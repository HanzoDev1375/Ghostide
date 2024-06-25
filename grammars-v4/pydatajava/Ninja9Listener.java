// Generated from /storage/emulated/0/AndroidIDEProjects/Ghost-web-ide/grammars-v4/pydatajava/Ninja9.g4 by ANTLR 4.13.1
package org.antlr.parser.antlr4;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link Ninja9Parser}.
 */
public interface Ninja9Listener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompilationUnit(Ninja9Parser.CompilationUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#compilationUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompilationUnit(Ninja9Parser.CompilationUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#modifier}.
	 * @param ctx the parse tree
	 */
	void enterModifier(Ninja9Parser.ModifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#modifier}.
	 * @param ctx the parse tree
	 */
	void exitModifier(Ninja9Parser.ModifierContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteral(Ninja9Parser.IntegerLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IntegerLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteral(Ninja9Parser.IntegerLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointLiteral(Ninja9Parser.FloatingPointLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FloatingPointLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointLiteral(Ninja9Parser.FloatingPointLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBooleanLiteral(Ninja9Parser.BooleanLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BooleanLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBooleanLiteral(Ninja9Parser.BooleanLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterCharacterLiteral(Ninja9Parser.CharacterLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CharacterLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitCharacterLiteral(Ninja9Parser.CharacterLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(Ninja9Parser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code StringLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(Ninja9Parser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void enterNullLiteral(Ninja9Parser.NullLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NullLiteral}
	 * labeled alternative in {@link Ninja9Parser#literal}.
	 * @param ctx the parse tree
	 */
	void exitNullLiteral(Ninja9Parser.NullLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void enterPrimitiveType(Ninja9Parser.PrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primitiveType}.
	 * @param ctx the parse tree
	 */
	void exitPrimitiveType(Ninja9Parser.PrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void enterNumericType(Ninja9Parser.NumericTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#numericType}.
	 * @param ctx the parse tree
	 */
	void exitNumericType(Ninja9Parser.NumericTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void enterIntegralType(Ninja9Parser.IntegralTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#integralType}.
	 * @param ctx the parse tree
	 */
	void exitIntegralType(Ninja9Parser.IntegralTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void enterFloatingPointType(Ninja9Parser.FloatingPointTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#floatingPointType}.
	 * @param ctx the parse tree
	 */
	void exitFloatingPointType(Ninja9Parser.FloatingPointTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void enterReferenceType(Ninja9Parser.ReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#referenceType}.
	 * @param ctx the parse tree
	 */
	void exitReferenceType(Ninja9Parser.ReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classType}.
	 * @param ctx the parse tree
	 */
	void enterClassType(Ninja9Parser.ClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classType}.
	 * @param ctx the parse tree
	 */
	void exitClassType(Ninja9Parser.ClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void enterTypeVariable(Ninja9Parser.TypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeVariable}.
	 * @param ctx the parse tree
	 */
	void exitTypeVariable(Ninja9Parser.TypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(Ninja9Parser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(Ninja9Parser.ArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayTypeName}.
	 * @param ctx the parse tree
	 */
	void enterArrayTypeName(Ninja9Parser.ArrayTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayTypeName}.
	 * @param ctx the parse tree
	 */
	void exitArrayTypeName(Ninja9Parser.ArrayTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#dims}.
	 * @param ctx the parse tree
	 */
	void enterDims(Ninja9Parser.DimsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#dims}.
	 * @param ctx the parse tree
	 */
	void exitDims(Ninja9Parser.DimsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayDimension}.
	 * @param ctx the parse tree
	 */
	void enterArrayDimension(Ninja9Parser.ArrayDimensionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayDimension}.
	 * @param ctx the parse tree
	 */
	void exitArrayDimension(Ninja9Parser.ArrayDimensionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameter(Ninja9Parser.TypeParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeParameter}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameter(Ninja9Parser.TypeParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpleTypeBound}
	 * labeled alternative in {@link Ninja9Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeBound(Ninja9Parser.SimpleTypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpleTypeBound}
	 * labeled alternative in {@link Ninja9Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeBound(Ninja9Parser.SimpleTypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classTypeBound}
	 * labeled alternative in {@link Ninja9Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void enterClassTypeBound(Ninja9Parser.ClassTypeBoundContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classTypeBound}
	 * labeled alternative in {@link Ninja9Parser#typeBound}.
	 * @param ctx the parse tree
	 */
	void exitClassTypeBound(Ninja9Parser.ClassTypeBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void enterAdditionalBound(Ninja9Parser.AdditionalBoundContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#additionalBound}.
	 * @param ctx the parse tree
	 */
	void exitAdditionalBound(Ninja9Parser.AdditionalBoundContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void enterTypeArguments(Ninja9Parser.TypeArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeArguments}.
	 * @param ctx the parse tree
	 */
	void exitTypeArguments(Ninja9Parser.TypeArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgumentList(Ninja9Parser.TypeArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeArgumentList}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgumentList(Ninja9Parser.TypeArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void enterTypeArgument(Ninja9Parser.TypeArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeArgument}.
	 * @param ctx the parse tree
	 */
	void exitTypeArgument(Ninja9Parser.TypeArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void enterWildcard(Ninja9Parser.WildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#wildcard}.
	 * @param ctx the parse tree
	 */
	void exitWildcard(Ninja9Parser.WildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void enterWildcardBounds(Ninja9Parser.WildcardBoundsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#wildcardBounds}.
	 * @param ctx the parse tree
	 */
	void exitWildcardBounds(Ninja9Parser.WildcardBoundsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#wildcardType}.
	 * @param ctx the parse tree
	 */
	void enterWildcardType(Ninja9Parser.WildcardTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#wildcardType}.
	 * @param ctx the parse tree
	 */
	void exitWildcardType(Ninja9Parser.WildcardTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void enterTypeName(Ninja9Parser.TypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeName}.
	 * @param ctx the parse tree
	 */
	void exitTypeName(Ninja9Parser.TypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#propertyLookup}.
	 * @param ctx the parse tree
	 */
	void enterPropertyLookup(Ninja9Parser.PropertyLookupContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#propertyLookup}.
	 * @param ctx the parse tree
	 */
	void exitPropertyLookup(Ninja9Parser.PropertyLookupContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void enterPackageName(Ninja9Parser.PackageNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#packageName}.
	 * @param ctx the parse tree
	 */
	void exitPackageName(Ninja9Parser.PackageNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void enterExpressionName(Ninja9Parser.ExpressionNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#expressionName}.
	 * @param ctx the parse tree
	 */
	void exitExpressionName(Ninja9Parser.ExpressionNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterPackageDeclaration(Ninja9Parser.PackageDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#packageDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitPackageDeclaration(Ninja9Parser.PackageDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#import_static}.
	 * @param ctx the parse tree
	 */
	void enterImport_static(Ninja9Parser.Import_staticContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#import_static}.
	 * @param ctx the parse tree
	 */
	void exitImport_static(Ninja9Parser.Import_staticContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#import_wildcard}.
	 * @param ctx the parse tree
	 */
	void enterImport_wildcard(Ninja9Parser.Import_wildcardContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#import_wildcard}.
	 * @param ctx the parse tree
	 */
	void exitImport_wildcard(Ninja9Parser.Import_wildcardContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterImportDeclaration(Ninja9Parser.ImportDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#importDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitImportDeclaration(Ninja9Parser.ImportDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterTypeDeclaration(Ninja9Parser.TypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitTypeDeclaration(Ninja9Parser.TypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(Ninja9Parser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(Ninja9Parser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameterList(Ninja9Parser.TypeParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeParameterList}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameterList(Ninja9Parser.TypeParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void enterTypeParameters(Ninja9Parser.TypeParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#typeParameters}.
	 * @param ctx the parse tree
	 */
	void exitTypeParameters(Ninja9Parser.TypeParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#superclass}.
	 * @param ctx the parse tree
	 */
	void enterSuperclass(Ninja9Parser.SuperclassContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#superclass}.
	 * @param ctx the parse tree
	 */
	void exitSuperclass(Ninja9Parser.SuperclassContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void enterSuperinterfaces(Ninja9Parser.SuperinterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#superinterfaces}.
	 * @param ctx the parse tree
	 */
	void exitSuperinterfaces(Ninja9Parser.SuperinterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceTypeList(Ninja9Parser.InterfaceTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#interfaceTypeList}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceTypeList(Ninja9Parser.InterfaceTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(Ninja9Parser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(Ninja9Parser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassBodyDeclaration(Ninja9Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classBodyDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassBodyDeclaration(Ninja9Parser.ClassBodyDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterFieldDeclaration(Ninja9Parser.FieldDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#fieldDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitFieldDeclaration(Ninja9Parser.FieldDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorList(Ninja9Parser.VariableDeclaratorListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#variableDeclaratorList}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorList(Ninja9Parser.VariableDeclaratorListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclarator(Ninja9Parser.VariableDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#variableDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclarator(Ninja9Parser.VariableDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaratorId(Ninja9Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#variableDeclaratorId}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaratorId(Ninja9Parser.VariableDeclaratorIdContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializer(Ninja9Parser.VariableInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#variableInitializer}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializer(Ninja9Parser.VariableInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void enterUnannType(Ninja9Parser.UnannTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannType}.
	 * @param ctx the parse tree
	 */
	void exitUnannType(Ninja9Parser.UnannTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void enterUnannPrimitiveType(Ninja9Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannPrimitiveType}.
	 * @param ctx the parse tree
	 */
	void exitUnannPrimitiveType(Ninja9Parser.UnannPrimitiveTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannReferenceType(Ninja9Parser.UnannReferenceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannReferenceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannReferenceType(Ninja9Parser.UnannReferenceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassOrInterfaceType(Ninja9Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassOrInterfaceType(Ninja9Parser.UnannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType(Ninja9Parser.UnannClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannClassType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType(Ninja9Parser.UnannClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lf_unannClassOrInterfaceType(Ninja9Parser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannClassType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lf_unannClassOrInterfaceType(Ninja9Parser.UnannClassType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannClassType_lfno_unannClassOrInterfaceType(Ninja9Parser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannClassType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannClassType_lfno_unannClassOrInterfaceType(Ninja9Parser.UnannClassType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lf_unannClassOrInterfaceType(Ninja9Parser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannInterfaceType_lf_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lf_unannClassOrInterfaceType(Ninja9Parser.UnannInterfaceType_lf_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void enterUnannInterfaceType_lfno_unannClassOrInterfaceType(Ninja9Parser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannInterfaceType_lfno_unannClassOrInterfaceType}.
	 * @param ctx the parse tree
	 */
	void exitUnannInterfaceType_lfno_unannClassOrInterfaceType(Ninja9Parser.UnannInterfaceType_lfno_unannClassOrInterfaceTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void enterUnannTypeVariable(Ninja9Parser.UnannTypeVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannTypeVariable}.
	 * @param ctx the parse tree
	 */
	void exitUnannTypeVariable(Ninja9Parser.UnannTypeVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void enterUnannArrayType(Ninja9Parser.UnannArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unannArrayType}.
	 * @param ctx the parse tree
	 */
	void exitUnannArrayType(Ninja9Parser.UnannArrayTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(Ninja9Parser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(Ninja9Parser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void enterMethodHeader(Ninja9Parser.MethodHeaderContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodHeader}.
	 * @param ctx the parse tree
	 */
	void exitMethodHeader(Ninja9Parser.MethodHeaderContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#result}.
	 * @param ctx the parse tree
	 */
	void enterResult(Ninja9Parser.ResultContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#result}.
	 * @param ctx the parse tree
	 */
	void exitResult(Ninja9Parser.ResultContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclarator(Ninja9Parser.MethodDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclarator(Ninja9Parser.MethodDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameterList(Ninja9Parser.FormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#formalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameterList(Ninja9Parser.FormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(Ninja9Parser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(Ninja9Parser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(Ninja9Parser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(Ninja9Parser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void enterLastFormalParameter(Ninja9Parser.LastFormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#lastFormalParameter}.
	 * @param ctx the parse tree
	 */
	void exitLastFormalParameter(Ninja9Parser.LastFormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void enterReceiverParameter(Ninja9Parser.ReceiverParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#receiverParameter}.
	 * @param ctx the parse tree
	 */
	void exitReceiverParameter(Ninja9Parser.ReceiverParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#throws_}.
	 * @param ctx the parse tree
	 */
	void enterThrows_(Ninja9Parser.Throws_Context ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#throws_}.
	 * @param ctx the parse tree
	 */
	void exitThrows_(Ninja9Parser.Throws_Context ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void enterExceptionTypeList(Ninja9Parser.ExceptionTypeListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#exceptionTypeList}.
	 * @param ctx the parse tree
	 */
	void exitExceptionTypeList(Ninja9Parser.ExceptionTypeListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void enterExceptionType(Ninja9Parser.ExceptionTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#exceptionType}.
	 * @param ctx the parse tree
	 */
	void exitExceptionType(Ninja9Parser.ExceptionTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void enterMethodBody(Ninja9Parser.MethodBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodBody}.
	 * @param ctx the parse tree
	 */
	void exitMethodBody(Ninja9Parser.MethodBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void enterInstanceInitializer(Ninja9Parser.InstanceInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#instanceInitializer}.
	 * @param ctx the parse tree
	 */
	void exitInstanceInitializer(Ninja9Parser.InstanceInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void enterStaticInitializer(Ninja9Parser.StaticInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#staticInitializer}.
	 * @param ctx the parse tree
	 */
	void exitStaticInitializer(Ninja9Parser.StaticInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclaration(Ninja9Parser.ConstructorDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#constructorDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclaration(Ninja9Parser.ConstructorDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void enterConstructorDeclarator(Ninja9Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#constructorDeclarator}.
	 * @param ctx the parse tree
	 */
	void exitConstructorDeclarator(Ninja9Parser.ConstructorDeclaratorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void enterSimpleTypeName(Ninja9Parser.SimpleTypeNameContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#simpleTypeName}.
	 * @param ctx the parse tree
	 */
	void exitSimpleTypeName(Ninja9Parser.SimpleTypeNameContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void enterConstructorBody(Ninja9Parser.ConstructorBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#constructorBody}.
	 * @param ctx the parse tree
	 */
	void exitConstructorBody(Ninja9Parser.ConstructorBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void enterExplicitConstructorInvocation(Ninja9Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#explicitConstructorInvocation}.
	 * @param ctx the parse tree
	 */
	void exitExplicitConstructorInvocation(Ninja9Parser.ExplicitConstructorInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterEnumDeclaration(Ninja9Parser.EnumDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#enumDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitEnumDeclaration(Ninja9Parser.EnumDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void enterEnumBody(Ninja9Parser.EnumBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#enumBody}.
	 * @param ctx the parse tree
	 */
	void exitEnumBody(Ninja9Parser.EnumBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstantList(Ninja9Parser.EnumConstantListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#enumConstantList}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstantList(Ninja9Parser.EnumConstantListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void enterEnumConstant(Ninja9Parser.EnumConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#enumConstant}.
	 * @param ctx the parse tree
	 */
	void exitEnumConstant(Ninja9Parser.EnumConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void enterEnumBodyDeclarations(Ninja9Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#enumBodyDeclarations}.
	 * @param ctx the parse tree
	 */
	void exitEnumBodyDeclarations(Ninja9Parser.EnumBodyDeclarationsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceDeclaration(Ninja9Parser.InterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#interfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceDeclaration(Ninja9Parser.InterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterNormalInterfaceDeclaration(Ninja9Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#normalInterfaceDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitNormalInterfaceDeclaration(Ninja9Parser.NormalInterfaceDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void enterExtendsInterfaces(Ninja9Parser.ExtendsInterfacesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#extendsInterfaces}.
	 * @param ctx the parse tree
	 */
	void exitExtendsInterfaces(Ninja9Parser.ExtendsInterfacesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceBody(Ninja9Parser.InterfaceBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#interfaceBody}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceBody(Ninja9Parser.InterfaceBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMemberDeclaration(Ninja9Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#interfaceMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMemberDeclaration(Ninja9Parser.InterfaceMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterConstantDeclaration(Ninja9Parser.ConstantDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#constantDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitConstantDeclaration(Ninja9Parser.ConstantDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterInterfaceMethodDeclaration(Ninja9Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#interfaceMethodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitInterfaceMethodDeclaration(Ninja9Parser.InterfaceMethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeDeclaration(Ninja9Parser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#annotationTypeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeDeclaration(Ninja9Parser.AnnotationTypeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeBody(Ninja9Parser.AnnotationTypeBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#annotationTypeBody}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeBody(Ninja9Parser.AnnotationTypeBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeMemberDeclaration(Ninja9Parser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#annotationTypeMemberDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeMemberDeclaration(Ninja9Parser.AnnotationTypeMemberDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAnnotationTypeElementDeclaration(Ninja9Parser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#annotationTypeElementDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAnnotationTypeElementDeclaration(Ninja9Parser.AnnotationTypeElementDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void enterDefaultValue(Ninja9Parser.DefaultValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#defaultValue}.
	 * @param ctx the parse tree
	 */
	void exitDefaultValue(Ninja9Parser.DefaultValueContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(Ninja9Parser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(Ninja9Parser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterNormalAnnotation(Ninja9Parser.NormalAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#normalAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitNormalAnnotation(Ninja9Parser.NormalAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePairList(Ninja9Parser.ElementValuePairListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#elementValuePairList}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePairList(Ninja9Parser.ElementValuePairListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void enterElementValuePair(Ninja9Parser.ElementValuePairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#elementValuePair}.
	 * @param ctx the parse tree
	 */
	void exitElementValuePair(Ninja9Parser.ElementValuePairContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elementValueExpression}
	 * labeled alternative in {@link Ninja9Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValueExpression(Ninja9Parser.ElementValueExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elementValueExpression}
	 * labeled alternative in {@link Ninja9Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValueExpression(Ninja9Parser.ElementValueExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elementValueArray}
	 * labeled alternative in {@link Ninja9Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArray(Ninja9Parser.ElementValueArrayContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elementValueArray}
	 * labeled alternative in {@link Ninja9Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArray(Ninja9Parser.ElementValueArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code elementValueAnnotation}
	 * labeled alternative in {@link Ninja9Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void enterElementValueAnnotation(Ninja9Parser.ElementValueAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code elementValueAnnotation}
	 * labeled alternative in {@link Ninja9Parser#elementValue}.
	 * @param ctx the parse tree
	 */
	void exitElementValueAnnotation(Ninja9Parser.ElementValueAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterElementValueArrayInitializer(Ninja9Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#elementValueArrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitElementValueArrayInitializer(Ninja9Parser.ElementValueArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void enterElementValueList(Ninja9Parser.ElementValueListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#elementValueList}.
	 * @param ctx the parse tree
	 */
	void exitElementValueList(Ninja9Parser.ElementValueListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterMarkerAnnotation(Ninja9Parser.MarkerAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#markerAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitMarkerAnnotation(Ninja9Parser.MarkerAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void enterSingleElementAnnotation(Ninja9Parser.SingleElementAnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#singleElementAnnotation}.
	 * @param ctx the parse tree
	 */
	void exitSingleElementAnnotation(Ninja9Parser.SingleElementAnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void enterArrayInitializer(Ninja9Parser.ArrayInitializerContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayInitializer}.
	 * @param ctx the parse tree
	 */
	void exitArrayInitializer(Ninja9Parser.ArrayInitializerContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void enterVariableInitializerList(Ninja9Parser.VariableInitializerListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#variableInitializerList}.
	 * @param ctx the parse tree
	 */
	void exitVariableInitializerList(Ninja9Parser.VariableInitializerListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(Ninja9Parser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(Ninja9Parser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatements(Ninja9Parser.BlockStatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#blockStatements}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatements(Ninja9Parser.BlockStatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(Ninja9Parser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#blockStatement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(Ninja9Parser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclarationStatement(Ninja9Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#localVariableDeclarationStatement}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclarationStatement(Ninja9Parser.LocalVariableDeclarationStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLocalVariableDeclaration(Ninja9Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#localVariableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLocalVariableDeclaration(Ninja9Parser.LocalVariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(Ninja9Parser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(Ninja9Parser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterStatementNoShortIf(Ninja9Parser.StatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitStatementNoShortIf(Ninja9Parser.StatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void enterStatementWithoutTrailingSubstatement(Ninja9Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementWithoutTrailingSubstatement}.
	 * @param ctx the parse tree
	 */
	void exitStatementWithoutTrailingSubstatement(Ninja9Parser.StatementWithoutTrailingSubstatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStatement(Ninja9Parser.EmptyStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#emptyStatement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStatement(Ninja9Parser.EmptyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatement(Ninja9Parser.LabeledStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#labeledStatement}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatement(Ninja9Parser.LabeledStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterLabeledStatementNoShortIf(Ninja9Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#labeledStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitLabeledStatementNoShortIf(Ninja9Parser.LabeledStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(Ninja9Parser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(Ninja9Parser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpression(Ninja9Parser.StatementExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementExpression}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpression(Ninja9Parser.StatementExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementAssignment_nocol}.
	 * @param ctx the parse tree
	 */
	void enterStatementAssignment_nocol(Ninja9Parser.StatementAssignment_nocolContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementAssignment_nocol}.
	 * @param ctx the parse tree
	 */
	void exitStatementAssignment_nocol(Ninja9Parser.StatementAssignment_nocolContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementPre_nocol}.
	 * @param ctx the parse tree
	 */
	void enterStatementPre_nocol(Ninja9Parser.StatementPre_nocolContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementPre_nocol}.
	 * @param ctx the parse tree
	 */
	void exitStatementPre_nocol(Ninja9Parser.StatementPre_nocolContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementPost_nocol}.
	 * @param ctx the parse tree
	 */
	void enterStatementPost_nocol(Ninja9Parser.StatementPost_nocolContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementPost_nocol}.
	 * @param ctx the parse tree
	 */
	void exitStatementPost_nocol(Ninja9Parser.StatementPost_nocolContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementMethodInvocation_nocol}.
	 * @param ctx the parse tree
	 */
	void enterStatementMethodInvocation_nocol(Ninja9Parser.StatementMethodInvocation_nocolContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementMethodInvocation_nocol}.
	 * @param ctx the parse tree
	 */
	void exitStatementMethodInvocation_nocol(Ninja9Parser.StatementMethodInvocation_nocolContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementClassInstanceCreation_nocol}.
	 * @param ctx the parse tree
	 */
	void enterStatementClassInstanceCreation_nocol(Ninja9Parser.StatementClassInstanceCreation_nocolContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementClassInstanceCreation_nocol}.
	 * @param ctx the parse tree
	 */
	void exitStatementClassInstanceCreation_nocol(Ninja9Parser.StatementClassInstanceCreation_nocolContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenStatement(Ninja9Parser.IfThenStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#ifThenStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenStatement(Ninja9Parser.IfThenStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatement(Ninja9Parser.IfThenElseStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#ifThenElseStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatement(Ninja9Parser.IfThenElseStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElseStatementNoShortIf(Ninja9Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#ifThenElseStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElseStatementNoShortIf(Ninja9Parser.IfThenElseStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void enterAssertStatement(Ninja9Parser.AssertStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#assertStatement}.
	 * @param ctx the parse tree
	 */
	void exitAssertStatement(Ninja9Parser.AssertStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void enterSwitchStatement(Ninja9Parser.SwitchStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#switchStatement}.
	 * @param ctx the parse tree
	 */
	void exitSwitchStatement(Ninja9Parser.SwitchStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void enterSwitchBlock(Ninja9Parser.SwitchBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#switchBlock}.
	 * @param ctx the parse tree
	 */
	void exitSwitchBlock(Ninja9Parser.SwitchBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#switchCase}.
	 * @param ctx the parse tree
	 */
	void enterSwitchCase(Ninja9Parser.SwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#switchCase}.
	 * @param ctx the parse tree
	 */
	void exitSwitchCase(Ninja9Parser.SwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#defaultSwitchCase}.
	 * @param ctx the parse tree
	 */
	void enterDefaultSwitchCase(Ninja9Parser.DefaultSwitchCaseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#defaultSwitchCase}.
	 * @param ctx the parse tree
	 */
	void exitDefaultSwitchCase(Ninja9Parser.DefaultSwitchCaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(Ninja9Parser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(Ninja9Parser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatementNoShortIf(Ninja9Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#whileStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatementNoShortIf(Ninja9Parser.WhileStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void enterDoStatement(Ninja9Parser.DoStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#doStatement}.
	 * @param ctx the parse tree
	 */
	void exitDoStatement(Ninja9Parser.DoStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void enterForStatement(Ninja9Parser.ForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#forStatement}.
	 * @param ctx the parse tree
	 */
	void exitForStatement(Ninja9Parser.ForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterForStatementNoShortIf(Ninja9Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#forStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitForStatementNoShortIf(Ninja9Parser.ForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatement(Ninja9Parser.BasicForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#basicForStatement}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatement(Ninja9Parser.BasicForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterBasicForStatementNoShortIf(Ninja9Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#basicForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitBasicForStatementNoShortIf(Ninja9Parser.BasicForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void enterForInit(Ninja9Parser.ForInitContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#forInit}.
	 * @param ctx the parse tree
	 */
	void exitForInit(Ninja9Parser.ForInitContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void enterForUpdate(Ninja9Parser.ForUpdateContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#forUpdate}.
	 * @param ctx the parse tree
	 */
	void exitForUpdate(Ninja9Parser.ForUpdateContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void enterStatementExpressionList(Ninja9Parser.StatementExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#statementExpressionList}.
	 * @param ctx the parse tree
	 */
	void exitStatementExpressionList(Ninja9Parser.StatementExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatement(Ninja9Parser.EnhancedForStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#enhancedForStatement}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatement(Ninja9Parser.EnhancedForStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void enterEnhancedForStatementNoShortIf(Ninja9Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#enhancedForStatementNoShortIf}.
	 * @param ctx the parse tree
	 */
	void exitEnhancedForStatementNoShortIf(Ninja9Parser.EnhancedForStatementNoShortIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStatement(Ninja9Parser.BreakStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#breakStatement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStatement(Ninja9Parser.BreakStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStatement(Ninja9Parser.ContinueStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#continueStatement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStatement(Ninja9Parser.ContinueStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(Ninja9Parser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(Ninja9Parser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void enterThrowStatement(Ninja9Parser.ThrowStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#throwStatement}.
	 * @param ctx the parse tree
	 */
	void exitThrowStatement(Ninja9Parser.ThrowStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void enterSynchronizedStatement(Ninja9Parser.SynchronizedStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#synchronizedStatement}.
	 * @param ctx the parse tree
	 */
	void exitSynchronizedStatement(Ninja9Parser.SynchronizedStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryStatement(Ninja9Parser.TryStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#tryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryStatement(Ninja9Parser.TryStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryCatchStatement}
	 * labeled alternative in {@link Ninja9Parser#basicTryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchStatement(Ninja9Parser.TryCatchStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryCatchStatement}
	 * labeled alternative in {@link Ninja9Parser#basicTryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchStatement(Ninja9Parser.TryCatchStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code tryCatchFinallyStatement}
	 * labeled alternative in {@link Ninja9Parser#basicTryStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryCatchFinallyStatement(Ninja9Parser.TryCatchFinallyStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code tryCatchFinallyStatement}
	 * labeled alternative in {@link Ninja9Parser#basicTryStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryCatchFinallyStatement(Ninja9Parser.TryCatchFinallyStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#catches}.
	 * @param ctx the parse tree
	 */
	void enterCatches(Ninja9Parser.CatchesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#catches}.
	 * @param ctx the parse tree
	 */
	void exitCatches(Ninja9Parser.CatchesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void enterCatchClause(Ninja9Parser.CatchClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#catchClause}.
	 * @param ctx the parse tree
	 */
	void exitCatchClause(Ninja9Parser.CatchClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#finally_}.
	 * @param ctx the parse tree
	 */
	void enterFinally_(Ninja9Parser.Finally_Context ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#finally_}.
	 * @param ctx the parse tree
	 */
	void exitFinally_(Ninja9Parser.Finally_Context ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void enterTryWithResourcesStatement(Ninja9Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#tryWithResourcesStatement}.
	 * @param ctx the parse tree
	 */
	void exitTryWithResourcesStatement(Ninja9Parser.TryWithResourcesStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void enterResourceSpecification(Ninja9Parser.ResourceSpecificationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#resourceSpecification}.
	 * @param ctx the parse tree
	 */
	void exitResourceSpecification(Ninja9Parser.ResourceSpecificationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void enterResourceList(Ninja9Parser.ResourceListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#resourceList}.
	 * @param ctx the parse tree
	 */
	void exitResourceList(Ninja9Parser.ResourceListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#resource}.
	 * @param ctx the parse tree
	 */
	void enterResource(Ninja9Parser.ResourceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#resource}.
	 * @param ctx the parse tree
	 */
	void exitResource(Ninja9Parser.ResourceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(Ninja9Parser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(Ninja9Parser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#expressionParenthesis}.
	 * @param ctx the parse tree
	 */
	void enterExpressionParenthesis(Ninja9Parser.ExpressionParenthesisContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#expressionParenthesis}.
	 * @param ctx the parse tree
	 */
	void exitExpressionParenthesis(Ninja9Parser.ExpressionParenthesisContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_arrayAccess(Ninja9Parser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_arrayAccess(Ninja9Parser.PrimaryNoNewArray_lf_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_arrayAccess(Ninja9Parser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_arrayAccess(Ninja9Parser.PrimaryNoNewArray_lfno_arrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary(Ninja9Parser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary(Ninja9Parser.PrimaryNoNewArray_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(Ninja9Parser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primary(Ninja9Parser.PrimaryNoNewArray_lf_primary_lf_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(Ninja9Parser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primary(Ninja9Parser.PrimaryNoNewArray_lf_primary_lfno_arrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryClassType}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryClassType(Ninja9Parser.PrimaryClassTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryClassType}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryClassType(Ninja9Parser.PrimaryClassTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryClassTypeAlternates}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryClassTypeAlternates(Ninja9Parser.PrimaryClassTypeAlternatesContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryClassTypeAlternates}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryClassTypeAlternates(Ninja9Parser.PrimaryClassTypeAlternatesContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#voidType}.
	 * @param ctx the parse tree
	 */
	void enterVoidType(Ninja9Parser.VoidTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#voidType}.
	 * @param ctx the parse tree
	 */
	void exitVoidType(Ninja9Parser.VoidTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#bracketPair}.
	 * @param ctx the parse tree
	 */
	void enterBracketPair(Ninja9Parser.BracketPairContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#bracketPair}.
	 * @param ctx the parse tree
	 */
	void exitBracketPair(Ninja9Parser.BracketPairContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary(Ninja9Parser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary(Ninja9Parser.PrimaryNoNewArray_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(Ninja9Parser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primary(Ninja9Parser.PrimaryNoNewArray_lfno_primary_lf_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Ninja9Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#primaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primary(Ninja9Parser.PrimaryNoNewArray_lfno_primary_lfno_arrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void enterClassIdentifier(Ninja9Parser.ClassIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classIdentifier}.
	 * @param ctx the parse tree
	 */
	void exitClassIdentifier(Ninja9Parser.ClassIdentifierContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression(Ninja9Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classInstanceCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression(Ninja9Parser.ClassInstanceCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lf_primary(Ninja9Parser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classInstanceCreationExpression_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lf_primary(Ninja9Parser.ClassInstanceCreationExpression_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterClassInstanceCreationExpression_lfno_primary(Ninja9Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#classInstanceCreationExpression_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitClassInstanceCreationExpression_lfno_primary(Ninja9Parser.ClassInstanceCreationExpression_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ig22}
	 * labeled alternative in {@link Ninja9Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterIg22(Ninja9Parser.Ig22Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ig22}
	 * labeled alternative in {@link Ninja9Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitIg22(Ninja9Parser.Ig22Context ctx);
	/**
	 * Enter a parse tree produced by the {@code diamond}
	 * labeled alternative in {@link Ninja9Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void enterDiamond(Ninja9Parser.DiamondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code diamond}
	 * labeled alternative in {@link Ninja9Parser#typeArgumentsOrDiamond}.
	 * @param ctx the parse tree
	 */
	void exitDiamond(Ninja9Parser.DiamondContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess(Ninja9Parser.FieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#fieldAccess}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess(Ninja9Parser.FieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lf_primary(Ninja9Parser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#fieldAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lf_primary(Ninja9Parser.FieldAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterFieldAccess_lfno_primary(Ninja9Parser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#fieldAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitFieldAccess_lfno_primary(Ninja9Parser.FieldAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess(Ninja9Parser.ArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayAccess}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess(Ninja9Parser.ArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lf_primary(Ninja9Parser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayAccess_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lf_primary(Ninja9Parser.ArrayAccess_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterArrayAccess_lfno_primary(Ninja9Parser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayAccess_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitArrayAccess_lfno_primary(Ninja9Parser.ArrayAccess_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation(Ninja9Parser.MethodInvocationContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodInvocation}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation(Ninja9Parser.MethodInvocationContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodArea}.
	 * @param ctx the parse tree
	 */
	void enterMethodArea(Ninja9Parser.MethodAreaContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodArea}.
	 * @param ctx the parse tree
	 */
	void exitMethodArea(Ninja9Parser.MethodAreaContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lf_primary(Ninja9Parser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodInvocation_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lf_primary(Ninja9Parser.MethodInvocation_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodInvocation_lfno_primary(Ninja9Parser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodInvocation_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodInvocation_lfno_primary(Ninja9Parser.MethodInvocation_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void enterArgumentList(Ninja9Parser.ArgumentListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#argumentList}.
	 * @param ctx the parse tree
	 */
	void exitArgumentList(Ninja9Parser.ArgumentListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference(Ninja9Parser.MethodReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodReference}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference(Ninja9Parser.MethodReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lf_primary(Ninja9Parser.MethodReference_lf_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodReference_lf_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lf_primary(Ninja9Parser.MethodReference_lf_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void enterMethodReference_lfno_primary(Ninja9Parser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#methodReference_lfno_primary}.
	 * @param ctx the parse tree
	 */
	void exitMethodReference_lfno_primary(Ninja9Parser.MethodReference_lfno_primaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void enterArrayCreationExpression(Ninja9Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#arrayCreationExpression}.
	 * @param ctx the parse tree
	 */
	void exitArrayCreationExpression(Ninja9Parser.ArrayCreationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void enterDimExprs(Ninja9Parser.DimExprsContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#dimExprs}.
	 * @param ctx the parse tree
	 */
	void exitDimExprs(Ninja9Parser.DimExprsContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void enterDimExpr(Ninja9Parser.DimExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#dimExpr}.
	 * @param ctx the parse tree
	 */
	void exitDimExpr(Ninja9Parser.DimExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(Ninja9Parser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(Ninja9Parser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void enterLambdaExpression(Ninja9Parser.LambdaExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#lambdaExpression}.
	 * @param ctx the parse tree
	 */
	void exitLambdaExpression(Ninja9Parser.LambdaExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameters(Ninja9Parser.LambdaParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#lambdaParameters}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameters(Ninja9Parser.LambdaParametersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lambdaInferedParameterList}
	 * labeled alternative in {@link Ninja9Parser#lambdaInteredParameterList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaInferedParameterList(Ninja9Parser.LambdaInferedParameterListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lambdaInferedParameterList}
	 * labeled alternative in {@link Ninja9Parser#lambdaInteredParameterList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaInferedParameterList(Ninja9Parser.LambdaInferedParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#lambdaIdentifierParameter}.
	 * @param ctx the parse tree
	 */
	void enterLambdaIdentifierParameter(Ninja9Parser.LambdaIdentifierParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#lambdaIdentifierParameter}.
	 * @param ctx the parse tree
	 */
	void exitLambdaIdentifierParameter(Ninja9Parser.LambdaIdentifierParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void enterLambdaParameterList(Ninja9Parser.LambdaParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#lambdaParameterList}.
	 * @param ctx the parse tree
	 */
	void exitLambdaParameterList(Ninja9Parser.LambdaParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void enterInferredFormalParameterList(Ninja9Parser.InferredFormalParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#inferredFormalParameterList}.
	 * @param ctx the parse tree
	 */
	void exitInferredFormalParameterList(Ninja9Parser.InferredFormalParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void enterLambdaBody(Ninja9Parser.LambdaBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#lambdaBody}.
	 * @param ctx the parse tree
	 */
	void exitLambdaBody(Ninja9Parser.LambdaBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(Ninja9Parser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#assignmentExpression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(Ninja9Parser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(Ninja9Parser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(Ninja9Parser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void enterLeftHandSide(Ninja9Parser.LeftHandSideContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#leftHandSide}.
	 * @param ctx the parse tree
	 */
	void exitLeftHandSide(Ninja9Parser.LeftHandSideContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentOperator(Ninja9Parser.AssignmentOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#assignmentOperator}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentOperator(Ninja9Parser.AssignmentOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#leftRightOperator}.
	 * @param ctx the parse tree
	 */
	void enterLeftRightOperator(Ninja9Parser.LeftRightOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#leftRightOperator}.
	 * @param ctx the parse tree
	 */
	void exitLeftRightOperator(Ninja9Parser.LeftRightOperatorContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ig18}
	 * labeled alternative in {@link Ninja9Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterIg18(Ninja9Parser.Ig18Context ctx);
	/**
	 * Exit a parse tree produced by the {@code ig18}
	 * labeled alternative in {@link Ninja9Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitIg18(Ninja9Parser.Ig18Context ctx);
	/**
	 * Enter a parse tree produced by the {@code leftRightExpression}
	 * labeled alternative in {@link Ninja9Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterLeftRightExpression(Ninja9Parser.LeftRightExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code leftRightExpression}
	 * labeled alternative in {@link Ninja9Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitLeftRightExpression(Ninja9Parser.LeftRightExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code conditionalTernary}
	 * labeled alternative in {@link Ninja9Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void enterConditionalTernary(Ninja9Parser.ConditionalTernaryContext ctx);
	/**
	 * Exit a parse tree produced by the {@code conditionalTernary}
	 * labeled alternative in {@link Ninja9Parser#conditionalExpression}.
	 * @param ctx the parse tree
	 */
	void exitConditionalTernary(Ninja9Parser.ConditionalTernaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpression(Ninja9Parser.UnaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#unaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpression(Ninja9Parser.UnaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpression(Ninja9Parser.BinaryExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#binaryExpression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpression(Ninja9Parser.BinaryExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void enterBinaryOperator(Ninja9Parser.BinaryOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#binaryOperator}.
	 * @param ctx the parse tree
	 */
	void exitBinaryOperator(Ninja9Parser.BinaryOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#prefixOperator}.
	 * @param ctx the parse tree
	 */
	void enterPrefixOperator(Ninja9Parser.PrefixOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#prefixOperator}.
	 * @param ctx the parse tree
	 */
	void exitPrefixOperator(Ninja9Parser.PrefixOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#preExpression}.
	 * @param ctx the parse tree
	 */
	void enterPreExpression(Ninja9Parser.PreExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#preExpression}.
	 * @param ctx the parse tree
	 */
	void exitPreExpression(Ninja9Parser.PreExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostfixExpression(Ninja9Parser.PostfixExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#postfixExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostfixExpression(Ninja9Parser.PostfixExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#postfixOperator}.
	 * @param ctx the parse tree
	 */
	void enterPostfixOperator(Ninja9Parser.PostfixOperatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#postfixOperator}.
	 * @param ctx the parse tree
	 */
	void exitPostfixOperator(Ninja9Parser.PostfixOperatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#postExpression}.
	 * @param ctx the parse tree
	 */
	void enterPostExpression(Ninja9Parser.PostExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#postExpression}.
	 * @param ctx the parse tree
	 */
	void exitPostExpression(Ninja9Parser.PostExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void enterCastExpression(Ninja9Parser.CastExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#castExpression}.
	 * @param ctx the parse tree
	 */
	void exitCastExpression(Ninja9Parser.CastExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#castPrimitive}.
	 * @param ctx the parse tree
	 */
	void enterCastPrimitive(Ninja9Parser.CastPrimitiveContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#castPrimitive}.
	 * @param ctx the parse tree
	 */
	void exitCastPrimitive(Ninja9Parser.CastPrimitiveContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#castReference}.
	 * @param ctx the parse tree
	 */
	void enterCastReference(Ninja9Parser.CastReferenceContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#castReference}.
	 * @param ctx the parse tree
	 */
	void exitCastReference(Ninja9Parser.CastReferenceContext ctx);
	/**
	 * Enter a parse tree produced by {@link Ninja9Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(Ninja9Parser.IdentifierContext ctx);
	/**
	 * Exit a parse tree produced by {@link Ninja9Parser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(Ninja9Parser.IdentifierContext ctx);
}