package com.tencent.ysdk.shell.module.user;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
public class UserApi {
    public static final java.lang.String LOG_TAG = "YSDK UserAPI";
    private static volatile com.tencent.ysdk.shell.module.user.UserApi instance;
    private static volatile java.util.concurrent.ConcurrentLinkedQueue<com.tencent.ysdk.shell.module.user.UserInnerLoginListener> mInnerListener = new java.util.concurrent.ConcurrentLinkedQueue<>();
    private boolean mIsResumed = true;
    private com.tencent.ysdk.shell.module.user.UserInterface userInterfaceImp;

    private UserApi() {
    }

    public static java.util.concurrent.ConcurrentLinkedQueue<com.tencent.ysdk.shell.module.user.UserInnerLoginListener> getInnerLoginListener() {
        return mInnerListener;
    }

    public static com.tencent.ysdk.shell.module.user.UserApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.UserApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.user.UserApi();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.shell.module.user.UserInterface getOrLoadUserInterface() {
        com.tencent.ysdk.shell.module.user.UserInterface userInterface = this.userInterfaceImp;
        if (userInterface != null) {
            return userInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.user.UserInterface) {
                this.userInterfaceImp = (com.tencent.ysdk.shell.module.user.UserInterface) moduleByName;
            }
        }
        return this.userInterfaceImp;
    }

    public static void reportGameRoleInfo(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, long j, long j2, long j3, java.util.HashMap<java.lang.String, java.lang.String> map) {
        try {
            java.util.HashMap map2 = new java.util.HashMap();
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_PAY_ZONEID, str);
            map2.put("zoneName", str2);
            map2.put("roleId", str3);
            map2.put("roleName", str4);
            map2.put("roleCTime", java.lang.String.valueOf(j));
            map2.put("roleLevel", java.lang.String.valueOf(j2));
            map2.put("roleLevelMTime", java.lang.String.valueOf(j3));
            if (map != null) {
                map2.putAll(map);
            }
            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_ROLE_INFO, 0, "user role info", map2, java.lang.System.currentTimeMillis(), true);
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, e);
        }
    }

    public static boolean setUserInnerLoginListener(com.tencent.ysdk.shell.module.user.UserInnerLoginListener userInnerLoginListener) {
        if (userInnerLoginListener == null || mInnerListener == null) {
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "mInnerListener or innerListener is null");
            return false;
        }
        if (mInnerListener.contains(userInnerLoginListener)) {
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "add innerListener again");
            return false;
        }
        com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "add innerListener");
        mInnerListener.add(userInnerLoginListener);
        return true;
    }

    public void autoLogin() {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.autoLogin();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("autoLogin"));
        }
    }

    public com.tencent.ysdk.framework.common.ePlatform getLoginPlatform() {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            return orLoadUserInterface.getLoginPlatform();
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getLoginPlatform"));
        return com.tencent.ysdk.framework.common.ePlatform.None;
    }

    public int getLoginRecord(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        if (this.mIsResumed) {
            com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
            if (orLoadUserInterface != null) {
                userLoginRet.copy(orLoadUserInterface.getLoginRecord());
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getLoginRecord"));
                userLoginRet.platform = com.tencent.ysdk.framework.common.ePlatform.None.val();
                userLoginRet.ret = 1;
                userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            }
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, "YSDKApi.onResume hava not beed called");
            userLoginRet.ret = 1;
            userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            userLoginRet.platform = com.tencent.ysdk.framework.common.ePlatform.None.val();
            userLoginRet.msg = "YSDKApi.onResume hava not beed called";
        }
        return userLoginRet.platform;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            return orLoadUserInterface.getLoginRecord();
        }
        com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getLoginRecord"));
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        return userLoginRet;
    }

    public java.lang.Object getPlatformObject(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            return orLoadUserInterface.getPlatformObject(eplatform);
        }
        com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getPlatformObject"));
        return null;
    }

    public java.lang.String getRegisterChannelId() {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            return orLoadUserInterface.getRegisterChannelId();
        }
        com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getRegisterChannelId"));
        return "";
    }

    public com.tencent.ysdk.framework.common.ePlatform getStartPlatform() {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            return orLoadUserInterface.getStartPlatform();
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getStartPlatform"));
        return com.tencent.ysdk.framework.common.ePlatform.None;
    }

    public void handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.handleIntent(intent);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("handleIntent"));
        }
    }

    public void localLogin() {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.localLogin();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("localLogin"));
        }
    }

    public void login(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "login");
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.login(eplatform);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("login"));
        }
    }

    public void logout() {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.logout();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("logout"));
        }
    }

    public void notifyLoginAsync(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.notifyLoginAsync(userLoginRet);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("notifyLoginAsync"));
        }
    }

    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.onActivityResult(i, i2, intent);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("onActivityResult"));
        }
    }

    public void onPause(android.app.Activity activity) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.onPause(activity);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("onPause"));
        }
    }

    public void onResume(android.app.Activity activity) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("onResume"));
        } else {
            orLoadUserInterface.onResume(activity);
            this.mIsResumed = true;
        }
    }

    public void queryUserInfo(com.tencent.ysdk.framework.common.ePlatform eplatform, com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.queryUserInfo(eplatform, userRelationListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("queryUserInfo"));
        }
    }

    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "setUserListener");
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            orLoadUserInterface.setUserListener(userListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setUserListener"));
        }
    }

    public boolean switchUser(boolean z) {
        com.tencent.ysdk.shell.module.user.UserInterface orLoadUserInterface = getOrLoadUserInterface();
        if (orLoadUserInterface != null) {
            return orLoadUserInterface.switchUser(z);
        }
        com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("switchUser"));
        return false;
    }
}
