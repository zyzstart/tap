package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f1284a;
    final /* synthetic */ java.lang.String b;

    e(android.content.Context context, java.lang.String str) {
        this.f1284a = context;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        android.widget.Toast.makeText(this.f1284a, this.b, 1).show();
        android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) this.f1284a.getSystemService("clipboard");
        if (clipboardManager != null) {
            clipboardManager.setPrimaryClip(android.content.ClipData.newPlainText("beacon", this.b));
        }
    }
}
