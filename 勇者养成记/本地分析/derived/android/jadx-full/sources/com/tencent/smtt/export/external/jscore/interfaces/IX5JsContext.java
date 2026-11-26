package com.tencent.smtt.export.external.jscore.interfaces;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface IX5JsContext {
    void addJavascriptInterface(java.lang.Object obj, java.lang.String str);

    void destroy();

    void evaluateJavascript(java.lang.String str, android.webkit.ValueCallback valueCallback, java.net.URL url);

    com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue evaluateScript(java.lang.String str, java.net.URL url);

    void evaluateScriptAsync(java.lang.String str, android.webkit.ValueCallback valueCallback, java.net.URL url);

    byte[] getNativeBuffer(int i);

    int getNativeBufferId();

    void removeJavascriptInterface(java.lang.String str);

    void setExceptionHandler(android.webkit.ValueCallback valueCallback);

    void setName(java.lang.String str);

    int setNativeBuffer(int i, byte[] bArr);

    void setPerContextData(java.lang.Object obj);

    void stealValueFromOtherCtx(java.lang.String str, com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext iX5JsContext, java.lang.String str2);
}
