package io.github.rosemoe.sora.langs.desc;

@SuppressWarnings("SpellCheckingInspection")
public class CppDescription extends CDescription {

    @Override
    public String[] getKeywords() {
        return new String[]{
                "asm", "auto", "bool", "break", "case", "catch", "char", "class",
                "const", "const_cast", "continue", "default", "delete", "do",
                "double", "dynamic_cast", "else", "enum", "explicit", "export",
                "extern", "false", "float", "for", "friend", "goto", "if", "inline",
                "int", "long", "mutable", "namespace", "new", "operator",
                "private", "protected", "public", "register", "reinterpret_cast",
                "return", "short", "signed", "sizeof", "static", "static_cast",
                "struct", "switch", "template", "this", "throw", "true", "try",
                "typedef", "typeid", "typename", "unsigned", "union",
                "using", "virtual", "void", "volatile", "wchar_t", "while", "define", "include",
                "_Bool", "char16_t", "char32_t", "endif", "end", "button", "ifdef", "int16_t", "int32_t", "int64_t", "intptr_t", "int_fast16_t", "int_fast32_t", "int_fast64_t",
                "double_t", "abort()", "abs()", "acos()", "acosf()", "acoshf()", "acosh()", "alignof()", "alloca()", "android_get_device_api_level()", "arc4random()", "arc4random_buf()", "arc4random_uniform()", "argc", "argv", "asctime()", "asctime_r()", "asin()",
                "bcopy()", "blkcnt_t", "blksize_t", "bsearch()", "btowc()", "bzero()", "caddr_t", "calloc()", "cbrt()", "cbrtf()", "cbrtl()", "ceil()", "ceilf()", "dynamic_cast<>()", "daddr_t", "daylight", "delete[]", "delete", "std::", "std::cout << std::boolalpha;", "std::cin >>", "std::cout << $yourcode << '\n';",
                "include <iostream>", "include <string>", "include <vector>", "vector<>", "<filesystem>", "::", "object", "std::"
        };
    }
}
