package com.tencent.ysdk.shell.module.user.impl.freelogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class FreeLoginUserModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.user.impl.UserInnerInterface {
    private static final java.lang.String EVENT_FREE_LOGIN_LOCAL_LOGIN = "YSDK_User_Login_LocalLogin_FREELOGIN";
    public static final java.lang.String LOG_TAG = "YSDK_FREE_LOGIN";
    private static final int MSG_BG_FREE_LOGIN = 2;
    private static final int MSG_UI_FREE_LOGIN = 1;
    private android.os.Handler mBgHandler;
    private android.os.Handler mUiHandler;
    private com.tencent.ysdk.module.user.UserListener mUserListener;
    private com.tencent.ysdk.module.user.UserLoginRet mUserLoginRet;

    private class FreeLoginCheckResponseHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse> {
        private long mRequestStartTime;

        public FreeLoginCheckResponseHandler(long j) {
            this.mRequestStartTime = 0L;
            this.mRequestStartTime = j;
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse cloudGameFreeloginResponse) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "FreeLoginUserModule#response>>>" + cloudGameFreeloginResponse.toString());
            if (cloudGameFreeloginResponse.ret == 0) {
                com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet freeLoginRet = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet();
                freeLoginRet.parseFreeLoginResponse(cloudGameFreeloginResponse);
                com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.this.notifyGameLogin(freeLoginRet);
                com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.reportFreeLoginEvent(freeLoginRet, this.mRequestStartTime);
                return;
            }
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet freeLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet();
            freeLoginRet2.ret = 1;
            freeLoginRet2.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
            freeLoginRet2.msg = cloudGameFreeloginResponse.msg;
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.this.notifyGameLogin(freeLoginRet2);
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.reportFreeLoginEvent(freeLoginRet2, this.mRequestStartTime);
        }
    }

    private class HandlerInBG extends android.os.Handler {
        public HandlerInBG(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 2) {
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "loginAsync in bg");
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.this.loginAsync();
        }
    }

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "loginAsync");
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.this.loginAsync();
        }
    }

    public FreeLoginUserModule() {
        super.init();
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "FreeLoginUserModule init start");
        this.mUiHandler = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        this.mBgHandler = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.HandlerInBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(1));
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "FreeLoginUserModule init end");
    }

    private com.tencent.ysdk.module.user.UserLoginRet freeLoginRet2UserLoginRet(com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet freeLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "FreeLoginRet2UserLoginRet>>>" + freeLoginRet.toString());
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet(freeLoginRet);
        userLoginRet.platform = 8;
        if (freeLoginRet != null) {
            com.tencent.ysdk.module.user.UserToken userToken = new com.tencent.ysdk.module.user.UserToken();
            userToken.type = 6;
            userToken.value = freeLoginRet.access_token;
            userLoginRet.token.add(userToken);
        }
        return userLoginRet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginAsync() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "free login OK-loginAsync");
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginRequest(com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getLoginInfo(), new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserModule.FreeLoginCheckResponseHandler(java.lang.System.currentTimeMillis() / 1000)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGameLogin(com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet freeLoginRet) {
        if (freeLoginRet == null) {
            freeLoginRet = new com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet();
            freeLoginRet.ret = 1;
            freeLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_Free_Login_Auth_Failed;
            freeLoginRet.msg = "notify game login ret is null";
        }
        freeLoginRet.setLoginType(0);
        com.tencent.ysdk.module.user.UserLoginRet userLoginRetFreeLoginRet2UserLoginRet = freeLoginRet2UserLoginRet(freeLoginRet);
        this.mUserLoginRet = userLoginRetFreeLoginRet2UserLoginRet;
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.copy(userLoginRetFreeLoginRet2UserLoginRet);
        userLoginRet.platform = freeLoginRet.platform;
        userLoginRet.getTokenByType(6).type = userLoginRet.platform == com.tencent.ysdk.framework.common.ePlatform.WX.val() ? 3 : 1;
        com.tencent.ysdk.module.user.UserListener userListener = this.mUserListener;
        if (userListener != null) {
            userListener.OnLoginNotify(userLoginRet);
        }
    }

    public static void reportFreeLoginEvent(com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginRet freeLoginRet, long j) {
        com.tencent.ysdk.shell.libware.file.Logger.d("reportFreeLoginEvent");
        java.util.HashMap map = new java.util.HashMap();
        try {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_IS_FIRST, java.lang.String.valueOf(freeLoginRet.getUserType()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            map.put("regChannel", freeLoginRet.getRegChannel());
            map.put("offerid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("sandbox", e);
        }
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(EVENT_FREE_LOGIN_LOCAL_LOGIN, freeLoginRet.flag, freeLoginRet.msg, 7, freeLoginRet.open_id, map, j, true);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord() {
        com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "Free login don't support getLaunchRecord!");
        return null;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "Free login getLoginRecord");
        if (this.mUserLoginRet == null) {
            this.mUserLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
            this.mUserLoginRet.platform = 8;
        }
        return this.mUserLoginRet;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public java.lang.Object getPlatformObject() {
        com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "Free login don't support getPlatformObject!");
        return null;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "Free login don't support handleIntent!");
        return null;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void login() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "Free login OK-login");
        android.os.Message message = new android.os.Message();
        message.what = 1;
        this.mUiHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLaunchRecord() {
        com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "Free login don't support loginWithLaunchRecord!");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "Free login don't support loginWithLocalRecord!");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithMemory() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "Free login OK-login");
        android.os.Message message = new android.os.Message();
        message.what = 2;
        this.mBgHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void logout() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK", "Free logout!");
        this.mUserLoginRet = null;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "requestCode=" + i + ", resultCode=" + i2 + ", data=" + intent.toString());
        return false;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "Free login don't support queryUserInfo!");
        if (userRelationListener != null) {
            userRelationListener.OnRelationNotify(null);
        }
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        this.mUserListener = userListener;
    }
}
