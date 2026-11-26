package com.tencent.ysdk.shell.module.sandbox;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SandboxPayModule {
    public static final java.lang.String TAG = "sandbox_pay";
    private static com.tencent.ysdk.shell.module.pay.impl.PayModule.PayCallBack mPayCallback;
    private static com.tencent.ysdk.shell.module.sandbox.SandboxPayModule sInstance;

    private SandboxPayModule() {
    }

    private java.lang.String convertToJson(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGameRequest) {
            com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = (com.tencent.midas.api.request.APMidasGameRequest) aPMidasBaseRequest;
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("gameLogo", aPMidasGameRequest.gameLogo);
                jSONObject.put("offerId", aPMidasGameRequest.offerId);
                jSONObject.put("openId", aPMidasGameRequest.openId);
                jSONObject.put("openKey", aPMidasGameRequest.openKey);
                jSONObject.put("sessionId", aPMidasGameRequest.sessionId);
                jSONObject.put(com.tencent.pipe.IPipeInterface.KEY_SESSION_TYPE, aPMidasGameRequest.sessionType);
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_ZONEID, aPMidasGameRequest.zoneId);
                jSONObject.put("pf", aPMidasGameRequest.pf);
                jSONObject.put(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse.PARAM_PK_KEY, aPMidasGameRequest.pfKey);
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_SAVE_VALUE, aPMidasGameRequest.saveValue);
                jSONObject.put("isCanChange", aPMidasGameRequest.isCanChange);
                jSONObject.put("resId", aPMidasGameRequest.resId);
                jSONObject.put("resData", android.util.Base64.encodeToString(aPMidasGameRequest.resData, 0));
                jSONObject.put("acctType", aPMidasGameRequest.acctType);
                jSONObject.put("reserv", aPMidasGameRequest.reserv);
                jSONObject.put("remark", aPMidasGameRequest.remark);
                jSONObject.put("mallType", aPMidasGameRequest.mallType);
                jSONObject.put("h5Url", aPMidasGameRequest.h5Url);
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                jSONObject2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_CHANNEL, aPMidasGameRequest.mpInfo.payChannel);
                jSONObject2.put("discountType", aPMidasGameRequest.mpInfo.discountType);
                jSONObject2.put("discountUrl", aPMidasGameRequest.mpInfo.discountUrl);
                jSONObject2.put("drmInfo", aPMidasGameRequest.mpInfo.drmInfo);
                jSONObject2.put("discoutId", aPMidasGameRequest.mpInfo.discoutId);
                jSONObject2.put("extras", aPMidasGameRequest.mpInfo.extras);
                jSONObject.put("mpInfo", jSONObject2);
                org.json.JSONObject jSONObject3 = new org.json.JSONObject();
                jSONObject3.put("unit", aPMidasGameRequest.extendInfo.unit);
                jSONObject3.put("isShowNum", aPMidasGameRequest.extendInfo.isShowNum);
                jSONObject3.put("isShowListOtherNum", aPMidasGameRequest.extendInfo.isShowListOtherNum);
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_TYPE, jSONObject3);
                return jSONObject.toString();
            } catch (org.json.JSONException e) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
                return "";
            }
        }
        com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = (com.tencent.midas.api.request.APMidasGoodsRequest) aPMidasBaseRequest;
        org.json.JSONObject jSONObject4 = new org.json.JSONObject();
        try {
            jSONObject4.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_TOKEN_TYPE, aPMidasGoodsRequest.tokenType);
            jSONObject4.put("[REDACTED]", aPMidasGoodsRequest.goodsTokenUrl);
            jSONObject4.put("prodcutId", aPMidasGoodsRequest.prodcutId);
            jSONObject4.put("developerPayload", aPMidasGoodsRequest.developerPayload);
            jSONObject4.put("mIsReceiptMode", aPMidasGoodsRequest.mIsReceiptMode);
            jSONObject4.put("gameLogo", aPMidasGoodsRequest.gameLogo);
            jSONObject4.put("offerId", aPMidasGoodsRequest.offerId);
            jSONObject4.put("openId", aPMidasGoodsRequest.openId);
            jSONObject4.put("openKey", aPMidasGoodsRequest.openKey);
            jSONObject4.put("sessionId", aPMidasGoodsRequest.sessionId);
            jSONObject4.put(com.tencent.pipe.IPipeInterface.KEY_SESSION_TYPE, aPMidasGoodsRequest.sessionType);
            jSONObject4.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_ZONEID, aPMidasGoodsRequest.zoneId);
            jSONObject4.put("pf", aPMidasGoodsRequest.pf);
            jSONObject4.put(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse.PARAM_PK_KEY, aPMidasGoodsRequest.pfKey);
            jSONObject4.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_SAVE_VALUE, aPMidasGoodsRequest.saveValue);
            jSONObject4.put("isCanChange", aPMidasGoodsRequest.isCanChange);
            jSONObject4.put("resId", aPMidasGoodsRequest.resId);
            jSONObject4.put("resData", aPMidasGoodsRequest.resData);
            jSONObject4.put("acctType", aPMidasGoodsRequest.acctType);
            jSONObject4.put("reserv", aPMidasGoodsRequest.reserv);
            jSONObject4.put("remark", aPMidasGoodsRequest.remark);
            jSONObject4.put("mallType", aPMidasGoodsRequest.mallType);
            jSONObject4.put("h5Url", aPMidasGoodsRequest.h5Url);
            org.json.JSONObject jSONObject5 = new org.json.JSONObject();
            jSONObject5.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_CHANNEL, aPMidasGoodsRequest.mpInfo.payChannel);
            jSONObject5.put("discountType", aPMidasGoodsRequest.mpInfo.discountType);
            jSONObject5.put("discountUrl", aPMidasGoodsRequest.mpInfo.discountUrl);
            jSONObject5.put("drmInfo", aPMidasGoodsRequest.mpInfo.drmInfo);
            jSONObject5.put("discoutId", aPMidasGoodsRequest.mpInfo.discoutId);
            jSONObject5.put("extras", aPMidasGoodsRequest.mpInfo.extras);
            jSONObject4.put("mpInfo", jSONObject5);
            org.json.JSONObject jSONObject6 = new org.json.JSONObject();
            jSONObject6.put("unit", aPMidasGoodsRequest.extendInfo.unit);
            jSONObject6.put("isShowNum", aPMidasGoodsRequest.extendInfo.isShowNum);
            jSONObject6.put("isShowListOtherNum", aPMidasGoodsRequest.extendInfo.isShowListOtherNum);
            jSONObject4.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_TYPE, jSONObject6);
            return jSONObject4.toString();
        } catch (org.json.JSONException e2) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e2);
            return "";
        }
    }

    public static com.tencent.ysdk.shell.module.sandbox.SandboxPayModule getInstance() {
        if (sInstance == null) {
            sInstance = new com.tencent.ysdk.shell.module.sandbox.SandboxPayModule();
        }
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendPayInfo(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, boolean z, com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse payInfoEncodeResponse) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "PayInfoEncodeResponse == " + payInfoEncodeResponse.toString());
        if (payInfoEncodeResponse.isRequestSuccess()) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "sandbox pay decode request failed,please check your param");
            return;
        }
        if (android.text.TextUtils.isEmpty(payInfoEncodeResponse.mData)) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "payinfo encode response is null,dose encode request failed ?");
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "payinfo encode success, send to yyb");
        java.util.HashMap map = new java.util.HashMap();
        map.put(com.tencent.pipe.IPipeInterface.KEY_REQUEST, payInfoEncodeResponse.mData);
        map.put(com.tencent.pipe.IPipeInterface.KEY_NEED_LOGIN_INFO, java.lang.String.valueOf(z));
        map.put("openid", aPMidasBaseRequest.openId);
        map.put("appid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId());
        map.put("offerid", aPMidasBaseRequest.offerId);
        map.put(com.tencent.pipe.IPipeInterface.KEY_PAY_ID, com.tencent.ysdk.shell.libware.encrypt.MD5.toMD5(aPMidasBaseRequest.openId + aPMidasBaseRequest.offerId + java.lang.System.currentTimeMillis()));
        if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGameRequest) {
            com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender.getInstance().sendIPCEvent(256, map);
        } else if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGoodsRequest) {
            com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender.getInstance().sendIPCEvent(4096, map);
        }
    }

    public void launchRemotePay(final com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.ysdk.shell.module.pay.impl.PayModule.PayCallBack payCallBack) {
        mPayCallback = payCallBack;
        java.lang.String offerId = com.tencent.ysdk.shell.module.sandbox.SandboxConfig.getOfferId();
        if (android.text.TextUtils.isEmpty(offerId)) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "guest pay failed, offerId == null");
            return;
        }
        final boolean z = false;
        if (com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginPlatform() == com.tencent.ysdk.framework.common.ePlatform.Guest) {
            aPMidasBaseRequest.offerId = offerId;
        } else if (com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginPlatform() == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            aPMidasBaseRequest.pfKey = com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getLoginRecord().pf_key;
            aPMidasBaseRequest.pf = com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getLoginRecord().pf;
            aPMidasBaseRequest.offerId = offerId;
            aPMidasBaseRequest.sessionType = com.tencent.ysdk.shell.module.sandbox.SandboxConfig.getSessionType();
            aPMidasBaseRequest.sessionId = com.tencent.ysdk.shell.module.sandbox.SandboxConfig.getSessionId();
            z = true;
        }
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeRequest(convertToJson(aPMidasBaseRequest), new com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse>() { // from class: com.tencent.ysdk.shell.module.sandbox.SandboxPayModule.1
            @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
            public void onResponse(com.tencent.ysdk.shell.module.sandbox.business.PayInfoEncodeResponse payInfoEncodeResponse) {
                com.tencent.ysdk.shell.module.sandbox.SandboxPayModule.this.sendPayInfo(aPMidasBaseRequest, z, payInfoEncodeResponse);
            }
        }));
    }

    public void sendPayCallback(java.util.Map map) {
        java.lang.String str = (java.lang.String) map.get(com.tencent.pipe.IPipeInterface.KEY_CALLBACK_CMD);
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, "cmd is null ,please check your params");
            return;
        }
        if (com.tencent.pipe.IPipeInterface.CMD_MIDASPAYNEEDLOGIN.equals(str)) {
            mPayCallback.MidasPayNeedLogin();
            return;
        }
        if (com.tencent.pipe.IPipeInterface.CMD_MIDASPAYCALLBACK.equals(str)) {
            try {
                java.lang.String str2 = (java.lang.String) map.get("APMidasResponse");
                com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
                org.json.JSONObject jSONObject = new org.json.JSONObject(str2);
                aPMidasResponse.setResultCode(jSONObject.optInt("resultCode"));
                aPMidasResponse.setResultInerCode(jSONObject.optInt("resultInerCode"));
                aPMidasResponse.setRealSaveNum(jSONObject.optInt("realSaveNum"));
                aPMidasResponse.setPayChannel(jSONObject.optInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_CHANNEL));
                aPMidasResponse.setPayState(jSONObject.optInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_STATE));
                aPMidasResponse.setProvideState(jSONObject.optInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_PROVIDE_STATE));
                aPMidasResponse.setResultMsg(jSONObject.optString("resultMsg"));
                aPMidasResponse.setExtendInfo(jSONObject.optString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_TYPE));
                aPMidasResponse.setPayReserve1(jSONObject.optString("payReserve1"));
                aPMidasResponse.setPayReserve2(jSONObject.optString("payReserve2"));
                aPMidasResponse.setPayReserve3(jSONObject.optString("payReserve3"));
                org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("mAPPurchase");
                com.tencent.midas.api.request.APPurchase aPPurchase = new com.tencent.midas.api.request.APPurchase();
                aPPurchase.mSku = jSONObject2.optString("mSku");
                aPPurchase.mOriginalJson = jSONObject2.optString("mOriginalJson");
                aPPurchase.mSignature = jSONObject2.optString("mSignature");
                aPMidasResponse.setReceipt(aPPurchase);
                mPayCallback.MidasPayCallBack(aPMidasResponse);
            } catch (org.json.JSONException e) {
                com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
            }
        }
    }
}
