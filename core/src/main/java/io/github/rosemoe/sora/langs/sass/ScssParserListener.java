// Generated from ./ScssParser.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.sass;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ScssParser}.
 */
public interface ScssParserListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link ScssParser#stylesheet}.
     *
     * @param ctx the parse tree
     */
    void enterStylesheet(ScssParser.StylesheetContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#stylesheet}.
     *
     * @param ctx the parse tree
     */
    void exitStylesheet(ScssParser.StylesheetContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#statement}.
     *
     * @param ctx the parse tree
     */
    void enterStatement(ScssParser.StatementContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#statement}.
     *
     * @param ctx the parse tree
     */
    void exitStatement(ScssParser.StatementContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#importDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterImportDeclaration(ScssParser.ImportDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#importDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitImportDeclaration(ScssParser.ImportDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#importPath}.
     *
     * @param ctx the parse tree
     */
    void enterImportPath(ScssParser.ImportPathContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#importPath}.
     *
     * @param ctx the parse tree
     */
    void exitImportPath(ScssParser.ImportPathContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#asClause}.
     *
     * @param ctx the parse tree
     */
    void enterAsClause(ScssParser.AsClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#asClause}.
     *
     * @param ctx the parse tree
     */
    void exitAsClause(ScssParser.AsClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#withClause}.
     *
     * @param ctx the parse tree
     */
    void enterWithClause(ScssParser.WithClauseContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#withClause}.
     *
     * @param ctx the parse tree
     */
    void exitWithClause(ScssParser.WithClauseContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#variableDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterVariableDeclaration(ScssParser.VariableDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#variableDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitVariableDeclaration(ScssParser.VariableDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#variableValue}.
     *
     * @param ctx the parse tree
     */
    void enterVariableValue(ScssParser.VariableValueContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#variableValue}.
     *
     * @param ctx the parse tree
     */
    void exitVariableValue(ScssParser.VariableValueContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#variableName}.
     *
     * @param ctx the parse tree
     */
    void enterVariableName(ScssParser.VariableNameContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#variableName}.
     *
     * @param ctx the parse tree
     */
    void exitVariableName(ScssParser.VariableNameContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#namespace_}.
     *
     * @param ctx the parse tree
     */
    void enterNamespace_(ScssParser.Namespace_Context ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#namespace_}.
     *
     * @param ctx the parse tree
     */
    void exitNamespace_(ScssParser.Namespace_Context ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#propertyDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterPropertyDeclaration(ScssParser.PropertyDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#propertyDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitPropertyDeclaration(ScssParser.PropertyDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#prio}.
     *
     * @param ctx the parse tree
     */
    void enterPrio(ScssParser.PrioContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#prio}.
     *
     * @param ctx the parse tree
     */
    void exitPrio(ScssParser.PrioContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#propertyValue}.
     *
     * @param ctx the parse tree
     */
    void enterPropertyValue(ScssParser.PropertyValueContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#propertyValue}.
     *
     * @param ctx the parse tree
     */
    void exitPropertyValue(ScssParser.PropertyValueContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mediaDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterMediaDeclaration(ScssParser.MediaDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mediaDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitMediaDeclaration(ScssParser.MediaDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mediaQueryList}.
     *
     * @param ctx the parse tree
     */
    void enterMediaQueryList(ScssParser.MediaQueryListContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mediaQueryList}.
     *
     * @param ctx the parse tree
     */
    void exitMediaQueryList(ScssParser.MediaQueryListContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mediaQuery}.
     *
     * @param ctx the parse tree
     */
    void enterMediaQuery(ScssParser.MediaQueryContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mediaQuery}.
     *
     * @param ctx the parse tree
     */
    void exitMediaQuery(ScssParser.MediaQueryContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mediaExpression}.
     *
     * @param ctx the parse tree
     */
    void enterMediaExpression(ScssParser.MediaExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mediaExpression}.
     *
     * @param ctx the parse tree
     */
    void exitMediaExpression(ScssParser.MediaExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mixinDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterMixinDeclaration(ScssParser.MixinDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mixinDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitMixinDeclaration(ScssParser.MixinDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#contentDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterContentDeclaration(ScssParser.ContentDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#contentDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitContentDeclaration(ScssParser.ContentDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#fontFaceDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterFontFaceDeclaration(ScssParser.FontFaceDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#fontFaceDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitFontFaceDeclaration(ScssParser.FontFaceDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#keyframesDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterKeyframesDeclaration(ScssParser.KeyframesDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#keyframesDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitKeyframesDeclaration(ScssParser.KeyframesDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#keyframesBlock}.
     *
     * @param ctx the parse tree
     */
    void enterKeyframesBlock(ScssParser.KeyframesBlockContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#keyframesBlock}.
     *
     * @param ctx the parse tree
     */
    void exitKeyframesBlock(ScssParser.KeyframesBlockContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#percentageStatement}.
     *
     * @param ctx the parse tree
     */
    void enterPercentageStatement(ScssParser.PercentageStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#percentageStatement}.
     *
     * @param ctx the parse tree
     */
    void exitPercentageStatement(ScssParser.PercentageStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#includeDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterIncludeDeclaration(ScssParser.IncludeDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#includeDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitIncludeDeclaration(ScssParser.IncludeDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#interpolationDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterInterpolationDeclaration(ScssParser.InterpolationDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#interpolationDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitInterpolationDeclaration(ScssParser.InterpolationDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#extendDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterExtendDeclaration(ScssParser.ExtendDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#extendDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitExtendDeclaration(ScssParser.ExtendDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#warndingDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterWarndingDeclaration(ScssParser.WarndingDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#warndingDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitWarndingDeclaration(ScssParser.WarndingDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#errorDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterErrorDeclaration(ScssParser.ErrorDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#errorDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitErrorDeclaration(ScssParser.ErrorDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#atStatementDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterAtStatementDeclaration(ScssParser.AtStatementDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#atStatementDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitAtStatementDeclaration(ScssParser.AtStatementDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#ruleset}.
     *
     * @param ctx the parse tree
     */
    void enterRuleset(ScssParser.RulesetContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#ruleset}.
     *
     * @param ctx the parse tree
     */
    void exitRuleset(ScssParser.RulesetContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#block}.
     *
     * @param ctx the parse tree
     */
    void enterBlock(ScssParser.BlockContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#block}.
     *
     * @param ctx the parse tree
     */
    void exitBlock(ScssParser.BlockContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#selectorGroup}.
     *
     * @param ctx the parse tree
     */
    void enterSelectorGroup(ScssParser.SelectorGroupContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#selectorGroup}.
     *
     * @param ctx the parse tree
     */
    void exitSelectorGroup(ScssParser.SelectorGroupContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#selector}.
     *
     * @param ctx the parse tree
     */
    void enterSelector(ScssParser.SelectorContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#selector}.
     *
     * @param ctx the parse tree
     */
    void exitSelector(ScssParser.SelectorContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#combinator}.
     *
     * @param ctx the parse tree
     */
    void enterCombinator(ScssParser.CombinatorContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#combinator}.
     *
     * @param ctx the parse tree
     */
    void exitCombinator(ScssParser.CombinatorContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#selectorSequence}.
     *
     * @param ctx the parse tree
     */
    void enterSelectorSequence(ScssParser.SelectorSequenceContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#selectorSequence}.
     *
     * @param ctx the parse tree
     */
    void exitSelectorSequence(ScssParser.SelectorSequenceContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#id}.
     *
     * @param ctx the parse tree
     */
    void enterId(ScssParser.IdContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#id}.
     *
     * @param ctx the parse tree
     */
    void exitId(ScssParser.IdContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#typeSelector}.
     *
     * @param ctx the parse tree
     */
    void enterTypeSelector(ScssParser.TypeSelectorContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#typeSelector}.
     *
     * @param ctx the parse tree
     */
    void exitTypeSelector(ScssParser.TypeSelectorContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#typeNamespacePrefix}.
     *
     * @param ctx the parse tree
     */
    void enterTypeNamespacePrefix(ScssParser.TypeNamespacePrefixContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#typeNamespacePrefix}.
     *
     * @param ctx the parse tree
     */
    void exitTypeNamespacePrefix(ScssParser.TypeNamespacePrefixContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#universal}.
     *
     * @param ctx the parse tree
     */
    void enterUniversal(ScssParser.UniversalContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#universal}.
     *
     * @param ctx the parse tree
     */
    void exitUniversal(ScssParser.UniversalContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#className}.
     *
     * @param ctx the parse tree
     */
    void enterClassName(ScssParser.ClassNameContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#className}.
     *
     * @param ctx the parse tree
     */
    void exitClassName(ScssParser.ClassNameContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#interpolation}.
     *
     * @param ctx the parse tree
     */
    void enterInterpolation(ScssParser.InterpolationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#interpolation}.
     *
     * @param ctx the parse tree
     */
    void exitInterpolation(ScssParser.InterpolationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#parentRef}.
     *
     * @param ctx the parse tree
     */
    void enterParentRef(ScssParser.ParentRefContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#parentRef}.
     *
     * @param ctx the parse tree
     */
    void exitParentRef(ScssParser.ParentRefContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#attrib}.
     *
     * @param ctx the parse tree
     */
    void enterAttrib(ScssParser.AttribContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#attrib}.
     *
     * @param ctx the parse tree
     */
    void exitAttrib(ScssParser.AttribContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#pseudo}.
     *
     * @param ctx the parse tree
     */
    void enterPseudo(ScssParser.PseudoContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#pseudo}.
     *
     * @param ctx the parse tree
     */
    void exitPseudo(ScssParser.PseudoContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#functionalPseudo}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionalPseudo(ScssParser.FunctionalPseudoContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#functionalPseudo}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionalPseudo(ScssParser.FunctionalPseudoContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#pseudoParameter}.
     *
     * @param ctx the parse tree
     */
    void enterPseudoParameter(ScssParser.PseudoParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#pseudoParameter}.
     *
     * @param ctx the parse tree
     */
    void exitPseudoParameter(ScssParser.PseudoParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#negation}.
     *
     * @param ctx the parse tree
     */
    void enterNegation(ScssParser.NegationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#negation}.
     *
     * @param ctx the parse tree
     */
    void exitNegation(ScssParser.NegationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#negationArg}.
     *
     * @param ctx the parse tree
     */
    void enterNegationArg(ScssParser.NegationArgContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#negationArg}.
     *
     * @param ctx the parse tree
     */
    void exitNegationArg(ScssParser.NegationArgContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#operator_}.
     *
     * @param ctx the parse tree
     */
    void enterOperator_(ScssParser.Operator_Context ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#operator_}.
     *
     * @param ctx the parse tree
     */
    void exitOperator_(ScssParser.Operator_Context ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#value}.
     *
     * @param ctx the parse tree
     */
    void enterValue(ScssParser.ValueContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#value}.
     *
     * @param ctx the parse tree
     */
    void exitValue(ScssParser.ValueContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#functionDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionDeclaration(ScssParser.FunctionDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#functionDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionDeclaration(ScssParser.FunctionDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#parameters}.
     *
     * @param ctx the parse tree
     */
    void enterParameters(ScssParser.ParametersContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#parameters}.
     *
     * @param ctx the parse tree
     */
    void exitParameters(ScssParser.ParametersContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#parameter}.
     *
     * @param ctx the parse tree
     */
    void enterParameter(ScssParser.ParameterContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#parameter}.
     *
     * @param ctx the parse tree
     */
    void exitParameter(ScssParser.ParameterContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#functionBody}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionBody(ScssParser.FunctionBodyContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#functionBody}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionBody(ScssParser.FunctionBodyContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#functionReturn}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionReturn(ScssParser.FunctionReturnContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#functionReturn}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionReturn(ScssParser.FunctionReturnContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#functionStatement}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionStatement(ScssParser.FunctionStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#functionStatement}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionStatement(ScssParser.FunctionStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#functionCall}.
     *
     * @param ctx the parse tree
     */
    void enterFunctionCall(ScssParser.FunctionCallContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#functionCall}.
     *
     * @param ctx the parse tree
     */
    void exitFunctionCall(ScssParser.FunctionCallContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#expression}.
     *
     * @param ctx the parse tree
     */
    void enterExpression(ScssParser.ExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#expression}.
     *
     * @param ctx the parse tree
     */
    void exitExpression(ScssParser.ExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#expressionPart}.
     *
     * @param ctx the parse tree
     */
    void enterExpressionPart(ScssParser.ExpressionPartContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#expressionPart}.
     *
     * @param ctx the parse tree
     */
    void exitExpressionPart(ScssParser.ExpressionPartContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#ifExpression}.
     *
     * @param ctx the parse tree
     */
    void enterIfExpression(ScssParser.IfExpressionContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#ifExpression}.
     *
     * @param ctx the parse tree
     */
    void exitIfExpression(ScssParser.IfExpressionContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#listDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterListDeclaration(ScssParser.ListDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#listDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitListDeclaration(ScssParser.ListDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#listCommaSeparated}.
     *
     * @param ctx the parse tree
     */
    void enterListCommaSeparated(ScssParser.ListCommaSeparatedContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#listCommaSeparated}.
     *
     * @param ctx the parse tree
     */
    void exitListCommaSeparated(ScssParser.ListCommaSeparatedContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#listSpaceSeparated}.
     *
     * @param ctx the parse tree
     */
    void enterListSpaceSeparated(ScssParser.ListSpaceSeparatedContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#listSpaceSeparated}.
     *
     * @param ctx the parse tree
     */
    void exitListSpaceSeparated(ScssParser.ListSpaceSeparatedContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#listBracketed}.
     *
     * @param ctx the parse tree
     */
    void enterListBracketed(ScssParser.ListBracketedContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#listBracketed}.
     *
     * @param ctx the parse tree
     */
    void exitListBracketed(ScssParser.ListBracketedContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#listElement}.
     *
     * @param ctx the parse tree
     */
    void enterListElement(ScssParser.ListElementContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#listElement}.
     *
     * @param ctx the parse tree
     */
    void exitListElement(ScssParser.ListElementContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mapDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterMapDeclaration(ScssParser.MapDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mapDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitMapDeclaration(ScssParser.MapDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mapEntries}.
     *
     * @param ctx the parse tree
     */
    void enterMapEntries(ScssParser.MapEntriesContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mapEntries}.
     *
     * @param ctx the parse tree
     */
    void exitMapEntries(ScssParser.MapEntriesContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mapEntry}.
     *
     * @param ctx the parse tree
     */
    void enterMapEntry(ScssParser.MapEntryContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mapEntry}.
     *
     * @param ctx the parse tree
     */
    void exitMapEntry(ScssParser.MapEntryContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mapKey}.
     *
     * @param ctx the parse tree
     */
    void enterMapKey(ScssParser.MapKeyContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mapKey}.
     *
     * @param ctx the parse tree
     */
    void exitMapKey(ScssParser.MapKeyContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#mapValue}.
     *
     * @param ctx the parse tree
     */
    void enterMapValue(ScssParser.MapValueContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#mapValue}.
     *
     * @param ctx the parse tree
     */
    void exitMapValue(ScssParser.MapValueContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#ifDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterIfDeclaration(ScssParser.IfDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#ifDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitIfDeclaration(ScssParser.IfDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#elseIfStatement}.
     *
     * @param ctx the parse tree
     */
    void enterElseIfStatement(ScssParser.ElseIfStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#elseIfStatement}.
     *
     * @param ctx the parse tree
     */
    void exitElseIfStatement(ScssParser.ElseIfStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#elseStatement}.
     *
     * @param ctx the parse tree
     */
    void enterElseStatement(ScssParser.ElseStatementContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#elseStatement}.
     *
     * @param ctx the parse tree
     */
    void exitElseStatement(ScssParser.ElseStatementContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#forDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterForDeclaration(ScssParser.ForDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#forDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitForDeclaration(ScssParser.ForDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#through}.
     *
     * @param ctx the parse tree
     */
    void enterThrough(ScssParser.ThroughContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#through}.
     *
     * @param ctx the parse tree
     */
    void exitThrough(ScssParser.ThroughContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#whileDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterWhileDeclaration(ScssParser.WhileDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#whileDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitWhileDeclaration(ScssParser.WhileDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#eachDeclaration}.
     *
     * @param ctx the parse tree
     */
    void enterEachDeclaration(ScssParser.EachDeclarationContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#eachDeclaration}.
     *
     * @param ctx the parse tree
     */
    void exitEachDeclaration(ScssParser.EachDeclarationContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#eachValueList}.
     *
     * @param ctx the parse tree
     */
    void enterEachValueList(ScssParser.EachValueListContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#eachValueList}.
     *
     * @param ctx the parse tree
     */
    void exitEachValueList(ScssParser.EachValueListContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#var_}.
     *
     * @param ctx the parse tree
     */
    void enterVar_(ScssParser.Var_Context ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#var_}.
     *
     * @param ctx the parse tree
     */
    void exitVar_(ScssParser.Var_Context ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#calc}.
     *
     * @param ctx the parse tree
     */
    void enterCalc(ScssParser.CalcContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#calc}.
     *
     * @param ctx the parse tree
     */
    void exitCalc(ScssParser.CalcContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#rotate}.
     *
     * @param ctx the parse tree
     */
    void enterRotate(ScssParser.RotateContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#rotate}.
     *
     * @param ctx the parse tree
     */
    void exitRotate(ScssParser.RotateContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#rgba}.
     *
     * @param ctx the parse tree
     */
    void enterRgba(ScssParser.RgbaContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#rgba}.
     *
     * @param ctx the parse tree
     */
    void exitRgba(ScssParser.RgbaContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#repeat}.
     *
     * @param ctx the parse tree
     */
    void enterRepeat(ScssParser.RepeatContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#repeat}.
     *
     * @param ctx the parse tree
     */
    void exitRepeat(ScssParser.RepeatContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#unit}.
     *
     * @param ctx the parse tree
     */
    void enterUnit(ScssParser.UnitContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#unit}.
     *
     * @param ctx the parse tree
     */
    void exitUnit(ScssParser.UnitContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#length}.
     *
     * @param ctx the parse tree
     */
    void enterLength(ScssParser.LengthContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#length}.
     *
     * @param ctx the parse tree
     */
    void exitLength(ScssParser.LengthContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#dimension}.
     *
     * @param ctx the parse tree
     */
    void enterDimension(ScssParser.DimensionContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#dimension}.
     *
     * @param ctx the parse tree
     */
    void exitDimension(ScssParser.DimensionContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#percentage}.
     *
     * @param ctx the parse tree
     */
    void enterPercentage(ScssParser.PercentageContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#percentage}.
     *
     * @param ctx the parse tree
     */
    void exitPercentage(ScssParser.PercentageContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#degree}.
     *
     * @param ctx the parse tree
     */
    void enterDegree(ScssParser.DegreeContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#degree}.
     *
     * @param ctx the parse tree
     */
    void exitDegree(ScssParser.DegreeContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#measurment}.
     *
     * @param ctx the parse tree
     */
    void enterMeasurment(ScssParser.MeasurmentContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#measurment}.
     *
     * @param ctx the parse tree
     */
    void exitMeasurment(ScssParser.MeasurmentContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#uri}.
     *
     * @param ctx the parse tree
     */
    void enterUri(ScssParser.UriContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#uri}.
     *
     * @param ctx the parse tree
     */
    void exitUri(ScssParser.UriContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#arglist}.
     *
     * @param ctx the parse tree
     */
    void enterArglist(ScssParser.ArglistContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#arglist}.
     *
     * @param ctx the parse tree
     */
    void exitArglist(ScssParser.ArglistContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#plusMinus}.
     *
     * @param ctx the parse tree
     */
    void enterPlusMinus(ScssParser.PlusMinusContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#plusMinus}.
     *
     * @param ctx the parse tree
     */
    void exitPlusMinus(ScssParser.PlusMinusContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#hexcolor}.
     *
     * @param ctx the parse tree
     */
    void enterHexcolor(ScssParser.HexcolorContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#hexcolor}.
     *
     * @param ctx the parse tree
     */
    void exitHexcolor(ScssParser.HexcolorContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#color}.
     *
     * @param ctx the parse tree
     */
    void enterColor(ScssParser.ColorContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#color}.
     *
     * @param ctx the parse tree
     */
    void exitColor(ScssParser.ColorContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#boolean}.
     *
     * @param ctx the parse tree
     */
    void enterBoolean(ScssParser.BooleanContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#boolean}.
     *
     * @param ctx the parse tree
     */
    void exitBoolean(ScssParser.BooleanContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#number}.
     *
     * @param ctx the parse tree
     */
    void enterNumber(ScssParser.NumberContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#number}.
     *
     * @param ctx the parse tree
     */
    void exitNumber(ScssParser.NumberContext ctx);

    /**
     * Enter a parse tree produced by {@link ScssParser#identifier}.
     *
     * @param ctx the parse tree
     */
    void enterIdentifier(ScssParser.IdentifierContext ctx);

    /**
     * Exit a parse tree produced by {@link ScssParser#identifier}.
     *
     * @param ctx the parse tree
     */
    void exitIdentifier(ScssParser.IdentifierContext ctx);
}