// Generated from Dart2Parser.g4 by ANTLR 4.13.2
package io.github.rosemoe.sora.langs.dart;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link Dart2Parser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface Dart2ParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(Dart2Parser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#additiveOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperator(Dart2Parser.AdditiveOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#argumentList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentList(Dart2Parser.ArgumentListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#argumentPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgumentPart(Dart2Parser.ArgumentPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(Dart2Parser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#asOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAsOperator(Dart2Parser.AsOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#assertion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertion(Dart2Parser.AssertionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#assertStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssertStatement(Dart2Parser.AssertStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#assignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableExpression(Dart2Parser.AssignableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#assignableSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableSelector(Dart2Parser.AssignableSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#assignableSelectorPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableSelectorPart(Dart2Parser.AssignableSelectorPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentOperator(Dart2Parser.AssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#awaitExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAwaitExpression(Dart2Parser.AwaitExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#binaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBinaryOperator(Dart2Parser.BinaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#bitwiseAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseAndExpression(Dart2Parser.BitwiseAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#bitwiseOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOperator(Dart2Parser.BitwiseOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#bitwiseOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseOrExpression(Dart2Parser.BitwiseOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#bitwiseXorExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBitwiseXorExpression(Dart2Parser.BitwiseXorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(Dart2Parser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#booleanLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanLiteral(Dart2Parser.BooleanLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#breakStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreakStatement(Dart2Parser.BreakStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#cascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascade(Dart2Parser.CascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#cascadeAssignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeAssignment(Dart2Parser.CascadeAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#cascadeSection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeSection(Dart2Parser.CascadeSectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#cascadeSectionTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeSectionTail(Dart2Parser.CascadeSectionTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#cascadeSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCascadeSelector(Dart2Parser.CascadeSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#catchPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchPart(Dart2Parser.CatchPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(Dart2Parser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(Dart2Parser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#combinator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCombinator(Dart2Parser.CombinatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#compilationUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompilationUnit(Dart2Parser.CompilationUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#compoundAssignmentOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompoundAssignmentOperator(Dart2Parser.CompoundAssignmentOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalExpression(Dart2Parser.ConditionalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#configurableUri}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfigurableUri(Dart2Parser.ConfigurableUriContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#configurationUri}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConfigurationUri(Dart2Parser.ConfigurationUriContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#constantConstructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstantConstructorSignature(Dart2Parser.ConstantConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#constObjectExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstObjectExpression(Dart2Parser.ConstObjectExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#constructorDesignation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDesignation(Dart2Parser.ConstructorDesignationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#constructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorInvocation(Dart2Parser.ConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#constructorName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorName(Dart2Parser.ConstructorNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#constructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorSignature(Dart2Parser.ConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#continueStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinueStatement(Dart2Parser.ContinueStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(Dart2Parser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#declaredIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaredIdentifier(Dart2Parser.DeclaredIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#defaultCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultCase(Dart2Parser.DefaultCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#defaultFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultFormalParameter(Dart2Parser.DefaultFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#defaultNamedParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefaultNamedParameter(Dart2Parser.DefaultNamedParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#doStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoStatement(Dart2Parser.DoStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#dottedIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDottedIdentifierList(Dart2Parser.DottedIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#element}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElement(Dart2Parser.ElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#elements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElements(Dart2Parser.ElementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#enumEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEntry(Dart2Parser.EnumEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#enumType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumType(Dart2Parser.EnumTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#equalityExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpression(Dart2Parser.EqualityExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#equalityOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOperator(Dart2Parser.EqualityOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(Dart2Parser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#expressionElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionElement(Dart2Parser.ExpressionElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#expressionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(Dart2Parser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#expressionStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionStatement(Dart2Parser.ExpressionStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#expressionWithoutCascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionWithoutCascade(Dart2Parser.ExpressionWithoutCascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#extensionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExtensionDeclaration(Dart2Parser.ExtensionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#factoryConstructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactoryConstructorSignature(Dart2Parser.FactoryConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#fieldFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldFormalParameter(Dart2Parser.FieldFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#fieldInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFieldInitializer(Dart2Parser.FieldInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#finalConstVarOrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinalConstVarOrType(Dart2Parser.FinalConstVarOrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#finallyPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyPart(Dart2Parser.FinallyPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#forElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForElement(Dart2Parser.ForElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#forInitializerStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForInitializerStatement(Dart2Parser.ForInitializerStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#forLoopParts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForLoopParts(Dart2Parser.ForLoopPartsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#formalParameterList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterList(Dart2Parser.FormalParameterListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#formalParameterPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameterPart(Dart2Parser.FormalParameterPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(Dart2Parser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(Dart2Parser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpression(Dart2Parser.FunctionExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionExpressionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionExpressionBody(Dart2Parser.FunctionExpressionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionFormalParameter(Dart2Parser.FunctionFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionPrefix(Dart2Parser.FunctionPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionSignature(Dart2Parser.FunctionSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(Dart2Parser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionTypeAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeAlias(Dart2Parser.FunctionTypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionTypeTail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeTail(Dart2Parser.FunctionTypeTailContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#functionTypeTails}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeTails(Dart2Parser.FunctionTypeTailsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#getterSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetterSignature(Dart2Parser.GetterSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(Dart2Parser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#identifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifierList(Dart2Parser.IdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#ifElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfElement(Dart2Parser.IfElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#ifNullExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfNullExpression(Dart2Parser.IfNullExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#ifStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(Dart2Parser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#importOrExport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportOrExport(Dart2Parser.ImportOrExportContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#importSpecification}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportSpecification(Dart2Parser.ImportSpecificationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#incrementOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrementOperator(Dart2Parser.IncrementOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#initializedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedIdentifier(Dart2Parser.InitializedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#initializedIdentifierList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedIdentifierList(Dart2Parser.InitializedIdentifierListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#initializedVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializedVariableDeclaration(Dart2Parser.InitializedVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#initializerExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerExpression(Dart2Parser.InitializerExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#initializerListEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializerListEntry(Dart2Parser.InitializerListEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#initializers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInitializers(Dart2Parser.InitializersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#interfaces}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInterfaces(Dart2Parser.InterfacesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#isOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOperator(Dart2Parser.IsOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(Dart2Parser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#letExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLetExpression(Dart2Parser.LetExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#libraryDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibraryDeclaration(Dart2Parser.LibraryDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#libraryExport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibraryExport(Dart2Parser.LibraryExportContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#libraryImport}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibraryImport(Dart2Parser.LibraryImportContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#libraryName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLibraryName(Dart2Parser.LibraryNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#listLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitListLiteral(Dart2Parser.ListLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(Dart2Parser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#localFunctionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalFunctionDeclaration(Dart2Parser.LocalFunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalVariableDeclaration(Dart2Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#logicalAndExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalAndExpression(Dart2Parser.LogicalAndExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#logicalOrExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicalOrExpression(Dart2Parser.LogicalOrExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#mapElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMapElement(Dart2Parser.MapElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#metadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadata(Dart2Parser.MetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#metadatum}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMetadatum(Dart2Parser.MetadatumContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#methodSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodSignature(Dart2Parser.MethodSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#minusOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusOperator(Dart2Parser.MinusOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#mixinApplication}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinApplication(Dart2Parser.MixinApplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#mixinApplicationClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinApplicationClass(Dart2Parser.MixinApplicationClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#mixinDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixinDeclaration(Dart2Parser.MixinDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#mixins}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMixins(Dart2Parser.MixinsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#multilineString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultilineString(Dart2Parser.MultilineStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(Dart2Parser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOperator(Dart2Parser.MultiplicativeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#namedArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedArgument(Dart2Parser.NamedArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#namedFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedFormalParameters(Dart2Parser.NamedFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#namedParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedParameterType(Dart2Parser.NamedParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#namedParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedParameterTypes(Dart2Parser.NamedParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#negationOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegationOperator(Dart2Parser.NegationOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#newExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNewExpression(Dart2Parser.NewExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#nonLabelledStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNonLabelledStatement(Dart2Parser.NonLabelledStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#normalFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFormalParameter(Dart2Parser.NormalFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#normalFormalParameterNoMetadata}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFormalParameterNoMetadata(Dart2Parser.NormalFormalParameterNoMetadataContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#normalFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalFormalParameters(Dart2Parser.NormalFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#normalParameterType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalParameterType(Dart2Parser.NormalParameterTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#normalParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormalParameterTypes(Dart2Parser.NormalParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#nullLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullLiteral(Dart2Parser.NullLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#numericLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNumericLiteral(Dart2Parser.NumericLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#onPart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOnPart(Dart2Parser.OnPartContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperator(Dart2Parser.OperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#operatorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOperatorSignature(Dart2Parser.OperatorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#optionalOrNamedFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalOrNamedFormalParameters(Dart2Parser.OptionalOrNamedFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#optionalParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalParameterTypes(Dart2Parser.OptionalParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#optionalPositionalFormalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalPositionalFormalParameters(Dart2Parser.OptionalPositionalFormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#optionalPositionalParameterTypes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOptionalPositionalParameterTypes(Dart2Parser.OptionalPositionalParameterTypesContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#parameterTypeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterTypeList(Dart2Parser.ParameterTypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#partDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartDeclaration(Dart2Parser.PartDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#partDirective}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartDirective(Dart2Parser.PartDirectiveContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#partHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPartHeader(Dart2Parser.PartHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#postfixExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixExpression(Dart2Parser.PostfixExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#postfixOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixOperator(Dart2Parser.PostfixOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#prefixOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixOperator(Dart2Parser.PrefixOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(Dart2Parser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#qualifiedName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQualifiedName(Dart2Parser.QualifiedNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#redirectingFactoryConstructorSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirectingFactoryConstructorSignature(Dart2Parser.RedirectingFactoryConstructorSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#redirection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRedirection(Dart2Parser.RedirectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#relationalExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpression(Dart2Parser.RelationalExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#relationalOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalOperator(Dart2Parser.RelationalOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#reserved_word}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReserved_word(Dart2Parser.Reserved_wordContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#rethrowStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRethrowStatement(Dart2Parser.RethrowStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#returnStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(Dart2Parser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#selector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelector(Dart2Parser.SelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#setOrMapLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetOrMapLiteral(Dart2Parser.SetOrMapLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#setterSignature}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetterSignature(Dart2Parser.SetterSignatureContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#shiftExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftExpression(Dart2Parser.ShiftExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#shiftOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShiftOperator(Dart2Parser.ShiftOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#simpleFormalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleFormalParameter(Dart2Parser.SimpleFormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#singleLineString}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleLineString(Dart2Parser.SingleLineStringContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#spreadElement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSpreadElement(Dart2Parser.SpreadElementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(Dart2Parser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(Dart2Parser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#staticFinalDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticFinalDeclaration(Dart2Parser.StaticFinalDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#staticFinalDeclarationList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStaticFinalDeclarationList(Dart2Parser.StaticFinalDeclarationListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(Dart2Parser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#superclass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperclass(Dart2Parser.SuperclassContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#switchCase}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchCase(Dart2Parser.SwitchCaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#switchStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSwitchStatement(Dart2Parser.SwitchStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#symbolLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSymbolLiteral(Dart2Parser.SymbolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#thisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(Dart2Parser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#throwExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowExpression(Dart2Parser.ThrowExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#throwExpressionWithoutCascade}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThrowExpressionWithoutCascade(Dart2Parser.ThrowExpressionWithoutCascadeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#tildeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTildeOperator(Dart2Parser.TildeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#topLevelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTopLevelDeclaration(Dart2Parser.TopLevelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#tryStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryStatement(Dart2Parser.TryStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(Dart2Parser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeAlias(Dart2Parser.TypeAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(Dart2Parser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeCast}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeCast(Dart2Parser.TypeCastContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typedIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypedIdentifier(Dart2Parser.TypedIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeIdentifier(Dart2Parser.TypeIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeList(Dart2Parser.TypeListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeName}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeName(Dart2Parser.TypeNameContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeNotFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotFunction(Dart2Parser.TypeNotFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeNotVoid}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotVoid(Dart2Parser.TypeNotVoidContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeNotVoidList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotVoidList(Dart2Parser.TypeNotVoidListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeNotVoidNotFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotVoidNotFunction(Dart2Parser.TypeNotVoidNotFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeNotVoidNotFunctionList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeNotVoidNotFunctionList(Dart2Parser.TypeNotVoidNotFunctionListContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(Dart2Parser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(Dart2Parser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#typeTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTest(Dart2Parser.TypeTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#unaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpression(Dart2Parser.UnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#unconditionalAssignableSelector}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnconditionalAssignableSelector(Dart2Parser.UnconditionalAssignableSelectorContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#uri}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUri(Dart2Parser.UriContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#uriTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUriTest(Dart2Parser.UriTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#varOrType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarOrType(Dart2Parser.VarOrTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(Dart2Parser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#yieldEachStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldEachStatement(Dart2Parser.YieldEachStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link Dart2Parser#yieldStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitYieldStatement(Dart2Parser.YieldStatementContext ctx);
}