package com.tencent.smtt.export.external.jscore.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5JsVirtualMachine {
    com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext createJsContext();

    void destroy();

    android.os.Looper getLooper();

    void onPause();

    void onResume();
}
