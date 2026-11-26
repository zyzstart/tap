package com.tencent.qqdownloader.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQDownloaderEntryActivity extends android.app.Activity {
    private void a(android.content.Intent intent) {
        com.tencent.qqdownloader.pay.api.b.a().a(intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        a(getIntent());
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        a(getIntent());
    }
}
