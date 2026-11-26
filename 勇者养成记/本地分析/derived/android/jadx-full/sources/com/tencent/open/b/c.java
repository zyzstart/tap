package com.tencent.open.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.open.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f701a;
    private android.view.KeyEvent b;
    private com.tencent.open.web.security.a c;

    public c(android.content.Context context) {
        super(context);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(android.view.KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        com.tencent.open.log.SLog.d("openSDK_LOG.SecureWebView", "-->dispatchKeyEvent, is device support: " + f701a);
        if (f701a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.b = true;
            } else {
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                if (!com.tencent.open.web.security.SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                    return super.dispatchKeyEvent(keyEvent);
                }
                keyEvent = new android.view.KeyEvent(0, 17);
                this.b = keyEvent;
            }
            return super.dispatchKeyEvent(keyEvent);
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.webkit.WebView, android.view.View
    public android.view.inputmethod.InputConnection onCreateInputConnection(android.view.inputmethod.EditorInfo editorInfo) {
        com.tencent.open.log.SLog.i("openSDK_LOG.SecureWebView", "-->create input connection, is edit: " + com.tencent.open.web.security.SecureJsInterface.isPWDEdit);
        android.view.inputmethod.InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
        com.tencent.open.log.SLog.v("openSDK_LOG.SecureWebView", "-->onCreateInputConnection, inputConn is " + inputConnectionOnCreateInputConnection);
        if (inputConnectionOnCreateInputConnection == null) {
            f701a = false;
            return inputConnectionOnCreateInputConnection;
        }
        f701a = true;
        com.tencent.open.web.security.a aVar = new com.tencent.open.web.security.a(super.onCreateInputConnection(editorInfo), false);
        this.c = aVar;
        return aVar;
    }

    @Override // android.webkit.WebView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        int keyCode;
        int unicodeChar;
        com.tencent.open.log.SLog.d("openSDK_LOG.SecureWebView", "-->onKeyDown, is device support: " + f701a);
        if (f701a && keyEvent.getAction() == 0 && (keyCode = keyEvent.getKeyCode()) != 4 && keyCode != 66) {
            if (keyCode == 67) {
                com.tencent.open.web.security.a.b = true;
            } else {
                if (keyEvent.getUnicodeChar() == 0) {
                    return super.onKeyDown(i, keyEvent);
                }
                if (!com.tencent.open.web.security.SecureJsInterface.isPWDEdit || (((unicodeChar = keyEvent.getUnicodeChar()) < 33 || unicodeChar > 95) && (unicodeChar < 97 || unicodeChar > 125))) {
                    return super.onKeyDown(i, keyEvent);
                }
                android.view.KeyEvent keyEvent2 = new android.view.KeyEvent(0, 17);
                this.b = keyEvent2;
                i = keyEvent2.getKeyCode();
                keyEvent = this.b;
            }
            return super.onKeyDown(i, keyEvent);
        }
        return super.onKeyDown(i, keyEvent);
    }
}
