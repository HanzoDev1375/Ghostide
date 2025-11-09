package io.github.rosemoe.sora.langs.cpp;

/*
 *    sora-editor - the awesome code editor for Android
 *    ///
 *    Copyright (C) 2020-2021  Rosemoe
 *
 *     This library is free software; you can redistribute it and/or
 *     modify it under the terms of the GNU Lesser General Public
 *     License as published by the Free Software Foundation; either
 *     version 2.1 of the License, or (at your option) any later version.
 *
 *     This library is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *     Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public
 *     License along with this library; if not, write to the Free Software
 *     Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301
 *     USA
 *
 *     Please contact Rosemoe by email 2073412493@qq.com if you need
 *     additional information or have any questions
 */

/**
 * Tokens for C++
 *
 * @author Rose
 */
@SuppressWarnings("SpellCheckingInspection")
public enum Tokens {
    WHITESPACE,
    NEWLINE,
    UNKNOWN,
    EOF,

    // Comment types
    LONG_COMMENT,
    LINE_COMMENT,

    DIV, // Divide
    MULT, // Multiply
    IDENTIFIER, // Identifier
    INTEGER_LITERAL, // Integer
    DOT, // Dot
    MINUS, // Minus
    STRING_LITERAL, // String
    CHARACTER_LITERAL, // Character
    LPAREN, // Left parenthesis
    RPAREN, // Right parenthesis
    LBRACE, // Left brace
    RBRACE, // Right brace
    LBRACK, // Left bracket
    RBRACK, // Right bracket
    SEMICOLON, // Semicolon
    COMMA, // Comma
    EQ, // Equals
    GT, // Greater than
    LT, // Less than
    NOT, // Not
    AT,
    COMP, // ~
    QUESTION, // Question
    COLON, // Colon
    AND, // And
    OR, // Or
    PLUS, // Plus
    XOR, // XOR
    MOD, // Modulo
    DIVEQ, // Divide and assign
    MULTEQ, // Multiply and assign
    FLOATING_POINT_LITERAL, // Float
    MINUSMINUS, // Decrement
    MINUSEQ, // Minus and assign
    EQEQ, // Equals equals
    GTEQ, // Greater than equal to
    RSHIFT, // Right shift
    LTEQ, // Less than equal to
    LSHIFT, // Left shift
    NOTEQ, // Not equal to
    ANDEQ, // And and assign
    ANDAND, // And and and
    OREQ, // Or and assign
    OROR, // Or or
    PLUSEQ, // Plus and assign
    PLUSPLUS, // Increment
    XOREQ, // XOR and assign
    MODEQ, // Modulo and assign
    RSHIFTEQ, // Right shift and assign
    URSHIFT, // Unsigned right shift
    LSHIFTEQ, // Left shift and assign
    URSHIFTEQ, // Unsigned right shift and assign
    DOUBLECASE,
    HASHCODE, // using (#)  ,
    // Keywords
    AUTO,
    BREAK,
    CASE,
    CHAR,
    CONST,
    CONTINUE,
    DEFAULT,
    DO,
    DOUBLE,
    ELSE,
    ENUM,
    EXPLICIT,
    EXTERN,
    FLOAT,
    FOR,
    FRIEND,
    GOTO,
    IF,
    INLINE,
    INT,
    LONG,
    MUTABLE,
    NAMESPACE,
    NEW,
    OPERATOR,
    PRIVATE,
    PROTECTED,
    PUBLIC,
    REGISTER,
    RETURN,
    SHORT,
    SIGNED,
    SIZEOF,
    STATIC,
    STRUCT,
    SWITCH,
    TEMPLATE,
    THIS,
    THROW,
    INLINE_THEN_CONSTEXPR,
    TRY,
    TYPEDEF,
    UNION,
    UNSIGNED,
    USING,
    VIRTUAL,
    VOID,
    VOLATILE,
    WCHAR_T,
    WHILE,
    BOOL,
    TRUE,
    FALSE,
    NULLPTR,
    ASSERT,
    ABSTRACT,
    INCLUDE,
    COUT,
    TEST,
    DEBUG,
    ERROR,
    LOG,
    TIP,
    WARNING
}
