package com.tencent.ysdk.shell.module.user.impl.guest;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.2.3")
public class GuestUserApi {
    private static volatile com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi instance;
    private com.tencent.ysdk.shell.module.user.impl.UserInnerInterface userInnerInterfaceImp;

    private GuestUserApi() {
    }

    public static com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi();
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
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER_GUEST);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) {
                this.userInnerInterfaceImp = (com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) moduleByName;
            }
        }
        return this.userInnerInterfaceImp;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface userInnerInterface = this.userInnerInterfaceImp;
        if (userInnerInterface != null) {
            return userInnerInterface.getLoginRecord();
        }
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi;
        return userLoginRet;
    }

    public void login() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.login();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_GUEST", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("login"));
        }
    }

    public void logout() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.logout();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_GUEST", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("logout"));
        }
    }

    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.setUserListener(userListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_GUEST", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setUserListener"));
        }
    }
}
