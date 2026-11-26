package com.tencent.ysdk.shell.module.antiaddiction.impl.model;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VisitorLoginModel {
    private static final java.lang.String PARAM_JUDGE_LOGIN_DATA = "judgeLoginData";
    private static final java.lang.String PARAM_VISITOR_GUIDE_URL = "visitorLoginConfirmUrl";
    private static final java.lang.String PARAM_VISITOR_LOGIN_STATE = "visitorLoginState";
    private static final java.lang.String PARAM_VISITOR_LOGIN_URL = "visitorLoginUrl";
    private static final java.lang.String PARAM_VISITOR_SWITCH = "visitorSwitch";
    public com.tencent.ysdk.shell.module.antiaddiction.impl.model.LoginJudgeModel loginJudgeModel;
    public java.lang.String visitorGuideUrl;
    public int visitorLoginState;
    public java.lang.String visitorLoginUrl;
    public int visitorSwitch;

    public VisitorLoginModel(org.json.JSONObject jSONObject) {
        this.visitorSwitch = -1;
        this.visitorLoginState = -1;
        if (jSONObject != null) {
            try {
                if (jSONObject.has(PARAM_VISITOR_SWITCH)) {
                    this.visitorSwitch = jSONObject.optInt(PARAM_VISITOR_SWITCH);
                    if (jSONObject.has(PARAM_VISITOR_LOGIN_URL)) {
                        this.visitorLoginUrl = jSONObject.optString(PARAM_VISITOR_LOGIN_URL);
                    }
                    if (jSONObject.has(PARAM_VISITOR_LOGIN_STATE)) {
                        this.visitorLoginState = jSONObject.optInt(PARAM_VISITOR_LOGIN_STATE);
                    }
                    if (jSONObject.has(PARAM_VISITOR_GUIDE_URL)) {
                        this.visitorGuideUrl = jSONObject.optString(PARAM_VISITOR_GUIDE_URL);
                    }
                    if (jSONObject.has(PARAM_JUDGE_LOGIN_DATA)) {
                        java.lang.String strOptString = jSONObject.optString(PARAM_JUDGE_LOGIN_DATA);
                        if (android.text.TextUtils.isEmpty(strOptString)) {
                            return;
                        }
                        this.loginJudgeModel = new com.tencent.ysdk.shell.module.antiaddiction.impl.model.LoginJudgeModel(new org.json.JSONObject(strOptString));
                    }
                }
            } catch (java.lang.Throwable unused) {
                com.tencent.ysdk.libware.file.Logger.e("VisitorLoginModel parse json error");
            }
        }
    }
}
