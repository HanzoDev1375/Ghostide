// Generated from /storage/emulated/0/apk/LessParser.g4 by ANTLR 4.13.2
package io.github.rosemoe.sora.langs.less;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LessParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LessParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link LessParser#stylesheet}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStylesheet(LessParser.StylesheetContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(LessParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#variableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableName(LessParser.VariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#commandStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommandStatement(LessParser.CommandStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#mathCharacter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathCharacter(LessParser.MathCharacterContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#mathStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMathStatement(LessParser.MathStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(LessParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#function_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_(LessParser.Function_Context ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#conditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditions(LessParser.ConditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(LessParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#conditionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionStatement(LessParser.ConditionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(LessParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#importDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDeclaration(LessParser.ImportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#importOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportOption(LessParser.ImportOptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#referenceUrl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReferenceUrl(LessParser.ReferenceUrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#mediaTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMediaTypes(LessParser.MediaTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#ruleset}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRuleset(LessParser.RulesetContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(LessParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#mixinDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinDefinition(LessParser.MixinDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#mixinGuard}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinGuard(LessParser.MixinGuardContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#mixinDefinitionParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinDefinitionParam(LessParser.MixinDefinitionParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#mixinReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinReference(LessParser.MixinReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#selectors}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectors(LessParser.SelectorsContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(LessParser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#attrib}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttrib(LessParser.AttribContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#negation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegation(LessParser.NegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#pseudo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPseudo(LessParser.PseudoContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(LessParser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#selectorPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelectorPrefix(LessParser.SelectorPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#attribRelate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribRelate(LessParser.AttribRelateContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(LessParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#identifierPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierPart(LessParser.IdentifierPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#identifierVariableName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierVariableName(LessParser.IdentifierVariableNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#property_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProperty_(LessParser.Property_Context ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValues(LessParser.ValuesContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#url}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUrl(LessParser.UrlContext ctx);
	/**
	 * Visit a parse tree produced by {@link LessParser#measurement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMeasurement(LessParser.MeasurementContext ctx);
}