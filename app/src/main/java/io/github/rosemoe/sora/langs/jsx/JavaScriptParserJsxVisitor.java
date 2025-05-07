// Generated from /storage/emulated/0/apk/iconz/sources/JavaScriptParserJsx.g4 by ANTLR 4.13.1
package io.github.rosemoe.sora.langs.jsx;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link JavaScriptParserJsx}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface JavaScriptParserJsxVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(JavaScriptParserJsx.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#sourceElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceElement(JavaScriptParserJsx.SourceElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(JavaScriptParserJsx.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(JavaScriptParserJsx.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#statementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatementList(JavaScriptParserJsx.StatementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#importStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportStatement(JavaScriptParserJsx.ImportStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#importFromBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportFromBlock(JavaScriptParserJsx.ImportFromBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#moduleItems}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModuleItems(JavaScriptParserJsx.ModuleItemsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#importDefault}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDefault(JavaScriptParserJsx.ImportDefaultContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#importNamespace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportNamespace(JavaScriptParserJsx.ImportNamespaceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#importFrom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportFrom(JavaScriptParserJsx.ImportFromContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#aliasName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAliasName(JavaScriptParserJsx.AliasNameContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportDeclaration}
	 * labeled alternative in {@link JavaScriptParserJsx#exportStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDeclaration(JavaScriptParserJsx.ExportDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExportDefaultDeclaration}
	 * labeled alternative in {@link JavaScriptParserJsx#exportStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportDefaultDeclaration(JavaScriptParserJsx.ExportDefaultDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#exportFromBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExportFromBlock(JavaScriptParserJsx.ExportFromBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(JavaScriptParserJsx.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#variableStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableStatement(JavaScriptParserJsx.VariableStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#variableDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclarationList(JavaScriptParserJsx.VariableDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(JavaScriptParserJsx.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#emptyStatement_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStatement_(JavaScriptParserJsx.EmptyStatement_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(JavaScriptParserJsx.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(JavaScriptParserJsx.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DoStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(JavaScriptParserJsx.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(JavaScriptParserJsx.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(JavaScriptParserJsx.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForInStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInStatement(JavaScriptParserJsx.ForInStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ForOfStatement}
	 * labeled alternative in {@link JavaScriptParserJsx#iterationStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForOfStatement(JavaScriptParserJsx.ForOfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#varModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarModifier(JavaScriptParserJsx.VarModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(JavaScriptParserJsx.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(JavaScriptParserJsx.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(JavaScriptParserJsx.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(JavaScriptParserJsx.YieldStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#withStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWithStatement(JavaScriptParserJsx.WithStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(JavaScriptParserJsx.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#caseBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseBlock(JavaScriptParserJsx.CaseBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#caseClauses}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClauses(JavaScriptParserJsx.CaseClausesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#caseClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCaseClause(JavaScriptParserJsx.CaseClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#defaultClause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultClause(JavaScriptParserJsx.DefaultClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#labelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabelledStatement(JavaScriptParserJsx.LabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#throwStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowStatement(JavaScriptParserJsx.ThrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(JavaScriptParserJsx.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#catchProduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchProduction(JavaScriptParserJsx.CatchProductionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#finallyProduction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyProduction(JavaScriptParserJsx.FinallyProductionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#debuggerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDebuggerStatement(JavaScriptParserJsx.DebuggerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(JavaScriptParserJsx.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(JavaScriptParserJsx.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#classTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassTail(JavaScriptParserJsx.ClassTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#classElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassElement(JavaScriptParserJsx.ClassElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#methodDefinition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDefinition(JavaScriptParserJsx.MethodDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(JavaScriptParserJsx.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#formalParameterArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterArg(JavaScriptParserJsx.FormalParameterArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#lastFormalParameterArg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLastFormalParameterArg(JavaScriptParserJsx.LastFormalParameterArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(JavaScriptParserJsx.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#sourceElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSourceElements(JavaScriptParserJsx.SourceElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteral(JavaScriptParserJsx.ArrayLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#elementList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElementList(JavaScriptParserJsx.ElementListContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#arrayElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayElement(JavaScriptParserJsx.ArrayElementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyExpressionAssignment}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyExpressionAssignment(JavaScriptParserJsx.PropertyExpressionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ComputedPropertyExpressionAssignment}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComputedPropertyExpressionAssignment(JavaScriptParserJsx.ComputedPropertyExpressionAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionProperty}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionProperty(JavaScriptParserJsx.FunctionPropertyContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyGetter}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyGetter(JavaScriptParserJsx.PropertyGetterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertySetter}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertySetter(JavaScriptParserJsx.PropertySetterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PropertyShorthand}
	 * labeled alternative in {@link JavaScriptParserJsx#propertyAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyShorthand(JavaScriptParserJsx.PropertyShorthandContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#propertyName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyName(JavaScriptParserJsx.PropertyNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(JavaScriptParserJsx.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(JavaScriptParserJsx.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#expressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionSequence(JavaScriptParserJsx.ExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TemplateStringExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateStringExpression(JavaScriptParserJsx.TemplateStringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TernaryExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTernaryExpression(JavaScriptParserJsx.TernaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalAndExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(JavaScriptParserJsx.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PowerExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowerExpression(JavaScriptParserJsx.PowerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreIncrementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncrementExpression(JavaScriptParserJsx.PreIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectLiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteralExpression(JavaScriptParserJsx.ObjectLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MetaExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetaExpression(JavaScriptParserJsx.MetaExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInExpression(JavaScriptParserJsx.InExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicalOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(JavaScriptParserJsx.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpression(JavaScriptParserJsx.NotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreDecreaseExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreDecreaseExpression(JavaScriptParserJsx.PreDecreaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code jsxElementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxElementExpression(JavaScriptParserJsx.JsxElementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArgumentsExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentsExpression(JavaScriptParserJsx.ArgumentsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AwaitExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAwaitExpression(JavaScriptParserJsx.AwaitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ThisExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(JavaScriptParserJsx.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(JavaScriptParserJsx.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryMinusExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryMinusExpression(JavaScriptParserJsx.UnaryMinusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentExpression(JavaScriptParserJsx.AssignmentExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostDecreaseExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostDecreaseExpression(JavaScriptParserJsx.PostDecreaseExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TypeofExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeofExpression(JavaScriptParserJsx.TypeofExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InstanceofExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstanceofExpression(JavaScriptParserJsx.InstanceofExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code UnaryPlusExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPlusExpression(JavaScriptParserJsx.UnaryPlusExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DeleteExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeleteExpression(JavaScriptParserJsx.DeleteExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ImportExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportExpression(JavaScriptParserJsx.ImportExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(JavaScriptParserJsx.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitXOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitXOrExpression(JavaScriptParserJsx.BitXOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SuperExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperExpression(JavaScriptParserJsx.SuperExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MultiplicativeExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(JavaScriptParserJsx.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitShiftExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitShiftExpression(JavaScriptParserJsx.BitShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParenthesizedExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(JavaScriptParserJsx.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AdditiveExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(JavaScriptParserJsx.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelationalExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(JavaScriptParserJsx.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostIncrementExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncrementExpression(JavaScriptParserJsx.PostIncrementExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code YieldExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldExpression(JavaScriptParserJsx.YieldExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitNotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitNotExpression(JavaScriptParserJsx.BitNotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NewExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(JavaScriptParserJsx.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralExpression(JavaScriptParserJsx.LiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayLiteralExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralExpression(JavaScriptParserJsx.ArrayLiteralExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberDotExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberDotExpression(JavaScriptParserJsx.MemberDotExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ClassExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassExpression(JavaScriptParserJsx.ClassExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MemberIndexExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberIndexExpression(JavaScriptParserJsx.MemberIndexExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IdentifierExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierExpression(JavaScriptParserJsx.IdentifierExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitAndExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitAndExpression(JavaScriptParserJsx.BitAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BitOrExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitOrExpression(JavaScriptParserJsx.BitOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AssignmentOperatorExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperatorExpression(JavaScriptParserJsx.AssignmentOperatorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VoidExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoidExpression(JavaScriptParserJsx.VoidExpressionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CoalesceExpression}
	 * labeled alternative in {@link JavaScriptParserJsx#singleExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCoalesceExpression(JavaScriptParserJsx.CoalesceExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxElements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxElements(JavaScriptParserJsx.JsxElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxElementBegin}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxElementBegin(JavaScriptParserJsx.JsxElementBeginContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxElement(JavaScriptParserJsx.JsxElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxSelfClosingElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxSelfClosingElement(JavaScriptParserJsx.JsxSelfClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxOpeningElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxOpeningElement(JavaScriptParserJsx.JsxOpeningElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxClosingElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxClosingElement(JavaScriptParserJsx.JsxClosingElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxChildren}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxChildren(JavaScriptParserJsx.JsxChildrenContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxSelfClosingElementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxSelfClosingElementName(JavaScriptParserJsx.JsxSelfClosingElementNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxOpeningElementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxOpeningElementName(JavaScriptParserJsx.JsxOpeningElementNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxClosingElementName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxClosingElementName(JavaScriptParserJsx.JsxClosingElementNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxAttributes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxAttributes(JavaScriptParserJsx.JsxAttributesContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxSpreadAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxSpreadAttribute(JavaScriptParserJsx.JsxSpreadAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxAttribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxAttribute(JavaScriptParserJsx.JsxAttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxAttributeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxAttributeName(JavaScriptParserJsx.JsxAttributeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#jsxAttributeValue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJsxAttributeValue(JavaScriptParserJsx.JsxAttributeValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#assignable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignable(JavaScriptParserJsx.AssignableContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#objectLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectLiteral(JavaScriptParserJsx.ObjectLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#openBrace}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOpenBrace(JavaScriptParserJsx.OpenBraceContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#objectExpressionSequence}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpressionSequence(JavaScriptParserJsx.ObjectExpressionSequenceContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionDecl}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(JavaScriptParserJsx.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AnoymousFunctionDecl}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnoymousFunctionDecl(JavaScriptParserJsx.AnoymousFunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrowFunction}
	 * labeled alternative in {@link JavaScriptParserJsx#anoymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunction(JavaScriptParserJsx.ArrowFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#arrowFunctionParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunctionParameters(JavaScriptParserJsx.ArrowFunctionParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#arrowFunctionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrowFunctionBody(JavaScriptParserJsx.ArrowFunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(JavaScriptParserJsx.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(JavaScriptParserJsx.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#templateStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateStringLiteral(JavaScriptParserJsx.TemplateStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#templateStringAtom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTemplateStringAtom(JavaScriptParserJsx.TemplateStringAtomContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(JavaScriptParserJsx.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#bigintLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBigintLiteral(JavaScriptParserJsx.BigintLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#getter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetter(JavaScriptParserJsx.GetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#setter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetter(JavaScriptParserJsx.SetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#identifierName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierName(JavaScriptParserJsx.IdentifierNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(JavaScriptParserJsx.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#reservedWord}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReservedWord(JavaScriptParserJsx.ReservedWordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#keyword}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyword(JavaScriptParserJsx.KeywordContext ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#let_}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLet_(JavaScriptParserJsx.Let_Context ctx);
	/**
	 * Visit a parse tree produced by {@link JavaScriptParserJsx#eos}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEos(JavaScriptParserJsx.EosContext ctx);
}