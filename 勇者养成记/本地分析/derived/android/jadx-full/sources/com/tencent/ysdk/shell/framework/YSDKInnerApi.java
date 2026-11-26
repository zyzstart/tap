package com.tencent.ysdk.shell.framework;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class YSDKInnerApi {
    private static final java.lang.String TAG = "YSDK";

    YSDKInnerApi() {
    }

    public static void autoLogin() {
        if (com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isFreeAutoLoginValid()) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN", "start getLoginRecordWithAutoLogin");
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().loginBeforeCheck(com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getLoginPlatformFormInfo(), new com.tencent.ysdk.module.user.UserLoginRet());
        } else {
            com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("autoLogin");
            com.tencent.ysdk.shell.module.user.UserApi.getInstance().localLogin();
        }
    }

    public static void buyGoods(com.tencent.ysdk.module.pay.PayBuyGoodsPara payBuyGoodsPara, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "buyGoods");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("buyGoods");
        com.tencent.ysdk.shell.module.pay.PayApi.getInstance().buyGoods(payBuyGoodsPara, payListener);
    }

    public static void buyGoods(java.lang.String str, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str2, byte[] bArr, boolean z, java.lang.String str3, java.lang.String str4, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "buyGoods");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("buyGoods");
        com.tencent.ysdk.shell.module.pay.PayApi.getInstance().buyGoods(str, payItem, str2, bArr, z, str3, str4, payListener);
    }

    public static void buyGoods(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "buyGoods");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("buyGoods");
        com.tencent.ysdk.shell.module.pay.PayApi.getInstance().bugGoods(str, str2, z, bArr, str3, payListener);
    }

    public static java.lang.String getChannelId() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getChannelId");
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId();
    }

    public static com.tencent.ysdk.module.cloud.ICloudSettingApi getCloudSettingApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getCloudSettingApiInstance");
        try {
            return com.tencent.ysdk.shell.module.cloud.CloudSettingApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.tencent.ysdk.module.stat.IDelayReportApi getDelayReportApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getCloudSettingApiInstance");
        try {
            return com.tencent.ysdk.shell.module.stat.delayreport.DelayReportApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi getFreeLoginUserApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getFreeLoginUserApiInstance");
        try {
            return com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.tencent.ysdk.module.icon.IIconApi getIconApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getIconApiInstance");
        try {
            return com.tencent.ysdk.shell.module.icon.IconApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.tencent.ysdk.module.immersiveicon.IImmersiveIconApi getImmersiveIconApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getImmersiveIconApiInstance");
        try {
            return com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.tencent.ysdk.module.launchgift.ILaunchGiftApi getLaunchGiftApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getLaunchGiftApiInstance");
        try {
            return com.tencent.ysdk.shell.module.launchgift.LaunchGiftApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static int getLoginRecord(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getLoginRecord");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("getLoginRecord");
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord(userLoginRet);
    }

    public static com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getLoginRecord");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("getLoginRecord");
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
    }

    @java.lang.Deprecated
    public static int getLoginRecordWithAutoLogin(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN", "getLoginRecordWithAutoLogin");
        userLoginRet.ret = com.tencent.ysdk.framework.common.eFlag.METHOD_DEPRECATED;
        userLoginRet.msg = "此方法已废弃;云游戏的自动登录能力已经整合到YSDKApi.autoLogin()中";
        return userLoginRet.ret;
    }

    public static com.tencent.ysdk.module.msgbox.IMsgBoxApi getMsgBoxApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getCloudSettingApiInstance");
        try {
            return com.tencent.ysdk.shell.module.msgbox.MsgBoxApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getPayProductId(boolean z, com.tencent.ysdk.module.pay.PayItem payItem, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getPayProductId");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("getPayProductId");
        return com.tencent.ysdk.shell.module.pay.PayApi.getInstance().getPayProductId(z, payItem, str, str2);
    }

    public static java.lang.String getPf() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getPf");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("getPf");
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().pf;
    }

    public static java.lang.String getPfKey() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getPfKey");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("getPfKey");
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord().pf_key;
    }

    public static java.lang.String getPlatformAppVersion(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getPlatformAppVersion");
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPlatformAppVersion(eplatform);
    }

    public static com.tencent.ysdk.framework.dynamic.manager.IPluginDownloadApi getPluginDownloadApi() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "IPluginDownloadApi");
        try {
            return com.tencent.ysdk.shell.framework.dynamic.PluginDownloadApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getQImei() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getQImei");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("getQImei");
        try {
            return com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static java.lang.String getQImei36() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getQImei36");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("getQImei36");
        try {
            return com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei36();
        } catch (java.lang.Exception unused) {
            return "";
        }
    }

    public static com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter getQRPresenter(android.app.Activity activity) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getQRPresenter");
        try {
            return com.tencent.ysdk.shell.module.user.impl.wx.qrcode.QRCodePresenter.getInstance(activity);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getRegisterChannelId() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getRegisterChannelId");
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().getRegisterChannelId();
    }

    public static com.tencent.ysdk.module.share.IShareApi getShareApiInstance() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getShareApiInstance");
        try {
            return com.tencent.ysdk.shell.module.share.ShareApiImpl.getInstance();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static java.lang.String getVersion() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "getVersion");
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion();
    }

    public static void handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "handleIntent");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().handleIntent(intent);
    }

    public static void init() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "init");
        init(true);
    }

    public static void init(android.app.Application application, com.tencent.ysdk.framework.dynamic.manager.LoadedPluginInfo loadedPluginInfo) {
        android.util.Log.d("YSDK", "init: ");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().init(application, loadedPluginInfo);
    }

    public static void init(boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "init autoLoginByYSDK " + z);
        if (!z) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK", "调用了YSDKApi.init(false)将关闭ysdk的自动登录能力，开发者需要手动调用YSDKApi.autoLogin()进行自动登录，避免因为登录态过期导致支付失败等问题");
        }
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().init(z);
    }

    public static boolean isDebugVersion() {
        try {
            return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isExternalStorageAvailable(android.content.Context context) {
        try {
            return com.tencent.ysdk.shell.libware.file.ExternalStorage.isExternalStorageAvailable(context);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isPlatformInstalled(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "isPlatformInstalled");
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isPlatformInstalled(eplatform);
    }

    public static boolean isVisitorState() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "isVisitorState");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("isVisitorState");
        try {
            return com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void login(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "login");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("login");
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_CORE", "login " + eplatform.name());
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().login(eplatform);
    }

    public static void logout() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "logout");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("logout");
        com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGOUT, 0, "logout", null, java.lang.System.currentTimeMillis(), true, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
        setAntiAddictGameEnd();
        com.tencent.ysdk.shell.framework.YSDKPlayer.getInstance().logout();
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().logout();
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().setVisitorState(false);
    }

    public static void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "onActivityResult");
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onActivityResult , requestCode ");
        sb.append(i);
        sb.append(" , resultCode ");
        sb.append(i2);
        sb.append(" , ");
        sb.append(intent == null);
        com.tencent.ysdk.libware.file.Logger.d(" YSDK_LOGIN_QQ", sb.toString());
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onActivityResult(i, i2, intent);
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().onActivityResult(i, i2, intent);
        com.tencent.ysdk.module.share.ShareApi.getInstance().onActivityResult(i, i2, intent);
    }

    public static void onCreate(android.app.Activity activity) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "onCreate");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onCreate(activity);
    }

    public static void onDestroy(android.app.Activity activity) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "onDestroy");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onDestroy(activity);
    }

    public static void onPause(android.app.Activity activity) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "onPause");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onPause(activity);
    }

    public static void onResume(android.app.Activity activity) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "onResume");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().onResume(activity);
    }

    public static java.util.Map pipeEventDispatchEvent(int i, java.util.Map map) {
        try {
            return com.tencent.ysdk.shell.module.sandbox.pipe.PipeEventHandler.dispatchEvent(i, map);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void queryCertification(com.tencent.ysdk.module.antiaddiction.listener.QueryCertificationCallback queryCertificationCallback) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "queryCertification");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("queryCertification");
        try {
            com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().queryCertification(queryCertificationCallback);
        } catch (java.lang.Exception unused) {
            queryCertificationCallback.onQueryCertification(new com.tencent.ysdk.module.antiaddiction.model.CertificationRect(-1, "query certification fail"));
        }
    }

    public static void queryUserInfo(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "queryUserInfo");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("queryUserInfo");
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().queryUserInfo(eplatform, null);
    }

    public static void queryUserInfo(com.tencent.ysdk.framework.common.ePlatform eplatform, com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "queryUserInfo");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("queryUserInfo");
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().queryUserInfo(eplatform, userRelationListener);
    }

    public static void recharge(java.lang.String str, java.lang.String str2, boolean z, byte[] bArr, java.lang.String str3, com.tencent.ysdk.module.pay.PayListener payListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.PAY_STAT_PARAM_RECHARGE);
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited(com.tencent.ysdk.shell.module.stat.StatEvent.PayEvent.PAY_STAT_PARAM_RECHARGE);
        com.tencent.ysdk.shell.module.pay.PayApi.getInstance().recharge(str, str2, z, bArr, str3, payListener);
    }

    public static void reportAntiAddictExecute(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet, long j) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "reportAntiAddictExecute");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("reportAntiAddictExecute");
        try {
            com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().reportExecuteInstruction(antiAddictRet, j);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void reportApiEventWithDeviceInfo(java.lang.String str, int i, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(str, i, str2, map);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void reportEvent(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "reportEvent");
        com.tencent.ysdk.shell.module.stat.StatApi.getInstance().reportEvent(str, map, z);
    }

    public static void reportGameRoleInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j, long j2, long j3, java.util.HashMap<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "reportGameRoleInfo");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("reportGameRoleInfo");
        try {
            com.tencent.ysdk.shell.module.user.UserApi.reportGameRoleInfo(str, str2, str3, str4, j, j2, j3, map);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void reportStatError(java.util.Map<java.lang.String, java.lang.String> map, java.lang.Throwable th) {
        try {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(map, th);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendConfigRequest() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "sendConfigRequest");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().sendConfigRequest();
    }

    public static boolean setAntiAddictGameEnd() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setAntiAddictGameEnd");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("setAntiAddictGameEnd");
        try {
            return com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().setGameEnd();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean setAntiAddictGameStart() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setAntiAddictGameStart");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("setAntiAddictGameStart");
        try {
            return com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().setGameStart();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void setAntiAddictListener(com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener antiAddictListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setAntiAddictListener");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("setAntiAddictListener");
        try {
            com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().setAntiAddictListener(antiAddictListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setAntiAddictLogEnable(boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setAntiAddictLogEnable");
        try {
            com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().setLogEnable(z);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setBuglyListener(com.tencent.ysdk.module.bugly.BuglyListener buglyListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setBuglyListener");
        com.tencent.ysdk.shell.module.bugly.BuglyApi.getInstance().setBuglyListener(buglyListener);
    }

    public static void setMainActivity(java.lang.String str) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setMainActivity");
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().setMainActivity(str);
    }

    public static void setNotchSupport(boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setNotchSupport " + z);
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("setNotchSupport");
        try {
            com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().setNotchSupport(z);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK", e);
        }
    }

    public static void setRegisterWindowCloseListener(com.tencent.ysdk.module.antiaddiction.listener.AntiRegisterWindowCloseListener antiRegisterWindowCloseListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setRegisterWindowCloseListener");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("setRegisterWindowCloseListener");
        try {
            com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().setRegisterWindowCloseListener(antiRegisterWindowCloseListener);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setScreenCapturer(com.tencent.ysdk.module.share.impl.IScreenImageCapturer iScreenImageCapturer) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setScreenCapturer");
        try {
            com.tencent.ysdk.module.share.ShareApi.getInstance().setScreenCapturer(iScreenImageCapturer);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public static void setSensitivePermissionSwitchStatus(boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setSensitivePermissionSwitchStatus " + z);
        com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().setSensitivePermissionStatus(z);
    }

    public static void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "setUserListener");
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().setUserListener(userListener);
    }

    public static void showDebugIcon(android.app.Activity activity) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "showDebugIcon");
        com.tencent.ysdk.shell.module.debug.DebugViewManager.getInstance().showDebugIconView(activity);
    }

    public static boolean switchUser(boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK", "switchUser");
        com.tencent.ysdk.shell.framework.verification.UserTips.showAndCheckIsYSDKInited("switchUser");
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().switchUser(z);
    }
}
