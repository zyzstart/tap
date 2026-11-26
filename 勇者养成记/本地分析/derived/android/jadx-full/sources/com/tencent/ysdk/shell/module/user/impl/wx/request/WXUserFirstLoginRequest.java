package com.tencent.ysdk.shell.module.user.impl.wx.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserFirstLoginRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_CHANNEL = "channel";
    private static final java.lang.String PARAM_HOPE_SWITCH = "client_hope_switch";
    private static final java.lang.String PARAM_LOGIN_TYPE = "loginType";
    private static final java.lang.String PARAM_OFFERID = "offerid";
    public static final java.lang.String PARAM_PLATFORM_PF = "platform";
    private static final java.lang.String PARAM_VISITOR_SWITCH = "visitor_switch";
    private static final java.lang.String PARAM_WX_CODE = "code";
    private static final java.lang.String PATH = "/auth/wx_verify_code";
    private java.lang.String mGrantType;
    private int mHopeSwitch;
    private int mLoginType;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse> mResponseHandler;
    private java.lang.String mWXCode;

    public WXUserFirstLoginRequest(java.lang.String str, java.lang.String str2, int i, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse> httpResponseHandler) {
        super(PATH);
        this.mGrantType = "";
        this.mWXCode = "";
        this.mLoginType = -1;
        this.mGrantType = str;
        this.mWXCode = str2;
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
        sb.append(ySDKSystem.getChannelId());
        sb.append("&");
        sb.append("code");
        sb.append("=");
        sb.append(this.mWXCode);
        sb.append("&");
        sb.append("offerid");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
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
        com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
        try {
            java.lang.String baseParams = getBaseParams(com.tencent.ysdk.framework.common.ePlatform.WX, "");
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
}
