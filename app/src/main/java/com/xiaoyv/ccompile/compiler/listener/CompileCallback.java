package com.xiaoyv.ccompile.compiler.listener;

/**
 * Created by zyw on 2017/11/14.
 */
public interface CompileCallback {

    void onSuccess(String outPath);

    void onError(String error);
}
