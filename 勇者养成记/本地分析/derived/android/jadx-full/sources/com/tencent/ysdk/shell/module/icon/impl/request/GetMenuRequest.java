package com.tencent.ysdk.shell.module.icon.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetMenuRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_ACCESSTOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_CMD = "cmd";
    private static final java.lang.String PARAM_CMD_VALUE = "get_menu";
    private static final java.lang.String PARAM_ICON_MENU_TAG = "menu_tag";
    private static final java.lang.String PARAM_ICON_OPENAPPID = "openappid";
    private static final java.lang.String PARAM_ICON_VERSION = "icon_version";
    private static final java.lang.String PARAM_PACKAGE_NAME = "pkg_name";
    private static final java.lang.String PARAM_TEMP_PLATFORM = "pf";
    private static final java.lang.String PATH = "/icon/myapp_game_assist_menu";
    private java.lang.String mAccessToken;
    private java.lang.String mMenuTag;
    private java.lang.String mOpenId;
    private com.tencent.ysdk.framework.common.ePlatform mPlatform;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse> mResponseHandler;

    public GetMenuRequest(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse> httpResponseHandler) {
        super(PATH);
        this.mPlatform = eplatform;
        this.mOpenId = str;
        this.mAccessToken = str2;
        this.mMenuTag = str3;
        this.mResponseHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(PARAM_CMD);
        sb.append("=");
        sb.append(PARAM_CMD_VALUE);
        sb.append("&");
        sb.append(PARAM_PACKAGE_NAME);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getPackageName()));
        sb.append("&");
        sb.append("[REDACTED]");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mAccessToken));
        sb.append("&");
        sb.append(PARAM_ICON_VERSION);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance().getIconVersion());
        sb.append("&");
        sb.append(PARAM_ICON_MENU_TAG);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mMenuTag));
        sb.append("&");
        sb.append(PARAM_ICON_OPENAPPID);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
        sb.append("&");
        sb.append("pf");
        sb.append("=");
        sb.append(this.mPlatform.val());
        com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
        try {
            sb.append(getBaseParams(this.mPlatform, this.mOpenId));
            return getBaseUrl() + com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + sb.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "获取URL通用参数异常");
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse getMenuResponse = new com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse();
        getMenuResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getMenuResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse getMenuResponse = new com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse();
        getMenuResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getMenuResponse);
        }
    }
}
