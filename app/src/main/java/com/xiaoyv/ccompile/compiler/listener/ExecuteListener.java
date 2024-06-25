package com.xiaoyv.ccompile.compiler.listener;


/**
 * Dex 文件执行结果监听
 */
public interface ExecuteListener {

    /**
     * 程序创建成功
     */
    void onExecuteStart(Process process);

    /**
     * 错误输出
     */
    void printStderr(final Throwable error);

    /**
     * 正常输出
     */
    void printStdout(final CharSequence out);

    /**
     * 执行完成
     *
     * @param waitFor
     * @param i
     */
    void onExecuteFinish(int waitFor, int exitValue);

}
