// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide/grammars-v4/pydatajava/Ninja9.g4 by ANTLR 4.13.1
package org.antlr.parser.antlr4;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class Ninja9Parser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, ABSTRACT=4, ASSERT=5, BOOLEAN=6, BREAK=7, BYTE=8, 
		CASE=9, CATCH=10, CHAR=11, CLASS=12, CONST=13, CONTINUE=14, DEFAULT=15, 
		DO=16, DOUBLE=17, ELSE=18, ENUM=19, EXTENDS=20, FINAL=21, FINALLY=22, 
		FLOAT=23, FOR=24, IF=25, GOTO=26, IMPLEMENTS=27, IMPORT=28, INSTANCEOF=29, 
		INT=30, INTERFACE=31, LONG=32, NATIVE=33, NEW=34, PACKAGE=35, PRIVATE=36, 
		PROTECTED=37, PUBLIC=38, RETURN=39, SHORT=40, STATIC=41, STRICTFP=42, 
		SUPER=43, SWITCH=44, SYNCHRONIZED=45, THIS=46, THROW=47, THROWS=48, TRANSIENT=49, 
		TRY=50, VOID=51, VOLATILE=52, WHILE=53, IntegerLiteral=54, FloatingPointLiteral=55, 
		BooleanLiteral=56, CharacterLiteral=57, StringLiteral=58, NullLiteral=59, 
		LPAREN=60, RPAREN=61, LBRACE=62, RBRACE=63, LBRACK=64, RBRACK=65, SEMI=66, 
		COMMA=67, DOT=68, ASSIGN=69, GT=70, LT=71, BANG=72, TILDE=73, QUESTION=74, 
		COLON=75, EQUAL=76, LE=77, GE=78, NOTEQUAL=79, AND=80, OR=81, INC=82, 
		DEC=83, ADD=84, SUB=85, MUL=86, DIV=87, BITAND=88, BITOR=89, CARET=90, 
		MOD=91, ARROW=92, COLONCOLON=93, ADD_ASSIGN=94, SUB_ASSIGN=95, MUL_ASSIGN=96, 
		DIV_ASSIGN=97, AND_ASSIGN=98, OR_ASSIGN=99, XOR_ASSIGN=100, MOD_ASSIGN=101, 
		LSHIFT_ASSIGN=102, RSHIFT_ASSIGN=103, URSHIFT_ASSIGN=104, Identifier=105, 
		AT=106, ELLIPSIS=107, WS=108, COMMENT=109, LINE_COMMENT=110;
	public static final int
		RULE_compilationUnit = 0, RULE_modifier = 1, RULE_literal = 2, RULE_primitiveType = 3, 
		RULE_numericType = 4, RULE_integralType = 5, RULE_floatingPointType = 6, 
		RULE_referenceType = 7, RULE_classType = 8, RULE_typeVariable = 9, RULE_arrayType = 10, 
		RULE_arrayTypeName = 11, RULE_dims = 12, RULE_arrayDimension = 13, RULE_typeParameter = 14, 
		RULE_typeBound = 15, RULE_additionalBound = 16, RULE_typeArguments = 17, 
		RULE_typeArgumentList = 18, RULE_typeArgument = 19, RULE_wildcard = 20, 
		RULE_wildcardBounds = 21, RULE_wildcardType = 22, RULE_typeName = 23, 
		RULE_propertyLookup = 24, RULE_packageName = 25, RULE_expressionName = 26, 
		RULE_packageDeclaration = 27, RULE_import_static = 28, RULE_import_wildcard = 29, 
		RULE_importDeclaration = 30, RULE_typeDeclaration = 31, RULE_classDeclaration = 32, 
		RULE_typeParameterList = 33, RULE_typeParameters = 34, RULE_superclass = 35, 
		RULE_superinterfaces = 36, RULE_interfaceTypeList = 37, RULE_classBody = 38, 
		RULE_classBodyDeclaration = 39, RULE_fieldDeclaration = 40, RULE_variableDeclaratorList = 41, 
		RULE_variableDeclarator = 42, RULE_variableDeclaratorId = 43, RULE_variableInitializer = 44, 
		RULE_unannType = 45, RULE_unannPrimitiveType = 46, RULE_unannReferenceType = 47, 
		RULE_unannClassOrInterfaceType = 48, RULE_unannClassType = 49, RULE_unannClassType_lf_unannClassOrInterfaceType = 50, 
		RULE_unannClassType_lfno_unannClassOrInterfaceType = 51, RULE_unannInterfaceType_lf_unannClassOrInterfaceType = 52, 
		RULE_unannInterfaceType_lfno_unannClassOrInterfaceType = 53, RULE_unannTypeVariable = 54, 
		RULE_unannArrayType = 55, RULE_methodDeclaration = 56, RULE_methodHeader = 57, 
		RULE_result = 58, RULE_methodDeclarator = 59, RULE_formalParameterList = 60, 
		RULE_formalParameters = 61, RULE_formalParameter = 62, RULE_lastFormalParameter = 63, 
		RULE_receiverParameter = 64, RULE_throws_ = 65, RULE_exceptionTypeList = 66, 
		RULE_exceptionType = 67, RULE_methodBody = 68, RULE_instanceInitializer = 69, 
		RULE_staticInitializer = 70, RULE_constructorDeclaration = 71, RULE_constructorDeclarator = 72, 
		RULE_simpleTypeName = 73, RULE_constructorBody = 74, RULE_explicitConstructorInvocation = 75, 
		RULE_enumDeclaration = 76, RULE_enumBody = 77, RULE_enumConstantList = 78, 
		RULE_enumConstant = 79, RULE_enumBodyDeclarations = 80, RULE_interfaceDeclaration = 81, 
		RULE_normalInterfaceDeclaration = 82, RULE_extendsInterfaces = 83, RULE_interfaceBody = 84, 
		RULE_interfaceMemberDeclaration = 85, RULE_constantDeclaration = 86, RULE_interfaceMethodDeclaration = 87, 
		RULE_annotationTypeDeclaration = 88, RULE_annotationTypeBody = 89, RULE_annotationTypeMemberDeclaration = 90, 
		RULE_annotationTypeElementDeclaration = 91, RULE_defaultValue = 92, RULE_annotation = 93, 
		RULE_normalAnnotation = 94, RULE_elementValuePairList = 95, RULE_elementValuePair = 96, 
		RULE_elementValue = 97, RULE_elementValueArrayInitializer = 98, RULE_elementValueList = 99, 
		RULE_markerAnnotation = 100, RULE_singleElementAnnotation = 101, RULE_arrayInitializer = 102, 
		RULE_variableInitializerList = 103, RULE_block = 104, RULE_blockStatements = 105, 
		RULE_blockStatement = 106, RULE_localVariableDeclarationStatement = 107, 
		RULE_localVariableDeclaration = 108, RULE_statement = 109, RULE_statementNoShortIf = 110, 
		RULE_statementWithoutTrailingSubstatement = 111, RULE_emptyStatement = 112, 
		RULE_labeledStatement = 113, RULE_labeledStatementNoShortIf = 114, RULE_expressionStatement = 115, 
		RULE_statementExpression = 116, RULE_statementAssignment_nocol = 117, 
		RULE_statementPre_nocol = 118, RULE_statementPost_nocol = 119, RULE_statementMethodInvocation_nocol = 120, 
		RULE_statementClassInstanceCreation_nocol = 121, RULE_ifThenStatement = 122, 
		RULE_ifThenElseStatement = 123, RULE_ifThenElseStatementNoShortIf = 124, 
		RULE_assertStatement = 125, RULE_switchStatement = 126, RULE_switchBlock = 127, 
		RULE_switchCase = 128, RULE_defaultSwitchCase = 129, RULE_whileStatement = 130, 
		RULE_whileStatementNoShortIf = 131, RULE_doStatement = 132, RULE_forStatement = 133, 
		RULE_forStatementNoShortIf = 134, RULE_basicForStatement = 135, RULE_basicForStatementNoShortIf = 136, 
		RULE_forInit = 137, RULE_forUpdate = 138, RULE_statementExpressionList = 139, 
		RULE_enhancedForStatement = 140, RULE_enhancedForStatementNoShortIf = 141, 
		RULE_breakStatement = 142, RULE_continueStatement = 143, RULE_returnStatement = 144, 
		RULE_throwStatement = 145, RULE_synchronizedStatement = 146, RULE_tryStatement = 147, 
		RULE_basicTryStatement = 148, RULE_catches = 149, RULE_catchClause = 150, 
		RULE_finally_ = 151, RULE_tryWithResourcesStatement = 152, RULE_resourceSpecification = 153, 
		RULE_resourceList = 154, RULE_resource = 155, RULE_primary = 156, RULE_expressionParenthesis = 157, 
		RULE_primaryNoNewArray_lf_arrayAccess = 158, RULE_primaryNoNewArray_lfno_arrayAccess = 159, 
		RULE_primaryNoNewArray_lf_primary = 160, RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary = 161, 
		RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary = 162, RULE_primaryClassType = 163, 
		RULE_primaryClassTypeAlternates = 164, RULE_voidType = 165, RULE_bracketPair = 166, 
		RULE_primaryNoNewArray_lfno_primary = 167, RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary = 168, 
		RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary = 169, 
		RULE_classIdentifier = 170, RULE_classInstanceCreationExpression = 171, 
		RULE_classInstanceCreationExpression_lf_primary = 172, RULE_classInstanceCreationExpression_lfno_primary = 173, 
		RULE_typeArgumentsOrDiamond = 174, RULE_fieldAccess = 175, RULE_fieldAccess_lf_primary = 176, 
		RULE_fieldAccess_lfno_primary = 177, RULE_arrayAccess = 178, RULE_arrayAccess_lf_primary = 179, 
		RULE_arrayAccess_lfno_primary = 180, RULE_methodInvocation = 181, RULE_methodArea = 182, 
		RULE_methodInvocation_lf_primary = 183, RULE_methodInvocation_lfno_primary = 184, 
		RULE_argumentList = 185, RULE_methodReference = 186, RULE_methodReference_lf_primary = 187, 
		RULE_methodReference_lfno_primary = 188, RULE_arrayCreationExpression = 189, 
		RULE_dimExprs = 190, RULE_dimExpr = 191, RULE_expression = 192, RULE_lambdaExpression = 193, 
		RULE_lambdaParameters = 194, RULE_lambdaInteredParameterList = 195, RULE_lambdaIdentifierParameter = 196, 
		RULE_lambdaParameterList = 197, RULE_inferredFormalParameterList = 198, 
		RULE_lambdaBody = 199, RULE_assignmentExpression = 200, RULE_assignment = 201, 
		RULE_leftHandSide = 202, RULE_assignmentOperator = 203, RULE_leftRightOperator = 204, 
		RULE_conditionalExpression = 205, RULE_unaryExpression = 206, RULE_binaryExpression = 207, 
		RULE_binaryOperator = 208, RULE_prefixOperator = 209, RULE_preExpression = 210, 
		RULE_postfixExpression = 211, RULE_postfixOperator = 212, RULE_postExpression = 213, 
		RULE_castExpression = 214, RULE_castPrimitive = 215, RULE_castReference = 216, 
		RULE_identifier = 217;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "modifier", "literal", "primitiveType", "numericType", 
			"integralType", "floatingPointType", "referenceType", "classType", "typeVariable", 
			"arrayType", "arrayTypeName", "dims", "arrayDimension", "typeParameter", 
			"typeBound", "additionalBound", "typeArguments", "typeArgumentList", 
			"typeArgument", "wildcard", "wildcardBounds", "wildcardType", "typeName", 
			"propertyLookup", "packageName", "expressionName", "packageDeclaration", 
			"import_static", "import_wildcard", "importDeclaration", "typeDeclaration", 
			"classDeclaration", "typeParameterList", "typeParameters", "superclass", 
			"superinterfaces", "interfaceTypeList", "classBody", "classBodyDeclaration", 
			"fieldDeclaration", "variableDeclaratorList", "variableDeclarator", "variableDeclaratorId", 
			"variableInitializer", "unannType", "unannPrimitiveType", "unannReferenceType", 
			"unannClassOrInterfaceType", "unannClassType", "unannClassType_lf_unannClassOrInterfaceType", 
			"unannClassType_lfno_unannClassOrInterfaceType", "unannInterfaceType_lf_unannClassOrInterfaceType", 
			"unannInterfaceType_lfno_unannClassOrInterfaceType", "unannTypeVariable", 
			"unannArrayType", "methodDeclaration", "methodHeader", "result", "methodDeclarator", 
			"formalParameterList", "formalParameters", "formalParameter", "lastFormalParameter", 
			"receiverParameter", "throws_", "exceptionTypeList", "exceptionType", 
			"methodBody", "instanceInitializer", "staticInitializer", "constructorDeclaration", 
			"constructorDeclarator", "simpleTypeName", "constructorBody", "explicitConstructorInvocation", 
			"enumDeclaration", "enumBody", "enumConstantList", "enumConstant", "enumBodyDeclarations", 
			"interfaceDeclaration", "normalInterfaceDeclaration", "extendsInterfaces", 
			"interfaceBody", "interfaceMemberDeclaration", "constantDeclaration", 
			"interfaceMethodDeclaration", "annotationTypeDeclaration", "annotationTypeBody", 
			"annotationTypeMemberDeclaration", "annotationTypeElementDeclaration", 
			"defaultValue", "annotation", "normalAnnotation", "elementValuePairList", 
			"elementValuePair", "elementValue", "elementValueArrayInitializer", "elementValueList", 
			"markerAnnotation", "singleElementAnnotation", "arrayInitializer", "variableInitializerList", 
			"block", "blockStatements", "blockStatement", "localVariableDeclarationStatement", 
			"localVariableDeclaration", "statement", "statementNoShortIf", "statementWithoutTrailingSubstatement", 
			"emptyStatement", "labeledStatement", "labeledStatementNoShortIf", "expressionStatement", 
			"statementExpression", "statementAssignment_nocol", "statementPre_nocol", 
			"statementPost_nocol", "statementMethodInvocation_nocol", "statementClassInstanceCreation_nocol", 
			"ifThenStatement", "ifThenElseStatement", "ifThenElseStatementNoShortIf", 
			"assertStatement", "switchStatement", "switchBlock", "switchCase", "defaultSwitchCase", 
			"whileStatement", "whileStatementNoShortIf", "doStatement", "forStatement", 
			"forStatementNoShortIf", "basicForStatement", "basicForStatementNoShortIf", 
			"forInit", "forUpdate", "statementExpressionList", "enhancedForStatement", 
			"enhancedForStatementNoShortIf", "breakStatement", "continueStatement", 
			"returnStatement", "throwStatement", "synchronizedStatement", "tryStatement", 
			"basicTryStatement", "catches", "catchClause", "finally_", "tryWithResourcesStatement", 
			"resourceSpecification", "resourceList", "resource", "primary", "expressionParenthesis", 
			"primaryNoNewArray_lf_arrayAccess", "primaryNoNewArray_lfno_arrayAccess", 
			"primaryNoNewArray_lf_primary", "primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary", 
			"primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary", "primaryClassType", 
			"primaryClassTypeAlternates", "voidType", "bracketPair", "primaryNoNewArray_lfno_primary", 
			"primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary", "primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary", 
			"classIdentifier", "classInstanceCreationExpression", "classInstanceCreationExpression_lf_primary", 
			"classInstanceCreationExpression_lfno_primary", "typeArgumentsOrDiamond", 
			"fieldAccess", "fieldAccess_lf_primary", "fieldAccess_lfno_primary", 
			"arrayAccess", "arrayAccess_lf_primary", "arrayAccess_lfno_primary", 
			"methodInvocation", "methodArea", "methodInvocation_lf_primary", "methodInvocation_lfno_primary", 
			"argumentList", "methodReference", "methodReference_lf_primary", "methodReference_lfno_primary", 
			"arrayCreationExpression", "dimExprs", "dimExpr", "expression", "lambdaExpression", 
			"lambdaParameters", "lambdaInteredParameterList", "lambdaIdentifierParameter", 
			"lambdaParameterList", "inferredFormalParameterList", "lambdaBody", "assignmentExpression", 
			"assignment", "leftHandSide", "assignmentOperator", "leftRightOperator", 
			"conditionalExpression", "unaryExpression", "binaryExpression", "binaryOperator", 
			"prefixOperator", "preExpression", "postfixExpression", "postfixOperator", 
			"postExpression", "castExpression", "castPrimitive", "castReference", 
			"identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<<'", "'>>'", "'>>>'", "'abstract'", "'assert'", "'boolean'", 
			"'break'", "'byte'", "'case'", "'catch'", "'char'", "'class'", "'const'", 
			"'continue'", "'default'", "'do'", "'double'", "'else'", "'enum'", "'extends'", 
			"'final'", "'finally'", "'float'", "'for'", "'if'", "'goto'", "'implements'", 
			"'import'", "'instanceof'", "'int'", "'interface'", "'long'", "'native'", 
			"'new'", "'package'", "'private'", "'protected'", "'public'", "'return'", 
			"'short'", "'static'", "'strictfp'", "'super'", "'switch'", "'synchronized'", 
			"'this'", "'throw'", "'throws'", "'transient'", "'try'", "'void'", "'volatile'", 
			"'while'", null, null, null, null, null, "'null'", "'('", "')'", "'{'", 
			"'}'", "'['", "']'", "';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", 
			"'~'", "'?'", "':'", "'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", 
			"'++'", "'--'", "'+'", "'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", 
			"'->'", "'::'", "'+='", "'-='", "'*='", "'/='", "'&='", "'|='", "'^='", 
			"'%='", "'<<='", "'>>='", "'>>>='", null, "'@'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", 
			"CASE", "CATCH", "CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", 
			"DOUBLE", "ELSE", "ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", 
			"IF", "GOTO", "IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", 
			"LONG", "NATIVE", "NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", 
			"RETURN", "SHORT", "STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", 
			"THIS", "THROW", "THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", 
			"IntegerLiteral", "FloatingPointLiteral", "BooleanLiteral", "CharacterLiteral", 
			"StringLiteral", "NullLiteral", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
			"TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", 
			"OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", 
			"MOD", "ARROW", "COLONCOLON", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", 
			"DIV_ASSIGN", "AND_ASSIGN", "OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", 
			"LSHIFT_ASSIGN", "RSHIFT_ASSIGN", "URSHIFT_ASSIGN", "Identifier", "AT", 
			"ELLIPSIS", "WS", "COMMENT", "LINE_COMMENT"
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
	public String getGrammarFileName() { return "Ninja9.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public Ninja9Parser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(Ninja9Parser.EOF, 0); }
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterCompilationUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitCompilationUnit(this);
		}
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(437);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(436);
				packageDeclaration();
				}
			}

			setState(442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(439);
				importDeclaration();
				}
				}
				setState(444);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108822799028240L) != 0) || _la==SEMI || _la==AT) {
				{
				{
				setState(445);
				typeDeclaration();
				}
				}
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(451);
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
	public static class ModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(Ninja9Parser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(Ninja9Parser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(Ninja9Parser.PROTECTED, 0); }
		public TerminalNode FINAL() { return getToken(Ninja9Parser.FINAL, 0); }
		public TerminalNode STATIC() { return getToken(Ninja9Parser.STATIC, 0); }
		public TerminalNode STRICTFP() { return getToken(Ninja9Parser.STRICTFP, 0); }
		public TerminalNode VOLATILE() { return getToken(Ninja9Parser.VOLATILE, 0); }
		public TerminalNode ABSTRACT() { return getToken(Ninja9Parser.ABSTRACT, 0); }
		public TerminalNode SYNCHRONIZED() { return getToken(Ninja9Parser.SYNCHRONIZED, 0); }
		public TerminalNode TRANSIENT() { return getToken(Ninja9Parser.TRANSIENT, 0); }
		public TerminalNode NATIVE() { return getToken(Ninja9Parser.NATIVE, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterModifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitModifier(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_modifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(453);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) ) {
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
	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	 
		public LiteralContext() { }
		public void copyFrom(LiteralContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends LiteralContext {
		public TerminalNode StringLiteral() { return getToken(Ninja9Parser.StringLiteral, 0); }
		public StringLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStringLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FloatingPointLiteralContext extends LiteralContext {
		public TerminalNode FloatingPointLiteral() { return getToken(Ninja9Parser.FloatingPointLiteral, 0); }
		public FloatingPointLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFloatingPointLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFloatingPointLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class BooleanLiteralContext extends LiteralContext {
		public TerminalNode BooleanLiteral() { return getToken(Ninja9Parser.BooleanLiteral, 0); }
		public BooleanLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBooleanLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NullLiteralContext extends LiteralContext {
		public TerminalNode NullLiteral() { return getToken(Ninja9Parser.NullLiteral, 0); }
		public NullLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterNullLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitNullLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerLiteralContext extends LiteralContext {
		public TerminalNode IntegerLiteral() { return getToken(Ninja9Parser.IntegerLiteral, 0); }
		public IntegerLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIntegerLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIntegerLiteral(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class CharacterLiteralContext extends LiteralContext {
		public TerminalNode CharacterLiteral() { return getToken(Ninja9Parser.CharacterLiteral, 0); }
		public CharacterLiteralContext(LiteralContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterCharacterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitCharacterLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_literal);
		try {
			setState(461);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntegerLiteral:
				_localctx = new IntegerLiteralContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(455);
				match(IntegerLiteral);
				}
				break;
			case FloatingPointLiteral:
				_localctx = new FloatingPointLiteralContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(456);
				match(FloatingPointLiteral);
				}
				break;
			case BooleanLiteral:
				_localctx = new BooleanLiteralContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(457);
				match(BooleanLiteral);
				}
				break;
			case CharacterLiteral:
				_localctx = new CharacterLiteralContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(458);
				match(CharacterLiteral);
				}
				break;
			case StringLiteral:
				_localctx = new StringLiteralContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(459);
				match(StringLiteral);
				}
				break;
			case NullLiteral:
				_localctx = new NullLiteralContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(460);
				match(NullLiteral);
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
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode BOOLEAN() { return getToken(Ninja9Parser.BOOLEAN, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimitiveType(this);
		}
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_primitiveType);
		int _la;
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(466);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(463);
					annotation();
					}
					}
					setState(468);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(469);
				numericType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(473);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(470);
					annotation();
					}
					}
					setState(475);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(476);
				match(BOOLEAN);
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
	public static class NumericTypeContext extends ParserRuleContext {
		public IntegralTypeContext integralType() {
			return getRuleContext(IntegralTypeContext.class,0);
		}
		public FloatingPointTypeContext floatingPointType() {
			return getRuleContext(FloatingPointTypeContext.class,0);
		}
		public NumericTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numericType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterNumericType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitNumericType(this);
		}
	}

	public final NumericTypeContext numericType() throws RecognitionException {
		NumericTypeContext _localctx = new NumericTypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_numericType);
		try {
			setState(481);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				integralType();
				}
				break;
			case DOUBLE:
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(480);
				floatingPointType();
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
	public static class IntegralTypeContext extends ParserRuleContext {
		public TerminalNode BYTE() { return getToken(Ninja9Parser.BYTE, 0); }
		public TerminalNode SHORT() { return getToken(Ninja9Parser.SHORT, 0); }
		public TerminalNode INT() { return getToken(Ninja9Parser.INT, 0); }
		public TerminalNode LONG() { return getToken(Ninja9Parser.LONG, 0); }
		public TerminalNode CHAR() { return getToken(Ninja9Parser.CHAR, 0); }
		public IntegralTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integralType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIntegralType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIntegralType(this);
		}
	}

	public final IntegralTypeContext integralType() throws RecognitionException {
		IntegralTypeContext _localctx = new IntegralTypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_integralType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(483);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1104880339200L) != 0)) ) {
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
	public static class FloatingPointTypeContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(Ninja9Parser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(Ninja9Parser.DOUBLE, 0); }
		public FloatingPointTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatingPointType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFloatingPointType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFloatingPointType(this);
		}
	}

	public final FloatingPointTypeContext floatingPointType() throws RecognitionException {
		FloatingPointTypeContext _localctx = new FloatingPointTypeContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_floatingPointType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(485);
			_la = _input.LA(1);
			if ( !(_la==DOUBLE || _la==FLOAT) ) {
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
	public static class ReferenceTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public ReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_referenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitReferenceType(this);
		}
	}

	public final ReferenceTypeContext referenceType() throws RecognitionException {
		ReferenceTypeContext _localctx = new ReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_referenceType);
		try {
			setState(490);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(487);
				classType(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(488);
				typeVariable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(489);
				arrayType();
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
	public static class ClassTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassType(this);
		}
	}

	public final ClassTypeContext classType() throws RecognitionException {
		return classType(0);
	}

	private ClassTypeContext classType(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, _parentState);
		ClassTypeContext _prevctx = _localctx;
		int _startState = 16;
		enterRecursionRule(_localctx, 16, RULE_classType, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(496);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(493);
				annotation();
				}
				}
				setState(498);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(499);
			identifier();
			setState(501);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(500);
				typeArguments();
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ClassTypeContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_classType);
					setState(503);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(504);
					match(DOT);
					setState(505);
					classType(2);
					}
					} 
				}
				setState(510);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
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
	public static class TypeVariableContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeVariable(this);
		}
	}

	public final TypeVariableContext typeVariable() throws RecognitionException {
		TypeVariableContext _localctx = new TypeVariableContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeVariable);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(511);
				annotation();
				}
				}
				setState(516);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(517);
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
	public static class ArrayTypeContext extends ParserRuleContext {
		public ArrayTypeNameContext arrayTypeName() {
			return getRuleContext(ArrayTypeNameContext.class,0);
		}
		public List<ArrayDimensionContext> arrayDimension() {
			return getRuleContexts(ArrayDimensionContext.class);
		}
		public ArrayDimensionContext arrayDimension(int i) {
			return getRuleContext(ArrayDimensionContext.class,i);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayType(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_arrayType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(519);
			arrayTypeName();
			setState(521); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(520);
				arrayDimension();
				}
				}
				setState(523); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LBRACK );
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
	public static class ArrayTypeNameContext extends ParserRuleContext {
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ArrayTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayTypeName(this);
		}
	}

	public final ArrayTypeNameContext arrayTypeName() throws RecognitionException {
		ArrayTypeNameContext _localctx = new ArrayTypeNameContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_arrayTypeName);
		try {
			setState(528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(525);
				primitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(526);
				classType(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(527);
				typeVariable();
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
	public static class DimsContext extends ParserRuleContext {
		public List<ArrayDimensionContext> arrayDimension() {
			return getRuleContexts(ArrayDimensionContext.class);
		}
		public ArrayDimensionContext arrayDimension(int i) {
			return getRuleContext(ArrayDimensionContext.class,i);
		}
		public DimsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dims; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterDims(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitDims(this);
		}
	}

	public final DimsContext dims() throws RecognitionException {
		DimsContext _localctx = new DimsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dims);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(531); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(530);
					arrayDimension();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(533); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class ArrayDimensionContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(Ninja9Parser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(Ninja9Parser.RBRACK, 0); }
		public ArrayDimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayDimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayDimension(this);
		}
	}

	public final ArrayDimensionContext arrayDimension() throws RecognitionException {
		ArrayDimensionContext _localctx = new ArrayDimensionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_arrayDimension);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(535);
			match(LBRACK);
			setState(536);
			match(RBRACK);
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
	public static class TypeParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeParameter(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(538);
				annotation();
				}
				}
				setState(543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(544);
			identifier();
			setState(546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(545);
				typeBound();
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
	public static class TypeBoundContext extends ParserRuleContext {
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
	 
		public TypeBoundContext() { }
		public void copyFrom(TypeBoundContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SimpleTypeBoundContext extends TypeBoundContext {
		public TerminalNode EXTENDS() { return getToken(Ninja9Parser.EXTENDS, 0); }
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public SimpleTypeBoundContext(TypeBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSimpleTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSimpleTypeBound(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassTypeBoundContext extends TypeBoundContext {
		public TerminalNode EXTENDS() { return getToken(Ninja9Parser.EXTENDS, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public ClassTypeBoundContext(TypeBoundContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassTypeBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassTypeBound(this);
		}
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeBound);
		int _la;
		try {
			setState(558);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new SimpleTypeBoundContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(548);
				match(EXTENDS);
				setState(549);
				typeVariable();
				}
				break;
			case 2:
				_localctx = new ClassTypeBoundContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(550);
				match(EXTENDS);
				setState(551);
				classType(0);
				setState(555);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(552);
					additionalBound();
					}
					}
					setState(557);
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
	public static class AdditionalBoundContext extends ParserRuleContext {
		public TerminalNode BITAND() { return getToken(Ninja9Parser.BITAND, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public AdditionalBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additionalBound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAdditionalBound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAdditionalBound(this);
		}
	}

	public final AdditionalBoundContext additionalBound() throws RecognitionException {
		AdditionalBoundContext _localctx = new AdditionalBoundContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_additionalBound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
			match(BITAND);
			setState(561);
			classType(0);
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
	public static class TypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(Ninja9Parser.LT, 0); }
		public TypeArgumentListContext typeArgumentList() {
			return getRuleContext(TypeArgumentListContext.class,0);
		}
		public TerminalNode GT() { return getToken(Ninja9Parser.GT, 0); }
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeArguments(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(LT);
			setState(564);
			typeArgumentList();
			setState(565);
			match(GT);
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
	public static class TypeArgumentListContext extends ParserRuleContext {
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public TypeArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeArgumentList(this);
		}
	}

	public final TypeArgumentListContext typeArgumentList() throws RecognitionException {
		TypeArgumentListContext _localctx = new TypeArgumentListContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeArgumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(567);
			typeArgument();
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(568);
				match(COMMA);
				setState(569);
				typeArgument();
				}
				}
				setState(574);
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
	public static class TypeArgumentContext extends ParserRuleContext {
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardContext wildcard() {
			return getRuleContext(WildcardContext.class,0);
		}
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeArgument(this);
		}
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeArgument);
		try {
			setState(577);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				referenceType();
				}
				break;
			case QUESTION:
				enterOuterAlt(_localctx, 2);
				{
				setState(576);
				wildcard();
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
	public static class WildcardContext extends ParserRuleContext {
		public TerminalNode QUESTION() { return getToken(Ninja9Parser.QUESTION, 0); }
		public WildcardBoundsContext wildcardBounds() {
			return getRuleContext(WildcardBoundsContext.class,0);
		}
		public WildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterWildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitWildcard(this);
		}
	}

	public final WildcardContext wildcard() throws RecognitionException {
		WildcardContext _localctx = new WildcardContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_wildcard);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(579);
			match(QUESTION);
			setState(581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS || _la==SUPER) {
				{
				setState(580);
				wildcardBounds();
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
	public static class WildcardBoundsContext extends ParserRuleContext {
		public WildcardTypeContext wildcardType() {
			return getRuleContext(WildcardTypeContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public WildcardBoundsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardBounds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterWildcardBounds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitWildcardBounds(this);
		}
	}

	public final WildcardBoundsContext wildcardBounds() throws RecognitionException {
		WildcardBoundsContext _localctx = new WildcardBoundsContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_wildcardBounds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			wildcardType();
			setState(584);
			referenceType();
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
	public static class WildcardTypeContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(Ninja9Parser.EXTENDS, 0); }
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public WildcardTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcardType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterWildcardType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitWildcardType(this);
		}
	}

	public final WildcardTypeContext wildcardType() throws RecognitionException {
		WildcardTypeContext _localctx = new WildcardTypeContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_wildcardType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			_la = _input.LA(1);
			if ( !(_la==EXTENDS || _la==SUPER) ) {
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
	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeName(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_typeName);
		try {
			setState(593);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(588);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(589);
				packageName();
				setState(590);
				match(DOT);
				setState(591);
				match(Identifier);
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
	public static class PropertyLookupContext extends ParserRuleContext {
		public List<TerminalNode> Identifier() { return getTokens(Ninja9Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Ninja9Parser.Identifier, i);
		}
		public List<TerminalNode> DOT() { return getTokens(Ninja9Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Ninja9Parser.DOT, i);
		}
		public PropertyLookupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyLookup; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPropertyLookup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPropertyLookup(this);
		}
	}

	public final PropertyLookupContext propertyLookup() throws RecognitionException {
		PropertyLookupContext _localctx = new PropertyLookupContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_propertyLookup);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(595);
			match(Identifier);
			setState(600);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(596);
					match(DOT);
					setState(597);
					match(Identifier);
					}
					} 
				}
				setState(602);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,24,_ctx);
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
	public static class PackageNameContext extends ParserRuleContext {
		public PropertyLookupContext propertyLookup() {
			return getRuleContext(PropertyLookupContext.class,0);
		}
		public PackageNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPackageName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPackageName(this);
		}
	}

	public final PackageNameContext packageName() throws RecognitionException {
		PackageNameContext _localctx = new PackageNameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_packageName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(603);
			propertyLookup();
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
	public static class ExpressionNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public PropertyLookupContext propertyLookup() {
			return getRuleContext(PropertyLookupContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public ExpressionNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExpressionName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExpressionName(this);
		}
	}

	public final ExpressionNameContext expressionName() throws RecognitionException {
		ExpressionNameContext _localctx = new ExpressionNameContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_expressionName);
		try {
			setState(610);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,25,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(605);
				match(Identifier);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(606);
				propertyLookup();
				setState(607);
				match(DOT);
				setState(608);
				match(Identifier);
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
	public static class PackageDeclarationContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(Ninja9Parser.PACKAGE, 0); }
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPackageDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPackageDeclaration(this);
		}
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_packageDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			match(PACKAGE);
			setState(613);
			packageName();
			setState(614);
			match(SEMI);
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
	public static class Import_staticContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(Ninja9Parser.STATIC, 0); }
		public Import_staticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_static; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterImport_static(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitImport_static(this);
		}
	}

	public final Import_staticContext import_static() throws RecognitionException {
		Import_staticContext _localctx = new Import_staticContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_import_static);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(616);
			match(STATIC);
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
	public static class Import_wildcardContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public TerminalNode MUL() { return getToken(Ninja9Parser.MUL, 0); }
		public Import_wildcardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_wildcard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterImport_wildcard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitImport_wildcard(this);
		}
	}

	public final Import_wildcardContext import_wildcard() throws RecognitionException {
		Import_wildcardContext _localctx = new Import_wildcardContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_import_wildcard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(618);
			match(DOT);
			setState(619);
			match(MUL);
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
	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(Ninja9Parser.IMPORT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public Import_staticContext import_static() {
			return getRuleContext(Import_staticContext.class,0);
		}
		public PackageNameContext packageName() {
			return getRuleContext(PackageNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public Import_wildcardContext import_wildcard() {
			return getRuleContext(Import_wildcardContext.class,0);
		}
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterImportDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitImportDeclaration(this);
		}
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(IMPORT);
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(622);
				import_static();
				}
			}

			setState(628);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				{
				setState(625);
				packageName();
				setState(626);
				match(DOT);
				}
				break;
			}
			setState(630);
			typeName();
			setState(632);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(631);
				import_wildcard();
				}
			}

			setState(634);
			match(SEMI);
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
	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeDeclaration(this);
		}
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_typeDeclaration);
		try {
			setState(640);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(636);
				classDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(637);
				enumDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(638);
				interfaceDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(639);
				match(SEMI);
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
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(Ninja9Parser.CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public SuperclassContext superclass() {
			return getRuleContext(SuperclassContext.class,0);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassDeclaration(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(645);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(642);
				annotation();
				}
				}
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(648);
				modifier();
				}
				}
				setState(653);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(654);
			match(CLASS);
			setState(655);
			identifier();
			setState(657);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(656);
				typeParameters();
				}
			}

			setState(660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(659);
				superclass();
				}
			}

			setState(663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(662);
				superinterfaces();
				}
			}

			setState(665);
			classBody();
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
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public TypeParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeParameterList(this);
		}
	}

	public final TypeParameterListContext typeParameterList() throws RecognitionException {
		TypeParameterListContext _localctx = new TypeParameterListContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_typeParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(667);
			typeParameter();
			setState(672);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(668);
				match(COMMA);
				setState(669);
				typeParameter();
				}
				}
				setState(674);
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
	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(Ninja9Parser.LT, 0); }
		public TypeParameterListContext typeParameterList() {
			return getRuleContext(TypeParameterListContext.class,0);
		}
		public TerminalNode GT() { return getToken(Ninja9Parser.GT, 0); }
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTypeParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTypeParameters(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_typeParameters);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(675);
			match(LT);
			setState(676);
			typeParameterList();
			setState(677);
			match(GT);
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
	public static class SuperclassContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(Ninja9Parser.EXTENDS, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public SuperclassContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superclass; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSuperclass(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSuperclass(this);
		}
	}

	public final SuperclassContext superclass() throws RecognitionException {
		SuperclassContext _localctx = new SuperclassContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_superclass);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(679);
			match(EXTENDS);
			setState(680);
			classType(0);
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
	public static class SuperinterfacesContext extends ParserRuleContext {
		public TerminalNode IMPLEMENTS() { return getToken(Ninja9Parser.IMPLEMENTS, 0); }
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public SuperinterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superinterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSuperinterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSuperinterfaces(this);
		}
	}

	public final SuperinterfacesContext superinterfaces() throws RecognitionException {
		SuperinterfacesContext _localctx = new SuperinterfacesContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_superinterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			match(IMPLEMENTS);
			setState(683);
			interfaceTypeList();
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
	public static class InterfaceTypeListContext extends ParserRuleContext {
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public InterfaceTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterInterfaceTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitInterfaceTypeList(this);
		}
	}

	public final InterfaceTypeListContext interfaceTypeList() throws RecognitionException {
		InterfaceTypeListContext _localctx = new InterfaceTypeListContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_interfaceTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(685);
			classType(0);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(686);
				match(COMMA);
				setState(687);
				classType(0);
				}
				}
				setState(692);
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
	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassBody(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(693);
			match(LBRACE);
			setState(697);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4619047745928436048L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267441697L) != 0)) {
				{
				{
				setState(694);
				classBodyDeclaration();
				}
				}
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(700);
			match(RBRACE);
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
	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public InstanceInitializerContext instanceInitializer() {
			return getRuleContext(InstanceInitializerContext.class,0);
		}
		public StaticInitializerContext staticInitializer() {
			return getRuleContext(StaticInitializerContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassBodyDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassBodyDeclaration(this);
		}
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_classBodyDeclaration);
		try {
			setState(710);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(702);
				fieldDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(703);
				methodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(704);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(705);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(706);
				emptyStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(707);
				instanceInitializer();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(708);
				staticInitializer();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(709);
				constructorDeclaration();
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
	public static class FieldDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFieldDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFieldDeclaration(this);
		}
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_fieldDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(712);
				annotation();
				}
				}
				setState(717);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(721);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(718);
				modifier();
				}
				}
				setState(723);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(724);
			unannType();
			setState(725);
			variableDeclaratorList();
			setState(726);
			match(SEMI);
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
	public static class VariableDeclaratorListContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public VariableDeclaratorListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterVariableDeclaratorList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitVariableDeclaratorList(this);
		}
	}

	public final VariableDeclaratorListContext variableDeclaratorList() throws RecognitionException {
		VariableDeclaratorListContext _localctx = new VariableDeclaratorListContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_variableDeclaratorList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(728);
			variableDeclarator();
			setState(733);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(729);
				match(COMMA);
				setState(730);
				variableDeclarator();
				}
				}
				setState(735);
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
	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Ninja9Parser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterVariableDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitVariableDeclarator(this);
		}
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			variableDeclaratorId();
			setState(739);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(737);
				match(ASSIGN);
				setState(738);
				variableInitializer();
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
	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<ArrayDimensionContext> arrayDimension() {
			return getRuleContexts(ArrayDimensionContext.class);
		}
		public ArrayDimensionContext arrayDimension(int i) {
			return getRuleContext(ArrayDimensionContext.class,i);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterVariableDeclaratorId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitVariableDeclaratorId(this);
		}
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(741);
			identifier();
			setState(745);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(742);
				arrayDimension();
				}
				}
				setState(747);
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
	public static class VariableInitializerContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterVariableInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitVariableInitializer(this);
		}
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_variableInitializer);
		try {
			setState(750);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(748);
				expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(749);
				arrayInitializer();
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
	public static class UnannTypeContext extends ParserRuleContext {
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public UnannReferenceTypeContext unannReferenceType() {
			return getRuleContext(UnannReferenceTypeContext.class,0);
		}
		public UnannTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannType(this);
		}
	}

	public final UnannTypeContext unannType() throws RecognitionException {
		UnannTypeContext _localctx = new UnannTypeContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_unannType);
		try {
			setState(754);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,45,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(752);
				unannPrimitiveType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(753);
				unannReferenceType();
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
	public static class UnannPrimitiveTypeContext extends ParserRuleContext {
		public NumericTypeContext numericType() {
			return getRuleContext(NumericTypeContext.class,0);
		}
		public TerminalNode BOOLEAN() { return getToken(Ninja9Parser.BOOLEAN, 0); }
		public UnannPrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannPrimitiveType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannPrimitiveType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannPrimitiveType(this);
		}
	}

	public final UnannPrimitiveTypeContext unannPrimitiveType() throws RecognitionException {
		UnannPrimitiveTypeContext _localctx = new UnannPrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_unannPrimitiveType);
		try {
			setState(758);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(756);
				numericType();
				}
				break;
			case BOOLEAN:
				enterOuterAlt(_localctx, 2);
				{
				setState(757);
				match(BOOLEAN);
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
	public static class UnannReferenceTypeContext extends ParserRuleContext {
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public UnannArrayTypeContext unannArrayType() {
			return getRuleContext(UnannArrayTypeContext.class,0);
		}
		public UnannReferenceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannReferenceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannReferenceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannReferenceType(this);
		}
	}

	public final UnannReferenceTypeContext unannReferenceType() throws RecognitionException {
		UnannReferenceTypeContext _localctx = new UnannReferenceTypeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_unannReferenceType);
		try {
			setState(763);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(760);
				unannClassOrInterfaceType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(761);
				unannTypeVariable();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(762);
				unannArrayType();
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
	public static class UnannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public List<UnannClassType_lf_unannClassOrInterfaceTypeContext> unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContexts(UnannClassType_lf_unannClassOrInterfaceTypeContext.class);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType(int i) {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,i);
		}
		public List<UnannInterfaceType_lf_unannClassOrInterfaceTypeContext> unannInterfaceType_lf_unannClassOrInterfaceType() {
			return getRuleContexts(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext.class);
		}
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType(int i) {
			return getRuleContext(UnannInterfaceType_lf_unannClassOrInterfaceTypeContext.class,i);
		}
		public UnannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannClassOrInterfaceType(this);
		}
	}

	public final UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() throws RecognitionException {
		UnannClassOrInterfaceTypeContext _localctx = new UnannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_unannClassOrInterfaceType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(767);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				{
				setState(765);
				unannClassType_lfno_unannClassOrInterfaceType();
				}
				break;
			case 2:
				{
				setState(766);
				unannInterfaceType_lfno_unannClassOrInterfaceType();
				}
				break;
			}
			setState(773);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					setState(771);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,49,_ctx) ) {
					case 1:
						{
						setState(769);
						unannClassType_lf_unannClassOrInterfaceType();
						}
						break;
					case 2:
						{
						setState(770);
						unannInterfaceType_lf_unannClassOrInterfaceType();
						}
						break;
					}
					} 
				}
				setState(775);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,50,_ctx);
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
	public static class UnannClassTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public UnannClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannClassType(this);
		}
	}

	public final UnannClassTypeContext unannClassType() throws RecognitionException {
		UnannClassTypeContext _localctx = new UnannClassTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_unannClassType);
		int _la;
		try {
			setState(792);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(776);
				match(Identifier);
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(777);
					typeArguments();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(780);
				unannClassOrInterfaceType();
				setState(781);
				match(DOT);
				setState(785);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(782);
					annotation();
					}
					}
					setState(787);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(788);
				match(Identifier);
				setState(790);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(789);
					typeArguments();
					}
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
	public static class UnannClassType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannClassType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannClassType_lf_unannClassOrInterfaceType(this);
		}
	}

	public final UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_unannClassType_lf_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(794);
			match(DOT);
			setState(798);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(795);
				annotation();
				}
				}
				setState(800);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(801);
			match(Identifier);
			setState(803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(802);
				typeArguments();
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
	public static class UnannClassType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannClassType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannClassType_lfno_unannClassOrInterfaceType(this);
		}
	}

	public final UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannClassType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannClassType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_unannClassType_lfno_unannClassOrInterfaceType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(805);
			match(Identifier);
			setState(807);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(806);
				typeArguments();
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
	public static class UnannInterfaceType_lf_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lf_unannClassOrInterfaceTypeContext unannClassType_lf_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lf_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lf_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannInterfaceType_lf_unannClassOrInterfaceType(this);
		}
	}

	public final UnannInterfaceType_lf_unannClassOrInterfaceTypeContext unannInterfaceType_lf_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lf_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lf_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_unannInterfaceType_lf_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			unannClassType_lf_unannClassOrInterfaceType();
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
	public static class UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext extends ParserRuleContext {
		public UnannClassType_lfno_unannClassOrInterfaceTypeContext unannClassType_lfno_unannClassOrInterfaceType() {
			return getRuleContext(UnannClassType_lfno_unannClassOrInterfaceTypeContext.class,0);
		}
		public UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannInterfaceType_lfno_unannClassOrInterfaceType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannInterfaceType_lfno_unannClassOrInterfaceType(this);
		}
	}

	public final UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext unannInterfaceType_lfno_unannClassOrInterfaceType() throws RecognitionException {
		UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext _localctx = new UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_unannInterfaceType_lfno_unannClassOrInterfaceType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(811);
			unannClassType_lfno_unannClassOrInterfaceType();
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
	public static class UnannTypeVariableContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public UnannTypeVariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannTypeVariable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannTypeVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannTypeVariable(this);
		}
	}

	public final UnannTypeVariableContext unannTypeVariable() throws RecognitionException {
		UnannTypeVariableContext _localctx = new UnannTypeVariableContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_unannTypeVariable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(813);
			match(Identifier);
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
	public static class UnannArrayTypeContext extends ParserRuleContext {
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public List<ArrayDimensionContext> arrayDimension() {
			return getRuleContexts(ArrayDimensionContext.class);
		}
		public ArrayDimensionContext arrayDimension(int i) {
			return getRuleContext(ArrayDimensionContext.class,i);
		}
		public UnannClassOrInterfaceTypeContext unannClassOrInterfaceType() {
			return getRuleContext(UnannClassOrInterfaceTypeContext.class,0);
		}
		public UnannTypeVariableContext unannTypeVariable() {
			return getRuleContext(UnannTypeVariableContext.class,0);
		}
		public UnannArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unannArrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnannArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnannArrayType(this);
		}
	}

	public final UnannArrayTypeContext unannArrayType() throws RecognitionException {
		UnannArrayTypeContext _localctx = new UnannArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_unannArrayType);
		int _la;
		try {
			setState(833);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(815);
				unannPrimitiveType();
				setState(817); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(816);
					arrayDimension();
					}
					}
					setState(819); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(821);
				unannClassOrInterfaceType();
				setState(823); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(822);
					arrayDimension();
					}
					}
					setState(825); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(827);
				unannTypeVariable();
				setState(829); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(828);
					arrayDimension();
					}
					}
					setState(831); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
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
	public static class MethodDeclarationContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodDeclaration(this);
		}
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(838);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(835);
				annotation();
				}
				}
				setState(840);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(844);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(841);
				modifier();
				}
				}
				setState(846);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(847);
			methodHeader();
			setState(848);
			methodBody();
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
	public static class MethodHeaderContext extends ParserRuleContext {
		public ResultContext result() {
			return getRuleContext(ResultContext.class,0);
		}
		public MethodDeclaratorContext methodDeclarator() {
			return getRuleContext(MethodDeclaratorContext.class,0);
		}
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public MethodHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodHeader; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodHeader(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodHeader(this);
		}
	}

	public final MethodHeaderContext methodHeader() throws RecognitionException {
		MethodHeaderContext _localctx = new MethodHeaderContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_methodHeader);
		int _la;
		try {
			setState(867);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case VOID:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(850);
				result();
				setState(851);
				methodDeclarator();
				setState(853);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(852);
					throws_();
					}
				}

				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(855);
				typeParameters();
				setState(859);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(856);
					annotation();
					}
					}
					setState(861);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(862);
				result();
				setState(863);
				methodDeclarator();
				setState(865);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==THROWS) {
					{
					setState(864);
					throws_();
					}
				}

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
	public static class ResultContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(Ninja9Parser.VOID, 0); }
		public ResultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_result; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterResult(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitResult(this);
		}
	}

	public final ResultContext result() throws RecognitionException {
		ResultContext _localctx = new ResultContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_result);
		try {
			setState(871);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(869);
				unannType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(870);
				match(VOID);
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
	public static class MethodDeclaratorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public MethodDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodDeclarator(this);
		}
	}

	public final MethodDeclaratorContext methodDeclarator() throws RecognitionException {
		MethodDeclaratorContext _localctx = new MethodDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_methodDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			identifier();
			setState(874);
			match(LPAREN);
			setState(876);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5109925539875152L) != 0) || _la==Identifier || _la==AT) {
				{
				setState(875);
				formalParameterList();
				}
			}

			setState(878);
			match(RPAREN);
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
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Ninja9Parser.COMMA, 0); }
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFormalParameterList(this);
		}
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_formalParameterList);
		try {
			setState(886);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(880);
				receiverParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(881);
				formalParameters();
				setState(882);
				match(COMMA);
				setState(883);
				lastFormalParameter();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(885);
				lastFormalParameter();
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
	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFormalParameters(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_formalParameters);
		try {
			int _alt;
			setState(904);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,73,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(888);
				formalParameter();
				setState(893);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(889);
						match(COMMA);
						setState(890);
						formalParameter();
						}
						} 
					}
					setState(895);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,71,_ctx);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(896);
				receiverParameter();
				setState(901);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(897);
						match(COMMA);
						setState(898);
						formalParameter();
						}
						} 
					}
					setState(903);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,72,_ctx);
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
	public static class FormalParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFormalParameter(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_formalParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(906);
				annotation();
				}
				}
				setState(911);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(915);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(912);
				modifier();
				}
				}
				setState(917);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(918);
			unannType();
			setState(919);
			variableDeclaratorId();
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
	public static class LastFormalParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(Ninja9Parser.ELLIPSIS, 0); }
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public FormalParameterContext formalParameter() {
			return getRuleContext(FormalParameterContext.class,0);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLastFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLastFormalParameter(this);
		}
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_lastFormalParameter);
		int _la;
		try {
			setState(938);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(924);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
					{
					{
					setState(921);
					modifier();
					}
					}
					setState(926);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(927);
				unannType();
				setState(931);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(928);
					annotation();
					}
					}
					setState(933);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(934);
				match(ELLIPSIS);
				setState(935);
				variableDeclaratorId();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(937);
				formalParameter();
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
	public static class ReceiverParameterContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public TerminalNode THIS() { return getToken(Ninja9Parser.THIS, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public ReceiverParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterReceiverParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitReceiverParameter(this);
		}
	}

	public final ReceiverParameterContext receiverParameter() throws RecognitionException {
		ReceiverParameterContext _localctx = new ReceiverParameterContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_receiverParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(940);
				annotation();
				}
				}
				setState(945);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(946);
			unannType();
			setState(950);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(947);
				identifier();
				setState(948);
				match(DOT);
				}
			}

			setState(952);
			match(THIS);
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
	public static class Throws_Context extends ParserRuleContext {
		public TerminalNode THROWS() { return getToken(Ninja9Parser.THROWS, 0); }
		public ExceptionTypeListContext exceptionTypeList() {
			return getRuleContext(ExceptionTypeListContext.class,0);
		}
		public Throws_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throws_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterThrows_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitThrows_(this);
		}
	}

	public final Throws_Context throws_() throws RecognitionException {
		Throws_Context _localctx = new Throws_Context(_ctx, getState());
		enterRule(_localctx, 130, RULE_throws_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(954);
			match(THROWS);
			setState(955);
			exceptionTypeList();
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
	public static class ExceptionTypeListContext extends ParserRuleContext {
		public List<ExceptionTypeContext> exceptionType() {
			return getRuleContexts(ExceptionTypeContext.class);
		}
		public ExceptionTypeContext exceptionType(int i) {
			return getRuleContext(ExceptionTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public ExceptionTypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionTypeList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExceptionTypeList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExceptionTypeList(this);
		}
	}

	public final ExceptionTypeListContext exceptionTypeList() throws RecognitionException {
		ExceptionTypeListContext _localctx = new ExceptionTypeListContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_exceptionTypeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(957);
			exceptionType();
			setState(962);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(958);
				match(COMMA);
				setState(959);
				exceptionType();
				}
				}
				setState(964);
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
	public static class ExceptionTypeContext extends ParserRuleContext {
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TypeVariableContext typeVariable() {
			return getRuleContext(TypeVariableContext.class,0);
		}
		public ExceptionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exceptionType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExceptionType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExceptionType(this);
		}
	}

	public final ExceptionTypeContext exceptionType() throws RecognitionException {
		ExceptionTypeContext _localctx = new ExceptionTypeContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_exceptionType);
		try {
			setState(967);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,82,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(965);
				classType(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(966);
				typeVariable();
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
	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodBody(this);
		}
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_methodBody);
		try {
			setState(971);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(969);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(970);
				match(SEMI);
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
	public static class InstanceInitializerContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public InstanceInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_instanceInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterInstanceInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitInstanceInitializer(this);
		}
	}

	public final InstanceInitializerContext instanceInitializer() throws RecognitionException {
		InstanceInitializerContext _localctx = new InstanceInitializerContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_instanceInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(973);
			block();
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
	public static class StaticInitializerContext extends ParserRuleContext {
		public TerminalNode STATIC() { return getToken(Ninja9Parser.STATIC, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StaticInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_staticInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStaticInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStaticInitializer(this);
		}
	}

	public final StaticInitializerContext staticInitializer() throws RecognitionException {
		StaticInitializerContext _localctx = new StaticInitializerContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_staticInitializer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(975);
			match(STATIC);
			setState(976);
			block();
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
	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public ConstructorDeclaratorContext constructorDeclarator() {
			return getRuleContext(ConstructorDeclaratorContext.class,0);
		}
		public ConstructorBodyContext constructorBody() {
			return getRuleContext(ConstructorBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public Throws_Context throws_() {
			return getRuleContext(Throws_Context.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterConstructorDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitConstructorDeclaration(this);
		}
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(981);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(978);
				annotation();
				}
				}
				setState(983);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(987);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(984);
				modifier();
				}
				}
				setState(989);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(990);
			constructorDeclarator();
			setState(992);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(991);
				throws_();
				}
			}

			setState(994);
			constructorBody();
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
	public static class ConstructorDeclaratorContext extends ParserRuleContext {
		public SimpleTypeNameContext simpleTypeName() {
			return getRuleContext(SimpleTypeNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public ConstructorDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterConstructorDeclarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitConstructorDeclarator(this);
		}
	}

	public final ConstructorDeclaratorContext constructorDeclarator() throws RecognitionException {
		ConstructorDeclaratorContext _localctx = new ConstructorDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_constructorDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(996);
				typeParameters();
				}
			}

			setState(999);
			simpleTypeName();
			setState(1000);
			match(LPAREN);
			setState(1002);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5109925539875152L) != 0) || _la==Identifier || _la==AT) {
				{
				setState(1001);
				formalParameterList();
				}
			}

			setState(1004);
			match(RPAREN);
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
	public static class SimpleTypeNameContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public SimpleTypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleTypeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSimpleTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSimpleTypeName(this);
		}
	}

	public final SimpleTypeNameContext simpleTypeName() throws RecognitionException {
		SimpleTypeNameContext _localctx = new SimpleTypeNameContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_simpleTypeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1006);
			match(Identifier);
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
	public static class ConstructorBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public ExplicitConstructorInvocationContext explicitConstructorInvocation() {
			return getRuleContext(ExplicitConstructorInvocationContext.class,0);
		}
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public ConstructorBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterConstructorBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitConstructorBody(this);
		}
	}

	public final ConstructorBodyContext constructorBody() throws RecognitionException {
		ConstructorBodyContext _localctx = new ConstructorBodyContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_constructorBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1008);
			match(LBRACE);
			setState(1010);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,89,_ctx) ) {
			case 1:
				{
				setState(1009);
				explicitConstructorInvocation();
				}
				break;
			}
			setState(1013);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6917247515144444400L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267638305L) != 0)) {
				{
				setState(1012);
				blockStatements();
				}
			}

			setState(1015);
			match(RBRACE);
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
	public static class ExplicitConstructorInvocationContext extends ParserRuleContext {
		public TerminalNode THIS() { return getToken(Ninja9Parser.THIS, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExplicitConstructorInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitConstructorInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExplicitConstructorInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExplicitConstructorInvocation(this);
		}
	}

	public final ExplicitConstructorInvocationContext explicitConstructorInvocation() throws RecognitionException {
		ExplicitConstructorInvocationContext _localctx = new ExplicitConstructorInvocationContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_explicitConstructorInvocation);
		int _la;
		try {
			setState(1063);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1018);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1017);
					typeArguments();
					}
				}

				setState(1020);
				match(THIS);
				setState(1021);
				match(LPAREN);
				setState(1023);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(1022);
					argumentList();
					}
				}

				setState(1025);
				match(RPAREN);
				setState(1026);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1028);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1027);
					typeArguments();
					}
				}

				setState(1030);
				match(SUPER);
				setState(1031);
				match(LPAREN);
				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(1032);
					argumentList();
					}
				}

				setState(1035);
				match(RPAREN);
				setState(1036);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1037);
				expressionName();
				setState(1038);
				match(DOT);
				setState(1040);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1039);
					typeArguments();
					}
				}

				setState(1042);
				match(SUPER);
				setState(1043);
				match(LPAREN);
				setState(1045);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(1044);
					argumentList();
					}
				}

				setState(1047);
				match(RPAREN);
				setState(1048);
				match(SEMI);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1050);
				primary();
				setState(1051);
				match(DOT);
				setState(1053);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1052);
					typeArguments();
					}
				}

				setState(1055);
				match(SUPER);
				setState(1056);
				match(LPAREN);
				setState(1058);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(1057);
					argumentList();
					}
				}

				setState(1060);
				match(RPAREN);
				setState(1061);
				match(SEMI);
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
	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(Ninja9Parser.ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public EnumBodyContext enumBody() {
			return getRuleContext(EnumBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public SuperinterfacesContext superinterfaces() {
			return getRuleContext(SuperinterfacesContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEnumDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEnumDeclaration(this);
		}
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1068);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1065);
				annotation();
				}
				}
				setState(1070);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1074);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1071);
				modifier();
				}
				}
				setState(1076);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1077);
			match(ENUM);
			setState(1078);
			identifier();
			setState(1080);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(1079);
				superinterfaces();
				}
			}

			setState(1082);
			enumBody();
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
	public static class EnumBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public EnumConstantListContext enumConstantList() {
			return getRuleContext(EnumConstantListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Ninja9Parser.COMMA, 0); }
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEnumBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEnumBody(this);
		}
	}

	public final EnumBodyContext enumBody() throws RecognitionException {
		EnumBodyContext _localctx = new EnumBodyContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_enumBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1084);
			match(LBRACE);
			setState(1086);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier || _la==AT) {
				{
				setState(1085);
				enumConstantList();
				}
			}

			setState(1089);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1088);
				match(COMMA);
				}
			}

			setState(1092);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1091);
				enumBodyDeclarations();
				}
			}

			setState(1094);
			match(RBRACE);
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
	public static class EnumConstantListContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public EnumConstantListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstantList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEnumConstantList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEnumConstantList(this);
		}
	}

	public final EnumConstantListContext enumConstantList() throws RecognitionException {
		EnumConstantListContext _localctx = new EnumConstantListContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_enumConstantList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1096);
			enumConstant();
			setState(1101);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1097);
					match(COMMA);
					setState(1098);
					enumConstant();
					}
					} 
				}
				setState(1103);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,106,_ctx);
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
	public static class EnumConstantContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEnumConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEnumConstant(this);
		}
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_enumConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1107);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1104);
				annotation();
				}
				}
				setState(1109);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1110);
			identifier();
			setState(1116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(1111);
				match(LPAREN);
				setState(1113);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(1112);
					argumentList();
					}
				}

				setState(1115);
				match(RPAREN);
				}
			}

			setState(1119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(1118);
				classBody();
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
	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEnumBodyDeclarations(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEnumBodyDeclarations(this);
		}
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1121);
			match(SEMI);
			setState(1125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 4619047745928436048L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267441697L) != 0)) {
				{
				{
				setState(1122);
				classBodyDeclaration();
				}
				}
				setState(1127);
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
	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public NormalInterfaceDeclarationContext normalInterfaceDeclaration() {
			return getRuleContext(NormalInterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitInterfaceDeclaration(this);
		}
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_interfaceDeclaration);
		try {
			setState(1130);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1128);
				normalInterfaceDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1129);
				annotationTypeDeclaration();
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
	public static class NormalInterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(Ninja9Parser.INTERFACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ExtendsInterfacesContext extendsInterfaces() {
			return getRuleContext(ExtendsInterfacesContext.class,0);
		}
		public NormalInterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalInterfaceDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterNormalInterfaceDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitNormalInterfaceDeclaration(this);
		}
	}

	public final NormalInterfaceDeclarationContext normalInterfaceDeclaration() throws RecognitionException {
		NormalInterfaceDeclarationContext _localctx = new NormalInterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_normalInterfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1135);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1132);
				annotation();
				}
				}
				setState(1137);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1138);
				modifier();
				}
				}
				setState(1143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1144);
			match(INTERFACE);
			setState(1145);
			identifier();
			setState(1147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1146);
				typeParameters();
				}
			}

			setState(1150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(1149);
				extendsInterfaces();
				}
			}

			setState(1152);
			interfaceBody();
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
	public static class ExtendsInterfacesContext extends ParserRuleContext {
		public TerminalNode EXTENDS() { return getToken(Ninja9Parser.EXTENDS, 0); }
		public InterfaceTypeListContext interfaceTypeList() {
			return getRuleContext(InterfaceTypeListContext.class,0);
		}
		public ExtendsInterfacesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_extendsInterfaces; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExtendsInterfaces(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExtendsInterfaces(this);
		}
	}

	public final ExtendsInterfacesContext extendsInterfaces() throws RecognitionException {
		ExtendsInterfacesContext _localctx = new ExtendsInterfacesContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_extendsInterfaces);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1154);
			match(EXTENDS);
			setState(1155);
			interfaceTypeList();
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
	public static class InterfaceBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public List<InterfaceMemberDeclarationContext> interfaceMemberDeclaration() {
			return getRuleContexts(InterfaceMemberDeclarationContext.class);
		}
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration(int i) {
			return getRuleContext(InterfaceMemberDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterInterfaceBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitInterfaceBody(this);
		}
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1157);
			match(LBRACE);
			setState(1161);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 7361727501080912L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267441697L) != 0)) {
				{
				{
				setState(1158);
				interfaceMemberDeclaration();
				}
				}
				setState(1163);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1164);
			match(RBRACE);
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
	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterInterfaceMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitInterfaceMemberDeclaration(this);
		}
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_interfaceMemberDeclaration);
		try {
			setState(1171);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1166);
				constantDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1167);
				interfaceMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1168);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1169);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1170);
				emptyStatement();
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
	public static class ConstantDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ConstantDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterConstantDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitConstantDeclaration(this);
		}
	}

	public final ConstantDeclarationContext constantDeclaration() throws RecognitionException {
		ConstantDeclarationContext _localctx = new ConstantDeclarationContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_constantDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1173);
				annotation();
				}
				}
				setState(1178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1179);
				modifier();
				}
				}
				setState(1184);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1185);
			unannType();
			setState(1186);
			variableDeclaratorList();
			setState(1187);
			match(SEMI);
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
	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public MethodHeaderContext methodHeader() {
			return getRuleContext(MethodHeaderContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TerminalNode DEFAULT() { return getToken(Ninja9Parser.DEFAULT, 0); }
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterInterfaceMethodDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitInterfaceMethodDeclaration(this);
		}
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_interfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1192);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1189);
				annotation();
				}
				}
				setState(1194);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1195);
				modifier();
				}
				}
				setState(1200);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1201);
				match(DEFAULT);
				}
			}

			setState(1204);
			methodHeader();
			setState(1205);
			methodBody();
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
	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Ninja9Parser.AT, 0); }
		public TerminalNode INTERFACE() { return getToken(Ninja9Parser.INTERFACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAnnotationTypeDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAnnotationTypeDeclaration(this);
		}
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_annotationTypeDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1210);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1207);
					annotation();
					}
					} 
				}
				setState(1212);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(1216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1213);
				modifier();
				}
				}
				setState(1218);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1219);
			match(AT);
			setState(1220);
			match(INTERFACE);
			setState(1221);
			identifier();
			setState(1222);
			annotationTypeBody();
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
	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public List<AnnotationTypeMemberDeclarationContext> annotationTypeMemberDeclaration() {
			return getRuleContexts(AnnotationTypeMemberDeclarationContext.class);
		}
		public AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration(int i) {
			return getRuleContext(AnnotationTypeMemberDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAnnotationTypeBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAnnotationTypeBody(this);
		}
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1224);
			match(LBRACE);
			setState(1228);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5109927687362896L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267441665L) != 0)) {
				{
				{
				setState(1225);
				annotationTypeMemberDeclaration();
				}
				}
				setState(1230);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1231);
			match(RBRACE);
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
	public static class AnnotationTypeMemberDeclarationContext extends ParserRuleContext {
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,0);
		}
		public ConstantDeclarationContext constantDeclaration() {
			return getRuleContext(ConstantDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public AnnotationTypeMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeMemberDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAnnotationTypeMemberDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAnnotationTypeMemberDeclaration(this);
		}
	}

	public final AnnotationTypeMemberDeclarationContext annotationTypeMemberDeclaration() throws RecognitionException {
		AnnotationTypeMemberDeclarationContext _localctx = new AnnotationTypeMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_annotationTypeMemberDeclaration);
		try {
			setState(1238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,127,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1233);
				annotationTypeElementDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1234);
				constantDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1235);
				classDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1236);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1237);
				match(SEMI);
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
	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public List<ArrayDimensionContext> arrayDimension() {
			return getRuleContexts(ArrayDimensionContext.class);
		}
		public ArrayDimensionContext arrayDimension(int i) {
			return getRuleContext(ArrayDimensionContext.class,i);
		}
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAnnotationTypeElementDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAnnotationTypeElementDeclaration(this);
		}
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_annotationTypeElementDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1240);
				annotation();
				}
				}
				setState(1245);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1246);
				modifier();
				}
				}
				setState(1251);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1252);
			unannType();
			setState(1253);
			identifier();
			setState(1254);
			match(LPAREN);
			setState(1255);
			match(RPAREN);
			setState(1259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(1256);
				arrayDimension();
				}
				}
				setState(1261);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1262);
				defaultValue();
				}
			}

			setState(1265);
			match(SEMI);
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
	public static class DefaultValueContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(Ninja9Parser.DEFAULT, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitDefaultValue(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1267);
			match(DEFAULT);
			setState(1268);
			elementValue();
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
	public static class AnnotationContext extends ParserRuleContext {
		public NormalAnnotationContext normalAnnotation() {
			return getRuleContext(NormalAnnotationContext.class,0);
		}
		public MarkerAnnotationContext markerAnnotation() {
			return getRuleContext(MarkerAnnotationContext.class,0);
		}
		public SingleElementAnnotationContext singleElementAnnotation() {
			return getRuleContext(SingleElementAnnotationContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_annotation);
		try {
			setState(1273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,132,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1270);
				normalAnnotation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1271);
				markerAnnotation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1272);
				singleElementAnnotation();
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
	public static class NormalAnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Ninja9Parser.AT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public ElementValuePairListContext elementValuePairList() {
			return getRuleContext(ElementValuePairListContext.class,0);
		}
		public NormalAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normalAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterNormalAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitNormalAnnotation(this);
		}
	}

	public final NormalAnnotationContext normalAnnotation() throws RecognitionException {
		NormalAnnotationContext _localctx = new NormalAnnotationContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_normalAnnotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1275);
			match(AT);
			setState(1276);
			typeName();
			setState(1277);
			match(LPAREN);
			setState(1279);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1278);
				elementValuePairList();
				}
			}

			setState(1281);
			match(RPAREN);
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
	public static class ElementValuePairListContext extends ParserRuleContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public ElementValuePairListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterElementValuePairList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitElementValuePairList(this);
		}
	}

	public final ElementValuePairListContext elementValuePairList() throws RecognitionException {
		ElementValuePairListContext _localctx = new ElementValuePairListContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_elementValuePairList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1283);
			elementValuePair();
			setState(1288);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1284);
				match(COMMA);
				setState(1285);
				elementValuePair();
				}
				}
				setState(1290);
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
	public static class ElementValuePairContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Ninja9Parser.ASSIGN, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterElementValuePair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitElementValuePair(this);
		}
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1291);
			identifier();
			setState(1292);
			match(ASSIGN);
			setState(1293);
			elementValue();
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
	public static class ElementValueContext extends ParserRuleContext {
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
	 
		public ElementValueContext() { }
		public void copyFrom(ElementValueContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueAnnotationContext extends ElementValueContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueAnnotationContext(ElementValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterElementValueAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitElementValueAnnotation(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueExpressionContext extends ElementValueContext {
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ElementValueExpressionContext(ElementValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterElementValueExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitElementValueExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueArrayContext extends ElementValueContext {
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public ElementValueArrayContext(ElementValueContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterElementValueArray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitElementValueArray(this);
		}
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_elementValue);
		try {
			setState(1298);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
			case 1:
				_localctx = new ElementValueExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1295);
				conditionalExpression(0);
				}
				break;
			case 2:
				_localctx = new ElementValueArrayContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1296);
				elementValueArrayInitializer();
				}
				break;
			case 3:
				_localctx = new ElementValueAnnotationContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(1297);
				annotation();
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
	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public ElementValueListContext elementValueList() {
			return getRuleContext(ElementValueListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Ninja9Parser.COMMA, 0); }
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterElementValueArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitElementValueArrayInitializer(this);
		}
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_elementValueArrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1300);
			match(LBRACE);
			setState(1302);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6901846715851213120L) != 0) || ((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 25769819139L) != 0)) {
				{
				setState(1301);
				elementValueList();
				}
			}

			setState(1305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1304);
				match(COMMA);
				}
			}

			setState(1307);
			match(RBRACE);
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
	public static class ElementValueListContext extends ParserRuleContext {
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public ElementValueListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterElementValueList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitElementValueList(this);
		}
	}

	public final ElementValueListContext elementValueList() throws RecognitionException {
		ElementValueListContext _localctx = new ElementValueListContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_elementValueList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1309);
			elementValue();
			setState(1314);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1310);
					match(COMMA);
					setState(1311);
					elementValue();
					}
					} 
				}
				setState(1316);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,138,_ctx);
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
	public static class MarkerAnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Ninja9Parser.AT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public MarkerAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_markerAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMarkerAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMarkerAnnotation(this);
		}
	}

	public final MarkerAnnotationContext markerAnnotation() throws RecognitionException {
		MarkerAnnotationContext _localctx = new MarkerAnnotationContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_markerAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1317);
			match(AT);
			setState(1318);
			typeName();
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
	public static class SingleElementAnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(Ninja9Parser.AT, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public SingleElementAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleElementAnnotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSingleElementAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSingleElementAnnotation(this);
		}
	}

	public final SingleElementAnnotationContext singleElementAnnotation() throws RecognitionException {
		SingleElementAnnotationContext _localctx = new SingleElementAnnotationContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_singleElementAnnotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1320);
			match(AT);
			setState(1321);
			typeName();
			setState(1322);
			match(LPAREN);
			setState(1323);
			elementValue();
			setState(1324);
			match(RPAREN);
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
	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public VariableInitializerListContext variableInitializerList() {
			return getRuleContext(VariableInitializerListContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(Ninja9Parser.COMMA, 0); }
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayInitializer(this);
		}
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_arrayInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1326);
			match(LBRACE);
			setState(1328);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6901846715851213120L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(1327);
				variableInitializerList();
				}
			}

			setState(1331);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1330);
				match(COMMA);
				}
			}

			setState(1333);
			match(RBRACE);
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
	public static class VariableInitializerListContext extends ParserRuleContext {
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public VariableInitializerListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializerList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterVariableInitializerList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitVariableInitializerList(this);
		}
	}

	public final VariableInitializerListContext variableInitializerList() throws RecognitionException {
		VariableInitializerListContext _localctx = new VariableInitializerListContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_variableInitializerList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1335);
			variableInitializer();
			setState(1340);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1336);
					match(COMMA);
					setState(1337);
					variableInitializer();
					}
					} 
				}
				setState(1342);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,141,_ctx);
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBlock(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1343);
			match(LBRACE);
			setState(1347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6917247515144444400L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267638305L) != 0)) {
				{
				{
				setState(1344);
				blockStatement();
				}
				}
				setState(1349);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1350);
			match(RBRACE);
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
	public static class BlockStatementsContext extends ParserRuleContext {
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockStatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBlockStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBlockStatements(this);
		}
	}

	public final BlockStatementsContext blockStatements() throws RecognitionException {
		BlockStatementsContext _localctx = new BlockStatementsContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_blockStatements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1353); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1352);
				blockStatement();
				}
				}
				setState(1355); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 6917247515144444400L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267638305L) != 0) );
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
		public LocalVariableDeclarationStatementContext localVariableDeclarationStatement() {
			return getRuleContext(LocalVariableDeclarationStatementContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBlockStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBlockStatement(this);
		}
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_blockStatement);
		try {
			setState(1360);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,144,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1357);
				localVariableDeclarationStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1358);
				classDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1359);
				statement();
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
	public static class LocalVariableDeclarationStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public LocalVariableDeclarationStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclarationStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLocalVariableDeclarationStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLocalVariableDeclarationStatement(this);
		}
	}

	public final LocalVariableDeclarationStatementContext localVariableDeclarationStatement() throws RecognitionException {
		LocalVariableDeclarationStatementContext _localctx = new LocalVariableDeclarationStatementContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_localVariableDeclarationStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1362);
			localVariableDeclaration();
			setState(1363);
			match(SEMI);
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
	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorListContext variableDeclaratorList() {
			return getRuleContext(VariableDeclaratorListContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLocalVariableDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLocalVariableDeclaration(this);
		}
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_localVariableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1368);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1365);
				annotation();
				}
				}
				setState(1370);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1374);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1371);
				modifier();
				}
				}
				setState(1376);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1377);
			unannType();
			setState(1378);
			variableDeclaratorList();
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
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public LabeledStatementContext labeledStatement() {
			return getRuleContext(LabeledStatementContext.class,0);
		}
		public IfThenStatementContext ifThenStatement() {
			return getRuleContext(IfThenStatementContext.class,0);
		}
		public IfThenElseStatementContext ifThenElseStatement() {
			return getRuleContext(IfThenElseStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_statement);
		try {
			setState(1386);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,147,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1380);
				statementWithoutTrailingSubstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1381);
				labeledStatement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1382);
				ifThenStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1383);
				ifThenElseStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1384);
				whileStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1385);
				forStatement();
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
	public static class StatementNoShortIfContext extends ParserRuleContext {
		public StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() {
			return getRuleContext(StatementWithoutTrailingSubstatementContext.class,0);
		}
		public LabeledStatementNoShortIfContext labeledStatementNoShortIf() {
			return getRuleContext(LabeledStatementNoShortIfContext.class,0);
		}
		public IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() {
			return getRuleContext(IfThenElseStatementNoShortIfContext.class,0);
		}
		public WhileStatementNoShortIfContext whileStatementNoShortIf() {
			return getRuleContext(WhileStatementNoShortIfContext.class,0);
		}
		public ForStatementNoShortIfContext forStatementNoShortIf() {
			return getRuleContext(ForStatementNoShortIfContext.class,0);
		}
		public StatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementNoShortIf(this);
		}
	}

	public final StatementNoShortIfContext statementNoShortIf() throws RecognitionException {
		StatementNoShortIfContext _localctx = new StatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_statementNoShortIf);
		try {
			setState(1393);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1388);
				statementWithoutTrailingSubstatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1389);
				labeledStatementNoShortIf();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1390);
				ifThenElseStatementNoShortIf();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1391);
				whileStatementNoShortIf();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1392);
				forStatementNoShortIf();
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
	public static class StatementWithoutTrailingSubstatementContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public EmptyStatementContext emptyStatement() {
			return getRuleContext(EmptyStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public AssertStatementContext assertStatement() {
			return getRuleContext(AssertStatementContext.class,0);
		}
		public SwitchStatementContext switchStatement() {
			return getRuleContext(SwitchStatementContext.class,0);
		}
		public DoStatementContext doStatement() {
			return getRuleContext(DoStatementContext.class,0);
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
		public SynchronizedStatementContext synchronizedStatement() {
			return getRuleContext(SynchronizedStatementContext.class,0);
		}
		public ThrowStatementContext throwStatement() {
			return getRuleContext(ThrowStatementContext.class,0);
		}
		public TryStatementContext tryStatement() {
			return getRuleContext(TryStatementContext.class,0);
		}
		public StatementWithoutTrailingSubstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementWithoutTrailingSubstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementWithoutTrailingSubstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementWithoutTrailingSubstatement(this);
		}
	}

	public final StatementWithoutTrailingSubstatementContext statementWithoutTrailingSubstatement() throws RecognitionException {
		StatementWithoutTrailingSubstatementContext _localctx = new StatementWithoutTrailingSubstatementContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_statementWithoutTrailingSubstatement);
		try {
			setState(1407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1395);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(1396);
				emptyStatement();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case INC:
			case DEC:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 3);
				{
				setState(1397);
				expressionStatement();
				}
				break;
			case ASSERT:
				enterOuterAlt(_localctx, 4);
				{
				setState(1398);
				assertStatement();
				}
				break;
			case SWITCH:
				enterOuterAlt(_localctx, 5);
				{
				setState(1399);
				switchStatement();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 6);
				{
				setState(1400);
				doStatement();
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 7);
				{
				setState(1401);
				breakStatement();
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 8);
				{
				setState(1402);
				continueStatement();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 9);
				{
				setState(1403);
				returnStatement();
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 10);
				{
				setState(1404);
				synchronizedStatement();
				}
				break;
			case THROW:
				enterOuterAlt(_localctx, 11);
				{
				setState(1405);
				throwStatement();
				}
				break;
			case TRY:
				enterOuterAlt(_localctx, 12);
				{
				setState(1406);
				tryStatement();
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
	public static class EmptyStatementContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public EmptyStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_emptyStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEmptyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEmptyStatement(this);
		}
	}

	public final EmptyStatementContext emptyStatement() throws RecognitionException {
		EmptyStatementContext _localctx = new EmptyStatementContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_emptyStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1409);
			match(SEMI);
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
	public static class LabeledStatementContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public LabeledStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLabeledStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLabeledStatement(this);
		}
	}

	public final LabeledStatementContext labeledStatement() throws RecognitionException {
		LabeledStatementContext _localctx = new LabeledStatementContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_labeledStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1411);
			identifier();
			setState(1412);
			match(COLON);
			setState(1413);
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
	public static class LabeledStatementNoShortIfContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public LabeledStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_labeledStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLabeledStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLabeledStatementNoShortIf(this);
		}
	}

	public final LabeledStatementNoShortIfContext labeledStatementNoShortIf() throws RecognitionException {
		LabeledStatementNoShortIfContext _localctx = new LabeledStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_labeledStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1415);
			identifier();
			setState(1416);
			match(COLON);
			setState(1417);
			statementNoShortIf();
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
		public StatementExpressionContext statementExpression() {
			return getRuleContext(StatementExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExpressionStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExpressionStatement(this);
		}
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1419);
			statementExpression();
			setState(1420);
			match(SEMI);
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
	public static class StatementExpressionContext extends ParserRuleContext {
		public StatementAssignment_nocolContext statementAssignment_nocol() {
			return getRuleContext(StatementAssignment_nocolContext.class,0);
		}
		public StatementPre_nocolContext statementPre_nocol() {
			return getRuleContext(StatementPre_nocolContext.class,0);
		}
		public StatementPost_nocolContext statementPost_nocol() {
			return getRuleContext(StatementPost_nocolContext.class,0);
		}
		public StatementMethodInvocation_nocolContext statementMethodInvocation_nocol() {
			return getRuleContext(StatementMethodInvocation_nocolContext.class,0);
		}
		public StatementClassInstanceCreation_nocolContext statementClassInstanceCreation_nocol() {
			return getRuleContext(StatementClassInstanceCreation_nocolContext.class,0);
		}
		public StatementExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementExpression(this);
		}
	}

	public final StatementExpressionContext statementExpression() throws RecognitionException {
		StatementExpressionContext _localctx = new StatementExpressionContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_statementExpression);
		try {
			setState(1427);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,150,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1422);
				statementAssignment_nocol();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1423);
				statementPre_nocol();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1424);
				statementPost_nocol();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1425);
				statementMethodInvocation_nocol();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1426);
				statementClassInstanceCreation_nocol();
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
	public static class StatementAssignment_nocolContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public StatementAssignment_nocolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementAssignment_nocol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementAssignment_nocol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementAssignment_nocol(this);
		}
	}

	public final StatementAssignment_nocolContext statementAssignment_nocol() throws RecognitionException {
		StatementAssignment_nocolContext _localctx = new StatementAssignment_nocolContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_statementAssignment_nocol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1429);
			assignment();
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
	public static class StatementPre_nocolContext extends ParserRuleContext {
		public PreExpressionContext preExpression() {
			return getRuleContext(PreExpressionContext.class,0);
		}
		public StatementPre_nocolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementPre_nocol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementPre_nocol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementPre_nocol(this);
		}
	}

	public final StatementPre_nocolContext statementPre_nocol() throws RecognitionException {
		StatementPre_nocolContext _localctx = new StatementPre_nocolContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_statementPre_nocol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1431);
			preExpression();
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
	public static class StatementPost_nocolContext extends ParserRuleContext {
		public PostExpressionContext postExpression() {
			return getRuleContext(PostExpressionContext.class,0);
		}
		public StatementPost_nocolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementPost_nocol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementPost_nocol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementPost_nocol(this);
		}
	}

	public final StatementPost_nocolContext statementPost_nocol() throws RecognitionException {
		StatementPost_nocolContext _localctx = new StatementPost_nocolContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_statementPost_nocol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1433);
			postExpression();
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
	public static class StatementMethodInvocation_nocolContext extends ParserRuleContext {
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public StatementMethodInvocation_nocolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementMethodInvocation_nocol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementMethodInvocation_nocol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementMethodInvocation_nocol(this);
		}
	}

	public final StatementMethodInvocation_nocolContext statementMethodInvocation_nocol() throws RecognitionException {
		StatementMethodInvocation_nocolContext _localctx = new StatementMethodInvocation_nocolContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_statementMethodInvocation_nocol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1435);
			methodInvocation();
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
	public static class StatementClassInstanceCreation_nocolContext extends ParserRuleContext {
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public StatementClassInstanceCreation_nocolContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementClassInstanceCreation_nocol; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementClassInstanceCreation_nocol(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementClassInstanceCreation_nocol(this);
		}
	}

	public final StatementClassInstanceCreation_nocolContext statementClassInstanceCreation_nocol() throws RecognitionException {
		StatementClassInstanceCreation_nocolContext _localctx = new StatementClassInstanceCreation_nocolContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_statementClassInstanceCreation_nocol);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1437);
			classInstanceCreationExpression();
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
	public static class IfThenStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Ninja9Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfThenStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIfThenStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIfThenStatement(this);
		}
	}

	public final IfThenStatementContext ifThenStatement() throws RecognitionException {
		IfThenStatementContext _localctx = new IfThenStatementContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_ifThenStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1439);
			match(IF);
			setState(1440);
			match(LPAREN);
			setState(1441);
			expression();
			setState(1442);
			match(RPAREN);
			setState(1443);
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
	public static class IfThenElseStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Ninja9Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(Ninja9Parser.ELSE, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public IfThenElseStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIfThenElseStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIfThenElseStatement(this);
		}
	}

	public final IfThenElseStatementContext ifThenElseStatement() throws RecognitionException {
		IfThenElseStatementContext _localctx = new IfThenElseStatementContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_ifThenElseStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1445);
			match(IF);
			setState(1446);
			match(LPAREN);
			setState(1447);
			expression();
			setState(1448);
			match(RPAREN);
			setState(1449);
			statementNoShortIf();
			setState(1450);
			match(ELSE);
			setState(1451);
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
	public static class IfThenElseStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(Ninja9Parser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public List<StatementNoShortIfContext> statementNoShortIf() {
			return getRuleContexts(StatementNoShortIfContext.class);
		}
		public StatementNoShortIfContext statementNoShortIf(int i) {
			return getRuleContext(StatementNoShortIfContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(Ninja9Parser.ELSE, 0); }
		public IfThenElseStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifThenElseStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIfThenElseStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIfThenElseStatementNoShortIf(this);
		}
	}

	public final IfThenElseStatementNoShortIfContext ifThenElseStatementNoShortIf() throws RecognitionException {
		IfThenElseStatementNoShortIfContext _localctx = new IfThenElseStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_ifThenElseStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1453);
			match(IF);
			setState(1454);
			match(LPAREN);
			setState(1455);
			expression();
			setState(1456);
			match(RPAREN);
			setState(1457);
			statementNoShortIf();
			setState(1458);
			match(ELSE);
			setState(1459);
			statementNoShortIf();
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
	public static class AssertStatementContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(Ninja9Parser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public AssertStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assertStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAssertStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAssertStatement(this);
		}
	}

	public final AssertStatementContext assertStatement() throws RecognitionException {
		AssertStatementContext _localctx = new AssertStatementContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_assertStatement);
		try {
			setState(1471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1461);
				match(ASSERT);
				setState(1462);
				expression();
				setState(1463);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1465);
				match(ASSERT);
				setState(1466);
				expression();
				setState(1467);
				match(COLON);
				setState(1468);
				expression();
				setState(1469);
				match(SEMI);
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
	public static class SwitchStatementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(Ninja9Parser.SWITCH, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public SwitchBlockContext switchBlock() {
			return getRuleContext(SwitchBlockContext.class,0);
		}
		public SwitchStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSwitchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSwitchStatement(this);
		}
	}

	public final SwitchStatementContext switchStatement() throws RecognitionException {
		SwitchStatementContext _localctx = new SwitchStatementContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_switchStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1473);
			match(SWITCH);
			setState(1474);
			match(LPAREN);
			setState(1475);
			expression();
			setState(1476);
			match(RPAREN);
			setState(1477);
			switchBlock();
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
		public TerminalNode LBRACE() { return getToken(Ninja9Parser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(Ninja9Parser.RBRACE, 0); }
		public List<SwitchCaseContext> switchCase() {
			return getRuleContexts(SwitchCaseContext.class);
		}
		public SwitchCaseContext switchCase(int i) {
			return getRuleContext(SwitchCaseContext.class,i);
		}
		public DefaultSwitchCaseContext defaultSwitchCase() {
			return getRuleContext(DefaultSwitchCaseContext.class,0);
		}
		public SwitchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSwitchBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSwitchBlock(this);
		}
	}

	public final SwitchBlockContext switchBlock() throws RecognitionException {
		SwitchBlockContext _localctx = new SwitchBlockContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_switchBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1479);
			match(LBRACE);
			setState(1483);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE) {
				{
				{
				setState(1480);
				switchCase();
				}
				}
				setState(1485);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1487);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(1486);
				defaultSwitchCase();
				}
			}

			setState(1489);
			match(RBRACE);
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
	public static class SwitchCaseContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(Ninja9Parser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public SwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSwitchCase(this);
		}
	}

	public final SwitchCaseContext switchCase() throws RecognitionException {
		SwitchCaseContext _localctx = new SwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_switchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1491);
			match(CASE);
			setState(1492);
			expression();
			setState(1493);
			match(COLON);
			setState(1495);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6917247515144444400L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267638305L) != 0)) {
				{
				setState(1494);
				blockStatements();
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
	public static class DefaultSwitchCaseContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(Ninja9Parser.DEFAULT, 0); }
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public BlockStatementsContext blockStatements() {
			return getRuleContext(BlockStatementsContext.class,0);
		}
		public DefaultSwitchCaseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultSwitchCase; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterDefaultSwitchCase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitDefaultSwitchCase(this);
		}
	}

	public final DefaultSwitchCaseContext defaultSwitchCase() throws RecognitionException {
		DefaultSwitchCaseContext _localctx = new DefaultSwitchCaseContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_defaultSwitchCase);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1497);
			match(DEFAULT);
			setState(1498);
			match(COLON);
			setState(1500);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 6917247515144444400L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 1649267638305L) != 0)) {
				{
				setState(1499);
				blockStatements();
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
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Ninja9Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterWhileStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitWhileStatement(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1502);
			match(WHILE);
			setState(1503);
			match(LPAREN);
			setState(1504);
			expression();
			setState(1505);
			match(RPAREN);
			setState(1506);
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
	public static class WhileStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(Ninja9Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public WhileStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterWhileStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitWhileStatementNoShortIf(this);
		}
	}

	public final WhileStatementNoShortIfContext whileStatementNoShortIf() throws RecognitionException {
		WhileStatementNoShortIfContext _localctx = new WhileStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_whileStatementNoShortIf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1508);
			match(WHILE);
			setState(1509);
			match(LPAREN);
			setState(1510);
			expression();
			setState(1511);
			match(RPAREN);
			setState(1512);
			statementNoShortIf();
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
	public static class DoStatementContext extends ParserRuleContext {
		public TerminalNode DO() { return getToken(Ninja9Parser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public TerminalNode WHILE() { return getToken(Ninja9Parser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public DoStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_doStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterDoStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitDoStatement(this);
		}
	}

	public final DoStatementContext doStatement() throws RecognitionException {
		DoStatementContext _localctx = new DoStatementContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_doStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1514);
			match(DO);
			setState(1515);
			statement();
			setState(1516);
			match(WHILE);
			setState(1517);
			match(LPAREN);
			setState(1518);
			expression();
			setState(1519);
			match(RPAREN);
			setState(1520);
			match(SEMI);
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
		public BasicForStatementContext basicForStatement() {
			return getRuleContext(BasicForStatementContext.class,0);
		}
		public EnhancedForStatementContext enhancedForStatement() {
			return getRuleContext(EnhancedForStatementContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitForStatement(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_forStatement);
		try {
			setState(1524);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1522);
				basicForStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1523);
				enhancedForStatement();
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
	public static class ForStatementNoShortIfContext extends ParserRuleContext {
		public BasicForStatementNoShortIfContext basicForStatementNoShortIf() {
			return getRuleContext(BasicForStatementNoShortIfContext.class,0);
		}
		public EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() {
			return getRuleContext(EnhancedForStatementNoShortIfContext.class,0);
		}
		public ForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitForStatementNoShortIf(this);
		}
	}

	public final ForStatementNoShortIfContext forStatementNoShortIf() throws RecognitionException {
		ForStatementNoShortIfContext _localctx = new ForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_forStatementNoShortIf);
		try {
			setState(1528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1526);
				basicForStatementNoShortIf();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1527);
				enhancedForStatementNoShortIf();
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
	public static class BasicForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Ninja9Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Ninja9Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Ninja9Parser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public BasicForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBasicForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBasicForStatement(this);
		}
	}

	public final BasicForStatementContext basicForStatement() throws RecognitionException {
		BasicForStatementContext _localctx = new BasicForStatementContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_basicForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1530);
			match(FOR);
			setState(1531);
			match(LPAREN);
			setState(1533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2295269518074841424L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539613697L) != 0)) {
				{
				setState(1532);
				forInit();
				}
			}

			setState(1535);
			match(SEMI);
			setState(1537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(1536);
				expression();
				}
			}

			setState(1539);
			match(SEMI);
			setState(1541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539613697L) != 0)) {
				{
				setState(1540);
				forUpdate();
				}
			}

			setState(1543);
			match(RPAREN);
			setState(1544);
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
	public static class BasicForStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Ninja9Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public List<TerminalNode> SEMI() { return getTokens(Ninja9Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Ninja9Parser.SEMI, i);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ForUpdateContext forUpdate() {
			return getRuleContext(ForUpdateContext.class,0);
		}
		public BasicForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBasicForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBasicForStatementNoShortIf(this);
		}
	}

	public final BasicForStatementNoShortIfContext basicForStatementNoShortIf() throws RecognitionException {
		BasicForStatementNoShortIfContext _localctx = new BasicForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_basicForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1546);
			match(FOR);
			setState(1547);
			match(LPAREN);
			setState(1549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2295269518074841424L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539613697L) != 0)) {
				{
				setState(1548);
				forInit();
				}
			}

			setState(1551);
			match(SEMI);
			setState(1553);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(1552);
				expression();
				}
			}

			setState(1555);
			match(SEMI);
			setState(1557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539613697L) != 0)) {
				{
				setState(1556);
				forUpdate();
				}
			}

			setState(1559);
			match(RPAREN);
			setState(1560);
			statementNoShortIf();
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
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
		}
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterForInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitForInit(this);
		}
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_forInit);
		try {
			setState(1564);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,164,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1562);
				statementExpressionList();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1563);
				localVariableDeclaration();
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
	public static class ForUpdateContext extends ParserRuleContext {
		public StatementExpressionListContext statementExpressionList() {
			return getRuleContext(StatementExpressionListContext.class,0);
		}
		public ForUpdateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forUpdate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterForUpdate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitForUpdate(this);
		}
	}

	public final ForUpdateContext forUpdate() throws RecognitionException {
		ForUpdateContext _localctx = new ForUpdateContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_forUpdate);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1566);
			statementExpressionList();
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
	public static class StatementExpressionListContext extends ParserRuleContext {
		public List<StatementExpressionContext> statementExpression() {
			return getRuleContexts(StatementExpressionContext.class);
		}
		public StatementExpressionContext statementExpression(int i) {
			return getRuleContext(StatementExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public StatementExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statementExpressionList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterStatementExpressionList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitStatementExpressionList(this);
		}
	}

	public final StatementExpressionListContext statementExpressionList() throws RecognitionException {
		StatementExpressionListContext _localctx = new StatementExpressionListContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_statementExpressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1568);
			statementExpression();
			setState(1573);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1569);
				match(COMMA);
				setState(1570);
				statementExpression();
				}
				}
				setState(1575);
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
	public static class EnhancedForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Ninja9Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public EnhancedForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEnhancedForStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEnhancedForStatement(this);
		}
	}

	public final EnhancedForStatementContext enhancedForStatement() throws RecognitionException {
		EnhancedForStatementContext _localctx = new EnhancedForStatementContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_enhancedForStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1576);
			match(FOR);
			setState(1577);
			match(LPAREN);
			setState(1581);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1578);
				modifier();
				}
				}
				setState(1583);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1584);
			unannType();
			setState(1585);
			variableDeclaratorId();
			setState(1586);
			match(COLON);
			setState(1587);
			expression();
			setState(1588);
			match(RPAREN);
			setState(1589);
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
	public static class EnhancedForStatementNoShortIfContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(Ninja9Parser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public StatementNoShortIfContext statementNoShortIf() {
			return getRuleContext(StatementNoShortIfContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public EnhancedForStatementNoShortIfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForStatementNoShortIf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterEnhancedForStatementNoShortIf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitEnhancedForStatementNoShortIf(this);
		}
	}

	public final EnhancedForStatementNoShortIfContext enhancedForStatementNoShortIf() throws RecognitionException {
		EnhancedForStatementNoShortIfContext _localctx = new EnhancedForStatementNoShortIfContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_enhancedForStatementNoShortIf);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1591);
			match(FOR);
			setState(1592);
			match(LPAREN);
			setState(1596);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1593);
				modifier();
				}
				}
				setState(1598);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1599);
			unannType();
			setState(1600);
			variableDeclaratorId();
			setState(1601);
			match(COLON);
			setState(1602);
			expression();
			setState(1603);
			match(RPAREN);
			setState(1604);
			statementNoShortIf();
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
		public TerminalNode BREAK() { return getToken(Ninja9Parser.BREAK, 0); }
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BreakStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_breakStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBreakStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBreakStatement(this);
		}
	}

	public final BreakStatementContext breakStatement() throws RecognitionException {
		BreakStatementContext _localctx = new BreakStatementContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_breakStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1606);
			match(BREAK);
			setState(1608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1607);
				identifier();
				}
			}

			setState(1610);
			match(SEMI);
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
		public TerminalNode CONTINUE() { return getToken(Ninja9Parser.CONTINUE, 0); }
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ContinueStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_continueStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterContinueStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitContinueStatement(this);
		}
	}

	public final ContinueStatementContext continueStatement() throws RecognitionException {
		ContinueStatementContext _localctx = new ContinueStatementContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_continueStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1612);
			match(CONTINUE);
			setState(1614);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Identifier) {
				{
				setState(1613);
				identifier();
				}
			}

			setState(1616);
			match(SEMI);
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
		public TerminalNode RETURN() { return getToken(Ninja9Parser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterReturnStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitReturnStatement(this);
		}
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1618);
			match(RETURN);
			setState(1620);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(1619);
				expression();
				}
			}

			setState(1622);
			match(SEMI);
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
		public TerminalNode THROW() { return getToken(Ninja9Parser.THROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public ThrowStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_throwStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterThrowStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitThrowStatement(this);
		}
	}

	public final ThrowStatementContext throwStatement() throws RecognitionException {
		ThrowStatementContext _localctx = new ThrowStatementContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_throwStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1624);
			match(THROW);
			setState(1625);
			expression();
			setState(1626);
			match(SEMI);
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
	public static class SynchronizedStatementContext extends ParserRuleContext {
		public TerminalNode SYNCHRONIZED() { return getToken(Ninja9Parser.SYNCHRONIZED, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SynchronizedStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_synchronizedStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterSynchronizedStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitSynchronizedStatement(this);
		}
	}

	public final SynchronizedStatementContext synchronizedStatement() throws RecognitionException {
		SynchronizedStatementContext _localctx = new SynchronizedStatementContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_synchronizedStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1628);
			match(SYNCHRONIZED);
			setState(1629);
			match(LPAREN);
			setState(1630);
			expression();
			setState(1631);
			match(RPAREN);
			setState(1632);
			block();
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
	public static class TryStatementContext extends ParserRuleContext {
		public BasicTryStatementContext basicTryStatement() {
			return getRuleContext(BasicTryStatementContext.class,0);
		}
		public TryWithResourcesStatementContext tryWithResourcesStatement() {
			return getRuleContext(TryWithResourcesStatementContext.class,0);
		}
		public TryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTryStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTryStatement(this);
		}
	}

	public final TryStatementContext tryStatement() throws RecognitionException {
		TryStatementContext _localctx = new TryStatementContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_tryStatement);
		try {
			setState(1636);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1634);
				basicTryStatement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1635);
				tryWithResourcesStatement();
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
	public static class BasicTryStatementContext extends ParserRuleContext {
		public BasicTryStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_basicTryStatement; }
	 
		public BasicTryStatementContext() { }
		public void copyFrom(BasicTryStatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchFinallyStatementContext extends BasicTryStatementContext {
		public TerminalNode TRY() { return getToken(Ninja9Parser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public TryCatchFinallyStatementContext(BasicTryStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTryCatchFinallyStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTryCatchFinallyStatement(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TryCatchStatementContext extends BasicTryStatementContext {
		public TerminalNode TRY() { return getToken(Ninja9Parser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public TryCatchStatementContext(BasicTryStatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTryCatchStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTryCatchStatement(this);
		}
	}

	public final BasicTryStatementContext basicTryStatement() throws RecognitionException {
		BasicTryStatementContext _localctx = new BasicTryStatementContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_basicTryStatement);
		int _la;
		try {
			setState(1649);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,173,_ctx) ) {
			case 1:
				_localctx = new TryCatchStatementContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1638);
				match(TRY);
				setState(1639);
				block();
				setState(1640);
				catches();
				}
				break;
			case 2:
				_localctx = new TryCatchFinallyStatementContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1642);
				match(TRY);
				setState(1643);
				block();
				setState(1645);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==CATCH) {
					{
					setState(1644);
					catches();
					}
				}

				setState(1647);
				finally_();
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
	public static class CatchesContext extends ParserRuleContext {
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public CatchesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catches; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterCatches(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitCatches(this);
		}
	}

	public final CatchesContext catches() throws RecognitionException {
		CatchesContext _localctx = new CatchesContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_catches);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1651);
			catchClause();
			setState(1655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CATCH) {
				{
				{
				setState(1652);
				catchClause();
				}
				}
				setState(1657);
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
	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(Ninja9Parser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public UnannClassTypeContext unannClassType() {
			return getRuleContext(UnannClassTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public List<TerminalNode> BITOR() { return getTokens(Ninja9Parser.BITOR); }
		public TerminalNode BITOR(int i) {
			return getToken(Ninja9Parser.BITOR, i);
		}
		public List<ClassTypeContext> classType() {
			return getRuleContexts(ClassTypeContext.class);
		}
		public ClassTypeContext classType(int i) {
			return getRuleContext(ClassTypeContext.class,i);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterCatchClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitCatchClause(this);
		}
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_catchClause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1658);
			match(CATCH);
			setState(1659);
			match(LPAREN);
			setState(1663);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1660);
				modifier();
				}
				}
				setState(1665);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1666);
			unannClassType();
			setState(1671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1667);
				match(BITOR);
				setState(1668);
				classType(0);
				}
				}
				setState(1673);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1674);
			variableDeclaratorId();
			setState(1675);
			match(RPAREN);
			setState(1676);
			block();
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
	public static class Finally_Context extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(Ninja9Parser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFinally_(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFinally_(this);
		}
	}

	public final Finally_Context finally_() throws RecognitionException {
		Finally_Context _localctx = new Finally_Context(_ctx, getState());
		enterRule(_localctx, 302, RULE_finally_);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1678);
			match(FINALLY);
			setState(1679);
			block();
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
	public static class TryWithResourcesStatementContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(Ninja9Parser.TRY, 0); }
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public CatchesContext catches() {
			return getRuleContext(CatchesContext.class,0);
		}
		public Finally_Context finally_() {
			return getRuleContext(Finally_Context.class,0);
		}
		public TryWithResourcesStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryWithResourcesStatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterTryWithResourcesStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitTryWithResourcesStatement(this);
		}
	}

	public final TryWithResourcesStatementContext tryWithResourcesStatement() throws RecognitionException {
		TryWithResourcesStatementContext _localctx = new TryWithResourcesStatementContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_tryWithResourcesStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1681);
			match(TRY);
			setState(1682);
			resourceSpecification();
			setState(1683);
			block();
			setState(1685);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CATCH) {
				{
				setState(1684);
				catches();
				}
			}

			setState(1688);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==FINALLY) {
				{
				setState(1687);
				finally_();
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
	public static class ResourceSpecificationContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ResourceListContext resourceList() {
			return getRuleContext(ResourceListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(Ninja9Parser.SEMI, 0); }
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterResourceSpecification(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitResourceSpecification(this);
		}
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1690);
			match(LPAREN);
			setState(1691);
			resourceList();
			setState(1693);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1692);
				match(SEMI);
				}
			}

			setState(1695);
			match(RPAREN);
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
	public static class ResourceListContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(Ninja9Parser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(Ninja9Parser.SEMI, i);
		}
		public ResourceListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterResourceList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitResourceList(this);
		}
	}

	public final ResourceListContext resourceList() throws RecognitionException {
		ResourceListContext _localctx = new ResourceListContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_resourceList);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1697);
			resource();
			setState(1702);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1698);
					match(SEMI);
					setState(1699);
					resource();
					}
					} 
				}
				setState(1704);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
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
	public static class ResourceContext extends ParserRuleContext {
		public UnannTypeContext unannType() {
			return getRuleContext(UnannTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(Ninja9Parser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterResource(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitResource(this);
		}
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_resource);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1708);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5108820651016208L) != 0)) {
				{
				{
				setState(1705);
				modifier();
				}
				}
				setState(1710);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1711);
			unannType();
			setState(1712);
			variableDeclaratorId();
			setState(1713);
			match(ASSIGN);
			setState(1714);
			expression();
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
	public static class PrimaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primaryContext.class,0);
		}
		public ArrayCreationExpressionContext arrayCreationExpression() {
			return getRuleContext(ArrayCreationExpressionContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_primaryContext> primaryNoNewArray_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primaryContext.class);
		}
		public PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primaryContext.class,i);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimary(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1718);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				{
				setState(1716);
				primaryNoNewArray_lfno_primary();
				}
				break;
			case 2:
				{
				setState(1717);
				arrayCreationExpression();
				}
				break;
			}
			setState(1723);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1720);
					primaryNoNewArray_lf_primary();
					}
					} 
				}
				setState(1725);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,183,_ctx);
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
	public static class ExpressionParenthesisContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public ExpressionParenthesisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionParenthesis; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExpressionParenthesis(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExpressionParenthesis(this);
		}
	}

	public final ExpressionParenthesisContext expressionParenthesis() throws RecognitionException {
		ExpressionParenthesisContext _localctx = new ExpressionParenthesisContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_expressionParenthesis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1726);
			match(LPAREN);
			setState(1727);
			expression();
			setState(1728);
			match(RPAREN);
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
	public static class PrimaryNoNewArray_lf_arrayAccessContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lf_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lf_arrayAccess(this);
		}
	}

	public final PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lf_arrayAccessContext _localctx = new PrimaryNoNewArray_lf_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_primaryNoNewArray_lf_arrayAccess);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
	public static class PrimaryNoNewArray_lfno_arrayAccessContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(Ninja9Parser.CLASS, 0); }
		public List<TerminalNode> LBRACK() { return getTokens(Ninja9Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Ninja9Parser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Ninja9Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Ninja9Parser.RBRACK, i);
		}
		public TerminalNode VOID() { return getToken(Ninja9Parser.VOID, 0); }
		public TerminalNode THIS() { return getToken(Ninja9Parser.THIS, 0); }
		public ExpressionParenthesisContext expressionParenthesis() {
			return getRuleContext(ExpressionParenthesisContext.class,0);
		}
		public ClassInstanceCreationExpressionContext classInstanceCreationExpression() {
			return getRuleContext(ClassInstanceCreationExpressionContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public MethodInvocationContext methodInvocation() {
			return getRuleContext(MethodInvocationContext.class,0);
		}
		public MethodReferenceContext methodReference() {
			return getRuleContext(MethodReferenceContext.class,0);
		}
		public PrimaryNoNewArray_lfno_arrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lfno_arrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lfno_arrayAccess(this);
		}
	}

	public final PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() throws RecognitionException {
		PrimaryNoNewArray_lfno_arrayAccessContext _localctx = new PrimaryNoNewArray_lfno_arrayAccessContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_primaryNoNewArray_lfno_arrayAccess);
		int _la;
		try {
			setState(1757);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1732);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1733);
				typeName();
				setState(1738);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==LBRACK) {
					{
					{
					setState(1734);
					match(LBRACK);
					setState(1735);
					match(RBRACK);
					}
					}
					setState(1740);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1741);
				match(DOT);
				setState(1742);
				match(CLASS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1744);
				match(VOID);
				setState(1745);
				match(DOT);
				setState(1746);
				match(CLASS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1747);
				match(THIS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1748);
				typeName();
				setState(1749);
				match(DOT);
				setState(1750);
				match(THIS);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1752);
				expressionParenthesis();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1753);
				classInstanceCreationExpression();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1754);
				fieldAccess();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1755);
				methodInvocation();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1756);
				methodReference();
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
	public static class PrimaryNoNewArray_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public ArrayAccess_lf_primaryContext arrayAccess_lf_primary() {
			return getRuleContext(ArrayAccess_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lf_primary(this);
		}
	}

	public final PrimaryNoNewArray_lf_primaryContext primaryNoNewArray_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_primaryNoNewArray_lf_primary);
		try {
			setState(1764);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,186,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1759);
				classInstanceCreationExpression_lf_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1760);
				fieldAccess_lf_primary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1761);
				arrayAccess_lf_primary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1762);
				methodInvocation_lf_primary();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1763);
				methodReference_lf_primary();
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
	public static class PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
	public static class PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext extends ParserRuleContext {
		public ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lf_primaryContext.class,0);
		}
		public FieldAccess_lf_primaryContext fieldAccess_lf_primary() {
			return getRuleContext(FieldAccess_lf_primaryContext.class,0);
		}
		public MethodInvocation_lf_primaryContext methodInvocation_lf_primary() {
			return getRuleContext(MethodInvocation_lf_primaryContext.class,0);
		}
		public MethodReference_lf_primaryContext methodReference_lf_primary() {
			return getRuleContext(MethodReference_lf_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(this);
		}
	}

	public final PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() throws RecognitionException {
		PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext _localctx = new PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary);
		try {
			setState(1772);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1768);
				classInstanceCreationExpression_lf_primary();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1769);
				fieldAccess_lf_primary();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1770);
				methodInvocation_lf_primary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1771);
				methodReference_lf_primary();
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
	public static class PrimaryClassTypeContext extends ParserRuleContext {
		public PrimaryClassTypeAlternatesContext primaryClassTypeAlternates() {
			return getRuleContext(PrimaryClassTypeAlternatesContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(Ninja9Parser.CLASS, 0); }
		public List<BracketPairContext> bracketPair() {
			return getRuleContexts(BracketPairContext.class);
		}
		public BracketPairContext bracketPair(int i) {
			return getRuleContext(BracketPairContext.class,i);
		}
		public PrimaryClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryClassType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryClassType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryClassType(this);
		}
	}

	public final PrimaryClassTypeContext primaryClassType() throws RecognitionException {
		PrimaryClassTypeContext _localctx = new PrimaryClassTypeContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_primaryClassType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1774);
			primaryClassTypeAlternates();
			setState(1778);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(1775);
				bracketPair();
				}
				}
				setState(1780);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1781);
			match(DOT);
			setState(1782);
			match(CLASS);
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
	public static class PrimaryClassTypeAlternatesContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public UnannPrimitiveTypeContext unannPrimitiveType() {
			return getRuleContext(UnannPrimitiveTypeContext.class,0);
		}
		public VoidTypeContext voidType() {
			return getRuleContext(VoidTypeContext.class,0);
		}
		public PrimaryClassTypeAlternatesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryClassTypeAlternates; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryClassTypeAlternates(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryClassTypeAlternates(this);
		}
	}

	public final PrimaryClassTypeAlternatesContext primaryClassTypeAlternates() throws RecognitionException {
		PrimaryClassTypeAlternatesContext _localctx = new PrimaryClassTypeAlternatesContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_primaryClassTypeAlternates);
		try {
			setState(1787);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1784);
				typeName();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1785);
				unannPrimitiveType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 3);
				{
				setState(1786);
				voidType();
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
	public static class VoidTypeContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(Ninja9Parser.VOID, 0); }
		public VoidTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_voidType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterVoidType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitVoidType(this);
		}
	}

	public final VoidTypeContext voidType() throws RecognitionException {
		VoidTypeContext _localctx = new VoidTypeContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_voidType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1789);
			match(VOID);
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
	public static class BracketPairContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(Ninja9Parser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(Ninja9Parser.RBRACK, 0); }
		public BracketPairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bracketPair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBracketPair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBracketPair(this);
		}
	}

	public final BracketPairContext bracketPair() throws RecognitionException {
		BracketPairContext _localctx = new BracketPairContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_bracketPair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1791);
			match(LBRACK);
			setState(1792);
			match(RBRACK);
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
	public static class PrimaryNoNewArray_lfno_primaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryClassTypeContext primaryClassType() {
			return getRuleContext(PrimaryClassTypeContext.class,0);
		}
		public TerminalNode THIS() { return getToken(Ninja9Parser.THIS, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public ExpressionParenthesisContext expressionParenthesis() {
			return getRuleContext(ExpressionParenthesisContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() {
			return getRuleContext(ArrayAccess_lfno_primaryContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lfno_primary(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primaryContext primaryNoNewArray_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_primaryNoNewArray_lfno_primary);
		try {
			setState(1807);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,190,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1794);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1795);
				primaryClassType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1796);
				match(THIS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1797);
				typeName();
				setState(1798);
				match(DOT);
				setState(1799);
				match(THIS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1801);
				expressionParenthesis();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1802);
				classInstanceCreationExpression_lfno_primary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1803);
				fieldAccess_lfno_primary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1804);
				arrayAccess_lfno_primary();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1805);
				methodInvocation_lfno_primary();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1806);
				methodReference_lfno_primary();
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
	public static class PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
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
	public static class PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public PrimaryClassTypeContext primaryClassType() {
			return getRuleContext(PrimaryClassTypeContext.class,0);
		}
		public TerminalNode THIS() { return getToken(Ninja9Parser.THIS, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public ExpressionParenthesisContext expressionParenthesis() {
			return getRuleContext(ExpressionParenthesisContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() {
			return getRuleContext(ClassInstanceCreationExpression_lfno_primaryContext.class,0);
		}
		public FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() {
			return getRuleContext(FieldAccess_lfno_primaryContext.class,0);
		}
		public MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() {
			return getRuleContext(MethodInvocation_lfno_primaryContext.class,0);
		}
		public MethodReference_lfno_primaryContext methodReference_lfno_primary() {
			return getRuleContext(MethodReference_lfno_primaryContext.class,0);
		}
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(this);
		}
	}

	public final PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() throws RecognitionException {
		PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext _localctx = new PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary);
		try {
			setState(1823);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1811);
				literal();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1812);
				primaryClassType();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1813);
				match(THIS);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1814);
				typeName();
				setState(1815);
				match(DOT);
				setState(1816);
				match(THIS);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1818);
				expressionParenthesis();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1819);
				classInstanceCreationExpression_lfno_primary();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1820);
				fieldAccess_lfno_primary();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1821);
				methodInvocation_lfno_primary();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1822);
				methodReference_lfno_primary();
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
	public static class ClassIdentifierContext extends ParserRuleContext {
		public PropertyLookupContext propertyLookup() {
			return getRuleContext(PropertyLookupContext.class,0);
		}
		public ClassIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classIdentifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassIdentifier(this);
		}
	}

	public final ClassIdentifierContext classIdentifier() throws RecognitionException {
		ClassIdentifierContext _localctx = new ClassIdentifierContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_classIdentifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1825);
			propertyLookup();
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
	public static class ClassInstanceCreationExpressionContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(Ninja9Parser.NEW, 0); }
		public ClassIdentifierContext classIdentifier() {
			return getRuleContext(ClassIdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassInstanceCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassInstanceCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassInstanceCreationExpression(this);
		}
	}

	public final ClassInstanceCreationExpressionContext classInstanceCreationExpression() throws RecognitionException {
		ClassInstanceCreationExpressionContext _localctx = new ClassInstanceCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_classInstanceCreationExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1827);
			match(NEW);
			setState(1829);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1828);
				typeArguments();
				}
			}

			setState(1831);
			classIdentifier();
			setState(1833);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1832);
				typeArgumentsOrDiamond();
				}
			}

			setState(1835);
			match(LPAREN);
			setState(1837);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(1836);
				argumentList();
				}
			}

			setState(1839);
			match(RPAREN);
			setState(1841);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(1840);
				classBody();
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
	public static class ClassInstanceCreationExpression_lf_primaryContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public TerminalNode NEW() { return getToken(Ninja9Parser.NEW, 0); }
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassInstanceCreationExpression_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassInstanceCreationExpression_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassInstanceCreationExpression_lf_primary(this);
		}
	}

	public final ClassInstanceCreationExpression_lf_primaryContext classInstanceCreationExpression_lf_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lf_primaryContext _localctx = new ClassInstanceCreationExpression_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_classInstanceCreationExpression_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1843);
			match(DOT);
			setState(1844);
			match(NEW);
			setState(1846);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1845);
				typeArguments();
				}
			}

			setState(1851);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(1848);
				annotation();
				}
				}
				setState(1853);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1854);
			match(Identifier);
			setState(1856);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1855);
				typeArgumentsOrDiamond();
				}
			}

			setState(1858);
			match(LPAREN);
			setState(1860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(1859);
				argumentList();
				}
			}

			setState(1862);
			match(RPAREN);
			setState(1864);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,200,_ctx) ) {
			case 1:
				{
				setState(1863);
				classBody();
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
	public static class ClassInstanceCreationExpression_lfno_primaryContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(Ninja9Parser.NEW, 0); }
		public List<TerminalNode> Identifier() { return getTokens(Ninja9Parser.Identifier); }
		public TerminalNode Identifier(int i) {
			return getToken(Ninja9Parser.Identifier, i);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(Ninja9Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Ninja9Parser.DOT, i);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public ClassInstanceCreationExpression_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classInstanceCreationExpression_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterClassInstanceCreationExpression_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitClassInstanceCreationExpression_lfno_primary(this);
		}
	}

	public final ClassInstanceCreationExpression_lfno_primaryContext classInstanceCreationExpression_lfno_primary() throws RecognitionException {
		ClassInstanceCreationExpression_lfno_primaryContext _localctx = new ClassInstanceCreationExpression_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_classInstanceCreationExpression_lfno_primary);
		int _la;
		try {
			setState(1925);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
				enterOuterAlt(_localctx, 1);
				{
				setState(1866);
				match(NEW);
				setState(1868);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1867);
					typeArguments();
					}
				}

				setState(1873);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1870);
					annotation();
					}
					}
					setState(1875);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1876);
				match(Identifier);
				setState(1887);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(1877);
					match(DOT);
					setState(1881);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==AT) {
						{
						{
						setState(1878);
						annotation();
						}
						}
						setState(1883);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1884);
					match(Identifier);
					}
					}
					setState(1889);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1891);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1890);
					typeArgumentsOrDiamond();
					}
				}

				setState(1893);
				match(LPAREN);
				setState(1895);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(1894);
					argumentList();
					}
				}

				setState(1897);
				match(RPAREN);
				setState(1899);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
				case 1:
					{
					setState(1898);
					classBody();
					}
					break;
				}
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1901);
				expressionName();
				setState(1902);
				match(DOT);
				setState(1903);
				match(NEW);
				setState(1905);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1904);
					typeArguments();
					}
				}

				setState(1910);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==AT) {
					{
					{
					setState(1907);
					annotation();
					}
					}
					setState(1912);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1913);
				match(Identifier);
				setState(1915);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1914);
					typeArgumentsOrDiamond();
					}
				}

				setState(1917);
				match(LPAREN);
				setState(1919);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(1918);
					argumentList();
					}
				}

				setState(1921);
				match(RPAREN);
				setState(1923);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,212,_ctx) ) {
				case 1:
					{
					setState(1922);
					classBody();
					}
					break;
				}
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
	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
	 
		public TypeArgumentsOrDiamondContext() { }
		public void copyFrom(TypeArgumentsOrDiamondContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DiamondContext extends TypeArgumentsOrDiamondContext {
		public TerminalNode LT() { return getToken(Ninja9Parser.LT, 0); }
		public TerminalNode GT() { return getToken(Ninja9Parser.GT, 0); }
		public DiamondContext(TypeArgumentsOrDiamondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterDiamond(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitDiamond(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Ig22Context extends TypeArgumentsOrDiamondContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public Ig22Context(TypeArgumentsOrDiamondContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIg22(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIg22(this);
		}
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_typeArgumentsOrDiamond);
		try {
			setState(1930);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,214,_ctx) ) {
			case 1:
				_localctx = new Ig22Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(1927);
				typeArguments();
				}
				break;
			case 2:
				_localctx = new DiamondContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(1928);
				match(LT);
				setState(1929);
				match(GT);
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
	public static class FieldAccessContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(Ninja9Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Ninja9Parser.DOT, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public FieldAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFieldAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFieldAccess(this);
		}
	}

	public final FieldAccessContext fieldAccess() throws RecognitionException {
		FieldAccessContext _localctx = new FieldAccessContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_fieldAccess);
		try {
			setState(1945);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1932);
				primary();
				setState(1933);
				match(DOT);
				setState(1934);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1936);
				match(SUPER);
				setState(1937);
				match(DOT);
				setState(1938);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1939);
				typeName();
				setState(1940);
				match(DOT);
				setState(1941);
				match(SUPER);
				setState(1942);
				match(DOT);
				setState(1943);
				identifier();
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
	public static class FieldAccess_lf_primaryContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FieldAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFieldAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFieldAccess_lf_primary(this);
		}
	}

	public final FieldAccess_lf_primaryContext fieldAccess_lf_primary() throws RecognitionException {
		FieldAccess_lf_primaryContext _localctx = new FieldAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_fieldAccess_lf_primary);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1947);
			match(DOT);
			setState(1948);
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
	public static class FieldAccess_lfno_primaryContext extends ParserRuleContext {
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public List<TerminalNode> DOT() { return getTokens(Ninja9Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Ninja9Parser.DOT, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public FieldAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterFieldAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitFieldAccess_lfno_primary(this);
		}
	}

	public final FieldAccess_lfno_primaryContext fieldAccess_lfno_primary() throws RecognitionException {
		FieldAccess_lfno_primaryContext _localctx = new FieldAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_fieldAccess_lfno_primary);
		try {
			setState(1959);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1950);
				match(SUPER);
				setState(1951);
				match(DOT);
				setState(1952);
				identifier();
				}
				break;
			case Identifier:
				enterOuterAlt(_localctx, 2);
				{
				setState(1953);
				typeName();
				setState(1954);
				match(DOT);
				setState(1955);
				match(SUPER);
				setState(1956);
				match(DOT);
				setState(1957);
				identifier();
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
	public static class ArrayAccessContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Ninja9Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Ninja9Parser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Ninja9Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Ninja9Parser.RBRACK, i);
		}
		public PrimaryNoNewArray_lfno_arrayAccessContext primaryNoNewArray_lfno_arrayAccess() {
			return getRuleContext(PrimaryNoNewArray_lfno_arrayAccessContext.class,0);
		}
		public List<PrimaryNoNewArray_lf_arrayAccessContext> primaryNoNewArray_lf_arrayAccess() {
			return getRuleContexts(PrimaryNoNewArray_lf_arrayAccessContext.class);
		}
		public PrimaryNoNewArray_lf_arrayAccessContext primaryNoNewArray_lf_arrayAccess(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_arrayAccessContext.class,i);
		}
		public ArrayAccessContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayAccess(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayAccess(this);
		}
	}

	public final ArrayAccessContext arrayAccess() throws RecognitionException {
		ArrayAccessContext _localctx = new ArrayAccessContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_arrayAccess);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1971);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,217,_ctx) ) {
			case 1:
				{
				setState(1961);
				expressionName();
				setState(1962);
				match(LBRACK);
				setState(1963);
				expression();
				setState(1964);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(1966);
				primaryNoNewArray_lfno_arrayAccess();
				setState(1967);
				match(LBRACK);
				setState(1968);
				expression();
				setState(1969);
				match(RBRACK);
				}
				break;
			}
			setState(1980);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(1973);
				primaryNoNewArray_lf_arrayAccess();
				setState(1974);
				match(LBRACK);
				setState(1975);
				expression();
				setState(1976);
				match(RBRACK);
				}
				}
				setState(1982);
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
	public static class ArrayAccess_lf_primaryContext extends ParserRuleContext {
		public PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary() {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Ninja9Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Ninja9Parser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Ninja9Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Ninja9Parser.RBRACK, i);
		}
		public List<PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext> primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary() {
			return getRuleContexts(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class);
		}
		public PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext.class,i);
		}
		public ArrayAccess_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayAccess_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayAccess_lf_primary(this);
		}
	}

	public final ArrayAccess_lf_primaryContext arrayAccess_lf_primary() throws RecognitionException {
		ArrayAccess_lf_primaryContext _localctx = new ArrayAccess_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_arrayAccess_lf_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1983);
			primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary();
			setState(1984);
			match(LBRACK);
			setState(1985);
			expression();
			setState(1986);
			match(RBRACK);
			}
			setState(1995);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1988);
					primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary();
					setState(1989);
					match(LBRACK);
					setState(1990);
					expression();
					setState(1991);
					match(RBRACK);
					}
					} 
				}
				setState(1997);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
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
	public static class ArrayAccess_lfno_primaryContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(Ninja9Parser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(Ninja9Parser.LBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(Ninja9Parser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(Ninja9Parser.RBRACK, i);
		}
		public PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary() {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext.class,0);
		}
		public List<PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext> primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary() {
			return getRuleContexts(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class);
		}
		public PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(int i) {
			return getRuleContext(PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext.class,i);
		}
		public ArrayAccess_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayAccess_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayAccess_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayAccess_lfno_primary(this);
		}
	}

	public final ArrayAccess_lfno_primaryContext arrayAccess_lfno_primary() throws RecognitionException {
		ArrayAccess_lfno_primaryContext _localctx = new ArrayAccess_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_arrayAccess_lfno_primary);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2008);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,220,_ctx) ) {
			case 1:
				{
				setState(1998);
				expressionName();
				setState(1999);
				match(LBRACK);
				setState(2000);
				expression();
				setState(2001);
				match(RBRACK);
				}
				break;
			case 2:
				{
				setState(2003);
				primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary();
				setState(2004);
				match(LBRACK);
				setState(2005);
				expression();
				setState(2006);
				match(RBRACK);
				}
				break;
			}
			setState(2017);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2010);
					primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary();
					setState(2011);
					match(LBRACK);
					setState(2012);
					expression();
					setState(2013);
					match(RBRACK);
					}
					} 
				}
				setState(2019);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,221,_ctx);
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
	public static class MethodInvocationContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public MethodAreaContext methodArea() {
			return getRuleContext(MethodAreaContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodInvocation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodInvocation(this);
		}
	}

	public final MethodInvocationContext methodInvocation() throws RecognitionException {
		MethodInvocationContext _localctx = new MethodInvocationContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_methodInvocation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2021);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,222,_ctx) ) {
			case 1:
				{
				setState(2020);
				methodArea();
				}
				break;
			}
			setState(2024);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2023);
				typeArguments();
				}
			}

			setState(2026);
			identifier();
			setState(2027);
			match(LPAREN);
			setState(2029);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(2028);
				argumentList();
				}
			}

			setState(2031);
			match(RPAREN);
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
	public static class MethodAreaContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public List<TerminalNode> DOT() { return getTokens(Ninja9Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Ninja9Parser.DOT, i);
		}
		public MethodAreaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodArea; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodArea(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodArea(this);
		}
	}

	public final MethodAreaContext methodArea() throws RecognitionException {
		MethodAreaContext _localctx = new MethodAreaContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_methodArea);
		try {
			setState(2043);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,225,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2033);
				typeName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2034);
				expressionName();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2035);
				primary();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2036);
				match(SUPER);
				setState(2037);
				match(DOT);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2038);
				typeName();
				setState(2039);
				match(DOT);
				setState(2040);
				match(SUPER);
				setState(2041);
				match(DOT);
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
	public static class MethodInvocation_lf_primaryContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public MethodInvocation_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodInvocation_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodInvocation_lf_primary(this);
		}
	}

	public final MethodInvocation_lf_primaryContext methodInvocation_lf_primary() throws RecognitionException {
		MethodInvocation_lf_primaryContext _localctx = new MethodInvocation_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_methodInvocation_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2045);
			match(DOT);
			setState(2047);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2046);
				typeArguments();
				}
			}

			setState(2049);
			identifier();
			setState(2050);
			match(LPAREN);
			setState(2052);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
				{
				setState(2051);
				argumentList();
				}
			}

			setState(2054);
			match(RPAREN);
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
	public static class MethodInvocation_lfno_primaryContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public ArgumentListContext argumentList() {
			return getRuleContext(ArgumentListContext.class,0);
		}
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(Ninja9Parser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(Ninja9Parser.DOT, i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public MethodInvocation_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodInvocation_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodInvocation_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodInvocation_lfno_primary(this);
		}
	}

	public final MethodInvocation_lfno_primaryContext methodInvocation_lfno_primary() throws RecognitionException {
		MethodInvocation_lfno_primaryContext _localctx = new MethodInvocation_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_methodInvocation_lfno_primary);
		int _la;
		try {
			setState(2113);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,237,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2056);
				identifier();
				setState(2057);
				match(LPAREN);
				setState(2059);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(2058);
					argumentList();
					}
				}

				setState(2061);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2063);
				typeName();
				setState(2064);
				match(DOT);
				setState(2066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2065);
					typeArguments();
					}
				}

				setState(2068);
				identifier();
				setState(2069);
				match(LPAREN);
				setState(2071);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(2070);
					argumentList();
					}
				}

				setState(2073);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2075);
				expressionName();
				setState(2076);
				match(DOT);
				setState(2078);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2077);
					typeArguments();
					}
				}

				setState(2080);
				identifier();
				setState(2081);
				match(LPAREN);
				setState(2083);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(2082);
					argumentList();
					}
				}

				setState(2085);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2087);
				match(SUPER);
				setState(2088);
				match(DOT);
				setState(2090);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2089);
					typeArguments();
					}
				}

				setState(2092);
				identifier();
				setState(2093);
				match(LPAREN);
				setState(2095);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(2094);
					argumentList();
					}
				}

				setState(2097);
				match(RPAREN);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2099);
				typeName();
				setState(2100);
				match(DOT);
				setState(2101);
				match(SUPER);
				setState(2102);
				match(DOT);
				setState(2104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2103);
					typeArguments();
					}
				}

				setState(2106);
				identifier();
				setState(2107);
				match(LPAREN);
				setState(2109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2290160697423825216L) != 0) || ((((_la - 71)) & ~0x3f) == 0 && ((1L << (_la - 71)) & 51539638279L) != 0)) {
					{
					setState(2108);
					argumentList();
					}
				}

				setState(2111);
				match(RPAREN);
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
	public static class ArgumentListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public ArgumentListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argumentList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArgumentList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArgumentList(this);
		}
	}

	public final ArgumentListContext argumentList() throws RecognitionException {
		ArgumentListContext _localctx = new ArgumentListContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_argumentList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2115);
			expression();
			setState(2120);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2116);
				match(COMMA);
				setState(2117);
				expression();
				}
				}
				setState(2122);
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
	public static class MethodReferenceContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(Ninja9Parser.COLONCOLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode NEW() { return getToken(Ninja9Parser.NEW, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public MethodReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodReference(this);
		}
	}

	public final MethodReferenceContext methodReference() throws RecognitionException {
		MethodReferenceContext _localctx = new MethodReferenceContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_methodReference);
		int _la;
		try {
			setState(2170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2123);
				expressionName();
				setState(2124);
				match(COLONCOLON);
				setState(2126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2125);
					typeArguments();
					}
				}

				setState(2128);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2130);
				referenceType();
				setState(2131);
				match(COLONCOLON);
				setState(2133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2132);
					typeArguments();
					}
				}

				setState(2135);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2137);
				primary();
				setState(2138);
				match(COLONCOLON);
				setState(2140);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2139);
					typeArguments();
					}
				}

				setState(2142);
				identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2144);
				match(SUPER);
				setState(2145);
				match(COLONCOLON);
				setState(2147);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2146);
					typeArguments();
					}
				}

				setState(2149);
				identifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2150);
				typeName();
				setState(2151);
				match(DOT);
				setState(2152);
				match(SUPER);
				setState(2153);
				match(COLONCOLON);
				setState(2155);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2154);
					typeArguments();
					}
				}

				setState(2157);
				identifier();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2159);
				classType(0);
				setState(2160);
				match(COLONCOLON);
				setState(2162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2161);
					typeArguments();
					}
				}

				setState(2164);
				match(NEW);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(2166);
				arrayType();
				setState(2167);
				match(COLONCOLON);
				setState(2168);
				match(NEW);
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
	public static class MethodReference_lf_primaryContext extends ParserRuleContext {
		public TerminalNode COLONCOLON() { return getToken(Ninja9Parser.COLONCOLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public MethodReference_lf_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lf_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodReference_lf_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodReference_lf_primary(this);
		}
	}

	public final MethodReference_lf_primaryContext methodReference_lf_primary() throws RecognitionException {
		MethodReference_lf_primaryContext _localctx = new MethodReference_lf_primaryContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_methodReference_lf_primary);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2172);
			match(COLONCOLON);
			setState(2174);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(2173);
				typeArguments();
				}
			}

			setState(2176);
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
	public static class MethodReference_lfno_primaryContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(Ninja9Parser.COLONCOLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(Ninja9Parser.SUPER, 0); }
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(Ninja9Parser.DOT, 0); }
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public TerminalNode NEW() { return getToken(Ninja9Parser.NEW, 0); }
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public MethodReference_lfno_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodReference_lfno_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterMethodReference_lfno_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitMethodReference_lfno_primary(this);
		}
	}

	public final MethodReference_lfno_primaryContext methodReference_lfno_primary() throws RecognitionException {
		MethodReference_lfno_primaryContext _localctx = new MethodReference_lfno_primaryContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_methodReference_lfno_primary);
		int _la;
		try {
			setState(2218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2178);
				expressionName();
				setState(2179);
				match(COLONCOLON);
				setState(2181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2180);
					typeArguments();
					}
				}

				setState(2183);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2185);
				referenceType();
				setState(2186);
				match(COLONCOLON);
				setState(2188);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2187);
					typeArguments();
					}
				}

				setState(2190);
				identifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2192);
				match(SUPER);
				setState(2193);
				match(COLONCOLON);
				setState(2195);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2194);
					typeArguments();
					}
				}

				setState(2197);
				identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2198);
				typeName();
				setState(2199);
				match(DOT);
				setState(2200);
				match(SUPER);
				setState(2201);
				match(COLONCOLON);
				setState(2203);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2202);
					typeArguments();
					}
				}

				setState(2205);
				identifier();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2207);
				classType(0);
				setState(2208);
				match(COLONCOLON);
				setState(2210);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(2209);
					typeArguments();
					}
				}

				setState(2212);
				match(NEW);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(2214);
				arrayType();
				setState(2215);
				match(COLONCOLON);
				setState(2216);
				match(NEW);
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
	public static class ArrayCreationExpressionContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(Ninja9Parser.NEW, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public DimExprsContext dimExprs() {
			return getRuleContext(DimExprsContext.class,0);
		}
		public DimsContext dims() {
			return getRuleContext(DimsContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ArrayCreationExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreationExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterArrayCreationExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitArrayCreationExpression(this);
		}
	}

	public final ArrayCreationExpressionContext arrayCreationExpression() throws RecognitionException {
		ArrayCreationExpressionContext _localctx = new ArrayCreationExpressionContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_arrayCreationExpression);
		try {
			setState(2242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,255,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2220);
				match(NEW);
				setState(2221);
				primitiveType();
				setState(2222);
				dimExprs();
				setState(2224);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
				case 1:
					{
					setState(2223);
					dims();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2226);
				match(NEW);
				setState(2227);
				classType(0);
				setState(2228);
				dimExprs();
				setState(2230);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,254,_ctx) ) {
				case 1:
					{
					setState(2229);
					dims();
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2232);
				match(NEW);
				setState(2233);
				primitiveType();
				setState(2234);
				dims();
				setState(2235);
				arrayInitializer();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2237);
				match(NEW);
				setState(2238);
				classType(0);
				setState(2239);
				dims();
				setState(2240);
				arrayInitializer();
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
	public static class DimExprsContext extends ParserRuleContext {
		public List<DimExprContext> dimExpr() {
			return getRuleContexts(DimExprContext.class);
		}
		public DimExprContext dimExpr(int i) {
			return getRuleContext(DimExprContext.class,i);
		}
		public DimExprsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExprs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterDimExprs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitDimExprs(this);
		}
	}

	public final DimExprsContext dimExprs() throws RecognitionException {
		DimExprsContext _localctx = new DimExprsContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_dimExprs);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2244);
			dimExpr();
			setState(2248);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,256,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2245);
					dimExpr();
					}
					} 
				}
				setState(2250);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,256,_ctx);
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
	public static class DimExprContext extends ParserRuleContext {
		public TerminalNode LBRACK() { return getToken(Ninja9Parser.LBRACK, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RBRACK() { return getToken(Ninja9Parser.RBRACK, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public DimExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterDimExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitDimExpr(this);
		}
	}

	public final DimExprContext dimExpr() throws RecognitionException {
		DimExprContext _localctx = new DimExprContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_dimExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2254);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AT) {
				{
				{
				setState(2251);
				annotation();
				}
				}
				setState(2256);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2257);
			match(LBRACK);
			setState(2258);
			expression();
			setState(2259);
			match(RBRACK);
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
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public AssignmentExpressionContext assignmentExpression() {
			return getRuleContext(AssignmentExpressionContext.class,0);
		}
		public ConditionalExpressionContext conditionalExpression() {
			return getRuleContext(ConditionalExpressionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitExpression(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_expression);
		try {
			setState(2264);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2261);
				lambdaExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2262);
				assignmentExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2263);
				conditionalExpression(0);
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
	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(Ninja9Parser.ARROW, 0); }
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLambdaExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLambdaExpression(this);
		}
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2266);
			lambdaParameters();
			setState(2267);
			match(ARROW);
			setState(2268);
			lambdaBody();
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
	public static class LambdaParametersContext extends ParserRuleContext {
		public LambdaIdentifierParameterContext lambdaIdentifierParameter() {
			return getRuleContext(LambdaIdentifierParameterContext.class,0);
		}
		public LambdaParameterListContext lambdaParameterList() {
			return getRuleContext(LambdaParameterListContext.class,0);
		}
		public LambdaInteredParameterListContext lambdaInteredParameterList() {
			return getRuleContext(LambdaInteredParameterListContext.class,0);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLambdaParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLambdaParameters(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_lambdaParameters);
		try {
			setState(2273);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,259,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2270);
				lambdaIdentifierParameter();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2271);
				lambdaParameterList();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2272);
				lambdaInteredParameterList();
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
	public static class LambdaInteredParameterListContext extends ParserRuleContext {
		public LambdaInteredParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaInteredParameterList; }
	 
		public LambdaInteredParameterListContext() { }
		public void copyFrom(LambdaInteredParameterListContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LambdaInferedParameterListContext extends LambdaInteredParameterListContext {
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public InferredFormalParameterListContext inferredFormalParameterList() {
			return getRuleContext(InferredFormalParameterListContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public LambdaInferedParameterListContext(LambdaInteredParameterListContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLambdaInferedParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLambdaInferedParameterList(this);
		}
	}

	public final LambdaInteredParameterListContext lambdaInteredParameterList() throws RecognitionException {
		LambdaInteredParameterListContext _localctx = new LambdaInteredParameterListContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_lambdaInteredParameterList);
		try {
			_localctx = new LambdaInferedParameterListContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(2275);
			match(LPAREN);
			setState(2276);
			inferredFormalParameterList();
			setState(2277);
			match(RPAREN);
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
	public static class LambdaIdentifierParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public LambdaIdentifierParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaIdentifierParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLambdaIdentifierParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLambdaIdentifierParameter(this);
		}
	}

	public final LambdaIdentifierParameterContext lambdaIdentifierParameter() throws RecognitionException {
		LambdaIdentifierParameterContext _localctx = new LambdaIdentifierParameterContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_lambdaIdentifierParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2279);
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
	public static class LambdaParameterListContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public LambdaParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLambdaParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLambdaParameterList(this);
		}
	}

	public final LambdaParameterListContext lambdaParameterList() throws RecognitionException {
		LambdaParameterListContext _localctx = new LambdaParameterListContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_lambdaParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2281);
			match(LPAREN);
			setState(2283);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5109925539875152L) != 0) || _la==Identifier || _la==AT) {
				{
				setState(2282);
				formalParameterList();
				}
			}

			setState(2285);
			match(RPAREN);
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
	public static class InferredFormalParameterListContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(Ninja9Parser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(Ninja9Parser.COMMA, i);
		}
		public InferredFormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inferredFormalParameterList; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterInferredFormalParameterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitInferredFormalParameterList(this);
		}
	}

	public final InferredFormalParameterListContext inferredFormalParameterList() throws RecognitionException {
		InferredFormalParameterListContext _localctx = new InferredFormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_inferredFormalParameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2287);
			identifier();
			setState(2292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(2288);
				match(COMMA);
				setState(2289);
				identifier();
				}
				}
				setState(2294);
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
	public static class LambdaBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLambdaBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLambdaBody(this);
		}
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 398, RULE_lambdaBody);
		try {
			setState(2297);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case THIS:
			case VOID:
			case IntegerLiteral:
			case FloatingPointLiteral:
			case BooleanLiteral:
			case CharacterLiteral:
			case StringLiteral:
			case NullLiteral:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case Identifier:
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2295);
				expression();
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2296);
				block();
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
	public static class AssignmentExpressionContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public AssignmentExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAssignmentExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAssignmentExpression(this);
		}
	}

	public final AssignmentExpressionContext assignmentExpression() throws RecognitionException {
		AssignmentExpressionContext _localctx = new AssignmentExpressionContext(_ctx, getState());
		enterRule(_localctx, 400, RULE_assignmentExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2299);
			assignment();
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
	public static class AssignmentContext extends ParserRuleContext {
		public LeftHandSideContext leftHandSide() {
			return getRuleContext(LeftHandSideContext.class,0);
		}
		public AssignmentOperatorContext assignmentOperator() {
			return getRuleContext(AssignmentOperatorContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAssignment(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 402, RULE_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2301);
			leftHandSide();
			setState(2302);
			assignmentOperator();
			setState(2303);
			expression();
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
	public static class LeftHandSideContext extends ParserRuleContext {
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public FieldAccessContext fieldAccess() {
			return getRuleContext(FieldAccessContext.class,0);
		}
		public ArrayAccessContext arrayAccess() {
			return getRuleContext(ArrayAccessContext.class,0);
		}
		public LeftHandSideContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftHandSide; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLeftHandSide(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLeftHandSide(this);
		}
	}

	public final LeftHandSideContext leftHandSide() throws RecognitionException {
		LeftHandSideContext _localctx = new LeftHandSideContext(_ctx, getState());
		enterRule(_localctx, 404, RULE_leftHandSide);
		try {
			setState(2308);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,263,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2305);
				expressionName();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2306);
				fieldAccess();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2307);
				arrayAccess();
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
	public static class AssignmentOperatorContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(Ninja9Parser.ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(Ninja9Parser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(Ninja9Parser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(Ninja9Parser.MOD_ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(Ninja9Parser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(Ninja9Parser.SUB_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(Ninja9Parser.LSHIFT_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(Ninja9Parser.RSHIFT_ASSIGN, 0); }
		public TerminalNode URSHIFT_ASSIGN() { return getToken(Ninja9Parser.URSHIFT_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(Ninja9Parser.AND_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(Ninja9Parser.XOR_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(Ninja9Parser.OR_ASSIGN, 0); }
		public AssignmentOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterAssignmentOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitAssignmentOperator(this);
		}
	}

	public final AssignmentOperatorContext assignmentOperator() throws RecognitionException {
		AssignmentOperatorContext _localctx = new AssignmentOperatorContext(_ctx, getState());
		enterRule(_localctx, 406, RULE_assignmentOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2310);
			_la = _input.LA(1);
			if ( !(((((_la - 69)) & ~0x3f) == 0 && ((1L << (_la - 69)) & 68685922305L) != 0)) ) {
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
	public static class LeftRightOperatorContext extends ParserRuleContext {
		public TerminalNode OR() { return getToken(Ninja9Parser.OR, 0); }
		public TerminalNode AND() { return getToken(Ninja9Parser.AND, 0); }
		public TerminalNode BITOR() { return getToken(Ninja9Parser.BITOR, 0); }
		public TerminalNode CARET() { return getToken(Ninja9Parser.CARET, 0); }
		public TerminalNode BITAND() { return getToken(Ninja9Parser.BITAND, 0); }
		public TerminalNode EQUAL() { return getToken(Ninja9Parser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(Ninja9Parser.NOTEQUAL, 0); }
		public TerminalNode LT() { return getToken(Ninja9Parser.LT, 0); }
		public TerminalNode GT() { return getToken(Ninja9Parser.GT, 0); }
		public TerminalNode LE() { return getToken(Ninja9Parser.LE, 0); }
		public TerminalNode GE() { return getToken(Ninja9Parser.GE, 0); }
		public TerminalNode INSTANCEOF() { return getToken(Ninja9Parser.INSTANCEOF, 0); }
		public TerminalNode ADD() { return getToken(Ninja9Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(Ninja9Parser.SUB, 0); }
		public TerminalNode MUL() { return getToken(Ninja9Parser.MUL, 0); }
		public TerminalNode DIV() { return getToken(Ninja9Parser.DIV, 0); }
		public TerminalNode MOD() { return getToken(Ninja9Parser.MOD, 0); }
		public LeftRightOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_leftRightOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLeftRightOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLeftRightOperator(this);
		}
	}

	public final LeftRightOperatorContext leftRightOperator() throws RecognitionException {
		LeftRightOperatorContext _localctx = new LeftRightOperatorContext(_ctx, getState());
		enterRule(_localctx, 408, RULE_leftRightOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2312);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 536870926L) != 0) || ((((_la - 70)) & ~0x3f) == 0 && ((1L << (_la - 70)) & 4181955L) != 0)) ) {
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
	public static class ConditionalExpressionContext extends ParserRuleContext {
		public ConditionalExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conditionalExpression; }
	 
		public ConditionalExpressionContext() { }
		public void copyFrom(ConditionalExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class Ig18Context extends ConditionalExpressionContext {
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public Ig18Context(ConditionalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIg18(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIg18(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LeftRightExpressionContext extends ConditionalExpressionContext {
		public List<ConditionalExpressionContext> conditionalExpression() {
			return getRuleContexts(ConditionalExpressionContext.class);
		}
		public ConditionalExpressionContext conditionalExpression(int i) {
			return getRuleContext(ConditionalExpressionContext.class,i);
		}
		public LeftRightOperatorContext leftRightOperator() {
			return getRuleContext(LeftRightOperatorContext.class,0);
		}
		public LeftRightExpressionContext(ConditionalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterLeftRightExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitLeftRightExpression(this);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ConditionalTernaryContext extends ConditionalExpressionContext {
		public List<ConditionalExpressionContext> conditionalExpression() {
			return getRuleContexts(ConditionalExpressionContext.class);
		}
		public ConditionalExpressionContext conditionalExpression(int i) {
			return getRuleContext(ConditionalExpressionContext.class,i);
		}
		public TerminalNode QUESTION() { return getToken(Ninja9Parser.QUESTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(Ninja9Parser.COLON, 0); }
		public ConditionalTernaryContext(ConditionalExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterConditionalTernary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitConditionalTernary(this);
		}
	}

	public final ConditionalExpressionContext conditionalExpression() throws RecognitionException {
		return conditionalExpression(0);
	}

	private ConditionalExpressionContext conditionalExpression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ConditionalExpressionContext _localctx = new ConditionalExpressionContext(_ctx, _parentState);
		ConditionalExpressionContext _prevctx = _localctx;
		int _startState = 410;
		enterRecursionRule(_localctx, 410, RULE_conditionalExpression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Ig18Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(2315);
			unaryExpression();
			}
			_ctx.stop = _input.LT(-1);
			setState(2329);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(2327);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,264,_ctx) ) {
					case 1:
						{
						_localctx = new LeftRightExpressionContext(new ConditionalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionalExpression);
						setState(2317);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(2318);
						leftRightOperator();
						setState(2319);
						conditionalExpression(4);
						}
						break;
					case 2:
						{
						_localctx = new ConditionalTernaryContext(new ConditionalExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_conditionalExpression);
						setState(2321);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(2322);
						match(QUESTION);
						setState(2323);
						expression();
						setState(2324);
						match(COLON);
						setState(2325);
						conditionalExpression(3);
						}
						break;
					}
					} 
				}
				setState(2331);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
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
	public static class UnaryExpressionContext extends ParserRuleContext {
		public PreExpressionContext preExpression() {
			return getRuleContext(PreExpressionContext.class,0);
		}
		public PostfixExpressionContext postfixExpression() {
			return getRuleContext(PostfixExpressionContext.class,0);
		}
		public BinaryExpressionContext binaryExpression() {
			return getRuleContext(BinaryExpressionContext.class,0);
		}
		public CastExpressionContext castExpression() {
			return getRuleContext(CastExpressionContext.class,0);
		}
		public UnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterUnaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitUnaryExpression(this);
		}
	}

	public final UnaryExpressionContext unaryExpression() throws RecognitionException {
		UnaryExpressionContext _localctx = new UnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 412, RULE_unaryExpression);
		try {
			setState(2336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2332);
				preExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2333);
				postfixExpression();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2334);
				binaryExpression();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2335);
				castExpression();
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
	public static class BinaryExpressionContext extends ParserRuleContext {
		public BinaryOperatorContext binaryOperator() {
			return getRuleContext(BinaryOperatorContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public BinaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBinaryExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBinaryExpression(this);
		}
	}

	public final BinaryExpressionContext binaryExpression() throws RecognitionException {
		BinaryExpressionContext _localctx = new BinaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 414, RULE_binaryExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2338);
			binaryOperator();
			setState(2339);
			unaryExpression();
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
	public static class BinaryOperatorContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(Ninja9Parser.ADD, 0); }
		public TerminalNode SUB() { return getToken(Ninja9Parser.SUB, 0); }
		public TerminalNode TILDE() { return getToken(Ninja9Parser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(Ninja9Parser.BANG, 0); }
		public BinaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binaryOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterBinaryOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitBinaryOperator(this);
		}
	}

	public final BinaryOperatorContext binaryOperator() throws RecognitionException {
		BinaryOperatorContext _localctx = new BinaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 416, RULE_binaryOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2341);
			_la = _input.LA(1);
			if ( !(((((_la - 72)) & ~0x3f) == 0 && ((1L << (_la - 72)) & 12291L) != 0)) ) {
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
	public static class PrefixOperatorContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(Ninja9Parser.INC, 0); }
		public TerminalNode DEC() { return getToken(Ninja9Parser.DEC, 0); }
		public PrefixOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPrefixOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPrefixOperator(this);
		}
	}

	public final PrefixOperatorContext prefixOperator() throws RecognitionException {
		PrefixOperatorContext _localctx = new PrefixOperatorContext(_ctx, getState());
		enterRule(_localctx, 418, RULE_prefixOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2343);
			_la = _input.LA(1);
			if ( !(_la==INC || _la==DEC) ) {
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
	public static class PreExpressionContext extends ParserRuleContext {
		public PrefixOperatorContext prefixOperator() {
			return getRuleContext(PrefixOperatorContext.class,0);
		}
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public PreExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_preExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPreExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPreExpression(this);
		}
	}

	public final PreExpressionContext preExpression() throws RecognitionException {
		PreExpressionContext _localctx = new PreExpressionContext(_ctx, getState());
		enterRule(_localctx, 420, RULE_preExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2345);
			prefixOperator();
			setState(2346);
			unaryExpression();
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
	public static class PostfixExpressionContext extends ParserRuleContext {
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PostfixOperatorContext postfixOperator() {
			return getRuleContext(PostfixOperatorContext.class,0);
		}
		public PostfixExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPostfixExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPostfixExpression(this);
		}
	}

	public final PostfixExpressionContext postfixExpression() throws RecognitionException {
		PostfixExpressionContext _localctx = new PostfixExpressionContext(_ctx, getState());
		enterRule(_localctx, 422, RULE_postfixExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2350);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(2348);
				primary();
				}
				break;
			case 2:
				{
				setState(2349);
				expressionName();
				}
				break;
			}
			setState(2353);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,268,_ctx) ) {
			case 1:
				{
				setState(2352);
				postfixOperator();
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
	public static class PostfixOperatorContext extends ParserRuleContext {
		public TerminalNode INC() { return getToken(Ninja9Parser.INC, 0); }
		public TerminalNode DEC() { return getToken(Ninja9Parser.DEC, 0); }
		public PostfixOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixOperator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPostfixOperator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPostfixOperator(this);
		}
	}

	public final PostfixOperatorContext postfixOperator() throws RecognitionException {
		PostfixOperatorContext _localctx = new PostfixOperatorContext(_ctx, getState());
		enterRule(_localctx, 424, RULE_postfixOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2355);
			_la = _input.LA(1);
			if ( !(_la==INC || _la==DEC) ) {
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
	public static class PostExpressionContext extends ParserRuleContext {
		public PostfixOperatorContext postfixOperator() {
			return getRuleContext(PostfixOperatorContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public ExpressionNameContext expressionName() {
			return getRuleContext(ExpressionNameContext.class,0);
		}
		public PostExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterPostExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitPostExpression(this);
		}
	}

	public final PostExpressionContext postExpression() throws RecognitionException {
		PostExpressionContext _localctx = new PostExpressionContext(_ctx, getState());
		enterRule(_localctx, 426, RULE_postExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2359);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,269,_ctx) ) {
			case 1:
				{
				setState(2357);
				primary();
				}
				break;
			case 2:
				{
				setState(2358);
				expressionName();
				}
				break;
			}
			setState(2361);
			postfixOperator();
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
	public static class CastExpressionContext extends ParserRuleContext {
		public CastPrimitiveContext castPrimitive() {
			return getRuleContext(CastPrimitiveContext.class,0);
		}
		public CastReferenceContext castReference() {
			return getRuleContext(CastReferenceContext.class,0);
		}
		public CastExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castExpression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterCastExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitCastExpression(this);
		}
	}

	public final CastExpressionContext castExpression() throws RecognitionException {
		CastExpressionContext _localctx = new CastExpressionContext(_ctx, getState());
		enterRule(_localctx, 428, RULE_castExpression);
		try {
			setState(2365);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2363);
				castPrimitive();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2364);
				castReference();
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
	public static class CastPrimitiveContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public CastPrimitiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castPrimitive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterCastPrimitive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitCastPrimitive(this);
		}
	}

	public final CastPrimitiveContext castPrimitive() throws RecognitionException {
		CastPrimitiveContext _localctx = new CastPrimitiveContext(_ctx, getState());
		enterRule(_localctx, 430, RULE_castPrimitive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2367);
			match(LPAREN);
			setState(2368);
			primitiveType();
			setState(2369);
			match(RPAREN);
			setState(2370);
			unaryExpression();
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
	public static class CastReferenceContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(Ninja9Parser.LPAREN, 0); }
		public ReferenceTypeContext referenceType() {
			return getRuleContext(ReferenceTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(Ninja9Parser.RPAREN, 0); }
		public UnaryExpressionContext unaryExpression() {
			return getRuleContext(UnaryExpressionContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public List<AdditionalBoundContext> additionalBound() {
			return getRuleContexts(AdditionalBoundContext.class);
		}
		public AdditionalBoundContext additionalBound(int i) {
			return getRuleContext(AdditionalBoundContext.class,i);
		}
		public CastReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_castReference; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterCastReference(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitCastReference(this);
		}
	}

	public final CastReferenceContext castReference() throws RecognitionException {
		CastReferenceContext _localctx = new CastReferenceContext(_ctx, getState());
		enterRule(_localctx, 432, RULE_castReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2372);
			match(LPAREN);
			setState(2373);
			referenceType();
			setState(2377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITAND) {
				{
				{
				setState(2374);
				additionalBound();
				}
				}
				setState(2379);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2380);
			match(RPAREN);
			setState(2383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,272,_ctx) ) {
			case 1:
				{
				setState(2381);
				unaryExpression();
				}
				break;
			case 2:
				{
				setState(2382);
				lambdaExpression();
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
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(Ninja9Parser.Identifier, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).enterIdentifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof Ninja9Listener ) ((Ninja9Listener)listener).exitIdentifier(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 434, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2385);
			match(Identifier);
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
		case 8:
			return classType_sempred((ClassTypeContext)_localctx, predIndex);
		case 205:
			return conditionalExpression_sempred((ConditionalExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean classType_sempred(ClassTypeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean conditionalExpression_sempred(ConditionalExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 3);
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001n\u0954\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007\'\u0002"+
		"(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007,\u0002"+
		"-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u00071\u0002"+
		"2\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u00076\u0002"+
		"7\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007;\u0002"+
		"<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007@\u0002"+
		"A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007E\u0002"+
		"F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007J\u0002"+
		"K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007O\u0002"+
		"P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007T\u0002"+
		"U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007Y\u0002"+
		"Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007^\u0002"+
		"_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007c\u0002"+
		"d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007h\u0002"+
		"i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007m\u0002"+
		"n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007r\u0002"+
		"s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007w\u0002"+
		"x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007|\u0002"+
		"}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007\u0080"+
		"\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007\u0083"+
		"\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007\u0086"+
		"\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007\u0089"+
		"\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007\u008c"+
		"\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007\u008f"+
		"\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091\u0002\u0092\u0007\u0092"+
		"\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094\u0002\u0095\u0007\u0095"+
		"\u0002\u0096\u0007\u0096\u0002\u0097\u0007\u0097\u0002\u0098\u0007\u0098"+
		"\u0002\u0099\u0007\u0099\u0002\u009a\u0007\u009a\u0002\u009b\u0007\u009b"+
		"\u0002\u009c\u0007\u009c\u0002\u009d\u0007\u009d\u0002\u009e\u0007\u009e"+
		"\u0002\u009f\u0007\u009f\u0002\u00a0\u0007\u00a0\u0002\u00a1\u0007\u00a1"+
		"\u0002\u00a2\u0007\u00a2\u0002\u00a3\u0007\u00a3\u0002\u00a4\u0007\u00a4"+
		"\u0002\u00a5\u0007\u00a5\u0002\u00a6\u0007\u00a6\u0002\u00a7\u0007\u00a7"+
		"\u0002\u00a8\u0007\u00a8\u0002\u00a9\u0007\u00a9\u0002\u00aa\u0007\u00aa"+
		"\u0002\u00ab\u0007\u00ab\u0002\u00ac\u0007\u00ac\u0002\u00ad\u0007\u00ad"+
		"\u0002\u00ae\u0007\u00ae\u0002\u00af\u0007\u00af\u0002\u00b0\u0007\u00b0"+
		"\u0002\u00b1\u0007\u00b1\u0002\u00b2\u0007\u00b2\u0002\u00b3\u0007\u00b3"+
		"\u0002\u00b4\u0007\u00b4\u0002\u00b5\u0007\u00b5\u0002\u00b6\u0007\u00b6"+
		"\u0002\u00b7\u0007\u00b7\u0002\u00b8\u0007\u00b8\u0002\u00b9\u0007\u00b9"+
		"\u0002\u00ba\u0007\u00ba\u0002\u00bb\u0007\u00bb\u0002\u00bc\u0007\u00bc"+
		"\u0002\u00bd\u0007\u00bd\u0002\u00be\u0007\u00be\u0002\u00bf\u0007\u00bf"+
		"\u0002\u00c0\u0007\u00c0\u0002\u00c1\u0007\u00c1\u0002\u00c2\u0007\u00c2"+
		"\u0002\u00c3\u0007\u00c3\u0002\u00c4\u0007\u00c4\u0002\u00c5\u0007\u00c5"+
		"\u0002\u00c6\u0007\u00c6\u0002\u00c7\u0007\u00c7\u0002\u00c8\u0007\u00c8"+
		"\u0002\u00c9\u0007\u00c9\u0002\u00ca\u0007\u00ca\u0002\u00cb\u0007\u00cb"+
		"\u0002\u00cc\u0007\u00cc\u0002\u00cd\u0007\u00cd\u0002\u00ce\u0007\u00ce"+
		"\u0002\u00cf\u0007\u00cf\u0002\u00d0\u0007\u00d0\u0002\u00d1\u0007\u00d1"+
		"\u0002\u00d2\u0007\u00d2\u0002\u00d3\u0007\u00d3\u0002\u00d4\u0007\u00d4"+
		"\u0002\u00d5\u0007\u00d5\u0002\u00d6\u0007\u00d6\u0002\u00d7\u0007\u00d7"+
		"\u0002\u00d8\u0007\u00d8\u0002\u00d9\u0007\u00d9\u0001\u0000\u0003\u0000"+
		"\u01b6\b\u0000\u0001\u0000\u0005\u0000\u01b9\b\u0000\n\u0000\f\u0000\u01bc"+
		"\t\u0000\u0001\u0000\u0005\u0000\u01bf\b\u0000\n\u0000\f\u0000\u01c2\t"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u01ce"+
		"\b\u0002\u0001\u0003\u0005\u0003\u01d1\b\u0003\n\u0003\f\u0003\u01d4\t"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u01d8\b\u0003\n\u0003\f\u0003"+
		"\u01db\t\u0003\u0001\u0003\u0003\u0003\u01de\b\u0003\u0001\u0004\u0001"+
		"\u0004\u0003\u0004\u01e2\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u01eb\b\u0007\u0001"+
		"\b\u0001\b\u0005\b\u01ef\b\b\n\b\f\b\u01f2\t\b\u0001\b\u0001\b\u0003\b"+
		"\u01f6\b\b\u0001\b\u0001\b\u0001\b\u0005\b\u01fb\b\b\n\b\f\b\u01fe\t\b"+
		"\u0001\t\u0005\t\u0201\b\t\n\t\f\t\u0204\t\t\u0001\t\u0001\t\u0001\n\u0001"+
		"\n\u0004\n\u020a\b\n\u000b\n\f\n\u020b\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0003\u000b\u0211\b\u000b\u0001\f\u0004\f\u0214\b\f\u000b\f\f\f\u0215"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0005\u000e\u021c\b\u000e\n\u000e"+
		"\f\u000e\u021f\t\u000e\u0001\u000e\u0001\u000e\u0003\u000e\u0223\b\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u022a\b\u000f\n\u000f\f\u000f\u022d\t\u000f\u0003\u000f\u022f\b\u000f"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0005\u0012\u023b\b\u0012"+
		"\n\u0012\f\u0012\u023e\t\u0012\u0001\u0013\u0001\u0013\u0003\u0013\u0242"+
		"\b\u0013\u0001\u0014\u0001\u0014\u0003\u0014\u0246\b\u0014\u0001\u0015"+
		"\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017\u0252\b\u0017\u0001\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u0257\b\u0018\n\u0018\f\u0018\u025a"+
		"\t\u0018\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001a\u0001\u001a\u0003\u001a\u0263\b\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001"+
		"\u001d\u0001\u001e\u0001\u001e\u0003\u001e\u0270\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0003\u001e\u0275\b\u001e\u0001\u001e\u0001\u001e\u0003"+
		"\u001e\u0279\b\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001"+
		"\u001f\u0001\u001f\u0003\u001f\u0281\b\u001f\u0001 \u0005 \u0284\b \n"+
		" \f \u0287\t \u0001 \u0005 \u028a\b \n \f \u028d\t \u0001 \u0001 \u0001"+
		" \u0003 \u0292\b \u0001 \u0003 \u0295\b \u0001 \u0003 \u0298\b \u0001"+
		" \u0001 \u0001!\u0001!\u0001!\u0005!\u029f\b!\n!\f!\u02a2\t!\u0001\"\u0001"+
		"\"\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001$\u0001%\u0001"+
		"%\u0001%\u0005%\u02b1\b%\n%\f%\u02b4\t%\u0001&\u0001&\u0005&\u02b8\b&"+
		"\n&\f&\u02bb\t&\u0001&\u0001&\u0001\'\u0001\'\u0001\'\u0001\'\u0001\'"+
		"\u0001\'\u0001\'\u0001\'\u0003\'\u02c7\b\'\u0001(\u0005(\u02ca\b(\n(\f"+
		"(\u02cd\t(\u0001(\u0005(\u02d0\b(\n(\f(\u02d3\t(\u0001(\u0001(\u0001("+
		"\u0001(\u0001)\u0001)\u0001)\u0005)\u02dc\b)\n)\f)\u02df\t)\u0001*\u0001"+
		"*\u0001*\u0003*\u02e4\b*\u0001+\u0001+\u0005+\u02e8\b+\n+\f+\u02eb\t+"+
		"\u0001,\u0001,\u0003,\u02ef\b,\u0001-\u0001-\u0003-\u02f3\b-\u0001.\u0001"+
		".\u0003.\u02f7\b.\u0001/\u0001/\u0001/\u0003/\u02fc\b/\u00010\u00010\u0003"+
		"0\u0300\b0\u00010\u00010\u00050\u0304\b0\n0\f0\u0307\t0\u00011\u00011"+
		"\u00031\u030b\b1\u00011\u00011\u00011\u00051\u0310\b1\n1\f1\u0313\t1\u0001"+
		"1\u00011\u00031\u0317\b1\u00031\u0319\b1\u00012\u00012\u00052\u031d\b"+
		"2\n2\f2\u0320\t2\u00012\u00012\u00032\u0324\b2\u00013\u00013\u00033\u0328"+
		"\b3\u00014\u00014\u00015\u00015\u00016\u00016\u00017\u00017\u00047\u0332"+
		"\b7\u000b7\f7\u0333\u00017\u00017\u00047\u0338\b7\u000b7\f7\u0339\u0001"+
		"7\u00017\u00047\u033e\b7\u000b7\f7\u033f\u00037\u0342\b7\u00018\u0005"+
		"8\u0345\b8\n8\f8\u0348\t8\u00018\u00058\u034b\b8\n8\f8\u034e\t8\u0001"+
		"8\u00018\u00018\u00019\u00019\u00019\u00039\u0356\b9\u00019\u00019\u0005"+
		"9\u035a\b9\n9\f9\u035d\t9\u00019\u00019\u00019\u00039\u0362\b9\u00039"+
		"\u0364\b9\u0001:\u0001:\u0003:\u0368\b:\u0001;\u0001;\u0001;\u0003;\u036d"+
		"\b;\u0001;\u0001;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003<\u0377"+
		"\b<\u0001=\u0001=\u0001=\u0005=\u037c\b=\n=\f=\u037f\t=\u0001=\u0001="+
		"\u0001=\u0005=\u0384\b=\n=\f=\u0387\t=\u0003=\u0389\b=\u0001>\u0005>\u038c"+
		"\b>\n>\f>\u038f\t>\u0001>\u0005>\u0392\b>\n>\f>\u0395\t>\u0001>\u0001"+
		">\u0001>\u0001?\u0005?\u039b\b?\n?\f?\u039e\t?\u0001?\u0001?\u0005?\u03a2"+
		"\b?\n?\f?\u03a5\t?\u0001?\u0001?\u0001?\u0001?\u0003?\u03ab\b?\u0001@"+
		"\u0005@\u03ae\b@\n@\f@\u03b1\t@\u0001@\u0001@\u0001@\u0001@\u0003@\u03b7"+
		"\b@\u0001@\u0001@\u0001A\u0001A\u0001A\u0001B\u0001B\u0001B\u0005B\u03c1"+
		"\bB\nB\fB\u03c4\tB\u0001C\u0001C\u0003C\u03c8\bC\u0001D\u0001D\u0003D"+
		"\u03cc\bD\u0001E\u0001E\u0001F\u0001F\u0001F\u0001G\u0005G\u03d4\bG\n"+
		"G\fG\u03d7\tG\u0001G\u0005G\u03da\bG\nG\fG\u03dd\tG\u0001G\u0001G\u0003"+
		"G\u03e1\bG\u0001G\u0001G\u0001H\u0003H\u03e6\bH\u0001H\u0001H\u0001H\u0003"+
		"H\u03eb\bH\u0001H\u0001H\u0001I\u0001I\u0001J\u0001J\u0003J\u03f3\bJ\u0001"+
		"J\u0003J\u03f6\bJ\u0001J\u0001J\u0001K\u0003K\u03fb\bK\u0001K\u0001K\u0001"+
		"K\u0003K\u0400\bK\u0001K\u0001K\u0001K\u0003K\u0405\bK\u0001K\u0001K\u0001"+
		"K\u0003K\u040a\bK\u0001K\u0001K\u0001K\u0001K\u0001K\u0003K\u0411\bK\u0001"+
		"K\u0001K\u0001K\u0003K\u0416\bK\u0001K\u0001K\u0001K\u0001K\u0001K\u0001"+
		"K\u0003K\u041e\bK\u0001K\u0001K\u0001K\u0003K\u0423\bK\u0001K\u0001K\u0001"+
		"K\u0003K\u0428\bK\u0001L\u0005L\u042b\bL\nL\fL\u042e\tL\u0001L\u0005L"+
		"\u0431\bL\nL\fL\u0434\tL\u0001L\u0001L\u0001L\u0003L\u0439\bL\u0001L\u0001"+
		"L\u0001M\u0001M\u0003M\u043f\bM\u0001M\u0003M\u0442\bM\u0001M\u0003M\u0445"+
		"\bM\u0001M\u0001M\u0001N\u0001N\u0001N\u0005N\u044c\bN\nN\fN\u044f\tN"+
		"\u0001O\u0005O\u0452\bO\nO\fO\u0455\tO\u0001O\u0001O\u0001O\u0003O\u045a"+
		"\bO\u0001O\u0003O\u045d\bO\u0001O\u0003O\u0460\bO\u0001P\u0001P\u0005"+
		"P\u0464\bP\nP\fP\u0467\tP\u0001Q\u0001Q\u0003Q\u046b\bQ\u0001R\u0005R"+
		"\u046e\bR\nR\fR\u0471\tR\u0001R\u0005R\u0474\bR\nR\fR\u0477\tR\u0001R"+
		"\u0001R\u0001R\u0003R\u047c\bR\u0001R\u0003R\u047f\bR\u0001R\u0001R\u0001"+
		"S\u0001S\u0001S\u0001T\u0001T\u0005T\u0488\bT\nT\fT\u048b\tT\u0001T\u0001"+
		"T\u0001U\u0001U\u0001U\u0001U\u0001U\u0003U\u0494\bU\u0001V\u0005V\u0497"+
		"\bV\nV\fV\u049a\tV\u0001V\u0005V\u049d\bV\nV\fV\u04a0\tV\u0001V\u0001"+
		"V\u0001V\u0001V\u0001W\u0005W\u04a7\bW\nW\fW\u04aa\tW\u0001W\u0005W\u04ad"+
		"\bW\nW\fW\u04b0\tW\u0001W\u0003W\u04b3\bW\u0001W\u0001W\u0001W\u0001X"+
		"\u0005X\u04b9\bX\nX\fX\u04bc\tX\u0001X\u0005X\u04bf\bX\nX\fX\u04c2\tX"+
		"\u0001X\u0001X\u0001X\u0001X\u0001X\u0001Y\u0001Y\u0005Y\u04cb\bY\nY\f"+
		"Y\u04ce\tY\u0001Y\u0001Y\u0001Z\u0001Z\u0001Z\u0001Z\u0001Z\u0003Z\u04d7"+
		"\bZ\u0001[\u0005[\u04da\b[\n[\f[\u04dd\t[\u0001[\u0005[\u04e0\b[\n[\f"+
		"[\u04e3\t[\u0001[\u0001[\u0001[\u0001[\u0001[\u0005[\u04ea\b[\n[\f[\u04ed"+
		"\t[\u0001[\u0003[\u04f0\b[\u0001[\u0001[\u0001\\\u0001\\\u0001\\\u0001"+
		"]\u0001]\u0001]\u0003]\u04fa\b]\u0001^\u0001^\u0001^\u0001^\u0003^\u0500"+
		"\b^\u0001^\u0001^\u0001_\u0001_\u0001_\u0005_\u0507\b_\n_\f_\u050a\t_"+
		"\u0001`\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0003a\u0513\ba\u0001"+
		"b\u0001b\u0003b\u0517\bb\u0001b\u0003b\u051a\bb\u0001b\u0001b\u0001c\u0001"+
		"c\u0001c\u0005c\u0521\bc\nc\fc\u0524\tc\u0001d\u0001d\u0001d\u0001e\u0001"+
		"e\u0001e\u0001e\u0001e\u0001e\u0001f\u0001f\u0003f\u0531\bf\u0001f\u0003"+
		"f\u0534\bf\u0001f\u0001f\u0001g\u0001g\u0001g\u0005g\u053b\bg\ng\fg\u053e"+
		"\tg\u0001h\u0001h\u0005h\u0542\bh\nh\fh\u0545\th\u0001h\u0001h\u0001i"+
		"\u0004i\u054a\bi\u000bi\fi\u054b\u0001j\u0001j\u0001j\u0003j\u0551\bj"+
		"\u0001k\u0001k\u0001k\u0001l\u0005l\u0557\bl\nl\fl\u055a\tl\u0001l\u0005"+
		"l\u055d\bl\nl\fl\u0560\tl\u0001l\u0001l\u0001l\u0001m\u0001m\u0001m\u0001"+
		"m\u0001m\u0001m\u0003m\u056b\bm\u0001n\u0001n\u0001n\u0001n\u0001n\u0003"+
		"n\u0572\bn\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001o\u0001"+
		"o\u0001o\u0001o\u0001o\u0003o\u0580\bo\u0001p\u0001p\u0001q\u0001q\u0001"+
		"q\u0001q\u0001r\u0001r\u0001r\u0001r\u0001s\u0001s\u0001s\u0001t\u0001"+
		"t\u0001t\u0001t\u0001t\u0003t\u0594\bt\u0001u\u0001u\u0001v\u0001v\u0001"+
		"w\u0001w\u0001x\u0001x\u0001y\u0001y\u0001z\u0001z\u0001z\u0001z\u0001"+
		"z\u0001z\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001{\u0001"+
		"|\u0001|\u0001|\u0001|\u0001|\u0001|\u0001|\u0001|\u0001}\u0001}\u0001"+
		"}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0001}\u0003}\u05c0\b}\u0001"+
		"~\u0001~\u0001~\u0001~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0005\u007f"+
		"\u05ca\b\u007f\n\u007f\f\u007f\u05cd\t\u007f\u0001\u007f\u0003\u007f\u05d0"+
		"\b\u007f\u0001\u007f\u0001\u007f\u0001\u0080\u0001\u0080\u0001\u0080\u0001"+
		"\u0080\u0003\u0080\u05d8\b\u0080\u0001\u0081\u0001\u0081\u0001\u0081\u0003"+
		"\u0081\u05dd\b\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0001\u0082\u0001"+
		"\u0082\u0001\u0082\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001"+
		"\u0083\u0001\u0083\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001"+
		"\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0085\u0001\u0085\u0003"+
		"\u0085\u05f5\b\u0085\u0001\u0086\u0001\u0086\u0003\u0086\u05f9\b\u0086"+
		"\u0001\u0087\u0001\u0087\u0001\u0087\u0003\u0087\u05fe\b\u0087\u0001\u0087"+
		"\u0001\u0087\u0003\u0087\u0602\b\u0087\u0001\u0087\u0001\u0087\u0003\u0087"+
		"\u0606\b\u0087\u0001\u0087\u0001\u0087\u0001\u0087\u0001\u0088\u0001\u0088"+
		"\u0001\u0088\u0003\u0088\u060e\b\u0088\u0001\u0088\u0001\u0088\u0003\u0088"+
		"\u0612\b\u0088\u0001\u0088\u0001\u0088\u0003\u0088\u0616\b\u0088\u0001"+
		"\u0088\u0001\u0088\u0001\u0088\u0001\u0089\u0001\u0089\u0003\u0089\u061d"+
		"\b\u0089\u0001\u008a\u0001\u008a\u0001\u008b\u0001\u008b\u0001\u008b\u0005"+
		"\u008b\u0624\b\u008b\n\u008b\f\u008b\u0627\t\u008b\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0005\u008c\u062c\b\u008c\n\u008c\f\u008c\u062f\t\u008c\u0001"+
		"\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001"+
		"\u008c\u0001\u008d\u0001\u008d\u0001\u008d\u0005\u008d\u063b\b\u008d\n"+
		"\u008d\f\u008d\u063e\t\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001"+
		"\u008d\u0001\u008d\u0001\u008d\u0001\u008d\u0001\u008e\u0001\u008e\u0003"+
		"\u008e\u0649\b\u008e\u0001\u008e\u0001\u008e\u0001\u008f\u0001\u008f\u0003"+
		"\u008f\u064f\b\u008f\u0001\u008f\u0001\u008f\u0001\u0090\u0001\u0090\u0003"+
		"\u0090\u0655\b\u0090\u0001\u0090\u0001\u0090\u0001\u0091\u0001\u0091\u0001"+
		"\u0091\u0001\u0091\u0001\u0092\u0001\u0092\u0001\u0092\u0001\u0092\u0001"+
		"\u0092\u0001\u0092\u0001\u0093\u0001\u0093\u0003\u0093\u0665\b\u0093\u0001"+
		"\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0094\u0001"+
		"\u0094\u0003\u0094\u066e\b\u0094\u0001\u0094\u0001\u0094\u0003\u0094\u0672"+
		"\b\u0094\u0001\u0095\u0001\u0095\u0005\u0095\u0676\b\u0095\n\u0095\f\u0095"+
		"\u0679\t\u0095\u0001\u0096\u0001\u0096\u0001\u0096\u0005\u0096\u067e\b"+
		"\u0096\n\u0096\f\u0096\u0681\t\u0096\u0001\u0096\u0001\u0096\u0001\u0096"+
		"\u0005\u0096\u0686\b\u0096\n\u0096\f\u0096\u0689\t\u0096\u0001\u0096\u0001"+
		"\u0096\u0001\u0096\u0001\u0096\u0001\u0097\u0001\u0097\u0001\u0097\u0001"+
		"\u0098\u0001\u0098\u0001\u0098\u0001\u0098\u0003\u0098\u0696\b\u0098\u0001"+
		"\u0098\u0003\u0098\u0699\b\u0098\u0001\u0099\u0001\u0099\u0001\u0099\u0003"+
		"\u0099\u069e\b\u0099\u0001\u0099\u0001\u0099\u0001\u009a\u0001\u009a\u0001"+
		"\u009a\u0005\u009a\u06a5\b\u009a\n\u009a\f\u009a\u06a8\t\u009a\u0001\u009b"+
		"\u0005\u009b\u06ab\b\u009b\n\u009b\f\u009b\u06ae\t\u009b\u0001\u009b\u0001"+
		"\u009b\u0001\u009b\u0001\u009b\u0001\u009b\u0001\u009c\u0001\u009c\u0003"+
		"\u009c\u06b7\b\u009c\u0001\u009c\u0005\u009c\u06ba\b\u009c\n\u009c\f\u009c"+
		"\u06bd\t\u009c\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009d\u0001\u009e"+
		"\u0001\u009e\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0005\u009f"+
		"\u06c9\b\u009f\n\u009f\f\u009f\u06cc\t\u009f\u0001\u009f\u0001\u009f\u0001"+
		"\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001"+
		"\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001\u009f\u0001"+
		"\u009f\u0001\u009f\u0003\u009f\u06de\b\u009f\u0001\u00a0\u0001\u00a0\u0001"+
		"\u00a0\u0001\u00a0\u0001\u00a0\u0003\u00a0\u06e5\b\u00a0\u0001\u00a1\u0001"+
		"\u00a1\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0003\u00a2\u06ed"+
		"\b\u00a2\u0001\u00a3\u0001\u00a3\u0005\u00a3\u06f1\b\u00a3\n\u00a3\f\u00a3"+
		"\u06f4\t\u00a3\u0001\u00a3\u0001\u00a3\u0001\u00a3\u0001\u00a4\u0001\u00a4"+
		"\u0001\u00a4\u0003\u00a4\u06fc\b\u00a4\u0001\u00a5\u0001\u00a5\u0001\u00a6"+
		"\u0001\u00a6\u0001\u00a6\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7"+
		"\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7"+
		"\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0003\u00a7\u0710\b\u00a7\u0001\u00a8"+
		"\u0001\u00a8\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9"+
		"\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9"+
		"\u0001\u00a9\u0003\u00a9\u0720\b\u00a9\u0001\u00aa\u0001\u00aa\u0001\u00ab"+
		"\u0001\u00ab\u0003\u00ab\u0726\b\u00ab\u0001\u00ab\u0001\u00ab\u0003\u00ab"+
		"\u072a\b\u00ab\u0001\u00ab\u0001\u00ab\u0003\u00ab\u072e\b\u00ab\u0001"+
		"\u00ab\u0001\u00ab\u0003\u00ab\u0732\b\u00ab\u0001\u00ac\u0001\u00ac\u0001"+
		"\u00ac\u0003\u00ac\u0737\b\u00ac\u0001\u00ac\u0005\u00ac\u073a\b\u00ac"+
		"\n\u00ac\f\u00ac\u073d\t\u00ac\u0001\u00ac\u0001\u00ac\u0003\u00ac\u0741"+
		"\b\u00ac\u0001\u00ac\u0001\u00ac\u0003\u00ac\u0745\b\u00ac\u0001\u00ac"+
		"\u0001\u00ac\u0003\u00ac\u0749\b\u00ac\u0001\u00ad\u0001\u00ad\u0003\u00ad"+
		"\u074d\b\u00ad\u0001\u00ad\u0005\u00ad\u0750\b\u00ad\n\u00ad\f\u00ad\u0753"+
		"\t\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0005\u00ad\u0758\b\u00ad"+
		"\n\u00ad\f\u00ad\u075b\t\u00ad\u0001\u00ad\u0005\u00ad\u075e\b\u00ad\n"+
		"\u00ad\f\u00ad\u0761\t\u00ad\u0001\u00ad\u0003\u00ad\u0764\b\u00ad\u0001"+
		"\u00ad\u0001\u00ad\u0003\u00ad\u0768\b\u00ad\u0001\u00ad\u0001\u00ad\u0003"+
		"\u00ad\u076c\b\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0003"+
		"\u00ad\u0772\b\u00ad\u0001\u00ad\u0005\u00ad\u0775\b\u00ad\n\u00ad\f\u00ad"+
		"\u0778\t\u00ad\u0001\u00ad\u0001\u00ad\u0003\u00ad\u077c\b\u00ad\u0001"+
		"\u00ad\u0001\u00ad\u0003\u00ad\u0780\b\u00ad\u0001\u00ad\u0001\u00ad\u0003"+
		"\u00ad\u0784\b\u00ad\u0003\u00ad\u0786\b\u00ad\u0001\u00ae\u0001\u00ae"+
		"\u0001\u00ae\u0003\u00ae\u078b\b\u00ae\u0001\u00af\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0001\u00af\u0001\u00af\u0001\u00af\u0003\u00af\u079a\b\u00af"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b1\u0001\u00b1\u0001\u00b1"+
		"\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0001\u00b1"+
		"\u0003\u00b1\u07a8\b\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2"+
		"\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2"+
		"\u0003\u00b2\u07b4\b\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2"+
		"\u0001\u00b2\u0005\u00b2\u07bb\b\u00b2\n\u00b2\f\u00b2\u07be\t\u00b2\u0001"+
		"\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001"+
		"\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0005\u00b3\u07ca\b\u00b3\n"+
		"\u00b3\f\u00b3\u07cd\t\u00b3\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001"+
		"\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001"+
		"\u00b4\u0003\u00b4\u07d9\b\u00b4\u0001\u00b4\u0001\u00b4\u0001\u00b4\u0001"+
		"\u00b4\u0001\u00b4\u0005\u00b4\u07e0\b\u00b4\n\u00b4\f\u00b4\u07e3\t\u00b4"+
		"\u0001\u00b5\u0003\u00b5\u07e6\b\u00b5\u0001\u00b5\u0003\u00b5\u07e9\b"+
		"\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0003\u00b5\u07ee\b\u00b5\u0001"+
		"\u00b5\u0001\u00b5\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001"+
		"\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0003"+
		"\u00b6\u07fc\b\u00b6\u0001\u00b7\u0001\u00b7\u0003\u00b7\u0800\b\u00b7"+
		"\u0001\u00b7\u0001\u00b7\u0001\u00b7\u0003\u00b7\u0805\b\u00b7\u0001\u00b7"+
		"\u0001\u00b7\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8\u080c\b\u00b8"+
		"\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8"+
		"\u0813\b\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8\u0818\b"+
		"\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003"+
		"\u00b8\u081f\b\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8\u0824"+
		"\b\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003"+
		"\u00b8\u082b\b\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8\u0830"+
		"\b\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0001\u00b8\u0003\u00b8\u0839\b\u00b8\u0001\u00b8\u0001\u00b8\u0001"+
		"\u00b8\u0003\u00b8\u083e\b\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8\u0842"+
		"\b\u00b8\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0005\u00b9\u0847\b\u00b9"+
		"\n\u00b9\f\u00b9\u084a\t\u00b9\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0003"+
		"\u00ba\u084f\b\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001"+
		"\u00ba\u0003\u00ba\u0856\b\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001"+
		"\u00ba\u0001\u00ba\u0003\u00ba\u085d\b\u00ba\u0001\u00ba\u0001\u00ba\u0001"+
		"\u00ba\u0001\u00ba\u0001\u00ba\u0003\u00ba\u0864\b\u00ba\u0001\u00ba\u0001"+
		"\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0003\u00ba\u086c"+
		"\b\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0003"+
		"\u00ba\u0873\b\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001"+
		"\u00ba\u0001\u00ba\u0003\u00ba\u087b\b\u00ba\u0001\u00bb\u0001\u00bb\u0003"+
		"\u00bb\u087f\b\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0003\u00bc\u0886\b\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bc\u0003\u00bc\u088d\b\u00bc\u0001\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bc\u0001\u00bc\u0003\u00bc\u0894\b\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0003\u00bc\u089c"+
		"\b\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0003"+
		"\u00bc\u08a3\b\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001"+
		"\u00bc\u0001\u00bc\u0003\u00bc\u08ab\b\u00bc\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0003\u00bd\u08b1\b\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0003\u00bd\u08b7\b\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0001\u00bd\u0003\u00bd\u08c3\b\u00bd\u0001\u00be\u0001\u00be\u0005"+
		"\u00be\u08c7\b\u00be\n\u00be\f\u00be\u08ca\t\u00be\u0001\u00bf\u0005\u00bf"+
		"\u08cd\b\u00bf\n\u00bf\f\u00bf\u08d0\t\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0003\u00c0\u08d9"+
		"\b\u00c0\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c2\u0001"+
		"\u00c2\u0001\u00c2\u0003\u00c2\u08e2\b\u00c2\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0001\u00c3\u0001\u00c4\u0001\u00c4\u0001\u00c5\u0001\u00c5\u0003"+
		"\u00c5\u08ec\b\u00c5\u0001\u00c5\u0001\u00c5\u0001\u00c6\u0001\u00c6\u0001"+
		"\u00c6\u0005\u00c6\u08f3\b\u00c6\n\u00c6\f\u00c6\u08f6\t\u00c6\u0001\u00c7"+
		"\u0001\u00c7\u0003\u00c7\u08fa\b\u00c7\u0001\u00c8\u0001\u00c8\u0001\u00c9"+
		"\u0001\u00c9\u0001\u00c9\u0001\u00c9\u0001\u00ca\u0001\u00ca\u0001\u00ca"+
		"\u0003\u00ca\u0905\b\u00ca\u0001\u00cb\u0001\u00cb\u0001\u00cc\u0001\u00cc"+
		"\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0001\u00cd"+
		"\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0001\u00cd\u0001\u00cd"+
		"\u0001\u00cd\u0005\u00cd\u0918\b\u00cd\n\u00cd\f\u00cd\u091b\t\u00cd\u0001"+
		"\u00ce\u0001\u00ce\u0001\u00ce\u0001\u00ce\u0003\u00ce\u0921\b\u00ce\u0001"+
		"\u00cf\u0001\u00cf\u0001\u00cf\u0001\u00d0\u0001\u00d0\u0001\u00d1\u0001"+
		"\u00d1\u0001\u00d2\u0001\u00d2\u0001\u00d2\u0001\u00d3\u0001\u00d3\u0003"+
		"\u00d3\u092f\b\u00d3\u0001\u00d3\u0003\u00d3\u0932\b\u00d3\u0001\u00d4"+
		"\u0001\u00d4\u0001\u00d5\u0001\u00d5\u0003\u00d5\u0938\b\u00d5\u0001\u00d5"+
		"\u0001\u00d5\u0001\u00d6\u0001\u00d6\u0003\u00d6\u093e\b\u00d6\u0001\u00d7"+
		"\u0001\u00d7\u0001\u00d7\u0001\u00d7\u0001\u00d7\u0001\u00d8\u0001\u00d8"+
		"\u0001\u00d8\u0005\u00d8\u0948\b\u00d8\n\u00d8\f\u00d8\u094b\t\u00d8\u0001"+
		"\u00d8\u0001\u00d8\u0001\u00d8\u0003\u00d8\u0950\b\u00d8\u0001\u00d9\u0001"+
		"\u00d9\u0001\u00d9\u0000\u0002\u0010\u019a\u00da\u0000\u0002\u0004\u0006"+
		"\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e \"$&(*,."+
		"02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086\u0088"+
		"\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e\u00a0"+
		"\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8"+
		"\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0"+
		"\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6\u00e8"+
		"\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe\u0100"+
		"\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116\u0118"+
		"\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e\u0130"+
		"\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146\u0148"+
		"\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e\u0160"+
		"\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176\u0178"+
		"\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u018e\u0190"+
		"\u0192\u0194\u0196\u0198\u019a\u019c\u019e\u01a0\u01a2\u01a4\u01a6\u01a8"+
		"\u01aa\u01ac\u01ae\u01b0\u01b2\u0000\b\b\u0000\u0004\u0004\u0015\u0015"+
		"!!$&)*--1144\u0005\u0000\b\b\u000b\u000b\u001e\u001e  ((\u0002\u0000\u0011"+
		"\u0011\u0017\u0017\u0002\u0000\u0014\u0014++\u0002\u0000EE^h\u0005\u0000"+
		"\u0001\u0003\u001d\u001dFGLQT[\u0002\u0000HITU\u0001\u0000RS\u09ee\u0000"+
		"\u01b5\u0001\u0000\u0000\u0000\u0002\u01c5\u0001\u0000\u0000\u0000\u0004"+
		"\u01cd\u0001\u0000\u0000\u0000\u0006\u01dd\u0001\u0000\u0000\u0000\b\u01e1"+
		"\u0001\u0000\u0000\u0000\n\u01e3\u0001\u0000\u0000\u0000\f\u01e5\u0001"+
		"\u0000\u0000\u0000\u000e\u01ea\u0001\u0000\u0000\u0000\u0010\u01ec\u0001"+
		"\u0000\u0000\u0000\u0012\u0202\u0001\u0000\u0000\u0000\u0014\u0207\u0001"+
		"\u0000\u0000\u0000\u0016\u0210\u0001\u0000\u0000\u0000\u0018\u0213\u0001"+
		"\u0000\u0000\u0000\u001a\u0217\u0001\u0000\u0000\u0000\u001c\u021d\u0001"+
		"\u0000\u0000\u0000\u001e\u022e\u0001\u0000\u0000\u0000 \u0230\u0001\u0000"+
		"\u0000\u0000\"\u0233\u0001\u0000\u0000\u0000$\u0237\u0001\u0000\u0000"+
		"\u0000&\u0241\u0001\u0000\u0000\u0000(\u0243\u0001\u0000\u0000\u0000*"+
		"\u0247\u0001\u0000\u0000\u0000,\u024a\u0001\u0000\u0000\u0000.\u0251\u0001"+
		"\u0000\u0000\u00000\u0253\u0001\u0000\u0000\u00002\u025b\u0001\u0000\u0000"+
		"\u00004\u0262\u0001\u0000\u0000\u00006\u0264\u0001\u0000\u0000\u00008"+
		"\u0268\u0001\u0000\u0000\u0000:\u026a\u0001\u0000\u0000\u0000<\u026d\u0001"+
		"\u0000\u0000\u0000>\u0280\u0001\u0000\u0000\u0000@\u0285\u0001\u0000\u0000"+
		"\u0000B\u029b\u0001\u0000\u0000\u0000D\u02a3\u0001\u0000\u0000\u0000F"+
		"\u02a7\u0001\u0000\u0000\u0000H\u02aa\u0001\u0000\u0000\u0000J\u02ad\u0001"+
		"\u0000\u0000\u0000L\u02b5\u0001\u0000\u0000\u0000N\u02c6\u0001\u0000\u0000"+
		"\u0000P\u02cb\u0001\u0000\u0000\u0000R\u02d8\u0001\u0000\u0000\u0000T"+
		"\u02e0\u0001\u0000\u0000\u0000V\u02e5\u0001\u0000\u0000\u0000X\u02ee\u0001"+
		"\u0000\u0000\u0000Z\u02f2\u0001\u0000\u0000\u0000\\\u02f6\u0001\u0000"+
		"\u0000\u0000^\u02fb\u0001\u0000\u0000\u0000`\u02ff\u0001\u0000\u0000\u0000"+
		"b\u0318\u0001\u0000\u0000\u0000d\u031a\u0001\u0000\u0000\u0000f\u0325"+
		"\u0001\u0000\u0000\u0000h\u0329\u0001\u0000\u0000\u0000j\u032b\u0001\u0000"+
		"\u0000\u0000l\u032d\u0001\u0000\u0000\u0000n\u0341\u0001\u0000\u0000\u0000"+
		"p\u0346\u0001\u0000\u0000\u0000r\u0363\u0001\u0000\u0000\u0000t\u0367"+
		"\u0001\u0000\u0000\u0000v\u0369\u0001\u0000\u0000\u0000x\u0376\u0001\u0000"+
		"\u0000\u0000z\u0388\u0001\u0000\u0000\u0000|\u038d\u0001\u0000\u0000\u0000"+
		"~\u03aa\u0001\u0000\u0000\u0000\u0080\u03af\u0001\u0000\u0000\u0000\u0082"+
		"\u03ba\u0001\u0000\u0000\u0000\u0084\u03bd\u0001\u0000\u0000\u0000\u0086"+
		"\u03c7\u0001\u0000\u0000\u0000\u0088\u03cb\u0001\u0000\u0000\u0000\u008a"+
		"\u03cd\u0001\u0000\u0000\u0000\u008c\u03cf\u0001\u0000\u0000\u0000\u008e"+
		"\u03d5\u0001\u0000\u0000\u0000\u0090\u03e5\u0001\u0000\u0000\u0000\u0092"+
		"\u03ee\u0001\u0000\u0000\u0000\u0094\u03f0\u0001\u0000\u0000\u0000\u0096"+
		"\u0427\u0001\u0000\u0000\u0000\u0098\u042c\u0001\u0000\u0000\u0000\u009a"+
		"\u043c\u0001\u0000\u0000\u0000\u009c\u0448\u0001\u0000\u0000\u0000\u009e"+
		"\u0453\u0001\u0000\u0000\u0000\u00a0\u0461\u0001\u0000\u0000\u0000\u00a2"+
		"\u046a\u0001\u0000\u0000\u0000\u00a4\u046f\u0001\u0000\u0000\u0000\u00a6"+
		"\u0482\u0001\u0000\u0000\u0000\u00a8\u0485\u0001\u0000\u0000\u0000\u00aa"+
		"\u0493\u0001\u0000\u0000\u0000\u00ac\u0498\u0001\u0000\u0000\u0000\u00ae"+
		"\u04a8\u0001\u0000\u0000\u0000\u00b0\u04ba\u0001\u0000\u0000\u0000\u00b2"+
		"\u04c8\u0001\u0000\u0000\u0000\u00b4\u04d6\u0001\u0000\u0000\u0000\u00b6"+
		"\u04db\u0001\u0000\u0000\u0000\u00b8\u04f3\u0001\u0000\u0000\u0000\u00ba"+
		"\u04f9\u0001\u0000\u0000\u0000\u00bc\u04fb\u0001\u0000\u0000\u0000\u00be"+
		"\u0503\u0001\u0000\u0000\u0000\u00c0\u050b\u0001\u0000\u0000\u0000\u00c2"+
		"\u0512\u0001\u0000\u0000\u0000\u00c4\u0514\u0001\u0000\u0000\u0000\u00c6"+
		"\u051d\u0001\u0000\u0000\u0000\u00c8\u0525\u0001\u0000\u0000\u0000\u00ca"+
		"\u0528\u0001\u0000\u0000\u0000\u00cc\u052e\u0001\u0000\u0000\u0000\u00ce"+
		"\u0537\u0001\u0000\u0000\u0000\u00d0\u053f\u0001\u0000\u0000\u0000\u00d2"+
		"\u0549\u0001\u0000\u0000\u0000\u00d4\u0550\u0001\u0000\u0000\u0000\u00d6"+
		"\u0552\u0001\u0000\u0000\u0000\u00d8\u0558\u0001\u0000\u0000\u0000\u00da"+
		"\u056a\u0001\u0000\u0000\u0000\u00dc\u0571\u0001\u0000\u0000\u0000\u00de"+
		"\u057f\u0001\u0000\u0000\u0000\u00e0\u0581\u0001\u0000\u0000\u0000\u00e2"+
		"\u0583\u0001\u0000\u0000\u0000\u00e4\u0587\u0001\u0000\u0000\u0000\u00e6"+
		"\u058b\u0001\u0000\u0000\u0000\u00e8\u0593\u0001\u0000\u0000\u0000\u00ea"+
		"\u0595\u0001\u0000\u0000\u0000\u00ec\u0597\u0001\u0000\u0000\u0000\u00ee"+
		"\u0599\u0001\u0000\u0000\u0000\u00f0\u059b\u0001\u0000\u0000\u0000\u00f2"+
		"\u059d\u0001\u0000\u0000\u0000\u00f4\u059f\u0001\u0000\u0000\u0000\u00f6"+
		"\u05a5\u0001\u0000\u0000\u0000\u00f8\u05ad\u0001\u0000\u0000\u0000\u00fa"+
		"\u05bf\u0001\u0000\u0000\u0000\u00fc\u05c1\u0001\u0000\u0000\u0000\u00fe"+
		"\u05c7\u0001\u0000\u0000\u0000\u0100\u05d3\u0001\u0000\u0000\u0000\u0102"+
		"\u05d9\u0001\u0000\u0000\u0000\u0104\u05de\u0001\u0000\u0000\u0000\u0106"+
		"\u05e4\u0001\u0000\u0000\u0000\u0108\u05ea\u0001\u0000\u0000\u0000\u010a"+
		"\u05f4\u0001\u0000\u0000\u0000\u010c\u05f8\u0001\u0000\u0000\u0000\u010e"+
		"\u05fa\u0001\u0000\u0000\u0000\u0110\u060a\u0001\u0000\u0000\u0000\u0112"+
		"\u061c\u0001\u0000\u0000\u0000\u0114\u061e\u0001\u0000\u0000\u0000\u0116"+
		"\u0620\u0001\u0000\u0000\u0000\u0118\u0628\u0001\u0000\u0000\u0000\u011a"+
		"\u0637\u0001\u0000\u0000\u0000\u011c\u0646\u0001\u0000\u0000\u0000\u011e"+
		"\u064c\u0001\u0000\u0000\u0000\u0120\u0652\u0001\u0000\u0000\u0000\u0122"+
		"\u0658\u0001\u0000\u0000\u0000\u0124\u065c\u0001\u0000\u0000\u0000\u0126"+
		"\u0664\u0001\u0000\u0000\u0000\u0128\u0671\u0001\u0000\u0000\u0000\u012a"+
		"\u0673\u0001\u0000\u0000\u0000\u012c\u067a\u0001\u0000\u0000\u0000\u012e"+
		"\u068e\u0001\u0000\u0000\u0000\u0130\u0691\u0001\u0000\u0000\u0000\u0132"+
		"\u069a\u0001\u0000\u0000\u0000\u0134\u06a1\u0001\u0000\u0000\u0000\u0136"+
		"\u06ac\u0001\u0000\u0000\u0000\u0138\u06b6\u0001\u0000\u0000\u0000\u013a"+
		"\u06be\u0001\u0000\u0000\u0000\u013c\u06c2\u0001\u0000\u0000\u0000\u013e"+
		"\u06dd\u0001\u0000\u0000\u0000\u0140\u06e4\u0001\u0000\u0000\u0000\u0142"+
		"\u06e6\u0001\u0000\u0000\u0000\u0144\u06ec\u0001\u0000\u0000\u0000\u0146"+
		"\u06ee\u0001\u0000\u0000\u0000\u0148\u06fb\u0001\u0000\u0000\u0000\u014a"+
		"\u06fd\u0001\u0000\u0000\u0000\u014c\u06ff\u0001\u0000\u0000\u0000\u014e"+
		"\u070f\u0001\u0000\u0000\u0000\u0150\u0711\u0001\u0000\u0000\u0000\u0152"+
		"\u071f\u0001\u0000\u0000\u0000\u0154\u0721\u0001\u0000\u0000\u0000\u0156"+
		"\u0723\u0001\u0000\u0000\u0000\u0158\u0733\u0001\u0000\u0000\u0000\u015a"+
		"\u0785\u0001\u0000\u0000\u0000\u015c\u078a\u0001\u0000\u0000\u0000\u015e"+
		"\u0799\u0001\u0000\u0000\u0000\u0160\u079b\u0001\u0000\u0000\u0000\u0162"+
		"\u07a7\u0001\u0000\u0000\u0000\u0164\u07b3\u0001\u0000\u0000\u0000\u0166"+
		"\u07bf\u0001\u0000\u0000\u0000\u0168\u07d8\u0001\u0000\u0000\u0000\u016a"+
		"\u07e5\u0001\u0000\u0000\u0000\u016c\u07fb\u0001\u0000\u0000\u0000\u016e"+
		"\u07fd\u0001\u0000\u0000\u0000\u0170\u0841\u0001\u0000\u0000\u0000\u0172"+
		"\u0843\u0001\u0000\u0000\u0000\u0174\u087a\u0001\u0000\u0000\u0000\u0176"+
		"\u087c\u0001\u0000\u0000\u0000\u0178\u08aa\u0001\u0000\u0000\u0000\u017a"+
		"\u08c2\u0001\u0000\u0000\u0000\u017c\u08c4\u0001\u0000\u0000\u0000\u017e"+
		"\u08ce\u0001\u0000\u0000\u0000\u0180\u08d8\u0001\u0000\u0000\u0000\u0182"+
		"\u08da\u0001\u0000\u0000\u0000\u0184\u08e1\u0001\u0000\u0000\u0000\u0186"+
		"\u08e3\u0001\u0000\u0000\u0000\u0188\u08e7\u0001\u0000\u0000\u0000\u018a"+
		"\u08e9\u0001\u0000\u0000\u0000\u018c\u08ef\u0001\u0000\u0000\u0000\u018e"+
		"\u08f9\u0001\u0000\u0000\u0000\u0190\u08fb\u0001\u0000\u0000\u0000\u0192"+
		"\u08fd\u0001\u0000\u0000\u0000\u0194\u0904\u0001\u0000\u0000\u0000\u0196"+
		"\u0906\u0001\u0000\u0000\u0000\u0198\u0908\u0001\u0000\u0000\u0000\u019a"+
		"\u090a\u0001\u0000\u0000\u0000\u019c\u0920\u0001\u0000\u0000\u0000\u019e"+
		"\u0922\u0001\u0000\u0000\u0000\u01a0\u0925\u0001\u0000\u0000\u0000\u01a2"+
		"\u0927\u0001\u0000\u0000\u0000\u01a4\u0929\u0001\u0000\u0000\u0000\u01a6"+
		"\u092e\u0001\u0000\u0000\u0000\u01a8\u0933\u0001\u0000\u0000\u0000\u01aa"+
		"\u0937\u0001\u0000\u0000\u0000\u01ac\u093d\u0001\u0000\u0000\u0000\u01ae"+
		"\u093f\u0001\u0000\u0000\u0000\u01b0\u0944\u0001\u0000\u0000\u0000\u01b2"+
		"\u0951\u0001\u0000\u0000\u0000\u01b4\u01b6\u00036\u001b\u0000\u01b5\u01b4"+
		"\u0001\u0000\u0000\u0000\u01b5\u01b6\u0001\u0000\u0000\u0000\u01b6\u01ba"+
		"\u0001\u0000\u0000\u0000\u01b7\u01b9\u0003<\u001e\u0000\u01b8\u01b7\u0001"+
		"\u0000\u0000\u0000\u01b9\u01bc\u0001\u0000\u0000\u0000\u01ba\u01b8\u0001"+
		"\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01c0\u0001"+
		"\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bd\u01bf\u0003"+
		">\u001f\u0000\u01be\u01bd\u0001\u0000\u0000\u0000\u01bf\u01c2\u0001\u0000"+
		"\u0000\u0000\u01c0\u01be\u0001\u0000\u0000\u0000\u01c0\u01c1\u0001\u0000"+
		"\u0000\u0000\u01c1\u01c3\u0001\u0000\u0000\u0000\u01c2\u01c0\u0001\u0000"+
		"\u0000\u0000\u01c3\u01c4\u0005\u0000\u0000\u0001\u01c4\u0001\u0001\u0000"+
		"\u0000\u0000\u01c5\u01c6\u0007\u0000\u0000\u0000\u01c6\u0003\u0001\u0000"+
		"\u0000\u0000\u01c7\u01ce\u00056\u0000\u0000\u01c8\u01ce\u00057\u0000\u0000"+
		"\u01c9\u01ce\u00058\u0000\u0000\u01ca\u01ce\u00059\u0000\u0000\u01cb\u01ce"+
		"\u0005:\u0000\u0000\u01cc\u01ce\u0005;\u0000\u0000\u01cd\u01c7\u0001\u0000"+
		"\u0000\u0000\u01cd\u01c8\u0001\u0000\u0000\u0000\u01cd\u01c9\u0001\u0000"+
		"\u0000\u0000\u01cd\u01ca\u0001\u0000\u0000\u0000\u01cd\u01cb\u0001\u0000"+
		"\u0000\u0000\u01cd\u01cc\u0001\u0000\u0000\u0000\u01ce\u0005\u0001\u0000"+
		"\u0000\u0000\u01cf\u01d1\u0003\u00ba]\u0000\u01d0\u01cf\u0001\u0000\u0000"+
		"\u0000\u01d1\u01d4\u0001\u0000\u0000\u0000\u01d2\u01d0\u0001\u0000\u0000"+
		"\u0000\u01d2\u01d3\u0001\u0000\u0000\u0000\u01d3\u01d5\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d2\u0001\u0000\u0000\u0000\u01d5\u01de\u0003\b\u0004\u0000"+
		"\u01d6\u01d8\u0003\u00ba]\u0000\u01d7\u01d6\u0001\u0000\u0000\u0000\u01d8"+
		"\u01db\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000\u01d9"+
		"\u01da\u0001\u0000\u0000\u0000\u01da\u01dc\u0001\u0000\u0000\u0000\u01db"+
		"\u01d9\u0001\u0000\u0000\u0000\u01dc\u01de\u0005\u0006\u0000\u0000\u01dd"+
		"\u01d2\u0001\u0000\u0000\u0000\u01dd\u01d9\u0001\u0000\u0000\u0000\u01de"+
		"\u0007\u0001\u0000\u0000\u0000\u01df\u01e2\u0003\n\u0005\u0000\u01e0\u01e2"+
		"\u0003\f\u0006\u0000\u01e1\u01df\u0001\u0000\u0000\u0000\u01e1\u01e0\u0001"+
		"\u0000\u0000\u0000\u01e2\t\u0001\u0000\u0000\u0000\u01e3\u01e4\u0007\u0001"+
		"\u0000\u0000\u01e4\u000b\u0001\u0000\u0000\u0000\u01e5\u01e6\u0007\u0002"+
		"\u0000\u0000\u01e6\r\u0001\u0000\u0000\u0000\u01e7\u01eb\u0003\u0010\b"+
		"\u0000\u01e8\u01eb\u0003\u0012\t\u0000\u01e9\u01eb\u0003\u0014\n\u0000"+
		"\u01ea\u01e7\u0001\u0000\u0000\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000"+
		"\u01ea\u01e9\u0001\u0000\u0000\u0000\u01eb\u000f\u0001\u0000\u0000\u0000"+
		"\u01ec\u01f0\u0006\b\uffff\uffff\u0000\u01ed\u01ef\u0003\u00ba]\u0000"+
		"\u01ee\u01ed\u0001\u0000\u0000\u0000\u01ef\u01f2\u0001\u0000\u0000\u0000"+
		"\u01f0\u01ee\u0001\u0000\u0000\u0000\u01f0\u01f1\u0001\u0000\u0000\u0000"+
		"\u01f1\u01f3\u0001\u0000\u0000\u0000\u01f2\u01f0\u0001\u0000\u0000\u0000"+
		"\u01f3\u01f5\u0003\u01b2\u00d9\u0000\u01f4\u01f6\u0003\"\u0011\u0000\u01f5"+
		"\u01f4\u0001\u0000\u0000\u0000\u01f5\u01f6\u0001\u0000\u0000\u0000\u01f6"+
		"\u01fc\u0001\u0000\u0000\u0000\u01f7\u01f8\n\u0001\u0000\u0000\u01f8\u01f9"+
		"\u0005D\u0000\u0000\u01f9\u01fb\u0003\u0010\b\u0002\u01fa\u01f7\u0001"+
		"\u0000\u0000\u0000\u01fb\u01fe\u0001\u0000\u0000\u0000\u01fc\u01fa\u0001"+
		"\u0000\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd\u0011\u0001"+
		"\u0000\u0000\u0000\u01fe\u01fc\u0001\u0000\u0000\u0000\u01ff\u0201\u0003"+
		"\u00ba]\u0000\u0200\u01ff\u0001\u0000\u0000\u0000\u0201\u0204\u0001\u0000"+
		"\u0000\u0000\u0202\u0200\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000"+
		"\u0000\u0000\u0203\u0205\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000"+
		"\u0000\u0000\u0205\u0206\u0003\u01b2\u00d9\u0000\u0206\u0013\u0001\u0000"+
		"\u0000\u0000\u0207\u0209\u0003\u0016\u000b\u0000\u0208\u020a\u0003\u001a"+
		"\r\u0000\u0209\u0208\u0001\u0000\u0000\u0000\u020a\u020b\u0001\u0000\u0000"+
		"\u0000\u020b\u0209\u0001\u0000\u0000\u0000\u020b\u020c\u0001\u0000\u0000"+
		"\u0000\u020c\u0015\u0001\u0000\u0000\u0000\u020d\u0211\u0003\u0006\u0003"+
		"\u0000\u020e\u0211\u0003\u0010\b\u0000\u020f\u0211\u0003\u0012\t\u0000"+
		"\u0210\u020d\u0001\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000\u0000"+
		"\u0210\u020f\u0001\u0000\u0000\u0000\u0211\u0017\u0001\u0000\u0000\u0000"+
		"\u0212\u0214\u0003\u001a\r\u0000\u0213\u0212\u0001\u0000\u0000\u0000\u0214"+
		"\u0215\u0001\u0000\u0000\u0000\u0215\u0213\u0001\u0000\u0000\u0000\u0215"+
		"\u0216\u0001\u0000\u0000\u0000\u0216\u0019\u0001\u0000\u0000\u0000\u0217"+
		"\u0218\u0005@\u0000\u0000\u0218\u0219\u0005A\u0000\u0000\u0219\u001b\u0001"+
		"\u0000\u0000\u0000\u021a\u021c\u0003\u00ba]\u0000\u021b\u021a\u0001\u0000"+
		"\u0000\u0000\u021c\u021f\u0001\u0000\u0000\u0000\u021d\u021b\u0001\u0000"+
		"\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e\u0220\u0001\u0000"+
		"\u0000\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u0220\u0222\u0003\u01b2"+
		"\u00d9\u0000\u0221\u0223\u0003\u001e\u000f\u0000\u0222\u0221\u0001\u0000"+
		"\u0000\u0000\u0222\u0223\u0001\u0000\u0000\u0000\u0223\u001d\u0001\u0000"+
		"\u0000\u0000\u0224\u0225\u0005\u0014\u0000\u0000\u0225\u022f\u0003\u0012"+
		"\t\u0000\u0226\u0227\u0005\u0014\u0000\u0000\u0227\u022b\u0003\u0010\b"+
		"\u0000\u0228\u022a\u0003 \u0010\u0000\u0229\u0228\u0001\u0000\u0000\u0000"+
		"\u022a\u022d\u0001\u0000\u0000\u0000\u022b\u0229\u0001\u0000\u0000\u0000"+
		"\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u022f\u0001\u0000\u0000\u0000"+
		"\u022d\u022b\u0001\u0000\u0000\u0000\u022e\u0224\u0001\u0000\u0000\u0000"+
		"\u022e\u0226\u0001\u0000\u0000\u0000\u022f\u001f\u0001\u0000\u0000\u0000"+
		"\u0230\u0231\u0005X\u0000\u0000\u0231\u0232\u0003\u0010\b\u0000\u0232"+
		"!\u0001\u0000\u0000\u0000\u0233\u0234\u0005G\u0000\u0000\u0234\u0235\u0003"+
		"$\u0012\u0000\u0235\u0236\u0005F\u0000\u0000\u0236#\u0001\u0000\u0000"+
		"\u0000\u0237\u023c\u0003&\u0013\u0000\u0238\u0239\u0005C\u0000\u0000\u0239"+
		"\u023b\u0003&\u0013\u0000\u023a\u0238\u0001\u0000\u0000\u0000\u023b\u023e"+
		"\u0001\u0000\u0000\u0000\u023c\u023a\u0001\u0000\u0000\u0000\u023c\u023d"+
		"\u0001\u0000\u0000\u0000\u023d%\u0001\u0000\u0000\u0000\u023e\u023c\u0001"+
		"\u0000\u0000\u0000\u023f\u0242\u0003\u000e\u0007\u0000\u0240\u0242\u0003"+
		"(\u0014\u0000\u0241\u023f\u0001\u0000\u0000\u0000\u0241\u0240\u0001\u0000"+
		"\u0000\u0000\u0242\'\u0001\u0000\u0000\u0000\u0243\u0245\u0005J\u0000"+
		"\u0000\u0244\u0246\u0003*\u0015\u0000\u0245\u0244\u0001\u0000\u0000\u0000"+
		"\u0245\u0246\u0001\u0000\u0000\u0000\u0246)\u0001\u0000\u0000\u0000\u0247"+
		"\u0248\u0003,\u0016\u0000\u0248\u0249\u0003\u000e\u0007\u0000\u0249+\u0001"+
		"\u0000\u0000\u0000\u024a\u024b\u0007\u0003\u0000\u0000\u024b-\u0001\u0000"+
		"\u0000\u0000\u024c\u0252\u0005i\u0000\u0000\u024d\u024e\u00032\u0019\u0000"+
		"\u024e\u024f\u0005D\u0000\u0000\u024f\u0250\u0005i\u0000\u0000\u0250\u0252"+
		"\u0001\u0000\u0000\u0000\u0251\u024c\u0001\u0000\u0000\u0000\u0251\u024d"+
		"\u0001\u0000\u0000\u0000\u0252/\u0001\u0000\u0000\u0000\u0253\u0258\u0005"+
		"i\u0000\u0000\u0254\u0255\u0005D\u0000\u0000\u0255\u0257\u0005i\u0000"+
		"\u0000\u0256\u0254\u0001\u0000\u0000\u0000\u0257\u025a\u0001\u0000\u0000"+
		"\u0000\u0258\u0256\u0001\u0000\u0000\u0000\u0258\u0259\u0001\u0000\u0000"+
		"\u0000\u02591\u0001\u0000\u0000\u0000\u025a\u0258\u0001\u0000\u0000\u0000"+
		"\u025b\u025c\u00030\u0018\u0000\u025c3\u0001\u0000\u0000\u0000\u025d\u0263"+
		"\u0005i\u0000\u0000\u025e\u025f\u00030\u0018\u0000\u025f\u0260\u0005D"+
		"\u0000\u0000\u0260\u0261\u0005i\u0000\u0000\u0261\u0263\u0001\u0000\u0000"+
		"\u0000\u0262\u025d\u0001\u0000\u0000\u0000\u0262\u025e\u0001\u0000\u0000"+
		"\u0000\u02635\u0001\u0000\u0000\u0000\u0264\u0265\u0005#\u0000\u0000\u0265"+
		"\u0266\u00032\u0019\u0000\u0266\u0267\u0005B\u0000\u0000\u02677\u0001"+
		"\u0000\u0000\u0000\u0268\u0269\u0005)\u0000\u0000\u02699\u0001\u0000\u0000"+
		"\u0000\u026a\u026b\u0005D\u0000\u0000\u026b\u026c\u0005V\u0000\u0000\u026c"+
		";\u0001\u0000\u0000\u0000\u026d\u026f\u0005\u001c\u0000\u0000\u026e\u0270"+
		"\u00038\u001c\u0000\u026f\u026e\u0001\u0000\u0000\u0000\u026f\u0270\u0001"+
		"\u0000\u0000\u0000\u0270\u0274\u0001\u0000\u0000\u0000\u0271\u0272\u0003"+
		"2\u0019\u0000\u0272\u0273\u0005D\u0000\u0000\u0273\u0275\u0001\u0000\u0000"+
		"\u0000\u0274\u0271\u0001\u0000\u0000\u0000\u0274\u0275\u0001\u0000\u0000"+
		"\u0000\u0275\u0276\u0001\u0000\u0000\u0000\u0276\u0278\u0003.\u0017\u0000"+
		"\u0277\u0279\u0003:\u001d\u0000\u0278\u0277\u0001\u0000\u0000\u0000\u0278"+
		"\u0279\u0001\u0000\u0000\u0000\u0279\u027a\u0001\u0000\u0000\u0000\u027a"+
		"\u027b\u0005B\u0000\u0000\u027b=\u0001\u0000\u0000\u0000\u027c\u0281\u0003"+
		"@ \u0000\u027d\u0281\u0003\u0098L\u0000\u027e\u0281\u0003\u00a2Q\u0000"+
		"\u027f\u0281\u0005B\u0000\u0000\u0280\u027c\u0001\u0000\u0000\u0000\u0280"+
		"\u027d\u0001\u0000\u0000\u0000\u0280\u027e\u0001\u0000\u0000\u0000\u0280"+
		"\u027f\u0001\u0000\u0000\u0000\u0281?\u0001\u0000\u0000\u0000\u0282\u0284"+
		"\u0003\u00ba]\u0000\u0283\u0282\u0001\u0000\u0000\u0000\u0284\u0287\u0001"+
		"\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000\u0000\u0285\u0286\u0001"+
		"\u0000\u0000\u0000\u0286\u028b\u0001\u0000\u0000\u0000\u0287\u0285\u0001"+
		"\u0000\u0000\u0000\u0288\u028a\u0003\u0002\u0001\u0000\u0289\u0288\u0001"+
		"\u0000\u0000\u0000\u028a\u028d\u0001\u0000\u0000\u0000\u028b\u0289\u0001"+
		"\u0000\u0000\u0000\u028b\u028c\u0001\u0000\u0000\u0000\u028c\u028e\u0001"+
		"\u0000\u0000\u0000\u028d\u028b\u0001\u0000\u0000\u0000\u028e\u028f\u0005"+
		"\f\u0000\u0000\u028f\u0291\u0003\u01b2\u00d9\u0000\u0290\u0292\u0003D"+
		"\"\u0000\u0291\u0290\u0001\u0000\u0000\u0000\u0291\u0292\u0001\u0000\u0000"+
		"\u0000\u0292\u0294\u0001\u0000\u0000\u0000\u0293\u0295\u0003F#\u0000\u0294"+
		"\u0293\u0001\u0000\u0000\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295"+
		"\u0297\u0001\u0000\u0000\u0000\u0296\u0298\u0003H$\u0000\u0297\u0296\u0001"+
		"\u0000\u0000\u0000\u0297\u0298\u0001\u0000\u0000\u0000\u0298\u0299\u0001"+
		"\u0000\u0000\u0000\u0299\u029a\u0003L&\u0000\u029aA\u0001\u0000\u0000"+
		"\u0000\u029b\u02a0\u0003\u001c\u000e\u0000\u029c\u029d\u0005C\u0000\u0000"+
		"\u029d\u029f\u0003\u001c\u000e\u0000\u029e\u029c\u0001\u0000\u0000\u0000"+
		"\u029f\u02a2\u0001\u0000\u0000\u0000\u02a0\u029e\u0001\u0000\u0000\u0000"+
		"\u02a0\u02a1\u0001\u0000\u0000\u0000\u02a1C\u0001\u0000\u0000\u0000\u02a2"+
		"\u02a0\u0001\u0000\u0000\u0000\u02a3\u02a4\u0005G\u0000\u0000\u02a4\u02a5"+
		"\u0003B!\u0000\u02a5\u02a6\u0005F\u0000\u0000\u02a6E\u0001\u0000\u0000"+
		"\u0000\u02a7\u02a8\u0005\u0014\u0000\u0000\u02a8\u02a9\u0003\u0010\b\u0000"+
		"\u02a9G\u0001\u0000\u0000\u0000\u02aa\u02ab\u0005\u001b\u0000\u0000\u02ab"+
		"\u02ac\u0003J%\u0000\u02acI\u0001\u0000\u0000\u0000\u02ad\u02b2\u0003"+
		"\u0010\b\u0000\u02ae\u02af\u0005C\u0000\u0000\u02af\u02b1\u0003\u0010"+
		"\b\u0000\u02b0\u02ae\u0001\u0000\u0000\u0000\u02b1\u02b4\u0001\u0000\u0000"+
		"\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000"+
		"\u0000\u02b3K\u0001\u0000\u0000\u0000\u02b4\u02b2\u0001\u0000\u0000\u0000"+
		"\u02b5\u02b9\u0005>\u0000\u0000\u02b6\u02b8\u0003N\'\u0000\u02b7\u02b6"+
		"\u0001\u0000\u0000\u0000\u02b8\u02bb\u0001\u0000\u0000\u0000\u02b9\u02b7"+
		"\u0001\u0000\u0000\u0000\u02b9\u02ba\u0001\u0000\u0000\u0000\u02ba\u02bc"+
		"\u0001\u0000\u0000\u0000\u02bb\u02b9\u0001\u0000\u0000\u0000\u02bc\u02bd"+
		"\u0005?\u0000\u0000\u02bdM\u0001\u0000\u0000\u0000\u02be\u02c7\u0003P"+
		"(\u0000\u02bf\u02c7\u0003p8\u0000\u02c0\u02c7\u0003@ \u0000\u02c1\u02c7"+
		"\u0003\u00a2Q\u0000\u02c2\u02c7\u0003\u00e0p\u0000\u02c3\u02c7\u0003\u008a"+
		"E\u0000\u02c4\u02c7\u0003\u008cF\u0000\u02c5\u02c7\u0003\u008eG\u0000"+
		"\u02c6\u02be\u0001\u0000\u0000\u0000\u02c6\u02bf\u0001\u0000\u0000\u0000"+
		"\u02c6\u02c0\u0001\u0000\u0000\u0000\u02c6\u02c1\u0001\u0000\u0000\u0000"+
		"\u02c6\u02c2\u0001\u0000\u0000\u0000\u02c6\u02c3\u0001\u0000\u0000\u0000"+
		"\u02c6\u02c4\u0001\u0000\u0000\u0000\u02c6\u02c5\u0001\u0000\u0000\u0000"+
		"\u02c7O\u0001\u0000\u0000\u0000\u02c8\u02ca\u0003\u00ba]\u0000\u02c9\u02c8"+
		"\u0001\u0000\u0000\u0000\u02ca\u02cd\u0001\u0000\u0000\u0000\u02cb\u02c9"+
		"\u0001\u0000\u0000\u0000\u02cb\u02cc\u0001\u0000\u0000\u0000\u02cc\u02d1"+
		"\u0001\u0000\u0000\u0000\u02cd\u02cb\u0001\u0000\u0000\u0000\u02ce\u02d0"+
		"\u0003\u0002\u0001\u0000\u02cf\u02ce\u0001\u0000\u0000\u0000\u02d0\u02d3"+
		"\u0001\u0000\u0000\u0000\u02d1\u02cf\u0001\u0000\u0000\u0000\u02d1\u02d2"+
		"\u0001\u0000\u0000\u0000\u02d2\u02d4\u0001\u0000\u0000\u0000\u02d3\u02d1"+
		"\u0001\u0000\u0000\u0000\u02d4\u02d5\u0003Z-\u0000\u02d5\u02d6\u0003R"+
		")\u0000\u02d6\u02d7\u0005B\u0000\u0000\u02d7Q\u0001\u0000\u0000\u0000"+
		"\u02d8\u02dd\u0003T*\u0000\u02d9\u02da\u0005C\u0000\u0000\u02da\u02dc"+
		"\u0003T*\u0000\u02db\u02d9\u0001\u0000\u0000\u0000\u02dc\u02df\u0001\u0000"+
		"\u0000\u0000\u02dd\u02db\u0001\u0000\u0000\u0000\u02dd\u02de\u0001\u0000"+
		"\u0000\u0000\u02deS\u0001\u0000\u0000\u0000\u02df\u02dd\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e3\u0003V+\u0000\u02e1\u02e2\u0005E\u0000\u0000\u02e2"+
		"\u02e4\u0003X,\u0000\u02e3\u02e1\u0001\u0000\u0000\u0000\u02e3\u02e4\u0001"+
		"\u0000\u0000\u0000\u02e4U\u0001\u0000\u0000\u0000\u02e5\u02e9\u0003\u01b2"+
		"\u00d9\u0000\u02e6\u02e8\u0003\u001a\r\u0000\u02e7\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e8\u02eb\u0001\u0000\u0000\u0000\u02e9\u02e7\u0001\u0000\u0000"+
		"\u0000\u02e9\u02ea\u0001\u0000\u0000\u0000\u02eaW\u0001\u0000\u0000\u0000"+
		"\u02eb\u02e9\u0001\u0000\u0000\u0000\u02ec\u02ef\u0003\u0180\u00c0\u0000"+
		"\u02ed\u02ef\u0003\u00ccf\u0000\u02ee\u02ec\u0001\u0000\u0000\u0000\u02ee"+
		"\u02ed\u0001\u0000\u0000\u0000\u02efY\u0001\u0000\u0000\u0000\u02f0\u02f3"+
		"\u0003\\.\u0000\u02f1\u02f3\u0003^/\u0000\u02f2\u02f0\u0001\u0000\u0000"+
		"\u0000\u02f2\u02f1\u0001\u0000\u0000\u0000\u02f3[\u0001\u0000\u0000\u0000"+
		"\u02f4\u02f7\u0003\b\u0004\u0000\u02f5\u02f7\u0005\u0006\u0000\u0000\u02f6"+
		"\u02f4\u0001\u0000\u0000\u0000\u02f6\u02f5\u0001\u0000\u0000\u0000\u02f7"+
		"]\u0001\u0000\u0000\u0000\u02f8\u02fc\u0003`0\u0000\u02f9\u02fc\u0003"+
		"l6\u0000\u02fa\u02fc\u0003n7\u0000\u02fb\u02f8\u0001\u0000\u0000\u0000"+
		"\u02fb\u02f9\u0001\u0000\u0000\u0000\u02fb\u02fa\u0001\u0000\u0000\u0000"+
		"\u02fc_\u0001\u0000\u0000\u0000\u02fd\u0300\u0003f3\u0000\u02fe\u0300"+
		"\u0003j5\u0000\u02ff\u02fd\u0001\u0000\u0000\u0000\u02ff\u02fe\u0001\u0000"+
		"\u0000\u0000\u0300\u0305\u0001\u0000\u0000\u0000\u0301\u0304\u0003d2\u0000"+
		"\u0302\u0304\u0003h4\u0000\u0303\u0301\u0001\u0000\u0000\u0000\u0303\u0302"+
		"\u0001\u0000\u0000\u0000\u0304\u0307\u0001\u0000\u0000\u0000\u0305\u0303"+
		"\u0001\u0000\u0000\u0000\u0305\u0306\u0001\u0000\u0000\u0000\u0306a\u0001"+
		"\u0000\u0000\u0000\u0307\u0305\u0001\u0000\u0000\u0000\u0308\u030a\u0005"+
		"i\u0000\u0000\u0309\u030b\u0003\"\u0011\u0000\u030a\u0309\u0001\u0000"+
		"\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000\u030b\u0319\u0001\u0000"+
		"\u0000\u0000\u030c\u030d\u0003`0\u0000\u030d\u0311\u0005D\u0000\u0000"+
		"\u030e\u0310\u0003\u00ba]\u0000\u030f\u030e\u0001\u0000\u0000\u0000\u0310"+
		"\u0313\u0001\u0000\u0000\u0000\u0311\u030f\u0001\u0000\u0000\u0000\u0311"+
		"\u0312\u0001\u0000\u0000\u0000\u0312\u0314\u0001\u0000\u0000\u0000\u0313"+
		"\u0311\u0001\u0000\u0000\u0000\u0314\u0316\u0005i\u0000\u0000\u0315\u0317"+
		"\u0003\"\u0011\u0000\u0316\u0315\u0001\u0000\u0000\u0000\u0316\u0317\u0001"+
		"\u0000\u0000\u0000\u0317\u0319\u0001\u0000\u0000\u0000\u0318\u0308\u0001"+
		"\u0000\u0000\u0000\u0318\u030c\u0001\u0000\u0000\u0000\u0319c\u0001\u0000"+
		"\u0000\u0000\u031a\u031e\u0005D\u0000\u0000\u031b\u031d\u0003\u00ba]\u0000"+
		"\u031c\u031b\u0001\u0000\u0000\u0000\u031d\u0320\u0001\u0000\u0000\u0000"+
		"\u031e\u031c\u0001\u0000\u0000\u0000\u031e\u031f\u0001\u0000\u0000\u0000"+
		"\u031f\u0321\u0001\u0000\u0000\u0000\u0320\u031e\u0001\u0000\u0000\u0000"+
		"\u0321\u0323\u0005i\u0000\u0000\u0322\u0324\u0003\"\u0011\u0000\u0323"+
		"\u0322\u0001\u0000\u0000\u0000\u0323\u0324\u0001\u0000\u0000\u0000\u0324"+
		"e\u0001\u0000\u0000\u0000\u0325\u0327\u0005i\u0000\u0000\u0326\u0328\u0003"+
		"\"\u0011\u0000\u0327\u0326\u0001\u0000\u0000\u0000\u0327\u0328\u0001\u0000"+
		"\u0000\u0000\u0328g\u0001\u0000\u0000\u0000\u0329\u032a\u0003d2\u0000"+
		"\u032ai\u0001\u0000\u0000\u0000\u032b\u032c\u0003f3\u0000\u032ck\u0001"+
		"\u0000\u0000\u0000\u032d\u032e\u0005i\u0000\u0000\u032em\u0001\u0000\u0000"+
		"\u0000\u032f\u0331\u0003\\.\u0000\u0330\u0332\u0003\u001a\r\u0000\u0331"+
		"\u0330\u0001\u0000\u0000\u0000\u0332\u0333\u0001\u0000\u0000\u0000\u0333"+
		"\u0331\u0001\u0000\u0000\u0000\u0333\u0334\u0001\u0000\u0000\u0000\u0334"+
		"\u0342\u0001\u0000\u0000\u0000\u0335\u0337\u0003`0\u0000\u0336\u0338\u0003"+
		"\u001a\r\u0000\u0337\u0336\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000"+
		"\u0000\u0000\u0339\u0337\u0001\u0000\u0000\u0000\u0339\u033a\u0001\u0000"+
		"\u0000\u0000\u033a\u0342\u0001\u0000\u0000\u0000\u033b\u033d\u0003l6\u0000"+
		"\u033c\u033e\u0003\u001a\r\u0000\u033d\u033c\u0001\u0000\u0000\u0000\u033e"+
		"\u033f\u0001\u0000\u0000\u0000\u033f\u033d\u0001\u0000\u0000\u0000\u033f"+
		"\u0340\u0001\u0000\u0000\u0000\u0340\u0342\u0001\u0000\u0000\u0000\u0341"+
		"\u032f\u0001\u0000\u0000\u0000\u0341\u0335\u0001\u0000\u0000\u0000\u0341"+
		"\u033b\u0001\u0000\u0000\u0000\u0342o\u0001\u0000\u0000\u0000\u0343\u0345"+
		"\u0003\u00ba]\u0000\u0344\u0343\u0001\u0000\u0000\u0000\u0345\u0348\u0001"+
		"\u0000\u0000\u0000\u0346\u0344\u0001\u0000\u0000\u0000\u0346\u0347\u0001"+
		"\u0000\u0000\u0000\u0347\u034c\u0001\u0000\u0000\u0000\u0348\u0346\u0001"+
		"\u0000\u0000\u0000\u0349\u034b\u0003\u0002\u0001\u0000\u034a\u0349\u0001"+
		"\u0000\u0000\u0000\u034b\u034e\u0001\u0000\u0000\u0000\u034c\u034a\u0001"+
		"\u0000\u0000\u0000\u034c\u034d\u0001\u0000\u0000\u0000\u034d\u034f\u0001"+
		"\u0000\u0000\u0000\u034e\u034c\u0001\u0000\u0000\u0000\u034f\u0350\u0003"+
		"r9\u0000\u0350\u0351\u0003\u0088D\u0000\u0351q\u0001\u0000\u0000\u0000"+
		"\u0352\u0353\u0003t:\u0000\u0353\u0355\u0003v;\u0000\u0354\u0356\u0003"+
		"\u0082A\u0000\u0355\u0354\u0001\u0000\u0000\u0000\u0355\u0356\u0001\u0000"+
		"\u0000\u0000\u0356\u0364\u0001\u0000\u0000\u0000\u0357\u035b\u0003D\""+
		"\u0000\u0358\u035a\u0003\u00ba]\u0000\u0359\u0358\u0001\u0000\u0000\u0000"+
		"\u035a\u035d\u0001\u0000\u0000\u0000\u035b\u0359\u0001\u0000\u0000\u0000"+
		"\u035b\u035c\u0001\u0000\u0000\u0000\u035c\u035e\u0001\u0000\u0000\u0000"+
		"\u035d\u035b\u0001\u0000\u0000\u0000\u035e\u035f\u0003t:\u0000\u035f\u0361"+
		"\u0003v;\u0000\u0360\u0362\u0003\u0082A\u0000\u0361\u0360\u0001\u0000"+
		"\u0000\u0000\u0361\u0362\u0001\u0000\u0000\u0000\u0362\u0364\u0001\u0000"+
		"\u0000\u0000\u0363\u0352\u0001\u0000\u0000\u0000\u0363\u0357\u0001\u0000"+
		"\u0000\u0000\u0364s\u0001\u0000\u0000\u0000\u0365\u0368\u0003Z-\u0000"+
		"\u0366\u0368\u00053\u0000\u0000\u0367\u0365\u0001\u0000\u0000\u0000\u0367"+
		"\u0366\u0001\u0000\u0000\u0000\u0368u\u0001\u0000\u0000\u0000\u0369\u036a"+
		"\u0003\u01b2\u00d9\u0000\u036a\u036c\u0005<\u0000\u0000\u036b\u036d\u0003"+
		"x<\u0000\u036c\u036b\u0001\u0000\u0000\u0000\u036c\u036d\u0001\u0000\u0000"+
		"\u0000\u036d\u036e\u0001\u0000\u0000\u0000\u036e\u036f\u0005=\u0000\u0000"+
		"\u036fw\u0001\u0000\u0000\u0000\u0370\u0377\u0003\u0080@\u0000\u0371\u0372"+
		"\u0003z=\u0000\u0372\u0373\u0005C\u0000\u0000\u0373\u0374\u0003~?\u0000"+
		"\u0374\u0377\u0001\u0000\u0000\u0000\u0375\u0377\u0003~?\u0000\u0376\u0370"+
		"\u0001\u0000\u0000\u0000\u0376\u0371\u0001\u0000\u0000\u0000\u0376\u0375"+
		"\u0001\u0000\u0000\u0000\u0377y\u0001\u0000\u0000\u0000\u0378\u037d\u0003"+
		"|>\u0000\u0379\u037a\u0005C\u0000\u0000\u037a\u037c\u0003|>\u0000\u037b"+
		"\u0379\u0001\u0000\u0000\u0000\u037c\u037f\u0001\u0000\u0000\u0000\u037d"+
		"\u037b\u0001\u0000\u0000\u0000\u037d\u037e\u0001\u0000\u0000\u0000\u037e"+
		"\u0389\u0001\u0000\u0000\u0000\u037f\u037d\u0001\u0000\u0000\u0000\u0380"+
		"\u0385\u0003\u0080@\u0000\u0381\u0382\u0005C\u0000\u0000\u0382\u0384\u0003"+
		"|>\u0000\u0383\u0381\u0001\u0000\u0000\u0000\u0384\u0387\u0001\u0000\u0000"+
		"\u0000\u0385\u0383\u0001\u0000\u0000\u0000\u0385\u0386\u0001\u0000\u0000"+
		"\u0000\u0386\u0389\u0001\u0000\u0000\u0000\u0387\u0385\u0001\u0000\u0000"+
		"\u0000\u0388\u0378\u0001\u0000\u0000\u0000\u0388\u0380\u0001\u0000\u0000"+
		"\u0000\u0389{\u0001\u0000\u0000\u0000\u038a\u038c\u0003\u00ba]\u0000\u038b"+
		"\u038a\u0001\u0000\u0000\u0000\u038c\u038f\u0001\u0000\u0000\u0000\u038d"+
		"\u038b\u0001\u0000\u0000\u0000\u038d\u038e\u0001\u0000\u0000\u0000\u038e"+
		"\u0393\u0001\u0000\u0000\u0000\u038f\u038d\u0001\u0000\u0000\u0000\u0390"+
		"\u0392\u0003\u0002\u0001\u0000\u0391\u0390\u0001\u0000\u0000\u0000\u0392"+
		"\u0395\u0001\u0000\u0000\u0000\u0393\u0391\u0001\u0000\u0000\u0000\u0393"+
		"\u0394\u0001\u0000\u0000\u0000\u0394\u0396\u0001\u0000\u0000\u0000\u0395"+
		"\u0393\u0001\u0000\u0000\u0000\u0396\u0397\u0003Z-\u0000\u0397\u0398\u0003"+
		"V+\u0000\u0398}\u0001\u0000\u0000\u0000\u0399\u039b\u0003\u0002\u0001"+
		"\u0000\u039a\u0399\u0001\u0000\u0000\u0000\u039b\u039e\u0001\u0000\u0000"+
		"\u0000\u039c\u039a\u0001\u0000\u0000\u0000\u039c\u039d\u0001\u0000\u0000"+
		"\u0000\u039d\u039f\u0001\u0000\u0000\u0000\u039e\u039c\u0001\u0000\u0000"+
		"\u0000\u039f\u03a3\u0003Z-\u0000\u03a0\u03a2\u0003\u00ba]\u0000\u03a1"+
		"\u03a0\u0001\u0000\u0000\u0000\u03a2\u03a5\u0001\u0000\u0000\u0000\u03a3"+
		"\u03a1\u0001\u0000\u0000\u0000\u03a3\u03a4\u0001\u0000\u0000\u0000\u03a4"+
		"\u03a6\u0001\u0000\u0000\u0000\u03a5\u03a3\u0001\u0000\u0000\u0000\u03a6"+
		"\u03a7\u0005k\u0000\u0000\u03a7\u03a8\u0003V+\u0000\u03a8\u03ab\u0001"+
		"\u0000\u0000\u0000\u03a9\u03ab\u0003|>\u0000\u03aa\u039c\u0001\u0000\u0000"+
		"\u0000\u03aa\u03a9\u0001\u0000\u0000\u0000\u03ab\u007f\u0001\u0000\u0000"+
		"\u0000\u03ac\u03ae\u0003\u00ba]\u0000\u03ad\u03ac\u0001\u0000\u0000\u0000"+
		"\u03ae\u03b1\u0001\u0000\u0000\u0000\u03af\u03ad\u0001\u0000\u0000\u0000"+
		"\u03af\u03b0\u0001\u0000\u0000\u0000\u03b0\u03b2\u0001\u0000\u0000\u0000"+
		"\u03b1\u03af\u0001\u0000\u0000\u0000\u03b2\u03b6\u0003Z-\u0000\u03b3\u03b4"+
		"\u0003\u01b2\u00d9\u0000\u03b4\u03b5\u0005D\u0000\u0000\u03b5\u03b7\u0001"+
		"\u0000\u0000\u0000\u03b6\u03b3\u0001\u0000\u0000\u0000\u03b6\u03b7\u0001"+
		"\u0000\u0000\u0000\u03b7\u03b8\u0001\u0000\u0000\u0000\u03b8\u03b9\u0005"+
		".\u0000\u0000\u03b9\u0081\u0001\u0000\u0000\u0000\u03ba\u03bb\u00050\u0000"+
		"\u0000\u03bb\u03bc\u0003\u0084B\u0000\u03bc\u0083\u0001\u0000\u0000\u0000"+
		"\u03bd\u03c2\u0003\u0086C\u0000\u03be\u03bf\u0005C\u0000\u0000\u03bf\u03c1"+
		"\u0003\u0086C\u0000\u03c0\u03be\u0001\u0000\u0000\u0000\u03c1\u03c4\u0001"+
		"\u0000\u0000\u0000\u03c2\u03c0\u0001\u0000\u0000\u0000\u03c2\u03c3\u0001"+
		"\u0000\u0000\u0000\u03c3\u0085\u0001\u0000\u0000\u0000\u03c4\u03c2\u0001"+
		"\u0000\u0000\u0000\u03c5\u03c8\u0003\u0010\b\u0000\u03c6\u03c8\u0003\u0012"+
		"\t\u0000\u03c7\u03c5\u0001\u0000\u0000\u0000\u03c7\u03c6\u0001\u0000\u0000"+
		"\u0000\u03c8\u0087\u0001\u0000\u0000\u0000\u03c9\u03cc\u0003\u00d0h\u0000"+
		"\u03ca\u03cc\u0005B\u0000\u0000\u03cb\u03c9\u0001\u0000\u0000\u0000\u03cb"+
		"\u03ca\u0001\u0000\u0000\u0000\u03cc\u0089\u0001\u0000\u0000\u0000\u03cd"+
		"\u03ce\u0003\u00d0h\u0000\u03ce\u008b\u0001\u0000\u0000\u0000\u03cf\u03d0"+
		"\u0005)\u0000\u0000\u03d0\u03d1\u0003\u00d0h\u0000\u03d1\u008d\u0001\u0000"+
		"\u0000\u0000\u03d2\u03d4\u0003\u00ba]\u0000\u03d3\u03d2\u0001\u0000\u0000"+
		"\u0000\u03d4\u03d7\u0001\u0000\u0000\u0000\u03d5\u03d3\u0001\u0000\u0000"+
		"\u0000\u03d5\u03d6\u0001\u0000\u0000\u0000\u03d6\u03db\u0001\u0000\u0000"+
		"\u0000\u03d7\u03d5\u0001\u0000\u0000\u0000\u03d8\u03da\u0003\u0002\u0001"+
		"\u0000\u03d9\u03d8\u0001\u0000\u0000\u0000\u03da\u03dd\u0001\u0000\u0000"+
		"\u0000\u03db\u03d9\u0001\u0000\u0000\u0000\u03db\u03dc\u0001\u0000\u0000"+
		"\u0000\u03dc\u03de\u0001\u0000\u0000\u0000\u03dd\u03db\u0001\u0000\u0000"+
		"\u0000\u03de\u03e0\u0003\u0090H\u0000\u03df\u03e1\u0003\u0082A\u0000\u03e0"+
		"\u03df\u0001\u0000\u0000\u0000\u03e0\u03e1\u0001\u0000\u0000\u0000\u03e1"+
		"\u03e2\u0001\u0000\u0000\u0000\u03e2\u03e3\u0003\u0094J\u0000\u03e3\u008f"+
		"\u0001\u0000\u0000\u0000\u03e4\u03e6\u0003D\"\u0000\u03e5\u03e4\u0001"+
		"\u0000\u0000\u0000\u03e5\u03e6\u0001\u0000\u0000\u0000\u03e6\u03e7\u0001"+
		"\u0000\u0000\u0000\u03e7\u03e8\u0003\u0092I\u0000\u03e8\u03ea\u0005<\u0000"+
		"\u0000\u03e9\u03eb\u0003x<\u0000\u03ea\u03e9\u0001\u0000\u0000\u0000\u03ea"+
		"\u03eb\u0001\u0000\u0000\u0000\u03eb\u03ec\u0001\u0000\u0000\u0000\u03ec"+
		"\u03ed\u0005=\u0000\u0000\u03ed\u0091\u0001\u0000\u0000\u0000\u03ee\u03ef"+
		"\u0005i\u0000\u0000\u03ef\u0093\u0001\u0000\u0000\u0000\u03f0\u03f2\u0005"+
		">\u0000\u0000\u03f1\u03f3\u0003\u0096K\u0000\u03f2\u03f1\u0001\u0000\u0000"+
		"\u0000\u03f2\u03f3\u0001\u0000\u0000\u0000\u03f3\u03f5\u0001\u0000\u0000"+
		"\u0000\u03f4\u03f6\u0003\u00d2i\u0000\u03f5\u03f4\u0001\u0000\u0000\u0000"+
		"\u03f5\u03f6\u0001\u0000\u0000\u0000\u03f6\u03f7\u0001\u0000\u0000\u0000"+
		"\u03f7\u03f8\u0005?\u0000\u0000\u03f8\u0095\u0001\u0000\u0000\u0000\u03f9"+
		"\u03fb\u0003\"\u0011\u0000\u03fa\u03f9\u0001\u0000\u0000\u0000\u03fa\u03fb"+
		"\u0001\u0000\u0000\u0000\u03fb\u03fc\u0001\u0000\u0000\u0000\u03fc\u03fd"+
		"\u0005.\u0000\u0000\u03fd\u03ff\u0005<\u0000\u0000\u03fe\u0400\u0003\u0172"+
		"\u00b9\u0000\u03ff\u03fe\u0001\u0000\u0000\u0000\u03ff\u0400\u0001\u0000"+
		"\u0000\u0000\u0400\u0401\u0001\u0000\u0000\u0000\u0401\u0402\u0005=\u0000"+
		"\u0000\u0402\u0428\u0005B\u0000\u0000\u0403\u0405\u0003\"\u0011\u0000"+
		"\u0404\u0403\u0001\u0000\u0000\u0000\u0404\u0405\u0001\u0000\u0000\u0000"+
		"\u0405\u0406\u0001\u0000\u0000\u0000\u0406\u0407\u0005+\u0000\u0000\u0407"+
		"\u0409\u0005<\u0000\u0000\u0408\u040a\u0003\u0172\u00b9\u0000\u0409\u0408"+
		"\u0001\u0000\u0000\u0000\u0409\u040a\u0001\u0000\u0000\u0000\u040a\u040b"+
		"\u0001\u0000\u0000\u0000\u040b\u040c\u0005=\u0000\u0000\u040c\u0428\u0005"+
		"B\u0000\u0000\u040d\u040e\u00034\u001a\u0000\u040e\u0410\u0005D\u0000"+
		"\u0000\u040f\u0411\u0003\"\u0011\u0000\u0410\u040f\u0001\u0000\u0000\u0000"+
		"\u0410\u0411\u0001\u0000\u0000\u0000\u0411\u0412\u0001\u0000\u0000\u0000"+
		"\u0412\u0413\u0005+\u0000\u0000\u0413\u0415\u0005<\u0000\u0000\u0414\u0416"+
		"\u0003\u0172\u00b9\u0000\u0415\u0414\u0001\u0000\u0000\u0000\u0415\u0416"+
		"\u0001\u0000\u0000\u0000\u0416\u0417\u0001\u0000\u0000\u0000\u0417\u0418"+
		"\u0005=\u0000\u0000\u0418\u0419\u0005B\u0000\u0000\u0419\u0428\u0001\u0000"+
		"\u0000\u0000\u041a\u041b\u0003\u0138\u009c\u0000\u041b\u041d\u0005D\u0000"+
		"\u0000\u041c\u041e\u0003\"\u0011\u0000\u041d\u041c\u0001\u0000\u0000\u0000"+
		"\u041d\u041e\u0001\u0000\u0000\u0000\u041e\u041f\u0001\u0000\u0000\u0000"+
		"\u041f\u0420\u0005+\u0000\u0000\u0420\u0422\u0005<\u0000\u0000\u0421\u0423"+
		"\u0003\u0172\u00b9\u0000\u0422\u0421\u0001\u0000\u0000\u0000\u0422\u0423"+
		"\u0001\u0000\u0000\u0000\u0423\u0424\u0001\u0000\u0000\u0000\u0424\u0425"+
		"\u0005=\u0000\u0000\u0425\u0426\u0005B\u0000\u0000\u0426\u0428\u0001\u0000"+
		"\u0000\u0000\u0427\u03fa\u0001\u0000\u0000\u0000\u0427\u0404\u0001\u0000"+
		"\u0000\u0000\u0427\u040d\u0001\u0000\u0000\u0000\u0427\u041a\u0001\u0000"+
		"\u0000\u0000\u0428\u0097\u0001\u0000\u0000\u0000\u0429\u042b\u0003\u00ba"+
		"]\u0000\u042a\u0429\u0001\u0000\u0000\u0000\u042b\u042e\u0001\u0000\u0000"+
		"\u0000\u042c\u042a\u0001\u0000\u0000\u0000\u042c\u042d\u0001\u0000\u0000"+
		"\u0000\u042d\u0432\u0001\u0000\u0000\u0000\u042e\u042c\u0001\u0000\u0000"+
		"\u0000\u042f\u0431\u0003\u0002\u0001\u0000\u0430\u042f\u0001\u0000\u0000"+
		"\u0000\u0431\u0434\u0001\u0000\u0000\u0000\u0432\u0430\u0001\u0000\u0000"+
		"\u0000\u0432\u0433\u0001\u0000\u0000\u0000\u0433\u0435\u0001\u0000\u0000"+
		"\u0000\u0434\u0432\u0001\u0000\u0000\u0000\u0435\u0436\u0005\u0013\u0000"+
		"\u0000\u0436\u0438\u0003\u01b2\u00d9\u0000\u0437\u0439\u0003H$\u0000\u0438"+
		"\u0437\u0001\u0000\u0000\u0000\u0438\u0439\u0001\u0000\u0000\u0000\u0439"+
		"\u043a\u0001\u0000\u0000\u0000\u043a\u043b\u0003\u009aM\u0000\u043b\u0099"+
		"\u0001\u0000\u0000\u0000\u043c\u043e\u0005>\u0000\u0000\u043d\u043f\u0003"+
		"\u009cN\u0000\u043e\u043d\u0001\u0000\u0000\u0000\u043e\u043f\u0001\u0000"+
		"\u0000\u0000\u043f\u0441\u0001\u0000\u0000\u0000\u0440\u0442\u0005C\u0000"+
		"\u0000\u0441\u0440\u0001\u0000\u0000\u0000\u0441\u0442\u0001\u0000\u0000"+
		"\u0000\u0442\u0444\u0001\u0000\u0000\u0000\u0443\u0445\u0003\u00a0P\u0000"+
		"\u0444\u0443\u0001\u0000\u0000\u0000\u0444\u0445\u0001\u0000\u0000\u0000"+
		"\u0445\u0446\u0001\u0000\u0000\u0000\u0446\u0447\u0005?\u0000\u0000\u0447"+
		"\u009b\u0001\u0000\u0000\u0000\u0448\u044d\u0003\u009eO\u0000\u0449\u044a"+
		"\u0005C\u0000\u0000\u044a\u044c\u0003\u009eO\u0000\u044b\u0449\u0001\u0000"+
		"\u0000\u0000\u044c\u044f\u0001\u0000\u0000\u0000\u044d\u044b\u0001\u0000"+
		"\u0000\u0000\u044d\u044e\u0001\u0000\u0000\u0000\u044e\u009d\u0001\u0000"+
		"\u0000\u0000\u044f\u044d\u0001\u0000\u0000\u0000\u0450\u0452\u0003\u00ba"+
		"]\u0000\u0451\u0450\u0001\u0000\u0000\u0000\u0452\u0455\u0001\u0000\u0000"+
		"\u0000\u0453\u0451\u0001\u0000\u0000\u0000\u0453\u0454\u0001\u0000\u0000"+
		"\u0000\u0454\u0456\u0001\u0000\u0000\u0000\u0455\u0453\u0001\u0000\u0000"+
		"\u0000\u0456\u045c\u0003\u01b2\u00d9\u0000\u0457\u0459\u0005<\u0000\u0000"+
		"\u0458\u045a\u0003\u0172\u00b9\u0000\u0459\u0458\u0001\u0000\u0000\u0000"+
		"\u0459\u045a\u0001\u0000\u0000\u0000\u045a\u045b\u0001\u0000\u0000\u0000"+
		"\u045b\u045d\u0005=\u0000\u0000\u045c\u0457\u0001\u0000\u0000\u0000\u045c"+
		"\u045d\u0001\u0000\u0000\u0000\u045d\u045f\u0001\u0000\u0000\u0000\u045e"+
		"\u0460\u0003L&\u0000\u045f\u045e\u0001\u0000\u0000\u0000\u045f\u0460\u0001"+
		"\u0000\u0000\u0000\u0460\u009f\u0001\u0000\u0000\u0000\u0461\u0465\u0005"+
		"B\u0000\u0000\u0462\u0464\u0003N\'\u0000\u0463\u0462\u0001\u0000\u0000"+
		"\u0000\u0464\u0467\u0001\u0000\u0000\u0000\u0465\u0463\u0001\u0000\u0000"+
		"\u0000\u0465\u0466\u0001\u0000\u0000\u0000\u0466\u00a1\u0001\u0000\u0000"+
		"\u0000\u0467\u0465\u0001\u0000\u0000\u0000\u0468\u046b\u0003\u00a4R\u0000"+
		"\u0469\u046b\u0003\u00b0X\u0000\u046a\u0468\u0001\u0000\u0000\u0000\u046a"+
		"\u0469\u0001\u0000\u0000\u0000\u046b\u00a3\u0001\u0000\u0000\u0000\u046c"+
		"\u046e\u0003\u00ba]\u0000\u046d\u046c\u0001\u0000\u0000\u0000\u046e\u0471"+
		"\u0001\u0000\u0000\u0000\u046f\u046d\u0001\u0000\u0000\u0000\u046f\u0470"+
		"\u0001\u0000\u0000\u0000\u0470\u0475\u0001\u0000\u0000\u0000\u0471\u046f"+
		"\u0001\u0000\u0000\u0000\u0472\u0474\u0003\u0002\u0001\u0000\u0473\u0472"+
		"\u0001\u0000\u0000\u0000\u0474\u0477\u0001\u0000\u0000\u0000\u0475\u0473"+
		"\u0001\u0000\u0000\u0000\u0475\u0476\u0001\u0000\u0000\u0000\u0476\u0478"+
		"\u0001\u0000\u0000\u0000\u0477\u0475\u0001\u0000\u0000\u0000\u0478\u0479"+
		"\u0005\u001f\u0000\u0000\u0479\u047b\u0003\u01b2\u00d9\u0000\u047a\u047c"+
		"\u0003D\"\u0000\u047b\u047a\u0001\u0000\u0000\u0000\u047b\u047c\u0001"+
		"\u0000\u0000\u0000\u047c\u047e\u0001\u0000\u0000\u0000\u047d\u047f\u0003"+
		"\u00a6S\u0000\u047e\u047d\u0001\u0000\u0000\u0000\u047e\u047f\u0001\u0000"+
		"\u0000\u0000\u047f\u0480\u0001\u0000\u0000\u0000\u0480\u0481\u0003\u00a8"+
		"T\u0000\u0481\u00a5\u0001\u0000\u0000\u0000\u0482\u0483\u0005\u0014\u0000"+
		"\u0000\u0483\u0484\u0003J%\u0000\u0484\u00a7\u0001\u0000\u0000\u0000\u0485"+
		"\u0489\u0005>\u0000\u0000\u0486\u0488\u0003\u00aaU\u0000\u0487\u0486\u0001"+
		"\u0000\u0000\u0000\u0488\u048b\u0001\u0000\u0000\u0000\u0489\u0487\u0001"+
		"\u0000\u0000\u0000\u0489\u048a\u0001\u0000\u0000\u0000\u048a\u048c\u0001"+
		"\u0000\u0000\u0000\u048b\u0489\u0001\u0000\u0000\u0000\u048c\u048d\u0005"+
		"?\u0000\u0000\u048d\u00a9\u0001\u0000\u0000\u0000\u048e\u0494\u0003\u00ac"+
		"V\u0000\u048f\u0494\u0003\u00aeW\u0000\u0490\u0494\u0003@ \u0000\u0491"+
		"\u0494\u0003\u00a2Q\u0000\u0492\u0494\u0003\u00e0p\u0000\u0493\u048e\u0001"+
		"\u0000\u0000\u0000\u0493\u048f\u0001\u0000\u0000\u0000\u0493\u0490\u0001"+
		"\u0000\u0000\u0000\u0493\u0491\u0001\u0000\u0000\u0000\u0493\u0492\u0001"+
		"\u0000\u0000\u0000\u0494\u00ab\u0001\u0000\u0000\u0000\u0495\u0497\u0003"+
		"\u00ba]\u0000\u0496\u0495\u0001\u0000\u0000\u0000\u0497\u049a\u0001\u0000"+
		"\u0000\u0000\u0498\u0496\u0001\u0000\u0000\u0000\u0498\u0499\u0001\u0000"+
		"\u0000\u0000\u0499\u049e\u0001\u0000\u0000\u0000\u049a\u0498\u0001\u0000"+
		"\u0000\u0000\u049b\u049d\u0003\u0002\u0001\u0000\u049c\u049b\u0001\u0000"+
		"\u0000\u0000\u049d\u04a0\u0001\u0000\u0000\u0000\u049e\u049c\u0001\u0000"+
		"\u0000\u0000\u049e\u049f\u0001\u0000\u0000\u0000\u049f\u04a1\u0001\u0000"+
		"\u0000\u0000\u04a0\u049e\u0001\u0000\u0000\u0000\u04a1\u04a2\u0003Z-\u0000"+
		"\u04a2\u04a3\u0003R)\u0000\u04a3\u04a4\u0005B\u0000\u0000\u04a4\u00ad"+
		"\u0001\u0000\u0000\u0000\u04a5\u04a7\u0003\u00ba]\u0000\u04a6\u04a5\u0001"+
		"\u0000\u0000\u0000\u04a7\u04aa\u0001\u0000\u0000\u0000\u04a8\u04a6\u0001"+
		"\u0000\u0000\u0000\u04a8\u04a9\u0001\u0000\u0000\u0000\u04a9\u04ae\u0001"+
		"\u0000\u0000\u0000\u04aa\u04a8\u0001\u0000\u0000\u0000\u04ab\u04ad\u0003"+
		"\u0002\u0001\u0000\u04ac\u04ab\u0001\u0000\u0000\u0000\u04ad\u04b0\u0001"+
		"\u0000\u0000\u0000\u04ae\u04ac\u0001\u0000\u0000\u0000\u04ae\u04af\u0001"+
		"\u0000\u0000\u0000\u04af\u04b2\u0001\u0000\u0000\u0000\u04b0\u04ae\u0001"+
		"\u0000\u0000\u0000\u04b1\u04b3\u0005\u000f\u0000\u0000\u04b2\u04b1\u0001"+
		"\u0000\u0000\u0000\u04b2\u04b3\u0001\u0000\u0000\u0000\u04b3\u04b4\u0001"+
		"\u0000\u0000\u0000\u04b4\u04b5\u0003r9\u0000\u04b5\u04b6\u0003\u0088D"+
		"\u0000\u04b6\u00af\u0001\u0000\u0000\u0000\u04b7\u04b9\u0003\u00ba]\u0000"+
		"\u04b8\u04b7\u0001\u0000\u0000\u0000\u04b9\u04bc\u0001\u0000\u0000\u0000"+
		"\u04ba\u04b8\u0001\u0000\u0000\u0000\u04ba\u04bb\u0001\u0000\u0000\u0000"+
		"\u04bb\u04c0\u0001\u0000\u0000\u0000\u04bc\u04ba\u0001\u0000\u0000\u0000"+
		"\u04bd\u04bf\u0003\u0002\u0001\u0000\u04be\u04bd\u0001\u0000\u0000\u0000"+
		"\u04bf\u04c2\u0001\u0000\u0000\u0000\u04c0\u04be\u0001\u0000\u0000\u0000"+
		"\u04c0\u04c1\u0001\u0000\u0000\u0000\u04c1\u04c3\u0001\u0000\u0000\u0000"+
		"\u04c2\u04c0\u0001\u0000\u0000\u0000\u04c3\u04c4\u0005j\u0000\u0000\u04c4"+
		"\u04c5\u0005\u001f\u0000\u0000\u04c5\u04c6\u0003\u01b2\u00d9\u0000\u04c6"+
		"\u04c7\u0003\u00b2Y\u0000\u04c7\u00b1\u0001\u0000\u0000\u0000\u04c8\u04cc"+
		"\u0005>\u0000\u0000\u04c9\u04cb\u0003\u00b4Z\u0000\u04ca\u04c9\u0001\u0000"+
		"\u0000\u0000\u04cb\u04ce\u0001\u0000\u0000\u0000\u04cc\u04ca\u0001\u0000"+
		"\u0000\u0000\u04cc\u04cd\u0001\u0000\u0000\u0000\u04cd\u04cf\u0001\u0000"+
		"\u0000\u0000\u04ce\u04cc\u0001\u0000\u0000\u0000\u04cf\u04d0\u0005?\u0000"+
		"\u0000\u04d0\u00b3\u0001\u0000\u0000\u0000\u04d1\u04d7\u0003\u00b6[\u0000"+
		"\u04d2\u04d7\u0003\u00acV\u0000\u04d3\u04d7\u0003@ \u0000\u04d4\u04d7"+
		"\u0003\u00a2Q\u0000\u04d5\u04d7\u0005B\u0000\u0000\u04d6\u04d1\u0001\u0000"+
		"\u0000\u0000\u04d6\u04d2\u0001\u0000\u0000\u0000\u04d6\u04d3\u0001\u0000"+
		"\u0000\u0000\u04d6\u04d4\u0001\u0000\u0000\u0000\u04d6\u04d5\u0001\u0000"+
		"\u0000\u0000\u04d7\u00b5\u0001\u0000\u0000\u0000\u04d8\u04da\u0003\u00ba"+
		"]\u0000\u04d9\u04d8\u0001\u0000\u0000\u0000\u04da\u04dd\u0001\u0000\u0000"+
		"\u0000\u04db\u04d9\u0001\u0000\u0000\u0000\u04db\u04dc\u0001\u0000\u0000"+
		"\u0000\u04dc\u04e1\u0001\u0000\u0000\u0000\u04dd\u04db\u0001\u0000\u0000"+
		"\u0000\u04de\u04e0\u0003\u0002\u0001\u0000\u04df\u04de\u0001\u0000\u0000"+
		"\u0000\u04e0\u04e3\u0001\u0000\u0000\u0000\u04e1\u04df\u0001\u0000\u0000"+
		"\u0000\u04e1\u04e2\u0001\u0000\u0000\u0000\u04e2\u04e4\u0001\u0000\u0000"+
		"\u0000\u04e3\u04e1\u0001\u0000\u0000\u0000\u04e4\u04e5\u0003Z-\u0000\u04e5"+
		"\u04e6\u0003\u01b2\u00d9\u0000\u04e6\u04e7\u0005<\u0000\u0000\u04e7\u04eb"+
		"\u0005=\u0000\u0000\u04e8\u04ea\u0003\u001a\r\u0000\u04e9\u04e8\u0001"+
		"\u0000\u0000\u0000\u04ea\u04ed\u0001\u0000\u0000\u0000\u04eb\u04e9\u0001"+
		"\u0000\u0000\u0000\u04eb\u04ec\u0001\u0000\u0000\u0000\u04ec\u04ef\u0001"+
		"\u0000\u0000\u0000\u04ed\u04eb\u0001\u0000\u0000\u0000\u04ee\u04f0\u0003"+
		"\u00b8\\\u0000\u04ef\u04ee\u0001\u0000\u0000\u0000\u04ef\u04f0\u0001\u0000"+
		"\u0000\u0000\u04f0\u04f1\u0001\u0000\u0000\u0000\u04f1\u04f2\u0005B\u0000"+
		"\u0000\u04f2\u00b7\u0001\u0000\u0000\u0000\u04f3\u04f4\u0005\u000f\u0000"+
		"\u0000\u04f4\u04f5\u0003\u00c2a\u0000\u04f5\u00b9\u0001\u0000\u0000\u0000"+
		"\u04f6\u04fa\u0003\u00bc^\u0000\u04f7\u04fa\u0003\u00c8d\u0000\u04f8\u04fa"+
		"\u0003\u00cae\u0000\u04f9\u04f6\u0001\u0000\u0000\u0000\u04f9\u04f7\u0001"+
		"\u0000\u0000\u0000\u04f9\u04f8\u0001\u0000\u0000\u0000\u04fa\u00bb\u0001"+
		"\u0000\u0000\u0000\u04fb\u04fc\u0005j\u0000\u0000\u04fc\u04fd\u0003.\u0017"+
		"\u0000\u04fd\u04ff\u0005<\u0000\u0000\u04fe\u0500\u0003\u00be_\u0000\u04ff"+
		"\u04fe\u0001\u0000\u0000\u0000\u04ff\u0500\u0001\u0000\u0000\u0000\u0500"+
		"\u0501\u0001\u0000\u0000\u0000\u0501\u0502\u0005=\u0000\u0000\u0502\u00bd"+
		"\u0001\u0000\u0000\u0000\u0503\u0508\u0003\u00c0`\u0000\u0504\u0505\u0005"+
		"C\u0000\u0000\u0505\u0507\u0003\u00c0`\u0000\u0506\u0504\u0001\u0000\u0000"+
		"\u0000\u0507\u050a\u0001\u0000\u0000\u0000\u0508\u0506\u0001\u0000\u0000"+
		"\u0000\u0508\u0509\u0001\u0000\u0000\u0000\u0509\u00bf\u0001\u0000\u0000"+
		"\u0000\u050a\u0508\u0001\u0000\u0000\u0000\u050b\u050c\u0003\u01b2\u00d9"+
		"\u0000\u050c\u050d\u0005E\u0000\u0000\u050d\u050e\u0003\u00c2a\u0000\u050e"+
		"\u00c1\u0001\u0000\u0000\u0000\u050f\u0513\u0003\u019a\u00cd\u0000\u0510"+
		"\u0513\u0003\u00c4b\u0000\u0511\u0513\u0003\u00ba]\u0000\u0512\u050f\u0001"+
		"\u0000\u0000\u0000\u0512\u0510\u0001\u0000\u0000\u0000\u0512\u0511\u0001"+
		"\u0000\u0000\u0000\u0513\u00c3\u0001\u0000\u0000\u0000\u0514\u0516\u0005"+
		">\u0000\u0000\u0515\u0517\u0003\u00c6c\u0000\u0516\u0515\u0001\u0000\u0000"+
		"\u0000\u0516\u0517\u0001\u0000\u0000\u0000\u0517\u0519\u0001\u0000\u0000"+
		"\u0000\u0518\u051a\u0005C\u0000\u0000\u0519\u0518\u0001\u0000\u0000\u0000"+
		"\u0519\u051a\u0001\u0000\u0000\u0000\u051a\u051b\u0001\u0000\u0000\u0000"+
		"\u051b\u051c\u0005?\u0000\u0000\u051c\u00c5\u0001\u0000\u0000\u0000\u051d"+
		"\u0522\u0003\u00c2a\u0000\u051e\u051f\u0005C\u0000\u0000\u051f\u0521\u0003"+
		"\u00c2a\u0000\u0520\u051e\u0001\u0000\u0000\u0000\u0521\u0524\u0001\u0000"+
		"\u0000\u0000\u0522\u0520\u0001\u0000\u0000\u0000\u0522\u0523\u0001\u0000"+
		"\u0000\u0000\u0523\u00c7\u0001\u0000\u0000\u0000\u0524\u0522\u0001\u0000"+
		"\u0000\u0000\u0525\u0526\u0005j\u0000\u0000\u0526\u0527\u0003.\u0017\u0000"+
		"\u0527\u00c9\u0001\u0000\u0000\u0000\u0528\u0529\u0005j\u0000\u0000\u0529"+
		"\u052a\u0003.\u0017\u0000\u052a\u052b\u0005<\u0000\u0000\u052b\u052c\u0003"+
		"\u00c2a\u0000\u052c\u052d\u0005=\u0000\u0000\u052d\u00cb\u0001\u0000\u0000"+
		"\u0000\u052e\u0530\u0005>\u0000\u0000\u052f\u0531\u0003\u00ceg\u0000\u0530"+
		"\u052f\u0001\u0000\u0000\u0000\u0530\u0531\u0001\u0000\u0000\u0000\u0531"+
		"\u0533\u0001\u0000\u0000\u0000\u0532\u0534\u0005C\u0000\u0000\u0533\u0532"+
		"\u0001\u0000\u0000\u0000\u0533\u0534\u0001\u0000\u0000\u0000\u0534\u0535"+
		"\u0001\u0000\u0000\u0000\u0535\u0536\u0005?\u0000\u0000\u0536\u00cd\u0001"+
		"\u0000\u0000\u0000\u0537\u053c\u0003X,\u0000\u0538\u0539\u0005C\u0000"+
		"\u0000\u0539\u053b\u0003X,\u0000\u053a\u0538\u0001\u0000\u0000\u0000\u053b"+
		"\u053e\u0001\u0000\u0000\u0000\u053c\u053a\u0001\u0000\u0000\u0000\u053c"+
		"\u053d\u0001\u0000\u0000\u0000\u053d\u00cf\u0001\u0000\u0000\u0000\u053e"+
		"\u053c\u0001\u0000\u0000\u0000\u053f\u0543\u0005>\u0000\u0000\u0540\u0542"+
		"\u0003\u00d4j\u0000\u0541\u0540\u0001\u0000\u0000\u0000\u0542\u0545\u0001"+
		"\u0000\u0000\u0000\u0543\u0541\u0001\u0000\u0000\u0000\u0543\u0544\u0001"+
		"\u0000\u0000\u0000\u0544\u0546\u0001\u0000\u0000\u0000\u0545\u0543\u0001"+
		"\u0000\u0000\u0000\u0546\u0547\u0005?\u0000\u0000\u0547\u00d1\u0001\u0000"+
		"\u0000\u0000\u0548\u054a\u0003\u00d4j\u0000\u0549\u0548\u0001\u0000\u0000"+
		"\u0000\u054a\u054b\u0001\u0000\u0000\u0000\u054b\u0549\u0001\u0000\u0000"+
		"\u0000\u054b\u054c\u0001\u0000\u0000\u0000\u054c\u00d3\u0001\u0000\u0000"+
		"\u0000\u054d\u0551\u0003\u00d6k\u0000\u054e\u0551\u0003@ \u0000\u054f"+
		"\u0551\u0003\u00dam\u0000\u0550\u054d\u0001\u0000\u0000\u0000\u0550\u054e"+
		"\u0001\u0000\u0000\u0000\u0550\u054f\u0001\u0000\u0000\u0000\u0551\u00d5"+
		"\u0001\u0000\u0000\u0000\u0552\u0553\u0003\u00d8l\u0000\u0553\u0554\u0005"+
		"B\u0000\u0000\u0554\u00d7\u0001\u0000\u0000\u0000\u0555\u0557\u0003\u00ba"+
		"]\u0000\u0556\u0555\u0001\u0000\u0000\u0000\u0557\u055a\u0001\u0000\u0000"+
		"\u0000\u0558\u0556\u0001\u0000\u0000\u0000\u0558\u0559\u0001\u0000\u0000"+
		"\u0000\u0559\u055e\u0001\u0000\u0000\u0000\u055a\u0558\u0001\u0000\u0000"+
		"\u0000\u055b\u055d\u0003\u0002\u0001\u0000\u055c\u055b\u0001\u0000\u0000"+
		"\u0000\u055d\u0560\u0001\u0000\u0000\u0000\u055e\u055c\u0001\u0000\u0000"+
		"\u0000\u055e\u055f\u0001\u0000\u0000\u0000\u055f\u0561\u0001\u0000\u0000"+
		"\u0000\u0560\u055e\u0001\u0000\u0000\u0000\u0561\u0562\u0003Z-\u0000\u0562"+
		"\u0563\u0003R)\u0000\u0563\u00d9\u0001\u0000\u0000\u0000\u0564\u056b\u0003"+
		"\u00deo\u0000\u0565\u056b\u0003\u00e2q\u0000\u0566\u056b\u0003\u00f4z"+
		"\u0000\u0567\u056b\u0003\u00f6{\u0000\u0568\u056b\u0003\u0104\u0082\u0000"+
		"\u0569\u056b\u0003\u010a\u0085\u0000\u056a\u0564\u0001\u0000\u0000\u0000"+
		"\u056a\u0565\u0001\u0000\u0000\u0000\u056a\u0566\u0001\u0000\u0000\u0000"+
		"\u056a\u0567\u0001\u0000\u0000\u0000\u056a\u0568\u0001\u0000\u0000\u0000"+
		"\u056a\u0569\u0001\u0000\u0000\u0000\u056b\u00db\u0001\u0000\u0000\u0000"+
		"\u056c\u0572\u0003\u00deo\u0000\u056d\u0572\u0003\u00e4r\u0000\u056e\u0572"+
		"\u0003\u00f8|\u0000\u056f\u0572\u0003\u0106\u0083\u0000\u0570\u0572\u0003"+
		"\u010c\u0086\u0000\u0571\u056c\u0001\u0000\u0000\u0000\u0571\u056d\u0001"+
		"\u0000\u0000\u0000\u0571\u056e\u0001\u0000\u0000\u0000\u0571\u056f\u0001"+
		"\u0000\u0000\u0000\u0571\u0570\u0001\u0000\u0000\u0000\u0572\u00dd\u0001"+
		"\u0000\u0000\u0000\u0573\u0580\u0003\u00d0h\u0000\u0574\u0580\u0003\u00e0"+
		"p\u0000\u0575\u0580\u0003\u00e6s\u0000\u0576\u0580\u0003\u00fa}\u0000"+
		"\u0577\u0580\u0003\u00fc~\u0000\u0578\u0580\u0003\u0108\u0084\u0000\u0579"+
		"\u0580\u0003\u011c\u008e\u0000\u057a\u0580\u0003\u011e\u008f\u0000\u057b"+
		"\u0580\u0003\u0120\u0090\u0000\u057c\u0580\u0003\u0124\u0092\u0000\u057d"+
		"\u0580\u0003\u0122\u0091\u0000\u057e\u0580\u0003\u0126\u0093\u0000\u057f"+
		"\u0573\u0001\u0000\u0000\u0000\u057f\u0574\u0001\u0000\u0000\u0000\u057f"+
		"\u0575\u0001\u0000\u0000\u0000\u057f\u0576\u0001\u0000\u0000\u0000\u057f"+
		"\u0577\u0001\u0000\u0000\u0000\u057f\u0578\u0001\u0000\u0000\u0000\u057f"+
		"\u0579\u0001\u0000\u0000\u0000\u057f\u057a\u0001\u0000\u0000\u0000\u057f"+
		"\u057b\u0001\u0000\u0000\u0000\u057f\u057c\u0001\u0000\u0000\u0000\u057f"+
		"\u057d\u0001\u0000\u0000\u0000\u057f\u057e\u0001\u0000\u0000\u0000\u0580"+
		"\u00df\u0001\u0000\u0000\u0000\u0581\u0582\u0005B\u0000\u0000\u0582\u00e1"+
		"\u0001\u0000\u0000\u0000\u0583\u0584\u0003\u01b2\u00d9\u0000\u0584\u0585"+
		"\u0005K\u0000\u0000\u0585\u0586\u0003\u00dam\u0000\u0586\u00e3\u0001\u0000"+
		"\u0000\u0000\u0587\u0588\u0003\u01b2\u00d9\u0000\u0588\u0589\u0005K\u0000"+
		"\u0000\u0589\u058a\u0003\u00dcn\u0000\u058a\u00e5\u0001\u0000\u0000\u0000"+
		"\u058b\u058c\u0003\u00e8t\u0000\u058c\u058d\u0005B\u0000\u0000\u058d\u00e7"+
		"\u0001\u0000\u0000\u0000\u058e\u0594\u0003\u00eau\u0000\u058f\u0594\u0003"+
		"\u00ecv\u0000\u0590\u0594\u0003\u00eew\u0000\u0591\u0594\u0003\u00f0x"+
		"\u0000\u0592\u0594\u0003\u00f2y\u0000\u0593\u058e\u0001\u0000\u0000\u0000"+
		"\u0593\u058f\u0001\u0000\u0000\u0000\u0593\u0590\u0001\u0000\u0000\u0000"+
		"\u0593\u0591\u0001\u0000\u0000\u0000\u0593\u0592\u0001\u0000\u0000\u0000"+
		"\u0594\u00e9\u0001\u0000\u0000\u0000\u0595\u0596\u0003\u0192\u00c9\u0000"+
		"\u0596\u00eb\u0001\u0000\u0000\u0000\u0597\u0598\u0003\u01a4\u00d2\u0000"+
		"\u0598\u00ed\u0001\u0000\u0000\u0000\u0599\u059a\u0003\u01aa\u00d5\u0000"+
		"\u059a\u00ef\u0001\u0000\u0000\u0000\u059b\u059c\u0003\u016a\u00b5\u0000"+
		"\u059c\u00f1\u0001\u0000\u0000\u0000\u059d\u059e\u0003\u0156\u00ab\u0000"+
		"\u059e\u00f3\u0001\u0000\u0000\u0000\u059f\u05a0\u0005\u0019\u0000\u0000"+
		"\u05a0\u05a1\u0005<\u0000\u0000\u05a1\u05a2\u0003\u0180\u00c0\u0000\u05a2"+
		"\u05a3\u0005=\u0000\u0000\u05a3\u05a4\u0003\u00dam\u0000\u05a4\u00f5\u0001"+
		"\u0000\u0000\u0000\u05a5\u05a6\u0005\u0019\u0000\u0000\u05a6\u05a7\u0005"+
		"<\u0000\u0000\u05a7\u05a8\u0003\u0180\u00c0\u0000\u05a8\u05a9\u0005=\u0000"+
		"\u0000\u05a9\u05aa\u0003\u00dcn\u0000\u05aa\u05ab\u0005\u0012\u0000\u0000"+
		"\u05ab\u05ac\u0003\u00dam\u0000\u05ac\u00f7\u0001\u0000\u0000\u0000\u05ad"+
		"\u05ae\u0005\u0019\u0000\u0000\u05ae\u05af\u0005<\u0000\u0000\u05af\u05b0"+
		"\u0003\u0180\u00c0\u0000\u05b0\u05b1\u0005=\u0000\u0000\u05b1\u05b2\u0003"+
		"\u00dcn\u0000\u05b2\u05b3\u0005\u0012\u0000\u0000\u05b3\u05b4\u0003\u00dc"+
		"n\u0000\u05b4\u00f9\u0001\u0000\u0000\u0000\u05b5\u05b6\u0005\u0005\u0000"+
		"\u0000\u05b6\u05b7\u0003\u0180\u00c0\u0000\u05b7\u05b8\u0005B\u0000\u0000"+
		"\u05b8\u05c0\u0001\u0000\u0000\u0000\u05b9\u05ba\u0005\u0005\u0000\u0000"+
		"\u05ba\u05bb\u0003\u0180\u00c0\u0000\u05bb\u05bc\u0005K\u0000\u0000\u05bc"+
		"\u05bd\u0003\u0180\u00c0\u0000\u05bd\u05be\u0005B\u0000\u0000\u05be\u05c0"+
		"\u0001\u0000\u0000\u0000\u05bf\u05b5\u0001\u0000\u0000\u0000\u05bf\u05b9"+
		"\u0001\u0000\u0000\u0000\u05c0\u00fb\u0001\u0000\u0000\u0000\u05c1\u05c2"+
		"\u0005,\u0000\u0000\u05c2\u05c3\u0005<\u0000\u0000\u05c3\u05c4\u0003\u0180"+
		"\u00c0\u0000\u05c4\u05c5\u0005=\u0000\u0000\u05c5\u05c6\u0003\u00fe\u007f"+
		"\u0000\u05c6\u00fd\u0001\u0000\u0000\u0000\u05c7\u05cb\u0005>\u0000\u0000"+
		"\u05c8\u05ca\u0003\u0100\u0080\u0000\u05c9\u05c8\u0001\u0000\u0000\u0000"+
		"\u05ca\u05cd\u0001\u0000\u0000\u0000\u05cb\u05c9\u0001\u0000\u0000\u0000"+
		"\u05cb\u05cc\u0001\u0000\u0000\u0000\u05cc\u05cf\u0001\u0000\u0000\u0000"+
		"\u05cd\u05cb\u0001\u0000\u0000\u0000\u05ce\u05d0\u0003\u0102\u0081\u0000"+
		"\u05cf\u05ce\u0001\u0000\u0000\u0000\u05cf\u05d0\u0001\u0000\u0000\u0000"+
		"\u05d0\u05d1\u0001\u0000\u0000\u0000\u05d1\u05d2\u0005?\u0000\u0000\u05d2"+
		"\u00ff\u0001\u0000\u0000\u0000\u05d3\u05d4\u0005\t\u0000\u0000\u05d4\u05d5"+
		"\u0003\u0180\u00c0\u0000\u05d5\u05d7\u0005K\u0000\u0000\u05d6\u05d8\u0003"+
		"\u00d2i\u0000\u05d7\u05d6\u0001\u0000\u0000\u0000\u05d7\u05d8\u0001\u0000"+
		"\u0000\u0000\u05d8\u0101\u0001\u0000\u0000\u0000\u05d9\u05da\u0005\u000f"+
		"\u0000\u0000\u05da\u05dc\u0005K\u0000\u0000\u05db\u05dd\u0003\u00d2i\u0000"+
		"\u05dc\u05db\u0001\u0000\u0000\u0000\u05dc\u05dd\u0001\u0000\u0000\u0000"+
		"\u05dd\u0103\u0001\u0000\u0000\u0000\u05de\u05df\u00055\u0000\u0000\u05df"+
		"\u05e0\u0005<\u0000\u0000\u05e0\u05e1\u0003\u0180\u00c0\u0000\u05e1\u05e2"+
		"\u0005=\u0000\u0000\u05e2\u05e3\u0003\u00dam\u0000\u05e3\u0105\u0001\u0000"+
		"\u0000\u0000\u05e4\u05e5\u00055\u0000\u0000\u05e5\u05e6\u0005<\u0000\u0000"+
		"\u05e6\u05e7\u0003\u0180\u00c0\u0000\u05e7\u05e8\u0005=\u0000\u0000\u05e8"+
		"\u05e9\u0003\u00dcn\u0000\u05e9\u0107\u0001\u0000\u0000\u0000\u05ea\u05eb"+
		"\u0005\u0010\u0000\u0000\u05eb\u05ec\u0003\u00dam\u0000\u05ec\u05ed\u0005"+
		"5\u0000\u0000\u05ed\u05ee\u0005<\u0000\u0000\u05ee\u05ef\u0003\u0180\u00c0"+
		"\u0000\u05ef\u05f0\u0005=\u0000\u0000\u05f0\u05f1\u0005B\u0000\u0000\u05f1"+
		"\u0109\u0001\u0000\u0000\u0000\u05f2\u05f5\u0003\u010e\u0087\u0000\u05f3"+
		"\u05f5\u0003\u0118\u008c\u0000\u05f4\u05f2\u0001\u0000\u0000\u0000\u05f4"+
		"\u05f3\u0001\u0000\u0000\u0000\u05f5\u010b\u0001\u0000\u0000\u0000\u05f6"+
		"\u05f9\u0003\u0110\u0088\u0000\u05f7\u05f9\u0003\u011a\u008d\u0000\u05f8"+
		"\u05f6\u0001\u0000\u0000\u0000\u05f8\u05f7\u0001\u0000\u0000\u0000\u05f9"+
		"\u010d\u0001\u0000\u0000\u0000\u05fa\u05fb\u0005\u0018\u0000\u0000\u05fb"+
		"\u05fd\u0005<\u0000\u0000\u05fc\u05fe\u0003\u0112\u0089\u0000\u05fd\u05fc"+
		"\u0001\u0000\u0000\u0000\u05fd\u05fe\u0001\u0000\u0000\u0000\u05fe\u05ff"+
		"\u0001\u0000\u0000\u0000\u05ff\u0601\u0005B\u0000\u0000\u0600\u0602\u0003"+
		"\u0180\u00c0\u0000\u0601\u0600\u0001\u0000\u0000\u0000\u0601\u0602\u0001"+
		"\u0000\u0000\u0000\u0602\u0603\u0001\u0000\u0000\u0000\u0603\u0605\u0005"+
		"B\u0000\u0000\u0604\u0606\u0003\u0114\u008a\u0000\u0605\u0604\u0001\u0000"+
		"\u0000\u0000\u0605\u0606\u0001\u0000\u0000\u0000\u0606\u0607\u0001\u0000"+
		"\u0000\u0000\u0607\u0608\u0005=\u0000\u0000\u0608\u0609\u0003\u00dam\u0000"+
		"\u0609\u010f\u0001\u0000\u0000\u0000\u060a\u060b\u0005\u0018\u0000\u0000"+
		"\u060b\u060d\u0005<\u0000\u0000\u060c\u060e\u0003\u0112\u0089\u0000\u060d"+
		"\u060c\u0001\u0000\u0000\u0000\u060d\u060e\u0001\u0000\u0000\u0000\u060e"+
		"\u060f\u0001\u0000\u0000\u0000\u060f\u0611\u0005B\u0000\u0000\u0610\u0612"+
		"\u0003\u0180\u00c0\u0000\u0611\u0610\u0001\u0000\u0000\u0000\u0611\u0612"+
		"\u0001\u0000\u0000\u0000\u0612\u0613\u0001\u0000\u0000\u0000\u0613\u0615"+
		"\u0005B\u0000\u0000\u0614\u0616\u0003\u0114\u008a\u0000\u0615\u0614\u0001"+
		"\u0000\u0000\u0000\u0615\u0616\u0001\u0000\u0000\u0000\u0616\u0617\u0001"+
		"\u0000\u0000\u0000\u0617\u0618\u0005=\u0000\u0000\u0618\u0619\u0003\u00dc"+
		"n\u0000\u0619\u0111\u0001\u0000\u0000\u0000\u061a\u061d\u0003\u0116\u008b"+
		"\u0000\u061b\u061d\u0003\u00d8l\u0000\u061c\u061a\u0001\u0000\u0000\u0000"+
		"\u061c\u061b\u0001\u0000\u0000\u0000\u061d\u0113\u0001\u0000\u0000\u0000"+
		"\u061e\u061f\u0003\u0116\u008b\u0000\u061f\u0115\u0001\u0000\u0000\u0000"+
		"\u0620\u0625\u0003\u00e8t\u0000\u0621\u0622\u0005C\u0000\u0000\u0622\u0624"+
		"\u0003\u00e8t\u0000\u0623\u0621\u0001\u0000\u0000\u0000\u0624\u0627\u0001"+
		"\u0000\u0000\u0000\u0625\u0623\u0001\u0000\u0000\u0000\u0625\u0626\u0001"+
		"\u0000\u0000\u0000\u0626\u0117\u0001\u0000\u0000\u0000\u0627\u0625\u0001"+
		"\u0000\u0000\u0000\u0628\u0629\u0005\u0018\u0000\u0000\u0629\u062d\u0005"+
		"<\u0000\u0000\u062a\u062c\u0003\u0002\u0001\u0000\u062b\u062a\u0001\u0000"+
		"\u0000\u0000\u062c\u062f\u0001\u0000\u0000\u0000\u062d\u062b\u0001\u0000"+
		"\u0000\u0000\u062d\u062e\u0001\u0000\u0000\u0000\u062e\u0630\u0001\u0000"+
		"\u0000\u0000\u062f\u062d\u0001\u0000\u0000\u0000\u0630\u0631\u0003Z-\u0000"+
		"\u0631\u0632\u0003V+\u0000\u0632\u0633\u0005K\u0000\u0000\u0633\u0634"+
		"\u0003\u0180\u00c0\u0000\u0634\u0635\u0005=\u0000\u0000\u0635\u0636\u0003"+
		"\u00dam\u0000\u0636\u0119\u0001\u0000\u0000\u0000\u0637\u0638\u0005\u0018"+
		"\u0000\u0000\u0638\u063c\u0005<\u0000\u0000\u0639\u063b\u0003\u0002\u0001"+
		"\u0000\u063a\u0639\u0001\u0000\u0000\u0000\u063b\u063e\u0001\u0000\u0000"+
		"\u0000\u063c\u063a\u0001\u0000\u0000\u0000\u063c\u063d\u0001\u0000\u0000"+
		"\u0000\u063d\u063f\u0001\u0000\u0000\u0000\u063e\u063c\u0001\u0000\u0000"+
		"\u0000\u063f\u0640\u0003Z-\u0000\u0640\u0641\u0003V+\u0000\u0641\u0642"+
		"\u0005K\u0000\u0000\u0642\u0643\u0003\u0180\u00c0\u0000\u0643\u0644\u0005"+
		"=\u0000\u0000\u0644\u0645\u0003\u00dcn\u0000\u0645\u011b\u0001\u0000\u0000"+
		"\u0000\u0646\u0648\u0005\u0007\u0000\u0000\u0647\u0649\u0003\u01b2\u00d9"+
		"\u0000\u0648\u0647\u0001\u0000\u0000\u0000\u0648\u0649\u0001\u0000\u0000"+
		"\u0000\u0649\u064a\u0001\u0000\u0000\u0000\u064a\u064b\u0005B\u0000\u0000"+
		"\u064b\u011d\u0001\u0000\u0000\u0000\u064c\u064e\u0005\u000e\u0000\u0000"+
		"\u064d\u064f\u0003\u01b2\u00d9\u0000\u064e\u064d\u0001\u0000\u0000\u0000"+
		"\u064e\u064f\u0001\u0000\u0000\u0000\u064f\u0650\u0001\u0000\u0000\u0000"+
		"\u0650\u0651\u0005B\u0000\u0000\u0651\u011f\u0001\u0000\u0000\u0000\u0652"+
		"\u0654\u0005\'\u0000\u0000\u0653\u0655\u0003\u0180\u00c0\u0000\u0654\u0653"+
		"\u0001\u0000\u0000\u0000\u0654\u0655\u0001\u0000\u0000\u0000\u0655\u0656"+
		"\u0001\u0000\u0000\u0000\u0656\u0657\u0005B\u0000\u0000\u0657\u0121\u0001"+
		"\u0000\u0000\u0000\u0658\u0659\u0005/\u0000\u0000\u0659\u065a\u0003\u0180"+
		"\u00c0\u0000\u065a\u065b\u0005B\u0000\u0000\u065b\u0123\u0001\u0000\u0000"+
		"\u0000\u065c\u065d\u0005-\u0000\u0000\u065d\u065e\u0005<\u0000\u0000\u065e"+
		"\u065f\u0003\u0180\u00c0\u0000\u065f\u0660\u0005=\u0000\u0000\u0660\u0661"+
		"\u0003\u00d0h\u0000\u0661\u0125\u0001\u0000\u0000\u0000\u0662\u0665\u0003"+
		"\u0128\u0094\u0000\u0663\u0665\u0003\u0130\u0098\u0000\u0664\u0662\u0001"+
		"\u0000\u0000\u0000\u0664\u0663\u0001\u0000\u0000\u0000\u0665\u0127\u0001"+
		"\u0000\u0000\u0000\u0666\u0667\u00052\u0000\u0000\u0667\u0668\u0003\u00d0"+
		"h\u0000\u0668\u0669\u0003\u012a\u0095\u0000\u0669\u0672\u0001\u0000\u0000"+
		"\u0000\u066a\u066b\u00052\u0000\u0000\u066b\u066d\u0003\u00d0h\u0000\u066c"+
		"\u066e\u0003\u012a\u0095\u0000\u066d\u066c\u0001\u0000\u0000\u0000\u066d"+
		"\u066e\u0001\u0000\u0000\u0000\u066e\u066f\u0001\u0000\u0000\u0000\u066f"+
		"\u0670\u0003\u012e\u0097\u0000\u0670\u0672\u0001\u0000\u0000\u0000\u0671"+
		"\u0666\u0001\u0000\u0000\u0000\u0671\u066a\u0001\u0000\u0000\u0000\u0672"+
		"\u0129\u0001\u0000\u0000\u0000\u0673\u0677\u0003\u012c\u0096\u0000\u0674"+
		"\u0676\u0003\u012c\u0096\u0000\u0675\u0674\u0001\u0000\u0000\u0000\u0676"+
		"\u0679\u0001\u0000\u0000\u0000\u0677\u0675\u0001\u0000\u0000\u0000\u0677"+
		"\u0678\u0001\u0000\u0000\u0000\u0678\u012b\u0001\u0000\u0000\u0000\u0679"+
		"\u0677\u0001\u0000\u0000\u0000\u067a\u067b\u0005\n\u0000\u0000\u067b\u067f"+
		"\u0005<\u0000\u0000\u067c\u067e\u0003\u0002\u0001\u0000\u067d\u067c\u0001"+
		"\u0000\u0000\u0000\u067e\u0681\u0001\u0000\u0000\u0000\u067f\u067d\u0001"+
		"\u0000\u0000\u0000\u067f\u0680\u0001\u0000\u0000\u0000\u0680\u0682\u0001"+
		"\u0000\u0000\u0000\u0681\u067f\u0001\u0000\u0000\u0000\u0682\u0687\u0003"+
		"b1\u0000\u0683\u0684\u0005Y\u0000\u0000\u0684\u0686\u0003\u0010\b\u0000"+
		"\u0685\u0683\u0001\u0000\u0000\u0000\u0686\u0689\u0001\u0000\u0000\u0000"+
		"\u0687\u0685\u0001\u0000\u0000\u0000\u0687\u0688\u0001\u0000\u0000\u0000"+
		"\u0688\u068a\u0001\u0000\u0000\u0000\u0689\u0687\u0001\u0000\u0000\u0000"+
		"\u068a\u068b\u0003V+\u0000\u068b\u068c\u0005=\u0000\u0000\u068c\u068d"+
		"\u0003\u00d0h\u0000\u068d\u012d\u0001\u0000\u0000\u0000\u068e\u068f\u0005"+
		"\u0016\u0000\u0000\u068f\u0690\u0003\u00d0h\u0000\u0690\u012f\u0001\u0000"+
		"\u0000\u0000\u0691\u0692\u00052\u0000\u0000\u0692\u0693\u0003\u0132\u0099"+
		"\u0000\u0693\u0695\u0003\u00d0h\u0000\u0694\u0696\u0003\u012a\u0095\u0000"+
		"\u0695\u0694\u0001\u0000\u0000\u0000\u0695\u0696\u0001\u0000\u0000\u0000"+
		"\u0696\u0698\u0001\u0000\u0000\u0000\u0697\u0699\u0003\u012e\u0097\u0000"+
		"\u0698\u0697\u0001\u0000\u0000\u0000\u0698\u0699\u0001\u0000\u0000\u0000"+
		"\u0699\u0131\u0001\u0000\u0000\u0000\u069a\u069b\u0005<\u0000\u0000\u069b"+
		"\u069d\u0003\u0134\u009a\u0000\u069c\u069e\u0005B\u0000\u0000\u069d\u069c"+
		"\u0001\u0000\u0000\u0000\u069d\u069e\u0001\u0000\u0000\u0000\u069e\u069f"+
		"\u0001\u0000\u0000\u0000\u069f\u06a0\u0005=\u0000\u0000\u06a0\u0133\u0001"+
		"\u0000\u0000\u0000\u06a1\u06a6\u0003\u0136\u009b\u0000\u06a2\u06a3\u0005"+
		"B\u0000\u0000\u06a3\u06a5\u0003\u0136\u009b\u0000\u06a4\u06a2\u0001\u0000"+
		"\u0000\u0000\u06a5\u06a8\u0001\u0000\u0000\u0000\u06a6\u06a4\u0001\u0000"+
		"\u0000\u0000\u06a6\u06a7\u0001\u0000\u0000\u0000\u06a7\u0135\u0001\u0000"+
		"\u0000\u0000\u06a8\u06a6\u0001\u0000\u0000\u0000\u06a9\u06ab\u0003\u0002"+
		"\u0001\u0000\u06aa\u06a9\u0001\u0000\u0000\u0000\u06ab\u06ae\u0001\u0000"+
		"\u0000\u0000\u06ac\u06aa\u0001\u0000\u0000\u0000\u06ac\u06ad\u0001\u0000"+
		"\u0000\u0000\u06ad\u06af\u0001\u0000\u0000\u0000\u06ae\u06ac\u0001\u0000"+
		"\u0000\u0000\u06af\u06b0\u0003Z-\u0000\u06b0\u06b1\u0003V+\u0000\u06b1"+
		"\u06b2\u0005E\u0000\u0000\u06b2\u06b3\u0003\u0180\u00c0\u0000\u06b3\u0137"+
		"\u0001\u0000\u0000\u0000\u06b4\u06b7\u0003\u014e\u00a7\u0000\u06b5\u06b7"+
		"\u0003\u017a\u00bd\u0000\u06b6\u06b4\u0001\u0000\u0000\u0000\u06b6\u06b5"+
		"\u0001\u0000\u0000\u0000\u06b7\u06bb\u0001\u0000\u0000\u0000\u06b8\u06ba"+
		"\u0003\u0140\u00a0\u0000\u06b9\u06b8\u0001\u0000\u0000\u0000\u06ba\u06bd"+
		"\u0001\u0000\u0000\u0000\u06bb\u06b9\u0001\u0000\u0000\u0000\u06bb\u06bc"+
		"\u0001\u0000\u0000\u0000\u06bc\u0139\u0001\u0000\u0000\u0000\u06bd\u06bb"+
		"\u0001\u0000\u0000\u0000\u06be\u06bf\u0005<\u0000\u0000\u06bf\u06c0\u0003"+
		"\u0180\u00c0\u0000\u06c0\u06c1\u0005=\u0000\u0000\u06c1\u013b\u0001\u0000"+
		"\u0000\u0000\u06c2\u06c3\u0001\u0000\u0000\u0000\u06c3\u013d\u0001\u0000"+
		"\u0000\u0000\u06c4\u06de\u0003\u0004\u0002\u0000\u06c5\u06ca\u0003.\u0017"+
		"\u0000\u06c6\u06c7\u0005@\u0000\u0000\u06c7\u06c9\u0005A\u0000\u0000\u06c8"+
		"\u06c6\u0001\u0000\u0000\u0000\u06c9\u06cc\u0001\u0000\u0000\u0000\u06ca"+
		"\u06c8\u0001\u0000\u0000\u0000\u06ca\u06cb\u0001\u0000\u0000\u0000\u06cb"+
		"\u06cd\u0001\u0000\u0000\u0000\u06cc\u06ca\u0001\u0000\u0000\u0000\u06cd"+
		"\u06ce\u0005D\u0000\u0000\u06ce\u06cf\u0005\f\u0000\u0000\u06cf\u06de"+
		"\u0001\u0000\u0000\u0000\u06d0\u06d1\u00053\u0000\u0000\u06d1\u06d2\u0005"+
		"D\u0000\u0000\u06d2\u06de\u0005\f\u0000\u0000\u06d3\u06de\u0005.\u0000"+
		"\u0000\u06d4\u06d5\u0003.\u0017\u0000\u06d5\u06d6\u0005D\u0000\u0000\u06d6"+
		"\u06d7\u0005.\u0000\u0000\u06d7\u06de\u0001\u0000\u0000\u0000\u06d8\u06de"+
		"\u0003\u013a\u009d\u0000\u06d9\u06de\u0003\u0156\u00ab\u0000\u06da\u06de"+
		"\u0003\u015e\u00af\u0000\u06db\u06de\u0003\u016a\u00b5\u0000\u06dc\u06de"+
		"\u0003\u0174\u00ba\u0000\u06dd\u06c4\u0001\u0000\u0000\u0000\u06dd\u06c5"+
		"\u0001\u0000\u0000\u0000\u06dd\u06d0\u0001\u0000\u0000\u0000\u06dd\u06d3"+
		"\u0001\u0000\u0000\u0000\u06dd\u06d4\u0001\u0000\u0000\u0000\u06dd\u06d8"+
		"\u0001\u0000\u0000\u0000\u06dd\u06d9\u0001\u0000\u0000\u0000\u06dd\u06da"+
		"\u0001\u0000\u0000\u0000\u06dd\u06db\u0001\u0000\u0000\u0000\u06dd\u06dc"+
		"\u0001\u0000\u0000\u0000\u06de\u013f\u0001\u0000\u0000\u0000\u06df\u06e5"+
		"\u0003\u0158\u00ac\u0000\u06e0\u06e5\u0003\u0160\u00b0\u0000\u06e1\u06e5"+
		"\u0003\u0166\u00b3\u0000\u06e2\u06e5\u0003\u016e\u00b7\u0000\u06e3\u06e5"+
		"\u0003\u0176\u00bb\u0000\u06e4\u06df\u0001\u0000\u0000\u0000\u06e4\u06e0"+
		"\u0001\u0000\u0000\u0000\u06e4\u06e1\u0001\u0000\u0000\u0000\u06e4\u06e2"+
		"\u0001\u0000\u0000\u0000\u06e4\u06e3\u0001\u0000\u0000\u0000\u06e5\u0141"+
		"\u0001\u0000\u0000\u0000\u06e6\u06e7\u0001\u0000\u0000\u0000\u06e7\u0143"+
		"\u0001\u0000\u0000\u0000\u06e8\u06ed\u0003\u0158\u00ac\u0000\u06e9\u06ed"+
		"\u0003\u0160\u00b0\u0000\u06ea\u06ed\u0003\u016e\u00b7\u0000\u06eb\u06ed"+
		"\u0003\u0176\u00bb\u0000\u06ec\u06e8\u0001\u0000\u0000\u0000\u06ec\u06e9"+
		"\u0001\u0000\u0000\u0000\u06ec\u06ea\u0001\u0000\u0000\u0000\u06ec\u06eb"+
		"\u0001\u0000\u0000\u0000\u06ed\u0145\u0001\u0000\u0000\u0000\u06ee\u06f2"+
		"\u0003\u0148\u00a4\u0000\u06ef\u06f1\u0003\u014c\u00a6\u0000\u06f0\u06ef"+
		"\u0001\u0000\u0000\u0000\u06f1\u06f4\u0001\u0000\u0000\u0000\u06f2\u06f0"+
		"\u0001\u0000\u0000\u0000\u06f2\u06f3\u0001\u0000\u0000\u0000\u06f3\u06f5"+
		"\u0001\u0000\u0000\u0000\u06f4\u06f2\u0001\u0000\u0000\u0000\u06f5\u06f6"+
		"\u0005D\u0000\u0000\u06f6\u06f7\u0005\f\u0000\u0000\u06f7\u0147\u0001"+
		"\u0000\u0000\u0000\u06f8\u06fc\u0003.\u0017\u0000\u06f9\u06fc\u0003\\"+
		".\u0000\u06fa\u06fc\u0003\u014a\u00a5\u0000\u06fb\u06f8\u0001\u0000\u0000"+
		"\u0000\u06fb\u06f9\u0001\u0000\u0000\u0000\u06fb\u06fa\u0001\u0000\u0000"+
		"\u0000\u06fc\u0149\u0001\u0000\u0000\u0000\u06fd\u06fe\u00053\u0000\u0000"+
		"\u06fe\u014b\u0001\u0000\u0000\u0000\u06ff\u0700\u0005@\u0000\u0000\u0700"+
		"\u0701\u0005A\u0000\u0000\u0701\u014d\u0001\u0000\u0000\u0000\u0702\u0710"+
		"\u0003\u0004\u0002\u0000\u0703\u0710\u0003\u0146\u00a3\u0000\u0704\u0710"+
		"\u0005.\u0000\u0000\u0705\u0706\u0003.\u0017\u0000\u0706\u0707\u0005D"+
		"\u0000\u0000\u0707\u0708\u0005.\u0000\u0000\u0708\u0710\u0001\u0000\u0000"+
		"\u0000\u0709\u0710\u0003\u013a\u009d\u0000\u070a\u0710\u0003\u015a\u00ad"+
		"\u0000\u070b\u0710\u0003\u0162\u00b1\u0000\u070c\u0710\u0003\u0168\u00b4"+
		"\u0000\u070d\u0710\u0003\u0170\u00b8\u0000\u070e\u0710\u0003\u0178\u00bc"+
		"\u0000\u070f\u0702\u0001\u0000\u0000\u0000\u070f\u0703\u0001\u0000\u0000"+
		"\u0000\u070f\u0704\u0001\u0000\u0000\u0000\u070f\u0705\u0001\u0000\u0000"+
		"\u0000\u070f\u0709\u0001\u0000\u0000\u0000\u070f\u070a\u0001\u0000\u0000"+
		"\u0000\u070f\u070b\u0001\u0000\u0000\u0000\u070f\u070c\u0001\u0000\u0000"+
		"\u0000\u070f\u070d\u0001\u0000\u0000\u0000\u070f\u070e\u0001\u0000\u0000"+
		"\u0000\u0710\u014f\u0001\u0000\u0000\u0000\u0711\u0712\u0001\u0000\u0000"+
		"\u0000\u0712\u0151\u0001\u0000\u0000\u0000\u0713\u0720\u0003\u0004\u0002"+
		"\u0000\u0714\u0720\u0003\u0146\u00a3\u0000\u0715\u0720\u0005.\u0000\u0000"+
		"\u0716\u0717\u0003.\u0017\u0000\u0717\u0718\u0005D\u0000\u0000\u0718\u0719"+
		"\u0005.\u0000\u0000\u0719\u0720\u0001\u0000\u0000\u0000\u071a\u0720\u0003"+
		"\u013a\u009d\u0000\u071b\u0720\u0003\u015a\u00ad\u0000\u071c\u0720\u0003"+
		"\u0162\u00b1\u0000\u071d\u0720\u0003\u0170\u00b8\u0000\u071e\u0720\u0003"+
		"\u0178\u00bc\u0000\u071f\u0713\u0001\u0000\u0000\u0000\u071f\u0714\u0001"+
		"\u0000\u0000\u0000\u071f\u0715\u0001\u0000\u0000\u0000\u071f\u0716\u0001"+
		"\u0000\u0000\u0000\u071f\u071a\u0001\u0000\u0000\u0000\u071f\u071b\u0001"+
		"\u0000\u0000\u0000\u071f\u071c\u0001\u0000\u0000\u0000\u071f\u071d\u0001"+
		"\u0000\u0000\u0000\u071f\u071e\u0001\u0000\u0000\u0000\u0720\u0153\u0001"+
		"\u0000\u0000\u0000\u0721\u0722\u00030\u0018\u0000\u0722\u0155\u0001\u0000"+
		"\u0000\u0000\u0723\u0725\u0005\"\u0000\u0000\u0724\u0726\u0003\"\u0011"+
		"\u0000\u0725\u0724\u0001\u0000\u0000\u0000\u0725\u0726\u0001\u0000\u0000"+
		"\u0000\u0726\u0727\u0001\u0000\u0000\u0000\u0727\u0729\u0003\u0154\u00aa"+
		"\u0000\u0728\u072a\u0003\u015c\u00ae\u0000\u0729\u0728\u0001\u0000\u0000"+
		"\u0000\u0729\u072a\u0001\u0000\u0000\u0000\u072a\u072b\u0001\u0000\u0000"+
		"\u0000\u072b\u072d\u0005<\u0000\u0000\u072c\u072e\u0003\u0172\u00b9\u0000"+
		"\u072d\u072c\u0001\u0000\u0000\u0000\u072d\u072e\u0001\u0000\u0000\u0000"+
		"\u072e\u072f\u0001\u0000\u0000\u0000\u072f\u0731\u0005=\u0000\u0000\u0730"+
		"\u0732\u0003L&\u0000\u0731\u0730\u0001\u0000\u0000\u0000\u0731\u0732\u0001"+
		"\u0000\u0000\u0000\u0732\u0157\u0001\u0000\u0000\u0000\u0733\u0734\u0005"+
		"D\u0000\u0000\u0734\u0736\u0005\"\u0000\u0000\u0735\u0737\u0003\"\u0011"+
		"\u0000\u0736\u0735\u0001\u0000\u0000\u0000\u0736\u0737\u0001\u0000\u0000"+
		"\u0000\u0737\u073b\u0001\u0000\u0000\u0000\u0738\u073a\u0003\u00ba]\u0000"+
		"\u0739\u0738\u0001\u0000\u0000\u0000\u073a\u073d\u0001\u0000\u0000\u0000"+
		"\u073b\u0739\u0001\u0000\u0000\u0000\u073b\u073c\u0001\u0000\u0000\u0000"+
		"\u073c\u073e\u0001\u0000\u0000\u0000\u073d\u073b\u0001\u0000\u0000\u0000"+
		"\u073e\u0740\u0005i\u0000\u0000\u073f\u0741\u0003\u015c\u00ae\u0000\u0740"+
		"\u073f\u0001\u0000\u0000\u0000\u0740\u0741\u0001\u0000\u0000\u0000\u0741"+
		"\u0742\u0001\u0000\u0000\u0000\u0742\u0744\u0005<\u0000\u0000\u0743\u0745"+
		"\u0003\u0172\u00b9\u0000\u0744\u0743\u0001\u0000\u0000\u0000\u0744\u0745"+
		"\u0001\u0000\u0000\u0000\u0745\u0746\u0001\u0000\u0000\u0000\u0746\u0748"+
		"\u0005=\u0000\u0000\u0747\u0749\u0003L&\u0000\u0748\u0747\u0001\u0000"+
		"\u0000\u0000\u0748\u0749\u0001\u0000\u0000\u0000\u0749\u0159\u0001\u0000"+
		"\u0000\u0000\u074a\u074c\u0005\"\u0000\u0000\u074b\u074d\u0003\"\u0011"+
		"\u0000\u074c\u074b\u0001\u0000\u0000\u0000\u074c\u074d\u0001\u0000\u0000"+
		"\u0000\u074d\u0751\u0001\u0000\u0000\u0000\u074e\u0750\u0003\u00ba]\u0000"+
		"\u074f\u074e\u0001\u0000\u0000\u0000\u0750\u0753\u0001\u0000\u0000\u0000"+
		"\u0751\u074f\u0001\u0000\u0000\u0000\u0751\u0752\u0001\u0000\u0000\u0000"+
		"\u0752\u0754\u0001\u0000\u0000\u0000\u0753\u0751\u0001\u0000\u0000\u0000"+
		"\u0754\u075f\u0005i\u0000\u0000\u0755\u0759\u0005D\u0000\u0000\u0756\u0758"+
		"\u0003\u00ba]\u0000\u0757\u0756\u0001\u0000\u0000\u0000\u0758\u075b\u0001"+
		"\u0000\u0000\u0000\u0759\u0757\u0001\u0000\u0000\u0000\u0759\u075a\u0001"+
		"\u0000\u0000\u0000\u075a\u075c\u0001\u0000\u0000\u0000\u075b\u0759\u0001"+
		"\u0000\u0000\u0000\u075c\u075e\u0005i\u0000\u0000\u075d\u0755\u0001\u0000"+
		"\u0000\u0000\u075e\u0761\u0001\u0000\u0000\u0000\u075f\u075d\u0001\u0000"+
		"\u0000\u0000\u075f\u0760\u0001\u0000\u0000\u0000\u0760\u0763\u0001\u0000"+
		"\u0000\u0000\u0761\u075f\u0001\u0000\u0000\u0000\u0762\u0764\u0003\u015c"+
		"\u00ae\u0000\u0763\u0762\u0001\u0000\u0000\u0000\u0763\u0764\u0001\u0000"+
		"\u0000\u0000\u0764\u0765\u0001\u0000\u0000\u0000\u0765\u0767\u0005<\u0000"+
		"\u0000\u0766\u0768\u0003\u0172\u00b9\u0000\u0767\u0766\u0001\u0000\u0000"+
		"\u0000\u0767\u0768\u0001\u0000\u0000\u0000\u0768\u0769\u0001\u0000\u0000"+
		"\u0000\u0769\u076b\u0005=\u0000\u0000\u076a\u076c\u0003L&\u0000\u076b"+
		"\u076a\u0001\u0000\u0000\u0000\u076b\u076c\u0001\u0000\u0000\u0000\u076c"+
		"\u0786\u0001\u0000\u0000\u0000\u076d\u076e\u00034\u001a\u0000\u076e\u076f"+
		"\u0005D\u0000\u0000\u076f\u0771\u0005\"\u0000\u0000\u0770\u0772\u0003"+
		"\"\u0011\u0000\u0771\u0770\u0001\u0000\u0000\u0000\u0771\u0772\u0001\u0000"+
		"\u0000\u0000\u0772\u0776\u0001\u0000\u0000\u0000\u0773\u0775\u0003\u00ba"+
		"]\u0000\u0774\u0773\u0001\u0000\u0000\u0000\u0775\u0778\u0001\u0000\u0000"+
		"\u0000\u0776\u0774\u0001\u0000\u0000\u0000\u0776\u0777\u0001\u0000\u0000"+
		"\u0000\u0777\u0779\u0001\u0000\u0000\u0000\u0778\u0776\u0001\u0000\u0000"+
		"\u0000\u0779\u077b\u0005i\u0000\u0000\u077a\u077c\u0003\u015c\u00ae\u0000"+
		"\u077b\u077a\u0001\u0000\u0000\u0000\u077b\u077c\u0001\u0000\u0000\u0000"+
		"\u077c\u077d\u0001\u0000\u0000\u0000\u077d\u077f\u0005<\u0000\u0000\u077e"+
		"\u0780\u0003\u0172\u00b9\u0000\u077f\u077e\u0001\u0000\u0000\u0000\u077f"+
		"\u0780\u0001\u0000\u0000\u0000\u0780\u0781\u0001\u0000\u0000\u0000\u0781"+
		"\u0783\u0005=\u0000\u0000\u0782\u0784\u0003L&\u0000\u0783\u0782\u0001"+
		"\u0000\u0000\u0000\u0783\u0784\u0001\u0000\u0000\u0000\u0784\u0786\u0001"+
		"\u0000\u0000\u0000\u0785\u074a\u0001\u0000\u0000\u0000\u0785\u076d\u0001"+
		"\u0000\u0000\u0000\u0786\u015b\u0001\u0000\u0000\u0000\u0787\u078b\u0003"+
		"\"\u0011\u0000\u0788\u0789\u0005G\u0000\u0000\u0789\u078b\u0005F\u0000"+
		"\u0000\u078a\u0787\u0001\u0000\u0000\u0000\u078a\u0788\u0001\u0000\u0000"+
		"\u0000\u078b\u015d\u0001\u0000\u0000\u0000\u078c\u078d\u0003\u0138\u009c"+
		"\u0000\u078d\u078e\u0005D\u0000\u0000\u078e\u078f\u0003\u01b2\u00d9\u0000"+
		"\u078f\u079a\u0001\u0000\u0000\u0000\u0790\u0791\u0005+\u0000\u0000\u0791"+
		"\u0792\u0005D\u0000\u0000\u0792\u079a\u0003\u01b2\u00d9\u0000\u0793\u0794"+
		"\u0003.\u0017\u0000\u0794\u0795\u0005D\u0000\u0000\u0795\u0796\u0005+"+
		"\u0000\u0000\u0796\u0797\u0005D\u0000\u0000\u0797\u0798\u0003\u01b2\u00d9"+
		"\u0000\u0798\u079a\u0001\u0000\u0000\u0000\u0799\u078c\u0001\u0000\u0000"+
		"\u0000\u0799\u0790\u0001\u0000\u0000\u0000\u0799\u0793\u0001\u0000\u0000"+
		"\u0000\u079a\u015f\u0001\u0000\u0000\u0000\u079b\u079c\u0005D\u0000\u0000"+
		"\u079c\u079d\u0003\u01b2\u00d9\u0000\u079d\u0161\u0001\u0000\u0000\u0000"+
		"\u079e\u079f\u0005+\u0000\u0000\u079f\u07a0\u0005D\u0000\u0000\u07a0\u07a8"+
		"\u0003\u01b2\u00d9\u0000\u07a1\u07a2\u0003.\u0017\u0000\u07a2\u07a3\u0005"+
		"D\u0000\u0000\u07a3\u07a4\u0005+\u0000\u0000\u07a4\u07a5\u0005D\u0000"+
		"\u0000\u07a5\u07a6\u0003\u01b2\u00d9\u0000\u07a6\u07a8\u0001\u0000\u0000"+
		"\u0000\u07a7\u079e\u0001\u0000\u0000\u0000\u07a7\u07a1\u0001\u0000\u0000"+
		"\u0000\u07a8\u0163\u0001\u0000\u0000\u0000\u07a9\u07aa\u00034\u001a\u0000"+
		"\u07aa\u07ab\u0005@\u0000\u0000\u07ab\u07ac\u0003\u0180\u00c0\u0000\u07ac"+
		"\u07ad\u0005A\u0000\u0000\u07ad\u07b4\u0001\u0000\u0000\u0000\u07ae\u07af"+
		"\u0003\u013e\u009f\u0000\u07af\u07b0\u0005@\u0000\u0000\u07b0\u07b1\u0003"+
		"\u0180\u00c0\u0000\u07b1\u07b2\u0005A\u0000\u0000\u07b2\u07b4\u0001\u0000"+
		"\u0000\u0000\u07b3\u07a9\u0001\u0000\u0000\u0000\u07b3\u07ae\u0001\u0000"+
		"\u0000\u0000\u07b4\u07bc\u0001\u0000\u0000\u0000\u07b5\u07b6\u0003\u013c"+
		"\u009e\u0000\u07b6\u07b7\u0005@\u0000\u0000\u07b7\u07b8\u0003\u0180\u00c0"+
		"\u0000\u07b8\u07b9\u0005A\u0000\u0000\u07b9\u07bb\u0001\u0000\u0000\u0000"+
		"\u07ba\u07b5\u0001\u0000\u0000\u0000\u07bb\u07be\u0001\u0000\u0000\u0000"+
		"\u07bc\u07ba\u0001\u0000\u0000\u0000\u07bc\u07bd\u0001\u0000\u0000\u0000"+
		"\u07bd\u0165\u0001\u0000\u0000\u0000\u07be\u07bc\u0001\u0000\u0000\u0000"+
		"\u07bf\u07c0\u0003\u0144\u00a2\u0000\u07c0\u07c1\u0005@\u0000\u0000\u07c1"+
		"\u07c2\u0003\u0180\u00c0\u0000\u07c2\u07c3\u0005A\u0000\u0000\u07c3\u07cb"+
		"\u0001\u0000\u0000\u0000\u07c4\u07c5\u0003\u0142\u00a1\u0000\u07c5\u07c6"+
		"\u0005@\u0000\u0000\u07c6\u07c7\u0003\u0180\u00c0\u0000\u07c7\u07c8\u0005"+
		"A\u0000\u0000\u07c8\u07ca\u0001\u0000\u0000\u0000\u07c9\u07c4\u0001\u0000"+
		"\u0000\u0000\u07ca\u07cd\u0001\u0000\u0000\u0000\u07cb\u07c9\u0001\u0000"+
		"\u0000\u0000\u07cb\u07cc\u0001\u0000\u0000\u0000\u07cc\u0167\u0001\u0000"+
		"\u0000\u0000\u07cd\u07cb\u0001\u0000\u0000\u0000\u07ce\u07cf\u00034\u001a"+
		"\u0000\u07cf\u07d0\u0005@\u0000\u0000\u07d0\u07d1\u0003\u0180\u00c0\u0000"+
		"\u07d1\u07d2\u0005A\u0000\u0000\u07d2\u07d9\u0001\u0000\u0000\u0000\u07d3"+
		"\u07d4\u0003\u0152\u00a9\u0000\u07d4\u07d5\u0005@\u0000\u0000\u07d5\u07d6"+
		"\u0003\u0180\u00c0\u0000\u07d6\u07d7\u0005A\u0000\u0000\u07d7\u07d9\u0001"+
		"\u0000\u0000\u0000\u07d8\u07ce\u0001\u0000\u0000\u0000\u07d8\u07d3\u0001"+
		"\u0000\u0000\u0000\u07d9\u07e1\u0001\u0000\u0000\u0000\u07da\u07db\u0003"+
		"\u0150\u00a8\u0000\u07db\u07dc\u0005@\u0000\u0000\u07dc\u07dd\u0003\u0180"+
		"\u00c0\u0000\u07dd\u07de\u0005A\u0000\u0000\u07de\u07e0\u0001\u0000\u0000"+
		"\u0000\u07df\u07da\u0001\u0000\u0000\u0000\u07e0\u07e3\u0001\u0000\u0000"+
		"\u0000\u07e1\u07df\u0001\u0000\u0000\u0000\u07e1\u07e2\u0001\u0000\u0000"+
		"\u0000\u07e2\u0169\u0001\u0000\u0000\u0000\u07e3\u07e1\u0001\u0000\u0000"+
		"\u0000\u07e4\u07e6\u0003\u016c\u00b6\u0000\u07e5\u07e4\u0001\u0000\u0000"+
		"\u0000\u07e5\u07e6\u0001\u0000\u0000\u0000\u07e6\u07e8\u0001\u0000\u0000"+
		"\u0000\u07e7\u07e9\u0003\"\u0011\u0000\u07e8\u07e7\u0001\u0000\u0000\u0000"+
		"\u07e8\u07e9\u0001\u0000\u0000\u0000\u07e9\u07ea\u0001\u0000\u0000\u0000"+
		"\u07ea\u07eb\u0003\u01b2\u00d9\u0000\u07eb\u07ed\u0005<\u0000\u0000\u07ec"+
		"\u07ee\u0003\u0172\u00b9\u0000\u07ed\u07ec\u0001\u0000\u0000\u0000\u07ed"+
		"\u07ee\u0001\u0000\u0000\u0000\u07ee\u07ef\u0001\u0000\u0000\u0000\u07ef"+
		"\u07f0\u0005=\u0000\u0000\u07f0\u016b\u0001\u0000\u0000\u0000\u07f1\u07fc"+
		"\u0003.\u0017\u0000\u07f2\u07fc\u00034\u001a\u0000\u07f3\u07fc\u0003\u0138"+
		"\u009c\u0000\u07f4\u07f5\u0005+\u0000\u0000\u07f5\u07fc\u0005D\u0000\u0000"+
		"\u07f6\u07f7\u0003.\u0017\u0000\u07f7\u07f8\u0005D\u0000\u0000\u07f8\u07f9"+
		"\u0005+\u0000\u0000\u07f9\u07fa\u0005D\u0000\u0000\u07fa\u07fc\u0001\u0000"+
		"\u0000\u0000\u07fb\u07f1\u0001\u0000\u0000\u0000\u07fb\u07f2\u0001\u0000"+
		"\u0000\u0000\u07fb\u07f3\u0001\u0000\u0000\u0000\u07fb\u07f4\u0001\u0000"+
		"\u0000\u0000\u07fb\u07f6\u0001\u0000\u0000\u0000\u07fc\u016d\u0001\u0000"+
		"\u0000\u0000\u07fd\u07ff\u0005D\u0000\u0000\u07fe\u0800\u0003\"\u0011"+
		"\u0000\u07ff\u07fe\u0001\u0000\u0000\u0000\u07ff\u0800\u0001\u0000\u0000"+
		"\u0000\u0800\u0801\u0001\u0000\u0000\u0000\u0801\u0802\u0003\u01b2\u00d9"+
		"\u0000\u0802\u0804\u0005<\u0000\u0000\u0803\u0805\u0003\u0172\u00b9\u0000"+
		"\u0804\u0803\u0001\u0000\u0000\u0000\u0804\u0805\u0001\u0000\u0000\u0000"+
		"\u0805\u0806\u0001\u0000\u0000\u0000\u0806\u0807\u0005=\u0000\u0000\u0807"+
		"\u016f\u0001\u0000\u0000\u0000\u0808\u0809\u0003\u01b2\u00d9\u0000\u0809"+
		"\u080b\u0005<\u0000\u0000\u080a\u080c\u0003\u0172\u00b9\u0000\u080b\u080a"+
		"\u0001\u0000\u0000\u0000\u080b\u080c\u0001\u0000\u0000\u0000\u080c\u080d"+
		"\u0001\u0000\u0000\u0000\u080d\u080e\u0005=\u0000\u0000\u080e\u0842\u0001"+
		"\u0000\u0000\u0000\u080f\u0810\u0003.\u0017\u0000\u0810\u0812\u0005D\u0000"+
		"\u0000\u0811\u0813\u0003\"\u0011\u0000\u0812\u0811\u0001\u0000\u0000\u0000"+
		"\u0812\u0813\u0001\u0000\u0000\u0000\u0813\u0814\u0001\u0000\u0000\u0000"+
		"\u0814\u0815\u0003\u01b2\u00d9\u0000\u0815\u0817\u0005<\u0000\u0000\u0816"+
		"\u0818\u0003\u0172\u00b9\u0000\u0817\u0816\u0001\u0000\u0000\u0000\u0817"+
		"\u0818\u0001\u0000\u0000\u0000\u0818\u0819\u0001\u0000\u0000\u0000\u0819"+
		"\u081a\u0005=\u0000\u0000\u081a\u0842\u0001\u0000\u0000\u0000\u081b\u081c"+
		"\u00034\u001a\u0000\u081c\u081e\u0005D\u0000\u0000\u081d\u081f\u0003\""+
		"\u0011\u0000\u081e\u081d\u0001\u0000\u0000\u0000\u081e\u081f\u0001\u0000"+
		"\u0000\u0000\u081f\u0820\u0001\u0000\u0000\u0000\u0820\u0821\u0003\u01b2"+
		"\u00d9\u0000\u0821\u0823\u0005<\u0000\u0000\u0822\u0824\u0003\u0172\u00b9"+
		"\u0000\u0823\u0822\u0001\u0000\u0000\u0000\u0823\u0824\u0001\u0000\u0000"+
		"\u0000\u0824\u0825\u0001\u0000\u0000\u0000\u0825\u0826\u0005=\u0000\u0000"+
		"\u0826\u0842\u0001\u0000\u0000\u0000\u0827\u0828\u0005+\u0000\u0000\u0828"+
		"\u082a\u0005D\u0000\u0000\u0829\u082b\u0003\"\u0011\u0000\u082a\u0829"+
		"\u0001\u0000\u0000\u0000\u082a\u082b\u0001\u0000\u0000\u0000\u082b\u082c"+
		"\u0001\u0000\u0000\u0000\u082c\u082d\u0003\u01b2\u00d9\u0000\u082d\u082f"+
		"\u0005<\u0000\u0000\u082e\u0830\u0003\u0172\u00b9\u0000\u082f\u082e\u0001"+
		"\u0000\u0000\u0000\u082f\u0830\u0001\u0000\u0000\u0000\u0830\u0831\u0001"+
		"\u0000\u0000\u0000\u0831\u0832\u0005=\u0000\u0000\u0832\u0842\u0001\u0000"+
		"\u0000\u0000\u0833\u0834\u0003.\u0017\u0000\u0834\u0835\u0005D\u0000\u0000"+
		"\u0835\u0836\u0005+\u0000\u0000\u0836\u0838\u0005D\u0000\u0000\u0837\u0839"+
		"\u0003\"\u0011\u0000\u0838\u0837\u0001\u0000\u0000\u0000\u0838\u0839\u0001"+
		"\u0000\u0000\u0000\u0839\u083a\u0001\u0000\u0000\u0000\u083a\u083b\u0003"+
		"\u01b2\u00d9\u0000\u083b\u083d\u0005<\u0000\u0000\u083c\u083e\u0003\u0172"+
		"\u00b9\u0000\u083d\u083c\u0001\u0000\u0000\u0000\u083d\u083e\u0001\u0000"+
		"\u0000\u0000\u083e\u083f\u0001\u0000\u0000\u0000\u083f\u0840\u0005=\u0000"+
		"\u0000\u0840\u0842\u0001\u0000\u0000\u0000\u0841\u0808\u0001\u0000\u0000"+
		"\u0000\u0841\u080f\u0001\u0000\u0000\u0000\u0841\u081b\u0001\u0000\u0000"+
		"\u0000\u0841\u0827\u0001\u0000\u0000\u0000\u0841\u0833\u0001\u0000\u0000"+
		"\u0000\u0842\u0171\u0001\u0000\u0000\u0000\u0843\u0848\u0003\u0180\u00c0"+
		"\u0000\u0844\u0845\u0005C\u0000\u0000\u0845\u0847\u0003\u0180\u00c0\u0000"+
		"\u0846\u0844\u0001\u0000\u0000\u0000\u0847\u084a\u0001\u0000\u0000\u0000"+
		"\u0848\u0846\u0001\u0000\u0000\u0000\u0848\u0849\u0001\u0000\u0000\u0000"+
		"\u0849\u0173\u0001\u0000\u0000\u0000\u084a\u0848\u0001\u0000\u0000\u0000"+
		"\u084b\u084c\u00034\u001a\u0000\u084c\u084e\u0005]\u0000\u0000\u084d\u084f"+
		"\u0003\"\u0011\u0000\u084e\u084d\u0001\u0000\u0000\u0000\u084e\u084f\u0001"+
		"\u0000\u0000\u0000\u084f\u0850\u0001\u0000\u0000\u0000\u0850\u0851\u0003"+
		"\u01b2\u00d9\u0000\u0851\u087b\u0001\u0000\u0000\u0000\u0852\u0853\u0003"+
		"\u000e\u0007\u0000\u0853\u0855\u0005]\u0000\u0000\u0854\u0856\u0003\""+
		"\u0011\u0000\u0855\u0854\u0001\u0000\u0000\u0000\u0855\u0856\u0001\u0000"+
		"\u0000\u0000\u0856\u0857\u0001\u0000\u0000\u0000\u0857\u0858\u0003\u01b2"+
		"\u00d9\u0000\u0858\u087b\u0001\u0000\u0000\u0000\u0859\u085a\u0003\u0138"+
		"\u009c\u0000\u085a\u085c\u0005]\u0000\u0000\u085b\u085d\u0003\"\u0011"+
		"\u0000\u085c\u085b\u0001\u0000\u0000\u0000\u085c\u085d\u0001\u0000\u0000"+
		"\u0000\u085d\u085e\u0001\u0000\u0000\u0000\u085e\u085f\u0003\u01b2\u00d9"+
		"\u0000\u085f\u087b\u0001\u0000\u0000\u0000\u0860\u0861\u0005+\u0000\u0000"+
		"\u0861\u0863\u0005]\u0000\u0000\u0862\u0864\u0003\"\u0011\u0000\u0863"+
		"\u0862\u0001\u0000\u0000\u0000\u0863\u0864\u0001\u0000\u0000\u0000\u0864"+
		"\u0865\u0001\u0000\u0000\u0000\u0865\u087b\u0003\u01b2\u00d9\u0000\u0866"+
		"\u0867\u0003.\u0017\u0000\u0867\u0868\u0005D\u0000\u0000\u0868\u0869\u0005"+
		"+\u0000\u0000\u0869\u086b\u0005]\u0000\u0000\u086a\u086c\u0003\"\u0011"+
		"\u0000\u086b\u086a\u0001\u0000\u0000\u0000\u086b\u086c\u0001\u0000\u0000"+
		"\u0000\u086c\u086d\u0001\u0000\u0000\u0000\u086d\u086e\u0003\u01b2\u00d9"+
		"\u0000\u086e\u087b\u0001\u0000\u0000\u0000\u086f\u0870\u0003\u0010\b\u0000"+
		"\u0870\u0872\u0005]\u0000\u0000\u0871\u0873\u0003\"\u0011\u0000\u0872"+
		"\u0871\u0001\u0000\u0000\u0000\u0872\u0873\u0001\u0000\u0000\u0000\u0873"+
		"\u0874\u0001\u0000\u0000\u0000\u0874\u0875\u0005\"\u0000\u0000\u0875\u087b"+
		"\u0001\u0000\u0000\u0000\u0876\u0877\u0003\u0014\n\u0000\u0877\u0878\u0005"+
		"]\u0000\u0000\u0878\u0879\u0005\"\u0000\u0000\u0879\u087b\u0001\u0000"+
		"\u0000\u0000\u087a\u084b\u0001\u0000\u0000\u0000\u087a\u0852\u0001\u0000"+
		"\u0000\u0000\u087a\u0859\u0001\u0000\u0000\u0000\u087a\u0860\u0001\u0000"+
		"\u0000\u0000\u087a\u0866\u0001\u0000\u0000\u0000\u087a\u086f\u0001\u0000"+
		"\u0000\u0000\u087a\u0876\u0001\u0000\u0000\u0000\u087b\u0175\u0001\u0000"+
		"\u0000\u0000\u087c\u087e\u0005]\u0000\u0000\u087d\u087f\u0003\"\u0011"+
		"\u0000\u087e\u087d\u0001\u0000\u0000\u0000\u087e\u087f\u0001\u0000\u0000"+
		"\u0000\u087f\u0880\u0001\u0000\u0000\u0000\u0880\u0881\u0003\u01b2\u00d9"+
		"\u0000\u0881\u0177\u0001\u0000\u0000\u0000\u0882\u0883\u00034\u001a\u0000"+
		"\u0883\u0885\u0005]\u0000\u0000\u0884\u0886\u0003\"\u0011\u0000\u0885"+
		"\u0884\u0001\u0000\u0000\u0000\u0885\u0886\u0001\u0000\u0000\u0000\u0886"+
		"\u0887\u0001\u0000\u0000\u0000\u0887\u0888\u0003\u01b2\u00d9\u0000\u0888"+
		"\u08ab\u0001\u0000\u0000\u0000\u0889\u088a\u0003\u000e\u0007\u0000\u088a"+
		"\u088c\u0005]\u0000\u0000\u088b\u088d\u0003\"\u0011\u0000\u088c\u088b"+
		"\u0001\u0000\u0000\u0000\u088c\u088d\u0001\u0000\u0000\u0000\u088d\u088e"+
		"\u0001\u0000\u0000\u0000\u088e\u088f\u0003\u01b2\u00d9\u0000\u088f\u08ab"+
		"\u0001\u0000\u0000\u0000\u0890\u0891\u0005+\u0000\u0000\u0891\u0893\u0005"+
		"]\u0000\u0000\u0892\u0894\u0003\"\u0011\u0000\u0893\u0892\u0001\u0000"+
		"\u0000\u0000\u0893\u0894\u0001\u0000\u0000\u0000\u0894\u0895\u0001\u0000"+
		"\u0000\u0000\u0895\u08ab\u0003\u01b2\u00d9\u0000\u0896\u0897\u0003.\u0017"+
		"\u0000\u0897\u0898\u0005D\u0000\u0000\u0898\u0899\u0005+\u0000\u0000\u0899"+
		"\u089b\u0005]\u0000\u0000\u089a\u089c\u0003\"\u0011\u0000\u089b\u089a"+
		"\u0001\u0000\u0000\u0000\u089b\u089c\u0001\u0000\u0000\u0000\u089c\u089d"+
		"\u0001\u0000\u0000\u0000\u089d\u089e\u0003\u01b2\u00d9\u0000\u089e\u08ab"+
		"\u0001\u0000\u0000\u0000\u089f\u08a0\u0003\u0010\b\u0000\u08a0\u08a2\u0005"+
		"]\u0000\u0000\u08a1\u08a3\u0003\"\u0011\u0000\u08a2\u08a1\u0001\u0000"+
		"\u0000\u0000\u08a2\u08a3\u0001\u0000\u0000\u0000\u08a3\u08a4\u0001\u0000"+
		"\u0000\u0000\u08a4\u08a5\u0005\"\u0000\u0000\u08a5\u08ab\u0001\u0000\u0000"+
		"\u0000\u08a6\u08a7\u0003\u0014\n\u0000\u08a7\u08a8\u0005]\u0000\u0000"+
		"\u08a8\u08a9\u0005\"\u0000\u0000\u08a9\u08ab\u0001\u0000\u0000\u0000\u08aa"+
		"\u0882\u0001\u0000\u0000\u0000\u08aa\u0889\u0001\u0000\u0000\u0000\u08aa"+
		"\u0890\u0001\u0000\u0000\u0000\u08aa\u0896\u0001\u0000\u0000\u0000\u08aa"+
		"\u089f\u0001\u0000\u0000\u0000\u08aa\u08a6\u0001\u0000\u0000\u0000\u08ab"+
		"\u0179\u0001\u0000\u0000\u0000\u08ac\u08ad\u0005\"\u0000\u0000\u08ad\u08ae"+
		"\u0003\u0006\u0003\u0000\u08ae\u08b0\u0003\u017c\u00be\u0000\u08af\u08b1"+
		"\u0003\u0018\f\u0000\u08b0\u08af\u0001\u0000\u0000\u0000\u08b0\u08b1\u0001"+
		"\u0000\u0000\u0000\u08b1\u08c3\u0001\u0000\u0000\u0000\u08b2\u08b3\u0005"+
		"\"\u0000\u0000\u08b3\u08b4\u0003\u0010\b\u0000\u08b4\u08b6\u0003\u017c"+
		"\u00be\u0000\u08b5\u08b7\u0003\u0018\f\u0000\u08b6\u08b5\u0001\u0000\u0000"+
		"\u0000\u08b6\u08b7\u0001\u0000\u0000\u0000\u08b7\u08c3\u0001\u0000\u0000"+
		"\u0000\u08b8\u08b9\u0005\"\u0000\u0000\u08b9\u08ba\u0003\u0006\u0003\u0000"+
		"\u08ba\u08bb\u0003\u0018\f\u0000\u08bb\u08bc\u0003\u00ccf\u0000\u08bc"+
		"\u08c3\u0001\u0000\u0000\u0000\u08bd\u08be\u0005\"\u0000\u0000\u08be\u08bf"+
		"\u0003\u0010\b\u0000\u08bf\u08c0\u0003\u0018\f\u0000\u08c0\u08c1\u0003"+
		"\u00ccf\u0000\u08c1\u08c3\u0001\u0000\u0000\u0000\u08c2\u08ac\u0001\u0000"+
		"\u0000\u0000\u08c2\u08b2\u0001\u0000\u0000\u0000\u08c2\u08b8\u0001\u0000"+
		"\u0000\u0000\u08c2\u08bd\u0001\u0000\u0000\u0000\u08c3\u017b\u0001\u0000"+
		"\u0000\u0000\u08c4\u08c8\u0003\u017e\u00bf\u0000\u08c5\u08c7\u0003\u017e"+
		"\u00bf\u0000\u08c6\u08c5\u0001\u0000\u0000\u0000\u08c7\u08ca\u0001\u0000"+
		"\u0000\u0000\u08c8\u08c6\u0001\u0000\u0000\u0000\u08c8\u08c9\u0001\u0000"+
		"\u0000\u0000\u08c9\u017d\u0001\u0000\u0000\u0000\u08ca\u08c8\u0001\u0000"+
		"\u0000\u0000\u08cb\u08cd\u0003\u00ba]\u0000\u08cc\u08cb\u0001\u0000\u0000"+
		"\u0000\u08cd\u08d0\u0001\u0000\u0000\u0000\u08ce\u08cc\u0001\u0000\u0000"+
		"\u0000\u08ce\u08cf\u0001\u0000\u0000\u0000\u08cf\u08d1\u0001\u0000\u0000"+
		"\u0000\u08d0\u08ce\u0001\u0000\u0000\u0000\u08d1\u08d2\u0005@\u0000\u0000"+
		"\u08d2\u08d3\u0003\u0180\u00c0\u0000\u08d3\u08d4\u0005A\u0000\u0000\u08d4"+
		"\u017f\u0001\u0000\u0000\u0000\u08d5\u08d9\u0003\u0182\u00c1\u0000\u08d6"+
		"\u08d9\u0003\u0190\u00c8\u0000\u08d7\u08d9\u0003\u019a\u00cd\u0000\u08d8"+
		"\u08d5\u0001\u0000\u0000\u0000\u08d8\u08d6\u0001\u0000\u0000\u0000\u08d8"+
		"\u08d7\u0001\u0000\u0000\u0000\u08d9\u0181\u0001\u0000\u0000\u0000\u08da"+
		"\u08db\u0003\u0184\u00c2\u0000\u08db\u08dc\u0005\\\u0000\u0000\u08dc\u08dd"+
		"\u0003\u018e\u00c7\u0000\u08dd\u0183\u0001\u0000\u0000\u0000\u08de\u08e2"+
		"\u0003\u0188\u00c4\u0000\u08df\u08e2\u0003\u018a\u00c5\u0000\u08e0\u08e2"+
		"\u0003\u0186\u00c3\u0000\u08e1\u08de\u0001\u0000\u0000\u0000\u08e1\u08df"+
		"\u0001\u0000\u0000\u0000\u08e1\u08e0\u0001\u0000\u0000\u0000\u08e2\u0185"+
		"\u0001\u0000\u0000\u0000\u08e3\u08e4\u0005<\u0000\u0000\u08e4\u08e5\u0003"+
		"\u018c\u00c6\u0000\u08e5\u08e6\u0005=\u0000\u0000\u08e6\u0187\u0001\u0000"+
		"\u0000\u0000\u08e7\u08e8\u0003\u01b2\u00d9\u0000\u08e8\u0189\u0001\u0000"+
		"\u0000\u0000\u08e9\u08eb\u0005<\u0000\u0000\u08ea\u08ec\u0003x<\u0000"+
		"\u08eb\u08ea\u0001\u0000\u0000\u0000\u08eb\u08ec\u0001\u0000\u0000\u0000"+
		"\u08ec\u08ed\u0001\u0000\u0000\u0000\u08ed\u08ee\u0005=\u0000\u0000\u08ee"+
		"\u018b\u0001\u0000\u0000\u0000\u08ef\u08f4\u0003\u01b2\u00d9\u0000\u08f0"+
		"\u08f1\u0005C\u0000\u0000\u08f1\u08f3\u0003\u01b2\u00d9\u0000\u08f2\u08f0"+
		"\u0001\u0000\u0000\u0000\u08f3\u08f6\u0001\u0000\u0000\u0000\u08f4\u08f2"+
		"\u0001\u0000\u0000\u0000\u08f4\u08f5\u0001\u0000\u0000\u0000\u08f5\u018d"+
		"\u0001\u0000\u0000\u0000\u08f6\u08f4\u0001\u0000\u0000\u0000\u08f7\u08fa"+
		"\u0003\u0180\u00c0\u0000\u08f8\u08fa\u0003\u00d0h\u0000\u08f9\u08f7\u0001"+
		"\u0000\u0000\u0000\u08f9\u08f8\u0001\u0000\u0000\u0000\u08fa\u018f\u0001"+
		"\u0000\u0000\u0000\u08fb\u08fc\u0003\u0192\u00c9\u0000\u08fc\u0191\u0001"+
		"\u0000\u0000\u0000\u08fd\u08fe\u0003\u0194\u00ca\u0000\u08fe\u08ff\u0003"+
		"\u0196\u00cb\u0000\u08ff\u0900\u0003\u0180\u00c0\u0000\u0900\u0193\u0001"+
		"\u0000\u0000\u0000\u0901\u0905\u00034\u001a\u0000\u0902\u0905\u0003\u015e"+
		"\u00af\u0000\u0903\u0905\u0003\u0164\u00b2\u0000\u0904\u0901\u0001\u0000"+
		"\u0000\u0000\u0904\u0902\u0001\u0000\u0000\u0000\u0904\u0903\u0001\u0000"+
		"\u0000\u0000\u0905\u0195\u0001\u0000\u0000\u0000\u0906\u0907\u0007\u0004"+
		"\u0000\u0000\u0907\u0197\u0001\u0000\u0000\u0000\u0908\u0909\u0007\u0005"+
		"\u0000\u0000\u0909\u0199\u0001\u0000\u0000\u0000\u090a\u090b\u0006\u00cd"+
		"\uffff\uffff\u0000\u090b\u090c\u0003\u019c\u00ce\u0000\u090c\u0919\u0001"+
		"\u0000\u0000\u0000\u090d\u090e\n\u0003\u0000\u0000\u090e\u090f\u0003\u0198"+
		"\u00cc\u0000\u090f\u0910\u0003\u019a\u00cd\u0004\u0910\u0918\u0001\u0000"+
		"\u0000\u0000\u0911\u0912\n\u0002\u0000\u0000\u0912\u0913\u0005J\u0000"+
		"\u0000\u0913\u0914\u0003\u0180\u00c0\u0000\u0914\u0915\u0005K\u0000\u0000"+
		"\u0915\u0916\u0003\u019a\u00cd\u0003\u0916\u0918\u0001\u0000\u0000\u0000"+
		"\u0917\u090d\u0001\u0000\u0000\u0000\u0917\u0911\u0001\u0000\u0000\u0000"+
		"\u0918\u091b\u0001\u0000\u0000\u0000\u0919\u0917\u0001\u0000\u0000\u0000"+
		"\u0919\u091a\u0001\u0000\u0000\u0000\u091a\u019b\u0001\u0000\u0000\u0000"+
		"\u091b\u0919\u0001\u0000\u0000\u0000\u091c\u0921\u0003\u01a4\u00d2\u0000"+
		"\u091d\u0921\u0003\u01a6\u00d3\u0000\u091e\u0921\u0003\u019e\u00cf\u0000"+
		"\u091f\u0921\u0003\u01ac\u00d6\u0000\u0920\u091c\u0001\u0000\u0000\u0000"+
		"\u0920\u091d\u0001\u0000\u0000\u0000\u0920\u091e\u0001\u0000\u0000\u0000"+
		"\u0920\u091f\u0001\u0000\u0000\u0000\u0921\u019d\u0001\u0000\u0000\u0000"+
		"\u0922\u0923\u0003\u01a0\u00d0\u0000\u0923\u0924\u0003\u019c\u00ce\u0000"+
		"\u0924\u019f\u0001\u0000\u0000\u0000\u0925\u0926\u0007\u0006\u0000\u0000"+
		"\u0926\u01a1\u0001\u0000\u0000\u0000\u0927\u0928\u0007\u0007\u0000\u0000"+
		"\u0928\u01a3\u0001\u0000\u0000\u0000\u0929\u092a\u0003\u01a2\u00d1\u0000"+
		"\u092a\u092b\u0003\u019c\u00ce\u0000\u092b\u01a5\u0001\u0000\u0000\u0000"+
		"\u092c\u092f\u0003\u0138\u009c\u0000\u092d\u092f\u00034\u001a\u0000\u092e"+
		"\u092c\u0001\u0000\u0000\u0000\u092e\u092d\u0001\u0000\u0000\u0000\u092f"+
		"\u0931\u0001\u0000\u0000\u0000\u0930\u0932\u0003\u01a8\u00d4\u0000\u0931"+
		"\u0930\u0001\u0000\u0000\u0000\u0931\u0932\u0001\u0000\u0000\u0000\u0932"+
		"\u01a7\u0001\u0000\u0000\u0000\u0933\u0934\u0007\u0007\u0000\u0000\u0934"+
		"\u01a9\u0001\u0000\u0000\u0000\u0935\u0938\u0003\u0138\u009c\u0000\u0936"+
		"\u0938\u00034\u001a\u0000\u0937\u0935\u0001\u0000\u0000\u0000\u0937\u0936"+
		"\u0001\u0000\u0000\u0000\u0938\u0939\u0001\u0000\u0000\u0000\u0939\u093a"+
		"\u0003\u01a8\u00d4\u0000\u093a\u01ab\u0001\u0000\u0000\u0000\u093b\u093e"+
		"\u0003\u01ae\u00d7\u0000\u093c\u093e\u0003\u01b0\u00d8\u0000\u093d\u093b"+
		"\u0001\u0000\u0000\u0000\u093d\u093c\u0001\u0000\u0000\u0000\u093e\u01ad"+
		"\u0001\u0000\u0000\u0000\u093f\u0940\u0005<\u0000\u0000\u0940\u0941\u0003"+
		"\u0006\u0003\u0000\u0941\u0942\u0005=\u0000\u0000\u0942\u0943\u0003\u019c"+
		"\u00ce\u0000\u0943\u01af\u0001\u0000\u0000\u0000\u0944\u0945\u0005<\u0000"+
		"\u0000\u0945\u0949\u0003\u000e\u0007\u0000\u0946\u0948\u0003 \u0010\u0000"+
		"\u0947\u0946\u0001\u0000\u0000\u0000\u0948\u094b\u0001\u0000\u0000\u0000"+
		"\u0949\u0947\u0001\u0000\u0000\u0000\u0949\u094a\u0001\u0000\u0000\u0000"+
		"\u094a\u094c\u0001\u0000\u0000\u0000\u094b\u0949\u0001\u0000\u0000\u0000"+
		"\u094c\u094f\u0005=\u0000\u0000\u094d\u0950\u0003\u019c\u00ce\u0000\u094e"+
		"\u0950\u0003\u0182\u00c1\u0000\u094f\u094d\u0001\u0000\u0000\u0000\u094f"+
		"\u094e\u0001\u0000\u0000\u0000\u0950\u01b1\u0001\u0000\u0000\u0000\u0951"+
		"\u0952\u0005i\u0000\u0000\u0952\u01b3\u0001\u0000\u0000\u0000\u0111\u01b5"+
		"\u01ba\u01c0\u01cd\u01d2\u01d9\u01dd\u01e1\u01ea\u01f0\u01f5\u01fc\u0202"+
		"\u020b\u0210\u0215\u021d\u0222\u022b\u022e\u023c\u0241\u0245\u0251\u0258"+
		"\u0262\u026f\u0274\u0278\u0280\u0285\u028b\u0291\u0294\u0297\u02a0\u02b2"+
		"\u02b9\u02c6\u02cb\u02d1\u02dd\u02e3\u02e9\u02ee\u02f2\u02f6\u02fb\u02ff"+
		"\u0303\u0305\u030a\u0311\u0316\u0318\u031e\u0323\u0327\u0333\u0339\u033f"+
		"\u0341\u0346\u034c\u0355\u035b\u0361\u0363\u0367\u036c\u0376\u037d\u0385"+
		"\u0388\u038d\u0393\u039c\u03a3\u03aa\u03af\u03b6\u03c2\u03c7\u03cb\u03d5"+
		"\u03db\u03e0\u03e5\u03ea\u03f2\u03f5\u03fa\u03ff\u0404\u0409\u0410\u0415"+
		"\u041d\u0422\u0427\u042c\u0432\u0438\u043e\u0441\u0444\u044d\u0453\u0459"+
		"\u045c\u045f\u0465\u046a\u046f\u0475\u047b\u047e\u0489\u0493\u0498\u049e"+
		"\u04a8\u04ae\u04b2\u04ba\u04c0\u04cc\u04d6\u04db\u04e1\u04eb\u04ef\u04f9"+
		"\u04ff\u0508\u0512\u0516\u0519\u0522\u0530\u0533\u053c\u0543\u054b\u0550"+
		"\u0558\u055e\u056a\u0571\u057f\u0593\u05bf\u05cb\u05cf\u05d7\u05dc\u05f4"+
		"\u05f8\u05fd\u0601\u0605\u060d\u0611\u0615\u061c\u0625\u062d\u063c\u0648"+
		"\u064e\u0654\u0664\u066d\u0671\u0677\u067f\u0687\u0695\u0698\u069d\u06a6"+
		"\u06ac\u06b6\u06bb\u06ca\u06dd\u06e4\u06ec\u06f2\u06fb\u070f\u071f\u0725"+
		"\u0729\u072d\u0731\u0736\u073b\u0740\u0744\u0748\u074c\u0751\u0759\u075f"+
		"\u0763\u0767\u076b\u0771\u0776\u077b\u077f\u0783\u0785\u078a\u0799\u07a7"+
		"\u07b3\u07bc\u07cb\u07d8\u07e1\u07e5\u07e8\u07ed\u07fb\u07ff\u0804\u080b"+
		"\u0812\u0817\u081e\u0823\u082a\u082f\u0838\u083d\u0841\u0848\u084e\u0855"+
		"\u085c\u0863\u086b\u0872\u087a\u087e\u0885\u088c\u0893\u089b\u08a2\u08aa"+
		"\u08b0\u08b6\u08c2\u08c8\u08ce\u08d8\u08e1\u08eb\u08f4\u08f9\u0904\u0917"+
		"\u0919\u0920\u092e\u0931\u0937\u093d\u0949\u094f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}