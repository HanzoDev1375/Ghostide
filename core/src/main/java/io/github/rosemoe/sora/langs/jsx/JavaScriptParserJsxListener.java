// Generated from /storage/emulated/0/apk/iconz/sources/JavaScriptParserJsx.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.jsx;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link JavaScriptParserJsx}.
 */
public interface JavaScriptParserJsxListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(JavaScriptParserJsx.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(JavaScriptParserJsx.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#sourceElement}.
	 * @param ctx the parse tree
	 */
	void enterSourceElement(JavaScriptParserJsx.SourceElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#sourceElement}.
	 * @param ctx the parse tree
	 */
	void exitSourceElement(JavaScriptParserJsx.SourceElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(JavaScriptParserJsx.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(JavaScriptParserJsx.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(JavaScriptParserJsx.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(JavaScriptParserJsx.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#statementList}.
	 * @param ctx the parse tree
	 */
	void enterStatementList(JavaScriptParserJsx.StatementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#statementList}.
	 * @param ctx the parse tree
	 */
	void exitStatementList(JavaScriptParserJsx.StatementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#importStatement}.
	 * @param ctx the parse tree
	 */
	void enterImportStatement(JavaScriptParserJsx.ImportStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#importStatement}.
	 * @param ctx the parse tree
	 */
	void exitImportStatement(JavaScriptParserJsx.ImportStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#importFromBlock}.
	 * @param ctx the parse tree
	 */
	void enterImportFromBlock(JavaScriptParserJsx.ImportFromBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#importFromBlock}.
	 * @param ctx the parse tree
	 */
	void exitImportFromBlock(JavaScriptParserJsx.ImportFromBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#moduleItems}.
	 * @param ctx the parse tree
	 */
	void enterModuleItems(JavaScriptParserJsx.ModuleItemsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#moduleItems}.
	 * @param ctx the parse tree
	 */
	void exitModuleItems(JavaScriptParserJsx.ModuleItemsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#importDefault}.
	 * @param ctx the parse tree
	 */
	void enterImportDefault(JavaScriptParserJsx.ImportDefaultContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#importDefault}.
	 * @param ctx the parse tree
	 */
	void exitImportDefault(JavaScriptParserJsx.ImportDefaultContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#importNamespace}.
	 * @param ctx the parse tree
	 */
	void enterImportNamespace(JavaScriptParserJsx.ImportNamespaceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#importNamespace}.
	 * @param ctx the parse tree
	 */
	void exitImportNamespace(JavaScriptParserJsx.ImportNamespaceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#importFrom}.
	 * @param ctx the parse tree
	 */
	void enterImportFrom(JavaScriptParserJsx.ImportFromContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#importFrom}.
	 * @param ctx the parse tree
	 */
	void exitImportFrom(JavaScriptParserJsx.ImportFromContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#aliasName}.
	 * @param ctx the parse tree
	 */
	void enterAliasName(JavaScriptParserJsx.AliasNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#aliasName}.
	 * @param ctx the parse tree
	 */
	void exitAliasName(JavaScriptParserJsx.AliasNameContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExportDeclaration}
	 * labeled alternative in {@link JavaScriptParserJsx#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportDeclaration(JavaScriptParserJsx.ExportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExportDeclaration}
	 * labeled alternative in {@link JavaScriptParserJsx#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportDeclaration(JavaScriptParserJsx.ExportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExportDefaultDeclaration}
	 * labeled alternative in {@link JavaScriptParserJsx#exportStatement}.
	 * @param ctx the parse tree
	 */
	void enterExportDefaultDeclaration(JavaScriptParserJsx.ExportDefaultDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExportDefaultDeclaration}
	 * labeled alternative in {@link JavaScriptParserJsx#exportStatement}.
	 * @param ctx the parse tree
	 */
	void exitExportDefaultDeclaration(JavaScriptParserJsx.ExportDefaultDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#exportFromBlock}.
	 * @param ctx the parse tree
	 */
	void enterExportFromBlock(JavaScriptParserJsx.ExportFromBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#exportFromBlock}.
	 * @param ctx the parse tree
	 */
	void exitExportFromBlock(JavaScriptParserJsx.ExportFromBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(JavaScriptParserJsx.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(JavaScriptParserJsx.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#variableStatement}.
	 * @param ctx the parse tree
	 */
	void enterVariableStatement(JavaScriptParserJsx.VariableStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#variableStatement}.
	 * @param ctx the parse tree
	 */
	void exitVariableStatement(JavaScriptParserJsx.VariableStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarationList(JavaScriptParserJsx.VariableDeclarationListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#variableDeclarationList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarationList(JavaScriptParserJsx.VariableDeclarationListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(JavaScriptParserJsx.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(JavaScriptParserJsx.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement_(JavaScriptParserJsx.EmptyStatement_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#emptyStatement_}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement_(JavaScriptParserJsx.EmptyStatement_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(JavaScriptParserJsx.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(JavaScriptParserJsx.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(JavaScriptParserJsx.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(JavaScriptParserJsx.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(JavaScriptParserJsx.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(JavaScriptParserJsx.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(JavaScriptParserJsx.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(JavaScriptParserJsx.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(JavaScriptParserJsx.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(JavaScriptParserJsx.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForInStatement(JavaScriptParserJsx.ForInStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForInStatement(JavaScriptParserJsx.ForInStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void enterForOfStatement(JavaScriptParserJsx.ForOfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 */
	void exitForOfStatement(JavaScriptParserJsx.ForOfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#varModifier}.
	 * @param ctx the parse tree
	 */
	void enterVarModifier(JavaScriptParserJsx.VarModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#varModifier}.
	 * @param ctx the parse tree
	 */
	void exitVarModifier(JavaScriptParserJsx.VarModifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(JavaScriptParserJsx.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(JavaScriptParserJsx.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(JavaScriptParserJsx.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(JavaScriptParserJsx.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(JavaScriptParserJsx.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(JavaScriptParserJsx.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void enterYieldStatement(JavaScriptParserJsx.YieldStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#yieldStatement}.
	 * @param ctx the parse tree
	 */
	void exitYieldStatement(JavaScriptParserJsx.YieldStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#withStatement}.
	 * @param ctx the parse tree
	 */
	void enterWithStatement(JavaScriptParserJsx.WithStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#withStatement}.
	 * @param ctx the parse tree
	 */
	void exitWithStatement(JavaScriptParserJsx.WithStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(JavaScriptParserJsx.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(JavaScriptParserJsx.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#caseBlock}.
	 * @param ctx the parse tree
	 */
	void enterCaseBlock(JavaScriptParserJsx.CaseBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#caseBlock}.
	 * @param ctx the parse tree
	 */
	void exitCaseBlock(JavaScriptParserJsx.CaseBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#caseClauses}.
	 * @param ctx the parse tree
	 */
	void enterCaseClauses(JavaScriptParserJsx.CaseClausesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#caseClauses}.
	 * @param ctx the parse tree
	 */
	void exitCaseClauses(JavaScriptParserJsx.CaseClausesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#caseClause}.
	 * @param ctx the parse tree
	 */
	void enterCaseClause(JavaScriptParserJsx.CaseClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#caseClause}.
	 * @param ctx the parse tree
	 */
	void exitCaseClause(JavaScriptParserJsx.CaseClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#defaultClause}.
	 * @param ctx the parse tree
	 */
	void enterDefaultClause(JavaScriptParserJsx.DefaultClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#defaultClause}.
	 * @param ctx the parse tree
	 */
	void exitDefaultClause(JavaScriptParserJsx.DefaultClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabelledStatement(JavaScriptParserJsx.LabelledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#labelledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabelledStatement(JavaScriptParserJsx.LabelledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(JavaScriptParserJsx.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(JavaScriptParserJsx.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(JavaScriptParserJsx.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(JavaScriptParserJsx.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#catchProduction}.
	 * @param ctx the parse tree
	 */
	void enterCatchProduction(JavaScriptParserJsx.CatchProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#catchProduction}.
	 * @param ctx the parse tree
	 */
	void exitCatchProduction(JavaScriptParserJsx.CatchProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#finallyProduction}.
	 * @param ctx the parse tree
	 */
	void enterFinallyProduction(JavaScriptParserJsx.FinallyProductionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#finallyProduction}.
	 * @param ctx the parse tree
	 */
	void exitFinallyProduction(JavaScriptParserJsx.FinallyProductionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void enterDebuggerStatement(JavaScriptParserJsx.DebuggerStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#debuggerStatement}.
	 * @param ctx the parse tree
	 */
	void exitDebuggerStatement(JavaScriptParserJsx.DebuggerStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(JavaScriptParserJsx.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#functionDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(JavaScriptParserJsx.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(JavaScriptParserJsx.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(JavaScriptParserJsx.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#classTail}.
	 * @param ctx the parse tree
	 */
	void enterClassTail(JavaScriptParserJsx.ClassTailContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#classTail}.
	 * @param ctx the parse tree
	 */
	void exitClassTail(JavaScriptParserJsx.ClassTailContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#classElement}.
	 * @param ctx the parse tree
	 */
	void enterClassElement(JavaScriptParserJsx.ClassElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#classElement}.
	 * @param ctx the parse tree
	 */
	void exitClassElement(JavaScriptParserJsx.ClassElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void enterMethodDefinition(JavaScriptParserJsx.MethodDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#methodDefinition}.
	 * @param ctx the parse tree
	 */
	void exitMethodDefinition(JavaScriptParserJsx.MethodDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(JavaScriptParserJsx.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(JavaScriptParserJsx.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#formalParameterArg}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterArg(JavaScriptParserJsx.FormalParameterArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#formalParameterArg}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterArg(JavaScriptParserJsx.FormalParameterArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#lastFormalParameterArg}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameterArg(JavaScriptParserJsx.LastFormalParameterArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#lastFormalParameterArg}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameterArg(JavaScriptParserJsx.LastFormalParameterArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#functionBody}.
	 * @param ctx the parse tree
	 */
	void enterFunctionBody(JavaScriptParserJsx.FunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#functionBody}.
	 * @param ctx the parse tree
	 */
	void exitFunctionBody(JavaScriptParserJsx.FunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#sourceElements}.
	 * @param ctx the parse tree
	 */
	void enterSourceElements(JavaScriptParserJsx.SourceElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#sourceElements}.
	 * @param ctx the parse tree
	 */
	void exitSourceElements(JavaScriptParserJsx.SourceElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteral(JavaScriptParserJsx.ArrayLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteral(JavaScriptParserJsx.ArrayLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#elementList}.
	 * @param ctx the parse tree
	 */
	void enterElementList(JavaScriptParserJsx.ElementListContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#elementList}.
	 * @param ctx the parse tree
	 */
	void exitElementList(JavaScriptParserJsx.ElementListContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#arrayElement}.
	 * @param ctx the parse tree
	 */
	void enterArrayElement(JavaScriptParserJsx.ArrayElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#arrayElement}.
	 * @param ctx the parse tree
	 */
	void exitArrayElement(JavaScriptParserJsx.ArrayElementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyExpressionAssignment}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertyExpressionAssignment(JavaScriptParserJsx.PropertyExpressionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyExpressionAssignment}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertyExpressionAssignment(JavaScriptParserJsx.PropertyExpressionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComputedPropertyExpressionAssignment}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterComputedPropertyExpressionAssignment(JavaScriptParserJsx.ComputedPropertyExpressionAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComputedPropertyExpressionAssignment}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitComputedPropertyExpressionAssignment(JavaScriptParserJsx.ComputedPropertyExpressionAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionProperty}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterFunctionProperty(JavaScriptParserJsx.FunctionPropertyContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionProperty}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitFunctionProperty(JavaScriptParserJsx.FunctionPropertyContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyGetter}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertyGetter(JavaScriptParserJsx.PropertyGetterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyGetter}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertyGetter(JavaScriptParserJsx.PropertyGetterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertySetter}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertySetter(JavaScriptParserJsx.PropertySetterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertySetter}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertySetter(JavaScriptParserJsx.PropertySetterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PropertyShorthand}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void enterPropertyShorthand(JavaScriptParserJsx.PropertyShorthandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PropertyShorthand}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 */
	void exitPropertyShorthand(JavaScriptParserJsx.PropertyShorthandContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#propertyName}.
	 * @param ctx the parse tree
	 */
	void enterPropertyName(JavaScriptParserJsx.PropertyNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#propertyName}.
	 * @param ctx the parse tree
	 */
	void exitPropertyName(JavaScriptParserJsx.PropertyNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(JavaScriptParserJsx.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(JavaScriptParserJsx.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(JavaScriptParserJsx.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(JavaScriptParserJsx.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterExpressionSequence(JavaScriptParserJsx.ExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#expressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitExpressionSequence(JavaScriptParserJsx.ExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TemplateStringExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterTemplateStringExpression(JavaScriptParserJsx.TemplateStringExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TemplateStringExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitTemplateStringExpression(JavaScriptParserJsx.TemplateStringExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterTernaryExpression(JavaScriptParserJsx.TernaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitTernaryExpression(JavaScriptParserJsx.TernaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalAndExpression(JavaScriptParserJsx.LogicalAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalAndExpression(JavaScriptParserJsx.LogicalAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PowerExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPowerExpression(JavaScriptParserJsx.PowerExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PowerExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPowerExpression(JavaScriptParserJsx.PowerExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreIncrementExpression(JavaScriptParserJsx.PreIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreIncrementExpression(JavaScriptParserJsx.PreIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectLiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteralExpression(JavaScriptParserJsx.ObjectLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectLiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteralExpression(JavaScriptParserJsx.ObjectLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MetaExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMetaExpression(JavaScriptParserJsx.MetaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MetaExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMetaExpression(JavaScriptParserJsx.MetaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterInExpression(JavaScriptParserJsx.InExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitInExpression(JavaScriptParserJsx.InExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterLogicalOrExpression(JavaScriptParserJsx.LogicalOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitLogicalOrExpression(JavaScriptParserJsx.LogicalOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(JavaScriptParserJsx.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(JavaScriptParserJsx.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreDecreaseExpression(JavaScriptParserJsx.PreDecreaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreDecreaseExpression(JavaScriptParserJsx.PreDecreaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code jsxElementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterJsxElementExpression(JavaScriptParserJsx.JsxElementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code jsxElementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitJsxElementExpression(JavaScriptParserJsx.JsxElementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArgumentsExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterArgumentsExpression(JavaScriptParserJsx.ArgumentsExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArgumentsExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitArgumentsExpression(JavaScriptParserJsx.ArgumentsExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AwaitExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAwaitExpression(JavaScriptParserJsx.AwaitExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AwaitExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAwaitExpression(JavaScriptParserJsx.AwaitExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ThisExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpression(JavaScriptParserJsx.ThisExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ThisExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpression(JavaScriptParserJsx.ThisExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterFunctionExpression(JavaScriptParserJsx.FunctionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitFunctionExpression(JavaScriptParserJsx.FunctionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(JavaScriptParserJsx.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(JavaScriptParserJsx.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(JavaScriptParserJsx.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(JavaScriptParserJsx.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostDecreaseExpression(JavaScriptParserJsx.PostDecreaseExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostDecreaseExpression(JavaScriptParserJsx.PostDecreaseExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeofExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterTypeofExpression(JavaScriptParserJsx.TypeofExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeofExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitTypeofExpression(JavaScriptParserJsx.TypeofExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code InstanceofExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterInstanceofExpression(JavaScriptParserJsx.InstanceofExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code InstanceofExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitInstanceofExpression(JavaScriptParserJsx.InstanceofExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code UnaryPlusExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryPlusExpression(JavaScriptParserJsx.UnaryPlusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code UnaryPlusExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryPlusExpression(JavaScriptParserJsx.UnaryPlusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DeleteExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterDeleteExpression(JavaScriptParserJsx.DeleteExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DeleteExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitDeleteExpression(JavaScriptParserJsx.DeleteExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ImportExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterImportExpression(JavaScriptParserJsx.ImportExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ImportExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitImportExpression(JavaScriptParserJsx.ImportExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(JavaScriptParserJsx.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(JavaScriptParserJsx.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitXOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitXOrExpression(JavaScriptParserJsx.BitXOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitXOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitXOrExpression(JavaScriptParserJsx.BitXOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SuperExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterSuperExpression(JavaScriptParserJsx.SuperExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SuperExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitSuperExpression(JavaScriptParserJsx.SuperExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpression(JavaScriptParserJsx.MultiplicativeExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpression(JavaScriptParserJsx.MultiplicativeExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitShiftExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitShiftExpression(JavaScriptParserJsx.BitShiftExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitShiftExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitShiftExpression(JavaScriptParserJsx.BitShiftExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpression(JavaScriptParserJsx.ParenthesizedExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpression(JavaScriptParserJsx.ParenthesizedExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpression(JavaScriptParserJsx.AdditiveExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpression(JavaScriptParserJsx.AdditiveExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpression(JavaScriptParserJsx.RelationalExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpression(JavaScriptParserJsx.RelationalExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostIncrementExpression(JavaScriptParserJsx.PostIncrementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostIncrementExpression(JavaScriptParserJsx.PostIncrementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code YieldExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterYieldExpression(JavaScriptParserJsx.YieldExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code YieldExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitYieldExpression(JavaScriptParserJsx.YieldExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitNotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitNotExpression(JavaScriptParserJsx.BitNotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitNotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitNotExpression(JavaScriptParserJsx.BitNotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(JavaScriptParserJsx.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(JavaScriptParserJsx.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterLiteralExpression(JavaScriptParserJsx.LiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitLiteralExpression(JavaScriptParserJsx.LiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralExpression(JavaScriptParserJsx.ArrayLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralExpression(JavaScriptParserJsx.ArrayLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberDotExpression(JavaScriptParserJsx.MemberDotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberDotExpression(JavaScriptParserJsx.MemberDotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ClassExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassExpression(JavaScriptParserJsx.ClassExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ClassExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassExpression(JavaScriptParserJsx.ClassExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterMemberIndexExpression(JavaScriptParserJsx.MemberIndexExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitMemberIndexExpression(JavaScriptParserJsx.MemberIndexExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(JavaScriptParserJsx.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(JavaScriptParserJsx.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitAndExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitAndExpression(JavaScriptParserJsx.BitAndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitAndExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitAndExpression(JavaScriptParserJsx.BitAndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BitOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterBitOrExpression(JavaScriptParserJsx.BitOrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BitOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitBitOrExpression(JavaScriptParserJsx.BitOrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AssignmentOperatorExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperatorExpression(JavaScriptParserJsx.AssignmentOperatorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AssignmentOperatorExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperatorExpression(JavaScriptParserJsx.AssignmentOperatorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VoidExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterVoidExpression(JavaScriptParserJsx.VoidExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VoidExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitVoidExpression(JavaScriptParserJsx.VoidExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CoalesceExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void enterCoalesceExpression(JavaScriptParserJsx.CoalesceExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CoalesceExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 */
	void exitCoalesceExpression(JavaScriptParserJsx.CoalesceExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxElements}.
	 * @param ctx the parse tree
	 */
	void enterJsxElements(JavaScriptParserJsx.JsxElementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxElements}.
	 * @param ctx the parse tree
	 */
	void exitJsxElements(JavaScriptParserJsx.JsxElementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxElementBegin}.
	 * @param ctx the parse tree
	 */
	void enterJsxElementBegin(JavaScriptParserJsx.JsxElementBeginContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxElementBegin}.
	 * @param ctx the parse tree
	 */
	void exitJsxElementBegin(JavaScriptParserJsx.JsxElementBeginContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxElement}.
	 * @param ctx the parse tree
	 */
	void enterJsxElement(JavaScriptParserJsx.JsxElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxElement}.
	 * @param ctx the parse tree
	 */
	void exitJsxElement(JavaScriptParserJsx.JsxElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxSelfClosingElement}.
	 * @param ctx the parse tree
	 */
	void enterJsxSelfClosingElement(JavaScriptParserJsx.JsxSelfClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxSelfClosingElement}.
	 * @param ctx the parse tree
	 */
	void exitJsxSelfClosingElement(JavaScriptParserJsx.JsxSelfClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxOpeningElement}.
	 * @param ctx the parse tree
	 */
	void enterJsxOpeningElement(JavaScriptParserJsx.JsxOpeningElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxOpeningElement}.
	 * @param ctx the parse tree
	 */
	void exitJsxOpeningElement(JavaScriptParserJsx.JsxOpeningElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxClosingElement}.
	 * @param ctx the parse tree
	 */
	void enterJsxClosingElement(JavaScriptParserJsx.JsxClosingElementContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxClosingElement}.
	 * @param ctx the parse tree
	 */
	void exitJsxClosingElement(JavaScriptParserJsx.JsxClosingElementContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxChildren}.
	 * @param ctx the parse tree
	 */
	void enterJsxChildren(JavaScriptParserJsx.JsxChildrenContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxChildren}.
	 * @param ctx the parse tree
	 */
	void exitJsxChildren(JavaScriptParserJsx.JsxChildrenContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxSelfClosingElementName}.
	 * @param ctx the parse tree
	 */
	void enterJsxSelfClosingElementName(JavaScriptParserJsx.JsxSelfClosingElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxSelfClosingElementName}.
	 * @param ctx the parse tree
	 */
	void exitJsxSelfClosingElementName(JavaScriptParserJsx.JsxSelfClosingElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxOpeningElementName}.
	 * @param ctx the parse tree
	 */
	void enterJsxOpeningElementName(JavaScriptParserJsx.JsxOpeningElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxOpeningElementName}.
	 * @param ctx the parse tree
	 */
	void exitJsxOpeningElementName(JavaScriptParserJsx.JsxOpeningElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxClosingElementName}.
	 * @param ctx the parse tree
	 */
	void enterJsxClosingElementName(JavaScriptParserJsx.JsxClosingElementNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxClosingElementName}.
	 * @param ctx the parse tree
	 */
	void exitJsxClosingElementName(JavaScriptParserJsx.JsxClosingElementNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxAttributes}.
	 * @param ctx the parse tree
	 */
	void enterJsxAttributes(JavaScriptParserJsx.JsxAttributesContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxAttributes}.
	 * @param ctx the parse tree
	 */
	void exitJsxAttributes(JavaScriptParserJsx.JsxAttributesContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxSpreadAttribute}.
	 * @param ctx the parse tree
	 */
	void enterJsxSpreadAttribute(JavaScriptParserJsx.JsxSpreadAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxSpreadAttribute}.
	 * @param ctx the parse tree
	 */
	void exitJsxSpreadAttribute(JavaScriptParserJsx.JsxSpreadAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void enterJsxAttribute(JavaScriptParserJsx.JsxAttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxAttribute}.
	 * @param ctx the parse tree
	 */
	void exitJsxAttribute(JavaScriptParserJsx.JsxAttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxAttributeName}.
	 * @param ctx the parse tree
	 */
	void enterJsxAttributeName(JavaScriptParserJsx.JsxAttributeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxAttributeName}.
	 * @param ctx the parse tree
	 */
	void exitJsxAttributeName(JavaScriptParserJsx.JsxAttributeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#jsxAttributeValue}.
	 * @param ctx the parse tree
	 */
	void enterJsxAttributeValue(JavaScriptParserJsx.JsxAttributeValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#jsxAttributeValue}.
	 * @param ctx the parse tree
	 */
	void exitJsxAttributeValue(JavaScriptParserJsx.JsxAttributeValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#assignable}.
	 * @param ctx the parse tree
	 */
	void enterAssignable(JavaScriptParserJsx.AssignableContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#assignable}.
	 * @param ctx the parse tree
	 */
	void exitAssignable(JavaScriptParserJsx.AssignableContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void enterObjectLiteral(JavaScriptParserJsx.ObjectLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#objectLiteral}.
	 * @param ctx the parse tree
	 */
	void exitObjectLiteral(JavaScriptParserJsx.ObjectLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#openBrace}.
	 * @param ctx the parse tree
	 */
	void enterOpenBrace(JavaScriptParserJsx.OpenBraceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#openBrace}.
	 * @param ctx the parse tree
	 */
	void exitOpenBrace(JavaScriptParserJsx.OpenBraceContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#objectExpressionSequence}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpressionSequence(JavaScriptParserJsx.ObjectExpressionSequenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#objectExpressionSequence}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpressionSequence(JavaScriptParserJsx.ObjectExpressionSequenceContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(JavaScriptParserJsx.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(JavaScriptParserJsx.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AnoymousFunctionDecl}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterAnoymousFunctionDecl(JavaScriptParserJsx.AnoymousFunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AnoymousFunctionDecl}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitAnoymousFunctionDecl(JavaScriptParserJsx.AnoymousFunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrowFunction}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunction(JavaScriptParserJsx.ArrowFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrowFunction}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunction(JavaScriptParserJsx.ArrowFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#arrowFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunctionParameters(JavaScriptParserJsx.ArrowFunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#arrowFunctionParameters}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunctionParameters(JavaScriptParserJsx.ArrowFunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#arrowFunctionBody}.
	 * @param ctx the parse tree
	 */
	void enterArrowFunctionBody(JavaScriptParserJsx.ArrowFunctionBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#arrowFunctionBody}.
	 * @param ctx the parse tree
	 */
	void exitArrowFunctionBody(JavaScriptParserJsx.ArrowFunctionBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(JavaScriptParserJsx.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(JavaScriptParserJsx.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(JavaScriptParserJsx.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(JavaScriptParserJsx.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#templateStringLiteral}.
	 * @param ctx the parse tree
	 */
	void enterTemplateStringLiteral(JavaScriptParserJsx.TemplateStringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#templateStringLiteral}.
	 * @param ctx the parse tree
	 */
	void exitTemplateStringLiteral(JavaScriptParserJsx.TemplateStringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#templateStringAtom}.
	 * @param ctx the parse tree
	 */
	void enterTemplateStringAtom(JavaScriptParserJsx.TemplateStringAtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#templateStringAtom}.
	 * @param ctx the parse tree
	 */
	void exitTemplateStringAtom(JavaScriptParserJsx.TemplateStringAtomContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNumericLiteral(JavaScriptParserJsx.NumericLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#numericLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNumericLiteral(JavaScriptParserJsx.NumericLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#bigintLiteral}.
	 * @param ctx the parse tree
	 */
	void enterBigintLiteral(JavaScriptParserJsx.BigintLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#bigintLiteral}.
	 * @param ctx the parse tree
	 */
	void exitBigintLiteral(JavaScriptParserJsx.BigintLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#getter}.
	 * @param ctx the parse tree
	 */
	void enterGetter(JavaScriptParserJsx.GetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#getter}.
	 * @param ctx the parse tree
	 */
	void exitGetter(JavaScriptParserJsx.GetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#setter}.
	 * @param ctx the parse tree
	 */
	void enterSetter(JavaScriptParserJsx.SetterContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#setter}.
	 * @param ctx the parse tree
	 */
	void exitSetter(JavaScriptParserJsx.SetterContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#identifierName}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierName(JavaScriptParserJsx.IdentifierNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#identifierName}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierName(JavaScriptParserJsx.IdentifierNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(JavaScriptParserJsx.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(JavaScriptParserJsx.IdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#reservedWord}.
	 * @param ctx the parse tree
	 */
	void enterReservedWord(JavaScriptParserJsx.ReservedWordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#reservedWord}.
	 * @param ctx the parse tree
	 */
	void exitReservedWord(JavaScriptParserJsx.ReservedWordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#keyword}.
	 * @param ctx the parse tree
	 */
	void enterKeyword(JavaScriptParserJsx.KeywordContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#keyword}.
	 * @param ctx the parse tree
	 */
	void exitKeyword(JavaScriptParserJsx.KeywordContext ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#let_}.
	 * @param ctx the parse tree
	 */
	void enterLet_(JavaScriptParserJsx.Let_Context ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#let_}.
	 * @param ctx the parse tree
	 */
	void exitLet_(JavaScriptParserJsx.Let_Context ctx);
	/**
	 * Enter a parse tree produced by {@link JavaScriptParserJsx#eos}.
	 * @param ctx the parse tree
	 */
	void enterEos(JavaScriptParserJsx.EosContext ctx);
	/**
	 * Exit a parse tree produced by {@link JavaScriptParserJsx#eos}.
	 * @param ctx the parse tree
	 */
	void exitEos(JavaScriptParserJsx.EosContext ctx);
}