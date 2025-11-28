/**
 * Manticore Projects JSQLFormatter is a SQL Beautifying and Formatting Software.
 * Copyright (C) 2024 Andreas Reichel <andreas@manticore-projects.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package io.github.rosemoe.sora.langs.sql;

import com.diogonunes.jcolor.Ansi;
import com.diogonunes.jcolor.AnsiFormat;
import com.diogonunes.jcolor.Attribute;
import net.sf.jsqlparser.expression.Alias;
import net.sf.jsqlparser.expression.Alias.AliasColumn;
import net.sf.jsqlparser.expression.AllValue;
import net.sf.jsqlparser.expression.AnalyticExpression;
import net.sf.jsqlparser.expression.AnalyticType;
import net.sf.jsqlparser.expression.ArrayConstructor;
import net.sf.jsqlparser.expression.BinaryExpression;
import net.sf.jsqlparser.expression.CaseExpression;
import net.sf.jsqlparser.expression.CastExpression;
import net.sf.jsqlparser.expression.DateValue;
import net.sf.jsqlparser.expression.DoubleValue;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.ExtractExpression;
import net.sf.jsqlparser.expression.Function;
import net.sf.jsqlparser.expression.IntervalExpression;
import net.sf.jsqlparser.expression.JdbcNamedParameter;
import net.sf.jsqlparser.expression.JdbcParameter;
import net.sf.jsqlparser.expression.KeepExpression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.MySQLGroupConcat;
import net.sf.jsqlparser.expression.NextValExpression;
import net.sf.jsqlparser.expression.NotExpression;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.OracleHint;
import net.sf.jsqlparser.expression.RowConstructor;
import net.sf.jsqlparser.expression.SignedExpression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.StructType;
import net.sf.jsqlparser.expression.TimeKeyExpression;
import net.sf.jsqlparser.expression.TranscodingFunction;
import net.sf.jsqlparser.expression.WhenClause;
import net.sf.jsqlparser.expression.WindowDefinition;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.Between;
import net.sf.jsqlparser.expression.operators.relational.EqualsTo;
import net.sf.jsqlparser.expression.operators.relational.ExistsExpression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.InExpression;
import net.sf.jsqlparser.expression.operators.relational.IsNullExpression;
import net.sf.jsqlparser.expression.operators.relational.LikeExpression;
import net.sf.jsqlparser.expression.operators.relational.NamedExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ParenthesedExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.ExplainStatement;
import net.sf.jsqlparser.statement.OutputClause;
import net.sf.jsqlparser.statement.ReferentialAction;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.alter.Alter;
import net.sf.jsqlparser.statement.alter.AlterExpression;
import net.sf.jsqlparser.statement.alter.AlterOperation;
import net.sf.jsqlparser.statement.alter.ConstraintState;
import net.sf.jsqlparser.statement.create.index.CreateIndex;
import net.sf.jsqlparser.statement.create.table.CheckConstraint;
import net.sf.jsqlparser.statement.create.table.ColDataType;
import net.sf.jsqlparser.statement.create.table.ColumnDefinition;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import net.sf.jsqlparser.statement.create.table.ExcludeConstraint;
import net.sf.jsqlparser.statement.create.table.ForeignKeyIndex;
import net.sf.jsqlparser.statement.create.table.Index;
import net.sf.jsqlparser.statement.create.table.NamedConstraint;
import net.sf.jsqlparser.statement.create.table.RowMovement;
import net.sf.jsqlparser.statement.create.view.CreateView;
import net.sf.jsqlparser.statement.create.view.ForceOption;
import net.sf.jsqlparser.statement.create.view.TemporaryOption;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.merge.Merge;
import net.sf.jsqlparser.statement.merge.MergeInsert;
import net.sf.jsqlparser.statement.merge.MergeUpdate;
import net.sf.jsqlparser.statement.select.AllColumns;
import net.sf.jsqlparser.statement.select.AllTableColumns;
import net.sf.jsqlparser.statement.select.Distinct;
import net.sf.jsqlparser.statement.select.Fetch;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.GroupByElement;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.Limit;
import net.sf.jsqlparser.statement.select.Offset;
import net.sf.jsqlparser.statement.select.OrderByElement;
import net.sf.jsqlparser.statement.select.OrderByElement.NullOrdering;
import net.sf.jsqlparser.statement.select.ParenthesedFromItem;
import net.sf.jsqlparser.statement.select.ParenthesedSelect;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectItem;
import net.sf.jsqlparser.statement.select.SetOperation;
import net.sf.jsqlparser.statement.select.SetOperationList;
import net.sf.jsqlparser.statement.select.TableFunction;
import net.sf.jsqlparser.statement.select.Top;
import net.sf.jsqlparser.statement.select.Values;
import net.sf.jsqlparser.statement.select.WithItem;
import net.sf.jsqlparser.statement.truncate.Truncate;
import net.sf.jsqlparser.statement.update.Update;
import net.sf.jsqlparser.statement.update.UpdateSet;

import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * A powerful Java SQL Formatter based on the JSQLParser.
 *
 * @author <a href="mailto:andreas@manticore-projects.com">Andreas Reichel</a>
 * @version 0.1
 */
@SuppressWarnings({"PMD.CyclomaticComplexity"})
public class JSQLFormatter {

  public static final Pattern SQUARED_BRACKET_QUOTATION_PATTERN = Pattern.compile(
      "(((?!\\[\\d+])\\[.*]\\.\\.?)|(\\.\\[\\w+( +\\w+)*])|((?!\\s\\[\\d+])\\s\\[\\w+( +\\w+)*]))");

  private static final Logger LOGGER = Logger.getLogger(JSQLFormatter.class.getName());
  public static final AnsiFormat ANSI_FORMAT_LINE_NUMBER =
      new AnsiFormat(Attribute.BRIGHT_BLACK_BACK(), Attribute.DESATURATED());
  public static final AnsiFormat ANSI_FORMAT_KEYWORD =
      new AnsiFormat(Attribute.BLUE_TEXT(), Attribute.BOLD());
  public static final AnsiFormat ANSI_FORMAT_HINT = new AnsiFormat(Attribute.BRIGHT_BLUE_TEXT());
  public static final AnsiFormat ANSI_FORMAT_OPERATOR = new AnsiFormat(Attribute.BLUE_TEXT());
  public static final AnsiFormat ANSI_FORMAT_PARAMETER =
      new AnsiFormat(Attribute.YELLOW_TEXT(), Attribute.DESATURATED());
  public static final AnsiFormat ANSI_FORMAT_ALIAS =
      new AnsiFormat(Attribute.RED_TEXT(), Attribute.BOLD(), Attribute.DESATURATED());
  public static final AnsiFormat ANSI_FORMAT_FUNCTION = new AnsiFormat(Attribute.BRIGHT_RED_TEXT());
  public static final AnsiFormat ANSI_FORMAT_TYPE =
      new AnsiFormat(Attribute.YELLOW_TEXT(), Attribute.DESATURATED());

  private static SquaredBracketQuotation squaredBracketQuotation = SquaredBracketQuotation.AUTO;
  private static Separation separation = Separation.BEFORE;
  private static Spelling keywordSpelling = Spelling.UPPER;
  private static Spelling functionSpelling = Spelling.CAMEL;
  private static Spelling objectSpelling = Spelling.LOWER;
  private static OutputFormat outputFormat = OutputFormat.PLAIN;
  private static ShowLineNumbers showLineNumbers = ShowLineNumbers.NO;
  private static StatementTerminator statementTerminator = StatementTerminator.SEMICOLON;

  private static BackSlashQuoting backSlashQuoting = BackSlashQuoting.NO;
  private static int indentWidth = 4;
  private static String indentString = "    ";
  private static int lineCount = 0;

  public static SquaredBracketQuotation getSquaredBracketQuotation() {
    return squaredBracketQuotation;
  }

  public static void setSquaredBracketQuotation(SquaredBracketQuotation squaredBracketQuotation) {
    JSQLFormatter.squaredBracketQuotation = squaredBracketQuotation;
  }

  public static BackSlashQuoting getBackSlashQuoting() {
    return backSlashQuoting;
  }

  public static void setBackSlashQuoting(BackSlashQuoting backSlashQuoting) {
    JSQLFormatter.backSlashQuoting = backSlashQuoting;
  }

  public static StatementTerminator getStatementTerminator() {
    return statementTerminator;
  }

  public static void setStatementTerminator(StatementTerminator statementTerminator) {
    JSQLFormatter.statementTerminator = statementTerminator;
  }

  public static Separation getSeparation() {
    return separation;
  }

  public static void setSeparation(Separation separation) {
    JSQLFormatter.separation = separation;
  }

  public static Spelling getKeywordSpelling() {
    return keywordSpelling;
  }

  public static void setKeywordSpelling(Spelling keywordSpelling) {
    JSQLFormatter.keywordSpelling = keywordSpelling;
  }

  public static Spelling getFunctionSpelling() {
    return functionSpelling;
  }

  public static void setFunctionSpelling(Spelling functionSpelling) {
    JSQLFormatter.functionSpelling = functionSpelling;
  }

  public static Spelling getObjectSpelling() {
    return objectSpelling;
  }

  public static void setObjectSpelling(Spelling objectSpelling) {
    JSQLFormatter.objectSpelling = objectSpelling;
  }

  public static OutputFormat getOutputFormat() {
    return outputFormat;
  }

  public static void setOutputFormat(OutputFormat outputFormat) {
    JSQLFormatter.outputFormat = outputFormat;
  }

  public static int getIndentWidth() {
    return indentWidth;
  }

  public static void setIndentWidth(int indentWidth) {
    JSQLFormatter.indentWidth = indentWidth;

    char[] chars = new char[indentWidth];
    Arrays.fill(chars, ' ');

    JSQLFormatter.indentString = new String(chars);
  }

  public static String getIndentString() {
    return indentString;
  }

  public static void setIndentString(String indentString) {
    JSQLFormatter.indentString = indentString;
  }

  private static void appendDecodeExpressionsList(ExpressionList<?> parameters, BreakLine breakLine,
      StringBuilder builder, int indent) {
    int subIndent = breakLine.equals(BreakLine.NEVER) ? indent : getSubIndent(builder, false);

    int i = 0;
    for (Expression expression : parameters) {
      switch (breakLine) {
        case AS_NEEDED:
          BreakLine bl = i == 0 || (i - 1) % 2 == 0 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;
          appendExpression(expression, null, builder, subIndent, i, parameters.size(), true, bl);
          break;

        default:
          appendExpression(expression, null, builder, subIndent, i, parameters.size(), true,
              breakLine);
      }
      i++;
    }
  }

  static String toCamelCase(String s) {
    StringBuilder camelCaseString = new StringBuilder();

    String[] nameParts = s.split("_");
    int i = 0;
    for (String part : nameParts) {
      if (i > 0) {
        camelCaseString.append("_");
      }
      camelCaseString.append(part.substring(0, 1).toUpperCase())
          .append(part.substring(1).toLowerCase());
      i++;
    }
    return camelCaseString.toString();
  }

  private static StringBuilder appendKeyWord(StringBuilder builder, OutputFormat format,
      String keyword, String before, String after) {

    String s;
    switch (keywordSpelling) {
      case UPPER:
        s = keyword.toUpperCase();
        break;
      case LOWER:
        s = keyword.toLowerCase();
        break;
      case CAMEL:
        s = toCamelCase(keyword);
        break;
      default:
        s = keyword;
    }

    switch (format) {
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_KEYWORD.format(s)).append(after);
        break;
      case HTML:
        builder.append(before).append("<span style=\"color:blue; font-style:bold;\">").append(s)
            .append("</span>").append(after);
        break;
      default:
        builder.append(before).append(s).append(after);
        break;
    }
    return builder;
  }

  private static StringBuilder appendNormalizingTrailingWhiteSpace(StringBuilder builder,
      String s) {
    if (builder.length() > 0) {
      int pos = builder.length() - 1;
      char lastChar = builder.charAt(pos);
      if (lastChar == ' ') {
        while (lastChar == ' ' && pos > 0) {
          pos--;
          lastChar = builder.charAt(pos);
        }
        builder.setLength(pos + 1);
      }
    }
    builder.append(s);
    return builder;
  }

  private static StringBuilder appendNormalizedLineBreak(StringBuilder builder) {
    switch (showLineNumbers) {
      case YES:
        lineCount++;

        String lineCountStr = "0000" + lineCount;
        lineCountStr = lineCountStr.substring(lineCountStr.length() - 5);
        lineCountStr += " | ";

        StringBuilder fillerStr = new StringBuilder();
        int adjust = getIndentWidth() - lineCountStr.length() % getIndentWidth();
        fillerStr.append(" ".repeat(Math.max(0, adjust)));


        switch (outputFormat) {
          case ANSI:
            return appendNormalizingTrailingWhiteSpace(builder, Ansi.RESET
                + ANSI_FORMAT_LINE_NUMBER.format("\n" + lineCountStr) + Ansi.RESET + fillerStr);
          case HTML:
            return builder.append("\n")
                .append("<span style=\"color:light-grey; font-size:8pt; font-style:normal;\">")
                .append(lineCountStr).append("</span>").append(fillerStr);
          default:
            return appendNormalizingTrailingWhiteSpace(builder, "\n" + lineCountStr + fillerStr);
        }
      default:
        return appendNormalizingTrailingWhiteSpace(builder, "\n");
    }
  }

  private static StringBuilder appendHint(StringBuilder builder, OutputFormat format, String hint,
      String before, String after) {

    String s;
    switch (keywordSpelling) {
      case UPPER:
        s = hint.toUpperCase();
        break;
      case LOWER:
        s = hint.toLowerCase();
        break;
      case CAMEL:
        s = toCamelCase(hint);
        break;
      default:
        s = hint;
    }

    switch (format) {
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_HINT.format(s)).append(after);
        break;
      case HTML:
        builder.append(before).append("<span style=\"color:light-blue; font-style:thin\">")
            .append(s).append("</span>").append(after);
        break;
      default:
        builder.append(before).append(s).append(after);
        break;
    }
    return builder;
  }

  private static StringBuilder appendOperator(StringBuilder builder, OutputFormat format,
      String operator, String before, String after) {

    String s;
    switch (keywordSpelling) {
      case UPPER:
        s = operator.toUpperCase();
        break;
      case LOWER:
        s = operator.toLowerCase();
        break;
      case CAMEL:
        s = toCamelCase(operator);
        break;
      default:
        s = operator;
    }

    switch (format) {
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_OPERATOR.format(s)).append(after);
        break;
      case HTML:
        builder.append(before).append("<span style=\"color:blue; font-style:normal;\">").append(s)
            .append("</span>").append(after);
        break;
      default:
        builder.append(before).append(s).append(after);
        break;
    }
    return builder;
  }

  private static StringBuilder appendValue(StringBuilder builder, OutputFormat format, String value,
      String before, String after) {
    switch (format) {
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_PARAMETER.format(value)).append(after);
        break;
      case HTML:
        builder.append(before).append("<span style=\"color:yellow; font-style:normal;\">")
            .append(value).append("</span>").append(after);
        break;
      default:
        builder.append(before).append(value).append(after);
        break;
    }
    return builder;
  }

  private static StringBuilder appendAlias(StringBuilder builder, OutputFormat format, String alias,
      String before, String after) {

    String s;
    if (alias.trim().startsWith("\"") || alias.trim().startsWith("[")) {
      s = alias;
    } else {
      switch (objectSpelling) {
        case UPPER:
          s = alias.toUpperCase();
          break;
        case LOWER:
          s = alias.toLowerCase();
          break;
        case CAMEL:
          s = toCamelCase(alias);
          break;
        default:
          s = alias;
      }
    }

    switch (format) {
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_ALIAS.format(s)).append(after);
        break;
      case HTML:
        builder.append(before).append("<span style=\"color:red; font-style:bold;\">").append(s)
            .append("</span>").append(after);
        break;
      default:
        builder.append(before).append(s).append(after);
        break;
    }
    return builder;
  }

  private static StringBuilder appendAlias(StringBuilder builder, OutputFormat format, Alias alias,
      String before, String after) {
    if (alias != null) {
      builder.append(before);

      if (alias.isUseAs()) {
        appendKeyWord(builder, outputFormat, "AS", "", " ");
      }

      String s;
      if (alias.getName().trim().startsWith("\"") || alias.getName().trim().startsWith("[")) {
        s = alias.getName();
      } else {
        switch (objectSpelling) {
          case UPPER:
            s = alias.getName().toUpperCase();
            break;
          case LOWER:
            s = alias.getName().toLowerCase();
            break;
          case CAMEL:
            s = toCamelCase(alias.getName());
            break;
          default:
            s = alias.getName();
        }
      }

      switch (format) {
        case ANSI:
          builder.append(ANSI_FORMAT_ALIAS.format(s));
          break;
        case HTML:
          builder.append("<span style=\"color:red; font-style:bold;\">").append(s)
              .append("</span>");
          break;
        default:
          builder.append(s);
          break;
      }

      if (alias.getAliasColumns() != null && !alias.getAliasColumns().isEmpty()) {
        int i = 0;
        builder.append("(");
        for (AliasColumn col : alias.getAliasColumns()) {
          appendObjectName(builder, outputFormat, col.name, i++ > 0 ? ", " : "", "");
          if (col.colDataType != null) {
            appendKeyWord(builder, outputFormat, col.colDataType.toString(), " ", "");
          }
        }
        builder.append(")");
      }
      builder.append(after);
    }

    return builder;
  }

  private static StringBuilder appendObjectName(StringBuilder builder, OutputFormat format,
      String objectName, String before, String after) {

    StringBuilder nameBuilder = new StringBuilder();

    int j = 0;
    String[] parts = objectName.contains(".") ? objectName.split("\\.") : new String[] {objectName};
    for (String w : parts) {
      if (j > 0) {
        nameBuilder.append(".");
      }
      if (w.trim().startsWith("\"") || w.trim().startsWith("[")) {
        nameBuilder.append(w);
      } else {
        switch (objectSpelling) {
          case UPPER:
            nameBuilder.append(w.toUpperCase());
            break;
          case LOWER:
            nameBuilder.append(w.toLowerCase());
            break;
          case CAMEL:
            nameBuilder.append(toCamelCase(w));
            break;
        }
      }
      j++;
    }

    switch (format) {
      default:
        builder.append(before).append(nameBuilder).append(after);
        break;
    }
    return builder;
  }

  private static StringBuilder appendFunction(StringBuilder builder, OutputFormat format,
      String function, String before, String after) {

    String s;
    switch (functionSpelling) {
      case UPPER:
        s = function.toUpperCase();
        break;
      case LOWER:
        s = function.toLowerCase();
        break;
      case CAMEL:
        s = toCamelCase(function);
        break;
      default:
        s = function;
    }

    switch (format) {
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_FUNCTION.format(s)).append(after);
        break;
      case HTML:
        builder.append(before).append("<span style=\"color:light-red; font-style:italic;\">")
            .append(s).append("</span>").append(after);
        break;
      default:
        builder.append(before).append(s).append(after);
        break;
    }
    return builder;
  }

  private static StringBuilder appendType(StringBuilder builder, OutputFormat format, String type,
      String before, String after) {

    String s;
    switch (keywordSpelling) {
      case UPPER:
        s = type.toUpperCase();
        break;
      case LOWER:
        s = type.toLowerCase();
        break;
      case CAMEL:
        s = toCamelCase(type);
        break;
      default:
        s = type;
    }

    switch (format) {
      case ANSI:
        builder.append(before).append(ANSI_FORMAT_TYPE.format(s)).append(after);
        break;
      case HTML:
        builder.append(before).append("<span style=\"color:yellow; font-style:normal;\">").append(s)
            .append("</span>").append(after);
        break;
      default:
        builder.append(before).append(s).append(after);
        break;
    }
    return builder;
  }

  private static int getLastLineLength(StringBuilder builder) {
    String lastLine = builder.substring(builder.lastIndexOf("\n") + 1);
    lastLine = lastLine.replaceAll("\u001B\\[[;\\d]*[ -/]*[@-~]", "");

    return lastLine.length();
  }

  private static int getSubIndent(StringBuilder builder, boolean moveToTab) {
    int lastLineLength = getLastLineLength(builder);

    int subIndent = lastLineLength / indentWidth + (lastLineLength % indentWidth > 0 ? 1 : 0);

    for (int i = lastLineLength; moveToTab && i < subIndent * indentWidth; i++) {
      builder.append(" ");
    }

    return subIndent;
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendDelete(StringBuilder builder, Delete delete, int indent) {
    List<WithItem<?>> withItems = delete.getWithItemsList();
    if (withItems != null && !withItems.isEmpty()) {
      int i = 0;
      appendKeyWord(builder, outputFormat, "WITH", "", " ");

      for (WithItem<?> withItem : withItems) {
        appendWithItem(withItem, builder, indent, i, withItems.size());
        i++;
      }

      appendNormalizedLineBreak(builder);
    }
    appendKeyWord(builder, outputFormat, "DELETE", "", " ");

    OracleHint oracleHint = delete.getOracleHint();
    if (oracleHint != null) {
      appendHint(builder, outputFormat, oracleHint.toString(), "", " ");
    }

    List<Table> tables = delete.getTables();

    if (tables != null && !tables.isEmpty()) {
      int j = 0;
      for (Table table : tables) {
        switch (separation) {
          case AFTER:
            appendObjectName(builder, outputFormat, table.getFullyQualifiedName(), "",
                j < tables.size() - 1 ? ", " : " ");
            break;
          case BEFORE:
          default:
            appendObjectName(builder, outputFormat, table.getFullyQualifiedName(),
                j > 0 ? ", " : "", " ");
            break;
        }

        j++;
      }
    }

    appendKeyWord(builder, outputFormat, "FROM", "", " ");

    Table table = delete.getTable();
    Alias alias = table.getAlias();

    appendTable(table, alias, builder);

    List<Join> joins = delete.getJoins();
    appendJoins(joins, builder, indent);

    Expression whereExpression = delete.getWhere();
    appendWhere(whereExpression, builder, indent);

    List<OrderByElement> orderByElements = delete.getOrderByElements();
    appendOrderByElements(orderByElements, builder, indent);

    Limit limit = delete.getLimit();
    if (limit != null) {
      appendNormalizedLineBreak(builder);
      for (int j = 0; j < indent; j++) {
        builder.append(indentString);
      }

      appendKeyWord(builder, outputFormat, "LIMIT", "", "");

      Expression rowCount = limit.getRowCount();
      if (rowCount instanceof AllValue || rowCount instanceof NullValue) {
        // no offset allowed
        appendKeyWord(builder, outputFormat, "NULL", " ", "");
      } else {
        if (null != limit.getOffset()) {
          appendExpression(limit.getOffset(), null, builder, indent, 0, 1, false, BreakLine.NEVER);
          builder.append(", ");
        }
        if (null != limit.getRowCount()) {
          appendExpression(limit.getRowCount(), null, builder, indent, 0, 1, false,
              BreakLine.NEVER);
        }
      }
    }
  }

  public static File getAbsoluteFile(String filename) {
    String homePath = new File(System.getProperty("user.home")).toURI().getPath();

    String _filename = filename.replaceFirst("~", Matcher.quoteReplacement(homePath))
        .replaceFirst("\\$\\{user.home}", Matcher.quoteReplacement(homePath));

    File f = new File(_filename);
    if (!f.isAbsolute()) {
      Path basePath = Paths.get("").toAbsolutePath();

      Path resolvedPath = basePath.resolve(filename);
      Path absolutePath = resolvedPath.normalize();
      f = absolutePath.toFile();
    }
    return f;
  }

  public static String getAbsoluteFileName(String filename) {
    return getAbsoluteFile(filename).getAbsolutePath();
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  public static ArrayList<Exception> verify(String sqlStr, String... options) {
    ArrayList<Exception> exceptions = new ArrayList<>();

    applyFormattingOptions(options);

    Pattern SEMICOLON_PATTERN = Pattern.compile(";|$");
    Matcher m = SEMICOLON_PATTERN.matcher(sqlStr);
    ArrayList<Integer> semicolons = new ArrayList<>();

    while (m.find()) {
      semicolons.add(m.start());
    }

    m = CommentMap.COMMENT_PATTERN.matcher(sqlStr);
    while (m.find()) {
      int start = m.start();
      int end = m.end();

      int n = semicolons.size();
      for (int i = n - 1; i >= 0; i--) {
        int pos = semicolons.get(i);
        if (start <= pos && pos < end) {
          semicolons.remove(i);
        }
      }
    }

    int pos = 0;
    int length = sqlStr.length();
    int n = semicolons.size();
    for (int i = 0; i < n; i++) {
      int semicolonPos = semicolons.get(i);

      if (semicolonPos > pos) {
        String statementSql = sqlStr.substring(pos, Integer.min(semicolonPos + 1, length));
        pos = semicolonPos + 1;

        // we are at the end and find only remaining whitespace
        if (statementSql.trim().isEmpty()) {
          break;
        }

        boolean useSquareBracketQuotation;
        switch (squaredBracketQuotation) {
          case YES:
            useSquareBracketQuotation = true;
            LOGGER.log(Level.FINE, "Square Bracket Quotation set as {0}.",
                useSquareBracketQuotation);
            break;
          case NO:
            useSquareBracketQuotation = false;
            LOGGER.log(Level.FINE, "Square Bracket Quotation set as {0}.",
                useSquareBracketQuotation);
            break;
          case AUTO:
          default:
            useSquareBracketQuotation =
                SQUARED_BRACKET_QUOTATION_PATTERN.matcher(statementSql).find();
            LOGGER.log(Level.FINE, "Square Bracket Quotation auto-detected as {0}.",
                useSquareBracketQuotation);
        }
        try {
          CCJSqlParserUtil.parse(statementSql,
              parser -> parser.withSquareBracketQuotation(useSquareBracketQuotation));

        } catch (Exception ex1) {
          exceptions.add(new Exception("Cannot parse the Statement:\n" + statementSql, ex1));
        }
      } else {
        break;
      }
    }
    return exceptions;
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.ExcessiveMethodLength"})
  public static String format(String sqlStr, String... options) throws Exception {
    applyFormattingOptions(options);

    StringBuilder builder = new StringBuilder();

    int indent = 0;
    lineCount = 0;

    // Pattern SEMICOLON_PATTERN =
    // Pattern.compile("((?:(?:'[^']*+')|(?:\"[^\"]*+\")|(?:--.*)|(?:\\/\\*[^\\*\\/]*+\\*\\/)|[^;])*+);");
    Pattern SEMICOLON_PATTERN = Pattern.compile(";|$|\\n\\n\\n");
    Matcher m = SEMICOLON_PATTERN.matcher(sqlStr);
    ArrayList<Integer> semicolons = new ArrayList<>();

    while (m.find()) {
      semicolons.add(m.start());
    }

    m = CommentMap.COMMENT_PATTERN.matcher(sqlStr);
    while (m.find()) {
      int start = m.start();
      int end = m.end();

      int n = semicolons.size();
      for (int i = n - 1; i >= 0; i--) {
        int pos = semicolons.get(i);
        if (start <= pos && pos < end) {
          semicolons.remove(i);
        }
      }
    }

    int pos = 0;
    int length = sqlStr.length();
    int n = semicolons.size();
    for (int i = 0; i < n; i++) {
      int semicolonPos = semicolons.get(i);

      if (semicolonPos > pos) {
        String statementSql = sqlStr.substring(pos, Integer.min(semicolonPos + 1, length));
        pos = semicolonPos + 1;

        // we are at the end and find only remaining whitespace
        // or comments
        if (statementSql.trim().isEmpty() || i == n - 1 && statementSql.trim().startsWith("--")
            || i == n - 1 && statementSql.trim().startsWith("/*")) {
          break;
        }

        StringBuilder statementBuilder = new StringBuilder();

        boolean useSquareBracketQuotation;
        switch (squaredBracketQuotation) {
          case YES:
            useSquareBracketQuotation = true;
            LOGGER.log(Level.FINE, "Square Bracket Quotation set as {0}.",
                useSquareBracketQuotation);
            break;
          case NO:
            useSquareBracketQuotation = false;
            LOGGER.log(Level.FINE, "Square Bracket Quotation set as {0}.",
                useSquareBracketQuotation);
            break;
          case AUTO:
          default:
            useSquareBracketQuotation =
                SQUARED_BRACKET_QUOTATION_PATTERN.matcher(statementSql).find();
            LOGGER.log(Level.FINE, "Square Bracket Quotation auto-detected as {0}.",
                useSquareBracketQuotation);
        }

        boolean useBackSlashQuoting;
        if (Objects.requireNonNull(backSlashQuoting) == BackSlashQuoting.YES) {
          useBackSlashQuoting = true;
          LOGGER.log(Level.FINE, "Back Slash Quoting set as {0}.", true);
        } else {
          useBackSlashQuoting = false;
          LOGGER.log(Level.FINE, "Back Slash Quoting set as {0}.", false);
        }

        CommentMap commentMap = new CommentMap(statementSql);

        Pattern DIRECTIVE_PATTERN = Pattern.compile("@JSQLFormatter\\s?\\((.*)\\)");
        for (Comment comment : commentMap.values()) {
          Matcher m1 = DIRECTIVE_PATTERN.matcher(comment.text);
          if (m1.find()) {
            String[] keyValuePairs = m1.group(1).split(",");
            applyFormattingOptions(keyValuePairs);
          }
        }

        try {
          Statement statement =
              CCJSqlParserUtil.parse(CCJSqlParserUtil.sanitizeSingleSql(statementSql),
                  parser -> parser.withSquareBracketQuotation(useSquareBracketQuotation)
                      .withBackslashEscapeCharacter(useBackSlashQuoting).withTimeOut(60000)
                      .withUnsupportedStatements(false));

          if (statement instanceof Select) {
            Select select = (Select) statement;
            appendSelect(select, statementBuilder, indent, true, false);

          } else if (statement instanceof Update) {
            Update update = (Update) statement;
            appendUpdate(statementBuilder, update, indent);

          } else if (statement instanceof Insert) {
            Insert insert = (Insert) statement;
            appendInsert(statementBuilder, insert, indent);

          } else if (statement instanceof Merge) {
            Merge merge = (Merge) statement;
            appendMerge(statementBuilder, merge, indent);

          } else if (statement instanceof Delete) {
            Delete delete = (Delete) statement;
            appendDelete(statementBuilder, delete, indent);

          } else if (statement instanceof Truncate) {
            Truncate truncate = (Truncate) statement;
            appendTruncate(statementBuilder, truncate);

          } else if (statement instanceof CreateTable) {
            CreateTable createTable = (CreateTable) statement;
            appendCreateTable(statementBuilder, createTable, indent);

          } else if (statement instanceof CreateIndex) {
            CreateIndex createIndex = (CreateIndex) statement;
            appendCreateIndex(statementBuilder, createIndex, indent);

          } else if (statement instanceof CreateView) {
            CreateView createView = (CreateView) statement;
            appendCreateView(statementBuilder, createView, indent);

          } else if (statement instanceof Alter) {
            Alter alter = (Alter) statement;
            appendAlter(statementBuilder, alter, indent);

          } else if (statement instanceof ExplainStatement) {
            ExplainStatement explainStatement = (ExplainStatement) statement;
            appendNormalizedLineBreak(builder);
            appendKeyWord(builder, outputFormat, explainStatement.getKeyword(), "", " ");

            if (explainStatement.getTable() == null) {

              final LinkedHashMap<ExplainStatement.OptionType, ExplainStatement.Option> options1 =
                  explainStatement.getOptions();
              if (options1 != null && !options1.isEmpty()) {
                builder.append(options1.values().stream().map(ExplainStatement.Option::formatOption)
                    .collect(Collectors.joining(" ")));
              }
              appendSelect(explainStatement.getStatement(), builder, indent, true, false);

            } else {
              appendTable(explainStatement.getTable(), explainStatement.getTable().getAlias(),
                  builder);
            }

          } else if (statement != null) {
            try {
              statementBuilder.append("\n").append(statement);
            } catch (Exception ex) {
              throw new UnsupportedOperationException(
                  "The " + statement.getClass().getName() + " Statement is not supported yet.");
            }
          }

          switch (statementTerminator) {
            case SEMICOLON:
              appendNormalizedLineBreak(statementBuilder).append(";\n");
              break;
            case NONE:
              appendNormalizedLineBreak(statementBuilder).append("\n\n");
              break;
            case GO:
              appendNormalizedLineBreak(statementBuilder).append("GO\n");
              break;
            case BACKSLASH:
              appendNormalizedLineBreak(statementBuilder).append("\\\n");
              break;
          }

          builder.append(commentMap.isEmpty() ? statementBuilder
              : commentMap.insertComments(statementBuilder, outputFormat));

        } catch (Exception ex1) {
          if (statementSql.trim().length() <= commentMap.getLength()) {
            LOGGER.info("Found only comments, but no SQL code.");
            builder.append(statementSql);
          } else {

            LOGGER.log(Level.WARNING, "Failed for format statement between \n" + statementSql, ex1);

            builder.append("-- failed to format start\n").append(statementSql)
                .append("\n-- failed to format end\n").append("\n");
          }
        }
      } else {
        break;
      }
    }

    if (outputFormat == OutputFormat.HTML) {
      builder = new StringBuilder().append("<html>\n").append("<head>\n")
          .append("<title>SQL Statement's Java Object Tree</title>\n").append("</head>\n")
          .append("<body>\n").append("<pre style=\"font-size:-2;background-color:#EFEFEF;\">\n")
          .append(builder).append("\n</pre>\n").append("</body>\n").append("</html>");
    }

    return builder.toString().trim();
  }

  public static StringBuilder formatToJava(String sqlStr, int indent, String... options)
      throws Exception {
    String formatted = format(sqlStr, options);
    StringReader stringReader = new StringReader(formatted);
    BufferedReader bufferedReader = new BufferedReader(stringReader);
    String line;
    StringBuilder builder = new StringBuilder();
    int i = 0;
    while ((line = bufferedReader.readLine()) != null) {
      if (i > 0) {
        builder.append(" ".repeat(Math.max(0, indent - 2)));
        builder.append("+ ");
      } else {
        builder.append(" ".repeat(Math.max(0, indent)));
      }
      builder.append("\"").append(line).append("\"\n");
      i++;
    }
    return builder;
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  public static void applyFormattingOptions(String[] options) {
    // set the formatting options
    if (options != null) {
      for (String s : options) {
        String[] o = s.split("=");
        if (o.length == 2) {
          LOGGER.log(Level.FINE, "Found Formatting Option {0} = {1}", o);

          String key = o[0].trim();
          String value = o[1].trim();

          if (key.equalsIgnoreCase(FormattingOption.OUTPUT_FORMAT.toString())) {
            try {
              outputFormat = OutputFormat.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.KEYWORD_SPELLING.toString())) {
            try {
              keywordSpelling = Spelling.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.FUNCTION_SPELLING.toString())) {
            try {
              functionSpelling = Spelling.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.OBJECT_SPELLING.toString())) {
            try {
              objectSpelling = Spelling.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.SEPARATION.toString())) {
            try {
              separation = Separation.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.SQUARE_BRACKET_QUOTATION.toString())) {
            try {
              squaredBracketQuotation = SquaredBracketQuotation.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.BACKSLASH_QUOTING.toString())) {
            try {
              backSlashQuoting = BackSlashQuoting.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.SHOW_LINE_NUMBERS.toString())) {
            try {
              showLineNumbers = ShowLineNumbers.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else if (key.equalsIgnoreCase(FormattingOption.INDENT_WIDTH.toString())) {
            try {
              indentWidth = Integer.parseInt(value);

              char[] chars = new char[indentWidth];
              Arrays.fill(chars, ' ');

              indentString = new String(chars);
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }
          } else if (key.equalsIgnoreCase(FormattingOption.STATEMENT_TERMINATOR.toString())) {
            try {
              statementTerminator = StatementTerminator.valueOf(value.toUpperCase());
            } catch (Exception ex) {
              LOGGER.log(Level.WARNING, "Formatting Option {0} does not support {1} ", o);
            }

          } else {
            LOGGER.log(Level.WARNING, "Unknown Formatting Option {0} = {1} ", o);
          }

        } else {
          LOGGER.log(Level.WARNING, "Invalid Formatting Option {0}", s);
        }
      }
    }
  }

  private static void appendMerge(StringBuilder builder, Merge merge, int indent) {

    List<WithItem<?>> withItems = merge.getWithItemsList();
    if (withItems != null && !withItems.isEmpty()) {
      int i = 0;
      appendKeyWord(builder, outputFormat, "WITH", "", " ");

      for (WithItem<?> withItem : withItems) {
        appendWithItem(withItem, builder, indent, i, withItems.size());
        i++;
      }

      appendNormalizedLineBreak(builder);
    }

    appendKeyWord(builder, outputFormat, "MERGE", "", " ");
    OracleHint oracleHint = merge.getOracleHint();
    if (oracleHint != null) {
      appendHint(builder, outputFormat, oracleHint.toString(), "", " ");
    }

    appendKeyWord(builder, outputFormat, "INTO", "", " ");

    Table table = merge.getTable();
    Alias alias = table.getAlias();

    appendTable(table, alias, builder);

    appendNormalizedLineBreak(builder);
    for (int j = 0; j < indent + 1; j++) {
      builder.append(indentString);
    }
    appendKeyWord(builder, outputFormat, "USING", "", " ");

    FromItem fromItem = merge.getFromItem();
    appendFromItem(fromItem, builder, indent, 0, 1);

    Expression onExpression = merge.getOnCondition();
    if (onExpression != null) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(Math.max(0, indent + 2)));
      appendKeyWord(builder, outputFormat, "ON", "", " ");
      appendExpression(onExpression, null, builder, indent + 2, 0, 1, false, BreakLine.AS_NEEDED);

      appendNormalizingTrailingWhiteSpace(builder, " ");
    }

    MergeInsert insert = merge.getMergeInsert();
    MergeUpdate update = merge.getMergeUpdate();
    if (merge.isInsertFirst()) {
      appendMergeInsert(insert, builder, indent, 0);
      appendMergeUpdate(update, builder, indent);
    } else {
      appendMergeUpdate(update, builder, indent);
      appendMergeInsert(insert, builder, indent, 0);
    }

    appendOutputClaus(merge.getOutputClause(), builder, indent);
  }

  private static void appendOutputClaus(OutputClause outputClause, StringBuilder builder,
      int indent) {
    if (outputClause != null) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(Math.max(0, indent)));
      appendKeyWord(builder, outputFormat, "OUTPUT", "", " ");
      int i = 0;
      int subIndent = getSubIndent(builder, outputClause.getSelectItemList().size() > 3);
      appendSelectItemList(outputClause.getSelectItemList(), builder, subIndent, i,
          BreakLine.AS_NEEDED, indent);

      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(Math.max(0, indent + 1)));
      appendKeyWord(builder, outputFormat, "INTO", "", " ");

      if (outputClause.getOutputTable() != null) {
        Table table = outputClause.getOutputTable();
        appendTable(table, table.getAlias(), builder);

        appendStringList(outputClause.getColumnList(), builder, indent + 1, true,
            BreakLine.AS_NEEDED);
      } else if (outputClause.getTableVariable() != null) {
        appendObjectName(builder, outputFormat, outputClause.getTableVariable().toString(), " ",
            "");
      }
    }
  }

  public static void appendMergeUpdate(MergeUpdate update, StringBuilder builder, int indent) {
    if (update != null) {
      appendNormalizedLineBreak(builder);

      builder.append(indentString.repeat(indent));
      appendKeyWord(builder, outputFormat, "WHEN", "", " ");
      appendKeyWord(builder, outputFormat, "MATCHED", "", " ");
      appendKeyWord(builder, outputFormat, "THEN", "", "\n");

      builder.append(indentString.repeat(indent + 1));
      appendKeyWord(builder, outputFormat, "UPDATE", "", " ");
      appendKeyWord(builder, outputFormat, "SET", "", " ");

      int subIndent = getSubIndent(builder, true);

      appendUpdateSets(builder, update.getUpdateSets(), subIndent);

      Expression whereCondition = update.getWhereCondition();
      if (whereCondition != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent + 1));
        appendKeyWord(builder, outputFormat, "WHERE", "", " ");

        subIndent = getSubIndent(builder, true);

        appendExpression(whereCondition, null, builder, subIndent, 0, 1, false,
            BreakLine.AFTER_FIRST);
      }

      Expression deleteWhereCondition = update.getDeleteWhereCondition();
      if (deleteWhereCondition != null) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; j < indent + 1; j++) {
          builder.append(indentString);
        }
        appendKeyWord(builder, outputFormat, "DELETE", "", " ");
        appendKeyWord(builder, outputFormat, "WHERE", "", " ");

        subIndent = getSubIndent(builder, true);

        appendExpression(deleteWhereCondition, null, builder, subIndent, 0, 1, false,
            BreakLine.AFTER_FIRST);
      }
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  public static void appendMergeInsert(MergeInsert insert, StringBuilder builder, int indent,
      int i) {
    if (insert != null) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent));
      appendKeyWord(builder, outputFormat, "WHEN", "", " ");
      appendKeyWord(builder, outputFormat, "NOT", "", " ");
      appendKeyWord(builder, outputFormat, "MATCHED", "", " ");
      appendKeyWord(builder, outputFormat, "THEN", "", "\n");

      builder.append(indentString.repeat(indent + 1));
      appendKeyWord(builder, outputFormat, "INSERT", "", " ");

      List<Column> columns = insert.getColumns();
      List<Expression> expressions = insert.getValues();

      int k = i;
      if (columns != null && !columns.isEmpty()) {
        builder.append("( ");
        int subIndent = getSubIndent(builder, false);

        for (Column column : columns) {
          appendExpression(column, null, builder, subIndent, k++, columns.size(), true,
              BreakLine.AFTER_FIRST);
        }
        appendNormalizingTrailingWhiteSpace(builder, " )\n");
      }

      if (columns != null && !columns.isEmpty()) {
        builder.append(indentString.repeat(indent + 1));
      }
      appendKeyWord(builder, outputFormat, "VALUES", "", " ( ");

      int subIndent = getSubIndent(builder, false);
      if (expressions != null) {
        int j = 0;
        for (Expression expression : expressions) {
          appendExpression(expression, null, builder, subIndent, j++, expressions.size(), true,
              BreakLine.AFTER_FIRST);
        }
      }
      appendNormalizingTrailingWhiteSpace(builder, " )");

      Expression whereCondition = insert.getWhereCondition();
      if (whereCondition != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent + 1));
        appendKeyWord(builder, outputFormat, "WHERE", "", " ");

        subIndent = getSubIndent(builder, true);

        appendExpression(whereCondition, null, builder, subIndent, 0, 1, false,
            BreakLine.AFTER_FIRST);
      }
    }
  }

  private static void appendInsert(StringBuilder builder, Insert insert, int indent) {
    List<WithItem<?>> withItems = insert.getWithItemsList();
    if (withItems != null && !withItems.isEmpty()) {
      int i = 0;
      appendKeyWord(builder, outputFormat, "WITH", "", " ");

      for (WithItem<?> withItem : withItems) {
        appendWithItem(withItem, builder, indent, i, withItems.size());
        i++;
      }

      appendNormalizedLineBreak(builder);
    }

    appendKeyWord(builder, outputFormat, "INSERT", "", " ");
    OracleHint oracleHint = insert.getOracleHint();
    if (oracleHint != null) {
      appendHint(builder, outputFormat, oracleHint.toString(), "", " ");
    }
    appendKeyWord(builder, outputFormat, "INTO", "", " ");

    Table table = insert.getTable();
    Alias alias = table.getAlias();

    appendTable(table, alias, builder);

    List<Column> columns = insert.getColumns();
    if (columns != null) {
      int i = 0;
      builder.append(" (");
      for (Column column : columns) {
        appendExpression(column, null, builder, indent + 1, i, columns.size(), true,
            BreakLine.ALWAYS);
        i++;
      }
      appendNormalizingTrailingWhiteSpace(builder, " ) ");
    }
    appendNormalizedLineBreak(builder);
    Select select = insert.getSelect();
    appendSelect(select, builder, indent, false, false);
  }

  private static void appendUpdate(StringBuilder builder, Update update, int indent) {
    List<WithItem<?>> withItems = update.getWithItemsList();
    if (withItems != null && !withItems.isEmpty()) {
      int i = 0;
      appendKeyWord(builder, outputFormat, "WITH", "", " ");

      for (WithItem<?> withItem : withItems) {
        appendWithItem(withItem, builder, indent, i, withItems.size());
        i++;
      }

      appendNormalizedLineBreak(builder);
    }

    appendKeyWord(builder, outputFormat, "UPDATE", "", " ");

    OracleHint oracleHint = update.getOracleHint();
    if (oracleHint != null) {
      appendHint(builder, outputFormat, oracleHint.toString(), "", " ");
    }

    Table table = update.getTable();
    Alias alias = table.getAlias();

    appendTable(table, alias, builder);

    if (update.getStartJoins() != null) {
      appendJoins(update.getStartJoins(), builder, indent);
    }

    appendNormalizedLineBreak(builder);
    builder.append(indentString.repeat(indent));
    appendKeyWord(builder, outputFormat, "SET", "", " ");

    final int subIndent = getSubIndent(builder, true);
    appendUpdateSets(builder, update.getUpdateSets(), subIndent);

    if (update.getFromItem() != null) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent));
      appendKeyWord(builder, outputFormat, "FROM", "", " ");
      appendFromItem(update.getFromItem(), builder, indent, 0, 1);
    }

    List<Join> joins = update.getJoins();
    appendJoins(joins, builder, indent);

    Expression whereExpression = update.getWhere();
    appendWhere(whereExpression, builder, indent);

    List<OrderByElement> orderByElements = update.getOrderByElements();
    appendOrderByElements(orderByElements, builder, indent);
  }

  private static void appendUpdateSets(StringBuilder builder, List<UpdateSet> updateSets,
      int subIndent) {
    int i = 0;
    int n = updateSets.size();
    for (UpdateSet updateSet : updateSets) {
      if (i > 0) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(subIndent));
      }

      switch (separation) {
        case BEFORE:
          builder.append(i > 0 ? ", " : "");
      }

      appendExpressionList(updateSet.getColumns(), builder, subIndent, BreakLine.AFTER_FIRST);
      appendNormalizingTrailingWhiteSpace(builder, " = ");
      appendExpressionList(updateSet.getValues(), builder, subIndent, BreakLine.AFTER_FIRST);

      switch (separation) {
        case AFTER:
          appendNormalizingTrailingWhiteSpace(builder, i < n - 1 ? ", " : "");
          break;
      }

      i++;
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.ExcessiveMethodLength"})
  private static void appendSelect(Select select, StringBuilder builder, int indent,
      boolean breakLineBefore, boolean indentFirstLine) {

    List<WithItem<?>> withItems = select.getWithItemsList();
    if (withItems != null && !withItems.isEmpty()) {
      int i = 0;
      if (breakLineBefore) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; indentFirstLine && j < indent; j++) {
          builder.append(indentString);
        }
      }
      appendKeyWord(builder, outputFormat, "WITH", "", " ");

      for (WithItem<?> withItem : withItems) {
        appendWithItem(withItem, builder, indent, i, withItems.size());
        i++;
      }
    }

    // All Known Implementing Classes: PlainSelect, SetOperationList,
    // ValuesStatement, WithItem
    if (select instanceof PlainSelect) {
      PlainSelect plainSelect = (PlainSelect) select;

      int i = 0;
      if (breakLineBefore || withItems != null && !withItems.isEmpty()) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; indentFirstLine && j < indent; j++) {
          builder.append(indentString);
        }
      }

      appendKeyWord(builder, outputFormat, "SELECT", "", " ");

      OracleHint oracleHint = plainSelect.getOracleHint();
      if (oracleHint != null) {
        appendHint(builder, outputFormat, oracleHint.toString(), "", " ");
      }

      Top top = plainSelect.getTop();
      if (top != null) {
        appendKeyWord(builder, outputFormat, "TOP", "", top.hasParenthesis() ? "( " : " ");
        appendExpression(top.getExpression(), null, builder, 0, 0, 0, false, BreakLine.AS_NEEDED);
        if (top.hasParenthesis()) {
          builder.append(" )");
        }
        appendNormalizingTrailingWhiteSpace(builder, " ");

        if (top.isPercentage()) {
          appendKeyWord(builder, outputFormat, "PERCENT", "", " ");
        }

        if (top.isWithTies()) {
          appendKeyWord(builder, outputFormat, "WITH TIES", "", " ");
        }
      }

      Distinct distinct = plainSelect.getDistinct();
      if (distinct != null) {
        if (distinct.isUseUnique()) {
          // @todo: implement Use Unique Distinct clause
          throw new UnsupportedOperationException("Unique DISTINCT not supported yet.");
        }

        if (distinct.getOnSelectItems() != null && !distinct.getOnSelectItems().isEmpty()) {
          // @todo: implement Use Unique Distinct clause
          throw new UnsupportedOperationException(
              "DISTINCT on select items are not supported yet.");
        }
        appendKeyWord(builder, outputFormat, "DISTINCT", "", " ");
      }

      int subIndent = oracleHint != null || distinct != null || top != null ? indent + 1
          : getSubIndent(builder, plainSelect.getSelectItems().size() > 1);
      BreakLine bl = oracleHint != null || distinct != null || top != null ? BreakLine.ALWAYS
          : BreakLine.AFTER_FIRST;

      List<SelectItem<?>> selectItems = plainSelect.getSelectItems();
      appendSelectItemList(selectItems, builder, subIndent, i, bl, indent);

      FromItem fromItem = plainSelect.getFromItem();
      if (fromItem != null) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; j < indent; j++) {
          builder.append(indentString);
        }
        appendKeyWord(builder, outputFormat, "FROM", "", " ");
        appendFromItem(fromItem, builder, indent, i, 1);

        List<Join> joins = plainSelect.getJoins();
        appendJoins(joins, builder, indent);
      }

      appendWhere(plainSelect.getWhere(), builder, indent);

      appendGroupByElement(plainSelect.getGroupBy(), builder, indent);

      appendHavingExpression(plainSelect.getHaving(), builder, indent);

      appendQualify(plainSelect.getQualify(), builder, indent);

      // @todo: write-out Windows
      if (plainSelect.getWindowDefinitions() != null) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; j < indent; j++) {
          builder.append(indentString);
        }
        builder.append("WINDOW ");
        int k = 0;
        for (WindowDefinition w : plainSelect.getWindowDefinitions()) {
          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(indent + 1));
          if (k++ > 0) {
            builder.append(", ");
          }
          if (w.getWindowName() != null) {
            appendObjectName(builder, outputFormat, w.getWindowName(), "", " ");
            appendKeyWord(builder, outputFormat, "AS", "", " (");
          } else {
            builder.append("(");
          }

          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(indent + 2));
          w.getPartitionBy().toStringPartitionBy(builder);

          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(indent + 2));
          w.getOrderBy().toStringOrderByElements(builder);

          if (w.getWindowElement() != null) {
            if (w.getOrderBy().getOrderByElements() != null) {
              appendNormalizedLineBreak(builder);
              builder.append(indentString.repeat(indent + 2));
            }
            appendKeyWord(builder, outputFormat, w.getWindowElement().toString(), "", "");
          }

          builder.append(" )");
        }
      }

      // @todo: write-out FOR MODE
      if (plainSelect.getForMode() != null) {
        builder.append(" FOR ");
        builder.append(plainSelect.getForMode().getValue());

        if (plainSelect.getForUpdateTable() != null) {
          builder.append(" OF ").append(plainSelect.getForUpdateTable());
        }
        if (plainSelect.getWait() != null) {
          // wait's toString will do the formatting for us
          builder.append(plainSelect.getWait());
        }
        if (plainSelect.isNoWait()) {
          builder.append(" NOWAIT");
        } else if (plainSelect.isSkipLocked()) {
          builder.append(" SKIP LOCKED");
        }
      }

      if (plainSelect.getPivot() != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        builder.append(plainSelect.getPivot());
      }

      if (plainSelect.getUnPivot() != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        builder.append(plainSelect.getUnPivot());
      }

      // @todo: write-out FOR CLAUSE
      if (plainSelect.getForClause() != null) {
        plainSelect.getForClause().appendTo(builder);
      }

      // @todo: write-out EMIT CHANGES
      if (plainSelect.isEmitChanges()) {
        builder.append(" EMIT CHANGES");
      }

      // @todo: write-out LIMIT BY
      if (plainSelect.getLimitBy() != null) {
        builder.append(plainSelect.getLimitBy());
      }

      List<OrderByElement> orderByElements = plainSelect.getOrderByElements();
      appendOrderByElements(orderByElements, builder, indent);

      Limit limit = plainSelect.getLimit();
      if (limit != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        appendKeyWord(builder, outputFormat, "LIMIT", "", " ");

        Expression rowCount = limit.getRowCount();
        if (rowCount instanceof AllValue || rowCount instanceof NullValue) {
          // no offset allowed
          appendKeyWord(builder, outputFormat, "NULL", "", " ");
        } else {
          if (null != limit.getOffset()) {
            appendExpression(limit.getOffset(), null, builder, indent, 0, 1, false,
                BreakLine.NEVER);
            builder.append(", ");
          }
          if (null != limit.getRowCount()) {
            appendExpression(limit.getRowCount(), null, builder, indent, 0, 1, false,
                BreakLine.NEVER);
          }
        }
      }

      Offset offset = plainSelect.getOffset();
      if (offset != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        appendKeyWord(builder, outputFormat, "OFFSET", "", " ");

        Expression offsetExpression = offset.getOffset();
        appendExpression(offsetExpression, null, builder, indent, 0, 1, false, BreakLine.NEVER);

        String offsetParam = offset.getOffsetParam();
        if (offsetParam != null) {
          appendString(offsetParam, builder, indent, 0, 1, false, BreakLine.NEVER);
        }
      }

      Fetch fetch = plainSelect.getFetch();
      if (fetch != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        appendKeyWord(builder, outputFormat, "FETCH", "", "");

        if (fetch.isFetchParamFirst()) {
          appendKeyWord(builder, outputFormat, "FIRST", " ", "");
        } else {
          appendKeyWord(builder, outputFormat, "NEXT", " ", "");
        }

        Expression expression = fetch.getExpression();
        if (expression != null) {
          appendNormalizingTrailingWhiteSpace(builder, " ");
          appendExpression(expression, null, builder, indent, 0, 1, false, BreakLine.NEVER);
        }

        for (String s : fetch.getFetchParameters()) {
          appendKeyWord(builder, outputFormat, s, " ", "");
        }

        // @todo: write-out ISOLATION
        if (plainSelect.getIsolation() != null) {
          builder.append(plainSelect.getIsolation());
        }

        // @todo: write-out Optimizer For
        if (plainSelect.getOptimizeFor() != null) {
          builder.append(plainSelect.getOptimizeFor());
        }

        // @todo: write-out FOR XML PATH
        if (plainSelect.getForXmlPath() != null) {
          builder.append(" FOR XML PATH(").append(plainSelect.getForXmlPath()).append(")");
        }

        // @todo: write-out INTO TEMP Table
        if (plainSelect.getIntoTempTable() != null) {
          builder.append(" INTO TEMP ").append(plainSelect.getIntoTempTable());
        }

        // @todo: write-out WITH NO LOG
        if (plainSelect.isUseWithNoLog()) {
          builder.append(" WITH NO LOG");
        }
      }

    } else if (select instanceof SetOperationList) {
      SetOperationList setOperationList = (SetOperationList) select;

      List<SetOperation> setOperations = setOperationList.getOperations();

      int k = 0;

      List<Select> selects = setOperationList.getSelects();
      if (selects != null && !selects.isEmpty()) {
        for (Select selectBody1 : selects) {
          if (k > 0 && setOperations != null && setOperations.size() >= k) {
            SetOperation setOperation = setOperations.get(k - 1);
            appendSetOperation(setOperation, builder, indent);
          }
          int subIndent = indent;
          appendSelect(selectBody1, builder, subIndent, k > 0 || breakLineBefore,
              k > 0 || breakLineBefore || indentFirstLine);
          k++;
        }
      }

      List<OrderByElement> orderByElements = setOperationList.getOrderByElements();
      appendOrderByElements(orderByElements, builder, indent);

      Limit limit = setOperationList.getLimit();
      if (limit != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        appendKeyWord(builder, outputFormat, "LIMIT", "", " ");

        Expression rowCount = limit.getRowCount();
        if (rowCount instanceof AllValue || rowCount instanceof NullValue) {
          // no offset allowed
          appendKeyWord(builder, outputFormat, "NULL", "", " ");
        } else {
          if (null != limit.getOffset()) {
            appendExpression(limit.getOffset(), null, builder, indent, 0, 1, false,
                BreakLine.NEVER);
            builder.append(", ");
          }
          if (null != limit.getRowCount()) {
            appendExpression(limit.getRowCount(), null, builder, indent, 0, 1, false,
                BreakLine.NEVER);
          }
        }
      }

      Offset offset = setOperationList.getOffset();
      if (offset != null) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; j < indent; j++) {
          builder.append(indentString);
        }
        appendKeyWord(builder, outputFormat, "OFFSET", "", " ");

        Expression offsetExpression = offset.getOffset();
        appendExpression(offsetExpression, null, builder, indent, 0, 1, false, BreakLine.NEVER);

        String offsetParam = offset.getOffsetParam();
        if (offsetParam != null) {
          appendString(offsetParam, builder, indent, 0, 1, false, BreakLine.NEVER);
        }
      }

    } else if (select instanceof Values) {
      Values values = (Values) select;

      if (breakLineBefore) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; indentFirstLine && j < indent; j++) {
          builder.append(indentString);
        }
      }

      appendKeyWord(builder, outputFormat, "VALUES", "", " ");
      appendExpressionList(values.getExpressions(), builder, indent, BreakLine.AS_NEEDED);

    } else if (select instanceof ParenthesedSelect) {
      ParenthesedSelect parenthesedSelect = (ParenthesedSelect) select;
      builder.append("( ");
      int subIndent = breakLineBefore ? indent + 1
          : getSubIndent(builder, !(parenthesedSelect.getSelect() instanceof Values));

      appendSelect(parenthesedSelect.getSelect(), builder, subIndent, breakLineBefore,
          indentFirstLine);
      builder.append(" )");

      if (parenthesedSelect.getPivot() != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        builder.append(parenthesedSelect.getPivot());
      }

      if (parenthesedSelect.getUnPivot() != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent));
        builder.append(parenthesedSelect.getUnPivot());
      }
    }
  }

  public static void appendSelectItemList(List<SelectItem<?>> selectItems, StringBuilder builder,
      int subIndent, int i, BreakLine bl, int indent) throws UnsupportedOperationException {
    int j = i;
    for (SelectItem<?> selectItem : selectItems) {
      Alias alias = selectItem.getAlias();
      Expression expression = selectItem.getExpression();

      appendExpression(expression, alias, builder, subIndent, j++, selectItems.size(), true, bl);
    }
  }

  public static void appendColumnSelectItemList(List<SelectItem<Column>> selectItems,
      StringBuilder builder, int subIndent, int i, BreakLine bl, int indent)
      throws UnsupportedOperationException {
    int j = i;
    for (SelectItem<?> selectItem : selectItems) {
      Alias alias = selectItem.getAlias();
      Expression expression = selectItem.getExpression();

      appendExpression(expression, alias, builder, subIndent, j++, selectItems.size(), true, bl);
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendOrderByElements(List<OrderByElement> orderByElements,
      StringBuilder builder, int indent) {
    if (orderByElements != null) {
      int i = 0;
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent));
      appendKeyWord(builder, outputFormat, "ORDER BY", "", " ");

      int subIndent = getSubIndent(builder, orderByElements.size() > 1);

      for (OrderByElement orderByElement : orderByElements) {
        Expression expression = orderByElement.getExpression();
        appendExpression(expression, null, builder, subIndent, i, orderByElements.size(), true,
            BreakLine.AFTER_FIRST);

        if (orderByElement.isAscDescPresent()) {
          builder.append(" ");

          if (orderByElement.isAsc()) {
            appendKeyWord(builder, outputFormat, "ASC", "", " ");
          } else {
            appendKeyWord(builder, outputFormat, "DESC", "", " ");
          }
        }

        NullOrdering nullOrdering = orderByElement.getNullOrdering();
        if (NullOrdering.NULLS_FIRST.equals(nullOrdering)) {
          appendKeyWord(builder, outputFormat, "NULLS FIRST",
              orderByElement.isAscDescPresent() ? "" : " ", " ");
        }

        if (NullOrdering.NULLS_LAST.equals(nullOrdering)) {
          appendKeyWord(builder, outputFormat, "NULLS LAST",
              orderByElement.isAscDescPresent() ? "" : " ", " ");
        }

        i++;
      }
    }
  }

  private static void appendHavingExpression(Expression havingExpression, StringBuilder builder,
      int indent) {
    if (havingExpression != null) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent));
      appendKeyWord(builder, outputFormat, "HAVING", "", " ");
      appendExpression(havingExpression, null, builder, indent, 0, 1, false, BreakLine.AFTER_FIRST);
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendGroupByElement(GroupByElement groupByElement, StringBuilder builder,
      int indent) throws UnsupportedOperationException {
    int i = 0;
    if (groupByElement != null) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent));
      appendKeyWord(builder, outputFormat, "GROUP BY", "", " ");

      List<?> groupingSets = groupByElement.getGroupingSets();
      ExpressionList<?> groupByExpressions = groupByElement.getGroupByExpressionList();

      if (groupingSets != null && !groupingSets.isEmpty()) {
        throw new UnsupportedOperationException("Grouping Sets are not supported yet.");
      }

      if (groupByExpressions != null && !groupByExpressions.isEmpty()) {
        BreakLine breakLine = BreakLine.AFTER_FIRST;
        int size = groupByExpressions.size();
        int subIndent = getSubIndent(builder, size > 1);

        for (Expression expression : groupByExpressions) {
          switch (breakLine) {
            case AS_NEEDED:
              BreakLine bl =
                  size == 4 || size >= 5 && i % 3 == 0 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;
              appendExpression(expression, null, builder, subIndent, i, size, true, bl);
              break;

            default:
              appendExpression(expression, null, builder, subIndent, i, size, true, breakLine);
          }
          i++;
        }
      }
    }
  }

  private static void appendKeywordedExpression(String keyword, Expression expression,
      StringBuilder builder, int indent) {
    if (expression != null) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent));
      appendKeyWord(builder, outputFormat, keyword, "", " ");
      appendExpression(expression, null, builder, indent, 0, 1, false, BreakLine.AFTER_FIRST);
    }
  }

  private static void appendWhere(Expression whereExpression, StringBuilder builder, int indent) {
    if (whereExpression != null) {
      appendKeywordedExpression("WHERE", whereExpression, builder, indent);
    }
  }

  private static void appendQualify(Expression qualifyExpression, StringBuilder builder,
      int indent) {
    if (qualifyExpression != null) {
      appendKeywordedExpression("QUALIFY", qualifyExpression, builder, indent);
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendJoins(List<Join> joins, StringBuilder builder, int indent) {
    if (joins != null) {
      for (Join join : joins) {

        if (join.isSimple()) {
          switch (separation) {
            case AFTER:
              builder.append(",");
          }
        }
        appendNormalizedLineBreak(builder);

        if (join.isSimple()) {
          builder.append(indentString.repeat(indent + 1));

          switch (separation) {
            case BEFORE:
              builder.append(", ");
          }

        } else {
          builder.append(indentString.repeat(indent + 1));

          if (join.isInner()) {
            appendKeyWord(builder, outputFormat, "INNER", "", " ");
          }
          if (join.isLeft()) {
            appendKeyWord(builder, outputFormat, "LEFT", "", " ");
          }
          if (join.isRight()) {
            appendKeyWord(builder, outputFormat, "RIGHT", "", " ");
          }
          if (join.isNatural()) {
            appendKeyWord(builder, outputFormat, "NATURAL", "", " ");
          }
          if (join.isCross()) {
            appendKeyWord(builder, outputFormat, "CROSS", "", " ");
          }
          if (join.isOuter()) {
            appendKeyWord(builder, outputFormat, "OUTER", "", " ");
          }
          if (join.isFull()) {
            appendKeyWord(builder, outputFormat, "FULL", "", " ");
          }

          appendKeyWord(builder, outputFormat, "JOIN", "", " ");
        }

        FromItem rightFromItem = join.getRightItem();
        appendFromItem(rightFromItem, builder, indent, 0, 1);

        for (Expression onExpression : join.getOnExpressions()) {
          if (onExpression != null) {
            appendNormalizedLineBreak(builder);
            builder.append(indentString.repeat(indent + 2));
            appendKeyWord(builder, outputFormat, "ON", "", " ");

            appendExpression(onExpression, null, builder, indent + 2, 0, 1, false,
                BreakLine.AFTER_FIRST);
          }
        }

        List<Column> usingColumns = join.getUsingColumns();
        if (usingColumns != null && !usingColumns.isEmpty()) {
          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(indent + 3));
          appendKeyWord(builder, outputFormat, "USING", "", " ( ");
          int k = 0;
          for (Column column : usingColumns) {
            appendExpression(column, null, builder, indent + 3, k, usingColumns.size(), true,
                BreakLine.AFTER_FIRST);
            k++;
          }
          appendNormalizingTrailingWhiteSpace(builder, " )");
        }
      }
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendWithItem(WithItem withItem, StringBuilder builder, int indent, int i,
      int n) {

    if (i > 0) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent + 1));
    }

    switch (separation) {
      case BEFORE:
        appendAlias(builder, outputFormat, withItem.getAlias().getName(), i > 0 ? ", " : "", " ");
        break;
      default:
        appendAlias(builder, outputFormat, withItem.getAlias().getName(), "", " ");
    }

    List<SelectItem<?>> selectItems = withItem.getWithItemList();
    if (selectItems != null && !selectItems.isEmpty()) {
      builder.append("( ");

      int subIndent = getSubIndent(builder, selectItems.size() > 2);
      BreakLine bl = selectItems.size() > 2 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;

      appendSelectItemList(selectItems, builder, subIndent, i, bl, indent);
      builder.append(" ) ");

      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent + 1));
      appendKeyWord(builder, outputFormat, "AS", "", " ");
      appendSelect(withItem.getSelect(), builder, indent + 1, false, false);

    } else {
      appendKeyWord(builder, outputFormat, "AS", "", " ");
      appendSelect(withItem.getSelect(), builder, indent + 1, true, true);
    }

    switch (separation) {
      case AFTER:
        appendNormalizingTrailingWhiteSpace(builder, i < n - 1 ? "," : "");
        break;
      case BEFORE:
        appendNormalizingTrailingWhiteSpace(builder, " ");
        break;
    }
  }

  private static void appendRowConstructor(StringBuilder builder, int indent,
      RowConstructor<?> rowConstructor) {

    if (rowConstructor.getName() != null) {
      appendAlias(builder, outputFormat, rowConstructor.getName(), "", "");
    }

    appendExpressionList(rowConstructor, builder, indent, BreakLine.AS_NEEDED);
  }

  private static void appendStringList(Collection<String> strings, StringBuilder builder,
      int indent, boolean commaSeparated, BreakLine breakLine) {
    int i = 0;
    if (strings != null) {
      for (String s : strings) {
        appendString(s, builder, indent, i, strings.size(), commaSeparated, breakLine);
        i++;
      }
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendString(String s, StringBuilder builder, int indent, int i, int n,
      boolean commaSeparated, BreakLine breakLine) {

    if ((i > 0 || breakLine.equals(BreakLine.ALWAYS)) && !breakLine.equals(BreakLine.NEVER)) {
      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent));
    }

    switch (separation) {
      case AFTER:
        appendObjectName(builder, outputFormat, s, "", "");
        appendNormalizingTrailingWhiteSpace(builder, commaSeparated && i < n - 1 ? ", " : "");
        break;
      case BEFORE:
        builder.append(commaSeparated && i > 0 ? ", " : "");
        appendObjectName(builder, outputFormat, s, "", "");
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.ExcessiveMethodLength"})
  private static void appendExpression(Expression expression, Alias alias, StringBuilder builder,
      int indent, final int i, final int n, boolean commaSeparated, BreakLine breakLine) {

    if ((i > 0 || breakLine.equals(BreakLine.ALWAYS)) && !breakLine.equals(BreakLine.NEVER)) {
      appendNormalizedLineBreak(builder);
      builder.append(String.valueOf(indentString).repeat(Math.max(0, indent)));
    }

    switch (separation) {
      case BEFORE:
        builder.append(commaSeparated && i > 0 ? ", " : "");
    }

    if (expression instanceof Column) {
      Column column = (Column) expression;
      appendObjectName(builder, outputFormat, column.getFullyQualifiedName(), "", "");

    } else if (expression instanceof AndExpression) {
      AndExpression andExpression = (AndExpression) expression;
      appendExpression(andExpression.getLeftExpression(), null, builder, indent, i, n, false,
          BreakLine.AFTER_FIRST);

      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent + 1));
      appendOperator(builder, outputFormat, "AND", "", " ");

      appendExpression(andExpression.getRightExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);

    } else if (expression instanceof OrExpression) {
      OrExpression orExpression = (OrExpression) expression;
      appendExpression(orExpression.getLeftExpression(), null, builder, indent, i, n, false,
          BreakLine.AFTER_FIRST);

      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent + 1));
      appendOperator(builder, outputFormat, "OR", "", " ");

      appendExpression(orExpression.getRightExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);

    } else if (expression instanceof EqualsTo) {
      EqualsTo equalsTo = (EqualsTo) expression;

      if (equalsTo.getOraclePriorPosition() == EqualsTo.ORACLE_PRIOR_START) {
        appendOperator(builder, outputFormat, "PRIOR", "", " ");
      }

      appendExpression(equalsTo.getLeftExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AS_NEEDED);

      if (equalsTo.getOldOracleJoinSyntax() == EqualsTo.ORACLE_JOIN_RIGHT) {
        appendOperator(builder, outputFormat, "(+)", "", " ");
      }

      appendOperator(builder, outputFormat, "=", " ", " ");

      if (equalsTo.getOraclePriorPosition() == EqualsTo.ORACLE_PRIOR_END) {
        appendOperator(builder, outputFormat, "PRIOR", "", " ");
      }

      appendExpression(equalsTo.getRightExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);

      if (equalsTo.getOldOracleJoinSyntax() == EqualsTo.ORACLE_JOIN_LEFT) {
        appendOperator(builder, outputFormat, "(+)", "", " ");
      }

    } else if (expression instanceof CaseExpression) {
      int subIndent = getSubIndent(builder, false);

      CaseExpression caseExpression = (CaseExpression) expression;
      appendKeyWord(builder, outputFormat, "CASE", "", " ");
      if (caseExpression.getSwitchExpression() != null) {
        appendExpression(caseExpression.getSwitchExpression(), null, builder, indent + 1, i, n,
            false, BreakLine.NEVER);
      }

      List<WhenClause> whenClauses = caseExpression.getWhenClauses();
      for (WhenClause whenClause : whenClauses) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(subIndent));
        appendKeyWord(builder, outputFormat, "WHEN", "", " ");
        appendExpression(whenClause.getWhenExpression(), null, builder, subIndent + 1, 0, 1, false,
            BreakLine.AFTER_FIRST);

        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(subIndent + 1));
        appendKeyWord(builder, outputFormat, "THEN", "", " ");
        appendExpression(whenClause.getThenExpression(), null, builder, subIndent + 1, 0, 1, false,
            BreakLine.AFTER_FIRST);
      }

      Expression elseExpression = caseExpression.getElseExpression();
      if (elseExpression != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(subIndent));
        appendKeyWord(builder, outputFormat, "ELSE", "", " ");
        appendExpression(elseExpression, null, builder, subIndent + 1, 0, 1, false,
            BreakLine.AFTER_FIRST);
      }

      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(subIndent));
      appendKeyWord(builder, outputFormat, "END", "", "");

    } else if (expression instanceof StringValue) {
      StringValue stringValue = (StringValue) expression;
      appendValue(builder, outputFormat, stringValue.toString(), "", "");

    } else if (expression instanceof LongValue) {
      LongValue longValue = (LongValue) expression;
      appendValue(builder, outputFormat, longValue.toString(), "", "");

    } else if (expression instanceof DateValue) {
      DateValue dateValue = (DateValue) expression;
      appendValue(builder, outputFormat, dateValue.toString(), "", "");

    } else if (expression instanceof DoubleValue) {
      DoubleValue doubleValue = (DoubleValue) expression;
      appendValue(builder, outputFormat, doubleValue.toString(), "", "");

    } else if (expression instanceof NotExpression) {
      NotExpression notExpression = (NotExpression) expression;
      if (notExpression.isExclamationMark()) {
        appendOperator(builder, outputFormat, "!", "", "");
      } else {
        appendOperator(builder, outputFormat, "NOT", "", " ");
      }

      appendExpression(notExpression.getExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);

    } else if (expression instanceof LikeExpression) {
      LikeExpression likeExpression = (LikeExpression) expression;

      appendExpression(likeExpression.getLeftExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);

      if (likeExpression.isNot()) {
        appendOperator(builder, outputFormat, "NOT", " ", "");
      }

      appendOperator(builder, outputFormat, "LIKE", " ", " ");

      appendExpression(likeExpression.getRightExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);

      Expression escapeExpression = likeExpression.getEscape();
      if (escapeExpression != null) {
        appendOperator(builder, outputFormat, "ESCAPE", " ", " ");
        appendExpression(escapeExpression, null, builder, indent + 1, i, n, false,
            BreakLine.AS_NEEDED);
      }

    } else if (expression instanceof NextValExpression) {
      NextValExpression nextValExpression = (NextValExpression) expression;
      if (nextValExpression.isUsingNextValueFor()) {
        appendOperator(builder, outputFormat, "NEXT VALUE FOR", "", " ");
      } else {
        appendOperator(builder, outputFormat, "NEXTVAL FOR", "", " ");
      }

      int j = 0;
      for (String name : nextValExpression.getNameList()) {
        if (j > 0) {
          builder.append(".");
        }
        appendObjectName(builder, outputFormat, name, "", "");
        j++;
      }

    } else if (expression instanceof ExistsExpression) {
      ExistsExpression existsExpression = (ExistsExpression) expression;
      if (existsExpression.isNot()) {
        appendOperator(builder, outputFormat, "NOT EXISTS", "", "");
      } else {
        appendOperator(builder, outputFormat, "EXISTS", "", " ");
      }

      appendExpression(existsExpression.getRightExpression(), null, builder, indent + 1, i, n,
          false, BreakLine.AFTER_FIRST);

    } else if (expression instanceof ExtractExpression) {
      ExtractExpression extractExpression = (ExtractExpression) expression;

      // "EXTRACT(" + name + " FROM " + expression + ')';

      appendKeyWord(builder, outputFormat, "EXTRACT", "", "( ");
      appendValue(builder, outputFormat, extractExpression.getName(), "", "");
      appendKeyWord(builder, outputFormat, "FROM", " ", " ");

      appendExpression(extractExpression.getExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);
      appendNormalizingTrailingWhiteSpace(builder, " )");

    } else if (expression instanceof JdbcNamedParameter) {
      JdbcNamedParameter jdbcNamedParameter = (JdbcNamedParameter) expression;
      appendValue(builder, outputFormat, jdbcNamedParameter.toString(), "", "");

    } else if (expression instanceof JdbcParameter) {
      JdbcParameter jdbcParameter = (JdbcParameter) expression;
      appendValue(builder, outputFormat, jdbcParameter.toString(), "", "");

    } else if (expression instanceof IsNullExpression) {
      IsNullExpression isNullExpression = (IsNullExpression) expression;
      appendExpression(isNullExpression.getLeftExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.AFTER_FIRST);

      if (isNullExpression.isUseNotNull()) {
        appendOperator(builder, outputFormat, "NOTNULL", " ", "");
      } else if (isNullExpression.isUseIsNull()) {
        if (isNullExpression.isNot()) {
          appendOperator(builder, outputFormat, "NOT ISNULL", " ", "");
        } else {
          appendOperator(builder, outputFormat, "ISNULL", " ", "");
        }
      } else {
        if (isNullExpression.isNot()) {
          appendOperator(builder, outputFormat, "IS NOT NULL", " ", "");
        } else {
          appendOperator(builder, outputFormat, "IS NULL", " ", "");
        }
      }

    } else if (expression instanceof NullValue) {
      NullValue nullValue = (NullValue) expression;
      appendKeyWord(builder, outputFormat, nullValue.toString(), "", "");

    } else if (expression instanceof TimeKeyExpression) {
      TimeKeyExpression timeKeyExpression = (TimeKeyExpression) expression;
      appendValue(builder, outputFormat, timeKeyExpression.toString(), "", "");

    } else if (expression instanceof InExpression) {
      InExpression inExpression = (InExpression) expression;
      Expression leftExpression = inExpression.getLeftExpression();
      boolean useNot = inExpression.isNot();

      Expression rightExpression = inExpression.getRightExpression();

      appendExpression(leftExpression, null, builder, indent, i, n, false, BreakLine.AS_NEEDED);

      if (inExpression.isGlobal()) {
        appendKeyWord(builder, outputFormat, "GLOBAL", " ", "");
      }

      if (useNot) {
        appendOperator(builder, outputFormat, "NOT IN", " ", " ");
      } else {
        appendOperator(builder, outputFormat, "IN", " ", " ");
      }

      appendExpression(rightExpression, null, builder, indent, i, n, false, BreakLine.AS_NEEDED);
    } else if (expression instanceof Function) {
      Function function = (Function) expression;

      String name = function.getName();
      ExpressionList<?> parameters = function.getParameters();
      NamedExpressionList<?> namedParameters = function.getNamedParameters();
      boolean distinct = function.isDistinct();
      boolean allColumns = function.isAllColumns();
      boolean escaped = function.isEscaped();
      KeepExpression keep = function.getKeep();
      Object attribute = function.getAttribute();

      if (escaped) {
        appendFunction(builder, outputFormat, "fn", " {", " ");
      }

      appendFunction(builder, outputFormat, name, "", "");

      if (parameters != null || namedParameters != null) {
        if (parameters != null) {
          if (distinct) {
            appendKeyWord(builder, outputFormat, "DISTINCT", "( ", " ");
          } else if (allColumns) {
            appendKeyWord(builder, outputFormat, "ALL", "( ", " ");
          } else {
            builder.append("( ");
          }

          if (name.equalsIgnoreCase("Decode")) {
            appendDecodeExpressionsList(parameters, BreakLine.AS_NEEDED, builder, indent);
          } else {
            appendExpressionList(parameters, builder, indent, BreakLine.AS_NEEDED);
          }

          appendNormalizingTrailingWhiteSpace(builder, " )");
        } else {
          // @todo: implement this properly and add a test case
          builder.append(namedParameters);
        }
      } else if (allColumns) {
        builder.append("( * )");
      } else {
        builder.append("()");
      }

      if (attribute != null) {
        builder.append(".").append(attribute);
      }

      if (keep != null) {
        builder.append(" ").append(keep);
      }

      if (escaped) {
        builder.append("} ");
      }

    } else if (expression instanceof SignedExpression) {
      SignedExpression signedExpression = (SignedExpression) expression;
      appendOperator(builder, outputFormat, String.valueOf(signedExpression.getSign()), "", " ");

      appendExpression(signedExpression.getExpression(), null, builder, indent, i, n, false,
          BreakLine.NEVER);

    } else if (expression instanceof Select) {
      Select select = (Select) expression;
      appendSelect(select, builder, indent, false, false);

    } else if (expression instanceof RowConstructor) {
      RowConstructor<?> rowConstructor = (RowConstructor<?>) expression;
      appendRowConstructor(builder, indent, rowConstructor);

    } else if (expression instanceof MySQLGroupConcat) {
      MySQLGroupConcat mySQLGroupConcat = (MySQLGroupConcat) expression;
      appendFunction(builder, outputFormat, "GROUP_CONCAT", "", "( ");

      int subIndent = getSubIndent(builder, true);

      if (mySQLGroupConcat.isDistinct()) {
        appendKeyWord(builder, outputFormat, "DISTINCT", "", " ");
      }
      appendExpressionsList(mySQLGroupConcat.getExpressionList(), builder, subIndent,
          BreakLine.AS_NEEDED);
      List<OrderByElement> orderByElements = mySQLGroupConcat.getOrderByElements();
      appendOrderByElements(orderByElements, builder, subIndent);

      String separator = mySQLGroupConcat.getSeparator();
      if (separator != null) {
        appendNormalizedLineBreak(builder);
        for (int j = 0; j < subIndent; j++) {
          builder.append(indentString);
        }
        appendKeyWord(builder, outputFormat, "SEPARATOR", "", " " + separator);
      }
      builder.append(" )");

      // Abstract Class, call last and let the specific implementations catch first
    } else if (expression instanceof BinaryExpression) {
      BinaryExpression binaryExpression = (BinaryExpression) expression;
      appendExpression(binaryExpression.getLeftExpression(), null, builder, indent, i, n, false,
          BreakLine.NEVER);

      if ((i > 0 || breakLine.equals(BreakLine.ALWAYS)) && !breakLine.equals(BreakLine.NEVER)) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent + 1));
      }
      appendOperator(builder, outputFormat, binaryExpression.getStringExpression(), " ", " ");

      appendExpression(binaryExpression.getRightExpression(), null, builder, indent, i, n, false,
          BreakLine.NEVER);

    } else if (expression instanceof ExpressionList) {
      ExpressionList<?> expressions = (ExpressionList<?>) expression;
      appendExpressionList(expressions, builder, indent, BreakLine.AS_NEEDED);
    } else if (expression instanceof AllTableColumns) {
      AllTableColumns allTableColumns = (AllTableColumns) expression;
      appendObjectName(builder, outputFormat, allTableColumns.getTable().getFullyQualifiedName(),
          "", ".*");

      if (allTableColumns.getExceptColumns() != null
          && !allTableColumns.getExceptColumns().isEmpty()) {
        appendKeyWord(builder, outputFormat, allTableColumns.getExceptKeyword(), " ", "( ");
        appendExpressionsList(allTableColumns.getExceptColumns(), builder, indent,
            BreakLine.AS_NEEDED);
        builder.append(" )");
      }

      if (allTableColumns.getReplaceExpressions() != null
          && !allTableColumns.getReplaceExpressions().isEmpty()) {
        appendKeyWord(builder, outputFormat, "REPLACE", " ", "( ");
        int subIndent = getSubIndent(builder, allTableColumns.getReplaceExpressions().size() > 3);
        appendSelectItemList(allTableColumns.getReplaceExpressions(), builder, subIndent, i,
            BreakLine.AS_NEEDED, indent);
        builder.append(" )");
      }
    } else if (expression instanceof AllColumns) {
      AllColumns allColumns = (AllColumns) expression;
      appendObjectName(builder, outputFormat, "*", "", "");

      if (allColumns.getExceptColumns() != null && !allColumns.getExceptColumns().isEmpty()) {
        appendKeyWord(builder, outputFormat, allColumns.getExceptKeyword(), " ", "( ");
        appendExpressionsList(allColumns.getExceptColumns(), builder, indent, BreakLine.AS_NEEDED);
        builder.append(" )");
      }

      if (allColumns.getReplaceExpressions() != null
          && !allColumns.getReplaceExpressions().isEmpty()) {
        appendKeyWord(builder, outputFormat, "REPLACE", " ", "( ");
        int subIndent = getSubIndent(builder, allColumns.getReplaceExpressions().size() > 3);
        appendSelectItemList(allColumns.getReplaceExpressions(), builder, subIndent, i,
            BreakLine.AS_NEEDED, indent);
        builder.append(" )");
      }

    } else if (expression instanceof IntervalExpression) {
      IntervalExpression intervalExpression = (IntervalExpression) expression;
      if (intervalExpression.isUsingIntervalKeyword()) {
        appendKeyWord(builder, outputFormat, "INTERVAL", "", " ");
      }
      if (intervalExpression.getExpression() != null) {
        appendExpression(intervalExpression.getExpression(), null, builder, indent, i, n, false,
            breakLine);
      } else {
        appendValue(builder, outputFormat, intervalExpression.getParameter(), "", "");
      }
      if (intervalExpression.getIntervalType() != null) {
        appendKeyWord(builder, outputFormat, intervalExpression.getIntervalType(), " ", "");
      }
    } else if (expression instanceof CastExpression) {
      CastExpression castExpression = (CastExpression) expression;

      if (castExpression.isImplicitCast()) {
        appendKeyWord(builder, outputFormat, castExpression.getColDataType().toString(), "", " ");
        appendExpression(castExpression.getLeftExpression(), null, builder, indent, i, n, false,
            BreakLine.NEVER);
      } else if (castExpression.isUseCastKeyword()) {
        if (castExpression.getColumnDefinitions().size() > 1) {
          appendFunction(builder, outputFormat, castExpression.keyword, " ", "( ");
          appendExpression(castExpression.getLeftExpression(), null, builder, indent, i, n, false,
              BreakLine.NEVER);
          appendKeyWord(builder, outputFormat, "AS ROW ( ", " ", " ");
          int j = 0;
          for (ColumnDefinition columnDefinition : castExpression.getColumnDefinitions()) {
            if (j++ > 0) {
              builder.append(", ");
            }
            appendKeyWord(builder, outputFormat, columnDefinition.toString(), "", "");
          }
        } else {
          appendFunction(builder, outputFormat, castExpression.keyword, " ", "( ");
          appendExpression(castExpression.getLeftExpression(), null, builder, indent, i, n, false,
              BreakLine.NEVER);
          appendKeyWord(builder, outputFormat, "AS " + castExpression.getColDataType().toString(),
              " ", " )");
        }
      } else {
        appendExpression(castExpression.getLeftExpression(), null, builder, indent, i, n, false,
            BreakLine.NEVER);
        appendKeyWord(builder, outputFormat, castExpression.getColDataType().toString(), "::", "");
      }
    } else if (expression instanceof Between) {
      Between between = (Between) expression;
      appendExpression(between.getLeftExpression(), null, builder, indent + 1, i, n, false,
          BreakLine.NEVER);

      int subIndent = getSubIndent(builder, false);

      appendKeyWord(builder, outputFormat, "BETWEEN", between.isNot() ? " NOT " : " ",
          (between.isUsingSymmetric() ? " SYMMETRIC" : "")
              + (between.isUsingAsymmetric() ? " ASYMMETRIC " : " "));

      appendExpression(between.getBetweenExpressionStart(), null, builder, indent + 1, i, n, false,
          BreakLine.NEVER);

      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(subIndent + 1));
      appendKeyWord(builder, outputFormat, "AND", " ", " ");

      appendExpression(between.getBetweenExpressionEnd(), null, builder, indent + 1, i, n, false,
          BreakLine.NEVER);
    } else if (expression instanceof ArrayConstructor) {
      ArrayConstructor arrayConstructor = (ArrayConstructor) expression;
      if (arrayConstructor.isArrayKeyword()) {
        appendKeyWord(builder, outputFormat, "ARRAY", " ", "");
      }

      boolean multiline = false;
      for (Expression p : arrayConstructor.getExpressions()) {
        if (p instanceof ArrayConstructor || p instanceof ExpressionList || p instanceof Select
            || p instanceof StructType) {
          multiline = true;
          break;
        }
      }

      int subIndent = getSubIndent(builder, true);
      builder.append("[ ");
      if (multiline) {
        appendExpressionList(arrayConstructor.getExpressions(), builder, subIndent,
            BreakLine.ALWAYS);
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(subIndent));
      } else {
        appendExpressionList(arrayConstructor.getExpressions(), builder, subIndent,
            BreakLine.NEVER);
      }
      builder.append("]");
    } else if (expression instanceof TranscodingFunction) {
      TranscodingFunction transcodingFunction = (TranscodingFunction) expression;
      appendFunction(builder, outputFormat, "Convert", "", "(");
      if (transcodingFunction.isTranscodeStyle()) {
        appendExpression(transcodingFunction.getExpression(), null, builder, indent, 0, 1, false,
            BreakLine.AS_NEEDED);
        appendKeyWord(builder, outputFormat, "USING", " ", "");
        appendKeyWord(builder, outputFormat, transcodingFunction.getTranscodingName(), " ", " )");
      } else {
        appendKeyWord(builder, outputFormat, transcodingFunction.getColDataType().toString(), " ",
            ", ");
        appendExpression(transcodingFunction.getExpression(), null, builder, indent, 0, 1, false,
            BreakLine.AS_NEEDED);

        String transcodingName = transcodingFunction.getTranscodingName();
        if (transcodingName != null && !transcodingName.isEmpty()) {
          appendKeyWord(builder, outputFormat, transcodingName, ", ", " )");
        } else {
          builder.append(" )");
        }
      }
    } else if (expression instanceof AnalyticExpression) {
      AnalyticExpression analyticExpression = (AnalyticExpression) expression;

      int subIndent = getSubIndent(builder, false);
      appendFunction(builder, outputFormat, analyticExpression.getName(), "", "( ");
      if (analyticExpression.isDistinct()) {
        appendKeyWord(builder, outputFormat, "DISTINCT", "", " ");
      }

      Expression expr = analyticExpression.getExpression();
      if (expr != null) {
        appendExpression(expr, null, builder, indent, 0, 1, false, BreakLine.NEVER);
        if (analyticExpression.getOffset() != null) {
          builder.append(", ");
          appendExpression(analyticExpression.getOffset(), null, builder, indent, 0, 1, true,
              BreakLine.NEVER);
          if (analyticExpression.getDefaultValue() != null) {
            builder.append(", ");
            appendExpression(analyticExpression.getDefaultValue(), null, builder, indent, 0, 1,
                true, BreakLine.NEVER);
          }
        }
      } else if (analyticExpression.isAllColumns()) {
        builder.append("*");
      }

      if (analyticExpression.getHavingClause() != null) {
        analyticExpression.getHavingClause().appendTo(builder);
      }

      if (analyticExpression.getNullHandling() != null) {
        switch (analyticExpression.getNullHandling()) {
          case IGNORE_NULLS:
            builder.append(" IGNORE NULLS");
            break;
          case RESPECT_NULLS:
            builder.append(" RESPECT NULLS");
        }
      }

      if (analyticExpression.getFuncOrderBy() != null) {
        builder.append(" ORDER BY ");
        builder.append(analyticExpression.getFuncOrderBy().stream().map(OrderByElement::toString)
            .collect(Collectors.joining(", ")));
      }

      if (analyticExpression.getLimit() != null) {
        builder.append(analyticExpression.getLimit());
      }
      builder.append(" ) ");

      if (analyticExpression.getKeep() != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(subIndent + 1));
        builder.append(analyticExpression.getKeep()).append(" ");
      }

      if (analyticExpression.getFilterExpression() != null) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(subIndent + 1));
        builder.append("FILTER ( WHERE ");
        builder.append(analyticExpression.getFilterExpression());
        builder.append(" )");
        if (analyticExpression.getType() != AnalyticType.FILTER_ONLY) {
          builder.append(" ");
        }
      }

      if (analyticExpression.isIgnoreNullsOutside()) {
        builder.append("IGNORE NULLS ");
      }

      switch (analyticExpression.getType()) {
        case FILTER_ONLY:
          return;
        case WITHIN_GROUP:
          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(subIndent + 1));
          builder.append("WITHIN GROUP");
          break;
        case WITHIN_GROUP_OVER:
          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(subIndent + 1));
          builder.append("WITHIN GROUP ( ");
          analyticExpression.getWindowDefinition().getOrderBy().toStringOrderByElements(builder);
          builder.append(" ) OVER ( ");
          analyticExpression.getWindowDefinition().getPartitionBy().toStringPartitionBy(builder);
          builder.append(" )");
          break;
        default:
          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(subIndent + 1));
          builder.append("OVER");
      }

      if (analyticExpression.getWindowName() != null) {
        builder.append(" ").append(analyticExpression.getWindowName());
      } else if (analyticExpression.getType() != AnalyticType.WITHIN_GROUP_OVER) {
        builder.append(" ");
        builder.append(analyticExpression.getWindowDefinition());
      }
    } else {
      LOGGER
          .warning("Unhandled expression: " + expression.getClass().getName() + " = " + expression);
      builder.append(expression);
    }

    appendAlias(builder, outputFormat, alias, " ", "");

    switch (separation) {
      case AFTER:
        appendNormalizingTrailingWhiteSpace(builder, commaSeparated && i < n - 1 ? ", " : "");
        break;
    }
  }

  private static void appendExpressionList(ExpressionList<?> expressionList, StringBuilder builder,
      int indent, BreakLine breakLine) {
    int subIndent = indent;
    if (expressionList instanceof ParenthesedExpressionList) {
      builder.append("( ");
      subIndent++;
    }
    appendExpressionsList(expressionList, builder, subIndent, breakLine);
    if (expressionList instanceof ParenthesedExpressionList) {
      builder.append(" )");
    }
  }

  private static void appendExpressionsList(List<? extends Expression> expressions,
      StringBuilder builder, int indent, BreakLine breakLine) {
    int size = expressions.size();
    int subIndent =
        breakLine.equals(BreakLine.NEVER) || breakLine.equals(BreakLine.AS_NEEDED) && size <= 3
            || size == 1 ? indent : getSubIndent(builder, true);

    int i = 0;
    for (Expression expression : expressions) {
      switch (breakLine) {
        case AS_NEEDED:
          BreakLine bl =
              size == 4 || size >= 5 && i % 3 == 0 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;
          appendExpression(expression, null, builder, subIndent, i, expressions.size(), true, bl);
          break;

        default:
          appendExpression(expression, null, builder, subIndent, i, expressions.size(), true,
              breakLine);
      }
      i++;
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendFromItem(FromItem fromItem, StringBuilder builder, int indent, int i,
      int n) {

    if (fromItem != null) {
      if (i > 0) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent + 1));
      }

      switch (separation) {
        case BEFORE:
          builder.append(i > 0 ? ", " : "");
      }

      Alias alias = fromItem.getAlias();

      // All Known Implementing Classes: LateralSubSelect, ParenthesisFromItem,
      // SpecialSubSelect, SubJoin, SubSelect, Table, TableFunction, ValuesList
      if (fromItem instanceof Table) {
        Table table = (Table) fromItem;
        appendTable(table, alias, builder);
      } else if (fromItem instanceof Select) {
        Select select = (Select) fromItem;
        appendSelect(select, builder, indent, false, true);
        appendAlias(builder, outputFormat, alias, " ", "");
      } else if (fromItem instanceof ParenthesedFromItem) {
        ParenthesedFromItem parenthesedFromItem = (ParenthesedFromItem) fromItem;
        builder.append("( ");
        int subIndent = getSubIndent(builder, true);

        appendFromItem(parenthesedFromItem.getFromItem(), builder, indent, i, n);
        List<Join> joins = parenthesedFromItem.getJoins();
        appendJoins(joins, builder, subIndent);
        builder.append(" )");

        appendAlias(builder, outputFormat, alias, " ", "");
      } else if (fromItem instanceof TableFunction) {
        TableFunction tableFunction = (TableFunction) fromItem;
        appendExpression(tableFunction.getFunction(), tableFunction.getAlias(), builder, indent, 0,
            1, true, BreakLine.AS_NEEDED);
      } else {
        LOGGER.log(Level.WARNING, "FROM Item not covered: " + fromItem.getClass().getName());
        fromItem.appendTo(builder, fromItem.getAlias());
      }

      switch (separation) {
        case AFTER:
          appendNormalizingTrailingWhiteSpace(builder, i < n - 1 ? ", " : "");
          break;
      }
    }
  }

  private static void appendTable(Table table, Alias alias, StringBuilder builder) {

    if (table != null) {
      appendObjectName(builder, outputFormat, table.getFullyQualifiedName(), "", "");
      if (alias != null) {
        appendNormalizingTrailingWhiteSpace(builder, " ");
        if (alias.isUseAs()) {
          appendKeyWord(builder, outputFormat, "AS", "", " ");
        }

        appendAlias(builder, outputFormat, alias.getName(), "", " ");
      }
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendSetOperation(SetOperation setOperation, StringBuilder builder,
      int indent) {
    appendNormalizedLineBreak(builder);
    builder.append(indentString.repeat(indent));
    appendOperator(builder, outputFormat, setOperation.toString(), "", " ");
  }

  private static void appendTruncate(StringBuilder builder, Truncate truncate) {
    Table table = truncate.getTable();
    boolean cascade = truncate.getCascade();

    appendKeyWord(builder, outputFormat, "TRUNCATE TABLE", "", " ")
        .append(table.getFullyQualifiedName());
    if (cascade) {
      appendOperator(builder, outputFormat, "CASCADE", " ", "");
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.ExcessiveMethodLength"})
  private static void appendCreateTable(StringBuilder builder, CreateTable createTable,
      int indent) {

    int i = 0;
    appendNormalizedLineBreak(builder);

    List<String> createOptionsString = createTable.getCreateOptionsStrings();
    String createOps = createOptionsString != null && !createOptionsString.isEmpty()
        ? PlainSelect.getStringList(createOptionsString, false, false)
        : null;

    boolean unlogged = createTable.isUnlogged();
    boolean ifNotExists = createTable.isIfNotExists();

    Table table = createTable.getTable();
    appendKeyWord(builder, outputFormat, "CREATE", "", " ");

    if (unlogged) {
      appendHint(builder, outputFormat, "UNLOGGED", "", " ");
    }

    if (createOps != null) {
      appendHint(builder, outputFormat, createOps, "", " ");
    }

    appendKeyWord(builder, outputFormat, "TABLE", "", " ");

    if (ifNotExists) {
      appendHint(builder, outputFormat, "IF NOT EXISTS", "", " ");
    }

    appendAlias(builder, outputFormat, table.getFullyQualifiedName(), "", "");

    List<ColumnDefinition> columnDefinitions = createTable.getColumnDefinitions();
    List<Index> indexes = createTable.getIndexes();

    if (columnDefinitions != null && !columnDefinitions.isEmpty()) {
      builder.append(" (");

      int colWidth = 0;
      int typeWidth = 0;

      for (ColumnDefinition columnDefinition : columnDefinitions) {
        String columnName = columnDefinition.getColumnName();
        // @todo: please get rid of that Replace workaround
        String colDataType = columnDefinition.getColDataType().toString().replace(", ", ",");

        if (colWidth < columnName.length()) {
          colWidth = columnName.length();
        }

        if (typeWidth < colDataType.length()) {
          typeWidth = colDataType.length();
        }
      }

      // int typeIndex = (((indent +1)* indentString.length() + colWidth + 1) /
      // indentString.length()) * ("
      // ".length() + 1);

      int typeIndex = indent + (colWidth / indentString.length()) + 3;

      int specIndex = indent + typeIndex + (typeWidth / indentString.length()) + 1;

      for (ColumnDefinition columnDefinition : columnDefinitions) {
        appendNormalizedLineBreak(builder);
        builder.append(indentString.repeat(indent + 1));

        String columnName = columnDefinition.getColumnName();
        ColDataType colDataType = columnDefinition.getColDataType();
        List<String> columnSpecs = columnDefinition.getColumnSpecs();

        switch (separation) {
          case BEFORE:
            builder.append(i > 0 ? ", " : "");
        }

        appendObjectName(builder, outputFormat, columnName, "", "");

        int lastLineLength = getLastLineLength(builder);

        builder.append(" ".repeat(Math.max(0, typeIndex * indentWidth - lastLineLength + 1)));
        // @todo: please get rid of that Replace workaround
        appendType(builder, outputFormat, colDataType.toString().replace(", ", ","), "", "");

        lastLineLength = getLastLineLength(builder);

        if (columnSpecs != null && !columnSpecs.isEmpty()) {
          builder.append(" ".repeat(Math.max(0, specIndex * indentWidth - lastLineLength + 1)));
          appendType(builder, outputFormat, PlainSelect.getStringList(columnSpecs, false, false),
              "", "");
        }

        switch (separation) {
          case AFTER:
            appendNormalizingTrailingWhiteSpace(builder,
                i < columnDefinitions.size() + indexes.size() - 1 ? ", " : "");
            break;
        }

        i++;
      }

      // Direct Known Subclasses:
      // ExcludeConstraint, NamedConstraint

      // Direct Known Subclasses:
      // CheckConstraint, ForeignKeyIndex

      if (indexes != null && !indexes.isEmpty()) {
        for (Index index : indexes) {
          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(indent + 1));

          switch (separation) {
            case BEFORE:
              builder.append(i > 0 ? ", " : "");
          }

          if (index instanceof ForeignKeyIndex) {
            ForeignKeyIndex foreignKeyIndex = (ForeignKeyIndex) index;

            String type = foreignKeyIndex.getType();
            String name = foreignKeyIndex.getName();
            List<String> columnsNames = foreignKeyIndex.getColumnsNames();
            List<String> idxSpec = foreignKeyIndex.getIndexSpec();
            String idxSpecText = PlainSelect.getStringList(idxSpec, false, false);

            // @todo: beautify the expression
            // @todo: add a test case
            if (name != null) {
              appendKeyWord(builder, outputFormat, "CONSTRAINT", "", " ");
              appendAlias(builder, outputFormat, name, "", "");
              appendNormalizedLineBreak(builder);
            }

            for (int j = 0; name != null && j <= indent + 1; j++) {
              builder.append(indentString);
            }

            appendKeyWord(builder, outputFormat, type, "", " ");

            builder.append("( ");
            int subIndent = getSubIndent(builder, columnsNames.size() > 2);
            BreakLine bl = columnsNames.size() > 2 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;
            appendStringList(columnsNames, builder, subIndent, true, bl);
            builder.append(" )");

            // @todo: add a test case for this
            if (idxSpec != null && !idxSpecText.isEmpty()) {
              appendHint(builder, outputFormat, idxSpecText, " ", "");
            }

            Table foreignTable = foreignKeyIndex.getTable();
            List<String> referencedColumnNames = foreignKeyIndex.getReferencedColumnNames();

            appendNormalizedLineBreak(builder);
            builder.append(indentString.repeat(indent + 2));
            appendKeyWord(builder, outputFormat, "REFERENCES", "", " ");
            appendObjectName(builder, outputFormat, foreignTable.getFullyQualifiedName(), "", " ");

            builder.append("( ");
            subIndent = getSubIndent(builder, referencedColumnNames.size() > 2);
            bl = referencedColumnNames.size() > 2 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;
            appendStringList(referencedColumnNames, builder, subIndent, true, bl);
            builder.append(" )");

            ReferentialAction updateAction =
                foreignKeyIndex.getReferentialAction(ReferentialAction.Type.UPDATE);
            if (updateAction != null) {
              appendNormalizedLineBreak(builder);
              builder.append(indentString.repeat(indent + 3));
              builder.append(updateAction);
            }

            ReferentialAction deleteAction =
                foreignKeyIndex.getReferentialAction(ReferentialAction.Type.DELETE);
            if (deleteAction != null) {
              appendNormalizedLineBreak(builder);
              builder.append(indentString.repeat(indent + 3));
              builder.append(deleteAction);
            }

          } else if (index instanceof CheckConstraint) {
            CheckConstraint checkConstraint = (CheckConstraint) index;

            String contraintName = checkConstraint.getName();
            Expression expression = checkConstraint.getExpression();

            appendKeyWord(builder, outputFormat, "CONSTRAINT", "", " ");
            appendAlias(builder, outputFormat, contraintName, "", "");

            appendNormalizedLineBreak(builder);
            builder.append(indentString.repeat(indent + 2));

            builder.append(" CHECK (").append(expression).append(")");

          } else if (index instanceof NamedConstraint) {
            NamedConstraint namedConstraint = (NamedConstraint) index;

            String type = namedConstraint.getType();
            String name = namedConstraint.getName();
            List<String> columnsNames = namedConstraint.getColumnsNames();
            List<String> idxSpec = namedConstraint.getIndexSpec();
            String idxSpecText = PlainSelect.getStringList(idxSpec, false, false);

            // @todo: beautify the expression
            // @todo: add a test case
            if (name != null) {
              appendKeyWord(builder, outputFormat, "CONSTRAINT", "", " ");
              appendAlias(builder, outputFormat, name, "", "");
              appendNormalizedLineBreak(builder);
            }

            for (int j = 0; name != null && j <= indent + 1; j++) {
              builder.append(indentString);
            }
            appendKeyWord(builder, outputFormat, type, "", " ");

            builder.append("( ");
            int subIndent = getSubIndent(builder, columnsNames.size() > 2);
            BreakLine bl = columnsNames.size() > 2 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;
            appendStringList(columnsNames, builder, subIndent, true, bl);
            builder.append(" )");

            // @todo: add a test case for this
            if (idxSpec != null && !idxSpecText.isEmpty()) {
              appendHint(builder, outputFormat, idxSpecText, " ", "");
            }

          } else if (index instanceof ExcludeConstraint) {
            ExcludeConstraint excludeConstraint = (ExcludeConstraint) index;
            Expression expression = excludeConstraint.getExpression();

            // @todo: beautify the expression
            // @todo: add a test case

            builder.append("EXCLUDE WHERE ");
            builder.append("(");
            builder.append(expression);
            builder.append(")");

          } else if (index != null) {
            String type = index.getType();
            String name = index.getName();
            List<Index.ColumnParams> columnParams = index.getColumns();
            List<String> idxSpec = index.getIndexSpec();
            String idxSpecText = PlainSelect.getStringList(idxSpec, false, false);

            builder.append(type);

            appendKeyWord(builder, outputFormat, type, "", " ");
            if (name != null) {
              appendAlias(builder, outputFormat, name, "", "");
            }

            builder.append(" ").append(PlainSelect.getStringList(columnParams, true, true))
                .append(!idxSpecText.isEmpty() ? " " + idxSpecText : "");
          }

          switch (separation) {
            case AFTER:
              appendNormalizingTrailingWhiteSpace(builder,
                  i < columnDefinitions.size() + indexes.size() - 1 ? ", " : "");
              break;
          }

          i++;
        }
      }
      appendNormalizedLineBreak(builder).append(")");
    }
    List<String> tableOptionsStrings = createTable.getTableOptionsStrings();
    String options = PlainSelect.getStringList(tableOptionsStrings, false, false);
    if (!options.isEmpty()) {
      appendHint(builder, outputFormat, options, " ", "");
    }

    RowMovement rowMovement = createTable.getRowMovement();
    if (rowMovement != null) {
      // @todo: beautify this part
      // @todo: provide test cases
      builder.append(" ").append(rowMovement.getMode()).append(" ROW MOVEMENT");
    }

    Select select = createTable.getSelect();
    if (select != null) {

      appendNormalizedLineBreak(builder);
      builder.append(indentString.repeat(indent + 1));
      builder.append("AS ");
      appendSelect(select, builder, indent, false, false);
    }

    Table likeTable = createTable.getLikeTable();
    if (likeTable != null) {

      builder.append(" AS ");

      Alias alias = likeTable.getAlias();

      appendTable(likeTable, alias, builder);
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity"})
  private static void appendCreateIndex(StringBuilder builder, CreateIndex createIndex,
      int indent) {

    Index index = createIndex.getIndex();
    Table table = createIndex.getTable();

    List<String> tailParameters = createIndex.getTailParameters();
    List<Index.ColumnParams> columnsParameters = index.getColumns();

    appendKeyWord(builder, outputFormat, "CREATE", "", " ");

    if (index.getType() != null) {
      appendKeyWord(builder, outputFormat, index.getType(), "", " ");
    }

    appendKeyWord(builder, outputFormat, "INDEX", "", " ");
    if (createIndex.isUsingIfNotExists()) {
      appendKeyWord(builder, outputFormat, "IF NOT EXISTS", "", " ");
    }
    appendAlias(builder, outputFormat, index.getName(), "", "");

    appendNormalizedLineBreak(builder);
    builder.append(indentString.repeat(indent + 1));
    appendKeyWord(builder, outputFormat, "ON", "", " ");
    appendObjectName(builder, outputFormat, table.getFullyQualifiedName(), "", "");

    if (index.getUsing() != null) {
      appendKeyWord(builder, outputFormat, "USING", "  ", " ");
      builder.append(index.getUsing());
    }

    if (index.getColumnsNames() != null) {
      builder.append("( ");

      int subIndent = getSubIndent(builder, columnsParameters.size() > 2);
      BreakLine bl = columnsParameters.size() > 2 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;

      int i = 0;
      for (Index.ColumnParams param : columnsParameters) {
        appendString(param.getColumnName(), builder, subIndent, i, columnsParameters.size(), true,
            bl);
        i++;
      }

      builder.append(" )");

      if (tailParameters != null) {
        builder.append(" ");
        for (String param : tailParameters) {
          appendHint(builder, outputFormat, param, "", " ");
        }
      }
    }
  }

  private static void appendCreateView(StringBuilder builder, CreateView createView, int indent) {
    boolean isOrReplace = createView.isOrReplace();
    ForceOption force = createView.getForce();
    TemporaryOption temp = createView.getTemporary();
    boolean isMaterialized = createView.isMaterialized();

    Table view = createView.getView();

    ExpressionList<Column> columnNames = createView.getColumnNames();
    Select select = createView.getSelect();
    boolean isWithReadOnly = createView.isWithReadOnly();

    appendNormalizedLineBreak(builder);

    appendKeyWord(builder, outputFormat, "CREATE", "", " ");
    if (isOrReplace) {
      appendKeyWord(builder, outputFormat, "OR REPLACE", "", " ");
    }
    switch (force) {
      case FORCE:
        appendKeyWord(builder, outputFormat, "FORCE", "", " ");
        break;
      case NO_FORCE:
        appendKeyWord(builder, outputFormat, "NO FORCE", "", " ");
        break;
    }

    if (temp != TemporaryOption.NONE) {
      builder.append(temp.name()).append(" ");
    }

    if (isMaterialized) {
      appendKeyWord(builder, outputFormat, "MATERIALIZED", "", " ");
    }
    appendKeyWord(builder, outputFormat, "VIEW", "", " ");
    appendAlias(builder, outputFormat, view.getFullyQualifiedName(), "", "");
    if (columnNames != null) {
      builder.append(PlainSelect.getStringList(columnNames, true, true));
    }

    appendNormalizedLineBreak(builder);
    builder.append(indentString.repeat(indent + 1));
    appendKeyWord(builder, outputFormat, "AS", "", " ");
    appendSelect(select, builder, indent + 2, false, false);

    if (isWithReadOnly) {
      builder.append(" WITH READ ONLY");
      appendHint(builder, outputFormat, "WITH READ ONLY", " ", "");
    }
  }

  @SuppressWarnings({"PMD.CyclomaticComplexity", "PMD.ExcessiveMethodLength"})
  private static void appendAlter(StringBuilder builder, Alter alter, int indent) {
    boolean useOnly = alter.isUseOnly();
    Table table = alter.getTable();
    List<AlterExpression> alterExpressions = alter.getAlterExpressions();

    appendKeyWord(builder, outputFormat, "ALTER TABLE", "", " ");
    if (useOnly) {
      appendKeyWord(builder, outputFormat, "ONLY", "", " ");
    }
    appendObjectName(builder, outputFormat, table.getFullyQualifiedName(), "", "");
    int i = 0;

    if (alterExpressions != null) {
      for (AlterExpression alterExpression : alterExpressions) {
        if (i > 0) {
          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(indent + 1));
        }

        switch (separation) {
          case BEFORE:
            builder.append(i > 0 ? ", " : "");
        }

        AlterOperation operation = alterExpression.getOperation();
        String commentText = alterExpression.getCommentText();
        String columnName = alterExpression.getColumnName();
        String columnOldName = alterExpression.getColumnOldName();

        List<AlterExpression.ColumnDataType> colDataTypeList = alterExpression.getColDataTypeList();
        String optionalSpecifier = alterExpression.getOptionalSpecifier();

        List<AlterExpression.ColumnDropNotNull> columnDropNotNullList =
            alterExpression.getColumnDropNotNullList();

        String constraintName = alterExpression.getConstraintName();
        boolean constraintIfExists = alterExpression.isUsingIfExists();

        List<String> pkColumns = alterExpression.getPkColumns();
        List<String> ukColumns = alterExpression.getUkColumns();
        String ukName = alterExpression.getUkName();
        boolean uk = alterExpression.getUk();

        List<String> fkColumns = alterExpression.getFkColumns();
        String fkSourceTable = alterExpression.getFkSourceTable();
        List<String> fkSourceColumns = alterExpression.getFkSourceColumns();

        ReferentialAction deleteAction =
            alterExpression.getReferentialAction(ReferentialAction.Type.DELETE);
        ReferentialAction updateAction =
            alterExpression.getReferentialAction(ReferentialAction.Type.UPDATE);

        Index index = alterExpression.getIndex();

        List<ConstraintState> constraints = alterExpression.getConstraints();
        boolean useEqual = alterExpression.getUseEqual();

        List<String> parameters = alterExpression.getParameters();

        appendNormalizedLineBreak(builder);

        builder.append(indentString.repeat(indent + 1));
        if (operation == AlterOperation.RENAME_TABLE) {
          appendKeyWord(builder, outputFormat, "RENAME TO", "", " ");
          appendObjectName(builder, outputFormat, alterExpression.getNewTableName(), "", "");
          break;
        } else {
          appendKeyWord(builder, outputFormat, operation.name(), "", " ");
        }

        if (commentText != null) {
          if (columnName != null) {
            appendKeyWord(builder, outputFormat, "COMMENT", " ", " ");
          }
          builder.append(commentText);
        } else if (columnName != null) {
          if (alterExpression.hasColumn()) {
            appendKeyWord(builder, outputFormat, "COLUMN", "", " ");
          }
          if (operation == AlterOperation.RENAME) {
            appendObjectName(builder, outputFormat, columnOldName, "", "");
            appendKeyWord(builder, outputFormat, "TO", " ", " ");
          }
          appendObjectName(builder, outputFormat, columnName, "", "");

        } else if (operation == AlterOperation.DROP && !alterExpression.hasColumn()
            && alterExpression.getPkColumns() != null) {
          // Oracle supports dropping multiple columns
          // we use the PKColumns List in this case instead of the Column

          List<String> columns = alterExpression.getPkColumns();

          builder.append("(");

          int subIndent = getSubIndent(builder, columns.size() > 3);
          BreakLine bl = columns.size() > 3 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;

          appendStringList(alterExpression.getPkColumns(), builder, subIndent, true, bl);
          builder.append(" )");

        } else if (colDataTypeList != null) {

          int colWidth = 0;
          int typeWidth = 0;

          BreakLine breakLine =
              colDataTypeList.size() > 1 ? BreakLine.AFTER_FIRST : BreakLine.NEVER;

          if (operation == AlterOperation.CHANGE) {
            if (optionalSpecifier != null) {
              builder.append(optionalSpecifier).append(" ");
            }
            appendObjectName(builder, outputFormat, columnOldName, "", " ");
          } else if (colDataTypeList.size() > 1) {

            for (ColumnDefinition columnDefinition : colDataTypeList) {
              String columnName1 = columnDefinition.getColumnName();
              // @todo: please get rid of that Replace workaround
              String colDataType = columnDefinition.getColDataType().toString().replace(", ", ",");

              if (colWidth < columnName1.length()) {
                colWidth = columnName1.length();
              }

              if (typeWidth < colDataType.length()) {
                typeWidth = colDataType.length();
              }
            }

            builder.append("( ");

          } else {
            if (alterExpression.hasColumn()) {
              appendKeyWord(builder, outputFormat, "COLUMN", "", " ");
            }
          }

          int subIndent = getSubIndent(builder, colDataTypeList.size() > 1);
          int typeIndex = subIndent + (colWidth / indentString.length()) + 1;
          int specIndex = indent + typeIndex + (typeWidth / indentString.length()) + 1;

          for (ColumnDefinition columnDefinition : colDataTypeList) {
            if (i > 0 || breakLine.equals(BreakLine.ALWAYS)) {
              if (!breakLine.equals(BreakLine.NEVER)) {
                appendNormalizedLineBreak(builder);
                builder.append(indentString.repeat(subIndent));
              }
              builder.append(", ");
            }

            String columnName1 = columnDefinition.getColumnName();
            ColDataType colDataType = columnDefinition.getColDataType();
            List<String> columnSpecs = columnDefinition.getColumnSpecs();

            appendObjectName(builder, outputFormat, columnName1, "", " ");

            int lastLineLength = getLastLineLength(builder);

            builder.append(" ".repeat(Math.max(0, typeIndex * indentWidth - lastLineLength + 1)));
            // @todo: please get rid of that Replace workaround
            appendType(builder, outputFormat, colDataType.toString().replace(", ", ","), "", "");

            lastLineLength = getLastLineLength(builder);

            if (columnSpecs != null && !columnSpecs.isEmpty()) {
              if (colDataTypeList.size() > 1) {
                builder
                    .append(" ".repeat(Math.max(0, specIndex * indentWidth - lastLineLength + 1)));
              } else {
                builder.append(" ");
              }

              appendType(builder, outputFormat,
                  PlainSelect.getStringList(columnSpecs, false, false), "", "");
            }
            i++;
          }

          if (colDataTypeList.size() > 1) {
            builder.append(")");
          }
        } else if (columnDropNotNullList != null) {
          if (operation == AlterOperation.CHANGE) {
            if (optionalSpecifier != null) {
              builder.append(optionalSpecifier).append(" ");
            }
            appendObjectName(builder, outputFormat, columnOldName, "", " ");
          } else if (columnDropNotNullList.size() > 1) {
            builder.append("(");
          } else {
            if (alterExpression.hasColumn()) {
              appendKeyWord(builder, outputFormat, "COLUMN", "", " ");
            }
          }
          builder.append(PlainSelect.getStringList(columnDropNotNullList));
          if (columnDropNotNullList.size() > 1) {
            builder.append(")");
          }
        } else if (constraintName != null) {
          appendKeyWord(builder, outputFormat, "CONSTRAINT", "", " ");

          if (constraintIfExists) {
            appendKeyWord(builder, outputFormat, "IF EXISTS", "", " ");
          }
          appendObjectName(builder, outputFormat, constraintName, "", "");
        } else if (pkColumns != null) {
          appendKeyWord(builder, outputFormat, "PRIMARY KEY", "", " (");

          builder.append(PlainSelect.getStringList(pkColumns)).append(")");
        } else if (ukColumns != null) {
          appendKeyWord(builder, outputFormat, "UNIQUE", "", "");
          if (ukName != null) {
            if (uk) {
              appendKeyWord(builder, outputFormat, "KEY", " ", " ");
            } else {
              appendKeyWord(builder, outputFormat, "INDEX", " ", " ");
            }
            appendObjectName(builder, outputFormat, ukName, "", "");
          }
          builder.append(" (").append(PlainSelect.getStringList(ukColumns)).append(")");
        } else if (fkColumns != null) {
          appendKeyWord(builder, outputFormat, "FOREIGN KEY", "", " (");
          builder.append(PlainSelect.getStringList(fkColumns)).append(")");

          appendNormalizedLineBreak(builder);
          builder.append(indentString.repeat(indent + 2));

          appendKeyWord(builder, outputFormat, "REFERENCES", "", " ");

          builder.append(fkSourceTable).append(" (")
              .append(PlainSelect.getStringList(fkSourceColumns)).append(")");
          // referentialActions.forEach(b::append);
          if (updateAction != null) {
            builder.append(updateAction);
          }

          if (deleteAction != null) {
            builder.append(deleteAction);
          }
        } else if (index != null) {
          builder.append(index);
        }
        if (constraints != null && !constraints.isEmpty()) {
          builder.append(" ").append(PlainSelect.getStringList(constraints, false, false));
        }
        if (useEqual) {
          builder.append("=");
        }
        if (parameters != null && !parameters.isEmpty()) {
          builder.append(" ").append(PlainSelect.getStringList(parameters, false, false));
        }

        switch (separation) {
          case AFTER:
            appendNormalizingTrailingWhiteSpace(builder,
                i < alterExpressions.size() - 1 ? ", " : "");
            break;
        }

        i++;
      }
    }
  }

  public enum OutputFormat {
    PLAIN, ANSI, HTML, RTF, XSLFO
  }

  public enum Spelling {
    UPPER, LOWER, CAMEL, KEEP
  }

  public enum Separation {
    BEFORE, AFTER
  }

  public enum BreakLine {
    NEVER // keep all arguments on one line
    , AS_NEEDED // only when more than 3 arguments
    , AFTER_FIRST // break all after the first argument
    , ALWAYS // break all arguments to a new line
  }

  public enum SquaredBracketQuotation {
    AUTO, YES, NO
  }

  public enum ShowLineNumbers {
    YES, NO
  }

  public enum BackSlashQuoting {
    YES, NO
  }

  public enum StatementTerminator {
    SEMICOLON, NONE, GO, BACKSLASH
  }

  public enum FormattingOption {
    SQUARE_BRACKET_QUOTATION("squareBracketQuotation")

    , BACKSLASH_QUOTING("backSlashQuoting")

    , OUTPUT_FORMAT("outputFormat")

    , KEYWORD_SPELLING("keywordSpelling")

    , FUNCTION_SPELLING("functionSpelling")

    , OBJECT_SPELLING("objectSpelling")

    , SEPARATION("separation")

    , INDENT_WIDTH("indentWidth")

    , SHOW_LINE_NUMBERS("showLineNumbers")

    , STATEMENT_TERMINATOR("statementTerminator")

    ;

    public final String optionName;

    FormattingOption(String optionName) {
      this.optionName = optionName;
    }

    @Override
    public String toString() {
      return optionName;
    }

    public void addFormatterOption(String value, ArrayList<String> formatterOptions) {
      formatterOptions.add(optionName + "=" + value);
    }
  }

}
