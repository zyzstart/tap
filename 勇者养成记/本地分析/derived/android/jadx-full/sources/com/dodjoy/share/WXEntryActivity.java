package com.dodjoy.share;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXEntryActivity extends android.app.Activity implements com.tencent.mm.opensdk.openapi.IWXAPIEventHandler {
    private static java.lang.String TAG = "MicroMsg.WXEntryActivity";
    private com.tencent.mm.opensdk.openapi.IWXAPI api;
    private com.dodjoy.share.WXEntryActivity.MyHandler handler;

    private static class MyHandler extends android.os.Handler {
        private final java.lang.ref.WeakReference<com.dodjoy.share.WXEntryActivity> wxEntryActivityWeakReference;

        public MyHandler(com.dodjoy.share.WXEntryActivity wXEntryActivity) {
            this.wxEntryActivityWeakReference = new java.lang.ref.WeakReference<>(wXEntryActivity);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
        }
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) {
        super.onCreate(bundle);
        this.handler = new com.dodjoy.share.WXEntryActivity.MyHandler(this);
        try {
            this.api.handleIntent(getIntent(), this);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.api.handleIntent(intent, this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0004. Please report as an issue. */
    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onReq(com.tencent.mm.opensdk.modelbase.BaseReq baseReq) {
        switch (baseReq.getType()) {
        }
        finish();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:5:0x0007. Please report as an issue. */
    @Override // com.tencent.mm.opensdk.openapi.IWXAPIEventHandler
    public void onResp(com.tencent.mm.opensdk.modelbase.BaseResp baseResp) {
        int i = baseResp.errCode;
        if (i != -2 && i != 0) {
            switch (i) {
            }
        }
        android.widget.Toast.makeText(this, getString(0) + ", type=" + baseResp.getType(), 0).show();
        if (baseResp.getType() == 1) {
            java.lang.String str = ((com.tencent.mm.opensdk.modelmsg.SendAuth.Resp) baseResp).code;
        }
        finish();
    }
}
