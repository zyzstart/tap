package com.tencent.ysdk.shell.module.realName.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RegisterRealNameRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_ACCESS_TOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_CERT_ID = "cert_id";
    private static final java.lang.String PARAM_CERT_TYPE = "cert_type";
    private static final java.lang.String PARAM_REAL_NAME = "real_name";
    private static final java.lang.String PATH = "/auth/ysdk_set_realname";
    private com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara mRegisterRealNameRequestPara;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse> mResponseHandler;

    public RegisterRealNameRequest(com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara registerRealNameRequestPara, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse> httpResponseHandler) {
        super(PATH);
        this.mRegisterRealNameRequestPara = null;
        this.mRegisterRealNameRequestPara = registerRealNameRequestPara;
        this.mResponseHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        sb.append("atk");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRegisterRealNameRequestPara.access_token));
        sb.append("&");
        sb.append(PARAM_REAL_NAME);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRegisterRealNameRequestPara.real_name));
        sb.append("&");
        sb.append(PARAM_CERT_ID);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRegisterRealNameRequestPara.cert_id));
        sb.append("&");
        sb.append(PARAM_CERT_TYPE);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRegisterRealNameRequestPara.cert_type));
        try {
            java.lang.String baseParams = getBaseParams(this.mRegisterRealNameRequestPara.platform, this.mRegisterRealNameRequestPara.open_id);
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
        com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse registerRealNameResponse = new com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse();
        registerRealNameResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(registerRealNameResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse registerRealNameResponse = new com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse();
        registerRealNameResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(registerRealNameResponse);
        }
    }
}
