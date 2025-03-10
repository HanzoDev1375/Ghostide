package io.github.rosemoe.sora.langs.kotlin;

import java.util.List;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class KotlinVisitor extends KotlinParserBaseVisitor<String> {

    private static final Logger LOGGER = LoggerFactory.getLogger(KotlinVisitor.class);

    private static final String INDENT_UNIT = "    ";

    private int currentIndentLevel;

    @Override
    public String visitKotlinFile(final KotlinParser.KotlinFileContext context) {
        final KotlinParser.PreambleContext preamble = context.preamble();
        final List<KotlinParser.TopLevelObjectContext> topLevelObjectContexts = context.topLevelObject();
        final StringBuilder text = new StringBuilder();
        if (!preamble.getText().isEmpty()) {
            text.append(this.visit(preamble));
            this.appendNewLinesAndIndent(text, 2);
        }
        for (int index = 0; index < topLevelObjectContexts.size(); index++) {
            final KotlinParser.TopLevelObjectContext topLevelObjectContext = topLevelObjectContexts.get(index);
            text.append(this.visit(topLevelObjectContext));
            if (index < topLevelObjectContexts.size() - 1) {
                this.appendNewLinesAndIndent(text, 2);
            }
        }
        this.appendNewLinesAndIndent(text, 1);
        return text.toString();
    }

    @Override
    public String visitPreamble(final KotlinParser.PreambleContext context) {
        final KotlinParser.FileAnnotationsContext fileAnnotationsContext = context.fileAnnotations();
        final KotlinParser.PackageHeaderContext packageHeaderContext = context.packageHeader();
        final KotlinParser.ImportListContext importListContext = context.importList();
        final StringBuilder text = new StringBuilder();
        if (fileAnnotationsContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPreamble -> fileAnnotations");
        }
        text.append(this.visit(packageHeaderContext));
        this.appendNewLinesAndIndent(text, 2);
        text.append(this.visit(importListContext));
        return text.toString();
    }

    @Override
    public String visitImportList(final KotlinParser.ImportListContext context) {
        final List<KotlinParser.ImportHeaderContext> importHeaderContexts = context.importHeader();
        final StringBuilder text = new StringBuilder();
        for (int index = 0; index < importHeaderContexts.size(); index++) {
            final KotlinParser.ImportHeaderContext importHeaderContext = importHeaderContexts.get(index);
            text.append(this.visit(importHeaderContext));
            if (index < importHeaderContexts.size() - 1) {
                this.appendNewLinesAndIndent(text, 1);
            }
        }
        return text.toString();
    }

    @Override
    public String visitImportHeader(final KotlinParser.ImportHeaderContext context) {
        final TerminalNode importTerminal = context.IMPORT();
        final KotlinParser.IdentifierContext identifierContext = context.identifier();
        final TerminalNode dotTerminal = context.DOT();
        final TerminalNode multTerminal = context.MULT();
        final KotlinParser.ImportAliasContext importAliasContext = context.importAlias();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(importTerminal))
            .append(' ')
            .append(this.visit(identifierContext));
        if (dotTerminal != null) {
            text.append(this.visit(dotTerminal))
                .append(this.visit(multTerminal));
        } else if (importAliasContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitImportHeader -> importAlias");
        }
        return text.toString();
    }

    @Override
    public String visitPackageHeader(final KotlinParser.PackageHeaderContext context) {
        final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
        final TerminalNode packageTerminal = context.PACKAGE();
        final KotlinParser.IdentifierContext identifierContext = context.identifier();
        final StringBuilder text = new StringBuilder();
        if (packageTerminal != null) {
            if (modifierListContext != null) {
                throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPackageHeader -> modifierList");
            }
            text.append(this.visit(packageTerminal))
                .append(' ')
                .append(this.visit(identifierContext));
        }
        return text.toString();
    }

    @Override
    public String visitTopLevelObject(final KotlinParser.TopLevelObjectContext context) {
        final KotlinParser.ClassDeclarationContext classDeclarationContext = context.classDeclaration();
        final KotlinParser.ObjectDeclarationContext objectDeclarationContext = context.objectDeclaration();
        final KotlinParser.FunctionDeclarationContext functionDeclarationContext = context.functionDeclaration();
        final KotlinParser.PropertyDeclarationContext propertyDeclarationContext = context.propertyDeclaration();
        final KotlinParser.TypeAliasContext typeAliasContext = context.typeAlias();
        final StringBuilder text = new StringBuilder();
        if (classDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitTopLevelObject -> classDeclaration");
        } else if (objectDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitTopLevelObject -> objectDeclaration");
        } else if (functionDeclarationContext != null) {
            text.append(this.visit(functionDeclarationContext));
        } else if (propertyDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitTopLevelObject -> propertyDeclaration");
        } else if (typeAliasContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitTopLevelObject -> typeAlias");
        }
        return text.toString();
    }

    @Override
    public String visitFunctionDeclaration(final KotlinParser.FunctionDeclarationContext context) {
        final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
        final TerminalNode funTerminal = context.FUN();
        final KotlinParser.FirstTypeOfFuncDeclarationContext firstTypeOfFuncDeclarationContext = context.firstTypeOfFuncDeclaration();
        final KotlinParser.TypeParametersContext typeParametersContext = context.typeParameters();
        final KotlinParser.ReceiverTypeContext receiverTypeContext = context.receiverType();
        // todo: use `dotTerminal` with tests.
        final TerminalNode dotTerminal = context.DOT();
        final KotlinParser.IdentifierContext identifierContext = context.identifier();
        final KotlinParser.FunctionValueParametersContext functionValueParametersContext = context.functionValueParameters();
        final KotlinParser.TypeContext typeContext = context.type();
        final TerminalNode colonTerminal = context.COLON();
        final KotlinParser.TypeConstraintsContext typeConstraintsContext = context.typeConstraints();
        final KotlinParser.FunctionBodyContext functionBodyContext = context.functionBody();
        final StringBuilder text = new StringBuilder();
        if (modifierListContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitFunctionDeclaration -> modifierList");
        }
        if (firstTypeOfFuncDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitFunctionDeclaration -> firstTypeOfFuncDeclaration");
        }
        text.append(this.visit(funTerminal));
        if (typeParametersContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitFunctionDeclaration -> typeParameters");
        }
        if (receiverTypeContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitFunctionDeclaration -> receiverType");
        }
        if (identifierContext != null) {
            text.append(' ');
            text.append(this.visit(identifierContext));
        }
        if (functionValueParametersContext != null) {
            text.append(this.visit(functionValueParametersContext));
        }
        if (typeContext != null) {
            text.append(this.visit(colonTerminal))
                .append(' ')
                .append(this.visit(typeContext));
        }
        if (typeConstraintsContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitFunctionDeclaration -> typeConstraints");
        }
        if (functionBodyContext != null) {
            text.append(' ');
            text.append(this.visit(functionBodyContext));
        }
        return text.toString();
    }

    @Override
    public String visitFunctionBody(final KotlinParser.FunctionBodyContext context) {
        final KotlinParser.BlockContext blockContext = context.block();
        final TerminalNode assignmentTerminal = context.ASSIGNMENT();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final StringBuilder text = new StringBuilder();
        if (blockContext != null) {
            text.append(this.visit(blockContext));
        } else {
            // ASSIGNMENT NL* expression
            text.append(this.visit(assignmentTerminal))
                .append(' ')
                .append(this.visit(expressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitBlock(final KotlinParser.BlockContext context) {
        final TerminalNode lcurlTerminal = context.LCURL();
        final KotlinParser.StatementsContext statementsContext = context.statements();
        final TerminalNode rcurlTerminal = context.RCURL();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(lcurlTerminal));
        this.currentIndentLevel++;
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(statementsContext));
        this.currentIndentLevel--;
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(rcurlTerminal));
        return text.toString();
    }

    @Override
    public String visitStatements(final KotlinParser.StatementsContext context) {
        final List<KotlinParser.StatementContext> statementContexts = context.statement();
        final StringBuilder text = new StringBuilder();
        for (int index = 0; index < statementContexts.size(); index++) {
            final KotlinParser.StatementContext statementContext = statementContexts.get(index);
            text.append(this.visit(statementContext));
            if (index < statementContexts.size() - 1) {
                this.appendNewLinesAndIndent(text, 1);
            }
        }
        return text.toString();
    }

    @Override
    public String visitStatement(final KotlinParser.StatementContext context) {
        final KotlinParser.DeclarationContext declarationContext = context.declaration();
        final KotlinParser.BlockLevelExpressionContext blockLevelExpressionContext = context.blockLevelExpression();
        final StringBuilder text = new StringBuilder();
        if (declarationContext != null) {
            text.append(this.visit(declarationContext));
        } else if (blockLevelExpressionContext != null) {
            text.append(this.visit(blockLevelExpressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitDeclaration(final KotlinParser.DeclarationContext context) {
        final List<KotlinParser.LabelDefinitionContext> labelDefinitionContexts = context.labelDefinition();
        final KotlinParser.ClassDeclarationContext classDeclarationContext = context.classDeclaration();
        final KotlinParser.FunctionDeclarationContext functionDeclarationContext = context.functionDeclaration();
        final KotlinParser.PropertyDeclarationContext propertyDeclarationContext = context.propertyDeclaration();
        final KotlinParser.TypeAliasContext typeAliasContext = context.typeAlias();
        final StringBuilder text = new StringBuilder();
        if (!labelDefinitionContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitDeclaration -> labelDefinition");
        }
        if (classDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitDeclaration -> classDeclaration");
        } else if (functionDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitDeclaration -> functionDeclaration");
        } else if (propertyDeclarationContext != null) {
            text.append(this.visit(propertyDeclarationContext));
        } else if (typeAliasContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitDeclaration -> typeAlias");
        }
        return text.toString();
    }

    @Override
    public String visitPropertyDeclaration(final KotlinParser.PropertyDeclarationContext context) {
        final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
        final TerminalNode valTerminal = context.VAL();
        final TerminalNode varTerminal = context.VAR();
        final KotlinParser.TypeParametersContext typeParametersContext = context.typeParameters();
        final KotlinParser.TypeContext typeContext = context.type();
        // todo: use `dotTerminal` with tests.
        final TerminalNode dotTerminal = context.DOT();
        final KotlinParser.MultiVariableDeclarationContext multiVariableDeclarationContext = context.multiVariableDeclaration();
        final KotlinParser.VariableDeclarationContext variableDeclarationContext = context.variableDeclaration();
        final KotlinParser.TypeConstraintsContext typeConstraintsContext = context.typeConstraints();
        final TerminalNode byTerminal = context.BY();
        final TerminalNode assignmentTerminal = context.ASSIGNMENT();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final KotlinParser.GetterContext getterContext = context.getter();
        final KotlinParser.SetterContext setterContext = context.setter();
        final StringBuilder text = new StringBuilder();
        if (modifierListContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> modifierList");
        }
        if (valTerminal != null) {
            text.append(this.visit(valTerminal));
            text.append(' ');
        } else if (varTerminal != null) {
            text.append(this.visit(varTerminal));
            text.append(' ');
        }
        if (typeParametersContext != null) {
            // (NL* typeParameters)?
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> typeParameters");
        }
        if (typeContext != null) {
            // (NL* type NL* DOT)?
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> type");
        }
        // NL* (multiVariableDeclaration | variableDeclaration)
        if (multiVariableDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> multiVariableDeclaration");
        } else if (variableDeclarationContext != null) {
            text.append(this.visit(variableDeclarationContext));
        }
        if (typeConstraintsContext != null) {
            // (NL* typeConstraints)?
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> typeConstraints");
        }
        if (expressionContext != null) {
            // (NL* (BY | ASSIGNMENT) NL* expression)?
            if (byTerminal != null) {
                throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> by");
            } else if (assignmentTerminal != null) {
                text.append(' ')
                    .append(this.visit(assignmentTerminal))
                    .append(' ')
                    .append(this.visit(expressionContext));
            }
        }
        // (NL* getter (semi setter)? | NL* setter (semi getter)?)?
        if (getterContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> getter");
        }
        if (setterContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPropertyDeclaration -> setter");
        }
        return text.toString();
    }

    @Override
    public String visitVariableDeclaration(final KotlinParser.VariableDeclarationContext context) {
        final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
        final TerminalNode colonTerminal = context.COLON();
        final KotlinParser.TypeContext typeContext = context.type();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(simpleIdentifierContext));
        if (colonTerminal != null) {
            text.append(this.visit(colonTerminal))
                .append(' ')
                .append(this.visit(typeContext));
        }
        return text.toString();
    }

    @Override
    public String visitType(final KotlinParser.TypeContext context) {
        final KotlinParser.TypeModifierListContext typeModifierListContext = context.typeModifierList();
        final KotlinParser.FunctionTypeContext functionTypeContext = context.functionType();
        final KotlinParser.ParenthesizedTypeContext parenthesizedTypeContext = context.parenthesizedType();
        final KotlinParser.NullableTypeContext nullableTypeContext = context.nullableType();
        final KotlinParser.TypeReferenceContext typeReferenceContext = context.typeReference();
        final StringBuilder text = new StringBuilder();
        if (typeModifierListContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitType -> typeModifierList");
        }
        if (functionTypeContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitType -> functionType");
        } else if (parenthesizedTypeContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitType -> parenthesizedType");
        } else if (nullableTypeContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitType -> nullableType");
        } else if (typeReferenceContext != null) {
            text.append(this.visit(typeReferenceContext));
        }
        return text.toString();
    }

    @Override
    public String visitTypeReference(final KotlinParser.TypeReferenceContext context) {
        final TerminalNode lparenTerminal = context.LPAREN();
        // todo: use `typeReferenceContext` and `rparenTerminal` with tests.
        final KotlinParser.TypeReferenceContext typeReferenceContext = context.typeReference();
        final TerminalNode rparenTerminal = context.RPAREN();
        final KotlinParser.UserTypeContext userTypeContext = context.userType();
        final TerminalNode dynamicTerminal = context.DYNAMIC();
        final StringBuilder text = new StringBuilder();
        if (lparenTerminal != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitTypeReference -> lparen");
        } else if (userTypeContext != null) {
            text.append(this.visit(userTypeContext));
        } else if (dynamicTerminal != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitTypeReference -> dynamic");
        }
        return text.toString();
    }

    @Override
    public String visitUserType(final KotlinParser.UserTypeContext context) {
        final List<KotlinParser.SimpleUserTypeContext> simpleUserTypeContexts = context.simpleUserType();
        final List<TerminalNode> dotTerminals = context.DOT();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.SimpleUserTypeContext firstSimpleUserTypeContext = simpleUserTypeContexts.get(0);
        text.append(this.visit(firstSimpleUserTypeContext));
        if (!dotTerminals.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitUserType -> dot");
        }
        return text.toString();
    }

    @Override
    public String visitSimpleUserType(final KotlinParser.SimpleUserTypeContext context) {
        final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
        final KotlinParser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(simpleIdentifierContext));
        if (typeArgumentsContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitSimpleUserType -> typeArguments");
        }
        return text.toString();
    }

    @Override
    public String visitBlockLevelExpression(final KotlinParser.BlockLevelExpressionContext context) {
        final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final StringBuilder text = new StringBuilder();
        if (!annotationsContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitBlockLevelExpression -> annotations");
        }
        if (expressionContext != null) {
            text.append(this.visit(expressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitExpression(final KotlinParser.ExpressionContext context) {
        final List<KotlinParser.DisjunctionContext> disjunctionContexts = context.disjunction();
        final List<KotlinParser.AssignmentOperatorContext> assignmentOperatorContexts = context.assignmentOperator();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.DisjunctionContext firstDisjunctionContext = disjunctionContexts.get(0);
        text.append(this.visit(firstDisjunctionContext));
        if (!assignmentOperatorContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitExpression -> assignmentOperator");
        }
        return text.toString();
    }

    @Override
    public String visitDisjunction(final KotlinParser.DisjunctionContext context) {
        final List<KotlinParser.ConjunctionContext> conjunctionContexts = context.conjunction();
        final List<TerminalNode> disjTerminals = context.DISJ();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.ConjunctionContext firstConjunctionContext = conjunctionContexts.get(0);
        text.append(this.visit(firstConjunctionContext));
        if (!disjTerminals.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitDisjunction -> disj");
        }
        return text.toString();
    }

    @Override
    public String visitConjunction(final KotlinParser.ConjunctionContext context) {
        final List<KotlinParser.EqualityComparisonContext> equalityComparisonContexts = context.equalityComparison();
        final List<TerminalNode> conjTerminals = context.CONJ();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.EqualityComparisonContext firstEqualityComparisonContext = equalityComparisonContexts.get(0);
        text.append(this.visit(firstEqualityComparisonContext));
        if (!conjTerminals.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitConjunction -> conj");
        }
        return text.toString();
    }

    @Override
    public String visitEqualityComparison(final KotlinParser.EqualityComparisonContext context) {
        final List<KotlinParser.ComparisonContext> comparisonContexts = context.comparison();
        final List<KotlinParser.EqualityOperationContext> equalityOperationContexts = context.equalityOperation();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.ComparisonContext firstComparisonContext = comparisonContexts.get(0);
        text.append(this.visit(firstComparisonContext));
        for (int index = 0; index < equalityOperationContexts.size(); index++) {
            final KotlinParser.EqualityOperationContext equalityOperationContext = equalityOperationContexts.get(index);
            final KotlinParser.ComparisonContext comparisonContext = comparisonContexts.get(index + 1);
            text.append(' ')
                .append(this.visit(equalityOperationContext))
                .append(' ')
                .append(this.visit(comparisonContext));
        }
        return text.toString();
    }

    @Override
    public String visitEqualityOperation(final KotlinParser.EqualityOperationContext context) {
        final TerminalNode exclEqTerminal = context.EXCL_EQ();
        final TerminalNode exclEqeqTerminal = context.EXCL_EQEQ();
        final TerminalNode eqeqTerminal = context.EQEQ();
        final TerminalNode eqeqeqTerminal = context.EQEQEQ();
        final StringBuilder text = new StringBuilder();
        if (exclEqTerminal != null) {
            text.append(this.visit(exclEqTerminal));
        } else if (exclEqeqTerminal != null) {
            text.append(this.visit(exclEqeqTerminal));
        } else if (eqeqTerminal != null) {
            text.append(this.visit(eqeqTerminal));
        } else if (eqeqeqTerminal != null) {
            text.append(this.visit(eqeqeqTerminal));
        }
        return text.toString();
    }

    @Override
    public String visitComparison(final KotlinParser.ComparisonContext context) {
        final List<KotlinParser.NamedInfixContext> namedInfixContexts = context.namedInfix();
        final KotlinParser.ComparisonOperatorContext comparisonOperatorContext = context.comparisonOperator();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.NamedInfixContext firstNamedInfixContext = namedInfixContexts.get(0);
        text.append(this.visit(firstNamedInfixContext));
        if (comparisonOperatorContext != null) {
            text.append(' ')
                .append(this.visit(comparisonOperatorContext));
            final KotlinParser.NamedInfixContext secondNamedInfixContext = namedInfixContexts.get(1);
            text.append(' ')
                .append(this.visit(secondNamedInfixContext));
        }
        return text.toString();
    }

    @Override
    public String visitComparisonOperator(final KotlinParser.ComparisonOperatorContext context) {
        final TerminalNode langleTerminal = context.LANGLE();
        final TerminalNode rangleTerminal = context.RANGLE();
        final TerminalNode leTerminal = context.LE();
        final TerminalNode geTerminal = context.GE();
        final StringBuilder text = new StringBuilder();
        if (langleTerminal != null) {
            text.append(this.visit(langleTerminal));
        } else if (rangleTerminal != null) {
            text.append(this.visit(rangleTerminal));
        } else if (leTerminal != null) {
            text.append(this.visit(leTerminal));
        } else if (geTerminal != null) {
            text.append(this.visit(geTerminal));
        }
        return text.toString();
    }

    @Override
    public String visitNamedInfix(final KotlinParser.NamedInfixContext context) {
        final List<KotlinParser.ElvisExpressionContext> elvisExpressionContexts = context.elvisExpression();
        final List<KotlinParser.InOperatorContext> inoperatorContexts = context.inOperator();
        // todo: use `isOperatorContext` with tests.
        final KotlinParser.IsOperatorContext isOperatorContext = context.isOperator();
        final KotlinParser.TypeContext typeContext = context.type();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.ElvisExpressionContext firstElvisExpressionContext = elvisExpressionContexts.get(0);
        text.append(this.visit(firstElvisExpressionContext));
        if (!inoperatorContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitNamedInfix -> inOperator");
        }
        if (typeContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitNamedInfix -> type");
        }
        return text.toString();
    }

    @Override
    public String visitElvisExpression(final KotlinParser.ElvisExpressionContext context) {
        final List<KotlinParser.InfixFunctionCallContext> infixFunctionCallContexts = context.infixFunctionCall();
        final List<TerminalNode> elvisTerminals = context.ELVIS();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.InfixFunctionCallContext firstInfixFunctionCallContext = infixFunctionCallContexts.get(0);
        text.append(this.visit(firstInfixFunctionCallContext));
        if (!elvisTerminals.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitElvisExpression -> elvis");
        }
        return text.toString();
    }

    @Override
    public String visitInfixFunctionCall(final KotlinParser.InfixFunctionCallContext context) {
        final List<KotlinParser.RangeExpressionContext> rangeExpressionContexts = context.rangeExpression();
        final List<KotlinParser.SimpleIdentifierContext> simpleIdentifierContexts = context.simpleIdentifier();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.RangeExpressionContext firstRangeExpressionContext = rangeExpressionContexts.get(0);
        text.append(this.visit(firstRangeExpressionContext));
        if (!simpleIdentifierContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitInfixFunctionCall -> simpleIdentifier");
        }
        return text.toString();
    }

    @Override
    public String visitRangeExpression(final KotlinParser.RangeExpressionContext context) {
        final List<KotlinParser.AdditiveExpressionContext> additiveExpressionContexts = context.additiveExpression();
        final List<TerminalNode> rangeTerminals = context.RANGE();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.AdditiveExpressionContext firstAdditiveExpressionContext = additiveExpressionContexts.get(0);
        text.append(this.visit(firstAdditiveExpressionContext));
        for (int index = 0; index < rangeTerminals.size(); index++) {
            final TerminalNode rangeTerminal = rangeTerminals.get(index);
            final KotlinParser.AdditiveExpressionContext additiveExpressionContext = additiveExpressionContexts.get(index + 1);
            text.append(this.visit(rangeTerminal))
                .append(this.visit(additiveExpressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitAdditiveExpression(final KotlinParser.AdditiveExpressionContext context) {
        final List<KotlinParser.MultiplicativeExpressionContext> multiplicativeExpressionContexts = context.multiplicativeExpression();
        final List<KotlinParser.AdditiveOperatorContext> additiveOperatorContexts = context.additiveOperator();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.MultiplicativeExpressionContext firstMultiplicativeExpressionContext = multiplicativeExpressionContexts.get(0);
        text.append(this.visit(firstMultiplicativeExpressionContext));
        for (int index = 0; index < additiveOperatorContexts.size(); index++) {
            final KotlinParser.AdditiveOperatorContext additiveOperatorContext = additiveOperatorContexts.get(index);
            final KotlinParser.MultiplicativeExpressionContext multiplicativeExpressionContext = multiplicativeExpressionContexts.get(index + 1);
            text.append(' ')
                .append(this.visit(additiveOperatorContext))
                .append(' ')
                .append(this.visit(multiplicativeExpressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitAdditiveOperator(final KotlinParser.AdditiveOperatorContext context) {
        final TerminalNode addTerminal = context.ADD();
        final TerminalNode subTerminal = context.SUB();
        final StringBuilder text = new StringBuilder();
        if (addTerminal != null) {
            text.append(this.visit(addTerminal));
        } else if (subTerminal != null) {
            text.append(this.visit(subTerminal));
        }
        return text.toString();
    }

    @Override
    public String visitMultiplicativeExpression(final KotlinParser.MultiplicativeExpressionContext context) {
        final List<KotlinParser.TypeRHSContext> typeRHSContexts = context.typeRHS();
        final List<KotlinParser.MultiplicativeOperationContext> multiplicativeOperationContexts = context.multiplicativeOperation();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.TypeRHSContext firstTypeRHSContext = typeRHSContexts.get(0);
        text.append(this.visit(firstTypeRHSContext));
        if (!multiplicativeOperationContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitMultiplicativeExpression -> multiplicativeOperation");
        }
        return text.toString();
    }

    @Override
    public String visitTypeRHS(final KotlinParser.TypeRHSContext context) {
        final List<KotlinParser.PrefixUnaryExpressionContext> prefixUnaryExpressionContexts = context.prefixUnaryExpression();
        final List<KotlinParser.TypeOperationContext> typeOperationContexts = context.typeOperation();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.PrefixUnaryExpressionContext firstPrefixUnaryExpressionContext = prefixUnaryExpressionContexts.get(0);
        text.append(this.visit(firstPrefixUnaryExpressionContext));
        if (!typeOperationContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitTypeRHS -> typeOperation");
        }
        return text.toString();
    }

    @Override
    public String visitPrefixUnaryExpression(final KotlinParser.PrefixUnaryExpressionContext context) {
        final List<KotlinParser.PrefixUnaryOperationContext> prefixUnaryOperationContexts = context.prefixUnaryOperation();
        final KotlinParser.PostfixUnaryExpressionContext postfixUnaryExpressionContext = context.postfixUnaryExpression();
        final StringBuilder text = new StringBuilder();
        if (!prefixUnaryOperationContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPrefixUnaryExpression -> prefixUnaryOperation");
        }
        text.append(this.visit(postfixUnaryExpressionContext));
        return text.toString();
    }

    @Override
    public String visitPostfixUnaryExpression(final KotlinParser.PostfixUnaryExpressionContext context) {
        final KotlinParser.AtomicExpressionContext atomicExpressionContext = context.atomicExpression();
        final KotlinParser.CallableReferenceContext callableReferenceContext = context.callableReference();
        final List<KotlinParser.PostfixUnaryOperationContext> postfixUnaryOperationContexts = context.postfixUnaryOperation();
        final StringBuilder text = new StringBuilder();
        if (atomicExpressionContext != null) {
            text.append(this.visit(atomicExpressionContext));
        } else if (callableReferenceContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPostfixUnaryExpression -> callableReference");
        }
        if (postfixUnaryOperationContexts.size() > 1) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPostfixUnaryExpression -> postfixUnaryOperationContexts.size() > 1");
        } else if (postfixUnaryOperationContexts.size() == 1) {
            final KotlinParser.PostfixUnaryOperationContext postfixUnaryOperationContext = postfixUnaryOperationContexts.get(0);
            text.append(this.visit(postfixUnaryOperationContext));
        }
        return text.toString();
    }

    @Override
    public String visitPostfixUnaryOperation(final KotlinParser.PostfixUnaryOperationContext context) {
        final TerminalNode incrTerminal = context.INCR();
        final TerminalNode decrTerminal = context.DECR();
        final List<TerminalNode> exclTerminals = context.EXCL();
        final KotlinParser.CallSuffixContext callSuffixContext = context.callSuffix();
        final KotlinParser.ArrayAccessContext arrayAccessContext = context.arrayAccess();
        final KotlinParser.MemberAccessOperatorContext memberAccessOperatorContext = context.memberAccessOperator();
        // todo: use `postfixUnaryExpressionContext` with tests.
        final KotlinParser.PostfixUnaryExpressionContext postfixUnaryExpressionContext = context.postfixUnaryExpression();
        final StringBuilder text = new StringBuilder();
        if (incrTerminal != null) {
            text.append(this.visit(incrTerminal));
        } else if (decrTerminal != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPostfixUnaryOperation -> decr");
        } else if (!exclTerminals.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPostfixUnaryOperation -> excl");
        } else if (callSuffixContext != null) {
            text.append(this.visit(callSuffixContext));
        } else if (arrayAccessContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPostfixUnaryOperation -> arrayAccess");
        } else if (memberAccessOperatorContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitPostfixUnaryOperation -> memberAccessOperator");
        }
        return text.toString();
    }

    @Override
    public String visitCallSuffix(final KotlinParser.CallSuffixContext context) {
        final KotlinParser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
        final KotlinParser.ValueArgumentsContext valueArgumentsContext = context.valueArguments();
        final List<KotlinParser.AnnotatedLambdaContext> annotatedLambdaContexts = context.annotatedLambda();
        final StringBuilder text = new StringBuilder();
        if (typeArgumentsContext != null) {
            // typeArguments valueArguments? annotatedLambda*
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitCallSuffix -> typeArguments valueArguments? annotatedLambda*");
        } else if (valueArgumentsContext != null) {
            // valueArguments annotatedLambda*
            text.append(this.visit(valueArgumentsContext));
            if (!annotatedLambdaContexts.isEmpty()) {
                throw new UnsupportedOperationException("The following parsing path is not supported yet: visitCallSuffix -> valueArguments annotatedLambda+");
            }
        } else if (!annotatedLambdaContexts.isEmpty()) {
            // annotatedLambda+
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitCallSuffix -> annotatedLambda+");
        }
        return text.toString();
    }

    @Override
    public String visitValueArguments(final KotlinParser.ValueArgumentsContext context) {
        final TerminalNode lparenTerminal = context.LPAREN();
        final List<KotlinParser.ValueArgumentContext> valueArgumentContexts = context.valueArgument();
        final List<TerminalNode> commaTerminals = context.COMMA();
        final TerminalNode rparenTerminal = context.RPAREN();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(lparenTerminal));
        if (!valueArgumentContexts.isEmpty()) {
            final KotlinParser.ValueArgumentContext firstValueArgumentContext = valueArgumentContexts.get(0);
            text.append(this.visit(firstValueArgumentContext));
            for (int index = 1; index < valueArgumentContexts.size(); index++) {
                // (COMMA valueArgument)*
                final TerminalNode commaTerminal = commaTerminals.get(index - 1);
                final KotlinParser.ValueArgumentContext valueArgumentContext = valueArgumentContexts.get(index);
                text.append(this.visit(commaTerminal))
                    .append(' ')
                    .append(this.visit(valueArgumentContext));
            }
        }
        // (NL* COMMA)?
        if (valueArgumentContexts.size() == commaTerminals.size()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitValueArguments -> (NL* COMMA)?");
        }
        text.append(this.visit(rparenTerminal));
        return text.toString();
    }

    @Override
    public String visitValueArgument(final KotlinParser.ValueArgumentContext context) {
        final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
        // todo: use `assignmentTerminal` with tests.
        final TerminalNode assignmentTerminal = context.ASSIGNMENT();
        final TerminalNode multTerminal = context.MULT();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final StringBuilder text = new StringBuilder();
        if (simpleIdentifierContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitValueArgument -> simpleIdentifier");
        }
        if (multTerminal != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitValueArgument -> mult");
        }
        text.append(this.visit(expressionContext));
        return text.toString();
    }

    @Override
    public String visitAtomicExpression(final KotlinParser.AtomicExpressionContext context) {
        final KotlinParser.ParenthesizedExpressionContext parenthesizedExpressionContext = context.parenthesizedExpression();
        final KotlinParser.LiteralConstantContext literalConstantContext = context.literalConstant();
        final KotlinParser.FunctionLiteralContext functionLiteralContext = context.functionLiteral();
        final KotlinParser.ThisExpressionContext thisExpressionContext = context.thisExpression();
        final KotlinParser.SuperExpressionContext superExpressionContext = context.superExpression();
        final KotlinParser.ConditionalExpressionContext conditionalExpressionContext = context.conditionalExpression();
        final KotlinParser.TryExpressionContext tryExpressionContext = context.tryExpression();
        final KotlinParser.ObjectLiteralContext objectLiteralContext = context.objectLiteral();
        final KotlinParser.JumpExpressionContext jumpExpressionContext = context.jumpExpression();
        final KotlinParser.LoopExpressionContext loopExpressionContext = context.loopExpression();
        final KotlinParser.CollectionLiteralContext collectionLiteralContext = context.collectionLiteral();
        final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
        final TerminalNode valTerminal = context.VAL();
        // todo: use `identifierContext` with tests.
        final KotlinParser.IdentifierContext identifierContext = context.identifier();
        final StringBuilder text = new StringBuilder();
        if (parenthesizedExpressionContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> parenthesizedExpression");
        } else if (literalConstantContext != null) {
            text.append(this.visit(literalConstantContext));
        } else if (functionLiteralContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> functionLiteral");
        } else if (thisExpressionContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> thisExpression");
        } else if (superExpressionContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> superExpression");
        } else if (conditionalExpressionContext != null) {
            text.append(this.visit(conditionalExpressionContext));
        } else if (tryExpressionContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> tryExpression");
        } else if (objectLiteralContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> objectLiteral");
        } else if (jumpExpressionContext != null) {
            text.append(this.visit(jumpExpressionContext));
        } else if (loopExpressionContext != null) {
            text.append(this.visit(loopExpressionContext));
        } else if (collectionLiteralContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> collectionLiteral");
        } else if (simpleIdentifierContext != null) {
            text.append(this.visit(simpleIdentifierContext));
        } else if (valTerminal != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitAtomicExpression -> val");
        }
        return text.toString();
    }

    @Override
    public String visitJumpExpression(final KotlinParser.JumpExpressionContext context) {
        final TerminalNode throwTerminal = context.THROW();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final TerminalNode returnTerminal = context.RETURN();
        final TerminalNode returnAtTerminal = context.RETURN_AT();
        final TerminalNode continueTerminal = context.CONTINUE();
        final TerminalNode continueAtTerminal = context.CONTINUE_AT();
        final TerminalNode breakTerminal = context.BREAK();
        final TerminalNode breakAtTerminal = context.BREAK_AT();
        final StringBuilder text = new StringBuilder();
        if (throwTerminal != null) {
            // THROW NL* expression
            text.append(this.visit(throwTerminal))
                .append(' ')
                .append(this.visit(expressionContext));
        } else if (returnTerminal != null) {
            // RETURN expression?
            text.append(this.visit(returnTerminal));
            if (expressionContext != null) {
                text.append(' ')
                    .append(this.visit(expressionContext));
            }
        } else if (returnAtTerminal != null) {
            // RETURN_AT expression?
            text.append(this.visit(returnAtTerminal));
            if (expressionContext != null) {
                text.append(' ')
                    .append(this.visit(expressionContext));
            }
        } else if (continueTerminal != null) {
            // CONTINUE
            text.append(this.visit(continueTerminal));
        } else if (continueAtTerminal != null) {
            // CONTINUE_AT
            text.append(this.visit(continueAtTerminal));
        } else if (breakTerminal != null) {
            // BREAK
            text.append(this.visit(breakTerminal));
        } else if (breakAtTerminal != null) {
            // BREAK_AT
            text.append(this.visit(breakAtTerminal));
        }
        return text.toString();
    }

    @Override
    public String visitLoopExpression(final KotlinParser.LoopExpressionContext context) {
        final KotlinParser.ForExpressionContext forExpressionContext = context.forExpression();
        final KotlinParser.WhileExpressionContext whileExpressionContext = context.whileExpression();
        final KotlinParser.DoWhileExpressionContext doWhileExpressionContext = context.doWhileExpression();
        final StringBuilder text = new StringBuilder();
        if (forExpressionContext != null) {
            text.append(this.visit(forExpressionContext));
        } else if (whileExpressionContext != null) {
            text.append(this.visit(whileExpressionContext));
        } else if (doWhileExpressionContext != null) {
            text.append(this.visit(doWhileExpressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitDoWhileExpression(final KotlinParser.DoWhileExpressionContext context) {
        final TerminalNode doTerminal = context.DO();
        final KotlinParser.ControlStructureBodyContext controlStructureBodyContext = context.controlStructureBody();
        final TerminalNode whileTerminal = context.WHILE();
        final TerminalNode lparenTerminal = context.LPAREN();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final TerminalNode rparenTerminal = context.RPAREN();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(doTerminal))
            .append(' ');
        if (controlStructureBodyContext != null) {
            text.append(this.visit(controlStructureBodyContext))
                .append(' ');
        }
        text.append(this.visit(whileTerminal))
            .append(' ')
            .append(this.visit(lparenTerminal))
            .append(this.visit(expressionContext))
            .append(this.visit(rparenTerminal));
        return text.toString();
    }

    @Override
    public String visitWhileExpression(final KotlinParser.WhileExpressionContext context) {
        final TerminalNode whileTerminal = context.WHILE();
        final TerminalNode lparenTerminal = context.LPAREN();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final TerminalNode rparenTerminal = context.RPAREN();
        final KotlinParser.ControlStructureBodyContext controlStructureBodyContext = context.controlStructureBody();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(whileTerminal))
            .append(' ')
            .append(this.visit(lparenTerminal))
            .append(this.visit(expressionContext))
            .append(this.visit(rparenTerminal))
            .append(' ')
            .append(this.visit(controlStructureBodyContext));
        return text.toString();
    }

    @Override
    public String visitForExpression(final KotlinParser.ForExpressionContext context) {
        final TerminalNode forTerminal = context.FOR();
        final TerminalNode lparenTerminal = context.LPAREN();
        final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
        final KotlinParser.VariableDeclarationContext variableDeclarationContext = context.variableDeclaration();
        final KotlinParser.MultiVariableDeclarationContext multiVariableDeclarationContext = context.multiVariableDeclaration();
        final TerminalNode inTerminal = context.IN();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final TerminalNode rparenTerminal = context.RPAREN();
        final KotlinParser.ControlStructureBodyContext controlStructureBodyContext = context.controlStructureBody();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(forTerminal))
            .append(' ')
            .append(this.visit(lparenTerminal));
        if (!annotationsContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitForExpression -> annotations");
        }
        if (variableDeclarationContext != null) {
            text.append(this.visit(variableDeclarationContext));
        } else if (multiVariableDeclarationContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitForExpression -> multiVariableDeclaration");
        }
        text.append(' ')
            .append(this.visit(inTerminal))
            .append(' ')
            .append(this.visit(expressionContext))
            .append(this.visit(rparenTerminal))
            .append(' ')
            .append(this.visit(controlStructureBodyContext));
        return text.toString();
    }

    @Override
    public String visitConditionalExpression(final KotlinParser.ConditionalExpressionContext context) {
        final KotlinParser.IfExpressionContext ifExpressionContext = context.ifExpression();
        final KotlinParser.WhenExpressionContext whenExpressionContext = context.whenExpression();
        final StringBuilder text = new StringBuilder();
        if (ifExpressionContext != null) {
            text.append(this.visit(ifExpressionContext));
        } else if (whenExpressionContext != null) {
            text.append(this.visit(whenExpressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitWhenExpression(final KotlinParser.WhenExpressionContext context) {
        final TerminalNode whenTerminal = context.WHEN();
        final TerminalNode lparenTerminal = context.LPAREN();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final TerminalNode rparenTerminal = context.RPAREN();
        final TerminalNode lcurlTerminal = context.LCURL();
        final List<KotlinParser.WhenEntryContext> whenEntryContexts = context.whenEntry();
        final TerminalNode rcurlTerminal = context.RCURL();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(whenTerminal))
            .append(' ')
            .append(this.visit(lparenTerminal))
            .append(this.visit(expressionContext))
            .append(this.visit(rparenTerminal))
            .append(' ')
            .append(this.visit(lcurlTerminal));
        this.currentIndentLevel++;
        this.appendNewLinesAndIndent(text, 1);
        for (int index = 0; index < whenEntryContexts.size(); index++) {
            final KotlinParser.WhenEntryContext whenEntryContext = whenEntryContexts.get(index);
            text.append(this.visit(whenEntryContext));
            if (index == whenEntryContexts.size() - 1) {
                this.currentIndentLevel--;
            }
            this.appendNewLinesAndIndent(text, 1);
        }
        text.append(this.visit(rcurlTerminal));
        return text.toString();
    }

    @Override
    public String visitWhenEntry(final KotlinParser.WhenEntryContext context) {
        final List<KotlinParser.WhenConditionContext> whenConditionContexts = context.whenCondition();
        final List<TerminalNode> commaTerminals = context.COMMA();
        final TerminalNode arrowTerminal = context.ARROW();
        final KotlinParser.ControlStructureBodyContext controlStructureBodyContext = context.controlStructureBody();
        final TerminalNode elseTerminal = context.ELSE();
        final StringBuilder text = new StringBuilder();
        if (elseTerminal == null) {
            // whenCondition (NL* COMMA NL* whenCondition)* NL* ARROW NL* controlStructureBody semi?
            final KotlinParser.WhenConditionContext firstWhenConditionContext = whenConditionContexts.get(0);
            text.append(this.visit(firstWhenConditionContext));
            for (int index = 0; index < commaTerminals.size(); index++) {
                final TerminalNode commaTerminal = commaTerminals.get(index);
                final KotlinParser.WhenConditionContext whenConditionContext = whenConditionContexts.get(index + 1);
                text.append(this.visit(commaTerminal))
                    .append(' ')
                    .append(this.visit(whenConditionContext));
            }
            text.append(' ')
                .append(this.visit(arrowTerminal))
                .append(' ')
                .append(this.visit(controlStructureBodyContext));
        } else {
            // ELSE NL* ARROW NL* controlStructureBody
            text.append(this.visit(elseTerminal))
                .append(' ')
                .append(this.visit(arrowTerminal))
                .append(' ')
                .append(this.visit(controlStructureBodyContext));
        }
        return text.toString();
    }

    @Override
    public String visitWhenCondition(final KotlinParser.WhenConditionContext context) {
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final KotlinParser.RangeTestContext rangeTestContext = context.rangeTest();
        final KotlinParser.TypeTestContext typeTestContext = context.typeTest();
        final StringBuilder text = new StringBuilder();
        if (expressionContext != null) {
            text.append(this.visit(expressionContext));
        } else if (rangeTestContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitWhenCondition -> rangeTest");
        } else if (typeTestContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitWhenCondition -> typeTest");
        }
        return text.toString();
    }

    @Override
    public String visitIfExpression(final KotlinParser.IfExpressionContext context) {
        final TerminalNode ifTerminal = context.IF();
        final TerminalNode lparenTerminal = context.LPAREN();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final TerminalNode rparenTerminal = context.RPAREN();
        final KotlinParser.FirstControlStructureBodyOfIfExpressionContext firstControlStructureBodyOfIfExpressionContext = context.firstControlStructureBodyOfIfExpression();
        final TerminalNode semicolonTerminal = context.SEMICOLON();
        final TerminalNode elseTerminal = context.ELSE();
        final KotlinParser.ControlStructureBodyContext controlStructureBodyContext = context.controlStructureBody();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(ifTerminal))
            .append(' ')
            .append(this.visit(lparenTerminal))
            .append(this.visit(expressionContext))
            .append(this.visit(rparenTerminal));
        if (firstControlStructureBodyOfIfExpressionContext != null) {
            text
                .append(' ')
                .append(this.visit(firstControlStructureBodyOfIfExpressionContext));
        }
        if (semicolonTerminal != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitIfExpression -> semicolon");
        }
        if (elseTerminal != null) {
            text.append(' ')
                .append(this.visit(elseTerminal))
                .append(' ')
                .append(this.visit(controlStructureBodyContext));
        }
        return text.toString();
    }

    @Override
    public String visitFirstControlStructureBodyOfIfExpression(final KotlinParser.FirstControlStructureBodyOfIfExpressionContext context) {
        final KotlinParser.ControlStructureBodyContext controlStructureBodyContext = context.controlStructureBody();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(controlStructureBodyContext));
        return text.toString();
    }

    @Override
    public String visitControlStructureBody(final KotlinParser.ControlStructureBodyContext context) {
        final KotlinParser.BlockContext blockContext = context.block();
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final StringBuilder text = new StringBuilder();
        if (blockContext != null) {
            text.append(this.visit(blockContext));
        } else if (expressionContext != null) {
            text.append(this.visit(expressionContext));
        }
        return text.toString();
    }

    @Override
    public String visitLiteralConstant(final KotlinParser.LiteralConstantContext context) {
        final TerminalNode booleanLiteralTerminal = context.BooleanLiteral();
        final TerminalNode integerLiteralTerminal = context.IntegerLiteral();
        final KotlinParser.StringLiteralContext stringLiteralContext = context.stringLiteral();
        final TerminalNode hexLiteralTerminal = context.HexLiteral();
        final TerminalNode binLiteralTerminal = context.BinLiteral();
        final TerminalNode characterLiteralTerminal = context.CharacterLiteral();
        final TerminalNode realLiteralTerminal = context.RealLiteral();
        final TerminalNode nullLiteralTerminal = context.NullLiteral();
        final TerminalNode longLiteralTerminal = context.LongLiteral();
        final StringBuilder text = new StringBuilder();
        if (booleanLiteralTerminal != null) {
            text.append(this.visit(booleanLiteralTerminal));
        } else if (integerLiteralTerminal != null) {
            text.append(this.visit(integerLiteralTerminal));
        } else if (stringLiteralContext != null) {
            text.append(this.visit(stringLiteralContext));
        } else if (hexLiteralTerminal != null) {
            text.append(this.visit(hexLiteralTerminal));
        } else if (binLiteralTerminal != null) {
            text.append(this.visit(binLiteralTerminal));
        } else if (characterLiteralTerminal != null) {
            text.append(this.visit(characterLiteralTerminal));
        } else if (realLiteralTerminal != null) {
            text.append(this.visit(realLiteralTerminal));
        } else if (nullLiteralTerminal != null) {
            text.append(this.visit(nullLiteralTerminal));
        } else if (longLiteralTerminal != null) {
            text.append(this.visit(longLiteralTerminal));
        }
        return text.toString();
    }

    @Override
    public String visitStringLiteral(final KotlinParser.StringLiteralContext context) {
        final KotlinParser.LineStringLiteralContext lineStringLiteralContext = context.lineStringLiteral();
        final KotlinParser.MultiLineStringLiteralContext multiLineStringLiteralContext = context.multiLineStringLiteral();
        final StringBuilder text = new StringBuilder();
        if (lineStringLiteralContext != null) {
            text.append(this.visit(lineStringLiteralContext));
        } else if (multiLineStringLiteralContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitStringLiteral -> multiLineStringLiteral");
        }
        return text.toString();
    }

    @Override
    public String visitLineStringLiteral(final KotlinParser.LineStringLiteralContext context) {
        final TerminalNode quoteOpenTerminal = context.QUOTE_OPEN();
        final List<KotlinParser.LineStringContentContext> lineStringContentContexts = context.lineStringContent();
        final List<KotlinParser.LineStringExpressionContext> lineStringExpressionContexts = context.lineStringExpression();
        final TerminalNode quoteCloseTerminal = context.QUOTE_CLOSE();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(quoteOpenTerminal));
        if (!lineStringContentContexts.isEmpty()) {
            for (final KotlinParser.LineStringContentContext lineStringContentContext : lineStringContentContexts) {
                text.append(this.visit(lineStringContentContext));
            }
        }
        if (!lineStringExpressionContexts.isEmpty()) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitLineStringLiteral -> lineStringExpression");
        }
        text.append(this.visit(quoteCloseTerminal));
        return text.toString();
    }

    @Override
    public String visitLineStringContent(final KotlinParser.LineStringContentContext context) {
        final TerminalNode lineStrTextTerminal = context.LineStrText();
        final TerminalNode lineStrEscapedCharTerminal = context.LineStrEscapedChar();
        final TerminalNode lineStrRefTerminal = context.LineStrRef();
        final StringBuilder text = new StringBuilder();
        if (lineStrTextTerminal != null) {
            text.append(this.visit(lineStrTextTerminal));
        } else if (lineStrEscapedCharTerminal != null) {
            text.append(this.visit(lineStrEscapedCharTerminal));
        } else if (lineStrRefTerminal != null) {
            text.append(this.visit(lineStrRefTerminal));
        }
        return text.toString();
    }

    @Override
    public String visitFunctionValueParameters(final KotlinParser.FunctionValueParametersContext context) {
        final TerminalNode lparenTerminal = context.LPAREN();
        final List<KotlinParser.FunctionValueParameterContext> functionValueParameterContexts = context.functionValueParameter();
        final List<TerminalNode> commaTerminals = context.COMMA();
        final TerminalNode rparenTerminal = context.RPAREN();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(lparenTerminal));
        if (!functionValueParameterContexts.isEmpty()) {
            final KotlinParser.FunctionValueParameterContext firstFunctionValueParameterContext = functionValueParameterContexts.get(0);
            text.append(this.visit(firstFunctionValueParameterContext));
            for (int index = 1; index < functionValueParameterContexts.size(); index++) {
                final TerminalNode commaTerminal = commaTerminals.get(index - 1);
                final KotlinParser.FunctionValueParameterContext functionValueParameterContext = functionValueParameterContexts.get(index);
                text.append(this.visit(commaTerminal))
                    .append(' ')
                    .append(this.visit(functionValueParameterContext));
            }
            if (functionValueParameterContexts.size() == commaTerminals.size()) {
                final TerminalNode commaTerminal = commaTerminals.get(commaTerminals.size() - 1);
                text.append(this.visit(commaTerminal));
            }
        }
        text.append(this.visit(rparenTerminal));
        return text.toString();
    }

    @Override
    public String visitFunctionValueParameter(final KotlinParser.FunctionValueParameterContext context) {
        final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
        final KotlinParser.ParameterContext parameterContext = context.parameter();
        final TerminalNode assignmentTerminal = context.ASSIGNMENT();
        // todo: use `expressionContext` with tests.
        final KotlinParser.ExpressionContext expressionContext = context.expression();
        final StringBuilder text = new StringBuilder();
        if (modifierListContext != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitFunctionValueParameter -> modifierList");
        }
        text.append(this.visit(parameterContext));
        if (assignmentTerminal != null) {
            throw new UnsupportedOperationException("The following parsing path is not supported yet: visitFunctionValueParameter -> assignment");
        }
        return text.toString();
    }

    @Override
    public String visitParameter(final KotlinParser.ParameterContext context) {
        final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
        final TerminalNode colonTerminal = context.COLON();
        final KotlinParser.TypeContext typeContext = context.type();
        final StringBuilder text = new StringBuilder();
        text.append(this.visit(simpleIdentifierContext))
            .append(this.visit(colonTerminal))
            .append(' ')
            .append(this.visit(typeContext));
        return text.toString();
    }

    @Override
    public String visitIdentifier(final KotlinParser.IdentifierContext context) {
        final List<KotlinParser.SimpleIdentifierContext> simpleIdentifierContexts = context.simpleIdentifier();
        final List<TerminalNode> dotTerminals = context.DOT();
        final StringBuilder text = new StringBuilder();
        final KotlinParser.SimpleIdentifierContext firstSimpleIdentifierContext = simpleIdentifierContexts.get(0);
        text.append(this.visit(firstSimpleIdentifierContext));
        for (int index = 0; index < dotTerminals.size(); index++) {
            final TerminalNode dotTerminal = dotTerminals.get(index);
            final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = simpleIdentifierContexts.get(index + 1);
            text.append(this.visit(dotTerminal))
                .append(this.visit(simpleIdentifierContext));
        }
        return text.toString();
    }

    @Override
    public String visitSimpleIdentifier(final KotlinParser.SimpleIdentifierContext context) {
        final TerminalNode identifierTerminal = context.Identifier();
        final TerminalNode abstractTerminal = context.ABSTRACT();
        final TerminalNode annotationTerminal = context.ANNOTATION();
        final TerminalNode byTerminal = context.BY();
        final TerminalNode catchTerminal = context.CATCH();
        final TerminalNode companionTerminal = context.COMPANION();
        final TerminalNode constructorTerminal = context.CONSTRUCTOR();
        final TerminalNode crossinlineTerminal = context.CROSSINLINE();
        final TerminalNode dataTerminal = context.DATA();
        final TerminalNode dynamicTerminal = context.DYNAMIC();
        final TerminalNode enumTerminal = context.ENUM();
        final TerminalNode externalTerminal = context.EXTERNAL();
        final TerminalNode finalTerminal = context.FINAL();
        final TerminalNode finallyTerminal = context.FINALLY();
        final TerminalNode getterTerminal = context.GETTER();
        final TerminalNode importTerminal = context.IMPORT();
        final TerminalNode infixTerminal = context.INFIX();
        final TerminalNode initTerminal = context.INIT();
        final TerminalNode inlineTerminal = context.INLINE();
        final TerminalNode innerTerminal = context.INNER();
        final TerminalNode internalTerminal = context.INTERNAL();
        final TerminalNode lateinitTerminal = context.LATEINIT();
        final TerminalNode noinlineTerminal = context.NOINLINE();
        final TerminalNode openTerminal = context.OPEN();
        final TerminalNode operatorTerminal = context.OPERATOR();
        final TerminalNode outTerminal = context.OUT();
        final TerminalNode overrideTerminal = context.OVERRIDE();
        final TerminalNode privateTerminal = context.PRIVATE();
        final TerminalNode protectedTerminal = context.PROTECTED();
        final TerminalNode publicTerminal = context.PUBLIC();
        final TerminalNode reifiedTerminal = context.REIFIED();
        final TerminalNode sealedTerminal = context.SEALED();
        final TerminalNode tailrecTerminal = context.TAILREC();
        final TerminalNode setterTerminal = context.SETTER();
        final TerminalNode varargTerminal = context.VARARG();
        final TerminalNode whereTerminal = context.WHERE();
        final TerminalNode constTerminal = context.CONST();
        final TerminalNode suspendTerminal = context.SUSPEND();
        final StringBuilder text = new StringBuilder();
        if (identifierTerminal != null) {
            text.append(this.visit(identifierTerminal));
        } else if (abstractTerminal != null) {
            text.append(this.visit(abstractTerminal));
        } else if (annotationTerminal != null) {
            text.append(this.visit(annotationTerminal));
        } else if (byTerminal != null) {
            text.append(this.visit(byTerminal));
        } else if (catchTerminal != null) {
            text.append(this.visit(catchTerminal));
        } else if (companionTerminal != null) {
            text.append(this.visit(companionTerminal));
        } else if (constructorTerminal != null) {
            text.append(this.visit(constructorTerminal));
        } else if (crossinlineTerminal != null) {
            text.append(this.visit(crossinlineTerminal));
        } else if (dataTerminal != null) {
            text.append(this.visit(dataTerminal));
        } else if (dynamicTerminal != null) {
            text.append(this.visit(dynamicTerminal));
        } else if (enumTerminal != null) {
            text.append(this.visit(enumTerminal));
        } else if (externalTerminal != null) {
            text.append(this.visit(externalTerminal));
        } else if (finalTerminal != null) {
            text.append(this.visit(finalTerminal));
        } else if (finallyTerminal != null) {
            text.append(this.visit(finallyTerminal));
        } else if (getterTerminal != null) {
            text.append(this.visit(getterTerminal));
        } else if (importTerminal != null) {
            text.append(this.visit(importTerminal));
        } else if (infixTerminal != null) {
            text.append(this.visit(infixTerminal));
        } else if (initTerminal != null) {
            text.append(this.visit(initTerminal));
        } else if (inlineTerminal != null) {
            text.append(this.visit(inlineTerminal));
        } else if (innerTerminal != null) {
            text.append(this.visit(innerTerminal));
        } else if (internalTerminal != null) {
            text.append(this.visit(internalTerminal));
        } else if (lateinitTerminal != null) {
            text.append(this.visit(lateinitTerminal));
        } else if (noinlineTerminal != null) {
            text.append(this.visit(noinlineTerminal));
        } else if (openTerminal != null) {
            text.append(this.visit(openTerminal));
        } else if (operatorTerminal != null) {
            text.append(this.visit(operatorTerminal));
        } else if (outTerminal != null) {
            text.append(this.visit(outTerminal));
        } else if (overrideTerminal != null) {
            text.append(this.visit(overrideTerminal));
        } else if (privateTerminal != null) {
            text.append(this.visit(privateTerminal));
        } else if (protectedTerminal != null) {
            text.append(this.visit(protectedTerminal));
        } else if (publicTerminal != null) {
            text.append(this.visit(publicTerminal));
        } else if (reifiedTerminal != null) {
            text.append(this.visit(reifiedTerminal));
        } else if (sealedTerminal != null) {
            text.append(this.visit(sealedTerminal));
        } else if (tailrecTerminal != null) {
            text.append(this.visit(tailrecTerminal));
        } else if (setterTerminal != null) {
            text.append(this.visit(setterTerminal));
        } else if (varargTerminal != null) {
            text.append(this.visit(varargTerminal));
        } else if (whereTerminal != null) {
            text.append(this.visit(whereTerminal));
        } else if (constTerminal != null) {
            text.append(this.visit(constTerminal));
        } else if (suspendTerminal != null) {
            text.append(this.visit(suspendTerminal));
        }
        return text.toString();
    }

    @Override
    public String visit(final ParseTree tree) {
        final String ruleName = tree.getClass().getSimpleName();
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Enter `{}` text: {}", ruleName, tree.getText());
        }
        return tree.accept(this);
    }

    @Override
    public String visitTerminal(final TerminalNode node) {
        return node.getText();
    }

    @Override
    public String visitChildren(final RuleNode node) {
        throw new UnsupportedOperationException(
            String.format(
                "The following rule is not implemented yet: %s text: %s",
                node.getClass(),
                node.getText()
            )
        );
    }

    private void appendNewLinesAndIndent(final StringBuilder text, final int newLines) {
        text.append("\n".repeat(newLines))
            .append(INDENT_UNIT.repeat(this.currentIndentLevel));
    }

}
