package com.tencent.ysdk.shell.module.antiaddiction.impl.http.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class JudgeTimingRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_CONTEXT = "context";
    private static final java.lang.String PARAM_DURATION = "duration";
    private static final java.lang.String PARAM_FACT_TYPE = "factType";
    private static final java.lang.String PARAM_VISITOR_SWITCH = "visitor_switch";
    private static final java.lang.String PATH = "/hope/judgeTiming";
    private com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam mRequestParam;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse> mResponseHandler;

    public JudgeTimingRequest(@androidx.annotation.NonNull com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam judgeTimingRequestParam, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse> httpResponseHandler) {
        super(PATH);
        this.mRequestParam = judgeTimingRequestParam;
        this.mResponseHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        sb.append(PARAM_CONTEXT);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRequestParam.context));
        sb.append("&");
        sb.append(PARAM_FACT_TYPE);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(this.mRequestParam.factType)));
        sb.append("&");
        sb.append(PARAM_DURATION);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(this.mRequestParam.duration)));
        sb.append("&");
        sb.append(PARAM_VISITOR_SWITCH);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(this.mRequestParam.visitorSwitch)));
        try {
            java.lang.String baseParams = getBaseParams(this.mRequestParam.platform, this.mRequestParam.openId);
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
        com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse judgeTimingResponse = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse();
        judgeTimingResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(judgeTimingResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse judgeTimingResponse = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse();
        judgeTimingResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(judgeTimingResponse);
        }
    }
}
