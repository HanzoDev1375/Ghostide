/*
 * Antlr4Formatter Copyright 2015, khubla.com
 *
 *   This program is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *    This program is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *    GNU General Public License for more details.
 *
 *    You should have received a copy of the GNU General Public License
 *    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package com.khubla.antlr4formatter;

import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

import org.antlr.parser.antlr4.*;
import org.antlr.parser.antlr4.ANTLRv4Parser.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import com.khubla.antlr4formatter.listener.*;

/**
 * @author Tom Everett
 */
public class Antlr4Formatter {

  public static String format(String string) throws Antlr4FormatterException {
    try {
      if (null != string) {
        final StringWriter writer = new StringWriter();
        final CodePointCharStream input = CharStreams.fromString(string);
        formatGrammar(input, writer);
        return writer.toString();
      } else {
        return "";
      }
    } catch (final Exception e) {
      throw new Antlr4FormatterException("Exception reading and parsing file", e);
    }
  }

  private static void formatGrammar(CharStream input, Writer output) {
    final ANTLRv4Lexer lexer = new ANTLRv4Lexer(input);
    final CommonTokenStream commonTokenStream = new CommonTokenStream(lexer);
    final ANTLRv4Parser parser = new ANTLRv4Parser(commonTokenStream);
    final GrammarSpecContext grammarSpecContext = parser.grammarSpec();
    ParseTreeWalker.DEFAULT.walk(
        new FormatterParseTreeListenerImpl(
            new Antlr4FormatterListenerImpl(output), commonTokenStream),
        grammarSpecContext);
  }

  private Antlr4Formatter() {}
}
