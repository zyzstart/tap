package com.tencent.ysdk.shell.module.user.impl.wx.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserAutoLoginRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_ACCESS_TOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_CHANNEL = "channel";
    private static final java.lang.String PARAM_CHECK_TOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_HOPE_SWITCH = "client_hope_switch";
    private static final java.lang.String PARAM_LOGIN_TYPE = "loginType";
    private static final java.lang.String PARAM_OFFERID = "offerid";
    public static final java.lang.String PARAM_PLATFORM_PF = "platform";
    private static final java.lang.String PARAM_REFRESH_TOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_VISITOR_SWITCH = "visitor_switch";
    private static final java.lang.String PATH = "/auth/wx_verify_login";
    private java.lang.String mAccessToken;
    private int mCheckTokenFlag;
    private int mHopeSwitch;
    private int mLoginType;
    private java.lang.String mOpenId;
    private java.lang.String mRefreshToken;
    private java.lang.String mRegChannel;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse> mResponseHandler;
    private int mVisitorSwitch;

    public WXUserAutoLoginRequest(int i, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, int i2, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse> httpResponseHandler) {
        super(PATH);
        this.mAccessToken = "[REDACTED]";
        this.mRefreshToken = "[REDACTED]";
        this.mOpenId = "";
        this.mRegChannel = "";
        this.mCheckTokenFlag = -1;
        this.mLoginType = -1;
        this.mVisitorSwitch = -1;
        this.mOpenId = str;
        this.mAccessToken = str2;
        this.mRefreshToken = str3;
        this.mResponseHandler = httpResponseHandler;
        this.mCheckTokenFlag = i2;
        this.mRegChannel = str4;
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
        sb.append("atk");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mAccessToken));
        sb.append("&");
        sb.append("offerid");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId()));
        sb.append("&");
        sb.append("rtk");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRefreshToken));
        sb.append("&");
        sb.append("regChannel");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRegChannel));
        sb.append("&");
        sb.append(PARAM_CHECK_TOKEN);
        sb.append("=");
        sb.append(this.mCheckTokenFlag);
        sb.append("&");
        sb.append("loginType");
        sb.append("=");
        sb.append(this.mLoginType);
        java.lang.String str = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getStartPlatform().pfStr() + "_" + com.tencent.ysdk.framework.common.ePlatform.WX.platformStr();
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
        com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
        try {
            java.lang.String baseParams = getBaseParams(com.tencent.ysdk.framework.common.ePlatform.WX, this.mOpenId);
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
        com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse = new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse();
        wXUserLoginResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(wXUserLoginResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse = new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse();
        wXUserLoginResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(wXUserLoginResponse);
        }
    }

    public void setVisitorSwitch(int i) {
        this.mVisitorSwitch = i;
    }
}
