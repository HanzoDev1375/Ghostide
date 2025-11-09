package io.github.rosemoe.sora.langs.smali;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import io.github.rosemoe.sora.data.CompletionItem;
import io.github.rosemoe.sora.interfaces.AutoCompleteProvider;
import io.github.rosemoe.sora.text.TextAnalyzeResult;

public class SmAuto implements AutoCompleteProvider {

    private static final String[] INSTRUCTIONS = {
            "start",
            "end",
            "handler",
            "nop",
            "move",
            "move/from16",
            "move/16",
            "move-wide",
            "move-wide/from16",
            "move-wide/16",
            "move-object",
            "move-object/from16",
            "move-object/16",
            "move-result",
            "move-result-wide",
            "move-result-object",
            "move-exception",
            "const/4",
            "const/16",
            "const",
            "const/high16",
            "const-wide/16",
            "const-wide/32",
            "const-wide",
            "const-wide/high16",
            "const-string",
            "const-string/jumbo",
            "const-class",
            "monitor-enter",
            "monitor-exit",
            "check-cast",
            "instance-of",
            "array-length",
            "new-instance",
            "new-array",
            "filled-new-array",
            "filled-new-array/range",
            "fill-array-data",
            "cmpl-float",
            "cmpg-float",
            "cmpl-double",
            "cmpg-double",
            "cmp-long",
            "aget",
            "aget-wide",
            "aget-object",
            "aget-boolean",
            "aget-byte",
            "aget-char",
            "aget-short",
            "aput",
            "aput-wide",
            "aput-object",
            "aput-boolean",
            "aput-byte",
            "aput-char",
            "aput-short",
            "iget",
            "iget-wide",
            "iget-object",
            "iget-boolean",
            "iget-byte",
            "iget-char",
            "iget-short",
            "iput",
            "iput-wide",
            "iput-object",
            "iput-boolean",
            "iput-byte",
            "iput-char",
            "iput-short",
            "sget",
            "sget-wide",
            "sget-object",
            "sget-boolean",
            "sget-byte",
            "sget-char",
            "sget-short",
            "sput",
            "sput-wide",
            "sput-object",
            "sput-boolean",
            "sput-byte",
            "sput-char",
            "sput-short",
            "invoke-virtual",
            "invoke-super",
            "invoke-direct",
            "invoke-static",
            "invoke-interface",
            "invoke-virtual/range",
            "invoke-super/range",
            "invoke-direct/range",
            "invoke-static/range",
            "invoke-interface/range",
            "neg-int",
            "not-int",
            "neg-long",
            "not-long",
            "neg-float",
            "neg-double",
            "int-to-long",
            "int-to-float",
            "int-to-double",
            "long-to-int",
            "long-to-float",
            "long-to-double",
            "float-to-int",
            "float-to-long",
            "float-to-double",
            "double-to-int",
            "double-to-long",
            "double-to-float",
            "int-to-byte",
            "int-to-char",
            "int-to-short",
            "add-int",
            "sub-int",
            "mul-int",
            "div-int",
            "rem-int",
            "and-int",
            "or-int",
            "xor-int",
            "shl-int",
            "shr-int",
            "ushr-int",
            "add-long",
            "sub-long",
            "mul-long",
            "div-long",
            "rem-long",
            "and-long",
            "or-long",
            "xor-long",
            "shl-long",
            "shr-long",
            "ushr-long",
            "add-float",
            "sub-float",
            "mul-float",
            "div-float",
            "rem-float",
            "add-double",
            "sub-double",
            "mul-double",
            "div-double",
            "rem-double",
            "add-int/2addr",
            "sub-int/2addr",
            "mul-int/2addr",
            "div-int/2addr",
            "rem-int/2addr",
            "and-int/2addr",
            "or-int/2addr",
            "xor-int/2addr",
            "shl-int/2addr",
            "shr-int/2addr",
            "ushr-int/2addr",
            "add-long/2addr",
            "sub-long/2addr",
            "mul-long/2addr",
            "div-long/2addr",
            "rem-long/2addr",
            "and-long/2addr",
            "or-long/2addr",
            "xor-long/2addr",
            "shl-long/2addr",
            "shr-long/2addr",
            "ushr-long/2addr",
            "add-float/2addr",
            "sub-float/2addr",
            "mul-float/2addr",
            "div-float/2addr",
            "rem-float/2addr",
            "add-double/2addr",
            "sub-double/2addr",
            "mul-double/2addr",
            "div-double/2addr",
            "rem-double/2addr",
            "add-int/lit16",
            "rsub-int",
            "mul-int/lit16",
            "div-int/lit16",
            "rem-int/lit16",
            "and-int/lit16",
            "or-int/lit16",
            "xor-int/lit16",
            "add-int/lit8",
            "rsub-int/lit8",
            "mul-int/lit8",
            "div-int/lit8",
            "rem-int/lit8",
            "and-int/lit8",
            "or-int/lit8",
            "xor-int/lit8",
            "shl-int/lit8",
            "shr-int/lit8",
            "ushr-int/lit8",
            "iget-volatile",
            "iput-volatile",
            "sget-volatile",
            "sput-volatile",
            "iget-object-volatile",
            "iget-wide-volatile",
            "iput-wide-volatile",
            "sget-wide-volatile",
            "sput-wide-volatile",
            "execute-inline",
            "execute-inline/range",
            "invoke-direct-empty",
            "iget-quick",
            "iget-wide-quick",
            "iget-object-quick",
            "iput-quick",
            "iput-wide-quick",
            "iput-object-quick",
            "invoke-virtual-quick",
            "invoke-virtual-quick/range",
            "invoke-super-quick",
            "invoke-super-quick/range",
            "iput-object-volatile",
            "sget-object-volatile",
            "sput-object-volatile",
            "packed-switch-payload",
            "sparse-switch-payload",
            "array-payload",
            "invoke-polymorphic",
            "invoke-polymorphic/range",
            "invoke-custom",
            "invoke-custom/range",
            "const-method-handle",
            "const-method-type"
    };
    private static final String[] DIRECTIVES = {
            ".class",
            ".super",
            ".implements",
            ".source",
            ".field",
            ".subannotation",
            ".annotation",
            ".enum",
            ".method",
            ".registers",
            ".locals",
            ".array-data",
            ".packed-switch",
            ".sparse-switch",
            ".catch",
            ".catchall",
            ".line",
            ".param",
            ".local",
            ".prologue",
            ".epilogue",
            ".end" // not a real directive but works for auto-complete
    };
    private static final String[] ACCESS_SPECS = {
            "public",
            "private",
            "protected",
            "static",
            "final",
            "synchronized",
            "bridge",
            "varargs",
            "native",
            "abstract",
            "strictfp",
            "synthetic",
            "constructor",
            "declared-synchronized",
            "interface",
            "enum",
            "annotation",
            "volatile",
            "transient"
    };

    @Override
    public List<CompletionItem> getAutoCompleteItems(
            String prefix, TextAnalyzeResult colors, int line, int column) {
        List<CompletionItem> list = new ArrayList<>();

        list.addAll(basicItems(prefix, DIRECTIVES, "Directive"));
        list.addAll(basicItems(prefix, INSTRUCTIONS, "Instruction"));
        list.addAll(basicItems(prefix, ACCESS_SPECS, "Access spec"));

        SmaliAutoCompleteModel acModel = (SmaliAutoCompleteModel) colors.getExtra();

        for (SmaliClassDesc classDesc : acModel.classDescs) {
            if (classDesc.name.contains(prefix)) {
                list.add(classDescItem(classDesc));
            }
        }

        // TODO: add completions for labels/gotos

        return list;
    }

    private List<CompletionItem> basicItems(String prefix, String[] source, String desc) {
        return Arrays.stream(source)
                .filter(it -> it.startsWith(prefix))
                .map(it -> basicItem(it, desc))
                .collect(Collectors.toList());
    }

    private CompletionItem basicItem(String label, String desc) {
        return new CompletionItem(label, label + " ", desc);
    }

    private CompletionItem classDescItem(SmaliClassDesc classDesc) {
        return new CompletionItem(classDesc.name, classDesc.name, "Class descriptor");
    }

    class SmaliAutoCompleteModel {
        private Set<SmaliClassDesc> classDescs;

        public SmaliAutoCompleteModel(Set<SmaliClassDesc> classDescs) {
            this.classDescs = classDescs;
        }

        public Set<SmaliClassDesc> getClassDescs() {
            return classDescs;
        }

        public void setClassDescs(Set<SmaliClassDesc> classDescs) {
            this.classDescs = classDescs;
        }
    }

    class SmaliClassDesc {
        private String name;

        public SmaliClassDesc(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
