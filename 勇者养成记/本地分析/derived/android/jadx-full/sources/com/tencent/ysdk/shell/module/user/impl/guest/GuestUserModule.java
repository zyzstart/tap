package com.tencent.ysdk.shell.module.user.impl.guest;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GuestUserModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.user.impl.UserInnerInterface {
    private static final java.lang.String EVENT_GUEST_LOCAL_LOGIN = "YSDK_User_Login_LocalLogin_GUEST";
    public static final java.lang.String LOG_TAG = "YSDK_USER_GUEST";
    private static final int MSG_UI_USER_GUEST_LOGIN = 1;
    private static final int MSG_UI_USER_GUEST_REALNAME_LOGIN = 2;
    private static final java.lang.String STAT_LOGIN_PLATFORM_GUEST = "guest";
    private com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet mLocalLoginRet = null;
    private android.os.Handler mUiHandler;
    private com.tencent.ysdk.module.user.UserListener mUserListener;

    private class GuestUserCheckResponesHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse> {
        private boolean mIsCheckRealName;
        private long mRequestStartTime;

        GuestUserCheckResponesHandler(long j, boolean z) {
            this.mRequestStartTime = 0L;
            this.mIsCheckRealName = false;
            this.mRequestStartTime = j;
            this.mIsCheckRealName = z;
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginResponse guestUserLoginResponse) {
            com.tencent.ysdk.shell.libware.file.Logger.d("[REDACTED]", "[REDACTED]" + guestUserLoginResponse.ret + "[REDACTED]" + guestUserLoginResponse.flag);
            if (guestUserLoginResponse.ret == 0) {
                final com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet();
                guestUserLoginRet.parseGuestLoginResponse(guestUserLoginResponse);
                if (com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().checkAntiAddictionLoginRules(guestUserLoginResponse.getJudgeLoginData(), guestUserLoginResponse.getVisitorLoginData(), new com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack() { // from class: com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler.1
                    @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
                    public void onExecuteInstruction(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet) {
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.saveGuestLoginRetToDB(guestUserLoginRet);
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.notifyGameLogin(guestUserLoginRet);
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.reportGuestLoginEvent(guestUserLoginRet, com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler.this.mRequestStartTime);
                    }

                    @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
                    public void onRegisterRealName() {
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet2 = guestUserLoginRet;
                        guestUserLoginRet2.ret = 1;
                        guestUserLoginRet2.flag = 3103;
                        guestUserLoginRet2.msg = "user need register realname";
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.notifyGameLogin(guestUserLoginRet);
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.reportGuestLoginEvent(guestUserLoginRet, com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler.this.mRequestStartTime);
                    }

                    @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
                    public void onRequestLogin(int i) {
                        android.os.Message message = new android.os.Message();
                        message.what = 2;
                        message.arg1 = i;
                        message.obj = guestUserLoginRet;
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.mUiHandler.sendMessage(message);
                    }

                    @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
                    public void onVisitorLogin() {
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet2 = guestUserLoginRet;
                        guestUserLoginRet2.ret = 0;
                        guestUserLoginRet2.flag = 0;
                        guestUserLoginRet2.msg = "visitor login";
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.saveGuestLoginRetToDB(guestUserLoginRet);
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.notifyGameLogin(guestUserLoginRet);
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.reportGuestLoginEvent(guestUserLoginRet, com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler.this.mRequestStartTime);
                    }
                }, this.mIsCheckRealName)) {
                    return;
                }
                com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.saveGuestLoginRetToDB(guestUserLoginRet);
                com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.notifyGameLogin(guestUserLoginRet);
                com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.reportGuestLoginEvent(guestUserLoginRet, this.mRequestStartTime);
                return;
            }
            com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet();
            guestUserLoginRet2.ret = 1;
            guestUserLoginRet2.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
            guestUserLoginRet2.errorCode = guestUserLoginResponse.flag;
            guestUserLoginRet2.msg = guestUserLoginResponse.msg;
            com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.notifyGameLogin(guestUserLoginRet2);
            com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.reportGuestLoginEvent(guestUserLoginRet2, this.mRequestStartTime);
            if (this.mIsCheckRealName) {
                com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().onRegisterWindowClose();
            }
        }
    }

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            switch (message.what) {
                case 1:
                    com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.LOG_TAG, "loginAsync");
                    com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.loginAsync();
                    break;
                case 2:
                    if (message.obj instanceof com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet) {
                        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.this.verifyRealnameLoginAsync((com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet) message.obj, message.arg1);
                    }
                    break;
            }
        }
    }

    private com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet getGuestLoginRet() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "getGuestLoginRet");
        if (this.mLocalLoginRet == null) {
            this.mLocalLoginRet = readLastGuestUserLoginRetFormDB();
        }
        return this.mLocalLoginRet;
    }

    private com.tencent.ysdk.module.user.UserLoginRet guestUserLoginRet2UserLoginRet(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "GuestUserLoginRet2UserLoginRet");
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet(guestUserLoginRet);
        userLoginRet.platform = 7;
        if (guestUserLoginRet != null) {
            com.tencent.ysdk.module.user.UserToken userToken = new com.tencent.ysdk.module.user.UserToken();
            userToken.type = 5;
            userToken.value = guestUserLoginRet.pay_token;
            userLoginRet.token.add(userToken);
        }
        return userLoginRet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginAsync() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-loginAsync");
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_GUEST", "request guest login");
        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler guestUserCheckResponesHandler = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler(java.lang.System.currentTimeMillis() / 1000, false);
        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestLoginRet = getGuestLoginRet();
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginRequest(guestLoginRet.open_id, guestLoginRet.getRegChannel(), guestUserCheckResponesHandler));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGameLogin(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet) {
        if (guestUserLoginRet == null) {
            guestUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet();
            guestUserLoginRet.ret = 1;
            guestUserLoginRet.flag = 3000;
            guestUserLoginRet.msg = "notify game login ret is null";
        }
        guestUserLoginRet.setLoginType(0);
        if (this.mUserListener == null || guestUserLoginRet == null) {
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_GUEST", "login notify ret " + guestUserLoginRet.ret + " , flag " + guestUserLoginRet.flag);
        this.mUserListener.OnLoginNotify(guestUserLoginRet2UserLoginRet(guestUserLoginRet));
    }

    private com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet readLastGuestUserLoginRetFormDB() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "read Last GuestUserLoginRet Form DB");
        return com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserTableModel.readLastUserLoginRet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportGuestLoginEvent(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet, long j) {
        com.tencent.ysdk.shell.libware.file.Logger.d("reportGuestLogin");
        java.util.HashMap map = new java.util.HashMap();
        try {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_IS_FIRST, java.lang.String.valueOf(guestUserLoginRet.getUserType()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            map.put("regChannel", guestUserLoginRet.getRegChannel());
            map.put("offerid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_PLATFORM, "guest");
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, "6");
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_LOCAL_ERROR_CODE, java.lang.String.valueOf(guestUserLoginRet.flag));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_RESPONSE_ERROR_CODE, java.lang.String.valueOf(guestUserLoginRet.errorCode));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_IS_VISITOR, com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState() ? "1" : "0");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_IS_VISITOR);
            sb.append(com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState() ? "1" : "0");
            com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (guestUserLoginRet.flag == 0) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_SUCCESS, guestUserLoginRet.flag, guestUserLoginRet.msg, 7, guestUserLoginRet.open_id, map, j, true, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
        } else {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_FAIL, guestUserLoginRet.flag, guestUserLoginRet.msg, 7, guestUserLoginRet.open_id, map, j, true, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean saveGuestLoginRetToDB(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "save saveGuestLoginRetToDB To DB");
        this.mLocalLoginRet = guestUserLoginRet;
        return com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserTableModel.saveUserLoginRet(guestUserLoginRet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void verifyRealnameLoginAsync(com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestUserLoginRet, int i) {
        if (guestUserLoginRet != null) {
            com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler guestUserCheckResponesHandler = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.GuestUserCheckResponesHandler(java.lang.System.currentTimeMillis() / 1000, true);
            com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet guestLoginRet = getGuestLoginRet();
            com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginRequest guestUserLoginRequest = new com.tencent.ysdk.shell.module.user.impl.guest.request.GuestUserLoginRequest(guestLoginRet.open_id, guestLoginRet.getRegChannel(), guestUserCheckResponesHandler);
            guestUserLoginRequest.setVisitorSwitch(i);
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(guestUserLoginRequest);
        }
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord() {
        return new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserLoginRet();
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-getLoginRecord");
        return guestUserLoginRet2UserLoginRet(getGuestLoginRet());
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public java.lang.Object getPlatformObject() {
        return 7;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-handleIntent");
        return null;
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "GuestUserModule init start");
        this.mUiHandler = new com.tencent.ysdk.shell.module.user.impl.guest.GuestUserModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "GuestUserModule init end");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void login() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-login");
        android.os.Message message = new android.os.Message();
        message.what = 1;
        this.mUiHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLaunchRecord() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-loginWithLaunchRecord");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-loginWithLocalRecord");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithMemory() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest WX not support this kind of login");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void logout() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "Guest OK-logout");
        int iClearUserLoginRet = com.tencent.ysdk.shell.module.user.impl.guest.db.GuestUserTableModel.clearUserLoginRet();
        this.mLocalLoginRet = null;
        com.tencent.ysdk.shell.libware.file.Logger.d("logoutAsync userNum:" + iClearUserLoginRet);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        return false;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-queryUserInfo");
        com.tencent.ysdk.module.user.UserRelationRet userRelationRet = new com.tencent.ysdk.module.user.UserRelationRet();
        userRelationRet.info_type = 1;
        userRelationRet.platform = 7;
        userRelationRet.ret = 1;
        userRelationRet.flag = 3201;
        if (userRelationListener == null) {
            this.mUserListener.OnRelationNotify(userRelationRet);
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("notify relation to :" + userRelationListener.toString());
        userRelationListener.OnRelationNotify(userRelationRet);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "Guest OK-setUserListener");
        this.mUserListener = userListener;
    }
}
