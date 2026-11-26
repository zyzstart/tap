package com.tencent.ysdk.shell.module.user.impl.qq;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
public class QQUserApi {
    private static final java.lang.String TAG = "YSDK.QQApi";
    private static volatile com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi instance;
    private com.tencent.ysdk.shell.module.user.impl.UserInnerInterface userInnerInterfaceImp;

    private QQUserApi() {
    }

    public static com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.shell.module.user.impl.UserInnerInterface getOrLoadUserInnerInterface() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface userInnerInterface = this.userInnerInterfaceImp;
        if (userInnerInterface != null) {
            return userInnerInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER_QQ);
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER_QQ);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) {
                this.userInnerInterfaceImp = (com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) moduleByName;
            }
        }
        return this.userInnerInterfaceImp;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.getLaunchRecord();
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getLaunchRecord"));
        return null;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.getLoginRecord();
        }
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi;
        return userLoginRet;
    }

    public com.tencent.tauth.Tencent getQQApi() {
        java.lang.Object platformObject;
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            platformObject = orLoadUserInnerInterface.getPlatformObject();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getQQApi"));
            platformObject = null;
        }
        if (platformObject instanceof com.tencent.tauth.Tencent) {
            return (com.tencent.tauth.Tencent) platformObject;
        }
        return null;
    }

    public com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.handleIntent(intent);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("handleIntent"));
        return null;
    }

    public void login() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("login"));
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", "login");
            orLoadUserInnerInterface.login();
        }
    }

    public void loginWithLaunchRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.loginWithLaunchRecord();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("loginWithLaunchRecord"));
        }
    }

    public void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("loginWithLocalRecord"));
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", "local login");
            orLoadUserInnerInterface.loginWithLocalRecord(z);
        }
    }

    public void logout() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.logout();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("logout"));
        }
    }

    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.onActivityResult(i, i2, intent);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("onActivityResult"));
        return false;
    }

    public void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.queryUserInfo(userRelationListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("queryUserInfo"));
        }
    }

    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "setUserListener");
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.setUserListener(userListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setUserListener"));
        }
    }
}
