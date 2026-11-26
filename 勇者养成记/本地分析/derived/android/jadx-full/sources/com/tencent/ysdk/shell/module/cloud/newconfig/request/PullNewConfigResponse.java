package com.tencent.ysdk.shell.module.cloud.newconfig.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PullNewConfigResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_DATA = "data";
    private static final java.lang.String PARAM_SDK_CONF = "sdk_conf";
    private com.tencent.ysdk.shell.libware.util.SafeJSONObject mResponseJson;
    private org.json.JSONObject mSdkConfJson;

    private void parsePullConfigResponseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        org.json.JSONObject jSONObjectOptJSONObject;
        if (safeJSONObject == null || !safeJSONObject.has("data") || (jSONObjectOptJSONObject = safeJSONObject.optJSONObject("data")) == null || !jSONObjectOptJSONObject.has(PARAM_SDK_CONF)) {
            return;
        }
        this.mSdkConfJson = jSONObjectOptJSONObject.optJSONObject(PARAM_SDK_CONF);
    }

    public com.tencent.ysdk.shell.libware.util.SafeJSONObject getResponseJson() {
        return this.mResponseJson;
    }

    public org.json.JSONObject getSdkConfJson() {
        return this.mSdkConfJson;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        this.mResponseJson = safeJSONObject;
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parsePullConfigResponseJson(safeJSONObject);
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.framework.request.HttpResponse.TAG, "PullNewConfigResponse failed: " + safeJSONObject.toString());
    }
}
