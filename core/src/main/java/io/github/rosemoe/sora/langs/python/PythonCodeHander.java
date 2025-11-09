package io.github.rosemoe.sora.langs.python;

import io.github.rosemoe.sora.text.TextAnalyzeResult;

public class PythonCodeHander {
    int lineNumber;
    TextAnalyzeResult result;

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public TextAnalyzeResult getResult() {
        return this.result;
    }

    public void setResult(TextAnalyzeResult result) {
        this.result = result;
    }
}
