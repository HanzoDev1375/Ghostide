package io.github.rosemoe.sora.langs.php;

import android.os.Build;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.Token;

import java.io.StringReader;

import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.interfaces.CodeAnalyzer;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.interfaces.NewlineHandler;
import io.github.rosemoe.sora.langs.html.HTMLAutoComplete;
import io.github.rosemoe.sora.langs.internal.MyCharacter;
import io.github.rosemoe.sora.text.TextUtils;
import io.github.rosemoe.sora.widget.SymbolPairMatch;
import ir.ninjacoder.ghostide.core.IdeEditor;

public class PHPLanguage implements EditorLanguage {

  private IdeEditor editor;
  private boolean isSdk33 = Build.VERSION.SDK_INT >= 33;

  public PHPLanguage(IdeEditor editor) {
    this.editor = editor;
  }

  public static String[] key = {
    "abstract",
    "array",
    "as",
    "binary",
    "break",
    "callable",
    "case",
    "catch",
    "class",
    "clone",
    "const",
    "continue",
    "declare",
    "default",
    "do",
    "real",
    "double",
    "echo",
    "else",
    "elseif",
    "empty",
    "enddeclare",
    "endfor",
    "endforeach",
    "endif",
    "endswitch",
    "endwhile",
    "eval",
    "die",
    "extends",
    "final",
    "finally",
    "float",
    "for",
    "foreach",
    "function",
    "global",
    "goto",
    "if",
    "implements",
    "import",
    "include",
    "include_once",
    "instanceof",
    "insteadof",
    "int8",
    "int16",
    "int64",
    "int",
    "interface",
    "isset",
    "list",
    "and",
    "or",
    "xor",
    "match",
    "namespace",
    "new",
    "null",
    "object",
    "parent",
    "partial",
    "print",
    "private",
    "protected",
    "public",
    "require",
    "require_once",
    "resource",
    "return",
    "static",
    "string",
    "switch",
    "throw",
    "trait",
    "try",
    "clrtypeof",
    "unicode",
    "unset",
    "use",
    "var",
    "while",
    "yield",
    "from",
    "fn"
  };
  public static String[] phpFuns = {
    "__halt_compiler()",
    "usleep()",
    "unpack()",
    "uniqid()",
    "time_sleep_until()",
    "time_nanosleep()",
    "sleep()",
    "show_source()",
    "strip_whitespace()",
    "pack()",
    "ignore_user_abort()",
    "highlight_string()",
    "highlight_file()",
    "get_browser()",
    "exit()",
    "eval()",
    "die()",
    "defined()",
    "define()",
    "constant()",
    "connection_status()",
    "connection_aborted()",
    "zip_read()",
    "zip_open()",
    "zip_entry_read()",
    "zip_entry_open()",
    "zip_entry_name()",
    "zip_entry_filesize()",
    "zip_entry_compressionmethod()",
    "zip_entry_compressedsize()",
    "zip_entry_close()",
    "zip_close()",
    "xml_set_unparsed_entity_decl_handler()",
    "xml_set_processing_instruction_handler()",
    "xml_set_object()",
    "xml_set_notation_decl_handler()",
    "xml_set_external_entity_ref_handler()",
    "xml_set_element_handler()",
    "xml_set_default_handler()",
    "xml_set_character_data_handler()",
    "xml_parser_set_option()",
    "xml_parser_get_option()",
    "xml_parser_free()",
    "xml_parser_create()",
    "xml_parser_create_ns()",
    "xml_parse_into_struct()",
    "xml_parse()",
    "xml_get_error_code()",
    "xml_get_current_line_number()",
    "xml_get_current_column_number()",
    "xml_get_current_byte_index()",
    "xml_error_string()",
    "utf8_encode()",
    "utf8_decode()",
    "wordwrap()",
    "vsprintf()",
    "vprintf()",
    "vfprintf()",
    "ucwords()",
    "ucfirst()",
    "trim()",
    "substr_replace()",
    "substr_count()",
    "substr_compare()",
    "substr()",
    "strtr()",
    "strtoupper()",
    "strtolower()",
    "strtok()",
    "strstr()",
    "strspn()",
    "strrpos()",
    "strripos()",
    "strrev()",
    "strrchr()",
    "strpos()",
    "strpbrk()",
    "strncmp()",
    "strncasecmp()",
    "strnatcmp()",
    "strnatcasecmp()",
    "strlen()",
    "stristr()",
    "stripos()",
    "stripslashes()",
    "stripcslashes()",
    "strip_tags()",
    "strcspn()",
    "strcoll()",
    "strcmp()",
    "strchr()",
    "strcasecmp()",
    "str_word_count()",
    "str_split()",
    "str_shuffle()",
    "str_rot13()",
    "str_replace()",
    "str_repeat()",
    "str_pad()",
    "str_ireplace()",
    "sscanf()",
    "sprintf()",
    "soundex()",
    "similar_text()",
    "sha1_file()",
    "sha1()",
    "setlocale()",
    "rtrim()",
    "rtrim()",
    "PHP",
    "quotemeta()",
    "quoted_printable_decode()",
    "printf()",
    "print()",
    "parse_str()",
    "ord()",
    "number_format()",
    "nl2br()",
    "nl_langinfo()",
    "money_format()",
    "metaphone()",
    "md5_file()",
    "md5()",
    "ltrim()",
    "localeconv()",
    "levenshtein()",
    "",
    "implode()",
    "htmlspecialchars()",
    "html_entity_decode()",
    "chars_decode()",
    "PHP",
    "htmlentities()",
    "html_entity_decode()",
    "hebrevc()",
    "hebrev()",
    "get_html_translation_table()",
    "fprintf()",
    "explode()",
    "echo()",
    "crypt()",
    "crc32()",
    "count_chars()",
    "convert_uuencode()",
    "convert_uudecode()",
    "convert_cyr_string()",
    "chunk_split()",
    "chr()",
    "chop()",
    "bin2hex()",
    "addslashes()",
    "addcslashes()",
    "xpath()",
    "simplexml_load_string()",
    "simplexml_load_file()",
    "simplexml_import_dom()",
    "registerXPathNamespace()",
    "getNamespace()",
    "getName()",
    "getDocNamespaces()",
    "children()",
    "attributes()",
    "asXML()",
    "addChild()",
    "addAttribute()",
    "__construct()",
    "mysql_unbuffered_query()",
    "mysql_thread_id()",
    "mysql_stat()",
    "mysql_select_db()",
    "mysql_result()",
    "mysql_real_escape_string()",
    "mysql_query()",
    "mysql_ping()",
    "mysql_pconnect()",
    "mysql_num_rows()",
    "mysql_num_fields()",
    "mysql_list_processes()",
    "mysql_list_dbs()",
    "mysql_insert_id()",
    "mysql_info()",
    "mysql_get_server_info()",
    "mysql_get_proto_info()",
    "mysql_get_host_info()",
    "mysql_get_client_info()",
    "mysql_free_result()",
    "mysql_field_type()",
    "mysql_field_table()",
    "mysql_field_seek()",
    "mysql_field_name()",
    "mysql_field_len()",
    "mysql_field_flags()",
    "mysql_fetch_row()",
    "mysql_fetch_object()",
    "mysql_fetch_lengths()",
    "mysql_fetch_field()",
    "mysql_fetch_assoc()",
    "mysql_fetch_array()",
    "mysql_errno()",
    "mysql_db_name()",
    "mysql_data_seek()",
    "mysql_connect()",
    "mysql_close()",
    "mysql_client_encoding()",
    "mysql_affected_rows()",
    "tanh()",
    "tan()",
    "srand()",
    "sqrt()",
    "sinh()",
    "sin()",
    "round()",
    "rand()",
    "rad2deg()",
    "pow()",
    "pi()",
    "octdec()",
    "mt_srand()",
    "mt_rand()",
    "mt_getrandmax()",
    "min()",
    "log1p()",
    "log10()",
    "lcg_value()",
    "is_nan()",
    "is_finite()",
    "hypot()",
    "hexdec()",
    "fmod()",
    "fmod()",
    "floor()",
    "expm1()",
    "exp()",
    "deg2rad()",
    "decoct()",
    "dechex()",
    "decbin()",
    "cosh()",
    "cos()",
    "ceil()",
    "bindec()",
    "base_convert()",
    "atanh()",
    "atan()",
    "PHP",
    "asinh()",
    "asin()",
    "acosh()",
    "acos()",
    "abs()",
    "mail()",
    "libxml_use_internal_errors()",
    "libxml_get_last_error()",
    "libxml_get_errors()",
    "libxml_clear_errors()",
    "setrawcookie()",
    "setcookie()",
    "headers_sent()",
    "headers_list()",
    "header()",
    "ftp_systype()",
    "ftp_ssl_connect()",
    "ftp_size()",
    "ftp_site()",
    "ftp_set_option()",
    "ftp_rmdir()",
    "ftp_rename()",
    "ftp_rawlist()",
    "ftp_raw()",
    "ftp_quit()",
    "ftp_pwd()",
    "ftp_put()",
    "ftp_pasv()",
    "ftp_nlist()",
    "ftp_nb_put()",
    "ftp_nb_get()",
    "ftp_nb_fput()",
    "ftp_nb_fget()",
    "ftp_nb_continue()",
    "ftp_mkdir()",
    "ftp_mdtm()",
    "ftp_login()",
    "ftp_get()",
    "ftp_get_option()",
    "ftp_fput()",
    "ftp_fget()",
    "ftp_exec()",
    "ftp_connect()",
    "ftp_close()",
    "ftp_chmod()",
    "ftp_chdir()",
    "ftp_cdup()",
    "ftp_alloc()",
    "filter_var()",
    "filter_var_array()",
    "filter_list()",
    "filter_input_array()",
    "filter_input()",
    "filter_id()",
    "filter_has_var()",
    "unlink()",
    "umask()",
    "touch()",
    "tmpfile()",
    "tempnam()",
    "symlink()",
    "stat()",
    "set_file_buffer()",
    "rmdir()",
    "rewind()",
    "rename()",
    "realpath()",
    "readlink()",
    "readfile()",
    "popen()",
    "pclose()",
    "pathinfo()",
    "parse_ini_file()",
    "move_uploaded_file()",
    "mkdir()",
    "lstat()",
    "linkinfo()",
    "link()",
    "is_writeable()",
    "is_writable()",
    "is_uploaded_file()",
    "is_readable()",
    "is_link()",
    "is_file()",
    "is_executable()",
    "is_dir()",
    "glob()",
    "fwrite()",
    "ftruncate()",
    "ftell()",
    "fstat()",
    "fseek()",
    "fscanf()",
    "fread()",
    "fputs()",
    "fputcsv()",
    "fpassthru()",
    "fopen()",
    "fnmatch()",
    "flock()",
    "filetype()",
    "filesize()",
    "fileperms()",
    "fileowner()",
    "filemtime()",
    "fileinode()",
    "filegroup()",
    "filectime()",
    "fileatime()",
    "file_put_contents()",
    "file_get_contents()",
    "file_exists()",
    "file()",
    "fgetss()",
    "fgets()",
    "fgetcsv()",
    "fgetc()",
    "fflush()",
    "feof()",
    "fclose()",
    "diskfreespace()",
    "disk_total_space()",
    "disk_free_space()",
    "dirname()",
    "clearstatcache()",
    "clearstatcache()",
    "chown()",
    "chmod()",
    "chgrp()",
    "basename()",
    "set_exception_handler()",
    "",
    "PHP",
    "set_exception_handler()",
    "set_error_handler()",
    "restore_exception_handler()",
    "set_exception_handler()",
    "restore_error_handler()",
    "set_error_handler()",
    "error_reporting()",
    "error_log()",
    "error_get_last()",
    "debug_print_backtrace()",
    "debug_backtrace()",
    "PHP",
    "scandir()",
    "rewinddir()",
    "opendir()",
    "readdir()",
    "opendir()",
    "getcwd()",
    "closedir()",
    "dir()",
    "chroot()",
    "chdir()",
    "time()",
    "strtotime()",
    "strptime()",
    "strftime()",
    "mktime()",
    "microtime()",
    "localtime()",
    "idate()",
    "gmstrftime()",
    "gmmktime()",
    "gmdate()",
    "gettimeofday()",
    "getdate()",
    "date()",
    "date_sunset()",
    "date_sunrise()",
    "date_default_timezone_set()",
    "date_default_timezone_get()",
    "checkdate()",
    "UnixToJD()",
    "JulianToJD()",
    "JewishToJD()",
    "JDToUnix()",
    "PHP",
    "JDToGregorian()",
    "JDToFrench()",
    "JDMonthName()",
    "JDDayOfWeek()",
    "GregorianToJD()",
    "FrenchToJD()",
    "easter_days()",
    "easter_date()",
    "cal_to_jd()",
    "cal_info()",
    "cal_from_jd()",
    "cal_days_in_month()",
    "uksort()",
    "uasort()",
    "sort()",
    "sizeof()",
    "shuffle()",
    "rsort()",
    "reset()",
    "range()",
    "prev()",
    "PHP",
    "pos()",
    "next()",
    "natsort()",
    "natcasesort()",
    "list()",
    "ksort()",
    "krsort()",
    "key()",
    "in_array()",
    "extract()",
    "PHP",
    "end()",
    "each()",
    "current()",
    "count()",
    "compact()",
    "asort()",
    "arsort()",
    "array_walk_recursive()",
    "cursive()",
    "array_walk()",
    "array_values()",
    "array_unshift()",
    "array_unique()",
    "array_uintersect_assoc()",
    "array_uintersect()",
    "array_udiff_uassoc()",
    "array_udiff_assoc()",
    "array_udiff()",
    "array_sum()",
    "array_splice()",
    "array_slice()",
    "array_shift()",
    "array_search()",
    "array_reverse()",
    "array_reduce()",
    "array_rand()",
    "array_push()",
    "array_product()",
    "array_pop()",
    "array_pad()",
    "array_multisort()",
    "array_merge_recursive()",
    "array_merge()",
    "array_map()",
    "array_keys()",
    "array_key_exists()",
    "array_intersect_ukey()",
    "array_intersect_uassoc()",
    "array_intersect_key()",
    "array_intersect_assoc()",
    "array_intersect()",
    "array_flip()",
    "array_filter()",
    "array_fill()",
    "array_diff_ukey()",
    "array_diff_uassoc()",
    "array_diff_key()",
    "array_diff_assoc()",
    "array_diff()",
    "array_count_values()",
    "array_combine()",
    "array_chunk()",
    "array_change_key_case()",
    "array()",
    "phpinfo()"
  };

  @Override
  public CharSequence format(CharSequence text) {
    return text;
  }

  @Override
  public CodeAnalyzer getAnalyzer() {
    return new PHPCodeAnalyzer(editor);
  }

  @Override
  public AutoCompleteProvider getAutoCompleteProvider() {
    return new HTMLAutoComplete(editor);
  }

  @Override
  public int getIndentAdvance(String content) {
    try {
      PhpLexer lexer = new PhpLexer(CharStreams.fromReader(new StringReader(content)));
      Token token;
      int advance = 0;
      while (((token = lexer.nextToken()) != null && token.getType() != token.EOF)) {
        switch (token.getType()) {
          case PhpLexer.OpenCurlyBracket:
          case PhpLexer.OpenRoundBracket:
          case PhpLexer.OpenSquareBracket:
            advance++;
            break;
          case PhpLexer.CloseCurlyBracket:
          case PhpLexer.CloseRoundBracket:
          case PhpLexer.CloseSquareBracket:
            advance--;
            break;
        }
      }
      advance = Math.max(0, advance);
      return advance * 4;
    } catch (Exception err) {

    }
    return 0;
  }

  @Override
  public NewlineHandler[] getNewlineHandlers() {
    return new NewlineHandler[] {
      new StartTagHandler(),
      new EndTagHandler(),
      new EndTagAttributeHandler(),
      new Css3CodeHandler()
    };
  }

  @Override
  public SymbolPairMatch getSymbolPairs() {
    return new SymbolPairMatch.DefaultSymbolPairs();
  }

  @Override
  public boolean isAutoCompleteChar(char ch) {
    return MyCharacter.isJavaIdentifierPart(ch)
        || Character.isDigit(ch)
        || ch == '?'
        || ch == '.'
        || ch == '_'
        || ch == '/'
        || ch == '$';
  }

  @Override
  public boolean useTab() {
    return true;
  }

  class Css3CodeHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.endsWith("{") && afterText.startsWith("}")
          || beforeText.endsWith("?>") && afterText.startsWith("<?php");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      int advanceBefore = getIndentAdvance(beforeText);
      int advanceAfter = getIndentAdvance(afterText);
      String text;
      StringBuilder sb =
          new StringBuilder("\n")
              .append(TextUtils.createIndent(count + advanceBefore, tabSize, useTab()))
              .append('\n')
              .append(text = TextUtils.createIndent(count + advanceAfter, tabSize, useTab()));
      int shiftLeft = text.length() + 1;
      return new HandleResult(sb, shiftLeft);
    }
  }

  private class EndTagHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      String trim = beforeText.trim();
      if (!trim.startsWith("<") || !trim.startsWith("<?php")) {
        return false;
      }
      if (!trim.endsWith(">") || !trim.endsWith("?>")) {
        return false;
      }
      return afterText.trim().startsWith("</") || !trim.endsWith("?>");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      String middle;
      StringBuilder sb = new StringBuilder();
      sb.append('\n');
      sb.append(TextUtils.createIndent(count + tabSize, tabSize, useTab()));
      sb.append('\n');
      sb.append(middle = TextUtils.createIndent(count, tabSize, useTab()));
      return new HandleResult(sb, middle.length() + 1);
    }
  }

  private class EndTagAttributeHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      return beforeText.trim().endsWith(">") && afterText.trim().startsWith("</")
          || beforeText.endsWith("?>") && afterText.startsWith("<?");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      String middle;
      StringBuilder sb = new StringBuilder();
      sb.append('\n');
      sb.append(TextUtils.createIndent(count, tabSize, useTab()));
      sb.append('\n');
      sb.append(middle = TextUtils.createIndent(count - tabSize, tabSize, useTab()));
      return new HandleResult(sb, middle.length() + 1);
    }
  }

  private class StartTagHandler implements NewlineHandler {

    @Override
    public boolean matchesRequirement(String beforeText, String afterText) {
      String trim = beforeText.trim();
      return trim.startsWith("<") && !trim.endsWith(">")
          || beforeText.endsWith("?>") && afterText.startsWith("<?");
    }

    @Override
    public HandleResult handleNewline(String beforeText, String afterText, int tabSize) {
      int count = TextUtils.countLeadingSpaceCount(beforeText, tabSize);
      String text;
      StringBuilder sb =
          new StringBuilder()
              .append("\n")
              .append(TextUtils.createIndent(count + tabSize, tabSize, useTab()));
      return new HandleResult(sb, 0);
    }
  }
}
