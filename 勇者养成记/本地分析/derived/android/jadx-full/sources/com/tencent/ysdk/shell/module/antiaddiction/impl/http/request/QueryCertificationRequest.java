package com.tencent.ysdk.shell.module.antiaddiction.impl.http.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QueryCertificationRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_ACCESS_TOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_LOGIN_TYPE = "loginType";
    private static final java.lang.String PATH = "/hope/queryCertification";
    private java.lang.String mAccessToken;
    private int mLoginPlatform;
    private int mLoginType;
    private java.lang.String mOpenId;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse> mResponseHandler;

    public QueryCertificationRequest(int i, int i2, java.lang.String str, java.lang.String str2, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse> httpResponseHandler) {
        super(PATH);
        this.mLoginType = i;
        this.mLoginPlatform = i2;
        this.mOpenId = str;
        this.mAccessToken = str2;
        this.mResponseHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("&");
        sb.append("atk");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mAccessToken));
        sb.append("&");
        sb.append("loginType");
        sb.append("=");
        sb.append(this.mLoginType);
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
            com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
        }
        try {
            java.lang.String baseParams = getBaseParams(com.tencent.ysdk.framework.common.ePlatform.getEnum(this.mLoginPlatform), this.mOpenId);
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(getBaseUrl());
            sb2.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
            sb.append(baseParams);
            sb2.append(sb.toString());
            return sb2.toString();
        } catch (java.lang.Exception unused) {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "获取URL通用参数异常");
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse queryCertificationResponse = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse();
        queryCertificationResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(queryCertificationResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse queryCertificationResponse = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse();
        queryCertificationResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(queryCertificationResponse);
        }
    }
}
