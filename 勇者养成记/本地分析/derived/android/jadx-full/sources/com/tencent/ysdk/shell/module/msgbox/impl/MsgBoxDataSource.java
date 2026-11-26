package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MsgBoxDataSource {
    private static final int MSG_GET_MSG_LIST_START_UP = 1;
    private static final int MSG_SHOW_MSG_JSON = 3;
    private static final int MSG_SHOW_MSG_START_UP = 2;
    private android.os.Handler mBgHandler;
    public com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.OnNewDataListener mOnNewDataListener;
    private android.os.Handler mUiHandler;
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.DataSourceStartUp mDataSourceStartUp = new com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.DataSourceStartUp();
    private com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.DataSourceFromJson mDataSourceFromJson = new com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.DataSourceFromJson();
    private com.tencent.ysdk.shell.module.pay.DataSourceAfterPay mDataSourceAfterPay = new com.tencent.ysdk.shell.module.pay.DataSourceAfterPay(this);

    class DataSourceFromJson {
        private static final java.lang.String PARAM_BG_PIC_URL = "bg_pic_url";
        private static final java.lang.String PARAM_BUSSINESS_ID = "bussiness_id";
        private static final java.lang.String PARAM_END_TIME = "end_time";
        private static final java.lang.String PARAM_H5_URL = "h5_url";
        private static final java.lang.String PARAM_MESSAGE_ID = "message_id";
        private static final java.lang.String PARAM_MESSAGE_TYPE = "message_type";
        private static final java.lang.String PARAM_PUSH_BUTTON_TEXT = "push_button_text";
        private static final java.lang.String PARAM_PUSH_BUTTON_URL = "push_button_url";
        private static final java.lang.String PARAM_SHOW_DELAY_SEC = "show_delay_sec";
        private static final java.lang.String PARAM_SHOW_FREQUENCY = "show_frequency";
        private static final java.lang.String PARAM_SHOW_TYPE = "show_type";
        private static final java.lang.String PARAM_TEXT = "text";
        private static final java.lang.String PARAM_TITLE = "title";
        private com.tencent.ysdk.module.msgbox.MsgItem jsonMsgItem;

        DataSourceFromJson() {
        }

        public void showMsg() {
            if (this.jsonMsgItem != null) {
                com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mOnNewDataListener.onNewData(this.jsonMsgItem);
                this.jsonMsgItem = null;
            }
        }

        public void showMsg(java.lang.String str) throws org.json.JSONException {
            this.jsonMsgItem = com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.generateMsgItem(new org.json.JSONObject(str));
            com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mUiHandler.sendEmptyMessage(3);
        }
    }

    class DataSourceStartUp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private java.lang.String currentOpenID = null;
        private java.util.HashMap<java.lang.String, com.tencent.ysdk.module.msgbox.MsgItem> mLocalMsgs;
        private java.util.HashMap<java.lang.String, com.tencent.ysdk.module.msgbox.MsgItem> mServerMsgs;

        public DataSourceStartUp() {
            com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(this);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void reportMsgPushEvent(com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse getMsgListResponse) {
            java.lang.String sourceData = getMsgListResponse.getSourceData();
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_MSG_PUSH_JSON, sourceData);
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
            com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatHelper.EVENT_MSG_PUSH_RESPONSE, loginRecord.ret, "", loginRecord.platform, loginRecord.open_id, map, java.lang.System.currentTimeMillis(), true, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default, "");
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet != null) {
                if (userLoginRet.ret != 0 || userLoginRet.flag != 0) {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, "MsgBox login Fail");
                    return;
                }
                if (userLoginRet.getLoginType() != 0 && 1 != userLoginRet.getLoginType()) {
                    userLoginRet.getLoginType();
                } else if (this.currentOpenID == null || !userLoginRet.open_id.equals(this.currentOpenID)) {
                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mBgHandler.sendEmptyMessageDelayed(1, 3000L);
                    this.currentOpenID = userLoginRet.open_id;
                }
            }
        }

        public void loadMsgList() {
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
            this.mLocalMsgs = (java.util.HashMap) com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.read(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG + loginRecord.open_id);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            if (this.mLocalMsgs == null) {
                this.mLocalMsgs = new java.util.HashMap<>();
            }
            java.util.Iterator<java.util.Map.Entry<java.lang.String, com.tencent.ysdk.module.msgbox.MsgItem>> it = this.mLocalMsgs.entrySet().iterator();
            while (it.hasNext()) {
                com.tencent.ysdk.module.msgbox.MsgItem value = it.next().getValue();
                if (value.getEndTime().longValue() <= java.lang.System.currentTimeMillis() / 1000) {
                    it.remove();
                } else if (value.getShowFrequency() <= 0) {
                    sb.append(value.getMessageId());
                    sb.append("_");
                }
            }
            if (sb.toString().endsWith("_")) {
                sb.deleteCharAt(sb.lastIndexOf("_"));
            }
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest(com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest.SCENE.login, com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform), loginRecord.open_id, 7 == loginRecord.platform ? loginRecord.getPayToken() : loginRecord.getAccessToken(), sb.toString(), new com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse>() { // from class: com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.DataSourceStartUp.1
                @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
                public void onResponse(com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse getMsgListResponse) {
                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.DataSourceStartUp.this.reportMsgPushEvent(getMsgListResponse);
                    if (getMsgListResponse.ret != 0) {
                        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, "get bad response");
                        return;
                    }
                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.DataSourceStartUp.this.mServerMsgs = getMsgListResponse.msgList;
                    if (!getMsgListResponse.isPayEnable) {
                        com.tencent.ysdk.shell.module.pay.PayApi.getInstance().getPayInterfaceImp().setPayEnable(getMsgListResponse.isPayEnable, getMsgListResponse.payMsg);
                    }
                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mUiHandler.sendEmptyMessage(2);
                }
            }));
        }

        public void showMsg() {
            for (java.util.Map.Entry<java.lang.String, com.tencent.ysdk.module.msgbox.MsgItem> entry : this.mServerMsgs.entrySet()) {
                java.lang.String key = entry.getKey();
                com.tencent.ysdk.module.msgbox.MsgItem value = entry.getValue();
                if (this.mLocalMsgs.containsKey(key)) {
                    value.setShowFrequency(this.mLocalMsgs.get(key).getShowFrequency() - 1);
                } else {
                    value.setShowFrequency(value.getShowFrequency() - 1);
                }
                this.mLocalMsgs.put(key, value);
                com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mOnNewDataListener.onNewData(value);
            }
            com.tencent.ysdk.shell.module.msgbox.impl.ObjectStorageHelper.save(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG + com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id, this.mLocalMsgs);
        }
    }

    private class HandlerInBG extends android.os.Handler {
        public HandlerInBG(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mDataSourceStartUp.loadMsgList();
        }
    }

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            switch (message.what) {
                case 2:
                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mDataSourceStartUp.showMsg();
                    break;
                case 3:
                    com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.this.mDataSourceFromJson.showMsg();
                    break;
            }
        }
    }

    public interface OnNewDataListener {
        void onNewData(com.tencent.ysdk.module.msgbox.MsgItem msgItem);
    }

    MsgBoxDataSource(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.OnNewDataListener onNewDataListener) {
        this.mUiHandler = null;
        this.mBgHandler = null;
        this.mOnNewDataListener = onNewDataListener;
        this.mUiHandler = new com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        this.mBgHandler = new com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxDataSource.HandlerInBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(1));
    }

    private int getIntFromJSONObject(org.json.JSONObject jSONObject, java.lang.String str, int i) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.optInt(str) : i;
    }

    private long getLongFromJSONObject(org.json.JSONObject jSONObject, java.lang.String str, long j) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.optInt(str) : j;
    }

    private java.lang.String getStringFromJSONObject(org.json.JSONObject jSONObject, java.lang.String str, java.lang.String str2) {
        return (jSONObject != null && jSONObject.has(str)) ? jSONObject.optString(str) : str2;
    }

    com.tencent.ysdk.module.msgbox.MsgItem generateMsgItem(org.json.JSONObject jSONObject) {
        com.tencent.ysdk.module.msgbox.MsgItem msgItem = new com.tencent.ysdk.module.msgbox.MsgItem();
        msgItem.setBgPicUrl(getStringFromJSONObject(jSONObject, "bg_pic_url", ""));
        msgItem.setH5Url(getStringFromJSONObject(jSONObject, "h5_url", ""));
        msgItem.setMessageId(getStringFromJSONObject(jSONObject, "message_id", ""));
        msgItem.setMessageType(getIntFromJSONObject(jSONObject, "message_type", 0));
        msgItem.setPushButtonText(getStringFromJSONObject(jSONObject, "push_button_text", ""));
        msgItem.setPushButtonUrl(getStringFromJSONObject(jSONObject, "push_button_url", ""));
        msgItem.setShowDelaySec(getIntFromJSONObject(jSONObject, "show_delay_sec", 0));
        msgItem.setShowFrequency(getIntFromJSONObject(jSONObject, "show_frequency", 0));
        msgItem.setEndTime(java.lang.Long.valueOf(getLongFromJSONObject(jSONObject, "end_time", 0L)));
        msgItem.setShowType(getIntFromJSONObject(jSONObject, "show_type", 0));
        msgItem.setText(getStringFromJSONObject(jSONObject, com.unisound.sdk.cb.h, ""));
        msgItem.setTitle(getStringFromJSONObject(jSONObject, "title", ""));
        msgItem.setBussinessId(getStringFromJSONObject(jSONObject, "bussiness_id", ""));
        return msgItem;
    }

    public void showJsonMsg(java.lang.String str) {
        try {
            this.mDataSourceFromJson.showMsg(str);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e("MsgBox Data Source get Bad Json String");
        }
    }
}
