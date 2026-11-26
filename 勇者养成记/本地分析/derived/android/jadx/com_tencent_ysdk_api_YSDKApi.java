package com.tencent.ysdk.api;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class YSDKApi {
    @com.tencent.ysdk.framework.verification.YSDKDescription("1.7.15")
    public static void autoLogin() {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("autoLogin", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.1")
    public static void buyGoods(com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara, com.tencent.ysdk.module.pay.PayListener payListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("buyGoods", payBuyGoodsPara, payListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void buyGoods(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("buyGoods", str, str2, java.lang.Boolean.valueOf(z), bArr, str3, payListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.3")
    public static void buyGoods(java.lang.String str, java.lang.String str2, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("buyGoods", str, str2, java.lang.Boolean.FALSE, bArr, str3, payListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.4")
    public static void buyGoods(boolean z, java.lang.String str, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str2, byte[] bArr, java.lang.String str3, java.lang.String str4, com.tencent.ysdk.module.pay.PayListener payListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("buyGoods", str, payItem, str2, bArr, java.lang.Boolean.valueOf(z), str3, str4, payListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static java.lang.String getChannelId() {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getChannelId", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static int getLoginRecord(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        try {
            return ((java.lang.Integer) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getLoginRecord", userLoginRet)).intValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        try {
            return (com.tencent.ysdk.module.user.UserLoginRet) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getLoginRecord", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return new com.tencent.ysdk.module.user.UserLoginRet();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.1")
    public static java.lang.String getPayProductId(boolean z, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str, java.lang.String str2) {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getPayProductId", java.lang.Boolean.valueOf(z), payItem, str, str2);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static java.lang.String getPf() {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getPf", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static java.lang.String getPfKey() {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getPfKey", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static java.lang.String getPlatformAppVersion(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getPlatformAppVersion", eplatform);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getQImei() {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getQImei", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static java.lang.String getQImei36() {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getQImei36", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static java.lang.String getRegisterChannelId() {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getRegisterChannelId", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static java.lang.String getVersion() {
        try {
            return (java.lang.String) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("getVersion", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    @java.lang.Deprecated
    public static void handleIntent(android.content.Intent intent) {
    }

    public static void init() {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("init", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void init(boolean z) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("init", java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKDeletedVersion("1.2.3")
    @java.lang.Deprecated
    @com.tencent.ysdk.framework.verification.YSDKDeprecatedVersion("1.2.0")
    @com.tencent.ysdk.framework.verification.YSDKDescription("该接口YSDK自1.2.3版本开始启用,游戏需要自行实现重复activity的判断")
    public static void isDifferentActivity(android.app.Activity activity) {
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static boolean isPlatformInstalled(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        try {
            return ((java.lang.Boolean) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("isPlatformInstalled", eplatform)).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isVisitorState() {
        try {
            return ((java.lang.Boolean) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("isVisitorState", new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static void login(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("login", eplatform);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static void logout() {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("logout", new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static void onActivityResult(int i, int i2, android.content.Intent intent) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("onActivityResult", java.lang.Integer.valueOf(i), java.lang.Integer.valueOf(i2), intent);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    @java.lang.Deprecated
    public static void onCreate(android.app.Activity activity) {
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    @java.lang.Deprecated
    public static void onDestroy(android.app.Activity activity) {
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    @java.lang.Deprecated
    public static void onPause(android.app.Activity activity) {
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    @java.lang.Deprecated
    public static void onRestart(android.app.Activity activity) {
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    @java.lang.Deprecated
    public static void onResume(android.app.Activity activity) {
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    @java.lang.Deprecated
    public static void onStop(android.app.Activity activity) {
    }

    public static void queryCertification(com.tencent.ysdk.module.antiaddiction.listener.QueryCertificationCallback queryCertificationCallback) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("queryCertification", queryCertificationCallback);
        } catch (java.lang.Exception e) {
            queryCertificationCallback.onQueryCertification(new com.tencent.ysdk.module.antiaddiction.model.CertificationRect(-1, "query certification fail"));
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKDeletedVersion("1.2.4")
    @java.lang.Deprecated
    public static void queryUserInfo(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("queryUserInfo", eplatform);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.4")
    public static void queryUserInfo(com.tencent.ysdk.framework.common.ePlatform eplatform, com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("queryUserInfo", eplatform, userRelationListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion(com.tencent.ysdk.shell.framework.web.jsbridge.YYBJsBridgeProxy.VERSION_NAME)
    public static void recharge(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke(com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.PAY_STAT_PARAM_RECHARGE, str, str2, java.lang.Boolean.valueOf(z), bArr, str3, payListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void reportAntiAddictExecute(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet, long j) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("reportAntiAddictExecute", antiAddictRet, java.lang.Long.valueOf(j));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static void reportEvent(java.lang.String str, java.util.HashMap map, boolean z) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("reportEvent", str, map, java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void reportGameRoleInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j, long j2, long j3, java.util.HashMap map) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("reportGameRoleInfo", str, str2, str3, str4, java.lang.Long.valueOf(j), java.lang.Long.valueOf(j2), java.lang.Long.valueOf(j3), map);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendConfigRequest() {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("sendConfigRequest", new java.lang.Object[0]);
        } catch (java.lang.Exception unused) {
        }
    }

    public static boolean setAntiAddictGameEnd() {
        try {
            return ((java.lang.Boolean) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setAntiAddictGameEnd", new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setAntiAddictGameStart() {
        try {
            return ((java.lang.Boolean) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setAntiAddictGameStart", new java.lang.Object[0])).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setAntiAddictListener(com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener antiAddictListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setAntiAddictListener", antiAddictListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAntiAddictLogEnable(boolean z) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setAntiAddictLogEnable", java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAntiRegisterWindowCloseListener(com.tencent.ysdk.module.antiaddiction.listener.AntiRegisterWindowCloseListener antiRegisterWindowCloseListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setRegisterWindowCloseListener", antiRegisterWindowCloseListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static void setBuglyListener(com.tencent.ysdk.module.bugly.BuglyListener buglyListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setBuglyListener", buglyListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setMainActivity(java.lang.String str) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setMainActivity", str);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setNotchSupport(boolean z) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setNotchSupport", java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.7")
    public static void setScreenCapturer(com.tencent.ysdk.module.share.impl.IScreenImageCapturer iScreenImageCapturer) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setScreenCapturer", iScreenImageCapturer);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSensitivePermissionSwitchStatus(boolean z) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setSensitivePermissionSwitchStatus", java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("setUserListener", userListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void showDebugIcon(android.app.Activity activity) {
        try {
            com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("showDebugIcon", activity);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
    public static boolean switchUser(boolean z) {
        try {
            return ((java.lang.Boolean) com.tencent.ysdk.framework.dynamic.YSDKDynamicUtil.invoke("switchUser", java.lang.Boolean.valueOf(z))).booleanValue();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
