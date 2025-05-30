// Generated from /storage/emulated/0/apk/python-stylerin-main/src/main/antlr/PythonParser.g4 by ANTLR 4.13.1
package com.ninjacoder.jgit.pythonformatter;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class PythonParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ENCODING=1, INDENT=2, DEDENT=3, TYPE_COMMENT=4, FSTRING_START=5, FSTRING_MIDDLE=6, 
		FSTRING_END=7, LPAR=8, LSQB=9, LBRACE=10, RPAR=11, RSQB=12, RBRACE=13, 
		DOT=14, COLON=15, COMMA=16, SEMI=17, PLUS=18, MINUS=19, STAR=20, SLASH=21, 
		VBAR=22, AMPER=23, LESS=24, GREATER=25, EQUAL=26, PERCENT=27, EQEQUAL=28, 
		NOTEQUAL=29, LESSEQUAL=30, GREATEREQUAL=31, TILDE=32, CIRCUMFLEX=33, LEFTSHIFT=34, 
		RIGHTSHIFT=35, DOUBLESTAR=36, PLUSEQUAL=37, MINEQUAL=38, STAREQUAL=39, 
		SLASHEQUAL=40, PERCENTEQUAL=41, AMPEREQUAL=42, VBAREQUAL=43, CIRCUMFLEXEQUAL=44, 
		LEFTSHIFTEQUAL=45, RIGHTSHIFTEQUAL=46, DOUBLESTAREQUAL=47, DOUBLESLASH=48, 
		DOUBLESLASHEQUAL=49, AT=50, ATEQUAL=51, RARROW=52, ELLIPSIS=53, COLONEQUAL=54, 
		EXCLAMATION=55, FALSE=56, AWAIT=57, ELSE=58, IMPORT=59, PASS=60, NONE=61, 
		BREAK=62, EXCEPT=63, IN=64, RAISE=65, TRUE=66, CLASS=67, FINALLY=68, IS=69, 
		RETURN=70, AND=71, CONTINUE=72, FOR=73, LAMBDA=74, TRY=75, AS=76, DEF=77, 
		FROM=78, NONLOCAL=79, WHILE=80, ASSERT=81, DEL=82, GLOBAL=83, NOT=84, 
		WITH=85, ASYNC=86, ELIF=87, IF=88, OR=89, YIELD=90, NAME_OR_TYPE=91, NAME_OR_MATCH=92, 
		NAME_OR_CASE=93, NAME_OR_WILDCARD=94, NAME=95, NUMBER=96, STRING=97, NEWLINE=98, 
		COMMENT=99, WS=100, EXPLICIT_LINE_JOINING=101, ERRORTOKEN=102;
	public static final int
		RULE_file_input = 0, RULE_interactive = 1, RULE_eval = 2, RULE_func_type = 3, 
		RULE_statements = 4, RULE_statement = 5, RULE_statement_newline = 6, RULE_simple_stmts = 7, 
		RULE_simple_stmt = 8, RULE_compound_stmt = 9, RULE_assignment = 10, RULE_annotated_rhs = 11, 
		RULE_augassign = 12, RULE_return_stmt = 13, RULE_raise_stmt = 14, RULE_global_stmt = 15, 
		RULE_nonlocal_stmt = 16, RULE_del_stmt = 17, RULE_yield_stmt = 18, RULE_assert_stmt = 19, 
		RULE_import_stmt = 20, RULE_import_name = 21, RULE_import_from = 22, RULE_import_from_targets = 23, 
		RULE_import_from_as_names = 24, RULE_import_from_as_name = 25, RULE_dotted_as_names = 26, 
		RULE_dotted_as_name = 27, RULE_dotted_name = 28, RULE_block = 29, RULE_decorators = 30, 
		RULE_class_def = 31, RULE_class_def_raw = 32, RULE_function_def = 33, 
		RULE_function_def_raw = 34, RULE_params = 35, RULE_parameters = 36, RULE_slash_no_default = 37, 
		RULE_slash_with_default = 38, RULE_star_etc = 39, RULE_kwds = 40, RULE_param_no_default = 41, 
		RULE_param_no_default_star_annotation = 42, RULE_param_with_default = 43, 
		RULE_param_maybe_default = 44, RULE_param = 45, RULE_param_star_annotation = 46, 
		RULE_annotation = 47, RULE_star_annotation = 48, RULE_default_assignment = 49, 
		RULE_if_stmt = 50, RULE_elif_stmt = 51, RULE_else_block = 52, RULE_while_stmt = 53, 
		RULE_for_stmt = 54, RULE_with_stmt = 55, RULE_with_item = 56, RULE_try_stmt = 57, 
		RULE_except_block = 58, RULE_except_star_block = 59, RULE_finally_block = 60, 
		RULE_match_stmt = 61, RULE_subject_expr = 62, RULE_case_block = 63, RULE_guard = 64, 
		RULE_patterns = 65, RULE_pattern = 66, RULE_as_pattern = 67, RULE_or_pattern = 68, 
		RULE_closed_pattern = 69, RULE_literal_pattern = 70, RULE_literal_expr = 71, 
		RULE_complex_number = 72, RULE_signed_number = 73, RULE_signed_real_number = 74, 
		RULE_real_number = 75, RULE_imaginary_number = 76, RULE_capture_pattern = 77, 
		RULE_pattern_capture_target = 78, RULE_wildcard_pattern = 79, RULE_value_pattern = 80, 
		RULE_attr = 81, RULE_name_or_attr = 82, RULE_group_pattern = 83, RULE_sequence_pattern = 84, 
		RULE_open_sequence_pattern = 85, RULE_maybe_sequence_pattern = 86, RULE_maybe_star_pattern = 87, 
		RULE_star_pattern = 88, RULE_mapping_pattern = 89, RULE_items_pattern = 90, 
		RULE_key_value_pattern = 91, RULE_double_star_pattern = 92, RULE_class_pattern = 93, 
		RULE_positional_patterns = 94, RULE_keyword_patterns = 95, RULE_keyword_pattern = 96, 
		RULE_type_alias = 97, RULE_type_params = 98, RULE_type_param_seq = 99, 
		RULE_type_param = 100, RULE_type_param_bound = 101, RULE_type_param_default = 102, 
		RULE_type_param_starred_default = 103, RULE_expressions = 104, RULE_expression = 105, 
		RULE_yield_expr = 106, RULE_star_expressions = 107, RULE_star_expression = 108, 
		RULE_star_named_expressions = 109, RULE_star_named_expression = 110, RULE_assignment_expression = 111, 
		RULE_named_expression = 112, RULE_disjunction = 113, RULE_conjunction = 114, 
		RULE_inversion = 115, RULE_comparison = 116, RULE_compare_op_bitwise_or_pair = 117, 
		RULE_eq_bitwise_or = 118, RULE_noteq_bitwise_or = 119, RULE_lte_bitwise_or = 120, 
		RULE_lt_bitwise_or = 121, RULE_gte_bitwise_or = 122, RULE_gt_bitwise_or = 123, 
		RULE_notin_bitwise_or = 124, RULE_in_bitwise_or = 125, RULE_isnot_bitwise_or = 126, 
		RULE_is_bitwise_or = 127, RULE_bitwise_or = 128, RULE_bitwise_xor = 129, 
		RULE_bitwise_and = 130, RULE_shift_expr = 131, RULE_sum = 132, RULE_term = 133, 
		RULE_factor = 134, RULE_power = 135, RULE_await_primary = 136, RULE_primary = 137, 
		RULE_slices = 138, RULE_slice = 139, RULE_atom = 140, RULE_group = 141, 
		RULE_lambdef = 142, RULE_lambda_params = 143, RULE_lambda_parameters = 144, 
		RULE_lambda_slash_no_default = 145, RULE_lambda_slash_with_default = 146, 
		RULE_lambda_star_etc = 147, RULE_lambda_kwds = 148, RULE_lambda_param_no_default = 149, 
		RULE_lambda_param_with_default = 150, RULE_lambda_param_maybe_default = 151, 
		RULE_lambda_param = 152, RULE_fstring_middle = 153, RULE_fstring_replacement_field = 154, 
		RULE_fstring_conversion = 155, RULE_fstring_full_format_spec = 156, RULE_fstring_format_spec = 157, 
		RULE_fstring = 158, RULE_string = 159, RULE_strings = 160, RULE_fstringOrString = 161, 
		RULE_list = 162, RULE_tuple = 163, RULE_set = 164, RULE_dict = 165, RULE_double_starred_kvpairs = 166, 
		RULE_double_starred_kvpair = 167, RULE_kvpair = 168, RULE_for_if_clauses = 169, 
		RULE_for_if_clause = 170, RULE_listcomp = 171, RULE_setcomp = 172, RULE_genexp = 173, 
		RULE_dictcomp = 174, RULE_arguments = 175, RULE_args = 176, RULE_firstPartOfArgs = 177, 
		RULE_secondPartOfArgs = 178, RULE_kwargs = 179, RULE_starred_expression = 180, 
		RULE_kwarg_or_starred = 181, RULE_kwarg_or_double_starred = 182, RULE_star_targets = 183, 
		RULE_star_targets_list_seq = 184, RULE_star_targets_tuple_seq = 185, RULE_star_target = 186, 
		RULE_target_with_star_atom = 187, RULE_star_atom = 188, RULE_single_target = 189, 
		RULE_single_subscript_attribute_target = 190, RULE_t_primary = 191, RULE_del_targets = 192, 
		RULE_del_target = 193, RULE_del_t_atom = 194, RULE_type_expressions = 195, 
		RULE_func_type_comment = 196, RULE_name_except_underscore = 197, RULE_name = 198;
	private static String[] makeRuleNames() {
		return new String[] {
			"file_input", "interactive", "eval", "func_type", "statements", "statement", 
			"statement_newline", "simple_stmts", "simple_stmt", "compound_stmt", 
			"assignment", "annotated_rhs", "augassign", "return_stmt", "raise_stmt", 
			"global_stmt", "nonlocal_stmt", "del_stmt", "yield_stmt", "assert_stmt", 
			"import_stmt", "import_name", "import_from", "import_from_targets", "import_from_as_names", 
			"import_from_as_name", "dotted_as_names", "dotted_as_name", "dotted_name", 
			"block", "decorators", "class_def", "class_def_raw", "function_def", 
			"function_def_raw", "params", "parameters", "slash_no_default", "slash_with_default", 
			"star_etc", "kwds", "param_no_default", "param_no_default_star_annotation", 
			"param_with_default", "param_maybe_default", "param", "param_star_annotation", 
			"annotation", "star_annotation", "default_assignment", "if_stmt", "elif_stmt", 
			"else_block", "while_stmt", "for_stmt", "with_stmt", "with_item", "try_stmt", 
			"except_block", "except_star_block", "finally_block", "match_stmt", "subject_expr", 
			"case_block", "guard", "patterns", "pattern", "as_pattern", "or_pattern", 
			"closed_pattern", "literal_pattern", "literal_expr", "complex_number", 
			"signed_number", "signed_real_number", "real_number", "imaginary_number", 
			"capture_pattern", "pattern_capture_target", "wildcard_pattern", "value_pattern", 
			"attr", "name_or_attr", "group_pattern", "sequence_pattern", "open_sequence_pattern", 
			"maybe_sequence_pattern", "maybe_star_pattern", "star_pattern", "mapping_pattern", 
			"items_pattern", "key_value_pattern", "double_star_pattern", "class_pattern", 
			"positional_patterns", "keyword_patterns", "keyword_pattern", "type_alias", 
			"type_params", "type_param_seq", "type_param", "type_param_bound", "type_param_default", 
			"type_param_starred_default", "expressions", "expression", "yield_expr", 
			"star_expressions", "star_expression", "star_named_expressions", "star_named_expression", 
			"assignment_expression", "named_expression", "disjunction", "conjunction", 
			"inversion", "comparison", "compare_op_bitwise_or_pair", "eq_bitwise_or", 
			"noteq_bitwise_or", "lte_bitwise_or", "lt_bitwise_or", "gte_bitwise_or", 
			"gt_bitwise_or", "notin_bitwise_or", "in_bitwise_or", "isnot_bitwise_or", 
			"is_bitwise_or", "bitwise_or", "bitwise_xor", "bitwise_and", "shift_expr", 
			"sum", "term", "factor", "power", "await_primary", "primary", "slices", 
			"slice", "atom", "group", "lambdef", "lambda_params", "lambda_parameters", 
			"lambda_slash_no_default", "lambda_slash_with_default", "lambda_star_etc", 
			"lambda_kwds", "lambda_param_no_default", "lambda_param_with_default", 
			"lambda_param_maybe_default", "lambda_param", "fstring_middle", "fstring_replacement_field", 
			"fstring_conversion", "fstring_full_format_spec", "fstring_format_spec", 
			"fstring", "string", "strings", "fstringOrString", "list", "tuple", "set", 
			"dict", "double_starred_kvpairs", "double_starred_kvpair", "kvpair", 
			"for_if_clauses", "for_if_clause", "listcomp", "setcomp", "genexp", "dictcomp", 
			"arguments", "args", "firstPartOfArgs", "secondPartOfArgs", "kwargs", 
			"starred_expression", "kwarg_or_starred", "kwarg_or_double_starred", 
			"star_targets", "star_targets_list_seq", "star_targets_tuple_seq", "star_target", 
			"target_with_star_atom", "star_atom", "single_target", "single_subscript_attribute_target", 
			"t_primary", "del_targets", "del_target", "del_t_atom", "type_expressions", 
			"func_type_comment", "name_except_underscore", "name"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "'('", "'['", null, "')'", 
			"']'", null, "'.'", "':'", "','", "';'", "'+'", "'-'", "'*'", "'/'", 
			"'|'", "'&'", "'<'", "'>'", "'='", "'%'", "'=='", "'!='", "'<='", "'>='", 
			"'~'", "'^'", "'<<'", "'>>'", "'**'", "'+='", "'-='", "'*='", "'/='", 
			"'%='", "'&='", "'|='", "'^='", "'<<='", "'>>='", "'**='", "'//'", "'//='", 
			"'@'", "'@='", "'->'", "'...'", "':='", "'!'", "'False'", "'await'", 
			"'else'", "'import'", "'pass'", "'None'", "'break'", "'except'", "'in'", 
			"'raise'", "'True'", "'class'", "'finally'", "'is'", "'return'", "'and'", 
			"'continue'", "'for'", "'lambda'", "'try'", "'as'", "'def'", "'from'", 
			"'nonlocal'", "'while'", "'assert'", "'del'", "'global'", "'not'", "'with'", 
			"'async'", "'elif'", "'if'", "'or'", "'yield'", "'type'", "'match'", 
			"'case'", "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ENCODING", "INDENT", "DEDENT", "TYPE_COMMENT", "FSTRING_START", 
			"FSTRING_MIDDLE", "FSTRING_END", "LPAR", "LSQB", "LBRACE", "RPAR", "RSQB", 
			"RBRACE", "DOT", "COLON", "COMMA", "SEMI", "PLUS", "MINUS", "STAR", "SLASH", 
			"VBAR", "AMPER", "LESS", "GREATER", "EQUAL", "PERCENT", "EQEQUAL", "NOTEQUAL", 
			"LESSEQUAL", "GREATEREQUAL", "TILDE", "CIRCUMFLEX", "LEFTSHIFT", "RIGHTSHIFT", 
			"DOUBLESTAR", "PLUSEQUAL", "MINEQUAL", "STAREQUAL", "SLASHEQUAL", "PERCENTEQUAL", 
			"AMPEREQUAL", "VBAREQUAL", "CIRCUMFLEXEQUAL", "LEFTSHIFTEQUAL", "RIGHTSHIFTEQUAL", 
			"DOUBLESTAREQUAL", "DOUBLESLASH", "DOUBLESLASHEQUAL", "AT", "ATEQUAL", 
			"RARROW", "ELLIPSIS", "COLONEQUAL", "EXCLAMATION", "FALSE", "AWAIT", 
			"ELSE", "IMPORT", "PASS", "NONE", "BREAK", "EXCEPT", "IN", "RAISE", "TRUE", 
			"CLASS", "FINALLY", "IS", "RETURN", "AND", "CONTINUE", "FOR", "LAMBDA", 
			"TRY", "AS", "DEF", "FROM", "NONLOCAL", "WHILE", "ASSERT", "DEL", "GLOBAL", 
			"NOT", "WITH", "ASYNC", "ELIF", "IF", "OR", "YIELD", "NAME_OR_TYPE", 
			"NAME_OR_MATCH", "NAME_OR_CASE", "NAME_OR_WILDCARD", "NAME", "NUMBER", 
			"STRING", "NEWLINE", "COMMENT", "WS", "EXPLICIT_LINE_JOINING", "ERRORTOKEN"
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
	public String getGrammarFileName() { return "PythonParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public PythonParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class File_inputContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public File_inputContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_file_input; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFile_input(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFile_input(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFile_input(this);
			else return visitor.visitChildren(this);
		}
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8873217170123523872L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 8568960935L) != 0)) {
				{
				setState(398);
				statements();
				}
			}

			setState(401);
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
	public static class InteractiveContext extends ParserRuleContext {
		public Statement_newlineContext statement_newline() {
			return getRuleContext(Statement_newlineContext.class,0);
		}
		public InteractiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interactive; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterInteractive(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitInteractive(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitInteractive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InteractiveContext interactive() throws RecognitionException {
		InteractiveContext _localctx = new InteractiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_interactive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			statement_newline();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EvalContext extends ParserRuleContext {
		public ExpressionsContext expressions() {
			return getRuleContext(ExpressionsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public List<TerminalNode> NEWLINE() { return getTokens(PythonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PythonParser.NEWLINE, i);
		}
		public EvalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eval; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterEval(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitEval(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitEval(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			expressions();
			setState(409);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(406);
				match(NEWLINE);
				}
				}
				setState(411);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(412);
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
	public static class Func_typeContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode RARROW() { return getToken(PythonParser.RARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public Type_expressionsContext type_expressions() {
			return getRuleContext(Type_expressionsContext.class,0);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PythonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PythonParser.NEWLINE, i);
		}
		public Func_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunc_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunc_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFunc_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(414);
			match(LPAR);
			setState(416);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(415);
				type_expressions();
				}
			}

			setState(418);
			match(RPAR);
			setState(419);
			match(RARROW);
			setState(420);
			expression();
			setState(424);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(421);
				match(NEWLINE);
				}
				}
				setState(426);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(427);
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
	public static class StatementsContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(429);
				statement();
				}
				}
				setState(432); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 8873217170123523872L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 8568960935L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public Simple_stmtsContext simple_stmts() {
			return getRuleContext(Simple_stmtsContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(436);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(434);
				compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				simple_stmts();
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
	public static class Statement_newlineContext extends ParserRuleContext {
		public Compound_stmtContext compound_stmt() {
			return getRuleContext(Compound_stmtContext.class,0);
		}
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public Simple_stmtsContext simple_stmts() {
			return getRuleContext(Simple_stmtsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(PythonParser.EOF, 0); }
		public Statement_newlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_newline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStatement_newline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStatement_newline(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStatement_newline(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Statement_newlineContext statement_newline() throws RecognitionException {
		Statement_newlineContext _localctx = new Statement_newlineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement_newline);
		try {
			setState(444);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(438);
				compound_stmt();
				setState(439);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(441);
				simple_stmts();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(442);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(443);
				match(EOF);
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
	public static class Simple_stmtsContext extends ParserRuleContext {
		public List<Simple_stmtContext> simple_stmt() {
			return getRuleContexts(Simple_stmtContext.class);
		}
		public Simple_stmtContext simple_stmt(int i) {
			return getRuleContext(Simple_stmtContext.class,i);
		}
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public List<TerminalNode> SEMI() { return getTokens(PythonParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(PythonParser.SEMI, i);
		}
		public Simple_stmtsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmts; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSimple_stmts(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSimple_stmts(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSimple_stmts(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_stmtsContext simple_stmts() throws RecognitionException {
		Simple_stmtsContext _localctx = new Simple_stmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simple_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(446);
			simple_stmt();
			setState(451);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(447);
					match(SEMI);
					setState(448);
					simple_stmt();
					}
					} 
				}
				setState(453);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(455);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(454);
				match(SEMI);
				}
			}

			setState(457);
			match(NEWLINE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Simple_stmtContext extends ParserRuleContext {
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public Type_aliasContext type_alias() {
			return getRuleContext(Type_aliasContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Return_stmtContext return_stmt() {
			return getRuleContext(Return_stmtContext.class,0);
		}
		public Import_stmtContext import_stmt() {
			return getRuleContext(Import_stmtContext.class,0);
		}
		public Raise_stmtContext raise_stmt() {
			return getRuleContext(Raise_stmtContext.class,0);
		}
		public TerminalNode PASS() { return getToken(PythonParser.PASS, 0); }
		public Del_stmtContext del_stmt() {
			return getRuleContext(Del_stmtContext.class,0);
		}
		public Yield_stmtContext yield_stmt() {
			return getRuleContext(Yield_stmtContext.class,0);
		}
		public Assert_stmtContext assert_stmt() {
			return getRuleContext(Assert_stmtContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(PythonParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(PythonParser.CONTINUE, 0); }
		public Global_stmtContext global_stmt() {
			return getRuleContext(Global_stmtContext.class,0);
		}
		public Nonlocal_stmtContext nonlocal_stmt() {
			return getRuleContext(Nonlocal_stmtContext.class,0);
		}
		public Simple_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSimple_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSimple_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSimple_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simple_stmt);
		try {
			setState(473);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(459);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(460);
				type_alias();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(461);
				star_expressions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(462);
				return_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(463);
				import_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(464);
				raise_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(465);
				match(PASS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(466);
				del_stmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(467);
				yield_stmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(468);
				assert_stmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(469);
				match(BREAK);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(470);
				match(CONTINUE);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(471);
				global_stmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(472);
				nonlocal_stmt();
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
	public static class Compound_stmtContext extends ParserRuleContext {
		public Function_defContext function_def() {
			return getRuleContext(Function_defContext.class,0);
		}
		public If_stmtContext if_stmt() {
			return getRuleContext(If_stmtContext.class,0);
		}
		public Class_defContext class_def() {
			return getRuleContext(Class_defContext.class,0);
		}
		public With_stmtContext with_stmt() {
			return getRuleContext(With_stmtContext.class,0);
		}
		public For_stmtContext for_stmt() {
			return getRuleContext(For_stmtContext.class,0);
		}
		public Try_stmtContext try_stmt() {
			return getRuleContext(Try_stmtContext.class,0);
		}
		public While_stmtContext while_stmt() {
			return getRuleContext(While_stmtContext.class,0);
		}
		public Match_stmtContext match_stmt() {
			return getRuleContext(Match_stmtContext.class,0);
		}
		public Compound_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCompound_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCompound_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitCompound_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compound_stmt);
		try {
			setState(483);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(475);
				function_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(476);
				if_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(477);
				class_def();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(478);
				with_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(479);
				for_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(480);
				try_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(481);
				while_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(482);
				match_stmt();
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
	public static class AssignmentContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> EQUAL() { return getTokens(PythonParser.EQUAL); }
		public TerminalNode EQUAL(int i) {
			return getToken(PythonParser.EQUAL, i);
		}
		public Annotated_rhsContext annotated_rhs() {
			return getRuleContext(Annotated_rhsContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Single_targetContext single_target() {
			return getRuleContext(Single_targetContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Single_subscript_attribute_targetContext single_subscript_attribute_target() {
			return getRuleContext(Single_subscript_attribute_targetContext.class,0);
		}
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public List<Star_targetsContext> star_targets() {
			return getRuleContexts(Star_targetsContext.class);
		}
		public Star_targetsContext star_targets(int i) {
			return getRuleContext(Star_targetsContext.class,i);
		}
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public AugassignContext augassign() {
			return getRuleContext(AugassignContext.class,0);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		int _la;
		try {
			int _alt;
			setState(525);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(485);
				name();
				setState(486);
				match(COLON);
				setState(487);
				expression();
				setState(490);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(488);
					match(EQUAL);
					setState(489);
					annotated_rhs();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(497);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(492);
					match(LPAR);
					setState(493);
					single_target();
					setState(494);
					match(RPAR);
					}
					break;
				case 2:
					{
					setState(496);
					single_subscript_attribute_target();
					}
					break;
				}
				setState(499);
				match(COLON);
				setState(500);
				expression();
				setState(503);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(501);
					match(EQUAL);
					setState(502);
					annotated_rhs();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(508); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(505);
						star_targets();
						setState(506);
						match(EQUAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(510); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(514);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(512);
					yield_expr();
					}
					break;
				case FSTRING_START:
				case LPAR:
				case LSQB:
				case LBRACE:
				case PLUS:
				case MINUS:
				case STAR:
				case TILDE:
				case ELLIPSIS:
				case FALSE:
				case AWAIT:
				case NONE:
				case TRUE:
				case LAMBDA:
				case NOT:
				case NAME_OR_TYPE:
				case NAME_OR_MATCH:
				case NAME_OR_CASE:
				case NAME_OR_WILDCARD:
				case NAME:
				case NUMBER:
				case STRING:
					{
					setState(513);
					star_expressions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(517);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(516);
					match(TYPE_COMMENT);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(519);
				single_target();
				setState(520);
				augassign();
				setState(523);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(521);
					yield_expr();
					}
					break;
				case FSTRING_START:
				case LPAR:
				case LSQB:
				case LBRACE:
				case PLUS:
				case MINUS:
				case STAR:
				case TILDE:
				case ELLIPSIS:
				case FALSE:
				case AWAIT:
				case NONE:
				case TRUE:
				case LAMBDA:
				case NOT:
				case NAME_OR_TYPE:
				case NAME_OR_MATCH:
				case NAME_OR_CASE:
				case NAME_OR_WILDCARD:
				case NAME:
				case NUMBER:
				case STRING:
					{
					setState(522);
					star_expressions();
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
	public static class Annotated_rhsContext extends ParserRuleContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Annotated_rhsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotated_rhs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAnnotated_rhs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAnnotated_rhs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAnnotated_rhs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Annotated_rhsContext annotated_rhs() throws RecognitionException {
		Annotated_rhsContext _localctx = new Annotated_rhsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_annotated_rhs);
		try {
			setState(529);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YIELD:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				yield_expr();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(528);
				star_expressions();
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
	public static class AugassignContext extends ParserRuleContext {
		public TerminalNode PLUSEQUAL() { return getToken(PythonParser.PLUSEQUAL, 0); }
		public TerminalNode MINEQUAL() { return getToken(PythonParser.MINEQUAL, 0); }
		public TerminalNode STAREQUAL() { return getToken(PythonParser.STAREQUAL, 0); }
		public TerminalNode ATEQUAL() { return getToken(PythonParser.ATEQUAL, 0); }
		public TerminalNode SLASHEQUAL() { return getToken(PythonParser.SLASHEQUAL, 0); }
		public TerminalNode PERCENTEQUAL() { return getToken(PythonParser.PERCENTEQUAL, 0); }
		public TerminalNode AMPEREQUAL() { return getToken(PythonParser.AMPEREQUAL, 0); }
		public TerminalNode VBAREQUAL() { return getToken(PythonParser.VBAREQUAL, 0); }
		public TerminalNode CIRCUMFLEXEQUAL() { return getToken(PythonParser.CIRCUMFLEXEQUAL, 0); }
		public TerminalNode LEFTSHIFTEQUAL() { return getToken(PythonParser.LEFTSHIFTEQUAL, 0); }
		public TerminalNode RIGHTSHIFTEQUAL() { return getToken(PythonParser.RIGHTSHIFTEQUAL, 0); }
		public TerminalNode DOUBLESTAREQUAL() { return getToken(PythonParser.DOUBLESTAREQUAL, 0); }
		public TerminalNode DOUBLESLASHEQUAL() { return getToken(PythonParser.DOUBLESLASHEQUAL, 0); }
		public AugassignContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_augassign; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAugassign(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAugassign(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAugassign(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AugassignContext augassign() throws RecognitionException {
		AugassignContext _localctx = new AugassignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_augassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3096087304863744L) != 0)) ) {
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
	public static class Return_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(PythonParser.RETURN, 0); }
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Return_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterReturn_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitReturn_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitReturn_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(533);
			match(RETURN);
			setState(535);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(534);
				star_expressions();
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
	public static class Raise_stmtContext extends ParserRuleContext {
		public TerminalNode RAISE() { return getToken(PythonParser.RAISE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public Raise_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_raise_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterRaise_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitRaise_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitRaise_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Raise_stmtContext raise_stmt() throws RecognitionException {
		Raise_stmtContext _localctx = new Raise_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_raise_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(537);
			match(RAISE);
			setState(543);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(538);
				expression();
				setState(541);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(539);
					match(FROM);
					setState(540);
					expression();
					}
				}

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
	public static class Global_stmtContext extends ParserRuleContext {
		public TerminalNode GLOBAL() { return getToken(PythonParser.GLOBAL, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Global_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_global_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGlobal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGlobal_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitGlobal_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Global_stmtContext global_stmt() throws RecognitionException {
		Global_stmtContext _localctx = new Global_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_global_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(545);
			match(GLOBAL);
			setState(546);
			name();
			setState(551);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(547);
				match(COMMA);
				setState(548);
				name();
				}
				}
				setState(553);
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
	public static class Nonlocal_stmtContext extends ParserRuleContext {
		public TerminalNode NONLOCAL() { return getToken(PythonParser.NONLOCAL, 0); }
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Nonlocal_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonlocal_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNonlocal_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNonlocal_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitNonlocal_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Nonlocal_stmtContext nonlocal_stmt() throws RecognitionException {
		Nonlocal_stmtContext _localctx = new Nonlocal_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nonlocal_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			match(NONLOCAL);
			setState(555);
			name();
			setState(560);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(556);
				match(COMMA);
				setState(557);
				name();
				}
				}
				setState(562);
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
	public static class Del_stmtContext extends ParserRuleContext {
		public TerminalNode DEL() { return getToken(PythonParser.DEL, 0); }
		public Del_targetsContext del_targets() {
			return getRuleContext(Del_targetsContext.class,0);
		}
		public Del_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDel_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Del_stmtContext del_stmt() throws RecognitionException {
		Del_stmtContext _localctx = new Del_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_del_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(563);
			match(DEL);
			setState(564);
			del_targets();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Yield_stmtContext extends ParserRuleContext {
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Yield_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterYield_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitYield_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitYield_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_stmtContext yield_stmt() throws RecognitionException {
		Yield_stmtContext _localctx = new Yield_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_yield_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(566);
			yield_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Assert_stmtContext extends ParserRuleContext {
		public TerminalNode ASSERT() { return getToken(PythonParser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Assert_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assert_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssert_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssert_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAssert_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assert_stmtContext assert_stmt() throws RecognitionException {
		Assert_stmtContext _localctx = new Assert_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			match(ASSERT);
			setState(569);
			expression();
			setState(572);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(570);
				match(COMMA);
				setState(571);
				expression();
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
	public static class Import_stmtContext extends ParserRuleContext {
		public Import_nameContext import_name() {
			return getRuleContext(Import_nameContext.class,0);
		}
		public Import_fromContext import_from() {
			return getRuleContext(Import_fromContext.class,0);
		}
		public Import_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImport_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_stmtContext import_stmt() throws RecognitionException {
		Import_stmtContext _localctx = new Import_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_import_stmt);
		try {
			setState(576);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(574);
				import_name();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(575);
				import_from();
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
	public static class Import_nameContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(PythonParser.IMPORT, 0); }
		public Dotted_as_namesContext dotted_as_names() {
			return getRuleContext(Dotted_as_namesContext.class,0);
		}
		public Import_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImport_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_nameContext import_name() throws RecognitionException {
		Import_nameContext _localctx = new Import_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_import_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			match(IMPORT);
			setState(579);
			dotted_as_names();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Import_fromContext extends ParserRuleContext {
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode IMPORT() { return getToken(PythonParser.IMPORT, 0); }
		public Import_from_targetsContext import_from_targets() {
			return getRuleContext(Import_from_targetsContext.class,0);
		}
		public List<TerminalNode> DOT() { return getTokens(PythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PythonParser.DOT, i);
		}
		public List<TerminalNode> ELLIPSIS() { return getTokens(PythonParser.ELLIPSIS); }
		public TerminalNode ELLIPSIS(int i) {
			return getToken(PythonParser.ELLIPSIS, i);
		}
		public Import_fromContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImport_from(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_fromContext import_from() throws RecognitionException {
		Import_fromContext _localctx = new Import_fromContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_import_from);
		int _la;
		try {
			setState(600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(581);
				match(FROM);
				setState(585);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT || _la==ELLIPSIS) {
					{
					{
					setState(582);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(587);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(588);
				dotted_name(0);
				setState(589);
				match(IMPORT);
				setState(590);
				import_from_targets();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(592);
				match(FROM);
				setState(594); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(593);
					_la = _input.LA(1);
					if ( !(_la==DOT || _la==ELLIPSIS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					}
					}
					setState(596); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT || _la==ELLIPSIS );
				setState(598);
				match(IMPORT);
				setState(599);
				import_from_targets();
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
	public static class Import_from_targetsContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Import_from_as_namesContext import_from_as_names() {
			return getRuleContext(Import_from_as_namesContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Import_from_targetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from_targets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from_targets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from_targets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImport_from_targets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_from_targetsContext import_from_targets() throws RecognitionException {
		Import_from_targetsContext _localctx = new Import_from_targetsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_import_from_targets);
		int _la;
		try {
			setState(611);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(602);
				match(LPAR);
				setState(603);
				import_from_as_names();
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(604);
					match(COMMA);
					}
				}

				setState(607);
				match(RPAR);
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(609);
				import_from_as_names();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(610);
				match(STAR);
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
	public static class Import_from_as_namesContext extends ParserRuleContext {
		public List<Import_from_as_nameContext> import_from_as_name() {
			return getRuleContexts(Import_from_as_nameContext.class);
		}
		public Import_from_as_nameContext import_from_as_name(int i) {
			return getRuleContext(Import_from_as_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Import_from_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from_as_names(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImport_from_as_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_from_as_namesContext import_from_as_names() throws RecognitionException {
		Import_from_as_namesContext _localctx = new Import_from_as_namesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_import_from_as_names);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(613);
			import_from_as_name();
			setState(618);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(614);
					match(COMMA);
					setState(615);
					import_from_as_name();
					}
					} 
				}
				setState(620);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
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
	public static class Import_from_as_nameContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Import_from_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_import_from_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImport_from_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImport_from_as_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImport_from_as_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Import_from_as_nameContext import_from_as_name() throws RecognitionException {
		Import_from_as_nameContext _localctx = new Import_from_as_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_import_from_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			name();
			setState(624);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(622);
				match(AS);
				setState(623);
				name();
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
	public static class Dotted_as_namesContext extends ParserRuleContext {
		public List<Dotted_as_nameContext> dotted_as_name() {
			return getRuleContexts(Dotted_as_nameContext.class);
		}
		public Dotted_as_nameContext dotted_as_name(int i) {
			return getRuleContext(Dotted_as_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Dotted_as_namesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_names; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_as_names(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_as_names(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDotted_as_names(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_as_namesContext dotted_as_names() throws RecognitionException {
		Dotted_as_namesContext _localctx = new Dotted_as_namesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dotted_as_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(626);
			dotted_as_name();
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(627);
				match(COMMA);
				setState(628);
				dotted_as_name();
				}
				}
				setState(633);
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
	public static class Dotted_as_nameContext extends ParserRuleContext {
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dotted_as_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_as_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_as_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_as_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDotted_as_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_as_nameContext dotted_as_name() throws RecognitionException {
		Dotted_as_nameContext _localctx = new Dotted_as_nameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_dotted_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(634);
			dotted_name(0);
			setState(637);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(635);
				match(AS);
				setState(636);
				name();
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
	public static class Dotted_nameContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Dotted_nameContext dotted_name() {
			return getRuleContext(Dotted_nameContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public Dotted_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dotted_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDotted_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDotted_name(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDotted_name(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dotted_nameContext dotted_name() throws RecognitionException {
		return dotted_name(0);
	}

	private Dotted_nameContext dotted_name(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Dotted_nameContext _localctx = new Dotted_nameContext(_ctx, _parentState);
		Dotted_nameContext _prevctx = _localctx;
		int _startState = 56;
		enterRecursionRule(_localctx, 56, RULE_dotted_name, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(640);
			name();
			}
			_ctx.stop = _input.LT(-1);
			setState(647);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Dotted_nameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_dotted_name);
					setState(642);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(643);
					match(DOT);
					setState(644);
					name();
					}
					} 
				}
				setState(649);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
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
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(PythonParser.INDENT, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode DEDENT() { return getToken(PythonParser.DEDENT, 0); }
		public Simple_stmtsContext simple_stmts() {
			return getRuleContext(Simple_stmtsContext.class,0);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_block);
		try {
			setState(656);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(650);
				match(NEWLINE);
				setState(651);
				match(INDENT);
				setState(652);
				statements();
				setState(653);
				match(DEDENT);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case IMPORT:
			case PASS:
			case NONE:
			case BREAK:
			case RAISE:
			case TRUE:
			case RETURN:
			case CONTINUE:
			case LAMBDA:
			case FROM:
			case NONLOCAL:
			case ASSERT:
			case DEL:
			case GLOBAL:
			case NOT:
			case YIELD:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(655);
				simple_stmts();
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
	public static class DecoratorsContext extends ParserRuleContext {
		public List<TerminalNode> AT() { return getTokens(PythonParser.AT); }
		public TerminalNode AT(int i) {
			return getToken(PythonParser.AT, i);
		}
		public List<Named_expressionContext> named_expression() {
			return getRuleContexts(Named_expressionContext.class);
		}
		public Named_expressionContext named_expression(int i) {
			return getRuleContext(Named_expressionContext.class,i);
		}
		public List<TerminalNode> NEWLINE() { return getTokens(PythonParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(PythonParser.NEWLINE, i);
		}
		public DecoratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decorators; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDecorators(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDecorators(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDecorators(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DecoratorsContext decorators() throws RecognitionException {
		DecoratorsContext _localctx = new DecoratorsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_decorators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(662); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(658);
				match(AT);
				setState(659);
				named_expression();
				setState(660);
				match(NEWLINE);
				}
				}
				setState(664); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==AT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_defContext extends ParserRuleContext {
		public DecoratorsContext decorators() {
			return getRuleContext(DecoratorsContext.class,0);
		}
		public Class_def_rawContext class_def_raw() {
			return getRuleContext(Class_def_rawContext.class,0);
		}
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClass_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitClass_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_class_def);
		try {
			setState(670);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(666);
				decorators();
				setState(667);
				class_def_raw();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(669);
				class_def_raw();
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
	public static class Class_def_rawContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(PythonParser.CLASS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Type_paramsContext type_params() {
			return getRuleContext(Type_paramsContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public Class_def_rawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def_raw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClass_def_raw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClass_def_raw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitClass_def_raw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_def_rawContext class_def_raw() throws RecognitionException {
		Class_def_rawContext _localctx = new Class_def_rawContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_class_def_raw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(672);
			match(CLASS);
			setState(673);
			name();
			setState(675);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQB) {
				{
				setState(674);
				type_params();
				}
			}

			setState(682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(677);
				match(LPAR);
				setState(679);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(678);
					arguments();
					}
				}

				setState(681);
				match(RPAR);
				}
			}

			setState(684);
			match(COLON);
			setState(685);
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
	public static class Function_defContext extends ParserRuleContext {
		public DecoratorsContext decorators() {
			return getRuleContext(DecoratorsContext.class,0);
		}
		public Function_def_rawContext function_def_raw() {
			return getRuleContext(Function_def_rawContext.class,0);
		}
		public Function_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunction_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunction_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFunction_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_function_def);
		try {
			setState(691);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				decorators();
				setState(688);
				function_def_raw();
				}
				break;
			case DEF:
			case ASYNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(690);
				function_def_raw();
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
	public static class Function_def_rawContext extends ParserRuleContext {
		public TerminalNode DEF() { return getToken(PythonParser.DEF, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Type_paramsContext type_params() {
			return getRuleContext(Type_paramsContext.class,0);
		}
		public ParamsContext params() {
			return getRuleContext(ParamsContext.class,0);
		}
		public TerminalNode RARROW() { return getToken(PythonParser.RARROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Func_type_commentContext func_type_comment() {
			return getRuleContext(Func_type_commentContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public Function_def_rawContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_def_raw; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunction_def_raw(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunction_def_raw(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFunction_def_raw(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Function_def_rawContext function_def_raw() throws RecognitionException {
		Function_def_rawContext _localctx = new Function_def_rawContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_function_def_raw);
		int _la;
		try {
			setState(734);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(693);
				match(DEF);
				setState(694);
				name();
				setState(696);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQB) {
					{
					setState(695);
					type_params();
					}
				}

				setState(698);
				match(LPAR);
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					setState(699);
					params();
					}
				}

				setState(702);
				match(RPAR);
				setState(705);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RARROW) {
					{
					setState(703);
					match(RARROW);
					setState(704);
					expression();
					}
				}

				setState(707);
				match(COLON);
				setState(709);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(708);
					func_type_comment();
					}
					break;
				}
				setState(711);
				block();
				}
				break;
			case ASYNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(713);
				match(ASYNC);
				setState(714);
				match(DEF);
				setState(715);
				name();
				setState(717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQB) {
					{
					setState(716);
					type_params();
					}
				}

				setState(719);
				match(LPAR);
				setState(721);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					setState(720);
					params();
					}
				}

				setState(723);
				match(RPAR);
				setState(726);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RARROW) {
					{
					setState(724);
					match(RARROW);
					setState(725);
					expression();
					}
				}

				setState(728);
				match(COLON);
				setState(730);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(729);
					func_type_comment();
					}
					break;
				}
				setState(732);
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
	public static class ParamsContext extends ParserRuleContext {
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public ParamsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParams(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParams(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParams(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(736);
			parameters();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersContext extends ParserRuleContext {
		public Slash_no_defaultContext slash_no_default() {
			return getRuleContext(Slash_no_defaultContext.class,0);
		}
		public List<Param_no_defaultContext> param_no_default() {
			return getRuleContexts(Param_no_defaultContext.class);
		}
		public Param_no_defaultContext param_no_default(int i) {
			return getRuleContext(Param_no_defaultContext.class,i);
		}
		public List<Param_with_defaultContext> param_with_default() {
			return getRuleContexts(Param_with_defaultContext.class);
		}
		public Param_with_defaultContext param_with_default(int i) {
			return getRuleContext(Param_with_defaultContext.class,i);
		}
		public Star_etcContext star_etc() {
			return getRuleContext(Star_etcContext.class,0);
		}
		public Slash_with_defaultContext slash_with_default() {
			return getRuleContext(Slash_with_defaultContext.class,0);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_parameters);
		int _la;
		try {
			int _alt;
			setState(787);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(738);
				slash_no_default();
				setState(742);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(739);
						param_no_default();
						}
						} 
					}
					setState(744);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				}
				setState(748);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(745);
					param_with_default();
					}
					}
					setState(750);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(751);
					star_etc();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(754);
				slash_with_default();
				setState(758);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(755);
					param_with_default();
					}
					}
					setState(760);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(762);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(761);
					star_etc();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(765); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(764);
						param_no_default();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(767); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(772);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(769);
					param_with_default();
					}
					}
					setState(774);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(775);
					star_etc();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(779); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(778);
					param_with_default();
					}
					}
					setState(781); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(784);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(783);
					star_etc();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(786);
				star_etc();
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
	public static class Slash_no_defaultContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Param_no_defaultContext> param_no_default() {
			return getRuleContexts(Param_no_defaultContext.class);
		}
		public Param_no_defaultContext param_no_default(int i) {
			return getRuleContext(Param_no_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Slash_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slash_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlash_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlash_no_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSlash_no_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Slash_no_defaultContext slash_no_default() throws RecognitionException {
		Slash_no_defaultContext _localctx = new Slash_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_slash_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(790); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(789);
				param_no_default();
				}
				}
				setState(792); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(794);
			match(SLASH);
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(795);
				match(COMMA);
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
	public static class Slash_with_defaultContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Param_no_defaultContext> param_no_default() {
			return getRuleContexts(Param_no_defaultContext.class);
		}
		public Param_no_defaultContext param_no_default(int i) {
			return getRuleContext(Param_no_defaultContext.class,i);
		}
		public List<Param_with_defaultContext> param_with_default() {
			return getRuleContexts(Param_with_defaultContext.class);
		}
		public Param_with_defaultContext param_with_default(int i) {
			return getRuleContext(Param_with_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Slash_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slash_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlash_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlash_with_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSlash_with_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Slash_with_defaultContext slash_with_default() throws RecognitionException {
		Slash_with_defaultContext _localctx = new Slash_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_slash_with_default);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(801);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(798);
					param_no_default();
					}
					} 
				}
				setState(803);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			setState(805); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(804);
				param_with_default();
				}
				}
				setState(807); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(809);
			match(SLASH);
			setState(811);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(810);
				match(COMMA);
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
	public static class Star_etcContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Param_no_defaultContext param_no_default() {
			return getRuleContext(Param_no_defaultContext.class,0);
		}
		public List<Param_maybe_defaultContext> param_maybe_default() {
			return getRuleContexts(Param_maybe_defaultContext.class);
		}
		public Param_maybe_defaultContext param_maybe_default(int i) {
			return getRuleContext(Param_maybe_defaultContext.class,i);
		}
		public KwdsContext kwds() {
			return getRuleContext(KwdsContext.class,0);
		}
		public Param_no_default_star_annotationContext param_no_default_star_annotation() {
			return getRuleContext(Param_no_default_star_annotationContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Star_etcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_etc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_etc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_etc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_etc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_etcContext star_etc() throws RecognitionException {
		Star_etcContext _localctx = new Star_etcContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_star_etc);
		int _la;
		try {
			setState(846);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(813);
				match(STAR);
				setState(814);
				param_no_default();
				setState(818);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(815);
					param_maybe_default();
					}
					}
					setState(820);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(822);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(821);
					kwds();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(824);
				match(STAR);
				setState(825);
				param_no_default_star_annotation();
				setState(829);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(826);
					param_maybe_default();
					}
					}
					setState(831);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(833);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(832);
					kwds();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(835);
				match(STAR);
				setState(836);
				match(COMMA);
				setState(838); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(837);
					param_maybe_default();
					}
					}
					setState(840); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(843);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(842);
					kwds();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(845);
				kwds();
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
	public static class KwdsContext extends ParserRuleContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Param_no_defaultContext param_no_default() {
			return getRuleContext(Param_no_defaultContext.class,0);
		}
		public KwdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKwds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KwdsContext kwds() throws RecognitionException {
		KwdsContext _localctx = new KwdsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_kwds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(848);
			match(DOUBLESTAR);
			setState(849);
			param_no_default();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Param_no_defaultContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_no_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParam_no_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_no_defaultContext param_no_default() throws RecognitionException {
		Param_no_defaultContext _localctx = new Param_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_param_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(851);
			param();
			setState(853);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(852);
				match(COMMA);
				}
			}

			setState(856);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(855);
				match(TYPE_COMMENT);
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
	public static class Param_no_default_star_annotationContext extends ParserRuleContext {
		public Param_star_annotationContext param_star_annotation() {
			return getRuleContext(Param_star_annotationContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_no_default_star_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_no_default_star_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_no_default_star_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_no_default_star_annotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParam_no_default_star_annotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_no_default_star_annotationContext param_no_default_star_annotation() throws RecognitionException {
		Param_no_default_star_annotationContext _localctx = new Param_no_default_star_annotationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_param_no_default_star_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(858);
			param_star_annotation();
			setState(860);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(859);
				match(COMMA);
				}
			}

			setState(863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(862);
				match(TYPE_COMMENT);
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
	public static class Param_with_defaultContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_with_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParam_with_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_with_defaultContext param_with_default() throws RecognitionException {
		Param_with_defaultContext _localctx = new Param_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_param_with_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(865);
			param();
			setState(866);
			default_assignment();
			setState(868);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(867);
				match(COMMA);
				}
			}

			setState(871);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(870);
				match(TYPE_COMMENT);
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
	public static class Param_maybe_defaultContext extends ParserRuleContext {
		public ParamContext param() {
			return getRuleContext(ParamContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Param_maybe_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_maybe_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_maybe_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_maybe_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParam_maybe_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_maybe_defaultContext param_maybe_default() throws RecognitionException {
		Param_maybe_defaultContext _localctx = new Param_maybe_defaultContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_param_maybe_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(873);
			param();
			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(874);
				default_assignment();
				}
			}

			setState(878);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(877);
				match(COMMA);
				}
			}

			setState(881);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(880);
				match(TYPE_COMMENT);
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
	public static class ParamContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ParamContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParam(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(883);
			name();
			setState(885);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(884);
				annotation();
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
	public static class Param_star_annotationContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Star_annotationContext star_annotation() {
			return getRuleContext(Star_annotationContext.class,0);
		}
		public Param_star_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_param_star_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterParam_star_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitParam_star_annotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitParam_star_annotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Param_star_annotationContext param_star_annotation() throws RecognitionException {
		Param_star_annotationContext _localctx = new Param_star_annotationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_param_star_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			name();
			setState(888);
			star_annotation();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAnnotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			match(COLON);
			setState(891);
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
	public static class Star_annotationContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public Star_expressionContext star_expression() {
			return getRuleContext(Star_expressionContext.class,0);
		}
		public Star_annotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_annotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_annotation(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_annotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_annotationContext star_annotation() throws RecognitionException {
		Star_annotationContext _localctx = new Star_annotationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_star_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(893);
			match(COLON);
			setState(894);
			star_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Default_assignmentContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Default_assignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_default_assignment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDefault_assignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDefault_assignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDefault_assignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Default_assignmentContext default_assignment() throws RecognitionException {
		Default_assignmentContext _localctx = new Default_assignmentContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_default_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(896);
			match(EQUAL);
			setState(897);
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
	public static class If_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elif_stmtContext elif_stmt() {
			return getRuleContext(Elif_stmtContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public If_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIf_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIf_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitIf_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(899);
			match(IF);
			setState(900);
			named_expression();
			setState(901);
			match(COLON);
			setState(902);
			block();
			setState(907);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELIF:
				{
				setState(903);
				elif_stmt();
				}
				break;
			case EOF:
			case DEDENT:
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case AT:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case ELSE:
			case IMPORT:
			case PASS:
			case NONE:
			case BREAK:
			case RAISE:
			case TRUE:
			case CLASS:
			case RETURN:
			case CONTINUE:
			case FOR:
			case LAMBDA:
			case TRY:
			case DEF:
			case FROM:
			case NONLOCAL:
			case WHILE:
			case ASSERT:
			case DEL:
			case GLOBAL:
			case NOT:
			case WITH:
			case ASYNC:
			case IF:
			case YIELD:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
			case NEWLINE:
				{
				setState(905);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(904);
					else_block();
					}
				}

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
	public static class Elif_stmtContext extends ParserRuleContext {
		public TerminalNode ELIF() { return getToken(PythonParser.ELIF, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Elif_stmtContext elif_stmt() {
			return getRuleContext(Elif_stmtContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public Elif_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elif_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterElif_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitElif_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitElif_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Elif_stmtContext elif_stmt() throws RecognitionException {
		Elif_stmtContext _localctx = new Elif_stmtContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_elif_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(909);
			match(ELIF);
			setState(910);
			named_expression();
			setState(911);
			match(COLON);
			setState(912);
			block();
			setState(917);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELIF:
				{
				setState(913);
				elif_stmt();
				}
				break;
			case EOF:
			case DEDENT:
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case STAR:
			case TILDE:
			case AT:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case ELSE:
			case IMPORT:
			case PASS:
			case NONE:
			case BREAK:
			case RAISE:
			case TRUE:
			case CLASS:
			case RETURN:
			case CONTINUE:
			case FOR:
			case LAMBDA:
			case TRY:
			case DEF:
			case FROM:
			case NONLOCAL:
			case WHILE:
			case ASSERT:
			case DEL:
			case GLOBAL:
			case NOT:
			case WITH:
			case ASYNC:
			case IF:
			case YIELD:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
			case NEWLINE:
				{
				setState(915);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(914);
					else_block();
					}
				}

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
	public static class Else_blockContext extends ParserRuleContext {
		public TerminalNode ELSE() { return getToken(PythonParser.ELSE, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_else_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterElse_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitElse_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitElse_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Else_blockContext else_block() throws RecognitionException {
		Else_blockContext _localctx = new Else_blockContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_else_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(919);
			match(ELSE);
			setState(920);
			match(COLON);
			setState(921);
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
	public static class While_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(PythonParser.WHILE, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public While_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWhile_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWhile_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitWhile_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(923);
			match(WHILE);
			setState(924);
			named_expression();
			setState(925);
			match(COLON);
			setState(926);
			block();
			setState(928);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(927);
				else_block();
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
	public static class For_stmtContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PythonParser.FOR, 0); }
		public Star_targetsContext star_targets() {
			return getRuleContext(Star_targetsContext.class,0);
		}
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public For_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFor_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFor_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFor_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(931);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(930);
				match(ASYNC);
				}
			}

			setState(933);
			match(FOR);
			setState(934);
			star_targets();
			setState(935);
			match(IN);
			setState(936);
			star_expressions();
			setState(937);
			match(COLON);
			setState(939);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(938);
				match(TYPE_COMMENT);
				}
			}

			setState(941);
			block();
			setState(943);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(942);
				else_block();
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
	public static class With_stmtContext extends ParserRuleContext {
		public TerminalNode WITH() { return getToken(PythonParser.WITH, 0); }
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public List<With_itemContext> with_item() {
			return getRuleContexts(With_itemContext.class);
		}
		public With_itemContext with_item(int i) {
			return getRuleContext(With_itemContext.class,i);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public With_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWith_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWith_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitWith_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_stmtContext with_stmt() throws RecognitionException {
		With_stmtContext _localctx = new With_stmtContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_with_stmt);
		int _la;
		try {
			int _alt;
			setState(1001);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(945);
				match(WITH);
				setState(946);
				match(LPAR);
				setState(947);
				with_item();
				setState(952);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(948);
						match(COMMA);
						setState(949);
						with_item();
						}
						} 
					}
					setState(954);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				}
				setState(956);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(955);
					match(COMMA);
					}
				}

				setState(958);
				match(RPAR);
				setState(959);
				match(COLON);
				setState(961);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(960);
					match(TYPE_COMMENT);
					}
				}

				setState(963);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(965);
				match(ASYNC);
				setState(966);
				match(WITH);
				setState(967);
				match(LPAR);
				setState(968);
				with_item();
				setState(973);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(969);
						match(COMMA);
						setState(970);
						with_item();
						}
						} 
					}
					setState(975);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				setState(977);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(976);
					match(COMMA);
					}
				}

				setState(979);
				match(RPAR);
				setState(980);
				match(COLON);
				setState(981);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(984);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASYNC) {
					{
					setState(983);
					match(ASYNC);
					}
				}

				setState(986);
				match(WITH);
				setState(987);
				with_item();
				setState(992);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(988);
					match(COMMA);
					setState(989);
					with_item();
					}
					}
					setState(994);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(995);
				match(COLON);
				setState(997);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(996);
					match(TYPE_COMMENT);
					}
				}

				setState(999);
				block();
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
	public static class With_itemContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Star_targetContext star_target() {
			return getRuleContext(Star_targetContext.class,0);
		}
		public With_itemContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_with_item; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWith_item(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWith_item(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitWith_item(this);
			else return visitor.visitChildren(this);
		}
	}

	public final With_itemContext with_item() throws RecognitionException {
		With_itemContext _localctx = new With_itemContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_with_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1003);
			expression();
			setState(1006);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1004);
				match(AS);
				setState(1005);
				star_target();
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
	public static class Try_stmtContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(PythonParser.TRY, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_blockContext finally_block() {
			return getRuleContext(Finally_blockContext.class,0);
		}
		public List<Except_blockContext> except_block() {
			return getRuleContexts(Except_blockContext.class);
		}
		public Except_blockContext except_block(int i) {
			return getRuleContext(Except_blockContext.class,i);
		}
		public Else_blockContext else_block() {
			return getRuleContext(Else_blockContext.class,0);
		}
		public List<Except_star_blockContext> except_star_block() {
			return getRuleContexts(Except_star_blockContext.class);
		}
		public Except_star_blockContext except_star_block(int i) {
			return getRuleContext(Except_star_blockContext.class,i);
		}
		public Try_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_try_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTry_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTry_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitTry_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Try_stmtContext try_stmt() throws RecognitionException {
		Try_stmtContext _localctx = new Try_stmtContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_try_stmt);
		int _la;
		try {
			setState(1041);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1008);
				match(TRY);
				setState(1009);
				match(COLON);
				setState(1010);
				block();
				setState(1011);
				finally_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1013);
				match(TRY);
				setState(1014);
				match(COLON);
				setState(1015);
				block();
				setState(1017); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1016);
					except_block();
					}
					}
					setState(1019); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(1022);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1021);
					else_block();
					}
				}

				setState(1025);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1024);
					finally_block();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1027);
				match(TRY);
				setState(1028);
				match(COLON);
				setState(1029);
				block();
				setState(1031); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1030);
					except_star_block();
					}
					}
					setState(1033); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(1036);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1035);
					else_block();
					}
				}

				setState(1039);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1038);
					finally_block();
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
	public static class Except_blockContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(PythonParser.EXCEPT, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Except_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExcept_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExcept_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitExcept_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_blockContext except_block() throws RecognitionException {
		Except_blockContext _localctx = new Except_blockContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_except_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1043);
			match(EXCEPT);
			setState(1049);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1044);
				expression();
				setState(1047);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1045);
					match(AS);
					setState(1046);
					name();
					}
				}

				}
			}

			setState(1051);
			match(COLON);
			setState(1052);
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
	public static class Except_star_blockContext extends ParserRuleContext {
		public TerminalNode EXCEPT() { return getToken(PythonParser.EXCEPT, 0); }
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Except_star_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_except_star_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExcept_star_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExcept_star_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitExcept_star_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Except_star_blockContext except_star_block() throws RecognitionException {
		Except_star_blockContext _localctx = new Except_star_blockContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_except_star_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1054);
			match(EXCEPT);
			setState(1055);
			match(STAR);
			setState(1056);
			expression();
			setState(1059);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1057);
				match(AS);
				setState(1058);
				name();
				}
			}

			setState(1061);
			match(COLON);
			setState(1062);
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
	public static class Finally_blockContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(PythonParser.FINALLY, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Finally_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finally_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFinally_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFinally_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFinally_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Finally_blockContext finally_block() throws RecognitionException {
		Finally_blockContext _localctx = new Finally_blockContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_finally_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1064);
			match(FINALLY);
			setState(1065);
			match(COLON);
			setState(1066);
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
	public static class Match_stmtContext extends ParserRuleContext {
		public TerminalNode NAME_OR_MATCH() { return getToken(PythonParser.NAME_OR_MATCH, 0); }
		public Subject_exprContext subject_expr() {
			return getRuleContext(Subject_exprContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public TerminalNode INDENT() { return getToken(PythonParser.INDENT, 0); }
		public TerminalNode DEDENT() { return getToken(PythonParser.DEDENT, 0); }
		public List<Case_blockContext> case_block() {
			return getRuleContexts(Case_blockContext.class);
		}
		public Case_blockContext case_block(int i) {
			return getRuleContext(Case_blockContext.class,i);
		}
		public Match_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_match_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMatch_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMatch_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitMatch_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Match_stmtContext match_stmt() throws RecognitionException {
		Match_stmtContext _localctx = new Match_stmtContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_match_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1068);
			match(NAME_OR_MATCH);
			setState(1069);
			subject_expr();
			setState(1070);
			match(COLON);
			setState(1071);
			match(NEWLINE);
			setState(1072);
			match(INDENT);
			setState(1074); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1073);
				case_block();
				}
				}
				setState(1076); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME_OR_CASE );
			setState(1078);
			match(DEDENT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Subject_exprContext extends ParserRuleContext {
		public Star_named_expressionContext star_named_expression() {
			return getRuleContext(Star_named_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public Subject_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_subject_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSubject_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSubject_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSubject_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Subject_exprContext subject_expr() throws RecognitionException {
		Subject_exprContext _localctx = new Subject_exprContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_subject_expr);
		int _la;
		try {
			setState(1086);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1080);
				star_named_expression();
				setState(1081);
				match(COMMA);
				setState(1083);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1082);
					star_named_expressions();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1085);
				named_expression();
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
	public static class Case_blockContext extends ParserRuleContext {
		public TerminalNode NAME_OR_CASE() { return getToken(PythonParser.NAME_OR_CASE, 0); }
		public PatternsContext patterns() {
			return getRuleContext(PatternsContext.class,0);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public GuardContext guard() {
			return getRuleContext(GuardContext.class,0);
		}
		public Case_blockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCase_block(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCase_block(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitCase_block(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Case_blockContext case_block() throws RecognitionException {
		Case_blockContext _localctx = new Case_blockContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_case_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1088);
			match(NAME_OR_CASE);
			setState(1089);
			patterns();
			setState(1091);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1090);
				guard();
				}
			}

			setState(1093);
			match(COLON);
			setState(1094);
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
	public static class GuardContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public GuardContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guard; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGuard(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGuard(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitGuard(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1096);
			match(IF);
			setState(1097);
			named_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternsContext extends ParserRuleContext {
		public Open_sequence_patternContext open_sequence_pattern() {
			return getRuleContext(Open_sequence_patternContext.class,0);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public PatternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPatterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPatterns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitPatterns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternsContext patterns() throws RecognitionException {
		PatternsContext _localctx = new PatternsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_patterns);
		try {
			setState(1101);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1099);
				open_sequence_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1100);
				pattern();
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
	public static class PatternContext extends ParserRuleContext {
		public As_patternContext as_pattern() {
			return getRuleContext(As_patternContext.class,0);
		}
		public Or_patternContext or_pattern() {
			return getRuleContext(Or_patternContext.class,0);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitPattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_pattern);
		try {
			setState(1105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1103);
				as_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1104);
				or_pattern();
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
	public static class As_patternContext extends ParserRuleContext {
		public Or_patternContext or_pattern() {
			return getRuleContext(Or_patternContext.class,0);
		}
		public TerminalNode AS() { return getToken(PythonParser.AS, 0); }
		public Pattern_capture_targetContext pattern_capture_target() {
			return getRuleContext(Pattern_capture_targetContext.class,0);
		}
		public As_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_as_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAs_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAs_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAs_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final As_patternContext as_pattern() throws RecognitionException {
		As_patternContext _localctx = new As_patternContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_as_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1107);
			or_pattern();
			setState(1108);
			match(AS);
			setState(1109);
			pattern_capture_target();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Or_patternContext extends ParserRuleContext {
		public List<Closed_patternContext> closed_pattern() {
			return getRuleContexts(Closed_patternContext.class);
		}
		public Closed_patternContext closed_pattern(int i) {
			return getRuleContext(Closed_patternContext.class,i);
		}
		public List<TerminalNode> VBAR() { return getTokens(PythonParser.VBAR); }
		public TerminalNode VBAR(int i) {
			return getToken(PythonParser.VBAR, i);
		}
		public Or_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterOr_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitOr_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitOr_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Or_patternContext or_pattern() throws RecognitionException {
		Or_patternContext _localctx = new Or_patternContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_or_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1111);
			closed_pattern();
			setState(1116);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(1112);
				match(VBAR);
				setState(1113);
				closed_pattern();
				}
				}
				setState(1118);
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
	public static class Closed_patternContext extends ParserRuleContext {
		public Literal_patternContext literal_pattern() {
			return getRuleContext(Literal_patternContext.class,0);
		}
		public Capture_patternContext capture_pattern() {
			return getRuleContext(Capture_patternContext.class,0);
		}
		public Wildcard_patternContext wildcard_pattern() {
			return getRuleContext(Wildcard_patternContext.class,0);
		}
		public Value_patternContext value_pattern() {
			return getRuleContext(Value_patternContext.class,0);
		}
		public Group_patternContext group_pattern() {
			return getRuleContext(Group_patternContext.class,0);
		}
		public Sequence_patternContext sequence_pattern() {
			return getRuleContext(Sequence_patternContext.class,0);
		}
		public Mapping_patternContext mapping_pattern() {
			return getRuleContext(Mapping_patternContext.class,0);
		}
		public Class_patternContext class_pattern() {
			return getRuleContext(Class_patternContext.class,0);
		}
		public Closed_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_closed_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClosed_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClosed_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitClosed_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Closed_patternContext closed_pattern() throws RecognitionException {
		Closed_patternContext _localctx = new Closed_patternContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_closed_pattern);
		try {
			setState(1127);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1119);
				literal_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1120);
				capture_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1121);
				wildcard_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1122);
				value_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1123);
				group_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1124);
				sequence_pattern();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1125);
				mapping_pattern();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1126);
				class_pattern();
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
	public static class Literal_patternContext extends ParserRuleContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Complex_numberContext complex_number() {
			return getRuleContext(Complex_numberContext.class,0);
		}
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode NONE() { return getToken(PythonParser.NONE, 0); }
		public TerminalNode TRUE() { return getToken(PythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PythonParser.FALSE, 0); }
		public Literal_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLiteral_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLiteral_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLiteral_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_patternContext literal_pattern() throws RecognitionException {
		Literal_patternContext _localctx = new Literal_patternContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_literal_pattern);
		try {
			setState(1135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1129);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1130);
				complex_number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1131);
				strings();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1132);
				match(NONE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1133);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1134);
				match(FALSE);
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
	public static class Literal_exprContext extends ParserRuleContext {
		public Signed_numberContext signed_number() {
			return getRuleContext(Signed_numberContext.class,0);
		}
		public Complex_numberContext complex_number() {
			return getRuleContext(Complex_numberContext.class,0);
		}
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode NONE() { return getToken(PythonParser.NONE, 0); }
		public TerminalNode TRUE() { return getToken(PythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PythonParser.FALSE, 0); }
		public Literal_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLiteral_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLiteral_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLiteral_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Literal_exprContext literal_expr() throws RecognitionException {
		Literal_exprContext _localctx = new Literal_exprContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_literal_expr);
		try {
			setState(1143);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1137);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1138);
				complex_number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1139);
				strings();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1140);
				match(NONE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1141);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1142);
				match(FALSE);
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
	public static class Complex_numberContext extends ParserRuleContext {
		public Signed_real_numberContext signed_real_number() {
			return getRuleContext(Signed_real_numberContext.class,0);
		}
		public Imaginary_numberContext imaginary_number() {
			return getRuleContext(Imaginary_numberContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public Complex_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_complex_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterComplex_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitComplex_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitComplex_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Complex_numberContext complex_number() throws RecognitionException {
		Complex_numberContext _localctx = new Complex_numberContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_complex_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1145);
			signed_real_number();
			setState(1146);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1147);
			imaginary_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_numberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public Signed_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSigned_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSigned_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSigned_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1150);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(1149);
				match(MINUS);
				}
			}

			setState(1152);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Signed_real_numberContext extends ParserRuleContext {
		public Real_numberContext real_number() {
			return getRuleContext(Real_numberContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public Signed_real_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_signed_real_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSigned_real_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSigned_real_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSigned_real_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Signed_real_numberContext signed_real_number() throws RecognitionException {
		Signed_real_numberContext _localctx = new Signed_real_numberContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_signed_real_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(1154);
				match(MINUS);
				}
			}

			setState(1157);
			real_number();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Real_numberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public Real_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_real_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterReal_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitReal_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitReal_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Real_numberContext real_number() throws RecognitionException {
		Real_numberContext _localctx = new Real_numberContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_real_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1159);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Imaginary_numberContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public Imaginary_numberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_imaginary_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterImaginary_number(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitImaginary_number(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitImaginary_number(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Imaginary_numberContext imaginary_number() throws RecognitionException {
		Imaginary_numberContext _localctx = new Imaginary_numberContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_imaginary_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1161);
			match(NUMBER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Capture_patternContext extends ParserRuleContext {
		public Pattern_capture_targetContext pattern_capture_target() {
			return getRuleContext(Pattern_capture_targetContext.class,0);
		}
		public Capture_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_capture_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCapture_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCapture_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitCapture_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Capture_patternContext capture_pattern() throws RecognitionException {
		Capture_patternContext _localctx = new Capture_patternContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_capture_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1163);
			pattern_capture_target();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Pattern_capture_targetContext extends ParserRuleContext {
		public Name_except_underscoreContext name_except_underscore() {
			return getRuleContext(Name_except_underscoreContext.class,0);
		}
		public Pattern_capture_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern_capture_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPattern_capture_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPattern_capture_target(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitPattern_capture_target(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Pattern_capture_targetContext pattern_capture_target() throws RecognitionException {
		Pattern_capture_targetContext _localctx = new Pattern_capture_targetContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_pattern_capture_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1165);
			name_except_underscore();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Wildcard_patternContext extends ParserRuleContext {
		public TerminalNode NAME_OR_WILDCARD() { return getToken(PythonParser.NAME_OR_WILDCARD, 0); }
		public Wildcard_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wildcard_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterWildcard_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitWildcard_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitWildcard_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Wildcard_patternContext wildcard_pattern() throws RecognitionException {
		Wildcard_patternContext _localctx = new Wildcard_patternContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_wildcard_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1167);
			match(NAME_OR_WILDCARD);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Value_patternContext extends ParserRuleContext {
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public Value_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterValue_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitValue_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitValue_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Value_patternContext value_pattern() throws RecognitionException {
		Value_patternContext _localctx = new Value_patternContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_value_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1169);
			attr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttrContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PythonParser.DOT, i);
		}
		public AttrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAttr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAttr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAttr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1171);
			name();
			setState(1174); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1172);
				match(DOT);
				setState(1173);
				name();
				}
				}
				setState(1176); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DOT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Name_or_attrContext extends ParserRuleContext {
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(PythonParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(PythonParser.DOT, i);
		}
		public Name_or_attrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_or_attr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName_or_attr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName_or_attr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitName_or_attr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Name_or_attrContext name_or_attr() throws RecognitionException {
		Name_or_attrContext _localctx = new Name_or_attrContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_name_or_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1178);
			name();
			setState(1183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(1179);
				match(DOT);
				setState(1180);
				name();
				}
				}
				setState(1185);
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
	public static class Group_patternContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Group_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGroup_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGroup_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitGroup_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Group_patternContext group_pattern() throws RecognitionException {
		Group_patternContext _localctx = new Group_patternContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_group_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1186);
			match(LPAR);
			setState(1187);
			pattern();
			setState(1188);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Sequence_patternContext extends ParserRuleContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Maybe_sequence_patternContext maybe_sequence_pattern() {
			return getRuleContext(Maybe_sequence_patternContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Open_sequence_patternContext open_sequence_pattern() {
			return getRuleContext(Open_sequence_patternContext.class,0);
		}
		public Sequence_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sequence_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSequence_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSequence_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSequence_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sequence_patternContext sequence_pattern() throws RecognitionException {
		Sequence_patternContext _localctx = new Sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_sequence_pattern);
		int _la;
		try {
			setState(1200);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSQB:
				enterOuterAlt(_localctx, 1);
				{
				setState(1190);
				match(LSQB);
				setState(1192);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603253196576L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(1191);
					maybe_sequence_pattern();
					}
				}

				setState(1194);
				match(RSQB);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1195);
				match(LPAR);
				setState(1197);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603253196576L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(1196);
					open_sequence_pattern();
					}
				}

				setState(1199);
				match(RPAR);
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
	public static class Open_sequence_patternContext extends ParserRuleContext {
		public Maybe_star_patternContext maybe_star_pattern() {
			return getRuleContext(Maybe_star_patternContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Maybe_sequence_patternContext maybe_sequence_pattern() {
			return getRuleContext(Maybe_sequence_patternContext.class,0);
		}
		public Open_sequence_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_open_sequence_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterOpen_sequence_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitOpen_sequence_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitOpen_sequence_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Open_sequence_patternContext open_sequence_pattern() throws RecognitionException {
		Open_sequence_patternContext _localctx = new Open_sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_open_sequence_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1202);
			maybe_star_pattern();
			setState(1203);
			match(COMMA);
			setState(1205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603253196576L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
				{
				setState(1204);
				maybe_sequence_pattern();
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
	public static class Maybe_sequence_patternContext extends ParserRuleContext {
		public List<Maybe_star_patternContext> maybe_star_pattern() {
			return getRuleContexts(Maybe_star_patternContext.class);
		}
		public Maybe_star_patternContext maybe_star_pattern(int i) {
			return getRuleContext(Maybe_star_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Maybe_sequence_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maybe_sequence_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMaybe_sequence_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMaybe_sequence_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitMaybe_sequence_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Maybe_sequence_patternContext maybe_sequence_pattern() throws RecognitionException {
		Maybe_sequence_patternContext _localctx = new Maybe_sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_maybe_sequence_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1207);
			maybe_star_pattern();
			setState(1212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1208);
					match(COMMA);
					setState(1209);
					maybe_star_pattern();
					}
					} 
				}
				setState(1214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(1216);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1215);
				match(COMMA);
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
	public static class Maybe_star_patternContext extends ParserRuleContext {
		public Star_patternContext star_pattern() {
			return getRuleContext(Star_patternContext.class,0);
		}
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public Maybe_star_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_maybe_star_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMaybe_star_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMaybe_star_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitMaybe_star_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Maybe_star_patternContext maybe_star_pattern() throws RecognitionException {
		Maybe_star_patternContext _localctx = new Maybe_star_patternContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_maybe_star_pattern);
		try {
			setState(1220);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1218);
				star_pattern();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case MINUS:
			case FALSE:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1219);
				pattern();
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
	public static class Star_patternContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Star_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_patternContext star_pattern() throws RecognitionException {
		Star_patternContext _localctx = new Star_patternContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_star_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1222);
			match(STAR);
			setState(1223);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Mapping_patternContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public Double_star_patternContext double_star_pattern() {
			return getRuleContext(Double_star_patternContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Items_patternContext items_pattern() {
			return getRuleContext(Items_patternContext.class,0);
		}
		public Mapping_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mapping_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterMapping_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitMapping_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitMapping_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mapping_patternContext mapping_pattern() throws RecognitionException {
		Mapping_patternContext _localctx = new Mapping_patternContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_mapping_pattern);
		int _la;
		try {
			setState(1245);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1225);
				match(LBRACE);
				setState(1226);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1227);
				match(LBRACE);
				setState(1228);
				double_star_pattern();
				setState(1230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1229);
					match(COMMA);
					}
				}

				setState(1232);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1234);
				match(LBRACE);
				setState(1235);
				items_pattern();
				setState(1238);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1236);
					match(COMMA);
					setState(1237);
					double_star_pattern();
					}
					break;
				}
				setState(1241);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1240);
					match(COMMA);
					}
				}

				setState(1243);
				match(RBRACE);
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
	public static class Items_patternContext extends ParserRuleContext {
		public List<Key_value_patternContext> key_value_pattern() {
			return getRuleContexts(Key_value_patternContext.class);
		}
		public Key_value_patternContext key_value_pattern(int i) {
			return getRuleContext(Key_value_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Items_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_items_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterItems_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitItems_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitItems_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Items_patternContext items_pattern() throws RecognitionException {
		Items_patternContext _localctx = new Items_patternContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_items_pattern);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1247);
			key_value_pattern();
			setState(1252);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1248);
					match(COMMA);
					setState(1249);
					key_value_pattern();
					}
					} 
				}
				setState(1254);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
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
	public static class Key_value_patternContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public Literal_exprContext literal_expr() {
			return getRuleContext(Literal_exprContext.class,0);
		}
		public AttrContext attr() {
			return getRuleContext(AttrContext.class,0);
		}
		public Key_value_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_key_value_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKey_value_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKey_value_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKey_value_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Key_value_patternContext key_value_pattern() throws RecognitionException {
		Key_value_patternContext _localctx = new Key_value_patternContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_key_value_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1257);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_START:
			case MINUS:
			case FALSE:
			case NONE:
			case TRUE:
			case NUMBER:
			case STRING:
				{
				setState(1255);
				literal_expr();
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				{
				setState(1256);
				attr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1259);
			match(COLON);
			setState(1260);
			pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Double_star_patternContext extends ParserRuleContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Pattern_capture_targetContext pattern_capture_target() {
			return getRuleContext(Pattern_capture_targetContext.class,0);
		}
		public Double_star_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_star_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDouble_star_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDouble_star_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDouble_star_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_star_patternContext double_star_pattern() throws RecognitionException {
		Double_star_patternContext _localctx = new Double_star_patternContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_double_star_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1262);
			match(DOUBLESTAR);
			setState(1263);
			pattern_capture_target();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Class_patternContext extends ParserRuleContext {
		public Name_or_attrContext name_or_attr() {
			return getRuleContext(Name_or_attrContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Positional_patternsContext positional_patterns() {
			return getRuleContext(Positional_patternsContext.class,0);
		}
		public Keyword_patternsContext keyword_patterns() {
			return getRuleContext(Keyword_patternsContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Class_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterClass_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitClass_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitClass_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_patternContext class_pattern() throws RecognitionException {
		Class_patternContext _localctx = new Class_patternContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_class_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1265);
			name_or_attr();
			setState(1266);
			match(LPAR);
			setState(1278);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603252148000L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
				{
				setState(1273);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
				case 1:
					{
					setState(1267);
					positional_patterns();
					setState(1270);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
					case 1:
						{
						setState(1268);
						match(COMMA);
						setState(1269);
						keyword_patterns();
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(1272);
					keyword_patterns();
					}
					break;
				}
				setState(1276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1275);
					match(COMMA);
					}
				}

				}
			}

			setState(1280);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Positional_patternsContext extends ParserRuleContext {
		public List<PatternContext> pattern() {
			return getRuleContexts(PatternContext.class);
		}
		public PatternContext pattern(int i) {
			return getRuleContext(PatternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Positional_patternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_positional_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPositional_patterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPositional_patterns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitPositional_patterns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Positional_patternsContext positional_patterns() throws RecognitionException {
		Positional_patternsContext _localctx = new Positional_patternsContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_positional_patterns);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1282);
			pattern();
			setState(1287);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1283);
					match(COMMA);
					setState(1284);
					pattern();
					}
					} 
				}
				setState(1289);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
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
	public static class Keyword_patternsContext extends ParserRuleContext {
		public List<Keyword_patternContext> keyword_pattern() {
			return getRuleContexts(Keyword_patternContext.class);
		}
		public Keyword_patternContext keyword_pattern(int i) {
			return getRuleContext(Keyword_patternContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Keyword_patternsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_patterns; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKeyword_patterns(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKeyword_patterns(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKeyword_patterns(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_patternsContext keyword_patterns() throws RecognitionException {
		Keyword_patternsContext _localctx = new Keyword_patternsContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_keyword_patterns);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1290);
			keyword_pattern();
			setState(1295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1291);
					match(COMMA);
					setState(1292);
					keyword_pattern();
					}
					} 
				}
				setState(1297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
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
	public static class Keyword_patternContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public Keyword_patternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword_pattern; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKeyword_pattern(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKeyword_pattern(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKeyword_pattern(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Keyword_patternContext keyword_pattern() throws RecognitionException {
		Keyword_patternContext _localctx = new Keyword_patternContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_keyword_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1298);
			name();
			setState(1299);
			match(EQUAL);
			setState(1300);
			pattern();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_aliasContext extends ParserRuleContext {
		public TerminalNode NAME_OR_TYPE() { return getToken(PythonParser.NAME_OR_TYPE, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Type_paramsContext type_params() {
			return getRuleContext(Type_paramsContext.class,0);
		}
		public Type_aliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_alias; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_alias(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_alias(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_alias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_aliasContext type_alias() throws RecognitionException {
		Type_aliasContext _localctx = new Type_aliasContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_type_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1302);
			match(NAME_OR_TYPE);
			setState(1303);
			name();
			setState(1305);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQB) {
				{
				setState(1304);
				type_params();
				}
			}

			setState(1307);
			match(EQUAL);
			setState(1308);
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
	public static class Type_paramsContext extends ParserRuleContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public Type_param_seqContext type_param_seq() {
			return getRuleContext(Type_param_seqContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Type_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_params(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_params(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_paramsContext type_params() throws RecognitionException {
		Type_paramsContext _localctx = new Type_paramsContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_type_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1310);
			match(LSQB);
			setState(1311);
			type_param_seq();
			setState(1312);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_param_seqContext extends ParserRuleContext {
		public List<Type_paramContext> type_param() {
			return getRuleContexts(Type_paramContext.class);
		}
		public Type_paramContext type_param(int i) {
			return getRuleContext(Type_paramContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Type_param_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_param_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_param_seqContext type_param_seq() throws RecognitionException {
		Type_param_seqContext _localctx = new Type_param_seqContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_type_param_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1314);
			type_param();
			setState(1319);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1315);
					match(COMMA);
					setState(1316);
					type_param();
					}
					} 
				}
				setState(1321);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
			}
			setState(1323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1322);
				match(COMMA);
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
	public static class Type_paramContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Type_param_boundContext type_param_bound() {
			return getRuleContext(Type_param_boundContext.class,0);
		}
		public Type_param_defaultContext type_param_default() {
			return getRuleContext(Type_param_defaultContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Type_param_starred_defaultContext type_param_starred_default() {
			return getRuleContext(Type_param_starred_defaultContext.class,0);
		}
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Type_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_paramContext type_param() throws RecognitionException {
		Type_paramContext _localctx = new Type_paramContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_type_param);
		int _la;
		try {
			setState(1342);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1325);
				name();
				setState(1327);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1326);
					type_param_bound();
					}
				}

				setState(1330);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1329);
					type_param_default();
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1332);
				match(STAR);
				setState(1333);
				name();
				setState(1335);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1334);
					type_param_starred_default();
					}
				}

				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1337);
				match(DOUBLESTAR);
				setState(1338);
				name();
				setState(1340);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1339);
					type_param_default();
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
	public static class Type_param_boundContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Type_param_boundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_bound; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_bound(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_bound(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_param_bound(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_param_boundContext type_param_bound() throws RecognitionException {
		Type_param_boundContext _localctx = new Type_param_boundContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_type_param_bound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1344);
			match(COLON);
			setState(1345);
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
	public static class Type_param_defaultContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Type_param_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_param_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_param_defaultContext type_param_default() throws RecognitionException {
		Type_param_defaultContext _localctx = new Type_param_defaultContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_type_param_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1347);
			match(EQUAL);
			setState(1348);
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
	public static class Type_param_starred_defaultContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public Star_expressionContext star_expression() {
			return getRuleContext(Star_expressionContext.class,0);
		}
		public Type_param_starred_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_param_starred_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_param_starred_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_param_starred_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_param_starred_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_param_starred_defaultContext type_param_starred_default() throws RecognitionException {
		Type_param_starred_defaultContext _localctx = new Type_param_starred_defaultContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_type_param_starred_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1350);
			match(EQUAL);
			setState(1351);
			star_expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public ExpressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExpressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExpressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitExpressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1353);
			expression();
			setState(1358);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1354);
					match(COMMA);
					setState(1355);
					expression();
					}
					} 
				}
				setState(1360);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			}
			setState(1362);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1361);
				match(COMMA);
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
	public static class ExpressionContext extends ParserRuleContext {
		public List<DisjunctionContext> disjunction() {
			return getRuleContexts(DisjunctionContext.class);
		}
		public DisjunctionContext disjunction(int i) {
			return getRuleContext(DisjunctionContext.class,i);
		}
		public TerminalNode IF() { return getToken(PythonParser.IF, 0); }
		public TerminalNode ELSE() { return getToken(PythonParser.ELSE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public LambdefContext lambdef() {
			return getRuleContext(LambdefContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_expression);
		int _la;
		try {
			setState(1373);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(1364);
				disjunction();
				setState(1370);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1365);
					match(IF);
					setState(1366);
					disjunction();
					setState(1367);
					match(ELSE);
					setState(1368);
					expression();
					}
				}

				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(1372);
				lambdef();
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
	public static class Yield_exprContext extends ParserRuleContext {
		public TerminalNode YIELD() { return getToken(PythonParser.YIELD, 0); }
		public TerminalNode FROM() { return getToken(PythonParser.FROM, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Star_expressionsContext star_expressions() {
			return getRuleContext(Star_expressionsContext.class,0);
		}
		public Yield_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_yield_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterYield_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitYield_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitYield_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Yield_exprContext yield_expr() throws RecognitionException {
		Yield_exprContext _localctx = new Yield_exprContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_yield_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1375);
			match(YIELD);
			setState(1381);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
				{
				setState(1376);
				match(FROM);
				setState(1377);
				expression();
				}
				break;
			case TYPE_COMMENT:
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case RPAR:
			case RBRACE:
			case COLON:
			case SEMI:
			case PLUS:
			case MINUS:
			case STAR:
			case EQUAL:
			case TILDE:
			case ELLIPSIS:
			case EXCLAMATION:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
			case NEWLINE:
				{
				setState(1379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1378);
					star_expressions();
					}
				}

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
	public static class Star_expressionsContext extends ParserRuleContext {
		public List<Star_expressionContext> star_expression() {
			return getRuleContexts(Star_expressionContext.class);
		}
		public Star_expressionContext star_expression(int i) {
			return getRuleContext(Star_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_expressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_expressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_expressionsContext star_expressions() throws RecognitionException {
		Star_expressionsContext _localctx = new Star_expressionsContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_star_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1383);
			star_expression();
			setState(1388);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1384);
					match(COMMA);
					setState(1385);
					star_expression();
					}
					} 
				}
				setState(1390);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			}
			setState(1392);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1391);
				match(COMMA);
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
	public static class Star_expressionContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Star_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_expressionContext star_expression() throws RecognitionException {
		Star_expressionContext _localctx = new Star_expressionContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_star_expression);
		try {
			setState(1397);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1394);
				match(STAR);
				setState(1395);
				bitwise_or(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1396);
				expression();
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
	public static class Star_named_expressionsContext extends ParserRuleContext {
		public List<Star_named_expressionContext> star_named_expression() {
			return getRuleContexts(Star_named_expressionContext.class);
		}
		public Star_named_expressionContext star_named_expression(int i) {
			return getRuleContext(Star_named_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_named_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_named_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_named_expressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_named_expressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_named_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_named_expressionsContext star_named_expressions() throws RecognitionException {
		Star_named_expressionsContext _localctx = new Star_named_expressionsContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_star_named_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1399);
			star_named_expression();
			setState(1404);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1400);
					match(COMMA);
					setState(1401);
					star_named_expression();
					}
					} 
				}
				setState(1406);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			}
			setState(1408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1407);
				match(COMMA);
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
	public static class Star_named_expressionContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public Star_named_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_named_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_named_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_named_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_named_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_named_expressionContext star_named_expression() throws RecognitionException {
		Star_named_expressionContext _localctx = new Star_named_expressionContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_star_named_expression);
		try {
			setState(1413);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1410);
				match(STAR);
				setState(1411);
				bitwise_or(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1412);
				named_expression();
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
	public static class Assignment_expressionContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode COLONEQUAL() { return getToken(PythonParser.COLONEQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAssignment_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAssignment_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAssignment_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_assignment_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1415);
			name();
			setState(1416);
			match(COLONEQUAL);
			setState(1417);
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
	public static class Named_expressionContext extends ParserRuleContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Named_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_named_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNamed_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNamed_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitNamed_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Named_expressionContext named_expression() throws RecognitionException {
		Named_expressionContext _localctx = new Named_expressionContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_named_expression);
		try {
			setState(1421);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1419);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1420);
				expression();
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
	public static class DisjunctionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public List<TerminalNode> OR() { return getTokens(PythonParser.OR); }
		public TerminalNode OR(int i) {
			return getToken(PythonParser.OR, i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDisjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDisjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1423);
			conjunction();
			setState(1428);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(1424);
				match(OR);
				setState(1425);
				conjunction();
				}
				}
				setState(1430);
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
	public static class ConjunctionContext extends ParserRuleContext {
		public List<InversionContext> inversion() {
			return getRuleContexts(InversionContext.class);
		}
		public InversionContext inversion(int i) {
			return getRuleContext(InversionContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(PythonParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(PythonParser.AND, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterConjunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitConjunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1431);
			inversion();
			setState(1436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(1432);
				match(AND);
				setState(1433);
				inversion();
				}
				}
				setState(1438);
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
	public static class InversionContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public InversionContext inversion() {
			return getRuleContext(InversionContext.class,0);
		}
		public ComparisonContext comparison() {
			return getRuleContext(ComparisonContext.class,0);
		}
		public InversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterInversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitInversion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitInversion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InversionContext inversion() throws RecognitionException {
		InversionContext _localctx = new InversionContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_inversion);
		try {
			setState(1442);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1439);
				match(NOT);
				setState(1440);
				inversion();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1441);
				comparison();
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
	public static class ComparisonContext extends ParserRuleContext {
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public List<Compare_op_bitwise_or_pairContext> compare_op_bitwise_or_pair() {
			return getRuleContexts(Compare_op_bitwise_or_pairContext.class);
		}
		public Compare_op_bitwise_or_pairContext compare_op_bitwise_or_pair(int i) {
			return getRuleContext(Compare_op_bitwise_or_pairContext.class,i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterComparison(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitComparison(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1444);
			bitwise_or(0);
			setState(1448);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 1152957788490563827L) != 0)) {
				{
				{
				setState(1445);
				compare_op_bitwise_or_pair();
				}
				}
				setState(1450);
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
	public static class Compare_op_bitwise_or_pairContext extends ParserRuleContext {
		public Eq_bitwise_orContext eq_bitwise_or() {
			return getRuleContext(Eq_bitwise_orContext.class,0);
		}
		public Noteq_bitwise_orContext noteq_bitwise_or() {
			return getRuleContext(Noteq_bitwise_orContext.class,0);
		}
		public Lte_bitwise_orContext lte_bitwise_or() {
			return getRuleContext(Lte_bitwise_orContext.class,0);
		}
		public Lt_bitwise_orContext lt_bitwise_or() {
			return getRuleContext(Lt_bitwise_orContext.class,0);
		}
		public Gte_bitwise_orContext gte_bitwise_or() {
			return getRuleContext(Gte_bitwise_orContext.class,0);
		}
		public Gt_bitwise_orContext gt_bitwise_or() {
			return getRuleContext(Gt_bitwise_orContext.class,0);
		}
		public Notin_bitwise_orContext notin_bitwise_or() {
			return getRuleContext(Notin_bitwise_orContext.class,0);
		}
		public In_bitwise_orContext in_bitwise_or() {
			return getRuleContext(In_bitwise_orContext.class,0);
		}
		public Isnot_bitwise_orContext isnot_bitwise_or() {
			return getRuleContext(Isnot_bitwise_orContext.class,0);
		}
		public Is_bitwise_orContext is_bitwise_or() {
			return getRuleContext(Is_bitwise_orContext.class,0);
		}
		public Compare_op_bitwise_or_pairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compare_op_bitwise_or_pair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterCompare_op_bitwise_or_pair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitCompare_op_bitwise_or_pair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitCompare_op_bitwise_or_pair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Compare_op_bitwise_or_pairContext compare_op_bitwise_or_pair() throws RecognitionException {
		Compare_op_bitwise_or_pairContext _localctx = new Compare_op_bitwise_or_pairContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_compare_op_bitwise_or_pair);
		try {
			setState(1461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1451);
				eq_bitwise_or();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1452);
				noteq_bitwise_or();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1453);
				lte_bitwise_or();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1454);
				lt_bitwise_or();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1455);
				gte_bitwise_or();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1456);
				gt_bitwise_or();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1457);
				notin_bitwise_or();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1458);
				in_bitwise_or();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1459);
				isnot_bitwise_or();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1460);
				is_bitwise_or();
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
	public static class Eq_bitwise_orContext extends ParserRuleContext {
		public TerminalNode EQEQUAL() { return getToken(PythonParser.EQEQUAL, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Eq_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eq_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterEq_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitEq_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitEq_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Eq_bitwise_orContext eq_bitwise_or() throws RecognitionException {
		Eq_bitwise_orContext _localctx = new Eq_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_eq_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1463);
			match(EQEQUAL);
			setState(1464);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Noteq_bitwise_orContext extends ParserRuleContext {
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public TerminalNode NOTEQUAL() { return getToken(PythonParser.NOTEQUAL, 0); }
		public Noteq_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noteq_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNoteq_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNoteq_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitNoteq_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Noteq_bitwise_orContext noteq_bitwise_or() throws RecognitionException {
		Noteq_bitwise_orContext _localctx = new Noteq_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_noteq_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1466);
			match(NOTEQUAL);
			}
			setState(1467);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lte_bitwise_orContext extends ParserRuleContext {
		public TerminalNode LESSEQUAL() { return getToken(PythonParser.LESSEQUAL, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Lte_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lte_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLte_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLte_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLte_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lte_bitwise_orContext lte_bitwise_or() throws RecognitionException {
		Lte_bitwise_orContext _localctx = new Lte_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_lte_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469);
			match(LESSEQUAL);
			setState(1470);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lt_bitwise_orContext extends ParserRuleContext {
		public TerminalNode LESS() { return getToken(PythonParser.LESS, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Lt_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lt_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLt_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLt_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLt_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lt_bitwise_orContext lt_bitwise_or() throws RecognitionException {
		Lt_bitwise_orContext _localctx = new Lt_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_lt_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1472);
			match(LESS);
			setState(1473);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Gte_bitwise_orContext extends ParserRuleContext {
		public TerminalNode GREATEREQUAL() { return getToken(PythonParser.GREATEREQUAL, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Gte_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gte_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGte_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGte_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitGte_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Gte_bitwise_orContext gte_bitwise_or() throws RecognitionException {
		Gte_bitwise_orContext _localctx = new Gte_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_gte_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1475);
			match(GREATEREQUAL);
			setState(1476);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Gt_bitwise_orContext extends ParserRuleContext {
		public TerminalNode GREATER() { return getToken(PythonParser.GREATER, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Gt_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gt_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGt_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGt_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitGt_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Gt_bitwise_orContext gt_bitwise_or() throws RecognitionException {
		Gt_bitwise_orContext _localctx = new Gt_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_gt_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1478);
			match(GREATER);
			setState(1479);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Notin_bitwise_orContext extends ParserRuleContext {
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Notin_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notin_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterNotin_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitNotin_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitNotin_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Notin_bitwise_orContext notin_bitwise_or() throws RecognitionException {
		Notin_bitwise_orContext _localctx = new Notin_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_notin_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1481);
			match(NOT);
			setState(1482);
			match(IN);
			setState(1483);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class In_bitwise_orContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public In_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_in_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIn_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIn_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitIn_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final In_bitwise_orContext in_bitwise_or() throws RecognitionException {
		In_bitwise_orContext _localctx = new In_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_in_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1485);
			match(IN);
			setState(1486);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Isnot_bitwise_orContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(PythonParser.IS, 0); }
		public TerminalNode NOT() { return getToken(PythonParser.NOT, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Isnot_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isnot_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIsnot_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIsnot_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitIsnot_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Isnot_bitwise_orContext isnot_bitwise_or() throws RecognitionException {
		Isnot_bitwise_orContext _localctx = new Isnot_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_isnot_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1488);
			match(IS);
			setState(1489);
			match(NOT);
			setState(1490);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Is_bitwise_orContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(PythonParser.IS, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public Is_bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_is_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterIs_bitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitIs_bitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitIs_bitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Is_bitwise_orContext is_bitwise_or() throws RecognitionException {
		Is_bitwise_orContext _localctx = new Is_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_is_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1492);
			match(IS);
			setState(1493);
			bitwise_or(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Bitwise_orContext extends ParserRuleContext {
		public Bitwise_xorContext bitwise_xor() {
			return getRuleContext(Bitwise_xorContext.class,0);
		}
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public TerminalNode VBAR() { return getToken(PythonParser.VBAR, 0); }
		public Bitwise_orContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_or; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBitwise_or(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBitwise_or(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitBitwise_or(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_orContext bitwise_or() throws RecognitionException {
		return bitwise_or(0);
	}

	private Bitwise_orContext bitwise_or(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_orContext _localctx = new Bitwise_orContext(_ctx, _parentState);
		Bitwise_orContext _prevctx = _localctx;
		int _startState = 256;
		enterRecursionRule(_localctx, 256, RULE_bitwise_or, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1496);
			bitwise_xor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1503);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_orContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_or);
					setState(1498);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1499);
					match(VBAR);
					setState(1500);
					bitwise_xor(0);
					}
					} 
				}
				setState(1505);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
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
	public static class Bitwise_xorContext extends ParserRuleContext {
		public Bitwise_andContext bitwise_and() {
			return getRuleContext(Bitwise_andContext.class,0);
		}
		public Bitwise_xorContext bitwise_xor() {
			return getRuleContext(Bitwise_xorContext.class,0);
		}
		public TerminalNode CIRCUMFLEX() { return getToken(PythonParser.CIRCUMFLEX, 0); }
		public Bitwise_xorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_xor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBitwise_xor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBitwise_xor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitBitwise_xor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_xorContext bitwise_xor() throws RecognitionException {
		return bitwise_xor(0);
	}

	private Bitwise_xorContext bitwise_xor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_xorContext _localctx = new Bitwise_xorContext(_ctx, _parentState);
		Bitwise_xorContext _prevctx = _localctx;
		int _startState = 258;
		enterRecursionRule(_localctx, 258, RULE_bitwise_xor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1507);
			bitwise_and(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1514);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_xorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_xor);
					setState(1509);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1510);
					match(CIRCUMFLEX);
					setState(1511);
					bitwise_and(0);
					}
					} 
				}
				setState(1516);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
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
	public static class Bitwise_andContext extends ParserRuleContext {
		public Shift_exprContext shift_expr() {
			return getRuleContext(Shift_exprContext.class,0);
		}
		public Bitwise_andContext bitwise_and() {
			return getRuleContext(Bitwise_andContext.class,0);
		}
		public TerminalNode AMPER() { return getToken(PythonParser.AMPER, 0); }
		public Bitwise_andContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bitwise_and; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterBitwise_and(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitBitwise_and(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitBitwise_and(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bitwise_andContext bitwise_and() throws RecognitionException {
		return bitwise_and(0);
	}

	private Bitwise_andContext bitwise_and(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Bitwise_andContext _localctx = new Bitwise_andContext(_ctx, _parentState);
		Bitwise_andContext _prevctx = _localctx;
		int _startState = 260;
		enterRecursionRule(_localctx, 260, RULE_bitwise_and, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1518);
			shift_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1525);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_andContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_and);
					setState(1520);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1521);
					match(AMPER);
					setState(1522);
					shift_expr(0);
					}
					} 
				}
				setState(1527);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
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
	public static class Shift_exprContext extends ParserRuleContext {
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public Shift_exprContext shift_expr() {
			return getRuleContext(Shift_exprContext.class,0);
		}
		public TerminalNode LEFTSHIFT() { return getToken(PythonParser.LEFTSHIFT, 0); }
		public TerminalNode RIGHTSHIFT() { return getToken(PythonParser.RIGHTSHIFT, 0); }
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterShift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitShift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitShift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		return shift_expr(0);
	}

	private Shift_exprContext shift_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, _parentState);
		Shift_exprContext _prevctx = _localctx;
		int _startState = 262;
		enterRecursionRule(_localctx, 262, RULE_shift_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1529);
			sum(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1536);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Shift_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shift_expr);
					setState(1531);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1532);
					_la = _input.LA(1);
					if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1533);
					sum(0);
					}
					} 
				}
				setState(1538);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
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
	public static class SumContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public SumContext sum() {
			return getRuleContext(SumContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(PythonParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public SumContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sum; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSum(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSum(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSum(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SumContext sum() throws RecognitionException {
		return sum(0);
	}

	private SumContext sum(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SumContext _localctx = new SumContext(_ctx, _parentState);
		SumContext _prevctx = _localctx;
		int _startState = 264;
		enterRecursionRule(_localctx, 264, RULE_sum, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1540);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1547);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SumContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sum);
					setState(1542);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1543);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1544);
					term(0);
					}
					} 
				}
				setState(1549);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
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
	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public TerminalNode DOUBLESLASH() { return getToken(PythonParser.DOUBLESLASH, 0); }
		public TerminalNode PERCENT() { return getToken(PythonParser.PERCENT, 0); }
		public TerminalNode AT() { return getToken(PythonParser.AT, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 266;
		enterRecursionRule(_localctx, 266, RULE_term, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1551);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(1558);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(1553);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1554);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1407375020916736L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1555);
					factor();
					}
					} 
				}
				setState(1560);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
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
	public static class FactorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(PythonParser.PLUS, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode MINUS() { return getToken(PythonParser.MINUS, 0); }
		public TerminalNode TILDE() { return getToken(PythonParser.TILDE, 0); }
		public PowerContext power() {
			return getRuleContext(PowerContext.class,0);
		}
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_factor);
		try {
			setState(1568);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1561);
				match(PLUS);
				setState(1562);
				factor();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1563);
				match(MINUS);
				setState(1564);
				factor();
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1565);
				match(TILDE);
				setState(1566);
				factor();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 4);
				{
				setState(1567);
				power();
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
	public static class PowerContext extends ParserRuleContext {
		public Await_primaryContext await_primary() {
			return getRuleContext(Await_primaryContext.class,0);
		}
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public PowerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_power; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPower(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPower(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitPower(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PowerContext power() throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_power);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1570);
			await_primary();
			setState(1573);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				{
				setState(1571);
				match(DOUBLESTAR);
				setState(1572);
				factor();
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
	public static class Await_primaryContext extends ParserRuleContext {
		public TerminalNode AWAIT() { return getToken(PythonParser.AWAIT, 0); }
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public Await_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_await_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAwait_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAwait_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAwait_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Await_primaryContext await_primary() throws RecognitionException {
		Await_primaryContext _localctx = new Await_primaryContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_await_primary);
		try {
			setState(1578);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AWAIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1575);
				match(AWAIT);
				setState(1576);
				primary(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case ELLIPSIS:
			case FALSE:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1577);
				primary(0);
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
	public static class PrimaryContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public GenexpContext genexp() {
			return getRuleContext(GenexpContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterPrimary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitPrimary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitPrimary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryContext primary() throws RecognitionException {
		return primary(0);
	}

	private PrimaryContext primary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PrimaryContext _localctx = new PrimaryContext(_ctx, _parentState);
		PrimaryContext _prevctx = _localctx;
		int _startState = 274;
		enterRecursionRule(_localctx, 274, RULE_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1581);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(1600);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimaryContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_primary);
					setState(1583);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1596);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
					case 1:
						{
						setState(1584);
						match(DOT);
						setState(1585);
						name();
						}
						break;
					case 2:
						{
						setState(1586);
						genexp();
						}
						break;
					case 3:
						{
						setState(1587);
						match(LPAR);
						setState(1589);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
							{
							setState(1588);
							arguments();
							}
						}

						setState(1591);
						match(RPAR);
						}
						break;
					case 4:
						{
						setState(1592);
						match(LSQB);
						setState(1593);
						slices();
						setState(1594);
						match(RSQB);
						}
						break;
					}
					}
					} 
				}
				setState(1602);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
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
	public static class SlicesContext extends ParserRuleContext {
		public List<SliceContext> slice() {
			return getRuleContexts(SliceContext.class);
		}
		public SliceContext slice(int i) {
			return getRuleContext(SliceContext.class,i);
		}
		public List<Starred_expressionContext> starred_expression() {
			return getRuleContexts(Starred_expressionContext.class);
		}
		public Starred_expressionContext starred_expression(int i) {
			return getRuleContext(Starred_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public SlicesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slices; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlices(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlices(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSlices(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SlicesContext slices() throws RecognitionException {
		SlicesContext _localctx = new SlicesContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_slices);
		int _la;
		try {
			int _alt;
			setState(1621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1603);
				slice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1606);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FSTRING_START:
				case LPAR:
				case LSQB:
				case LBRACE:
				case COLON:
				case PLUS:
				case MINUS:
				case TILDE:
				case ELLIPSIS:
				case FALSE:
				case AWAIT:
				case NONE:
				case TRUE:
				case LAMBDA:
				case NOT:
				case NAME_OR_TYPE:
				case NAME_OR_MATCH:
				case NAME_OR_CASE:
				case NAME_OR_WILDCARD:
				case NAME:
				case NUMBER:
				case STRING:
					{
					setState(1604);
					slice();
					}
					break;
				case STAR:
					{
					setState(1605);
					starred_expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1615);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1608);
						match(COMMA);
						setState(1611);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case FSTRING_START:
						case LPAR:
						case LSQB:
						case LBRACE:
						case COLON:
						case PLUS:
						case MINUS:
						case TILDE:
						case ELLIPSIS:
						case FALSE:
						case AWAIT:
						case NONE:
						case TRUE:
						case LAMBDA:
						case NOT:
						case NAME_OR_TYPE:
						case NAME_OR_MATCH:
						case NAME_OR_CASE:
						case NAME_OR_WILDCARD:
						case NAME:
						case NUMBER:
						case STRING:
							{
							setState(1609);
							slice();
							}
							break;
						case STAR:
							{
							setState(1610);
							starred_expression();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(1617);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
				}
				setState(1619);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1618);
					match(COMMA);
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
	public static class SliceContext extends ParserRuleContext {
		public List<TerminalNode> COLON() { return getTokens(PythonParser.COLON); }
		public TerminalNode COLON(int i) {
			return getToken(PythonParser.COLON, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public SliceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_slice; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSlice(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSlice(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSlice(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_slice);
		int _la;
		try {
			setState(1637);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1624);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1623);
					expression();
					}
				}

				setState(1626);
				match(COLON);
				setState(1628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1627);
					expression();
					}
				}

				setState(1634);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1630);
					match(COLON);
					setState(1632);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
						{
						setState(1631);
						expression();
						}
					}

					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1636);
				named_expression();
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
	public static class AtomContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(PythonParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(PythonParser.FALSE, 0); }
		public TerminalNode NONE() { return getToken(PythonParser.NONE, 0); }
		public StringsContext strings() {
			return getRuleContext(StringsContext.class,0);
		}
		public TerminalNode NUMBER() { return getToken(PythonParser.NUMBER, 0); }
		public TupleContext tuple() {
			return getRuleContext(TupleContext.class,0);
		}
		public GroupContext group() {
			return getRuleContext(GroupContext.class,0);
		}
		public GenexpContext genexp() {
			return getRuleContext(GenexpContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public ListcompContext listcomp() {
			return getRuleContext(ListcompContext.class,0);
		}
		public DictContext dict() {
			return getRuleContext(DictContext.class,0);
		}
		public SetContext set() {
			return getRuleContext(SetContext.class,0);
		}
		public DictcompContext dictcomp() {
			return getRuleContext(DictcompContext.class,0);
		}
		public SetcompContext setcomp() {
			return getRuleContext(SetcompContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(PythonParser.ELLIPSIS, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_atom);
		try {
			setState(1661);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1639);
				name();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1640);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1641);
				match(FALSE);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1642);
				match(NONE);
				}
				break;
			case FSTRING_START:
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(1643);
				strings();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 6);
				{
				setState(1644);
				match(NUMBER);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(1648);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
				case 1:
					{
					setState(1645);
					tuple();
					}
					break;
				case 2:
					{
					setState(1646);
					group();
					}
					break;
				case 3:
					{
					setState(1647);
					genexp();
					}
					break;
				}
				}
				break;
			case LSQB:
				enterOuterAlt(_localctx, 8);
				{
				setState(1652);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1650);
					list();
					}
					break;
				case 2:
					{
					setState(1651);
					listcomp();
					}
					break;
				}
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1658);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
				case 1:
					{
					setState(1654);
					dict();
					}
					break;
				case 2:
					{
					setState(1655);
					set();
					}
					break;
				case 3:
					{
					setState(1656);
					dictcomp();
					}
					break;
				case 4:
					{
					setState(1657);
					setcomp();
					}
					break;
				}
				}
				break;
			case ELLIPSIS:
				enterOuterAlt(_localctx, 10);
				{
				setState(1660);
				match(ELLIPSIS);
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
	public static class GroupContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Yield_exprContext yield_expr() {
			return getRuleContext(Yield_exprContext.class,0);
		}
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public GroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_group; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGroup(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGroup(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitGroup(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1663);
			match(LPAR);
			setState(1666);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YIELD:
				{
				setState(1664);
				yield_expr();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				{
				setState(1665);
				named_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1668);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdefContext extends ParserRuleContext {
		public TerminalNode LAMBDA() { return getToken(PythonParser.LAMBDA, 0); }
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Lambda_paramsContext lambda_params() {
			return getRuleContext(Lambda_paramsContext.class,0);
		}
		public LambdefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambdef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambdef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambdef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdefContext lambdef() throws RecognitionException {
		LambdefContext _localctx = new LambdefContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_lambdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1670);
			match(LAMBDA);
			setState(1672);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
				{
				setState(1671);
				lambda_params();
				}
			}

			setState(1674);
			match(COLON);
			setState(1675);
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
	public static class Lambda_paramsContext extends ParserRuleContext {
		public Lambda_parametersContext lambda_parameters() {
			return getRuleContext(Lambda_parametersContext.class,0);
		}
		public Lambda_paramsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_params; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_params(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_params(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_params(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_paramsContext lambda_params() throws RecognitionException {
		Lambda_paramsContext _localctx = new Lambda_paramsContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_lambda_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1677);
			lambda_parameters();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lambda_parametersContext extends ParserRuleContext {
		public Lambda_slash_no_defaultContext lambda_slash_no_default() {
			return getRuleContext(Lambda_slash_no_defaultContext.class,0);
		}
		public List<Lambda_param_no_defaultContext> lambda_param_no_default() {
			return getRuleContexts(Lambda_param_no_defaultContext.class);
		}
		public Lambda_param_no_defaultContext lambda_param_no_default(int i) {
			return getRuleContext(Lambda_param_no_defaultContext.class,i);
		}
		public List<Lambda_param_with_defaultContext> lambda_param_with_default() {
			return getRuleContexts(Lambda_param_with_defaultContext.class);
		}
		public Lambda_param_with_defaultContext lambda_param_with_default(int i) {
			return getRuleContext(Lambda_param_with_defaultContext.class,i);
		}
		public Lambda_star_etcContext lambda_star_etc() {
			return getRuleContext(Lambda_star_etcContext.class,0);
		}
		public Lambda_slash_with_defaultContext lambda_slash_with_default() {
			return getRuleContext(Lambda_slash_with_defaultContext.class,0);
		}
		public Lambda_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_parametersContext lambda_parameters() throws RecognitionException {
		Lambda_parametersContext _localctx = new Lambda_parametersContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_lambda_parameters);
		int _la;
		try {
			int _alt;
			setState(1728);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1679);
				lambda_slash_no_default();
				setState(1683);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1680);
						lambda_param_no_default();
						}
						} 
					}
					setState(1685);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				}
				setState(1689);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1686);
					lambda_param_with_default();
					}
					}
					setState(1691);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1692);
					lambda_star_etc();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1695);
				lambda_slash_with_default();
				setState(1699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1696);
					lambda_param_with_default();
					}
					}
					setState(1701);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1703);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1702);
					lambda_star_etc();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1706); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1705);
						lambda_param_no_default();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1708); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1713);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1710);
					lambda_param_with_default();
					}
					}
					setState(1715);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1717);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1716);
					lambda_star_etc();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1720); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1719);
					lambda_param_with_default();
					}
					}
					setState(1722); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(1725);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1724);
					lambda_star_etc();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1727);
				lambda_star_etc();
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
	public static class Lambda_slash_no_defaultContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Lambda_param_no_defaultContext> lambda_param_no_default() {
			return getRuleContexts(Lambda_param_no_defaultContext.class);
		}
		public Lambda_param_no_defaultContext lambda_param_no_default(int i) {
			return getRuleContext(Lambda_param_no_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_slash_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_slash_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_slash_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_slash_no_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_slash_no_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_slash_no_defaultContext lambda_slash_no_default() throws RecognitionException {
		Lambda_slash_no_defaultContext _localctx = new Lambda_slash_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_lambda_slash_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1731); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1730);
				lambda_param_no_default();
				}
				}
				setState(1733); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(1735);
			match(SLASH);
			setState(1737);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1736);
				match(COMMA);
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
	public static class Lambda_slash_with_defaultContext extends ParserRuleContext {
		public TerminalNode SLASH() { return getToken(PythonParser.SLASH, 0); }
		public List<Lambda_param_no_defaultContext> lambda_param_no_default() {
			return getRuleContexts(Lambda_param_no_defaultContext.class);
		}
		public Lambda_param_no_defaultContext lambda_param_no_default(int i) {
			return getRuleContext(Lambda_param_no_defaultContext.class,i);
		}
		public List<Lambda_param_with_defaultContext> lambda_param_with_default() {
			return getRuleContexts(Lambda_param_with_defaultContext.class);
		}
		public Lambda_param_with_defaultContext lambda_param_with_default(int i) {
			return getRuleContext(Lambda_param_with_defaultContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_slash_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_slash_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_slash_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_slash_with_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_slash_with_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_slash_with_defaultContext lambda_slash_with_default() throws RecognitionException {
		Lambda_slash_with_defaultContext _localctx = new Lambda_slash_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_lambda_slash_with_default);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1742);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1739);
					lambda_param_no_default();
					}
					} 
				}
				setState(1744);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			}
			setState(1746); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1745);
				lambda_param_with_default();
				}
				}
				setState(1748); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(1750);
			match(SLASH);
			setState(1752);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1751);
				match(COMMA);
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
	public static class Lambda_star_etcContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Lambda_param_no_defaultContext lambda_param_no_default() {
			return getRuleContext(Lambda_param_no_defaultContext.class,0);
		}
		public List<Lambda_param_maybe_defaultContext> lambda_param_maybe_default() {
			return getRuleContexts(Lambda_param_maybe_defaultContext.class);
		}
		public Lambda_param_maybe_defaultContext lambda_param_maybe_default(int i) {
			return getRuleContext(Lambda_param_maybe_defaultContext.class,i);
		}
		public Lambda_kwdsContext lambda_kwds() {
			return getRuleContext(Lambda_kwdsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_star_etcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_star_etc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_star_etc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_star_etc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_star_etc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_star_etcContext lambda_star_etc() throws RecognitionException {
		Lambda_star_etcContext _localctx = new Lambda_star_etcContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_lambda_star_etc);
		int _la;
		try {
			setState(1776);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1754);
				match(STAR);
				setState(1755);
				lambda_param_no_default();
				setState(1759);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1756);
					lambda_param_maybe_default();
					}
					}
					setState(1761);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1763);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(1762);
					lambda_kwds();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1765);
				match(STAR);
				setState(1766);
				match(COMMA);
				setState(1768); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1767);
					lambda_param_maybe_default();
					}
					}
					setState(1770); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(1773);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(1772);
					lambda_kwds();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1775);
				lambda_kwds();
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
	public static class Lambda_kwdsContext extends ParserRuleContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Lambda_param_no_defaultContext lambda_param_no_default() {
			return getRuleContext(Lambda_param_no_defaultContext.class,0);
		}
		public Lambda_kwdsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_kwds; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_kwds(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_kwds(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_kwds(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_kwdsContext lambda_kwds() throws RecognitionException {
		Lambda_kwdsContext _localctx = new Lambda_kwdsContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_lambda_kwds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1778);
			match(DOUBLESTAR);
			setState(1779);
			lambda_param_no_default();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Lambda_param_no_defaultContext extends ParserRuleContext {
		public Lambda_paramContext lambda_param() {
			return getRuleContext(Lambda_paramContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_param_no_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param_no_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param_no_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param_no_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_param_no_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_param_no_defaultContext lambda_param_no_default() throws RecognitionException {
		Lambda_param_no_defaultContext _localctx = new Lambda_param_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_lambda_param_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1781);
			lambda_param();
			setState(1783);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1782);
				match(COMMA);
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
	public static class Lambda_param_with_defaultContext extends ParserRuleContext {
		public Lambda_paramContext lambda_param() {
			return getRuleContext(Lambda_paramContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_param_with_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param_with_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param_with_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param_with_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_param_with_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_param_with_defaultContext lambda_param_with_default() throws RecognitionException {
		Lambda_param_with_defaultContext _localctx = new Lambda_param_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_lambda_param_with_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1785);
			lambda_param();
			setState(1786);
			default_assignment();
			setState(1788);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1787);
				match(COMMA);
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
	public static class Lambda_param_maybe_defaultContext extends ParserRuleContext {
		public Lambda_paramContext lambda_param() {
			return getRuleContext(Lambda_paramContext.class,0);
		}
		public Default_assignmentContext default_assignment() {
			return getRuleContext(Default_assignmentContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Lambda_param_maybe_defaultContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param_maybe_default; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param_maybe_default(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param_maybe_default(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_param_maybe_default(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_param_maybe_defaultContext lambda_param_maybe_default() throws RecognitionException {
		Lambda_param_maybe_defaultContext _localctx = new Lambda_param_maybe_defaultContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_lambda_param_maybe_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1790);
			lambda_param();
			setState(1792);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(1791);
				default_assignment();
				}
			}

			setState(1795);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1794);
				match(COMMA);
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
	public static class Lambda_paramContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Lambda_paramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambda_param; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterLambda_param(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitLambda_param(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitLambda_param(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Lambda_paramContext lambda_param() throws RecognitionException {
		Lambda_paramContext _localctx = new Lambda_paramContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_lambda_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1797);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fstring_middleContext extends ParserRuleContext {
		public Fstring_replacement_fieldContext fstring_replacement_field() {
			return getRuleContext(Fstring_replacement_fieldContext.class,0);
		}
		public TerminalNode FSTRING_MIDDLE() { return getToken(PythonParser.FSTRING_MIDDLE, 0); }
		public Fstring_middleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_middle; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_middle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_middle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFstring_middle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fstring_middleContext fstring_middle() throws RecognitionException {
		Fstring_middleContext _localctx = new Fstring_middleContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_fstring_middle);
		try {
			setState(1801);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1799);
				fstring_replacement_field();
				}
				break;
			case FSTRING_MIDDLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1800);
				match(FSTRING_MIDDLE);
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
	public static class Fstring_replacement_fieldContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public Annotated_rhsContext annotated_rhs() {
			return getRuleContext(Annotated_rhsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public Fstring_conversionContext fstring_conversion() {
			return getRuleContext(Fstring_conversionContext.class,0);
		}
		public Fstring_full_format_specContext fstring_full_format_spec() {
			return getRuleContext(Fstring_full_format_specContext.class,0);
		}
		public Fstring_replacement_fieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_replacement_field; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_replacement_field(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_replacement_field(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFstring_replacement_field(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fstring_replacement_fieldContext fstring_replacement_field() throws RecognitionException {
		Fstring_replacement_fieldContext _localctx = new Fstring_replacement_fieldContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_fstring_replacement_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1803);
			match(LBRACE);
			setState(1804);
			annotated_rhs();
			setState(1806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(1805);
				match(EQUAL);
				}
			}

			setState(1809);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION) {
				{
				setState(1808);
				fstring_conversion();
				}
			}

			setState(1812);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1811);
				fstring_full_format_spec();
				}
			}

			setState(1814);
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
	public static class Fstring_conversionContext extends ParserRuleContext {
		public TerminalNode EXCLAMATION() { return getToken(PythonParser.EXCLAMATION, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public Fstring_conversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_conversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_conversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_conversion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFstring_conversion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fstring_conversionContext fstring_conversion() throws RecognitionException {
		Fstring_conversionContext _localctx = new Fstring_conversionContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_fstring_conversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1816);
			match(EXCLAMATION);
			setState(1817);
			name();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Fstring_full_format_specContext extends ParserRuleContext {
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public List<Fstring_format_specContext> fstring_format_spec() {
			return getRuleContexts(Fstring_format_specContext.class);
		}
		public Fstring_format_specContext fstring_format_spec(int i) {
			return getRuleContext(Fstring_format_specContext.class,i);
		}
		public Fstring_full_format_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_full_format_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_full_format_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_full_format_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFstring_full_format_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fstring_full_format_specContext fstring_full_format_spec() throws RecognitionException {
		Fstring_full_format_specContext _localctx = new Fstring_full_format_specContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_fstring_full_format_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1819);
			match(COLON);
			setState(1823);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FSTRING_MIDDLE || _la==LBRACE) {
				{
				{
				setState(1820);
				fstring_format_spec();
				}
				}
				setState(1825);
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
	public static class Fstring_format_specContext extends ParserRuleContext {
		public TerminalNode FSTRING_MIDDLE() { return getToken(PythonParser.FSTRING_MIDDLE, 0); }
		public Fstring_replacement_fieldContext fstring_replacement_field() {
			return getRuleContext(Fstring_replacement_fieldContext.class,0);
		}
		public Fstring_format_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring_format_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring_format_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring_format_spec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFstring_format_spec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Fstring_format_specContext fstring_format_spec() throws RecognitionException {
		Fstring_format_specContext _localctx = new Fstring_format_specContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_fstring_format_spec);
		try {
			setState(1828);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_MIDDLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1826);
				match(FSTRING_MIDDLE);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1827);
				fstring_replacement_field();
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
	public static class FstringContext extends ParserRuleContext {
		public TerminalNode FSTRING_START() { return getToken(PythonParser.FSTRING_START, 0); }
		public TerminalNode FSTRING_END() { return getToken(PythonParser.FSTRING_END, 0); }
		public List<Fstring_middleContext> fstring_middle() {
			return getRuleContexts(Fstring_middleContext.class);
		}
		public Fstring_middleContext fstring_middle(int i) {
			return getRuleContext(Fstring_middleContext.class,i);
		}
		public FstringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstring; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstring(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstring(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFstring(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FstringContext fstring() throws RecognitionException {
		FstringContext _localctx = new FstringContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_fstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1830);
			match(FSTRING_START);
			setState(1834);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FSTRING_MIDDLE || _la==LBRACE) {
				{
				{
				setState(1831);
				fstring_middle();
				}
				}
				setState(1836);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1837);
			match(FSTRING_END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		public TerminalNode STRING() { return getToken(PythonParser.STRING, 0); }
		public StringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_string; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1839);
			match(STRING);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringsContext extends ParserRuleContext {
		public List<FstringOrStringContext> fstringOrString() {
			return getRuleContexts(FstringOrStringContext.class);
		}
		public FstringOrStringContext fstringOrString(int i) {
			return getRuleContext(FstringOrStringContext.class,i);
		}
		public StringsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_strings; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStrings(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStrings(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStrings(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringsContext strings() throws RecognitionException {
		StringsContext _localctx = new StringsContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_strings);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1842); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1841);
					fstringOrString();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1844); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,233,_ctx);
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
	public static class FstringOrStringContext extends ParserRuleContext {
		public FstringContext fstring() {
			return getRuleContext(FstringContext.class,0);
		}
		public StringContext string() {
			return getRuleContext(StringContext.class,0);
		}
		public FstringOrStringContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fstringOrString; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFstringOrString(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFstringOrString(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFstringOrString(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FstringOrStringContext fstringOrString() throws RecognitionException {
		FstringOrStringContext _localctx = new FstringOrStringContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_fstringOrString);
		try {
			setState(1848);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(1846);
				fstring();
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1847);
				string();
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
	public static class ListContext extends ParserRuleContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitList(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1850);
			match(LSQB);
			setState(1852);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1851);
				star_named_expressions();
				}
			}

			setState(1854);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TupleContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Star_named_expressionContext star_named_expression() {
			return getRuleContext(Star_named_expressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public TupleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tuple; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTuple(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTuple(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitTuple(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1856);
			match(LPAR);
			setState(1862);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1857);
				star_named_expression();
				setState(1858);
				match(COMMA);
				setState(1860);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1859);
					star_named_expressions();
					}
				}

				}
			}

			setState(1864);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public Star_named_expressionsContext star_named_expressions() {
			return getRuleContext(Star_named_expressionsContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public SetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_set; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSet(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSet(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSet(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1866);
			match(LBRACE);
			setState(1867);
			star_named_expressions();
			setState(1868);
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
	public static class DictContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public Double_starred_kvpairsContext double_starred_kvpairs() {
			return getRuleContext(Double_starred_kvpairsContext.class,0);
		}
		public DictContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dict; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDict(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDict(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDict(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictContext dict() throws RecognitionException {
		DictContext _localctx = new DictContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_dict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1870);
			match(LBRACE);
			setState(1872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063597451040L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1871);
				double_starred_kvpairs();
				}
			}

			setState(1874);
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
	public static class Double_starred_kvpairsContext extends ParserRuleContext {
		public List<Double_starred_kvpairContext> double_starred_kvpair() {
			return getRuleContexts(Double_starred_kvpairContext.class);
		}
		public Double_starred_kvpairContext double_starred_kvpair(int i) {
			return getRuleContext(Double_starred_kvpairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Double_starred_kvpairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_starred_kvpairs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDouble_starred_kvpairs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDouble_starred_kvpairs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDouble_starred_kvpairs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_starred_kvpairsContext double_starred_kvpairs() throws RecognitionException {
		Double_starred_kvpairsContext _localctx = new Double_starred_kvpairsContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_double_starred_kvpairs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1876);
			double_starred_kvpair();
			setState(1881);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1877);
					match(COMMA);
					setState(1878);
					double_starred_kvpair();
					}
					} 
				}
				setState(1883);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
			}
			setState(1885);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1884);
				match(COMMA);
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
	public static class Double_starred_kvpairContext extends ParserRuleContext {
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Bitwise_orContext bitwise_or() {
			return getRuleContext(Bitwise_orContext.class,0);
		}
		public KvpairContext kvpair() {
			return getRuleContext(KvpairContext.class,0);
		}
		public Double_starred_kvpairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_starred_kvpair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDouble_starred_kvpair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDouble_starred_kvpair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDouble_starred_kvpair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_starred_kvpairContext double_starred_kvpair() throws RecognitionException {
		Double_starred_kvpairContext _localctx = new Double_starred_kvpairContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_double_starred_kvpair);
		try {
			setState(1890);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1887);
				match(DOUBLESTAR);
				setState(1888);
				bitwise_or(0);
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1889);
				kvpair();
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
	public static class KvpairContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode COLON() { return getToken(PythonParser.COLON, 0); }
		public KvpairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kvpair; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKvpair(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKvpair(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKvpair(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KvpairContext kvpair() throws RecognitionException {
		KvpairContext _localctx = new KvpairContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_kvpair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1892);
			expression();
			setState(1893);
			match(COLON);
			setState(1894);
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
	public static class For_if_clausesContext extends ParserRuleContext {
		public List<For_if_clauseContext> for_if_clause() {
			return getRuleContexts(For_if_clauseContext.class);
		}
		public For_if_clauseContext for_if_clause(int i) {
			return getRuleContext(For_if_clauseContext.class,i);
		}
		public For_if_clausesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_if_clauses; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFor_if_clauses(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFor_if_clauses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFor_if_clauses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_if_clausesContext for_if_clauses() throws RecognitionException {
		For_if_clausesContext _localctx = new For_if_clausesContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_for_if_clauses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1897); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1896);
				for_if_clause();
				}
				}
				setState(1899); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==FOR || _la==ASYNC );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class For_if_clauseContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(PythonParser.FOR, 0); }
		public Star_targetsContext star_targets() {
			return getRuleContext(Star_targetsContext.class,0);
		}
		public TerminalNode IN() { return getToken(PythonParser.IN, 0); }
		public List<DisjunctionContext> disjunction() {
			return getRuleContexts(DisjunctionContext.class);
		}
		public DisjunctionContext disjunction(int i) {
			return getRuleContext(DisjunctionContext.class,i);
		}
		public TerminalNode ASYNC() { return getToken(PythonParser.ASYNC, 0); }
		public List<TerminalNode> IF() { return getTokens(PythonParser.IF); }
		public TerminalNode IF(int i) {
			return getToken(PythonParser.IF, i);
		}
		public For_if_clauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_if_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFor_if_clause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFor_if_clause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFor_if_clause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_if_clauseContext for_if_clause() throws RecognitionException {
		For_if_clauseContext _localctx = new For_if_clauseContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_for_if_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1902);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(1901);
				match(ASYNC);
				}
			}

			setState(1904);
			match(FOR);
			setState(1905);
			star_targets();
			setState(1906);
			match(IN);
			setState(1907);
			disjunction();
			setState(1912);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF) {
				{
				{
				setState(1908);
				match(IF);
				setState(1909);
				disjunction();
				}
				}
				setState(1914);
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
	public static class ListcompContext extends ParserRuleContext {
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public ListcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterListcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitListcomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitListcomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListcompContext listcomp() throws RecognitionException {
		ListcompContext _localctx = new ListcompContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_listcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1915);
			match(LSQB);
			setState(1916);
			named_expression();
			setState(1917);
			for_if_clauses();
			setState(1918);
			match(RSQB);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetcompContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public Named_expressionContext named_expression() {
			return getRuleContext(Named_expressionContext.class,0);
		}
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public SetcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSetcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSetcomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSetcomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetcompContext setcomp() throws RecognitionException {
		SetcompContext _localctx = new SetcompContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_setcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1920);
			match(LBRACE);
			setState(1921);
			named_expression();
			setState(1922);
			for_if_clauses();
			setState(1923);
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
	public static class GenexpContext extends ParserRuleContext {
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public GenexpContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genexp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterGenexp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitGenexp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitGenexp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenexpContext genexp() throws RecognitionException {
		GenexpContext _localctx = new GenexpContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_genexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1925);
			match(LPAR);
			setState(1928);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				{
				setState(1926);
				assignment_expression();
				}
				break;
			case 2:
				{
				setState(1927);
				expression();
				}
				break;
			}
			setState(1930);
			for_if_clauses();
			setState(1931);
			match(RPAR);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DictcompContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(PythonParser.LBRACE, 0); }
		public KvpairContext kvpair() {
			return getRuleContext(KvpairContext.class,0);
		}
		public For_if_clausesContext for_if_clauses() {
			return getRuleContext(For_if_clausesContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(PythonParser.RBRACE, 0); }
		public DictcompContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dictcomp; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDictcomp(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDictcomp(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDictcomp(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DictcompContext dictcomp() throws RecognitionException {
		DictcompContext _localctx = new DictcompContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_dictcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1933);
			match(LBRACE);
			setState(1934);
			kvpair();
			setState(1935);
			for_if_clauses();
			setState(1936);
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
	public static class ArgumentsContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1938);
			args();
			setState(1940);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1939);
				match(COMMA);
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
	public static class ArgsContext extends ParserRuleContext {
		public FirstPartOfArgsContext firstPartOfArgs() {
			return getRuleContext(FirstPartOfArgsContext.class,0);
		}
		public List<SecondPartOfArgsContext> secondPartOfArgs() {
			return getRuleContexts(SecondPartOfArgsContext.class);
		}
		public SecondPartOfArgsContext secondPartOfArgs(int i) {
			return getRuleContext(SecondPartOfArgsContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public KwargsContext kwargs() {
			return getRuleContext(KwargsContext.class,0);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_args);
		try {
			int _alt;
			setState(1954);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1942);
				firstPartOfArgs();
				setState(1946);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1943);
						secondPartOfArgs();
						}
						} 
					}
					setState(1948);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,247,_ctx);
				}
				setState(1951);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,248,_ctx) ) {
				case 1:
					{
					setState(1949);
					match(COMMA);
					setState(1950);
					kwargs();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1953);
				kwargs();
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
	public static class FirstPartOfArgsContext extends ParserRuleContext {
		public Starred_expressionContext starred_expression() {
			return getRuleContext(Starred_expressionContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FirstPartOfArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_firstPartOfArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFirstPartOfArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFirstPartOfArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFirstPartOfArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FirstPartOfArgsContext firstPartOfArgs() throws RecognitionException {
		FirstPartOfArgsContext _localctx = new FirstPartOfArgsContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_firstPartOfArgs);
		try {
			setState(1961);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1956);
				starred_expression();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(1959);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,250,_ctx) ) {
				case 1:
					{
					setState(1957);
					assignment_expression();
					}
					break;
				case 2:
					{
					setState(1958);
					expression();
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
	public static class SecondPartOfArgsContext extends ParserRuleContext {
		public TerminalNode COMMA() { return getToken(PythonParser.COMMA, 0); }
		public Starred_expressionContext starred_expression() {
			return getRuleContext(Starred_expressionContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SecondPartOfArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secondPartOfArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSecondPartOfArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSecondPartOfArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSecondPartOfArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SecondPartOfArgsContext secondPartOfArgs() throws RecognitionException {
		SecondPartOfArgsContext _localctx = new SecondPartOfArgsContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_secondPartOfArgs);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1963);
			match(COMMA);
			setState(1969);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				{
				setState(1964);
				starred_expression();
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				{
				setState(1967);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1965);
					assignment_expression();
					}
					break;
				case 2:
					{
					setState(1966);
					expression();
					}
					break;
				}
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
	public static class KwargsContext extends ParserRuleContext {
		public List<Kwarg_or_starredContext> kwarg_or_starred() {
			return getRuleContexts(Kwarg_or_starredContext.class);
		}
		public Kwarg_or_starredContext kwarg_or_starred(int i) {
			return getRuleContext(Kwarg_or_starredContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public List<Kwarg_or_double_starredContext> kwarg_or_double_starred() {
			return getRuleContexts(Kwarg_or_double_starredContext.class);
		}
		public Kwarg_or_double_starredContext kwarg_or_double_starred(int i) {
			return getRuleContext(Kwarg_or_double_starredContext.class,i);
		}
		public KwargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwargs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKwargs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KwargsContext kwargs() throws RecognitionException {
		KwargsContext _localctx = new KwargsContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_kwargs);
		try {
			int _alt;
			setState(1998);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1971);
				kwarg_or_starred();
				setState(1976);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1972);
						match(COMMA);
						setState(1973);
						kwarg_or_starred();
						}
						} 
					}
					setState(1978);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
				}
				setState(1988);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
				case 1:
					{
					setState(1979);
					match(COMMA);
					setState(1980);
					kwarg_or_double_starred();
					setState(1985);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1981);
							match(COMMA);
							setState(1982);
							kwarg_or_double_starred();
							}
							} 
						}
						setState(1987);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1990);
				kwarg_or_double_starred();
				setState(1995);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1991);
						match(COMMA);
						setState(1992);
						kwarg_or_double_starred();
						}
						} 
					}
					setState(1997);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
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
	public static class Starred_expressionContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Starred_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_starred_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStarred_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStarred_expression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStarred_expression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Starred_expressionContext starred_expression() throws RecognitionException {
		Starred_expressionContext _localctx = new Starred_expressionContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_starred_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2000);
			match(STAR);
			setState(2001);
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
	public static class Kwarg_or_starredContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Starred_expressionContext starred_expression() {
			return getRuleContext(Starred_expressionContext.class,0);
		}
		public Kwarg_or_starredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwarg_or_starred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwarg_or_starred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwarg_or_starred(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKwarg_or_starred(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Kwarg_or_starredContext kwarg_or_starred() throws RecognitionException {
		Kwarg_or_starredContext _localctx = new Kwarg_or_starredContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_kwarg_or_starred);
		try {
			setState(2008);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(2003);
				name();
				setState(2004);
				match(EQUAL);
				setState(2005);
				expression();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2007);
				starred_expression();
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
	public static class Kwarg_or_double_starredContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(PythonParser.EQUAL, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Kwarg_or_double_starredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_kwarg_or_double_starred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterKwarg_or_double_starred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitKwarg_or_double_starred(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitKwarg_or_double_starred(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Kwarg_or_double_starredContext kwarg_or_double_starred() throws RecognitionException {
		Kwarg_or_double_starredContext _localctx = new Kwarg_or_double_starredContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_kwarg_or_double_starred);
		try {
			setState(2016);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(2010);
				name();
				setState(2011);
				match(EQUAL);
				setState(2012);
				expression();
				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2014);
				match(DOUBLESTAR);
				setState(2015);
				expression();
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
	public static class Star_targetsContext extends ParserRuleContext {
		public List<Star_targetContext> star_target() {
			return getRuleContexts(Star_targetContext.class);
		}
		public Star_targetContext star_target(int i) {
			return getRuleContext(Star_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_targetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_targets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_targets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_targets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_targets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_targetsContext star_targets() throws RecognitionException {
		Star_targetsContext _localctx = new Star_targetsContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_star_targets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2018);
			star_target();
			setState(2023);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2019);
					match(COMMA);
					setState(2020);
					star_target();
					}
					} 
				}
				setState(2025);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			}
			setState(2027);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2026);
				match(COMMA);
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
	public static class Star_targets_list_seqContext extends ParserRuleContext {
		public List<Star_targetContext> star_target() {
			return getRuleContexts(Star_targetContext.class);
		}
		public Star_targetContext star_target(int i) {
			return getRuleContext(Star_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_targets_list_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_targets_list_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_targets_list_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_targets_list_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_targets_list_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_targets_list_seqContext star_targets_list_seq() throws RecognitionException {
		Star_targets_list_seqContext _localctx = new Star_targets_list_seqContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_star_targets_list_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2029);
			star_target();
			setState(2034);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2030);
					match(COMMA);
					setState(2031);
					star_target();
					}
					} 
				}
				setState(2036);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			}
			setState(2038);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2037);
				match(COMMA);
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
	public static class Star_targets_tuple_seqContext extends ParserRuleContext {
		public List<Star_targetContext> star_target() {
			return getRuleContexts(Star_targetContext.class);
		}
		public Star_targetContext star_target(int i) {
			return getRuleContext(Star_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Star_targets_tuple_seqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_targets_tuple_seq; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_targets_tuple_seq(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_targets_tuple_seq(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_targets_tuple_seq(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_targets_tuple_seqContext star_targets_tuple_seq() throws RecognitionException {
		Star_targets_tuple_seqContext _localctx = new Star_targets_tuple_seqContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_star_targets_tuple_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2040);
			star_target();
			setState(2051);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(2041);
				match(COMMA);
				}
				break;
			case 2:
				{
				setState(2044); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2042);
						match(COMMA);
						setState(2043);
						star_target();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2046); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(2049);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2048);
					match(COMMA);
					}
				}

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
	public static class Star_targetContext extends ParserRuleContext {
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public Star_targetContext star_target() {
			return getRuleContext(Star_targetContext.class,0);
		}
		public Target_with_star_atomContext target_with_star_atom() {
			return getRuleContext(Target_with_star_atomContext.class,0);
		}
		public Star_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_target(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_target(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_targetContext star_target() throws RecognitionException {
		Star_targetContext _localctx = new Star_targetContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_star_target);
		try {
			setState(2056);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2053);
				match(STAR);
				{
				setState(2054);
				star_target();
				}
				}
				break;
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case ELLIPSIS:
			case FALSE:
			case NONE:
			case TRUE:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(2055);
				target_with_star_atom();
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
	public static class Target_with_star_atomContext extends ParserRuleContext {
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Star_atomContext star_atom() {
			return getRuleContext(Star_atomContext.class,0);
		}
		public Target_with_star_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_target_with_star_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterTarget_with_star_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitTarget_with_star_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitTarget_with_star_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Target_with_star_atomContext target_with_star_atom() throws RecognitionException {
		Target_with_star_atomContext _localctx = new Target_with_star_atomContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_target_with_star_atom);
		try {
			setState(2068);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2058);
				t_primary(0);
				setState(2065);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(2059);
					match(DOT);
					setState(2060);
					name();
					}
					break;
				case LSQB:
					{
					setState(2061);
					match(LSQB);
					setState(2062);
					slices();
					setState(2063);
					match(RSQB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2067);
				star_atom();
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
	public static class Star_atomContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Target_with_star_atomContext target_with_star_atom() {
			return getRuleContext(Target_with_star_atomContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Star_targets_tuple_seqContext star_targets_tuple_seq() {
			return getRuleContext(Star_targets_tuple_seqContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Star_targets_list_seqContext star_targets_list_seq() {
			return getRuleContext(Star_targets_list_seqContext.class,0);
		}
		public Star_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_star_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterStar_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitStar_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitStar_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Star_atomContext star_atom() throws RecognitionException {
		Star_atomContext _localctx = new Star_atomContext(_ctx, getState());
		enterRule(_localctx, 376, RULE_star_atom);
		int _la;
		try {
			setState(2085);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2070);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2071);
				match(LPAR);
				setState(2072);
				target_with_star_atom();
				setState(2073);
				match(RPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2075);
				match(LPAR);
				setState(2077);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802507413280L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2076);
					star_targets_tuple_seq();
					}
				}

				setState(2079);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2080);
				match(LSQB);
				setState(2082);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802507413280L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2081);
					star_targets_list_seq();
					}
				}

				setState(2084);
				match(RSQB);
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
	public static class Single_targetContext extends ParserRuleContext {
		public Single_subscript_attribute_targetContext single_subscript_attribute_target() {
			return getRuleContext(Single_subscript_attribute_targetContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Single_targetContext single_target() {
			return getRuleContext(Single_targetContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Single_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSingle_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSingle_target(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSingle_target(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_targetContext single_target() throws RecognitionException {
		Single_targetContext _localctx = new Single_targetContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_single_target);
		try {
			setState(2093);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2087);
				single_subscript_attribute_target();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2088);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2089);
				match(LPAR);
				setState(2090);
				single_target();
				setState(2091);
				match(RPAR);
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
	public static class Single_subscript_attribute_targetContext extends ParserRuleContext {
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Single_subscript_attribute_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_subscript_attribute_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterSingle_subscript_attribute_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitSingle_subscript_attribute_target(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitSingle_subscript_attribute_target(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_subscript_attribute_targetContext single_subscript_attribute_target() throws RecognitionException {
		Single_subscript_attribute_targetContext _localctx = new Single_subscript_attribute_targetContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_single_subscript_attribute_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2095);
			t_primary(0);
			setState(2102);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(2096);
				match(DOT);
				setState(2097);
				name();
				}
				break;
			case LSQB:
				{
				setState(2098);
				match(LSQB);
				setState(2099);
				slices();
				setState(2100);
				match(RSQB);
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
	public static class T_primaryContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public GenexpContext genexp() {
			return getRuleContext(GenexpContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public T_primaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t_primary; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterT_primary(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitT_primary(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitT_primary(this);
			else return visitor.visitChildren(this);
		}
	}

	public final T_primaryContext t_primary() throws RecognitionException {
		return t_primary(0);
	}

	private T_primaryContext t_primary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		T_primaryContext _localctx = new T_primaryContext(_ctx, _parentState);
		T_primaryContext _prevctx = _localctx;
		int _startState = 382;
		enterRecursionRule(_localctx, 382, RULE_t_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2105);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(2124);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,278,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new T_primaryContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_t_primary);
					setState(2107);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(2120);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
					case 1:
						{
						setState(2108);
						match(DOT);
						setState(2109);
						name();
						}
						break;
					case 2:
						{
						setState(2110);
						match(LSQB);
						setState(2111);
						slices();
						setState(2112);
						match(RSQB);
						}
						break;
					case 3:
						{
						setState(2114);
						genexp();
						}
						break;
					case 4:
						{
						setState(2115);
						match(LPAR);
						setState(2117);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
							{
							setState(2116);
							arguments();
							}
						}

						setState(2119);
						match(RPAR);
						}
						break;
					}
					}
					} 
				}
				setState(2126);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,278,_ctx);
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
	public static class Del_targetsContext extends ParserRuleContext {
		public List<Del_targetContext> del_target() {
			return getRuleContexts(Del_targetContext.class);
		}
		public Del_targetContext del_target(int i) {
			return getRuleContext(Del_targetContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public Del_targetsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_targets; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_targets(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_targets(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDel_targets(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Del_targetsContext del_targets() throws RecognitionException {
		Del_targetsContext _localctx = new Del_targetsContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_del_targets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2127);
			del_target();
			setState(2132);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2128);
					match(COMMA);
					setState(2129);
					del_target();
					}
					} 
				}
				setState(2134);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			}
			setState(2136);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2135);
				match(COMMA);
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
	public static class Del_targetContext extends ParserRuleContext {
		public T_primaryContext t_primary() {
			return getRuleContext(T_primaryContext.class,0);
		}
		public TerminalNode DOT() { return getToken(PythonParser.DOT, 0); }
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public SlicesContext slices() {
			return getRuleContext(SlicesContext.class,0);
		}
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Del_t_atomContext del_t_atom() {
			return getRuleContext(Del_t_atomContext.class,0);
		}
		public Del_targetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_target; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_target(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_target(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDel_target(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Del_targetContext del_target() throws RecognitionException {
		Del_targetContext _localctx = new Del_targetContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_del_target);
		try {
			setState(2148);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,282,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2138);
				t_primary(0);
				setState(2145);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(2139);
					match(DOT);
					setState(2140);
					name();
					}
					break;
				case LSQB:
					{
					setState(2141);
					match(LSQB);
					setState(2142);
					slices();
					setState(2143);
					match(RSQB);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2147);
				del_t_atom();
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
	public static class Del_t_atomContext extends ParserRuleContext {
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public TerminalNode LPAR() { return getToken(PythonParser.LPAR, 0); }
		public Del_targetContext del_target() {
			return getRuleContext(Del_targetContext.class,0);
		}
		public TerminalNode RPAR() { return getToken(PythonParser.RPAR, 0); }
		public Del_targetsContext del_targets() {
			return getRuleContext(Del_targetsContext.class,0);
		}
		public TerminalNode LSQB() { return getToken(PythonParser.LSQB, 0); }
		public TerminalNode RSQB() { return getToken(PythonParser.RSQB, 0); }
		public Del_t_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_del_t_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterDel_t_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitDel_t_atom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitDel_t_atom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Del_t_atomContext del_t_atom() throws RecognitionException {
		Del_t_atomContext _localctx = new Del_t_atomContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_del_t_atom);
		int _la;
		try {
			setState(2165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2150);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2151);
				match(LPAR);
				setState(2152);
				del_target();
				setState(2153);
				match(RPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2155);
				match(LPAR);
				setState(2157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802506364704L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2156);
					del_targets();
					}
				}

				setState(2159);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2160);
				match(LSQB);
				setState(2162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802506364704L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2161);
					del_targets();
					}
				}

				setState(2164);
				match(RSQB);
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
	public static class Type_expressionsContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(PythonParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(PythonParser.COMMA, i);
		}
		public TerminalNode STAR() { return getToken(PythonParser.STAR, 0); }
		public TerminalNode DOUBLESTAR() { return getToken(PythonParser.DOUBLESTAR, 0); }
		public Type_expressionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_expressions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterType_expressions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitType_expressions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitType_expressions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Type_expressionsContext type_expressions() throws RecognitionException {
		Type_expressionsContext _localctx = new Type_expressionsContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_type_expressions);
		int _la;
		try {
			int _alt;
			setState(2198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_START:
			case LPAR:
			case LSQB:
			case LBRACE:
			case PLUS:
			case MINUS:
			case TILDE:
			case ELLIPSIS:
			case FALSE:
			case AWAIT:
			case NONE:
			case TRUE:
			case LAMBDA:
			case NOT:
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
			case NUMBER:
			case STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(2167);
				expression();
				setState(2172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2168);
						match(COMMA);
						setState(2169);
						expression();
						}
						} 
					}
					setState(2174);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				}
				setState(2187);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2175);
					match(COMMA);
					setState(2185);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STAR:
						{
						setState(2176);
						match(STAR);
						setState(2177);
						expression();
						setState(2181);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2178);
							match(COMMA);
							setState(2179);
							match(DOUBLESTAR);
							setState(2180);
							expression();
							}
						}

						}
						break;
					case DOUBLESTAR:
						{
						setState(2183);
						match(DOUBLESTAR);
						setState(2184);
						expression();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2189);
				match(STAR);
				setState(2190);
				expression();
				setState(2194);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2191);
					match(COMMA);
					setState(2192);
					match(DOUBLESTAR);
					setState(2193);
					expression();
					}
				}

				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(2196);
				match(DOUBLESTAR);
				setState(2197);
				expression();
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
	public static class Func_type_commentContext extends ParserRuleContext {
		public TerminalNode NEWLINE() { return getToken(PythonParser.NEWLINE, 0); }
		public TerminalNode TYPE_COMMENT() { return getToken(PythonParser.TYPE_COMMENT, 0); }
		public Func_type_commentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_type_comment; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterFunc_type_comment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitFunc_type_comment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitFunc_type_comment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_type_commentContext func_type_comment() throws RecognitionException {
		Func_type_commentContext _localctx = new Func_type_commentContext(_ctx, getState());
		enterRule(_localctx, 392, RULE_func_type_comment);
		try {
			setState(2203);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2200);
				match(NEWLINE);
				setState(2201);
				match(TYPE_COMMENT);
				}
				break;
			case TYPE_COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2202);
				match(TYPE_COMMENT);
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
	public static class Name_except_underscoreContext extends ParserRuleContext {
		public TerminalNode NAME() { return getToken(PythonParser.NAME, 0); }
		public TerminalNode NAME_OR_TYPE() { return getToken(PythonParser.NAME_OR_TYPE, 0); }
		public TerminalNode NAME_OR_MATCH() { return getToken(PythonParser.NAME_OR_MATCH, 0); }
		public TerminalNode NAME_OR_CASE() { return getToken(PythonParser.NAME_OR_CASE, 0); }
		public Name_except_underscoreContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name_except_underscore; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName_except_underscore(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName_except_underscore(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitName_except_underscore(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Name_except_underscoreContext name_except_underscore() throws RecognitionException {
		Name_except_underscoreContext _localctx = new Name_except_underscoreContext(_ctx, getState());
		enterRule(_localctx, 394, RULE_name_except_underscore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2205);
			_la = _input.LA(1);
			if ( !(((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 23L) != 0)) ) {
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
	public static class NameContext extends ParserRuleContext {
		public TerminalNode NAME_OR_WILDCARD() { return getToken(PythonParser.NAME_OR_WILDCARD, 0); }
		public Name_except_underscoreContext name_except_underscore() {
			return getRuleContext(Name_except_underscoreContext.class,0);
		}
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof PythonParserListener ) ((PythonParserListener)listener).exitName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof PythonParserVisitor ) return ((PythonParserVisitor<? extends T>)visitor).visitName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 396, RULE_name);
		try {
			setState(2209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_WILDCARD:
				enterOuterAlt(_localctx, 1);
				{
				setState(2207);
				match(NAME_OR_WILDCARD);
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2208);
				name_except_underscore();
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 28:
			return dotted_name_sempred((Dotted_nameContext)_localctx, predIndex);
		case 128:
			return bitwise_or_sempred((Bitwise_orContext)_localctx, predIndex);
		case 129:
			return bitwise_xor_sempred((Bitwise_xorContext)_localctx, predIndex);
		case 130:
			return bitwise_and_sempred((Bitwise_andContext)_localctx, predIndex);
		case 131:
			return shift_expr_sempred((Shift_exprContext)_localctx, predIndex);
		case 132:
			return sum_sempred((SumContext)_localctx, predIndex);
		case 133:
			return term_sempred((TermContext)_localctx, predIndex);
		case 137:
			return primary_sempred((PrimaryContext)_localctx, predIndex);
		case 191:
			return t_primary_sempred((T_primaryContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean dotted_name_sempred(Dotted_nameContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_or_sempred(Bitwise_orContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_xor_sempred(Bitwise_xorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean bitwise_and_sempred(Bitwise_andContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean shift_expr_sempred(Shift_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean sum_sempred(SumContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean primary_sempred(PrimaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean t_primary_sempred(T_primaryContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001f\u08a4\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0002\u00c6\u0007\u00c6\u0001\u0000\u0003\u0000\u0190\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u0198\b\u0002\n\u0002\f\u0002\u019b\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u01a1\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u01a7\b\u0003\n\u0003\f\u0003\u01aa\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004\u01af\b\u0004\u000b\u0004"+
		"\f\u0004\u01b0\u0001\u0005\u0001\u0005\u0003\u0005\u01b5\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u01bd\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u01c2"+
		"\b\u0007\n\u0007\f\u0007\u01c5\t\u0007\u0001\u0007\u0003\u0007\u01c8\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u01da\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u01e4\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u01eb\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u01f2\b\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u01f8\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u01fd\b\n\u000b\n\f\n\u01fe\u0001\n\u0001\n\u0003\n\u0203\b"+
		"\n\u0001\n\u0003\n\u0206\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u020c"+
		"\b\n\u0003\n\u020e\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u0212\b\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u0218\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u021e\b\u000e\u0003\u000e\u0220\b"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0226"+
		"\b\u000f\n\u000f\f\u000f\u0229\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u022f\b\u0010\n\u0010\f\u0010\u0232\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u023d\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u0241\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u0248\b\u0016\n\u0016\f\u0016\u024b\t\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0004\u0016\u0253\b\u0016\u000b\u0016\f\u0016\u0254\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0259\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u025e\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u0264\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0269"+
		"\b\u0018\n\u0018\f\u0018\u026c\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u0271\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a"+
		"\u0276\b\u001a\n\u001a\f\u001a\u0279\t\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u027e\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0286\b\u001c\n\u001c\f\u001c"+
		"\u0289\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u0291\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0004\u001e\u0297\b\u001e\u000b\u001e\f\u001e\u0298\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u029f\b\u001f\u0001"+
		" \u0001 \u0001 \u0003 \u02a4\b \u0001 \u0001 \u0003 \u02a8\b \u0001 \u0003"+
		" \u02ab\b \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0003!\u02b4"+
		"\b!\u0001\"\u0001\"\u0001\"\u0003\"\u02b9\b\"\u0001\"\u0001\"\u0003\""+
		"\u02bd\b\"\u0001\"\u0001\"\u0001\"\u0003\"\u02c2\b\"\u0001\"\u0001\"\u0003"+
		"\"\u02c6\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u02ce"+
		"\b\"\u0001\"\u0001\"\u0003\"\u02d2\b\"\u0001\"\u0001\"\u0001\"\u0003\""+
		"\u02d7\b\"\u0001\"\u0001\"\u0003\"\u02db\b\"\u0001\"\u0001\"\u0003\"\u02df"+
		"\b\"\u0001#\u0001#\u0001$\u0001$\u0005$\u02e5\b$\n$\f$\u02e8\t$\u0001"+
		"$\u0005$\u02eb\b$\n$\f$\u02ee\t$\u0001$\u0003$\u02f1\b$\u0001$\u0001$"+
		"\u0005$\u02f5\b$\n$\f$\u02f8\t$\u0001$\u0003$\u02fb\b$\u0001$\u0004$\u02fe"+
		"\b$\u000b$\f$\u02ff\u0001$\u0005$\u0303\b$\n$\f$\u0306\t$\u0001$\u0003"+
		"$\u0309\b$\u0001$\u0004$\u030c\b$\u000b$\f$\u030d\u0001$\u0003$\u0311"+
		"\b$\u0001$\u0003$\u0314\b$\u0001%\u0004%\u0317\b%\u000b%\f%\u0318\u0001"+
		"%\u0001%\u0003%\u031d\b%\u0001&\u0005&\u0320\b&\n&\f&\u0323\t&\u0001&"+
		"\u0004&\u0326\b&\u000b&\f&\u0327\u0001&\u0001&\u0003&\u032c\b&\u0001\'"+
		"\u0001\'\u0001\'\u0005\'\u0331\b\'\n\'\f\'\u0334\t\'\u0001\'\u0003\'\u0337"+
		"\b\'\u0001\'\u0001\'\u0001\'\u0005\'\u033c\b\'\n\'\f\'\u033f\t\'\u0001"+
		"\'\u0003\'\u0342\b\'\u0001\'\u0001\'\u0001\'\u0004\'\u0347\b\'\u000b\'"+
		"\f\'\u0348\u0001\'\u0003\'\u034c\b\'\u0001\'\u0003\'\u034f\b\'\u0001("+
		"\u0001(\u0001(\u0001)\u0001)\u0003)\u0356\b)\u0001)\u0003)\u0359\b)\u0001"+
		"*\u0001*\u0003*\u035d\b*\u0001*\u0003*\u0360\b*\u0001+\u0001+\u0001+\u0003"+
		"+\u0365\b+\u0001+\u0003+\u0368\b+\u0001,\u0001,\u0003,\u036c\b,\u0001"+
		",\u0003,\u036f\b,\u0001,\u0003,\u0372\b,\u0001-\u0001-\u0003-\u0376\b"+
		"-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00010\u0001"+
		"1\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u038a"+
		"\b2\u00032\u038c\b2\u00013\u00013\u00013\u00013\u00013\u00013\u00033\u0394"+
		"\b3\u00033\u0396\b3\u00014\u00014\u00014\u00014\u00015\u00015\u00015\u0001"+
		"5\u00015\u00035\u03a1\b5\u00016\u00036\u03a4\b6\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00036\u03ac\b6\u00016\u00016\u00036\u03b0\b6\u00017\u0001"+
		"7\u00017\u00017\u00017\u00057\u03b7\b7\n7\f7\u03ba\t7\u00017\u00037\u03bd"+
		"\b7\u00017\u00017\u00017\u00037\u03c2\b7\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00057\u03cc\b7\n7\f7\u03cf\t7\u00017\u00037\u03d2"+
		"\b7\u00017\u00017\u00017\u00017\u00017\u00037\u03d9\b7\u00017\u00017\u0001"+
		"7\u00017\u00057\u03df\b7\n7\f7\u03e2\t7\u00017\u00017\u00037\u03e6\b7"+
		"\u00017\u00017\u00037\u03ea\b7\u00018\u00018\u00018\u00038\u03ef\b8\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00049\u03fa"+
		"\b9\u000b9\f9\u03fb\u00019\u00039\u03ff\b9\u00019\u00039\u0402\b9\u0001"+
		"9\u00019\u00019\u00019\u00049\u0408\b9\u000b9\f9\u0409\u00019\u00039\u040d"+
		"\b9\u00019\u00039\u0410\b9\u00039\u0412\b9\u0001:\u0001:\u0001:\u0001"+
		":\u0003:\u0418\b:\u0003:\u041a\b:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0003;\u0424\b;\u0001;\u0001;\u0001;\u0001<\u0001<\u0001"+
		"<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0004=\u0433\b=\u000b"+
		"=\f=\u0434\u0001=\u0001=\u0001>\u0001>\u0001>\u0003>\u043c\b>\u0001>\u0003"+
		">\u043f\b>\u0001?\u0001?\u0001?\u0003?\u0444\b?\u0001?\u0001?\u0001?\u0001"+
		"@\u0001@\u0001@\u0001A\u0001A\u0003A\u044e\bA\u0001B\u0001B\u0003B\u0452"+
		"\bB\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0005D\u045b\bD\n"+
		"D\fD\u045e\tD\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E"+
		"\u0003E\u0468\bE\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0003F\u0470"+
		"\bF\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0003G\u0478\bG\u0001H\u0001"+
		"H\u0001H\u0001H\u0001I\u0003I\u047f\bI\u0001I\u0001I\u0001J\u0003J\u0484"+
		"\bJ\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001M\u0001M\u0001N\u0001"+
		"N\u0001O\u0001O\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0004Q\u0497\bQ\u000b"+
		"Q\fQ\u0498\u0001R\u0001R\u0001R\u0005R\u049e\bR\nR\fR\u04a1\tR\u0001S"+
		"\u0001S\u0001S\u0001S\u0001T\u0001T\u0003T\u04a9\bT\u0001T\u0001T\u0001"+
		"T\u0003T\u04ae\bT\u0001T\u0003T\u04b1\bT\u0001U\u0001U\u0001U\u0003U\u04b6"+
		"\bU\u0001V\u0001V\u0001V\u0005V\u04bb\bV\nV\fV\u04be\tV\u0001V\u0003V"+
		"\u04c1\bV\u0001W\u0001W\u0003W\u04c5\bW\u0001X\u0001X\u0001X\u0001Y\u0001"+
		"Y\u0001Y\u0001Y\u0001Y\u0003Y\u04cf\bY\u0001Y\u0001Y\u0001Y\u0001Y\u0001"+
		"Y\u0001Y\u0003Y\u04d7\bY\u0001Y\u0003Y\u04da\bY\u0001Y\u0001Y\u0003Y\u04de"+
		"\bY\u0001Z\u0001Z\u0001Z\u0005Z\u04e3\bZ\nZ\fZ\u04e6\tZ\u0001[\u0001["+
		"\u0003[\u04ea\b[\u0001[\u0001[\u0001[\u0001\\\u0001\\\u0001\\\u0001]\u0001"+
		"]\u0001]\u0001]\u0001]\u0003]\u04f7\b]\u0001]\u0003]\u04fa\b]\u0001]\u0003"+
		"]\u04fd\b]\u0003]\u04ff\b]\u0001]\u0001]\u0001^\u0001^\u0001^\u0005^\u0506"+
		"\b^\n^\f^\u0509\t^\u0001_\u0001_\u0001_\u0005_\u050e\b_\n_\f_\u0511\t"+
		"_\u0001`\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0003a\u051a\ba\u0001"+
		"a\u0001a\u0001a\u0001b\u0001b\u0001b\u0001b\u0001c\u0001c\u0001c\u0005"+
		"c\u0526\bc\nc\fc\u0529\tc\u0001c\u0003c\u052c\bc\u0001d\u0001d\u0003d"+
		"\u0530\bd\u0001d\u0003d\u0533\bd\u0001d\u0001d\u0001d\u0003d\u0538\bd"+
		"\u0001d\u0001d\u0001d\u0003d\u053d\bd\u0003d\u053f\bd\u0001e\u0001e\u0001"+
		"e\u0001f\u0001f\u0001f\u0001g\u0001g\u0001g\u0001h\u0001h\u0001h\u0005"+
		"h\u054d\bh\nh\fh\u0550\th\u0001h\u0003h\u0553\bh\u0001i\u0001i\u0001i"+
		"\u0001i\u0001i\u0001i\u0003i\u055b\bi\u0001i\u0003i\u055e\bi\u0001j\u0001"+
		"j\u0001j\u0001j\u0003j\u0564\bj\u0003j\u0566\bj\u0001k\u0001k\u0001k\u0005"+
		"k\u056b\bk\nk\fk\u056e\tk\u0001k\u0003k\u0571\bk\u0001l\u0001l\u0001l"+
		"\u0003l\u0576\bl\u0001m\u0001m\u0001m\u0005m\u057b\bm\nm\fm\u057e\tm\u0001"+
		"m\u0003m\u0581\bm\u0001n\u0001n\u0001n\u0003n\u0586\bn\u0001o\u0001o\u0001"+
		"o\u0001o\u0001p\u0001p\u0003p\u058e\bp\u0001q\u0001q\u0001q\u0005q\u0593"+
		"\bq\nq\fq\u0596\tq\u0001r\u0001r\u0001r\u0005r\u059b\br\nr\fr\u059e\t"+
		"r\u0001s\u0001s\u0001s\u0003s\u05a3\bs\u0001t\u0001t\u0005t\u05a7\bt\n"+
		"t\ft\u05aa\tt\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u"+
		"\u0001u\u0001u\u0003u\u05b6\bu\u0001v\u0001v\u0001v\u0001w\u0001w\u0001"+
		"w\u0001x\u0001x\u0001x\u0001y\u0001y\u0001y\u0001z\u0001z\u0001z\u0001"+
		"{\u0001{\u0001{\u0001|\u0001|\u0001|\u0001|\u0001}\u0001}\u0001}\u0001"+
		"~\u0001~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u0080"+
		"\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0005\u0080"+
		"\u05de\b\u0080\n\u0080\f\u0080\u05e1\t\u0080\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0005\u0081\u05e9\b\u0081\n"+
		"\u0081\f\u0081\u05ec\t\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0001"+
		"\u0082\u0001\u0082\u0001\u0082\u0005\u0082\u05f4\b\u0082\n\u0082\f\u0082"+
		"\u05f7\t\u0082\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083"+
		"\u0001\u0083\u0005\u0083\u05ff\b\u0083\n\u0083\f\u0083\u0602\t\u0083\u0001"+
		"\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0005"+
		"\u0084\u060a\b\u0084\n\u0084\f\u0084\u060d\t\u0084\u0001\u0085\u0001\u0085"+
		"\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0005\u0085\u0615\b\u0085"+
		"\n\u0085\f\u0085\u0618\t\u0085\u0001\u0086\u0001\u0086\u0001\u0086\u0001"+
		"\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0003\u0086\u0621\b\u0086\u0001"+
		"\u0087\u0001\u0087\u0001\u0087\u0003\u0087\u0626\b\u0087\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0003\u0088\u062b\b\u0088\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0003\u0089\u0636\b\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0001\u0089\u0003\u0089\u063d\b\u0089\u0005\u0089\u063f\b\u0089"+
		"\n\u0089\f\u0089\u0642\t\u0089\u0001\u008a\u0001\u008a\u0001\u008a\u0003"+
		"\u008a\u0647\b\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0003\u008a\u064c"+
		"\b\u008a\u0005\u008a\u064e\b\u008a\n\u008a\f\u008a\u0651\t\u008a\u0001"+
		"\u008a\u0003\u008a\u0654\b\u008a\u0003\u008a\u0656\b\u008a\u0001\u008b"+
		"\u0003\u008b\u0659\b\u008b\u0001\u008b\u0001\u008b\u0003\u008b\u065d\b"+
		"\u008b\u0001\u008b\u0001\u008b\u0003\u008b\u0661\b\u008b\u0003\u008b\u0663"+
		"\b\u008b\u0001\u008b\u0003\u008b\u0666\b\u008b\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0003\u008c\u0671\b\u008c\u0001\u008c\u0001\u008c\u0003\u008c"+
		"\u0675\b\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0003\u008c"+
		"\u067b\b\u008c\u0001\u008c\u0003\u008c\u067e\b\u008c\u0001\u008d\u0001"+
		"\u008d\u0001\u008d\u0003\u008d\u0683\b\u008d\u0001\u008d\u0001\u008d\u0001"+
		"\u008e\u0001\u008e\u0003\u008e\u0689\b\u008e\u0001\u008e\u0001\u008e\u0001"+
		"\u008e\u0001\u008f\u0001\u008f\u0001\u0090\u0001\u0090\u0005\u0090\u0692"+
		"\b\u0090\n\u0090\f\u0090\u0695\t\u0090\u0001\u0090\u0005\u0090\u0698\b"+
		"\u0090\n\u0090\f\u0090\u069b\t\u0090\u0001\u0090\u0003\u0090\u069e\b\u0090"+
		"\u0001\u0090\u0001\u0090\u0005\u0090\u06a2\b\u0090\n\u0090\f\u0090\u06a5"+
		"\t\u0090\u0001\u0090\u0003\u0090\u06a8\b\u0090\u0001\u0090\u0004\u0090"+
		"\u06ab\b\u0090\u000b\u0090\f\u0090\u06ac\u0001\u0090\u0005\u0090\u06b0"+
		"\b\u0090\n\u0090\f\u0090\u06b3\t\u0090\u0001\u0090\u0003\u0090\u06b6\b"+
		"\u0090\u0001\u0090\u0004\u0090\u06b9\b\u0090\u000b\u0090\f\u0090\u06ba"+
		"\u0001\u0090\u0003\u0090\u06be\b\u0090\u0001\u0090\u0003\u0090\u06c1\b"+
		"\u0090\u0001\u0091\u0004\u0091\u06c4\b\u0091\u000b\u0091\f\u0091\u06c5"+
		"\u0001\u0091\u0001\u0091\u0003\u0091\u06ca\b\u0091\u0001\u0092\u0005\u0092"+
		"\u06cd\b\u0092\n\u0092\f\u0092\u06d0\t\u0092\u0001\u0092\u0004\u0092\u06d3"+
		"\b\u0092\u000b\u0092\f\u0092\u06d4\u0001\u0092\u0001\u0092\u0003\u0092"+
		"\u06d9\b\u0092\u0001\u0093\u0001\u0093\u0001\u0093\u0005\u0093\u06de\b"+
		"\u0093\n\u0093\f\u0093\u06e1\t\u0093\u0001\u0093\u0003\u0093\u06e4\b\u0093"+
		"\u0001\u0093\u0001\u0093\u0001\u0093\u0004\u0093\u06e9\b\u0093\u000b\u0093"+
		"\f\u0093\u06ea\u0001\u0093\u0003\u0093\u06ee\b\u0093\u0001\u0093\u0003"+
		"\u0093\u06f1\b\u0093\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0095\u0001"+
		"\u0095\u0003\u0095\u06f8\b\u0095\u0001\u0096\u0001\u0096\u0001\u0096\u0003"+
		"\u0096\u06fd\b\u0096\u0001\u0097\u0001\u0097\u0003\u0097\u0701\b\u0097"+
		"\u0001\u0097\u0003\u0097\u0704\b\u0097\u0001\u0098\u0001\u0098\u0001\u0099"+
		"\u0001\u0099\u0003\u0099\u070a\b\u0099\u0001\u009a\u0001\u009a\u0001\u009a"+
		"\u0003\u009a\u070f\b\u009a\u0001\u009a\u0003\u009a\u0712\b\u009a\u0001"+
		"\u009a\u0003\u009a\u0715\b\u009a\u0001\u009a\u0001\u009a\u0001\u009b\u0001"+
		"\u009b\u0001\u009b\u0001\u009c\u0001\u009c\u0005\u009c\u071e\b\u009c\n"+
		"\u009c\f\u009c\u0721\t\u009c\u0001\u009d\u0001\u009d\u0003\u009d\u0725"+
		"\b\u009d\u0001\u009e\u0001\u009e\u0005\u009e\u0729\b\u009e\n\u009e\f\u009e"+
		"\u072c\t\u009e\u0001\u009e\u0001\u009e\u0001\u009f\u0001\u009f\u0001\u00a0"+
		"\u0004\u00a0\u0733\b\u00a0\u000b\u00a0\f\u00a0\u0734\u0001\u00a1\u0001"+
		"\u00a1\u0003\u00a1\u0739\b\u00a1\u0001\u00a2\u0001\u00a2\u0003\u00a2\u073d"+
		"\b\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a3\u0001\u00a3\u0001\u00a3\u0001"+
		"\u00a3\u0003\u00a3\u0745\b\u00a3\u0003\u00a3\u0747\b\u00a3\u0001\u00a3"+
		"\u0001\u00a3\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a4\u0001\u00a5"+
		"\u0001\u00a5\u0003\u00a5\u0751\b\u00a5\u0001\u00a5\u0001\u00a5\u0001\u00a6"+
		"\u0001\u00a6\u0001\u00a6\u0005\u00a6\u0758\b\u00a6\n\u00a6\f\u00a6\u075b"+
		"\t\u00a6\u0001\u00a6\u0003\u00a6\u075e\b\u00a6\u0001\u00a7\u0001\u00a7"+
		"\u0001\u00a7\u0003\u00a7\u0763\b\u00a7\u0001\u00a8\u0001\u00a8\u0001\u00a8"+
		"\u0001\u00a8\u0001\u00a9\u0004\u00a9\u076a\b\u00a9\u000b\u00a9\f\u00a9"+
		"\u076b\u0001\u00aa\u0003\u00aa\u076f\b\u00aa\u0001\u00aa\u0001\u00aa\u0001"+
		"\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0005\u00aa\u0777\b\u00aa\n"+
		"\u00aa\f\u00aa\u077a\t\u00aa\u0001\u00ab\u0001\u00ab\u0001\u00ab\u0001"+
		"\u00ab\u0001\u00ab\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001"+
		"\u00ac\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0003\u00ad\u0789\b\u00ad\u0001"+
		"\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ae\u0001\u00ae\u0001\u00ae\u0001"+
		"\u00ae\u0001\u00ae\u0001\u00af\u0001\u00af\u0003\u00af\u0795\b\u00af\u0001"+
		"\u00b0\u0001\u00b0\u0005\u00b0\u0799\b\u00b0\n\u00b0\f\u00b0\u079c\t\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0003\u00b0\u07a0\b\u00b0\u0001\u00b0\u0003\u00b0"+
		"\u07a3\b\u00b0\u0001\u00b1\u0001\u00b1\u0001\u00b1\u0003\u00b1\u07a8\b"+
		"\u00b1\u0003\u00b1\u07aa\b\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001"+
		"\u00b2\u0003\u00b2\u07b0\b\u00b2\u0003\u00b2\u07b2\b\u00b2\u0001\u00b3"+
		"\u0001\u00b3\u0001\u00b3\u0005\u00b3\u07b7\b\u00b3\n\u00b3\f\u00b3\u07ba"+
		"\t\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0005\u00b3\u07c0"+
		"\b\u00b3\n\u00b3\f\u00b3\u07c3\t\u00b3\u0003\u00b3\u07c5\b\u00b3\u0001"+
		"\u00b3\u0001\u00b3\u0001\u00b3\u0005\u00b3\u07ca\b\u00b3\n\u00b3\f\u00b3"+
		"\u07cd\t\u00b3\u0003\u00b3\u07cf\b\u00b3\u0001\u00b4\u0001\u00b4\u0001"+
		"\u00b4\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0003"+
		"\u00b5\u07d9\b\u00b5\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001"+
		"\u00b6\u0001\u00b6\u0003\u00b6\u07e1\b\u00b6\u0001\u00b7\u0001\u00b7\u0001"+
		"\u00b7\u0005\u00b7\u07e6\b\u00b7\n\u00b7\f\u00b7\u07e9\t\u00b7\u0001\u00b7"+
		"\u0003\u00b7\u07ec\b\u00b7\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0005\u00b8"+
		"\u07f1\b\u00b8\n\u00b8\f\u00b8\u07f4\t\u00b8\u0001\u00b8\u0003\u00b8\u07f7"+
		"\b\u00b8\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0004\u00b9\u07fd"+
		"\b\u00b9\u000b\u00b9\f\u00b9\u07fe\u0001\u00b9\u0003\u00b9\u0802\b\u00b9"+
		"\u0003\u00b9\u0804\b\u00b9\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0003\u00ba"+
		"\u0809\b\u00ba\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb"+
		"\u0001\u00bb\u0001\u00bb\u0003\u00bb\u0812\b\u00bb\u0001\u00bb\u0003\u00bb"+
		"\u0815\b\u00bb\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc"+
		"\u0001\u00bc\u0001\u00bc\u0003\u00bc\u081e\b\u00bc\u0001\u00bc\u0001\u00bc"+
		"\u0001\u00bc\u0003\u00bc\u0823\b\u00bc\u0001\u00bc\u0003\u00bc\u0826\b"+
		"\u00bc\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001\u00bd\u0001"+
		"\u00bd\u0003\u00bd\u082e\b\u00bd\u0001\u00be\u0001\u00be\u0001\u00be\u0001"+
		"\u00be\u0001\u00be\u0001\u00be\u0001\u00be\u0003\u00be\u0837\b\u00be\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001"+
		"\u00bf\u0003\u00bf\u0846\b\u00bf\u0001\u00bf\u0003\u00bf\u0849\b\u00bf"+
		"\u0005\u00bf\u084b\b\u00bf\n\u00bf\f\u00bf\u084e\t\u00bf\u0001\u00c0\u0001"+
		"\u00c0\u0001\u00c0\u0005\u00c0\u0853\b\u00c0\n\u00c0\f\u00c0\u0856\t\u00c0"+
		"\u0001\u00c0\u0003\u00c0\u0859\b\u00c0\u0001\u00c1\u0001\u00c1\u0001\u00c1"+
		"\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0003\u00c1\u0862\b\u00c1"+
		"\u0001\u00c1\u0003\u00c1\u0865\b\u00c1\u0001\u00c2\u0001\u00c2\u0001\u00c2"+
		"\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0003\u00c2\u086e\b\u00c2"+
		"\u0001\u00c2\u0001\u00c2\u0001\u00c2\u0003\u00c2\u0873\b\u00c2\u0001\u00c2"+
		"\u0003\u00c2\u0876\b\u00c2\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0005\u00c3"+
		"\u087b\b\u00c3\n\u00c3\f\u00c3\u087e\t\u00c3\u0001\u00c3\u0001\u00c3\u0001"+
		"\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0003\u00c3\u0886\b\u00c3\u0001"+
		"\u00c3\u0001\u00c3\u0003\u00c3\u088a\b\u00c3\u0003\u00c3\u088c\b\u00c3"+
		"\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0001\u00c3\u0003\u00c3"+
		"\u0893\b\u00c3\u0001\u00c3\u0001\u00c3\u0003\u00c3\u0897\b\u00c3\u0001"+
		"\u00c4\u0001\u00c4\u0001\u00c4\u0003\u00c4\u089c\b\u00c4\u0001\u00c5\u0001"+
		"\u00c5\u0001\u00c6\u0001\u00c6\u0003\u00c6\u08a2\b\u00c6\u0001\u00c6\u0000"+
		"\t8\u0100\u0102\u0104\u0106\u0108\u010a\u0112\u017e\u00c7\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe"+
		"\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116"+
		"\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u012c\u012e"+
		"\u0130\u0132\u0134\u0136\u0138\u013a\u013c\u013e\u0140\u0142\u0144\u0146"+
		"\u0148\u014a\u014c\u014e\u0150\u0152\u0154\u0156\u0158\u015a\u015c\u015e"+
		"\u0160\u0162\u0164\u0166\u0168\u016a\u016c\u016e\u0170\u0172\u0174\u0176"+
		"\u0178\u017a\u017c\u017e\u0180\u0182\u0184\u0186\u0188\u018a\u018c\u0000"+
		"\u0006\u0003\u0000%/1133\u0002\u0000\u000e\u000e55\u0001\u0000\u0012\u0013"+
		"\u0001\u0000\"#\u0004\u0000\u0014\u0015\u001b\u001b0022\u0002\u0000[]"+
		"__\u0953\u0000\u018f\u0001\u0000\u0000\u0000\u0002\u0193\u0001\u0000\u0000"+
		"\u0000\u0004\u0195\u0001\u0000\u0000\u0000\u0006\u019e\u0001\u0000\u0000"+
		"\u0000\b\u01ae\u0001\u0000\u0000\u0000\n\u01b4\u0001\u0000\u0000\u0000"+
		"\f\u01bc\u0001\u0000\u0000\u0000\u000e\u01be\u0001\u0000\u0000\u0000\u0010"+
		"\u01d9\u0001\u0000\u0000\u0000\u0012\u01e3\u0001\u0000\u0000\u0000\u0014"+
		"\u020d\u0001\u0000\u0000\u0000\u0016\u0211\u0001\u0000\u0000\u0000\u0018"+
		"\u0213\u0001\u0000\u0000\u0000\u001a\u0215\u0001\u0000\u0000\u0000\u001c"+
		"\u0219\u0001\u0000\u0000\u0000\u001e\u0221\u0001\u0000\u0000\u0000 \u022a"+
		"\u0001\u0000\u0000\u0000\"\u0233\u0001\u0000\u0000\u0000$\u0236\u0001"+
		"\u0000\u0000\u0000&\u0238\u0001\u0000\u0000\u0000(\u0240\u0001\u0000\u0000"+
		"\u0000*\u0242\u0001\u0000\u0000\u0000,\u0258\u0001\u0000\u0000\u0000."+
		"\u0263\u0001\u0000\u0000\u00000\u0265\u0001\u0000\u0000\u00002\u026d\u0001"+
		"\u0000\u0000\u00004\u0272\u0001\u0000\u0000\u00006\u027a\u0001\u0000\u0000"+
		"\u00008\u027f\u0001\u0000\u0000\u0000:\u0290\u0001\u0000\u0000\u0000<"+
		"\u0296\u0001\u0000\u0000\u0000>\u029e\u0001\u0000\u0000\u0000@\u02a0\u0001"+
		"\u0000\u0000\u0000B\u02b3\u0001\u0000\u0000\u0000D\u02de\u0001\u0000\u0000"+
		"\u0000F\u02e0\u0001\u0000\u0000\u0000H\u0313\u0001\u0000\u0000\u0000J"+
		"\u0316\u0001\u0000\u0000\u0000L\u0321\u0001\u0000\u0000\u0000N\u034e\u0001"+
		"\u0000\u0000\u0000P\u0350\u0001\u0000\u0000\u0000R\u0353\u0001\u0000\u0000"+
		"\u0000T\u035a\u0001\u0000\u0000\u0000V\u0361\u0001\u0000\u0000\u0000X"+
		"\u0369\u0001\u0000\u0000\u0000Z\u0373\u0001\u0000\u0000\u0000\\\u0377"+
		"\u0001\u0000\u0000\u0000^\u037a\u0001\u0000\u0000\u0000`\u037d\u0001\u0000"+
		"\u0000\u0000b\u0380\u0001\u0000\u0000\u0000d\u0383\u0001\u0000\u0000\u0000"+
		"f\u038d\u0001\u0000\u0000\u0000h\u0397\u0001\u0000\u0000\u0000j\u039b"+
		"\u0001\u0000\u0000\u0000l\u03a3\u0001\u0000\u0000\u0000n\u03e9\u0001\u0000"+
		"\u0000\u0000p\u03eb\u0001\u0000\u0000\u0000r\u0411\u0001\u0000\u0000\u0000"+
		"t\u0413\u0001\u0000\u0000\u0000v\u041e\u0001\u0000\u0000\u0000x\u0428"+
		"\u0001\u0000\u0000\u0000z\u042c\u0001\u0000\u0000\u0000|\u043e\u0001\u0000"+
		"\u0000\u0000~\u0440\u0001\u0000\u0000\u0000\u0080\u0448\u0001\u0000\u0000"+
		"\u0000\u0082\u044d\u0001\u0000\u0000\u0000\u0084\u0451\u0001\u0000\u0000"+
		"\u0000\u0086\u0453\u0001\u0000\u0000\u0000\u0088\u0457\u0001\u0000\u0000"+
		"\u0000\u008a\u0467\u0001\u0000\u0000\u0000\u008c\u046f\u0001\u0000\u0000"+
		"\u0000\u008e\u0477\u0001\u0000\u0000\u0000\u0090\u0479\u0001\u0000\u0000"+
		"\u0000\u0092\u047e\u0001\u0000\u0000\u0000\u0094\u0483\u0001\u0000\u0000"+
		"\u0000\u0096\u0487\u0001\u0000\u0000\u0000\u0098\u0489\u0001\u0000\u0000"+
		"\u0000\u009a\u048b\u0001\u0000\u0000\u0000\u009c\u048d\u0001\u0000\u0000"+
		"\u0000\u009e\u048f\u0001\u0000\u0000\u0000\u00a0\u0491\u0001\u0000\u0000"+
		"\u0000\u00a2\u0493\u0001\u0000\u0000\u0000\u00a4\u049a\u0001\u0000\u0000"+
		"\u0000\u00a6\u04a2\u0001\u0000\u0000\u0000\u00a8\u04b0\u0001\u0000\u0000"+
		"\u0000\u00aa\u04b2\u0001\u0000\u0000\u0000\u00ac\u04b7\u0001\u0000\u0000"+
		"\u0000\u00ae\u04c4\u0001\u0000\u0000\u0000\u00b0\u04c6\u0001\u0000\u0000"+
		"\u0000\u00b2\u04dd\u0001\u0000\u0000\u0000\u00b4\u04df\u0001\u0000\u0000"+
		"\u0000\u00b6\u04e9\u0001\u0000\u0000\u0000\u00b8\u04ee\u0001\u0000\u0000"+
		"\u0000\u00ba\u04f1\u0001\u0000\u0000\u0000\u00bc\u0502\u0001\u0000\u0000"+
		"\u0000\u00be\u050a\u0001\u0000\u0000\u0000\u00c0\u0512\u0001\u0000\u0000"+
		"\u0000\u00c2\u0516\u0001\u0000\u0000\u0000\u00c4\u051e\u0001\u0000\u0000"+
		"\u0000\u00c6\u0522\u0001\u0000\u0000\u0000\u00c8\u053e\u0001\u0000\u0000"+
		"\u0000\u00ca\u0540\u0001\u0000\u0000\u0000\u00cc\u0543\u0001\u0000\u0000"+
		"\u0000\u00ce\u0546\u0001\u0000\u0000\u0000\u00d0\u0549\u0001\u0000\u0000"+
		"\u0000\u00d2\u055d\u0001\u0000\u0000\u0000\u00d4\u055f\u0001\u0000\u0000"+
		"\u0000\u00d6\u0567\u0001\u0000\u0000\u0000\u00d8\u0575\u0001\u0000\u0000"+
		"\u0000\u00da\u0577\u0001\u0000\u0000\u0000\u00dc\u0585\u0001\u0000\u0000"+
		"\u0000\u00de\u0587\u0001\u0000\u0000\u0000\u00e0\u058d\u0001\u0000\u0000"+
		"\u0000\u00e2\u058f\u0001\u0000\u0000\u0000\u00e4\u0597\u0001\u0000\u0000"+
		"\u0000\u00e6\u05a2\u0001\u0000\u0000\u0000\u00e8\u05a4\u0001\u0000\u0000"+
		"\u0000\u00ea\u05b5\u0001\u0000\u0000\u0000\u00ec\u05b7\u0001\u0000\u0000"+
		"\u0000\u00ee\u05ba\u0001\u0000\u0000\u0000\u00f0\u05bd\u0001\u0000\u0000"+
		"\u0000\u00f2\u05c0\u0001\u0000\u0000\u0000\u00f4\u05c3\u0001\u0000\u0000"+
		"\u0000\u00f6\u05c6\u0001\u0000\u0000\u0000\u00f8\u05c9\u0001\u0000\u0000"+
		"\u0000\u00fa\u05cd\u0001\u0000\u0000\u0000\u00fc\u05d0\u0001\u0000\u0000"+
		"\u0000\u00fe\u05d4\u0001\u0000\u0000\u0000\u0100\u05d7\u0001\u0000\u0000"+
		"\u0000\u0102\u05e2\u0001\u0000\u0000\u0000\u0104\u05ed\u0001\u0000\u0000"+
		"\u0000\u0106\u05f8\u0001\u0000\u0000\u0000\u0108\u0603\u0001\u0000\u0000"+
		"\u0000\u010a\u060e\u0001\u0000\u0000\u0000\u010c\u0620\u0001\u0000\u0000"+
		"\u0000\u010e\u0622\u0001\u0000\u0000\u0000\u0110\u062a\u0001\u0000\u0000"+
		"\u0000\u0112\u062c\u0001\u0000\u0000\u0000\u0114\u0655\u0001\u0000\u0000"+
		"\u0000\u0116\u0665\u0001\u0000\u0000\u0000\u0118\u067d\u0001\u0000\u0000"+
		"\u0000\u011a\u067f\u0001\u0000\u0000\u0000\u011c\u0686\u0001\u0000\u0000"+
		"\u0000\u011e\u068d\u0001\u0000\u0000\u0000\u0120\u06c0\u0001\u0000\u0000"+
		"\u0000\u0122\u06c3\u0001\u0000\u0000\u0000\u0124\u06ce\u0001\u0000\u0000"+
		"\u0000\u0126\u06f0\u0001\u0000\u0000\u0000\u0128\u06f2\u0001\u0000\u0000"+
		"\u0000\u012a\u06f5\u0001\u0000\u0000\u0000\u012c\u06f9\u0001\u0000\u0000"+
		"\u0000\u012e\u06fe\u0001\u0000\u0000\u0000\u0130\u0705\u0001\u0000\u0000"+
		"\u0000\u0132\u0709\u0001\u0000\u0000\u0000\u0134\u070b\u0001\u0000\u0000"+
		"\u0000\u0136\u0718\u0001\u0000\u0000\u0000\u0138\u071b\u0001\u0000\u0000"+
		"\u0000\u013a\u0724\u0001\u0000\u0000\u0000\u013c\u0726\u0001\u0000\u0000"+
		"\u0000\u013e\u072f\u0001\u0000\u0000\u0000\u0140\u0732\u0001\u0000\u0000"+
		"\u0000\u0142\u0738\u0001\u0000\u0000\u0000\u0144\u073a\u0001\u0000\u0000"+
		"\u0000\u0146\u0740\u0001\u0000\u0000\u0000\u0148\u074a\u0001\u0000\u0000"+
		"\u0000\u014a\u074e\u0001\u0000\u0000\u0000\u014c\u0754\u0001\u0000\u0000"+
		"\u0000\u014e\u0762\u0001\u0000\u0000\u0000\u0150\u0764\u0001\u0000\u0000"+
		"\u0000\u0152\u0769\u0001\u0000\u0000\u0000\u0154\u076e\u0001\u0000\u0000"+
		"\u0000\u0156\u077b\u0001\u0000\u0000\u0000\u0158\u0780\u0001\u0000\u0000"+
		"\u0000\u015a\u0785\u0001\u0000\u0000\u0000\u015c\u078d\u0001\u0000\u0000"+
		"\u0000\u015e\u0792\u0001\u0000\u0000\u0000\u0160\u07a2\u0001\u0000\u0000"+
		"\u0000\u0162\u07a9\u0001\u0000\u0000\u0000\u0164\u07ab\u0001\u0000\u0000"+
		"\u0000\u0166\u07ce\u0001\u0000\u0000\u0000\u0168\u07d0\u0001\u0000\u0000"+
		"\u0000\u016a\u07d8\u0001\u0000\u0000\u0000\u016c\u07e0\u0001\u0000\u0000"+
		"\u0000\u016e\u07e2\u0001\u0000\u0000\u0000\u0170\u07ed\u0001\u0000\u0000"+
		"\u0000\u0172\u07f8\u0001\u0000\u0000\u0000\u0174\u0808\u0001\u0000\u0000"+
		"\u0000\u0176\u0814\u0001\u0000\u0000\u0000\u0178\u0825\u0001\u0000\u0000"+
		"\u0000\u017a\u082d\u0001\u0000\u0000\u0000\u017c\u082f\u0001\u0000\u0000"+
		"\u0000\u017e\u0838\u0001\u0000\u0000\u0000\u0180\u084f\u0001\u0000\u0000"+
		"\u0000\u0182\u0864\u0001\u0000\u0000\u0000\u0184\u0875\u0001\u0000\u0000"+
		"\u0000\u0186\u0896\u0001\u0000\u0000\u0000\u0188\u089b\u0001\u0000\u0000"+
		"\u0000\u018a\u089d\u0001\u0000\u0000\u0000\u018c\u08a1\u0001\u0000\u0000"+
		"\u0000\u018e\u0190\u0003\b\u0004\u0000\u018f\u018e\u0001\u0000\u0000\u0000"+
		"\u018f\u0190\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000\u0000"+
		"\u0191\u0192\u0005\u0000\u0000\u0001\u0192\u0001\u0001\u0000\u0000\u0000"+
		"\u0193\u0194\u0003\f\u0006\u0000\u0194\u0003\u0001\u0000\u0000\u0000\u0195"+
		"\u0199\u0003\u00d0h\u0000\u0196\u0198\u0005b\u0000\u0000\u0197\u0196\u0001"+
		"\u0000\u0000\u0000\u0198\u019b\u0001\u0000\u0000\u0000\u0199\u0197\u0001"+
		"\u0000\u0000\u0000\u0199\u019a\u0001\u0000\u0000\u0000\u019a\u019c\u0001"+
		"\u0000\u0000\u0000\u019b\u0199\u0001\u0000\u0000\u0000\u019c\u019d\u0005"+
		"\u0000\u0000\u0001\u019d\u0005\u0001\u0000\u0000\u0000\u019e\u01a0\u0005"+
		"\b\u0000\u0000\u019f\u01a1\u0003\u0186\u00c3\u0000\u01a0\u019f\u0001\u0000"+
		"\u0000\u0000\u01a0\u01a1\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000"+
		"\u0000\u0000\u01a2\u01a3\u0005\u000b\u0000\u0000\u01a3\u01a4\u00054\u0000"+
		"\u0000\u01a4\u01a8\u0003\u00d2i\u0000\u01a5\u01a7\u0005b\u0000\u0000\u01a6"+
		"\u01a5\u0001\u0000\u0000\u0000\u01a7\u01aa\u0001\u0000\u0000\u0000\u01a8"+
		"\u01a6\u0001\u0000\u0000\u0000\u01a8\u01a9\u0001\u0000\u0000\u0000\u01a9"+
		"\u01ab\u0001\u0000\u0000\u0000\u01aa\u01a8\u0001\u0000\u0000\u0000\u01ab"+
		"\u01ac\u0005\u0000\u0000\u0001\u01ac\u0007\u0001\u0000\u0000\u0000\u01ad"+
		"\u01af\u0003\n\u0005\u0000\u01ae\u01ad\u0001\u0000\u0000\u0000\u01af\u01b0"+
		"\u0001\u0000\u0000\u0000\u01b0\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1"+
		"\u0001\u0000\u0000\u0000\u01b1\t\u0001\u0000\u0000\u0000\u01b2\u01b5\u0003"+
		"\u0012\t\u0000\u01b3\u01b5\u0003\u000e\u0007\u0000\u01b4\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b5\u000b\u0001\u0000"+
		"\u0000\u0000\u01b6\u01b7\u0003\u0012\t\u0000\u01b7\u01b8\u0005b\u0000"+
		"\u0000\u01b8\u01bd\u0001\u0000\u0000\u0000\u01b9\u01bd\u0003\u000e\u0007"+
		"\u0000\u01ba\u01bd\u0005b\u0000\u0000\u01bb\u01bd\u0005\u0000\u0000\u0001"+
		"\u01bc\u01b6\u0001\u0000\u0000\u0000\u01bc\u01b9\u0001\u0000\u0000\u0000"+
		"\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bc\u01bb\u0001\u0000\u0000\u0000"+
		"\u01bd\r\u0001\u0000\u0000\u0000\u01be\u01c3\u0003\u0010\b\u0000\u01bf"+
		"\u01c0\u0005\u0011\u0000\u0000\u01c0\u01c2\u0003\u0010\b\u0000\u01c1\u01bf"+
		"\u0001\u0000\u0000\u0000\u01c2\u01c5\u0001\u0000\u0000\u0000\u01c3\u01c1"+
		"\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000\u0000\u01c4\u01c7"+
		"\u0001\u0000\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c6\u01c8"+
		"\u0005\u0011\u0000\u0000\u01c7\u01c6\u0001\u0000\u0000\u0000\u01c7\u01c8"+
		"\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000\u01c9\u01ca"+
		"\u0005b\u0000\u0000\u01ca\u000f\u0001\u0000\u0000\u0000\u01cb\u01da\u0003"+
		"\u0014\n\u0000\u01cc\u01da\u0003\u00c2a\u0000\u01cd\u01da\u0003\u00d6"+
		"k\u0000\u01ce\u01da\u0003\u001a\r\u0000\u01cf\u01da\u0003(\u0014\u0000"+
		"\u01d0\u01da\u0003\u001c\u000e\u0000\u01d1\u01da\u0005<\u0000\u0000\u01d2"+
		"\u01da\u0003\"\u0011\u0000\u01d3\u01da\u0003$\u0012\u0000\u01d4\u01da"+
		"\u0003&\u0013\u0000\u01d5\u01da\u0005>\u0000\u0000\u01d6\u01da\u0005H"+
		"\u0000\u0000\u01d7\u01da\u0003\u001e\u000f\u0000\u01d8\u01da\u0003 \u0010"+
		"\u0000\u01d9\u01cb\u0001\u0000\u0000\u0000\u01d9\u01cc\u0001\u0000\u0000"+
		"\u0000\u01d9\u01cd\u0001\u0000\u0000\u0000\u01d9\u01ce\u0001\u0000\u0000"+
		"\u0000\u01d9\u01cf\u0001\u0000\u0000\u0000\u01d9\u01d0\u0001\u0000\u0000"+
		"\u0000\u01d9\u01d1\u0001\u0000\u0000\u0000\u01d9\u01d2\u0001\u0000\u0000"+
		"\u0000\u01d9\u01d3\u0001\u0000\u0000\u0000\u01d9\u01d4\u0001\u0000\u0000"+
		"\u0000\u01d9\u01d5\u0001\u0000\u0000\u0000\u01d9\u01d6\u0001\u0000\u0000"+
		"\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000\u01d9\u01d8\u0001\u0000\u0000"+
		"\u0000\u01da\u0011\u0001\u0000\u0000\u0000\u01db\u01e4\u0003B!\u0000\u01dc"+
		"\u01e4\u0003d2\u0000\u01dd\u01e4\u0003>\u001f\u0000\u01de\u01e4\u0003"+
		"n7\u0000\u01df\u01e4\u0003l6\u0000\u01e0\u01e4\u0003r9\u0000\u01e1\u01e4"+
		"\u0003j5\u0000\u01e2\u01e4\u0003z=\u0000\u01e3\u01db\u0001\u0000\u0000"+
		"\u0000\u01e3\u01dc\u0001\u0000\u0000\u0000\u01e3\u01dd\u0001\u0000\u0000"+
		"\u0000\u01e3\u01de\u0001\u0000\u0000\u0000\u01e3\u01df\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e0\u0001\u0000\u0000\u0000\u01e3\u01e1\u0001\u0000\u0000"+
		"\u0000\u01e3\u01e2\u0001\u0000\u0000\u0000\u01e4\u0013\u0001\u0000\u0000"+
		"\u0000\u01e5\u01e6\u0003\u018c\u00c6\u0000\u01e6\u01e7\u0005\u000f\u0000"+
		"\u0000\u01e7\u01ea\u0003\u00d2i\u0000\u01e8\u01e9\u0005\u001a\u0000\u0000"+
		"\u01e9\u01eb\u0003\u0016\u000b\u0000\u01ea\u01e8\u0001\u0000\u0000\u0000"+
		"\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u020e\u0001\u0000\u0000\u0000"+
		"\u01ec\u01ed\u0005\b\u0000\u0000\u01ed\u01ee\u0003\u017a\u00bd\u0000\u01ee"+
		"\u01ef\u0005\u000b\u0000\u0000\u01ef\u01f2\u0001\u0000\u0000\u0000\u01f0"+
		"\u01f2\u0003\u017c\u00be\u0000\u01f1\u01ec\u0001\u0000\u0000\u0000\u01f1"+
		"\u01f0\u0001\u0000\u0000\u0000\u01f2\u01f3\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f4\u0005\u000f\u0000\u0000\u01f4\u01f7\u0003\u00d2i\u0000\u01f5\u01f6"+
		"\u0005\u001a\u0000\u0000\u01f6\u01f8\u0003\u0016\u000b\u0000\u01f7\u01f5"+
		"\u0001\u0000\u0000\u0000\u01f7\u01f8\u0001\u0000\u0000\u0000\u01f8\u020e"+
		"\u0001\u0000\u0000\u0000\u01f9\u01fa\u0003\u016e\u00b7\u0000\u01fa\u01fb"+
		"\u0005\u001a\u0000\u0000\u01fb\u01fd\u0001\u0000\u0000\u0000\u01fc\u01f9"+
		"\u0001\u0000\u0000\u0000\u01fd\u01fe\u0001\u0000\u0000\u0000\u01fe\u01fc"+
		"\u0001\u0000\u0000\u0000\u01fe\u01ff\u0001\u0000\u0000\u0000\u01ff\u0202"+
		"\u0001\u0000\u0000\u0000\u0200\u0203\u0003\u00d4j\u0000\u0201\u0203\u0003"+
		"\u00d6k\u0000\u0202\u0200\u0001\u0000\u0000\u0000\u0202\u0201\u0001\u0000"+
		"\u0000\u0000\u0203\u0205\u0001\u0000\u0000\u0000\u0204\u0206\u0005\u0004"+
		"\u0000\u0000\u0205\u0204\u0001\u0000\u0000\u0000\u0205\u0206\u0001\u0000"+
		"\u0000\u0000\u0206\u020e\u0001\u0000\u0000\u0000\u0207\u0208\u0003\u017a"+
		"\u00bd\u0000\u0208\u020b\u0003\u0018\f\u0000\u0209\u020c\u0003\u00d4j"+
		"\u0000\u020a\u020c\u0003\u00d6k\u0000\u020b\u0209\u0001\u0000\u0000\u0000"+
		"\u020b\u020a\u0001\u0000\u0000\u0000\u020c\u020e\u0001\u0000\u0000\u0000"+
		"\u020d\u01e5\u0001\u0000\u0000\u0000\u020d\u01f1\u0001\u0000\u0000\u0000"+
		"\u020d\u01fc\u0001\u0000\u0000\u0000\u020d\u0207\u0001\u0000\u0000\u0000"+
		"\u020e\u0015\u0001\u0000\u0000\u0000\u020f\u0212\u0003\u00d4j\u0000\u0210"+
		"\u0212\u0003\u00d6k\u0000\u0211\u020f\u0001\u0000\u0000\u0000\u0211\u0210"+
		"\u0001\u0000\u0000\u0000\u0212\u0017\u0001\u0000\u0000\u0000\u0213\u0214"+
		"\u0007\u0000\u0000\u0000\u0214\u0019\u0001\u0000\u0000\u0000\u0215\u0217"+
		"\u0005F\u0000\u0000\u0216\u0218\u0003\u00d6k\u0000\u0217\u0216\u0001\u0000"+
		"\u0000\u0000\u0217\u0218\u0001\u0000\u0000\u0000\u0218\u001b\u0001\u0000"+
		"\u0000\u0000\u0219\u021f\u0005A\u0000\u0000\u021a\u021d\u0003\u00d2i\u0000"+
		"\u021b\u021c\u0005N\u0000\u0000\u021c\u021e\u0003\u00d2i\u0000\u021d\u021b"+
		"\u0001\u0000\u0000\u0000\u021d\u021e\u0001\u0000\u0000\u0000\u021e\u0220"+
		"\u0001\u0000\u0000\u0000\u021f\u021a\u0001\u0000\u0000\u0000\u021f\u0220"+
		"\u0001\u0000\u0000\u0000\u0220\u001d\u0001\u0000\u0000\u0000\u0221\u0222"+
		"\u0005S\u0000\u0000\u0222\u0227\u0003\u018c\u00c6\u0000\u0223\u0224\u0005"+
		"\u0010\u0000\u0000\u0224\u0226\u0003\u018c\u00c6\u0000\u0225\u0223\u0001"+
		"\u0000\u0000\u0000\u0226\u0229\u0001\u0000\u0000\u0000\u0227\u0225\u0001"+
		"\u0000\u0000\u0000\u0227\u0228\u0001\u0000\u0000\u0000\u0228\u001f\u0001"+
		"\u0000\u0000\u0000\u0229\u0227\u0001\u0000\u0000\u0000\u022a\u022b\u0005"+
		"O\u0000\u0000\u022b\u0230\u0003\u018c\u00c6\u0000\u022c\u022d\u0005\u0010"+
		"\u0000\u0000\u022d\u022f\u0003\u018c\u00c6\u0000\u022e\u022c\u0001\u0000"+
		"\u0000\u0000\u022f\u0232\u0001\u0000\u0000\u0000\u0230\u022e\u0001\u0000"+
		"\u0000\u0000\u0230\u0231\u0001\u0000\u0000\u0000\u0231!\u0001\u0000\u0000"+
		"\u0000\u0232\u0230\u0001\u0000\u0000\u0000\u0233\u0234\u0005R\u0000\u0000"+
		"\u0234\u0235\u0003\u0180\u00c0\u0000\u0235#\u0001\u0000\u0000\u0000\u0236"+
		"\u0237\u0003\u00d4j\u0000\u0237%\u0001\u0000\u0000\u0000\u0238\u0239\u0005"+
		"Q\u0000\u0000\u0239\u023c\u0003\u00d2i\u0000\u023a\u023b\u0005\u0010\u0000"+
		"\u0000\u023b\u023d\u0003\u00d2i\u0000\u023c\u023a\u0001\u0000\u0000\u0000"+
		"\u023c\u023d\u0001\u0000\u0000\u0000\u023d\'\u0001\u0000\u0000\u0000\u023e"+
		"\u0241\u0003*\u0015\u0000\u023f\u0241\u0003,\u0016\u0000\u0240\u023e\u0001"+
		"\u0000\u0000\u0000\u0240\u023f\u0001\u0000\u0000\u0000\u0241)\u0001\u0000"+
		"\u0000\u0000\u0242\u0243\u0005;\u0000\u0000\u0243\u0244\u00034\u001a\u0000"+
		"\u0244+\u0001\u0000\u0000\u0000\u0245\u0249\u0005N\u0000\u0000\u0246\u0248"+
		"\u0007\u0001\u0000\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0248\u024b"+
		"\u0001\u0000\u0000\u0000\u0249\u0247\u0001\u0000\u0000\u0000\u0249\u024a"+
		"\u0001\u0000\u0000\u0000\u024a\u024c\u0001\u0000\u0000\u0000\u024b\u0249"+
		"\u0001\u0000\u0000\u0000\u024c\u024d\u00038\u001c\u0000\u024d\u024e\u0005"+
		";\u0000\u0000\u024e\u024f\u0003.\u0017\u0000\u024f\u0259\u0001\u0000\u0000"+
		"\u0000\u0250\u0252\u0005N\u0000\u0000\u0251\u0253\u0007\u0001\u0000\u0000"+
		"\u0252\u0251\u0001\u0000\u0000\u0000\u0253\u0254\u0001\u0000\u0000\u0000"+
		"\u0254\u0252\u0001\u0000\u0000\u0000\u0254\u0255\u0001\u0000\u0000\u0000"+
		"\u0255\u0256\u0001\u0000\u0000\u0000\u0256\u0257\u0005;\u0000\u0000\u0257"+
		"\u0259\u0003.\u0017\u0000\u0258\u0245\u0001\u0000\u0000\u0000\u0258\u0250"+
		"\u0001\u0000\u0000\u0000\u0259-\u0001\u0000\u0000\u0000\u025a\u025b\u0005"+
		"\b\u0000\u0000\u025b\u025d\u00030\u0018\u0000\u025c\u025e\u0005\u0010"+
		"\u0000\u0000\u025d\u025c\u0001\u0000\u0000\u0000\u025d\u025e\u0001\u0000"+
		"\u0000\u0000\u025e\u025f\u0001\u0000\u0000\u0000\u025f\u0260\u0005\u000b"+
		"\u0000\u0000\u0260\u0264\u0001\u0000\u0000\u0000\u0261\u0264\u00030\u0018"+
		"\u0000\u0262\u0264\u0005\u0014\u0000\u0000\u0263\u025a\u0001\u0000\u0000"+
		"\u0000\u0263\u0261\u0001\u0000\u0000\u0000\u0263\u0262\u0001\u0000\u0000"+
		"\u0000\u0264/\u0001\u0000\u0000\u0000\u0265\u026a\u00032\u0019\u0000\u0266"+
		"\u0267\u0005\u0010\u0000\u0000\u0267\u0269\u00032\u0019\u0000\u0268\u0266"+
		"\u0001\u0000\u0000\u0000\u0269\u026c\u0001\u0000\u0000\u0000\u026a\u0268"+
		"\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b1\u0001"+
		"\u0000\u0000\u0000\u026c\u026a\u0001\u0000\u0000\u0000\u026d\u0270\u0003"+
		"\u018c\u00c6\u0000\u026e\u026f\u0005L\u0000\u0000\u026f\u0271\u0003\u018c"+
		"\u00c6\u0000\u0270\u026e\u0001\u0000\u0000\u0000\u0270\u0271\u0001\u0000"+
		"\u0000\u0000\u02713\u0001\u0000\u0000\u0000\u0272\u0277\u00036\u001b\u0000"+
		"\u0273\u0274\u0005\u0010\u0000\u0000\u0274\u0276\u00036\u001b\u0000\u0275"+
		"\u0273\u0001\u0000\u0000\u0000\u0276\u0279\u0001\u0000\u0000\u0000\u0277"+
		"\u0275\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278"+
		"5\u0001\u0000\u0000\u0000\u0279\u0277\u0001\u0000\u0000\u0000\u027a\u027d"+
		"\u00038\u001c\u0000\u027b\u027c\u0005L\u0000\u0000\u027c\u027e\u0003\u018c"+
		"\u00c6\u0000\u027d\u027b\u0001\u0000\u0000\u0000\u027d\u027e\u0001\u0000"+
		"\u0000\u0000\u027e7\u0001\u0000\u0000\u0000\u027f\u0280\u0006\u001c\uffff"+
		"\uffff\u0000\u0280\u0281\u0003\u018c\u00c6\u0000\u0281\u0287\u0001\u0000"+
		"\u0000\u0000\u0282\u0283\n\u0002\u0000\u0000\u0283\u0284\u0005\u000e\u0000"+
		"\u0000\u0284\u0286\u0003\u018c\u00c6\u0000\u0285\u0282\u0001\u0000\u0000"+
		"\u0000\u0286\u0289\u0001\u0000\u0000\u0000\u0287\u0285\u0001\u0000\u0000"+
		"\u0000\u0287\u0288\u0001\u0000\u0000\u0000\u02889\u0001\u0000\u0000\u0000"+
		"\u0289\u0287\u0001\u0000\u0000\u0000\u028a\u028b\u0005b\u0000\u0000\u028b"+
		"\u028c\u0005\u0002\u0000\u0000\u028c\u028d\u0003\b\u0004\u0000\u028d\u028e"+
		"\u0005\u0003\u0000\u0000\u028e\u0291\u0001\u0000\u0000\u0000\u028f\u0291"+
		"\u0003\u000e\u0007\u0000\u0290\u028a\u0001\u0000\u0000\u0000\u0290\u028f"+
		"\u0001\u0000\u0000\u0000\u0291;\u0001\u0000\u0000\u0000\u0292\u0293\u0005"+
		"2\u0000\u0000\u0293\u0294\u0003\u00e0p\u0000\u0294\u0295\u0005b\u0000"+
		"\u0000\u0295\u0297\u0001\u0000\u0000\u0000\u0296\u0292\u0001\u0000\u0000"+
		"\u0000\u0297\u0298\u0001\u0000\u0000\u0000\u0298\u0296\u0001\u0000\u0000"+
		"\u0000\u0298\u0299\u0001\u0000\u0000\u0000\u0299=\u0001\u0000\u0000\u0000"+
		"\u029a\u029b\u0003<\u001e\u0000\u029b\u029c\u0003@ \u0000\u029c\u029f"+
		"\u0001\u0000\u0000\u0000\u029d\u029f\u0003@ \u0000\u029e\u029a\u0001\u0000"+
		"\u0000\u0000\u029e\u029d\u0001\u0000\u0000\u0000\u029f?\u0001\u0000\u0000"+
		"\u0000\u02a0\u02a1\u0005C\u0000\u0000\u02a1\u02a3\u0003\u018c\u00c6\u0000"+
		"\u02a2\u02a4\u0003\u00c4b\u0000\u02a3\u02a2\u0001\u0000\u0000\u0000\u02a3"+
		"\u02a4\u0001\u0000\u0000\u0000\u02a4\u02aa\u0001\u0000\u0000\u0000\u02a5"+
		"\u02a7\u0005\b\u0000\u0000\u02a6\u02a8\u0003\u015e\u00af\u0000\u02a7\u02a6"+
		"\u0001\u0000\u0000\u0000\u02a7\u02a8\u0001\u0000\u0000\u0000\u02a8\u02a9"+
		"\u0001\u0000\u0000\u0000\u02a9\u02ab\u0005\u000b\u0000\u0000\u02aa\u02a5"+
		"\u0001\u0000\u0000\u0000\u02aa\u02ab\u0001\u0000\u0000\u0000\u02ab\u02ac"+
		"\u0001\u0000\u0000\u0000\u02ac\u02ad\u0005\u000f\u0000\u0000\u02ad\u02ae"+
		"\u0003:\u001d\u0000\u02aeA\u0001\u0000\u0000\u0000\u02af\u02b0\u0003<"+
		"\u001e\u0000\u02b0\u02b1\u0003D\"\u0000\u02b1\u02b4\u0001\u0000\u0000"+
		"\u0000\u02b2\u02b4\u0003D\"\u0000\u02b3\u02af\u0001\u0000\u0000\u0000"+
		"\u02b3\u02b2\u0001\u0000\u0000\u0000\u02b4C\u0001\u0000\u0000\u0000\u02b5"+
		"\u02b6\u0005M\u0000\u0000\u02b6\u02b8\u0003\u018c\u00c6\u0000\u02b7\u02b9"+
		"\u0003\u00c4b\u0000\u02b8\u02b7\u0001\u0000\u0000\u0000\u02b8\u02b9\u0001"+
		"\u0000\u0000\u0000\u02b9\u02ba\u0001\u0000\u0000\u0000\u02ba\u02bc\u0005"+
		"\b\u0000\u0000\u02bb\u02bd\u0003F#\u0000\u02bc\u02bb\u0001\u0000\u0000"+
		"\u0000\u02bc\u02bd\u0001\u0000\u0000\u0000\u02bd\u02be\u0001\u0000\u0000"+
		"\u0000\u02be\u02c1\u0005\u000b\u0000\u0000\u02bf\u02c0\u00054\u0000\u0000"+
		"\u02c0\u02c2\u0003\u00d2i\u0000\u02c1\u02bf\u0001\u0000\u0000\u0000\u02c1"+
		"\u02c2\u0001\u0000\u0000\u0000\u02c2\u02c3\u0001\u0000\u0000\u0000\u02c3"+
		"\u02c5\u0005\u000f\u0000\u0000\u02c4\u02c6\u0003\u0188\u00c4\u0000\u02c5"+
		"\u02c4\u0001\u0000\u0000\u0000\u02c5\u02c6\u0001\u0000\u0000\u0000\u02c6"+
		"\u02c7\u0001\u0000\u0000\u0000\u02c7\u02c8\u0003:\u001d\u0000\u02c8\u02df"+
		"\u0001\u0000\u0000\u0000\u02c9\u02ca\u0005V\u0000\u0000\u02ca\u02cb\u0005"+
		"M\u0000\u0000\u02cb\u02cd\u0003\u018c\u00c6\u0000\u02cc\u02ce\u0003\u00c4"+
		"b\u0000\u02cd\u02cc\u0001\u0000\u0000\u0000\u02cd\u02ce\u0001\u0000\u0000"+
		"\u0000\u02ce\u02cf\u0001\u0000\u0000\u0000\u02cf\u02d1\u0005\b\u0000\u0000"+
		"\u02d0\u02d2\u0003F#\u0000\u02d1\u02d0\u0001\u0000\u0000\u0000\u02d1\u02d2"+
		"\u0001\u0000\u0000\u0000\u02d2\u02d3\u0001\u0000\u0000\u0000\u02d3\u02d6"+
		"\u0005\u000b\u0000\u0000\u02d4\u02d5\u00054\u0000\u0000\u02d5\u02d7\u0003"+
		"\u00d2i\u0000\u02d6\u02d4\u0001\u0000\u0000\u0000\u02d6\u02d7\u0001\u0000"+
		"\u0000\u0000\u02d7\u02d8\u0001\u0000\u0000\u0000\u02d8\u02da\u0005\u000f"+
		"\u0000\u0000\u02d9\u02db\u0003\u0188\u00c4\u0000\u02da\u02d9\u0001\u0000"+
		"\u0000\u0000\u02da\u02db\u0001\u0000\u0000\u0000\u02db\u02dc\u0001\u0000"+
		"\u0000\u0000\u02dc\u02dd\u0003:\u001d\u0000\u02dd\u02df\u0001\u0000\u0000"+
		"\u0000\u02de\u02b5\u0001\u0000\u0000\u0000\u02de\u02c9\u0001\u0000\u0000"+
		"\u0000\u02dfE\u0001\u0000\u0000\u0000\u02e0\u02e1\u0003H$\u0000\u02e1"+
		"G\u0001\u0000\u0000\u0000\u02e2\u02e6\u0003J%\u0000\u02e3\u02e5\u0003"+
		"R)\u0000\u02e4\u02e3\u0001\u0000\u0000\u0000\u02e5\u02e8\u0001\u0000\u0000"+
		"\u0000\u02e6\u02e4\u0001\u0000\u0000\u0000\u02e6\u02e7\u0001\u0000\u0000"+
		"\u0000\u02e7\u02ec\u0001\u0000\u0000\u0000\u02e8\u02e6\u0001\u0000\u0000"+
		"\u0000\u02e9\u02eb\u0003V+\u0000\u02ea\u02e9\u0001\u0000\u0000\u0000\u02eb"+
		"\u02ee\u0001\u0000\u0000\u0000\u02ec\u02ea\u0001\u0000\u0000\u0000\u02ec"+
		"\u02ed\u0001\u0000\u0000\u0000\u02ed\u02f0\u0001\u0000\u0000\u0000\u02ee"+
		"\u02ec\u0001\u0000\u0000\u0000\u02ef\u02f1\u0003N\'\u0000\u02f0\u02ef"+
		"\u0001\u0000\u0000\u0000\u02f0\u02f1\u0001\u0000\u0000\u0000\u02f1\u0314"+
		"\u0001\u0000\u0000\u0000\u02f2\u02f6\u0003L&\u0000\u02f3\u02f5\u0003V"+
		"+\u0000\u02f4\u02f3\u0001\u0000\u0000\u0000\u02f5\u02f8\u0001\u0000\u0000"+
		"\u0000\u02f6\u02f4\u0001\u0000\u0000\u0000\u02f6\u02f7\u0001\u0000\u0000"+
		"\u0000\u02f7\u02fa\u0001\u0000\u0000\u0000\u02f8\u02f6\u0001\u0000\u0000"+
		"\u0000\u02f9\u02fb\u0003N\'\u0000\u02fa\u02f9\u0001\u0000\u0000\u0000"+
		"\u02fa\u02fb\u0001\u0000\u0000\u0000\u02fb\u0314\u0001\u0000\u0000\u0000"+
		"\u02fc\u02fe\u0003R)\u0000\u02fd\u02fc\u0001\u0000\u0000\u0000\u02fe\u02ff"+
		"\u0001\u0000\u0000\u0000\u02ff\u02fd\u0001\u0000\u0000\u0000\u02ff\u0300"+
		"\u0001\u0000\u0000\u0000\u0300\u0304\u0001\u0000\u0000\u0000\u0301\u0303"+
		"\u0003V+\u0000\u0302\u0301\u0001\u0000\u0000\u0000\u0303\u0306\u0001\u0000"+
		"\u0000\u0000\u0304\u0302\u0001\u0000\u0000\u0000\u0304\u0305\u0001\u0000"+
		"\u0000\u0000\u0305\u0308\u0001\u0000\u0000\u0000\u0306\u0304\u0001\u0000"+
		"\u0000\u0000\u0307\u0309\u0003N\'\u0000\u0308\u0307\u0001\u0000\u0000"+
		"\u0000\u0308\u0309\u0001\u0000\u0000\u0000\u0309\u0314\u0001\u0000\u0000"+
		"\u0000\u030a\u030c\u0003V+\u0000\u030b\u030a\u0001\u0000\u0000\u0000\u030c"+
		"\u030d\u0001\u0000\u0000\u0000\u030d\u030b\u0001\u0000\u0000\u0000\u030d"+
		"\u030e\u0001\u0000\u0000\u0000\u030e\u0310\u0001\u0000\u0000\u0000\u030f"+
		"\u0311\u0003N\'\u0000\u0310\u030f\u0001\u0000\u0000\u0000\u0310\u0311"+
		"\u0001\u0000\u0000\u0000\u0311\u0314\u0001\u0000\u0000\u0000\u0312\u0314"+
		"\u0003N\'\u0000\u0313\u02e2\u0001\u0000\u0000\u0000\u0313\u02f2\u0001"+
		"\u0000\u0000\u0000\u0313\u02fd\u0001\u0000\u0000\u0000\u0313\u030b\u0001"+
		"\u0000\u0000\u0000\u0313\u0312\u0001\u0000\u0000\u0000\u0314I\u0001\u0000"+
		"\u0000\u0000\u0315\u0317\u0003R)\u0000\u0316\u0315\u0001\u0000\u0000\u0000"+
		"\u0317\u0318\u0001\u0000\u0000\u0000\u0318\u0316\u0001\u0000\u0000\u0000"+
		"\u0318\u0319\u0001\u0000\u0000\u0000\u0319\u031a\u0001\u0000\u0000\u0000"+
		"\u031a\u031c\u0005\u0015\u0000\u0000\u031b\u031d\u0005\u0010\u0000\u0000"+
		"\u031c\u031b\u0001\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000\u0000"+
		"\u031dK\u0001\u0000\u0000\u0000\u031e\u0320\u0003R)\u0000\u031f\u031e"+
		"\u0001\u0000\u0000\u0000\u0320\u0323\u0001\u0000\u0000\u0000\u0321\u031f"+
		"\u0001\u0000\u0000\u0000\u0321\u0322\u0001\u0000\u0000\u0000\u0322\u0325"+
		"\u0001\u0000\u0000\u0000\u0323\u0321\u0001\u0000\u0000\u0000\u0324\u0326"+
		"\u0003V+\u0000\u0325\u0324\u0001\u0000\u0000\u0000\u0326\u0327\u0001\u0000"+
		"\u0000\u0000\u0327\u0325\u0001\u0000\u0000\u0000\u0327\u0328\u0001\u0000"+
		"\u0000\u0000\u0328\u0329\u0001\u0000\u0000\u0000\u0329\u032b\u0005\u0015"+
		"\u0000\u0000\u032a\u032c\u0005\u0010\u0000\u0000\u032b\u032a\u0001\u0000"+
		"\u0000\u0000\u032b\u032c\u0001\u0000\u0000\u0000\u032cM\u0001\u0000\u0000"+
		"\u0000\u032d\u032e\u0005\u0014\u0000\u0000\u032e\u0332\u0003R)\u0000\u032f"+
		"\u0331\u0003X,\u0000\u0330\u032f\u0001\u0000\u0000\u0000\u0331\u0334\u0001"+
		"\u0000\u0000\u0000\u0332\u0330\u0001\u0000\u0000\u0000\u0332\u0333\u0001"+
		"\u0000\u0000\u0000\u0333\u0336\u0001\u0000\u0000\u0000\u0334\u0332\u0001"+
		"\u0000\u0000\u0000\u0335\u0337\u0003P(\u0000\u0336\u0335\u0001\u0000\u0000"+
		"\u0000\u0336\u0337\u0001\u0000\u0000\u0000\u0337\u034f\u0001\u0000\u0000"+
		"\u0000\u0338\u0339\u0005\u0014\u0000\u0000\u0339\u033d\u0003T*\u0000\u033a"+
		"\u033c\u0003X,\u0000\u033b\u033a\u0001\u0000\u0000\u0000\u033c\u033f\u0001"+
		"\u0000\u0000\u0000\u033d\u033b\u0001\u0000\u0000\u0000\u033d\u033e\u0001"+
		"\u0000\u0000\u0000\u033e\u0341\u0001\u0000\u0000\u0000\u033f\u033d\u0001"+
		"\u0000\u0000\u0000\u0340\u0342\u0003P(\u0000\u0341\u0340\u0001\u0000\u0000"+
		"\u0000\u0341\u0342\u0001\u0000\u0000\u0000\u0342\u034f\u0001\u0000\u0000"+
		"\u0000\u0343\u0344\u0005\u0014\u0000\u0000\u0344\u0346\u0005\u0010\u0000"+
		"\u0000\u0345\u0347\u0003X,\u0000\u0346\u0345\u0001\u0000\u0000\u0000\u0347"+
		"\u0348\u0001\u0000\u0000\u0000\u0348\u0346\u0001\u0000\u0000\u0000\u0348"+
		"\u0349\u0001\u0000\u0000\u0000\u0349\u034b\u0001\u0000\u0000\u0000\u034a"+
		"\u034c\u0003P(\u0000\u034b\u034a\u0001\u0000\u0000\u0000\u034b\u034c\u0001"+
		"\u0000\u0000\u0000\u034c\u034f\u0001\u0000\u0000\u0000\u034d\u034f\u0003"+
		"P(\u0000\u034e\u032d\u0001\u0000\u0000\u0000\u034e\u0338\u0001\u0000\u0000"+
		"\u0000\u034e\u0343\u0001\u0000\u0000\u0000\u034e\u034d\u0001\u0000\u0000"+
		"\u0000\u034fO\u0001\u0000\u0000\u0000\u0350\u0351\u0005$\u0000\u0000\u0351"+
		"\u0352\u0003R)\u0000\u0352Q\u0001\u0000\u0000\u0000\u0353\u0355\u0003"+
		"Z-\u0000\u0354\u0356\u0005\u0010\u0000\u0000\u0355\u0354\u0001\u0000\u0000"+
		"\u0000\u0355\u0356\u0001\u0000\u0000\u0000\u0356\u0358\u0001\u0000\u0000"+
		"\u0000\u0357\u0359\u0005\u0004\u0000\u0000\u0358\u0357\u0001\u0000\u0000"+
		"\u0000\u0358\u0359\u0001\u0000\u0000\u0000\u0359S\u0001\u0000\u0000\u0000"+
		"\u035a\u035c\u0003\\.\u0000\u035b\u035d\u0005\u0010\u0000\u0000\u035c"+
		"\u035b\u0001\u0000\u0000\u0000\u035c\u035d\u0001\u0000\u0000\u0000\u035d"+
		"\u035f\u0001\u0000\u0000\u0000\u035e\u0360\u0005\u0004\u0000\u0000\u035f"+
		"\u035e\u0001\u0000\u0000\u0000\u035f\u0360\u0001\u0000\u0000\u0000\u0360"+
		"U\u0001\u0000\u0000\u0000\u0361\u0362\u0003Z-\u0000\u0362\u0364\u0003"+
		"b1\u0000\u0363\u0365\u0005\u0010\u0000\u0000\u0364\u0363\u0001\u0000\u0000"+
		"\u0000\u0364\u0365\u0001\u0000\u0000\u0000\u0365\u0367\u0001\u0000\u0000"+
		"\u0000\u0366\u0368\u0005\u0004\u0000\u0000\u0367\u0366\u0001\u0000\u0000"+
		"\u0000\u0367\u0368\u0001\u0000\u0000\u0000\u0368W\u0001\u0000\u0000\u0000"+
		"\u0369\u036b\u0003Z-\u0000\u036a\u036c\u0003b1\u0000\u036b\u036a\u0001"+
		"\u0000\u0000\u0000\u036b\u036c\u0001\u0000\u0000\u0000\u036c\u036e\u0001"+
		"\u0000\u0000\u0000\u036d\u036f\u0005\u0010\u0000\u0000\u036e\u036d\u0001"+
		"\u0000\u0000\u0000\u036e\u036f\u0001\u0000\u0000\u0000\u036f\u0371\u0001"+
		"\u0000\u0000\u0000\u0370\u0372\u0005\u0004\u0000\u0000\u0371\u0370\u0001"+
		"\u0000\u0000\u0000\u0371\u0372\u0001\u0000\u0000\u0000\u0372Y\u0001\u0000"+
		"\u0000\u0000\u0373\u0375\u0003\u018c\u00c6\u0000\u0374\u0376\u0003^/\u0000"+
		"\u0375\u0374\u0001\u0000\u0000\u0000\u0375\u0376\u0001\u0000\u0000\u0000"+
		"\u0376[\u0001\u0000\u0000\u0000\u0377\u0378\u0003\u018c\u00c6\u0000\u0378"+
		"\u0379\u0003`0\u0000\u0379]\u0001\u0000\u0000\u0000\u037a\u037b\u0005"+
		"\u000f\u0000\u0000\u037b\u037c\u0003\u00d2i\u0000\u037c_\u0001\u0000\u0000"+
		"\u0000\u037d\u037e\u0005\u000f\u0000\u0000\u037e\u037f\u0003\u00d8l\u0000"+
		"\u037fa\u0001\u0000\u0000\u0000\u0380\u0381\u0005\u001a\u0000\u0000\u0381"+
		"\u0382\u0003\u00d2i\u0000\u0382c\u0001\u0000\u0000\u0000\u0383\u0384\u0005"+
		"X\u0000\u0000\u0384\u0385\u0003\u00e0p\u0000\u0385\u0386\u0005\u000f\u0000"+
		"\u0000\u0386\u038b\u0003:\u001d\u0000\u0387\u038c\u0003f3\u0000\u0388"+
		"\u038a\u0003h4\u0000\u0389\u0388\u0001\u0000\u0000\u0000\u0389\u038a\u0001"+
		"\u0000\u0000\u0000\u038a\u038c\u0001\u0000\u0000\u0000\u038b\u0387\u0001"+
		"\u0000\u0000\u0000\u038b\u0389\u0001\u0000\u0000\u0000\u038ce\u0001\u0000"+
		"\u0000\u0000\u038d\u038e\u0005W\u0000\u0000\u038e\u038f\u0003\u00e0p\u0000"+
		"\u038f\u0390\u0005\u000f\u0000\u0000\u0390\u0395\u0003:\u001d\u0000\u0391"+
		"\u0396\u0003f3\u0000\u0392\u0394\u0003h4\u0000\u0393\u0392\u0001\u0000"+
		"\u0000\u0000\u0393\u0394\u0001\u0000\u0000\u0000\u0394\u0396\u0001\u0000"+
		"\u0000\u0000\u0395\u0391\u0001\u0000\u0000\u0000\u0395\u0393\u0001\u0000"+
		"\u0000\u0000\u0396g\u0001\u0000\u0000\u0000\u0397\u0398\u0005:\u0000\u0000"+
		"\u0398\u0399\u0005\u000f\u0000\u0000\u0399\u039a\u0003:\u001d\u0000\u039a"+
		"i\u0001\u0000\u0000\u0000\u039b\u039c\u0005P\u0000\u0000\u039c\u039d\u0003"+
		"\u00e0p\u0000\u039d\u039e\u0005\u000f\u0000\u0000\u039e\u03a0\u0003:\u001d"+
		"\u0000\u039f\u03a1\u0003h4\u0000\u03a0\u039f\u0001\u0000\u0000\u0000\u03a0"+
		"\u03a1\u0001\u0000\u0000\u0000\u03a1k\u0001\u0000\u0000\u0000\u03a2\u03a4"+
		"\u0005V\u0000\u0000\u03a3\u03a2\u0001\u0000\u0000\u0000\u03a3\u03a4\u0001"+
		"\u0000\u0000\u0000\u03a4\u03a5\u0001\u0000\u0000\u0000\u03a5\u03a6\u0005"+
		"I\u0000\u0000\u03a6\u03a7\u0003\u016e\u00b7\u0000\u03a7\u03a8\u0005@\u0000"+
		"\u0000\u03a8\u03a9\u0003\u00d6k\u0000\u03a9\u03ab\u0005\u000f\u0000\u0000"+
		"\u03aa\u03ac\u0005\u0004\u0000\u0000\u03ab\u03aa\u0001\u0000\u0000\u0000"+
		"\u03ab\u03ac\u0001\u0000\u0000\u0000\u03ac\u03ad\u0001\u0000\u0000\u0000"+
		"\u03ad\u03af\u0003:\u001d\u0000\u03ae\u03b0\u0003h4\u0000\u03af\u03ae"+
		"\u0001\u0000\u0000\u0000\u03af\u03b0\u0001\u0000\u0000\u0000\u03b0m\u0001"+
		"\u0000\u0000\u0000\u03b1\u03b2\u0005U\u0000\u0000\u03b2\u03b3\u0005\b"+
		"\u0000\u0000\u03b3\u03b8\u0003p8\u0000\u03b4\u03b5\u0005\u0010\u0000\u0000"+
		"\u03b5\u03b7\u0003p8\u0000\u03b6\u03b4\u0001\u0000\u0000\u0000\u03b7\u03ba"+
		"\u0001\u0000\u0000\u0000\u03b8\u03b6\u0001\u0000\u0000\u0000\u03b8\u03b9"+
		"\u0001\u0000\u0000\u0000\u03b9\u03bc\u0001\u0000\u0000\u0000\u03ba\u03b8"+
		"\u0001\u0000\u0000\u0000\u03bb\u03bd\u0005\u0010\u0000\u0000\u03bc\u03bb"+
		"\u0001\u0000\u0000\u0000\u03bc\u03bd\u0001\u0000\u0000\u0000\u03bd\u03be"+
		"\u0001\u0000\u0000\u0000\u03be\u03bf\u0005\u000b\u0000\u0000\u03bf\u03c1"+
		"\u0005\u000f\u0000\u0000\u03c0\u03c2\u0005\u0004\u0000\u0000\u03c1\u03c0"+
		"\u0001\u0000\u0000\u0000\u03c1\u03c2\u0001\u0000\u0000\u0000\u03c2\u03c3"+
		"\u0001\u0000\u0000\u0000\u03c3\u03c4\u0003:\u001d\u0000\u03c4\u03ea\u0001"+
		"\u0000\u0000\u0000\u03c5\u03c6\u0005V\u0000\u0000\u03c6\u03c7\u0005U\u0000"+
		"\u0000\u03c7\u03c8\u0005\b\u0000\u0000\u03c8\u03cd\u0003p8\u0000\u03c9"+
		"\u03ca\u0005\u0010\u0000\u0000\u03ca\u03cc\u0003p8\u0000\u03cb\u03c9\u0001"+
		"\u0000\u0000\u0000\u03cc\u03cf\u0001\u0000\u0000\u0000\u03cd\u03cb\u0001"+
		"\u0000\u0000\u0000\u03cd\u03ce\u0001\u0000\u0000\u0000\u03ce\u03d1\u0001"+
		"\u0000\u0000\u0000\u03cf\u03cd\u0001\u0000\u0000\u0000\u03d0\u03d2\u0005"+
		"\u0010\u0000\u0000\u03d1\u03d0\u0001\u0000\u0000\u0000\u03d1\u03d2\u0001"+
		"\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000\u0000\u0000\u03d3\u03d4\u0005"+
		"\u000b\u0000\u0000\u03d4\u03d5\u0005\u000f\u0000\u0000\u03d5\u03d6\u0003"+
		":\u001d\u0000\u03d6\u03ea\u0001\u0000\u0000\u0000\u03d7\u03d9\u0005V\u0000"+
		"\u0000\u03d8\u03d7\u0001\u0000\u0000\u0000\u03d8\u03d9\u0001\u0000\u0000"+
		"\u0000\u03d9\u03da\u0001\u0000\u0000\u0000\u03da\u03db\u0005U\u0000\u0000"+
		"\u03db\u03e0\u0003p8\u0000\u03dc\u03dd\u0005\u0010\u0000\u0000\u03dd\u03df"+
		"\u0003p8\u0000\u03de\u03dc\u0001\u0000\u0000\u0000\u03df\u03e2\u0001\u0000"+
		"\u0000\u0000\u03e0\u03de\u0001\u0000\u0000\u0000\u03e0\u03e1\u0001\u0000"+
		"\u0000\u0000\u03e1\u03e3\u0001\u0000\u0000\u0000\u03e2\u03e0\u0001\u0000"+
		"\u0000\u0000\u03e3\u03e5\u0005\u000f\u0000\u0000\u03e4\u03e6\u0005\u0004"+
		"\u0000\u0000\u03e5\u03e4\u0001\u0000\u0000\u0000\u03e5\u03e6\u0001\u0000"+
		"\u0000\u0000\u03e6\u03e7\u0001\u0000\u0000\u0000\u03e7\u03e8\u0003:\u001d"+
		"\u0000\u03e8\u03ea\u0001\u0000\u0000\u0000\u03e9\u03b1\u0001\u0000\u0000"+
		"\u0000\u03e9\u03c5\u0001\u0000\u0000\u0000\u03e9\u03d8\u0001\u0000\u0000"+
		"\u0000\u03eao\u0001\u0000\u0000\u0000\u03eb\u03ee\u0003\u00d2i\u0000\u03ec"+
		"\u03ed\u0005L\u0000\u0000\u03ed\u03ef\u0003\u0174\u00ba\u0000\u03ee\u03ec"+
		"\u0001\u0000\u0000\u0000\u03ee\u03ef\u0001\u0000\u0000\u0000\u03efq\u0001"+
		"\u0000\u0000\u0000\u03f0\u03f1\u0005K\u0000\u0000\u03f1\u03f2\u0005\u000f"+
		"\u0000\u0000\u03f2\u03f3\u0003:\u001d\u0000\u03f3\u03f4\u0003x<\u0000"+
		"\u03f4\u0412\u0001\u0000\u0000\u0000\u03f5\u03f6\u0005K\u0000\u0000\u03f6"+
		"\u03f7\u0005\u000f\u0000\u0000\u03f7\u03f9\u0003:\u001d\u0000\u03f8\u03fa"+
		"\u0003t:\u0000\u03f9\u03f8\u0001\u0000\u0000\u0000\u03fa\u03fb\u0001\u0000"+
		"\u0000\u0000\u03fb\u03f9\u0001\u0000\u0000\u0000\u03fb\u03fc\u0001\u0000"+
		"\u0000\u0000\u03fc\u03fe\u0001\u0000\u0000\u0000\u03fd\u03ff\u0003h4\u0000"+
		"\u03fe\u03fd\u0001\u0000\u0000\u0000\u03fe\u03ff\u0001\u0000\u0000\u0000"+
		"\u03ff\u0401\u0001\u0000\u0000\u0000\u0400\u0402\u0003x<\u0000\u0401\u0400"+
		"\u0001\u0000\u0000\u0000\u0401\u0402\u0001\u0000\u0000\u0000\u0402\u0412"+
		"\u0001\u0000\u0000\u0000\u0403\u0404\u0005K\u0000\u0000\u0404\u0405\u0005"+
		"\u000f\u0000\u0000\u0405\u0407\u0003:\u001d\u0000\u0406\u0408\u0003v;"+
		"\u0000\u0407\u0406\u0001\u0000\u0000\u0000\u0408\u0409\u0001\u0000\u0000"+
		"\u0000\u0409\u0407\u0001\u0000\u0000\u0000\u0409\u040a\u0001\u0000\u0000"+
		"\u0000\u040a\u040c\u0001\u0000\u0000\u0000\u040b\u040d\u0003h4\u0000\u040c"+
		"\u040b\u0001\u0000\u0000\u0000\u040c\u040d\u0001\u0000\u0000\u0000\u040d"+
		"\u040f\u0001\u0000\u0000\u0000\u040e\u0410\u0003x<\u0000\u040f\u040e\u0001"+
		"\u0000\u0000\u0000\u040f\u0410\u0001\u0000\u0000\u0000\u0410\u0412\u0001"+
		"\u0000\u0000\u0000\u0411\u03f0\u0001\u0000\u0000\u0000\u0411\u03f5\u0001"+
		"\u0000\u0000\u0000\u0411\u0403\u0001\u0000\u0000\u0000\u0412s\u0001\u0000"+
		"\u0000\u0000\u0413\u0419\u0005?\u0000\u0000\u0414\u0417\u0003\u00d2i\u0000"+
		"\u0415\u0416\u0005L\u0000\u0000\u0416\u0418\u0003\u018c\u00c6\u0000\u0417"+
		"\u0415\u0001\u0000\u0000\u0000\u0417\u0418\u0001\u0000\u0000\u0000\u0418"+
		"\u041a\u0001\u0000\u0000\u0000\u0419\u0414\u0001\u0000\u0000\u0000\u0419"+
		"\u041a\u0001\u0000\u0000\u0000\u041a\u041b\u0001\u0000\u0000\u0000\u041b"+
		"\u041c\u0005\u000f\u0000\u0000\u041c\u041d\u0003:\u001d\u0000\u041du\u0001"+
		"\u0000\u0000\u0000\u041e\u041f\u0005?\u0000\u0000\u041f\u0420\u0005\u0014"+
		"\u0000\u0000\u0420\u0423\u0003\u00d2i\u0000\u0421\u0422\u0005L\u0000\u0000"+
		"\u0422\u0424\u0003\u018c\u00c6\u0000\u0423\u0421\u0001\u0000\u0000\u0000"+
		"\u0423\u0424\u0001\u0000\u0000\u0000\u0424\u0425\u0001\u0000\u0000\u0000"+
		"\u0425\u0426\u0005\u000f\u0000\u0000\u0426\u0427\u0003:\u001d\u0000\u0427"+
		"w\u0001\u0000\u0000\u0000\u0428\u0429\u0005D\u0000\u0000\u0429\u042a\u0005"+
		"\u000f\u0000\u0000\u042a\u042b\u0003:\u001d\u0000\u042by\u0001\u0000\u0000"+
		"\u0000\u042c\u042d\u0005\\\u0000\u0000\u042d\u042e\u0003|>\u0000\u042e"+
		"\u042f\u0005\u000f\u0000\u0000\u042f\u0430\u0005b\u0000\u0000\u0430\u0432"+
		"\u0005\u0002\u0000\u0000\u0431\u0433\u0003~?\u0000\u0432\u0431\u0001\u0000"+
		"\u0000\u0000\u0433\u0434\u0001\u0000\u0000\u0000\u0434\u0432\u0001\u0000"+
		"\u0000\u0000\u0434\u0435\u0001\u0000\u0000\u0000\u0435\u0436\u0001\u0000"+
		"\u0000\u0000\u0436\u0437\u0005\u0003\u0000\u0000\u0437{\u0001\u0000\u0000"+
		"\u0000\u0438\u0439\u0003\u00dcn\u0000\u0439\u043b\u0005\u0010\u0000\u0000"+
		"\u043a\u043c\u0003\u00dam\u0000\u043b\u043a\u0001\u0000\u0000\u0000\u043b"+
		"\u043c\u0001\u0000\u0000\u0000\u043c\u043f\u0001\u0000\u0000\u0000\u043d"+
		"\u043f\u0003\u00e0p\u0000\u043e\u0438\u0001\u0000\u0000\u0000\u043e\u043d"+
		"\u0001\u0000\u0000\u0000\u043f}\u0001\u0000\u0000\u0000\u0440\u0441\u0005"+
		"]\u0000\u0000\u0441\u0443\u0003\u0082A\u0000\u0442\u0444\u0003\u0080@"+
		"\u0000\u0443\u0442\u0001\u0000\u0000\u0000\u0443\u0444\u0001\u0000\u0000"+
		"\u0000\u0444\u0445\u0001\u0000\u0000\u0000\u0445\u0446\u0005\u000f\u0000"+
		"\u0000\u0446\u0447\u0003:\u001d\u0000\u0447\u007f\u0001\u0000\u0000\u0000"+
		"\u0448\u0449\u0005X\u0000\u0000\u0449\u044a\u0003\u00e0p\u0000\u044a\u0081"+
		"\u0001\u0000\u0000\u0000\u044b\u044e\u0003\u00aaU\u0000\u044c\u044e\u0003"+
		"\u0084B\u0000\u044d\u044b\u0001\u0000\u0000\u0000\u044d\u044c\u0001\u0000"+
		"\u0000\u0000\u044e\u0083\u0001\u0000\u0000\u0000\u044f\u0452\u0003\u0086"+
		"C\u0000\u0450\u0452\u0003\u0088D\u0000\u0451\u044f\u0001\u0000\u0000\u0000"+
		"\u0451\u0450\u0001\u0000\u0000\u0000\u0452\u0085\u0001\u0000\u0000\u0000"+
		"\u0453\u0454\u0003\u0088D\u0000\u0454\u0455\u0005L\u0000\u0000\u0455\u0456"+
		"\u0003\u009cN\u0000\u0456\u0087\u0001\u0000\u0000\u0000\u0457\u045c\u0003"+
		"\u008aE\u0000\u0458\u0459\u0005\u0016\u0000\u0000\u0459\u045b\u0003\u008a"+
		"E\u0000\u045a\u0458\u0001\u0000\u0000\u0000\u045b\u045e\u0001\u0000\u0000"+
		"\u0000\u045c\u045a\u0001\u0000\u0000\u0000\u045c\u045d\u0001\u0000\u0000"+
		"\u0000\u045d\u0089\u0001\u0000\u0000\u0000\u045e\u045c\u0001\u0000\u0000"+
		"\u0000\u045f\u0468\u0003\u008cF\u0000\u0460\u0468\u0003\u009aM\u0000\u0461"+
		"\u0468\u0003\u009eO\u0000\u0462\u0468\u0003\u00a0P\u0000\u0463\u0468\u0003"+
		"\u00a6S\u0000\u0464\u0468\u0003\u00a8T\u0000\u0465\u0468\u0003\u00b2Y"+
		"\u0000\u0466\u0468\u0003\u00ba]\u0000\u0467\u045f\u0001\u0000\u0000\u0000"+
		"\u0467\u0460\u0001\u0000\u0000\u0000\u0467\u0461\u0001\u0000\u0000\u0000"+
		"\u0467\u0462\u0001\u0000\u0000\u0000\u0467\u0463\u0001\u0000\u0000\u0000"+
		"\u0467\u0464\u0001\u0000\u0000\u0000\u0467\u0465\u0001\u0000\u0000\u0000"+
		"\u0467\u0466\u0001\u0000\u0000\u0000\u0468\u008b\u0001\u0000\u0000\u0000"+
		"\u0469\u0470\u0003\u0092I\u0000\u046a\u0470\u0003\u0090H\u0000\u046b\u0470"+
		"\u0003\u0140\u00a0\u0000\u046c\u0470\u0005=\u0000\u0000\u046d\u0470\u0005"+
		"B\u0000\u0000\u046e\u0470\u00058\u0000\u0000\u046f\u0469\u0001\u0000\u0000"+
		"\u0000\u046f\u046a\u0001\u0000\u0000\u0000\u046f\u046b\u0001\u0000\u0000"+
		"\u0000\u046f\u046c\u0001\u0000\u0000\u0000\u046f\u046d\u0001\u0000\u0000"+
		"\u0000\u046f\u046e\u0001\u0000\u0000\u0000\u0470\u008d\u0001\u0000\u0000"+
		"\u0000\u0471\u0478\u0003\u0092I\u0000\u0472\u0478\u0003\u0090H\u0000\u0473"+
		"\u0478\u0003\u0140\u00a0\u0000\u0474\u0478\u0005=\u0000\u0000\u0475\u0478"+
		"\u0005B\u0000\u0000\u0476\u0478\u00058\u0000\u0000\u0477\u0471\u0001\u0000"+
		"\u0000\u0000\u0477\u0472\u0001\u0000\u0000\u0000\u0477\u0473\u0001\u0000"+
		"\u0000\u0000\u0477\u0474\u0001\u0000\u0000\u0000\u0477\u0475\u0001\u0000"+
		"\u0000\u0000\u0477\u0476\u0001\u0000\u0000\u0000\u0478\u008f\u0001\u0000"+
		"\u0000\u0000\u0479\u047a\u0003\u0094J\u0000\u047a\u047b\u0007\u0002\u0000"+
		"\u0000\u047b\u047c\u0003\u0098L\u0000\u047c\u0091\u0001\u0000\u0000\u0000"+
		"\u047d\u047f\u0005\u0013\u0000\u0000\u047e\u047d\u0001\u0000\u0000\u0000"+
		"\u047e\u047f\u0001\u0000\u0000\u0000\u047f\u0480\u0001\u0000\u0000\u0000"+
		"\u0480\u0481\u0005`\u0000\u0000\u0481\u0093\u0001\u0000\u0000\u0000\u0482"+
		"\u0484\u0005\u0013\u0000\u0000\u0483\u0482\u0001\u0000\u0000\u0000\u0483"+
		"\u0484\u0001\u0000\u0000\u0000\u0484\u0485\u0001\u0000\u0000\u0000\u0485"+
		"\u0486\u0003\u0096K\u0000\u0486\u0095\u0001\u0000\u0000\u0000\u0487\u0488"+
		"\u0005`\u0000\u0000\u0488\u0097\u0001\u0000\u0000\u0000\u0489\u048a\u0005"+
		"`\u0000\u0000\u048a\u0099\u0001\u0000\u0000\u0000\u048b\u048c\u0003\u009c"+
		"N\u0000\u048c\u009b\u0001\u0000\u0000\u0000\u048d\u048e\u0003\u018a\u00c5"+
		"\u0000\u048e\u009d\u0001\u0000\u0000\u0000\u048f\u0490\u0005^\u0000\u0000"+
		"\u0490\u009f\u0001\u0000\u0000\u0000\u0491\u0492\u0003\u00a2Q\u0000\u0492"+
		"\u00a1\u0001\u0000\u0000\u0000\u0493\u0496\u0003\u018c\u00c6\u0000\u0494"+
		"\u0495\u0005\u000e\u0000\u0000\u0495\u0497\u0003\u018c\u00c6\u0000\u0496"+
		"\u0494\u0001\u0000\u0000\u0000\u0497\u0498\u0001\u0000\u0000\u0000\u0498"+
		"\u0496\u0001\u0000\u0000\u0000\u0498\u0499\u0001\u0000\u0000\u0000\u0499"+
		"\u00a3\u0001\u0000\u0000\u0000\u049a\u049f\u0003\u018c\u00c6\u0000\u049b"+
		"\u049c\u0005\u000e\u0000\u0000\u049c\u049e\u0003\u018c\u00c6\u0000\u049d"+
		"\u049b\u0001\u0000\u0000\u0000\u049e\u04a1\u0001\u0000\u0000\u0000\u049f"+
		"\u049d\u0001\u0000\u0000\u0000\u049f\u04a0\u0001\u0000\u0000\u0000\u04a0"+
		"\u00a5\u0001\u0000\u0000\u0000\u04a1\u049f\u0001\u0000\u0000\u0000\u04a2"+
		"\u04a3\u0005\b\u0000\u0000\u04a3\u04a4\u0003\u0084B\u0000\u04a4\u04a5"+
		"\u0005\u000b\u0000\u0000\u04a5\u00a7\u0001\u0000\u0000\u0000\u04a6\u04a8"+
		"\u0005\t\u0000\u0000\u04a7\u04a9\u0003\u00acV\u0000\u04a8\u04a7\u0001"+
		"\u0000\u0000\u0000\u04a8\u04a9\u0001\u0000\u0000\u0000\u04a9\u04aa\u0001"+
		"\u0000\u0000\u0000\u04aa\u04b1\u0005\f\u0000\u0000\u04ab\u04ad\u0005\b"+
		"\u0000\u0000\u04ac\u04ae\u0003\u00aaU\u0000\u04ad\u04ac\u0001\u0000\u0000"+
		"\u0000\u04ad\u04ae\u0001\u0000\u0000\u0000\u04ae\u04af\u0001\u0000\u0000"+
		"\u0000\u04af\u04b1\u0005\u000b\u0000\u0000\u04b0\u04a6\u0001\u0000\u0000"+
		"\u0000\u04b0\u04ab\u0001\u0000\u0000\u0000\u04b1\u00a9\u0001\u0000\u0000"+
		"\u0000\u04b2\u04b3\u0003\u00aeW\u0000\u04b3\u04b5\u0005\u0010\u0000\u0000"+
		"\u04b4\u04b6\u0003\u00acV\u0000\u04b5\u04b4\u0001\u0000\u0000\u0000\u04b5"+
		"\u04b6\u0001\u0000\u0000\u0000\u04b6\u00ab\u0001\u0000\u0000\u0000\u04b7"+
		"\u04bc\u0003\u00aeW\u0000\u04b8\u04b9\u0005\u0010\u0000\u0000\u04b9\u04bb"+
		"\u0003\u00aeW\u0000\u04ba\u04b8\u0001\u0000\u0000\u0000\u04bb\u04be\u0001"+
		"\u0000\u0000\u0000\u04bc\u04ba\u0001\u0000\u0000\u0000\u04bc\u04bd\u0001"+
		"\u0000\u0000\u0000\u04bd\u04c0\u0001\u0000\u0000\u0000\u04be\u04bc\u0001"+
		"\u0000\u0000\u0000\u04bf\u04c1\u0005\u0010\u0000\u0000\u04c0\u04bf\u0001"+
		"\u0000\u0000\u0000\u04c0\u04c1\u0001\u0000\u0000\u0000\u04c1\u00ad\u0001"+
		"\u0000\u0000\u0000\u04c2\u04c5\u0003\u00b0X\u0000\u04c3\u04c5\u0003\u0084"+
		"B\u0000\u04c4\u04c2\u0001\u0000\u0000\u0000\u04c4\u04c3\u0001\u0000\u0000"+
		"\u0000\u04c5\u00af\u0001\u0000\u0000\u0000\u04c6\u04c7\u0005\u0014\u0000"+
		"\u0000\u04c7\u04c8\u0003\u018c\u00c6\u0000\u04c8\u00b1\u0001\u0000\u0000"+
		"\u0000\u04c9\u04ca\u0005\n\u0000\u0000\u04ca\u04de\u0005\r\u0000\u0000"+
		"\u04cb\u04cc\u0005\n\u0000\u0000\u04cc\u04ce\u0003\u00b8\\\u0000\u04cd"+
		"\u04cf\u0005\u0010\u0000\u0000\u04ce\u04cd\u0001\u0000\u0000\u0000\u04ce"+
		"\u04cf\u0001\u0000\u0000\u0000\u04cf\u04d0\u0001\u0000\u0000\u0000\u04d0"+
		"\u04d1\u0005\r\u0000\u0000\u04d1\u04de\u0001\u0000\u0000\u0000\u04d2\u04d3"+
		"\u0005\n\u0000\u0000\u04d3\u04d6\u0003\u00b4Z\u0000\u04d4\u04d5\u0005"+
		"\u0010\u0000\u0000\u04d5\u04d7\u0003\u00b8\\\u0000\u04d6\u04d4\u0001\u0000"+
		"\u0000\u0000\u04d6\u04d7\u0001\u0000\u0000\u0000\u04d7\u04d9\u0001\u0000"+
		"\u0000\u0000\u04d8\u04da\u0005\u0010\u0000\u0000\u04d9\u04d8\u0001\u0000"+
		"\u0000\u0000\u04d9\u04da\u0001\u0000\u0000\u0000\u04da\u04db\u0001\u0000"+
		"\u0000\u0000\u04db\u04dc\u0005\r\u0000\u0000\u04dc\u04de\u0001\u0000\u0000"+
		"\u0000\u04dd\u04c9\u0001\u0000\u0000\u0000\u04dd\u04cb\u0001\u0000\u0000"+
		"\u0000\u04dd\u04d2\u0001\u0000\u0000\u0000\u04de\u00b3\u0001\u0000\u0000"+
		"\u0000\u04df\u04e4\u0003\u00b6[\u0000\u04e0\u04e1\u0005\u0010\u0000\u0000"+
		"\u04e1\u04e3\u0003\u00b6[\u0000\u04e2\u04e0\u0001\u0000\u0000\u0000\u04e3"+
		"\u04e6\u0001\u0000\u0000\u0000\u04e4\u04e2\u0001\u0000\u0000\u0000\u04e4"+
		"\u04e5\u0001\u0000\u0000\u0000\u04e5\u00b5\u0001\u0000\u0000\u0000\u04e6"+
		"\u04e4\u0001\u0000\u0000\u0000\u04e7\u04ea\u0003\u008eG\u0000\u04e8\u04ea"+
		"\u0003\u00a2Q\u0000\u04e9\u04e7\u0001\u0000\u0000\u0000\u04e9\u04e8\u0001"+
		"\u0000\u0000\u0000\u04ea\u04eb\u0001\u0000\u0000\u0000\u04eb\u04ec\u0005"+
		"\u000f\u0000\u0000\u04ec\u04ed\u0003\u0084B\u0000\u04ed\u00b7\u0001\u0000"+
		"\u0000\u0000\u04ee\u04ef\u0005$\u0000\u0000\u04ef\u04f0\u0003\u009cN\u0000"+
		"\u04f0\u00b9\u0001\u0000\u0000\u0000\u04f1\u04f2\u0003\u00a4R\u0000\u04f2"+
		"\u04fe\u0005\b\u0000\u0000\u04f3\u04f6\u0003\u00bc^\u0000\u04f4\u04f5"+
		"\u0005\u0010\u0000\u0000\u04f5\u04f7\u0003\u00be_\u0000\u04f6\u04f4\u0001"+
		"\u0000\u0000\u0000\u04f6\u04f7\u0001\u0000\u0000\u0000\u04f7\u04fa\u0001"+
		"\u0000\u0000\u0000\u04f8\u04fa\u0003\u00be_\u0000\u04f9\u04f3\u0001\u0000"+
		"\u0000\u0000\u04f9\u04f8\u0001\u0000\u0000\u0000\u04fa\u04fc\u0001\u0000"+
		"\u0000\u0000\u04fb\u04fd\u0005\u0010\u0000\u0000\u04fc\u04fb\u0001\u0000"+
		"\u0000\u0000\u04fc\u04fd\u0001\u0000\u0000\u0000\u04fd\u04ff\u0001\u0000"+
		"\u0000\u0000\u04fe\u04f9\u0001\u0000\u0000\u0000\u04fe\u04ff\u0001\u0000"+
		"\u0000\u0000\u04ff\u0500\u0001\u0000\u0000\u0000\u0500\u0501\u0005\u000b"+
		"\u0000\u0000\u0501\u00bb\u0001\u0000\u0000\u0000\u0502\u0507\u0003\u0084"+
		"B\u0000\u0503\u0504\u0005\u0010\u0000\u0000\u0504\u0506\u0003\u0084B\u0000"+
		"\u0505\u0503\u0001\u0000\u0000\u0000\u0506\u0509\u0001\u0000\u0000\u0000"+
		"\u0507\u0505\u0001\u0000\u0000\u0000\u0507\u0508\u0001\u0000\u0000\u0000"+
		"\u0508\u00bd\u0001\u0000\u0000\u0000\u0509\u0507\u0001\u0000\u0000\u0000"+
		"\u050a\u050f\u0003\u00c0`\u0000\u050b\u050c\u0005\u0010\u0000\u0000\u050c"+
		"\u050e\u0003\u00c0`\u0000\u050d\u050b\u0001\u0000\u0000\u0000\u050e\u0511"+
		"\u0001\u0000\u0000\u0000\u050f\u050d\u0001\u0000\u0000\u0000\u050f\u0510"+
		"\u0001\u0000\u0000\u0000\u0510\u00bf\u0001\u0000\u0000\u0000\u0511\u050f"+
		"\u0001\u0000\u0000\u0000\u0512\u0513\u0003\u018c\u00c6\u0000\u0513\u0514"+
		"\u0005\u001a\u0000\u0000\u0514\u0515\u0003\u0084B\u0000\u0515\u00c1\u0001"+
		"\u0000\u0000\u0000\u0516\u0517\u0005[\u0000\u0000\u0517\u0519\u0003\u018c"+
		"\u00c6\u0000\u0518\u051a\u0003\u00c4b\u0000\u0519\u0518\u0001\u0000\u0000"+
		"\u0000\u0519\u051a\u0001\u0000\u0000\u0000\u051a\u051b\u0001\u0000\u0000"+
		"\u0000\u051b\u051c\u0005\u001a\u0000\u0000\u051c\u051d\u0003\u00d2i\u0000"+
		"\u051d\u00c3\u0001\u0000\u0000\u0000\u051e\u051f\u0005\t\u0000\u0000\u051f"+
		"\u0520\u0003\u00c6c\u0000\u0520\u0521\u0005\f\u0000\u0000\u0521\u00c5"+
		"\u0001\u0000\u0000\u0000\u0522\u0527\u0003\u00c8d\u0000\u0523\u0524\u0005"+
		"\u0010\u0000\u0000\u0524\u0526\u0003\u00c8d\u0000\u0525\u0523\u0001\u0000"+
		"\u0000\u0000\u0526\u0529\u0001\u0000\u0000\u0000\u0527\u0525\u0001\u0000"+
		"\u0000\u0000\u0527\u0528\u0001\u0000\u0000\u0000\u0528\u052b\u0001\u0000"+
		"\u0000\u0000\u0529\u0527\u0001\u0000\u0000\u0000\u052a\u052c\u0005\u0010"+
		"\u0000\u0000\u052b\u052a\u0001\u0000\u0000\u0000\u052b\u052c\u0001\u0000"+
		"\u0000\u0000\u052c\u00c7\u0001\u0000\u0000\u0000\u052d\u052f\u0003\u018c"+
		"\u00c6\u0000\u052e\u0530\u0003\u00cae\u0000\u052f\u052e\u0001\u0000\u0000"+
		"\u0000\u052f\u0530\u0001\u0000\u0000\u0000\u0530\u0532\u0001\u0000\u0000"+
		"\u0000\u0531\u0533\u0003\u00ccf\u0000\u0532\u0531\u0001\u0000\u0000\u0000"+
		"\u0532\u0533\u0001\u0000\u0000\u0000\u0533\u053f\u0001\u0000\u0000\u0000"+
		"\u0534\u0535\u0005\u0014\u0000\u0000\u0535\u0537\u0003\u018c\u00c6\u0000"+
		"\u0536\u0538\u0003\u00ceg\u0000\u0537\u0536\u0001\u0000\u0000\u0000\u0537"+
		"\u0538\u0001\u0000\u0000\u0000\u0538\u053f\u0001\u0000\u0000\u0000\u0539"+
		"\u053a\u0005$\u0000\u0000\u053a\u053c\u0003\u018c\u00c6\u0000\u053b\u053d"+
		"\u0003\u00ccf\u0000\u053c\u053b\u0001\u0000\u0000\u0000\u053c\u053d\u0001"+
		"\u0000\u0000\u0000\u053d\u053f\u0001\u0000\u0000\u0000\u053e\u052d\u0001"+
		"\u0000\u0000\u0000\u053e\u0534\u0001\u0000\u0000\u0000\u053e\u0539\u0001"+
		"\u0000\u0000\u0000\u053f\u00c9\u0001\u0000\u0000\u0000\u0540\u0541\u0005"+
		"\u000f\u0000\u0000\u0541\u0542\u0003\u00d2i\u0000\u0542\u00cb\u0001\u0000"+
		"\u0000\u0000\u0543\u0544\u0005\u001a\u0000\u0000\u0544\u0545\u0003\u00d2"+
		"i\u0000\u0545\u00cd\u0001\u0000\u0000\u0000\u0546\u0547\u0005\u001a\u0000"+
		"\u0000\u0547\u0548\u0003\u00d8l\u0000\u0548\u00cf\u0001\u0000\u0000\u0000"+
		"\u0549\u054e\u0003\u00d2i\u0000\u054a\u054b\u0005\u0010\u0000\u0000\u054b"+
		"\u054d\u0003\u00d2i\u0000\u054c\u054a\u0001\u0000\u0000\u0000\u054d\u0550"+
		"\u0001\u0000\u0000\u0000\u054e\u054c\u0001\u0000\u0000\u0000\u054e\u054f"+
		"\u0001\u0000\u0000\u0000\u054f\u0552\u0001\u0000\u0000\u0000\u0550\u054e"+
		"\u0001\u0000\u0000\u0000\u0551\u0553\u0005\u0010\u0000\u0000\u0552\u0551"+
		"\u0001\u0000\u0000\u0000\u0552\u0553\u0001\u0000\u0000\u0000\u0553\u00d1"+
		"\u0001\u0000\u0000\u0000\u0554\u055a\u0003\u00e2q\u0000\u0555\u0556\u0005"+
		"X\u0000\u0000\u0556\u0557\u0003\u00e2q\u0000\u0557\u0558\u0005:\u0000"+
		"\u0000\u0558\u0559\u0003\u00d2i\u0000\u0559\u055b\u0001\u0000\u0000\u0000"+
		"\u055a\u0555\u0001\u0000\u0000\u0000\u055a\u055b\u0001\u0000\u0000\u0000"+
		"\u055b\u055e\u0001\u0000\u0000\u0000\u055c\u055e\u0003\u011c\u008e\u0000"+
		"\u055d\u0554\u0001\u0000\u0000\u0000\u055d\u055c\u0001\u0000\u0000\u0000"+
		"\u055e\u00d3\u0001\u0000\u0000\u0000\u055f\u0565\u0005Z\u0000\u0000\u0560"+
		"\u0561\u0005N\u0000\u0000\u0561\u0566\u0003\u00d2i\u0000\u0562\u0564\u0003"+
		"\u00d6k\u0000\u0563\u0562\u0001\u0000\u0000\u0000\u0563\u0564\u0001\u0000"+
		"\u0000\u0000\u0564\u0566\u0001\u0000\u0000\u0000\u0565\u0560\u0001\u0000"+
		"\u0000\u0000\u0565\u0563\u0001\u0000\u0000\u0000\u0566\u00d5\u0001\u0000"+
		"\u0000\u0000\u0567\u056c\u0003\u00d8l\u0000\u0568\u0569\u0005\u0010\u0000"+
		"\u0000\u0569\u056b\u0003\u00d8l\u0000\u056a\u0568\u0001\u0000\u0000\u0000"+
		"\u056b\u056e\u0001\u0000\u0000\u0000\u056c\u056a\u0001\u0000\u0000\u0000"+
		"\u056c\u056d\u0001\u0000\u0000\u0000\u056d\u0570\u0001\u0000\u0000\u0000"+
		"\u056e\u056c\u0001\u0000\u0000\u0000\u056f\u0571\u0005\u0010\u0000\u0000"+
		"\u0570\u056f\u0001\u0000\u0000\u0000\u0570\u0571\u0001\u0000\u0000\u0000"+
		"\u0571\u00d7\u0001\u0000\u0000\u0000\u0572\u0573\u0005\u0014\u0000\u0000"+
		"\u0573\u0576\u0003\u0100\u0080\u0000\u0574\u0576\u0003\u00d2i\u0000\u0575"+
		"\u0572\u0001\u0000\u0000\u0000\u0575\u0574\u0001\u0000\u0000\u0000\u0576"+
		"\u00d9\u0001\u0000\u0000\u0000\u0577\u057c\u0003\u00dcn\u0000\u0578\u0579"+
		"\u0005\u0010\u0000\u0000\u0579\u057b\u0003\u00dcn\u0000\u057a\u0578\u0001"+
		"\u0000\u0000\u0000\u057b\u057e\u0001\u0000\u0000\u0000\u057c\u057a\u0001"+
		"\u0000\u0000\u0000\u057c\u057d\u0001\u0000\u0000\u0000\u057d\u0580\u0001"+
		"\u0000\u0000\u0000\u057e\u057c\u0001\u0000\u0000\u0000\u057f\u0581\u0005"+
		"\u0010\u0000\u0000\u0580\u057f\u0001\u0000\u0000\u0000\u0580\u0581\u0001"+
		"\u0000\u0000\u0000\u0581\u00db\u0001\u0000\u0000\u0000\u0582\u0583\u0005"+
		"\u0014\u0000\u0000\u0583\u0586\u0003\u0100\u0080\u0000\u0584\u0586\u0003"+
		"\u00e0p\u0000\u0585\u0582\u0001\u0000\u0000\u0000\u0585\u0584\u0001\u0000"+
		"\u0000\u0000\u0586\u00dd\u0001\u0000\u0000\u0000\u0587\u0588\u0003\u018c"+
		"\u00c6\u0000\u0588\u0589\u00056\u0000\u0000\u0589\u058a\u0003\u00d2i\u0000"+
		"\u058a\u00df\u0001\u0000\u0000\u0000\u058b\u058e\u0003\u00deo\u0000\u058c"+
		"\u058e\u0003\u00d2i\u0000\u058d\u058b\u0001\u0000\u0000\u0000\u058d\u058c"+
		"\u0001\u0000\u0000\u0000\u058e\u00e1\u0001\u0000\u0000\u0000\u058f\u0594"+
		"\u0003\u00e4r\u0000\u0590\u0591\u0005Y\u0000\u0000\u0591\u0593\u0003\u00e4"+
		"r\u0000\u0592\u0590\u0001\u0000\u0000\u0000\u0593\u0596\u0001\u0000\u0000"+
		"\u0000\u0594\u0592\u0001\u0000\u0000\u0000\u0594\u0595\u0001\u0000\u0000"+
		"\u0000\u0595\u00e3\u0001\u0000\u0000\u0000\u0596\u0594\u0001\u0000\u0000"+
		"\u0000\u0597\u059c\u0003\u00e6s\u0000\u0598\u0599\u0005G\u0000\u0000\u0599"+
		"\u059b\u0003\u00e6s\u0000\u059a\u0598\u0001\u0000\u0000\u0000\u059b\u059e"+
		"\u0001\u0000\u0000\u0000\u059c\u059a\u0001\u0000\u0000\u0000\u059c\u059d"+
		"\u0001\u0000\u0000\u0000\u059d\u00e5\u0001\u0000\u0000\u0000\u059e\u059c"+
		"\u0001\u0000\u0000\u0000\u059f\u05a0\u0005T\u0000\u0000\u05a0\u05a3\u0003"+
		"\u00e6s\u0000\u05a1\u05a3\u0003\u00e8t\u0000\u05a2\u059f\u0001\u0000\u0000"+
		"\u0000\u05a2\u05a1\u0001\u0000\u0000\u0000\u05a3\u00e7\u0001\u0000\u0000"+
		"\u0000\u05a4\u05a8\u0003\u0100\u0080\u0000\u05a5\u05a7\u0003\u00eau\u0000"+
		"\u05a6\u05a5\u0001\u0000\u0000\u0000\u05a7\u05aa\u0001\u0000\u0000\u0000"+
		"\u05a8\u05a6\u0001\u0000\u0000\u0000\u05a8\u05a9\u0001\u0000\u0000\u0000"+
		"\u05a9\u00e9\u0001\u0000\u0000\u0000\u05aa\u05a8\u0001\u0000\u0000\u0000"+
		"\u05ab\u05b6\u0003\u00ecv\u0000\u05ac\u05b6\u0003\u00eew\u0000\u05ad\u05b6"+
		"\u0003\u00f0x\u0000\u05ae\u05b6\u0003\u00f2y\u0000\u05af\u05b6\u0003\u00f4"+
		"z\u0000\u05b0\u05b6\u0003\u00f6{\u0000\u05b1\u05b6\u0003\u00f8|\u0000"+
		"\u05b2\u05b6\u0003\u00fa}\u0000\u05b3\u05b6\u0003\u00fc~\u0000\u05b4\u05b6"+
		"\u0003\u00fe\u007f\u0000\u05b5\u05ab\u0001\u0000\u0000\u0000\u05b5\u05ac"+
		"\u0001\u0000\u0000\u0000\u05b5\u05ad\u0001\u0000\u0000\u0000\u05b5\u05ae"+
		"\u0001\u0000\u0000\u0000\u05b5\u05af\u0001\u0000\u0000\u0000\u05b5\u05b0"+
		"\u0001\u0000\u0000\u0000\u05b5\u05b1\u0001\u0000\u0000\u0000\u05b5\u05b2"+
		"\u0001\u0000\u0000\u0000\u05b5\u05b3\u0001\u0000\u0000\u0000\u05b5\u05b4"+
		"\u0001\u0000\u0000\u0000\u05b6\u00eb\u0001\u0000\u0000\u0000\u05b7\u05b8"+
		"\u0005\u001c\u0000\u0000\u05b8\u05b9\u0003\u0100\u0080\u0000\u05b9\u00ed"+
		"\u0001\u0000\u0000\u0000\u05ba\u05bb\u0005\u001d\u0000\u0000\u05bb\u05bc"+
		"\u0003\u0100\u0080\u0000\u05bc\u00ef\u0001\u0000\u0000\u0000\u05bd\u05be"+
		"\u0005\u001e\u0000\u0000\u05be\u05bf\u0003\u0100\u0080\u0000\u05bf\u00f1"+
		"\u0001\u0000\u0000\u0000\u05c0\u05c1\u0005\u0018\u0000\u0000\u05c1\u05c2"+
		"\u0003\u0100\u0080\u0000\u05c2\u00f3\u0001\u0000\u0000\u0000\u05c3\u05c4"+
		"\u0005\u001f\u0000\u0000\u05c4\u05c5\u0003\u0100\u0080\u0000\u05c5\u00f5"+
		"\u0001\u0000\u0000\u0000\u05c6\u05c7\u0005\u0019\u0000\u0000\u05c7\u05c8"+
		"\u0003\u0100\u0080\u0000\u05c8\u00f7\u0001\u0000\u0000\u0000\u05c9\u05ca"+
		"\u0005T\u0000\u0000\u05ca\u05cb\u0005@\u0000\u0000\u05cb\u05cc\u0003\u0100"+
		"\u0080\u0000\u05cc\u00f9\u0001\u0000\u0000\u0000\u05cd\u05ce\u0005@\u0000"+
		"\u0000\u05ce\u05cf\u0003\u0100\u0080\u0000\u05cf\u00fb\u0001\u0000\u0000"+
		"\u0000\u05d0\u05d1\u0005E\u0000\u0000\u05d1\u05d2\u0005T\u0000\u0000\u05d2"+
		"\u05d3\u0003\u0100\u0080\u0000\u05d3\u00fd\u0001\u0000\u0000\u0000\u05d4"+
		"\u05d5\u0005E\u0000\u0000\u05d5\u05d6\u0003\u0100\u0080\u0000\u05d6\u00ff"+
		"\u0001\u0000\u0000\u0000\u05d7\u05d8\u0006\u0080\uffff\uffff\u0000\u05d8"+
		"\u05d9\u0003\u0102\u0081\u0000\u05d9\u05df\u0001\u0000\u0000\u0000\u05da"+
		"\u05db\n\u0002\u0000\u0000\u05db\u05dc\u0005\u0016\u0000\u0000\u05dc\u05de"+
		"\u0003\u0102\u0081\u0000\u05dd\u05da\u0001\u0000\u0000\u0000\u05de\u05e1"+
		"\u0001\u0000\u0000\u0000\u05df\u05dd\u0001\u0000\u0000\u0000\u05df\u05e0"+
		"\u0001\u0000\u0000\u0000\u05e0\u0101\u0001\u0000\u0000\u0000\u05e1\u05df"+
		"\u0001\u0000\u0000\u0000\u05e2\u05e3\u0006\u0081\uffff\uffff\u0000\u05e3"+
		"\u05e4\u0003\u0104\u0082\u0000\u05e4\u05ea\u0001\u0000\u0000\u0000\u05e5"+
		"\u05e6\n\u0002\u0000\u0000\u05e6\u05e7\u0005!\u0000\u0000\u05e7\u05e9"+
		"\u0003\u0104\u0082\u0000\u05e8\u05e5\u0001\u0000\u0000\u0000\u05e9\u05ec"+
		"\u0001\u0000\u0000\u0000\u05ea\u05e8\u0001\u0000\u0000\u0000\u05ea\u05eb"+
		"\u0001\u0000\u0000\u0000\u05eb\u0103\u0001\u0000\u0000\u0000\u05ec\u05ea"+
		"\u0001\u0000\u0000\u0000\u05ed\u05ee\u0006\u0082\uffff\uffff\u0000\u05ee"+
		"\u05ef\u0003\u0106\u0083\u0000\u05ef\u05f5\u0001\u0000\u0000\u0000\u05f0"+
		"\u05f1\n\u0002\u0000\u0000\u05f1\u05f2\u0005\u0017\u0000\u0000\u05f2\u05f4"+
		"\u0003\u0106\u0083\u0000\u05f3\u05f0\u0001\u0000\u0000\u0000\u05f4\u05f7"+
		"\u0001\u0000\u0000\u0000\u05f5\u05f3\u0001\u0000\u0000\u0000\u05f5\u05f6"+
		"\u0001\u0000\u0000\u0000\u05f6\u0105\u0001\u0000\u0000\u0000\u05f7\u05f5"+
		"\u0001\u0000\u0000\u0000\u05f8\u05f9\u0006\u0083\uffff\uffff\u0000\u05f9"+
		"\u05fa\u0003\u0108\u0084\u0000\u05fa\u0600\u0001\u0000\u0000\u0000\u05fb"+
		"\u05fc\n\u0002\u0000\u0000\u05fc\u05fd\u0007\u0003\u0000\u0000\u05fd\u05ff"+
		"\u0003\u0108\u0084\u0000\u05fe\u05fb\u0001\u0000\u0000\u0000\u05ff\u0602"+
		"\u0001\u0000\u0000\u0000\u0600\u05fe\u0001\u0000\u0000\u0000\u0600\u0601"+
		"\u0001\u0000\u0000\u0000\u0601\u0107\u0001\u0000\u0000\u0000\u0602\u0600"+
		"\u0001\u0000\u0000\u0000\u0603\u0604\u0006\u0084\uffff\uffff\u0000\u0604"+
		"\u0605\u0003\u010a\u0085\u0000\u0605\u060b\u0001\u0000\u0000\u0000\u0606"+
		"\u0607\n\u0002\u0000\u0000\u0607\u0608\u0007\u0002\u0000\u0000\u0608\u060a"+
		"\u0003\u010a\u0085\u0000\u0609\u0606\u0001\u0000\u0000\u0000\u060a\u060d"+
		"\u0001\u0000\u0000\u0000\u060b\u0609\u0001\u0000\u0000\u0000\u060b\u060c"+
		"\u0001\u0000\u0000\u0000\u060c\u0109\u0001\u0000\u0000\u0000\u060d\u060b"+
		"\u0001\u0000\u0000\u0000\u060e\u060f\u0006\u0085\uffff\uffff\u0000\u060f"+
		"\u0610\u0003\u010c\u0086\u0000\u0610\u0616\u0001\u0000\u0000\u0000\u0611"+
		"\u0612\n\u0002\u0000\u0000\u0612\u0613\u0007\u0004\u0000\u0000\u0613\u0615"+
		"\u0003\u010c\u0086\u0000\u0614\u0611\u0001\u0000\u0000\u0000\u0615\u0618"+
		"\u0001\u0000\u0000\u0000\u0616\u0614\u0001\u0000\u0000\u0000\u0616\u0617"+
		"\u0001\u0000\u0000\u0000\u0617\u010b\u0001\u0000\u0000\u0000\u0618\u0616"+
		"\u0001\u0000\u0000\u0000\u0619\u061a\u0005\u0012\u0000\u0000\u061a\u0621"+
		"\u0003\u010c\u0086\u0000\u061b\u061c\u0005\u0013\u0000\u0000\u061c\u0621"+
		"\u0003\u010c\u0086\u0000\u061d\u061e\u0005 \u0000\u0000\u061e\u0621\u0003"+
		"\u010c\u0086\u0000\u061f\u0621\u0003\u010e\u0087\u0000\u0620\u0619\u0001"+
		"\u0000\u0000\u0000\u0620\u061b\u0001\u0000\u0000\u0000\u0620\u061d\u0001"+
		"\u0000\u0000\u0000\u0620\u061f\u0001\u0000\u0000\u0000\u0621\u010d\u0001"+
		"\u0000\u0000\u0000\u0622\u0625\u0003\u0110\u0088\u0000\u0623\u0624\u0005"+
		"$\u0000\u0000\u0624\u0626\u0003\u010c\u0086\u0000\u0625\u0623\u0001\u0000"+
		"\u0000\u0000\u0625\u0626\u0001\u0000\u0000\u0000\u0626\u010f\u0001\u0000"+
		"\u0000\u0000\u0627\u0628\u00059\u0000\u0000\u0628\u062b\u0003\u0112\u0089"+
		"\u0000\u0629\u062b\u0003\u0112\u0089\u0000\u062a\u0627\u0001\u0000\u0000"+
		"\u0000\u062a\u0629\u0001\u0000\u0000\u0000\u062b\u0111\u0001\u0000\u0000"+
		"\u0000\u062c\u062d\u0006\u0089\uffff\uffff\u0000\u062d\u062e\u0003\u0118"+
		"\u008c\u0000\u062e\u0640\u0001\u0000\u0000\u0000\u062f\u063c\n\u0002\u0000"+
		"\u0000\u0630\u0631\u0005\u000e\u0000\u0000\u0631\u063d\u0003\u018c\u00c6"+
		"\u0000\u0632\u063d\u0003\u015a\u00ad\u0000\u0633\u0635\u0005\b\u0000\u0000"+
		"\u0634\u0636\u0003\u015e\u00af\u0000\u0635\u0634\u0001\u0000\u0000\u0000"+
		"\u0635\u0636\u0001\u0000\u0000\u0000\u0636\u0637\u0001\u0000\u0000\u0000"+
		"\u0637\u063d\u0005\u000b\u0000\u0000\u0638\u0639\u0005\t\u0000\u0000\u0639"+
		"\u063a\u0003\u0114\u008a\u0000\u063a\u063b\u0005\f\u0000\u0000\u063b\u063d"+
		"\u0001\u0000\u0000\u0000\u063c\u0630\u0001\u0000\u0000\u0000\u063c\u0632"+
		"\u0001\u0000\u0000\u0000\u063c\u0633\u0001\u0000\u0000\u0000\u063c\u0638"+
		"\u0001\u0000\u0000\u0000\u063d\u063f\u0001\u0000\u0000\u0000\u063e\u062f"+
		"\u0001\u0000\u0000\u0000\u063f\u0642\u0001\u0000\u0000\u0000\u0640\u063e"+
		"\u0001\u0000\u0000\u0000\u0640\u0641\u0001\u0000\u0000\u0000\u0641\u0113"+
		"\u0001\u0000\u0000\u0000\u0642\u0640\u0001\u0000\u0000\u0000\u0643\u0656"+
		"\u0003\u0116\u008b\u0000\u0644\u0647\u0003\u0116\u008b\u0000\u0645\u0647"+
		"\u0003\u0168\u00b4\u0000\u0646\u0644\u0001\u0000\u0000\u0000\u0646\u0645"+
		"\u0001\u0000\u0000\u0000\u0647\u064f\u0001\u0000\u0000\u0000\u0648\u064b"+
		"\u0005\u0010\u0000\u0000\u0649\u064c\u0003\u0116\u008b\u0000\u064a\u064c"+
		"\u0003\u0168\u00b4\u0000\u064b\u0649\u0001\u0000\u0000\u0000\u064b\u064a"+
		"\u0001\u0000\u0000\u0000\u064c\u064e\u0001\u0000\u0000\u0000\u064d\u0648"+
		"\u0001\u0000\u0000\u0000\u064e\u0651\u0001\u0000\u0000\u0000\u064f\u064d"+
		"\u0001\u0000\u0000\u0000\u064f\u0650\u0001\u0000\u0000\u0000\u0650\u0653"+
		"\u0001\u0000\u0000\u0000\u0651\u064f\u0001\u0000\u0000\u0000\u0652\u0654"+
		"\u0005\u0010\u0000\u0000\u0653\u0652\u0001\u0000\u0000\u0000\u0653\u0654"+
		"\u0001\u0000\u0000\u0000\u0654\u0656\u0001\u0000\u0000\u0000\u0655\u0643"+
		"\u0001\u0000\u0000\u0000\u0655\u0646\u0001\u0000\u0000\u0000\u0656\u0115"+
		"\u0001\u0000\u0000\u0000\u0657\u0659\u0003\u00d2i\u0000\u0658\u0657\u0001"+
		"\u0000\u0000\u0000\u0658\u0659\u0001\u0000\u0000\u0000\u0659\u065a\u0001"+
		"\u0000\u0000\u0000\u065a\u065c\u0005\u000f\u0000\u0000\u065b\u065d\u0003"+
		"\u00d2i\u0000\u065c\u065b\u0001\u0000\u0000\u0000\u065c\u065d\u0001\u0000"+
		"\u0000\u0000\u065d\u0662\u0001\u0000\u0000\u0000\u065e\u0660\u0005\u000f"+
		"\u0000\u0000\u065f\u0661\u0003\u00d2i\u0000\u0660\u065f\u0001\u0000\u0000"+
		"\u0000\u0660\u0661\u0001\u0000\u0000\u0000\u0661\u0663\u0001\u0000\u0000"+
		"\u0000\u0662\u065e\u0001\u0000\u0000\u0000\u0662\u0663\u0001\u0000\u0000"+
		"\u0000\u0663\u0666\u0001\u0000\u0000\u0000\u0664\u0666\u0003\u00e0p\u0000"+
		"\u0665\u0658\u0001\u0000\u0000\u0000\u0665\u0664\u0001\u0000\u0000\u0000"+
		"\u0666\u0117\u0001\u0000\u0000\u0000\u0667\u067e\u0003\u018c\u00c6\u0000"+
		"\u0668\u067e\u0005B\u0000\u0000\u0669\u067e\u00058\u0000\u0000\u066a\u067e"+
		"\u0005=\u0000\u0000\u066b\u067e\u0003\u0140\u00a0\u0000\u066c\u067e\u0005"+
		"`\u0000\u0000\u066d\u0671\u0003\u0146\u00a3\u0000\u066e\u0671\u0003\u011a"+
		"\u008d\u0000\u066f\u0671\u0003\u015a\u00ad\u0000\u0670\u066d\u0001\u0000"+
		"\u0000\u0000\u0670\u066e\u0001\u0000\u0000\u0000\u0670\u066f\u0001\u0000"+
		"\u0000\u0000\u0671\u067e\u0001\u0000\u0000\u0000\u0672\u0675\u0003\u0144"+
		"\u00a2\u0000\u0673\u0675\u0003\u0156\u00ab\u0000\u0674\u0672\u0001\u0000"+
		"\u0000\u0000\u0674\u0673\u0001\u0000\u0000\u0000\u0675\u067e\u0001\u0000"+
		"\u0000\u0000\u0676\u067b\u0003\u014a\u00a5\u0000\u0677\u067b\u0003\u0148"+
		"\u00a4\u0000\u0678\u067b\u0003\u015c\u00ae\u0000\u0679\u067b\u0003\u0158"+
		"\u00ac\u0000\u067a\u0676\u0001\u0000\u0000\u0000\u067a\u0677\u0001\u0000"+
		"\u0000\u0000\u067a\u0678\u0001\u0000\u0000\u0000\u067a\u0679\u0001\u0000"+
		"\u0000\u0000\u067b\u067e\u0001\u0000\u0000\u0000\u067c\u067e\u00055\u0000"+
		"\u0000\u067d\u0667\u0001\u0000\u0000\u0000\u067d\u0668\u0001\u0000\u0000"+
		"\u0000\u067d\u0669\u0001\u0000\u0000\u0000\u067d\u066a\u0001\u0000\u0000"+
		"\u0000\u067d\u066b\u0001\u0000\u0000\u0000\u067d\u066c\u0001\u0000\u0000"+
		"\u0000\u067d\u0670\u0001\u0000\u0000\u0000\u067d\u0674\u0001\u0000\u0000"+
		"\u0000\u067d\u067a\u0001\u0000\u0000\u0000\u067d\u067c\u0001\u0000\u0000"+
		"\u0000\u067e\u0119\u0001\u0000\u0000\u0000\u067f\u0682\u0005\b\u0000\u0000"+
		"\u0680\u0683\u0003\u00d4j\u0000\u0681\u0683\u0003\u00e0p\u0000\u0682\u0680"+
		"\u0001\u0000\u0000\u0000\u0682\u0681\u0001\u0000\u0000\u0000\u0683\u0684"+
		"\u0001\u0000\u0000\u0000\u0684\u0685\u0005\u000b\u0000\u0000\u0685\u011b"+
		"\u0001\u0000\u0000\u0000\u0686\u0688\u0005J\u0000\u0000\u0687\u0689\u0003"+
		"\u011e\u008f\u0000\u0688\u0687\u0001\u0000\u0000\u0000\u0688\u0689\u0001"+
		"\u0000\u0000\u0000\u0689\u068a\u0001\u0000\u0000\u0000\u068a\u068b\u0005"+
		"\u000f\u0000\u0000\u068b\u068c\u0003\u00d2i\u0000\u068c\u011d\u0001\u0000"+
		"\u0000\u0000\u068d\u068e\u0003\u0120\u0090\u0000\u068e\u011f\u0001\u0000"+
		"\u0000\u0000\u068f\u0693\u0003\u0122\u0091\u0000\u0690\u0692\u0003\u012a"+
		"\u0095\u0000\u0691\u0690\u0001\u0000\u0000\u0000\u0692\u0695\u0001\u0000"+
		"\u0000\u0000\u0693\u0691\u0001\u0000\u0000\u0000\u0693\u0694\u0001\u0000"+
		"\u0000\u0000\u0694\u0699\u0001\u0000\u0000\u0000\u0695\u0693\u0001\u0000"+
		"\u0000\u0000\u0696\u0698\u0003\u012c\u0096\u0000\u0697\u0696\u0001\u0000"+
		"\u0000\u0000\u0698\u069b\u0001\u0000\u0000\u0000\u0699\u0697\u0001\u0000"+
		"\u0000\u0000\u0699\u069a\u0001\u0000\u0000\u0000\u069a\u069d\u0001\u0000"+
		"\u0000\u0000\u069b\u0699\u0001\u0000\u0000\u0000\u069c\u069e\u0003\u0126"+
		"\u0093\u0000\u069d\u069c\u0001\u0000\u0000\u0000\u069d\u069e\u0001\u0000"+
		"\u0000\u0000\u069e\u06c1\u0001\u0000\u0000\u0000\u069f\u06a3\u0003\u0124"+
		"\u0092\u0000\u06a0\u06a2\u0003\u012c\u0096\u0000\u06a1\u06a0\u0001\u0000"+
		"\u0000\u0000\u06a2\u06a5\u0001\u0000\u0000\u0000\u06a3\u06a1\u0001\u0000"+
		"\u0000\u0000\u06a3\u06a4\u0001\u0000\u0000\u0000\u06a4\u06a7\u0001\u0000"+
		"\u0000\u0000\u06a5\u06a3\u0001\u0000\u0000\u0000\u06a6\u06a8\u0003\u0126"+
		"\u0093\u0000\u06a7\u06a6\u0001\u0000\u0000\u0000\u06a7\u06a8\u0001\u0000"+
		"\u0000\u0000\u06a8\u06c1\u0001\u0000\u0000\u0000\u06a9\u06ab\u0003\u012a"+
		"\u0095\u0000\u06aa\u06a9\u0001\u0000\u0000\u0000\u06ab\u06ac\u0001\u0000"+
		"\u0000\u0000\u06ac\u06aa\u0001\u0000\u0000\u0000\u06ac\u06ad\u0001\u0000"+
		"\u0000\u0000\u06ad\u06b1\u0001\u0000\u0000\u0000\u06ae\u06b0\u0003\u012c"+
		"\u0096\u0000\u06af\u06ae\u0001\u0000\u0000\u0000\u06b0\u06b3\u0001\u0000"+
		"\u0000\u0000\u06b1\u06af\u0001\u0000\u0000\u0000\u06b1\u06b2\u0001\u0000"+
		"\u0000\u0000\u06b2\u06b5\u0001\u0000\u0000\u0000\u06b3\u06b1\u0001\u0000"+
		"\u0000\u0000\u06b4\u06b6\u0003\u0126\u0093\u0000\u06b5\u06b4\u0001\u0000"+
		"\u0000\u0000\u06b5\u06b6\u0001\u0000\u0000\u0000\u06b6\u06c1\u0001\u0000"+
		"\u0000\u0000\u06b7\u06b9\u0003\u012c\u0096\u0000\u06b8\u06b7\u0001\u0000"+
		"\u0000\u0000\u06b9\u06ba\u0001\u0000\u0000\u0000\u06ba\u06b8\u0001\u0000"+
		"\u0000\u0000\u06ba\u06bb\u0001\u0000\u0000\u0000\u06bb\u06bd\u0001\u0000"+
		"\u0000\u0000\u06bc\u06be\u0003\u0126\u0093\u0000\u06bd\u06bc\u0001\u0000"+
		"\u0000\u0000\u06bd\u06be\u0001\u0000\u0000\u0000\u06be\u06c1\u0001\u0000"+
		"\u0000\u0000\u06bf\u06c1\u0003\u0126\u0093\u0000\u06c0\u068f\u0001\u0000"+
		"\u0000\u0000\u06c0\u069f\u0001\u0000\u0000\u0000\u06c0\u06aa\u0001\u0000"+
		"\u0000\u0000\u06c0\u06b8\u0001\u0000\u0000\u0000\u06c0\u06bf\u0001\u0000"+
		"\u0000\u0000\u06c1\u0121\u0001\u0000\u0000\u0000\u06c2\u06c4\u0003\u012a"+
		"\u0095\u0000\u06c3\u06c2\u0001\u0000\u0000\u0000\u06c4\u06c5\u0001\u0000"+
		"\u0000\u0000\u06c5\u06c3\u0001\u0000\u0000\u0000\u06c5\u06c6\u0001\u0000"+
		"\u0000\u0000\u06c6\u06c7\u0001\u0000\u0000\u0000\u06c7\u06c9\u0005\u0015"+
		"\u0000\u0000\u06c8\u06ca\u0005\u0010\u0000\u0000\u06c9\u06c8\u0001\u0000"+
		"\u0000\u0000\u06c9\u06ca\u0001\u0000\u0000\u0000\u06ca\u0123\u0001\u0000"+
		"\u0000\u0000\u06cb\u06cd\u0003\u012a\u0095\u0000\u06cc\u06cb\u0001\u0000"+
		"\u0000\u0000\u06cd\u06d0\u0001\u0000\u0000\u0000\u06ce\u06cc\u0001\u0000"+
		"\u0000\u0000\u06ce\u06cf\u0001\u0000\u0000\u0000\u06cf\u06d2\u0001\u0000"+
		"\u0000\u0000\u06d0\u06ce\u0001\u0000\u0000\u0000\u06d1\u06d3\u0003\u012c"+
		"\u0096\u0000\u06d2\u06d1\u0001\u0000\u0000\u0000\u06d3\u06d4\u0001\u0000"+
		"\u0000\u0000\u06d4\u06d2\u0001\u0000\u0000\u0000\u06d4\u06d5\u0001\u0000"+
		"\u0000\u0000\u06d5\u06d6\u0001\u0000\u0000\u0000\u06d6\u06d8\u0005\u0015"+
		"\u0000\u0000\u06d7\u06d9\u0005\u0010\u0000\u0000\u06d8\u06d7\u0001\u0000"+
		"\u0000\u0000\u06d8\u06d9\u0001\u0000\u0000\u0000\u06d9\u0125\u0001\u0000"+
		"\u0000\u0000\u06da\u06db\u0005\u0014\u0000\u0000\u06db\u06df\u0003\u012a"+
		"\u0095\u0000\u06dc\u06de\u0003\u012e\u0097\u0000\u06dd\u06dc\u0001\u0000"+
		"\u0000\u0000\u06de\u06e1\u0001\u0000\u0000\u0000\u06df\u06dd\u0001\u0000"+
		"\u0000\u0000\u06df\u06e0\u0001\u0000\u0000\u0000\u06e0\u06e3\u0001\u0000"+
		"\u0000\u0000\u06e1\u06df\u0001\u0000\u0000\u0000\u06e2\u06e4\u0003\u0128"+
		"\u0094\u0000\u06e3\u06e2\u0001\u0000\u0000\u0000\u06e3\u06e4\u0001\u0000"+
		"\u0000\u0000\u06e4\u06f1\u0001\u0000\u0000\u0000\u06e5\u06e6\u0005\u0014"+
		"\u0000\u0000\u06e6\u06e8\u0005\u0010\u0000\u0000\u06e7\u06e9\u0003\u012e"+
		"\u0097\u0000\u06e8\u06e7\u0001\u0000\u0000\u0000\u06e9\u06ea\u0001\u0000"+
		"\u0000\u0000\u06ea\u06e8\u0001\u0000\u0000\u0000\u06ea\u06eb\u0001\u0000"+
		"\u0000\u0000\u06eb\u06ed\u0001\u0000\u0000\u0000\u06ec\u06ee\u0003\u0128"+
		"\u0094\u0000\u06ed\u06ec\u0001\u0000\u0000\u0000\u06ed\u06ee\u0001\u0000"+
		"\u0000\u0000\u06ee\u06f1\u0001\u0000\u0000\u0000\u06ef\u06f1\u0003\u0128"+
		"\u0094\u0000\u06f0\u06da\u0001\u0000\u0000\u0000\u06f0\u06e5\u0001\u0000"+
		"\u0000\u0000\u06f0\u06ef\u0001\u0000\u0000\u0000\u06f1\u0127\u0001\u0000"+
		"\u0000\u0000\u06f2\u06f3\u0005$\u0000\u0000\u06f3\u06f4\u0003\u012a\u0095"+
		"\u0000\u06f4\u0129\u0001\u0000\u0000\u0000\u06f5\u06f7\u0003\u0130\u0098"+
		"\u0000\u06f6\u06f8\u0005\u0010\u0000\u0000\u06f7\u06f6\u0001\u0000\u0000"+
		"\u0000\u06f7\u06f8\u0001\u0000\u0000\u0000\u06f8\u012b\u0001\u0000\u0000"+
		"\u0000\u06f9\u06fa\u0003\u0130\u0098\u0000\u06fa\u06fc\u0003b1\u0000\u06fb"+
		"\u06fd\u0005\u0010\u0000\u0000\u06fc\u06fb\u0001\u0000\u0000\u0000\u06fc"+
		"\u06fd\u0001\u0000\u0000\u0000\u06fd\u012d\u0001\u0000\u0000\u0000\u06fe"+
		"\u0700\u0003\u0130\u0098\u0000\u06ff\u0701\u0003b1\u0000\u0700\u06ff\u0001"+
		"\u0000\u0000\u0000\u0700\u0701\u0001\u0000\u0000\u0000\u0701\u0703\u0001"+
		"\u0000\u0000\u0000\u0702\u0704\u0005\u0010\u0000\u0000\u0703\u0702\u0001"+
		"\u0000\u0000\u0000\u0703\u0704\u0001\u0000\u0000\u0000\u0704\u012f\u0001"+
		"\u0000\u0000\u0000\u0705\u0706\u0003\u018c\u00c6\u0000\u0706\u0131\u0001"+
		"\u0000\u0000\u0000\u0707\u070a\u0003\u0134\u009a\u0000\u0708\u070a\u0005"+
		"\u0006\u0000\u0000\u0709\u0707\u0001\u0000\u0000\u0000\u0709\u0708\u0001"+
		"\u0000\u0000\u0000\u070a\u0133\u0001\u0000\u0000\u0000\u070b\u070c\u0005"+
		"\n\u0000\u0000\u070c\u070e\u0003\u0016\u000b\u0000\u070d\u070f\u0005\u001a"+
		"\u0000\u0000\u070e\u070d\u0001\u0000\u0000\u0000\u070e\u070f\u0001\u0000"+
		"\u0000\u0000\u070f\u0711\u0001\u0000\u0000\u0000\u0710\u0712\u0003\u0136"+
		"\u009b\u0000\u0711\u0710\u0001\u0000\u0000\u0000\u0711\u0712\u0001\u0000"+
		"\u0000\u0000\u0712\u0714\u0001\u0000\u0000\u0000\u0713\u0715\u0003\u0138"+
		"\u009c\u0000\u0714\u0713\u0001\u0000\u0000\u0000\u0714\u0715\u0001\u0000"+
		"\u0000\u0000\u0715\u0716\u0001\u0000\u0000\u0000\u0716\u0717\u0005\r\u0000"+
		"\u0000\u0717\u0135\u0001\u0000\u0000\u0000\u0718\u0719\u00057\u0000\u0000"+
		"\u0719\u071a\u0003\u018c\u00c6\u0000\u071a\u0137\u0001\u0000\u0000\u0000"+
		"\u071b\u071f\u0005\u000f\u0000\u0000\u071c\u071e\u0003\u013a\u009d\u0000"+
		"\u071d\u071c\u0001\u0000\u0000\u0000\u071e\u0721\u0001\u0000\u0000\u0000"+
		"\u071f\u071d\u0001\u0000\u0000\u0000\u071f\u0720\u0001\u0000\u0000\u0000"+
		"\u0720\u0139\u0001\u0000\u0000\u0000\u0721\u071f\u0001\u0000\u0000\u0000"+
		"\u0722\u0725\u0005\u0006\u0000\u0000\u0723\u0725\u0003\u0134\u009a\u0000"+
		"\u0724\u0722\u0001\u0000\u0000\u0000\u0724\u0723\u0001\u0000\u0000\u0000"+
		"\u0725\u013b\u0001\u0000\u0000\u0000\u0726\u072a\u0005\u0005\u0000\u0000"+
		"\u0727\u0729\u0003\u0132\u0099\u0000\u0728\u0727\u0001\u0000\u0000\u0000"+
		"\u0729\u072c\u0001\u0000\u0000\u0000\u072a\u0728\u0001\u0000\u0000\u0000"+
		"\u072a\u072b\u0001\u0000\u0000\u0000\u072b\u072d\u0001\u0000\u0000\u0000"+
		"\u072c\u072a\u0001\u0000\u0000\u0000\u072d\u072e\u0005\u0007\u0000\u0000"+
		"\u072e\u013d\u0001\u0000\u0000\u0000\u072f\u0730\u0005a\u0000\u0000\u0730"+
		"\u013f\u0001\u0000\u0000\u0000\u0731\u0733\u0003\u0142\u00a1\u0000\u0732"+
		"\u0731\u0001\u0000\u0000\u0000\u0733\u0734\u0001\u0000\u0000\u0000\u0734"+
		"\u0732\u0001\u0000\u0000\u0000\u0734\u0735\u0001\u0000\u0000\u0000\u0735"+
		"\u0141\u0001\u0000\u0000\u0000\u0736\u0739\u0003\u013c\u009e\u0000\u0737"+
		"\u0739\u0003\u013e\u009f\u0000\u0738\u0736\u0001\u0000\u0000\u0000\u0738"+
		"\u0737\u0001\u0000\u0000\u0000\u0739\u0143\u0001\u0000\u0000\u0000\u073a"+
		"\u073c\u0005\t\u0000\u0000\u073b\u073d\u0003\u00dam\u0000\u073c\u073b"+
		"\u0001\u0000\u0000\u0000\u073c\u073d\u0001\u0000\u0000\u0000\u073d\u073e"+
		"\u0001\u0000\u0000\u0000\u073e\u073f\u0005\f\u0000\u0000\u073f\u0145\u0001"+
		"\u0000\u0000\u0000\u0740\u0746\u0005\b\u0000\u0000\u0741\u0742\u0003\u00dc"+
		"n\u0000\u0742\u0744\u0005\u0010\u0000\u0000\u0743\u0745\u0003\u00dam\u0000"+
		"\u0744\u0743\u0001\u0000\u0000\u0000\u0744\u0745\u0001\u0000\u0000\u0000"+
		"\u0745\u0747\u0001\u0000\u0000\u0000\u0746\u0741\u0001\u0000\u0000\u0000"+
		"\u0746\u0747\u0001\u0000\u0000\u0000\u0747\u0748\u0001\u0000\u0000\u0000"+
		"\u0748\u0749\u0005\u000b\u0000\u0000\u0749\u0147\u0001\u0000\u0000\u0000"+
		"\u074a\u074b\u0005\n\u0000\u0000\u074b\u074c\u0003\u00dam\u0000\u074c"+
		"\u074d\u0005\r\u0000\u0000\u074d\u0149\u0001\u0000\u0000\u0000\u074e\u0750"+
		"\u0005\n\u0000\u0000\u074f\u0751\u0003\u014c\u00a6\u0000\u0750\u074f\u0001"+
		"\u0000\u0000\u0000\u0750\u0751\u0001\u0000\u0000\u0000\u0751\u0752\u0001"+
		"\u0000\u0000\u0000\u0752\u0753\u0005\r\u0000\u0000\u0753\u014b\u0001\u0000"+
		"\u0000\u0000\u0754\u0759\u0003\u014e\u00a7\u0000\u0755\u0756\u0005\u0010"+
		"\u0000\u0000\u0756\u0758\u0003\u014e\u00a7\u0000\u0757\u0755\u0001\u0000"+
		"\u0000\u0000\u0758\u075b\u0001\u0000\u0000\u0000\u0759\u0757\u0001\u0000"+
		"\u0000\u0000\u0759\u075a\u0001\u0000\u0000\u0000\u075a\u075d\u0001\u0000"+
		"\u0000\u0000\u075b\u0759\u0001\u0000\u0000\u0000\u075c\u075e\u0005\u0010"+
		"\u0000\u0000\u075d\u075c\u0001\u0000\u0000\u0000\u075d\u075e\u0001\u0000"+
		"\u0000\u0000\u075e\u014d\u0001\u0000\u0000\u0000\u075f\u0760\u0005$\u0000"+
		"\u0000\u0760\u0763\u0003\u0100\u0080\u0000\u0761\u0763\u0003\u0150\u00a8"+
		"\u0000\u0762\u075f\u0001\u0000\u0000\u0000\u0762\u0761\u0001\u0000\u0000"+
		"\u0000\u0763\u014f\u0001\u0000\u0000\u0000\u0764\u0765\u0003\u00d2i\u0000"+
		"\u0765\u0766\u0005\u000f\u0000\u0000\u0766\u0767\u0003\u00d2i\u0000\u0767"+
		"\u0151\u0001\u0000\u0000\u0000\u0768\u076a\u0003\u0154\u00aa\u0000\u0769"+
		"\u0768\u0001\u0000\u0000\u0000\u076a\u076b\u0001\u0000\u0000\u0000\u076b"+
		"\u0769\u0001\u0000\u0000\u0000\u076b\u076c\u0001\u0000\u0000\u0000\u076c"+
		"\u0153\u0001\u0000\u0000\u0000\u076d\u076f\u0005V\u0000\u0000\u076e\u076d"+
		"\u0001\u0000\u0000\u0000\u076e\u076f\u0001\u0000\u0000\u0000\u076f\u0770"+
		"\u0001\u0000\u0000\u0000\u0770\u0771\u0005I\u0000\u0000\u0771\u0772\u0003"+
		"\u016e\u00b7\u0000\u0772\u0773\u0005@\u0000\u0000\u0773\u0778\u0003\u00e2"+
		"q\u0000\u0774\u0775\u0005X\u0000\u0000\u0775\u0777\u0003\u00e2q\u0000"+
		"\u0776\u0774\u0001\u0000\u0000\u0000\u0777\u077a\u0001\u0000\u0000\u0000"+
		"\u0778\u0776\u0001\u0000\u0000\u0000\u0778\u0779\u0001\u0000\u0000\u0000"+
		"\u0779\u0155\u0001\u0000\u0000\u0000\u077a\u0778\u0001\u0000\u0000\u0000"+
		"\u077b\u077c\u0005\t\u0000\u0000\u077c\u077d\u0003\u00e0p\u0000\u077d"+
		"\u077e\u0003\u0152\u00a9\u0000\u077e\u077f\u0005\f\u0000\u0000\u077f\u0157"+
		"\u0001\u0000\u0000\u0000\u0780\u0781\u0005\n\u0000\u0000\u0781\u0782\u0003"+
		"\u00e0p\u0000\u0782\u0783\u0003\u0152\u00a9\u0000\u0783\u0784\u0005\r"+
		"\u0000\u0000\u0784\u0159\u0001\u0000\u0000\u0000\u0785\u0788\u0005\b\u0000"+
		"\u0000\u0786\u0789\u0003\u00deo\u0000\u0787\u0789\u0003\u00d2i\u0000\u0788"+
		"\u0786\u0001\u0000\u0000\u0000\u0788\u0787\u0001\u0000\u0000\u0000\u0789"+
		"\u078a\u0001\u0000\u0000\u0000\u078a\u078b\u0003\u0152\u00a9\u0000\u078b"+
		"\u078c\u0005\u000b\u0000\u0000\u078c\u015b\u0001\u0000\u0000\u0000\u078d"+
		"\u078e\u0005\n\u0000\u0000\u078e\u078f\u0003\u0150\u00a8\u0000\u078f\u0790"+
		"\u0003\u0152\u00a9\u0000\u0790\u0791\u0005\r\u0000\u0000\u0791\u015d\u0001"+
		"\u0000\u0000\u0000\u0792\u0794\u0003\u0160\u00b0\u0000\u0793\u0795\u0005"+
		"\u0010\u0000\u0000\u0794\u0793\u0001\u0000\u0000\u0000\u0794\u0795\u0001"+
		"\u0000\u0000\u0000\u0795\u015f\u0001\u0000\u0000\u0000\u0796\u079a\u0003"+
		"\u0162\u00b1\u0000\u0797\u0799\u0003\u0164\u00b2\u0000\u0798\u0797\u0001"+
		"\u0000\u0000\u0000\u0799\u079c\u0001\u0000\u0000\u0000\u079a\u0798\u0001"+
		"\u0000\u0000\u0000\u079a\u079b\u0001\u0000\u0000\u0000\u079b\u079f\u0001"+
		"\u0000\u0000\u0000\u079c\u079a\u0001\u0000\u0000\u0000\u079d\u079e\u0005"+
		"\u0010\u0000\u0000\u079e\u07a0\u0003\u0166\u00b3\u0000\u079f\u079d\u0001"+
		"\u0000\u0000\u0000\u079f\u07a0\u0001\u0000\u0000\u0000\u07a0\u07a3\u0001"+
		"\u0000\u0000\u0000\u07a1\u07a3\u0003\u0166\u00b3\u0000\u07a2\u0796\u0001"+
		"\u0000\u0000\u0000\u07a2\u07a1\u0001\u0000\u0000\u0000\u07a3\u0161\u0001"+
		"\u0000\u0000\u0000\u07a4\u07aa\u0003\u0168\u00b4\u0000\u07a5\u07a8\u0003"+
		"\u00deo\u0000\u07a6\u07a8\u0003\u00d2i\u0000\u07a7\u07a5\u0001\u0000\u0000"+
		"\u0000\u07a7\u07a6\u0001\u0000\u0000\u0000\u07a8\u07aa\u0001\u0000\u0000"+
		"\u0000\u07a9\u07a4\u0001\u0000\u0000\u0000\u07a9\u07a7\u0001\u0000\u0000"+
		"\u0000\u07aa\u0163\u0001\u0000\u0000\u0000\u07ab\u07b1\u0005\u0010\u0000"+
		"\u0000\u07ac\u07b2\u0003\u0168\u00b4\u0000\u07ad\u07b0\u0003\u00deo\u0000"+
		"\u07ae\u07b0\u0003\u00d2i\u0000\u07af\u07ad\u0001\u0000\u0000\u0000\u07af"+
		"\u07ae\u0001\u0000\u0000\u0000\u07b0\u07b2\u0001\u0000\u0000\u0000\u07b1"+
		"\u07ac\u0001\u0000\u0000\u0000\u07b1\u07af\u0001\u0000\u0000\u0000\u07b2"+
		"\u0165\u0001\u0000\u0000\u0000\u07b3\u07b8\u0003\u016a\u00b5\u0000\u07b4"+
		"\u07b5\u0005\u0010\u0000\u0000\u07b5\u07b7\u0003\u016a\u00b5\u0000\u07b6"+
		"\u07b4\u0001\u0000\u0000\u0000\u07b7\u07ba\u0001\u0000\u0000\u0000\u07b8"+
		"\u07b6\u0001\u0000\u0000\u0000\u07b8\u07b9\u0001\u0000\u0000\u0000\u07b9"+
		"\u07c4\u0001\u0000\u0000\u0000\u07ba\u07b8\u0001\u0000\u0000\u0000\u07bb"+
		"\u07bc\u0005\u0010\u0000\u0000\u07bc\u07c1\u0003\u016c\u00b6\u0000\u07bd"+
		"\u07be\u0005\u0010\u0000\u0000\u07be\u07c0\u0003\u016c\u00b6\u0000\u07bf"+
		"\u07bd\u0001\u0000\u0000\u0000\u07c0\u07c3\u0001\u0000\u0000\u0000\u07c1"+
		"\u07bf\u0001\u0000\u0000\u0000\u07c1\u07c2\u0001\u0000\u0000\u0000\u07c2"+
		"\u07c5\u0001\u0000\u0000\u0000\u07c3\u07c1\u0001\u0000\u0000\u0000\u07c4"+
		"\u07bb\u0001\u0000\u0000\u0000\u07c4\u07c5\u0001\u0000\u0000\u0000\u07c5"+
		"\u07cf\u0001\u0000\u0000\u0000\u07c6\u07cb\u0003\u016c\u00b6\u0000\u07c7"+
		"\u07c8\u0005\u0010\u0000\u0000\u07c8\u07ca\u0003\u016c\u00b6\u0000\u07c9"+
		"\u07c7\u0001\u0000\u0000\u0000\u07ca\u07cd\u0001\u0000\u0000\u0000\u07cb"+
		"\u07c9\u0001\u0000\u0000\u0000\u07cb\u07cc\u0001\u0000\u0000\u0000\u07cc"+
		"\u07cf\u0001\u0000\u0000\u0000\u07cd\u07cb\u0001\u0000\u0000\u0000\u07ce"+
		"\u07b3\u0001\u0000\u0000\u0000\u07ce\u07c6\u0001\u0000\u0000\u0000\u07cf"+
		"\u0167\u0001\u0000\u0000\u0000\u07d0\u07d1\u0005\u0014\u0000\u0000\u07d1"+
		"\u07d2\u0003\u00d2i\u0000\u07d2\u0169\u0001\u0000\u0000\u0000\u07d3\u07d4"+
		"\u0003\u018c\u00c6\u0000\u07d4\u07d5\u0005\u001a\u0000\u0000\u07d5\u07d6"+
		"\u0003\u00d2i\u0000\u07d6\u07d9\u0001\u0000\u0000\u0000\u07d7\u07d9\u0003"+
		"\u0168\u00b4\u0000\u07d8\u07d3\u0001\u0000\u0000\u0000\u07d8\u07d7\u0001"+
		"\u0000\u0000\u0000\u07d9\u016b\u0001\u0000\u0000\u0000\u07da\u07db\u0003"+
		"\u018c\u00c6\u0000\u07db\u07dc\u0005\u001a\u0000\u0000\u07dc\u07dd\u0003"+
		"\u00d2i\u0000\u07dd\u07e1\u0001\u0000\u0000\u0000\u07de\u07df\u0005$\u0000"+
		"\u0000\u07df\u07e1\u0003\u00d2i\u0000\u07e0\u07da\u0001\u0000\u0000\u0000"+
		"\u07e0\u07de\u0001\u0000\u0000\u0000\u07e1\u016d\u0001\u0000\u0000\u0000"+
		"\u07e2\u07e7\u0003\u0174\u00ba\u0000\u07e3\u07e4\u0005\u0010\u0000\u0000"+
		"\u07e4\u07e6\u0003\u0174\u00ba\u0000\u07e5\u07e3\u0001\u0000\u0000\u0000"+
		"\u07e6\u07e9\u0001\u0000\u0000\u0000\u07e7\u07e5\u0001\u0000\u0000\u0000"+
		"\u07e7\u07e8\u0001\u0000\u0000\u0000\u07e8\u07eb\u0001\u0000\u0000\u0000"+
		"\u07e9\u07e7\u0001\u0000\u0000\u0000\u07ea\u07ec\u0005\u0010\u0000\u0000"+
		"\u07eb\u07ea\u0001\u0000\u0000\u0000\u07eb\u07ec\u0001\u0000\u0000\u0000"+
		"\u07ec\u016f\u0001\u0000\u0000\u0000\u07ed\u07f2\u0003\u0174\u00ba\u0000"+
		"\u07ee\u07ef\u0005\u0010\u0000\u0000\u07ef\u07f1\u0003\u0174\u00ba\u0000"+
		"\u07f0\u07ee\u0001\u0000\u0000\u0000\u07f1\u07f4\u0001\u0000\u0000\u0000"+
		"\u07f2\u07f0\u0001\u0000\u0000\u0000\u07f2\u07f3\u0001\u0000\u0000\u0000"+
		"\u07f3\u07f6\u0001\u0000\u0000\u0000\u07f4\u07f2\u0001\u0000\u0000\u0000"+
		"\u07f5\u07f7\u0005\u0010\u0000\u0000\u07f6\u07f5\u0001\u0000\u0000\u0000"+
		"\u07f6\u07f7\u0001\u0000\u0000\u0000\u07f7\u0171\u0001\u0000\u0000\u0000"+
		"\u07f8\u0803\u0003\u0174\u00ba\u0000\u07f9\u0804\u0005\u0010\u0000\u0000"+
		"\u07fa\u07fb\u0005\u0010\u0000\u0000\u07fb\u07fd\u0003\u0174\u00ba\u0000"+
		"\u07fc\u07fa\u0001\u0000\u0000\u0000\u07fd\u07fe\u0001\u0000\u0000\u0000"+
		"\u07fe\u07fc\u0001\u0000\u0000\u0000\u07fe\u07ff\u0001\u0000\u0000\u0000"+
		"\u07ff\u0801\u0001\u0000\u0000\u0000\u0800\u0802\u0005\u0010\u0000\u0000"+
		"\u0801\u0800\u0001\u0000\u0000\u0000\u0801\u0802\u0001\u0000\u0000\u0000"+
		"\u0802\u0804\u0001\u0000\u0000\u0000\u0803\u07f9\u0001\u0000\u0000\u0000"+
		"\u0803\u07fc\u0001\u0000\u0000\u0000\u0804\u0173\u0001\u0000\u0000\u0000"+
		"\u0805\u0806\u0005\u0014\u0000\u0000\u0806\u0809\u0003\u0174\u00ba\u0000"+
		"\u0807\u0809\u0003\u0176\u00bb\u0000\u0808\u0805\u0001\u0000\u0000\u0000"+
		"\u0808\u0807\u0001\u0000\u0000\u0000\u0809\u0175\u0001\u0000\u0000\u0000"+
		"\u080a\u0811\u0003\u017e\u00bf\u0000\u080b\u080c\u0005\u000e\u0000\u0000"+
		"\u080c\u0812\u0003\u018c\u00c6\u0000\u080d\u080e\u0005\t\u0000\u0000\u080e"+
		"\u080f\u0003\u0114\u008a\u0000\u080f\u0810\u0005\f\u0000\u0000\u0810\u0812"+
		"\u0001\u0000\u0000\u0000\u0811\u080b\u0001\u0000\u0000\u0000\u0811\u080d"+
		"\u0001\u0000\u0000\u0000\u0812\u0815\u0001\u0000\u0000\u0000\u0813\u0815"+
		"\u0003\u0178\u00bc\u0000\u0814\u080a\u0001\u0000\u0000\u0000\u0814\u0813"+
		"\u0001\u0000\u0000\u0000\u0815\u0177\u0001\u0000\u0000\u0000\u0816\u0826"+
		"\u0003\u018c\u00c6\u0000\u0817\u0818\u0005\b\u0000\u0000\u0818\u0819\u0003"+
		"\u0176\u00bb\u0000\u0819\u081a\u0005\u000b\u0000\u0000\u081a\u0826\u0001"+
		"\u0000\u0000\u0000\u081b\u081d\u0005\b\u0000\u0000\u081c\u081e\u0003\u0172"+
		"\u00b9\u0000\u081d\u081c\u0001\u0000\u0000\u0000\u081d\u081e\u0001\u0000"+
		"\u0000\u0000\u081e\u081f\u0001\u0000\u0000\u0000\u081f\u0826\u0005\u000b"+
		"\u0000\u0000\u0820\u0822\u0005\t\u0000\u0000\u0821\u0823\u0003\u0170\u00b8"+
		"\u0000\u0822\u0821\u0001\u0000\u0000\u0000\u0822\u0823\u0001\u0000\u0000"+
		"\u0000\u0823\u0824\u0001\u0000\u0000\u0000\u0824\u0826\u0005\f\u0000\u0000"+
		"\u0825\u0816\u0001\u0000\u0000\u0000\u0825\u0817\u0001\u0000\u0000\u0000"+
		"\u0825\u081b\u0001\u0000\u0000\u0000\u0825\u0820\u0001\u0000\u0000\u0000"+
		"\u0826\u0179\u0001\u0000\u0000\u0000\u0827\u082e\u0003\u017c\u00be\u0000"+
		"\u0828\u082e\u0003\u018c\u00c6\u0000\u0829\u082a\u0005\b\u0000\u0000\u082a"+
		"\u082b\u0003\u017a\u00bd\u0000\u082b\u082c\u0005\u000b\u0000\u0000\u082c"+
		"\u082e\u0001\u0000\u0000\u0000\u082d\u0827\u0001\u0000\u0000\u0000\u082d"+
		"\u0828\u0001\u0000\u0000\u0000\u082d\u0829\u0001\u0000\u0000\u0000\u082e"+
		"\u017b\u0001\u0000\u0000\u0000\u082f\u0836\u0003\u017e\u00bf\u0000\u0830"+
		"\u0831\u0005\u000e\u0000\u0000\u0831\u0837\u0003\u018c\u00c6\u0000\u0832"+
		"\u0833\u0005\t\u0000\u0000\u0833\u0834\u0003\u0114\u008a\u0000\u0834\u0835"+
		"\u0005\f\u0000\u0000\u0835\u0837\u0001\u0000\u0000\u0000\u0836\u0830\u0001"+
		"\u0000\u0000\u0000\u0836\u0832\u0001\u0000\u0000\u0000\u0837\u017d\u0001"+
		"\u0000\u0000\u0000\u0838\u0839\u0006\u00bf\uffff\uffff\u0000\u0839\u083a"+
		"\u0003\u0118\u008c\u0000\u083a\u084c\u0001\u0000\u0000\u0000\u083b\u0848"+
		"\n\u0002\u0000\u0000\u083c\u083d\u0005\u000e\u0000\u0000\u083d\u0849\u0003"+
		"\u018c\u00c6\u0000\u083e\u083f\u0005\t\u0000\u0000\u083f\u0840\u0003\u0114"+
		"\u008a\u0000\u0840\u0841\u0005\f\u0000\u0000\u0841\u0849\u0001\u0000\u0000"+
		"\u0000\u0842\u0849\u0003\u015a\u00ad\u0000\u0843\u0845\u0005\b\u0000\u0000"+
		"\u0844\u0846\u0003\u015e\u00af\u0000\u0845\u0844\u0001\u0000\u0000\u0000"+
		"\u0845\u0846\u0001\u0000\u0000\u0000\u0846\u0847\u0001\u0000\u0000\u0000"+
		"\u0847\u0849\u0005\u000b\u0000\u0000\u0848\u083c\u0001\u0000\u0000\u0000"+
		"\u0848\u083e\u0001\u0000\u0000\u0000\u0848\u0842\u0001\u0000\u0000\u0000"+
		"\u0848\u0843\u0001\u0000\u0000\u0000\u0849\u084b\u0001\u0000\u0000\u0000"+
		"\u084a\u083b\u0001\u0000\u0000\u0000\u084b\u084e\u0001\u0000\u0000\u0000"+
		"\u084c\u084a\u0001\u0000\u0000\u0000\u084c\u084d\u0001\u0000\u0000\u0000"+
		"\u084d\u017f\u0001\u0000\u0000\u0000\u084e\u084c\u0001\u0000\u0000\u0000"+
		"\u084f\u0854\u0003\u0182\u00c1\u0000\u0850\u0851\u0005\u0010\u0000\u0000"+
		"\u0851\u0853\u0003\u0182\u00c1\u0000\u0852\u0850\u0001\u0000\u0000\u0000"+
		"\u0853\u0856\u0001\u0000\u0000\u0000\u0854\u0852\u0001\u0000\u0000\u0000"+
		"\u0854\u0855\u0001\u0000\u0000\u0000\u0855\u0858\u0001\u0000\u0000\u0000"+
		"\u0856\u0854\u0001\u0000\u0000\u0000\u0857\u0859\u0005\u0010\u0000\u0000"+
		"\u0858\u0857\u0001\u0000\u0000\u0000\u0858\u0859\u0001\u0000\u0000\u0000"+
		"\u0859\u0181\u0001\u0000\u0000\u0000\u085a\u0861\u0003\u017e\u00bf\u0000"+
		"\u085b\u085c\u0005\u000e\u0000\u0000\u085c\u0862\u0003\u018c\u00c6\u0000"+
		"\u085d\u085e\u0005\t\u0000\u0000\u085e\u085f\u0003\u0114\u008a\u0000\u085f"+
		"\u0860\u0005\f\u0000\u0000\u0860\u0862\u0001\u0000\u0000\u0000\u0861\u085b"+
		"\u0001\u0000\u0000\u0000\u0861\u085d\u0001\u0000\u0000\u0000\u0862\u0865"+
		"\u0001\u0000\u0000\u0000\u0863\u0865\u0003\u0184\u00c2\u0000\u0864\u085a"+
		"\u0001\u0000\u0000\u0000\u0864\u0863\u0001\u0000\u0000\u0000\u0865\u0183"+
		"\u0001\u0000\u0000\u0000\u0866\u0876\u0003\u018c\u00c6\u0000\u0867\u0868"+
		"\u0005\b\u0000\u0000\u0868\u0869\u0003\u0182\u00c1\u0000\u0869\u086a\u0005"+
		"\u000b\u0000\u0000\u086a\u0876\u0001\u0000\u0000\u0000\u086b\u086d\u0005"+
		"\b\u0000\u0000\u086c\u086e\u0003\u0180\u00c0\u0000\u086d\u086c\u0001\u0000"+
		"\u0000\u0000\u086d\u086e\u0001\u0000\u0000\u0000\u086e\u086f\u0001\u0000"+
		"\u0000\u0000\u086f\u0876\u0005\u000b\u0000\u0000\u0870\u0872\u0005\t\u0000"+
		"\u0000\u0871\u0873\u0003\u0180\u00c0\u0000\u0872\u0871\u0001\u0000\u0000"+
		"\u0000\u0872\u0873\u0001\u0000\u0000\u0000\u0873\u0874\u0001\u0000\u0000"+
		"\u0000\u0874\u0876\u0005\f\u0000\u0000\u0875\u0866\u0001\u0000\u0000\u0000"+
		"\u0875\u0867\u0001\u0000\u0000\u0000\u0875\u086b\u0001\u0000\u0000\u0000"+
		"\u0875\u0870\u0001\u0000\u0000\u0000\u0876\u0185\u0001\u0000\u0000\u0000"+
		"\u0877\u087c\u0003\u00d2i\u0000\u0878\u0879\u0005\u0010\u0000\u0000\u0879"+
		"\u087b\u0003\u00d2i\u0000\u087a\u0878\u0001\u0000\u0000\u0000\u087b\u087e"+
		"\u0001\u0000\u0000\u0000\u087c\u087a\u0001\u0000\u0000\u0000\u087c\u087d"+
		"\u0001\u0000\u0000\u0000\u087d\u088b\u0001\u0000\u0000\u0000\u087e\u087c"+
		"\u0001\u0000\u0000\u0000\u087f\u0889\u0005\u0010\u0000\u0000\u0880\u0881"+
		"\u0005\u0014\u0000\u0000\u0881\u0885\u0003\u00d2i\u0000\u0882\u0883\u0005"+
		"\u0010\u0000\u0000\u0883\u0884\u0005$\u0000\u0000\u0884\u0886\u0003\u00d2"+
		"i\u0000\u0885\u0882\u0001\u0000\u0000\u0000\u0885\u0886\u0001\u0000\u0000"+
		"\u0000\u0886\u088a\u0001\u0000\u0000\u0000\u0887\u0888\u0005$\u0000\u0000"+
		"\u0888\u088a\u0003\u00d2i\u0000\u0889\u0880\u0001\u0000\u0000\u0000\u0889"+
		"\u0887\u0001\u0000\u0000\u0000\u088a\u088c\u0001\u0000\u0000\u0000\u088b"+
		"\u087f\u0001\u0000\u0000\u0000\u088b\u088c\u0001\u0000\u0000\u0000\u088c"+
		"\u0897\u0001\u0000\u0000\u0000\u088d\u088e\u0005\u0014\u0000\u0000\u088e"+
		"\u0892\u0003\u00d2i\u0000\u088f\u0890\u0005\u0010\u0000\u0000\u0890\u0891"+
		"\u0005$\u0000\u0000\u0891\u0893\u0003\u00d2i\u0000\u0892\u088f\u0001\u0000"+
		"\u0000\u0000\u0892\u0893\u0001\u0000\u0000\u0000\u0893\u0897\u0001\u0000"+
		"\u0000\u0000\u0894\u0895\u0005$\u0000\u0000\u0895\u0897\u0003\u00d2i\u0000"+
		"\u0896\u0877\u0001\u0000\u0000\u0000\u0896\u088d\u0001\u0000\u0000\u0000"+
		"\u0896\u0894\u0001\u0000\u0000\u0000\u0897\u0187\u0001\u0000\u0000\u0000"+
		"\u0898\u0899\u0005b\u0000\u0000\u0899\u089c\u0005\u0004\u0000\u0000\u089a"+
		"\u089c\u0005\u0004\u0000\u0000\u089b\u0898\u0001\u0000\u0000\u0000\u089b"+
		"\u089a\u0001\u0000\u0000\u0000\u089c\u0189\u0001\u0000\u0000\u0000\u089d"+
		"\u089e\u0007\u0005\u0000\u0000\u089e\u018b\u0001\u0000\u0000\u0000\u089f"+
		"\u08a2\u0005^\u0000\u0000\u08a0\u08a2\u0003\u018a\u00c5\u0000\u08a1\u089f"+
		"\u0001\u0000\u0000\u0000\u08a1\u08a0\u0001\u0000\u0000\u0000\u08a2\u018d"+
		"\u0001\u0000\u0000\u0000\u0126\u018f\u0199\u01a0\u01a8\u01b0\u01b4\u01bc"+
		"\u01c3\u01c7\u01d9\u01e3\u01ea\u01f1\u01f7\u01fe\u0202\u0205\u020b\u020d"+
		"\u0211\u0217\u021d\u021f\u0227\u0230\u023c\u0240\u0249\u0254\u0258\u025d"+
		"\u0263\u026a\u0270\u0277\u027d\u0287\u0290\u0298\u029e\u02a3\u02a7\u02aa"+
		"\u02b3\u02b8\u02bc\u02c1\u02c5\u02cd\u02d1\u02d6\u02da\u02de\u02e6\u02ec"+
		"\u02f0\u02f6\u02fa\u02ff\u0304\u0308\u030d\u0310\u0313\u0318\u031c\u0321"+
		"\u0327\u032b\u0332\u0336\u033d\u0341\u0348\u034b\u034e\u0355\u0358\u035c"+
		"\u035f\u0364\u0367\u036b\u036e\u0371\u0375\u0389\u038b\u0393\u0395\u03a0"+
		"\u03a3\u03ab\u03af\u03b8\u03bc\u03c1\u03cd\u03d1\u03d8\u03e0\u03e5\u03e9"+
		"\u03ee\u03fb\u03fe\u0401\u0409\u040c\u040f\u0411\u0417\u0419\u0423\u0434"+
		"\u043b\u043e\u0443\u044d\u0451\u045c\u0467\u046f\u0477\u047e\u0483\u0498"+
		"\u049f\u04a8\u04ad\u04b0\u04b5\u04bc\u04c0\u04c4\u04ce\u04d6\u04d9\u04dd"+
		"\u04e4\u04e9\u04f6\u04f9\u04fc\u04fe\u0507\u050f\u0519\u0527\u052b\u052f"+
		"\u0532\u0537\u053c\u053e\u054e\u0552\u055a\u055d\u0563\u0565\u056c\u0570"+
		"\u0575\u057c\u0580\u0585\u058d\u0594\u059c\u05a2\u05a8\u05b5\u05df\u05ea"+
		"\u05f5\u0600\u060b\u0616\u0620\u0625\u062a\u0635\u063c\u0640\u0646\u064b"+
		"\u064f\u0653\u0655\u0658\u065c\u0660\u0662\u0665\u0670\u0674\u067a\u067d"+
		"\u0682\u0688\u0693\u0699\u069d\u06a3\u06a7\u06ac\u06b1\u06b5\u06ba\u06bd"+
		"\u06c0\u06c5\u06c9\u06ce\u06d4\u06d8\u06df\u06e3\u06ea\u06ed\u06f0\u06f7"+
		"\u06fc\u0700\u0703\u0709\u070e\u0711\u0714\u071f\u0724\u072a\u0734\u0738"+
		"\u073c\u0744\u0746\u0750\u0759\u075d\u0762\u076b\u076e\u0778\u0788\u0794"+
		"\u079a\u079f\u07a2\u07a7\u07a9\u07af\u07b1\u07b8\u07c1\u07c4\u07cb\u07ce"+
		"\u07d8\u07e0\u07e7\u07eb\u07f2\u07f6\u07fe\u0801\u0803\u0808\u0811\u0814"+
		"\u081d\u0822\u0825\u082d\u0836\u0845\u0848\u084c\u0854\u0858\u0861\u0864"+
		"\u086d\u0872\u0875\u087c\u0885\u0889\u088b\u0892\u0896\u089b\u08a1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}