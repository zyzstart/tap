package com.tencent.ysdk.shell.module.user.impl.qq.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQUserCheckResponse extends com.tencent.ysdk.shell.framework.request.HttpResponse {
    private static final java.lang.String PARAM_FIRST = "first";
    private static final java.lang.String PARAM_JUDGE_LOGIN_DATA = "judgeLoginData";
    private static final java.lang.String PARAM_NICK_NAME = "nick_name";
    private static final java.lang.String PARAM_PF = "pf";
    private static final java.lang.String PARAM_PFKEY = "pfKey";
    private static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_VISITOR_LOGIN_DATA = "visitorLoginData";
    public int first;
    public org.json.JSONObject judgeLoginData;
    public org.json.JSONObject visitorLoginData;
    public java.lang.String regChannel = "";
    public java.lang.String pf = "";
    public java.lang.String pfKey = "";
    public java.lang.String nick_name = "";

    private void parseQQUserCheckSuccRespones(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        try {
            this.first = safeJSONObject.getInt("first");
            this.regChannel = safeJSONObject.getString("regChannel");
            this.pfKey = safeJSONObject.getString("pfKey");
            this.pf = safeJSONObject.getString("pf");
            this.nick_name = safeJSONObject.getString(PARAM_NICK_NAME);
            if (safeJSONObject.has(PARAM_JUDGE_LOGIN_DATA)) {
                java.lang.String string = safeJSONObject.getString(PARAM_JUDGE_LOGIN_DATA);
                if (!android.text.TextUtils.isEmpty(string) && !"null".equalsIgnoreCase(string)) {
                    this.judgeLoginData = new org.json.JSONObject(string);
                }
            }
            if (safeJSONObject.has(PARAM_VISITOR_LOGIN_DATA)) {
                java.lang.String strOptString = safeJSONObject.optString(PARAM_VISITOR_LOGIN_DATA);
                if (!android.text.TextUtils.isEmpty(strOptString) && !"null".equalsIgnoreCase(strOptString)) {
                    this.visitorLoginData = new org.json.JSONObject(strOptString);
                }
            }
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.framework.request.HttpResponse.TAG, "parseQQUserCheckSuccRespones: " + safeJSONObject.toString());
            }
        } catch (java.lang.Throwable unused) {
            com.tencent.ysdk.shell.libware.file.Logger.e("QQUserCheckResponse parse json error");
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public void parseJson(com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        super.parseBaseJson(safeJSONObject);
        if (this.ret == 0) {
            parseQQUserCheckSuccRespones(safeJSONObject);
        } else if (1200 != this.flag) {
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LOG_TAG, safeJSONObject.toString());
        } else {
            parseQQUserCheckSuccRespones(safeJSONObject);
            com.tencent.ysdk.shell.libware.file.Logger.w(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LOG_TAG, "User_NotRegisterRealName");
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpResponse
    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("&first=" + this.first);
        sb.append("&regChannel=" + this.regChannel);
        sb.append("&pf=" + this.pf);
        sb.append("&pfKey=" + this.pfKey);
        sb.append("&nick_name=" + this.nick_name);
        return super.toString() + sb.toString();
    }
}
