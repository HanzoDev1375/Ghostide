package io.github.rosemoe.sora.langs.kotlin;

import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/** This is the class that has the formatting logic. Welcome to the project :) */
// Excluding the following PMD rules via `ruleSet.xml` didn't work, for some reason.
// Except PMD.UnusedAssignment was added due to a false-positive.
@SuppressWarnings({"PMD.TooManyMethods", "PMD.LinguisticNaming", "PMD.UnusedAssignment"})
public class KotlinVisitor extends KotlinParserBaseVisitor<String> {

  /** For logging. */
  private static final Logger LOGGER = LoggerFactory.getLogger(KotlinVisitor.class);

  /** Number of spaces for an indentation. */
  private static final String INDENT_UNIT = "    ";

  /**
   * Whenever we visit a rule, we will record its count. The purpose is to know what went down when
   * we visit a child context. Ex: For example, we want to format the constructor call differently
   * if the child also calls the constructor (nested constructor calls). We can identify the nested
   * constructor calls by checking the constructor call counts after visiting the child context. Key
   * - Simple class name of the context. Ex: KotlinFileContext. Value - Number of visits.
   */
  private Map<String, Integer> ruleVisitCounts = new HashMap<>();

  /** As is. */
  private int currentIndentLevel;

  /** We will use this for formatting the method chain. */
  private int currentMethodCallCount;

  /** It's to check if we are currently chaining methods. */
  private boolean memberAccessing;

  /** For getting comments from the hidden channel. */
  private final CommonTokenStream tokens;

  /**
   * Constructor.
   *
   * @param tokens See {@link KotlinVisitor#tokens}.
   */
  public KotlinVisitor(final CommonTokenStream tokens) {
    this.tokens = tokens;
  }

  @Override
  public String visitKotlinFile(final KotlinParser.KotlinFileContext context) {
    final KotlinParser.PreambleContext preamble = context.preamble();
    final List<KotlinParser.TopLevelObjectContext> topLevelObjectContexts =
        context.topLevelObject();
    final StringBuilder text = new StringBuilder();
    if (!preamble.getText().isEmpty()) {
      text.append(this.visit(preamble));
      this.appendNewLinesAndIndent(text, 2);
    }
    for (int index = 0; index < topLevelObjectContexts.size(); index++) {
      final KotlinParser.TopLevelObjectContext topLevelObjectContext =
          topLevelObjectContexts.get(index);
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
      text.append(this.visit(fileAnnotationsContext));
    }
    if (!packageHeaderContext.getText().isEmpty()) {
      text.append(this.visit(packageHeaderContext));
      this.appendNewLinesAndIndent(text, 2);
    }
    text.append(this.visit(importListContext));
    return text.toString();
  }

  @Override
  public String visitFileAnnotations(final KotlinParser.FileAnnotationsContext context) {
    final List<KotlinParser.FileAnnotationContext> fileAnnotationContexts =
        context.fileAnnotation();
    final StringBuilder text = new StringBuilder();
    for (int index = 0; index < fileAnnotationContexts.size(); index++) {
      final KotlinParser.FileAnnotationContext fileAnnotationContext =
          fileAnnotationContexts.get(index);
      text.append(this.visit(fileAnnotationContext));
      if (index < fileAnnotationContexts.size() - 1) {
        this.appendNewLinesAndIndent(text, 2);
      }
    }
    return text.toString();
  }

  @Override
  public String visitFileAnnotation(final KotlinParser.FileAnnotationContext context) {
    final List<KotlinParser.FileAnnotationPartContext> fileAnnotationPartContexts =
        context.fileAnnotationPart();
    final StringBuilder text = new StringBuilder();
    for (final KotlinParser.FileAnnotationPartContext fileAnnotationPartContext :
        fileAnnotationPartContexts) {
      text.append(this.visit(fileAnnotationPartContext));
    }
    return text.toString();
  }

  @Override
  public String visitFileAnnotationPart(final KotlinParser.FileAnnotationPartContext context) {
    final TerminalNode fileTerminal = context.FILE();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.BracketedFileAnnotationPartContext bracketedFileAnnotationPartContext =
        context.bracketedFileAnnotationPart();
    final KotlinParser.UnescapedAnnotationContext unescapedAnnotationContext =
        context.unescapedAnnotation();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(fileTerminal)).append(this.visit(colonTerminal));
    if (bracketedFileAnnotationPartContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFileAnnotationPart -> bracketedFileAnnotationPart");
    } else if (unescapedAnnotationContext != null) {
      text.append(this.visit(unescapedAnnotationContext));
    }
    return text.toString();
  }

  @Override
  public String visitUnescapedAnnotation(final KotlinParser.UnescapedAnnotationContext context) {
    final KotlinParser.IdentifierContext identifierContext = context.identifier();
    final KotlinParser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final KotlinParser.ValueArgumentsContext valueArgumentsContext = context.valueArguments();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(identifierContext));
    if (typeArgumentsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitUnescapedAnnotation -> typeArguments");
    }
    if (valueArgumentsContext != null) {
      text.append(this.visit(valueArgumentsContext));
    }
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
    text.append(this.visit(importTerminal)).append(' ').append(this.visit(identifierContext));
    if (dotTerminal != null) {
      text.append(this.visit(dotTerminal)).append(this.visit(multTerminal));
    } else if (importAliasContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitImportHeader -> importAlias");
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
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitPackageHeader -> modifierList");
      }
      text.append(this.visit(packageTerminal)).append(' ').append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitTopLevelObject(final KotlinParser.TopLevelObjectContext context) {
    final KotlinParser.ClassDeclarationContext classDeclarationContext = context.classDeclaration();
    final KotlinParser.ObjectDeclarationContext objectDeclarationContext =
        context.objectDeclaration();
    final KotlinParser.FunctionDeclarationContext functionDeclarationContext =
        context.functionDeclaration();
    final KotlinParser.PropertyDeclarationContext propertyDeclarationContext =
        context.propertyDeclaration();
    final KotlinParser.TypeAliasContext typeAliasContext = context.typeAlias();
    final StringBuilder text = new StringBuilder();
    if (classDeclarationContext != null) {
      text.append(this.visit(classDeclarationContext));
    } else if (objectDeclarationContext != null) {
      text.append(this.visit(objectDeclarationContext));
    } else if (functionDeclarationContext != null) {
      text.append(this.visit(functionDeclarationContext));
    } else if (propertyDeclarationContext != null) {
      text.append(this.visit(propertyDeclarationContext));
    } else if (typeAliasContext != null) {
      text.append(this.visit(typeAliasContext));
    }
    return text.toString();
  }

  @Override
  public String visitObjectDeclaration(final KotlinParser.ObjectDeclarationContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode objectTerminal = context.OBJECT();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final KotlinParser.PrimaryConstructorContext primaryConstructorContext =
        context.primaryConstructor();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.DelegationSpecifiersContext delegationSpecifiersContext =
        context.delegationSpecifiers();
    final KotlinParser.ClassBodyContext classBodyContext = context.classBody();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext)).append(' ');
    }
    text.append(this.visit(objectTerminal)).append(' ').append(this.visit(simpleIdentifierContext));
    if (primaryConstructorContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitObjectDeclaration -> primaryConstructor");
    }
    if (colonTerminal != null) {
      text.append(' ')
          .append(this.visit(colonTerminal))
          .append(' ')
          .append(this.visit(delegationSpecifiersContext));
    }
    if (classBodyContext != null) {
      text.append(' ').append(this.visit(classBodyContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeAlias(final KotlinParser.TypeAliasContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode typeAliasTerminal = context.TYPE_ALIAS();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final KotlinParser.TypeParametersContext typeParametersContext = context.typeParameters();
    final TerminalNode assignmentTerminal = context.ASSIGNMENT();
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTypeAlias -> modifierList");
    }
    text.append(this.visit(typeAliasTerminal))
        .append(' ')
        .append(this.visit(simpleIdentifierContext));
    if (typeParametersContext != null) {
      text.append(this.visit(typeParametersContext));
    }
    text.append(' ')
        .append(this.visit(assignmentTerminal))
        .append(' ')
        .append(this.visit(typeContext));
    return text.toString();
  }

  @Override
  public String visitTypeParameters(final KotlinParser.TypeParametersContext context) {
    final TerminalNode langleTerminal = context.LANGLE();
    final List<KotlinParser.TypeParameterContext> typeParameterContexts = context.typeParameter();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rangleTerminal = context.RANGLE();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(langleTerminal));
    final KotlinParser.TypeParameterContext firstTypeParameter = typeParameterContexts.get(0);
    text.append(this.visit(firstTypeParameter));
    for (int index = 1; index < typeParameterContexts.size(); index++) {
      final TerminalNode commaTerminal = commaTerminals.get(index - 1);
      final KotlinParser.TypeParameterContext typeParameterContext =
          typeParameterContexts.get(index);
      text.append(this.visit(commaTerminal)).append(' ').append(this.visit(typeParameterContext));
    }
    if (typeParameterContexts.size() == commaTerminals.size()) {
      final TerminalNode commaTerminal = commaTerminals.get(commaTerminals.size() - 1);
      text.append(this.visit(commaTerminal));
    }
    text.append(this.visit(rangleTerminal));
    return text.toString();
  }

  @Override
  public String visitTypeParameter(final KotlinParser.TypeParameterContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final TerminalNode multTerminal = context.MULT();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext)).append(' ');
    }
    if (simpleIdentifierContext != null) {
      text.append(this.visit(simpleIdentifierContext));
    } else if (multTerminal != null) {
      text.append(this.visit(multTerminal));
    }
    if (colonTerminal != null) {
      text.append(' ')
          .append(this.visit(colonTerminal))
          .append(' ')
          .append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitClassDeclaration(final KotlinParser.ClassDeclarationContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode classTerminal = context.CLASS();
    final TerminalNode interfaceTerminal = context.INTERFACE();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final KotlinParser.TypeParametersContext typeParametersContext = context.typeParameters();
    final KotlinParser.PrimaryConstructorContext primaryConstructorContext =
        context.primaryConstructor();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.DelegationSpecifiersContext delegationSpecifiersContext =
        context.delegationSpecifiers();
    final KotlinParser.TypeConstraintsContext typeConstraintsContext = context.typeConstraints();
    final KotlinParser.ClassBodyContext classBodyContext = context.classBody();
    final KotlinParser.EnumClassBodyContext enumClassBodyContext = context.enumClassBody();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      final int visitAnnotationsCountBefore =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationsContext.class.getSimpleName(), 0);
      final String modifierListText = this.visit(modifierListContext);
      final int visitAnnotationsCountAfter =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationsContext.class.getSimpleName(), 0);
      text.append(modifierListText);
      if (visitAnnotationsCountBefore < visitAnnotationsCountAfter) {
        this.appendNewLinesAndIndent(text, 1);
      } else {
        text.append(' ');
      }
    }
    if (classTerminal != null) {
      text.append(this.visit(classTerminal));
    } else if (interfaceTerminal != null) {
      text.append(this.visit(interfaceTerminal));
    }
    text.append(' ').append(this.visit(simpleIdentifierContext));
    if (typeParametersContext != null) {
      text.append(this.visit(typeParametersContext));
    }
    if (primaryConstructorContext != null) {
      text.append(this.visit(primaryConstructorContext));
    }
    if (colonTerminal != null) {
      text.append(' ')
          .append(this.visit(colonTerminal))
          .append(' ')
          .append(this.visit(delegationSpecifiersContext));
    }
    if (typeConstraintsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitClassDeclaration -> typeConstraints");
    }
    if (classBodyContext != null) {
      text.append(' ').append(this.visit(classBodyContext));
    } else if (enumClassBodyContext != null) {
      text.append(' ').append(this.visit(enumClassBodyContext));
    }
    return text.toString();
  }

  @Override
  public String visitEnumClassBody(final KotlinParser.EnumClassBodyContext context) {
    final TerminalNode lcurlTerminal = context.LCURL();
    final KotlinParser.EnumEntriesContext enumEntriesContext = context.enumEntries();
    final TerminalNode semicolonTerminal = context.SEMICOLON();
    final List<KotlinParser.ClassMemberDeclarationContext> classMemberDeclarationContexts =
        context.classMemberDeclaration();
    final TerminalNode rcurlTerminal = context.RCURL();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lcurlTerminal));
    this.currentIndentLevel++;
    this.appendNewLinesAndIndent(text, 2);
    if (enumEntriesContext != null) {
      text.append(this.visit(enumEntriesContext));
    }
    if (semicolonTerminal != null) {
      text.append(this.visit(semicolonTerminal));
      for (int index = 0; index < classMemberDeclarationContexts.size(); index++) {
        if (index == 0) {
          this.appendNewLinesAndIndent(text, 2);
        }
        final KotlinParser.ClassMemberDeclarationContext classMemberDeclarationContext =
            classMemberDeclarationContexts.get(index);
        text.append(this.visit(classMemberDeclarationContext));
        if (index < classMemberDeclarationContexts.size() - 1) {
          this.appendNewLinesAndIndent(text, 2);
        }
      }
    }
    this.currentIndentLevel--;
    this.appendNewLinesAndIndent(text, 2);
    text.append(this.visit(rcurlTerminal));
    return text.toString();
  }

  @Override
  public String visitEnumEntries(final KotlinParser.EnumEntriesContext context) {
    final List<KotlinParser.EnumEntryContext> enumEntryContexts = context.enumEntry();
    final TerminalNode semicolonTerminal = context.SEMICOLON();
    final StringBuilder text = new StringBuilder();
    for (int index = 0; index < enumEntryContexts.size(); index++) {
      final KotlinParser.EnumEntryContext enumEntry = enumEntryContexts.get(index);
      text.append(this.visit(enumEntry));
      if (index < enumEntryContexts.size() - 1) {
        this.appendNewLinesAndIndent(text, 2);
      }
    }
    if (semicolonTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not uspported yet: visitEnumEntries -> semicolon");
    }
    return text.toString();
  }

  @Override
  public String visitEnumEntry(final KotlinParser.EnumEntryContext context) {
    final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final KotlinParser.ValueArgumentsContext valueArgumentsContext = context.valueArguments();
    final KotlinParser.ClassBodyContext classBodyContext = context.classBody();
    final TerminalNode commaTerminal = context.COMMA();
    final StringBuilder text = new StringBuilder();
    if (!annotationsContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitEnumEntry -> annotations");
    }
    text.append(this.visit(simpleIdentifierContext));
    if (valueArgumentsContext != null) {
      text.append(this.visit(valueArgumentsContext));
    }
    if (classBodyContext != null) {
      text.append(' ').append(this.visit(classBodyContext));
    }
    if (commaTerminal != null) {
      text.append(this.visit(commaTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitPrimaryConstructor(final KotlinParser.PrimaryConstructorContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode constructorTerminal = context.CONSTRUCTOR();
    final KotlinParser.ClassParametersContext classParametersContext = context.classParameters();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(' ').append(this.visit(modifierListContext));
    }
    if (constructorTerminal != null) {
      text.append(' ').append(this.visit(constructorTerminal));
    }
    text.append(this.visit(classParametersContext));
    return text.toString();
  }

  @Override
  public String visitClassParameters(final KotlinParser.ClassParametersContext context) {
    final TerminalNode lparenTerminal = context.LPAREN();
    final List<KotlinParser.ClassParameterContext> classParameterContexts =
        context.classParameter();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lparenTerminal));
    if (!classParameterContexts.isEmpty()) {
      final KotlinParser.ClassParameterContext firstClassParameter = classParameterContexts.get(0);
      text.append(this.visit(firstClassParameter));
      for (int index = 1; index < classParameterContexts.size(); index++) {
        final TerminalNode commaTerminal = commaTerminals.get(index - 1);
        final KotlinParser.ClassParameterContext classParameterContext =
            classParameterContexts.get(index);
        text.append(this.visit(commaTerminal))
            .append(' ')
            .append(this.visit(classParameterContext));
      }
      if (classParameterContexts.size() == commaTerminals.size()) {
        final TerminalNode commaTerminal = commaTerminals.get(commaTerminals.size() - 1);
        text.append(this.visit(commaTerminal));
      }
    }
    text.append(this.visit(rparenTerminal));
    return text.toString();
  }

  @Override
  public String visitClassParameter(final KotlinParser.ClassParameterContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode valTerminal = context.VAL();
    final TerminalNode varTerminal = context.VAR();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.TypeContext typeContext = context.type();
    final TerminalNode assignmentTerminal = context.ASSIGNMENT();
    // todo: use `expressionContext` with tests.
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext)).append(' ');
    }
    if (valTerminal != null) {
      text.append(this.visit(valTerminal)).append(' ');
    } else if (varTerminal != null) {
      text.append(this.visit(varTerminal)).append(' ');
    }
    text.append(this.visit(simpleIdentifierContext))
        .append(this.visit(colonTerminal))
        .append(' ')
        .append(this.visit(typeContext));
    if (assignmentTerminal != null) {
      text.append(' ')
          .append(this.visit(assignmentTerminal))
          .append(' ')
          .append(this.visit(expressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitDelegationSpecifiers(final KotlinParser.DelegationSpecifiersContext context) {
    final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
    final List<KotlinParser.DelegationSpecifierContext> delegationSpecifierContexts =
        context.delegationSpecifier();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final StringBuilder text = new StringBuilder();
    if (!annotationsContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDelegationSpecifiers -> annotations");
    }
    final KotlinParser.DelegationSpecifierContext firstDelegationSpecifierContext =
        delegationSpecifierContexts.get(0);
    text.append(this.visit(firstDelegationSpecifierContext));
    for (int index = 0; index < commaTerminals.size(); index++) {
      final TerminalNode commaTerminal = commaTerminals.get(index);
      final KotlinParser.DelegationSpecifierContext delegationSpecifierContext =
          delegationSpecifierContexts.get(index + 1);
      text.append(this.visit(commaTerminal))
          .append(' ')
          .append(this.visit(delegationSpecifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitDelegationSpecifier(final KotlinParser.DelegationSpecifierContext context) {
    final KotlinParser.ConstructorInvocationContext constructorInvocationContext =
        context.constructorInvocation();
    final KotlinParser.UserTypeContext userTypeContext = context.userType();
    final KotlinParser.ExplicitDelegationContext explicitDelegationContext =
        context.explicitDelegation();
    final StringBuilder text = new StringBuilder();
    if (constructorInvocationContext != null) {
      text.append(this.visit(constructorInvocationContext));
    } else if (userTypeContext != null) {
      text.append(this.visit(userTypeContext));
    } else if (explicitDelegationContext != null) {
      text.append(this.visit(explicitDelegationContext));
    }
    return text.toString();
  }

  @Override
  public String visitExplicitDelegation(final KotlinParser.ExplicitDelegationContext context) {
    final KotlinParser.UserTypeContext userTypeContext = context.userType();
    final TerminalNode byTerminal = context.BY();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(userTypeContext))
        .append(' ')
        .append(this.visit(byTerminal))
        .append(' ')
        .append(this.visit(expressionContext));
    return text.toString();
  }

  @Override
  public String visitConstructorInvocation(
      final KotlinParser.ConstructorInvocationContext context) {
    final KotlinParser.UserTypeContext userTypeContext = context.userType();
    final KotlinParser.CallSuffixContext callSuffixContext = context.callSuffix();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(userTypeContext)).append(this.visit(callSuffixContext));
    return text.toString();
  }

  @Override
  public String visitModifierList(final KotlinParser.ModifierListContext context) {
    final List<KotlinParser.AnnotationsOrModifierContext> annotationsOrModifierContexts =
        context.annotationsOrModifier();
    final StringBuilder text = new StringBuilder();
    for (int index = 0; index < annotationsOrModifierContexts.size(); index++) {
      final KotlinParser.AnnotationsOrModifierContext annotationsOrModifierContext =
          annotationsOrModifierContexts.get(index);
      final int visitAnnotationsCountBefore =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationsContext.class.getSimpleName(), 0);
      final String annotationsOrModifierText = this.visit(annotationsOrModifierContext);
      final int visitAnnotationsCountAfter =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationsContext.class.getSimpleName(), 0);
      text.append(annotationsOrModifierText);
      if (index < annotationsOrModifierContexts.size() - 1) {
        if (visitAnnotationsCountBefore < visitAnnotationsCountAfter) {
          this.appendNewLinesAndIndent(text, 1);
        } else {
          text.append(' ');
        }
      }
    }
    return text.toString();
  }

  @Override
  public String visitAnnotationsOrModifier(
      final KotlinParser.AnnotationsOrModifierContext context) {
    final KotlinParser.AnnotationsContext annotationsContext = context.annotations();
    final KotlinParser.ModifierContext modifierContext = context.modifier();
    final StringBuilder text = new StringBuilder();
    if (annotationsContext != null) {
      text.append(this.visit(annotationsContext));
    } else if (modifierContext != null) {
      text.append(this.visit(modifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitAnnotations(final KotlinParser.AnnotationsContext context) {
    final KotlinParser.AnnotationContext annotationContext = context.annotation();
    final KotlinParser.AnnotationListContext annotationListContext = context.annotationList();
    final StringBuilder text = new StringBuilder();
    if (annotationContext != null) {
      text.append(this.visit(annotationContext));
    } else if (annotationListContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAnnotations -> annotationList");
    }
    return text.toString();
  }

  @Override
  public String visitAnnotationList(final KotlinParser.AnnotationListContext context) {
    final KotlinParser.AnnotationUseSiteTargetContext annotationUseSiteTargetContext =
        context.annotationUseSiteTarget();
    // todo: use `colonTerminal`, `lsqaureTerminal`, `unescapedAnnotationContexts`, and
    // `rsqaureTerminal` with tests.
    final TerminalNode colonTerminal = context.COLON();
    final TerminalNode lsqaureTerminal = context.LSQUARE();
    final List<KotlinParser.UnescapedAnnotationContext> unescapedAnnotationContexts =
        context.unescapedAnnotation();
    final TerminalNode rsqaureTerminal = context.RSQUARE();
    final TerminalNode atTerminal = context.AT();
    final StringBuilder text = new StringBuilder();
    if (annotationUseSiteTargetContext != null) {
      // annotationUseSiteTarget COLON LSQUARE unescapedAnnotation+ RSQUARE
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAnnotationList -> annotationUseSiteTarget");
    } else if (atTerminal != null) {
      // AT LSQUARE unescapedAnnotation+ RSQUARE
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAnnotationList -> at");
    }
    return text.toString();
  }

  @Override
  public String visitAnnotation(final KotlinParser.AnnotationContext context) {
    final KotlinParser.AnnotationUseSiteTargetContext annotationUseSiteTargetContext =
        context.annotationUseSiteTarget();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.UnescapedAnnotationContext unescapedAnnotationContext =
        context.unescapedAnnotation();
    final TerminalNode labelReferenceTerminal = context.LabelReference();
    final List<TerminalNode> dotTerminals = context.DOT();
    // todo: use `simpleIdentifierContexts` with tests.
    final List<KotlinParser.SimpleIdentifierContext> simpleIdentifierContexts =
        context.simpleIdentifier();
    final KotlinParser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final KotlinParser.ValueArgumentsContext valueArgumentsContext = context.valueArguments();
    final StringBuilder text = new StringBuilder();
    if (annotationUseSiteTargetContext != null) {
      // annotationUseSiteTarget NL* COLON NL* unescapedAnnotation
      text.append(this.visit(annotationUseSiteTargetContext))
          .append(this.visit(colonTerminal))
          .append(this.visit(unescapedAnnotationContext));
    } else if (labelReferenceTerminal != null) {
      // LabelReference (NL* DOT NL* simpleIdentifier)* (NL* typeArguments)? (NL* valueArguments)?
      text.append(this.visit(labelReferenceTerminal));
      if (!dotTerminals.isEmpty()) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitAnnotation -> dot");
      }
      if (typeArgumentsContext != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitAnnotation -> typeArguments");
      }
      if (valueArgumentsContext != null) {
        text.append(this.visit(valueArgumentsContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitAnnotationUseSiteTarget(
      final KotlinParser.AnnotationUseSiteTargetContext context) {
    final TerminalNode fieldTerminal = context.FIELD();
    final TerminalNode fileTerminal = context.FILE();
    final TerminalNode propertyTerminal = context.PROPERTY();
    final TerminalNode getTerminal = context.GET();
    final TerminalNode setTerminal = context.SET();
    final TerminalNode receiverTerminal = context.RECEIVER();
    final TerminalNode paramTerminal = context.PARAM();
    final TerminalNode setparamTerminal = context.SETPARAM();
    final TerminalNode delegateTerminal = context.DELEGATE();
    final StringBuilder text = new StringBuilder();
    if (fieldTerminal != null) {
      text.append(this.visit(fieldTerminal));
    } else if (fileTerminal != null) {
      text.append(this.visit(fileTerminal));
    } else if (propertyTerminal != null) {
      text.append(this.visit(propertyTerminal));
    } else if (getTerminal != null) {
      text.append(this.visit(getTerminal));
    } else if (setTerminal != null) {
      text.append(this.visit(setTerminal));
    } else if (receiverTerminal != null) {
      text.append(this.visit(receiverTerminal));
    } else if (paramTerminal != null) {
      text.append(this.visit(paramTerminal));
    } else if (setparamTerminal != null) {
      text.append(this.visit(setparamTerminal));
    } else if (delegateTerminal != null) {
      text.append(this.visit(delegateTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitModifier(final KotlinParser.ModifierContext context) {
    final KotlinParser.ClassModifierContext classModifierContext = context.classModifier();
    final KotlinParser.MemberModifierContext memberModifierContext = context.memberModifier();
    final KotlinParser.VisibilityModifierContext visibilityModifierContext =
        context.visibilityModifier();
    final KotlinParser.VarianceAnnotationContext varianceAnnotationContext =
        context.varianceAnnotation();
    final KotlinParser.FunctionModifierContext functionModifierContext = context.functionModifier();
    final KotlinParser.PropertyModifierContext propertyModifierContext = context.propertyModifier();
    final KotlinParser.InheritanceModifierContext inheritanceModifierContext =
        context.inheritanceModifier();
    final KotlinParser.ParameterModifierContext parameterModifierContext =
        context.parameterModifier();
    final KotlinParser.TypeParameterModifierContext typeParameterModifierContext =
        context.typeParameterModifier();
    final StringBuilder text = new StringBuilder();
    if (classModifierContext != null) {
      text.append(this.visit(classModifierContext));
    } else if (memberModifierContext != null) {
      text.append(this.visit(memberModifierContext));
    } else if (visibilityModifierContext != null) {
      text.append(this.visit(visibilityModifierContext));
    } else if (varianceAnnotationContext != null) {
      text.append(this.visit(varianceAnnotationContext));
    } else if (functionModifierContext != null) {
      text.append(this.visit(functionModifierContext));
    } else if (propertyModifierContext != null) {
      text.append(this.visit(propertyModifierContext));
    } else if (inheritanceModifierContext != null) {
      text.append(this.visit(inheritanceModifierContext));
    } else if (parameterModifierContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitModifier -> parameterModifier");
    } else if (typeParameterModifierContext != null) {
      text.append(this.visit(typeParameterModifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeParameterModifier(
      final KotlinParser.TypeParameterModifierContext context) {
    final TerminalNode reifiedTerminal = context.REIFIED();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(reifiedTerminal));
    return text.toString();
  }

  @Override
  public String visitPropertyModifier(final KotlinParser.PropertyModifierContext context) {
    final TerminalNode constTerminal = context.CONST();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(constTerminal));
    return text.toString();
  }

  @Override
  public String visitFunctionModifier(final KotlinParser.FunctionModifierContext context) {
    final TerminalNode tailrecTerminal = context.TAILREC();
    final TerminalNode operatorTerminal = context.OPERATOR();
    final TerminalNode infixTerminal = context.INFIX();
    final TerminalNode inlineTerminal = context.INLINE();
    final TerminalNode externalTerminal = context.EXTERNAL();
    final TerminalNode suspendTerminal = context.SUSPEND();
    final StringBuilder text = new StringBuilder();
    if (tailrecTerminal != null) {
      text.append(this.visit(tailrecTerminal));
    } else if (operatorTerminal != null) {
      text.append(this.visit(operatorTerminal));
    } else if (infixTerminal != null) {
      text.append(this.visit(infixTerminal));
    } else if (inlineTerminal != null) {
      text.append(this.visit(inlineTerminal));
    } else if (externalTerminal != null) {
      text.append(this.visit(externalTerminal));
    } else if (suspendTerminal != null) {
      text.append(this.visit(suspendTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitVisibilityModifier(final KotlinParser.VisibilityModifierContext context) {
    final TerminalNode publicTerminal = context.PUBLIC();
    final TerminalNode privateTerminal = context.PRIVATE();
    final TerminalNode internalTerminal = context.INTERNAL();
    final TerminalNode protectedTerminal = context.PROTECTED();
    final StringBuilder text = new StringBuilder();
    if (publicTerminal != null) {
      text.append(this.visit(publicTerminal));
    } else if (privateTerminal != null) {
      text.append(this.visit(privateTerminal));
    } else if (internalTerminal != null) {
      text.append(this.visit(internalTerminal));
    } else if (protectedTerminal != null) {
      text.append(this.visit(protectedTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitClassModifier(final KotlinParser.ClassModifierContext context) {
    final TerminalNode enumTerminal = context.ENUM();
    final TerminalNode sealedTerminal = context.SEALED();
    final TerminalNode annotationTerminal = context.ANNOTATION();
    final TerminalNode dataTerminal = context.DATA();
    final TerminalNode innerTerminal = context.INNER();
    final StringBuilder text = new StringBuilder();
    if (enumTerminal != null) {
      text.append(this.visit(enumTerminal));
    } else if (sealedTerminal != null) {
      text.append(this.visit(sealedTerminal));
    } else if (annotationTerminal != null) {
      text.append(this.visit(annotationTerminal));
    } else if (dataTerminal != null) {
      text.append(this.visit(dataTerminal));
    } else if (innerTerminal != null) {
      text.append(this.visit(innerTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitMemberModifier(final KotlinParser.MemberModifierContext context) {
    final TerminalNode overrideTerminal = context.OVERRIDE();
    final TerminalNode lateinitTerminal = context.LATEINIT();
    final StringBuilder text = new StringBuilder();
    if (overrideTerminal != null) {
      text.append(this.visit(overrideTerminal));
    } else if (lateinitTerminal != null) {
      text.append(this.visit(lateinitTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitInheritanceModifier(final KotlinParser.InheritanceModifierContext context) {
    final TerminalNode abstractTerminal = context.ABSTRACT();
    final TerminalNode finalTerminal = context.FINAL();
    final TerminalNode openTerminal = context.OPEN();
    final StringBuilder text = new StringBuilder();
    if (abstractTerminal != null) {
      text.append(this.visit(abstractTerminal));
    } else if (finalTerminal != null) {
      text.append(this.visit(finalTerminal));
    } else if (openTerminal != null) {
      text.append(this.visit(openTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitClassBody(final KotlinParser.ClassBodyContext context) {
    final TerminalNode lcurlTerminal = context.LCURL();
    final List<KotlinParser.ClassMemberDeclarationContext> classMemberDeclarationContexts =
        context.classMemberDeclaration();
    final TerminalNode rcurlTerminal = context.RCURL();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lcurlTerminal));
    if (!classMemberDeclarationContexts.isEmpty()) {
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 2);
      for (int index = 0; index < classMemberDeclarationContexts.size(); index++) {
        final KotlinParser.ClassMemberDeclarationContext classMemberDeclarationContext =
            classMemberDeclarationContexts.get(index);
        text.append(this.visit(classMemberDeclarationContext));
        if (index < classMemberDeclarationContexts.size() - 1) {
          this.appendNewLinesAndIndent(text, 2);
        }
      }
      this.currentIndentLevel--;
      this.appendNewLinesAndIndent(text, 2);
    }
    text.append(this.visit(rcurlTerminal));
    return text.toString();
  }

  @Override
  public String visitClassMemberDeclaration(
      final KotlinParser.ClassMemberDeclarationContext context) {
    final KotlinParser.ClassDeclarationContext classDeclarationContext = context.classDeclaration();
    final KotlinParser.FunctionDeclarationContext functionDeclarationContext =
        context.functionDeclaration();
    final KotlinParser.ObjectDeclarationContext objectDeclarationContext =
        context.objectDeclaration();
    final KotlinParser.CompanionObjectContext companionObjectContext = context.companionObject();
    final KotlinParser.PropertyDeclarationContext propertyDeclarationContext =
        context.propertyDeclaration();
    final KotlinParser.AnonymousInitializerContext anonymousInitializerContext =
        context.anonymousInitializer();
    final KotlinParser.SecondaryConstructorContext secondaryConstructorContext =
        context.secondaryConstructor();
    final KotlinParser.TypeAliasContext typeAliasContext = context.typeAlias();
    final StringBuilder text = new StringBuilder();
    if (classDeclarationContext != null) {
      text.append(this.visit(classDeclarationContext));
    } else if (functionDeclarationContext != null) {
      text.append(this.visit(functionDeclarationContext));
    } else if (objectDeclarationContext != null) {
      text.append(this.visit(objectDeclarationContext));
    } else if (companionObjectContext != null) {
      text.append(this.visit(companionObjectContext));
    } else if (propertyDeclarationContext != null) {
      text.append(this.visit(propertyDeclarationContext));
    } else if (anonymousInitializerContext != null) {
      text.append(this.visit(anonymousInitializerContext));
    } else if (secondaryConstructorContext != null) {
      text.append(this.visit(secondaryConstructorContext));
    } else if (typeAliasContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitClassMemberDeclaration -> typeAlias");
    }
    return text.toString();
  }

  @Override
  public String visitAnonymousInitializer(final KotlinParser.AnonymousInitializerContext context) {
    final TerminalNode initTerminal = context.INIT();
    final KotlinParser.BlockContext blockContext = context.block();
    final StringBuilder text = new StringBuilder();
    text.append(initTerminal).append(' ').append(this.visit(blockContext));
    return text.toString();
  }

  @Override
  public String visitCompanionObject(final KotlinParser.CompanionObjectContext context) {
    final List<KotlinParser.ModifierListContext> modifierListContexts = context.modifierList();
    final TerminalNode companionTerminal = context.COMPANION();
    final TerminalNode objectTerminal = context.OBJECT();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final TerminalNode colonTerminal = context.COLON();
    // todo: use `delegationSpecifiersContext` with tests.
    final KotlinParser.DelegationSpecifiersContext delegationSpecifiersContext =
        context.delegationSpecifiers();
    final KotlinParser.ClassBodyContext classBodyContext = context.classBody();
    final StringBuilder text = new StringBuilder();
    if (!modifierListContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompanionObject -> modifierList");
    }
    text.append(this.visit(companionTerminal)).append(' ').append(this.visit(objectTerminal));
    if (simpleIdentifierContext != null) {
      text.append(' ').append(this.visit(simpleIdentifierContext));
    }
    if (colonTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompanionObject -> colon");
    }
    if (classBodyContext != null) {
      text.append(' ').append(this.visit(classBodyContext));
    }
    return text.toString();
  }

  @Override
  public String visitSecondaryConstructor(final KotlinParser.SecondaryConstructorContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode constructorTerminal = context.CONSTRUCTOR();
    final KotlinParser.FunctionValueParametersContext functionValueParametersContext =
        context.functionValueParameters();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.ConstructorDelegationCallContext constructorDelegationCallContext =
        context.constructorDelegationCall();
    final KotlinParser.BlockContext blockContext = context.block();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext)).append(' ');
    }
    text.append(this.visit(constructorTerminal)).append(this.visit(functionValueParametersContext));
    if (colonTerminal != null) {
      text.append(' ')
          .append(this.visit(colonTerminal))
          .append(' ')
          .append(this.visit(constructorDelegationCallContext));
    }
    if (blockContext != null) {
      text.append(' ').append(this.visit(blockContext));
    }
    return text.toString();
  }

  @Override
  public String visitConstructorDelegationCall(
      final KotlinParser.ConstructorDelegationCallContext context) {
    final TerminalNode thisTerminal = context.THIS();
    final KotlinParser.ValueArgumentsContext valueArgumentsContext = context.valueArguments();
    final TerminalNode superTerminal = context.SUPER();
    final StringBuilder text = new StringBuilder();
    if (thisTerminal != null) {
      text.append(this.visit(thisTerminal)).append(this.visit(valueArgumentsContext));
    } else if (superTerminal != null) {
      text.append(this.visit(superTerminal)).append(this.visit(valueArgumentsContext));
    }
    return text.toString();
  }

  @Override
  public String visitFunctionDeclaration(final KotlinParser.FunctionDeclarationContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode funTerminal = context.FUN();
    final KotlinParser.FirstTypeOfFuncDeclarationContext firstTypeOfFuncDeclarationContext =
        context.firstTypeOfFuncDeclaration();
    final KotlinParser.TypeParametersContext typeParametersContext = context.typeParameters();
    final KotlinParser.ReceiverTypeContext receiverTypeContext = context.receiverType();
    final TerminalNode dotTerminal = context.DOT();
    final KotlinParser.IdentifierContext identifierContext = context.identifier();
    final KotlinParser.FunctionValueParametersContext functionValueParametersContext =
        context.functionValueParameters();
    final KotlinParser.TypeContext typeContext = context.type();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.TypeConstraintsContext typeConstraintsContext = context.typeConstraints();
    final KotlinParser.FunctionBodyContext functionBodyContext = context.functionBody();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      final int visitAnnotationsCountBefore =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationsContext.class.getSimpleName(), 0);
      final String modifierListText = this.visit(modifierListContext);
      final int visitAnnotationsCountAfter =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationsContext.class.getSimpleName(), 0);
      text.append(modifierListText);
      if (visitAnnotationsCountBefore < visitAnnotationsCountAfter) {
        this.appendNewLinesAndIndent(text, 1);
      } else {
        text.append(' ');
      }
    }
    text.append(this.visit(funTerminal)).append(' ');
    if (firstTypeOfFuncDeclarationContext != null) {
      text.append(this.visit(firstTypeOfFuncDeclarationContext));
    }
    if (typeParametersContext != null) {
      text.append(this.visit(typeParametersContext)).append(' ');
    }
    if (receiverTypeContext != null) {
      text.append(this.visit(receiverTypeContext)).append(this.visit(dotTerminal));
    }
    if (identifierContext != null) {
      text.append(this.visit(identifierContext));
    }
    if (functionValueParametersContext != null) {
      text.append(this.visit(functionValueParametersContext));
    }
    if (typeContext != null) {
      text.append(this.visit(colonTerminal)).append(' ').append(this.visit(typeContext));
    }
    if (typeConstraintsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionDeclaration -> typeConstraints");
    }
    if (functionBodyContext != null) {
      text.append(' ').append(this.visit(functionBodyContext));
    }
    return text.toString();
  }

  @Override
  public String visitReceiverType(final KotlinParser.ReceiverTypeContext context) {
    final KotlinParser.TypeModifierListContext modifierListContext = context.typeModifierList();
    final KotlinParser.ParenthesizedTypeContext parenthesizedTypeContext =
        context.parenthesizedType();
    final KotlinParser.NullableTypeContext nullableTypeContext = context.nullableType();
    final KotlinParser.TypeReferenceContext typeReferenceContext = context.typeReference();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext)).append(' ');
    }
    if (parenthesizedTypeContext != null) {
      text.append(this.visit(parenthesizedTypeContext));
    } else if (nullableTypeContext != null) {
      text.append(this.visit(nullableTypeContext));
    } else if (typeReferenceContext != null) {
      text.append(this.visit(typeReferenceContext));
    }
    return text.toString();
  }

  @Override
  public String visitFirstTypeOfFuncDeclaration(
      final KotlinParser.FirstTypeOfFuncDeclarationContext context) {
    final KotlinParser.TypeContext typeContext = context.type();
    final TerminalNode dotTerminal = context.DOT();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(typeContext)).append(this.visit(dotTerminal));
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
      text.append(this.visit(assignmentTerminal)).append(' ').append(this.visit(expressionContext));
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
    // The `statements` context depends on the current indent level.
    // That's why we need to assume the `statements` context is not empty and increase the indent
    // level before parsing it.
    this.currentIndentLevel++;
    final String statementsText = this.visit(statementsContext);
    if (statementsText.trim().isEmpty()) {
      this.currentIndentLevel--;
    } else {
      this.appendNewLinesAndIndent(text, 1);
      text.append(statementsText);
      this.currentIndentLevel--;
      this.appendNewLinesAndIndent(text, 1);
    }
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
    final KotlinParser.BlockLevelExpressionContext blockLevelExpressionContext =
        context.blockLevelExpression();
    final StringBuilder text = new StringBuilder();
    this.currentMethodCallCount = 0;
    if (declarationContext != null) {
      text.append(this.visit(declarationContext));
    } else if (blockLevelExpressionContext != null) {
      text.append(this.visit(blockLevelExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitDeclaration(final KotlinParser.DeclarationContext context) {
    final List<KotlinParser.LabelDefinitionContext> labelDefinitionContexts =
        context.labelDefinition();
    final KotlinParser.ClassDeclarationContext classDeclarationContext = context.classDeclaration();
    final KotlinParser.FunctionDeclarationContext functionDeclarationContext =
        context.functionDeclaration();
    final KotlinParser.PropertyDeclarationContext propertyDeclarationContext =
        context.propertyDeclaration();
    final KotlinParser.TypeAliasContext typeAliasContext = context.typeAlias();
    final StringBuilder text = new StringBuilder();
    if (!labelDefinitionContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> labelDefinition");
    }
    if (classDeclarationContext != null) {
      text.append(this.visit(classDeclarationContext));
    } else if (functionDeclarationContext != null) {
      text.append(this.visit(functionDeclarationContext));
    } else if (propertyDeclarationContext != null) {
      text.append(this.visit(propertyDeclarationContext));
    } else if (typeAliasContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> typeAlias");
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
    final TerminalNode dotTerminal = context.DOT();
    final KotlinParser.MultiVariableDeclarationContext multiVariableDeclarationContext =
        context.multiVariableDeclaration();
    final KotlinParser.VariableDeclarationContext variableDeclarationContext =
        context.variableDeclaration();
    final KotlinParser.TypeConstraintsContext typeConstraintsContext = context.typeConstraints();
    final TerminalNode byTerminal = context.BY();
    final TerminalNode assignmentTerminal = context.ASSIGNMENT();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final KotlinParser.GetterPartOfPropertyDeclarationContext
        getterPartOfPropertyDeclarationContext = context.getterPartOfPropertyDeclaration();
    final KotlinParser.SetterPartOfPropertyDeclarationContext
        setterPartOfPropertyDeclarationContext = context.setterPartOfPropertyDeclaration();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      final int visitAnnotationCountBefore =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationContext.class.getSimpleName(), 0);
      final String modifierListText = this.visit(modifierListContext);
      final int visitAnnotationCountAfter =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.AnnotationContext.class.getSimpleName(), 0);
      text.append(modifierListText);
      if (visitAnnotationCountBefore < visitAnnotationCountAfter) {
        this.appendNewLinesAndIndent(text, 1);
      } else {
        text.append(' ');
      }
    }
    if (valTerminal != null) {
      text.append(this.visit(valTerminal)).append(' ');
    } else if (varTerminal != null) {
      text.append(this.visit(varTerminal)).append(' ');
    }
    if (typeParametersContext != null) {
      // (NL* typeParameters)?
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitPropertyDeclaration -> typeParameters");
    }
    if (typeContext != null) {
      // (NL* type NL* DOT)?
      text.append(this.visit(typeContext)).append(this.visit(dotTerminal));
    }
    // NL* (multiVariableDeclaration | variableDeclaration)
    if (multiVariableDeclarationContext != null) {
      text.append(this.visit(multiVariableDeclarationContext));
    } else if (variableDeclarationContext != null) {
      text.append(this.visit(variableDeclarationContext));
    }
    if (typeConstraintsContext != null) {
      // (NL* typeConstraints)?
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitPropertyDeclaration -> typeConstraints");
    }
    if (expressionContext != null) {
      // (NL* (BY | ASSIGNMENT) NL* expression)?
      text.append(' ');
      if (byTerminal != null) {
        text.append(this.visit(byTerminal));
      } else if (assignmentTerminal != null) {
        text.append(this.visit(assignmentTerminal));
      }
      text.append(' ').append(this.visit(expressionContext));
    }
    if (getterPartOfPropertyDeclarationContext != null) {
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(getterPartOfPropertyDeclarationContext));
      this.currentIndentLevel--;
    } else if (setterPartOfPropertyDeclarationContext != null) {
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(setterPartOfPropertyDeclarationContext));
      this.currentIndentLevel--;
    }
    return text.toString();
  }

  @Override
  public String visitGetterPartOfPropertyDeclaration(
      final KotlinParser.GetterPartOfPropertyDeclarationContext context) {
    final KotlinParser.GetterContext getterContext = context.getter();
    final KotlinParser.SetterContext setterContext = context.setter();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(getterContext));
    if (setterContext != null) {
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(setterContext));
    }
    return text.toString();
  }

  @Override
  public String visitSetterPartOfPropertyDeclaration(
      final KotlinParser.SetterPartOfPropertyDeclarationContext context) {
    final KotlinParser.SetterContext setterContext = context.setter();
    final KotlinParser.GetterContext getterContext = context.getter();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(setterContext));
    if (getterContext != null) {
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(getterContext));
    }
    return text.toString();
  }

  @Override
  public String visitGetter(final KotlinParser.GetterContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode getterTerminal = context.GETTER();
    final TerminalNode lparenTerminal = context.LPAREN();
    final TerminalNode rparenTerminal = context.RPAREN();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.TypeContext typeContext = context.type();
    final KotlinParser.BlockContext blockContext = context.block();
    final TerminalNode assignmentTerminal = context.ASSIGNMENT();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext));
      this.appendNewLinesAndIndent(text, 1);
    }
    text.append(this.visit(getterTerminal));
    if (lparenTerminal != null) {
      // LPAREN RPAREN (NL* COLON NL* type)? NL* (block | ASSIGNMENT NL* expression)
      text.append(this.visit(lparenTerminal)).append(this.visit(rparenTerminal));
      if (colonTerminal != null) {
        text.append(this.visit(colonTerminal)).append(' ').append(this.visit(typeContext));
      }
      text.append(' ');
      if (blockContext != null) {
        text.append(this.visit(blockContext));
      } else if (assignmentTerminal != null) {
        text.append(this.visit(assignmentTerminal))
            .append(' ')
            .append(this.visit(expressionContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitSetter(final KotlinParser.SetterContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final TerminalNode setterTerminal = context.SETTER();
    final TerminalNode lparenTerminal = context.LPAREN();
    final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
    final List<KotlinParser.ParameterModifierContext> parameterModifierContexts =
        context.parameterModifier();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final KotlinParser.ParameterContext parameterContext = context.parameter();
    final TerminalNode rparenTerminal = context.RPAREN();
    final KotlinParser.FunctionBodyContext functionBodyContext = context.functionBody();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext));
      this.appendNewLinesAndIndent(text, 1);
    }
    text.append(this.visit(setterTerminal));
    if (lparenTerminal != null) {
      // LPAREN (annotations | parameterModifier)* (simpleIdentifier | parameter) RPAREN NL*
      // functionBody
      text.append(this.visit(lparenTerminal));
      if (!annotationsContexts.isEmpty()) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitSetter -> annotations");
      }
      if (!parameterModifierContexts.isEmpty()) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitSetter -> parameterModifier");
      }
      if (simpleIdentifierContext != null) {
        text.append(this.visit(simpleIdentifierContext));
      } else if (parameterContext != null) {
        text.append(this.visit(parameterContext));
      }
      text.append(this.visit(rparenTerminal)).append(' ').append(this.visit(functionBodyContext));
    }
    return text.toString();
  }

  @Override
  public String visitMultiVariableDeclaration(
      final KotlinParser.MultiVariableDeclarationContext context) {
    final TerminalNode lparenTerminal = context.LPAREN();
    final List<KotlinParser.VariableDeclarationContext> variableDeclarationContexts =
        context.variableDeclaration();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lparenTerminal));
    final KotlinParser.VariableDeclarationContext firstVariableDeclarationContext =
        variableDeclarationContexts.get(0);
    text.append(this.visit(firstVariableDeclarationContext));
    for (int index = 0; index < commaTerminals.size(); index++) {
      final TerminalNode commaTerminal = commaTerminals.get(index);
      final KotlinParser.VariableDeclarationContext variableDeclarationContext =
          variableDeclarationContexts.get(index + 1);
      text.append(this.visit(commaTerminal))
          .append(' ')
          .append(this.visit(variableDeclarationContext));
    }
    text.append(this.visit(rparenTerminal));
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
      text.append(this.visit(colonTerminal)).append(' ').append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitType(final KotlinParser.TypeContext context) {
    final KotlinParser.TypeModifierListContext typeModifierListContext = context.typeModifierList();
    final KotlinParser.FunctionTypeContext functionTypeContext = context.functionType();
    final KotlinParser.ParenthesizedTypeContext parenthesizedTypeContext =
        context.parenthesizedType();
    final KotlinParser.NullableTypeContext nullableTypeContext = context.nullableType();
    final KotlinParser.TypeReferenceContext typeReferenceContext = context.typeReference();
    final StringBuilder text = new StringBuilder();
    if (typeModifierListContext != null) {
      text.append(this.visit(typeModifierListContext)).append(' ');
    }
    if (functionTypeContext != null) {
      text.append(this.visit(functionTypeContext));
    } else if (parenthesizedTypeContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitType -> parenthesizedType");
    } else if (nullableTypeContext != null) {
      text.append(this.visit(nullableTypeContext));
    } else if (typeReferenceContext != null) {
      text.append(this.visit(typeReferenceContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeModifierList(final KotlinParser.TypeModifierListContext context) {
    final List<KotlinParser.AnnotationsOrSuspendContext> annotationsOrSuspendContexts =
        context.annotationsOrSuspend();
    final StringBuilder text = new StringBuilder();
    for (int index = 0; index < annotationsOrSuspendContexts.size(); index++) {
      final KotlinParser.AnnotationsOrSuspendContext annotationsOrSuspendContext =
          annotationsOrSuspendContexts.get(index);
      text.append(this.visit(annotationsOrSuspendContext));
      if (index < annotationsOrSuspendContexts.size() - 1) {
        text.append(' ');
      }
    }
    return text.toString();
  }

  @Override
  public String visitAnnotationsOrSuspend(final KotlinParser.AnnotationsOrSuspendContext context) {
    final KotlinParser.AnnotationsContext annotationsContext = context.annotations();
    final TerminalNode suspendTerminal = context.SUSPEND();
    final StringBuilder text = new StringBuilder();
    if (annotationsContext != null) {
      text.append(this.visit(annotationsContext));
    } else if (suspendTerminal != null) {
      text.append(this.visit(suspendTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitFunctionType(final KotlinParser.FunctionTypeContext context) {
    final KotlinParser.FunctionTypeReceiverContext functionTypeReceiverContext =
        context.functionTypeReceiver();
    final TerminalNode dotTerminal = context.DOT();
    final KotlinParser.FunctionTypeParametersContext functionTypeParametersContext =
        context.functionTypeParameters();
    final TerminalNode arrowTerminal = context.ARROW();
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (functionTypeReceiverContext != null) {
      text.append(this.visit(functionTypeReceiverContext)).append(this.visit(dotTerminal));
    }
    text.append(this.visit(functionTypeParametersContext))
        .append(' ')
        .append(this.visit(arrowTerminal))
        .append(' ')
        .append(this.visit(typeContext));
    return text.toString();
  }

  @Override
  public String visitFunctionTypeReceiver(final KotlinParser.FunctionTypeReceiverContext context) {
    final KotlinParser.ParenthesizedTypeContext parenthesizedTypeContext =
        context.parenthesizedType();
    final KotlinParser.NullableTypeContext nullableTypeContext = context.nullableType();
    final KotlinParser.TypeReferenceContext typeReferenceContext = context.typeReference();
    final StringBuilder text = new StringBuilder();
    if (parenthesizedTypeContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionTypeReceiver -> parenthesizedType");
    } else if (nullableTypeContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionTypeReceiver -> nullableType");
    } else if (typeReferenceContext != null) {
      text.append(this.visit(typeReferenceContext));
    }
    return text.toString();
  }

  @Override
  public String visitFunctionTypeParameters(
      final KotlinParser.FunctionTypeParametersContext context) {
    final TerminalNode lparenTerminal = context.LPAREN();
    final KotlinParser.FirstParamOrTypeOfFuncTypeParamsContext
        firstParamOrTypeOfFuncTypeParamsContext = context.firstParamOrTypeOfFuncTypeParams();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final List<KotlinParser.SecondParamOrTypeOfFuncTypeParamsContext>
        secondParamOrTypeOfFuncTypeParamsContexts = context.secondParamOrTypeOfFuncTypeParams();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lparenTerminal));
    if (firstParamOrTypeOfFuncTypeParamsContext != null) {
      text.append(this.visit(firstParamOrTypeOfFuncTypeParamsContext));
    }
    for (int index = 0; index < secondParamOrTypeOfFuncTypeParamsContexts.size(); index++) {
      final TerminalNode commaTerminal = context.COMMA(index);
      final KotlinParser.SecondParamOrTypeOfFuncTypeParamsContext
          secondParamOrTypeOfFuncTypeParamsContext =
              secondParamOrTypeOfFuncTypeParamsContexts.get(index);
      text.append(this.visit(commaTerminal))
          .append(' ')
          .append(this.visit(secondParamOrTypeOfFuncTypeParamsContext));
    }
    if (secondParamOrTypeOfFuncTypeParamsContexts.size() < commaTerminals.size()) {
      final TerminalNode commaTerminal = commaTerminals.get(commaTerminals.size() - 1);
      text.append(this.visit(commaTerminal));
    }
    text.append(this.visit(rparenTerminal));
    return text.toString();
  }

  @Override
  public String visitFirstParamOrTypeOfFuncTypeParams(
      final KotlinParser.FirstParamOrTypeOfFuncTypeParamsContext context) {
    final KotlinParser.ParameterContext parameterContext = context.parameter();
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (parameterContext != null) {
      text.append(this.visit(parameterContext));
    } else if (typeContext != null) {
      text.append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitSecondParamOrTypeOfFuncTypeParams(
      final KotlinParser.SecondParamOrTypeOfFuncTypeParamsContext context) {
    final KotlinParser.ParameterContext parameterContext = context.parameter();
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (parameterContext != null) {
      text.append(this.visit(parameterContext));
    } else if (typeContext != null) {
      text.append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitNullableType(final KotlinParser.NullableTypeContext context) {
    final KotlinParser.TypeReferenceContext typeReferenceContext = context.typeReference();
    final KotlinParser.ParenthesizedTypeContext parenthesizedTypeContext =
        context.parenthesizedType();
    final List<TerminalNode> questTerminals = context.QUEST();
    final StringBuilder text = new StringBuilder();
    if (typeReferenceContext != null) {
      text.append(this.visit(typeReferenceContext));
    } else if (parenthesizedTypeContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNullableType -> parenthesizedType");
    }
    if (!questTerminals.isEmpty()) {
      final TerminalNode questTerminal = questTerminals.get(0);
      text.append(this.visit(questTerminal));
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
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTypeReference -> lparen");
    } else if (userTypeContext != null) {
      text.append(this.visit(userTypeContext));
    } else if (dynamicTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTypeReference -> dynamic");
    }
    return text.toString();
  }

  @Override
  public String visitUserType(final KotlinParser.UserTypeContext context) {
    final List<KotlinParser.SimpleUserTypeContext> simpleUserTypeContexts =
        context.simpleUserType();
    final List<TerminalNode> dotTerminals = context.DOT();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.SimpleUserTypeContext firstSimpleUserTypeContext =
        simpleUserTypeContexts.get(0);
    text.append(this.visit(firstSimpleUserTypeContext));
    for (int index = 0; index < dotTerminals.size(); index++) {
      final TerminalNode dotTerminal = dotTerminals.get(index);
      final KotlinParser.SimpleUserTypeContext simpleUserTypeContext =
          simpleUserTypeContexts.get(index + 1);
      text.append(this.visit(dotTerminal)).append(this.visit(simpleUserTypeContext));
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
      text.append(this.visit(typeArgumentsContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeArguments(final KotlinParser.TypeArgumentsContext context) {
    final TerminalNode langleTerminal = context.LANGLE();
    final List<KotlinParser.TypeProjectionContext> typeProjectionContexts =
        context.typeProjection();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rangleTerminal = context.RANGLE();
    final TerminalNode questTerminal = context.QUEST();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(langleTerminal));
    final KotlinParser.TypeProjectionContext firstTypeProjectionContext =
        typeProjectionContexts.get(0);
    text.append(this.visit(firstTypeProjectionContext));
    for (int index = 1; index < typeProjectionContexts.size(); index++) {
      final TerminalNode commaTerminal = commaTerminals.get(index - 1);
      final KotlinParser.TypeProjectionContext typeProjectionContext =
          typeProjectionContexts.get(index);
      text.append(this.visit(commaTerminal)).append(' ').append(this.visit(typeProjectionContext));
    }
    if (typeProjectionContexts.size() == commaTerminals.size()) {
      final TerminalNode commaTerminal = commaTerminals.get(commaTerminals.size() - 1);
      text.append(this.visit(commaTerminal));
    }
    text.append(this.visit(rangleTerminal));
    if (questTerminal != null) {
      text.append(this.visit(questTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitTypeProjection(final KotlinParser.TypeProjectionContext context) {
    final KotlinParser.TypeProjectionModifierListContext typeProjectionModifierListContext =
        context.typeProjectionModifierList();
    final KotlinParser.TypeContext typeContext = context.type();
    final TerminalNode multTerminal = context.MULT();
    final StringBuilder text = new StringBuilder();
    if (typeContext != null) {
      if (typeProjectionModifierListContext != null) {
        text.append(this.visit(typeProjectionModifierListContext)).append(' ');
      }
      text.append(this.visit(typeContext));
    } else if (multTerminal != null) {
      text.append(this.visit(multTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitTypeProjectionModifierList(
      final KotlinParser.TypeProjectionModifierListContext context) {
    final List<KotlinParser.VarianceAnnotationContext> varianceAnnotationContexts =
        context.varianceAnnotation();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.VarianceAnnotationContext firstVarianceAnnotationContext =
        varianceAnnotationContexts.get(0);
    text.append(this.visit(firstVarianceAnnotationContext));
    if (varianceAnnotationContexts.size() > 1) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTypeProjectionModifierList -> varianceAnnotation > 1");
    }
    return text.toString();
  }

  @Override
  public String visitVarianceAnnotation(final KotlinParser.VarianceAnnotationContext context) {
    final TerminalNode inTerminal = context.IN();
    final TerminalNode outTerminal = context.OUT();
    final StringBuilder text = new StringBuilder();
    if (inTerminal != null) {
      text.append(this.visit(inTerminal));
    } else if (outTerminal != null) {
      text.append(this.visit(outTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitBlockLevelExpression(final KotlinParser.BlockLevelExpressionContext context) {
    final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    if (!annotationsContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBlockLevelExpression -> annotations");
    }
    if (expressionContext != null) {
      text.append(this.visit(expressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitExpression(final KotlinParser.ExpressionContext context) {
    final List<KotlinParser.DisjunctionContext> disjunctionContexts = context.disjunction();
    final List<KotlinParser.AssignmentOperatorContext> assignmentOperatorContexts =
        context.assignmentOperator();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.DisjunctionContext firstDisjunctionContext = disjunctionContexts.get(0);
    text.append(this.visit(firstDisjunctionContext));
    for (int index = 0; index < assignmentOperatorContexts.size(); index++) {
      final KotlinParser.AssignmentOperatorContext assignmentOperatorContext =
          assignmentOperatorContexts.get(index);
      final KotlinParser.DisjunctionContext disjunctionContext = disjunctionContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(assignmentOperatorContext))
          .append(' ')
          .append(this.visit(disjunctionContext));
    }
    return text.toString();
  }

  @Override
  public String visitAssignmentOperator(final KotlinParser.AssignmentOperatorContext context) {
    final TerminalNode assignmentTerminal = context.ASSIGNMENT();
    final TerminalNode addAssignmentTerminal = context.ADD_ASSIGNMENT();
    final TerminalNode subAssignmentTerminal = context.SUB_ASSIGNMENT();
    final TerminalNode multAssignmentTerminal = context.MULT_ASSIGNMENT();
    final TerminalNode divAssignmentTerminal = context.DIV_ASSIGNMENT();
    final TerminalNode modAssignmentTerminal = context.MOD_ASSIGNMENT();
    final StringBuilder text = new StringBuilder();
    if (assignmentTerminal != null) {
      text.append(this.visit(assignmentTerminal));
    } else if (addAssignmentTerminal != null) {
      text.append(this.visit(addAssignmentTerminal));
    } else if (subAssignmentTerminal != null) {
      text.append(this.visit(subAssignmentTerminal));
    } else if (multAssignmentTerminal != null) {
      text.append(this.visit(multAssignmentTerminal));
    } else if (divAssignmentTerminal != null) {
      text.append(this.visit(divAssignmentTerminal));
    } else if (modAssignmentTerminal != null) {
      text.append(this.visit(modAssignmentTerminal));
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
    for (int index = 0; index < disjTerminals.size(); index++) {
      final TerminalNode disjTerminal = disjTerminals.get(index);
      final KotlinParser.ConjunctionContext conjunctionContext = conjunctionContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(disjTerminal))
          .append(' ')
          .append(this.visit(conjunctionContext));
    }
    return text.toString();
  }

  @Override
  public String visitConjunction(final KotlinParser.ConjunctionContext context) {
    final List<KotlinParser.EqualityComparisonContext> equalityComparisonContexts =
        context.equalityComparison();
    final List<TerminalNode> conjTerminals = context.CONJ();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.EqualityComparisonContext firstEqualityComparisonContext =
        equalityComparisonContexts.get(0);
    text.append(this.visit(firstEqualityComparisonContext));
    for (int index = 0; index < conjTerminals.size(); index++) {
      final TerminalNode conjTerminal = conjTerminals.get(index);
      final KotlinParser.EqualityComparisonContext conjComparisonContext =
          equalityComparisonContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(conjTerminal))
          .append(' ')
          .append(this.visit(conjComparisonContext));
    }
    return text.toString();
  }

  @Override
  public String visitEqualityComparison(final KotlinParser.EqualityComparisonContext context) {
    final List<KotlinParser.ComparisonContext> comparisonContexts = context.comparison();
    final List<KotlinParser.EqualityOperationContext> equalityOperationContexts =
        context.equalityOperation();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.ComparisonContext firstComparisonContext = comparisonContexts.get(0);
    text.append(this.visit(firstComparisonContext));
    for (int index = 0; index < equalityOperationContexts.size(); index++) {
      final KotlinParser.EqualityOperationContext equalityOperationContext =
          equalityOperationContexts.get(index);
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
    final KotlinParser.ComparisonOperatorContext comparisonOperatorContext =
        context.comparisonOperator();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.NamedInfixContext firstNamedInfixContext = namedInfixContexts.get(0);
    text.append(this.visit(firstNamedInfixContext));
    if (comparisonOperatorContext != null) {
      text.append(' ').append(this.visit(comparisonOperatorContext));
      final KotlinParser.NamedInfixContext secondNamedInfixContext = namedInfixContexts.get(1);
      text.append(' ').append(this.visit(secondNamedInfixContext));
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
    final List<KotlinParser.ElvisExpressionContext> elvisExpressionContexts =
        context.elvisExpression();
    final List<KotlinParser.InOperatorContext> inoperatorContexts = context.inOperator();
    final KotlinParser.IsOperatorContext isOperatorContext = context.isOperator();
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.ElvisExpressionContext firstElvisExpressionContext =
        elvisExpressionContexts.get(0);
    text.append(this.visit(firstElvisExpressionContext));
    if (!inoperatorContexts.isEmpty()) {
      // (inOperator NL* elvisExpression)+
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNamedInfix -> inOperator");
    }
    if (isOperatorContext != null) {
      // isOperator NL* type
      text.append(' ')
          .append(this.visit(isOperatorContext))
          .append(' ')
          .append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitIsOperator(final KotlinParser.IsOperatorContext context) {
    final TerminalNode isTerminal = context.IS();
    final TerminalNode notIsTerminal = context.NOT_IS();
    final StringBuilder text = new StringBuilder();
    if (isTerminal != null) {
      text.append(this.visit(isTerminal));
    } else if (notIsTerminal != null) {
      // notIsTerminal may have whitespaces at the end.
      text.append(this.visit(notIsTerminal).trim());
    }
    return text.toString();
  }

  @Override
  public String visitElvisExpression(final KotlinParser.ElvisExpressionContext context) {
    final List<KotlinParser.InfixFunctionCallContext> infixFunctionCallContexts =
        context.infixFunctionCall();
    final List<TerminalNode> elvisTerminals = context.ELVIS();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.InfixFunctionCallContext firstInfixFunctionCallContext =
        infixFunctionCallContexts.get(0);
    text.append(this.visit(firstInfixFunctionCallContext));
    for (int index = 0; index < elvisTerminals.size(); index++) {
      final TerminalNode elvisTerminal = elvisTerminals.get(index);
      final KotlinParser.InfixFunctionCallContext infixFunctionCallContext =
          infixFunctionCallContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(elvisTerminal))
          .append(' ')
          .append(this.visit(infixFunctionCallContext));
    }
    return text.toString();
  }

  @Override
  public String visitInfixFunctionCall(final KotlinParser.InfixFunctionCallContext context) {
    final List<KotlinParser.RangeExpressionContext> rangeExpressionContexts =
        context.rangeExpression();
    final List<KotlinParser.SimpleIdentifierContext> simpleIdentifierContexts =
        context.simpleIdentifier();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.RangeExpressionContext firstRangeExpressionContext =
        rangeExpressionContexts.get(0);
    text.append(this.visit(firstRangeExpressionContext));
    for (int index = 0; index < simpleIdentifierContexts.size(); index++) {
      final KotlinParser.SimpleIdentifierContext simpleIdentifierContext =
          simpleIdentifierContexts.get(index);
      final KotlinParser.RangeExpressionContext rangeExpressionContext =
          rangeExpressionContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(simpleIdentifierContext))
          .append(' ')
          .append(this.visit(rangeExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitRangeExpression(final KotlinParser.RangeExpressionContext context) {
    final List<KotlinParser.AdditiveExpressionContext> additiveExpressionContexts =
        context.additiveExpression();
    final List<TerminalNode> rangeTerminals = context.RANGE();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.AdditiveExpressionContext firstAdditiveExpressionContext =
        additiveExpressionContexts.get(0);
    text.append(this.visit(firstAdditiveExpressionContext));
    for (int index = 0; index < rangeTerminals.size(); index++) {
      final TerminalNode rangeTerminal = rangeTerminals.get(index);
      final KotlinParser.AdditiveExpressionContext additiveExpressionContext =
          additiveExpressionContexts.get(index + 1);
      text.append(this.visit(rangeTerminal)).append(this.visit(additiveExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitAdditiveExpression(final KotlinParser.AdditiveExpressionContext context) {
    final List<KotlinParser.MultiplicativeExpressionContext> multiplicativeExpressionContexts =
        context.multiplicativeExpression();
    final List<KotlinParser.AdditiveOperatorContext> additiveOperatorContexts =
        context.additiveOperator();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.MultiplicativeExpressionContext firstMultiplicativeExpressionContext =
        multiplicativeExpressionContexts.get(0);
    text.append(this.visit(firstMultiplicativeExpressionContext));
    for (int index = 0; index < additiveOperatorContexts.size(); index++) {
      final KotlinParser.AdditiveOperatorContext additiveOperatorContext =
          additiveOperatorContexts.get(index);
      final KotlinParser.MultiplicativeExpressionContext multiplicativeExpressionContext =
          multiplicativeExpressionContexts.get(index + 1);
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
  public String visitMultiplicativeExpression(
      final KotlinParser.MultiplicativeExpressionContext context) {
    final List<KotlinParser.TypeRHSContext> typeRHSContexts = context.typeRHS();
    final List<KotlinParser.MultiplicativeOperationContext> multiplicativeOperationContexts =
        context.multiplicativeOperation();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.TypeRHSContext firstTypeRHSContext = typeRHSContexts.get(0);
    text.append(this.visit(firstTypeRHSContext));
    for (int index = 0; index < multiplicativeOperationContexts.size(); index++) {
      final KotlinParser.MultiplicativeOperationContext multiplicativeOperationContext =
          multiplicativeOperationContexts.get(index);
      final KotlinParser.TypeRHSContext typeRHSContext = typeRHSContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(multiplicativeOperationContext))
          .append(' ')
          .append(this.visit(typeRHSContext));
    }
    return text.toString();
  }

  @Override
  public String visitMultiplicativeOperation(
      final KotlinParser.MultiplicativeOperationContext context) {
    final TerminalNode multTerminal = context.MULT();
    final TerminalNode divTerminal = context.DIV();
    final TerminalNode modTerminal = context.MOD();
    final StringBuilder text = new StringBuilder();
    if (multTerminal != null) {
      text.append(this.visit(multTerminal));
    } else if (divTerminal != null) {
      text.append(this.visit(divTerminal));
    } else if (modTerminal != null) {
      text.append(this.visit(modTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitTypeRHS(final KotlinParser.TypeRHSContext context) {
    final List<KotlinParser.PrefixUnaryExpressionContext> prefixUnaryExpressionContexts =
        context.prefixUnaryExpression();
    final List<KotlinParser.TypeOperationContext> typeOperationContexts = context.typeOperation();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.PrefixUnaryExpressionContext firstPrefixUnaryExpressionContext =
        prefixUnaryExpressionContexts.get(0);
    text.append(this.visit(firstPrefixUnaryExpressionContext));
    for (int index = 0; index < typeOperationContexts.size(); index++) {
      final KotlinParser.TypeOperationContext typeOperationContext =
          typeOperationContexts.get(index);
      final KotlinParser.PrefixUnaryExpressionContext prefixUnaryExpressionContext =
          prefixUnaryExpressionContexts.get(index + 1);
      final int visitColonTypeOperationCountBefore =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.ColonTypeOperationContext.class.getSimpleName(), 0);
      final String typeOperationText = this.visit(typeOperationContext);
      final int visitColonTypeOperationCountAfter =
          this.ruleVisitCounts.getOrDefault(
              KotlinParser.ColonTypeOperationContext.class.getSimpleName(), 0);
      if (visitColonTypeOperationCountBefore == visitColonTypeOperationCountAfter) {
        text.append(' ');
      }
      text.append(typeOperationText).append(' ').append(this.visit(prefixUnaryExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeOperation(final KotlinParser.TypeOperationContext context) {
    final TerminalNode asTerminal = context.AS();
    final TerminalNode asSafeTerminal = context.AS_SAFE();
    final KotlinParser.ColonTypeOperationContext colonTypeOperationContext =
        context.colonTypeOperation();
    final StringBuilder text = new StringBuilder();
    if (asTerminal != null) {
      text.append(this.visit(asTerminal));
    } else if (asSafeTerminal != null) {
      text.append(this.visit(asSafeTerminal));
    } else if (colonTypeOperationContext != null) {
      text.append(this.visit(colonTypeOperationContext));
    }
    return text.toString();
  }

  @Override
  public String visitColonTypeOperation(final KotlinParser.ColonTypeOperationContext context) {
    final TerminalNode colonTerminal = context.COLON();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(colonTerminal));
    return text.toString();
  }

  @Override
  public String visitPrefixUnaryExpression(
      final KotlinParser.PrefixUnaryExpressionContext context) {
    final List<KotlinParser.PrefixUnaryOperationContext> prefixUnaryOperationContexts =
        context.prefixUnaryOperation();
    final KotlinParser.PostfixUnaryExpressionContext postfixUnaryExpressionContext =
        context.postfixUnaryExpression();
    final StringBuilder text = new StringBuilder();
    if (!prefixUnaryOperationContexts.isEmpty()) {
      final KotlinParser.PrefixUnaryOperationContext firstPrefixUnaryOperationContext =
          prefixUnaryOperationContexts.get(0);
      text.append(this.visit(firstPrefixUnaryOperationContext));
      if (prefixUnaryOperationContexts.size() > 1) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitPrefixUnaryExpression prefixUnaryOperation{2,}");
      }
    }
    text.append(this.visit(postfixUnaryExpressionContext));
    return text.toString();
  }

  @Override
  public String visitPrefixUnaryOperation(final KotlinParser.PrefixUnaryOperationContext context) {
    final TerminalNode incrTerminal = context.INCR();
    final TerminalNode decrTerminal = context.DECR();
    final TerminalNode addTerminal = context.ADD();
    final TerminalNode subTerminal = context.SUB();
    final TerminalNode exclTerminal = context.EXCL();
    final KotlinParser.AnnotationsContext annotationsContext = context.annotations();
    final KotlinParser.LabelDefinitionContext labelDefinitionContext = context.labelDefinition();
    final StringBuilder text = new StringBuilder();
    if (incrTerminal != null) {
      text.append(this.visit(incrTerminal));
    } else if (decrTerminal != null) {
      text.append(this.visit(decrTerminal));
    } else if (addTerminal != null) {
      text.append(this.visit(addTerminal));
    } else if (subTerminal != null) {
      text.append(this.visit(subTerminal));
    } else if (exclTerminal != null) {
      text.append(this.visit(exclTerminal));
    } else if (annotationsContext != null) {
      text.append(this.visit(annotationsContext));
    } else if (labelDefinitionContext != null) {
      text.append(this.visit(labelDefinitionContext));
    }
    return text.toString();
  }

  @Override
  public String visitLabelDefinition(final KotlinParser.LabelDefinitionContext context) {
    final TerminalNode labelDefinitionTerminal = context.LabelDefinition();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(labelDefinitionTerminal));
    return text.toString();
  }

  @Override
  public String visitPostfixUnaryExpression(
      final KotlinParser.PostfixUnaryExpressionContext context) {
    final KotlinParser.AtomicExpressionContext atomicExpressionContext = context.atomicExpression();
    final KotlinParser.CallableReferenceContext callableReferenceContext =
        context.callableReference();
    final List<KotlinParser.PostfixUnaryOperationContext> postfixUnaryOperationContexts =
        context.postfixUnaryOperation();
    final StringBuilder text = new StringBuilder();
    if (atomicExpressionContext != null) {
      text.append(this.visit(atomicExpressionContext));
    } else if (callableReferenceContext != null) {
      text.append(this.visit(callableReferenceContext));
    }
    for (final KotlinParser.PostfixUnaryOperationContext postfixUnaryOperationContext :
        postfixUnaryOperationContexts) {
      text.append(this.visit(postfixUnaryOperationContext));
    }
    return text.toString();
  }

  @Override
  public String visitCallableReference(final KotlinParser.CallableReferenceContext context) {
    final KotlinParser.UserTypeContext userTypeContext = context.userType();
    final List<TerminalNode> questTerminals = context.QUEST();
    final TerminalNode coloncolonTerminal = context.COLONCOLON();
    final TerminalNode qColoncolonTerminal = context.Q_COLONCOLON();
    final KotlinParser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode classTerminal = context.CLASS();
    final TerminalNode thisTerminal = context.THIS();
    final StringBuilder text = new StringBuilder();
    if (thisTerminal == null) {
      // (userType (QUEST NL*)*)? NL* (COLONCOLON | Q_COLONCOLON) NL* (identifier | CLASS)
      if (userTypeContext != null) {
        text.append(this.visit(userTypeContext));
        if (!questTerminals.isEmpty()) {
          throw new UnsupportedOperationException(
              "The following parsing path is not supported yet: visitCallableReference -> quest");
        }
      }
      if (coloncolonTerminal != null) {
        text.append(this.visit(coloncolonTerminal));
      } else if (qColoncolonTerminal != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitCallableReference -> qColoncolon");
      }
      if (identifierContext != null) {
        text.append(this.visit(identifierContext));
      } else if (classTerminal != null) {
        text.append(this.visit(classTerminal));
      }
    } else {
      // THIS NL* COLONCOLON NL* CLASS
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCallableReference -> this");
    }
    return text.toString();
  }

  @SuppressWarnings("PMD.ConfusingTernary")
  @Override
  public String visitPostfixUnaryOperation(
      final KotlinParser.PostfixUnaryOperationContext context) {
    final TerminalNode incrTerminal = context.INCR();
    final TerminalNode decrTerminal = context.DECR();
    final List<TerminalNode> exclTerminals = context.EXCL();
    final KotlinParser.CallSuffixContext callSuffixContext = context.callSuffix();
    final KotlinParser.ArrayAccessContext arrayAccessContext = context.arrayAccess();
    final KotlinParser.MemberAccessOperatorContext memberAccessOperatorContext =
        context.memberAccessOperator();
    final KotlinParser.PostfixUnaryExpressionContext postfixUnaryExpressionContext =
        context.postfixUnaryExpression();
    final StringBuilder text = new StringBuilder();
    if (incrTerminal != null) {
      text.append(this.visit(incrTerminal));
    } else if (decrTerminal != null) {
      text.append(this.visit(decrTerminal));
    } else if (!exclTerminals.isEmpty()) {
      for (final TerminalNode exclTerminal : exclTerminals) {
        text.append(this.visit(exclTerminal));
      }
    } else if (callSuffixContext != null) {
      text.append(this.visit(callSuffixContext));
    } else if (arrayAccessContext != null) {
      text.append(this.visit(arrayAccessContext));
    } else if (memberAccessOperatorContext != null) {
      boolean indentedByMethodChain = false;
      if (this.currentMethodCallCount == 1) {
        this.currentIndentLevel++;
        indentedByMethodChain = true;
        this.appendNewLinesAndIndent(text, 1);
      } else if (this.currentMethodCallCount > 1) {
        this.appendNewLinesAndIndent(text, 1);
      }
      this.memberAccessing = true;
      text.append(this.visit(memberAccessOperatorContext))
          .append(this.visit(postfixUnaryExpressionContext));
      this.memberAccessing = false;
      if (indentedByMethodChain) {
        this.currentIndentLevel--;
      }
    }
    return text.toString();
  }

  @Override
  public String visitArrayAccess(final KotlinParser.ArrayAccessContext context) {
    final TerminalNode lsquareTerminal = context.LSQUARE();
    final List<KotlinParser.ExpressionContext> expressionContexts = context.expression();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rsqaureTerminal = context.RSQUARE();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lsquareTerminal));
    if (!expressionContexts.isEmpty()) {
      final KotlinParser.ExpressionContext firstExpressionContext = expressionContexts.get(0);
      text.append(this.visit(firstExpressionContext));
      for (int index = 0; index < commaTerminals.size(); index++) {
        final TerminalNode commaTerminal = commaTerminals.get(index);
        final KotlinParser.ExpressionContext expressionContext = expressionContexts.get(index + 1);
        text.append(this.visit(commaTerminal)).append(' ').append(this.visit(expressionContext));
      }
    }
    text.append(this.visit(rsqaureTerminal));
    return text.toString();
  }

  @Override
  public String visitMemberAccessOperator(final KotlinParser.MemberAccessOperatorContext context) {
    final TerminalNode dotTerminal = context.DOT();
    final TerminalNode questTerminal = context.QUEST();
    final StringBuilder text = new StringBuilder();
    if (questTerminal == null) {
      // DOT
      text.append(this.visit(dotTerminal));
    } else {
      // QUEST DOT
      text.append(this.visit(questTerminal)).append(this.visit(dotTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitCallSuffix(final KotlinParser.CallSuffixContext context) {
    final KotlinParser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final KotlinParser.ValueArgumentsContext valueArgumentsContext = context.valueArguments();
    final List<KotlinParser.AnnotatedLambdaContext> annotatedLambdaContexts =
        context.annotatedLambda();
    final StringBuilder text = new StringBuilder();
    if (this.memberAccessing) {
      this.currentMethodCallCount++;
    }
    if (typeArgumentsContext != null) {
      // typeArguments valueArguments? annotatedLambda*
      text.append(this.visit(typeArgumentsContext));
      if (valueArgumentsContext != null) {
        text.append(this.visit(valueArgumentsContext));
      }
      if (!annotatedLambdaContexts.isEmpty()) {
        if (annotatedLambdaContexts.size() == 1) {
          final KotlinParser.AnnotatedLambdaContext annotatedLambdaContext =
              annotatedLambdaContexts.get(0);
          text.append(' ').append(this.visit(annotatedLambdaContext));
        } else {
          throw new UnsupportedOperationException(
              "The following parsing path is not supported yet: visitCallSuffix -> annotatedLambda > 1");
        }
      }
    } else if (valueArgumentsContext != null) {
      // valueArguments annotatedLambda*
      text.append(this.visit(valueArgumentsContext));
      if (annotatedLambdaContexts.size() == 1) {
        final KotlinParser.AnnotatedLambdaContext annotatedLambdaContext =
            annotatedLambdaContexts.get(0);
        text.append(' ').append(this.visit(annotatedLambdaContext));
      } else if (annotatedLambdaContexts.size() > 1) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitCallSuffix -> valueArguments annotatedLambda+");
      }
    } else if (!annotatedLambdaContexts.isEmpty()) {
      // annotatedLambda+
      if (annotatedLambdaContexts.size() == 1) {
        final KotlinParser.AnnotatedLambdaContext annotatedLambdaContext =
            annotatedLambdaContexts.get(0);
        text.append(' ').append(this.visit(annotatedLambdaContext));
      } else {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitCallSuffix -> annotatedLambda+");
      }
    }
    return text.toString();
  }

  @Override
  public String visitAnnotatedLambda(final KotlinParser.AnnotatedLambdaContext context) {
    final List<KotlinParser.UnescapedAnnotationContext> unescapedAnnotationContexts =
        context.unescapedAnnotation();
    final TerminalNode labelDefinitionTerminal = context.LabelDefinition();
    final KotlinParser.FunctionLiteralContext functionLiteralContext = context.functionLiteral();
    final StringBuilder text = new StringBuilder();
    for (final KotlinParser.UnescapedAnnotationContext unescapedAnnotationContext :
        unescapedAnnotationContexts) {
      text.append(this.visit(unescapedAnnotationContext)).append(' ');
    }
    if (labelDefinitionTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAnnotatedLambda -> labelDefinition");
    }
    text.append(this.visit(functionLiteralContext));
    return text.toString();
  }

  @Override
  public String visitFunctionLiteral(final KotlinParser.FunctionLiteralContext context) {
    final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
    final TerminalNode lcurlTerminal = context.LCURL();
    final KotlinParser.StatementsContext statementsContext = context.statements();
    final TerminalNode rcurlTerminal = context.RCURL();
    final KotlinParser.LambdaParametersContext lambdaParametersContext = context.lambdaParameters();
    final TerminalNode arrowTerminal = context.ARROW();
    final StringBuilder text = new StringBuilder();
    if (!annotationsContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionLiteral -> annotations");
    }
    if (lambdaParametersContext == null) {
      // LCURL NL* statements NL* RCURL
      text.append(this.visit(lcurlTerminal));
      if (!statementsContext.getText().isEmpty()) {
        this.currentIndentLevel++;
        final int visitDeclarationCountBefore =
            this.ruleVisitCounts.getOrDefault(
                KotlinParser.DeclarationContext.class.getSimpleName(), 0);
        final String statementsText = this.visit(statementsContext);
        final int visitDeclarationCountAfter =
            this.ruleVisitCounts.getOrDefault(
                KotlinParser.DeclarationContext.class.getSimpleName(), 0);
        final int newLines;
        if (visitDeclarationCountBefore == visitDeclarationCountAfter) {
          newLines = 1;
        } else {
          newLines = 2;
        }
        this.appendNewLinesAndIndent(text, newLines);
        text.append(statementsText);
        this.currentIndentLevel--;
        this.appendNewLinesAndIndent(text, newLines);
      }
      text.append(this.visit(rcurlTerminal));
    } else {
      // LCURL NL* lambdaParameters NL* ARROW NL* statements NL* RCURL
      text.append(this.visit(lcurlTerminal))
          .append(' ')
          .append(this.visit(lambdaParametersContext))
          .append(' ')
          .append(this.visit(arrowTerminal));
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(statementsContext));
      this.currentIndentLevel--;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(rcurlTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitLambdaParameters(final KotlinParser.LambdaParametersContext context) {
    final List<KotlinParser.LambdaParameterContext> lambdaParameterContexts =
        context.lambdaParameter();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final StringBuilder text = new StringBuilder();
    if (!lambdaParameterContexts.isEmpty()) {
      final KotlinParser.LambdaParameterContext firstLambdaParameterContext =
          lambdaParameterContexts.get(0);
      text.append(this.visit(firstLambdaParameterContext));
      for (int index = 0; index < commaTerminals.size(); index++) {
        final TerminalNode commaTerminal = commaTerminals.get(index);
        final KotlinParser.LambdaParameterContext lambdaParameterContext =
            lambdaParameterContexts.get(index + 1);
        text.append(this.visit(commaTerminal))
            .append(' ')
            .append(this.visit(lambdaParameterContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitLambdaParameter(final KotlinParser.LambdaParameterContext context) {
    final KotlinParser.VariableDeclarationContext variableDeclarationContext =
        context.variableDeclaration();
    final KotlinParser.MultiVariableDeclarationContext multiVariableDeclarationContext =
        context.multiVariableDeclaration();
    final TerminalNode colonTerminal = context.COLON();
    // todo: use `typeContext` with tests.
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (variableDeclarationContext != null) {
      text.append(this.visit(variableDeclarationContext));
    } else if (multiVariableDeclarationContext != null) {
      text.append(this.visit(multiVariableDeclarationContext));
      if (colonTerminal != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitLambdaParameter -> colon");
      }
    }
    return text.toString();
  }

  @Override
  public String visitValueArguments(final KotlinParser.ValueArgumentsContext context) {
    final List<TerminalNode> commaTerminals = context.COMMA();
    final StringBuilder text = new StringBuilder();
    if (commaTerminals.size() > 2) {
      text.append(this.visitValueArgumentsWithIndentation(context));
      return text.toString();
    }
    final Map<String, Integer> ruleVisitCountsCopy = new HashMap<>(this.ruleVisitCounts);
    final int currentMethodCallCountCopy = this.currentMethodCallCount;
    final int currentIndentLevelCopy = this.currentIndentLevel;
    final int visitValueArgumentsCountBefore =
        this.ruleVisitCounts.getOrDefault(
            KotlinParser.ValueArgumentsContext.class.getSimpleName(), 0);
    final int visitNamedParamCountBefore =
        this.ruleVisitCounts.getOrDefault(KotlinParser.NamedParamContext.class.getSimpleName(), 0);
    final String withoutIndentation = this.visitValueArgumentsWithoutIndentation(context);
    final int visitValueArgumentsCountAfter =
        this.ruleVisitCounts.getOrDefault(
            KotlinParser.ValueArgumentsContext.class.getSimpleName(), 0);
    final int visitNamedParamCountAfter =
        this.ruleVisitCounts.getOrDefault(KotlinParser.NamedParamContext.class.getSimpleName(), 0);
    final boolean nestedArgs = visitValueArgumentsCountBefore < visitValueArgumentsCountAfter;
    final boolean namedParams = visitNamedParamCountBefore < visitNamedParamCountAfter;
    if (nestedArgs || namedParams) {
      this.ruleVisitCounts = ruleVisitCountsCopy;
      this.currentMethodCallCount = currentMethodCallCountCopy;
      this.currentIndentLevel = currentIndentLevelCopy;
      text.append(this.visitValueArgumentsWithIndentation(context));
    } else {
      text.append(withoutIndentation);
    }
    return text.toString();
  }

  /**
   * It's for {@link KotlinVisitor#visitValueArguments(KotlinParser.ValueArgumentsContext)}. There
   * is a case where parameters are nested like this:
   * `RussianDoll("Rin",RussianDoll("Revomin",RussianDoll("Ian")))`. In such as a case, we want to
   * indent them.
   *
   * @param context As is.
   * @return Formatted text with the assumption that the parameters are nested.
   */
  private String visitValueArgumentsWithIndentation(
      final KotlinParser.ValueArgumentsContext context) {
    final TerminalNode lparenTerminal = context.LPAREN();
    final List<KotlinParser.ValueArgumentContext> valueArgumentContexts = context.valueArgument();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lparenTerminal));
    if (!valueArgumentContexts.isEmpty()) {
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 1);
      final KotlinParser.ValueArgumentContext firstValueArgumentContext =
          valueArgumentContexts.get(0);
      text.append(this.visit(firstValueArgumentContext));
      for (int index = 1; index < valueArgumentContexts.size(); index++) {
        // (COMMA valueArgument)*
        final TerminalNode commaTerminal = commaTerminals.get(index - 1);
        final KotlinParser.ValueArgumentContext valueArgumentContext =
            valueArgumentContexts.get(index);
        text.append(this.visit(commaTerminal));
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(valueArgumentContext));
      }
    }
    // (NL* COMMA)?
    if (!valueArgumentContexts.isEmpty() && valueArgumentContexts.size() == commaTerminals.size()) {
      final TerminalNode commaTerminal = commaTerminals.get(commaTerminals.size() - 1);
      text.append(this.visit(commaTerminal));
    }
    if (!valueArgumentContexts.isEmpty()) {
      this.currentIndentLevel--;
      this.appendNewLinesAndIndent(text, 1);
    }
    text.append(this.visit(rparenTerminal));
    return text.toString();
  }

  /**
   * Similar to {@link
   * KotlinVisitor#visitValueArgumentsWithIndentation(KotlinParser.ValueArgumentsContext)}. The only
   * difference is that we assume the parameters are NOT nested. In such a case, we don't want to
   * indent them.
   *
   * @param context As is.
   * @return Formatted text with the assumption that the parameters are NOT nested.
   */
  private String visitValueArgumentsWithoutIndentation(
      final KotlinParser.ValueArgumentsContext context) {
    final TerminalNode lparenTerminal = context.LPAREN();
    final List<KotlinParser.ValueArgumentContext> valueArgumentContexts = context.valueArgument();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lparenTerminal));
    if (!valueArgumentContexts.isEmpty()) {
      final KotlinParser.ValueArgumentContext firstValueArgumentContext =
          valueArgumentContexts.get(0);
      text.append(this.visit(firstValueArgumentContext));
      for (int index = 1; index < valueArgumentContexts.size(); index++) {
        // (COMMA valueArgument)*
        final TerminalNode commaTerminal = commaTerminals.get(index - 1);
        final KotlinParser.ValueArgumentContext valueArgumentContext =
            valueArgumentContexts.get(index);
        text.append(this.visit(commaTerminal)).append(' ').append(this.visit(valueArgumentContext));
      }
    }
    // (NL* COMMA)?
    if (!valueArgumentContexts.isEmpty() && valueArgumentContexts.size() == commaTerminals.size()) {
      final TerminalNode commaTerminal = commaTerminals.get(commaTerminals.size() - 1);
      text.append(this.visit(commaTerminal));
    }
    text.append(this.visit(rparenTerminal));
    return text.toString();
  }

  @Override
  public String visitValueArgument(final KotlinParser.ValueArgumentContext context) {
    final KotlinParser.NamedParamContext namedParamContext = context.namedParam();
    final TerminalNode multTerminal = context.MULT();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    if (namedParamContext != null) {
      text.append(this.visit(namedParamContext));
    }
    if (multTerminal != null) {
      text.append(this.visit(multTerminal));
    }
    text.append(this.visit(expressionContext));
    return text.toString();
  }

  @Override
  public String visitNamedParam(final KotlinParser.NamedParamContext context) {
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final TerminalNode assignmentTerminal = context.ASSIGNMENT();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(simpleIdentifierContext))
        .append(' ')
        .append(this.visit(assignmentTerminal))
        .append(' ');
    return text.toString();
  }

  @Override
  public String visitAtomicExpression(final KotlinParser.AtomicExpressionContext context) {
    final KotlinParser.ParenthesizedExpressionContext parenthesizedExpressionContext =
        context.parenthesizedExpression();
    final KotlinParser.LiteralConstantContext literalConstantContext = context.literalConstant();
    final KotlinParser.FunctionLiteralContext functionLiteralContext = context.functionLiteral();
    final KotlinParser.ThisExpressionContext thisExpressionContext = context.thisExpression();
    final KotlinParser.SuperExpressionContext superExpressionContext = context.superExpression();
    final KotlinParser.ConditionalExpressionContext conditionalExpressionContext =
        context.conditionalExpression();
    final KotlinParser.TryExpressionContext tryExpressionContext = context.tryExpression();
    final KotlinParser.ObjectLiteralContext objectLiteralContext = context.objectLiteral();
    final KotlinParser.JumpExpressionContext jumpExpressionContext = context.jumpExpression();
    final KotlinParser.LoopExpressionContext loopExpressionContext = context.loopExpression();
    final KotlinParser.CollectionLiteralContext collectionLiteralContext =
        context.collectionLiteral();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final TerminalNode valTerminal = context.VAL();
    final KotlinParser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (parenthesizedExpressionContext != null) {
      text.append(this.visit(parenthesizedExpressionContext));
    } else if (literalConstantContext != null) {
      text.append(this.visit(literalConstantContext));
    } else if (functionLiteralContext != null) {
      text.append(this.visit(functionLiteralContext));
    } else if (thisExpressionContext != null) {
      text.append(this.visit(thisExpressionContext));
    } else if (superExpressionContext != null) {
      text.append(this.visit(superExpressionContext));
    } else if (conditionalExpressionContext != null) {
      text.append(this.visit(conditionalExpressionContext));
    } else if (tryExpressionContext != null) {
      text.append(this.visit(tryExpressionContext));
    } else if (objectLiteralContext != null) {
      text.append(this.visit(objectLiteralContext));
    } else if (jumpExpressionContext != null) {
      text.append(this.visit(jumpExpressionContext));
    } else if (loopExpressionContext != null) {
      text.append(this.visit(loopExpressionContext));
    } else if (collectionLiteralContext != null) {
      text.append(this.visit(collectionLiteralContext));
    } else if (simpleIdentifierContext != null) {
      text.append(this.visit(simpleIdentifierContext));
    } else if (valTerminal != null) {
      text.append(this.visit(valTerminal)).append(' ').append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitCollectionLiteral(final KotlinParser.CollectionLiteralContext context) {
    final TerminalNode lsqaureTerminal = context.LSQUARE();
    final List<KotlinParser.ExpressionContext> expressionContexts = context.expression();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rsqaureTerminal = context.RSQUARE();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lsqaureTerminal));
    if (!expressionContexts.isEmpty()) {
      final KotlinParser.ExpressionContext firstExpressionContext = expressionContexts.get(0);
      text.append(this.visit(firstExpressionContext));
    }
    for (int index = 0; index < commaTerminals.size(); index++) {
      final TerminalNode commaTerminal = commaTerminals.get(index);
      final KotlinParser.ExpressionContext expressionContext = expressionContexts.get(index + 1);
      text.append(this.visit(commaTerminal)).append(' ').append(this.visit(expressionContext));
    }
    text.append(this.visit(rsqaureTerminal));
    return text.toString();
  }

  @Override
  public String visitParenthesizedExpression(
      final KotlinParser.ParenthesizedExpressionContext context) {
    final TerminalNode lparenTerminal = context.LPAREN();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lparenTerminal))
        .append(this.visit(expressionContext))
        .append(this.visit(rparenTerminal));
    return text.toString();
  }

  @Override
  public String visitSuperExpression(final KotlinParser.SuperExpressionContext context) {
    final TerminalNode superTerminal = context.SUPER();
    final TerminalNode langleTerminal = context.LANGLE();
    // todo: use `typeContext` and `rangleTerminal` with tests.
    final KotlinParser.TypeContext typeContext = context.type();
    final TerminalNode rangleTerminal = context.RANGLE();
    final TerminalNode labelReferenceTerminal = context.LabelReference();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(superTerminal));
    if (langleTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSuperExpression -> langle");
    }
    if (labelReferenceTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSuperExpression -> labelReference");
    }
    return text.toString();
  }

  @Override
  public String visitObjectLiteral(final KotlinParser.ObjectLiteralContext context) {
    final TerminalNode objectTerminal = context.OBJECT();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.DelegationSpecifiersContext delegationSpecifiersContext =
        context.delegationSpecifiers();
    final KotlinParser.ClassBodyContext classBodyContext = context.classBody();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(objectTerminal));
    if (colonTerminal != null) {
      text.append(' ')
          .append(this.visit(colonTerminal))
          .append(' ')
          .append(this.visit(delegationSpecifiersContext));
    }
    if (classBodyContext != null) {
      text.append(' ').append(this.visit(classBodyContext));
    }
    return text.toString();
  }

  @Override
  public String visitTryExpression(final KotlinParser.TryExpressionContext context) {
    final TerminalNode tryTerminal = context.TRY();
    final KotlinParser.BlockContext blockContext = context.block();
    final List<KotlinParser.CatchBlockContext> catchBlockContexts = context.catchBlock();
    final KotlinParser.FinallyBlockContext finallyBlockContext = context.finallyBlock();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(tryTerminal)).append(' ').append(this.visit(blockContext));
    for (final KotlinParser.CatchBlockContext catchBlockContext : catchBlockContexts) {
      text.append(' ').append(this.visit(catchBlockContext));
    }
    if (finallyBlockContext != null) {
      text.append(' ').append(this.visit(finallyBlockContext));
    }
    return text.toString();
  }

  @Override
  public String visitFinallyBlock(final KotlinParser.FinallyBlockContext context) {
    final TerminalNode finallyTerminal = context.FINALLY();
    final KotlinParser.BlockContext blockContext = context.block();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(finallyTerminal)).append(' ').append(this.visit(blockContext));
    return text.toString();
  }

  @Override
  public String visitCatchBlock(final KotlinParser.CatchBlockContext context) {
    final TerminalNode catchTerminal = context.CATCH();
    final TerminalNode lparenTerminal = context.LPAREN();
    final List<KotlinParser.AnnotationsContext> annotationsContexts = context.annotations();
    final KotlinParser.SimpleIdentifierContext simpleIdentifierContext = context.simpleIdentifier();
    final TerminalNode colonTerminal = context.COLON();
    final KotlinParser.UserTypeContext userTypeContext = context.userType();
    final TerminalNode rparenTerminal = context.RPAREN();
    final KotlinParser.BlockContext blockContext = context.block();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(catchTerminal)).append(' ').append(this.visit(lparenTerminal));
    if (!annotationsContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCatchBlock -> annotations");
    }
    text.append(this.visit(simpleIdentifierContext))
        .append(this.visit(colonTerminal))
        .append(' ')
        .append(this.visit(userTypeContext))
        .append(this.visit(rparenTerminal))
        .append(' ')
        .append(this.visit(blockContext));
    return text.toString();
  }

  @Override
  public String visitThisExpression(final KotlinParser.ThisExpressionContext context) {
    final TerminalNode thisTerminal = context.THIS();
    final TerminalNode labelReferenceTerminal = context.LabelReference();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(thisTerminal));
    if (labelReferenceTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitThisExpression -> labelReference");
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
      text.append(this.visit(throwTerminal)).append(' ').append(this.visit(expressionContext));
    } else if (returnTerminal != null) {
      // RETURN expression?
      text.append(this.visit(returnTerminal));
      if (expressionContext != null) {
        text.append(' ').append(this.visit(expressionContext));
      }
    } else if (returnAtTerminal != null) {
      // RETURN_AT expression?
      text.append(this.visit(returnAtTerminal));
      if (expressionContext != null) {
        text.append(' ').append(this.visit(expressionContext));
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
    final KotlinParser.DoWhileExpressionContext doWhileExpressionContext =
        context.doWhileExpression();
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
    final KotlinParser.ControlStructureBodyContext controlStructureBodyContext =
        context.controlStructureBody();
    final TerminalNode whileTerminal = context.WHILE();
    final TerminalNode lparenTerminal = context.LPAREN();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(doTerminal)).append(' ');
    if (controlStructureBodyContext != null) {
      text.append(this.visit(controlStructureBodyContext)).append(' ');
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
    final KotlinParser.ControlStructureBodyContext controlStructureBodyContext =
        context.controlStructureBody();
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
    final KotlinParser.VariableDeclarationContext variableDeclarationContext =
        context.variableDeclaration();
    final KotlinParser.MultiVariableDeclarationContext multiVariableDeclarationContext =
        context.multiVariableDeclaration();
    final TerminalNode inTerminal = context.IN();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final TerminalNode rparenTerminal = context.RPAREN();
    final KotlinParser.ControlStructureBodyContext controlStructureBodyContext =
        context.controlStructureBody();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(forTerminal)).append(' ').append(this.visit(lparenTerminal));
    if (!annotationsContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitForExpression -> annotations");
    }
    if (variableDeclarationContext != null) {
      text.append(this.visit(variableDeclarationContext));
    } else if (multiVariableDeclarationContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitForExpression -> multiVariableDeclaration");
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
  public String visitConditionalExpression(
      final KotlinParser.ConditionalExpressionContext context) {
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
    final KotlinParser.ControlStructureBodyContext controlStructureBodyContext =
        context.controlStructureBody();
    final TerminalNode elseTerminal = context.ELSE();
    final StringBuilder text = new StringBuilder();
    if (elseTerminal == null) {
      // whenCondition (NL* COMMA NL* whenCondition)* NL* ARROW NL* controlStructureBody semi?
      final KotlinParser.WhenConditionContext firstWhenConditionContext =
          whenConditionContexts.get(0);
      text.append(this.visit(firstWhenConditionContext));
      for (int index = 0; index < commaTerminals.size(); index++) {
        final TerminalNode commaTerminal = commaTerminals.get(index);
        final KotlinParser.WhenConditionContext whenConditionContext =
            whenConditionContexts.get(index + 1);
        text.append(this.visit(commaTerminal)).append(' ').append(this.visit(whenConditionContext));
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
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitWhenCondition -> rangeTest");
    } else if (typeTestContext != null) {
      text.append(this.visit(typeTestContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeTest(final KotlinParser.TypeTestContext context) {
    final KotlinParser.IsOperatorContext isOperatorContext = context.isOperator();
    final KotlinParser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (isOperatorContext != null) {
      text.append(this.visit(isOperatorContext)).append(' ').append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitIfExpression(final KotlinParser.IfExpressionContext context) {
    final TerminalNode ifTerminal = context.IF();
    final TerminalNode lparenTerminal = context.LPAREN();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final TerminalNode rparenTerminal = context.RPAREN();
    final KotlinParser.FirstControlStructureBodyOfIfExpressionContext
        firstControlStructureBodyOfIfExpressionContext =
            context.firstControlStructureBodyOfIfExpression();
    final TerminalNode semicolonTerminal = context.SEMICOLON();
    final TerminalNode elseTerminal = context.ELSE();
    final KotlinParser.ControlStructureBodyContext controlStructureBodyContext =
        context.controlStructureBody();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(ifTerminal))
        .append(' ')
        .append(this.visit(lparenTerminal))
        .append(this.visit(expressionContext))
        .append(this.visit(rparenTerminal));
    if (firstControlStructureBodyOfIfExpressionContext != null) {
      text.append(' ').append(this.visit(firstControlStructureBodyOfIfExpressionContext));
    }
    if (semicolonTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitIfExpression -> semicolon");
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
  public String visitFirstControlStructureBodyOfIfExpression(
      final KotlinParser.FirstControlStructureBodyOfIfExpressionContext context) {
    final KotlinParser.ControlStructureBodyContext controlStructureBodyContext =
        context.controlStructureBody();
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
    final KotlinParser.LineStringLiteralContext lineStringLiteralContext =
        context.lineStringLiteral();
    final KotlinParser.MultiLineStringLiteralContext multiLineStringLiteralContext =
        context.multiLineStringLiteral();
    final StringBuilder text = new StringBuilder();
    if (lineStringLiteralContext != null) {
      text.append(this.visit(lineStringLiteralContext));
    } else if (multiLineStringLiteralContext != null) {
      text.append(this.visit(multiLineStringLiteralContext));
    }
    return text.toString();
  }

  @Override
  public String visitMultiLineStringLiteral(
      final KotlinParser.MultiLineStringLiteralContext context) {
    final TerminalNode tripleQuoteOpenTerminal = context.TRIPLE_QUOTE_OPEN();
    final List<KotlinParser.MultiLineStringLiteralPartContext> multiLineStringLiteralPartContexts =
        context.multiLineStringLiteralPart();
    final TerminalNode tripleQuoteCloseTerminal = context.TRIPLE_QUOTE_CLOSE();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(tripleQuoteOpenTerminal));
    for (final KotlinParser.MultiLineStringLiteralPartContext multiLineStringLiteralPartContext :
        multiLineStringLiteralPartContexts) {
      text.append(this.visit(multiLineStringLiteralPartContext));
    }
    text.append(this.visit(tripleQuoteCloseTerminal));
    return text.toString();
  }

  @Override
  public String visitMultiLineStringLiteralPart(
      final KotlinParser.MultiLineStringLiteralPartContext context) {
    final KotlinParser.MultiLineStringContentContext multiLineStringContentContext =
        context.multiLineStringContent();
    final KotlinParser.MultiLineStringExpressionContext multiLineStringExpressionContext =
        context.multiLineStringExpression();
    final KotlinParser.LineStringLiteralContext lineStringLiteralContext =
        context.lineStringLiteral();
    final TerminalNode multiLineStringQuote = context.MultiLineStringQuote();
    final StringBuilder text = new StringBuilder();
    if (multiLineStringContentContext != null) {
      text.append(this.visit(multiLineStringContentContext));
    } else if (multiLineStringExpressionContext != null) {
      text.append(this.visit(multiLineStringExpressionContext));
    } else if (lineStringLiteralContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitMultiLineStringLiteralPart -> lineStringLiteral");
    } else if (multiLineStringQuote != null) {
      text.append(this.visit(multiLineStringQuote));
    }
    return text.toString();
  }

  @Override
  public String visitMultiLineStringExpression(
      final KotlinParser.MultiLineStringExpressionContext context) {
    final TerminalNode multiLineStrExprStartTerminal = context.MultiLineStrExprStart();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final TerminalNode rcurlTerminal = context.RCURL();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(multiLineStrExprStartTerminal))
        .append(this.visit(expressionContext))
        .append(this.visit(rcurlTerminal));
    return text.toString();
  }

  @Override
  public String visitMultiLineStringContent(
      final KotlinParser.MultiLineStringContentContext context) {
    final TerminalNode multiLineStrTextTerminal = context.MultiLineStrText();
    final TerminalNode multiLineStrEscapedCharTerminal = context.MultiLineStrEscapedChar();
    final TerminalNode multiLineStrRefTerminal = context.MultiLineStrRef();
    final StringBuilder text = new StringBuilder();
    if (multiLineStrTextTerminal != null) {
      text.append(this.visit(multiLineStrTextTerminal));
    } else if (multiLineStrEscapedCharTerminal != null) {
      text.append(this.visit(multiLineStrEscapedCharTerminal));
    } else if (multiLineStrRefTerminal != null) {
      text.append(this.visit(multiLineStrRefTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitLineStringLiteral(final KotlinParser.LineStringLiteralContext context) {
    final TerminalNode quoteOpenTerminal = context.QUOTE_OPEN();
    final List<KotlinParser.LineStringContentOrExpressionContext>
        lineStringContentOrExpressionContexts = context.lineStringContentOrExpression();
    final TerminalNode quoteCloseTerminal = context.QUOTE_CLOSE();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(quoteOpenTerminal));
    for (final KotlinParser.LineStringContentOrExpressionContext
        lineStringContentOrExpressionContext : lineStringContentOrExpressionContexts) {
      text.append(this.visit(lineStringContentOrExpressionContext));
    }
    text.append(this.visit(quoteCloseTerminal));
    return text.toString();
  }

  @Override
  public String visitLineStringContentOrExpression(
      final KotlinParser.LineStringContentOrExpressionContext context) {
    final KotlinParser.LineStringContentContext lineStringContentContext =
        context.lineStringContent();
    final KotlinParser.LineStringExpressionContext lineStringExpressionContext =
        context.lineStringExpression();
    final StringBuilder text = new StringBuilder();
    if (lineStringContentContext != null) {
      text.append(this.visit(lineStringContentContext));
    } else if (lineStringExpressionContext != null) {
      text.append(this.visit(lineStringExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitLineStringExpression(final KotlinParser.LineStringExpressionContext context) {
    final TerminalNode lineStrExprStartTerminal = context.LineStrExprStart();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final TerminalNode rcurlTerminal = context.RCURL();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lineStrExprStartTerminal))
        .append(this.visit(expressionContext))
        .append(this.visit(rcurlTerminal));
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
  public String visitFunctionValueParameters(
      final KotlinParser.FunctionValueParametersContext context) {
    final TerminalNode lparenTerminal = context.LPAREN();
    final List<KotlinParser.FunctionValueParameterContext> functionValueParameterContexts =
        context.functionValueParameter();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final TerminalNode rparenTerminal = context.RPAREN();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(lparenTerminal));
    if (!functionValueParameterContexts.isEmpty()) {
      final KotlinParser.FunctionValueParameterContext firstFunctionValueParameterContext =
          functionValueParameterContexts.get(0);
      text.append(this.visit(firstFunctionValueParameterContext));
      for (int index = 1; index < functionValueParameterContexts.size(); index++) {
        final TerminalNode commaTerminal = commaTerminals.get(index - 1);
        final KotlinParser.FunctionValueParameterContext functionValueParameterContext =
            functionValueParameterContexts.get(index);
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
  public String visitFunctionValueParameter(
      final KotlinParser.FunctionValueParameterContext context) {
    final KotlinParser.ModifierListContext modifierListContext = context.modifierList();
    final KotlinParser.ParameterContext parameterContext = context.parameter();
    final TerminalNode assignmentTerminal = context.ASSIGNMENT();
    final KotlinParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    if (modifierListContext != null) {
      text.append(this.visit(modifierListContext)).append(' ');
    }
    text.append(this.visit(parameterContext));
    if (assignmentTerminal != null) {
      text.append(' ')
          .append(this.visit(assignmentTerminal))
          .append(' ')
          .append(this.visit(expressionContext));
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
    final List<KotlinParser.SimpleIdentifierContext> simpleIdentifierContexts =
        context.simpleIdentifier();
    final List<TerminalNode> dotTerminals = context.DOT();
    final StringBuilder text = new StringBuilder();
    final KotlinParser.SimpleIdentifierContext firstSimpleIdentifierContext =
        simpleIdentifierContexts.get(0);
    text.append(this.visit(firstSimpleIdentifierContext));
    for (int index = 0; index < dotTerminals.size(); index++) {
      final TerminalNode dotTerminal = dotTerminals.get(index);
      final KotlinParser.SimpleIdentifierContext simpleIdentifierContext =
          simpleIdentifierContexts.get(index + 1);
      text.append(this.visit(dotTerminal)).append(this.visit(simpleIdentifierContext));
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
    this.ruleVisitCounts.putIfAbsent(ruleName, 0);
    this.ruleVisitCounts.computeIfPresent(ruleName, (ignored, currentCount) -> currentCount + 1);
    return tree.accept(this);
  }

  @Override
  @SuppressWarnings("MagicNumber")
  public String visitTerminal(final TerminalNode node) {
    int tokenIndex = node.getSymbol().getTokenIndex();
    // Since we skip NL and SEMICOLON tokens, we need to look back
    // and get the comment from the initially skipped token index.
    for (int index = tokenIndex - 1; index >= 0; index--) {
      final Token token = this.tokens.get(index);
      // The token type 5 is NL and 26 is SEMICOLON.
      // Note that we may have to update the type number if we modify the KotlinLexer.
      if (token.getType() != 5 && token.getType() != 26) {
        tokenIndex = index + 1;
        break;
      }
    }
    final List<Token> comments = this.tokens.getHiddenTokensToLeft(tokenIndex);
    final StringBuilder text = new StringBuilder();
    if (comments != null) {
      for (final Token comment : comments) {
        text.append(comment.getText());
        this.appendNewLinesAndIndent(text, 1);
      }
    }
    text.append(node.getText());
    return text.toString();
  }

  @Override
  public String visitChildren(final RuleNode node) {
    throw new UnsupportedOperationException(
        String.format(
            "The following rule is not implemented yet: %s text: %s",
            node.getClass(), node.getText()));
  }

  /**
   * We use this to add new lines with appropriate indentations.
   *
   * @param text We will append the new lines and indentations into this.
   * @param newLines Number of new lines before appending indentations.
   */
  private void appendNewLinesAndIndent(final StringBuilder text, final int newLines) {
    text.append("\n".repeat(newLines)).append(INDENT_UNIT.repeat(this.currentIndentLevel));
  }
}
