package com.tyron.javacompletion;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.tyron.javacompletion.completion.CompletionResult;
import com.tyron.javacompletion.file.FileManager;
import com.tyron.javacompletion.file.FileManagerImpl;
import com.tyron.javacompletion.logging.JLogger;
import com.tyron.javacompletion.options.IndexOptions;
import com.tyron.javacompletion.options.JavaCompletionOptions;
import com.tyron.javacompletion.project.Project;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JavaCompletions {
  private static final JLogger logger = JLogger.createForEnclosingClass();

  private final ExecutorService mExecutor;

  private static final String notInit = "Not yet initialized.";

  public boolean mInitialized;
  private FileManager mFileManager;
  private Project mProject;

  public JavaCompletions() {
    mExecutor = Executors.newCachedThreadPool();
  }

  public synchronized void initialize(URI projectRootUri, JavaCompletionOptions options) {
    checkState(!mInitialized, "Already initialized.");
    mInitialized = true;

    List<String> ignorePaths;

    logger.info("Initializing project: %s", projectRootUri);
    logger.info(
        """
                        Options:
                          logPath: %s
                          logLevel: %s
                          ignorePaths: %s
                          typeIndexFiles: %s""",
        options.getLogPath(),
        options.getLogLevel(),
        options.getIgnorePaths(),
        options.getTypeIndexFiles());
    if (options.getLogPath() != null) {
      JLogger.setLogFile(options.getLogPath());
    }
    if (options.getIgnorePaths() != null) {
      ignorePaths = options.getIgnorePaths();
    } else {
      ignorePaths = List.of();
    }
    mFileManager = new FileManagerImpl(projectRootUri, ignorePaths, mExecutor);
    mProject = new Project(mFileManager, projectRootUri, IndexOptions.FULL_INDEX_BUILDER.build());
    mExecutor.submit(
        () -> {
          synchronized (JavaCompletions.this) {
            mProject.initialize();
            mProject.loadJdkModule();
            if (options.getTypeIndexFiles() != null) {
              for (String typeIndexFile : options.getTypeIndexFiles()) {
                mProject.loadTypeIndexFile(typeIndexFile);
              }
            }
          }
        });
  }

  public synchronized void shutdown() {
    checkState(mInitialized, "shutdown() called without being initialized.");
    mInitialized = false;
    mExecutor.shutdown();
    mFileManager.shutdown();
  }

  public synchronized Project getProject() {
    checkState(mInitialized, notInit);
    return checkNotNull(mProject);
  }

  /**
   * Used to inform the infrastructure that the contents of the file has been changed. Useful if
   * code editors are not writing the changes to file immediately
   */
  public synchronized void updateFileContent(Path file, String newContent) {
    checkState(mInitialized, notInit);
    mFileManager.setSnaphotContent(file.toUri(), newContent);
  }

  public synchronized void openFile(Path file, String content) {
    try {
      checkState(mInitialized, notInit);
      mFileManager.openFileForSnapshot(file.toUri(), content);
    } catch (Exception err) {
      logger.warning(err.getLocalizedMessage());
    }
  }

  /**
   * Retrieves completions with the file content
   *
   * @param file Path of file to complete
   * @param line 0 based line of the caret
   * @param column 0 based column of the caret
   */
  public synchronized CompletionResult getCompletions(Path file, int line, int column) {
    checkState(mInitialized, notInit);
    return mProject.getCompletionResult(file, line, column);
  }
}
