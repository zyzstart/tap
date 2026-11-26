package com.tencent.midas.control;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APMidasPayHelper implements com.tencent.midas.control.APCallBackResultReceiver.Receiver {
    public static java.lang.String MED_DISTRIBUTE_CALL = "openMidasCall";
    public static java.lang.String MED_DISTRIBUTE_CALL2 = "openMidasCall2";
    public static final java.lang.String MED_DISTRIBUTE_CALLBACK_FROM_MIDAS_PAY = "callbackFromMidasPay";
    public static java.lang.String MED_DISTRIBUTE_H5PAY = "openMidasH5Pay";
    public static java.lang.String MED_DISTRIBUTE_HANDLE_QQ_WALLET_INTENT = "handleQQWalletIntent";
    public static java.lang.String MED_DISTRIBUTE_HANDLE_WX_INTENT = "handleWXIntent";
    public static final java.lang.String MED_DISTRIBUTE_HF_COUPONS_ROLLBACK = "hfCouponsRollBack";
    public static java.lang.String MED_DISTRIBUTE_INFO = "openMidasInfo";
    public static java.lang.String MED_DISTRIBUTE_INIT = "golbalInit";
    public static java.lang.String MED_DISTRIBUTE_NET = "openMidasNet";
    public static java.lang.String MED_DISTRIBUTE_PAY = "openMidasPay";
    public static java.lang.String MED_DISTRIBUTE_RECEIVE = "receiveMidas";
    public static java.lang.String MED_DISTRIBUTE_RELEASE = "release";
    public static java.lang.String MED_DISTRIBUTE_WEB = "openMidasWeb";
    public static final java.lang.String MED_DISTRIBUTE_WX_MINIPROGRAM = "launchWXMiniProgram";
    public static final java.lang.String MED_DISTRIBUTE_WX_MINIPROGRAM_ONRESPONSE = "launchWXMiniProgram_OnResponse";
    public static final java.lang.String MED_DISTRIBUTE_XGAME_CONSUME = "consumeAsync";
    public static final java.lang.String MED_DISTRIBUTE_XGAME_QUERY = "queryInventoryAsync";
    public static int MIDAS_INNER_WEBVIEW = 0;
    public static int MIDAS_OUT_WEBVIEW = 1;
    public static java.lang.String MIDAS_PLUGIN_NAME = "MidasPay";
    public static final java.lang.String MIDAS_PLUGIN_VERSION = "1.7.1f";
    public static int MIDAS_WEBVIEW = 0;
    public static java.lang.String PKG_DISTRIBUTE = "com.tencent.midas.pay.APMidasDistribute";
    public static final int PLUGIN_INITFAIL = 2;
    private static final int PLUGIN_INITIDLE = -1;
    public static final int PLUGIN_INITING = 0;
    public static final int PLUGIN_INITSUCC = 1;
    private static final int RET_CHANGE_H5 = -100011;
    private static final java.lang.String RET_MSG_CHANGE_H5 = "needChangeH5";
    private static final java.lang.String TAG = "APMidasPayHelper";
    private static java.lang.String env = "release";
    private static int initCount = 0;
    private static com.tencent.midas.api.request.APMidasBaseRequest initRequest = null;
    public static int initState = -1;
    private static boolean isInitSucc = false;
    private static boolean isNeedLocalUpdate = false;
    public static boolean isNewProcess = false;
    private static boolean logEnable = false;
    public static com.tencent.midas.api.IAPMidasPayCallBack midasCallBack = null;
    public static com.tencent.midas.api.IAPMidasNetCallBack netCallBack = null;
    private static java.lang.String netCallBack_ReqType = "";
    private static com.tencent.midas.control.APCallBackResultReceiver remotRecevier;
    public static com.tencent.midas.api.request.APMidasBaseRequest requestObject;
    public static com.tencent.midas.api.IAPWebView sIWebView;
    public static android.app.Activity staticActivityContext;
    public static android.webkit.WebView webview;
    public static com.tencent.smtt.sdk.WebView x5Webview;
    private static java.lang.Object initObject = new java.lang.Object();
    private static java.lang.Object dexloadObject = new java.lang.Object();
    private static java.lang.Object loadingObject = new java.lang.Object();
    public int saveType = 0;
    public int screenType = 0;
    java.lang.Object retobj = null;

    static /* synthetic */ int access$508() {
        int i = initCount;
        initCount = i + 1;
        return i;
    }

    public static synchronized java.lang.String getJSContent(android.content.Context context) {
        com.tencent.midas.comm.APLog.i(TAG, "getJSContent");
        init(context, null);
        return (java.lang.String) new com.tencent.midas.control.APMidasPayHelper().callWithContext(context, "getH5JS", new java.lang.Object[]{context});
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static synchronized void h5Init(final android.app.Activity activity, android.webkit.WebView webView, com.tencent.smtt.sdk.WebView webView2) {
        com.tencent.midas.comm.APLog.i(TAG, "h5Init");
        x5Webview = webView2;
        webview = webView;
        isNewProcess = isNewProcess(activity);
        if (initCount < 1) {
            com.tencent.midas.plugin.APPluginUtils.release();
            preLoadPlugin(activity, "init", new com.tencent.midas.control.IAPInitCallBack() { // from class: com.tencent.midas.control.APMidasPayHelper.4
                @Override // com.tencent.midas.control.IAPInitCallBack
                public void result(int i, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
                    com.tencent.midas.comm.APLog.i(com.tencent.midas.control.APMidasPayHelper.TAG, "init ret:" + i + " msg:" + str);
                    com.tencent.midas.data.APPluginReportManager.getInstance().dataReport("init");
                    if (i == 0) {
                        com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
                        android.app.Activity activity2 = activity;
                        java.lang.String str3 = (java.lang.String) aPMidasPayHelper.call(activity2, "getH5JS", new java.lang.Object[]{activity2});
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            try {
                                if (com.tencent.midas.control.APMidasPayHelper.webview != null) {
                                    com.tencent.midas.control.APMidasPayHelper.webview.loadUrl("javascript:" + str3);
                                }
                                if (com.tencent.midas.control.APMidasPayHelper.x5Webview != null) {
                                    com.tencent.midas.control.APMidasPayHelper.x5Webview.loadUrl("javascript:" + str3);
                                }
                            } catch (java.lang.Exception e) {
                                com.tencent.midas.comm.APLog.w(com.tencent.midas.control.APMidasPayHelper.TAG, "h5Init loadJS error:" + e.toString());
                            }
                        }
                        com.tencent.midas.control.APMidasPayHelper.access$508();
                    }
                }
            });
        } else {
            java.lang.String str = (java.lang.String) new com.tencent.midas.control.APMidasPayHelper().call(activity, "getH5JS", new java.lang.Object[]{activity});
            if (!android.text.TextUtils.isEmpty(str)) {
                try {
                    if (webview != null) {
                        webView.loadUrl("javascript:" + str);
                    }
                    if (x5Webview != null) {
                        x5Webview.loadUrl("javascript:" + str);
                    }
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.w(TAG, "h5Init loadJS error:" + e.toString());
                }
            }
        }
    }

    @android.annotation.SuppressLint({"NewApi"})
    public static synchronized void h5InitUnifier(final android.app.Activity activity, com.tencent.midas.api.IAPWebView iAPWebView) {
        try {
            com.tencent.midas.comm.APLog.i(TAG, "h5InitUnifier");
            sIWebView = iAPWebView;
            isNewProcess = isNewProcess(activity);
            if (initCount < 1) {
                com.tencent.midas.plugin.APPluginUtils.release();
                preLoadPlugin(activity, "init", new com.tencent.midas.control.IAPInitCallBack() { // from class: com.tencent.midas.control.APMidasPayHelper.3
                    @Override // com.tencent.midas.control.IAPInitCallBack
                    public void result(int i, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
                        com.tencent.midas.comm.APLog.i(com.tencent.midas.control.APMidasPayHelper.TAG, "h5InitUnifier ret:" + i + " msg:" + str);
                        com.tencent.midas.data.APPluginReportManager.getInstance().dataReport("init");
                        if (i == 0) {
                            com.tencent.midas.control.APMidasPayHelper aPMidasPayHelper = new com.tencent.midas.control.APMidasPayHelper();
                            android.app.Activity activity2 = activity;
                            java.lang.String str3 = (java.lang.String) aPMidasPayHelper.call(activity2, "getH5JS", new java.lang.Object[]{activity2});
                            if (!android.text.TextUtils.isEmpty(str3)) {
                                try {
                                    if (com.tencent.midas.control.APMidasPayHelper.sIWebView != null) {
                                        com.tencent.midas.control.APMidasPayHelper.sIWebView.loadUrl("javascript:" + str3);
                                    }
                                } catch (java.lang.Exception e) {
                                    com.tencent.midas.comm.APLog.w(com.tencent.midas.control.APMidasPayHelper.TAG, "h5InitUnifier loadJS error:" + e.toString());
                                }
                            }
                            com.tencent.midas.control.APMidasPayHelper.access$508();
                        }
                    }
                });
            } else {
                java.lang.String str = (java.lang.String) new com.tencent.midas.control.APMidasPayHelper().call(activity, "getH5JS", new java.lang.Object[]{activity});
                if (!android.text.TextUtils.isEmpty(str)) {
                    try {
                        if (sIWebView != null) {
                            sIWebView.loadUrl("javascript:" + str);
                        }
                    } catch (java.lang.Exception e) {
                        com.tencent.midas.comm.APLog.w(TAG, "h5InitUnifier loadJS error:" + e.toString());
                    }
                }
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }

    public static synchronized void init(final android.content.Context context, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest) {
        com.tencent.midas.comm.APLog.i(TAG, "init initCount:" + initCount);
        isNewProcess = isNewProcess(context);
        initRequest = aPMidasBaseRequest;
        if (initCount < 1 && !isInitSucc) {
            com.tencent.midas.plugin.APPluginUtils.release();
            preLoadPlugin(context, "init", new com.tencent.midas.control.IAPInitCallBack() { // from class: com.tencent.midas.control.APMidasPayHelper.1
                @Override // com.tencent.midas.control.IAPInitCallBack
                public void result(int i, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
                    com.tencent.midas.comm.APLog.i(com.tencent.midas.control.APMidasPayHelper.TAG, "initcallback ret:" + i + " msg:" + str);
                    synchronized (com.tencent.midas.control.APMidasPayHelper.dexloadObject) {
                        boolean unused = com.tencent.midas.control.APMidasPayHelper.isInitSucc = true;
                        com.tencent.midas.control.APMidasPayHelper.dexloadObject.notifyAll();
                    }
                    com.tencent.midas.data.APPluginReportManager.getInstance().dataReport("init");
                }
            });
        } else if (isInitSucc) {
            ((android.app.Activity) context).runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.2
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.midas.comm.APLog.i(com.tencent.midas.control.APMidasPayHelper.TAG, "initcallback isInitSucc direct call init function");
                    android.content.Intent intent = new android.content.Intent();
                    intent.putExtra(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, "1.7.1f");
                    intent.putExtra("req", com.tencent.midas.control.APMidasPayHelper.initRequest);
                    intent.putExtra("env", com.tencent.midas.control.APMidasPayHelper.env);
                    intent.putExtra("logEnable", com.tencent.midas.control.APMidasPayHelper.logEnable);
                    intent.putExtra("launchInterfaceName", java.lang.Thread.currentThread().getName());
                    try {
                        com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface(context, com.tencent.midas.control.APMidasPayHelper.MIDAS_PLUGIN_NAME, com.tencent.midas.control.APMidasPayHelper.PKG_DISTRIBUTE, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_INIT, new java.lang.Object[]{context, intent});
                    } catch (java.lang.Exception e) {
                        com.tencent.midas.comm.APLog.i(com.tencent.midas.control.APMidasPayHelper.TAG, "initcallback isInitSucc direct call init function e:" + e.toString());
                    }
                }
            });
        }
        com.tencent.midas.data.APPluginReportManager.getInstance().dataReport("init");
        initCount++;
    }

    public static boolean isLogEnable() {
        return logEnable;
    }

    public static boolean isNewProcess(android.content.Context context) {
        try {
            android.content.pm.PackageManager packageManager = context.getApplicationContext().getPackageManager();
            android.content.pm.ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageManager.getPackageInfo(context.getApplicationContext().getPackageName(), 0).packageName, 1).activities;
            for (android.content.pm.ActivityInfo activityInfo : activityInfoArr) {
                if (activityInfo.name.equals("com.tencent.midas.proxyactivity.APMidasPayProxyActivity")) {
                    java.lang.String str = activityInfo.processName;
                    if (!android.text.TextUtils.isEmpty(str) && str.contains("midasPay")) {
                        return true;
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
        return false;
    }

    public static void midasCallBack(com.tencent.midas.api.APMidasResponse aPMidasResponse) {
        if (aPMidasResponse != null && aPMidasResponse.resultCode == RET_CHANGE_H5 && RET_MSG_CHANGE_H5.equals(aPMidasResponse.resultMsg) && com.tencent.midas.jsbridge.APWebJSBridgeActivity.startPureH5Pay(staticActivityContext, "", "change_h5_from_cgi")) {
            staticActivityContext = null;
            return;
        }
        com.tencent.midas.comm.APLog.i(TAG, "midasCallBack resultCode :" + aPMidasResponse.resultCode + " midasCallBack:" + midasCallBack);
        com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack = midasCallBack;
        if (iAPMidasPayCallBack != null) {
            iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
            midasCallBack = null;
        }
        com.tencent.midas.control.APCallBackResultReceiver aPCallBackResultReceiver = remotRecevier;
        if (aPCallBackResultReceiver != null) {
            aPCallBackResultReceiver.setReceiver(null);
            remotRecevier = null;
        }
        com.tencent.midas.data.APPluginReportManager.getInstance().dataReport(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        requestObject = null;
        com.tencent.midas.plugin.APPluginUtils.release();
        com.tencent.midas.comm.APLog.closeLog();
        staticActivityContext = null;
    }

    public static void midasH5CallBack(java.lang.String str) {
        com.tencent.midas.comm.APLog.i(TAG, "midasH5CallBack params:" + str + " webview:" + webview + " x5Webview:" + x5Webview);
        android.webkit.WebView webView = webview;
        if (webView != null) {
            try {
                webView.loadUrl(str);
            } catch (java.lang.Exception e) {
                com.tencent.midas.comm.APLog.w(TAG, "midasH5CallBack error:" + e.toString());
            }
        }
        com.tencent.smtt.sdk.WebView webView2 = x5Webview;
        if (webView2 != null) {
            try {
                webView2.loadUrl(str);
            } catch (java.lang.Exception e2) {
                com.tencent.midas.comm.APLog.w(TAG, "midasH5CallBack error:" + e2.toString());
            }
        }
        com.tencent.midas.control.APCallBackResultReceiver aPCallBackResultReceiver = remotRecevier;
        if (aPCallBackResultReceiver != null) {
            aPCallBackResultReceiver.setReceiver(null);
            remotRecevier = null;
        }
        com.tencent.midas.data.APPluginReportManager.getInstance().dataReport(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        com.tencent.midas.plugin.APPluginUtils.release();
        com.tencent.midas.comm.APLog.closeLog();
        staticActivityContext = null;
        requestObject = null;
    }

    public static void midasLoginExpire() {
        com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack = midasCallBack;
        if (iAPMidasPayCallBack != null) {
            iAPMidasPayCallBack.MidasPayNeedLogin();
            midasCallBack = null;
        }
        com.tencent.midas.control.APCallBackResultReceiver aPCallBackResultReceiver = remotRecevier;
        if (aPCallBackResultReceiver != null) {
            aPCallBackResultReceiver.setReceiver(null);
            remotRecevier = null;
        }
        com.tencent.midas.data.APPluginReportManager.getInstance().dataReport(com.tencent.midas.data.APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY);
        com.tencent.midas.plugin.APPluginUtils.release();
        com.tencent.midas.comm.APLog.closeLog();
        staticActivityContext = null;
        requestObject = null;
    }

    public static void onNetError(java.lang.String str, java.lang.Integer num, java.lang.String str2) {
        com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack = netCallBack;
        if (iAPMidasNetCallBack != null) {
            iAPMidasNetCallBack.MidasNetError(str, num.intValue(), str2);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
    }

    public static void onNetFinish(java.lang.String str, java.lang.String str2) {
        com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack = netCallBack;
        if (iAPMidasNetCallBack != null) {
            iAPMidasNetCallBack.MidasNetFinish(str, str2);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
    }

    public static void onNetStop(java.lang.String str) {
        com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack = netCallBack;
        if (iAPMidasNetCallBack != null) {
            iAPMidasNetCallBack.MidasNetStop(str);
            netCallBack = null;
            netCallBack_ReqType = "";
        }
        staticActivityContext = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openPlugin(android.app.Activity activity, android.content.Intent intent, java.lang.String str) {
        java.lang.Object objInitPluginInterface;
        com.tencent.midas.comm.APLog.d(TAG, "Calling into openPlugin, method = " + str + " caller = " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        try {
            objInitPluginInterface = com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface(activity, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, str, new java.lang.Object[]{activity, intent});
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            objInitPluginInterface = null;
        }
        try {
            com.tencent.midas.data.APPluginReportManager.getInstance().dataReport(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface());
        } catch (java.lang.Exception e2) {
            com.tencent.midas.comm.APLog.i(TAG, "openPlugin dataReport:" + e2.toString());
        }
        com.tencent.midas.comm.APLog.i(TAG, "openPlugin obj:" + objInitPluginInterface);
    }

    private void pluginInitErrCallBack(final android.app.Activity activity) {
        com.tencent.midas.comm.APLog.i(TAG, "pluginInitErrCallBack" + midasCallBack);
        if (com.tencent.midas.jsbridge.APWebJSBridgeActivity.startPureH5Pay(activity, com.tencent.midas.plugin.APPluginUtils.getInitErrorMsg(), "pluginInitErrCallBack")) {
            return;
        }
        activity.runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.14
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface(), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_ERROR, "", com.tencent.midas.plugin.APPluginUtils.getInitErrorMsg());
                android.widget.Toast.makeText(activity, "腾讯支付服务加载失败，请退出重试", 1).show();
                com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
                aPMidasResponse.resultCode = -100;
                com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack = com.tencent.midas.control.APMidasPayHelper.midasCallBack;
                if (iAPMidasPayCallBack != null) {
                    iAPMidasPayCallBack.MidasPayCallBack(aPMidasResponse);
                    com.tencent.midas.control.APMidasPayHelper.midasCallBack = null;
                    com.tencent.midas.control.APMidasPayHelper.requestObject = null;
                    com.tencent.midas.control.APMidasPayHelper.staticActivityContext = null;
                }
                com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack = com.tencent.midas.control.APMidasPayHelper.netCallBack;
                if (iAPMidasNetCallBack != null) {
                    iAPMidasNetCallBack.MidasNetError(com.tencent.midas.control.APMidasPayHelper.netCallBack_ReqType, -100, "腾讯支付服务加载失败，请退出重试");
                    com.tencent.midas.control.APMidasPayHelper.netCallBack = null;
                    java.lang.String unused = com.tencent.midas.control.APMidasPayHelper.netCallBack_ReqType = "";
                    com.tencent.midas.control.APMidasPayHelper.requestObject = null;
                    com.tencent.midas.control.APMidasPayHelper.staticActivityContext = null;
                }
                com.tencent.midas.data.APPluginReportManager.getInstance().dataReport(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void preLoadMidasPay(final android.content.Context context, final java.lang.String str, final com.tencent.midas.control.IAPInitCallBack iAPInitCallBack) {
        int iInstallPlugin;
        com.tencent.midas.comm.APLog.d(TAG, "Calling into preLoadMidasPay " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        java.lang.System.currentTimeMillis();
        if (isNeedLocalUpdate) {
            com.tencent.midas.comm.APLog.d(TAG, "Calling into preLoadMidasPay isNeedLocalUpdate == true");
            com.tencent.midas.plugin.APPluginInstallerAndUpdater.installFromLocal(context);
            com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_INSTALL_FROM_LOCAL, java.lang.System.currentTimeMillis());
            isNeedLocalUpdate = false;
        } else {
            com.tencent.midas.comm.APLog.d(TAG, "Calling into preLoadMidasPay isNeedLocalUpdate == false");
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        int iIsNeedUpdateFromAssets = com.tencent.midas.plugin.APPluginInstallerAndUpdater.isNeedUpdateFromAssets(context);
        com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_IS_NEED_ASSETS_UPDATE, jCurrentTimeMillis);
        com.tencent.midas.comm.APLog.d(TAG, "preLoadMidasPay isNeedUpdateFromAssets = " + iIsNeedUpdateFromAssets);
        if (iIsNeedUpdateFromAssets > 0) {
            long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis();
            iInstallPlugin = com.tencent.midas.plugin.APPluginInstallerAndUpdater.installPlugin(context, iIsNeedUpdateFromAssets);
            com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_INSTALL_FROM_ASSETS, jCurrentTimeMillis2);
        } else {
            iInstallPlugin = 0;
        }
        com.tencent.midas.comm.APLog.i(TAG, "preLoadMidasPay installPlugin ret:" + iInstallPlugin + " initRequest:" + initRequest);
        synchronized (initObject) {
            if (iInstallPlugin != 0) {
                initCount = 0;
                initState = 2;
                if (iAPInitCallBack != null) {
                    iAPInitCallBack.result(-1, com.tencent.midas.plugin.APPluginUtils.getInitErrorMsg(), str, null);
                }
            } else {
                long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis();
                boolean zIsPluginValid = com.tencent.midas.plugin.APPluginChecker.isPluginValid(context);
                com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_PLUGIN_VALID, jCurrentTimeMillis3);
                if (zIsPluginValid) {
                    try {
                        long jCurrentTimeMillis4 = java.lang.System.currentTimeMillis();
                        com.tencent.midas.plugin.APPluginLoader.preCreateClassLoaderByPath(context);
                        com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LOAD_DEX, jCurrentTimeMillis4);
                    } catch (java.lang.Exception e) {
                        com.tencent.midas.comm.APLog.e(TAG, "preLoadMidasPay preCreateClassLoaderByPath e: " + e.toString());
                        e.printStackTrace();
                    }
                    final java.lang.String name = java.lang.Thread.currentThread().getName();
                    if (context instanceof android.app.Activity) {
                        ((android.app.Activity) context).runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.13
                            @Override // java.lang.Runnable
                            public void run() {
                                java.lang.Object objInitPluginInterface;
                                android.content.Intent intent = new android.content.Intent();
                                intent.putExtra(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, "1.7.1f");
                                intent.putExtra("req", com.tencent.midas.control.APMidasPayHelper.initRequest);
                                intent.putExtra("env", com.tencent.midas.control.APMidasPayHelper.env);
                                intent.putExtra("logEnable", com.tencent.midas.control.APMidasPayHelper.logEnable);
                                intent.putExtra("launchInterfaceName", name);
                                android.app.Activity activity = (android.app.Activity) context;
                                try {
                                    long jCurrentTimeMillis5 = java.lang.System.currentTimeMillis();
                                    objInitPluginInterface = com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface(activity, com.tencent.midas.control.APMidasPayHelper.MIDAS_PLUGIN_NAME, com.tencent.midas.control.APMidasPayHelper.PKG_DISTRIBUTE, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_INIT, new java.lang.Object[]{activity, intent});
                                    try {
                                        com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(name, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT_KERNEL, jCurrentTimeMillis5);
                                        if (iAPInitCallBack != null) {
                                            iAPInitCallBack.result(0, "succ", str, null);
                                        }
                                    } catch (java.lang.Exception e2) {
                                        e = e2;
                                        e.printStackTrace();
                                        com.tencent.midas.control.IAPInitCallBack iAPInitCallBack2 = iAPInitCallBack;
                                        if (iAPInitCallBack2 != null) {
                                            iAPInitCallBack2.result(-2, e.toString(), str, null);
                                        }
                                    }
                                } catch (java.lang.Exception e3) {
                                    e = e3;
                                    objInitPluginInterface = null;
                                }
                                com.tencent.midas.comm.APLog.i(com.tencent.midas.control.APMidasPayHelper.TAG, "preLoadMidasPay openPlugin obj:" + objInitPluginInterface);
                                com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeData(name, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_INIT_TOTALTIME);
                                com.tencent.midas.comm.APLog.i(com.tencent.midas.control.APMidasPayHelper.TAG, "preLoadMidasPay initState = PLUGIN_INITSUCC");
                                com.tencent.midas.control.APMidasPayHelper.initState = 1;
                                synchronized (com.tencent.midas.control.APMidasPayHelper.loadingObject) {
                                    com.tencent.midas.control.APMidasPayHelper.loadingObject.notifyAll();
                                }
                            }
                        });
                    } else {
                        initState = 1;
                        synchronized (loadingObject) {
                            loadingObject.notifyAll();
                        }
                    }
                } else {
                    com.tencent.midas.comm.APLog.i(TAG, "preLoadMidasPay isPluginValid false");
                    com.tencent.midas.plugin.APPluginInstallerAndUpdater.unInstallPlugin(context);
                    initState = -1;
                    if (iAPInitCallBack != null) {
                        initCount = 0;
                        iAPInitCallBack.result(-1, "支付插件校验失败", str, null);
                    }
                    synchronized (loadingObject) {
                        loadingObject.notifyAll();
                    }
                }
            }
        }
    }

    private static void preLoadPlugin(final android.content.Context context, final java.lang.String str, final com.tencent.midas.control.IAPInitCallBack iAPInitCallBack) {
        synchronized (initObject) {
            initState = 0;
        }
        java.lang.Thread thread = new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.12
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.midas.control.APMidasPayHelper.preLoadMidasPay(context, str, iAPInitCallBack);
            }
        });
        thread.setName(com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface());
        thread.start();
    }

    public static void release(android.content.Context context) {
        com.tencent.midas.comm.APLog.d(TAG, "release");
        com.tencent.midas.plugin.APPluginInstallerAndUpdater.unInstallPlugin(context);
        synchronized (initObject) {
            initState = -1;
        }
    }

    public static void setEnv(java.lang.String str) {
        if (!"release".equals(str) && !com.tencent.midas.api.APMidasPayAPI.ENV_TEST.equals(str) && !com.tencent.midas.api.APMidasPayAPI.ENV_DEV.equals(str) && !"debug".equals(str) && !com.tencent.midas.api.APMidasPayAPI.ENV_TESTING.equals(str)) {
            str = "release";
        }
        env = str;
    }

    public static void setLogEnable(boolean z) {
        logEnable = z;
    }

    private int toH5Midas(final android.app.Activity activity, android.webkit.WebView webView, final java.lang.String str, final java.lang.String str2, final java.lang.String str3, java.lang.String str4) {
        com.tencent.midas.comm.APLog.i(TAG, "toH5Midas initState: " + initState);
        synchronized (initObject) {
            final android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(activity);
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(0);
            progressDialog.setTitle("温馨提示");
            progressDialog.setMessage("腾讯支付服务初始化中");
            if (initState == -1 || initState == 0) {
                try {
                    progressDialog.show();
                } catch (java.lang.Throwable unused) {
                }
            }
            if (initState == -1) {
                preLoadPlugin(activity, str4, null);
            }
            if (initState == 0) {
                new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.10
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (com.tencent.midas.control.APMidasPayHelper.loadingObject) {
                                com.tencent.midas.control.APMidasPayHelper.loadingObject.wait();
                            }
                        } catch (java.lang.InterruptedException e) {
                            com.tencent.midas.comm.APLog.w(com.tencent.midas.control.APMidasPayHelper.TAG, "toH5Midas e:" + e.toString());
                        }
                        try {
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        } catch (java.lang.Throwable unused2) {
                        }
                        com.tencent.midas.control.APMidasPayHelper.this.toH5MidasPay(activity, str, str2, str3);
                    }
                }).start();
                return 0;
            }
            return toH5MidasPay(activity, str, str2, str3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toH5MidasPay(final android.app.Activity activity, final java.lang.String str, final java.lang.String str2, final java.lang.String str3) {
        synchronized (initObject) {
            if (initState != 2) {
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.11
                    @Override // java.lang.Runnable
                    public void run() {
                        android.content.Intent intent = new android.content.Intent();
                        intent.putExtra(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, com.tencent.midas.api.APMidasPayAPI.getMidasPluginVersion());
                        intent.putExtra("env", com.tencent.midas.control.APMidasPayHelper.env);
                        intent.putExtra("screenType", com.tencent.midas.control.APMidasPayHelper.this.screenType);
                        intent.putExtra("logEnable", com.tencent.midas.control.APMidasPayHelper.logEnable);
                        intent.putExtra("req", "H5Pay");
                        intent.putExtra("url", str);
                        intent.putExtra("message", str2);
                        intent.putExtra("reqType", com.tencent.midas.control.APMidasPayHelper.netCallBack_ReqType);
                        try {
                            com.tencent.midas.data.APMultiProcessData processData = com.tencent.midas.data.APPluginDataInterface.singleton().getProcessData();
                            if (processData != null) {
                                intent.putExtra("launchPayGUID", processData.getGuid());
                                intent.putExtra("launchPayTime", processData.getPayInterfaceTime());
                                intent.putExtra("launchPayDataid", com.tencent.midas.data.APDataId.getDataId());
                                intent.putExtra("launchIntervalTime", processData.getIntervalTime());
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                        if (com.tencent.midas.control.APMidasPayHelper.isNewProcess) {
                            com.tencent.midas.control.APCallBackResultReceiver unused = com.tencent.midas.control.APMidasPayHelper.remotRecevier = new com.tencent.midas.control.APCallBackResultReceiver(new android.os.Handler());
                            com.tencent.midas.control.APMidasPayHelper.remotRecevier.setReceiver(com.tencent.midas.control.APMidasPayHelper.this);
                            intent.putExtra("remoteReceiver", com.tencent.midas.control.APMidasPayHelper.remotRecevier);
                        }
                        com.tencent.midas.control.APMidasPayHelper.this.openPlugin(activity, intent, str3);
                    }
                });
                return 0;
            }
            com.tencent.midas.comm.APLog.i(TAG, "toH5MidasPay plugin init error");
            pluginInitErrCallBack(activity);
            initState = -1;
            return -1;
        }
    }

    private int toMidas(final android.app.Activity activity, final com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, final java.lang.String str, final java.lang.String str2) {
        if (aPMidasBaseRequest == null) {
            com.tencent.midas.comm.APLog.w(TAG, "toMidas pay request is null");
            return -1;
        }
        requestObject = aPMidasBaseRequest;
        staticActivityContext = activity;
        com.tencent.midas.comm.APLog.i(TAG, "ToMidas initState = " + initState);
        synchronized (initObject) {
            final android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(activity);
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(0);
            progressDialog.setTitle("温馨提示");
            progressDialog.setMessage("腾讯支付服务初始化中");
            final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            boolean zIsNeedUpdateFromLocal = com.tencent.midas.plugin.APPluginInstallerAndUpdater.isNeedUpdateFromLocal(activity);
            isNeedLocalUpdate = zIsNeedUpdateFromLocal;
            if (zIsNeedUpdateFromLocal) {
                synchronized (initObject) {
                    initState = -1;
                }
            }
            if ((initState == -1 || initState == 0) && !MED_DISTRIBUTE_NET.equals(str) && !MED_DISTRIBUTE_INFO.equals(str)) {
                try {
                    progressDialog.show();
                } catch (java.lang.Throwable unused) {
                }
            }
            if (initState == -1) {
                if (isNeedLocalUpdate) {
                    release(activity);
                }
                preLoadPlugin(activity, str2, null);
            }
            if (initState == 0) {
                new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.8
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (com.tencent.midas.control.APMidasPayHelper.loadingObject) {
                                com.tencent.midas.control.APMidasPayHelper.loadingObject.wait();
                            }
                        } catch (java.lang.InterruptedException e) {
                            com.tencent.midas.comm.APLog.w(com.tencent.midas.control.APMidasPayHelper.TAG, e.toString());
                        }
                        try {
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        } catch (java.lang.Throwable unused2) {
                        }
                        com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT, jCurrentTimeMillis);
                        com.tencent.midas.control.APMidasPayHelper.this.toMidasPay(activity, aPMidasBaseRequest, str, str2);
                    }
                }).start();
                return 0;
            }
            return toMidasPay(activity, aPMidasBaseRequest, str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int toMidasPay(final android.app.Activity activity, final com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, final java.lang.String str, java.lang.String str2) {
        synchronized (initObject) {
            if (initState == 2) {
                com.tencent.midas.comm.APLog.i(TAG, "toMidasPay plugin init error");
                pluginInitErrCallBack(activity);
                initState = -1;
                return -1;
            }
            requestObject = aPMidasBaseRequest;
            staticActivityContext = activity;
            try {
                activity.runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.9
                    @Override // java.lang.Runnable
                    public void run() {
                        android.content.Intent intent = new android.content.Intent();
                        intent.putExtra(com.tencent.ysdk.shell.framework.request.HttpRequest.PARAM_VERSION, com.tencent.midas.api.APMidasPayAPI.getMidasPluginVersion());
                        intent.putExtra("env", com.tencent.midas.control.APMidasPayHelper.env);
                        intent.putExtra("screenType", com.tencent.midas.control.APMidasPayHelper.this.screenType);
                        intent.putExtra("logEnable", com.tencent.midas.control.APMidasPayHelper.logEnable);
                        intent.putExtra("req", aPMidasBaseRequest);
                        intent.putExtra("reqType", com.tencent.midas.control.APMidasPayHelper.netCallBack_ReqType);
                        intent.putExtra("method", str);
                        if (com.tencent.midas.control.APMidasPayHelper.isNewProcess) {
                            com.tencent.midas.control.APCallBackResultReceiver unused = com.tencent.midas.control.APMidasPayHelper.remotRecevier = new com.tencent.midas.control.APCallBackResultReceiver(new android.os.Handler());
                            com.tencent.midas.control.APMidasPayHelper.remotRecevier.setReceiver(com.tencent.midas.control.APMidasPayHelper.this);
                            intent.putExtra("remoteReceiver", com.tencent.midas.control.APMidasPayHelper.remotRecevier);
                        }
                        intent.putExtra("launchInterfaceName", com.tencent.midas.data.APPluginDataInterface.singleton().getLaunchInterface());
                        try {
                            com.tencent.midas.data.APMultiProcessData processData = com.tencent.midas.data.APPluginDataInterface.singleton().getProcessData();
                            if (processData != null) {
                                intent.putExtra("launchPayGUID", processData.getGuid());
                                intent.putExtra("launchPayTime", processData.getPayInterfaceTime());
                                intent.putExtra("launchPayDataid", com.tencent.midas.data.APDataId.getDataId());
                                intent.putExtra("launchIntervalTime", processData.getIntervalTime());
                            }
                        } catch (java.lang.Exception e) {
                            e.printStackTrace();
                        }
                        com.tencent.midas.control.APMidasPayHelper.this.openPlugin(activity, intent, str);
                    }
                });
                return 0;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

    private void waitingPluginReady(android.content.Context context, final android.os.ResultReceiver resultReceiver) {
        if (com.tencent.midas.api.APMidasPayAPI.ENV_TEST.equals(env) && initCount < 1) {
            android.widget.Toast.makeText(context, "腾讯支付尚未初始化，请先调用初始化接口!", 1).show();
        }
        if (isNewProcess) {
            android.content.SharedPreferences.Editor editorEdit = context.getApplicationContext().getSharedPreferences(com.tencent.midas.data.APPluginDataInterface.SHARE_PREFERENCE_NAME, 4).edit();
            editorEdit.putString("launchpaycalling", "1");
            editorEdit.commit();
        }
        com.tencent.midas.comm.APLog.i(TAG, "ToMidas initState = " + initState);
        synchronized (initObject) {
            final android.app.ProgressDialog progressDialog = new android.app.ProgressDialog(context);
            progressDialog.setIndeterminate(false);
            progressDialog.setProgressStyle(0);
            progressDialog.setTitle("温馨提示");
            progressDialog.setMessage("腾讯支付服务初始化中");
            final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            boolean zIsNeedUpdateFromLocal = com.tencent.midas.plugin.APPluginInstallerAndUpdater.isNeedUpdateFromLocal(context);
            isNeedLocalUpdate = zIsNeedUpdateFromLocal;
            if (zIsNeedUpdateFromLocal) {
                synchronized (initObject) {
                    initState = -1;
                }
            }
            if ((initState == -1 || initState == 0) && !MED_DISTRIBUTE_NET.equals("launchFunction") && !MED_DISTRIBUTE_INFO.equals("launchFunction")) {
                try {
                    progressDialog.show();
                } catch (java.lang.Throwable unused) {
                }
            }
            if (initState == -1) {
                if (isNeedLocalUpdate) {
                    release(context);
                }
                preLoadPlugin(context, "launchFunction", null);
            }
            if (initState == 0) {
                new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.6
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            synchronized (com.tencent.midas.control.APMidasPayHelper.loadingObject) {
                                com.tencent.midas.control.APMidasPayHelper.loadingObject.wait();
                            }
                        } catch (java.lang.InterruptedException e) {
                            com.tencent.midas.comm.APLog.w(com.tencent.midas.control.APMidasPayHelper.TAG, e.toString());
                        }
                        try {
                            if (progressDialog.isShowing()) {
                                progressDialog.dismiss();
                            }
                        } catch (java.lang.Throwable unused2) {
                        }
                        com.tencent.midas.data.APPluginReportManager.getInstance().insertTimeDataEx(com.pay.tool.APMidasTools.getCurrentThreadName(java.lang.Thread.currentThread()), com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY_WAIT_INIT, jCurrentTimeMillis);
                        resultReceiver.send(0, new android.os.Bundle());
                    }
                }).start();
            } else {
                resultReceiver.send(0, new android.os.Bundle());
            }
        }
    }

    public java.lang.Object call(android.app.Activity activity, java.lang.String str, java.lang.Object[] objArr) {
        return callWithContext(activity, str, objArr);
    }

    public java.lang.Object call(android.app.Activity activity, java.lang.String str, java.lang.Object[] objArr, java.lang.Class[] clsArr) {
        return callWithContext(activity, str, objArr, clsArr);
    }

    public java.lang.Object call(android.content.Context context, java.lang.String str, java.lang.Class[] clsArr, java.lang.Object[] objArr) {
        return callWithContext(context, str, objArr, clsArr);
    }

    public java.lang.Object callWithContext(android.content.Context context, java.lang.String str, java.lang.Object[] objArr) {
        try {
            return com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface(context, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL, new java.lang.Object[]{str, objArr});
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i(TAG, "callWithContext error:" + e.toString());
            return null;
        }
    }

    public java.lang.Object callWithContext(final android.content.Context context, final java.lang.String str, final java.lang.Object[] objArr, final java.lang.Class[] clsArr) {
        synchronized (initObject) {
            com.tencent.midas.comm.APLog.i("callWithContext ", "initState:" + initState);
            if (initState == 0) {
                new java.lang.Thread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.7
                    @Override // java.lang.Runnable
                    public void run() {
                        java.lang.StringBuilder sb;
                        java.lang.String string;
                        try {
                            com.tencent.midas.comm.APLog.d("callWithContext ", "PLUGIN_INITING wait");
                            synchronized (com.tencent.midas.control.APMidasPayHelper.dexloadObject) {
                                com.tencent.midas.control.APMidasPayHelper.dexloadObject.wait();
                            }
                            com.tencent.midas.comm.APLog.d("callWithContext ", "PLUGIN_INITING go");
                            ((android.app.Activity) context).runOnUiThread(new java.lang.Runnable() { // from class: com.tencent.midas.control.APMidasPayHelper.7.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    try {
                                        com.tencent.midas.control.APMidasPayHelper.this.retobj = com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface2(context, com.tencent.midas.control.APMidasPayHelper.MIDAS_PLUGIN_NAME, com.tencent.midas.control.APMidasPayHelper.PKG_DISTRIBUTE, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_CALL2, new java.lang.Object[]{str, objArr, clsArr});
                                    } catch (java.lang.Exception e) {
                                        com.tencent.midas.comm.APLog.e("callWithContext", "error1 " + e.toString());
                                    }
                                }
                            });
                        } catch (java.lang.InterruptedException e) {
                            sb = new java.lang.StringBuilder();
                            sb.append("error2 ");
                            string = e.toString();
                            sb.append(string);
                            com.tencent.midas.comm.APLog.e("callWithContext", sb.toString());
                        } catch (java.lang.Throwable th) {
                            sb = new java.lang.StringBuilder();
                            sb.append("error3 ");
                            string = th.toString();
                            sb.append(string);
                            com.tencent.midas.comm.APLog.e("callWithContext", sb.toString());
                        }
                    }
                }).start();
            } else {
                try {
                    this.retobj = com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface2(context, MIDAS_PLUGIN_NAME, PKG_DISTRIBUTE, MED_DISTRIBUTE_CALL2, new java.lang.Object[]{str, objArr, clsArr});
                } catch (java.lang.Exception e) {
                    com.tencent.midas.comm.APLog.e("callWithContext", "error3 " + e.toString());
                }
            }
        }
        return this.retobj;
    }

    public int getInfo(android.app.Activity activity, java.lang.String str, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack) {
        netCallBack = iAPMidasNetCallBack;
        netCallBack_ReqType = str;
        return toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_INFO, "getInfo");
    }

    public int h5Pay(android.app.Activity activity, android.webkit.WebView webView, com.tencent.smtt.sdk.WebView webView2, java.lang.String str, java.lang.String str2) {
        webview = webView;
        x5Webview = webView2;
        com.tencent.midas.comm.APLog.i(TAG, "h5Pay webview:" + webview + " x5Webview:" + x5Webview + " msg:" + str2);
        if (android.text.TextUtils.isEmpty(str2) || !str2.startsWith("midas_js_bridge_")) {
            return -2;
        }
        return toH5Midas(activity, webView, str, str2, MED_DISTRIBUTE_H5PAY, "h5Pay");
    }

    public void launchWXMiniProgram(android.content.Context context, android.os.Bundle bundle, android.os.ResultReceiver resultReceiver) {
        call(context, MED_DISTRIBUTE_WX_MINIPROGRAM, new java.lang.Class[]{android.content.Context.class, android.os.Bundle.class, android.os.ResultReceiver.class}, new java.lang.Object[]{context, bundle, resultReceiver});
    }

    public void launchWXMiniProgram_OnResponse(android.content.Context context, int i, android.os.Bundle bundle) {
        call(context, MED_DISTRIBUTE_WX_MINIPROGRAM_ONRESPONSE, new java.lang.Class[]{java.lang.Integer.TYPE, android.os.Bundle.class}, new java.lang.Object[]{java.lang.Integer.valueOf(i), bundle});
    }

    public void launchWeb(android.app.Activity activity, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(activity, com.tencent.midas.jsbridge.APWebJSBridgeActivity.class);
        activity.startActivity(intent);
    }

    public int net(android.app.Activity activity, com.tencent.midas.api.request.APMidasNetRequest aPMidasNetRequest, com.tencent.midas.api.IAPMidasNetCallBack iAPMidasNetCallBack) {
        netCallBack = iAPMidasNetCallBack;
        netCallBack_ReqType = aPMidasNetRequest.reqType;
        return toMidas(activity, aPMidasNetRequest, MED_DISTRIBUTE_NET, "net");
    }

    @Override // com.tencent.midas.control.APCallBackResultReceiver.Receiver
    public void onReceiveResult(int i, android.os.Bundle bundle) {
        com.tencent.midas.comm.APLog.i(TAG, "remotRecevier payHelper resultCode:" + i);
        if (i == 0) {
            progressRemoteInfo(bundle);
        }
    }

    public int pay(android.app.Activity activity, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack) {
        com.tencent.midas.comm.APLog.d(TAG, "Calling into pay, caller = " + java.lang.Thread.currentThread().getStackTrace()[3].toString());
        if (com.tencent.midas.api.APMidasPayAPI.ENV_TEST.equals(env) && initCount < 1) {
            android.widget.Toast.makeText(activity, "腾讯支付尚未初始化，请先调用初始化接口!", 1).show();
        }
        midasCallBack = iAPMidasPayCallBack;
        if (isNewProcess) {
            android.content.SharedPreferences.Editor editorEdit = activity.getApplicationContext().getSharedPreferences(com.tencent.midas.data.APPluginDataInterface.SHARE_PREFERENCE_NAME, 4).edit();
            editorEdit.putString("launchpaycalling", "1");
            editorEdit.commit();
        }
        return toMidas(activity, aPMidasBaseRequest, MED_DISTRIBUTE_PAY, "pay");
    }

    public void progressRemoteInfo(android.os.Bundle bundle) {
        com.tencent.midas.api.request.APPurchase aPPurchase;
        java.lang.StringBuilder sb;
        java.lang.String string;
        java.lang.String string2 = bundle.getString(com.tencent.open.SocialConstants.PARAM_TYPE);
        com.tencent.midas.comm.APLog.i(TAG, "progressRemoteInfo type:" + string2);
        if (!"callback".equals(string2)) {
            if ("h5callback".equals(string2)) {
                midasH5CallBack(bundle.getString("callbackinfo"));
                return;
            } else {
                if ("needlogin".equals(string2)) {
                    midasLoginExpire();
                    return;
                }
                return;
            }
        }
        com.tencent.midas.api.APMidasResponse aPMidasResponse = new com.tencent.midas.api.APMidasResponse();
        aPMidasResponse.resultCode = bundle.getInt("resultCode", -1);
        aPMidasResponse.resultInerCode = bundle.getInt("resultInerCode");
        aPMidasResponse.realSaveNum = bundle.getInt("realSaveNum");
        aPMidasResponse.payChannel = bundle.getInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_CHANNEL);
        aPMidasResponse.payState = bundle.getInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_STATE);
        aPMidasResponse.provideState = bundle.getInt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_PROVIDE_STATE);
        aPMidasResponse.resultMsg = bundle.getString("resultMsg");
        aPMidasResponse.extendInfo = bundle.getString(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_TYPE);
        aPMidasResponse.payReserve1 = bundle.getString("payReserve1");
        aPMidasResponse.payReserve2 = bundle.getString("payReserve2");
        aPMidasResponse.payReserve3 = bundle.getString("payReserve3");
        try {
            aPPurchase = new com.tencent.midas.api.request.APPurchase(bundle.getString("purchaseJson"), bundle.getString("purchaseSign"));
        } catch (org.json.JSONException e) {
            aPPurchase = new com.tencent.midas.api.request.APPurchase();
            sb = new java.lang.StringBuilder();
            sb.append("purchase creat fail1 ");
            string = e.toString();
            sb.append(string);
            com.tencent.midas.comm.APLog.w("progressRemoteInfo", sb.toString());
        } catch (java.lang.Exception e2) {
            aPPurchase = new com.tencent.midas.api.request.APPurchase();
            sb = new java.lang.StringBuilder();
            sb.append("purchase creat fail2 ");
            string = e2.toString();
            sb.append(string);
            com.tencent.midas.comm.APLog.w("progressRemoteInfo", sb.toString());
        }
        aPMidasResponse.mAPPurchase = aPPurchase;
        midasCallBack(aPMidasResponse);
    }

    public void sendMidas(final android.content.Context context, final android.os.Bundle bundle, final android.os.ResultReceiver resultReceiver) {
        waitingPluginReady(context, new android.os.ResultReceiver(new android.os.Handler(android.os.Looper.getMainLooper())) { // from class: com.tencent.midas.control.APMidasPayHelper.5
            @Override // android.os.ResultReceiver
            protected void onReceiveResult(int i, android.os.Bundle bundle2) {
                if (i == 0) {
                    try {
                        com.tencent.midas.control.APMidasPayHelper.this.retobj = com.tencent.midas.plugin.APPluginInterfaceManager.initPluginInterface(context, com.tencent.midas.control.APMidasPayHelper.MIDAS_PLUGIN_NAME, com.tencent.midas.control.APMidasPayHelper.PKG_DISTRIBUTE, com.tencent.midas.control.APMidasPayHelper.MED_DISTRIBUTE_RECEIVE, new java.lang.Object[]{context, bundle, resultReceiver}, new java.lang.Class[]{android.content.Context.class, android.os.Bundle.class, android.os.ResultReceiver.class});
                        return;
                    } catch (java.lang.Exception e) {
                        com.tencent.midas.comm.APLog.e(com.tencent.midas.control.APMidasPayHelper.TAG, "sendMidas() e = " + e.toString());
                        e.printStackTrace();
                        return;
                    }
                }
                if (resultReceiver != null) {
                    java.lang.String string = bundle.getString("__midas_ability_baseReq__postBack");
                    android.os.Bundle bundle3 = new android.os.Bundle();
                    bundle3.putString("midas_callback_ability_postBack", string);
                    bundle3.putInt("midas_callback_ability_code", -1999);
                    bundle3.putString("midas_callback_ability_msg", "MidasPlugin load failure");
                    bundle3.putBundle("midas_callback_ability_data", bundle2);
                    resultReceiver.send(-1, bundle3);
                }
            }
        });
    }

    public void setScreenType(int i) {
        this.screenType = i;
    }

    public void web(android.app.Activity activity, com.tencent.midas.api.request.APMidasBaseRequest aPMidasBaseRequest, com.tencent.midas.api.IAPMidasPayCallBack iAPMidasPayCallBack) {
        midasCallBack = iAPMidasPayCallBack;
        launchWeb(activity, aPMidasBaseRequest, iAPMidasPayCallBack);
    }
}
