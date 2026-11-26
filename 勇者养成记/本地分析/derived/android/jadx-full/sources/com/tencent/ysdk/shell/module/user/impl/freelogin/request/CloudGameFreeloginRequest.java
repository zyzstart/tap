package com.tencent.ysdk.shell.module.user.impl.freelogin.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CloudGameFreeloginRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String CMD_CLOUD_LOGIN = "CloudCheckLogin";
    private java.lang.String mLoginInfo;
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse> mRspHandler;

    public CloudGameFreeloginRequest(java.lang.String str, com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse> httpResponseHandler) {
        super("");
        if (android.text.TextUtils.isEmpty(str)) {
            this.mLoginInfo = str;
        } else {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                jSONObject.put("hostAppid", java.lang.String.valueOf(jSONObject.opt("hostAppid")));
                jSONObject.put("hostUserID", java.lang.String.valueOf(jSONObject.opt("hostUserID")));
                jSONObject.put("imei", com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei());
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, com.tencent.ysdk.api.YSDKApi.getChannelId());
                jSONObject.put("regchannel", com.tencent.ysdk.api.YSDKApi.getRegisterChannelId());
                jSONObject.put("platform", com.tencent.ysdk.shell.module.user.UserApi.getInstance().getStartPlatform().pfStr() + "_" + com.tencent.ysdk.framework.common.ePlatform.QQ.pfStr());
                jSONObject.put(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, com.tencent.ysdk.api.YSDKApi.getVersion());
                jSONObject.put("openappid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
                jSONObject.put("offerid", com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getOfferId());
                this.mLoginInfo = jSONObject.toString();
            } catch (org.json.JSONException e) {
                com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet freeLoginRet = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet();
                freeLoginRet.ret = -1;
                freeLoginRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.FREE_LOGIN_JSON_PARSE_ERROR;
                freeLoginRet.msg = "request exception:" + e.toString() + ", loginInfo:" + str;
                com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.reportFreeLoginEvent(freeLoginRet, java.lang.System.currentTimeMillis() / 1000);
                this.mLoginInfo = str;
                com.tencent.ysdk.shell.libware.file.Logger.e("sandbox", e);
            }
        }
        this.data = com.tencent.ysdk.shell.libware.util.YSDKTextUtils.getBytesUTF8(this.mLoginInfo);
        this.mRspHandler = httpResponseHandler;
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        return com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameRequestHelper.genReqUrl(CMD_CLOUD_LOGIN);
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse cloudGameFreeloginResponse = new com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse();
        cloudGameFreeloginResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse> httpResponseHandler = this.mRspHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(cloudGameFreeloginResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse cloudGameFreeloginResponse = new com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse();
        cloudGameFreeloginResponse.parseSuccessResponse(i, safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse> httpResponseHandler = this.mRspHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(cloudGameFreeloginResponse);
        }
    }
}
