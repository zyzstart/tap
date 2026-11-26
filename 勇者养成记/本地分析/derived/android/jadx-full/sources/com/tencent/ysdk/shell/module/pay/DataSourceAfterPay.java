package com.tencent.ysdk.shell.module.pay;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DataSourceAfterPay extends android.content.BroadcastReceiver {
    public static final java.lang.String CONTENT_KEY = "MSG_LOCAL_BROADCAST_AFTER_PAY";
    private static final int MSG_SHOW_MSG_AFTER_PAY = 4;
    public static final java.lang.String PAY_ERRORCODE = "pay_errorcode";
    public static final java.lang.String PAY_SCENE = "pay_scene";
    public static final java.lang.String PUSH_ACTION = "com.tencent.ysdk.MSG_LOCAL_BROADCAST_AFTER_PAY";
    public static final java.lang.String SCENE_AFTERPAY = "afterPay";
    public static final java.lang.String SCENE_AFTERPAY_FAILED = "afterPayFailed";
    private static final java.lang.String TAG = "DataSourceAfterPay";
    private java.util.HashMap<java.lang.String, com.tencent.ysdk.module.msgbox.MsgItem> mServerMsgs = new java.util.HashMap<>();
    private android.os.Handler mUiHandler;
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource msgBoxDataSource;

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 4) {
                return;
            }
            com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.this.showMsg();
        }
    }

    public DataSourceAfterPay(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource msgBoxDataSource) {
        this.mUiHandler = null;
        this.msgBoxDataSource = msgBoxDataSource;
        this.mUiHandler = new com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        registerInnerAfterPayBroadcast();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportMsgPushEvent(com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse getMsgListResponse) {
        java.lang.String sourceData = getMsgListResponse.getSourceData();
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_MSG_PUSH_JSON, sourceData);
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_MSG_PUSH_RESPONSE, loginRecord.ret, "", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default, "");
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        java.lang.String payToken = 7 == loginRecord.platform ? loginRecord.getPayToken() : loginRecord.getAccessToken();
        com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest.SCENE scene = com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest.SCENE.afterpay;
        java.lang.String stringExtra = intent.getStringExtra(PAY_SCENE);
        com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest.SCENE scene2 = (android.text.TextUtils.isEmpty(stringExtra) || !stringExtra.equals(SCENE_AFTERPAY_FAILED)) ? scene : com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest.SCENE.afterpayFailed;
        java.lang.String stringExtra2 = intent.getStringExtra(PAY_ERRORCODE);
        com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest getMsgListRequest = new com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest(scene2, com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform), loginRecord.open_id, payToken, "[REDACTED]", new com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse>() { // from class: com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.1
            @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
            public void onResponse(com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse getMsgListResponse) {
                com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.this.reportMsgPushEvent(getMsgListResponse);
                if (getMsgListResponse.ret != 0) {
                    com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, "get bad response");
                    return;
                }
                com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.this.mServerMsgs = getMsgListResponse.msgList;
                com.tencent.ysdk.shell.module.pay.DataSourceAfterPay.this.mUiHandler.sendEmptyMessage(4);
            }
        });
        getMsgListRequest.setPayErrorCode(stringExtra2);
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(getMsgListRequest);
    }

    protected void registerInnerAfterPayBroadcast() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "registerInnerAfterPayBroadcast");
        com.tencent.ysdk.shell.external.LocalBroadcastManager.getInstance(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()).registerReceiver(this, new android.content.IntentFilter(PUSH_ACTION));
    }

    public void showMsg() {
        java.util.Iterator<java.util.Map.Entry<java.lang.String, com.tencent.ysdk.module.msgbox.MsgItem>> it = this.mServerMsgs.entrySet().iterator();
        while (it.hasNext()) {
            this.msgBoxDataSource.mOnNewDataListener.onNewData(it.next().getValue());
        }
    }

    protected void unRegisterInnerXGBroadcast() {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "unregisterInnerXGBroadcast");
        com.tencent.ysdk.shell.external.LocalBroadcastManager.getInstance(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext()).unregisterReceiver(this);
    }
}
