package com.tencent.ysdk.shell.module.cloud.newconfig.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PullNewConfigRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_OPEN_APPID = "openappid";
    private static final java.lang.String PATH = "/conf/get_conf";
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse> mHandler;

    public PullNewConfigRequest(com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse> httpResponseHandler) {
        super(PATH);
        this.mHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            java.lang.String qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
            sb.append(PARAM_OPEN_APPID);
            sb.append("=");
            sb.append(qQAppId);
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
            sb.append(getBaseParams(com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform), loginRecord.open_id));
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
        }
        return getBaseUrl() + com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START + sb.toString();
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse pullNewConfigResponse = new com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse();
        pullNewConfigResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse> httpResponseHandler = this.mHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(pullNewConfigResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse pullNewConfigResponse = new com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse();
        pullNewConfigResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.cloud.newconfig.request.PullNewConfigResponse> httpResponseHandler = this.mHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(pullNewConfigResponse);
        }
    }
}
