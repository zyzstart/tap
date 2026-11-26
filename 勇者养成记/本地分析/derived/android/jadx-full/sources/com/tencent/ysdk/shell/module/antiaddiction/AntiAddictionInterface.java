package com.tencent.ysdk.shell.module.antiaddiction;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public interface AntiAddictionInterface {
    public static final java.lang.String LOG_TAG = "YSDK_AntiAddiction";

    boolean checkAntiAddictionLoginRules(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginAntiAddictCallBack, boolean z);

    int getGameDuration();

    boolean isVisitorState();

    void onRegisterWindowClose();

    void printLogInDebug(java.lang.String str);

    void queryCertification(com.tencent.ysdk.module.antiaddiction.listener.QueryCertificationCallback queryCertificationCallback);

    void registerRealName();

    void reportExecute(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet, long j);

    void resetGameStartFromBackground();

    void setAntiAddictionListener(com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener antiAddictListener);

    void setGameBackground();

    boolean setGameEnd();

    boolean setGameStart();

    void setLogEnable(boolean z);

    void setRegisterWindowClose(com.tencent.ysdk.module.antiaddiction.listener.AntiRegisterWindowCloseListener antiRegisterWindowCloseListener);

    void setVisitorState(boolean z);

    void visitorLogin();
}
