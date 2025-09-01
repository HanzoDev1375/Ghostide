package ninjacoder.ghostide.androidtools.r8.android;

public class CodeLine {
  public final String code;
  public final String error;
  public final int line;
  public final int column;
  public final boolean haserror;
  public final boolean haswar;

  public CodeLine(
      String code, String error, int line, int column, boolean haserror, boolean haswar) {
    this.code = code;
    this.error = error;
    this.line = line;
    this.column = column;
    this.haserror = haserror;
    this.haswar = haswar;
  }

  @Override
  public String toString() {
    return "Line " + line + ", Column " + column + ": " + error + "\n" + code;
  }
}
