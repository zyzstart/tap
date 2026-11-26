package com.tencent.ysdk.shell.module.user.impl.wx;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class WXUserModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.user.impl.UserInnerInterface {
    private static final int DEFAULT_WX_ACCESS_TOKEN_BUFFER = 1800;
    protected static final int DEFAULT_WX_ACCESS_TOKEN_EXPIRATION = 7200;
    private static final int DEFAULT_WX_REFRESH_TOKEN_BUFFER = 86400;
    protected static final int DEFAULT_WX_REFRESH_TOKEN_EXPIRATION = 2592000;
    private static final int LOGIN_FLAG_CHECK_ATK = 1;
    private static final int LOGIN_FLAG_NOT_CHECK_ATK = 0;
    public static final java.lang.String LOG_TAG = "YSDK_USER_WX";
    static final int MSG_BG_USER_WX_LAUNCH_LOGIN = 3;
    static final int MSG_BG_USER_WX_LOCAL_LOGIN = 2;
    static final int MSG_BG_USER_WX_QUERY_USER = 4;
    static final int MSG_BG_USER_WX_REALNAME_CHECK_LOGIN = 5;
    static final int MSG_UI_USER_WX_AUTH_LOGIN = 1;
    private static final java.lang.String STAT_EVENT_NAME_FRIST_LOGIN = "YSDK_User_Login_FirstLogin_WX";
    public static final java.lang.String STAT_EVENT_NAME_FRIST_SCAN_LOGIN = "YSDK_User_Login_FirstScanLogin_WX";
    private static final java.lang.String STAT_EVENT_NAME_LAUNCHER_LOGIN = "YSDK_User_Login_LauncherLogin_WX";
    private static final java.lang.String STAT_EVENT_NAME_LOCAL_LOGIN = "YSDK_User_Login_LocalLogin_WX";
    private static final java.lang.String STAT_EVENT_NAME_QUERY_USER = "YSDK_User_UserInfo_WX";
    private static final java.lang.String STAT_EVENT_NAME_TIMER_LOGIN = "YSDK_User_Login_TimerLogin_WX";
    private static final java.lang.String STAT_LOGIN_PLATFORM_WX = "wx";
    private static final java.lang.String WX_LOGIN_SCOPE = "snsapi_userinfo,snsapi_friend,snsapi_message";
    public static final java.lang.String WX_LOGIN_TRANSACTION = "YSDKAuthLogin";
    private static final java.util.Map<java.lang.Integer, com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams> sLoginEventParamsMap = new java.util.HashMap();
    private android.os.Handler mBgHandler;
    private android.os.Handler mUiHandler;
    com.tencent.ysdk.module.user.UserListener mWXUserListener;
    private com.tencent.mm.opensdk.openapi.IWXAPI mWXAPI = null;
    private com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet mLocalLoginRet = null;
    private com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet mLaunchLoginRet = null;
    private boolean mLaunchLoginRetIsFromAuthLogin = false;
    private long mLastRefreshTime = 0;

    private class HandlerInBG extends android.os.Handler {
        public HandlerInBG(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.dealWithHandlerInBGMsg(message);
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
            com.tencent.ysdk.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "loginAsync");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.loginAsync();
        }
    }

    static class LoginEventParams {
        private java.lang.String loginEventName;
        private com.tencent.ysdk.shell.module.stat.StatConstants.EventType loginEventType;
        private java.lang.String loginType;

        public LoginEventParams(java.lang.String str, java.lang.String str2, com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType) {
            this.loginEventName = str;
            this.loginType = str2;
            this.loginEventType = eventType;
        }
    }

    protected class LoginRequest {
        protected static final int REQUEST_TICKET_WX_AUTH_LOGIN = 1;
        protected static final int REQUEST_TICKET_WX_AUTO_LOGIN = 11;
        protected static final int REQUEST_TICKET_WX_AUTO_TOKEN_CHECK = 9;
        protected static final int REQUEST_TICKET_WX_AUTO_TOKEN_REFRESH = 10;
        protected static final int REQUEST_TICKET_WX_LAUNCHER_BAD_LOGIN = 8;
        protected static final int REQUEST_TICKET_WX_LAUNCHER_CODE_LOGIN = 6;
        protected static final int REQUEST_TICKET_WX_LAUNCHER_TOKEN_CHECK = 7;
        protected static final int REQUEST_TICKET_WX_LOCAL_LOGIN = 5;
        protected static final int REQUEST_TICKET_WX_LOCAL_TOKEN_CHECK = 2;
        protected static final int REQUEST_TICKET_WX_LOCAL_TOKEN_REFRESH = 3;
        protected static final int REQUEST_TICKET_WX_SCAN_LOGIN = 12;
        public long requestStartTime;
        public com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet tempRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
        public java.lang.String scope = "";
        public java.lang.String regChannel = "";
        public java.lang.String permission = "";
        public int ticket = 0;
        public boolean isCheckRealName = false;

        protected LoginRequest() {
        }
    }

    private class RegisterRealNameListenerHandle implements com.tencent.ysdk.shell.module.realName.RealNameInnerListener {
        private com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler mWXLoginResponseHandler;

        public RegisterRealNameListenerHandle(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler wXLoginResponseHandler) {
            this.mWXLoginResponseHandler = null;
            this.mWXLoginResponseHandler = wXLoginResponseHandler;
        }

        @Override // com.tencent.ysdk.shell.module.realName.RealNameInnerListener
        public void OnRegisterRealNameNotify(com.tencent.ysdk.framework.common.BaseRet baseRet) {
            com.tencent.ysdk.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "OnRegisterRealNameNotify:" + baseRet.toString());
            if (baseRet.ret == 0) {
                this.mWXLoginResponseHandler.request.tempRet.ret = 0;
                this.mWXLoginResponseHandler.request.tempRet.flag = 0;
                this.mWXLoginResponseHandler.request.tempRet.msg = this.mWXLoginResponseHandler.request.tempRet.msg + "OnRegisterRealNameNotify";
                com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.saveWXUserLoginRetToDB(this.mWXLoginResponseHandler.request.tempRet);
                com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.mWXLoginResponseHandler.request.ticket, this.mWXLoginResponseHandler.request.tempRet, null, this.mWXLoginResponseHandler.request.requestStartTime, true);
                com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(this.mWXLoginResponseHandler.request.tempRet, this.mWXLoginResponseHandler.request.ticket);
                return;
            }
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
            wXUserLoginRet.ret = 1;
            wXUserLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_NotRegisterRealName;
            wXUserLoginRet.msg = "RegisterRealName failed," + baseRet.msg;
            wXUserLoginRet.open_id = this.mWXLoginResponseHandler.request.tempRet.open_id;
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.mWXLoginResponseHandler.request.ticket, wXUserLoginRet, null, this.mWXLoginResponseHandler.request.requestStartTime, true);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(wXUserLoginRet, this.mWXLoginResponseHandler.request.ticket);
        }
    }

    static class RelationRequest {
        private static final int REQUEST_TICKET_WX_USER_LOCAL_BAD = 2;
        private static final int REQUEST_TICKET_WX_USER_LOCAL_SUCC = 1;
        private static final int REQUEST_TICKET_WX_USER_LOGIN_BAD = 3;
        private static final int REQUEST_TICKET_WX_USER_REMOTE_BAD = 4;
        private static final int REQUEST_TICKET_WX_USER_REMOTE_SUCC = 0;
        public long requestStartTime = 0;
        public java.lang.String openId = "";
        public com.tencent.ysdk.module.user.UserRelationListener listener = null;

        RelationRequest() {
        }
    }

    private class WXLoginResponseHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse> {
        private com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest request;

        public WXLoginResponseHandler(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest) {
            this.request = loginRequest;
        }

        private boolean handleHadRegisterRealNameResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse) {
            if ((9 == this.request.ticket || 10 == this.request.ticket) && (100000 == wXUserLoginResponse.flag || 100101 == wXUserLoginResponse.flag || 100102 == wXUserLoginResponse.flag || -65 == wXUserLoginResponse.flag)) {
                com.tencent.ysdk.shell.framework.timertask.BaseTask taskByName = com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance().getTaskByName(com.tencent.ysdk.shell.module.user.impl.UserTask.TASK_NAME);
                if (taskByName != null) {
                    taskByName.letTaskRunEarly();
                }
                return true;
            }
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
            wXUserLoginRet.ret = 1;
            wXUserLoginRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
            wXUserLoginRet.errorCode = wXUserLoginResponse.flag;
            wXUserLoginRet.msg = wXUserLoginResponse.msg;
            wXUserLoginRet.open_id = wXUserLoginResponse.openid;
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.request.ticket, wXUserLoginRet, null, this.request.requestStartTime, true);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(wXUserLoginRet, this.request.ticket);
            return false;
        }

        private void handleNotRegisterRealNameResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse) {
            this.request.tempRet.parseWXLoginResponse(wXUserLoginResponse);
            if (6 == this.request.ticket || 1 == this.request.ticket) {
                com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.RegisterRealNameListenerHandle registerRealNameListenerHandle = com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.new RegisterRealNameListenerHandle(this);
                com.tencent.ysdk.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "showRegisterPage");
                com.tencent.ysdk.shell.module.realName.RealNameApi.getInstance().showRegisterPage(com.tencent.ysdk.framework.common.ePlatform.WX, this.request.tempRet.open_id, this.request.tempRet.access_token, this.request.tempRet.nick_name, registerRealNameListenerHandle);
                return;
            }
            com.tencent.ysdk.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "need register real name but not first login:" + this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.saveWXUserLoginRetToDB(this.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.request.ticket, this.request.tempRet, null, this.request.requestStartTime, true);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
        }

        private void handleSuccResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse) {
            this.request.tempRet.parseWXLoginResponse(wXUserLoginResponse);
            if (com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.isNotRefreshToken(this.request) && com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().checkAntiAddictionLoginRules(wXUserLoginResponse.judgeLoginData, wXUserLoginResponse.visitorLoginData, com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.new WxLoginAntiAddictCallback(this.request), this.request.isCheckRealName)) {
                return;
            }
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.saveWXUserLoginRetToDB(this.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.request.ticket, this.request.tempRet, null, this.request.requestStartTime, true);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
        }

        private void reportWxLoginDetailInfo(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse) {
            try {
                java.util.HashMap map = new java.util.HashMap();
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.WX_LOGIN_REQUEST, this.request.tempRet.toString());
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.WX_LOGIN_RESPONSE_CODE, java.lang.String.valueOf(wXUserLoginResponse.flag));
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, java.lang.String.valueOf(this.request.tempRet.getLoginType()));
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.WX_LOGIN_ATK_EXPIRE_SECOND, java.lang.String.valueOf((this.request.tempRet.access_token_expire - jCurrentTimeMillis) / 1000));
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.WX_LOGIN_RTK_EXPIRE_SECOND, java.lang.String.valueOf((this.request.tempRet.refresh_token_expire - jCurrentTimeMillis) / 1000));
                com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams loginEventParams = com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.sLoginEventParamsMap.containsKey(java.lang.Integer.valueOf(this.request.ticket)) ? (com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams) com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.sLoginEventParamsMap.get(java.lang.Integer.valueOf(this.request.ticket)) : null;
                if (loginEventParams == null) {
                    loginEventParams = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.STAT_EVENT_NAME_FRIST_LOGIN, "0", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default);
                }
                com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_WX_LOGIN_RESPONSE, wXUserLoginResponse.flag, wXUserLoginResponse.msg, 2, wXUserLoginResponse.openid, map, this.request.requestStartTime, true, loginEventParams.loginEventType, "");
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.libware.file.Logger.e(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, e);
            }
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse wXUserLoginResponse) {
            com.tencent.ysdk.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, "loginType:" + this.request.ticket);
            com.tencent.ysdk.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LOG_TAG, wXUserLoginResponse.toString());
            reportWxLoginDetailInfo(wXUserLoginResponse);
            com.tencent.ysdk.libware.file.Logger.d("[REDACTED]", "[REDACTED]" + wXUserLoginResponse.ret + "[REDACTED]" + wXUserLoginResponse.flag);
            if (wXUserLoginResponse.ret == 0) {
                handleSuccResponse(wXUserLoginResponse);
                return;
            }
            if (1200 == wXUserLoginResponse.flag) {
                handleNotRegisterRealNameResponse(wXUserLoginResponse);
            } else if (handleHadRegisterRealNameResponse(wXUserLoginResponse)) {
                return;
            }
            if (this.request.isCheckRealName) {
                com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().onRegisterWindowClose();
            }
        }
    }

    private class WXUserInfoResponseHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserInfoResponse> {
        private com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.RelationRequest request;

        public WXUserInfoResponseHandler(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.RelationRequest relationRequest) {
            this.request = relationRequest;
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserInfoResponse wXUserInfoResponse) {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.dealWithWXUserInfoResponse(wXUserInfoResponse, this.request);
        }
    }

    private class WxLoginAntiAddictCallback implements com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack {
        private com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest request;

        public WxLoginAntiAddictCallback(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest) {
            this.request = loginRequest;
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onExecuteInstruction(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet) {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.saveWXUserLoginRetToDB(this.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.request.ticket, this.request.tempRet, null, this.request.requestStartTime, true);
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onRegisterRealName() {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = this.request.tempRet;
            wXUserLoginRet.ret = 1;
            wXUserLoginRet.flag = 3103;
            wXUserLoginRet.msg = "user need register realname";
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(wXUserLoginRet, this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.request.ticket, wXUserLoginRet, null, this.request.requestStartTime, true);
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onRequestLogin(int i) {
            android.os.Message message = new android.os.Message();
            message.what = 5;
            message.arg1 = i;
            message.obj = this.request.tempRet;
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.mBgHandler.sendMessage(message);
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onVisitorLogin() {
            this.request.tempRet.ret = 0;
            this.request.tempRet.flag = 0;
            this.request.tempRet.msg = "visitor login";
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.saveWXUserLoginRetToDB(this.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.this.reportWXLoginEvent(this.request.ticket, this.request.tempRet, null, this.request.requestStartTime, true);
        }
    }

    static {
        sLoginEventParamsMap.put(1, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_FRIST_LOGIN, "1", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click));
        sLoginEventParamsMap.put(12, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_FRIST_SCAN_LOGIN, "1", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(2, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_LOCAL_LOGIN, "2", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(3, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_LOCAL_LOGIN, "2", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(5, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_LOCAL_LOGIN, "2", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(6, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_LAUNCHER_LOGIN, "4", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(7, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_LAUNCHER_LOGIN, "4", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(8, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_LAUNCHER_LOGIN, "4", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(9, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_TIMER_LOGIN, "3", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(10, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_TIMER_LOGIN, "3", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
        sLoginEventParamsMap.put(11, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_TIMER_LOGIN, "3", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default));
    }

    public WXUserModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER_WX;
    }

    private int checkWXEnv() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "checkWXEnv");
        if (this.mWXAPI.isWXAppInstalled()) {
            return 0;
        }
        com.tencent.ysdk.libware.file.Logger.d("weixin not install");
        return 2000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealWithWXUserInfoResponse(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserInfoResponse wXUserInfoResponse, com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.RelationRequest relationRequest) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, wXUserInfoResponse.toString());
        com.tencent.ysdk.module.user.UserRelationRet userRelationRet = new com.tencent.ysdk.module.user.UserRelationRet();
        userRelationRet.info_type = 1;
        userRelationRet.platform = 2;
        if (wXUserInfoResponse.ret == 0) {
            if (wXUserInfoResponse.userInfo != null) {
                userRelationRet.ret = 0;
                userRelationRet.flag = 0;
                userRelationRet.msg = "wx query user info succ!";
                userRelationRet.persons.add(wXUserInfoResponse.userInfo);
                reportUserInfoEvent(0, userRelationRet.flag, userRelationRet.msg, relationRequest.openId, null, java.lang.System.currentTimeMillis());
            } else {
                userRelationRet.ret = 1;
                userRelationRet.flag = 3201;
                userRelationRet.msg = wXUserInfoResponse.toString();
                reportUserInfoEvent(4, userRelationRet.flag, userRelationRet.msg, relationRequest.openId, null, java.lang.System.currentTimeMillis());
            }
        } else if (100000 == wXUserInfoResponse.flag || 100101 == wXUserInfoResponse.flag || 100102 == wXUserInfoResponse.flag || -65 == wXUserInfoResponse.flag) {
            com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo personInfoByOpenId = com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.readPersonInfoByOpenId(relationRequest.openId);
            if (personInfoByOpenId == null || com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(personInfoByOpenId.openId)) {
                userRelationRet.ret = 1;
                userRelationRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
                userRelationRet.msg = "wx query user info from local cache failed!" + wXUserInfoResponse.toString();
                reportUserInfoEvent(2, userRelationRet.flag, userRelationRet.msg, relationRequest.openId, null, java.lang.System.currentTimeMillis());
            } else {
                userRelationRet.ret = 0;
                userRelationRet.flag = 0;
                userRelationRet.msg = "wx query user info succ from local cache!";
                userRelationRet.persons.add(personInfoByOpenId);
                reportUserInfoEvent(1, userRelationRet.flag, userRelationRet.msg, relationRequest.openId, null, java.lang.System.currentTimeMillis());
            }
        } else {
            userRelationRet.ret = 1;
            userRelationRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
            userRelationRet.msg = wXUserInfoResponse.toString();
            reportUserInfoEvent(4, userRelationRet.flag, userRelationRet.msg, relationRequest.openId, null, java.lang.System.currentTimeMillis());
        }
        if (relationRequest.listener == null) {
            notifyGameRelation(userRelationRet);
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d("notify relation to :" + relationRequest.listener.toString());
        relationRequest.listener.OnRelationNotify(userRelationRet);
    }

    private com.tencent.mm.opensdk.openapi.IWXAPI getIWXAPI() {
        return this.mWXAPI;
    }

    private com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet getWXUserLoginRet() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "getWXUserLoginRet");
        if (this.mLocalLoginRet == null) {
            this.mLocalLoginRet = readLastWXUserLoginRetFormDB();
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        if (jCurrentTimeMillis > this.mLocalLoginRet.refresh_token_expire - com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mLocalLoginRet.refresh_token)) {
                com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "UserLoginRet flag：3100;get login ret failed, on login recrod in db! ");
                com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = this.mLocalLoginRet;
                wXUserLoginRet.ret = 1;
                wXUserLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
                wXUserLoginRet.msg = "get login ret failed, on login recrod in db!";
            } else {
                com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "[REDACTED]");
                com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet2 = this.mLocalLoginRet;
                wXUserLoginRet2.ret = 1;
                wXUserLoginRet2.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
                wXUserLoginRet2.msg = "[REDACTED]";
            }
        } else if (jCurrentTimeMillis > this.mLocalLoginRet.access_token_expire - 1800) {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet3 = this.mLocalLoginRet;
            wXUserLoginRet3.ret = 1;
            wXUserLoginRet3.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_WX_ACCESS_TOKEN_EXPIRED;
            wXUserLoginRet3.msg = "[REDACTED]";
        } else {
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet4 = this.mLocalLoginRet;
            wXUserLoginRet4.ret = 0;
            wXUserLoginRet4.flag = 0;
            wXUserLoginRet4.msg = "wx login succ！";
        }
        return this.mLocalLoginRet;
    }

    private com.tencent.ysdk.module.user.WakeupRet handleLoginIntent(int i, java.lang.String str, android.os.Bundle bundle) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleLoginIntent errCode: " + i);
        this.mLaunchLoginRetIsFromAuthLogin = true;
        java.lang.String string = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID);
        java.lang.String string2 = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_CODE);
        com.tencent.ysdk.module.user.WakeupRet wakeupRet = new com.tencent.ysdk.module.user.WakeupRet();
        wakeupRet.ret = 0;
        wakeupRet.platform = 2;
        wakeupRet.open_id = string == null ? "" : string;
        wakeupRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_URL_LOGIN;
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
        if (string == null) {
            string = "";
        }
        wXUserLoginRet.open_id = string;
        wXUserLoginRet.wx_code = string2 == null ? "" : string2;
        if (i == -2) {
            wXUserLoginRet.ret = 1;
            wXUserLoginRet.flag = 2002;
            wXUserLoginRet.msg = "user cancle this login:;errCode: " + i + ";errMsg: " + str;
        } else if (i != 0) {
            switch (i) {
                case -5:
                    wXUserLoginRet.ret = 1;
                    wXUserLoginRet.flag = 2001;
                    wXUserLoginRet.msg = "login api unsupport:;errCode: " + i + ";errMsg: " + str;
                    break;
                case -4:
                    wXUserLoginRet.ret = 1;
                    wXUserLoginRet.flag = 2003;
                    wXUserLoginRet.msg = "user deny this login:;errCode: " + i + ";errMsg: " + str;
                    break;
                default:
                    wXUserLoginRet.ret = 1;
                    wXUserLoginRet.flag = 2004;
                    wXUserLoginRet.msg = "login failed:;errCode: " + i + ";errMsg: " + str;
                    break;
            }
        } else {
            wXUserLoginRet.ret = 0;
            wXUserLoginRet.flag = 0;
            wXUserLoginRet.msg = "wc code:" + string2;
        }
        this.mLaunchLoginRet = wXUserLoginRet;
        return wakeupRet;
    }

    private com.tencent.ysdk.module.user.WakeupRet handleOnQrcodeIntent(int i, java.lang.String str, android.os.Bundle bundle) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "onQrcode");
        this.mLaunchLoginRetIsFromAuthLogin = false;
        java.lang.String string = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID);
        java.lang.String string2 = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_CODE);
        com.tencent.ysdk.module.user.WakeupRet wakeupRet = new com.tencent.ysdk.module.user.WakeupRet();
        wakeupRet.ret = 0;
        wakeupRet.platform = 2;
        wakeupRet.open_id = string == null ? "" : string;
        wakeupRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_URL_LOGIN;
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
        if (string == null) {
            string = "";
        }
        wXUserLoginRet.open_id = string;
        wXUserLoginRet.wx_code = string2 == null ? "" : string2;
        wXUserLoginRet.flag = i;
        wXUserLoginRet.ret = i;
        if (i == 0) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "wc onQrcode,code:" + string2);
            wXUserLoginRet.ret = 0;
            wXUserLoginRet.flag = 0;
            wXUserLoginRet.msg = "wc onQrcode,code:" + string2;
        } else {
            wXUserLoginRet.ret = 1;
            wXUserLoginRet.flag = 2004;
            wXUserLoginRet.msg = "wc onQrcode error,code:" + string2 + ";errCode: " + i + ";errMsg: " + str;
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, wXUserLoginRet.msg);
        }
        this.mLaunchLoginRet = wXUserLoginRet;
        return wakeupRet;
    }

    private com.tencent.ysdk.module.user.WakeupRet handleOnReqIntent(int i, java.lang.String str, android.os.Bundle bundle) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleOnReqIntent errCode: " + i);
        com.tencent.ysdk.module.user.WakeupRet wakeupRet = new com.tencent.ysdk.module.user.WakeupRet();
        wakeupRet.ret = 0;
        wakeupRet.platform = 2;
        wakeupRet.flag = i;
        java.lang.String string = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_OPENID);
        wakeupRet.open_id = string == null ? "" : string;
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
        if (string == null) {
            string = "";
        }
        wXUserLoginRet.open_id = string;
        if (i == 0) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "wc onQrcode,code:" + i);
            wXUserLoginRet.ret = 0;
            wXUserLoginRet.flag = 0;
            wXUserLoginRet.msg = "wc onQrcode,code:" + str;
        } else {
            wXUserLoginRet.ret = 1;
            wXUserLoginRet.flag = 2004;
            wXUserLoginRet.msg = "wc onQrcode error, errCode: " + i + ";errMsg: " + str;
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, wXUserLoginRet.msg);
        }
        java.lang.String string2 = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.MEDIA_TAG);
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string2)) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback mediaTagName null or empty");
        } else {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback mediaTagName : " + string2);
            wakeupRet.media_tag_name = string2;
        }
        java.lang.String string3 = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.MSG_EXT);
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string3)) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback messageExt : " + string3);
            wakeupRet.message_ext = string3;
        }
        java.lang.String string4 = bundle.getString("country");
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string4)) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback country : " + string3);
            wakeupRet.country = string4;
        }
        java.lang.String string5 = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.USER_LANG);
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string5)) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback lang : " + string3);
            wakeupRet.lang = string5;
        }
        wakeupRet.ext_info = com.tencent.ysdk.shell.libware.util.CommonUtils.bundleToVector(bundle);
        this.mLaunchLoginRet = wXUserLoginRet;
        return wakeupRet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNotRefreshToken(com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest) {
        return (loginRequest.ticket == 9 || loginRequest.ticket == 10 || loginRequest.ticket == 11) ? false : true;
    }

    private void launchLoginAsync() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "launchLoginAsync");
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx launch login");
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = this.mLaunchLoginRet;
        if (wXUserLoginRet != null && !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(wXUserLoginRet.access_token) && !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(wXUserLoginRet.refresh_token)) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "[REDACTED]");
            com.tencent.ysdk.libware.file.Logger.d("[REDACTED]", "[REDACTED]");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest();
            loginRequest.tempRet = wXUserLoginRet;
            loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
            loginRequest.ticket = 7;
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserAutoLoginRequest(loginRequest.ticket, wXUserLoginRet.open_id, wXUserLoginRet.access_token, wXUserLoginRet.refresh_token, wXUserLoginRet.getRegChannel(), 0, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler(loginRequest)));
        } else if (wXUserLoginRet != null && !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(wXUserLoginRet.wx_code)) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "REQUEST_TICKET_WAKEUP_CODE_LOGIN");
            com.tencent.ysdk.libware.file.Logger.d("[REDACTED]", "[REDACTED]");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest2 = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest();
            loginRequest2.requestStartTime = java.lang.System.currentTimeMillis();
            if (this.mLaunchLoginRetIsFromAuthLogin) {
                loginRequest2.ticket = 1;
            } else {
                loginRequest2.ticket = 6;
            }
            loginRequest2.tempRet = wXUserLoginRet;
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserFirstLoginRequest("", wXUserLoginRet.wx_code, loginRequest2.ticket, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler(loginRequest2)));
        } else if (wXUserLoginRet != null) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "wx login failed");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet2 = this.mLaunchLoginRet;
            wXUserLoginRet2.ret = 1;
            wXUserLoginRet2.platform = 2;
            int i = this.mLaunchLoginRetIsFromAuthLogin ? 1 : 8;
            notifyGameLogin(wXUserLoginRet2, i);
            reportWXLoginEvent(i, wXUserLoginRet2, null, java.lang.System.currentTimeMillis(), true);
        } else {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "[REDACTED]");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet3 = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
            wXUserLoginRet3.ret = 1;
            wXUserLoginRet3.platform = 2;
            wXUserLoginRet3.msg = "[REDACTED]";
            int i2 = this.mLaunchLoginRetIsFromAuthLogin ? 1 : 8;
            notifyGameLogin(wXUserLoginRet3, i2);
            reportWXLoginEvent(i2, wXUserLoginRet3, null, java.lang.System.currentTimeMillis(), true);
        }
        this.mLaunchLoginRet = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loginAsync() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "loginAsync");
        com.tencent.ysdk.shell.framework.verification.UserTips.showWXLoginTips();
        int iCheckWXEnv = checkWXEnv();
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
        wXUserLoginRet.platform = 2;
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "code :" + iCheckWXEnv);
        switch (iCheckWXEnv) {
            case 2000:
                com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx not install");
                com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WX NotInstall Enter QRCode");
                wXUserLoginRet.flag = 2000;
                wXUserLoginRet.msg = "Weixin NOT Installed";
                reportWXLoginEvent(12, wXUserLoginRet, null, java.lang.System.currentTimeMillis(), true);
                scanLogin();
                break;
            case 2001:
                com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx not supportApi");
                wXUserLoginRet.ret = 1;
                wXUserLoginRet.flag = 2001;
                wXUserLoginRet.msg = "Weixin API NOT Support";
                notifyGameLogin(wXUserLoginRet, 1);
                reportWXLoginEvent(1, wXUserLoginRet, null, java.lang.System.currentTimeMillis(), true);
                break;
            default:
                com.tencent.mm.opensdk.modelmsg.SendAuth.Req req = new com.tencent.mm.opensdk.modelmsg.SendAuth.Req();
                req.scope = WX_LOGIN_SCOPE;
                req.state = "none";
                req.transaction = WX_LOGIN_TRANSACTION;
                com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "wexin sendReq");
                boolean zSendReq = this.mWXAPI.sendReq(req);
                com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "lauchWXPlatForm wx SendReqRet: " + zSendReq);
                com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx sendReq " + zSendReq);
                if (!zSendReq) {
                    wXUserLoginRet.ret = 1;
                    wXUserLoginRet.flag = 2004;
                    wXUserLoginRet.msg = "Weixin login fail, sendReq false";
                    notifyGameLogin(wXUserLoginRet, 1);
                    reportWXLoginEvent(1, wXUserLoginRet, null, java.lang.System.currentTimeMillis(), true);
                }
                break;
        }
    }

    private void notifyGameRelation(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
        if (userRelationRet == null) {
            userRelationRet = new com.tencent.ysdk.module.user.UserRelationRet();
            userRelationRet.ret = 1;
            userRelationRet.flag = -1;
            userRelationRet.msg = "notify game relation ret is null";
        }
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "notifyGameRelation:" + userRelationRet.toString());
        com.tencent.ysdk.module.user.UserListener userListener = this.mWXUserListener;
        if (userListener == null || userRelationRet == null) {
            com.tencent.ysdk.libware.file.Logger.w(LOG_TAG, "mWXUserListener not set");
        } else {
            userListener.OnRelationNotify(userRelationRet);
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "mWXUserListener.OnRelationNotify");
        }
    }

    private void queryUserInfoAsync(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "queryUserInfoAsync");
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.RelationRequest relationRequest = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.RelationRequest();
        relationRequest.requestStartTime = java.lang.System.currentTimeMillis();
        relationRequest.listener = userRelationListener;
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = getWXUserLoginRet();
        if (wXUserLoginRet.ret == 0) {
            relationRequest.openId = wXUserLoginRet.open_id;
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserInfoRequest(wXUserLoginRet.open_id, wXUserLoginRet.access_token, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXUserInfoResponseHandler(relationRequest)));
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "get local wechat record failed");
        com.tencent.ysdk.module.user.UserRelationRet userRelationRet = new com.tencent.ysdk.module.user.UserRelationRet();
        userRelationRet.ret = 1;
        userRelationRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        userRelationRet.msg = "get local wechat record failed";
        userRelationRet.info_type = 1;
        userRelationRet.platform = 2;
        if (userRelationListener != null) {
            com.tencent.ysdk.libware.file.Logger.d("notify relation to :" + userRelationListener.toString());
            userRelationListener.OnRelationNotify(userRelationRet);
        } else {
            notifyGameRelation(userRelationRet);
        }
        reportUserInfoEvent(0, userRelationRet.flag, userRelationRet.msg, wXUserLoginRet.open_id, null, java.lang.System.currentTimeMillis());
    }

    private com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet readLastWXUserLoginRetFormDB() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "read Last WXUserLoginRet Form DB");
        return com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.readLastUserLoginRet();
    }

    private void refreshWXToken(int i, com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "[REDACTED]");
        if ((java.lang.System.currentTimeMillis() / 1000) - this.mLastRefreshTime < 60) {
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "[REDACTED]");
            return;
        }
        this.mLastRefreshTime = java.lang.System.currentTimeMillis() / 1000;
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest();
        loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
        loginRequest.ticket = i;
        loginRequest.tempRet = wXUserLoginRet;
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserAutoLoginRequest(loginRequest.ticket, wXUserLoginRet.open_id, wXUserLoginRet.access_token, wXUserLoginRet.refresh_token, wXUserLoginRet.getRegChannel(), 0, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler(loginRequest)));
    }

    private void reportUserInfoEvent(int i, int i2, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, long j) {
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap();
        map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOGIN_TICKET, "" + i);
        com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(STAT_EVENT_NAME_QUERY_USER, i2, str, 2, str2, map2, j, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveWXUserLoginRetToDB(com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "save WXUserLoginRet To DB");
        this.mLocalLoginRet = wXUserLoginRet;
        com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.saveUserLoginRet(wXUserLoginRet);
    }

    private void scanLogin() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "lauchQRCodeActivity ");
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx scanLogin");
        com.tencent.ysdk.module.user.impl.wx.qrcode.QRActivity.enterActivity(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity());
    }

    private void verifyRealnameLoginAsync(com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet, int i) {
        if (wXUserLoginRet != null) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_GUEST", "wx guest login visitorSwitch " + i + " , qId " + android.text.TextUtils.isEmpty(com.tencent.ysdk.shell.libware.device.DeviceUtils.getQImei()));
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest();
            loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
            loginRequest.ticket = 2;
            loginRequest.tempRet = wXUserLoginRet;
            loginRequest.isCheckRealName = true;
            com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserAutoLoginRequest wXUserAutoLoginRequest = new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserAutoLoginRequest(loginRequest.ticket, wXUserLoginRet.open_id, wXUserLoginRet.access_token, wXUserLoginRet.refresh_token, wXUserLoginRet.getRegChannel(), 1, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler(loginRequest));
            wXUserAutoLoginRequest.setVisitorSwitch(i);
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(wXUserAutoLoginRequest);
        }
    }

    private com.tencent.ysdk.module.user.UserLoginRet wxUserLoginRet2UserLoginRet(com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WXUserLoginRet2UserLoginRet");
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet(wXUserLoginRet);
        userLoginRet.platform = 2;
        if (wXUserLoginRet != null) {
            com.tencent.ysdk.module.user.UserToken userToken = new com.tencent.ysdk.module.user.UserToken();
            userToken.type = 3;
            userToken.value = wXUserLoginRet.access_token;
            userToken.expiration = wXUserLoginRet.access_token_expire;
            userLoginRet.token.add(userToken);
            com.tencent.ysdk.module.user.UserToken userToken2 = new com.tencent.ysdk.module.user.UserToken();
            userToken2.type = 4;
            userToken2.value = wXUserLoginRet.refresh_token;
            userToken2.expiration = wXUserLoginRet.refresh_token_expire;
            userLoginRet.token.add(userToken2);
            if (102002 == wXUserLoginRet.flag) {
                com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "[REDACTED]");
                userLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_CheckingToken;
                userLoginRet.msg = wXUserLoginRet.msg + "[REDACTED]";
                refreshWXToken(3, this.mLocalLoginRet);
            }
        }
        return userLoginRet;
    }

    public void autoLoginAsync() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "autoLoginAsync");
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = getWXUserLoginRet();
        if (wXUserLoginRet != null && wXUserLoginRet.ret == 0) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "local auto login");
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "REQUEST_TICKET_AUTO_LOGIN");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest();
            loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
            loginRequest.ticket = 9;
            loginRequest.tempRet = wXUserLoginRet;
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserAutoLoginRequest(loginRequest.ticket, wXUserLoginRet.open_id, wXUserLoginRet.access_token, wXUserLoginRet.refresh_token, wXUserLoginRet.getRegChannel(), 1, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler(loginRequest)));
            return;
        }
        if (wXUserLoginRet != null && 102002 == wXUserLoginRet.flag) {
            refreshWXToken(10, wXUserLoginRet);
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "local auto login fail");
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
        wXUserLoginRet2.platform = 2;
        wXUserLoginRet2.ret = 1;
        wXUserLoginRet2.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        wXUserLoginRet2.msg = "[REDACTED]";
        notifyGameLogin(wXUserLoginRet2, 11);
        reportWXLoginEvent(11, wXUserLoginRet2, null, java.lang.System.currentTimeMillis(), true);
    }

    void dealWithHandlerInBGMsg(android.os.Message message) {
        switch (message.what) {
            case 2:
                if (message.arg1 <= 0) {
                    com.tencent.ysdk.libware.file.Logger.w(LOG_TAG, "localLoginAsync is not auto!!!");
                    localLoginAsync();
                } else {
                    com.tencent.ysdk.libware.file.Logger.w(LOG_TAG, "localLoginAsync is auto!!!");
                    autoLoginAsync();
                }
                break;
            case 3:
                launchLoginAsync();
                break;
            case 4:
                if (message.obj != null && (message.obj instanceof com.tencent.ysdk.module.user.UserRelationListener)) {
                    queryUserInfoAsync((com.tencent.ysdk.module.user.UserRelationListener) message.obj);
                } else {
                    com.tencent.ysdk.libware.file.Logger.w(LOG_TAG, "queryUserInfoAsync listener is null");
                    queryUserInfoAsync(null);
                }
                break;
            case 5:
                com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_GUEST", "wx guest login");
                if (message.obj instanceof com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet) {
                    verifyRealnameLoginAsync((com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet) message.obj, message.arg1);
                }
                break;
        }
    }

    void fillReportEventParams(int i, com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet, java.lang.String str, java.util.Map<java.lang.String, java.lang.String> map) {
        try {
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOGIN_TICKET, "" + i);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_IS_FIRST, java.lang.String.valueOf(wXUserLoginRet.getUserType()));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            map.put("regChannel", wXUserLoginRet.getRegChannel());
            map.put("offerid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_PLATFORM, "wx");
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, str);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_LOCAL_ERROR_CODE, java.lang.String.valueOf(wXUserLoginRet.flag));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_RESPONSE_ERROR_CODE, java.lang.String.valueOf(wXUserLoginRet.errorCode));
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_IS_VISITOR, com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState() ? "1" : "0");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_IS_VISITOR);
            sb.append(com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState() ? "1" : "0");
            com.tencent.ysdk.libware.file.Logger.d(sb.toString());
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.libware.file.Logger.e(LOG_TAG, e);
        }
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord() {
        return this.mLaunchLoginRet;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WX OK-getLoginRecord");
        return wxUserLoginRet2UserLoginRet(getWXUserLoginRet());
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public java.lang.Object getPlatformObject() {
        return this.mWXAPI;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "WX handleIntent");
        android.os.Bundle bundle = new android.os.Bundle();
        if (intent != null) {
            try {
                if (intent.getExtras() != null) {
                    bundle.putAll(intent.getExtras());
                    if (!bundle.containsKey(com.tencent.ysdk.module.user.impl.wx.WXKey.CALLBACK_FLAG)) {
                        return null;
                    }
                    java.lang.String string = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.CALLBACK_FLAG);
                    java.lang.String string2 = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.TRANSACTION_TYPE);
                    int i = bundle.getInt(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_CODE);
                    java.lang.String string3 = bundle.getString(com.tencent.ysdk.module.user.impl.wx.WXKey.ERROR_DESC);
                    com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback flag: " + i);
                    com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback wxCallbackFlag: " + string);
                    com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "handleWXCallback transaction: " + string2);
                    if (!"onReq".equals(string)) {
                        if (WX_LOGIN_TRANSACTION.equals(string2)) {
                            return handleLoginIntent(i, string3, bundle);
                        }
                        return null;
                    }
                    com.tencent.ysdk.module.user.WakeupRet wakeupRetHandleOnReqIntent = handleOnReqIntent(i, string3, bundle);
                    com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx handleIntent " + wakeupRetHandleOnReqIntent.ret);
                    return wakeupRetHandleOnReqIntent;
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        com.tencent.ysdk.libware.file.Logger.w(LOG_TAG, "WX handleIntent Bundle EMPTY");
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx handleIntent intent or extras null");
        return null;
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WXUserModule init start");
        java.lang.String wXAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getWXAppId();
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(wXAppId)) {
            com.tencent.ysdk.libware.file.Logger.e("appid may be null");
        } else {
            this.mWXAPI = com.tencent.mm.opensdk.openapi.WXAPIFactory.createWXAPI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), wXAppId);
            this.mWXAPI.registerApp(wXAppId);
        }
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WeixinSDKVersionName: android 5.1.6");
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WeixinSDKVersionCode: 620824064");
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WeixinClient: " + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPlatformAppVersion(com.tencent.ysdk.framework.common.ePlatform.WX));
        this.mUiHandler = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        this.mBgHandler = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.HandlerInBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(1));
        this.mLocalLoginRet = getWXUserLoginRet();
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WXUserModule init start");
    }

    boolean isLoginTypeAuth(int i) {
        return i == 1 || i == 6 || i == 7 || i == 8;
    }

    boolean isLoginTypeAuto(int i) {
        return i == 5 || i == 2 || i == 3;
    }

    boolean isLoginTypeTimer(int i) {
        return i == 11 || i == 9 || i == 10;
    }

    public void localLoginAsync() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "localLoginAsync");
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet = getWXUserLoginRet();
        if (wXUserLoginRet != null && wXUserLoginRet.ret == 0) {
            com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx local login async");
            com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "[REDACTED]");
            com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginRequest();
            loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
            loginRequest.ticket = 2;
            loginRequest.tempRet = wXUserLoginRet;
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserAutoLoginRequest(loginRequest.ticket, wXUserLoginRet.open_id, wXUserLoginRet.access_token, wXUserLoginRet.refresh_token, wXUserLoginRet.getRegChannel(), 1, new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.WXLoginResponseHandler(loginRequest)));
            return;
        }
        if (wXUserLoginRet != null && 102002 == wXUserLoginRet.flag) {
            refreshWXToken(3, wXUserLoginRet);
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "wx local login async fail");
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
        wXUserLoginRet2.platform = 2;
        wXUserLoginRet2.ret = 1;
        wXUserLoginRet2.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        wXUserLoginRet2.msg = "[REDACTED]";
        notifyGameLogin(wXUserLoginRet2, 5);
        reportWXLoginEvent(5, wXUserLoginRet2, null, java.lang.System.currentTimeMillis(), true);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void login() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "WX OK-login");
        android.os.Message message = new android.os.Message();
        message.what = 1;
        this.mUiHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLaunchRecord() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "WX OK-loginWithLaunchRecord");
        android.os.Message message = new android.os.Message();
        message.what = 3;
        this.mBgHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "WX OK-loginWithLocalRecord");
        android.os.Message message = new android.os.Message();
        message.what = 2;
        message.arg1 = !z ? 0 : 1;
        this.mBgHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithMemory() {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "WX not support this kind of login");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void logout() {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "logout");
        int iClearUserLoginRet = com.tencent.ysdk.shell.module.user.impl.wx.db.WXUserTableModel.clearUserLoginRet();
        this.mLocalLoginRet = null;
        this.mLaunchLoginRet = null;
        com.tencent.ysdk.libware.file.Logger.d("logoutAsync userNum:" + iClearUserLoginRet);
    }

    public void notifyGameLogin(com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet, int i) {
        if (wXUserLoginRet == null) {
            wXUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet();
            wXUserLoginRet.ret = 1;
            wXUserLoginRet.flag = 2004;
            wXUserLoginRet.msg = "notify game login ret is null";
        }
        if (isLoginTypeAuth(i)) {
            wXUserLoginRet.setLoginType(0);
        } else if (isLoginTypeAuto(i)) {
            wXUserLoginRet.setLoginType(1);
        } else if (isLoginTypeTimer(i)) {
            wXUserLoginRet.setLoginType(2);
        }
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "notifyGameLogin:" + wXUserLoginRet.toString());
        if (this.mWXUserListener == null) {
            com.tencent.ysdk.libware.file.Logger.w(LOG_TAG, "mWXUserListener not set");
            return;
        }
        com.tencent.ysdk.libware.file.Logger.d("YSDK_LOGIN_WX", "notify login ret " + wXUserLoginRet.ret + " , flag " + wXUserLoginRet.flag);
        this.mWXUserListener.OnLoginNotify(wxUserLoginRet2UserLoginRet(wXUserLoginRet));
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "mWXUserListener.OnLoginNotify");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        return false;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.libware.file.Logger.d(LOG_TAG, "WX OK-queryUserInfo");
        android.os.Message messageObtainMessage = this.mBgHandler.obtainMessage(4);
        messageObtainMessage.obj = userRelationListener;
        this.mBgHandler.sendMessage(messageObtainMessage);
    }

    protected void reportWXLoginEvent(int i, com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet, java.util.Map<java.lang.String, java.lang.String> map, long j, boolean z) {
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams loginEventParams = sLoginEventParamsMap.containsKey(java.lang.Integer.valueOf(i)) ? sLoginEventParamsMap.get(java.lang.Integer.valueOf(i)) : null;
        if (loginEventParams == null) {
            loginEventParams = new com.tencent.ysdk.shell.module.user.impl.wx.WXUserModule.LoginEventParams(STAT_EVENT_NAME_FRIST_LOGIN, "0", com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default);
        }
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap();
        fillReportEventParams(i, wXUserLoginRet, loginEventParams.loginType, map2);
        reportWxLoginEvent(wXUserLoginRet, j, z, loginEventParams.loginEventType, map2);
    }

    void reportWxLoginEvent(com.tencent.ysdk.shell.module.user.impl.wx.WXUserLoginRet wXUserLoginRet, long j, boolean z, com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType, java.util.Map<java.lang.String, java.lang.String> map) {
        if (wXUserLoginRet.flag == 0) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_SUCCESS, wXUserLoginRet.flag, wXUserLoginRet.msg, 2, wXUserLoginRet.open_id, map, j, z, eventType, "");
        } else {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_FAIL, wXUserLoginRet.flag, wXUserLoginRet.msg, 2, wXUserLoginRet.open_id, map, j, z, eventType, "");
        }
    }

    @Override // com.tencent.ysdk.shell.module.Module
    protected void selfCheck() {
        com.tencent.ysdk.shell.module.user.impl.wx.WXUserModuleSelfCheck.checkSDKConfig();
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.libware.file.Logger.d("YSDK_DOCTOR", "WX OK-setUserListener");
        this.mWXUserListener = userListener;
    }
}
