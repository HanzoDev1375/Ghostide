// Generated from /storage/emulated/0/apk/kotlin-stylerin-0.0.1/src/main/antlr/KotlinParser.g4 by
// ANTLR 4.13.1
package io.github.rosemoe.sora.langs.kotlin;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced by {@link
 * KotlinParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for operations with no return
 *     type.
 */
public interface KotlinParserVisitor<T> extends ParseTreeVisitor<T> {
  /**
   * Visit a parse tree produced by {@link KotlinParser#kotlinFile}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitKotlinFile(KotlinParser.KotlinFileContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#script}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitScript(KotlinParser.ScriptContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#preamble}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPreamble(KotlinParser.PreambleContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#fileAnnotations}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFileAnnotations(KotlinParser.FileAnnotationsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#fileAnnotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFileAnnotation(KotlinParser.FileAnnotationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#fileAnnotationPart}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFileAnnotationPart(KotlinParser.FileAnnotationPartContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#bracketedFileAnnotationPart}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBracketedFileAnnotationPart(KotlinParser.BracketedFileAnnotationPartContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#packageHeader}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPackageHeader(KotlinParser.PackageHeaderContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#importList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportList(KotlinParser.ImportListContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#importHeader}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportHeader(KotlinParser.ImportHeaderContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#importAlias}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitImportAlias(KotlinParser.ImportAliasContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#topLevelObject}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTopLevelObject(KotlinParser.TopLevelObjectContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#classDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassDeclaration(KotlinParser.ClassDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#primaryConstructor}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrimaryConstructor(KotlinParser.PrimaryConstructorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#classParameters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassParameters(KotlinParser.ClassParametersContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#classParameter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassParameter(KotlinParser.ClassParameterContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#delegationSpecifiers}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDelegationSpecifiers(KotlinParser.DelegationSpecifiersContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#delegationSpecifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDelegationSpecifier(KotlinParser.DelegationSpecifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#constructorInvocation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstructorInvocation(KotlinParser.ConstructorInvocationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#explicitDelegation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExplicitDelegation(KotlinParser.ExplicitDelegationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#classBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassBody(KotlinParser.ClassBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#classMemberDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassMemberDeclaration(KotlinParser.ClassMemberDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#anonymousInitializer}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnonymousInitializer(KotlinParser.AnonymousInitializerContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#secondaryConstructor}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSecondaryConstructor(KotlinParser.SecondaryConstructorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#constructorDelegationCall}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConstructorDelegationCall(KotlinParser.ConstructorDelegationCallContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#enumClassBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumClassBody(KotlinParser.EnumClassBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#enumEntries}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumEntries(KotlinParser.EnumEntriesContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#enumEntry}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEnumEntry(KotlinParser.EnumEntryContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionDeclaration(KotlinParser.FunctionDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#firstTypeOfFuncDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFirstTypeOfFuncDeclaration(KotlinParser.FirstTypeOfFuncDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionValueParameters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionValueParameters(KotlinParser.FunctionValueParametersContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionValueParameter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionValueParameter(KotlinParser.FunctionValueParameterContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#parameter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParameter(KotlinParser.ParameterContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#receiverType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitReceiverType(KotlinParser.ReceiverTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionBody(KotlinParser.FunctionBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#objectDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObjectDeclaration(KotlinParser.ObjectDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#companionObject}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCompanionObject(KotlinParser.CompanionObjectContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#propertyDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertyDeclaration(KotlinParser.PropertyDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#getterPartOfPropertyDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGetterPartOfPropertyDeclaration(KotlinParser.GetterPartOfPropertyDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#setterPartOfPropertyDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSetterPartOfPropertyDeclaration(KotlinParser.SetterPartOfPropertyDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#multiVariableDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiVariableDeclaration(KotlinParser.MultiVariableDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#variableDeclaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVariableDeclaration(KotlinParser.VariableDeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#getter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitGetter(KotlinParser.GetterContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#setter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSetter(KotlinParser.SetterContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeAlias}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeAlias(KotlinParser.TypeAliasContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeParameters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeParameters(KotlinParser.TypeParametersContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeParameter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeParameter(KotlinParser.TypeParameterContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#type}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitType(KotlinParser.TypeContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeModifierList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeModifierList(KotlinParser.TypeModifierListContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#annotationsOrSuspend}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotationsOrSuspend(KotlinParser.AnnotationsOrSuspendContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#parenthesizedType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParenthesizedType(KotlinParser.ParenthesizedTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#nullableType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNullableType(KotlinParser.NullableTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeReference}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeReference(KotlinParser.TypeReferenceContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionType(KotlinParser.FunctionTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionTypeReceiver}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionTypeReceiver(KotlinParser.FunctionTypeReceiverContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#userType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUserType(KotlinParser.UserTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#simpleUserType}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSimpleUserType(KotlinParser.SimpleUserTypeContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionTypeParameters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionTypeParameters(KotlinParser.FunctionTypeParametersContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#firstParamOrTypeOfFuncTypeParams}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFirstParamOrTypeOfFuncTypeParams(KotlinParser.FirstParamOrTypeOfFuncTypeParamsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#secondParamOrTypeOfFuncTypeParams}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSecondParamOrTypeOfFuncTypeParams(
      KotlinParser.SecondParamOrTypeOfFuncTypeParamsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeConstraints}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeConstraints(KotlinParser.TypeConstraintsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeConstraint}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeConstraint(KotlinParser.TypeConstraintContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#block}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBlock(KotlinParser.BlockContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#statements}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatements(KotlinParser.StatementsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#statement}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStatement(KotlinParser.StatementContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#blockLevelExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitBlockLevelExpression(KotlinParser.BlockLevelExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#declaration}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDeclaration(KotlinParser.DeclarationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#expression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitExpression(KotlinParser.ExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#disjunction}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDisjunction(KotlinParser.DisjunctionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#conjunction}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConjunction(KotlinParser.ConjunctionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#equalityComparison}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEqualityComparison(KotlinParser.EqualityComparisonContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#comparison}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparison(KotlinParser.ComparisonContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#namedInfix}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamedInfix(KotlinParser.NamedInfixContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#elvisExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitElvisExpression(KotlinParser.ElvisExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#infixFunctionCall}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInfixFunctionCall(KotlinParser.InfixFunctionCallContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#rangeExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRangeExpression(KotlinParser.RangeExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#additiveExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAdditiveExpression(KotlinParser.AdditiveExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#multiplicativeExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiplicativeExpression(KotlinParser.MultiplicativeExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeRHS}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeRHS(KotlinParser.TypeRHSContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#prefixUnaryExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrefixUnaryExpression(KotlinParser.PrefixUnaryExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#postfixUnaryExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPostfixUnaryExpression(KotlinParser.PostfixUnaryExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#atomicExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAtomicExpression(KotlinParser.AtomicExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#parenthesizedExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParenthesizedExpression(KotlinParser.ParenthesizedExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#callSuffix}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallSuffix(KotlinParser.CallSuffixContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#annotatedLambda}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotatedLambda(KotlinParser.AnnotatedLambdaContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#arrayAccess}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitArrayAccess(KotlinParser.ArrayAccessContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#valueArguments}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValueArguments(KotlinParser.ValueArgumentsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeArguments}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeArguments(KotlinParser.TypeArgumentsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeProjection}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeProjection(KotlinParser.TypeProjectionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeProjectionModifierList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeProjectionModifierList(KotlinParser.TypeProjectionModifierListContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#valueArgument}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitValueArgument(KotlinParser.ValueArgumentContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#namedParam}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitNamedParam(KotlinParser.NamedParamContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#literalConstant}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLiteralConstant(KotlinParser.LiteralConstantContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#stringLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitStringLiteral(KotlinParser.StringLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#lineStringLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLineStringLiteral(KotlinParser.LineStringLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#lineStringContentOrExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLineStringContentOrExpression(KotlinParser.LineStringContentOrExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#multiLineStringLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiLineStringLiteral(KotlinParser.MultiLineStringLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#multiLineStringLiteralPart}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiLineStringLiteralPart(KotlinParser.MultiLineStringLiteralPartContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#lineStringContent}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLineStringContent(KotlinParser.LineStringContentContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#lineStringExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLineStringExpression(KotlinParser.LineStringExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#multiLineStringContent}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiLineStringContent(KotlinParser.MultiLineStringContentContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#multiLineStringExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiLineStringExpression(KotlinParser.MultiLineStringExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionLiteral(KotlinParser.FunctionLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#lambdaParameters}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLambdaParameters(KotlinParser.LambdaParametersContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#lambdaParameter}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLambdaParameter(KotlinParser.LambdaParameterContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#objectLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitObjectLiteral(KotlinParser.ObjectLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#collectionLiteral}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCollectionLiteral(KotlinParser.CollectionLiteralContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#thisExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitThisExpression(KotlinParser.ThisExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#superExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSuperExpression(KotlinParser.SuperExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#conditionalExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitConditionalExpression(KotlinParser.ConditionalExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#ifExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIfExpression(KotlinParser.IfExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#firstControlStructureBodyOfIfExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFirstControlStructureBodyOfIfExpression(
      KotlinParser.FirstControlStructureBodyOfIfExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#controlStructureBody}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitControlStructureBody(KotlinParser.ControlStructureBodyContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#whenExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWhenExpression(KotlinParser.WhenExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#whenEntry}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWhenEntry(KotlinParser.WhenEntryContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#whenCondition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWhenCondition(KotlinParser.WhenConditionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#rangeTest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitRangeTest(KotlinParser.RangeTestContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeTest}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeTest(KotlinParser.TypeTestContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#tryExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTryExpression(KotlinParser.TryExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#catchBlock}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCatchBlock(KotlinParser.CatchBlockContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#finallyBlock}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFinallyBlock(KotlinParser.FinallyBlockContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#loopExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLoopExpression(KotlinParser.LoopExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#forExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitForExpression(KotlinParser.ForExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#whileExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitWhileExpression(KotlinParser.WhileExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#doWhileExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitDoWhileExpression(KotlinParser.DoWhileExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#jumpExpression}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitJumpExpression(KotlinParser.JumpExpressionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#callableReference}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitCallableReference(KotlinParser.CallableReferenceContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#assignmentOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAssignmentOperator(KotlinParser.AssignmentOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#equalityOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitEqualityOperation(KotlinParser.EqualityOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#comparisonOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitComparisonOperator(KotlinParser.ComparisonOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#inOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInOperator(KotlinParser.InOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#isOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIsOperator(KotlinParser.IsOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#additiveOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAdditiveOperator(KotlinParser.AdditiveOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#multiplicativeOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMultiplicativeOperation(KotlinParser.MultiplicativeOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeOperation(KotlinParser.TypeOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#colonTypeOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitColonTypeOperation(KotlinParser.ColonTypeOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#prefixUnaryOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPrefixUnaryOperation(KotlinParser.PrefixUnaryOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#postfixUnaryOperation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPostfixUnaryOperation(KotlinParser.PostfixUnaryOperationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#memberAccessOperator}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMemberAccessOperator(KotlinParser.MemberAccessOperatorContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#modifierList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModifierList(KotlinParser.ModifierListContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#annotationsOrModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotationsOrModifier(KotlinParser.AnnotationsOrModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#modifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitModifier(KotlinParser.ModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#classModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitClassModifier(KotlinParser.ClassModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#memberModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitMemberModifier(KotlinParser.MemberModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#visibilityModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVisibilityModifier(KotlinParser.VisibilityModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#varianceAnnotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitVarianceAnnotation(KotlinParser.VarianceAnnotationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#functionModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitFunctionModifier(KotlinParser.FunctionModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#propertyModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitPropertyModifier(KotlinParser.PropertyModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#inheritanceModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitInheritanceModifier(KotlinParser.InheritanceModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#parameterModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitParameterModifier(KotlinParser.ParameterModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#typeParameterModifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitTypeParameterModifier(KotlinParser.TypeParameterModifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#labelDefinition}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitLabelDefinition(KotlinParser.LabelDefinitionContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#annotations}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotations(KotlinParser.AnnotationsContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#annotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotation(KotlinParser.AnnotationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#annotationList}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotationList(KotlinParser.AnnotationListContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#annotationUseSiteTarget}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnnotationUseSiteTarget(KotlinParser.AnnotationUseSiteTargetContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#unescapedAnnotation}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitUnescapedAnnotation(KotlinParser.UnescapedAnnotationContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#identifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitIdentifier(KotlinParser.IdentifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#simpleIdentifier}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSimpleIdentifier(KotlinParser.SimpleIdentifierContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#semi}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitSemi(KotlinParser.SemiContext ctx);

  /**
   * Visit a parse tree produced by {@link KotlinParser#anysemi}.
   *
   * @param ctx the parse tree
   * @return the visitor result
   */
  T visitAnysemi(KotlinParser.AnysemiContext ctx);
}
