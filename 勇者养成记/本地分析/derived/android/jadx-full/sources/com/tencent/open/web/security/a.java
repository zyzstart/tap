package com.tencent.open.web.security;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends android.view.inputmethod.InputConnectionWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f738a = null;
    public static boolean b = false;
    public static boolean c = false;

    public a(android.view.inputmethod.InputConnection inputConnection, boolean z) {
        super(inputConnection, z);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean commitText(java.lang.CharSequence charSequence, int i) {
        c = true;
        f738a = charSequence.toString();
        com.tencent.open.log.SLog.v("openSDK_LOG.CaptureInputConnection", "-->commitText: " + charSequence.toString());
        return super.commitText(charSequence, i);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(android.view.KeyEvent keyEvent) {
        if (keyEvent.getAction() == 0) {
            com.tencent.open.log.SLog.i("openSDK_LOG.CaptureInputConnection", "sendKeyEvent");
            f738a = java.lang.String.valueOf((char) keyEvent.getUnicodeChar());
            c = true;
            com.tencent.open.log.SLog.d("openSDK_LOG.CaptureInputConnection", "s: " + f738a);
        }
        com.tencent.open.log.SLog.d("openSDK_LOG.CaptureInputConnection", "-->sendKeyEvent: " + f738a);
        return super.sendKeyEvent(keyEvent);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public boolean setComposingText(java.lang.CharSequence charSequence, int i) {
        c = true;
        f738a = charSequence.toString();
        com.tencent.open.log.SLog.v("openSDK_LOG.CaptureInputConnection", "-->setComposingText: " + charSequence.toString());
        return super.setComposingText(charSequence, i);
    }
}
