package com.xiaoyv.ccompile.compiler.listener;


/**
 * C 文件编译监听器
 */
public abstract class CompilerListener {

    /**
     * 编译为类文件成功
     *
     * @param path 编译的类文件路径
     */
    public abstract void onSuccess(String path);

    /**
     * 编译失败
     *
     * @param error 错误原因
     */
    public abstract void onError(Throwable error);

    /**
     * 编译进度
     *
     * @param task     任务名
     * @param progress 进度
     */
    public void onProgress(String task, int progress) {

    }
}