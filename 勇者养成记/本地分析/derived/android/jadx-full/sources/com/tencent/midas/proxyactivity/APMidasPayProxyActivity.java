package com.tencent.midas.proxyactivity;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasPayProxyActivity extends com.tencent.midas.plugin.APPluginProxyActivity {
    @Override // com.tencent.midas.plugin.APPluginProxyActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.midas.comm.APLog.i("APMidasPayProxyActivity", "onActivityResult requestCode:" + i + " resultCode:" + i2);
        super.onActivityResult(i, i2, intent);
    }

    @Override // com.tencent.midas.plugin.APPluginProxyActivity, android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
    }
}
