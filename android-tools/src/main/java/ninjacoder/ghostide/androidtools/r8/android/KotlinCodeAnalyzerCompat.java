package ninjacoder.ghostide.androidtools.r8.android;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSeverity;
import org.jetbrains.kotlin.cli.common.messages.CompilerMessageSourceLocation;
import org.jetbrains.kotlin.cli.common.messages.MessageCollector;
import org.jetbrains.kotlin.cli.jvm.K2JVMCompiler;
import org.jetbrains.kotlin.cli.common.arguments.K2JVMCompilerArguments;
import org.jetbrains.kotlin.config.Services;
import org.jetbrains.kotlin.cli.common.ExitCode;
import java.util.ArrayList;
import java.util.List;

public class KotlinCodeAnalyzerCompat {
  private final String kotlinCode;
  private final String[] classpath = {
    "kotlin-stdlib-1.8.0-RC.jar",
    "kotlin-stdlib-common-1.8.0-RC.jar",
    "kotlinx-coroutines-core-jvm-1.6.4.jar"
  };

  public KotlinCodeAnalyzerCompat(String kotlinCode) {
    this.kotlinCode = kotlinCode;
  }

  public AnalysisResult analyze() {
    // Create a temporary file for the Kotlin code
    File tempFile = createTempFile(kotlinCode);
    if (tempFile == null) {
      return new AnalysisResult(false, "Failed to create temporary file");
    }

    // Set up compiler arguments
    K2JVMCompilerArguments args = new K2JVMCompilerArguments();
    args.setCompileJava(false);
    args.setIncludeRuntime(false);
    args.setNoJdk(false);
    args.setNoReflect(false);
    args.setNoStdlib(false);

    // Add classpath if provided
    if (classpath != null && classpath.length > 0) {
      args.setClasspath(String.join(":", classpath));
    }

    // Add the temporary file to compile

    args.setFreeArgs(Arrays.asList(new String[] {tempFile.getAbsolutePath()}));

    // Create a custom message collector
    AnalysisMessageCollector collector = new AnalysisMessageCollector();

    // Run the compiler
    K2JVMCompiler compiler = new K2JVMCompiler();
    ExitCode exitCode = compiler.exec(collector, Services.EMPTY, args);

    // Clean up the temporary file
    tempFile.delete();

    return new AnalysisResult(
        exitCode == ExitCode.OK && !collector.hasErrors(), collector.getMessages());
  }

  private File createTempFile(String content) {
    try {
      File tempFile = File.createTempFile("Main", ".kt");
      try (FileOutputStream fos = new FileOutputStream(tempFile)) {
        fos.write(content.getBytes());
      }
      return tempFile;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  public static class AnalysisResult {
    private final boolean success;
    private final List<AnalysisMessage> messages;

    public AnalysisResult(boolean success, String error) {
      this.success = success;
      this.messages = new ArrayList<>();
      if (error != null) {
        this.messages.add(new AnalysisMessage(CompilerMessageSeverity.ERROR, error, null));
      }
    }

    public AnalysisResult(boolean success, List<AnalysisMessage> messages) {
      this.success = success;
      this.messages = messages;
    }

    public boolean isSuccess() {
      return success;
    }

    public List<AnalysisMessage> getMessages() {
      return messages;
    }

    public List<AnalysisMessage> getWarnings() {
      return messages.stream()
          .filter(m -> m.getSeverity() == CompilerMessageSeverity.WARNING)
          .collect(Collectors.toList());
    }

    public List<AnalysisMessage> getErrors() {
      return messages.stream().filter(m -> m.getSeverity().isError()).collect(Collectors.toList());
    }

    public boolean hasWarnings() {
      return messages.stream().anyMatch(m -> m.getSeverity() == CompilerMessageSeverity.WARNING);
    }

    public boolean hasErrors() {
      return messages.stream().anyMatch(m -> m.getSeverity().isError());
    }

    public int getStartLineError() {
      return getErrors().stream().findFirst().map(msg -> msg.getLocation().getLine()).orElse(1);
    }

    public int getEndLineError() {
      return getErrors().stream().findFirst().map(msg -> msg.getLocation().getLineEnd()).orElse(1);
    }

    public int getStartColErrors() {
      return getErrors().stream().findFirst().map(msg -> msg.getLocation().getColumn()).orElse(1);
    }

    public int getEndColErrors() {
      return getErrors().stream()
          .findFirst()
          .map(msg -> msg.getLocation().getColumnEnd())
          .orElse(0);
    }

    public int getStartLineWar() {
      return getWarnings().stream().findFirst().map(msg -> msg.getLocation().getLine()).orElse(1);
    }

    public int getEndLineWar() {
      return getWarnings().stream()
          .findFirst()
          .map(msg -> msg.getLocation().getLineEnd())
          .orElse(1);
    }

    public int getStartColWar() {
      return getWarnings().stream().findFirst().map(msg -> msg.getLocation().getColumn()).orElse(1);
    }

    public int getEndColWar() {
      return getWarnings().stream()
          .findFirst()
          .map(msg -> msg.getLocation().getColumnEnd())
          .orElse(1);
    }
  }

  public static class AnalysisMessage {
    private final CompilerMessageSeverity severity;
    private final String message;
    private final CompilerMessageSourceLocation location;

    public AnalysisMessage(
        CompilerMessageSeverity severity, String message, CompilerMessageSourceLocation location) {
      this.severity = severity;
      this.message = message;
      this.location = location;
    }

    // Getters
    public CompilerMessageSeverity getSeverity() {
      return severity;
    }

    public String getMessage() {
      return message;
    }

    public CompilerMessageSourceLocation getLocation() {
      return location;
    }
  }

  private static class AnalysisMessageCollector implements MessageCollector {
    private final List<AnalysisMessage> messages = new ArrayList<>();

    @Override
    public void clear() {
      messages.clear();
    }

    @Override
    public boolean hasErrors() {
      return messages.stream().anyMatch(m -> m.getSeverity().isError());
    }

    @Override
    public void report(
        CompilerMessageSeverity severity, String message, CompilerMessageSourceLocation location) {
      messages.add(new AnalysisMessage(severity, message, location));
    }

    public List<AnalysisMessage> getMessages() {
      return new ArrayList<>(messages);
    }
  }
}
