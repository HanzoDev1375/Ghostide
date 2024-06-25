// Generated from java-escape by ANTLR 4.11.1
package io.github.rosemoe.sora.langs.php;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PhpParser extends Parser {
    public static final int
            SeaWhitespace = 1, HtmlText = 2, XmlStart = 3, PHPStart = 4, HtmlComment = 5, HtmlCommentOpen = 6,
            HtmlDtd = 7, HtmlOpen = 8, Shebang = 9, Error = 10, XmlText = 11, XmlClose = 12, PHPStartInside = 13,
            HtmlClose = 14, HtmlSlashClose = 15, HtmlSlash = 16, HtmlEquals = 17, HtmlStartQuoteString = 18,
            HtmlStartDoubleQuoteString = 19, HtmlHex = 20, HtmlDecimal = 21, HtmlSpace = 22,
            HtmlName = 23, ErrorInside = 24, PHPStartInsideQuoteString = 25, HtmlEndQuoteString = 26,
            HtmlQuoteString = 27, ErrorHtmlQuote = 28, PHPStartDoubleQuoteString = 29, HtmlEndDoubleQuoteString = 30,
            HtmlDoubleQuoteString = 31, ErrorHtmlDoubleQuote = 32, PHPStartInsideScript = 33,
            PHPEnd = 34, Whitespace = 35, MultiLineComment = 36, MultiLineCommentOpen = 37,
            SingleLineComment = 38, ShellStyleComment = 39, AttributeStart = 40, Abstract = 41,
            Array = 42, As = 43, BinaryCast = 44, BoolType = 45, BooleanConstant = 46, Break = 47,
            Callable = 48, Case = 49, Catch = 50, Class = 51, Clone = 52, Const = 53, Continue = 54,
            Declare = 55, Default = 56, Do = 57, DoubleCast = 58, DoubleType = 59, Echo = 60,
            Else = 61, ElseIf = 62, Empty = 63, EndDeclare = 64, EndFor = 65, EndForeach = 66,
            EndIf = 67, EndSwitch = 68, EndWhile = 69, Eval = 70, Exit = 71, Extends = 72, Final = 73,
            Finally = 74, FloatCast = 75, For = 76, Foreach = 77, Function_ = 78, Global = 79,
            Goto = 80, If = 81, Implements = 82, Import = 83, Include = 84, IncludeOnce = 85,
            InstanceOf = 86, InsteadOf = 87, Int8Cast = 88, Int16Cast = 89, Int64Type = 90,
            IntType = 91, Interface = 92, IsSet = 93, List = 94, LogicalAnd = 95, LogicalOr = 96,
            LogicalXor = 97, Match_ = 98, Namespace = 99, New = 100, Null = 101, ObjectType = 102,
            Parent_ = 103, Partial = 104, Print = 105, Private = 106, Protected = 107, Public = 108,
            Require = 109, RequireOnce = 110, Resource = 111, Return = 112, Static = 113, StringType = 114,
            Switch = 115, Throw = 116, Trait = 117, Try = 118, Typeof = 119, UintCast = 120, UnicodeCast = 121,
            Unset = 122, Use = 123, Var = 124, While = 125, Yield = 126, From = 127, LambdaFn = 128,
            Get = 129, Set = 130, Call = 131, CallStatic = 132, Constructor = 133, Destruct = 134,
            Wakeup = 135, Sleep = 136, Autoload = 137, IsSet__ = 138, Unset__ = 139, ToString__ = 140,
            Invoke = 141, SetState = 142, Clone__ = 143, DebugInfo = 144, Namespace__ = 145,
            Class__ = 146, Traic__ = 147, Function__ = 148, Method__ = 149, Line__ = 150, File__ = 151,
            Dir__ = 152, Spaceship = 153, Lgeneric = 154, Rgeneric = 155, DoubleArrow = 156,
            Inc = 157, Dec = 158, IsIdentical = 159, IsNoidentical = 160, IsEqual = 161, IsNotEq = 162,
            IsSmallerOrEqual = 163, IsGreaterOrEqual = 164, PlusEqual = 165, MinusEqual = 166,
            MulEqual = 167, Pow = 168, PowEqual = 169, DivEqual = 170, Concaequal = 171, ModEqual = 172,
            ShiftLeftEqual = 173, ShiftRightEqual = 174, AndEqual = 175, OrEqual = 176, XorEqual = 177,
            BooleanOr = 178, BooleanAnd = 179, NullCoalescing = 180, NullCoalescingEqual = 181,
            ShiftLeft = 182, ShiftRight = 183, DoubleColon = 184, ObjectOperator = 185, NamespaceSeparator = 186,
            Ellipsis = 187, Less = 188, Greater = 189, Ampersand = 190, Pipe = 191, Bang = 192,
            Caret = 193, Plus = 194, Minus = 195, Asterisk = 196, Percent = 197, Divide = 198,
            Tilde = 199, SuppressWarnings = 200, Dollar = 201, Dot = 202, QuestionMark = 203,
            OpenRoundBracket = 204, CloseRoundBracket = 205, OpenSquareBracket = 206, CloseSquareBracket = 207,
            OpenCurlyBracket = 208, CloseCurlyBracket = 209, Comma = 210, Colon = 211, SemiColon = 212,
            Eq = 213, Quote = 214, BackQuote = 215, VarName = 216, Label = 217, Octal = 218, Decimal = 219,
            Real = 220, Hex = 221, Binary = 222, BackQuoteString = 223, SingleQuoteString = 224,
            DoubleQuote = 225, StartNowDoc = 226, StartHereDoc = 227, ErrorPhp = 228, CurlyDollar = 229,
            UnicodeEscape = 230, StringPart = 231, Comment = 232, PHPEndSingleLineComment = 233,
            CommentEnd = 234, HereDocText = 235, XmlText2 = 236;
    public static final int
            RULE_htmlDocument = 0, RULE_inlineHtml = 1, RULE_htmlElement = 2, RULE_phpBlock = 3,
            RULE_importStatement = 4, RULE_topStatement = 5, RULE_useDeclaration = 6,
            RULE_useDeclarationContentList = 7, RULE_useDeclarationContent = 8, RULE_namespaceDeclaration = 9,
            RULE_namespaceStatement = 10, RULE_functionDeclaration = 11, RULE_classDeclaration = 12,
            RULE_classEntryType = 13, RULE_interfaceList = 14, RULE_typeParameterListInBrackets = 15,
            RULE_typeParameterList = 16, RULE_typeParameterWithDefaultsList = 17,
            RULE_typeParameterDecl = 18, RULE_typeParameterWithDefaultDecl = 19, RULE_genericDynamicArgs = 20,
            RULE_attributes = 21, RULE_attributeGroup = 22, RULE_attribute = 23, RULE_innerStatementList = 24,
            RULE_innerStatement = 25, RULE_statement = 26, RULE_emptyStatement_ = 27,
            RULE_blockStatement = 28, RULE_ifStatement = 29, RULE_elseIfStatement = 30,
            RULE_elseIfColonStatement = 31, RULE_elseStatement = 32, RULE_elseColonStatement = 33,
            RULE_whileStatement = 34, RULE_doWhileStatement = 35, RULE_forStatement = 36,
            RULE_forInit = 37, RULE_forUpdate = 38, RULE_switchStatement = 39, RULE_switchBlock = 40,
            RULE_breakStatement = 41, RULE_continueStatement = 42, RULE_returnStatement = 43,
            RULE_expressionStatement = 44, RULE_unsetStatement = 45, RULE_foreachStatement = 46,
            RULE_tryCatchFinally = 47, RULE_catchClause = 48, RULE_finallyStatement = 49,
            RULE_throwStatement = 50, RULE_gotoStatement = 51, RULE_declareStatement = 52,
            RULE_inlineHtmlStatement = 53, RULE_declareList = 54, RULE_formalParameterList = 55,
            RULE_formalParameter = 56, RULE_typeHint = 57, RULE_globalStatement = 58,
            RULE_globalVar = 59, RULE_echoStatement = 60, RULE_staticVariableStatement = 61,
            RULE_classStatement = 62, RULE_traitAdaptations = 63, RULE_traitAdaptationStatement = 64,
            RULE_traitPrecedence = 65, RULE_traitAlias = 66, RULE_traitMethodReference = 67,
            RULE_baseCtorCall = 68, RULE_methodBody = 69, RULE_propertyModifiers = 70,
            RULE_memberModifiers = 71, RULE_variableInitializer = 72, RULE_identifierInitializer = 73,
            RULE_globalConstantDeclaration = 74, RULE_expressionList = 75, RULE_parentheses = 76,
            RULE_expression = 77, RULE_assignable = 78, RULE_arrayCreation = 79, RULE_lambdaFunctionExpr = 80,
            RULE_matchExpr = 81, RULE_matchItem = 82, RULE_newExpr = 83, RULE_assignmentOperator = 84,
            RULE_yieldExpression = 85, RULE_arrayItemList = 86, RULE_arrayItem = 87,
            RULE_lambdaFunctionUseVars = 88, RULE_lambdaFunctionUseVar = 89, RULE_qualifiedStaticTypeRef = 90,
            RULE_typeRef = 91, RULE_anonymousClass = 92, RULE_indirectTypeRef = 93,
            RULE_qualifiedNamespaceName = 94, RULE_namespaceNameList = 95, RULE_namespaceNameTail = 96,
            RULE_qualifiedNamespaceNameList = 97, RULE_arguments = 98, RULE_actualArgument = 99,
            RULE_argumentName = 100, RULE_constantInitializer = 101, RULE_constant = 102,
            RULE_literalConstant = 103, RULE_numericConstant = 104, RULE_classConstant = 105,
            RULE_stringConstant = 106, RULE_string = 107, RULE_interpolatedStringPart = 108,
            RULE_chainList = 109, RULE_chain = 110, RULE_chainOrigin = 111, RULE_memberAccess = 112,
            RULE_functionCall = 113, RULE_functionCallName = 114, RULE_actualArguments = 115,
            RULE_chainBase = 116, RULE_keyedFieldName = 117, RULE_keyedSimpleFieldName = 118,
            RULE_keyedVariable = 119, RULE_squareCurlyExpression = 120, RULE_assignmentList = 121,
            RULE_assignmentListElement = 122, RULE_modifier = 123, RULE_identifier = 124,
            RULE_memberModifier = 125, RULE_magicConstant = 126, RULE_magicMethod = 127,
            RULE_primitiveType = 128, RULE_castOperation = 129;
    public static final String[] ruleNames = makeRuleNames();
    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;
    public static final String _serializedATN =
            "\u0004\u0001\u00ec\u06e5\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001" +
                    "\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004" +
                    "\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007" +
                    "\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b" +
                    "\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007" +
                    "\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007" +
                    "\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007" +
                    "\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007" +
                    "\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007" +
                    "\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007" +
                    "\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007" +
                    "\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007" +
                    "\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007" +
                    ",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007" +
                    "1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007" +
                    "6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007" +
                    ";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007" +
                    "@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007" +
                    "E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007" +
                    "J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007" +
                    "O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007" +
                    "T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007" +
                    "Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007" +
                    "^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007" +
                    "c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007" +
                    "h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007" +
                    "m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007" +
                    "r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007" +
                    "w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007" +
                    "|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007" +
                    "\u0080\u0002\u0081\u0007\u0081\u0001\u0000\u0003\u0000\u0106\b\u0000\u0001" +
                    "\u0000\u0001\u0000\u0005\u0000\u010a\b\u0000\n\u0000\f\u0000\u010d\t\u0000" +
                    "\u0001\u0000\u0001\u0000\u0001\u0001\u0004\u0001\u0112\b\u0001\u000b\u0001" +
                    "\f\u0001\u0113\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002" +
                    "\u0001\u0002\u0005\u0002\u0128\b\u0002\n\u0002\f\u0002\u012b\t\u0002\u0001" +
                    "\u0002\u0003\u0002\u012e\b\u0002\u0001\u0003\u0005\u0003\u0131\b\u0003" +
                    "\n\u0003\f\u0003\u0134\t\u0003\u0001\u0003\u0004\u0003\u0137\b\u0003\u000b" +
                    "\u0003\f\u0003\u0138\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001" +
                    "\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001" +
                    "\u0005\u0003\u0005\u0146\b\u0005\u0001\u0006\u0001\u0006\u0003\u0006\u014a" +
                    "\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0003\u0007\u0150" +
                    "\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0155\b\u0007" +
                    "\u0001\u0007\u0005\u0007\u0158\b\u0007\n\u0007\f\u0007\u015b\t\u0007\u0001" +
                    "\b\u0001\b\u0001\t\u0001\t\u0003\t\u0161\b\t\u0001\t\u0001\t\u0005\t\u0165" +
                    "\b\t\n\t\f\t\u0168\t\t\u0001\t\u0001\t\u0001\t\u0001\t\u0003\t\u016e\b" +
                    "\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0175\b\n\u0001\u000b" +
                    "\u0003\u000b\u0178\b\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u017c\b" +
                    "\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0180\b\u000b\u0001\u000b\u0001" +
                    "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0187\b\u000b\u0001" +
                    "\u000b\u0003\u000b\u018a\b\u000b\u0001\u000b\u0001\u000b\u0001\f\u0003" +
                    "\f\u018f\b\f\u0001\f\u0003\f\u0192\b\f\u0001\f\u0003\f\u0195\b\f\u0001" +
                    "\f\u0003\f\u0198\b\f\u0001\f\u0001\f\u0001\f\u0003\f\u019d\b\f\u0001\f" +
                    "\u0001\f\u0003\f\u01a1\b\f\u0001\f\u0001\f\u0003\f\u01a5\b\f\u0001\f\u0001" +
                    "\f\u0001\f\u0003\f\u01aa\b\f\u0001\f\u0001\f\u0003\f\u01ae\b\f\u0003\f" +
                    "\u01b0\b\f\u0001\f\u0001\f\u0005\f\u01b4\b\f\n\f\f\f\u01b7\t\f\u0001\f" +
                    "\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e" +
                    "\u01c0\b\u000e\n\u000e\f\u000e\u01c3\t\u000e\u0001\u000f\u0001\u000f\u0001" +
                    "\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001" +
                    "\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0003" +
                    "\u000f\u01d3\b\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0005\u0010\u01d8" +
                    "\b\u0010\n\u0010\f\u0010\u01db\t\u0010\u0001\u0011\u0001\u0011\u0001\u0011" +
                    "\u0005\u0011\u01e0\b\u0011\n\u0011\f\u0011\u01e3\t\u0011\u0001\u0012\u0003" +
                    "\u0012\u01e6\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0003\u0013\u01eb" +
                    "\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u01f1" +
                    "\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0005\u0014\u01f7" +
                    "\b\u0014\n\u0014\f\u0014\u01fa\t\u0014\u0001\u0014\u0001\u0014\u0001\u0015" +
                    "\u0004\u0015\u01ff\b\u0015\u000b\u0015\f\u0015\u0200\u0001\u0016\u0001" +
                    "\u0016\u0001\u0016\u0001\u0016\u0003\u0016\u0207\b\u0016\u0001\u0016\u0001" +
                    "\u0016\u0001\u0016\u0005\u0016\u020c\b\u0016\n\u0016\f\u0016\u020f\t\u0016" +
                    "\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0003\u0017\u0215\b\u0017" +
                    "\u0001\u0018\u0005\u0018\u0218\b\u0018\n\u0018\f\u0018\u021b\t\u0018\u0001" +
                    "\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u0220\b\u0019\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001" +
                    "\u001a\u0001\u001a\u0003\u001a\u023d\b\u001a\u0001\u001b\u0001\u001b\u0001" +
                    "\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001" +
                    "\u001d\u0001\u001d\u0005\u001d\u0249\b\u001d\n\u001d\f\u001d\u024c\t\u001d" +
                    "\u0001\u001d\u0003\u001d\u024f\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0001\u001d\u0005\u001d\u0256\b\u001d\n\u001d\f\u001d\u0259" +
                    "\t\u001d\u0001\u001d\u0003\u001d\u025c\b\u001d\u0001\u001d\u0001\u001d" +
                    "\u0001\u001d\u0003\u001d\u0261\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e" +
                    "\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f" +
                    "\u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001" +
                    "\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u027b\b\"\u0001#\u0001" +
                    "#\u0001#\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0003$\u0286\b$\u0001" +
                    "$\u0001$\u0003$\u028a\b$\u0001$\u0001$\u0003$\u028e\b$\u0001$\u0001$\u0001" +
                    "$\u0001$\u0001$\u0001$\u0001$\u0003$\u0297\b$\u0001%\u0001%\u0001&\u0001" +
                    "&\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u02a1\b\'\u0001\'\u0005\'\u02a4" +
                    "\b\'\n\'\f\'\u02a7\t\'\u0001\'\u0001\'\u0001\'\u0003\'\u02ac\b\'\u0001" +
                    "\'\u0005\'\u02af\b\'\n\'\f\'\u02b2\t\'\u0001\'\u0001\'\u0003\'\u02b6\b" +
                    "\'\u0001(\u0001(\u0001(\u0003(\u02bb\b(\u0001(\u0004(\u02be\b(\u000b(" +
                    "\f(\u02bf\u0001(\u0001(\u0001)\u0001)\u0003)\u02c6\b)\u0001)\u0001)\u0001" +
                    "*\u0001*\u0003*\u02cc\b*\u0001*\u0001*\u0001+\u0001+\u0003+\u02d2\b+\u0001" +
                    "+\u0001+\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001-\u0001" +
                    "-\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u02e4\b.\u0001.\u0001.\u0001" +
                    ".\u0003.\u02e9\b.\u0001.\u0003.\u02ec\b.\u0001.\u0001.\u0001.\u0001.\u0001" +
                    ".\u0001.\u0001.\u0001.\u0003.\u02f6\b.\u0001.\u0003.\u02f9\b.\u0001.\u0001" +
                    ".\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0003" +
                    ".\u0306\b.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0003.\u030e\b.\u0001" +
                    "/\u0001/\u0001/\u0004/\u0313\b/\u000b/\f/\u0314\u0001/\u0003/\u0318\b" +
                    "/\u0001/\u0005/\u031b\b/\n/\f/\u031e\t/\u0001/\u0003/\u0321\b/\u00010" +
                    "\u00010\u00010\u00010\u00010\u00050\u0328\b0\n0\f0\u032b\t0\u00010\u0001" +
                    "0\u00010\u00010\u00011\u00011\u00011\u00012\u00012\u00012\u00012\u0001" +
                    "3\u00013\u00013\u00013\u00014\u00014\u00014\u00014\u00014\u00014\u0001" +
                    "4\u00014\u00014\u00014\u00034\u0346\b4\u00015\u00045\u0349\b5\u000b5\f" +
                    "5\u034a\u00016\u00016\u00016\u00056\u0350\b6\n6\f6\u0353\t6\u00017\u0003" +
                    "7\u0356\b7\u00017\u00017\u00057\u035a\b7\n7\f7\u035d\t7\u00017\u00037" +
                    "\u0360\b7\u00018\u00038\u0363\b8\u00018\u00038\u0366\b8\u00018\u00038" +
                    "\u0369\b8\u00018\u00038\u036c\b8\u00018\u00038\u036f\b8\u00018\u00038" +
                    "\u0372\b8\u00018\u00018\u00019\u00019\u00019\u00019\u00039\u037a\b9\u0001" +
                    "9\u00019\u00019\u00059\u037f\b9\n9\f9\u0382\t9\u0001:\u0001:\u0001:\u0001" +
                    ":\u0005:\u0388\b:\n:\f:\u038b\t:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001" +
                    ";\u0001;\u0001;\u0001;\u0001;\u0003;\u0397\b;\u0001<\u0001<\u0001<\u0001" +
                    "<\u0001=\u0001=\u0001=\u0001=\u0005=\u03a1\b=\n=\f=\u03a4\t=\u0001=\u0001" +
                    "=\u0001>\u0003>\u03a9\b>\u0001>\u0001>\u0003>\u03ad\b>\u0001>\u0001>\u0001" +
                    ">\u0005>\u03b2\b>\n>\f>\u03b5\t>\u0001>\u0001>\u0001>\u0003>\u03ba\b>" +
                    "\u0001>\u0001>\u0003>\u03be\b>\u0001>\u0001>\u0001>\u0005>\u03c3\b>\n" +
                    ">\f>\u03c6\t>\u0001>\u0001>\u0001>\u0001>\u0003>\u03cc\b>\u0001>\u0001" +
                    ">\u0003>\u03d0\b>\u0001>\u0001>\u0001>\u0001>\u0003>\u03d6\b>\u0001>\u0001" +
                    ">\u0003>\u03da\b>\u0003>\u03dc\b>\u0001>\u0001>\u0001>\u0001>\u0003>\u03e2" +
                    "\b>\u0001?\u0001?\u0001?\u0005?\u03e7\b?\n?\f?\u03ea\t?\u0001?\u0003?" +
                    "\u03ed\b?\u0001@\u0001@\u0003@\u03f1\b@\u0001A\u0001A\u0001A\u0001A\u0001" +
                    "A\u0001A\u0001A\u0001B\u0001B\u0001B\u0001B\u0003B\u03fe\bB\u0001B\u0003" +
                    "B\u0401\bB\u0001B\u0001B\u0001C\u0001C\u0001C\u0003C\u0408\bC\u0001C\u0001" +
                    "C\u0001D\u0001D\u0001D\u0003D\u040f\bD\u0001E\u0001E\u0003E\u0413\bE\u0001" +
                    "F\u0001F\u0003F\u0417\bF\u0001G\u0004G\u041a\bG\u000bG\fG\u041b\u0001" +
                    "H\u0001H\u0001H\u0003H\u0421\bH\u0001I\u0001I\u0001I\u0001I\u0001J\u0003" +
                    "J\u0428\bJ\u0001J\u0001J\u0001J\u0001J\u0005J\u042e\bJ\nJ\fJ\u0431\tJ" +
                    "\u0001J\u0001J\u0001K\u0001K\u0001K\u0005K\u0438\bK\nK\fK\u043b\tK\u0001" +
                    "L\u0001L\u0001L\u0003L\u0440\bL\u0001L\u0001L\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0003M\u047f\bM\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0003M\u048c" +
                    "\bM\u0001M\u0001M\u0001M\u0001M\u0001M\u0003M\u0493\bM\u0001M\u0001M\u0001" +
                    "M\u0003M\u0498\bM\u0003M\u049a\bM\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0003M\u04c0\bM\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001M\u0001" +
                    "M\u0001M\u0001M\u0005M\u04d6\bM\nM\fM\u04d9\tM\u0001N\u0001N\u0003N\u04dd" +
                    "\bN\u0001O\u0001O\u0001O\u0003O\u04e2\bO\u0001O\u0001O\u0001O\u0003O\u04e7" +
                    "\bO\u0001O\u0003O\u04ea\bO\u0001O\u0001O\u0001O\u0001O\u0003O\u04f0\b" +
                    "O\u0001P\u0003P\u04f3\bP\u0001P\u0001P\u0003P\u04f7\bP\u0001P\u0001P\u0001" +
                    "P\u0001P\u0003P\u04fd\bP\u0001P\u0001P\u0003P\u0501\bP\u0001P\u0001P\u0001" +
                    "P\u0001P\u0001P\u0001P\u0001P\u0001P\u0001P\u0003P\u050c\bP\u0001Q\u0001" +
                    "Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0001Q\u0005Q\u0516\bQ\nQ\fQ\u0519" +
                    "\tQ\u0001Q\u0003Q\u051c\bQ\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0005R\u0523" +
                    "\bR\nR\fR\u0526\tR\u0001R\u0001R\u0001R\u0001S\u0001S\u0001S\u0003S\u052e" +
                    "\bS\u0001T\u0001T\u0001U\u0001U\u0001U\u0001U\u0003U\u0536\bU\u0001U\u0001" +
                    "U\u0003U\u053a\bU\u0001V\u0001V\u0001V\u0005V\u053f\bV\nV\fV\u0542\tV" +
                    "\u0001V\u0003V\u0545\bV\u0001W\u0001W\u0001W\u0003W\u054a\bW\u0001W\u0001" +
                    "W\u0001W\u0003W\u054f\bW\u0001W\u0001W\u0003W\u0553\bW\u0001X\u0001X\u0001" +
                    "X\u0001X\u0001X\u0005X\u055a\bX\nX\fX\u055d\tX\u0001X\u0001X\u0001Y\u0003" +
                    "Y\u0562\bY\u0001Y\u0001Y\u0001Z\u0001Z\u0003Z\u0568\bZ\u0001Z\u0003Z\u056b" +
                    "\bZ\u0001[\u0001[\u0003[\u056f\b[\u0001[\u0003[\u0572\b[\u0001[\u0001" +
                    "[\u0001[\u0003[\u0577\b[\u0001\\\u0003\\\u057a\b\\\u0001\\\u0003\\\u057d" +
                    "\b\\\u0001\\\u0003\\\u0580\b\\\u0001\\\u0003\\\u0583\b\\\u0001\\\u0001" +
                    "\\\u0003\\\u0587\b\\\u0001\\\u0001\\\u0003\\\u058b\b\\\u0001\\\u0001\\" +
                    "\u0003\\\u058f\b\\\u0001\\\u0001\\\u0001\\\u0003\\\u0594\b\\\u0001\\\u0001" +
                    "\\\u0003\\\u0598\b\\\u0003\\\u059a\b\\\u0001\\\u0001\\\u0005\\\u059e\b" +
                    "\\\n\\\f\\\u05a1\t\\\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0005]\u05a8" +
                    "\b]\n]\f]\u05ab\t]\u0001^\u0003^\u05ae\b^\u0001^\u0003^\u05b1\b^\u0001" +
                    "^\u0001^\u0001_\u0001_\u0001_\u0001_\u0005_\u05b9\b_\n_\f_\u05bc\t_\u0001" +
                    "_\u0001_\u0003_\u05c0\b_\u0003_\u05c2\b_\u0001`\u0001`\u0001`\u0003`\u05c7" +
                    "\b`\u0001`\u0001`\u0001`\u0001`\u0005`\u05cd\b`\n`\f`\u05d0\t`\u0001`" +
                    "\u0003`\u05d3\b`\u0001`\u0001`\u0003`\u05d7\b`\u0001a\u0001a\u0001a\u0005" +
                    "a\u05dc\ba\na\fa\u05df\ta\u0001b\u0001b\u0001b\u0001b\u0005b\u05e5\bb" +
                    "\nb\fb\u05e8\tb\u0001b\u0003b\u05eb\bb\u0001b\u0003b\u05ee\bb\u0001b\u0001" +
                    "b\u0001c\u0003c\u05f3\bc\u0001c\u0003c\u05f6\bc\u0001c\u0001c\u0001c\u0003" +
                    "c\u05fb\bc\u0001d\u0001d\u0001d\u0001e\u0001e\u0001e\u0001e\u0001e\u0001" +
                    "e\u0003e\u0606\be\u0003e\u0608\be\u0001e\u0001e\u0001e\u0001e\u0003e\u060e" +
                    "\be\u0003e\u0610\be\u0001e\u0001e\u0001e\u0003e\u0615\be\u0001f\u0001" +
                    "f\u0001f\u0001f\u0001f\u0003f\u061c\bf\u0001g\u0001g\u0001g\u0001g\u0003" +
                    "g\u0622\bg\u0001h\u0001h\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0003" +
                    "i\u062c\bi\u0001i\u0001i\u0001i\u0003i\u0631\bi\u0001i\u0001i\u0001i\u0003" +
                    "i\u0636\bi\u0003i\u0638\bi\u0001j\u0001j\u0001k\u0001k\u0004k\u063e\b" +
                    "k\u000bk\fk\u063f\u0001k\u0001k\u0004k\u0644\bk\u000bk\fk\u0645\u0001" +
                    "k\u0001k\u0001k\u0005k\u064b\bk\nk\fk\u064e\tk\u0001k\u0003k\u0651\bk" +
                    "\u0001l\u0001l\u0001l\u0003l\u0656\bl\u0001m\u0001m\u0001m\u0005m\u065b" +
                    "\bm\nm\fm\u065e\tm\u0001n\u0001n\u0005n\u0662\bn\nn\fn\u0665\tn\u0001" +
                    "o\u0001o\u0001o\u0001o\u0001o\u0001o\u0003o\u066d\bo\u0001p\u0001p\u0001" +
                    "p\u0003p\u0672\bp\u0001q\u0001q\u0001q\u0001r\u0001r\u0001r\u0001r\u0003" +
                    "r\u067b\br\u0001s\u0003s\u067e\bs\u0001s\u0001s\u0005s\u0682\bs\ns\fs" +
                    "\u0685\ts\u0001t\u0001t\u0001t\u0003t\u068a\bt\u0001t\u0001t\u0001t\u0001" +
                    "t\u0003t\u0690\bt\u0001u\u0001u\u0003u\u0694\bu\u0001v\u0001v\u0001v\u0001" +
                    "v\u0001v\u0003v\u069b\bv\u0001v\u0005v\u069e\bv\nv\fv\u06a1\tv\u0001w" +
                    "\u0005w\u06a4\bw\nw\fw\u06a7\tw\u0001w\u0001w\u0001w\u0001w\u0001w\u0001" +
                    "w\u0003w\u06af\bw\u0001w\u0005w\u06b2\bw\nw\fw\u06b5\tw\u0001x\u0001x" +
                    "\u0003x\u06b9\bx\u0001x\u0001x\u0001x\u0001x\u0001x\u0003x\u06c0\bx\u0001" +
                    "y\u0003y\u06c3\by\u0001y\u0001y\u0003y\u06c7\by\u0005y\u06c9\by\ny\fy" +
                    "\u06cc\ty\u0001z\u0001z\u0001z\u0001z\u0001z\u0001z\u0001z\u0003z\u06d5" +
                    "\bz\u0001{\u0001{\u0001|\u0001|\u0001}\u0001}\u0001~\u0001~\u0001\u007f" +
                    "\u0001\u007f\u0001\u0080\u0001\u0080\u0001\u0081\u0001\u0081\u0001\u0081" +
                    "\u0000\u0002r\u009a\u0082\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012" +
                    "\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\" +
                    "^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090" +
                    "\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8" +
                    "\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0" +
                    "\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8" +
                    "\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0" +
                    "\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0000\u0018\u0002" +
                    "\u000055NN\u0002\u000033uu\u0001\u0000\u00d3\u00d4\u0001\u0000\u00c7\u00c8" +
                    "\u0002\u0000\u00c0\u00c0\u00c2\u00c3\u0001\u0000\u009d\u009e\u0001\u0000" +
                    "TU\u0001\u0000mn\u0001\u0000\u00c4\u00c6\u0002\u0000\u00c2\u00c3\u00ca" +
                    "\u00ca\u0001\u0000\u00b6\u00b7\u0002\u0000\u00a3\u00a4\u00bc\u00bd\u0001" +
                    "\u0000\u009f\u00a2\u0004\u0000\u00a5\u00a7\u00a9\u00b1\u00b5\u00b5\u00d5" +
                    "\u00d5\u0001\u0000\u00c2\u00c3\u0002\u0000\u00da\u00db\u00dd\u00de\u0002" +
                    "\u000033gg\u0002\u0000))II\u0004\u0000)ac\u007f\u0081\u0098\u00d9\u00d9" +
                    "\u0004\u0000))IIjlqq\u0001\u0000\u0091\u0098\u0001\u0000\u0081\u0090\u0007" +
                    "\u0000**--;;Z[ffoorr\t\u0000**,-:;KKX[ffoorrxz\u07b4\u0000\u0105\u0001" +
                    "\u0000\u0000\u0000\u0002\u0111\u0001\u0000\u0000\u0000\u0004\u012d\u0001" +
                    "\u0000\u0000\u0000\u0006\u0132\u0001\u0000\u0000\u0000\b\u013a\u0001\u0000" +
                    "\u0000\u0000\n\u0145\u0001\u0000\u0000\u0000\f\u0147\u0001\u0000\u0000" +
                    "\u0000\u000e\u014f\u0001\u0000\u0000\u0000\u0010\u015c\u0001\u0000\u0000" +
                    "\u0000\u0012\u015e\u0001\u0000\u0000\u0000\u0014\u0174\u0001\u0000\u0000" +
                    "\u0000\u0016\u0177\u0001\u0000\u0000\u0000\u0018\u018e\u0001\u0000\u0000" +
                    "\u0000\u001a\u01ba\u0001\u0000\u0000\u0000\u001c\u01bc\u0001\u0000\u0000" +
                    "\u0000\u001e\u01d2\u0001\u0000\u0000\u0000 \u01d4\u0001\u0000\u0000\u0000" +
                    "\"\u01dc\u0001\u0000\u0000\u0000$\u01e5\u0001\u0000\u0000\u0000&\u01ea" +
                    "\u0001\u0000\u0000\u0000(\u01f2\u0001\u0000\u0000\u0000*\u01fe\u0001\u0000" +
                    "\u0000\u0000,\u0202\u0001\u0000\u0000\u0000.\u0212\u0001\u0000\u0000\u0000" +
                    "0\u0219\u0001\u0000\u0000\u00002\u021f\u0001\u0000\u0000\u00004\u023c" +
                    "\u0001\u0000\u0000\u00006\u023e\u0001\u0000\u0000\u00008\u0240\u0001\u0000" +
                    "\u0000\u0000:\u0260\u0001\u0000\u0000\u0000<\u0262\u0001\u0000\u0000\u0000" +
                    ">\u0266\u0001\u0000\u0000\u0000@\u026b\u0001\u0000\u0000\u0000B\u026e" +
                    "\u0001\u0000\u0000\u0000D\u0272\u0001\u0000\u0000\u0000F\u027c\u0001\u0000" +
                    "\u0000\u0000H\u0282\u0001\u0000\u0000\u0000J\u0298\u0001\u0000\u0000\u0000" +
                    "L\u029a\u0001\u0000\u0000\u0000N\u029c\u0001\u0000\u0000\u0000P\u02bd" +
                    "\u0001\u0000\u0000\u0000R\u02c3\u0001\u0000\u0000\u0000T\u02c9\u0001\u0000" +
                    "\u0000\u0000V\u02cf\u0001\u0000\u0000\u0000X\u02d5\u0001\u0000\u0000\u0000" +
                    "Z\u02d8\u0001\u0000\u0000\u0000\\\u02de\u0001\u0000\u0000\u0000^\u030f" +
                    "\u0001\u0000\u0000\u0000`\u0322\u0001\u0000\u0000\u0000b\u0330\u0001\u0000" +
                    "\u0000\u0000d\u0333\u0001\u0000\u0000\u0000f\u0337\u0001\u0000\u0000\u0000" +
                    "h\u033b\u0001\u0000\u0000\u0000j\u0348\u0001\u0000\u0000\u0000l\u034c" +
                    "\u0001\u0000\u0000\u0000n\u0355\u0001\u0000\u0000\u0000p\u0362\u0001\u0000" +
                    "\u0000\u0000r\u0379\u0001\u0000\u0000\u0000t\u0383\u0001\u0000\u0000\u0000" +
                    "v\u0396\u0001\u0000\u0000\u0000x\u0398\u0001\u0000\u0000\u0000z\u039c" +
                    "\u0001\u0000\u0000\u0000|\u03e1\u0001\u0000\u0000\u0000~\u03ec\u0001\u0000" +
                    "\u0000\u0000\u0080\u03f0\u0001\u0000\u0000\u0000\u0082\u03f2\u0001\u0000" +
                    "\u0000\u0000\u0084\u03f9\u0001\u0000\u0000\u0000\u0086\u0407\u0001\u0000" +
                    "\u0000\u0000\u0088\u040b\u0001\u0000\u0000\u0000\u008a\u0412\u0001\u0000" +
                    "\u0000\u0000\u008c\u0416\u0001\u0000\u0000\u0000\u008e\u0419\u0001\u0000" +
                    "\u0000\u0000\u0090\u041d\u0001\u0000\u0000\u0000\u0092\u0422\u0001\u0000" +
                    "\u0000\u0000\u0094\u0427\u0001\u0000\u0000\u0000\u0096\u0434\u0001\u0000" +
                    "\u0000\u0000\u0098\u043c\u0001\u0000\u0000\u0000\u009a\u0499\u0001\u0000" +
                    "\u0000\u0000\u009c\u04dc\u0001\u0000\u0000\u0000\u009e\u04e9\u0001\u0000" +
                    "\u0000\u0000\u00a0\u050b\u0001\u0000\u0000\u0000\u00a2\u050d\u0001\u0000" +
                    "\u0000\u0000\u00a4\u051f\u0001\u0000\u0000\u0000\u00a6\u052a\u0001\u0000" +
                    "\u0000\u0000\u00a8\u052f\u0001\u0000\u0000\u0000\u00aa\u0531\u0001\u0000" +
                    "\u0000\u0000\u00ac\u053b\u0001\u0000\u0000\u0000\u00ae\u0552\u0001\u0000" +
                    "\u0000\u0000\u00b0\u0554\u0001\u0000\u0000\u0000\u00b2\u0561\u0001\u0000" +
                    "\u0000\u0000\u00b4\u056a\u0001\u0000\u0000\u0000\u00b6\u0576\u0001\u0000" +
                    "\u0000\u0000\u00b8\u0579\u0001\u0000\u0000\u0000\u00ba\u05a4\u0001\u0000" +
                    "\u0000\u0000\u00bc\u05ad\u0001\u0000\u0000\u0000\u00be\u05c1\u0001\u0000" +
                    "\u0000\u0000\u00c0\u05d6\u0001\u0000\u0000\u0000\u00c2\u05d8\u0001\u0000" +
                    "\u0000\u0000\u00c4\u05e0\u0001\u0000\u0000\u0000\u00c6\u05fa\u0001\u0000" +
                    "\u0000\u0000\u00c8\u05fc\u0001\u0000\u0000\u0000\u00ca\u0614\u0001\u0000" +
                    "\u0000\u0000\u00cc\u061b\u0001\u0000\u0000\u0000\u00ce\u0621\u0001\u0000" +
                    "\u0000\u0000\u00d0\u0623\u0001\u0000\u0000\u0000\u00d2\u0637\u0001\u0000" +
                    "\u0000\u0000\u00d4\u0639\u0001\u0000\u0000\u0000\u00d6\u0650\u0001\u0000" +
                    "\u0000\u0000\u00d8\u0655\u0001\u0000\u0000\u0000\u00da\u0657\u0001\u0000" +
                    "\u0000\u0000\u00dc\u065f\u0001\u0000\u0000\u0000\u00de\u066c\u0001\u0000" +
                    "\u0000\u0000\u00e0\u066e\u0001\u0000\u0000\u0000\u00e2\u0673\u0001\u0000" +
                    "\u0000\u0000\u00e4\u067a\u0001\u0000\u0000\u0000\u00e6\u067d\u0001\u0000" +
                    "\u0000\u0000\u00e8\u068f\u0001\u0000\u0000\u0000\u00ea\u0693\u0001\u0000" +
                    "\u0000\u0000\u00ec\u069a\u0001\u0000\u0000\u0000\u00ee\u06a5\u0001\u0000" +
                    "\u0000\u0000\u00f0\u06bf\u0001\u0000\u0000\u0000\u00f2\u06c2\u0001\u0000" +
                    "\u0000\u0000\u00f4\u06d4\u0001\u0000\u0000\u0000\u00f6\u06d6\u0001\u0000" +
                    "\u0000\u0000\u00f8\u06d8\u0001\u0000\u0000\u0000\u00fa\u06da\u0001\u0000" +
                    "\u0000\u0000\u00fc\u06dc\u0001\u0000\u0000\u0000\u00fe\u06de\u0001\u0000" +
                    "\u0000\u0000\u0100\u06e0\u0001\u0000\u0000\u0000\u0102\u06e2\u0001\u0000" +
                    "\u0000\u0000\u0104\u0106\u0005\t\u0000\u0000\u0105\u0104\u0001\u0000\u0000" +
                    "\u0000\u0105\u0106\u0001\u0000\u0000\u0000\u0106\u010b\u0001\u0000\u0000" +
                    "\u0000\u0107\u010a\u0003\u0002\u0001\u0000\u0108\u010a\u0003\u0006\u0003" +
                    "\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u0109\u0108\u0001\u0000\u0000" +
                    "\u0000\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000" +
                    "\u0000\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000" +
                    "\u0000\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0005\u0000\u0000" +
                    "\u0001\u010f\u0001\u0001\u0000\u0000\u0000\u0110\u0112\u0003\u0004\u0002" +
                    "\u0000\u0111\u0110\u0001\u0000\u0000\u0000\u0112\u0113\u0001\u0000\u0000" +
                    "\u0000\u0113\u0111\u0001\u0000\u0000\u0000\u0113\u0114\u0001\u0000\u0000" +
                    "\u0000\u0114\u0003\u0001\u0000\u0000\u0000\u0115\u012e\u0005\u0007\u0000" +
                    "\u0000\u0116\u012e\u0005\u000e\u0000\u0000\u0117\u012e\u0005\b\u0000\u0000" +
                    "\u0118\u012e\u0005\u0017\u0000\u0000\u0119\u012e\u0005\u000f\u0000\u0000" +
                    "\u011a\u012e\u0005\u0010\u0000\u0000\u011b\u012e\u0005\u0002\u0000\u0000" +
                    "\u011c\u012e\u0005\u0011\u0000\u0000\u011d\u012e\u0005\u0012\u0000\u0000" +
                    "\u011e\u012e\u0005\u001a\u0000\u0000\u011f\u012e\u0005\u0013\u0000\u0000" +
                    "\u0120\u012e\u0005\u001e\u0000\u0000\u0121\u012e\u0005\u0014\u0000\u0000" +
                    "\u0122\u012e\u0005\u0015\u0000\u0000\u0123\u012e\u0005\u001b\u0000\u0000" +
                    "\u0124\u012e\u0005\u001f\u0000\u0000\u0125\u0129\u0005\u0003\u0000\u0000" +
                    "\u0126\u0128\u0005\u000b\u0000\u0000\u0127\u0126\u0001\u0000\u0000\u0000" +
                    "\u0128\u012b\u0001\u0000\u0000\u0000\u0129\u0127\u0001\u0000\u0000\u0000" +
                    "\u0129\u012a\u0001\u0000\u0000\u0000\u012a\u012c\u0001\u0000\u0000\u0000" +
                    "\u012b\u0129\u0001\u0000\u0000\u0000\u012c\u012e\u0005\f\u0000\u0000\u012d" +
                    "\u0115\u0001\u0000\u0000\u0000\u012d\u0116\u0001\u0000\u0000\u0000\u012d" +
                    "\u0117\u0001\u0000\u0000\u0000\u012d\u0118\u0001\u0000\u0000\u0000\u012d" +
                    "\u0119\u0001\u0000\u0000\u0000\u012d\u011a\u0001\u0000\u0000\u0000\u012d" +
                    "\u011b\u0001\u0000\u0000\u0000\u012d\u011c\u0001\u0000\u0000\u0000\u012d" +
                    "\u011d\u0001\u0000\u0000\u0000\u012d\u011e\u0001\u0000\u0000\u0000\u012d" +
                    "\u011f\u0001\u0000\u0000\u0000\u012d\u0120\u0001\u0000\u0000\u0000\u012d" +
                    "\u0121\u0001\u0000\u0000\u0000\u012d\u0122\u0001\u0000\u0000\u0000\u012d" +
                    "\u0123\u0001\u0000\u0000\u0000\u012d\u0124\u0001\u0000\u0000\u0000\u012d" +
                    "\u0125\u0001\u0000\u0000\u0000\u012e\u0005\u0001\u0000\u0000\u0000\u012f" +
                    "\u0131\u0003\b\u0004\u0000\u0130\u012f\u0001\u0000\u0000\u0000\u0131\u0134" +
                    "\u0001\u0000\u0000\u0000\u0132\u0130\u0001\u0000\u0000\u0000\u0132\u0133" +
                    "\u0001\u0000\u0000\u0000\u0133\u0136\u0001\u0000\u0000\u0000\u0134\u0132" +
                    "\u0001\u0000\u0000\u0000\u0135\u0137\u0003\n\u0005\u0000\u0136\u0135\u0001" +
                    "\u0000\u0000\u0000\u0137\u0138\u0001\u0000\u0000\u0000\u0138\u0136\u0001" +
                    "\u0000\u0000\u0000\u0138\u0139\u0001\u0000\u0000\u0000\u0139\u0007\u0001" +
                    "\u0000\u0000\u0000\u013a\u013b\u0005S\u0000\u0000\u013b\u013c\u0005c\u0000" +
                    "\u0000\u013c\u013d\u0003\u00be_\u0000\u013d\u013e\u0005\u00d4\u0000\u0000" +
                    "\u013e\t\u0001\u0000\u0000\u0000\u013f\u0146\u00034\u001a\u0000\u0140" +
                    "\u0146\u0003\f\u0006\u0000\u0141\u0146\u0003\u0012\t\u0000\u0142\u0146" +
                    "\u0003\u0016\u000b\u0000\u0143\u0146\u0003\u0018\f\u0000\u0144\u0146\u0003" +
                    "\u0094J\u0000\u0145\u013f\u0001\u0000\u0000\u0000\u0145\u0140\u0001\u0000" +
                    "\u0000\u0000\u0145\u0141\u0001\u0000\u0000\u0000\u0145\u0142\u0001\u0000" +
                    "\u0000\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0145\u0144\u0001\u0000" +
                    "\u0000\u0000\u0146\u000b\u0001\u0000\u0000\u0000\u0147\u0149\u0005{\u0000" +
                    "\u0000\u0148\u014a\u0007\u0000\u0000\u0000\u0149\u0148\u0001\u0000\u0000" +
                    "\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000\u0000" +
                    "\u0000\u014b\u014c\u0003\u000e\u0007\u0000\u014c\u014d\u0005\u00d4\u0000" +
                    "\u0000\u014d\r\u0001\u0000\u0000\u0000\u014e\u0150\u0005\u00ba\u0000\u0000" +
                    "\u014f\u014e\u0001\u0000\u0000\u0000\u014f\u0150\u0001\u0000\u0000\u0000" +
                    "\u0150\u0151\u0001\u0000\u0000\u0000\u0151\u0159\u0003\u0010\b\u0000\u0152" +
                    "\u0154\u0005\u00d2\u0000\u0000\u0153\u0155\u0005\u00ba\u0000\u0000\u0154" +
                    "\u0153\u0001\u0000\u0000\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155" +
                    "\u0156\u0001\u0000\u0000\u0000\u0156\u0158\u0003\u0010\b\u0000\u0157\u0152" +
                    "\u0001\u0000\u0000\u0000\u0158\u015b\u0001\u0000\u0000\u0000\u0159\u0157" +
                    "\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000\u0000\u0000\u015a\u000f" +
                    "\u0001\u0000\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015c\u015d" +
                    "\u0003\u00be_\u0000\u015d\u0011\u0001\u0000\u0000\u0000\u015e\u016d\u0005" +
                    "c\u0000\u0000\u015f\u0161\u0003\u00be_\u0000\u0160\u015f\u0001\u0000\u0000" +
                    "\u0000\u0160\u0161\u0001\u0000\u0000\u0000\u0161\u0162\u0001\u0000\u0000" +
                    "\u0000\u0162\u0166\u0005\u00d0\u0000\u0000\u0163\u0165\u0003\u0014\n\u0000" +
                    "\u0164\u0163\u0001\u0000\u0000\u0000\u0165\u0168\u0001\u0000\u0000\u0000" +
                    "\u0166\u0164\u0001\u0000\u0000\u0000\u0166\u0167\u0001\u0000\u0000\u0000" +
                    "\u0167\u0169\u0001\u0000\u0000\u0000\u0168\u0166\u0001\u0000\u0000\u0000" +
                    "\u0169\u016e\u0005\u00d1\u0000\u0000\u016a\u016b\u0003\u00be_\u0000\u016b" +
                    "\u016c\u0005\u00d4\u0000\u0000\u016c\u016e\u0001\u0000\u0000\u0000\u016d" +
                    "\u0160\u0001\u0000\u0000\u0000\u016d\u016a\u0001\u0000\u0000\u0000\u016e" +
                    "\u0013\u0001\u0000\u0000\u0000\u016f\u0175\u00034\u001a\u0000\u0170\u0175" +
                    "\u0003\f\u0006\u0000\u0171\u0175\u0003\u0016\u000b\u0000\u0172\u0175\u0003" +
                    "\u0018\f\u0000\u0173\u0175\u0003\u0094J\u0000\u0174\u016f\u0001\u0000" +
                    "\u0000\u0000\u0174\u0170\u0001\u0000\u0000\u0000\u0174\u0171\u0001\u0000" +
                    "\u0000\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0174\u0173\u0001\u0000" +
                    "\u0000\u0000\u0175\u0015\u0001\u0000\u0000\u0000\u0176\u0178\u0003*\u0015" +
                    "\u0000\u0177\u0176\u0001\u0000\u0000\u0000\u0177\u0178\u0001\u0000\u0000" +
                    "\u0000\u0178\u0179\u0001\u0000\u0000\u0000\u0179\u017b\u0005N\u0000\u0000" +
                    "\u017a\u017c\u0005\u00be\u0000\u0000\u017b\u017a\u0001\u0000\u0000\u0000" +
                    "\u017b\u017c\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000" +
                    "\u017d\u017f\u0003\u00f8|\u0000\u017e\u0180\u0003\u001e\u000f\u0000\u017f" +
                    "\u017e\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180" +
                    "\u0181\u0001\u0000\u0000\u0000\u0181\u0182\u0005\u00cc\u0000\u0000\u0182" +
                    "\u0183\u0003n7\u0000\u0183\u0189\u0005\u00cd\u0000\u0000\u0184\u0186\u0005" +
                    "\u00d3\u0000\u0000\u0185\u0187\u0005\u00cb\u0000\u0000\u0186\u0185\u0001" +
                    "\u0000\u0000\u0000\u0186\u0187\u0001\u0000\u0000\u0000\u0187\u0188\u0001" +
                    "\u0000\u0000\u0000\u0188\u018a\u0003r9\u0000\u0189\u0184\u0001\u0000\u0000" +
                    "\u0000\u0189\u018a\u0001\u0000\u0000\u0000\u018a\u018b\u0001\u0000\u0000" +
                    "\u0000\u018b\u018c\u00038\u001c\u0000\u018c\u0017\u0001\u0000\u0000\u0000" +
                    "\u018d\u018f\u0003*\u0015\u0000\u018e\u018d\u0001\u0000\u0000\u0000\u018e" +
                    "\u018f\u0001\u0000\u0000\u0000\u018f\u0191\u0001\u0000\u0000\u0000\u0190" +
                    "\u0192\u0005j\u0000\u0000\u0191\u0190\u0001\u0000\u0000\u0000\u0191\u0192" +
                    "\u0001\u0000\u0000\u0000\u0192\u0194\u0001\u0000\u0000\u0000\u0193\u0195" +
                    "\u0003\u00f6{\u0000\u0194\u0193\u0001\u0000\u0000\u0000\u0194\u0195\u0001" +
                    "\u0000\u0000\u0000\u0195\u0197\u0001\u0000\u0000\u0000\u0196\u0198\u0005" +
                    "h\u0000\u0000\u0197\u0196\u0001\u0000\u0000\u0000\u0197\u0198\u0001\u0000" +
                    "\u0000\u0000\u0198\u01af\u0001\u0000\u0000\u0000\u0199\u019a\u0003\u001a" +
                    "\r\u0000\u019a\u019c\u0003\u00f8|\u0000\u019b\u019d\u0003\u001e\u000f" +
                    "\u0000\u019c\u019b\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000" +
                    "\u0000\u019d\u01a0\u0001\u0000\u0000\u0000\u019e\u019f\u0005H\u0000\u0000" +
                    "\u019f\u01a1\u0003\u00b4Z\u0000\u01a0\u019e\u0001\u0000\u0000\u0000\u01a0" +
                    "\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a4\u0001\u0000\u0000\u0000\u01a2" +
                    "\u01a3\u0005R\u0000\u0000\u01a3\u01a5\u0003\u001c\u000e\u0000\u01a4\u01a2" +
                    "\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000\u0000\u01a5\u01b0" +
                    "\u0001\u0000\u0000\u0000\u01a6\u01a7\u0005\\\u0000\u0000\u01a7\u01a9\u0003" +
                    "\u00f8|\u0000\u01a8\u01aa\u0003\u001e\u000f\u0000\u01a9\u01a8\u0001\u0000" +
                    "\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000\u01aa\u01ad\u0001\u0000" +
                    "\u0000\u0000\u01ab\u01ac\u0005H\u0000\u0000\u01ac\u01ae\u0003\u001c\u000e" +
                    "\u0000\u01ad\u01ab\u0001\u0000\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000" +
                    "\u0000\u01ae\u01b0\u0001\u0000\u0000\u0000\u01af\u0199\u0001\u0000\u0000" +
                    "\u0000\u01af\u01a6\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000\u0000" +
                    "\u0000\u01b1\u01b5\u0005\u00d0\u0000\u0000\u01b2\u01b4\u0003|>\u0000\u01b3" +
                    "\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b7\u0001\u0000\u0000\u0000\u01b5" +
                    "\u01b3\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6" +
                    "\u01b8\u0001\u0000\u0000\u0000\u01b7\u01b5\u0001\u0000\u0000\u0000\u01b8" +
                    "\u01b9\u0005\u00d1\u0000\u0000\u01b9\u0019\u0001\u0000\u0000\u0000\u01ba" +
                    "\u01bb\u0007\u0001\u0000\u0000\u01bb\u001b\u0001\u0000\u0000\u0000\u01bc" +
                    "\u01c1\u0003\u00b4Z\u0000\u01bd\u01be\u0005\u00d2\u0000\u0000\u01be\u01c0" +
                    "\u0003\u00b4Z\u0000\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0\u01c3\u0001" +
                    "\u0000\u0000\u0000\u01c1\u01bf\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001" +
                    "\u0000\u0000\u0000\u01c2\u001d\u0001\u0000\u0000\u0000\u01c3\u01c1\u0001" +
                    "\u0000\u0000\u0000\u01c4\u01c5\u0005\u009a\u0000\u0000\u01c5\u01c6\u0003" +
                    " \u0010\u0000\u01c6\u01c7\u0005\u009b\u0000\u0000\u01c7\u01d3\u0001\u0000" +
                    "\u0000\u0000\u01c8\u01c9\u0005\u009a\u0000\u0000\u01c9\u01ca\u0003\"\u0011" +
                    "\u0000\u01ca\u01cb\u0005\u009b\u0000\u0000\u01cb\u01d3\u0001\u0000\u0000" +
                    "\u0000\u01cc\u01cd\u0005\u009a\u0000\u0000\u01cd\u01ce\u0003 \u0010\u0000" +
                    "\u01ce\u01cf\u0005\u00d2\u0000\u0000\u01cf\u01d0\u0003\"\u0011\u0000\u01d0" +
                    "\u01d1\u0005\u009b\u0000\u0000\u01d1\u01d3\u0001\u0000\u0000\u0000\u01d2" +
                    "\u01c4\u0001\u0000\u0000\u0000\u01d2\u01c8\u0001\u0000\u0000\u0000\u01d2" +
                    "\u01cc\u0001\u0000\u0000\u0000\u01d3\u001f\u0001\u0000\u0000\u0000\u01d4" +
                    "\u01d9\u0003$\u0012\u0000\u01d5\u01d6\u0005\u00d2\u0000\u0000\u01d6\u01d8" +
                    "\u0003$\u0012\u0000\u01d7\u01d5\u0001\u0000\u0000\u0000\u01d8\u01db\u0001" +
                    "\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000\u01d9\u01da\u0001" +
                    "\u0000\u0000\u0000\u01da!\u0001\u0000\u0000\u0000\u01db\u01d9\u0001\u0000" +
                    "\u0000\u0000\u01dc\u01e1\u0003&\u0013\u0000\u01dd\u01de\u0005\u00d2\u0000" +
                    "\u0000\u01de\u01e0\u0003&\u0013\u0000\u01df\u01dd\u0001\u0000\u0000\u0000" +
                    "\u01e0\u01e3\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000\u0000\u0000" +
                    "\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2#\u0001\u0000\u0000\u0000\u01e3" +
                    "\u01e1\u0001\u0000\u0000\u0000\u01e4\u01e6\u0003*\u0015\u0000\u01e5\u01e4" +
                    "\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000\u01e6\u01e7" +
                    "\u0001\u0000\u0000\u0000\u01e7\u01e8\u0003\u00f8|\u0000\u01e8%\u0001\u0000" +
                    "\u0000\u0000\u01e9\u01eb\u0003*\u0015\u0000\u01ea\u01e9\u0001\u0000\u0000" +
                    "\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000\u0000" +
                    "\u0000\u01ec\u01ed\u0003\u00f8|\u0000\u01ed\u01f0\u0005\u00d5\u0000\u0000" +
                    "\u01ee\u01f1\u0003\u00b4Z\u0000\u01ef\u01f1\u0003\u0100\u0080\u0000\u01f0" +
                    "\u01ee\u0001\u0000\u0000\u0000\u01f0\u01ef\u0001\u0000\u0000\u0000\u01f1" +
                    "\'\u0001\u0000\u0000\u0000\u01f2\u01f3\u0005\u009a\u0000\u0000\u01f3\u01f8" +
                    "\u0003\u00b6[\u0000\u01f4\u01f5\u0005\u00d2\u0000\u0000\u01f5\u01f7\u0003" +
                    "\u00b6[\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f7\u01fa\u0001\u0000" +
                    "\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8\u01f9\u0001\u0000" +
                    "\u0000\u0000\u01f9\u01fb\u0001\u0000\u0000\u0000\u01fa\u01f8\u0001\u0000" +
                    "\u0000\u0000\u01fb\u01fc\u0005\u009b\u0000\u0000\u01fc)\u0001\u0000\u0000" +
                    "\u0000\u01fd\u01ff\u0003,\u0016\u0000\u01fe\u01fd\u0001\u0000\u0000\u0000" +
                    "\u01ff\u0200\u0001\u0000\u0000\u0000\u0200\u01fe\u0001\u0000\u0000\u0000" +
                    "\u0200\u0201\u0001\u0000\u0000\u0000\u0201+\u0001\u0000\u0000\u0000\u0202" +
                    "\u0206\u0005(\u0000\u0000\u0203\u0204\u0003\u00f8|\u0000\u0204\u0205\u0005" +
                    "\u00d3\u0000\u0000\u0205\u0207\u0001\u0000\u0000\u0000\u0206\u0203\u0001" +
                    "\u0000\u0000\u0000\u0206\u0207\u0001\u0000\u0000\u0000\u0207\u0208\u0001" +
                    "\u0000\u0000\u0000\u0208\u020d\u0003.\u0017\u0000\u0209\u020a\u0005\u00d2" +
                    "\u0000\u0000\u020a\u020c\u0003.\u0017\u0000\u020b\u0209\u0001\u0000\u0000" +
                    "\u0000\u020c\u020f\u0001\u0000\u0000\u0000\u020d\u020b\u0001\u0000\u0000" +
                    "\u0000\u020d\u020e\u0001\u0000\u0000\u0000\u020e\u0210\u0001\u0000\u0000" +
                    "\u0000\u020f\u020d\u0001\u0000\u0000\u0000\u0210\u0211\u0005\u00cf\u0000" +
                    "\u0000\u0211-\u0001\u0000\u0000\u0000\u0212\u0214\u0003\u00bc^\u0000\u0213" +
                    "\u0215\u0003\u00c4b\u0000\u0214\u0213\u0001\u0000\u0000\u0000\u0214\u0215" +
                    "\u0001\u0000\u0000\u0000\u0215/\u0001\u0000\u0000\u0000\u0216\u0218\u0003" +
                    "2\u0019\u0000\u0217\u0216\u0001\u0000\u0000\u0000\u0218\u021b\u0001\u0000" +
                    "\u0000\u0000\u0219\u0217\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000" +
                    "\u0000\u0000\u021a1\u0001\u0000\u0000\u0000\u021b\u0219\u0001\u0000\u0000" +
                    "\u0000\u021c\u0220\u00034\u001a\u0000\u021d\u0220\u0003\u0016\u000b\u0000" +
                    "\u021e\u0220\u0003\u0018\f\u0000\u021f\u021c\u0001\u0000\u0000\u0000\u021f" +
                    "\u021d\u0001\u0000\u0000\u0000\u021f\u021e\u0001\u0000\u0000\u0000\u0220" +
                    "3\u0001\u0000\u0000\u0000\u0221\u0222\u0003\u00f8|\u0000\u0222\u0223\u0005" +
                    "\u00d3\u0000\u0000\u0223\u023d\u0001\u0000\u0000\u0000\u0224\u023d\u0003" +
                    "8\u001c\u0000\u0225\u023d\u0003:\u001d\u0000\u0226\u023d\u0003D\"\u0000" +
                    "\u0227\u023d\u0003F#\u0000\u0228\u023d\u0003H$\u0000\u0229\u023d\u0003" +
                    "N\'\u0000\u022a\u023d\u0003R)\u0000\u022b\u023d\u0003T*\u0000\u022c\u023d" +
                    "\u0003V+\u0000\u022d\u022e\u0003\u00aaU\u0000\u022e\u022f\u0005\u00d4" +
                    "\u0000\u0000\u022f\u023d\u0001\u0000\u0000\u0000\u0230\u023d\u0003t:\u0000" +
                    "\u0231\u023d\u0003z=\u0000\u0232\u023d\u0003x<\u0000\u0233\u023d\u0003" +
                    "X,\u0000\u0234\u023d\u0003Z-\u0000\u0235\u023d\u0003\\.\u0000\u0236\u023d" +
                    "\u0003^/\u0000\u0237\u023d\u0003d2\u0000\u0238\u023d\u0003f3\u0000\u0239" +
                    "\u023d\u0003h4\u0000\u023a\u023d\u00036\u001b\u0000\u023b\u023d\u0003" +
                    "j5\u0000\u023c\u0221\u0001\u0000\u0000\u0000\u023c\u0224\u0001\u0000\u0000" +
                    "\u0000\u023c\u0225\u0001\u0000\u0000\u0000\u023c\u0226\u0001\u0000\u0000" +
                    "\u0000\u023c\u0227\u0001\u0000\u0000\u0000\u023c\u0228\u0001\u0000\u0000" +
                    "\u0000\u023c\u0229\u0001\u0000\u0000\u0000\u023c\u022a\u0001\u0000\u0000" +
                    "\u0000\u023c\u022b\u0001\u0000\u0000\u0000\u023c\u022c\u0001\u0000\u0000" +
                    "\u0000\u023c\u022d\u0001\u0000\u0000\u0000\u023c\u0230\u0001\u0000\u0000" +
                    "\u0000\u023c\u0231\u0001\u0000\u0000\u0000\u023c\u0232\u0001\u0000\u0000" +
                    "\u0000\u023c\u0233\u0001\u0000\u0000\u0000\u023c\u0234\u0001\u0000\u0000" +
                    "\u0000\u023c\u0235\u0001\u0000\u0000\u0000\u023c\u0236\u0001\u0000\u0000" +
                    "\u0000\u023c\u0237\u0001\u0000\u0000\u0000\u023c\u0238\u0001\u0000\u0000" +
                    "\u0000\u023c\u0239\u0001\u0000\u0000\u0000\u023c\u023a\u0001\u0000\u0000" +
                    "\u0000\u023c\u023b\u0001\u0000\u0000\u0000\u023d5\u0001\u0000\u0000\u0000" +
                    "\u023e\u023f\u0005\u00d4\u0000\u0000\u023f7\u0001\u0000\u0000\u0000\u0240" +
                    "\u0241\u0005\u00d0\u0000\u0000\u0241\u0242\u00030\u0018\u0000\u0242\u0243" +
                    "\u0005\u00d1\u0000\u0000\u02439\u0001\u0000\u0000\u0000\u0244\u0245\u0005" +
                    "Q\u0000\u0000\u0245\u0246\u0003\u0098L\u0000\u0246\u024a\u00034\u001a" +
                    "\u0000\u0247\u0249\u0003<\u001e\u0000\u0248\u0247\u0001\u0000\u0000\u0000" +
                    "\u0249\u024c\u0001\u0000\u0000\u0000\u024a\u0248\u0001\u0000\u0000\u0000" +
                    "\u024a\u024b\u0001\u0000\u0000\u0000\u024b\u024e\u0001\u0000\u0000\u0000" +
                    "\u024c\u024a\u0001\u0000\u0000\u0000\u024d\u024f\u0003@ \u0000\u024e\u024d" +
                    "\u0001\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f\u0261" +
                    "\u0001\u0000\u0000\u0000\u0250\u0251\u0005Q\u0000\u0000\u0251\u0252\u0003" +
                    "\u0098L\u0000\u0252\u0253\u0005\u00d3\u0000\u0000\u0253\u0257\u00030\u0018" +
                    "\u0000\u0254\u0256\u0003>\u001f\u0000\u0255\u0254\u0001\u0000\u0000\u0000" +
                    "\u0256\u0259\u0001\u0000\u0000\u0000\u0257\u0255\u0001\u0000\u0000\u0000" +
                    "\u0257\u0258\u0001\u0000\u0000\u0000\u0258\u025b\u0001\u0000\u0000\u0000" +
                    "\u0259\u0257\u0001\u0000\u0000\u0000\u025a\u025c\u0003B!\u0000\u025b\u025a" +
                    "\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000\u0000\u0000\u025c\u025d" +
                    "\u0001\u0000\u0000\u0000\u025d\u025e\u0005C\u0000\u0000\u025e\u025f\u0005" +
                    "\u00d4\u0000\u0000\u025f\u0261\u0001\u0000\u0000\u0000\u0260\u0244\u0001" +
                    "\u0000\u0000\u0000\u0260\u0250\u0001\u0000\u0000\u0000\u0261;\u0001\u0000" +
                    "\u0000\u0000\u0262\u0263\u0005>\u0000\u0000\u0263\u0264\u0003\u0098L\u0000" +
                    "\u0264\u0265\u00034\u001a\u0000\u0265=\u0001\u0000\u0000\u0000\u0266\u0267" +
                    "\u0005>\u0000\u0000\u0267\u0268\u0003\u0098L\u0000\u0268\u0269\u0005\u00d3" +
                    "\u0000\u0000\u0269\u026a\u00030\u0018\u0000\u026a?\u0001\u0000\u0000\u0000" +
                    "\u026b\u026c\u0005=\u0000\u0000\u026c\u026d\u00034\u001a\u0000\u026dA" +
                    "\u0001\u0000\u0000\u0000\u026e\u026f\u0005=\u0000\u0000\u026f\u0270\u0005" +
                    "\u00d3\u0000\u0000\u0270\u0271\u00030\u0018\u0000\u0271C\u0001\u0000\u0000" +
                    "\u0000\u0272\u0273\u0005}\u0000\u0000\u0273\u027a\u0003\u0098L\u0000\u0274" +
                    "\u027b\u00034\u001a\u0000\u0275\u0276\u0005\u00d3\u0000\u0000\u0276\u0277" +
                    "\u00030\u0018\u0000\u0277\u0278\u0005E\u0000\u0000\u0278\u0279\u0005\u00d4" +
                    "\u0000\u0000\u0279\u027b\u0001\u0000\u0000\u0000\u027a\u0274\u0001\u0000" +
                    "\u0000\u0000\u027a\u0275\u0001\u0000\u0000\u0000\u027bE\u0001\u0000\u0000" +
                    "\u0000\u027c\u027d\u00059\u0000\u0000\u027d\u027e\u00034\u001a\u0000\u027e" +
                    "\u027f\u0005}\u0000\u0000\u027f\u0280\u0003\u0098L\u0000\u0280\u0281\u0005" +
                    "\u00d4\u0000\u0000\u0281G\u0001\u0000\u0000\u0000\u0282\u0283\u0005L\u0000" +
                    "\u0000\u0283\u0285\u0005\u00cc\u0000\u0000\u0284\u0286\u0003J%\u0000\u0285" +
                    "\u0284\u0001\u0000\u0000\u0000\u0285\u0286\u0001\u0000\u0000\u0000\u0286" +
                    "\u0287\u0001\u0000\u0000\u0000\u0287\u0289\u0005\u00d4\u0000\u0000\u0288" +
                    "\u028a\u0003\u0096K\u0000\u0289\u0288\u0001\u0000\u0000\u0000\u0289\u028a" +
                    "\u0001\u0000\u0000\u0000\u028a\u028b\u0001\u0000\u0000\u0000\u028b\u028d" +
                    "\u0005\u00d4\u0000\u0000\u028c\u028e\u0003L&\u0000\u028d\u028c\u0001\u0000" +
                    "\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000\u028e\u028f\u0001\u0000" +
                    "\u0000\u0000\u028f\u0296\u0005\u00cd\u0000\u0000\u0290\u0297\u00034\u001a" +
                    "\u0000\u0291\u0292\u0005\u00d3\u0000\u0000\u0292\u0293\u00030\u0018\u0000" +
                    "\u0293\u0294\u0005A\u0000\u0000\u0294\u0295\u0005\u00d4\u0000\u0000\u0295" +
                    "\u0297\u0001\u0000\u0000\u0000\u0296\u0290\u0001\u0000\u0000\u0000\u0296" +
                    "\u0291\u0001\u0000\u0000\u0000\u0297I\u0001\u0000\u0000\u0000\u0298\u0299" +
                    "\u0003\u0096K\u0000\u0299K\u0001\u0000\u0000\u0000\u029a\u029b\u0003\u0096" +
                    "K\u0000\u029bM\u0001\u0000\u0000\u0000\u029c\u029d\u0005s\u0000\u0000" +
                    "\u029d\u02b5\u0003\u0098L\u0000\u029e\u02a0\u0005\u00d0\u0000\u0000\u029f" +
                    "\u02a1\u0005\u00d4\u0000\u0000\u02a0\u029f\u0001\u0000\u0000\u0000\u02a0" +
                    "\u02a1\u0001\u0000\u0000\u0000\u02a1\u02a5\u0001\u0000\u0000\u0000\u02a2" +
                    "\u02a4\u0003P(\u0000\u02a3\u02a2\u0001\u0000\u0000\u0000\u02a4\u02a7\u0001" +
                    "\u0000\u0000\u0000\u02a5\u02a3\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001" +
                    "\u0000\u0000\u0000\u02a6\u02a8\u0001\u0000\u0000\u0000\u02a7\u02a5\u0001" +
                    "\u0000\u0000\u0000\u02a8\u02b6\u0005\u00d1\u0000\u0000\u02a9\u02ab\u0005" +
                    "\u00d3\u0000\u0000\u02aa\u02ac\u0005\u00d4\u0000\u0000\u02ab\u02aa\u0001" +
                    "\u0000\u0000\u0000\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac\u02b0\u0001" +
                    "\u0000\u0000\u0000\u02ad\u02af\u0003P(\u0000\u02ae\u02ad\u0001\u0000\u0000" +
                    "\u0000\u02af\u02b2\u0001\u0000\u0000\u0000\u02b0\u02ae\u0001\u0000\u0000" +
                    "\u0000\u02b0\u02b1\u0001\u0000\u0000\u0000\u02b1\u02b3\u0001\u0000\u0000" +
                    "\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b3\u02b4\u0005D\u0000\u0000" +
                    "\u02b4\u02b6\u0005\u00d4\u0000\u0000\u02b5\u029e\u0001\u0000\u0000\u0000" +
                    "\u02b5\u02a9\u0001\u0000\u0000\u0000\u02b6O\u0001\u0000\u0000\u0000\u02b7" +
                    "\u02b8\u00051\u0000\u0000\u02b8\u02bb\u0003\u009aM\u0000\u02b9\u02bb\u0005" +
                    "8\u0000\u0000\u02ba\u02b7\u0001\u0000\u0000\u0000\u02ba\u02b9\u0001\u0000" +
                    "\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc\u02be\u0007\u0002" +
                    "\u0000\u0000\u02bd\u02ba\u0001\u0000\u0000\u0000\u02be\u02bf\u0001\u0000" +
                    "\u0000\u0000\u02bf\u02bd\u0001\u0000\u0000\u0000\u02bf\u02c0\u0001\u0000" +
                    "\u0000\u0000\u02c0\u02c1\u0001\u0000\u0000\u0000\u02c1\u02c2\u00030\u0018" +
                    "\u0000\u02c2Q\u0001\u0000\u0000\u0000\u02c3\u02c5\u0005/\u0000\u0000\u02c4" +
                    "\u02c6\u0003\u009aM\u0000\u02c5\u02c4\u0001\u0000\u0000\u0000\u02c5\u02c6" +
                    "\u0001\u0000\u0000\u0000\u02c6\u02c7\u0001\u0000\u0000\u0000\u02c7\u02c8" +
                    "\u0005\u00d4\u0000\u0000\u02c8S\u0001\u0000\u0000\u0000\u02c9\u02cb\u0005" +
                    "6\u0000\u0000\u02ca\u02cc\u0003\u009aM\u0000\u02cb\u02ca\u0001\u0000\u0000" +
                    "\u0000\u02cb\u02cc\u0001\u0000\u0000\u0000\u02cc\u02cd\u0001\u0000\u0000" +
                    "\u0000\u02cd\u02ce\u0005\u00d4\u0000\u0000\u02ceU\u0001\u0000\u0000\u0000" +
                    "\u02cf\u02d1\u0005p\u0000\u0000\u02d0\u02d2\u0003\u009aM\u0000\u02d1\u02d0" +
                    "\u0001\u0000\u0000\u0000\u02d1\u02d2\u0001\u0000\u0000\u0000\u02d2\u02d3" +
                    "\u0001\u0000\u0000\u0000\u02d3\u02d4\u0005\u00d4\u0000\u0000\u02d4W\u0001" +
                    "\u0000\u0000\u0000\u02d5\u02d6\u0003\u009aM\u0000\u02d6\u02d7\u0005\u00d4" +
                    "\u0000\u0000\u02d7Y\u0001\u0000\u0000\u0000\u02d8\u02d9\u0005z\u0000\u0000" +
                    "\u02d9\u02da\u0005\u00cc\u0000\u0000\u02da\u02db\u0003\u00dam\u0000\u02db" +
                    "\u02dc\u0005\u00cd\u0000\u0000\u02dc\u02dd\u0005\u00d4\u0000\u0000\u02dd" +
                    "[\u0001\u0000\u0000\u0000\u02de\u0305\u0005M\u0000\u0000\u02df\u02e0\u0005" +
                    "\u00cc\u0000\u0000\u02e0\u02e1\u0003\u00dcn\u0000\u02e1\u02e3\u0005+\u0000" +
                    "\u0000\u02e2\u02e4\u0005\u00be\u0000\u0000\u02e3\u02e2\u0001\u0000\u0000" +
                    "\u0000\u02e3\u02e4\u0001\u0000\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000" +
                    "\u0000\u02e5\u02eb\u0003\u009cN\u0000\u02e6\u02e8\u0005\u009c\u0000\u0000" +
                    "\u02e7\u02e9\u0005\u00be\u0000\u0000\u02e8\u02e7\u0001\u0000\u0000\u0000" +
                    "\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9\u02ea\u0001\u0000\u0000\u0000" +
                    "\u02ea\u02ec\u0003\u00dcn\u0000\u02eb\u02e6\u0001\u0000\u0000\u0000\u02eb" +
                    "\u02ec\u0001\u0000\u0000\u0000\u02ec\u02ed\u0001\u0000\u0000\u0000\u02ed" +
                    "\u02ee\u0005\u00cd\u0000\u0000\u02ee\u0306\u0001\u0000\u0000\u0000\u02ef" +
                    "\u02f0\u0005\u00cc\u0000\u0000\u02f0\u02f1\u0003\u009aM\u0000\u02f1\u02f2" +
                    "\u0005+\u0000\u0000\u02f2\u02f8\u0003\u009cN\u0000\u02f3\u02f5\u0005\u009c" +
                    "\u0000\u0000\u02f4\u02f6\u0005\u00be\u0000\u0000\u02f5\u02f4\u0001\u0000" +
                    "\u0000\u0000\u02f5\u02f6\u0001\u0000\u0000\u0000\u02f6\u02f7\u0001\u0000" +
                    "\u0000\u0000\u02f7\u02f9\u0003\u00dcn\u0000\u02f8\u02f3\u0001\u0000\u0000" +
                    "\u0000\u02f8\u02f9\u0001\u0000\u0000\u0000\u02f9\u02fa\u0001\u0000\u0000" +
                    "\u0000\u02fa\u02fb\u0005\u00cd\u0000\u0000\u02fb\u0306\u0001\u0000\u0000" +
                    "\u0000\u02fc\u02fd\u0005\u00cc\u0000\u0000\u02fd\u02fe\u0003\u00dcn\u0000" +
                    "\u02fe\u02ff\u0005+\u0000\u0000\u02ff\u0300\u0005^\u0000\u0000\u0300\u0301" +
                    "\u0005\u00cc\u0000\u0000\u0301\u0302\u0003\u00f2y\u0000\u0302\u0303\u0005" +
                    "\u00cd\u0000\u0000\u0303\u0304\u0005\u00cd\u0000\u0000\u0304\u0306\u0001" +
                    "\u0000\u0000\u0000\u0305\u02df\u0001\u0000\u0000\u0000\u0305\u02ef\u0001" +
                    "\u0000\u0000\u0000\u0305\u02fc\u0001\u0000\u0000\u0000\u0306\u030d\u0001" +
                    "\u0000\u0000\u0000\u0307\u030e\u00034\u001a\u0000\u0308\u0309\u0005\u00d3" +
                    "\u0000\u0000\u0309\u030a\u00030\u0018\u0000\u030a\u030b\u0005B\u0000\u0000" +
                    "\u030b\u030c\u0005\u00d4\u0000\u0000\u030c\u030e\u0001\u0000\u0000\u0000" +
                    "\u030d\u0307\u0001\u0000\u0000\u0000\u030d\u0308\u0001\u0000\u0000\u0000" +
                    "\u030e]\u0001\u0000\u0000\u0000\u030f\u0310\u0005v\u0000\u0000\u0310\u0320" +
                    "\u00038\u001c\u0000\u0311\u0313\u0003`0\u0000\u0312\u0311\u0001\u0000" +
                    "\u0000\u0000\u0313\u0314\u0001\u0000\u0000\u0000\u0314\u0312\u0001\u0000" +
                    "\u0000\u0000\u0314\u0315\u0001\u0000\u0000\u0000\u0315\u0317\u0001\u0000" +
                    "\u0000\u0000\u0316\u0318\u0003b1\u0000\u0317\u0316\u0001\u0000\u0000\u0000" +
                    "\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u0321\u0001\u0000\u0000\u0000" +
                    "\u0319\u031b\u0003`0\u0000\u031a\u0319\u0001\u0000\u0000\u0000\u031b\u031e" +
                    "\u0001\u0000\u0000\u0000\u031c\u031a\u0001\u0000\u0000\u0000\u031c\u031d" +
                    "\u0001\u0000\u0000\u0000\u031d\u031f\u0001\u0000\u0000\u0000\u031e\u031c" +
                    "\u0001\u0000\u0000\u0000\u031f\u0321\u0003b1\u0000\u0320\u0312\u0001\u0000" +
                    "\u0000\u0000\u0320\u031c\u0001\u0000\u0000\u0000\u0321_\u0001\u0000\u0000" +
                    "\u0000\u0322\u0323\u00052\u0000\u0000\u0323\u0324\u0005\u00cc\u0000\u0000" +
                    "\u0324\u0329\u0003\u00b4Z\u0000\u0325\u0326\u0005\u00bf\u0000\u0000\u0326" +
                    "\u0328\u0003\u00b4Z\u0000\u0327\u0325\u0001\u0000\u0000\u0000\u0328\u032b" +
                    "\u0001\u0000\u0000\u0000\u0329\u0327\u0001\u0000\u0000\u0000\u0329\u032a" +
                    "\u0001\u0000\u0000\u0000\u032a\u032c\u0001\u0000\u0000\u0000\u032b\u0329" +
                    "\u0001\u0000\u0000\u0000\u032c\u032d\u0005\u00d8\u0000\u0000\u032d\u032e" +
                    "\u0005\u00cd\u0000\u0000\u032e\u032f\u00038\u001c\u0000\u032fa\u0001\u0000" +
                    "\u0000\u0000\u0330\u0331\u0005J\u0000\u0000\u0331\u0332\u00038\u001c\u0000" +
                    "\u0332c\u0001\u0000\u0000\u0000\u0333\u0334\u0005t\u0000\u0000\u0334\u0335" +
                    "\u0003\u009aM\u0000\u0335\u0336\u0005\u00d4\u0000\u0000\u0336e\u0001\u0000" +
                    "\u0000\u0000\u0337\u0338\u0005P\u0000\u0000\u0338\u0339\u0003\u00f8|\u0000" +
                    "\u0339\u033a\u0005\u00d4\u0000\u0000\u033ag\u0001\u0000\u0000\u0000\u033b" +
                    "\u033c\u00057\u0000\u0000\u033c\u033d\u0005\u00cc\u0000\u0000\u033d\u033e" +
                    "\u0003l6\u0000\u033e\u0345\u0005\u00cd\u0000\u0000\u033f\u0346\u00034" +
                    "\u001a\u0000\u0340\u0341\u0005\u00d3\u0000\u0000\u0341\u0342\u00030\u0018" +
                    "\u0000\u0342\u0343\u0005@\u0000\u0000\u0343\u0344\u0005\u00d4\u0000\u0000" +
                    "\u0344\u0346\u0001\u0000\u0000\u0000\u0345\u033f\u0001\u0000\u0000\u0000" +
                    "\u0345\u0340\u0001\u0000\u0000\u0000\u0346i\u0001\u0000\u0000\u0000\u0347" +
                    "\u0349\u0003\u0002\u0001\u0000\u0348\u0347\u0001\u0000\u0000\u0000\u0349" +
                    "\u034a\u0001\u0000\u0000\u0000\u034a\u0348\u0001\u0000\u0000\u0000\u034a" +
                    "\u034b\u0001\u0000\u0000\u0000\u034bk\u0001\u0000\u0000\u0000\u034c\u0351" +
                    "\u0003\u0092I\u0000\u034d\u034e\u0005\u00d2\u0000\u0000\u034e\u0350\u0003" +
                    "\u0092I\u0000\u034f\u034d\u0001\u0000\u0000\u0000\u0350\u0353\u0001\u0000" +
                    "\u0000\u0000\u0351\u034f\u0001\u0000\u0000\u0000\u0351\u0352\u0001\u0000" +
                    "\u0000\u0000\u0352m\u0001\u0000\u0000\u0000\u0353\u0351\u0001\u0000\u0000" +
                    "\u0000\u0354\u0356\u0003p8\u0000\u0355\u0354\u0001\u0000\u0000\u0000\u0355" +
                    "\u0356\u0001\u0000\u0000\u0000\u0356\u035b\u0001\u0000\u0000\u0000\u0357" +
                    "\u0358\u0005\u00d2\u0000\u0000\u0358\u035a\u0003p8\u0000\u0359\u0357\u0001" +
                    "\u0000\u0000\u0000\u035a\u035d\u0001\u0000\u0000\u0000\u035b\u0359\u0001" +
                    "\u0000\u0000\u0000\u035b\u035c\u0001\u0000\u0000\u0000\u035c\u035f\u0001" +
                    "\u0000\u0000\u0000\u035d\u035b\u0001\u0000\u0000\u0000\u035e\u0360\u0005" +
                    "\u00d2\u0000\u0000\u035f\u035e\u0001\u0000\u0000\u0000\u035f\u0360\u0001" +
                    "\u0000\u0000\u0000\u0360o\u0001\u0000\u0000\u0000\u0361\u0363\u0003*\u0015" +
                    "\u0000\u0362\u0361\u0001\u0000\u0000\u0000\u0362\u0363\u0001\u0000\u0000" +
                    "\u0000\u0363\u0365\u0001\u0000\u0000\u0000\u0364\u0366\u0003\u00fa}\u0000" +
                    "\u0365\u0364\u0001\u0000\u0000\u0000\u0365\u0366\u0001\u0000\u0000\u0000" +
                    "\u0366\u0368\u0001\u0000\u0000\u0000\u0367\u0369\u0005\u00cb\u0000\u0000" +
                    "\u0368\u0367\u0001\u0000\u0000\u0000\u0368\u0369\u0001\u0000\u0000\u0000" +
                    "\u0369\u036b\u0001\u0000\u0000\u0000\u036a\u036c\u0003r9\u0000\u036b\u036a" +
                    "\u0001\u0000\u0000\u0000\u036b\u036c\u0001\u0000\u0000\u0000\u036c\u036e" +
                    "\u0001\u0000\u0000\u0000\u036d\u036f\u0005\u00be\u0000\u0000\u036e\u036d" +
                    "\u0001\u0000\u0000\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f\u0371" +
                    "\u0001\u0000\u0000\u0000\u0370\u0372\u0005\u00bb\u0000\u0000\u0371\u0370" +
                    "\u0001\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372\u0373" +
                    "\u0001\u0000\u0000\u0000\u0373\u0374\u0003\u0090H\u0000\u0374q\u0001\u0000" +
                    "\u0000\u0000\u0375\u0376\u00069\uffff\uffff\u0000\u0376\u037a\u0003\u00b4" +
                    "Z\u0000\u0377\u037a\u00050\u0000\u0000\u0378\u037a\u0003\u0100\u0080\u0000" +
                    "\u0379\u0375\u0001\u0000\u0000\u0000\u0379\u0377\u0001\u0000\u0000\u0000" +
                    "\u0379\u0378\u0001\u0000\u0000\u0000\u037a\u0380\u0001\u0000\u0000\u0000" +
                    "\u037b\u037c\n\u0001\u0000\u0000\u037c\u037d\u0005\u00bf\u0000\u0000\u037d" +
                    "\u037f\u0003r9\u0002\u037e\u037b\u0001\u0000\u0000\u0000\u037f\u0382\u0001" +
                    "\u0000\u0000\u0000\u0380\u037e\u0001\u0000\u0000\u0000\u0380\u0381\u0001" +
                    "\u0000\u0000\u0000\u0381s\u0001\u0000\u0000\u0000\u0382\u0380\u0001\u0000" +
                    "\u0000\u0000\u0383\u0384\u0005O\u0000\u0000\u0384\u0389\u0003v;\u0000" +
                    "\u0385\u0386\u0005\u00d2\u0000\u0000\u0386\u0388\u0003v;\u0000\u0387\u0385" +
                    "\u0001\u0000\u0000\u0000\u0388\u038b\u0001\u0000\u0000\u0000\u0389\u0387" +
                    "\u0001\u0000\u0000\u0000\u0389\u038a\u0001\u0000\u0000\u0000\u038a\u038c" +
                    "\u0001\u0000\u0000\u0000\u038b\u0389\u0001\u0000\u0000\u0000\u038c\u038d" +
                    "\u0005\u00d4\u0000\u0000\u038du\u0001\u0000\u0000\u0000\u038e\u0397\u0005" +
                    "\u00d8\u0000\u0000\u038f\u0390\u0005\u00c9\u0000\u0000\u0390\u0397\u0003" +
                    "\u00dcn\u0000\u0391\u0392\u0005\u00c9\u0000\u0000\u0392\u0393\u0005\u00d0" +
                    "\u0000\u0000\u0393\u0394\u0003\u009aM\u0000\u0394\u0395\u0005\u00d1\u0000" +
                    "\u0000\u0395\u0397\u0001\u0000\u0000\u0000\u0396\u038e\u0001\u0000\u0000" +
                    "\u0000\u0396\u038f\u0001\u0000\u0000\u0000\u0396\u0391\u0001\u0000\u0000" +
                    "\u0000\u0397w\u0001\u0000\u0000\u0000\u0398\u0399\u0005<\u0000\u0000\u0399" +
                    "\u039a\u0003\u0096K\u0000\u039a\u039b\u0005\u00d4\u0000\u0000\u039by\u0001" +
                    "\u0000\u0000\u0000\u039c\u039d\u0005q\u0000\u0000\u039d\u03a2\u0003\u0090" +
                    "H\u0000\u039e\u039f\u0005\u00d2\u0000\u0000\u039f\u03a1\u0003\u0090H\u0000" +
                    "\u03a0\u039e\u0001\u0000\u0000\u0000\u03a1\u03a4\u0001\u0000\u0000\u0000" +
                    "\u03a2\u03a0\u0001\u0000\u0000\u0000\u03a2\u03a3\u0001\u0000\u0000\u0000" +
                    "\u03a3\u03a5\u0001\u0000\u0000\u0000\u03a4\u03a2\u0001\u0000\u0000\u0000" +
                    "\u03a5\u03a6\u0005\u00d4\u0000\u0000\u03a6{\u0001\u0000\u0000\u0000\u03a7" +
                    "\u03a9\u0003*\u0015\u0000\u03a8\u03a7\u0001\u0000\u0000\u0000\u03a8\u03a9" +
                    "\u0001\u0000\u0000\u0000\u03a9\u03db\u0001\u0000\u0000\u0000\u03aa\u03ac" +
                    "\u0003\u008cF\u0000\u03ab\u03ad\u0003r9\u0000\u03ac\u03ab\u0001\u0000" +
                    "\u0000\u0000\u03ac\u03ad\u0001\u0000\u0000\u0000\u03ad\u03ae\u0001\u0000" +
                    "\u0000\u0000\u03ae\u03b3\u0003\u0090H\u0000\u03af\u03b0\u0005\u00d2\u0000" +
                    "\u0000\u03b0\u03b2\u0003\u0090H\u0000\u03b1\u03af\u0001\u0000\u0000\u0000" +
                    "\u03b2\u03b5\u0001\u0000\u0000\u0000\u03b3\u03b1\u0001\u0000\u0000\u0000" +
                    "\u03b3\u03b4\u0001\u0000\u0000\u0000\u03b4\u03b6\u0001\u0000\u0000\u0000" +
                    "\u03b5\u03b3\u0001\u0000\u0000\u0000\u03b6\u03b7\u0005\u00d4\u0000\u0000" +
                    "\u03b7\u03dc\u0001\u0000\u0000\u0000\u03b8\u03ba\u0003\u008eG\u0000\u03b9" +
                    "\u03b8\u0001\u0000\u0000\u0000\u03b9\u03ba\u0001\u0000\u0000\u0000\u03ba" +
                    "\u03d9\u0001\u0000\u0000\u0000\u03bb\u03bd\u00055\u0000\u0000\u03bc\u03be" +
                    "\u0003r9\u0000\u03bd\u03bc\u0001\u0000\u0000\u0000\u03bd\u03be\u0001\u0000" +
                    "\u0000\u0000\u03be\u03bf\u0001\u0000\u0000\u0000\u03bf\u03c4\u0003\u0092" +
                    "I\u0000\u03c0\u03c1\u0005\u00d2\u0000\u0000\u03c1\u03c3\u0003\u0092I\u0000" +
                    "\u03c2\u03c0\u0001\u0000\u0000\u0000\u03c3\u03c6\u0001\u0000\u0000\u0000" +
                    "\u03c4\u03c2\u0001\u0000\u0000\u0000\u03c4\u03c5\u0001\u0000\u0000\u0000" +
                    "\u03c5\u03c7\u0001\u0000\u0000\u0000\u03c6\u03c4\u0001\u0000\u0000\u0000" +
                    "\u03c7\u03c8\u0005\u00d4\u0000\u0000\u03c8\u03da\u0001\u0000\u0000\u0000" +
                    "\u03c9\u03cb\u0005N\u0000\u0000\u03ca\u03cc\u0005\u00be\u0000\u0000\u03cb" +
                    "\u03ca\u0001\u0000\u0000\u0000\u03cb\u03cc\u0001\u0000\u0000\u0000\u03cc" +
                    "\u03cd\u0001\u0000\u0000\u0000\u03cd\u03cf\u0003\u00f8|\u0000\u03ce\u03d0" +
                    "\u0003\u001e\u000f\u0000\u03cf\u03ce\u0001\u0000\u0000\u0000\u03cf\u03d0" +
                    "\u0001\u0000\u0000\u0000\u03d0\u03d1\u0001\u0000\u0000\u0000\u03d1\u03d2" +
                    "\u0005\u00cc\u0000\u0000\u03d2\u03d3\u0003n7\u0000\u03d3\u03d5\u0005\u00cd" +
                    "\u0000\u0000\u03d4\u03d6\u0003\u0088D\u0000\u03d5\u03d4\u0001\u0000\u0000" +
                    "\u0000\u03d5\u03d6\u0001\u0000\u0000\u0000\u03d6\u03d7\u0001\u0000\u0000" +
                    "\u0000\u03d7\u03d8\u0003\u008aE\u0000\u03d8\u03da\u0001\u0000\u0000\u0000" +
                    "\u03d9\u03bb\u0001\u0000\u0000\u0000\u03d9\u03c9\u0001\u0000\u0000\u0000" +
                    "\u03da\u03dc\u0001\u0000\u0000\u0000\u03db\u03aa\u0001\u0000\u0000\u0000" +
                    "\u03db\u03b9\u0001\u0000\u0000\u0000\u03dc\u03e2\u0001\u0000\u0000\u0000" +
                    "\u03dd\u03de\u0005{\u0000\u0000\u03de\u03df\u0003\u00c2a\u0000\u03df\u03e0" +
                    "\u0003~?\u0000\u03e0\u03e2\u0001\u0000\u0000\u0000\u03e1\u03a8\u0001\u0000" +
                    "\u0000\u0000\u03e1\u03dd\u0001\u0000\u0000\u0000\u03e2}\u0001\u0000\u0000" +
                    "\u0000\u03e3\u03ed\u0005\u00d4\u0000\u0000\u03e4\u03e8\u0005\u00d0\u0000" +
                    "\u0000\u03e5\u03e7\u0003\u0080@\u0000\u03e6\u03e5\u0001\u0000\u0000\u0000" +
                    "\u03e7\u03ea\u0001\u0000\u0000\u0000\u03e8\u03e6\u0001\u0000\u0000\u0000" +
                    "\u03e8\u03e9\u0001\u0000\u0000\u0000\u03e9\u03eb\u0001\u0000\u0000\u0000" +
                    "\u03ea\u03e8\u0001\u0000\u0000\u0000\u03eb\u03ed\u0005\u00d1\u0000\u0000" +
                    "\u03ec\u03e3\u0001\u0000\u0000\u0000\u03ec\u03e4\u0001\u0000\u0000\u0000" +
                    "\u03ed\u007f\u0001\u0000\u0000\u0000\u03ee\u03f1\u0003\u0082A\u0000\u03ef" +
                    "\u03f1\u0003\u0084B\u0000\u03f0\u03ee\u0001\u0000\u0000\u0000\u03f0\u03ef" +
                    "\u0001\u0000\u0000\u0000\u03f1\u0081\u0001\u0000\u0000\u0000\u03f2\u03f3" +
                    "\u0003\u00bc^\u0000\u03f3\u03f4\u0005\u00b8\u0000\u0000\u03f4\u03f5\u0003" +
                    "\u00f8|\u0000\u03f5\u03f6\u0005W\u0000\u0000\u03f6\u03f7\u0003\u00c2a" +
                    "\u0000\u03f7\u03f8\u0005\u00d4\u0000\u0000\u03f8\u0083\u0001\u0000\u0000" +
                    "\u0000\u03f9\u03fa\u0003\u0086C\u0000\u03fa\u0400\u0005+\u0000\u0000\u03fb" +
                    "\u0401\u0003\u00fa}\u0000\u03fc\u03fe\u0003\u00fa}\u0000\u03fd\u03fc\u0001" +
                    "\u0000\u0000\u0000\u03fd\u03fe\u0001\u0000\u0000\u0000\u03fe\u03ff\u0001" +
                    "\u0000\u0000\u0000\u03ff\u0401\u0003\u00f8|\u0000\u0400\u03fb\u0001\u0000" +
                    "\u0000\u0000\u0400\u03fd\u0001\u0000\u0000\u0000\u0401\u0402\u0001\u0000" +
                    "\u0000\u0000\u0402\u0403\u0005\u00d4\u0000\u0000\u0403\u0085\u0001\u0000" +
                    "\u0000\u0000\u0404\u0405\u0003\u00bc^\u0000\u0405\u0406\u0005\u00b8\u0000" +
                    "\u0000\u0406\u0408\u0001\u0000\u0000\u0000\u0407\u0404\u0001\u0000\u0000" +
                    "\u0000\u0407\u0408\u0001\u0000\u0000\u0000\u0408\u0409\u0001\u0000\u0000" +
                    "\u0000\u0409\u040a\u0003\u00f8|\u0000\u040a\u0087\u0001\u0000\u0000\u0000" +
                    "\u040b\u040c\u0005\u00d3\u0000\u0000\u040c\u040e\u0003\u00f8|\u0000\u040d" +
                    "\u040f\u0003\u00c4b\u0000\u040e\u040d\u0001\u0000\u0000\u0000\u040e\u040f" +
                    "\u0001\u0000\u0000\u0000\u040f\u0089\u0001\u0000\u0000\u0000\u0410\u0413" +
                    "\u0005\u00d4\u0000\u0000\u0411\u0413\u00038\u001c\u0000\u0412\u0410\u0001" +
                    "\u0000\u0000\u0000\u0412\u0411\u0001\u0000\u0000\u0000\u0413\u008b\u0001" +
                    "\u0000\u0000\u0000\u0414\u0417\u0003\u008eG\u0000\u0415\u0417\u0005|\u0000" +
                    "\u0000\u0416\u0414\u0001\u0000\u0000\u0000\u0416\u0415\u0001\u0000\u0000" +
                    "\u0000\u0417\u008d\u0001\u0000\u0000\u0000\u0418\u041a\u0003\u00fa}\u0000" +
                    "\u0419\u0418\u0001\u0000\u0000\u0000\u041a\u041b\u0001\u0000\u0000\u0000" +
                    "\u041b\u0419\u0001\u0000\u0000\u0000\u041b\u041c\u0001\u0000\u0000\u0000" +
                    "\u041c\u008f\u0001\u0000\u0000\u0000\u041d\u0420\u0005\u00d8\u0000\u0000" +
                    "\u041e\u041f\u0005\u00d5\u0000\u0000\u041f\u0421\u0003\u00cae\u0000\u0420" +
                    "\u041e\u0001\u0000\u0000\u0000\u0420\u0421\u0001\u0000\u0000\u0000\u0421" +
                    "\u0091\u0001\u0000\u0000\u0000\u0422\u0423\u0003\u00f8|\u0000\u0423\u0424" +
                    "\u0005\u00d5\u0000\u0000\u0424\u0425\u0003\u00cae\u0000\u0425\u0093\u0001" +
                    "\u0000\u0000\u0000\u0426\u0428\u0003*\u0015\u0000\u0427\u0426\u0001\u0000" +
                    "\u0000\u0000\u0427\u0428\u0001\u0000\u0000\u0000\u0428\u0429\u0001\u0000" +
                    "\u0000\u0000\u0429\u042a\u00055\u0000\u0000\u042a\u042f\u0003\u0092I\u0000" +
                    "\u042b\u042c\u0005\u00d2\u0000\u0000\u042c\u042e\u0003\u0092I\u0000\u042d" +
                    "\u042b\u0001\u0000\u0000\u0000\u042e\u0431\u0001\u0000\u0000\u0000\u042f" +
                    "\u042d\u0001\u0000\u0000\u0000\u042f\u0430\u0001\u0000\u0000\u0000\u0430" +
                    "\u0432\u0001\u0000\u0000\u0000\u0431\u042f\u0001\u0000\u0000\u0000\u0432" +
                    "\u0433\u0005\u00d4\u0000\u0000\u0433\u0095\u0001\u0000\u0000\u0000\u0434" +
                    "\u0439\u0003\u009aM\u0000\u0435\u0436\u0005\u00d2\u0000\u0000\u0436\u0438" +
                    "\u0003\u009aM\u0000\u0437\u0435\u0001\u0000\u0000\u0000\u0438\u043b\u0001" +
                    "\u0000\u0000\u0000\u0439\u0437\u0001\u0000\u0000\u0000\u0439\u043a\u0001" +
                    "\u0000\u0000\u0000\u043a\u0097\u0001\u0000\u0000\u0000\u043b\u0439\u0001" +
                    "\u0000\u0000\u0000\u043c\u043f\u0005\u00cc\u0000\u0000\u043d\u0440\u0003" +
                    "\u009aM\u0000\u043e\u0440\u0003\u00aaU\u0000\u043f\u043d\u0001\u0000\u0000" +
                    "\u0000\u043f\u043e\u0001\u0000\u0000\u0000\u0440\u0441\u0001\u0000\u0000" +
                    "\u0000\u0441\u0442\u0005\u00cd\u0000\u0000\u0442\u0099\u0001\u0000\u0000" +
                    "\u0000\u0443\u0444\u0006M\uffff\uffff\u0000\u0444\u0445\u00054\u0000\u0000" +
                    "\u0445\u049a\u0003\u009aM/\u0446\u049a\u0003\u00a6S\u0000\u0447\u0448" +
                    "\u0003\u00d4j\u0000\u0448\u0449\u0005\u00ce\u0000\u0000\u0449\u044a\u0003" +
                    "\u009aM\u0000\u044a\u044b\u0005\u00cf\u0000\u0000\u044b\u049a\u0001\u0000" +
                    "\u0000\u0000\u044c\u044d\u0005\u00cc\u0000\u0000\u044d\u044e\u0003\u0102" +
                    "\u0081\u0000\u044e\u044f\u0005\u00cd\u0000\u0000\u044f\u0450\u0003\u009a" +
                    "M,\u0450\u049a\u0001\u0000\u0000\u0000\u0451\u0452\u0007\u0003\u0000\u0000" +
                    "\u0452\u049a\u0003\u009aM+\u0453\u0454\u0007\u0004\u0000\u0000\u0454\u049a" +
                    "\u0003\u009aM*\u0455\u0456\u0007\u0005\u0000\u0000\u0456\u049a\u0003\u00dc" +
                    "n\u0000\u0457\u0458\u0003\u00dcn\u0000\u0458\u0459\u0007\u0005\u0000\u0000" +
                    "\u0459\u049a\u0001\u0000\u0000\u0000\u045a\u045b\u0005i\u0000\u0000\u045b" +
                    "\u049a\u0003\u009aM\'\u045c\u049a\u0003\u009eO\u0000\u045d\u049a\u0003" +
                    "\u00dcn\u0000\u045e\u049a\u0003\u00ccf\u0000\u045f\u049a\u0003\u00d6k" +
                    "\u0000\u0460\u049a\u0005\u00d9\u0000\u0000\u0461\u049a\u0005\u00df\u0000" +
                    "\u0000\u0462\u049a\u0003\u0098L\u0000\u0463\u049a\u0005~\u0000\u0000\u0464" +
                    "\u0465\u0005^\u0000\u0000\u0465\u0466\u0005\u00cc\u0000\u0000\u0466\u0467" +
                    "\u0003\u00f2y\u0000\u0467\u0468\u0005\u00cd\u0000\u0000\u0468\u0469\u0005" +
                    "\u00d5\u0000\u0000\u0469\u046a\u0003\u009aM\u001e\u046a\u049a\u0001\u0000" +
                    "\u0000\u0000\u046b\u046c\u0005]\u0000\u0000\u046c\u046d\u0005\u00cc\u0000" +
                    "\u0000\u046d\u046e\u0003\u00dam\u0000\u046e\u046f\u0005\u00cd\u0000\u0000" +
                    "\u046f\u049a\u0001\u0000\u0000\u0000\u0470\u0471\u0005?\u0000\u0000\u0471" +
                    "\u0472\u0005\u00cc\u0000\u0000\u0472\u0473\u0003\u00dcn\u0000\u0473\u0474" +
                    "\u0005\u00cd\u0000\u0000\u0474\u049a\u0001\u0000\u0000\u0000\u0475\u0476" +
                    "\u0005F\u0000\u0000\u0476\u0477\u0005\u00cc\u0000\u0000\u0477\u0478\u0003" +
                    "\u009aM\u0000\u0478\u0479\u0005\u00cd\u0000\u0000\u0479\u049a\u0001\u0000" +
                    "\u0000\u0000\u047a\u047e\u0005G\u0000\u0000\u047b\u047c\u0005\u00cc\u0000" +
                    "\u0000\u047c\u047f\u0005\u00cd\u0000\u0000\u047d\u047f\u0003\u0098L\u0000" +
                    "\u047e\u047b\u0001\u0000\u0000\u0000\u047e\u047d\u0001\u0000\u0000\u0000" +
                    "\u047e\u047f\u0001\u0000\u0000\u0000\u047f\u049a\u0001\u0000\u0000\u0000" +
                    "\u0480\u0481\u0007\u0006\u0000\u0000\u0481\u049a\u0003\u009aM\u0019\u0482" +
                    "\u0483\u0007\u0007\u0000\u0000\u0483\u049a\u0003\u009aM\u0018\u0484\u049a" +
                    "\u0003\u00a0P\u0000\u0485\u049a\u0003\u00a2Q\u0000\u0486\u0487\u0005t" +
                    "\u0000\u0000\u0487\u049a\u0003\u009aM\u0006\u0488\u0489\u0003\u009cN\u0000" +
                    "\u0489\u048b\u0003\u00a8T\u0000\u048a\u048c\u0003*\u0015\u0000\u048b\u048a" +
                    "\u0001\u0000\u0000\u0000\u048b\u048c\u0001\u0000\u0000\u0000\u048c\u048d" +
                    "\u0001\u0000\u0000\u0000\u048d\u048e\u0003\u009aM\u0005\u048e\u049a\u0001" +
                    "\u0000\u0000\u0000\u048f\u0490\u0003\u009cN\u0000\u0490\u0492\u0005\u00d5" +
                    "\u0000\u0000\u0491\u0493\u0003*\u0015\u0000\u0492\u0491\u0001\u0000\u0000" +
                    "\u0000\u0492\u0493\u0001\u0000\u0000\u0000\u0493\u0494\u0001\u0000\u0000" +
                    "\u0000\u0494\u0497\u0005\u00be\u0000\u0000\u0495\u0498\u0003\u00dcn\u0000" +
                    "\u0496\u0498\u0003\u00a6S\u0000\u0497\u0495\u0001\u0000\u0000\u0000\u0497" +
                    "\u0496\u0001\u0000\u0000\u0000\u0498\u049a\u0001\u0000\u0000\u0000\u0499" +
                    "\u0443\u0001\u0000\u0000\u0000\u0499\u0446\u0001\u0000\u0000\u0000\u0499" +
                    "\u0447\u0001\u0000\u0000\u0000\u0499\u044c\u0001\u0000\u0000\u0000\u0499" +
                    "\u0451\u0001\u0000\u0000\u0000\u0499\u0453\u0001\u0000\u0000\u0000\u0499" +
                    "\u0455\u0001\u0000\u0000\u0000\u0499\u0457\u0001\u0000\u0000\u0000\u0499" +
                    "\u045a\u0001\u0000\u0000\u0000\u0499\u045c\u0001\u0000\u0000\u0000\u0499" +
                    "\u045d\u0001\u0000\u0000\u0000\u0499\u045e\u0001\u0000\u0000\u0000\u0499" +
                    "\u045f\u0001\u0000\u0000\u0000\u0499\u0460\u0001\u0000\u0000\u0000\u0499" +
                    "\u0461\u0001\u0000\u0000\u0000\u0499\u0462\u0001\u0000\u0000\u0000\u0499" +
                    "\u0463\u0001\u0000\u0000\u0000\u0499\u0464\u0001\u0000\u0000\u0000\u0499" +
                    "\u046b\u0001\u0000\u0000\u0000\u0499\u0470\u0001\u0000\u0000\u0000\u0499" +
                    "\u0475\u0001\u0000\u0000\u0000\u0499\u047a\u0001\u0000\u0000\u0000\u0499" +
                    "\u0480\u0001\u0000\u0000\u0000\u0499\u0482\u0001\u0000\u0000\u0000\u0499" +
                    "\u0484\u0001\u0000\u0000\u0000\u0499\u0485\u0001\u0000\u0000\u0000\u0499" +
                    "\u0486\u0001\u0000\u0000\u0000\u0499\u0488\u0001\u0000\u0000\u0000\u0499" +
                    "\u048f\u0001\u0000\u0000\u0000\u049a\u04d7\u0001\u0000\u0000\u0000\u049b" +
                    "\u049c\n\u0015\u0000\u0000\u049c\u049d\u0005\u00a8\u0000\u0000\u049d\u04d6" +
                    "\u0003\u009aM\u0015\u049e\u049f\n\u0013\u0000\u0000\u049f\u04a0\u0007" +
                    "\b\u0000\u0000\u04a0\u04d6\u0003\u009aM\u0014\u04a1\u04a2\n\u0012\u0000" +
                    "\u0000\u04a2\u04a3\u0007\t\u0000\u0000\u04a3\u04d6\u0003\u009aM\u0013" +
                    "\u04a4\u04a5\n\u0011\u0000\u0000\u04a5\u04a6\u0007\n\u0000\u0000\u04a6" +
                    "\u04d6\u0003\u009aM\u0012\u04a7\u04a8\n\u0010\u0000\u0000\u04a8\u04a9" +
                    "\u0007\u000b\u0000\u0000\u04a9\u04d6\u0003\u009aM\u0011\u04aa\u04ab\n" +
                    "\u000f\u0000\u0000\u04ab\u04ac\u0007\f\u0000\u0000\u04ac\u04d6\u0003\u009a" +
                    "M\u0010\u04ad\u04ae\n\u000e\u0000\u0000\u04ae\u04af\u0005\u00be\u0000" +
                    "\u0000\u04af\u04d6\u0003\u009aM\u000f\u04b0\u04b1\n\r\u0000\u0000\u04b1" +
                    "\u04b2\u0005\u00c1\u0000\u0000\u04b2\u04d6\u0003\u009aM\u000e\u04b3\u04b4" +
                    "\n\f\u0000\u0000\u04b4\u04b5\u0005\u00bf\u0000\u0000\u04b5\u04d6\u0003" +
                    "\u009aM\r\u04b6\u04b7\n\u000b\u0000\u0000\u04b7\u04b8\u0005\u00b3\u0000" +
                    "\u0000\u04b8\u04d6\u0003\u009aM\f\u04b9\u04ba\n\n\u0000\u0000\u04ba\u04bb" +
                    "\u0005\u00b2\u0000\u0000\u04bb\u04d6\u0003\u009aM\u000b\u04bc\u04bd\n" +
                    "\t\u0000\u0000\u04bd\u04bf\u0005\u00cb\u0000\u0000\u04be\u04c0\u0003\u009a" +
                    "M\u0000\u04bf\u04be\u0001\u0000\u0000\u0000\u04bf\u04c0\u0001\u0000\u0000" +
                    "\u0000\u04c0\u04c1\u0001\u0000\u0000\u0000\u04c1\u04c2\u0005\u00d3\u0000" +
                    "\u0000\u04c2\u04d6\u0003\u009aM\n\u04c3\u04c4\n\b\u0000\u0000\u04c4\u04c5" +
                    "\u0005\u00b4\u0000\u0000\u04c5\u04d6\u0003\u009aM\t\u04c6\u04c7\n\u0007" +
                    "\u0000\u0000\u04c7\u04c8\u0005\u0099\u0000\u0000\u04c8\u04d6\u0003\u009a" +
                    "M\b\u04c9\u04ca\n\u0003\u0000\u0000\u04ca\u04cb\u0005_\u0000\u0000\u04cb" +
                    "\u04d6\u0003\u009aM\u0004\u04cc\u04cd\n\u0002\u0000\u0000\u04cd\u04ce" +
                    "\u0005a\u0000\u0000\u04ce\u04d6\u0003\u009aM\u0003\u04cf\u04d0\n\u0001" +
                    "\u0000\u0000\u04d0\u04d1\u0005`\u0000\u0000\u04d1\u04d6\u0003\u009aM\u0002" +
                    "\u04d2\u04d3\n\u0014\u0000\u0000\u04d3\u04d4\u0005V\u0000\u0000\u04d4" +
                    "\u04d6\u0003\u00b6[\u0000\u04d5\u049b\u0001\u0000\u0000\u0000\u04d5\u049e" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04a1\u0001\u0000\u0000\u0000\u04d5\u04a4" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04a7\u0001\u0000\u0000\u0000\u04d5\u04aa" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04ad\u0001\u0000\u0000\u0000\u04d5\u04b0" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04b3\u0001\u0000\u0000\u0000\u04d5\u04b6" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04b9\u0001\u0000\u0000\u0000\u04d5\u04bc" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04c3\u0001\u0000\u0000\u0000\u04d5\u04c6" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04c9\u0001\u0000\u0000\u0000\u04d5\u04cc" +
                    "\u0001\u0000\u0000\u0000\u04d5\u04cf\u0001\u0000\u0000\u0000\u04d5\u04d2" +
                    "\u0001\u0000\u0000\u0000\u04d6\u04d9\u0001\u0000\u0000\u0000\u04d7\u04d5" +
                    "\u0001\u0000\u0000\u0000\u04d7\u04d8\u0001\u0000\u0000\u0000\u04d8\u009b" +
                    "\u0001\u0000\u0000\u0000\u04d9\u04d7\u0001\u0000\u0000\u0000\u04da\u04dd" +
                    "\u0003\u00dcn\u0000\u04db\u04dd\u0003\u009eO\u0000\u04dc\u04da\u0001\u0000" +
                    "\u0000\u0000\u04dc\u04db\u0001\u0000\u0000\u0000\u04dd\u009d\u0001\u0000" +
                    "\u0000\u0000\u04de\u04df\u0005*\u0000\u0000\u04df\u04e1\u0005\u00cc\u0000" +
                    "\u0000\u04e0\u04e2\u0003\u00acV\u0000\u04e1\u04e0\u0001\u0000\u0000\u0000" +
                    "\u04e1\u04e2\u0001\u0000\u0000\u0000\u04e2\u04e3\u0001\u0000\u0000\u0000" +
                    "\u04e3\u04ea\u0005\u00cd\u0000\u0000\u04e4\u04e6\u0005\u00ce\u0000\u0000" +
                    "\u04e5\u04e7\u0003\u00acV\u0000\u04e6\u04e5\u0001\u0000\u0000\u0000\u04e6" +
                    "\u04e7\u0001\u0000\u0000\u0000\u04e7\u04e8\u0001\u0000\u0000\u0000\u04e8" +
                    "\u04ea\u0005\u00cf\u0000\u0000\u04e9\u04de\u0001\u0000\u0000\u0000\u04e9" +
                    "\u04e4\u0001\u0000\u0000\u0000\u04ea\u04ef\u0001\u0000\u0000\u0000\u04eb" +
                    "\u04ec\u0005\u00ce\u0000\u0000\u04ec\u04ed\u0003\u009aM\u0000\u04ed\u04ee" +
                    "\u0005\u00cf\u0000\u0000\u04ee\u04f0\u0001\u0000\u0000\u0000\u04ef\u04eb" +
                    "\u0001\u0000\u0000\u0000\u04ef\u04f0\u0001\u0000\u0000\u0000\u04f0\u009f" +
                    "\u0001\u0000\u0000\u0000\u04f1\u04f3\u0005q\u0000\u0000\u04f2\u04f1\u0001" +
                    "\u0000\u0000\u0000\u04f2\u04f3\u0001\u0000\u0000\u0000\u04f3\u04f4\u0001" +
                    "\u0000\u0000\u0000\u04f4\u04f6\u0005N\u0000\u0000\u04f5\u04f7\u0005\u00be" +
                    "\u0000\u0000\u04f6\u04f5\u0001\u0000\u0000\u0000\u04f6\u04f7\u0001\u0000" +
                    "\u0000\u0000\u04f7\u04f8\u0001\u0000\u0000\u0000\u04f8\u04f9\u0005\u00cc" +
                    "\u0000\u0000\u04f9\u04fa\u0003n7\u0000\u04fa\u04fc\u0005\u00cd\u0000\u0000" +
                    "\u04fb\u04fd\u0003\u00b0X\u0000\u04fc\u04fb\u0001\u0000\u0000\u0000\u04fc" +
                    "\u04fd\u0001\u0000\u0000\u0000\u04fd\u0500\u0001\u0000\u0000\u0000\u04fe" +
                    "\u04ff\u0005\u00d3\u0000\u0000\u04ff\u0501\u0003r9\u0000\u0500\u04fe\u0001" +
                    "\u0000\u0000\u0000\u0500\u0501\u0001\u0000\u0000\u0000\u0501\u0502\u0001" +
                    "\u0000\u0000\u0000\u0502\u0503\u00038\u001c\u0000\u0503\u050c\u0001\u0000" +
                    "\u0000\u0000\u0504\u0505\u0005\u0080\u0000\u0000\u0505\u0506\u0005\u00cc" +
                    "\u0000\u0000\u0506\u0507\u0003n7\u0000\u0507\u0508\u0005\u00cd\u0000\u0000" +
                    "\u0508\u0509\u0005\u009c\u0000\u0000\u0509\u050a\u0003\u009aM\u0000\u050a" +
                    "\u050c\u0001\u0000\u0000\u0000\u050b\u04f2\u0001\u0000\u0000\u0000\u050b" +
                    "\u0504\u0001\u0000\u0000\u0000\u050c\u00a1\u0001\u0000\u0000\u0000\u050d" +
                    "\u050e\u0005b\u0000\u0000\u050e\u050f\u0005\u00cc\u0000\u0000\u050f\u0510" +
                    "\u0003\u009aM\u0000\u0510\u0511\u0005\u00cd\u0000\u0000\u0511\u0512\u0005" +
                    "\u00d0\u0000\u0000\u0512\u0517\u0003\u00a4R\u0000\u0513\u0514\u0005\u00d2" +
                    "\u0000\u0000\u0514\u0516\u0003\u00a4R\u0000\u0515\u0513\u0001\u0000\u0000" +
                    "\u0000\u0516\u0519\u0001\u0000\u0000\u0000\u0517\u0515\u0001\u0000\u0000" +
                    "\u0000\u0517\u0518\u0001\u0000\u0000\u0000\u0518\u051b\u0001\u0000\u0000" +
                    "\u0000\u0519\u0517\u0001\u0000\u0000\u0000\u051a\u051c\u0005\u00d2\u0000" +
                    "\u0000\u051b\u051a\u0001\u0000\u0000\u0000\u051b\u051c\u0001\u0000\u0000" +
                    "\u0000\u051c\u051d\u0001\u0000\u0000\u0000\u051d\u051e\u0005\u00d1\u0000" +
                    "\u0000\u051e\u00a3\u0001\u0000\u0000\u0000\u051f\u0524\u0003\u009aM\u0000" +
                    "\u0520\u0521\u0005\u00d2\u0000\u0000\u0521\u0523\u0003\u009aM\u0000\u0522" +
                    "\u0520\u0001\u0000\u0000\u0000\u0523\u0526\u0001\u0000\u0000\u0000\u0524" +
                    "\u0522\u0001\u0000\u0000\u0000\u0524\u0525\u0001\u0000\u0000\u0000\u0525" +
                    "\u0527\u0001\u0000\u0000\u0000\u0526\u0524\u0001\u0000\u0000\u0000\u0527" +
                    "\u0528\u0005\u009c\u0000\u0000\u0528\u0529\u0003\u009aM\u0000\u0529\u00a5" +
                    "\u0001\u0000\u0000\u0000\u052a\u052b\u0005d\u0000\u0000\u052b\u052d\u0003" +
                    "\u00b6[\u0000\u052c\u052e\u0003\u00c4b\u0000\u052d\u052c\u0001\u0000\u0000" +
                    "\u0000\u052d\u052e\u0001\u0000\u0000\u0000\u052e\u00a7\u0001\u0000\u0000" +
                    "\u0000\u052f\u0530\u0007\r\u0000\u0000\u0530\u00a9\u0001\u0000\u0000\u0000" +
                    "\u0531\u0539\u0005~\u0000\u0000\u0532\u0535\u0003\u009aM\u0000\u0533\u0534" +
                    "\u0005\u009c\u0000\u0000\u0534\u0536\u0003\u009aM\u0000\u0535\u0533\u0001" +
                    "\u0000\u0000\u0000\u0535\u0536\u0001\u0000\u0000\u0000\u0536\u053a\u0001" +
                    "\u0000\u0000\u0000\u0537\u0538\u0005\u007f\u0000\u0000\u0538\u053a\u0003" +
                    "\u009aM\u0000\u0539\u0532\u0001\u0000\u0000\u0000\u0539\u0537\u0001\u0000" +
                    "\u0000\u0000\u053a\u00ab\u0001\u0000\u0000\u0000\u053b\u0540\u0003\u00ae" +
                    "W\u0000\u053c\u053d\u0005\u00d2\u0000\u0000\u053d\u053f\u0003\u00aeW\u0000" +
                    "\u053e\u053c\u0001\u0000\u0000\u0000\u053f\u0542\u0001\u0000\u0000\u0000" +
                    "\u0540\u053e\u0001\u0000\u0000\u0000\u0540\u0541\u0001\u0000\u0000\u0000" +
                    "\u0541\u0544\u0001\u0000\u0000\u0000\u0542\u0540\u0001\u0000\u0000\u0000" +
                    "\u0543\u0545\u0005\u00d2\u0000\u0000\u0544\u0543\u0001\u0000\u0000\u0000" +
                    "\u0544\u0545\u0001\u0000\u0000\u0000\u0545\u00ad\u0001\u0000\u0000\u0000" +
                    "\u0546\u0549\u0003\u009aM\u0000\u0547\u0548\u0005\u009c\u0000\u0000\u0548" +
                    "\u054a\u0003\u009aM\u0000\u0549\u0547\u0001\u0000\u0000\u0000\u0549\u054a" +
                    "\u0001\u0000\u0000\u0000\u054a\u0553\u0001\u0000\u0000\u0000\u054b\u054c" +
                    "\u0003\u009aM\u0000\u054c\u054d\u0005\u009c\u0000\u0000\u054d\u054f\u0001" +
                    "\u0000\u0000\u0000\u054e\u054b\u0001\u0000\u0000\u0000\u054e\u054f\u0001" +
                    "\u0000\u0000\u0000\u054f\u0550\u0001\u0000\u0000\u0000\u0550\u0551\u0005" +
                    "\u00be\u0000\u0000\u0551\u0553\u0003\u00dcn\u0000\u0552\u0546\u0001\u0000" +
                    "\u0000\u0000\u0552\u054e\u0001\u0000\u0000\u0000\u0553\u00af\u0001\u0000" +
                    "\u0000\u0000\u0554\u0555\u0005{\u0000\u0000\u0555\u0556\u0005\u00cc\u0000" +
                    "\u0000\u0556\u055b\u0003\u00b2Y\u0000\u0557\u0558\u0005\u00d2\u0000\u0000" +
                    "\u0558\u055a\u0003\u00b2Y\u0000\u0559\u0557\u0001\u0000\u0000\u0000\u055a" +
                    "\u055d\u0001\u0000\u0000\u0000\u055b\u0559\u0001\u0000\u0000\u0000\u055b" +
                    "\u055c\u0001\u0000\u0000\u0000\u055c\u055e\u0001\u0000\u0000\u0000\u055d" +
                    "\u055b\u0001\u0000\u0000\u0000\u055e\u055f\u0005\u00cd\u0000\u0000\u055f" +
                    "\u00b1\u0001\u0000\u0000\u0000\u0560\u0562\u0005\u00be\u0000\u0000\u0561" +
                    "\u0560\u0001\u0000\u0000\u0000\u0561\u0562\u0001\u0000\u0000\u0000\u0562" +
                    "\u0563\u0001\u0000\u0000\u0000\u0563\u0564\u0005\u00d8\u0000\u0000\u0564" +
                    "\u00b3\u0001\u0000\u0000\u0000\u0565\u0567\u0003\u00bc^\u0000\u0566\u0568" +
                    "\u0003(\u0014\u0000\u0567\u0566\u0001\u0000\u0000\u0000\u0567\u0568\u0001" +
                    "\u0000\u0000\u0000\u0568\u056b\u0001\u0000\u0000\u0000\u0569\u056b\u0005" +
                    "q\u0000\u0000\u056a\u0565\u0001\u0000\u0000\u0000\u056a\u0569\u0001\u0000" +
                    "\u0000\u0000\u056b\u00b5\u0001\u0000\u0000\u0000\u056c\u056f\u0003\u00bc" +
                    "^\u0000\u056d\u056f\u0003\u00ba]\u0000\u056e\u056c\u0001\u0000\u0000\u0000" +
                    "\u056e\u056d\u0001\u0000\u0000\u0000\u056f\u0571\u0001\u0000\u0000\u0000" +
                    "\u0570\u0572\u0003(\u0014\u0000\u0571\u0570\u0001\u0000\u0000\u0000\u0571" +
                    "\u0572\u0001\u0000\u0000\u0000\u0572\u0577\u0001\u0000\u0000\u0000\u0573" +
                    "\u0577\u0003\u0100\u0080\u0000\u0574\u0577\u0005q\u0000\u0000\u0575\u0577" +
                    "\u0003\u00b8\\\u0000\u0576\u056e\u0001\u0000\u0000\u0000\u0576\u0573\u0001" +
                    "\u0000\u0000\u0000\u0576\u0574\u0001\u0000\u0000\u0000\u0576\u0575\u0001" +
                    "\u0000\u0000\u0000\u0577\u00b7\u0001\u0000\u0000\u0000\u0578\u057a\u0003" +
                    "*\u0015\u0000\u0579\u0578\u0001\u0000\u0000\u0000\u0579\u057a\u0001\u0000" +
                    "\u0000\u0000\u057a\u057c\u0001\u0000\u0000\u0000\u057b\u057d\u0005j\u0000" +
                    "\u0000\u057c\u057b\u0001\u0000\u0000\u0000\u057c\u057d\u0001\u0000\u0000" +
                    "\u0000\u057d\u057f\u0001\u0000\u0000\u0000\u057e\u0580\u0003\u00f6{\u0000" +
                    "\u057f\u057e\u0001\u0000\u0000\u0000\u057f\u0580\u0001\u0000\u0000\u0000" +
                    "\u0580\u0582\u0001\u0000\u0000\u0000\u0581\u0583\u0005h\u0000\u0000\u0582" +
                    "\u0581\u0001\u0000\u0000\u0000\u0582\u0583\u0001\u0000\u0000\u0000\u0583" +
                    "\u0599\u0001\u0000\u0000\u0000\u0584\u0586\u0003\u001a\r\u0000\u0585\u0587" +
                    "\u0003\u001e\u000f\u0000\u0586\u0585\u0001\u0000\u0000\u0000\u0586\u0587" +
                    "\u0001\u0000\u0000\u0000\u0587\u058a\u0001\u0000\u0000\u0000\u0588\u0589" +
                    "\u0005H\u0000\u0000\u0589\u058b\u0003\u00b4Z\u0000\u058a\u0588\u0001\u0000" +
                    "\u0000\u0000\u058a\u058b\u0001\u0000\u0000\u0000\u058b\u058e\u0001\u0000" +
                    "\u0000\u0000\u058c\u058d\u0005R\u0000\u0000\u058d\u058f\u0003\u001c\u000e" +
                    "\u0000\u058e\u058c\u0001\u0000\u0000\u0000\u058e\u058f\u0001\u0000\u0000" +
                    "\u0000\u058f\u059a\u0001\u0000\u0000\u0000\u0590\u0591\u0005\\\u0000\u0000" +
                    "\u0591\u0593\u0003\u00f8|\u0000\u0592\u0594\u0003\u001e\u000f\u0000\u0593" +
                    "\u0592\u0001\u0000\u0000\u0000\u0593\u0594\u0001\u0000\u0000\u0000\u0594" +
                    "\u0597\u0001\u0000\u0000\u0000\u0595\u0596\u0005H\u0000\u0000\u0596\u0598" +
                    "\u0003\u001c\u000e\u0000\u0597\u0595\u0001\u0000\u0000\u0000\u0597\u0598" +
                    "\u0001\u0000\u0000\u0000\u0598\u059a\u0001\u0000\u0000\u0000\u0599\u0584" +
                    "\u0001\u0000\u0000\u0000\u0599\u0590\u0001\u0000\u0000\u0000\u059a\u059b" +
                    "\u0001\u0000\u0000\u0000\u059b\u059f\u0005\u00d0\u0000\u0000\u059c\u059e" +
                    "\u0003|>\u0000\u059d\u059c\u0001\u0000\u0000\u0000\u059e\u05a1\u0001\u0000" +
                    "\u0000\u0000\u059f\u059d\u0001\u0000\u0000\u0000\u059f\u05a0\u0001\u0000" +
                    "\u0000\u0000\u05a0\u05a2\u0001\u0000\u0000\u0000\u05a1\u059f\u0001\u0000" +
                    "\u0000\u0000\u05a2\u05a3\u0005\u00d1\u0000\u0000\u05a3\u00b9\u0001\u0000" +
                    "\u0000\u0000\u05a4\u05a9\u0003\u00e8t\u0000\u05a5\u05a6\u0005\u00b9\u0000" +
                    "\u0000\u05a6\u05a8\u0003\u00eau\u0000\u05a7\u05a5\u0001\u0000\u0000\u0000" +
                    "\u05a8\u05ab\u0001\u0000\u0000\u0000\u05a9\u05a7\u0001\u0000\u0000\u0000" +
                    "\u05a9\u05aa\u0001\u0000\u0000\u0000\u05aa\u00bb\u0001\u0000\u0000\u0000" +
                    "\u05ab\u05a9\u0001\u0000\u0000\u0000\u05ac\u05ae\u0005c\u0000\u0000\u05ad" +
                    "\u05ac\u0001\u0000\u0000\u0000\u05ad\u05ae\u0001\u0000\u0000\u0000\u05ae" +
                    "\u05b0\u0001\u0000\u0000\u0000\u05af\u05b1\u0005\u00ba\u0000\u0000\u05b0" +
                    "\u05af\u0001\u0000\u0000\u0000\u05b0\u05b1\u0001\u0000\u0000\u0000\u05b1" +
                    "\u05b2\u0001\u0000\u0000\u0000\u05b2\u05b3\u0003\u00be_\u0000\u05b3\u00bd" +
                    "\u0001\u0000\u0000\u0000\u05b4\u05c2\u0003\u00f8|\u0000\u05b5\u05ba\u0003" +
                    "\u00f8|\u0000\u05b6\u05b7\u0005\u00ba\u0000\u0000\u05b7\u05b9\u0003\u00f8" +
                    "|\u0000\u05b8\u05b6\u0001\u0000\u0000\u0000\u05b9\u05bc\u0001\u0000\u0000" +
                    "\u0000\u05ba\u05b8\u0001\u0000\u0000\u0000\u05ba\u05bb\u0001\u0000\u0000" +
                    "\u0000\u05bb\u05bf\u0001\u0000\u0000\u0000\u05bc\u05ba\u0001\u0000\u0000" +
                    "\u0000\u05bd\u05be\u0005\u00ba\u0000\u0000\u05be\u05c0\u0003\u00c0`\u0000" +
                    "\u05bf\u05bd\u0001\u0000\u0000\u0000\u05bf\u05c0\u0001\u0000\u0000\u0000" +
                    "\u05c0\u05c2\u0001\u0000\u0000\u0000\u05c1\u05b4\u0001\u0000\u0000\u0000" +
                    "\u05c1\u05b5\u0001\u0000\u0000\u0000\u05c2\u00bf\u0001\u0000\u0000\u0000" +
                    "\u05c3\u05c6\u0003\u00f8|\u0000\u05c4\u05c5\u0005+\u0000\u0000\u05c5\u05c7" +
                    "\u0003\u00f8|\u0000\u05c6\u05c4\u0001\u0000\u0000\u0000\u05c6\u05c7\u0001" +
                    "\u0000\u0000\u0000\u05c7\u05d7\u0001\u0000\u0000\u0000\u05c8\u05c9\u0005" +
                    "\u00d0\u0000\u0000\u05c9\u05ce\u0003\u00c0`\u0000\u05ca\u05cb\u0005\u00d2" +
                    "\u0000\u0000\u05cb\u05cd\u0003\u00c0`\u0000\u05cc\u05ca\u0001\u0000\u0000" +
                    "\u0000\u05cd\u05d0\u0001\u0000\u0000\u0000\u05ce\u05cc\u0001\u0000\u0000" +
                    "\u0000\u05ce\u05cf\u0001\u0000\u0000\u0000\u05cf\u05d2\u0001\u0000\u0000" +
                    "\u0000\u05d0\u05ce\u0001\u0000\u0000\u0000\u05d1\u05d3\u0005\u00d2\u0000" +
                    "\u0000\u05d2\u05d1\u0001\u0000\u0000\u0000\u05d2\u05d3\u0001\u0000\u0000" +
                    "\u0000\u05d3\u05d4\u0001\u0000\u0000\u0000\u05d4\u05d5\u0005\u00d1\u0000" +
                    "\u0000\u05d5\u05d7\u0001\u0000\u0000\u0000\u05d6\u05c3\u0001\u0000\u0000" +
                    "\u0000\u05d6\u05c8\u0001\u0000\u0000\u0000\u05d7\u00c1\u0001\u0000\u0000" +
                    "\u0000\u05d8\u05dd\u0003\u00bc^\u0000\u05d9\u05da\u0005\u00d2\u0000\u0000" +
                    "\u05da\u05dc\u0003\u00bc^\u0000\u05db\u05d9\u0001\u0000\u0000\u0000\u05dc" +
                    "\u05df\u0001\u0000\u0000\u0000\u05dd\u05db\u0001\u0000\u0000\u0000\u05dd" +
                    "\u05de\u0001\u0000\u0000\u0000\u05de\u00c3\u0001\u0000\u0000\u0000\u05df" +
                    "\u05dd\u0001\u0000\u0000\u0000\u05e0\u05ea\u0005\u00cc\u0000\u0000\u05e1" +
                    "\u05e6\u0003\u00c6c\u0000\u05e2\u05e3\u0005\u00d2\u0000\u0000\u05e3\u05e5" +
                    "\u0003\u00c6c\u0000\u05e4\u05e2\u0001\u0000\u0000\u0000\u05e5\u05e8\u0001" +
                    "\u0000\u0000\u0000\u05e6\u05e4\u0001\u0000\u0000\u0000\u05e6\u05e7\u0001" +
                    "\u0000\u0000\u0000\u05e7\u05eb\u0001\u0000\u0000\u0000\u05e8\u05e6\u0001" +
                    "\u0000\u0000\u0000\u05e9\u05eb\u0003\u00aaU\u0000\u05ea\u05e1\u0001\u0000" +
                    "\u0000\u0000\u05ea\u05e9\u0001\u0000\u0000\u0000\u05ea\u05eb\u0001\u0000" +
                    "\u0000\u0000\u05eb\u05ed\u0001\u0000\u0000\u0000\u05ec\u05ee\u0005\u00d2" +
                    "\u0000\u0000\u05ed\u05ec\u0001\u0000\u0000\u0000\u05ed\u05ee\u0001\u0000" +
                    "\u0000\u0000\u05ee\u05ef\u0001\u0000\u0000\u0000\u05ef\u05f0\u0005\u00cd" +
                    "\u0000\u0000\u05f0\u00c5\u0001\u0000\u0000\u0000\u05f1\u05f3\u0003\u00c8" +
                    "d\u0000\u05f2\u05f1\u0001\u0000\u0000\u0000\u05f2\u05f3\u0001\u0000\u0000" +
                    "\u0000\u05f3\u05f5\u0001\u0000\u0000\u0000\u05f4\u05f6\u0005\u00bb\u0000" +
                    "\u0000\u05f5\u05f4\u0001\u0000\u0000\u0000\u05f5\u05f6\u0001\u0000\u0000" +
                    "\u0000\u05f6\u05f7\u0001\u0000\u0000\u0000\u05f7\u05fb\u0003\u009aM\u0000" +
                    "\u05f8\u05f9\u0005\u00be\u0000\u0000\u05f9\u05fb\u0003\u00dcn\u0000\u05fa" +
                    "\u05f2\u0001\u0000\u0000\u0000\u05fa\u05f8\u0001\u0000\u0000\u0000\u05fb" +
                    "\u00c7\u0001\u0000\u0000\u0000\u05fc\u05fd\u0003\u00f8|\u0000\u05fd\u05fe" +
                    "\u0005\u00d3\u0000\u0000\u05fe\u00c9\u0001\u0000\u0000\u0000\u05ff\u0615" +
                    "\u0003\u00ccf\u0000\u0600\u0615\u0003\u00d6k\u0000\u0601\u0602\u0005*" +
                    "\u0000\u0000\u0602\u0607\u0005\u00cc\u0000\u0000\u0603\u0605\u0003\u00ac" +
                    "V\u0000\u0604\u0606\u0005\u00d2\u0000\u0000\u0605\u0604\u0001\u0000\u0000" +
                    "\u0000\u0605\u0606\u0001\u0000\u0000\u0000\u0606\u0608\u0001\u0000\u0000" +
                    "\u0000\u0607\u0603\u0001\u0000\u0000\u0000\u0607\u0608\u0001\u0000\u0000" +
                    "\u0000\u0608\u0609\u0001\u0000\u0000\u0000\u0609\u0615\u0005\u00cd\u0000" +
                    "\u0000\u060a\u060f\u0005\u00ce\u0000\u0000\u060b\u060d\u0003\u00acV\u0000" +
                    "\u060c\u060e\u0005\u00d2\u0000\u0000\u060d\u060c\u0001\u0000\u0000\u0000" +
                    "\u060d\u060e\u0001\u0000\u0000\u0000\u060e\u0610\u0001\u0000\u0000\u0000" +
                    "\u060f\u060b\u0001\u0000\u0000\u0000\u060f\u0610\u0001\u0000\u0000\u0000" +
                    "\u0610\u0611\u0001\u0000\u0000\u0000\u0611\u0615\u0005\u00cf\u0000\u0000" +
                    "\u0612\u0613\u0007\u000e\u0000\u0000\u0613\u0615\u0003\u00cae\u0000\u0614" +
                    "\u05ff\u0001\u0000\u0000\u0000\u0614\u0600\u0001\u0000\u0000\u0000\u0614" +
                    "\u0601\u0001\u0000\u0000\u0000\u0614\u060a\u0001\u0000\u0000\u0000\u0614" +
                    "\u0612\u0001\u0000\u0000\u0000\u0615\u00cb\u0001\u0000\u0000\u0000\u0616" +
                    "\u061c\u0005e\u0000\u0000\u0617\u061c\u0003\u00ceg\u0000\u0618\u061c\u0003" +
                    "\u00fc~\u0000\u0619\u061c\u0003\u00d2i\u0000\u061a\u061c\u0003\u00bc^" +
                    "\u0000\u061b\u0616\u0001\u0000\u0000\u0000\u061b\u0617\u0001\u0000\u0000" +
                    "\u0000\u061b\u0618\u0001\u0000\u0000\u0000\u061b\u0619\u0001\u0000\u0000" +
                    "\u0000\u061b\u061a\u0001\u0000\u0000\u0000\u061c\u00cd\u0001\u0000\u0000" +
                    "\u0000\u061d\u0622\u0005\u00dc\u0000\u0000\u061e\u0622\u0005.\u0000\u0000" +
                    "\u061f\u0622\u0003\u00d0h\u0000\u0620\u0622\u0003\u00d4j\u0000\u0621\u061d" +
                    "\u0001\u0000\u0000\u0000\u0621\u061e\u0001\u0000\u0000\u0000\u0621\u061f" +
                    "\u0001\u0000\u0000\u0000\u0621\u0620\u0001\u0000\u0000\u0000\u0622\u00cf" +
                    "\u0001\u0000\u0000\u0000\u0623\u0624\u0007\u000f\u0000\u0000\u0624\u00d1" +
                    "\u0001\u0000\u0000\u0000\u0625\u0626\u0007\u0010\u0000\u0000\u0626\u062b" +
                    "\u0005\u00b8\u0000\u0000\u0627\u062c\u0003\u00f8|\u0000\u0628\u062c\u0005" +
                    "\u0085\u0000\u0000\u0629\u062c\u0005\u0081\u0000\u0000\u062a\u062c\u0005" +
                    "\u0082\u0000\u0000\u062b\u0627\u0001\u0000\u0000\u0000\u062b\u0628\u0001" +
                    "\u0000\u0000\u0000\u062b\u0629\u0001\u0000\u0000\u0000\u062b\u062a\u0001" +
                    "\u0000\u0000\u0000\u062c\u0638\u0001\u0000\u0000\u0000\u062d\u0631\u0003" +
                    "\u00b4Z\u0000\u062e\u0631\u0003\u00eew\u0000\u062f\u0631\u0003\u00d6k" +
                    "\u0000\u0630\u062d\u0001\u0000\u0000\u0000\u0630\u062e\u0001\u0000\u0000" +
                    "\u0000\u0630\u062f\u0001\u0000\u0000\u0000\u0631\u0632\u0001\u0000\u0000" +
                    "\u0000\u0632\u0635\u0005\u00b8\u0000\u0000\u0633\u0636\u0003\u00f8|\u0000" +
                    "\u0634\u0636\u0003\u00eew\u0000\u0635\u0633\u0001\u0000\u0000\u0000\u0635" +
                    "\u0634\u0001\u0000\u0000\u0000\u0636\u0638\u0001\u0000\u0000\u0000\u0637" +
                    "\u0625\u0001\u0000\u0000\u0000\u0637\u0630\u0001\u0000\u0000\u0000\u0638" +
                    "\u00d3\u0001\u0000\u0000\u0000\u0639\u063a\u0005\u00d9\u0000\u0000\u063a" +
                    "\u00d5\u0001\u0000\u0000\u0000\u063b\u063d\u0005\u00e3\u0000\u0000\u063c" +
                    "\u063e\u0005\u00eb\u0000\u0000\u063d\u063c\u0001\u0000\u0000\u0000\u063e" +
                    "\u063f\u0001\u0000\u0000\u0000\u063f\u063d\u0001\u0000\u0000\u0000\u063f" +
                    "\u0640\u0001\u0000\u0000\u0000\u0640\u0651\u0001\u0000\u0000\u0000\u0641" +
                    "\u0643\u0005\u00e2\u0000\u0000\u0642\u0644\u0005\u00eb\u0000\u0000\u0643" +
                    "\u0642\u0001\u0000\u0000\u0000\u0644\u0645\u0001\u0000\u0000\u0000\u0645" +
                    "\u0643\u0001\u0000\u0000\u0000\u0645\u0646\u0001\u0000\u0000\u0000\u0646" +
                    "\u0651\u0001\u0000\u0000\u0000\u0647\u0651\u0005\u00e0\u0000\u0000\u0648" +
                    "\u064c\u0005\u00e1\u0000\u0000\u0649\u064b\u0003\u00d8l\u0000\u064a\u0649" +
                    "\u0001\u0000\u0000\u0000\u064b\u064e\u0001\u0000\u0000\u0000\u064c\u064a" +
                    "\u0001\u0000\u0000\u0000\u064c\u064d\u0001\u0000\u0000\u0000\u064d\u064f" +
                    "\u0001\u0000\u0000\u0000\u064e\u064c\u0001\u0000\u0000\u0000\u064f\u0651" +
                    "\u0005\u00e1\u0000\u0000\u0650\u063b\u0001\u0000\u0000\u0000\u0650\u0641" +
                    "\u0001\u0000\u0000\u0000\u0650\u0647\u0001\u0000\u0000\u0000\u0650\u0648" +
                    "\u0001\u0000\u0000\u0000\u0651\u00d7\u0001\u0000\u0000\u0000\u0652\u0656" +
                    "\u0005\u00e7\u0000\u0000\u0653\u0656\u0005\u00e6\u0000\u0000\u0654\u0656" +
                    "\u0003\u00dcn\u0000\u0655\u0652\u0001\u0000\u0000\u0000\u0655\u0653\u0001" +
                    "\u0000\u0000\u0000\u0655\u0654\u0001\u0000\u0000\u0000\u0656\u00d9\u0001" +
                    "\u0000\u0000\u0000\u0657\u065c\u0003\u00dcn\u0000\u0658\u0659\u0005\u00d2" +
                    "\u0000\u0000\u0659\u065b\u0003\u00dcn\u0000\u065a\u0658\u0001\u0000\u0000" +
                    "\u0000\u065b\u065e\u0001\u0000\u0000\u0000\u065c\u065a\u0001\u0000\u0000" +
                    "\u0000\u065c\u065d\u0001\u0000\u0000\u0000\u065d\u00db\u0001\u0000\u0000" +
                    "\u0000\u065e\u065c\u0001\u0000\u0000\u0000\u065f\u0663\u0003\u00deo\u0000" +
                    "\u0660\u0662\u0003\u00e0p\u0000\u0661\u0660\u0001\u0000\u0000\u0000\u0662" +
                    "\u0665\u0001\u0000\u0000\u0000\u0663\u0661\u0001\u0000\u0000\u0000\u0663" +
                    "\u0664\u0001\u0000\u0000\u0000\u0664\u00dd\u0001\u0000\u0000\u0000\u0665" +
                    "\u0663\u0001\u0000\u0000\u0000\u0666\u066d\u0003\u00e8t\u0000\u0667\u066d" +
                    "\u0003\u00e2q\u0000\u0668\u0669\u0005\u00cc\u0000\u0000\u0669\u066a\u0003" +
                    "\u00a6S\u0000\u066a\u066b\u0005\u00cd\u0000\u0000\u066b\u066d\u0001\u0000" +
                    "\u0000\u0000\u066c\u0666\u0001\u0000\u0000\u0000\u066c\u0667\u0001\u0000" +
                    "\u0000\u0000\u066c\u0668\u0001\u0000\u0000\u0000\u066d\u00df\u0001\u0000" +
                    "\u0000\u0000\u066e\u066f\u0005\u00b9\u0000\u0000\u066f\u0671\u0003\u00ea" +
                    "u\u0000\u0670\u0672\u0003\u00e6s\u0000\u0671\u0670\u0001\u0000\u0000\u0000" +
                    "\u0671\u0672\u0001\u0000\u0000\u0000\u0672\u00e1\u0001\u0000\u0000\u0000" +
                    "\u0673\u0674\u0003\u00e4r\u0000\u0674\u0675\u0003\u00e6s\u0000\u0675\u00e3" +
                    "\u0001\u0000\u0000\u0000\u0676\u067b\u0003\u00bc^\u0000\u0677\u067b\u0003" +
                    "\u00d2i\u0000\u0678\u067b\u0003\u00e8t\u0000\u0679\u067b\u0003\u0098L" +
                    "\u0000\u067a\u0676\u0001\u0000\u0000\u0000\u067a\u0677\u0001\u0000\u0000" +
                    "\u0000\u067a\u0678\u0001\u0000\u0000\u0000\u067a\u0679\u0001\u0000\u0000" +
                    "\u0000\u067b\u00e5\u0001\u0000\u0000\u0000\u067c\u067e\u0003(\u0014\u0000" +
                    "\u067d\u067c\u0001\u0000\u0000\u0000\u067d\u067e\u0001\u0000\u0000\u0000" +
                    "\u067e\u067f\u0001\u0000\u0000\u0000\u067f\u0683\u0003\u00c4b\u0000\u0680" +
                    "\u0682\u0003\u00f0x\u0000\u0681\u0680\u0001\u0000\u0000\u0000\u0682\u0685" +
                    "\u0001\u0000\u0000\u0000\u0683\u0681\u0001\u0000\u0000\u0000\u0683\u0684" +
                    "\u0001\u0000\u0000\u0000\u0684\u00e7\u0001\u0000\u0000\u0000\u0685\u0683" +
                    "\u0001\u0000\u0000\u0000\u0686\u0689\u0003\u00eew\u0000\u0687\u0688\u0005" +
                    "\u00b8\u0000\u0000\u0688\u068a\u0003\u00eew\u0000\u0689\u0687\u0001\u0000" +
                    "\u0000\u0000\u0689\u068a\u0001\u0000\u0000\u0000\u068a\u0690\u0001\u0000" +
                    "\u0000\u0000\u068b\u068c\u0003\u00b4Z\u0000\u068c\u068d\u0005\u00b8\u0000" +
                    "\u0000\u068d\u068e\u0003\u00eew\u0000\u068e\u0690\u0001\u0000\u0000\u0000" +
                    "\u068f\u0686\u0001\u0000\u0000\u0000\u068f\u068b\u0001\u0000\u0000\u0000" +
                    "\u0690\u00e9\u0001\u0000\u0000\u0000\u0691\u0694\u0003\u00ecv\u0000\u0692" +
                    "\u0694\u0003\u00eew\u0000\u0693\u0691\u0001\u0000\u0000\u0000\u0693\u0692" +
                    "\u0001\u0000\u0000\u0000\u0694\u00eb\u0001\u0000\u0000\u0000\u0695\u069b" +
                    "\u0003\u00f8|\u0000\u0696\u0697\u0005\u00d0\u0000\u0000\u0697\u0698\u0003" +
                    "\u009aM\u0000\u0698\u0699\u0005\u00d1\u0000\u0000\u0699\u069b\u0001\u0000" +
                    "\u0000\u0000\u069a\u0695\u0001\u0000\u0000\u0000\u069a\u0696\u0001\u0000" +
                    "\u0000\u0000\u069b\u069f\u0001\u0000\u0000\u0000\u069c\u069e\u0003\u00f0" +
                    "x\u0000\u069d\u069c\u0001\u0000\u0000\u0000\u069e\u06a1\u0001\u0000\u0000" +
                    "\u0000\u069f\u069d\u0001\u0000\u0000\u0000\u069f\u06a0\u0001\u0000\u0000" +
                    "\u0000\u06a0\u00ed\u0001\u0000\u0000\u0000\u06a1\u069f\u0001\u0000\u0000" +
                    "\u0000\u06a2\u06a4\u0005\u00c9\u0000\u0000\u06a3\u06a2\u0001\u0000\u0000" +
                    "\u0000\u06a4\u06a7\u0001\u0000\u0000\u0000\u06a5\u06a3\u0001\u0000\u0000" +
                    "\u0000\u06a5\u06a6\u0001\u0000\u0000\u0000\u06a6\u06ae\u0001\u0000\u0000" +
                    "\u0000\u06a7\u06a5\u0001\u0000\u0000\u0000\u06a8\u06af\u0005\u00d8\u0000" +
                    "\u0000\u06a9\u06aa\u0005\u00c9\u0000\u0000\u06aa\u06ab\u0005\u00d0\u0000" +
                    "\u0000\u06ab\u06ac\u0003\u009aM\u0000\u06ac\u06ad\u0005\u00d1\u0000\u0000" +
                    "\u06ad\u06af\u0001\u0000\u0000\u0000\u06ae\u06a8\u0001\u0000\u0000\u0000" +
                    "\u06ae\u06a9\u0001\u0000\u0000\u0000\u06af\u06b3\u0001\u0000\u0000\u0000" +
                    "\u06b0\u06b2\u0003\u00f0x\u0000\u06b1\u06b0\u0001\u0000\u0000\u0000\u06b2" +
                    "\u06b5\u0001\u0000\u0000\u0000\u06b3\u06b1\u0001\u0000\u0000\u0000\u06b3" +
                    "\u06b4\u0001\u0000\u0000\u0000\u06b4\u00ef\u0001\u0000\u0000\u0000\u06b5" +
                    "\u06b3\u0001\u0000\u0000\u0000\u06b6\u06b8\u0005\u00ce\u0000\u0000\u06b7" +
                    "\u06b9\u0003\u009aM\u0000\u06b8\u06b7\u0001\u0000\u0000\u0000\u06b8\u06b9" +
                    "\u0001\u0000\u0000\u0000\u06b9\u06ba\u0001\u0000\u0000\u0000\u06ba\u06c0" +
                    "\u0005\u00cf\u0000\u0000\u06bb\u06bc\u0005\u00d0\u0000\u0000\u06bc\u06bd" +
                    "\u0003\u009aM\u0000\u06bd\u06be\u0005\u00d1\u0000\u0000\u06be\u06c0\u0001" +
                    "\u0000\u0000\u0000\u06bf\u06b6\u0001\u0000\u0000\u0000\u06bf\u06bb\u0001" +
                    "\u0000\u0000\u0000\u06c0\u00f1\u0001\u0000\u0000\u0000\u06c1\u06c3\u0003" +
                    "\u00f4z\u0000\u06c2\u06c1\u0001\u0000\u0000\u0000\u06c2\u06c3\u0001\u0000" +
                    "\u0000\u0000\u06c3\u06ca\u0001\u0000\u0000\u0000\u06c4\u06c6\u0005\u00d2" +
                    "\u0000\u0000\u06c5\u06c7\u0003\u00f4z\u0000\u06c6\u06c5\u0001\u0000\u0000" +
                    "\u0000\u06c6\u06c7\u0001\u0000\u0000\u0000\u06c7\u06c9\u0001\u0000\u0000" +
                    "\u0000\u06c8\u06c4\u0001\u0000\u0000\u0000\u06c9\u06cc\u0001\u0000\u0000" +
                    "\u0000\u06ca\u06c8\u0001\u0000\u0000\u0000\u06ca\u06cb\u0001\u0000\u0000" +
                    "\u0000\u06cb\u00f3\u0001\u0000\u0000\u0000\u06cc\u06ca\u0001\u0000\u0000" +
                    "\u0000\u06cd\u06d5\u0003\u00dcn\u0000\u06ce\u06cf\u0005^\u0000\u0000\u06cf" +
                    "\u06d0\u0005\u00cc\u0000\u0000\u06d0\u06d1\u0003\u00f2y\u0000\u06d1\u06d2" +
                    "\u0005\u00cd\u0000\u0000\u06d2\u06d5\u0001\u0000\u0000\u0000\u06d3\u06d5" +
                    "\u0003\u00aeW\u0000\u06d4\u06cd\u0001\u0000\u0000\u0000\u06d4\u06ce\u0001" +
                    "\u0000\u0000\u0000\u06d4\u06d3\u0001\u0000\u0000\u0000\u06d5\u00f5\u0001" +
                    "\u0000\u0000\u0000\u06d6\u06d7\u0007\u0011\u0000\u0000\u06d7\u00f7\u0001" +
                    "\u0000\u0000\u0000\u06d8\u06d9\u0007\u0012\u0000\u0000\u06d9\u00f9\u0001" +
                    "\u0000\u0000\u0000\u06da\u06db\u0007\u0013\u0000\u0000\u06db\u00fb\u0001" +
                    "\u0000\u0000\u0000\u06dc\u06dd\u0007\u0014\u0000\u0000\u06dd\u00fd\u0001" +
                    "\u0000\u0000\u0000\u06de\u06df\u0007\u0015\u0000\u0000\u06df\u00ff\u0001" +
                    "\u0000\u0000\u0000\u06e0\u06e1\u0007\u0016\u0000\u0000\u06e1\u0101\u0001" +
                    "\u0000\u0000\u0000\u06e2\u06e3\u0007\u0017\u0000\u0000\u06e3\u0103\u0001" +
                    "\u0000\u0000\u0000\u00e1\u0105\u0109\u010b\u0113\u0129\u012d\u0132\u0138" +
                    "\u0145\u0149\u014f\u0154\u0159\u0160\u0166\u016d\u0174\u0177\u017b\u017f" +
                    "\u0186\u0189\u018e\u0191\u0194\u0197\u019c\u01a0\u01a4\u01a9\u01ad\u01af" +
                    "\u01b5\u01c1\u01d2\u01d9\u01e1\u01e5\u01ea\u01f0\u01f8\u0200\u0206\u020d" +
                    "\u0214\u0219\u021f\u023c\u024a\u024e\u0257\u025b\u0260\u027a\u0285\u0289" +
                    "\u028d\u0296\u02a0\u02a5\u02ab\u02b0\u02b5\u02ba\u02bf\u02c5\u02cb\u02d1" +
                    "\u02e3\u02e8\u02eb\u02f5\u02f8\u0305\u030d\u0314\u0317\u031c\u0320\u0329" +
                    "\u0345\u034a\u0351\u0355\u035b\u035f\u0362\u0365\u0368\u036b\u036e\u0371" +
                    "\u0379\u0380\u0389\u0396\u03a2\u03a8\u03ac\u03b3\u03b9\u03bd\u03c4\u03cb" +
                    "\u03cf\u03d5\u03d9\u03db\u03e1\u03e8\u03ec\u03f0\u03fd\u0400\u0407\u040e" +
                    "\u0412\u0416\u041b\u0420\u0427\u042f\u0439\u043f\u047e\u048b\u0492\u0497" +
                    "\u0499\u04bf\u04d5\u04d7\u04dc\u04e1\u04e6\u04e9\u04ef\u04f2\u04f6\u04fc" +
                    "\u0500\u050b\u0517\u051b\u0524\u052d\u0535\u0539\u0540\u0544\u0549\u054e" +
                    "\u0552\u055b\u0561\u0567\u056a\u056e\u0571\u0576\u0579\u057c\u057f\u0582" +
                    "\u0586\u058a\u058e\u0593\u0597\u0599\u059f\u05a9\u05ad\u05b0\u05ba\u05bf" +
                    "\u05c1\u05c6\u05ce\u05d2\u05d6\u05dd\u05e6\u05ea\u05ed\u05f2\u05f5\u05fa" +
                    "\u0605\u0607\u060d\u060f\u0614\u061b\u0621\u062b\u0630\u0635\u0637\u063f" +
                    "\u0645\u064c\u0650\u0655\u065c\u0663\u066c\u0671\u067a\u067d\u0683\u0689" +
                    "\u068f\u0693\u069a\u069f\u06a5\u06ae\u06b3\u06b8\u06bf\u06c2\u06c6\u06ca" +
                    "\u06d4";
    public static final ATN _ATN =
            new ATNDeserializer().deserialize(_serializedATN.toCharArray());
    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache =
            new PredictionContextCache();
    private static final String[] _LITERAL_NAMES = makeLiteralNames();
    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    static {
        RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION);
    }

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }

    public PhpParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    private static String[] makeRuleNames() {
        return new String[]{
                "htmlDocument", "inlineHtml", "htmlElement", "phpBlock", "importStatement",
                "topStatement", "useDeclaration", "useDeclarationContentList", "useDeclarationContent",
                "namespaceDeclaration", "namespaceStatement", "functionDeclaration",
                "classDeclaration", "classEntryType", "interfaceList", "typeParameterListInBrackets",
                "typeParameterList", "typeParameterWithDefaultsList", "typeParameterDecl",
                "typeParameterWithDefaultDecl", "genericDynamicArgs", "attributes", "attributeGroup",
                "attribute", "innerStatementList", "innerStatement", "statement", "emptyStatement_",
                "blockStatement", "ifStatement", "elseIfStatement", "elseIfColonStatement",
                "elseStatement", "elseColonStatement", "whileStatement", "doWhileStatement",
                "forStatement", "forInit", "forUpdate", "switchStatement", "switchBlock",
                "breakStatement", "continueStatement", "returnStatement", "expressionStatement",
                "unsetStatement", "foreachStatement", "tryCatchFinally", "catchClause",
                "finallyStatement", "throwStatement", "gotoStatement", "declareStatement",
                "inlineHtmlStatement", "declareList", "formalParameterList", "formalParameter",
                "typeHint", "globalStatement", "globalVar", "echoStatement", "staticVariableStatement",
                "classStatement", "traitAdaptations", "traitAdaptationStatement", "traitPrecedence",
                "traitAlias", "traitMethodReference", "baseCtorCall", "methodBody", "propertyModifiers",
                "memberModifiers", "variableInitializer", "identifierInitializer", "globalConstantDeclaration",
                "expressionList", "parentheses", "expression", "assignable", "arrayCreation",
                "lambdaFunctionExpr", "matchExpr", "matchItem", "newExpr", "assignmentOperator",
                "yieldExpression", "arrayItemList", "arrayItem", "lambdaFunctionUseVars",
                "lambdaFunctionUseVar", "qualifiedStaticTypeRef", "typeRef", "anonymousClass",
                "indirectTypeRef", "qualifiedNamespaceName", "namespaceNameList", "namespaceNameTail",
                "qualifiedNamespaceNameList", "arguments", "actualArgument", "argumentName",
                "constantInitializer", "constant", "literalConstant", "numericConstant",
                "classConstant", "stringConstant", "string", "interpolatedStringPart",
                "chainList", "chain", "chainOrigin", "memberAccess", "functionCall",
                "functionCallName", "actualArguments", "chainBase", "keyedFieldName",
                "keyedSimpleFieldName", "keyedVariable", "squareCurlyExpression", "assignmentList",
                "assignmentListElement", "modifier", "identifier", "memberModifier",
                "magicConstant", "magicMethod", "primitiveType", "castOperation"
        };
    }

    private static String[] makeLiteralNames() {
        return new String[]{
                null, null, null, "'<?xml'", null, null, "'<!--'", null, null, null,
                null, null, "'?>'", null, null, "'/>'", null, null, null, null, null,
                null, null, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, "'/*'", null, null, "'#['", "'abstract'", "'array'",
                "'as'", "'binary'", null, null, "'break'", "'callable'", "'case'", "'catch'",
                "'class'", "'clone'", "'const'", "'continue'", "'declare'", "'default'",
                "'do'", "'real'", "'double'", "'echo'", "'else'", "'elseif'", "'empty'",
                "'enddeclare'", "'endfor'", "'endforeach'", "'endif'", "'endswitch'",
                "'endwhile'", "'eval'", "'die'", "'extends'", "'final'", "'finally'",
                "'float'", "'for'", "'foreach'", "'function'", "'global'", "'goto'",
                "'if'", "'implements'", "'import'", "'include'", "'include_once'", "'instanceof'",
                "'insteadof'", "'int8'", "'int16'", "'int64'", null, "'interface'", "'isset'",
                "'list'", "'and'", "'or'", "'xor'", "'match'", "'namespace'", "'new'",
                "'null'", "'object'", "'parent'", "'partial'", "'print'", "'private'",
                "'protected'", "'public'", "'require'", "'require_once'", "'resource'",
                "'return'", "'static'", "'string'", "'switch'", "'throw'", "'trait'",
                "'try'", "'clrtypeof'", null, "'unicode'", "'unset'", "'use'", "'var'",
                "'while'", "'yield'", "'from'", "'fn'", "'__get'", "'__set'", "'__call'",
                "'__callstatic'", "'__construct'", "'__destruct'", "'__wakeup'", "'__sleep'",
                "'__autoload'", "'__isset'", "'__unset'", "'__tostring'", "'__invoke'",
                "'__set_state'", "'__clone'", "'__debuginfo'", "'__namespace__'", "'__class__'",
                "'__trait__'", "'__function__'", "'__method__'", "'__line__'", "'__file__'",
                "'__dir__'", "'<=>'", "'<:'", "':>'", "'=>'", "'++'", "'--'", "'==='",
                "'!=='", "'=='", null, "'<='", "'>='", "'+='", "'-='", "'*='", "'**'",
                "'**='", "'/='", "'.='", "'%='", "'<<='", "'>>='", "'&='", "'|='", "'^='",
                "'||'", "'&&'", "'??'", "'??='", "'<<'", "'>>'", "'::'", "'->'", "'\\'",
                "'...'", null, null, "'&'", "'|'", "'!'", "'^'", "'+'", "'-'", "'*'",
                "'%'", null, "'~'", "'@'", null, "'.'", null, "'('", "')'", "'['", "']'",
                null, "'}'", "','", "':'", "';'", null, "'''", "'`'"
        };
    }

    private static String[] makeSymbolicNames() {
        return new String[]{
                null, "SeaWhitespace", "HtmlText", "XmlStart", "PHPStart", "HtmlComment",
                "HtmlCommentOpen", "HtmlDtd", "HtmlOpen", "Shebang", "Error", "XmlText",
                "XmlClose", "PHPStartInside", "HtmlClose", "HtmlSlashClose", "HtmlSlash",
                "HtmlEquals", "HtmlStartQuoteString", "HtmlStartDoubleQuoteString", "HtmlHex",
                "HtmlDecimal", "HtmlSpace", "HtmlName", "ErrorInside", "PHPStartInsideQuoteString",
                "HtmlEndQuoteString", "HtmlQuoteString", "ErrorHtmlQuote", "PHPStartDoubleQuoteString",
                "HtmlEndDoubleQuoteString", "HtmlDoubleQuoteString", "ErrorHtmlDoubleQuote",
                "PHPStartInsideScript", "PHPEnd", "Whitespace", "MultiLineComment", "MultiLineCommentOpen",
                "SingleLineComment", "ShellStyleComment", "AttributeStart", "Abstract",
                "Array", "As", "BinaryCast", "BoolType", "BooleanConstant", "Break",
                "Callable", "Case", "Catch", "Class", "Clone", "Const", "Continue", "Declare",
                "Default", "Do", "DoubleCast", "DoubleType", "Echo", "Else", "ElseIf",
                "Empty", "EndDeclare", "EndFor", "EndForeach", "EndIf", "EndSwitch",
                "EndWhile", "Eval", "Exit", "Extends", "Final", "Finally", "FloatCast",
                "For", "Foreach", "Function_", "Global", "Goto", "If", "Implements",
                "Import", "Include", "IncludeOnce", "InstanceOf", "InsteadOf", "Int8Cast",
                "Int16Cast", "Int64Type", "IntType", "Interface", "IsSet", "List", "LogicalAnd",
                "LogicalOr", "LogicalXor", "Match_", "Namespace", "New", "Null", "ObjectType",
                "Parent_", "Partial", "Print", "Private", "Protected", "Public", "Require",
                "RequireOnce", "Resource", "Return", "Static", "StringType", "Switch",
                "Throw", "Trait", "Try", "Typeof", "UintCast", "UnicodeCast", "Unset",
                "Use", "Var", "While", "Yield", "From", "LambdaFn", "Get", "Set", "Call",
                "CallStatic", "Constructor", "Destruct", "Wakeup", "Sleep", "Autoload",
                "IsSet__", "Unset__", "ToString__", "Invoke", "SetState", "Clone__",
                "DebugInfo", "Namespace__", "Class__", "Traic__", "Function__", "Method__",
                "Line__", "File__", "Dir__", "Spaceship", "Lgeneric", "Rgeneric", "DoubleArrow",
                "Inc", "Dec", "IsIdentical", "IsNoidentical", "IsEqual", "IsNotEq", "IsSmallerOrEqual",
                "IsGreaterOrEqual", "PlusEqual", "MinusEqual", "MulEqual", "Pow", "PowEqual",
                "DivEqual", "Concaequal", "ModEqual", "ShiftLeftEqual", "ShiftRightEqual",
                "AndEqual", "OrEqual", "XorEqual", "BooleanOr", "BooleanAnd", "NullCoalescing",
                "NullCoalescingEqual", "ShiftLeft", "ShiftRight", "DoubleColon", "ObjectOperator",
                "NamespaceSeparator", "Ellipsis", "Less", "Greater", "Ampersand", "Pipe",
                "Bang", "Caret", "Plus", "Minus", "Asterisk", "Percent", "Divide", "Tilde",
                "SuppressWarnings", "Dollar", "Dot", "QuestionMark", "OpenRoundBracket",
                "CloseRoundBracket", "OpenSquareBracket", "CloseSquareBracket", "OpenCurlyBracket",
                "CloseCurlyBracket", "Comma", "Colon", "SemiColon", "Eq", "Quote", "BackQuote",
                "VarName", "Label", "Octal", "Decimal", "Real", "Hex", "Binary", "BackQuoteString",
                "SingleQuoteString", "DoubleQuote", "StartNowDoc", "StartHereDoc", "ErrorPhp",
                "CurlyDollar", "UnicodeEscape", "StringPart", "Comment", "PHPEndSingleLineComment",
                "CommentEnd", "HereDocText", "XmlText2"
        };
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override

    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    @Override
    public String getGrammarFileName() {
        return "java-escape";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public final HtmlDocumentContext htmlDocument() throws RecognitionException {
        HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_htmlDocument);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(261);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Shebang) {
                    {
                        setState(260);
                        match(Shebang);
                    }
                }

                setState(267);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((_la) & ~0x3f) == 0 && ((1L << _la) & -1096076508788L) != 0 || (((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1L) != 0 || (((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 288230377795878911L) != 0 || (((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 68703835021L) != 0) {
                    {
                        setState(265);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 1, _ctx)) {
                            case 1: {
                                setState(263);
                                inlineHtml();
                            }
                            break;
                            case 2: {
                                setState(264);
                                phpBlock();
                            }
                            break;
                        }
                    }
                    setState(269);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(270);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InlineHtmlContext inlineHtml() throws RecognitionException {
        InlineHtmlContext _localctx = new InlineHtmlContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_inlineHtml);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(273);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(272);
                                htmlElement();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(275);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 3, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final HtmlElementContext htmlElement() throws RecognitionException {
        HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_htmlElement);
        int _la;
        try {
            setState(301);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case HtmlDtd:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(277);
                    match(HtmlDtd);
                }
                break;
                case HtmlClose:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(278);
                    match(HtmlClose);
                }
                break;
                case HtmlOpen:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(279);
                    match(HtmlOpen);
                }
                break;
                case HtmlName:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(280);
                    match(HtmlName);
                }
                break;
                case HtmlSlashClose:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(281);
                    match(HtmlSlashClose);
                }
                break;
                case HtmlSlash:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(282);
                    match(HtmlSlash);
                }
                break;
                case HtmlText:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(283);
                    match(HtmlText);
                }
                break;
                case HtmlEquals:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(284);
                    match(HtmlEquals);
                }
                break;
                case HtmlStartQuoteString:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(285);
                    match(HtmlStartQuoteString);
                }
                break;
                case HtmlEndQuoteString:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(286);
                    match(HtmlEndQuoteString);
                }
                break;
                case HtmlStartDoubleQuoteString:
                    enterOuterAlt(_localctx, 11);
                {
                    setState(287);
                    match(HtmlStartDoubleQuoteString);
                }
                break;
                case HtmlEndDoubleQuoteString:
                    enterOuterAlt(_localctx, 12);
                {
                    setState(288);
                    match(HtmlEndDoubleQuoteString);
                }
                break;
                case HtmlHex:
                    enterOuterAlt(_localctx, 13);
                {
                    setState(289);
                    match(HtmlHex);
                }
                break;
                case HtmlDecimal:
                    enterOuterAlt(_localctx, 14);
                {
                    setState(290);
                    match(HtmlDecimal);
                }
                break;
                case HtmlQuoteString:
                    enterOuterAlt(_localctx, 15);
                {
                    setState(291);
                    match(HtmlQuoteString);
                }
                break;
                case HtmlDoubleQuoteString:
                    enterOuterAlt(_localctx, 16);
                {
                    setState(292);
                    match(HtmlDoubleQuoteString);
                }
                break;
                case XmlStart:
                    enterOuterAlt(_localctx, 17);
                {
                    setState(293);
                    match(XmlStart);
                    setState(297);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == XmlText) {
                        {
                            {
                                setState(294);
                                match(XmlText);
                            }
                        }
                        setState(299);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(300);
                    match(XmlClose);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PhpBlockContext phpBlock() throws RecognitionException {
        PhpBlockContext _localctx = new PhpBlockContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_phpBlock);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(306);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(303);
                                importStatement();
                            }
                        }
                    }
                    setState(308);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 6, _ctx);
                }
                setState(310);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(309);
                                topStatement();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(312);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 7, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ImportStatementContext importStatement() throws RecognitionException {
        ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_importStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(314);
                match(Import);
                setState(315);
                match(Namespace);
                setState(316);
                namespaceNameList();
                setState(317);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TopStatementContext topStatement() throws RecognitionException {
        TopStatementContext _localctx = new TopStatementContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_topStatement);
        try {
            setState(325);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 8, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(319);
                    statement();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(320);
                    useDeclaration();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(321);
                    namespaceDeclaration();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(322);
                    functionDeclaration();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(323);
                    classDeclaration();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(324);
                    globalConstantDeclaration();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final UseDeclarationContext useDeclaration() throws RecognitionException {
        UseDeclarationContext _localctx = new UseDeclarationContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_useDeclaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(327);
                match(Use);
                setState(329);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 9, _ctx)) {
                    case 1: {
                        setState(328);
                        _la = _input.LA(1);
                        if (!(_la == Const || _la == Function_)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                }
                setState(331);
                useDeclarationContentList();
                setState(332);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final UseDeclarationContentListContext useDeclarationContentList() throws RecognitionException {
        UseDeclarationContentListContext _localctx = new UseDeclarationContentListContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_useDeclarationContentList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(335);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NamespaceSeparator) {
                    {
                        setState(334);
                        match(NamespaceSeparator);
                    }
                }

                setState(337);
                useDeclarationContent();
                setState(345);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(338);
                            match(Comma);
                            setState(340);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == NamespaceSeparator) {
                                {
                                    setState(339);
                                    match(NamespaceSeparator);
                                }
                            }

                            setState(342);
                            useDeclarationContent();
                        }
                    }
                    setState(347);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final UseDeclarationContentContext useDeclarationContent() throws RecognitionException {
        UseDeclarationContentContext _localctx = new UseDeclarationContentContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_useDeclarationContent);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(348);
                namespaceNameList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NamespaceDeclarationContext namespaceDeclaration() throws RecognitionException {
        NamespaceDeclarationContext _localctx = new NamespaceDeclarationContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_namespaceDeclaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(350);
                match(Namespace);
                setState(365);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 15, _ctx)) {
                    case 1: {
                        setState(352);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -144115188075855873L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 281474968322047L) != 0 || _la == Label) {
                            {
                                setState(351);
                                namespaceNameList();
                            }
                        }

                        setState(354);
                        match(OpenCurlyBracket);
                        setState(358);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (((_la) & ~0x3f) == 0 && ((1L << _la) & -1096076508788L) != 0 || (((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1L) != 0 || (((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 288230377795878911L) != 0 || (((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 68703835021L) != 0) {
                            {
                                {
                                    setState(355);
                                    namespaceStatement();
                                }
                            }
                            setState(360);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(361);
                        match(CloseCurlyBracket);
                    }
                    break;
                    case 2: {
                        setState(362);
                        namespaceNameList();
                        setState(363);
                        match(SemiColon);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NamespaceStatementContext namespaceStatement() throws RecognitionException {
        NamespaceStatementContext _localctx = new NamespaceStatementContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_namespaceStatement);
        try {
            setState(372);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 16, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(367);
                    statement();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(368);
                    useDeclaration();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(369);
                    functionDeclaration();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(370);
                    classDeclaration();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(371);
                    globalConstantDeclaration();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
        FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_functionDeclaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(375);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AttributeStart) {
                    {
                        setState(374);
                        attributes();
                    }
                }

                setState(377);
                match(Function_);
                setState(379);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Ampersand) {
                    {
                        setState(378);
                        match(Ampersand);
                    }
                }

                setState(381);
                identifier();
                setState(383);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Lgeneric) {
                    {
                        setState(382);
                        typeParameterListInBrackets();
                    }
                }

                setState(385);
                match(OpenRoundBracket);
                setState(386);
                formalParameterList();
                setState(387);
                match(CloseRoundBracket);
                setState(393);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Colon) {
                    {
                        setState(388);
                        match(Colon);
                        setState(390);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == QuestionMark) {
                            {
                                setState(389);
                                match(QuestionMark);
                            }
                        }

                        setState(392);
                        typeHint(0);
                    }
                }

                setState(395);
                blockStatement();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClassDeclarationContext classDeclaration() throws RecognitionException {
        ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_classDeclaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(398);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AttributeStart) {
                    {
                        setState(397);
                        attributes();
                    }
                }

                setState(401);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Private) {
                    {
                        setState(400);
                        match(Private);
                    }
                }

                setState(404);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Abstract || _la == Final) {
                    {
                        setState(403);
                        modifier();
                    }
                }

                setState(407);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Partial) {
                    {
                        setState(406);
                        match(Partial);
                    }
                }

                setState(431);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case Class:
                    case Trait: {
                        setState(409);
                        classEntryType();
                        setState(410);
                        identifier();
                        setState(412);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Lgeneric) {
                            {
                                setState(411);
                                typeParameterListInBrackets();
                            }
                        }

                        setState(416);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Extends) {
                            {
                                setState(414);
                                match(Extends);
                                setState(415);
                                qualifiedStaticTypeRef();
                            }
                        }

                        setState(420);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Implements) {
                            {
                                setState(418);
                                match(Implements);
                                setState(419);
                                interfaceList();
                            }
                        }

                    }
                    break;
                    case Interface: {
                        setState(422);
                        match(Interface);
                        setState(423);
                        identifier();
                        setState(425);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Lgeneric) {
                            {
                                setState(424);
                                typeParameterListInBrackets();
                            }
                        }

                        setState(429);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Extends) {
                            {
                                setState(427);
                                match(Extends);
                                setState(428);
                                interfaceList();
                            }
                        }

                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(433);
                match(OpenCurlyBracket);
                setState(437);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((_la) & ~0x3f) == 0 && ((1L << _la) & 9010497789624320L) != 0 || (((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 3378859361697825L) != 0) {
                    {
                        {
                            setState(434);
                            classStatement();
                        }
                    }
                    setState(439);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(440);
                match(CloseCurlyBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClassEntryTypeContext classEntryType() throws RecognitionException {
        ClassEntryTypeContext _localctx = new ClassEntryTypeContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_classEntryType);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(442);
                _la = _input.LA(1);
                if (!(_la == Class || _la == Trait)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InterfaceListContext interfaceList() throws RecognitionException {
        InterfaceListContext _localctx = new InterfaceListContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_interfaceList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(444);
                qualifiedStaticTypeRef();
                setState(449);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(445);
                            match(Comma);
                            setState(446);
                            qualifiedStaticTypeRef();
                        }
                    }
                    setState(451);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeParameterListInBracketsContext typeParameterListInBrackets() throws RecognitionException {
        TypeParameterListInBracketsContext _localctx = new TypeParameterListInBracketsContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_typeParameterListInBrackets);
        try {
            setState(466);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 34, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(452);
                    match(Lgeneric);
                    setState(453);
                    typeParameterList();
                    setState(454);
                    match(Rgeneric);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(456);
                    match(Lgeneric);
                    setState(457);
                    typeParameterWithDefaultsList();
                    setState(458);
                    match(Rgeneric);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(460);
                    match(Lgeneric);
                    setState(461);
                    typeParameterList();
                    setState(462);
                    match(Comma);
                    setState(463);
                    typeParameterWithDefaultsList();
                    setState(464);
                    match(Rgeneric);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeParameterListContext typeParameterList() throws RecognitionException {
        TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_typeParameterList);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(468);
                typeParameterDecl();
                setState(473);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 35, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(469);
                                match(Comma);
                                setState(470);
                                typeParameterDecl();
                            }
                        }
                    }
                    setState(475);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 35, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeParameterWithDefaultsListContext typeParameterWithDefaultsList() throws RecognitionException {
        TypeParameterWithDefaultsListContext _localctx = new TypeParameterWithDefaultsListContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_typeParameterWithDefaultsList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(476);
                typeParameterWithDefaultDecl();
                setState(481);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(477);
                            match(Comma);
                            setState(478);
                            typeParameterWithDefaultDecl();
                        }
                    }
                    setState(483);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeParameterDeclContext typeParameterDecl() throws RecognitionException {
        TypeParameterDeclContext _localctx = new TypeParameterDeclContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_typeParameterDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(485);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AttributeStart) {
                    {
                        setState(484);
                        attributes();
                    }
                }

                setState(487);
                identifier();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeParameterWithDefaultDeclContext typeParameterWithDefaultDecl() throws RecognitionException {
        TypeParameterWithDefaultDeclContext _localctx = new TypeParameterWithDefaultDeclContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_typeParameterWithDefaultDecl);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(490);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AttributeStart) {
                    {
                        setState(489);
                        attributes();
                    }
                }

                setState(492);
                identifier();
                setState(493);
                match(Eq);
                setState(496);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 39, _ctx)) {
                    case 1: {
                        setState(494);
                        qualifiedStaticTypeRef();
                    }
                    break;
                    case 2: {
                        setState(495);
                        primitiveType();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GenericDynamicArgsContext genericDynamicArgs() throws RecognitionException {
        GenericDynamicArgsContext _localctx = new GenericDynamicArgsContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_genericDynamicArgs);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(498);
                match(Lgeneric);
                setState(499);
                typeRef();
                setState(504);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(500);
                            match(Comma);
                            setState(501);
                            typeRef();
                        }
                    }
                    setState(506);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(507);
                match(Rgeneric);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AttributesContext attributes() throws RecognitionException {
        AttributesContext _localctx = new AttributesContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_attributes);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(510);
                _errHandler.sync(this);
                _la = _input.LA(1);
                do {
                    {
                        {
                            setState(509);
                            attributeGroup();
                        }
                    }
                    setState(512);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                } while (_la == AttributeStart);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AttributeGroupContext attributeGroup() throws RecognitionException {
        AttributeGroupContext _localctx = new AttributeGroupContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_attributeGroup);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(514);
                match(AttributeStart);
                setState(518);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 42, _ctx)) {
                    case 1: {
                        setState(515);
                        identifier();
                        setState(516);
                        match(Colon);
                    }
                    break;
                }
                setState(520);
                attribute();
                setState(525);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(521);
                            match(Comma);
                            setState(522);
                            attribute();
                        }
                    }
                    setState(527);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(528);
                match(CloseSquareBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AttributeContext attribute() throws RecognitionException {
        AttributeContext _localctx = new AttributeContext(_ctx, getState());
        enterRule(_localctx, 46, RULE_attribute);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(530);
                qualifiedNamespaceName();
                setState(532);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OpenRoundBracket) {
                    {
                        setState(531);
                        arguments();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InnerStatementListContext innerStatementList() throws RecognitionException {
        InnerStatementListContext _localctx = new InnerStatementListContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_innerStatementList);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(537);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(534);
                                innerStatement();
                            }
                        }
                    }
                    setState(539);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 45, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InnerStatementContext innerStatement() throws RecognitionException {
        InnerStatementContext _localctx = new InnerStatementContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_innerStatement);
        try {
            setState(543);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 46, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(540);
                    statement();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(541);
                    functionDeclaration();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(542);
                    classDeclaration();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StatementContext statement() throws RecognitionException {
        StatementContext _localctx = new StatementContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_statement);
        try {
            setState(572);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 47, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(545);
                    identifier();
                    setState(546);
                    match(Colon);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(548);
                    blockStatement();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(549);
                    ifStatement();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(550);
                    whileStatement();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(551);
                    doWhileStatement();
                }
                break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                {
                    setState(552);
                    forStatement();
                }
                break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                {
                    setState(553);
                    switchStatement();
                }
                break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                {
                    setState(554);
                    breakStatement();
                }
                break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                {
                    setState(555);
                    continueStatement();
                }
                break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                {
                    setState(556);
                    returnStatement();
                }
                break;
                case 11:
                    enterOuterAlt(_localctx, 11);
                {
                    setState(557);
                    yieldExpression();
                    setState(558);
                    match(SemiColon);
                }
                break;
                case 12:
                    enterOuterAlt(_localctx, 12);
                {
                    setState(560);
                    globalStatement();
                }
                break;
                case 13:
                    enterOuterAlt(_localctx, 13);
                {
                    setState(561);
                    staticVariableStatement();
                }
                break;
                case 14:
                    enterOuterAlt(_localctx, 14);
                {
                    setState(562);
                    echoStatement();
                }
                break;
                case 15:
                    enterOuterAlt(_localctx, 15);
                {
                    setState(563);
                    expressionStatement();
                }
                break;
                case 16:
                    enterOuterAlt(_localctx, 16);
                {
                    setState(564);
                    unsetStatement();
                }
                break;
                case 17:
                    enterOuterAlt(_localctx, 17);
                {
                    setState(565);
                    foreachStatement();
                }
                break;
                case 18:
                    enterOuterAlt(_localctx, 18);
                {
                    setState(566);
                    tryCatchFinally();
                }
                break;
                case 19:
                    enterOuterAlt(_localctx, 19);
                {
                    setState(567);
                    throwStatement();
                }
                break;
                case 20:
                    enterOuterAlt(_localctx, 20);
                {
                    setState(568);
                    gotoStatement();
                }
                break;
                case 21:
                    enterOuterAlt(_localctx, 21);
                {
                    setState(569);
                    declareStatement();
                }
                break;
                case 22:
                    enterOuterAlt(_localctx, 22);
                {
                    setState(570);
                    emptyStatement_();
                }
                break;
                case 23:
                    enterOuterAlt(_localctx, 23);
                {
                    setState(571);
                    inlineHtmlStatement();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EmptyStatement_Context emptyStatement_() throws RecognitionException {
        EmptyStatement_Context _localctx = new EmptyStatement_Context(_ctx, getState());
        enterRule(_localctx, 54, RULE_emptyStatement_);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(574);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BlockStatementContext blockStatement() throws RecognitionException {
        BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_blockStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(576);
                match(OpenCurlyBracket);
                setState(577);
                innerStatementList();
                setState(578);
                match(CloseCurlyBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IfStatementContext ifStatement() throws RecognitionException {
        IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_ifStatement);
        int _la;
        try {
            int _alt;
            setState(608);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 52, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(580);
                    match(If);
                    setState(581);
                    parentheses();
                    setState(582);
                    statement();
                    setState(586);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 48, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(583);
                                    elseIfStatement();
                                }
                            }
                        }
                        setState(588);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 48, _ctx);
                    }
                    setState(590);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 49, _ctx)) {
                        case 1: {
                            setState(589);
                            elseStatement();
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(592);
                    match(If);
                    setState(593);
                    parentheses();
                    setState(594);
                    match(Colon);
                    setState(595);
                    innerStatementList();
                    setState(599);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while (_la == ElseIf) {
                        {
                            {
                                setState(596);
                                elseIfColonStatement();
                            }
                        }
                        setState(601);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(603);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Else) {
                        {
                            setState(602);
                            elseColonStatement();
                        }
                    }

                    setState(605);
                    match(EndIf);
                    setState(606);
                    match(SemiColon);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
        ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_elseIfStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(610);
                match(ElseIf);
                setState(611);
                parentheses();
                setState(612);
                statement();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ElseIfColonStatementContext elseIfColonStatement() throws RecognitionException {
        ElseIfColonStatementContext _localctx = new ElseIfColonStatementContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_elseIfColonStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(614);
                match(ElseIf);
                setState(615);
                parentheses();
                setState(616);
                match(Colon);
                setState(617);
                innerStatementList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ElseStatementContext elseStatement() throws RecognitionException {
        ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_elseStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(619);
                match(Else);
                setState(620);
                statement();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ElseColonStatementContext elseColonStatement() throws RecognitionException {
        ElseColonStatementContext _localctx = new ElseColonStatementContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_elseColonStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(622);
                match(Else);
                setState(623);
                match(Colon);
                setState(624);
                innerStatementList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final WhileStatementContext whileStatement() throws RecognitionException {
        WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_whileStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(626);
                match(While);
                setState(627);
                parentheses();
                setState(634);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case HtmlText:
                    case XmlStart:
                    case HtmlDtd:
                    case HtmlOpen:
                    case HtmlClose:
                    case HtmlSlashClose:
                    case HtmlSlash:
                    case HtmlEquals:
                    case HtmlStartQuoteString:
                    case HtmlStartDoubleQuoteString:
                    case HtmlHex:
                    case HtmlDecimal:
                    case HtmlName:
                    case HtmlEndQuoteString:
                    case HtmlQuoteString:
                    case HtmlEndDoubleQuoteString:
                    case HtmlDoubleQuoteString:
                    case Abstract:
                    case Array:
                    case As:
                    case BinaryCast:
                    case BoolType:
                    case BooleanConstant:
                    case Break:
                    case Callable:
                    case Case:
                    case Catch:
                    case Class:
                    case Clone:
                    case Const:
                    case Continue:
                    case Declare:
                    case Default:
                    case Do:
                    case DoubleCast:
                    case DoubleType:
                    case Echo:
                    case Else:
                    case ElseIf:
                    case Empty:
                    case EndDeclare:
                    case EndFor:
                    case EndForeach:
                    case EndIf:
                    case EndSwitch:
                    case EndWhile:
                    case Eval:
                    case Exit:
                    case Extends:
                    case Final:
                    case Finally:
                    case FloatCast:
                    case For:
                    case Foreach:
                    case Function_:
                    case Global:
                    case Goto:
                    case If:
                    case Implements:
                    case Import:
                    case Include:
                    case IncludeOnce:
                    case InstanceOf:
                    case InsteadOf:
                    case Int8Cast:
                    case Int16Cast:
                    case Int64Type:
                    case IntType:
                    case Interface:
                    case IsSet:
                    case List:
                    case LogicalAnd:
                    case LogicalOr:
                    case LogicalXor:
                    case Match_:
                    case Namespace:
                    case New:
                    case Null:
                    case ObjectType:
                    case Parent_:
                    case Partial:
                    case Print:
                    case Private:
                    case Protected:
                    case Public:
                    case Require:
                    case RequireOnce:
                    case Resource:
                    case Return:
                    case Static:
                    case StringType:
                    case Switch:
                    case Throw:
                    case Trait:
                    case Try:
                    case Typeof:
                    case UintCast:
                    case UnicodeCast:
                    case Unset:
                    case Use:
                    case Var:
                    case While:
                    case Yield:
                    case From:
                    case LambdaFn:
                    case Get:
                    case Set:
                    case Call:
                    case CallStatic:
                    case Constructor:
                    case Destruct:
                    case Wakeup:
                    case Sleep:
                    case Autoload:
                    case IsSet__:
                    case Unset__:
                    case ToString__:
                    case Invoke:
                    case SetState:
                    case Clone__:
                    case DebugInfo:
                    case Namespace__:
                    case Class__:
                    case Traic__:
                    case Function__:
                    case Method__:
                    case Line__:
                    case File__:
                    case Dir__:
                    case Inc:
                    case Dec:
                    case NamespaceSeparator:
                    case Bang:
                    case Plus:
                    case Minus:
                    case Tilde:
                    case SuppressWarnings:
                    case Dollar:
                    case OpenRoundBracket:
                    case OpenSquareBracket:
                    case OpenCurlyBracket:
                    case SemiColon:
                    case VarName:
                    case Label:
                    case Octal:
                    case Decimal:
                    case Real:
                    case Hex:
                    case Binary:
                    case BackQuoteString:
                    case SingleQuoteString:
                    case DoubleQuote:
                    case StartNowDoc:
                    case StartHereDoc: {
                        setState(628);
                        statement();
                    }
                    break;
                    case Colon: {
                        setState(629);
                        match(Colon);
                        setState(630);
                        innerStatementList();
                        setState(631);
                        match(EndWhile);
                        setState(632);
                        match(SemiColon);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
        DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
        enterRule(_localctx, 70, RULE_doWhileStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(636);
                match(Do);
                setState(637);
                statement();
                setState(638);
                match(While);
                setState(639);
                parentheses();
                setState(640);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ForStatementContext forStatement() throws RecognitionException {
        ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
        enterRule(_localctx, 72, RULE_forStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(642);
                match(For);
                setState(643);
                match(OpenRoundBracket);
                setState(645);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                    {
                        setState(644);
                        forInit();
                    }
                }

                setState(647);
                match(SemiColon);
                setState(649);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                    {
                        setState(648);
                        expressionList();
                    }
                }

                setState(651);
                match(SemiColon);
                setState(653);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                    {
                        setState(652);
                        forUpdate();
                    }
                }

                setState(655);
                match(CloseRoundBracket);
                setState(662);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case HtmlText:
                    case XmlStart:
                    case HtmlDtd:
                    case HtmlOpen:
                    case HtmlClose:
                    case HtmlSlashClose:
                    case HtmlSlash:
                    case HtmlEquals:
                    case HtmlStartQuoteString:
                    case HtmlStartDoubleQuoteString:
                    case HtmlHex:
                    case HtmlDecimal:
                    case HtmlName:
                    case HtmlEndQuoteString:
                    case HtmlQuoteString:
                    case HtmlEndDoubleQuoteString:
                    case HtmlDoubleQuoteString:
                    case Abstract:
                    case Array:
                    case As:
                    case BinaryCast:
                    case BoolType:
                    case BooleanConstant:
                    case Break:
                    case Callable:
                    case Case:
                    case Catch:
                    case Class:
                    case Clone:
                    case Const:
                    case Continue:
                    case Declare:
                    case Default:
                    case Do:
                    case DoubleCast:
                    case DoubleType:
                    case Echo:
                    case Else:
                    case ElseIf:
                    case Empty:
                    case EndDeclare:
                    case EndFor:
                    case EndForeach:
                    case EndIf:
                    case EndSwitch:
                    case EndWhile:
                    case Eval:
                    case Exit:
                    case Extends:
                    case Final:
                    case Finally:
                    case FloatCast:
                    case For:
                    case Foreach:
                    case Function_:
                    case Global:
                    case Goto:
                    case If:
                    case Implements:
                    case Import:
                    case Include:
                    case IncludeOnce:
                    case InstanceOf:
                    case InsteadOf:
                    case Int8Cast:
                    case Int16Cast:
                    case Int64Type:
                    case IntType:
                    case Interface:
                    case IsSet:
                    case List:
                    case LogicalAnd:
                    case LogicalOr:
                    case LogicalXor:
                    case Match_:
                    case Namespace:
                    case New:
                    case Null:
                    case ObjectType:
                    case Parent_:
                    case Partial:
                    case Print:
                    case Private:
                    case Protected:
                    case Public:
                    case Require:
                    case RequireOnce:
                    case Resource:
                    case Return:
                    case Static:
                    case StringType:
                    case Switch:
                    case Throw:
                    case Trait:
                    case Try:
                    case Typeof:
                    case UintCast:
                    case UnicodeCast:
                    case Unset:
                    case Use:
                    case Var:
                    case While:
                    case Yield:
                    case From:
                    case LambdaFn:
                    case Get:
                    case Set:
                    case Call:
                    case CallStatic:
                    case Constructor:
                    case Destruct:
                    case Wakeup:
                    case Sleep:
                    case Autoload:
                    case IsSet__:
                    case Unset__:
                    case ToString__:
                    case Invoke:
                    case SetState:
                    case Clone__:
                    case DebugInfo:
                    case Namespace__:
                    case Class__:
                    case Traic__:
                    case Function__:
                    case Method__:
                    case Line__:
                    case File__:
                    case Dir__:
                    case Inc:
                    case Dec:
                    case NamespaceSeparator:
                    case Bang:
                    case Plus:
                    case Minus:
                    case Tilde:
                    case SuppressWarnings:
                    case Dollar:
                    case OpenRoundBracket:
                    case OpenSquareBracket:
                    case OpenCurlyBracket:
                    case SemiColon:
                    case VarName:
                    case Label:
                    case Octal:
                    case Decimal:
                    case Real:
                    case Hex:
                    case Binary:
                    case BackQuoteString:
                    case SingleQuoteString:
                    case DoubleQuote:
                    case StartNowDoc:
                    case StartHereDoc: {
                        setState(656);
                        statement();
                    }
                    break;
                    case Colon: {
                        setState(657);
                        match(Colon);
                        setState(658);
                        innerStatementList();
                        setState(659);
                        match(EndFor);
                        setState(660);
                        match(SemiColon);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ForInitContext forInit() throws RecognitionException {
        ForInitContext _localctx = new ForInitContext(_ctx, getState());
        enterRule(_localctx, 74, RULE_forInit);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(664);
                expressionList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ForUpdateContext forUpdate() throws RecognitionException {
        ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
        enterRule(_localctx, 76, RULE_forUpdate);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(666);
                expressionList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SwitchStatementContext switchStatement() throws RecognitionException {
        SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
        enterRule(_localctx, 78, RULE_switchStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(668);
                match(Switch);
                setState(669);
                parentheses();
                setState(693);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case OpenCurlyBracket: {
                        setState(670);
                        match(OpenCurlyBracket);
                        setState(672);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == SemiColon) {
                            {
                                setState(671);
                                match(SemiColon);
                            }
                        }

                        setState(677);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == Case || _la == Default) {
                            {
                                {
                                    setState(674);
                                    switchBlock();
                                }
                            }
                            setState(679);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(680);
                        match(CloseCurlyBracket);
                    }
                    break;
                    case Colon: {
                        setState(681);
                        match(Colon);
                        setState(683);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == SemiColon) {
                            {
                                setState(682);
                                match(SemiColon);
                            }
                        }

                        setState(688);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == Case || _la == Default) {
                            {
                                {
                                    setState(685);
                                    switchBlock();
                                }
                            }
                            setState(690);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(691);
                        match(EndSwitch);
                        setState(692);
                        match(SemiColon);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SwitchBlockContext switchBlock() throws RecognitionException {
        SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
        enterRule(_localctx, 80, RULE_switchBlock);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(701);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(698);
                                _errHandler.sync(this);
                                switch (_input.LA(1)) {
                                    case Case: {
                                        setState(695);
                                        match(Case);
                                        setState(696);
                                        expression(0);
                                    }
                                    break;
                                    case Default: {
                                        setState(697);
                                        match(Default);
                                    }
                                    break;
                                    default:
                                        throw new NoViableAltException(this);
                                }
                                setState(700);
                                _la = _input.LA(1);
                                if (!(_la == Colon || _la == SemiColon)) {
                                    _errHandler.recoverInline(this);
                                } else {
                                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                    _errHandler.reportMatch(this);
                                    consume();
                                }
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(703);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 64, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                setState(705);
                innerStatementList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BreakStatementContext breakStatement() throws RecognitionException {
        BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
        enterRule(_localctx, 82, RULE_breakStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(707);
                match(Break);
                setState(709);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                    {
                        setState(708);
                        expression(0);
                    }
                }

                setState(711);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ContinueStatementContext continueStatement() throws RecognitionException {
        ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
        enterRule(_localctx, 84, RULE_continueStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(713);
                match(Continue);
                setState(715);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                    {
                        setState(714);
                        expression(0);
                    }
                }

                setState(717);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ReturnStatementContext returnStatement() throws RecognitionException {
        ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
        enterRule(_localctx, 86, RULE_returnStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(719);
                match(Return);
                setState(721);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                    {
                        setState(720);
                        expression(0);
                    }
                }

                setState(723);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionStatementContext expressionStatement() throws RecognitionException {
        ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
        enterRule(_localctx, 88, RULE_expressionStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(725);
                expression(0);
                setState(726);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final UnsetStatementContext unsetStatement() throws RecognitionException {
        UnsetStatementContext _localctx = new UnsetStatementContext(_ctx, getState());
        enterRule(_localctx, 90, RULE_unsetStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(728);
                match(Unset);
                setState(729);
                match(OpenRoundBracket);
                setState(730);
                chainList();
                setState(731);
                match(CloseRoundBracket);
                setState(732);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ForeachStatementContext foreachStatement() throws RecognitionException {
        ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
        enterRule(_localctx, 92, RULE_foreachStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(734);
                match(Foreach);
                setState(773);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 73, _ctx)) {
                    case 1: {
                        setState(735);
                        match(OpenRoundBracket);
                        setState(736);
                        chain();
                        setState(737);
                        match(As);
                        setState(739);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Ampersand) {
                            {
                                setState(738);
                                match(Ampersand);
                            }
                        }

                        setState(741);
                        assignable();
                        setState(747);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == DoubleArrow) {
                            {
                                setState(742);
                                match(DoubleArrow);
                                setState(744);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                if (_la == Ampersand) {
                                    {
                                        setState(743);
                                        match(Ampersand);
                                    }
                                }

                                setState(746);
                                chain();
                            }
                        }

                        setState(749);
                        match(CloseRoundBracket);
                    }
                    break;
                    case 2: {
                        setState(751);
                        match(OpenRoundBracket);
                        setState(752);
                        expression(0);
                        setState(753);
                        match(As);
                        setState(754);
                        assignable();
                        setState(760);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == DoubleArrow) {
                            {
                                setState(755);
                                match(DoubleArrow);
                                setState(757);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                if (_la == Ampersand) {
                                    {
                                        setState(756);
                                        match(Ampersand);
                                    }
                                }

                                setState(759);
                                chain();
                            }
                        }

                        setState(762);
                        match(CloseRoundBracket);
                    }
                    break;
                    case 3: {
                        setState(764);
                        match(OpenRoundBracket);
                        setState(765);
                        chain();
                        setState(766);
                        match(As);
                        setState(767);
                        match(List);
                        setState(768);
                        match(OpenRoundBracket);
                        setState(769);
                        assignmentList();
                        setState(770);
                        match(CloseRoundBracket);
                        setState(771);
                        match(CloseRoundBracket);
                    }
                    break;
                }
                setState(781);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case HtmlText:
                    case XmlStart:
                    case HtmlDtd:
                    case HtmlOpen:
                    case HtmlClose:
                    case HtmlSlashClose:
                    case HtmlSlash:
                    case HtmlEquals:
                    case HtmlStartQuoteString:
                    case HtmlStartDoubleQuoteString:
                    case HtmlHex:
                    case HtmlDecimal:
                    case HtmlName:
                    case HtmlEndQuoteString:
                    case HtmlQuoteString:
                    case HtmlEndDoubleQuoteString:
                    case HtmlDoubleQuoteString:
                    case Abstract:
                    case Array:
                    case As:
                    case BinaryCast:
                    case BoolType:
                    case BooleanConstant:
                    case Break:
                    case Callable:
                    case Case:
                    case Catch:
                    case Class:
                    case Clone:
                    case Const:
                    case Continue:
                    case Declare:
                    case Default:
                    case Do:
                    case DoubleCast:
                    case DoubleType:
                    case Echo:
                    case Else:
                    case ElseIf:
                    case Empty:
                    case EndDeclare:
                    case EndFor:
                    case EndForeach:
                    case EndIf:
                    case EndSwitch:
                    case EndWhile:
                    case Eval:
                    case Exit:
                    case Extends:
                    case Final:
                    case Finally:
                    case FloatCast:
                    case For:
                    case Foreach:
                    case Function_:
                    case Global:
                    case Goto:
                    case If:
                    case Implements:
                    case Import:
                    case Include:
                    case IncludeOnce:
                    case InstanceOf:
                    case InsteadOf:
                    case Int8Cast:
                    case Int16Cast:
                    case Int64Type:
                    case IntType:
                    case Interface:
                    case IsSet:
                    case List:
                    case LogicalAnd:
                    case LogicalOr:
                    case LogicalXor:
                    case Match_:
                    case Namespace:
                    case New:
                    case Null:
                    case ObjectType:
                    case Parent_:
                    case Partial:
                    case Print:
                    case Private:
                    case Protected:
                    case Public:
                    case Require:
                    case RequireOnce:
                    case Resource:
                    case Return:
                    case Static:
                    case StringType:
                    case Switch:
                    case Throw:
                    case Trait:
                    case Try:
                    case Typeof:
                    case UintCast:
                    case UnicodeCast:
                    case Unset:
                    case Use:
                    case Var:
                    case While:
                    case Yield:
                    case From:
                    case LambdaFn:
                    case Get:
                    case Set:
                    case Call:
                    case CallStatic:
                    case Constructor:
                    case Destruct:
                    case Wakeup:
                    case Sleep:
                    case Autoload:
                    case IsSet__:
                    case Unset__:
                    case ToString__:
                    case Invoke:
                    case SetState:
                    case Clone__:
                    case DebugInfo:
                    case Namespace__:
                    case Class__:
                    case Traic__:
                    case Function__:
                    case Method__:
                    case Line__:
                    case File__:
                    case Dir__:
                    case Inc:
                    case Dec:
                    case NamespaceSeparator:
                    case Bang:
                    case Plus:
                    case Minus:
                    case Tilde:
                    case SuppressWarnings:
                    case Dollar:
                    case OpenRoundBracket:
                    case OpenSquareBracket:
                    case OpenCurlyBracket:
                    case SemiColon:
                    case VarName:
                    case Label:
                    case Octal:
                    case Decimal:
                    case Real:
                    case Hex:
                    case Binary:
                    case BackQuoteString:
                    case SingleQuoteString:
                    case DoubleQuote:
                    case StartNowDoc:
                    case StartHereDoc: {
                        setState(775);
                        statement();
                    }
                    break;
                    case Colon: {
                        setState(776);
                        match(Colon);
                        setState(777);
                        innerStatementList();
                        setState(778);
                        match(EndForeach);
                        setState(779);
                        match(SemiColon);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TryCatchFinallyContext tryCatchFinally() throws RecognitionException {
        TryCatchFinallyContext _localctx = new TryCatchFinallyContext(_ctx, getState());
        enterRule(_localctx, 94, RULE_tryCatchFinally);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(783);
                match(Try);
                setState(784);
                blockStatement();
                setState(800);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 78, _ctx)) {
                    case 1: {
                        setState(786);
                        _errHandler.sync(this);
                        _alt = 1;
                        do {
                            switch (_alt) {
                                case 1: {
                                    {
                                        setState(785);
                                        catchClause();
                                    }
                                }
                                break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                            setState(788);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 75, _ctx);
                        } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                        setState(791);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 76, _ctx)) {
                            case 1: {
                                setState(790);
                                finallyStatement();
                            }
                            break;
                        }
                    }
                    break;
                    case 2: {
                        setState(796);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == Catch) {
                            {
                                {
                                    setState(793);
                                    catchClause();
                                }
                            }
                            setState(798);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(799);
                        finallyStatement();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CatchClauseContext catchClause() throws RecognitionException {
        CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
        enterRule(_localctx, 96, RULE_catchClause);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(802);
                match(Catch);
                setState(803);
                match(OpenRoundBracket);
                setState(804);
                qualifiedStaticTypeRef();
                setState(809);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Pipe) {
                    {
                        {
                            setState(805);
                            match(Pipe);
                            setState(806);
                            qualifiedStaticTypeRef();
                        }
                    }
                    setState(811);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(812);
                match(VarName);
                setState(813);
                match(CloseRoundBracket);
                setState(814);
                blockStatement();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FinallyStatementContext finallyStatement() throws RecognitionException {
        FinallyStatementContext _localctx = new FinallyStatementContext(_ctx, getState());
        enterRule(_localctx, 98, RULE_finallyStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(816);
                match(Finally);
                setState(817);
                blockStatement();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ThrowStatementContext throwStatement() throws RecognitionException {
        ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
        enterRule(_localctx, 100, RULE_throwStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(819);
                match(Throw);
                setState(820);
                expression(0);
                setState(821);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GotoStatementContext gotoStatement() throws RecognitionException {
        GotoStatementContext _localctx = new GotoStatementContext(_ctx, getState());
        enterRule(_localctx, 102, RULE_gotoStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(823);
                match(Goto);
                setState(824);
                identifier();
                setState(825);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DeclareStatementContext declareStatement() throws RecognitionException {
        DeclareStatementContext _localctx = new DeclareStatementContext(_ctx, getState());
        enterRule(_localctx, 104, RULE_declareStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(827);
                match(Declare);
                setState(828);
                match(OpenRoundBracket);
                setState(829);
                declareList();
                setState(830);
                match(CloseRoundBracket);
                setState(837);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case HtmlText:
                    case XmlStart:
                    case HtmlDtd:
                    case HtmlOpen:
                    case HtmlClose:
                    case HtmlSlashClose:
                    case HtmlSlash:
                    case HtmlEquals:
                    case HtmlStartQuoteString:
                    case HtmlStartDoubleQuoteString:
                    case HtmlHex:
                    case HtmlDecimal:
                    case HtmlName:
                    case HtmlEndQuoteString:
                    case HtmlQuoteString:
                    case HtmlEndDoubleQuoteString:
                    case HtmlDoubleQuoteString:
                    case Abstract:
                    case Array:
                    case As:
                    case BinaryCast:
                    case BoolType:
                    case BooleanConstant:
                    case Break:
                    case Callable:
                    case Case:
                    case Catch:
                    case Class:
                    case Clone:
                    case Const:
                    case Continue:
                    case Declare:
                    case Default:
                    case Do:
                    case DoubleCast:
                    case DoubleType:
                    case Echo:
                    case Else:
                    case ElseIf:
                    case Empty:
                    case EndDeclare:
                    case EndFor:
                    case EndForeach:
                    case EndIf:
                    case EndSwitch:
                    case EndWhile:
                    case Eval:
                    case Exit:
                    case Extends:
                    case Final:
                    case Finally:
                    case FloatCast:
                    case For:
                    case Foreach:
                    case Function_:
                    case Global:
                    case Goto:
                    case If:
                    case Implements:
                    case Import:
                    case Include:
                    case IncludeOnce:
                    case InstanceOf:
                    case InsteadOf:
                    case Int8Cast:
                    case Int16Cast:
                    case Int64Type:
                    case IntType:
                    case Interface:
                    case IsSet:
                    case List:
                    case LogicalAnd:
                    case LogicalOr:
                    case LogicalXor:
                    case Match_:
                    case Namespace:
                    case New:
                    case Null:
                    case ObjectType:
                    case Parent_:
                    case Partial:
                    case Print:
                    case Private:
                    case Protected:
                    case Public:
                    case Require:
                    case RequireOnce:
                    case Resource:
                    case Return:
                    case Static:
                    case StringType:
                    case Switch:
                    case Throw:
                    case Trait:
                    case Try:
                    case Typeof:
                    case UintCast:
                    case UnicodeCast:
                    case Unset:
                    case Use:
                    case Var:
                    case While:
                    case Yield:
                    case From:
                    case LambdaFn:
                    case Get:
                    case Set:
                    case Call:
                    case CallStatic:
                    case Constructor:
                    case Destruct:
                    case Wakeup:
                    case Sleep:
                    case Autoload:
                    case IsSet__:
                    case Unset__:
                    case ToString__:
                    case Invoke:
                    case SetState:
                    case Clone__:
                    case DebugInfo:
                    case Namespace__:
                    case Class__:
                    case Traic__:
                    case Function__:
                    case Method__:
                    case Line__:
                    case File__:
                    case Dir__:
                    case Inc:
                    case Dec:
                    case NamespaceSeparator:
                    case Bang:
                    case Plus:
                    case Minus:
                    case Tilde:
                    case SuppressWarnings:
                    case Dollar:
                    case OpenRoundBracket:
                    case OpenSquareBracket:
                    case OpenCurlyBracket:
                    case SemiColon:
                    case VarName:
                    case Label:
                    case Octal:
                    case Decimal:
                    case Real:
                    case Hex:
                    case Binary:
                    case BackQuoteString:
                    case SingleQuoteString:
                    case DoubleQuote:
                    case StartNowDoc:
                    case StartHereDoc: {
                        setState(831);
                        statement();
                    }
                    break;
                    case Colon: {
                        setState(832);
                        match(Colon);
                        setState(833);
                        innerStatementList();
                        setState(834);
                        match(EndDeclare);
                        setState(835);
                        match(SemiColon);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InlineHtmlStatementContext inlineHtmlStatement() throws RecognitionException {
        InlineHtmlStatementContext _localctx = new InlineHtmlStatementContext(_ctx, getState());
        enterRule(_localctx, 106, RULE_inlineHtmlStatement);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(840);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(839);
                                inlineHtml();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(842);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 81, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final DeclareListContext declareList() throws RecognitionException {
        DeclareListContext _localctx = new DeclareListContext(_ctx, getState());
        enterRule(_localctx, 108, RULE_declareList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(844);
                identifierInitializer();
                setState(849);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(845);
                            match(Comma);
                            setState(846);
                            identifierInitializer();
                        }
                    }
                    setState(851);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FormalParameterListContext formalParameterList() throws RecognitionException {
        FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
        enterRule(_localctx, 110, RULE_formalParameterList);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(853);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 40)) & ~0x3f) == 0 && ((1L << (_la - 40)) & -288230376151711745L) != 0 || (((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 562949936644095L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 3221356563L) != 0) {
                    {
                        setState(852);
                        formalParameter();
                    }
                }

                setState(859);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 84, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(855);
                                match(Comma);
                                setState(856);
                                formalParameter();
                            }
                        }
                    }
                    setState(861);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 84, _ctx);
                }
                setState(863);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Comma) {
                    {
                        setState(862);
                        match(Comma);
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FormalParameterContext formalParameter() throws RecognitionException {
        FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
        enterRule(_localctx, 112, RULE_formalParameter);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(866);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AttributeStart) {
                    {
                        setState(865);
                        attributes();
                    }
                }

                setState(869);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 87, _ctx)) {
                    case 1: {
                        setState(868);
                        memberModifier();
                    }
                    break;
                }
                setState(872);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == QuestionMark) {
                    {
                        setState(871);
                        match(QuestionMark);
                    }
                }

                setState(875);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -144115188075855873L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 281474968322047L) != 0 || _la == NamespaceSeparator || _la == Label) {
                    {
                        setState(874);
                        typeHint(0);
                    }
                }

                setState(878);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Ampersand) {
                    {
                        setState(877);
                        match(Ampersand);
                    }
                }

                setState(881);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Ellipsis) {
                    {
                        setState(880);
                        match(Ellipsis);
                    }
                }

                setState(883);
                variableInitializer();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeHintContext typeHint() throws RecognitionException {
        return typeHint(0);
    }

    private TypeHintContext typeHint(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        TypeHintContext _localctx = new TypeHintContext(_ctx, _parentState);
        TypeHintContext _prevctx = _localctx;
        int _startState = 114;
        enterRecursionRule(_localctx, 114, RULE_typeHint, _p);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(889);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 92, _ctx)) {
                    case 1: {
                        setState(886);
                        qualifiedStaticTypeRef();
                    }
                    break;
                    case 2: {
                        setState(887);
                        match(Callable);
                    }
                    break;
                    case 3: {
                        setState(888);
                        primitiveType();
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(896);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 93, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            {
                                _localctx = new TypeHintContext(_parentctx, _parentState);
                                pushNewRecursionContext(_localctx, _startState, RULE_typeHint);
                                setState(891);
                                if (!(precpred(_ctx, 1)))
                                    throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                setState(892);
                                match(Pipe);
                                setState(893);
                                typeHint(2);
                            }
                        }
                    }
                    setState(898);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 93, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final GlobalStatementContext globalStatement() throws RecognitionException {
        GlobalStatementContext _localctx = new GlobalStatementContext(_ctx, getState());
        enterRule(_localctx, 116, RULE_globalStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(899);
                match(Global);
                setState(900);
                globalVar();
                setState(905);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(901);
                            match(Comma);
                            setState(902);
                            globalVar();
                        }
                    }
                    setState(907);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(908);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GlobalVarContext globalVar() throws RecognitionException {
        GlobalVarContext _localctx = new GlobalVarContext(_ctx, getState());
        enterRule(_localctx, 118, RULE_globalVar);
        try {
            setState(918);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 95, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(910);
                    match(VarName);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(911);
                    match(Dollar);
                    setState(912);
                    chain();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(913);
                    match(Dollar);
                    setState(914);
                    match(OpenCurlyBracket);
                    setState(915);
                    expression(0);
                    setState(916);
                    match(CloseCurlyBracket);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final EchoStatementContext echoStatement() throws RecognitionException {
        EchoStatementContext _localctx = new EchoStatementContext(_ctx, getState());
        enterRule(_localctx, 120, RULE_echoStatement);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(920);
                match(Echo);
                setState(921);
                expressionList();
                setState(922);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StaticVariableStatementContext staticVariableStatement() throws RecognitionException {
        StaticVariableStatementContext _localctx = new StaticVariableStatementContext(_ctx, getState());
        enterRule(_localctx, 122, RULE_staticVariableStatement);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(924);
                match(Static);
                setState(925);
                variableInitializer();
                setState(930);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(926);
                            match(Comma);
                            setState(927);
                            variableInitializer();
                        }
                    }
                    setState(932);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(933);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClassStatementContext classStatement() throws RecognitionException {
        ClassStatementContext _localctx = new ClassStatementContext(_ctx, getState());
        enterRule(_localctx, 124, RULE_classStatement);
        int _la;
        try {
            setState(993);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case AttributeStart:
                case Abstract:
                case Const:
                case Final:
                case Function_:
                case Private:
                case Protected:
                case Public:
                case Static:
                case Var:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(936);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == AttributeStart) {
                        {
                            setState(935);
                            attributes();
                        }
                    }

                    setState(987);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 107, _ctx)) {
                        case 1: {
                            setState(938);
                            propertyModifiers();
                            setState(940);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -144115188075855873L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 281474968322047L) != 0 || _la == NamespaceSeparator || _la == Label) {
                                {
                                    setState(939);
                                    typeHint(0);
                                }
                            }

                            setState(942);
                            variableInitializer();
                            setState(947);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            while (_la == Comma) {
                                {
                                    {
                                        setState(943);
                                        match(Comma);
                                        setState(944);
                                        variableInitializer();
                                    }
                                }
                                setState(949);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                            }
                            setState(950);
                            match(SemiColon);
                        }
                        break;
                        case 2: {
                            setState(953);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == Abstract || (((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 1159641169921L) != 0) {
                                {
                                    setState(952);
                                    memberModifiers();
                                }
                            }

                            setState(985);
                            _errHandler.sync(this);
                            switch (_input.LA(1)) {
                                case Const: {
                                    setState(955);
                                    match(Const);
                                    setState(957);
                                    _errHandler.sync(this);
                                    switch (getInterpreter().adaptivePredict(_input, 101, _ctx)) {
                                        case 1: {
                                            setState(956);
                                            typeHint(0);
                                        }
                                        break;
                                    }
                                    setState(959);
                                    identifierInitializer();
                                    setState(964);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    while (_la == Comma) {
                                        {
                                            {
                                                setState(960);
                                                match(Comma);
                                                setState(961);
                                                identifierInitializer();
                                            }
                                        }
                                        setState(966);
                                        _errHandler.sync(this);
                                        _la = _input.LA(1);
                                    }
                                    setState(967);
                                    match(SemiColon);
                                }
                                break;
                                case Function_: {
                                    setState(969);
                                    match(Function_);
                                    setState(971);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if (_la == Ampersand) {
                                        {
                                            setState(970);
                                            match(Ampersand);
                                        }
                                    }

                                    setState(973);
                                    identifier();
                                    setState(975);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if (_la == Lgeneric) {
                                        {
                                            setState(974);
                                            typeParameterListInBrackets();
                                        }
                                    }

                                    setState(977);
                                    match(OpenRoundBracket);
                                    setState(978);
                                    formalParameterList();
                                    setState(979);
                                    match(CloseRoundBracket);
                                    setState(981);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if (_la == Colon) {
                                        {
                                            setState(980);
                                            baseCtorCall();
                                        }
                                    }

                                    setState(983);
                                    methodBody();
                                }
                                break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                        }
                        break;
                    }
                }
                break;
                case Use:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(989);
                    match(Use);
                    setState(990);
                    qualifiedNamespaceNameList();
                    setState(991);
                    traitAdaptations();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TraitAdaptationsContext traitAdaptations() throws RecognitionException {
        TraitAdaptationsContext _localctx = new TraitAdaptationsContext(_ctx, getState());
        enterRule(_localctx, 126, RULE_traitAdaptations);
        int _la;
        try {
            setState(1004);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case SemiColon:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(995);
                    match(SemiColon);
                }
                break;
                case OpenCurlyBracket:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(996);
                    match(OpenCurlyBracket);
                    setState(1000);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    while ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -144115188075855873L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 281474968322047L) != 0 || _la == NamespaceSeparator || _la == Label) {
                        {
                            {
                                setState(997);
                                traitAdaptationStatement();
                            }
                        }
                        setState(1002);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                    }
                    setState(1003);
                    match(CloseCurlyBracket);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TraitAdaptationStatementContext traitAdaptationStatement() throws RecognitionException {
        TraitAdaptationStatementContext _localctx = new TraitAdaptationStatementContext(_ctx, getState());
        enterRule(_localctx, 128, RULE_traitAdaptationStatement);
        try {
            setState(1008);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 111, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1006);
                    traitPrecedence();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1007);
                    traitAlias();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TraitPrecedenceContext traitPrecedence() throws RecognitionException {
        TraitPrecedenceContext _localctx = new TraitPrecedenceContext(_ctx, getState());
        enterRule(_localctx, 130, RULE_traitPrecedence);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1010);
                qualifiedNamespaceName();
                setState(1011);
                match(DoubleColon);
                setState(1012);
                identifier();
                setState(1013);
                match(InsteadOf);
                setState(1014);
                qualifiedNamespaceNameList();
                setState(1015);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TraitAliasContext traitAlias() throws RecognitionException {
        TraitAliasContext _localctx = new TraitAliasContext(_ctx, getState());
        enterRule(_localctx, 132, RULE_traitAlias);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1017);
                traitMethodReference();
                setState(1018);
                match(As);
                setState(1024);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 113, _ctx)) {
                    case 1: {
                        setState(1019);
                        memberModifier();
                    }
                    break;
                    case 2: {
                        setState(1021);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 112, _ctx)) {
                            case 1: {
                                setState(1020);
                                memberModifier();
                            }
                            break;
                        }
                        setState(1023);
                        identifier();
                    }
                    break;
                }
                setState(1026);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TraitMethodReferenceContext traitMethodReference() throws RecognitionException {
        TraitMethodReferenceContext _localctx = new TraitMethodReferenceContext(_ctx, getState());
        enterRule(_localctx, 134, RULE_traitMethodReference);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1031);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 114, _ctx)) {
                    case 1: {
                        setState(1028);
                        qualifiedNamespaceName();
                        setState(1029);
                        match(DoubleColon);
                    }
                    break;
                }
                setState(1033);
                identifier();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final BaseCtorCallContext baseCtorCall() throws RecognitionException {
        BaseCtorCallContext _localctx = new BaseCtorCallContext(_ctx, getState());
        enterRule(_localctx, 136, RULE_baseCtorCall);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1035);
                match(Colon);
                setState(1036);
                identifier();
                setState(1038);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == OpenRoundBracket) {
                    {
                        setState(1037);
                        arguments();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MethodBodyContext methodBody() throws RecognitionException {
        MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
        enterRule(_localctx, 138, RULE_methodBody);
        try {
            setState(1042);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case SemiColon:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1040);
                    match(SemiColon);
                }
                break;
                case OpenCurlyBracket:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1041);
                    blockStatement();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PropertyModifiersContext propertyModifiers() throws RecognitionException {
        PropertyModifiersContext _localctx = new PropertyModifiersContext(_ctx, getState());
        enterRule(_localctx, 140, RULE_propertyModifiers);
        try {
            setState(1046);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Abstract:
                case Final:
                case Private:
                case Protected:
                case Public:
                case Static:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1044);
                    memberModifiers();
                }
                break;
                case Var:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1045);
                    match(Var);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MemberModifiersContext memberModifiers() throws RecognitionException {
        MemberModifiersContext _localctx = new MemberModifiersContext(_ctx, getState());
        enterRule(_localctx, 142, RULE_memberModifiers);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1049);
                _errHandler.sync(this);
                _alt = 1;
                do {
                    switch (_alt) {
                        case 1: {
                            {
                                setState(1048);
                                memberModifier();
                            }
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1051);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 118, _ctx);
                } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final VariableInitializerContext variableInitializer() throws RecognitionException {
        VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
        enterRule(_localctx, 144, RULE_variableInitializer);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1053);
                match(VarName);
                setState(1056);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Eq) {
                    {
                        setState(1054);
                        match(Eq);
                        setState(1055);
                        constantInitializer();
                    }
                }

            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IdentifierInitializerContext identifierInitializer() throws RecognitionException {
        IdentifierInitializerContext _localctx = new IdentifierInitializerContext(_ctx, getState());
        enterRule(_localctx, 146, RULE_identifierInitializer);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1058);
                identifier();
                setState(1059);
                match(Eq);
                setState(1060);
                constantInitializer();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final GlobalConstantDeclarationContext globalConstantDeclaration() throws RecognitionException {
        GlobalConstantDeclarationContext _localctx = new GlobalConstantDeclarationContext(_ctx, getState());
        enterRule(_localctx, 148, RULE_globalConstantDeclaration);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1063);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AttributeStart) {
                    {
                        setState(1062);
                        attributes();
                    }
                }

                setState(1065);
                match(Const);
                setState(1066);
                identifierInitializer();
                setState(1071);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(1067);
                            match(Comma);
                            setState(1068);
                            identifierInitializer();
                        }
                    }
                    setState(1073);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1074);
                match(SemiColon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionListContext expressionList() throws RecognitionException {
        ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
        enterRule(_localctx, 150, RULE_expressionList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1076);
                expression(0);
                setState(1081);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(1077);
                            match(Comma);
                            setState(1078);
                            expression(0);
                        }
                    }
                    setState(1083);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ParenthesesContext parentheses() throws RecognitionException {
        ParenthesesContext _localctx = new ParenthesesContext(_ctx, getState());
        enterRule(_localctx, 152, RULE_parentheses);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1084);
                match(OpenRoundBracket);
                setState(1087);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 123, _ctx)) {
                    case 1: {
                        setState(1085);
                        expression(0);
                    }
                    break;
                    case 2: {
                        setState(1086);
                        yieldExpression();
                    }
                    break;
                }
                setState(1089);
                match(CloseRoundBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ExpressionContext expression() throws RecognitionException {
        return expression(0);
    }

    private ExpressionContext expression(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
        ExpressionContext _prevctx = _localctx;
        int _startState = 154;
        enterRecursionRule(_localctx, 154, RULE_expression, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1177);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 128, _ctx)) {
                    case 1: {
                        _localctx = new CloneExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;

                        setState(1092);
                        match(Clone);
                        setState(1093);
                        expression(47);
                    }
                    break;
                    case 2: {
                        _localctx = new NewExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1094);
                        newExpr();
                    }
                    break;
                    case 3: {
                        _localctx = new IndexerExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1095);
                        stringConstant();
                        setState(1096);
                        match(OpenSquareBracket);
                        setState(1097);
                        expression(0);
                        setState(1098);
                        match(CloseSquareBracket);
                    }
                    break;
                    case 4: {
                        _localctx = new CastExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1100);
                        match(OpenRoundBracket);
                        setState(1101);
                        castOperation();
                        setState(1102);
                        match(CloseRoundBracket);
                        setState(1103);
                        expression(44);
                    }
                    break;
                    case 5: {
                        _localctx = new UnaryOperatorExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1105);
                        _la = _input.LA(1);
                        if (!(_la == Tilde || _la == SuppressWarnings)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(1106);
                        expression(43);
                    }
                    break;
                    case 6: {
                        _localctx = new UnaryOperatorExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1107);
                        _la = _input.LA(1);
                        if (!((((_la - 192)) & ~0x3f) == 0 && ((1L << (_la - 192)) & 13L) != 0)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(1108);
                        expression(42);
                    }
                    break;
                    case 7: {
                        _localctx = new PrefixIncDecExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1109);
                        _la = _input.LA(1);
                        if (!(_la == Inc || _la == Dec)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(1110);
                        chain();
                    }
                    break;
                    case 8: {
                        _localctx = new PostfixIncDecExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1111);
                        chain();
                        setState(1112);
                        _la = _input.LA(1);
                        if (!(_la == Inc || _la == Dec)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                    }
                    break;
                    case 9: {
                        _localctx = new PrintExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1114);
                        match(Print);
                        setState(1115);
                        expression(39);
                    }
                    break;
                    case 10: {
                        _localctx = new ArrayCreationExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1116);
                        arrayCreation();
                    }
                    break;
                    case 11: {
                        _localctx = new ChainExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1117);
                        chain();
                    }
                    break;
                    case 12: {
                        _localctx = new ScalarExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1118);
                        constant();
                    }
                    break;
                    case 13: {
                        _localctx = new ScalarExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1119);
                        string();
                    }
                    break;
                    case 14: {
                        _localctx = new ScalarExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1120);
                        match(Label);
                    }
                    break;
                    case 15: {
                        _localctx = new BackQuoteStringExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1121);
                        match(BackQuoteString);
                    }
                    break;
                    case 16: {
                        _localctx = new ParenthesisExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1122);
                        parentheses();
                    }
                    break;
                    case 17: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1123);
                        match(Yield);
                    }
                    break;
                    case 18: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1124);
                        match(List);
                        setState(1125);
                        match(OpenRoundBracket);
                        setState(1126);
                        assignmentList();
                        setState(1127);
                        match(CloseRoundBracket);
                        setState(1128);
                        match(Eq);
                        setState(1129);
                        expression(30);
                    }
                    break;
                    case 19: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1131);
                        match(IsSet);
                        setState(1132);
                        match(OpenRoundBracket);
                        setState(1133);
                        chainList();
                        setState(1134);
                        match(CloseRoundBracket);
                    }
                    break;
                    case 20: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1136);
                        match(Empty);
                        setState(1137);
                        match(OpenRoundBracket);
                        setState(1138);
                        chain();
                        setState(1139);
                        match(CloseRoundBracket);
                    }
                    break;
                    case 21: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1141);
                        match(Eval);
                        setState(1142);
                        match(OpenRoundBracket);
                        setState(1143);
                        expression(0);
                        setState(1144);
                        match(CloseRoundBracket);
                    }
                    break;
                    case 22: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1146);
                        match(Exit);
                        setState(1150);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 124, _ctx)) {
                            case 1: {
                                setState(1147);
                                match(OpenRoundBracket);
                                setState(1148);
                                match(CloseRoundBracket);
                            }
                            break;
                            case 2: {
                                setState(1149);
                                parentheses();
                            }
                            break;
                        }
                    }
                    break;
                    case 23: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1152);
                        _la = _input.LA(1);
                        if (!(_la == Include || _la == IncludeOnce)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(1153);
                        expression(25);
                    }
                    break;
                    case 24: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1154);
                        _la = _input.LA(1);
                        if (!(_la == Require || _la == RequireOnce)) {
                            _errHandler.recoverInline(this);
                        } else {
                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                            _errHandler.reportMatch(this);
                            consume();
                        }
                        setState(1155);
                        expression(24);
                    }
                    break;
                    case 25: {
                        _localctx = new LambdaFunctionExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1156);
                        lambdaFunctionExpr();
                    }
                    break;
                    case 26: {
                        _localctx = new MatchExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1157);
                        matchExpr();
                    }
                    break;
                    case 27: {
                        _localctx = new SpecialWordExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1158);
                        match(Throw);
                        setState(1159);
                        expression(6);
                    }
                    break;
                    case 28: {
                        _localctx = new AssignmentExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1160);
                        assignable();
                        setState(1161);
                        assignmentOperator();
                        setState(1163);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == AttributeStart) {
                            {
                                setState(1162);
                                attributes();
                            }
                        }

                        setState(1165);
                        expression(5);
                    }
                    break;
                    case 29: {
                        _localctx = new AssignmentExpressionContext(_localctx);
                        _ctx = _localctx;
                        _prevctx = _localctx;
                        setState(1167);
                        assignable();
                        setState(1168);
                        match(Eq);
                        setState(1170);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == AttributeStart) {
                            {
                                setState(1169);
                                attributes();
                            }
                        }

                        setState(1172);
                        match(Ampersand);
                        setState(1175);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 127, _ctx)) {
                            case 1: {
                                setState(1173);
                                chain();
                            }
                            break;
                            case 2: {
                                setState(1174);
                                newExpr();
                            }
                            break;
                        }
                    }
                    break;
                }
                _ctx.stop = _input.LT(-1);
                setState(1239);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 131, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(1237);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 130, _ctx)) {
                                case 1: {
                                    _localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1179);
                                    if (!(precpred(_ctx, 21)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 21)");
                                    setState(1180);
                                    ((ArithmeticExpressionContext) _localctx).op = match(Pow);
                                    setState(1181);
                                    expression(21);
                                }
                                break;
                                case 2: {
                                    _localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1182);
                                    if (!(precpred(_ctx, 19)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 19)");
                                    setState(1183);
                                    ((ArithmeticExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la - 196)) & ~0x3f) == 0 && ((1L << (_la - 196)) & 7L) != 0)) {
                                        ((ArithmeticExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(1184);
                                    expression(20);
                                }
                                break;
                                case 3: {
                                    _localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1185);
                                    if (!(precpred(_ctx, 18)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 18)");
                                    setState(1186);
                                    ((ArithmeticExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 259L) != 0)) {
                                        ((ArithmeticExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(1187);
                                    expression(19);
                                }
                                break;
                                case 4: {
                                    _localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1188);
                                    if (!(precpred(_ctx, 17)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 17)");
                                    setState(1189);
                                    ((ComparisonExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!(_la == ShiftLeft || _la == ShiftRight)) {
                                        ((ComparisonExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(1190);
                                    expression(18);
                                }
                                break;
                                case 5: {
                                    _localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1191);
                                    if (!(precpred(_ctx, 16)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 16)");
                                    setState(1192);
                                    ((ComparisonExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la - 163)) & ~0x3f) == 0 && ((1L << (_la - 163)) & 100663299L) != 0)) {
                                        ((ComparisonExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(1193);
                                    expression(17);
                                }
                                break;
                                case 6: {
                                    _localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1194);
                                    if (!(precpred(_ctx, 15)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 15)");
                                    setState(1195);
                                    ((ComparisonExpressionContext) _localctx).op = _input.LT(1);
                                    _la = _input.LA(1);
                                    if (!((((_la - 159)) & ~0x3f) == 0 && ((1L << (_la - 159)) & 15L) != 0)) {
                                        ((ComparisonExpressionContext) _localctx).op = (Token) _errHandler.recoverInline(this);
                                    } else {
                                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                        _errHandler.reportMatch(this);
                                        consume();
                                    }
                                    setState(1196);
                                    expression(16);
                                }
                                break;
                                case 7: {
                                    _localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1197);
                                    if (!(precpred(_ctx, 14)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 14)");
                                    setState(1198);
                                    ((BitwiseExpressionContext) _localctx).op = match(Ampersand);
                                    setState(1199);
                                    expression(15);
                                }
                                break;
                                case 8: {
                                    _localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1200);
                                    if (!(precpred(_ctx, 13)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 13)");
                                    setState(1201);
                                    ((BitwiseExpressionContext) _localctx).op = match(Caret);
                                    setState(1202);
                                    expression(14);
                                }
                                break;
                                case 9: {
                                    _localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1203);
                                    if (!(precpred(_ctx, 12)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 12)");
                                    setState(1204);
                                    ((BitwiseExpressionContext) _localctx).op = match(Pipe);
                                    setState(1205);
                                    expression(13);
                                }
                                break;
                                case 10: {
                                    _localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1206);
                                    if (!(precpred(_ctx, 11)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 11)");
                                    setState(1207);
                                    ((BitwiseExpressionContext) _localctx).op = match(BooleanAnd);
                                    setState(1208);
                                    expression(12);
                                }
                                break;
                                case 11: {
                                    _localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1209);
                                    if (!(precpred(_ctx, 10)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 10)");
                                    setState(1210);
                                    ((BitwiseExpressionContext) _localctx).op = match(BooleanOr);
                                    setState(1211);
                                    expression(11);
                                }
                                break;
                                case 12: {
                                    _localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1212);
                                    if (!(precpred(_ctx, 9)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                    setState(1213);
                                    ((ConditionalExpressionContext) _localctx).op = match(QuestionMark);
                                    setState(1215);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                    if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                                        {
                                            setState(1214);
                                            expression(0);
                                        }
                                    }

                                    setState(1217);
                                    match(Colon);
                                    setState(1218);
                                    expression(10);
                                }
                                break;
                                case 13: {
                                    _localctx = new NullCoalescingExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1219);
                                    if (!(precpred(_ctx, 8)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                    setState(1220);
                                    ((NullCoalescingExpressionContext) _localctx).op = match(NullCoalescing);
                                    setState(1221);
                                    expression(9);
                                }
                                break;
                                case 14: {
                                    _localctx = new SpaceshipExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1222);
                                    if (!(precpred(_ctx, 7)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 7)");
                                    setState(1223);
                                    ((SpaceshipExpressionContext) _localctx).op = match(Spaceship);
                                    setState(1224);
                                    expression(8);
                                }
                                break;
                                case 15: {
                                    _localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1225);
                                    if (!(precpred(_ctx, 3)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                    setState(1226);
                                    ((LogicalExpressionContext) _localctx).op = match(LogicalAnd);
                                    setState(1227);
                                    expression(4);
                                }
                                break;
                                case 16: {
                                    _localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1228);
                                    if (!(precpred(_ctx, 2)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                    setState(1229);
                                    ((LogicalExpressionContext) _localctx).op = match(LogicalXor);
                                    setState(1230);
                                    expression(3);
                                }
                                break;
                                case 17: {
                                    _localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1231);
                                    if (!(precpred(_ctx, 1)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                    setState(1232);
                                    ((LogicalExpressionContext) _localctx).op = match(LogicalOr);
                                    setState(1233);
                                    expression(2);
                                }
                                break;
                                case 18: {
                                    _localctx = new InstanceOfExpressionContext(new ExpressionContext(_parentctx, _parentState));
                                    pushNewRecursionContext(_localctx, _startState, RULE_expression);
                                    setState(1234);
                                    if (!(precpred(_ctx, 20)))
                                        throw new FailedPredicateException(this, "precpred(_ctx, 20)");
                                    setState(1235);
                                    match(InstanceOf);
                                    setState(1236);
                                    typeRef();
                                }
                                break;
                            }
                        }
                    }
                    setState(1241);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 131, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    public final AssignableContext assignable() throws RecognitionException {
        AssignableContext _localctx = new AssignableContext(_ctx, getState());
        enterRule(_localctx, 156, RULE_assignable);
        try {
            setState(1244);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 132, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1242);
                    chain();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1243);
                    arrayCreation();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArrayCreationContext arrayCreation() throws RecognitionException {
        ArrayCreationContext _localctx = new ArrayCreationContext(_ctx, getState());
        enterRule(_localctx, 158, RULE_arrayCreation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1257);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case Array: {
                        setState(1246);
                        match(Array);
                        setState(1247);
                        match(OpenRoundBracket);
                        setState(1249);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138193L) != 0) {
                            {
                                setState(1248);
                                arrayItemList();
                            }
                        }

                        setState(1251);
                        match(CloseRoundBracket);
                    }
                    break;
                    case OpenSquareBracket: {
                        setState(1252);
                        match(OpenSquareBracket);
                        setState(1254);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138193L) != 0) {
                            {
                                setState(1253);
                                arrayItemList();
                            }
                        }

                        setState(1256);
                        match(CloseSquareBracket);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1263);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 136, _ctx)) {
                    case 1: {
                        setState(1259);
                        match(OpenSquareBracket);
                        setState(1260);
                        expression(0);
                        setState(1261);
                        match(CloseSquareBracket);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LambdaFunctionExprContext lambdaFunctionExpr() throws RecognitionException {
        LambdaFunctionExprContext _localctx = new LambdaFunctionExprContext(_ctx, getState());
        enterRule(_localctx, 160, RULE_lambdaFunctionExpr);
        int _la;
        try {
            setState(1291);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Function_:
                case Static:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1266);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Static) {
                        {
                            setState(1265);
                            match(Static);
                        }
                    }

                    setState(1268);
                    match(Function_);
                    setState(1270);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Ampersand) {
                        {
                            setState(1269);
                            match(Ampersand);
                        }
                    }

                    setState(1272);
                    match(OpenRoundBracket);
                    setState(1273);
                    formalParameterList();
                    setState(1274);
                    match(CloseRoundBracket);
                    setState(1276);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Use) {
                        {
                            setState(1275);
                            lambdaFunctionUseVars();
                        }
                    }

                    setState(1280);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Colon) {
                        {
                            setState(1278);
                            match(Colon);
                            setState(1279);
                            typeHint(0);
                        }
                    }

                    setState(1282);
                    blockStatement();
                }
                break;
                case LambdaFn:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1284);
                    match(LambdaFn);
                    setState(1285);
                    match(OpenRoundBracket);
                    setState(1286);
                    formalParameterList();
                    setState(1287);
                    match(CloseRoundBracket);
                    setState(1288);
                    match(DoubleArrow);
                    setState(1289);
                    expression(0);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MatchExprContext matchExpr() throws RecognitionException {
        MatchExprContext _localctx = new MatchExprContext(_ctx, getState());
        enterRule(_localctx, 162, RULE_matchExpr);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1293);
                match(Match_);
                setState(1294);
                match(OpenRoundBracket);
                setState(1295);
                expression(0);
                setState(1296);
                match(CloseRoundBracket);
                setState(1297);
                match(OpenCurlyBracket);
                setState(1298);
                matchItem();
                setState(1303);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 142, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1299);
                                match(Comma);
                                setState(1300);
                                matchItem();
                            }
                        }
                    }
                    setState(1305);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 142, _ctx);
                }
                setState(1307);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Comma) {
                    {
                        setState(1306);
                        match(Comma);
                    }
                }

                setState(1309);
                match(CloseCurlyBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MatchItemContext matchItem() throws RecognitionException {
        MatchItemContext _localctx = new MatchItemContext(_ctx, getState());
        enterRule(_localctx, 164, RULE_matchItem);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1311);
                expression(0);
                setState(1316);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(1312);
                            match(Comma);
                            setState(1313);
                            expression(0);
                        }
                    }
                    setState(1318);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1319);
                match(DoubleArrow);
                setState(1320);
                expression(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NewExprContext newExpr() throws RecognitionException {
        NewExprContext _localctx = new NewExprContext(_ctx, getState());
        enterRule(_localctx, 166, RULE_newExpr);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1322);
                match(New);
                setState(1323);
                typeRef();
                setState(1325);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 145, _ctx)) {
                    case 1: {
                        setState(1324);
                        arguments();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
        AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
        enterRule(_localctx, 168, RULE_assignmentOperator);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1327);
                _la = _input.LA(1);
                if (!((((_la - 165)) & ~0x3f) == 0 && ((1L << (_la - 165)) & 281474976784375L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final YieldExpressionContext yieldExpression() throws RecognitionException {
        YieldExpressionContext _localctx = new YieldExpressionContext(_ctx, getState());
        enterRule(_localctx, 170, RULE_yieldExpression);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1329);
                match(Yield);
                setState(1337);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 147, _ctx)) {
                    case 1: {
                        setState(1330);
                        expression(0);
                        setState(1333);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == DoubleArrow) {
                            {
                                setState(1331);
                                match(DoubleArrow);
                                setState(1332);
                                expression(0);
                            }
                        }

                    }
                    break;
                    case 2: {
                        setState(1335);
                        match(From);
                        setState(1336);
                        expression(0);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArrayItemListContext arrayItemList() throws RecognitionException {
        ArrayItemListContext _localctx = new ArrayItemListContext(_ctx, getState());
        enterRule(_localctx, 172, RULE_arrayItemList);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1339);
                arrayItem();
                setState(1344);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 148, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1340);
                                match(Comma);
                                setState(1341);
                                arrayItem();
                            }
                        }
                    }
                    setState(1346);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 148, _ctx);
                }
                setState(1348);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 149, _ctx)) {
                    case 1: {
                        setState(1347);
                        match(Comma);
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArrayItemContext arrayItem() throws RecognitionException {
        ArrayItemContext _localctx = new ArrayItemContext(_ctx, getState());
        enterRule(_localctx, 174, RULE_arrayItem);
        int _la;
        try {
            setState(1362);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 152, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1350);
                    expression(0);
                    setState(1353);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == DoubleArrow) {
                        {
                            setState(1351);
                            match(DoubleArrow);
                            setState(1352);
                            expression(0);
                        }
                    }

                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1358);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                        {
                            setState(1355);
                            expression(0);
                            setState(1356);
                            match(DoubleArrow);
                        }
                    }

                    setState(1360);
                    match(Ampersand);
                    setState(1361);
                    chain();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LambdaFunctionUseVarsContext lambdaFunctionUseVars() throws RecognitionException {
        LambdaFunctionUseVarsContext _localctx = new LambdaFunctionUseVarsContext(_ctx, getState());
        enterRule(_localctx, 176, RULE_lambdaFunctionUseVars);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1364);
                match(Use);
                setState(1365);
                match(OpenRoundBracket);
                setState(1366);
                lambdaFunctionUseVar();
                setState(1371);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(1367);
                            match(Comma);
                            setState(1368);
                            lambdaFunctionUseVar();
                        }
                    }
                    setState(1373);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1374);
                match(CloseRoundBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LambdaFunctionUseVarContext lambdaFunctionUseVar() throws RecognitionException {
        LambdaFunctionUseVarContext _localctx = new LambdaFunctionUseVarContext(_ctx, getState());
        enterRule(_localctx, 178, RULE_lambdaFunctionUseVar);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1377);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Ampersand) {
                    {
                        setState(1376);
                        match(Ampersand);
                    }
                }

                setState(1379);
                match(VarName);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final QualifiedStaticTypeRefContext qualifiedStaticTypeRef() throws RecognitionException {
        QualifiedStaticTypeRefContext _localctx = new QualifiedStaticTypeRefContext(_ctx, getState());
        enterRule(_localctx, 180, RULE_qualifiedStaticTypeRef);
        try {
            setState(1386);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 156, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1381);
                    qualifiedNamespaceName();
                    setState(1383);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 155, _ctx)) {
                        case 1: {
                            setState(1382);
                            genericDynamicArgs();
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1385);
                    match(Static);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final TypeRefContext typeRef() throws RecognitionException {
        TypeRefContext _localctx = new TypeRefContext(_ctx, getState());
        enterRule(_localctx, 182, RULE_typeRef);
        try {
            setState(1398);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 159, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1390);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 157, _ctx)) {
                        case 1: {
                            setState(1388);
                            qualifiedNamespaceName();
                        }
                        break;
                        case 2: {
                            setState(1389);
                            indirectTypeRef();
                        }
                        break;
                    }
                    setState(1393);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 158, _ctx)) {
                        case 1: {
                            setState(1392);
                            genericDynamicArgs();
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1395);
                    primitiveType();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1396);
                    match(Static);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1397);
                    anonymousClass();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AnonymousClassContext anonymousClass() throws RecognitionException {
        AnonymousClassContext _localctx = new AnonymousClassContext(_ctx, getState());
        enterRule(_localctx, 184, RULE_anonymousClass);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1401);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == AttributeStart) {
                    {
                        setState(1400);
                        attributes();
                    }
                }

                setState(1404);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Private) {
                    {
                        setState(1403);
                        match(Private);
                    }
                }

                setState(1407);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Abstract || _la == Final) {
                    {
                        setState(1406);
                        modifier();
                    }
                }

                setState(1410);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Partial) {
                    {
                        setState(1409);
                        match(Partial);
                    }
                }

                setState(1433);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case Class:
                    case Trait: {
                        setState(1412);
                        classEntryType();
                        setState(1414);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Lgeneric) {
                            {
                                setState(1413);
                                typeParameterListInBrackets();
                            }
                        }

                        setState(1418);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Extends) {
                            {
                                setState(1416);
                                match(Extends);
                                setState(1417);
                                qualifiedStaticTypeRef();
                            }
                        }

                        setState(1422);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Implements) {
                            {
                                setState(1420);
                                match(Implements);
                                setState(1421);
                                interfaceList();
                            }
                        }

                    }
                    break;
                    case Interface: {
                        setState(1424);
                        match(Interface);
                        setState(1425);
                        identifier();
                        setState(1427);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Lgeneric) {
                            {
                                setState(1426);
                                typeParameterListInBrackets();
                            }
                        }

                        setState(1431);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == Extends) {
                            {
                                setState(1429);
                                match(Extends);
                                setState(1430);
                                interfaceList();
                            }
                        }

                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1435);
                match(OpenCurlyBracket);
                setState(1439);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((_la) & ~0x3f) == 0 && ((1L << _la) & 9010497789624320L) != 0 || (((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 3378859361697825L) != 0) {
                    {
                        {
                            setState(1436);
                            classStatement();
                        }
                    }
                    setState(1441);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(1442);
                match(CloseCurlyBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IndirectTypeRefContext indirectTypeRef() throws RecognitionException {
        IndirectTypeRefContext _localctx = new IndirectTypeRefContext(_ctx, getState());
        enterRule(_localctx, 186, RULE_indirectTypeRef);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1444);
                chainBase();
                setState(1449);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 171, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1445);
                                match(ObjectOperator);
                                setState(1446);
                                keyedFieldName();
                            }
                        }
                    }
                    setState(1451);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 171, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final QualifiedNamespaceNameContext qualifiedNamespaceName() throws RecognitionException {
        QualifiedNamespaceNameContext _localctx = new QualifiedNamespaceNameContext(_ctx, getState());
        enterRule(_localctx, 188, RULE_qualifiedNamespaceName);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1453);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 172, _ctx)) {
                    case 1: {
                        setState(1452);
                        match(Namespace);
                    }
                    break;
                }
                setState(1456);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == NamespaceSeparator) {
                    {
                        setState(1455);
                        match(NamespaceSeparator);
                    }
                }

                setState(1458);
                namespaceNameList();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NamespaceNameListContext namespaceNameList() throws RecognitionException {
        NamespaceNameListContext _localctx = new NamespaceNameListContext(_ctx, getState());
        enterRule(_localctx, 190, RULE_namespaceNameList);
        try {
            int _alt;
            setState(1473);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 176, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1460);
                    identifier();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1461);
                    identifier();
                    setState(1466);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 174, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1462);
                                    match(NamespaceSeparator);
                                    setState(1463);
                                    identifier();
                                }
                            }
                        }
                        setState(1468);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 174, _ctx);
                    }
                    setState(1471);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 175, _ctx)) {
                        case 1: {
                            setState(1469);
                            match(NamespaceSeparator);
                            setState(1470);
                            namespaceNameTail();
                        }
                        break;
                    }
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NamespaceNameTailContext namespaceNameTail() throws RecognitionException {
        NamespaceNameTailContext _localctx = new NamespaceNameTailContext(_ctx, getState());
        enterRule(_localctx, 192, RULE_namespaceNameTail);
        int _la;
        try {
            int _alt;
            setState(1494);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Abstract:
                case Array:
                case As:
                case BinaryCast:
                case BoolType:
                case BooleanConstant:
                case Break:
                case Callable:
                case Case:
                case Catch:
                case Class:
                case Clone:
                case Const:
                case Continue:
                case Declare:
                case Default:
                case Do:
                case DoubleCast:
                case DoubleType:
                case Echo:
                case Else:
                case ElseIf:
                case Empty:
                case EndDeclare:
                case EndFor:
                case EndForeach:
                case EndIf:
                case EndSwitch:
                case EndWhile:
                case Eval:
                case Exit:
                case Extends:
                case Final:
                case Finally:
                case FloatCast:
                case For:
                case Foreach:
                case Function_:
                case Global:
                case Goto:
                case If:
                case Implements:
                case Import:
                case Include:
                case IncludeOnce:
                case InstanceOf:
                case InsteadOf:
                case Int8Cast:
                case Int16Cast:
                case Int64Type:
                case IntType:
                case Interface:
                case IsSet:
                case List:
                case LogicalAnd:
                case LogicalOr:
                case LogicalXor:
                case Namespace:
                case New:
                case Null:
                case ObjectType:
                case Parent_:
                case Partial:
                case Print:
                case Private:
                case Protected:
                case Public:
                case Require:
                case RequireOnce:
                case Resource:
                case Return:
                case Static:
                case StringType:
                case Switch:
                case Throw:
                case Trait:
                case Try:
                case Typeof:
                case UintCast:
                case UnicodeCast:
                case Unset:
                case Use:
                case Var:
                case While:
                case Yield:
                case From:
                case Get:
                case Set:
                case Call:
                case CallStatic:
                case Constructor:
                case Destruct:
                case Wakeup:
                case Sleep:
                case Autoload:
                case IsSet__:
                case Unset__:
                case ToString__:
                case Invoke:
                case SetState:
                case Clone__:
                case DebugInfo:
                case Namespace__:
                case Class__:
                case Traic__:
                case Function__:
                case Method__:
                case Line__:
                case File__:
                case Dir__:
                case Label:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1475);
                    identifier();
                    setState(1478);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 177, _ctx)) {
                        case 1: {
                            setState(1476);
                            match(As);
                            setState(1477);
                            identifier();
                        }
                        break;
                    }
                }
                break;
                case OpenCurlyBracket:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1480);
                    match(OpenCurlyBracket);
                    setState(1481);
                    namespaceNameTail();
                    setState(1486);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 178, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1482);
                                    match(Comma);
                                    setState(1483);
                                    namespaceNameTail();
                                }
                            }
                        }
                        setState(1488);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 178, _ctx);
                    }
                    setState(1490);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Comma) {
                        {
                            setState(1489);
                            match(Comma);
                        }
                    }

                    setState(1492);
                    match(CloseCurlyBracket);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final QualifiedNamespaceNameListContext qualifiedNamespaceNameList() throws RecognitionException {
        QualifiedNamespaceNameListContext _localctx = new QualifiedNamespaceNameListContext(_ctx, getState());
        enterRule(_localctx, 194, RULE_qualifiedNamespaceNameList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1496);
                qualifiedNamespaceName();
                setState(1501);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(1497);
                            match(Comma);
                            setState(1498);
                            qualifiedNamespaceName();
                        }
                    }
                    setState(1503);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArgumentsContext arguments() throws RecognitionException {
        ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
        enterRule(_localctx, 196, RULE_arguments);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1504);
                match(OpenRoundBracket);
                setState(1514);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 183, _ctx)) {
                    case 1: {
                        setState(1505);
                        actualArgument();
                        setState(1510);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 182, _ctx);
                        while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                            if (_alt == 1) {
                                {
                                    {
                                        setState(1506);
                                        match(Comma);
                                        setState(1507);
                                        actualArgument();
                                    }
                                }
                            }
                            setState(1512);
                            _errHandler.sync(this);
                            _alt = getInterpreter().adaptivePredict(_input, 182, _ctx);
                        }
                    }
                    break;
                    case 2: {
                        setState(1513);
                        yieldExpression();
                    }
                    break;
                }
                setState(1517);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Comma) {
                    {
                        setState(1516);
                        match(Comma);
                    }
                }

                setState(1519);
                match(CloseRoundBracket);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ActualArgumentContext actualArgument() throws RecognitionException {
        ActualArgumentContext _localctx = new ActualArgumentContext(_ctx, getState());
        enterRule(_localctx, 198, RULE_actualArgument);
        int _la;
        try {
            setState(1530);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Abstract:
                case Array:
                case As:
                case BinaryCast:
                case BoolType:
                case BooleanConstant:
                case Break:
                case Callable:
                case Case:
                case Catch:
                case Class:
                case Clone:
                case Const:
                case Continue:
                case Declare:
                case Default:
                case Do:
                case DoubleCast:
                case DoubleType:
                case Echo:
                case Else:
                case ElseIf:
                case Empty:
                case EndDeclare:
                case EndFor:
                case EndForeach:
                case EndIf:
                case EndSwitch:
                case EndWhile:
                case Eval:
                case Exit:
                case Extends:
                case Final:
                case Finally:
                case FloatCast:
                case For:
                case Foreach:
                case Function_:
                case Global:
                case Goto:
                case If:
                case Implements:
                case Import:
                case Include:
                case IncludeOnce:
                case InstanceOf:
                case InsteadOf:
                case Int8Cast:
                case Int16Cast:
                case Int64Type:
                case IntType:
                case Interface:
                case IsSet:
                case List:
                case LogicalAnd:
                case LogicalOr:
                case LogicalXor:
                case Match_:
                case Namespace:
                case New:
                case Null:
                case ObjectType:
                case Parent_:
                case Partial:
                case Print:
                case Private:
                case Protected:
                case Public:
                case Require:
                case RequireOnce:
                case Resource:
                case Return:
                case Static:
                case StringType:
                case Switch:
                case Throw:
                case Trait:
                case Try:
                case Typeof:
                case UintCast:
                case UnicodeCast:
                case Unset:
                case Use:
                case Var:
                case While:
                case Yield:
                case From:
                case LambdaFn:
                case Get:
                case Set:
                case Call:
                case CallStatic:
                case Constructor:
                case Destruct:
                case Wakeup:
                case Sleep:
                case Autoload:
                case IsSet__:
                case Unset__:
                case ToString__:
                case Invoke:
                case SetState:
                case Clone__:
                case DebugInfo:
                case Namespace__:
                case Class__:
                case Traic__:
                case Function__:
                case Method__:
                case Line__:
                case File__:
                case Dir__:
                case Inc:
                case Dec:
                case NamespaceSeparator:
                case Ellipsis:
                case Bang:
                case Plus:
                case Minus:
                case Tilde:
                case SuppressWarnings:
                case Dollar:
                case OpenRoundBracket:
                case OpenSquareBracket:
                case VarName:
                case Label:
                case Octal:
                case Decimal:
                case Real:
                case Hex:
                case Binary:
                case BackQuoteString:
                case SingleQuoteString:
                case DoubleQuote:
                case StartNowDoc:
                case StartHereDoc:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1522);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 185, _ctx)) {
                        case 1: {
                            setState(1521);
                            argumentName();
                        }
                        break;
                    }
                    setState(1525);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if (_la == Ellipsis) {
                        {
                            setState(1524);
                            match(Ellipsis);
                        }
                    }

                    setState(1527);
                    expression(0);
                }
                break;
                case Ampersand:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1528);
                    match(Ampersand);
                    setState(1529);
                    chain();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ArgumentNameContext argumentName() throws RecognitionException {
        ArgumentNameContext _localctx = new ArgumentNameContext(_ctx, getState());
        enterRule(_localctx, 200, RULE_argumentName);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1532);
                identifier();
                setState(1533);
                match(Colon);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstantInitializerContext constantInitializer() throws RecognitionException {
        ConstantInitializerContext _localctx = new ConstantInitializerContext(_ctx, getState());
        enterRule(_localctx, 202, RULE_constantInitializer);
        int _la;
        try {
            setState(1556);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 192, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1535);
                    constant();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1536);
                    string();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1537);
                    match(Array);
                    setState(1538);
                    match(OpenRoundBracket);
                    setState(1543);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138193L) != 0) {
                        {
                            setState(1539);
                            arrayItemList();
                            setState(1541);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == Comma) {
                                {
                                    setState(1540);
                                    match(Comma);
                                }
                            }

                        }
                    }

                    setState(1545);
                    match(CloseRoundBracket);
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1546);
                    match(OpenSquareBracket);
                    setState(1551);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138193L) != 0) {
                        {
                            setState(1547);
                            arrayItemList();
                            setState(1549);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == Comma) {
                                {
                                    setState(1548);
                                    match(Comma);
                                }
                            }

                        }
                    }

                    setState(1553);
                    match(CloseSquareBracket);
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1554);
                    _la = _input.LA(1);
                    if (!(_la == Plus || _la == Minus)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(1555);
                    constantInitializer();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ConstantContext constant() throws RecognitionException {
        ConstantContext _localctx = new ConstantContext(_ctx, getState());
        enterRule(_localctx, 204, RULE_constant);
        try {
            setState(1563);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 193, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1558);
                    match(Null);
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1559);
                    literalConstant();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1560);
                    magicConstant();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1561);
                    classConstant();
                }
                break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                {
                    setState(1562);
                    qualifiedNamespaceName();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final LiteralConstantContext literalConstant() throws RecognitionException {
        LiteralConstantContext _localctx = new LiteralConstantContext(_ctx, getState());
        enterRule(_localctx, 206, RULE_literalConstant);
        try {
            setState(1569);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Real:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1565);
                    match(Real);
                }
                break;
                case BooleanConstant:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1566);
                    match(BooleanConstant);
                }
                break;
                case Octal:
                case Decimal:
                case Hex:
                case Binary:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1567);
                    numericConstant();
                }
                break;
                case Label:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1568);
                    stringConstant();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final NumericConstantContext numericConstant() throws RecognitionException {
        NumericConstantContext _localctx = new NumericConstantContext(_ctx, getState());
        enterRule(_localctx, 208, RULE_numericConstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1571);
                _la = _input.LA(1);
                if (!((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & 27L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ClassConstantContext classConstant() throws RecognitionException {
        ClassConstantContext _localctx = new ClassConstantContext(_ctx, getState());
        enterRule(_localctx, 210, RULE_classConstant);
        int _la;
        try {
            setState(1591);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 198, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1573);
                    _la = _input.LA(1);
                    if (!(_la == Class || _la == Parent_)) {
                        _errHandler.recoverInline(this);
                    } else {
                        if (_input.LA(1) == Token.EOF) matchedEOF = true;
                        _errHandler.reportMatch(this);
                        consume();
                    }
                    setState(1574);
                    match(DoubleColon);
                    setState(1579);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 195, _ctx)) {
                        case 1: {
                            setState(1575);
                            identifier();
                        }
                        break;
                        case 2: {
                            setState(1576);
                            match(Constructor);
                        }
                        break;
                        case 3: {
                            setState(1577);
                            match(Get);
                        }
                        break;
                        case 4: {
                            setState(1578);
                            match(Set);
                        }
                        break;
                    }
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1584);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case Abstract:
                        case Array:
                        case As:
                        case BinaryCast:
                        case BoolType:
                        case BooleanConstant:
                        case Break:
                        case Callable:
                        case Case:
                        case Catch:
                        case Class:
                        case Clone:
                        case Const:
                        case Continue:
                        case Declare:
                        case Default:
                        case Do:
                        case DoubleCast:
                        case DoubleType:
                        case Echo:
                        case Else:
                        case ElseIf:
                        case Empty:
                        case EndDeclare:
                        case EndFor:
                        case EndForeach:
                        case EndIf:
                        case EndSwitch:
                        case EndWhile:
                        case Eval:
                        case Exit:
                        case Extends:
                        case Final:
                        case Finally:
                        case FloatCast:
                        case For:
                        case Foreach:
                        case Function_:
                        case Global:
                        case Goto:
                        case If:
                        case Implements:
                        case Import:
                        case Include:
                        case IncludeOnce:
                        case InstanceOf:
                        case InsteadOf:
                        case Int8Cast:
                        case Int16Cast:
                        case Int64Type:
                        case IntType:
                        case Interface:
                        case IsSet:
                        case List:
                        case LogicalAnd:
                        case LogicalOr:
                        case LogicalXor:
                        case Namespace:
                        case New:
                        case Null:
                        case ObjectType:
                        case Parent_:
                        case Partial:
                        case Print:
                        case Private:
                        case Protected:
                        case Public:
                        case Require:
                        case RequireOnce:
                        case Resource:
                        case Return:
                        case Static:
                        case StringType:
                        case Switch:
                        case Throw:
                        case Trait:
                        case Try:
                        case Typeof:
                        case UintCast:
                        case UnicodeCast:
                        case Unset:
                        case Use:
                        case Var:
                        case While:
                        case Yield:
                        case From:
                        case Get:
                        case Set:
                        case Call:
                        case CallStatic:
                        case Constructor:
                        case Destruct:
                        case Wakeup:
                        case Sleep:
                        case Autoload:
                        case IsSet__:
                        case Unset__:
                        case ToString__:
                        case Invoke:
                        case SetState:
                        case Clone__:
                        case DebugInfo:
                        case Namespace__:
                        case Class__:
                        case Traic__:
                        case Function__:
                        case Method__:
                        case Line__:
                        case File__:
                        case Dir__:
                        case NamespaceSeparator:
                        case Label: {
                            setState(1581);
                            qualifiedStaticTypeRef();
                        }
                        break;
                        case Dollar:
                        case VarName: {
                            setState(1582);
                            keyedVariable();
                        }
                        break;
                        case SingleQuoteString:
                        case DoubleQuote:
                        case StartNowDoc:
                        case StartHereDoc: {
                            setState(1583);
                            string();
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                    setState(1586);
                    match(DoubleColon);
                    setState(1589);
                    _errHandler.sync(this);
                    switch (_input.LA(1)) {
                        case Abstract:
                        case Array:
                        case As:
                        case BinaryCast:
                        case BoolType:
                        case BooleanConstant:
                        case Break:
                        case Callable:
                        case Case:
                        case Catch:
                        case Class:
                        case Clone:
                        case Const:
                        case Continue:
                        case Declare:
                        case Default:
                        case Do:
                        case DoubleCast:
                        case DoubleType:
                        case Echo:
                        case Else:
                        case ElseIf:
                        case Empty:
                        case EndDeclare:
                        case EndFor:
                        case EndForeach:
                        case EndIf:
                        case EndSwitch:
                        case EndWhile:
                        case Eval:
                        case Exit:
                        case Extends:
                        case Final:
                        case Finally:
                        case FloatCast:
                        case For:
                        case Foreach:
                        case Function_:
                        case Global:
                        case Goto:
                        case If:
                        case Implements:
                        case Import:
                        case Include:
                        case IncludeOnce:
                        case InstanceOf:
                        case InsteadOf:
                        case Int8Cast:
                        case Int16Cast:
                        case Int64Type:
                        case IntType:
                        case Interface:
                        case IsSet:
                        case List:
                        case LogicalAnd:
                        case LogicalOr:
                        case LogicalXor:
                        case Namespace:
                        case New:
                        case Null:
                        case ObjectType:
                        case Parent_:
                        case Partial:
                        case Print:
                        case Private:
                        case Protected:
                        case Public:
                        case Require:
                        case RequireOnce:
                        case Resource:
                        case Return:
                        case Static:
                        case StringType:
                        case Switch:
                        case Throw:
                        case Trait:
                        case Try:
                        case Typeof:
                        case UintCast:
                        case UnicodeCast:
                        case Unset:
                        case Use:
                        case Var:
                        case While:
                        case Yield:
                        case From:
                        case Get:
                        case Set:
                        case Call:
                        case CallStatic:
                        case Constructor:
                        case Destruct:
                        case Wakeup:
                        case Sleep:
                        case Autoload:
                        case IsSet__:
                        case Unset__:
                        case ToString__:
                        case Invoke:
                        case SetState:
                        case Clone__:
                        case DebugInfo:
                        case Namespace__:
                        case Class__:
                        case Traic__:
                        case Function__:
                        case Method__:
                        case Line__:
                        case File__:
                        case Dir__:
                        case Label: {
                            setState(1587);
                            identifier();
                        }
                        break;
                        case Dollar:
                        case VarName: {
                            setState(1588);
                            keyedVariable();
                        }
                        break;
                        default:
                            throw new NoViableAltException(this);
                    }
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StringConstantContext stringConstant() throws RecognitionException {
        StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
        enterRule(_localctx, 212, RULE_stringConstant);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1593);
                match(Label);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 214, RULE_string);
        try {
            int _alt;
            setState(1616);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case StartHereDoc:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1595);
                    match(StartHereDoc);
                    setState(1597);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(1596);
                                    match(HereDocText);
                                }
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1599);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 199, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                }
                break;
                case StartNowDoc:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1601);
                    match(StartNowDoc);
                    setState(1603);
                    _errHandler.sync(this);
                    _alt = 1;
                    do {
                        switch (_alt) {
                            case 1: {
                                {
                                    setState(1602);
                                    match(HereDocText);
                                }
                            }
                            break;
                            default:
                                throw new NoViableAltException(this);
                        }
                        setState(1605);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 200, _ctx);
                    } while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER);
                }
                break;
                case SingleQuoteString:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1607);
                    match(SingleQuoteString);
                }
                break;
                case DoubleQuote:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1608);
                    match(DoubleQuote);
                    setState(1612);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 201, _ctx);
                    while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                        if (_alt == 1) {
                            {
                                {
                                    setState(1609);
                                    interpolatedStringPart();
                                }
                            }
                        }
                        setState(1614);
                        _errHandler.sync(this);
                        _alt = getInterpreter().adaptivePredict(_input, 201, _ctx);
                    }
                    setState(1615);
                    match(DoubleQuote);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final InterpolatedStringPartContext interpolatedStringPart() throws RecognitionException {
        InterpolatedStringPartContext _localctx = new InterpolatedStringPartContext(_ctx, getState());
        enterRule(_localctx, 216, RULE_interpolatedStringPart);
        try {
            setState(1621);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case StringPart:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1618);
                    match(StringPart);
                }
                break;
                case UnicodeEscape:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1619);
                    match(UnicodeEscape);
                }
                break;
                case Abstract:
                case Array:
                case As:
                case BinaryCast:
                case BoolType:
                case BooleanConstant:
                case Break:
                case Callable:
                case Case:
                case Catch:
                case Class:
                case Clone:
                case Const:
                case Continue:
                case Declare:
                case Default:
                case Do:
                case DoubleCast:
                case DoubleType:
                case Echo:
                case Else:
                case ElseIf:
                case Empty:
                case EndDeclare:
                case EndFor:
                case EndForeach:
                case EndIf:
                case EndSwitch:
                case EndWhile:
                case Eval:
                case Exit:
                case Extends:
                case Final:
                case Finally:
                case FloatCast:
                case For:
                case Foreach:
                case Function_:
                case Global:
                case Goto:
                case If:
                case Implements:
                case Import:
                case Include:
                case IncludeOnce:
                case InstanceOf:
                case InsteadOf:
                case Int8Cast:
                case Int16Cast:
                case Int64Type:
                case IntType:
                case Interface:
                case IsSet:
                case List:
                case LogicalAnd:
                case LogicalOr:
                case LogicalXor:
                case Namespace:
                case New:
                case Null:
                case ObjectType:
                case Parent_:
                case Partial:
                case Print:
                case Private:
                case Protected:
                case Public:
                case Require:
                case RequireOnce:
                case Resource:
                case Return:
                case Static:
                case StringType:
                case Switch:
                case Throw:
                case Trait:
                case Try:
                case Typeof:
                case UintCast:
                case UnicodeCast:
                case Unset:
                case Use:
                case Var:
                case While:
                case Yield:
                case From:
                case Get:
                case Set:
                case Call:
                case CallStatic:
                case Constructor:
                case Destruct:
                case Wakeup:
                case Sleep:
                case Autoload:
                case IsSet__:
                case Unset__:
                case ToString__:
                case Invoke:
                case SetState:
                case Clone__:
                case DebugInfo:
                case Namespace__:
                case Class__:
                case Traic__:
                case Function__:
                case Method__:
                case Line__:
                case File__:
                case Dir__:
                case NamespaceSeparator:
                case Dollar:
                case OpenRoundBracket:
                case VarName:
                case Label:
                case SingleQuoteString:
                case DoubleQuote:
                case StartNowDoc:
                case StartHereDoc:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1620);
                    chain();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ChainListContext chainList() throws RecognitionException {
        ChainListContext _localctx = new ChainListContext(_ctx, getState());
        enterRule(_localctx, 218, RULE_chainList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1623);
                chain();
                setState(1628);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(1624);
                            match(Comma);
                            setState(1625);
                            chain();
                        }
                    }
                    setState(1630);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ChainContext chain() throws RecognitionException {
        ChainContext _localctx = new ChainContext(_ctx, getState());
        enterRule(_localctx, 220, RULE_chain);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1631);
                chainOrigin();
                setState(1635);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 205, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1632);
                                memberAccess();
                            }
                        }
                    }
                    setState(1637);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 205, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ChainOriginContext chainOrigin() throws RecognitionException {
        ChainOriginContext _localctx = new ChainOriginContext(_ctx, getState());
        enterRule(_localctx, 222, RULE_chainOrigin);
        try {
            setState(1644);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 206, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1638);
                    chainBase();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1639);
                    functionCall();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1640);
                    match(OpenRoundBracket);
                    setState(1641);
                    newExpr();
                    setState(1642);
                    match(CloseRoundBracket);
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MemberAccessContext memberAccess() throws RecognitionException {
        MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
        enterRule(_localctx, 224, RULE_memberAccess);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1646);
                match(ObjectOperator);
                setState(1647);
                keyedFieldName();
                setState(1649);
                _errHandler.sync(this);
                switch (getInterpreter().adaptivePredict(_input, 207, _ctx)) {
                    case 1: {
                        setState(1648);
                        actualArguments();
                    }
                    break;
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionCallContext functionCall() throws RecognitionException {
        FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
        enterRule(_localctx, 226, RULE_functionCall);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1651);
                functionCallName();
                setState(1652);
                actualArguments();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final FunctionCallNameContext functionCallName() throws RecognitionException {
        FunctionCallNameContext _localctx = new FunctionCallNameContext(_ctx, getState());
        enterRule(_localctx, 228, RULE_functionCallName);
        try {
            setState(1658);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 208, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1654);
                    qualifiedNamespaceName();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1655);
                    classConstant();
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1656);
                    chainBase();
                }
                break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                {
                    setState(1657);
                    parentheses();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ActualArgumentsContext actualArguments() throws RecognitionException {
        ActualArgumentsContext _localctx = new ActualArgumentsContext(_ctx, getState());
        enterRule(_localctx, 230, RULE_actualArguments);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1661);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == Lgeneric) {
                    {
                        setState(1660);
                        genericDynamicArgs();
                    }
                }

                setState(1663);
                arguments();
                setState(1667);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 210, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1664);
                                squareCurlyExpression();
                            }
                        }
                    }
                    setState(1669);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 210, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ChainBaseContext chainBase() throws RecognitionException {
        ChainBaseContext _localctx = new ChainBaseContext(_ctx, getState());
        enterRule(_localctx, 232, RULE_chainBase);
        try {
            setState(1679);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Dollar:
                case VarName:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1670);
                    keyedVariable();
                    setState(1673);
                    _errHandler.sync(this);
                    switch (getInterpreter().adaptivePredict(_input, 211, _ctx)) {
                        case 1: {
                            setState(1671);
                            match(DoubleColon);
                            setState(1672);
                            keyedVariable();
                        }
                        break;
                    }
                }
                break;
                case Abstract:
                case Array:
                case As:
                case BinaryCast:
                case BoolType:
                case BooleanConstant:
                case Break:
                case Callable:
                case Case:
                case Catch:
                case Class:
                case Clone:
                case Const:
                case Continue:
                case Declare:
                case Default:
                case Do:
                case DoubleCast:
                case DoubleType:
                case Echo:
                case Else:
                case ElseIf:
                case Empty:
                case EndDeclare:
                case EndFor:
                case EndForeach:
                case EndIf:
                case EndSwitch:
                case EndWhile:
                case Eval:
                case Exit:
                case Extends:
                case Final:
                case Finally:
                case FloatCast:
                case For:
                case Foreach:
                case Function_:
                case Global:
                case Goto:
                case If:
                case Implements:
                case Import:
                case Include:
                case IncludeOnce:
                case InstanceOf:
                case InsteadOf:
                case Int8Cast:
                case Int16Cast:
                case Int64Type:
                case IntType:
                case Interface:
                case IsSet:
                case List:
                case LogicalAnd:
                case LogicalOr:
                case LogicalXor:
                case Namespace:
                case New:
                case Null:
                case ObjectType:
                case Parent_:
                case Partial:
                case Print:
                case Private:
                case Protected:
                case Public:
                case Require:
                case RequireOnce:
                case Resource:
                case Return:
                case Static:
                case StringType:
                case Switch:
                case Throw:
                case Trait:
                case Try:
                case Typeof:
                case UintCast:
                case UnicodeCast:
                case Unset:
                case Use:
                case Var:
                case While:
                case Yield:
                case From:
                case Get:
                case Set:
                case Call:
                case CallStatic:
                case Constructor:
                case Destruct:
                case Wakeup:
                case Sleep:
                case Autoload:
                case IsSet__:
                case Unset__:
                case ToString__:
                case Invoke:
                case SetState:
                case Clone__:
                case DebugInfo:
                case Namespace__:
                case Class__:
                case Traic__:
                case Function__:
                case Method__:
                case Line__:
                case File__:
                case Dir__:
                case NamespaceSeparator:
                case Label:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1675);
                    qualifiedStaticTypeRef();
                    setState(1676);
                    match(DoubleColon);
                    setState(1677);
                    keyedVariable();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final KeyedFieldNameContext keyedFieldName() throws RecognitionException {
        KeyedFieldNameContext _localctx = new KeyedFieldNameContext(_ctx, getState());
        enterRule(_localctx, 234, RULE_keyedFieldName);
        try {
            setState(1683);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case Abstract:
                case Array:
                case As:
                case BinaryCast:
                case BoolType:
                case BooleanConstant:
                case Break:
                case Callable:
                case Case:
                case Catch:
                case Class:
                case Clone:
                case Const:
                case Continue:
                case Declare:
                case Default:
                case Do:
                case DoubleCast:
                case DoubleType:
                case Echo:
                case Else:
                case ElseIf:
                case Empty:
                case EndDeclare:
                case EndFor:
                case EndForeach:
                case EndIf:
                case EndSwitch:
                case EndWhile:
                case Eval:
                case Exit:
                case Extends:
                case Final:
                case Finally:
                case FloatCast:
                case For:
                case Foreach:
                case Function_:
                case Global:
                case Goto:
                case If:
                case Implements:
                case Import:
                case Include:
                case IncludeOnce:
                case InstanceOf:
                case InsteadOf:
                case Int8Cast:
                case Int16Cast:
                case Int64Type:
                case IntType:
                case Interface:
                case IsSet:
                case List:
                case LogicalAnd:
                case LogicalOr:
                case LogicalXor:
                case Namespace:
                case New:
                case Null:
                case ObjectType:
                case Parent_:
                case Partial:
                case Print:
                case Private:
                case Protected:
                case Public:
                case Require:
                case RequireOnce:
                case Resource:
                case Return:
                case Static:
                case StringType:
                case Switch:
                case Throw:
                case Trait:
                case Try:
                case Typeof:
                case UintCast:
                case UnicodeCast:
                case Unset:
                case Use:
                case Var:
                case While:
                case Yield:
                case From:
                case Get:
                case Set:
                case Call:
                case CallStatic:
                case Constructor:
                case Destruct:
                case Wakeup:
                case Sleep:
                case Autoload:
                case IsSet__:
                case Unset__:
                case ToString__:
                case Invoke:
                case SetState:
                case Clone__:
                case DebugInfo:
                case Namespace__:
                case Class__:
                case Traic__:
                case Function__:
                case Method__:
                case Line__:
                case File__:
                case Dir__:
                case OpenCurlyBracket:
                case Label:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1681);
                    keyedSimpleFieldName();
                }
                break;
                case Dollar:
                case VarName:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1682);
                    keyedVariable();
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final KeyedSimpleFieldNameContext keyedSimpleFieldName() throws RecognitionException {
        KeyedSimpleFieldNameContext _localctx = new KeyedSimpleFieldNameContext(_ctx, getState());
        enterRule(_localctx, 236, RULE_keyedSimpleFieldName);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1690);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case Abstract:
                    case Array:
                    case As:
                    case BinaryCast:
                    case BoolType:
                    case BooleanConstant:
                    case Break:
                    case Callable:
                    case Case:
                    case Catch:
                    case Class:
                    case Clone:
                    case Const:
                    case Continue:
                    case Declare:
                    case Default:
                    case Do:
                    case DoubleCast:
                    case DoubleType:
                    case Echo:
                    case Else:
                    case ElseIf:
                    case Empty:
                    case EndDeclare:
                    case EndFor:
                    case EndForeach:
                    case EndIf:
                    case EndSwitch:
                    case EndWhile:
                    case Eval:
                    case Exit:
                    case Extends:
                    case Final:
                    case Finally:
                    case FloatCast:
                    case For:
                    case Foreach:
                    case Function_:
                    case Global:
                    case Goto:
                    case If:
                    case Implements:
                    case Import:
                    case Include:
                    case IncludeOnce:
                    case InstanceOf:
                    case InsteadOf:
                    case Int8Cast:
                    case Int16Cast:
                    case Int64Type:
                    case IntType:
                    case Interface:
                    case IsSet:
                    case List:
                    case LogicalAnd:
                    case LogicalOr:
                    case LogicalXor:
                    case Namespace:
                    case New:
                    case Null:
                    case ObjectType:
                    case Parent_:
                    case Partial:
                    case Print:
                    case Private:
                    case Protected:
                    case Public:
                    case Require:
                    case RequireOnce:
                    case Resource:
                    case Return:
                    case Static:
                    case StringType:
                    case Switch:
                    case Throw:
                    case Trait:
                    case Try:
                    case Typeof:
                    case UintCast:
                    case UnicodeCast:
                    case Unset:
                    case Use:
                    case Var:
                    case While:
                    case Yield:
                    case From:
                    case Get:
                    case Set:
                    case Call:
                    case CallStatic:
                    case Constructor:
                    case Destruct:
                    case Wakeup:
                    case Sleep:
                    case Autoload:
                    case IsSet__:
                    case Unset__:
                    case ToString__:
                    case Invoke:
                    case SetState:
                    case Clone__:
                    case DebugInfo:
                    case Namespace__:
                    case Class__:
                    case Traic__:
                    case Function__:
                    case Method__:
                    case Line__:
                    case File__:
                    case Dir__:
                    case Label: {
                        setState(1685);
                        identifier();
                    }
                    break;
                    case OpenCurlyBracket: {
                        setState(1686);
                        match(OpenCurlyBracket);
                        setState(1687);
                        expression(0);
                        setState(1688);
                        match(CloseCurlyBracket);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1695);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 215, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1692);
                                squareCurlyExpression();
                            }
                        }
                    }
                    setState(1697);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 215, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final KeyedVariableContext keyedVariable() throws RecognitionException {
        KeyedVariableContext _localctx = new KeyedVariableContext(_ctx, getState());
        enterRule(_localctx, 238, RULE_keyedVariable);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(1701);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 216, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1698);
                                match(Dollar);
                            }
                        }
                    }
                    setState(1703);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 216, _ctx);
                }
                setState(1710);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case VarName: {
                        setState(1704);
                        match(VarName);
                    }
                    break;
                    case Dollar: {
                        setState(1705);
                        match(Dollar);
                        setState(1706);
                        match(OpenCurlyBracket);
                        setState(1707);
                        expression(0);
                        setState(1708);
                        match(CloseCurlyBracket);
                    }
                    break;
                    default:
                        throw new NoViableAltException(this);
                }
                setState(1715);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 218, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(1712);
                                squareCurlyExpression();
                            }
                        }
                    }
                    setState(1717);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 218, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final SquareCurlyExpressionContext squareCurlyExpression() throws RecognitionException {
        SquareCurlyExpressionContext _localctx = new SquareCurlyExpressionContext(_ctx, getState());
        enterRule(_localctx, 240, RULE_squareCurlyExpression);
        int _la;
        try {
            setState(1727);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case OpenSquareBracket:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1718);
                    match(OpenSquareBracket);
                    setState(1720);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                    if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138177L) != 0) {
                        {
                            setState(1719);
                            expression(0);
                        }
                    }

                    setState(1722);
                    match(CloseSquareBracket);
                }
                break;
                case OpenCurlyBracket:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1723);
                    match(OpenCurlyBracket);
                    setState(1724);
                    expression(0);
                    setState(1725);
                    match(CloseCurlyBracket);
                }
                break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AssignmentListContext assignmentList() throws RecognitionException {
        AssignmentListContext _localctx = new AssignmentListContext(_ctx, getState());
        enterRule(_localctx, 242, RULE_assignmentList);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1730);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138193L) != 0) {
                    {
                        setState(1729);
                        assignmentListElement();
                    }
                }

                setState(1738);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == Comma) {
                    {
                        {
                            setState(1732);
                            match(Comma);
                            setState(1734);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if ((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -1L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 13792273858822143L) != 0 || (((_la - 186)) & ~0x3f) == 0 && ((1L << (_la - 186)) & 4396974138193L) != 0) {
                                {
                                    setState(1733);
                                    assignmentListElement();
                                }
                            }

                        }
                    }
                    setState(1740);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final AssignmentListElementContext assignmentListElement() throws RecognitionException {
        AssignmentListElementContext _localctx = new AssignmentListElementContext(_ctx, getState());
        enterRule(_localctx, 244, RULE_assignmentListElement);
        try {
            setState(1748);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 224, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                {
                    setState(1741);
                    chain();
                }
                break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                {
                    setState(1742);
                    match(List);
                    setState(1743);
                    match(OpenRoundBracket);
                    setState(1744);
                    assignmentList();
                    setState(1745);
                    match(CloseRoundBracket);
                }
                break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                {
                    setState(1747);
                    arrayItem();
                }
                break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final ModifierContext modifier() throws RecognitionException {
        ModifierContext _localctx = new ModifierContext(_ctx, getState());
        enterRule(_localctx, 246, RULE_modifier);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1750);
                _la = _input.LA(1);
                if (!(_la == Abstract || _la == Final)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final IdentifierContext identifier() throws RecognitionException {
        IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
        enterRule(_localctx, 248, RULE_identifier);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1752);
                _la = _input.LA(1);
                if (!((((_la - 41)) & ~0x3f) == 0 && ((1L << (_la - 41)) & -144115188075855873L) != 0 || (((_la - 105)) & ~0x3f) == 0 && ((1L << (_la - 105)) & 281474968322047L) != 0 || _la == Label)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MemberModifierContext memberModifier() throws RecognitionException {
        MemberModifierContext _localctx = new MemberModifierContext(_ctx, getState());
        enterRule(_localctx, 250, RULE_memberModifier);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1754);
                _la = _input.LA(1);
                if (!(_la == Abstract || (((_la - 73)) & ~0x3f) == 0 && ((1L << (_la - 73)) & 1159641169921L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MagicConstantContext magicConstant() throws RecognitionException {
        MagicConstantContext _localctx = new MagicConstantContext(_ctx, getState());
        enterRule(_localctx, 252, RULE_magicConstant);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1756);
                _la = _input.LA(1);
                if (!((((_la - 145)) & ~0x3f) == 0 && ((1L << (_la - 145)) & 255L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final MagicMethodContext magicMethod() throws RecognitionException {
        MagicMethodContext _localctx = new MagicMethodContext(_ctx, getState());
        enterRule(_localctx, 254, RULE_magicMethod);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1758);
                _la = _input.LA(1);
                if (!((((_la - 129)) & ~0x3f) == 0 && ((1L << (_la - 129)) & 65535L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final PrimitiveTypeContext primitiveType() throws RecognitionException {
        PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
        enterRule(_localctx, 256, RULE_primitiveType);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1760);
                _la = _input.LA(1);
                if (!(((_la) & ~0x3f) == 0 && ((1L << _la) & 576500334722023424L) != 0 || (((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 18878467L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public final CastOperationContext castOperation() throws RecognitionException {
        CastOperationContext _localctx = new CastOperationContext(_ctx, getState());
        enterRule(_localctx, 258, RULE_castOperation);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(1762);
                _la = _input.LA(1);
                if (!(((_la) & ~0x3f) == 0 && ((1L << _la) & 864748303059779584L) != 0 || (((_la - 75)) & ~0x3f) == 0 && ((1L << (_la - 75)) & 246909214253057L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 57:
                return typeHint_sempred((TypeHintContext) _localctx, predIndex);
            case 77:
                return expression_sempred((ExpressionContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean typeHint_sempred(TypeHintContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 1);
        }
        return true;
    }

    private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
        switch (predIndex) {
            case 1:
                return precpred(_ctx, 21);
            case 2:
                return precpred(_ctx, 19);
            case 3:
                return precpred(_ctx, 18);
            case 4:
                return precpred(_ctx, 17);
            case 5:
                return precpred(_ctx, 16);
            case 6:
                return precpred(_ctx, 15);
            case 7:
                return precpred(_ctx, 14);
            case 8:
                return precpred(_ctx, 13);
            case 9:
                return precpred(_ctx, 12);
            case 10:
                return precpred(_ctx, 11);
            case 11:
                return precpred(_ctx, 10);
            case 12:
                return precpred(_ctx, 9);
            case 13:
                return precpred(_ctx, 8);
            case 14:
                return precpred(_ctx, 7);
            case 15:
                return precpred(_ctx, 3);
            case 16:
                return precpred(_ctx, 2);
            case 17:
                return precpred(_ctx, 1);
            case 18:
                return precpred(_ctx, 20);
        }
        return true;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class HtmlDocumentContext extends ParserRuleContext {
        public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode EOF() {
            return getToken(PhpParser.EOF, 0);
        }

        public TerminalNode Shebang() {
            return getToken(PhpParser.Shebang, 0);
        }

        public List<InlineHtmlContext> inlineHtml() {
            return getRuleContexts(InlineHtmlContext.class);
        }

        public InlineHtmlContext inlineHtml(int i) {
            return getRuleContext(InlineHtmlContext.class, i);
        }

        public List<PhpBlockContext> phpBlock() {
            return getRuleContexts(PhpBlockContext.class);
        }

        public PhpBlockContext phpBlock(int i) {
            return getRuleContext(PhpBlockContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_htmlDocument;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterHtmlDocument(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitHtmlDocument(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitHtmlDocument(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InlineHtmlContext extends ParserRuleContext {
        public InlineHtmlContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<HtmlElementContext> htmlElement() {
            return getRuleContexts(HtmlElementContext.class);
        }

        public HtmlElementContext htmlElement(int i) {
            return getRuleContext(HtmlElementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inlineHtml;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterInlineHtml(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitInlineHtml(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitInlineHtml(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class HtmlElementContext extends ParserRuleContext {
        public HtmlElementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode HtmlDtd() {
            return getToken(PhpParser.HtmlDtd, 0);
        }

        public TerminalNode HtmlClose() {
            return getToken(PhpParser.HtmlClose, 0);
        }

        public TerminalNode HtmlOpen() {
            return getToken(PhpParser.HtmlOpen, 0);
        }

        public TerminalNode HtmlName() {
            return getToken(PhpParser.HtmlName, 0);
        }

        public TerminalNode HtmlSlashClose() {
            return getToken(PhpParser.HtmlSlashClose, 0);
        }

        public TerminalNode HtmlSlash() {
            return getToken(PhpParser.HtmlSlash, 0);
        }

        public TerminalNode HtmlText() {
            return getToken(PhpParser.HtmlText, 0);
        }

        public TerminalNode HtmlEquals() {
            return getToken(PhpParser.HtmlEquals, 0);
        }

        public TerminalNode HtmlStartQuoteString() {
            return getToken(PhpParser.HtmlStartQuoteString, 0);
        }

        public TerminalNode HtmlEndQuoteString() {
            return getToken(PhpParser.HtmlEndQuoteString, 0);
        }

        public TerminalNode HtmlStartDoubleQuoteString() {
            return getToken(PhpParser.HtmlStartDoubleQuoteString, 0);
        }

        public TerminalNode HtmlEndDoubleQuoteString() {
            return getToken(PhpParser.HtmlEndDoubleQuoteString, 0);
        }

        public TerminalNode HtmlHex() {
            return getToken(PhpParser.HtmlHex, 0);
        }

        public TerminalNode HtmlDecimal() {
            return getToken(PhpParser.HtmlDecimal, 0);
        }

        public TerminalNode HtmlQuoteString() {
            return getToken(PhpParser.HtmlQuoteString, 0);
        }

        public TerminalNode HtmlDoubleQuoteString() {
            return getToken(PhpParser.HtmlDoubleQuoteString, 0);
        }

        public TerminalNode XmlStart() {
            return getToken(PhpParser.XmlStart, 0);
        }

        public TerminalNode XmlClose() {
            return getToken(PhpParser.XmlClose, 0);
        }

        public List<TerminalNode> XmlText() {
            return getTokens(PhpParser.XmlText);
        }

        public TerminalNode XmlText(int i) {
            return getToken(PhpParser.XmlText, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_htmlElement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterHtmlElement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitHtmlElement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitHtmlElement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PhpBlockContext extends ParserRuleContext {
        public PhpBlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ImportStatementContext> importStatement() {
            return getRuleContexts(ImportStatementContext.class);
        }

        public ImportStatementContext importStatement(int i) {
            return getRuleContext(ImportStatementContext.class, i);
        }

        public List<TopStatementContext> topStatement() {
            return getRuleContexts(TopStatementContext.class);
        }

        public TopStatementContext topStatement(int i) {
            return getRuleContext(TopStatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_phpBlock;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterPhpBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitPhpBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitPhpBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ImportStatementContext extends ParserRuleContext {
        public ImportStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Import() {
            return getToken(PhpParser.Import, 0);
        }

        public TerminalNode Namespace() {
            return getToken(PhpParser.Namespace, 0);
        }

        public NamespaceNameListContext namespaceNameList() {
            return getRuleContext(NamespaceNameListContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_importStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterImportStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitImportStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitImportStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TopStatementContext extends ParserRuleContext {
        public TopStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public UseDeclarationContext useDeclaration() {
            return getRuleContext(UseDeclarationContext.class, 0);
        }

        public NamespaceDeclarationContext namespaceDeclaration() {
            return getRuleContext(NamespaceDeclarationContext.class, 0);
        }

        public FunctionDeclarationContext functionDeclaration() {
            return getRuleContext(FunctionDeclarationContext.class, 0);
        }

        public ClassDeclarationContext classDeclaration() {
            return getRuleContext(ClassDeclarationContext.class, 0);
        }

        public GlobalConstantDeclarationContext globalConstantDeclaration() {
            return getRuleContext(GlobalConstantDeclarationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_topStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTopStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTopStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTopStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class UseDeclarationContext extends ParserRuleContext {
        public UseDeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Use() {
            return getToken(PhpParser.Use, 0);
        }

        public UseDeclarationContentListContext useDeclarationContentList() {
            return getRuleContext(UseDeclarationContentListContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public TerminalNode Function_() {
            return getToken(PhpParser.Function_, 0);
        }

        public TerminalNode Const() {
            return getToken(PhpParser.Const, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_useDeclaration;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterUseDeclaration(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitUseDeclaration(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitUseDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class UseDeclarationContentListContext extends ParserRuleContext {
        public UseDeclarationContentListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<UseDeclarationContentContext> useDeclarationContent() {
            return getRuleContexts(UseDeclarationContentContext.class);
        }

        public UseDeclarationContentContext useDeclarationContent(int i) {
            return getRuleContext(UseDeclarationContentContext.class, i);
        }

        public List<TerminalNode> NamespaceSeparator() {
            return getTokens(PhpParser.NamespaceSeparator);
        }

        public TerminalNode NamespaceSeparator(int i) {
            return getToken(PhpParser.NamespaceSeparator, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_useDeclarationContentList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterUseDeclarationContentList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitUseDeclarationContentList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitUseDeclarationContentList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class UseDeclarationContentContext extends ParserRuleContext {
        public UseDeclarationContentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public NamespaceNameListContext namespaceNameList() {
            return getRuleContext(NamespaceNameListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_useDeclarationContent;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterUseDeclarationContent(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitUseDeclarationContent(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitUseDeclarationContent(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NamespaceDeclarationContext extends ParserRuleContext {
        public NamespaceDeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Namespace() {
            return getToken(PhpParser.Namespace, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public NamespaceNameListContext namespaceNameList() {
            return getRuleContext(NamespaceNameListContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public List<NamespaceStatementContext> namespaceStatement() {
            return getRuleContexts(NamespaceStatementContext.class);
        }

        public NamespaceStatementContext namespaceStatement(int i) {
            return getRuleContext(NamespaceStatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namespaceDeclaration;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNamespaceDeclaration(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNamespaceDeclaration(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNamespaceDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NamespaceStatementContext extends ParserRuleContext {
        public NamespaceStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public UseDeclarationContext useDeclaration() {
            return getRuleContext(UseDeclarationContext.class, 0);
        }

        public FunctionDeclarationContext functionDeclaration() {
            return getRuleContext(FunctionDeclarationContext.class, 0);
        }

        public ClassDeclarationContext classDeclaration() {
            return getRuleContext(ClassDeclarationContext.class, 0);
        }

        public GlobalConstantDeclarationContext globalConstantDeclaration() {
            return getRuleContext(GlobalConstantDeclarationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namespaceStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNamespaceStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNamespaceStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNamespaceStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionDeclarationContext extends ParserRuleContext {
        public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Function_() {
            return getToken(PhpParser.Function_, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public FormalParameterListContext formalParameterList() {
            return getRuleContext(FormalParameterListContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public BlockStatementContext blockStatement() {
            return getRuleContext(BlockStatementContext.class, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public TypeParameterListInBracketsContext typeParameterListInBrackets() {
            return getRuleContext(TypeParameterListInBracketsContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public TypeHintContext typeHint() {
            return getRuleContext(TypeHintContext.class, 0);
        }

        public TerminalNode QuestionMark() {
            return getToken(PhpParser.QuestionMark, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionDeclaration;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterFunctionDeclaration(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitFunctionDeclaration(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitFunctionDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ClassDeclarationContext extends ParserRuleContext {
        public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public ClassEntryTypeContext classEntryType() {
            return getRuleContext(ClassEntryTypeContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode Interface() {
            return getToken(PhpParser.Interface, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        public TerminalNode Private() {
            return getToken(PhpParser.Private, 0);
        }

        public ModifierContext modifier() {
            return getRuleContext(ModifierContext.class, 0);
        }

        public TerminalNode Partial() {
            return getToken(PhpParser.Partial, 0);
        }

        public List<ClassStatementContext> classStatement() {
            return getRuleContexts(ClassStatementContext.class);
        }

        public ClassStatementContext classStatement(int i) {
            return getRuleContext(ClassStatementContext.class, i);
        }

        public TypeParameterListInBracketsContext typeParameterListInBrackets() {
            return getRuleContext(TypeParameterListInBracketsContext.class, 0);
        }

        public TerminalNode Extends() {
            return getToken(PhpParser.Extends, 0);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
            return getRuleContext(QualifiedStaticTypeRefContext.class, 0);
        }

        public TerminalNode Implements() {
            return getToken(PhpParser.Implements, 0);
        }

        public InterfaceListContext interfaceList() {
            return getRuleContext(InterfaceListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classDeclaration;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterClassDeclaration(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitClassDeclaration(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitClassDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ClassEntryTypeContext extends ParserRuleContext {
        public ClassEntryTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Class() {
            return getToken(PhpParser.Class, 0);
        }

        public TerminalNode Trait() {
            return getToken(PhpParser.Trait, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classEntryType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterClassEntryType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitClassEntryType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitClassEntryType(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InterfaceListContext extends ParserRuleContext {
        public InterfaceListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<QualifiedStaticTypeRefContext> qualifiedStaticTypeRef() {
            return getRuleContexts(QualifiedStaticTypeRefContext.class);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef(int i) {
            return getRuleContext(QualifiedStaticTypeRefContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_interfaceList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterInterfaceList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitInterfaceList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitInterfaceList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TypeParameterListInBracketsContext extends ParserRuleContext {
        public TypeParameterListInBracketsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Lgeneric() {
            return getToken(PhpParser.Lgeneric, 0);
        }

        public TypeParameterListContext typeParameterList() {
            return getRuleContext(TypeParameterListContext.class, 0);
        }

        public TerminalNode Rgeneric() {
            return getToken(PhpParser.Rgeneric, 0);
        }

        public TypeParameterWithDefaultsListContext typeParameterWithDefaultsList() {
            return getRuleContext(TypeParameterWithDefaultsListContext.class, 0);
        }

        public TerminalNode Comma() {
            return getToken(PhpParser.Comma, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeParameterListInBrackets;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTypeParameterListInBrackets(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTypeParameterListInBrackets(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTypeParameterListInBrackets(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TypeParameterListContext extends ParserRuleContext {
        public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TypeParameterDeclContext> typeParameterDecl() {
            return getRuleContexts(TypeParameterDeclContext.class);
        }

        public TypeParameterDeclContext typeParameterDecl(int i) {
            return getRuleContext(TypeParameterDeclContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeParameterList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTypeParameterList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTypeParameterList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTypeParameterList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TypeParameterWithDefaultsListContext extends ParserRuleContext {
        public TypeParameterWithDefaultsListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<TypeParameterWithDefaultDeclContext> typeParameterWithDefaultDecl() {
            return getRuleContexts(TypeParameterWithDefaultDeclContext.class);
        }

        public TypeParameterWithDefaultDeclContext typeParameterWithDefaultDecl(int i) {
            return getRuleContext(TypeParameterWithDefaultDeclContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeParameterWithDefaultsList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTypeParameterWithDefaultsList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTypeParameterWithDefaultsList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTypeParameterWithDefaultsList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TypeParameterDeclContext extends ParserRuleContext {
        public TypeParameterDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeParameterDecl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTypeParameterDecl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTypeParameterDecl(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTypeParameterDecl(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TypeParameterWithDefaultDeclContext extends ParserRuleContext {
        public TypeParameterWithDefaultDeclContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode Eq() {
            return getToken(PhpParser.Eq, 0);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
            return getRuleContext(QualifiedStaticTypeRefContext.class, 0);
        }

        public PrimitiveTypeContext primitiveType() {
            return getRuleContext(PrimitiveTypeContext.class, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeParameterWithDefaultDecl;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTypeParameterWithDefaultDecl(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTypeParameterWithDefaultDecl(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTypeParameterWithDefaultDecl(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GenericDynamicArgsContext extends ParserRuleContext {
        public GenericDynamicArgsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Lgeneric() {
            return getToken(PhpParser.Lgeneric, 0);
        }

        public List<TypeRefContext> typeRef() {
            return getRuleContexts(TypeRefContext.class);
        }

        public TypeRefContext typeRef(int i) {
            return getRuleContext(TypeRefContext.class, i);
        }

        public TerminalNode Rgeneric() {
            return getToken(PhpParser.Rgeneric, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_genericDynamicArgs;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterGenericDynamicArgs(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitGenericDynamicArgs(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitGenericDynamicArgs(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AttributesContext extends ParserRuleContext {
        public AttributesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<AttributeGroupContext> attributeGroup() {
            return getRuleContexts(AttributeGroupContext.class);
        }

        public AttributeGroupContext attributeGroup(int i) {
            return getRuleContext(AttributeGroupContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attributes;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAttributes(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAttributes(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAttributes(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AttributeGroupContext extends ParserRuleContext {
        public AttributeGroupContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode AttributeStart() {
            return getToken(PhpParser.AttributeStart, 0);
        }

        public List<AttributeContext> attribute() {
            return getRuleContexts(AttributeContext.class);
        }

        public AttributeContext attribute(int i) {
            return getRuleContext(AttributeContext.class, i);
        }

        public TerminalNode CloseSquareBracket() {
            return getToken(PhpParser.CloseSquareBracket, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attributeGroup;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAttributeGroup(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAttributeGroup(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAttributeGroup(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AttributeContext extends ParserRuleContext {
        public AttributeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName() {
            return getRuleContext(QualifiedNamespaceNameContext.class, 0);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_attribute;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAttribute(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAttribute(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAttribute(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InnerStatementListContext extends ParserRuleContext {
        public InnerStatementListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<InnerStatementContext> innerStatement() {
            return getRuleContexts(InnerStatementContext.class);
        }

        public InnerStatementContext innerStatement(int i) {
            return getRuleContext(InnerStatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_innerStatementList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterInnerStatementList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitInnerStatementList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitInnerStatementList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InnerStatementContext extends ParserRuleContext {
        public InnerStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public FunctionDeclarationContext functionDeclaration() {
            return getRuleContext(FunctionDeclarationContext.class, 0);
        }

        public ClassDeclarationContext classDeclaration() {
            return getRuleContext(ClassDeclarationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_innerStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterInnerStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitInnerStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitInnerStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StatementContext extends ParserRuleContext {
        public StatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public BlockStatementContext blockStatement() {
            return getRuleContext(BlockStatementContext.class, 0);
        }

        public IfStatementContext ifStatement() {
            return getRuleContext(IfStatementContext.class, 0);
        }

        public WhileStatementContext whileStatement() {
            return getRuleContext(WhileStatementContext.class, 0);
        }

        public DoWhileStatementContext doWhileStatement() {
            return getRuleContext(DoWhileStatementContext.class, 0);
        }

        public ForStatementContext forStatement() {
            return getRuleContext(ForStatementContext.class, 0);
        }

        public SwitchStatementContext switchStatement() {
            return getRuleContext(SwitchStatementContext.class, 0);
        }

        public BreakStatementContext breakStatement() {
            return getRuleContext(BreakStatementContext.class, 0);
        }

        public ContinueStatementContext continueStatement() {
            return getRuleContext(ContinueStatementContext.class, 0);
        }

        public ReturnStatementContext returnStatement() {
            return getRuleContext(ReturnStatementContext.class, 0);
        }

        public YieldExpressionContext yieldExpression() {
            return getRuleContext(YieldExpressionContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public GlobalStatementContext globalStatement() {
            return getRuleContext(GlobalStatementContext.class, 0);
        }

        public StaticVariableStatementContext staticVariableStatement() {
            return getRuleContext(StaticVariableStatementContext.class, 0);
        }

        public EchoStatementContext echoStatement() {
            return getRuleContext(EchoStatementContext.class, 0);
        }

        public ExpressionStatementContext expressionStatement() {
            return getRuleContext(ExpressionStatementContext.class, 0);
        }

        public UnsetStatementContext unsetStatement() {
            return getRuleContext(UnsetStatementContext.class, 0);
        }

        public ForeachStatementContext foreachStatement() {
            return getRuleContext(ForeachStatementContext.class, 0);
        }

        public TryCatchFinallyContext tryCatchFinally() {
            return getRuleContext(TryCatchFinallyContext.class, 0);
        }

        public ThrowStatementContext throwStatement() {
            return getRuleContext(ThrowStatementContext.class, 0);
        }

        public GotoStatementContext gotoStatement() {
            return getRuleContext(GotoStatementContext.class, 0);
        }

        public DeclareStatementContext declareStatement() {
            return getRuleContext(DeclareStatementContext.class, 0);
        }

        public EmptyStatement_Context emptyStatement_() {
            return getRuleContext(EmptyStatement_Context.class, 0);
        }

        public InlineHtmlStatementContext inlineHtmlStatement() {
            return getRuleContext(InlineHtmlStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_statement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EmptyStatement_Context extends ParserRuleContext {
        public EmptyStatement_Context(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_emptyStatement_;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterEmptyStatement_(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitEmptyStatement_(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitEmptyStatement_(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BlockStatementContext extends ParserRuleContext {
        public BlockStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_blockStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterBlockStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitBlockStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitBlockStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IfStatementContext extends ParserRuleContext {
        public IfStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode If() {
            return getToken(PhpParser.If, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public List<ElseIfStatementContext> elseIfStatement() {
            return getRuleContexts(ElseIfStatementContext.class);
        }

        public ElseIfStatementContext elseIfStatement(int i) {
            return getRuleContext(ElseIfStatementContext.class, i);
        }

        public ElseStatementContext elseStatement() {
            return getRuleContext(ElseStatementContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        public TerminalNode EndIf() {
            return getToken(PhpParser.EndIf, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public List<ElseIfColonStatementContext> elseIfColonStatement() {
            return getRuleContexts(ElseIfColonStatementContext.class);
        }

        public ElseIfColonStatementContext elseIfColonStatement(int i) {
            return getRuleContext(ElseIfColonStatementContext.class, i);
        }

        public ElseColonStatementContext elseColonStatement() {
            return getRuleContext(ElseColonStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterIfStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitIfStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitIfStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ElseIfStatementContext extends ParserRuleContext {
        public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ElseIf() {
            return getToken(PhpParser.ElseIf, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elseIfStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterElseIfStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitElseIfStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitElseIfStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ElseIfColonStatementContext extends ParserRuleContext {
        public ElseIfColonStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ElseIf() {
            return getToken(PhpParser.ElseIf, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elseIfColonStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterElseIfColonStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitElseIfColonStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitElseIfColonStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ElseStatementContext extends ParserRuleContext {
        public ElseStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Else() {
            return getToken(PhpParser.Else, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elseStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterElseStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitElseStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitElseStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ElseColonStatementContext extends ParserRuleContext {
        public ElseColonStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Else() {
            return getToken(PhpParser.Else, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_elseColonStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterElseColonStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitElseColonStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitElseColonStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WhileStatementContext extends ParserRuleContext {
        public WhileStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode While() {
            return getToken(PhpParser.While, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        public TerminalNode EndWhile() {
            return getToken(PhpParser.EndWhile, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whileStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterWhileStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitWhileStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitWhileStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DoWhileStatementContext extends ParserRuleContext {
        public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Do() {
            return getToken(PhpParser.Do, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode While() {
            return getToken(PhpParser.While, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_doWhileStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterDoWhileStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitDoWhileStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitDoWhileStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForStatementContext extends ParserRuleContext {
        public ForStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode For() {
            return getToken(PhpParser.For, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public List<TerminalNode> SemiColon() {
            return getTokens(PhpParser.SemiColon);
        }

        public TerminalNode SemiColon(int i) {
            return getToken(PhpParser.SemiColon, i);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        public TerminalNode EndFor() {
            return getToken(PhpParser.EndFor, 0);
        }

        public ForInitContext forInit() {
            return getRuleContext(ForInitContext.class, 0);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        public ForUpdateContext forUpdate() {
            return getRuleContext(ForUpdateContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterForStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitForStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitForStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForInitContext extends ParserRuleContext {
        public ForInitContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forInit;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterForInit(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitForInit(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitForInit(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForUpdateContext extends ParserRuleContext {
        public ForUpdateContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forUpdate;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterForUpdate(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitForUpdate(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitForUpdate(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SwitchStatementContext extends ParserRuleContext {
        public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Switch() {
            return getToken(PhpParser.Switch, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public TerminalNode EndSwitch() {
            return getToken(PhpParser.EndSwitch, 0);
        }

        public List<TerminalNode> SemiColon() {
            return getTokens(PhpParser.SemiColon);
        }

        public TerminalNode SemiColon(int i) {
            return getToken(PhpParser.SemiColon, i);
        }

        public List<SwitchBlockContext> switchBlock() {
            return getRuleContexts(SwitchBlockContext.class);
        }

        public SwitchBlockContext switchBlock(int i) {
            return getRuleContext(SwitchBlockContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_switchStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterSwitchStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitSwitchStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitSwitchStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SwitchBlockContext extends ParserRuleContext {
        public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        public List<TerminalNode> Colon() {
            return getTokens(PhpParser.Colon);
        }

        public TerminalNode Colon(int i) {
            return getToken(PhpParser.Colon, i);
        }

        public List<TerminalNode> SemiColon() {
            return getTokens(PhpParser.SemiColon);
        }

        public TerminalNode SemiColon(int i) {
            return getToken(PhpParser.SemiColon, i);
        }

        public List<TerminalNode> Case() {
            return getTokens(PhpParser.Case);
        }

        public TerminalNode Case(int i) {
            return getToken(PhpParser.Case, i);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<TerminalNode> Default() {
            return getTokens(PhpParser.Default);
        }

        public TerminalNode Default(int i) {
            return getToken(PhpParser.Default, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_switchBlock;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterSwitchBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitSwitchBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitSwitchBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BreakStatementContext extends ParserRuleContext {
        public BreakStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Break() {
            return getToken(PhpParser.Break, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_breakStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterBreakStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitBreakStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitBreakStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ContinueStatementContext extends ParserRuleContext {
        public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Continue() {
            return getToken(PhpParser.Continue, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_continueStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterContinueStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitContinueStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitContinueStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ReturnStatementContext extends ParserRuleContext {
        public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Return() {
            return getToken(PhpParser.Return, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_returnStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterReturnStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitReturnStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitReturnStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExpressionStatementContext extends ParserRuleContext {
        public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expressionStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterExpressionStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitExpressionStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitExpressionStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class UnsetStatementContext extends ParserRuleContext {
        public UnsetStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Unset() {
            return getToken(PhpParser.Unset, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public ChainListContext chainList() {
            return getRuleContext(ChainListContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unsetStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterUnsetStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitUnsetStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitUnsetStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForeachStatementContext extends ParserRuleContext {
        public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Foreach() {
            return getToken(PhpParser.Foreach, 0);
        }

        public List<TerminalNode> OpenRoundBracket() {
            return getTokens(PhpParser.OpenRoundBracket);
        }

        public TerminalNode OpenRoundBracket(int i) {
            return getToken(PhpParser.OpenRoundBracket, i);
        }

        public List<ChainContext> chain() {
            return getRuleContexts(ChainContext.class);
        }

        public ChainContext chain(int i) {
            return getRuleContext(ChainContext.class, i);
        }

        public TerminalNode As() {
            return getToken(PhpParser.As, 0);
        }

        public AssignableContext assignable() {
            return getRuleContext(AssignableContext.class, 0);
        }

        public List<TerminalNode> CloseRoundBracket() {
            return getTokens(PhpParser.CloseRoundBracket);
        }

        public TerminalNode CloseRoundBracket(int i) {
            return getToken(PhpParser.CloseRoundBracket, i);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode List() {
            return getToken(PhpParser.List, 0);
        }

        public AssignmentListContext assignmentList() {
            return getRuleContext(AssignmentListContext.class, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        public TerminalNode EndForeach() {
            return getToken(PhpParser.EndForeach, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public List<TerminalNode> Ampersand() {
            return getTokens(PhpParser.Ampersand);
        }

        public TerminalNode Ampersand(int i) {
            return getToken(PhpParser.Ampersand, i);
        }

        public TerminalNode DoubleArrow() {
            return getToken(PhpParser.DoubleArrow, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_foreachStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterForeachStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitForeachStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitForeachStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TryCatchFinallyContext extends ParserRuleContext {
        public TryCatchFinallyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Try() {
            return getToken(PhpParser.Try, 0);
        }

        public BlockStatementContext blockStatement() {
            return getRuleContext(BlockStatementContext.class, 0);
        }

        public FinallyStatementContext finallyStatement() {
            return getRuleContext(FinallyStatementContext.class, 0);
        }

        public List<CatchClauseContext> catchClause() {
            return getRuleContexts(CatchClauseContext.class);
        }

        public CatchClauseContext catchClause(int i) {
            return getRuleContext(CatchClauseContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_tryCatchFinally;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTryCatchFinally(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTryCatchFinally(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTryCatchFinally(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CatchClauseContext extends ParserRuleContext {
        public CatchClauseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Catch() {
            return getToken(PhpParser.Catch, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public List<QualifiedStaticTypeRefContext> qualifiedStaticTypeRef() {
            return getRuleContexts(QualifiedStaticTypeRefContext.class);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef(int i) {
            return getRuleContext(QualifiedStaticTypeRefContext.class, i);
        }

        public TerminalNode VarName() {
            return getToken(PhpParser.VarName, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public BlockStatementContext blockStatement() {
            return getRuleContext(BlockStatementContext.class, 0);
        }

        public List<TerminalNode> Pipe() {
            return getTokens(PhpParser.Pipe);
        }

        public TerminalNode Pipe(int i) {
            return getToken(PhpParser.Pipe, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_catchClause;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterCatchClause(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitCatchClause(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitCatchClause(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FinallyStatementContext extends ParserRuleContext {
        public FinallyStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Finally() {
            return getToken(PhpParser.Finally, 0);
        }

        public BlockStatementContext blockStatement() {
            return getRuleContext(BlockStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_finallyStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterFinallyStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitFinallyStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitFinallyStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ThrowStatementContext extends ParserRuleContext {
        public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Throw() {
            return getToken(PhpParser.Throw, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_throwStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterThrowStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitThrowStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitThrowStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GotoStatementContext extends ParserRuleContext {
        public GotoStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Goto() {
            return getToken(PhpParser.Goto, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_gotoStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterGotoStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitGotoStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitGotoStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DeclareStatementContext extends ParserRuleContext {
        public DeclareStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Declare() {
            return getToken(PhpParser.Declare, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public DeclareListContext declareList() {
            return getRuleContext(DeclareListContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public StatementContext statement() {
            return getRuleContext(StatementContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public InnerStatementListContext innerStatementList() {
            return getRuleContext(InnerStatementListContext.class, 0);
        }

        public TerminalNode EndDeclare() {
            return getToken(PhpParser.EndDeclare, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_declareStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterDeclareStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitDeclareStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitDeclareStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InlineHtmlStatementContext extends ParserRuleContext {
        public InlineHtmlStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<InlineHtmlContext> inlineHtml() {
            return getRuleContexts(InlineHtmlContext.class);
        }

        public InlineHtmlContext inlineHtml(int i) {
            return getRuleContext(InlineHtmlContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_inlineHtmlStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterInlineHtmlStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitInlineHtmlStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitInlineHtmlStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DeclareListContext extends ParserRuleContext {
        public DeclareListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<IdentifierInitializerContext> identifierInitializer() {
            return getRuleContexts(IdentifierInitializerContext.class);
        }

        public IdentifierInitializerContext identifierInitializer(int i) {
            return getRuleContext(IdentifierInitializerContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_declareList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterDeclareList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitDeclareList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitDeclareList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FormalParameterListContext extends ParserRuleContext {
        public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<FormalParameterContext> formalParameter() {
            return getRuleContexts(FormalParameterContext.class);
        }

        public FormalParameterContext formalParameter(int i) {
            return getRuleContext(FormalParameterContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_formalParameterList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterFormalParameterList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitFormalParameterList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitFormalParameterList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FormalParameterContext extends ParserRuleContext {
        public FormalParameterContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public VariableInitializerContext variableInitializer() {
            return getRuleContext(VariableInitializerContext.class, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        public MemberModifierContext memberModifier() {
            return getRuleContext(MemberModifierContext.class, 0);
        }

        public TerminalNode QuestionMark() {
            return getToken(PhpParser.QuestionMark, 0);
        }

        public TypeHintContext typeHint() {
            return getRuleContext(TypeHintContext.class, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public TerminalNode Ellipsis() {
            return getToken(PhpParser.Ellipsis, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_formalParameter;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterFormalParameter(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitFormalParameter(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitFormalParameter(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TypeHintContext extends ParserRuleContext {
        public TypeHintContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
            return getRuleContext(QualifiedStaticTypeRefContext.class, 0);
        }

        public TerminalNode Callable() {
            return getToken(PhpParser.Callable, 0);
        }

        public PrimitiveTypeContext primitiveType() {
            return getRuleContext(PrimitiveTypeContext.class, 0);
        }

        public List<TypeHintContext> typeHint() {
            return getRuleContexts(TypeHintContext.class);
        }

        public TypeHintContext typeHint(int i) {
            return getRuleContext(TypeHintContext.class, i);
        }

        public TerminalNode Pipe() {
            return getToken(PhpParser.Pipe, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeHint;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTypeHint(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTypeHint(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTypeHint(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GlobalStatementContext extends ParserRuleContext {
        public GlobalStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Global() {
            return getToken(PhpParser.Global, 0);
        }

        public List<GlobalVarContext> globalVar() {
            return getRuleContexts(GlobalVarContext.class);
        }

        public GlobalVarContext globalVar(int i) {
            return getRuleContext(GlobalVarContext.class, i);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterGlobalStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitGlobalStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitGlobalStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GlobalVarContext extends ParserRuleContext {
        public GlobalVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VarName() {
            return getToken(PhpParser.VarName, 0);
        }

        public TerminalNode Dollar() {
            return getToken(PhpParser.Dollar, 0);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterGlobalVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitGlobalVar(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitGlobalVar(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class EchoStatementContext extends ParserRuleContext {
        public EchoStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Echo() {
            return getToken(PhpParser.Echo, 0);
        }

        public ExpressionListContext expressionList() {
            return getRuleContext(ExpressionListContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_echoStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterEchoStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitEchoStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitEchoStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StaticVariableStatementContext extends ParserRuleContext {
        public StaticVariableStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Static() {
            return getToken(PhpParser.Static, 0);
        }

        public List<VariableInitializerContext> variableInitializer() {
            return getRuleContexts(VariableInitializerContext.class);
        }

        public VariableInitializerContext variableInitializer(int i) {
            return getRuleContext(VariableInitializerContext.class, i);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_staticVariableStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterStaticVariableStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitStaticVariableStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitStaticVariableStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ClassStatementContext extends ParserRuleContext {
        public ClassStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public PropertyModifiersContext propertyModifiers() {
            return getRuleContext(PropertyModifiersContext.class, 0);
        }

        public List<VariableInitializerContext> variableInitializer() {
            return getRuleContexts(VariableInitializerContext.class);
        }

        public VariableInitializerContext variableInitializer(int i) {
            return getRuleContext(VariableInitializerContext.class, i);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        public TerminalNode Const() {
            return getToken(PhpParser.Const, 0);
        }

        public List<IdentifierInitializerContext> identifierInitializer() {
            return getRuleContexts(IdentifierInitializerContext.class);
        }

        public IdentifierInitializerContext identifierInitializer(int i) {
            return getRuleContext(IdentifierInitializerContext.class, i);
        }

        public TerminalNode Function_() {
            return getToken(PhpParser.Function_, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public FormalParameterListContext formalParameterList() {
            return getRuleContext(FormalParameterListContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public MethodBodyContext methodBody() {
            return getRuleContext(MethodBodyContext.class, 0);
        }

        public TypeHintContext typeHint() {
            return getRuleContext(TypeHintContext.class, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        public MemberModifiersContext memberModifiers() {
            return getRuleContext(MemberModifiersContext.class, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public TypeParameterListInBracketsContext typeParameterListInBrackets() {
            return getRuleContext(TypeParameterListInBracketsContext.class, 0);
        }

        public BaseCtorCallContext baseCtorCall() {
            return getRuleContext(BaseCtorCallContext.class, 0);
        }

        public TerminalNode Use() {
            return getToken(PhpParser.Use, 0);
        }

        public QualifiedNamespaceNameListContext qualifiedNamespaceNameList() {
            return getRuleContext(QualifiedNamespaceNameListContext.class, 0);
        }

        public TraitAdaptationsContext traitAdaptations() {
            return getRuleContext(TraitAdaptationsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterClassStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitClassStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitClassStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TraitAdaptationsContext extends ParserRuleContext {
        public TraitAdaptationsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public List<TraitAdaptationStatementContext> traitAdaptationStatement() {
            return getRuleContexts(TraitAdaptationStatementContext.class);
        }

        public TraitAdaptationStatementContext traitAdaptationStatement(int i) {
            return getRuleContext(TraitAdaptationStatementContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_traitAdaptations;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTraitAdaptations(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTraitAdaptations(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTraitAdaptations(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TraitAdaptationStatementContext extends ParserRuleContext {
        public TraitAdaptationStatementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TraitPrecedenceContext traitPrecedence() {
            return getRuleContext(TraitPrecedenceContext.class, 0);
        }

        public TraitAliasContext traitAlias() {
            return getRuleContext(TraitAliasContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_traitAdaptationStatement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTraitAdaptationStatement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTraitAdaptationStatement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTraitAdaptationStatement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TraitPrecedenceContext extends ParserRuleContext {
        public TraitPrecedenceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName() {
            return getRuleContext(QualifiedNamespaceNameContext.class, 0);
        }

        public TerminalNode DoubleColon() {
            return getToken(PhpParser.DoubleColon, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode InsteadOf() {
            return getToken(PhpParser.InsteadOf, 0);
        }

        public QualifiedNamespaceNameListContext qualifiedNamespaceNameList() {
            return getRuleContext(QualifiedNamespaceNameListContext.class, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_traitPrecedence;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTraitPrecedence(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTraitPrecedence(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTraitPrecedence(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TraitAliasContext extends ParserRuleContext {
        public TraitAliasContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TraitMethodReferenceContext traitMethodReference() {
            return getRuleContext(TraitMethodReferenceContext.class, 0);
        }

        public TerminalNode As() {
            return getToken(PhpParser.As, 0);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public MemberModifierContext memberModifier() {
            return getRuleContext(MemberModifierContext.class, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_traitAlias;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTraitAlias(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTraitAlias(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTraitAlias(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TraitMethodReferenceContext extends ParserRuleContext {
        public TraitMethodReferenceContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName() {
            return getRuleContext(QualifiedNamespaceNameContext.class, 0);
        }

        public TerminalNode DoubleColon() {
            return getToken(PhpParser.DoubleColon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_traitMethodReference;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTraitMethodReference(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTraitMethodReference(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTraitMethodReference(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BaseCtorCallContext extends ParserRuleContext {
        public BaseCtorCallContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_baseCtorCall;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterBaseCtorCall(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitBaseCtorCall(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitBaseCtorCall(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MethodBodyContext extends ParserRuleContext {
        public MethodBodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public BlockStatementContext blockStatement() {
            return getRuleContext(BlockStatementContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_methodBody;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMethodBody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMethodBody(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMethodBody(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PropertyModifiersContext extends ParserRuleContext {
        public PropertyModifiersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public MemberModifiersContext memberModifiers() {
            return getRuleContext(MemberModifiersContext.class, 0);
        }

        public TerminalNode Var() {
            return getToken(PhpParser.Var, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_propertyModifiers;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterPropertyModifiers(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitPropertyModifiers(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitPropertyModifiers(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MemberModifiersContext extends ParserRuleContext {
        public MemberModifiersContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<MemberModifierContext> memberModifier() {
            return getRuleContexts(MemberModifierContext.class);
        }

        public MemberModifierContext memberModifier(int i) {
            return getRuleContext(MemberModifierContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_memberModifiers;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMemberModifiers(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMemberModifiers(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMemberModifiers(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class VariableInitializerContext extends ParserRuleContext {
        public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VarName() {
            return getToken(PhpParser.VarName, 0);
        }

        public TerminalNode Eq() {
            return getToken(PhpParser.Eq, 0);
        }

        public ConstantInitializerContext constantInitializer() {
            return getRuleContext(ConstantInitializerContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_variableInitializer;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterVariableInitializer(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitVariableInitializer(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitVariableInitializer(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IdentifierInitializerContext extends ParserRuleContext {
        public IdentifierInitializerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode Eq() {
            return getToken(PhpParser.Eq, 0);
        }

        public ConstantInitializerContext constantInitializer() {
            return getRuleContext(ConstantInitializerContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_identifierInitializer;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterIdentifierInitializer(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitIdentifierInitializer(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitIdentifierInitializer(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class GlobalConstantDeclarationContext extends ParserRuleContext {
        public GlobalConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Const() {
            return getToken(PhpParser.Const, 0);
        }

        public List<IdentifierInitializerContext> identifierInitializer() {
            return getRuleContexts(IdentifierInitializerContext.class);
        }

        public IdentifierInitializerContext identifierInitializer(int i) {
            return getRuleContext(IdentifierInitializerContext.class, i);
        }

        public TerminalNode SemiColon() {
            return getToken(PhpParser.SemiColon, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_globalConstantDeclaration;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterGlobalConstantDeclaration(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitGlobalConstantDeclaration(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitGlobalConstantDeclaration(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExpressionListContext extends ParserRuleContext {
        public ExpressionListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expressionList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterExpressionList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitExpressionList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitExpressionList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ParenthesesContext extends ParserRuleContext {
        public ParenthesesContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public YieldExpressionContext yieldExpression() {
            return getRuleContext(YieldExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_parentheses;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterParentheses(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitParentheses(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitParentheses(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExpressionContext extends ParserRuleContext {
        public ExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext() {
        }

        @Override
        public int getRuleIndex() {
            return RULE_expression;
        }

        public void copyFrom(ExpressionContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ChainExpressionContext extends ExpressionContext {
        public ChainExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterChainExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitChainExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitChainExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SpecialWordExpressionContext extends ExpressionContext {
        public SpecialWordExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Yield() {
            return getToken(PhpParser.Yield, 0);
        }

        public TerminalNode List() {
            return getToken(PhpParser.List, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public AssignmentListContext assignmentList() {
            return getRuleContext(AssignmentListContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public TerminalNode Eq() {
            return getToken(PhpParser.Eq, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode IsSet() {
            return getToken(PhpParser.IsSet, 0);
        }

        public ChainListContext chainList() {
            return getRuleContext(ChainListContext.class, 0);
        }

        public TerminalNode Empty() {
            return getToken(PhpParser.Empty, 0);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        public TerminalNode Eval() {
            return getToken(PhpParser.Eval, 0);
        }

        public TerminalNode Exit() {
            return getToken(PhpParser.Exit, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        public TerminalNode Include() {
            return getToken(PhpParser.Include, 0);
        }

        public TerminalNode IncludeOnce() {
            return getToken(PhpParser.IncludeOnce, 0);
        }

        public TerminalNode Require() {
            return getToken(PhpParser.Require, 0);
        }

        public TerminalNode RequireOnce() {
            return getToken(PhpParser.RequireOnce, 0);
        }

        public TerminalNode Throw() {
            return getToken(PhpParser.Throw, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterSpecialWordExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitSpecialWordExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitSpecialWordExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArrayCreationExpressionContext extends ExpressionContext {
        public ArrayCreationExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ArrayCreationContext arrayCreation() {
            return getRuleContext(ArrayCreationContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterArrayCreationExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitArrayCreationExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitArrayCreationExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BackQuoteStringExpressionContext extends ExpressionContext {
        public BackQuoteStringExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode BackQuoteString() {
            return getToken(PhpParser.BackQuoteString, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterBackQuoteStringExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitBackQuoteStringExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitBackQuoteStringExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchExpressionContext extends ExpressionContext {
        public MatchExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public MatchExprContext matchExpr() {
            return getRuleContext(MatchExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMatchExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMatchExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMatchExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LogicalExpressionContext extends ExpressionContext {
        public Token op;

        public LogicalExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode LogicalAnd() {
            return getToken(PhpParser.LogicalAnd, 0);
        }

        public TerminalNode LogicalXor() {
            return getToken(PhpParser.LogicalXor, 0);
        }

        public TerminalNode LogicalOr() {
            return getToken(PhpParser.LogicalOr, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterLogicalExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitLogicalExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitLogicalExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrintExpressionContext extends ExpressionContext {
        public PrintExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Print() {
            return getToken(PhpParser.Print, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterPrintExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitPrintExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitPrintExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignmentExpressionContext extends ExpressionContext {
        public AssignmentExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public AssignableContext assignable() {
            return getRuleContext(AssignableContext.class, 0);
        }

        public AssignmentOperatorContext assignmentOperator() {
            return getRuleContext(AssignmentOperatorContext.class, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        public TerminalNode Eq() {
            return getToken(PhpParser.Eq, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        public NewExprContext newExpr() {
            return getRuleContext(NewExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAssignmentExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAssignmentExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAssignmentExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PostfixIncDecExpressionContext extends ExpressionContext {
        public PostfixIncDecExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        public TerminalNode Inc() {
            return getToken(PhpParser.Inc, 0);
        }

        public TerminalNode Dec() {
            return getToken(PhpParser.Dec, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterPostfixIncDecExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitPostfixIncDecExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitPostfixIncDecExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CloneExpressionContext extends ExpressionContext {
        public CloneExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode Clone() {
            return getToken(PhpParser.Clone, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterCloneExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitCloneExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitCloneExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class UnaryOperatorExpressionContext extends ExpressionContext {
        public UnaryOperatorExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode Tilde() {
            return getToken(PhpParser.Tilde, 0);
        }

        public TerminalNode SuppressWarnings() {
            return getToken(PhpParser.SuppressWarnings, 0);
        }

        public TerminalNode Bang() {
            return getToken(PhpParser.Bang, 0);
        }

        public TerminalNode Plus() {
            return getToken(PhpParser.Plus, 0);
        }

        public TerminalNode Minus() {
            return getToken(PhpParser.Minus, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterUnaryOperatorExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitUnaryOperatorExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitUnaryOperatorExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NewExpressionContext extends ExpressionContext {
        public NewExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public NewExprContext newExpr() {
            return getRuleContext(NewExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNewExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNewExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNewExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ParenthesisExpressionContext extends ExpressionContext {
        public ParenthesisExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterParenthesisExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitParenthesisExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitParenthesisExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SpaceshipExpressionContext extends ExpressionContext {
        public Token op;

        public SpaceshipExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode Spaceship() {
            return getToken(PhpParser.Spaceship, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterSpaceshipExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitSpaceshipExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitSpaceshipExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ConditionalExpressionContext extends ExpressionContext {
        public Token op;

        public ConditionalExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public TerminalNode QuestionMark() {
            return getToken(PhpParser.QuestionMark, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterConditionalExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitConditionalExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitConditionalExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NullCoalescingExpressionContext extends ExpressionContext {
        public Token op;

        public NullCoalescingExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode NullCoalescing() {
            return getToken(PhpParser.NullCoalescing, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNullCoalescingExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNullCoalescingExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNullCoalescingExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArithmeticExpressionContext extends ExpressionContext {
        public Token op;

        public ArithmeticExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode Pow() {
            return getToken(PhpParser.Pow, 0);
        }

        public TerminalNode Asterisk() {
            return getToken(PhpParser.Asterisk, 0);
        }

        public TerminalNode Divide() {
            return getToken(PhpParser.Divide, 0);
        }

        public TerminalNode Percent() {
            return getToken(PhpParser.Percent, 0);
        }

        public TerminalNode Plus() {
            return getToken(PhpParser.Plus, 0);
        }

        public TerminalNode Minus() {
            return getToken(PhpParser.Minus, 0);
        }

        public TerminalNode Dot() {
            return getToken(PhpParser.Dot, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterArithmeticExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitArithmeticExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitArithmeticExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IndexerExpressionContext extends ExpressionContext {
        public IndexerExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public StringConstantContext stringConstant() {
            return getRuleContext(StringConstantContext.class, 0);
        }

        public TerminalNode OpenSquareBracket() {
            return getToken(PhpParser.OpenSquareBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CloseSquareBracket() {
            return getToken(PhpParser.CloseSquareBracket, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterIndexerExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitIndexerExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitIndexerExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ScalarExpressionContext extends ExpressionContext {
        public ScalarExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public TerminalNode Label() {
            return getToken(PhpParser.Label, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterScalarExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitScalarExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitScalarExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrefixIncDecExpressionContext extends ExpressionContext {
        public PrefixIncDecExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        public TerminalNode Inc() {
            return getToken(PhpParser.Inc, 0);
        }

        public TerminalNode Dec() {
            return getToken(PhpParser.Dec, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterPrefixIncDecExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitPrefixIncDecExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitPrefixIncDecExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ComparisonExpressionContext extends ExpressionContext {
        public Token op;

        public ComparisonExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode ShiftLeft() {
            return getToken(PhpParser.ShiftLeft, 0);
        }

        public TerminalNode ShiftRight() {
            return getToken(PhpParser.ShiftRight, 0);
        }

        public TerminalNode Less() {
            return getToken(PhpParser.Less, 0);
        }

        public TerminalNode IsSmallerOrEqual() {
            return getToken(PhpParser.IsSmallerOrEqual, 0);
        }

        public TerminalNode Greater() {
            return getToken(PhpParser.Greater, 0);
        }

        public TerminalNode IsGreaterOrEqual() {
            return getToken(PhpParser.IsGreaterOrEqual, 0);
        }

        public TerminalNode IsIdentical() {
            return getToken(PhpParser.IsIdentical, 0);
        }

        public TerminalNode IsNoidentical() {
            return getToken(PhpParser.IsNoidentical, 0);
        }

        public TerminalNode IsEqual() {
            return getToken(PhpParser.IsEqual, 0);
        }

        public TerminalNode IsNotEq() {
            return getToken(PhpParser.IsNotEq, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterComparisonExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitComparisonExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitComparisonExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CastExpressionContext extends ExpressionContext {
        public CastExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public CastOperationContext castOperation() {
            return getRuleContext(CastOperationContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterCastExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitCastExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitCastExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InstanceOfExpressionContext extends ExpressionContext {
        public InstanceOfExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode InstanceOf() {
            return getToken(PhpParser.InstanceOf, 0);
        }

        public TypeRefContext typeRef() {
            return getRuleContext(TypeRefContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterInstanceOfExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitInstanceOfExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitInstanceOfExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LambdaFunctionExpressionContext extends ExpressionContext {
        public LambdaFunctionExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public LambdaFunctionExprContext lambdaFunctionExpr() {
            return getRuleContext(LambdaFunctionExprContext.class, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterLambdaFunctionExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitLambdaFunctionExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitLambdaFunctionExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BitwiseExpressionContext extends ExpressionContext {
        public Token op;

        public BitwiseExpressionContext(ExpressionContext ctx) {
            copyFrom(ctx);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public TerminalNode Caret() {
            return getToken(PhpParser.Caret, 0);
        }

        public TerminalNode Pipe() {
            return getToken(PhpParser.Pipe, 0);
        }

        public TerminalNode BooleanAnd() {
            return getToken(PhpParser.BooleanAnd, 0);
        }

        public TerminalNode BooleanOr() {
            return getToken(PhpParser.BooleanOr, 0);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterBitwiseExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitBitwiseExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitBitwiseExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignableContext extends ParserRuleContext {
        public AssignableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        public ArrayCreationContext arrayCreation() {
            return getRuleContext(ArrayCreationContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAssignable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAssignable(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAssignable(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArrayCreationContext extends ParserRuleContext {
        public ArrayCreationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Array() {
            return getToken(PhpParser.Array, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public List<TerminalNode> OpenSquareBracket() {
            return getTokens(PhpParser.OpenSquareBracket);
        }

        public TerminalNode OpenSquareBracket(int i) {
            return getToken(PhpParser.OpenSquareBracket, i);
        }

        public List<TerminalNode> CloseSquareBracket() {
            return getTokens(PhpParser.CloseSquareBracket);
        }

        public TerminalNode CloseSquareBracket(int i) {
            return getToken(PhpParser.CloseSquareBracket, i);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public ArrayItemListContext arrayItemList() {
            return getRuleContext(ArrayItemListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arrayCreation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterArrayCreation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitArrayCreation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitArrayCreation(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LambdaFunctionExprContext extends ParserRuleContext {
        public LambdaFunctionExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Function_() {
            return getToken(PhpParser.Function_, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public FormalParameterListContext formalParameterList() {
            return getRuleContext(FormalParameterListContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public BlockStatementContext blockStatement() {
            return getRuleContext(BlockStatementContext.class, 0);
        }

        public TerminalNode Static() {
            return getToken(PhpParser.Static, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public LambdaFunctionUseVarsContext lambdaFunctionUseVars() {
            return getRuleContext(LambdaFunctionUseVarsContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        public TypeHintContext typeHint() {
            return getRuleContext(TypeHintContext.class, 0);
        }

        public TerminalNode LambdaFn() {
            return getToken(PhpParser.LambdaFn, 0);
        }

        public TerminalNode DoubleArrow() {
            return getToken(PhpParser.DoubleArrow, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lambdaFunctionExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterLambdaFunctionExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitLambdaFunctionExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitLambdaFunctionExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchExprContext extends ParserRuleContext {
        public MatchExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Match_() {
            return getToken(PhpParser.Match_, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public List<MatchItemContext> matchItem() {
            return getRuleContexts(MatchItemContext.class);
        }

        public MatchItemContext matchItem(int i) {
            return getRuleContext(MatchItemContext.class, i);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_matchExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMatchExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMatchExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMatchExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MatchItemContext extends ParserRuleContext {
        public MatchItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode DoubleArrow() {
            return getToken(PhpParser.DoubleArrow, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_matchItem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMatchItem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMatchItem(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMatchItem(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NewExprContext extends ParserRuleContext {
        public NewExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode New() {
            return getToken(PhpParser.New, 0);
        }

        public TypeRefContext typeRef() {
            return getRuleContext(TypeRefContext.class, 0);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_newExpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNewExpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNewExpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNewExpr(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignmentOperatorContext extends ParserRuleContext {
        public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Eq() {
            return getToken(PhpParser.Eq, 0);
        }

        public TerminalNode PlusEqual() {
            return getToken(PhpParser.PlusEqual, 0);
        }

        public TerminalNode MinusEqual() {
            return getToken(PhpParser.MinusEqual, 0);
        }

        public TerminalNode MulEqual() {
            return getToken(PhpParser.MulEqual, 0);
        }

        public TerminalNode PowEqual() {
            return getToken(PhpParser.PowEqual, 0);
        }

        public TerminalNode DivEqual() {
            return getToken(PhpParser.DivEqual, 0);
        }

        public TerminalNode Concaequal() {
            return getToken(PhpParser.Concaequal, 0);
        }

        public TerminalNode ModEqual() {
            return getToken(PhpParser.ModEqual, 0);
        }

        public TerminalNode AndEqual() {
            return getToken(PhpParser.AndEqual, 0);
        }

        public TerminalNode OrEqual() {
            return getToken(PhpParser.OrEqual, 0);
        }

        public TerminalNode XorEqual() {
            return getToken(PhpParser.XorEqual, 0);
        }

        public TerminalNode ShiftLeftEqual() {
            return getToken(PhpParser.ShiftLeftEqual, 0);
        }

        public TerminalNode ShiftRightEqual() {
            return getToken(PhpParser.ShiftRightEqual, 0);
        }

        public TerminalNode NullCoalescingEqual() {
            return getToken(PhpParser.NullCoalescingEqual, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentOperator;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAssignmentOperator(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAssignmentOperator(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAssignmentOperator(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class YieldExpressionContext extends ParserRuleContext {
        public YieldExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Yield() {
            return getToken(PhpParser.Yield, 0);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode From() {
            return getToken(PhpParser.From, 0);
        }

        public TerminalNode DoubleArrow() {
            return getToken(PhpParser.DoubleArrow, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_yieldExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterYieldExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitYieldExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitYieldExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArrayItemListContext extends ParserRuleContext {
        public ArrayItemListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ArrayItemContext> arrayItem() {
            return getRuleContexts(ArrayItemContext.class);
        }

        public ArrayItemContext arrayItem(int i) {
            return getRuleContext(ArrayItemContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arrayItemList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterArrayItemList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitArrayItemList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitArrayItemList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArrayItemContext extends ParserRuleContext {
        public ArrayItemContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ExpressionContext> expression() {
            return getRuleContexts(ExpressionContext.class);
        }

        public ExpressionContext expression(int i) {
            return getRuleContext(ExpressionContext.class, i);
        }

        public TerminalNode DoubleArrow() {
            return getToken(PhpParser.DoubleArrow, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arrayItem;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterArrayItem(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitArrayItem(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitArrayItem(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LambdaFunctionUseVarsContext extends ParserRuleContext {
        public LambdaFunctionUseVarsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Use() {
            return getToken(PhpParser.Use, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public List<LambdaFunctionUseVarContext> lambdaFunctionUseVar() {
            return getRuleContexts(LambdaFunctionUseVarContext.class);
        }

        public LambdaFunctionUseVarContext lambdaFunctionUseVar(int i) {
            return getRuleContext(LambdaFunctionUseVarContext.class, i);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lambdaFunctionUseVars;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterLambdaFunctionUseVars(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitLambdaFunctionUseVars(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitLambdaFunctionUseVars(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LambdaFunctionUseVarContext extends ParserRuleContext {
        public LambdaFunctionUseVarContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VarName() {
            return getToken(PhpParser.VarName, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_lambdaFunctionUseVar;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterLambdaFunctionUseVar(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitLambdaFunctionUseVar(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitLambdaFunctionUseVar(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class QualifiedStaticTypeRefContext extends ParserRuleContext {
        public QualifiedStaticTypeRefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName() {
            return getRuleContext(QualifiedNamespaceNameContext.class, 0);
        }

        public GenericDynamicArgsContext genericDynamicArgs() {
            return getRuleContext(GenericDynamicArgsContext.class, 0);
        }

        public TerminalNode Static() {
            return getToken(PhpParser.Static, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qualifiedStaticTypeRef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterQualifiedStaticTypeRef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitQualifiedStaticTypeRef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitQualifiedStaticTypeRef(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class TypeRefContext extends ParserRuleContext {
        public TypeRefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName() {
            return getRuleContext(QualifiedNamespaceNameContext.class, 0);
        }

        public IndirectTypeRefContext indirectTypeRef() {
            return getRuleContext(IndirectTypeRefContext.class, 0);
        }

        public GenericDynamicArgsContext genericDynamicArgs() {
            return getRuleContext(GenericDynamicArgsContext.class, 0);
        }

        public PrimitiveTypeContext primitiveType() {
            return getRuleContext(PrimitiveTypeContext.class, 0);
        }

        public TerminalNode Static() {
            return getToken(PhpParser.Static, 0);
        }

        public AnonymousClassContext anonymousClass() {
            return getRuleContext(AnonymousClassContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_typeRef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterTypeRef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitTypeRef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitTypeRef(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AnonymousClassContext extends ParserRuleContext {
        public AnonymousClassContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public ClassEntryTypeContext classEntryType() {
            return getRuleContext(ClassEntryTypeContext.class, 0);
        }

        public TerminalNode Interface() {
            return getToken(PhpParser.Interface, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public AttributesContext attributes() {
            return getRuleContext(AttributesContext.class, 0);
        }

        public TerminalNode Private() {
            return getToken(PhpParser.Private, 0);
        }

        public ModifierContext modifier() {
            return getRuleContext(ModifierContext.class, 0);
        }

        public TerminalNode Partial() {
            return getToken(PhpParser.Partial, 0);
        }

        public List<ClassStatementContext> classStatement() {
            return getRuleContexts(ClassStatementContext.class);
        }

        public ClassStatementContext classStatement(int i) {
            return getRuleContext(ClassStatementContext.class, i);
        }

        public TypeParameterListInBracketsContext typeParameterListInBrackets() {
            return getRuleContext(TypeParameterListInBracketsContext.class, 0);
        }

        public TerminalNode Extends() {
            return getToken(PhpParser.Extends, 0);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
            return getRuleContext(QualifiedStaticTypeRefContext.class, 0);
        }

        public TerminalNode Implements() {
            return getToken(PhpParser.Implements, 0);
        }

        public InterfaceListContext interfaceList() {
            return getRuleContext(InterfaceListContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_anonymousClass;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAnonymousClass(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAnonymousClass(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAnonymousClass(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IndirectTypeRefContext extends ParserRuleContext {
        public IndirectTypeRefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ChainBaseContext chainBase() {
            return getRuleContext(ChainBaseContext.class, 0);
        }

        public List<TerminalNode> ObjectOperator() {
            return getTokens(PhpParser.ObjectOperator);
        }

        public TerminalNode ObjectOperator(int i) {
            return getToken(PhpParser.ObjectOperator, i);
        }

        public List<KeyedFieldNameContext> keyedFieldName() {
            return getRuleContexts(KeyedFieldNameContext.class);
        }

        public KeyedFieldNameContext keyedFieldName(int i) {
            return getRuleContext(KeyedFieldNameContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_indirectTypeRef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterIndirectTypeRef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitIndirectTypeRef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitIndirectTypeRef(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class QualifiedNamespaceNameContext extends ParserRuleContext {
        public QualifiedNamespaceNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public NamespaceNameListContext namespaceNameList() {
            return getRuleContext(NamespaceNameListContext.class, 0);
        }

        public TerminalNode Namespace() {
            return getToken(PhpParser.Namespace, 0);
        }

        public TerminalNode NamespaceSeparator() {
            return getToken(PhpParser.NamespaceSeparator, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qualifiedNamespaceName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterQualifiedNamespaceName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitQualifiedNamespaceName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitQualifiedNamespaceName(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NamespaceNameListContext extends ParserRuleContext {
        public NamespaceNameListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<IdentifierContext> identifier() {
            return getRuleContexts(IdentifierContext.class);
        }

        public IdentifierContext identifier(int i) {
            return getRuleContext(IdentifierContext.class, i);
        }

        public List<TerminalNode> NamespaceSeparator() {
            return getTokens(PhpParser.NamespaceSeparator);
        }

        public TerminalNode NamespaceSeparator(int i) {
            return getToken(PhpParser.NamespaceSeparator, i);
        }

        public NamespaceNameTailContext namespaceNameTail() {
            return getRuleContext(NamespaceNameTailContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namespaceNameList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNamespaceNameList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNamespaceNameList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNamespaceNameList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NamespaceNameTailContext extends ParserRuleContext {
        public NamespaceNameTailContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<IdentifierContext> identifier() {
            return getRuleContexts(IdentifierContext.class);
        }

        public IdentifierContext identifier(int i) {
            return getRuleContext(IdentifierContext.class, i);
        }

        public TerminalNode As() {
            return getToken(PhpParser.As, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public List<NamespaceNameTailContext> namespaceNameTail() {
            return getRuleContexts(NamespaceNameTailContext.class);
        }

        public NamespaceNameTailContext namespaceNameTail(int i) {
            return getRuleContext(NamespaceNameTailContext.class, i);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namespaceNameTail;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNamespaceNameTail(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNamespaceNameTail(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNamespaceNameTail(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class QualifiedNamespaceNameListContext extends ParserRuleContext {
        public QualifiedNamespaceNameListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<QualifiedNamespaceNameContext> qualifiedNamespaceName() {
            return getRuleContexts(QualifiedNamespaceNameContext.class);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName(int i) {
            return getRuleContext(QualifiedNamespaceNameContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_qualifiedNamespaceNameList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterQualifiedNamespaceNameList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitQualifiedNamespaceNameList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitQualifiedNamespaceNameList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArgumentsContext extends ParserRuleContext {
        public ArgumentsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public List<ActualArgumentContext> actualArgument() {
            return getRuleContexts(ActualArgumentContext.class);
        }

        public ActualArgumentContext actualArgument(int i) {
            return getRuleContext(ActualArgumentContext.class, i);
        }

        public YieldExpressionContext yieldExpression() {
            return getRuleContext(YieldExpressionContext.class, 0);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_arguments;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterArguments(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitArguments(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitArguments(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ActualArgumentContext extends ParserRuleContext {
        public ActualArgumentContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public ArgumentNameContext argumentName() {
            return getRuleContext(ArgumentNameContext.class, 0);
        }

        public TerminalNode Ellipsis() {
            return getToken(PhpParser.Ellipsis, 0);
        }

        public TerminalNode Ampersand() {
            return getToken(PhpParser.Ampersand, 0);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_actualArgument;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterActualArgument(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitActualArgument(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitActualArgument(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ArgumentNameContext extends ParserRuleContext {
        public ArgumentNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode Colon() {
            return getToken(PhpParser.Colon, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_argumentName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterArgumentName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitArgumentName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitArgumentName(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ConstantInitializerContext extends ParserRuleContext {
        public ConstantInitializerContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ConstantContext constant() {
            return getRuleContext(ConstantContext.class, 0);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public TerminalNode Array() {
            return getToken(PhpParser.Array, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public ArrayItemListContext arrayItemList() {
            return getRuleContext(ArrayItemListContext.class, 0);
        }

        public TerminalNode Comma() {
            return getToken(PhpParser.Comma, 0);
        }

        public TerminalNode OpenSquareBracket() {
            return getToken(PhpParser.OpenSquareBracket, 0);
        }

        public TerminalNode CloseSquareBracket() {
            return getToken(PhpParser.CloseSquareBracket, 0);
        }

        public ConstantInitializerContext constantInitializer() {
            return getRuleContext(ConstantInitializerContext.class, 0);
        }

        public TerminalNode Plus() {
            return getToken(PhpParser.Plus, 0);
        }

        public TerminalNode Minus() {
            return getToken(PhpParser.Minus, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constantInitializer;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterConstantInitializer(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitConstantInitializer(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitConstantInitializer(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ConstantContext extends ParserRuleContext {
        public ConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Null() {
            return getToken(PhpParser.Null, 0);
        }

        public LiteralConstantContext literalConstant() {
            return getRuleContext(LiteralConstantContext.class, 0);
        }

        public MagicConstantContext magicConstant() {
            return getRuleContext(MagicConstantContext.class, 0);
        }

        public ClassConstantContext classConstant() {
            return getRuleContext(ClassConstantContext.class, 0);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName() {
            return getRuleContext(QualifiedNamespaceNameContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LiteralConstantContext extends ParserRuleContext {
        public LiteralConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Real() {
            return getToken(PhpParser.Real, 0);
        }

        public TerminalNode BooleanConstant() {
            return getToken(PhpParser.BooleanConstant, 0);
        }

        public NumericConstantContext numericConstant() {
            return getRuleContext(NumericConstantContext.class, 0);
        }

        public StringConstantContext stringConstant() {
            return getRuleContext(StringConstantContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_literalConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterLiteralConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitLiteralConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitLiteralConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NumericConstantContext extends ParserRuleContext {
        public NumericConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Octal() {
            return getToken(PhpParser.Octal, 0);
        }

        public TerminalNode Decimal() {
            return getToken(PhpParser.Decimal, 0);
        }

        public TerminalNode Hex() {
            return getToken(PhpParser.Hex, 0);
        }

        public TerminalNode Binary() {
            return getToken(PhpParser.Binary, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_numericConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterNumericConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitNumericConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitNumericConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ClassConstantContext extends ParserRuleContext {
        public ClassConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode DoubleColon() {
            return getToken(PhpParser.DoubleColon, 0);
        }

        public TerminalNode Class() {
            return getToken(PhpParser.Class, 0);
        }

        public TerminalNode Parent_() {
            return getToken(PhpParser.Parent_, 0);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode Constructor() {
            return getToken(PhpParser.Constructor, 0);
        }

        public TerminalNode Get() {
            return getToken(PhpParser.Get, 0);
        }

        public TerminalNode Set() {
            return getToken(PhpParser.Set, 0);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
            return getRuleContext(QualifiedStaticTypeRefContext.class, 0);
        }

        public List<KeyedVariableContext> keyedVariable() {
            return getRuleContexts(KeyedVariableContext.class);
        }

        public KeyedVariableContext keyedVariable(int i) {
            return getRuleContext(KeyedVariableContext.class, i);
        }

        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_classConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterClassConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitClassConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitClassConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StringConstantContext extends ParserRuleContext {
        public StringConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Label() {
            return getToken(PhpParser.Label, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stringConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterStringConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitStringConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitStringConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StringContext extends ParserRuleContext {
        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode StartHereDoc() {
            return getToken(PhpParser.StartHereDoc, 0);
        }

        public List<TerminalNode> HereDocText() {
            return getTokens(PhpParser.HereDocText);
        }

        public TerminalNode HereDocText(int i) {
            return getToken(PhpParser.HereDocText, i);
        }

        public TerminalNode StartNowDoc() {
            return getToken(PhpParser.StartNowDoc, 0);
        }

        public TerminalNode SingleQuoteString() {
            return getToken(PhpParser.SingleQuoteString, 0);
        }

        public List<TerminalNode> DoubleQuote() {
            return getTokens(PhpParser.DoubleQuote);
        }

        public TerminalNode DoubleQuote(int i) {
            return getToken(PhpParser.DoubleQuote, i);
        }

        public List<InterpolatedStringPartContext> interpolatedStringPart() {
            return getRuleContexts(InterpolatedStringPartContext.class);
        }

        public InterpolatedStringPartContext interpolatedStringPart(int i) {
            return getRuleContext(InterpolatedStringPartContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitString(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class InterpolatedStringPartContext extends ParserRuleContext {
        public InterpolatedStringPartContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode StringPart() {
            return getToken(PhpParser.StringPart, 0);
        }

        public TerminalNode UnicodeEscape() {
            return getToken(PhpParser.UnicodeEscape, 0);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_interpolatedStringPart;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterInterpolatedStringPart(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitInterpolatedStringPart(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitInterpolatedStringPart(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ChainListContext extends ParserRuleContext {
        public ChainListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<ChainContext> chain() {
            return getRuleContexts(ChainContext.class);
        }

        public ChainContext chain(int i) {
            return getRuleContext(ChainContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_chainList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterChainList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitChainList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitChainList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ChainContext extends ParserRuleContext {
        public ChainContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ChainOriginContext chainOrigin() {
            return getRuleContext(ChainOriginContext.class, 0);
        }

        public List<MemberAccessContext> memberAccess() {
            return getRuleContexts(MemberAccessContext.class);
        }

        public MemberAccessContext memberAccess(int i) {
            return getRuleContext(MemberAccessContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_chain;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterChain(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitChain(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitChain(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ChainOriginContext extends ParserRuleContext {
        public ChainOriginContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ChainBaseContext chainBase() {
            return getRuleContext(ChainBaseContext.class, 0);
        }

        public FunctionCallContext functionCall() {
            return getRuleContext(FunctionCallContext.class, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public NewExprContext newExpr() {
            return getRuleContext(NewExprContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_chainOrigin;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterChainOrigin(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitChainOrigin(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitChainOrigin(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MemberAccessContext extends ParserRuleContext {
        public MemberAccessContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode ObjectOperator() {
            return getToken(PhpParser.ObjectOperator, 0);
        }

        public KeyedFieldNameContext keyedFieldName() {
            return getRuleContext(KeyedFieldNameContext.class, 0);
        }

        public ActualArgumentsContext actualArguments() {
            return getRuleContext(ActualArgumentsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_memberAccess;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMemberAccess(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMemberAccess(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMemberAccess(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionCallContext extends ParserRuleContext {
        public FunctionCallContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public FunctionCallNameContext functionCallName() {
            return getRuleContext(FunctionCallNameContext.class, 0);
        }

        public ActualArgumentsContext actualArguments() {
            return getRuleContext(ActualArgumentsContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionCall;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterFunctionCall(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitFunctionCall(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitFunctionCall(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionCallNameContext extends ParserRuleContext {
        public FunctionCallNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public QualifiedNamespaceNameContext qualifiedNamespaceName() {
            return getRuleContext(QualifiedNamespaceNameContext.class, 0);
        }

        public ClassConstantContext classConstant() {
            return getRuleContext(ClassConstantContext.class, 0);
        }

        public ChainBaseContext chainBase() {
            return getRuleContext(ChainBaseContext.class, 0);
        }

        public ParenthesesContext parentheses() {
            return getRuleContext(ParenthesesContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionCallName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterFunctionCallName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitFunctionCallName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitFunctionCallName(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ActualArgumentsContext extends ParserRuleContext {
        public ActualArgumentsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ArgumentsContext arguments() {
            return getRuleContext(ArgumentsContext.class, 0);
        }

        public GenericDynamicArgsContext genericDynamicArgs() {
            return getRuleContext(GenericDynamicArgsContext.class, 0);
        }

        public List<SquareCurlyExpressionContext> squareCurlyExpression() {
            return getRuleContexts(SquareCurlyExpressionContext.class);
        }

        public SquareCurlyExpressionContext squareCurlyExpression(int i) {
            return getRuleContext(SquareCurlyExpressionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_actualArguments;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterActualArguments(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitActualArguments(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitActualArguments(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ChainBaseContext extends ParserRuleContext {
        public ChainBaseContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<KeyedVariableContext> keyedVariable() {
            return getRuleContexts(KeyedVariableContext.class);
        }

        public KeyedVariableContext keyedVariable(int i) {
            return getRuleContext(KeyedVariableContext.class, i);
        }

        public TerminalNode DoubleColon() {
            return getToken(PhpParser.DoubleColon, 0);
        }

        public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
            return getRuleContext(QualifiedStaticTypeRefContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_chainBase;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterChainBase(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitChainBase(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitChainBase(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class KeyedFieldNameContext extends ParserRuleContext {
        public KeyedFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public KeyedSimpleFieldNameContext keyedSimpleFieldName() {
            return getRuleContext(KeyedSimpleFieldNameContext.class, 0);
        }

        public KeyedVariableContext keyedVariable() {
            return getRuleContext(KeyedVariableContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_keyedFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterKeyedFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitKeyedFieldName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitKeyedFieldName(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class KeyedSimpleFieldNameContext extends ParserRuleContext {
        public KeyedSimpleFieldNameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public IdentifierContext identifier() {
            return getRuleContext(IdentifierContext.class, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public List<SquareCurlyExpressionContext> squareCurlyExpression() {
            return getRuleContexts(SquareCurlyExpressionContext.class);
        }

        public SquareCurlyExpressionContext squareCurlyExpression(int i) {
            return getRuleContext(SquareCurlyExpressionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_keyedSimpleFieldName;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterKeyedSimpleFieldName(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitKeyedSimpleFieldName(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitKeyedSimpleFieldName(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class KeyedVariableContext extends ParserRuleContext {
        public KeyedVariableContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode VarName() {
            return getToken(PhpParser.VarName, 0);
        }

        public List<TerminalNode> Dollar() {
            return getTokens(PhpParser.Dollar);
        }

        public TerminalNode Dollar(int i) {
            return getToken(PhpParser.Dollar, i);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        public List<SquareCurlyExpressionContext> squareCurlyExpression() {
            return getRuleContexts(SquareCurlyExpressionContext.class);
        }

        public SquareCurlyExpressionContext squareCurlyExpression(int i) {
            return getRuleContext(SquareCurlyExpressionContext.class, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_keyedVariable;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterKeyedVariable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitKeyedVariable(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitKeyedVariable(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class SquareCurlyExpressionContext extends ParserRuleContext {
        public SquareCurlyExpressionContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode OpenSquareBracket() {
            return getToken(PhpParser.OpenSquareBracket, 0);
        }

        public TerminalNode CloseSquareBracket() {
            return getToken(PhpParser.CloseSquareBracket, 0);
        }

        public ExpressionContext expression() {
            return getRuleContext(ExpressionContext.class, 0);
        }

        public TerminalNode OpenCurlyBracket() {
            return getToken(PhpParser.OpenCurlyBracket, 0);
        }

        public TerminalNode CloseCurlyBracket() {
            return getToken(PhpParser.CloseCurlyBracket, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_squareCurlyExpression;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterSquareCurlyExpression(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitSquareCurlyExpression(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitSquareCurlyExpression(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignmentListContext extends ParserRuleContext {
        public AssignmentListContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public List<AssignmentListElementContext> assignmentListElement() {
            return getRuleContexts(AssignmentListElementContext.class);
        }

        public AssignmentListElementContext assignmentListElement(int i) {
            return getRuleContext(AssignmentListElementContext.class, i);
        }

        public List<TerminalNode> Comma() {
            return getTokens(PhpParser.Comma);
        }

        public TerminalNode Comma(int i) {
            return getToken(PhpParser.Comma, i);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentList;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAssignmentList(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAssignmentList(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAssignmentList(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignmentListElementContext extends ParserRuleContext {
        public AssignmentListElementContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public ChainContext chain() {
            return getRuleContext(ChainContext.class, 0);
        }

        public TerminalNode List() {
            return getToken(PhpParser.List, 0);
        }

        public TerminalNode OpenRoundBracket() {
            return getToken(PhpParser.OpenRoundBracket, 0);
        }

        public AssignmentListContext assignmentList() {
            return getRuleContext(AssignmentListContext.class, 0);
        }

        public TerminalNode CloseRoundBracket() {
            return getToken(PhpParser.CloseRoundBracket, 0);
        }

        public ArrayItemContext arrayItem() {
            return getRuleContext(ArrayItemContext.class, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignmentListElement;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterAssignmentListElement(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitAssignmentListElement(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitAssignmentListElement(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ModifierContext extends ParserRuleContext {
        public ModifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Abstract() {
            return getToken(PhpParser.Abstract, 0);
        }

        public TerminalNode Final() {
            return getToken(PhpParser.Final, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_modifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterModifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitModifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitModifier(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IdentifierContext extends ParserRuleContext {
        public IdentifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Label() {
            return getToken(PhpParser.Label, 0);
        }

        public TerminalNode Abstract() {
            return getToken(PhpParser.Abstract, 0);
        }

        public TerminalNode Array() {
            return getToken(PhpParser.Array, 0);
        }

        public TerminalNode As() {
            return getToken(PhpParser.As, 0);
        }

        public TerminalNode BinaryCast() {
            return getToken(PhpParser.BinaryCast, 0);
        }

        public TerminalNode BoolType() {
            return getToken(PhpParser.BoolType, 0);
        }

        public TerminalNode BooleanConstant() {
            return getToken(PhpParser.BooleanConstant, 0);
        }

        public TerminalNode Break() {
            return getToken(PhpParser.Break, 0);
        }

        public TerminalNode Callable() {
            return getToken(PhpParser.Callable, 0);
        }

        public TerminalNode Case() {
            return getToken(PhpParser.Case, 0);
        }

        public TerminalNode Catch() {
            return getToken(PhpParser.Catch, 0);
        }

        public TerminalNode Class() {
            return getToken(PhpParser.Class, 0);
        }

        public TerminalNode Clone() {
            return getToken(PhpParser.Clone, 0);
        }

        public TerminalNode Const() {
            return getToken(PhpParser.Const, 0);
        }

        public TerminalNode Continue() {
            return getToken(PhpParser.Continue, 0);
        }

        public TerminalNode Declare() {
            return getToken(PhpParser.Declare, 0);
        }

        public TerminalNode Default() {
            return getToken(PhpParser.Default, 0);
        }

        public TerminalNode Do() {
            return getToken(PhpParser.Do, 0);
        }

        public TerminalNode DoubleCast() {
            return getToken(PhpParser.DoubleCast, 0);
        }

        public TerminalNode DoubleType() {
            return getToken(PhpParser.DoubleType, 0);
        }

        public TerminalNode Echo() {
            return getToken(PhpParser.Echo, 0);
        }

        public TerminalNode Else() {
            return getToken(PhpParser.Else, 0);
        }

        public TerminalNode ElseIf() {
            return getToken(PhpParser.ElseIf, 0);
        }

        public TerminalNode Empty() {
            return getToken(PhpParser.Empty, 0);
        }

        public TerminalNode EndDeclare() {
            return getToken(PhpParser.EndDeclare, 0);
        }

        public TerminalNode EndFor() {
            return getToken(PhpParser.EndFor, 0);
        }

        public TerminalNode EndForeach() {
            return getToken(PhpParser.EndForeach, 0);
        }

        public TerminalNode EndIf() {
            return getToken(PhpParser.EndIf, 0);
        }

        public TerminalNode EndSwitch() {
            return getToken(PhpParser.EndSwitch, 0);
        }

        public TerminalNode EndWhile() {
            return getToken(PhpParser.EndWhile, 0);
        }

        public TerminalNode Eval() {
            return getToken(PhpParser.Eval, 0);
        }

        public TerminalNode Exit() {
            return getToken(PhpParser.Exit, 0);
        }

        public TerminalNode Extends() {
            return getToken(PhpParser.Extends, 0);
        }

        public TerminalNode Final() {
            return getToken(PhpParser.Final, 0);
        }

        public TerminalNode Finally() {
            return getToken(PhpParser.Finally, 0);
        }

        public TerminalNode FloatCast() {
            return getToken(PhpParser.FloatCast, 0);
        }

        public TerminalNode For() {
            return getToken(PhpParser.For, 0);
        }

        public TerminalNode Foreach() {
            return getToken(PhpParser.Foreach, 0);
        }

        public TerminalNode Function_() {
            return getToken(PhpParser.Function_, 0);
        }

        public TerminalNode Global() {
            return getToken(PhpParser.Global, 0);
        }

        public TerminalNode Goto() {
            return getToken(PhpParser.Goto, 0);
        }

        public TerminalNode If() {
            return getToken(PhpParser.If, 0);
        }

        public TerminalNode Implements() {
            return getToken(PhpParser.Implements, 0);
        }

        public TerminalNode Import() {
            return getToken(PhpParser.Import, 0);
        }

        public TerminalNode Include() {
            return getToken(PhpParser.Include, 0);
        }

        public TerminalNode IncludeOnce() {
            return getToken(PhpParser.IncludeOnce, 0);
        }

        public TerminalNode InstanceOf() {
            return getToken(PhpParser.InstanceOf, 0);
        }

        public TerminalNode InsteadOf() {
            return getToken(PhpParser.InsteadOf, 0);
        }

        public TerminalNode Int16Cast() {
            return getToken(PhpParser.Int16Cast, 0);
        }

        public TerminalNode Int64Type() {
            return getToken(PhpParser.Int64Type, 0);
        }

        public TerminalNode Int8Cast() {
            return getToken(PhpParser.Int8Cast, 0);
        }

        public TerminalNode Interface() {
            return getToken(PhpParser.Interface, 0);
        }

        public TerminalNode IntType() {
            return getToken(PhpParser.IntType, 0);
        }

        public TerminalNode IsSet() {
            return getToken(PhpParser.IsSet, 0);
        }

        public TerminalNode List() {
            return getToken(PhpParser.List, 0);
        }

        public TerminalNode LogicalAnd() {
            return getToken(PhpParser.LogicalAnd, 0);
        }

        public TerminalNode LogicalOr() {
            return getToken(PhpParser.LogicalOr, 0);
        }

        public TerminalNode LogicalXor() {
            return getToken(PhpParser.LogicalXor, 0);
        }

        public TerminalNode Namespace() {
            return getToken(PhpParser.Namespace, 0);
        }

        public TerminalNode New() {
            return getToken(PhpParser.New, 0);
        }

        public TerminalNode Null() {
            return getToken(PhpParser.Null, 0);
        }

        public TerminalNode ObjectType() {
            return getToken(PhpParser.ObjectType, 0);
        }

        public TerminalNode Parent_() {
            return getToken(PhpParser.Parent_, 0);
        }

        public TerminalNode Partial() {
            return getToken(PhpParser.Partial, 0);
        }

        public TerminalNode Print() {
            return getToken(PhpParser.Print, 0);
        }

        public TerminalNode Private() {
            return getToken(PhpParser.Private, 0);
        }

        public TerminalNode Protected() {
            return getToken(PhpParser.Protected, 0);
        }

        public TerminalNode Public() {
            return getToken(PhpParser.Public, 0);
        }

        public TerminalNode Require() {
            return getToken(PhpParser.Require, 0);
        }

        public TerminalNode RequireOnce() {
            return getToken(PhpParser.RequireOnce, 0);
        }

        public TerminalNode Resource() {
            return getToken(PhpParser.Resource, 0);
        }

        public TerminalNode Return() {
            return getToken(PhpParser.Return, 0);
        }

        public TerminalNode Static() {
            return getToken(PhpParser.Static, 0);
        }

        public TerminalNode StringType() {
            return getToken(PhpParser.StringType, 0);
        }

        public TerminalNode Switch() {
            return getToken(PhpParser.Switch, 0);
        }

        public TerminalNode Throw() {
            return getToken(PhpParser.Throw, 0);
        }

        public TerminalNode Trait() {
            return getToken(PhpParser.Trait, 0);
        }

        public TerminalNode Try() {
            return getToken(PhpParser.Try, 0);
        }

        public TerminalNode Typeof() {
            return getToken(PhpParser.Typeof, 0);
        }

        public TerminalNode UintCast() {
            return getToken(PhpParser.UintCast, 0);
        }

        public TerminalNode UnicodeCast() {
            return getToken(PhpParser.UnicodeCast, 0);
        }

        public TerminalNode Unset() {
            return getToken(PhpParser.Unset, 0);
        }

        public TerminalNode Use() {
            return getToken(PhpParser.Use, 0);
        }

        public TerminalNode Var() {
            return getToken(PhpParser.Var, 0);
        }

        public TerminalNode While() {
            return getToken(PhpParser.While, 0);
        }

        public TerminalNode Yield() {
            return getToken(PhpParser.Yield, 0);
        }

        public TerminalNode From() {
            return getToken(PhpParser.From, 0);
        }

        public TerminalNode Get() {
            return getToken(PhpParser.Get, 0);
        }

        public TerminalNode Set() {
            return getToken(PhpParser.Set, 0);
        }

        public TerminalNode Call() {
            return getToken(PhpParser.Call, 0);
        }

        public TerminalNode CallStatic() {
            return getToken(PhpParser.CallStatic, 0);
        }

        public TerminalNode Constructor() {
            return getToken(PhpParser.Constructor, 0);
        }

        public TerminalNode Destruct() {
            return getToken(PhpParser.Destruct, 0);
        }

        public TerminalNode Wakeup() {
            return getToken(PhpParser.Wakeup, 0);
        }

        public TerminalNode Sleep() {
            return getToken(PhpParser.Sleep, 0);
        }

        public TerminalNode Autoload() {
            return getToken(PhpParser.Autoload, 0);
        }

        public TerminalNode IsSet__() {
            return getToken(PhpParser.IsSet__, 0);
        }

        public TerminalNode Unset__() {
            return getToken(PhpParser.Unset__, 0);
        }

        public TerminalNode ToString__() {
            return getToken(PhpParser.ToString__, 0);
        }

        public TerminalNode Invoke() {
            return getToken(PhpParser.Invoke, 0);
        }

        public TerminalNode SetState() {
            return getToken(PhpParser.SetState, 0);
        }

        public TerminalNode Clone__() {
            return getToken(PhpParser.Clone__, 0);
        }

        public TerminalNode DebugInfo() {
            return getToken(PhpParser.DebugInfo, 0);
        }

        public TerminalNode Namespace__() {
            return getToken(PhpParser.Namespace__, 0);
        }

        public TerminalNode Class__() {
            return getToken(PhpParser.Class__, 0);
        }

        public TerminalNode Traic__() {
            return getToken(PhpParser.Traic__, 0);
        }

        public TerminalNode Function__() {
            return getToken(PhpParser.Function__, 0);
        }

        public TerminalNode Method__() {
            return getToken(PhpParser.Method__, 0);
        }

        public TerminalNode Line__() {
            return getToken(PhpParser.Line__, 0);
        }

        public TerminalNode File__() {
            return getToken(PhpParser.File__, 0);
        }

        public TerminalNode Dir__() {
            return getToken(PhpParser.Dir__, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_identifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterIdentifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitIdentifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitIdentifier(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MemberModifierContext extends ParserRuleContext {
        public MemberModifierContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Public() {
            return getToken(PhpParser.Public, 0);
        }

        public TerminalNode Protected() {
            return getToken(PhpParser.Protected, 0);
        }

        public TerminalNode Private() {
            return getToken(PhpParser.Private, 0);
        }

        public TerminalNode Static() {
            return getToken(PhpParser.Static, 0);
        }

        public TerminalNode Abstract() {
            return getToken(PhpParser.Abstract, 0);
        }

        public TerminalNode Final() {
            return getToken(PhpParser.Final, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_memberModifier;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMemberModifier(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMemberModifier(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMemberModifier(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MagicConstantContext extends ParserRuleContext {
        public MagicConstantContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Namespace__() {
            return getToken(PhpParser.Namespace__, 0);
        }

        public TerminalNode Class__() {
            return getToken(PhpParser.Class__, 0);
        }

        public TerminalNode Traic__() {
            return getToken(PhpParser.Traic__, 0);
        }

        public TerminalNode Function__() {
            return getToken(PhpParser.Function__, 0);
        }

        public TerminalNode Method__() {
            return getToken(PhpParser.Method__, 0);
        }

        public TerminalNode Line__() {
            return getToken(PhpParser.Line__, 0);
        }

        public TerminalNode File__() {
            return getToken(PhpParser.File__, 0);
        }

        public TerminalNode Dir__() {
            return getToken(PhpParser.Dir__, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_magicConstant;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMagicConstant(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMagicConstant(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMagicConstant(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class MagicMethodContext extends ParserRuleContext {
        public MagicMethodContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode Get() {
            return getToken(PhpParser.Get, 0);
        }

        public TerminalNode Set() {
            return getToken(PhpParser.Set, 0);
        }

        public TerminalNode Call() {
            return getToken(PhpParser.Call, 0);
        }

        public TerminalNode CallStatic() {
            return getToken(PhpParser.CallStatic, 0);
        }

        public TerminalNode Constructor() {
            return getToken(PhpParser.Constructor, 0);
        }

        public TerminalNode Destruct() {
            return getToken(PhpParser.Destruct, 0);
        }

        public TerminalNode Wakeup() {
            return getToken(PhpParser.Wakeup, 0);
        }

        public TerminalNode Sleep() {
            return getToken(PhpParser.Sleep, 0);
        }

        public TerminalNode Autoload() {
            return getToken(PhpParser.Autoload, 0);
        }

        public TerminalNode IsSet__() {
            return getToken(PhpParser.IsSet__, 0);
        }

        public TerminalNode Unset__() {
            return getToken(PhpParser.Unset__, 0);
        }

        public TerminalNode ToString__() {
            return getToken(PhpParser.ToString__, 0);
        }

        public TerminalNode Invoke() {
            return getToken(PhpParser.Invoke, 0);
        }

        public TerminalNode SetState() {
            return getToken(PhpParser.SetState, 0);
        }

        public TerminalNode Clone__() {
            return getToken(PhpParser.Clone__, 0);
        }

        public TerminalNode DebugInfo() {
            return getToken(PhpParser.DebugInfo, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_magicMethod;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterMagicMethod(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitMagicMethod(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitMagicMethod(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrimitiveTypeContext extends ParserRuleContext {
        public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BoolType() {
            return getToken(PhpParser.BoolType, 0);
        }

        public TerminalNode IntType() {
            return getToken(PhpParser.IntType, 0);
        }

        public TerminalNode Int64Type() {
            return getToken(PhpParser.Int64Type, 0);
        }

        public TerminalNode DoubleType() {
            return getToken(PhpParser.DoubleType, 0);
        }

        public TerminalNode StringType() {
            return getToken(PhpParser.StringType, 0);
        }

        public TerminalNode Resource() {
            return getToken(PhpParser.Resource, 0);
        }

        public TerminalNode ObjectType() {
            return getToken(PhpParser.ObjectType, 0);
        }

        public TerminalNode Array() {
            return getToken(PhpParser.Array, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_primitiveType;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterPrimitiveType(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitPrimitiveType(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitPrimitiveType(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CastOperationContext extends ParserRuleContext {
        public CastOperationContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        public TerminalNode BoolType() {
            return getToken(PhpParser.BoolType, 0);
        }

        public TerminalNode Int8Cast() {
            return getToken(PhpParser.Int8Cast, 0);
        }

        public TerminalNode Int16Cast() {
            return getToken(PhpParser.Int16Cast, 0);
        }

        public TerminalNode IntType() {
            return getToken(PhpParser.IntType, 0);
        }

        public TerminalNode Int64Type() {
            return getToken(PhpParser.Int64Type, 0);
        }

        public TerminalNode UintCast() {
            return getToken(PhpParser.UintCast, 0);
        }

        public TerminalNode DoubleCast() {
            return getToken(PhpParser.DoubleCast, 0);
        }

        public TerminalNode DoubleType() {
            return getToken(PhpParser.DoubleType, 0);
        }

        public TerminalNode FloatCast() {
            return getToken(PhpParser.FloatCast, 0);
        }

        public TerminalNode StringType() {
            return getToken(PhpParser.StringType, 0);
        }

        public TerminalNode BinaryCast() {
            return getToken(PhpParser.BinaryCast, 0);
        }

        public TerminalNode UnicodeCast() {
            return getToken(PhpParser.UnicodeCast, 0);
        }

        public TerminalNode Array() {
            return getToken(PhpParser.Array, 0);
        }

        public TerminalNode ObjectType() {
            return getToken(PhpParser.ObjectType, 0);
        }

        public TerminalNode Resource() {
            return getToken(PhpParser.Resource, 0);
        }

        public TerminalNode Unset() {
            return getToken(PhpParser.Unset, 0);
        }

        @Override
        public int getRuleIndex() {
            return RULE_castOperation;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).enterCastOperation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof PhpParserListener)
                ((PhpParserListener) listener).exitCastOperation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof PhpParserVisitor)
                return ((PhpParserVisitor<? extends T>) visitor).visitCastOperation(this);
            else return visitor.visitChildren(this);
        }
    }
}