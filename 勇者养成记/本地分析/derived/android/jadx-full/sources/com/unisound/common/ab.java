package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ab extends android.os.Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.unisound.common.ac f1464a;

    public ab() {
    }

    public ab(android.os.Looper looper) {
        super(looper);
    }

    protected boolean a(android.os.Message message) {
        return true;
    }

    @Override // android.os.Handler
    public void handleMessage(android.os.Message message) {
        com.unisound.common.ac acVar;
        super.handleMessage(message);
        if (a(message) || (acVar = this.f1464a) == null) {
            return;
        }
        acVar.a(message);
    }

    public void removeSendMessage() {
        removeCallbacksAndMessages(null);
    }

    public void sendMessage(int i) {
        sendEmptyMessage(i);
    }

    public void sendMessage(int i, java.lang.Object obj) {
        obtainMessage(i, obj).sendToTarget();
    }

    public void setMessageLisenter(com.unisound.common.ac acVar) {
        this.f1464a = acVar;
    }
}
