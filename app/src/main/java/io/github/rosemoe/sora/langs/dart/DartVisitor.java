package io.github.rosemoe.sora.langs.dart;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This is the class that has the formatting logic. Welcome to the project :) */
// Excluding the following PMD rules via `ruleSet.xml` didn't work, for some reason.
// Except PMD.UnusedAssignment was added due to a false-positive.
@SuppressWarnings({"PMD.TooManyMethods", "PMD.LinguisticNaming", "PMD.UnusedAssignment"})
public final class DartVisitor extends Dart2ParserBaseVisitor<String> {

  /** For logging. */
  private static final Logger LOGGER = LoggerFactory.getLogger(DartVisitor.class);

  /** Number of spaces for an indentation. */
  private static final String INDENT_UNIT = "  ";

  /**
   * Whenever we visit a rule, we will record its count. The purpose is to know what went down when
   * we visit a child context. Ex: For example, we want to format the constructor call differently
   * if the child also calls the constructor (nested constructor calls). We can identify the nested
   * constructor calls by checking the constructor call counts after visiting the child context. Key
   * - Simple class name of the context. Ex: CompilationUnitContext. Value - Number of visits.
   */
  private Map<String, Integer> ruleVisitCounts = new HashMap<>();

  /** As is. */
  private int currentIndentLevel;

  /** A flag to see if chaining the method currently. */
  private boolean methodChaining;

  /** For getting comments from the hidden channel. */
  private final CommonTokenStream tokens;

  /**
   * Constructor.
   *
   * @param tokens See {@link DartVisitor#tokens}.
   */
  public DartVisitor(final CommonTokenStream tokens) {
    this.tokens = tokens;
  }

  @Override
  public String visitCompilationUnit(final Dart2Parser.CompilationUnitContext context) {
    final Dart2Parser.LibraryDeclarationContext libraryDeclarationContext =
        context.libraryDeclaration();
    final Dart2Parser.PartDeclarationContext partDeclarationContext = context.partDeclaration();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final Dart2Parser.StatementContext statementContext = context.statement();
    final StringBuilder text = new StringBuilder();
    if (libraryDeclarationContext != null) {
      text.append(this.visit(libraryDeclarationContext));
    } else if (partDeclarationContext != null) {
      text.append(this.visit(partDeclarationContext));
    } else if (exprContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompilationUnit -> expr");
    } else if (statementContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompilationUnit -> statement");
    }
    this.appendNewLinesAndIndent(text, 1);
    return text.toString();
  }

  @Override
  public String visitPartDeclaration(final Dart2Parser.PartDeclarationContext context) {
    final Dart2Parser.PartHeaderContext partHeaderContext = context.partHeader();
    final List<Dart2Parser.MetadataContext> metadataContexts = context.metadata();
    final List<Dart2Parser.TopLevelDeclarationContext> topLevelDeclarationContexts =
        context.topLevelDeclaration();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(partHeaderContext));
    for (int index = 0; index < metadataContexts.size(); index++) {
      final Dart2Parser.MetadataContext metadataContext = metadataContexts.get(index);
      final Dart2Parser.TopLevelDeclarationContext topLevelDeclarationContext =
          topLevelDeclarationContexts.get(index);
      if (!metadataContext.getText().isEmpty()) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitPartDeclaration -> metadata");
      }
      this.appendNewLinesAndIndent(text, 2);
      text.append(this.visit(topLevelDeclarationContext));
    }
    return text.toString();
  }

  @Override
  public String visitPartHeader(final Dart2Parser.PartHeaderContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final TerminalNode partTerminal = context.PART_();
    final TerminalNode ofTerminal = context.OF_();
    final Dart2Parser.DottedIdentifierListContext dottedIdentifierListContext =
        context.dottedIdentifierList();
    final Dart2Parser.UriContext uriContext = context.uri();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet.: visitPartHeader -> metadata");
    }
    text.append(this.visit(partTerminal)).append(' ').append(this.visit(ofTerminal));
    if (dottedIdentifierListContext != null) {
      text.append(' ').append(this.visit(dottedIdentifierListContext));
    } else if (uriContext != null) {
      text.append(' ').append(this.visit(uriContext));
    }
    text.append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitLibraryDeclaration(final Dart2Parser.LibraryDeclarationContext context) {
    final Dart2Parser.LibraryNameContext libraryNameContext = context.libraryName();
    final List<Dart2Parser.ImportOrExportContext> importOrExportContexts = context.importOrExport();
    final List<Dart2Parser.PartDirectiveContext> partDirectiveContexts = context.partDirective();
    final List<Dart2Parser.MetadataContext> metadataContexts = context.metadata();
    final List<Dart2Parser.TopLevelDeclarationContext> topLevelDeclarationContexts =
        context.topLevelDeclaration();
    final StringBuilder text = new StringBuilder();
    if (libraryNameContext != null) {
      text.append(this.visit(libraryNameContext));
    }
    if (!importOrExportContexts.isEmpty()) {
      if (libraryNameContext != null) {
        this.appendNewLinesAndIndent(text, 2);
      }
      for (final Dart2Parser.ImportOrExportContext importOrExportContext : importOrExportContexts) {
        final String importOrExportText = this.visit(importOrExportContext);
        text.append(importOrExportText);
        this.appendNewLinesAndIndent(text, 1);
      }
      this.appendNewLinesAndIndent(text, 1);
    }
    if (!partDirectiveContexts.isEmpty()) {
      if (libraryNameContext != null && importOrExportContexts.isEmpty()) {
        this.appendNewLinesAndIndent(text, 2);
      }
      for (final Dart2Parser.PartDirectiveContext partDirectiveContext : partDirectiveContexts) {
        text.append(this.visit(partDirectiveContext));
        this.appendNewLinesAndIndent(text, 1);
      }
      this.appendNewLinesAndIndent(text, 1);
    }
    if (!topLevelDeclarationContexts.isEmpty()) {
      for (int index = 0; index < topLevelDeclarationContexts.size(); index++) {
        if (index > 0) {
          this.appendNewLinesAndIndent(text, 2);
        }
        final Dart2Parser.MetadataContext metadataContext = metadataContexts.get(index);
        final Dart2Parser.TopLevelDeclarationContext topLevelDeclarationContext =
            topLevelDeclarationContexts.get(index);
        if (!metadataContext.getText().isEmpty()) {
          text.append(this.visit(metadataContext));
          this.appendNewLinesAndIndent(text, 1);
        }
        final String topLevelDeclarationText = this.visit(topLevelDeclarationContext);
        text.append(topLevelDeclarationText);
      }
    }
    return text.toString();
  }

  @Override
  public String visitPartDirective(final Dart2Parser.PartDirectiveContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final TerminalNode partTerminal = context.PART_();
    final Dart2Parser.UriContext uriContext = context.uri();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitPartDirective -> metadata");
    }
    text.append(this.visit(partTerminal))
        .append(' ')
        .append(this.visit(uriContext))
        .append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitLibraryName(final Dart2Parser.LibraryNameContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final TerminalNode libraryTerminal = context.LIBRARY_();
    final Dart2Parser.DottedIdentifierListContext dottedIdentifierListContext =
        context.dottedIdentifierList();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitLibraryName -> metadata");
    }
    text.append(this.visit(libraryTerminal))
        .append(' ')
        .append(this.visit(dottedIdentifierListContext))
        .append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitDottedIdentifierList(final Dart2Parser.DottedIdentifierListContext context) {
    final List<Dart2Parser.IdentifierContext> identifierContexts = context.identifier();
    final List<TerminalNode> dTerminals = context.D();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.IdentifierContext firstIdentifierContext = identifierContexts.get(0);
    text.append(this.visit(firstIdentifierContext));
    for (int index = 0; index < dTerminals.size(); index++) {
      final TerminalNode dTerminal = dTerminals.get(index);
      final Dart2Parser.IdentifierContext identifierContext = identifierContexts.get(index + 1);
      text.append(this.visit(dTerminal)).append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitTopLevelDeclaration(final Dart2Parser.TopLevelDeclarationContext context) {
    final Dart2Parser.ClassDeclarationContext classDeclarationContext = context.classDeclaration();
    final Dart2Parser.MixinDeclarationContext mixinDeclarationContext = context.mixinDeclaration();
    final Dart2Parser.ExtensionDeclarationContext extensionDeclarationContext =
        context.extensionDeclaration();
    final Dart2Parser.EnumTypeContext enumTypeContext = context.enumType();
    final Dart2Parser.TypeAliasContext typeAliasContext = context.typeAlias();
    final TerminalNode externalTerminal = context.EXTERNAL_();
    final Dart2Parser.FunctionSignatureContext functionSignatureContext =
        context.functionSignature();
    final TerminalNode scTerminal = context.SC();
    final Dart2Parser.GetterSignatureContext getterSignatureContext = context.getterSignature();
    final Dart2Parser.SetterSignatureContext setterSignatureContext = context.setterSignature();
    final Dart2Parser.FunctionBodyContext functionBodyContext = context.functionBody();
    final TerminalNode finalTerminal = context.FINAL_();
    final TerminalNode constTerminal = context.CONST_();
    final Dart2Parser.TypeContext typeContext = context.type();
    final Dart2Parser.StaticFinalDeclarationListContext staticFinalDeclarationListContext =
        context.staticFinalDeclarationList();
    final TerminalNode lateTerminal = context.LATE_();
    final Dart2Parser.InitializedIdentifierListContext initializedIdentifierListContext =
        context.initializedIdentifierList();
    final Dart2Parser.VarOrTypeContext varOrTypeContext = context.varOrType();
    final StringBuilder text = new StringBuilder();
    if (classDeclarationContext != null) {
      text.append(this.visit(classDeclarationContext));
    } else if (mixinDeclarationContext != null) {
      text.append(this.visit(mixinDeclarationContext));
    } else if (extensionDeclarationContext != null) {
      text.append(this.visit(extensionDeclarationContext));
    } else if (enumTypeContext != null) {
      text.append(this.visit(enumTypeContext));
    } else if (typeAliasContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTopLevelDeclaration -> typeAlias");
    } else if (externalTerminal != null && functionSignatureContext != null && scTerminal != null) {
      // EXTERNAL_ functionSignature SC
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTopLevelDeclaration -> EXTERNAL_ functionSignature SC");
    } else if (externalTerminal != null && getterSignatureContext != null && scTerminal != null) {
      // EXTERNAL_ getterSignature SC
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTopLevelDeclaration -> EXTERNAL_ getterSignature SC");
    } else if (externalTerminal != null && setterSignatureContext != null && scTerminal != null) {
      // EXTERNAL_ setterSignature SC
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTopLevelDeclaration -> EXTERNAL_ setterSignature SC");
    } else if (functionSignatureContext != null && functionBodyContext != null) {
      // functionSignature functionBody
      text.append(this.visit(functionSignatureContext))
          .append(' ')
          .append(this.visit(functionBodyContext));
    } else if (getterSignatureContext != null && functionBodyContext != null) {
      // getterSignature functionBody
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTopLevelDeclaration -> getterSignature functionBody");
    } else if (setterSignatureContext != null && functionBodyContext != null) {
      // setterSignature functionBody
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTopLevelDeclaration -> setterSignature functionBody");
    } else if (staticFinalDeclarationListContext != null) {
      // ( FINAL_ | CONST_) type? staticFinalDeclarationList SC
      if (finalTerminal == null) {
        text.append(this.visit(constTerminal)).append(' ');
      } else {
        text.append(this.visit(finalTerminal)).append(' ');
      }
      if (typeContext != null) {
        text.append(this.visit(typeContext)).append(' ');
      }
      text.append(this.visit(staticFinalDeclarationListContext)).append(this.visit(scTerminal));
    } else if (lateTerminal != null
        && finalTerminal != null
        && initializedIdentifierListContext != null
        && scTerminal != null) {
      // LATE_ FINAL_ type? initializedIdentifierList SC
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTopLevelDeclaration -> LATE_ FINAL_ type? initializedIdentifierList SC");
    } else if (varOrTypeContext != null
        && initializedIdentifierListContext != null
        && scTerminal != null) {
      // LATE_? varOrType initializedIdentifierList SC
      if (lateTerminal != null) {
        text.append(this.visit(lateTerminal)).append(' ');
      }
      text.append(this.visit(varOrTypeContext))
          .append(' ')
          .append(this.visit(initializedIdentifierListContext))
          .append(this.visit(scTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitExtensionDeclaration(final Dart2Parser.ExtensionDeclarationContext context) {
    final TerminalNode extensionTerminal = context.EXTENSION_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.TypeParametersContext typeParametersContext = context.typeParameters();
    final TerminalNode onTerminal = context.ON_();
    final Dart2Parser.TypeContext typeContext = context.type();
    final TerminalNode obcTerminal = context.OBC();
    final List<Dart2Parser.MetadataContext> metadataContexts = context.metadata();
    final List<Dart2Parser.ClassMemberDeclarationContext> classMemberDeclarationContexts =
        context.classMemberDeclaration();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(extensionTerminal));
    if (identifierContext != null) {
      text.append(' ').append(this.visit(identifierContext));
    }
    if (typeParametersContext != null) {
      text.append(this.visit(typeParametersContext));
    }
    text.append(' ')
        .append(this.visit(onTerminal))
        .append(' ')
        .append(this.visit(typeContext))
        .append(' ')
        .append(this.visit(obcTerminal));
    this.currentIndentLevel++;
    this.appendNewLinesAndIndent(text, 2);
    for (int index = 0; index < metadataContexts.size(); index++) {
      final Dart2Parser.MetadataContext metadataContext = metadataContexts.get(index);
      final Dart2Parser.ClassMemberDeclarationContext classMemberDeclarationContext =
          classMemberDeclarationContexts.get(index);
      if (!metadataContext.getText().isEmpty()) {
        text.append(this.visit(metadataContext));
        this.appendNewLinesAndIndent(text, 1);
      }
      text.append(this.visit(classMemberDeclarationContext));
    }
    this.currentIndentLevel--;
    this.appendNewLinesAndIndent(text, 2);
    text.append(this.visit(cbcTerminal));
    return text.toString();
  }

  @Override
  public String visitEnumType(final Dart2Parser.EnumTypeContext context) {
    final TerminalNode enumTerminal = context.ENUM_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode obcTerminal = context.OBC();
    final List<Dart2Parser.EnumEntryContext> enumEntryContexts = context.enumEntry();
    final List<TerminalNode> cTerminals = context.C();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(enumTerminal))
        .append(' ')
        .append(this.visit(identifierContext))
        .append(' ')
        .append(this.visit(obcTerminal));
    this.currentIndentLevel++;
    this.appendNewLinesAndIndent(text, 1);
    final Dart2Parser.EnumEntryContext firstEnumEntryContext = enumEntryContexts.get(0);
    text.append(this.visit(firstEnumEntryContext));
    for (int index = 1; index < enumEntryContexts.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index - 1);
      final Dart2Parser.EnumEntryContext enumEntryContext = enumEntryContexts.get(index);
      text.append(this.visit(cTerminal));
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(enumEntryContext));
    }
    if (enumEntryContexts.size() == cTerminals.size()) {
      final TerminalNode cTerminal = cTerminals.get(enumEntryContexts.size() - 1);
      text.append(this.visit(cTerminal));
    }
    this.currentIndentLevel--;
    this.appendNewLinesAndIndent(text, 1);
    text.append(this.visit(cbcTerminal));
    return text.toString();
  }

  @Override
  public String visitEnumEntry(final Dart2Parser.EnumEntryContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitEnumEntry -> metadata");
    }
    text.append(this.visit(identifierContext));
    return text.toString();
  }

  @Override
  public String visitMixinDeclaration(final Dart2Parser.MixinDeclarationContext context) {
    final TerminalNode mixinTerminal = context.MIXIN_();
    final Dart2Parser.TypeIdentifierContext typeIdentifierContext = context.typeIdentifier();
    final Dart2Parser.TypeParametersContext typeParametersContext = context.typeParameters();
    final TerminalNode onTerminal = context.ON_();
    final Dart2Parser.TypeNotVoidListContext typeNotVoidListContext = context.typeNotVoidList();
    final Dart2Parser.InterfacesContext interfacesContext = context.interfaces();
    final TerminalNode obcTerminal = context.OBC();
    final List<Dart2Parser.MetadataContext> metadataContexts = context.metadata();
    final List<Dart2Parser.ClassMemberDeclarationContext> classMemberDeclarationContexts =
        context.classMemberDeclaration();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(mixinTerminal)).append(' ').append(this.visit(typeIdentifierContext));
    if (typeParametersContext == null) {
      text.append(' ');
    } else {
      text.append(this.visit(typeParametersContext)).append(' ');
    }
    if (onTerminal != null) {
      text.append(this.visit(onTerminal))
          .append(' ')
          .append(this.visit(typeNotVoidListContext))
          .append(' ');
    }
    if (interfacesContext != null) {
      text.append(this.visit(interfacesContext)).append(' ');
    }
    text.append(this.visit(obcTerminal));
    for (int index = 0; index < classMemberDeclarationContexts.size(); index++) {
      final Dart2Parser.MetadataContext metadataContext = metadataContexts.get(index);
      final Dart2Parser.ClassMemberDeclarationContext classMemberDeclarationContext =
          classMemberDeclarationContexts.get(index);
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 2);
      if (!metadataContext.getText().isEmpty()) {
        text.append(this.visit(metadataContext));
        this.appendNewLinesAndIndent(text, 1);
      }
      text.append(this.visit(classMemberDeclarationContext));
      this.currentIndentLevel--;
      if (index == classMemberDeclarationContexts.size() - 1) {
        this.appendNewLinesAndIndent(text, 2);
      }
    }
    text.append(this.visit(cbcTerminal));
    return text.toString();
  }

  @Override
  public String visitTypeIdentifier(final Dart2Parser.TypeIdentifierContext context) {
    final TerminalNode identifierTerminal = context.IDENTIFIER();
    final TerminalNode asyncTerminal = context.ASYNC_();
    final TerminalNode hideTerminal = context.HIDE_();
    final TerminalNode ofTerminal = context.OF_();
    final TerminalNode onTerminal = context.ON_();
    final TerminalNode showTerminal = context.SHOW_();
    final TerminalNode syncTerminal = context.SYNC_();
    final TerminalNode awaitTerminal = context.AWAIT_();
    final TerminalNode yieldTerminal = context.YIELD_();
    final TerminalNode dynamicTerminal = context.DYNAMIC_();
    final TerminalNode nativeTerminal = context.NATIVE_();
    final TerminalNode functionTerminal = context.FUNCTION_();
    final StringBuilder text = new StringBuilder();
    if (identifierTerminal != null) {
      text.append(this.visit(identifierTerminal));
    } else if (asyncTerminal != null) {
      text.append(this.visit(asyncTerminal));
    } else if (hideTerminal != null) {
      text.append(this.visit(hideTerminal));
    } else if (ofTerminal != null) {
      text.append(this.visit(ofTerminal));
    } else if (onTerminal != null) {
      text.append(this.visit(onTerminal));
    } else if (showTerminal != null) {
      text.append(this.visit(showTerminal));
    } else if (syncTerminal != null) {
      text.append(this.visit(syncTerminal));
    } else if (awaitTerminal != null) {
      text.append(this.visit(awaitTerminal));
    } else if (yieldTerminal != null) {
      text.append(this.visit(yieldTerminal));
    } else if (dynamicTerminal != null) {
      text.append(this.visit(dynamicTerminal));
    } else if (nativeTerminal != null) {
      text.append(this.visit(nativeTerminal));
    } else if (functionTerminal != null) {
      text.append(this.visit(functionTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitImportOrExport(final Dart2Parser.ImportOrExportContext context) {
    final Dart2Parser.LibraryImportContext libraryImportContext = context.libraryImport();
    final Dart2Parser.LibraryExportContext libraryExportContext = context.libraryExport();
    final StringBuilder text = new StringBuilder();
    if (libraryImportContext == null) {
      text.append(this.visit(libraryExportContext));
    } else {
      text.append(this.visit(libraryImportContext));
    }
    return text.toString();
  }

  @Override
  public String visitLibraryExport(final Dart2Parser.LibraryExportContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final TerminalNode exportTerminal = context.EXPORT_();
    final Dart2Parser.ConfigurableUriContext configurableUriContext = context.configurableUri();
    final List<Dart2Parser.CombinatorContext> combinatorContexts = context.combinator();
    final TerminalNode scTerminal = context.SC();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitLibraryExport -> metadata");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(exportTerminal)).append(' ').append(this.visit(configurableUriContext));
    for (final Dart2Parser.CombinatorContext combinatorContext : combinatorContexts) {
      text.append(' ').append(this.visit(combinatorContext));
    }
    text.append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitLibraryImport(final Dart2Parser.LibraryImportContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.ImportSpecificationContext importSpecificationContext =
        context.importSpecification();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitLibraryImport -> metadata");
    }
    final StringBuilder text = new StringBuilder();
    final String importSpecificationText = this.visit(importSpecificationContext);
    text.append(importSpecificationText);
    return text.toString();
  }

  @Override
  public String visitImportSpecification(final Dart2Parser.ImportSpecificationContext context) {
    final TerminalNode importTerminal = context.IMPORT_();
    final Dart2Parser.ConfigurableUriContext configurableUriContext = context.configurableUri();
    final TerminalNode deferredTerminal = context.DEFERRED_();
    final TerminalNode asTerminal = context.AS_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final List<Dart2Parser.CombinatorContext> combinatorContexts = context.combinator();
    final TerminalNode scTerminal = context.SC();
    if (deferredTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitImportSpecification -> deferred");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(importTerminal)).append(' ').append(this.visit(configurableUriContext));
    if (asTerminal != null) {
      text.append(' ')
          .append(this.visit(asTerminal))
          .append(' ')
          .append(this.visit(identifierContext));
    }
    for (final Dart2Parser.CombinatorContext combinatorContext : combinatorContexts) {
      text.append(' ').append(this.visit(combinatorContext));
    }
    text.append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitCombinator(final Dart2Parser.CombinatorContext context) {
    final TerminalNode showTerminal = context.SHOW_();
    final Dart2Parser.IdentifierListContext identifierListContext = context.identifierList();
    final TerminalNode hideTerminal = context.HIDE_();
    final StringBuilder text = new StringBuilder();
    if (showTerminal != null) {
      text.append(this.visit(showTerminal));
    } else if (hideTerminal != null) {
      text.append(this.visit(hideTerminal));
    }
    text.append(' ').append(this.visit(identifierListContext));
    return text.toString();
  }

  @Override
  public String visitIdentifierList(final Dart2Parser.IdentifierListContext context) {
    final List<Dart2Parser.IdentifierContext> identifierContexts = context.identifier();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.IdentifierContext firstIdentifierContext = identifierContexts.get(0);
    text.append(this.visit(firstIdentifierContext));
    for (int index = 0; index < cTerminals.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index);
      final Dart2Parser.IdentifierContext identifierContext = identifierContexts.get(index + 1);
      text.append(this.visit(cTerminal)).append(' ').append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitConfigurableUri(final Dart2Parser.ConfigurableUriContext context) {
    final Dart2Parser.UriContext uriContext = context.uri();
    final List<Dart2Parser.ConfigurationUriContext> configurationUriContexts =
        context.configurationUri();
    if (!configurationUriContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitConfigurableUri -> configurationUri");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(uriContext));
    return text.toString();
  }

  @Override
  public String visitUri(final Dart2Parser.UriContext context) {
    final Dart2Parser.StringLiteralContext stringLiteralContext = context.stringLiteral();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(stringLiteralContext));
    return text.toString();
  }

  @Override
  public String visitStringLiteral(final Dart2Parser.StringLiteralContext context) {
    final List<Dart2Parser.MultilineStringContext> multilineStringContexts =
        context.multilineString();
    final List<Dart2Parser.SingleLineStringContext> singleLineStringContexts =
        context.singleLineString();
    final StringBuilder text = new StringBuilder();
    for (final Dart2Parser.MultilineStringContext multilineStringContext :
        multilineStringContexts) {
      text.append(this.visit(multilineStringContext));
    }
    for (final Dart2Parser.SingleLineStringContext singleLineStringContext :
        singleLineStringContexts) {
      text.append(this.visit(singleLineStringContext));
    }
    return text.toString();
  }

  @Override
  public String visitMultilineString(final Dart2Parser.MultilineStringContext context) {
    final TerminalNode multiLineStringTerminal = context.MultiLineString();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(multiLineStringTerminal));
    return text.toString();
  }

  @Override
  public String visitSingleLineString(final Dart2Parser.SingleLineStringContext context) {
    final TerminalNode singleLineString = context.SingleLineString();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(singleLineString));
    return text.toString();
  }

  @Override
  public String visitClassDeclaration(final Dart2Parser.ClassDeclarationContext context) {
    final TerminalNode abstractTerminal = context.ABSTRACT_();
    final TerminalNode classTerminal = context.CLASS_();
    // It can be a class name.
    final Dart2Parser.TypeIdentifierContext typeIdentifierContext = context.typeIdentifier();
    final Dart2Parser.TypeParametersContext typeParametersContext = context.typeParameters();
    final Dart2Parser.SuperclassContext superclassContext = context.superclass();
    final Dart2Parser.InterfacesContext interfacesContext = context.interfaces();
    final TerminalNode obcTerminal = context.OBC();
    final List<Dart2Parser.MetadataContext> metadataContexts = context.metadata();
    final List<Dart2Parser.ClassMemberDeclarationContext> classMemberDeclarationContexts =
        context.classMemberDeclaration();
    final TerminalNode cbcTerminal = context.CBC();
    final Dart2Parser.MixinApplicationClassContext mixinApplicationClassContext =
        context.mixinApplicationClass();
    if (mixinApplicationClassContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitClassDeclaration -> mixinApplicationClass");
    }
    final StringBuilder text = new StringBuilder();
    if (abstractTerminal != null) {
      text.append(this.visit(abstractTerminal)).append(' ');
    }
    text.append(this.visit(classTerminal)).append(' ').append(this.visit(typeIdentifierContext));
    if (typeParametersContext == null) {
      text.append(' ');
    } else {
      text.append(this.visit(typeParametersContext)).append(' ');
    }
    if (superclassContext != null) {
      text.append(this.visit(superclassContext)).append(' ');
    }
    if (interfacesContext != null) {
      text.append(this.visit(interfacesContext)).append(' ');
    }
    text.append(this.visit(obcTerminal)).append("\n\n");
    this.currentIndentLevel++;
    if (!classMemberDeclarationContexts.isEmpty()) {
      text.append(INDENT_UNIT.repeat(this.currentIndentLevel));
    }
    for (int index = 0; index < classMemberDeclarationContexts.size(); index++) {
      final Dart2Parser.MetadataContext metadataContext = metadataContexts.get(index);
      final Dart2Parser.ClassMemberDeclarationContext classMemberDeclarationContext =
          classMemberDeclarationContexts.get(index);
      if (!metadataContext.getText().isEmpty()) {
        text.append(this.visit(metadataContext));
        this.appendNewLinesAndIndent(text, 1);
      }
      text.append(this.visit(classMemberDeclarationContext)).append("\n\n");
      if (index < classMemberDeclarationContexts.size() - 1) {
        text.append(INDENT_UNIT.repeat(this.currentIndentLevel));
      }
    }
    this.currentIndentLevel--;
    text.append(INDENT_UNIT.repeat(this.currentIndentLevel)).append(this.visit(cbcTerminal));
    return text.toString();
  }

  @Override
  public String visitInterfaces(final Dart2Parser.InterfacesContext context) {
    final TerminalNode implementsTerminal = context.IMPLEMENTS_();
    final Dart2Parser.TypeNotVoidListContext typeNotVoidListContext = context.typeNotVoidList();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(implementsTerminal))
        .append(' ')
        .append(this.visit(typeNotVoidListContext));
    return text.toString();
  }

  @Override
  public String visitTypeParameters(final Dart2Parser.TypeParametersContext context) {
    final TerminalNode ltTerminal = context.LT();
    final List<Dart2Parser.TypeParameterContext> typeParameterContexts = context.typeParameter();
    final List<TerminalNode> cTerminals = context.C();
    final TerminalNode gtTerminal = context.GT();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(ltTerminal));
    final Dart2Parser.TypeParameterContext firstTypeParameter = typeParameterContexts.get(0);
    text.append(this.visit(firstTypeParameter));
    for (int index = 0; index < cTerminals.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index);
      final Dart2Parser.TypeParameterContext typeParameterContext =
          typeParameterContexts.get(index + 1);
      text.append(this.visit(cTerminal)).append(' ').append(this.visit(typeParameterContext));
    }
    text.append(this.visit(gtTerminal));
    return text.toString();
  }

  @Override
  public String visitTypeParameter(final Dart2Parser.TypeParameterContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode extendsTerminal = context.EXTENDS_();
    final Dart2Parser.TypeNotVoidContext typeNotVoidContext = context.typeNotVoid();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      text.append(this.visit(metadataContext)).append(' ');
    }
    text.append(this.visit(identifierContext));
    if (extendsTerminal != null) {
      text.append(' ')
          .append(this.visit(extendsTerminal))
          .append(' ')
          .append(this.visit(typeNotVoidContext));
    }
    return text.toString();
  }

  @Override
  public String visitMetadata(final Dart2Parser.MetadataContext context) {
    final List<TerminalNode> atTerminals = context.AT();
    final List<Dart2Parser.MetadatumContext> metadatumContexts = context.metadatum();
    final StringBuilder text = new StringBuilder();
    for (int index = 0; index < atTerminals.size(); index++) {
      final TerminalNode atTerminal = atTerminals.get(index);
      final Dart2Parser.MetadatumContext metadatumContext = metadatumContexts.get(index);
      text.append(this.visit(atTerminal)).append(this.visit(metadatumContext));
    }
    return text.toString();
  }

  @Override
  public String visitMetadatum(final Dart2Parser.MetadatumContext context) {
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.QualifiedNameContext qualifiedNameContext = context.qualifiedName();
    // todo: use `constructorDesignationContext`, `argumentsContext`, and `argumentsContext` with
    // tests.
    // final Dart2Parser.ConstructorDesignationContext constructorDesignationContext =
    // context.constructorDesignation();
    // final Dart2Parser.ArgumentsContext argumentsContext = context.arguments();
    final StringBuilder text = new StringBuilder();
    if (identifierContext != null) {
      text.append(this.visit(identifierContext));
    } else if (qualifiedNameContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitMetadatum -> qualifiedName");
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitMetadatum -> constructorDesignation");
    }
    return text.toString();
  }

  @Override
  public String visitSuperclass(final Dart2Parser.SuperclassContext context) {
    final TerminalNode extendsTerminal = context.EXTENDS_();
    final Dart2Parser.TypeNotVoidContext typeNotVoidContext = context.typeNotVoid();
    final Dart2Parser.MixinsContext mixinsContext = context.mixins();
    final StringBuilder text = new StringBuilder();
    if (extendsTerminal != null) {
      text.append(this.visit(extendsTerminal)).append(' ').append(this.visit(typeNotVoidContext));
      if (mixinsContext != null) {
        text.append(' ').append(this.visit(mixinsContext));
      }
    } else {
      text.append(this.visit(mixinsContext));
    }
    return text.toString();
  }

  @Override
  public String visitMixins(final Dart2Parser.MixinsContext context) {
    final TerminalNode withTerminal = context.WITH_();
    final Dart2Parser.TypeNotVoidListContext typeNotVoidListContext = context.typeNotVoidList();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(withTerminal)).append(' ').append(this.visit(typeNotVoidListContext));
    return text.toString();
  }

  @Override
  public String visitTypeNotVoidList(final Dart2Parser.TypeNotVoidListContext context) {
    final List<Dart2Parser.TypeNotVoidContext> typeNotVoidContexts = context.typeNotVoid();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.TypeNotVoidContext firstTypeNotVoidContext = typeNotVoidContexts.get(0);
    text.append(this.visit(firstTypeNotVoidContext));
    for (int index = 0; index < cTerminals.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index);
      final Dart2Parser.TypeNotVoidContext typeNotVoidContext = typeNotVoidContexts.get(index + 1);
      text.append(this.visit(cTerminal)).append(' ').append(this.visit(typeNotVoidContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeNotVoid(final Dart2Parser.TypeNotVoidContext context) {
    final Dart2Parser.FunctionTypeContext functionTypeContext = context.functionType();
    // todo: use `quTerminal` with tests.
    // final TerminalNode quTerminal = context.QU();
    final Dart2Parser.TypeNotVoidNotFunctionContext typeNotVoidNotFunctionContext =
        context.typeNotVoidNotFunction();
    if (functionTypeContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTypeNotVoid -> functionType");
    }
    final StringBuilder text = new StringBuilder();
    if (typeNotVoidNotFunctionContext != null) {
      text.append(this.visit(typeNotVoidNotFunctionContext));
    }
    return text.toString();
  }

  @Override
  public String visitClassMemberDeclaration(
      final Dart2Parser.ClassMemberDeclarationContext context) {
    final Dart2Parser.DeclarationContext declarationContext = context.declaration();
    final TerminalNode scTerminal = context.SC();
    final Dart2Parser.MethodSignatureContext methodSignatureContext = context.methodSignature();
    final Dart2Parser.FunctionBodyContext functionBodyContext = context.functionBody();
    final StringBuilder text = new StringBuilder();
    if (declarationContext != null) {
      final String declarationText = this.visit(declarationContext);
      text.append(declarationText).append(this.visit(scTerminal));
    }
    if (methodSignatureContext != null) {
      final String methodSignatureText = this.visit(methodSignatureContext);
      text.append(methodSignatureText).append(' ');
      final String functionBodyText = this.visit(functionBodyContext);
      text.append(functionBodyText);
    }
    return text.toString();
  }

  @Override
  public String visitMethodSignature(final Dart2Parser.MethodSignatureContext context) {
    final Dart2Parser.ConstructorSignatureContext constructorSignatureContext =
        context.constructorSignature();
    final Dart2Parser.InitializersContext initializersContext = context.initializers();
    final Dart2Parser.FactoryConstructorSignatureContext factoryConstructorSignatureContext =
        context.factoryConstructorSignature();
    final TerminalNode staticTerminal = context.STATIC_();
    final Dart2Parser.FunctionSignatureContext functionSignatureContext =
        context.functionSignature();
    final Dart2Parser.GetterSignatureContext getterSignatureContext = context.getterSignature();
    final Dart2Parser.SetterSignatureContext setterSignatureContext = context.setterSignature();
    final Dart2Parser.OperatorSignatureContext operatorSignatureContext =
        context.operatorSignature();
    final StringBuilder text = new StringBuilder();
    if (constructorSignatureContext != null) {
      text.append(this.visit(constructorSignatureContext))
          .append(' ')
          .append(this.visit(initializersContext));
    } else if (factoryConstructorSignatureContext != null) {
      final String factoryConstructorSignatureText = this.visit(factoryConstructorSignatureContext);
      text.append(factoryConstructorSignatureText);
    } else if (functionSignatureContext != null) {
      if (staticTerminal != null) {
        text.append(this.visit(staticTerminal)).append(' ');
      }
      text.append(this.visit(functionSignatureContext));
    } else if (getterSignatureContext != null) {
      if (staticTerminal != null) {
        text.append(this.visit(staticTerminal)).append(' ');
      }
      text.append(this.visit(getterSignatureContext));
    } else if (setterSignatureContext != null) {
      if (staticTerminal != null) {
        text.append(this.visit(staticTerminal)).append(' ');
      }
      text.append(this.visit(setterSignatureContext));
    } else if (operatorSignatureContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitMethodSignature -> operatorSignature");
    }
    return text.toString();
  }

  @Override
  public String visitSetterSignature(final Dart2Parser.SetterSignatureContext context) {
    final Dart2Parser.TypeContext typeContext = context.type();
    final TerminalNode setTerminal = context.SET_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.FormalParameterListContext formalParameterListContext =
        context.formalParameterList();
    final StringBuilder text = new StringBuilder();
    if (typeContext != null) {
      text.append(this.visit(typeContext)).append(' ');
    }
    text.append(this.visit(setTerminal))
        .append(' ')
        .append(this.visit(identifierContext))
        .append(this.visit(formalParameterListContext));
    return text.toString();
  }

  @Override
  public String visitGetterSignature(final Dart2Parser.GetterSignatureContext context) {
    final Dart2Parser.TypeContext typeContext = context.type();
    final TerminalNode getTerminal = context.GET_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (typeContext != null) {
      text.append(this.visit(typeContext)).append(' ');
    }
    text.append(this.visit(getTerminal)).append(' ').append(this.visit(identifierContext));
    return text.toString();
  }

  @Override
  public String visitFactoryConstructorSignature(
      final Dart2Parser.FactoryConstructorSignatureContext context) {
    final TerminalNode constTerminal = context.CONST_();
    final TerminalNode factoryTerminal = context.FACTORY_();
    final Dart2Parser.ConstructorNameContext constructorNameContext = context.constructorName();
    final Dart2Parser.FormalParameterListContext formalParameterListContext =
        context.formalParameterList();
    if (constTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFactoryConstructorSignature -> const");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(factoryTerminal)).append(' ').append(this.visit(constructorNameContext));
    final String formalParameterListText = this.visit(formalParameterListContext);
    text.append(formalParameterListText);
    return text.toString();
  }

  @Override
  public String visitConstructorName(final Dart2Parser.ConstructorNameContext context) {
    final Dart2Parser.TypeIdentifierContext typeIdentifierContext = context.typeIdentifier();
    final TerminalNode dTerminal = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(typeIdentifierContext));
    if (dTerminal != null) {
      text.append(this.visit(dTerminal)).append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitFunctionSignature(final Dart2Parser.FunctionSignatureContext context) {
    final Dart2Parser.TypeContext typeContext = context.type();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.FormalParameterPartContext formalParameterPartContext =
        context.formalParameterPart();
    final StringBuilder text = new StringBuilder();
    if (typeContext != null) {
      text.append(this.visit(typeContext)).append(' ');
    }
    text.append(this.visit(identifierContext));
    final String formalParameterText = this.visit(formalParameterPartContext);
    text.append(formalParameterText);
    return text.toString();
  }

  @Override
  public String visitFormalParameterPart(final Dart2Parser.FormalParameterPartContext context) {
    final Dart2Parser.TypeParametersContext typeParametersContext = context.typeParameters();
    final Dart2Parser.FormalParameterListContext formalParameterListContext =
        context.formalParameterList();
    final StringBuilder text = new StringBuilder();
    if (typeParametersContext != null) {
      text.append(this.visit(typeParametersContext));
    }
    final String formalParameterListText = this.visit(formalParameterListContext);
    text.append(formalParameterListText);
    return text.toString();
  }

  @Override
  public String visitFormalParameterList(final Dart2Parser.FormalParameterListContext context) {
    final TerminalNode opTerminal = context.OP();
    final TerminalNode cpTerminal = context.CP();
    final Dart2Parser.NormalFormalParametersContext normalFormalParametersContext =
        context.normalFormalParameters();
    final TerminalNode cTerminal = context.C();
    final Dart2Parser.OptionalOrNamedFormalParametersContext
        optionalOrNamedFormalParametersContext = context.optionalOrNamedFormalParameters();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(opTerminal));
    if (normalFormalParametersContext != null) {
      final String normalFormalParametersText = this.visit(normalFormalParametersContext);
      text.append(normalFormalParametersText);
    }
    if (cTerminal != null) {
      text.append(this.visit(cTerminal)).append(' ');
    }
    if (optionalOrNamedFormalParametersContext != null) {
      text.append(this.visit(optionalOrNamedFormalParametersContext));
    }
    text.append(this.visit(cpTerminal));
    return text.toString();
  }

  @Override
  public String visitOptionalOrNamedFormalParameters(
      final Dart2Parser.OptionalOrNamedFormalParametersContext context) {
    final Dart2Parser.OptionalPositionalFormalParametersContext
        optionalPositionalFormalParametersContext = context.optionalPositionalFormalParameters();
    final Dart2Parser.NamedFormalParametersContext namedFormalParametersContext =
        context.namedFormalParameters();
    final StringBuilder text = new StringBuilder();
    if (optionalPositionalFormalParametersContext != null) {
      text.append(this.visit(optionalPositionalFormalParametersContext));
    }
    if (namedFormalParametersContext != null) {
      text.append(this.visit(namedFormalParametersContext));
    }
    return text.toString();
  }

  @Override
  public String visitOptionalPositionalFormalParameters(
      final Dart2Parser.OptionalPositionalFormalParametersContext context) {
    final TerminalNode obTerminal = context.OB();
    final List<Dart2Parser.DefaultFormalParameterContext> defaultFormalParameterContexts =
        context.defaultFormalParameter();
    final List<TerminalNode> cTerminals = context.C();
    final TerminalNode cbTerminal = context.CB();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(obTerminal));
    final Dart2Parser.DefaultFormalParameterContext firstDefaultFormalParameterContext =
        defaultFormalParameterContexts.get(0);
    text.append(this.visit(firstDefaultFormalParameterContext));
    if (defaultFormalParameterContexts.size() > 1) {
      for (int index = 0; index < cTerminals.size(); index++) {
        final TerminalNode cTerminal = cTerminals.get(index);
        if (defaultFormalParameterContexts.size() > index + 1) {
          text.append(this.visit(cTerminal)).append(' ');
          final Dart2Parser.DefaultFormalParameterContext defaultFormalParameterContext =
              defaultFormalParameterContexts.get(index + 1);
          text.append(this.visit(defaultFormalParameterContext));
        } else {
          text.append(this.visit(cTerminal));
        }
      }
    }
    text.append(this.visit(cbTerminal));
    return text.toString();
  }

  @Override
  public String visitDefaultFormalParameter(
      final Dart2Parser.DefaultFormalParameterContext context) {
    final Dart2Parser.NormalFormalParameterContext normalFormalParameterContext =
        context.normalFormalParameter();
    final TerminalNode eqTerminal = context.EQ();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(normalFormalParameterContext));
    if (eqTerminal != null) {
      text.append(' ').append(this.visit(eqTerminal)).append(' ').append(this.visit(exprContext));
    }
    return text.toString();
  }

  @Override
  public String visitNamedFormalParameters(final Dart2Parser.NamedFormalParametersContext context) {
    final TerminalNode obcTerminal = context.OBC();
    final List<Dart2Parser.DefaultNamedParameterContext> defaultNamedParameterContexts =
        context.defaultNamedParameter();
    final List<TerminalNode> cTerminals = context.C();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(obcTerminal));
    this.currentIndentLevel++;
    this.appendNewLinesAndIndent(text, 1);
    final Dart2Parser.DefaultNamedParameterContext firstDefaultNamedParameterContext =
        defaultNamedParameterContexts.get(0);
    text.append(this.visit(firstDefaultNamedParameterContext));
    if (defaultNamedParameterContexts.size() > 1) {
      for (int index = 0; index < cTerminals.size(); index++) {
        final TerminalNode cTerminal = cTerminals.get(index);
        if (defaultNamedParameterContexts.size() > index + 1) {
          text.append(this.visit(cTerminal));
          this.appendNewLinesAndIndent(text, 1);
          final Dart2Parser.DefaultNamedParameterContext defaultNamedParameterContext =
              defaultNamedParameterContexts.get(index + 1);
          text.append(this.visit(defaultNamedParameterContext));
        } else {
          text.append(this.visit(cTerminal));
        }
      }
    }
    this.currentIndentLevel--;
    this.appendNewLinesAndIndent(text, 1);
    text.append(this.visit(cbcTerminal));
    return text.toString();
  }

  @Override
  public String visitDefaultNamedParameter(final Dart2Parser.DefaultNamedParameterContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final TerminalNode requiredTerminal = context.REQUIRED_();
    final Dart2Parser.NormalFormalParameterNoMetadataContext
        normalFormalParameterNoMetadataContext = context.normalFormalParameterNoMetadata();
    final TerminalNode eqTerminal = context.EQ();
    final TerminalNode coTerminal = context.CO();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDefaultNamedParameter -> metadata");
    }
    if (requiredTerminal != null) {
      text.append(this.visit(requiredTerminal)).append(' ');
    }
    text.append(this.visit(normalFormalParameterNoMetadataContext));
    if (exprContext != null) {
      text.append(' ');
      if (eqTerminal == null) {
        text.append(this.visit(coTerminal));
      } else {
        text.append(this.visit(eqTerminal));
      }
      text.append(' ').append(this.visit(exprContext));
    }
    return text.toString();
  }

  @Override
  public String visitNormalFormalParameters(
      final Dart2Parser.NormalFormalParametersContext context) {
    final List<Dart2Parser.NormalFormalParameterContext> normalFormalParameterContexts =
        context.normalFormalParameter();
    final StringBuilder text = new StringBuilder();
    final StringJoiner joiner = new StringJoiner(", ");
    for (final Dart2Parser.NormalFormalParameterContext normalFormalParameterContext :
        normalFormalParameterContexts) {
      final String normalFormalParameterText = this.visit(normalFormalParameterContext);
      joiner.add(normalFormalParameterText);
    }
    text.append(joiner);
    return text.toString();
  }

  @Override
  public String visitNormalFormalParameter(final Dart2Parser.NormalFormalParameterContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.NormalFormalParameterNoMetadataContext
        normalFormalParameterNoMetadataContext = context.normalFormalParameterNoMetadata();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNormalFormalParameter -> metadata");
    }
    final StringBuilder text = new StringBuilder();
    final String normalFormalParameterNoMetadataText =
        this.visit(normalFormalParameterNoMetadataContext);
    text.append(normalFormalParameterNoMetadataText);
    return text.toString();
  }

  @Override
  public String visitNormalFormalParameterNoMetadata(
      final Dart2Parser.NormalFormalParameterNoMetadataContext context) {
    final Dart2Parser.FunctionFormalParameterContext functionFormalParameterContext =
        context.functionFormalParameter();
    final Dart2Parser.FieldFormalParameterContext fieldFormalParameterContext =
        context.fieldFormalParameter();
    final Dart2Parser.SimpleFormalParameterContext simpleFormalParameterContext =
        context.simpleFormalParameter();
    if (functionFormalParameterContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNormalFormalParameterNoMetadata -> functionFormalParameter");
    }
    final StringBuilder text = new StringBuilder();
    if (simpleFormalParameterContext != null) {
      final String simpleFormalParameterText = this.visit(simpleFormalParameterContext);
      text.append(simpleFormalParameterText);
    }
    if (fieldFormalParameterContext != null) {
      text.append(this.visit(fieldFormalParameterContext));
    }
    return text.toString();
  }

  @Override
  public String visitFieldFormalParameter(final Dart2Parser.FieldFormalParameterContext context) {
    final Dart2Parser.FinalConstVarOrTypeContext finalConstVarOrTypeContext =
        context.finalConstVarOrType();
    final TerminalNode thisTerminal = context.THIS_();
    final TerminalNode superTerminal = context.SUPER_();
    final TerminalNode dTerminal = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.FormalParameterPartContext formalParameterPartContext =
        context.formalParameterPart();
    // todo: use `quTerminal` with tests.
    // final TerminalNode quTerminal = context.QU();
    final StringBuilder text = new StringBuilder();
    if (finalConstVarOrTypeContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFieldFormalParameter -> finalConstVarOrType");
    }
    if (thisTerminal != null) {
      text.append(this.visit(thisTerminal));
    } else if (superTerminal != null) {
      text.append(this.visit(superTerminal));
    }
    text.append(this.visit(dTerminal)).append(this.visit(identifierContext));
    if (formalParameterPartContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFieldFormalParameter -> formalParameterPart");
    }
    return text.toString();
  }

  @Override
  public String visitSimpleFormalParameter(final Dart2Parser.SimpleFormalParameterContext context) {
    final Dart2Parser.DeclaredIdentifierContext declaredIdentifierContext =
        context.declaredIdentifier();
    final TerminalNode covariantTerminal = context.COVARIANT_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    if (covariantTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimpleFormalParameter -> covariant");
    }
    final StringBuilder text = new StringBuilder();
    if (declaredIdentifierContext != null) {
      final String declaredIdentifierText = this.visit(declaredIdentifierContext);
      text.append(declaredIdentifierText);
    }
    if (identifierContext != null) {
      text.append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitDeclaredIdentifier(final Dart2Parser.DeclaredIdentifierContext context) {
    final TerminalNode covariantTerminal = context.COVARIANT_();
    final Dart2Parser.FinalConstVarOrTypeContext finalConstVarOrTypeContext =
        context.finalConstVarOrType();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (covariantTerminal != null) {
      text.append(this.visit(covariantTerminal)).append(' ');
    }
    text.append(this.visit(finalConstVarOrTypeContext))
        .append(' ')
        .append(this.visit(identifierContext));
    return text.toString();
  }

  @Override
  public String visitFinalConstVarOrType(final Dart2Parser.FinalConstVarOrTypeContext context) {
    final TerminalNode lateTerminal = context.LATE_();
    final TerminalNode finalTerminal = context.FINAL_();
    final Dart2Parser.TypeContext typeContext = context.type();
    final TerminalNode constTerminal = context.CONST_();
    final Dart2Parser.VarOrTypeContext varOrTypeContext = context.varOrType();
    final StringBuilder text = new StringBuilder();
    if (finalTerminal != null) {
      // LATE_? FINAL_ type?
      if (lateTerminal != null) {
        text.append(this.visit(lateTerminal)).append(' ');
      }
      text.append(this.visit(finalTerminal));
      if (typeContext != null) {
        text.append(' ').append(this.visit(typeContext));
      }
    } else if (constTerminal != null) {
      // CONST_ type?
      text.append(this.visit(constTerminal));
      if (typeContext != null) {
        text.append(' ').append(this.visit(typeContext));
      }
    } else if (varOrTypeContext != null) {
      // LATE_? varOrType
      if (lateTerminal != null) {
        text.append(this.visit(lateTerminal)).append(' ');
      }
      text.append(this.visit(varOrTypeContext));
    }
    return text.toString();
  }

  @Override
  public String visitFunctionBody(final Dart2Parser.FunctionBodyContext context) {
    final TerminalNode nativeTerminal = context.NATIVE_();
    final Dart2Parser.StringLiteralContext stringLiteralContext = context.stringLiteral();
    final TerminalNode scTerminal = context.SC();
    final TerminalNode asyncTerminal = context.ASYNC_();
    final TerminalNode egTerminal = context.EG();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode stTerminal = context.ST();
    final TerminalNode syncTerminal = context.SYNC_();
    final Dart2Parser.BlockContext blockContext = context.block();
    if (nativeTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionBody -> native");
    }
    if (stringLiteralContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionBody -> stringLiteral");
    }
    if (stTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionBody -> st");
    }
    final StringBuilder text = new StringBuilder();
    if (egTerminal != null) {
      if (asyncTerminal != null) {
        text.append(this.visit(asyncTerminal)).append(' ');
      }
      text.append(this.visit(egTerminal))
          .append(' ')
          .append(this.visit(exprContext))
          .append(this.visit(scTerminal));
    }
    if (blockContext != null) {
      if (asyncTerminal != null) {
        text.append(this.visit(asyncTerminal)).append(' ');
      }
      if (syncTerminal != null) {
        text.append(this.visit(syncTerminal)).append(' ');
      }
      final String blockText = this.visit(blockContext);
      text.append(blockText);
    }
    return text.toString();
  }

  @Override
  public String visitBlock(final Dart2Parser.BlockContext context) {
    final TerminalNode obcTerminal = context.OBC();
    final Dart2Parser.StatementsContext statementsContext = context.statements();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(obcTerminal));
    this.currentIndentLevel++;
    final String statementsText = this.visit(statementsContext);
    if (statementsText.isEmpty()) {
      this.currentIndentLevel--;
      text.append(this.visit(cbcTerminal));
    } else {
      this.appendNewLinesAndIndent(text, 1);
      text.append(statementsText);
      this.currentIndentLevel--;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(cbcTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitStatements(final Dart2Parser.StatementsContext context) {
    final List<Dart2Parser.StatementContext> statementContexts = context.statement();
    final StringBuilder text = new StringBuilder();
    for (int index = 0; index < statementContexts.size(); index++) {
      final Dart2Parser.StatementContext statementContext = statementContexts.get(index);
      text.append(this.visit(statementContext));
      if (index < statementContexts.size() - 1) {
        this.appendNewLinesAndIndent(text, 1);
      }
    }
    return text.toString();
  }

  @Override
  public String visitStatement(final Dart2Parser.StatementContext context) {
    final List<Dart2Parser.LabelContext> labelContexts = context.label();
    final Dart2Parser.NonLabelledStatementContext nonLabelledStatementContext =
        context.nonLabelledStatement();
    final StringBuilder text = new StringBuilder();
    for (final Dart2Parser.LabelContext labelContext : labelContexts) {
      text.append(this.visit(labelContext)).append(' ');
    }
    final String nonLabelledStatementText = this.visit(nonLabelledStatementContext);
    text.append(nonLabelledStatementText);
    return text.toString();
  }

  @Override
  public String visitNonLabelledStatement(final Dart2Parser.NonLabelledStatementContext context) {
    final Dart2Parser.BlockContext blockContext = context.block();
    final Dart2Parser.LocalVariableDeclarationContext localVariableDeclarationContext =
        context.localVariableDeclaration();
    final Dart2Parser.ForStatementContext forStatementContext = context.forStatement();
    final Dart2Parser.WhileStatementContext whileStatementContext = context.whileStatement();
    final Dart2Parser.DoStatementContext doStatementContext = context.doStatement();
    final Dart2Parser.SwitchStatementContext switchStatementContext = context.switchStatement();
    final Dart2Parser.IfStatementContext ifStatementContext = context.ifStatement();
    final Dart2Parser.RethrowStatementContext rethrowStatementContext = context.rethrowStatement();
    final Dart2Parser.TryStatementContext tryStatementContext = context.tryStatement();
    final Dart2Parser.BreakStatementContext breakStatementContext = context.breakStatement();
    final Dart2Parser.ContinueStatementContext continueStatementContext =
        context.continueStatement();
    final Dart2Parser.ReturnStatementContext returnStatementContext = context.returnStatement();
    final Dart2Parser.YieldStatementContext yieldStatementContext = context.yieldStatement();
    final Dart2Parser.YieldEachStatementContext yieldEachStatementContext =
        context.yieldEachStatement();
    final Dart2Parser.ExpressionStatementContext expressionStatementContext =
        context.expressionStatement();
    final Dart2Parser.AssertStatementContext assertStatementContext = context.assertStatement();
    final Dart2Parser.LocalFunctionDeclarationContext localFunctionDeclarationContext =
        context.localFunctionDeclaration();
    if (doStatementContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNonLabelledStatement -> doStatement");
    }
    if (continueStatementContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNonLabelledStatement -> continueStatement");
    }
    if (yieldStatementContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNonLabelledStatement -> yieldStatement");
    }
    if (yieldEachStatementContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNonLabelledStatement -> yieldEachStatement");
    }
    final StringBuilder text = new StringBuilder();
    if (blockContext != null) {
      text.append(this.visit(blockContext));
    } else if (returnStatementContext != null) {
      text.append(this.visit(returnStatementContext));
    } else if (forStatementContext != null) {
      text.append(this.visit(forStatementContext));
    } else if (expressionStatementContext != null) {
      text.append(this.visit(expressionStatementContext));
    } else if (localVariableDeclarationContext != null) {
      text.append(this.visit(localVariableDeclarationContext));
    } else if (ifStatementContext != null) {
      text.append(this.visit(ifStatementContext));
    } else if (tryStatementContext != null) {
      text.append(this.visit(tryStatementContext));
    } else if (breakStatementContext != null) {
      text.append(this.visit(breakStatementContext));
    } else if (whileStatementContext != null) {
      text.append(this.visit(whileStatementContext));
    } else if (switchStatementContext != null) {
      text.append(this.visit(switchStatementContext));
    } else if (localFunctionDeclarationContext != null) {
      text.append(this.visit(localFunctionDeclarationContext));
    } else if (rethrowStatementContext != null) {
      text.append(this.visit(rethrowStatementContext));
    } else if (assertStatementContext != null) {
      text.append(this.visit(assertStatementContext));
    }
    return text.toString();
  }

  @Override
  public String visitAssertStatement(final Dart2Parser.AssertStatementContext context) {
    final Dart2Parser.AssertionContext assertionContext = context.assertion();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(assertionContext)).append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitAssertion(final Dart2Parser.AssertionContext context) {
    final TerminalNode assertTerminal = context.ASSERT_();
    final TerminalNode opTerminal = context.OP();
    final List<Dart2Parser.ExprContext> exprContexts = context.expr();
    final List<TerminalNode> cTerminals = context.C();
    final TerminalNode cpTerminal = context.CP();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(assertTerminal)).append(this.visit(opTerminal));
    final Dart2Parser.ExprContext firstExprContext = exprContexts.get(0);
    text.append(this.visit(firstExprContext));
    for (int index = 1; index < exprContexts.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index - 1);
      final Dart2Parser.ExprContext exprContext = exprContexts.get(index);
      text.append(this.visit(cTerminal)).append(' ').append(this.visit(exprContext));
    }
    if (cTerminals.size() == exprContexts.size()) {
      final TerminalNode cTerminal = cTerminals.get(cTerminals.size() - 1);
      text.append(this.visit(cTerminal));
    }
    text.append(this.visit(cpTerminal));
    return text.toString();
  }

  @Override
  public String visitRethrowStatement(final Dart2Parser.RethrowStatementContext context) {
    final TerminalNode rethrowTerminal = context.RETHROW_();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(rethrowTerminal)).append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitBreakStatement(final Dart2Parser.BreakStatementContext context) {
    final TerminalNode breakTerminal = context.BREAK_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(breakTerminal));
    if (identifierContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBreakStatement -> identifier");
    }
    text.append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitLocalFunctionDeclaration(
      final Dart2Parser.LocalFunctionDeclarationContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.FunctionSignatureContext functionSignatureContext =
        context.functionSignature();
    final Dart2Parser.FunctionBodyContext functionBodyContext = context.functionBody();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitLocalFunctionDeclaration -> metadata");
    }
    text.append(this.visit(functionSignatureContext))
        .append(' ')
        .append(this.visit(functionBodyContext));
    return text.toString();
  }

  @Override
  public String visitTryStatement(final Dart2Parser.TryStatementContext context) {
    final TerminalNode tryTerminal = context.TRY_();
    final Dart2Parser.BlockContext blockContext = context.block();
    final List<Dart2Parser.OnPartContext> onPartContexts = context.onPart();
    final Dart2Parser.FinallyPartContext finallyPartContext = context.finallyPart();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(tryTerminal)).append(' ').append(this.visit(blockContext));
    for (final Dart2Parser.OnPartContext onPartContext : onPartContexts) {
      text.append(' ').append(this.visit(onPartContext));
    }
    if (finallyPartContext != null) {
      text.append(' ').append(this.visit(finallyPartContext));
    }
    return text.toString();
  }

  @Override
  public String visitFinallyPart(final Dart2Parser.FinallyPartContext context) {
    final TerminalNode finallyTerminal = context.FINALLY_();
    final Dart2Parser.BlockContext blockContext = context.block();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(finallyTerminal)).append(' ').append(this.visit(blockContext));
    return text.toString();
  }

  @Override
  public String visitOnPart(final Dart2Parser.OnPartContext context) {
    final Dart2Parser.CatchPartContext catchPartContext = context.catchPart();
    final Dart2Parser.BlockContext blockContext = context.block();
    final TerminalNode onTerminal = context.ON_();
    final Dart2Parser.TypeNotVoidContext typeNotVoidContext = context.typeNotVoid();
    final StringBuilder text = new StringBuilder();
    if (onTerminal == null) {
      // catchPart block
      text.append(this.visit(catchPartContext)).append(' ').append(this.visit(blockContext));
    } else {
      // ON_ typeNotVoid catchPart? block
      text.append(this.visit(onTerminal)).append(' ').append(this.visit(typeNotVoidContext));
      if (catchPartContext != null) {
        text.append(' ').append(this.visit(catchPartContext));
      }
      text.append(' ').append(this.visit(blockContext));
    }
    return text.toString();
  }

  @Override
  public String visitCatchPart(final Dart2Parser.CatchPartContext context) {
    final TerminalNode catchTerminal = context.CATCH_();
    final TerminalNode opTerminal = context.OP();
    final List<Dart2Parser.IdentifierContext> identifierContexts = context.identifier();
    final TerminalNode cTerminal = context.C();
    final TerminalNode cpTerminal = context.CP();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(catchTerminal)).append(' ').append(this.visit(opTerminal));
    final Dart2Parser.IdentifierContext firstIdentifierContext = identifierContexts.get(0);
    text.append(this.visit(firstIdentifierContext));
    if (cTerminal != null) {
      text.append(this.visit(cTerminal)).append(' ');
      final Dart2Parser.IdentifierContext secondIdentifierContext = identifierContexts.get(1);
      text.append(this.visit(secondIdentifierContext));
    }
    text.append(this.visit(cpTerminal));
    return text.toString();
  }

  @Override
  public String visitSwitchStatement(final Dart2Parser.SwitchStatementContext context) {
    final TerminalNode switchTerminal = context.SWITCH_();
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode cpTerminal = context.CP();
    final TerminalNode obcTerminal = context.OBC();
    final List<Dart2Parser.SwitchCaseContext> switchCaseContexts = context.switchCase();
    final Dart2Parser.DefaultCaseContext defaultCaseContext = context.defaultCase();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(switchTerminal))
        .append(' ')
        .append(this.visit(opTerminal))
        .append(this.visit(exprContext))
        .append(this.visit(cpTerminal))
        .append(' ')
        .append(this.visit(obcTerminal));
    this.currentIndentLevel++;
    for (final Dart2Parser.SwitchCaseContext switchCaseContext : switchCaseContexts) {
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(switchCaseContext));
    }
    if (defaultCaseContext != null) {
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(defaultCaseContext));
    }
    this.currentIndentLevel--;
    this.appendNewLinesAndIndent(text, 1);
    text.append(this.visit(cbcTerminal));
    return text.toString();
  }

  @Override
  public String visitSwitchCase(final Dart2Parser.SwitchCaseContext context) {
    final List<Dart2Parser.LabelContext> labelContexts = context.label();
    final TerminalNode caseTerminal = context.CASE_();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode coTerminal = context.CO();
    final Dart2Parser.StatementsContext statementsContext = context.statements();
    if (!labelContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSwitchCase -> label");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(caseTerminal))
        .append(' ')
        .append(this.visit(exprContext))
        .append(this.visit(coTerminal));
    this.currentIndentLevel++;
    final int visitStatementCountBefore =
        this.ruleVisitCounts.getOrDefault(Dart2Parser.StatementContext.class.getSimpleName(), 0);
    final String statementsText = this.visit(statementsContext);
    final int visitStatementCountAfter =
        this.ruleVisitCounts.getOrDefault(Dart2Parser.StatementContext.class.getSimpleName(), 0);
    if (visitStatementCountBefore < visitStatementCountAfter) {
      this.appendNewLinesAndIndent(text, 1);
      text.append(statementsText);
    }
    this.currentIndentLevel--;
    return text.toString();
  }

  @Override
  public String visitDefaultCase(final Dart2Parser.DefaultCaseContext context) {
    final List<Dart2Parser.LabelContext> labelContexts = context.label();
    final TerminalNode defaultTerminal = context.DEFAULT_();
    final TerminalNode coTerminal = context.CO();
    final Dart2Parser.StatementsContext statementsContext = context.statements();
    if (!labelContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDefaultCase -> label");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(defaultTerminal)).append(this.visit(coTerminal));
    this.currentIndentLevel++;
    this.appendNewLinesAndIndent(text, 1);
    text.append(this.visit(statementsContext));
    this.currentIndentLevel--;
    return text.toString();
  }

  @Override
  public String visitWhileStatement(final Dart2Parser.WhileStatementContext context) {
    final TerminalNode whileTerminal = context.WHILE_();
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode cpTerminal = context.CP();
    final Dart2Parser.StatementContext statementContext = context.statement();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(whileTerminal)).append(' ').append(this.visit(opTerminal));
    final String exprText = this.visit(exprContext);
    text.append(exprText).append(this.visit(cpTerminal)).append(' ');
    final String statementText = this.visit(statementContext);
    text.append(statementText);
    return text.toString();
  }

  @Override
  public String visitExpressionStatement(final Dart2Parser.ExpressionStatementContext context) {
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    if (exprContext != null) {
      final int visitUnconditionalAssignableSelectorCountBefore =
          this.ruleVisitCounts.getOrDefault(
              Dart2Parser.UnconditionalAssignableSelectorContext.class.getSimpleName(), 0);
      final int visitIdentifierCountBefore =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.IdentifierContext.class.getSimpleName(), 0);
      final int visitArgumentsCountBefore =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.ArgumentsContext.class.getSimpleName(), 0);
      final int visitCascadeCountBefore =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.CascadeContext.class.getSimpleName(), 0);
      final String exprText = this.visit(exprContext);
      final int visitUnconditionalAssignableSelectorCountAfter =
          this.ruleVisitCounts.getOrDefault(
              Dart2Parser.UnconditionalAssignableSelectorContext.class.getSimpleName(), 0);
      final int visitIdentifierCountAfter =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.IdentifierContext.class.getSimpleName(), 0);
      final int visitArgumentsCountAfter =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.ArgumentsContext.class.getSimpleName(), 0);
      final int visitCascadeCountAfter =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.CascadeContext.class.getSimpleName(), 0);
      final int visitUnconditionalAssignableSelectorCountDiff =
          visitUnconditionalAssignableSelectorCountAfter
              - visitUnconditionalAssignableSelectorCountBefore;
      final int visitIdentifierCountDiff = visitIdentifierCountAfter - visitIdentifierCountBefore;
      final int visitArgumentsCountDiff = visitArgumentsCountAfter - visitArgumentsCountBefore;
      final int visitCascadeCountDiff = visitCascadeCountAfter - visitCascadeCountBefore;
      final boolean methodChained =
          visitUnconditionalAssignableSelectorCountDiff > 1
              && visitIdentifierCountDiff > 1
              && visitArgumentsCountDiff > 1;
      final boolean bothChained =
          visitUnconditionalAssignableSelectorCountDiff > 0
              && visitIdentifierCountDiff > 0
              && visitCascadeCountDiff > 0;
      if (methodChained || visitCascadeCountDiff > 1 || bothChained) {
        this.methodChaining = true;
        text.append(this.visit(exprContext));
        this.methodChaining = false;
      } else {
        text.append(exprText);
      }
    }
    text.append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitIfStatement(final Dart2Parser.IfStatementContext context) {
    final TerminalNode ifTerminal = context.IF_();
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode cpTerminal = context.CP();
    final List<Dart2Parser.StatementContext> statementContexts = context.statement();
    final TerminalNode elseTerminal = context.ELSE_();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(ifTerminal)).append(' ').append(this.visit(opTerminal));
    final String exprText = this.visit(exprContext);
    text.append(exprText).append(this.visit(cpTerminal)).append(' ');
    final Dart2Parser.StatementContext firstStatementContext = statementContexts.get(0);
    final String firstStatementText = this.visit(firstStatementContext);
    text.append(firstStatementText);
    if (elseTerminal != null) {
      text.append(' ').append(this.visit(elseTerminal)).append(' ');
      final Dart2Parser.StatementContext secondStatementContext = statementContexts.get(1);
      final String secondStatementText = this.visit(secondStatementContext);
      text.append(secondStatementText);
    }
    return text.toString();
  }

  @Override
  public String visitForStatement(final Dart2Parser.ForStatementContext context) {
    final TerminalNode awaitTerminal = context.AWAIT_();
    final TerminalNode forTerminal = context.FOR_();
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ForLoopPartsContext forLoopPartsContext = context.forLoopParts();
    final TerminalNode cpTerminal = context.CP();
    final Dart2Parser.StatementContext statementContext = context.statement();
    if (awaitTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitForStatement -> await");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(forTerminal)).append(' ').append(this.visit(opTerminal));
    final String forLoopPartsText = this.visit(forLoopPartsContext);
    text.append(forLoopPartsText).append(this.visit(cpTerminal)).append(' ');
    final String statementText = this.visit(statementContext);
    text.append(statementText);
    return text.toString();
  }

  @Override
  public String visitForLoopParts(final Dart2Parser.ForLoopPartsContext context) {
    final Dart2Parser.ForInitializerStatementContext forInitializerStatementContext =
        context.forInitializerStatement();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode scTerminal = context.SC();
    final Dart2Parser.ExpressionListContext expressionListContext = context.expressionList();
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.DeclaredIdentifierContext declaredIdentifierContext =
        context.declaredIdentifier();
    final TerminalNode inTerminal = context.IN_();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    if (identifierContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitForLoopParts -> identifier");
    }
    final StringBuilder text = new StringBuilder();
    if (forInitializerStatementContext != null) {
      text.append(this.visit(forInitializerStatementContext)).append(' ');
      if (exprContext != null) {
        text.append(this.visit(exprContext));
      }
      text.append(this.visit(scTerminal));
      if (expressionListContext != null) {
        text.append(' ').append(this.visit(expressionListContext));
      }
    }
    if (metadataContext != null) {
      if (!metadataContext.getText().isEmpty()) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitForLoopParts -> metadata");
      }
      text.append(this.visit(declaredIdentifierContext))
          .append(' ')
          .append(this.visit(inTerminal))
          .append(' ')
          .append(this.visit(exprContext));
    }
    return text.toString();
  }

  @Override
  public String visitExpressionList(final Dart2Parser.ExpressionListContext context) {
    final List<Dart2Parser.ExprContext> exprContexts = context.expr();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.ExprContext firstExprContext = exprContexts.get(0);
    final String firstExprText = this.visit(firstExprContext);
    text.append(firstExprText);
    for (int index = 0; index < cTerminals.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index);
      final Dart2Parser.ExprContext exprContext = exprContexts.get(index + 1);
      final int visitArgumentsCountBefore =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.ArgumentsContext.class.getSimpleName(), 0);
      final String exprText = this.visit(exprContext);
      final int visitArgumentsCountAfter =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.ArgumentsContext.class.getSimpleName(), 0);
      // We assume the following condition means nested object initialization. Ex: User('Rin',
      // User('Ian'));
      if (visitArgumentsCountBefore < visitArgumentsCountAfter) {
        text.append(this.visit(cTerminal));
        this.appendNewLinesAndIndent(text, 1);
        text.append(exprText);
      } else {
        text.append(this.visit(cTerminal)).append(' ').append(exprText);
      }
    }
    return text.toString();
  }

  @Override
  public String visitForInitializerStatement(
      final Dart2Parser.ForInitializerStatementContext context) {
    final Dart2Parser.LocalVariableDeclarationContext localVariableDeclarationContext =
        context.localVariableDeclaration();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode scTerminal = context.SC();
    if (exprContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitForInitializerStatement -> expr");
    }
    if (scTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitForInitializerStatement -> sc");
    }
    final StringBuilder text = new StringBuilder();
    if (localVariableDeclarationContext != null) {
      final String localVariableDeclarationText = this.visit(localVariableDeclarationContext);
      text.append(localVariableDeclarationText);
    }
    return text.toString();
  }

  @Override
  public String visitLocalVariableDeclaration(
      final Dart2Parser.LocalVariableDeclarationContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.InitializedVariableDeclarationContext initializedVariableDeclarationContext =
        context.initializedVariableDeclaration();
    final TerminalNode scTerminal = context.SC();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitLocalVariableDeclaration -> metadata");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(initializedVariableDeclarationContext)).append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitInitializedVariableDeclaration(
      final Dart2Parser.InitializedVariableDeclarationContext context) {
    final Dart2Parser.DeclaredIdentifierContext declaredIdentifierContext =
        context.declaredIdentifier();
    final TerminalNode eqTerminal = context.EQ();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final List<TerminalNode> cTerminals = context.C();
    // todo: use `initializedIdentifierContexts` with tests.
    // final List<Dart2Parser.InitializedIdentifierContext> initializedIdentifierContexts =
    // context.initializedIdentifier();
    if (!cTerminals.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitInitializedVariableDeclaration -> c");
    }
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(declaredIdentifierContext));
    if (eqTerminal != null) {
      text.append(' ').append(this.visit(eqTerminal)).append(' ').append(this.visit(exprContext));
    }
    return text.toString();
  }

  @Override
  public String visitReturnStatement(final Dart2Parser.ReturnStatementContext context) {
    final TerminalNode returnTerminal = context.RETURN_();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode scTerminal = context.SC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(returnTerminal)).append(' ');
    if (exprContext != null) {
      final String exprText = this.visit(exprContext);
      text.append(exprText);
    }
    text.append(this.visit(scTerminal));
    return text.toString();
  }

  @Override
  public String visitDeclaration(final Dart2Parser.DeclarationContext context) {
    final TerminalNode abstractTerminal = context.ABSTRACT_();
    final TerminalNode externalTerminal = context.EXTERNAL_();
    final Dart2Parser.FactoryConstructorSignatureContext factoryConstructorSignatureContext =
        context.factoryConstructorSignature();
    final Dart2Parser.ConstantConstructorSignatureContext constantConstructorSignatureContext =
        context.constantConstructorSignature();
    final Dart2Parser.ConstructorSignatureContext constructorSignatureContext =
        context.constructorSignature();
    final TerminalNode staticTerminal = context.STATIC_();
    final Dart2Parser.GetterSignatureContext getterSignatureContext = context.getterSignature();
    final Dart2Parser.SetterSignatureContext setterSignatureContext = context.setterSignature();
    final Dart2Parser.FunctionSignatureContext functionSignatureContext =
        context.functionSignature();
    final Dart2Parser.OperatorSignatureContext operatorSignatureContext =
        context.operatorSignature();
    final TerminalNode constTerminal = context.CONST_();
    final Dart2Parser.TypeContext typeContext = context.type();
    final Dart2Parser.StaticFinalDeclarationListContext staticFinalDeclarationListContext =
        context.staticFinalDeclarationList();
    final TerminalNode finalTerminal = context.FINAL_();
    final TerminalNode lateTerminal = context.LATE_();
    final Dart2Parser.InitializedIdentifierListContext initializedIdentifierListContext =
        context.initializedIdentifierList();
    final Dart2Parser.VarOrTypeContext varOrTypeContext = context.varOrType();
    final TerminalNode covariantTerminal = context.COVARIANT_();
    final Dart2Parser.IdentifierListContext identifierListContext = context.identifierList();
    final Dart2Parser.RedirectingFactoryConstructorSignatureContext
        redirectingFactoryConstructorSignatureContext =
            context.redirectingFactoryConstructorSignature();
    final Dart2Parser.RedirectionContext redirectionContext = context.redirection();
    final Dart2Parser.InitializersContext initializersContext = context.initializers();
    final StringBuilder text = new StringBuilder();
    if (abstractTerminal != null) {
      text.append(this.visit(abstractTerminal)).append(' ');
    }
    if (externalTerminal != null && factoryConstructorSignatureContext != null) {
      // EXTERNAL_ factoryConstructorSignature
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> EXTERNAL_ factoryConstructorSignature");
    } else if (externalTerminal != null && constantConstructorSignatureContext != null) {
      // EXTERNAL_ constantConstructorSignature
      text.append(this.visit(externalTerminal))
          .append(' ')
          .append(this.visit(constantConstructorSignatureContext));
    } else if (externalTerminal != null && constructorSignatureContext != null) {
      // EXTERNAL_ constructorSignature
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> EXTERNAL_ constructorSignature");
    } else if (getterSignatureContext != null) {
      // ( EXTERNAL_ STATIC_?)? getterSignature
      if (externalTerminal != null) {
        text.append(this.visit(externalTerminal)).append(' ');
        if (staticTerminal != null) {
          text.append(this.visit(staticTerminal)).append(' ');
        }
      }
      text.append(this.visit(getterSignatureContext));
    } else if (setterSignatureContext != null) {
      // ( EXTERNAL_ STATIC_?)? setterSignature
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> ( EXTERNAL_ STATIC_?)? setterSignature");
    } else if (functionSignatureContext != null) {
      // ( EXTERNAL_ STATIC_?)? functionSignature
      if (externalTerminal != null) {
        text.append(this.visit(externalTerminal)).append(' ');
      }
      if (staticTerminal != null) {
        text.append(this.visit(staticTerminal)).append(' ');
      }
      text.append(this.visit(functionSignatureContext));
    } else if (operatorSignatureContext != null) {
      // EXTERNAL_? operatorSignature
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> EXTERNAL_? operatorSignature");
    } else if (staticTerminal != null
        && constTerminal != null
        && staticFinalDeclarationListContext != null) {
      // STATIC_ CONST_ type? staticFinalDeclarationList
      text.append(this.visit(staticTerminal))
          .append(' ')
          .append(this.visit(constTerminal))
          .append(' ');
      if (typeContext != null) {
        text.append(this.visit(typeContext)).append(' ');
      }
      text.append(this.visit(staticFinalDeclarationListContext));
    } else if (staticTerminal != null
        && finalTerminal != null
        && staticFinalDeclarationListContext != null) {
      // STATIC_ FINAL_ type? staticFinalDeclarationList
      text.append(this.visit(staticTerminal))
          .append(' ')
          .append(this.visit(finalTerminal))
          .append(' ');
      if (typeContext != null) {
        text.append(this.visit(typeContext)).append(' ');
      }
      text.append(this.visit(staticFinalDeclarationListContext));
    } else if (staticTerminal != null
        && lateTerminal != null
        && finalTerminal != null
        && initializedIdentifierListContext != null) {
      // STATIC_ LATE_ FINAL_ type? initializedIdentifierList
      text.append(this.visit(staticTerminal))
          .append(' ')
          .append(this.visit(lateTerminal))
          .append(' ')
          .append(this.visit(finalTerminal))
          .append(' ');
      if (typeContext != null) {
        text.append(this.visit(typeContext)).append(' ');
      }
      text.append(this.visit(initializedIdentifierListContext));
    } else if (staticTerminal != null
        && varOrTypeContext != null
        && initializedIdentifierListContext != null) {
      // STATIC_ LATE_? varOrType initializedIdentifierList
      text.append(this.visit(staticTerminal)).append(' ');
      if (lateTerminal != null) {
        text.append(this.visit(lateTerminal)).append(' ');
      }
      text.append(this.visit(varOrTypeContext))
          .append(' ')
          .append(this.visit(initializedIdentifierListContext));
    } else if (covariantTerminal != null
        && lateTerminal != null
        && finalTerminal != null
        && identifierListContext != null) {
      // COVARIANT_ LATE_ FINAL_ type? identifierList
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> COVARIANT_ LATE_ FINAL_ type? identifierList");
    } else if (covariantTerminal != null
        && varOrTypeContext != null
        && initializedIdentifierListContext != null) {
      // COVARIANT_ LATE_? varOrType initializedIdentifierList
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> COVARIANT_ LATE_? varOrType initializedIdentifierList");
    } else if (finalTerminal != null && initializedIdentifierListContext != null) {
      // LATE_? FINAL_ type? initializedIdentifierList
      if (lateTerminal != null) {
        text.append(this.visit(lateTerminal)).append(' ');
      }
      text.append(this.visit(finalTerminal)).append(' ');
      if (typeContext != null) {
        text.append(this.visit(typeContext)).append(' ');
      }
      text.append(this.visit(initializedIdentifierListContext));
    } else if (varOrTypeContext != null && initializedIdentifierListContext != null) {
      // LATE_? varOrType initializedIdentifierList
      if (lateTerminal != null) {
        text.append(this.visit(lateTerminal)).append(' ');
      }
      text.append(this.visit(varOrTypeContext))
          .append(' ')
          .append(this.visit(initializedIdentifierListContext));
    } else if (redirectingFactoryConstructorSignatureContext != null) {
      // redirectingFactoryConstructorSignature
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDeclaration -> redirectingFactoryConstructorSignature");
    } else if (constantConstructorSignatureContext != null) {
      // constantConstructorSignature ( redirection | initializers)?
      text.append(this.visit(constantConstructorSignatureContext));
      if (redirectionContext != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitDeclaration -> constantConstructorSignature redirection");
      } else if (initializersContext != null) {
        text.append(' ').append(this.visit(initializersContext));
      }
    } else if (constructorSignatureContext != null) {
      // constructorSignature ( redirection | initializers)?
      text.append(this.visit(constructorSignatureContext));
      if (redirectionContext != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitDeclaration -> constructorSignature redirection");
      } else if (initializersContext != null) {
        text.append(' ').append(this.visit(initializersContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitConstructorSignature(final Dart2Parser.ConstructorSignatureContext context) {
    final Dart2Parser.ConstructorNameContext constructorNameContext = context.constructorName();
    final Dart2Parser.FormalParameterListContext formalParameterListContext =
        context.formalParameterList();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(constructorNameContext)).append(this.visit(formalParameterListContext));
    return text.toString();
  }

  @Override
  public String visitInitializers(final Dart2Parser.InitializersContext context) {
    final TerminalNode coTerminal = context.CO();
    final List<Dart2Parser.InitializerListEntryContext> initializerListEntryContexts =
        context.initializerListEntry();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(coTerminal)).append(' ');
    final Dart2Parser.InitializerListEntryContext firstInitializerListEntryContext =
        initializerListEntryContexts.get(0);
    text.append(this.visit(firstInitializerListEntryContext));
    for (int index = 0; index < cTerminals.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index);
      final Dart2Parser.InitializerListEntryContext initializerListEntryContext =
          initializerListEntryContexts.get(index + 1);
      text.append(this.visit(cTerminal))
          .append(' ')
          .append(this.visit(initializerListEntryContext));
    }
    return text.toString();
  }

  @Override
  public String visitInitializerListEntry(final Dart2Parser.InitializerListEntryContext context) {
    final TerminalNode superTerminal = context.SUPER_();
    final Dart2Parser.ArgumentsContext argumentsContext = context.arguments();
    final TerminalNode dTerminal = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.FieldInitializerContext fieldInitializerContext = context.fieldInitializer();
    // todo: use `assertionContext` with tests.
    // final Dart2Parser.AssertionContext assertionContext = context.assertion();
    final StringBuilder text = new StringBuilder();
    if (dTerminal != null) {
      // SUPER_ D identifier arguments
      text.append(this.visit(superTerminal))
          .append(this.visit(dTerminal))
          .append(this.visit(identifierContext))
          .append(this.visit(argumentsContext));
    } else if (superTerminal != null) {
      // SUPER_ arguments
      text.append(this.visit(superTerminal)).append(this.visit(argumentsContext));
    } else if (fieldInitializerContext != null) {
      // fieldInitializer
      text.append(this.visit(fieldInitializerContext));
    } else {
      // assertion
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitInitializerListEntry -> assertion");
    }
    return text.toString();
  }

  @Override
  public String visitFieldInitializer(final Dart2Parser.FieldInitializerContext context) {
    final TerminalNode thisTerminal = context.THIS_();
    final TerminalNode dTerminal = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode eqTerminal = context.EQ();
    final Dart2Parser.InitializerExpressionContext initializerExpressionContext =
        context.initializerExpression();
    final StringBuilder text = new StringBuilder();
    if (thisTerminal != null) {
      text.append(this.visit(thisTerminal)).append(this.visit(dTerminal));
    }
    text.append(this.visit(identifierContext))
        .append(' ')
        .append(this.visit(eqTerminal))
        .append(' ')
        .append(this.visit(initializerExpressionContext));
    return text.toString();
  }

  @Override
  public String visitInitializerExpression(final Dart2Parser.InitializerExpressionContext context) {
    final Dart2Parser.ConditionalExpressionContext conditionalExpressionContext =
        context.conditionalExpression();
    final Dart2Parser.CascadeContext cascadeContext = context.cascade();
    final StringBuilder text = new StringBuilder();
    if (conditionalExpressionContext != null) {
      text.append(this.visit(conditionalExpressionContext));
    } else {
      text.append(this.visit(cascadeContext));
    }
    return text.toString();
  }

  @Override
  public String visitVarOrType(final Dart2Parser.VarOrTypeContext context) {
    final TerminalNode varTerminal = context.VAR_();
    final Dart2Parser.TypeContext typeContext = context.type();
    final StringBuilder text = new StringBuilder();
    if (varTerminal != null) {
      text.append(this.visit(varTerminal));
    } else if (typeContext != null) {
      text.append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitStaticFinalDeclarationList(
      final Dart2Parser.StaticFinalDeclarationListContext context) {
    final List<Dart2Parser.StaticFinalDeclarationContext> staticFinalDeclarationContexts =
        context.staticFinalDeclaration();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.StaticFinalDeclarationContext firstStaticFinalDeclarationContext =
        staticFinalDeclarationContexts.get(0);
    text.append(this.visit(firstStaticFinalDeclarationContext));
    for (int index = 0; index < cTerminals.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index);
      final Dart2Parser.StaticFinalDeclarationContext staticFinalDeclarationContext =
          staticFinalDeclarationContexts.get(index + 1);
      text.append(this.visit(cTerminal))
          .append(' ')
          .append(this.visit(staticFinalDeclarationContext));
    }
    return text.toString();
  }

  @Override
  public String visitStaticFinalDeclaration(
      final Dart2Parser.StaticFinalDeclarationContext context) {
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode eqTerminal = context.EQ();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(identifierContext))
        .append(' ')
        .append(this.visit(eqTerminal))
        .append(' ')
        .append(this.visit(exprContext));
    return text.toString();
  }

  @Override
  public String visitConstantConstructorSignature(
      final Dart2Parser.ConstantConstructorSignatureContext context) {
    final TerminalNode constTerminal = context.CONST_();
    final Dart2Parser.ConstructorNameContext constructorNameContext = context.constructorName();
    final Dart2Parser.FormalParameterListContext formalParameterListContext =
        context.formalParameterList();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(constTerminal)).append(' ').append(this.visit(constructorNameContext));
    final String formalParameterListText = this.visit(formalParameterListContext);
    text.append(formalParameterListText);
    return text.toString();
  }

  @Override
  public String visitType(final Dart2Parser.TypeContext context) {
    final Dart2Parser.FunctionTypeContext functionTypeContext = context.functionType();
    final TerminalNode quTerminal = context.QU();
    final Dart2Parser.TypeNotFunctionContext typeNotFunctionContext = context.typeNotFunction();
    final StringBuilder text = new StringBuilder();
    if (functionTypeContext != null) {
      final String functionTypeText = this.visit(functionTypeContext);
      text.append(functionTypeText);
      if (quTerminal != null) {
        text.append(this.visit(quTerminal));
      }
    } else if (typeNotFunctionContext != null) {
      final String typeNotFunctionText = this.visit(typeNotFunctionContext);
      text.append(typeNotFunctionText);
    }
    return text.toString();
  }

  @Override
  public String visitFunctionType(final Dart2Parser.FunctionTypeContext context) {
    final Dart2Parser.FunctionTypeTailsContext functionTypeTailsContext =
        context.functionTypeTails();
    final Dart2Parser.TypeNotFunctionContext typeNotFunctionContext = context.typeNotFunction();
    final StringBuilder text = new StringBuilder();
    if (typeNotFunctionContext != null) {
      final String typeNotFunctionText = this.visit(typeNotFunctionContext);
      text.append(typeNotFunctionText).append(' ');
    }
    final String functionTypeText = this.visit(functionTypeTailsContext);
    text.append(functionTypeText);
    return text.toString();
  }

  @Override
  public String visitFunctionTypeTails(final Dart2Parser.FunctionTypeTailsContext context) {
    final Dart2Parser.FunctionTypeTailContext functionTypeTailContext = context.functionTypeTail();
    final TerminalNode quTerminal = context.QU();
    final Dart2Parser.FunctionTypeTailsContext functionTypeTailsContext =
        context.functionTypeTails();
    if (quTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionTypeTails -> qu");
    }
    if (functionTypeTailsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionTypeTails -> functionTypeTails");
    }
    final StringBuilder text = new StringBuilder();
    final String functionTypeTailText = this.visit(functionTypeTailContext);
    text.append(functionTypeTailText);
    return text.toString();
  }

  @Override
  public String visitFunctionTypeTail(final Dart2Parser.FunctionTypeTailContext context) {
    final TerminalNode functionTerminal = context.FUNCTION_();
    final Dart2Parser.TypeParametersContext typeParametersContext = context.typeParameters();
    final Dart2Parser.ParameterTypeListContext parameterTypeListContext =
        context.parameterTypeList();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(functionTerminal));
    if (typeParametersContext != null) {
      text.append(this.visit(typeParametersContext));
    }
    text.append(this.visit(parameterTypeListContext));
    return text.toString();
  }

  @Override
  public String visitParameterTypeList(final Dart2Parser.ParameterTypeListContext context) {
    final TerminalNode opTerminal = context.OP();
    final TerminalNode cpTerminal = context.CP();
    final Dart2Parser.NormalParameterTypesContext normalParameterTypesContext =
        context.normalParameterTypes();
    final TerminalNode cTerminal = context.C();
    final Dart2Parser.OptionalParameterTypesContext optionalParameterTypesContext =
        context.optionalParameterTypes();
    final StringBuilder text = new StringBuilder();
    if (opTerminal != null
        && normalParameterTypesContext != null
        && cTerminal != null
        && optionalParameterTypesContext != null
        && cpTerminal != null) {
      // OP normalParameterTypes C optionalParameterTypes CP
      text.append(this.visit(opTerminal))
          .append(this.visit(normalParameterTypesContext))
          .append(this.visit(cTerminal))
          .append(' ')
          .append(this.visit(optionalParameterTypesContext))
          .append(this.visit(cpTerminal));
    } else if (opTerminal != null && normalParameterTypesContext != null && cpTerminal != null) {
      // OP normalParameterTypes C? CP
      text.append(this.visit(opTerminal)).append(this.visit(normalParameterTypesContext));
      if (cTerminal != null) {
        text.append(this.visit(cTerminal)).append(' ');
      }
      text.append(this.visit(cpTerminal));
    } else if (opTerminal != null && optionalParameterTypesContext != null && cpTerminal != null) {
      // OP optionalParameterTypes CP
      text.append(this.visit(opTerminal))
          .append(this.visit(optionalParameterTypesContext))
          .append(this.visit(cpTerminal));
    } else if (opTerminal != null && cpTerminal != null) {
      // OP CP
      text.append(this.visit(opTerminal)).append(this.visit(cpTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitOptionalParameterTypes(
      final Dart2Parser.OptionalParameterTypesContext context) {
    final Dart2Parser.OptionalPositionalParameterTypesContext optionalParameterTypesContext =
        context.optionalPositionalParameterTypes();
    final Dart2Parser.NamedParameterTypesContext namedParameterTypesContext =
        context.namedParameterTypes();
    final StringBuilder text = new StringBuilder();
    if (optionalParameterTypesContext != null) {
      text.append(this.visit(optionalParameterTypesContext));
    } else if (namedParameterTypesContext != null) {
      text.append(this.visit(namedParameterTypesContext));
    }
    return text.toString();
  }

  @Override
  public String visitNamedParameterTypes(final Dart2Parser.NamedParameterTypesContext context) {
    final TerminalNode obcTerminal = context.OBC();
    final List<Dart2Parser.NamedParameterTypeContext> namedParameterTypeContexts =
        context.namedParameterType();
    final List<TerminalNode> cTerminals = context.C();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(obcTerminal));
    this.currentIndentLevel++;
    this.appendNewLinesAndIndent(text, 1);
    final Dart2Parser.NamedParameterTypeContext firstNamedParameterTypeContext =
        namedParameterTypeContexts.get(0);
    text.append(this.visit(firstNamedParameterTypeContext));
    for (int index = 1; index < namedParameterTypeContexts.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index - 1);
      final Dart2Parser.NamedParameterTypeContext namedParameterTypeContext =
          namedParameterTypeContexts.get(index);
      text.append(this.visit(cTerminal));
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(namedParameterTypeContext));
    }
    if (cTerminals.size() == namedParameterTypeContexts.size()) {
      final TerminalNode cTerminal = cTerminals.get(cTerminals.size() - 1);
      text.append(this.visit(cTerminal));
    }
    this.currentIndentLevel--;
    this.appendNewLinesAndIndent(text, 1);
    text.append(this.visit(cbcTerminal));
    return text.toString();
  }

  @Override
  public String visitNamedParameterType(final Dart2Parser.NamedParameterTypeContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final TerminalNode requiredTerminal = context.REQUIRED_();
    final Dart2Parser.TypedIdentifierContext typedIdentifierContext = context.typedIdentifier();
    final StringBuilder text = new StringBuilder();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNamedParameterType -> metadata");
    }
    if (requiredTerminal != null) {
      text.append(this.visit(requiredTerminal)).append(' ');
    }
    text.append(this.visit(typedIdentifierContext));
    return text.toString();
  }

  @Override
  public String visitOptionalPositionalParameterTypes(
      final Dart2Parser.OptionalPositionalParameterTypesContext context) {
    final TerminalNode obTerminal = context.OB();
    final Dart2Parser.NormalParameterTypesContext normalParameterTypesContext =
        context.normalParameterTypes();
    final TerminalNode cTerminal = context.C();
    final TerminalNode cbTerminal = context.CB();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(obTerminal)).append(this.visit(normalParameterTypesContext));
    if (cTerminal != null) {
      text.append(this.visit(cTerminal));
    }
    text.append(this.visit(cbTerminal));
    return text.toString();
  }

  @Override
  public String visitNormalParameterTypes(final Dart2Parser.NormalParameterTypesContext context) {
    final List<Dart2Parser.NormalParameterTypeContext> normalParameterTypeContexts =
        context.normalParameterType();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.NormalParameterTypeContext firstNormalParameterTypeContext =
        normalParameterTypeContexts.get(0);
    text.append(this.visit(firstNormalParameterTypeContext));
    for (int index = 0; index < cTerminals.size(); index++) {
      text.append(this.visit(cTerminals.get(index)))
          .append(' ')
          .append(this.visit(normalParameterTypeContexts.get(index + 1)));
    }
    return text.toString();
  }

  @Override
  public String visitNormalParameterType(final Dart2Parser.NormalParameterTypeContext context) {
    final Dart2Parser.MetadataContext metadataContext = context.metadata();
    final Dart2Parser.TypedIdentifierContext typedIdentifierContext = context.typedIdentifier();
    final Dart2Parser.TypeContext typeContext = context.type();
    if (!metadataContext.getText().isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitNormalParameterType -> metadata");
    }
    final StringBuilder text = new StringBuilder();
    if (typedIdentifierContext != null) {
      text.append(this.visit(typedIdentifierContext));
    } else if (typeContext != null) {
      text.append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypedIdentifier(final Dart2Parser.TypedIdentifierContext context) {
    final Dart2Parser.TypeContext typeContext = context.type();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(typeContext)).append(' ').append(this.visit(identifierContext));
    return text.toString();
  }

  @Override
  public String visitTypeNotFunction(final Dart2Parser.TypeNotFunctionContext context) {
    final TerminalNode voidTerminal = context.VOID_();
    final Dart2Parser.TypeNotVoidNotFunctionContext typeNotVoidNotFunctionContext =
        context.typeNotVoidNotFunction();
    final StringBuilder text = new StringBuilder();
    if (voidTerminal != null) {
      text.append(this.visit(voidTerminal));
    }
    if (typeNotVoidNotFunctionContext != null) {
      final String typeNotVoidNotFunctionText = this.visit(typeNotVoidNotFunctionContext);
      text.append(typeNotVoidNotFunctionText);
    }
    return text.toString();
  }

  @Override
  public String visitTypeNotVoidNotFunction(
      final Dart2Parser.TypeNotVoidNotFunctionContext context) {
    final Dart2Parser.TypeNameContext typeNameContext = context.typeName();
    final Dart2Parser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final TerminalNode quTerminal = context.QU();
    final TerminalNode functionTerminal = context.FUNCTION_();
    if (functionTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTypeNotVoidNotFunction -> function");
    }
    final StringBuilder text = new StringBuilder();
    if (typeNameContext != null) {
      text.append(this.visit(typeNameContext));
    }
    if (typeArgumentsContext != null) {
      final String typeArgumentsText = this.visit(typeArgumentsContext);
      text.append(typeArgumentsText);
    }
    if (quTerminal != null) {
      text.append(this.visit(quTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitTypeName(final Dart2Parser.TypeNameContext context) {
    final List<Dart2Parser.TypeIdentifierContext> typeIdentifierContexts = context.typeIdentifier();
    final TerminalNode dTerminal = context.D();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.TypeIdentifierContext firstTypeIdentifierContext =
        typeIdentifierContexts.get(0);
    text.append(this.visit(firstTypeIdentifierContext));
    if (dTerminal != null) {
      text.append(this.visit(dTerminal));
      final Dart2Parser.TypeIdentifierContext secondTypeIdentifierContext =
          typeIdentifierContexts.get(1);
      text.append(this.visit(secondTypeIdentifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitTypeArguments(final Dart2Parser.TypeArgumentsContext context) {
    final TerminalNode ltTerminal = context.LT();
    final Dart2Parser.TypeListContext typeListContext = context.typeList();
    final TerminalNode gtTerminal = context.GT();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(ltTerminal))
        .append(this.visit(typeListContext))
        .append(this.visit(gtTerminal));
    return text.toString();
  }

  @Override
  public String visitTypeList(final Dart2Parser.TypeListContext context) {
    final List<Dart2Parser.TypeContext> typeContexts = context.type();
    final StringBuilder text = new StringBuilder();
    final String firstTypeText = this.visit(typeContexts.get(0));
    text.append(firstTypeText);
    for (int index = 1; index < typeContexts.size(); index++) {
      final Dart2Parser.TypeContext typeContext = typeContexts.get(index);
      text.append(", ").append(this.visit(typeContext));
    }
    return text.toString();
  }

  @Override
  public String visitInitializedIdentifierList(
      final Dart2Parser.InitializedIdentifierListContext context) {
    final List<Dart2Parser.InitializedIdentifierContext> initializedIdentifierContexts =
        context.initializedIdentifier();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.InitializedIdentifierContext firstInitializedIdentifierContext =
        initializedIdentifierContexts.get(0);
    text.append(this.visit(firstInitializedIdentifierContext));
    for (int index = 0; index < cTerminals.size(); index++) {
      final TerminalNode cTerminal = cTerminals.get(index);
      final Dart2Parser.InitializedIdentifierContext initializedIdentifierContext =
          initializedIdentifierContexts.get(index + 1);
      text.append(this.visit(cTerminal))
          .append(' ')
          .append(this.visit(initializedIdentifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitInitializedIdentifier(final Dart2Parser.InitializedIdentifierContext context) {
    // It can be a variable name.
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode eqTerminal = context.EQ();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(identifierContext));
    if (eqTerminal != null) {
      text.append(' ').append(this.visit(eqTerminal)).append(' ').append(this.visit(exprContext));
    }
    return text.toString();
  }

  @Override
  public String visitExpr(final Dart2Parser.ExprContext context) {
    final Dart2Parser.AssignableExpressionContext assignableExpressionContext =
        context.assignableExpression();
    final Dart2Parser.AssignmentOperatorContext assignmentOperatorContext =
        context.assignmentOperator();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final Dart2Parser.ConditionalExpressionContext conditionalExpressionContext =
        context.conditionalExpression();
    final Dart2Parser.CascadeContext cascadeContext = context.cascade();
    final Dart2Parser.ThrowExpressionContext throwExpressionContext = context.throwExpression();
    final StringBuilder text = new StringBuilder();
    if (assignableExpressionContext != null) {
      text.append(this.visit(assignableExpressionContext))
          .append(' ')
          .append(this.visit(assignmentOperatorContext))
          .append(' ')
          .append(this.visit(exprContext));
    } else if (conditionalExpressionContext != null) {
      text.append(this.visit(conditionalExpressionContext));
    } else if (cascadeContext != null) {
      text.append(this.visit(cascadeContext));
    } else if (throwExpressionContext != null) {
      text.append(this.visit(throwExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitAssignmentOperator(final Dart2Parser.AssignmentOperatorContext context) {
    final TerminalNode eqTerminal = context.EQ();
    final Dart2Parser.CompoundAssignmentOperatorContext compoundAssignmentOperatorContext =
        context.compoundAssignmentOperator();
    final StringBuilder text = new StringBuilder();
    if (eqTerminal != null) {
      text.append(this.visit(eqTerminal));
    } else {
      text.append(this.visit(compoundAssignmentOperatorContext));
    }
    return text.toString();
  }

  @Override
  // False-positive: PMD.ConfusingTernary
  @SuppressWarnings("PMD.ConfusingTernary")
  public String visitCompoundAssignmentOperator(
      final Dart2Parser.CompoundAssignmentOperatorContext context) {
    final TerminalNode steTerminal = context.STE();
    final TerminalNode seTerminal = context.SE();
    final TerminalNode sqseTerminal = context.SQSE();
    final TerminalNode peTerminal = context.PE();
    final TerminalNode pleTerminal = context.PLE();
    final TerminalNode meTerminal = context.ME();
    final TerminalNode ltlteTerminal = context.LTLTE();
    final List<TerminalNode> gtTerminals = context.GT();
    final TerminalNode eqTerminal = context.EQ();
    final TerminalNode aeTerminal = context.AE();
    final TerminalNode cireTerminal = context.CIRE();
    final TerminalNode poeTerminal = context.POE();
    final TerminalNode ququeqTerminal = context.QUQUEQ();
    final StringBuilder text = new StringBuilder();
    if (steTerminal != null) {
      text.append(this.visit(steTerminal));
    } else if (seTerminal != null) {
      text.append(this.visit(seTerminal));
    } else if (sqseTerminal != null) {
      text.append(this.visit(sqseTerminal));
    } else if (peTerminal != null) {
      text.append(this.visit(peTerminal));
    } else if (pleTerminal != null) {
      text.append(this.visit(pleTerminal));
    } else if (meTerminal != null) {
      text.append(this.visit(meTerminal));
    } else if (ltlteTerminal != null) {
      text.append(this.visit(ltlteTerminal));
    } else if (!gtTerminals.isEmpty()) {
      for (final TerminalNode gtTerminal : gtTerminals) {
        text.append(this.visit(gtTerminal));
      }
      text.append(this.visit(eqTerminal));
    } else if (aeTerminal != null) {
      text.append(this.visit(aeTerminal));
    } else if (cireTerminal != null) {
      text.append(this.visit(cireTerminal));
    } else if (poeTerminal != null) {
      text.append(this.visit(poeTerminal));
    } else if (ququeqTerminal != null) {
      text.append(this.visit(ququeqTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitAssignableExpression(final Dart2Parser.AssignableExpressionContext context) {
    final Dart2Parser.PrimaryContext primaryContext = context.primary();
    final Dart2Parser.AssignableSelectorPartContext assignableSelectorPartContext =
        context.assignableSelectorPart();
    final TerminalNode superTerminal = context.SUPER_();
    // todo: use `unconditionalAssignableSelectorContext` with tests.
    // final Dart2Parser.UnconditionalAssignableSelectorContext
    // unconditionalAssignableSelectorContext = context.unconditionalAssignableSelector();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (primaryContext != null) {
      text.append(this.visit(primaryContext)).append(this.visit(assignableSelectorPartContext));
    } else if (superTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAssignableExpression -> super");
    } else {
      text.append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitAssignableSelectorPart(
      final Dart2Parser.AssignableSelectorPartContext context) {
    final List<Dart2Parser.SelectorContext> selectorContexts = context.selector();
    final Dart2Parser.AssignableSelectorContext assignableSelectorContext =
        context.assignableSelector();
    final StringBuilder text = new StringBuilder();
    for (final Dart2Parser.SelectorContext selectorContext : selectorContexts) {
      text.append(this.visit(selectorContext));
    }
    text.append(this.visit(assignableSelectorContext));
    return text.toString();
  }

  @Override
  public String visitCascade(final Dart2Parser.CascadeContext context) {
    final Dart2Parser.CascadeContext cascadeContext = context.cascade();
    final TerminalNode ddTerminal = context.DD();
    final Dart2Parser.CascadeSectionContext cascadeSectionContext = context.cascadeSection();
    final Dart2Parser.ConditionalExpressionContext conditionalExpressionContext =
        context.conditionalExpression();
    final TerminalNode quddTerminal = context.QUDD();
    if (quddTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCascade -> qudd");
    }
    final StringBuilder text = new StringBuilder();
    if (cascadeContext != null) {
      if (this.methodChaining) {
        text.append(this.visit(cascadeContext));
        this.currentIndentLevel++;
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(ddTerminal)).append(this.visit(cascadeSectionContext));
        this.currentIndentLevel--;
      } else {
        text.append(this.visit(cascadeContext))
            .append(this.visit(ddTerminal))
            .append(this.visit(cascadeSectionContext));
      }
    } else if (conditionalExpressionContext != null) {
      if (this.methodChaining) {
        text.append(this.visit(conditionalExpressionContext));
        this.currentIndentLevel++;
        this.appendNewLinesAndIndent(text, 1);
        if (ddTerminal != null) {
          text.append(this.visit(ddTerminal));
        }
        text.append(this.visit(cascadeSectionContext));
        this.currentIndentLevel--;
      } else {
        text.append(this.visit(conditionalExpressionContext));
        if (ddTerminal != null) {
          text.append(this.visit(ddTerminal));
        }
        text.append(this.visit(cascadeSectionContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitCascadeSection(final Dart2Parser.CascadeSectionContext context) {
    final Dart2Parser.CascadeSelectorContext cascadeSelectorContext = context.cascadeSelector();
    final Dart2Parser.CascadeSectionTailContext cascadeSectionTailContext =
        context.cascadeSectionTail();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(cascadeSelectorContext)).append(this.visit(cascadeSectionTailContext));
    return text.toString();
  }

  @Override
  public String visitCascadeSelector(final Dart2Parser.CascadeSelectorContext context) {
    final TerminalNode obTerminal = context.OB();
    // todo: use `exprContext` and `cbTerminal` with tests.
    // final Dart2Parser.ExprContext exprContext = context.expr();
    // final TerminalNode cbTerminal = context.CB();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (obTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCascadeSelector -> ob");
    } else {
      text.append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitCascadeSectionTail(final Dart2Parser.CascadeSectionTailContext context) {
    final Dart2Parser.CascadeAssignmentContext cascadeAssignmentContext =
        context.cascadeAssignment();
    final List<Dart2Parser.SelectorContext> selectorContexts = context.selector();
    final Dart2Parser.AssignableSelectorContext assignableSelectorContext =
        context.assignableSelector();
    final StringBuilder text = new StringBuilder();
    if (cascadeAssignmentContext != null && assignableSelectorContext == null) {
      // cascadeAssignment
      text.append(this.visit(cascadeAssignmentContext));
    } else {
      // selector* ( assignableSelector cascadeAssignment)?
      for (final Dart2Parser.SelectorContext selectorContext : selectorContexts) {
        text.append(this.visit(selectorContext));
      }
      if (assignableSelectorContext != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitCascadeSectionTail -> assignableSelector");
      }
    }
    return text.toString();
  }

  @Override
  public String visitCascadeAssignment(final Dart2Parser.CascadeAssignmentContext context) {
    final Dart2Parser.AssignmentOperatorContext assignmentOperatorContext =
        context.assignmentOperator();
    final Dart2Parser.ExpressionWithoutCascadeContext expressionWithoutCascadeContext =
        context.expressionWithoutCascade();
    final StringBuilder text = new StringBuilder();
    text.append(' ')
        .append(this.visit(assignmentOperatorContext))
        .append(' ')
        .append(this.visit(expressionWithoutCascadeContext));
    return text.toString();
  }

  @Override
  public String visitThrowExpression(final Dart2Parser.ThrowExpressionContext context) {
    final TerminalNode throwTerminal = context.THROW_();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(throwTerminal)).append(' ').append(this.visit(exprContext));
    return text.toString();
  }

  @Override
  public String visitConditionalExpression(final Dart2Parser.ConditionalExpressionContext context) {
    final Dart2Parser.IfNullExpressionContext ifNullExpressionContext = context.ifNullExpression();
    final TerminalNode quTerminal = context.QU();
    final List<Dart2Parser.ExpressionWithoutCascadeContext> expressionWithoutCascadeContexts =
        context.expressionWithoutCascade();
    final TerminalNode coTerminal = context.CO();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(ifNullExpressionContext));
    if (quTerminal != null) {
      text.append(' ').append(this.visit(quTerminal)).append(' ');
      final Dart2Parser.ExpressionWithoutCascadeContext firstExpressionWithoutCascadeContext =
          expressionWithoutCascadeContexts.get(0);
      text.append(this.visit(firstExpressionWithoutCascadeContext))
          .append(' ')
          .append(this.visit(coTerminal))
          .append(' ');
      final Dart2Parser.ExpressionWithoutCascadeContext secondExpressionWithoutCascadeContext =
          expressionWithoutCascadeContexts.get(1);
      text.append(this.visit(secondExpressionWithoutCascadeContext));
    }
    return text.toString();
  }

  @Override
  public String visitExpressionWithoutCascade(
      final Dart2Parser.ExpressionWithoutCascadeContext context) {
    final Dart2Parser.AssignableExpressionContext assignableExpressionContext =
        context.assignableExpression();
    // todo: use `assignmentOperatorContext` and `expressionWithoutCascadeContext` with tests.
    // final Dart2Parser.AssignmentOperatorContext assignmentOperatorContext =
    // context.assignmentOperator();
    // final Dart2Parser.ExpressionWithoutCascadeContext expressionWithoutCascadeContext =
    // context.expressionWithoutCascade();
    final Dart2Parser.ConditionalExpressionContext conditionalExpressionContext =
        context.conditionalExpression();
    final Dart2Parser.ThrowExpressionWithoutCascadeContext throwExpressionWithoutCascadeContext =
        context.throwExpressionWithoutCascade();
    final StringBuilder text = new StringBuilder();
    if (assignableExpressionContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitExpressionWithoutCascade -> assignableExpression");
    } else if (conditionalExpressionContext != null) {
      text.append(this.visit(conditionalExpressionContext));
    } else if (throwExpressionWithoutCascadeContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitExpressionWithoutCascade -> throwExpressionWithoutCascade");
    }
    return text.toString();
  }

  @Override
  public String visitIfNullExpression(final Dart2Parser.IfNullExpressionContext context) {
    final List<Dart2Parser.LogicalOrExpressionContext> logicalOrExpressionContexts =
        context.logicalOrExpression();
    final List<TerminalNode> ququTerminals = context.QUQU();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.LogicalOrExpressionContext firstLogicalOrExpression =
        logicalOrExpressionContexts.get(0);
    text.append(this.visit(firstLogicalOrExpression));
    for (int index = 0; index < ququTerminals.size(); index++) {
      final TerminalNode ququTerminal = ququTerminals.get(index);
      final Dart2Parser.LogicalOrExpressionContext logicalOrExpressionContext =
          logicalOrExpressionContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(ququTerminal))
          .append(' ')
          .append(this.visit(logicalOrExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitLogicalOrExpression(final Dart2Parser.LogicalOrExpressionContext context) {
    final List<Dart2Parser.LogicalAndExpressionContext> logicalAndExpressionContexts =
        context.logicalAndExpression();
    final List<TerminalNode> ppTerminals = context.PP();
    final Dart2Parser.LogicalAndExpressionContext firstLogicalAndExpressionContext =
        logicalAndExpressionContexts.get(0);
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(firstLogicalAndExpressionContext));
    for (int index = 0; index < ppTerminals.size(); index++) {
      final TerminalNode ppTerminal = ppTerminals.get(index);
      final Dart2Parser.LogicalAndExpressionContext logicalAndExpressionContext =
          logicalAndExpressionContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(ppTerminal))
          .append(' ')
          .append(this.visit(logicalAndExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitLogicalAndExpression(final Dart2Parser.LogicalAndExpressionContext context) {
    final List<Dart2Parser.EqualityExpressionContext> equalityExpressionContexts =
        context.equalityExpression();
    final List<TerminalNode> aaTerminals = context.AA();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.EqualityExpressionContext firstEqualityExpressionContext =
        equalityExpressionContexts.get(0);
    text.append(this.visit(firstEqualityExpressionContext));
    for (int index = 0; index < aaTerminals.size(); index++) {
      final TerminalNode aaTerminal = aaTerminals.get(index);
      final Dart2Parser.EqualityExpressionContext equalityExpressionContext =
          equalityExpressionContexts.get(index + 1);
      text.append(' ')
          .append(this.visit(aaTerminal))
          .append(' ')
          .append(this.visit(equalityExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitEqualityExpression(final Dart2Parser.EqualityExpressionContext context) {
    final List<Dart2Parser.RelationalExpressionContext> relationalExpressionContexts =
        context.relationalExpression();
    final Dart2Parser.EqualityOperatorContext equalityOperatorContext = context.equalityOperator();
    final TerminalNode superTerminal = context.SUPER_();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.RelationalExpressionContext firstRelationalExpressionContext =
        relationalExpressionContexts.get(0);
    final String firstRelationalExpressionText = this.visit(firstRelationalExpressionContext);
    if (superTerminal == null) {
      text.append(firstRelationalExpressionText);
      if (equalityOperatorContext != null) {
        text.append(' ').append(this.visit(equalityOperatorContext)).append(' ');
        final Dart2Parser.RelationalExpressionContext secondRelationalExpressionContext =
            relationalExpressionContexts.get(1);
        text.append(this.visit(secondRelationalExpressionContext));
      }
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitEqualityExpression -> super");
    }
    return text.toString();
  }

  @Override
  public String visitEqualityOperator(final Dart2Parser.EqualityOperatorContext context) {
    final TerminalNode eeTerminal = context.EE();
    final TerminalNode neTerminal = context.NE();
    final StringBuilder text = new StringBuilder();
    if (eeTerminal != null) {
      text.append(this.visit(eeTerminal));
    } else {
      text.append(this.visit(neTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitRelationalExpression(final Dart2Parser.RelationalExpressionContext context) {
    final List<Dart2Parser.BitwiseOrExpressionContext> bitwiseOrExpressionContexts =
        context.bitwiseOrExpression();
    final Dart2Parser.TypeTestContext typeTestContext = context.typeTest();
    final Dart2Parser.TypeCastContext typeCastContext = context.typeCast();
    final Dart2Parser.RelationalOperatorContext relationalOperatorContext =
        context.relationalOperator();
    final TerminalNode superTerminal = context.SUPER_();
    final StringBuilder text = new StringBuilder();
    if (superTerminal == null) {
      // bitwiseOrExpression (typeTest | typeCast | relationalOperator bitwiseOrExpression)?
      final Dart2Parser.BitwiseOrExpressionContext firstBitwiseOrExpression =
          bitwiseOrExpressionContexts.get(0);
      text.append(this.visit(firstBitwiseOrExpression));
      if (typeTestContext != null) {
        text.append(' ').append(this.visit(typeTestContext));
      } else if (typeCastContext != null) {
        text.append(' ').append(this.visit(typeCastContext));
      } else if (relationalOperatorContext != null) {
        text.append(' ').append(this.visit(relationalOperatorContext)).append(' ');
        final Dart2Parser.BitwiseOrExpressionContext secondBitwiseOrExpression =
            bitwiseOrExpressionContexts.get(1);
        text.append(this.visit(secondBitwiseOrExpression));
      }
    } else {
      // SUPER_ relationalOperator bitwiseOrExpression
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitRelationalExpression -> super");
    }
    return text.toString();
  }

  @Override
  public String visitTypeCast(final Dart2Parser.TypeCastContext context) {
    final Dart2Parser.AsOperatorContext asOperatorContext = context.asOperator();
    final Dart2Parser.TypeNotVoidContext typeNotVoidContext = context.typeNotVoid();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(asOperatorContext)).append(' ').append(this.visit(typeNotVoidContext));
    return text.toString();
  }

  @Override
  public String visitAsOperator(final Dart2Parser.AsOperatorContext context) {
    return this.visit(context.AS_());
  }

  @Override
  public String visitTypeTest(final Dart2Parser.TypeTestContext context) {
    final Dart2Parser.IsOperatorContext isOperatorContext = context.isOperator();
    final Dart2Parser.TypeNotVoidContext typeNotVoidContext = context.typeNotVoid();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(isOperatorContext)).append(' ').append(this.visit(typeNotVoidContext));
    return text.toString();
  }

  @Override
  public String visitIsOperator(final Dart2Parser.IsOperatorContext context) {
    final TerminalNode isTerminal = context.IS_();
    final TerminalNode notTerminal = context.NOT();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(isTerminal));
    if (notTerminal != null) {
      text.append(' ').append(this.visit(notTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitRelationalOperator(final Dart2Parser.RelationalOperatorContext context) {
    final TerminalNode gtTerminal = context.GT();
    final TerminalNode eqTerminal = context.EQ();
    final TerminalNode lteTerminal = context.LTE();
    final TerminalNode ltTerminal = context.LT();
    final StringBuilder text = new StringBuilder();
    if (eqTerminal != null) {
      text.append(this.visit(gtTerminal)).append(this.visit(eqTerminal));
    } else if (gtTerminal != null) {
      text.append(this.visit(gtTerminal));
    } else if (lteTerminal != null) {
      text.append(this.visit(lteTerminal));
    } else {
      text.append(this.visit(ltTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitBitwiseOrExpression(final Dart2Parser.BitwiseOrExpressionContext context) {
    final List<Dart2Parser.BitwiseXorExpressionContext> bitwiseXorExpressionContexts =
        context.bitwiseXorExpression();
    final List<TerminalNode> pTerminals = context.P();
    final TerminalNode superTerminal = context.SUPER_();
    if (!pTerminals.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwiseOrExpression -> p");
    }
    if (superTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwiseOrExpression -> super");
    }
    final StringBuilder text = new StringBuilder();
    for (final Dart2Parser.BitwiseXorExpressionContext bitwiseXorExpression :
        bitwiseXorExpressionContexts) {
      final String bitwiseXorExpressionText = this.visit(bitwiseXorExpression);
      text.append(bitwiseXorExpressionText);
    }
    return text.toString();
  }

  @Override
  public String visitBitwiseXorExpression(final Dart2Parser.BitwiseXorExpressionContext context) {
    final List<Dart2Parser.BitwiseAndExpressionContext> bitwiseAndExpressionContexts =
        context.bitwiseAndExpression();
    final List<TerminalNode> cirTerminals = context.CIR();
    final TerminalNode superTerminal = context.SUPER_();
    if (!cirTerminals.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwiseXorExpression -> cir");
    }
    if (superTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwiseXorExpression -> super");
    }
    final StringBuilder text = new StringBuilder();
    for (final Dart2Parser.BitwiseAndExpressionContext bitwiseAndExpression :
        bitwiseAndExpressionContexts) {
      final String bitwiseAndExpressionText = this.visit(bitwiseAndExpression);
      text.append(bitwiseAndExpressionText);
    }
    return text.toString();
  }

  @Override
  public String visitBitwiseAndExpression(final Dart2Parser.BitwiseAndExpressionContext context) {
    final List<Dart2Parser.ShiftExpressionContext> shiftExpressionContexts =
        context.shiftExpression();
    final List<TerminalNode> aTerminals = context.A();
    final TerminalNode superTerminal = context.SUPER_();
    final StringBuilder text = new StringBuilder();
    if (superTerminal == null) {
      // shiftExpression (A shiftExpression)*
      final Dart2Parser.ShiftExpressionContext firstShiftExpressionContext =
          shiftExpressionContexts.get(0);
      text.append(this.visit(firstShiftExpressionContext));
      for (int index = 0; index < aTerminals.size(); index++) {
        final TerminalNode aTerminal = aTerminals.get(index);
        final Dart2Parser.ShiftExpressionContext shiftExpressionContext =
            shiftExpressionContexts.get(index + 1);
        text.append(' ')
            .append(this.visit(aTerminal))
            .append(' ')
            .append(this.visit(shiftExpressionContext));
      }
    } else {
      // SUPER_ ( A shiftExpression)+
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwiseAndExpression -> SUPER_ ( A shiftExpression)+");
    }
    return text.toString();
  }

  @Override
  public String visitShiftExpression(final Dart2Parser.ShiftExpressionContext context) {
    final List<Dart2Parser.AdditiveExpressionContext> additiveExpressionContexts =
        context.additiveExpression();
    final List<Dart2Parser.ShiftOperatorContext> shiftOperatorContexts = context.shiftOperator();
    final TerminalNode superTerminal = context.SUPER_();
    if (!shiftOperatorContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitShiftExpression -> shiftOperator");
    }
    if (superTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitShiftExpression -> super");
    }
    final StringBuilder text = new StringBuilder();
    for (final Dart2Parser.AdditiveExpressionContext additiveExpression :
        additiveExpressionContexts) {
      final String additiveExpressionText = this.visit(additiveExpression);
      text.append(additiveExpressionText);
    }
    return text.toString();
  }

  @Override
  public String visitAdditiveExpression(final Dart2Parser.AdditiveExpressionContext context) {
    final List<Dart2Parser.MultiplicativeExpressionContext> multiplicativeExpressionContexts =
        context.multiplicativeExpression();
    final List<Dart2Parser.AdditiveOperatorContext> additiveOperatorContexts =
        context.additiveOperator();
    final TerminalNode superTerminal = context.SUPER_();
    if (superTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAdditiveExpression -> super");
    }
    final StringBuilder text = new StringBuilder();
    for (int index = 0; index < multiplicativeExpressionContexts.size(); index++) {
      final Dart2Parser.MultiplicativeExpressionContext multiplicativeExpression =
          multiplicativeExpressionContexts.get(index);
      final String multiplicativeExpressionText = this.visit(multiplicativeExpression);
      text.append(multiplicativeExpressionText);
      if (index < additiveOperatorContexts.size()) {
        final Dart2Parser.AdditiveOperatorContext additiveOperatorContext =
            additiveOperatorContexts.get(index);
        text.append(' ').append(this.visit(additiveOperatorContext)).append(' ');
      }
    }
    return text.toString();
  }

  @Override
  public String visitAdditiveOperator(final Dart2Parser.AdditiveOperatorContext context) {
    final TerminalNode plTerminal = context.PL();
    final TerminalNode minusTerminal = context.MINUS();
    final StringBuilder text = new StringBuilder();
    if (plTerminal != null) {
      text.append(this.visit(plTerminal));
    } else {
      text.append(this.visit(minusTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitMultiplicativeExpression(
      final Dart2Parser.MultiplicativeExpressionContext context) {
    final List<Dart2Parser.UnaryExpressionContext> unaryExpressionContexts =
        context.unaryExpression();
    final List<Dart2Parser.MultiplicativeOperatorContext> multiplicativeOperatorContexts =
        context.multiplicativeOperator();
    final TerminalNode superTerminal = context.SUPER_();
    final StringBuilder text = new StringBuilder();
    if (superTerminal == null) {
      final Dart2Parser.UnaryExpressionContext firstUnaryExpression =
          unaryExpressionContexts.get(0);
      final String firstUnaryExpressionText = this.visit(firstUnaryExpression);
      text.append(firstUnaryExpressionText);
      for (int index = 0; index < multiplicativeOperatorContexts.size(); index++) {
        text.append(' ');
        final Dart2Parser.MultiplicativeOperatorContext multiplicativeOperatorContext =
            multiplicativeOperatorContexts.get(index);
        text.append(this.visit(multiplicativeOperatorContext)).append(' ');
        final Dart2Parser.UnaryExpressionContext unaryExpressionContext =
            unaryExpressionContexts.get(index + 1);
        text.append(this.visit(unaryExpressionContext));
      }
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitMultiplicativeExpression -> super");
    }
    return text.toString();
  }

  @Override
  public String visitMultiplicativeOperator(
      final Dart2Parser.MultiplicativeOperatorContext context) {
    final TerminalNode stTerminal = context.ST();
    final TerminalNode slTerminal = context.SL();
    final TerminalNode pcTerminal = context.PC();
    final TerminalNode sqsTerminal = context.SQS();
    final StringBuilder text = new StringBuilder();
    if (stTerminal != null) {
      text.append(this.visit(stTerminal));
    } else if (slTerminal != null) {
      text.append(this.visit(slTerminal));
    } else if (pcTerminal != null) {
      text.append(this.visit(pcTerminal));
    } else {
      text.append(this.visit(sqsTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitUnaryExpression(final Dart2Parser.UnaryExpressionContext context) {
    final Dart2Parser.PrefixOperatorContext prefixOperatorContext = context.prefixOperator();
    final Dart2Parser.UnaryExpressionContext unaryExpressionContext = context.unaryExpression();
    final Dart2Parser.AwaitExpressionContext awaitExpressionContext = context.awaitExpression();
    final Dart2Parser.PostfixExpressionContext postfixExpressionContext =
        context.postfixExpression();
    // todo: use `minusOperatorContext` and `tildeOperatorContext` with tests.
    // final Dart2Parser.MinusOperatorContext minusOperatorContext = context.minusOperator();
    // final Dart2Parser.TildeOperatorContext tildeOperatorContext = context.tildeOperator();
    final TerminalNode superTerminal = context.SUPER_();
    final Dart2Parser.IncrementOperatorContext incrementOperatorContext =
        context.incrementOperator();
    final Dart2Parser.AssignableExpressionContext assignableExpressionContext =
        context.assignableExpression();
    final StringBuilder text = new StringBuilder();
    if (prefixOperatorContext != null) {
      // prefixOperator unaryExpression
      text.append(this.visit(prefixOperatorContext)).append(this.visit(unaryExpressionContext));
    } else if (awaitExpressionContext != null) {
      text.append(this.visit(awaitExpressionContext));
    } else if (postfixExpressionContext != null) {
      text.append(this.visit(postfixExpressionContext));
    } else if (superTerminal != null) {
      // ( minusOperator | tildeOperator) SUPER_
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitUnaryExpression -> ( minusOperator | tildeOperator) SUPER_");
    } else if (incrementOperatorContext != null) {
      // incrementOperator assignableExpression
      text.append(this.visit(incrementOperatorContext))
          .append(this.visit(assignableExpressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitPrefixOperator(final Dart2Parser.PrefixOperatorContext context) {
    final Dart2Parser.MinusOperatorContext minusOperatorContext = context.minusOperator();
    final Dart2Parser.NegationOperatorContext negationOperatorContext = context.negationOperator();
    final Dart2Parser.TildeOperatorContext tildeOperatorContext = context.tildeOperator();
    final StringBuilder text = new StringBuilder();
    if (minusOperatorContext != null) {
      text.append(this.visit(minusOperatorContext));
    } else if (negationOperatorContext != null) {
      text.append(this.visit(negationOperatorContext));
    } else {
      text.append(this.visit(tildeOperatorContext));
    }
    return text.toString();
  }

  @Override
  public String visitMinusOperator(final Dart2Parser.MinusOperatorContext context) {
    final TerminalNode minusTerminal = context.MINUS();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(minusTerminal));
    return text.toString();
  }

  @Override
  public String visitNegationOperator(final Dart2Parser.NegationOperatorContext context) {
    final TerminalNode notTerminal = context.NOT();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(notTerminal));
    return text.toString();
  }

  @Override
  public String visitTildeOperator(final Dart2Parser.TildeOperatorContext context) {
    final TerminalNode sqigTerminal = context.SQUIG();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(sqigTerminal));
    return text.toString();
  }

  @Override
  public String visitAwaitExpression(final Dart2Parser.AwaitExpressionContext context) {
    final TerminalNode awaitTerminal = context.AWAIT_();
    final Dart2Parser.UnaryExpressionContext unaryExpressionContext = context.unaryExpression();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(awaitTerminal)).append(' ').append(this.visit(unaryExpressionContext));
    return text.toString();
  }

  @Override
  public String visitPostfixExpression(final Dart2Parser.PostfixExpressionContext context) {
    final Dart2Parser.AssignableExpressionContext assignableExpressionContext =
        context.assignableExpression();
    final Dart2Parser.PostfixOperatorContext postfixOperatorContext = context.postfixOperator();
    final Dart2Parser.PrimaryContext primaryContext = context.primary();
    final List<Dart2Parser.SelectorContext> selectorContexts = context.selector();
    final StringBuilder text = new StringBuilder();
    if (assignableExpressionContext != null) {
      text.append(this.visit(assignableExpressionContext))
          .append(this.visit(postfixOperatorContext));
    }
    if (primaryContext != null) {
      text.append(this.visit(primaryContext));
    }
    for (final Dart2Parser.SelectorContext selectorContext : selectorContexts) {
      text.append(this.visit(selectorContext));
    }
    return text.toString();
  }

  @Override
  public String visitPostfixOperator(final Dart2Parser.PostfixOperatorContext context) {
    final Dart2Parser.IncrementOperatorContext incrementOperatorContext =
        context.incrementOperator();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(incrementOperatorContext));
    return text.toString();
  }

  @Override
  public String visitIncrementOperator(final Dart2Parser.IncrementOperatorContext context) {
    final TerminalNode plplTerminal = context.PLPL();
    final TerminalNode mmTerminal = context.MM();
    final StringBuilder text = new StringBuilder();
    if (plplTerminal != null) {
      text.append(this.visit(plplTerminal));
    } else {
      text.append(this.visit(mmTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitSelector(final Dart2Parser.SelectorContext context) {
    final TerminalNode notTerminal = context.NOT();
    final Dart2Parser.AssignableSelectorContext assignableSelectorContext =
        context.assignableSelector();
    final Dart2Parser.ArgumentPartContext argumentPartContext = context.argumentPart();
    final StringBuilder text = new StringBuilder();
    if (notTerminal != null) {
      text.append(this.visit(notTerminal));
    } else if (assignableSelectorContext != null) {
      text.append(this.visit(assignableSelectorContext));
    } else {
      final String argumentPartText = this.visit(argumentPartContext);
      text.append(argumentPartText);
    }
    return text.toString();
  }

  @Override
  public String visitAssignableSelector(final Dart2Parser.AssignableSelectorContext context) {
    final Dart2Parser.UnconditionalAssignableSelectorContext
        unconditionalAssignableSelectorContext = context.unconditionalAssignableSelector();
    final TerminalNode qudTerminal = context.QUD();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode quTerminal = context.QU();
    final TerminalNode obTerminal = context.OB();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode cbTerminal = context.CB();
    final StringBuilder text = new StringBuilder();
    if (unconditionalAssignableSelectorContext != null) {
      // unconditionalAssignableSelector
      text.append(this.visit(unconditionalAssignableSelectorContext));
    } else if (qudTerminal != null) {
      // QUD identifier
      text.append(this.visit(qudTerminal)).append(this.visit(identifierContext));
    } else {
      // QU OB expr CB
      text.append(this.visit(quTerminal))
          .append(this.visit(obTerminal))
          .append(this.visit(exprContext))
          .append(this.visit(cbTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitUnconditionalAssignableSelector(
      final Dart2Parser.UnconditionalAssignableSelectorContext context) {
    final TerminalNode obTerminal = context.OB();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode cbTerminal = context.CB();
    final TerminalNode dTerminal = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (obTerminal != null) {
      // OB expr CB
      text.append(this.visit(obTerminal))
          .append(this.visit(exprContext))
          .append(this.visit(cbTerminal));
    } else {
      // D identifier
      if (this.methodChaining) {
        this.currentIndentLevel++;
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(dTerminal)).append(this.visit(identifierContext));
        this.currentIndentLevel--;
      } else {
        text.append(this.visit(dTerminal)).append(this.visit(identifierContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitArgumentPart(final Dart2Parser.ArgumentPartContext context) {
    final Dart2Parser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final Dart2Parser.ArgumentsContext argumentsContext = context.arguments();
    final StringBuilder text = new StringBuilder();
    if (typeArgumentsContext != null) {
      text.append(this.visit(typeArgumentsContext));
    }
    if (argumentsContext != null) {
      final String argumentsText = this.visit(argumentsContext);
      text.append(argumentsText);
    }
    return text.toString();
  }

  @Override
  public String visitPrimary(final Dart2Parser.PrimaryContext context) {
    final Dart2Parser.ThisExpressionContext thisExpressionContext = context.thisExpression();
    final TerminalNode superTerminal = context.SUPER_();
    final Dart2Parser.UnconditionalAssignableSelectorContext
        unconditionalAssignableSelectorContext = context.unconditionalAssignableSelector();
    final Dart2Parser.ArgumentPartContext argumentPartContext = context.argumentPart();
    final Dart2Parser.FunctionExpressionContext functionExpressionContext =
        context.functionExpression();
    final Dart2Parser.LiteralContext literalContext = context.literal();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.NewExpressionContext newExpressionContext = context.newExpression();
    final Dart2Parser.ConstObjectExpressionContext constObjectExpressionContext =
        context.constObjectExpression();
    final Dart2Parser.ConstructorInvocationContext constructorInvocationContext =
        context.constructorInvocation();
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode cpTerminal = context.CP();
    final StringBuilder text = new StringBuilder();
    if (thisExpressionContext != null) {
      text.append(this.visit(thisExpressionContext));
    } else if (unconditionalAssignableSelectorContext != null) {
      text.append(this.visit(superTerminal))
          .append(this.visit(unconditionalAssignableSelectorContext));
    } else if (argumentPartContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitPrimary -> argumentPart");
    } else if (functionExpressionContext != null) {
      text.append(this.visit(functionExpressionContext));
    } else if (literalContext != null) {
      text.append(this.visit(literalContext));
    } else if (identifierContext != null) {
      text.append(this.visit(identifierContext));
    } else if (newExpressionContext != null) {
      text.append(this.visit(newExpressionContext));
    } else if (constObjectExpressionContext != null) {
      text.append(this.visit(constObjectExpressionContext));
    } else if (constructorInvocationContext != null) {
      text.append(this.visit(constructorInvocationContext));
    } else if (opTerminal != null) {
      text.append(this.visit(opTerminal))
          .append(this.visit(exprContext))
          .append(this.visit(cpTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitConstructorInvocation(final Dart2Parser.ConstructorInvocationContext context) {
    final Dart2Parser.TypeNameContext typeNameContext = context.typeName();
    final Dart2Parser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final TerminalNode dTerminal = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final Dart2Parser.ArgumentsContext argumentsContext = context.arguments();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(typeNameContext))
        .append(this.visit(typeArgumentsContext))
        .append(this.visit(dTerminal))
        .append(this.visit(identifierContext))
        .append(this.visit(argumentsContext));
    return text.toString();
  }

  @Override
  public String visitThisExpression(final Dart2Parser.ThisExpressionContext context) {
    final TerminalNode thisTerminal = context.THIS_();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(thisTerminal));
    return text.toString();
  }

  @Override
  public String visitConstObjectExpression(final Dart2Parser.ConstObjectExpressionContext context) {
    final TerminalNode constTerminal = context.CONST_();
    final Dart2Parser.ConstructorDesignationContext constructorDesignationContext =
        context.constructorDesignation();
    final Dart2Parser.ArgumentsContext argumentsContext = context.arguments();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(constTerminal))
        .append(' ')
        .append(this.visit(constructorDesignationContext))
        .append(this.visit(argumentsContext));
    return text.toString();
  }

  @Override
  public String visitConstructorDesignation(
      final Dart2Parser.ConstructorDesignationContext context) {
    final Dart2Parser.TypeIdentifierContext typeIdentifierContext = context.typeIdentifier();
    final Dart2Parser.QualifiedNameContext qualifiedNameContext = context.qualifiedName();
    final Dart2Parser.TypeNameContext typeNameContext = context.typeName();
    final Dart2Parser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final TerminalNode dTerminal = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (typeIdentifierContext != null) {
      text.append(this.visit(typeIdentifierContext));
    } else if (qualifiedNameContext != null) {
      text.append(this.visit(qualifiedNameContext));
    } else {
      // typeName typeArguments ( D identifier)?
      text.append(this.visit(typeNameContext)).append(this.visit(typeArgumentsContext));
      if (dTerminal != null) {
        text.append(this.visit(dTerminal)).append(this.visit(identifierContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitQualifiedName(final Dart2Parser.QualifiedNameContext context) {
    final List<Dart2Parser.TypeIdentifierContext> typeIdentifierContexts = context.typeIdentifier();
    final List<TerminalNode> dTerminals = context.D();
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final StringBuilder text = new StringBuilder();
    if (typeIdentifierContexts.size() == 1) {
      // typeIdentifier D identifier
      final Dart2Parser.TypeIdentifierContext typeIdentifierContext = typeIdentifierContexts.get(0);
      final TerminalNode dTerminal = dTerminals.get(0);
      text.append(this.visit(typeIdentifierContext))
          .append(this.visit(dTerminal))
          .append(this.visit(identifierContext));
    } else {
      // typeIdentifier D typeIdentifier D identifier
      final Dart2Parser.TypeIdentifierContext firstTypeIdentifierContext =
          typeIdentifierContexts.get(0);
      final TerminalNode firstDTerminal = dTerminals.get(0);
      final Dart2Parser.TypeIdentifierContext secondTypeIdentifierContext =
          typeIdentifierContexts.get(1);
      final TerminalNode secondDTerminal = dTerminals.get(1);
      text.append(this.visit(firstTypeIdentifierContext))
          .append(this.visit(firstDTerminal))
          .append(this.visit(secondTypeIdentifierContext))
          .append(this.visit(secondDTerminal))
          .append(this.visit(identifierContext));
    }
    return text.toString();
  }

  @Override
  public String visitFunctionExpression(final Dart2Parser.FunctionExpressionContext context) {
    final Dart2Parser.FormalParameterPartContext formalParameterPartContext =
        context.formalParameterPart();
    final Dart2Parser.FunctionExpressionBodyContext functionExpressionBodyContext =
        context.functionExpressionBody();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(formalParameterPartContext))
        .append(' ')
        .append(this.visit(functionExpressionBodyContext));
    return text.toString();
  }

  @Override
  public String visitFunctionExpressionBody(
      final Dart2Parser.FunctionExpressionBodyContext context) {
    final TerminalNode asyncTerminal = context.ASYNC_();
    final TerminalNode egTerminal = context.EG();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode stTerminal = context.ST();
    final TerminalNode syncTerminal = context.SYNC_();
    final Dart2Parser.BlockContext blockContext = context.block();
    if (stTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunctionExpressionBody -> st");
    }
    final StringBuilder text = new StringBuilder();
    if (egTerminal != null) {
      // ASYNC_? EG expr
      if (asyncTerminal != null) {
        text.append(this.visit(asyncTerminal)).append(' ');
      }
      text.append(this.visit(egTerminal)).append(' ').append(this.visit(exprContext));
    } else if (blockContext != null) {
      // ( ASYNC_ ST? | SYNC_ ST)? block
      if (asyncTerminal != null) {
        text.append(this.visit(asyncTerminal)).append(' ');
      } else if (syncTerminal != null) {
        text.append(this.visit(syncTerminal)).append(' ');
      }
      text.append(this.visit(blockContext));
    }
    return text.toString();
  }

  @Override
  public String visitIdentifier(final Dart2Parser.IdentifierContext context) {
    final TerminalNode identifierTerminal = context.IDENTIFIER();
    final TerminalNode abstractTerminal = context.ABSTRACT_();
    final TerminalNode asTerminal = context.AS_();
    final TerminalNode covariantTerminal = context.COVARIANT_();
    final TerminalNode deferredTerminal = context.DEFERRED_();
    final TerminalNode dynamicTerminal = context.DYNAMIC_();
    final TerminalNode exportTerminal = context.EXPORT_();
    final TerminalNode externalTerminal = context.EXTERNAL_();
    final TerminalNode extensionTerminal = context.EXTENSION_();
    final TerminalNode factoryTerminal = context.FACTORY_();
    final TerminalNode functionTerminal = context.FUNCTION_();
    final TerminalNode getTerminal = context.GET_();
    final TerminalNode implementsTerminal = context.IMPLEMENTS_();
    final TerminalNode importTerminal = context.IMPORT_();
    final TerminalNode interfaceTerminal = context.INTERFACE_();
    final TerminalNode lateTerminal = context.LATE_();
    final TerminalNode libraryTerminal = context.LIBRARY_();
    final TerminalNode mixinTerminal = context.MIXIN_();
    final TerminalNode operatorTerminal = context.OPERATOR_();
    final TerminalNode partTerminal = context.PART_();
    final TerminalNode requiredTerminal = context.REQUIRED_();
    final TerminalNode setTerminal = context.SET_();
    final TerminalNode staticTerminal = context.STATIC_();
    final TerminalNode typedefTerminal = context.TYPEDEF_();
    final TerminalNode asyncTerminal = context.ASYNC_();
    final TerminalNode hideTerminal = context.HIDE_();
    final TerminalNode ofTerminal = context.OF_();
    final TerminalNode onTerminal = context.ON_();
    final TerminalNode showTerminal = context.SHOW_();
    final TerminalNode syncTerminal = context.SYNC_();
    final TerminalNode awaitTerminal = context.AWAIT_();
    final TerminalNode yieldTerminal = context.YIELD_();
    final TerminalNode nativeTerminal = context.NATIVE_();
    final StringBuilder text = new StringBuilder();
    if (identifierTerminal != null) {
      text.append(this.visit(identifierTerminal));
    } else if (abstractTerminal != null) {
      text.append(this.visit(abstractTerminal));
    } else if (asTerminal != null) {
      text.append(this.visit(asTerminal));
    } else if (covariantTerminal != null) {
      text.append(this.visit(covariantTerminal));
    } else if (deferredTerminal != null) {
      text.append(this.visit(deferredTerminal));
    } else if (dynamicTerminal != null) {
      text.append(this.visit(dynamicTerminal));
    } else if (exportTerminal != null) {
      text.append(this.visit(exportTerminal));
    } else if (externalTerminal != null) {
      text.append(this.visit(externalTerminal));
    } else if (extensionTerminal != null) {
      text.append(this.visit(extensionTerminal));
    } else if (factoryTerminal != null) {
      text.append(this.visit(factoryTerminal));
    } else if (functionTerminal != null) {
      text.append(this.visit(functionTerminal));
    } else if (getTerminal != null) {
      text.append(this.visit(getTerminal));
    } else if (implementsTerminal != null) {
      text.append(this.visit(implementsTerminal));
    } else if (importTerminal != null) {
      text.append(this.visit(importTerminal));
    } else if (interfaceTerminal != null) {
      text.append(this.visit(interfaceTerminal));
    } else if (lateTerminal != null) {
      text.append(this.visit(lateTerminal));
    } else if (libraryTerminal != null) {
      text.append(this.visit(libraryTerminal));
    } else if (mixinTerminal != null) {
      text.append(this.visit(mixinTerminal));
    } else if (operatorTerminal != null) {
      text.append(this.visit(operatorTerminal));
    } else if (partTerminal != null) {
      text.append(this.visit(partTerminal));
    } else if (requiredTerminal != null) {
      text.append(this.visit(requiredTerminal));
    } else if (setTerminal != null) {
      text.append(this.visit(setTerminal));
    } else if (staticTerminal != null) {
      text.append(this.visit(staticTerminal));
    } else if (typedefTerminal != null) {
      text.append(this.visit(typedefTerminal));
    } else if (asyncTerminal != null) {
      text.append(this.visit(asyncTerminal));
    } else if (hideTerminal != null) {
      text.append(this.visit(hideTerminal));
    } else if (ofTerminal != null) {
      text.append(this.visit(ofTerminal));
    } else if (onTerminal != null) {
      text.append(this.visit(onTerminal));
    } else if (showTerminal != null) {
      text.append(this.visit(showTerminal));
    } else if (syncTerminal != null) {
      text.append(this.visit(syncTerminal));
    } else if (awaitTerminal != null) {
      text.append(this.visit(awaitTerminal));
    } else if (yieldTerminal != null) {
      text.append(this.visit(yieldTerminal));
    } else if (nativeTerminal != null) {
      text.append(this.visit(nativeTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitLiteral(final Dart2Parser.LiteralContext context) {
    final Dart2Parser.NullLiteralContext nullLiteralContext = context.nullLiteral();
    final Dart2Parser.BooleanLiteralContext booleanLiteralContext = context.booleanLiteral();
    final Dart2Parser.NumericLiteralContext numericLiteralContext = context.numericLiteral();
    final Dart2Parser.StringLiteralContext stringLiteralContext = context.stringLiteral();
    final Dart2Parser.SymbolLiteralContext symbolLiteralContext = context.symbolLiteral();
    final Dart2Parser.ListLiteralContext listLiteralContext = context.listLiteral();
    final Dart2Parser.SetOrMapLiteralContext setOrMapLiteralContext = context.setOrMapLiteral();
    if (symbolLiteralContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitLiteral -> symbolLiteral");
    }
    final StringBuilder text = new StringBuilder();
    if (nullLiteralContext != null) {
      text.append(this.visit(nullLiteralContext));
    }
    if (booleanLiteralContext != null) {
      text.append(this.visit(booleanLiteralContext));
    }
    if (stringLiteralContext != null) {
      text.append(this.visit(stringLiteralContext));
    }
    if (setOrMapLiteralContext != null) {
      text.append(this.visit(setOrMapLiteralContext));
    }
    if (listLiteralContext != null) {
      text.append(this.visit(listLiteralContext));
    }
    if (numericLiteralContext != null) {
      text.append(this.visit(numericLiteralContext));
    }
    return text.toString();
  }

  @Override
  public String visitNumericLiteral(final Dart2Parser.NumericLiteralContext context) {
    final TerminalNode numberTerminal = context.NUMBER();
    final TerminalNode hexNumberTerminal = context.HEX_NUMBER();
    final StringBuilder text = new StringBuilder();
    if (numberTerminal == null) {
      text.append(this.visit(hexNumberTerminal));
    } else {
      text.append(this.visit(numberTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitBooleanLiteral(final Dart2Parser.BooleanLiteralContext context) {
    final TerminalNode trueTerminal = context.TRUE_();
    final TerminalNode falseTerminal = context.FALSE_();
    final StringBuilder text = new StringBuilder();
    if (trueTerminal == null) {
      text.append(this.visit(falseTerminal));
    } else {
      text.append(this.visit(trueTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitNullLiteral(final Dart2Parser.NullLiteralContext context) {
    final TerminalNode nullTerminal = context.NULL_();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(nullTerminal));
    return text.toString();
  }

  @Override
  public String visitListLiteral(final Dart2Parser.ListLiteralContext context) {
    final TerminalNode constTerminal = context.CONST_();
    final Dart2Parser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final TerminalNode obTerminal = context.OB();
    final Dart2Parser.ElementsContext elementsContext = context.elements();
    final TerminalNode cbTerminal = context.CB();
    final StringBuilder text = new StringBuilder();
    if (constTerminal != null) {
      text.append(this.visit(constTerminal)).append(' ');
    }
    if (typeArgumentsContext != null) {
      text.append(this.visit(typeArgumentsContext));
    }
    text.append(this.visit(obTerminal));
    if (elementsContext != null) {
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(elementsContext));
      this.currentIndentLevel--;
      this.appendNewLinesAndIndent(text, 1);
    }
    text.append(this.visit(cbTerminal));
    return text.toString();
  }

  @Override
  public String visitSetOrMapLiteral(final Dart2Parser.SetOrMapLiteralContext context) {
    final TerminalNode constTerminal = context.CONST_();
    final Dart2Parser.TypeArgumentsContext typeArgumentsContext = context.typeArguments();
    final TerminalNode obcTerminal = context.OBC();
    final Dart2Parser.ElementsContext elementsContext = context.elements();
    final TerminalNode cbcTerminal = context.CBC();
    final StringBuilder text = new StringBuilder();
    if (constTerminal != null) {
      text.append(this.visit(constTerminal)).append(' ');
    }
    if (typeArgumentsContext != null) {
      text.append(this.visit(typeArgumentsContext));
    }
    if (elementsContext == null) {
      text.append(this.visit(obcTerminal)).append(this.visit(cbcTerminal));
    } else {
      text.append(this.visit(obcTerminal));
      this.currentIndentLevel++;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(elementsContext));
      this.currentIndentLevel--;
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(cbcTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitElements(final Dart2Parser.ElementsContext context) {
    final List<Dart2Parser.ElementContext> elementContexts = context.element();
    final List<TerminalNode> cTerminals = context.C();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.ElementContext firstElementContext = elementContexts.get(0);
    final String firstElementText = this.visit(firstElementContext);
    text.append(firstElementText);
    for (int index = 1; index < elementContexts.size(); index++) {
      final Dart2Parser.ElementContext elementContext = elementContexts.get(index);
      final TerminalNode cTerminal = cTerminals.get(index - 1);
      text.append(this.visit(cTerminal));
      this.appendNewLinesAndIndent(text, 1);
      text.append(this.visit(elementContext));
    }
    if (elementContexts.size() == cTerminals.size()) {
      final TerminalNode cTerminal = cTerminals.get(cTerminals.size() - 1);
      text.append(this.visit(cTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitElement(final Dart2Parser.ElementContext context) {
    final Dart2Parser.ExpressionElementContext expressionElementContext =
        context.expressionElement();
    final Dart2Parser.MapElementContext mapElementContext = context.mapElement();
    final Dart2Parser.SpreadElementContext spreadElementContext = context.spreadElement();
    final Dart2Parser.IfElementContext ifElementContext = context.ifElement();
    final Dart2Parser.ForElementContext forElementContext = context.forElement();
    final StringBuilder text = new StringBuilder();
    if (expressionElementContext != null) {
      text.append(this.visit(expressionElementContext));
    } else if (mapElementContext != null) {
      text.append(this.visit(mapElementContext));
    } else if (spreadElementContext != null) {
      text.append(this.visit(spreadElementContext));
    } else if (ifElementContext != null) {
      text.append(this.visit(ifElementContext));
    } else if (forElementContext != null) {
      text.append(this.visit(forElementContext));
    }
    return text.toString();
  }

  @Override
  public String visitForElement(final Dart2Parser.ForElementContext context) {
    final TerminalNode awaitTerminal = context.AWAIT_();
    final TerminalNode forTerminal = context.FOR_();
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ForLoopPartsContext forLoopPartsContext = context.forLoopParts();
    final TerminalNode cpTerminal = context.CP();
    final Dart2Parser.ElementContext elementContext = context.element();
    final StringBuilder text = new StringBuilder();
    if (awaitTerminal != null) {
      text.append(this.visit(awaitTerminal)).append(' ');
    }
    text.append(this.visit(forTerminal))
        .append(' ')
        .append(this.visit(opTerminal))
        .append(this.visit(forLoopPartsContext))
        .append(this.visit(cpTerminal))
        .append(' ')
        .append(this.visit(elementContext));
    return text.toString();
  }

  @Override
  public String visitIfElement(final Dart2Parser.IfElementContext context) {
    final TerminalNode ifTerminal = context.IF_();
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final TerminalNode cpTerminal = context.CP();
    final List<Dart2Parser.ElementContext> elementContexts = context.element();
    final TerminalNode elseTerminal = context.ELSE_();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(ifTerminal))
        .append(' ')
        .append(this.visit(opTerminal))
        .append(this.visit(exprContext))
        .append(this.visit(cpTerminal))
        .append(' ');
    final Dart2Parser.ElementContext firstElementContext = elementContexts.get(0);
    text.append(this.visit(firstElementContext));
    if (elseTerminal != null) {
      text.append(' ').append(this.visit(elseTerminal)).append(' ');
      final Dart2Parser.ElementContext secondElementContext = elementContexts.get(1);
      text.append(this.visit(secondElementContext));
    }
    return text.toString();
  }

  @Override
  public String visitSpreadElement(final Dart2Parser.SpreadElementContext context) {
    final TerminalNode dddTerminal = context.DDD();
    final TerminalNode dddqTerminal = context.DDDQ();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    if (dddTerminal != null) {
      text.append(this.visit(dddTerminal));
    } else if (dddqTerminal != null) {
      text.append(this.visit(dddqTerminal));
    }
    text.append(this.visit(exprContext));
    return text.toString();
  }

  @Override
  public String visitExpressionElement(final Dart2Parser.ExpressionElementContext context) {
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(exprContext));
    return text.toString();
  }

  @Override
  public String visitMapElement(final Dart2Parser.MapElementContext context) {
    final List<Dart2Parser.ExprContext> exprContexts = context.expr();
    final TerminalNode coTerminal = context.CO();
    final StringBuilder text = new StringBuilder();
    final Dart2Parser.ExprContext firstExprContext = exprContexts.get(0);
    text.append(this.visit(firstExprContext)).append(this.visit(coTerminal)).append(' ');
    final Dart2Parser.ExprContext secondExprContext = exprContexts.get(1);
    text.append(this.visit(secondExprContext));
    return text.toString();
  }

  @Override
  public String visitNewExpression(final Dart2Parser.NewExpressionContext context) {
    final TerminalNode newTerminal = context.NEW_();
    // It can be a class name.
    final Dart2Parser.ConstructorDesignationContext constructorDesignationContext =
        context.constructorDesignation();
    final Dart2Parser.ArgumentsContext argumentsContext = context.arguments();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(newTerminal))
        .append(' ')
        .append(this.visit(constructorDesignationContext))
        .append(this.visit(argumentsContext));
    return text.toString();
  }

  @Override
  public String visitArguments(final Dart2Parser.ArgumentsContext context) {
    final TerminalNode opTerminal = context.OP();
    final Dart2Parser.ArgumentListContext argumentListContext = context.argumentList();
    final TerminalNode cTerminal = context.C();
    final TerminalNode cpTerminal = context.CP();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(opTerminal));
    if (argumentListContext != null) {
      // We will visit children assuming that we are not supposed to indent them.
      // After the visit, we can determine if the children actually needed indentation.
      // If indentation was needed, we will visit the children again with indentation.
      // That means we may visit the same children twice, which may mess up the visit counts.
      // For that reason, we create a backup for the visit counts to reset them.
      final Map<String, Integer> ruleVisitCountsBackup = new HashMap<>(this.ruleVisitCounts);
      final int visitArgumentsCountBefore =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.ArgumentsContext.class.getSimpleName(), 0);
      final int visitNamedArgumentCountBefore =
          this.ruleVisitCounts.getOrDefault(
              Dart2Parser.NamedArgumentContext.class.getSimpleName(), 0);
      final String unindentedArgumentsText = this.visit(argumentListContext);
      final int visitArgumentsCountAfter =
          this.ruleVisitCounts.getOrDefault(Dart2Parser.ArgumentsContext.class.getSimpleName(), 0);
      final int visitNamedArgumentCountAfter =
          this.ruleVisitCounts.getOrDefault(
              Dart2Parser.NamedArgumentContext.class.getSimpleName(), 0);
      // We assume the following condition means nested object initialization. Ex:
      // User(User('Rin'));
      final boolean objNested = visitArgumentsCountBefore < visitArgumentsCountAfter;
      final boolean namedParamUsed = visitNamedArgumentCountBefore < visitNamedArgumentCountAfter;
      if (objNested || namedParamUsed) {
        // Indentation needed.
        // We need to visit children again with indentation.
        // Reset the visit counts.
        this.ruleVisitCounts = ruleVisitCountsBackup;
        this.currentIndentLevel++;
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(argumentListContext));
        if (cTerminal != null) {
          text.append(this.visit(cTerminal));
        }
        this.currentIndentLevel--;
        this.appendNewLinesAndIndent(text, 1);
      } else {
        // No indentation needed.
        text.append(unindentedArgumentsText);
        if (cTerminal != null) {
          text.append(this.visit(cTerminal));
        }
      }
    }
    text.append(this.visit(cpTerminal));
    return text.toString();
  }

  @Override
  public String visitArgumentList(final Dart2Parser.ArgumentListContext context) {
    final List<Dart2Parser.NamedArgumentContext> namedArgumentContexts = context.namedArgument();
    final List<TerminalNode> cTerminals = context.C();
    final Dart2Parser.ExpressionListContext expressionListContext = context.expressionList();
    final StringBuilder text = new StringBuilder();
    if (expressionListContext != null) {
      // expressionList ( C namedArgument)*
      text.append(this.visit(expressionListContext));
      for (int index = 0; index < cTerminals.size(); index++) {
        final TerminalNode cTerminal = cTerminals.get(index);
        final Dart2Parser.NamedArgumentContext namedArgumentContext =
            namedArgumentContexts.get(index);
        text.append(this.visit(cTerminal));
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(namedArgumentContext));
      }
    } else {
      final Dart2Parser.NamedArgumentContext firstNamedArgumentContext =
          namedArgumentContexts.get(0);
      text.append(this.visit(firstNamedArgumentContext));
      for (int index = 0; index < cTerminals.size(); index++) {
        final TerminalNode cTerminal = cTerminals.get(index);
        final Dart2Parser.NamedArgumentContext namedArgumentContext;
        if (cTerminals.size() == namedArgumentContexts.size()) {
          namedArgumentContext = namedArgumentContexts.get(index);
        } else {
          namedArgumentContext = namedArgumentContexts.get(index + 1);
        }
        text.append(this.visit(cTerminal));
        this.appendNewLinesAndIndent(text, 1);
        text.append(this.visit(namedArgumentContext));
      }
    }
    return text.toString();
  }

  @Override
  public String visitNamedArgument(final Dart2Parser.NamedArgumentContext context) {
    final Dart2Parser.LabelContext labelContext = context.label();
    final Dart2Parser.ExprContext exprContext = context.expr();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(labelContext)).append(' ').append(this.visit(exprContext));
    return text.toString();
  }

  @Override
  public String visitLabel(final Dart2Parser.LabelContext context) {
    final Dart2Parser.IdentifierContext identifierContext = context.identifier();
    final TerminalNode coTerminal = context.CO();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(identifierContext)).append(this.visit(coTerminal));
    return text.toString();
  }

  @Override
  public String visitChildren(final RuleNode node) {
    throw new UnsupportedOperationException(
        String.format(
            "The following rule is not implemented yet: %s text: %s",
            node.getClass(), node.getText()));
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
  public String visitTerminal(final TerminalNode node) {
    final int tokenIndex = node.getSymbol().getTokenIndex();
    final int commentChannel = 3;
    final List<Token> comments = this.tokens.getHiddenTokensToLeft(tokenIndex, commentChannel);
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
