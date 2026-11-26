package com.tencent.ysdk.shell.module.user.impl.qq.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQUserCheckRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_ACCESSTOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_ACCESSTOKEN_CHECK = "[REDACTED]";
    private static final java.lang.String PARAM_CHANNEL = "channel";
    private static final java.lang.String PARAM_HOPE_SWITCH = "client_hope_switch";
    private static final java.lang.String PARAM_LOGIN_TYPE = "loginType";
    private static final java.lang.String PARAM_OFFERID = "offerid";
    private static final java.lang.String PARAM_PAYTOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_PAYTOKEN_CHECK = "[REDACTED]";
    public static final java.lang.String PARAM_PLATFORM_PF = "platform";
    private static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_VISITOR_SWITCH = "visitor_switch";
    private static final java.lang.String PATH = "/auth/qq_verify_login";
    private int mHopeSwitch;
    private int mLoginType;
    private com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet mQQUserLoginRet;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse> mResponseHandler;
    private int mVisitorSwitch;

    public QQUserCheckRequest(int i, com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse> httpResponseHandler) {
        super(PATH);
        this.mLoginType = -1;
        this.mVisitorSwitch = -1;
        this.mQQUserLoginRet = qQUserLoginRet;
        this.mResponseHandler = httpResponseHandler;
        this.reportIMEI = true;
        this.mLoginType = i;
        this.mHopeSwitch = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_ANTIADDICTION_SWITCH, false) ? 1 : 0;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        com.tencent.ysdk.shell.framework.YSDKSystem ySDKSystem = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        sb.append("channel");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(ySDKSystem.getChannelId()));
        sb.append("&");
        sb.append("offerid");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(ySDKSystem.getOfferId()));
        sb.append("&");
        sb.append("atk");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mQQUserLoginRet.access_token));
        sb.append("&");
        sb.append(PARAM_PAYTOKEN);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mQQUserLoginRet.pay_token));
        sb.append("&");
        sb.append("regChannel");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mQQUserLoginRet.getRegChannel()));
        sb.append("&");
        sb.append(PARAM_ACCESSTOKEN_CHECK);
        sb.append("=");
        sb.append("1");
        sb.append("&");
        sb.append(PARAM_PAYTOKEN_CHECK);
        sb.append("=");
        sb.append("1");
        sb.append("&");
        sb.append("loginType");
        sb.append("=");
        sb.append(this.mLoginType);
        java.lang.String str = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getStartPlatform().pfStr() + "_" + com.tencent.ysdk.framework.common.ePlatform.QQ.platformStr();
        com.tencent.ysdk.shell.libware.file.Logger.d("final platform:" + str);
        sb.append("&");
        sb.append("platform");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(str));
        sb.append("&");
        sb.append(PARAM_HOPE_SWITCH);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(this.mHopeSwitch)));
        sb.append("&");
        sb.append(PARAM_VISITOR_SWITCH);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(this.mVisitorSwitch)));
        try {
            java.lang.String baseParams = getBaseParams(com.tencent.ysdk.framework.common.ePlatform.QQ, this.mQQUserLoginRet.open_id);
            com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(getBaseUrl());
            sb.append(baseParams);
            sb2.append(sb.toString());
            return sb2.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "获取URL通用参数异常");
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse qQUserCheckResponse = new com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse();
        qQUserCheckResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(qQUserCheckResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse qQUserCheckResponse = new com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse();
        qQUserCheckResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(qQUserCheckResponse);
        }
    }

    public void setVisitorSwitch(int i) {
        this.mVisitorSwitch = i;
    }
}
