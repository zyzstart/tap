package com.tencent.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class b extends android.app.Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tencent.open.a f698a;

    @android.annotation.SuppressLint({"NewApi"})
    protected final android.webkit.WebChromeClient b;

    public b(android.content.Context context, int i) {
        super(context, i);
        this.b = new android.webkit.WebChromeClient() { // from class: com.tencent.open.b.1
            @Override // android.webkit.WebChromeClient
            public void onConsoleMessage(java.lang.String str, int i2, java.lang.String str2) {
                com.tencent.open.log.SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + str + " -- From 222 line " + i2 + " of " + str2);
                if (android.os.Build.VERSION.SDK_INT == 7) {
                    com.tencent.open.b.this.a(str);
                }
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(android.webkit.ConsoleMessage consoleMessage) {
                if (consoleMessage == null) {
                    return false;
                }
                com.tencent.open.log.SLog.i("openSDK_LOG.JsDialog", "WebChromeClient onConsoleMessage" + consoleMessage.message() + " -- From  111 line " + consoleMessage.lineNumber() + " of " + consoleMessage.sourceId());
                if (android.os.Build.VERSION.SDK_INT <= 7) {
                    return true;
                }
                com.tencent.open.b.this.a(consoleMessage == null ? "" : consoleMessage.message());
                return true;
            }
        };
    }

    protected abstract void a(java.lang.String str);

    @Override // android.app.Dialog
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.f698a = new com.tencent.open.a();
    }
}
