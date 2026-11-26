package com.tencent.ysdk.shell.module.user.impl.wx.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserScanForloginResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_NONCESTR = "noncestr";
    private static final java.lang.String PARAM_OPEN_APPID = "openappid";
    private static final java.lang.String PARAM_SCOPE = "scope";
    private static final java.lang.String PARAM_SIGNATURE = "signature";
    private static final java.lang.String PARAM_TIME_STAMP = "timestamp";
    private static final java.lang.String PARAM_WX_APPID = "appid";
    private static final java.lang.String PATH = "/auth/wx_scan_code_login";
    public java.lang.String appid;
    public java.lang.String noncestr;
    public java.lang.String openappid;
    public java.lang.String scope;
    public java.lang.String signature;
    public java.lang.String timestamp;

    private void parseWXScanLoginResponse(org.json.JSONObject jSONObject) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "parseWXScanLoginResponse");
        try {
            this.appid = jSONObject.getString("appid");
            this.openappid = jSONObject.getString(PARAM_OPEN_APPID);
            this.scope = jSONObject.getString("scope");
            this.noncestr = jSONObject.getString(PARAM_NONCESTR);
            this.timestamp = jSONObject.getString("timestamp");
            this.signature = jSONObject.getString("signature");
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "JSONException : " + jSONObject.toString());
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseWXScanLoginResponse(safeJSONObject);
        } else if (1200 != this.flag) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, safeJSONObject.toString());
        } else {
            parseWXScanLoginResponse(safeJSONObject);
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "User_NotRegisterRealName");
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public java.lang.String toString() {
        return "WXUserScanForloginResponse{appid='" + this.appid + "', openappid='" + this.openappid + "', scope='" + this.scope + "', noncestr='" + this.noncestr + "', timestamp='" + this.timestamp + "', signature='" + this.signature + "'}";
    }
}
