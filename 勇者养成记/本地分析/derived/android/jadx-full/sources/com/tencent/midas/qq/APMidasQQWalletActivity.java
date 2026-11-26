package com.tencent.midas.qq;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasQQWalletActivity extends android.app.Activity {
    private static final java.lang.String TAG = "APMidasQQWalletActivity";

    private void handleIntent(android.content.Intent intent) {
        com.tencent.midas.comm.APLog.d(TAG, "handleIntent get called!");
        try {
            com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface(this, com.tencent.midas.control.APMidasPayHelper.MIDAS_PLUGIN_NAME, com.tencent.midas.control.APMidasPayHelper.PKG_DISTRIBUTE, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT, new java.lang.Object[]{this, intent});
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.e(TAG, "handleIntent got exception = " + e.toString());
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        try {
            getIntent().getStringExtra("wxpay");
            try {
                requestWindowFeature(1);
                handleIntent(getIntent());
                finish();
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                finish();
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
