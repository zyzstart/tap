package com.tencent.midas.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APWebJSBridgeActivity extends android.app.Activity {
    private static final java.lang.String KEY_REQUEST = "key_request";
    private static final java.lang.String KEY_TYPE = "key_pure_h5_pay";
    private static final java.lang.String TAG = "APWebJSBridgeActivity";
    private static final java.lang.String VALUE_PURE_H5 = "value_pure_h5_pay";
    private static final java.lang.String WEB_URL_POST = "/index.html";
    private static final java.lang.String WEB_URL_PRE = "http://youxi.vip.qq.com/m/act/";
    private com.tencent.midas.jsbridge.IAPWebPage webPage = null;

    private java.lang.String constructUrl() {
        java.lang.String discountUrl;
        java.lang.StringBuilder sb;
        java.lang.String str;
        if (android.text.TextUtils.isEmpty(com.tencent.midas.data.APPluginDataInterface.singleton().getDiscountUrl())) {
            discountUrl = WEB_URL_PRE + com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId() + WEB_URL_POST;
            this.webPage.initHead(this, com.pay.tool.APMidasTools.getUrlParamsValue(discountUrl, com.tencent.midas.jsbridge.APWebProtocol.URL_KEY_HEAD_CONTROL), com.pay.tool.APMidasTools.getUrlParamsValue(discountUrl, com.tencent.midas.jsbridge.APWebProtocol.URL_KEY_HEAD_TITLE));
            this.webPage.updateWebViewSize(discountUrl);
        } else {
            discountUrl = com.tencent.midas.data.APPluginDataInterface.singleton().getDiscountUrl();
            this.webPage.initHead(this, com.pay.tool.APMidasTools.getUrlParamsValue(discountUrl, com.tencent.midas.jsbridge.APWebProtocol.URL_KEY_HEAD_CONTROL), com.pay.tool.APMidasTools.getUrlParamsValue(discountUrl, com.tencent.midas.jsbridge.APWebProtocol.URL_KEY_HEAD_TITLE));
            this.webPage.updateWebViewSize(com.tencent.midas.data.APPluginDataInterface.singleton().getDiscountUrl());
        }
        com.tencent.midas.comm.APLog.e("constructUrl", discountUrl);
        java.util.HashMap map = new java.util.HashMap();
        map.put("offerId", com.tencent.midas.data.APPluginDataInterface.singleton().getOfferId());
        map.put("openId", com.tencent.midas.data.APPluginDataInterface.singleton().getOpenId());
        map.put("openKey", com.tencent.midas.data.APPluginDataInterface.singleton().getOpenKey());
        map.put("sessionId", com.tencent.midas.data.APPluginDataInterface.singleton().getSessionId());
        map.put(com.tencent.pipe.IPipeInterface.KEY_SESSION_TYPE, com.tencent.midas.data.APPluginDataInterface.singleton().getSessionType());
        map.put("pf", com.tencent.midas.data.APPluginDataInterface.singleton().getPf());
        map.put(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse.PARAM_PK_KEY, com.tencent.midas.data.APPluginDataInterface.singleton().getPfKey());
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_ZONEID, com.tencent.midas.data.APPluginDataInterface.singleton().getZoneId());
        if (discountUrl.contains(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START)) {
            if (!discountUrl.endsWith(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START)) {
                sb = new java.lang.StringBuilder();
                sb.append(discountUrl);
                str = "&";
            }
            java.lang.String str2 = discountUrl + com.pay.tool.APMidasTools.map2UrlParams(map);
            com.tencent.midas.comm.APLog.i("constructUrl", str2);
            return str2;
        }
        sb = new java.lang.StringBuilder();
        sb.append(discountUrl);
        str = com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START;
        sb.append(str);
        discountUrl = sb.toString();
        java.lang.String str3 = discountUrl + com.pay.tool.APMidasTools.map2UrlParams(map);
        com.tencent.midas.comm.APLog.i("constructUrl", str3);
        return str3;
    }

    private java.lang.String getPureH5PayURLParameters(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        java.util.HashMap map = new java.util.HashMap();
        map.put("m", "buy");
        map.put("_version", "v3");
        map.put("appid", aPMidasBaseRequest.offerId);
        map.put("pf", aPMidasBaseRequest.pf);
        map.put("n", aPMidasBaseRequest.saveValue);
        map.put("sessionid", aPMidasBaseRequest.sessionId);
        map.put("sessiontype", aPMidasBaseRequest.sessionType);
        map.put("openid", aPMidasBaseRequest.openId);
        map.put("openkey", aPMidasBaseRequest.openKey);
        map.put(com.tencent.open.SocialOperation.GAME_ZONE_ID, aPMidasBaseRequest.zoneId);
        map.put("sdktype", "android");
        java.lang.String midasCoreVersionName = com.tencent.midas.plugin.APPluginUtils.getMidasCoreVersionName(this);
        com.tencent.midas.comm.APLog.d(TAG, "app_version = " + midasCoreVersionName);
        map.put("appversion", midasCoreVersionName);
        map.put("request_from", "androidsdk");
        map.put("is_android_sdk_error_version", "1");
        map.put("android_sdk_reserve", aPMidasBaseRequest.reserv);
        map.put("android_sdk_mpinfo_discountType", aPMidasBaseRequest.mpInfo.discountType);
        map.put("android_sdk_mpinfo_discountUrl", aPMidasBaseRequest.mpInfo.discountUrl);
        map.put("android_sdk_mpinfo_discoutId", aPMidasBaseRequest.mpInfo.discoutId);
        map.put("android_sdk_mpinfo_drmInfo", aPMidasBaseRequest.mpInfo.drmInfo);
        map.put("android_sdk_mpinfo_extras", aPMidasBaseRequest.mpInfo.extras);
        map.put("android_sdk_mpinfo_payChannel", aPMidasBaseRequest.mpInfo.payChannel);
        map.put("android_sdk_extendInfo_unit", aPMidasBaseRequest.extendInfo.unit);
        map.put("android_sdk_extendInfo_isShowListOtherNum", java.lang.String.valueOf(aPMidasBaseRequest.extendInfo.isShowListOtherNum));
        map.put("android_sdk_extendInfo_isShowNum", java.lang.String.valueOf(aPMidasBaseRequest.extendInfo.isShowNum));
        if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGameRequest) {
            if ("[REDACTED]".equals(aPMidasBaseRequest.sessionId) && "[REDACTED]".equals(aPMidasBaseRequest.sessionType)) {
                str8 = "c";
                str9 = "wechat_game";
            } else if ("itopid".equals(aPMidasBaseRequest.sessionId)) {
                str8 = "c";
                str9 = "itop_game";
            } else {
                str8 = "c";
                str9 = "game";
            }
            map.put(str8, str9);
            if (!android.text.TextUtils.isEmpty(aPMidasBaseRequest.saveValue)) {
                str5 = "as";
                map.put(str5, "1");
            }
        } else {
            if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGoodsRequest) {
                com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = (com.tencent.midas.api.request.APMidasGoodsRequest) aPMidasBaseRequest;
                map.put("c", "goods");
                if (aPMidasGoodsRequest.tokenType == 1) {
                    str = aPMidasGoodsRequest.goodsTokenUrl;
                    str2 = "params";
                } else {
                    str = aPMidasGoodsRequest.prodcutId;
                    str2 = "productid";
                }
            } else if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasSubscribeRequest) {
                com.tencent.midas.api.request.APMidasSubscribeRequest aPMidasSubscribeRequest = (com.tencent.midas.api.request.APMidasSubscribeRequest) aPMidasBaseRequest;
                if ("uin".equals(aPMidasBaseRequest.sessionId) || "openid".equals(aPMidasBaseRequest.sessionId)) {
                    str3 = "c";
                    str4 = "qqsubscribe";
                } else {
                    str3 = "c";
                    str4 = "subscribe";
                }
                map.put(str3, str4);
                if (!android.text.TextUtils.isEmpty(aPMidasSubscribeRequest.productId)) {
                    map.put("as", "1");
                    map.put("productid", aPMidasSubscribeRequest.productId);
                }
                map.put(android.support.v4.app.NotificationCompat.CATEGORY_SERVICE, aPMidasSubscribeRequest.serviceCode);
                map.put("aid", aPMidasSubscribeRequest.remark);
                if (aPMidasSubscribeRequest.autoPay) {
                    str5 = "ap";
                    map.put(str5, "1");
                }
            } else if (aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasMonthRequest) {
                com.tencent.midas.api.request.APMidasMonthRequest aPMidasMonthRequest = (com.tencent.midas.api.request.APMidasMonthRequest) aPMidasBaseRequest;
                map.put("da", "1");
                map.put("c", aPMidasMonthRequest.serviceCode.toLowerCase());
                map.put("_newservice", "1");
                if (aPMidasMonthRequest.autoPay) {
                    map.put("ap", "1");
                }
                if (!android.text.TextUtils.isEmpty(aPMidasBaseRequest.saveValue)) {
                    map.put("as", "1");
                }
                str = aPMidasMonthRequest.remark;
                str2 = "aid";
            }
            map.put(str2, str);
        }
        java.lang.String str10 = com.tencent.midas.api.APMidasPayAPI.env;
        if (!com.tencent.midas.api.APMidasPayAPI.ENV_DEV.equals(str10)) {
            if (com.tencent.midas.api.APMidasPayAPI.ENV_TEST.equals(str10)) {
                str6 = "sandbox";
                str7 = "1";
            }
            return map2UrlParams(map);
        }
        str6 = "sandbox";
        str7 = "2";
        map.put(str6, str7);
        return map2UrlParams(map);
    }

    private void initUI() {
        this.webPage.initUI(this);
        this.webPage.loadUrl(constructUrl());
    }

    private void initWebPage() {
        com.tencent.midas.data.APPluginReportManager aPPluginReportManager;
        java.lang.String launchInterface;
        java.lang.String str;
        com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_INIT, "", "");
        if (com.tencent.midas.jsbridge.APX5.isX5Enabled(this)) {
            this.webPage = new com.tencent.midas.jsbridge.APX5WebPage();
            aPPluginReportManager = com.tencent.midas.data.APPluginReportManager.getInstance();
            launchInterface = com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface();
            str = com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_X5;
        } else {
            this.webPage = new com.tencent.midas.jsbridge.APSystemWebPage();
            aPPluginReportManager = com.tencent.midas.data.APPluginReportManager.getInstance();
            launchInterface = com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface();
            str = com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_WEBPAGE_SYSTEM;
        }
        aPPluginReportManager.insertData(launchInterface, str, "", "");
    }

    public static java.lang.String map2UrlParams(java.util.HashMap map) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        try {
            for (java.util.Map.Entry entry : map.entrySet()) {
                stringBuffer.append((java.lang.String) entry.getKey());
                stringBuffer.append("=");
                stringBuffer.append((java.lang.String) entry.getValue());
                stringBuffer.append("&");
            }
            if (!android.text.TextUtils.isEmpty(stringBuffer)) {
                stringBuffer.deleteCharAt(stringBuffer.length() - 1);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    private static boolean startPureH5Pay(android.content.Context context, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        if (context == null) {
            com.tencent.midas.comm.APLog.e(TAG, "Cannot start pure h5 pay with null context!");
            return false;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(context, com.tencent.midas.jsbridge.APWebJSBridgeActivity.class);
        intent.putExtra(KEY_TYPE, VALUE_PURE_H5);
        intent.putExtra(KEY_REQUEST, aPMidasBaseRequest);
        context.startActivity(intent);
        return true;
    }

    public static boolean startPureH5Pay(android.content.Context context, java.lang.String str, java.lang.String str2) {
        java.lang.String str3;
        java.lang.String str4;
        com.tencent.midas.comm.APLog.d(TAG, " Calling into startPureH5Pay caller = " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        com.tencent.midas.data.APPluginReportManager.getInstance().reportImmediatelyOneRecord(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_LAUNCH_PURE_H5_ERROR_REASON, "scene=" + str2 + "&reason=" + str);
        if (context == null) {
            str3 = TAG;
            str4 = "Cannot start pure h5 pay with null context!";
        } else {
            com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest = com.tencent.midas.control.APMidasPayHelper.requestObject;
            if (aPMidasBaseRequest == null) {
                str3 = TAG;
                str4 = "Cannot start pure h5 pay with null request object!";
            } else {
                android.app.Activity activity = com.tencent.midas.control.APMidasPayHelper.staticActivityContext;
                if (activity != null) {
                    com.tencent.midas.control.APMidasPayHelper.staticActivityContext = null;
                    return startPureH5Pay(activity, aPMidasBaseRequest);
                }
                str3 = TAG;
                str4 = "Cannot start pure h5 pay with null activity object!";
            }
        }
        com.tencent.midas.comm.APLog.e(str3, str4);
        return false;
    }

    private void toPureH5Pay(com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        this.webPage.toPureH5Pay(this, aPMidasBaseRequest);
        java.lang.String str = "https://pay.qq.com/h5/index.shtml" + getPureH5PayURLParameters(aPMidasBaseRequest);
        com.tencent.midas.comm.APLog.d(TAG, "To pure h5 pay full url = " + str);
        this.webPage.loadUrl(str);
    }

    @Override // android.app.Activity
    public void onCreate(android.os.Bundle bundle) throws java.lang.Throwable {
        super.onCreate(bundle);
        try {
            com.pay.tool.APMidasCommMethod.pushActivity(this);
            initWebPage();
            android.content.Intent intent = getIntent();
            if (intent == null || !VALUE_PURE_H5.equals(intent.getStringExtra(KEY_TYPE))) {
                initUI();
            } else {
                toPureH5Pay((com.tencent.midas.api.request.APMidasBaseRequest) intent.getSerializableExtra(KEY_REQUEST));
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            java.lang.String fullExceptionStacktrace = com.tencent.midas.plugin.APPluginUtils.getFullExceptionStacktrace(e);
            if (!android.text.TextUtils.isEmpty(fullExceptionStacktrace) && (fullExceptionStacktrace.contains("webview") || fullExceptionStacktrace.contains("Webview"))) {
                android.widget.Toast.makeText(this, "系统组件缺失，请退出重试", 0).show();
            }
            com.tencent.midas.plugin.APPluginUtils.callbackInMidasPluginWithoutCaringAboutNewProcess(this, 100, "返回");
            finish();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        if (i == 4) {
            com.tencent.midas.comm.APLog.d(TAG, "onKey down = back!");
            com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
            aPMidasResponse.resultCode = 100;
            aPMidasResponse.resultMsg = "返回";
            com.tencent.midas.control.APMidasPayHelper.midasCallBack(aPMidasResponse);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }
}
