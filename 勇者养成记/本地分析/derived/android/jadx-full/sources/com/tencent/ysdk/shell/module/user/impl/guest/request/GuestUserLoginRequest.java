package com.tencent.ysdk.shell.module.user.impl.guest.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GuestUserLoginRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_CHANNEL = "channel";
    private static final java.lang.String PARAM_HOPE_SWITCH = "client_hope_switch";
    private static final java.lang.String PARAM_IMEI = "deviceid";
    private static final java.lang.String PARAM_MAC = "mac";
    private static final java.lang.String PARAM_OFFERID = "offerid";
    private static final java.lang.String PARAM_OPENID = "openid";
    public static final java.lang.String PARAM_PLATFORM_PF = "platform";
    private static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_VISITOR_SWITCH = "visitor_switch";
    private static final java.lang.String PATH = "/auth/guest_verify_login";
    private java.lang.String mOpenId;
    private java.lang.String mRegChannel;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse> mResponseHandler;
    private int mVisitorSwitch;

    public GuestUserLoginRequest(java.lang.String str, java.lang.String str2, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse> httpResponseHandler) {
        super(PATH);
        this.mResponseHandler = null;
        this.mOpenId = "";
        this.mRegChannel = "";
        this.mVisitorSwitch = -1;
        this.mOpenId = str;
        this.mRegChannel = str2;
        this.mResponseHandler = httpResponseHandler;
        this.reportIMEI = true;
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
        sb.append(PARAM_IMEI);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.module.stat.StatApi.getInstance().getIMEI()));
        sb.append("&");
        sb.append("regChannel");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRegChannel));
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mOpenId)) {
            sb.append("&");
            sb.append("openid");
            sb.append("=");
            sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mOpenId));
        }
        java.lang.String localMacAddress = com.tencent.ysdk.shell.libware.device.DeviceUtils.getLocalMacAddress(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext());
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(localMacAddress)) {
            localMacAddress = "";
        }
        sb.append("&");
        sb.append("mac");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(localMacAddress));
        java.lang.String str = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getStartPlatform().pfStr() + "_" + com.tencent.ysdk.framework.common.ePlatform.Guest.pfStr();
        com.tencent.ysdk.shell.libware.file.Logger.d("final platform:" + str);
        sb.append("&");
        sb.append("platform");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(str));
        java.lang.String str2 = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_ANTIADDICTION_SWITCH, false) ? "1" : "0";
        sb.append("&");
        sb.append(PARAM_HOPE_SWITCH);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(str2));
        sb.append("&");
        sb.append(PARAM_VISITOR_SWITCH);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(this.mVisitorSwitch)));
        try {
            java.lang.String baseParams = getBaseParams(com.tencent.ysdk.framework.common.ePlatform.Guest, this.mOpenId);
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
        com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse guestUserLoginResponse = new com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse();
        guestUserLoginResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(guestUserLoginResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse guestUserLoginResponse = new com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse();
        guestUserLoginResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(guestUserLoginResponse);
        }
    }

    public void setVisitorSwitch(int i) {
        this.mVisitorSwitch = i;
    }
}
