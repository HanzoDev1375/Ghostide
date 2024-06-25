package com.xiaoyv.ccompile.compiler;

import com.xiaoyv.ccompile.compiler.listener.CompilerListener;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CompileHelper {

    private CompileHelper() {
        throw new AssertionError();
    }


    /**
     * 携带环境变量执行shell命令
     *
     * @param command shell命令
     * @param args    参数
     * @param env     环境变量
     * @return 执行结果
     */
    static CommandResult execCommand(String command, List<String> args, Map<String, String> env) {
        int result = -1;
        if (command == null || command.length() == 0) {
            return new CommandResult(result, "Shell 命令不存在");
        }

        Process process = null;
        BufferedReader inputBufferedReader = null;
        StringBuilder msg = null;
        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            List<String> argsList = processBuilder.command();
            argsList.addAll(args);
            processBuilder.redirectErrorStream(true);//合并输入流和错误流
            Map<String, String> map = processBuilder.environment();
            map.clear();
            for (Map.Entry<String, String> entry : env.entrySet()) {
                map.put(entry.getKey(), entry.getValue());
            }
            process = processBuilder.start();
            result = process.waitFor();
            msg = new StringBuilder();

            inputBufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String s;
            while ((s = inputBufferedReader.readLine()) != null) {
                msg.append(s);
                msg.append("\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (msg != null)
                msg.append(e.toString());
        } finally {
            try {
                if (inputBufferedReader != null) {
                    inputBufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (process != null) {
                process.destroy();
            }
        }
        return new CommandResult(result, msg == null ? "" : msg.toString());
    }


    /**
     * 命令结果类
     */
    public static class CommandResult {
        private int result;
        private String msg;

        CommandResult(int result) {
            this.result = result;
        }

        CommandResult(int result, String msg) {
            this.result = result;
            this.msg = msg;
        }

        public String getMsg() {
            return msg;
        }

        public boolean isOk() {
            return result == 0;
        }
    }


/*    public static void compile(final File cFile, CompilerListener compilerListener) {
        // 找出错误行号
        Matcher matcher = Pattern.compile(":(\\d+):").matcher("");
        String pos = "";
        if (matcher.find()) {
            pos = matcher.group(1);
        }
    }*/

}