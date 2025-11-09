package com.xiaoyv.ccompile.compiler;

import android.content.Context;

import androidx.annotation.NonNull;

import com.xiaoyv.ccompile.CCppEngine;
import com.xiaoyv.ccompile.compiler.listener.CompileCallback;
import com.xiaoyv.ccompile.utils.ThreadUtils;
import com.xiaoyv.ccompile.utils.Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * g++编译代码（编译CPP）
 *
 * @author 王怀玉
 * @since 2020/5/14
 */
public class CppCompiler {

    /**
     * g++编译代码
     */
    public void compile(@NonNull final List<File> src, @NonNull final CompileCallback compileCallback) {
        final Context context = Utils.getApp().getApplicationContext();
        ThreadUtils.executeByCached(new ThreadUtils.SimpleTask<String>() {
            @Override
            public String doInBackground() throws Throwable {

                if (!CCppEngine.checkGcc(context)) {
                    throw new Throwable("GCC 环境不存在");
                }

                final String SYS_PATH = System.getenv("PATH");
                final String GCC_BIN_PATH = CCppEngine.getCompilerDirPath(context) + File.separator + "gcc" + File.separator + "bin";
                final String ARM_GCC_PATH = CCppEngine.getCompilerDirPath(context) + File.separator + "gcc" + File.separator + "arm-linux-androideabi" + File.separator + "bin";
                final String OUT_FILE_PATH = CCppEngine.getCompilerDirPath(context) + File.separator + "temp";

                List<String> args = new ArrayList<>();
                for (File file : src) {
                    args.add(file.getAbsolutePath());
                }
                args.add("-Wfatal-errors");//一遇到错误就停止
                args.add("-pie");
                args.add("-std=c++14");
                args.add("-lz");
                args.add("-ldl");
                args.add("-lm");
                args.add("-llog");
                args.add("-lncurses");
                args.add("-Og");
                args.add("-o");
                args.add(OUT_FILE_PATH);

                String TEMPEnv = CCppEngine.getCompilerDirPath(context) + "/gcc/tmpdir";
                String PATHEnv = CCppEngine.getCompilerDirPath(context) + File.pathSeparator + GCC_BIN_PATH + File.pathSeparator + ARM_GCC_PATH + File.pathSeparator + SYS_PATH;
                Map<String, String> envMap = new HashMap<>();
                envMap.put("PATH", PATHEnv);
                envMap.put("TEMP", TEMPEnv);

                // 编译命令
                String cmd = "." + GCC_BIN_PATH + File.separator + "arm-linux-androideabi-g++";

                // 运行结果
                CompileHelper.CommandResult result = CompileHelper.execCommand(cmd, args, envMap);

                // 编译错误
                if (!result.isOk()) {
                    throw new Throwable(result.getMsg());
                }

                // 返回输出文件
                return OUT_FILE_PATH;
            }

            @Override
            public void onFail(Throwable t) {
                compileCallback.onError(t.getMessage());
            }

            @Override
            public void onSuccess(String result) {
                compileCallback.onSuccess(result);
            }
        });
    }
}
