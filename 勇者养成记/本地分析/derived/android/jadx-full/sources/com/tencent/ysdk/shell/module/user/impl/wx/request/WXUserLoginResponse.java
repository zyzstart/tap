package com.tencent.ysdk.shell.module.user.impl.wx.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserLoginResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    public static final java.lang.String PARAM_ACCESS_TOKEN = "[REDACTED]";
    public static final java.lang.String PARAM_CHECK_TOKEN_FLAG = "[REDACTED]";
    public static final java.lang.String PARAM_EXPIRED = "atk_expire";
    public static final java.lang.String PARAM_FIRST = "first";
    private static final java.lang.String PARAM_JUDGE_LOGIN_DATA = "judgeLoginData";
    private static final java.lang.String PARAM_NICK_NAME = "nick_name";
    public static final java.lang.String PARAM_OPEN_ID = "openid";
    public static final java.lang.String PARAM_PF = "pf";
    public static final java.lang.String PARAM_PK_KEY = "pfKey";
    public static final java.lang.String PARAM_REFRESH_TOKEN = "[REDACTED]";
    public static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_VISITOR_LOGIN_DATA = "visitorLoginData";
    public int expired;
    public int first;
    public org.json.JSONObject judgeLoginData;
    public org.json.JSONObject visitorLoginData;
    public java.lang.String accessToken = "[REDACTED]";
    public java.lang.String refreshToken = "[REDACTED]";
    public java.lang.String openid = "";
    public java.lang.String regChannel = "";
    public java.lang.String pfKey = "";
    public java.lang.String pf = "";
    public int checkTokenFlag = -1;
    public java.lang.String nick_name = "";

    private void parseWXFirstLoginResponse(org.json.JSONObject jSONObject) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "parseWXFirstLoginResponse");
        try {
            this.accessToken = jSONObject.getString(PARAM_ACCESS_TOKEN);
            this.expired = jSONObject.getInt(PARAM_EXPIRED);
            this.first = jSONObject.getInt(PARAM_FIRST);
            this.openid = jSONObject.getString("openid");
            this.refreshToken = jSONObject.getString(PARAM_REFRESH_TOKEN);
            this.regChannel = jSONObject.getString("regChannel");
            this.pfKey = jSONObject.getString(PARAM_PK_KEY);
            this.pf = jSONObject.getString("pf");
            this.nick_name = jSONObject.getString(PARAM_NICK_NAME);
            if (jSONObject.has(PARAM_CHECK_TOKEN_FLAG)) {
                this.checkTokenFlag = jSONObject.getInt(PARAM_CHECK_TOKEN_FLAG);
            } else {
                this.checkTokenFlag = -1;
            }
            if (jSONObject.has(PARAM_JUDGE_LOGIN_DATA)) {
                java.lang.String string = jSONObject.getString(PARAM_JUDGE_LOGIN_DATA);
                if (!android.text.TextUtils.isEmpty(string) && !"null".equalsIgnoreCase(string)) {
                    this.judgeLoginData = new org.json.JSONObject(string);
                }
            }
            if (jSONObject.has(PARAM_VISITOR_LOGIN_DATA)) {
                java.lang.String strOptString = jSONObject.optString(PARAM_VISITOR_LOGIN_DATA);
                if (!android.text.TextUtils.isEmpty(strOptString) && !"null".equalsIgnoreCase(strOptString)) {
                    this.visitorLoginData = new org.json.JSONObject(strOptString);
                }
            }
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.request.HttpResponse.TAG, "parseQQUserCheckSuccRespones: " + jSONObject.toString());
            }
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "[REDACTED]" + this.checkTokenFlag);
        } catch (java.lang.Throwable th) {
            com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "JSONException : " + jSONObject.toString());
            th.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseWXFirstLoginResponse(safeJSONObject);
        } else if (1200 != this.flag) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, safeJSONObject.toString());
        } else {
            parseWXFirstLoginResponse(safeJSONObject);
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "User_NotRegisterRealName");
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("WXFirstLoginResponse json: ");
        sb.append("[REDACTED]" + this.accessToken);
        sb.append("&expired=" + this.expired);
        sb.append("[REDACTED]" + this.refreshToken);
        sb.append("&openid=" + this.openid);
        sb.append("&first=" + this.first);
        sb.append("&regChannel=" + this.regChannel);
        sb.append("&pfKey=" + this.pfKey);
        sb.append("&pf=" + this.pf);
        sb.append("&nickname=" + this.nick_name);
        sb.append("[REDACTED]" + this.checkTokenFlag);
        return super.toString() + sb.toString();
    }
}
