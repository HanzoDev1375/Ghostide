package io.github.rosemoe.sora.langs.desc;

import io.github.rosemoe.sora.langs.universal.LanguageDescription;


public class RubyDescription implements LanguageDescription {
    public boolean isLineCommentStart(char c, char c2) {
        return c == '#' && c2 == '#';
    }

    public boolean isLongCommentEnd(char c, char c2) {
        return c == '#' && c2 == '#';
    }

    public boolean isLongCommentStart(char c, char c2) {
        return c == '#' && c2 == '#';
    }

    public boolean isSupportBlockLine() {
        return true;
    }

    public boolean useTab() {
        return false;
    }

    public boolean isOperator(char[] cArr, int i) {
        if (i != 1) {
            return false;
        }
        char c = cArr[0];
        return c == '+' || c == '-' || c == '{' || c == '}' || c == '[' || c == ']' || c == '(' || c == ')' || c == '|' || c == ':' || c == '.' || c == ',' || c == ';' || c == '*' || c == '/' || c == '&' || c == '^' || c == '%' || c == '!' || c == '~' || c == '<' || c == '>' || c == '=' || c == '\\' || c == '#';
    }

    public String[] getKeywords() {
        return new String[]{
                "abort", "array", "assert", "assert_equal", "assert_not_equal", "assert_same", "assert_not_same",
                "assert_nil", "assert_not_nil", "assert_match", "assert_no_match", "assert_in_delta", "assert_throws",
                "assert_raise", "assert_nothing_raised", "assert_instance_of", "assert_kind_of assert_respond_to",
                "assert_operator", "assert_send", "assert_difference", "assert_no_difference assert_recognizes",
                "assert_generates", "assert_response", "assert_redirected_to", "assert_template", "assert_select",
                "assert_select_email", "assert_select_rjs", "assert_select_encoded", "css_select", "at_exit",
                "attr", "attr_writer", "attr_reader", "attr_accessor", "attr_accessible", "autoload", "binding", "block_given?", "callcc",
                "caller", "catch", "chomp", "chomp!", "chop", "chop!", "defined?", "delete_via_redirect", "eval", "exec", "exit",
                "exit!", "fail", "Float", "flunk", "follow_redirect!", "fork", "form_for", "form_tag", "format", "gets", "global_variables", "gsub",
                "gsub!", "get_via_redirect", "host!", "https?", "https!", "include", "Integer", "lambda", "link_to",
                "link_to_unless_current", "link_to_function", "link_to_remote", "load", "local_variables", "loop", "open", "open_session",
                "p", "print", "printf", "proc", "putc", "puts", "post_via_redirect", "put_via_redirect", "raise", "rand",
                "raw", "readline", "readlines", "redirect?", "request_via_redirect", "require", "scan", "select",
                "set_trace_func sleep", "split", "sprintf", "srand", "string", "stylesheet_link_tag", "syscall", "system", "sub", "sub!", "test",
                "throw", "trace_var", "trap", "untrace_var", "atan2", "cos", "exp", "frexp", "ldexp", "log", "log10", "sin", "sqrt", "tan",
                "render", "javascript_include_tag", "csrf_meta_tag", "label_tag", "text_field_tag", "submit_tag", "check_box_tag",
                "content_tag", "radio_button_tag", "text_area_tag", "password_field_tag", "hidden_field_tag",
                "fields_for", "select_tag", "options_for_select", "options_from_collection_for_select", "collection_select",
                "time_zone_select", "select_date", "select_time", "select_datetime", "date_select", "time_select", "datetime_select",
                "select_year", "select_month", "select_day", "select_hour", "select_minute", "select_second", "file_field_tag",
                "file_field", "respond_to", "skip_before_filter", "around_filter", "after_filter", "verify",
                "protect_from_forgery", "rescue_from", "helper_method", "redirect_to", "before_filter",
                "send_data", "send_filevalidates_presence_of", "validates_uniqueness_of", "validates_length_of",
                "validates_format_of", "validates_acceptance_of", "validates_associated", "validates_exclusion_of",
                "validates_inclusion_of", "validates_numericality_of", "validates_with validates_each",
                "authenticate_or_request_with_http_basic", "authenticate_or_request_with_http_digest",
                "filter_parameter_logging", "match", "get", "post", "resources", "redirect", "scope", "assert_routing",
                "translate", "localize", "extract_locale_from_tld", "caches_page", "expire_page", "caches_action", "expire_action",
                "cache", "expire_fragment", "expire_cache_for", "observe", "cache_sweeper",
                "has_many", "has_one", "belongs_to", "has_and_belongs_to_many",
                "alias", "and", "BEGIN", "begin", "break", "case", "class", "def", "defined", "do", "else", "elsif", "END", "end", "ensure",
                "__FILE__", "finally", "for", "gem", "if", "in", "module", "next", "not", "or", "private", "protected", "public",
                "redo", "rescue", "retry", "return", "super", "then", "undef", "unless", "until", "when", "while", "yield"
        };
    }

    public int getOperatorAdvance(String str) {
        str.hashCode();
        if (!str.equals("{")) {
            return !str.equals("}") ? 0 : -4;
        }
        return 4;
    }

    public boolean isBlockStart(String str) {
        return str.equals("{");
    }

    public boolean isBlockEnd(String str) {
        return str.equals("}");
    }
}
///code by ninja coder
