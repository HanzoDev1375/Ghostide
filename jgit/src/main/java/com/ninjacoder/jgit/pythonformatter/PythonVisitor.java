package com.ninjacoder.jgit.pythonformatter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** This is the class that has the formatting logic. Welcome to the project :) */
public final class PythonVisitor extends PythonParserBaseVisitor<String> {

  /** For logging. */
  private static final Logger LOGGER = LoggerFactory.getLogger(PythonVisitor.class);

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
   * @param tokens See {@link PythonVisitor#tokens}.
   */
  public PythonVisitor(final CommonTokenStream tokens) {
    this.tokens = tokens;
  }

  @Override
  public String visitFile_input(final PythonParser.File_inputContext context) {
    final PythonParser.StatementsContext statementsContext = context.statements();
    final StringBuilder text = new StringBuilder();
    if (statementsContext != null) {
      text.append(this.visit(statementsContext));
    }
    return text.toString();
  }

  @Override
  public String visitStatements(final PythonParser.StatementsContext context) {
    final List<PythonParser.StatementContext> statementContexts = context.statement();
    final StringBuilder text = new StringBuilder();
    for (final PythonParser.StatementContext statementContext : statementContexts) {
      text.append(this.visit(statementContext));
    }
    return text.toString();
  }

  @Override
  public String visitStatement(final PythonParser.StatementContext context) {
    final PythonParser.Compound_stmtContext compoundStmtContext = context.compound_stmt();
    final PythonParser.Simple_stmtsContext simpleStmtsContext = context.simple_stmts();
    final StringBuilder text = new StringBuilder();
    if (compoundStmtContext != null) {
      text.append(this.visit(compoundStmtContext));
    } else if (simpleStmtsContext != null) {
      text.append(this.visit(simpleStmtsContext));
    }
    return text.toString();
  }

  @Override
  public String visitSimple_stmts(final PythonParser.Simple_stmtsContext context) {
    final List<PythonParser.Simple_stmtContext> simpleStmtContexts = context.simple_stmt();
    final List<TerminalNode> semiTerminals = context.SEMI();
    final TerminalNode newlineTerminal = context.NEWLINE();
    final StringBuilder text = new StringBuilder();
    final PythonParser.Simple_stmtContext firstSimpleStmtContext = simpleStmtContexts.get(0);
    text.append(this.visit(firstSimpleStmtContext));
    if (!semiTerminals.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmts -> SEMI");
    }
    text.append(this.visit(newlineTerminal));
    return text.toString();
  }

  @Override
  public String visitSimple_stmt(final PythonParser.Simple_stmtContext context) {
    final PythonParser.AssignmentContext assignmentContext = context.assignment();
    final PythonParser.Type_aliasContext typeAliasContext = context.type_alias();
    final PythonParser.Star_expressionsContext starExpressionsContext = context.star_expressions();
    final PythonParser.Return_stmtContext returnStmtContext = context.return_stmt();
    final PythonParser.Import_stmtContext importStmtContext = context.import_stmt();
    final PythonParser.Raise_stmtContext raiseStmtContext = context.raise_stmt();
    final TerminalNode passTerminal = context.PASS();
    final PythonParser.Del_stmtContext delStmtContext = context.del_stmt();
    final PythonParser.Yield_stmtContext yieldStmtContext = context.yield_stmt();
    final PythonParser.Assert_stmtContext assertStmtContext = context.assert_stmt();
    final TerminalNode breakTerminal = context.BREAK();
    final TerminalNode continueTerminal = context.CONTINUE();
    final PythonParser.Global_stmtContext globalStmtContext = context.global_stmt();
    final PythonParser.Nonlocal_stmtContext nonlocalStmtContext = context.nonlocal_stmt();
    final StringBuilder text = new StringBuilder();
    if (assignmentContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> assignment");
    } else if (typeAliasContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> type_alias");
    } else if (starExpressionsContext != null) {
      text.append(this.visit(starExpressionsContext));
    } else if (returnStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> return_stmt");
    } else if (importStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> import_stmt");
    } else if (raiseStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> raise_stmt");
    } else if (passTerminal != null) {
      text.append(this.visit(passTerminal));
    } else if (delStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> del_stmt");
    } else if (yieldStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> yield_stmt");
    } else if (assertStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> assert_stmt");
    } else if (breakTerminal != null) {
      text.append(this.visit(breakTerminal));
    } else if (continueTerminal != null) {
      text.append(this.visit(continueTerminal));
    } else if (globalStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> global_stmt");
    } else if (nonlocalStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSimple_stmt -> nonlocal_stmt");
    }
    return text.toString();
  }

  @Override
  public String visitStar_expressions(final PythonParser.Star_expressionsContext context) {
    final List<PythonParser.Star_expressionContext> starExpressionContexts =
        context.star_expression();
    final List<TerminalNode> commaTerminals = context.COMMA();
    final StringBuilder text = new StringBuilder();
    final PythonParser.Star_expressionContext firstStarExpressionContext =
        starExpressionContexts.get(0);
    text.append(this.visit(firstStarExpressionContext));
    if (!commaTerminals.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitStar_expressions -> COMMA");
    }
    return text.toString();
  }

  @Override
  public String visitStar_expression(final PythonParser.Star_expressionContext context) {
    final TerminalNode starTerminal = context.STAR();
    // todo: use `bitwiseOrContext` with tests.
    final PythonParser.Bitwise_orContext bitwiseOrContext = context.bitwise_or();
    final PythonParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    if (starTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitStar_expression -> STAR");
    } else if (expressionContext != null) {
      text.append(this.visit(expressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitExpression(final PythonParser.ExpressionContext context) {
    final List<PythonParser.DisjunctionContext> disjunctionContexts = context.disjunction();
    final TerminalNode ifTerminal = context.IF();
    // todo: use `elseTerminal` and `expressionContext` with tests.
    final TerminalNode elseTerminal = context.ELSE();
    final PythonParser.ExpressionContext expressionContext = context.expression();
    final PythonParser.LambdefContext lambdefContext = context.lambdef();
    final StringBuilder text = new StringBuilder();
    if (lambdefContext == null) {
      final PythonParser.DisjunctionContext firstDisjunctionContext = disjunctionContexts.get(0);
      text.append(this.visit(firstDisjunctionContext));
      if (ifTerminal != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitExpression -> IF");
      }
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitExpression -> lambdef");
    }
    return text.toString();
  }

  @Override
  public String visitDisjunction(final PythonParser.DisjunctionContext context) {
    final List<PythonParser.ConjunctionContext> conjunctionContexts = context.conjunction();
    final List<TerminalNode> orTerminals = context.OR();
    final StringBuilder text = new StringBuilder();
    final PythonParser.ConjunctionContext firstConjunctionContext = conjunctionContexts.get(0);
    text.append(this.visit(firstConjunctionContext));
    if (!orTerminals.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitDisjunction -> OR");
    }
    return text.toString();
  }

  @Override
  public String visitConjunction(final PythonParser.ConjunctionContext context) {
    final List<PythonParser.InversionContext> inversionContexts = context.inversion();
    final List<TerminalNode> andTerminals = context.AND();
    final StringBuilder text = new StringBuilder();
    final PythonParser.InversionContext firstInversionContext = inversionContexts.get(0);
    text.append(this.visit(firstInversionContext));
    if (!andTerminals.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitConjunction -> AND");
    }
    return text.toString();
  }

  @Override
  public String visitInversion(final PythonParser.InversionContext context) {
    final TerminalNode notTerminal = context.NOT();
    // todo: use `inversionContext` with tests.
    final PythonParser.InversionContext inversionContext = context.inversion();
    final PythonParser.ComparisonContext comparisonContext = context.comparison();
    final StringBuilder text = new StringBuilder();
    if (notTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitInversion -> NOT");
    } else if (comparisonContext != null) {
      text.append(this.visit(comparisonContext));
    }
    return text.toString();
  }

  @Override
  public String visitComparison(final PythonParser.ComparisonContext context) {
    final PythonParser.Bitwise_orContext bitwiseOrContext = context.bitwise_or();
    final List<PythonParser.Compare_op_bitwise_or_pairContext> compareOpBitwiseOrPairContexts =
        context.compare_op_bitwise_or_pair();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(bitwiseOrContext));
    if (!compareOpBitwiseOrPairContexts.isEmpty()) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitComparison -> compare_op_bitwise_or_pair");
    }
    return text.toString();
  }

  @Override
  public String visitBitwise_or(final PythonParser.Bitwise_orContext context) {
    final PythonParser.Bitwise_orContext bitwiseOrContext = context.bitwise_or();
    // todo: use `vbarTerminal` with tests.
    final TerminalNode vbarTerminal = context.VBAR();
    final PythonParser.Bitwise_xorContext bitwiseXorContext = context.bitwise_xor();
    final StringBuilder text = new StringBuilder();
    if (bitwiseOrContext == null) {
      text.append(this.visit(bitwiseXorContext));
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwise_or -> bitwise_or");
    }
    return text.toString();
  }

  @Override
  public String visitBitwise_xor(final PythonParser.Bitwise_xorContext context) {
    final PythonParser.Bitwise_xorContext bitwiseXorContext = context.bitwise_xor();
    // todo: use `circumflexTerminal` with tests.
    final TerminalNode circumflexTerminal = context.CIRCUMFLEX();
    final PythonParser.Bitwise_andContext bitwiseAndContext = context.bitwise_and();
    final StringBuilder text = new StringBuilder();
    if (bitwiseXorContext == null) {
      text.append(this.visit(bitwiseAndContext));
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwise_xor -> bitwise_xor");
    }
    return text.toString();
  }

  @Override
  public String visitBitwise_and(final PythonParser.Bitwise_andContext context) {
    final PythonParser.Bitwise_andContext bitwiseAndContext = context.bitwise_and();
    // todo: use `amperTerminal` with tests.
    final TerminalNode amperTerminal = context.AMPER();
    final PythonParser.Shift_exprContext shiftExprContext = context.shift_expr();
    final StringBuilder text = new StringBuilder();
    if (bitwiseAndContext == null) {
      text.append(this.visit(shiftExprContext));
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBitwise_and -> bitwise_and");
    }
    return text.toString();
  }

  @Override
  public String visitShift_expr(final PythonParser.Shift_exprContext context) {
    final PythonParser.Shift_exprContext shiftExprContext = context.shift_expr();
    // todo: use `leftshiftTerminal` and `rightshiftTerminal` with tests.
    final TerminalNode leftshiftTerminal = context.LEFTSHIFT();
    final TerminalNode rightshiftTerminal = context.RIGHTSHIFT();
    final PythonParser.SumContext sumContext = context.sum();
    final StringBuilder text = new StringBuilder();
    if (shiftExprContext == null) {
      text.append(this.visit(sumContext));
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitShift_expr -> shift_expr");
    }
    return text.toString();
  }

  @Override
  public String visitSum(final PythonParser.SumContext context) {
    final PythonParser.SumContext sumContext = context.sum();
    // todo: use `plusTerminal` and `minusTerminal` with tests.
    final TerminalNode plusTerminal = context.PLUS();
    final TerminalNode minusTerminal = context.MINUS();
    final PythonParser.TermContext termContext = context.term();
    final StringBuilder text = new StringBuilder();
    if (sumContext == null) {
      text.append(this.visit(termContext));
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitSum -> sum");
    }
    return text.toString();
  }

  @Override
  public String visitTerm(final PythonParser.TermContext context) {
    final PythonParser.TermContext termContext = context.term();
    // todo: use `starTerminal`, `slashTerminal`, `doubleSlashTerminal`, `percentTerminal`, and
    // `atTerminal` with tests.
    final TerminalNode starTerminal = context.STAR();
    final TerminalNode slashTerminal = context.SLASH();
    final TerminalNode doubleSlashTerminal = context.DOUBLESLASH();
    final TerminalNode percentTerminal = context.PERCENT();
    final TerminalNode atTerminal = context.AT();
    final PythonParser.FactorContext factorContext = context.factor();
    final StringBuilder text = new StringBuilder();
    if (termContext == null) {
      text.append(this.visit(factorContext));
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitTerm -> term");
    }
    return text.toString();
  }

  @Override
  public String visitFactor(final PythonParser.FactorContext context) {
    // todo: use `plusTerminal`, `factorContext`, `minusTerminal`, and `tildeTerminal` with tests.
    final TerminalNode plusTerminal = context.PLUS();
    final PythonParser.FactorContext factorContext = context.factor();
    final TerminalNode minusTerminal = context.MINUS();
    final TerminalNode tildeTerminal = context.TILDE();
    final PythonParser.PowerContext powerContext = context.power();
    final StringBuilder text = new StringBuilder();
    if (powerContext == null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFactor -> factor");
    } else {
      text.append(this.visit(powerContext));
    }
    return text.toString();
  }

  @Override
  public String visitPower(final PythonParser.PowerContext context) {
    final PythonParser.Await_primaryContext awaitPrimaryContext = context.await_primary();
    final TerminalNode doublestartTerminal = context.DOUBLESTAR();
    // todo: use `factorContext` with tests.
    final PythonParser.FactorContext factorContext = context.factor();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(awaitPrimaryContext));
    if (doublestartTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitPower -> DOUBLESTAR");
    }
    return text.toString();
  }

  @Override
  public String visitAwait_primary(final PythonParser.Await_primaryContext context) {
    final TerminalNode awaitTerminal = context.AWAIT();
    final PythonParser.PrimaryContext primaryContext = context.primary();
    final StringBuilder text = new StringBuilder();
    if (awaitTerminal == null) {
      text.append(this.visit(primaryContext));
    } else {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAwait_primary -> AWAIT");
    }
    return text.toString();
  }

  @Override
  public String visitPrimary(final PythonParser.PrimaryContext context) {
    final PythonParser.PrimaryContext primaryContext = context.primary();
    final TerminalNode dotTerminal = context.DOT();
    // todo: use `nameContext` with tests.
    final PythonParser.NameContext nameContext = context.name();
    final PythonParser.GenexpContext genexpContext = context.genexp();
    final TerminalNode lparTerminal = context.LPAR();
    final PythonParser.ArgumentsContext argumentsContext = context.arguments();
    final TerminalNode rparTerminal = context.RPAR();
    final TerminalNode lsqbTerminal = context.LSQB();
    // todo: use `slicesContext` and `rsqbTerminal` with tests.
    final PythonParser.SlicesContext slicesContext = context.slices();
    final TerminalNode rsqbTerminal = context.RSQB();
    final PythonParser.AtomContext atomContext = context.atom();
    final StringBuilder text = new StringBuilder();
    if (primaryContext != null) {
      text.append(this.visit(primaryContext));
      if (dotTerminal != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitPrimary -> DOT");
      } else if (genexpContext != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitPrimary -> genexp");
      } else if (lparTerminal != null) {
        text.append(this.visit(lparTerminal));
        if (argumentsContext != null) {
          text.append(this.visit(argumentsContext));
        }
        text.append(this.visit(rparTerminal));
      } else if (lsqbTerminal != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitPrimary -> LSQB");
      }
    } else if (atomContext != null) {
      text.append(this.visit(atomContext));
    }
    return text.toString();
  }

  @Override
  public String visitArguments(final PythonParser.ArgumentsContext context) {
    final PythonParser.ArgsContext argsContext = context.args();
    final TerminalNode commaTerminal = context.COMMA();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(argsContext));
    if (commaTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitArguments -> COMMA");
    }
    return text.toString();
  }

  @Override
  public String visitArgs(final PythonParser.ArgsContext context) {
    final PythonParser.FirstPartOfArgsContext firstPartOfArgsContext = context.firstPartOfArgs();
    final List<PythonParser.SecondPartOfArgsContext> secondPartOfArgsContexts =
        context.secondPartOfArgs();
    final TerminalNode commaTerminal = context.COMMA();
    // todo: use `kwargsContext` with tests.
    final PythonParser.KwargsContext kwargsContext = context.kwargs();
    final StringBuilder text = new StringBuilder();
    if (firstPartOfArgsContext == null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitArgs -> kwargs");
    } else {
      text.append(this.visit(firstPartOfArgsContext));
      if (!secondPartOfArgsContexts.isEmpty()) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitArgs -> secondPartOfArgsContexts");
      }
      if (commaTerminal != null) {
        throw new UnsupportedOperationException(
            "The following parsing path is not supported yet: visitArgs -> COMMA");
      }
    }
    return text.toString();
  }

  @Override
  public String visitFirstPartOfArgs(final PythonParser.FirstPartOfArgsContext context) {
    final PythonParser.Starred_expressionContext starredExpressionContext =
        context.starred_expression();
    final PythonParser.Assignment_expressionContext assignmentExpressionContext =
        context.assignment_expression();
    final PythonParser.ExpressionContext expressionContext = context.expression();
    final StringBuilder text = new StringBuilder();
    if (starredExpressionContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFirstPartOfArgs -> starred_expression");
    } else if (assignmentExpressionContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFirstPartOfArgs -> assignment_expression");
    } else if (expressionContext != null) {
      text.append(this.visit(expressionContext));
    }
    return text.toString();
  }

  @Override
  public String visitAtom(final PythonParser.AtomContext context) {
    final PythonParser.NameContext nameContext = context.name();
    final TerminalNode trueTerminal = context.TRUE();
    final TerminalNode falseTerminal = context.FALSE();
    final TerminalNode noneTerminal = context.NONE();
    final PythonParser.StringsContext stringsContext = context.strings();
    final TerminalNode numberTerminal = context.NUMBER();
    final PythonParser.TupleContext tupleContext = context.tuple();
    final PythonParser.GroupContext groupContext = context.group();
    final PythonParser.GenexpContext genexpContext = context.genexp();
    final PythonParser.ListContext listContext = context.list();
    final PythonParser.ListcompContext listcompContext = context.listcomp();
    final PythonParser.DictContext dictContext = context.dict();
    final PythonParser.SetContext setContext = context.set();
    final PythonParser.DictcompContext dictcompContext = context.dictcomp();
    final PythonParser.SetcompContext setcompContext = context.setcomp();
    final TerminalNode ellipsesTerminal = context.ELLIPSIS();
    final StringBuilder text = new StringBuilder();
    if (nameContext != null) {
      text.append(this.visit(nameContext));
    } else if (trueTerminal != null) {
      text.append(this.visit(trueTerminal));
    } else if (falseTerminal != null) {
      text.append(this.visit(falseTerminal));
    } else if (noneTerminal != null) {
      text.append(this.visit(noneTerminal));
    } else if (stringsContext != null) {
      text.append(this.visit(stringsContext));
    } else if (numberTerminal != null) {
      text.append(this.visit(numberTerminal));
    } else if (tupleContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> tuple");
    } else if (groupContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> group");
    } else if (genexpContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> genexp");
    } else if (listContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> list");
    } else if (listcompContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> listcomp");
    } else if (dictContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> dict");
    } else if (setContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> set");
    } else if (dictcompContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> dictcomp");
    } else if (setcompContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitAtom -> setcomp");
    } else if (ellipsesTerminal != null) {
      text.append(this.visit(ellipsesTerminal));
    }
    return text.toString();
  }

  @Override
  public String visitStrings(final PythonParser.StringsContext context) {
    final List<PythonParser.FstringOrStringContext> fstringOrStringContexts =
        context.fstringOrString();
    final StringBuilder text = new StringBuilder();
    for (final PythonParser.FstringOrStringContext fstringOrStringContext :
        fstringOrStringContexts) {
      text.append(this.visit(fstringOrStringContext));
    }
    return text.toString();
  }

  @Override
  public String visitString(final PythonParser.StringContext context) {
    final TerminalNode stringTerminal = context.STRING();
    final StringBuilder text = new StringBuilder();
    text.append(this.visit(stringTerminal));
    return text.toString();
  }

  @Override
  public String visitFstringOrString(final PythonParser.FstringOrStringContext context) {
    final PythonParser.FstringContext fstringContext = context.fstring();
    final PythonParser.StringContext stringContext = context.string();
    final StringBuilder text = new StringBuilder();
    if (fstringContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFstringOrString -> fstring");
    } else if (stringContext != null) {
      text.append(this.visit(stringContext));
    }
    return text.toString();
  }

  @Override
  public String visitCompound_stmt(final PythonParser.Compound_stmtContext context) {
    final PythonParser.Function_defContext functionDefContext = context.function_def();
    final PythonParser.If_stmtContext ifStmtContext = context.if_stmt();
    final PythonParser.Class_defContext classDefContext = context.class_def();
    final PythonParser.With_stmtContext withStmtContext = context.with_stmt();
    final PythonParser.For_stmtContext forStmtContext = context.for_stmt();
    final PythonParser.Try_stmtContext tryStmtContext = context.try_stmt();
    final PythonParser.While_stmtContext whileStmtContext = context.while_stmt();
    final PythonParser.Match_stmtContext matchStmtContext = context.match_stmt();
    final StringBuilder text = new StringBuilder();
    if (functionDefContext != null) {
      text.append(this.visit(functionDefContext));
    } else if (ifStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompound_stmt -> if_stmt");
    } else if (classDefContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompound_stmt -> class_def");
    } else if (withStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompound_stmt -> with_stmt");
    } else if (forStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompound_stmt -> for_stmt");
    } else if (tryStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompound_stmt -> try_stmt");
    } else if (whileStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompound_stmt -> while_stmt");
    } else if (matchStmtContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitCompound_stmt -> match_stmt");
    }
    return text.toString();
  }

  @Override
  public String visitFunction_def(final PythonParser.Function_defContext context) {
    final PythonParser.DecoratorsContext decoratorsContext = context.decorators();
    final PythonParser.Function_def_rawContext functionDefRawContext = context.function_def_raw();
    final StringBuilder text = new StringBuilder();
    if (decoratorsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunction_def -> decorators");
    } else {
      text.append(this.visit(functionDefRawContext));
      this.appendNewLinesAndIndent(text, 2);
    }
    return text.toString();
  }

  @Override
  public String visitFunction_def_raw(final PythonParser.Function_def_rawContext context) {
    final TerminalNode defTerminal = context.DEF();
    final PythonParser.NameContext nameContext = context.name();
    final PythonParser.Type_paramsContext typeParamsContext = context.type_params();
    final TerminalNode lparTerminal = context.LPAR();
    final PythonParser.ParamsContext paramsContext = context.params();
    final TerminalNode rparTerminal = context.RPAR();
    final TerminalNode rarrowTerminal = context.RARROW();
    // todo: use `expressionContext` with tests.
    final PythonParser.ExpressionContext expressionContext = context.expression();
    final TerminalNode colonTerminal = context.COLON();
    final PythonParser.Func_type_commentContext typeCommentContext = context.func_type_comment();
    final PythonParser.BlockContext blockContext = context.block();
    final TerminalNode asyncTerminal = context.ASYNC();
    final StringBuilder text = new StringBuilder();
    if (asyncTerminal != null) {
      text.append(this.visit(asyncTerminal)).append(' ');
    }
    text.append(this.visit(defTerminal)).append(' ').append(this.visit(nameContext));
    if (typeParamsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunction_def_raw -> type_params");
    }
    text.append(this.visit(lparTerminal));
    if (paramsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunction_def_raw -> params");
    }
    text.append(this.visit(rparTerminal));
    if (rarrowTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunction_def_raw -> rarrow");
    }
    text.append(this.visit(colonTerminal));
    if (typeCommentContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitFunction_def_raw -> func_type_comment");
    }
    text.append(this.visit(blockContext));
    return text.toString();
  }

  @Override
  public String visitBlock(final PythonParser.BlockContext context) {
    final TerminalNode newlineTerminal = context.NEWLINE();
    final TerminalNode indentTerminal = context.INDENT();
    final PythonParser.StatementsContext statementsContext = context.statements();
    final TerminalNode dedentTerminal = context.DEDENT();
    final PythonParser.Simple_stmtsContext simpleStmtsContext = context.simple_stmts();
    final StringBuilder text = new StringBuilder();
    if (newlineTerminal != null) {
      text.append(this.visit(newlineTerminal))
          .append(this.visit(indentTerminal))
          .append(this.visit(statementsContext))
          .append(this.visit(dedentTerminal));
    } else if (simpleStmtsContext != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitBlock -> simple_stmts");
    }
    return text.toString();
  }

  @Override
  public String visitName(final PythonParser.NameContext context) {
    final TerminalNode nameOrWildcardTerminal = context.NAME_OR_WILDCARD();
    final PythonParser.Name_except_underscoreContext nameExceptUnderscoreContext =
        context.name_except_underscore();
    final StringBuilder text = new StringBuilder();
    if (nameOrWildcardTerminal != null) {
      throw new UnsupportedOperationException(
          "The following parsing path is not supported yet: visitName -> NAME_OR_WILDCARD");
    } else if (nameExceptUnderscoreContext != null) {
      text.append(this.visit(nameExceptUnderscoreContext));
    }
    return text.toString();
  }

  @Override
  public String visitName_except_underscore(
      final PythonParser.Name_except_underscoreContext context) {
    final TerminalNode nameTerminal = context.NAME();
    final TerminalNode nameOrType = context.NAME_OR_TYPE();
    final TerminalNode nameOrMatch = context.NAME_OR_MATCH();
    final TerminalNode nameOrCase = context.NAME_OR_CASE();
    final StringBuilder text = new StringBuilder();
    if (nameTerminal != null) {
      text.append(this.visit(nameTerminal));
    } else if (nameOrType != null) {
      text.append(this.visit(nameOrType));
    } else if (nameOrMatch != null) {
      text.append(this.visit(nameOrMatch));
    } else if (nameOrCase != null) {
      text.append(this.visit(nameOrCase));
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
  public String visitTerminal(final TerminalNode node) {
    final int type = node.getSymbol().getType();
    final StringBuilder text = new StringBuilder();
    if (type == 98) {
      // newline token
      text.append('\n');
    } else if (type == 2) {
      // indent
      this.currentIndentLevel++;
      text.append(INDENT_UNIT.repeat(this.currentIndentLevel));
    } else if (type == 3) {
      // dedent
      this.currentIndentLevel--;
      text.append(INDENT_UNIT.repeat(this.currentIndentLevel));
    } else {
      text.append(node.getText());
    }
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
