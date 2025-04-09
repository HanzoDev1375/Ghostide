package ir.ninjacoder.ghostide.tasks;

import androidx.annotation.NonNull;
import jadx.api.CommentsLevel;
import java.io.Reader;
import org.jf.dexlib2.iface.ClassDef;
import java.io.IOException;
import org.antlr.runtime.RecognitionException;
import java.io.File;
import java.util.List;
import org.jf.dexlib2.Opcodes;
import org.jf.smali.smaliFlexLexer;
import org.antlr.runtime.CommonTokenStream;
import org.jf.smali.smaliParser;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeNodeStream;
import org.jf.dexlib2.writer.builder.DexBuilder;
import org.jf.smali.smaliTreeWalker;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.io.StringReader;
import jadx.core.utils.files.FileUtils;
import org.jf.dexlib2.writer.pool.DexPool;
import org.jf.dexlib2.writer.io.FileDataStore;
import java.util.ArrayList;
import jadx.api.JadxArgs;
import jadx.api.JadxDecompiler;
import jadx.api.JavaClass;
import android.os.AsyncTask;

/**
 * tnks for appManager for code 
 * fix bug by ninja coder
 */

public class SmalitoJava {
  public interface DecompileCallback {
    void onResult(String javaCode);

    void onError(Exception e);
  }

  public static void toAsync(String code, DecompileCallback callback) throws Exception {
    new AsyncTask<String, Void, String>() {

      @Override
      protected String doInBackground(String... params) {

        try {
          return toJavaCodeMain(params[0], 0);
        } catch (Exception err) {
          return null;
        }
      }

      @Override
      protected void onPostExecute(String result) {
        if (result != null) {
          callback.onResult(result);
        } else {
          callback.onError(new Exception("Decompilation failed"));
        }
      }

      @Override
      protected void onPreExecute() {
        if (callback != null) {
          callback.onResult("Loading....");
        }
        super.onPreExecute();
      }
    }.execute(code);
  }

  @NonNull
  public static String toJavaCodeMain(@NonNull String smaliContent, int api) throws IOException {
    Opcodes opcodes = api < 0 ? Opcodes.getDefault() : Opcodes.forApi(api);
    try {
      return toJavaCode(toClassDef(smaliContent, api), opcodes);
    } catch (RecognitionException e) {
      throw new IOException(e);
    }
  }

  private static ClassDef toClassDef(@NonNull Reader smaliReader, int apiLevel)
      throws IOException, RecognitionException {
    Opcodes opcodes = apiLevel < 0 ? Opcodes.getDefault() : Opcodes.forApi(apiLevel);
    smaliFlexLexer lexer = new smaliFlexLexer(smaliReader, opcodes.api);
    CommonTokenStream tokens = new CommonTokenStream(lexer);
    smaliParser parser = new smaliParser(tokens);
    parser.setVerboseErrors(false);
    parser.setAllowOdex(false);
    parser.setApiLevel(opcodes.api);
    smaliParser.smali_file_return result = parser.smali_file();
    if (parser.getNumberOfSyntaxErrors() > 0 || lexer.getNumberOfSyntaxErrors() > 0) {
      throw new IOException(
          (parser.getNumberOfSyntaxErrors() + lexer.getNumberOfSyntaxErrors())
              + " syntax errors during parsing and/or lexing.");
    }

    CommonTree t = result.getTree();
    CommonTreeNodeStream treeStream = new CommonTreeNodeStream(t);
    treeStream.setTokenStream(tokens);

    DexBuilder dexBuilder = new DexBuilder(opcodes);
    smaliTreeWalker dexGen = new smaliTreeWalker(treeStream);
    dexGen.setApiLevel(opcodes.api);
    dexGen.setVerboseErrors(false);
    dexGen.setDexBuilder(dexBuilder);
    ClassDef classDef = dexGen.smali_file();

    if (dexGen.getNumberOfSyntaxErrors() > 0) {
      throw new IOException(
          dexGen.getNumberOfSyntaxErrors() + " syntax errors during dex creation");
    }

    if (classDef == null) {
      throw new IOException("Could not generate class from smali.");
    }
    return classDef;
  }

  private static ClassDef toClassDef(@NonNull File smaliFile, int apiLevel)
      throws IOException, RecognitionException {
    try (InputStreamReader sr =
        new InputStreamReader(new FileInputStream(smaliFile), StandardCharsets.UTF_8)) {
      return toClassDef(sr, apiLevel);
    }
  }

  @NonNull
  private static ClassDef toClassDef(@NonNull String smaliContents, int apiLevel)
      throws IOException, RecognitionException {
    try (StringReader sr = new StringReader(smaliContents)) {
      return toClassDef(sr, apiLevel);
    }
  }

  private static String toJavaCode(@NonNull List<ClassDef> classDefs, @NonNull Opcodes opcodes)
      throws IOException {
    var tmp = FileUtils.createTempFile(".dex");
    try {
      DexPool pool = new DexPool(opcodes);
      for (ClassDef classDef : classDefs) {
        pool.internClass(classDef);
      }
      pool.writeTo(new FileDataStore(tmp.toFile()));
      return toJavaCode(tmp.toFile());
    } finally {
      tmp.toFile().delete();
    }
  }

  @NonNull
  private static String toJavaCode(@NonNull ClassDef classDef, @NonNull Opcodes opcodes)
      throws IOException {
    var tmp = FileUtils.createTempFile(".dex");
    try {
      DexPool pool = new DexPool(opcodes);
      pool.internClass(classDef);
      pool.writeTo(new FileDataStore(tmp.toFile()));
      return toJavaCode(tmp.toFile());
    } finally {
      tmp.toFile().delete();
    }
  }

  @NonNull
  private static String toJavaCode(@NonNull List<String> smaliContents, int api)
      throws IOException {
    Opcodes opcodes = api < 0 ? Opcodes.getDefault() : Opcodes.forApi(api);
    try {
      List<ClassDef> classDefs = new ArrayList<>(smaliContents.size());
      for (String smaliContent : smaliContents) {
        classDefs.add(toClassDef(smaliContent, api));
      }
      return toJavaCode(classDefs, opcodes);
    } catch (RecognitionException e) {
      throw new IOException(e);
    }
  }

  @NonNull
  private static String toJavaCode(@NonNull File dexFile) {
    JadxArgs args = new JadxArgs();
    args.setInputFile(dexFile);
    args.setSkipResources(true);
    args.setShowInconsistentCode(true);
    args.setDebugInfo(false);
    args.setCommentsLevel(CommentsLevel.NONE);
    args.setRenameValid(true);
    try (JadxDecompiler decompiler = new JadxDecompiler(args)) {
      decompiler.load();
      JavaClass javaClass = decompiler.getClasses().iterator().next();
      javaClass.decompile();
      return javaClass.getCode();
    }
  }
}
