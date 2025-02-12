package io.github.rosemoe.sora.langs.sql;

import ir.ninjacoder.ghostide.marco.RegexUtilCompat;
import android.graphics.Color;
import androidx.core.graphics.ColorUtils;
import io.github.rosemoe.sora.data.Span;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzer;
import io.github.rosemoe.sora.text.TextAnalyzeResult;
import io.github.rosemoe.sora.text.TextStyle;
import io.github.rosemoe.sora.widget.EditorColorScheme;
import java.io.StringReader;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;
import io.github.rosemoe.sora.langs.xml.analyzer.Utils;

public class MySqlCodeAnalyzer implements CodeAnalyzer {

  @Override
  public void analyze(
      CharSequence content,
      TextAnalyzeResult result,
      TextAnalyzer.AnalyzeThread.Delegate delegate) {

    try {
      var stream = CharStreams.fromReader(new StringReader(content.toString()));
      var lexer = new MySqlLexer(stream);
      Token token, preToken = null, prePreToken = null;
      int line, column;
      var previous = -1;
      var lastLine = 1;
      int type;
      boolean frist = false;

      while (delegate.shouldAnalyze()) {
        token = lexer.nextToken();
        if (token == null) break;
        if (token.getType() == MySqlLexer.EOF) {
          lastLine = token.getLine() - 1;
          break;
        }
        line = token.getLine() - 1;
        type = token.getType();
        column = token.getCharPositionInLine();
        if (type == MySqlLexer.EOF) {
          lastLine = line;
          break;
        }
        switch (type) {
          case MySqlLexer.SPACE:
            if (frist) result.addNormalIfNull();
            break;
          case MySqlLexer.COMMENT:
          case MySqlLexer.SPEC_MYSQL_COMMENT:
          case MySqlLexer.COMMENT_INPUT:
            get(result, EditorColorScheme.COMMENT, false, false, line, column);
            break;
          case MySqlLexer.ADD:
          case MySqlLexer.ALL:
          case MySqlLexer.ALTER:
          case MySqlLexer.ALWAYS:
          case MySqlLexer.ANALYZE:
          case MySqlLexer.AND:
          case MySqlLexer.ARRAY:
          case MySqlLexer.AS:
          case MySqlLexer.ASC:
          case MySqlLexer.ATTRIBUTE:
          case MySqlLexer.BEFORE:
          case MySqlLexer.BETWEEN:
          case MySqlLexer.BOTH:
          case MySqlLexer.BUCKETS:
          case MySqlLexer.BY:
          case MySqlLexer.CALL:
          case MySqlLexer.CASCADE:
          case MySqlLexer.CASE:
          case MySqlLexer.CAST:
          case MySqlLexer.CHANGE:
          case MySqlLexer.CHARACTER:
          case MySqlLexer.CHECK:
          case MySqlLexer.COLLATE:
          case MySqlLexer.COLUMN:
          case MySqlLexer.CONDITION:
          case MySqlLexer.CONSTRAINT:
          case MySqlLexer.CONTINUE:
          case MySqlLexer.CONVERT:
          case MySqlLexer.CREATE:
          case MySqlLexer.CROSS:
          case MySqlLexer.CURRENT:
          case MySqlLexer.CURRENT_ROLE:
          case MySqlLexer.CURRENT_USER:
          case MySqlLexer.CURSOR:
          case MySqlLexer.DATABASE:
          case MySqlLexer.DATABASES:
          case MySqlLexer.DECLARE:
          case MySqlLexer.DEFAULT:
          case MySqlLexer.DELAYED:
          case MySqlLexer.DELETE:
          case MySqlLexer.DESC:
          case MySqlLexer.DESCRIBE:
          case MySqlLexer.DETERMINISTIC:
          case MySqlLexer.DIAGNOSTICS:
            get(result, EditorColorScheme.OPERATOR, true, false, line, column);
            break;
          case MySqlLexer.LINEAR:
          case MySqlLexer.LINES:
          case MySqlLexer.LOAD:
          case MySqlLexer.LOCK:
          case MySqlLexer.LOCKED:
          case MySqlLexer.LOOP:
          case MySqlLexer.LOW_PRIORITY:
          case MySqlLexer.MASTER_BIND:
          case MySqlLexer.MASTER_SSL_VERIFY_SERVER_CERT:
          case MySqlLexer.MATCH:
          case MySqlLexer.MAXVALUE:
          case MySqlLexer.MINVALUE:
          case MySqlLexer.MODIFIES:
          case MySqlLexer.NATURAL:
          case MySqlLexer.NOT:
          case MySqlLexer.NO_WRITE_TO_BINLOG:
          case MySqlLexer.NULL_LITERAL:
          case MySqlLexer.NUMBER:
          case MySqlLexer.ON:
          case MySqlLexer.OPTIMIZE:
          case MySqlLexer.OPTION:
          case MySqlLexer.OPTIONAL:
          case MySqlLexer.OPTIONALLY:
          case MySqlLexer.OR:
          case MySqlLexer.ORDER:
          case MySqlLexer.OUT:
          case MySqlLexer.OUTER:
          case MySqlLexer.OUTFILE:
          case MySqlLexer.OVER:
          case MySqlLexer.PARTITION:
          case MySqlLexer.PRIMARY:
          case MySqlLexer.PROCEDURE:
          case MySqlLexer.PURGE:
          case MySqlLexer.RANGE:
          case MySqlLexer.READ:
          case MySqlLexer.READS:
          case MySqlLexer.REFERENCES:
          case MySqlLexer.REGEXP:
          case MySqlLexer.RELEASE:
          case MySqlLexer.RENAME:

          case MySqlLexer.DISTINCT:
          case MySqlLexer.DISTINCTROW:
          case MySqlLexer.DROP:
          case MySqlLexer.EACH:
          case MySqlLexer.ELSE:
          case MySqlLexer.ELSEIF:
          case MySqlLexer.EMPTY:
          case MySqlLexer.ENCLOSED:
          case MySqlLexer.ENFORCED:
          case MySqlLexer.ESCAPED:
          case MySqlLexer.EXCEPT:
          case MySqlLexer.EXISTS:
          case MySqlLexer.EXIT:
          case MySqlLexer.EXPLAIN:
          case MySqlLexer.FALSE:
          case MySqlLexer.FETCH:
          case MySqlLexer.FOR:
          case MySqlLexer.FORCE:
          case MySqlLexer.FOREIGN:
          case MySqlLexer.FROM:
          case MySqlLexer.FULLTEXT:
          case MySqlLexer.GENERATED:
          case MySqlLexer.GET:
          case MySqlLexer.GRANT:
          case MySqlLexer.GROUP:
          case MySqlLexer.HAVING:
          case MySqlLexer.HIGH_PRIORITY:
          case MySqlLexer.HISTOGRAM:
          case MySqlLexer.IF:
          case MySqlLexer.IGNORE:
          case MySqlLexer.IGNORED:
          case MySqlLexer.IN:
          case MySqlLexer.INDEX:
          case MySqlLexer.INFILE:
          case MySqlLexer.INNER:
          case MySqlLexer.INOUT:
          case MySqlLexer.INSERT:
          case MySqlLexer.INTERVAL:
          case MySqlLexer.INTO:
          case MySqlLexer.IS:
          case MySqlLexer.ITERATE:
          case MySqlLexer.JOIN:
          case MySqlLexer.KEY:
          case MySqlLexer.KEYS:
          case MySqlLexer.KILL:
          case MySqlLexer.LATERAL:
          case MySqlLexer.LEADING:
          case MySqlLexer.LEAVE:
          case MySqlLexer.LEFT:
          case MySqlLexer.LIKE:
            get(result, EditorColorScheme.ATTRIBUTE_NAME, true, false, line, column);
            break;

          case MySqlLexer.LIMIT:

          case MySqlLexer.REPEAT:
          case MySqlLexer.REPLACE:
          case MySqlLexer.REQUIRE:
          case MySqlLexer.RESIGNAL:
          case MySqlLexer.RESTRICT:
          case MySqlLexer.RETAIN:
          case MySqlLexer.RETURN:
          case MySqlLexer.REVOKE:
          case MySqlLexer.RIGHT:
          case MySqlLexer.RLIKE:
          case MySqlLexer.SCHEMA:
          case MySqlLexer.SCHEMAS:
          case MySqlLexer.SELECT:
          case MySqlLexer.SET:
          case MySqlLexer.SEPARATOR:
          case MySqlLexer.SHOW:
          case MySqlLexer.SIGNAL:
          case MySqlLexer.SKIP_:
          case MySqlLexer.SKIP_QUERY_REWRITE:
          case MySqlLexer.SPATIAL:
          case MySqlLexer.SQL:
          case MySqlLexer.SQLEXCEPTION:
          case MySqlLexer.SQLSTATE:
          case MySqlLexer.SQLWARNING:
          case MySqlLexer.SQL_BIG_RESULT:
          case MySqlLexer.SQL_CALC_FOUND_ROWS:
          case MySqlLexer.SQL_SMALL_RESULT:
          case MySqlLexer.SSL:
          case MySqlLexer.STACKED:
            get(result, EditorColorScheme.ATTRIBUTE_VALUE, true, false, line, column);

            break;
          case MySqlLexer.STARTING:
          case MySqlLexer.STATEMENT:
          case MySqlLexer.STRAIGHT_JOIN:
          case MySqlLexer.TABLE:
          case MySqlLexer.TERMINATED:
          case MySqlLexer.THEN:
          case MySqlLexer.TO:
          case MySqlLexer.TRAILING:
          case MySqlLexer.TRIGGER:
          case MySqlLexer.TRUE:
          case MySqlLexer.UNDO:
          case MySqlLexer.UNION:
          case MySqlLexer.UNIQUE:
          case MySqlLexer.UNLOCK:
          case MySqlLexer.UNSIGNED:
          case MySqlLexer.UPDATE:
          case MySqlLexer.USAGE:
          case MySqlLexer.USE:
          case MySqlLexer.USING:
          case MySqlLexer.VALUES:
          case MySqlLexer.WHEN:
          case MySqlLexer.WHERE:
          case MySqlLexer.WHILE:
          case MySqlLexer.WITH:
          case MySqlLexer.WRITE:
          case MySqlLexer.XOR:
          case MySqlLexer.ZEROFILL:
          case MySqlLexer.TINYINT:
          case MySqlLexer.SMALLINT:
          case MySqlLexer.MEDIUMINT:
          case MySqlLexer.MIDDLEINT:
          case MySqlLexer.INT1:
          case MySqlLexer.INT2:
          case MySqlLexer.INT3:
          case MySqlLexer.INT4:
          case MySqlLexer.INTEGER:
          case MySqlLexer.BIGINT:
          case MySqlLexer.REAL:
          case MySqlLexer.DOUBLE:
          case MySqlLexer.PRECISION:
          case MySqlLexer.FLOAT:
          case MySqlLexer.DECIMAL:
          case MySqlLexer.DEC:
          case MySqlLexer.NUMERIC:
          case MySqlLexer.DATE:
          case MySqlLexer.TIME:
          case MySqlLexer.TIMESTAMP:
          case MySqlLexer.DATETIME:
          case MySqlLexer.YEAR:
          case MySqlLexer.CHAR:
          case MySqlLexer.VARCHAR:
          case MySqlLexer.NVARCHAR:
          case MySqlLexer.NATIONAL:
          case MySqlLexer.BINARY:
          case MySqlLexer.VARBINARY:
          case MySqlLexer.TINYBLOB:
          case MySqlLexer.BLOB:
          case MySqlLexer.MEDIUMBLOB:
          case MySqlLexer.LONG:
          case MySqlLexer.LONGBLOB:
          case MySqlLexer.TINYTEXT:
          case MySqlLexer.TEXT:
          case MySqlLexer.MEDIUMTEXT:
          case MySqlLexer.LONGTEXT:
          case MySqlLexer.ENUM:
          case MySqlLexer.VARYING:
          case MySqlLexer.SERIAL:
          case MySqlLexer.YEAR_MONTH:
          case MySqlLexer.DAY_HOUR:
          case MySqlLexer.DAY_MINUTE:
          case MySqlLexer.DAY_SECOND:
          case MySqlLexer.HOUR_MINUTE:
          case MySqlLexer.HOUR_SECOND:
          case MySqlLexer.MINUTE_SECOND:
          case MySqlLexer.SECOND_MICROSECOND:
          case MySqlLexer.MINUTE_MICROSECOND:
          case MySqlLexer.HOUR_MICROSECOND:
          case MySqlLexer.DAY_MICROSECOND:
            get(result, EditorColorScheme.Ninja, false, true, line, column);
            break;
          case MySqlLexer.JSON_ARRAY:
          case MySqlLexer.JSON_ARRAYAGG:
          case MySqlLexer.JSON_ARRAY_APPEND:
          case MySqlLexer.JSON_ARRAY_INSERT:
          case MySqlLexer.JSON_CONTAINS:
          case MySqlLexer.JSON_CONTAINS_PATH:
          case MySqlLexer.JSON_DEPTH:
          case MySqlLexer.JSON_EXTRACT:
          case MySqlLexer.JSON_INSERT:
          case MySqlLexer.JSON_KEYS:
          case MySqlLexer.JSON_LENGTH:
          case MySqlLexer.JSON_MERGE:
          case MySqlLexer.JSON_MERGE_PATCH:
          case MySqlLexer.JSON_MERGE_PRESERVE:
          case MySqlLexer.JSON_OBJECT:
          case MySqlLexer.JSON_OBJECTAGG:
          case MySqlLexer.JSON_OVERLAPS:
          case MySqlLexer.JSON_PRETTY:
          case MySqlLexer.JSON_QUOTE:
          case MySqlLexer.JSON_REMOVE:
          case MySqlLexer.JSON_REPLACE:
          case MySqlLexer.JSON_SCHEMA_VALID:
          case MySqlLexer.JSON_SCHEMA_VALIDATION_REPORT:
          case MySqlLexer.JSON_SEARCH:
          case MySqlLexer.JSON_SET:
          case MySqlLexer.JSON_STORAGE_FREE:
          case MySqlLexer.JSON_STORAGE_SIZE:
          case MySqlLexer.JSON_TABLE:
          case MySqlLexer.JSON_TYPE:
          case MySqlLexer.JSON_UNQUOTE:
          case MySqlLexer.JSON_VALID:
          case MySqlLexer.JSON_VALUE:
          case MySqlLexer.NESTED:
          case MySqlLexer.ORDINALITY:
          case MySqlLexer.PATH:
          case MySqlLexer.AVG:
          case MySqlLexer.BIT_AND:
          case MySqlLexer.BIT_OR:
          case MySqlLexer.BIT_XOR:
          case MySqlLexer.COUNT:
          case MySqlLexer.CUME_DIST:
          case MySqlLexer.DENSE_RANK:
          case MySqlLexer.FIRST_VALUE:
          case MySqlLexer.GROUP_CONCAT:
          case MySqlLexer.LAG:
          case MySqlLexer.LAST_VALUE:
          case MySqlLexer.LEAD:
          case MySqlLexer.MAX:
          case MySqlLexer.MIN:
          case MySqlLexer.NTILE:
          case MySqlLexer.NTH_VALUE:
          case MySqlLexer.PERCENT_RANK:
          case MySqlLexer.RANK:
          case MySqlLexer.ROW_NUMBER:
          case MySqlLexer.STD:
          case MySqlLexer.STDDEV:
          case MySqlLexer.STDDEV_POP:
          case MySqlLexer.STDDEV_SAMP:
          case MySqlLexer.SUM:
          case MySqlLexer.VAR_POP:
          case MySqlLexer.VAR_SAMP:
          case MySqlLexer.VARIANCE:
          case MySqlLexer.CURRENT_DATE:
          case MySqlLexer.CURRENT_TIME:
          case MySqlLexer.CURRENT_TIMESTAMP:
          case MySqlLexer.LOCALTIME:
          case MySqlLexer.CURDATE:
          case MySqlLexer.CURTIME:
          case MySqlLexer.DATE_ADD:
          case MySqlLexer.DATE_SUB:
          case MySqlLexer.EXTRACT:
          case MySqlLexer.LOCALTIMESTAMP:
          case MySqlLexer.NOW:
          case MySqlLexer.POSITION:
          case MySqlLexer.SUBSTR:
          case MySqlLexer.SUBSTRING:
          case MySqlLexer.SYSDATE:
          case MySqlLexer.TRIM:
          case MySqlLexer.UTC_DATE:
          case MySqlLexer.UTC_TIME:
          case MySqlLexer.UTC_TIMESTAMP:
          case MySqlLexer.ACCOUNT:
          case MySqlLexer.ACTION:
          case MySqlLexer.AFTER:
          case MySqlLexer.AGGREGATE:
          case MySqlLexer.ALGORITHM:
          case MySqlLexer.ANY:
          case MySqlLexer.AT:
          case MySqlLexer.AUTHORS:
          case MySqlLexer.AUTOCOMMIT:
          case MySqlLexer.AUTOEXTEND_SIZE:
          case MySqlLexer.AUTO_INCREMENT:
          case MySqlLexer.AVG_ROW_LENGTH:
          case MySqlLexer.BEGIN:
          case MySqlLexer.BINLOG:
          case MySqlLexer.BIT:
          case MySqlLexer.BLOCK:
          case MySqlLexer.BOOL:
          case MySqlLexer.BOOLEAN:
          case MySqlLexer.BTREE:
          case MySqlLexer.CACHE:
          case MySqlLexer.CASCADED:
          case MySqlLexer.CHAIN:
          case MySqlLexer.CHANGED:
          case MySqlLexer.CHANNEL:
          case MySqlLexer.CHECKSUM:
          case MySqlLexer.PAGE_CHECKSUM:
          case MySqlLexer.CIPHER:
          case MySqlLexer.CLASS_ORIGIN:
          case MySqlLexer.CLIENT:
          case MySqlLexer.CLOSE:
          case MySqlLexer.CLUSTERING:
          case MySqlLexer.COALESCE:
          case MySqlLexer.CODE:
          case MySqlLexer.COLUMNS:
          case MySqlLexer.COLUMN_FORMAT:
          case MySqlLexer.COLUMN_NAME:
          case MySqlLexer.COMMIT:
          case MySqlLexer.COMPACT:
          case MySqlLexer.COMPLETION:
          case MySqlLexer.COMPRESSED:
          case MySqlLexer.COMPRESSION:
          case MySqlLexer.CONCURRENT:
          case MySqlLexer.CONNECT:
          case MySqlLexer.CONNECTION:
          case MySqlLexer.CONSISTENT:
          case MySqlLexer.CONSTRAINT_CATALOG:
          case MySqlLexer.CONSTRAINT_SCHEMA:
          case MySqlLexer.CONSTRAINT_NAME:
          case MySqlLexer.CONTAINS:
          case MySqlLexer.CONTEXT:
          case MySqlLexer.CONTRIBUTORS:
          case MySqlLexer.COPY:
          case MySqlLexer.CPU:
          case MySqlLexer.CYCLE:
          case MySqlLexer.CURSOR_NAME:
          case MySqlLexer.DATA:
          case MySqlLexer.DATAFILE:
          case MySqlLexer.DEALLOCATE:
          case MySqlLexer.DEFAULT_AUTH:
          case MySqlLexer.DEFINER:
          case MySqlLexer.DELAY_KEY_WRITE:
          case MySqlLexer.DES_KEY_FILE:
          case MySqlLexer.DIRECTORY:
          case MySqlLexer.DISABLE:
          case MySqlLexer.DISCARD:
          case MySqlLexer.DISK:
          case MySqlLexer.DO:
          case MySqlLexer.DUMPFILE:
          case MySqlLexer.DUPLICATE:
          case MySqlLexer.DYNAMIC:
          case MySqlLexer.ENABLE:
          case MySqlLexer.ENCRYPTED:
          case MySqlLexer.ENCRYPTION:
          case MySqlLexer.ENCRYPTION_KEY_ID:
          case MySqlLexer.END:
          case MySqlLexer.ENDS:
          case MySqlLexer.ENGINE:
          case MySqlLexer.ENGINES:
          case MySqlLexer.ERROR:
          case MySqlLexer.ERRORS:
          case MySqlLexer.ESCAPE:
          case MySqlLexer.EVEN:
          case MySqlLexer.EVENT:
          case MySqlLexer.EVENTS:
          case MySqlLexer.EVERY:
          case MySqlLexer.EXCHANGE:
          case MySqlLexer.EXCLUSIVE:
          case MySqlLexer.EXPIRE:
          case MySqlLexer.EXPORT:
          case MySqlLexer.EXTENDED:
          case MySqlLexer.EXTENT_SIZE:
          case MySqlLexer.FAILED_LOGIN_ATTEMPTS:
          case MySqlLexer.FAST:
          case MySqlLexer.FAULTS:
          case MySqlLexer.FIELDS:
          case MySqlLexer.FILE_BLOCK_SIZE:
          case MySqlLexer.FILTER:
          case MySqlLexer.FIRST:
          case MySqlLexer.FIXED:
          case MySqlLexer.FLUSH:
          case MySqlLexer.FOLLOWING:
          case MySqlLexer.FOLLOWS:
          case MySqlLexer.FOUND:
          case MySqlLexer.FULL:
          case MySqlLexer.FUNCTION:
          case MySqlLexer.GENERAL:
          case MySqlLexer.GLOBAL:
          case MySqlLexer.GRANTS:
          case MySqlLexer.GROUP_REPLICATION:
          case MySqlLexer.HANDLER:
          case MySqlLexer.HASH:
          case MySqlLexer.HELP:
          case MySqlLexer.HISTORY:
          case MySqlLexer.HOST:
          case MySqlLexer.HOSTS:
          case MySqlLexer.IDENTIFIED:
          case MySqlLexer.IGNORE_SERVER_IDS:
          case MySqlLexer.IMPORT:
          case MySqlLexer.INCREMENT:
          case MySqlLexer.INDEXES:
          case MySqlLexer.INITIAL_SIZE:
          case MySqlLexer.INPLACE:
          case MySqlLexer.INSERT_METHOD:
          case MySqlLexer.INSTALL:
          case MySqlLexer.INSTANCE:
          case MySqlLexer.INSTANT:
          case MySqlLexer.INVISIBLE:
          case MySqlLexer.INVOKER:
          case MySqlLexer.IO:
          case MySqlLexer.IO_THREAD:
          case MySqlLexer.IPC:
          case MySqlLexer.ISOLATION:
          case MySqlLexer.ISSUER:
          case MySqlLexer.JSON:
          case MySqlLexer.KEY_BLOCK_SIZE:
          case MySqlLexer.LANGUAGE:
          case MySqlLexer.LAST:
          case MySqlLexer.LEAVES:
          case MySqlLexer.LESS:
          case MySqlLexer.LEVEL:
          case MySqlLexer.LIST:
          case MySqlLexer.LOCAL:
          case MySqlLexer.LOGFILE:
          case MySqlLexer.LOGS:
          case MySqlLexer.MASTER:
          case MySqlLexer.MASTER_AUTO_POSITION:
          case MySqlLexer.MASTER_CONNECT_RETRY:
          case MySqlLexer.MASTER_DELAY:
          case MySqlLexer.MASTER_HEARTBEAT_PERIOD:
          case MySqlLexer.MASTER_HOST:
          case MySqlLexer.MASTER_LOG_FILE:
          case MySqlLexer.MASTER_LOG_POS:
          case MySqlLexer.MASTER_PASSWORD:
          case MySqlLexer.MASTER_PORT:
          case MySqlLexer.MASTER_RETRY_COUNT:
          case MySqlLexer.MASTER_SSL:
          case MySqlLexer.MASTER_SSL_CA:
          case MySqlLexer.MASTER_SSL_CAPATH:
          case MySqlLexer.MASTER_SSL_CERT:
          case MySqlLexer.MASTER_SSL_CIPHER:
          case MySqlLexer.MASTER_SSL_CRL:
          case MySqlLexer.MASTER_SSL_CRLPATH:
          case MySqlLexer.MASTER_SSL_KEY:
          case MySqlLexer.MASTER_TLS_VERSION:
          case MySqlLexer.MASTER_USER:
          case MySqlLexer.MAX_CONNECTIONS_PER_HOUR:
          case MySqlLexer.MAX_QUERIES_PER_HOUR:
          case MySqlLexer.MAX_ROWS:
          case MySqlLexer.MAX_SIZE:
          case MySqlLexer.MAX_UPDATES_PER_HOUR:
          case MySqlLexer.MAX_USER_CONNECTIONS:
          case MySqlLexer.MEDIUM:
          case MySqlLexer.MEMBER:
          case MySqlLexer.MERGE:
          case MySqlLexer.MESSAGE_TEXT:
          case MySqlLexer.MID:
          case MySqlLexer.MIGRATE:
          case MySqlLexer.MIN_ROWS:
          case MySqlLexer.MODE:
          case MySqlLexer.MODIFY:
          case MySqlLexer.MUTEX:
          case MySqlLexer.MYSQL:
          case MySqlLexer.MYSQL_ERRNO:
          case MySqlLexer.NAME:
          case MySqlLexer.NAMES:
          case MySqlLexer.NCHAR:
          case MySqlLexer.NEVER:
          case MySqlLexer.NEXT:
          case MySqlLexer.NO:
          case MySqlLexer.NOCACHE:
          case MySqlLexer.NOCOPY:
          case MySqlLexer.NOCYCLE:
          case MySqlLexer.NOMAXVALUE:
          case MySqlLexer.NOMINVALUE:
          case MySqlLexer.NOWAIT:
          case MySqlLexer.NODEGROUP:
          case MySqlLexer.NONE:
          case MySqlLexer.ODBC:
          case MySqlLexer.OFFLINE:
          case MySqlLexer.OFFSET:
          case MySqlLexer.OF:
          case MySqlLexer.OJ:
          case MySqlLexer.OLD_PASSWORD:
          case MySqlLexer.ONE:
          case MySqlLexer.ONLINE:
          case MySqlLexer.ONLY:
          case MySqlLexer.OPEN:
          case MySqlLexer.OPTIMIZER_COSTS:
          case MySqlLexer.OPTIONS:
          case MySqlLexer.OWNER:
          case MySqlLexer.PACK_KEYS:
          case MySqlLexer.PAGE:
          case MySqlLexer.PAGE_COMPRESSED:
          case MySqlLexer.PAGE_COMPRESSION_LEVEL:
          case MySqlLexer.PARSER:
          case MySqlLexer.PARTIAL:
          case MySqlLexer.PARTITIONING:
          case MySqlLexer.PARTITIONS:
          case MySqlLexer.PASSWORD:
          case MySqlLexer.PASSWORD_LOCK_TIME:
          case MySqlLexer.PHASE:
          case MySqlLexer.PLUGIN:
          case MySqlLexer.PLUGIN_DIR:
          case MySqlLexer.PLUGINS:
          case MySqlLexer.PORT:
          case MySqlLexer.PRECEDES:
          case MySqlLexer.PRECEDING:
          case MySqlLexer.PREPARE:
          case MySqlLexer.PRESERVE:
          case MySqlLexer.PREV:
          case MySqlLexer.PROCESSLIST:
          case MySqlLexer.PROFILE:
          case MySqlLexer.PROFILES:
          case MySqlLexer.PROXY:
          case MySqlLexer.QUERY:
          case MySqlLexer.QUICK:
          case MySqlLexer.REBUILD:
          case MySqlLexer.RECOVER:
          case MySqlLexer.RECURSIVE:
          case MySqlLexer.REDO_BUFFER_SIZE:
          case MySqlLexer.REDUNDANT:
          case MySqlLexer.RELAY:
          case MySqlLexer.RELAY_LOG_FILE:
          case MySqlLexer.RELAY_LOG_POS:
          case MySqlLexer.RELAYLOG:
          case MySqlLexer.REMOVE:
          case MySqlLexer.REORGANIZE:
          case MySqlLexer.REPAIR:
          case MySqlLexer.REPLICATE_DO_DB:
          case MySqlLexer.REPLICATE_DO_TABLE:
          case MySqlLexer.REPLICATE_IGNORE_DB:
          case MySqlLexer.REPLICATE_IGNORE_TABLE:
          case MySqlLexer.REPLICATE_REWRITE_DB:
          case MySqlLexer.REPLICATE_WILD_DO_TABLE:
          case MySqlLexer.REPLICATE_WILD_IGNORE_TABLE:
          case MySqlLexer.REPLICATION:
          case MySqlLexer.RESET:
          case MySqlLexer.RESTART:
          case MySqlLexer.RESUME:
          case MySqlLexer.RETURNED_SQLSTATE:
          case MySqlLexer.RETURNING:
          case MySqlLexer.RETURNS:
          case MySqlLexer.REUSE:
          case MySqlLexer.ROLE:
          case MySqlLexer.ROLLBACK:
          case MySqlLexer.ROLLUP:
          case MySqlLexer.ROTATE:
          case MySqlLexer.ROW:
          case MySqlLexer.ROWS:
          case MySqlLexer.ROW_FORMAT:
          case MySqlLexer.RTREE:
          case MySqlLexer.SAVEPOINT:
          case MySqlLexer.SCHEDULE:
          case MySqlLexer.SECURITY:
          case MySqlLexer.SEQUENCE:
          case MySqlLexer.SERVER:
          case MySqlLexer.SESSION:
          case MySqlLexer.SHARE:
          case MySqlLexer.SHARED:
          case MySqlLexer.SIGNED:
          case MySqlLexer.SIMPLE:
          case MySqlLexer.SLAVE:
          case MySqlLexer.SLOW:
          case MySqlLexer.SNAPSHOT:
          case MySqlLexer.SOCKET:
          case MySqlLexer.SOME:
          case MySqlLexer.SONAME:
          case MySqlLexer.SOUNDS:
          case MySqlLexer.SOURCE:
          case MySqlLexer.SQL_AFTER_GTIDS:
          case MySqlLexer.SQL_AFTER_MTS_GAPS:
          case MySqlLexer.SQL_BEFORE_GTIDS:
          case MySqlLexer.SQL_BUFFER_RESULT:
          case MySqlLexer.SQL_CACHE:
          case MySqlLexer.SQL_NO_CACHE:
          case MySqlLexer.SQL_THREAD:
          case MySqlLexer.START:
          case MySqlLexer.STARTS:
          case MySqlLexer.STATS_AUTO_RECALC:
          case MySqlLexer.STATS_PERSISTENT:
          case MySqlLexer.STATS_SAMPLE_PAGES:
          case MySqlLexer.STATUS:
          case MySqlLexer.STOP:
          case MySqlLexer.STORAGE:
          case MySqlLexer.STORED:
          case MySqlLexer.STRING:
          case MySqlLexer.SUBCLASS_ORIGIN:
          case MySqlLexer.SUBJECT:
          case MySqlLexer.SUBPARTITION:
          case MySqlLexer.SUBPARTITIONS:
          case MySqlLexer.SUSPEND:
          case MySqlLexer.SWAPS:
          case MySqlLexer.SWITCHES:
          case MySqlLexer.TABLE_NAME:
          case MySqlLexer.TABLESPACE:
          case MySqlLexer.TABLE_TYPE:
          case MySqlLexer.TEMPORARY:
          case MySqlLexer.TEMPTABLE:
            get(result, EditorColorScheme.KEYWORD, true, false, line, column);
            break;
            // color hex

          case MySqlLexer.HEXADECIMAL_LITERAL:
            get(result, EditorColorScheme.COLOR_WARNING, true, false, line, column);
            break;

          case MySqlLexer.ERROR_RECONGNIGION:
            get(result, EditorColorScheme.KEYWORD, false, false, line, column);
            break;
          case MySqlLexer.CHARSET_REVERSE_QOUTE_STRING:
            get(result, EditorColorScheme.LITERAL, true, true, line, column);
            break;

          default:
            get(result, EditorColorScheme.TEXT_NORMAL, false, false, line, column);
            break;
        }

//        if (type != MySqlLexer.SPACE) {
//          previous = type;
//        }
        frist = true;
        result.determine(lastLine);
      }

    } catch (Exception err) {

    }
  }

  void get(
      TextAnalyzeResult colors, int color, boolean isBold, boolean isItalic, int line, int colum) {
    colors.addIfNeeded(line, colum, TextStyle.makeStyle(color, 0, isBold, isItalic, false));
  }
}
