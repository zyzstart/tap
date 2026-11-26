package com.tencent.ysdk.shell.module.user.impl.wx.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserScanForLoginCodeRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_NONCESTR = "noncestr";
    private static final java.lang.String PARAM_OPEN_APPID = "openappid";
    private static final java.lang.String PARAM_SCOPE = "scope";
    private static final java.lang.String PARAM_TIME_STAMP = "timestamp";
    private static final java.lang.String PARAM_WX_APPID = "appid";
    private static final java.lang.String PATH = "/auth/wx_scan_code_login";
    java.lang.String appid;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse> mResponseHandler;
    java.lang.String noncestr;
    java.lang.String openappid;
    java.lang.String scope;
    java.lang.String timestamp;

    public WXUserScanForLoginCodeRequest(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse> httpResponseHandler) {
        super(PATH);
        this.appid = str;
        this.openappid = str2;
        this.scope = str3;
        this.noncestr = str4;
        this.timestamp = str5;
        this.mResponseHandler = httpResponseHandler;
        this.reportIMEI = true;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        try {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
            sb.append(PARAM_OPEN_APPID);
            sb.append("=");
            sb.append(this.openappid);
            sb.append("&");
            sb.append("scope");
            sb.append("=");
            sb.append(java.net.URLEncoder.encode(this.scope, "UTF-8"));
            sb.append("&");
            sb.append(PARAM_NONCESTR);
            sb.append("=");
            sb.append(this.noncestr);
            com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
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
        com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse wXUserScanForloginResponse = new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse();
        wXUserScanForloginResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(wXUserScanForloginResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse wXUserScanForloginResponse = new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse();
        wXUserScanForloginResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserScanForloginResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(wXUserScanForloginResponse);
        }
    }
}
