package com.ninjacoder.jgit.pythonformatter;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class PyFormatter {
  public static String format(String code) {
    try {
      CharStream charStream = CharStreams.fromString(code);
      PythonLexer lexer = new PythonLexer(charStream);
      CommonTokenStream tokens = new CommonTokenStream(lexer);
      PythonParser parser = new PythonParser(tokens);
      ThrowableErrorListener errorListener = new ThrowableErrorListener();
      parser.removeErrorListeners();
      parser.addErrorListener(errorListener);
      ParseTree tree = parser.file_input();
      PythonVisitor visitor = new PythonVisitor(tokens);
      String result = visitor.visit(tree);
      return result;
    } catch (Exception err) {
      return code;
    }
  }
}
