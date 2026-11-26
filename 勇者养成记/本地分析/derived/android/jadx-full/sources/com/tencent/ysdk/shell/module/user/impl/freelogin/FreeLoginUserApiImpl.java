package com.tencent.ysdk.shell.module.user.impl.freelogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@com.tencent.ysdk.framework.verification.YSDKSupportVersion("1.3.3")
public class FreeLoginUserApiImpl implements com.tencent.ysdk.module.user.UserListener, com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi {
    private static final java.lang.String AUTO_LOGIN_KEY_CLOSE = "0";
    private static final java.lang.String AUTO_LOGIN_KEY_OPEN = "1";
    private static final int AUTO_LOGIN_TIMEOUT_SECOND = 2;
    private static final java.lang.String IS_AUTO_LOGIN = "isAutoLogin";
    private static final java.lang.String LOGIN_PLATFORM = "loginPlatform";
    private static final java.lang.String QQ_PLATFORM = "1";
    private static final java.lang.String WX_PLATFORM = "2";
    private static volatile com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl instance;
    private java.lang.String mAutoLogin;
    private java.lang.String mGOpenID;
    private java.lang.String mGToken;
    private java.lang.String mLoginInfo;
    private com.tencent.ysdk.framework.common.ePlatform mLoginPlatform;
    private com.tencent.ysdk.framework.common.ePlatform mLoginPlatformFormInfo = com.tencent.ysdk.framework.common.ePlatform.QQ;
    private com.tencent.ysdk.module.user.UserListener mOutListener;
    private com.tencent.ysdk.shell.module.user.impl.UserInnerInterface mUserInnerInterfaceImp;
    private com.tencent.ysdk.module.user.UserLoginRet mUserLoginRet;

    private FreeLoginUserApiImpl() {
    }

    public static com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.class) {
                if (instance == null) {
                    instance = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl();
                }
            }
        }
        return instance;
    }

    private com.tencent.ysdk.framework.common.ePlatform getLoginPlatformByString(java.lang.String str) {
        return (android.text.TextUtils.isEmpty(str) || !"2".equals(str)) ? com.tencent.ysdk.framework.common.ePlatform.QQ : com.tencent.ysdk.framework.common.ePlatform.WX;
    }

    private com.tencent.ysdk.shell.module.user.impl.UserInnerInterface getOrLoadUserInnerInterface() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface userInnerInterface = this.mUserInnerInterfaceImp;
        if (userInnerInterface != null) {
            return userInnerInterface;
        }
        com.tencent.ysdk.shell.module.ModuleManager moduleManager = com.tencent.ysdk.shell.module.ModuleManager.getInstance();
        if (moduleManager != null) {
            java.lang.Object moduleByName = moduleManager.getModuleByName(com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_FREE_LOGIN);
            if (moduleByName instanceof com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) {
                this.mUserInnerInterfaceImp = (com.tencent.ysdk.shell.module.user.impl.UserInnerInterface) moduleByName;
            }
        }
        return this.mUserInnerInterfaceImp;
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        com.tencent.ysdk.framework.common.ePlatform eplatform;
        this.mUserLoginRet = userLoginRet;
        if (userLoginRet != null && (eplatform = this.mLoginPlatform) != null) {
            userLoginRet.platform = eplatform.val();
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "OnLoginNotify>>>");
        com.tencent.ysdk.module.user.UserListener userListener = this.mOutListener;
        if (userListener != null) {
            userListener.OnLoginNotify(userLoginRet);
        }
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
        com.tencent.ysdk.module.user.UserListener userListener = this.mOutListener;
        if (userListener != null) {
            userListener.OnRelationNotify(userRelationRet);
        }
    }

    @Override // com.tencent.ysdk.module.user.UserListener
    public void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
        com.tencent.ysdk.module.user.UserListener userListener = this.mOutListener;
        if (userListener != null) {
            userListener.OnWakeupNotify(wakeupRet);
        }
    }

    public boolean getIsAutoLogin() {
        boolean z = !android.text.TextUtils.isEmpty(this.mAutoLogin) && this.mAutoLogin.equals("1");
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "getIsAutoLogin=" + z);
        return z;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.getLaunchRecord();
        }
        com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("getLaunchRecord"));
        return null;
    }

    @Override // com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi
    public java.lang.String getLoginInfo() {
        return this.mLoginInfo;
    }

    @Override // com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi
    public com.tencent.ysdk.framework.common.ePlatform getLoginPlatformFormInfo() {
        return this.mLoginPlatformFormInfo;
    }

    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null && this.mLoginPlatform != null) {
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = orLoadUserInnerInterface.getLoginRecord();
            loginRecord.platform = this.mLoginPlatform.val();
            loginRecord.getTokenByType(6).type = this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.WX ? 3 : 1;
            return loginRecord;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "getLoginRecord>>>null");
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi;
        return userLoginRet;
    }

    public java.lang.String getOfferId() {
        try {
            return new org.json.JSONObject(this.mLoginInfo).optString("offerid");
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox", e);
            return "";
        }
    }

    public java.lang.String getToken() {
        return this.mGToken;
    }

    public java.lang.String getgOpenID() {
        return this.mGOpenID;
    }

    public com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.handleIntent(intent);
        }
        com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("handleIntent"));
        return null;
    }

    @Override // com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi
    public boolean isDebug() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug();
    }

    @Override // com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi
    public boolean isFreeAutoLoginValid() {
        boolean z = isLoginInfoVaild(this.mLoginPlatformFormInfo.val()) && getIsAutoLogin();
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "isFreeAutoLoginValid>>>" + z);
        return z;
    }

    public boolean isHasLogin() {
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = this.mUserLoginRet;
        return userLoginRet != null && userLoginRet.flag == 0;
    }

    public boolean isLoginInfoVaild(int i) {
        return isLoginInfoVaild(i, false);
    }

    public boolean isLoginInfoVaild(int i, boolean z) {
        java.lang.String str;
        boolean z2 = (android.text.TextUtils.isEmpty(this.mLoginInfo) || i == com.tencent.ysdk.framework.common.ePlatform.Guest.val()) ? false : true;
        com.tencent.ysdk.shell.libware.file.Logger.debug("YSDK", "isLoginInfoVaild>>>isValid:" + z2 + ", mLoginInfo:" + this.mLoginInfo + ", platform:" + i);
        if (z) {
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet freeLoginRet = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet();
            freeLoginRet.ret = -1;
            freeLoginRet.flag = z2 ? com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.FREE_LOGIN_INFO_VALID : com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.FREE_LOGIN_INFO_INVALID;
            if (z2) {
                str = "login info is valid";
            } else {
                str = "login info is inValid, platform" + i + ", loginInfo:" + this.mLoginInfo;
            }
            freeLoginRet.msg = str;
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.reportFreeLoginEvent(freeLoginRet, java.lang.System.currentTimeMillis() / 1000);
        }
        return z2;
    }

    public void login(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        this.mLoginPlatform = eplatform;
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.login();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("login"));
        }
    }

    @Override // com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi
    public int loginBeforeCheck(com.tencent.ysdk.framework.common.ePlatform eplatform, com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        loginWithMemory(eplatform);
        if (userLoginRet != null) {
            userLoginRet.copy(this.mUserLoginRet);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "loginBeforeCheck return");
        if (userLoginRet != null) {
            return userLoginRet.platform;
        }
        return 0;
    }

    public void loginWithLaunchRecord() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.loginWithLaunchRecord();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("loginWithLaunchRecord"));
        }
    }

    public void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.loginWithLocalRecord(z);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("loginWithLocalRecord"));
        }
    }

    public void loginWithMemory(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        this.mLoginPlatform = eplatform;
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.loginWithMemory();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("loginWithMemory"));
        }
    }

    public void logout() {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.logout();
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("logout"));
        }
    }

    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            return orLoadUserInnerInterface.onActivityResult(i, i2, intent);
        }
        com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("onActivityResult"));
        return false;
    }

    public void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.queryUserInfo(userRelationListener);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("queryUserInfo"));
        }
    }

    @Override // com.tencent.ysdk.module.user.impl.freelogin.IFreeLoginUserApi
    public void setLoginInfo(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "setLoginInfo>>>" + str);
        this.mLoginInfo = str;
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return;
        }
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            this.mGOpenID = jSONObject.optString("cloudUserID");
            this.mGToken = jSONObject.optString("[REDACTED]");
            this.mAutoLogin = jSONObject.optString(IS_AUTO_LOGIN);
            this.mLoginPlatformFormInfo = getLoginPlatformByString(jSONObject.optString("loginPlatform"));
        } catch (org.json.JSONException e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox", e);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("[REDACTED]", "[REDACTED]" + this.mGOpenID + "[REDACTED]" + this.mGToken + "[REDACTED]" + this.mAutoLogin + "[REDACTED]" + this.mLoginPlatformFormInfo);
    }

    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        this.mOutListener = userListener;
        com.tencent.ysdk.shell.module.user.impl.UserInnerInterface orLoadUserInnerInterface = getOrLoadUserInnerInterface();
        if (orLoadUserInnerInterface != null) {
            orLoadUserInnerInterface.setUserListener(this);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.e("YSDK_LOGIN_FREE", com.tencent.ysdk.shell.libware.util.CommonUtils.getCommonNotifyMsg("setUserListener"));
        }
    }
}
