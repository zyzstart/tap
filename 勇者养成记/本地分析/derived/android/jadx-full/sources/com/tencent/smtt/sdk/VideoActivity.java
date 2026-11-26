package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VideoActivity extends android.app.Activity {
    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        super.onActivityResult(i, i2, intent);
        com.tencent.smtt.sdk.p.a(this).a(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        super.requestWindowFeature(1);
        super.getWindow().setFormat(-3);
        android.content.Intent intent = super.getIntent();
        android.os.Bundle bundleExtra = intent != null ? intent.getBundleExtra("extraData") : null;
        if (bundleExtra != null) {
            bundleExtra.putInt("callMode", 1);
            com.tencent.smtt.sdk.p.a(super.getApplicationContext()).a((java.lang.String) null, bundleExtra, (com.tencent.tbs.video.interfaces.a) null);
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.tencent.smtt.sdk.p.a(this).a(this, 4);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.tencent.smtt.sdk.p.a(this).a(this, 3);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.tencent.smtt.sdk.p.a(this).a(this, 2);
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.tencent.smtt.sdk.p.a(this).a(this, 1);
    }
}
