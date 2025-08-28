package ninjacoder.ghostide.androidtools.r8.android;

public class CodeLine {
    public final String code;
    public final String error;
    public final int line;
    public final int column;

    public CodeLine(String code, String error, int line, int column) {
      this.code = code;
      this.error = error;
      this.line = line;
      this.column = column;
    }

    @Override
    public String toString() {
      return "Line " + line + ", Column " + column + ": " + error + "\n" + code;
    }
}
