// Generated from /storage/emulated/0/apktest/ANTLR4-parser-for-Python-3.13-main/PythonParser.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.python;

import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.NoViableAltException;
import org.antlr.v4.runtime.Parser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuleContext;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.VocabularyImpl;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.List;

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
		RULE_fstring = 158, RULE_string = 159, RULE_strings = 160, RULE_list = 161, 
		RULE_tuple = 162, RULE_set = 163, RULE_dict = 164, RULE_double_starred_kvpairs = 165, 
		RULE_double_starred_kvpair = 166, RULE_kvpair = 167, RULE_for_if_clauses = 168, 
		RULE_for_if_clause = 169, RULE_listcomp = 170, RULE_setcomp = 171, RULE_genexp = 172, 
		RULE_dictcomp = 173, RULE_arguments = 174, RULE_args = 175, RULE_kwargs = 176, 
		RULE_starred_expression = 177, RULE_kwarg_or_starred = 178, RULE_kwarg_or_double_starred = 179, 
		RULE_star_targets = 180, RULE_star_targets_list_seq = 181, RULE_star_targets_tuple_seq = 182, 
		RULE_star_target = 183, RULE_target_with_star_atom = 184, RULE_star_atom = 185, 
		RULE_single_target = 186, RULE_single_subscript_attribute_target = 187, 
		RULE_t_primary = 188, RULE_del_targets = 189, RULE_del_target = 190, RULE_del_t_atom = 191, 
		RULE_type_expressions = 192, RULE_func_type_comment = 193, RULE_name_except_underscore = 194, 
		RULE_name = 195;
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
			"fstring", "string", "strings", "list", "tuple", "set", "dict", "double_starred_kvpairs", 
			"double_starred_kvpair", "kvpair", "for_if_clauses", "for_if_clause", 
			"listcomp", "setcomp", "genexp", "dictcomp", "arguments", "args", "kwargs", 
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
	}

	public final File_inputContext file_input() throws RecognitionException {
		File_inputContext _localctx = new File_inputContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_file_input);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(393);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 8873217170123523872L) != 0) || ((((_la - 65)) & ~0x3f) == 0 && ((1L << (_la - 65)) & 8568960935L) != 0)) {
				{
				setState(392);
				statements();
				}
			}

			setState(395);
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
	}

	public final InteractiveContext interactive() throws RecognitionException {
		InteractiveContext _localctx = new InteractiveContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_interactive);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(397);
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
	}

	public final EvalContext eval() throws RecognitionException {
		EvalContext _localctx = new EvalContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_eval);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(399);
			expressions();
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(400);
				match(NEWLINE);
				}
				}
				setState(405);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(406);
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
	}

	public final Func_typeContext func_type() throws RecognitionException {
		Func_typeContext _localctx = new Func_typeContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_func_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(LPAR);
			setState(410);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(409);
				type_expressions();
				}
			}

			setState(412);
			match(RPAR);
			setState(413);
			match(RARROW);
			setState(414);
			expression();
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NEWLINE) {
				{
				{
				setState(415);
				match(NEWLINE);
				}
				}
				setState(420);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(421);
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
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_statements);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(424); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(423);
				statement();
				}
				}
				setState(426); 
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
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statement);
		try {
			setState(430);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(428);
				compound_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429);
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
	}

	public final Statement_newlineContext statement_newline() throws RecognitionException {
		Statement_newlineContext _localctx = new Statement_newlineContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_statement_newline);
		try {
			setState(438);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(432);
				compound_stmt();
				setState(433);
				match(NEWLINE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(435);
				simple_stmts();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(436);
				match(NEWLINE);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(437);
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
	}

	public final Simple_stmtsContext simple_stmts() throws RecognitionException {
		Simple_stmtsContext _localctx = new Simple_stmtsContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_simple_stmts);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(440);
			simple_stmt();
			setState(445);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(441);
					match(SEMI);
					setState(442);
					simple_stmt();
					}
					} 
				}
				setState(447);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(449);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(448);
				match(SEMI);
				}
			}

			setState(451);
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
	}

	public final Simple_stmtContext simple_stmt() throws RecognitionException {
		Simple_stmtContext _localctx = new Simple_stmtContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_simple_stmt);
		try {
			setState(467);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(453);
				assignment();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(454);
				type_alias();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(455);
				star_expressions();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(456);
				return_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(457);
				import_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(458);
				raise_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(459);
				match(PASS);
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(460);
				del_stmt();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(461);
				yield_stmt();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(462);
				assert_stmt();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(463);
				match(BREAK);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(464);
				match(CONTINUE);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(465);
				global_stmt();
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(466);
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
	}

	public final Compound_stmtContext compound_stmt() throws RecognitionException {
		Compound_stmtContext _localctx = new Compound_stmtContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_compound_stmt);
		try {
			setState(477);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(469);
				function_def();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(470);
				if_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(471);
				class_def();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(472);
				with_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(473);
				for_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(474);
				try_stmt();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(475);
				while_stmt();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(476);
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
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_assignment);
		int _la;
		try {
			int _alt;
			setState(519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(479);
				name();
				setState(480);
				match(COLON);
				setState(481);
				expression();
				setState(484);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(482);
					match(EQUAL);
					setState(483);
					annotated_rhs();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(491);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(486);
					match(LPAR);
					setState(487);
					single_target();
					setState(488);
					match(RPAR);
					}
					break;
				case 2:
					{
					setState(490);
					single_subscript_attribute_target();
					}
					break;
				}
				setState(493);
				match(COLON);
				setState(494);
				expression();
				setState(497);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(495);
					match(EQUAL);
					setState(496);
					annotated_rhs();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(502); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(499);
						star_targets();
						setState(500);
						match(EQUAL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(504); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(508);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(506);
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
					setState(507);
					star_expressions();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(511);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(510);
					match(TYPE_COMMENT);
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(513);
				single_target();
				setState(514);
				augassign();
				setState(517);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case YIELD:
					{
					setState(515);
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
					setState(516);
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
	}

	public final Annotated_rhsContext annotated_rhs() throws RecognitionException {
		Annotated_rhsContext _localctx = new Annotated_rhsContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_annotated_rhs);
		try {
			setState(523);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YIELD:
				enterOuterAlt(_localctx, 1);
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
				enterOuterAlt(_localctx, 2);
				{
				setState(522);
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
	}

	public final AugassignContext augassign() throws RecognitionException {
		AugassignContext _localctx = new AugassignContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_augassign);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(525);
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
	}

	public final Return_stmtContext return_stmt() throws RecognitionException {
		Return_stmtContext _localctx = new Return_stmtContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_return_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(527);
			match(RETURN);
			setState(529);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(528);
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
	}

	public final Raise_stmtContext raise_stmt() throws RecognitionException {
		Raise_stmtContext _localctx = new Raise_stmtContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_raise_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(531);
			match(RAISE);
			setState(537);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(532);
				expression();
				setState(535);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FROM) {
					{
					setState(533);
					match(FROM);
					setState(534);
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
	}

	public final Global_stmtContext global_stmt() throws RecognitionException {
		Global_stmtContext _localctx = new Global_stmtContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_global_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(539);
			match(GLOBAL);
			setState(540);
			name();
			setState(545);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(541);
				match(COMMA);
				setState(542);
				name();
				}
				}
				setState(547);
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
	}

	public final Nonlocal_stmtContext nonlocal_stmt() throws RecognitionException {
		Nonlocal_stmtContext _localctx = new Nonlocal_stmtContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_nonlocal_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(548);
			match(NONLOCAL);
			setState(549);
			name();
			setState(554);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(550);
				match(COMMA);
				setState(551);
				name();
				}
				}
				setState(556);
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
	}

	public final Del_stmtContext del_stmt() throws RecognitionException {
		Del_stmtContext _localctx = new Del_stmtContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_del_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			match(DEL);
			setState(558);
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
	}

	public final Yield_stmtContext yield_stmt() throws RecognitionException {
		Yield_stmtContext _localctx = new Yield_stmtContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_yield_stmt);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(560);
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
	}

	public final Assert_stmtContext assert_stmt() throws RecognitionException {
		Assert_stmtContext _localctx = new Assert_stmtContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_assert_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(562);
			match(ASSERT);
			setState(563);
			expression();
			setState(566);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(564);
				match(COMMA);
				setState(565);
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
	}

	public final Import_stmtContext import_stmt() throws RecognitionException {
		Import_stmtContext _localctx = new Import_stmtContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_import_stmt);
		try {
			setState(570);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
				enterOuterAlt(_localctx, 1);
				{
				setState(568);
				import_name();
				}
				break;
			case FROM:
				enterOuterAlt(_localctx, 2);
				{
				setState(569);
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
	}

	public final Import_nameContext import_name() throws RecognitionException {
		Import_nameContext _localctx = new Import_nameContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_import_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			match(IMPORT);
			setState(573);
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
	}

	public final Import_fromContext import_from() throws RecognitionException {
		Import_fromContext _localctx = new Import_fromContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_import_from);
		int _la;
		try {
			setState(594);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,29,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(575);
				match(FROM);
				setState(579);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT || _la==ELLIPSIS) {
					{
					{
					setState(576);
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
					setState(581);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(582);
				dotted_name(0);
				setState(583);
				match(IMPORT);
				setState(584);
				import_from_targets();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(586);
				match(FROM);
				setState(588); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(587);
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
					setState(590); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DOT || _la==ELLIPSIS );
				setState(592);
				match(IMPORT);
				setState(593);
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
	}

	public final Import_from_targetsContext import_from_targets() throws RecognitionException {
		Import_from_targetsContext _localctx = new Import_from_targetsContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_import_from_targets);
		int _la;
		try {
			setState(605);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(596);
				match(LPAR);
				setState(597);
				import_from_as_names();
				setState(599);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(598);
					match(COMMA);
					}
				}

				setState(601);
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
				setState(603);
				import_from_as_names();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(604);
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
	}

	public final Import_from_as_namesContext import_from_as_names() throws RecognitionException {
		Import_from_as_namesContext _localctx = new Import_from_as_namesContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_import_from_as_names);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(607);
			import_from_as_name();
			setState(612);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(608);
					match(COMMA);
					setState(609);
					import_from_as_name();
					}
					} 
				}
				setState(614);
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
	}

	public final Import_from_as_nameContext import_from_as_name() throws RecognitionException {
		Import_from_as_nameContext _localctx = new Import_from_as_nameContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_import_from_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(615);
			name();
			setState(618);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(616);
				match(AS);
				setState(617);
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
	}

	public final Dotted_as_namesContext dotted_as_names() throws RecognitionException {
		Dotted_as_namesContext _localctx = new Dotted_as_namesContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_dotted_as_names);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			dotted_as_name();
			setState(625);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(621);
				match(COMMA);
				setState(622);
				dotted_as_name();
				}
				}
				setState(627);
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
	}

	public final Dotted_as_nameContext dotted_as_name() throws RecognitionException {
		Dotted_as_nameContext _localctx = new Dotted_as_nameContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_dotted_as_name);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628);
			dotted_name(0);
			setState(631);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(629);
				match(AS);
				setState(630);
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
			setState(634);
			name();
			}
			_ctx.stop = _input.LT(-1);
			setState(641);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,36,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Dotted_nameContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_dotted_name);
					setState(636);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(637);
					match(DOT);
					setState(638);
					name();
					}
					} 
				}
				setState(643);
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
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_block);
		try {
			setState(650);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(644);
				match(NEWLINE);
				setState(645);
				match(INDENT);
				setState(646);
				statements();
				setState(647);
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
				setState(649);
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
	}

	public final DecoratorsContext decorators() throws RecognitionException {
		DecoratorsContext _localctx = new DecoratorsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_decorators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(656); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(652);
				match(AT);
				setState(653);
				named_expression();
				setState(654);
				match(NEWLINE);
				}
				}
				setState(658); 
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
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_class_def);
		try {
			setState(664);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(660);
				decorators();
				setState(661);
				class_def_raw();
				}
				break;
			case CLASS:
				enterOuterAlt(_localctx, 2);
				{
				setState(663);
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
	}

	public final Class_def_rawContext class_def_raw() throws RecognitionException {
		Class_def_rawContext _localctx = new Class_def_rawContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_class_def_raw);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			match(CLASS);
			setState(667);
			name();
			setState(669);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQB) {
				{
				setState(668);
				type_params();
				}
			}

			setState(676);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAR) {
				{
				setState(671);
				match(LPAR);
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(672);
					arguments();
					}
				}

				setState(675);
				match(RPAR);
				}
			}

			setState(678);
			match(COLON);
			setState(679);
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
	}

	public final Function_defContext function_def() throws RecognitionException {
		Function_defContext _localctx = new Function_defContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_function_def);
		try {
			setState(685);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AT:
				enterOuterAlt(_localctx, 1);
				{
				setState(681);
				decorators();
				setState(682);
				function_def_raw();
				}
				break;
			case DEF:
			case ASYNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(684);
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
	}

	public final Function_def_rawContext function_def_raw() throws RecognitionException {
		Function_def_rawContext _localctx = new Function_def_rawContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_function_def_raw);
		int _la;
		try {
			setState(728);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DEF:
				enterOuterAlt(_localctx, 1);
				{
				setState(687);
				match(DEF);
				setState(688);
				name();
				setState(690);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQB) {
					{
					setState(689);
					type_params();
					}
				}

				setState(692);
				match(LPAR);
				setState(694);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					setState(693);
					params();
					}
				}

				setState(696);
				match(RPAR);
				setState(699);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RARROW) {
					{
					setState(697);
					match(RARROW);
					setState(698);
					expression();
					}
				}

				setState(701);
				match(COLON);
				setState(703);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,47,_ctx) ) {
				case 1:
					{
					setState(702);
					func_type_comment();
					}
					break;
				}
				setState(705);
				block();
				}
				break;
			case ASYNC:
				enterOuterAlt(_localctx, 2);
				{
				setState(707);
				match(ASYNC);
				setState(708);
				match(DEF);
				setState(709);
				name();
				setState(711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LSQB) {
					{
					setState(710);
					type_params();
					}
				}

				setState(713);
				match(LPAR);
				setState(715);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					setState(714);
					params();
					}
				}

				setState(717);
				match(RPAR);
				setState(720);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==RARROW) {
					{
					setState(718);
					match(RARROW);
					setState(719);
					expression();
					}
				}

				setState(722);
				match(COLON);
				setState(724);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,51,_ctx) ) {
				case 1:
					{
					setState(723);
					func_type_comment();
					}
					break;
				}
				setState(726);
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
	}

	public final ParamsContext params() throws RecognitionException {
		ParamsContext _localctx = new ParamsContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(730);
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
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_parameters);
		int _la;
		try {
			int _alt;
			setState(781);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(732);
				slash_no_default();
				setState(736);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(733);
						param_no_default();
						}
						} 
					}
					setState(738);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,53,_ctx);
				}
				setState(742);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(739);
					param_with_default();
					}
					}
					setState(744);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(746);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(745);
					star_etc();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(748);
				slash_with_default();
				setState(752);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(749);
					param_with_default();
					}
					}
					setState(754);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(756);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(755);
					star_etc();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(759); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(758);
						param_no_default();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(761); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(766);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(763);
					param_with_default();
					}
					}
					setState(768);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(770);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(769);
					star_etc();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(773); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(772);
					param_with_default();
					}
					}
					setState(775); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(778);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(777);
					star_etc();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(780);
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
	}

	public final Slash_no_defaultContext slash_no_default() throws RecognitionException {
		Slash_no_defaultContext _localctx = new Slash_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_slash_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(784); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(783);
				param_no_default();
				}
				}
				setState(786); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(788);
			match(SLASH);
			setState(790);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(789);
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
	}

	public final Slash_with_defaultContext slash_with_default() throws RecognitionException {
		Slash_with_defaultContext _localctx = new Slash_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_slash_with_default);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(795);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(792);
					param_no_default();
					}
					} 
				}
				setState(797);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,66,_ctx);
			}
			setState(799); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(798);
				param_with_default();
				}
				}
				setState(801); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(803);
			match(SLASH);
			setState(805);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(804);
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
	}

	public final Star_etcContext star_etc() throws RecognitionException {
		Star_etcContext _localctx = new Star_etcContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_star_etc);
		int _la;
		try {
			setState(840);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,75,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(807);
				match(STAR);
				setState(808);
				param_no_default();
				setState(812);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(809);
					param_maybe_default();
					}
					}
					setState(814);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(816);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(815);
					kwds();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(818);
				match(STAR);
				setState(819);
				param_no_default_star_annotation();
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(820);
					param_maybe_default();
					}
					}
					setState(825);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(827);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(826);
					kwds();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(829);
				match(STAR);
				setState(830);
				match(COMMA);
				setState(832); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(831);
					param_maybe_default();
					}
					}
					setState(834); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(837);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(836);
					kwds();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(839);
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
	}

	public final KwdsContext kwds() throws RecognitionException {
		KwdsContext _localctx = new KwdsContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_kwds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(842);
			match(DOUBLESTAR);
			setState(843);
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
	}

	public final Param_no_defaultContext param_no_default() throws RecognitionException {
		Param_no_defaultContext _localctx = new Param_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_param_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(845);
			param();
			setState(847);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(846);
				match(COMMA);
				}
			}

			setState(850);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(849);
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
	}

	public final Param_no_default_star_annotationContext param_no_default_star_annotation() throws RecognitionException {
		Param_no_default_star_annotationContext _localctx = new Param_no_default_star_annotationContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_param_no_default_star_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			param_star_annotation();
			setState(854);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(853);
				match(COMMA);
				}
			}

			setState(857);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(856);
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
	}

	public final Param_with_defaultContext param_with_default() throws RecognitionException {
		Param_with_defaultContext _localctx = new Param_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_param_with_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(859);
			param();
			setState(860);
			default_assignment();
			setState(862);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(861);
				match(COMMA);
				}
			}

			setState(865);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(864);
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
	}

	public final Param_maybe_defaultContext param_maybe_default() throws RecognitionException {
		Param_maybe_defaultContext _localctx = new Param_maybe_defaultContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_param_maybe_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(867);
			param();
			setState(869);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(868);
				default_assignment();
				}
			}

			setState(872);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(871);
				match(COMMA);
				}
			}

			setState(875);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(874);
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
	}

	public final ParamContext param() throws RecognitionException {
		ParamContext _localctx = new ParamContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_param);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(877);
			name();
			setState(879);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(878);
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
	}

	public final Param_star_annotationContext param_star_annotation() throws RecognitionException {
		Param_star_annotationContext _localctx = new Param_star_annotationContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_param_star_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(881);
			name();
			setState(882);
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
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(884);
			match(COLON);
			setState(885);
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
	}

	public final Star_annotationContext star_annotation() throws RecognitionException {
		Star_annotationContext _localctx = new Star_annotationContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_star_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(887);
			match(COLON);
			setState(888);
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
	}

	public final Default_assignmentContext default_assignment() throws RecognitionException {
		Default_assignmentContext _localctx = new Default_assignmentContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_default_assignment);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(890);
			match(EQUAL);
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
	}

	public final If_stmtContext if_stmt() throws RecognitionException {
		If_stmtContext _localctx = new If_stmtContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_if_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(893);
			match(IF);
			setState(894);
			named_expression();
			setState(895);
			match(COLON);
			setState(896);
			block();
			setState(901);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELIF:
				{
				setState(897);
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
				setState(899);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(898);
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
	}

	public final Elif_stmtContext elif_stmt() throws RecognitionException {
		Elif_stmtContext _localctx = new Elif_stmtContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_elif_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(903);
			match(ELIF);
			setState(904);
			named_expression();
			setState(905);
			match(COLON);
			setState(906);
			block();
			setState(911);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ELIF:
				{
				setState(907);
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
				setState(909);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(908);
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
	}

	public final Else_blockContext else_block() throws RecognitionException {
		Else_blockContext _localctx = new Else_blockContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_else_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(913);
			match(ELSE);
			setState(914);
			match(COLON);
			setState(915);
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
	}

	public final While_stmtContext while_stmt() throws RecognitionException {
		While_stmtContext _localctx = new While_stmtContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_while_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(917);
			match(WHILE);
			setState(918);
			named_expression();
			setState(919);
			match(COLON);
			setState(920);
			block();
			setState(922);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(921);
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
	}

	public final For_stmtContext for_stmt() throws RecognitionException {
		For_stmtContext _localctx = new For_stmtContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_for_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(925);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(924);
				match(ASYNC);
				}
			}

			setState(927);
			match(FOR);
			setState(928);
			star_targets();
			setState(929);
			match(IN);
			setState(930);
			star_expressions();
			setState(931);
			match(COLON);
			setState(933);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TYPE_COMMENT) {
				{
				setState(932);
				match(TYPE_COMMENT);
				}
			}

			setState(935);
			block();
			setState(937);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(936);
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
	}

	public final With_stmtContext with_stmt() throws RecognitionException {
		With_stmtContext _localctx = new With_stmtContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_with_stmt);
		int _la;
		try {
			int _alt;
			setState(995);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(939);
				match(WITH);
				setState(940);
				match(LPAR);
				setState(941);
				with_item();
				setState(946);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(942);
						match(COMMA);
						setState(943);
						with_item();
						}
						} 
					}
					setState(948);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,94,_ctx);
				}
				setState(950);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(949);
					match(COMMA);
					}
				}

				setState(952);
				match(RPAR);
				setState(953);
				match(COLON);
				setState(955);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(954);
					match(TYPE_COMMENT);
					}
				}

				setState(957);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(959);
				match(ASYNC);
				setState(960);
				match(WITH);
				setState(961);
				match(LPAR);
				setState(962);
				with_item();
				setState(967);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(963);
						match(COMMA);
						setState(964);
						with_item();
						}
						} 
					}
					setState(969);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,97,_ctx);
				}
				setState(971);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(970);
					match(COMMA);
					}
				}

				setState(973);
				match(RPAR);
				setState(974);
				match(COLON);
				setState(975);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(978);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASYNC) {
					{
					setState(977);
					match(ASYNC);
					}
				}

				setState(980);
				match(WITH);
				setState(981);
				with_item();
				setState(986);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(982);
					match(COMMA);
					setState(983);
					with_item();
					}
					}
					setState(988);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(989);
				match(COLON);
				setState(991);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TYPE_COMMENT) {
					{
					setState(990);
					match(TYPE_COMMENT);
					}
				}

				setState(993);
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
	}

	public final With_itemContext with_item() throws RecognitionException {
		With_itemContext _localctx = new With_itemContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_with_item);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(997);
			expression();
			setState(1000);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(998);
				match(AS);
				setState(999);
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
	}

	public final Try_stmtContext try_stmt() throws RecognitionException {
		Try_stmtContext _localctx = new Try_stmtContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_try_stmt);
		int _la;
		try {
			setState(1035);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,110,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1002);
				match(TRY);
				setState(1003);
				match(COLON);
				setState(1004);
				block();
				setState(1005);
				finally_block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1007);
				match(TRY);
				setState(1008);
				match(COLON);
				setState(1009);
				block();
				setState(1011); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1010);
					except_block();
					}
					}
					setState(1013); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(1016);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1015);
					else_block();
					}
				}

				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1018);
					finally_block();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1021);
				match(TRY);
				setState(1022);
				match(COLON);
				setState(1023);
				block();
				setState(1025); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1024);
					except_star_block();
					}
					}
					setState(1027); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==EXCEPT );
				setState(1030);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ELSE) {
					{
					setState(1029);
					else_block();
					}
				}

				setState(1033);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1032);
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
	}

	public final Except_blockContext except_block() throws RecognitionException {
		Except_blockContext _localctx = new Except_blockContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_except_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1037);
			match(EXCEPT);
			setState(1043);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1038);
				expression();
				setState(1041);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==AS) {
					{
					setState(1039);
					match(AS);
					setState(1040);
					name();
					}
				}

				}
			}

			setState(1045);
			match(COLON);
			setState(1046);
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
	}

	public final Except_star_blockContext except_star_block() throws RecognitionException {
		Except_star_blockContext _localctx = new Except_star_blockContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_except_star_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1048);
			match(EXCEPT);
			setState(1049);
			match(STAR);
			setState(1050);
			expression();
			setState(1053);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(1051);
				match(AS);
				setState(1052);
				name();
				}
			}

			setState(1055);
			match(COLON);
			setState(1056);
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
	}

	public final Finally_blockContext finally_block() throws RecognitionException {
		Finally_blockContext _localctx = new Finally_blockContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_finally_block);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1058);
			match(FINALLY);
			setState(1059);
			match(COLON);
			setState(1060);
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
	}

	public final Match_stmtContext match_stmt() throws RecognitionException {
		Match_stmtContext _localctx = new Match_stmtContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_match_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1062);
			match(NAME_OR_MATCH);
			setState(1063);
			subject_expr();
			setState(1064);
			match(COLON);
			setState(1065);
			match(NEWLINE);
			setState(1066);
			match(INDENT);
			setState(1068); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1067);
				case_block();
				}
				}
				setState(1070); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==NAME_OR_CASE );
			setState(1072);
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
	}

	public final Subject_exprContext subject_expr() throws RecognitionException {
		Subject_exprContext _localctx = new Subject_exprContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_subject_expr);
		int _la;
		try {
			setState(1080);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,116,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1074);
				star_named_expression();
				setState(1075);
				match(COMMA);
				setState(1077);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1076);
					star_named_expressions();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1079);
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
	}

	public final Case_blockContext case_block() throws RecognitionException {
		Case_blockContext _localctx = new Case_blockContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_case_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1082);
			match(NAME_OR_CASE);
			setState(1083);
			patterns();
			setState(1085);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IF) {
				{
				setState(1084);
				guard();
				}
			}

			setState(1087);
			match(COLON);
			setState(1088);
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
	}

	public final GuardContext guard() throws RecognitionException {
		GuardContext _localctx = new GuardContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_guard);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1090);
			match(IF);
			setState(1091);
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
	}

	public final PatternsContext patterns() throws RecognitionException {
		PatternsContext _localctx = new PatternsContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_patterns);
		try {
			setState(1095);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1093);
				open_sequence_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1094);
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
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_pattern);
		try {
			setState(1099);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,119,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1097);
				as_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1098);
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
	}

	public final As_patternContext as_pattern() throws RecognitionException {
		As_patternContext _localctx = new As_patternContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_as_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1101);
			or_pattern();
			setState(1102);
			match(AS);
			setState(1103);
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
	}

	public final Or_patternContext or_pattern() throws RecognitionException {
		Or_patternContext _localctx = new Or_patternContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_or_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1105);
			closed_pattern();
			setState(1110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==VBAR) {
				{
				{
				setState(1106);
				match(VBAR);
				setState(1107);
				closed_pattern();
				}
				}
				setState(1112);
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
	}

	public final Closed_patternContext closed_pattern() throws RecognitionException {
		Closed_patternContext _localctx = new Closed_patternContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_closed_pattern);
		try {
			setState(1121);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,121,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1113);
				literal_pattern();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1114);
				capture_pattern();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1115);
				wildcard_pattern();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1116);
				value_pattern();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1117);
				group_pattern();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1118);
				sequence_pattern();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1119);
				mapping_pattern();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1120);
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
	}

	public final Literal_patternContext literal_pattern() throws RecognitionException {
		Literal_patternContext _localctx = new Literal_patternContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_literal_pattern);
		try {
			setState(1129);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,122,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1123);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1124);
				complex_number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1125);
				strings();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1126);
				match(NONE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1127);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1128);
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
	}

	public final Literal_exprContext literal_expr() throws RecognitionException {
		Literal_exprContext _localctx = new Literal_exprContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_literal_expr);
		try {
			setState(1137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1131);
				signed_number();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1132);
				complex_number();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1133);
				strings();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1134);
				match(NONE);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1135);
				match(TRUE);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1136);
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
	}

	public final Complex_numberContext complex_number() throws RecognitionException {
		Complex_numberContext _localctx = new Complex_numberContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_complex_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1139);
			signed_real_number();
			setState(1140);
			_la = _input.LA(1);
			if ( !(_la==PLUS || _la==MINUS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1141);
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
	}

	public final Signed_numberContext signed_number() throws RecognitionException {
		Signed_numberContext _localctx = new Signed_numberContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_signed_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(1143);
				match(MINUS);
				}
			}

			setState(1146);
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
	}

	public final Signed_real_numberContext signed_real_number() throws RecognitionException {
		Signed_real_numberContext _localctx = new Signed_real_numberContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_signed_real_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MINUS) {
				{
				setState(1148);
				match(MINUS);
				}
			}

			setState(1151);
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
	}

	public final Real_numberContext real_number() throws RecognitionException {
		Real_numberContext _localctx = new Real_numberContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_real_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1153);
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
	}

	public final Imaginary_numberContext imaginary_number() throws RecognitionException {
		Imaginary_numberContext _localctx = new Imaginary_numberContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_imaginary_number);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1155);
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
	}

	public final Capture_patternContext capture_pattern() throws RecognitionException {
		Capture_patternContext _localctx = new Capture_patternContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_capture_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1157);
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
	}

	public final Pattern_capture_targetContext pattern_capture_target() throws RecognitionException {
		Pattern_capture_targetContext _localctx = new Pattern_capture_targetContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_pattern_capture_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1159);
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
	}

	public final Wildcard_patternContext wildcard_pattern() throws RecognitionException {
		Wildcard_patternContext _localctx = new Wildcard_patternContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_wildcard_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1161);
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
	}

	public final Value_patternContext value_pattern() throws RecognitionException {
		Value_patternContext _localctx = new Value_patternContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_value_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1163);
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
	}

	public final AttrContext attr() throws RecognitionException {
		AttrContext _localctx = new AttrContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1165);
			name();
			setState(1168); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1166);
				match(DOT);
				setState(1167);
				name();
				}
				}
				setState(1170); 
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
	}

	public final Name_or_attrContext name_or_attr() throws RecognitionException {
		Name_or_attrContext _localctx = new Name_or_attrContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_name_or_attr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1172);
			name();
			setState(1177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==DOT) {
				{
				{
				setState(1173);
				match(DOT);
				setState(1174);
				name();
				}
				}
				setState(1179);
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
	}

	public final Group_patternContext group_pattern() throws RecognitionException {
		Group_patternContext _localctx = new Group_patternContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_group_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1180);
			match(LPAR);
			setState(1181);
			pattern();
			setState(1182);
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
	}

	public final Sequence_patternContext sequence_pattern() throws RecognitionException {
		Sequence_patternContext _localctx = new Sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_sequence_pattern);
		int _la;
		try {
			setState(1194);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LSQB:
				enterOuterAlt(_localctx, 1);
				{
				setState(1184);
				match(LSQB);
				setState(1186);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603253196576L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(1185);
					maybe_sequence_pattern();
					}
				}

				setState(1188);
				match(RSQB);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1189);
				match(LPAR);
				setState(1191);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603253196576L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(1190);
					open_sequence_pattern();
					}
				}

				setState(1193);
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
	}

	public final Open_sequence_patternContext open_sequence_pattern() throws RecognitionException {
		Open_sequence_patternContext _localctx = new Open_sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_open_sequence_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1196);
			maybe_star_pattern();
			setState(1197);
			match(COMMA);
			setState(1199);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603253196576L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
				{
				setState(1198);
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
	}

	public final Maybe_sequence_patternContext maybe_sequence_pattern() throws RecognitionException {
		Maybe_sequence_patternContext _localctx = new Maybe_sequence_patternContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_maybe_sequence_pattern);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1201);
			maybe_star_pattern();
			setState(1206);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1202);
					match(COMMA);
					setState(1203);
					maybe_star_pattern();
					}
					} 
				}
				setState(1208);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(1210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1209);
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
	}

	public final Maybe_star_patternContext maybe_star_pattern() throws RecognitionException {
		Maybe_star_patternContext _localctx = new Maybe_star_patternContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_maybe_star_pattern);
		try {
			setState(1214);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1212);
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
				setState(1213);
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
	}

	public final Star_patternContext star_pattern() throws RecognitionException {
		Star_patternContext _localctx = new Star_patternContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_star_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1216);
			match(STAR);
			setState(1217);
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
	}

	public final Mapping_patternContext mapping_pattern() throws RecognitionException {
		Mapping_patternContext _localctx = new Mapping_patternContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_mapping_pattern);
		int _la;
		try {
			setState(1239);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1219);
				match(LBRACE);
				setState(1220);
				match(RBRACE);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1221);
				match(LBRACE);
				setState(1222);
				double_star_pattern();
				setState(1224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1223);
					match(COMMA);
					}
				}

				setState(1226);
				match(RBRACE);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1228);
				match(LBRACE);
				setState(1229);
				items_pattern();
				setState(1232);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1230);
					match(COMMA);
					setState(1231);
					double_star_pattern();
					}
					break;
				}
				setState(1235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1234);
					match(COMMA);
					}
				}

				setState(1237);
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
	}

	public final Items_patternContext items_pattern() throws RecognitionException {
		Items_patternContext _localctx = new Items_patternContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_items_pattern);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1241);
			key_value_pattern();
			setState(1246);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,139,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1242);
					match(COMMA);
					setState(1243);
					key_value_pattern();
					}
					} 
				}
				setState(1248);
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
	}

	public final Key_value_patternContext key_value_pattern() throws RecognitionException {
		Key_value_patternContext _localctx = new Key_value_patternContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_key_value_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1251);
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
				setState(1249);
				literal_expr();
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				{
				setState(1250);
				attr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1253);
			match(COLON);
			setState(1254);
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
	}

	public final Double_star_patternContext double_star_pattern() throws RecognitionException {
		Double_star_patternContext _localctx = new Double_star_patternContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_double_star_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1256);
			match(DOUBLESTAR);
			setState(1257);
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
	}

	public final Class_patternContext class_pattern() throws RecognitionException {
		Class_patternContext _localctx = new Class_patternContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_class_pattern);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1259);
			name_or_attr();
			setState(1260);
			match(LPAR);
			setState(1272);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2377900603252148000L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
				{
				setState(1267);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,142,_ctx) ) {
				case 1:
					{
					setState(1261);
					positional_patterns();
					setState(1264);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,141,_ctx) ) {
					case 1:
						{
						setState(1262);
						match(COMMA);
						setState(1263);
						keyword_patterns();
						}
						break;
					}
					}
					break;
				case 2:
					{
					setState(1266);
					keyword_patterns();
					}
					break;
				}
				setState(1270);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1269);
					match(COMMA);
					}
				}

				}
			}

			setState(1274);
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
	}

	public final Positional_patternsContext positional_patterns() throws RecognitionException {
		Positional_patternsContext _localctx = new Positional_patternsContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_positional_patterns);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1276);
			pattern();
			setState(1281);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,145,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1277);
					match(COMMA);
					setState(1278);
					pattern();
					}
					} 
				}
				setState(1283);
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
	}

	public final Keyword_patternsContext keyword_patterns() throws RecognitionException {
		Keyword_patternsContext _localctx = new Keyword_patternsContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_keyword_patterns);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1284);
			keyword_pattern();
			setState(1289);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,146,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1285);
					match(COMMA);
					setState(1286);
					keyword_pattern();
					}
					} 
				}
				setState(1291);
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
	}

	public final Keyword_patternContext keyword_pattern() throws RecognitionException {
		Keyword_patternContext _localctx = new Keyword_patternContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_keyword_pattern);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1292);
			name();
			setState(1293);
			match(EQUAL);
			setState(1294);
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
	}

	public final Type_aliasContext type_alias() throws RecognitionException {
		Type_aliasContext _localctx = new Type_aliasContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_type_alias);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1296);
			match(NAME_OR_TYPE);
			setState(1297);
			name();
			setState(1299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LSQB) {
				{
				setState(1298);
				type_params();
				}
			}

			setState(1301);
			match(EQUAL);
			setState(1302);
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
	}

	public final Type_paramsContext type_params() throws RecognitionException {
		Type_paramsContext _localctx = new Type_paramsContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_type_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1304);
			match(LSQB);
			setState(1305);
			type_param_seq();
			setState(1306);
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
	}

	public final Type_param_seqContext type_param_seq() throws RecognitionException {
		Type_param_seqContext _localctx = new Type_param_seqContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_type_param_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1308);
			type_param();
			setState(1313);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1309);
					match(COMMA);
					setState(1310);
					type_param();
					}
					} 
				}
				setState(1315);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,148,_ctx);
			}
			setState(1317);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1316);
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
	}

	public final Type_paramContext type_param() throws RecognitionException {
		Type_paramContext _localctx = new Type_paramContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_type_param);
		int _la;
		try {
			setState(1336);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1319);
				name();
				setState(1321);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1320);
					type_param_bound();
					}
				}

				setState(1324);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1323);
					type_param_default();
					}
				}

				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1326);
				match(STAR);
				setState(1327);
				name();
				setState(1329);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1328);
					type_param_starred_default();
					}
				}

				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(1331);
				match(DOUBLESTAR);
				setState(1332);
				name();
				setState(1334);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(1333);
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
	}

	public final Type_param_boundContext type_param_bound() throws RecognitionException {
		Type_param_boundContext _localctx = new Type_param_boundContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_type_param_bound);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1338);
			match(COLON);
			setState(1339);
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
	}

	public final Type_param_defaultContext type_param_default() throws RecognitionException {
		Type_param_defaultContext _localctx = new Type_param_defaultContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_type_param_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1341);
			match(EQUAL);
			setState(1342);
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
	}

	public final Type_param_starred_defaultContext type_param_starred_default() throws RecognitionException {
		Type_param_starred_defaultContext _localctx = new Type_param_starred_defaultContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_type_param_starred_default);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1344);
			match(EQUAL);
			setState(1345);
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
	}

	public final ExpressionsContext expressions() throws RecognitionException {
		ExpressionsContext _localctx = new ExpressionsContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1347);
			expression();
			setState(1352);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1348);
					match(COMMA);
					setState(1349);
					expression();
					}
					} 
				}
				setState(1354);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,155,_ctx);
			}
			setState(1356);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1355);
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
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_expression);
		int _la;
		try {
			setState(1367);
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
				setState(1358);
				disjunction();
				setState(1364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IF) {
					{
					setState(1359);
					match(IF);
					setState(1360);
					disjunction();
					setState(1361);
					match(ELSE);
					setState(1362);
					expression();
					}
				}

				}
				break;
			case LAMBDA:
				enterOuterAlt(_localctx, 2);
				{
				setState(1366);
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
	}

	public final Yield_exprContext yield_expr() throws RecognitionException {
		Yield_exprContext _localctx = new Yield_exprContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_yield_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			match(YIELD);
			setState(1375);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FROM:
				{
				setState(1370);
				match(FROM);
				setState(1371);
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
				setState(1373);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1372);
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
	}

	public final Star_expressionsContext star_expressions() throws RecognitionException {
		Star_expressionsContext _localctx = new Star_expressionsContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_star_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1377);
			star_expression();
			setState(1382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1378);
					match(COMMA);
					setState(1379);
					star_expression();
					}
					} 
				}
				setState(1384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,161,_ctx);
			}
			setState(1386);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1385);
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
	}

	public final Star_expressionContext star_expression() throws RecognitionException {
		Star_expressionContext _localctx = new Star_expressionContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_star_expression);
		try {
			setState(1391);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1388);
				match(STAR);
				setState(1389);
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
				setState(1390);
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
	}

	public final Star_named_expressionsContext star_named_expressions() throws RecognitionException {
		Star_named_expressionsContext _localctx = new Star_named_expressionsContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_star_named_expressions);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1393);
			star_named_expression();
			setState(1398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1394);
					match(COMMA);
					setState(1395);
					star_named_expression();
					}
					} 
				}
				setState(1400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			}
			setState(1402);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1401);
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
	}

	public final Star_named_expressionContext star_named_expression() throws RecognitionException {
		Star_named_expressionContext _localctx = new Star_named_expressionContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_star_named_expression);
		try {
			setState(1407);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1404);
				match(STAR);
				setState(1405);
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
				setState(1406);
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
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_assignment_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1409);
			name();
			setState(1410);
			match(COLONEQUAL);
			setState(1411);
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
	}

	public final Named_expressionContext named_expression() throws RecognitionException {
		Named_expressionContext _localctx = new Named_expressionContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_named_expression);
		try {
			setState(1415);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,167,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1413);
				assignment_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1414);
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
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_disjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1417);
			conjunction();
			setState(1422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OR) {
				{
				{
				setState(1418);
				match(OR);
				setState(1419);
				conjunction();
				}
				}
				setState(1424);
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
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_conjunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1425);
			inversion();
			setState(1430);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==AND) {
				{
				{
				setState(1426);
				match(AND);
				setState(1427);
				inversion();
				}
				}
				setState(1432);
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
	}

	public final InversionContext inversion() throws RecognitionException {
		InversionContext _localctx = new InversionContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_inversion);
		try {
			setState(1436);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NOT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1433);
				match(NOT);
				setState(1434);
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
				setState(1435);
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
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_comparison);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1438);
			bitwise_or(0);
			setState(1442);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 24)) & ~0x3f) == 0 && ((1L << (_la - 24)) & 1152957788490563827L) != 0)) {
				{
				{
				setState(1439);
				compare_op_bitwise_or_pair();
				}
				}
				setState(1444);
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
	}

	public final Compare_op_bitwise_or_pairContext compare_op_bitwise_or_pair() throws RecognitionException {
		Compare_op_bitwise_or_pairContext _localctx = new Compare_op_bitwise_or_pairContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_compare_op_bitwise_or_pair);
		try {
			setState(1455);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1445);
				eq_bitwise_or();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1446);
				noteq_bitwise_or();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1447);
				lte_bitwise_or();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1448);
				lt_bitwise_or();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1449);
				gte_bitwise_or();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1450);
				gt_bitwise_or();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1451);
				notin_bitwise_or();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1452);
				in_bitwise_or();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1453);
				isnot_bitwise_or();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1454);
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
	}

	public final Eq_bitwise_orContext eq_bitwise_or() throws RecognitionException {
		Eq_bitwise_orContext _localctx = new Eq_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_eq_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1457);
			match(EQEQUAL);
			setState(1458);
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
	}

	public final Noteq_bitwise_orContext noteq_bitwise_or() throws RecognitionException {
		Noteq_bitwise_orContext _localctx = new Noteq_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_noteq_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(1460);
			match(NOTEQUAL);
			}
			setState(1461);
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
	}

	public final Lte_bitwise_orContext lte_bitwise_or() throws RecognitionException {
		Lte_bitwise_orContext _localctx = new Lte_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_lte_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1463);
			match(LESSEQUAL);
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
	}

	public final Lt_bitwise_orContext lt_bitwise_or() throws RecognitionException {
		Lt_bitwise_orContext _localctx = new Lt_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_lt_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1466);
			match(LESS);
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
	}

	public final Gte_bitwise_orContext gte_bitwise_or() throws RecognitionException {
		Gte_bitwise_orContext _localctx = new Gte_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_gte_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1469);
			match(GREATEREQUAL);
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
	}

	public final Gt_bitwise_orContext gt_bitwise_or() throws RecognitionException {
		Gt_bitwise_orContext _localctx = new Gt_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_gt_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1472);
			match(GREATER);
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
	}

	public final Notin_bitwise_orContext notin_bitwise_or() throws RecognitionException {
		Notin_bitwise_orContext _localctx = new Notin_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_notin_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1475);
			match(NOT);
			setState(1476);
			match(IN);
			setState(1477);
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
	}

	public final In_bitwise_orContext in_bitwise_or() throws RecognitionException {
		In_bitwise_orContext _localctx = new In_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_in_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1479);
			match(IN);
			setState(1480);
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
	}

	public final Isnot_bitwise_orContext isnot_bitwise_or() throws RecognitionException {
		Isnot_bitwise_orContext _localctx = new Isnot_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_isnot_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1482);
			match(IS);
			setState(1483);
			match(NOT);
			setState(1484);
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
	}

	public final Is_bitwise_orContext is_bitwise_or() throws RecognitionException {
		Is_bitwise_orContext _localctx = new Is_bitwise_orContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_is_bitwise_or);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1486);
			match(IS);
			setState(1487);
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
			setState(1490);
			bitwise_xor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1497);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,173,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_orContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_or);
					setState(1492);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1493);
					match(VBAR);
					setState(1494);
					bitwise_xor(0);
					}
					} 
				}
				setState(1499);
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
			setState(1501);
			bitwise_and(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1508);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,174,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_xorContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_xor);
					setState(1503);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1504);
					match(CIRCUMFLEX);
					setState(1505);
					bitwise_and(0);
					}
					} 
				}
				setState(1510);
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
			setState(1512);
			shift_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1519);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,175,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Bitwise_andContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_bitwise_and);
					setState(1514);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1515);
					match(AMPER);
					setState(1516);
					shift_expr(0);
					}
					} 
				}
				setState(1521);
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
			setState(1523);
			sum(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1530);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Shift_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shift_expr);
					setState(1525);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1526);
					_la = _input.LA(1);
					if ( !(_la==LEFTSHIFT || _la==RIGHTSHIFT) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1527);
					sum(0);
					}
					} 
				}
				setState(1532);
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
			setState(1534);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(1541);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SumContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_sum);
					setState(1536);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1537);
					_la = _input.LA(1);
					if ( !(_la==PLUS || _la==MINUS) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1538);
					term(0);
					}
					} 
				}
				setState(1543);
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
			setState(1545);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(1552);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new TermContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_term);
					setState(1547);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1548);
					_la = _input.LA(1);
					if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1407375020916736L) != 0)) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(1549);
					factor();
					}
					} 
				}
				setState(1554);
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
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_factor);
		try {
			setState(1562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PLUS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1555);
				match(PLUS);
				setState(1556);
				factor();
				}
				break;
			case MINUS:
				enterOuterAlt(_localctx, 2);
				{
				setState(1557);
				match(MINUS);
				setState(1558);
				factor();
				}
				break;
			case TILDE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1559);
				match(TILDE);
				setState(1560);
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
				setState(1561);
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
	}

	public final PowerContext power() throws RecognitionException {
		PowerContext _localctx = new PowerContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_power);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1564);
			await_primary();
			setState(1567);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,180,_ctx) ) {
			case 1:
				{
				setState(1565);
				match(DOUBLESTAR);
				setState(1566);
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
	}

	public final Await_primaryContext await_primary() throws RecognitionException {
		Await_primaryContext _localctx = new Await_primaryContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_await_primary);
		try {
			setState(1572);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case AWAIT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1569);
				match(AWAIT);
				setState(1570);
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
				setState(1571);
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
			setState(1575);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(1594);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PrimaryContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_primary);
					setState(1577);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(1590);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
					case 1:
						{
						setState(1578);
						match(DOT);
						setState(1579);
						name();
						}
						break;
					case 2:
						{
						setState(1580);
						genexp();
						}
						break;
					case 3:
						{
						setState(1581);
						match(LPAR);
						setState(1583);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
							{
							setState(1582);
							arguments();
							}
						}

						setState(1585);
						match(RPAR);
						}
						break;
					case 4:
						{
						setState(1586);
						match(LSQB);
						setState(1587);
						slices();
						setState(1588);
						match(RSQB);
						}
						break;
					}
					}
					} 
				}
				setState(1596);
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
	}

	public final SlicesContext slices() throws RecognitionException {
		SlicesContext _localctx = new SlicesContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_slices);
		int _la;
		try {
			int _alt;
			setState(1615);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1597);
				slice();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1600);
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
					setState(1598);
					slice();
					}
					break;
				case STAR:
					{
					setState(1599);
					starred_expression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1609);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1602);
						match(COMMA);
						setState(1605);
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
							setState(1603);
							slice();
							}
							break;
						case STAR:
							{
							setState(1604);
							starred_expression();
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						}
						} 
					}
					setState(1611);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,187,_ctx);
				}
				setState(1613);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(1612);
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
	}

	public final SliceContext slice() throws RecognitionException {
		SliceContext _localctx = new SliceContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_slice);
		int _la;
		try {
			setState(1631);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,194,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1618);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1617);
					expression();
					}
				}

				setState(1620);
				match(COLON);
				setState(1622);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1621);
					expression();
					}
				}

				setState(1628);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1624);
					match(COLON);
					setState(1626);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994877974304L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
						{
						setState(1625);
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
				setState(1630);
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
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_atom);
		try {
			setState(1655);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1633);
				name();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1634);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(1635);
				match(FALSE);
				}
				break;
			case NONE:
				enterOuterAlt(_localctx, 4);
				{
				setState(1636);
				match(NONE);
				}
				break;
			case FSTRING_START:
			case STRING:
				enterOuterAlt(_localctx, 5);
				{
				setState(1637);
				strings();
				}
				break;
			case NUMBER:
				enterOuterAlt(_localctx, 6);
				{
				setState(1638);
				match(NUMBER);
				}
				break;
			case LPAR:
				enterOuterAlt(_localctx, 7);
				{
				setState(1642);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
				case 1:
					{
					setState(1639);
					tuple();
					}
					break;
				case 2:
					{
					setState(1640);
					group();
					}
					break;
				case 3:
					{
					setState(1641);
					genexp();
					}
					break;
				}
				}
				break;
			case LSQB:
				enterOuterAlt(_localctx, 8);
				{
				setState(1646);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
				case 1:
					{
					setState(1644);
					list();
					}
					break;
				case 2:
					{
					setState(1645);
					listcomp();
					}
					break;
				}
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 9);
				{
				setState(1652);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
				case 1:
					{
					setState(1648);
					dict();
					}
					break;
				case 2:
					{
					setState(1649);
					set();
					}
					break;
				case 3:
					{
					setState(1650);
					dictcomp();
					}
					break;
				case 4:
					{
					setState(1651);
					setcomp();
					}
					break;
				}
				}
				break;
			case ELLIPSIS:
				enterOuterAlt(_localctx, 10);
				{
				setState(1654);
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
	}

	public final GroupContext group() throws RecognitionException {
		GroupContext _localctx = new GroupContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_group);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1657);
			match(LPAR);
			setState(1660);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case YIELD:
				{
				setState(1658);
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
				setState(1659);
				named_expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1662);
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
	}

	public final LambdefContext lambdef() throws RecognitionException {
		LambdefContext _localctx = new LambdefContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_lambdef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1664);
			match(LAMBDA);
			setState(1666);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STAR || _la==DOUBLESTAR || ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
				{
				setState(1665);
				lambda_params();
				}
			}

			setState(1668);
			match(COLON);
			setState(1669);
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
	}

	public final Lambda_paramsContext lambda_params() throws RecognitionException {
		Lambda_paramsContext _localctx = new Lambda_paramsContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_lambda_params);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1671);
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
	}

	public final Lambda_parametersContext lambda_parameters() throws RecognitionException {
		Lambda_parametersContext _localctx = new Lambda_parametersContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_lambda_parameters);
		int _la;
		try {
			int _alt;
			setState(1722);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1673);
				lambda_slash_no_default();
				setState(1677);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1674);
						lambda_param_no_default();
						}
						} 
					}
					setState(1679);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
				}
				setState(1683);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1680);
					lambda_param_with_default();
					}
					}
					setState(1685);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1687);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1686);
					lambda_star_etc();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1689);
				lambda_slash_with_default();
				setState(1693);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1690);
					lambda_param_with_default();
					}
					}
					setState(1695);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1696);
					lambda_star_etc();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1700); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1699);
						lambda_param_no_default();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1702); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
				setState(1707);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1704);
					lambda_param_with_default();
					}
					}
					setState(1709);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1711);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1710);
					lambda_star_etc();
					}
				}

				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1714); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1713);
					lambda_param_with_default();
					}
					}
					setState(1716); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(1719);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STAR || _la==DOUBLESTAR) {
					{
					setState(1718);
					lambda_star_etc();
					}
				}

				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1721);
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
	}

	public final Lambda_slash_no_defaultContext lambda_slash_no_default() throws RecognitionException {
		Lambda_slash_no_defaultContext _localctx = new Lambda_slash_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_lambda_slash_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1725); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1724);
				lambda_param_no_default();
				}
				}
				setState(1727); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(1729);
			match(SLASH);
			setState(1731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1730);
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
	}

	public final Lambda_slash_with_defaultContext lambda_slash_with_default() throws RecognitionException {
		Lambda_slash_with_defaultContext _localctx = new Lambda_slash_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_lambda_slash_with_default);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1736);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1733);
					lambda_param_no_default();
					}
					} 
				}
				setState(1738);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			}
			setState(1740); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1739);
				lambda_param_with_default();
				}
				}
				setState(1742); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
			setState(1744);
			match(SLASH);
			setState(1746);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1745);
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
	}

	public final Lambda_star_etcContext lambda_star_etc() throws RecognitionException {
		Lambda_star_etcContext _localctx = new Lambda_star_etcContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_lambda_star_etc);
		int _la;
		try {
			setState(1770);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1748);
				match(STAR);
				setState(1749);
				lambda_param_no_default();
				setState(1753);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0)) {
					{
					{
					setState(1750);
					lambda_param_maybe_default();
					}
					}
					setState(1755);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1757);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(1756);
					lambda_kwds();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1759);
				match(STAR);
				setState(1760);
				match(COMMA);
				setState(1762); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1761);
					lambda_param_maybe_default();
					}
					}
					setState(1764); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( ((((_la - 91)) & ~0x3f) == 0 && ((1L << (_la - 91)) & 31L) != 0) );
				setState(1767);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==DOUBLESTAR) {
					{
					setState(1766);
					lambda_kwds();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1769);
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
	}

	public final Lambda_kwdsContext lambda_kwds() throws RecognitionException {
		Lambda_kwdsContext _localctx = new Lambda_kwdsContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_lambda_kwds);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1772);
			match(DOUBLESTAR);
			setState(1773);
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
	}

	public final Lambda_param_no_defaultContext lambda_param_no_default() throws RecognitionException {
		Lambda_param_no_defaultContext _localctx = new Lambda_param_no_defaultContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_lambda_param_no_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1775);
			lambda_param();
			setState(1777);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1776);
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
	}

	public final Lambda_param_with_defaultContext lambda_param_with_default() throws RecognitionException {
		Lambda_param_with_defaultContext _localctx = new Lambda_param_with_defaultContext(_ctx, getState());
		enterRule(_localctx, 300, RULE_lambda_param_with_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1779);
			lambda_param();
			setState(1780);
			default_assignment();
			setState(1782);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1781);
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
	}

	public final Lambda_param_maybe_defaultContext lambda_param_maybe_default() throws RecognitionException {
		Lambda_param_maybe_defaultContext _localctx = new Lambda_param_maybe_defaultContext(_ctx, getState());
		enterRule(_localctx, 302, RULE_lambda_param_maybe_default);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1784);
			lambda_param();
			setState(1786);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(1785);
				default_assignment();
				}
			}

			setState(1789);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1788);
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
	}

	public final Lambda_paramContext lambda_param() throws RecognitionException {
		Lambda_paramContext _localctx = new Lambda_paramContext(_ctx, getState());
		enterRule(_localctx, 304, RULE_lambda_param);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1791);
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
	}

	public final Fstring_middleContext fstring_middle() throws RecognitionException {
		Fstring_middleContext _localctx = new Fstring_middleContext(_ctx, getState());
		enterRule(_localctx, 306, RULE_fstring_middle);
		try {
			setState(1795);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1793);
				fstring_replacement_field();
				}
				break;
			case FSTRING_MIDDLE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1794);
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
	}

	public final Fstring_replacement_fieldContext fstring_replacement_field() throws RecognitionException {
		Fstring_replacement_fieldContext _localctx = new Fstring_replacement_fieldContext(_ctx, getState());
		enterRule(_localctx, 308, RULE_fstring_replacement_field);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1797);
			match(LBRACE);
			setState(1798);
			annotated_rhs();
			setState(1800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(1799);
				match(EQUAL);
				}
			}

			setState(1803);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXCLAMATION) {
				{
				setState(1802);
				fstring_conversion();
				}
			}

			setState(1806);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1805);
				fstring_full_format_spec();
				}
			}

			setState(1808);
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
	}

	public final Fstring_conversionContext fstring_conversion() throws RecognitionException {
		Fstring_conversionContext _localctx = new Fstring_conversionContext(_ctx, getState());
		enterRule(_localctx, 310, RULE_fstring_conversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1810);
			match(EXCLAMATION);
			setState(1811);
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
	}

	public final Fstring_full_format_specContext fstring_full_format_spec() throws RecognitionException {
		Fstring_full_format_specContext _localctx = new Fstring_full_format_specContext(_ctx, getState());
		enterRule(_localctx, 312, RULE_fstring_full_format_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1813);
			match(COLON);
			setState(1817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FSTRING_MIDDLE || _la==LBRACE) {
				{
				{
				setState(1814);
				fstring_format_spec();
				}
				}
				setState(1819);
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
	}

	public final Fstring_format_specContext fstring_format_spec() throws RecognitionException {
		Fstring_format_specContext _localctx = new Fstring_format_specContext(_ctx, getState());
		enterRule(_localctx, 314, RULE_fstring_format_spec);
		try {
			setState(1822);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FSTRING_MIDDLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1820);
				match(FSTRING_MIDDLE);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1821);
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
	}

	public final FstringContext fstring() throws RecognitionException {
		FstringContext _localctx = new FstringContext(_ctx, getState());
		enterRule(_localctx, 316, RULE_fstring);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1824);
			match(FSTRING_START);
			setState(1828);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FSTRING_MIDDLE || _la==LBRACE) {
				{
				{
				setState(1825);
				fstring_middle();
				}
				}
				setState(1830);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1831);
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
	}

	public final StringContext string() throws RecognitionException {
		StringContext _localctx = new StringContext(_ctx, getState());
		enterRule(_localctx, 318, RULE_string);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1833);
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
		public List<FstringContext> fstring() {
			return getRuleContexts(FstringContext.class);
		}
		public FstringContext fstring(int i) {
			return getRuleContext(FstringContext.class,i);
		}
		public List<StringContext> string() {
			return getRuleContexts(StringContext.class);
		}
		public StringContext string(int i) {
			return getRuleContext(StringContext.class,i);
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
	}

	public final StringsContext strings() throws RecognitionException {
		StringsContext _localctx = new StringsContext(_ctx, getState());
		enterRule(_localctx, 320, RULE_strings);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1837); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(1837);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case FSTRING_START:
						{
						setState(1835);
						fstring();
						}
						break;
					case STRING:
						{
						setState(1836);
						string();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1839); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,234,_ctx);
			} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 322, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1841);
			match(LSQB);
			setState(1843);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1842);
				star_named_expressions();
				}
			}

			setState(1845);
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
	}

	public final TupleContext tuple() throws RecognitionException {
		TupleContext _localctx = new TupleContext(_ctx, getState());
		enterRule(_localctx, 324, RULE_tuple);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1847);
			match(LPAR);
			setState(1853);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1848);
				star_named_expression();
				setState(1849);
				match(COMMA);
				setState(1851);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531022994879022880L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
					{
					setState(1850);
					star_named_expressions();
					}
				}

				}
			}

			setState(1855);
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
	}

	public final SetContext set() throws RecognitionException {
		SetContext _localctx = new SetContext(_ctx, getState());
		enterRule(_localctx, 326, RULE_set);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1857);
			match(LBRACE);
			setState(1858);
			star_named_expressions();
			setState(1859);
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
	}

	public final DictContext dict() throws RecognitionException {
		DictContext _localctx = new DictContext(_ctx, getState());
		enterRule(_localctx, 328, RULE_dict);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1861);
			match(LBRACE);
			setState(1863);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063597451040L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
				{
				setState(1862);
				double_starred_kvpairs();
				}
			}

			setState(1865);
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
	}

	public final Double_starred_kvpairsContext double_starred_kvpairs() throws RecognitionException {
		Double_starred_kvpairsContext _localctx = new Double_starred_kvpairsContext(_ctx, getState());
		enterRule(_localctx, 330, RULE_double_starred_kvpairs);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1867);
			double_starred_kvpair();
			setState(1872);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1868);
					match(COMMA);
					setState(1869);
					double_starred_kvpair();
					}
					} 
				}
				setState(1874);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,239,_ctx);
			}
			setState(1876);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1875);
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
	}

	public final Double_starred_kvpairContext double_starred_kvpair() throws RecognitionException {
		Double_starred_kvpairContext _localctx = new Double_starred_kvpairContext(_ctx, getState());
		enterRule(_localctx, 332, RULE_double_starred_kvpair);
		try {
			setState(1881);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1878);
				match(DOUBLESTAR);
				setState(1879);
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
				setState(1880);
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
	}

	public final KvpairContext kvpair() throws RecognitionException {
		KvpairContext _localctx = new KvpairContext(_ctx, getState());
		enterRule(_localctx, 334, RULE_kvpair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1883);
			expression();
			setState(1884);
			match(COLON);
			setState(1885);
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
	}

	public final For_if_clausesContext for_if_clauses() throws RecognitionException {
		For_if_clausesContext _localctx = new For_if_clausesContext(_ctx, getState());
		enterRule(_localctx, 336, RULE_for_if_clauses);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1888); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1887);
				for_if_clause();
				}
				}
				setState(1890); 
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
	}

	public final For_if_clauseContext for_if_clause() throws RecognitionException {
		For_if_clauseContext _localctx = new For_if_clauseContext(_ctx, getState());
		enterRule(_localctx, 338, RULE_for_if_clause);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1893);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASYNC) {
				{
				setState(1892);
				match(ASYNC);
				}
			}

			setState(1895);
			match(FOR);
			setState(1896);
			star_targets();
			setState(1897);
			match(IN);
			setState(1898);
			disjunction();
			setState(1903);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IF) {
				{
				{
				setState(1899);
				match(IF);
				setState(1900);
				disjunction();
				}
				}
				setState(1905);
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
	}

	public final ListcompContext listcomp() throws RecognitionException {
		ListcompContext _localctx = new ListcompContext(_ctx, getState());
		enterRule(_localctx, 340, RULE_listcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1906);
			match(LSQB);
			setState(1907);
			named_expression();
			setState(1908);
			for_if_clauses();
			setState(1909);
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
	}

	public final SetcompContext setcomp() throws RecognitionException {
		SetcompContext _localctx = new SetcompContext(_ctx, getState());
		enterRule(_localctx, 342, RULE_setcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1911);
			match(LBRACE);
			setState(1912);
			named_expression();
			setState(1913);
			for_if_clauses();
			setState(1914);
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
	}

	public final GenexpContext genexp() throws RecognitionException {
		GenexpContext _localctx = new GenexpContext(_ctx, getState());
		enterRule(_localctx, 344, RULE_genexp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1916);
			match(LPAR);
			setState(1919);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,245,_ctx) ) {
			case 1:
				{
				setState(1917);
				assignment_expression();
				}
				break;
			case 2:
				{
				setState(1918);
				expression();
				}
				break;
			}
			setState(1921);
			for_if_clauses();
			setState(1922);
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
	}

	public final DictcompContext dictcomp() throws RecognitionException {
		DictcompContext _localctx = new DictcompContext(_ctx, getState());
		enterRule(_localctx, 346, RULE_dictcomp);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1924);
			match(LBRACE);
			setState(1925);
			kvpair();
			setState(1926);
			for_if_clauses();
			setState(1927);
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
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 348, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1929);
			args();
			setState(1931);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(1930);
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
		public KwargsContext kwargs() {
			return getRuleContext(KwargsContext.class,0);
		}
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
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
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 350, RULE_args);
		try {
			int _alt;
			setState(1958);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,253,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1938);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case STAR:
					{
					setState(1933);
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
					setState(1936);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,247,_ctx) ) {
					case 1:
						{
						setState(1934);
						assignment_expression();
						}
						break;
					case 2:
						{
						setState(1935);
						expression();
						}
						break;
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1950);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,251,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1940);
						match(COMMA);
						setState(1946);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case STAR:
							{
							setState(1941);
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
							setState(1944);
							_errHandler.sync(this);
							switch ( getInterpreter().adaptivePredict(_input,249,_ctx) ) {
							case 1:
								{
								setState(1942);
								assignment_expression();
								}
								break;
							case 2:
								{
								setState(1943);
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
					}
					setState(1952);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,251,_ctx);
				}
				setState(1955);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,252,_ctx) ) {
				case 1:
					{
					setState(1953);
					match(COMMA);
					setState(1954);
					kwargs();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1957);
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
	}

	public final KwargsContext kwargs() throws RecognitionException {
		KwargsContext _localctx = new KwargsContext(_ctx, getState());
		enterRule(_localctx, 352, RULE_kwargs);
		try {
			int _alt;
			setState(1987);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,258,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1960);
				kwarg_or_starred();
				setState(1965);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1961);
						match(COMMA);
						setState(1962);
						kwarg_or_starred();
						}
						} 
					}
					setState(1967);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,254,_ctx);
				}
				setState(1977);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,256,_ctx) ) {
				case 1:
					{
					setState(1968);
					match(COMMA);
					setState(1969);
					kwarg_or_double_starred();
					setState(1974);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,255,_ctx);
					while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1970);
							match(COMMA);
							setState(1971);
							kwarg_or_double_starred();
							}
							} 
						}
						setState(1976);
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
				setState(1979);
				kwarg_or_double_starred();
				setState(1984);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,257,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1980);
						match(COMMA);
						setState(1981);
						kwarg_or_double_starred();
						}
						} 
					}
					setState(1986);
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
	}

	public final Starred_expressionContext starred_expression() throws RecognitionException {
		Starred_expressionContext _localctx = new Starred_expressionContext(_ctx, getState());
		enterRule(_localctx, 354, RULE_starred_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1989);
			match(STAR);
			setState(1990);
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
	}

	public final Kwarg_or_starredContext kwarg_or_starred() throws RecognitionException {
		Kwarg_or_starredContext _localctx = new Kwarg_or_starredContext(_ctx, getState());
		enterRule(_localctx, 356, RULE_kwarg_or_starred);
		try {
			setState(1997);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1992);
				name();
				setState(1993);
				match(EQUAL);
				setState(1994);
				expression();
				}
				break;
			case STAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(1996);
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
	}

	public final Kwarg_or_double_starredContext kwarg_or_double_starred() throws RecognitionException {
		Kwarg_or_double_starredContext _localctx = new Kwarg_or_double_starredContext(_ctx, getState());
		enterRule(_localctx, 358, RULE_kwarg_or_double_starred);
		try {
			setState(2005);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME_OR_WILDCARD:
			case NAME:
				enterOuterAlt(_localctx, 1);
				{
				setState(1999);
				name();
				setState(2000);
				match(EQUAL);
				setState(2001);
				expression();
				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2003);
				match(DOUBLESTAR);
				setState(2004);
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
	}

	public final Star_targetsContext star_targets() throws RecognitionException {
		Star_targetsContext _localctx = new Star_targetsContext(_ctx, getState());
		enterRule(_localctx, 360, RULE_star_targets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2007);
			star_target();
			setState(2012);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2008);
					match(COMMA);
					setState(2009);
					star_target();
					}
					} 
				}
				setState(2014);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			}
			setState(2016);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2015);
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
	}

	public final Star_targets_list_seqContext star_targets_list_seq() throws RecognitionException {
		Star_targets_list_seqContext _localctx = new Star_targets_list_seqContext(_ctx, getState());
		enterRule(_localctx, 362, RULE_star_targets_list_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2018);
			star_target();
			setState(2023);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
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
				_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
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
	}

	public final Star_targets_tuple_seqContext star_targets_tuple_seq() throws RecognitionException {
		Star_targets_tuple_seqContext _localctx = new Star_targets_tuple_seqContext(_ctx, getState());
		enterRule(_localctx, 364, RULE_star_targets_tuple_seq);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2029);
			star_target();
			setState(2040);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,267,_ctx) ) {
			case 1:
				{
				setState(2030);
				match(COMMA);
				}
				break;
			case 2:
				{
				setState(2033); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2031);
						match(COMMA);
						setState(2032);
						star_target();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2035); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,265,_ctx);
				} while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER );
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
	}

	public final Star_targetContext star_target() throws RecognitionException {
		Star_targetContext _localctx = new Star_targetContext(_ctx, getState());
		enterRule(_localctx, 366, RULE_star_target);
		try {
			setState(2045);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case STAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2042);
				match(STAR);
				{
				setState(2043);
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
				setState(2044);
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
	}

	public final Target_with_star_atomContext target_with_star_atom() throws RecognitionException {
		Target_with_star_atomContext _localctx = new Target_with_star_atomContext(_ctx, getState());
		enterRule(_localctx, 368, RULE_target_with_star_atom);
		try {
			setState(2057);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,270,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2047);
				t_primary(0);
				setState(2054);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(2048);
					match(DOT);
					setState(2049);
					name();
					}
					break;
				case LSQB:
					{
					setState(2050);
					match(LSQB);
					setState(2051);
					slices();
					setState(2052);
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
				setState(2056);
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
	}

	public final Star_atomContext star_atom() throws RecognitionException {
		Star_atomContext _localctx = new Star_atomContext(_ctx, getState());
		enterRule(_localctx, 370, RULE_star_atom);
		int _la;
		try {
			setState(2074);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,273,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2059);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2060);
				match(LPAR);
				setState(2061);
				target_with_star_atom();
				setState(2062);
				match(RPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2064);
				match(LPAR);
				setState(2066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802507413280L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2065);
					star_targets_tuple_seq();
					}
				}

				setState(2068);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2069);
				match(LSQB);
				setState(2071);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802507413280L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2070);
					star_targets_list_seq();
					}
				}

				setState(2073);
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
	}

	public final Single_targetContext single_target() throws RecognitionException {
		Single_targetContext _localctx = new Single_targetContext(_ctx, getState());
		enterRule(_localctx, 372, RULE_single_target);
		try {
			setState(2082);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,274,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2076);
				single_subscript_attribute_target();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2077);
				name();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2078);
				match(LPAR);
				setState(2079);
				single_target();
				setState(2080);
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
	}

	public final Single_subscript_attribute_targetContext single_subscript_attribute_target() throws RecognitionException {
		Single_subscript_attribute_targetContext _localctx = new Single_subscript_attribute_targetContext(_ctx, getState());
		enterRule(_localctx, 374, RULE_single_subscript_attribute_target);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2084);
			t_primary(0);
			setState(2091);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DOT:
				{
				setState(2085);
				match(DOT);
				setState(2086);
				name();
				}
				break;
			case LSQB:
				{
				setState(2087);
				match(LSQB);
				setState(2088);
				slices();
				setState(2089);
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
	}

	public final T_primaryContext t_primary() throws RecognitionException {
		return t_primary(0);
	}

	private T_primaryContext t_primary(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		T_primaryContext _localctx = new T_primaryContext(_ctx, _parentState);
		T_primaryContext _prevctx = _localctx;
		int _startState = 376;
		enterRecursionRule(_localctx, 376, RULE_t_primary, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(2094);
			atom();
			}
			_ctx.stop = _input.LT(-1);
			setState(2113);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,278,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new T_primaryContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_t_primary);
					setState(2096);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(2109);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,277,_ctx) ) {
					case 1:
						{
						setState(2097);
						match(DOT);
						setState(2098);
						name();
						}
						break;
					case 2:
						{
						setState(2099);
						match(LSQB);
						setState(2100);
						slices();
						setState(2101);
						match(RSQB);
						}
						break;
					case 3:
						{
						setState(2103);
						genexp();
						}
						break;
					case 4:
						{
						setState(2104);
						match(LPAR);
						setState(2106);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2531023063598499616L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261675265L) != 0)) {
							{
							setState(2105);
							arguments();
							}
						}

						setState(2108);
						match(RPAR);
						}
						break;
					}
					}
					} 
				}
				setState(2115);
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
	}

	public final Del_targetsContext del_targets() throws RecognitionException {
		Del_targetsContext _localctx = new Del_targetsContext(_ctx, getState());
		enterRule(_localctx, 378, RULE_del_targets);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2116);
			del_target();
			setState(2121);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2117);
					match(COMMA);
					setState(2118);
					del_target();
					}
					} 
				}
				setState(2123);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			}
			setState(2125);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(2124);
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
	}

	public final Del_targetContext del_target() throws RecognitionException {
		Del_targetContext _localctx = new Del_targetContext(_ctx, getState());
		enterRule(_localctx, 380, RULE_del_target);
		try {
			setState(2137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,282,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2127);
				t_primary(0);
				setState(2134);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case DOT:
					{
					setState(2128);
					match(DOT);
					setState(2129);
					name();
					}
					break;
				case LSQB:
					{
					setState(2130);
					match(LSQB);
					setState(2131);
					slices();
					setState(2132);
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
				setState(2136);
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
	}

	public final Del_t_atomContext del_t_atom() throws RecognitionException {
		Del_t_atomContext _localctx = new Del_t_atomContext(_ctx, getState());
		enterRule(_localctx, 382, RULE_del_t_atom);
		int _la;
		try {
			setState(2154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,285,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2139);
				name();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2140);
				match(LPAR);
				setState(2141);
				del_target();
				setState(2142);
				match(RPAR);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2144);
				match(LPAR);
				setState(2146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802506364704L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2145);
					del_targets();
					}
				}

				setState(2148);
				match(RPAR);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2149);
				match(LSQB);
				setState(2151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 2386907802506364704L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & 4261412865L) != 0)) {
					{
					setState(2150);
					del_targets();
					}
				}

				setState(2153);
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
	}

	public final Type_expressionsContext type_expressions() throws RecognitionException {
		Type_expressionsContext _localctx = new Type_expressionsContext(_ctx, getState());
		enterRule(_localctx, 384, RULE_type_expressions);
		int _la;
		try {
			int _alt;
			setState(2187);
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
				setState(2156);
				expression();
				setState(2161);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2157);
						match(COMMA);
						setState(2158);
						expression();
						}
						} 
					}
					setState(2163);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				}
				setState(2176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2164);
					match(COMMA);
					setState(2174);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case STAR:
						{
						setState(2165);
						match(STAR);
						setState(2166);
						expression();
						setState(2170);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==COMMA) {
							{
							setState(2167);
							match(COMMA);
							setState(2168);
							match(DOUBLESTAR);
							setState(2169);
							expression();
							}
						}

						}
						break;
					case DOUBLESTAR:
						{
						setState(2172);
						match(DOUBLESTAR);
						setState(2173);
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
				setState(2178);
				match(STAR);
				setState(2179);
				expression();
				setState(2183);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(2180);
					match(COMMA);
					setState(2181);
					match(DOUBLESTAR);
					setState(2182);
					expression();
					}
				}

				}
				break;
			case DOUBLESTAR:
				enterOuterAlt(_localctx, 3);
				{
				setState(2185);
				match(DOUBLESTAR);
				setState(2186);
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
	}

	public final Func_type_commentContext func_type_comment() throws RecognitionException {
		Func_type_commentContext _localctx = new Func_type_commentContext(_ctx, getState());
		enterRule(_localctx, 386, RULE_func_type_comment);
		try {
			setState(2192);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEWLINE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2189);
				match(NEWLINE);
				setState(2190);
				match(TYPE_COMMENT);
				}
				break;
			case TYPE_COMMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(2191);
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
	}

	public final Name_except_underscoreContext name_except_underscore() throws RecognitionException {
		Name_except_underscoreContext _localctx = new Name_except_underscoreContext(_ctx, getState());
		enterRule(_localctx, 388, RULE_name_except_underscore);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2194);
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
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 390, RULE_name);
		try {
			setState(2198);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NAME_OR_WILDCARD:
				enterOuterAlt(_localctx, 1);
				{
				setState(2196);
				match(NAME_OR_WILDCARD);
				}
				break;
			case NAME_OR_TYPE:
			case NAME_OR_MATCH:
			case NAME_OR_CASE:
			case NAME:
				enterOuterAlt(_localctx, 2);
				{
				setState(2197);
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
		case 188:
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
		"\u0004\u0001f\u0899\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
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
		"\u0002\u00c3\u0007\u00c3\u0001\u0000\u0003\u0000\u018a\b\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0005\u0002"+
		"\u0192\b\u0002\n\u0002\f\u0002\u0195\t\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0003\u0001\u0003\u0003\u0003\u019b\b\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0005\u0003\u01a1\b\u0003\n\u0003\f\u0003\u01a4\t\u0003"+
		"\u0001\u0003\u0001\u0003\u0001\u0004\u0004\u0004\u01a9\b\u0004\u000b\u0004"+
		"\f\u0004\u01aa\u0001\u0005\u0001\u0005\u0003\u0005\u01af\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0003"+
		"\u0006\u01b7\b\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0005\u0007\u01bc"+
		"\b\u0007\n\u0007\f\u0007\u01bf\t\u0007\u0001\u0007\u0003\u0007\u01c2\b"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"+
		"\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b\u0001"+
		"\b\u0003\b\u01d4\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u01de\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\n\u01e5\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u01ec\b\n"+
		"\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u01f2\b\n\u0001\n\u0001\n\u0001"+
		"\n\u0004\n\u01f7\b\n\u000b\n\f\n\u01f8\u0001\n\u0001\n\u0003\n\u01fd\b"+
		"\n\u0001\n\u0003\n\u0200\b\n\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0206"+
		"\b\n\u0003\n\u0208\b\n\u0001\u000b\u0001\u000b\u0003\u000b\u020c\b\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0003\r\u0212\b\r\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u0218\b\u000e\u0003\u000e\u021a\b"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0005\u000f\u0220"+
		"\b\u000f\n\u000f\f\u000f\u0223\t\u000f\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u0229\b\u0010\n\u0010\f\u0010\u022c\t\u0010\u0001"+
		"\u0011\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0013\u0001"+
		"\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u0237\b\u0013\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u023b\b\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u0242\b\u0016\n\u0016\f\u0016\u0245\t\u0016"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016"+
		"\u0004\u0016\u024d\b\u0016\u000b\u0016\f\u0016\u024e\u0001\u0016\u0001"+
		"\u0016\u0003\u0016\u0253\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u0258\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003"+
		"\u0017\u025e\b\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0263"+
		"\b\u0018\n\u0018\f\u0018\u0266\t\u0018\u0001\u0019\u0001\u0019\u0001\u0019"+
		"\u0003\u0019\u026b\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a"+
		"\u0270\b\u001a\n\u001a\f\u001a\u0273\t\u001a\u0001\u001b\u0001\u001b\u0001"+
		"\u001b\u0003\u001b\u0278\b\u001b\u0001\u001c\u0001\u001c\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0280\b\u001c\n\u001c\f\u001c"+
		"\u0283\t\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0003\u001d\u028b\b\u001d\u0001\u001e\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0004\u001e\u0291\b\u001e\u000b\u001e\f\u001e\u0292\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u0299\b\u001f\u0001"+
		" \u0001 \u0001 \u0003 \u029e\b \u0001 \u0001 \u0003 \u02a2\b \u0001 \u0003"+
		" \u02a5\b \u0001 \u0001 \u0001 \u0001!\u0001!\u0001!\u0001!\u0003!\u02ae"+
		"\b!\u0001\"\u0001\"\u0001\"\u0003\"\u02b3\b\"\u0001\"\u0001\"\u0003\""+
		"\u02b7\b\"\u0001\"\u0001\"\u0001\"\u0003\"\u02bc\b\"\u0001\"\u0001\"\u0003"+
		"\"\u02c0\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u02c8"+
		"\b\"\u0001\"\u0001\"\u0003\"\u02cc\b\"\u0001\"\u0001\"\u0001\"\u0003\""+
		"\u02d1\b\"\u0001\"\u0001\"\u0003\"\u02d5\b\"\u0001\"\u0001\"\u0003\"\u02d9"+
		"\b\"\u0001#\u0001#\u0001$\u0001$\u0005$\u02df\b$\n$\f$\u02e2\t$\u0001"+
		"$\u0005$\u02e5\b$\n$\f$\u02e8\t$\u0001$\u0003$\u02eb\b$\u0001$\u0001$"+
		"\u0005$\u02ef\b$\n$\f$\u02f2\t$\u0001$\u0003$\u02f5\b$\u0001$\u0004$\u02f8"+
		"\b$\u000b$\f$\u02f9\u0001$\u0005$\u02fd\b$\n$\f$\u0300\t$\u0001$\u0003"+
		"$\u0303\b$\u0001$\u0004$\u0306\b$\u000b$\f$\u0307\u0001$\u0003$\u030b"+
		"\b$\u0001$\u0003$\u030e\b$\u0001%\u0004%\u0311\b%\u000b%\f%\u0312\u0001"+
		"%\u0001%\u0003%\u0317\b%\u0001&\u0005&\u031a\b&\n&\f&\u031d\t&\u0001&"+
		"\u0004&\u0320\b&\u000b&\f&\u0321\u0001&\u0001&\u0003&\u0326\b&\u0001\'"+
		"\u0001\'\u0001\'\u0005\'\u032b\b\'\n\'\f\'\u032e\t\'\u0001\'\u0003\'\u0331"+
		"\b\'\u0001\'\u0001\'\u0001\'\u0005\'\u0336\b\'\n\'\f\'\u0339\t\'\u0001"+
		"\'\u0003\'\u033c\b\'\u0001\'\u0001\'\u0001\'\u0004\'\u0341\b\'\u000b\'"+
		"\f\'\u0342\u0001\'\u0003\'\u0346\b\'\u0001\'\u0003\'\u0349\b\'\u0001("+
		"\u0001(\u0001(\u0001)\u0001)\u0003)\u0350\b)\u0001)\u0003)\u0353\b)\u0001"+
		"*\u0001*\u0003*\u0357\b*\u0001*\u0003*\u035a\b*\u0001+\u0001+\u0001+\u0003"+
		"+\u035f\b+\u0001+\u0003+\u0362\b+\u0001,\u0001,\u0003,\u0366\b,\u0001"+
		",\u0003,\u0369\b,\u0001,\u0003,\u036c\b,\u0001-\u0001-\u0003-\u0370\b"+
		"-\u0001.\u0001.\u0001.\u0001/\u0001/\u0001/\u00010\u00010\u00010\u0001"+
		"1\u00011\u00011\u00012\u00012\u00012\u00012\u00012\u00012\u00032\u0384"+
		"\b2\u00032\u0386\b2\u00013\u00013\u00013\u00013\u00013\u00013\u00033\u038e"+
		"\b3\u00033\u0390\b3\u00014\u00014\u00014\u00014\u00015\u00015\u00015\u0001"+
		"5\u00015\u00035\u039b\b5\u00016\u00036\u039e\b6\u00016\u00016\u00016\u0001"+
		"6\u00016\u00016\u00036\u03a6\b6\u00016\u00016\u00036\u03aa\b6\u00017\u0001"+
		"7\u00017\u00017\u00017\u00057\u03b1\b7\n7\f7\u03b4\t7\u00017\u00037\u03b7"+
		"\b7\u00017\u00017\u00017\u00037\u03bc\b7\u00017\u00017\u00017\u00017\u0001"+
		"7\u00017\u00017\u00017\u00057\u03c6\b7\n7\f7\u03c9\t7\u00017\u00037\u03cc"+
		"\b7\u00017\u00017\u00017\u00017\u00017\u00037\u03d3\b7\u00017\u00017\u0001"+
		"7\u00017\u00057\u03d9\b7\n7\f7\u03dc\t7\u00017\u00017\u00037\u03e0\b7"+
		"\u00017\u00017\u00037\u03e4\b7\u00018\u00018\u00018\u00038\u03e9\b8\u0001"+
		"9\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00049\u03f4"+
		"\b9\u000b9\f9\u03f5\u00019\u00039\u03f9\b9\u00019\u00039\u03fc\b9\u0001"+
		"9\u00019\u00019\u00019\u00049\u0402\b9\u000b9\f9\u0403\u00019\u00039\u0407"+
		"\b9\u00019\u00039\u040a\b9\u00039\u040c\b9\u0001:\u0001:\u0001:\u0001"+
		":\u0003:\u0412\b:\u0003:\u0414\b:\u0001:\u0001:\u0001:\u0001;\u0001;\u0001"+
		";\u0001;\u0001;\u0003;\u041e\b;\u0001;\u0001;\u0001;\u0001<\u0001<\u0001"+
		"<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0004=\u042d\b=\u000b"+
		"=\f=\u042e\u0001=\u0001=\u0001>\u0001>\u0001>\u0003>\u0436\b>\u0001>\u0003"+
		">\u0439\b>\u0001?\u0001?\u0001?\u0003?\u043e\b?\u0001?\u0001?\u0001?\u0001"+
		"@\u0001@\u0001@\u0001A\u0001A\u0003A\u0448\bA\u0001B\u0001B\u0003B\u044c"+
		"\bB\u0001C\u0001C\u0001C\u0001C\u0001D\u0001D\u0001D\u0005D\u0455\bD\n"+
		"D\fD\u0458\tD\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E\u0001E"+
		"\u0003E\u0462\bE\u0001F\u0001F\u0001F\u0001F\u0001F\u0001F\u0003F\u046a"+
		"\bF\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0003G\u0472\bG\u0001H\u0001"+
		"H\u0001H\u0001H\u0001I\u0003I\u0479\bI\u0001I\u0001I\u0001J\u0003J\u047e"+
		"\bJ\u0001J\u0001J\u0001K\u0001K\u0001L\u0001L\u0001M\u0001M\u0001N\u0001"+
		"N\u0001O\u0001O\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0004Q\u0491\bQ\u000b"+
		"Q\fQ\u0492\u0001R\u0001R\u0001R\u0005R\u0498\bR\nR\fR\u049b\tR\u0001S"+
		"\u0001S\u0001S\u0001S\u0001T\u0001T\u0003T\u04a3\bT\u0001T\u0001T\u0001"+
		"T\u0003T\u04a8\bT\u0001T\u0003T\u04ab\bT\u0001U\u0001U\u0001U\u0003U\u04b0"+
		"\bU\u0001V\u0001V\u0001V\u0005V\u04b5\bV\nV\fV\u04b8\tV\u0001V\u0003V"+
		"\u04bb\bV\u0001W\u0001W\u0003W\u04bf\bW\u0001X\u0001X\u0001X\u0001Y\u0001"+
		"Y\u0001Y\u0001Y\u0001Y\u0003Y\u04c9\bY\u0001Y\u0001Y\u0001Y\u0001Y\u0001"+
		"Y\u0001Y\u0003Y\u04d1\bY\u0001Y\u0003Y\u04d4\bY\u0001Y\u0001Y\u0003Y\u04d8"+
		"\bY\u0001Z\u0001Z\u0001Z\u0005Z\u04dd\bZ\nZ\fZ\u04e0\tZ\u0001[\u0001["+
		"\u0003[\u04e4\b[\u0001[\u0001[\u0001[\u0001\\\u0001\\\u0001\\\u0001]\u0001"+
		"]\u0001]\u0001]\u0001]\u0003]\u04f1\b]\u0001]\u0003]\u04f4\b]\u0001]\u0003"+
		"]\u04f7\b]\u0003]\u04f9\b]\u0001]\u0001]\u0001^\u0001^\u0001^\u0005^\u0500"+
		"\b^\n^\f^\u0503\t^\u0001_\u0001_\u0001_\u0005_\u0508\b_\n_\f_\u050b\t"+
		"_\u0001`\u0001`\u0001`\u0001`\u0001a\u0001a\u0001a\u0003a\u0514\ba\u0001"+
		"a\u0001a\u0001a\u0001b\u0001b\u0001b\u0001b\u0001c\u0001c\u0001c\u0005"+
		"c\u0520\bc\nc\fc\u0523\tc\u0001c\u0003c\u0526\bc\u0001d\u0001d\u0003d"+
		"\u052a\bd\u0001d\u0003d\u052d\bd\u0001d\u0001d\u0001d\u0003d\u0532\bd"+
		"\u0001d\u0001d\u0001d\u0003d\u0537\bd\u0003d\u0539\bd\u0001e\u0001e\u0001"+
		"e\u0001f\u0001f\u0001f\u0001g\u0001g\u0001g\u0001h\u0001h\u0001h\u0005"+
		"h\u0547\bh\nh\fh\u054a\th\u0001h\u0003h\u054d\bh\u0001i\u0001i\u0001i"+
		"\u0001i\u0001i\u0001i\u0003i\u0555\bi\u0001i\u0003i\u0558\bi\u0001j\u0001"+
		"j\u0001j\u0001j\u0003j\u055e\bj\u0003j\u0560\bj\u0001k\u0001k\u0001k\u0005"+
		"k\u0565\bk\nk\fk\u0568\tk\u0001k\u0003k\u056b\bk\u0001l\u0001l\u0001l"+
		"\u0003l\u0570\bl\u0001m\u0001m\u0001m\u0005m\u0575\bm\nm\fm\u0578\tm\u0001"+
		"m\u0003m\u057b\bm\u0001n\u0001n\u0001n\u0003n\u0580\bn\u0001o\u0001o\u0001"+
		"o\u0001o\u0001p\u0001p\u0003p\u0588\bp\u0001q\u0001q\u0001q\u0005q\u058d"+
		"\bq\nq\fq\u0590\tq\u0001r\u0001r\u0001r\u0005r\u0595\br\nr\fr\u0598\t"+
		"r\u0001s\u0001s\u0001s\u0003s\u059d\bs\u0001t\u0001t\u0005t\u05a1\bt\n"+
		"t\ft\u05a4\tt\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u\u0001u"+
		"\u0001u\u0001u\u0003u\u05b0\bu\u0001v\u0001v\u0001v\u0001w\u0001w\u0001"+
		"w\u0001x\u0001x\u0001x\u0001y\u0001y\u0001y\u0001z\u0001z\u0001z\u0001"+
		"{\u0001{\u0001{\u0001|\u0001|\u0001|\u0001|\u0001}\u0001}\u0001}\u0001"+
		"~\u0001~\u0001~\u0001~\u0001\u007f\u0001\u007f\u0001\u007f\u0001\u0080"+
		"\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0001\u0080\u0005\u0080"+
		"\u05d8\b\u0080\n\u0080\f\u0080\u05db\t\u0080\u0001\u0081\u0001\u0081\u0001"+
		"\u0081\u0001\u0081\u0001\u0081\u0001\u0081\u0005\u0081\u05e3\b\u0081\n"+
		"\u0081\f\u0081\u05e6\t\u0081\u0001\u0082\u0001\u0082\u0001\u0082\u0001"+
		"\u0082\u0001\u0082\u0001\u0082\u0005\u0082\u05ee\b\u0082\n\u0082\f\u0082"+
		"\u05f1\t\u0082\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083\u0001\u0083"+
		"\u0001\u0083\u0005\u0083\u05f9\b\u0083\n\u0083\f\u0083\u05fc\t\u0083\u0001"+
		"\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0001\u0084\u0005"+
		"\u0084\u0604\b\u0084\n\u0084\f\u0084\u0607\t\u0084\u0001\u0085\u0001\u0085"+
		"\u0001\u0085\u0001\u0085\u0001\u0085\u0001\u0085\u0005\u0085\u060f\b\u0085"+
		"\n\u0085\f\u0085\u0612\t\u0085\u0001\u0086\u0001\u0086\u0001\u0086\u0001"+
		"\u0086\u0001\u0086\u0001\u0086\u0001\u0086\u0003\u0086\u061b\b\u0086\u0001"+
		"\u0087\u0001\u0087\u0001\u0087\u0003\u0087\u0620\b\u0087\u0001\u0088\u0001"+
		"\u0088\u0001\u0088\u0003\u0088\u0625\b\u0088\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0003\u0089\u0630\b\u0089\u0001\u0089\u0001\u0089\u0001\u0089\u0001"+
		"\u0089\u0001\u0089\u0003\u0089\u0637\b\u0089\u0005\u0089\u0639\b\u0089"+
		"\n\u0089\f\u0089\u063c\t\u0089\u0001\u008a\u0001\u008a\u0001\u008a\u0003"+
		"\u008a\u0641\b\u008a\u0001\u008a\u0001\u008a\u0001\u008a\u0003\u008a\u0646"+
		"\b\u008a\u0005\u008a\u0648\b\u008a\n\u008a\f\u008a\u064b\t\u008a\u0001"+
		"\u008a\u0003\u008a\u064e\b\u008a\u0003\u008a\u0650\b\u008a\u0001\u008b"+
		"\u0003\u008b\u0653\b\u008b\u0001\u008b\u0001\u008b\u0003\u008b\u0657\b"+
		"\u008b\u0001\u008b\u0001\u008b\u0003\u008b\u065b\b\u008b\u0003\u008b\u065d"+
		"\b\u008b\u0001\u008b\u0003\u008b\u0660\b\u008b\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c"+
		"\u0001\u008c\u0003\u008c\u066b\b\u008c\u0001\u008c\u0001\u008c\u0003\u008c"+
		"\u066f\b\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0001\u008c\u0003\u008c"+
		"\u0675\b\u008c\u0001\u008c\u0003\u008c\u0678\b\u008c\u0001\u008d\u0001"+
		"\u008d\u0001\u008d\u0003\u008d\u067d\b\u008d\u0001\u008d\u0001\u008d\u0001"+
		"\u008e\u0001\u008e\u0003\u008e\u0683\b\u008e\u0001\u008e\u0001\u008e\u0001"+
		"\u008e\u0001\u008f\u0001\u008f\u0001\u0090\u0001\u0090\u0005\u0090\u068c"+
		"\b\u0090\n\u0090\f\u0090\u068f\t\u0090\u0001\u0090\u0005\u0090\u0692\b"+
		"\u0090\n\u0090\f\u0090\u0695\t\u0090\u0001\u0090\u0003\u0090\u0698\b\u0090"+
		"\u0001\u0090\u0001\u0090\u0005\u0090\u069c\b\u0090\n\u0090\f\u0090\u069f"+
		"\t\u0090\u0001\u0090\u0003\u0090\u06a2\b\u0090\u0001\u0090\u0004\u0090"+
		"\u06a5\b\u0090\u000b\u0090\f\u0090\u06a6\u0001\u0090\u0005\u0090\u06aa"+
		"\b\u0090\n\u0090\f\u0090\u06ad\t\u0090\u0001\u0090\u0003\u0090\u06b0\b"+
		"\u0090\u0001\u0090\u0004\u0090\u06b3\b\u0090\u000b\u0090\f\u0090\u06b4"+
		"\u0001\u0090\u0003\u0090\u06b8\b\u0090\u0001\u0090\u0003\u0090\u06bb\b"+
		"\u0090\u0001\u0091\u0004\u0091\u06be\b\u0091\u000b\u0091\f\u0091\u06bf"+
		"\u0001\u0091\u0001\u0091\u0003\u0091\u06c4\b\u0091\u0001\u0092\u0005\u0092"+
		"\u06c7\b\u0092\n\u0092\f\u0092\u06ca\t\u0092\u0001\u0092\u0004\u0092\u06cd"+
		"\b\u0092\u000b\u0092\f\u0092\u06ce\u0001\u0092\u0001\u0092\u0003\u0092"+
		"\u06d3\b\u0092\u0001\u0093\u0001\u0093\u0001\u0093\u0005\u0093\u06d8\b"+
		"\u0093\n\u0093\f\u0093\u06db\t\u0093\u0001\u0093\u0003\u0093\u06de\b\u0093"+
		"\u0001\u0093\u0001\u0093\u0001\u0093\u0004\u0093\u06e3\b\u0093\u000b\u0093"+
		"\f\u0093\u06e4\u0001\u0093\u0003\u0093\u06e8\b\u0093\u0001\u0093\u0003"+
		"\u0093\u06eb\b\u0093\u0001\u0094\u0001\u0094\u0001\u0094\u0001\u0095\u0001"+
		"\u0095\u0003\u0095\u06f2\b\u0095\u0001\u0096\u0001\u0096\u0001\u0096\u0003"+
		"\u0096\u06f7\b\u0096\u0001\u0097\u0001\u0097\u0003\u0097\u06fb\b\u0097"+
		"\u0001\u0097\u0003\u0097\u06fe\b\u0097\u0001\u0098\u0001\u0098\u0001\u0099"+
		"\u0001\u0099\u0003\u0099\u0704\b\u0099\u0001\u009a\u0001\u009a\u0001\u009a"+
		"\u0003\u009a\u0709\b\u009a\u0001\u009a\u0003\u009a\u070c\b\u009a\u0001"+
		"\u009a\u0003\u009a\u070f\b\u009a\u0001\u009a\u0001\u009a\u0001\u009b\u0001"+
		"\u009b\u0001\u009b\u0001\u009c\u0001\u009c\u0005\u009c\u0718\b\u009c\n"+
		"\u009c\f\u009c\u071b\t\u009c\u0001\u009d\u0001\u009d\u0003\u009d\u071f"+
		"\b\u009d\u0001\u009e\u0001\u009e\u0005\u009e\u0723\b\u009e\n\u009e\f\u009e"+
		"\u0726\t\u009e\u0001\u009e\u0001\u009e\u0001\u009f\u0001\u009f\u0001\u00a0"+
		"\u0001\u00a0\u0004\u00a0\u072e\b\u00a0\u000b\u00a0\f\u00a0\u072f\u0001"+
		"\u00a1\u0001\u00a1\u0003\u00a1\u0734\b\u00a1\u0001\u00a1\u0001\u00a1\u0001"+
		"\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a2\u0003\u00a2\u073c\b\u00a2\u0003"+
		"\u00a2\u073e\b\u00a2\u0001\u00a2\u0001\u00a2\u0001\u00a3\u0001\u00a3\u0001"+
		"\u00a3\u0001\u00a3\u0001\u00a4\u0001\u00a4\u0003\u00a4\u0748\b\u00a4\u0001"+
		"\u00a4\u0001\u00a4\u0001\u00a5\u0001\u00a5\u0001\u00a5\u0005\u00a5\u074f"+
		"\b\u00a5\n\u00a5\f\u00a5\u0752\t\u00a5\u0001\u00a5\u0003\u00a5\u0755\b"+
		"\u00a5\u0001\u00a6\u0001\u00a6\u0001\u00a6\u0003\u00a6\u075a\b\u00a6\u0001"+
		"\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a7\u0001\u00a8\u0004\u00a8\u0761"+
		"\b\u00a8\u000b\u00a8\f\u00a8\u0762\u0001\u00a9\u0003\u00a9\u0766\b\u00a9"+
		"\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9\u0001\u00a9"+
		"\u0005\u00a9\u076e\b\u00a9\n\u00a9\f\u00a9\u0771\t\u00a9\u0001\u00aa\u0001"+
		"\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00aa\u0001\u00ab\u0001\u00ab\u0001"+
		"\u00ab\u0001\u00ab\u0001\u00ab\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0003"+
		"\u00ac\u0780\b\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ac\u0001\u00ad\u0001"+
		"\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ad\u0001\u00ae\u0001\u00ae\u0003"+
		"\u00ae\u078c\b\u00ae\u0001\u00af\u0001\u00af\u0001\u00af\u0003\u00af\u0791"+
		"\b\u00af\u0003\u00af\u0793\b\u00af\u0001\u00af\u0001\u00af\u0001\u00af"+
		"\u0001\u00af\u0003\u00af\u0799\b\u00af\u0003\u00af\u079b\b\u00af\u0005"+
		"\u00af\u079d\b\u00af\n\u00af\f\u00af\u07a0\t\u00af\u0001\u00af\u0001\u00af"+
		"\u0003\u00af\u07a4\b\u00af\u0001\u00af\u0003\u00af\u07a7\b\u00af\u0001"+
		"\u00b0\u0001\u00b0\u0001\u00b0\u0005\u00b0\u07ac\b\u00b0\n\u00b0\f\u00b0"+
		"\u07af\t\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0005\u00b0"+
		"\u07b5\b\u00b0\n\u00b0\f\u00b0\u07b8\t\u00b0\u0003\u00b0\u07ba\b\u00b0"+
		"\u0001\u00b0\u0001\u00b0\u0001\u00b0\u0005\u00b0\u07bf\b\u00b0\n\u00b0"+
		"\f\u00b0\u07c2\t\u00b0\u0003\u00b0\u07c4\b\u00b0\u0001\u00b1\u0001\u00b1"+
		"\u0001\u00b1\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2\u0001\u00b2"+
		"\u0003\u00b2\u07ce\b\u00b2\u0001\u00b3\u0001\u00b3\u0001\u00b3\u0001\u00b3"+
		"\u0001\u00b3\u0001\u00b3\u0003\u00b3\u07d6\b\u00b3\u0001\u00b4\u0001\u00b4"+
		"\u0001\u00b4\u0005\u00b4\u07db\b\u00b4\n\u00b4\f\u00b4\u07de\t\u00b4\u0001"+
		"\u00b4\u0003\u00b4\u07e1\b\u00b4\u0001\u00b5\u0001\u00b5\u0001\u00b5\u0005"+
		"\u00b5\u07e6\b\u00b5\n\u00b5\f\u00b5\u07e9\t\u00b5\u0001\u00b5\u0003\u00b5"+
		"\u07ec\b\u00b5\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0001\u00b6\u0004\u00b6"+
		"\u07f2\b\u00b6\u000b\u00b6\f\u00b6\u07f3\u0001\u00b6\u0003\u00b6\u07f7"+
		"\b\u00b6\u0003\u00b6\u07f9\b\u00b6\u0001\u00b7\u0001\u00b7\u0001\u00b7"+
		"\u0003\u00b7\u07fe\b\u00b7\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0001\u00b8"+
		"\u0001\u00b8\u0001\u00b8\u0001\u00b8\u0003\u00b8\u0807\b\u00b8\u0001\u00b8"+
		"\u0003\u00b8\u080a\b\u00b8\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0001\u00b9"+
		"\u0001\u00b9\u0001\u00b9\u0001\u00b9\u0003\u00b9\u0813\b\u00b9\u0001\u00b9"+
		"\u0001\u00b9\u0001\u00b9\u0003\u00b9\u0818\b\u00b9\u0001\u00b9\u0003\u00b9"+
		"\u081b\b\u00b9\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba\u0001\u00ba"+
		"\u0001\u00ba\u0003\u00ba\u0823\b\u00ba\u0001\u00bb\u0001\u00bb\u0001\u00bb"+
		"\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0001\u00bb\u0003\u00bb\u082c\b\u00bb"+
		"\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc"+
		"\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc\u0001\u00bc"+
		"\u0001\u00bc\u0003\u00bc\u083b\b\u00bc\u0001\u00bc\u0003\u00bc\u083e\b"+
		"\u00bc\u0005\u00bc\u0840\b\u00bc\n\u00bc\f\u00bc\u0843\t\u00bc\u0001\u00bd"+
		"\u0001\u00bd\u0001\u00bd\u0005\u00bd\u0848\b\u00bd\n\u00bd\f\u00bd\u084b"+
		"\t\u00bd\u0001\u00bd\u0003\u00bd\u084e\b\u00bd\u0001\u00be\u0001\u00be"+
		"\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be\u0001\u00be\u0003\u00be"+
		"\u0857\b\u00be\u0001\u00be\u0003\u00be\u085a\b\u00be\u0001\u00bf\u0001"+
		"\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0003"+
		"\u00bf\u0863\b\u00bf\u0001\u00bf\u0001\u00bf\u0001\u00bf\u0003\u00bf\u0868"+
		"\b\u00bf\u0001\u00bf\u0003\u00bf\u086b\b\u00bf\u0001\u00c0\u0001\u00c0"+
		"\u0001\u00c0\u0005\u00c0\u0870\b\u00c0\n\u00c0\f\u00c0\u0873\t\u00c0\u0001"+
		"\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0003"+
		"\u00c0\u087b\b\u00c0\u0001\u00c0\u0001\u00c0\u0003\u00c0\u087f\b\u00c0"+
		"\u0003\u00c0\u0881\b\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0\u0001\u00c0"+
		"\u0001\u00c0\u0003\u00c0\u0888\b\u00c0\u0001\u00c0\u0001\u00c0\u0003\u00c0"+
		"\u088c\b\u00c0\u0001\u00c1\u0001\u00c1\u0001\u00c1\u0003\u00c1\u0891\b"+
		"\u00c1\u0001\u00c2\u0001\u00c2\u0001\u00c3\u0001\u00c3\u0003\u00c3\u0897"+
		"\b\u00c3\u0001\u00c3\u0000\t8\u0100\u0102\u0104\u0106\u0108\u010a\u0112"+
		"\u0178\u00c4\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016"+
		"\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprt"+
		"vxz|~\u0080\u0082\u0084\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094"+
		"\u0096\u0098\u009a\u009c\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac"+
		"\u00ae\u00b0\u00b2\u00b4\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4"+
		"\u00c6\u00c8\u00ca\u00cc\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc"+
		"\u00de\u00e0\u00e2\u00e4\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4"+
		"\u00f6\u00f8\u00fa\u00fc\u00fe\u0100\u0102\u0104\u0106\u0108\u010a\u010c"+
		"\u010e\u0110\u0112\u0114\u0116\u0118\u011a\u011c\u011e\u0120\u0122\u0124"+
		"\u0126\u0128\u012a\u012c\u012e\u0130\u0132\u0134\u0136\u0138\u013a\u013c"+
		"\u013e\u0140\u0142\u0144\u0146\u0148\u014a\u014c\u014e\u0150\u0152\u0154"+
		"\u0156\u0158\u015a\u015c\u015e\u0160\u0162\u0164\u0166\u0168\u016a\u016c"+
		"\u016e\u0170\u0172\u0174\u0176\u0178\u017a\u017c\u017e\u0180\u0182\u0184"+
		"\u0186\u0000\u0006\u0003\u0000%/1133\u0002\u0000\u000e\u000e55\u0001\u0000"+
		"\u0012\u0013\u0001\u0000\"#\u0004\u0000\u0014\u0015\u001b\u001b0022\u0002"+
		"\u0000[]__\u094b\u0000\u0189\u0001\u0000\u0000\u0000\u0002\u018d\u0001"+
		"\u0000\u0000\u0000\u0004\u018f\u0001\u0000\u0000\u0000\u0006\u0198\u0001"+
		"\u0000\u0000\u0000\b\u01a8\u0001\u0000\u0000\u0000\n\u01ae\u0001\u0000"+
		"\u0000\u0000\f\u01b6\u0001\u0000\u0000\u0000\u000e\u01b8\u0001\u0000\u0000"+
		"\u0000\u0010\u01d3\u0001\u0000\u0000\u0000\u0012\u01dd\u0001\u0000\u0000"+
		"\u0000\u0014\u0207\u0001\u0000\u0000\u0000\u0016\u020b\u0001\u0000\u0000"+
		"\u0000\u0018\u020d\u0001\u0000\u0000\u0000\u001a\u020f\u0001\u0000\u0000"+
		"\u0000\u001c\u0213\u0001\u0000\u0000\u0000\u001e\u021b\u0001\u0000\u0000"+
		"\u0000 \u0224\u0001\u0000\u0000\u0000\"\u022d\u0001\u0000\u0000\u0000"+
		"$\u0230\u0001\u0000\u0000\u0000&\u0232\u0001\u0000\u0000\u0000(\u023a"+
		"\u0001\u0000\u0000\u0000*\u023c\u0001\u0000\u0000\u0000,\u0252\u0001\u0000"+
		"\u0000\u0000.\u025d\u0001\u0000\u0000\u00000\u025f\u0001\u0000\u0000\u0000"+
		"2\u0267\u0001\u0000\u0000\u00004\u026c\u0001\u0000\u0000\u00006\u0274"+
		"\u0001\u0000\u0000\u00008\u0279\u0001\u0000\u0000\u0000:\u028a\u0001\u0000"+
		"\u0000\u0000<\u0290\u0001\u0000\u0000\u0000>\u0298\u0001\u0000\u0000\u0000"+
		"@\u029a\u0001\u0000\u0000\u0000B\u02ad\u0001\u0000\u0000\u0000D\u02d8"+
		"\u0001\u0000\u0000\u0000F\u02da\u0001\u0000\u0000\u0000H\u030d\u0001\u0000"+
		"\u0000\u0000J\u0310\u0001\u0000\u0000\u0000L\u031b\u0001\u0000\u0000\u0000"+
		"N\u0348\u0001\u0000\u0000\u0000P\u034a\u0001\u0000\u0000\u0000R\u034d"+
		"\u0001\u0000\u0000\u0000T\u0354\u0001\u0000\u0000\u0000V\u035b\u0001\u0000"+
		"\u0000\u0000X\u0363\u0001\u0000\u0000\u0000Z\u036d\u0001\u0000\u0000\u0000"+
		"\\\u0371\u0001\u0000\u0000\u0000^\u0374\u0001\u0000\u0000\u0000`\u0377"+
		"\u0001\u0000\u0000\u0000b\u037a\u0001\u0000\u0000\u0000d\u037d\u0001\u0000"+
		"\u0000\u0000f\u0387\u0001\u0000\u0000\u0000h\u0391\u0001\u0000\u0000\u0000"+
		"j\u0395\u0001\u0000\u0000\u0000l\u039d\u0001\u0000\u0000\u0000n\u03e3"+
		"\u0001\u0000\u0000\u0000p\u03e5\u0001\u0000\u0000\u0000r\u040b\u0001\u0000"+
		"\u0000\u0000t\u040d\u0001\u0000\u0000\u0000v\u0418\u0001\u0000\u0000\u0000"+
		"x\u0422\u0001\u0000\u0000\u0000z\u0426\u0001\u0000\u0000\u0000|\u0438"+
		"\u0001\u0000\u0000\u0000~\u043a\u0001\u0000\u0000\u0000\u0080\u0442\u0001"+
		"\u0000\u0000\u0000\u0082\u0447\u0001\u0000\u0000\u0000\u0084\u044b\u0001"+
		"\u0000\u0000\u0000\u0086\u044d\u0001\u0000\u0000\u0000\u0088\u0451\u0001"+
		"\u0000\u0000\u0000\u008a\u0461\u0001\u0000\u0000\u0000\u008c\u0469\u0001"+
		"\u0000\u0000\u0000\u008e\u0471\u0001\u0000\u0000\u0000\u0090\u0473\u0001"+
		"\u0000\u0000\u0000\u0092\u0478\u0001\u0000\u0000\u0000\u0094\u047d\u0001"+
		"\u0000\u0000\u0000\u0096\u0481\u0001\u0000\u0000\u0000\u0098\u0483\u0001"+
		"\u0000\u0000\u0000\u009a\u0485\u0001\u0000\u0000\u0000\u009c\u0487\u0001"+
		"\u0000\u0000\u0000\u009e\u0489\u0001\u0000\u0000\u0000\u00a0\u048b\u0001"+
		"\u0000\u0000\u0000\u00a2\u048d\u0001\u0000\u0000\u0000\u00a4\u0494\u0001"+
		"\u0000\u0000\u0000\u00a6\u049c\u0001\u0000\u0000\u0000\u00a8\u04aa\u0001"+
		"\u0000\u0000\u0000\u00aa\u04ac\u0001\u0000\u0000\u0000\u00ac\u04b1\u0001"+
		"\u0000\u0000\u0000\u00ae\u04be\u0001\u0000\u0000\u0000\u00b0\u04c0\u0001"+
		"\u0000\u0000\u0000\u00b2\u04d7\u0001\u0000\u0000\u0000\u00b4\u04d9\u0001"+
		"\u0000\u0000\u0000\u00b6\u04e3\u0001\u0000\u0000\u0000\u00b8\u04e8\u0001"+
		"\u0000\u0000\u0000\u00ba\u04eb\u0001\u0000\u0000\u0000\u00bc\u04fc\u0001"+
		"\u0000\u0000\u0000\u00be\u0504\u0001\u0000\u0000\u0000\u00c0\u050c\u0001"+
		"\u0000\u0000\u0000\u00c2\u0510\u0001\u0000\u0000\u0000\u00c4\u0518\u0001"+
		"\u0000\u0000\u0000\u00c6\u051c\u0001\u0000\u0000\u0000\u00c8\u0538\u0001"+
		"\u0000\u0000\u0000\u00ca\u053a\u0001\u0000\u0000\u0000\u00cc\u053d\u0001"+
		"\u0000\u0000\u0000\u00ce\u0540\u0001\u0000\u0000\u0000\u00d0\u0543\u0001"+
		"\u0000\u0000\u0000\u00d2\u0557\u0001\u0000\u0000\u0000\u00d4\u0559\u0001"+
		"\u0000\u0000\u0000\u00d6\u0561\u0001\u0000\u0000\u0000\u00d8\u056f\u0001"+
		"\u0000\u0000\u0000\u00da\u0571\u0001\u0000\u0000\u0000\u00dc\u057f\u0001"+
		"\u0000\u0000\u0000\u00de\u0581\u0001\u0000\u0000\u0000\u00e0\u0587\u0001"+
		"\u0000\u0000\u0000\u00e2\u0589\u0001\u0000\u0000\u0000\u00e4\u0591\u0001"+
		"\u0000\u0000\u0000\u00e6\u059c\u0001\u0000\u0000\u0000\u00e8\u059e\u0001"+
		"\u0000\u0000\u0000\u00ea\u05af\u0001\u0000\u0000\u0000\u00ec\u05b1\u0001"+
		"\u0000\u0000\u0000\u00ee\u05b4\u0001\u0000\u0000\u0000\u00f0\u05b7\u0001"+
		"\u0000\u0000\u0000\u00f2\u05ba\u0001\u0000\u0000\u0000\u00f4\u05bd\u0001"+
		"\u0000\u0000\u0000\u00f6\u05c0\u0001\u0000\u0000\u0000\u00f8\u05c3\u0001"+
		"\u0000\u0000\u0000\u00fa\u05c7\u0001\u0000\u0000\u0000\u00fc\u05ca\u0001"+
		"\u0000\u0000\u0000\u00fe\u05ce\u0001\u0000\u0000\u0000\u0100\u05d1\u0001"+
		"\u0000\u0000\u0000\u0102\u05dc\u0001\u0000\u0000\u0000\u0104\u05e7\u0001"+
		"\u0000\u0000\u0000\u0106\u05f2\u0001\u0000\u0000\u0000\u0108\u05fd\u0001"+
		"\u0000\u0000\u0000\u010a\u0608\u0001\u0000\u0000\u0000\u010c\u061a\u0001"+
		"\u0000\u0000\u0000\u010e\u061c\u0001\u0000\u0000\u0000\u0110\u0624\u0001"+
		"\u0000\u0000\u0000\u0112\u0626\u0001\u0000\u0000\u0000\u0114\u064f\u0001"+
		"\u0000\u0000\u0000\u0116\u065f\u0001\u0000\u0000\u0000\u0118\u0677\u0001"+
		"\u0000\u0000\u0000\u011a\u0679\u0001\u0000\u0000\u0000\u011c\u0680\u0001"+
		"\u0000\u0000\u0000\u011e\u0687\u0001\u0000\u0000\u0000\u0120\u06ba\u0001"+
		"\u0000\u0000\u0000\u0122\u06bd\u0001\u0000\u0000\u0000\u0124\u06c8\u0001"+
		"\u0000\u0000\u0000\u0126\u06ea\u0001\u0000\u0000\u0000\u0128\u06ec\u0001"+
		"\u0000\u0000\u0000\u012a\u06ef\u0001\u0000\u0000\u0000\u012c\u06f3\u0001"+
		"\u0000\u0000\u0000\u012e\u06f8\u0001\u0000\u0000\u0000\u0130\u06ff\u0001"+
		"\u0000\u0000\u0000\u0132\u0703\u0001\u0000\u0000\u0000\u0134\u0705\u0001"+
		"\u0000\u0000\u0000\u0136\u0712\u0001\u0000\u0000\u0000\u0138\u0715\u0001"+
		"\u0000\u0000\u0000\u013a\u071e\u0001\u0000\u0000\u0000\u013c\u0720\u0001"+
		"\u0000\u0000\u0000\u013e\u0729\u0001\u0000\u0000\u0000\u0140\u072d\u0001"+
		"\u0000\u0000\u0000\u0142\u0731\u0001\u0000\u0000\u0000\u0144\u0737\u0001"+
		"\u0000\u0000\u0000\u0146\u0741\u0001\u0000\u0000\u0000\u0148\u0745\u0001"+
		"\u0000\u0000\u0000\u014a\u074b\u0001\u0000\u0000\u0000\u014c\u0759\u0001"+
		"\u0000\u0000\u0000\u014e\u075b\u0001\u0000\u0000\u0000\u0150\u0760\u0001"+
		"\u0000\u0000\u0000\u0152\u0765\u0001\u0000\u0000\u0000\u0154\u0772\u0001"+
		"\u0000\u0000\u0000\u0156\u0777\u0001\u0000\u0000\u0000\u0158\u077c\u0001"+
		"\u0000\u0000\u0000\u015a\u0784\u0001\u0000\u0000\u0000\u015c\u0789\u0001"+
		"\u0000\u0000\u0000\u015e\u07a6\u0001\u0000\u0000\u0000\u0160\u07c3\u0001"+
		"\u0000\u0000\u0000\u0162\u07c5\u0001\u0000\u0000\u0000\u0164\u07cd\u0001"+
		"\u0000\u0000\u0000\u0166\u07d5\u0001\u0000\u0000\u0000\u0168\u07d7\u0001"+
		"\u0000\u0000\u0000\u016a\u07e2\u0001\u0000\u0000\u0000\u016c\u07ed\u0001"+
		"\u0000\u0000\u0000\u016e\u07fd\u0001\u0000\u0000\u0000\u0170\u0809\u0001"+
		"\u0000\u0000\u0000\u0172\u081a\u0001\u0000\u0000\u0000\u0174\u0822\u0001"+
		"\u0000\u0000\u0000\u0176\u0824\u0001\u0000\u0000\u0000\u0178\u082d\u0001"+
		"\u0000\u0000\u0000\u017a\u0844\u0001\u0000\u0000\u0000\u017c\u0859\u0001"+
		"\u0000\u0000\u0000\u017e\u086a\u0001\u0000\u0000\u0000\u0180\u088b\u0001"+
		"\u0000\u0000\u0000\u0182\u0890\u0001\u0000\u0000\u0000\u0184\u0892\u0001"+
		"\u0000\u0000\u0000\u0186\u0896\u0001\u0000\u0000\u0000\u0188\u018a\u0003"+
		"\b\u0004\u0000\u0189\u0188\u0001\u0000\u0000\u0000\u0189\u018a\u0001\u0000"+
		"\u0000\u0000\u018a\u018b\u0001\u0000\u0000\u0000\u018b\u018c\u0005\u0000"+
		"\u0000\u0001\u018c\u0001\u0001\u0000\u0000\u0000\u018d\u018e\u0003\f\u0006"+
		"\u0000\u018e\u0003\u0001\u0000\u0000\u0000\u018f\u0193\u0003\u00d0h\u0000"+
		"\u0190\u0192\u0005b\u0000\u0000\u0191\u0190\u0001\u0000\u0000\u0000\u0192"+
		"\u0195\u0001\u0000\u0000\u0000\u0193\u0191\u0001\u0000\u0000\u0000\u0193"+
		"\u0194\u0001\u0000\u0000\u0000\u0194\u0196\u0001\u0000\u0000\u0000\u0195"+
		"\u0193\u0001\u0000\u0000\u0000\u0196\u0197\u0005\u0000\u0000\u0001\u0197"+
		"\u0005\u0001\u0000\u0000\u0000\u0198\u019a\u0005\b\u0000\u0000\u0199\u019b"+
		"\u0003\u0180\u00c0\u0000\u019a\u0199\u0001\u0000\u0000\u0000\u019a\u019b"+
		"\u0001\u0000\u0000\u0000\u019b\u019c\u0001\u0000\u0000\u0000\u019c\u019d"+
		"\u0005\u000b\u0000\u0000\u019d\u019e\u00054\u0000\u0000\u019e\u01a2\u0003"+
		"\u00d2i\u0000\u019f\u01a1\u0005b\u0000\u0000\u01a0\u019f\u0001\u0000\u0000"+
		"\u0000\u01a1\u01a4\u0001\u0000\u0000\u0000\u01a2\u01a0\u0001\u0000\u0000"+
		"\u0000\u01a2\u01a3\u0001\u0000\u0000\u0000\u01a3\u01a5\u0001\u0000\u0000"+
		"\u0000\u01a4\u01a2\u0001\u0000\u0000\u0000\u01a5\u01a6\u0005\u0000\u0000"+
		"\u0001\u01a6\u0007\u0001\u0000\u0000\u0000\u01a7\u01a9\u0003\n\u0005\u0000"+
		"\u01a8\u01a7\u0001\u0000\u0000\u0000\u01a9\u01aa\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a8\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000"+
		"\u01ab\t\u0001\u0000\u0000\u0000\u01ac\u01af\u0003\u0012\t\u0000\u01ad"+
		"\u01af\u0003\u000e\u0007\u0000\u01ae\u01ac\u0001\u0000\u0000\u0000\u01ae"+
		"\u01ad\u0001\u0000\u0000\u0000\u01af\u000b\u0001\u0000\u0000\u0000\u01b0"+
		"\u01b1\u0003\u0012\t\u0000\u01b1\u01b2\u0005b\u0000\u0000\u01b2\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b3\u01b7\u0003\u000e\u0007\u0000\u01b4\u01b7"+
		"\u0005b\u0000\u0000\u01b5\u01b7\u0005\u0000\u0000\u0001\u01b6\u01b0\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b3\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b6\u01b5\u0001\u0000\u0000\u0000\u01b7\r\u0001\u0000"+
		"\u0000\u0000\u01b8\u01bd\u0003\u0010\b\u0000\u01b9\u01ba\u0005\u0011\u0000"+
		"\u0000\u01ba\u01bc\u0003\u0010\b\u0000\u01bb\u01b9\u0001\u0000\u0000\u0000"+
		"\u01bc\u01bf\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000"+
		"\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01c1\u0001\u0000\u0000\u0000"+
		"\u01bf\u01bd\u0001\u0000\u0000\u0000\u01c0\u01c2\u0005\u0011\u0000\u0000"+
		"\u01c1\u01c0\u0001\u0000\u0000\u0000\u01c1\u01c2\u0001\u0000\u0000\u0000"+
		"\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4\u0005b\u0000\u0000\u01c4"+
		"\u000f\u0001\u0000\u0000\u0000\u01c5\u01d4\u0003\u0014\n\u0000\u01c6\u01d4"+
		"\u0003\u00c2a\u0000\u01c7\u01d4\u0003\u00d6k\u0000\u01c8\u01d4\u0003\u001a"+
		"\r\u0000\u01c9\u01d4\u0003(\u0014\u0000\u01ca\u01d4\u0003\u001c\u000e"+
		"\u0000\u01cb\u01d4\u0005<\u0000\u0000\u01cc\u01d4\u0003\"\u0011\u0000"+
		"\u01cd\u01d4\u0003$\u0012\u0000\u01ce\u01d4\u0003&\u0013\u0000\u01cf\u01d4"+
		"\u0005>\u0000\u0000\u01d0\u01d4\u0005H\u0000\u0000\u01d1\u01d4\u0003\u001e"+
		"\u000f\u0000\u01d2\u01d4\u0003 \u0010\u0000\u01d3\u01c5\u0001\u0000\u0000"+
		"\u0000\u01d3\u01c6\u0001\u0000\u0000\u0000\u01d3\u01c7\u0001\u0000\u0000"+
		"\u0000\u01d3\u01c8\u0001\u0000\u0000\u0000\u01d3\u01c9\u0001\u0000\u0000"+
		"\u0000\u01d3\u01ca\u0001\u0000\u0000\u0000\u01d3\u01cb\u0001\u0000\u0000"+
		"\u0000\u01d3\u01cc\u0001\u0000\u0000\u0000\u01d3\u01cd\u0001\u0000\u0000"+
		"\u0000\u01d3\u01ce\u0001\u0000\u0000\u0000\u01d3\u01cf\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d0\u0001\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d2\u0001\u0000\u0000\u0000\u01d4\u0011\u0001\u0000\u0000"+
		"\u0000\u01d5\u01de\u0003B!\u0000\u01d6\u01de\u0003d2\u0000\u01d7\u01de"+
		"\u0003>\u001f\u0000\u01d8\u01de\u0003n7\u0000\u01d9\u01de\u0003l6\u0000"+
		"\u01da\u01de\u0003r9\u0000\u01db\u01de\u0003j5\u0000\u01dc\u01de\u0003"+
		"z=\u0000\u01dd\u01d5\u0001\u0000\u0000\u0000\u01dd\u01d6\u0001\u0000\u0000"+
		"\u0000\u01dd\u01d7\u0001\u0000\u0000\u0000\u01dd\u01d8\u0001\u0000\u0000"+
		"\u0000\u01dd\u01d9\u0001\u0000\u0000\u0000\u01dd\u01da\u0001\u0000\u0000"+
		"\u0000\u01dd\u01db\u0001\u0000\u0000\u0000\u01dd\u01dc\u0001\u0000\u0000"+
		"\u0000\u01de\u0013\u0001\u0000\u0000\u0000\u01df\u01e0\u0003\u0186\u00c3"+
		"\u0000\u01e0\u01e1\u0005\u000f\u0000\u0000\u01e1\u01e4\u0003\u00d2i\u0000"+
		"\u01e2\u01e3\u0005\u001a\u0000\u0000\u01e3\u01e5\u0003\u0016\u000b\u0000"+
		"\u01e4\u01e2\u0001\u0000\u0000\u0000\u01e4\u01e5\u0001\u0000\u0000\u0000"+
		"\u01e5\u0208\u0001\u0000\u0000\u0000\u01e6\u01e7\u0005\b\u0000\u0000\u01e7"+
		"\u01e8\u0003\u0174\u00ba\u0000\u01e8\u01e9\u0005\u000b\u0000\u0000\u01e9"+
		"\u01ec\u0001\u0000\u0000\u0000\u01ea\u01ec\u0003\u0176\u00bb\u0000\u01eb"+
		"\u01e6\u0001\u0000\u0000\u0000\u01eb\u01ea\u0001\u0000\u0000\u0000\u01ec"+
		"\u01ed\u0001\u0000\u0000\u0000\u01ed\u01ee\u0005\u000f\u0000\u0000\u01ee"+
		"\u01f1\u0003\u00d2i\u0000\u01ef\u01f0\u0005\u001a\u0000\u0000\u01f0\u01f2"+
		"\u0003\u0016\u000b\u0000\u01f1\u01ef\u0001\u0000\u0000\u0000\u01f1\u01f2"+
		"\u0001\u0000\u0000\u0000\u01f2\u0208\u0001\u0000\u0000\u0000\u01f3\u01f4"+
		"\u0003\u0168\u00b4\u0000\u01f4\u01f5\u0005\u001a\u0000\u0000\u01f5\u01f7"+
		"\u0001\u0000\u0000\u0000\u01f6\u01f3\u0001\u0000\u0000\u0000\u01f7\u01f8"+
		"\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8\u01f9"+
		"\u0001\u0000\u0000\u0000\u01f9\u01fc\u0001\u0000\u0000\u0000\u01fa\u01fd"+
		"\u0003\u00d4j\u0000\u01fb\u01fd\u0003\u00d6k\u0000\u01fc\u01fa\u0001\u0000"+
		"\u0000\u0000\u01fc\u01fb\u0001\u0000\u0000\u0000\u01fd\u01ff\u0001\u0000"+
		"\u0000\u0000\u01fe\u0200\u0005\u0004\u0000\u0000\u01ff\u01fe\u0001\u0000"+
		"\u0000\u0000\u01ff\u0200\u0001\u0000\u0000\u0000\u0200\u0208\u0001\u0000"+
		"\u0000\u0000\u0201\u0202\u0003\u0174\u00ba\u0000\u0202\u0205\u0003\u0018"+
		"\f\u0000\u0203\u0206\u0003\u00d4j\u0000\u0204\u0206\u0003\u00d6k\u0000"+
		"\u0205\u0203\u0001\u0000\u0000\u0000\u0205\u0204\u0001\u0000\u0000\u0000"+
		"\u0206\u0208\u0001\u0000\u0000\u0000\u0207\u01df\u0001\u0000\u0000\u0000"+
		"\u0207\u01eb\u0001\u0000\u0000\u0000\u0207\u01f6\u0001\u0000\u0000\u0000"+
		"\u0207\u0201\u0001\u0000\u0000\u0000\u0208\u0015\u0001\u0000\u0000\u0000"+
		"\u0209\u020c\u0003\u00d4j\u0000\u020a\u020c\u0003\u00d6k\u0000\u020b\u0209"+
		"\u0001\u0000\u0000\u0000\u020b\u020a\u0001\u0000\u0000\u0000\u020c\u0017"+
		"\u0001\u0000\u0000\u0000\u020d\u020e\u0007\u0000\u0000\u0000\u020e\u0019"+
		"\u0001\u0000\u0000\u0000\u020f\u0211\u0005F\u0000\u0000\u0210\u0212\u0003"+
		"\u00d6k\u0000\u0211\u0210\u0001\u0000\u0000\u0000\u0211\u0212\u0001\u0000"+
		"\u0000\u0000\u0212\u001b\u0001\u0000\u0000\u0000\u0213\u0219\u0005A\u0000"+
		"\u0000\u0214\u0217\u0003\u00d2i\u0000\u0215\u0216\u0005N\u0000\u0000\u0216"+
		"\u0218\u0003\u00d2i\u0000\u0217\u0215\u0001\u0000\u0000\u0000\u0217\u0218"+
		"\u0001\u0000\u0000\u0000\u0218\u021a\u0001\u0000\u0000\u0000\u0219\u0214"+
		"\u0001\u0000\u0000\u0000\u0219\u021a\u0001\u0000\u0000\u0000\u021a\u001d"+
		"\u0001\u0000\u0000\u0000\u021b\u021c\u0005S\u0000\u0000\u021c\u0221\u0003"+
		"\u0186\u00c3\u0000\u021d\u021e\u0005\u0010\u0000\u0000\u021e\u0220\u0003"+
		"\u0186\u00c3\u0000\u021f\u021d\u0001\u0000\u0000\u0000\u0220\u0223\u0001"+
		"\u0000\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0221\u0222\u0001"+
		"\u0000\u0000\u0000\u0222\u001f\u0001\u0000\u0000\u0000\u0223\u0221\u0001"+
		"\u0000\u0000\u0000\u0224\u0225\u0005O\u0000\u0000\u0225\u022a\u0003\u0186"+
		"\u00c3\u0000\u0226\u0227\u0005\u0010\u0000\u0000\u0227\u0229\u0003\u0186"+
		"\u00c3\u0000\u0228\u0226\u0001\u0000\u0000\u0000\u0229\u022c\u0001\u0000"+
		"\u0000\u0000\u022a\u0228\u0001\u0000\u0000\u0000\u022a\u022b\u0001\u0000"+
		"\u0000\u0000\u022b!\u0001\u0000\u0000\u0000\u022c\u022a\u0001\u0000\u0000"+
		"\u0000\u022d\u022e\u0005R\u0000\u0000\u022e\u022f\u0003\u017a\u00bd\u0000"+
		"\u022f#\u0001\u0000\u0000\u0000\u0230\u0231\u0003\u00d4j\u0000\u0231%"+
		"\u0001\u0000\u0000\u0000\u0232\u0233\u0005Q\u0000\u0000\u0233\u0236\u0003"+
		"\u00d2i\u0000\u0234\u0235\u0005\u0010\u0000\u0000\u0235\u0237\u0003\u00d2"+
		"i\u0000\u0236\u0234\u0001\u0000\u0000\u0000\u0236\u0237\u0001\u0000\u0000"+
		"\u0000\u0237\'\u0001\u0000\u0000\u0000\u0238\u023b\u0003*\u0015\u0000"+
		"\u0239\u023b\u0003,\u0016\u0000\u023a\u0238\u0001\u0000\u0000\u0000\u023a"+
		"\u0239\u0001\u0000\u0000\u0000\u023b)\u0001\u0000\u0000\u0000\u023c\u023d"+
		"\u0005;\u0000\u0000\u023d\u023e\u00034\u001a\u0000\u023e+\u0001\u0000"+
		"\u0000\u0000\u023f\u0243\u0005N\u0000\u0000\u0240\u0242\u0007\u0001\u0000"+
		"\u0000\u0241\u0240\u0001\u0000\u0000\u0000\u0242\u0245\u0001\u0000\u0000"+
		"\u0000\u0243\u0241\u0001\u0000\u0000\u0000\u0243\u0244\u0001\u0000\u0000"+
		"\u0000\u0244\u0246\u0001\u0000\u0000\u0000\u0245\u0243\u0001\u0000\u0000"+
		"\u0000\u0246\u0247\u00038\u001c\u0000\u0247\u0248\u0005;\u0000\u0000\u0248"+
		"\u0249\u0003.\u0017\u0000\u0249\u0253\u0001\u0000\u0000\u0000\u024a\u024c"+
		"\u0005N\u0000\u0000\u024b\u024d\u0007\u0001\u0000\u0000\u024c\u024b\u0001"+
		"\u0000\u0000\u0000\u024d\u024e\u0001\u0000\u0000\u0000\u024e\u024c\u0001"+
		"\u0000\u0000\u0000\u024e\u024f\u0001\u0000\u0000\u0000\u024f\u0250\u0001"+
		"\u0000\u0000\u0000\u0250\u0251\u0005;\u0000\u0000\u0251\u0253\u0003.\u0017"+
		"\u0000\u0252\u023f\u0001\u0000\u0000\u0000\u0252\u024a\u0001\u0000\u0000"+
		"\u0000\u0253-\u0001\u0000\u0000\u0000\u0254\u0255\u0005\b\u0000\u0000"+
		"\u0255\u0257\u00030\u0018\u0000\u0256\u0258\u0005\u0010\u0000\u0000\u0257"+
		"\u0256\u0001\u0000\u0000\u0000\u0257\u0258\u0001\u0000\u0000\u0000\u0258"+
		"\u0259\u0001\u0000\u0000\u0000\u0259\u025a\u0005\u000b\u0000\u0000\u025a"+
		"\u025e\u0001\u0000\u0000\u0000\u025b\u025e\u00030\u0018\u0000\u025c\u025e"+
		"\u0005\u0014\u0000\u0000\u025d\u0254\u0001\u0000\u0000\u0000\u025d\u025b"+
		"\u0001\u0000\u0000\u0000\u025d\u025c\u0001\u0000\u0000\u0000\u025e/\u0001"+
		"\u0000\u0000\u0000\u025f\u0264\u00032\u0019\u0000\u0260\u0261\u0005\u0010"+
		"\u0000\u0000\u0261\u0263\u00032\u0019\u0000\u0262\u0260\u0001\u0000\u0000"+
		"\u0000\u0263\u0266\u0001\u0000\u0000\u0000\u0264\u0262\u0001\u0000\u0000"+
		"\u0000\u0264\u0265\u0001\u0000\u0000\u0000\u02651\u0001\u0000\u0000\u0000"+
		"\u0266\u0264\u0001\u0000\u0000\u0000\u0267\u026a\u0003\u0186\u00c3\u0000"+
		"\u0268\u0269\u0005L\u0000\u0000\u0269\u026b\u0003\u0186\u00c3\u0000\u026a"+
		"\u0268\u0001\u0000\u0000\u0000\u026a\u026b\u0001\u0000\u0000\u0000\u026b"+
		"3\u0001\u0000\u0000\u0000\u026c\u0271\u00036\u001b\u0000\u026d\u026e\u0005"+
		"\u0010\u0000\u0000\u026e\u0270\u00036\u001b\u0000\u026f\u026d\u0001\u0000"+
		"\u0000\u0000\u0270\u0273\u0001\u0000\u0000\u0000\u0271\u026f\u0001\u0000"+
		"\u0000\u0000\u0271\u0272\u0001\u0000\u0000\u0000\u02725\u0001\u0000\u0000"+
		"\u0000\u0273\u0271\u0001\u0000\u0000\u0000\u0274\u0277\u00038\u001c\u0000"+
		"\u0275\u0276\u0005L\u0000\u0000\u0276\u0278\u0003\u0186\u00c3\u0000\u0277"+
		"\u0275\u0001\u0000\u0000\u0000\u0277\u0278\u0001\u0000\u0000\u0000\u0278"+
		"7\u0001\u0000\u0000\u0000\u0279\u027a\u0006\u001c\uffff\uffff\u0000\u027a"+
		"\u027b\u0003\u0186\u00c3\u0000\u027b\u0281\u0001\u0000\u0000\u0000\u027c"+
		"\u027d\n\u0002\u0000\u0000\u027d\u027e\u0005\u000e\u0000\u0000\u027e\u0280"+
		"\u0003\u0186\u00c3\u0000\u027f\u027c\u0001\u0000\u0000\u0000\u0280\u0283"+
		"\u0001\u0000\u0000\u0000\u0281\u027f\u0001\u0000\u0000\u0000\u0281\u0282"+
		"\u0001\u0000\u0000\u0000\u02829\u0001\u0000\u0000\u0000\u0283\u0281\u0001"+
		"\u0000\u0000\u0000\u0284\u0285\u0005b\u0000\u0000\u0285\u0286\u0005\u0002"+
		"\u0000\u0000\u0286\u0287\u0003\b\u0004\u0000\u0287\u0288\u0005\u0003\u0000"+
		"\u0000\u0288\u028b\u0001\u0000\u0000\u0000\u0289\u028b\u0003\u000e\u0007"+
		"\u0000\u028a\u0284\u0001\u0000\u0000\u0000\u028a\u0289\u0001\u0000\u0000"+
		"\u0000\u028b;\u0001\u0000\u0000\u0000\u028c\u028d\u00052\u0000\u0000\u028d"+
		"\u028e\u0003\u00e0p\u0000\u028e\u028f\u0005b\u0000\u0000\u028f\u0291\u0001"+
		"\u0000\u0000\u0000\u0290\u028c\u0001\u0000\u0000\u0000\u0291\u0292\u0001"+
		"\u0000\u0000\u0000\u0292\u0290\u0001\u0000\u0000\u0000\u0292\u0293\u0001"+
		"\u0000\u0000\u0000\u0293=\u0001\u0000\u0000\u0000\u0294\u0295\u0003<\u001e"+
		"\u0000\u0295\u0296\u0003@ \u0000\u0296\u0299\u0001\u0000\u0000\u0000\u0297"+
		"\u0299\u0003@ \u0000\u0298\u0294\u0001\u0000\u0000\u0000\u0298\u0297\u0001"+
		"\u0000\u0000\u0000\u0299?\u0001\u0000\u0000\u0000\u029a\u029b\u0005C\u0000"+
		"\u0000\u029b\u029d\u0003\u0186\u00c3\u0000\u029c\u029e\u0003\u00c4b\u0000"+
		"\u029d\u029c\u0001\u0000\u0000\u0000\u029d\u029e\u0001\u0000\u0000\u0000"+
		"\u029e\u02a4\u0001\u0000\u0000\u0000\u029f\u02a1\u0005\b\u0000\u0000\u02a0"+
		"\u02a2\u0003\u015c\u00ae\u0000\u02a1\u02a0\u0001\u0000\u0000\u0000\u02a1"+
		"\u02a2\u0001\u0000\u0000\u0000\u02a2\u02a3\u0001\u0000\u0000\u0000\u02a3"+
		"\u02a5\u0005\u000b\u0000\u0000\u02a4\u029f\u0001\u0000\u0000\u0000\u02a4"+
		"\u02a5\u0001\u0000\u0000\u0000\u02a5\u02a6\u0001\u0000\u0000\u0000\u02a6"+
		"\u02a7\u0005\u000f\u0000\u0000\u02a7\u02a8\u0003:\u001d\u0000\u02a8A\u0001"+
		"\u0000\u0000\u0000\u02a9\u02aa\u0003<\u001e\u0000\u02aa\u02ab\u0003D\""+
		"\u0000\u02ab\u02ae\u0001\u0000\u0000\u0000\u02ac\u02ae\u0003D\"\u0000"+
		"\u02ad\u02a9\u0001\u0000\u0000\u0000\u02ad\u02ac\u0001\u0000\u0000\u0000"+
		"\u02aeC\u0001\u0000\u0000\u0000\u02af\u02b0\u0005M\u0000\u0000\u02b0\u02b2"+
		"\u0003\u0186\u00c3\u0000\u02b1\u02b3\u0003\u00c4b\u0000\u02b2\u02b1\u0001"+
		"\u0000\u0000\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000\u02b3\u02b4\u0001"+
		"\u0000\u0000\u0000\u02b4\u02b6\u0005\b\u0000\u0000\u02b5\u02b7\u0003F"+
		"#\u0000\u02b6\u02b5\u0001\u0000\u0000\u0000\u02b6\u02b7\u0001\u0000\u0000"+
		"\u0000\u02b7\u02b8\u0001\u0000\u0000\u0000\u02b8\u02bb\u0005\u000b\u0000"+
		"\u0000\u02b9\u02ba\u00054\u0000\u0000\u02ba\u02bc\u0003\u00d2i\u0000\u02bb"+
		"\u02b9\u0001\u0000\u0000\u0000\u02bb\u02bc\u0001\u0000\u0000\u0000\u02bc"+
		"\u02bd\u0001\u0000\u0000\u0000\u02bd\u02bf\u0005\u000f\u0000\u0000\u02be"+
		"\u02c0\u0003\u0182\u00c1\u0000\u02bf\u02be\u0001\u0000\u0000\u0000\u02bf"+
		"\u02c0\u0001\u0000\u0000\u0000\u02c0\u02c1\u0001\u0000\u0000\u0000\u02c1"+
		"\u02c2\u0003:\u001d\u0000\u02c2\u02d9\u0001\u0000\u0000\u0000\u02c3\u02c4"+
		"\u0005V\u0000\u0000\u02c4\u02c5\u0005M\u0000\u0000\u02c5\u02c7\u0003\u0186"+
		"\u00c3\u0000\u02c6\u02c8\u0003\u00c4b\u0000\u02c7\u02c6\u0001\u0000\u0000"+
		"\u0000\u02c7\u02c8\u0001\u0000\u0000\u0000\u02c8\u02c9\u0001\u0000\u0000"+
		"\u0000\u02c9\u02cb\u0005\b\u0000\u0000\u02ca\u02cc\u0003F#\u0000\u02cb"+
		"\u02ca\u0001\u0000\u0000\u0000\u02cb\u02cc\u0001\u0000\u0000\u0000\u02cc"+
		"\u02cd\u0001\u0000\u0000\u0000\u02cd\u02d0\u0005\u000b\u0000\u0000\u02ce"+
		"\u02cf\u00054\u0000\u0000\u02cf\u02d1\u0003\u00d2i\u0000\u02d0\u02ce\u0001"+
		"\u0000\u0000\u0000\u02d0\u02d1\u0001\u0000\u0000\u0000\u02d1\u02d2\u0001"+
		"\u0000\u0000\u0000\u02d2\u02d4\u0005\u000f\u0000\u0000\u02d3\u02d5\u0003"+
		"\u0182\u00c1\u0000\u02d4\u02d3\u0001\u0000\u0000\u0000\u02d4\u02d5\u0001"+
		"\u0000\u0000\u0000\u02d5\u02d6\u0001\u0000\u0000\u0000\u02d6\u02d7\u0003"+
		":\u001d\u0000\u02d7\u02d9\u0001\u0000\u0000\u0000\u02d8\u02af\u0001\u0000"+
		"\u0000\u0000\u02d8\u02c3\u0001\u0000\u0000\u0000\u02d9E\u0001\u0000\u0000"+
		"\u0000\u02da\u02db\u0003H$\u0000\u02dbG\u0001\u0000\u0000\u0000\u02dc"+
		"\u02e0\u0003J%\u0000\u02dd\u02df\u0003R)\u0000\u02de\u02dd\u0001\u0000"+
		"\u0000\u0000\u02df\u02e2\u0001\u0000\u0000\u0000\u02e0\u02de\u0001\u0000"+
		"\u0000\u0000\u02e0\u02e1\u0001\u0000\u0000\u0000\u02e1\u02e6\u0001\u0000"+
		"\u0000\u0000\u02e2\u02e0\u0001\u0000\u0000\u0000\u02e3\u02e5\u0003V+\u0000"+
		"\u02e4\u02e3\u0001\u0000\u0000\u0000\u02e5\u02e8\u0001\u0000\u0000\u0000"+
		"\u02e6\u02e4\u0001\u0000\u0000\u0000\u02e6\u02e7\u0001\u0000\u0000\u0000"+
		"\u02e7\u02ea\u0001\u0000\u0000\u0000\u02e8\u02e6\u0001\u0000\u0000\u0000"+
		"\u02e9\u02eb\u0003N\'\u0000\u02ea\u02e9\u0001\u0000\u0000\u0000\u02ea"+
		"\u02eb\u0001\u0000\u0000\u0000\u02eb\u030e\u0001\u0000\u0000\u0000\u02ec"+
		"\u02f0\u0003L&\u0000\u02ed\u02ef\u0003V+\u0000\u02ee\u02ed\u0001\u0000"+
		"\u0000\u0000\u02ef\u02f2\u0001\u0000\u0000\u0000\u02f0\u02ee\u0001\u0000"+
		"\u0000\u0000\u02f0\u02f1\u0001\u0000\u0000\u0000\u02f1\u02f4\u0001\u0000"+
		"\u0000\u0000\u02f2\u02f0\u0001\u0000\u0000\u0000\u02f3\u02f5\u0003N\'"+
		"\u0000\u02f4\u02f3\u0001\u0000\u0000\u0000\u02f4\u02f5\u0001\u0000\u0000"+
		"\u0000\u02f5\u030e\u0001\u0000\u0000\u0000\u02f6\u02f8\u0003R)\u0000\u02f7"+
		"\u02f6\u0001\u0000\u0000\u0000\u02f8\u02f9\u0001\u0000\u0000\u0000\u02f9"+
		"\u02f7\u0001\u0000\u0000\u0000\u02f9\u02fa\u0001\u0000\u0000\u0000\u02fa"+
		"\u02fe\u0001\u0000\u0000\u0000\u02fb\u02fd\u0003V+\u0000\u02fc\u02fb\u0001"+
		"\u0000\u0000\u0000\u02fd\u0300\u0001\u0000\u0000\u0000\u02fe\u02fc\u0001"+
		"\u0000\u0000\u0000\u02fe\u02ff\u0001\u0000\u0000\u0000\u02ff\u0302\u0001"+
		"\u0000\u0000\u0000\u0300\u02fe\u0001\u0000\u0000\u0000\u0301\u0303\u0003"+
		"N\'\u0000\u0302\u0301\u0001\u0000\u0000\u0000\u0302\u0303\u0001\u0000"+
		"\u0000\u0000\u0303\u030e\u0001\u0000\u0000\u0000\u0304\u0306\u0003V+\u0000"+
		"\u0305\u0304\u0001\u0000\u0000\u0000\u0306\u0307\u0001\u0000\u0000\u0000"+
		"\u0307\u0305\u0001\u0000\u0000\u0000\u0307\u0308\u0001\u0000\u0000\u0000"+
		"\u0308\u030a\u0001\u0000\u0000\u0000\u0309\u030b\u0003N\'\u0000\u030a"+
		"\u0309\u0001\u0000\u0000\u0000\u030a\u030b\u0001\u0000\u0000\u0000\u030b"+
		"\u030e\u0001\u0000\u0000\u0000\u030c\u030e\u0003N\'\u0000\u030d\u02dc"+
		"\u0001\u0000\u0000\u0000\u030d\u02ec\u0001\u0000\u0000\u0000\u030d\u02f7"+
		"\u0001\u0000\u0000\u0000\u030d\u0305\u0001\u0000\u0000\u0000\u030d\u030c"+
		"\u0001\u0000\u0000\u0000\u030eI\u0001\u0000\u0000\u0000\u030f\u0311\u0003"+
		"R)\u0000\u0310\u030f\u0001\u0000\u0000\u0000\u0311\u0312\u0001\u0000\u0000"+
		"\u0000\u0312\u0310\u0001\u0000\u0000\u0000\u0312\u0313\u0001\u0000\u0000"+
		"\u0000\u0313\u0314\u0001\u0000\u0000\u0000\u0314\u0316\u0005\u0015\u0000"+
		"\u0000\u0315\u0317\u0005\u0010\u0000\u0000\u0316\u0315\u0001\u0000\u0000"+
		"\u0000\u0316\u0317\u0001\u0000\u0000\u0000\u0317K\u0001\u0000\u0000\u0000"+
		"\u0318\u031a\u0003R)\u0000\u0319\u0318\u0001\u0000\u0000\u0000\u031a\u031d"+
		"\u0001\u0000\u0000\u0000\u031b\u0319\u0001\u0000\u0000\u0000\u031b\u031c"+
		"\u0001\u0000\u0000\u0000\u031c\u031f\u0001\u0000\u0000\u0000\u031d\u031b"+
		"\u0001\u0000\u0000\u0000\u031e\u0320\u0003V+\u0000\u031f\u031e\u0001\u0000"+
		"\u0000\u0000\u0320\u0321\u0001\u0000\u0000\u0000\u0321\u031f\u0001\u0000"+
		"\u0000\u0000\u0321\u0322\u0001\u0000\u0000\u0000\u0322\u0323\u0001\u0000"+
		"\u0000\u0000\u0323\u0325\u0005\u0015\u0000\u0000\u0324\u0326\u0005\u0010"+
		"\u0000\u0000\u0325\u0324\u0001\u0000\u0000\u0000\u0325\u0326\u0001\u0000"+
		"\u0000\u0000\u0326M\u0001\u0000\u0000\u0000\u0327\u0328\u0005\u0014\u0000"+
		"\u0000\u0328\u032c\u0003R)\u0000\u0329\u032b\u0003X,\u0000\u032a\u0329"+
		"\u0001\u0000\u0000\u0000\u032b\u032e\u0001\u0000\u0000\u0000\u032c\u032a"+
		"\u0001\u0000\u0000\u0000\u032c\u032d\u0001\u0000\u0000\u0000\u032d\u0330"+
		"\u0001\u0000\u0000\u0000\u032e\u032c\u0001\u0000\u0000\u0000\u032f\u0331"+
		"\u0003P(\u0000\u0330\u032f\u0001\u0000\u0000\u0000\u0330\u0331\u0001\u0000"+
		"\u0000\u0000\u0331\u0349\u0001\u0000\u0000\u0000\u0332\u0333\u0005\u0014"+
		"\u0000\u0000\u0333\u0337\u0003T*\u0000\u0334\u0336\u0003X,\u0000\u0335"+
		"\u0334\u0001\u0000\u0000\u0000\u0336\u0339\u0001\u0000\u0000\u0000\u0337"+
		"\u0335\u0001\u0000\u0000\u0000\u0337\u0338\u0001\u0000\u0000\u0000\u0338"+
		"\u033b\u0001\u0000\u0000\u0000\u0339\u0337\u0001\u0000\u0000\u0000\u033a"+
		"\u033c\u0003P(\u0000\u033b\u033a\u0001\u0000\u0000\u0000\u033b\u033c\u0001"+
		"\u0000\u0000\u0000\u033c\u0349\u0001\u0000\u0000\u0000\u033d\u033e\u0005"+
		"\u0014\u0000\u0000\u033e\u0340\u0005\u0010\u0000\u0000\u033f\u0341\u0003"+
		"X,\u0000\u0340\u033f\u0001\u0000\u0000\u0000\u0341\u0342\u0001\u0000\u0000"+
		"\u0000\u0342\u0340\u0001\u0000\u0000\u0000\u0342\u0343\u0001\u0000\u0000"+
		"\u0000\u0343\u0345\u0001\u0000\u0000\u0000\u0344\u0346\u0003P(\u0000\u0345"+
		"\u0344\u0001\u0000\u0000\u0000\u0345\u0346\u0001\u0000\u0000\u0000\u0346"+
		"\u0349\u0001\u0000\u0000\u0000\u0347\u0349\u0003P(\u0000\u0348\u0327\u0001"+
		"\u0000\u0000\u0000\u0348\u0332\u0001\u0000\u0000\u0000\u0348\u033d\u0001"+
		"\u0000\u0000\u0000\u0348\u0347\u0001\u0000\u0000\u0000\u0349O\u0001\u0000"+
		"\u0000\u0000\u034a\u034b\u0005$\u0000\u0000\u034b\u034c\u0003R)\u0000"+
		"\u034cQ\u0001\u0000\u0000\u0000\u034d\u034f\u0003Z-\u0000\u034e\u0350"+
		"\u0005\u0010\u0000\u0000\u034f\u034e\u0001\u0000\u0000\u0000\u034f\u0350"+
		"\u0001\u0000\u0000\u0000\u0350\u0352\u0001\u0000\u0000\u0000\u0351\u0353"+
		"\u0005\u0004\u0000\u0000\u0352\u0351\u0001\u0000\u0000\u0000\u0352\u0353"+
		"\u0001\u0000\u0000\u0000\u0353S\u0001\u0000\u0000\u0000\u0354\u0356\u0003"+
		"\\.\u0000\u0355\u0357\u0005\u0010\u0000\u0000\u0356\u0355\u0001\u0000"+
		"\u0000\u0000\u0356\u0357\u0001\u0000\u0000\u0000\u0357\u0359\u0001\u0000"+
		"\u0000\u0000\u0358\u035a\u0005\u0004\u0000\u0000\u0359\u0358\u0001\u0000"+
		"\u0000\u0000\u0359\u035a\u0001\u0000\u0000\u0000\u035aU\u0001\u0000\u0000"+
		"\u0000\u035b\u035c\u0003Z-\u0000\u035c\u035e\u0003b1\u0000\u035d\u035f"+
		"\u0005\u0010\u0000\u0000\u035e\u035d\u0001\u0000\u0000\u0000\u035e\u035f"+
		"\u0001\u0000\u0000\u0000\u035f\u0361\u0001\u0000\u0000\u0000\u0360\u0362"+
		"\u0005\u0004\u0000\u0000\u0361\u0360\u0001\u0000\u0000\u0000\u0361\u0362"+
		"\u0001\u0000\u0000\u0000\u0362W\u0001\u0000\u0000\u0000\u0363\u0365\u0003"+
		"Z-\u0000\u0364\u0366\u0003b1\u0000\u0365\u0364\u0001\u0000\u0000\u0000"+
		"\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u0368\u0001\u0000\u0000\u0000"+
		"\u0367\u0369\u0005\u0010\u0000\u0000\u0368\u0367\u0001\u0000\u0000\u0000"+
		"\u0368\u0369\u0001\u0000\u0000\u0000\u0369\u036b\u0001\u0000\u0000\u0000"+
		"\u036a\u036c\u0005\u0004\u0000\u0000\u036b\u036a\u0001\u0000\u0000\u0000"+
		"\u036b\u036c\u0001\u0000\u0000\u0000\u036cY\u0001\u0000\u0000\u0000\u036d"+
		"\u036f\u0003\u0186\u00c3\u0000\u036e\u0370\u0003^/\u0000\u036f\u036e\u0001"+
		"\u0000\u0000\u0000\u036f\u0370\u0001\u0000\u0000\u0000\u0370[\u0001\u0000"+
		"\u0000\u0000\u0371\u0372\u0003\u0186\u00c3\u0000\u0372\u0373\u0003`0\u0000"+
		"\u0373]\u0001\u0000\u0000\u0000\u0374\u0375\u0005\u000f\u0000\u0000\u0375"+
		"\u0376\u0003\u00d2i\u0000\u0376_\u0001\u0000\u0000\u0000\u0377\u0378\u0005"+
		"\u000f\u0000\u0000\u0378\u0379\u0003\u00d8l\u0000\u0379a\u0001\u0000\u0000"+
		"\u0000\u037a\u037b\u0005\u001a\u0000\u0000\u037b\u037c\u0003\u00d2i\u0000"+
		"\u037cc\u0001\u0000\u0000\u0000\u037d\u037e\u0005X\u0000\u0000\u037e\u037f"+
		"\u0003\u00e0p\u0000\u037f\u0380\u0005\u000f\u0000\u0000\u0380\u0385\u0003"+
		":\u001d\u0000\u0381\u0386\u0003f3\u0000\u0382\u0384\u0003h4\u0000\u0383"+
		"\u0382\u0001\u0000\u0000\u0000\u0383\u0384\u0001\u0000\u0000\u0000\u0384"+
		"\u0386\u0001\u0000\u0000\u0000\u0385\u0381\u0001\u0000\u0000\u0000\u0385"+
		"\u0383\u0001\u0000\u0000\u0000\u0386e\u0001\u0000\u0000\u0000\u0387\u0388"+
		"\u0005W\u0000\u0000\u0388\u0389\u0003\u00e0p\u0000\u0389\u038a\u0005\u000f"+
		"\u0000\u0000\u038a\u038f\u0003:\u001d\u0000\u038b\u0390\u0003f3\u0000"+
		"\u038c\u038e\u0003h4\u0000\u038d\u038c\u0001\u0000\u0000\u0000\u038d\u038e"+
		"\u0001\u0000\u0000\u0000\u038e\u0390\u0001\u0000\u0000\u0000\u038f\u038b"+
		"\u0001\u0000\u0000\u0000\u038f\u038d\u0001\u0000\u0000\u0000\u0390g\u0001"+
		"\u0000\u0000\u0000\u0391\u0392\u0005:\u0000\u0000\u0392\u0393\u0005\u000f"+
		"\u0000\u0000\u0393\u0394\u0003:\u001d\u0000\u0394i\u0001\u0000\u0000\u0000"+
		"\u0395\u0396\u0005P\u0000\u0000\u0396\u0397\u0003\u00e0p\u0000\u0397\u0398"+
		"\u0005\u000f\u0000\u0000\u0398\u039a\u0003:\u001d\u0000\u0399\u039b\u0003"+
		"h4\u0000\u039a\u0399\u0001\u0000\u0000\u0000\u039a\u039b\u0001\u0000\u0000"+
		"\u0000\u039bk\u0001\u0000\u0000\u0000\u039c\u039e\u0005V\u0000\u0000\u039d"+
		"\u039c\u0001\u0000\u0000\u0000\u039d\u039e\u0001\u0000\u0000\u0000\u039e"+
		"\u039f\u0001\u0000\u0000\u0000\u039f\u03a0\u0005I\u0000\u0000\u03a0\u03a1"+
		"\u0003\u0168\u00b4\u0000\u03a1\u03a2\u0005@\u0000\u0000\u03a2\u03a3\u0003"+
		"\u00d6k\u0000\u03a3\u03a5\u0005\u000f\u0000\u0000\u03a4\u03a6\u0005\u0004"+
		"\u0000\u0000\u03a5\u03a4\u0001\u0000\u0000\u0000\u03a5\u03a6\u0001\u0000"+
		"\u0000\u0000\u03a6\u03a7\u0001\u0000\u0000\u0000\u03a7\u03a9\u0003:\u001d"+
		"\u0000\u03a8\u03aa\u0003h4\u0000\u03a9\u03a8\u0001\u0000\u0000\u0000\u03a9"+
		"\u03aa\u0001\u0000\u0000\u0000\u03aam\u0001\u0000\u0000\u0000\u03ab\u03ac"+
		"\u0005U\u0000\u0000\u03ac\u03ad\u0005\b\u0000\u0000\u03ad\u03b2\u0003"+
		"p8\u0000\u03ae\u03af\u0005\u0010\u0000\u0000\u03af\u03b1\u0003p8\u0000"+
		"\u03b0\u03ae\u0001\u0000\u0000\u0000\u03b1\u03b4\u0001\u0000\u0000\u0000"+
		"\u03b2\u03b0\u0001\u0000\u0000\u0000\u03b2\u03b3\u0001\u0000\u0000\u0000"+
		"\u03b3\u03b6\u0001\u0000\u0000\u0000\u03b4\u03b2\u0001\u0000\u0000\u0000"+
		"\u03b5\u03b7\u0005\u0010\u0000\u0000\u03b6\u03b5\u0001\u0000\u0000\u0000"+
		"\u03b6\u03b7\u0001\u0000\u0000\u0000\u03b7\u03b8\u0001\u0000\u0000\u0000"+
		"\u03b8\u03b9\u0005\u000b\u0000\u0000\u03b9\u03bb\u0005\u000f\u0000\u0000"+
		"\u03ba\u03bc\u0005\u0004\u0000\u0000\u03bb\u03ba\u0001\u0000\u0000\u0000"+
		"\u03bb\u03bc\u0001\u0000\u0000\u0000\u03bc\u03bd\u0001\u0000\u0000\u0000"+
		"\u03bd\u03be\u0003:\u001d\u0000\u03be\u03e4\u0001\u0000\u0000\u0000\u03bf"+
		"\u03c0\u0005V\u0000\u0000\u03c0\u03c1\u0005U\u0000\u0000\u03c1\u03c2\u0005"+
		"\b\u0000\u0000\u03c2\u03c7\u0003p8\u0000\u03c3\u03c4\u0005\u0010\u0000"+
		"\u0000\u03c4\u03c6\u0003p8\u0000\u03c5\u03c3\u0001\u0000\u0000\u0000\u03c6"+
		"\u03c9\u0001\u0000\u0000\u0000\u03c7\u03c5\u0001\u0000\u0000\u0000\u03c7"+
		"\u03c8\u0001\u0000\u0000\u0000\u03c8\u03cb\u0001\u0000\u0000\u0000\u03c9"+
		"\u03c7\u0001\u0000\u0000\u0000\u03ca\u03cc\u0005\u0010\u0000\u0000\u03cb"+
		"\u03ca\u0001\u0000\u0000\u0000\u03cb\u03cc\u0001\u0000\u0000\u0000\u03cc"+
		"\u03cd\u0001\u0000\u0000\u0000\u03cd\u03ce\u0005\u000b\u0000\u0000\u03ce"+
		"\u03cf\u0005\u000f\u0000\u0000\u03cf\u03d0\u0003:\u001d\u0000\u03d0\u03e4"+
		"\u0001\u0000\u0000\u0000\u03d1\u03d3\u0005V\u0000\u0000\u03d2\u03d1\u0001"+
		"\u0000\u0000\u0000\u03d2\u03d3\u0001\u0000\u0000\u0000\u03d3\u03d4\u0001"+
		"\u0000\u0000\u0000\u03d4\u03d5\u0005U\u0000\u0000\u03d5\u03da\u0003p8"+
		"\u0000\u03d6\u03d7\u0005\u0010\u0000\u0000\u03d7\u03d9\u0003p8\u0000\u03d8"+
		"\u03d6\u0001\u0000\u0000\u0000\u03d9\u03dc\u0001\u0000\u0000\u0000\u03da"+
		"\u03d8\u0001\u0000\u0000\u0000\u03da\u03db\u0001\u0000\u0000\u0000\u03db"+
		"\u03dd\u0001\u0000\u0000\u0000\u03dc\u03da\u0001\u0000\u0000\u0000\u03dd"+
		"\u03df\u0005\u000f\u0000\u0000\u03de\u03e0\u0005\u0004\u0000\u0000\u03df"+
		"\u03de\u0001\u0000\u0000\u0000\u03df\u03e0\u0001\u0000\u0000\u0000\u03e0"+
		"\u03e1\u0001\u0000\u0000\u0000\u03e1\u03e2\u0003:\u001d\u0000\u03e2\u03e4"+
		"\u0001\u0000\u0000\u0000\u03e3\u03ab\u0001\u0000\u0000\u0000\u03e3\u03bf"+
		"\u0001\u0000\u0000\u0000\u03e3\u03d2\u0001\u0000\u0000\u0000\u03e4o\u0001"+
		"\u0000\u0000\u0000\u03e5\u03e8\u0003\u00d2i\u0000\u03e6\u03e7\u0005L\u0000"+
		"\u0000\u03e7\u03e9\u0003\u016e\u00b7\u0000\u03e8\u03e6\u0001\u0000\u0000"+
		"\u0000\u03e8\u03e9\u0001\u0000\u0000\u0000\u03e9q\u0001\u0000\u0000\u0000"+
		"\u03ea\u03eb\u0005K\u0000\u0000\u03eb\u03ec\u0005\u000f\u0000\u0000\u03ec"+
		"\u03ed\u0003:\u001d\u0000\u03ed\u03ee\u0003x<\u0000\u03ee\u040c\u0001"+
		"\u0000\u0000\u0000\u03ef\u03f0\u0005K\u0000\u0000\u03f0\u03f1\u0005\u000f"+
		"\u0000\u0000\u03f1\u03f3\u0003:\u001d\u0000\u03f2\u03f4\u0003t:\u0000"+
		"\u03f3\u03f2\u0001\u0000\u0000\u0000\u03f4\u03f5\u0001\u0000\u0000\u0000"+
		"\u03f5\u03f3\u0001\u0000\u0000\u0000\u03f5\u03f6\u0001\u0000\u0000\u0000"+
		"\u03f6\u03f8\u0001\u0000\u0000\u0000\u03f7\u03f9\u0003h4\u0000\u03f8\u03f7"+
		"\u0001\u0000\u0000\u0000\u03f8\u03f9\u0001\u0000\u0000\u0000\u03f9\u03fb"+
		"\u0001\u0000\u0000\u0000\u03fa\u03fc\u0003x<\u0000\u03fb\u03fa\u0001\u0000"+
		"\u0000\u0000\u03fb\u03fc\u0001\u0000\u0000\u0000\u03fc\u040c\u0001\u0000"+
		"\u0000\u0000\u03fd\u03fe\u0005K\u0000\u0000\u03fe\u03ff\u0005\u000f\u0000"+
		"\u0000\u03ff\u0401\u0003:\u001d\u0000\u0400\u0402\u0003v;\u0000\u0401"+
		"\u0400\u0001\u0000\u0000\u0000\u0402\u0403\u0001\u0000\u0000\u0000\u0403"+
		"\u0401\u0001\u0000\u0000\u0000\u0403\u0404\u0001\u0000\u0000\u0000\u0404"+
		"\u0406\u0001\u0000\u0000\u0000\u0405\u0407\u0003h4\u0000\u0406\u0405\u0001"+
		"\u0000\u0000\u0000\u0406\u0407\u0001\u0000\u0000\u0000\u0407\u0409\u0001"+
		"\u0000\u0000\u0000\u0408\u040a\u0003x<\u0000\u0409\u0408\u0001\u0000\u0000"+
		"\u0000\u0409\u040a\u0001\u0000\u0000\u0000\u040a\u040c\u0001\u0000\u0000"+
		"\u0000\u040b\u03ea\u0001\u0000\u0000\u0000\u040b\u03ef\u0001\u0000\u0000"+
		"\u0000\u040b\u03fd\u0001\u0000\u0000\u0000\u040cs\u0001\u0000\u0000\u0000"+
		"\u040d\u0413\u0005?\u0000\u0000\u040e\u0411\u0003\u00d2i\u0000\u040f\u0410"+
		"\u0005L\u0000\u0000\u0410\u0412\u0003\u0186\u00c3\u0000\u0411\u040f\u0001"+
		"\u0000\u0000\u0000\u0411\u0412\u0001\u0000\u0000\u0000\u0412\u0414\u0001"+
		"\u0000\u0000\u0000\u0413\u040e\u0001\u0000\u0000\u0000\u0413\u0414\u0001"+
		"\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415\u0416\u0005"+
		"\u000f\u0000\u0000\u0416\u0417\u0003:\u001d\u0000\u0417u\u0001\u0000\u0000"+
		"\u0000\u0418\u0419\u0005?\u0000\u0000\u0419\u041a\u0005\u0014\u0000\u0000"+
		"\u041a\u041d\u0003\u00d2i\u0000\u041b\u041c\u0005L\u0000\u0000\u041c\u041e"+
		"\u0003\u0186\u00c3\u0000\u041d\u041b\u0001\u0000\u0000\u0000\u041d\u041e"+
		"\u0001\u0000\u0000\u0000\u041e\u041f\u0001\u0000\u0000\u0000\u041f\u0420"+
		"\u0005\u000f\u0000\u0000\u0420\u0421\u0003:\u001d\u0000\u0421w\u0001\u0000"+
		"\u0000\u0000\u0422\u0423\u0005D\u0000\u0000\u0423\u0424\u0005\u000f\u0000"+
		"\u0000\u0424\u0425\u0003:\u001d\u0000\u0425y\u0001\u0000\u0000\u0000\u0426"+
		"\u0427\u0005\\\u0000\u0000\u0427\u0428\u0003|>\u0000\u0428\u0429\u0005"+
		"\u000f\u0000\u0000\u0429\u042a\u0005b\u0000\u0000\u042a\u042c\u0005\u0002"+
		"\u0000\u0000\u042b\u042d\u0003~?\u0000\u042c\u042b\u0001\u0000\u0000\u0000"+
		"\u042d\u042e\u0001\u0000\u0000\u0000\u042e\u042c\u0001\u0000\u0000\u0000"+
		"\u042e\u042f\u0001\u0000\u0000\u0000\u042f\u0430\u0001\u0000\u0000\u0000"+
		"\u0430\u0431\u0005\u0003\u0000\u0000\u0431{\u0001\u0000\u0000\u0000\u0432"+
		"\u0433\u0003\u00dcn\u0000\u0433\u0435\u0005\u0010\u0000\u0000\u0434\u0436"+
		"\u0003\u00dam\u0000\u0435\u0434\u0001\u0000\u0000\u0000\u0435\u0436\u0001"+
		"\u0000\u0000\u0000\u0436\u0439\u0001\u0000\u0000\u0000\u0437\u0439\u0003"+
		"\u00e0p\u0000\u0438\u0432\u0001\u0000\u0000\u0000\u0438\u0437\u0001\u0000"+
		"\u0000\u0000\u0439}\u0001\u0000\u0000\u0000\u043a\u043b\u0005]\u0000\u0000"+
		"\u043b\u043d\u0003\u0082A\u0000\u043c\u043e\u0003\u0080@\u0000\u043d\u043c"+
		"\u0001\u0000\u0000\u0000\u043d\u043e\u0001\u0000\u0000\u0000\u043e\u043f"+
		"\u0001\u0000\u0000\u0000\u043f\u0440\u0005\u000f\u0000\u0000\u0440\u0441"+
		"\u0003:\u001d\u0000\u0441\u007f\u0001\u0000\u0000\u0000\u0442\u0443\u0005"+
		"X\u0000\u0000\u0443\u0444\u0003\u00e0p\u0000\u0444\u0081\u0001\u0000\u0000"+
		"\u0000\u0445\u0448\u0003\u00aaU\u0000\u0446\u0448\u0003\u0084B\u0000\u0447"+
		"\u0445\u0001\u0000\u0000\u0000\u0447\u0446\u0001\u0000\u0000\u0000\u0448"+
		"\u0083\u0001\u0000\u0000\u0000\u0449\u044c\u0003\u0086C\u0000\u044a\u044c"+
		"\u0003\u0088D\u0000\u044b\u0449\u0001\u0000\u0000\u0000\u044b\u044a\u0001"+
		"\u0000\u0000\u0000\u044c\u0085\u0001\u0000\u0000\u0000\u044d\u044e\u0003"+
		"\u0088D\u0000\u044e\u044f\u0005L\u0000\u0000\u044f\u0450\u0003\u009cN"+
		"\u0000\u0450\u0087\u0001\u0000\u0000\u0000\u0451\u0456\u0003\u008aE\u0000"+
		"\u0452\u0453\u0005\u0016\u0000\u0000\u0453\u0455\u0003\u008aE\u0000\u0454"+
		"\u0452\u0001\u0000\u0000\u0000\u0455\u0458\u0001\u0000\u0000\u0000\u0456"+
		"\u0454\u0001\u0000\u0000\u0000\u0456\u0457\u0001\u0000\u0000\u0000\u0457"+
		"\u0089\u0001\u0000\u0000\u0000\u0458\u0456\u0001\u0000\u0000\u0000\u0459"+
		"\u0462\u0003\u008cF\u0000\u045a\u0462\u0003\u009aM\u0000\u045b\u0462\u0003"+
		"\u009eO\u0000\u045c\u0462\u0003\u00a0P\u0000\u045d\u0462\u0003\u00a6S"+
		"\u0000\u045e\u0462\u0003\u00a8T\u0000\u045f\u0462\u0003\u00b2Y\u0000\u0460"+
		"\u0462\u0003\u00ba]\u0000\u0461\u0459\u0001\u0000\u0000\u0000\u0461\u045a"+
		"\u0001\u0000\u0000\u0000\u0461\u045b\u0001\u0000\u0000\u0000\u0461\u045c"+
		"\u0001\u0000\u0000\u0000\u0461\u045d\u0001\u0000\u0000\u0000\u0461\u045e"+
		"\u0001\u0000\u0000\u0000\u0461\u045f\u0001\u0000\u0000\u0000\u0461\u0460"+
		"\u0001\u0000\u0000\u0000\u0462\u008b\u0001\u0000\u0000\u0000\u0463\u046a"+
		"\u0003\u0092I\u0000\u0464\u046a\u0003\u0090H\u0000\u0465\u046a\u0003\u0140"+
		"\u00a0\u0000\u0466\u046a\u0005=\u0000\u0000\u0467\u046a\u0005B\u0000\u0000"+
		"\u0468\u046a\u00058\u0000\u0000\u0469\u0463\u0001\u0000\u0000\u0000\u0469"+
		"\u0464\u0001\u0000\u0000\u0000\u0469\u0465\u0001\u0000\u0000\u0000\u0469"+
		"\u0466\u0001\u0000\u0000\u0000\u0469\u0467\u0001\u0000\u0000\u0000\u0469"+
		"\u0468\u0001\u0000\u0000\u0000\u046a\u008d\u0001\u0000\u0000\u0000\u046b"+
		"\u0472\u0003\u0092I\u0000\u046c\u0472\u0003\u0090H\u0000\u046d\u0472\u0003"+
		"\u0140\u00a0\u0000\u046e\u0472\u0005=\u0000\u0000\u046f\u0472\u0005B\u0000"+
		"\u0000\u0470\u0472\u00058\u0000\u0000\u0471\u046b\u0001\u0000\u0000\u0000"+
		"\u0471\u046c\u0001\u0000\u0000\u0000\u0471\u046d\u0001\u0000\u0000\u0000"+
		"\u0471\u046e\u0001\u0000\u0000\u0000\u0471\u046f\u0001\u0000\u0000\u0000"+
		"\u0471\u0470\u0001\u0000\u0000\u0000\u0472\u008f\u0001\u0000\u0000\u0000"+
		"\u0473\u0474\u0003\u0094J\u0000\u0474\u0475\u0007\u0002\u0000\u0000\u0475"+
		"\u0476\u0003\u0098L\u0000\u0476\u0091\u0001\u0000\u0000\u0000\u0477\u0479"+
		"\u0005\u0013\u0000\u0000\u0478\u0477\u0001\u0000\u0000\u0000\u0478\u0479"+
		"\u0001\u0000\u0000\u0000\u0479\u047a\u0001\u0000\u0000\u0000\u047a\u047b"+
		"\u0005`\u0000\u0000\u047b\u0093\u0001\u0000\u0000\u0000\u047c\u047e\u0005"+
		"\u0013\u0000\u0000\u047d\u047c\u0001\u0000\u0000\u0000\u047d\u047e\u0001"+
		"\u0000\u0000\u0000\u047e\u047f\u0001\u0000\u0000\u0000\u047f\u0480\u0003"+
		"\u0096K\u0000\u0480\u0095\u0001\u0000\u0000\u0000\u0481\u0482\u0005`\u0000"+
		"\u0000\u0482\u0097\u0001\u0000\u0000\u0000\u0483\u0484\u0005`\u0000\u0000"+
		"\u0484\u0099\u0001\u0000\u0000\u0000\u0485\u0486\u0003\u009cN\u0000\u0486"+
		"\u009b\u0001\u0000\u0000\u0000\u0487\u0488\u0003\u0184\u00c2\u0000\u0488"+
		"\u009d\u0001\u0000\u0000\u0000\u0489\u048a\u0005^\u0000\u0000\u048a\u009f"+
		"\u0001\u0000\u0000\u0000\u048b\u048c\u0003\u00a2Q\u0000\u048c\u00a1\u0001"+
		"\u0000\u0000\u0000\u048d\u0490\u0003\u0186\u00c3\u0000\u048e\u048f\u0005"+
		"\u000e\u0000\u0000\u048f\u0491\u0003\u0186\u00c3\u0000\u0490\u048e\u0001"+
		"\u0000\u0000\u0000\u0491\u0492\u0001\u0000\u0000\u0000\u0492\u0490\u0001"+
		"\u0000\u0000\u0000\u0492\u0493\u0001\u0000\u0000\u0000\u0493\u00a3\u0001"+
		"\u0000\u0000\u0000\u0494\u0499\u0003\u0186\u00c3\u0000\u0495\u0496\u0005"+
		"\u000e\u0000\u0000\u0496\u0498\u0003\u0186\u00c3\u0000\u0497\u0495\u0001"+
		"\u0000\u0000\u0000\u0498\u049b\u0001\u0000\u0000\u0000\u0499\u0497\u0001"+
		"\u0000\u0000\u0000\u0499\u049a\u0001\u0000\u0000\u0000\u049a\u00a5\u0001"+
		"\u0000\u0000\u0000\u049b\u0499\u0001\u0000\u0000\u0000\u049c\u049d\u0005"+
		"\b\u0000\u0000\u049d\u049e\u0003\u0084B\u0000\u049e\u049f\u0005\u000b"+
		"\u0000\u0000\u049f\u00a7\u0001\u0000\u0000\u0000\u04a0\u04a2\u0005\t\u0000"+
		"\u0000\u04a1\u04a3\u0003\u00acV\u0000\u04a2\u04a1\u0001\u0000\u0000\u0000"+
		"\u04a2\u04a3\u0001\u0000\u0000\u0000\u04a3\u04a4\u0001\u0000\u0000\u0000"+
		"\u04a4\u04ab\u0005\f\u0000\u0000\u04a5\u04a7\u0005\b\u0000\u0000\u04a6"+
		"\u04a8\u0003\u00aaU\u0000\u04a7\u04a6\u0001\u0000\u0000\u0000\u04a7\u04a8"+
		"\u0001\u0000\u0000\u0000\u04a8\u04a9\u0001\u0000\u0000\u0000\u04a9\u04ab"+
		"\u0005\u000b\u0000\u0000\u04aa\u04a0\u0001\u0000\u0000\u0000\u04aa\u04a5"+
		"\u0001\u0000\u0000\u0000\u04ab\u00a9\u0001\u0000\u0000\u0000\u04ac\u04ad"+
		"\u0003\u00aeW\u0000\u04ad\u04af\u0005\u0010\u0000\u0000\u04ae\u04b0\u0003"+
		"\u00acV\u0000\u04af\u04ae\u0001\u0000\u0000\u0000\u04af\u04b0\u0001\u0000"+
		"\u0000\u0000\u04b0\u00ab\u0001\u0000\u0000\u0000\u04b1\u04b6\u0003\u00ae"+
		"W\u0000\u04b2\u04b3\u0005\u0010\u0000\u0000\u04b3\u04b5\u0003\u00aeW\u0000"+
		"\u04b4\u04b2\u0001\u0000\u0000\u0000\u04b5\u04b8\u0001\u0000\u0000\u0000"+
		"\u04b6\u04b4\u0001\u0000\u0000\u0000\u04b6\u04b7\u0001\u0000\u0000\u0000"+
		"\u04b7\u04ba\u0001\u0000\u0000\u0000\u04b8\u04b6\u0001\u0000\u0000\u0000"+
		"\u04b9\u04bb\u0005\u0010\u0000\u0000\u04ba\u04b9\u0001\u0000\u0000\u0000"+
		"\u04ba\u04bb\u0001\u0000\u0000\u0000\u04bb\u00ad\u0001\u0000\u0000\u0000"+
		"\u04bc\u04bf\u0003\u00b0X\u0000\u04bd\u04bf\u0003\u0084B\u0000\u04be\u04bc"+
		"\u0001\u0000\u0000\u0000\u04be\u04bd\u0001\u0000\u0000\u0000\u04bf\u00af"+
		"\u0001\u0000\u0000\u0000\u04c0\u04c1\u0005\u0014\u0000\u0000\u04c1\u04c2"+
		"\u0003\u0186\u00c3\u0000\u04c2\u00b1\u0001\u0000\u0000\u0000\u04c3\u04c4"+
		"\u0005\n\u0000\u0000\u04c4\u04d8\u0005\r\u0000\u0000\u04c5\u04c6\u0005"+
		"\n\u0000\u0000\u04c6\u04c8\u0003\u00b8\\\u0000\u04c7\u04c9\u0005\u0010"+
		"\u0000\u0000\u04c8\u04c7\u0001\u0000\u0000\u0000\u04c8\u04c9\u0001\u0000"+
		"\u0000\u0000\u04c9\u04ca\u0001\u0000\u0000\u0000\u04ca\u04cb\u0005\r\u0000"+
		"\u0000\u04cb\u04d8\u0001\u0000\u0000\u0000\u04cc\u04cd\u0005\n\u0000\u0000"+
		"\u04cd\u04d0\u0003\u00b4Z\u0000\u04ce\u04cf\u0005\u0010\u0000\u0000\u04cf"+
		"\u04d1\u0003\u00b8\\\u0000\u04d0\u04ce\u0001\u0000\u0000\u0000\u04d0\u04d1"+
		"\u0001\u0000\u0000\u0000\u04d1\u04d3\u0001\u0000\u0000\u0000\u04d2\u04d4"+
		"\u0005\u0010\u0000\u0000\u04d3\u04d2\u0001\u0000\u0000\u0000\u04d3\u04d4"+
		"\u0001\u0000\u0000\u0000\u04d4\u04d5\u0001\u0000\u0000\u0000\u04d5\u04d6"+
		"\u0005\r\u0000\u0000\u04d6\u04d8\u0001\u0000\u0000\u0000\u04d7\u04c3\u0001"+
		"\u0000\u0000\u0000\u04d7\u04c5\u0001\u0000\u0000\u0000\u04d7\u04cc\u0001"+
		"\u0000\u0000\u0000\u04d8\u00b3\u0001\u0000\u0000\u0000\u04d9\u04de\u0003"+
		"\u00b6[\u0000\u04da\u04db\u0005\u0010\u0000\u0000\u04db\u04dd\u0003\u00b6"+
		"[\u0000\u04dc\u04da\u0001\u0000\u0000\u0000\u04dd\u04e0\u0001\u0000\u0000"+
		"\u0000\u04de\u04dc\u0001\u0000\u0000\u0000\u04de\u04df\u0001\u0000\u0000"+
		"\u0000\u04df\u00b5\u0001\u0000\u0000\u0000\u04e0\u04de\u0001\u0000\u0000"+
		"\u0000\u04e1\u04e4\u0003\u008eG\u0000\u04e2\u04e4\u0003\u00a2Q\u0000\u04e3"+
		"\u04e1\u0001\u0000\u0000\u0000\u04e3\u04e2\u0001\u0000\u0000\u0000\u04e4"+
		"\u04e5\u0001\u0000\u0000\u0000\u04e5\u04e6\u0005\u000f\u0000\u0000\u04e6"+
		"\u04e7\u0003\u0084B\u0000\u04e7\u00b7\u0001\u0000\u0000\u0000\u04e8\u04e9"+
		"\u0005$\u0000\u0000\u04e9\u04ea\u0003\u009cN\u0000\u04ea\u00b9\u0001\u0000"+
		"\u0000\u0000\u04eb\u04ec\u0003\u00a4R\u0000\u04ec\u04f8\u0005\b\u0000"+
		"\u0000\u04ed\u04f0\u0003\u00bc^\u0000\u04ee\u04ef\u0005\u0010\u0000\u0000"+
		"\u04ef\u04f1\u0003\u00be_\u0000\u04f0\u04ee\u0001\u0000\u0000\u0000\u04f0"+
		"\u04f1\u0001\u0000\u0000\u0000\u04f1\u04f4\u0001\u0000\u0000\u0000\u04f2"+
		"\u04f4\u0003\u00be_\u0000\u04f3\u04ed\u0001\u0000\u0000\u0000\u04f3\u04f2"+
		"\u0001\u0000\u0000\u0000\u04f4\u04f6\u0001\u0000\u0000\u0000\u04f5\u04f7"+
		"\u0005\u0010\u0000\u0000\u04f6\u04f5\u0001\u0000\u0000\u0000\u04f6\u04f7"+
		"\u0001\u0000\u0000\u0000\u04f7\u04f9\u0001\u0000\u0000\u0000\u04f8\u04f3"+
		"\u0001\u0000\u0000\u0000\u04f8\u04f9\u0001\u0000\u0000\u0000\u04f9\u04fa"+
		"\u0001\u0000\u0000\u0000\u04fa\u04fb\u0005\u000b\u0000\u0000\u04fb\u00bb"+
		"\u0001\u0000\u0000\u0000\u04fc\u0501\u0003\u0084B\u0000\u04fd\u04fe\u0005"+
		"\u0010\u0000\u0000\u04fe\u0500\u0003\u0084B\u0000\u04ff\u04fd\u0001\u0000"+
		"\u0000\u0000\u0500\u0503\u0001\u0000\u0000\u0000\u0501\u04ff\u0001\u0000"+
		"\u0000\u0000\u0501\u0502\u0001\u0000\u0000\u0000\u0502\u00bd\u0001\u0000"+
		"\u0000\u0000\u0503\u0501\u0001\u0000\u0000\u0000\u0504\u0509\u0003\u00c0"+
		"`\u0000\u0505\u0506\u0005\u0010\u0000\u0000\u0506\u0508\u0003\u00c0`\u0000"+
		"\u0507\u0505\u0001\u0000\u0000\u0000\u0508\u050b\u0001\u0000\u0000\u0000"+
		"\u0509\u0507\u0001\u0000\u0000\u0000\u0509\u050a\u0001\u0000\u0000\u0000"+
		"\u050a\u00bf\u0001\u0000\u0000\u0000\u050b\u0509\u0001\u0000\u0000\u0000"+
		"\u050c\u050d\u0003\u0186\u00c3\u0000\u050d\u050e\u0005\u001a\u0000\u0000"+
		"\u050e\u050f\u0003\u0084B\u0000\u050f\u00c1\u0001\u0000\u0000\u0000\u0510"+
		"\u0511\u0005[\u0000\u0000\u0511\u0513\u0003\u0186\u00c3\u0000\u0512\u0514"+
		"\u0003\u00c4b\u0000\u0513\u0512\u0001\u0000\u0000\u0000\u0513\u0514\u0001"+
		"\u0000\u0000\u0000\u0514\u0515\u0001\u0000\u0000\u0000\u0515\u0516\u0005"+
		"\u001a\u0000\u0000\u0516\u0517\u0003\u00d2i\u0000\u0517\u00c3\u0001\u0000"+
		"\u0000\u0000\u0518\u0519\u0005\t\u0000\u0000\u0519\u051a\u0003\u00c6c"+
		"\u0000\u051a\u051b\u0005\f\u0000\u0000\u051b\u00c5\u0001\u0000\u0000\u0000"+
		"\u051c\u0521\u0003\u00c8d\u0000\u051d\u051e\u0005\u0010\u0000\u0000\u051e"+
		"\u0520\u0003\u00c8d\u0000\u051f\u051d\u0001\u0000\u0000\u0000\u0520\u0523"+
		"\u0001\u0000\u0000\u0000\u0521\u051f\u0001\u0000\u0000\u0000\u0521\u0522"+
		"\u0001\u0000\u0000\u0000\u0522\u0525\u0001\u0000\u0000\u0000\u0523\u0521"+
		"\u0001\u0000\u0000\u0000\u0524\u0526\u0005\u0010\u0000\u0000\u0525\u0524"+
		"\u0001\u0000\u0000\u0000\u0525\u0526\u0001\u0000\u0000\u0000\u0526\u00c7"+
		"\u0001\u0000\u0000\u0000\u0527\u0529\u0003\u0186\u00c3\u0000\u0528\u052a"+
		"\u0003\u00cae\u0000\u0529\u0528\u0001\u0000\u0000\u0000\u0529\u052a\u0001"+
		"\u0000\u0000\u0000\u052a\u052c\u0001\u0000\u0000\u0000\u052b\u052d\u0003"+
		"\u00ccf\u0000\u052c\u052b\u0001\u0000\u0000\u0000\u052c\u052d\u0001\u0000"+
		"\u0000\u0000\u052d\u0539\u0001\u0000\u0000\u0000\u052e\u052f\u0005\u0014"+
		"\u0000\u0000\u052f\u0531\u0003\u0186\u00c3\u0000\u0530\u0532\u0003\u00ce"+
		"g\u0000\u0531\u0530\u0001\u0000\u0000\u0000\u0531\u0532\u0001\u0000\u0000"+
		"\u0000\u0532\u0539\u0001\u0000\u0000\u0000\u0533\u0534\u0005$\u0000\u0000"+
		"\u0534\u0536\u0003\u0186\u00c3\u0000\u0535\u0537\u0003\u00ccf\u0000\u0536"+
		"\u0535\u0001\u0000\u0000\u0000\u0536\u0537\u0001\u0000\u0000\u0000\u0537"+
		"\u0539\u0001\u0000\u0000\u0000\u0538\u0527\u0001\u0000\u0000\u0000\u0538"+
		"\u052e\u0001\u0000\u0000\u0000\u0538\u0533\u0001\u0000\u0000\u0000\u0539"+
		"\u00c9\u0001\u0000\u0000\u0000\u053a\u053b\u0005\u000f\u0000\u0000\u053b"+
		"\u053c\u0003\u00d2i\u0000\u053c\u00cb\u0001\u0000\u0000\u0000\u053d\u053e"+
		"\u0005\u001a\u0000\u0000\u053e\u053f\u0003\u00d2i\u0000\u053f\u00cd\u0001"+
		"\u0000\u0000\u0000\u0540\u0541\u0005\u001a\u0000\u0000\u0541\u0542\u0003"+
		"\u00d8l\u0000\u0542\u00cf\u0001\u0000\u0000\u0000\u0543\u0548\u0003\u00d2"+
		"i\u0000\u0544\u0545\u0005\u0010\u0000\u0000\u0545\u0547\u0003\u00d2i\u0000"+
		"\u0546\u0544\u0001\u0000\u0000\u0000\u0547\u054a\u0001\u0000\u0000\u0000"+
		"\u0548\u0546\u0001\u0000\u0000\u0000\u0548\u0549\u0001\u0000\u0000\u0000"+
		"\u0549\u054c\u0001\u0000\u0000\u0000\u054a\u0548\u0001\u0000\u0000\u0000"+
		"\u054b\u054d\u0005\u0010\u0000\u0000\u054c\u054b\u0001\u0000\u0000\u0000"+
		"\u054c\u054d\u0001\u0000\u0000\u0000\u054d\u00d1\u0001\u0000\u0000\u0000"+
		"\u054e\u0554\u0003\u00e2q\u0000\u054f\u0550\u0005X\u0000\u0000\u0550\u0551"+
		"\u0003\u00e2q\u0000\u0551\u0552\u0005:\u0000\u0000\u0552\u0553\u0003\u00d2"+
		"i\u0000\u0553\u0555\u0001\u0000\u0000\u0000\u0554\u054f\u0001\u0000\u0000"+
		"\u0000\u0554\u0555\u0001\u0000\u0000\u0000\u0555\u0558\u0001\u0000\u0000"+
		"\u0000\u0556\u0558\u0003\u011c\u008e\u0000\u0557\u054e\u0001\u0000\u0000"+
		"\u0000\u0557\u0556\u0001\u0000\u0000\u0000\u0558\u00d3\u0001\u0000\u0000"+
		"\u0000\u0559\u055f\u0005Z\u0000\u0000\u055a\u055b\u0005N\u0000\u0000\u055b"+
		"\u0560\u0003\u00d2i\u0000\u055c\u055e\u0003\u00d6k\u0000\u055d\u055c\u0001"+
		"\u0000\u0000\u0000\u055d\u055e\u0001\u0000\u0000\u0000\u055e\u0560\u0001"+
		"\u0000\u0000\u0000\u055f\u055a\u0001\u0000\u0000\u0000\u055f\u055d\u0001"+
		"\u0000\u0000\u0000\u0560\u00d5\u0001\u0000\u0000\u0000\u0561\u0566\u0003"+
		"\u00d8l\u0000\u0562\u0563\u0005\u0010\u0000\u0000\u0563\u0565\u0003\u00d8"+
		"l\u0000\u0564\u0562\u0001\u0000\u0000\u0000\u0565\u0568\u0001\u0000\u0000"+
		"\u0000\u0566\u0564\u0001\u0000\u0000\u0000\u0566\u0567\u0001\u0000\u0000"+
		"\u0000\u0567\u056a\u0001\u0000\u0000\u0000\u0568\u0566\u0001\u0000\u0000"+
		"\u0000\u0569\u056b\u0005\u0010\u0000\u0000\u056a\u0569\u0001\u0000\u0000"+
		"\u0000\u056a\u056b\u0001\u0000\u0000\u0000\u056b\u00d7\u0001\u0000\u0000"+
		"\u0000\u056c\u056d\u0005\u0014\u0000\u0000\u056d\u0570\u0003\u0100\u0080"+
		"\u0000\u056e\u0570\u0003\u00d2i\u0000\u056f\u056c\u0001\u0000\u0000\u0000"+
		"\u056f\u056e\u0001\u0000\u0000\u0000\u0570\u00d9\u0001\u0000\u0000\u0000"+
		"\u0571\u0576\u0003\u00dcn\u0000\u0572\u0573\u0005\u0010\u0000\u0000\u0573"+
		"\u0575\u0003\u00dcn\u0000\u0574\u0572\u0001\u0000\u0000\u0000\u0575\u0578"+
		"\u0001\u0000\u0000\u0000\u0576\u0574\u0001\u0000\u0000\u0000\u0576\u0577"+
		"\u0001\u0000\u0000\u0000\u0577\u057a\u0001\u0000\u0000\u0000\u0578\u0576"+
		"\u0001\u0000\u0000\u0000\u0579\u057b\u0005\u0010\u0000\u0000\u057a\u0579"+
		"\u0001\u0000\u0000\u0000\u057a\u057b\u0001\u0000\u0000\u0000\u057b\u00db"+
		"\u0001\u0000\u0000\u0000\u057c\u057d\u0005\u0014\u0000\u0000\u057d\u0580"+
		"\u0003\u0100\u0080\u0000\u057e\u0580\u0003\u00e0p\u0000\u057f\u057c\u0001"+
		"\u0000\u0000\u0000\u057f\u057e\u0001\u0000\u0000\u0000\u0580\u00dd\u0001"+
		"\u0000\u0000\u0000\u0581\u0582\u0003\u0186\u00c3\u0000\u0582\u0583\u0005"+
		"6\u0000\u0000\u0583\u0584\u0003\u00d2i\u0000\u0584\u00df\u0001\u0000\u0000"+
		"\u0000\u0585\u0588\u0003\u00deo\u0000\u0586\u0588\u0003\u00d2i\u0000\u0587"+
		"\u0585\u0001\u0000\u0000\u0000\u0587\u0586\u0001\u0000\u0000\u0000\u0588"+
		"\u00e1\u0001\u0000\u0000\u0000\u0589\u058e\u0003\u00e4r\u0000\u058a\u058b"+
		"\u0005Y\u0000\u0000\u058b\u058d\u0003\u00e4r\u0000\u058c\u058a\u0001\u0000"+
		"\u0000\u0000\u058d\u0590\u0001\u0000\u0000\u0000\u058e\u058c\u0001\u0000"+
		"\u0000\u0000\u058e\u058f\u0001\u0000\u0000\u0000\u058f\u00e3\u0001\u0000"+
		"\u0000\u0000\u0590\u058e\u0001\u0000\u0000\u0000\u0591\u0596\u0003\u00e6"+
		"s\u0000\u0592\u0593\u0005G\u0000\u0000\u0593\u0595\u0003\u00e6s\u0000"+
		"\u0594\u0592\u0001\u0000\u0000\u0000\u0595\u0598\u0001\u0000\u0000\u0000"+
		"\u0596\u0594\u0001\u0000\u0000\u0000\u0596\u0597\u0001\u0000\u0000\u0000"+
		"\u0597\u00e5\u0001\u0000\u0000\u0000\u0598\u0596\u0001\u0000\u0000\u0000"+
		"\u0599\u059a\u0005T\u0000\u0000\u059a\u059d\u0003\u00e6s\u0000\u059b\u059d"+
		"\u0003\u00e8t\u0000\u059c\u0599\u0001\u0000\u0000\u0000\u059c\u059b\u0001"+
		"\u0000\u0000\u0000\u059d\u00e7\u0001\u0000\u0000\u0000\u059e\u05a2\u0003"+
		"\u0100\u0080\u0000\u059f\u05a1\u0003\u00eau\u0000\u05a0\u059f\u0001\u0000"+
		"\u0000\u0000\u05a1\u05a4\u0001\u0000\u0000\u0000\u05a2\u05a0\u0001\u0000"+
		"\u0000\u0000\u05a2\u05a3\u0001\u0000\u0000\u0000\u05a3\u00e9\u0001\u0000"+
		"\u0000\u0000\u05a4\u05a2\u0001\u0000\u0000\u0000\u05a5\u05b0\u0003\u00ec"+
		"v\u0000\u05a6\u05b0\u0003\u00eew\u0000\u05a7\u05b0\u0003\u00f0x\u0000"+
		"\u05a8\u05b0\u0003\u00f2y\u0000\u05a9\u05b0\u0003\u00f4z\u0000\u05aa\u05b0"+
		"\u0003\u00f6{\u0000\u05ab\u05b0\u0003\u00f8|\u0000\u05ac\u05b0\u0003\u00fa"+
		"}\u0000\u05ad\u05b0\u0003\u00fc~\u0000\u05ae\u05b0\u0003\u00fe\u007f\u0000"+
		"\u05af\u05a5\u0001\u0000\u0000\u0000\u05af\u05a6\u0001\u0000\u0000\u0000"+
		"\u05af\u05a7\u0001\u0000\u0000\u0000\u05af\u05a8\u0001\u0000\u0000\u0000"+
		"\u05af\u05a9\u0001\u0000\u0000\u0000\u05af\u05aa\u0001\u0000\u0000\u0000"+
		"\u05af\u05ab\u0001\u0000\u0000\u0000\u05af\u05ac\u0001\u0000\u0000\u0000"+
		"\u05af\u05ad\u0001\u0000\u0000\u0000\u05af\u05ae\u0001\u0000\u0000\u0000"+
		"\u05b0\u00eb\u0001\u0000\u0000\u0000\u05b1\u05b2\u0005\u001c\u0000\u0000"+
		"\u05b2\u05b3\u0003\u0100\u0080\u0000\u05b3\u00ed\u0001\u0000\u0000\u0000"+
		"\u05b4\u05b5\u0005\u001d\u0000\u0000\u05b5\u05b6\u0003\u0100\u0080\u0000"+
		"\u05b6\u00ef\u0001\u0000\u0000\u0000\u05b7\u05b8\u0005\u001e\u0000\u0000"+
		"\u05b8\u05b9\u0003\u0100\u0080\u0000\u05b9\u00f1\u0001\u0000\u0000\u0000"+
		"\u05ba\u05bb\u0005\u0018\u0000\u0000\u05bb\u05bc\u0003\u0100\u0080\u0000"+
		"\u05bc\u00f3\u0001\u0000\u0000\u0000\u05bd\u05be\u0005\u001f\u0000\u0000"+
		"\u05be\u05bf\u0003\u0100\u0080\u0000\u05bf\u00f5\u0001\u0000\u0000\u0000"+
		"\u05c0\u05c1\u0005\u0019\u0000\u0000\u05c1\u05c2\u0003\u0100\u0080\u0000"+
		"\u05c2\u00f7\u0001\u0000\u0000\u0000\u05c3\u05c4\u0005T\u0000\u0000\u05c4"+
		"\u05c5\u0005@\u0000\u0000\u05c5\u05c6\u0003\u0100\u0080\u0000\u05c6\u00f9"+
		"\u0001\u0000\u0000\u0000\u05c7\u05c8\u0005@\u0000\u0000\u05c8\u05c9\u0003"+
		"\u0100\u0080\u0000\u05c9\u00fb\u0001\u0000\u0000\u0000\u05ca\u05cb\u0005"+
		"E\u0000\u0000\u05cb\u05cc\u0005T\u0000\u0000\u05cc\u05cd\u0003\u0100\u0080"+
		"\u0000\u05cd\u00fd\u0001\u0000\u0000\u0000\u05ce\u05cf\u0005E\u0000\u0000"+
		"\u05cf\u05d0\u0003\u0100\u0080\u0000\u05d0\u00ff\u0001\u0000\u0000\u0000"+
		"\u05d1\u05d2\u0006\u0080\uffff\uffff\u0000\u05d2\u05d3\u0003\u0102\u0081"+
		"\u0000\u05d3\u05d9\u0001\u0000\u0000\u0000\u05d4\u05d5\n\u0002\u0000\u0000"+
		"\u05d5\u05d6\u0005\u0016\u0000\u0000\u05d6\u05d8\u0003\u0102\u0081\u0000"+
		"\u05d7\u05d4\u0001\u0000\u0000\u0000\u05d8\u05db\u0001\u0000\u0000\u0000"+
		"\u05d9\u05d7\u0001\u0000\u0000\u0000\u05d9\u05da\u0001\u0000\u0000\u0000"+
		"\u05da\u0101\u0001\u0000\u0000\u0000\u05db\u05d9\u0001\u0000\u0000\u0000"+
		"\u05dc\u05dd\u0006\u0081\uffff\uffff\u0000\u05dd\u05de\u0003\u0104\u0082"+
		"\u0000\u05de\u05e4\u0001\u0000\u0000\u0000\u05df\u05e0\n\u0002\u0000\u0000"+
		"\u05e0\u05e1\u0005!\u0000\u0000\u05e1\u05e3\u0003\u0104\u0082\u0000\u05e2"+
		"\u05df\u0001\u0000\u0000\u0000\u05e3\u05e6\u0001\u0000\u0000\u0000\u05e4"+
		"\u05e2\u0001\u0000\u0000\u0000\u05e4\u05e5\u0001\u0000\u0000\u0000\u05e5"+
		"\u0103\u0001\u0000\u0000\u0000\u05e6\u05e4\u0001\u0000\u0000\u0000\u05e7"+
		"\u05e8\u0006\u0082\uffff\uffff\u0000\u05e8\u05e9\u0003\u0106\u0083\u0000"+
		"\u05e9\u05ef\u0001\u0000\u0000\u0000\u05ea\u05eb\n\u0002\u0000\u0000\u05eb"+
		"\u05ec\u0005\u0017\u0000\u0000\u05ec\u05ee\u0003\u0106\u0083\u0000\u05ed"+
		"\u05ea\u0001\u0000\u0000\u0000\u05ee\u05f1\u0001\u0000\u0000\u0000\u05ef"+
		"\u05ed\u0001\u0000\u0000\u0000\u05ef\u05f0\u0001\u0000\u0000\u0000\u05f0"+
		"\u0105\u0001\u0000\u0000\u0000\u05f1\u05ef\u0001\u0000\u0000\u0000\u05f2"+
		"\u05f3\u0006\u0083\uffff\uffff\u0000\u05f3\u05f4\u0003\u0108\u0084\u0000"+
		"\u05f4\u05fa\u0001\u0000\u0000\u0000\u05f5\u05f6\n\u0002\u0000\u0000\u05f6"+
		"\u05f7\u0007\u0003\u0000\u0000\u05f7\u05f9\u0003\u0108\u0084\u0000\u05f8"+
		"\u05f5\u0001\u0000\u0000\u0000\u05f9\u05fc\u0001\u0000\u0000\u0000\u05fa"+
		"\u05f8\u0001\u0000\u0000\u0000\u05fa\u05fb\u0001\u0000\u0000\u0000\u05fb"+
		"\u0107\u0001\u0000\u0000\u0000\u05fc\u05fa\u0001\u0000\u0000\u0000\u05fd"+
		"\u05fe\u0006\u0084\uffff\uffff\u0000\u05fe\u05ff\u0003\u010a\u0085\u0000"+
		"\u05ff\u0605\u0001\u0000\u0000\u0000\u0600\u0601\n\u0002\u0000\u0000\u0601"+
		"\u0602\u0007\u0002\u0000\u0000\u0602\u0604\u0003\u010a\u0085\u0000\u0603"+
		"\u0600\u0001\u0000\u0000\u0000\u0604\u0607\u0001\u0000\u0000\u0000\u0605"+
		"\u0603\u0001\u0000\u0000\u0000\u0605\u0606\u0001\u0000\u0000\u0000\u0606"+
		"\u0109\u0001\u0000\u0000\u0000\u0607\u0605\u0001\u0000\u0000\u0000\u0608"+
		"\u0609\u0006\u0085\uffff\uffff\u0000\u0609\u060a\u0003\u010c\u0086\u0000"+
		"\u060a\u0610\u0001\u0000\u0000\u0000\u060b\u060c\n\u0002\u0000\u0000\u060c"+
		"\u060d\u0007\u0004\u0000\u0000\u060d\u060f\u0003\u010c\u0086\u0000\u060e"+
		"\u060b\u0001\u0000\u0000\u0000\u060f\u0612\u0001\u0000\u0000\u0000\u0610"+
		"\u060e\u0001\u0000\u0000\u0000\u0610\u0611\u0001\u0000\u0000\u0000\u0611"+
		"\u010b\u0001\u0000\u0000\u0000\u0612\u0610\u0001\u0000\u0000\u0000\u0613"+
		"\u0614\u0005\u0012\u0000\u0000\u0614\u061b\u0003\u010c\u0086\u0000\u0615"+
		"\u0616\u0005\u0013\u0000\u0000\u0616\u061b\u0003\u010c\u0086\u0000\u0617"+
		"\u0618\u0005 \u0000\u0000\u0618\u061b\u0003\u010c\u0086\u0000\u0619\u061b"+
		"\u0003\u010e\u0087\u0000\u061a\u0613\u0001\u0000\u0000\u0000\u061a\u0615"+
		"\u0001\u0000\u0000\u0000\u061a\u0617\u0001\u0000\u0000\u0000\u061a\u0619"+
		"\u0001\u0000\u0000\u0000\u061b\u010d\u0001\u0000\u0000\u0000\u061c\u061f"+
		"\u0003\u0110\u0088\u0000\u061d\u061e\u0005$\u0000\u0000\u061e\u0620\u0003"+
		"\u010c\u0086\u0000\u061f\u061d\u0001\u0000\u0000\u0000\u061f\u0620\u0001"+
		"\u0000\u0000\u0000\u0620\u010f\u0001\u0000\u0000\u0000\u0621\u0622\u0005"+
		"9\u0000\u0000\u0622\u0625\u0003\u0112\u0089\u0000\u0623\u0625\u0003\u0112"+
		"\u0089\u0000\u0624\u0621\u0001\u0000\u0000\u0000\u0624\u0623\u0001\u0000"+
		"\u0000\u0000\u0625\u0111\u0001\u0000\u0000\u0000\u0626\u0627\u0006\u0089"+
		"\uffff\uffff\u0000\u0627\u0628\u0003\u0118\u008c\u0000\u0628\u063a\u0001"+
		"\u0000\u0000\u0000\u0629\u0636\n\u0002\u0000\u0000\u062a\u062b\u0005\u000e"+
		"\u0000\u0000\u062b\u0637\u0003\u0186\u00c3\u0000\u062c\u0637\u0003\u0158"+
		"\u00ac\u0000\u062d\u062f\u0005\b\u0000\u0000\u062e\u0630\u0003\u015c\u00ae"+
		"\u0000\u062f\u062e\u0001\u0000\u0000\u0000\u062f\u0630\u0001\u0000\u0000"+
		"\u0000\u0630\u0631\u0001\u0000\u0000\u0000\u0631\u0637\u0005\u000b\u0000"+
		"\u0000\u0632\u0633\u0005\t\u0000\u0000\u0633\u0634\u0003\u0114\u008a\u0000"+
		"\u0634\u0635\u0005\f\u0000\u0000\u0635\u0637\u0001\u0000\u0000\u0000\u0636"+
		"\u062a\u0001\u0000\u0000\u0000\u0636\u062c\u0001\u0000\u0000\u0000\u0636"+
		"\u062d\u0001\u0000\u0000\u0000\u0636\u0632\u0001\u0000\u0000\u0000\u0637"+
		"\u0639\u0001\u0000\u0000\u0000\u0638\u0629\u0001\u0000\u0000\u0000\u0639"+
		"\u063c\u0001\u0000\u0000\u0000\u063a\u0638\u0001\u0000\u0000\u0000\u063a"+
		"\u063b\u0001\u0000\u0000\u0000\u063b\u0113\u0001\u0000\u0000\u0000\u063c"+
		"\u063a\u0001\u0000\u0000\u0000\u063d\u0650\u0003\u0116\u008b\u0000\u063e"+
		"\u0641\u0003\u0116\u008b\u0000\u063f\u0641\u0003\u0162\u00b1\u0000\u0640"+
		"\u063e\u0001\u0000\u0000\u0000\u0640\u063f\u0001\u0000\u0000\u0000\u0641"+
		"\u0649\u0001\u0000\u0000\u0000\u0642\u0645\u0005\u0010\u0000\u0000\u0643"+
		"\u0646\u0003\u0116\u008b\u0000\u0644\u0646\u0003\u0162\u00b1\u0000\u0645"+
		"\u0643\u0001\u0000\u0000\u0000\u0645\u0644\u0001\u0000\u0000\u0000\u0646"+
		"\u0648\u0001\u0000\u0000\u0000\u0647\u0642\u0001\u0000\u0000\u0000\u0648"+
		"\u064b\u0001\u0000\u0000\u0000\u0649\u0647\u0001\u0000\u0000\u0000\u0649"+
		"\u064a\u0001\u0000\u0000\u0000\u064a\u064d\u0001\u0000\u0000\u0000\u064b"+
		"\u0649\u0001\u0000\u0000\u0000\u064c\u064e\u0005\u0010\u0000\u0000\u064d"+
		"\u064c\u0001\u0000\u0000\u0000\u064d\u064e\u0001\u0000\u0000\u0000\u064e"+
		"\u0650\u0001\u0000\u0000\u0000\u064f\u063d\u0001\u0000\u0000\u0000\u064f"+
		"\u0640\u0001\u0000\u0000\u0000\u0650\u0115\u0001\u0000\u0000\u0000\u0651"+
		"\u0653\u0003\u00d2i\u0000\u0652\u0651\u0001\u0000\u0000\u0000\u0652\u0653"+
		"\u0001\u0000\u0000\u0000\u0653\u0654\u0001\u0000\u0000\u0000\u0654\u0656"+
		"\u0005\u000f\u0000\u0000\u0655\u0657\u0003\u00d2i\u0000\u0656\u0655\u0001"+
		"\u0000\u0000\u0000\u0656\u0657\u0001\u0000\u0000\u0000\u0657\u065c\u0001"+
		"\u0000\u0000\u0000\u0658\u065a\u0005\u000f\u0000\u0000\u0659\u065b\u0003"+
		"\u00d2i\u0000\u065a\u0659\u0001\u0000\u0000\u0000\u065a\u065b\u0001\u0000"+
		"\u0000\u0000\u065b\u065d\u0001\u0000\u0000\u0000\u065c\u0658\u0001\u0000"+
		"\u0000\u0000\u065c\u065d\u0001\u0000\u0000\u0000\u065d\u0660\u0001\u0000"+
		"\u0000\u0000\u065e\u0660\u0003\u00e0p\u0000\u065f\u0652\u0001\u0000\u0000"+
		"\u0000\u065f\u065e\u0001\u0000\u0000\u0000\u0660\u0117\u0001\u0000\u0000"+
		"\u0000\u0661\u0678\u0003\u0186\u00c3\u0000\u0662\u0678\u0005B\u0000\u0000"+
		"\u0663\u0678\u00058\u0000\u0000\u0664\u0678\u0005=\u0000\u0000\u0665\u0678"+
		"\u0003\u0140\u00a0\u0000\u0666\u0678\u0005`\u0000\u0000\u0667\u066b\u0003"+
		"\u0144\u00a2\u0000\u0668\u066b\u0003\u011a\u008d\u0000\u0669\u066b\u0003"+
		"\u0158\u00ac\u0000\u066a\u0667\u0001\u0000\u0000\u0000\u066a\u0668\u0001"+
		"\u0000\u0000\u0000\u066a\u0669\u0001\u0000\u0000\u0000\u066b\u0678\u0001"+
		"\u0000\u0000\u0000\u066c\u066f\u0003\u0142\u00a1\u0000\u066d\u066f\u0003"+
		"\u0154\u00aa\u0000\u066e\u066c\u0001\u0000\u0000\u0000\u066e\u066d\u0001"+
		"\u0000\u0000\u0000\u066f\u0678\u0001\u0000\u0000\u0000\u0670\u0675\u0003"+
		"\u0148\u00a4\u0000\u0671\u0675\u0003\u0146\u00a3\u0000\u0672\u0675\u0003"+
		"\u015a\u00ad\u0000\u0673\u0675\u0003\u0156\u00ab\u0000\u0674\u0670\u0001"+
		"\u0000\u0000\u0000\u0674\u0671\u0001\u0000\u0000\u0000\u0674\u0672\u0001"+
		"\u0000\u0000\u0000\u0674\u0673\u0001\u0000\u0000\u0000\u0675\u0678\u0001"+
		"\u0000\u0000\u0000\u0676\u0678\u00055\u0000\u0000\u0677\u0661\u0001\u0000"+
		"\u0000\u0000\u0677\u0662\u0001\u0000\u0000\u0000\u0677\u0663\u0001\u0000"+
		"\u0000\u0000\u0677\u0664\u0001\u0000\u0000\u0000\u0677\u0665\u0001\u0000"+
		"\u0000\u0000\u0677\u0666\u0001\u0000\u0000\u0000\u0677\u066a\u0001\u0000"+
		"\u0000\u0000\u0677\u066e\u0001\u0000\u0000\u0000\u0677\u0674\u0001\u0000"+
		"\u0000\u0000\u0677\u0676\u0001\u0000\u0000\u0000\u0678\u0119\u0001\u0000"+
		"\u0000\u0000\u0679\u067c\u0005\b\u0000\u0000\u067a\u067d\u0003\u00d4j"+
		"\u0000\u067b\u067d\u0003\u00e0p\u0000\u067c\u067a\u0001\u0000\u0000\u0000"+
		"\u067c\u067b\u0001\u0000\u0000\u0000\u067d\u067e\u0001\u0000\u0000\u0000"+
		"\u067e\u067f\u0005\u000b\u0000\u0000\u067f\u011b\u0001\u0000\u0000\u0000"+
		"\u0680\u0682\u0005J\u0000\u0000\u0681\u0683\u0003\u011e\u008f\u0000\u0682"+
		"\u0681\u0001\u0000\u0000\u0000\u0682\u0683\u0001\u0000\u0000\u0000\u0683"+
		"\u0684\u0001\u0000\u0000\u0000\u0684\u0685\u0005\u000f\u0000\u0000\u0685"+
		"\u0686\u0003\u00d2i\u0000\u0686\u011d\u0001\u0000\u0000\u0000\u0687\u0688"+
		"\u0003\u0120\u0090\u0000\u0688\u011f\u0001\u0000\u0000\u0000\u0689\u068d"+
		"\u0003\u0122\u0091\u0000\u068a\u068c\u0003\u012a\u0095\u0000\u068b\u068a"+
		"\u0001\u0000\u0000\u0000\u068c\u068f\u0001\u0000\u0000\u0000\u068d\u068b"+
		"\u0001\u0000\u0000\u0000\u068d\u068e\u0001\u0000\u0000\u0000\u068e\u0693"+
		"\u0001\u0000\u0000\u0000\u068f\u068d\u0001\u0000\u0000\u0000\u0690\u0692"+
		"\u0003\u012c\u0096\u0000\u0691\u0690\u0001\u0000\u0000\u0000\u0692\u0695"+
		"\u0001\u0000\u0000\u0000\u0693\u0691\u0001\u0000\u0000\u0000\u0693\u0694"+
		"\u0001\u0000\u0000\u0000\u0694\u0697\u0001\u0000\u0000\u0000\u0695\u0693"+
		"\u0001\u0000\u0000\u0000\u0696\u0698\u0003\u0126\u0093\u0000\u0697\u0696"+
		"\u0001\u0000\u0000\u0000\u0697\u0698\u0001\u0000\u0000\u0000\u0698\u06bb"+
		"\u0001\u0000\u0000\u0000\u0699\u069d\u0003\u0124\u0092\u0000\u069a\u069c"+
		"\u0003\u012c\u0096\u0000\u069b\u069a\u0001\u0000\u0000\u0000\u069c\u069f"+
		"\u0001\u0000\u0000\u0000\u069d\u069b\u0001\u0000\u0000\u0000\u069d\u069e"+
		"\u0001\u0000\u0000\u0000\u069e\u06a1\u0001\u0000\u0000\u0000\u069f\u069d"+
		"\u0001\u0000\u0000\u0000\u06a0\u06a2\u0003\u0126\u0093\u0000\u06a1\u06a0"+
		"\u0001\u0000\u0000\u0000\u06a1\u06a2\u0001\u0000\u0000\u0000\u06a2\u06bb"+
		"\u0001\u0000\u0000\u0000\u06a3\u06a5\u0003\u012a\u0095\u0000\u06a4\u06a3"+
		"\u0001\u0000\u0000\u0000\u06a5\u06a6\u0001\u0000\u0000\u0000\u06a6\u06a4"+
		"\u0001\u0000\u0000\u0000\u06a6\u06a7\u0001\u0000\u0000\u0000\u06a7\u06ab"+
		"\u0001\u0000\u0000\u0000\u06a8\u06aa\u0003\u012c\u0096\u0000\u06a9\u06a8"+
		"\u0001\u0000\u0000\u0000\u06aa\u06ad\u0001\u0000\u0000\u0000\u06ab\u06a9"+
		"\u0001\u0000\u0000\u0000\u06ab\u06ac\u0001\u0000\u0000\u0000\u06ac\u06af"+
		"\u0001\u0000\u0000\u0000\u06ad\u06ab\u0001\u0000\u0000\u0000\u06ae\u06b0"+
		"\u0003\u0126\u0093\u0000\u06af\u06ae\u0001\u0000\u0000\u0000\u06af\u06b0"+
		"\u0001\u0000\u0000\u0000\u06b0\u06bb\u0001\u0000\u0000\u0000\u06b1\u06b3"+
		"\u0003\u012c\u0096\u0000\u06b2\u06b1\u0001\u0000\u0000\u0000\u06b3\u06b4"+
		"\u0001\u0000\u0000\u0000\u06b4\u06b2\u0001\u0000\u0000\u0000\u06b4\u06b5"+
		"\u0001\u0000\u0000\u0000\u06b5\u06b7\u0001\u0000\u0000\u0000\u06b6\u06b8"+
		"\u0003\u0126\u0093\u0000\u06b7\u06b6\u0001\u0000\u0000\u0000\u06b7\u06b8"+
		"\u0001\u0000\u0000\u0000\u06b8\u06bb\u0001\u0000\u0000\u0000\u06b9\u06bb"+
		"\u0003\u0126\u0093\u0000\u06ba\u0689\u0001\u0000\u0000\u0000\u06ba\u0699"+
		"\u0001\u0000\u0000\u0000\u06ba\u06a4\u0001\u0000\u0000\u0000\u06ba\u06b2"+
		"\u0001\u0000\u0000\u0000\u06ba\u06b9\u0001\u0000\u0000\u0000\u06bb\u0121"+
		"\u0001\u0000\u0000\u0000\u06bc\u06be\u0003\u012a\u0095\u0000\u06bd\u06bc"+
		"\u0001\u0000\u0000\u0000\u06be\u06bf\u0001\u0000\u0000\u0000\u06bf\u06bd"+
		"\u0001\u0000\u0000\u0000\u06bf\u06c0\u0001\u0000\u0000\u0000\u06c0\u06c1"+
		"\u0001\u0000\u0000\u0000\u06c1\u06c3\u0005\u0015\u0000\u0000\u06c2\u06c4"+
		"\u0005\u0010\u0000\u0000\u06c3\u06c2\u0001\u0000\u0000\u0000\u06c3\u06c4"+
		"\u0001\u0000\u0000\u0000\u06c4\u0123\u0001\u0000\u0000\u0000\u06c5\u06c7"+
		"\u0003\u012a\u0095\u0000\u06c6\u06c5\u0001\u0000\u0000\u0000\u06c7\u06ca"+
		"\u0001\u0000\u0000\u0000\u06c8\u06c6\u0001\u0000\u0000\u0000\u06c8\u06c9"+
		"\u0001\u0000\u0000\u0000\u06c9\u06cc\u0001\u0000\u0000\u0000\u06ca\u06c8"+
		"\u0001\u0000\u0000\u0000\u06cb\u06cd\u0003\u012c\u0096\u0000\u06cc\u06cb"+
		"\u0001\u0000\u0000\u0000\u06cd\u06ce\u0001\u0000\u0000\u0000\u06ce\u06cc"+
		"\u0001\u0000\u0000\u0000\u06ce\u06cf\u0001\u0000\u0000\u0000\u06cf\u06d0"+
		"\u0001\u0000\u0000\u0000\u06d0\u06d2\u0005\u0015\u0000\u0000\u06d1\u06d3"+
		"\u0005\u0010\u0000\u0000\u06d2\u06d1\u0001\u0000\u0000\u0000\u06d2\u06d3"+
		"\u0001\u0000\u0000\u0000\u06d3\u0125\u0001\u0000\u0000\u0000\u06d4\u06d5"+
		"\u0005\u0014\u0000\u0000\u06d5\u06d9\u0003\u012a\u0095\u0000\u06d6\u06d8"+
		"\u0003\u012e\u0097\u0000\u06d7\u06d6\u0001\u0000\u0000\u0000\u06d8\u06db"+
		"\u0001\u0000\u0000\u0000\u06d9\u06d7\u0001\u0000\u0000\u0000\u06d9\u06da"+
		"\u0001\u0000\u0000\u0000\u06da\u06dd\u0001\u0000\u0000\u0000\u06db\u06d9"+
		"\u0001\u0000\u0000\u0000\u06dc\u06de\u0003\u0128\u0094\u0000\u06dd\u06dc"+
		"\u0001\u0000\u0000\u0000\u06dd\u06de\u0001\u0000\u0000\u0000\u06de\u06eb"+
		"\u0001\u0000\u0000\u0000\u06df\u06e0\u0005\u0014\u0000\u0000\u06e0\u06e2"+
		"\u0005\u0010\u0000\u0000\u06e1\u06e3\u0003\u012e\u0097\u0000\u06e2\u06e1"+
		"\u0001\u0000\u0000\u0000\u06e3\u06e4\u0001\u0000\u0000\u0000\u06e4\u06e2"+
		"\u0001\u0000\u0000\u0000\u06e4\u06e5\u0001\u0000\u0000\u0000\u06e5\u06e7"+
		"\u0001\u0000\u0000\u0000\u06e6\u06e8\u0003\u0128\u0094\u0000\u06e7\u06e6"+
		"\u0001\u0000\u0000\u0000\u06e7\u06e8\u0001\u0000\u0000\u0000\u06e8\u06eb"+
		"\u0001\u0000\u0000\u0000\u06e9\u06eb\u0003\u0128\u0094\u0000\u06ea\u06d4"+
		"\u0001\u0000\u0000\u0000\u06ea\u06df\u0001\u0000\u0000\u0000\u06ea\u06e9"+
		"\u0001\u0000\u0000\u0000\u06eb\u0127\u0001\u0000\u0000\u0000\u06ec\u06ed"+
		"\u0005$\u0000\u0000\u06ed\u06ee\u0003\u012a\u0095\u0000\u06ee\u0129\u0001"+
		"\u0000\u0000\u0000\u06ef\u06f1\u0003\u0130\u0098\u0000\u06f0\u06f2\u0005"+
		"\u0010\u0000\u0000\u06f1\u06f0\u0001\u0000\u0000\u0000\u06f1\u06f2\u0001"+
		"\u0000\u0000\u0000\u06f2\u012b\u0001\u0000\u0000\u0000\u06f3\u06f4\u0003"+
		"\u0130\u0098\u0000\u06f4\u06f6\u0003b1\u0000\u06f5\u06f7\u0005\u0010\u0000"+
		"\u0000\u06f6\u06f5\u0001\u0000\u0000\u0000\u06f6\u06f7\u0001\u0000\u0000"+
		"\u0000\u06f7\u012d\u0001\u0000\u0000\u0000\u06f8\u06fa\u0003\u0130\u0098"+
		"\u0000\u06f9\u06fb\u0003b1\u0000\u06fa\u06f9\u0001\u0000\u0000\u0000\u06fa"+
		"\u06fb\u0001\u0000\u0000\u0000\u06fb\u06fd\u0001\u0000\u0000\u0000\u06fc"+
		"\u06fe\u0005\u0010\u0000\u0000\u06fd\u06fc\u0001\u0000\u0000\u0000\u06fd"+
		"\u06fe\u0001\u0000\u0000\u0000\u06fe\u012f\u0001\u0000\u0000\u0000\u06ff"+
		"\u0700\u0003\u0186\u00c3\u0000\u0700\u0131\u0001\u0000\u0000\u0000\u0701"+
		"\u0704\u0003\u0134\u009a\u0000\u0702\u0704\u0005\u0006\u0000\u0000\u0703"+
		"\u0701\u0001\u0000\u0000\u0000\u0703\u0702\u0001\u0000\u0000\u0000\u0704"+
		"\u0133\u0001\u0000\u0000\u0000\u0705\u0706\u0005\n\u0000\u0000\u0706\u0708"+
		"\u0003\u0016\u000b\u0000\u0707\u0709\u0005\u001a\u0000\u0000\u0708\u0707"+
		"\u0001\u0000\u0000\u0000\u0708\u0709\u0001\u0000\u0000\u0000\u0709\u070b"+
		"\u0001\u0000\u0000\u0000\u070a\u070c\u0003\u0136\u009b\u0000\u070b\u070a"+
		"\u0001\u0000\u0000\u0000\u070b\u070c\u0001\u0000\u0000\u0000\u070c\u070e"+
		"\u0001\u0000\u0000\u0000\u070d\u070f\u0003\u0138\u009c\u0000\u070e\u070d"+
		"\u0001\u0000\u0000\u0000\u070e\u070f\u0001\u0000\u0000\u0000\u070f\u0710"+
		"\u0001\u0000\u0000\u0000\u0710\u0711\u0005\r\u0000\u0000\u0711\u0135\u0001"+
		"\u0000\u0000\u0000\u0712\u0713\u00057\u0000\u0000\u0713\u0714\u0003\u0186"+
		"\u00c3\u0000\u0714\u0137\u0001\u0000\u0000\u0000\u0715\u0719\u0005\u000f"+
		"\u0000\u0000\u0716\u0718\u0003\u013a\u009d\u0000\u0717\u0716\u0001\u0000"+
		"\u0000\u0000\u0718\u071b\u0001\u0000\u0000\u0000\u0719\u0717\u0001\u0000"+
		"\u0000\u0000\u0719\u071a\u0001\u0000\u0000\u0000\u071a\u0139\u0001\u0000"+
		"\u0000\u0000\u071b\u0719\u0001\u0000\u0000\u0000\u071c\u071f\u0005\u0006"+
		"\u0000\u0000\u071d\u071f\u0003\u0134\u009a\u0000\u071e\u071c\u0001\u0000"+
		"\u0000\u0000\u071e\u071d\u0001\u0000\u0000\u0000\u071f\u013b\u0001\u0000"+
		"\u0000\u0000\u0720\u0724\u0005\u0005\u0000\u0000\u0721\u0723\u0003\u0132"+
		"\u0099\u0000\u0722\u0721\u0001\u0000\u0000\u0000\u0723\u0726\u0001\u0000"+
		"\u0000\u0000\u0724\u0722\u0001\u0000\u0000\u0000\u0724\u0725\u0001\u0000"+
		"\u0000\u0000\u0725\u0727\u0001\u0000\u0000\u0000\u0726\u0724\u0001\u0000"+
		"\u0000\u0000\u0727\u0728\u0005\u0007\u0000\u0000\u0728\u013d\u0001\u0000"+
		"\u0000\u0000\u0729\u072a\u0005a\u0000\u0000\u072a\u013f\u0001\u0000\u0000"+
		"\u0000\u072b\u072e\u0003\u013c\u009e\u0000\u072c\u072e\u0003\u013e\u009f"+
		"\u0000\u072d\u072b\u0001\u0000\u0000\u0000\u072d\u072c\u0001\u0000\u0000"+
		"\u0000\u072e\u072f\u0001\u0000\u0000\u0000\u072f\u072d\u0001\u0000\u0000"+
		"\u0000\u072f\u0730\u0001\u0000\u0000\u0000\u0730\u0141\u0001\u0000\u0000"+
		"\u0000\u0731\u0733\u0005\t\u0000\u0000\u0732\u0734\u0003\u00dam\u0000"+
		"\u0733\u0732\u0001\u0000\u0000\u0000\u0733\u0734\u0001\u0000\u0000\u0000"+
		"\u0734\u0735\u0001\u0000\u0000\u0000\u0735\u0736\u0005\f\u0000\u0000\u0736"+
		"\u0143\u0001\u0000\u0000\u0000\u0737\u073d\u0005\b\u0000\u0000\u0738\u0739"+
		"\u0003\u00dcn\u0000\u0739\u073b\u0005\u0010\u0000\u0000\u073a\u073c\u0003"+
		"\u00dam\u0000\u073b\u073a\u0001\u0000\u0000\u0000\u073b\u073c\u0001\u0000"+
		"\u0000\u0000\u073c\u073e\u0001\u0000\u0000\u0000\u073d\u0738\u0001\u0000"+
		"\u0000\u0000\u073d\u073e\u0001\u0000\u0000\u0000\u073e\u073f\u0001\u0000"+
		"\u0000\u0000\u073f\u0740\u0005\u000b\u0000\u0000\u0740\u0145\u0001\u0000"+
		"\u0000\u0000\u0741\u0742\u0005\n\u0000\u0000\u0742\u0743\u0003\u00dam"+
		"\u0000\u0743\u0744\u0005\r\u0000\u0000\u0744\u0147\u0001\u0000\u0000\u0000"+
		"\u0745\u0747\u0005\n\u0000\u0000\u0746\u0748\u0003\u014a\u00a5\u0000\u0747"+
		"\u0746\u0001\u0000\u0000\u0000\u0747\u0748\u0001\u0000\u0000\u0000\u0748"+
		"\u0749\u0001\u0000\u0000\u0000\u0749\u074a\u0005\r\u0000\u0000\u074a\u0149"+
		"\u0001\u0000\u0000\u0000\u074b\u0750\u0003\u014c\u00a6\u0000\u074c\u074d"+
		"\u0005\u0010\u0000\u0000\u074d\u074f\u0003\u014c\u00a6\u0000\u074e\u074c"+
		"\u0001\u0000\u0000\u0000\u074f\u0752\u0001\u0000\u0000\u0000\u0750\u074e"+
		"\u0001\u0000\u0000\u0000\u0750\u0751\u0001\u0000\u0000\u0000\u0751\u0754"+
		"\u0001\u0000\u0000\u0000\u0752\u0750\u0001\u0000\u0000\u0000\u0753\u0755"+
		"\u0005\u0010\u0000\u0000\u0754\u0753\u0001\u0000\u0000\u0000\u0754\u0755"+
		"\u0001\u0000\u0000\u0000\u0755\u014b\u0001\u0000\u0000\u0000\u0756\u0757"+
		"\u0005$\u0000\u0000\u0757\u075a\u0003\u0100\u0080\u0000\u0758\u075a\u0003"+
		"\u014e\u00a7\u0000\u0759\u0756\u0001\u0000\u0000\u0000\u0759\u0758\u0001"+
		"\u0000\u0000\u0000\u075a\u014d\u0001\u0000\u0000\u0000\u075b\u075c\u0003"+
		"\u00d2i\u0000\u075c\u075d\u0005\u000f\u0000\u0000\u075d\u075e\u0003\u00d2"+
		"i\u0000\u075e\u014f\u0001\u0000\u0000\u0000\u075f\u0761\u0003\u0152\u00a9"+
		"\u0000\u0760\u075f\u0001\u0000\u0000\u0000\u0761\u0762\u0001\u0000\u0000"+
		"\u0000\u0762\u0760\u0001\u0000\u0000\u0000\u0762\u0763\u0001\u0000\u0000"+
		"\u0000\u0763\u0151\u0001\u0000\u0000\u0000\u0764\u0766\u0005V\u0000\u0000"+
		"\u0765\u0764\u0001\u0000\u0000\u0000\u0765\u0766\u0001\u0000\u0000\u0000"+
		"\u0766\u0767\u0001\u0000\u0000\u0000\u0767\u0768\u0005I\u0000\u0000\u0768"+
		"\u0769\u0003\u0168\u00b4\u0000\u0769\u076a\u0005@\u0000\u0000\u076a\u076f"+
		"\u0003\u00e2q\u0000\u076b\u076c\u0005X\u0000\u0000\u076c\u076e\u0003\u00e2"+
		"q\u0000\u076d\u076b\u0001\u0000\u0000\u0000\u076e\u0771\u0001\u0000\u0000"+
		"\u0000\u076f\u076d\u0001\u0000\u0000\u0000\u076f\u0770\u0001\u0000\u0000"+
		"\u0000\u0770\u0153\u0001\u0000\u0000\u0000\u0771\u076f\u0001\u0000\u0000"+
		"\u0000\u0772\u0773\u0005\t\u0000\u0000\u0773\u0774\u0003\u00e0p\u0000"+
		"\u0774\u0775\u0003\u0150\u00a8\u0000\u0775\u0776\u0005\f\u0000\u0000\u0776"+
		"\u0155\u0001\u0000\u0000\u0000\u0777\u0778\u0005\n\u0000\u0000\u0778\u0779"+
		"\u0003\u00e0p\u0000\u0779\u077a\u0003\u0150\u00a8\u0000\u077a\u077b\u0005"+
		"\r\u0000\u0000\u077b\u0157\u0001\u0000\u0000\u0000\u077c\u077f\u0005\b"+
		"\u0000\u0000\u077d\u0780\u0003\u00deo\u0000\u077e\u0780\u0003\u00d2i\u0000"+
		"\u077f\u077d\u0001\u0000\u0000\u0000\u077f\u077e\u0001\u0000\u0000\u0000"+
		"\u0780\u0781\u0001\u0000\u0000\u0000\u0781\u0782\u0003\u0150\u00a8\u0000"+
		"\u0782\u0783\u0005\u000b\u0000\u0000\u0783\u0159\u0001\u0000\u0000\u0000"+
		"\u0784\u0785\u0005\n\u0000\u0000\u0785\u0786\u0003\u014e\u00a7\u0000\u0786"+
		"\u0787\u0003\u0150\u00a8\u0000\u0787\u0788\u0005\r\u0000\u0000\u0788\u015b"+
		"\u0001\u0000\u0000\u0000\u0789\u078b\u0003\u015e\u00af\u0000\u078a\u078c"+
		"\u0005\u0010\u0000\u0000\u078b\u078a\u0001\u0000\u0000\u0000\u078b\u078c"+
		"\u0001\u0000\u0000\u0000\u078c\u015d\u0001\u0000\u0000\u0000\u078d\u0793"+
		"\u0003\u0162\u00b1\u0000\u078e\u0791\u0003\u00deo\u0000\u078f\u0791\u0003"+
		"\u00d2i\u0000\u0790\u078e\u0001\u0000\u0000\u0000\u0790\u078f\u0001\u0000"+
		"\u0000\u0000\u0791\u0793\u0001\u0000\u0000\u0000\u0792\u078d\u0001\u0000"+
		"\u0000\u0000\u0792\u0790\u0001\u0000\u0000\u0000\u0793\u079e\u0001\u0000"+
		"\u0000\u0000\u0794\u079a\u0005\u0010\u0000\u0000\u0795\u079b\u0003\u0162"+
		"\u00b1\u0000\u0796\u0799\u0003\u00deo\u0000\u0797\u0799\u0003\u00d2i\u0000"+
		"\u0798\u0796\u0001\u0000\u0000\u0000\u0798\u0797\u0001\u0000\u0000\u0000"+
		"\u0799\u079b\u0001\u0000\u0000\u0000\u079a\u0795\u0001\u0000\u0000\u0000"+
		"\u079a\u0798\u0001\u0000\u0000\u0000\u079b\u079d\u0001\u0000\u0000\u0000"+
		"\u079c\u0794\u0001\u0000\u0000\u0000\u079d\u07a0\u0001\u0000\u0000\u0000"+
		"\u079e\u079c\u0001\u0000\u0000\u0000\u079e\u079f\u0001\u0000\u0000\u0000"+
		"\u079f\u07a3\u0001\u0000\u0000\u0000\u07a0\u079e\u0001\u0000\u0000\u0000"+
		"\u07a1\u07a2\u0005\u0010\u0000\u0000\u07a2\u07a4\u0003\u0160\u00b0\u0000"+
		"\u07a3\u07a1\u0001\u0000\u0000\u0000\u07a3\u07a4\u0001\u0000\u0000\u0000"+
		"\u07a4\u07a7\u0001\u0000\u0000\u0000\u07a5\u07a7\u0003\u0160\u00b0\u0000"+
		"\u07a6\u0792\u0001\u0000\u0000\u0000\u07a6\u07a5\u0001\u0000\u0000\u0000"+
		"\u07a7\u015f\u0001\u0000\u0000\u0000\u07a8\u07ad\u0003\u0164\u00b2\u0000"+
		"\u07a9\u07aa\u0005\u0010\u0000\u0000\u07aa\u07ac\u0003\u0164\u00b2\u0000"+
		"\u07ab\u07a9\u0001\u0000\u0000\u0000\u07ac\u07af\u0001\u0000\u0000\u0000"+
		"\u07ad\u07ab\u0001\u0000\u0000\u0000\u07ad\u07ae\u0001\u0000\u0000\u0000"+
		"\u07ae\u07b9\u0001\u0000\u0000\u0000\u07af\u07ad\u0001\u0000\u0000\u0000"+
		"\u07b0\u07b1\u0005\u0010\u0000\u0000\u07b1\u07b6\u0003\u0166\u00b3\u0000"+
		"\u07b2\u07b3\u0005\u0010\u0000\u0000\u07b3\u07b5\u0003\u0166\u00b3\u0000"+
		"\u07b4\u07b2\u0001\u0000\u0000\u0000\u07b5\u07b8\u0001\u0000\u0000\u0000"+
		"\u07b6\u07b4\u0001\u0000\u0000\u0000\u07b6\u07b7\u0001\u0000\u0000\u0000"+
		"\u07b7\u07ba\u0001\u0000\u0000\u0000\u07b8\u07b6\u0001\u0000\u0000\u0000"+
		"\u07b9\u07b0\u0001\u0000\u0000\u0000\u07b9\u07ba\u0001\u0000\u0000\u0000"+
		"\u07ba\u07c4\u0001\u0000\u0000\u0000\u07bb\u07c0\u0003\u0166\u00b3\u0000"+
		"\u07bc\u07bd\u0005\u0010\u0000\u0000\u07bd\u07bf\u0003\u0166\u00b3\u0000"+
		"\u07be\u07bc\u0001\u0000\u0000\u0000\u07bf\u07c2\u0001\u0000\u0000\u0000"+
		"\u07c0\u07be\u0001\u0000\u0000\u0000\u07c0\u07c1\u0001\u0000\u0000\u0000"+
		"\u07c1\u07c4\u0001\u0000\u0000\u0000\u07c2\u07c0\u0001\u0000\u0000\u0000"+
		"\u07c3\u07a8\u0001\u0000\u0000\u0000\u07c3\u07bb\u0001\u0000\u0000\u0000"+
		"\u07c4\u0161\u0001\u0000\u0000\u0000\u07c5\u07c6\u0005\u0014\u0000\u0000"+
		"\u07c6\u07c7\u0003\u00d2i\u0000\u07c7\u0163\u0001\u0000\u0000\u0000\u07c8"+
		"\u07c9\u0003\u0186\u00c3\u0000\u07c9\u07ca\u0005\u001a\u0000\u0000\u07ca"+
		"\u07cb\u0003\u00d2i\u0000\u07cb\u07ce\u0001\u0000\u0000\u0000\u07cc\u07ce"+
		"\u0003\u0162\u00b1\u0000\u07cd\u07c8\u0001\u0000\u0000\u0000\u07cd\u07cc"+
		"\u0001\u0000\u0000\u0000\u07ce\u0165\u0001\u0000\u0000\u0000\u07cf\u07d0"+
		"\u0003\u0186\u00c3\u0000\u07d0\u07d1\u0005\u001a\u0000\u0000\u07d1\u07d2"+
		"\u0003\u00d2i\u0000\u07d2\u07d6\u0001\u0000\u0000\u0000\u07d3\u07d4\u0005"+
		"$\u0000\u0000\u07d4\u07d6\u0003\u00d2i\u0000\u07d5\u07cf\u0001\u0000\u0000"+
		"\u0000\u07d5\u07d3\u0001\u0000\u0000\u0000\u07d6\u0167\u0001\u0000\u0000"+
		"\u0000\u07d7\u07dc\u0003\u016e\u00b7\u0000\u07d8\u07d9\u0005\u0010\u0000"+
		"\u0000\u07d9\u07db\u0003\u016e\u00b7\u0000\u07da\u07d8\u0001\u0000\u0000"+
		"\u0000\u07db\u07de\u0001\u0000\u0000\u0000\u07dc\u07da\u0001\u0000\u0000"+
		"\u0000\u07dc\u07dd\u0001\u0000\u0000\u0000\u07dd\u07e0\u0001\u0000\u0000"+
		"\u0000\u07de\u07dc\u0001\u0000\u0000\u0000\u07df\u07e1\u0005\u0010\u0000"+
		"\u0000\u07e0\u07df\u0001\u0000\u0000\u0000\u07e0\u07e1\u0001\u0000\u0000"+
		"\u0000\u07e1\u0169\u0001\u0000\u0000\u0000\u07e2\u07e7\u0003\u016e\u00b7"+
		"\u0000\u07e3\u07e4\u0005\u0010\u0000\u0000\u07e4\u07e6\u0003\u016e\u00b7"+
		"\u0000\u07e5\u07e3\u0001\u0000\u0000\u0000\u07e6\u07e9\u0001\u0000\u0000"+
		"\u0000\u07e7\u07e5\u0001\u0000\u0000\u0000\u07e7\u07e8\u0001\u0000\u0000"+
		"\u0000\u07e8\u07eb\u0001\u0000\u0000\u0000\u07e9\u07e7\u0001\u0000\u0000"+
		"\u0000\u07ea\u07ec\u0005\u0010\u0000\u0000\u07eb\u07ea\u0001\u0000\u0000"+
		"\u0000\u07eb\u07ec\u0001\u0000\u0000\u0000\u07ec\u016b\u0001\u0000\u0000"+
		"\u0000\u07ed\u07f8\u0003\u016e\u00b7\u0000\u07ee\u07f9\u0005\u0010\u0000"+
		"\u0000\u07ef\u07f0\u0005\u0010\u0000\u0000\u07f0\u07f2\u0003\u016e\u00b7"+
		"\u0000\u07f1\u07ef\u0001\u0000\u0000\u0000\u07f2\u07f3\u0001\u0000\u0000"+
		"\u0000\u07f3\u07f1\u0001\u0000\u0000\u0000\u07f3\u07f4\u0001\u0000\u0000"+
		"\u0000\u07f4\u07f6\u0001\u0000\u0000\u0000\u07f5\u07f7\u0005\u0010\u0000"+
		"\u0000\u07f6\u07f5\u0001\u0000\u0000\u0000\u07f6\u07f7\u0001\u0000\u0000"+
		"\u0000\u07f7\u07f9\u0001\u0000\u0000\u0000\u07f8\u07ee\u0001\u0000\u0000"+
		"\u0000\u07f8\u07f1\u0001\u0000\u0000\u0000\u07f9\u016d\u0001\u0000\u0000"+
		"\u0000\u07fa\u07fb\u0005\u0014\u0000\u0000\u07fb\u07fe\u0003\u016e\u00b7"+
		"\u0000\u07fc\u07fe\u0003\u0170\u00b8\u0000\u07fd\u07fa\u0001\u0000\u0000"+
		"\u0000\u07fd\u07fc\u0001\u0000\u0000\u0000\u07fe\u016f\u0001\u0000\u0000"+
		"\u0000\u07ff\u0806\u0003\u0178\u00bc\u0000\u0800\u0801\u0005\u000e\u0000"+
		"\u0000\u0801\u0807\u0003\u0186\u00c3\u0000\u0802\u0803\u0005\t\u0000\u0000"+
		"\u0803\u0804\u0003\u0114\u008a\u0000\u0804\u0805\u0005\f\u0000\u0000\u0805"+
		"\u0807\u0001\u0000\u0000\u0000\u0806\u0800\u0001\u0000\u0000\u0000\u0806"+
		"\u0802\u0001\u0000\u0000\u0000\u0807\u080a\u0001\u0000\u0000\u0000\u0808"+
		"\u080a\u0003\u0172\u00b9\u0000\u0809\u07ff\u0001\u0000\u0000\u0000\u0809"+
		"\u0808\u0001\u0000\u0000\u0000\u080a\u0171\u0001\u0000\u0000\u0000\u080b"+
		"\u081b\u0003\u0186\u00c3\u0000\u080c\u080d\u0005\b\u0000\u0000\u080d\u080e"+
		"\u0003\u0170\u00b8\u0000\u080e\u080f\u0005\u000b\u0000\u0000\u080f\u081b"+
		"\u0001\u0000\u0000\u0000\u0810\u0812\u0005\b\u0000\u0000\u0811\u0813\u0003"+
		"\u016c\u00b6\u0000\u0812\u0811\u0001\u0000\u0000\u0000\u0812\u0813\u0001"+
		"\u0000\u0000\u0000\u0813\u0814\u0001\u0000\u0000\u0000\u0814\u081b\u0005"+
		"\u000b\u0000\u0000\u0815\u0817\u0005\t\u0000\u0000\u0816\u0818\u0003\u016a"+
		"\u00b5\u0000\u0817\u0816\u0001\u0000\u0000\u0000\u0817\u0818\u0001\u0000"+
		"\u0000\u0000\u0818\u0819\u0001\u0000\u0000\u0000\u0819\u081b\u0005\f\u0000"+
		"\u0000\u081a\u080b\u0001\u0000\u0000\u0000\u081a\u080c\u0001\u0000\u0000"+
		"\u0000\u081a\u0810\u0001\u0000\u0000\u0000\u081a\u0815\u0001\u0000\u0000"+
		"\u0000\u081b\u0173\u0001\u0000\u0000\u0000\u081c\u0823\u0003\u0176\u00bb"+
		"\u0000\u081d\u0823\u0003\u0186\u00c3\u0000\u081e\u081f\u0005\b\u0000\u0000"+
		"\u081f\u0820\u0003\u0174\u00ba\u0000\u0820\u0821\u0005\u000b\u0000\u0000"+
		"\u0821\u0823\u0001\u0000\u0000\u0000\u0822\u081c\u0001\u0000\u0000\u0000"+
		"\u0822\u081d\u0001\u0000\u0000\u0000\u0822\u081e\u0001\u0000\u0000\u0000"+
		"\u0823\u0175\u0001\u0000\u0000\u0000\u0824\u082b\u0003\u0178\u00bc\u0000"+
		"\u0825\u0826\u0005\u000e\u0000\u0000\u0826\u082c\u0003\u0186\u00c3\u0000"+
		"\u0827\u0828\u0005\t\u0000\u0000\u0828\u0829\u0003\u0114\u008a\u0000\u0829"+
		"\u082a\u0005\f\u0000\u0000\u082a\u082c\u0001\u0000\u0000\u0000\u082b\u0825"+
		"\u0001\u0000\u0000\u0000\u082b\u0827\u0001\u0000\u0000\u0000\u082c\u0177"+
		"\u0001\u0000\u0000\u0000\u082d\u082e\u0006\u00bc\uffff\uffff\u0000\u082e"+
		"\u082f\u0003\u0118\u008c\u0000\u082f\u0841\u0001\u0000\u0000\u0000\u0830"+
		"\u083d\n\u0002\u0000\u0000\u0831\u0832\u0005\u000e\u0000\u0000\u0832\u083e"+
		"\u0003\u0186\u00c3\u0000\u0833\u0834\u0005\t\u0000\u0000\u0834\u0835\u0003"+
		"\u0114\u008a\u0000\u0835\u0836\u0005\f\u0000\u0000\u0836\u083e\u0001\u0000"+
		"\u0000\u0000\u0837\u083e\u0003\u0158\u00ac\u0000\u0838\u083a\u0005\b\u0000"+
		"\u0000\u0839\u083b\u0003\u015c\u00ae\u0000\u083a\u0839\u0001\u0000\u0000"+
		"\u0000\u083a\u083b\u0001\u0000\u0000\u0000\u083b\u083c\u0001\u0000\u0000"+
		"\u0000\u083c\u083e\u0005\u000b\u0000\u0000\u083d\u0831\u0001\u0000\u0000"+
		"\u0000\u083d\u0833\u0001\u0000\u0000\u0000\u083d\u0837\u0001\u0000\u0000"+
		"\u0000\u083d\u0838\u0001\u0000\u0000\u0000\u083e\u0840\u0001\u0000\u0000"+
		"\u0000\u083f\u0830\u0001\u0000\u0000\u0000\u0840\u0843\u0001\u0000\u0000"+
		"\u0000\u0841\u083f\u0001\u0000\u0000\u0000\u0841\u0842\u0001\u0000\u0000"+
		"\u0000\u0842\u0179\u0001\u0000\u0000\u0000\u0843\u0841\u0001\u0000\u0000"+
		"\u0000\u0844\u0849\u0003\u017c\u00be\u0000\u0845\u0846\u0005\u0010\u0000"+
		"\u0000\u0846\u0848\u0003\u017c\u00be\u0000\u0847\u0845\u0001\u0000\u0000"+
		"\u0000\u0848\u084b\u0001\u0000\u0000\u0000\u0849\u0847\u0001\u0000\u0000"+
		"\u0000\u0849\u084a\u0001\u0000\u0000\u0000\u084a\u084d\u0001\u0000\u0000"+
		"\u0000\u084b\u0849\u0001\u0000\u0000\u0000\u084c\u084e\u0005\u0010\u0000"+
		"\u0000\u084d\u084c\u0001\u0000\u0000\u0000\u084d\u084e\u0001\u0000\u0000"+
		"\u0000\u084e\u017b\u0001\u0000\u0000\u0000\u084f\u0856\u0003\u0178\u00bc"+
		"\u0000\u0850\u0851\u0005\u000e\u0000\u0000\u0851\u0857\u0003\u0186\u00c3"+
		"\u0000\u0852\u0853\u0005\t\u0000\u0000\u0853\u0854\u0003\u0114\u008a\u0000"+
		"\u0854\u0855\u0005\f\u0000\u0000\u0855\u0857\u0001\u0000\u0000\u0000\u0856"+
		"\u0850\u0001\u0000\u0000\u0000\u0856\u0852\u0001\u0000\u0000\u0000\u0857"+
		"\u085a\u0001\u0000\u0000\u0000\u0858\u085a\u0003\u017e\u00bf\u0000\u0859"+
		"\u084f\u0001\u0000\u0000\u0000\u0859\u0858\u0001\u0000\u0000\u0000\u085a"+
		"\u017d\u0001\u0000\u0000\u0000\u085b\u086b\u0003\u0186\u00c3\u0000\u085c"+
		"\u085d\u0005\b\u0000\u0000\u085d\u085e\u0003\u017c\u00be\u0000\u085e\u085f"+
		"\u0005\u000b\u0000\u0000\u085f\u086b\u0001\u0000\u0000\u0000\u0860\u0862"+
		"\u0005\b\u0000\u0000\u0861\u0863\u0003\u017a\u00bd\u0000\u0862\u0861\u0001"+
		"\u0000\u0000\u0000\u0862\u0863\u0001\u0000\u0000\u0000\u0863\u0864\u0001"+
		"\u0000\u0000\u0000\u0864\u086b\u0005\u000b\u0000\u0000\u0865\u0867\u0005"+
		"\t\u0000\u0000\u0866\u0868\u0003\u017a\u00bd\u0000\u0867\u0866\u0001\u0000"+
		"\u0000\u0000\u0867\u0868\u0001\u0000\u0000\u0000\u0868\u0869\u0001\u0000"+
		"\u0000\u0000\u0869\u086b\u0005\f\u0000\u0000\u086a\u085b\u0001\u0000\u0000"+
		"\u0000\u086a\u085c\u0001\u0000\u0000\u0000\u086a\u0860\u0001\u0000\u0000"+
		"\u0000\u086a\u0865\u0001\u0000\u0000\u0000\u086b\u017f\u0001\u0000\u0000"+
		"\u0000\u086c\u0871\u0003\u00d2i\u0000\u086d\u086e\u0005\u0010\u0000\u0000"+
		"\u086e\u0870\u0003\u00d2i\u0000\u086f\u086d\u0001\u0000\u0000\u0000\u0870"+
		"\u0873\u0001\u0000\u0000\u0000\u0871\u086f\u0001\u0000\u0000\u0000\u0871"+
		"\u0872\u0001\u0000\u0000\u0000\u0872\u0880\u0001\u0000\u0000\u0000\u0873"+
		"\u0871\u0001\u0000\u0000\u0000\u0874\u087e\u0005\u0010\u0000\u0000\u0875"+
		"\u0876\u0005\u0014\u0000\u0000\u0876\u087a\u0003\u00d2i\u0000\u0877\u0878"+
		"\u0005\u0010\u0000\u0000\u0878\u0879\u0005$\u0000\u0000\u0879\u087b\u0003"+
		"\u00d2i\u0000\u087a\u0877\u0001\u0000\u0000\u0000\u087a\u087b\u0001\u0000"+
		"\u0000\u0000\u087b\u087f\u0001\u0000\u0000\u0000\u087c\u087d\u0005$\u0000"+
		"\u0000\u087d\u087f\u0003\u00d2i\u0000\u087e\u0875\u0001\u0000\u0000\u0000"+
		"\u087e\u087c\u0001\u0000\u0000\u0000\u087f\u0881\u0001\u0000\u0000\u0000"+
		"\u0880\u0874\u0001\u0000\u0000\u0000\u0880\u0881\u0001\u0000\u0000\u0000"+
		"\u0881\u088c\u0001\u0000\u0000\u0000\u0882\u0883\u0005\u0014\u0000\u0000"+
		"\u0883\u0887\u0003\u00d2i\u0000\u0884\u0885\u0005\u0010\u0000\u0000\u0885"+
		"\u0886\u0005$\u0000\u0000\u0886\u0888\u0003\u00d2i\u0000\u0887\u0884\u0001"+
		"\u0000\u0000\u0000\u0887\u0888\u0001\u0000\u0000\u0000\u0888\u088c\u0001"+
		"\u0000\u0000\u0000\u0889\u088a\u0005$\u0000\u0000\u088a\u088c\u0003\u00d2"+
		"i\u0000\u088b\u086c\u0001\u0000\u0000\u0000\u088b\u0882\u0001\u0000\u0000"+
		"\u0000\u088b\u0889\u0001\u0000\u0000\u0000\u088c\u0181\u0001\u0000\u0000"+
		"\u0000\u088d\u088e\u0005b\u0000\u0000\u088e\u0891\u0005\u0004\u0000\u0000"+
		"\u088f\u0891\u0005\u0004\u0000\u0000\u0890\u088d\u0001\u0000\u0000\u0000"+
		"\u0890\u088f\u0001\u0000\u0000\u0000\u0891\u0183\u0001\u0000\u0000\u0000"+
		"\u0892\u0893\u0007\u0005\u0000\u0000\u0893\u0185\u0001\u0000\u0000\u0000"+
		"\u0894\u0897\u0005^\u0000\u0000\u0895\u0897\u0003\u0184\u00c2\u0000\u0896"+
		"\u0894\u0001\u0000\u0000\u0000\u0896\u0895\u0001\u0000\u0000\u0000\u0897"+
		"\u0187\u0001\u0000\u0000\u0000\u0126\u0189\u0193\u019a\u01a2\u01aa\u01ae"+
		"\u01b6\u01bd\u01c1\u01d3\u01dd\u01e4\u01eb\u01f1\u01f8\u01fc\u01ff\u0205"+
		"\u0207\u020b\u0211\u0217\u0219\u0221\u022a\u0236\u023a\u0243\u024e\u0252"+
		"\u0257\u025d\u0264\u026a\u0271\u0277\u0281\u028a\u0292\u0298\u029d\u02a1"+
		"\u02a4\u02ad\u02b2\u02b6\u02bb\u02bf\u02c7\u02cb\u02d0\u02d4\u02d8\u02e0"+
		"\u02e6\u02ea\u02f0\u02f4\u02f9\u02fe\u0302\u0307\u030a\u030d\u0312\u0316"+
		"\u031b\u0321\u0325\u032c\u0330\u0337\u033b\u0342\u0345\u0348\u034f\u0352"+
		"\u0356\u0359\u035e\u0361\u0365\u0368\u036b\u036f\u0383\u0385\u038d\u038f"+
		"\u039a\u039d\u03a5\u03a9\u03b2\u03b6\u03bb\u03c7\u03cb\u03d2\u03da\u03df"+
		"\u03e3\u03e8\u03f5\u03f8\u03fb\u0403\u0406\u0409\u040b\u0411\u0413\u041d"+
		"\u042e\u0435\u0438\u043d\u0447\u044b\u0456\u0461\u0469\u0471\u0478\u047d"+
		"\u0492\u0499\u04a2\u04a7\u04aa\u04af\u04b6\u04ba\u04be\u04c8\u04d0\u04d3"+
		"\u04d7\u04de\u04e3\u04f0\u04f3\u04f6\u04f8\u0501\u0509\u0513\u0521\u0525"+
		"\u0529\u052c\u0531\u0536\u0538\u0548\u054c\u0554\u0557\u055d\u055f\u0566"+
		"\u056a\u056f\u0576\u057a\u057f\u0587\u058e\u0596\u059c\u05a2\u05af\u05d9"+
		"\u05e4\u05ef\u05fa\u0605\u0610\u061a\u061f\u0624\u062f\u0636\u063a\u0640"+
		"\u0645\u0649\u064d\u064f\u0652\u0656\u065a\u065c\u065f\u066a\u066e\u0674"+
		"\u0677\u067c\u0682\u068d\u0693\u0697\u069d\u06a1\u06a6\u06ab\u06af\u06b4"+
		"\u06b7\u06ba\u06bf\u06c3\u06c8\u06ce\u06d2\u06d9\u06dd\u06e4\u06e7\u06ea"+
		"\u06f1\u06f6\u06fa\u06fd\u0703\u0708\u070b\u070e\u0719\u071e\u0724\u072d"+
		"\u072f\u0733\u073b\u073d\u0747\u0750\u0754\u0759\u0762\u0765\u076f\u077f"+
		"\u078b\u0790\u0792\u0798\u079a\u079e\u07a3\u07a6\u07ad\u07b6\u07b9\u07c0"+
		"\u07c3\u07cd\u07d5\u07dc\u07e0\u07e7\u07eb\u07f3\u07f6\u07f8\u07fd\u0806"+
		"\u0809\u0812\u0817\u081a\u0822\u082b\u083a\u083d\u0841\u0849\u084d\u0856"+
		"\u0859\u0862\u0867\u086a\u0871\u087a\u087e\u0880\u0887\u088b\u0890\u0896";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}