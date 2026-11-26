package com.tencent.ysdk.shell.module.sandbox.business;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PayInfoEncodeRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String CMD_ENCODE = "PayInfoEncode";
    private static final java.lang.String TAG = "sandbox_pay";
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse> mHandler;

    public PayInfoEncodeRequest(java.lang.String str, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse> httpResponseHandler) {
        super(str);
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        java.lang.String qImei = com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei();
        java.lang.String str2 = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id;
        java.lang.String qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            jSONObject.put("imei", qImei);
            jSONObject.put("openid", str2);
            jSONObject.put("appid", qQAppId);
            jSONObject.put("timestamp", jCurrentTimeMillis);
            java.lang.String strEncodeToString = android.util.Base64.encodeToString(str.getBytes(), 0);
            jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_INIT_INFO, strEncodeToString);
            jSONObject.put("md5", com.tencent.ysdk.shell.libware.encrypt.MD5.toMD5(qImei + str2 + qQAppId + strEncodeToString + jCurrentTimeMillis));
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("PayInfoEncodeRequest: ");
            sb.append(jSONObject.toString());
            com.tencent.ysdk.shell.libware.file.Logger.d("sandbox_pay", sb.toString());
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", "encode request is failed, " + e.getMessage());
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", e);
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", "encode request is failed, " + e.getMessage());
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", e);
        }
        this.data = com.tencent.ysdk.shell.libware.util.YSDKTextUtils.getBytesUTF8(jSONObject.toString());
        this.mHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        return com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameRequestHelper.genReqUrl(CMD_ENCODE);
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse payInfoEncodeResponse = new com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse();
        payInfoEncodeResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse> httpResponseHandler = this.mHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(payInfoEncodeResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse payInfoEncodeResponse = new com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse();
        payInfoEncodeResponse.parseJson(safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse> httpResponseHandler = this.mHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(payInfoEncodeResponse);
        }
    }
}
