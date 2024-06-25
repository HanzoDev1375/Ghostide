package io.github.rosemoe.sora.langs.ninjalang;

public enum Tokens {
    /// Symbol
    WHITESPACE,
    NEWLINE,
    UNKNOWN,
    EOF,
    AT,
    // 注释类 Comments
    LONG_COMMENT, // 长注释 Long comment
    LINE_COMMENT, // 单行注释 Single line comment
    DIV, // 除
    MULT, // 乘
    IDENTIFIER, // 标识符
    INTEGER_LITERAL, // 整数
    DOT, // 点
    MINUS, // 减
    STRING, // 字符串
    CHARACTER_LITERAL, // 字符
    LPAREN, // 左小括号
    RPAREN, // 右小括号
    LBRACE, // 左大括号
    RBRACE, // 右大括号
    LBRACK, // 左中括号
    RBRACK, // 右中括号
    SEMICOLON, // 分号
    COMMA, // 逗号
    EQ, // 等于
    GT, // 大于
    LT, // 小于
    NOT, // 非
    COMP, // ~
    QUESTION, // 问号
    COLON, // 冒号
    AND, // 与
    OR, // 或
    PLUS, // 加
    XOR, // 异或
    MOD, // 百分号
    DIVEQ,
    MULTEQ,
    FLOATING_POINT_LITERAL, // 浮点数
    MINUSMINUS, // 减减
    MINUSEQ,
    EQEQ, // 等于等于
    GTEQ,
    RSHIFT, // 右位移
    LTEQ,
    LSHIFT, // 左位移
    NOTEQ,
    ANDEQ,
    ANDAND, // 与与
    OREQ,
    OROR, // 或或
    PLUSEQ,
    PLUSPLUS, // 加加
    XOREQ,
    MODEQ,
    RSHIFTEQ,
    URSHIFT,
    LSHIFTEQ,
    URSHIFTEQ,
    // KeyWord
    ABSOLUTE,
    ABSTRACT,
    ALL,
    AND_THEN,
    ARRAY,
    AS,
    ASM,
    ATTRIBUTE,
    BEGIN,
    BINDABLE,
    CASE,
    CLASS,
    CONST,
    CONSTRUCTOR,
    DESTRUCTOR,
    DO,
    ELSE,
    END,
    EXPORTS,
    EXTERNAL,
    FAR,
    FILE,
    FINALIZATION,
    FINALLY,
    FOR,
    FORWARD,
    GOTO,
    IF,
    IMPLEMENTATION,
    IN,
    INHERITED,
    INITIALIZATION,
    INTERFACE,
    INTERRUPT,
    IS,
    LABEL,
    LIBRARY,
    MODULE,
    NAME,
    NEAR,
    NIL,
    OBJECT,
    OF,
    ONLY,
    OPERATOR,
    OR_ELSE,
    OTHERWISE,
    PACKED,
    POW,
    PRIVATE,
    PROGRAM,
    PROPERTY,
    PROTECTED,
    PUBLIC,
    PUBLISHED,
    QUALIFIED,
    RECORD,
    REPEAT,
    RESIDENT,
    RESTRICTED,
    SEGMENT,
    SET,
    SHL,
    SHR,
    THEN,
    TO,
    TRY,
    TYPE,
    UNIT,
    UNTIL,
    USES,
    VALUE,
    VAR,
    VIEW,
    VIRTUAL,
    WHILE,
    WITH,
    MSG,
    PRAPERTY,
    EXEC,
    BASEEXCEPTION,
    FROM,
    SYSTEM,
    PRINTOR,
    OUT,
    CIN,
    COUT,
    LAMBDA,
    QAR,
    VEL,
    VAL,
    SYNCHRONIZED,
    INT32,
    INT64,
    EXTENDS,
    SEALED,
    TYPEVIEW,
    VOID,
    PERMITS,
    BRAKRTCOMPAT,
    ENDBRAKRTCOMPAT,
    IMPORT,
    EXPORT,
    EXCEPT
}
