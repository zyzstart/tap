package com.tencent.ysdk.shell.module.cloud.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PullConfigRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_APN = "apn";
    private static final java.lang.String PARAM_APPID = "appid";
    private static final java.lang.String PARAM_APP_VERSION_CODE = "appVersionCode";
    private static final java.lang.String PARAM_APP_VERSION_NAME = "appVersionName";
    private static final java.lang.String PARAM_CHANNEL = "channel";
    private static final java.lang.String PARAM_OPENID = "openid";
    private static final java.lang.String PARAM_OS = "os";
    private static final java.lang.String PARAM_OS_VERSION = "osVersion";
    private static final java.lang.String PARAM_PLATFORM = "platform";
    private static final java.lang.String PARAM_PRODUCT_MODULE = "productModel";
    private static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_SCENE = "scene";
    private static final java.lang.String PARAM_SDK_VERSION = "sdkVersion";
    private static final java.lang.String PARAM_SO_MD5 = "soMd5";
    private static final java.lang.String PATH = "/conf/get_ysdk_update_conf";
    private com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequestPara mPullConfigRequestPara;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse> mResponseHandler;

    public PullConfigRequest(com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigRequestPara pullConfigRequestPara, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse> httpResponseHandler) {
        super(PATH);
        this.mPullConfigRequestPara = null;
        this.mPullConfigRequestPara = pullConfigRequestPara;
        this.mResponseHandler = httpResponseHandler;
    }

    private void appendParamsIfNotNull(java.lang.StringBuilder sb, java.lang.String str, java.lang.String str2) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        sb.append("&");
        sb.append(str2);
        sb.append("=");
        sb.append(str);
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        sb.append("appid");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mPullConfigRequestPara.appid));
        sb.append("&");
        sb.append("scene");
        sb.append("=");
        sb.append(java.lang.String.valueOf(this.mPullConfigRequestPara.scene));
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.soMd5, PARAM_SO_MD5);
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.productModel, PARAM_PRODUCT_MODULE);
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.os, PARAM_OS);
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.osVersion, PARAM_OS_VERSION);
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.sdkVersion, PARAM_SDK_VERSION);
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.appVersionName, "appVersionName");
        if (this.mPullConfigRequestPara.appVersionCode > 0) {
            sb.append("&");
            sb.append("appVersionCode");
            sb.append("=");
            sb.append(this.mPullConfigRequestPara.appVersionCode);
        }
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.apn, "apn");
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.openid, "openid");
        if (this.mPullConfigRequestPara.platform > 0) {
            sb.append("&");
            sb.append("platform");
            sb.append("=");
            sb.append(this.mPullConfigRequestPara.platform);
        }
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.channel, "channel");
        appendParamsIfNotNull(sb, this.mPullConfigRequestPara.regChannel, "regChannel");
        com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
        try {
            sb.append(getBaseParams(com.tencent.ysdk.framework.common.ePlatform.getEnum(this.mPullConfigRequestPara.platform), this.mPullConfigRequestPara.openid));
            return getBaseUrl() + sb.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "获取URL通用参数异常");
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse pullConfigResponse = new com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse();
        pullConfigResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(pullConfigResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse pullConfigResponse = new com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse();
        pullConfigResponse.parseSuccessResponse(i, safeJSONObject);
        android.util.Log.d("YSDK", "request conf: /conf/get_ysdk_update_conf");
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.impl.request.PullConfigResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(pullConfigResponse);
        }
    }
}
