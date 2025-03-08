// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/grammars-v4/YamlGrammar.g4 by ANTLR 4.13.1
package ir.ninjacoder.ghostide;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link YamlGrammarParser}.
 */
public interface YamlGrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link YamlGrammarParser#yaml}.
	 * @param ctx the parse tree
	 */
	void enterYaml(YamlGrammarParser.YamlContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlGrammarParser#yaml}.
	 * @param ctx the parse tree
	 */
	void exitYaml(YamlGrammarParser.YamlContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlGrammarParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(YamlGrammarParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlGrammarParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(YamlGrammarParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlGrammarParser#key_value_pairs}.
	 * @param ctx the parse tree
	 */
	void enterKey_value_pairs(YamlGrammarParser.Key_value_pairsContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlGrammarParser#key_value_pairs}.
	 * @param ctx the parse tree
	 */
	void exitKey_value_pairs(YamlGrammarParser.Key_value_pairsContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlGrammarParser#key_value_pair}.
	 * @param ctx the parse tree
	 */
	void enterKey_value_pair(YamlGrammarParser.Key_value_pairContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlGrammarParser#key_value_pair}.
	 * @param ctx the parse tree
	 */
	void exitKey_value_pair(YamlGrammarParser.Key_value_pairContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlGrammarParser#key}.
	 * @param ctx the parse tree
	 */
	void enterKey(YamlGrammarParser.KeyContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlGrammarParser#key}.
	 * @param ctx the parse tree
	 */
	void exitKey(YamlGrammarParser.KeyContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(YamlGrammarParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlGrammarParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(YamlGrammarParser.ValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link YamlGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(YamlGrammarParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link YamlGrammarParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(YamlGrammarParser.ListContext ctx);
}