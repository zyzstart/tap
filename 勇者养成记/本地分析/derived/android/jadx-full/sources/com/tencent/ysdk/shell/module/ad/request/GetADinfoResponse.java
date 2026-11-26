package com.tencent.ysdk.shell.module.ad.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetADinfoResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_DATA = "data";
    private static final java.lang.String PARAM_DATA_ACTION = "action";
    private static final java.lang.String PARAM_DATA_END_TIME = "end_time";
    private static final java.lang.String PARAM_DATA_PIC_URL = "pic_url";
    private static final java.lang.String PARAM_DATA_START_TIME = "start_time";
    public com.tencent.ysdk.shell.module.ad.request.ADInfo adInfo;

    private void parseGetMenuResponseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            if (!safeJSONObject.has("data")) {
                com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.framework.request.HttpResponse.TAG, safeJSONObject.toString());
                return;
            }
            this.adInfo = new com.tencent.ysdk.shell.module.ad.request.ADInfo();
            org.json.JSONObject jSONObjectOptJSONObject = safeJSONObject.optJSONObject("data");
            java.lang.String string = jSONObjectOptJSONObject == null ? "" : jSONObjectOptJSONObject.toString();
            if (!android.text.TextUtils.isEmpty(string) && !"null".equals(string)) {
                com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject2 = new com.tencent.ysdk.shell.libware.util.SafeJSONObject(string);
                if (safeJSONObject2.has(PARAM_DATA_PIC_URL)) {
                    this.adInfo.setPicUrl(safeJSONObject2.getString(PARAM_DATA_PIC_URL));
                }
                if (safeJSONObject2.has("action")) {
                    this.adInfo.setAction(safeJSONObject2.getString("action"));
                }
                if (safeJSONObject2.has(PARAM_DATA_START_TIME)) {
                    this.adInfo.setStartTime(safeJSONObject2.getLong(PARAM_DATA_START_TIME));
                }
                if (safeJSONObject2.has(PARAM_DATA_END_TIME)) {
                    this.adInfo.setEndTime(safeJSONObject2.getLong(PARAM_DATA_END_TIME));
                    return;
                }
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.framework.request.HttpResponse.TAG, safeJSONObject.toString());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseGetMenuResponseJson(safeJSONObject);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.framework.request.HttpResponse.TAG, safeJSONObject.toString());
        }
    }
}
