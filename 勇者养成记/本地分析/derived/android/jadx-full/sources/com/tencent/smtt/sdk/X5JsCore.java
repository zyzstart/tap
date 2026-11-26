package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class X5JsCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.smtt.sdk.X5JsCore.a f900a;
    private static com.tencent.smtt.sdk.X5JsCore.a b;
    private static com.tencent.smtt.sdk.X5JsCore.a c;
    private final android.content.Context d;
    private java.lang.Object e;
    private com.tencent.smtt.sdk.WebView f;

    private enum a {
        UNINITIALIZED,
        UNAVAILABLE,
        AVAILABLE
    }

    static {
        com.tencent.smtt.sdk.X5JsCore.a aVar = com.tencent.smtt.sdk.X5JsCore.a.UNINITIALIZED;
        f900a = aVar;
        b = aVar;
        c = aVar;
    }

    @java.lang.Deprecated
    public X5JsCore(android.content.Context context) {
        java.lang.Object objA;
        this.e = null;
        this.f = null;
        this.d = context;
        if (canUseX5JsCore(context) && (objA = a("createX5JavaBridge", new java.lang.Class[]{android.content.Context.class}, context)) != null) {
            this.e = objA;
            return;
        }
        android.util.Log.e("X5JsCore", "X5JsCore create X5JavaBridge failure, use fallback!");
        com.tencent.smtt.sdk.WebView webView = new com.tencent.smtt.sdk.WebView(context);
        this.f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
    }

    protected static com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine a(android.content.Context context, android.os.Looper looper) {
        java.lang.Object objA;
        if (canUseX5JsCore(context) && (objA = a("createX5JsVirtualMachine", new java.lang.Class[]{android.content.Context.class, android.os.Looper.class}, context, looper)) != null) {
            return (com.tencent.smtt.export.external.jscore.interfaces.IX5JsVirtualMachine) objA;
        }
        android.util.Log.e("X5JsCore", "X5JsCore#createVirtualMachine failure!");
        return null;
    }

    protected static java.lang.Object a() {
        return a("currentContextData", new java.lang.Class[0], new java.lang.Object[0]);
    }

    private static java.lang.Object a(java.lang.String str, java.lang.Class[] clsArr, java.lang.Object... objArr) {
        try {
            com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
            if (uVarA != null && uVarA.b()) {
                return uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", str, clsArr, objArr);
            }
            android.util.Log.e("X5JsCore", "X5Jscore#" + str + " - x5CoreEngine is null or is not x5core.");
            return null;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean canUseX5JsCore(android.content.Context context) {
        if (f900a != com.tencent.smtt.sdk.X5JsCore.a.UNINITIALIZED) {
            return f900a == com.tencent.smtt.sdk.X5JsCore.a.AVAILABLE;
        }
        f900a = com.tencent.smtt.sdk.X5JsCore.a.UNAVAILABLE;
        java.lang.Object objA = a("canUseX5JsCore", new java.lang.Class[]{android.content.Context.class}, context);
        if (objA == null || !(objA instanceof java.lang.Boolean) || !((java.lang.Boolean) objA).booleanValue()) {
            return false;
        }
        a("setJsValueFactory", new java.lang.Class[]{java.lang.Object.class}, com.tencent.smtt.sdk.JsValue.a());
        f900a = com.tencent.smtt.sdk.X5JsCore.a.AVAILABLE;
        return true;
    }

    public static boolean canUseX5JsCoreNewAPI(android.content.Context context) {
        if (c != com.tencent.smtt.sdk.X5JsCore.a.UNINITIALIZED) {
            return c == com.tencent.smtt.sdk.X5JsCore.a.AVAILABLE;
        }
        c = com.tencent.smtt.sdk.X5JsCore.a.UNAVAILABLE;
        java.lang.Object objA = a("canUseX5JsCoreNewAPI", new java.lang.Class[]{android.content.Context.class}, context);
        if (objA == null || !(objA instanceof java.lang.Boolean) || !((java.lang.Boolean) objA).booleanValue()) {
            return false;
        }
        c = com.tencent.smtt.sdk.X5JsCore.a.AVAILABLE;
        return true;
    }

    public static boolean canX5JsCoreUseNativeBuffer(android.content.Context context) {
        java.lang.Object objA;
        if (b != com.tencent.smtt.sdk.X5JsCore.a.UNINITIALIZED) {
            return b == com.tencent.smtt.sdk.X5JsCore.a.AVAILABLE;
        }
        b = com.tencent.smtt.sdk.X5JsCore.a.UNAVAILABLE;
        if (!canUseX5JsCore(context) || (objA = a("canX5JsCoreUseBuffer", new java.lang.Class[]{android.content.Context.class}, context)) == null || !(objA instanceof java.lang.Boolean) || !((java.lang.Boolean) objA).booleanValue()) {
            return false;
        }
        b = com.tencent.smtt.sdk.X5JsCore.a.AVAILABLE;
        return true;
    }

    @java.lang.Deprecated
    public void addJavascriptInterface(java.lang.Object obj, java.lang.String str) {
        java.lang.Object obj2 = this.e;
        if (obj2 != null) {
            a("addJavascriptInterface", new java.lang.Class[]{java.lang.Object.class, java.lang.String.class, java.lang.Object.class}, obj, str, obj2);
            return;
        }
        com.tencent.smtt.sdk.WebView webView = this.f;
        if (webView != null) {
            webView.addJavascriptInterface(obj, str);
            this.f.loadUrl("about:blank");
        }
    }

    @java.lang.Deprecated
    public void destroy() {
        java.lang.Object obj = this.e;
        if (obj != null) {
            a("destroyX5JsCore", new java.lang.Class[]{java.lang.Object.class}, obj);
            this.e = null;
            return;
        }
        com.tencent.smtt.sdk.WebView webView = this.f;
        if (webView != null) {
            webView.clearHistory();
            this.f.clearCache(true);
            this.f.loadUrl("about:blank");
            this.f.freeMemory();
            this.f.pauseTimers();
            this.f.destroy();
            this.f = null;
        }
    }

    @java.lang.Deprecated
    public void evaluateJavascript(java.lang.String str, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        java.lang.Object obj = this.e;
        if (obj != null) {
            a("evaluateJavascript", new java.lang.Class[]{java.lang.String.class, android.webkit.ValueCallback.class, java.lang.Object.class}, str, valueCallback, obj);
            return;
        }
        com.tencent.smtt.sdk.WebView webView = this.f;
        if (webView != null) {
            webView.evaluateJavascript(str, valueCallback);
        }
    }

    @java.lang.Deprecated
    public java.nio.ByteBuffer getNativeBuffer(int i) {
        java.lang.Object objA;
        if (this.e == null || !canX5JsCoreUseNativeBuffer(this.d) || (objA = a("getNativeBuffer", new java.lang.Class[]{java.lang.Object.class, java.lang.Integer.TYPE}, this.e, java.lang.Integer.valueOf(i))) == null || !(objA instanceof java.nio.ByteBuffer)) {
            return null;
        }
        return (java.nio.ByteBuffer) objA;
    }

    @java.lang.Deprecated
    public int getNativeBufferId() {
        java.lang.Object objA;
        if (this.e == null || !canX5JsCoreUseNativeBuffer(this.d) || (objA = a("getNativeBufferId", new java.lang.Class[]{java.lang.Object.class}, this.e)) == null || !(objA instanceof java.lang.Integer)) {
            return -1;
        }
        return ((java.lang.Integer) objA).intValue();
    }

    @java.lang.Deprecated
    public void pause() {
        java.lang.Object obj = this.e;
        if (obj != null) {
            a("pause", new java.lang.Class[]{java.lang.Object.class}, obj);
        }
    }

    @java.lang.Deprecated
    public void pauseTimers() {
        java.lang.Object obj = this.e;
        if (obj != null) {
            a("pauseTimers", new java.lang.Class[]{java.lang.Object.class}, obj);
        }
    }

    @java.lang.Deprecated
    public void removeJavascriptInterface(java.lang.String str) {
        java.lang.Object obj = this.e;
        if (obj != null) {
            a("removeJavascriptInterface", new java.lang.Class[]{java.lang.String.class, java.lang.Object.class}, str, obj);
            return;
        }
        com.tencent.smtt.sdk.WebView webView = this.f;
        if (webView != null) {
            webView.removeJavascriptInterface(str);
        }
    }

    @java.lang.Deprecated
    public void resume() {
        java.lang.Object obj = this.e;
        if (obj != null) {
            a("resume", new java.lang.Class[]{java.lang.Object.class}, obj);
        }
    }

    @java.lang.Deprecated
    public void resumeTimers() {
        java.lang.Object obj = this.e;
        if (obj != null) {
            a("resumeTimers", new java.lang.Class[]{java.lang.Object.class}, obj);
        }
    }

    @java.lang.Deprecated
    public void setNativeBuffer(int i, java.nio.ByteBuffer byteBuffer) {
        if (this.e == null || !canX5JsCoreUseNativeBuffer(this.d)) {
            return;
        }
        a("setNativeBuffer", new java.lang.Class[]{java.lang.Object.class, java.lang.Integer.TYPE, java.nio.ByteBuffer.class}, this.e, java.lang.Integer.valueOf(i), byteBuffer);
    }
}
