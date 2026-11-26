package com.tencent.ysdk.shell.module.user.impl.guest.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GuestUserLoginResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_FIRST = "first";
    private static final java.lang.String PARAM_JUDGE_LOGIN_DATA = "judgeLoginData";
    private static final java.lang.String PARAM_MSG = "msg";
    private static final java.lang.String PARAM_OPEN_ID = "openid";
    private static final java.lang.String PARAM_PAY_TOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_PF = "pf";
    private static final java.lang.String PARAM_PF_KEY = "pfKey";
    private static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_VISITOR_LOGIN_DATA = "visitorLoginData";
    public int first;
    private org.json.JSONObject mJudgeLoginData;
    private org.json.JSONObject mVisitorLoginData;
    public java.lang.String msg = "";
    public java.lang.String openid = "";
    public java.lang.String pay_token = "[REDACTED]";
    public java.lang.String pf = "";
    public java.lang.String pfKey = "";
    public java.lang.String regChannel = "";

    private void parseGuestUserCheckSuccRespones(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            this.first = safeJSONObject.getInt("first");
            this.msg = safeJSONObject.getString("msg");
            this.openid = safeJSONObject.getString("openid");
            this.pay_token = safeJSONObject.getString(PARAM_PAY_TOKEN);
            this.pf = safeJSONObject.getString("pf");
            this.pfKey = safeJSONObject.getString("pfKey");
            this.regChannel = safeJSONObject.getString("regChannel");
            if (safeJSONObject.has(PARAM_JUDGE_LOGIN_DATA)) {
                java.lang.String string = safeJSONObject.getString(PARAM_JUDGE_LOGIN_DATA);
                if (!android.text.TextUtils.isEmpty(string) && !"null".equalsIgnoreCase(string)) {
                    this.mJudgeLoginData = new org.json.JSONObject(string);
                }
            }
            if (safeJSONObject.has(PARAM_VISITOR_LOGIN_DATA)) {
                java.lang.String strOptString = safeJSONObject.optString(PARAM_VISITOR_LOGIN_DATA);
                if (!android.text.TextUtils.isEmpty(strOptString) && !"null".equalsIgnoreCase(strOptString)) {
                    this.mVisitorLoginData = new org.json.JSONObject(strOptString);
                }
            }
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.request.HttpResponse.TAG, "parseQQUserCheckSuccRespones: " + safeJSONObject.toString());
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    public org.json.JSONObject getJudgeLoginData() {
        return this.mJudgeLoginData;
    }

    public org.json.JSONObject getVisitorLoginData() {
        return this.mVisitorLoginData;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseGuestUserCheckSuccRespones(safeJSONObject);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.LOG_TAG, safeJSONObject.toString());
        }
    }
}
