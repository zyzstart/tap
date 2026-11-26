package com.tencent.ysdk.shell.module.user.impl.wx;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.0.0")
public class WXUserApi {
    private static java.lang.String appId;
    private static volatile com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi instance;
    private com.tencent.ysdk.shell.module.user.impl.UserInnerInterface userWXInnerInterfaceImp;

    private WXUserApi() {
    }

    public static com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.shell.module.user.impl.UserInnerInterface getOrLoadUserInnerInterface() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface userInnerInterface = this.userWXInnerInterfaceImp;
        if (userInnerInterface != null) {
            return userInnerInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER_WX);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) {
                this.userWXInnerInterfaceImp = (com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) moduleByName;
            }
        }
        return this.userWXInnerInterfaceImp;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.getLaunchRecord();
        }
        com.tencent.ysdk.libware.file.Logger.e("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getLaunchRecord"));
        return null;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.getLoginRecord();
        }
        com.tencent.ysdk.libware.file.Logger.e("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getLoginRecord"));
        return new com.tencent.ysdk.module.user.UserLoginRet();
    }

    public com.tencent.mm.opensdk.openapi.IWXAPI getWXApi() {
        java.lang.Object platformObject;
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            platformObject = orLoadUserInnerInterface.getPlatformObject();
        } else {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getWXApi"));
            platformObject = null;
        }
        if (platformObject instanceof com.tencent.mm.opensdk.openapi.IWXAPI) {
            return (com.tencent.mm.opensdk.openapi.IWXAPI) platformObject;
        }
        return null;
    }

    public com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.handleIntent(intent);
        }
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("handleIntent"));
        return null;
    }

    public void login() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface == null) {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("login"));
        } else {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx login");
            orLoadUserInnerInterface.login();
        }
    }

    public void loginWithLaunchRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.loginWithLaunchRecord();
        } else {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("loginWithLaunchRecord"));
        }
    }

    public void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface == null) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("loginWithLocalRecord"));
        } else {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx local login");
            orLoadUserInnerInterface.loginWithLocalRecord(z);
        }
    }

    public void logout() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.logout();
        } else {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("logout"));
        }
    }

    public void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.queryUserInfo(userRelationListener);
        } else {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("queryUserInfo"));
        }
    }

    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.setUserListener(userListener);
        } else {
            com.tencent.ysdk.libware.file.Logger.e("YSDK_LOGIN_WX", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setUserListener"));
        }
    }
}
