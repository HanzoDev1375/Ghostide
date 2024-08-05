// Generated from /storage/emulated/0/cdm/grammars-v4/php/PhpParser.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.php;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PhpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		SeaWhitespace=1, HtmlText=2, XmlStart=3, PHPStart=4, HtmlScriptOpen=5, 
		HtmlStyleOpen=6, HtmlComment=7, HtmlDtd=8, HtmlOpen=9, Shebang=10, Error=11, 
		XmlText=12, XmlClose=13, PHPStartInside=14, HtmlClose=15, HtmlSlashClose=16, 
		HtmlSlash=17, HtmlEquals=18, HtmlStartQuoteString=19, HtmlStartDoubleQuoteString=20, 
		HtmlHex=21, HtmlDecimal=22, HtmlSpace=23, HtmlName=24, ErrorInside=25, 
		PHPStartInsideQuoteString=26, HtmlEndQuoteString=27, HtmlQuoteString=28, 
		ErrorHtmlQuote=29, PHPStartDoubleQuoteString=30, HtmlEndDoubleQuoteString=31, 
		HtmlDoubleQuoteString=32, ErrorHtmlDoubleQuote=33, ScriptText=34, HtmlScriptClose=35, 
		PHPStartInsideScript=36, StyleBody=37, PHPEnd=38, Whitespace=39, MultiLineComment=40, 
		SingleLineComment=41, ShellStyleComment=42, AttributeStart=43, Abstract=44, 
		Array=45, As=46, BinaryCast=47, BoolType=48, BooleanConstant=49, Break=50, 
		Callable=51, Case=52, Catch=53, Class=54, Clone=55, Const=56, Continue=57, 
		Declare=58, Default=59, Do=60, DoubleCast=61, DoubleType=62, Echo=63, 
		Else=64, ElseIf=65, Empty=66, Enum_=67, EndDeclare=68, EndFor=69, EndForeach=70, 
		EndIf=71, EndSwitch=72, EndWhile=73, Eval=74, Exit=75, Extends=76, Final=77, 
		Finally=78, FloatCast=79, For=80, Foreach=81, Function_=82, Global=83, 
		Goto=84, If=85, Implements=86, Import=87, Include=88, IncludeOnce=89, 
		InstanceOf=90, InsteadOf=91, Int8Cast=92, Int16Cast=93, Int64Type=94, 
		IntType=95, Interface=96, IsSet=97, List=98, LogicalAnd=99, LogicalOr=100, 
		LogicalXor=101, Match_=102, Namespace=103, New=104, Null=105, ObjectType=106, 
		Parent_=107, Partial=108, Print=109, Private=110, Protected=111, Public=112, 
		Readonly=113, Require=114, RequireOnce=115, Resource=116, Return=117, 
		Static=118, StringType=119, Switch=120, Throw=121, Trait=122, Try=123, 
		Typeof=124, UintCast=125, UnicodeCast=126, Unset=127, Use=128, Var=129, 
		While=130, Yield=131, From=132, LambdaFn=133, Ticks=134, Encoding=135, 
		StrictTypes=136, Get=137, Set=138, Call=139, CallStatic=140, Constructor=141, 
		Destruct=142, Wakeup=143, Sleep=144, Autoload=145, IsSet__=146, Unset__=147, 
		ToString__=148, Invoke=149, SetState=150, Clone__=151, DebugInfo=152, 
		Namespace__=153, Class__=154, Traic__=155, Function__=156, Method__=157, 
		Line__=158, File__=159, Dir__=160, Spaceship=161, Lgeneric=162, Rgeneric=163, 
		DoubleArrow=164, Inc=165, Dec=166, IsIdentical=167, IsNoidentical=168, 
		IsEqual=169, IsNotEq=170, IsSmallerOrEqual=171, IsGreaterOrEqual=172, 
		PlusEqual=173, MinusEqual=174, MulEqual=175, Pow=176, PowEqual=177, DivEqual=178, 
		Concaequal=179, ModEqual=180, ShiftLeftEqual=181, ShiftRightEqual=182, 
		AndEqual=183, OrEqual=184, XorEqual=185, BooleanOr=186, BooleanAnd=187, 
		NullCoalescing=188, NullCoalescingEqual=189, ShiftLeft=190, ShiftRight=191, 
		DoubleColon=192, ObjectOperator=193, NamespaceSeparator=194, Ellipsis=195, 
		Less=196, Greater=197, Ampersand=198, Pipe=199, Bang=200, Caret=201, Plus=202, 
		Minus=203, Asterisk=204, Percent=205, Divide=206, Tilde=207, SuppressWarnings=208, 
		Dollar=209, Dot=210, QuestionMark=211, OpenRoundBracket=212, CloseRoundBracket=213, 
		OpenSquareBracket=214, CloseSquareBracket=215, OpenCurlyBracket=216, CloseCurlyBracket=217, 
		Comma=218, Colon=219, SemiColon=220, Eq=221, Quote=222, BackQuote=223, 
		VarName=224, Label=225, Octal=226, Decimal=227, Real=228, Hex=229, Binary=230, 
		BackQuoteString=231, SingleQuoteString=232, DoubleQuote=233, StartNowDoc=234, 
		StartHereDoc=235, ErrorPhp=236, CurlyDollar=237, UnicodeEscape=238, StringPart=239, 
		Comment=240, PHPEndSingleLineComment=241, CommentEnd=242, HereDocText=243, 
		XmlText2=244;
	public static final int
		RULE_htmlDocument = 0, RULE_inlineHtml = 1, RULE_htmlElement = 2, RULE_scriptText = 3, 
		RULE_phpBlock = 4, RULE_importStatement = 5, RULE_topStatement = 6, RULE_useDeclaration = 7, 
		RULE_useDeclarationContentList = 8, RULE_useDeclarationContent = 9, RULE_namespaceDeclaration = 10, 
		RULE_namespaceStatement = 11, RULE_functionDeclaration = 12, RULE_classDeclaration = 13, 
		RULE_classEntryType = 14, RULE_interfaceList = 15, RULE_typeParameterListInBrackets = 16, 
		RULE_typeParameterList = 17, RULE_typeParameterWithDefaultsList = 18, 
		RULE_typeParameterDecl = 19, RULE_typeParameterWithDefaultDecl = 20, RULE_genericDynamicArgs = 21, 
		RULE_attributes = 22, RULE_attributeGroup = 23, RULE_attribute = 24, RULE_innerStatementList = 25, 
		RULE_innerStatement = 26, RULE_statement = 27, RULE_emptyStatement_ = 28, 
		RULE_blockStatement = 29, RULE_ifStatement = 30, RULE_elseIfStatement = 31, 
		RULE_elseIfColonStatement = 32, RULE_elseStatement = 33, RULE_elseColonStatement = 34, 
		RULE_whileStatement = 35, RULE_doWhileStatement = 36, RULE_forStatement = 37, 
		RULE_forInit = 38, RULE_forUpdate = 39, RULE_switchStatement = 40, RULE_switchBlock = 41, 
		RULE_breakStatement = 42, RULE_continueStatement = 43, RULE_returnStatement = 44, 
		RULE_expressionStatement = 45, RULE_unsetStatement = 46, RULE_foreachStatement = 47, 
		RULE_tryCatchFinally = 48, RULE_catchClause = 49, RULE_finallyStatement = 50, 
		RULE_throwStatement = 51, RULE_gotoStatement = 52, RULE_declareStatement = 53, 
		RULE_inlineHtmlStatement = 54, RULE_declareList = 55, RULE_directive = 56, 
		RULE_formalParameterList = 57, RULE_formalParameter = 58, RULE_typeHint = 59, 
		RULE_globalStatement = 60, RULE_globalVar = 61, RULE_echoStatement = 62, 
		RULE_staticVariableStatement = 63, RULE_classStatement = 64, RULE_traitAdaptations = 65, 
		RULE_traitAdaptationStatement = 66, RULE_traitPrecedence = 67, RULE_traitAlias = 68, 
		RULE_traitMethodReference = 69, RULE_baseCtorCall = 70, RULE_returnTypeDecl = 71, 
		RULE_methodBody = 72, RULE_propertyModifiers = 73, RULE_memberModifiers = 74, 
		RULE_variableInitializer = 75, RULE_identifierInitializer = 76, RULE_globalConstantDeclaration = 77, 
		RULE_enumDeclaration = 78, RULE_enumItem = 79, RULE_expressionList = 80, 
		RULE_parentheses = 81, RULE_expression = 82, RULE_assignable = 83, RULE_arrayCreation = 84, 
		RULE_arrayDestructuring = 85, RULE_indexedDestructItem = 86, RULE_keyedDestructItem = 87, 
		RULE_lambdaFunctionExpr = 88, RULE_matchExpr = 89, RULE_matchItem = 90, 
		RULE_newExpr = 91, RULE_assignmentOperator = 92, RULE_yieldExpression = 93, 
		RULE_arrayItemList = 94, RULE_arrayItem = 95, RULE_lambdaFunctionUseVars = 96, 
		RULE_lambdaFunctionUseVar = 97, RULE_qualifiedStaticTypeRef = 98, RULE_typeRef = 99, 
		RULE_anonymousClass = 100, RULE_indirectTypeRef = 101, RULE_qualifiedNamespaceName = 102, 
		RULE_namespaceNameList = 103, RULE_namespaceNameTail = 104, RULE_qualifiedNamespaceNameList = 105, 
		RULE_arguments = 106, RULE_actualArgument = 107, RULE_argumentName = 108, 
		RULE_constantInitializer = 109, RULE_constant = 110, RULE_literalConstant = 111, 
		RULE_numericConstant = 112, RULE_classConstant = 113, RULE_stringConstant = 114, 
		RULE_string = 115, RULE_interpolatedStringPart = 116, RULE_chainList = 117, 
		RULE_chain = 118, RULE_chainOrigin = 119, RULE_memberAccess = 120, RULE_functionCall = 121, 
		RULE_functionCallName = 122, RULE_actualArguments = 123, RULE_chainBase = 124, 
		RULE_keyedFieldName = 125, RULE_keyedSimpleFieldName = 126, RULE_keyedVariable = 127, 
		RULE_squareCurlyExpression = 128, RULE_assignmentList = 129, RULE_assignmentListElement = 130, 
		RULE_modifier = 131, RULE_identifier = 132, RULE_memberModifier = 133, 
		RULE_magicConstant = 134, RULE_magicMethod = 135, RULE_primitiveType = 136, 
		RULE_castOperation = 137;
	private static String[] makeRuleNames() {
		return new String[] {
			"htmlDocument", "inlineHtml", "htmlElement", "scriptText", "phpBlock", 
			"importStatement", "topStatement", "useDeclaration", "useDeclarationContentList", 
			"useDeclarationContent", "namespaceDeclaration", "namespaceStatement", 
			"functionDeclaration", "classDeclaration", "classEntryType", "interfaceList", 
			"typeParameterListInBrackets", "typeParameterList", "typeParameterWithDefaultsList", 
			"typeParameterDecl", "typeParameterWithDefaultDecl", "genericDynamicArgs", 
			"attributes", "attributeGroup", "attribute", "innerStatementList", "innerStatement", 
			"statement", "emptyStatement_", "blockStatement", "ifStatement", "elseIfStatement", 
			"elseIfColonStatement", "elseStatement", "elseColonStatement", "whileStatement", 
			"doWhileStatement", "forStatement", "forInit", "forUpdate", "switchStatement", 
			"switchBlock", "breakStatement", "continueStatement", "returnStatement", 
			"expressionStatement", "unsetStatement", "foreachStatement", "tryCatchFinally", 
			"catchClause", "finallyStatement", "throwStatement", "gotoStatement", 
			"declareStatement", "inlineHtmlStatement", "declareList", "directive", 
			"formalParameterList", "formalParameter", "typeHint", "globalStatement", 
			"globalVar", "echoStatement", "staticVariableStatement", "classStatement", 
			"traitAdaptations", "traitAdaptationStatement", "traitPrecedence", "traitAlias", 
			"traitMethodReference", "baseCtorCall", "returnTypeDecl", "methodBody", 
			"propertyModifiers", "memberModifiers", "variableInitializer", "identifierInitializer", 
			"globalConstantDeclaration", "enumDeclaration", "enumItem", "expressionList", 
			"parentheses", "expression", "assignable", "arrayCreation", "arrayDestructuring", 
			"indexedDestructItem", "keyedDestructItem", "lambdaFunctionExpr", "matchExpr", 
			"matchItem", "newExpr", "assignmentOperator", "yieldExpression", "arrayItemList", 
			"arrayItem", "lambdaFunctionUseVars", "lambdaFunctionUseVar", "qualifiedStaticTypeRef", 
			"typeRef", "anonymousClass", "indirectTypeRef", "qualifiedNamespaceName", 
			"namespaceNameList", "namespaceNameTail", "qualifiedNamespaceNameList", 
			"arguments", "actualArgument", "argumentName", "constantInitializer", 
			"constant", "literalConstant", "numericConstant", "classConstant", "stringConstant", 
			"string", "interpolatedStringPart", "chainList", "chain", "chainOrigin", 
			"memberAccess", "functionCall", "functionCallName", "actualArguments", 
			"chainBase", "keyedFieldName", "keyedSimpleFieldName", "keyedVariable", 
			"squareCurlyExpression", "assignmentList", "assignmentListElement", "modifier", 
			"identifier", "memberModifier", "magicConstant", "magicMethod", "primitiveType", 
			"castOperation"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'<?xml'", null, null, null, null, null, null, null, 
			null, null, "'?>'", null, null, "'/>'", null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, "'#['", "'abstract'", 
			"'array'", "'as'", "'binary'", null, null, "'break'", "'callable'", "'case'", 
			"'catch'", "'class'", "'clone'", "'const'", "'continue'", "'declare'", 
			"'default'", "'do'", "'real'", "'double'", "'echo'", "'else'", "'elseif'", 
			"'empty'", "'enum'", "'enddeclare'", "'endfor'", "'endforeach'", "'endif'", 
			"'endswitch'", "'endwhile'", "'eval'", "'die'", "'extends'", "'final'", 
			"'finally'", "'float'", "'for'", "'foreach'", "'function'", "'global'", 
			"'goto'", "'if'", "'implements'", "'import'", "'include'", "'include_once'", 
			"'instanceof'", "'insteadof'", "'int8'", "'int16'", "'int64'", null, 
			"'interface'", "'isset'", "'list'", "'and'", "'or'", "'xor'", "'match'", 
			"'namespace'", "'new'", "'null'", "'object'", "'parent'", "'partial'", 
			"'print'", "'private'", "'protected'", "'public'", "'readonly'", "'require'", 
			"'require_once'", "'resource'", "'return'", "'static'", "'string'", "'switch'", 
			"'throw'", "'trait'", "'try'", "'clrtypeof'", null, "'unicode'", "'unset'", 
			"'use'", "'var'", "'while'", "'yield'", "'from'", "'fn'", "'ticks'", 
			"'encoding'", "'strict_types'", "'__get'", "'__set'", "'__call'", "'__callstatic'", 
			"'__construct'", "'__destruct'", "'__wakeup'", "'__sleep'", "'__autoload'", 
			"'__isset'", "'__unset'", "'__tostring'", "'__invoke'", "'__set_state'", 
			"'__clone'", "'__debuginfo'", "'__namespace__'", "'__class__'", "'__trait__'", 
			"'__function__'", "'__method__'", "'__line__'", "'__file__'", "'__dir__'", 
			"'<=>'", "'<:'", "':>'", "'=>'", "'++'", "'--'", "'==='", "'!=='", "'=='", 
			null, "'<='", "'>='", "'+='", "'-='", "'*='", "'**'", "'**='", "'/='", 
			"'.='", "'%='", "'<<='", "'>>='", "'&='", "'|='", "'^='", "'||'", "'&&'", 
			"'??'", "'??='", "'<<'", "'>>'", "'::'", "'->'", "'\\'", "'...'", null, 
			null, "'&'", "'|'", "'!'", "'^'", "'+'", "'-'", "'*'", "'%'", null, "'~'", 
			"'@'", null, "'.'", null, "'('", "')'", "'['", "']'", null, "'}'", "','", 
			"':'", "';'", null, "'''", "'`'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "SeaWhitespace", "HtmlText", "XmlStart", "PHPStart", "HtmlScriptOpen", 
			"HtmlStyleOpen", "HtmlComment", "HtmlDtd", "HtmlOpen", "Shebang", "Error", 
			"XmlText", "XmlClose", "PHPStartInside", "HtmlClose", "HtmlSlashClose", 
			"HtmlSlash", "HtmlEquals", "HtmlStartQuoteString", "HtmlStartDoubleQuoteString", 
			"HtmlHex", "HtmlDecimal", "HtmlSpace", "HtmlName", "ErrorInside", "PHPStartInsideQuoteString", 
			"HtmlEndQuoteString", "HtmlQuoteString", "ErrorHtmlQuote", "PHPStartDoubleQuoteString", 
			"HtmlEndDoubleQuoteString", "HtmlDoubleQuoteString", "ErrorHtmlDoubleQuote", 
			"ScriptText", "HtmlScriptClose", "PHPStartInsideScript", "StyleBody", 
			"PHPEnd", "Whitespace", "MultiLineComment", "SingleLineComment", "ShellStyleComment", 
			"AttributeStart", "Abstract", "Array", "As", "BinaryCast", "BoolType", 
			"BooleanConstant", "Break", "Callable", "Case", "Catch", "Class", "Clone", 
			"Const", "Continue", "Declare", "Default", "Do", "DoubleCast", "DoubleType", 
			"Echo", "Else", "ElseIf", "Empty", "Enum_", "EndDeclare", "EndFor", "EndForeach", 
			"EndIf", "EndSwitch", "EndWhile", "Eval", "Exit", "Extends", "Final", 
			"Finally", "FloatCast", "For", "Foreach", "Function_", "Global", "Goto", 
			"If", "Implements", "Import", "Include", "IncludeOnce", "InstanceOf", 
			"InsteadOf", "Int8Cast", "Int16Cast", "Int64Type", "IntType", "Interface", 
			"IsSet", "List", "LogicalAnd", "LogicalOr", "LogicalXor", "Match_", "Namespace", 
			"New", "Null", "ObjectType", "Parent_", "Partial", "Print", "Private", 
			"Protected", "Public", "Readonly", "Require", "RequireOnce", "Resource", 
			"Return", "Static", "StringType", "Switch", "Throw", "Trait", "Try", 
			"Typeof", "UintCast", "UnicodeCast", "Unset", "Use", "Var", "While", 
			"Yield", "From", "LambdaFn", "Ticks", "Encoding", "StrictTypes", "Get", 
			"Set", "Call", "CallStatic", "Constructor", "Destruct", "Wakeup", "Sleep", 
			"Autoload", "IsSet__", "Unset__", "ToString__", "Invoke", "SetState", 
			"Clone__", "DebugInfo", "Namespace__", "Class__", "Traic__", "Function__", 
			"Method__", "Line__", "File__", "Dir__", "Spaceship", "Lgeneric", "Rgeneric", 
			"DoubleArrow", "Inc", "Dec", "IsIdentical", "IsNoidentical", "IsEqual", 
			"IsNotEq", "IsSmallerOrEqual", "IsGreaterOrEqual", "PlusEqual", "MinusEqual", 
			"MulEqual", "Pow", "PowEqual", "DivEqual", "Concaequal", "ModEqual", 
			"ShiftLeftEqual", "ShiftRightEqual", "AndEqual", "OrEqual", "XorEqual", 
			"BooleanOr", "BooleanAnd", "NullCoalescing", "NullCoalescingEqual", "ShiftLeft", 
			"ShiftRight", "DoubleColon", "ObjectOperator", "NamespaceSeparator", 
			"Ellipsis", "Less", "Greater", "Ampersand", "Pipe", "Bang", "Caret", 
			"Plus", "Minus", "Asterisk", "Percent", "Divide", "Tilde", "SuppressWarnings", 
			"Dollar", "Dot", "QuestionMark", "OpenRoundBracket", "CloseRoundBracket", 
			"OpenSquareBracket", "CloseSquareBracket", "OpenCurlyBracket", "CloseCurlyBracket", 
			"Comma", "Colon", "SemiColon", "Eq", "Quote", "BackQuote", "VarName", 
			"Label", "Octal", "Decimal", "Real", "Hex", "Binary", "BackQuoteString", 
			"SingleQuoteString", "DoubleQuote", "StartNowDoc", "StartHereDoc", "ErrorPhp", 
			"CurlyDollar", "UnicodeEscape", "StringPart", "Comment", "PHPEndSingleLineComment", 
			"CommentEnd", "HereDocText", "XmlText2"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
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
	public String getGrammarFileName() { return "PhpParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PhpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlDocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PhpParser.EOF, 0); }
		public TerminalNode Shebang() { return getToken(PhpParser.Shebang, 0); }
		public List<InlineHtmlContext> inlineHtml() {
			return getRuleContexts(InlineHtmlContext.class);
		}
		public InlineHtmlContext inlineHtml(int i) {
			return getRuleContext(InlineHtmlContext.class,i);
		}
		public List<PhpBlockContext> phpBlock() {
			return getRuleContexts(PhpBlockContext.class);
		}
		public PhpBlockContext phpBlock(int i) {
			return getRuleContext(PhpBlockContext.class,i);
		}
		public HtmlDocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlDocument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterHtmlDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitHtmlDocument(this);
		}
	}

	public final HtmlDocumentContext htmlDocument() throws RecognitionException {
		HtmlDocumentContext _localctx = new HtmlDocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_htmlDocument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Shebang) {
				{
				setState(276);
				match(Shebang);
				}
			}

			setState(283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8600244223124L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 420906795007L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4397045441345L) != 0)) {
				{
				setState(281);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
				case 1:
					{
					setState(279);
					inlineHtml();
					}
					break;
				case 2:
					{
					setState(280);
					phpBlock();
					}
					break;
				}
				}
				setState(285);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(286);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineHtmlContext extends ParserRuleContext {
		public List<HtmlElementContext> htmlElement() {
			return getRuleContexts(HtmlElementContext.class);
		}
		public HtmlElementContext htmlElement(int i) {
			return getRuleContext(HtmlElementContext.class,i);
		}
		public ScriptTextContext scriptText() {
			return getRuleContext(ScriptTextContext.class,0);
		}
		public InlineHtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineHtml; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInlineHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInlineHtml(this);
		}
	}

	public final InlineHtmlContext inlineHtml() throws RecognitionException {
		InlineHtmlContext _localctx = new InlineHtmlContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_inlineHtml);
		try {
			int _alt;
			setState(294);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
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
			case HtmlScriptClose:
			case StyleBody:
				enterOuterAlt(_localctx, 1);
				{
				setState(289); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(288);
						htmlElement();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(291); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case ScriptText:
				enterOuterAlt(_localctx, 2);
				{
				setState(293);
				scriptText();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class HtmlElementContext extends ParserRuleContext {
		public TerminalNode HtmlDtd() { return getToken(PhpParser.HtmlDtd, 0); }
		public TerminalNode HtmlClose() { return getToken(PhpParser.HtmlClose, 0); }
		public TerminalNode HtmlStyleOpen() { return getToken(PhpParser.HtmlStyleOpen, 0); }
		public TerminalNode HtmlOpen() { return getToken(PhpParser.HtmlOpen, 0); }
		public TerminalNode HtmlName() { return getToken(PhpParser.HtmlName, 0); }
		public TerminalNode HtmlSlashClose() { return getToken(PhpParser.HtmlSlashClose, 0); }
		public TerminalNode HtmlSlash() { return getToken(PhpParser.HtmlSlash, 0); }
		public TerminalNode HtmlText() { return getToken(PhpParser.HtmlText, 0); }
		public TerminalNode HtmlEquals() { return getToken(PhpParser.HtmlEquals, 0); }
		public TerminalNode HtmlStartQuoteString() { return getToken(PhpParser.HtmlStartQuoteString, 0); }
		public TerminalNode HtmlEndQuoteString() { return getToken(PhpParser.HtmlEndQuoteString, 0); }
		public TerminalNode HtmlStartDoubleQuoteString() { return getToken(PhpParser.HtmlStartDoubleQuoteString, 0); }
		public TerminalNode HtmlEndDoubleQuoteString() { return getToken(PhpParser.HtmlEndDoubleQuoteString, 0); }
		public TerminalNode HtmlHex() { return getToken(PhpParser.HtmlHex, 0); }
		public TerminalNode HtmlDecimal() { return getToken(PhpParser.HtmlDecimal, 0); }
		public TerminalNode HtmlQuoteString() { return getToken(PhpParser.HtmlQuoteString, 0); }
		public TerminalNode HtmlDoubleQuoteString() { return getToken(PhpParser.HtmlDoubleQuoteString, 0); }
		public TerminalNode StyleBody() { return getToken(PhpParser.StyleBody, 0); }
		public TerminalNode HtmlScriptOpen() { return getToken(PhpParser.HtmlScriptOpen, 0); }
		public TerminalNode HtmlScriptClose() { return getToken(PhpParser.HtmlScriptClose, 0); }
		public TerminalNode XmlStart() { return getToken(PhpParser.XmlStart, 0); }
		public TerminalNode XmlClose() { return getToken(PhpParser.XmlClose, 0); }
		public List<TerminalNode> XmlText() { return getTokens(PhpParser.XmlText); }
		public TerminalNode XmlText(int i) {
			return getToken(PhpParser.XmlText, i);
		}
		public HtmlElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_htmlElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterHtmlElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitHtmlElement(this);
		}
	}

	public final HtmlElementContext htmlElement() throws RecognitionException {
		HtmlElementContext _localctx = new HtmlElementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_htmlElement);
		int _la;
		try {
			setState(324);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlDtd:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				match(HtmlDtd);
				}
				break;
			case HtmlClose:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				match(HtmlClose);
				}
				break;
			case HtmlStyleOpen:
				enterOuterAlt(_localctx, 3);
				{
				setState(298);
				match(HtmlStyleOpen);
				}
				break;
			case HtmlOpen:
				enterOuterAlt(_localctx, 4);
				{
				setState(299);
				match(HtmlOpen);
				}
				break;
			case HtmlName:
				enterOuterAlt(_localctx, 5);
				{
				setState(300);
				match(HtmlName);
				}
				break;
			case HtmlSlashClose:
				enterOuterAlt(_localctx, 6);
				{
				setState(301);
				match(HtmlSlashClose);
				}
				break;
			case HtmlSlash:
				enterOuterAlt(_localctx, 7);
				{
				setState(302);
				match(HtmlSlash);
				}
				break;
			case HtmlText:
				enterOuterAlt(_localctx, 8);
				{
				setState(303);
				match(HtmlText);
				}
				break;
			case HtmlEquals:
				enterOuterAlt(_localctx, 9);
				{
				setState(304);
				match(HtmlEquals);
				}
				break;
			case HtmlStartQuoteString:
				enterOuterAlt(_localctx, 10);
				{
				setState(305);
				match(HtmlStartQuoteString);
				}
				break;
			case HtmlEndQuoteString:
				enterOuterAlt(_localctx, 11);
				{
				setState(306);
				match(HtmlEndQuoteString);
				}
				break;
			case HtmlStartDoubleQuoteString:
				enterOuterAlt(_localctx, 12);
				{
				setState(307);
				match(HtmlStartDoubleQuoteString);
				}
				break;
			case HtmlEndDoubleQuoteString:
				enterOuterAlt(_localctx, 13);
				{
				setState(308);
				match(HtmlEndDoubleQuoteString);
				}
				break;
			case HtmlHex:
				enterOuterAlt(_localctx, 14);
				{
				setState(309);
				match(HtmlHex);
				}
				break;
			case HtmlDecimal:
				enterOuterAlt(_localctx, 15);
				{
				setState(310);
				match(HtmlDecimal);
				}
				break;
			case HtmlQuoteString:
				enterOuterAlt(_localctx, 16);
				{
				setState(311);
				match(HtmlQuoteString);
				}
				break;
			case HtmlDoubleQuoteString:
				enterOuterAlt(_localctx, 17);
				{
				setState(312);
				match(HtmlDoubleQuoteString);
				}
				break;
			case StyleBody:
				enterOuterAlt(_localctx, 18);
				{
				setState(313);
				match(StyleBody);
				}
				break;
			case HtmlScriptOpen:
				enterOuterAlt(_localctx, 19);
				{
				setState(314);
				match(HtmlScriptOpen);
				}
				break;
			case HtmlScriptClose:
				enterOuterAlt(_localctx, 20);
				{
				setState(315);
				match(HtmlScriptClose);
				}
				break;
			case XmlStart:
				enterOuterAlt(_localctx, 21);
				{
				setState(316);
				match(XmlStart);
				setState(320);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==XmlText) {
					{
					{
					setState(317);
					match(XmlText);
					}
					}
					setState(322);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(323);
				match(XmlClose);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ScriptTextContext extends ParserRuleContext {
		public List<TerminalNode> ScriptText() { return getTokens(PhpParser.ScriptText); }
		public TerminalNode ScriptText(int i) {
			return getToken(PhpParser.ScriptText, i);
		}
		public ScriptTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scriptText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterScriptText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitScriptText(this);
		}
	}

	public final ScriptTextContext scriptText() throws RecognitionException {
		ScriptTextContext _localctx = new ScriptTextContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_scriptText);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(327); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(326);
					match(ScriptText);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(329); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PhpBlockContext extends ParserRuleContext {
		public List<ImportStatementContext> importStatement() {
			return getRuleContexts(ImportStatementContext.class);
		}
		public ImportStatementContext importStatement(int i) {
			return getRuleContext(ImportStatementContext.class,i);
		}
		public List<TopStatementContext> topStatement() {
			return getRuleContexts(TopStatementContext.class);
		}
		public TopStatementContext topStatement(int i) {
			return getRuleContext(TopStatementContext.class,i);
		}
		public PhpBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_phpBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPhpBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPhpBlock(this);
		}
	}

	public final PhpBlockContext phpBlock() throws RecognitionException {
		PhpBlockContext _localctx = new PhpBlockContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_phpBlock);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(331);
					importStatement();
					}
					} 
				}
				setState(336);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			setState(338); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(337);
					topStatement();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(340); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportStatementContext extends ParserRuleContext {
		public TerminalNode Import() { return getToken(PhpParser.Import, 0); }
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public ImportStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterImportStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitImportStatement(this);
		}
	}

	public final ImportStatementContext importStatement() throws RecognitionException {
		ImportStatementContext _localctx = new ImportStatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_importStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(342);
			match(Import);
			setState(343);
			match(Namespace);
			setState(344);
			namespaceNameList();
			setState(345);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TopStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UseDeclarationContext useDeclaration() {
			return getRuleContext(UseDeclarationContext.class,0);
		}
		public NamespaceDeclarationContext namespaceDeclaration() {
			return getRuleContext(NamespaceDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public GlobalConstantDeclarationContext globalConstantDeclaration() {
			return getRuleContext(GlobalConstantDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public TopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_topStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTopStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTopStatement(this);
		}
	}

	public final TopStatementContext topStatement() throws RecognitionException {
		TopStatementContext _localctx = new TopStatementContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_topStatement);
		try {
			setState(354);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(347);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(348);
				useDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(349);
				namespaceDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(350);
				functionDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(351);
				classDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(352);
				globalConstantDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(353);
				enumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UseDeclarationContext extends ParserRuleContext {
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public UseDeclarationContentListContext useDeclarationContentList() {
			return getRuleContext(UseDeclarationContentListContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public TerminalNode Function_() { return getToken(PhpParser.Function_, 0); }
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public UseDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUseDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUseDeclaration(this);
		}
	}

	public final UseDeclarationContext useDeclaration() throws RecognitionException {
		UseDeclarationContext _localctx = new UseDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_useDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356);
			match(Use);
			setState(358);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				{
				setState(357);
				_la = _input.LA(1);
				if ( !(_la==Const || _la==Function_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			}
			setState(360);
			useDeclarationContentList();
			setState(361);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UseDeclarationContentListContext extends ParserRuleContext {
		public List<UseDeclarationContentContext> useDeclarationContent() {
			return getRuleContexts(UseDeclarationContentContext.class);
		}
		public UseDeclarationContentContext useDeclarationContent(int i) {
			return getRuleContext(UseDeclarationContentContext.class,i);
		}
		public List<TerminalNode> NamespaceSeparator() { return getTokens(PhpParser.NamespaceSeparator); }
		public TerminalNode NamespaceSeparator(int i) {
			return getToken(PhpParser.NamespaceSeparator, i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public UseDeclarationContentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDeclarationContentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUseDeclarationContentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUseDeclarationContentList(this);
		}
	}

	public final UseDeclarationContentListContext useDeclarationContentList() throws RecognitionException {
		UseDeclarationContentListContext _localctx = new UseDeclarationContentListContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_useDeclarationContentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NamespaceSeparator) {
				{
				setState(363);
				match(NamespaceSeparator);
				}
			}

			setState(366);
			useDeclarationContent();
			setState(374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(367);
				match(Comma);
				setState(369);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NamespaceSeparator) {
					{
					setState(368);
					match(NamespaceSeparator);
					}
				}

				setState(371);
				useDeclarationContent();
				}
				}
				setState(376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UseDeclarationContentContext extends ParserRuleContext {
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public UseDeclarationContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_useDeclarationContent; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUseDeclarationContent(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUseDeclarationContent(this);
		}
	}

	public final UseDeclarationContentContext useDeclarationContent() throws RecognitionException {
		UseDeclarationContentContext _localctx = new UseDeclarationContentContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_useDeclarationContent);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			namespaceNameList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamespaceDeclarationContext extends ParserRuleContext {
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public List<NamespaceStatementContext> namespaceStatement() {
			return getRuleContexts(NamespaceStatementContext.class);
		}
		public NamespaceStatementContext namespaceStatement(int i) {
			return getRuleContext(NamespaceStatementContext.class,i);
		}
		public NamespaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNamespaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNamespaceDeclaration(this);
		}
	}

	public final NamespaceDeclarationContext namespaceDeclaration() throws RecognitionException {
		NamespaceDeclarationContext _localctx = new NamespaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_namespaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(379);
			match(Namespace);
			setState(394);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(381);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 9007199254740991L) != 0) || _la==Label) {
					{
					setState(380);
					namespaceNameList();
					}
				}

				setState(383);
				match(OpenCurlyBracket);
				setState(387);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8600244223124L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -1L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 420906795007L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4397045441345L) != 0)) {
					{
					{
					setState(384);
					namespaceStatement();
					}
					}
					setState(389);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(390);
				match(CloseCurlyBracket);
				}
				break;
			case 2:
				{
				setState(391);
				namespaceNameList();
				setState(392);
				match(SemiColon);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamespaceStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public UseDeclarationContext useDeclaration() {
			return getRuleContext(UseDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public GlobalConstantDeclarationContext globalConstantDeclaration() {
			return getRuleContext(GlobalConstantDeclarationContext.class,0);
		}
		public NamespaceStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNamespaceStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNamespaceStatement(this);
		}
	}

	public final NamespaceStatementContext namespaceStatement() throws RecognitionException {
		NamespaceStatementContext _localctx = new NamespaceStatementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_namespaceStatement);
		try {
			setState(401);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(396);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(397);
				useDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(398);
				functionDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(399);
				classDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(400);
				globalConstantDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode Function_() { return getToken(PhpParser.Function_, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public TypeParameterListInBracketsContext typeParameterListInBrackets() {
			return getRuleContext(TypeParameterListInBracketsContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public TypeHintContext typeHint() {
			return getRuleContext(TypeHintContext.class,0);
		}
		public TerminalNode QuestionMark() { return getToken(PhpParser.QuestionMark, 0); }
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFunctionDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFunctionDeclaration(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(404);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AttributeStart) {
				{
				setState(403);
				attributes();
				}
			}

			setState(406);
			match(Function_);
			setState(408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(407);
				match(Ampersand);
				}
			}

			setState(410);
			identifier();
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Lgeneric) {
				{
				setState(411);
				typeParameterListInBrackets();
				}
			}

			setState(414);
			match(OpenRoundBracket);
			setState(415);
			formalParameterList();
			setState(416);
			match(CloseRoundBracket);
			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(417);
				match(Colon);
				setState(419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==QuestionMark) {
					{
					setState(418);
					match(QuestionMark);
					}
				}

				setState(421);
				typeHint(0);
				}
			}

			setState(424);
			blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public ClassEntryTypeContext classEntryType() {
			return getRuleContext(ClassEntryTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Interface() { return getToken(PhpParser.Interface, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode Private() { return getToken(PhpParser.Private, 0); }
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public TerminalNode Partial() { return getToken(PhpParser.Partial, 0); }
		public List<ClassStatementContext> classStatement() {
			return getRuleContexts(ClassStatementContext.class);
		}
		public ClassStatementContext classStatement(int i) {
			return getRuleContext(ClassStatementContext.class,i);
		}
		public TypeParameterListInBracketsContext typeParameterListInBrackets() {
			return getRuleContext(TypeParameterListInBracketsContext.class,0);
		}
		public TerminalNode Extends() { return getToken(PhpParser.Extends, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public TerminalNode Implements() { return getToken(PhpParser.Implements, 0); }
		public InterfaceListContext interfaceList() {
			return getRuleContext(InterfaceListContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(427);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AttributeStart) {
				{
				setState(426);
				attributes();
				}
			}

			setState(430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Private) {
				{
				setState(429);
				match(Private);
				}
			}

			setState(433);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract || _la==Final) {
				{
				setState(432);
				modifier();
				}
			}

			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Partial) {
				{
				setState(435);
				match(Partial);
				}
			}

			setState(460);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Trait:
				{
				setState(438);
				classEntryType();
				setState(439);
				identifier();
				setState(441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(440);
					typeParameterListInBrackets();
					}
				}

				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Extends) {
					{
					setState(443);
					match(Extends);
					setState(444);
					qualifiedStaticTypeRef();
					}
				}

				setState(449);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Implements) {
					{
					setState(447);
					match(Implements);
					setState(448);
					interfaceList();
					}
				}

				}
				break;
			case Interface:
				{
				setState(451);
				match(Interface);
				setState(452);
				identifier();
				setState(454);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(453);
					typeParameterListInBrackets();
					}
				}

				setState(458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Extends) {
					{
					setState(456);
					match(Extends);
					setState(457);
					interfaceList();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(462);
			match(OpenCurlyBracket);
			setState(466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72083982316994560L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 6757727313330209L) != 0)) {
				{
				{
				setState(463);
				classStatement();
				}
				}
				setState(468);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(469);
			match(CloseCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassEntryTypeContext extends ParserRuleContext {
		public TerminalNode Class() { return getToken(PhpParser.Class, 0); }
		public TerminalNode Trait() { return getToken(PhpParser.Trait, 0); }
		public ClassEntryTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classEntryType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassEntryType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassEntryType(this);
		}
	}

	public final ClassEntryTypeContext classEntryType() throws RecognitionException {
		ClassEntryTypeContext _localctx = new ClassEntryTypeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_classEntryType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(471);
			_la = _input.LA(1);
			if ( !(_la==Class || _la==Trait) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceListContext extends ParserRuleContext {
		public List<QualifiedStaticTypeRefContext> qualifiedStaticTypeRef() {
			return getRuleContexts(QualifiedStaticTypeRefContext.class);
		}
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef(int i) {
			return getRuleContext(QualifiedStaticTypeRefContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public InterfaceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInterfaceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInterfaceList(this);
		}
	}

	public final InterfaceListContext interfaceList() throws RecognitionException {
		InterfaceListContext _localctx = new InterfaceListContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_interfaceList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			qualifiedStaticTypeRef();
			setState(478);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(474);
				match(Comma);
				setState(475);
				qualifiedStaticTypeRef();
				}
				}
				setState(480);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterListInBracketsContext extends ParserRuleContext {
		public TerminalNode Lgeneric() { return getToken(PhpParser.Lgeneric, 0); }
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TerminalNode Rgeneric() { return getToken(PhpParser.Rgeneric, 0); }
		public TypeParameterWithDefaultsListContext typeParameterWithDefaultsList() {
			return getRuleContext(TypeParameterWithDefaultsListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(PhpParser.Comma, 0); }
		public TypeParameterListInBracketsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterListInBrackets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterListInBrackets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterListInBrackets(this);
		}
	}

	public final TypeParameterListInBracketsContext typeParameterListInBrackets() throws RecognitionException {
		TypeParameterListInBracketsContext _localctx = new TypeParameterListInBracketsContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeParameterListInBrackets);
		try {
			setState(495);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(481);
				match(Lgeneric);
				setState(482);
				typeParameterList();
				setState(483);
				match(Rgeneric);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(485);
				match(Lgeneric);
				setState(486);
				typeParameterWithDefaultsList();
				setState(487);
				match(Rgeneric);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(489);
				match(Lgeneric);
				setState(490);
				typeParameterList();
				setState(491);
				match(Comma);
				setState(492);
				typeParameterWithDefaultsList();
				setState(493);
				match(Rgeneric);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterListContext extends ParserRuleContext {
		public List<TypeParameterDeclContext> typeParameterDecl() {
			return getRuleContexts(TypeParameterDeclContext.class);
		}
		public TypeParameterDeclContext typeParameterDecl(int i) {
			return getRuleContext(TypeParameterDeclContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterList(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeParameterList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			typeParameterDecl();
			setState(502);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(498);
					match(Comma);
					setState(499);
					typeParameterDecl();
					}
					} 
				}
				setState(504);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterWithDefaultsListContext extends ParserRuleContext {
		public List<TypeParameterWithDefaultDeclContext> typeParameterWithDefaultDecl() {
			return getRuleContexts(TypeParameterWithDefaultDeclContext.class);
		}
		public TypeParameterWithDefaultDeclContext typeParameterWithDefaultDecl(int i) {
			return getRuleContext(TypeParameterWithDefaultDeclContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public TypeParameterWithDefaultsListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterWithDefaultsList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterWithDefaultsList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterWithDefaultsList(this);
		}
	}

	public final TypeParameterWithDefaultsListContext typeParameterWithDefaultsList() throws RecognitionException {
		TypeParameterWithDefaultsListContext _localctx = new TypeParameterWithDefaultsListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeParameterWithDefaultsList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(505);
			typeParameterWithDefaultDecl();
			setState(510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(506);
				match(Comma);
				setState(507);
				typeParameterWithDefaultDecl();
				}
				}
				setState(512);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterDeclContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TypeParameterDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterDecl(this);
		}
	}

	public final TypeParameterDeclContext typeParameterDecl() throws RecognitionException {
		TypeParameterDeclContext _localctx = new TypeParameterDeclContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeParameterDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AttributeStart) {
				{
				setState(513);
				attributes();
				}
			}

			setState(516);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterWithDefaultDeclContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TypeParameterWithDefaultDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterWithDefaultDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeParameterWithDefaultDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeParameterWithDefaultDecl(this);
		}
	}

	public final TypeParameterWithDefaultDeclContext typeParameterWithDefaultDecl() throws RecognitionException {
		TypeParameterWithDefaultDeclContext _localctx = new TypeParameterWithDefaultDeclContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_typeParameterWithDefaultDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AttributeStart) {
				{
				setState(518);
				attributes();
				}
			}

			setState(521);
			identifier();
			setState(522);
			match(Eq);
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,41,_ctx) ) {
			case 1:
				{
				setState(523);
				qualifiedStaticTypeRef();
				}
				break;
			case 2:
				{
				setState(524);
				primitiveType();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericDynamicArgsContext extends ParserRuleContext {
		public TerminalNode Lgeneric() { return getToken(PhpParser.Lgeneric, 0); }
		public List<TypeRefContext> typeRef() {
			return getRuleContexts(TypeRefContext.class);
		}
		public TypeRefContext typeRef(int i) {
			return getRuleContext(TypeRefContext.class,i);
		}
		public TerminalNode Rgeneric() { return getToken(PhpParser.Rgeneric, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public GenericDynamicArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericDynamicArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGenericDynamicArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGenericDynamicArgs(this);
		}
	}

	public final GenericDynamicArgsContext genericDynamicArgs() throws RecognitionException {
		GenericDynamicArgsContext _localctx = new GenericDynamicArgsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_genericDynamicArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(Lgeneric);
			setState(528);
			typeRef();
			setState(533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(529);
				match(Comma);
				setState(530);
				typeRef();
				}
				}
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(536);
			match(Rgeneric);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributesContext extends ParserRuleContext {
		public List<AttributeGroupContext> attributeGroup() {
			return getRuleContexts(AttributeGroupContext.class);
		}
		public AttributeGroupContext attributeGroup(int i) {
			return getRuleContext(AttributeGroupContext.class,i);
		}
		public AttributesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttributes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttributes(this);
		}
	}

	public final AttributesContext attributes() throws RecognitionException {
		AttributesContext _localctx = new AttributesContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_attributes);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(538);
				attributeGroup();
				}
				}
				setState(541); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AttributeStart );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeGroupContext extends ParserRuleContext {
		public TerminalNode AttributeStart() { return getToken(PhpParser.AttributeStart, 0); }
		public List<AttributeContext> attribute() {
			return getRuleContexts(AttributeContext.class);
		}
		public AttributeContext attribute(int i) {
			return getRuleContext(AttributeContext.class,i);
		}
		public TerminalNode CloseSquareBracket() { return getToken(PhpParser.CloseSquareBracket, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public AttributeGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeGroup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttributeGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttributeGroup(this);
		}
	}

	public final AttributeGroupContext attributeGroup() throws RecognitionException {
		AttributeGroupContext _localctx = new AttributeGroupContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_attributeGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			match(AttributeStart);
			setState(547);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(544);
				identifier();
				setState(545);
				match(Colon);
				}
				break;
			}
			setState(549);
			attribute();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(550);
				match(Comma);
				setState(551);
				attribute();
				}
				}
				setState(556);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(557);
			match(CloseSquareBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_attribute);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(559);
			qualifiedNamespaceName();
			setState(561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpenRoundBracket) {
				{
				setState(560);
				arguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InnerStatementListContext extends ParserRuleContext {
		public List<InnerStatementContext> innerStatement() {
			return getRuleContexts(InnerStatementContext.class);
		}
		public InnerStatementContext innerStatement(int i) {
			return getRuleContext(InnerStatementContext.class,i);
		}
		public InnerStatementListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerStatementList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInnerStatementList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInnerStatementList(this);
		}
	}

	public final InnerStatementListContext innerStatementList() throws RecognitionException {
		InnerStatementListContext _localctx = new InnerStatementListContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_innerStatementList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(563);
					innerStatement();
					}
					} 
				}
				setState(568);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InnerStatementContext extends ParserRuleContext {
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InnerStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInnerStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInnerStatement(this);
		}
	}

	public final InnerStatementContext innerStatement() throws RecognitionException {
		InnerStatementContext _localctx = new InnerStatementContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_innerStatement);
		try {
			setState(572);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(569);
				statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(570);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(571);
				classDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public DoWhileStatementContext doWhileStatement() {
			return getRuleContext(DoWhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public BreakStatementContext breakStatement() {
			return getRuleContext(BreakStatementContext.class,0);
		}
		public ContinueStatementContext continueStatement() {
			return getRuleContext(ContinueStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public YieldExpressionContext yieldExpression() {
			return getRuleContext(YieldExpressionContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public GlobalStatementContext globalStatement() {
			return getRuleContext(GlobalStatementContext.class,0);
		}
		public StaticVariableStatementContext staticVariableStatement() {
			return getRuleContext(StaticVariableStatementContext.class,0);
		}
		public EchoStatementContext echoStatement() {
			return getRuleContext(EchoStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public UnsetStatementContext unsetStatement() {
			return getRuleContext(UnsetStatementContext.class,0);
		}
		public ForeachStatementContext foreachStatement() {
			return getRuleContext(ForeachStatementContext.class,0);
		}
		public TryCatchFinallyContext tryCatchFinally() {
			return getRuleContext(TryCatchFinallyContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public GotoStatementContext gotoStatement() {
			return getRuleContext(GotoStatementContext.class,0);
		}
		public DeclareStatementContext declareStatement() {
			return getRuleContext(DeclareStatementContext.class,0);
		}
		public EmptyStatement_Context emptyStatement_() {
			return getRuleContext(EmptyStatement_Context.class,0);
		}
		public InlineHtmlStatementContext inlineHtmlStatement() {
			return getRuleContext(InlineHtmlStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_statement);
		try {
			setState(601);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(574);
				identifier();
				setState(575);
				match(Colon);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(577);
				blockStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(578);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(579);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(580);
				doWhileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(581);
				forStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(582);
				switchStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(583);
				breakStatement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(584);
				continueStatement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(585);
				returnStatement();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(586);
				yieldExpression();
				setState(587);
				match(SemiColon);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(589);
				globalStatement();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(590);
				staticVariableStatement();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(591);
				echoStatement();
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(592);
				expressionStatement();
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(593);
				unsetStatement();
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(594);
				foreachStatement();
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(595);
				tryCatchFinally();
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(596);
				throwStatement();
				}
				break;
			case 20:
				enterOuterAlt(_localctx, 20);
				{
				setState(597);
				gotoStatement();
				}
				break;
			case 21:
				enterOuterAlt(_localctx, 21);
				{
				setState(598);
				declareStatement();
				}
				break;
			case 22:
				enterOuterAlt(_localctx, 22);
				{
				setState(599);
				emptyStatement_();
				}
				break;
			case 23:
				enterOuterAlt(_localctx, 23);
				{
				setState(600);
				inlineHtmlStatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EmptyStatement_Context extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public EmptyStatement_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterEmptyStatement_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitEmptyStatement_(this);
		}
	}

	public final EmptyStatement_Context emptyStatement_() throws RecognitionException {
		EmptyStatement_Context _localctx = new EmptyStatement_Context(_ctx, getState());
		enterRule(_localctx, 56, RULE_emptyStatement_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_blockStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(605);
			match(OpenCurlyBracket);
			setState(606);
			innerStatementList();
			setState(607);
			match(CloseCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode If() { return getToken(PhpParser.If, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ElseIfStatementContext> elseIfStatement() {
			return getRuleContexts(ElseIfStatementContext.class);
		}
		public ElseIfStatementContext elseIfStatement(int i) {
			return getRuleContext(ElseIfStatementContext.class,i);
		}
		public ElseStatementContext elseStatement() {
			return getRuleContext(ElseStatementContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndIf() { return getToken(PhpParser.EndIf, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public List<ElseIfColonStatementContext> elseIfColonStatement() {
			return getRuleContexts(ElseIfColonStatementContext.class);
		}
		public ElseIfColonStatementContext elseIfColonStatement(int i) {
			return getRuleContext(ElseIfColonStatementContext.class,i);
		}
		public ElseColonStatementContext elseColonStatement() {
			return getRuleContext(ElseColonStatementContext.class,0);
		}
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIfStatement(this);
		}
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_ifStatement);
		int _la;
		try {
			int _alt;
			setState(637);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(609);
				match(If);
				setState(610);
				parentheses();
				setState(611);
				statement();
				setState(615);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(612);
						elseIfStatement();
						}
						} 
					}
					setState(617);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
				}
				setState(619);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(618);
					elseStatement();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(621);
				match(If);
				setState(622);
				parentheses();
				setState(623);
				match(Colon);
				setState(624);
				innerStatementList();
				setState(628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==ElseIf) {
					{
					{
					setState(625);
					elseIfColonStatement();
					}
					}
					setState(630);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Else) {
					{
					setState(631);
					elseColonStatement();
					}
				}

				setState(634);
				match(EndIf);
				setState(635);
				match(SemiColon);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfStatementContext extends ParserRuleContext {
		public TerminalNode ElseIf() { return getToken(PhpParser.ElseIf, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseIfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseIfStatement(this);
		}
	}

	public final ElseIfStatementContext elseIfStatement() throws RecognitionException {
		ElseIfStatementContext _localctx = new ElseIfStatementContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_elseIfStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(639);
			match(ElseIf);
			setState(640);
			parentheses();
			setState(641);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseIfColonStatementContext extends ParserRuleContext {
		public TerminalNode ElseIf() { return getToken(PhpParser.ElseIf, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public ElseIfColonStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseIfColonStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseIfColonStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseIfColonStatement(this);
		}
	}

	public final ElseIfColonStatementContext elseIfColonStatement() throws RecognitionException {
		ElseIfColonStatementContext _localctx = new ElseIfColonStatementContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_elseIfColonStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			match(ElseIf);
			setState(644);
			parentheses();
			setState(645);
			match(Colon);
			setState(646);
			innerStatementList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(PhpParser.Else, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseStatement(this);
		}
	}

	public final ElseStatementContext elseStatement() throws RecognitionException {
		ElseStatementContext _localctx = new ElseStatementContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_elseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(648);
			match(Else);
			setState(649);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElseColonStatementContext extends ParserRuleContext {
		public TerminalNode Else() { return getToken(PhpParser.Else, 0); }
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public ElseColonStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elseColonStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterElseColonStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitElseColonStatement(this);
		}
	}

	public final ElseColonStatementContext elseColonStatement() throws RecognitionException {
		ElseColonStatementContext _localctx = new ElseColonStatementContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_elseColonStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			match(Else);
			setState(652);
			match(Colon);
			setState(653);
			innerStatementList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode While() { return getToken(PhpParser.While, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndWhile() { return getToken(PhpParser.EndWhile, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(655);
			match(While);
			setState(656);
			parentheses();
			setState(663);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
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
			case ScriptText:
			case HtmlScriptClose:
			case StyleBody:
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
			case StartHereDoc:
				{
				setState(657);
				statement();
				}
				break;
			case Colon:
				{
				setState(658);
				match(Colon);
				setState(659);
				innerStatementList();
				setState(660);
				match(EndWhile);
				setState(661);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DoWhileStatementContext extends ParserRuleContext {
		public TerminalNode Do() { return getToken(PhpParser.Do, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode While() { return getToken(PhpParser.While, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public DoWhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doWhileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterDoWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitDoWhileStatement(this);
		}
	}

	public final DoWhileStatementContext doWhileStatement() throws RecognitionException {
		DoWhileStatementContext _localctx = new DoWhileStatementContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_doWhileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			match(Do);
			setState(666);
			statement();
			setState(667);
			match(While);
			setState(668);
			parentheses();
			setState(669);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode For() { return getToken(PhpParser.For, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public List<TerminalNode> SemiColon() { return getTokens(PhpParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(PhpParser.SemiColon, i);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndFor() { return getToken(PhpParser.EndFor, 0); }
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_forStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(671);
			match(For);
			setState(672);
			match(OpenRoundBracket);
			setState(674);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
				{
				setState(673);
				forInit();
				}
			}

			setState(676);
			match(SemiColon);
			setState(678);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
				{
				setState(677);
				expressionList();
				}
			}

			setState(680);
			match(SemiColon);
			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
				{
				setState(681);
				forUpdate();
				}
			}

			setState(684);
			match(CloseRoundBracket);
			setState(691);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
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
			case ScriptText:
			case HtmlScriptClose:
			case StyleBody:
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
			case StartHereDoc:
				{
				setState(685);
				statement();
				}
				break;
			case Colon:
				{
				setState(686);
				match(Colon);
				setState(687);
				innerStatementList();
				setState(688);
				match(EndFor);
				setState(689);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_forInit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForUpdateContext extends ParserRuleContext {
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForUpdate(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(695);
			expressionList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode Switch() { return getToken(PhpParser.Switch, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public TerminalNode EndSwitch() { return getToken(PhpParser.EndSwitch, 0); }
		public List<TerminalNode> SemiColon() { return getTokens(PhpParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(PhpParser.SemiColon, i);
		}
		public List<SwitchBlockContext> switchBlock() {
			return getRuleContexts(SwitchBlockContext.class);
		}
		public SwitchBlockContext switchBlock(int i) {
			return getRuleContext(SwitchBlockContext.class,i);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_switchStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(697);
			match(Switch);
			setState(698);
			parentheses();
			setState(722);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenCurlyBracket:
				{
				setState(699);
				match(OpenCurlyBracket);
				setState(701);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SemiColon) {
					{
					setState(700);
					match(SemiColon);
					}
				}

				setState(706);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Case || _la==Default) {
					{
					{
					setState(703);
					switchBlock();
					}
					}
					setState(708);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(709);
				match(CloseCurlyBracket);
				}
				break;
			case Colon:
				{
				setState(710);
				match(Colon);
				setState(712);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SemiColon) {
					{
					setState(711);
					match(SemiColon);
					}
				}

				setState(717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Case || _la==Default) {
					{
					{
					setState(714);
					switchBlock();
					}
					}
					setState(719);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(720);
				match(EndSwitch);
				setState(721);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchBlockContext extends ParserRuleContext {
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public List<TerminalNode> Colon() { return getTokens(PhpParser.Colon); }
		public TerminalNode Colon(int i) {
			return getToken(PhpParser.Colon, i);
		}
		public List<TerminalNode> SemiColon() { return getTokens(PhpParser.SemiColon); }
		public TerminalNode SemiColon(int i) {
			return getToken(PhpParser.SemiColon, i);
		}
		public List<TerminalNode> Case() { return getTokens(PhpParser.Case); }
		public TerminalNode Case(int i) {
			return getToken(PhpParser.Case, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Default() { return getTokens(PhpParser.Default); }
		public TerminalNode Default(int i) {
			return getToken(PhpParser.Default, i);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSwitchBlock(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_switchBlock);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(730); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(727);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Case:
						{
						setState(724);
						match(Case);
						setState(725);
						expression(0);
						}
						break;
					case Default:
						{
						setState(726);
						match(Default);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(729);
					_la = _input.LA(1);
					if ( !(_la==Colon || _la==SemiColon) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(732); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(734);
			innerStatementList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BreakStatementContext extends ParserRuleContext {
		public TerminalNode Break() { return getToken(PhpParser.Break, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBreakStatement(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_breakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			match(Break);
			setState(738);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
				{
				setState(737);
				expression(0);
				}
			}

			setState(740);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ContinueStatementContext extends ParserRuleContext {
		public TerminalNode Continue() { return getToken(PhpParser.Continue, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitContinueStatement(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_continueStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(742);
			match(Continue);
			setState(744);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
				{
				setState(743);
				expression(0);
				}
			}

			setState(746);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode Return() { return getToken(PhpParser.Return, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(748);
			match(Return);
			setState(750);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
				{
				setState(749);
				expression(0);
				}
			}

			setState(752);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(754);
			expression(0);
			setState(755);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnsetStatementContext extends ParserRuleContext {
		public TerminalNode Unset() { return getToken(PhpParser.Unset, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public ChainListContext chainList() {
			return getRuleContext(ChainListContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public UnsetStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unsetStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUnsetStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUnsetStatement(this);
		}
	}

	public final UnsetStatementContext unsetStatement() throws RecognitionException {
		UnsetStatementContext _localctx = new UnsetStatementContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_unsetStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757);
			match(Unset);
			setState(758);
			match(OpenRoundBracket);
			setState(759);
			chainList();
			setState(760);
			match(CloseRoundBracket);
			setState(761);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForeachStatementContext extends ParserRuleContext {
		public TerminalNode Foreach() { return getToken(PhpParser.Foreach, 0); }
		public List<TerminalNode> OpenRoundBracket() { return getTokens(PhpParser.OpenRoundBracket); }
		public TerminalNode OpenRoundBracket(int i) {
			return getToken(PhpParser.OpenRoundBracket, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public ArrayDestructuringContext arrayDestructuring() {
			return getRuleContext(ArrayDestructuringContext.class,0);
		}
		public List<TerminalNode> CloseRoundBracket() { return getTokens(PhpParser.CloseRoundBracket); }
		public TerminalNode CloseRoundBracket(int i) {
			return getToken(PhpParser.CloseRoundBracket, i);
		}
		public List<ChainContext> chain() {
			return getRuleContexts(ChainContext.class);
		}
		public ChainContext chain(int i) {
			return getRuleContext(ChainContext.class,i);
		}
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndForeach() { return getToken(PhpParser.EndForeach, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public List<TerminalNode> Ampersand() { return getTokens(PhpParser.Ampersand); }
		public TerminalNode Ampersand(int i) {
			return getToken(PhpParser.Ampersand, i);
		}
		public TerminalNode DoubleArrow() { return getToken(PhpParser.DoubleArrow, 0); }
		public ForeachStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_foreachStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterForeachStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitForeachStatement(this);
		}
	}

	public final ForeachStatementContext foreachStatement() throws RecognitionException {
		ForeachStatementContext _localctx = new ForeachStatementContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_foreachStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			match(Foreach);
			setState(808);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				{
				setState(764);
				match(OpenRoundBracket);
				setState(765);
				expression(0);
				setState(766);
				match(As);
				setState(767);
				arrayDestructuring();
				setState(768);
				match(CloseRoundBracket);
				}
				break;
			case 2:
				{
				setState(770);
				match(OpenRoundBracket);
				setState(771);
				chain();
				setState(772);
				match(As);
				setState(774);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ampersand) {
					{
					setState(773);
					match(Ampersand);
					}
				}

				setState(776);
				assignable();
				setState(782);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleArrow) {
					{
					setState(777);
					match(DoubleArrow);
					setState(779);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Ampersand) {
						{
						setState(778);
						match(Ampersand);
						}
					}

					setState(781);
					chain();
					}
				}

				setState(784);
				match(CloseRoundBracket);
				}
				break;
			case 3:
				{
				setState(786);
				match(OpenRoundBracket);
				setState(787);
				expression(0);
				setState(788);
				match(As);
				setState(789);
				assignable();
				setState(795);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleArrow) {
					{
					setState(790);
					match(DoubleArrow);
					setState(792);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Ampersand) {
						{
						setState(791);
						match(Ampersand);
						}
					}

					setState(794);
					chain();
					}
				}

				setState(797);
				match(CloseRoundBracket);
				}
				break;
			case 4:
				{
				setState(799);
				match(OpenRoundBracket);
				setState(800);
				chain();
				setState(801);
				match(As);
				setState(802);
				match(List);
				setState(803);
				match(OpenRoundBracket);
				setState(804);
				assignmentList();
				setState(805);
				match(CloseRoundBracket);
				setState(806);
				match(CloseRoundBracket);
				}
				break;
			}
			setState(816);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
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
			case ScriptText:
			case HtmlScriptClose:
			case StyleBody:
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
			case StartHereDoc:
				{
				setState(810);
				statement();
				}
				break;
			case Colon:
				{
				setState(811);
				match(Colon);
				setState(812);
				innerStatementList();
				setState(813);
				match(EndForeach);
				setState(814);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchFinallyContext extends ParserRuleContext {
		public TerminalNode Try() { return getToken(PhpParser.Try, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FinallyStatementContext finallyStatement() {
			return getRuleContext(FinallyStatementContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public TryCatchFinallyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryCatchFinally; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTryCatchFinally(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTryCatchFinally(this);
		}
	}

	public final TryCatchFinallyContext tryCatchFinally() throws RecognitionException {
		TryCatchFinallyContext _localctx = new TryCatchFinallyContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_tryCatchFinally);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(818);
			match(Try);
			setState(819);
			blockStatement();
			setState(835);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,80,_ctx) ) {
			case 1:
				{
				setState(821); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(820);
						catchClause();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(823); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,77,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(826);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
				case 1:
					{
					setState(825);
					finallyStatement();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(831);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Catch) {
					{
					{
					setState(828);
					catchClause();
					}
					}
					setState(833);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(834);
				finallyStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode Catch() { return getToken(PhpParser.Catch, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public List<QualifiedStaticTypeRefContext> qualifiedStaticTypeRef() {
			return getRuleContexts(QualifiedStaticTypeRefContext.class);
		}
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef(int i) {
			return getRuleContext(QualifiedStaticTypeRefContext.class,i);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public List<TerminalNode> Pipe() { return getTokens(PhpParser.Pipe); }
		public TerminalNode Pipe(int i) {
			return getToken(PhpParser.Pipe, i);
		}
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(837);
			match(Catch);
			setState(838);
			match(OpenRoundBracket);
			setState(839);
			qualifiedStaticTypeRef();
			setState(844);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Pipe) {
				{
				{
				setState(840);
				match(Pipe);
				setState(841);
				qualifiedStaticTypeRef();
				}
				}
				setState(846);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VarName) {
				{
				setState(847);
				match(VarName);
				}
			}

			setState(850);
			match(CloseRoundBracket);
			setState(851);
			blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinallyStatementContext extends ParserRuleContext {
		public TerminalNode Finally() { return getToken(PhpParser.Finally, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public FinallyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFinallyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFinallyStatement(this);
		}
	}

	public final FinallyStatementContext finallyStatement() throws RecognitionException {
		FinallyStatementContext _localctx = new FinallyStatementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_finallyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(853);
			match(Finally);
			setState(854);
			blockStatement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ThrowStatementContext extends ParserRuleContext {
		public TerminalNode Throw() { return getToken(PhpParser.Throw, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(856);
			match(Throw);
			setState(857);
			expression(0);
			setState(858);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GotoStatementContext extends ParserRuleContext {
		public TerminalNode Goto() { return getToken(PhpParser.Goto, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public GotoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gotoStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGotoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGotoStatement(this);
		}
	}

	public final GotoStatementContext gotoStatement() throws RecognitionException {
		GotoStatementContext _localctx = new GotoStatementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_gotoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(860);
			match(Goto);
			setState(861);
			identifier();
			setState(862);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareStatementContext extends ParserRuleContext {
		public TerminalNode Declare() { return getToken(PhpParser.Declare, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public DeclareListContext declareList() {
			return getRuleContext(DeclareListContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public InnerStatementListContext innerStatementList() {
			return getRuleContext(InnerStatementListContext.class,0);
		}
		public TerminalNode EndDeclare() { return getToken(PhpParser.EndDeclare, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public DeclareStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterDeclareStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitDeclareStatement(this);
		}
	}

	public final DeclareStatementContext declareStatement() throws RecognitionException {
		DeclareStatementContext _localctx = new DeclareStatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_declareStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(864);
			match(Declare);
			setState(865);
			match(OpenRoundBracket);
			setState(866);
			declareList();
			setState(867);
			match(CloseRoundBracket);
			setState(874);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case HtmlText:
			case XmlStart:
			case HtmlScriptOpen:
			case HtmlStyleOpen:
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
			case ScriptText:
			case HtmlScriptClose:
			case StyleBody:
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
			case StartHereDoc:
				{
				setState(868);
				statement();
				}
				break;
			case Colon:
				{
				setState(869);
				match(Colon);
				setState(870);
				innerStatementList();
				setState(871);
				match(EndDeclare);
				setState(872);
				match(SemiColon);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InlineHtmlStatementContext extends ParserRuleContext {
		public List<InlineHtmlContext> inlineHtml() {
			return getRuleContexts(InlineHtmlContext.class);
		}
		public InlineHtmlContext inlineHtml(int i) {
			return getRuleContext(InlineHtmlContext.class,i);
		}
		public InlineHtmlStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inlineHtmlStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInlineHtmlStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInlineHtmlStatement(this);
		}
	}

	public final InlineHtmlStatementContext inlineHtmlStatement() throws RecognitionException {
		InlineHtmlStatementContext _localctx = new InlineHtmlStatementContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_inlineHtmlStatement);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(877); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(876);
					inlineHtml();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(879); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclareListContext extends ParserRuleContext {
		public List<DirectiveContext> directive() {
			return getRuleContexts(DirectiveContext.class);
		}
		public DirectiveContext directive(int i) {
			return getRuleContext(DirectiveContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public DeclareListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declareList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterDeclareList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitDeclareList(this);
		}
	}

	public final DeclareListContext declareList() throws RecognitionException {
		DeclareListContext _localctx = new DeclareListContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_declareList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			directive();
			setState(886);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(882);
				match(Comma);
				setState(883);
				directive();
				}
				}
				setState(888);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectiveContext extends ParserRuleContext {
		public TerminalNode Ticks() { return getToken(PhpParser.Ticks, 0); }
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public NumericConstantContext numericConstant() {
			return getRuleContext(NumericConstantContext.class,0);
		}
		public TerminalNode Real() { return getToken(PhpParser.Real, 0); }
		public TerminalNode Encoding() { return getToken(PhpParser.Encoding, 0); }
		public TerminalNode SingleQuoteString() { return getToken(PhpParser.SingleQuoteString, 0); }
		public TerminalNode StrictTypes() { return getToken(PhpParser.StrictTypes, 0); }
		public DirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterDirective(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitDirective(this);
		}
	}

	public final DirectiveContext directive() throws RecognitionException {
		DirectiveContext _localctx = new DirectiveContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_directive);
		try {
			setState(901);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Ticks:
				enterOuterAlt(_localctx, 1);
				{
				setState(889);
				match(Ticks);
				setState(890);
				match(Eq);
				setState(893);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Octal:
				case Decimal:
				case Hex:
				case Binary:
					{
					setState(891);
					numericConstant();
					}
					break;
				case Real:
					{
					setState(892);
					match(Real);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case Encoding:
				enterOuterAlt(_localctx, 2);
				{
				setState(895);
				match(Encoding);
				setState(896);
				match(Eq);
				setState(897);
				match(SingleQuoteString);
				}
				break;
			case StrictTypes:
				enterOuterAlt(_localctx, 3);
				{
				setState(898);
				match(StrictTypes);
				setState(899);
				match(Eq);
				setState(900);
				numericConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFormalParameterList(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(904);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 43)) & ~0x3f) == 0 && ((1L << (_la - 43)) & -1L) != 0) || ((((_la - 107)) & ~0x3f) == 0 && ((1L << (_la - 107)) & 18014398509481983L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 3221356563L) != 0)) {
				{
				setState(903);
				formalParameter();
				}
			}

			setState(910);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(906);
					match(Comma);
					setState(907);
					formalParameter();
					}
					} 
				}
				setState(912);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,89,_ctx);
			}
			setState(914);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(913);
				match(Comma);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterContext extends ParserRuleContext {
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public List<MemberModifierContext> memberModifier() {
			return getRuleContexts(MemberModifierContext.class);
		}
		public MemberModifierContext memberModifier(int i) {
			return getRuleContext(MemberModifierContext.class,i);
		}
		public TerminalNode QuestionMark() { return getToken(PhpParser.QuestionMark, 0); }
		public TypeHintContext typeHint() {
			return getRuleContext(TypeHintContext.class,0);
		}
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public TerminalNode Ellipsis() { return getToken(PhpParser.Ellipsis, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_formalParameter);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AttributeStart) {
				{
				setState(916);
				attributes();
				}
			}

			setState(922);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(919);
					memberModifier();
					}
					} 
				}
				setState(924);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
			}
			setState(926);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QuestionMark) {
				{
				setState(925);
				match(QuestionMark);
				}
			}

			setState(929);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 9007199254740991L) != 0) || _la==NamespaceSeparator || _la==Label) {
				{
				setState(928);
				typeHint(0);
				}
			}

			setState(932);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(931);
				match(Ampersand);
				}
			}

			setState(935);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ellipsis) {
				{
				setState(934);
				match(Ellipsis);
				}
			}

			setState(937);
			variableInitializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeHintContext extends ParserRuleContext {
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public TerminalNode Callable() { return getToken(PhpParser.Callable, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<TypeHintContext> typeHint() {
			return getRuleContexts(TypeHintContext.class);
		}
		public TypeHintContext typeHint(int i) {
			return getRuleContext(TypeHintContext.class,i);
		}
		public TerminalNode Pipe() { return getToken(PhpParser.Pipe, 0); }
		public TypeHintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeHint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeHint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeHint(this);
		}
	}

	public final TypeHintContext typeHint() throws RecognitionException {
		return typeHint(0);
	}

	private TypeHintContext typeHint(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TypeHintContext _localctx = new TypeHintContext(_ctx, _parentState);
		TypeHintContext _prevctx = _localctx;
		int _startState = 118;
		enterRecursionRule(_localctx, 118, RULE_typeHint, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,97,_ctx) ) {
			case 1:
				{
				setState(940);
				qualifiedStaticTypeRef();
				}
				break;
			case 2:
				{
				setState(941);
				match(Callable);
				}
				break;
			case 3:
				{
				setState(942);
				primitiveType();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(950);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TypeHintContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_typeHint);
					setState(945);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(946);
					match(Pipe);
					setState(947);
					typeHint(2);
					}
					} 
				}
				setState(952);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,98,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalStatementContext extends ParserRuleContext {
		public TerminalNode Global() { return getToken(PhpParser.Global, 0); }
		public List<GlobalVarContext> globalVar() {
			return getRuleContexts(GlobalVarContext.class);
		}
		public GlobalVarContext globalVar(int i) {
			return getRuleContext(GlobalVarContext.class,i);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public GlobalStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGlobalStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGlobalStatement(this);
		}
	}

	public final GlobalStatementContext globalStatement() throws RecognitionException {
		GlobalStatementContext _localctx = new GlobalStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_globalStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(953);
			match(Global);
			setState(954);
			globalVar();
			setState(959);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(955);
				match(Comma);
				setState(956);
				globalVar();
				}
				}
				setState(961);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(962);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalVarContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public TerminalNode Dollar() { return getToken(PhpParser.Dollar, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public GlobalVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGlobalVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGlobalVar(this);
		}
	}

	public final GlobalVarContext globalVar() throws RecognitionException {
		GlobalVarContext _localctx = new GlobalVarContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_globalVar);
		try {
			setState(972);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(964);
				match(VarName);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(965);
				match(Dollar);
				setState(966);
				chain();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(967);
				match(Dollar);
				setState(968);
				match(OpenCurlyBracket);
				setState(969);
				expression(0);
				setState(970);
				match(CloseCurlyBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EchoStatementContext extends ParserRuleContext {
		public TerminalNode Echo() { return getToken(PhpParser.Echo, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public EchoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echoStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterEchoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitEchoStatement(this);
		}
	}

	public final EchoStatementContext echoStatement() throws RecognitionException {
		EchoStatementContext _localctx = new EchoStatementContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_echoStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(974);
			match(Echo);
			setState(975);
			expressionList();
			setState(976);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StaticVariableStatementContext extends ParserRuleContext {
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public StaticVariableStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticVariableStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterStaticVariableStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitStaticVariableStatement(this);
		}
	}

	public final StaticVariableStatementContext staticVariableStatement() throws RecognitionException {
		StaticVariableStatementContext _localctx = new StaticVariableStatementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_staticVariableStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(978);
			match(Static);
			setState(979);
			variableInitializer();
			setState(984);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(980);
				match(Comma);
				setState(981);
				variableInitializer();
				}
				}
				setState(986);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(987);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassStatementContext extends ParserRuleContext {
		public PropertyModifiersContext propertyModifiers() {
			return getRuleContext(PropertyModifiersContext.class,0);
		}
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public List<IdentifierInitializerContext> identifierInitializer() {
			return getRuleContexts(IdentifierInitializerContext.class);
		}
		public IdentifierInitializerContext identifierInitializer(int i) {
			return getRuleContext(IdentifierInitializerContext.class,i);
		}
		public TerminalNode Function_() { return getToken(PhpParser.Function_, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public TypeHintContext typeHint() {
			return getRuleContext(TypeHintContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public MemberModifiersContext memberModifiers() {
			return getRuleContext(MemberModifiersContext.class,0);
		}
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public TypeParameterListInBracketsContext typeParameterListInBrackets() {
			return getRuleContext(TypeParameterListInBracketsContext.class,0);
		}
		public BaseCtorCallContext baseCtorCall() {
			return getRuleContext(BaseCtorCallContext.class,0);
		}
		public ReturnTypeDeclContext returnTypeDecl() {
			return getRuleContext(ReturnTypeDeclContext.class,0);
		}
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public QualifiedNamespaceNameListContext qualifiedNamespaceNameList() {
			return getRuleContext(QualifiedNamespaceNameListContext.class,0);
		}
		public TraitAdaptationsContext traitAdaptations() {
			return getRuleContext(TraitAdaptationsContext.class,0);
		}
		public ClassStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassStatement(this);
		}
	}

	public final ClassStatementContext classStatement() throws RecognitionException {
		ClassStatementContext _localctx = new ClassStatementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_classStatement);
		int _la;
		try {
			setState(1048);
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
			case Readonly:
			case Static:
			case Var:
				enterOuterAlt(_localctx, 1);
				{
				setState(990);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AttributeStart) {
					{
					setState(989);
					attributes();
					}
				}

				setState(1042);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
				case 1:
					{
					setState(992);
					propertyModifiers();
					setState(994);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 9007199254740991L) != 0) || _la==NamespaceSeparator || _la==Label) {
						{
						setState(993);
						typeHint(0);
						}
					}

					setState(996);
					variableInitializer();
					setState(1001);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==Comma) {
						{
						{
						setState(997);
						match(Comma);
						setState(998);
						variableInitializer();
						}
						}
						setState(1003);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1004);
					match(SemiColon);
					}
					break;
				case 2:
					{
					setState(1007);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Abstract || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 2327872274433L) != 0)) {
						{
						setState(1006);
						memberModifiers();
						}
					}

					setState(1040);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case Const:
						{
						setState(1009);
						match(Const);
						setState(1011);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,106,_ctx) ) {
						case 1:
							{
							setState(1010);
							typeHint(0);
							}
							break;
						}
						setState(1013);
						identifierInitializer();
						setState(1018);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==Comma) {
							{
							{
							setState(1014);
							match(Comma);
							setState(1015);
							identifierInitializer();
							}
							}
							setState(1020);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1021);
						match(SemiColon);
						}
						break;
					case Function_:
						{
						setState(1023);
						match(Function_);
						setState(1025);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Ampersand) {
							{
							setState(1024);
							match(Ampersand);
							}
						}

						setState(1027);
						identifier();
						setState(1029);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==Lgeneric) {
							{
							setState(1028);
							typeParameterListInBrackets();
							}
						}

						setState(1031);
						match(OpenRoundBracket);
						setState(1032);
						formalParameterList();
						setState(1033);
						match(CloseRoundBracket);
						setState(1036);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
						case 1:
							{
							setState(1034);
							baseCtorCall();
							}
							break;
						case 2:
							{
							setState(1035);
							returnTypeDecl();
							}
							break;
						}
						setState(1038);
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
				setState(1044);
				match(Use);
				setState(1045);
				qualifiedNamespaceNameList();
				setState(1046);
				traitAdaptations();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitAdaptationsContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public List<TraitAdaptationStatementContext> traitAdaptationStatement() {
			return getRuleContexts(TraitAdaptationStatementContext.class);
		}
		public TraitAdaptationStatementContext traitAdaptationStatement(int i) {
			return getRuleContext(TraitAdaptationStatementContext.class,i);
		}
		public TraitAdaptationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitAdaptations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitAdaptations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitAdaptations(this);
		}
	}

	public final TraitAdaptationsContext traitAdaptations() throws RecognitionException {
		TraitAdaptationsContext _localctx = new TraitAdaptationsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_traitAdaptations);
		int _la;
		try {
			setState(1059);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SemiColon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1050);
				match(SemiColon);
				}
				break;
			case OpenCurlyBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1051);
				match(OpenCurlyBracket);
				setState(1055);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 9007199254740991L) != 0) || _la==NamespaceSeparator || _la==Label) {
					{
					{
					setState(1052);
					traitAdaptationStatement();
					}
					}
					setState(1057);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1058);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitAdaptationStatementContext extends ParserRuleContext {
		public TraitPrecedenceContext traitPrecedence() {
			return getRuleContext(TraitPrecedenceContext.class,0);
		}
		public TraitAliasContext traitAlias() {
			return getRuleContext(TraitAliasContext.class,0);
		}
		public TraitAdaptationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitAdaptationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitAdaptationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitAdaptationStatement(this);
		}
	}

	public final TraitAdaptationStatementContext traitAdaptationStatement() throws RecognitionException {
		TraitAdaptationStatementContext _localctx = new TraitAdaptationStatementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_traitAdaptationStatement);
		try {
			setState(1063);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1061);
				traitPrecedence();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1062);
				traitAlias();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitPrecedenceContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(PhpParser.DoubleColon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode InsteadOf() { return getToken(PhpParser.InsteadOf, 0); }
		public QualifiedNamespaceNameListContext qualifiedNamespaceNameList() {
			return getRuleContext(QualifiedNamespaceNameListContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public TraitPrecedenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitPrecedence; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitPrecedence(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitPrecedence(this);
		}
	}

	public final TraitPrecedenceContext traitPrecedence() throws RecognitionException {
		TraitPrecedenceContext _localctx = new TraitPrecedenceContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_traitPrecedence);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1065);
			qualifiedNamespaceName();
			setState(1066);
			match(DoubleColon);
			setState(1067);
			identifier();
			setState(1068);
			match(InsteadOf);
			setState(1069);
			qualifiedNamespaceNameList();
			setState(1070);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitAliasContext extends ParserRuleContext {
		public TraitMethodReferenceContext traitMethodReference() {
			return getRuleContext(TraitMethodReferenceContext.class,0);
		}
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public MemberModifierContext memberModifier() {
			return getRuleContext(MemberModifierContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TraitAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitAlias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitAlias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitAlias(this);
		}
	}

	public final TraitAliasContext traitAlias() throws RecognitionException {
		TraitAliasContext _localctx = new TraitAliasContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_traitAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1072);
			traitMethodReference();
			setState(1073);
			match(As);
			setState(1079);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				{
				setState(1074);
				memberModifier();
				}
				break;
			case 2:
				{
				setState(1076);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,117,_ctx) ) {
				case 1:
					{
					setState(1075);
					memberModifier();
					}
					break;
				}
				setState(1078);
				identifier();
				}
				break;
			}
			setState(1081);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TraitMethodReferenceContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public TerminalNode DoubleColon() { return getToken(PhpParser.DoubleColon, 0); }
		public TraitMethodReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_traitMethodReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTraitMethodReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTraitMethodReference(this);
		}
	}

	public final TraitMethodReferenceContext traitMethodReference() throws RecognitionException {
		TraitMethodReferenceContext _localctx = new TraitMethodReferenceContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_traitMethodReference);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1086);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				{
				setState(1083);
				qualifiedNamespaceName();
				setState(1084);
				match(DoubleColon);
				}
				break;
			}
			setState(1088);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BaseCtorCallContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BaseCtorCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_baseCtorCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBaseCtorCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBaseCtorCall(this);
		}
	}

	public final BaseCtorCallContext baseCtorCall() throws RecognitionException {
		BaseCtorCallContext _localctx = new BaseCtorCallContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_baseCtorCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1090);
			match(Colon);
			setState(1091);
			identifier();
			setState(1093);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OpenRoundBracket) {
				{
				setState(1092);
				arguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnTypeDeclContext extends ParserRuleContext {
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public TypeHintContext typeHint() {
			return getRuleContext(TypeHintContext.class,0);
		}
		public TerminalNode QuestionMark() { return getToken(PhpParser.QuestionMark, 0); }
		public ReturnTypeDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnTypeDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterReturnTypeDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitReturnTypeDecl(this);
		}
	}

	public final ReturnTypeDeclContext returnTypeDecl() throws RecognitionException {
		ReturnTypeDeclContext _localctx = new ReturnTypeDeclContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_returnTypeDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1095);
			match(Colon);
			setState(1097);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==QuestionMark) {
				{
				setState(1096);
				match(QuestionMark);
				}
			}

			setState(1099);
			typeHint(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends ParserRuleContext {
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_methodBody);
		try {
			setState(1103);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SemiColon:
				enterOuterAlt(_localctx, 1);
				{
				setState(1101);
				match(SemiColon);
				}
				break;
			case OpenCurlyBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1102);
				blockStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyModifiersContext extends ParserRuleContext {
		public MemberModifiersContext memberModifiers() {
			return getRuleContext(MemberModifiersContext.class,0);
		}
		public TerminalNode Var() { return getToken(PhpParser.Var, 0); }
		public PropertyModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPropertyModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPropertyModifiers(this);
		}
	}

	public final PropertyModifiersContext propertyModifiers() throws RecognitionException {
		PropertyModifiersContext _localctx = new PropertyModifiersContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_propertyModifiers);
		try {
			setState(1107);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Abstract:
			case Final:
			case Private:
			case Protected:
			case Public:
			case Readonly:
			case Static:
				enterOuterAlt(_localctx, 1);
				{
				setState(1105);
				memberModifiers();
				}
				break;
			case Var:
				enterOuterAlt(_localctx, 2);
				{
				setState(1106);
				match(Var);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberModifiersContext extends ParserRuleContext {
		public List<MemberModifierContext> memberModifier() {
			return getRuleContexts(MemberModifierContext.class);
		}
		public MemberModifierContext memberModifier(int i) {
			return getRuleContext(MemberModifierContext.class,i);
		}
		public MemberModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberModifiers; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMemberModifiers(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMemberModifiers(this);
		}
	}

	public final MemberModifiersContext memberModifiers() throws RecognitionException {
		MemberModifiersContext _localctx = new MemberModifiersContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_memberModifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1110); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1109);
					memberModifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1112); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableInitializerContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ConstantInitializerContext constantInitializer() {
			return getRuleContext(ConstantInitializerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitVariableInitializer(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_variableInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1114);
			match(VarName);
			setState(1117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Eq) {
				{
				setState(1115);
				match(Eq);
				setState(1116);
				constantInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierInitializerContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ConstantInitializerContext constantInitializer() {
			return getRuleContext(ConstantInitializerContext.class,0);
		}
		public IdentifierInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifierInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIdentifierInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIdentifierInitializer(this);
		}
	}

	public final IdentifierInitializerContext identifierInitializer() throws RecognitionException {
		IdentifierInitializerContext _localctx = new IdentifierInitializerContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_identifierInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1119);
			identifier();
			setState(1120);
			match(Eq);
			setState(1121);
			constantInitializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GlobalConstantDeclarationContext extends ParserRuleContext {
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public List<IdentifierInitializerContext> identifierInitializer() {
			return getRuleContexts(IdentifierInitializerContext.class);
		}
		public IdentifierInitializerContext identifierInitializer(int i) {
			return getRuleContext(IdentifierInitializerContext.class,i);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public GlobalConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_globalConstantDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterGlobalConstantDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitGlobalConstantDeclaration(this);
		}
	}

	public final GlobalConstantDeclarationContext globalConstantDeclaration() throws RecognitionException {
		GlobalConstantDeclarationContext _localctx = new GlobalConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_globalConstantDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1124);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AttributeStart) {
				{
				setState(1123);
				attributes();
				}
			}

			setState(1126);
			match(Const);
			setState(1127);
			identifierInitializer();
			setState(1132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1128);
				match(Comma);
				setState(1129);
				identifierInitializer();
				}
				}
				setState(1134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1135);
			match(SemiColon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode Enum_() { return getToken(PhpParser.Enum_, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public TerminalNode Implements() { return getToken(PhpParser.Implements, 0); }
		public InterfaceListContext interfaceList() {
			return getRuleContext(InterfaceListContext.class,0);
		}
		public List<EnumItemContext> enumItem() {
			return getRuleContexts(EnumItemContext.class);
		}
		public EnumItemContext enumItem(int i) {
			return getRuleContext(EnumItemContext.class,i);
		}
		public TerminalNode IntType() { return getToken(PhpParser.IntType, 0); }
		public TerminalNode StringType() { return getToken(PhpParser.StringType, 0); }
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitEnumDeclaration(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1137);
			match(Enum_);
			setState(1138);
			identifier();
			setState(1141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Colon) {
				{
				setState(1139);
				match(Colon);
				setState(1140);
				_la = _input.LA(1);
				if ( !(_la==IntType || _la==StringType) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(1145);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Implements) {
				{
				setState(1143);
				match(Implements);
				setState(1144);
				interfaceList();
				}
			}

			setState(1147);
			match(OpenCurlyBracket);
			setState(1151);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4529987906437120L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 2254127685959713L) != 0)) {
				{
				{
				setState(1148);
				enumItem();
				}
				}
				setState(1153);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1154);
			match(CloseCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumItemContext extends ParserRuleContext {
		public TerminalNode Case() { return getToken(PhpParser.Case, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SemiColon() { return getToken(PhpParser.SemiColon, 0); }
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public MemberModifiersContext memberModifiers() {
			return getRuleContext(MemberModifiersContext.class,0);
		}
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public QualifiedNamespaceNameListContext qualifiedNamespaceNameList() {
			return getRuleContext(QualifiedNamespaceNameListContext.class,0);
		}
		public TraitAdaptationsContext traitAdaptations() {
			return getRuleContext(TraitAdaptationsContext.class,0);
		}
		public EnumItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterEnumItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitEnumItem(this);
		}
	}

	public final EnumItemContext enumItem() throws RecognitionException {
		EnumItemContext _localctx = new EnumItemContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_enumItem);
		int _la;
		try {
			setState(1172);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Case:
				enterOuterAlt(_localctx, 1);
				{
				setState(1156);
				match(Case);
				setState(1157);
				identifier();
				setState(1160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Eq) {
					{
					setState(1158);
					match(Eq);
					setState(1159);
					expression(0);
					}
				}

				setState(1162);
				match(SemiColon);
				}
				break;
			case AttributeStart:
			case Abstract:
			case Final:
			case Function_:
			case Private:
			case Protected:
			case Public:
			case Readonly:
			case Static:
				enterOuterAlt(_localctx, 2);
				{
				setState(1165);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Abstract || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 2327872274433L) != 0)) {
					{
					setState(1164);
					memberModifiers();
					}
				}

				setState(1167);
				functionDeclaration();
				}
				break;
			case Use:
				enterOuterAlt(_localctx, 3);
				{
				setState(1168);
				match(Use);
				setState(1169);
				qualifiedNamespaceNameList();
				setState(1170);
				traitAdaptations();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitExpressionList(this);
		}
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1174);
			expression(0);
			setState(1179);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1175);
				match(Comma);
				setState(1176);
				expression(0);
				}
				}
				setState(1181);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesesContext extends ParserRuleContext {
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public YieldExpressionContext yieldExpression() {
			return getRuleContext(YieldExpressionContext.class,0);
		}
		public ParenthesesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parentheses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterParentheses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitParentheses(this);
		}
	}

	public final ParenthesesContext parentheses() throws RecognitionException {
		ParenthesesContext _localctx = new ParenthesesContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_parentheses);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1182);
			match(OpenRoundBracket);
			setState(1185);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				{
				setState(1183);
				expression(0);
				}
				break;
			case 2:
				{
				setState(1184);
				yieldExpression();
				}
				break;
			}
			setState(1187);
			match(CloseRoundBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ChainExpressionContext extends ExpressionContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ChainExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChainExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChainExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SpecialWordExpressionContext extends ExpressionContext {
		public TerminalNode Yield() { return getToken(PhpParser.Yield, 0); }
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IsSet() { return getToken(PhpParser.IsSet, 0); }
		public ChainListContext chainList() {
			return getRuleContext(ChainListContext.class,0);
		}
		public TerminalNode Empty() { return getToken(PhpParser.Empty, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode Eval() { return getToken(PhpParser.Eval, 0); }
		public TerminalNode Exit() { return getToken(PhpParser.Exit, 0); }
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public TerminalNode Include() { return getToken(PhpParser.Include, 0); }
		public TerminalNode IncludeOnce() { return getToken(PhpParser.IncludeOnce, 0); }
		public TerminalNode Require() { return getToken(PhpParser.Require, 0); }
		public TerminalNode RequireOnce() { return getToken(PhpParser.RequireOnce, 0); }
		public TerminalNode Throw() { return getToken(PhpParser.Throw, 0); }
		public SpecialWordExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSpecialWordExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSpecialWordExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayCreationExpressionContext extends ExpressionContext {
		public ArrayCreationContext arrayCreation() {
			return getRuleContext(ArrayCreationContext.class,0);
		}
		public ArrayCreationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayCreationExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BackQuoteStringExpressionContext extends ExpressionContext {
		public TerminalNode BackQuoteString() { return getToken(PhpParser.BackQuoteString, 0); }
		public BackQuoteStringExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBackQuoteStringExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBackQuoteStringExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MatchExpressionContext extends ExpressionContext {
		public MatchExprContext matchExpr() {
			return getRuleContext(MatchExprContext.class,0);
		}
		public MatchExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMatchExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMatchExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LogicalExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LogicalAnd() { return getToken(PhpParser.LogicalAnd, 0); }
		public TerminalNode LogicalXor() { return getToken(PhpParser.LogicalXor, 0); }
		public TerminalNode LogicalOr() { return getToken(PhpParser.LogicalOr, 0); }
		public LogicalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLogicalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLogicalExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrintExpressionContext extends ExpressionContext {
		public TerminalNode Print() { return getToken(PhpParser.Print, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrintExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPrintExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPrintExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ExpressionContext {
		public AssignableContext assignable() {
			return getRuleContext(AssignableContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public AssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PostfixIncDecExpressionContext extends ExpressionContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode Inc() { return getToken(PhpParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(PhpParser.Dec, 0); }
		public PostfixIncDecExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPostfixIncDecExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPostfixIncDecExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CloneExpressionContext extends ExpressionContext {
		public TerminalNode Clone() { return getToken(PhpParser.Clone, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CloneExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCloneExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCloneExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryOperatorExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode Tilde() { return getToken(PhpParser.Tilde, 0); }
		public TerminalNode SuppressWarnings() { return getToken(PhpParser.SuppressWarnings, 0); }
		public TerminalNode Bang() { return getToken(PhpParser.Bang, 0); }
		public TerminalNode Plus() { return getToken(PhpParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(PhpParser.Minus, 0); }
		public UnaryOperatorExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterUnaryOperatorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitUnaryOperatorExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExpressionContext extends ExpressionContext {
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public NewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNewExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNewExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesisExpressionContext extends ExpressionContext {
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public ParenthesisExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterParenthesisExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitParenthesisExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SpaceshipExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Spaceship() { return getToken(PhpParser.Spaceship, 0); }
		public SpaceshipExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSpaceshipExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSpaceshipExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public TerminalNode QuestionMark() { return getToken(PhpParser.QuestionMark, 0); }
		public ConditionalExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConditionalExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConditionalExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullCoalescingExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NullCoalescing() { return getToken(PhpParser.NullCoalescing, 0); }
		public NullCoalescingExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNullCoalescingExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNullCoalescingExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArithmeticExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Pow() { return getToken(PhpParser.Pow, 0); }
		public TerminalNode Asterisk() { return getToken(PhpParser.Asterisk, 0); }
		public TerminalNode Divide() { return getToken(PhpParser.Divide, 0); }
		public TerminalNode Percent() { return getToken(PhpParser.Percent, 0); }
		public TerminalNode Plus() { return getToken(PhpParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(PhpParser.Minus, 0); }
		public TerminalNode Dot() { return getToken(PhpParser.Dot, 0); }
		public ArithmeticExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArithmeticExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArithmeticExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IndexerExpressionContext extends ExpressionContext {
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public TerminalNode OpenSquareBracket() { return getToken(PhpParser.OpenSquareBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseSquareBracket() { return getToken(PhpParser.CloseSquareBracket, 0); }
		public IndexerExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIndexerExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIndexerExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ScalarExpressionContext extends ExpressionContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public TerminalNode Label() { return getToken(PhpParser.Label, 0); }
		public ScalarExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterScalarExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitScalarExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class PrefixIncDecExpressionContext extends ExpressionContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode Inc() { return getToken(PhpParser.Inc, 0); }
		public TerminalNode Dec() { return getToken(PhpParser.Dec, 0); }
		public PrefixIncDecExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPrefixIncDecExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPrefixIncDecExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ShiftLeft() { return getToken(PhpParser.ShiftLeft, 0); }
		public TerminalNode ShiftRight() { return getToken(PhpParser.ShiftRight, 0); }
		public TerminalNode Less() { return getToken(PhpParser.Less, 0); }
		public TerminalNode IsSmallerOrEqual() { return getToken(PhpParser.IsSmallerOrEqual, 0); }
		public TerminalNode Greater() { return getToken(PhpParser.Greater, 0); }
		public TerminalNode IsGreaterOrEqual() { return getToken(PhpParser.IsGreaterOrEqual, 0); }
		public TerminalNode IsIdentical() { return getToken(PhpParser.IsIdentical, 0); }
		public TerminalNode IsNoidentical() { return getToken(PhpParser.IsNoidentical, 0); }
		public TerminalNode IsEqual() { return getToken(PhpParser.IsEqual, 0); }
		public TerminalNode IsNotEq() { return getToken(PhpParser.IsNotEq, 0); }
		public ComparisonExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterComparisonExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitComparisonExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CastExpressionContext extends ExpressionContext {
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public CastOperationContext castOperation() {
			return getRuleContext(CastOperationContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CastExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCastExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class InstanceOfExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode InstanceOf() { return getToken(PhpParser.InstanceOf, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public InstanceOfExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInstanceOfExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInstanceOfExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDestructExpressionContext extends ExpressionContext {
		public ArrayDestructuringContext arrayDestructuring() {
			return getRuleContext(ArrayDestructuringContext.class,0);
		}
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayDestructExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayDestructExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayDestructExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaFunctionExpressionContext extends ExpressionContext {
		public LambdaFunctionExprContext lambdaFunctionExpr() {
			return getRuleContext(LambdaFunctionExprContext.class,0);
		}
		public LambdaFunctionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLambdaFunctionExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLambdaFunctionExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BitwiseExpressionContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public TerminalNode Caret() { return getToken(PhpParser.Caret, 0); }
		public TerminalNode Pipe() { return getToken(PhpParser.Pipe, 0); }
		public TerminalNode BooleanAnd() { return getToken(PhpParser.BooleanAnd, 0); }
		public TerminalNode BooleanOr() { return getToken(PhpParser.BooleanOr, 0); }
		public BitwiseExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterBitwiseExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitBitwiseExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 164;
		enterRecursionRule(_localctx, 164, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1279);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
			case 1:
				{
				_localctx = new CloneExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(1190);
				match(Clone);
				setState(1191);
				expression(48);
				}
				break;
			case 2:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1192);
				newExpr();
				}
				break;
			case 3:
				{
				_localctx = new IndexerExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1193);
				stringConstant();
				setState(1194);
				match(OpenSquareBracket);
				setState(1195);
				expression(0);
				setState(1196);
				match(CloseSquareBracket);
				}
				break;
			case 4:
				{
				_localctx = new CastExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1198);
				match(OpenRoundBracket);
				setState(1199);
				castOperation();
				setState(1200);
				match(CloseRoundBracket);
				setState(1201);
				expression(45);
				}
				break;
			case 5:
				{
				_localctx = new UnaryOperatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1203);
				_la = _input.LA(1);
				if ( !(_la==Tilde || _la==SuppressWarnings) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1204);
				expression(44);
				}
				break;
			case 6:
				{
				_localctx = new UnaryOperatorExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1205);
				_la = _input.LA(1);
				if ( !(((((_la - 200)) & ~0x3f) == 0 && ((1L << (_la - 200)) & 13L) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1206);
				expression(43);
				}
				break;
			case 7:
				{
				_localctx = new PrefixIncDecExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1207);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1208);
				chain();
				}
				break;
			case 8:
				{
				_localctx = new PostfixIncDecExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1209);
				chain();
				setState(1210);
				_la = _input.LA(1);
				if ( !(_la==Inc || _la==Dec) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				break;
			case 9:
				{
				_localctx = new PrintExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1212);
				match(Print);
				setState(1213);
				expression(40);
				}
				break;
			case 10:
				{
				_localctx = new ArrayCreationExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1214);
				arrayCreation();
				}
				break;
			case 11:
				{
				_localctx = new ChainExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1215);
				chain();
				}
				break;
			case 12:
				{
				_localctx = new ScalarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1216);
				constant();
				}
				break;
			case 13:
				{
				_localctx = new ScalarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1217);
				string();
				}
				break;
			case 14:
				{
				_localctx = new ScalarExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1218);
				match(Label);
				}
				break;
			case 15:
				{
				_localctx = new BackQuoteStringExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1219);
				match(BackQuoteString);
				}
				break;
			case 16:
				{
				_localctx = new ParenthesisExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1220);
				parentheses();
				}
				break;
			case 17:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1221);
				match(Yield);
				}
				break;
			case 18:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1222);
				match(List);
				setState(1223);
				match(OpenRoundBracket);
				setState(1224);
				assignmentList();
				setState(1225);
				match(CloseRoundBracket);
				setState(1226);
				match(Eq);
				setState(1227);
				expression(31);
				}
				break;
			case 19:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1229);
				match(IsSet);
				setState(1230);
				match(OpenRoundBracket);
				setState(1231);
				chainList();
				setState(1232);
				match(CloseRoundBracket);
				}
				break;
			case 20:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1234);
				match(Empty);
				setState(1235);
				match(OpenRoundBracket);
				setState(1236);
				chain();
				setState(1237);
				match(CloseRoundBracket);
				}
				break;
			case 21:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1239);
				match(Eval);
				setState(1240);
				match(OpenRoundBracket);
				setState(1241);
				expression(0);
				setState(1242);
				match(CloseRoundBracket);
				}
				break;
			case 22:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1244);
				match(Exit);
				setState(1248);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1245);
					match(OpenRoundBracket);
					setState(1246);
					match(CloseRoundBracket);
					}
					break;
				case 2:
					{
					setState(1247);
					parentheses();
					}
					break;
				}
				}
				break;
			case 23:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1250);
				_la = _input.LA(1);
				if ( !(_la==Include || _la==IncludeOnce) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1251);
				expression(26);
				}
				break;
			case 24:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1252);
				_la = _input.LA(1);
				if ( !(_la==Require || _la==RequireOnce) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1253);
				expression(25);
				}
				break;
			case 25:
				{
				_localctx = new LambdaFunctionExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1254);
				lambdaFunctionExpr();
				}
				break;
			case 26:
				{
				_localctx = new MatchExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1255);
				matchExpr();
				}
				break;
			case 27:
				{
				_localctx = new SpecialWordExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1256);
				match(Throw);
				setState(1257);
				expression(7);
				}
				break;
			case 28:
				{
				_localctx = new ArrayDestructExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1258);
				arrayDestructuring();
				setState(1259);
				match(Eq);
				setState(1260);
				expression(6);
				}
				break;
			case 29:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1262);
				assignable();
				setState(1263);
				assignmentOperator();
				setState(1265);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AttributeStart) {
					{
					setState(1264);
					attributes();
					}
				}

				setState(1267);
				expression(5);
				}
				break;
			case 30:
				{
				_localctx = new AssignmentExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(1269);
				assignable();
				setState(1270);
				match(Eq);
				setState(1272);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AttributeStart) {
					{
					setState(1271);
					attributes();
					}
				}

				setState(1274);
				match(Ampersand);
				setState(1277);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,139,_ctx) ) {
				case 1:
					{
					setState(1275);
					chain();
					}
					break;
				case 2:
					{
					setState(1276);
					newExpr();
					}
					break;
				}
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1341);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1339);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
					case 1:
						{
						_localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1281);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(1282);
						((ArithmeticExpressionContext)_localctx).op = match(Pow);
						setState(1283);
						expression(22);
						}
						break;
					case 2:
						{
						_localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1284);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(1285);
						((ArithmeticExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 7L) != 0)) ) {
							((ArithmeticExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1286);
						expression(21);
						}
						break;
					case 3:
						{
						_localctx = new ArithmeticExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1287);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(1288);
						((ArithmeticExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 202)) & ~0x3f) == 0 && ((1L << (_la - 202)) & 259L) != 0)) ) {
							((ArithmeticExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1289);
						expression(20);
						}
						break;
					case 4:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1290);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1291);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ShiftLeft || _la==ShiftRight) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1292);
						expression(19);
						}
						break;
					case 5:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1293);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(1294);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 171)) & ~0x3f) == 0 && ((1L << (_la - 171)) & 100663299L) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1295);
						expression(18);
						}
						break;
					case 6:
						{
						_localctx = new ComparisonExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1296);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(1297);
						((ComparisonExpressionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 167)) & ~0x3f) == 0 && ((1L << (_la - 167)) & 15L) != 0)) ) {
							((ComparisonExpressionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1298);
						expression(17);
						}
						break;
					case 7:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1299);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(1300);
						((BitwiseExpressionContext)_localctx).op = match(Ampersand);
						setState(1301);
						expression(16);
						}
						break;
					case 8:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1302);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1303);
						((BitwiseExpressionContext)_localctx).op = match(Caret);
						setState(1304);
						expression(15);
						}
						break;
					case 9:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1305);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1306);
						((BitwiseExpressionContext)_localctx).op = match(Pipe);
						setState(1307);
						expression(14);
						}
						break;
					case 10:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1308);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1309);
						((BitwiseExpressionContext)_localctx).op = match(BooleanAnd);
						setState(1310);
						expression(13);
						}
						break;
					case 11:
						{
						_localctx = new BitwiseExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1311);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1312);
						((BitwiseExpressionContext)_localctx).op = match(BooleanOr);
						setState(1313);
						expression(12);
						}
						break;
					case 12:
						{
						_localctx = new ConditionalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1314);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1315);
						((ConditionalExpressionContext)_localctx).op = match(QuestionMark);
						setState(1317);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
							{
							setState(1316);
							expression(0);
							}
						}

						setState(1319);
						match(Colon);
						setState(1320);
						expression(11);
						}
						break;
					case 13:
						{
						_localctx = new NullCoalescingExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1321);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1322);
						((NullCoalescingExpressionContext)_localctx).op = match(NullCoalescing);
						setState(1323);
						expression(10);
						}
						break;
					case 14:
						{
						_localctx = new SpaceshipExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1324);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1325);
						((SpaceshipExpressionContext)_localctx).op = match(Spaceship);
						setState(1326);
						expression(9);
						}
						break;
					case 15:
						{
						_localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1327);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1328);
						((LogicalExpressionContext)_localctx).op = match(LogicalAnd);
						setState(1329);
						expression(4);
						}
						break;
					case 16:
						{
						_localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1330);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1331);
						((LogicalExpressionContext)_localctx).op = match(LogicalXor);
						setState(1332);
						expression(3);
						}
						break;
					case 17:
						{
						_localctx = new LogicalExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1333);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(1334);
						((LogicalExpressionContext)_localctx).op = match(LogicalOr);
						setState(1335);
						expression(2);
						}
						break;
					case 18:
						{
						_localctx = new InstanceOfExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1336);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(1337);
						match(InstanceOf);
						setState(1338);
						typeRef();
						}
						break;
					}
					} 
				}
				setState(1343);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,143,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableContext extends ParserRuleContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ArrayCreationContext arrayCreation() {
			return getRuleContext(ArrayCreationContext.class,0);
		}
		public AssignableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignable(this);
		}
	}

	public final AssignableContext assignable() throws RecognitionException {
		AssignableContext _localctx = new AssignableContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_assignable);
		try {
			setState(1346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1344);
				chain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1345);
				arrayCreation();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayCreationContext extends ParserRuleContext {
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public List<TerminalNode> OpenSquareBracket() { return getTokens(PhpParser.OpenSquareBracket); }
		public TerminalNode OpenSquareBracket(int i) {
			return getToken(PhpParser.OpenSquareBracket, i);
		}
		public List<TerminalNode> CloseSquareBracket() { return getTokens(PhpParser.CloseSquareBracket); }
		public TerminalNode CloseSquareBracket(int i) {
			return getToken(PhpParser.CloseSquareBracket, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayItemListContext arrayItemList() {
			return getRuleContext(ArrayItemListContext.class,0);
		}
		public ArrayCreationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayCreation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayCreation(this);
		}
	}

	public final ArrayCreationContext arrayCreation() throws RecognitionException {
		ArrayCreationContext _localctx = new ArrayCreationContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_arrayCreation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1359);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Array:
				{
				setState(1348);
				match(Array);
				setState(1349);
				match(OpenRoundBracket);
				setState(1351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138193L) != 0)) {
					{
					setState(1350);
					arrayItemList();
					}
				}

				setState(1353);
				match(CloseRoundBracket);
				}
				break;
			case OpenSquareBracket:
				{
				setState(1354);
				match(OpenSquareBracket);
				setState(1356);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138193L) != 0)) {
					{
					setState(1355);
					arrayItemList();
					}
				}

				setState(1358);
				match(CloseSquareBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				{
				setState(1361);
				match(OpenSquareBracket);
				setState(1362);
				expression(0);
				setState(1363);
				match(CloseSquareBracket);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayDestructuringContext extends ParserRuleContext {
		public TerminalNode OpenSquareBracket() { return getToken(PhpParser.OpenSquareBracket, 0); }
		public List<IndexedDestructItemContext> indexedDestructItem() {
			return getRuleContexts(IndexedDestructItemContext.class);
		}
		public IndexedDestructItemContext indexedDestructItem(int i) {
			return getRuleContext(IndexedDestructItemContext.class,i);
		}
		public TerminalNode CloseSquareBracket() { return getToken(PhpParser.CloseSquareBracket, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public List<KeyedDestructItemContext> keyedDestructItem() {
			return getRuleContexts(KeyedDestructItemContext.class);
		}
		public KeyedDestructItemContext keyedDestructItem(int i) {
			return getRuleContext(KeyedDestructItemContext.class,i);
		}
		public ArrayDestructuringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDestructuring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayDestructuring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayDestructuring(this);
		}
	}

	public final ArrayDestructuringContext arrayDestructuring() throws RecognitionException {
		ArrayDestructuringContext _localctx = new ArrayDestructuringContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_arrayDestructuring);
		int _la;
		try {
			int _alt;
			setState(1412);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1367);
				match(OpenSquareBracket);
				setState(1371);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1368);
					match(Comma);
					}
					}
					setState(1373);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1374);
				indexedDestructItem();
				setState(1383);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1376); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1375);
							match(Comma);
							}
							}
							setState(1378); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==Comma );
						setState(1380);
						indexedDestructItem();
						}
						} 
					}
					setState(1385);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,151,_ctx);
				}
				setState(1389);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Comma) {
					{
					{
					setState(1386);
					match(Comma);
					}
					}
					setState(1391);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1392);
				match(CloseSquareBracket);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1394);
				match(OpenSquareBracket);
				setState(1395);
				keyedDestructItem();
				setState(1404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1397); 
						_errHandler.sync(this);
						_la = _input.LA(1);
						do {
							{
							{
							setState(1396);
							match(Comma);
							}
							}
							setState(1399); 
							_errHandler.sync(this);
							_la = _input.LA(1);
						} while ( _la==Comma );
						setState(1401);
						keyedDestructItem();
						}
						} 
					}
					setState(1406);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
				}
				setState(1408);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1407);
					match(Comma);
					}
				}

				setState(1410);
				match(CloseSquareBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexedDestructItemContext extends ParserRuleContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public IndexedDestructItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexedDestructItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIndexedDestructItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIndexedDestructItem(this);
		}
	}

	public final IndexedDestructItemContext indexedDestructItem() throws RecognitionException {
		IndexedDestructItemContext _localctx = new IndexedDestructItemContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_indexedDestructItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1415);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(1414);
				match(Ampersand);
				}
			}

			setState(1417);
			chain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyedDestructItemContext extends ParserRuleContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DoubleArrow() { return getToken(PhpParser.DoubleArrow, 0); }
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public KeyedDestructItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedDestructItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterKeyedDestructItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitKeyedDestructItem(this);
		}
	}

	public final KeyedDestructItemContext keyedDestructItem() throws RecognitionException {
		KeyedDestructItemContext _localctx = new KeyedDestructItemContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_keyedDestructItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1422);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,158,_ctx) ) {
			case 1:
				{
				setState(1419);
				expression(0);
				setState(1420);
				match(DoubleArrow);
				}
				break;
			}
			setState(1425);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(1424);
				match(Ampersand);
				}
			}

			setState(1427);
			chain();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaFunctionExprContext extends ParserRuleContext {
		public TerminalNode Function_() { return getToken(PhpParser.Function_, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public BlockStatementContext blockStatement() {
			return getRuleContext(BlockStatementContext.class,0);
		}
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public LambdaFunctionUseVarsContext lambdaFunctionUseVars() {
			return getRuleContext(LambdaFunctionUseVarsContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public TypeHintContext typeHint() {
			return getRuleContext(TypeHintContext.class,0);
		}
		public TerminalNode LambdaFn() { return getToken(PhpParser.LambdaFn, 0); }
		public TerminalNode DoubleArrow() { return getToken(PhpParser.DoubleArrow, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdaFunctionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunctionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLambdaFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLambdaFunctionExpr(this);
		}
	}

	public final LambdaFunctionExprContext lambdaFunctionExpr() throws RecognitionException {
		LambdaFunctionExprContext _localctx = new LambdaFunctionExprContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_lambdaFunctionExpr);
		int _la;
		try {
			setState(1455);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Function_:
			case Static:
				enterOuterAlt(_localctx, 1);
				{
				setState(1430);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Static) {
					{
					setState(1429);
					match(Static);
					}
				}

				setState(1432);
				match(Function_);
				setState(1434);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ampersand) {
					{
					setState(1433);
					match(Ampersand);
					}
				}

				setState(1436);
				match(OpenRoundBracket);
				setState(1437);
				formalParameterList();
				setState(1438);
				match(CloseRoundBracket);
				setState(1440);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Use) {
					{
					setState(1439);
					lambdaFunctionUseVars();
					}
				}

				setState(1444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Colon) {
					{
					setState(1442);
					match(Colon);
					setState(1443);
					typeHint(0);
					}
				}

				setState(1446);
				blockStatement();
				}
				break;
			case LambdaFn:
				enterOuterAlt(_localctx, 2);
				{
				setState(1448);
				match(LambdaFn);
				setState(1449);
				match(OpenRoundBracket);
				setState(1450);
				formalParameterList();
				setState(1451);
				match(CloseRoundBracket);
				setState(1452);
				match(DoubleArrow);
				setState(1453);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchExprContext extends ParserRuleContext {
		public TerminalNode Match_() { return getToken(PhpParser.Match_, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public List<MatchItemContext> matchItem() {
			return getRuleContexts(MatchItemContext.class);
		}
		public MatchItemContext matchItem(int i) {
			return getRuleContext(MatchItemContext.class,i);
		}
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public MatchExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMatchExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMatchExpr(this);
		}
	}

	public final MatchExprContext matchExpr() throws RecognitionException {
		MatchExprContext _localctx = new MatchExprContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_matchExpr);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1457);
			match(Match_);
			setState(1458);
			match(OpenRoundBracket);
			setState(1459);
			expression(0);
			setState(1460);
			match(CloseRoundBracket);
			setState(1461);
			match(OpenCurlyBracket);
			setState(1462);
			matchItem();
			setState(1467);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1463);
					match(Comma);
					setState(1464);
					matchItem();
					}
					} 
				}
				setState(1469);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
			}
			setState(1471);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(1470);
				match(Comma);
				}
			}

			setState(1473);
			match(CloseCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MatchItemContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DoubleArrow() { return getToken(PhpParser.DoubleArrow, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public MatchItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_matchItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMatchItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMatchItem(this);
		}
	}

	public final MatchItemContext matchItem() throws RecognitionException {
		MatchItemContext _localctx = new MatchItemContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_matchItem);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1475);
			expression(0);
			setState(1480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1476);
				match(Comma);
				setState(1477);
				expression(0);
				}
				}
				setState(1482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1483);
			match(DoubleArrow);
			setState(1484);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NewExprContext extends ParserRuleContext {
		public TerminalNode New() { return getToken(PhpParser.New, 0); }
		public TypeRefContext typeRef() {
			return getRuleContext(TypeRefContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public NewExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_newExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNewExpr(this);
		}
	}

	public final NewExprContext newExpr() throws RecognitionException {
		NewExprContext _localctx = new NewExprContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_newExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1486);
			match(New);
			setState(1487);
			typeRef();
			setState(1489);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,168,_ctx) ) {
			case 1:
				{
				setState(1488);
				arguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode Eq() { return getToken(PhpParser.Eq, 0); }
		public TerminalNode PlusEqual() { return getToken(PhpParser.PlusEqual, 0); }
		public TerminalNode MinusEqual() { return getToken(PhpParser.MinusEqual, 0); }
		public TerminalNode MulEqual() { return getToken(PhpParser.MulEqual, 0); }
		public TerminalNode PowEqual() { return getToken(PhpParser.PowEqual, 0); }
		public TerminalNode DivEqual() { return getToken(PhpParser.DivEqual, 0); }
		public TerminalNode Concaequal() { return getToken(PhpParser.Concaequal, 0); }
		public TerminalNode ModEqual() { return getToken(PhpParser.ModEqual, 0); }
		public TerminalNode AndEqual() { return getToken(PhpParser.AndEqual, 0); }
		public TerminalNode OrEqual() { return getToken(PhpParser.OrEqual, 0); }
		public TerminalNode XorEqual() { return getToken(PhpParser.XorEqual, 0); }
		public TerminalNode ShiftLeftEqual() { return getToken(PhpParser.ShiftLeftEqual, 0); }
		public TerminalNode ShiftRightEqual() { return getToken(PhpParser.ShiftRightEqual, 0); }
		public TerminalNode NullCoalescingEqual() { return getToken(PhpParser.NullCoalescingEqual, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1491);
			_la = _input.LA(1);
			if ( !(((((_la - 173)) & ~0x3f) == 0 && ((1L << (_la - 173)) & 281474976784375L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class YieldExpressionContext extends ParserRuleContext {
		public TerminalNode Yield() { return getToken(PhpParser.Yield, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode From() { return getToken(PhpParser.From, 0); }
		public TerminalNode DoubleArrow() { return getToken(PhpParser.DoubleArrow, 0); }
		public YieldExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yieldExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterYieldExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitYieldExpression(this);
		}
	}

	public final YieldExpressionContext yieldExpression() throws RecognitionException {
		YieldExpressionContext _localctx = new YieldExpressionContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_yieldExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1493);
			match(Yield);
			setState(1501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,170,_ctx) ) {
			case 1:
				{
				setState(1494);
				expression(0);
				setState(1497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleArrow) {
					{
					setState(1495);
					match(DoubleArrow);
					setState(1496);
					expression(0);
					}
				}

				}
				break;
			case 2:
				{
				setState(1499);
				match(From);
				setState(1500);
				expression(0);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayItemListContext extends ParserRuleContext {
		public List<ArrayItemContext> arrayItem() {
			return getRuleContexts(ArrayItemContext.class);
		}
		public ArrayItemContext arrayItem(int i) {
			return getRuleContext(ArrayItemContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public ArrayItemListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayItemList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayItemList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayItemList(this);
		}
	}

	public final ArrayItemListContext arrayItemList() throws RecognitionException {
		ArrayItemListContext _localctx = new ArrayItemListContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_arrayItemList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1503);
			arrayItem();
			setState(1508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1504);
					match(Comma);
					setState(1505);
					arrayItem();
					}
					} 
				}
				setState(1510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,171,_ctx);
			}
			setState(1512);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				{
				setState(1511);
				match(Comma);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayItemContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DoubleArrow() { return getToken(PhpParser.DoubleArrow, 0); }
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ArrayItemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayItem; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArrayItem(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArrayItem(this);
		}
	}

	public final ArrayItemContext arrayItem() throws RecognitionException {
		ArrayItemContext _localctx = new ArrayItemContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_arrayItem);
		int _la;
		try {
			setState(1526);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,175,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1514);
				expression(0);
				setState(1517);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DoubleArrow) {
					{
					setState(1515);
					match(DoubleArrow);
					setState(1516);
					expression(0);
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1522);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
					{
					setState(1519);
					expression(0);
					setState(1520);
					match(DoubleArrow);
					}
				}

				setState(1524);
				match(Ampersand);
				setState(1525);
				chain();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaFunctionUseVarsContext extends ParserRuleContext {
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public List<LambdaFunctionUseVarContext> lambdaFunctionUseVar() {
			return getRuleContexts(LambdaFunctionUseVarContext.class);
		}
		public LambdaFunctionUseVarContext lambdaFunctionUseVar(int i) {
			return getRuleContext(LambdaFunctionUseVarContext.class,i);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public LambdaFunctionUseVarsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunctionUseVars; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLambdaFunctionUseVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLambdaFunctionUseVars(this);
		}
	}

	public final LambdaFunctionUseVarsContext lambdaFunctionUseVars() throws RecognitionException {
		LambdaFunctionUseVarsContext _localctx = new LambdaFunctionUseVarsContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_lambdaFunctionUseVars);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1528);
			match(Use);
			setState(1529);
			match(OpenRoundBracket);
			setState(1530);
			lambdaFunctionUseVar();
			setState(1535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1531);
				match(Comma);
				setState(1532);
				lambdaFunctionUseVar();
				}
				}
				setState(1537);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1538);
			match(CloseRoundBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaFunctionUseVarContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public LambdaFunctionUseVarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaFunctionUseVar; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLambdaFunctionUseVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLambdaFunctionUseVar(this);
		}
	}

	public final LambdaFunctionUseVarContext lambdaFunctionUseVar() throws RecognitionException {
		LambdaFunctionUseVarContext _localctx = new LambdaFunctionUseVarContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_lambdaFunctionUseVar);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Ampersand) {
				{
				setState(1540);
				match(Ampersand);
				}
			}

			setState(1543);
			match(VarName);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedStaticTypeRefContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public GenericDynamicArgsContext genericDynamicArgs() {
			return getRuleContext(GenericDynamicArgsContext.class,0);
		}
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public QualifiedStaticTypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedStaticTypeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterQualifiedStaticTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitQualifiedStaticTypeRef(this);
		}
	}

	public final QualifiedStaticTypeRefContext qualifiedStaticTypeRef() throws RecognitionException {
		QualifiedStaticTypeRefContext _localctx = new QualifiedStaticTypeRefContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_qualifiedStaticTypeRef);
		try {
			setState(1550);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,179,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1545);
				qualifiedNamespaceName();
				setState(1547);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,178,_ctx) ) {
				case 1:
					{
					setState(1546);
					genericDynamicArgs();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1549);
				match(Static);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeRefContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public IndirectTypeRefContext indirectTypeRef() {
			return getRuleContext(IndirectTypeRefContext.class,0);
		}
		public GenericDynamicArgsContext genericDynamicArgs() {
			return getRuleContext(GenericDynamicArgsContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public AnonymousClassContext anonymousClass() {
			return getRuleContext(AnonymousClassContext.class,0);
		}
		public TypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitTypeRef(this);
		}
	}

	public final TypeRefContext typeRef() throws RecognitionException {
		TypeRefContext _localctx = new TypeRefContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_typeRef);
		try {
			setState(1562);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1554);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
				case 1:
					{
					setState(1552);
					qualifiedNamespaceName();
					}
					break;
				case 2:
					{
					setState(1553);
					indirectTypeRef();
					}
					break;
				}
				setState(1557);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,181,_ctx) ) {
				case 1:
					{
					setState(1556);
					genericDynamicArgs();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1559);
				primitiveType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1560);
				match(Static);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1561);
				anonymousClass();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousClassContext extends ParserRuleContext {
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public ClassEntryTypeContext classEntryType() {
			return getRuleContext(ClassEntryTypeContext.class,0);
		}
		public TerminalNode Interface() { return getToken(PhpParser.Interface, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AttributesContext attributes() {
			return getRuleContext(AttributesContext.class,0);
		}
		public TerminalNode Private() { return getToken(PhpParser.Private, 0); }
		public ModifierContext modifier() {
			return getRuleContext(ModifierContext.class,0);
		}
		public TerminalNode Partial() { return getToken(PhpParser.Partial, 0); }
		public List<ClassStatementContext> classStatement() {
			return getRuleContexts(ClassStatementContext.class);
		}
		public ClassStatementContext classStatement(int i) {
			return getRuleContext(ClassStatementContext.class,i);
		}
		public TypeParameterListInBracketsContext typeParameterListInBrackets() {
			return getRuleContext(TypeParameterListInBracketsContext.class,0);
		}
		public TerminalNode Extends() { return getToken(PhpParser.Extends, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public TerminalNode Implements() { return getToken(PhpParser.Implements, 0); }
		public InterfaceListContext interfaceList() {
			return getRuleContext(InterfaceListContext.class,0);
		}
		public AnonymousClassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousClass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAnonymousClass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAnonymousClass(this);
		}
	}

	public final AnonymousClassContext anonymousClass() throws RecognitionException {
		AnonymousClassContext _localctx = new AnonymousClassContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_anonymousClass);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1565);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AttributeStart) {
				{
				setState(1564);
				attributes();
				}
			}

			setState(1568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Private) {
				{
				setState(1567);
				match(Private);
				}
			}

			setState(1571);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Abstract || _la==Final) {
				{
				setState(1570);
				modifier();
				}
			}

			setState(1574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Partial) {
				{
				setState(1573);
				match(Partial);
				}
			}

			setState(1597);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Class:
			case Trait:
				{
				setState(1576);
				classEntryType();
				setState(1578);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(1577);
					typeParameterListInBrackets();
					}
				}

				setState(1582);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Extends) {
					{
					setState(1580);
					match(Extends);
					setState(1581);
					qualifiedStaticTypeRef();
					}
				}

				setState(1586);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Implements) {
					{
					setState(1584);
					match(Implements);
					setState(1585);
					interfaceList();
					}
				}

				}
				break;
			case Interface:
				{
				setState(1588);
				match(Interface);
				setState(1589);
				identifier();
				setState(1591);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Lgeneric) {
					{
					setState(1590);
					typeParameterListInBrackets();
					}
				}

				setState(1595);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Extends) {
					{
					setState(1593);
					match(Extends);
					setState(1594);
					interfaceList();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1599);
			match(OpenCurlyBracket);
			setState(1603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 72083982316994560L) != 0) || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 6757727313330209L) != 0)) {
				{
				{
				setState(1600);
				classStatement();
				}
				}
				setState(1605);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1606);
			match(CloseCurlyBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndirectTypeRefContext extends ParserRuleContext {
		public ChainBaseContext chainBase() {
			return getRuleContext(ChainBaseContext.class,0);
		}
		public List<TerminalNode> ObjectOperator() { return getTokens(PhpParser.ObjectOperator); }
		public TerminalNode ObjectOperator(int i) {
			return getToken(PhpParser.ObjectOperator, i);
		}
		public List<KeyedFieldNameContext> keyedFieldName() {
			return getRuleContexts(KeyedFieldNameContext.class);
		}
		public KeyedFieldNameContext keyedFieldName(int i) {
			return getRuleContext(KeyedFieldNameContext.class,i);
		}
		public IndirectTypeRefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indirectTypeRef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIndirectTypeRef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIndirectTypeRef(this);
		}
	}

	public final IndirectTypeRefContext indirectTypeRef() throws RecognitionException {
		IndirectTypeRefContext _localctx = new IndirectTypeRefContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_indirectTypeRef);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1608);
			chainBase();
			setState(1613);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1609);
					match(ObjectOperator);
					setState(1610);
					keyedFieldName();
					}
					} 
				}
				setState(1615);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNamespaceNameContext extends ParserRuleContext {
		public NamespaceNameListContext namespaceNameList() {
			return getRuleContext(NamespaceNameListContext.class,0);
		}
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public TerminalNode NamespaceSeparator() { return getToken(PhpParser.NamespaceSeparator, 0); }
		public QualifiedNamespaceNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNamespaceName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterQualifiedNamespaceName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitQualifiedNamespaceName(this);
		}
	}

	public final QualifiedNamespaceNameContext qualifiedNamespaceName() throws RecognitionException {
		QualifiedNamespaceNameContext _localctx = new QualifiedNamespaceNameContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_qualifiedNamespaceName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1617);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				{
				setState(1616);
				match(Namespace);
				}
				break;
			}
			setState(1620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NamespaceSeparator) {
				{
				setState(1619);
				match(NamespaceSeparator);
				}
			}

			setState(1622);
			namespaceNameList();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamespaceNameListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> NamespaceSeparator() { return getTokens(PhpParser.NamespaceSeparator); }
		public TerminalNode NamespaceSeparator(int i) {
			return getToken(PhpParser.NamespaceSeparator, i);
		}
		public NamespaceNameTailContext namespaceNameTail() {
			return getRuleContext(NamespaceNameTailContext.class,0);
		}
		public NamespaceNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNamespaceNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNamespaceNameList(this);
		}
	}

	public final NamespaceNameListContext namespaceNameList() throws RecognitionException {
		NamespaceNameListContext _localctx = new NamespaceNameListContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_namespaceNameList);
		try {
			int _alt;
			setState(1637);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1624);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1625);
				identifier();
				setState(1630);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1626);
						match(NamespaceSeparator);
						setState(1627);
						identifier();
						}
						} 
					}
					setState(1632);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,197,_ctx);
				}
				setState(1635);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
				case 1:
					{
					setState(1633);
					match(NamespaceSeparator);
					setState(1634);
					namespaceNameTail();
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NamespaceNameTailContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public List<NamespaceNameTailContext> namespaceNameTail() {
			return getRuleContexts(NamespaceNameTailContext.class);
		}
		public NamespaceNameTailContext namespaceNameTail(int i) {
			return getRuleContext(NamespaceNameTailContext.class,i);
		}
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public NamespaceNameTailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_namespaceNameTail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNamespaceNameTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNamespaceNameTail(this);
		}
	}

	public final NamespaceNameTailContext namespaceNameTail() throws RecognitionException {
		NamespaceNameTailContext _localctx = new NamespaceNameTailContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_namespaceNameTail);
		int _la;
		try {
			int _alt;
			setState(1658);
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
				setState(1639);
				identifier();
				setState(1642);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
				case 1:
					{
					setState(1640);
					match(As);
					setState(1641);
					identifier();
					}
					break;
				}
				}
				break;
			case OpenCurlyBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1644);
				match(OpenCurlyBracket);
				setState(1645);
				namespaceNameTail();
				setState(1650);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1646);
						match(Comma);
						setState(1647);
						namespaceNameTail();
						}
						} 
					}
					setState(1652);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				}
				setState(1654);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Comma) {
					{
					setState(1653);
					match(Comma);
					}
				}

				setState(1656);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNamespaceNameListContext extends ParserRuleContext {
		public List<QualifiedNamespaceNameContext> qualifiedNamespaceName() {
			return getRuleContexts(QualifiedNamespaceNameContext.class);
		}
		public QualifiedNamespaceNameContext qualifiedNamespaceName(int i) {
			return getRuleContext(QualifiedNamespaceNameContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public QualifiedNamespaceNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNamespaceNameList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterQualifiedNamespaceNameList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitQualifiedNamespaceNameList(this);
		}
	}

	public final QualifiedNamespaceNameListContext qualifiedNamespaceNameList() throws RecognitionException {
		QualifiedNamespaceNameListContext _localctx = new QualifiedNamespaceNameListContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_qualifiedNamespaceNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1660);
			qualifiedNamespaceName();
			setState(1665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1661);
				match(Comma);
				setState(1662);
				qualifiedNamespaceName();
				}
				}
				setState(1667);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public List<ActualArgumentContext> actualArgument() {
			return getRuleContexts(ActualArgumentContext.class);
		}
		public ActualArgumentContext actualArgument(int i) {
			return getRuleContext(ActualArgumentContext.class,i);
		}
		public YieldExpressionContext yieldExpression() {
			return getRuleContext(YieldExpressionContext.class,0);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArguments(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_arguments);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1668);
			match(OpenRoundBracket);
			setState(1678);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,206,_ctx) ) {
			case 1:
				{
				setState(1669);
				actualArgument();
				setState(1674);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,205,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1670);
						match(Comma);
						setState(1671);
						actualArgument();
						}
						} 
					}
					setState(1676);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,205,_ctx);
				}
				}
				break;
			case 2:
				{
				setState(1677);
				yieldExpression();
				}
				break;
			}
			setState(1681);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Comma) {
				{
				setState(1680);
				match(Comma);
				}
			}

			setState(1683);
			match(CloseRoundBracket);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActualArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArgumentNameContext argumentName() {
			return getRuleContext(ArgumentNameContext.class,0);
		}
		public TerminalNode Ellipsis() { return getToken(PhpParser.Ellipsis, 0); }
		public TerminalNode Ampersand() { return getToken(PhpParser.Ampersand, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public ActualArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterActualArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitActualArgument(this);
		}
	}

	public final ActualArgumentContext actualArgument() throws RecognitionException {
		ActualArgumentContext _localctx = new ActualArgumentContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_actualArgument);
		int _la;
		try {
			setState(1694);
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
				setState(1686);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,208,_ctx) ) {
				case 1:
					{
					setState(1685);
					argumentName();
					}
					break;
				}
				setState(1689);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==Ellipsis) {
					{
					setState(1688);
					match(Ellipsis);
					}
				}

				setState(1691);
				expression(0);
				}
				break;
			case Ampersand:
				enterOuterAlt(_localctx, 2);
				{
				setState(1692);
				match(Ampersand);
				setState(1693);
				chain();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Colon() { return getToken(PhpParser.Colon, 0); }
		public ArgumentNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterArgumentName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitArgumentName(this);
		}
	}

	public final ArgumentNameContext argumentName() throws RecognitionException {
		ArgumentNameContext _localctx = new ArgumentNameContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_argumentName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1696);
			identifier();
			setState(1697);
			match(Colon);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantInitializerContext extends ParserRuleContext {
		public List<ConstantContext> constant() {
			return getRuleContexts(ConstantContext.class);
		}
		public ConstantContext constant(int i) {
			return getRuleContext(ConstantContext.class,i);
		}
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
		}
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public ArrayItemListContext arrayItemList() {
			return getRuleContext(ArrayItemListContext.class,0);
		}
		public TerminalNode Comma() { return getToken(PhpParser.Comma, 0); }
		public TerminalNode OpenSquareBracket() { return getToken(PhpParser.OpenSquareBracket, 0); }
		public TerminalNode CloseSquareBracket() { return getToken(PhpParser.CloseSquareBracket, 0); }
		public ConstantInitializerContext constantInitializer() {
			return getRuleContext(ConstantInitializerContext.class,0);
		}
		public TerminalNode Plus() { return getToken(PhpParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(PhpParser.Minus, 0); }
		public List<TerminalNode> Dot() { return getTokens(PhpParser.Dot); }
		public TerminalNode Dot(int i) {
			return getToken(PhpParser.Dot, i);
		}
		public ConstantInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConstantInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConstantInitializer(this);
		}
	}

	public final ConstantInitializerContext constantInitializer() throws RecognitionException {
		ConstantInitializerContext _localctx = new ConstantInitializerContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_constantInitializer);
		int _la;
		try {
			setState(1734);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1699);
				constant();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1700);
				string();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1701);
				match(Array);
				setState(1702);
				match(OpenRoundBracket);
				setState(1707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138193L) != 0)) {
					{
					setState(1703);
					arrayItemList();
					setState(1705);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(1704);
						match(Comma);
						}
					}

					}
				}

				setState(1709);
				match(CloseRoundBracket);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1710);
				match(OpenSquareBracket);
				setState(1715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138193L) != 0)) {
					{
					setState(1711);
					arrayItemList();
					setState(1713);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==Comma) {
						{
						setState(1712);
						match(Comma);
						}
					}

					}
				}

				setState(1717);
				match(CloseSquareBracket);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1718);
				_la = _input.LA(1);
				if ( !(_la==Plus || _la==Minus) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1719);
				constantInitializer();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1722);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
				case 1:
					{
					setState(1720);
					string();
					}
					break;
				case 2:
					{
					setState(1721);
					constant();
					}
					break;
				}
				setState(1731);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==Dot) {
					{
					{
					setState(1724);
					match(Dot);
					setState(1727);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,216,_ctx) ) {
					case 1:
						{
						setState(1725);
						string();
						}
						break;
					case 2:
						{
						setState(1726);
						constant();
						}
						break;
					}
					}
					}
					setState(1733);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode Null() { return getToken(PhpParser.Null, 0); }
		public LiteralConstantContext literalConstant() {
			return getRuleContext(LiteralConstantContext.class,0);
		}
		public MagicConstantContext magicConstant() {
			return getRuleContext(MagicConstantContext.class,0);
		}
		public ClassConstantContext classConstant() {
			return getRuleContext(ClassConstantContext.class,0);
		}
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitConstant(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_constant);
		try {
			setState(1741);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,219,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1736);
				match(Null);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1737);
				literalConstant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1738);
				magicConstant();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1739);
				classConstant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1740);
				qualifiedNamespaceName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralConstantContext extends ParserRuleContext {
		public TerminalNode Real() { return getToken(PhpParser.Real, 0); }
		public TerminalNode BooleanConstant() { return getToken(PhpParser.BooleanConstant, 0); }
		public NumericConstantContext numericConstant() {
			return getRuleContext(NumericConstantContext.class,0);
		}
		public StringConstantContext stringConstant() {
			return getRuleContext(StringConstantContext.class,0);
		}
		public LiteralConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterLiteralConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitLiteralConstant(this);
		}
	}

	public final LiteralConstantContext literalConstant() throws RecognitionException {
		LiteralConstantContext _localctx = new LiteralConstantContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_literalConstant);
		try {
			setState(1747);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Real:
				enterOuterAlt(_localctx, 1);
				{
				setState(1743);
				match(Real);
				}
				break;
			case BooleanConstant:
				enterOuterAlt(_localctx, 2);
				{
				setState(1744);
				match(BooleanConstant);
				}
				break;
			case Octal:
			case Decimal:
			case Hex:
			case Binary:
				enterOuterAlt(_localctx, 3);
				{
				setState(1745);
				numericConstant();
				}
				break;
			case Label:
				enterOuterAlt(_localctx, 4);
				{
				setState(1746);
				stringConstant();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NumericConstantContext extends ParserRuleContext {
		public TerminalNode Octal() { return getToken(PhpParser.Octal, 0); }
		public TerminalNode Decimal() { return getToken(PhpParser.Decimal, 0); }
		public TerminalNode Hex() { return getToken(PhpParser.Hex, 0); }
		public TerminalNode Binary() { return getToken(PhpParser.Binary, 0); }
		public NumericConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterNumericConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitNumericConstant(this);
		}
	}

	public final NumericConstantContext numericConstant() throws RecognitionException {
		NumericConstantContext _localctx = new NumericConstantContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_numericConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1749);
			_la = _input.LA(1);
			if ( !(((((_la - 226)) & ~0x3f) == 0 && ((1L << (_la - 226)) & 27L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassConstantContext extends ParserRuleContext {
		public TerminalNode DoubleColon() { return getToken(PhpParser.DoubleColon, 0); }
		public TerminalNode Class() { return getToken(PhpParser.Class, 0); }
		public TerminalNode Parent_() { return getToken(PhpParser.Parent_, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode Constructor() { return getToken(PhpParser.Constructor, 0); }
		public TerminalNode Get() { return getToken(PhpParser.Get, 0); }
		public TerminalNode Set() { return getToken(PhpParser.Set, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public List<KeyedVariableContext> keyedVariable() {
			return getRuleContexts(KeyedVariableContext.class);
		}
		public KeyedVariableContext keyedVariable(int i) {
			return getRuleContext(KeyedVariableContext.class,i);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public ClassConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterClassConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitClassConstant(this);
		}
	}

	public final ClassConstantContext classConstant() throws RecognitionException {
		ClassConstantContext _localctx = new ClassConstantContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_classConstant);
		int _la;
		try {
			setState(1769);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,224,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1751);
				_la = _input.LA(1);
				if ( !(_la==Class || _la==Parent_) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1752);
				match(DoubleColon);
				setState(1757);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
				case 1:
					{
					setState(1753);
					identifier();
					}
					break;
				case 2:
					{
					setState(1754);
					match(Constructor);
					}
					break;
				case 3:
					{
					setState(1755);
					match(Get);
					}
					break;
				case 4:
					{
					setState(1756);
					match(Set);
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1762);
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
				case Enum_:
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
				case Readonly:
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
				case Ticks:
				case Encoding:
				case StrictTypes:
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
					{
					setState(1759);
					qualifiedStaticTypeRef();
					}
					break;
				case Dollar:
				case VarName:
					{
					setState(1760);
					keyedVariable();
					}
					break;
				case SingleQuoteString:
				case DoubleQuote:
				case StartNowDoc:
				case StartHereDoc:
					{
					setState(1761);
					string();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1764);
				match(DoubleColon);
				setState(1767);
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
				case Enum_:
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
				case Readonly:
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
				case Ticks:
				case Encoding:
				case StrictTypes:
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
					{
					setState(1765);
					identifier();
					}
					break;
				case Dollar:
				case VarName:
					{
					setState(1766);
					keyedVariable();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringConstantContext extends ParserRuleContext {
		public TerminalNode Label() { return getToken(PhpParser.Label, 0); }
		public StringConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterStringConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitStringConstant(this);
		}
	}

	public final StringConstantContext stringConstant() throws RecognitionException {
		StringConstantContext _localctx = new StringConstantContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_stringConstant);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1771);
			match(Label);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringContext extends ParserRuleContext {
		public TerminalNode StartHereDoc() { return getToken(PhpParser.StartHereDoc, 0); }
		public List<TerminalNode> HereDocText() { return getTokens(PhpParser.HereDocText); }
		public TerminalNode HereDocText(int i) {
			return getToken(PhpParser.HereDocText, i);
		}
		public TerminalNode StartNowDoc() { return getToken(PhpParser.StartNowDoc, 0); }
		public TerminalNode SingleQuoteString() { return getToken(PhpParser.SingleQuoteString, 0); }
		public List<TerminalNode> DoubleQuote() { return getTokens(PhpParser.DoubleQuote); }
		public TerminalNode DoubleQuote(int i) {
			return getToken(PhpParser.DoubleQuote, i);
		}
		public List<InterpolatedStringPartContext> interpolatedStringPart() {
			return getRuleContexts(InterpolatedStringPartContext.class);
		}
		public InterpolatedStringPartContext interpolatedStringPart(int i) {
			return getRuleContext(InterpolatedStringPartContext.class,i);
		}
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitString(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_string);
		try {
			int _alt;
			setState(1794);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StartHereDoc:
				enterOuterAlt(_localctx, 1);
				{
				setState(1773);
				match(StartHereDoc);
				setState(1775); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1774);
						match(HereDocText);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1777); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,225,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case StartNowDoc:
				enterOuterAlt(_localctx, 2);
				{
				setState(1779);
				match(StartNowDoc);
				setState(1781); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1780);
						match(HereDocText);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1783); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,226,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case SingleQuoteString:
				enterOuterAlt(_localctx, 3);
				{
				setState(1785);
				match(SingleQuoteString);
				}
				break;
			case DoubleQuote:
				enterOuterAlt(_localctx, 4);
				{
				setState(1786);
				match(DoubleQuote);
				setState(1790);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,227,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1787);
						interpolatedStringPart();
						}
						} 
					}
					setState(1792);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,227,_ctx);
				}
				setState(1793);
				match(DoubleQuote);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterpolatedStringPartContext extends ParserRuleContext {
		public TerminalNode StringPart() { return getToken(PhpParser.StringPart, 0); }
		public TerminalNode UnicodeEscape() { return getToken(PhpParser.UnicodeEscape, 0); }
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public InterpolatedStringPartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolatedStringPart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterInterpolatedStringPart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitInterpolatedStringPart(this);
		}
	}

	public final InterpolatedStringPartContext interpolatedStringPart() throws RecognitionException {
		InterpolatedStringPartContext _localctx = new InterpolatedStringPartContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_interpolatedStringPart);
		try {
			setState(1799);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case StringPart:
				enterOuterAlt(_localctx, 1);
				{
				setState(1796);
				match(StringPart);
				}
				break;
			case UnicodeEscape:
				enterOuterAlt(_localctx, 2);
				{
				setState(1797);
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
				setState(1798);
				chain();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChainListContext extends ParserRuleContext {
		public List<ChainContext> chain() {
			return getRuleContexts(ChainContext.class);
		}
		public ChainContext chain(int i) {
			return getRuleContext(ChainContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public ChainListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chainList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChainList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChainList(this);
		}
	}

	public final ChainListContext chainList() throws RecognitionException {
		ChainListContext _localctx = new ChainListContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_chainList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1801);
			chain();
			setState(1806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1802);
				match(Comma);
				setState(1803);
				chain();
				}
				}
				setState(1808);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChainContext extends ParserRuleContext {
		public ChainOriginContext chainOrigin() {
			return getRuleContext(ChainOriginContext.class,0);
		}
		public List<MemberAccessContext> memberAccess() {
			return getRuleContexts(MemberAccessContext.class);
		}
		public MemberAccessContext memberAccess(int i) {
			return getRuleContext(MemberAccessContext.class,i);
		}
		public ChainContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chain; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChain(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChain(this);
		}
	}

	public final ChainContext chain() throws RecognitionException {
		ChainContext _localctx = new ChainContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_chain);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1809);
			chainOrigin();
			setState(1813);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,231,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1810);
					memberAccess();
					}
					} 
				}
				setState(1815);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,231,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChainOriginContext extends ParserRuleContext {
		public ChainBaseContext chainBase() {
			return getRuleContext(ChainBaseContext.class,0);
		}
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public NewExprContext newExpr() {
			return getRuleContext(NewExprContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public ChainOriginContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chainOrigin; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChainOrigin(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChainOrigin(this);
		}
	}

	public final ChainOriginContext chainOrigin() throws RecognitionException {
		ChainOriginContext _localctx = new ChainOriginContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_chainOrigin);
		try {
			setState(1822);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1816);
				chainBase();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1817);
				functionCall();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1818);
				match(OpenRoundBracket);
				setState(1819);
				newExpr();
				setState(1820);
				match(CloseRoundBracket);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessContext extends ParserRuleContext {
		public TerminalNode ObjectOperator() { return getToken(PhpParser.ObjectOperator, 0); }
		public KeyedFieldNameContext keyedFieldName() {
			return getRuleContext(KeyedFieldNameContext.class,0);
		}
		public ActualArgumentsContext actualArguments() {
			return getRuleContext(ActualArgumentsContext.class,0);
		}
		public MemberAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMemberAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMemberAccess(this);
		}
	}

	public final MemberAccessContext memberAccess() throws RecognitionException {
		MemberAccessContext _localctx = new MemberAccessContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_memberAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			match(ObjectOperator);
			setState(1825);
			keyedFieldName();
			setState(1827);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,233,_ctx) ) {
			case 1:
				{
				setState(1826);
				actualArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallContext extends ParserRuleContext {
		public FunctionCallNameContext functionCallName() {
			return getRuleContext(FunctionCallNameContext.class,0);
		}
		public ActualArgumentsContext actualArguments() {
			return getRuleContext(ActualArgumentsContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFunctionCall(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_functionCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1829);
			functionCallName();
			setState(1830);
			actualArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionCallNameContext extends ParserRuleContext {
		public QualifiedNamespaceNameContext qualifiedNamespaceName() {
			return getRuleContext(QualifiedNamespaceNameContext.class,0);
		}
		public ClassConstantContext classConstant() {
			return getRuleContext(ClassConstantContext.class,0);
		}
		public ChainBaseContext chainBase() {
			return getRuleContext(ChainBaseContext.class,0);
		}
		public ParenthesesContext parentheses() {
			return getRuleContext(ParenthesesContext.class,0);
		}
		public FunctionCallNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCallName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterFunctionCallName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitFunctionCallName(this);
		}
	}

	public final FunctionCallNameContext functionCallName() throws RecognitionException {
		FunctionCallNameContext _localctx = new FunctionCallNameContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_functionCallName);
		try {
			setState(1836);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1832);
				qualifiedNamespaceName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1833);
				classConstant();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1834);
				chainBase();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1835);
				parentheses();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ActualArgumentsContext extends ParserRuleContext {
		public GenericDynamicArgsContext genericDynamicArgs() {
			return getRuleContext(GenericDynamicArgsContext.class,0);
		}
		public List<ArgumentsContext> arguments() {
			return getRuleContexts(ArgumentsContext.class);
		}
		public ArgumentsContext arguments(int i) {
			return getRuleContext(ArgumentsContext.class,i);
		}
		public List<SquareCurlyExpressionContext> squareCurlyExpression() {
			return getRuleContexts(SquareCurlyExpressionContext.class);
		}
		public SquareCurlyExpressionContext squareCurlyExpression(int i) {
			return getRuleContext(SquareCurlyExpressionContext.class,i);
		}
		public ActualArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actualArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterActualArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitActualArguments(this);
		}
	}

	public final ActualArgumentsContext actualArguments() throws RecognitionException {
		ActualArgumentsContext _localctx = new ActualArgumentsContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_actualArguments);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1839);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Lgeneric) {
				{
				setState(1838);
				genericDynamicArgs();
				}
			}

			setState(1842); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1841);
					arguments();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1844); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			setState(1849);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,237,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1846);
					squareCurlyExpression();
					}
					} 
				}
				setState(1851);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,237,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ChainBaseContext extends ParserRuleContext {
		public List<KeyedVariableContext> keyedVariable() {
			return getRuleContexts(KeyedVariableContext.class);
		}
		public KeyedVariableContext keyedVariable(int i) {
			return getRuleContext(KeyedVariableContext.class,i);
		}
		public TerminalNode DoubleColon() { return getToken(PhpParser.DoubleColon, 0); }
		public QualifiedStaticTypeRefContext qualifiedStaticTypeRef() {
			return getRuleContext(QualifiedStaticTypeRefContext.class,0);
		}
		public ChainBaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_chainBase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterChainBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitChainBase(this);
		}
	}

	public final ChainBaseContext chainBase() throws RecognitionException {
		ChainBaseContext _localctx = new ChainBaseContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_chainBase);
		try {
			setState(1861);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Dollar:
			case VarName:
				enterOuterAlt(_localctx, 1);
				{
				setState(1852);
				keyedVariable();
				setState(1855);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,238,_ctx) ) {
				case 1:
					{
					setState(1853);
					match(DoubleColon);
					setState(1854);
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
				setState(1857);
				qualifiedStaticTypeRef();
				setState(1858);
				match(DoubleColon);
				setState(1859);
				keyedVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyedFieldNameContext extends ParserRuleContext {
		public KeyedSimpleFieldNameContext keyedSimpleFieldName() {
			return getRuleContext(KeyedSimpleFieldNameContext.class,0);
		}
		public KeyedVariableContext keyedVariable() {
			return getRuleContext(KeyedVariableContext.class,0);
		}
		public KeyedFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterKeyedFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitKeyedFieldName(this);
		}
	}

	public final KeyedFieldNameContext keyedFieldName() throws RecognitionException {
		KeyedFieldNameContext _localctx = new KeyedFieldNameContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_keyedFieldName);
		try {
			setState(1865);
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
				setState(1863);
				keyedSimpleFieldName();
				}
				break;
			case Dollar:
			case VarName:
				enterOuterAlt(_localctx, 2);
				{
				setState(1864);
				keyedVariable();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyedSimpleFieldNameContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public List<SquareCurlyExpressionContext> squareCurlyExpression() {
			return getRuleContexts(SquareCurlyExpressionContext.class);
		}
		public SquareCurlyExpressionContext squareCurlyExpression(int i) {
			return getRuleContext(SquareCurlyExpressionContext.class,i);
		}
		public KeyedSimpleFieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedSimpleFieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterKeyedSimpleFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitKeyedSimpleFieldName(this);
		}
	}

	public final KeyedSimpleFieldNameContext keyedSimpleFieldName() throws RecognitionException {
		KeyedSimpleFieldNameContext _localctx = new KeyedSimpleFieldNameContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_keyedSimpleFieldName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1872);
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
			case Enum_:
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
			case Readonly:
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
			case Ticks:
			case Encoding:
			case StrictTypes:
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
				{
				setState(1867);
				identifier();
				}
				break;
			case OpenCurlyBracket:
				{
				setState(1868);
				match(OpenCurlyBracket);
				setState(1869);
				expression(0);
				setState(1870);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1877);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,242,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1874);
					squareCurlyExpression();
					}
					} 
				}
				setState(1879);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,242,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class KeyedVariableContext extends ParserRuleContext {
		public TerminalNode VarName() { return getToken(PhpParser.VarName, 0); }
		public List<TerminalNode> Dollar() { return getTokens(PhpParser.Dollar); }
		public TerminalNode Dollar(int i) {
			return getToken(PhpParser.Dollar, i);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public List<SquareCurlyExpressionContext> squareCurlyExpression() {
			return getRuleContexts(SquareCurlyExpressionContext.class);
		}
		public SquareCurlyExpressionContext squareCurlyExpression(int i) {
			return getRuleContext(SquareCurlyExpressionContext.class,i);
		}
		public KeyedVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyedVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterKeyedVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitKeyedVariable(this);
		}
	}

	public final KeyedVariableContext keyedVariable() throws RecognitionException {
		KeyedVariableContext _localctx = new KeyedVariableContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_keyedVariable);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1883);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,243,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1880);
					match(Dollar);
					}
					} 
				}
				setState(1885);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,243,_ctx);
			}
			setState(1892);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VarName:
				{
				setState(1886);
				match(VarName);
				}
				break;
			case Dollar:
				{
				setState(1887);
				match(Dollar);
				setState(1888);
				match(OpenCurlyBracket);
				setState(1889);
				expression(0);
				setState(1890);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1897);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1894);
					squareCurlyExpression();
					}
					} 
				}
				setState(1899);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SquareCurlyExpressionContext extends ParserRuleContext {
		public TerminalNode OpenSquareBracket() { return getToken(PhpParser.OpenSquareBracket, 0); }
		public TerminalNode CloseSquareBracket() { return getToken(PhpParser.CloseSquareBracket, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode OpenCurlyBracket() { return getToken(PhpParser.OpenCurlyBracket, 0); }
		public TerminalNode CloseCurlyBracket() { return getToken(PhpParser.CloseCurlyBracket, 0); }
		public SquareCurlyExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squareCurlyExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterSquareCurlyExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitSquareCurlyExpression(this);
		}
	}

	public final SquareCurlyExpressionContext squareCurlyExpression() throws RecognitionException {
		SquareCurlyExpressionContext _localctx = new SquareCurlyExpressionContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_squareCurlyExpression);
		int _la;
		try {
			setState(1909);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case OpenSquareBracket:
				enterOuterAlt(_localctx, 1);
				{
				setState(1900);
				match(OpenSquareBracket);
				setState(1902);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138177L) != 0)) {
					{
					setState(1901);
					expression(0);
					}
				}

				setState(1904);
				match(CloseSquareBracket);
				}
				break;
			case OpenCurlyBracket:
				enterOuterAlt(_localctx, 2);
				{
				setState(1905);
				match(OpenCurlyBracket);
				setState(1906);
				expression(0);
				setState(1907);
				match(CloseCurlyBracket);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentListContext extends ParserRuleContext {
		public List<AssignmentListElementContext> assignmentListElement() {
			return getRuleContexts(AssignmentListElementContext.class);
		}
		public AssignmentListElementContext assignmentListElement(int i) {
			return getRuleContext(AssignmentListElementContext.class,i);
		}
		public List<TerminalNode> Comma() { return getTokens(PhpParser.Comma); }
		public TerminalNode Comma(int i) {
			return getToken(PhpParser.Comma, i);
		}
		public AssignmentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentList(this);
		}
	}

	public final AssignmentListContext assignmentList() throws RecognitionException {
		AssignmentListContext _localctx = new AssignmentListContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_assignmentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138193L) != 0)) {
				{
				setState(1911);
				assignmentListElement();
				}
			}

			setState(1920);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Comma) {
				{
				{
				setState(1914);
				match(Comma);
				setState(1916);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 441352763482308607L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & 4396974138193L) != 0)) {
					{
					setState(1915);
					assignmentListElement();
					}
				}

				}
				}
				setState(1922);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentListElementContext extends ParserRuleContext {
		public ChainContext chain() {
			return getRuleContext(ChainContext.class,0);
		}
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public TerminalNode OpenRoundBracket() { return getToken(PhpParser.OpenRoundBracket, 0); }
		public AssignmentListContext assignmentList() {
			return getRuleContext(AssignmentListContext.class,0);
		}
		public TerminalNode CloseRoundBracket() { return getToken(PhpParser.CloseRoundBracket, 0); }
		public ArrayItemContext arrayItem() {
			return getRuleContext(ArrayItemContext.class,0);
		}
		public AssignmentListElementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentListElement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterAssignmentListElement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitAssignmentListElement(this);
		}
	}

	public final AssignmentListElementContext assignmentListElement() throws RecognitionException {
		AssignmentListElementContext _localctx = new AssignmentListElementContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_assignmentListElement);
		try {
			setState(1930);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1923);
				chain();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1924);
				match(List);
				setState(1925);
				match(OpenRoundBracket);
				setState(1926);
				assignmentList();
				setState(1927);
				match(CloseRoundBracket);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1929);
				arrayItem();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode Abstract() { return getToken(PhpParser.Abstract, 0); }
		public TerminalNode Final() { return getToken(PhpParser.Final, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1932);
			_la = _input.LA(1);
			if ( !(_la==Abstract || _la==Final) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Label() { return getToken(PhpParser.Label, 0); }
		public TerminalNode Abstract() { return getToken(PhpParser.Abstract, 0); }
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public TerminalNode As() { return getToken(PhpParser.As, 0); }
		public TerminalNode BinaryCast() { return getToken(PhpParser.BinaryCast, 0); }
		public TerminalNode BoolType() { return getToken(PhpParser.BoolType, 0); }
		public TerminalNode BooleanConstant() { return getToken(PhpParser.BooleanConstant, 0); }
		public TerminalNode Break() { return getToken(PhpParser.Break, 0); }
		public TerminalNode Callable() { return getToken(PhpParser.Callable, 0); }
		public TerminalNode Case() { return getToken(PhpParser.Case, 0); }
		public TerminalNode Catch() { return getToken(PhpParser.Catch, 0); }
		public TerminalNode Class() { return getToken(PhpParser.Class, 0); }
		public TerminalNode Clone() { return getToken(PhpParser.Clone, 0); }
		public TerminalNode Const() { return getToken(PhpParser.Const, 0); }
		public TerminalNode Continue() { return getToken(PhpParser.Continue, 0); }
		public TerminalNode Declare() { return getToken(PhpParser.Declare, 0); }
		public TerminalNode Default() { return getToken(PhpParser.Default, 0); }
		public TerminalNode Do() { return getToken(PhpParser.Do, 0); }
		public TerminalNode DoubleCast() { return getToken(PhpParser.DoubleCast, 0); }
		public TerminalNode DoubleType() { return getToken(PhpParser.DoubleType, 0); }
		public TerminalNode Echo() { return getToken(PhpParser.Echo, 0); }
		public TerminalNode Else() { return getToken(PhpParser.Else, 0); }
		public TerminalNode ElseIf() { return getToken(PhpParser.ElseIf, 0); }
		public TerminalNode Empty() { return getToken(PhpParser.Empty, 0); }
		public TerminalNode EndDeclare() { return getToken(PhpParser.EndDeclare, 0); }
		public TerminalNode EndFor() { return getToken(PhpParser.EndFor, 0); }
		public TerminalNode EndForeach() { return getToken(PhpParser.EndForeach, 0); }
		public TerminalNode EndIf() { return getToken(PhpParser.EndIf, 0); }
		public TerminalNode EndSwitch() { return getToken(PhpParser.EndSwitch, 0); }
		public TerminalNode EndWhile() { return getToken(PhpParser.EndWhile, 0); }
		public TerminalNode Eval() { return getToken(PhpParser.Eval, 0); }
		public TerminalNode Exit() { return getToken(PhpParser.Exit, 0); }
		public TerminalNode Extends() { return getToken(PhpParser.Extends, 0); }
		public TerminalNode Final() { return getToken(PhpParser.Final, 0); }
		public TerminalNode Finally() { return getToken(PhpParser.Finally, 0); }
		public TerminalNode FloatCast() { return getToken(PhpParser.FloatCast, 0); }
		public TerminalNode For() { return getToken(PhpParser.For, 0); }
		public TerminalNode Foreach() { return getToken(PhpParser.Foreach, 0); }
		public TerminalNode Function_() { return getToken(PhpParser.Function_, 0); }
		public TerminalNode Global() { return getToken(PhpParser.Global, 0); }
		public TerminalNode Goto() { return getToken(PhpParser.Goto, 0); }
		public TerminalNode If() { return getToken(PhpParser.If, 0); }
		public TerminalNode Implements() { return getToken(PhpParser.Implements, 0); }
		public TerminalNode Import() { return getToken(PhpParser.Import, 0); }
		public TerminalNode Include() { return getToken(PhpParser.Include, 0); }
		public TerminalNode IncludeOnce() { return getToken(PhpParser.IncludeOnce, 0); }
		public TerminalNode InstanceOf() { return getToken(PhpParser.InstanceOf, 0); }
		public TerminalNode InsteadOf() { return getToken(PhpParser.InsteadOf, 0); }
		public TerminalNode Int16Cast() { return getToken(PhpParser.Int16Cast, 0); }
		public TerminalNode Int64Type() { return getToken(PhpParser.Int64Type, 0); }
		public TerminalNode Int8Cast() { return getToken(PhpParser.Int8Cast, 0); }
		public TerminalNode Interface() { return getToken(PhpParser.Interface, 0); }
		public TerminalNode IntType() { return getToken(PhpParser.IntType, 0); }
		public TerminalNode IsSet() { return getToken(PhpParser.IsSet, 0); }
		public TerminalNode LambdaFn() { return getToken(PhpParser.LambdaFn, 0); }
		public TerminalNode List() { return getToken(PhpParser.List, 0); }
		public TerminalNode LogicalAnd() { return getToken(PhpParser.LogicalAnd, 0); }
		public TerminalNode LogicalOr() { return getToken(PhpParser.LogicalOr, 0); }
		public TerminalNode LogicalXor() { return getToken(PhpParser.LogicalXor, 0); }
		public TerminalNode Namespace() { return getToken(PhpParser.Namespace, 0); }
		public TerminalNode New() { return getToken(PhpParser.New, 0); }
		public TerminalNode Null() { return getToken(PhpParser.Null, 0); }
		public TerminalNode ObjectType() { return getToken(PhpParser.ObjectType, 0); }
		public TerminalNode Parent_() { return getToken(PhpParser.Parent_, 0); }
		public TerminalNode Partial() { return getToken(PhpParser.Partial, 0); }
		public TerminalNode Print() { return getToken(PhpParser.Print, 0); }
		public TerminalNode Private() { return getToken(PhpParser.Private, 0); }
		public TerminalNode Protected() { return getToken(PhpParser.Protected, 0); }
		public TerminalNode Public() { return getToken(PhpParser.Public, 0); }
		public TerminalNode Readonly() { return getToken(PhpParser.Readonly, 0); }
		public TerminalNode Require() { return getToken(PhpParser.Require, 0); }
		public TerminalNode RequireOnce() { return getToken(PhpParser.RequireOnce, 0); }
		public TerminalNode Resource() { return getToken(PhpParser.Resource, 0); }
		public TerminalNode Return() { return getToken(PhpParser.Return, 0); }
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public TerminalNode StringType() { return getToken(PhpParser.StringType, 0); }
		public TerminalNode Switch() { return getToken(PhpParser.Switch, 0); }
		public TerminalNode Throw() { return getToken(PhpParser.Throw, 0); }
		public TerminalNode Trait() { return getToken(PhpParser.Trait, 0); }
		public TerminalNode Try() { return getToken(PhpParser.Try, 0); }
		public TerminalNode Typeof() { return getToken(PhpParser.Typeof, 0); }
		public TerminalNode UintCast() { return getToken(PhpParser.UintCast, 0); }
		public TerminalNode UnicodeCast() { return getToken(PhpParser.UnicodeCast, 0); }
		public TerminalNode Unset() { return getToken(PhpParser.Unset, 0); }
		public TerminalNode Use() { return getToken(PhpParser.Use, 0); }
		public TerminalNode Var() { return getToken(PhpParser.Var, 0); }
		public TerminalNode While() { return getToken(PhpParser.While, 0); }
		public TerminalNode Yield() { return getToken(PhpParser.Yield, 0); }
		public TerminalNode From() { return getToken(PhpParser.From, 0); }
		public TerminalNode Enum_() { return getToken(PhpParser.Enum_, 0); }
		public TerminalNode Match_() { return getToken(PhpParser.Match_, 0); }
		public TerminalNode Ticks() { return getToken(PhpParser.Ticks, 0); }
		public TerminalNode Encoding() { return getToken(PhpParser.Encoding, 0); }
		public TerminalNode StrictTypes() { return getToken(PhpParser.StrictTypes, 0); }
		public TerminalNode Get() { return getToken(PhpParser.Get, 0); }
		public TerminalNode Set() { return getToken(PhpParser.Set, 0); }
		public TerminalNode Call() { return getToken(PhpParser.Call, 0); }
		public TerminalNode CallStatic() { return getToken(PhpParser.CallStatic, 0); }
		public TerminalNode Constructor() { return getToken(PhpParser.Constructor, 0); }
		public TerminalNode Destruct() { return getToken(PhpParser.Destruct, 0); }
		public TerminalNode Wakeup() { return getToken(PhpParser.Wakeup, 0); }
		public TerminalNode Sleep() { return getToken(PhpParser.Sleep, 0); }
		public TerminalNode Autoload() { return getToken(PhpParser.Autoload, 0); }
		public TerminalNode IsSet__() { return getToken(PhpParser.IsSet__, 0); }
		public TerminalNode Unset__() { return getToken(PhpParser.Unset__, 0); }
		public TerminalNode ToString__() { return getToken(PhpParser.ToString__, 0); }
		public TerminalNode Invoke() { return getToken(PhpParser.Invoke, 0); }
		public TerminalNode SetState() { return getToken(PhpParser.SetState, 0); }
		public TerminalNode Clone__() { return getToken(PhpParser.Clone__, 0); }
		public TerminalNode DebugInfo() { return getToken(PhpParser.DebugInfo, 0); }
		public TerminalNode Namespace__() { return getToken(PhpParser.Namespace__, 0); }
		public TerminalNode Class__() { return getToken(PhpParser.Class__, 0); }
		public TerminalNode Traic__() { return getToken(PhpParser.Traic__, 0); }
		public TerminalNode Function__() { return getToken(PhpParser.Function__, 0); }
		public TerminalNode Method__() { return getToken(PhpParser.Method__, 0); }
		public TerminalNode Line__() { return getToken(PhpParser.Line__, 0); }
		public TerminalNode File__() { return getToken(PhpParser.File__, 0); }
		public TerminalNode Dir__() { return getToken(PhpParser.Dir__, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1934);
			_la = _input.LA(1);
			if ( !(((((_la - 44)) & ~0x3f) == 0 && ((1L << (_la - 44)) & -1L) != 0) || ((((_la - 108)) & ~0x3f) == 0 && ((1L << (_la - 108)) & 9007199254740991L) != 0) || _la==Label) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberModifierContext extends ParserRuleContext {
		public TerminalNode Public() { return getToken(PhpParser.Public, 0); }
		public TerminalNode Protected() { return getToken(PhpParser.Protected, 0); }
		public TerminalNode Private() { return getToken(PhpParser.Private, 0); }
		public TerminalNode Static() { return getToken(PhpParser.Static, 0); }
		public TerminalNode Abstract() { return getToken(PhpParser.Abstract, 0); }
		public TerminalNode Final() { return getToken(PhpParser.Final, 0); }
		public TerminalNode Readonly() { return getToken(PhpParser.Readonly, 0); }
		public MemberModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberModifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMemberModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMemberModifier(this);
		}
	}

	public final MemberModifierContext memberModifier() throws RecognitionException {
		MemberModifierContext _localctx = new MemberModifierContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_memberModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1936);
			_la = _input.LA(1);
			if ( !(_la==Abstract || ((((_la - 77)) & ~0x3f) == 0 && ((1L << (_la - 77)) & 2327872274433L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MagicConstantContext extends ParserRuleContext {
		public TerminalNode Namespace__() { return getToken(PhpParser.Namespace__, 0); }
		public TerminalNode Class__() { return getToken(PhpParser.Class__, 0); }
		public TerminalNode Traic__() { return getToken(PhpParser.Traic__, 0); }
		public TerminalNode Function__() { return getToken(PhpParser.Function__, 0); }
		public TerminalNode Method__() { return getToken(PhpParser.Method__, 0); }
		public TerminalNode Line__() { return getToken(PhpParser.Line__, 0); }
		public TerminalNode File__() { return getToken(PhpParser.File__, 0); }
		public TerminalNode Dir__() { return getToken(PhpParser.Dir__, 0); }
		public MagicConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_magicConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMagicConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMagicConstant(this);
		}
	}

	public final MagicConstantContext magicConstant() throws RecognitionException {
		MagicConstantContext _localctx = new MagicConstantContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_magicConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1938);
			_la = _input.LA(1);
			if ( !(((((_la - 153)) & ~0x3f) == 0 && ((1L << (_la - 153)) & 255L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MagicMethodContext extends ParserRuleContext {
		public TerminalNode Get() { return getToken(PhpParser.Get, 0); }
		public TerminalNode Set() { return getToken(PhpParser.Set, 0); }
		public TerminalNode Call() { return getToken(PhpParser.Call, 0); }
		public TerminalNode CallStatic() { return getToken(PhpParser.CallStatic, 0); }
		public TerminalNode Constructor() { return getToken(PhpParser.Constructor, 0); }
		public TerminalNode Destruct() { return getToken(PhpParser.Destruct, 0); }
		public TerminalNode Wakeup() { return getToken(PhpParser.Wakeup, 0); }
		public TerminalNode Sleep() { return getToken(PhpParser.Sleep, 0); }
		public TerminalNode Autoload() { return getToken(PhpParser.Autoload, 0); }
		public TerminalNode IsSet__() { return getToken(PhpParser.IsSet__, 0); }
		public TerminalNode Unset__() { return getToken(PhpParser.Unset__, 0); }
		public TerminalNode ToString__() { return getToken(PhpParser.ToString__, 0); }
		public TerminalNode Invoke() { return getToken(PhpParser.Invoke, 0); }
		public TerminalNode SetState() { return getToken(PhpParser.SetState, 0); }
		public TerminalNode Clone__() { return getToken(PhpParser.Clone__, 0); }
		public TerminalNode DebugInfo() { return getToken(PhpParser.DebugInfo, 0); }
		public MagicMethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_magicMethod; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterMagicMethod(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitMagicMethod(this);
		}
	}

	public final MagicMethodContext magicMethod() throws RecognitionException {
		MagicMethodContext _localctx = new MagicMethodContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_magicMethod);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1940);
			_la = _input.LA(1);
			if ( !(((((_la - 137)) & ~0x3f) == 0 && ((1L << (_la - 137)) & 65535L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BoolType() { return getToken(PhpParser.BoolType, 0); }
		public TerminalNode IntType() { return getToken(PhpParser.IntType, 0); }
		public TerminalNode Int64Type() { return getToken(PhpParser.Int64Type, 0); }
		public TerminalNode DoubleType() { return getToken(PhpParser.DoubleType, 0); }
		public TerminalNode StringType() { return getToken(PhpParser.StringType, 0); }
		public TerminalNode Resource() { return getToken(PhpParser.Resource, 0); }
		public TerminalNode ObjectType() { return getToken(PhpParser.ObjectType, 0); }
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1942);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 4612002677776187392L) != 0) || ((((_la - 94)) & ~0x3f) == 0 && ((1L << (_la - 94)) & 37752835L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CastOperationContext extends ParserRuleContext {
		public TerminalNode BoolType() { return getToken(PhpParser.BoolType, 0); }
		public TerminalNode Int8Cast() { return getToken(PhpParser.Int8Cast, 0); }
		public TerminalNode Int16Cast() { return getToken(PhpParser.Int16Cast, 0); }
		public TerminalNode IntType() { return getToken(PhpParser.IntType, 0); }
		public TerminalNode Int64Type() { return getToken(PhpParser.Int64Type, 0); }
		public TerminalNode UintCast() { return getToken(PhpParser.UintCast, 0); }
		public TerminalNode DoubleCast() { return getToken(PhpParser.DoubleCast, 0); }
		public TerminalNode DoubleType() { return getToken(PhpParser.DoubleType, 0); }
		public TerminalNode FloatCast() { return getToken(PhpParser.FloatCast, 0); }
		public TerminalNode StringType() { return getToken(PhpParser.StringType, 0); }
		public TerminalNode BinaryCast() { return getToken(PhpParser.BinaryCast, 0); }
		public TerminalNode UnicodeCast() { return getToken(PhpParser.UnicodeCast, 0); }
		public TerminalNode Array() { return getToken(PhpParser.Array, 0); }
		public TerminalNode ObjectType() { return getToken(PhpParser.ObjectType, 0); }
		public TerminalNode Resource() { return getToken(PhpParser.Resource, 0); }
		public TerminalNode Unset() { return getToken(PhpParser.Unset, 0); }
		public CastOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castOperation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).enterCastOperation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PhpParserListener ) ((PhpParserListener)listener).exitCastOperation(this);
		}
	}

	public final CastOperationContext castOperation() throws RecognitionException {
		CastOperationContext _localctx = new CastOperationContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_castOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1944);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 6917986424478236672L) != 0) || ((((_la - 79)) & ~0x3f) == 0 && ((1L << (_la - 79)) & 493818294165505L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 59:
			return typeHint_sempred((TypeHintContext)_localctx, predIndex);
		case 82:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
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
			return precpred(_ctx, 22);
		case 2:
			return precpred(_ctx, 20);
		case 3:
			return precpred(_ctx, 19);
		case 4:
			return precpred(_ctx, 18);
		case 5:
			return precpred(_ctx, 17);
		case 6:
			return precpred(_ctx, 16);
		case 7:
			return precpred(_ctx, 15);
		case 8:
			return precpred(_ctx, 14);
		case 9:
			return precpred(_ctx, 13);
		case 10:
			return precpred(_ctx, 12);
		case 11:
			return precpred(_ctx, 11);
		case 12:
			return precpred(_ctx, 10);
		case 13:
			return precpred(_ctx, 9);
		case 14:
			return precpred(_ctx, 8);
		case 15:
			return precpred(_ctx, 3);
		case 16:
			return precpred(_ctx, 2);
		case 17:
			return precpred(_ctx, 1);
		case 18:
			return precpred(_ctx, 21);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u00f4\u079b\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"+
		"\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"+
		"\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"+
		"\u0089\u0001\u0000\u0003\u0000\u0116\b\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u011a\b\u0000\n\u0000\f\u0000\u011d\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0001\u0004\u0001\u0122\b\u0001\u000b\u0001\f\u0001\u0123\u0001"+
		"\u0001\u0003\u0001\u0127\b\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0005\u0002\u013f\b\u0002\n\u0002\f\u0002\u0142\t\u0002\u0001\u0002"+
		"\u0003\u0002\u0145\b\u0002\u0001\u0003\u0004\u0003\u0148\b\u0003\u000b"+
		"\u0003\f\u0003\u0149\u0001\u0004\u0005\u0004\u014d\b\u0004\n\u0004\f\u0004"+
		"\u0150\t\u0004\u0001\u0004\u0004\u0004\u0153\b\u0004\u000b\u0004\f\u0004"+
		"\u0154\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0003\u0006\u0163\b\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u0167"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0003\b\u016d\b\b"+
		"\u0001\b\u0001\b\u0001\b\u0003\b\u0172\b\b\u0001\b\u0005\b\u0175\b\b\n"+
		"\b\f\b\u0178\t\b\u0001\t\u0001\t\u0001\n\u0001\n\u0003\n\u017e\b\n\u0001"+
		"\n\u0001\n\u0005\n\u0182\b\n\n\n\f\n\u0185\t\n\u0001\n\u0001\n\u0001\n"+
		"\u0001\n\u0003\n\u018b\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\u000b\u0003\u000b\u0192\b\u000b\u0001\f\u0003\f\u0195\b\f\u0001"+
		"\f\u0001\f\u0003\f\u0199\b\f\u0001\f\u0001\f\u0003\f\u019d\b\f\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u01a4\b\f\u0001\f\u0003\f\u01a7"+
		"\b\f\u0001\f\u0001\f\u0001\r\u0003\r\u01ac\b\r\u0001\r\u0003\r\u01af\b"+
		"\r\u0001\r\u0003\r\u01b2\b\r\u0001\r\u0003\r\u01b5\b\r\u0001\r\u0001\r"+
		"\u0001\r\u0003\r\u01ba\b\r\u0001\r\u0001\r\u0003\r\u01be\b\r\u0001\r\u0001"+
		"\r\u0003\r\u01c2\b\r\u0001\r\u0001\r\u0001\r\u0003\r\u01c7\b\r\u0001\r"+
		"\u0001\r\u0003\r\u01cb\b\r\u0003\r\u01cd\b\r\u0001\r\u0001\r\u0005\r\u01d1"+
		"\b\r\n\r\f\r\u01d4\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0005\u000f\u01dd\b\u000f\n\u000f\f\u000f\u01e0"+
		"\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0001\u0010\u0003\u0010\u01f0\b\u0010\u0001\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u01f5\b\u0011\n\u0011\f\u0011\u01f8\t\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u01fd\b\u0012\n\u0012"+
		"\f\u0012\u0200\t\u0012\u0001\u0013\u0003\u0013\u0203\b\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0014\u0003\u0014\u0208\b\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0014\u0001\u0014\u0003\u0014\u020e\b\u0014\u0001\u0015\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0005\u0015\u0214\b\u0015\n\u0015\f\u0015\u0217"+
		"\t\u0015\u0001\u0015\u0001\u0015\u0001\u0016\u0004\u0016\u021c\b\u0016"+
		"\u000b\u0016\f\u0016\u021d\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"+
		"\u0003\u0017\u0224\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0005\u0017"+
		"\u0229\b\u0017\n\u0017\f\u0017\u022c\t\u0017\u0001\u0017\u0001\u0017\u0001"+
		"\u0018\u0001\u0018\u0003\u0018\u0232\b\u0018\u0001\u0019\u0005\u0019\u0235"+
		"\b\u0019\n\u0019\f\u0019\u0238\t\u0019\u0001\u001a\u0001\u001a\u0001\u001a"+
		"\u0003\u001a\u023d\b\u001a\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b"+
		"\u025a\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005\u001e"+
		"\u0266\b\u001e\n\u001e\f\u001e\u0269\t\u001e\u0001\u001e\u0003\u001e\u026c"+
		"\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0005"+
		"\u001e\u0273\b\u001e\n\u001e\f\u001e\u0276\t\u001e\u0001\u001e\u0003\u001e"+
		"\u0279\b\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0003\u001e\u027e\b"+
		"\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001"+
		" \u0001 \u0001 \u0001!\u0001!\u0001!\u0001\"\u0001\"\u0001\"\u0001\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003#\u0298\b#\u0001"+
		"$\u0001$\u0001$\u0001$\u0001$\u0001$\u0001%\u0001%\u0001%\u0003%\u02a3"+
		"\b%\u0001%\u0001%\u0003%\u02a7\b%\u0001%\u0001%\u0003%\u02ab\b%\u0001"+
		"%\u0001%\u0001%\u0001%\u0001%\u0001%\u0001%\u0003%\u02b4\b%\u0001&\u0001"+
		"&\u0001\'\u0001\'\u0001(\u0001(\u0001(\u0001(\u0003(\u02be\b(\u0001(\u0005"+
		"(\u02c1\b(\n(\f(\u02c4\t(\u0001(\u0001(\u0001(\u0003(\u02c9\b(\u0001("+
		"\u0005(\u02cc\b(\n(\f(\u02cf\t(\u0001(\u0001(\u0003(\u02d3\b(\u0001)\u0001"+
		")\u0001)\u0003)\u02d8\b)\u0001)\u0004)\u02db\b)\u000b)\f)\u02dc\u0001"+
		")\u0001)\u0001*\u0001*\u0003*\u02e3\b*\u0001*\u0001*\u0001+\u0001+\u0003"+
		"+\u02e9\b+\u0001+\u0001+\u0001,\u0001,\u0003,\u02ef\b,\u0001,\u0001,\u0001"+
		"-\u0001-\u0001-\u0001.\u0001.\u0001.\u0001.\u0001.\u0001.\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003"+
		"/\u0307\b/\u0001/\u0001/\u0001/\u0003/\u030c\b/\u0001/\u0003/\u030f\b"+
		"/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0003/\u0319"+
		"\b/\u0001/\u0003/\u031c\b/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0001/\u0001/\u0003/\u0329\b/\u0001/\u0001/\u0001/\u0001"+
		"/\u0001/\u0001/\u0003/\u0331\b/\u00010\u00010\u00010\u00040\u0336\b0\u000b"+
		"0\f0\u0337\u00010\u00030\u033b\b0\u00010\u00050\u033e\b0\n0\f0\u0341\t"+
		"0\u00010\u00030\u0344\b0\u00011\u00011\u00011\u00011\u00011\u00051\u034b"+
		"\b1\n1\f1\u034e\t1\u00011\u00031\u0351\b1\u00011\u00011\u00011\u00012"+
		"\u00012\u00012\u00013\u00013\u00013\u00013\u00014\u00014\u00014\u0001"+
		"4\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u00015\u0001"+
		"5\u00035\u036b\b5\u00016\u00046\u036e\b6\u000b6\f6\u036f\u00017\u0001"+
		"7\u00017\u00057\u0375\b7\n7\f7\u0378\t7\u00018\u00018\u00018\u00018\u0003"+
		"8\u037e\b8\u00018\u00018\u00018\u00018\u00018\u00018\u00038\u0386\b8\u0001"+
		"9\u00039\u0389\b9\u00019\u00019\u00059\u038d\b9\n9\f9\u0390\t9\u00019"+
		"\u00039\u0393\b9\u0001:\u0003:\u0396\b:\u0001:\u0005:\u0399\b:\n:\f:\u039c"+
		"\t:\u0001:\u0003:\u039f\b:\u0001:\u0003:\u03a2\b:\u0001:\u0003:\u03a5"+
		"\b:\u0001:\u0003:\u03a8\b:\u0001:\u0001:\u0001;\u0001;\u0001;\u0001;\u0003"+
		";\u03b0\b;\u0001;\u0001;\u0001;\u0005;\u03b5\b;\n;\f;\u03b8\t;\u0001<"+
		"\u0001<\u0001<\u0001<\u0005<\u03be\b<\n<\f<\u03c1\t<\u0001<\u0001<\u0001"+
		"=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u03cd\b=\u0001"+
		">\u0001>\u0001>\u0001>\u0001?\u0001?\u0001?\u0001?\u0005?\u03d7\b?\n?"+
		"\f?\u03da\t?\u0001?\u0001?\u0001@\u0003@\u03df\b@\u0001@\u0001@\u0003"+
		"@\u03e3\b@\u0001@\u0001@\u0001@\u0005@\u03e8\b@\n@\f@\u03eb\t@\u0001@"+
		"\u0001@\u0001@\u0003@\u03f0\b@\u0001@\u0001@\u0003@\u03f4\b@\u0001@\u0001"+
		"@\u0001@\u0005@\u03f9\b@\n@\f@\u03fc\t@\u0001@\u0001@\u0001@\u0001@\u0003"+
		"@\u0402\b@\u0001@\u0001@\u0003@\u0406\b@\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0003@\u040d\b@\u0001@\u0001@\u0003@\u0411\b@\u0003@\u0413\b@\u0001"+
		"@\u0001@\u0001@\u0001@\u0003@\u0419\b@\u0001A\u0001A\u0001A\u0005A\u041e"+
		"\bA\nA\fA\u0421\tA\u0001A\u0003A\u0424\bA\u0001B\u0001B\u0003B\u0428\b"+
		"B\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001"+
		"D\u0001D\u0003D\u0435\bD\u0001D\u0003D\u0438\bD\u0001D\u0001D\u0001E\u0001"+
		"E\u0001E\u0003E\u043f\bE\u0001E\u0001E\u0001F\u0001F\u0001F\u0003F\u0446"+
		"\bF\u0001G\u0001G\u0003G\u044a\bG\u0001G\u0001G\u0001H\u0001H\u0003H\u0450"+
		"\bH\u0001I\u0001I\u0003I\u0454\bI\u0001J\u0004J\u0457\bJ\u000bJ\fJ\u0458"+
		"\u0001K\u0001K\u0001K\u0003K\u045e\bK\u0001L\u0001L\u0001L\u0001L\u0001"+
		"M\u0003M\u0465\bM\u0001M\u0001M\u0001M\u0001M\u0005M\u046b\bM\nM\fM\u046e"+
		"\tM\u0001M\u0001M\u0001N\u0001N\u0001N\u0001N\u0003N\u0476\bN\u0001N\u0001"+
		"N\u0003N\u047a\bN\u0001N\u0001N\u0005N\u047e\bN\nN\fN\u0481\tN\u0001N"+
		"\u0001N\u0001O\u0001O\u0001O\u0001O\u0003O\u0489\bO\u0001O\u0001O\u0001"+
		"O\u0003O\u048e\bO\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u0495\bO\u0001"+
		"P\u0001P\u0001P\u0005P\u049a\bP\nP\fP\u049d\tP\u0001Q\u0001Q\u0001Q\u0003"+
		"Q\u04a2\bQ\u0001Q\u0001Q\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0003R\u04e1\bR\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0003"+
		"R\u04f2\bR\u0001R\u0001R\u0001R\u0001R\u0001R\u0003R\u04f9\bR\u0001R\u0001"+
		"R\u0001R\u0003R\u04fe\bR\u0003R\u0500\bR\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0003R\u0526\bR\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001R\u0001"+
		"R\u0001R\u0001R\u0001R\u0005R\u053c\bR\nR\fR\u053f\tR\u0001S\u0001S\u0003"+
		"S\u0543\bS\u0001T\u0001T\u0001T\u0003T\u0548\bT\u0001T\u0001T\u0001T\u0003"+
		"T\u054d\bT\u0001T\u0003T\u0550\bT\u0001T\u0001T\u0001T\u0001T\u0003T\u0556"+
		"\bT\u0001U\u0001U\u0005U\u055a\bU\nU\fU\u055d\tU\u0001U\u0001U\u0004U"+
		"\u0561\bU\u000bU\fU\u0562\u0001U\u0005U\u0566\bU\nU\fU\u0569\tU\u0001"+
		"U\u0005U\u056c\bU\nU\fU\u056f\tU\u0001U\u0001U\u0001U\u0001U\u0001U\u0004"+
		"U\u0576\bU\u000bU\fU\u0577\u0001U\u0005U\u057b\bU\nU\fU\u057e\tU\u0001"+
		"U\u0003U\u0581\bU\u0001U\u0001U\u0003U\u0585\bU\u0001V\u0003V\u0588\b"+
		"V\u0001V\u0001V\u0001W\u0001W\u0001W\u0003W\u058f\bW\u0001W\u0003W\u0592"+
		"\bW\u0001W\u0001W\u0001X\u0003X\u0597\bX\u0001X\u0001X\u0003X\u059b\b"+
		"X\u0001X\u0001X\u0001X\u0001X\u0003X\u05a1\bX\u0001X\u0001X\u0003X\u05a5"+
		"\bX\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0001X\u0003"+
		"X\u05b0\bX\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0001Y\u0005"+
		"Y\u05ba\bY\nY\fY\u05bd\tY\u0001Y\u0003Y\u05c0\bY\u0001Y\u0001Y\u0001Z"+
		"\u0001Z\u0001Z\u0005Z\u05c7\bZ\nZ\fZ\u05ca\tZ\u0001Z\u0001Z\u0001Z\u0001"+
		"[\u0001[\u0001[\u0003[\u05d2\b[\u0001\\\u0001\\\u0001]\u0001]\u0001]\u0001"+
		"]\u0003]\u05da\b]\u0001]\u0001]\u0003]\u05de\b]\u0001^\u0001^\u0001^\u0005"+
		"^\u05e3\b^\n^\f^\u05e6\t^\u0001^\u0003^\u05e9\b^\u0001_\u0001_\u0001_"+
		"\u0003_\u05ee\b_\u0001_\u0001_\u0001_\u0003_\u05f3\b_\u0001_\u0001_\u0003"+
		"_\u05f7\b_\u0001`\u0001`\u0001`\u0001`\u0001`\u0005`\u05fe\b`\n`\f`\u0601"+
		"\t`\u0001`\u0001`\u0001a\u0003a\u0606\ba\u0001a\u0001a\u0001b\u0001b\u0003"+
		"b\u060c\bb\u0001b\u0003b\u060f\bb\u0001c\u0001c\u0003c\u0613\bc\u0001"+
		"c\u0003c\u0616\bc\u0001c\u0001c\u0001c\u0003c\u061b\bc\u0001d\u0003d\u061e"+
		"\bd\u0001d\u0003d\u0621\bd\u0001d\u0003d\u0624\bd\u0001d\u0003d\u0627"+
		"\bd\u0001d\u0001d\u0003d\u062b\bd\u0001d\u0001d\u0003d\u062f\bd\u0001"+
		"d\u0001d\u0003d\u0633\bd\u0001d\u0001d\u0001d\u0003d\u0638\bd\u0001d\u0001"+
		"d\u0003d\u063c\bd\u0003d\u063e\bd\u0001d\u0001d\u0005d\u0642\bd\nd\fd"+
		"\u0645\td\u0001d\u0001d\u0001e\u0001e\u0001e\u0005e\u064c\be\ne\fe\u064f"+
		"\te\u0001f\u0003f\u0652\bf\u0001f\u0003f\u0655\bf\u0001f\u0001f\u0001"+
		"g\u0001g\u0001g\u0001g\u0005g\u065d\bg\ng\fg\u0660\tg\u0001g\u0001g\u0003"+
		"g\u0664\bg\u0003g\u0666\bg\u0001h\u0001h\u0001h\u0003h\u066b\bh\u0001"+
		"h\u0001h\u0001h\u0001h\u0005h\u0671\bh\nh\fh\u0674\th\u0001h\u0003h\u0677"+
		"\bh\u0001h\u0001h\u0003h\u067b\bh\u0001i\u0001i\u0001i\u0005i\u0680\b"+
		"i\ni\fi\u0683\ti\u0001j\u0001j\u0001j\u0001j\u0005j\u0689\bj\nj\fj\u068c"+
		"\tj\u0001j\u0003j\u068f\bj\u0001j\u0003j\u0692\bj\u0001j\u0001j\u0001"+
		"k\u0003k\u0697\bk\u0001k\u0003k\u069a\bk\u0001k\u0001k\u0001k\u0003k\u069f"+
		"\bk\u0001l\u0001l\u0001l\u0001m\u0001m\u0001m\u0001m\u0001m\u0001m\u0003"+
		"m\u06aa\bm\u0003m\u06ac\bm\u0001m\u0001m\u0001m\u0001m\u0003m\u06b2\b"+
		"m\u0003m\u06b4\bm\u0001m\u0001m\u0001m\u0001m\u0001m\u0003m\u06bb\bm\u0001"+
		"m\u0001m\u0001m\u0003m\u06c0\bm\u0005m\u06c2\bm\nm\fm\u06c5\tm\u0003m"+
		"\u06c7\bm\u0001n\u0001n\u0001n\u0001n\u0001n\u0003n\u06ce\bn\u0001o\u0001"+
		"o\u0001o\u0001o\u0003o\u06d4\bo\u0001p\u0001p\u0001q\u0001q\u0001q\u0001"+
		"q\u0001q\u0001q\u0003q\u06de\bq\u0001q\u0001q\u0001q\u0003q\u06e3\bq\u0001"+
		"q\u0001q\u0001q\u0003q\u06e8\bq\u0003q\u06ea\bq\u0001r\u0001r\u0001s\u0001"+
		"s\u0004s\u06f0\bs\u000bs\fs\u06f1\u0001s\u0001s\u0004s\u06f6\bs\u000b"+
		"s\fs\u06f7\u0001s\u0001s\u0001s\u0005s\u06fd\bs\ns\fs\u0700\ts\u0001s"+
		"\u0003s\u0703\bs\u0001t\u0001t\u0001t\u0003t\u0708\bt\u0001u\u0001u\u0001"+
		"u\u0005u\u070d\bu\nu\fu\u0710\tu\u0001v\u0001v\u0005v\u0714\bv\nv\fv\u0717"+
		"\tv\u0001w\u0001w\u0001w\u0001w\u0001w\u0001w\u0003w\u071f\bw\u0001x\u0001"+
		"x\u0001x\u0003x\u0724\bx\u0001y\u0001y\u0001y\u0001z\u0001z\u0001z\u0001"+
		"z\u0003z\u072d\bz\u0001{\u0003{\u0730\b{\u0001{\u0004{\u0733\b{\u000b"+
		"{\f{\u0734\u0001{\u0005{\u0738\b{\n{\f{\u073b\t{\u0001|\u0001|\u0001|"+
		"\u0003|\u0740\b|\u0001|\u0001|\u0001|\u0001|\u0003|\u0746\b|\u0001}\u0001"+
		"}\u0003}\u074a\b}\u0001~\u0001~\u0001~\u0001~\u0001~\u0003~\u0751\b~\u0001"+
		"~\u0005~\u0754\b~\n~\f~\u0757\t~\u0001\u007f\u0005\u007f\u075a\b\u007f"+
		"\n\u007f\f\u007f\u075d\t\u007f\u0001\u007f\u0001\u007f\u0001\u007f\u0001"+
		"\u007f\u0001\u007f\u0001\u007f\u0003\u007f\u0765\b\u007f\u0001\u007f\u0005"+
		"\u007f\u0768\b\u007f\n\u007f\f\u007f\u076b\t\u007f\u0001\u0080\u0001\u0080"+
		"\u0003\u0080\u076f\b\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080"+
		"\u0001\u0080\u0003\u0080\u0776\b\u0080\u0001\u0081\u0003\u0081\u0779\b"+
		"\u0081\u0001\u0081\u0001\u0081\u0003\u0081\u077d\b\u0081\u0005\u0081\u077f"+
		"\b\u0081\n\u0081\f\u0081\u0782\t\u0081\u0001\u0082\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0003\u0082\u078b\b\u0082"+
		"\u0001\u0083\u0001\u0083\u0001\u0084\u0001\u0084\u0001\u0085\u0001\u0085"+
		"\u0001\u0086\u0001\u0086\u0001\u0087\u0001\u0087\u0001\u0088\u0001\u0088"+
		"\u0001\u0089\u0001\u0089\u0001\u0089\u0000\u0002v\u00a4\u008a\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe"+
		"\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0000\u0019"+
		"\u0002\u000088RR\u0002\u000066zz\u0001\u0000\u00db\u00dc\u0002\u0000_"+
		"_ww\u0001\u0000\u00cf\u00d0\u0002\u0000\u00c8\u00c8\u00ca\u00cb\u0001"+
		"\u0000\u00a5\u00a6\u0001\u0000XY\u0001\u0000rs\u0001\u0000\u00cc\u00ce"+
		"\u0002\u0000\u00ca\u00cb\u00d2\u00d2\u0001\u0000\u00be\u00bf\u0002\u0000"+
		"\u00ab\u00ac\u00c4\u00c5\u0001\u0000\u00a7\u00aa\u0004\u0000\u00ad\u00af"+
		"\u00b1\u00b9\u00bd\u00bd\u00dd\u00dd\u0001\u0000\u00ca\u00cb\u0002\u0000"+
		"\u00e2\u00e3\u00e5\u00e6\u0002\u000066kk\u0002\u0000,,MM\u0002\u0000,"+
		"\u00a0\u00e1\u00e1\u0004\u0000,,MMnqvv\u0001\u0000\u0099\u00a0\u0001\u0000"+
		"\u0089\u0098\u0007\u0000--00>>^_jjttww\t\u0000--/0=>OO\\_jjttww}\u007f"+
		"\u0888\u0000\u0115\u0001\u0000\u0000\u0000\u0002\u0126\u0001\u0000\u0000"+
		"\u0000\u0004\u0144\u0001\u0000\u0000\u0000\u0006\u0147\u0001\u0000\u0000"+
		"\u0000\b\u014e\u0001\u0000\u0000\u0000\n\u0156\u0001\u0000\u0000\u0000"+
		"\f\u0162\u0001\u0000\u0000\u0000\u000e\u0164\u0001\u0000\u0000\u0000\u0010"+
		"\u016c\u0001\u0000\u0000\u0000\u0012\u0179\u0001\u0000\u0000\u0000\u0014"+
		"\u017b\u0001\u0000\u0000\u0000\u0016\u0191\u0001\u0000\u0000\u0000\u0018"+
		"\u0194\u0001\u0000\u0000\u0000\u001a\u01ab\u0001\u0000\u0000\u0000\u001c"+
		"\u01d7\u0001\u0000\u0000\u0000\u001e\u01d9\u0001\u0000\u0000\u0000 \u01ef"+
		"\u0001\u0000\u0000\u0000\"\u01f1\u0001\u0000\u0000\u0000$\u01f9\u0001"+
		"\u0000\u0000\u0000&\u0202\u0001\u0000\u0000\u0000(\u0207\u0001\u0000\u0000"+
		"\u0000*\u020f\u0001\u0000\u0000\u0000,\u021b\u0001\u0000\u0000\u0000."+
		"\u021f\u0001\u0000\u0000\u00000\u022f\u0001\u0000\u0000\u00002\u0236\u0001"+
		"\u0000\u0000\u00004\u023c\u0001\u0000\u0000\u00006\u0259\u0001\u0000\u0000"+
		"\u00008\u025b\u0001\u0000\u0000\u0000:\u025d\u0001\u0000\u0000\u0000<"+
		"\u027d\u0001\u0000\u0000\u0000>\u027f\u0001\u0000\u0000\u0000@\u0283\u0001"+
		"\u0000\u0000\u0000B\u0288\u0001\u0000\u0000\u0000D\u028b\u0001\u0000\u0000"+
		"\u0000F\u028f\u0001\u0000\u0000\u0000H\u0299\u0001\u0000\u0000\u0000J"+
		"\u029f\u0001\u0000\u0000\u0000L\u02b5\u0001\u0000\u0000\u0000N\u02b7\u0001"+
		"\u0000\u0000\u0000P\u02b9\u0001\u0000\u0000\u0000R\u02da\u0001\u0000\u0000"+
		"\u0000T\u02e0\u0001\u0000\u0000\u0000V\u02e6\u0001\u0000\u0000\u0000X"+
		"\u02ec\u0001\u0000\u0000\u0000Z\u02f2\u0001\u0000\u0000\u0000\\\u02f5"+
		"\u0001\u0000\u0000\u0000^\u02fb\u0001\u0000\u0000\u0000`\u0332\u0001\u0000"+
		"\u0000\u0000b\u0345\u0001\u0000\u0000\u0000d\u0355\u0001\u0000\u0000\u0000"+
		"f\u0358\u0001\u0000\u0000\u0000h\u035c\u0001\u0000\u0000\u0000j\u0360"+
		"\u0001\u0000\u0000\u0000l\u036d\u0001\u0000\u0000\u0000n\u0371\u0001\u0000"+
		"\u0000\u0000p\u0385\u0001\u0000\u0000\u0000r\u0388\u0001\u0000\u0000\u0000"+
		"t\u0395\u0001\u0000\u0000\u0000v\u03af\u0001\u0000\u0000\u0000x\u03b9"+
		"\u0001\u0000\u0000\u0000z\u03cc\u0001\u0000\u0000\u0000|\u03ce\u0001\u0000"+
		"\u0000\u0000~\u03d2\u0001\u0000\u0000\u0000\u0080\u0418\u0001\u0000\u0000"+
		"\u0000\u0082\u0423\u0001\u0000\u0000\u0000\u0084\u0427\u0001\u0000\u0000"+
		"\u0000\u0086\u0429\u0001\u0000\u0000\u0000\u0088\u0430\u0001\u0000\u0000"+
		"\u0000\u008a\u043e\u0001\u0000\u0000\u0000\u008c\u0442\u0001\u0000\u0000"+
		"\u0000\u008e\u0447\u0001\u0000\u0000\u0000\u0090\u044f\u0001\u0000\u0000"+
		"\u0000\u0092\u0453\u0001\u0000\u0000\u0000\u0094\u0456\u0001\u0000\u0000"+
		"\u0000\u0096\u045a\u0001\u0000\u0000\u0000\u0098\u045f\u0001\u0000\u0000"+
		"\u0000\u009a\u0464\u0001\u0000\u0000\u0000\u009c\u0471\u0001\u0000\u0000"+
		"\u0000\u009e\u0494\u0001\u0000\u0000\u0000\u00a0\u0496\u0001\u0000\u0000"+
		"\u0000\u00a2\u049e\u0001\u0000\u0000\u0000\u00a4\u04ff\u0001\u0000\u0000"+
		"\u0000\u00a6\u0542\u0001\u0000\u0000\u0000\u00a8\u054f\u0001\u0000\u0000"+
		"\u0000\u00aa\u0584\u0001\u0000\u0000\u0000\u00ac\u0587\u0001\u0000\u0000"+
		"\u0000\u00ae\u058e\u0001\u0000\u0000\u0000\u00b0\u05af\u0001\u0000\u0000"+
		"\u0000\u00b2\u05b1\u0001\u0000\u0000\u0000\u00b4\u05c3\u0001\u0000\u0000"+
		"\u0000\u00b6\u05ce\u0001\u0000\u0000\u0000\u00b8\u05d3\u0001\u0000\u0000"+
		"\u0000\u00ba\u05d5\u0001\u0000\u0000\u0000\u00bc\u05df\u0001\u0000\u0000"+
		"\u0000\u00be\u05f6\u0001\u0000\u0000\u0000\u00c0\u05f8\u0001\u0000\u0000"+
		"\u0000\u00c2\u0605\u0001\u0000\u0000\u0000\u00c4\u060e\u0001\u0000\u0000"+
		"\u0000\u00c6\u061a\u0001\u0000\u0000\u0000\u00c8\u061d\u0001\u0000\u0000"+
		"\u0000\u00ca\u0648\u0001\u0000\u0000\u0000\u00cc\u0651\u0001\u0000\u0000"+
		"\u0000\u00ce\u0665\u0001\u0000\u0000\u0000\u00d0\u067a\u0001\u0000\u0000"+
		"\u0000\u00d2\u067c\u0001\u0000\u0000\u0000\u00d4\u0684\u0001\u0000\u0000"+
		"\u0000\u00d6\u069e\u0001\u0000\u0000\u0000\u00d8\u06a0\u0001\u0000\u0000"+
		"\u0000\u00da\u06c6\u0001\u0000\u0000\u0000\u00dc\u06cd\u0001\u0000\u0000"+
		"\u0000\u00de\u06d3\u0001\u0000\u0000\u0000\u00e0\u06d5\u0001\u0000\u0000"+
		"\u0000\u00e2\u06e9\u0001\u0000\u0000\u0000\u00e4\u06eb\u0001\u0000\u0000"+
		"\u0000\u00e6\u0702\u0001\u0000\u0000\u0000\u00e8\u0707\u0001\u0000\u0000"+
		"\u0000\u00ea\u0709\u0001\u0000\u0000\u0000\u00ec\u0711\u0001\u0000\u0000"+
		"\u0000\u00ee\u071e\u0001\u0000\u0000\u0000\u00f0\u0720\u0001\u0000\u0000"+
		"\u0000\u00f2\u0725\u0001\u0000\u0000\u0000\u00f4\u072c\u0001\u0000\u0000"+
		"\u0000\u00f6\u072f\u0001\u0000\u0000\u0000\u00f8\u0745\u0001\u0000\u0000"+
		"\u0000\u00fa\u0749\u0001\u0000\u0000\u0000\u00fc\u0750\u0001\u0000\u0000"+
		"\u0000\u00fe\u075b\u0001\u0000\u0000\u0000\u0100\u0775\u0001\u0000\u0000"+
		"\u0000\u0102\u0778\u0001\u0000\u0000\u0000\u0104\u078a\u0001\u0000\u0000"+
		"\u0000\u0106\u078c\u0001\u0000\u0000\u0000\u0108\u078e\u0001\u0000\u0000"+
		"\u0000\u010a\u0790\u0001\u0000\u0000\u0000\u010c\u0792\u0001\u0000\u0000"+
		"\u0000\u010e\u0794\u0001\u0000\u0000\u0000\u0110\u0796\u0001\u0000\u0000"+
		"\u0000\u0112\u0798\u0001\u0000\u0000\u0000\u0114\u0116\u0005\n\u0000\u0000"+
		"\u0115\u0114\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000"+
		"\u0116\u011b\u0001\u0000\u0000\u0000\u0117\u011a\u0003\u0002\u0001\u0000"+
		"\u0118\u011a\u0003\b\u0004\u0000\u0119\u0117\u0001\u0000\u0000\u0000\u0119"+
		"\u0118\u0001\u0000\u0000\u0000\u011a\u011d\u0001\u0000\u0000\u0000\u011b"+
		"\u0119\u0001\u0000\u0000\u0000\u011b\u011c\u0001\u0000\u0000\u0000\u011c"+
		"\u011e\u0001\u0000\u0000\u0000\u011d\u011b\u0001\u0000\u0000\u0000\u011e"+
		"\u011f\u0005\u0000\u0000\u0001\u011f\u0001\u0001\u0000\u0000\u0000\u0120"+
		"\u0122\u0003\u0004\u0002\u0000\u0121\u0120\u0001\u0000\u0000\u0000\u0122"+
		"\u0123\u0001\u0000\u0000\u0000\u0123\u0121\u0001\u0000\u0000\u0000\u0123"+
		"\u0124\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000\u0125"+
		"\u0127\u0003\u0006\u0003\u0000\u0126\u0121\u0001\u0000\u0000\u0000\u0126"+
		"\u0125\u0001\u0000\u0000\u0000\u0127\u0003\u0001\u0000\u0000\u0000\u0128"+
		"\u0145\u0005\b\u0000\u0000\u0129\u0145\u0005\u000f\u0000\u0000\u012a\u0145"+
		"\u0005\u0006\u0000\u0000\u012b\u0145\u0005\t\u0000\u0000\u012c\u0145\u0005"+
		"\u0018\u0000\u0000\u012d\u0145\u0005\u0010\u0000\u0000\u012e\u0145\u0005"+
		"\u0011\u0000\u0000\u012f\u0145\u0005\u0002\u0000\u0000\u0130\u0145\u0005"+
		"\u0012\u0000\u0000\u0131\u0145\u0005\u0013\u0000\u0000\u0132\u0145\u0005"+
		"\u001b\u0000\u0000\u0133\u0145\u0005\u0014\u0000\u0000\u0134\u0145\u0005"+
		"\u001f\u0000\u0000\u0135\u0145\u0005\u0015\u0000\u0000\u0136\u0145\u0005"+
		"\u0016\u0000\u0000\u0137\u0145\u0005\u001c\u0000\u0000\u0138\u0145\u0005"+
		" \u0000\u0000\u0139\u0145\u0005%\u0000\u0000\u013a\u0145\u0005\u0005\u0000"+
		"\u0000\u013b\u0145\u0005#\u0000\u0000\u013c\u0140\u0005\u0003\u0000\u0000"+
		"\u013d\u013f\u0005\f\u0000\u0000\u013e\u013d\u0001\u0000\u0000\u0000\u013f"+
		"\u0142\u0001\u0000\u0000\u0000\u0140\u013e\u0001\u0000\u0000\u0000\u0140"+
		"\u0141\u0001\u0000\u0000\u0000\u0141\u0143\u0001\u0000\u0000\u0000\u0142"+
		"\u0140\u0001\u0000\u0000\u0000\u0143\u0145\u0005\r\u0000\u0000\u0144\u0128"+
		"\u0001\u0000\u0000\u0000\u0144\u0129\u0001\u0000\u0000\u0000\u0144\u012a"+
		"\u0001\u0000\u0000\u0000\u0144\u012b\u0001\u0000\u0000\u0000\u0144\u012c"+
		"\u0001\u0000\u0000\u0000\u0144\u012d\u0001\u0000\u0000\u0000\u0144\u012e"+
		"\u0001\u0000\u0000\u0000\u0144\u012f\u0001\u0000\u0000\u0000\u0144\u0130"+
		"\u0001\u0000\u0000\u0000\u0144\u0131\u0001\u0000\u0000\u0000\u0144\u0132"+
		"\u0001\u0000\u0000\u0000\u0144\u0133\u0001\u0000\u0000\u0000\u0144\u0134"+
		"\u0001\u0000\u0000\u0000\u0144\u0135\u0001\u0000\u0000\u0000\u0144\u0136"+
		"\u0001\u0000\u0000\u0000\u0144\u0137\u0001\u0000\u0000\u0000\u0144\u0138"+
		"\u0001\u0000\u0000\u0000\u0144\u0139\u0001\u0000\u0000\u0000\u0144\u013a"+
		"\u0001\u0000\u0000\u0000\u0144\u013b\u0001\u0000\u0000\u0000\u0144\u013c"+
		"\u0001\u0000\u0000\u0000\u0145\u0005\u0001\u0000\u0000\u0000\u0146\u0148"+
		"\u0005\"\u0000\u0000\u0147\u0146\u0001\u0000\u0000\u0000\u0148\u0149\u0001"+
		"\u0000\u0000\u0000\u0149\u0147\u0001\u0000\u0000\u0000\u0149\u014a\u0001"+
		"\u0000\u0000\u0000\u014a\u0007\u0001\u0000\u0000\u0000\u014b\u014d\u0003"+
		"\n\u0005\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014d\u0150\u0001\u0000"+
		"\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000"+
		"\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000"+
		"\u0000\u0000\u0151\u0153\u0003\f\u0006\u0000\u0152\u0151\u0001\u0000\u0000"+
		"\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154\u0152\u0001\u0000\u0000"+
		"\u0000\u0154\u0155\u0001\u0000\u0000\u0000\u0155\t\u0001\u0000\u0000\u0000"+
		"\u0156\u0157\u0005W\u0000\u0000\u0157\u0158\u0005g\u0000\u0000\u0158\u0159"+
		"\u0003\u00ceg\u0000\u0159\u015a\u0005\u00dc\u0000\u0000\u015a\u000b\u0001"+
		"\u0000\u0000\u0000\u015b\u0163\u00036\u001b\u0000\u015c\u0163\u0003\u000e"+
		"\u0007\u0000\u015d\u0163\u0003\u0014\n\u0000\u015e\u0163\u0003\u0018\f"+
		"\u0000\u015f\u0163\u0003\u001a\r\u0000\u0160\u0163\u0003\u009aM\u0000"+
		"\u0161\u0163\u0003\u009cN\u0000\u0162\u015b\u0001\u0000\u0000\u0000\u0162"+
		"\u015c\u0001\u0000\u0000\u0000\u0162\u015d\u0001\u0000\u0000\u0000\u0162"+
		"\u015e\u0001\u0000\u0000\u0000\u0162\u015f\u0001\u0000\u0000\u0000\u0162"+
		"\u0160\u0001\u0000\u0000\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0163"+
		"\r\u0001\u0000\u0000\u0000\u0164\u0166\u0005\u0080\u0000\u0000\u0165\u0167"+
		"\u0007\u0000\u0000\u0000\u0166\u0165\u0001\u0000\u0000\u0000\u0166\u0167"+
		"\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0169"+
		"\u0003\u0010\b\u0000\u0169\u016a\u0005\u00dc\u0000\u0000\u016a\u000f\u0001"+
		"\u0000\u0000\u0000\u016b\u016d\u0005\u00c2\u0000\u0000\u016c\u016b\u0001"+
		"\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d\u016e\u0001"+
		"\u0000\u0000\u0000\u016e\u0176\u0003\u0012\t\u0000\u016f\u0171\u0005\u00da"+
		"\u0000\u0000\u0170\u0172\u0005\u00c2\u0000\u0000\u0171\u0170\u0001\u0000"+
		"\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0173\u0001\u0000"+
		"\u0000\u0000\u0173\u0175\u0003\u0012\t\u0000\u0174\u016f\u0001\u0000\u0000"+
		"\u0000\u0175\u0178\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000"+
		"\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u0011\u0001\u0000\u0000"+
		"\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u017a\u0003\u00ceg\u0000"+
		"\u017a\u0013\u0001\u0000\u0000\u0000\u017b\u018a\u0005g\u0000\u0000\u017c"+
		"\u017e\u0003\u00ceg\u0000\u017d\u017c\u0001\u0000\u0000\u0000\u017d\u017e"+
		"\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f\u0183"+
		"\u0005\u00d8\u0000\u0000\u0180\u0182\u0003\u0016\u000b\u0000\u0181\u0180"+
		"\u0001\u0000\u0000\u0000\u0182\u0185\u0001\u0000\u0000\u0000\u0183\u0181"+
		"\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u0184\u0186"+
		"\u0001\u0000\u0000\u0000\u0185\u0183\u0001\u0000\u0000\u0000\u0186\u018b"+
		"\u0005\u00d9\u0000\u0000\u0187\u0188\u0003\u00ceg\u0000\u0188\u0189\u0005"+
		"\u00dc\u0000\u0000\u0189\u018b\u0001\u0000\u0000\u0000\u018a\u017d\u0001"+
		"\u0000\u0000\u0000\u018a\u0187\u0001\u0000\u0000\u0000\u018b\u0015\u0001"+
		"\u0000\u0000\u0000\u018c\u0192\u00036\u001b\u0000\u018d\u0192\u0003\u000e"+
		"\u0007\u0000\u018e\u0192\u0003\u0018\f\u0000\u018f\u0192\u0003\u001a\r"+
		"\u0000\u0190\u0192\u0003\u009aM\u0000\u0191\u018c\u0001\u0000\u0000\u0000"+
		"\u0191\u018d\u0001\u0000\u0000\u0000\u0191\u018e\u0001\u0000\u0000\u0000"+
		"\u0191\u018f\u0001\u0000\u0000\u0000\u0191\u0190\u0001\u0000\u0000\u0000"+
		"\u0192\u0017\u0001\u0000\u0000\u0000\u0193\u0195\u0003,\u0016\u0000\u0194"+
		"\u0193\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195"+
		"\u0196\u0001\u0000\u0000\u0000\u0196\u0198\u0005R\u0000\u0000\u0197\u0199"+
		"\u0005\u00c6\u0000\u0000\u0198\u0197\u0001\u0000\u0000\u0000\u0198\u0199"+
		"\u0001\u0000\u0000\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a\u019c"+
		"\u0003\u0108\u0084\u0000\u019b\u019d\u0003 \u0010\u0000\u019c\u019b\u0001"+
		"\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d\u019e\u0001"+
		"\u0000\u0000\u0000\u019e\u019f\u0005\u00d4\u0000\u0000\u019f\u01a0\u0003"+
		"r9\u0000\u01a0\u01a6\u0005\u00d5\u0000\u0000\u01a1\u01a3\u0005\u00db\u0000"+
		"\u0000\u01a2\u01a4\u0005\u00d3\u0000\u0000\u01a3\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a3\u01a4\u0001\u0000\u0000\u0000\u01a4\u01a5\u0001\u0000\u0000"+
		"\u0000\u01a5\u01a7\u0003v;\u0000\u01a6\u01a1\u0001\u0000\u0000\u0000\u01a6"+
		"\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a9\u0003:\u001d\u0000\u01a9\u0019\u0001\u0000\u0000\u0000\u01aa\u01ac"+
		"\u0003,\u0016\u0000\u01ab\u01aa\u0001\u0000\u0000\u0000\u01ab\u01ac\u0001"+
		"\u0000\u0000\u0000\u01ac\u01ae\u0001\u0000\u0000\u0000\u01ad\u01af\u0005"+
		"n\u0000\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01ae\u01af\u0001\u0000"+
		"\u0000\u0000\u01af\u01b1\u0001\u0000\u0000\u0000\u01b0\u01b2\u0003\u0106"+
		"\u0083\u0000\u01b1\u01b0\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b2\u01b4\u0001\u0000\u0000\u0000\u01b3\u01b5\u0005l\u0000"+
		"\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000"+
		"\u0000\u01b5\u01cc\u0001\u0000\u0000\u0000\u01b6\u01b7\u0003\u001c\u000e"+
		"\u0000\u01b7\u01b9\u0003\u0108\u0084\u0000\u01b8\u01ba\u0003 \u0010\u0000"+
		"\u01b9\u01b8\u0001\u0000\u0000\u0000\u01b9\u01ba\u0001\u0000\u0000\u0000"+
		"\u01ba\u01bd\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005L\u0000\u0000\u01bc"+
		"\u01be\u0003\u00c4b\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01bd\u01be"+
		"\u0001\u0000\u0000\u0000\u01be\u01c1\u0001\u0000\u0000\u0000\u01bf\u01c0"+
		"\u0005V\u0000\u0000\u01c0\u01c2\u0003\u001e\u000f\u0000\u01c1\u01bf\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000\u01c2\u01cd\u0001"+
		"\u0000\u0000\u0000\u01c3\u01c4\u0005`\u0000\u0000\u01c4\u01c6\u0003\u0108"+
		"\u0084\u0000\u01c5\u01c7\u0003 \u0010\u0000\u01c6\u01c5\u0001\u0000\u0000"+
		"\u0000\u01c6\u01c7\u0001\u0000\u0000\u0000\u01c7\u01ca\u0001\u0000\u0000"+
		"\u0000\u01c8\u01c9\u0005L\u0000\u0000\u01c9\u01cb\u0003\u001e\u000f\u0000"+
		"\u01ca\u01c8\u0001\u0000\u0000\u0000\u01ca\u01cb\u0001\u0000\u0000\u0000"+
		"\u01cb\u01cd\u0001\u0000\u0000\u0000\u01cc\u01b6\u0001\u0000\u0000\u0000"+
		"\u01cc\u01c3\u0001\u0000\u0000\u0000\u01cd\u01ce\u0001\u0000\u0000\u0000"+
		"\u01ce\u01d2\u0005\u00d8\u0000\u0000\u01cf\u01d1\u0003\u0080@\u0000\u01d0"+
		"\u01cf\u0001\u0000\u0000\u0000\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2"+
		"\u01d0\u0001\u0000\u0000\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3"+
		"\u01d5\u0001\u0000\u0000\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5"+
		"\u01d6\u0005\u00d9\u0000\u0000\u01d6\u001b\u0001\u0000\u0000\u0000\u01d7"+
		"\u01d8\u0007\u0001\u0000\u0000\u01d8\u001d\u0001\u0000\u0000\u0000\u01d9"+
		"\u01de\u0003\u00c4b\u0000\u01da\u01db\u0005\u00da\u0000\u0000\u01db\u01dd"+
		"\u0003\u00c4b\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01e0\u0001"+
		"\u0000\u0000\u0000\u01de\u01dc\u0001\u0000\u0000\u0000\u01de\u01df\u0001"+
		"\u0000\u0000\u0000\u01df\u001f\u0001\u0000\u0000\u0000\u01e0\u01de\u0001"+
		"\u0000\u0000\u0000\u01e1\u01e2\u0005\u00a2\u0000\u0000\u01e2\u01e3\u0003"+
		"\"\u0011\u0000\u01e3\u01e4\u0005\u00a3\u0000\u0000\u01e4\u01f0\u0001\u0000"+
		"\u0000\u0000\u01e5\u01e6\u0005\u00a2\u0000\u0000\u01e6\u01e7\u0003$\u0012"+
		"\u0000\u01e7\u01e8\u0005\u00a3\u0000\u0000\u01e8\u01f0\u0001\u0000\u0000"+
		"\u0000\u01e9\u01ea\u0005\u00a2\u0000\u0000\u01ea\u01eb\u0003\"\u0011\u0000"+
		"\u01eb\u01ec\u0005\u00da\u0000\u0000\u01ec\u01ed\u0003$\u0012\u0000\u01ed"+
		"\u01ee\u0005\u00a3\u0000\u0000\u01ee\u01f0\u0001\u0000\u0000\u0000\u01ef"+
		"\u01e1\u0001\u0000\u0000\u0000\u01ef\u01e5\u0001\u0000\u0000\u0000\u01ef"+
		"\u01e9\u0001\u0000\u0000\u0000\u01f0!\u0001\u0000\u0000\u0000\u01f1\u01f6"+
		"\u0003&\u0013\u0000\u01f2\u01f3\u0005\u00da\u0000\u0000\u01f3\u01f5\u0003"+
		"&\u0013\u0000\u01f4\u01f2\u0001\u0000\u0000\u0000\u01f5\u01f8\u0001\u0000"+
		"\u0000\u0000\u01f6\u01f4\u0001\u0000\u0000\u0000\u01f6\u01f7\u0001\u0000"+
		"\u0000\u0000\u01f7#\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000"+
		"\u0000\u01f9\u01fe\u0003(\u0014\u0000\u01fa\u01fb\u0005\u00da\u0000\u0000"+
		"\u01fb\u01fd\u0003(\u0014\u0000\u01fc\u01fa\u0001\u0000\u0000\u0000\u01fd"+
		"\u0200\u0001\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000\u01fe"+
		"\u01ff\u0001\u0000\u0000\u0000\u01ff%\u0001\u0000\u0000\u0000\u0200\u01fe"+
		"\u0001\u0000\u0000\u0000\u0201\u0203\u0003,\u0016\u0000\u0202\u0201\u0001"+
		"\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000\u0203\u0204\u0001"+
		"\u0000\u0000\u0000\u0204\u0205\u0003\u0108\u0084\u0000\u0205\'\u0001\u0000"+
		"\u0000\u0000\u0206\u0208\u0003,\u0016\u0000\u0207\u0206\u0001\u0000\u0000"+
		"\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u0209\u0001\u0000\u0000"+
		"\u0000\u0209\u020a\u0003\u0108\u0084\u0000\u020a\u020d\u0005\u00dd\u0000"+
		"\u0000\u020b\u020e\u0003\u00c4b\u0000\u020c\u020e\u0003\u0110\u0088\u0000"+
		"\u020d\u020b\u0001\u0000\u0000\u0000\u020d\u020c\u0001\u0000\u0000\u0000"+
		"\u020e)\u0001\u0000\u0000\u0000\u020f\u0210\u0005\u00a2\u0000\u0000\u0210"+
		"\u0215\u0003\u00c6c\u0000\u0211\u0212\u0005\u00da\u0000\u0000\u0212\u0214"+
		"\u0003\u00c6c\u0000\u0213\u0211\u0001\u0000\u0000\u0000\u0214\u0217\u0001"+
		"\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0215\u0216\u0001"+
		"\u0000\u0000\u0000\u0216\u0218\u0001\u0000\u0000\u0000\u0217\u0215\u0001"+
		"\u0000\u0000\u0000\u0218\u0219\u0005\u00a3\u0000\u0000\u0219+\u0001\u0000"+
		"\u0000\u0000\u021a\u021c\u0003.\u0017\u0000\u021b\u021a\u0001\u0000\u0000"+
		"\u0000\u021c\u021d\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000\u0000"+
		"\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e-\u0001\u0000\u0000\u0000"+
		"\u021f\u0223\u0005+\u0000\u0000\u0220\u0221\u0003\u0108\u0084\u0000\u0221"+
		"\u0222\u0005\u00db\u0000\u0000\u0222\u0224\u0001\u0000\u0000\u0000\u0223"+
		"\u0220\u0001\u0000\u0000\u0000\u0223\u0224\u0001\u0000\u0000\u0000\u0224"+
		"\u0225\u0001\u0000\u0000\u0000\u0225\u022a\u00030\u0018\u0000\u0226\u0227"+
		"\u0005\u00da\u0000\u0000\u0227\u0229\u00030\u0018\u0000\u0228\u0226\u0001"+
		"\u0000\u0000\u0000\u0229\u022c\u0001\u0000\u0000\u0000\u022a\u0228\u0001"+
		"\u0000\u0000\u0000\u022a\u022b\u0001\u0000\u0000\u0000\u022b\u022d\u0001"+
		"\u0000\u0000\u0000\u022c\u022a\u0001\u0000\u0000\u0000\u022d\u022e\u0005"+
		"\u00d7\u0000\u0000\u022e/\u0001\u0000\u0000\u0000\u022f\u0231\u0003\u00cc"+
		"f\u0000\u0230\u0232\u0003\u00d4j\u0000\u0231\u0230\u0001\u0000\u0000\u0000"+
		"\u0231\u0232\u0001\u0000\u0000\u0000\u02321\u0001\u0000\u0000\u0000\u0233"+
		"\u0235\u00034\u001a\u0000\u0234\u0233\u0001\u0000\u0000\u0000\u0235\u0238"+
		"\u0001\u0000\u0000\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0236\u0237"+
		"\u0001\u0000\u0000\u0000\u02373\u0001\u0000\u0000\u0000\u0238\u0236\u0001"+
		"\u0000\u0000\u0000\u0239\u023d\u00036\u001b\u0000\u023a\u023d\u0003\u0018"+
		"\f\u0000\u023b\u023d\u0003\u001a\r\u0000\u023c\u0239\u0001\u0000\u0000"+
		"\u0000\u023c\u023a\u0001\u0000\u0000\u0000\u023c\u023b\u0001\u0000\u0000"+
		"\u0000\u023d5\u0001\u0000\u0000\u0000\u023e\u023f\u0003\u0108\u0084\u0000"+
		"\u023f\u0240\u0005\u00db\u0000\u0000\u0240\u025a\u0001\u0000\u0000\u0000"+
		"\u0241\u025a\u0003:\u001d\u0000\u0242\u025a\u0003<\u001e\u0000\u0243\u025a"+
		"\u0003F#\u0000\u0244\u025a\u0003H$\u0000\u0245\u025a\u0003J%\u0000\u0246"+
		"\u025a\u0003P(\u0000\u0247\u025a\u0003T*\u0000\u0248\u025a\u0003V+\u0000"+
		"\u0249\u025a\u0003X,\u0000\u024a\u024b\u0003\u00ba]\u0000\u024b\u024c"+
		"\u0005\u00dc\u0000\u0000\u024c\u025a\u0001\u0000\u0000\u0000\u024d\u025a"+
		"\u0003x<\u0000\u024e\u025a\u0003~?\u0000\u024f\u025a\u0003|>\u0000\u0250"+
		"\u025a\u0003Z-\u0000\u0251\u025a\u0003\\.\u0000\u0252\u025a\u0003^/\u0000"+
		"\u0253\u025a\u0003`0\u0000\u0254\u025a\u0003f3\u0000\u0255\u025a\u0003"+
		"h4\u0000\u0256\u025a\u0003j5\u0000\u0257\u025a\u00038\u001c\u0000\u0258"+
		"\u025a\u0003l6\u0000\u0259\u023e\u0001\u0000\u0000\u0000\u0259\u0241\u0001"+
		"\u0000\u0000\u0000\u0259\u0242\u0001\u0000\u0000\u0000\u0259\u0243\u0001"+
		"\u0000\u0000\u0000\u0259\u0244\u0001\u0000\u0000\u0000\u0259\u0245\u0001"+
		"\u0000\u0000\u0000\u0259\u0246\u0001\u0000\u0000\u0000\u0259\u0247\u0001"+
		"\u0000\u0000\u0000\u0259\u0248\u0001\u0000\u0000\u0000\u0259\u0249\u0001"+
		"\u0000\u0000\u0000\u0259\u024a\u0001\u0000\u0000\u0000\u0259\u024d\u0001"+
		"\u0000\u0000\u0000\u0259\u024e\u0001\u0000\u0000\u0000\u0259\u024f\u0001"+
		"\u0000\u0000\u0000\u0259\u0250\u0001\u0000\u0000\u0000\u0259\u0251\u0001"+
		"\u0000\u0000\u0000\u0259\u0252\u0001\u0000\u0000\u0000\u0259\u0253\u0001"+
		"\u0000\u0000\u0000\u0259\u0254\u0001\u0000\u0000\u0000\u0259\u0255\u0001"+
		"\u0000\u0000\u0000\u0259\u0256\u0001\u0000\u0000\u0000\u0259\u0257\u0001"+
		"\u0000\u0000\u0000\u0259\u0258\u0001\u0000\u0000\u0000\u025a7\u0001\u0000"+
		"\u0000\u0000\u025b\u025c\u0005\u00dc\u0000\u0000\u025c9\u0001\u0000\u0000"+
		"\u0000\u025d\u025e\u0005\u00d8\u0000\u0000\u025e\u025f\u00032\u0019\u0000"+
		"\u025f\u0260\u0005\u00d9\u0000\u0000\u0260;\u0001\u0000\u0000\u0000\u0261"+
		"\u0262\u0005U\u0000\u0000\u0262\u0263\u0003\u00a2Q\u0000\u0263\u0267\u0003"+
		"6\u001b\u0000\u0264\u0266\u0003>\u001f\u0000\u0265\u0264\u0001\u0000\u0000"+
		"\u0000\u0266\u0269\u0001\u0000\u0000\u0000\u0267\u0265\u0001\u0000\u0000"+
		"\u0000\u0267\u0268\u0001\u0000\u0000\u0000\u0268\u026b\u0001\u0000\u0000"+
		"\u0000\u0269\u0267\u0001\u0000\u0000\u0000\u026a\u026c\u0003B!\u0000\u026b"+
		"\u026a\u0001\u0000\u0000\u0000\u026b\u026c\u0001\u0000\u0000\u0000\u026c"+
		"\u027e\u0001\u0000\u0000\u0000\u026d\u026e\u0005U\u0000\u0000\u026e\u026f"+
		"\u0003\u00a2Q\u0000\u026f\u0270\u0005\u00db\u0000\u0000\u0270\u0274\u0003"+
		"2\u0019\u0000\u0271\u0273\u0003@ \u0000\u0272\u0271\u0001\u0000\u0000"+
		"\u0000\u0273\u0276\u0001\u0000\u0000\u0000\u0274\u0272\u0001\u0000\u0000"+
		"\u0000\u0274\u0275\u0001\u0000\u0000\u0000\u0275\u0278\u0001\u0000\u0000"+
		"\u0000\u0276\u0274\u0001\u0000\u0000\u0000\u0277\u0279\u0003D\"\u0000"+
		"\u0278\u0277\u0001\u0000\u0000\u0000\u0278\u0279\u0001\u0000\u0000\u0000"+
		"\u0279\u027a\u0001\u0000\u0000\u0000\u027a\u027b\u0005G\u0000\u0000\u027b"+
		"\u027c\u0005\u00dc\u0000\u0000\u027c\u027e\u0001\u0000\u0000\u0000\u027d"+
		"\u0261\u0001\u0000\u0000\u0000\u027d\u026d\u0001\u0000\u0000\u0000\u027e"+
		"=\u0001\u0000\u0000\u0000\u027f\u0280\u0005A\u0000\u0000\u0280\u0281\u0003"+
		"\u00a2Q\u0000\u0281\u0282\u00036\u001b\u0000\u0282?\u0001\u0000\u0000"+
		"\u0000\u0283\u0284\u0005A\u0000\u0000\u0284\u0285\u0003\u00a2Q\u0000\u0285"+
		"\u0286\u0005\u00db\u0000\u0000\u0286\u0287\u00032\u0019\u0000\u0287A\u0001"+
		"\u0000\u0000\u0000\u0288\u0289\u0005@\u0000\u0000\u0289\u028a\u00036\u001b"+
		"\u0000\u028aC\u0001\u0000\u0000\u0000\u028b\u028c\u0005@\u0000\u0000\u028c"+
		"\u028d\u0005\u00db\u0000\u0000\u028d\u028e\u00032\u0019\u0000\u028eE\u0001"+
		"\u0000\u0000\u0000\u028f\u0290\u0005\u0082\u0000\u0000\u0290\u0297\u0003"+
		"\u00a2Q\u0000\u0291\u0298\u00036\u001b\u0000\u0292\u0293\u0005\u00db\u0000"+
		"\u0000\u0293\u0294\u00032\u0019\u0000\u0294\u0295\u0005I\u0000\u0000\u0295"+
		"\u0296\u0005\u00dc\u0000\u0000\u0296\u0298\u0001\u0000\u0000\u0000\u0297"+
		"\u0291\u0001\u0000\u0000\u0000\u0297\u0292\u0001\u0000\u0000\u0000\u0298"+
		"G\u0001\u0000\u0000\u0000\u0299\u029a\u0005<\u0000\u0000\u029a\u029b\u0003"+
		"6\u001b\u0000\u029b\u029c\u0005\u0082\u0000\u0000\u029c\u029d\u0003\u00a2"+
		"Q\u0000\u029d\u029e\u0005\u00dc\u0000\u0000\u029eI\u0001\u0000\u0000\u0000"+
		"\u029f\u02a0\u0005P\u0000\u0000\u02a0\u02a2\u0005\u00d4\u0000\u0000\u02a1"+
		"\u02a3\u0003L&\u0000\u02a2\u02a1\u0001\u0000\u0000\u0000\u02a2\u02a3\u0001"+
		"\u0000\u0000\u0000\u02a3\u02a4\u0001\u0000\u0000\u0000\u02a4\u02a6\u0005"+
		"\u00dc\u0000\u0000\u02a5\u02a7\u0003\u00a0P\u0000\u02a6\u02a5\u0001\u0000"+
		"\u0000\u0000\u02a6\u02a7\u0001\u0000\u0000\u0000\u02a7\u02a8\u0001\u0000"+
		"\u0000\u0000\u02a8\u02aa\u0005\u00dc\u0000\u0000\u02a9\u02ab\u0003N\'"+
		"\u0000\u02aa\u02a9\u0001\u0000\u0000\u0000\u02aa\u02ab\u0001\u0000\u0000"+
		"\u0000\u02ab\u02ac\u0001\u0000\u0000\u0000\u02ac\u02b3\u0005\u00d5\u0000"+
		"\u0000\u02ad\u02b4\u00036\u001b\u0000\u02ae\u02af\u0005\u00db\u0000\u0000"+
		"\u02af\u02b0\u00032\u0019\u0000\u02b0\u02b1\u0005E\u0000\u0000\u02b1\u02b2"+
		"\u0005\u00dc\u0000\u0000\u02b2\u02b4\u0001\u0000\u0000\u0000\u02b3\u02ad"+
		"\u0001\u0000\u0000\u0000\u02b3\u02ae\u0001\u0000\u0000\u0000\u02b4K\u0001"+
		"\u0000\u0000\u0000\u02b5\u02b6\u0003\u00a0P\u0000\u02b6M\u0001\u0000\u0000"+
		"\u0000\u02b7\u02b8\u0003\u00a0P\u0000\u02b8O\u0001\u0000\u0000\u0000\u02b9"+
		"\u02ba\u0005x\u0000\u0000\u02ba\u02d2\u0003\u00a2Q\u0000\u02bb\u02bd\u0005"+
		"\u00d8\u0000\u0000\u02bc\u02be\u0005\u00dc\u0000\u0000\u02bd\u02bc\u0001"+
		"\u0000\u0000\u0000\u02bd\u02be\u0001\u0000\u0000\u0000\u02be\u02c2\u0001"+
		"\u0000\u0000\u0000\u02bf\u02c1\u0003R)\u0000\u02c0\u02bf\u0001\u0000\u0000"+
		"\u0000\u02c1\u02c4\u0001\u0000\u0000\u0000\u02c2\u02c0\u0001\u0000\u0000"+
		"\u0000\u02c2\u02c3\u0001\u0000\u0000\u0000\u02c3\u02c5\u0001\u0000\u0000"+
		"\u0000\u02c4\u02c2\u0001\u0000\u0000\u0000\u02c5\u02d3\u0005\u00d9\u0000"+
		"\u0000\u02c6\u02c8\u0005\u00db\u0000\u0000\u02c7\u02c9\u0005\u00dc\u0000"+
		"\u0000\u02c8\u02c7\u0001\u0000\u0000\u0000\u02c8\u02c9\u0001\u0000\u0000"+
		"\u0000\u02c9\u02cd\u0001\u0000\u0000\u0000\u02ca\u02cc\u0003R)\u0000\u02cb"+
		"\u02ca\u0001\u0000\u0000\u0000\u02cc\u02cf\u0001\u0000\u0000\u0000\u02cd"+
		"\u02cb\u0001\u0000\u0000\u0000\u02cd\u02ce\u0001\u0000\u0000\u0000\u02ce"+
		"\u02d0\u0001\u0000\u0000\u0000\u02cf\u02cd\u0001\u0000\u0000\u0000\u02d0"+
		"\u02d1\u0005H\u0000\u0000\u02d1\u02d3\u0005\u00dc\u0000\u0000\u02d2\u02bb"+
		"\u0001\u0000\u0000\u0000\u02d2\u02c6\u0001\u0000\u0000\u0000\u02d3Q\u0001"+
		"\u0000\u0000\u0000\u02d4\u02d5\u00054\u0000\u0000\u02d5\u02d8\u0003\u00a4"+
		"R\u0000\u02d6\u02d8\u0005;\u0000\u0000\u02d7\u02d4\u0001\u0000\u0000\u0000"+
		"\u02d7\u02d6\u0001\u0000\u0000\u0000\u02d8\u02d9\u0001\u0000\u0000\u0000"+
		"\u02d9\u02db\u0007\u0002\u0000\u0000\u02da\u02d7\u0001\u0000\u0000\u0000"+
		"\u02db\u02dc\u0001\u0000\u0000\u0000\u02dc\u02da\u0001\u0000\u0000\u0000"+
		"\u02dc\u02dd\u0001\u0000\u0000\u0000\u02dd\u02de\u0001\u0000\u0000\u0000"+
		"\u02de\u02df\u00032\u0019\u0000\u02dfS\u0001\u0000\u0000\u0000\u02e0\u02e2"+
		"\u00052\u0000\u0000\u02e1\u02e3\u0003\u00a4R\u0000\u02e2\u02e1\u0001\u0000"+
		"\u0000\u0000\u02e2\u02e3\u0001\u0000\u0000\u0000\u02e3\u02e4\u0001\u0000"+
		"\u0000\u0000\u02e4\u02e5\u0005\u00dc\u0000\u0000\u02e5U\u0001\u0000\u0000"+
		"\u0000\u02e6\u02e8\u00059\u0000\u0000\u02e7\u02e9\u0003\u00a4R\u0000\u02e8"+
		"\u02e7\u0001\u0000\u0000\u0000\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9"+
		"\u02ea\u0001\u0000\u0000\u0000\u02ea\u02eb\u0005\u00dc\u0000\u0000\u02eb"+
		"W\u0001\u0000\u0000\u0000\u02ec\u02ee\u0005u\u0000\u0000\u02ed\u02ef\u0003"+
		"\u00a4R\u0000\u02ee\u02ed\u0001\u0000\u0000\u0000\u02ee\u02ef\u0001\u0000"+
		"\u0000\u0000\u02ef\u02f0\u0001\u0000\u0000\u0000\u02f0\u02f1\u0005\u00dc"+
		"\u0000\u0000\u02f1Y\u0001\u0000\u0000\u0000\u02f2\u02f3\u0003\u00a4R\u0000"+
		"\u02f3\u02f4\u0005\u00dc\u0000\u0000\u02f4[\u0001\u0000\u0000\u0000\u02f5"+
		"\u02f6\u0005\u007f\u0000\u0000\u02f6\u02f7\u0005\u00d4\u0000\u0000\u02f7"+
		"\u02f8\u0003\u00eau\u0000\u02f8\u02f9\u0005\u00d5\u0000\u0000\u02f9\u02fa"+
		"\u0005\u00dc\u0000\u0000\u02fa]\u0001\u0000\u0000\u0000\u02fb\u0328\u0005"+
		"Q\u0000\u0000\u02fc\u02fd\u0005\u00d4\u0000\u0000\u02fd\u02fe\u0003\u00a4"+
		"R\u0000\u02fe\u02ff\u0005.\u0000\u0000\u02ff\u0300\u0003\u00aaU\u0000"+
		"\u0300\u0301\u0005\u00d5\u0000\u0000\u0301\u0329\u0001\u0000\u0000\u0000"+
		"\u0302\u0303\u0005\u00d4\u0000\u0000\u0303\u0304\u0003\u00ecv\u0000\u0304"+
		"\u0306\u0005.\u0000\u0000\u0305\u0307\u0005\u00c6\u0000\u0000\u0306\u0305"+
		"\u0001\u0000\u0000\u0000\u0306\u0307\u0001\u0000\u0000\u0000\u0307\u0308"+
		"\u0001\u0000\u0000\u0000\u0308\u030e\u0003\u00a6S\u0000\u0309\u030b\u0005"+
		"\u00a4\u0000\u0000\u030a\u030c\u0005\u00c6\u0000\u0000\u030b\u030a\u0001"+
		"\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000\u0000\u030c\u030d\u0001"+
		"\u0000\u0000\u0000\u030d\u030f\u0003\u00ecv\u0000\u030e\u0309\u0001\u0000"+
		"\u0000\u0000\u030e\u030f\u0001\u0000\u0000\u0000\u030f\u0310\u0001\u0000"+
		"\u0000\u0000\u0310\u0311\u0005\u00d5\u0000\u0000\u0311\u0329\u0001\u0000"+
		"\u0000\u0000\u0312\u0313\u0005\u00d4\u0000\u0000\u0313\u0314\u0003\u00a4"+
		"R\u0000\u0314\u0315\u0005.\u0000\u0000\u0315\u031b\u0003\u00a6S\u0000"+
		"\u0316\u0318\u0005\u00a4\u0000\u0000\u0317\u0319\u0005\u00c6\u0000\u0000"+
		"\u0318\u0317\u0001\u0000\u0000\u0000\u0318\u0319\u0001\u0000\u0000\u0000"+
		"\u0319\u031a\u0001\u0000\u0000\u0000\u031a\u031c\u0003\u00ecv\u0000\u031b"+
		"\u0316\u0001\u0000\u0000\u0000\u031b\u031c\u0001\u0000\u0000\u0000\u031c"+
		"\u031d\u0001\u0000\u0000\u0000\u031d\u031e\u0005\u00d5\u0000\u0000\u031e"+
		"\u0329\u0001\u0000\u0000\u0000\u031f\u0320\u0005\u00d4\u0000\u0000\u0320"+
		"\u0321\u0003\u00ecv\u0000\u0321\u0322\u0005.\u0000\u0000\u0322\u0323\u0005"+
		"b\u0000\u0000\u0323\u0324\u0005\u00d4\u0000\u0000\u0324\u0325\u0003\u0102"+
		"\u0081\u0000\u0325\u0326\u0005\u00d5\u0000\u0000\u0326\u0327\u0005\u00d5"+
		"\u0000\u0000\u0327\u0329\u0001\u0000\u0000\u0000\u0328\u02fc\u0001\u0000"+
		"\u0000\u0000\u0328\u0302\u0001\u0000\u0000\u0000\u0328\u0312\u0001\u0000"+
		"\u0000\u0000\u0328\u031f\u0001\u0000\u0000\u0000\u0329\u0330\u0001\u0000"+
		"\u0000\u0000\u032a\u0331\u00036\u001b\u0000\u032b\u032c\u0005\u00db\u0000"+
		"\u0000\u032c\u032d\u00032\u0019\u0000\u032d\u032e\u0005F\u0000\u0000\u032e"+
		"\u032f\u0005\u00dc\u0000\u0000\u032f\u0331\u0001\u0000\u0000\u0000\u0330"+
		"\u032a\u0001\u0000\u0000\u0000\u0330\u032b\u0001\u0000\u0000\u0000\u0331"+
		"_\u0001\u0000\u0000\u0000\u0332\u0333\u0005{\u0000\u0000\u0333\u0343\u0003"+
		":\u001d\u0000\u0334\u0336\u0003b1\u0000\u0335\u0334\u0001\u0000\u0000"+
		"\u0000\u0336\u0337\u0001\u0000\u0000\u0000\u0337\u0335\u0001\u0000\u0000"+
		"\u0000\u0337\u0338\u0001\u0000\u0000\u0000\u0338\u033a\u0001\u0000\u0000"+
		"\u0000\u0339\u033b\u0003d2\u0000\u033a\u0339\u0001\u0000\u0000\u0000\u033a"+
		"\u033b\u0001\u0000\u0000\u0000\u033b\u0344\u0001\u0000\u0000\u0000\u033c"+
		"\u033e\u0003b1\u0000\u033d\u033c\u0001\u0000\u0000\u0000\u033e\u0341\u0001"+
		"\u0000\u0000\u0000\u033f\u033d\u0001\u0000\u0000\u0000\u033f\u0340\u0001"+
		"\u0000\u0000\u0000\u0340\u0342\u0001\u0000\u0000\u0000\u0341\u033f\u0001"+
		"\u0000\u0000\u0000\u0342\u0344\u0003d2\u0000\u0343\u0335\u0001\u0000\u0000"+
		"\u0000\u0343\u033f\u0001\u0000\u0000\u0000\u0344a\u0001\u0000\u0000\u0000"+
		"\u0345\u0346\u00055\u0000\u0000\u0346\u0347\u0005\u00d4\u0000\u0000\u0347"+
		"\u034c\u0003\u00c4b\u0000\u0348\u0349\u0005\u00c7\u0000\u0000\u0349\u034b"+
		"\u0003\u00c4b\u0000\u034a\u0348\u0001\u0000\u0000\u0000\u034b\u034e\u0001"+
		"\u0000\u0000\u0000\u034c\u034a\u0001\u0000\u0000\u0000\u034c\u034d\u0001"+
		"\u0000\u0000\u0000\u034d\u0350\u0001\u0000\u0000\u0000\u034e\u034c\u0001"+
		"\u0000\u0000\u0000\u034f\u0351\u0005\u00e0\u0000\u0000\u0350\u034f\u0001"+
		"\u0000\u0000\u0000\u0350\u0351\u0001\u0000\u0000\u0000\u0351\u0352\u0001"+
		"\u0000\u0000\u0000\u0352\u0353\u0005\u00d5\u0000\u0000\u0353\u0354\u0003"+
		":\u001d\u0000\u0354c\u0001\u0000\u0000\u0000\u0355\u0356\u0005N\u0000"+
		"\u0000\u0356\u0357\u0003:\u001d\u0000\u0357e\u0001\u0000\u0000\u0000\u0358"+
		"\u0359\u0005y\u0000\u0000\u0359\u035a\u0003\u00a4R\u0000\u035a\u035b\u0005"+
		"\u00dc\u0000\u0000\u035bg\u0001\u0000\u0000\u0000\u035c\u035d\u0005T\u0000"+
		"\u0000\u035d\u035e\u0003\u0108\u0084\u0000\u035e\u035f\u0005\u00dc\u0000"+
		"\u0000\u035fi\u0001\u0000\u0000\u0000\u0360\u0361\u0005:\u0000\u0000\u0361"+
		"\u0362\u0005\u00d4\u0000\u0000\u0362\u0363\u0003n7\u0000\u0363\u036a\u0005"+
		"\u00d5\u0000\u0000\u0364\u036b\u00036\u001b\u0000\u0365\u0366\u0005\u00db"+
		"\u0000\u0000\u0366\u0367\u00032\u0019\u0000\u0367\u0368\u0005D\u0000\u0000"+
		"\u0368\u0369\u0005\u00dc\u0000\u0000\u0369\u036b\u0001\u0000\u0000\u0000"+
		"\u036a\u0364\u0001\u0000\u0000\u0000\u036a\u0365\u0001\u0000\u0000\u0000"+
		"\u036bk\u0001\u0000\u0000\u0000\u036c\u036e\u0003\u0002\u0001\u0000\u036d"+
		"\u036c\u0001\u0000\u0000\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f"+
		"\u036d\u0001\u0000\u0000\u0000\u036f\u0370\u0001\u0000\u0000\u0000\u0370"+
		"m\u0001\u0000\u0000\u0000\u0371\u0376\u0003p8\u0000\u0372\u0373\u0005"+
		"\u00da\u0000\u0000\u0373\u0375\u0003p8\u0000\u0374\u0372\u0001\u0000\u0000"+
		"\u0000\u0375\u0378\u0001\u0000\u0000\u0000\u0376\u0374\u0001\u0000\u0000"+
		"\u0000\u0376\u0377\u0001\u0000\u0000\u0000\u0377o\u0001\u0000\u0000\u0000"+
		"\u0378\u0376\u0001\u0000\u0000\u0000\u0379\u037a\u0005\u0086\u0000\u0000"+
		"\u037a\u037d\u0005\u00dd\u0000\u0000\u037b\u037e\u0003\u00e0p\u0000\u037c"+
		"\u037e\u0005\u00e4\u0000\u0000\u037d\u037b\u0001\u0000\u0000\u0000\u037d"+
		"\u037c\u0001\u0000\u0000\u0000\u037e\u0386\u0001\u0000\u0000\u0000\u037f"+
		"\u0380\u0005\u0087\u0000\u0000\u0380\u0381\u0005\u00dd\u0000\u0000\u0381"+
		"\u0386\u0005\u00e8\u0000\u0000\u0382\u0383\u0005\u0088\u0000\u0000\u0383"+
		"\u0384\u0005\u00dd\u0000\u0000\u0384\u0386\u0003\u00e0p\u0000\u0385\u0379"+
		"\u0001\u0000\u0000\u0000\u0385\u037f\u0001\u0000\u0000\u0000\u0385\u0382"+
		"\u0001\u0000\u0000\u0000\u0386q\u0001\u0000\u0000\u0000\u0387\u0389\u0003"+
		"t:\u0000\u0388\u0387\u0001\u0000\u0000\u0000\u0388\u0389\u0001\u0000\u0000"+
		"\u0000\u0389\u038e\u0001\u0000\u0000\u0000\u038a\u038b\u0005\u00da\u0000"+
		"\u0000\u038b\u038d\u0003t:\u0000\u038c\u038a\u0001\u0000\u0000\u0000\u038d"+
		"\u0390\u0001\u0000\u0000\u0000\u038e\u038c\u0001\u0000\u0000\u0000\u038e"+
		"\u038f\u0001\u0000\u0000\u0000\u038f\u0392\u0001\u0000\u0000\u0000\u0390"+
		"\u038e\u0001\u0000\u0000\u0000\u0391\u0393\u0005\u00da\u0000\u0000\u0392"+
		"\u0391\u0001\u0000\u0000\u0000\u0392\u0393\u0001\u0000\u0000\u0000\u0393"+
		"s\u0001\u0000\u0000\u0000\u0394\u0396\u0003,\u0016\u0000\u0395\u0394\u0001"+
		"\u0000\u0000\u0000\u0395\u0396\u0001\u0000\u0000\u0000\u0396\u039a\u0001"+
		"\u0000\u0000\u0000\u0397\u0399\u0003\u010a\u0085\u0000\u0398\u0397\u0001"+
		"\u0000\u0000\u0000\u0399\u039c\u0001\u0000\u0000\u0000\u039a\u0398\u0001"+
		"\u0000\u0000\u0000\u039a\u039b\u0001\u0000\u0000\u0000\u039b\u039e\u0001"+
		"\u0000\u0000\u0000\u039c\u039a\u0001\u0000\u0000\u0000\u039d\u039f\u0005"+
		"\u00d3\u0000\u0000\u039e\u039d\u0001\u0000\u0000\u0000\u039e\u039f\u0001"+
		"\u0000\u0000\u0000\u039f\u03a1\u0001\u0000\u0000\u0000\u03a0\u03a2\u0003"+
		"v;\u0000\u03a1\u03a0\u0001\u0000\u0000\u0000\u03a1\u03a2\u0001\u0000\u0000"+
		"\u0000\u03a2\u03a4\u0001\u0000\u0000\u0000\u03a3\u03a5\u0005\u00c6\u0000"+
		"\u0000\u03a4\u03a3\u0001\u0000\u0000\u0000\u03a4\u03a5\u0001\u0000\u0000"+
		"\u0000\u03a5\u03a7\u0001\u0000\u0000\u0000\u03a6\u03a8\u0005\u00c3\u0000"+
		"\u0000\u03a7\u03a6\u0001\u0000\u0000\u0000\u03a7\u03a8\u0001\u0000\u0000"+
		"\u0000\u03a8\u03a9\u0001\u0000\u0000\u0000\u03a9\u03aa\u0003\u0096K\u0000"+
		"\u03aau\u0001\u0000\u0000\u0000\u03ab\u03ac\u0006;\uffff\uffff\u0000\u03ac"+
		"\u03b0\u0003\u00c4b\u0000\u03ad\u03b0\u00053\u0000\u0000\u03ae\u03b0\u0003"+
		"\u0110\u0088\u0000\u03af\u03ab\u0001\u0000\u0000\u0000\u03af\u03ad\u0001"+
		"\u0000\u0000\u0000\u03af\u03ae\u0001\u0000\u0000\u0000\u03b0\u03b6\u0001"+
		"\u0000\u0000\u0000\u03b1\u03b2\n\u0001\u0000\u0000\u03b2\u03b3\u0005\u00c7"+
		"\u0000\u0000\u03b3\u03b5\u0003v;\u0002\u03b4\u03b1\u0001\u0000\u0000\u0000"+
		"\u03b5\u03b8\u0001\u0000\u0000\u0000\u03b6\u03b4\u0001\u0000\u0000\u0000"+
		"\u03b6\u03b7\u0001\u0000\u0000\u0000\u03b7w\u0001\u0000\u0000\u0000\u03b8"+
		"\u03b6\u0001\u0000\u0000\u0000\u03b9\u03ba\u0005S\u0000\u0000\u03ba\u03bf"+
		"\u0003z=\u0000\u03bb\u03bc\u0005\u00da\u0000\u0000\u03bc\u03be\u0003z"+
		"=\u0000\u03bd\u03bb\u0001\u0000\u0000\u0000\u03be\u03c1\u0001\u0000\u0000"+
		"\u0000\u03bf\u03bd\u0001\u0000\u0000\u0000\u03bf\u03c0\u0001\u0000\u0000"+
		"\u0000\u03c0\u03c2\u0001\u0000\u0000\u0000\u03c1\u03bf\u0001\u0000\u0000"+
		"\u0000\u03c2\u03c3\u0005\u00dc\u0000\u0000\u03c3y\u0001\u0000\u0000\u0000"+
		"\u03c4\u03cd\u0005\u00e0\u0000\u0000\u03c5\u03c6\u0005\u00d1\u0000\u0000"+
		"\u03c6\u03cd\u0003\u00ecv\u0000\u03c7\u03c8\u0005\u00d1\u0000\u0000\u03c8"+
		"\u03c9\u0005\u00d8\u0000\u0000\u03c9\u03ca\u0003\u00a4R\u0000\u03ca\u03cb"+
		"\u0005\u00d9\u0000\u0000\u03cb\u03cd\u0001\u0000\u0000\u0000\u03cc\u03c4"+
		"\u0001\u0000\u0000\u0000\u03cc\u03c5\u0001\u0000\u0000\u0000\u03cc\u03c7"+
		"\u0001\u0000\u0000\u0000\u03cd{\u0001\u0000\u0000\u0000\u03ce\u03cf\u0005"+
		"?\u0000\u0000\u03cf\u03d0\u0003\u00a0P\u0000\u03d0\u03d1\u0005\u00dc\u0000"+
		"\u0000\u03d1}\u0001\u0000\u0000\u0000\u03d2\u03d3\u0005v\u0000\u0000\u03d3"+
		"\u03d8\u0003\u0096K\u0000\u03d4\u03d5\u0005\u00da\u0000\u0000\u03d5\u03d7"+
		"\u0003\u0096K\u0000\u03d6\u03d4\u0001\u0000\u0000\u0000\u03d7\u03da\u0001"+
		"\u0000\u0000\u0000\u03d8\u03d6\u0001\u0000\u0000\u0000\u03d8\u03d9\u0001"+
		"\u0000\u0000\u0000\u03d9\u03db\u0001\u0000\u0000\u0000\u03da\u03d8\u0001"+
		"\u0000\u0000\u0000\u03db\u03dc\u0005\u00dc\u0000\u0000\u03dc\u007f\u0001"+
		"\u0000\u0000\u0000\u03dd\u03df\u0003,\u0016\u0000\u03de\u03dd\u0001\u0000"+
		"\u0000\u0000\u03de\u03df\u0001\u0000\u0000\u0000\u03df\u0412\u0001\u0000"+
		"\u0000\u0000\u03e0\u03e2\u0003\u0092I\u0000\u03e1\u03e3\u0003v;\u0000"+
		"\u03e2\u03e1\u0001\u0000\u0000\u0000\u03e2\u03e3\u0001\u0000\u0000\u0000"+
		"\u03e3\u03e4\u0001\u0000\u0000\u0000\u03e4\u03e9\u0003\u0096K\u0000\u03e5"+
		"\u03e6\u0005\u00da\u0000\u0000\u03e6\u03e8\u0003\u0096K\u0000\u03e7\u03e5"+
		"\u0001\u0000\u0000\u0000\u03e8\u03eb\u0001\u0000\u0000\u0000\u03e9\u03e7"+
		"\u0001\u0000\u0000\u0000\u03e9\u03ea\u0001\u0000\u0000\u0000\u03ea\u03ec"+
		"\u0001\u0000\u0000\u0000\u03eb\u03e9\u0001\u0000\u0000\u0000\u03ec\u03ed"+
		"\u0005\u00dc\u0000\u0000\u03ed\u0413\u0001\u0000\u0000\u0000\u03ee\u03f0"+
		"\u0003\u0094J\u0000\u03ef\u03ee\u0001\u0000\u0000\u0000\u03ef\u03f0\u0001"+
		"\u0000\u0000\u0000\u03f0\u0410\u0001\u0000\u0000\u0000\u03f1\u03f3\u0005"+
		"8\u0000\u0000\u03f2\u03f4\u0003v;\u0000\u03f3\u03f2\u0001\u0000\u0000"+
		"\u0000\u03f3\u03f4\u0001\u0000\u0000\u0000\u03f4\u03f5\u0001\u0000\u0000"+
		"\u0000\u03f5\u03fa\u0003\u0098L\u0000\u03f6\u03f7\u0005\u00da\u0000\u0000"+
		"\u03f7\u03f9\u0003\u0098L\u0000\u03f8\u03f6\u0001\u0000\u0000\u0000\u03f9"+
		"\u03fc\u0001\u0000\u0000\u0000\u03fa\u03f8\u0001\u0000\u0000\u0000\u03fa"+
		"\u03fb\u0001\u0000\u0000\u0000\u03fb\u03fd\u0001\u0000\u0000\u0000\u03fc"+
		"\u03fa\u0001\u0000\u0000\u0000\u03fd\u03fe\u0005\u00dc\u0000\u0000\u03fe"+
		"\u0411\u0001\u0000\u0000\u0000\u03ff\u0401\u0005R\u0000\u0000\u0400\u0402"+
		"\u0005\u00c6\u0000\u0000\u0401\u0400\u0001\u0000\u0000\u0000\u0401\u0402"+
		"\u0001\u0000\u0000\u0000\u0402\u0403\u0001\u0000\u0000\u0000\u0403\u0405"+
		"\u0003\u0108\u0084\u0000\u0404\u0406\u0003 \u0010\u0000\u0405\u0404\u0001"+
		"\u0000\u0000\u0000\u0405\u0406\u0001\u0000\u0000\u0000\u0406\u0407\u0001"+
		"\u0000\u0000\u0000\u0407\u0408\u0005\u00d4\u0000\u0000\u0408\u0409\u0003"+
		"r9\u0000\u0409\u040c\u0005\u00d5\u0000\u0000\u040a\u040d\u0003\u008cF"+
		"\u0000\u040b\u040d\u0003\u008eG\u0000\u040c\u040a\u0001\u0000\u0000\u0000"+
		"\u040c\u040b\u0001\u0000\u0000\u0000\u040c\u040d\u0001\u0000\u0000\u0000"+
		"\u040d\u040e\u0001\u0000\u0000\u0000\u040e\u040f\u0003\u0090H\u0000\u040f"+
		"\u0411\u0001\u0000\u0000\u0000\u0410\u03f1\u0001\u0000\u0000\u0000\u0410"+
		"\u03ff\u0001\u0000\u0000\u0000\u0411\u0413\u0001\u0000\u0000\u0000\u0412"+
		"\u03e0\u0001\u0000\u0000\u0000\u0412\u03ef\u0001\u0000\u0000\u0000\u0413"+
		"\u0419\u0001\u0000\u0000\u0000\u0414\u0415\u0005\u0080\u0000\u0000\u0415"+
		"\u0416\u0003\u00d2i\u0000\u0416\u0417\u0003\u0082A\u0000\u0417\u0419\u0001"+
		"\u0000\u0000\u0000\u0418\u03de\u0001\u0000\u0000\u0000\u0418\u0414\u0001"+
		"\u0000\u0000\u0000\u0419\u0081\u0001\u0000\u0000\u0000\u041a\u0424\u0005"+
		"\u00dc\u0000\u0000\u041b\u041f\u0005\u00d8\u0000\u0000\u041c\u041e\u0003"+
		"\u0084B\u0000\u041d\u041c\u0001\u0000\u0000\u0000\u041e\u0421\u0001\u0000"+
		"\u0000\u0000\u041f\u041d\u0001\u0000\u0000\u0000\u041f\u0420\u0001\u0000"+
		"\u0000\u0000\u0420\u0422\u0001\u0000\u0000\u0000\u0421\u041f\u0001\u0000"+
		"\u0000\u0000\u0422\u0424\u0005\u00d9\u0000\u0000\u0423\u041a\u0001\u0000"+
		"\u0000\u0000\u0423\u041b\u0001\u0000\u0000\u0000\u0424\u0083\u0001\u0000"+
		"\u0000\u0000\u0425\u0428\u0003\u0086C\u0000\u0426\u0428\u0003\u0088D\u0000"+
		"\u0427\u0425\u0001\u0000\u0000\u0000\u0427\u0426\u0001\u0000\u0000\u0000"+
		"\u0428\u0085\u0001\u0000\u0000\u0000\u0429\u042a\u0003\u00ccf\u0000\u042a"+
		"\u042b\u0005\u00c0\u0000\u0000\u042b\u042c\u0003\u0108\u0084\u0000\u042c"+
		"\u042d\u0005[\u0000\u0000\u042d\u042e\u0003\u00d2i\u0000\u042e\u042f\u0005"+
		"\u00dc\u0000\u0000\u042f\u0087\u0001\u0000\u0000\u0000\u0430\u0431\u0003"+
		"\u008aE\u0000\u0431\u0437\u0005.\u0000\u0000\u0432\u0438\u0003\u010a\u0085"+
		"\u0000\u0433\u0435\u0003\u010a\u0085\u0000\u0434\u0433\u0001\u0000\u0000"+
		"\u0000\u0434\u0435\u0001\u0000\u0000\u0000\u0435\u0436\u0001\u0000\u0000"+
		"\u0000\u0436\u0438\u0003\u0108\u0084\u0000\u0437\u0432\u0001\u0000\u0000"+
		"\u0000\u0437\u0434\u0001\u0000\u0000\u0000\u0438\u0439\u0001\u0000\u0000"+
		"\u0000\u0439\u043a\u0005\u00dc\u0000\u0000\u043a\u0089\u0001\u0000\u0000"+
		"\u0000\u043b\u043c\u0003\u00ccf\u0000\u043c\u043d\u0005\u00c0\u0000\u0000"+
		"\u043d\u043f\u0001\u0000\u0000\u0000\u043e\u043b\u0001\u0000\u0000\u0000"+
		"\u043e\u043f\u0001\u0000\u0000\u0000\u043f\u0440\u0001\u0000\u0000\u0000"+
		"\u0440\u0441\u0003\u0108\u0084\u0000\u0441\u008b\u0001\u0000\u0000\u0000"+
		"\u0442\u0443\u0005\u00db\u0000\u0000\u0443\u0445\u0003\u0108\u0084\u0000"+
		"\u0444\u0446\u0003\u00d4j\u0000\u0445\u0444\u0001\u0000\u0000\u0000\u0445"+
		"\u0446\u0001\u0000\u0000\u0000\u0446\u008d\u0001\u0000\u0000\u0000\u0447"+
		"\u0449\u0005\u00db\u0000\u0000\u0448\u044a\u0005\u00d3\u0000\u0000\u0449"+
		"\u0448\u0001\u0000\u0000\u0000\u0449\u044a\u0001\u0000\u0000\u0000\u044a"+
		"\u044b\u0001\u0000\u0000\u0000\u044b\u044c\u0003v;\u0000\u044c\u008f\u0001"+
		"\u0000\u0000\u0000\u044d\u0450\u0005\u00dc\u0000\u0000\u044e\u0450\u0003"+
		":\u001d\u0000\u044f\u044d\u0001\u0000\u0000\u0000\u044f\u044e\u0001\u0000"+
		"\u0000\u0000\u0450\u0091\u0001\u0000\u0000\u0000\u0451\u0454\u0003\u0094"+
		"J\u0000\u0452\u0454\u0005\u0081\u0000\u0000\u0453\u0451\u0001\u0000\u0000"+
		"\u0000\u0453\u0452\u0001\u0000\u0000\u0000\u0454\u0093\u0001\u0000\u0000"+
		"\u0000\u0455\u0457\u0003\u010a\u0085\u0000\u0456\u0455\u0001\u0000\u0000"+
		"\u0000\u0457\u0458\u0001\u0000\u0000\u0000\u0458\u0456\u0001\u0000\u0000"+
		"\u0000\u0458\u0459\u0001\u0000\u0000\u0000\u0459\u0095\u0001\u0000\u0000"+
		"\u0000\u045a\u045d\u0005\u00e0\u0000\u0000\u045b\u045c\u0005\u00dd\u0000"+
		"\u0000\u045c\u045e\u0003\u00dam\u0000\u045d\u045b\u0001\u0000\u0000\u0000"+
		"\u045d\u045e\u0001\u0000\u0000\u0000\u045e\u0097\u0001\u0000\u0000\u0000"+
		"\u045f\u0460\u0003\u0108\u0084\u0000\u0460\u0461\u0005\u00dd\u0000\u0000"+
		"\u0461\u0462\u0003\u00dam\u0000\u0462\u0099\u0001\u0000\u0000\u0000\u0463"+
		"\u0465\u0003,\u0016\u0000\u0464\u0463\u0001\u0000\u0000\u0000\u0464\u0465"+
		"\u0001\u0000\u0000\u0000\u0465\u0466\u0001\u0000\u0000\u0000\u0466\u0467"+
		"\u00058\u0000\u0000\u0467\u046c\u0003\u0098L\u0000\u0468\u0469\u0005\u00da"+
		"\u0000\u0000\u0469\u046b\u0003\u0098L\u0000\u046a\u0468\u0001\u0000\u0000"+
		"\u0000\u046b\u046e\u0001\u0000\u0000\u0000\u046c\u046a\u0001\u0000\u0000"+
		"\u0000\u046c\u046d\u0001\u0000\u0000\u0000\u046d\u046f\u0001\u0000\u0000"+
		"\u0000\u046e\u046c\u0001\u0000\u0000\u0000\u046f\u0470\u0005\u00dc\u0000"+
		"\u0000\u0470\u009b\u0001\u0000\u0000\u0000\u0471\u0472\u0005C\u0000\u0000"+
		"\u0472\u0475\u0003\u0108\u0084\u0000\u0473\u0474\u0005\u00db\u0000\u0000"+
		"\u0474\u0476\u0007\u0003\u0000\u0000\u0475\u0473\u0001\u0000\u0000\u0000"+
		"\u0475\u0476\u0001\u0000\u0000\u0000\u0476\u0479\u0001\u0000\u0000\u0000"+
		"\u0477\u0478\u0005V\u0000\u0000\u0478\u047a\u0003\u001e\u000f\u0000\u0479"+
		"\u0477\u0001\u0000\u0000\u0000\u0479\u047a\u0001\u0000\u0000\u0000\u047a"+
		"\u047b\u0001\u0000\u0000\u0000\u047b\u047f\u0005\u00d8\u0000\u0000\u047c"+
		"\u047e\u0003\u009eO\u0000\u047d\u047c\u0001\u0000\u0000\u0000\u047e\u0481"+
		"\u0001\u0000\u0000\u0000\u047f\u047d\u0001\u0000\u0000\u0000\u047f\u0480"+
		"\u0001\u0000\u0000\u0000\u0480\u0482\u0001\u0000\u0000\u0000\u0481\u047f"+
		"\u0001\u0000\u0000\u0000\u0482\u0483\u0005\u00d9\u0000\u0000\u0483\u009d"+
		"\u0001\u0000\u0000\u0000\u0484\u0485\u00054\u0000\u0000\u0485\u0488\u0003"+
		"\u0108\u0084\u0000\u0486\u0487\u0005\u00dd\u0000\u0000\u0487\u0489\u0003"+
		"\u00a4R\u0000\u0488\u0486\u0001\u0000\u0000\u0000\u0488\u0489\u0001\u0000"+
		"\u0000\u0000\u0489\u048a\u0001\u0000\u0000\u0000\u048a\u048b\u0005\u00dc"+
		"\u0000\u0000\u048b\u0495\u0001\u0000\u0000\u0000\u048c\u048e\u0003\u0094"+
		"J\u0000\u048d\u048c\u0001\u0000\u0000\u0000\u048d\u048e\u0001\u0000\u0000"+
		"\u0000\u048e\u048f\u0001\u0000\u0000\u0000\u048f\u0495\u0003\u0018\f\u0000"+
		"\u0490\u0491\u0005\u0080\u0000\u0000\u0491\u0492\u0003\u00d2i\u0000\u0492"+
		"\u0493\u0003\u0082A\u0000\u0493\u0495\u0001\u0000\u0000\u0000\u0494\u0484"+
		"\u0001\u0000\u0000\u0000\u0494\u048d\u0001\u0000\u0000\u0000\u0494\u0490"+
		"\u0001\u0000\u0000\u0000\u0495\u009f\u0001\u0000\u0000\u0000\u0496\u049b"+
		"\u0003\u00a4R\u0000\u0497\u0498\u0005\u00da\u0000\u0000\u0498\u049a\u0003"+
		"\u00a4R\u0000\u0499\u0497\u0001\u0000\u0000\u0000\u049a\u049d\u0001\u0000"+
		"\u0000\u0000\u049b\u0499\u0001\u0000\u0000\u0000\u049b\u049c\u0001\u0000"+
		"\u0000\u0000\u049c\u00a1\u0001\u0000\u0000\u0000\u049d\u049b\u0001\u0000"+
		"\u0000\u0000\u049e\u04a1\u0005\u00d4\u0000\u0000\u049f\u04a2\u0003\u00a4"+
		"R\u0000\u04a0\u04a2\u0003\u00ba]\u0000\u04a1\u049f\u0001\u0000\u0000\u0000"+
		"\u04a1\u04a0\u0001\u0000\u0000\u0000\u04a2\u04a3\u0001\u0000\u0000\u0000"+
		"\u04a3\u04a4\u0005\u00d5\u0000\u0000\u04a4\u00a3\u0001\u0000\u0000\u0000"+
		"\u04a5\u04a6\u0006R\uffff\uffff\u0000\u04a6\u04a7\u00057\u0000\u0000\u04a7"+
		"\u0500\u0003\u00a4R0\u04a8\u0500\u0003\u00b6[\u0000\u04a9\u04aa\u0003"+
		"\u00e4r\u0000\u04aa\u04ab\u0005\u00d6\u0000\u0000\u04ab\u04ac\u0003\u00a4"+
		"R\u0000\u04ac\u04ad\u0005\u00d7\u0000\u0000\u04ad\u0500\u0001\u0000\u0000"+
		"\u0000\u04ae\u04af\u0005\u00d4\u0000\u0000\u04af\u04b0\u0003\u0112\u0089"+
		"\u0000\u04b0\u04b1\u0005\u00d5\u0000\u0000\u04b1\u04b2\u0003\u00a4R-\u04b2"+
		"\u0500\u0001\u0000\u0000\u0000\u04b3\u04b4\u0007\u0004\u0000\u0000\u04b4"+
		"\u0500\u0003\u00a4R,\u04b5\u04b6\u0007\u0005\u0000\u0000\u04b6\u0500\u0003"+
		"\u00a4R+\u04b7\u04b8\u0007\u0006\u0000\u0000\u04b8\u0500\u0003\u00ecv"+
		"\u0000\u04b9\u04ba\u0003\u00ecv\u0000\u04ba\u04bb\u0007\u0006\u0000\u0000"+
		"\u04bb\u0500\u0001\u0000\u0000\u0000\u04bc\u04bd\u0005m\u0000\u0000\u04bd"+
		"\u0500\u0003\u00a4R(\u04be\u0500\u0003\u00a8T\u0000\u04bf\u0500\u0003"+
		"\u00ecv\u0000\u04c0\u0500\u0003\u00dcn\u0000\u04c1\u0500\u0003\u00e6s"+
		"\u0000\u04c2\u0500\u0005\u00e1\u0000\u0000\u04c3\u0500\u0005\u00e7\u0000"+
		"\u0000\u04c4\u0500\u0003\u00a2Q\u0000\u04c5\u0500\u0005\u0083\u0000\u0000"+
		"\u04c6\u04c7\u0005b\u0000\u0000\u04c7\u04c8\u0005\u00d4\u0000\u0000\u04c8"+
		"\u04c9\u0003\u0102\u0081\u0000\u04c9\u04ca\u0005\u00d5\u0000\u0000\u04ca"+
		"\u04cb\u0005\u00dd\u0000\u0000\u04cb\u04cc\u0003\u00a4R\u001f\u04cc\u0500"+
		"\u0001\u0000\u0000\u0000\u04cd\u04ce\u0005a\u0000\u0000\u04ce\u04cf\u0005"+
		"\u00d4\u0000\u0000\u04cf\u04d0\u0003\u00eau\u0000\u04d0\u04d1\u0005\u00d5"+
		"\u0000\u0000\u04d1\u0500\u0001\u0000\u0000\u0000\u04d2\u04d3\u0005B\u0000"+
		"\u0000\u04d3\u04d4\u0005\u00d4\u0000\u0000\u04d4\u04d5\u0003\u00ecv\u0000"+
		"\u04d5\u04d6\u0005\u00d5\u0000\u0000\u04d6\u0500\u0001\u0000\u0000\u0000"+
		"\u04d7\u04d8\u0005J\u0000\u0000\u04d8\u04d9\u0005\u00d4\u0000\u0000\u04d9"+
		"\u04da\u0003\u00a4R\u0000\u04da\u04db\u0005\u00d5\u0000\u0000\u04db\u0500"+
		"\u0001\u0000\u0000\u0000\u04dc\u04e0\u0005K\u0000\u0000\u04dd\u04de\u0005"+
		"\u00d4\u0000\u0000\u04de\u04e1\u0005\u00d5\u0000\u0000\u04df\u04e1\u0003"+
		"\u00a2Q\u0000\u04e0\u04dd\u0001\u0000\u0000\u0000\u04e0\u04df\u0001\u0000"+
		"\u0000\u0000\u04e0\u04e1\u0001\u0000\u0000\u0000\u04e1\u0500\u0001\u0000"+
		"\u0000\u0000\u04e2\u04e3\u0007\u0007\u0000\u0000\u04e3\u0500\u0003\u00a4"+
		"R\u001a\u04e4\u04e5\u0007\b\u0000\u0000\u04e5\u0500\u0003\u00a4R\u0019"+
		"\u04e6\u0500\u0003\u00b0X\u0000\u04e7\u0500\u0003\u00b2Y\u0000\u04e8\u04e9"+
		"\u0005y\u0000\u0000\u04e9\u0500\u0003\u00a4R\u0007\u04ea\u04eb\u0003\u00aa"+
		"U\u0000\u04eb\u04ec\u0005\u00dd\u0000\u0000\u04ec\u04ed\u0003\u00a4R\u0006"+
		"\u04ed\u0500\u0001\u0000\u0000\u0000\u04ee\u04ef\u0003\u00a6S\u0000\u04ef"+
		"\u04f1\u0003\u00b8\\\u0000\u04f0\u04f2\u0003,\u0016\u0000\u04f1\u04f0"+
		"\u0001\u0000\u0000\u0000\u04f1\u04f2\u0001\u0000\u0000\u0000\u04f2\u04f3"+
		"\u0001\u0000\u0000\u0000\u04f3\u04f4\u0003\u00a4R\u0005\u04f4\u0500\u0001"+
		"\u0000\u0000\u0000\u04f5\u04f6\u0003\u00a6S\u0000\u04f6\u04f8\u0005\u00dd"+
		"\u0000\u0000\u04f7\u04f9\u0003,\u0016\u0000\u04f8\u04f7\u0001\u0000\u0000"+
		"\u0000\u04f8\u04f9\u0001\u0000\u0000\u0000\u04f9\u04fa\u0001\u0000\u0000"+
		"\u0000\u04fa\u04fd\u0005\u00c6\u0000\u0000\u04fb\u04fe\u0003\u00ecv\u0000"+
		"\u04fc\u04fe\u0003\u00b6[\u0000\u04fd\u04fb\u0001\u0000\u0000\u0000\u04fd"+
		"\u04fc\u0001\u0000\u0000\u0000\u04fe\u0500\u0001\u0000\u0000\u0000\u04ff"+
		"\u04a5\u0001\u0000\u0000\u0000\u04ff\u04a8\u0001\u0000\u0000\u0000\u04ff"+
		"\u04a9\u0001\u0000\u0000\u0000\u04ff\u04ae\u0001\u0000\u0000\u0000\u04ff"+
		"\u04b3\u0001\u0000\u0000\u0000\u04ff\u04b5\u0001\u0000\u0000\u0000\u04ff"+
		"\u04b7\u0001\u0000\u0000\u0000\u04ff\u04b9\u0001\u0000\u0000\u0000\u04ff"+
		"\u04bc\u0001\u0000\u0000\u0000\u04ff\u04be\u0001\u0000\u0000\u0000\u04ff"+
		"\u04bf\u0001\u0000\u0000\u0000\u04ff\u04c0\u0001\u0000\u0000\u0000\u04ff"+
		"\u04c1\u0001\u0000\u0000\u0000\u04ff\u04c2\u0001\u0000\u0000\u0000\u04ff"+
		"\u04c3\u0001\u0000\u0000\u0000\u04ff\u04c4\u0001\u0000\u0000\u0000\u04ff"+
		"\u04c5\u0001\u0000\u0000\u0000\u04ff\u04c6\u0001\u0000\u0000\u0000\u04ff"+
		"\u04cd\u0001\u0000\u0000\u0000\u04ff\u04d2\u0001\u0000\u0000\u0000\u04ff"+
		"\u04d7\u0001\u0000\u0000\u0000\u04ff\u04dc\u0001\u0000\u0000\u0000\u04ff"+
		"\u04e2\u0001\u0000\u0000\u0000\u04ff\u04e4\u0001\u0000\u0000\u0000\u04ff"+
		"\u04e6\u0001\u0000\u0000\u0000\u04ff\u04e7\u0001\u0000\u0000\u0000\u04ff"+
		"\u04e8\u0001\u0000\u0000\u0000\u04ff\u04ea\u0001\u0000\u0000\u0000\u04ff"+
		"\u04ee\u0001\u0000\u0000\u0000\u04ff\u04f5\u0001\u0000\u0000\u0000\u0500"+
		"\u053d\u0001\u0000\u0000\u0000\u0501\u0502\n\u0016\u0000\u0000\u0502\u0503"+
		"\u0005\u00b0\u0000\u0000\u0503\u053c\u0003\u00a4R\u0016\u0504\u0505\n"+
		"\u0014\u0000\u0000\u0505\u0506\u0007\t\u0000\u0000\u0506\u053c\u0003\u00a4"+
		"R\u0015\u0507\u0508\n\u0013\u0000\u0000\u0508\u0509\u0007\n\u0000\u0000"+
		"\u0509\u053c\u0003\u00a4R\u0014\u050a\u050b\n\u0012\u0000\u0000\u050b"+
		"\u050c\u0007\u000b\u0000\u0000\u050c\u053c\u0003\u00a4R\u0013\u050d\u050e"+
		"\n\u0011\u0000\u0000\u050e\u050f\u0007\f\u0000\u0000\u050f\u053c\u0003"+
		"\u00a4R\u0012\u0510\u0511\n\u0010\u0000\u0000\u0511\u0512\u0007\r\u0000"+
		"\u0000\u0512\u053c\u0003\u00a4R\u0011\u0513\u0514\n\u000f\u0000\u0000"+
		"\u0514\u0515\u0005\u00c6\u0000\u0000\u0515\u053c\u0003\u00a4R\u0010\u0516"+
		"\u0517\n\u000e\u0000\u0000\u0517\u0518\u0005\u00c9\u0000\u0000\u0518\u053c"+
		"\u0003\u00a4R\u000f\u0519\u051a\n\r\u0000\u0000\u051a\u051b\u0005\u00c7"+
		"\u0000\u0000\u051b\u053c\u0003\u00a4R\u000e\u051c\u051d\n\f\u0000\u0000"+
		"\u051d\u051e\u0005\u00bb\u0000\u0000\u051e\u053c\u0003\u00a4R\r\u051f"+
		"\u0520\n\u000b\u0000\u0000\u0520\u0521\u0005\u00ba\u0000\u0000\u0521\u053c"+
		"\u0003\u00a4R\f\u0522\u0523\n\n\u0000\u0000\u0523\u0525\u0005\u00d3\u0000"+
		"\u0000\u0524\u0526\u0003\u00a4R\u0000\u0525\u0524\u0001\u0000\u0000\u0000"+
		"\u0525\u0526\u0001\u0000\u0000\u0000\u0526\u0527\u0001\u0000\u0000\u0000"+
		"\u0527\u0528\u0005\u00db\u0000\u0000\u0528\u053c\u0003\u00a4R\u000b\u0529"+
		"\u052a\n\t\u0000\u0000\u052a\u052b\u0005\u00bc\u0000\u0000\u052b\u053c"+
		"\u0003\u00a4R\n\u052c\u052d\n\b\u0000\u0000\u052d\u052e\u0005\u00a1\u0000"+
		"\u0000\u052e\u053c\u0003\u00a4R\t\u052f\u0530\n\u0003\u0000\u0000\u0530"+
		"\u0531\u0005c\u0000\u0000\u0531\u053c\u0003\u00a4R\u0004\u0532\u0533\n"+
		"\u0002\u0000\u0000\u0533\u0534\u0005e\u0000\u0000\u0534\u053c\u0003\u00a4"+
		"R\u0003\u0535\u0536\n\u0001\u0000\u0000\u0536\u0537\u0005d\u0000\u0000"+
		"\u0537\u053c\u0003\u00a4R\u0002\u0538\u0539\n\u0015\u0000\u0000\u0539"+
		"\u053a\u0005Z\u0000\u0000\u053a\u053c\u0003\u00c6c\u0000\u053b\u0501\u0001"+
		"\u0000\u0000\u0000\u053b\u0504\u0001\u0000\u0000\u0000\u053b\u0507\u0001"+
		"\u0000\u0000\u0000\u053b\u050a\u0001\u0000\u0000\u0000\u053b\u050d\u0001"+
		"\u0000\u0000\u0000\u053b\u0510\u0001\u0000\u0000\u0000\u053b\u0513\u0001"+
		"\u0000\u0000\u0000\u053b\u0516\u0001\u0000\u0000\u0000\u053b\u0519\u0001"+
		"\u0000\u0000\u0000\u053b\u051c\u0001\u0000\u0000\u0000\u053b\u051f\u0001"+
		"\u0000\u0000\u0000\u053b\u0522\u0001\u0000\u0000\u0000\u053b\u0529\u0001"+
		"\u0000\u0000\u0000\u053b\u052c\u0001\u0000\u0000\u0000\u053b\u052f\u0001"+
		"\u0000\u0000\u0000\u053b\u0532\u0001\u0000\u0000\u0000\u053b\u0535\u0001"+
		"\u0000\u0000\u0000\u053b\u0538\u0001\u0000\u0000\u0000\u053c\u053f\u0001"+
		"\u0000\u0000\u0000\u053d\u053b\u0001\u0000\u0000\u0000\u053d\u053e\u0001"+
		"\u0000\u0000\u0000\u053e\u00a5\u0001\u0000\u0000\u0000\u053f\u053d\u0001"+
		"\u0000\u0000\u0000\u0540\u0543\u0003\u00ecv\u0000\u0541\u0543\u0003\u00a8"+
		"T\u0000\u0542\u0540\u0001\u0000\u0000\u0000\u0542\u0541\u0001\u0000\u0000"+
		"\u0000\u0543\u00a7\u0001\u0000\u0000\u0000\u0544\u0545\u0005-\u0000\u0000"+
		"\u0545\u0547\u0005\u00d4\u0000\u0000\u0546\u0548\u0003\u00bc^\u0000\u0547"+
		"\u0546\u0001\u0000\u0000\u0000\u0547\u0548\u0001\u0000\u0000\u0000\u0548"+
		"\u0549\u0001\u0000\u0000\u0000\u0549\u0550\u0005\u00d5\u0000\u0000\u054a"+
		"\u054c\u0005\u00d6\u0000\u0000\u054b\u054d\u0003\u00bc^\u0000\u054c\u054b"+
		"\u0001\u0000\u0000\u0000\u054c\u054d\u0001\u0000\u0000\u0000\u054d\u054e"+
		"\u0001\u0000\u0000\u0000\u054e\u0550\u0005\u00d7\u0000\u0000\u054f\u0544"+
		"\u0001\u0000\u0000\u0000\u054f\u054a\u0001\u0000\u0000\u0000\u0550\u0555"+
		"\u0001\u0000\u0000\u0000\u0551\u0552\u0005\u00d6\u0000\u0000\u0552\u0553"+
		"\u0003\u00a4R\u0000\u0553\u0554\u0005\u00d7\u0000\u0000\u0554\u0556\u0001"+
		"\u0000\u0000\u0000\u0555\u0551\u0001\u0000\u0000\u0000\u0555\u0556\u0001"+
		"\u0000\u0000\u0000\u0556\u00a9\u0001\u0000\u0000\u0000\u0557\u055b\u0005"+
		"\u00d6\u0000\u0000\u0558\u055a\u0005\u00da\u0000\u0000\u0559\u0558\u0001"+
		"\u0000\u0000\u0000\u055a\u055d\u0001\u0000\u0000\u0000\u055b\u0559\u0001"+
		"\u0000\u0000\u0000\u055b\u055c\u0001\u0000\u0000\u0000\u055c\u055e\u0001"+
		"\u0000\u0000\u0000\u055d\u055b\u0001\u0000\u0000\u0000\u055e\u0567\u0003"+
		"\u00acV\u0000\u055f\u0561\u0005\u00da\u0000\u0000\u0560\u055f\u0001\u0000"+
		"\u0000\u0000\u0561\u0562\u0001\u0000\u0000\u0000\u0562\u0560\u0001\u0000"+
		"\u0000\u0000\u0562\u0563\u0001\u0000\u0000\u0000\u0563\u0564\u0001\u0000"+
		"\u0000\u0000\u0564\u0566\u0003\u00acV\u0000\u0565\u0560\u0001\u0000\u0000"+
		"\u0000\u0566\u0569\u0001\u0000\u0000\u0000\u0567\u0565\u0001\u0000\u0000"+
		"\u0000\u0567\u0568\u0001\u0000\u0000\u0000\u0568\u056d\u0001\u0000\u0000"+
		"\u0000\u0569\u0567\u0001\u0000\u0000\u0000\u056a\u056c\u0005\u00da\u0000"+
		"\u0000\u056b\u056a\u0001\u0000\u0000\u0000\u056c\u056f\u0001\u0000\u0000"+
		"\u0000\u056d\u056b\u0001\u0000\u0000\u0000\u056d\u056e\u0001\u0000\u0000"+
		"\u0000\u056e\u0570\u0001\u0000\u0000\u0000\u056f\u056d\u0001\u0000\u0000"+
		"\u0000\u0570\u0571\u0005\u00d7\u0000\u0000\u0571\u0585\u0001\u0000\u0000"+
		"\u0000\u0572\u0573\u0005\u00d6\u0000\u0000\u0573\u057c\u0003\u00aeW\u0000"+
		"\u0574\u0576\u0005\u00da\u0000\u0000\u0575\u0574\u0001\u0000\u0000\u0000"+
		"\u0576\u0577\u0001\u0000\u0000\u0000\u0577\u0575\u0001\u0000\u0000\u0000"+
		"\u0577\u0578\u0001\u0000\u0000\u0000\u0578\u0579\u0001\u0000\u0000\u0000"+
		"\u0579\u057b\u0003\u00aeW\u0000\u057a\u0575\u0001\u0000\u0000\u0000\u057b"+
		"\u057e\u0001\u0000\u0000\u0000\u057c\u057a\u0001\u0000\u0000\u0000\u057c"+
		"\u057d\u0001\u0000\u0000\u0000\u057d\u0580\u0001\u0000\u0000\u0000\u057e"+
		"\u057c\u0001\u0000\u0000\u0000\u057f\u0581\u0005\u00da\u0000\u0000\u0580"+
		"\u057f\u0001\u0000\u0000\u0000\u0580\u0581\u0001\u0000\u0000\u0000\u0581"+
		"\u0582\u0001\u0000\u0000\u0000\u0582\u0583\u0005\u00d7\u0000\u0000\u0583"+
		"\u0585\u0001\u0000\u0000\u0000\u0584\u0557\u0001\u0000\u0000\u0000\u0584"+
		"\u0572\u0001\u0000\u0000\u0000\u0585\u00ab\u0001\u0000\u0000\u0000\u0586"+
		"\u0588\u0005\u00c6\u0000\u0000\u0587\u0586\u0001\u0000\u0000\u0000\u0587"+
		"\u0588\u0001\u0000\u0000\u0000\u0588\u0589\u0001\u0000\u0000\u0000\u0589"+
		"\u058a\u0003\u00ecv\u0000\u058a\u00ad\u0001\u0000\u0000\u0000\u058b\u058c"+
		"\u0003\u00a4R\u0000\u058c\u058d\u0005\u00a4\u0000\u0000\u058d\u058f\u0001"+
		"\u0000\u0000\u0000\u058e\u058b\u0001\u0000\u0000\u0000\u058e\u058f\u0001"+
		"\u0000\u0000\u0000\u058f\u0591\u0001\u0000\u0000\u0000\u0590\u0592\u0005"+
		"\u00c6\u0000\u0000\u0591\u0590\u0001\u0000\u0000\u0000\u0591\u0592\u0001"+
		"\u0000\u0000\u0000\u0592\u0593\u0001\u0000\u0000\u0000\u0593\u0594\u0003"+
		"\u00ecv\u0000\u0594\u00af\u0001\u0000\u0000\u0000\u0595\u0597\u0005v\u0000"+
		"\u0000\u0596\u0595\u0001\u0000\u0000\u0000\u0596\u0597\u0001\u0000\u0000"+
		"\u0000\u0597\u0598\u0001\u0000\u0000\u0000\u0598\u059a\u0005R\u0000\u0000"+
		"\u0599\u059b\u0005\u00c6\u0000\u0000\u059a\u0599\u0001\u0000\u0000\u0000"+
		"\u059a\u059b\u0001\u0000\u0000\u0000\u059b\u059c\u0001\u0000\u0000\u0000"+
		"\u059c\u059d\u0005\u00d4\u0000\u0000\u059d\u059e\u0003r9\u0000\u059e\u05a0"+
		"\u0005\u00d5\u0000\u0000\u059f\u05a1\u0003\u00c0`\u0000\u05a0\u059f\u0001"+
		"\u0000\u0000\u0000\u05a0\u05a1\u0001\u0000\u0000\u0000\u05a1\u05a4\u0001"+
		"\u0000\u0000\u0000\u05a2\u05a3\u0005\u00db\u0000\u0000\u05a3\u05a5\u0003"+
		"v;\u0000\u05a4\u05a2\u0001\u0000\u0000\u0000\u05a4\u05a5\u0001\u0000\u0000"+
		"\u0000\u05a5\u05a6\u0001\u0000\u0000\u0000\u05a6\u05a7\u0003:\u001d\u0000"+
		"\u05a7\u05b0\u0001\u0000\u0000\u0000\u05a8\u05a9\u0005\u0085\u0000\u0000"+
		"\u05a9\u05aa\u0005\u00d4\u0000\u0000\u05aa\u05ab\u0003r9\u0000\u05ab\u05ac"+
		"\u0005\u00d5\u0000\u0000\u05ac\u05ad\u0005\u00a4\u0000\u0000\u05ad\u05ae"+
		"\u0003\u00a4R\u0000\u05ae\u05b0\u0001\u0000\u0000\u0000\u05af\u0596\u0001"+
		"\u0000\u0000\u0000\u05af\u05a8\u0001\u0000\u0000\u0000\u05b0\u00b1\u0001"+
		"\u0000\u0000\u0000\u05b1\u05b2\u0005f\u0000\u0000\u05b2\u05b3\u0005\u00d4"+
		"\u0000\u0000\u05b3\u05b4\u0003\u00a4R\u0000\u05b4\u05b5\u0005\u00d5\u0000"+
		"\u0000\u05b5\u05b6\u0005\u00d8\u0000\u0000\u05b6\u05bb\u0003\u00b4Z\u0000"+
		"\u05b7\u05b8\u0005\u00da\u0000\u0000\u05b8\u05ba\u0003\u00b4Z\u0000\u05b9"+
		"\u05b7\u0001\u0000\u0000\u0000\u05ba\u05bd\u0001\u0000\u0000\u0000\u05bb"+
		"\u05b9\u0001\u0000\u0000\u0000\u05bb\u05bc\u0001\u0000\u0000\u0000\u05bc"+
		"\u05bf\u0001\u0000\u0000\u0000\u05bd\u05bb\u0001\u0000\u0000\u0000\u05be"+
		"\u05c0\u0005\u00da\u0000\u0000\u05bf\u05be\u0001\u0000\u0000\u0000\u05bf"+
		"\u05c0\u0001\u0000\u0000\u0000\u05c0\u05c1\u0001\u0000\u0000\u0000\u05c1"+
		"\u05c2\u0005\u00d9\u0000\u0000\u05c2\u00b3\u0001\u0000\u0000\u0000\u05c3"+
		"\u05c8\u0003\u00a4R\u0000\u05c4\u05c5\u0005\u00da\u0000\u0000\u05c5\u05c7"+
		"\u0003\u00a4R\u0000\u05c6\u05c4\u0001\u0000\u0000\u0000\u05c7\u05ca\u0001"+
		"\u0000\u0000\u0000\u05c8\u05c6\u0001\u0000\u0000\u0000\u05c8\u05c9\u0001"+
		"\u0000\u0000\u0000\u05c9\u05cb\u0001\u0000\u0000\u0000\u05ca\u05c8\u0001"+
		"\u0000\u0000\u0000\u05cb\u05cc\u0005\u00a4\u0000\u0000\u05cc\u05cd\u0003"+
		"\u00a4R\u0000\u05cd\u00b5\u0001\u0000\u0000\u0000\u05ce\u05cf\u0005h\u0000"+
		"\u0000\u05cf\u05d1\u0003\u00c6c\u0000\u05d0\u05d2\u0003\u00d4j\u0000\u05d1"+
		"\u05d0\u0001\u0000\u0000\u0000\u05d1\u05d2\u0001\u0000\u0000\u0000\u05d2"+
		"\u00b7\u0001\u0000\u0000\u0000\u05d3\u05d4\u0007\u000e\u0000\u0000\u05d4"+
		"\u00b9\u0001\u0000\u0000\u0000\u05d5\u05dd\u0005\u0083\u0000\u0000\u05d6"+
		"\u05d9\u0003\u00a4R\u0000\u05d7\u05d8\u0005\u00a4\u0000\u0000\u05d8\u05da"+
		"\u0003\u00a4R\u0000\u05d9\u05d7\u0001\u0000\u0000\u0000\u05d9\u05da\u0001"+
		"\u0000\u0000\u0000\u05da\u05de\u0001\u0000\u0000\u0000\u05db\u05dc\u0005"+
		"\u0084\u0000\u0000\u05dc\u05de\u0003\u00a4R\u0000\u05dd\u05d6\u0001\u0000"+
		"\u0000\u0000\u05dd\u05db\u0001\u0000\u0000\u0000\u05de\u00bb\u0001\u0000"+
		"\u0000\u0000\u05df\u05e4\u0003\u00be_\u0000\u05e0\u05e1\u0005\u00da\u0000"+
		"\u0000\u05e1\u05e3\u0003\u00be_\u0000\u05e2\u05e0\u0001\u0000\u0000\u0000"+
		"\u05e3\u05e6\u0001\u0000\u0000\u0000\u05e4\u05e2\u0001\u0000\u0000\u0000"+
		"\u05e4\u05e5\u0001\u0000\u0000\u0000\u05e5\u05e8\u0001\u0000\u0000\u0000"+
		"\u05e6\u05e4\u0001\u0000\u0000\u0000\u05e7\u05e9\u0005\u00da\u0000\u0000"+
		"\u05e8\u05e7\u0001\u0000\u0000\u0000\u05e8\u05e9\u0001\u0000\u0000\u0000"+
		"\u05e9\u00bd\u0001\u0000\u0000\u0000\u05ea\u05ed\u0003\u00a4R\u0000\u05eb"+
		"\u05ec\u0005\u00a4\u0000\u0000\u05ec\u05ee\u0003\u00a4R\u0000\u05ed\u05eb"+
		"\u0001\u0000\u0000\u0000\u05ed\u05ee\u0001\u0000\u0000\u0000\u05ee\u05f7"+
		"\u0001\u0000\u0000\u0000\u05ef\u05f0\u0003\u00a4R\u0000\u05f0\u05f1\u0005"+
		"\u00a4\u0000\u0000\u05f1\u05f3\u0001\u0000\u0000\u0000\u05f2\u05ef\u0001"+
		"\u0000\u0000\u0000\u05f2\u05f3\u0001\u0000\u0000\u0000\u05f3\u05f4\u0001"+
		"\u0000\u0000\u0000\u05f4\u05f5\u0005\u00c6\u0000\u0000\u05f5\u05f7\u0003"+
		"\u00ecv\u0000\u05f6\u05ea\u0001\u0000\u0000\u0000\u05f6\u05f2\u0001\u0000"+
		"\u0000\u0000\u05f7\u00bf\u0001\u0000\u0000\u0000\u05f8\u05f9\u0005\u0080"+
		"\u0000\u0000\u05f9\u05fa\u0005\u00d4\u0000\u0000\u05fa\u05ff\u0003\u00c2"+
		"a\u0000\u05fb\u05fc\u0005\u00da\u0000\u0000\u05fc\u05fe\u0003\u00c2a\u0000"+
		"\u05fd\u05fb\u0001\u0000\u0000\u0000\u05fe\u0601\u0001\u0000\u0000\u0000"+
		"\u05ff\u05fd\u0001\u0000\u0000\u0000\u05ff\u0600\u0001\u0000\u0000\u0000"+
		"\u0600\u0602\u0001\u0000\u0000\u0000\u0601\u05ff\u0001\u0000\u0000\u0000"+
		"\u0602\u0603\u0005\u00d5\u0000\u0000\u0603\u00c1\u0001\u0000\u0000\u0000"+
		"\u0604\u0606\u0005\u00c6\u0000\u0000\u0605\u0604\u0001\u0000\u0000\u0000"+
		"\u0605\u0606\u0001\u0000\u0000\u0000\u0606\u0607\u0001\u0000\u0000\u0000"+
		"\u0607\u0608\u0005\u00e0\u0000\u0000\u0608\u00c3\u0001\u0000\u0000\u0000"+
		"\u0609\u060b\u0003\u00ccf\u0000\u060a\u060c\u0003*\u0015\u0000\u060b\u060a"+
		"\u0001\u0000\u0000\u0000\u060b\u060c\u0001\u0000\u0000\u0000\u060c\u060f"+
		"\u0001\u0000\u0000\u0000\u060d\u060f\u0005v\u0000\u0000\u060e\u0609\u0001"+
		"\u0000\u0000\u0000\u060e\u060d\u0001\u0000\u0000\u0000\u060f\u00c5\u0001"+
		"\u0000\u0000\u0000\u0610\u0613\u0003\u00ccf\u0000\u0611\u0613\u0003\u00ca"+
		"e\u0000\u0612\u0610\u0001\u0000\u0000\u0000\u0612\u0611\u0001\u0000\u0000"+
		"\u0000\u0613\u0615\u0001\u0000\u0000\u0000\u0614\u0616\u0003*\u0015\u0000"+
		"\u0615\u0614\u0001\u0000\u0000\u0000\u0615\u0616\u0001\u0000\u0000\u0000"+
		"\u0616\u061b\u0001\u0000\u0000\u0000\u0617\u061b\u0003\u0110\u0088\u0000"+
		"\u0618\u061b\u0005v\u0000\u0000\u0619\u061b\u0003\u00c8d\u0000\u061a\u0612"+
		"\u0001\u0000\u0000\u0000\u061a\u0617\u0001\u0000\u0000\u0000\u061a\u0618"+
		"\u0001\u0000\u0000\u0000\u061a\u0619\u0001\u0000\u0000\u0000\u061b\u00c7"+
		"\u0001\u0000\u0000\u0000\u061c\u061e\u0003,\u0016\u0000\u061d\u061c\u0001"+
		"\u0000\u0000\u0000\u061d\u061e\u0001\u0000\u0000\u0000\u061e\u0620\u0001"+
		"\u0000\u0000\u0000\u061f\u0621\u0005n\u0000\u0000\u0620\u061f\u0001\u0000"+
		"\u0000\u0000\u0620\u0621\u0001\u0000\u0000\u0000\u0621\u0623\u0001\u0000"+
		"\u0000\u0000\u0622\u0624\u0003\u0106\u0083\u0000\u0623\u0622\u0001\u0000"+
		"\u0000\u0000\u0623\u0624\u0001\u0000\u0000\u0000\u0624\u0626\u0001\u0000"+
		"\u0000\u0000\u0625\u0627\u0005l\u0000\u0000\u0626\u0625\u0001\u0000\u0000"+
		"\u0000\u0626\u0627\u0001\u0000\u0000\u0000\u0627\u063d\u0001\u0000\u0000"+
		"\u0000\u0628\u062a\u0003\u001c\u000e\u0000\u0629\u062b\u0003 \u0010\u0000"+
		"\u062a\u0629\u0001\u0000\u0000\u0000\u062a\u062b\u0001\u0000\u0000\u0000"+
		"\u062b\u062e\u0001\u0000\u0000\u0000\u062c\u062d\u0005L\u0000\u0000\u062d"+
		"\u062f\u0003\u00c4b\u0000\u062e\u062c\u0001\u0000\u0000\u0000\u062e\u062f"+
		"\u0001\u0000\u0000\u0000\u062f\u0632\u0001\u0000\u0000\u0000\u0630\u0631"+
		"\u0005V\u0000\u0000\u0631\u0633\u0003\u001e\u000f\u0000\u0632\u0630\u0001"+
		"\u0000\u0000\u0000\u0632\u0633\u0001\u0000\u0000\u0000\u0633\u063e\u0001"+
		"\u0000\u0000\u0000\u0634\u0635\u0005`\u0000\u0000\u0635\u0637\u0003\u0108"+
		"\u0084\u0000\u0636\u0638\u0003 \u0010\u0000\u0637\u0636\u0001\u0000\u0000"+
		"\u0000\u0637\u0638\u0001\u0000\u0000\u0000\u0638\u063b\u0001\u0000\u0000"+
		"\u0000\u0639\u063a\u0005L\u0000\u0000\u063a\u063c\u0003\u001e\u000f\u0000"+
		"\u063b\u0639\u0001\u0000\u0000\u0000\u063b\u063c\u0001\u0000\u0000\u0000"+
		"\u063c\u063e\u0001\u0000\u0000\u0000\u063d\u0628\u0001\u0000\u0000\u0000"+
		"\u063d\u0634\u0001\u0000\u0000\u0000\u063e\u063f\u0001\u0000\u0000\u0000"+
		"\u063f\u0643\u0005\u00d8\u0000\u0000\u0640\u0642\u0003\u0080@\u0000\u0641"+
		"\u0640\u0001\u0000\u0000\u0000\u0642\u0645\u0001\u0000\u0000\u0000\u0643"+
		"\u0641\u0001\u0000\u0000\u0000\u0643\u0644\u0001\u0000\u0000\u0000\u0644"+
		"\u0646\u0001\u0000\u0000\u0000\u0645\u0643\u0001\u0000\u0000\u0000\u0646"+
		"\u0647\u0005\u00d9\u0000\u0000\u0647\u00c9\u0001\u0000\u0000\u0000\u0648"+
		"\u064d\u0003\u00f8|\u0000\u0649\u064a\u0005\u00c1\u0000\u0000\u064a\u064c"+
		"\u0003\u00fa}\u0000\u064b\u0649\u0001\u0000\u0000\u0000\u064c\u064f\u0001"+
		"\u0000\u0000\u0000\u064d\u064b\u0001\u0000\u0000\u0000\u064d\u064e\u0001"+
		"\u0000\u0000\u0000\u064e\u00cb\u0001\u0000\u0000\u0000\u064f\u064d\u0001"+
		"\u0000\u0000\u0000\u0650\u0652\u0005g\u0000\u0000\u0651\u0650\u0001\u0000"+
		"\u0000\u0000\u0651\u0652\u0001\u0000\u0000\u0000\u0652\u0654\u0001\u0000"+
		"\u0000\u0000\u0653\u0655\u0005\u00c2\u0000\u0000\u0654\u0653\u0001\u0000"+
		"\u0000\u0000\u0654\u0655\u0001\u0000\u0000\u0000\u0655\u0656\u0001\u0000"+
		"\u0000\u0000\u0656\u0657\u0003\u00ceg\u0000\u0657\u00cd\u0001\u0000\u0000"+
		"\u0000\u0658\u0666\u0003\u0108\u0084\u0000\u0659\u065e\u0003\u0108\u0084"+
		"\u0000\u065a\u065b\u0005\u00c2\u0000\u0000\u065b\u065d\u0003\u0108\u0084"+
		"\u0000\u065c\u065a\u0001\u0000\u0000\u0000\u065d\u0660\u0001\u0000\u0000"+
		"\u0000\u065e\u065c\u0001\u0000\u0000\u0000\u065e\u065f\u0001\u0000\u0000"+
		"\u0000\u065f\u0663\u0001\u0000\u0000\u0000\u0660\u065e\u0001\u0000\u0000"+
		"\u0000\u0661\u0662\u0005\u00c2\u0000\u0000\u0662\u0664\u0003\u00d0h\u0000"+
		"\u0663\u0661\u0001\u0000\u0000\u0000\u0663\u0664\u0001\u0000\u0000\u0000"+
		"\u0664\u0666\u0001\u0000\u0000\u0000\u0665\u0658\u0001\u0000\u0000\u0000"+
		"\u0665\u0659\u0001\u0000\u0000\u0000\u0666\u00cf\u0001\u0000\u0000\u0000"+
		"\u0667\u066a\u0003\u0108\u0084\u0000\u0668\u0669\u0005.\u0000\u0000\u0669"+
		"\u066b\u0003\u0108\u0084\u0000\u066a\u0668\u0001\u0000\u0000\u0000\u066a"+
		"\u066b\u0001\u0000\u0000\u0000\u066b\u067b\u0001\u0000\u0000\u0000\u066c"+
		"\u066d\u0005\u00d8\u0000\u0000\u066d\u0672\u0003\u00d0h\u0000\u066e\u066f"+
		"\u0005\u00da\u0000\u0000\u066f\u0671\u0003\u00d0h\u0000\u0670\u066e\u0001"+
		"\u0000\u0000\u0000\u0671\u0674\u0001\u0000\u0000\u0000\u0672\u0670\u0001"+
		"\u0000\u0000\u0000\u0672\u0673\u0001\u0000\u0000\u0000\u0673\u0676\u0001"+
		"\u0000\u0000\u0000\u0674\u0672\u0001\u0000\u0000\u0000\u0675\u0677\u0005"+
		"\u00da\u0000\u0000\u0676\u0675\u0001\u0000\u0000\u0000\u0676\u0677\u0001"+
		"\u0000\u0000\u0000\u0677\u0678\u0001\u0000\u0000\u0000\u0678\u0679\u0005"+
		"\u00d9\u0000\u0000\u0679\u067b\u0001\u0000\u0000\u0000\u067a\u0667\u0001"+
		"\u0000\u0000\u0000\u067a\u066c\u0001\u0000\u0000\u0000\u067b\u00d1\u0001"+
		"\u0000\u0000\u0000\u067c\u0681\u0003\u00ccf\u0000\u067d\u067e\u0005\u00da"+
		"\u0000\u0000\u067e\u0680\u0003\u00ccf\u0000\u067f\u067d\u0001\u0000\u0000"+
		"\u0000\u0680\u0683\u0001\u0000\u0000\u0000\u0681\u067f\u0001\u0000\u0000"+
		"\u0000\u0681\u0682\u0001\u0000\u0000\u0000\u0682\u00d3\u0001\u0000\u0000"+
		"\u0000\u0683\u0681\u0001\u0000\u0000\u0000\u0684\u068e\u0005\u00d4\u0000"+
		"\u0000\u0685\u068a\u0003\u00d6k\u0000\u0686\u0687\u0005\u00da\u0000\u0000"+
		"\u0687\u0689\u0003\u00d6k\u0000\u0688\u0686\u0001\u0000\u0000\u0000\u0689"+
		"\u068c\u0001\u0000\u0000\u0000\u068a\u0688\u0001\u0000\u0000\u0000\u068a"+
		"\u068b\u0001\u0000\u0000\u0000\u068b\u068f\u0001\u0000\u0000\u0000\u068c"+
		"\u068a\u0001\u0000\u0000\u0000\u068d\u068f\u0003\u00ba]\u0000\u068e\u0685"+
		"\u0001\u0000\u0000\u0000\u068e\u068d\u0001\u0000\u0000\u0000\u068e\u068f"+
		"\u0001\u0000\u0000\u0000\u068f\u0691\u0001\u0000\u0000\u0000\u0690\u0692"+
		"\u0005\u00da\u0000\u0000\u0691\u0690\u0001\u0000\u0000\u0000\u0691\u0692"+
		"\u0001\u0000\u0000\u0000\u0692\u0693\u0001\u0000\u0000\u0000\u0693\u0694"+
		"\u0005\u00d5\u0000\u0000\u0694\u00d5\u0001\u0000\u0000\u0000\u0695\u0697"+
		"\u0003\u00d8l\u0000\u0696\u0695\u0001\u0000\u0000\u0000\u0696\u0697\u0001"+
		"\u0000\u0000\u0000\u0697\u0699\u0001\u0000\u0000\u0000\u0698\u069a\u0005"+
		"\u00c3\u0000\u0000\u0699\u0698\u0001\u0000\u0000\u0000\u0699\u069a\u0001"+
		"\u0000\u0000\u0000\u069a\u069b\u0001\u0000\u0000\u0000\u069b\u069f\u0003"+
		"\u00a4R\u0000\u069c\u069d\u0005\u00c6\u0000\u0000\u069d\u069f\u0003\u00ec"+
		"v\u0000\u069e\u0696\u0001\u0000\u0000\u0000\u069e\u069c\u0001\u0000\u0000"+
		"\u0000\u069f\u00d7\u0001\u0000\u0000\u0000\u06a0\u06a1\u0003\u0108\u0084"+
		"\u0000\u06a1\u06a2\u0005\u00db\u0000\u0000\u06a2\u00d9\u0001\u0000\u0000"+
		"\u0000\u06a3\u06c7\u0003\u00dcn\u0000\u06a4\u06c7\u0003\u00e6s\u0000\u06a5"+
		"\u06a6\u0005-\u0000\u0000\u06a6\u06ab\u0005\u00d4\u0000\u0000\u06a7\u06a9"+
		"\u0003\u00bc^\u0000\u06a8\u06aa\u0005\u00da\u0000\u0000\u06a9\u06a8\u0001"+
		"\u0000\u0000\u0000\u06a9\u06aa\u0001\u0000\u0000\u0000\u06aa\u06ac\u0001"+
		"\u0000\u0000\u0000\u06ab\u06a7\u0001\u0000\u0000\u0000\u06ab\u06ac\u0001"+
		"\u0000\u0000\u0000\u06ac\u06ad\u0001\u0000\u0000\u0000\u06ad\u06c7\u0005"+
		"\u00d5\u0000\u0000\u06ae\u06b3\u0005\u00d6\u0000\u0000\u06af\u06b1\u0003"+
		"\u00bc^\u0000\u06b0\u06b2\u0005\u00da\u0000\u0000\u06b1\u06b0\u0001\u0000"+
		"\u0000\u0000\u06b1\u06b2\u0001\u0000\u0000\u0000\u06b2\u06b4\u0001\u0000"+
		"\u0000\u0000\u06b3\u06af\u0001\u0000\u0000\u0000\u06b3\u06b4\u0001\u0000"+
		"\u0000\u0000\u06b4\u06b5\u0001\u0000\u0000\u0000\u06b5\u06c7\u0005\u00d7"+
		"\u0000\u0000\u06b6\u06b7\u0007\u000f\u0000\u0000\u06b7\u06c7\u0003\u00da"+
		"m\u0000\u06b8\u06bb\u0003\u00e6s\u0000\u06b9\u06bb\u0003\u00dcn\u0000"+
		"\u06ba\u06b8\u0001\u0000\u0000\u0000\u06ba\u06b9\u0001\u0000\u0000\u0000"+
		"\u06bb\u06c3\u0001\u0000\u0000\u0000\u06bc\u06bf\u0005\u00d2\u0000\u0000"+
		"\u06bd\u06c0\u0003\u00e6s\u0000\u06be\u06c0\u0003\u00dcn\u0000\u06bf\u06bd"+
		"\u0001\u0000\u0000\u0000\u06bf\u06be\u0001\u0000\u0000\u0000\u06c0\u06c2"+
		"\u0001\u0000\u0000\u0000\u06c1\u06bc\u0001\u0000\u0000\u0000\u06c2\u06c5"+
		"\u0001\u0000\u0000\u0000\u06c3\u06c1\u0001\u0000\u0000\u0000\u06c3\u06c4"+
		"\u0001\u0000\u0000\u0000\u06c4\u06c7\u0001\u0000\u0000\u0000\u06c5\u06c3"+
		"\u0001\u0000\u0000\u0000\u06c6\u06a3\u0001\u0000\u0000\u0000\u06c6\u06a4"+
		"\u0001\u0000\u0000\u0000\u06c6\u06a5\u0001\u0000\u0000\u0000\u06c6\u06ae"+
		"\u0001\u0000\u0000\u0000\u06c6\u06b6\u0001\u0000\u0000\u0000\u06c6\u06ba"+
		"\u0001\u0000\u0000\u0000\u06c7\u00db\u0001\u0000\u0000\u0000\u06c8\u06ce"+
		"\u0005i\u0000\u0000\u06c9\u06ce\u0003\u00deo\u0000\u06ca\u06ce\u0003\u010c"+
		"\u0086\u0000\u06cb\u06ce\u0003\u00e2q\u0000\u06cc\u06ce\u0003\u00ccf\u0000"+
		"\u06cd\u06c8\u0001\u0000\u0000\u0000\u06cd\u06c9\u0001\u0000\u0000\u0000"+
		"\u06cd\u06ca\u0001\u0000\u0000\u0000\u06cd\u06cb\u0001\u0000\u0000\u0000"+
		"\u06cd\u06cc\u0001\u0000\u0000\u0000\u06ce\u00dd\u0001\u0000\u0000\u0000"+
		"\u06cf\u06d4\u0005\u00e4\u0000\u0000\u06d0\u06d4\u00051\u0000\u0000\u06d1"+
		"\u06d4\u0003\u00e0p\u0000\u06d2\u06d4\u0003\u00e4r\u0000\u06d3\u06cf\u0001"+
		"\u0000\u0000\u0000\u06d3\u06d0\u0001\u0000\u0000\u0000\u06d3\u06d1\u0001"+
		"\u0000\u0000\u0000\u06d3\u06d2\u0001\u0000\u0000\u0000\u06d4\u00df\u0001"+
		"\u0000\u0000\u0000\u06d5\u06d6\u0007\u0010\u0000\u0000\u06d6\u00e1\u0001"+
		"\u0000\u0000\u0000\u06d7\u06d8\u0007\u0011\u0000\u0000\u06d8\u06dd\u0005"+
		"\u00c0\u0000\u0000\u06d9\u06de\u0003\u0108\u0084\u0000\u06da\u06de\u0005"+
		"\u008d\u0000\u0000\u06db\u06de\u0005\u0089\u0000\u0000\u06dc\u06de\u0005"+
		"\u008a\u0000\u0000\u06dd\u06d9\u0001\u0000\u0000\u0000\u06dd\u06da\u0001"+
		"\u0000\u0000\u0000\u06dd\u06db\u0001\u0000\u0000\u0000\u06dd\u06dc\u0001"+
		"\u0000\u0000\u0000\u06de\u06ea\u0001\u0000\u0000\u0000\u06df\u06e3\u0003"+
		"\u00c4b\u0000\u06e0\u06e3\u0003\u00fe\u007f\u0000\u06e1\u06e3\u0003\u00e6"+
		"s\u0000\u06e2\u06df\u0001\u0000\u0000\u0000\u06e2\u06e0\u0001\u0000\u0000"+
		"\u0000\u06e2\u06e1\u0001\u0000\u0000\u0000\u06e3\u06e4\u0001\u0000\u0000"+
		"\u0000\u06e4\u06e7\u0005\u00c0\u0000\u0000\u06e5\u06e8\u0003\u0108\u0084"+
		"\u0000\u06e6\u06e8\u0003\u00fe\u007f\u0000\u06e7\u06e5\u0001\u0000\u0000"+
		"\u0000\u06e7\u06e6\u0001\u0000\u0000\u0000\u06e8\u06ea\u0001\u0000\u0000"+
		"\u0000\u06e9\u06d7\u0001\u0000\u0000\u0000\u06e9\u06e2\u0001\u0000\u0000"+
		"\u0000\u06ea\u00e3\u0001\u0000\u0000\u0000\u06eb\u06ec\u0005\u00e1\u0000"+
		"\u0000\u06ec\u00e5\u0001\u0000\u0000\u0000\u06ed\u06ef\u0005\u00eb\u0000"+
		"\u0000\u06ee\u06f0\u0005\u00f3\u0000\u0000\u06ef\u06ee\u0001\u0000\u0000"+
		"\u0000\u06f0\u06f1\u0001\u0000\u0000\u0000\u06f1\u06ef\u0001\u0000\u0000"+
		"\u0000\u06f1\u06f2\u0001\u0000\u0000\u0000\u06f2\u0703\u0001\u0000\u0000"+
		"\u0000\u06f3\u06f5\u0005\u00ea\u0000\u0000\u06f4\u06f6\u0005\u00f3\u0000"+
		"\u0000\u06f5\u06f4\u0001\u0000\u0000\u0000\u06f6\u06f7\u0001\u0000\u0000"+
		"\u0000\u06f7\u06f5\u0001\u0000\u0000\u0000\u06f7\u06f8\u0001\u0000\u0000"+
		"\u0000\u06f8\u0703\u0001\u0000\u0000\u0000\u06f9\u0703\u0005\u00e8\u0000"+
		"\u0000\u06fa\u06fe\u0005\u00e9\u0000\u0000\u06fb\u06fd\u0003\u00e8t\u0000"+
		"\u06fc\u06fb\u0001\u0000\u0000\u0000\u06fd\u0700\u0001\u0000\u0000\u0000"+
		"\u06fe\u06fc\u0001\u0000\u0000\u0000\u06fe\u06ff\u0001\u0000\u0000\u0000"+
		"\u06ff\u0701\u0001\u0000\u0000\u0000\u0700\u06fe\u0001\u0000\u0000\u0000"+
		"\u0701\u0703\u0005\u00e9\u0000\u0000\u0702\u06ed\u0001\u0000\u0000\u0000"+
		"\u0702\u06f3\u0001\u0000\u0000\u0000\u0702\u06f9\u0001\u0000\u0000\u0000"+
		"\u0702\u06fa\u0001\u0000\u0000\u0000\u0703\u00e7\u0001\u0000\u0000\u0000"+
		"\u0704\u0708\u0005\u00ef\u0000\u0000\u0705\u0708\u0005\u00ee\u0000\u0000"+
		"\u0706\u0708\u0003\u00ecv\u0000\u0707\u0704\u0001\u0000\u0000\u0000\u0707"+
		"\u0705\u0001\u0000\u0000\u0000\u0707\u0706\u0001\u0000\u0000\u0000\u0708"+
		"\u00e9\u0001\u0000\u0000\u0000\u0709\u070e\u0003\u00ecv\u0000\u070a\u070b"+
		"\u0005\u00da\u0000\u0000\u070b\u070d\u0003\u00ecv\u0000\u070c\u070a\u0001"+
		"\u0000\u0000\u0000\u070d\u0710\u0001\u0000\u0000\u0000\u070e\u070c\u0001"+
		"\u0000\u0000\u0000\u070e\u070f\u0001\u0000\u0000\u0000\u070f\u00eb\u0001"+
		"\u0000\u0000\u0000\u0710\u070e\u0001\u0000\u0000\u0000\u0711\u0715\u0003"+
		"\u00eew\u0000\u0712\u0714\u0003\u00f0x\u0000\u0713\u0712\u0001\u0000\u0000"+
		"\u0000\u0714\u0717\u0001\u0000\u0000\u0000\u0715\u0713\u0001\u0000\u0000"+
		"\u0000\u0715\u0716\u0001\u0000\u0000\u0000\u0716\u00ed\u0001\u0000\u0000"+
		"\u0000\u0717\u0715\u0001\u0000\u0000\u0000\u0718\u071f\u0003\u00f8|\u0000"+
		"\u0719\u071f\u0003\u00f2y\u0000\u071a\u071b\u0005\u00d4\u0000\u0000\u071b"+
		"\u071c\u0003\u00b6[\u0000\u071c\u071d\u0005\u00d5\u0000\u0000\u071d\u071f"+
		"\u0001\u0000\u0000\u0000\u071e\u0718\u0001\u0000\u0000\u0000\u071e\u0719"+
		"\u0001\u0000\u0000\u0000\u071e\u071a\u0001\u0000\u0000\u0000\u071f\u00ef"+
		"\u0001\u0000\u0000\u0000\u0720\u0721\u0005\u00c1\u0000\u0000\u0721\u0723"+
		"\u0003\u00fa}\u0000\u0722\u0724\u0003\u00f6{\u0000\u0723\u0722\u0001\u0000"+
		"\u0000\u0000\u0723\u0724\u0001\u0000\u0000\u0000\u0724\u00f1\u0001\u0000"+
		"\u0000\u0000\u0725\u0726\u0003\u00f4z\u0000\u0726\u0727\u0003\u00f6{\u0000"+
		"\u0727\u00f3\u0001\u0000\u0000\u0000\u0728\u072d\u0003\u00ccf\u0000\u0729"+
		"\u072d\u0003\u00e2q\u0000\u072a\u072d\u0003\u00f8|\u0000\u072b\u072d\u0003"+
		"\u00a2Q\u0000\u072c\u0728\u0001\u0000\u0000\u0000\u072c\u0729\u0001\u0000"+
		"\u0000\u0000\u072c\u072a\u0001\u0000\u0000\u0000\u072c\u072b\u0001\u0000"+
		"\u0000\u0000\u072d\u00f5\u0001\u0000\u0000\u0000\u072e\u0730\u0003*\u0015"+
		"\u0000\u072f\u072e\u0001\u0000\u0000\u0000\u072f\u0730\u0001\u0000\u0000"+
		"\u0000\u0730\u0732\u0001\u0000\u0000\u0000\u0731\u0733\u0003\u00d4j\u0000"+
		"\u0732\u0731\u0001\u0000\u0000\u0000\u0733\u0734\u0001\u0000\u0000\u0000"+
		"\u0734\u0732\u0001\u0000\u0000\u0000\u0734\u0735\u0001\u0000\u0000\u0000"+
		"\u0735\u0739\u0001\u0000\u0000\u0000\u0736\u0738\u0003\u0100\u0080\u0000"+
		"\u0737\u0736\u0001\u0000\u0000\u0000\u0738\u073b\u0001\u0000\u0000\u0000"+
		"\u0739\u0737\u0001\u0000\u0000\u0000\u0739\u073a\u0001\u0000\u0000\u0000"+
		"\u073a\u00f7\u0001\u0000\u0000\u0000\u073b\u0739\u0001\u0000\u0000\u0000"+
		"\u073c\u073f\u0003\u00fe\u007f\u0000\u073d\u073e\u0005\u00c0\u0000\u0000"+
		"\u073e\u0740\u0003\u00fe\u007f\u0000\u073f\u073d\u0001\u0000\u0000\u0000"+
		"\u073f\u0740\u0001\u0000\u0000\u0000\u0740\u0746\u0001\u0000\u0000\u0000"+
		"\u0741\u0742\u0003\u00c4b\u0000\u0742\u0743\u0005\u00c0\u0000\u0000\u0743"+
		"\u0744\u0003\u00fe\u007f\u0000\u0744\u0746\u0001\u0000\u0000\u0000\u0745"+
		"\u073c\u0001\u0000\u0000\u0000\u0745\u0741\u0001\u0000\u0000\u0000\u0746"+
		"\u00f9\u0001\u0000\u0000\u0000\u0747\u074a\u0003\u00fc~\u0000\u0748\u074a"+
		"\u0003\u00fe\u007f\u0000\u0749\u0747\u0001\u0000\u0000\u0000\u0749\u0748"+
		"\u0001\u0000\u0000\u0000\u074a\u00fb\u0001\u0000\u0000\u0000\u074b\u0751"+
		"\u0003\u0108\u0084\u0000\u074c\u074d\u0005\u00d8\u0000\u0000\u074d\u074e"+
		"\u0003\u00a4R\u0000\u074e\u074f\u0005\u00d9\u0000\u0000\u074f\u0751\u0001"+
		"\u0000\u0000\u0000\u0750\u074b\u0001\u0000\u0000\u0000\u0750\u074c\u0001"+
		"\u0000\u0000\u0000\u0751\u0755\u0001\u0000\u0000\u0000\u0752\u0754\u0003"+
		"\u0100\u0080\u0000\u0753\u0752\u0001\u0000\u0000\u0000\u0754\u0757\u0001"+
		"\u0000\u0000\u0000\u0755\u0753\u0001\u0000\u0000\u0000\u0755\u0756\u0001"+
		"\u0000\u0000\u0000\u0756\u00fd\u0001\u0000\u0000\u0000\u0757\u0755\u0001"+
		"\u0000\u0000\u0000\u0758\u075a\u0005\u00d1\u0000\u0000\u0759\u0758\u0001"+
		"\u0000\u0000\u0000\u075a\u075d\u0001\u0000\u0000\u0000\u075b\u0759\u0001"+
		"\u0000\u0000\u0000\u075b\u075c\u0001\u0000\u0000\u0000\u075c\u0764\u0001"+
		"\u0000\u0000\u0000\u075d\u075b\u0001\u0000\u0000\u0000\u075e\u0765\u0005"+
		"\u00e0\u0000\u0000\u075f\u0760\u0005\u00d1\u0000\u0000\u0760\u0761\u0005"+
		"\u00d8\u0000\u0000\u0761\u0762\u0003\u00a4R\u0000\u0762\u0763\u0005\u00d9"+
		"\u0000\u0000\u0763\u0765\u0001\u0000\u0000\u0000\u0764\u075e\u0001\u0000"+
		"\u0000\u0000\u0764\u075f\u0001\u0000\u0000\u0000\u0765\u0769\u0001\u0000"+
		"\u0000\u0000\u0766\u0768\u0003\u0100\u0080\u0000\u0767\u0766\u0001\u0000"+
		"\u0000\u0000\u0768\u076b\u0001\u0000\u0000\u0000\u0769\u0767\u0001\u0000"+
		"\u0000\u0000\u0769\u076a\u0001\u0000\u0000\u0000\u076a\u00ff\u0001\u0000"+
		"\u0000\u0000\u076b\u0769\u0001\u0000\u0000\u0000\u076c\u076e\u0005\u00d6"+
		"\u0000\u0000\u076d\u076f\u0003\u00a4R\u0000\u076e\u076d\u0001\u0000\u0000"+
		"\u0000\u076e\u076f\u0001\u0000\u0000\u0000\u076f\u0770\u0001\u0000\u0000"+
		"\u0000\u0770\u0776\u0005\u00d7\u0000\u0000\u0771\u0772\u0005\u00d8\u0000"+
		"\u0000\u0772\u0773\u0003\u00a4R\u0000\u0773\u0774\u0005\u00d9\u0000\u0000"+
		"\u0774\u0776\u0001\u0000\u0000\u0000\u0775\u076c\u0001\u0000\u0000\u0000"+
		"\u0775\u0771\u0001\u0000\u0000\u0000\u0776\u0101\u0001\u0000\u0000\u0000"+
		"\u0777\u0779\u0003\u0104\u0082\u0000\u0778\u0777\u0001\u0000\u0000\u0000"+
		"\u0778\u0779\u0001\u0000\u0000\u0000\u0779\u0780\u0001\u0000\u0000\u0000"+
		"\u077a\u077c\u0005\u00da\u0000\u0000\u077b\u077d\u0003\u0104\u0082\u0000"+
		"\u077c\u077b\u0001\u0000\u0000\u0000\u077c\u077d\u0001\u0000\u0000\u0000"+
		"\u077d\u077f\u0001\u0000\u0000\u0000\u077e\u077a\u0001\u0000\u0000\u0000"+
		"\u077f\u0782\u0001\u0000\u0000\u0000\u0780\u077e\u0001\u0000\u0000\u0000"+
		"\u0780\u0781\u0001\u0000\u0000\u0000\u0781\u0103\u0001\u0000\u0000\u0000"+
		"\u0782\u0780\u0001\u0000\u0000\u0000\u0783\u078b\u0003\u00ecv\u0000\u0784"+
		"\u0785\u0005b\u0000\u0000\u0785\u0786\u0005\u00d4\u0000\u0000\u0786\u0787"+
		"\u0003\u0102\u0081\u0000\u0787\u0788\u0005\u00d5\u0000\u0000\u0788\u078b"+
		"\u0001\u0000\u0000\u0000\u0789\u078b\u0003\u00be_\u0000\u078a\u0783\u0001"+
		"\u0000\u0000\u0000\u078a\u0784\u0001\u0000\u0000\u0000\u078a\u0789\u0001"+
		"\u0000\u0000\u0000\u078b\u0105\u0001\u0000\u0000\u0000\u078c\u078d\u0007"+
		"\u0012\u0000\u0000\u078d\u0107\u0001\u0000\u0000\u0000\u078e\u078f\u0007"+
		"\u0013\u0000\u0000\u078f\u0109\u0001\u0000\u0000\u0000\u0790\u0791\u0007"+
		"\u0014\u0000\u0000\u0791\u010b\u0001\u0000\u0000\u0000\u0792\u0793\u0007"+
		"\u0015\u0000\u0000\u0793\u010d\u0001\u0000\u0000\u0000\u0794\u0795\u0007"+
		"\u0016\u0000\u0000\u0795\u010f\u0001\u0000\u0000\u0000\u0796\u0797\u0007"+
		"\u0017\u0000\u0000\u0797\u0111\u0001\u0000\u0000\u0000\u0798\u0799\u0007"+
		"\u0018\u0000\u0000\u0799\u0113\u0001\u0000\u0000\u0000\u00fc\u0115\u0119"+
		"\u011b\u0123\u0126\u0140\u0144\u0149\u014e\u0154\u0162\u0166\u016c\u0171"+
		"\u0176\u017d\u0183\u018a\u0191\u0194\u0198\u019c\u01a3\u01a6\u01ab\u01ae"+
		"\u01b1\u01b4\u01b9\u01bd\u01c1\u01c6\u01ca\u01cc\u01d2\u01de\u01ef\u01f6"+
		"\u01fe\u0202\u0207\u020d\u0215\u021d\u0223\u022a\u0231\u0236\u023c\u0259"+
		"\u0267\u026b\u0274\u0278\u027d\u0297\u02a2\u02a6\u02aa\u02b3\u02bd\u02c2"+
		"\u02c8\u02cd\u02d2\u02d7\u02dc\u02e2\u02e8\u02ee\u0306\u030b\u030e\u0318"+
		"\u031b\u0328\u0330\u0337\u033a\u033f\u0343\u034c\u0350\u036a\u036f\u0376"+
		"\u037d\u0385\u0388\u038e\u0392\u0395\u039a\u039e\u03a1\u03a4\u03a7\u03af"+
		"\u03b6\u03bf\u03cc\u03d8\u03de\u03e2\u03e9\u03ef\u03f3\u03fa\u0401\u0405"+
		"\u040c\u0410\u0412\u0418\u041f\u0423\u0427\u0434\u0437\u043e\u0445\u0449"+
		"\u044f\u0453\u0458\u045d\u0464\u046c\u0475\u0479\u047f\u0488\u048d\u0494"+
		"\u049b\u04a1\u04e0\u04f1\u04f8\u04fd\u04ff\u0525\u053b\u053d\u0542\u0547"+
		"\u054c\u054f\u0555\u055b\u0562\u0567\u056d\u0577\u057c\u0580\u0584\u0587"+
		"\u058e\u0591\u0596\u059a\u05a0\u05a4\u05af\u05bb\u05bf\u05c8\u05d1\u05d9"+
		"\u05dd\u05e4\u05e8\u05ed\u05f2\u05f6\u05ff\u0605\u060b\u060e\u0612\u0615"+
		"\u061a\u061d\u0620\u0623\u0626\u062a\u062e\u0632\u0637\u063b\u063d\u0643"+
		"\u064d\u0651\u0654\u065e\u0663\u0665\u066a\u0672\u0676\u067a\u0681\u068a"+
		"\u068e\u0691\u0696\u0699\u069e\u06a9\u06ab\u06b1\u06b3\u06ba\u06bf\u06c3"+
		"\u06c6\u06cd\u06d3\u06dd\u06e2\u06e7\u06e9\u06f1\u06f7\u06fe\u0702\u0707"+
		"\u070e\u0715\u071e\u0723\u072c\u072f\u0734\u0739\u073f\u0745\u0749\u0750"+
		"\u0755\u075b\u0764\u0769\u076e\u0775\u0778\u077c\u0780\u078a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}