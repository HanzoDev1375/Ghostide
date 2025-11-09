// Generated from /storage/emulated/0/apk/glsl/GLSLParser.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.glsllang;

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
public class GLSLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ATOMIC_UINT=1, ATTRIBUTE=2, BOOL=3, BREAK=4, BUFFER=5, BVEC2=6, BVEC3=7, 
		BVEC4=8, CASE=9, CENTROID=10, COHERENT=11, CONST=12, CONTINUE=13, DEFAULT=14, 
		DISCARD=15, DMAT2=16, DMAT2X2=17, DMAT2X3=18, DMAT2X4=19, DMAT3=20, DMAT3X2=21, 
		DMAT3X3=22, DMAT3X4=23, DMAT4=24, DMAT4X2=25, DMAT4X3=26, DMAT4X4=27, 
		DO=28, DOUBLE=29, DVEC2=30, DVEC3=31, DVEC4=32, ELSE=33, FALSE=34, FLAT=35, 
		FLOAT=36, FOR=37, HIGHP=38, IF=39, IIMAGE1D=40, IIMAGE1DARRAY=41, IIMAGE2D=42, 
		IIMAGE2DARRAY=43, IIMAGE2DMS=44, IIMAGE2DMSARRAY=45, IIMAGE2DRECT=46, 
		IIMAGE3D=47, IIMAGEBUFFER=48, IIMAGECUBE=49, IIMAGECUBEARRAY=50, IMAGE1D=51, 
		IMAGE1DARRAY=52, IMAGE2D=53, IMAGE2DARRAY=54, IMAGE2DMS=55, IMAGE2DMSARRAY=56, 
		IMAGE2DRECT=57, IMAGE3D=58, IMAGEBUFFER=59, IMAGECUBE=60, IMAGECUBEARRAY=61, 
		IN=62, INOUT=63, INT=64, INVARIANT=65, ISAMPLER1D=66, ISAMPLER1DARRAY=67, 
		ISAMPLER2D=68, ISAMPLER2DARRAY=69, ISAMPLER2DMS=70, ISAMPLER2DMSARRAY=71, 
		ISAMPLER2DRECT=72, ISAMPLER3D=73, ISAMPLERBUFFER=74, ISAMPLERCUBE=75, 
		ISAMPLERCUBEARRAY=76, ISUBPASSINPUT=77, ISUBPASSINPUTMS=78, ITEXTURE1D=79, 
		ITEXTURE1DARRAY=80, ITEXTURE2D=81, ITEXTURE2DARRAY=82, ITEXTURE2DMS=83, 
		ITEXTURE2DMSARRAY=84, ITEXTURE2DRECT=85, ITEXTURE3D=86, ITEXTUREBUFFER=87, 
		ITEXTURECUBE=88, ITEXTURECUBEARRAY=89, IVEC2=90, IVEC3=91, IVEC4=92, LAYOUT=93, 
		LOWP=94, MAT2=95, MAT2X2=96, MAT2X3=97, MAT2X4=98, MAT3=99, MAT3X2=100, 
		MAT3X3=101, MAT3X4=102, MAT4=103, MAT4X2=104, MAT4X3=105, MAT4X4=106, 
		MEDIUMP=107, NOPERSPECTIVE=108, OUT=109, PATCH=110, PRECISE=111, PRECISION=112, 
		READONLY=113, RESTRICT=114, RETURN=115, SAMPLE=116, SAMPLER=117, SAMPLER1D=118, 
		SAMPLER1DARRAY=119, SAMPLER1DARRAYSHADOW=120, SAMPLER1DSHADOW=121, SAMPLER2D=122, 
		SAMPLER2DARRAY=123, SAMPLER2DARRAYSHADOW=124, SAMPLER2DMS=125, SAMPLER2DMSARRAY=126, 
		SAMPLER2DRECT=127, SAMPLER2DRECTSHADOW=128, SAMPLER2DSHADOW=129, SAMPLER3D=130, 
		SAMPLERBUFFER=131, SAMPLERCUBE=132, SAMPLERCUBEARRAY=133, SAMPLERCUBEARRAYSHADOW=134, 
		SAMPLERCUBESHADOW=135, SAMPLERSHADOW=136, SHARED=137, SMOOTH=138, STRUCT=139, 
		SUBPASSINPUT=140, SUBPASSINPUTMS=141, SUBROUTINE=142, SWITCH=143, TEXTURE1D=144, 
		TEXTURE1DARRAY=145, TEXTURE2D=146, TEXTURE2DARRAY=147, TEXTURE2DMS=148, 
		TEXTURE2DMSARRAY=149, TEXTURE2DRECT=150, TEXTURE3D=151, TEXTUREBUFFER=152, 
		TEXTURECUBE=153, TEXTURECUBEARRAY=154, TRUE=155, UIMAGE1D=156, UIMAGE1DARRAY=157, 
		UIMAGE2D=158, UIMAGE2DARRAY=159, UIMAGE2DMS=160, UIMAGE2DMSARRAY=161, 
		UIMAGE2DRECT=162, UIMAGE3D=163, UIMAGEBUFFER=164, UIMAGECUBE=165, UIMAGECUBEARRAY=166, 
		UINT=167, UNIFORM=168, USAMPLER1D=169, USAMPLER1DARRAY=170, USAMPLER2D=171, 
		USAMPLER2DARRAY=172, USAMPLER2DMS=173, USAMPLER2DMSARRAY=174, USAMPLER2DRECT=175, 
		USAMPLER3D=176, USAMPLERBUFFER=177, USAMPLERCUBE=178, USAMPLERCUBEARRAY=179, 
		USUBPASSINPUT=180, USUBPASSINPUTMS=181, UTEXTURE1D=182, UTEXTURE1DARRAY=183, 
		UTEXTURE2D=184, UTEXTURE2DARRAY=185, UTEXTURE2DMS=186, UTEXTURE2DMSARRAY=187, 
		UTEXTURE2DRECT=188, UTEXTURE3D=189, UTEXTUREBUFFER=190, UTEXTURECUBE=191, 
		UTEXTURECUBEARRAY=192, UVEC2=193, UVEC3=194, UVEC4=195, VARYING=196, VEC2=197, 
		VEC3=198, VEC4=199, VOID=200, VOLATILE=201, WHILE=202, WRITEONLY=203, 
		ADD_ASSIGN=204, AMPERSAND=205, AND_ASSIGN=206, AND_OP=207, BANG=208, CARET=209, 
		COLON=210, COMMA=211, DASH=212, DEC_OP=213, DIV_ASSIGN=214, DOT=215, EQ_OP=216, 
		EQUAL=217, GE_OP=218, INC_OP=219, LE_OP=220, LEFT_ANGLE=221, LEFT_ASSIGN=222, 
		LEFT_BRACE=223, LEFT_BRACKET=224, LEFT_OP=225, LEFT_PAREN=226, MOD_ASSIGN=227, 
		MUL_ASSIGN=228, NE_OP=229, NUMBER_SIGN=230, OR_ASSIGN=231, OR_OP=232, 
		PERCENT=233, PLUS=234, QUESTION=235, RIGHT_ANGLE=236, RIGHT_ASSIGN=237, 
		RIGHT_BRACE=238, RIGHT_BRACKET=239, RIGHT_OP=240, RIGHT_PAREN=241, SEMICOLON=242, 
		SLASH=243, STAR=244, SUB_ASSIGN=245, TILDE=246, VERTICAL_BAR=247, XOR_ASSIGN=248, 
		XOR_OP=249, DOUBLECONSTANT=250, FLOATCONSTANT=251, INTCONSTANT=252, UINTCONSTANT=253, 
		BLOCK_COMMENT=254, LINE_COMMENT=255, LINE_CONTINUATION=256, IDENTIFIER=257, 
		WHITE_SPACE=258, DEFINE_DIRECTIVE=259, ELIF_DIRECTIVE=260, ELSE_DIRECTIVE=261, 
		ENDIF_DIRECTIVE=262, ERROR_DIRECTIVE=263, EXTENSION_DIRECTIVE=264, IF_DIRECTIVE=265, 
		IFDEF_DIRECTIVE=266, IFNDEF_DIRECTIVE=267, LINE_DIRECTIVE=268, PRAGMA_DIRECTIVE=269, 
		UNDEF_DIRECTIVE=270, VERSION_DIRECTIVE=271, SPACE_TAB_0=272, NEWLINE_0=273, 
		MACRO_NAME=274, NEWLINE_1=275, SPACE_TAB_1=276, CONSTANT_EXPRESSION=277, 
		NEWLINE_2=278, ERROR_MESSAGE=279, NEWLINE_3=280, BEHAVIOR=281, EXTENSION_NAME=282, 
		NEWLINE_4=283, SPACE_TAB_2=284, NEWLINE_5=285, MACRO_IDENTIFIER=286, NEWLINE_6=287, 
		SPACE_TAB_3=288, LINE_EXPRESSION=289, NEWLINE_7=290, MACRO_ESC_NEWLINE=291, 
		MACRO_TEXT=292, NEWLINE_8=293, DEBUG=294, NEWLINE_9=295, OFF=296, ON=297, 
		OPTIMIZE=298, SPACE_TAB_5=299, STDGL=300, PROGRAM_TEXT=301, NEWLINE_10=302, 
		SPACE_TAB_6=303, NEWLINE_11=304, NUMBER=305, PROFILE=306, SPACE_TAB_7=307;
	public static final int
		RULE_translation_unit = 0, RULE_variable_identifier = 1, RULE_primary_expression = 2, 
		RULE_postfix_expression = 3, RULE_field_selection = 4, RULE_integer_expression = 5, 
		RULE_function_call = 6, RULE_function_identifier = 7, RULE_function_call_parameters = 8, 
		RULE_unary_expression = 9, RULE_unary_operator = 10, RULE_assignment_expression = 11, 
		RULE_assignment_operator = 12, RULE_binary_expression = 13, RULE_expression = 14, 
		RULE_constant_expression = 15, RULE_declaration = 16, RULE_identifier_list = 17, 
		RULE_function_prototype = 18, RULE_function_parameters = 19, RULE_parameter_declarator = 20, 
		RULE_parameter_declaration = 21, RULE_parameter_type_specifier = 22, RULE_init_declarator_list = 23, 
		RULE_single_declaration = 24, RULE_typeless_declaration = 25, RULE_fully_specified_type = 26, 
		RULE_invariant_qualifier = 27, RULE_interpolation_qualifier = 28, RULE_layout_qualifier = 29, 
		RULE_layout_qualifier_id_list = 30, RULE_layout_qualifier_id = 31, RULE_precise_qualifier = 32, 
		RULE_type_qualifier = 33, RULE_single_type_qualifier = 34, RULE_storage_qualifier = 35, 
		RULE_type_name_list = 36, RULE_type_name = 37, RULE_type_specifier = 38, 
		RULE_array_specifier = 39, RULE_dimension = 40, RULE_type_specifier_nonarray = 41, 
		RULE_precision_qualifier = 42, RULE_struct_specifier = 43, RULE_struct_declaration_list = 44, 
		RULE_struct_declaration = 45, RULE_struct_declarator_list = 46, RULE_struct_declarator = 47, 
		RULE_initializer = 48, RULE_initializer_list = 49, RULE_declaration_statement = 50, 
		RULE_statement = 51, RULE_simple_statement = 52, RULE_compound_statement = 53, 
		RULE_statement_no_new_scope = 54, RULE_compound_statement_no_new_scope = 55, 
		RULE_statement_list = 56, RULE_expression_statement = 57, RULE_selection_statement = 58, 
		RULE_selection_rest_statement = 59, RULE_condition = 60, RULE_switch_statement = 61, 
		RULE_case_label = 62, RULE_iteration_statement = 63, RULE_for_init_statement = 64, 
		RULE_for_rest_statement = 65, RULE_jump_statement = 66, RULE_external_declaration = 67, 
		RULE_function_definition = 68;
	private static String[] makeRuleNames() {
		return new String[] {
			"translation_unit", "variable_identifier", "primary_expression", "postfix_expression", 
			"field_selection", "integer_expression", "function_call", "function_identifier", 
			"function_call_parameters", "unary_expression", "unary_operator", "assignment_expression", 
			"assignment_operator", "binary_expression", "expression", "constant_expression", 
			"declaration", "identifier_list", "function_prototype", "function_parameters", 
			"parameter_declarator", "parameter_declaration", "parameter_type_specifier", 
			"init_declarator_list", "single_declaration", "typeless_declaration", 
			"fully_specified_type", "invariant_qualifier", "interpolation_qualifier", 
			"layout_qualifier", "layout_qualifier_id_list", "layout_qualifier_id", 
			"precise_qualifier", "type_qualifier", "single_type_qualifier", "storage_qualifier", 
			"type_name_list", "type_name", "type_specifier", "array_specifier", "dimension", 
			"type_specifier_nonarray", "precision_qualifier", "struct_specifier", 
			"struct_declaration_list", "struct_declaration", "struct_declarator_list", 
			"struct_declarator", "initializer", "initializer_list", "declaration_statement", 
			"statement", "simple_statement", "compound_statement", "statement_no_new_scope", 
			"compound_statement_no_new_scope", "statement_list", "expression_statement", 
			"selection_statement", "selection_rest_statement", "condition", "switch_statement", 
			"case_label", "iteration_statement", "for_init_statement", "for_rest_statement", 
			"jump_statement", "external_declaration", "function_definition"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'atomic_uint'", "'attribute'", "'bool'", "'break'", "'buffer'", 
			"'bvec2'", "'bvec3'", "'bvec4'", "'case'", "'centroid'", "'coherent'", 
			"'const'", "'continue'", "'default'", "'discard'", "'dmat2'", "'dmat2x2'", 
			"'dmat2x3'", "'dmat2x4'", "'dmat3'", "'dmat3x2'", "'dmat3x3'", "'dmat3x4'", 
			"'dmat4'", "'dmat4x2'", "'dmat4x3'", "'dmat4x4'", "'do'", "'double'", 
			"'dvec2'", "'dvec3'", "'dvec4'", "'else'", "'false'", "'flat'", "'float'", 
			"'for'", "'highp'", "'if'", "'iimage1D'", "'iimage1DArray'", "'iimage2D'", 
			"'iimage2DArray'", "'iimage2DMS'", "'iimage2DMSArray'", "'iimage2DRect'", 
			"'iimage3D'", "'iimageBuffer'", "'iimageCube'", "'iimageCubeArray'", 
			"'image1D'", "'image1DArray'", "'image2D'", "'image2DArray'", "'image2DMS'", 
			"'image2DMSArray'", "'image2DRect'", "'image3D'", "'imageBuffer'", "'imageCube'", 
			"'imageCubeArray'", "'in'", "'inout'", "'int'", "'invariant'", "'isampler1D'", 
			"'isampler1DArray'", "'isampler2D'", "'isampler2DArray'", "'isampler2DMS'", 
			"'isampler2DMSArray'", "'isampler2DRect'", "'isampler3D'", "'isamplerBuffer'", 
			"'isamplerCube'", "'isamplerCubeArray'", "'isubpassInput'", "'isubpassInputMS'", 
			"'itexture1D'", "'itexture1DArray'", "'itexture2D'", "'itexture2DArray'", 
			"'itexture2DMS'", "'itexture2DMSArray'", "'itexture2DRect'", "'itexture3D'", 
			"'itextureBuffer'", "'itextureCube'", "'itextureCubeArray'", "'ivec2'", 
			"'ivec3'", "'ivec4'", "'layout'", "'lowp'", "'mat2'", "'mat2x2'", "'mat2x3'", 
			"'mat2x4'", "'mat3'", "'mat3x2'", "'mat3x3'", "'mat3x4'", "'mat4'", "'mat4x2'", 
			"'mat4x3'", "'mat4x4'", "'mediump'", "'noperspective'", "'out'", "'patch'", 
			"'precise'", "'precision'", "'readonly'", "'restrict'", "'return'", "'sample'", 
			"'sampler'", "'sampler1D'", "'sampler1DArray'", "'sampler1DArrayShadow'", 
			"'sampler1DShadow'", "'sampler2D'", "'sampler2DArray'", "'sampler2DArrayShadow'", 
			"'sampler2DMS'", "'sampler2DMSArray'", "'sampler2DRect'", "'sampler2DRectShadow'", 
			"'sampler2DShadow'", "'sampler3D'", "'samplerBuffer'", "'samplerCube'", 
			"'samplerCubeArray'", "'samplerCubeArrayShadow'", "'samplerCubeShadow'", 
			"'samplerShadow'", "'shared'", "'smooth'", "'struct'", "'subpassInput'", 
			"'subpassInputMS'", "'subroutine'", "'switch'", "'texture1D'", "'texture1DArray'", 
			"'texture2D'", "'texture2DArray'", "'texture2DMS'", "'texture2DMSArray'", 
			"'texture2DRect'", "'texture3D'", "'textureBuffer'", "'textureCube'", 
			"'textureCubeArray'", "'true'", "'uimage1D'", "'uimage1DArray'", "'uimage2D'", 
			"'uimage2DArray'", "'uimage2DMS'", "'uimage2DMSArray'", "'uimage2DRect'", 
			"'uimage3D'", "'uimageBuffer'", "'uimageCube'", "'uimageCubeArray'", 
			"'uint'", "'uniform'", "'usampler1D'", "'usampler1DArray'", "'usampler2D'", 
			"'usampler2DArray'", "'usampler2DMS'", "'usampler2DMSArray'", "'usampler2DRect'", 
			"'usampler3D'", "'usamplerBuffer'", "'usamplerCube'", "'usamplerCubeArray'", 
			"'usubpassInput'", "'usubpassInputMS'", "'utexture1D'", "'utexture1DArray'", 
			"'utexture2D'", "'utexture2DArray'", "'utexture2DMS'", "'utexture2DMSArray'", 
			"'utexture2DRect'", "'utexture3D'", "'utextureBuffer'", "'utextureCube'", 
			"'utextureCubeArray'", "'uvec2'", "'uvec3'", "'uvec4'", "'varying'", 
			"'vec2'", "'vec3'", "'vec4'", "'void'", "'volatile'", "'while'", "'writeonly'", 
			"'+='", "'&'", "'&='", "'&&'", "'!'", "'^'", "':'", "','", "'-'", "'--'", 
			"'/='", "'.'", "'=='", "'='", "'>='", "'++'", "'<='", "'<'", "'<<='", 
			"'{'", "'['", "'<<'", "'('", "'%='", "'*='", "'!='", null, "'|='", "'||'", 
			"'%'", "'+'", "'?'", "'>'", "'>>='", "'}'", "']'", "'>>'", "')'", "';'", 
			"'/'", "'*'", "'-='", "'~'", "'|'", "'^='", "'^^'", null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, "'debug'", null, "'off'", "'on'", "'optimize'", 
			null, "'STDGL'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ATOMIC_UINT", "ATTRIBUTE", "BOOL", "BREAK", "BUFFER", "BVEC2", 
			"BVEC3", "BVEC4", "CASE", "CENTROID", "COHERENT", "CONST", "CONTINUE", 
			"DEFAULT", "DISCARD", "DMAT2", "DMAT2X2", "DMAT2X3", "DMAT2X4", "DMAT3", 
			"DMAT3X2", "DMAT3X3", "DMAT3X4", "DMAT4", "DMAT4X2", "DMAT4X3", "DMAT4X4", 
			"DO", "DOUBLE", "DVEC2", "DVEC3", "DVEC4", "ELSE", "FALSE", "FLAT", "FLOAT", 
			"FOR", "HIGHP", "IF", "IIMAGE1D", "IIMAGE1DARRAY", "IIMAGE2D", "IIMAGE2DARRAY", 
			"IIMAGE2DMS", "IIMAGE2DMSARRAY", "IIMAGE2DRECT", "IIMAGE3D", "IIMAGEBUFFER", 
			"IIMAGECUBE", "IIMAGECUBEARRAY", "IMAGE1D", "IMAGE1DARRAY", "IMAGE2D", 
			"IMAGE2DARRAY", "IMAGE2DMS", "IMAGE2DMSARRAY", "IMAGE2DRECT", "IMAGE3D", 
			"IMAGEBUFFER", "IMAGECUBE", "IMAGECUBEARRAY", "IN", "INOUT", "INT", "INVARIANT", 
			"ISAMPLER1D", "ISAMPLER1DARRAY", "ISAMPLER2D", "ISAMPLER2DARRAY", "ISAMPLER2DMS", 
			"ISAMPLER2DMSARRAY", "ISAMPLER2DRECT", "ISAMPLER3D", "ISAMPLERBUFFER", 
			"ISAMPLERCUBE", "ISAMPLERCUBEARRAY", "ISUBPASSINPUT", "ISUBPASSINPUTMS", 
			"ITEXTURE1D", "ITEXTURE1DARRAY", "ITEXTURE2D", "ITEXTURE2DARRAY", "ITEXTURE2DMS", 
			"ITEXTURE2DMSARRAY", "ITEXTURE2DRECT", "ITEXTURE3D", "ITEXTUREBUFFER", 
			"ITEXTURECUBE", "ITEXTURECUBEARRAY", "IVEC2", "IVEC3", "IVEC4", "LAYOUT", 
			"LOWP", "MAT2", "MAT2X2", "MAT2X3", "MAT2X4", "MAT3", "MAT3X2", "MAT3X3", 
			"MAT3X4", "MAT4", "MAT4X2", "MAT4X3", "MAT4X4", "MEDIUMP", "NOPERSPECTIVE", 
			"OUT", "PATCH", "PRECISE", "PRECISION", "READONLY", "RESTRICT", "RETURN", 
			"SAMPLE", "SAMPLER", "SAMPLER1D", "SAMPLER1DARRAY", "SAMPLER1DARRAYSHADOW", 
			"SAMPLER1DSHADOW", "SAMPLER2D", "SAMPLER2DARRAY", "SAMPLER2DARRAYSHADOW", 
			"SAMPLER2DMS", "SAMPLER2DMSARRAY", "SAMPLER2DRECT", "SAMPLER2DRECTSHADOW", 
			"SAMPLER2DSHADOW", "SAMPLER3D", "SAMPLERBUFFER", "SAMPLERCUBE", "SAMPLERCUBEARRAY", 
			"SAMPLERCUBEARRAYSHADOW", "SAMPLERCUBESHADOW", "SAMPLERSHADOW", "SHARED", 
			"SMOOTH", "STRUCT", "SUBPASSINPUT", "SUBPASSINPUTMS", "SUBROUTINE", "SWITCH", 
			"TEXTURE1D", "TEXTURE1DARRAY", "TEXTURE2D", "TEXTURE2DARRAY", "TEXTURE2DMS", 
			"TEXTURE2DMSARRAY", "TEXTURE2DRECT", "TEXTURE3D", "TEXTUREBUFFER", "TEXTURECUBE", 
			"TEXTURECUBEARRAY", "TRUE", "UIMAGE1D", "UIMAGE1DARRAY", "UIMAGE2D", 
			"UIMAGE2DARRAY", "UIMAGE2DMS", "UIMAGE2DMSARRAY", "UIMAGE2DRECT", "UIMAGE3D", 
			"UIMAGEBUFFER", "UIMAGECUBE", "UIMAGECUBEARRAY", "UINT", "UNIFORM", "USAMPLER1D", 
			"USAMPLER1DARRAY", "USAMPLER2D", "USAMPLER2DARRAY", "USAMPLER2DMS", "USAMPLER2DMSARRAY", 
			"USAMPLER2DRECT", "USAMPLER3D", "USAMPLERBUFFER", "USAMPLERCUBE", "USAMPLERCUBEARRAY", 
			"USUBPASSINPUT", "USUBPASSINPUTMS", "UTEXTURE1D", "UTEXTURE1DARRAY", 
			"UTEXTURE2D", "UTEXTURE2DARRAY", "UTEXTURE2DMS", "UTEXTURE2DMSARRAY", 
			"UTEXTURE2DRECT", "UTEXTURE3D", "UTEXTUREBUFFER", "UTEXTURECUBE", "UTEXTURECUBEARRAY", 
			"UVEC2", "UVEC3", "UVEC4", "VARYING", "VEC2", "VEC3", "VEC4", "VOID", 
			"VOLATILE", "WHILE", "WRITEONLY", "ADD_ASSIGN", "AMPERSAND", "AND_ASSIGN", 
			"AND_OP", "BANG", "CARET", "COLON", "COMMA", "DASH", "DEC_OP", "DIV_ASSIGN", 
			"DOT", "EQ_OP", "EQUAL", "GE_OP", "INC_OP", "LE_OP", "LEFT_ANGLE", "LEFT_ASSIGN", 
			"LEFT_BRACE", "LEFT_BRACKET", "LEFT_OP", "LEFT_PAREN", "MOD_ASSIGN", 
			"MUL_ASSIGN", "NE_OP", "NUMBER_SIGN", "OR_ASSIGN", "OR_OP", "PERCENT", 
			"PLUS", "QUESTION", "RIGHT_ANGLE", "RIGHT_ASSIGN", "RIGHT_BRACE", "RIGHT_BRACKET", 
			"RIGHT_OP", "RIGHT_PAREN", "SEMICOLON", "SLASH", "STAR", "SUB_ASSIGN", 
			"TILDE", "VERTICAL_BAR", "XOR_ASSIGN", "XOR_OP", "DOUBLECONSTANT", "FLOATCONSTANT", 
			"INTCONSTANT", "UINTCONSTANT", "BLOCK_COMMENT", "LINE_COMMENT", "LINE_CONTINUATION", 
			"IDENTIFIER", "WHITE_SPACE", "DEFINE_DIRECTIVE", "ELIF_DIRECTIVE", "ELSE_DIRECTIVE", 
			"ENDIF_DIRECTIVE", "ERROR_DIRECTIVE", "EXTENSION_DIRECTIVE", "IF_DIRECTIVE", 
			"IFDEF_DIRECTIVE", "IFNDEF_DIRECTIVE", "LINE_DIRECTIVE", "PRAGMA_DIRECTIVE", 
			"UNDEF_DIRECTIVE", "VERSION_DIRECTIVE", "SPACE_TAB_0", "NEWLINE_0", "MACRO_NAME", 
			"NEWLINE_1", "SPACE_TAB_1", "CONSTANT_EXPRESSION", "NEWLINE_2", "ERROR_MESSAGE", 
			"NEWLINE_3", "BEHAVIOR", "EXTENSION_NAME", "NEWLINE_4", "SPACE_TAB_2", 
			"NEWLINE_5", "MACRO_IDENTIFIER", "NEWLINE_6", "SPACE_TAB_3", "LINE_EXPRESSION", 
			"NEWLINE_7", "MACRO_ESC_NEWLINE", "MACRO_TEXT", "NEWLINE_8", "DEBUG", 
			"NEWLINE_9", "OFF", "ON", "OPTIMIZE", "SPACE_TAB_5", "STDGL", "PROGRAM_TEXT", 
			"NEWLINE_10", "SPACE_TAB_6", "NEWLINE_11", "NUMBER", "PROFILE", "SPACE_TAB_7"
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
	public String getGrammarFileName() { return "GLSLParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GLSLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Translation_unitContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(GLSLParser.EOF, 0); }
		public List<External_declarationContext> external_declaration() {
			return getRuleContexts(External_declarationContext.class);
		}
		public External_declarationContext external_declaration(int i) {
			return getRuleContext(External_declarationContext.class,i);
		}
		public Translation_unitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_translation_unit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterTranslation_unit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitTranslation_unit(this);
		}
	}

	public final Translation_unitContext translation_unit() throws RecognitionException {
		Translation_unitContext _localctx = new Translation_unitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_translation_unit);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -713233064466L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -11258999135526913L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599358955263L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 562949953422847L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(138);
				external_declaration();
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(144);
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
	public static class Variable_identifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public Variable_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterVariable_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitVariable_identifier(this);
		}
	}

	public final Variable_identifierContext variable_identifier() throws RecognitionException {
		Variable_identifierContext _localctx = new Variable_identifierContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_variable_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Primary_expressionContext extends ParserRuleContext {
		public Variable_identifierContext variable_identifier() {
			return getRuleContext(Variable_identifierContext.class,0);
		}
		public TerminalNode TRUE() { return getToken(GLSLParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(GLSLParser.FALSE, 0); }
		public TerminalNode INTCONSTANT() { return getToken(GLSLParser.INTCONSTANT, 0); }
		public TerminalNode UINTCONSTANT() { return getToken(GLSLParser.UINTCONSTANT, 0); }
		public TerminalNode FLOATCONSTANT() { return getToken(GLSLParser.FLOATCONSTANT, 0); }
		public TerminalNode DOUBLECONSTANT() { return getToken(GLSLParser.DOUBLECONSTANT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public Primary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPrimary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPrimary_expression(this);
		}
	}

	public final Primary_expressionContext primary_expression() throws RecognitionException {
		Primary_expressionContext _localctx = new Primary_expressionContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_primary_expression);
		try {
			setState(159);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(148);
				variable_identifier();
				}
				break;
			case TRUE:
				enterOuterAlt(_localctx, 2);
				{
				setState(149);
				match(TRUE);
				}
				break;
			case FALSE:
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(FALSE);
				}
				break;
			case INTCONSTANT:
				enterOuterAlt(_localctx, 4);
				{
				setState(151);
				match(INTCONSTANT);
				}
				break;
			case UINTCONSTANT:
				enterOuterAlt(_localctx, 5);
				{
				setState(152);
				match(UINTCONSTANT);
				}
				break;
			case FLOATCONSTANT:
				enterOuterAlt(_localctx, 6);
				{
				setState(153);
				match(FLOATCONSTANT);
				}
				break;
			case DOUBLECONSTANT:
				enterOuterAlt(_localctx, 7);
				{
				setState(154);
				match(DOUBLECONSTANT);
				}
				break;
			case LEFT_PAREN:
				enterOuterAlt(_localctx, 8);
				{
				setState(155);
				match(LEFT_PAREN);
				setState(156);
				expression(0);
				setState(157);
				match(RIGHT_PAREN);
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
	public static class Postfix_expressionContext extends ParserRuleContext {
		public Primary_expressionContext primary_expression() {
			return getRuleContext(Primary_expressionContext.class,0);
		}
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public Function_call_parametersContext function_call_parameters() {
			return getRuleContext(Function_call_parametersContext.class,0);
		}
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode LEFT_BRACKET() { return getToken(GLSLParser.LEFT_BRACKET, 0); }
		public Integer_expressionContext integer_expression() {
			return getRuleContext(Integer_expressionContext.class,0);
		}
		public TerminalNode RIGHT_BRACKET() { return getToken(GLSLParser.RIGHT_BRACKET, 0); }
		public TerminalNode DOT() { return getToken(GLSLParser.DOT, 0); }
		public Field_selectionContext field_selection() {
			return getRuleContext(Field_selectionContext.class,0);
		}
		public TerminalNode INC_OP() { return getToken(GLSLParser.INC_OP, 0); }
		public TerminalNode DEC_OP() { return getToken(GLSLParser.DEC_OP, 0); }
		public Postfix_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPostfix_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPostfix_expression(this);
		}
	}

	public final Postfix_expressionContext postfix_expression() throws RecognitionException {
		return postfix_expression(0);
	}

	private Postfix_expressionContext postfix_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Postfix_expressionContext _localctx = new Postfix_expressionContext(_ctx, _parentState);
		Postfix_expressionContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_postfix_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				{
				setState(162);
				primary_expression();
				}
				break;
			case 2:
				{
				setState(163);
				type_specifier();
				setState(164);
				match(LEFT_PAREN);
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -6917529530286505755L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & -4501401023543297L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & -9222246411859393985L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & -8138003422817533829L) != 0)) {
					{
					setState(165);
					function_call_parameters();
					}
				}

				setState(168);
				match(RIGHT_PAREN);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(192);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(190);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
					case 1:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(172);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(173);
						match(LEFT_BRACKET);
						setState(174);
						integer_expression();
						setState(175);
						match(RIGHT_BRACKET);
						}
						break;
					case 2:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(177);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(178);
						match(LEFT_PAREN);
						setState(180);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -6917529530286505755L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & -4501401023543297L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & -9222246411859393985L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & -8138003422817533829L) != 0)) {
							{
							setState(179);
							function_call_parameters();
							}
						}

						setState(182);
						match(RIGHT_PAREN);
						}
						break;
					case 3:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(183);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(184);
						match(DOT);
						setState(185);
						field_selection();
						}
						break;
					case 4:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(186);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(187);
						match(INC_OP);
						}
						break;
					case 5:
						{
						_localctx = new Postfix_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expression);
						setState(188);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(189);
						match(DEC_OP);
						}
						break;
					}
					} 
				}
				setState(194);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class Field_selectionContext extends ParserRuleContext {
		public Variable_identifierContext variable_identifier() {
			return getRuleContext(Variable_identifierContext.class,0);
		}
		public Function_callContext function_call() {
			return getRuleContext(Function_callContext.class,0);
		}
		public Field_selectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_field_selection; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterField_selection(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitField_selection(this);
		}
	}

	public final Field_selectionContext field_selection() throws RecognitionException {
		Field_selectionContext _localctx = new Field_selectionContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_field_selection);
		try {
			setState(197);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195);
				variable_identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(196);
				function_call();
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
	public static class Integer_expressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Integer_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInteger_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInteger_expression(this);
		}
	}

	public final Integer_expressionContext integer_expression() throws RecognitionException {
		Integer_expressionContext _localctx = new Integer_expressionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_integer_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
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
	public static class Function_callContext extends ParserRuleContext {
		public Function_identifierContext function_identifier() {
			return getRuleContext(Function_identifierContext.class,0);
		}
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public Function_call_parametersContext function_call_parameters() {
			return getRuleContext(Function_call_parametersContext.class,0);
		}
		public Function_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunction_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunction_call(this);
		}
	}

	public final Function_callContext function_call() throws RecognitionException {
		Function_callContext _localctx = new Function_callContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_function_call);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
			function_identifier();
			setState(202);
			match(LEFT_PAREN);
			setState(204);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -6917529530286505755L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & -4501401023543297L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & -9222246411859393985L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & -8138003422817533829L) != 0)) {
				{
				setState(203);
				function_call_parameters();
				}
			}

			setState(206);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_identifierContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public Function_identifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunction_identifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunction_identifier(this);
		}
	}

	public final Function_identifierContext function_identifier() throws RecognitionException {
		Function_identifierContext _localctx = new Function_identifierContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_function_identifier);
		try {
			setState(210);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(208);
				type_specifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(209);
				postfix_expression(0);
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
	public static class Function_call_parametersContext extends ParserRuleContext {
		public List<Assignment_expressionContext> assignment_expression() {
			return getRuleContexts(Assignment_expressionContext.class);
		}
		public Assignment_expressionContext assignment_expression(int i) {
			return getRuleContext(Assignment_expressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public TerminalNode VOID() { return getToken(GLSLParser.VOID, 0); }
		public Function_call_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_call_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunction_call_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunction_call_parameters(this);
		}
	}

	public final Function_call_parametersContext function_call_parameters() throws RecognitionException {
		Function_call_parametersContext _localctx = new Function_call_parametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_function_call_parameters);
		int _la;
		try {
			setState(221);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				assignment_expression();
				setState(217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(213);
					match(COMMA);
					setState(214);
					assignment_expression();
					}
					}
					setState(219);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220);
				match(VOID);
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
	public static class Unary_expressionContext extends ParserRuleContext {
		public Postfix_expressionContext postfix_expression() {
			return getRuleContext(Postfix_expressionContext.class,0);
		}
		public TerminalNode INC_OP() { return getToken(GLSLParser.INC_OP, 0); }
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public TerminalNode DEC_OP() { return getToken(GLSLParser.DEC_OP, 0); }
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Unary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterUnary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitUnary_expression(this);
		}
	}

	public final Unary_expressionContext unary_expression() throws RecognitionException {
		Unary_expressionContext _localctx = new Unary_expressionContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unary_expression);
		try {
			setState(231);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOMIC_UINT:
			case BOOL:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case DMAT2:
			case DMAT2X2:
			case DMAT2X3:
			case DMAT2X4:
			case DMAT3:
			case DMAT3X2:
			case DMAT3X3:
			case DMAT3X4:
			case DMAT4:
			case DMAT4X2:
			case DMAT4X3:
			case DMAT4X4:
			case DOUBLE:
			case DVEC2:
			case DVEC3:
			case DVEC4:
			case FALSE:
			case FLOAT:
			case IIMAGE1D:
			case IIMAGE1DARRAY:
			case IIMAGE2D:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE3D:
			case IIMAGEBUFFER:
			case IIMAGECUBE:
			case IIMAGECUBEARRAY:
			case IMAGE1D:
			case IMAGE1DARRAY:
			case IMAGE2D:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE3D:
			case IMAGEBUFFER:
			case IMAGECUBE:
			case IMAGECUBEARRAY:
			case INT:
			case ISAMPLER1D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2D:
			case ISAMPLER2DARRAY:
			case ISAMPLER2DMS:
			case ISAMPLER2DMSARRAY:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLERBUFFER:
			case ISAMPLERCUBE:
			case ISAMPLERCUBEARRAY:
			case IVEC2:
			case IVEC3:
			case IVEC4:
			case MAT2:
			case MAT2X2:
			case MAT2X3:
			case MAT2X4:
			case MAT3:
			case MAT3X2:
			case MAT3X3:
			case MAT3X4:
			case MAT4:
			case MAT4X2:
			case MAT4X3:
			case MAT4X4:
			case SAMPLER1D:
			case SAMPLER1DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER1DSHADOW:
			case SAMPLER2D:
			case SAMPLER2DARRAY:
			case SAMPLER2DARRAYSHADOW:
			case SAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case SAMPLER2DRECT:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER3D:
			case SAMPLERBUFFER:
			case SAMPLERCUBE:
			case SAMPLERCUBEARRAY:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBESHADOW:
			case STRUCT:
			case TRUE:
			case UIMAGE1D:
			case UIMAGE1DARRAY:
			case UIMAGE2D:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE3D:
			case UIMAGEBUFFER:
			case UIMAGECUBE:
			case UIMAGECUBEARRAY:
			case UINT:
			case USAMPLER1D:
			case USAMPLER1DARRAY:
			case USAMPLER2D:
			case USAMPLER2DARRAY:
			case USAMPLER2DMS:
			case USAMPLER2DMSARRAY:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLERBUFFER:
			case USAMPLERCUBE:
			case USAMPLERCUBEARRAY:
			case UVEC2:
			case UVEC3:
			case UVEC4:
			case VEC2:
			case VEC3:
			case VEC4:
			case VOID:
			case LEFT_PAREN:
			case DOUBLECONSTANT:
			case FLOATCONSTANT:
			case INTCONSTANT:
			case UINTCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(223);
				postfix_expression(0);
				}
				break;
			case INC_OP:
				enterOuterAlt(_localctx, 2);
				{
				setState(224);
				match(INC_OP);
				setState(225);
				unary_expression();
				}
				break;
			case DEC_OP:
				enterOuterAlt(_localctx, 3);
				{
				setState(226);
				match(DEC_OP);
				setState(227);
				unary_expression();
				}
				break;
			case BANG:
			case DASH:
			case PLUS:
			case TILDE:
				enterOuterAlt(_localctx, 4);
				{
				setState(228);
				unary_operator();
				setState(229);
				unary_expression();
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
	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(GLSLParser.PLUS, 0); }
		public TerminalNode DASH() { return getToken(GLSLParser.DASH, 0); }
		public TerminalNode BANG() { return getToken(GLSLParser.BANG, 0); }
		public TerminalNode TILDE() { return getToken(GLSLParser.TILDE, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitUnary_operator(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233);
			_la = _input.LA(1);
			if ( !(((((_la - 208)) & ~0x3f) == 0 && ((1L << (_la - 208)) & 274945015825L) != 0)) ) {
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
	public static class Assignment_expressionContext extends ParserRuleContext {
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public Assignment_operatorContext assignment_operator() {
			return getRuleContext(Assignment_operatorContext.class,0);
		}
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Assignment_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterAssignment_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitAssignment_expression(this);
		}
	}

	public final Assignment_expressionContext assignment_expression() throws RecognitionException {
		Assignment_expressionContext _localctx = new Assignment_expressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_assignment_expression);
		try {
			setState(240);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(235);
				constant_expression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(236);
				unary_expression();
				setState(237);
				assignment_operator();
				setState(238);
				assignment_expression();
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
	public static class Assignment_operatorContext extends ParserRuleContext {
		public TerminalNode EQUAL() { return getToken(GLSLParser.EQUAL, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(GLSLParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(GLSLParser.DIV_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(GLSLParser.MOD_ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(GLSLParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(GLSLParser.SUB_ASSIGN, 0); }
		public TerminalNode LEFT_ASSIGN() { return getToken(GLSLParser.LEFT_ASSIGN, 0); }
		public TerminalNode RIGHT_ASSIGN() { return getToken(GLSLParser.RIGHT_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(GLSLParser.AND_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(GLSLParser.XOR_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(GLSLParser.OR_ASSIGN, 0); }
		public Assignment_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterAssignment_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitAssignment_operator(this);
		}
	}

	public final Assignment_operatorContext assignment_operator() throws RecognitionException {
		Assignment_operatorContext _localctx = new Assignment_operatorContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_assignment_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			_la = _input.LA(1);
			if ( !(((((_la - 204)) & ~0x3f) == 0 && ((1L << (_la - 204)) & 19799958889477L) != 0)) ) {
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
	public static class Binary_expressionContext extends ParserRuleContext {
		public Unary_expressionContext unary_expression() {
			return getRuleContext(Unary_expressionContext.class,0);
		}
		public List<Binary_expressionContext> binary_expression() {
			return getRuleContexts(Binary_expressionContext.class);
		}
		public Binary_expressionContext binary_expression(int i) {
			return getRuleContext(Binary_expressionContext.class,i);
		}
		public TerminalNode STAR() { return getToken(GLSLParser.STAR, 0); }
		public TerminalNode SLASH() { return getToken(GLSLParser.SLASH, 0); }
		public TerminalNode PERCENT() { return getToken(GLSLParser.PERCENT, 0); }
		public TerminalNode PLUS() { return getToken(GLSLParser.PLUS, 0); }
		public TerminalNode DASH() { return getToken(GLSLParser.DASH, 0); }
		public TerminalNode LEFT_OP() { return getToken(GLSLParser.LEFT_OP, 0); }
		public TerminalNode RIGHT_OP() { return getToken(GLSLParser.RIGHT_OP, 0); }
		public TerminalNode LEFT_ANGLE() { return getToken(GLSLParser.LEFT_ANGLE, 0); }
		public TerminalNode RIGHT_ANGLE() { return getToken(GLSLParser.RIGHT_ANGLE, 0); }
		public TerminalNode LE_OP() { return getToken(GLSLParser.LE_OP, 0); }
		public TerminalNode GE_OP() { return getToken(GLSLParser.GE_OP, 0); }
		public TerminalNode EQ_OP() { return getToken(GLSLParser.EQ_OP, 0); }
		public TerminalNode NE_OP() { return getToken(GLSLParser.NE_OP, 0); }
		public TerminalNode AMPERSAND() { return getToken(GLSLParser.AMPERSAND, 0); }
		public TerminalNode CARET() { return getToken(GLSLParser.CARET, 0); }
		public TerminalNode VERTICAL_BAR() { return getToken(GLSLParser.VERTICAL_BAR, 0); }
		public TerminalNode AND_OP() { return getToken(GLSLParser.AND_OP, 0); }
		public TerminalNode XOR_OP() { return getToken(GLSLParser.XOR_OP, 0); }
		public TerminalNode OR_OP() { return getToken(GLSLParser.OR_OP, 0); }
		public Binary_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_binary_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterBinary_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitBinary_expression(this);
		}
	}

	public final Binary_expressionContext binary_expression() throws RecognitionException {
		return binary_expression(0);
	}

	private Binary_expressionContext binary_expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Binary_expressionContext _localctx = new Binary_expressionContext(_ctx, _parentState);
		Binary_expressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_binary_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(245);
			unary_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(282);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(280);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
					case 1:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(247);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(248);
						_la = _input.LA(1);
						if ( !(((((_la - 233)) & ~0x3f) == 0 && ((1L << (_la - 233)) & 3073L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(249);
						binary_expression(12);
						}
						break;
					case 2:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(250);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(251);
						_la = _input.LA(1);
						if ( !(_la==DASH || _la==PLUS) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(252);
						binary_expression(11);
						}
						break;
					case 3:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(253);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(254);
						_la = _input.LA(1);
						if ( !(_la==LEFT_OP || _la==RIGHT_OP) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(255);
						binary_expression(10);
						}
						break;
					case 4:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(256);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(257);
						_la = _input.LA(1);
						if ( !(((((_la - 218)) & ~0x3f) == 0 && ((1L << (_la - 218)) & 262157L) != 0)) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(258);
						binary_expression(9);
						}
						break;
					case 5:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(259);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(260);
						_la = _input.LA(1);
						if ( !(_la==EQ_OP || _la==NE_OP) ) {
						_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(261);
						binary_expression(8);
						}
						break;
					case 6:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(262);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(263);
						match(AMPERSAND);
						setState(264);
						binary_expression(7);
						}
						break;
					case 7:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(265);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(266);
						match(CARET);
						setState(267);
						binary_expression(6);
						}
						break;
					case 8:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(268);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(269);
						match(VERTICAL_BAR);
						setState(270);
						binary_expression(5);
						}
						break;
					case 9:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(271);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(272);
						match(AND_OP);
						setState(273);
						binary_expression(4);
						}
						break;
					case 10:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(274);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(275);
						match(XOR_OP);
						setState(276);
						binary_expression(3);
						}
						break;
					case 11:
						{
						_localctx = new Binary_expressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_binary_expression);
						setState(277);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(278);
						match(OR_OP);
						setState(279);
						binary_expression(2);
						}
						break;
					}
					} 
				}
				setState(284);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
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
	public static class ExpressionContext extends ParserRuleContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(GLSLParser.COMMA, 0); }
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitExpression(this);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(286);
			assignment_expression();
			}
			_ctx.stop = _input.LT(-1);
			setState(293);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new ExpressionContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(288);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(289);
					match(COMMA);
					setState(290);
					assignment_expression();
					}
					} 
				}
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,16,_ctx);
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
	public static class Constant_expressionContext extends ParserRuleContext {
		public Binary_expressionContext binary_expression() {
			return getRuleContext(Binary_expressionContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(GLSLParser.QUESTION, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GLSLParser.COLON, 0); }
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public Constant_expressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterConstant_expression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitConstant_expression(this);
		}
	}

	public final Constant_expressionContext constant_expression() throws RecognitionException {
		Constant_expressionContext _localctx = new Constant_expressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_constant_expression);
		try {
			setState(303);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(296);
				binary_expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(297);
				binary_expression(0);
				setState(298);
				match(QUESTION);
				setState(299);
				expression(0);
				setState(300);
				match(COLON);
				setState(301);
				assignment_expression();
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
	public static class DeclarationContext extends ParserRuleContext {
		public Function_prototypeContext function_prototype() {
			return getRuleContext(Function_prototypeContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public Init_declarator_listContext init_declarator_list() {
			return getRuleContext(Init_declarator_listContext.class,0);
		}
		public TerminalNode PRECISION() { return getToken(GLSLParser.PRECISION, 0); }
		public Precision_qualifierContext precision_qualifier() {
			return getRuleContext(Precision_qualifierContext.class,0);
		}
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Type_qualifierContext type_qualifier() {
			return getRuleContext(Type_qualifierContext.class,0);
		}
		public List<TerminalNode> IDENTIFIER() { return getTokens(GLSLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GLSLParser.IDENTIFIER, i);
		}
		public TerminalNode LEFT_BRACE() { return getToken(GLSLParser.LEFT_BRACE, 0); }
		public Struct_declaration_listContext struct_declaration_list() {
			return getRuleContext(Struct_declaration_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GLSLParser.RIGHT_BRACE, 0); }
		public Array_specifierContext array_specifier() {
			return getRuleContext(Array_specifierContext.class,0);
		}
		public Identifier_listContext identifier_list() {
			return getRuleContext(Identifier_listContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDeclaration(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_declaration);
		int _la;
		try {
			setState(335);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(305);
				function_prototype();
				setState(306);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(308);
				init_declarator_list();
				setState(309);
				match(SEMICOLON);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(311);
				match(PRECISION);
				setState(312);
				precision_qualifier();
				setState(313);
				type_specifier();
				setState(314);
				match(SEMICOLON);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(316);
				type_qualifier();
				setState(317);
				match(IDENTIFIER);
				setState(318);
				match(LEFT_BRACE);
				setState(319);
				struct_declaration_list();
				setState(320);
				match(RIGHT_BRACE);
				setState(325);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(321);
					match(IDENTIFIER);
					setState(323);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LEFT_BRACKET) {
						{
						setState(322);
						array_specifier();
						}
					}

					}
				}

				setState(327);
				match(SEMICOLON);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(329);
				type_qualifier();
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==IDENTIFIER) {
					{
					setState(330);
					identifier_list();
					}
				}

				setState(333);
				match(SEMICOLON);
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
	public static class Identifier_listContext extends ParserRuleContext {
		public List<TerminalNode> IDENTIFIER() { return getTokens(GLSLParser.IDENTIFIER); }
		public TerminalNode IDENTIFIER(int i) {
			return getToken(GLSLParser.IDENTIFIER, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public Identifier_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterIdentifier_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitIdentifier_list(this);
		}
	}

	public final Identifier_listContext identifier_list() throws RecognitionException {
		Identifier_listContext _localctx = new Identifier_listContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_identifier_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(IDENTIFIER);
			setState(342);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(338);
				match(COMMA);
				setState(339);
				match(IDENTIFIER);
				}
				}
				setState(344);
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
	public static class Function_prototypeContext extends ParserRuleContext {
		public Fully_specified_typeContext fully_specified_type() {
			return getRuleContext(Fully_specified_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public Function_parametersContext function_parameters() {
			return getRuleContext(Function_parametersContext.class,0);
		}
		public Function_prototypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_prototype; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunction_prototype(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunction_prototype(this);
		}
	}

	public final Function_prototypeContext function_prototype() throws RecognitionException {
		Function_prototypeContext _localctx = new Function_prototypeContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_function_prototype);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			fully_specified_type();
			setState(346);
			match(IDENTIFIER);
			setState(347);
			match(LEFT_PAREN);
			setState(349);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -713233064466L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -11540474112237569L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599358955263L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 1535L) != 0) || _la==IDENTIFIER) {
				{
				setState(348);
				function_parameters();
				}
			}

			setState(351);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Function_parametersContext extends ParserRuleContext {
		public List<Parameter_declarationContext> parameter_declaration() {
			return getRuleContexts(Parameter_declarationContext.class);
		}
		public Parameter_declarationContext parameter_declaration(int i) {
			return getRuleContext(Parameter_declarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public Function_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunction_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunction_parameters(this);
		}
	}

	public final Function_parametersContext function_parameters() throws RecognitionException {
		Function_parametersContext _localctx = new Function_parametersContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_function_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(353);
			parameter_declaration();
			setState(358);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(354);
				match(COMMA);
				setState(355);
				parameter_declaration();
				}
				}
				setState(360);
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
	public static class Parameter_declaratorContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public Array_specifierContext array_specifier() {
			return getRuleContext(Array_specifierContext.class,0);
		}
		public Parameter_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterParameter_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitParameter_declarator(this);
		}
	}

	public final Parameter_declaratorContext parameter_declarator() throws RecognitionException {
		Parameter_declaratorContext _localctx = new Parameter_declaratorContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_parameter_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			type_specifier();
			setState(362);
			match(IDENTIFIER);
			setState(364);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(363);
				array_specifier();
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
	public static class Parameter_declarationContext extends ParserRuleContext {
		public Type_qualifierContext type_qualifier() {
			return getRuleContext(Type_qualifierContext.class,0);
		}
		public Parameter_declaratorContext parameter_declarator() {
			return getRuleContext(Parameter_declaratorContext.class,0);
		}
		public Parameter_type_specifierContext parameter_type_specifier() {
			return getRuleContext(Parameter_type_specifierContext.class,0);
		}
		public Parameter_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterParameter_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitParameter_declaration(this);
		}
	}

	public final Parameter_declarationContext parameter_declaration() throws RecognitionException {
		Parameter_declarationContext _localctx = new Parameter_declarationContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_parameter_declaration);
		try {
			setState(373);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,27,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(366);
				type_qualifier();
				setState(369);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
				case 1:
					{
					setState(367);
					parameter_declarator();
					}
					break;
				case 2:
					{
					setState(368);
					parameter_type_specifier();
					}
					break;
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(371);
				parameter_declarator();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(372);
				parameter_type_specifier();
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
	public static class Parameter_type_specifierContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Parameter_type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_type_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterParameter_type_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitParameter_type_specifier(this);
		}
	}

	public final Parameter_type_specifierContext parameter_type_specifier() throws RecognitionException {
		Parameter_type_specifierContext _localctx = new Parameter_type_specifierContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_parameter_type_specifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375);
			type_specifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Init_declarator_listContext extends ParserRuleContext {
		public Single_declarationContext single_declaration() {
			return getRuleContext(Single_declarationContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public List<Typeless_declarationContext> typeless_declaration() {
			return getRuleContexts(Typeless_declarationContext.class);
		}
		public Typeless_declarationContext typeless_declaration(int i) {
			return getRuleContext(Typeless_declarationContext.class,i);
		}
		public Init_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_init_declarator_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInit_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInit_declarator_list(this);
		}
	}

	public final Init_declarator_listContext init_declarator_list() throws RecognitionException {
		Init_declarator_listContext _localctx = new Init_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_init_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(377);
			single_declaration();
			setState(382);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(378);
				match(COMMA);
				setState(379);
				typeless_declaration();
				}
				}
				setState(384);
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
	public static class Single_declarationContext extends ParserRuleContext {
		public Fully_specified_typeContext fully_specified_type() {
			return getRuleContext(Fully_specified_typeContext.class,0);
		}
		public Typeless_declarationContext typeless_declaration() {
			return getRuleContext(Typeless_declarationContext.class,0);
		}
		public Single_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSingle_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSingle_declaration(this);
		}
	}

	public final Single_declarationContext single_declaration() throws RecognitionException {
		Single_declarationContext _localctx = new Single_declarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_single_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			fully_specified_type();
			setState(387);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(386);
				typeless_declaration();
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
	public static class Typeless_declarationContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public Array_specifierContext array_specifier() {
			return getRuleContext(Array_specifierContext.class,0);
		}
		public TerminalNode EQUAL() { return getToken(GLSLParser.EQUAL, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public Typeless_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeless_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterTypeless_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitTypeless_declaration(this);
		}
	}

	public final Typeless_declarationContext typeless_declaration() throws RecognitionException {
		Typeless_declarationContext _localctx = new Typeless_declarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_typeless_declaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(389);
			match(IDENTIFIER);
			setState(391);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(390);
				array_specifier();
				}
			}

			setState(395);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EQUAL) {
				{
				setState(393);
				match(EQUAL);
				setState(394);
				initializer();
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
	public static class Fully_specified_typeContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Type_qualifierContext type_qualifier() {
			return getRuleContext(Type_qualifierContext.class,0);
		}
		public Fully_specified_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fully_specified_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFully_specified_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFully_specified_type(this);
		}
	}

	public final Fully_specified_typeContext fully_specified_type() throws RecognitionException {
		Fully_specified_typeContext _localctx = new Fully_specified_typeContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_fully_specified_type);
		try {
			setState(401);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOMIC_UINT:
			case BOOL:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case DMAT2:
			case DMAT2X2:
			case DMAT2X3:
			case DMAT2X4:
			case DMAT3:
			case DMAT3X2:
			case DMAT3X3:
			case DMAT3X4:
			case DMAT4:
			case DMAT4X2:
			case DMAT4X3:
			case DMAT4X4:
			case DOUBLE:
			case DVEC2:
			case DVEC3:
			case DVEC4:
			case FLOAT:
			case IIMAGE1D:
			case IIMAGE1DARRAY:
			case IIMAGE2D:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE3D:
			case IIMAGEBUFFER:
			case IIMAGECUBE:
			case IIMAGECUBEARRAY:
			case IMAGE1D:
			case IMAGE1DARRAY:
			case IMAGE2D:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE3D:
			case IMAGEBUFFER:
			case IMAGECUBE:
			case IMAGECUBEARRAY:
			case INT:
			case ISAMPLER1D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2D:
			case ISAMPLER2DARRAY:
			case ISAMPLER2DMS:
			case ISAMPLER2DMSARRAY:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLERBUFFER:
			case ISAMPLERCUBE:
			case ISAMPLERCUBEARRAY:
			case IVEC2:
			case IVEC3:
			case IVEC4:
			case MAT2:
			case MAT2X2:
			case MAT2X3:
			case MAT2X4:
			case MAT3:
			case MAT3X2:
			case MAT3X3:
			case MAT3X4:
			case MAT4:
			case MAT4X2:
			case MAT4X3:
			case MAT4X4:
			case SAMPLER1D:
			case SAMPLER1DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER1DSHADOW:
			case SAMPLER2D:
			case SAMPLER2DARRAY:
			case SAMPLER2DARRAYSHADOW:
			case SAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case SAMPLER2DRECT:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER3D:
			case SAMPLERBUFFER:
			case SAMPLERCUBE:
			case SAMPLERCUBEARRAY:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBESHADOW:
			case STRUCT:
			case UIMAGE1D:
			case UIMAGE1DARRAY:
			case UIMAGE2D:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE3D:
			case UIMAGEBUFFER:
			case UIMAGECUBE:
			case UIMAGECUBEARRAY:
			case UINT:
			case USAMPLER1D:
			case USAMPLER1DARRAY:
			case USAMPLER2D:
			case USAMPLER2DARRAY:
			case USAMPLER2DMS:
			case USAMPLER2DMSARRAY:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLERBUFFER:
			case USAMPLERCUBE:
			case USAMPLERCUBEARRAY:
			case UVEC2:
			case UVEC3:
			case UVEC4:
			case VEC2:
			case VEC3:
			case VEC4:
			case VOID:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(397);
				type_specifier();
				}
				break;
			case ATTRIBUTE:
			case BUFFER:
			case CENTROID:
			case COHERENT:
			case CONST:
			case FLAT:
			case HIGHP:
			case IN:
			case INOUT:
			case INVARIANT:
			case LAYOUT:
			case LOWP:
			case MEDIUMP:
			case NOPERSPECTIVE:
			case OUT:
			case PATCH:
			case PRECISE:
			case READONLY:
			case RESTRICT:
			case SAMPLE:
			case SHARED:
			case SMOOTH:
			case SUBROUTINE:
			case UNIFORM:
			case VARYING:
			case VOLATILE:
			case WRITEONLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(398);
				type_qualifier();
				setState(399);
				type_specifier();
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
	public static class Invariant_qualifierContext extends ParserRuleContext {
		public TerminalNode INVARIANT() { return getToken(GLSLParser.INVARIANT, 0); }
		public Invariant_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_invariant_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInvariant_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInvariant_qualifier(this);
		}
	}

	public final Invariant_qualifierContext invariant_qualifier() throws RecognitionException {
		Invariant_qualifierContext _localctx = new Invariant_qualifierContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_invariant_qualifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(403);
			match(INVARIANT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Interpolation_qualifierContext extends ParserRuleContext {
		public TerminalNode SMOOTH() { return getToken(GLSLParser.SMOOTH, 0); }
		public TerminalNode FLAT() { return getToken(GLSLParser.FLAT, 0); }
		public TerminalNode NOPERSPECTIVE() { return getToken(GLSLParser.NOPERSPECTIVE, 0); }
		public Interpolation_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interpolation_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInterpolation_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInterpolation_qualifier(this);
		}
	}

	public final Interpolation_qualifierContext interpolation_qualifier() throws RecognitionException {
		Interpolation_qualifierContext _localctx = new Interpolation_qualifierContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_interpolation_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(405);
			_la = _input.LA(1);
			if ( !(_la==FLAT || _la==NOPERSPECTIVE || _la==SMOOTH) ) {
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
	public static class Layout_qualifierContext extends ParserRuleContext {
		public TerminalNode LAYOUT() { return getToken(GLSLParser.LAYOUT, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public Layout_qualifier_id_listContext layout_qualifier_id_list() {
			return getRuleContext(Layout_qualifier_id_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public Layout_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layout_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLayout_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLayout_qualifier(this);
		}
	}

	public final Layout_qualifierContext layout_qualifier() throws RecognitionException {
		Layout_qualifierContext _localctx = new Layout_qualifierContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_layout_qualifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(407);
			match(LAYOUT);
			setState(408);
			match(LEFT_PAREN);
			setState(409);
			layout_qualifier_id_list();
			setState(410);
			match(RIGHT_PAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Layout_qualifier_id_listContext extends ParserRuleContext {
		public List<Layout_qualifier_idContext> layout_qualifier_id() {
			return getRuleContexts(Layout_qualifier_idContext.class);
		}
		public Layout_qualifier_idContext layout_qualifier_id(int i) {
			return getRuleContext(Layout_qualifier_idContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public Layout_qualifier_id_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layout_qualifier_id_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLayout_qualifier_id_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLayout_qualifier_id_list(this);
		}
	}

	public final Layout_qualifier_id_listContext layout_qualifier_id_list() throws RecognitionException {
		Layout_qualifier_id_listContext _localctx = new Layout_qualifier_id_listContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_layout_qualifier_id_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(412);
			layout_qualifier_id();
			setState(417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(413);
				match(COMMA);
				setState(414);
				layout_qualifier_id();
				}
				}
				setState(419);
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
	public static class Layout_qualifier_idContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(GLSLParser.EQUAL, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public TerminalNode SHARED() { return getToken(GLSLParser.SHARED, 0); }
		public Layout_qualifier_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_layout_qualifier_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterLayout_qualifier_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitLayout_qualifier_id(this);
		}
	}

	public final Layout_qualifier_idContext layout_qualifier_id() throws RecognitionException {
		Layout_qualifier_idContext _localctx = new Layout_qualifier_idContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_layout_qualifier_id);
		int _la;
		try {
			setState(426);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(420);
				match(IDENTIFIER);
				setState(423);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EQUAL) {
					{
					setState(421);
					match(EQUAL);
					setState(422);
					constant_expression();
					}
				}

				}
				break;
			case SHARED:
				enterOuterAlt(_localctx, 2);
				{
				setState(425);
				match(SHARED);
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
	public static class Precise_qualifierContext extends ParserRuleContext {
		public TerminalNode PRECISE() { return getToken(GLSLParser.PRECISE, 0); }
		public Precise_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precise_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPrecise_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPrecise_qualifier(this);
		}
	}

	public final Precise_qualifierContext precise_qualifier() throws RecognitionException {
		Precise_qualifierContext _localctx = new Precise_qualifierContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_precise_qualifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(428);
			match(PRECISE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_qualifierContext extends ParserRuleContext {
		public List<Single_type_qualifierContext> single_type_qualifier() {
			return getRuleContexts(Single_type_qualifierContext.class);
		}
		public Single_type_qualifierContext single_type_qualifier(int i) {
			return getRuleContext(Single_type_qualifierContext.class,i);
		}
		public Type_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterType_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitType_qualifier(this);
		}
	}

	public final Type_qualifierContext type_qualifier() throws RecognitionException {
		Type_qualifierContext _localctx = new Type_qualifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_type_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(431); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(430);
				single_type_qualifier();
				}
				}
				setState(433); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 2)) & ~0x3f) == 0 && ((1L << (_la - 2)) & -5764607445724821751L) != 0) || ((((_la - 93)) & ~0x3f) == 0 && ((1L << (_la - 93)) & 615726523596803L) != 0) || ((((_la - 168)) & ~0x3f) == 0 && ((1L << (_la - 168)) & 43218108417L) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Single_type_qualifierContext extends ParserRuleContext {
		public Storage_qualifierContext storage_qualifier() {
			return getRuleContext(Storage_qualifierContext.class,0);
		}
		public Layout_qualifierContext layout_qualifier() {
			return getRuleContext(Layout_qualifierContext.class,0);
		}
		public Precision_qualifierContext precision_qualifier() {
			return getRuleContext(Precision_qualifierContext.class,0);
		}
		public Interpolation_qualifierContext interpolation_qualifier() {
			return getRuleContext(Interpolation_qualifierContext.class,0);
		}
		public Invariant_qualifierContext invariant_qualifier() {
			return getRuleContext(Invariant_qualifierContext.class,0);
		}
		public Precise_qualifierContext precise_qualifier() {
			return getRuleContext(Precise_qualifierContext.class,0);
		}
		public Single_type_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_type_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSingle_type_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSingle_type_qualifier(this);
		}
	}

	public final Single_type_qualifierContext single_type_qualifier() throws RecognitionException {
		Single_type_qualifierContext _localctx = new Single_type_qualifierContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_single_type_qualifier);
		try {
			setState(441);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATTRIBUTE:
			case BUFFER:
			case CENTROID:
			case COHERENT:
			case CONST:
			case IN:
			case INOUT:
			case OUT:
			case PATCH:
			case READONLY:
			case RESTRICT:
			case SAMPLE:
			case SHARED:
			case SUBROUTINE:
			case UNIFORM:
			case VARYING:
			case VOLATILE:
			case WRITEONLY:
				enterOuterAlt(_localctx, 1);
				{
				setState(435);
				storage_qualifier();
				}
				break;
			case LAYOUT:
				enterOuterAlt(_localctx, 2);
				{
				setState(436);
				layout_qualifier();
				}
				break;
			case HIGHP:
			case LOWP:
			case MEDIUMP:
				enterOuterAlt(_localctx, 3);
				{
				setState(437);
				precision_qualifier();
				}
				break;
			case FLAT:
			case NOPERSPECTIVE:
			case SMOOTH:
				enterOuterAlt(_localctx, 4);
				{
				setState(438);
				interpolation_qualifier();
				}
				break;
			case INVARIANT:
				enterOuterAlt(_localctx, 5);
				{
				setState(439);
				invariant_qualifier();
				}
				break;
			case PRECISE:
				enterOuterAlt(_localctx, 6);
				{
				setState(440);
				precise_qualifier();
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
	public static class Storage_qualifierContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GLSLParser.CONST, 0); }
		public TerminalNode IN() { return getToken(GLSLParser.IN, 0); }
		public TerminalNode OUT() { return getToken(GLSLParser.OUT, 0); }
		public TerminalNode INOUT() { return getToken(GLSLParser.INOUT, 0); }
		public TerminalNode CENTROID() { return getToken(GLSLParser.CENTROID, 0); }
		public TerminalNode PATCH() { return getToken(GLSLParser.PATCH, 0); }
		public TerminalNode SAMPLE() { return getToken(GLSLParser.SAMPLE, 0); }
		public TerminalNode UNIFORM() { return getToken(GLSLParser.UNIFORM, 0); }
		public TerminalNode BUFFER() { return getToken(GLSLParser.BUFFER, 0); }
		public TerminalNode SHARED() { return getToken(GLSLParser.SHARED, 0); }
		public TerminalNode COHERENT() { return getToken(GLSLParser.COHERENT, 0); }
		public TerminalNode VOLATILE() { return getToken(GLSLParser.VOLATILE, 0); }
		public TerminalNode RESTRICT() { return getToken(GLSLParser.RESTRICT, 0); }
		public TerminalNode READONLY() { return getToken(GLSLParser.READONLY, 0); }
		public TerminalNode WRITEONLY() { return getToken(GLSLParser.WRITEONLY, 0); }
		public TerminalNode SUBROUTINE() { return getToken(GLSLParser.SUBROUTINE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public Type_name_listContext type_name_list() {
			return getRuleContext(Type_name_listContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public TerminalNode ATTRIBUTE() { return getToken(GLSLParser.ATTRIBUTE, 0); }
		public TerminalNode VARYING() { return getToken(GLSLParser.VARYING, 0); }
		public Storage_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_storage_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStorage_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStorage_qualifier(this);
		}
	}

	public final Storage_qualifierContext storage_qualifier() throws RecognitionException {
		Storage_qualifierContext _localctx = new Storage_qualifierContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_storage_qualifier);
		int _la;
		try {
			setState(467);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(443);
				match(CONST);
				}
				break;
			case IN:
				enterOuterAlt(_localctx, 2);
				{
				setState(444);
				match(IN);
				}
				break;
			case OUT:
				enterOuterAlt(_localctx, 3);
				{
				setState(445);
				match(OUT);
				}
				break;
			case INOUT:
				enterOuterAlt(_localctx, 4);
				{
				setState(446);
				match(INOUT);
				}
				break;
			case CENTROID:
				enterOuterAlt(_localctx, 5);
				{
				setState(447);
				match(CENTROID);
				}
				break;
			case PATCH:
				enterOuterAlt(_localctx, 6);
				{
				setState(448);
				match(PATCH);
				}
				break;
			case SAMPLE:
				enterOuterAlt(_localctx, 7);
				{
				setState(449);
				match(SAMPLE);
				}
				break;
			case UNIFORM:
				enterOuterAlt(_localctx, 8);
				{
				setState(450);
				match(UNIFORM);
				}
				break;
			case BUFFER:
				enterOuterAlt(_localctx, 9);
				{
				setState(451);
				match(BUFFER);
				}
				break;
			case SHARED:
				enterOuterAlt(_localctx, 10);
				{
				setState(452);
				match(SHARED);
				}
				break;
			case COHERENT:
				enterOuterAlt(_localctx, 11);
				{
				setState(453);
				match(COHERENT);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 12);
				{
				setState(454);
				match(VOLATILE);
				}
				break;
			case RESTRICT:
				enterOuterAlt(_localctx, 13);
				{
				setState(455);
				match(RESTRICT);
				}
				break;
			case READONLY:
				enterOuterAlt(_localctx, 14);
				{
				setState(456);
				match(READONLY);
				}
				break;
			case WRITEONLY:
				enterOuterAlt(_localctx, 15);
				{
				setState(457);
				match(WRITEONLY);
				}
				break;
			case SUBROUTINE:
				enterOuterAlt(_localctx, 16);
				{
				setState(458);
				match(SUBROUTINE);
				setState(463);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LEFT_PAREN) {
					{
					setState(459);
					match(LEFT_PAREN);
					setState(460);
					type_name_list();
					setState(461);
					match(RIGHT_PAREN);
					}
				}

				}
				break;
			case ATTRIBUTE:
				enterOuterAlt(_localctx, 17);
				{
				setState(465);
				match(ATTRIBUTE);
				}
				break;
			case VARYING:
				enterOuterAlt(_localctx, 18);
				{
				setState(466);
				match(VARYING);
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
	public static class Type_name_listContext extends ParserRuleContext {
		public List<Type_nameContext> type_name() {
			return getRuleContexts(Type_nameContext.class);
		}
		public Type_nameContext type_name(int i) {
			return getRuleContext(Type_nameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public Type_name_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterType_name_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitType_name_list(this);
		}
	}

	public final Type_name_listContext type_name_list() throws RecognitionException {
		Type_name_listContext _localctx = new Type_name_listContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_type_name_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(469);
			type_name();
			setState(474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(470);
				match(COMMA);
				setState(471);
				type_name();
				}
				}
				setState(476);
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
	public static class Type_nameContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public Type_nameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterType_name(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitType_name(this);
		}
	}

	public final Type_nameContext type_name() throws RecognitionException {
		Type_nameContext _localctx = new Type_nameContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_type_name);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(477);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifierContext extends ParserRuleContext {
		public Type_specifier_nonarrayContext type_specifier_nonarray() {
			return getRuleContext(Type_specifier_nonarrayContext.class,0);
		}
		public Array_specifierContext array_specifier() {
			return getRuleContext(Array_specifierContext.class,0);
		}
		public Type_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterType_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitType_specifier(this);
		}
	}

	public final Type_specifierContext type_specifier() throws RecognitionException {
		Type_specifierContext _localctx = new Type_specifierContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_type_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(479);
			type_specifier_nonarray();
			setState(481);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(480);
				array_specifier();
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
	public static class Array_specifierContext extends ParserRuleContext {
		public List<DimensionContext> dimension() {
			return getRuleContexts(DimensionContext.class);
		}
		public DimensionContext dimension(int i) {
			return getRuleContext(DimensionContext.class,i);
		}
		public Array_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_array_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterArray_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitArray_specifier(this);
		}
	}

	public final Array_specifierContext array_specifier() throws RecognitionException {
		Array_specifierContext _localctx = new Array_specifierContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_array_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(484); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(483);
				dimension();
				}
				}
				setState(486); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==LEFT_BRACKET );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DimensionContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACKET() { return getToken(GLSLParser.LEFT_BRACKET, 0); }
		public TerminalNode RIGHT_BRACKET() { return getToken(GLSLParser.RIGHT_BRACKET, 0); }
		public Constant_expressionContext constant_expression() {
			return getRuleContext(Constant_expressionContext.class,0);
		}
		public DimensionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dimension; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDimension(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDimension(this);
		}
	}

	public final DimensionContext dimension() throws RecognitionException {
		DimensionContext _localctx = new DimensionContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_dimension);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(488);
			match(LEFT_BRACKET);
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -6917529530286505755L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & -4501401023543297L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & -9222246411859393985L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & -8138003422817533829L) != 0)) {
				{
				setState(489);
				constant_expression();
				}
			}

			setState(492);
			match(RIGHT_BRACKET);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Type_specifier_nonarrayContext extends ParserRuleContext {
		public TerminalNode VOID() { return getToken(GLSLParser.VOID, 0); }
		public TerminalNode FLOAT() { return getToken(GLSLParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(GLSLParser.DOUBLE, 0); }
		public TerminalNode INT() { return getToken(GLSLParser.INT, 0); }
		public TerminalNode UINT() { return getToken(GLSLParser.UINT, 0); }
		public TerminalNode BOOL() { return getToken(GLSLParser.BOOL, 0); }
		public TerminalNode VEC2() { return getToken(GLSLParser.VEC2, 0); }
		public TerminalNode VEC3() { return getToken(GLSLParser.VEC3, 0); }
		public TerminalNode VEC4() { return getToken(GLSLParser.VEC4, 0); }
		public TerminalNode DVEC2() { return getToken(GLSLParser.DVEC2, 0); }
		public TerminalNode DVEC3() { return getToken(GLSLParser.DVEC3, 0); }
		public TerminalNode DVEC4() { return getToken(GLSLParser.DVEC4, 0); }
		public TerminalNode BVEC2() { return getToken(GLSLParser.BVEC2, 0); }
		public TerminalNode BVEC3() { return getToken(GLSLParser.BVEC3, 0); }
		public TerminalNode BVEC4() { return getToken(GLSLParser.BVEC4, 0); }
		public TerminalNode IVEC2() { return getToken(GLSLParser.IVEC2, 0); }
		public TerminalNode IVEC3() { return getToken(GLSLParser.IVEC3, 0); }
		public TerminalNode IVEC4() { return getToken(GLSLParser.IVEC4, 0); }
		public TerminalNode UVEC2() { return getToken(GLSLParser.UVEC2, 0); }
		public TerminalNode UVEC3() { return getToken(GLSLParser.UVEC3, 0); }
		public TerminalNode UVEC4() { return getToken(GLSLParser.UVEC4, 0); }
		public TerminalNode MAT2() { return getToken(GLSLParser.MAT2, 0); }
		public TerminalNode MAT3() { return getToken(GLSLParser.MAT3, 0); }
		public TerminalNode MAT4() { return getToken(GLSLParser.MAT4, 0); }
		public TerminalNode MAT2X2() { return getToken(GLSLParser.MAT2X2, 0); }
		public TerminalNode MAT2X3() { return getToken(GLSLParser.MAT2X3, 0); }
		public TerminalNode MAT2X4() { return getToken(GLSLParser.MAT2X4, 0); }
		public TerminalNode MAT3X2() { return getToken(GLSLParser.MAT3X2, 0); }
		public TerminalNode MAT3X3() { return getToken(GLSLParser.MAT3X3, 0); }
		public TerminalNode MAT3X4() { return getToken(GLSLParser.MAT3X4, 0); }
		public TerminalNode MAT4X2() { return getToken(GLSLParser.MAT4X2, 0); }
		public TerminalNode MAT4X3() { return getToken(GLSLParser.MAT4X3, 0); }
		public TerminalNode MAT4X4() { return getToken(GLSLParser.MAT4X4, 0); }
		public TerminalNode DMAT2() { return getToken(GLSLParser.DMAT2, 0); }
		public TerminalNode DMAT3() { return getToken(GLSLParser.DMAT3, 0); }
		public TerminalNode DMAT4() { return getToken(GLSLParser.DMAT4, 0); }
		public TerminalNode DMAT2X2() { return getToken(GLSLParser.DMAT2X2, 0); }
		public TerminalNode DMAT2X3() { return getToken(GLSLParser.DMAT2X3, 0); }
		public TerminalNode DMAT2X4() { return getToken(GLSLParser.DMAT2X4, 0); }
		public TerminalNode DMAT3X2() { return getToken(GLSLParser.DMAT3X2, 0); }
		public TerminalNode DMAT3X3() { return getToken(GLSLParser.DMAT3X3, 0); }
		public TerminalNode DMAT3X4() { return getToken(GLSLParser.DMAT3X4, 0); }
		public TerminalNode DMAT4X2() { return getToken(GLSLParser.DMAT4X2, 0); }
		public TerminalNode DMAT4X3() { return getToken(GLSLParser.DMAT4X3, 0); }
		public TerminalNode DMAT4X4() { return getToken(GLSLParser.DMAT4X4, 0); }
		public TerminalNode ATOMIC_UINT() { return getToken(GLSLParser.ATOMIC_UINT, 0); }
		public TerminalNode SAMPLER2D() { return getToken(GLSLParser.SAMPLER2D, 0); }
		public TerminalNode SAMPLER3D() { return getToken(GLSLParser.SAMPLER3D, 0); }
		public TerminalNode SAMPLERCUBE() { return getToken(GLSLParser.SAMPLERCUBE, 0); }
		public TerminalNode SAMPLER2DSHADOW() { return getToken(GLSLParser.SAMPLER2DSHADOW, 0); }
		public TerminalNode SAMPLERCUBESHADOW() { return getToken(GLSLParser.SAMPLERCUBESHADOW, 0); }
		public TerminalNode SAMPLER2DARRAY() { return getToken(GLSLParser.SAMPLER2DARRAY, 0); }
		public TerminalNode SAMPLER2DARRAYSHADOW() { return getToken(GLSLParser.SAMPLER2DARRAYSHADOW, 0); }
		public TerminalNode SAMPLERCUBEARRAY() { return getToken(GLSLParser.SAMPLERCUBEARRAY, 0); }
		public TerminalNode SAMPLERCUBEARRAYSHADOW() { return getToken(GLSLParser.SAMPLERCUBEARRAYSHADOW, 0); }
		public TerminalNode ISAMPLER2D() { return getToken(GLSLParser.ISAMPLER2D, 0); }
		public TerminalNode ISAMPLER3D() { return getToken(GLSLParser.ISAMPLER3D, 0); }
		public TerminalNode ISAMPLERCUBE() { return getToken(GLSLParser.ISAMPLERCUBE, 0); }
		public TerminalNode ISAMPLER2DARRAY() { return getToken(GLSLParser.ISAMPLER2DARRAY, 0); }
		public TerminalNode ISAMPLERCUBEARRAY() { return getToken(GLSLParser.ISAMPLERCUBEARRAY, 0); }
		public TerminalNode USAMPLER2D() { return getToken(GLSLParser.USAMPLER2D, 0); }
		public TerminalNode USAMPLER3D() { return getToken(GLSLParser.USAMPLER3D, 0); }
		public TerminalNode USAMPLERCUBE() { return getToken(GLSLParser.USAMPLERCUBE, 0); }
		public TerminalNode USAMPLER2DARRAY() { return getToken(GLSLParser.USAMPLER2DARRAY, 0); }
		public TerminalNode USAMPLERCUBEARRAY() { return getToken(GLSLParser.USAMPLERCUBEARRAY, 0); }
		public TerminalNode SAMPLER1D() { return getToken(GLSLParser.SAMPLER1D, 0); }
		public TerminalNode SAMPLER1DSHADOW() { return getToken(GLSLParser.SAMPLER1DSHADOW, 0); }
		public TerminalNode SAMPLER1DARRAY() { return getToken(GLSLParser.SAMPLER1DARRAY, 0); }
		public TerminalNode SAMPLER1DARRAYSHADOW() { return getToken(GLSLParser.SAMPLER1DARRAYSHADOW, 0); }
		public TerminalNode ISAMPLER1D() { return getToken(GLSLParser.ISAMPLER1D, 0); }
		public TerminalNode ISAMPLER1DARRAY() { return getToken(GLSLParser.ISAMPLER1DARRAY, 0); }
		public TerminalNode USAMPLER1D() { return getToken(GLSLParser.USAMPLER1D, 0); }
		public TerminalNode USAMPLER1DARRAY() { return getToken(GLSLParser.USAMPLER1DARRAY, 0); }
		public TerminalNode SAMPLER2DRECT() { return getToken(GLSLParser.SAMPLER2DRECT, 0); }
		public TerminalNode SAMPLER2DRECTSHADOW() { return getToken(GLSLParser.SAMPLER2DRECTSHADOW, 0); }
		public TerminalNode ISAMPLER2DRECT() { return getToken(GLSLParser.ISAMPLER2DRECT, 0); }
		public TerminalNode USAMPLER2DRECT() { return getToken(GLSLParser.USAMPLER2DRECT, 0); }
		public TerminalNode SAMPLERBUFFER() { return getToken(GLSLParser.SAMPLERBUFFER, 0); }
		public TerminalNode ISAMPLERBUFFER() { return getToken(GLSLParser.ISAMPLERBUFFER, 0); }
		public TerminalNode USAMPLERBUFFER() { return getToken(GLSLParser.USAMPLERBUFFER, 0); }
		public TerminalNode SAMPLER2DMS() { return getToken(GLSLParser.SAMPLER2DMS, 0); }
		public TerminalNode ISAMPLER2DMS() { return getToken(GLSLParser.ISAMPLER2DMS, 0); }
		public TerminalNode USAMPLER2DMS() { return getToken(GLSLParser.USAMPLER2DMS, 0); }
		public TerminalNode SAMPLER2DMSARRAY() { return getToken(GLSLParser.SAMPLER2DMSARRAY, 0); }
		public TerminalNode ISAMPLER2DMSARRAY() { return getToken(GLSLParser.ISAMPLER2DMSARRAY, 0); }
		public TerminalNode USAMPLER2DMSARRAY() { return getToken(GLSLParser.USAMPLER2DMSARRAY, 0); }
		public TerminalNode IMAGE2D() { return getToken(GLSLParser.IMAGE2D, 0); }
		public TerminalNode IIMAGE2D() { return getToken(GLSLParser.IIMAGE2D, 0); }
		public TerminalNode UIMAGE2D() { return getToken(GLSLParser.UIMAGE2D, 0); }
		public TerminalNode IMAGE3D() { return getToken(GLSLParser.IMAGE3D, 0); }
		public TerminalNode IIMAGE3D() { return getToken(GLSLParser.IIMAGE3D, 0); }
		public TerminalNode UIMAGE3D() { return getToken(GLSLParser.UIMAGE3D, 0); }
		public TerminalNode IMAGECUBE() { return getToken(GLSLParser.IMAGECUBE, 0); }
		public TerminalNode IIMAGECUBE() { return getToken(GLSLParser.IIMAGECUBE, 0); }
		public TerminalNode UIMAGECUBE() { return getToken(GLSLParser.UIMAGECUBE, 0); }
		public TerminalNode IMAGEBUFFER() { return getToken(GLSLParser.IMAGEBUFFER, 0); }
		public TerminalNode IIMAGEBUFFER() { return getToken(GLSLParser.IIMAGEBUFFER, 0); }
		public TerminalNode UIMAGEBUFFER() { return getToken(GLSLParser.UIMAGEBUFFER, 0); }
		public TerminalNode IMAGE1D() { return getToken(GLSLParser.IMAGE1D, 0); }
		public TerminalNode IIMAGE1D() { return getToken(GLSLParser.IIMAGE1D, 0); }
		public TerminalNode UIMAGE1D() { return getToken(GLSLParser.UIMAGE1D, 0); }
		public TerminalNode IMAGE1DARRAY() { return getToken(GLSLParser.IMAGE1DARRAY, 0); }
		public TerminalNode IIMAGE1DARRAY() { return getToken(GLSLParser.IIMAGE1DARRAY, 0); }
		public TerminalNode UIMAGE1DARRAY() { return getToken(GLSLParser.UIMAGE1DARRAY, 0); }
		public TerminalNode IMAGE2DRECT() { return getToken(GLSLParser.IMAGE2DRECT, 0); }
		public TerminalNode IIMAGE2DRECT() { return getToken(GLSLParser.IIMAGE2DRECT, 0); }
		public TerminalNode UIMAGE2DRECT() { return getToken(GLSLParser.UIMAGE2DRECT, 0); }
		public TerminalNode IMAGE2DARRAY() { return getToken(GLSLParser.IMAGE2DARRAY, 0); }
		public TerminalNode IIMAGE2DARRAY() { return getToken(GLSLParser.IIMAGE2DARRAY, 0); }
		public TerminalNode UIMAGE2DARRAY() { return getToken(GLSLParser.UIMAGE2DARRAY, 0); }
		public TerminalNode IMAGECUBEARRAY() { return getToken(GLSLParser.IMAGECUBEARRAY, 0); }
		public TerminalNode IIMAGECUBEARRAY() { return getToken(GLSLParser.IIMAGECUBEARRAY, 0); }
		public TerminalNode UIMAGECUBEARRAY() { return getToken(GLSLParser.UIMAGECUBEARRAY, 0); }
		public TerminalNode IMAGE2DMS() { return getToken(GLSLParser.IMAGE2DMS, 0); }
		public TerminalNode IIMAGE2DMS() { return getToken(GLSLParser.IIMAGE2DMS, 0); }
		public TerminalNode UIMAGE2DMS() { return getToken(GLSLParser.UIMAGE2DMS, 0); }
		public TerminalNode IMAGE2DMSARRAY() { return getToken(GLSLParser.IMAGE2DMSARRAY, 0); }
		public TerminalNode IIMAGE2DMSARRAY() { return getToken(GLSLParser.IIMAGE2DMSARRAY, 0); }
		public TerminalNode UIMAGE2DMSARRAY() { return getToken(GLSLParser.UIMAGE2DMSARRAY, 0); }
		public Struct_specifierContext struct_specifier() {
			return getRuleContext(Struct_specifierContext.class,0);
		}
		public Type_nameContext type_name() {
			return getRuleContext(Type_nameContext.class,0);
		}
		public Type_specifier_nonarrayContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type_specifier_nonarray; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterType_specifier_nonarray(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitType_specifier_nonarray(this);
		}
	}

	public final Type_specifier_nonarrayContext type_specifier_nonarray() throws RecognitionException {
		Type_specifier_nonarrayContext _localctx = new Type_specifier_nonarrayContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_type_specifier_nonarray);
		try {
			setState(615);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VOID:
				enterOuterAlt(_localctx, 1);
				{
				setState(494);
				match(VOID);
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(495);
				match(FLOAT);
				}
				break;
			case DOUBLE:
				enterOuterAlt(_localctx, 3);
				{
				setState(496);
				match(DOUBLE);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 4);
				{
				setState(497);
				match(INT);
				}
				break;
			case UINT:
				enterOuterAlt(_localctx, 5);
				{
				setState(498);
				match(UINT);
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 6);
				{
				setState(499);
				match(BOOL);
				}
				break;
			case VEC2:
				enterOuterAlt(_localctx, 7);
				{
				setState(500);
				match(VEC2);
				}
				break;
			case VEC3:
				enterOuterAlt(_localctx, 8);
				{
				setState(501);
				match(VEC3);
				}
				break;
			case VEC4:
				enterOuterAlt(_localctx, 9);
				{
				setState(502);
				match(VEC4);
				}
				break;
			case DVEC2:
				enterOuterAlt(_localctx, 10);
				{
				setState(503);
				match(DVEC2);
				}
				break;
			case DVEC3:
				enterOuterAlt(_localctx, 11);
				{
				setState(504);
				match(DVEC3);
				}
				break;
			case DVEC4:
				enterOuterAlt(_localctx, 12);
				{
				setState(505);
				match(DVEC4);
				}
				break;
			case BVEC2:
				enterOuterAlt(_localctx, 13);
				{
				setState(506);
				match(BVEC2);
				}
				break;
			case BVEC3:
				enterOuterAlt(_localctx, 14);
				{
				setState(507);
				match(BVEC3);
				}
				break;
			case BVEC4:
				enterOuterAlt(_localctx, 15);
				{
				setState(508);
				match(BVEC4);
				}
				break;
			case IVEC2:
				enterOuterAlt(_localctx, 16);
				{
				setState(509);
				match(IVEC2);
				}
				break;
			case IVEC3:
				enterOuterAlt(_localctx, 17);
				{
				setState(510);
				match(IVEC3);
				}
				break;
			case IVEC4:
				enterOuterAlt(_localctx, 18);
				{
				setState(511);
				match(IVEC4);
				}
				break;
			case UVEC2:
				enterOuterAlt(_localctx, 19);
				{
				setState(512);
				match(UVEC2);
				}
				break;
			case UVEC3:
				enterOuterAlt(_localctx, 20);
				{
				setState(513);
				match(UVEC3);
				}
				break;
			case UVEC4:
				enterOuterAlt(_localctx, 21);
				{
				setState(514);
				match(UVEC4);
				}
				break;
			case MAT2:
				enterOuterAlt(_localctx, 22);
				{
				setState(515);
				match(MAT2);
				}
				break;
			case MAT3:
				enterOuterAlt(_localctx, 23);
				{
				setState(516);
				match(MAT3);
				}
				break;
			case MAT4:
				enterOuterAlt(_localctx, 24);
				{
				setState(517);
				match(MAT4);
				}
				break;
			case MAT2X2:
				enterOuterAlt(_localctx, 25);
				{
				setState(518);
				match(MAT2X2);
				}
				break;
			case MAT2X3:
				enterOuterAlt(_localctx, 26);
				{
				setState(519);
				match(MAT2X3);
				}
				break;
			case MAT2X4:
				enterOuterAlt(_localctx, 27);
				{
				setState(520);
				match(MAT2X4);
				}
				break;
			case MAT3X2:
				enterOuterAlt(_localctx, 28);
				{
				setState(521);
				match(MAT3X2);
				}
				break;
			case MAT3X3:
				enterOuterAlt(_localctx, 29);
				{
				setState(522);
				match(MAT3X3);
				}
				break;
			case MAT3X4:
				enterOuterAlt(_localctx, 30);
				{
				setState(523);
				match(MAT3X4);
				}
				break;
			case MAT4X2:
				enterOuterAlt(_localctx, 31);
				{
				setState(524);
				match(MAT4X2);
				}
				break;
			case MAT4X3:
				enterOuterAlt(_localctx, 32);
				{
				setState(525);
				match(MAT4X3);
				}
				break;
			case MAT4X4:
				enterOuterAlt(_localctx, 33);
				{
				setState(526);
				match(MAT4X4);
				}
				break;
			case DMAT2:
				enterOuterAlt(_localctx, 34);
				{
				setState(527);
				match(DMAT2);
				}
				break;
			case DMAT3:
				enterOuterAlt(_localctx, 35);
				{
				setState(528);
				match(DMAT3);
				}
				break;
			case DMAT4:
				enterOuterAlt(_localctx, 36);
				{
				setState(529);
				match(DMAT4);
				}
				break;
			case DMAT2X2:
				enterOuterAlt(_localctx, 37);
				{
				setState(530);
				match(DMAT2X2);
				}
				break;
			case DMAT2X3:
				enterOuterAlt(_localctx, 38);
				{
				setState(531);
				match(DMAT2X3);
				}
				break;
			case DMAT2X4:
				enterOuterAlt(_localctx, 39);
				{
				setState(532);
				match(DMAT2X4);
				}
				break;
			case DMAT3X2:
				enterOuterAlt(_localctx, 40);
				{
				setState(533);
				match(DMAT3X2);
				}
				break;
			case DMAT3X3:
				enterOuterAlt(_localctx, 41);
				{
				setState(534);
				match(DMAT3X3);
				}
				break;
			case DMAT3X4:
				enterOuterAlt(_localctx, 42);
				{
				setState(535);
				match(DMAT3X4);
				}
				break;
			case DMAT4X2:
				enterOuterAlt(_localctx, 43);
				{
				setState(536);
				match(DMAT4X2);
				}
				break;
			case DMAT4X3:
				enterOuterAlt(_localctx, 44);
				{
				setState(537);
				match(DMAT4X3);
				}
				break;
			case DMAT4X4:
				enterOuterAlt(_localctx, 45);
				{
				setState(538);
				match(DMAT4X4);
				}
				break;
			case ATOMIC_UINT:
				enterOuterAlt(_localctx, 46);
				{
				setState(539);
				match(ATOMIC_UINT);
				}
				break;
			case SAMPLER2D:
				enterOuterAlt(_localctx, 47);
				{
				setState(540);
				match(SAMPLER2D);
				}
				break;
			case SAMPLER3D:
				enterOuterAlt(_localctx, 48);
				{
				setState(541);
				match(SAMPLER3D);
				}
				break;
			case SAMPLERCUBE:
				enterOuterAlt(_localctx, 49);
				{
				setState(542);
				match(SAMPLERCUBE);
				}
				break;
			case SAMPLER2DSHADOW:
				enterOuterAlt(_localctx, 50);
				{
				setState(543);
				match(SAMPLER2DSHADOW);
				}
				break;
			case SAMPLERCUBESHADOW:
				enterOuterAlt(_localctx, 51);
				{
				setState(544);
				match(SAMPLERCUBESHADOW);
				}
				break;
			case SAMPLER2DARRAY:
				enterOuterAlt(_localctx, 52);
				{
				setState(545);
				match(SAMPLER2DARRAY);
				}
				break;
			case SAMPLER2DARRAYSHADOW:
				enterOuterAlt(_localctx, 53);
				{
				setState(546);
				match(SAMPLER2DARRAYSHADOW);
				}
				break;
			case SAMPLERCUBEARRAY:
				enterOuterAlt(_localctx, 54);
				{
				setState(547);
				match(SAMPLERCUBEARRAY);
				}
				break;
			case SAMPLERCUBEARRAYSHADOW:
				enterOuterAlt(_localctx, 55);
				{
				setState(548);
				match(SAMPLERCUBEARRAYSHADOW);
				}
				break;
			case ISAMPLER2D:
				enterOuterAlt(_localctx, 56);
				{
				setState(549);
				match(ISAMPLER2D);
				}
				break;
			case ISAMPLER3D:
				enterOuterAlt(_localctx, 57);
				{
				setState(550);
				match(ISAMPLER3D);
				}
				break;
			case ISAMPLERCUBE:
				enterOuterAlt(_localctx, 58);
				{
				setState(551);
				match(ISAMPLERCUBE);
				}
				break;
			case ISAMPLER2DARRAY:
				enterOuterAlt(_localctx, 59);
				{
				setState(552);
				match(ISAMPLER2DARRAY);
				}
				break;
			case ISAMPLERCUBEARRAY:
				enterOuterAlt(_localctx, 60);
				{
				setState(553);
				match(ISAMPLERCUBEARRAY);
				}
				break;
			case USAMPLER2D:
				enterOuterAlt(_localctx, 61);
				{
				setState(554);
				match(USAMPLER2D);
				}
				break;
			case USAMPLER3D:
				enterOuterAlt(_localctx, 62);
				{
				setState(555);
				match(USAMPLER3D);
				}
				break;
			case USAMPLERCUBE:
				enterOuterAlt(_localctx, 63);
				{
				setState(556);
				match(USAMPLERCUBE);
				}
				break;
			case USAMPLER2DARRAY:
				enterOuterAlt(_localctx, 64);
				{
				setState(557);
				match(USAMPLER2DARRAY);
				}
				break;
			case USAMPLERCUBEARRAY:
				enterOuterAlt(_localctx, 65);
				{
				setState(558);
				match(USAMPLERCUBEARRAY);
				}
				break;
			case SAMPLER1D:
				enterOuterAlt(_localctx, 66);
				{
				setState(559);
				match(SAMPLER1D);
				}
				break;
			case SAMPLER1DSHADOW:
				enterOuterAlt(_localctx, 67);
				{
				setState(560);
				match(SAMPLER1DSHADOW);
				}
				break;
			case SAMPLER1DARRAY:
				enterOuterAlt(_localctx, 68);
				{
				setState(561);
				match(SAMPLER1DARRAY);
				}
				break;
			case SAMPLER1DARRAYSHADOW:
				enterOuterAlt(_localctx, 69);
				{
				setState(562);
				match(SAMPLER1DARRAYSHADOW);
				}
				break;
			case ISAMPLER1D:
				enterOuterAlt(_localctx, 70);
				{
				setState(563);
				match(ISAMPLER1D);
				}
				break;
			case ISAMPLER1DARRAY:
				enterOuterAlt(_localctx, 71);
				{
				setState(564);
				match(ISAMPLER1DARRAY);
				}
				break;
			case USAMPLER1D:
				enterOuterAlt(_localctx, 72);
				{
				setState(565);
				match(USAMPLER1D);
				}
				break;
			case USAMPLER1DARRAY:
				enterOuterAlt(_localctx, 73);
				{
				setState(566);
				match(USAMPLER1DARRAY);
				}
				break;
			case SAMPLER2DRECT:
				enterOuterAlt(_localctx, 74);
				{
				setState(567);
				match(SAMPLER2DRECT);
				}
				break;
			case SAMPLER2DRECTSHADOW:
				enterOuterAlt(_localctx, 75);
				{
				setState(568);
				match(SAMPLER2DRECTSHADOW);
				}
				break;
			case ISAMPLER2DRECT:
				enterOuterAlt(_localctx, 76);
				{
				setState(569);
				match(ISAMPLER2DRECT);
				}
				break;
			case USAMPLER2DRECT:
				enterOuterAlt(_localctx, 77);
				{
				setState(570);
				match(USAMPLER2DRECT);
				}
				break;
			case SAMPLERBUFFER:
				enterOuterAlt(_localctx, 78);
				{
				setState(571);
				match(SAMPLERBUFFER);
				}
				break;
			case ISAMPLERBUFFER:
				enterOuterAlt(_localctx, 79);
				{
				setState(572);
				match(ISAMPLERBUFFER);
				}
				break;
			case USAMPLERBUFFER:
				enterOuterAlt(_localctx, 80);
				{
				setState(573);
				match(USAMPLERBUFFER);
				}
				break;
			case SAMPLER2DMS:
				enterOuterAlt(_localctx, 81);
				{
				setState(574);
				match(SAMPLER2DMS);
				}
				break;
			case ISAMPLER2DMS:
				enterOuterAlt(_localctx, 82);
				{
				setState(575);
				match(ISAMPLER2DMS);
				}
				break;
			case USAMPLER2DMS:
				enterOuterAlt(_localctx, 83);
				{
				setState(576);
				match(USAMPLER2DMS);
				}
				break;
			case SAMPLER2DMSARRAY:
				enterOuterAlt(_localctx, 84);
				{
				setState(577);
				match(SAMPLER2DMSARRAY);
				}
				break;
			case ISAMPLER2DMSARRAY:
				enterOuterAlt(_localctx, 85);
				{
				setState(578);
				match(ISAMPLER2DMSARRAY);
				}
				break;
			case USAMPLER2DMSARRAY:
				enterOuterAlt(_localctx, 86);
				{
				setState(579);
				match(USAMPLER2DMSARRAY);
				}
				break;
			case IMAGE2D:
				enterOuterAlt(_localctx, 87);
				{
				setState(580);
				match(IMAGE2D);
				}
				break;
			case IIMAGE2D:
				enterOuterAlt(_localctx, 88);
				{
				setState(581);
				match(IIMAGE2D);
				}
				break;
			case UIMAGE2D:
				enterOuterAlt(_localctx, 89);
				{
				setState(582);
				match(UIMAGE2D);
				}
				break;
			case IMAGE3D:
				enterOuterAlt(_localctx, 90);
				{
				setState(583);
				match(IMAGE3D);
				}
				break;
			case IIMAGE3D:
				enterOuterAlt(_localctx, 91);
				{
				setState(584);
				match(IIMAGE3D);
				}
				break;
			case UIMAGE3D:
				enterOuterAlt(_localctx, 92);
				{
				setState(585);
				match(UIMAGE3D);
				}
				break;
			case IMAGECUBE:
				enterOuterAlt(_localctx, 93);
				{
				setState(586);
				match(IMAGECUBE);
				}
				break;
			case IIMAGECUBE:
				enterOuterAlt(_localctx, 94);
				{
				setState(587);
				match(IIMAGECUBE);
				}
				break;
			case UIMAGECUBE:
				enterOuterAlt(_localctx, 95);
				{
				setState(588);
				match(UIMAGECUBE);
				}
				break;
			case IMAGEBUFFER:
				enterOuterAlt(_localctx, 96);
				{
				setState(589);
				match(IMAGEBUFFER);
				}
				break;
			case IIMAGEBUFFER:
				enterOuterAlt(_localctx, 97);
				{
				setState(590);
				match(IIMAGEBUFFER);
				}
				break;
			case UIMAGEBUFFER:
				enterOuterAlt(_localctx, 98);
				{
				setState(591);
				match(UIMAGEBUFFER);
				}
				break;
			case IMAGE1D:
				enterOuterAlt(_localctx, 99);
				{
				setState(592);
				match(IMAGE1D);
				}
				break;
			case IIMAGE1D:
				enterOuterAlt(_localctx, 100);
				{
				setState(593);
				match(IIMAGE1D);
				}
				break;
			case UIMAGE1D:
				enterOuterAlt(_localctx, 101);
				{
				setState(594);
				match(UIMAGE1D);
				}
				break;
			case IMAGE1DARRAY:
				enterOuterAlt(_localctx, 102);
				{
				setState(595);
				match(IMAGE1DARRAY);
				}
				break;
			case IIMAGE1DARRAY:
				enterOuterAlt(_localctx, 103);
				{
				setState(596);
				match(IIMAGE1DARRAY);
				}
				break;
			case UIMAGE1DARRAY:
				enterOuterAlt(_localctx, 104);
				{
				setState(597);
				match(UIMAGE1DARRAY);
				}
				break;
			case IMAGE2DRECT:
				enterOuterAlt(_localctx, 105);
				{
				setState(598);
				match(IMAGE2DRECT);
				}
				break;
			case IIMAGE2DRECT:
				enterOuterAlt(_localctx, 106);
				{
				setState(599);
				match(IIMAGE2DRECT);
				}
				break;
			case UIMAGE2DRECT:
				enterOuterAlt(_localctx, 107);
				{
				setState(600);
				match(UIMAGE2DRECT);
				}
				break;
			case IMAGE2DARRAY:
				enterOuterAlt(_localctx, 108);
				{
				setState(601);
				match(IMAGE2DARRAY);
				}
				break;
			case IIMAGE2DARRAY:
				enterOuterAlt(_localctx, 109);
				{
				setState(602);
				match(IIMAGE2DARRAY);
				}
				break;
			case UIMAGE2DARRAY:
				enterOuterAlt(_localctx, 110);
				{
				setState(603);
				match(UIMAGE2DARRAY);
				}
				break;
			case IMAGECUBEARRAY:
				enterOuterAlt(_localctx, 111);
				{
				setState(604);
				match(IMAGECUBEARRAY);
				}
				break;
			case IIMAGECUBEARRAY:
				enterOuterAlt(_localctx, 112);
				{
				setState(605);
				match(IIMAGECUBEARRAY);
				}
				break;
			case UIMAGECUBEARRAY:
				enterOuterAlt(_localctx, 113);
				{
				setState(606);
				match(UIMAGECUBEARRAY);
				}
				break;
			case IMAGE2DMS:
				enterOuterAlt(_localctx, 114);
				{
				setState(607);
				match(IMAGE2DMS);
				}
				break;
			case IIMAGE2DMS:
				enterOuterAlt(_localctx, 115);
				{
				setState(608);
				match(IIMAGE2DMS);
				}
				break;
			case UIMAGE2DMS:
				enterOuterAlt(_localctx, 116);
				{
				setState(609);
				match(UIMAGE2DMS);
				}
				break;
			case IMAGE2DMSARRAY:
				enterOuterAlt(_localctx, 117);
				{
				setState(610);
				match(IMAGE2DMSARRAY);
				}
				break;
			case IIMAGE2DMSARRAY:
				enterOuterAlt(_localctx, 118);
				{
				setState(611);
				match(IIMAGE2DMSARRAY);
				}
				break;
			case UIMAGE2DMSARRAY:
				enterOuterAlt(_localctx, 119);
				{
				setState(612);
				match(UIMAGE2DMSARRAY);
				}
				break;
			case STRUCT:
				enterOuterAlt(_localctx, 120);
				{
				setState(613);
				struct_specifier();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 121);
				{
				setState(614);
				type_name();
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
	public static class Precision_qualifierContext extends ParserRuleContext {
		public TerminalNode HIGHP() { return getToken(GLSLParser.HIGHP, 0); }
		public TerminalNode MEDIUMP() { return getToken(GLSLParser.MEDIUMP, 0); }
		public TerminalNode LOWP() { return getToken(GLSLParser.LOWP, 0); }
		public Precision_qualifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_precision_qualifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterPrecision_qualifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitPrecision_qualifier(this);
		}
	}

	public final Precision_qualifierContext precision_qualifier() throws RecognitionException {
		Precision_qualifierContext _localctx = new Precision_qualifierContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_precision_qualifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(617);
			_la = _input.LA(1);
			if ( !(_la==HIGHP || _la==LOWP || _la==MEDIUMP) ) {
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
	public static class Struct_specifierContext extends ParserRuleContext {
		public TerminalNode STRUCT() { return getToken(GLSLParser.STRUCT, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(GLSLParser.LEFT_BRACE, 0); }
		public Struct_declaration_listContext struct_declaration_list() {
			return getRuleContext(Struct_declaration_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GLSLParser.RIGHT_BRACE, 0); }
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public Struct_specifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_specifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStruct_specifier(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStruct_specifier(this);
		}
	}

	public final Struct_specifierContext struct_specifier() throws RecognitionException {
		Struct_specifierContext _localctx = new Struct_specifierContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_struct_specifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(619);
			match(STRUCT);
			setState(621);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IDENTIFIER) {
				{
				setState(620);
				match(IDENTIFIER);
				}
			}

			setState(623);
			match(LEFT_BRACE);
			setState(624);
			struct_declaration_list();
			setState(625);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declaration_listContext extends ParserRuleContext {
		public List<Struct_declarationContext> struct_declaration() {
			return getRuleContexts(Struct_declarationContext.class);
		}
		public Struct_declarationContext struct_declaration(int i) {
			return getRuleContext(Struct_declarationContext.class,i);
		}
		public Struct_declaration_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStruct_declaration_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStruct_declaration_list(this);
		}
	}

	public final Struct_declaration_listContext struct_declaration_list() throws RecognitionException {
		Struct_declaration_listContext _localctx = new Struct_declaration_listContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_struct_declaration_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(628); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(627);
				struct_declaration();
				}
				}
				setState(630); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -713233064466L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -11540474112237569L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599358955263L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 1535L) != 0) || _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Struct_declarationContext extends ParserRuleContext {
		public Type_specifierContext type_specifier() {
			return getRuleContext(Type_specifierContext.class,0);
		}
		public Struct_declarator_listContext struct_declarator_list() {
			return getRuleContext(Struct_declarator_listContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public Type_qualifierContext type_qualifier() {
			return getRuleContext(Type_qualifierContext.class,0);
		}
		public Struct_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStruct_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStruct_declaration(this);
		}
	}

	public final Struct_declarationContext struct_declaration() throws RecognitionException {
		Struct_declarationContext _localctx = new Struct_declarationContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_struct_declaration);
		try {
			setState(641);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOMIC_UINT:
			case BOOL:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case DMAT2:
			case DMAT2X2:
			case DMAT2X3:
			case DMAT2X4:
			case DMAT3:
			case DMAT3X2:
			case DMAT3X3:
			case DMAT3X4:
			case DMAT4:
			case DMAT4X2:
			case DMAT4X3:
			case DMAT4X4:
			case DOUBLE:
			case DVEC2:
			case DVEC3:
			case DVEC4:
			case FLOAT:
			case IIMAGE1D:
			case IIMAGE1DARRAY:
			case IIMAGE2D:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE3D:
			case IIMAGEBUFFER:
			case IIMAGECUBE:
			case IIMAGECUBEARRAY:
			case IMAGE1D:
			case IMAGE1DARRAY:
			case IMAGE2D:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE3D:
			case IMAGEBUFFER:
			case IMAGECUBE:
			case IMAGECUBEARRAY:
			case INT:
			case ISAMPLER1D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2D:
			case ISAMPLER2DARRAY:
			case ISAMPLER2DMS:
			case ISAMPLER2DMSARRAY:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLERBUFFER:
			case ISAMPLERCUBE:
			case ISAMPLERCUBEARRAY:
			case IVEC2:
			case IVEC3:
			case IVEC4:
			case MAT2:
			case MAT2X2:
			case MAT2X3:
			case MAT2X4:
			case MAT3:
			case MAT3X2:
			case MAT3X3:
			case MAT3X4:
			case MAT4:
			case MAT4X2:
			case MAT4X3:
			case MAT4X4:
			case SAMPLER1D:
			case SAMPLER1DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER1DSHADOW:
			case SAMPLER2D:
			case SAMPLER2DARRAY:
			case SAMPLER2DARRAYSHADOW:
			case SAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case SAMPLER2DRECT:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER3D:
			case SAMPLERBUFFER:
			case SAMPLERCUBE:
			case SAMPLERCUBEARRAY:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBESHADOW:
			case STRUCT:
			case UIMAGE1D:
			case UIMAGE1DARRAY:
			case UIMAGE2D:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE3D:
			case UIMAGEBUFFER:
			case UIMAGECUBE:
			case UIMAGECUBEARRAY:
			case UINT:
			case USAMPLER1D:
			case USAMPLER1DARRAY:
			case USAMPLER2D:
			case USAMPLER2DARRAY:
			case USAMPLER2DMS:
			case USAMPLER2DMSARRAY:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLERBUFFER:
			case USAMPLERCUBE:
			case USAMPLERCUBEARRAY:
			case UVEC2:
			case UVEC3:
			case UVEC4:
			case VEC2:
			case VEC3:
			case VEC4:
			case VOID:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(632);
				type_specifier();
				setState(633);
				struct_declarator_list();
				setState(634);
				match(SEMICOLON);
				}
				break;
			case ATTRIBUTE:
			case BUFFER:
			case CENTROID:
			case COHERENT:
			case CONST:
			case FLAT:
			case HIGHP:
			case IN:
			case INOUT:
			case INVARIANT:
			case LAYOUT:
			case LOWP:
			case MEDIUMP:
			case NOPERSPECTIVE:
			case OUT:
			case PATCH:
			case PRECISE:
			case READONLY:
			case RESTRICT:
			case SAMPLE:
			case SHARED:
			case SMOOTH:
			case SUBROUTINE:
			case UNIFORM:
			case VARYING:
			case VOLATILE:
			case WRITEONLY:
				enterOuterAlt(_localctx, 2);
				{
				setState(636);
				type_qualifier();
				setState(637);
				type_specifier();
				setState(638);
				struct_declarator_list();
				setState(639);
				match(SEMICOLON);
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
	public static class Struct_declarator_listContext extends ParserRuleContext {
		public List<Struct_declaratorContext> struct_declarator() {
			return getRuleContexts(Struct_declaratorContext.class);
		}
		public Struct_declaratorContext struct_declarator(int i) {
			return getRuleContext(Struct_declaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public Struct_declarator_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declarator_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStruct_declarator_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStruct_declarator_list(this);
		}
	}

	public final Struct_declarator_listContext struct_declarator_list() throws RecognitionException {
		Struct_declarator_listContext _localctx = new Struct_declarator_listContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_struct_declarator_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(643);
			struct_declarator();
			setState(648);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(644);
				match(COMMA);
				setState(645);
				struct_declarator();
				}
				}
				setState(650);
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
	public static class Struct_declaratorContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public Array_specifierContext array_specifier() {
			return getRuleContext(Array_specifierContext.class,0);
		}
		public Struct_declaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_struct_declarator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStruct_declarator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStruct_declarator(this);
		}
	}

	public final Struct_declaratorContext struct_declarator() throws RecognitionException {
		Struct_declaratorContext _localctx = new Struct_declaratorContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_struct_declarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(651);
			match(IDENTIFIER);
			setState(653);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LEFT_BRACKET) {
				{
				setState(652);
				array_specifier();
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
	public static class InitializerContext extends ParserRuleContext {
		public Assignment_expressionContext assignment_expression() {
			return getRuleContext(Assignment_expressionContext.class,0);
		}
		public TerminalNode LEFT_BRACE() { return getToken(GLSLParser.LEFT_BRACE, 0); }
		public Initializer_listContext initializer_list() {
			return getRuleContext(Initializer_listContext.class,0);
		}
		public TerminalNode RIGHT_BRACE() { return getToken(GLSLParser.RIGHT_BRACE, 0); }
		public TerminalNode COMMA() { return getToken(GLSLParser.COMMA, 0); }
		public InitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInitializer(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInitializer(this);
		}
	}

	public final InitializerContext initializer() throws RecognitionException {
		InitializerContext _localctx = new InitializerContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_initializer);
		int _la;
		try {
			setState(663);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOMIC_UINT:
			case BOOL:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case DMAT2:
			case DMAT2X2:
			case DMAT2X3:
			case DMAT2X4:
			case DMAT3:
			case DMAT3X2:
			case DMAT3X3:
			case DMAT3X4:
			case DMAT4:
			case DMAT4X2:
			case DMAT4X3:
			case DMAT4X4:
			case DOUBLE:
			case DVEC2:
			case DVEC3:
			case DVEC4:
			case FALSE:
			case FLOAT:
			case IIMAGE1D:
			case IIMAGE1DARRAY:
			case IIMAGE2D:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE3D:
			case IIMAGEBUFFER:
			case IIMAGECUBE:
			case IIMAGECUBEARRAY:
			case IMAGE1D:
			case IMAGE1DARRAY:
			case IMAGE2D:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE3D:
			case IMAGEBUFFER:
			case IMAGECUBE:
			case IMAGECUBEARRAY:
			case INT:
			case ISAMPLER1D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2D:
			case ISAMPLER2DARRAY:
			case ISAMPLER2DMS:
			case ISAMPLER2DMSARRAY:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLERBUFFER:
			case ISAMPLERCUBE:
			case ISAMPLERCUBEARRAY:
			case IVEC2:
			case IVEC3:
			case IVEC4:
			case MAT2:
			case MAT2X2:
			case MAT2X3:
			case MAT2X4:
			case MAT3:
			case MAT3X2:
			case MAT3X3:
			case MAT3X4:
			case MAT4:
			case MAT4X2:
			case MAT4X3:
			case MAT4X4:
			case SAMPLER1D:
			case SAMPLER1DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER1DSHADOW:
			case SAMPLER2D:
			case SAMPLER2DARRAY:
			case SAMPLER2DARRAYSHADOW:
			case SAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case SAMPLER2DRECT:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER3D:
			case SAMPLERBUFFER:
			case SAMPLERCUBE:
			case SAMPLERCUBEARRAY:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBESHADOW:
			case STRUCT:
			case TRUE:
			case UIMAGE1D:
			case UIMAGE1DARRAY:
			case UIMAGE2D:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE3D:
			case UIMAGEBUFFER:
			case UIMAGECUBE:
			case UIMAGECUBEARRAY:
			case UINT:
			case USAMPLER1D:
			case USAMPLER1DARRAY:
			case USAMPLER2D:
			case USAMPLER2DARRAY:
			case USAMPLER2DMS:
			case USAMPLER2DMSARRAY:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLERBUFFER:
			case USAMPLERCUBE:
			case USAMPLERCUBEARRAY:
			case UVEC2:
			case UVEC3:
			case UVEC4:
			case VEC2:
			case VEC3:
			case VEC4:
			case VOID:
			case BANG:
			case DASH:
			case DEC_OP:
			case INC_OP:
			case LEFT_PAREN:
			case PLUS:
			case TILDE:
			case DOUBLECONSTANT:
			case FLOATCONSTANT:
			case INTCONSTANT:
			case UINTCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(655);
				assignment_expression();
				}
				break;
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(656);
				match(LEFT_BRACE);
				setState(657);
				initializer_list();
				setState(659);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(658);
					match(COMMA);
					}
				}

				setState(661);
				match(RIGHT_BRACE);
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
	public static class Initializer_listContext extends ParserRuleContext {
		public List<InitializerContext> initializer() {
			return getRuleContexts(InitializerContext.class);
		}
		public InitializerContext initializer(int i) {
			return getRuleContext(InitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(GLSLParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(GLSLParser.COMMA, i);
		}
		public Initializer_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_initializer_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterInitializer_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitInitializer_list(this);
		}
	}

	public final Initializer_listContext initializer_list() throws RecognitionException {
		Initializer_listContext _localctx = new Initializer_listContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_initializer_list);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(665);
			initializer();
			setState(670);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
			while ( _alt!=2 && _alt!= ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(666);
					match(COMMA);
					setState(667);
					initializer();
					}
					} 
				}
				setState(672);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,52,_ctx);
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
	public static class Declaration_statementContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Declaration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterDeclaration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitDeclaration_statement(this);
		}
	}

	public final Declaration_statementContext declaration_statement() throws RecognitionException {
		Declaration_statementContext _localctx = new Declaration_statementContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_declaration_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(673);
			declaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
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
		public Compound_statementContext compound_statement() {
			return getRuleContext(Compound_statementContext.class,0);
		}
		public Simple_statementContext simple_statement() {
			return getRuleContext(Simple_statementContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStatement(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_statement);
		try {
			setState(677);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(675);
				compound_statement();
				}
				break;
			case ATOMIC_UINT:
			case ATTRIBUTE:
			case BOOL:
			case BREAK:
			case BUFFER:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case CASE:
			case CENTROID:
			case COHERENT:
			case CONST:
			case CONTINUE:
			case DEFAULT:
			case DISCARD:
			case DMAT2:
			case DMAT2X2:
			case DMAT2X3:
			case DMAT2X4:
			case DMAT3:
			case DMAT3X2:
			case DMAT3X3:
			case DMAT3X4:
			case DMAT4:
			case DMAT4X2:
			case DMAT4X3:
			case DMAT4X4:
			case DO:
			case DOUBLE:
			case DVEC2:
			case DVEC3:
			case DVEC4:
			case FALSE:
			case FLAT:
			case FLOAT:
			case FOR:
			case HIGHP:
			case IF:
			case IIMAGE1D:
			case IIMAGE1DARRAY:
			case IIMAGE2D:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE3D:
			case IIMAGEBUFFER:
			case IIMAGECUBE:
			case IIMAGECUBEARRAY:
			case IMAGE1D:
			case IMAGE1DARRAY:
			case IMAGE2D:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE3D:
			case IMAGEBUFFER:
			case IMAGECUBE:
			case IMAGECUBEARRAY:
			case IN:
			case INOUT:
			case INT:
			case INVARIANT:
			case ISAMPLER1D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2D:
			case ISAMPLER2DARRAY:
			case ISAMPLER2DMS:
			case ISAMPLER2DMSARRAY:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLERBUFFER:
			case ISAMPLERCUBE:
			case ISAMPLERCUBEARRAY:
			case IVEC2:
			case IVEC3:
			case IVEC4:
			case LAYOUT:
			case LOWP:
			case MAT2:
			case MAT2X2:
			case MAT2X3:
			case MAT2X4:
			case MAT3:
			case MAT3X2:
			case MAT3X3:
			case MAT3X4:
			case MAT4:
			case MAT4X2:
			case MAT4X3:
			case MAT4X4:
			case MEDIUMP:
			case NOPERSPECTIVE:
			case OUT:
			case PATCH:
			case PRECISE:
			case PRECISION:
			case READONLY:
			case RESTRICT:
			case RETURN:
			case SAMPLE:
			case SAMPLER1D:
			case SAMPLER1DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER1DSHADOW:
			case SAMPLER2D:
			case SAMPLER2DARRAY:
			case SAMPLER2DARRAYSHADOW:
			case SAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case SAMPLER2DRECT:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER3D:
			case SAMPLERBUFFER:
			case SAMPLERCUBE:
			case SAMPLERCUBEARRAY:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBESHADOW:
			case SHARED:
			case SMOOTH:
			case STRUCT:
			case SUBROUTINE:
			case SWITCH:
			case TRUE:
			case UIMAGE1D:
			case UIMAGE1DARRAY:
			case UIMAGE2D:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE3D:
			case UIMAGEBUFFER:
			case UIMAGECUBE:
			case UIMAGECUBEARRAY:
			case UINT:
			case UNIFORM:
			case USAMPLER1D:
			case USAMPLER1DARRAY:
			case USAMPLER2D:
			case USAMPLER2DARRAY:
			case USAMPLER2DMS:
			case USAMPLER2DMSARRAY:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLERBUFFER:
			case USAMPLERCUBE:
			case USAMPLERCUBEARRAY:
			case UVEC2:
			case UVEC3:
			case UVEC4:
			case VARYING:
			case VEC2:
			case VEC3:
			case VEC4:
			case VOID:
			case VOLATILE:
			case WHILE:
			case WRITEONLY:
			case BANG:
			case DASH:
			case DEC_OP:
			case INC_OP:
			case LEFT_PAREN:
			case PLUS:
			case SEMICOLON:
			case TILDE:
			case DOUBLECONSTANT:
			case FLOATCONSTANT:
			case INTCONSTANT:
			case UINTCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(676);
				simple_statement();
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
	public static class Simple_statementContext extends ParserRuleContext {
		public Declaration_statementContext declaration_statement() {
			return getRuleContext(Declaration_statementContext.class,0);
		}
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Selection_statementContext selection_statement() {
			return getRuleContext(Selection_statementContext.class,0);
		}
		public Switch_statementContext switch_statement() {
			return getRuleContext(Switch_statementContext.class,0);
		}
		public Case_labelContext case_label() {
			return getRuleContext(Case_labelContext.class,0);
		}
		public Iteration_statementContext iteration_statement() {
			return getRuleContext(Iteration_statementContext.class,0);
		}
		public Jump_statementContext jump_statement() {
			return getRuleContext(Jump_statementContext.class,0);
		}
		public Simple_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simple_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSimple_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSimple_statement(this);
		}
	}

	public final Simple_statementContext simple_statement() throws RecognitionException {
		Simple_statementContext _localctx = new Simple_statementContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_simple_statement);
		try {
			setState(686);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,54,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(679);
				declaration_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(680);
				expression_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(681);
				selection_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(682);
				switch_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(683);
				case_label();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(684);
				iteration_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(685);
				jump_statement();
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
	public static class Compound_statementContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(GLSLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(GLSLParser.RIGHT_BRACE, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public Compound_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterCompound_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitCompound_statement(this);
		}
	}

	public final Compound_statementContext compound_statement() throws RecognitionException {
		Compound_statementContext _localctx = new Compound_statementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_compound_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(688);
			match(LEFT_BRACE);
			setState(690);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8589934594L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -9007199321841665L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599493205759L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 2171300179101648895L) != 0) || _la==IDENTIFIER) {
				{
				setState(689);
				statement_list();
				}
			}

			setState(692);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statement_no_new_scopeContext extends ParserRuleContext {
		public Compound_statement_no_new_scopeContext compound_statement_no_new_scope() {
			return getRuleContext(Compound_statement_no_new_scopeContext.class,0);
		}
		public Simple_statementContext simple_statement() {
			return getRuleContext(Simple_statementContext.class,0);
		}
		public Statement_no_new_scopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_no_new_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStatement_no_new_scope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStatement_no_new_scope(this);
		}
	}

	public final Statement_no_new_scopeContext statement_no_new_scope() throws RecognitionException {
		Statement_no_new_scopeContext _localctx = new Statement_no_new_scopeContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_statement_no_new_scope);
		try {
			setState(696);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LEFT_BRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(694);
				compound_statement_no_new_scope();
				}
				break;
			case ATOMIC_UINT:
			case ATTRIBUTE:
			case BOOL:
			case BREAK:
			case BUFFER:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case CASE:
			case CENTROID:
			case COHERENT:
			case CONST:
			case CONTINUE:
			case DEFAULT:
			case DISCARD:
			case DMAT2:
			case DMAT2X2:
			case DMAT2X3:
			case DMAT2X4:
			case DMAT3:
			case DMAT3X2:
			case DMAT3X3:
			case DMAT3X4:
			case DMAT4:
			case DMAT4X2:
			case DMAT4X3:
			case DMAT4X4:
			case DO:
			case DOUBLE:
			case DVEC2:
			case DVEC3:
			case DVEC4:
			case FALSE:
			case FLAT:
			case FLOAT:
			case FOR:
			case HIGHP:
			case IF:
			case IIMAGE1D:
			case IIMAGE1DARRAY:
			case IIMAGE2D:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE3D:
			case IIMAGEBUFFER:
			case IIMAGECUBE:
			case IIMAGECUBEARRAY:
			case IMAGE1D:
			case IMAGE1DARRAY:
			case IMAGE2D:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE3D:
			case IMAGEBUFFER:
			case IMAGECUBE:
			case IMAGECUBEARRAY:
			case IN:
			case INOUT:
			case INT:
			case INVARIANT:
			case ISAMPLER1D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2D:
			case ISAMPLER2DARRAY:
			case ISAMPLER2DMS:
			case ISAMPLER2DMSARRAY:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLERBUFFER:
			case ISAMPLERCUBE:
			case ISAMPLERCUBEARRAY:
			case IVEC2:
			case IVEC3:
			case IVEC4:
			case LAYOUT:
			case LOWP:
			case MAT2:
			case MAT2X2:
			case MAT2X3:
			case MAT2X4:
			case MAT3:
			case MAT3X2:
			case MAT3X3:
			case MAT3X4:
			case MAT4:
			case MAT4X2:
			case MAT4X3:
			case MAT4X4:
			case MEDIUMP:
			case NOPERSPECTIVE:
			case OUT:
			case PATCH:
			case PRECISE:
			case PRECISION:
			case READONLY:
			case RESTRICT:
			case RETURN:
			case SAMPLE:
			case SAMPLER1D:
			case SAMPLER1DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER1DSHADOW:
			case SAMPLER2D:
			case SAMPLER2DARRAY:
			case SAMPLER2DARRAYSHADOW:
			case SAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case SAMPLER2DRECT:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER3D:
			case SAMPLERBUFFER:
			case SAMPLERCUBE:
			case SAMPLERCUBEARRAY:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBESHADOW:
			case SHARED:
			case SMOOTH:
			case STRUCT:
			case SUBROUTINE:
			case SWITCH:
			case TRUE:
			case UIMAGE1D:
			case UIMAGE1DARRAY:
			case UIMAGE2D:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE3D:
			case UIMAGEBUFFER:
			case UIMAGECUBE:
			case UIMAGECUBEARRAY:
			case UINT:
			case UNIFORM:
			case USAMPLER1D:
			case USAMPLER1DARRAY:
			case USAMPLER2D:
			case USAMPLER2DARRAY:
			case USAMPLER2DMS:
			case USAMPLER2DMSARRAY:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLERBUFFER:
			case USAMPLERCUBE:
			case USAMPLERCUBEARRAY:
			case UVEC2:
			case UVEC3:
			case UVEC4:
			case VARYING:
			case VEC2:
			case VEC3:
			case VEC4:
			case VOID:
			case VOLATILE:
			case WHILE:
			case WRITEONLY:
			case BANG:
			case DASH:
			case DEC_OP:
			case INC_OP:
			case LEFT_PAREN:
			case PLUS:
			case SEMICOLON:
			case TILDE:
			case DOUBLECONSTANT:
			case FLOATCONSTANT:
			case INTCONSTANT:
			case UINTCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(695);
				simple_statement();
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
	public static class Compound_statement_no_new_scopeContext extends ParserRuleContext {
		public TerminalNode LEFT_BRACE() { return getToken(GLSLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(GLSLParser.RIGHT_BRACE, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public Compound_statement_no_new_scopeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compound_statement_no_new_scope; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterCompound_statement_no_new_scope(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitCompound_statement_no_new_scope(this);
		}
	}

	public final Compound_statement_no_new_scopeContext compound_statement_no_new_scope() throws RecognitionException {
		Compound_statement_no_new_scopeContext _localctx = new Compound_statement_no_new_scopeContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_compound_statement_no_new_scope);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(698);
			match(LEFT_BRACE);
			setState(700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8589934594L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -9007199321841665L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599493205759L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 2171300179101648895L) != 0) || _la==IDENTIFIER) {
				{
				setState(699);
				statement_list();
				}
			}

			setState(702);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Statement_listContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public Statement_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterStatement_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitStatement_list(this);
		}
	}

	public final Statement_listContext statement_list() throws RecognitionException {
		Statement_listContext _localctx = new Statement_listContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_statement_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(705); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(704);
				statement();
				}
				}
				setState(707); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -8589934594L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -9007199321841665L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599493205759L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 2171300179101648895L) != 0) || _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Expression_statementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Expression_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterExpression_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitExpression_statement(this);
		}
	}

	public final Expression_statementContext expression_statement() throws RecognitionException {
		Expression_statementContext _localctx = new Expression_statementContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_expression_statement);
		try {
			setState(713);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(709);
				match(SEMICOLON);
				}
				break;
			case ATOMIC_UINT:
			case BOOL:
			case BVEC2:
			case BVEC3:
			case BVEC4:
			case DMAT2:
			case DMAT2X2:
			case DMAT2X3:
			case DMAT2X4:
			case DMAT3:
			case DMAT3X2:
			case DMAT3X3:
			case DMAT3X4:
			case DMAT4:
			case DMAT4X2:
			case DMAT4X3:
			case DMAT4X4:
			case DOUBLE:
			case DVEC2:
			case DVEC3:
			case DVEC4:
			case FALSE:
			case FLOAT:
			case IIMAGE1D:
			case IIMAGE1DARRAY:
			case IIMAGE2D:
			case IIMAGE2DARRAY:
			case IIMAGE2DMS:
			case IIMAGE2DMSARRAY:
			case IIMAGE2DRECT:
			case IIMAGE3D:
			case IIMAGEBUFFER:
			case IIMAGECUBE:
			case IIMAGECUBEARRAY:
			case IMAGE1D:
			case IMAGE1DARRAY:
			case IMAGE2D:
			case IMAGE2DARRAY:
			case IMAGE2DMS:
			case IMAGE2DMSARRAY:
			case IMAGE2DRECT:
			case IMAGE3D:
			case IMAGEBUFFER:
			case IMAGECUBE:
			case IMAGECUBEARRAY:
			case INT:
			case ISAMPLER1D:
			case ISAMPLER1DARRAY:
			case ISAMPLER2D:
			case ISAMPLER2DARRAY:
			case ISAMPLER2DMS:
			case ISAMPLER2DMSARRAY:
			case ISAMPLER2DRECT:
			case ISAMPLER3D:
			case ISAMPLERBUFFER:
			case ISAMPLERCUBE:
			case ISAMPLERCUBEARRAY:
			case IVEC2:
			case IVEC3:
			case IVEC4:
			case MAT2:
			case MAT2X2:
			case MAT2X3:
			case MAT2X4:
			case MAT3:
			case MAT3X2:
			case MAT3X3:
			case MAT3X4:
			case MAT4:
			case MAT4X2:
			case MAT4X3:
			case MAT4X4:
			case SAMPLER1D:
			case SAMPLER1DARRAY:
			case SAMPLER1DARRAYSHADOW:
			case SAMPLER1DSHADOW:
			case SAMPLER2D:
			case SAMPLER2DARRAY:
			case SAMPLER2DARRAYSHADOW:
			case SAMPLER2DMS:
			case SAMPLER2DMSARRAY:
			case SAMPLER2DRECT:
			case SAMPLER2DRECTSHADOW:
			case SAMPLER2DSHADOW:
			case SAMPLER3D:
			case SAMPLERBUFFER:
			case SAMPLERCUBE:
			case SAMPLERCUBEARRAY:
			case SAMPLERCUBEARRAYSHADOW:
			case SAMPLERCUBESHADOW:
			case STRUCT:
			case TRUE:
			case UIMAGE1D:
			case UIMAGE1DARRAY:
			case UIMAGE2D:
			case UIMAGE2DARRAY:
			case UIMAGE2DMS:
			case UIMAGE2DMSARRAY:
			case UIMAGE2DRECT:
			case UIMAGE3D:
			case UIMAGEBUFFER:
			case UIMAGECUBE:
			case UIMAGECUBEARRAY:
			case UINT:
			case USAMPLER1D:
			case USAMPLER1DARRAY:
			case USAMPLER2D:
			case USAMPLER2DARRAY:
			case USAMPLER2DMS:
			case USAMPLER2DMSARRAY:
			case USAMPLER2DRECT:
			case USAMPLER3D:
			case USAMPLERBUFFER:
			case USAMPLERCUBE:
			case USAMPLERCUBEARRAY:
			case UVEC2:
			case UVEC3:
			case UVEC4:
			case VEC2:
			case VEC3:
			case VEC4:
			case VOID:
			case BANG:
			case DASH:
			case DEC_OP:
			case INC_OP:
			case LEFT_PAREN:
			case PLUS:
			case TILDE:
			case DOUBLECONSTANT:
			case FLOATCONSTANT:
			case INTCONSTANT:
			case UINTCONSTANT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(710);
				expression(0);
				setState(711);
				match(SEMICOLON);
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
	public static class Selection_statementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(GLSLParser.IF, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public Selection_rest_statementContext selection_rest_statement() {
			return getRuleContext(Selection_rest_statementContext.class,0);
		}
		public Selection_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSelection_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSelection_statement(this);
		}
	}

	public final Selection_statementContext selection_statement() throws RecognitionException {
		Selection_statementContext _localctx = new Selection_statementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_selection_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(715);
			match(IF);
			setState(716);
			match(LEFT_PAREN);
			setState(717);
			expression(0);
			setState(718);
			match(RIGHT_PAREN);
			setState(719);
			selection_rest_statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Selection_rest_statementContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(GLSLParser.ELSE, 0); }
		public Selection_rest_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_rest_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSelection_rest_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSelection_rest_statement(this);
		}
	}

	public final Selection_rest_statementContext selection_rest_statement() throws RecognitionException {
		Selection_rest_statementContext _localctx = new Selection_rest_statementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_selection_rest_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(721);
			statement();
			setState(724);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,60,_ctx) ) {
			case 1:
				{
				setState(722);
				match(ELSE);
				setState(723);
				statement();
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
	public static class ConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Fully_specified_typeContext fully_specified_type() {
			return getRuleContext(Fully_specified_typeContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(GLSLParser.IDENTIFIER, 0); }
		public TerminalNode EQUAL() { return getToken(GLSLParser.EQUAL, 0); }
		public InitializerContext initializer() {
			return getRuleContext(InitializerContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_condition);
		try {
			setState(732);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,61,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(726);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(727);
				fully_specified_type();
				setState(728);
				match(IDENTIFIER);
				setState(729);
				match(EQUAL);
				setState(730);
				initializer();
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
	public static class Switch_statementContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(GLSLParser.SWITCH, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public TerminalNode LEFT_BRACE() { return getToken(GLSLParser.LEFT_BRACE, 0); }
		public TerminalNode RIGHT_BRACE() { return getToken(GLSLParser.RIGHT_BRACE, 0); }
		public Statement_listContext statement_list() {
			return getRuleContext(Statement_listContext.class,0);
		}
		public Switch_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switch_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterSwitch_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitSwitch_statement(this);
		}
	}

	public final Switch_statementContext switch_statement() throws RecognitionException {
		Switch_statementContext _localctx = new Switch_statementContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_switch_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(734);
			match(SWITCH);
			setState(735);
			match(LEFT_PAREN);
			setState(736);
			expression(0);
			setState(737);
			match(RIGHT_PAREN);
			setState(738);
			match(LEFT_BRACE);
			setState(740);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -8589934594L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -9007199321841665L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599493205759L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 2171300179101648895L) != 0) || _la==IDENTIFIER) {
				{
				setState(739);
				statement_list();
				}
			}

			setState(742);
			match(RIGHT_BRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class Case_labelContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(GLSLParser.CASE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode COLON() { return getToken(GLSLParser.COLON, 0); }
		public TerminalNode DEFAULT() { return getToken(GLSLParser.DEFAULT, 0); }
		public Case_labelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_case_label; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterCase_label(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitCase_label(this);
		}
	}

	public final Case_labelContext case_label() throws RecognitionException {
		Case_labelContext _localctx = new Case_labelContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_case_label);
		try {
			setState(750);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(744);
				match(CASE);
				setState(745);
				expression(0);
				setState(746);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(748);
				match(DEFAULT);
				setState(749);
				match(COLON);
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
	public static class Iteration_statementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(GLSLParser.WHILE, 0); }
		public TerminalNode LEFT_PAREN() { return getToken(GLSLParser.LEFT_PAREN, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public TerminalNode RIGHT_PAREN() { return getToken(GLSLParser.RIGHT_PAREN, 0); }
		public Statement_no_new_scopeContext statement_no_new_scope() {
			return getRuleContext(Statement_no_new_scopeContext.class,0);
		}
		public TerminalNode DO() { return getToken(GLSLParser.DO, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public TerminalNode FOR() { return getToken(GLSLParser.FOR, 0); }
		public For_init_statementContext for_init_statement() {
			return getRuleContext(For_init_statementContext.class,0);
		}
		public For_rest_statementContext for_rest_statement() {
			return getRuleContext(For_rest_statementContext.class,0);
		}
		public Iteration_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterIteration_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitIteration_statement(this);
		}
	}

	public final Iteration_statementContext iteration_statement() throws RecognitionException {
		Iteration_statementContext _localctx = new Iteration_statementContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_iteration_statement);
		try {
			setState(773);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(752);
				match(WHILE);
				setState(753);
				match(LEFT_PAREN);
				setState(754);
				condition();
				setState(755);
				match(RIGHT_PAREN);
				setState(756);
				statement_no_new_scope();
				}
				break;
			case DO:
				enterOuterAlt(_localctx, 2);
				{
				setState(758);
				match(DO);
				setState(759);
				statement();
				setState(760);
				match(WHILE);
				setState(761);
				match(LEFT_PAREN);
				setState(762);
				expression(0);
				setState(763);
				match(RIGHT_PAREN);
				setState(764);
				match(SEMICOLON);
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 3);
				{
				setState(766);
				match(FOR);
				setState(767);
				match(LEFT_PAREN);
				setState(768);
				for_init_statement();
				setState(769);
				for_rest_statement();
				setState(770);
				match(RIGHT_PAREN);
				setState(771);
				statement_no_new_scope();
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
	public static class For_init_statementContext extends ParserRuleContext {
		public Expression_statementContext expression_statement() {
			return getRuleContext(Expression_statementContext.class,0);
		}
		public Declaration_statementContext declaration_statement() {
			return getRuleContext(Declaration_statementContext.class,0);
		}
		public For_init_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_init_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFor_init_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFor_init_statement(this);
		}
	}

	public final For_init_statementContext for_init_statement() throws RecognitionException {
		For_init_statementContext _localctx = new For_init_statementContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_for_init_statement);
		try {
			setState(777);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(775);
				expression_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(776);
				declaration_statement();
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
	public static class For_rest_statementContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public For_rest_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_rest_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFor_rest_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFor_rest_statement(this);
		}
	}

	public final For_rest_statementContext for_rest_statement() throws RecognitionException {
		For_rest_statementContext _localctx = new For_rest_statementContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_for_rest_statement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(780);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -696053195282L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & -11540474112237569L) != 0) || ((((_la - 128)) & ~0x3f) == 0 && ((1L << (_la - 128)) & 4503599493172991L) != 0) || ((((_la - 193)) & ~0x3f) == 0 && ((1L << (_la - 193)) & 2170737228074485247L) != 0) || _la==IDENTIFIER) {
				{
				setState(779);
				condition();
				}
			}

			setState(782);
			match(SEMICOLON);
			setState(784);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -6917529530286505755L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & -4501401023543297L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & -9222246411859393985L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & -8138003422817533829L) != 0)) {
				{
				setState(783);
				expression(0);
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
	public static class Jump_statementContext extends ParserRuleContext {
		public TerminalNode CONTINUE() { return getToken(GLSLParser.CONTINUE, 0); }
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public TerminalNode BREAK() { return getToken(GLSLParser.BREAK, 0); }
		public TerminalNode RETURN() { return getToken(GLSLParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DISCARD() { return getToken(GLSLParser.DISCARD, 0); }
		public Jump_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterJump_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitJump_statement(this);
		}
	}

	public final Jump_statementContext jump_statement() throws RecognitionException {
		Jump_statementContext _localctx = new Jump_statementContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_jump_statement);
		int _la;
		try {
			setState(797);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTINUE:
				enterOuterAlt(_localctx, 1);
				{
				setState(786);
				match(CONTINUE);
				setState(787);
				match(SEMICOLON);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(788);
				match(BREAK);
				setState(789);
				match(SEMICOLON);
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 3);
				{
				setState(790);
				match(RETURN);
				setState(792);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & -6917529530286505755L) != 0) || ((((_la - 66)) & ~0x3f) == 0 && ((1L << (_la - 66)) & -4501401023543297L) != 0) || ((((_la - 130)) & ~0x3f) == 0 && ((1L << (_la - 130)) & -9222246411859393985L) != 0) || ((((_la - 194)) & ~0x3f) == 0 && ((1L << (_la - 194)) & -8138003422817533829L) != 0)) {
					{
					setState(791);
					expression(0);
					}
				}

				setState(794);
				match(SEMICOLON);
				}
				break;
			case DISCARD:
				enterOuterAlt(_localctx, 4);
				{
				setState(795);
				match(DISCARD);
				setState(796);
				match(SEMICOLON);
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
	public static class External_declarationContext extends ParserRuleContext {
		public Function_definitionContext function_definition() {
			return getRuleContext(Function_definitionContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(GLSLParser.SEMICOLON, 0); }
		public External_declarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_external_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterExternal_declaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitExternal_declaration(this);
		}
	}

	public final External_declarationContext external_declaration() throws RecognitionException {
		External_declarationContext _localctx = new External_declarationContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_external_declaration);
		try {
			setState(802);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(799);
				function_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(800);
				declaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(801);
				match(SEMICOLON);
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
	public static class Function_definitionContext extends ParserRuleContext {
		public Function_prototypeContext function_prototype() {
			return getRuleContext(Function_prototypeContext.class,0);
		}
		public Compound_statement_no_new_scopeContext compound_statement_no_new_scope() {
			return getRuleContext(Compound_statement_no_new_scopeContext.class,0);
		}
		public Function_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_function_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).enterFunction_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GLSLParserListener ) ((GLSLParserListener)listener).exitFunction_definition(this);
		}
	}

	public final Function_definitionContext function_definition() throws RecognitionException {
		Function_definitionContext _localctx = new Function_definitionContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_function_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(804);
			function_prototype();
			setState(805);
			compound_statement_no_new_scope();
			}
		}
		catch (RecognitionException re) {
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
		case 3:
			return postfix_expression_sempred((Postfix_expressionContext)_localctx, predIndex);
		case 13:
			return binary_expression_sempred((Binary_expressionContext)_localctx, predIndex);
		case 14:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean postfix_expression_sempred(Postfix_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 6);
		case 1:
			return precpred(_ctx, 5);
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean binary_expression_sempred(Binary_expressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 11);
		case 6:
			return precpred(_ctx, 10);
		case 7:
			return precpred(_ctx, 9);
		case 8:
			return precpred(_ctx, 8);
		case 9:
			return precpred(_ctx, 7);
		case 10:
			return precpred(_ctx, 6);
		case 11:
			return precpred(_ctx, 5);
		case 12:
			return precpred(_ctx, 4);
		case 13:
			return precpred(_ctx, 3);
		case 14:
			return precpred(_ctx, 2);
		case 15:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 16:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0133\u0328\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
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
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0001\u0000"+
		"\u0005\u0000\u008c\b\u0000\n\u0000\f\u0000\u008f\t\u0000\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001"+
		"\u0002\u0001\u0002\u0003\u0002\u00a0\b\u0002\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00a7\b\u0003\u0001\u0003\u0001"+
		"\u0003\u0003\u0003\u00ab\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u00b5"+
		"\b\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0005\u0003\u00bf\b\u0003\n\u0003\f\u0003"+
		"\u00c2\t\u0003\u0001\u0004\u0001\u0004\u0003\u0004\u00c6\b\u0004\u0001"+
		"\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u00cd"+
		"\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0003\u0007\u00d3"+
		"\b\u0007\u0001\b\u0001\b\u0001\b\u0005\b\u00d8\b\b\n\b\f\b\u00db\t\b\u0001"+
		"\b\u0003\b\u00de\b\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0003\t\u00e8\b\t\u0001\n\u0001\n\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u00f1\b\u000b\u0001\f\u0001"+
		"\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001"+
		"\r\u0005\r\u0119\b\r\n\r\f\r\u011c\t\r\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0124\b\u000e\n\u000e"+
		"\f\u000e\u0127\t\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u0130\b\u000f\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010\u0003\u0010"+
		"\u0144\b\u0010\u0003\u0010\u0146\b\u0010\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0010\u0003\u0010\u014c\b\u0010\u0001\u0010\u0001\u0010\u0003"+
		"\u0010\u0150\b\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0005\u0011\u0155"+
		"\b\u0011\n\u0011\f\u0011\u0158\t\u0011\u0001\u0012\u0001\u0012\u0001\u0012"+
		"\u0001\u0012\u0003\u0012\u015e\b\u0012\u0001\u0012\u0001\u0012\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0005\u0013\u0165\b\u0013\n\u0013\f\u0013\u0168"+
		"\t\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u016d\b\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0003\u0015\u0172\b\u0015\u0001\u0015"+
		"\u0001\u0015\u0003\u0015\u0176\b\u0015\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u017d\b\u0017\n\u0017\f\u0017\u0180"+
		"\t\u0017\u0001\u0018\u0001\u0018\u0003\u0018\u0184\b\u0018\u0001\u0019"+
		"\u0001\u0019\u0003\u0019\u0188\b\u0019\u0001\u0019\u0001\u0019\u0003\u0019"+
		"\u018c\b\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a"+
		"\u0192\b\u001a\u0001\u001b\u0001\u001b\u0001\u001c\u0001\u001c\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0005\u001e\u01a0\b\u001e\n\u001e\f\u001e\u01a3\t\u001e\u0001"+
		"\u001f\u0001\u001f\u0001\u001f\u0003\u001f\u01a8\b\u001f\u0001\u001f\u0003"+
		"\u001f\u01ab\b\u001f\u0001 \u0001 \u0001!\u0004!\u01b0\b!\u000b!\f!\u01b1"+
		"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u01ba\b\"\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001"+
		"#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0001#\u0003"+
		"#\u01d0\b#\u0001#\u0001#\u0003#\u01d4\b#\u0001$\u0001$\u0001$\u0005$\u01d9"+
		"\b$\n$\f$\u01dc\t$\u0001%\u0001%\u0001&\u0001&\u0003&\u01e2\b&\u0001\'"+
		"\u0004\'\u01e5\b\'\u000b\'\f\'\u01e6\u0001(\u0001(\u0003(\u01eb\b(\u0001"+
		"(\u0001(\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001)\u0001"+
		")\u0001)\u0001)\u0003)\u0268\b)\u0001*\u0001*\u0001+\u0001+\u0003+\u026e"+
		"\b+\u0001+\u0001+\u0001+\u0001+\u0001,\u0004,\u0275\b,\u000b,\f,\u0276"+
		"\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0001-\u0003"+
		"-\u0282\b-\u0001.\u0001.\u0001.\u0005.\u0287\b.\n.\f.\u028a\t.\u0001/"+
		"\u0001/\u0003/\u028e\b/\u00010\u00010\u00010\u00010\u00030\u0294\b0\u0001"+
		"0\u00010\u00030\u0298\b0\u00011\u00011\u00011\u00051\u029d\b1\n1\f1\u02a0"+
		"\t1\u00012\u00012\u00013\u00013\u00033\u02a6\b3\u00014\u00014\u00014\u0001"+
		"4\u00014\u00014\u00014\u00034\u02af\b4\u00015\u00015\u00035\u02b3\b5\u0001"+
		"5\u00015\u00016\u00016\u00036\u02b9\b6\u00017\u00017\u00037\u02bd\b7\u0001"+
		"7\u00017\u00018\u00048\u02c2\b8\u000b8\f8\u02c3\u00019\u00019\u00019\u0001"+
		"9\u00039\u02ca\b9\u0001:\u0001:\u0001:\u0001:\u0001:\u0001:\u0001;\u0001"+
		";\u0001;\u0003;\u02d5\b;\u0001<\u0001<\u0001<\u0001<\u0001<\u0001<\u0003"+
		"<\u02dd\b<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001=\u0003=\u02e5\b=\u0001"+
		"=\u0001=\u0001>\u0001>\u0001>\u0001>\u0001>\u0001>\u0003>\u02ef\b>\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001?\u0001"+
		"?\u0003?\u0306\b?\u0001@\u0001@\u0003@\u030a\b@\u0001A\u0003A\u030d\b"+
		"A\u0001A\u0001A\u0003A\u0311\bA\u0001B\u0001B\u0001B\u0001B\u0001B\u0001"+
		"B\u0003B\u0319\bB\u0001B\u0001B\u0001B\u0003B\u031e\bB\u0001C\u0001C\u0001"+
		"C\u0003C\u0323\bC\u0001D\u0001D\u0001D\u0001D\u0000\u0003\u0006\u001a"+
		"\u001cE\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080"+
		"\u0082\u0084\u0086\u0088\u0000\t\u0004\u0000\u00d0\u00d0\u00d4\u00d4\u00ea"+
		"\u00ea\u00f6\u00f6\n\u0000\u00cc\u00cc\u00ce\u00ce\u00d6\u00d6\u00d9\u00d9"+
		"\u00de\u00de\u00e3\u00e4\u00e7\u00e7\u00ed\u00ed\u00f5\u00f5\u00f8\u00f8"+
		"\u0002\u0000\u00e9\u00e9\u00f3\u00f4\u0002\u0000\u00d4\u00d4\u00ea\u00ea"+
		"\u0002\u0000\u00e1\u00e1\u00f0\u00f0\u0003\u0000\u00da\u00da\u00dc\u00dd"+
		"\u00ec\u00ec\u0002\u0000\u00d8\u00d8\u00e5\u00e5\u0003\u0000##ll\u008a"+
		"\u008a\u0003\u0000&&^^kk\u03d5\u0000\u008d\u0001\u0000\u0000\u0000\u0002"+
		"\u0092\u0001\u0000\u0000\u0000\u0004\u009f\u0001\u0000\u0000\u0000\u0006"+
		"\u00aa\u0001\u0000\u0000\u0000\b\u00c5\u0001\u0000\u0000\u0000\n\u00c7"+
		"\u0001\u0000\u0000\u0000\f\u00c9\u0001\u0000\u0000\u0000\u000e\u00d2\u0001"+
		"\u0000\u0000\u0000\u0010\u00dd\u0001\u0000\u0000\u0000\u0012\u00e7\u0001"+
		"\u0000\u0000\u0000\u0014\u00e9\u0001\u0000\u0000\u0000\u0016\u00f0\u0001"+
		"\u0000\u0000\u0000\u0018\u00f2\u0001\u0000\u0000\u0000\u001a\u00f4\u0001"+
		"\u0000\u0000\u0000\u001c\u011d\u0001\u0000\u0000\u0000\u001e\u012f\u0001"+
		"\u0000\u0000\u0000 \u014f\u0001\u0000\u0000\u0000\"\u0151\u0001\u0000"+
		"\u0000\u0000$\u0159\u0001\u0000\u0000\u0000&\u0161\u0001\u0000\u0000\u0000"+
		"(\u0169\u0001\u0000\u0000\u0000*\u0175\u0001\u0000\u0000\u0000,\u0177"+
		"\u0001\u0000\u0000\u0000.\u0179\u0001\u0000\u0000\u00000\u0181\u0001\u0000"+
		"\u0000\u00002\u0185\u0001\u0000\u0000\u00004\u0191\u0001\u0000\u0000\u0000"+
		"6\u0193\u0001\u0000\u0000\u00008\u0195\u0001\u0000\u0000\u0000:\u0197"+
		"\u0001\u0000\u0000\u0000<\u019c\u0001\u0000\u0000\u0000>\u01aa\u0001\u0000"+
		"\u0000\u0000@\u01ac\u0001\u0000\u0000\u0000B\u01af\u0001\u0000\u0000\u0000"+
		"D\u01b9\u0001\u0000\u0000\u0000F\u01d3\u0001\u0000\u0000\u0000H\u01d5"+
		"\u0001\u0000\u0000\u0000J\u01dd\u0001\u0000\u0000\u0000L\u01df\u0001\u0000"+
		"\u0000\u0000N\u01e4\u0001\u0000\u0000\u0000P\u01e8\u0001\u0000\u0000\u0000"+
		"R\u0267\u0001\u0000\u0000\u0000T\u0269\u0001\u0000\u0000\u0000V\u026b"+
		"\u0001\u0000\u0000\u0000X\u0274\u0001\u0000\u0000\u0000Z\u0281\u0001\u0000"+
		"\u0000\u0000\\\u0283\u0001\u0000\u0000\u0000^\u028b\u0001\u0000\u0000"+
		"\u0000`\u0297\u0001\u0000\u0000\u0000b\u0299\u0001\u0000\u0000\u0000d"+
		"\u02a1\u0001\u0000\u0000\u0000f\u02a5\u0001\u0000\u0000\u0000h\u02ae\u0001"+
		"\u0000\u0000\u0000j\u02b0\u0001\u0000\u0000\u0000l\u02b8\u0001\u0000\u0000"+
		"\u0000n\u02ba\u0001\u0000\u0000\u0000p\u02c1\u0001\u0000\u0000\u0000r"+
		"\u02c9\u0001\u0000\u0000\u0000t\u02cb\u0001\u0000\u0000\u0000v\u02d1\u0001"+
		"\u0000\u0000\u0000x\u02dc\u0001\u0000\u0000\u0000z\u02de\u0001\u0000\u0000"+
		"\u0000|\u02ee\u0001\u0000\u0000\u0000~\u0305\u0001\u0000\u0000\u0000\u0080"+
		"\u0309\u0001\u0000\u0000\u0000\u0082\u030c\u0001\u0000\u0000\u0000\u0084"+
		"\u031d\u0001\u0000\u0000\u0000\u0086\u0322\u0001\u0000\u0000\u0000\u0088"+
		"\u0324\u0001\u0000\u0000\u0000\u008a\u008c\u0003\u0086C\u0000\u008b\u008a"+
		"\u0001\u0000\u0000\u0000\u008c\u008f\u0001\u0000\u0000\u0000\u008d\u008b"+
		"\u0001\u0000\u0000\u0000\u008d\u008e\u0001\u0000\u0000\u0000\u008e\u0090"+
		"\u0001\u0000\u0000\u0000\u008f\u008d\u0001\u0000\u0000\u0000\u0090\u0091"+
		"\u0005\u0000\u0000\u0001\u0091\u0001\u0001\u0000\u0000\u0000\u0092\u0093"+
		"\u0005\u0101\u0000\u0000\u0093\u0003\u0001\u0000\u0000\u0000\u0094\u00a0"+
		"\u0003\u0002\u0001\u0000\u0095\u00a0\u0005\u009b\u0000\u0000\u0096\u00a0"+
		"\u0005\"\u0000\u0000\u0097\u00a0\u0005\u00fc\u0000\u0000\u0098\u00a0\u0005"+
		"\u00fd\u0000\u0000\u0099\u00a0\u0005\u00fb\u0000\u0000\u009a\u00a0\u0005"+
		"\u00fa\u0000\u0000\u009b\u009c\u0005\u00e2\u0000\u0000\u009c\u009d\u0003"+
		"\u001c\u000e\u0000\u009d\u009e\u0005\u00f1\u0000\u0000\u009e\u00a0\u0001"+
		"\u0000\u0000\u0000\u009f\u0094\u0001\u0000\u0000\u0000\u009f\u0095\u0001"+
		"\u0000\u0000\u0000\u009f\u0096\u0001\u0000\u0000\u0000\u009f\u0097\u0001"+
		"\u0000\u0000\u0000\u009f\u0098\u0001\u0000\u0000\u0000\u009f\u0099\u0001"+
		"\u0000\u0000\u0000\u009f\u009a\u0001\u0000\u0000\u0000\u009f\u009b\u0001"+
		"\u0000\u0000\u0000\u00a0\u0005\u0001\u0000\u0000\u0000\u00a1\u00a2\u0006"+
		"\u0003\uffff\uffff\u0000\u00a2\u00ab\u0003\u0004\u0002\u0000\u00a3\u00a4"+
		"\u0003L&\u0000\u00a4\u00a6\u0005\u00e2\u0000\u0000\u00a5\u00a7\u0003\u0010"+
		"\b\u0000\u00a6\u00a5\u0001\u0000\u0000\u0000\u00a6\u00a7\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00a9\u0005\u00f1\u0000"+
		"\u0000\u00a9\u00ab\u0001\u0000\u0000\u0000\u00aa\u00a1\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a3\u0001\u0000\u0000\u0000\u00ab\u00c0\u0001\u0000\u0000"+
		"\u0000\u00ac\u00ad\n\u0006\u0000\u0000\u00ad\u00ae\u0005\u00e0\u0000\u0000"+
		"\u00ae\u00af\u0003\n\u0005\u0000\u00af\u00b0\u0005\u00ef\u0000\u0000\u00b0"+
		"\u00bf\u0001\u0000\u0000\u0000\u00b1\u00b2\n\u0005\u0000\u0000\u00b2\u00b4"+
		"\u0005\u00e2\u0000\u0000\u00b3\u00b5\u0003\u0010\b\u0000\u00b4\u00b3\u0001"+
		"\u0000\u0000\u0000\u00b4\u00b5\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001"+
		"\u0000\u0000\u0000\u00b6\u00bf\u0005\u00f1\u0000\u0000\u00b7\u00b8\n\u0003"+
		"\u0000\u0000\u00b8\u00b9\u0005\u00d7\u0000\u0000\u00b9\u00bf\u0003\b\u0004"+
		"\u0000\u00ba\u00bb\n\u0002\u0000\u0000\u00bb\u00bf\u0005\u00db\u0000\u0000"+
		"\u00bc\u00bd\n\u0001\u0000\u0000\u00bd\u00bf\u0005\u00d5\u0000\u0000\u00be"+
		"\u00ac\u0001\u0000\u0000\u0000\u00be\u00b1\u0001\u0000\u0000\u0000\u00be"+
		"\u00b7\u0001\u0000\u0000\u0000\u00be\u00ba\u0001\u0000\u0000\u0000\u00be"+
		"\u00bc\u0001\u0000\u0000\u0000\u00bf\u00c2\u0001\u0000\u0000\u0000\u00c0"+
		"\u00be\u0001\u0000\u0000\u0000\u00c0\u00c1\u0001\u0000\u0000\u0000\u00c1"+
		"\u0007\u0001\u0000\u0000\u0000\u00c2\u00c0\u0001\u0000\u0000\u0000\u00c3"+
		"\u00c6\u0003\u0002\u0001\u0000\u00c4\u00c6\u0003\f\u0006\u0000\u00c5\u00c3"+
		"\u0001\u0000\u0000\u0000\u00c5\u00c4\u0001\u0000\u0000\u0000\u00c6\t\u0001"+
		"\u0000\u0000\u0000\u00c7\u00c8\u0003\u001c\u000e\u0000\u00c8\u000b\u0001"+
		"\u0000\u0000\u0000\u00c9\u00ca\u0003\u000e\u0007\u0000\u00ca\u00cc\u0005"+
		"\u00e2\u0000\u0000\u00cb\u00cd\u0003\u0010\b\u0000\u00cc\u00cb\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\u0001\u0000\u0000\u0000\u00cd\u00ce\u0001\u0000"+
		"\u0000\u0000\u00ce\u00cf\u0005\u00f1\u0000\u0000\u00cf\r\u0001\u0000\u0000"+
		"\u0000\u00d0\u00d3\u0003L&\u0000\u00d1\u00d3\u0003\u0006\u0003\u0000\u00d2"+
		"\u00d0\u0001\u0000\u0000\u0000\u00d2\u00d1\u0001\u0000\u0000\u0000\u00d3"+
		"\u000f\u0001\u0000\u0000\u0000\u00d4\u00d9\u0003\u0016\u000b\u0000\u00d5"+
		"\u00d6\u0005\u00d3\u0000\u0000\u00d6\u00d8\u0003\u0016\u000b\u0000\u00d7"+
		"\u00d5\u0001\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9"+
		"\u00d7\u0001\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da"+
		"\u00de\u0001\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0005\u00c8\u0000\u0000\u00dd\u00d4\u0001\u0000\u0000\u0000\u00dd"+
		"\u00dc\u0001\u0000\u0000\u0000\u00de\u0011\u0001\u0000\u0000\u0000\u00df"+
		"\u00e8\u0003\u0006\u0003\u0000\u00e0\u00e1\u0005\u00db\u0000\u0000\u00e1"+
		"\u00e8\u0003\u0012\t\u0000\u00e2\u00e3\u0005\u00d5\u0000\u0000\u00e3\u00e8"+
		"\u0003\u0012\t\u0000\u00e4\u00e5\u0003\u0014\n\u0000\u00e5\u00e6\u0003"+
		"\u0012\t\u0000\u00e6\u00e8\u0001\u0000\u0000\u0000\u00e7\u00df\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e0\u0001\u0000\u0000\u0000\u00e7\u00e2\u0001\u0000"+
		"\u0000\u0000\u00e7\u00e4\u0001\u0000\u0000\u0000\u00e8\u0013\u0001\u0000"+
		"\u0000\u0000\u00e9\u00ea\u0007\u0000\u0000\u0000\u00ea\u0015\u0001\u0000"+
		"\u0000\u0000\u00eb\u00f1\u0003\u001e\u000f\u0000\u00ec\u00ed\u0003\u0012"+
		"\t\u0000\u00ed\u00ee\u0003\u0018\f\u0000\u00ee\u00ef\u0003\u0016\u000b"+
		"\u0000\u00ef\u00f1\u0001\u0000\u0000\u0000\u00f0\u00eb\u0001\u0000\u0000"+
		"\u0000\u00f0\u00ec\u0001\u0000\u0000\u0000\u00f1\u0017\u0001\u0000\u0000"+
		"\u0000\u00f2\u00f3\u0007\u0001\u0000\u0000\u00f3\u0019\u0001\u0000\u0000"+
		"\u0000\u00f4\u00f5\u0006\r\uffff\uffff\u0000\u00f5\u00f6\u0003\u0012\t"+
		"\u0000\u00f6\u011a\u0001\u0000\u0000\u0000\u00f7\u00f8\n\u000b\u0000\u0000"+
		"\u00f8\u00f9\u0007\u0002\u0000\u0000\u00f9\u0119\u0003\u001a\r\f\u00fa"+
		"\u00fb\n\n\u0000\u0000\u00fb\u00fc\u0007\u0003\u0000\u0000\u00fc\u0119"+
		"\u0003\u001a\r\u000b\u00fd\u00fe\n\t\u0000\u0000\u00fe\u00ff\u0007\u0004"+
		"\u0000\u0000\u00ff\u0119\u0003\u001a\r\n\u0100\u0101\n\b\u0000\u0000\u0101"+
		"\u0102\u0007\u0005\u0000\u0000\u0102\u0119\u0003\u001a\r\t\u0103\u0104"+
		"\n\u0007\u0000\u0000\u0104\u0105\u0007\u0006\u0000\u0000\u0105\u0119\u0003"+
		"\u001a\r\b\u0106\u0107\n\u0006\u0000\u0000\u0107\u0108\u0005\u00cd\u0000"+
		"\u0000\u0108\u0119\u0003\u001a\r\u0007\u0109\u010a\n\u0005\u0000\u0000"+
		"\u010a\u010b\u0005\u00d1\u0000\u0000\u010b\u0119\u0003\u001a\r\u0006\u010c"+
		"\u010d\n\u0004\u0000\u0000\u010d\u010e\u0005\u00f7\u0000\u0000\u010e\u0119"+
		"\u0003\u001a\r\u0005\u010f\u0110\n\u0003\u0000\u0000\u0110\u0111\u0005"+
		"\u00cf\u0000\u0000\u0111\u0119\u0003\u001a\r\u0004\u0112\u0113\n\u0002"+
		"\u0000\u0000\u0113\u0114\u0005\u00f9\u0000\u0000\u0114\u0119\u0003\u001a"+
		"\r\u0003\u0115\u0116\n\u0001\u0000\u0000\u0116\u0117\u0005\u00e8\u0000"+
		"\u0000\u0117\u0119\u0003\u001a\r\u0002\u0118\u00f7\u0001\u0000\u0000\u0000"+
		"\u0118\u00fa\u0001\u0000\u0000\u0000\u0118\u00fd\u0001\u0000\u0000\u0000"+
		"\u0118\u0100\u0001\u0000\u0000\u0000\u0118\u0103\u0001\u0000\u0000\u0000"+
		"\u0118\u0106\u0001\u0000\u0000\u0000\u0118\u0109\u0001\u0000\u0000\u0000"+
		"\u0118\u010c\u0001\u0000\u0000\u0000\u0118\u010f\u0001\u0000\u0000\u0000"+
		"\u0118\u0112\u0001\u0000\u0000\u0000\u0118\u0115\u0001\u0000\u0000\u0000"+
		"\u0119\u011c\u0001\u0000\u0000\u0000\u011a\u0118\u0001\u0000\u0000\u0000"+
		"\u011a\u011b\u0001\u0000\u0000\u0000\u011b\u001b\u0001\u0000\u0000\u0000"+
		"\u011c\u011a\u0001\u0000\u0000\u0000\u011d\u011e\u0006\u000e\uffff\uffff"+
		"\u0000\u011e\u011f\u0003\u0016\u000b\u0000\u011f\u0125\u0001\u0000\u0000"+
		"\u0000\u0120\u0121\n\u0001\u0000\u0000\u0121\u0122\u0005\u00d3\u0000\u0000"+
		"\u0122\u0124\u0003\u0016\u000b\u0000\u0123\u0120\u0001\u0000\u0000\u0000"+
		"\u0124\u0127\u0001\u0000\u0000\u0000\u0125\u0123\u0001\u0000\u0000\u0000"+
		"\u0125\u0126\u0001\u0000\u0000\u0000\u0126\u001d\u0001\u0000\u0000\u0000"+
		"\u0127\u0125\u0001\u0000\u0000\u0000\u0128\u0130\u0003\u001a\r\u0000\u0129"+
		"\u012a\u0003\u001a\r\u0000\u012a\u012b\u0005\u00eb\u0000\u0000\u012b\u012c"+
		"\u0003\u001c\u000e\u0000\u012c\u012d\u0005\u00d2\u0000\u0000\u012d\u012e"+
		"\u0003\u0016\u000b\u0000\u012e\u0130\u0001\u0000\u0000\u0000\u012f\u0128"+
		"\u0001\u0000\u0000\u0000\u012f\u0129\u0001\u0000\u0000\u0000\u0130\u001f"+
		"\u0001\u0000\u0000\u0000\u0131\u0132\u0003$\u0012\u0000\u0132\u0133\u0005"+
		"\u00f2\u0000\u0000\u0133\u0150\u0001\u0000\u0000\u0000\u0134\u0135\u0003"+
		".\u0017\u0000\u0135\u0136\u0005\u00f2\u0000\u0000\u0136\u0150\u0001\u0000"+
		"\u0000\u0000\u0137\u0138\u0005p\u0000\u0000\u0138\u0139\u0003T*\u0000"+
		"\u0139\u013a\u0003L&\u0000\u013a\u013b\u0005\u00f2\u0000\u0000\u013b\u0150"+
		"\u0001\u0000\u0000\u0000\u013c\u013d\u0003B!\u0000\u013d\u013e\u0005\u0101"+
		"\u0000\u0000\u013e\u013f\u0005\u00df\u0000\u0000\u013f\u0140\u0003X,\u0000"+
		"\u0140\u0145\u0005\u00ee\u0000\u0000\u0141\u0143\u0005\u0101\u0000\u0000"+
		"\u0142\u0144\u0003N\'\u0000\u0143\u0142\u0001\u0000\u0000\u0000\u0143"+
		"\u0144\u0001\u0000\u0000\u0000\u0144\u0146\u0001\u0000\u0000\u0000\u0145"+
		"\u0141\u0001\u0000\u0000\u0000\u0145\u0146\u0001\u0000\u0000\u0000\u0146"+
		"\u0147\u0001\u0000\u0000\u0000\u0147\u0148\u0005\u00f2\u0000\u0000\u0148"+
		"\u0150\u0001\u0000\u0000\u0000\u0149\u014b\u0003B!\u0000\u014a\u014c\u0003"+
		"\"\u0011\u0000\u014b\u014a\u0001\u0000\u0000\u0000\u014b\u014c\u0001\u0000"+
		"\u0000\u0000\u014c\u014d\u0001\u0000\u0000\u0000\u014d\u014e\u0005\u00f2"+
		"\u0000\u0000\u014e\u0150\u0001\u0000\u0000\u0000\u014f\u0131\u0001\u0000"+
		"\u0000\u0000\u014f\u0134\u0001\u0000\u0000\u0000\u014f\u0137\u0001\u0000"+
		"\u0000\u0000\u014f\u013c\u0001\u0000\u0000\u0000\u014f\u0149\u0001\u0000"+
		"\u0000\u0000\u0150!\u0001\u0000\u0000\u0000\u0151\u0156\u0005\u0101\u0000"+
		"\u0000\u0152\u0153\u0005\u00d3\u0000\u0000\u0153\u0155\u0005\u0101\u0000"+
		"\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0155\u0158\u0001\u0000\u0000"+
		"\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000\u0000"+
		"\u0000\u0157#\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000\u0000\u0000"+
		"\u0159\u015a\u00034\u001a\u0000\u015a\u015b\u0005\u0101\u0000\u0000\u015b"+
		"\u015d\u0005\u00e2\u0000\u0000\u015c\u015e\u0003&\u0013\u0000\u015d\u015c"+
		"\u0001\u0000\u0000\u0000\u015d\u015e\u0001\u0000\u0000\u0000\u015e\u015f"+
		"\u0001\u0000\u0000\u0000\u015f\u0160\u0005\u00f1\u0000\u0000\u0160%\u0001"+
		"\u0000\u0000\u0000\u0161\u0166\u0003*\u0015\u0000\u0162\u0163\u0005\u00d3"+
		"\u0000\u0000\u0163\u0165\u0003*\u0015\u0000\u0164\u0162\u0001\u0000\u0000"+
		"\u0000\u0165\u0168\u0001\u0000\u0000\u0000\u0166\u0164\u0001\u0000\u0000"+
		"\u0000\u0166\u0167\u0001\u0000\u0000\u0000\u0167\'\u0001\u0000\u0000\u0000"+
		"\u0168\u0166\u0001\u0000\u0000\u0000\u0169\u016a\u0003L&\u0000\u016a\u016c"+
		"\u0005\u0101\u0000\u0000\u016b\u016d\u0003N\'\u0000\u016c\u016b\u0001"+
		"\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000\u016d)\u0001\u0000"+
		"\u0000\u0000\u016e\u0171\u0003B!\u0000\u016f\u0172\u0003(\u0014\u0000"+
		"\u0170\u0172\u0003,\u0016\u0000\u0171\u016f\u0001\u0000\u0000\u0000\u0171"+
		"\u0170\u0001\u0000\u0000\u0000\u0172\u0176\u0001\u0000\u0000\u0000\u0173"+
		"\u0176\u0003(\u0014\u0000\u0174\u0176\u0003,\u0016\u0000\u0175\u016e\u0001"+
		"\u0000\u0000\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175\u0174\u0001"+
		"\u0000\u0000\u0000\u0176+\u0001\u0000\u0000\u0000\u0177\u0178\u0003L&"+
		"\u0000\u0178-\u0001\u0000\u0000\u0000\u0179\u017e\u00030\u0018\u0000\u017a"+
		"\u017b\u0005\u00d3\u0000\u0000\u017b\u017d\u00032\u0019\u0000\u017c\u017a"+
		"\u0001\u0000\u0000\u0000\u017d\u0180\u0001\u0000\u0000\u0000\u017e\u017c"+
		"\u0001\u0000\u0000\u0000\u017e\u017f\u0001\u0000\u0000\u0000\u017f/\u0001"+
		"\u0000\u0000\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0181\u0183\u0003"+
		"4\u001a\u0000\u0182\u0184\u00032\u0019\u0000\u0183\u0182\u0001\u0000\u0000"+
		"\u0000\u0183\u0184\u0001\u0000\u0000\u0000\u01841\u0001\u0000\u0000\u0000"+
		"\u0185\u0187\u0005\u0101\u0000\u0000\u0186\u0188\u0003N\'\u0000\u0187"+
		"\u0186\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188"+
		"\u018b\u0001\u0000\u0000\u0000\u0189\u018a\u0005\u00d9\u0000\u0000\u018a"+
		"\u018c\u0003`0\u0000\u018b\u0189\u0001\u0000\u0000\u0000\u018b\u018c\u0001"+
		"\u0000\u0000\u0000\u018c3\u0001\u0000\u0000\u0000\u018d\u0192\u0003L&"+
		"\u0000\u018e\u018f\u0003B!\u0000\u018f\u0190\u0003L&\u0000\u0190\u0192"+
		"\u0001\u0000\u0000\u0000\u0191\u018d\u0001\u0000\u0000\u0000\u0191\u018e"+
		"\u0001\u0000\u0000\u0000\u01925\u0001\u0000\u0000\u0000\u0193\u0194\u0005"+
		"A\u0000\u0000\u01947\u0001\u0000\u0000\u0000\u0195\u0196\u0007\u0007\u0000"+
		"\u0000\u01969\u0001\u0000\u0000\u0000\u0197\u0198\u0005]\u0000\u0000\u0198"+
		"\u0199\u0005\u00e2\u0000\u0000\u0199\u019a\u0003<\u001e\u0000\u019a\u019b"+
		"\u0005\u00f1\u0000\u0000\u019b;\u0001\u0000\u0000\u0000\u019c\u01a1\u0003"+
		">\u001f\u0000\u019d\u019e\u0005\u00d3\u0000\u0000\u019e\u01a0\u0003>\u001f"+
		"\u0000\u019f\u019d\u0001\u0000\u0000\u0000\u01a0\u01a3\u0001\u0000\u0000"+
		"\u0000\u01a1\u019f\u0001\u0000\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000"+
		"\u0000\u01a2=\u0001\u0000\u0000\u0000\u01a3\u01a1\u0001\u0000\u0000\u0000"+
		"\u01a4\u01a7\u0005\u0101\u0000\u0000\u01a5\u01a6\u0005\u00d9\u0000\u0000"+
		"\u01a6\u01a8\u0003\u001e\u000f\u0000\u01a7\u01a5\u0001\u0000\u0000\u0000"+
		"\u01a7\u01a8\u0001\u0000\u0000\u0000\u01a8\u01ab\u0001\u0000\u0000\u0000"+
		"\u01a9\u01ab\u0005\u0089\u0000\u0000\u01aa\u01a4\u0001\u0000\u0000\u0000"+
		"\u01aa\u01a9\u0001\u0000\u0000\u0000\u01ab?\u0001\u0000\u0000\u0000\u01ac"+
		"\u01ad\u0005o\u0000\u0000\u01adA\u0001\u0000\u0000\u0000\u01ae\u01b0\u0003"+
		"D\"\u0000\u01af\u01ae\u0001\u0000\u0000\u0000\u01b0\u01b1\u0001\u0000"+
		"\u0000\u0000\u01b1\u01af\u0001\u0000\u0000\u0000\u01b1\u01b2\u0001\u0000"+
		"\u0000\u0000\u01b2C\u0001\u0000\u0000\u0000\u01b3\u01ba\u0003F#\u0000"+
		"\u01b4\u01ba\u0003:\u001d\u0000\u01b5\u01ba\u0003T*\u0000\u01b6\u01ba"+
		"\u00038\u001c\u0000\u01b7\u01ba\u00036\u001b\u0000\u01b8\u01ba\u0003@"+
		" \u0000\u01b9\u01b3\u0001\u0000\u0000\u0000\u01b9\u01b4\u0001\u0000\u0000"+
		"\u0000\u01b9\u01b5\u0001\u0000\u0000\u0000\u01b9\u01b6\u0001\u0000\u0000"+
		"\u0000\u01b9\u01b7\u0001\u0000\u0000\u0000\u01b9\u01b8\u0001\u0000\u0000"+
		"\u0000\u01baE\u0001\u0000\u0000\u0000\u01bb\u01d4\u0005\f\u0000\u0000"+
		"\u01bc\u01d4\u0005>\u0000\u0000\u01bd\u01d4\u0005m\u0000\u0000\u01be\u01d4"+
		"\u0005?\u0000\u0000\u01bf\u01d4\u0005\n\u0000\u0000\u01c0\u01d4\u0005"+
		"n\u0000\u0000\u01c1\u01d4\u0005t\u0000\u0000\u01c2\u01d4\u0005\u00a8\u0000"+
		"\u0000\u01c3\u01d4\u0005\u0005\u0000\u0000\u01c4\u01d4\u0005\u0089\u0000"+
		"\u0000\u01c5\u01d4\u0005\u000b\u0000\u0000\u01c6\u01d4\u0005\u00c9\u0000"+
		"\u0000\u01c7\u01d4\u0005r\u0000\u0000\u01c8\u01d4\u0005q\u0000\u0000\u01c9"+
		"\u01d4\u0005\u00cb\u0000\u0000\u01ca\u01cf\u0005\u008e\u0000\u0000\u01cb"+
		"\u01cc\u0005\u00e2\u0000\u0000\u01cc\u01cd\u0003H$\u0000\u01cd\u01ce\u0005"+
		"\u00f1\u0000\u0000\u01ce\u01d0\u0001\u0000\u0000\u0000\u01cf\u01cb\u0001"+
		"\u0000\u0000\u0000\u01cf\u01d0\u0001\u0000\u0000\u0000\u01d0\u01d4\u0001"+
		"\u0000\u0000\u0000\u01d1\u01d4\u0005\u0002\u0000\u0000\u01d2\u01d4\u0005"+
		"\u00c4\u0000\u0000\u01d3\u01bb\u0001\u0000\u0000\u0000\u01d3\u01bc\u0001"+
		"\u0000\u0000\u0000\u01d3\u01bd\u0001\u0000\u0000\u0000\u01d3\u01be\u0001"+
		"\u0000\u0000\u0000\u01d3\u01bf\u0001\u0000\u0000\u0000\u01d3\u01c0\u0001"+
		"\u0000\u0000\u0000\u01d3\u01c1\u0001\u0000\u0000\u0000\u01d3\u01c2\u0001"+
		"\u0000\u0000\u0000\u01d3\u01c3\u0001\u0000\u0000\u0000\u01d3\u01c4\u0001"+
		"\u0000\u0000\u0000\u01d3\u01c5\u0001\u0000\u0000\u0000\u01d3\u01c6\u0001"+
		"\u0000\u0000\u0000\u01d3\u01c7\u0001\u0000\u0000\u0000\u01d3\u01c8\u0001"+
		"\u0000\u0000\u0000\u01d3\u01c9\u0001\u0000\u0000\u0000\u01d3\u01ca\u0001"+
		"\u0000\u0000\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d2\u0001"+
		"\u0000\u0000\u0000\u01d4G\u0001\u0000\u0000\u0000\u01d5\u01da\u0003J%"+
		"\u0000\u01d6\u01d7\u0005\u00d3\u0000\u0000\u01d7\u01d9\u0003J%\u0000\u01d8"+
		"\u01d6\u0001\u0000\u0000\u0000\u01d9\u01dc\u0001\u0000\u0000\u0000\u01da"+
		"\u01d8\u0001\u0000\u0000\u0000\u01da\u01db\u0001\u0000\u0000\u0000\u01db"+
		"I\u0001\u0000\u0000\u0000\u01dc\u01da\u0001\u0000\u0000\u0000\u01dd\u01de"+
		"\u0005\u0101\u0000\u0000\u01deK\u0001\u0000\u0000\u0000\u01df\u01e1\u0003"+
		"R)\u0000\u01e0\u01e2\u0003N\'\u0000\u01e1\u01e0\u0001\u0000\u0000\u0000"+
		"\u01e1\u01e2\u0001\u0000\u0000\u0000\u01e2M\u0001\u0000\u0000\u0000\u01e3"+
		"\u01e5\u0003P(\u0000\u01e4\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001"+
		"\u0000\u0000\u0000\u01e6\u01e4\u0001\u0000\u0000\u0000\u01e6\u01e7\u0001"+
		"\u0000\u0000\u0000\u01e7O\u0001\u0000\u0000\u0000\u01e8\u01ea\u0005\u00e0"+
		"\u0000\u0000\u01e9\u01eb\u0003\u001e\u000f\u0000\u01ea\u01e9\u0001\u0000"+
		"\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000\u01eb\u01ec\u0001\u0000"+
		"\u0000\u0000\u01ec\u01ed\u0005\u00ef\u0000\u0000\u01edQ\u0001\u0000\u0000"+
		"\u0000\u01ee\u0268\u0005\u00c8\u0000\u0000\u01ef\u0268\u0005$\u0000\u0000"+
		"\u01f0\u0268\u0005\u001d\u0000\u0000\u01f1\u0268\u0005@\u0000\u0000\u01f2"+
		"\u0268\u0005\u00a7\u0000\u0000\u01f3\u0268\u0005\u0003\u0000\u0000\u01f4"+
		"\u0268\u0005\u00c5\u0000\u0000\u01f5\u0268\u0005\u00c6\u0000\u0000\u01f6"+
		"\u0268\u0005\u00c7\u0000\u0000\u01f7\u0268\u0005\u001e\u0000\u0000\u01f8"+
		"\u0268\u0005\u001f\u0000\u0000\u01f9\u0268\u0005 \u0000\u0000\u01fa\u0268"+
		"\u0005\u0006\u0000\u0000\u01fb\u0268\u0005\u0007\u0000\u0000\u01fc\u0268"+
		"\u0005\b\u0000\u0000\u01fd\u0268\u0005Z\u0000\u0000\u01fe\u0268\u0005"+
		"[\u0000\u0000\u01ff\u0268\u0005\\\u0000\u0000\u0200\u0268\u0005\u00c1"+
		"\u0000\u0000\u0201\u0268\u0005\u00c2\u0000\u0000\u0202\u0268\u0005\u00c3"+
		"\u0000\u0000\u0203\u0268\u0005_\u0000\u0000\u0204\u0268\u0005c\u0000\u0000"+
		"\u0205\u0268\u0005g\u0000\u0000\u0206\u0268\u0005`\u0000\u0000\u0207\u0268"+
		"\u0005a\u0000\u0000\u0208\u0268\u0005b\u0000\u0000\u0209\u0268\u0005d"+
		"\u0000\u0000\u020a\u0268\u0005e\u0000\u0000\u020b\u0268\u0005f\u0000\u0000"+
		"\u020c\u0268\u0005h\u0000\u0000\u020d\u0268\u0005i\u0000\u0000\u020e\u0268"+
		"\u0005j\u0000\u0000\u020f\u0268\u0005\u0010\u0000\u0000\u0210\u0268\u0005"+
		"\u0014\u0000\u0000\u0211\u0268\u0005\u0018\u0000\u0000\u0212\u0268\u0005"+
		"\u0011\u0000\u0000\u0213\u0268\u0005\u0012\u0000\u0000\u0214\u0268\u0005"+
		"\u0013\u0000\u0000\u0215\u0268\u0005\u0015\u0000\u0000\u0216\u0268\u0005"+
		"\u0016\u0000\u0000\u0217\u0268\u0005\u0017\u0000\u0000\u0218\u0268\u0005"+
		"\u0019\u0000\u0000\u0219\u0268\u0005\u001a\u0000\u0000\u021a\u0268\u0005"+
		"\u001b\u0000\u0000\u021b\u0268\u0005\u0001\u0000\u0000\u021c\u0268\u0005"+
		"z\u0000\u0000\u021d\u0268\u0005\u0082\u0000\u0000\u021e\u0268\u0005\u0084"+
		"\u0000\u0000\u021f\u0268\u0005\u0081\u0000\u0000\u0220\u0268\u0005\u0087"+
		"\u0000\u0000\u0221\u0268\u0005{\u0000\u0000\u0222\u0268\u0005|\u0000\u0000"+
		"\u0223\u0268\u0005\u0085\u0000\u0000\u0224\u0268\u0005\u0086\u0000\u0000"+
		"\u0225\u0268\u0005D\u0000\u0000\u0226\u0268\u0005I\u0000\u0000\u0227\u0268"+
		"\u0005K\u0000\u0000\u0228\u0268\u0005E\u0000\u0000\u0229\u0268\u0005L"+
		"\u0000\u0000\u022a\u0268\u0005\u00ab\u0000\u0000\u022b\u0268\u0005\u00b0"+
		"\u0000\u0000\u022c\u0268\u0005\u00b2\u0000\u0000\u022d\u0268\u0005\u00ac"+
		"\u0000\u0000\u022e\u0268\u0005\u00b3\u0000\u0000\u022f\u0268\u0005v\u0000"+
		"\u0000\u0230\u0268\u0005y\u0000\u0000\u0231\u0268\u0005w\u0000\u0000\u0232"+
		"\u0268\u0005x\u0000\u0000\u0233\u0268\u0005B\u0000\u0000\u0234\u0268\u0005"+
		"C\u0000\u0000\u0235\u0268\u0005\u00a9\u0000\u0000\u0236\u0268\u0005\u00aa"+
		"\u0000\u0000\u0237\u0268\u0005\u007f\u0000\u0000\u0238\u0268\u0005\u0080"+
		"\u0000\u0000\u0239\u0268\u0005H\u0000\u0000\u023a\u0268\u0005\u00af\u0000"+
		"\u0000\u023b\u0268\u0005\u0083\u0000\u0000\u023c\u0268\u0005J\u0000\u0000"+
		"\u023d\u0268\u0005\u00b1\u0000\u0000\u023e\u0268\u0005}\u0000\u0000\u023f"+
		"\u0268\u0005F\u0000\u0000\u0240\u0268\u0005\u00ad\u0000\u0000\u0241\u0268"+
		"\u0005~\u0000\u0000\u0242\u0268\u0005G\u0000\u0000\u0243\u0268\u0005\u00ae"+
		"\u0000\u0000\u0244\u0268\u00055\u0000\u0000\u0245\u0268\u0005*\u0000\u0000"+
		"\u0246\u0268\u0005\u009e\u0000\u0000\u0247\u0268\u0005:\u0000\u0000\u0248"+
		"\u0268\u0005/\u0000\u0000\u0249\u0268\u0005\u00a3\u0000\u0000\u024a\u0268"+
		"\u0005<\u0000\u0000\u024b\u0268\u00051\u0000\u0000\u024c\u0268\u0005\u00a5"+
		"\u0000\u0000\u024d\u0268\u0005;\u0000\u0000\u024e\u0268\u00050\u0000\u0000"+
		"\u024f\u0268\u0005\u00a4\u0000\u0000\u0250\u0268\u00053\u0000\u0000\u0251"+
		"\u0268\u0005(\u0000\u0000\u0252\u0268\u0005\u009c\u0000\u0000\u0253\u0268"+
		"\u00054\u0000\u0000\u0254\u0268\u0005)\u0000\u0000\u0255\u0268\u0005\u009d"+
		"\u0000\u0000\u0256\u0268\u00059\u0000\u0000\u0257\u0268\u0005.\u0000\u0000"+
		"\u0258\u0268\u0005\u00a2\u0000\u0000\u0259\u0268\u00056\u0000\u0000\u025a"+
		"\u0268\u0005+\u0000\u0000\u025b\u0268\u0005\u009f\u0000\u0000\u025c\u0268"+
		"\u0005=\u0000\u0000\u025d\u0268\u00052\u0000\u0000\u025e\u0268\u0005\u00a6"+
		"\u0000\u0000\u025f\u0268\u00057\u0000\u0000\u0260\u0268\u0005,\u0000\u0000"+
		"\u0261\u0268\u0005\u00a0\u0000\u0000\u0262\u0268\u00058\u0000\u0000\u0263"+
		"\u0268\u0005-\u0000\u0000\u0264\u0268\u0005\u00a1\u0000\u0000\u0265\u0268"+
		"\u0003V+\u0000\u0266\u0268\u0003J%\u0000\u0267\u01ee\u0001\u0000\u0000"+
		"\u0000\u0267\u01ef\u0001\u0000\u0000\u0000\u0267\u01f0\u0001\u0000\u0000"+
		"\u0000\u0267\u01f1\u0001\u0000\u0000\u0000\u0267\u01f2\u0001\u0000\u0000"+
		"\u0000\u0267\u01f3\u0001\u0000\u0000\u0000\u0267\u01f4\u0001\u0000\u0000"+
		"\u0000\u0267\u01f5\u0001\u0000\u0000\u0000\u0267\u01f6\u0001\u0000\u0000"+
		"\u0000\u0267\u01f7\u0001\u0000\u0000\u0000\u0267\u01f8\u0001\u0000\u0000"+
		"\u0000\u0267\u01f9\u0001\u0000\u0000\u0000\u0267\u01fa\u0001\u0000\u0000"+
		"\u0000\u0267\u01fb\u0001\u0000\u0000\u0000\u0267\u01fc\u0001\u0000\u0000"+
		"\u0000\u0267\u01fd\u0001\u0000\u0000\u0000\u0267\u01fe\u0001\u0000\u0000"+
		"\u0000\u0267\u01ff\u0001\u0000\u0000\u0000\u0267\u0200\u0001\u0000\u0000"+
		"\u0000\u0267\u0201\u0001\u0000\u0000\u0000\u0267\u0202\u0001\u0000\u0000"+
		"\u0000\u0267\u0203\u0001\u0000\u0000\u0000\u0267\u0204\u0001\u0000\u0000"+
		"\u0000\u0267\u0205\u0001\u0000\u0000\u0000\u0267\u0206\u0001\u0000\u0000"+
		"\u0000\u0267\u0207\u0001\u0000\u0000\u0000\u0267\u0208\u0001\u0000\u0000"+
		"\u0000\u0267\u0209\u0001\u0000\u0000\u0000\u0267\u020a\u0001\u0000\u0000"+
		"\u0000\u0267\u020b\u0001\u0000\u0000\u0000\u0267\u020c\u0001\u0000\u0000"+
		"\u0000\u0267\u020d\u0001\u0000\u0000\u0000\u0267\u020e\u0001\u0000\u0000"+
		"\u0000\u0267\u020f\u0001\u0000\u0000\u0000\u0267\u0210\u0001\u0000\u0000"+
		"\u0000\u0267\u0211\u0001\u0000\u0000\u0000\u0267\u0212\u0001\u0000\u0000"+
		"\u0000\u0267\u0213\u0001\u0000\u0000\u0000\u0267\u0214\u0001\u0000\u0000"+
		"\u0000\u0267\u0215\u0001\u0000\u0000\u0000\u0267\u0216\u0001\u0000\u0000"+
		"\u0000\u0267\u0217\u0001\u0000\u0000\u0000\u0267\u0218\u0001\u0000\u0000"+
		"\u0000\u0267\u0219\u0001\u0000\u0000\u0000\u0267\u021a\u0001\u0000\u0000"+
		"\u0000\u0267\u021b\u0001\u0000\u0000\u0000\u0267\u021c\u0001\u0000\u0000"+
		"\u0000\u0267\u021d\u0001\u0000\u0000\u0000\u0267\u021e\u0001\u0000\u0000"+
		"\u0000\u0267\u021f\u0001\u0000\u0000\u0000\u0267\u0220\u0001\u0000\u0000"+
		"\u0000\u0267\u0221\u0001\u0000\u0000\u0000\u0267\u0222\u0001\u0000\u0000"+
		"\u0000\u0267\u0223\u0001\u0000\u0000\u0000\u0267\u0224\u0001\u0000\u0000"+
		"\u0000\u0267\u0225\u0001\u0000\u0000\u0000\u0267\u0226\u0001\u0000\u0000"+
		"\u0000\u0267\u0227\u0001\u0000\u0000\u0000\u0267\u0228\u0001\u0000\u0000"+
		"\u0000\u0267\u0229\u0001\u0000\u0000\u0000\u0267\u022a\u0001\u0000\u0000"+
		"\u0000\u0267\u022b\u0001\u0000\u0000\u0000\u0267\u022c\u0001\u0000\u0000"+
		"\u0000\u0267\u022d\u0001\u0000\u0000\u0000\u0267\u022e\u0001\u0000\u0000"+
		"\u0000\u0267\u022f\u0001\u0000\u0000\u0000\u0267\u0230\u0001\u0000\u0000"+
		"\u0000\u0267\u0231\u0001\u0000\u0000\u0000\u0267\u0232\u0001\u0000\u0000"+
		"\u0000\u0267\u0233\u0001\u0000\u0000\u0000\u0267\u0234\u0001\u0000\u0000"+
		"\u0000\u0267\u0235\u0001\u0000\u0000\u0000\u0267\u0236\u0001\u0000\u0000"+
		"\u0000\u0267\u0237\u0001\u0000\u0000\u0000\u0267\u0238\u0001\u0000\u0000"+
		"\u0000\u0267\u0239\u0001\u0000\u0000\u0000\u0267\u023a\u0001\u0000\u0000"+
		"\u0000\u0267\u023b\u0001\u0000\u0000\u0000\u0267\u023c\u0001\u0000\u0000"+
		"\u0000\u0267\u023d\u0001\u0000\u0000\u0000\u0267\u023e\u0001\u0000\u0000"+
		"\u0000\u0267\u023f\u0001\u0000\u0000\u0000\u0267\u0240\u0001\u0000\u0000"+
		"\u0000\u0267\u0241\u0001\u0000\u0000\u0000\u0267\u0242\u0001\u0000\u0000"+
		"\u0000\u0267\u0243\u0001\u0000\u0000\u0000\u0267\u0244\u0001\u0000\u0000"+
		"\u0000\u0267\u0245\u0001\u0000\u0000\u0000\u0267\u0246\u0001\u0000\u0000"+
		"\u0000\u0267\u0247\u0001\u0000\u0000\u0000\u0267\u0248\u0001\u0000\u0000"+
		"\u0000\u0267\u0249\u0001\u0000\u0000\u0000\u0267\u024a\u0001\u0000\u0000"+
		"\u0000\u0267\u024b\u0001\u0000\u0000\u0000\u0267\u024c\u0001\u0000\u0000"+
		"\u0000\u0267\u024d\u0001\u0000\u0000\u0000\u0267\u024e\u0001\u0000\u0000"+
		"\u0000\u0267\u024f\u0001\u0000\u0000\u0000\u0267\u0250\u0001\u0000\u0000"+
		"\u0000\u0267\u0251\u0001\u0000\u0000\u0000\u0267\u0252\u0001\u0000\u0000"+
		"\u0000\u0267\u0253\u0001\u0000\u0000\u0000\u0267\u0254\u0001\u0000\u0000"+
		"\u0000\u0267\u0255\u0001\u0000\u0000\u0000\u0267\u0256\u0001\u0000\u0000"+
		"\u0000\u0267\u0257\u0001\u0000\u0000\u0000\u0267\u0258\u0001\u0000\u0000"+
		"\u0000\u0267\u0259\u0001\u0000\u0000\u0000\u0267\u025a\u0001\u0000\u0000"+
		"\u0000\u0267\u025b\u0001\u0000\u0000\u0000\u0267\u025c\u0001\u0000\u0000"+
		"\u0000\u0267\u025d\u0001\u0000\u0000\u0000\u0267\u025e\u0001\u0000\u0000"+
		"\u0000\u0267\u025f\u0001\u0000\u0000\u0000\u0267\u0260\u0001\u0000\u0000"+
		"\u0000\u0267\u0261\u0001\u0000\u0000\u0000\u0267\u0262\u0001\u0000\u0000"+
		"\u0000\u0267\u0263\u0001\u0000\u0000\u0000\u0267\u0264\u0001\u0000\u0000"+
		"\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0267\u0266\u0001\u0000\u0000"+
		"\u0000\u0268S\u0001\u0000\u0000\u0000\u0269\u026a\u0007\b\u0000\u0000"+
		"\u026aU\u0001\u0000\u0000\u0000\u026b\u026d\u0005\u008b\u0000\u0000\u026c"+
		"\u026e\u0005\u0101\u0000\u0000\u026d\u026c\u0001\u0000\u0000\u0000\u026d"+
		"\u026e\u0001\u0000\u0000\u0000\u026e\u026f\u0001\u0000\u0000\u0000\u026f"+
		"\u0270\u0005\u00df\u0000\u0000\u0270\u0271\u0003X,\u0000\u0271\u0272\u0005"+
		"\u00ee\u0000\u0000\u0272W\u0001\u0000\u0000\u0000\u0273\u0275\u0003Z-"+
		"\u0000\u0274\u0273\u0001\u0000\u0000\u0000\u0275\u0276\u0001\u0000\u0000"+
		"\u0000\u0276\u0274\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000\u0000"+
		"\u0000\u0277Y\u0001\u0000\u0000\u0000\u0278\u0279\u0003L&\u0000\u0279"+
		"\u027a\u0003\\.\u0000\u027a\u027b\u0005\u00f2\u0000\u0000\u027b\u0282"+
		"\u0001\u0000\u0000\u0000\u027c\u027d\u0003B!\u0000\u027d\u027e\u0003L"+
		"&\u0000\u027e\u027f\u0003\\.\u0000\u027f\u0280\u0005\u00f2\u0000\u0000"+
		"\u0280\u0282\u0001\u0000\u0000\u0000\u0281\u0278\u0001\u0000\u0000\u0000"+
		"\u0281\u027c\u0001\u0000\u0000\u0000\u0282[\u0001\u0000\u0000\u0000\u0283"+
		"\u0288\u0003^/\u0000\u0284\u0285\u0005\u00d3\u0000\u0000\u0285\u0287\u0003"+
		"^/\u0000\u0286\u0284\u0001\u0000\u0000\u0000\u0287\u028a\u0001\u0000\u0000"+
		"\u0000\u0288\u0286\u0001\u0000\u0000\u0000\u0288\u0289\u0001\u0000\u0000"+
		"\u0000\u0289]\u0001\u0000\u0000\u0000\u028a\u0288\u0001\u0000\u0000\u0000"+
		"\u028b\u028d\u0005\u0101\u0000\u0000\u028c\u028e\u0003N\'\u0000\u028d"+
		"\u028c\u0001\u0000\u0000\u0000\u028d\u028e\u0001\u0000\u0000\u0000\u028e"+
		"_\u0001\u0000\u0000\u0000\u028f\u0298\u0003\u0016\u000b\u0000\u0290\u0291"+
		"\u0005\u00df\u0000\u0000\u0291\u0293\u0003b1\u0000\u0292\u0294\u0005\u00d3"+
		"\u0000\u0000\u0293\u0292\u0001\u0000\u0000\u0000\u0293\u0294\u0001\u0000"+
		"\u0000\u0000\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0296\u0005\u00ee"+
		"\u0000\u0000\u0296\u0298\u0001\u0000\u0000\u0000\u0297\u028f\u0001\u0000"+
		"\u0000\u0000\u0297\u0290\u0001\u0000\u0000\u0000\u0298a\u0001\u0000\u0000"+
		"\u0000\u0299\u029e\u0003`0\u0000\u029a\u029b\u0005\u00d3\u0000\u0000\u029b"+
		"\u029d\u0003`0\u0000\u029c\u029a\u0001\u0000\u0000\u0000\u029d\u02a0\u0001"+
		"\u0000\u0000\u0000\u029e\u029c\u0001\u0000\u0000\u0000\u029e\u029f\u0001"+
		"\u0000\u0000\u0000\u029fc\u0001\u0000\u0000\u0000\u02a0\u029e\u0001\u0000"+
		"\u0000\u0000\u02a1\u02a2\u0003 \u0010\u0000\u02a2e\u0001\u0000\u0000\u0000"+
		"\u02a3\u02a6\u0003j5\u0000\u02a4\u02a6\u0003h4\u0000\u02a5\u02a3\u0001"+
		"\u0000\u0000\u0000\u02a5\u02a4\u0001\u0000\u0000\u0000\u02a6g\u0001\u0000"+
		"\u0000\u0000\u02a7\u02af\u0003d2\u0000\u02a8\u02af\u0003r9\u0000\u02a9"+
		"\u02af\u0003t:\u0000\u02aa\u02af\u0003z=\u0000\u02ab\u02af\u0003|>\u0000"+
		"\u02ac\u02af\u0003~?\u0000\u02ad\u02af\u0003\u0084B\u0000\u02ae\u02a7"+
		"\u0001\u0000\u0000\u0000\u02ae\u02a8\u0001\u0000\u0000\u0000\u02ae\u02a9"+
		"\u0001\u0000\u0000\u0000\u02ae\u02aa\u0001\u0000\u0000\u0000\u02ae\u02ab"+
		"\u0001\u0000\u0000\u0000\u02ae\u02ac\u0001\u0000\u0000\u0000\u02ae\u02ad"+
		"\u0001\u0000\u0000\u0000\u02afi\u0001\u0000\u0000\u0000\u02b0\u02b2\u0005"+
		"\u00df\u0000\u0000\u02b1\u02b3\u0003p8\u0000\u02b2\u02b1\u0001\u0000\u0000"+
		"\u0000\u02b2\u02b3\u0001\u0000\u0000\u0000\u02b3\u02b4\u0001\u0000\u0000"+
		"\u0000\u02b4\u02b5\u0005\u00ee\u0000\u0000\u02b5k\u0001\u0000\u0000\u0000"+
		"\u02b6\u02b9\u0003n7\u0000\u02b7\u02b9\u0003h4\u0000\u02b8\u02b6\u0001"+
		"\u0000\u0000\u0000\u02b8\u02b7\u0001\u0000\u0000\u0000\u02b9m\u0001\u0000"+
		"\u0000\u0000\u02ba\u02bc\u0005\u00df\u0000\u0000\u02bb\u02bd\u0003p8\u0000"+
		"\u02bc\u02bb\u0001\u0000\u0000\u0000\u02bc\u02bd\u0001\u0000\u0000\u0000"+
		"\u02bd\u02be\u0001\u0000\u0000\u0000\u02be\u02bf\u0005\u00ee\u0000\u0000"+
		"\u02bfo\u0001\u0000\u0000\u0000\u02c0\u02c2\u0003f3\u0000\u02c1\u02c0"+
		"\u0001\u0000\u0000\u0000\u02c2\u02c3\u0001\u0000\u0000\u0000\u02c3\u02c1"+
		"\u0001\u0000\u0000\u0000\u02c3\u02c4\u0001\u0000\u0000\u0000\u02c4q\u0001"+
		"\u0000\u0000\u0000\u02c5\u02ca\u0005\u00f2\u0000\u0000\u02c6\u02c7\u0003"+
		"\u001c\u000e\u0000\u02c7\u02c8\u0005\u00f2\u0000\u0000\u02c8\u02ca\u0001"+
		"\u0000\u0000\u0000\u02c9\u02c5\u0001\u0000\u0000\u0000\u02c9\u02c6\u0001"+
		"\u0000\u0000\u0000\u02cas\u0001\u0000\u0000\u0000\u02cb\u02cc\u0005\'"+
		"\u0000\u0000\u02cc\u02cd\u0005\u00e2\u0000\u0000\u02cd\u02ce\u0003\u001c"+
		"\u000e\u0000\u02ce\u02cf\u0005\u00f1\u0000\u0000\u02cf\u02d0\u0003v;\u0000"+
		"\u02d0u\u0001\u0000\u0000\u0000\u02d1\u02d4\u0003f3\u0000\u02d2\u02d3"+
		"\u0005!\u0000\u0000\u02d3\u02d5\u0003f3\u0000\u02d4\u02d2\u0001\u0000"+
		"\u0000\u0000\u02d4\u02d5\u0001\u0000\u0000\u0000\u02d5w\u0001\u0000\u0000"+
		"\u0000\u02d6\u02dd\u0003\u001c\u000e\u0000\u02d7\u02d8\u00034\u001a\u0000"+
		"\u02d8\u02d9\u0005\u0101\u0000\u0000\u02d9\u02da\u0005\u00d9\u0000\u0000"+
		"\u02da\u02db\u0003`0\u0000\u02db\u02dd\u0001\u0000\u0000\u0000\u02dc\u02d6"+
		"\u0001\u0000\u0000\u0000\u02dc\u02d7\u0001\u0000\u0000\u0000\u02ddy\u0001"+
		"\u0000\u0000\u0000\u02de\u02df\u0005\u008f\u0000\u0000\u02df\u02e0\u0005"+
		"\u00e2\u0000\u0000\u02e0\u02e1\u0003\u001c\u000e\u0000\u02e1\u02e2\u0005"+
		"\u00f1\u0000\u0000\u02e2\u02e4\u0005\u00df\u0000\u0000\u02e3\u02e5\u0003"+
		"p8\u0000\u02e4\u02e3\u0001\u0000\u0000\u0000\u02e4\u02e5\u0001\u0000\u0000"+
		"\u0000\u02e5\u02e6\u0001\u0000\u0000\u0000\u02e6\u02e7\u0005\u00ee\u0000"+
		"\u0000\u02e7{\u0001\u0000\u0000\u0000\u02e8\u02e9\u0005\t\u0000\u0000"+
		"\u02e9\u02ea\u0003\u001c\u000e\u0000\u02ea\u02eb\u0005\u00d2\u0000\u0000"+
		"\u02eb\u02ef\u0001\u0000\u0000\u0000\u02ec\u02ed\u0005\u000e\u0000\u0000"+
		"\u02ed\u02ef\u0005\u00d2\u0000\u0000\u02ee\u02e8\u0001\u0000\u0000\u0000"+
		"\u02ee\u02ec\u0001\u0000\u0000\u0000\u02ef}\u0001\u0000\u0000\u0000\u02f0"+
		"\u02f1\u0005\u00ca\u0000\u0000\u02f1\u02f2\u0005\u00e2\u0000\u0000\u02f2"+
		"\u02f3\u0003x<\u0000\u02f3\u02f4\u0005\u00f1\u0000\u0000\u02f4\u02f5\u0003"+
		"l6\u0000\u02f5\u0306\u0001\u0000\u0000\u0000\u02f6\u02f7\u0005\u001c\u0000"+
		"\u0000\u02f7\u02f8\u0003f3\u0000\u02f8\u02f9\u0005\u00ca\u0000\u0000\u02f9"+
		"\u02fa\u0005\u00e2\u0000\u0000\u02fa\u02fb\u0003\u001c\u000e\u0000\u02fb"+
		"\u02fc\u0005\u00f1\u0000\u0000\u02fc\u02fd\u0005\u00f2\u0000\u0000\u02fd"+
		"\u0306\u0001\u0000\u0000\u0000\u02fe\u02ff\u0005%\u0000\u0000\u02ff\u0300"+
		"\u0005\u00e2\u0000\u0000\u0300\u0301\u0003\u0080@\u0000\u0301\u0302\u0003"+
		"\u0082A\u0000\u0302\u0303\u0005\u00f1\u0000\u0000\u0303\u0304\u0003l6"+
		"\u0000\u0304\u0306\u0001\u0000\u0000\u0000\u0305\u02f0\u0001\u0000\u0000"+
		"\u0000\u0305\u02f6\u0001\u0000\u0000\u0000\u0305\u02fe\u0001\u0000\u0000"+
		"\u0000\u0306\u007f\u0001\u0000\u0000\u0000\u0307\u030a\u0003r9\u0000\u0308"+
		"\u030a\u0003d2\u0000\u0309\u0307\u0001\u0000\u0000\u0000\u0309\u0308\u0001"+
		"\u0000\u0000\u0000\u030a\u0081\u0001\u0000\u0000\u0000\u030b\u030d\u0003"+
		"x<\u0000\u030c\u030b\u0001\u0000\u0000\u0000\u030c\u030d\u0001\u0000\u0000"+
		"\u0000\u030d\u030e\u0001\u0000\u0000\u0000\u030e\u0310\u0005\u00f2\u0000"+
		"\u0000\u030f\u0311\u0003\u001c\u000e\u0000\u0310\u030f\u0001\u0000\u0000"+
		"\u0000\u0310\u0311\u0001\u0000\u0000\u0000\u0311\u0083\u0001\u0000\u0000"+
		"\u0000\u0312\u0313\u0005\r\u0000\u0000\u0313\u031e\u0005\u00f2\u0000\u0000"+
		"\u0314\u0315\u0005\u0004\u0000\u0000\u0315\u031e\u0005\u00f2\u0000\u0000"+
		"\u0316\u0318\u0005s\u0000\u0000\u0317\u0319\u0003\u001c\u000e\u0000\u0318"+
		"\u0317\u0001\u0000\u0000\u0000\u0318\u0319\u0001\u0000\u0000\u0000\u0319"+
		"\u031a\u0001\u0000\u0000\u0000\u031a\u031e\u0005\u00f2\u0000\u0000\u031b"+
		"\u031c\u0005\u000f\u0000\u0000\u031c\u031e\u0005\u00f2\u0000\u0000\u031d"+
		"\u0312\u0001\u0000\u0000\u0000\u031d\u0314\u0001\u0000\u0000\u0000\u031d"+
		"\u0316\u0001\u0000\u0000\u0000\u031d\u031b\u0001\u0000\u0000\u0000\u031e"+
		"\u0085\u0001\u0000\u0000\u0000\u031f\u0323\u0003\u0088D\u0000\u0320\u0323"+
		"\u0003 \u0010\u0000\u0321\u0323\u0005\u00f2\u0000\u0000\u0322\u031f\u0001"+
		"\u0000\u0000\u0000\u0322\u0320\u0001\u0000\u0000\u0000\u0322\u0321\u0001"+
		"\u0000\u0000\u0000\u0323\u0087\u0001\u0000\u0000\u0000\u0324\u0325\u0003"+
		"$\u0012\u0000\u0325\u0326\u0003n7\u0000\u0326\u0089\u0001\u0000\u0000"+
		"\u0000G\u008d\u009f\u00a6\u00aa\u00b4\u00be\u00c0\u00c5\u00cc\u00d2\u00d9"+
		"\u00dd\u00e7\u00f0\u0118\u011a\u0125\u012f\u0143\u0145\u014b\u014f\u0156"+
		"\u015d\u0166\u016c\u0171\u0175\u017e\u0183\u0187\u018b\u0191\u01a1\u01a7"+
		"\u01aa\u01b1\u01b9\u01cf\u01d3\u01da\u01e1\u01e6\u01ea\u0267\u026d\u0276"+
		"\u0281\u0288\u028d\u0293\u0297\u029e\u02a5\u02ae\u02b2\u02b8\u02bc\u02c3"+
		"\u02c9\u02d4\u02dc\u02e4\u02ee\u0305\u0309\u030c\u0310\u0318\u031d\u0322";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}