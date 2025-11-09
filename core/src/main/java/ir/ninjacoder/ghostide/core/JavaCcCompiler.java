package ir.ninjacoder.ghostide.core;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import org.javacc.Version;
import org.javacc.parser.JavaCCErrors;
import org.javacc.parser.JavaCCGlobals;
import org.javacc.parser.JavaCCParser;
import org.javacc.parser.LexGen;
import org.javacc.parser.LexGenCPP;
import org.javacc.parser.MetaParseException;
import org.javacc.parser.NfaState;
import org.javacc.parser.Options;
import org.javacc.parser.OtherFilesGen;
import org.javacc.parser.OtherFilesGenCPP;
import org.javacc.parser.ParseException;
import org.javacc.parser.ParseGen;
import org.javacc.parser.ParseGenCPP;
import org.javacc.parser.Semanticize;
import org.javacc.utils.OptionInfo;
import org.javacc.utils.OptionType;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/** Entry point. */
public class JavaCcCompiler {
  protected JavaCcCompiler() {}

  public static LexGen lg;
  public static List<String> database = new ArrayList<>();
  

  static void help_message() {

    System.out.println("Usage:");
    System.out.println("    javacc option-settings inputfile");
    System.out.println("");
    System.out.println("\"option-settings\" is a sequence of settings separated by spaces.");
    System.out.println("Each option setting must be of one of the following forms:");
    System.out.println("");
    System.out.println("    -optionname=value (e.g., -STATIC=false)");
    System.out.println("    -optionname:value (e.g., -STATIC:false)");
    System.out.println("    -optionname       (equivalent to -optionname=true.  e.g., -STATIC)");
    System.out.println("    -NOoptionname     (equivalent to -optionname=false. e.g., -NOSTATIC)");
    System.out.println("");
    System.out.println(
        "Option settings are not case-sensitive, so one can say \"-nOsTaTiC\" instead");
    System.out.println(
        "of \"-NOSTATIC\".  Option values must be appropriate for the corresponding");
    System.out.println("option, and must be either an integer, a boolean, or a string value.");
    System.out.println("");

    // 2013/07/23 -- Changed this to auto-generate from metadata in Options so that help is always
    // in-sync with codebase
    printOptions();

    System.out.println("EXAMPLE:");
    System.out.println("    javacc -STATIC=false -LOOKAHEAD:2 -debug_parser mygrammar.jj");
    System.out.println("");
  }

  private static void printOptions() {

    Set<OptionInfo> options = Options.getUserOptions();

    int maxLengthInt = 0;
    int maxLengthBool = 0;
    int maxLengthString = 0;

    for (OptionInfo i : options) {
      int length = i.getName().length();

      if (i.getType() == OptionType.INTEGER) {
        maxLengthInt = length > maxLengthInt ? length : maxLengthInt;
      } else if (i.getType() == OptionType.BOOLEAN) {
        maxLengthBool = length > maxLengthBool ? length : maxLengthBool;

      } else if (i.getType() == OptionType.STRING) {
        maxLengthString = length > maxLengthString ? length : maxLengthString;

      } else {
        // Not interested
      }
    }

    if (maxLengthInt > 0) {
      System.out.println("The integer valued options are:");
      System.out.println("");
      for (OptionInfo i : options) {
        printOptionInfo(OptionType.INTEGER, i, maxLengthInt);
      }
      System.out.println("");
    }

    if (maxLengthBool > 0) {
      System.out.println("The boolean valued options are:");
      System.out.println("");
      for (OptionInfo i : options) {
        printOptionInfo(OptionType.BOOLEAN, i, maxLengthBool);
      }
      System.out.println("");
    }

    if (maxLengthString > 0) {
      System.out.println("The string valued options are:");
      System.out.println("");
      for (OptionInfo i : options) {
        printOptionInfo(OptionType.STRING, i, maxLengthString);
      }
      System.out.println("");
    }
  }

  private static void printOptionInfo(OptionType filter, OptionInfo optionInfo, int padLength) {
    if (optionInfo.getType() == filter) {
      Object default1 = optionInfo.getDefault();
      System.out.println(
          "    "
              + padRight(optionInfo.getName(), padLength + 1)
              + (default1 == null
                  ? ""
                  : ("(default : "
                      + (default1.toString().length() == 0 ? "<<empty>>" : default1)
                      + ")")));
    }
  }

  private static String padRight(String name, int maxLengthInt) {
    int nameLength = name.length();
    if (nameLength == maxLengthInt) {
      return name;
    } else {
      int charsToPad = maxLengthInt - nameLength;
      StringBuilder sb = new StringBuilder(charsToPad);
      sb.append(name);

      for (int i = 0; i < charsToPad; i++) {
        sb.append(" ");
      }

      return sb.toString();
    }
  }

  /** A main program that exercises the parser. */
  public static void main(String args[], Context c) throws Exception {
    int errorcode = mainProgram(args,c);
    // dont call System.exit for android port
    // System.exit(errorcode);
    Toast.makeText(c, String.valueOf(errorcode), 2).show();
  }

  /**
   * The method to call to exercise the parser from other Java programs. It returns an error code.
   * See how the main program above uses this method.
   */
  public static int mainProgram(String args[],Context c) throws Exception {

    if (args.length == 1 && args[args.length - 1].equalsIgnoreCase("-version")) {
      System.out.println(Version.versionNumber);
      return 0;
    }

    // Initialize all static state
    reInitAll();

    JavaCCGlobals.bannerLine("Parser Generator", "");

    JavaCCParser parser = null;
    if (args.length == 0) {
      System.out.println("");
      help_message();
      return 1;
    } else {
      toast("(type \"javacc\" with no arguments for help)",c);
    }

    if (Options.isOption(args[args.length - 1])) {
      toast("Last argument \"" + args[args.length - 1] + "\" is not a filename.",c);
      return 1;
    }
    for (int arg = 0; arg < args.length - 1; arg++) {
      if (!Options.isOption(args[arg])) {
        toast("Argument \"" + args[arg] + "\" must be an option setting.",c);
        return 1;
      }
      Options.setCmdLineOption(args[arg]);
    }

    try {
      java.io.File fp = new java.io.File(args[args.length - 1]);
      if (!fp.exists()) {
        toast("File " + args[args.length - 1] + " not found.",c);
        return 1;
      }
      if (fp.isDirectory()) {
        toast(
            args[args.length - 1] + " is a directory. Please use a valid file name.",c);
        return 1;
      }
      parser =
          new JavaCCParser(
              new java.io.BufferedReader(
                  new java.io.InputStreamReader(
                      new java.io.FileInputStream(args[args.length - 1]),
                      Options.getGrammarEncoding())));
    } catch (SecurityException se) {
      toast("Security violation while trying to open " + args[args.length - 1],c);
      return 1;
    } catch (java.io.FileNotFoundException e) {
      toast("File " + args[args.length - 1] + " not found.",c);
      return 1;
    }

    try {
      toast("Reading from file " + args[args.length - 1] + " . . .",c);
      JavaCCGlobals.fileName = JavaCCGlobals.origFileName = args[args.length - 1];
      JavaCCGlobals.jjtreeGenerated = JavaCCGlobals.isGeneratedBy("JJTree", args[args.length - 1]);
      JavaCCGlobals.toolNames = JavaCCGlobals.getToolNames(args[args.length - 1]);
      parser.javacc_input();

      // 2012/05/02 - Moved this here as cannot evaluate output language
      // until the cc file has been processed. Was previously setting the 'lg' variable
      // to a lexer before the configuration override in the cc file had been read.
      String outputLanguage = Options.getOutputLanguage();
      // TODO :: CBA --  Require Unification of output language specific processing into a single
      // Enum class
      boolean isJavaOutput = Options.isOutputLanguageJava();
      boolean isCPPOutput = true;//outputLanguage.equals(Options.OUTPUT_LANGUAGE__CPP);

      // 2013/07/22 Java Modern is a
      boolean isJavaModern =
          isJavaOutput && Options.getJavaTemplateType().equals(Options.JAVA_TEMPLATE_TYPE_MODERN);

      if (isJavaOutput) {
        lg = new LexGen();
      } else if (isCPPOutput) {
        lg = new LexGenCPP();
      } else {
        return unhandledLanguageExit(outputLanguage);
      }

      JavaCCGlobals.createOutputDir(Options.getOutputDirectory());

      if (Options.getUnicodeInput()) {
        NfaState.unicodeWarningGiven = true;
        System.out.println(
            "Note: UNICODE_INPUT option is specified. "
                + "Please make sure you create the parser/lexer using a Reader with the correct character encoding.");
      }

      Semanticize.start();
      boolean isBuildParser = Options.getBuildParser();
      if (isJavaOutput) {
        if (isBuildParser) {
          new ParseGen().start(isJavaModern);
        }
        new LexGen().start();

        Options.setStringOption(Options.NONUSER_OPTION__PARSER_NAME, JavaCCGlobals.cu_name);
        OtherFilesGen.start(isJavaModern);
      } else if (isCPPOutput) { // C++ for now
        if (isBuildParser) {
          new ParseGenCPP().start();
        }
        if (isBuildParser) {
          new LexGenCPP().start();
        }
        Options.setStringOption(Options.NONUSER_OPTION__PARSER_NAME, JavaCCGlobals.cu_name);
        OtherFilesGenCPP.start();
      } else {
        unhandledLanguageExit(outputLanguage);
      }

      if ((JavaCCErrors.get_error_count() == 0)
          && (isBuildParser || Options.getBuildTokenManager())) {
        if (JavaCCErrors.get_warning_count() == 0) {
          if (isBuildParser) {
            toast("Parser generated successfully.",c);
          }
        } else {
          toast(
              "Parser generated with 0 errors and "
                  + JavaCCErrors.get_warning_count()
                  + " warnings.",c);
        }
        return 0;
      } else {
        toast(
            "Detected "
                + JavaCCErrors.get_error_count()
                + " errors and "
                + JavaCCErrors.get_warning_count()
                + " warnings.",c);
        return (JavaCCErrors.get_error_count() == 0) ? 0 : 1;
      }
    } catch (MetaParseException e) {
      toast(
          "Detected "
              + JavaCCErrors.get_error_count()
              + " errors and "
              + JavaCCErrors.get_warning_count()
              + " warnings.",c);
      return 1;
    } catch (ParseException e) {
      System.out.println(e.toString());
      toast(
          "Detected "
              + (JavaCCErrors.get_error_count() + 1)
              + " errors and "
              + JavaCCErrors.get_warning_count()
              + " warnings.",c);
      return 1;
    }
  }

  private static int unhandledLanguageExit(String outputLanguage) {
    System.out.println(
        "Invalid '" + Options.USEROPTION__OUTPUT_LANGUAGE + "' specified : " + outputLanguage);
    return 1;
  }

  public static void reInitAll() {
    org.javacc.parser.Expansion.reInit();
    org.javacc.parser.JavaCCErrors.reInit();
    org.javacc.parser.JavaCCGlobals.reInit();
    Options.init();
    org.javacc.parser.JavaCCParserInternals.reInit();
    org.javacc.parser.RStringLiteral.reInit();
    org.javacc.parser.JavaFiles.reInit();
    org.javacc.parser.NfaState.reInit();
    org.javacc.parser.MatchInfo.reInit();
    org.javacc.parser.LookaheadWalk.reInit();
    org.javacc.parser.Semanticize.reInit();
    org.javacc.parser.OtherFilesGen.reInit();
    org.javacc.parser.LexGen.reInit();
  }

  static void toast(String msg, Context c) {
    Handler h = new Handler(Looper.getMainLooper());
    h.post(
        () -> {
          Toast.makeText(c, msg, 2).show();
        });
  }
}
