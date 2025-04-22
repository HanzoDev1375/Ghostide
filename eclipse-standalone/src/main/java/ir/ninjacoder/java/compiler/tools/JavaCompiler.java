package ir.ninjacoder.java.compiler.tools;

import org.eclipse.jdt.internal.compiler.batch.Main;
import java.io.PrintWriter;

/**
 * creat by ninja coder
 */
public class JavaCompiler {
  private Main main;
  private PrintWriter print;
  private String[] total;

  public JavaCompiler(PrintWriter print, String[] total) {
    this.print = print;
    this.total = total;
    main = new Main(print,print,false,null,null);
    main.compile(total);
  }
  
  public int getTotalError(){
      return main.globalErrorsCount;
  }
  public int getTotalInfo(){
      return main.globalInfoCount;
  }
  public int getTotoalProblems(){
      return main.globalProblemsCount;
  }
}
