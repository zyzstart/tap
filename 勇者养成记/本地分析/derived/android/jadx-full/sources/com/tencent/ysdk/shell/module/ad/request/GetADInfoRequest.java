package com.tencent.ysdk.shell.module.ad.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetADInfoRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_OPEN_APPID = "openappid";
    private static final java.lang.String PATH = "/ad/getadinfo";
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse> mResponseHandler;

    public GetADInfoRequest(com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse> httpResponseHandler) {
        super(PATH);
        this.mResponseHandler = httpResponseHandler;
        this.reportIMEI = true;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.lang.String qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
        sb.append(PARAM_OPEN_APPID);
        sb.append("=");
        sb.append(qQAppId);
        try {
            sb.append(getBaseParams(com.tencent.ysdk.framework.common.ePlatform.None, "Null"));
            return getBaseUrl() + com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + sb.toString();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_DOCTOR", "获取URL通用参数异常");
            return "";
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse getADinfoResponse = new com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse();
        getADinfoResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getADinfoResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse getADinfoResponse = new com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse();
        getADinfoResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.ad.request.GetADinfoResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getADinfoResponse);
        }
    }
}
