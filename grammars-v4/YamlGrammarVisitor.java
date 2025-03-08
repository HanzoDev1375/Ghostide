// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide2/grammars-v4/YamlGrammar.g4 by ANTLR 4.13.1
package ir.ninjacoder.ghostide;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link YamlGrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface YamlGrammarVisitor<T> extends ParseTreeVisitor<T> {

    /**
     * Visit a parse tree produced by {@link YamlGrammarParser#yaml}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitYaml(YamlGrammarParser.YamlContext ctx);

    /**
     * Visit a parse tree produced by {@link YamlGrammarParser#document}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDocument(YamlGrammarParser.DocumentContext ctx);

    /**
     * Visit a parse tree produced by {@link YamlGrammarParser#key_value_pairs}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitKey_value_pairs(YamlGrammarParser.Key_value_pairsContext ctx);

    /**
     * Visit a parse tree produced by {@link YamlGrammarParser#key_value_pair}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitKey_value_pair(YamlGrammarParser.Key_value_pairContext ctx);

    /**
     * Visit a parse tree produced by {@link YamlGrammarParser#key}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitKey(YamlGrammarParser.KeyContext ctx);

    /**
     * Visit a parse tree produced by {@link YamlGrammarParser#value}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitValue(YamlGrammarParser.ValueContext ctx);

    /**
     * Visit a parse tree produced by {@link YamlGrammarParser#list}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitList(YamlGrammarParser.ListContext ctx);
}
