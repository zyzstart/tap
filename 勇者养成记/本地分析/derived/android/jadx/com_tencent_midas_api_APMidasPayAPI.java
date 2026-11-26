package com.tencent.midas.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasPayAPI {
    public static final java.lang.String ACCOUNT_TYPE_COMMON = "common";
    public static final java.lang.String ACCOUNT_TYPE_SECURITY = "[REDACTED]";
    public static final java.lang.String ENV_DEV = "dev";
    public static final java.lang.String ENV_RELEASE = "release";
    public static final java.lang.String ENV_TEST = "test";
    public static final java.lang.String ENV_TESTING = "testing";
    public static final int LANDSCAPE = 0;
    public static final java.lang.String PAY_CHANNEL_BANK = "bank";
    public static final java.lang.String PAY_CHANNEL_QQWALLET = "qqwallet";
    public static final java.lang.String PAY_CHANNEL_WECHAT = "wechat";
    public static final int PORTRAINT = 1;
    private static final java.lang.String TAG = "APMidasPayAPI";
    public static final java.lang.String WX_COUPONS = "wechatAddCardToWXCardPackage";
    private static java.lang.String dataPath = "";
    public static java.lang.String env = "release";
    public static android.content.Context fromContext = null;
    private static boolean logEnable = true;
    private static int screenType = -1;

    public static void H5Release() {
        if (com.tencent.midas.control.APMidasPayHelper.x5Webview != null) {
            com.tencent.midas.control.APMidasPayHelper.x5Webview = null;
        }
        if (com.tencent.midas.control.APMidasPayHelper.webview != null) {
            com.tencent.midas.control.APMidasPayHelper.webview = null;
        }
        if (com.tencent.midas.control.APMidasPayHelper.sIWebView != null) {
            com.tencent.midas.control.APMidasPayHelper.sIWebView = null;
        }
    }

    public static void InnerH5PayInit(android.app.Activity activity, android.webkit.WebView webView) {
        com.tencent.midas.comm.APLog.i(TAG, "InnerH5PayInit enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper.MIDAS_WEBVIEW = com.tencent.midas.control.APMidasPayHelper.MIDAS_INNER_WEBVIEW;
            com.tencent.midas.control.APMidasPayHelper.h5Init(activity, webView, null);
        }
    }

    public static void InnerH5PayInitX5(android.app.Activity activity, com.tencent.smtt.sdk.WebView webView) {
        com.tencent.midas.comm.APLog.i(TAG, "InnerH5PayInit enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper.MIDAS_WEBVIEW = com.tencent.midas.control.APMidasPayHelper.MIDAS_INNER_WEBVIEW;
            com.tencent.midas.control.APMidasPayHelper.h5Init(activity, null, webView);
        }
    }

    private static boolean checkInitCommParam(android.content.Context context, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        if (!env.equals("release")) {
            try {
                if (com.pay.tool.APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay")) {
                    return true;
                }
                if (aPMidasBaseRequest == null) {
                    android.widget.Toast.makeText(context, "初始化request不能为空", 1).show();
                    return false;
                }
                if (android.text.TextUtils.isEmpty(aPMidasBaseRequest.offerId)) {
                    android.widget.Toast.makeText(context, "初始化offerid不能为空", 1).show();
                    return false;
                }
                if (android.text.TextUtils.isEmpty(aPMidasBaseRequest.openId)) {
                    android.widget.Toast.makeText(context, "初始化openId不能为空", 1).show();
                    return false;
                }
                if (android.text.TextUtils.isEmpty(aPMidasBaseRequest.openKey)) {
                    android.widget.Toast.makeText(context, "初始化openKey不能为空", 1).show();
                    return false;
                }
                if (android.text.TextUtils.isEmpty(aPMidasBaseRequest.sessionId)) {
                    android.widget.Toast.makeText(context, "初始化sessionId不能为空", 1).show();
                    return false;
                }
                if (android.text.TextUtils.isEmpty(aPMidasBaseRequest.sessionType)) {
                    android.widget.Toast.makeText(context, "初始化sessionType不能为空", 1).show();
                    return false;
                }
                if (android.text.TextUtils.isEmpty(aPMidasBaseRequest.pf)) {
                    android.widget.Toast.makeText(context, "初始化pf不能为空", 1).show();
                    return false;
                }
                if (android.text.TextUtils.isEmpty(aPMidasBaseRequest.pfKey)) {
                    android.widget.Toast.makeText(context, "初始化pfKey不能为空", 1).show();
                    return false;
                }
            } catch (java.lang.Exception unused) {
            }
        }
        return true;
    }

    private static boolean checkParams(android.content.Context context) {
        if (context != null) {
            return true;
        }
        com.tencent.midas.comm.APLog.e(TAG, "checkParams() context/activity == Null");
        new java.lang.Throwable("APMidasPayAPI().checkParams() context/activity == Null").printStackTrace();
        return false;
    }

    public static void closeAll() {
        com.tencent.midas.plugin.APPluginStatic.removeAll();
    }

    public static void consumeAsync(android.app.Activity activity, java.util.List list, com.tencent.midas.api.request.OnAPConsumeFinishedListener onAPConsumeFinishedListener) {
        java.lang.Class<?> cls;
        com.tencent.midas.comm.APLog.i(TAG, "consumeAsync enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
            java.lang.Class<?> cls2 = null;
            try {
                cls = java.lang.Class.forName(java.util.List.class.getName());
            } catch (java.lang.ClassNotFoundException e) {
                com.tencent.midas.comm.APLog.d(TAG, "consumeAsync setEnv e:" + e.toString());
                cls = null;
            }
            try {
                cls2 = java.lang.Class.forName("com.tencent.midas.api.request.OnAPConsumeFinishedListener");
            } catch (java.lang.ClassNotFoundException e2) {
                com.tencent.midas.comm.APLog.d(TAG, "consumeAsync OnAPConsumeFinishedListener e:" + e2.toString());
            }
            java.lang.Object objCall = aPMidasPayHelper.call(activity, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_XGAME_CONSUME, new java.lang.Object[]{list, onAPConsumeFinishedListener}, new java.lang.Class[]{cls, cls2});
            com.tencent.midas.comm.APLog.i(TAG, "consumeAsync ret " + objCall);
            if (objCall == null) {
                onAPConsumeFinishedListener.onConsumeFinished(new java.util.ArrayList());
            }
        }
    }

    public static void getInfo(android.app.Activity activity, java.lang.String str, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack) {
        com.tencent.midas.comm.APLog.i(TAG, "getInfo enter");
        if (checkParams(activity)) {
            try {
                fromContext = activity.getApplicationContext();
            } catch (java.lang.Exception e) {
                com.tencent.midas.comm.APLog.i("fromContext", e.toString());
            }
            com.tencent.midas.data.APPluginReportManager.payDataRelease();
            com.tencent.midas.data.APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_GETINFO);
            com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeData(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_GETINFO, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHINFO);
            com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
            com.tencent.midas.control.APMidasPayHelper.setEnv(env);
            com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
            aPMidasPayHelper.getInfo(activity, str, aPMidasBaseRequest, iAPMidasNetCallBack);
        }
    }

    public static java.lang.String getJSContent(android.content.Context context) {
        com.tencent.midas.comm.APLog.i(TAG, "getJSContent enter");
        return !checkParams(context) ? "" : com.tencent.midas.control.APMidasPayHelper.getJSContent(context);
    }

    public static java.lang.String getMidasCoreVersion(android.app.Activity activity) {
        com.tencent.midas.comm.APLog.i(TAG, "getMidasCoreVersion enter");
        return !checkParams(activity) ? "" : com.tencent.midas.plugin.APPluginUtils.getMidasCoreVersionName(activity);
    }

    public static java.lang.String getMidasPluginVersion() {
        com.tencent.midas.comm.APLog.d(TAG, "getMidasPluginVersion enter " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        return com.pay.tool.APMidasCommMethod.getApplicationPackageName().equals("com.tencent.unipay") ? com.pay.tool.APMidasCommMethod.getApplicationVersion() : "1.7.1f";
    }

    public static java.lang.String getMidasSDKVersion(android.app.Activity activity) {
        com.tencent.midas.comm.APLog.i(TAG, "getMidasSDKVersion enter");
        if (!checkParams(activity)) {
            return "";
        }
        return (java.lang.String) new com.tencent.midas.control.APMidasPayHelper().call(activity, java.lang.Thread.currentThread().getStackTrace()[2].getMethodName(), new java.lang.Object[0]);
    }

    public static java.lang.String getPath() {
        return dataPath;
    }

    public static int h5PayHook(android.app.Activity activity, android.webkit.WebView webView, java.lang.String str, java.lang.String str2, android.webkit.JsResult jsResult) {
        com.tencent.midas.comm.APLog.i(TAG, "h5PayHook enter");
        if (!checkParams(activity)) {
            return -33;
        }
        com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
        com.tencent.midas.control.APMidasPayHelper.setEnv(env);
        com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.setScreenType(screenType);
        return aPMidasPayHelper.h5Pay(activity, webView, null, str, str2);
    }

    public static int h5PayHookX5(android.app.Activity activity, com.tencent.smtt.sdk.WebView webView, java.lang.String str, java.lang.String str2, com.tencent.smtt.export.external.interfaces.JsResult jsResult) {
        com.tencent.midas.comm.APLog.i(TAG, "h5PayHookX5 enter");
        if (!checkParams(activity)) {
            return -33;
        }
        com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
        com.tencent.midas.control.APMidasPayHelper.setEnv(env);
        com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
        aPMidasPayHelper.setScreenType(screenType);
        return aPMidasPayHelper.h5Pay(activity, null, webView, str, str2);
    }

    public static void h5PayInit(android.app.Activity activity, android.webkit.WebView webView) {
        com.tencent.midas.comm.APLog.i(TAG, "h5PayInit enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper.MIDAS_WEBVIEW = com.tencent.midas.control.APMidasPayHelper.MIDAS_OUT_WEBVIEW;
            com.tencent.midas.control.APMidasPayHelper.h5Init(activity, webView, null);
        }
    }

    public static void h5PayInitUnifier(android.app.Activity activity, com.tencent.midas.api.IAPWebView iAPWebView) {
        com.tencent.midas.comm.APLog.i(TAG, "h5PayInitUnifier enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper.MIDAS_WEBVIEW = com.tencent.midas.control.APMidasPayHelper.MIDAS_OUT_WEBVIEW;
            com.tencent.midas.control.APMidasPayHelper.h5InitUnifier(activity, iAPWebView);
        }
    }

    public static void h5PayInitX5(android.app.Activity activity, com.tencent.smtt.sdk.WebView webView) {
        com.tencent.midas.comm.APLog.i(TAG, "h5PayInitX5 enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper.h5Init(activity, null, webView);
        }
    }

    public static void hfCouponsRollBack(android.app.Activity activity, java.lang.String str) {
        com.tencent.midas.comm.APLog.i(TAG, "hfCouponsRollBack enter");
        if (checkParams(activity)) {
            new com.tencent.midas.control.APMidasPayHelper().call(activity, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_HF_COUPONS_ROLLBACK, new java.lang.Object[]{str});
        }
    }

    public static void init(android.content.Context context, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        com.tencent.midas.data.APPluginReportManager.initDataRelease();
        com.tencent.midas.data.APPluginReportManager.getInstance().initInterfaceInit("init", aPMidasBaseRequest);
        com.tencent.midas.comm.APLogUtil.initAPLogInPlugin(context.getApplicationContext(), logEnable);
        com.tencent.midas.comm.APLog.i(TAG, "init new enter");
        com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeData("init", com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT);
        com.tencent.midas.control.APMidasPayHelper.setEnv(env);
        com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
        if (checkInitCommParam(context, aPMidasBaseRequest)) {
            com.tencent.midas.control.APMidasPayHelper.init(context, aPMidasBaseRequest);
        } else {
            com.tencent.midas.control.APMidasPayHelper.isNewProcess = com.tencent.midas.control.APMidasPayHelper.isNewProcess(context);
        }
    }

    public static void launchAbility(android.content.Context context, com.tencent.midas.api.ability.MidasBaseAbility midasBaseAbility, final android.os.ResultReceiver resultReceiver) {
        com.tencent.midas.comm.APLog.i(TAG, "launchAbility enter : " + midasBaseAbility.toString());
        if (!com.pay.tool.APMidasTools.isFastClick()) {
            if (checkParams(context)) {
                com.tencent.midas.data.APPluginReportManager.payDataRelease();
                com.tencent.midas.api.request.APMidasGameRequest aPMidasGameRequest = new com.tencent.midas.api.request.APMidasGameRequest();
                aPMidasGameRequest.offerId = midasBaseAbility.offerId;
                aPMidasGameRequest.openId = midasBaseAbility.openId;
                aPMidasGameRequest.openKey = midasBaseAbility.openKey;
                aPMidasGameRequest.sessionId = midasBaseAbility.sessionId;
                aPMidasGameRequest.sessionType = midasBaseAbility.sessionType;
                aPMidasGameRequest.pf = midasBaseAbility.pf;
                aPMidasGameRequest.pfKey = midasBaseAbility.pfKey;
                com.tencent.midas.data.APPluginReportManager.getInstance().payInterfaceInit(aPMidasGameRequest, com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHFEATURE);
                com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeData(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHFEATURE, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHABILITY);
                com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHABILITY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_ENTER_ABILITY, "MidasPlugin", midasBaseAbility.toString());
                new com.tencent.midas.control.APMidasPayHelper().sendMidas(context, midasBaseAbility.toBundle(), new android.os.ResultReceiver(new android.os.Handler()) { // from class: com.tencent.midas.api.APMidasPayAPI.1
                    @Override // android.os.ResultReceiver
                    protected void onReceiveResult(int i, android.os.Bundle bundle) {
                        com.tencent.midas.comm.APLog.i(com.tencent.midas.api.APMidasPayAPI.TAG, "launchAbility.onReceiveResult() resultCode=" + i + ", resultData=" + bundle);
                        android.os.ResultReceiver resultReceiver2 = resultReceiver;
                        if (resultReceiver2 != null) {
                            resultReceiver2.send(i, bundle);
                            com.tencent.midas.data.APPluginReportManager.getInstance().dataReport("launchAbility");
                            com.tencent.midas.plugin.APPluginUtils.release();
                            com.tencent.midas.comm.APLog.closeLog();
                        }
                    }
                });
                return;
            }
            return;
        }
        com.tencent.midas.comm.APLog.i("launchAbility", "isfast");
        if (resultReceiver != null) {
            android.os.Bundle bundle = new android.os.Bundle();
            bundle.putString("midas_callback_ability_postBack", midasBaseAbility.postBack);
            bundle.putInt("midas_callback_ability_code", com.tencent.safecloud.device.openlib.DeviceConfig.ERR_UNKNOW);
            bundle.putString("midas_callback_ability_msg", "fast click");
            bundle.putBundle("midas_callback_ability_" + com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, new android.os.Bundle());
            resultReceiver.send(-1, bundle);
        }
    }

    public static void launchNet(android.app.Activity activity, com.tencent.midas.api.request.APMidasNetRequest aPMidasNetRequest, com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack) {
        com.tencent.midas.comm.APLog.i(TAG, "launchNet enter");
        if (checkParams(activity)) {
            try {
                fromContext = activity.getApplicationContext();
            } catch (java.lang.Exception e) {
                com.tencent.midas.comm.APLog.i("fromContext", e.toString());
            }
            com.tencent.midas.data.APPluginReportManager.payDataRelease();
            com.tencent.midas.data.APPluginReportManager.getInstance().payInterfaceInit(aPMidasNetRequest, com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHNET);
            com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeData(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHNET, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHNET);
            com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
            com.tencent.midas.control.APMidasPayHelper.setEnv(env);
            com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
            aPMidasPayHelper.net(activity, aPMidasNetRequest, iAPMidasNetCallBack);
        }
    }

    public static void launchPay(android.app.Activity activity, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack) {
        com.tencent.midas.comm.APLog.i(TAG, "launchPay enter");
        if (checkParams(activity)) {
            try {
                fromContext = activity.getApplicationContext();
            } catch (java.lang.Exception e) {
                com.tencent.midas.comm.APLog.i("fromContext", e.toString());
            }
            if (!com.pay.tool.APMidasTools.isFastClick()) {
                com.tencent.midas.data.APPluginReportManager.payDataRelease();
                com.tencent.midas.data.APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
                com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeData(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY);
                com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
                com.tencent.midas.control.APMidasPayHelper.setEnv(env);
                com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
                aPMidasPayHelper.setScreenType(screenType);
                aPMidasPayHelper.pay(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
                return;
            }
            com.tencent.midas.comm.APLog.i("launchPay", "isfast");
            com.tencent.midas.comm.APLog.w(TAG, "launchPay enter fast:" + iAPMidasPayCallBack);
            com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
            aPMidasResponse.resultCode = -1;
            aPMidasResponse.payChannel = -1;
            aPMidasResponse.payState = 2;
            aPMidasResponse.provideState = -1;
            aPMidasResponse.resultMsg = "fast click";
            iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
        }
    }

    public static void launchPurchaseFlow(android.app.Activity activity, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, final com.tencent.midas.api.APOnIabPurchaseFinished aPOnIabPurchaseFinished) {
        boolean z;
        com.tencent.midas.comm.APLog.i(TAG, "launchPurchaseFlow enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper.setEnv(env);
            com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
            if (aPMidasBaseRequest == null || !((z = aPMidasBaseRequest instanceof com.tencent.midas.api.request.APMidasGoodsRequest))) {
                aPOnIabPurchaseFinished.onIabPurchaseFinished(new com.tencent.midas.api.request.APIabResult(3, ""), null);
                com.tencent.midas.comm.APLog.e("launchPurchaseFlow", "parameter is error");
                return;
            }
            if (z) {
                ((com.tencent.midas.api.request.APMidasGoodsRequest) aPMidasBaseRequest).mIsReceiptMode = true;
            }
            com.tencent.midas.api.request.APMidasGoodsRequest aPMidasGoodsRequest = (com.tencent.midas.api.request.APMidasGoodsRequest) aPMidasBaseRequest;
            aPMidasGoodsRequest.isCanChange = false;
            aPMidasGoodsRequest.saveValue = "1";
            aPMidasGoodsRequest.tokenType = 2;
            launchPay(activity, aPMidasBaseRequest, new com.tencent.midas.api.IAPMidasPayCallBack() { // from class: com.tencent.midas.api.APMidasPayAPI.2
                @Override // com.tencent.midas.api.IAPMidasPayCallBack
                public void MidasPayCallBack(com.tencent.midas.api.APMidasResponse aPMidasResponse) {
                    int resultCode = aPMidasResponse.getResultCode();
                    if (aPMidasResponse.resultCode == 100) {
                        resultCode = 101;
                    }
                    aPOnIabPurchaseFinished.onIabPurchaseFinished(new com.tencent.midas.api.request.APIabResult(resultCode, aPMidasResponse.getResultMsg()), aPMidasResponse.getReceipt());
                }

                @Override // com.tencent.midas.api.IAPMidasPayCallBack
                public void MidasPayNeedLogin() {
                    aPOnIabPurchaseFinished.onIabyNeedLogin();
                }
            });
        }
    }

    public static void launchWXMiniProgram(android.content.Context context, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
        com.tencent.midas.comm.APLog.i(TAG, "launchWXMiniProgram enter");
        if (checkParams(context)) {
            new com.tencent.midas.control.APMidasPayHelper().launchWXMiniProgram(context, bundle, resultReceiver);
        }
    }

    public static void launchWXMiniProgram_OnResponse(android.content.Context context, int i, android.os.Bundle bundle) {
        com.tencent.midas.comm.APLog.i(TAG, "launchWXMiniProgram_OnResponse enter");
        com.tencent.midas.comm.APLog.i(TAG, "launchWXMiniProgram_OnResponse enter: bundle = " + bundle);
        if (checkParams(context)) {
            new com.tencent.midas.control.APMidasPayHelper().launchWXMiniProgram_OnResponse(context, i, bundle);
        }
    }

    public static void launchWeb(android.app.Activity activity, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack) {
        com.tencent.midas.comm.APLog.i(TAG, "launchWeb enter");
        if (checkParams(activity)) {
            try {
                fromContext = activity.getApplicationContext();
            } catch (java.lang.Exception e) {
                com.tencent.midas.comm.APLog.i("fromContext", e.toString());
            }
            com.tencent.midas.data.APPluginReportManager.payDataRelease();
            com.tencent.midas.data.APPluginReportManager.getInstance().payInterfaceInit(aPMidasBaseRequest, com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHWEB);
            com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeData(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHWEB, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHWEB);
            com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
            com.tencent.midas.control.APMidasPayHelper.setEnv(env);
            com.tencent.midas.control.APMidasPayHelper.setLogEnable(logEnable);
            aPMidasPayHelper.setScreenType(screenType);
            aPMidasPayHelper.web(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
        }
    }

    public static void queryInventoryAsync(android.app.Activity activity, boolean z, java.util.List list, com.tencent.midas.api.request.APQueryInventoryFinishedListener aPQueryInventoryFinishedListener) {
        java.lang.Class<?> cls;
        java.lang.Class<?> cls2;
        com.tencent.midas.comm.APLog.i(TAG, "queryInventoryAsync enter");
        if (checkParams(activity)) {
            com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
            try {
                cls = java.lang.Class.forName(java.util.List.class.getName());
            } catch (java.lang.ClassNotFoundException e) {
                com.tencent.midas.comm.APLog.d(TAG, "queryInventoryAsync setEnv e:" + e.toString());
                cls = null;
            }
            try {
                cls2 = java.lang.Class.forName("com.tencent.midas.api.request.APQueryInventoryFinishedListener");
            } catch (java.lang.ClassNotFoundException e2) {
                com.tencent.midas.comm.APLog.d(TAG, "queryInventoryAsync APQueryInventoryFinishedListener e:" + e2.toString());
                cls2 = null;
            }
            java.lang.Object objCall = aPMidasPayHelper.call(activity, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_XGAME_QUERY, new java.lang.Object[]{java.lang.Boolean.valueOf(z), list, aPQueryInventoryFinishedListener}, new java.lang.Class[]{java.lang.Boolean.class, cls, cls2});
            com.tencent.midas.comm.APLog.i(TAG, "queryInventoryAsync ret " + objCall);
            if (objCall == null) {
                aPQueryInventoryFinishedListener.onQueryInventoryFinished(new com.tencent.midas.api.request.APIabResult(-1, ""), null);
            }
        }
    }

    public static void release(android.app.Activity activity) {
        com.tencent.midas.comm.APLog.i(TAG, "release() enter");
        new com.tencent.midas.control.APMidasPayHelper().call(activity, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_RELEASE, new java.lang.Object[0]);
    }

    public static void setEnv(java.lang.String str) {
        java.lang.reflect.Method declaredMethod;
        java.lang.Object objInvoke;
        env = str;
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("com.pay.tool.APAppDataInterface");
            if (cls != null) {
                java.lang.reflect.Method method = null;
                try {
                    declaredMethod = cls.getDeclaredMethod("singleton", new java.lang.Class[0]);
                } catch (java.lang.NoSuchMethodException unused) {
                    com.tencent.midas.comm.APLog.d(TAG, "com.pay.tool.APAppDataInterface ClassNotFound");
                    declaredMethod = null;
                }
                try {
                    objInvoke = declaredMethod.invoke(null, new java.lang.Object[0]);
                } catch (java.lang.Exception unused2) {
                    com.tencent.midas.comm.APLog.d(TAG, "com.pay.tool.APAppDataInterface invoke error");
                    objInvoke = null;
                }
                try {
                    method = cls.getMethod("setEnv", java.lang.String.class);
                } catch (java.lang.NoSuchMethodException unused3) {
                    com.tencent.midas.comm.APLog.d(TAG, "setEnv no such method");
                }
                try {
                    method.invoke(objInvoke, str);
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.d(TAG, "setEnv invoke error " + e.toString());
                }
            }
        } catch (java.lang.Exception e2) {
            com.tencent.midas.comm.APLog.d(TAG, "setEnv exception e:" + e2.toString());
        }
        com.tencent.midas.comm.APLog.d("MidasPluginSDK", "env= " + env);
    }

    public static void setLogEnable(boolean z) {
        logEnable = z;
    }

    public static void setParentClassloader(dalvik.system.DexClassLoader dexClassLoader) {
        com.tencent.midas.comm.APLog.i(TAG, "setParentClassloader enter classLoader:" + dexClassLoader);
        com.tencent.midas.plugin.APPluginLoader.setParentClassLoader(dexClassLoader);
    }

    public static void setPath(java.lang.String str) {
        com.tencent.midas.comm.APLog.i(TAG, "setPath enter path:" + str);
        dataPath = str;
    }

    public static void setScreenType(android.app.Activity activity, int i) {
        screenType = i;
    }
}
