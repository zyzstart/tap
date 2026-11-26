package com.tencent.ysdk.shell.module.user.impl.qq;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQUserModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.user.impl.UserInnerInterface {
    private static final int DEFAULT_QQ_ACCESSTOKEN_BUFFER = 86400;
    private static final int DEFAULT_QQ_ACCESSTOKEN_EXPIRATION = 7776000;
    private static final int DEFAULT_QQ_PATYOKEN_EXPIRATION = 518400;
    private static final int DEFAULT_QQ_PAYTOKEN_BUFFER = 43200;
    private static final java.lang.String EVENT_QQ_FIRST_LOGIN = "YSDK_User_Login_FirstLogin_QQ";
    private static final java.lang.String EVENT_QQ_LAUNCHER_LOGIN = "YSDK_User_Login_LauncherLogin_QQ";
    private static final java.lang.String EVENT_QQ_LOCAL_LOGIN = "YSDK_User_Login_LocalLogin_QQ";
    private static final java.lang.String EVENT_QQ_Timer_LOGIN = "YSDK_User_Login_TimerLogin_QQ";
    public static final java.lang.String LOG_TAG = "YSDK_USER_QQ";
    protected static final int MSG_QQ_AUTH_LOGIN = 1;
    protected static final int MSG_QQ_LAUNCH_LOGIN = 3;
    protected static final int MSG_QQ_LOCAL_LOGIN = 2;
    protected static final int MSG_QQ_QUERY_USER = 4;
    protected static final int MSG_QQ_REALNAME_LOGIN = 5;
    private static final java.lang.String STAT_EVENT_NAME_QUERY_USER = "YSDK_User_UserInfo_QQ";
    private static final java.lang.String STAT_LOGIN_PLATFORM_QQ = "qq";
    private com.tencent.tauth.Tencent mTencent = null;
    private android.content.Context mContext = null;
    private android.os.Handler mUiHandler = null;
    private android.os.Handler mBgHandler = null;
    private com.tencent.ysdk.module.user.UserListener mUserListener = null;
    private com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet mLocalLoginRet = null;
    private com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet mLaunchLoginRet = null;
    private com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQLoginCallback mLoginCallback = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQLoginCallback();

    private class HandlerInBG extends android.os.Handler {
        public HandlerInBG(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.dealWithBGMessage(message);
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
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.authLoginAsync();
        }
    }

    protected class LoginRequest {
        private static final int REQUEST_TICKET_QQ_AUTO_LOGIN = 2;
        private static final int REQUEST_TICKET_QQ_USER_CHECK_TOKEN = 1;
        private static final int REQUEST_TICKET_QQ_USER_LOGIN = 0;
        private static final int REQUEST_TICKET_QQ_WAKEUP_LOGIN = 3;
        public boolean isCheckRealName = false;
        public long requestStartTime;
        public com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet tempRet;
        public int ticket;

        protected LoginRequest() {
        }
    }

    private class QQLoginAntiAddictCallback implements com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack {
        private java.util.Map<java.lang.String, java.lang.String> map;
        private com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest request;

        public QQLoginAntiAddictCallback(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest, java.util.Map<java.lang.String, java.lang.String> map) {
            this.request = loginRequest;
            this.map = map;
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onExecuteInstruction(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.setLoginInfoToOpenSDK(this.request.tempRet.open_id, this.request.tempRet.access_token, this.request.tempRet.access_token_expire);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.saveQQUserLoginRetToDB(this.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.request.ticket, this.request.tempRet, this.map, this.request.requestStartTime);
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onRegisterRealName() {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = this.request.tempRet;
            qQUserLoginRet.ret = 1;
            qQUserLoginRet.flag = 3103;
            qQUserLoginRet.msg = "user need register realname";
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(qQUserLoginRet, this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.request.ticket, qQUserLoginRet, this.map, this.request.requestStartTime);
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onRequestLogin(int i) {
            android.os.Message message = new android.os.Message();
            message.what = 5;
            message.arg1 = i;
            message.obj = this.request.tempRet;
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.mBgHandler.sendMessage(message);
        }

        @Override // com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack
        public void onVisitorLogin() {
            this.request.tempRet.ret = 0;
            this.request.tempRet.flag = 0;
            this.request.tempRet.msg = "visitor login";
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.setLoginInfoToOpenSDK(this.request.tempRet.open_id, this.request.tempRet.access_token, this.request.tempRet.access_token_expire);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.saveQQUserLoginRetToDB(this.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.request.ticket, this.request.tempRet, this.map, this.request.requestStartTime);
        }
    }

    private class QQLoginCallback implements com.tencent.tauth.IUiListener {
        private com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest mRequest;

        public QQLoginCallback() {
        }

        public QQLoginCallback(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest) {
            this.mRequest = loginRequest;
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            com.tencent.ysdk.shell.libware.file.Logger.d("QQLoginCallback onCancel");
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
            qQUserLoginRet.ret = 1;
            qQUserLoginRet.flag = 1001;
            qQUserLoginRet.msg = "qq login user canceled";
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(qQUserLoginRet, this.mRequest.ticket);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.mRequest.ticket, qQUserLoginRet, null, this.mRequest.requestStartTime);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            com.tencent.ysdk.shell.libware.file.Logger.d("QQLoginCallback onComplete");
            if (!(obj instanceof org.json.JSONObject)) {
                com.tencent.ysdk.shell.libware.file.Logger.d(" YSDK_LOGIN_QQ", "qq login callback obj err");
                com.tencent.ysdk.shell.libware.file.Logger.d("QQLoginCallback onComplete ，arg0 instanceof JSONObject ");
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
                qQUserLoginRet.ret = 1;
                qQUserLoginRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_QQ_PARSE_JASON_ERROR;
                qQUserLoginRet.msg = "QQLoginCallback onComplete ，arg0 instanceof JSONObject ";
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.mRequest.ticket, qQUserLoginRet, null, this.mRequest.requestStartTime);
                return;
            }
            org.json.JSONObject jSONObject = (org.json.JSONObject) obj;
            try {
                java.lang.String strOptString = jSONObject.optString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
                long j = java.lang.Integer.parseInt(jSONObject.optString(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN));
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
                qQUserLoginRet2.open_id = jSONObject.optString("openid");
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
                if (android.text.TextUtils.isEmpty(strOptString)) {
                    qQUserLoginRet2.ret = 1;
                    qQUserLoginRet2.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_QQ_NO_ACESS_TOKEN;
                } else {
                    qQUserLoginRet2.ret = 0;
                    qQUserLoginRet2.flag = 0;
                    qQUserLoginRet2.access_token = strOptString;
                    qQUserLoginRet2.access_token_expire = j + jCurrentTimeMillis;
                }
                qQUserLoginRet2.pay_token = jSONObject.getString("[REDACTED]");
                qQUserLoginRet2.pay_token_expire = jCurrentTimeMillis + 518400;
                qQUserLoginRet2.pf = jSONObject.getString("pf");
                qQUserLoginRet2.pf_key = jSONObject.getString("pfkey");
                qQUserLoginRet2.create_timestamp = java.lang.System.currentTimeMillis();
                if (qQUserLoginRet2.ret != 0) {
                    com.tencent.ysdk.shell.libware.file.Logger.d("[REDACTED]", "[REDACTED]");
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(qQUserLoginRet2, this.mRequest.ticket);
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.mRequest.ticket, qQUserLoginRet2, null, this.mRequest.requestStartTime);
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.d("[REDACTED]", "[REDACTED]");
                    this.mRequest.tempRet = qQUserLoginRet2;
                    com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckRequest(this.mRequest.ticket, qQUserLoginRet2, com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.new QQUserCheckResponesHandler(this.mRequest)));
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet3 = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
                qQUserLoginRet3.platform = 1;
                qQUserLoginRet3.ret = 1;
                qQUserLoginRet3.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_QQ_PARSE_JASON_ERROR;
                qQUserLoginRet3.msg = e.toString();
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(qQUserLoginRet3, this.mRequest.ticket);
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.mRequest.ticket, qQUserLoginRet3, null, this.mRequest.requestStartTime);
            }
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
            qQUserLoginRet.platform = 1;
            qQUserLoginRet.ret = 1;
            qQUserLoginRet.flag = 1002;
            qQUserLoginRet.msg = "QQLoginCallback onError " + uiError.errorCode + " " + uiError.errorDetail;
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(qQUserLoginRet, this.mRequest.ticket);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.mRequest.ticket, qQUserLoginRet, null, this.mRequest.requestStartTime);
        }

        @Override // com.tencent.tauth.IUiListener
        public void onWarning(int i) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LOG_TAG, "QQLoginCallback onWarning " + i);
        }

        public void setLoginRequest(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest) {
            this.mRequest = loginRequest;
        }
    }

    private class QQQureyUserInfoResponesHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse> {
        private com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.RelationRequest request;

        public QQQureyUserInfoResponesHandler(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.RelationRequest relationRequest) {
            this.request = relationRequest;
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.user.impl.qq.request.QQQueryUserInfoResponse qQQueryUserInfoResponse) {
            com.tencent.ysdk.module.user.UserRelationRet userRelationRet = new com.tencent.ysdk.module.user.UserRelationRet();
            userRelationRet.info_type = 1;
            userRelationRet.platform = 1;
            if (qQQueryUserInfoResponse.ret == 0) {
                if (qQQueryUserInfoResponse.info != null) {
                    userRelationRet.ret = 0;
                    userRelationRet.flag = 0;
                    userRelationRet.msg = "qq query user info succ!";
                    userRelationRet.persons.add(qQQueryUserInfoResponse.info);
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportUserInfoEvent(0, userRelationRet.flag, userRelationRet.msg, this.request.openId, null, this.request.requestStartTime);
                } else {
                    userRelationRet.ret = 1;
                    userRelationRet.flag = 3201;
                    userRelationRet.msg = qQQueryUserInfoResponse.toString();
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportUserInfoEvent(4, userRelationRet.flag, userRelationRet.msg, this.request.openId, null, this.request.requestStartTime);
                }
            } else if (100000 == qQQueryUserInfoResponse.flag || 100101 == qQQueryUserInfoResponse.flag || 100102 == qQQueryUserInfoResponse.flag || -65 == qQQueryUserInfoResponse.flag) {
                com.tencent.ysdk.shell.module.user.impl.UserInnerPersonInfo personInfoByOpenId = com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserTableModel.readPersonInfoByOpenId(this.request.openId);
                if (personInfoByOpenId == null || com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(personInfoByOpenId.openId)) {
                    userRelationRet.ret = 1;
                    userRelationRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
                    userRelationRet.msg = "qq query user info from local cache failed!" + qQQueryUserInfoResponse.toString();
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportUserInfoEvent(2, userRelationRet.flag, userRelationRet.msg, this.request.openId, null, this.request.requestStartTime);
                } else {
                    userRelationRet.ret = 0;
                    userRelationRet.flag = 0;
                    userRelationRet.msg = "qq query user info succ from local cache!";
                    userRelationRet.persons.add(personInfoByOpenId);
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportUserInfoEvent(1, userRelationRet.flag, userRelationRet.msg, this.request.openId, null, this.request.requestStartTime);
                }
            } else {
                userRelationRet.ret = 1;
                userRelationRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
                userRelationRet.msg = qQQueryUserInfoResponse.toString();
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportUserInfoEvent(4, userRelationRet.flag, userRelationRet.msg, this.request.openId, null, this.request.requestStartTime);
            }
            if (this.request.listener == null) {
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameRelation(userRelationRet);
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d("notify relation to :" + this.request.listener.toString());
            this.request.listener.OnRelationNotify(userRelationRet);
        }
    }

    private class QQUserCheckResponesHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse> {
        private com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest request;

        public QQUserCheckResponesHandler(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest) {
            this.request = loginRequest;
        }

        private void handleNotRegisterRealName(com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse qQUserCheckResponse) {
            this.request.tempRet.parseQQLoginResponse(qQUserCheckResponse);
            if (this.request.ticket == 0 || 3 == this.request.ticket) {
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.RegisterRealNameListenerHandle registerRealNameListenerHandle = com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.new RegisterRealNameListenerHandle(this);
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LOG_TAG, "showRegisterPage");
                com.tencent.ysdk.shell.module.realName.RealNameApi.getInstance().showRegisterPage(com.tencent.ysdk.framework.common.ePlatform.QQ, this.request.tempRet.open_id, this.request.tempRet.access_token, this.request.tempRet.nick_name, registerRealNameListenerHandle);
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LOG_TAG, "need register real name but not first login:" + this.request.ticket);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.setLoginInfoToOpenSDK(this.request.tempRet.open_id, this.request.tempRet.access_token, this.request.tempRet.access_token_expire);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.saveQQUserLoginRetToDB(this.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_IS_FIRST, java.lang.String.valueOf(qQUserCheckResponse.first));
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.request.ticket, this.request.tempRet, map, this.request.requestStartTime);
        }

        private boolean isNotNeedNotifyUser(com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse qQUserCheckResponse) {
            return this.request.ticket == 2 && (100000 == qQUserCheckResponse.flag || 100101 == qQUserCheckResponse.flag || 100102 == qQUserCheckResponse.flag || -65 == qQUserCheckResponse.flag);
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckResponse qQUserCheckResponse) {
            if (qQUserCheckResponse.ret == 0) {
                this.request.tempRet.parseQQLoginResponse(qQUserCheckResponse);
                java.util.HashMap map = new java.util.HashMap();
                map.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_IS_FIRST, java.lang.String.valueOf(qQUserCheckResponse.first));
                if (this.request.ticket == 2) {
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.request.ticket, this.request.tempRet, map, this.request.requestStartTime);
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.setLoginInfoToOpenSDK(this.request.tempRet.open_id, this.request.tempRet.access_token, this.request.tempRet.access_token_expire);
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.saveQQUserLoginRetToDB(this.request.tempRet);
                    com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
                    return;
                }
                if (com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().checkAntiAddictionLoginRules(qQUserCheckResponse.judgeLoginData, qQUserCheckResponse.visitorLoginData, com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.new QQLoginAntiAddictCallback(this.request, map), this.request.isCheckRealName)) {
                    return;
                }
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.request.ticket, this.request.tempRet, map, this.request.requestStartTime);
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.setLoginInfoToOpenSDK(this.request.tempRet.open_id, this.request.tempRet.access_token, this.request.tempRet.access_token_expire);
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.saveQQUserLoginRetToDB(this.request.tempRet);
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(this.request.tempRet, this.request.ticket);
                return;
            }
            if (1200 == qQUserCheckResponse.flag) {
                handleNotRegisterRealName(qQUserCheckResponse);
            } else {
                if (isNotNeedNotifyUser(qQUserCheckResponse)) {
                    return;
                }
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
                qQUserLoginRet.ret = 1;
                qQUserLoginRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.YSDK_SERVER_ERROR;
                qQUserLoginRet.errorCode = qQUserCheckResponse.flag;
                qQUserLoginRet.msg = qQUserCheckResponse.msg;
                qQUserLoginRet.open_id = this.request.tempRet.open_id;
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(qQUserLoginRet, this.request.ticket);
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.request.ticket, qQUserLoginRet, null, this.request.requestStartTime);
            }
            if (this.request.isCheckRealName) {
                com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().onRegisterWindowClose();
            }
        }
    }

    private class RegisterRealNameListenerHandle implements com.tencent.ysdk.shell.module.realName.RealNameInnerListener {
        private com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQUserCheckResponesHandler mQQLoginResponseHandler;

        public RegisterRealNameListenerHandle(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQUserCheckResponesHandler qQUserCheckResponesHandler) {
            this.mQQLoginResponseHandler = null;
            this.mQQLoginResponseHandler = qQUserCheckResponesHandler;
        }

        @Override // com.tencent.ysdk.shell.module.realName.RealNameInnerListener
        public void OnRegisterRealNameNotify(com.tencent.ysdk.framework.common.BaseRet baseRet) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LOG_TAG, "OnRegisterRealNameNotify:" + baseRet.toString());
            if (baseRet.ret != 0) {
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
                qQUserLoginRet.ret = 1;
                qQUserLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_NotRegisterRealName;
                qQUserLoginRet.msg = "RegisterRealName failed," + baseRet.msg;
                qQUserLoginRet.open_id = this.mQQLoginResponseHandler.request.tempRet.open_id;
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.mQQLoginResponseHandler.request.ticket, qQUserLoginRet, null, this.mQQLoginResponseHandler.request.requestStartTime);
                com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(qQUserLoginRet, this.mQQLoginResponseHandler.request.ticket);
                return;
            }
            this.mQQLoginResponseHandler.request.tempRet.ret = 0;
            this.mQQLoginResponseHandler.request.tempRet.flag = 0;
            this.mQQLoginResponseHandler.request.tempRet.msg = this.mQQLoginResponseHandler.request.tempRet.msg + "OnRegisterRealNameNotify";
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.saveQQUserLoginRetToDB(this.mQQLoginResponseHandler.request.tempRet);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.setLoginInfoToOpenSDK(this.mQQLoginResponseHandler.request.tempRet.open_id, this.mQQLoginResponseHandler.request.tempRet.access_token, this.mQQLoginResponseHandler.request.tempRet.access_token_expire);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.reportQQLoginEvent(this.mQQLoginResponseHandler.request.ticket, this.mQQLoginResponseHandler.request.tempRet, null, this.mQQLoginResponseHandler.request.requestStartTime);
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.this.notifyGameLogin(this.mQQLoginResponseHandler.request.tempRet, this.mQQLoginResponseHandler.request.ticket);
        }
    }

    private class RelationRequest {
        private static final int REQUEST_TICKET_QQ_USER_LOCAL_BAD = 2;
        private static final int REQUEST_TICKET_QQ_USER_LOCAL_SUCC = 1;
        private static final int REQUEST_TICKET_QQ_USER_LOGIN_BAD = 3;
        private static final int REQUEST_TICKET_QQ_USER_REMOTE_BAD = 4;
        private static final int REQUEST_TICKET_QQ_USER_REMOTE_SUCC = 0;
        public com.tencent.ysdk.module.user.UserRelationListener listener;
        public java.lang.String openId;
        public long requestStartTime;

        private RelationRequest() {
            this.requestStartTime = 0L;
            this.openId = "";
            this.listener = null;
        }
    }

    public QQUserModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_USER_QQ;
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "new QQUserModule");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void authLoginAsync() {
        com.tencent.ysdk.shell.framework.verification.UserTips.showQQLoginTips();
        android.app.Activity activity = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity();
        if (this.mTencent == null || activity == null) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
            qQUserLoginRet.platform = 1;
            qQUserLoginRet.ret = 1;
            qQUserLoginRet.flag = com.tencent.ysdk.framework.common.eFlag.QQ_NotSupportApi;
            qQUserLoginRet.msg = "qq sdk init failed";
            notifyGameLogin(qQUserLoginRet, 0);
            reportQQLoginEvent(0, qQUserLoginRet, null, java.lang.System.currentTimeMillis());
            return;
        }
        setLoginInfoToOpenSDK("", "", 0L);
        com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, activity.toString());
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest();
        loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
        loginRequest.ticket = 0;
        this.mLoginCallback.setLoginRequest(loginRequest);
        this.mTencent.login(activity, "all", this.mLoginCallback);
    }

    private void autoLoginAsync() {
        com.tencent.ysdk.shell.libware.file.Logger.d("autoLoginAsync");
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = getQQUserLoginRet();
        if (qQUserLoginRet == null || qQUserLoginRet.ret != 0) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
            qQUserLoginRet2.platform = 1;
            qQUserLoginRet2.ret = 1;
            qQUserLoginRet2.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            qQUserLoginRet2.msg = "[REDACTED]";
            notifyGameLogin(qQUserLoginRet2, 2);
            reportQQLoginEvent(2, qQUserLoginRet2, null, java.lang.System.currentTimeMillis());
            return;
        }
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest();
        loginRequest.tempRet = qQUserLoginRet;
        loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
        loginRequest.ticket = 2;
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckRequest(loginRequest.ticket, qQUserLoginRet, new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQUserCheckResponesHandler(loginRequest)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dealWithBGMessage(android.os.Message message) {
        switch (message.what) {
            case 2:
                if ((message.obj instanceof java.lang.Boolean) && ((java.lang.Boolean) message.obj).booleanValue()) {
                    com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "localLoginAsync is auto!!!");
                    autoLoginAsync();
                } else {
                    com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "localLoginAsync is not auto!!!");
                    localLoginAsync();
                }
                break;
            case 3:
                launchLoginAsync();
                break;
            case 4:
                if (!(message.obj instanceof com.tencent.ysdk.module.user.UserRelationListener)) {
                    com.tencent.ysdk.shell.libware.file.Logger.w(LOG_TAG, "queryUserInfoAsync listener is null");
                    queryUserInfoAsync(null);
                } else {
                    queryUserInfoAsync((com.tencent.ysdk.module.user.UserRelationListener) message.obj);
                }
                break;
            case 5:
                if (message.obj instanceof com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet) {
                    verifyRealnameLoginAsync((com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet) message.obj, message.arg1);
                }
                break;
        }
    }

    private com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet getQQUserLoginRet() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "getQQUserLoginRet");
        if (this.mLocalLoginRet == null) {
            this.mLocalLoginRet = readLastQQUserLoginRetFormDB();
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
        if (jCurrentTimeMillis > this.mLocalLoginRet.access_token_expire - com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = this.mLocalLoginRet;
            qQUserLoginRet.ret = 1;
            qQUserLoginRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_QQ_ACCESS_TOKEN_EXPIRED;
        } else if (jCurrentTimeMillis > this.mLocalLoginRet.pay_token_expire - 43200) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet2 = this.mLocalLoginRet;
            qQUserLoginRet2.ret = 1;
            qQUserLoginRet2.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_QQ_PAY_TOKEN_EXPIRED;
        } else {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet3 = this.mLocalLoginRet;
            qQUserLoginRet3.ret = 0;
            qQUserLoginRet3.flag = 0;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "getQQUserLoginRet：" + this.mLocalLoginRet.flag);
        return this.mLocalLoginRet;
    }

    private com.tencent.ysdk.module.user.WakeupRet handleQQIntent(android.content.Intent intent) {
        android.os.Bundle extras = intent.getExtras();
        java.lang.String string = extras.getString("openid");
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string)) {
            string = extras.getString("current_uin");
        }
        com.tencent.ysdk.module.user.WakeupRet wakeupRet = new com.tencent.ysdk.module.user.WakeupRet();
        wakeupRet.platform = 1;
        wakeupRet.open_id = string;
        wakeupRet.ext_info = com.tencent.ysdk.shell.libware.util.CommonUtils.bundleToVector(extras);
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
        qQUserLoginRet.platform = 1;
        qQUserLoginRet.open_id = string;
        java.lang.String string2 = extras.getString("[REDACTED]");
        java.lang.String string3 = extras.getString("[REDACTED]");
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string2) && !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string3)) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis() / 1000;
            qQUserLoginRet.flag = com.tencent.ysdk.shell.framework.constant.YSDKInnerErrorCode.USER_URL_LOGIN;
            qQUserLoginRet.access_token = string2;
            qQUserLoginRet.access_token_expire = 7776000 + jCurrentTimeMillis;
            qQUserLoginRet.pay_token = string3;
            qQUserLoginRet.pay_token_expire = jCurrentTimeMillis + 518400;
            qQUserLoginRet.ret = 0;
            qQUserLoginRet.flag = 0;
        }
        java.lang.String string4 = extras.getString(com.tencent.ysdk.shell.module.user.impl.wx.request.WXUserLoginResponse.PARAM_PK_KEY);
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string4)) {
            qQUserLoginRet.pf_key = string4;
        }
        this.mLaunchLoginRet = qQUserLoginRet;
        return wakeupRet;
    }

    private void launchLoginAsync() {
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = this.mLaunchLoginRet;
        if (qQUserLoginRet != null && qQUserLoginRet.ret == 0) {
            if (qQUserLoginRet.platform == 1) {
                loginWithQQLaunchRecord(qQUserLoginRet);
                return;
            }
            return;
        }
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
        qQUserLoginRet2.platform = 1;
        qQUserLoginRet2.ret = 1;
        qQUserLoginRet2.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        qQUserLoginRet2.msg = "[REDACTED]";
        notifyGameLogin(qQUserLoginRet2, 3);
        reportQQLoginEvent(3, qQUserLoginRet2, null, java.lang.System.currentTimeMillis());
    }

    private void localLoginAsync() {
        com.tencent.ysdk.shell.libware.file.Logger.d("localLoginAsync");
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = getQQUserLoginRet();
        if (qQUserLoginRet == null || qQUserLoginRet.ret != 0) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet2 = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
            qQUserLoginRet2.platform = 1;
            qQUserLoginRet2.ret = 1;
            qQUserLoginRet2.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
            qQUserLoginRet2.msg = "[REDACTED]";
            notifyGameLogin(qQUserLoginRet2, 1);
            reportQQLoginEvent(1, qQUserLoginRet2, null, java.lang.System.currentTimeMillis());
            return;
        }
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest();
        loginRequest.tempRet = qQUserLoginRet;
        loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
        loginRequest.ticket = 1;
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckRequest(loginRequest.ticket, qQUserLoginRet, new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQUserCheckResponesHandler(loginRequest)));
    }

    private void loginWithQQLaunchRecord(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet) {
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest();
        loginRequest.tempRet = qQUserLoginRet;
        loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
        loginRequest.ticket = 3;
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckRequest(loginRequest.ticket, qQUserLoginRet, new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQUserCheckResponesHandler(loginRequest)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGameLogin(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet, int i) {
        if (qQUserLoginRet == null) {
            qQUserLoginRet = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet();
            qQUserLoginRet.ret = 1;
            qQUserLoginRet.flag = 1002;
            qQUserLoginRet.msg = "notify game login ret is null";
        }
        switch (i) {
            case 0:
            case 3:
                qQUserLoginRet.setLoginType(0);
                break;
            case 1:
                qQUserLoginRet.setLoginType(1);
                break;
            case 2:
                qQUserLoginRet.setLoginType(2);
                break;
        }
        if (this.mUserListener == null || qQUserLoginRet == null) {
            return;
        }
        this.mUserListener.OnLoginNotify(qqUserLoginRet2UserLoginRet(qQUserLoginRet));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyGameRelation(com.tencent.ysdk.module.user.UserRelationRet userRelationRet) {
        com.tencent.ysdk.module.user.UserListener userListener = this.mUserListener;
        if (userListener == null || userRelationRet == null) {
            return;
        }
        userListener.OnRelationNotify(userRelationRet);
    }

    private com.tencent.ysdk.module.user.UserLoginRet qqUserLoginRet2UserLoginRet(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "QQUserLoginRet2UserLoginRet");
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet(qQUserLoginRet);
        userLoginRet.platform = 1;
        if (qQUserLoginRet != null) {
            com.tencent.ysdk.module.user.UserToken userToken = new com.tencent.ysdk.module.user.UserToken();
            userToken.type = 1;
            userToken.value = qQUserLoginRet.access_token;
            userToken.expiration = qQUserLoginRet.access_token_expire;
            userLoginRet.token.add(userToken);
            com.tencent.ysdk.module.user.UserToken userToken2 = new com.tencent.ysdk.module.user.UserToken();
            userToken2.type = 2;
            userToken2.value = qQUserLoginRet.pay_token;
            userToken2.expiration = qQUserLoginRet.pay_token_expire;
            userLoginRet.token.add(userToken2);
        }
        return userLoginRet;
    }

    private void queryUserInfoAsync(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d("queryUserInfoAsync");
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = getQQUserLoginRet();
        if (qQUserLoginRet != null && qQUserLoginRet.ret == 0) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet2 = getQQUserLoginRet();
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.RelationRequest relationRequest = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.RelationRequest();
            relationRequest.requestStartTime = java.lang.System.currentTimeMillis();
            relationRequest.openId = qQUserLoginRet2.open_id;
            relationRequest.listener = userRelationListener;
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.user.impl.qq.request.QQQureyUserInfoRequest(qQUserLoginRet2.open_id, qQUserLoginRet2.access_token, new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQQureyUserInfoResponesHandler(relationRequest)));
            return;
        }
        com.tencent.ysdk.module.user.UserRelationRet userRelationRet = new com.tencent.ysdk.module.user.UserRelationRet();
        userRelationRet.info_type = 1;
        userRelationRet.platform = 1;
        userRelationRet.ret = 1;
        userRelationRet.flag = com.tencent.ysdk.framework.common.eFlag.Login_TokenInvalid;
        if (userRelationListener != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d("notify relation to :" + userRelationListener.toString());
            userRelationListener.OnRelationNotify(userRelationRet);
        } else {
            notifyGameRelation(userRelationRet);
        }
        reportUserInfoEvent(3, userRelationRet.flag, userRelationRet.msg, qQUserLoginRet.open_id, null, java.lang.System.currentTimeMillis());
    }

    private com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet readLastQQUserLoginRetFormDB() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "read Last QQUserLoginRet Form DB");
        return com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserTableModel.readLastUserLoginRet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportQQLoginEvent(int i, com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet, java.util.Map<java.lang.String, java.lang.String> map, long j) {
        java.lang.String str;
        com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType;
        com.tencent.ysdk.shell.libware.file.Logger.d("reportQQLogin");
        com.tencent.ysdk.shell.module.stat.StatConstants.EventType eventType2 = com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Default;
        switch (i) {
            case 0:
                str = "1";
                eventType = com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click;
                break;
            case 1:
                str = "2";
                eventType = eventType2;
                break;
            case 2:
                str = "3";
                eventType = eventType2;
                break;
            case 3:
                str = "4";
                eventType = eventType2;
                break;
            default:
                str = "0";
                eventType = eventType2;
                break;
        }
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap();
        try {
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOGIN_TICKET, "" + i);
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_IS_FIRST, java.lang.String.valueOf(qQUserLoginRet.getUserType()));
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_CHANNEL, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
            map2.put("regChannel", qQUserLoginRet.getRegChannel());
            map2.put("offerid", com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getOfferId());
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, str);
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_PLATFORM, "qq");
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_LOCAL_ERROR_CODE, java.lang.String.valueOf(qQUserLoginRet.flag));
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_RESPONSE_ERROR_CODE, java.lang.String.valueOf(qQUserLoginRet.errorCode));
            map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_IS_VISITOR, com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState() ? "1" : "0");
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_IS_VISITOR);
            sb.append(com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().isVisitorState() ? "1" : "0");
            com.tencent.ysdk.shell.libware.file.Logger.d(sb.toString());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        if (qQUserLoginRet.flag == 0) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_SUCCESS, qQUserLoginRet.flag, qQUserLoginRet.msg, qQUserLoginRet.platform, qQUserLoginRet.open_id, map2, j, true, eventType, "");
        } else {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGIN_FAIL, qQUserLoginRet.flag, qQUserLoginRet.msg, qQUserLoginRet.platform, qQUserLoginRet.open_id, map2, j, true, eventType, "");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportUserInfoEvent(int i, int i2, java.lang.String str, java.lang.String str2, java.util.Map<java.lang.String, java.lang.String> map, long j) {
        java.util.Map<java.lang.String, java.lang.String> map2 = map != null ? map : new java.util.HashMap();
        map2.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_PARAM_LOGIN_TICKET, "" + i);
        if (i == 0) {
            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(STAT_EVENT_NAME_QUERY_USER, i2, str, 1, str2, map2, j, true);
        } else {
            com.tencent.ysdk.framework.common.ePlatform eplatform = com.tencent.ysdk.framework.common.ePlatform.QQ;
            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(STAT_EVENT_NAME_QUERY_USER, i2, str, 1, str2, map2, j, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveQQUserLoginRetToDB(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "save QQUserLoginRet To DB");
        this.mLocalLoginRet = qQUserLoginRet;
        com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserTableModel.saveUserLoginRet(qQUserLoginRet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLoginInfoToOpenSDK(java.lang.String str, java.lang.String str2, long j) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        com.tencent.tauth.Tencent tencent = this.mTencent;
        if (tencent != null) {
            tencent.setOpenId(str);
            long jCurrentTimeMillis = j - (java.lang.System.currentTimeMillis() / 1000);
            this.mTencent.setAccessToken(str2, "[REDACTED]" + jCurrentTimeMillis);
        }
    }

    private void verifyRealnameLoginAsync(com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet, int i) {
        if (qQUserLoginRet != null) {
            com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest();
            loginRequest.tempRet = qQUserLoginRet;
            loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
            loginRequest.ticket = 0;
            loginRequest.isCheckRealName = true;
            com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckRequest qQUserCheckRequest = new com.tencent.ysdk.shell.module.user.impl.qq.request.QQUserCheckRequest(loginRequest.ticket, qQUserLoginRet, new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.QQUserCheckResponesHandler(loginRequest));
            qQUserCheckRequest.setVisitorSwitch(i);
            com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(qQUserCheckRequest);
        }
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLaunchRecord() {
        return this.mLaunchLoginRet;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.UserLoginRet getLoginRecord() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "QQ OK-getLoginRecord");
        return qqUserLoginRet2UserLoginRet(getQQUserLoginRet());
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public java.lang.Object getPlatformObject() {
        return this.mTencent;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public com.tencent.ysdk.module.user.WakeupRet handleIntent(android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQ handleIntent");
        if (intent == null) {
            return null;
        }
        android.os.Bundle extras = intent.getExtras();
        java.lang.String string = extras.getString("platformId");
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(string)) {
            string = extras.getString("platform");
        }
        if (!com.tencent.ysdk.framework.common.ePlatform.PF_STR_QQ.equals(string) && com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(extras.getString("current_uin"))) {
            return null;
        }
        return handleQQIntent(intent);
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "QQUserModule init start");
        this.mContext = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext();
        java.lang.String qQAppId = com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getQQAppId();
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(qQAppId)) {
            com.tencent.ysdk.shell.libware.file.Logger.e("[REDACTED]");
        } else {
            com.tencent.ysdk.shell.framework.verification.UserTips.showQQInitTips();
            this.mTencent = com.tencent.tauth.Tencent.createInstance(qQAppId, this.mContext);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "OpenSDK: 3.5.2.lite");
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "QQClient: " + com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPlatformAppVersion(com.tencent.ysdk.framework.common.ePlatform.QQ));
        this.mUiHandler = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        this.mBgHandler = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.HandlerInBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(1));
        this.mLocalLoginRet = getQQUserLoginRet();
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserLoginRet qQUserLoginRet = this.mLocalLoginRet;
        if (qQUserLoginRet != null) {
            setLoginInfoToOpenSDK(qQUserLoginRet.open_id, this.mLocalLoginRet.access_token, this.mLocalLoginRet.access_token_expire);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "QQUserModule init end");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void login() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQ OK-login");
        android.os.Message message = new android.os.Message();
        message.what = 1;
        this.mUiHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLaunchRecord() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQ OK-loginWithLaunchRecord");
        android.os.Message message = new android.os.Message();
        message.what = 3;
        this.mBgHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithLocalRecord(boolean z) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQ OK-loginWithLocalRecord");
        android.os.Message message = new android.os.Message();
        message.what = 2;
        message.obj = java.lang.Boolean.valueOf(z);
        this.mBgHandler.sendMessage(message);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void loginWithMemory() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQ not support this kind of login");
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void logout() {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQ OK-logout");
        this.mLocalLoginRet = null;
        this.mLaunchLoginRet = null;
        com.tencent.ysdk.shell.module.user.impl.qq.db.QQUserTableModel.clearUserLoginRet();
        com.tencent.tauth.Tencent tencent = this.mTencent;
        if (tencent == null || !tencent.isSessionValid()) {
            return;
        }
        this.mTencent.logout(this.mContext);
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "onActivityResult requestCode:" + i);
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "onActivityResult resultCode:" + i2);
        if (i != 11101 && i != 10102) {
            return false;
        }
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest loginRequest = new com.tencent.ysdk.shell.module.user.impl.qq.QQUserModule.LoginRequest();
        loginRequest.requestStartTime = java.lang.System.currentTimeMillis();
        loginRequest.ticket = 0;
        this.mLoginCallback.setLoginRequest(loginRequest);
        com.tencent.tauth.Tencent.onActivityResultData(i, i2, intent, this.mLoginCallback);
        return true;
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void queryUserInfo(com.tencent.ysdk.module.user.UserRelationListener userRelationListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(LOG_TAG, "QQ OK-queryUserInfo");
        android.os.Message messageObtainMessage = this.mBgHandler.obtainMessage(4);
        messageObtainMessage.obj = userRelationListener;
        this.mBgHandler.sendMessage(messageObtainMessage);
    }

    @Override // com.tencent.ysdk.shell.module.Module
    protected void selfCheck() {
        com.tencent.ysdk.shell.module.user.impl.qq.QQUserModuleSelfCheck.checkSDKConfig();
    }

    @Override // com.tencent.ysdk.shell.module.user.impl.UserInnerInterface
    public void setUserListener(com.tencent.ysdk.module.user.UserListener userListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_DOCTOR", "QQ OK-setUserListener");
        this.mUserListener = userListener;
    }
}
