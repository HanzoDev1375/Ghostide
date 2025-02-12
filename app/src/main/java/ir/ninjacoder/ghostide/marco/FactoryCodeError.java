package ir.ninjacoder.ghostide.marco;

import com.blankj.utilcode.util.ThreadUtils;
import io.github.rosemoe.sora.widget.tooltip.ToolItemPop;
import io.github.rosemoe.sora.widget.tooltip.ToolTipHelper;
import ir.ninjacoder.ghostide.GhostIdeAppLoader;
import ir.ninjacoder.ghostide.IdeEditor;
import ir.ninjacoder.ghostide.R;
import ir.ninjacoder.ghostide.utils.ObjectUtils;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import androidx.annotation.MainThread;
import com.ninjacoder.jgit.AsyncTaskCompat;
import io.github.rosemoe.sora.langs.csharp.CSharpLanguage;
import io.github.rosemoe.sora.langs.css3.CSS3Language;
import io.github.rosemoe.sora.langs.antlrlang.ANTLRV4Lang;
import io.github.rosemoe.sora.langs.cpp.CppLanguage;
import io.github.rosemoe.sora.langs.dart.DartLang;
import io.github.rosemoe.sora.langs.ghostthemelang.ghostlang.ghostlangs;
import io.github.rosemoe.sora.langs.html.HTMLLanguage;
import io.github.rosemoe.sora.langs.groovy.lang.GroovyLanguage;
import io.github.rosemoe.sora.langs.json.JsonLanguage;
import io.github.rosemoe.sora.langs.kotlin.KotlinLanguage;
import io.github.rosemoe.sora.langs.ninjalang.NinjaLang;
import io.github.rosemoe.sora.langs.sass.SassLangCompat;
import io.github.rosemoe.sora.langs.smali.SMLang;
import io.github.rosemoe.sora.langs.typescript.TsLang;
import io.github.rosemoe.sora.langs.xml.XMLLanguage;
import io.github.rosemoe.sora.interfaces.EditorLanguage;
import io.github.rosemoe.sora.langs.sql.MySqlLang;
import io.github.rosemoe.sora.langs.java.JavaLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLanguage;
import io.github.rosemoe.sora.langs.javascript.JavaScriptLexer;
import io.github.rosemoe.sora.langs.javascript.JavaScriptParser;
import io.github.rosemoe.sora.langs.javascript.JavaScriptParserBaseListener;
import io.github.rosemoe.sora.langs.php.PHPLanguage;
import io.github.rosemoe.sora.langs.php.PhpLexer;
import io.github.rosemoe.sora.langs.php.PhpParser;
import io.github.rosemoe.sora.langs.php.PhpParserBaseListener;
import io.github.rosemoe.sora.langs.python.PythonLang;
import io.github.rosemoe.sora.langs.python.PythonLexer;
import io.github.rosemoe.sora.langs.python.PythonParser;
import io.github.rosemoe.sora.langs.python.PythonParserBaseListener;
import java.io.StringReader;
import java.util.List;
import org.antlr.parser.antlr4.csharp.CSharpLexer;
import org.antlr.parser.antlr4.csharp.CSharpParser;
import org.antlr.parser.antlr4.csharp.CSharpParserBaseListener;
import org.antlr.parser.antlr4.java20.Java20Lexer;
import org.antlr.parser.antlr4.java20.Java20Parser;
import org.antlr.parser.antlr4.java20.Java20ParserBaseListener;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

/**
 * سازنده: نینجا کدر این کلاس برای تحلیل کد استفاده میشود در واقع یک عمل کرد دقیق تر از خط زیرین
 * فرفری است اگر کد سالم باشد تیک تایید با رنگ سبز اگر خراب علامت بسته شدن با رنگ قرمز نکته: نیازی
 * به کال کردن #Mode نیست چون یک سری وکتور معمولی هستند با رنگ سفید اگر رنگ های دیگری بود وکتور شما
 * میتوانید #Mode را کال کنید و طبقه نیاز خودتان رنگ رو کال کنید
 */
public class FactoryCodeError {

  private IdeEditor editor;
  private ImageView call;
  private boolean errorCall;

  /**
   * ایجاد کردن نمونه از کد ادیتور با این کار نیازی نیست در فعالیت اصلی دوبار کال کنید حافظه خوری
   * شدید است من سیع میکنم در گوست ide ویژگی های مفید پیاده سازی کنم
   */
  public FactoryCodeError(IdeEditor editor, ImageView call) {
    this.editor = editor;
    this.call = call;
  }

  void Iconnotfound() {
    call.setImageResource(R.drawable.ic_material_doc);
  }

  /**
   * این متتود باید کال شود مگر نه عمل کرد کار نمیکند این متتود به صورت خودکار زبان ها را حمایت
   * میکند و خودکار تشخیص میدهد بسته به نوع زبان متتود های مختلف رو کال کنید اگر نوع متتود با زبان
   * هماهنگ نباشد تحلیل کردن کد به درستی پیش نمیرود
   */
  public void run() {
    if (GhostIdeAppLoader.getAnalyzercod().getBoolean("Analyzercod", false) == true) {

      if (editor.getEditorLanguage() instanceof CSS3Language) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof ANTLRV4Lang) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof CppLanguage) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof DartLang) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof ghostlangs) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof HTMLLanguage) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof GroovyLanguage) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof JavaLanguage) {
        java();
      } else if (editor.getEditorLanguage() instanceof JavaScriptLanguage) {
        js();
      } else if (editor.getEditorLanguage() instanceof JsonLanguage) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof KotlinLanguage) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof NinjaLang) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof PHPLanguage) {
        php();
      } else if (editor.getEditorLanguage() instanceof PythonLang) {
        py();
      } else if (editor.getEditorLanguage() instanceof SassLangCompat) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof SMLang) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof TsLang) {
        if (editor != null) new TypeScriptTask().execute(editor.getText().toString());
      } else if (editor.getEditorLanguage() instanceof XMLLanguage) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof CSharpLanguage) {
        cs();
      } else if (editor.getEditorLanguage() instanceof MySqlLang) {
        Iconnotfound();
      } else if (editor.getEditorLanguage() instanceof EditorLanguage) {
        Iconnotfound();
      }
    }
  }

  /**
   * نکته: نیاز است برای هر زبانی این فرایند جدا ساخته بشود زیرا نمونه ایجاد کردن #ANTLRInputStream
   * سنگین است و فقط یک بار نمونه برای هر زبان کافی است ممکن است کد طولانی و سخت شود اما مشکلی نیست
   * اما حافظه خور نیست شاید 10 مگابایت میتوانید فرایند #errorCall را چندین بار کال کنید اگر از
   * #Thread و #post کردن چیزی نمیدانید ان را دست کاری نکنید ممکن است MainThread به درستی کال نشود و
   * برنامه دچار خطا و فورس کلوز شود
   */
  void js() {
    if (editor != null) {
      new Thread(
              () -> {
                try {
                  var input = new ANTLRInputStream(new StringReader(editor.getText().toString()));
                  var lexer = new JavaScriptLexer(input);
                  var stream = new CommonTokenStream(lexer);
                  var paser = new JavaScriptParser(stream);
                  var callBackLabe =
                      new JavaScriptParserBaseListener() {
                        @Override
                        public void visitErrorNode(ErrorNode node) {
                          errorCall = true;
                        }
                      };

                  var walk = new ParseTreeWalker();
                  walk.walk(callBackLabe, paser.program());
                  new Handler(Looper.getMainLooper())
                      .post(
                          () -> {
                            if (errorCall) {
                              call.setImageResource(R.drawable.closehsi);
                              call.setColorFilter(Color.RED);
                            } else {
                              call.setImageResource(R.drawable.ic_palette_check_box);
                              call.setColorFilter(Color.GREEN);
                            }
                          });
                } catch (Exception err) {

                }
              })
          .start();
    }
  }

  void java() {
    if (editor != null) {
      new JavaTask().execute(editor.getText().toString());
    }
  }

  /**
   * این متتود برای تحلیل و انالیز php به کاربرده میشه که سریع تر از مجموعه فرفری عمل میکنه
   *
   * <p>این کد عمل کرد نسبت بهتری داره به مجموعه فرفری
   */
  void php() {
    if (editor != null) {
      new Thread(
              () -> {
                try {
                  var input = new ANTLRInputStream(new StringReader(editor.getText().toString()));
                  var lexer = new PhpLexer(input);
                  var stream = new CommonTokenStream(lexer);
                  var paser = new PhpParser(stream);
                  var callBackLabe =
                      new PhpParserBaseListener() {
                        @Override
                        public void visitErrorNode(ErrorNode node) {
                          errorCall = true;
                        }
                      };

                  var walk = new ParseTreeWalker();
                  walk.walk(callBackLabe, paser.htmlDocument());
                  new Handler(Looper.getMainLooper())
                      .post(
                          () -> {
                            if (errorCall) {
                              call.setImageResource(R.drawable.closehsi);
                              call.setColorFilter(Color.RED);
                            } else {
                              call.setImageResource(R.drawable.ic_palette_check_box);
                              call.setColorFilter(Color.GREEN);
                            }
                          });
                } catch (Exception err) {

                }
              })
          .start();
    }
  }

  /**
   * این متتود برای تحلیل و انالیز پایتون به کاربرده میشه که سریع تر از مجموعه فرفری عمل میکنه
   *
   * <p>این کد عمل کرد نسبت بهتری داره به مجموعه فرفری
   *
   * <p>تحلیل دیتا را با این کد سریع تر کنید
   */
  void py() {
    if (editor != null) {
      new Thread(
              () -> {
                try {
                  var input = new ANTLRInputStream(new StringReader(editor.getText().toString()));
                  var lexer = new PythonLexer(input);
                  var stream = new CommonTokenStream(lexer);
                  var paser = new PythonParser(stream);
                  var callBackLabe =
                      new PythonParserBaseListener() {
                        @Override
                        public void visitErrorNode(ErrorNode node) {
                          errorCall = true;
                        }
                      };

                  var walk = new ParseTreeWalker();
                  walk.walk(callBackLabe, paser.file_input());
                  new Handler(Looper.getMainLooper())
                      .post(
                          () -> {
                            if (errorCall) {
                              call.setImageResource(R.drawable.closehsi);
                              call.setColorFilter(Color.RED);
                            } else {
                              call.setImageResource(R.drawable.ic_palette_check_box);
                              call.setColorFilter(Color.GREEN);
                            }
                          });
                } catch (Exception err) {

                }
              })
          .start();
    }
  }

  void cs() {
    if (editor != null) {
      new Thread(
              () -> {
                try {
                  var input = new ANTLRInputStream(new StringReader(editor.getText().toString()));
                  var lexer = new CSharpLexer(input);
                  var stream = new CommonTokenStream(lexer);
                  var paser = new CSharpParser(stream);
                  var callBackLabe =
                      new CSharpParserBaseListener() {
                        @Override
                        public void visitErrorNode(ErrorNode node) {
                          errorCall = true;
                        }
                      };

                  var walk = new ParseTreeWalker();
                  walk.walk(callBackLabe, paser.compilation_unit());
                  new Handler(Looper.getMainLooper())
                      .post(
                          () -> {
                            if (errorCall) {
                              call.setImageResource(R.drawable.closehsi);
                              call.setColorFilter(Color.RED);
                            } else {
                              call.setImageResource(R.drawable.ic_palette_check_box);
                              call.setColorFilter(Color.GREEN);
                            }
                          });
                } catch (Exception err) {

                }
              })
          .start();
    }
  }

  private class JavaTask extends AsyncTaskCompat<String, Void, Boolean> {

    private boolean errorCall = false;

    private ErrorNode errorNode;
    private ToolItemPop tooltipHelper;

    public JavaTask() {
      tooltipHelper = new ToolItemPop(editor);
    }

    @MainThread
    @Override
    protected void onPreExecute() {
      call.setImageDrawable(ObjectUtils.getCircularProgress());
    }

    @Override
    protected Boolean doInBackground(String... params) {

      try {
        var input = new ANTLRInputStream(new StringReader(params[0]));
        var lexer = new Java20Lexer(input);
        var stream = new CommonTokenStream(lexer);
        var parser = new Java20Parser(stream);

        var callbackLabel =
            new Java20ParserBaseListener() {
              @Override
              public void visitErrorNode(ErrorNode node) {
                errorCall = true;
                errorNode = node;
              }
            };

        var walk = new ParseTreeWalker();
        walk.walk(callbackLabel, parser.start_());
      } catch (Exception err) {
        // Handle exception if necessary
      }
      return errorCall;
    }

    @Override
    protected void onPostExecute(Boolean errorCall) {
      if (errorCall) {
        call.setImageResource(R.drawable.closehsi);
        call.setColorFilter(Color.RED);
        if (tooltipHelper != null) {
          var builder = new StringBuilder();
          builder.append("Error: ").append(errorNode.getSymbol().getText()).append('\n');
          builder
              .append("Line: ")
              .append(String.valueOf(errorNode.getSymbol().getLine()))
              .append('\n');

          tooltipHelper.run(builder.toString());
        }

      } else {
        call.setImageResource(R.drawable.ic_palette_check_box);
        call.setColorFilter(Color.GREEN);
      }
    }
  }

  private class TypeScriptTask extends AsyncTaskCompat<String, Void, Boolean> {

    private boolean errorCall = false;
    private ErrorNode errorNode; // تغییر نام به یک متغیر سراسری
    List<Integer> mlist = editor.getLineSize();
    private ToolTipHelper tooltipHelper;

    public TypeScriptTask() {
      tooltipHelper = new ToolTipHelper(editor);
    }

    @MainThread
    @Override
    protected void onPreExecute() {
      call.setImageDrawable(ObjectUtils.getCircularProgress());
    }

    @Override
    protected Boolean doInBackground(String... params) {
      try {
        var input = new ANTLRInputStream(new StringReader(params[0]));
        var lexer = new Java20Lexer(input);
        var stream = new CommonTokenStream(lexer);
        var parser = new Java20Parser(stream);

        var callbackLabel =
            new Java20ParserBaseListener() {
              @Override
              public void visitErrorNode(ErrorNode node) {
                errorCall = true;
                errorNode = node; // ذخیره خطا در متغیر سراسری
              }
            };

        var walk = new ParseTreeWalker();
        walk.walk(callbackLabel, parser.start_());
      } catch (Exception err) {
        // Handle exception if necessary
      }
      return errorCall;
    }

    @Override
    protected void onPostExecute(Boolean errorCall) {
      if (errorCall) {
        call.setImageResource(R.drawable.closehsi);
        call.setColorFilter(Color.RED);
        int line = errorNode.getSymbol().getLine(); // استفاده از متغیر سراسری
        mlist.add(line);
        if (tooltipHelper != null) {
          var builder = new StringBuilder();
          builder.append("Error: ").append(errorNode.getSymbol().getText()).append('\n');
          builder
              .append("Line: ")
              .append(String.valueOf(errorNode.getSymbol().getLine()))
              .append('\n');

          tooltipHelper.setText(builder.toString());
        }
      } else {
        mlist.clear();
        call.setImageResource(R.drawable.ic_palette_check_box);
        call.setColorFilter(Color.GREEN);
      }
    }
  }
}
