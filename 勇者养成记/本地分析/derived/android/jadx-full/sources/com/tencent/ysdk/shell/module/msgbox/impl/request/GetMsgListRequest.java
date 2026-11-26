package com.tencent.ysdk.shell.module.msgbox.impl.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetMsgListRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String PARAM_ACCESSTOKEN = "[REDACTED]";
    private static final java.lang.String PARAM_APPID_QQ = "openappid";
    private static final java.lang.String PARAM_CHANNEL = "channel";
    private static final java.lang.String PARAM_IS_VISITOR = "is_visitor";
    private static final java.lang.String PARAM_MSG_LIST = "msg_list";
    private static final java.lang.String PARAM_OFFERID = "offerid";
    private static final java.lang.String PARAM_PAY_ERRORCODE = "pay_errcode";
    private static final java.lang.String PARAM_REG_CHANNEL = "regChannel";
    private static final java.lang.String PARAM_SCENE = "scene";
    private static final java.lang.String PATH = "/msg/msg_push";
    private java.lang.String mAccessToken;
    private boolean mIsVisitor;
    private java.lang.String mMsgList;
    private java.lang.String mOpenId;
    private java.lang.String mPayErrorCode;
    private com.tencent.ysdk.framework.common.ePlatform mPlatform;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse> mResponseHandler;
    private java.lang.String mScene;

    public enum SCENE {
        login,
        afterpay,
        afterpayFailed
    }

    public GetMsgListRequest(com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListRequest.SCENE scene, com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse> httpResponseHandler) {
        super(PATH);
        this.mMsgList = str3;
        this.mPlatform = eplatform;
        this.mOpenId = str;
        this.mAccessToken = str2;
        this.mResponseHandler = httpResponseHandler;
        this.mScene = scene.name();
        this.mIsVisitor = com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState();
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("[REDACTED]");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mAccessToken));
        sb.append("&");
        sb.append(PARAM_MSG_LIST);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mMsgList));
        sb.append("&");
        sb.append(PARAM_APPID_QQ);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
        sb.append("&");
        sb.append("regChannel");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.module.user.UserApi.getInstance().getRegisterChannelId()));
        sb.append("&");
        sb.append("channel");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId()));
        sb.append("&");
        sb.append("offerid");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId()));
        sb.append("&");
        sb.append("offerid");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId()));
        sb.append("&");
        sb.append("scene");
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mScene));
        sb.append("&");
        sb.append(PARAM_IS_VISITOR);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mIsVisitor ? "1" : "0"));
        sb.append("&");
        sb.append(PARAM_PAY_ERRORCODE);
        sb.append("=");
        sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.getUrlEncodeValue(this.mPayErrorCode));
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
        com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse getMsgListResponse = new com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse();
        getMsgListResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getMsgListResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.libware.file.Logger.d("MSG_PUSH", safeJSONObject.toString());
        com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse getMsgListResponse = new com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse();
        getMsgListResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.msgbox.impl.request.GetMsgListResponse> httpResponseHandler = this.mResponseHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getMsgListResponse);
        }
    }

    public void setPayErrorCode(java.lang.String str) {
        this.mPayErrorCode = str;
    }
}
