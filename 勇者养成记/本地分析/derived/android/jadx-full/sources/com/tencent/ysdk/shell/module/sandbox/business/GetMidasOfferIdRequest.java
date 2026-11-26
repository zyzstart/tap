package com.tencent.ysdk.shell.module.sandbox.business;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GetMidasOfferIdRequest extends com.tencent.ysdk.shell.framework.request.HttpRequest {
    private static final java.lang.String CMD_OFFER_ID = "GetMidasOfferid";
    private static final java.lang.String TAG = "sandbox_pay";
    private com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse> mHandler;

    public GetMidasOfferIdRequest(com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse> httpResponseHandler) {
        super("GetMidasOfferIdRequest");
        this.mHandler = httpResponseHandler;
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put("qimei", com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei());
            jSONObject.put("appid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
            jSONObject.put("openid", com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().open_id);
            if (com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginPlatform() == com.tencent.ysdk.framework.common.ePlatform.Guest) {
                jSONObject.put("[REDACTED]", com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi.getInstance().getLoginRecord().getPayToken());
            } else if (com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginPlatform() == com.tencent.ysdk.framework.common.ePlatform.QQ) {
                jSONObject.put("[REDACTED]", com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getToken());
            }
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox_pay", e);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("sandbox_pay", "GetMidasOfferIdRequest: " + jSONObject.toString());
        this.data = com.tencent.ysdk.shell.libware.util.YSDKTextUtils.getBytesUTF8(jSONObject.toString());
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected java.lang.String getUrl() {
        return com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameRequestHelper.genReqUrl(CMD_OFFER_ID);
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestFailure(int i, java.lang.String str) {
        com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse getMidasOfferIdResponse = new com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse();
        getMidasOfferIdResponse.parseFailureResponse(i, str);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse> httpResponseHandler = this.mHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getMidasOfferIdResponse);
        }
    }

    @Override // com.tencent.ysdk.shell.framework.request.HttpRequest
    protected void onRequestSuccess(int i, com.tencent.ysdk.shell.libware.util.SafeJSONObject safeJSONObject) {
        com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse getMidasOfferIdResponse = new com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse();
        getMidasOfferIdResponse.parseJson(safeJSONObject);
        com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.GetMidasOfferIdResponse> httpResponseHandler = this.mHandler;
        if (httpResponseHandler != null) {
            httpResponseHandler.onResponse(getMidasOfferIdResponse);
        }
    }
}
