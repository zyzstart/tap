package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class JsContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.smtt.sdk.JsVirtualMachine f808a;
    private final com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext b;
    private com.tencent.smtt.sdk.JsContext.ExceptionHandler c;
    private java.lang.String d;

    public interface ExceptionHandler {
        void handleException(com.tencent.smtt.sdk.JsContext jsContext, com.tencent.smtt.sdk.JsError jsError);
    }

    public JsContext(android.content.Context context) {
        this(new com.tencent.smtt.sdk.JsVirtualMachine(context));
    }

    public JsContext(com.tencent.smtt.sdk.JsVirtualMachine jsVirtualMachine) {
        if (jsVirtualMachine == null) {
            throw new java.lang.IllegalArgumentException("The virtualMachine value can not be null");
        }
        this.f808a = jsVirtualMachine;
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext iX5JsContextA = jsVirtualMachine.a();
        this.b = iX5JsContextA;
        try {
            iX5JsContextA.setPerContextData(this);
        } catch (java.lang.AbstractMethodError unused) {
        }
    }

    public static com.tencent.smtt.sdk.JsContext current() {
        return (com.tencent.smtt.sdk.JsContext) com.tencent.smtt.sdk.X5JsCore.a();
    }

    public void addJavascriptInterface(java.lang.Object obj, java.lang.String str) {
        this.b.addJavascriptInterface(obj, str);
    }

    public void destroy() {
        this.b.destroy();
    }

    public void evaluateJavascript(java.lang.String str, android.webkit.ValueCallback valueCallback) {
        evaluateJavascript(str, valueCallback, null);
    }

    public void evaluateJavascript(java.lang.String str, android.webkit.ValueCallback valueCallback, java.net.URL url) {
        this.b.evaluateJavascript(str, valueCallback, url);
    }

    public com.tencent.smtt.sdk.JsValue evaluateScript(java.lang.String str) {
        return evaluateScript(str, null);
    }

    public com.tencent.smtt.sdk.JsValue evaluateScript(java.lang.String str, java.net.URL url) {
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue iX5JsValueEvaluateScript = this.b.evaluateScript(str, url);
        if (iX5JsValueEvaluateScript == null) {
            return null;
        }
        return new com.tencent.smtt.sdk.JsValue(this, iX5JsValueEvaluateScript);
    }

    public void evaluateScriptAsync(java.lang.String str, final android.webkit.ValueCallback valueCallback, java.net.URL url) {
        this.b.evaluateScriptAsync(str, valueCallback == null ? null : new android.webkit.ValueCallback() { // from class: com.tencent.smtt.sdk.JsContext.1
            @Override // android.webkit.ValueCallback
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onReceiveValue(com.tencent.smtt.export.external.jscore.interfaces.IX5JsValue iX5JsValue) {
                valueCallback.onReceiveValue(iX5JsValue == null ? null : new com.tencent.smtt.sdk.JsValue(com.tencent.smtt.sdk.JsContext.this, iX5JsValue));
            }
        }, url);
    }

    public com.tencent.smtt.sdk.JsContext.ExceptionHandler exceptionHandler() {
        return this.c;
    }

    public byte[] getNativeBuffer(int i) {
        return this.b.getNativeBuffer(i);
    }

    public int getNativeBufferId() {
        return this.b.getNativeBufferId();
    }

    public java.lang.String name() {
        return this.d;
    }

    public void removeJavascriptInterface(java.lang.String str) {
        this.b.removeJavascriptInterface(str);
    }

    public void setExceptionHandler(com.tencent.smtt.sdk.JsContext.ExceptionHandler exceptionHandler) {
        com.tencent.smtt.export.external.jscore.interfaces.IX5JsContext iX5JsContext;
        android.webkit.ValueCallback valueCallback;
        this.c = exceptionHandler;
        if (exceptionHandler == null) {
            iX5JsContext = this.b;
            valueCallback = null;
        } else {
            iX5JsContext = this.b;
            valueCallback = new android.webkit.ValueCallback() { // from class: com.tencent.smtt.sdk.JsContext.2
                @Override // android.webkit.ValueCallback
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public void onReceiveValue(com.tencent.smtt.export.external.jscore.interfaces.IX5JsError iX5JsError) {
                    com.tencent.smtt.sdk.JsContext.this.c.handleException(com.tencent.smtt.sdk.JsContext.this, new com.tencent.smtt.sdk.JsError(iX5JsError));
                }
            };
        }
        iX5JsContext.setExceptionHandler(valueCallback);
    }

    public void setName(java.lang.String str) {
        this.d = str;
        this.b.setName(str);
    }

    public int setNativeBuffer(int i, byte[] bArr) {
        return this.b.setNativeBuffer(i, bArr);
    }

    public void stealValueFromOtherCtx(java.lang.String str, com.tencent.smtt.sdk.JsContext jsContext, java.lang.String str2) {
        this.b.stealValueFromOtherCtx(str, jsContext.b, str2);
    }

    public com.tencent.smtt.sdk.JsVirtualMachine virtualMachine() {
        return this.f808a;
    }
}
