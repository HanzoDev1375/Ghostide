// Generated from /storage/emulated/0/apk/LessParser.g4 by ANTLR 4.13.2
package io.github.rosemoe.sora.langs.less;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LessParser}.
 */
public interface LessParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link LessParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void enterStylesheet(LessParser.StylesheetContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#stylesheet}.
	 * @param ctx the parse tree
	 */
	void exitStylesheet(LessParser.StylesheetContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(LessParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(LessParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#variableName}.
	 * @param ctx the parse tree
	 */
	void enterVariableName(LessParser.VariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#variableName}.
	 * @param ctx the parse tree
	 */
	void exitVariableName(LessParser.VariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#commandStatement}.
	 * @param ctx the parse tree
	 */
	void enterCommandStatement(LessParser.CommandStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#commandStatement}.
	 * @param ctx the parse tree
	 */
	void exitCommandStatement(LessParser.CommandStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#mathCharacter}.
	 * @param ctx the parse tree
	 */
	void enterMathCharacter(LessParser.MathCharacterContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#mathCharacter}.
	 * @param ctx the parse tree
	 */
	void exitMathCharacter(LessParser.MathCharacterContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#mathStatement}.
	 * @param ctx the parse tree
	 */
	void enterMathStatement(LessParser.MathStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#mathStatement}.
	 * @param ctx the parse tree
	 */
	void exitMathStatement(LessParser.MathStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(LessParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(LessParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#function_}.
	 * @param ctx the parse tree
	 */
	void enterFunction_(LessParser.Function_Context ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#function_}.
	 * @param ctx the parse tree
	 */
	void exitFunction_(LessParser.Function_Context ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#conditions}.
	 * @param ctx the parse tree
	 */
	void enterConditions(LessParser.ConditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#conditions}.
	 * @param ctx the parse tree
	 */
	void exitConditions(LessParser.ConditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(LessParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(LessParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void enterConditionStatement(LessParser.ConditionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#conditionStatement}.
	 * @param ctx the parse tree
	 */
	void exitConditionStatement(LessParser.ConditionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(LessParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(LessParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(LessParser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(LessParser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#importOption}.
	 * @param ctx the parse tree
	 */
	void enterImportOption(LessParser.ImportOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#importOption}.
	 * @param ctx the parse tree
	 */
	void exitImportOption(LessParser.ImportOptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#referenceUrl}.
	 * @param ctx the parse tree
	 */
	void enterReferenceUrl(LessParser.ReferenceUrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#referenceUrl}.
	 * @param ctx the parse tree
	 */
	void exitReferenceUrl(LessParser.ReferenceUrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#mediaTypes}.
	 * @param ctx the parse tree
	 */
	void enterMediaTypes(LessParser.MediaTypesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#mediaTypes}.
	 * @param ctx the parse tree
	 */
	void exitMediaTypes(LessParser.MediaTypesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void enterRuleset(LessParser.RulesetContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#ruleset}.
	 * @param ctx the parse tree
	 */
	void exitRuleset(LessParser.RulesetContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(LessParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(LessParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#mixinDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMixinDefinition(LessParser.MixinDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#mixinDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMixinDefinition(LessParser.MixinDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#mixinGuard}.
	 * @param ctx the parse tree
	 */
	void enterMixinGuard(LessParser.MixinGuardContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#mixinGuard}.
	 * @param ctx the parse tree
	 */
	void exitMixinGuard(LessParser.MixinGuardContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#mixinDefinitionParam}.
	 * @param ctx the parse tree
	 */
	void enterMixinDefinitionParam(LessParser.MixinDefinitionParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#mixinDefinitionParam}.
	 * @param ctx the parse tree
	 */
	void exitMixinDefinitionParam(LessParser.MixinDefinitionParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#mixinReference}.
	 * @param ctx the parse tree
	 */
	void enterMixinReference(LessParser.MixinReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#mixinReference}.
	 * @param ctx the parse tree
	 */
	void exitMixinReference(LessParser.MixinReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#selectors}.
	 * @param ctx the parse tree
	 */
	void enterSelectors(LessParser.SelectorsContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#selectors}.
	 * @param ctx the parse tree
	 */
	void exitSelectors(LessParser.SelectorsContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#selector}.
	 * @param ctx the parse tree
	 */
	void enterSelector(LessParser.SelectorContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#selector}.
	 * @param ctx the parse tree
	 */
	void exitSelector(LessParser.SelectorContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#attrib}.
	 * @param ctx the parse tree
	 */
	void enterAttrib(LessParser.AttribContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#attrib}.
	 * @param ctx the parse tree
	 */
	void exitAttrib(LessParser.AttribContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#negation}.
	 * @param ctx the parse tree
	 */
	void enterNegation(LessParser.NegationContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#negation}.
	 * @param ctx the parse tree
	 */
	void exitNegation(LessParser.NegationContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void enterPseudo(LessParser.PseudoContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#pseudo}.
	 * @param ctx the parse tree
	 */
	void exitPseudo(LessParser.PseudoContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#element}.
	 * @param ctx the parse tree
	 */
	void enterElement(LessParser.ElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#element}.
	 * @param ctx the parse tree
	 */
	void exitElement(LessParser.ElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#selectorPrefix}.
	 * @param ctx the parse tree
	 */
	void enterSelectorPrefix(LessParser.SelectorPrefixContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#selectorPrefix}.
	 * @param ctx the parse tree
	 */
	void exitSelectorPrefix(LessParser.SelectorPrefixContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#attribRelate}.
	 * @param ctx the parse tree
	 */
	void enterAttribRelate(LessParser.AttribRelateContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#attribRelate}.
	 * @param ctx the parse tree
	 */
	void exitAttribRelate(LessParser.AttribRelateContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(LessParser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(LessParser.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#identifierPart}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierPart(LessParser.IdentifierPartContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#identifierPart}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierPart(LessParser.IdentifierPartContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#identifierVariableName}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierVariableName(LessParser.IdentifierVariableNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#identifierVariableName}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierVariableName(LessParser.IdentifierVariableNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#property_}.
	 * @param ctx the parse tree
	 */
	void enterProperty_(LessParser.Property_Context ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#property_}.
	 * @param ctx the parse tree
	 */
	void exitProperty_(LessParser.Property_Context ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#values}.
	 * @param ctx the parse tree
	 */
	void enterValues(LessParser.ValuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#values}.
	 * @param ctx the parse tree
	 */
	void exitValues(LessParser.ValuesContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#url}.
	 * @param ctx the parse tree
	 */
	void enterUrl(LessParser.UrlContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#url}.
	 * @param ctx the parse tree
	 */
	void exitUrl(LessParser.UrlContext ctx);
	/**
	 * Enter a parse tree produced by {@link LessParser#measurement}.
	 * @param ctx the parse tree
	 */
	void enterMeasurement(LessParser.MeasurementContext ctx);
	/**
	 * Exit a parse tree produced by {@link LessParser#measurement}.
	 * @param ctx the parse tree
	 */
	void exitMeasurement(LessParser.MeasurementContext ctx);
}