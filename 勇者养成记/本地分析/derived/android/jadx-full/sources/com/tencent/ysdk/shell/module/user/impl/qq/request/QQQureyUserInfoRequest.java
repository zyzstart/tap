package com.tencent.ysdk.shell.module.user.impl.qq.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQQureyUserInfoRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_ACCESSTOKEN = "[REDACTED]";
    private static final java.lang.String PATH = "/relation/qq_userinfo";
    private java.lang.String mAccessToken;
    private java.lang.String mOpenId;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse> mResponseHandler;

    public QQQureyUserInfoRequest(java.lang.String str, java.lang.String str2, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse> httpResponseHandler) {
        super(PATH);
        this.mOpenId = str;
        this.mAccessToken = str2;
        this.mResponseHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        try {
            return getBaseUrl() + com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + PARAM_ACCESSTOKEN + "[REDACTED]" + com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mAccessToken) + getBaseParams(com.tencent.ysdk.framework.common.ePlatform.QQ, this.mOpenId);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "获取URL通用参数异常");
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse qQQueryUserInfoResponse = new com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse(this.mOpenId);
        qQQueryUserInfoResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(qQQueryUserInfoResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse qQQueryUserInfoResponse = new com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse(this.mOpenId);
        qQQueryUserInfoResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(qQQueryUserInfoResponse);
        }
    }
}
