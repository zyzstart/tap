package com.tencent.ysdk.shell.module.antiaddiction.impl.http.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ReportExecuteRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_EXEC_TIME = "execTime";
    private static final java.lang.String PARAM_INSTR_TRACEID = "instrTraceId";
    private static final java.lang.String PARAM_RULE_NAME = "ruleName";
    private static final java.lang.String PATH = "/hope/reportExecute";
    private com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.ReportExecuteRequestParam mRequestParam;

    public ReportExecuteRequest(com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.ReportExecuteRequestParam reportExecuteRequestParam) {
        super(PATH);
        this.mRequestParam = reportExecuteRequestParam;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
        sb.append(PARAM_RULE_NAME);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRequestParam.ruleName));
        sb.append("&");
        sb.append(PARAM_INSTR_TRACEID);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mRequestParam.instrTraceId));
        sb.append("&");
        sb.append(PARAM_EXEC_TIME);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(java.lang.String.valueOf(this.mRequestParam.execTime)));
        try {
            java.lang.String baseParams = getBaseParams(this.mRequestParam.platform, this.mRequestParam.openId);
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
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
    }
}
