package com.tencent.ysdk.shell.module.user.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.user.UserInterface {
    public static final java.lang.String LOG_TAG = "YSDK.UserModule";
    private static final int MSG_NOTIFY_LOGIN = 1;
    private static final int MSG_NOTIFY_RELATION = 3;
    private static final int MSG_NOTIFY_WAKEUP = 2;
    private com.tencent.ysdk.module.user.UserListener mUserListener = null;
    private android.os.Handler mUiHandler = null;
    private com.tencent.ysdk.framework.common.ePlatform mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.None;
    private com.tencent.ysdk.framework.common.ePlatform mLaunchPlatform = com.tencent.ysdk.framework.common.ePlatform.None;
    private com.tencent.ysdk.framework.common.ePlatform mStartPlatForm = com.tencent.ysdk.framework.common.ePlatform.None;
    private int mWakeUpLoginType = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_NEED_LOGIN;
    private boolean hadAutoLoginByYSDK = false;

    private class FreeLoginListenerImp implements com.tencent.ysdk.module.user.UserListener {
        private FreeLoginListenerImp() {
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            userLoginRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapFreeLoginFlag(userLoginRet.flag);
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "UserModule#OnLoginNotify>>>flag:" + userLoginRet.flag);
            com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().removeTask(com.tencent.ysdk.shell.module.user.impl.UserTask.TASK_NAME);
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyLogin(userLoginRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
            userRelationRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapRelationRetFlag(userRelationRet.flag);
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyRelation(userRelationRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyWakeup(wakeupRet);
        }
    }

    private class GuestUserListenerImp implements com.tencent.ysdk.module.user.UserListener {
        private GuestUserListenerImp() {
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            userLoginRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapGuestUserFlag(userLoginRet.flag);
            if (userLoginRet.flag == 0) {
                com.tencent.ysdk.shell.module.user.impl.UserModule.this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.Guest;
            }
            com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().removeTask(com.tencent.ysdk.shell.module.user.impl.UserTask.TASK_NAME);
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyLogin(userLoginRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
            userRelationRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapRelationRetFlag(userRelationRet.flag);
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyRelation(userRelationRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyWakeup(wakeupRet);
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
                    com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyLoginAsync((com.tencent.ysdk.module.user.UserLoginRet) message.obj);
                    break;
                case 2:
                    com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyWakeupAsync((com.tencent.ysdk.module.user.WakeupRet) message.obj);
                    break;
                case 3:
                    com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyRelationAsync((com.tencent.ysdk.module.user.UserRelationRet) message.obj);
                    break;
            }
        }
    }

    private class QQUserListenerImp implements com.tencent.ysdk.module.user.UserListener {
        private QQUserListenerImp() {
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            userLoginRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapQQUserFlag(userLoginRet.flag);
            if (userLoginRet.flag != 0) {
                com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().removeTask(com.tencent.ysdk.shell.module.user.impl.UserTask.TASK_NAME);
            } else {
                com.tencent.ysdk.shell.module.user.impl.UserModule.this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
                com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().addTask(new com.tencent.ysdk.shell.module.user.impl.UserTask());
            }
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyLogin(userLoginRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
            userRelationRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapRelationRetFlag(userRelationRet.flag);
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyRelation(userRelationRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyWakeup(wakeupRet);
        }
    }

    private class WXUserListenerImp implements com.tencent.ysdk.module.user.UserListener {
        private WXUserListenerImp() {
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            userLoginRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapWXUserFlag(userLoginRet.flag);
            if (userLoginRet.flag != 0) {
                com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().removeTask(com.tencent.ysdk.shell.module.user.impl.UserTask.TASK_NAME);
            } else {
                com.tencent.ysdk.shell.module.user.impl.UserModule.this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.WX;
                com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().addTask(new com.tencent.ysdk.shell.module.user.impl.UserTask());
            }
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyLogin(userLoginRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnRelationNotify(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
            userRelationRet.flag = com.tencent.ysdk.shell.module.user.impl.UserModule.this.mapRelationRetFlag(userRelationRet.flag);
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyRelation(userRelationRet);
        }

        @Override // com.tencent.ysdk.module.user.UserListener
        public void OnWakeupNotify(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
            com.tencent.ysdk.shell.module.user.impl.UserModule.this.notifyWakeup(wakeupRet);
        }
    }

    public UserModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER;
    }

    private void autoLoginByYSDK() {
        if (!this.hadAutoLoginByYSDK && com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isInit() && com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isAutoLoginByYSDK() && this.mUserListener != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "autologinByYSDK");
            com.tencent.ysdk.api.YSDKApi.autoLogin();
            this.hadAutoLoginByYSDK = true;
        }
    }

    private int checkWakeUpLoginType() {
        com.tencent.ysdk.module.user.UserLoginRet launchRecord;
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.None && this.mLaunchPlatform == com.tencent.ysdk.framework.common.ePlatform.None) {
            return com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_NEED_LOGIN;
        }
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = null;
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            loginRecord = com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().getLoginRecord();
            launchRecord = com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().getLaunchRecord();
        } else if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            loginRecord = com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().getLoginRecord();
            launchRecord = com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().getLaunchRecord();
        } else {
            launchRecord = null;
        }
        boolean z = (loginRecord == null || com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(loginRecord.open_id)) ? false : true;
        boolean z2 = (launchRecord == null || com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(launchRecord.open_id)) ? false : true;
        boolean z3 = z && z2 && loginRecord.open_id.equals(launchRecord.open_id);
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "localVaild:" + z + ";launchVaild:" + z2 + ";sameUser:" + z3);
        return getWakeUpLoginType(z, z2, z3);
    }

    private int getWakeUpLoginType(boolean z, boolean z2, boolean z3) {
        if (!z) {
            return z2 ? com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_URL_LOGIN : com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_NEED_LOGIN;
        }
        if (z2) {
            return !z3 ? com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_NEED_SELECT_ACCOUNT : com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_URL_LOGIN;
        }
        return com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_LOCAL_LOGIN;
    }

    private boolean isReturnSourceFlag(int i) {
        return i == 2000 || i == 2001 || i == 2002 || i == 2003 || i == 3101 || i == 3103;
    }

    private boolean isSucc(int i) {
        return i == 0 || i == 102001 || i == 102002;
    }

    private boolean isTokenInvalid(int i) {
        return i == 102003 || i == 3100;
    }

    private void loginWithLaunchRecord() {
        if (com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isLoginInfoVaild(this.mLoginPlatform.val())) {
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().loginWithLaunchRecord();
            return;
        }
        if (this.mLaunchPlatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", "wx login with record");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().loginWithLaunchRecord();
        } else {
            com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
            userLoginRet.ret = 1;
            userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            notifyLogin(userLoginRet);
        }
    }

    private void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "loginWithLocalRecord is auto：" + z);
        if (com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isLoginInfoVaild(this.mLoginPlatform.val())) {
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().loginWithLocalRecord(z);
            return;
        }
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().loginWithLocalRecord(z);
            return;
        }
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().loginWithLocalRecord(z);
            return;
        }
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.Guest) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_GUEST", "last login platform guest");
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "loginWithLocalRecord，current login platform is guest");
            return;
        }
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        userLoginRet.msg = "loginWithLocalRecord use bad login platform ";
        notifyLogin(userLoginRet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mapFreeLoginFlag(int i) {
        if (i != 0) {
            return i != 3100 ? com.tencent.ysdk.framework.common.eFlag.Login_Free_Login_Auth_Failed : com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mapGuestUserFlag(int i) {
        if (i == 0) {
            return 0;
        }
        if (i != 3100) {
            return i != 3103 ? 3000 : 3103;
        }
        return com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mapQQUserFlag(int i) {
        switch (i) {
            case 0:
            case 1001:
            case 1004:
            case com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi /* 1005 */:
            case com.tencent.ysdk.framework.common.eFlag.Login_NotRegisterRealName /* 3101 */:
            case 3103:
                return i;
            case com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid /* 3100 */:
            case com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_QQ_ACCESS_TOKEN_EXPIRED /* 101001 */:
            case com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_QQ_PAY_TOKEN_EXPIRED /* 101002 */:
                return com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            default:
                return 1002;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int mapRelationRetFlag(int i) {
        com.tencent.ysdk.shell.libware.file.Logger.d("mapRelationRetFlag:" + i);
        if (i != 0 && i != 3201) {
            i = -1;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("mapRelationRetFlag:" + i);
        return i;
    }

    private int mapWakeupRetFlag(int i) {
        com.tencent.ysdk.shell.libware.file.Logger.d("mapWakeupRetFlag:" + i);
        int i2 = 3301;
        switch (i) {
            case com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_URL_LOGIN /* 103002 */:
            case com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_LOCAL_LOGIN /* 103004 */:
                i2 = com.tencent.ysdk.framework.common.eFlag.Wakeup_YSDKLogining;
                break;
            case com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_NEED_SELECT_ACCOUNT /* 103003 */:
                i2 = com.tencent.ysdk.framework.common.eFlag.Wakeup_NeedUserSelectAccount;
                break;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("mapWakeupRetFlag:" + i2);
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyLogin(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        if (userLoginRet == null) {
            userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
            userLoginRet.ret = 1;
            userLoginRet.flag = -1;
            userLoginRet.msg = "notify game login ret is null";
        } else {
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.getEnum(userLoginRet.platform);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN", "UserModule#OnLoginNotify>>>ret:" + userLoginRet.ret);
        android.os.Message message = new android.os.Message();
        message.what = 1;
        message.obj = userLoginRet;
        this.mUiHandler.sendMessage(message);
        notifyLoginToInnerLoginListener(userLoginRet);
    }

    private void notifyLoginToInnerLoginListener(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        if (com.tencent.ysdk.shell.module.user.UserApi.getInnerLoginListener() == null || com.tencent.ysdk.shell.module.user.UserApi.getInnerLoginListener().size() <= 0) {
            return;
        }
        for (com.tencent.ysdk.shell.module.user.UserInnerLoginListener userInnerLoginListener : com.tencent.ysdk.shell.module.user.UserApi.getInnerLoginListener()) {
            if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDebug()) {
                com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, userInnerLoginListener.getClass().toString());
            }
            userInnerLoginListener.OnLoginNotify(userLoginRet);
        }
    }

    private void notifyLoginUnSupport() {
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        userLoginRet.flag = 5002;
        userLoginRet.msg = "wx login is not support in sandbox";
        notifyLogin(userLoginRet);
    }

    private void notifyNoLoginInfo() {
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        userLoginRet.flag = 5001;
        userLoginRet.msg = "sandbox login info not found";
        notifyLogin(userLoginRet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRelation(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
        android.os.Message message = new android.os.Message();
        message.what = 3;
        message.obj = userRelationRet;
        this.mUiHandler.sendMessage(message);
        if (userRelationRet.ret == 0 && 1 == userRelationRet.info_type) {
            try {
                com.tencent.ysdk.module.user.PersonInfo personInfo = (com.tencent.ysdk.module.user.PersonInfo) userRelationRet.persons.firstElement();
                com.tencent.ysdk.shell.framework.YSDKPlayer.getInstance().setPlayerInfo(personInfo.openId, personInfo.nickName, personInfo.pictureMiddle);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRelationAsync(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-notifyGameRelationAsync");
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "notifyRelationAsync start " + userRelationRet.flag);
        com.tencent.ysdk.shell.framework.verification.UserTips.showRelationNotifyTips();
        com.tencent.ysdk.module.user.UserListener userListener = this.mUserListener;
        if (userListener != null) {
            userListener.OnRelationNotify(userRelationRet);
            com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "mUserListener.OnRelationNotify");
        } else {
            try {
                com.tencent.ysdk.shell.module.user.UserNativeListener.OnRelationNotify(userRelationRet);
                com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "UserNativeListener.OnRelationNotify");
            } catch (java.lang.UnsatisfiedLinkError unused) {
                com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "ERROR-UserListener not set");
            }
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "notifyRelationAsync finished");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWakeup(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
        if (wakeupRet != null) {
            wakeupRet.flag = mapWakeupRetFlag(wakeupRet.flag);
        }
        android.os.Message message = new android.os.Message();
        message.what = 2;
        message.obj = wakeupRet;
        this.mUiHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyWakeupAsync(com.tencent.ysdk.module.user.WakeupRet wakeupRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "notifyWakeupAsync start " + wakeupRet.toString());
        com.tencent.ysdk.shell.framework.verification.UserTips.showWakeupNotifyTips();
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-notifyWakeupAsync");
        com.tencent.ysdk.module.user.UserListener userListener = this.mUserListener;
        if (userListener != null) {
            userListener.OnWakeupNotify(wakeupRet);
            com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "mUserListener.OnWakeupNotify");
        } else {
            try {
                com.tencent.ysdk.shell.module.user.UserNativeListener.OnWakeupNotify(wakeupRet);
                com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "mUserListener.OnWakeupNotify");
            } catch (java.lang.UnsatisfiedLinkError unused) {
                com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "ERROR-UserListener not set");
            }
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "notifyWakeupAsync finished");
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void autoLogin() {
        if (com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_HTTP_REQ_AUTO_LOGIN_SWITCH, true)) {
            loginWithLocalRecord(true);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "ysdk auto login has been closed!");
        }
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public com.tencent.ysdk.framework.common.ePlatform getLaunchPlatform() {
        return this.mLoginPlatform;
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public com.tencent.ysdk.framework.common.ePlatform getLoginPlatform() {
        return this.mLoginPlatform;
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        if (com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isLoginInfoVaild(this.mLoginPlatform.val())) {
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().getLoginRecord();
            loginRecord.flag = mapFreeLoginFlag(loginRecord.flag);
            return loginRecord;
        }
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            com.tencent.ysdk.module.user.UserLoginRet loginRecord2 = com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().getLoginRecord();
            loginRecord2.flag = mapQQUserFlag(loginRecord2.flag);
            return loginRecord2;
        }
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            com.tencent.ysdk.module.user.UserLoginRet loginRecord3 = com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().getLoginRecord();
            loginRecord3.flag = mapWXUserFlag(loginRecord3.flag);
            return loginRecord3;
        }
        if (this.mLoginPlatform == com.tencent.ysdk.framework.common.ePlatform.Guest) {
            com.tencent.ysdk.module.user.UserLoginRet loginRecord4 = com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi.getInstance().getLoginRecord();
            loginRecord4.flag = mapGuestUserFlag(loginRecord4.flag);
            return loginRecord4;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "login platform is null");
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.ret = 1;
        userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        return userLoginRet;
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public java.lang.Object getPlatformObject(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "getPlatformObject:" + eplatform.pfStr());
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            return com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().getQQApi();
        }
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            return com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().getWXApi();
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "bad request platformid ");
        return null;
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public java.lang.String getRegisterChannelId() {
        return getLoginRecord().getRegChannel();
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public com.tencent.ysdk.framework.common.ePlatform getStartPlatform() {
        if (this.mStartPlatForm == null) {
            this.mStartPlatForm = com.tencent.ysdk.framework.common.ePlatform.None;
        }
        return this.mStartPlatForm;
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void handleIntent(android.content.Intent intent) {
        int iCheckWakeUpLoginType;
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "handleIntent");
        if (intent == null || intent.getExtras() == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "not start from special platform, local login");
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", "local login");
            if (this.mStartPlatForm == null) {
                this.mStartPlatForm = com.tencent.ysdk.framework.common.ePlatform.None;
            }
            this.mWakeUpLoginType = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_LOCAL_LOGIN;
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", intent);
        com.tencent.ysdk.module.user.WakeupRet wakeupRetHandleIntent = com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().handleIntent(intent);
        if (wakeupRetHandleIntent == null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "qq login handle intent is null");
            wakeupRetHandleIntent = com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().handleIntent(intent);
        }
        if (wakeupRetHandleIntent == null) {
            com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "wx handleIntent ret is null");
            if (this.mStartPlatForm == null) {
                this.mStartPlatForm = com.tencent.ysdk.framework.common.ePlatform.None;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", "qq wx not handle intent");
            this.mWakeUpLoginType = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_LOCAL_LOGIN;
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, wakeupRetHandleIntent.toString());
        this.mLaunchPlatform = com.tencent.ysdk.framework.common.ePlatform.getEnum(wakeupRetHandleIntent.platform);
        if (this.mStartPlatForm == null) {
            this.mStartPlatForm = this.mLaunchPlatform;
        }
        if (103004 == wakeupRetHandleIntent.flag || 103002 == wakeupRetHandleIntent.flag) {
            iCheckWakeUpLoginType = wakeupRetHandleIntent.flag;
        } else {
            iCheckWakeUpLoginType = checkWakeUpLoginType();
            wakeupRetHandleIntent.flag = iCheckWakeUpLoginType;
        }
        notifyWakeup(wakeupRetHandleIntent);
        this.mWakeUpLoginType = iCheckWakeUpLoginType;
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", "login from special platform " + this.mLaunchPlatform.name() + " , loginType " + this.mWakeUpLoginType);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("mWakeUpLoginType:");
        sb.append(this.mWakeUpLoginType);
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, sb.toString());
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "UserModule init start");
        this.mUiHandler = new com.tencent.ysdk.shell.module.user.impl.UserModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().setUserListener(new com.tencent.ysdk.shell.module.user.impl.UserModule.QQUserListenerImp());
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().setUserListener(new com.tencent.ysdk.shell.module.user.impl.UserModule.WXUserListenerImp());
        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi.getInstance().setUserListener(new com.tencent.ysdk.shell.module.user.impl.UserModule.GuestUserListenerImp());
        com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().setUserListener(new com.tencent.ysdk.shell.module.user.impl.UserModule.FreeLoginListenerImp());
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.module.user.UserLoginRet loginRecord2 = com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().getLoginRecord();
        if (loginRecord.ret == 0 && loginRecord2.ret != 0) {
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
        } else if (loginRecord.ret != 0 && loginRecord2.ret == 0) {
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.WX;
        } else if (loginRecord.ret == 0 && loginRecord2.ret == 0) {
            if (loginRecord.update_timestamp > loginRecord2.update_timestamp) {
                this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
            } else {
                this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.WX;
            }
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "UserModule init end：" + this.mLoginPlatform.platformStr());
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void localLogin() {
        loginWithLocalRecord(false);
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void login(com.tencent.ysdk.framework.common.ePlatform eplatform) {
        if (eplatform.val() == com.tencent.ysdk.framework.common.ePlatform.WX.val() && com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv()) {
            java.util.HashMap map = new java.util.HashMap();
            map.put("packageName", com.tencent.ysdk.shell.module.sandbox.SandboxConfig.getPackageName());
            com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender.getInstance().sendIPCEvent(303, map);
            notifyLoginUnSupport();
            return;
        }
        if (eplatform.val() == 1 && com.tencent.ysdk.shell.module.sandbox.SandboxConfig.isSandboxEnv() && !com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isLoginInfoVaild(eplatform.val())) {
            com.tencent.ysdk.shell.module.sandbox.pipe.PipeSender.getInstance().sendIPCEvent(401, null);
            notifyNoLoginInfo();
            return;
        }
        if (com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().isLoginInfoVaild(eplatform.val(), true)) {
            com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().login(eplatform);
            this.mLoginPlatform = eplatform;
            return;
        }
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().login();
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
        } else if (eplatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().login();
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.WX;
        } else if (eplatform != com.tencent.ysdk.framework.common.ePlatform.Guest) {
            com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "bad platform id");
        } else {
            com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi.getInstance().login();
            this.mLoginPlatform = com.tencent.ysdk.framework.common.ePlatform.Guest;
        }
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void logout() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "logout");
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().logout();
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().logout();
        com.tencent.ysdk.shell.module.user.impl.guest.GuestUserApi.getInstance().logout();
        com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().logout();
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        userLoginRet.setLoginType(3);
        userLoginRet.ret = 1;
        userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        userLoginRet.msg = "user logout";
        notifyLoginToInnerLoginListener(userLoginRet);
    }

    int mapWXUserFlag(int i) {
        if (isSucc(i)) {
            return 0;
        }
        if (isReturnSourceFlag(i)) {
            return i;
        }
        if (isTokenInvalid(i)) {
            return com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        }
        return 2004;
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void notifyLoginAsync(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "notifyLoginAsync start " + userLoginRet.toString());
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-notifyGameLoginAsync");
        com.tencent.ysdk.shell.framework.verification.UserTips.showLoginNotifyTips();
        com.tencent.ysdk.module.user.UserListener userListener = this.mUserListener;
        if (userListener != null) {
            userListener.OnLoginNotify(userLoginRet);
            com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "mUserListener.OnLoginNotify");
        } else {
            try {
                com.tencent.ysdk.shell.module.user.UserNativeListener.OnLoginNotify(userLoginRet);
                com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "UserNativeListener.OnLoginNotify");
            } catch (java.lang.UnsatisfiedLinkError unused) {
                com.tencent.ysdk.shell.libware.file.Logger.w("YSDK_DOCTOR", "ERROR-UserListener not set");
            }
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "notifyLoginAsync finished");
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void onActivityResult(int i, int i2, android.content.Intent intent) {
        if (com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isDev()) {
            com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", intent);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQLogin onActivityResult:" + com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().onActivityResult(i, i2, intent));
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQLogin onActivityResult:" + com.tencent.ysdk.shell.module.user.impl.freelogin.FreeLoginUserApiImpl.getInstance().onActivityResult(i, i2, intent));
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void onPause(android.app.Activity activity) {
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void onResume(android.app.Activity activity) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "onResume:" + this.mWakeUpLoginType);
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_CORE", "onResume login type " + this.mWakeUpLoginType);
        if (this.mWakeUpLoginType == 103002) {
            loginWithLaunchRecord();
        }
        this.mWakeUpLoginType = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_LOCAL_LOGIN;
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void queryUserInfo(com.tencent.ysdk.framework.common.ePlatform eplatform, com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "queryUserInfo");
        if (eplatform == com.tencent.ysdk.framework.common.ePlatform.QQ) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserApi.getInstance().queryUserInfo(userRelationListener);
        } else if (eplatform == com.tencent.ysdk.framework.common.ePlatform.WX) {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserApi.getInstance().queryUserInfo(userRelationListener);
        }
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "OK-setUserListener");
        this.mUserListener = userListener;
        autoLoginByYSDK();
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "mUserListener = " + this.mUserListener.toString());
    }

    @Override // com.tencent.ysdk.shell.module.user.UserInterface
    public boolean switchUser(boolean z) {
        if (z) {
            loginWithLaunchRecord();
        } else {
            loginWithLocalRecord(false);
        }
        this.mWakeUpLoginType = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_LOCAL_LOGIN;
        return true;
    }
}
