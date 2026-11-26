package com.tencent.ysdk.shell.module.msgbox.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetMsgListResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_ACTION_AFTER_CLOSE = "action_after_close";
    private static final java.lang.String PARAM_ACTION_TEXT = "text";
    private static final java.lang.String PARAM_ACTION_TYPE = "type";
    private static final java.lang.String PARAM_BG_PIC_URL = "bg_pic_url";
    private static final java.lang.String PARAM_BUSSINESS_ID = "bussiness_id";
    private static final java.lang.String PARAM_DATA = "data";
    private static final java.lang.String PARAM_END_TIME = "end_time";
    private static final java.lang.String PARAM_H5_URL = "h5_url";
    private static final java.lang.String PARAM_MESSAGE_ID = "message_id";
    private static final java.lang.String PARAM_MESSAGE_TYPE = "message_type";
    private static final java.lang.String PARAM_PAY_DATA = "pay_data";
    private static final java.lang.String PARAM_PAY_ENABLE = "pay_enable";
    private static final java.lang.String PARAM_PUSH_BUTTON_TEXT = "push_button_text";
    private static final java.lang.String PARAM_PUSH_BUTTON_URL = "push_button_url";
    private static final java.lang.String PARAM_SHOW_AFTER_SEC = "show_after_sec";
    private static final java.lang.String PARAM_SHOW_DELAY_SEC = "show_delay_sec";
    private static final java.lang.String PARAM_SHOW_FREQUENCY = "show_frequency";
    private static final java.lang.String PARAM_SHOW_TYPE = "show_type";
    private static final java.lang.String PARAM_TEXT = "text";
    private static final java.lang.String PARAM_TITLE = "title";
    public java.util.HashMap<java.lang.String, com.tencent.ysdk.module.msgbox.MsgItem> msgList = new java.util.HashMap<>();
    public boolean isPayEnable = true;
    public com.tencent.ysdk.module.msgbox.MsgItem payMsg = null;
    private java.lang.String mSourceData = "";

    private com.tencent.ysdk.module.msgbox.MsgItem generateMsgItem(org.json.JSONObject jSONObject) {
        org.json.JSONObject jSONObjectOptJSONObject;
        com.tencent.ysdk.module.msgbox.MsgItem msgItem = new com.tencent.ysdk.module.msgbox.MsgItem();
        msgItem.setBgPicUrl(jSONObject.optString(PARAM_BG_PIC_URL, ""));
        msgItem.setH5Url(jSONObject.optString(PARAM_H5_URL, ""));
        msgItem.setMessageId(jSONObject.optString(PARAM_MESSAGE_ID, ""));
        msgItem.setMessageType(jSONObject.optInt(PARAM_MESSAGE_TYPE, 0));
        msgItem.setPushButtonText(jSONObject.optString(PARAM_PUSH_BUTTON_TEXT, ""));
        msgItem.setPushButtonUrl(jSONObject.optString(PARAM_PUSH_BUTTON_URL, ""));
        msgItem.setShowDelaySec(jSONObject.optInt(PARAM_SHOW_DELAY_SEC, 0));
        msgItem.setShowAfterSec(jSONObject.optLong(PARAM_SHOW_AFTER_SEC, 0L));
        msgItem.setShowFrequency(jSONObject.optInt(PARAM_SHOW_FREQUENCY, 0));
        msgItem.setEndTime(java.lang.Long.valueOf(jSONObject.optLong(PARAM_END_TIME, 0L)));
        msgItem.setShowType(jSONObject.optInt(PARAM_SHOW_TYPE, 0));
        msgItem.setText(jSONObject.optString(com.unisound.sdk.cb.h, ""));
        msgItem.setTitle(jSONObject.optString("title", ""));
        msgItem.setBussinessId(jSONObject.optString(PARAM_BUSSINESS_ID, ""));
        msgItem.setDuration(jSONObject.optLong(com.tencent.ysdk.shell.framework.request.HttpRequest.DURATION_TIME, 0L));
        if (!jSONObject.has(PARAM_ACTION_AFTER_CLOSE) || (jSONObjectOptJSONObject = jSONObject.optJSONObject(PARAM_ACTION_AFTER_CLOSE)) == null) {
            return msgItem;
        }
        com.tencent.ysdk.module.msgbox.MsgItem.MsgAction msgAction = new com.tencent.ysdk.module.msgbox.MsgItem.MsgAction();
        if (jSONObjectOptJSONObject.has(com.unisound.sdk.cb.h)) {
            msgAction.setActionType(jSONObjectOptJSONObject.optInt("type"));
        }
        if (jSONObjectOptJSONObject.has(com.unisound.sdk.cb.h)) {
            msgAction.setText(jSONObjectOptJSONObject.optString(com.unisound.sdk.cb.h));
        }
        msgItem.setMsgAction(msgAction);
        return msgItem;
    }

    private boolean parseDataFromJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        if (!safeJSONObject.has("data")) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, safeJSONObject.toString());
            return false;
        }
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray(safeJSONObject.optString("data"));
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                org.json.JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    com.tencent.ysdk.module.msgbox.MsgItem msgItemGenerateMsgItem = generateMsgItem(jSONObjectOptJSONObject);
                    this.msgList.put(msgItemGenerateMsgItem.getMessageId(), msgItemGenerateMsgItem);
                }
            }
            return true;
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, "parseJsonArray false");
            return false;
        }
    }

    private void parseGetMenuResponseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        parseDataFromJson(safeJSONObject);
        parsePayDataFromJson(safeJSONObject);
    }

    private boolean parsePayDataFromJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        if (safeJSONObject.opt(PARAM_PAY_DATA) == null) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, safeJSONObject.toString());
            return false;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(safeJSONObject.optString(PARAM_PAY_DATA, ""));
            this.isPayEnable = jSONObject.optString(PARAM_PAY_ENABLE, "0").equals("1");
            this.payMsg = generateMsgItem(jSONObject);
            return true;
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, safeJSONObject.toString() + "Error:" + e.getMessage());
            return false;
        }
    }

    public java.lang.String getSourceData() {
        return this.mSourceData;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        this.mSourceData = safeJSONObject.toString();
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseGetMenuResponseJson(safeJSONObject);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModule.TAG, safeJSONObject.toString());
        }
    }
}
