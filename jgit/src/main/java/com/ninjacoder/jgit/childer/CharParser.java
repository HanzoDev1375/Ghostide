package com.ninjacoder.jgit.childer;

public class CharParser {
  public static boolean parserChar(char ch) {
    return ch == '('
        || ch == ')'
        || ch == '<'
        || ch == '>'
        || ch == '+'
        || ch == '/'
        || ch == '-'
        || ch == '+'
		|| ch == '*'
        || ch == '#'
        || ch == '='
        || ch == ':'
        || ch == '.'
        || Character.isJavaIdentifierPart(ch)
        || Character.isDigit(ch)
        || Character.isLetter(ch);
  }
}
