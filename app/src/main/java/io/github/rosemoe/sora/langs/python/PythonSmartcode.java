package io.github.rosemoe.sora.langs.python;

import io.github.rosemoe.sora.data.CompletionItem;

import java.util.List;

public class PythonSmartcode {

    public String codeRead;
    public int NumberKey;
    public int line;
    public int column;
    public List<CompletionItem> list;

    public String getCodeRead() {
        return this.codeRead;
    }

    public void setCodeRead(String codeRead) {
        this.codeRead = codeRead;
    }

    public int getNumberKey() {
        return this.NumberKey;
    }

    public void setNumberKey(int NumberKey) {
        this.NumberKey = NumberKey;
    }

    public int getLine() {
        return this.line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getColumn() {
        return this.column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public List<CompletionItem> getList() {
        return this.list;
    }

    public void setList(List<CompletionItem> list) {
        this.list = list;
    }
}
