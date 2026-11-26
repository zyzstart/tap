package com.tencent.ysdk.shell.module.antiaddiction.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AntiAddictModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface {
    private static final int MSG_NOTIFY_LOGIN_INSTRUCTION = 2;
    private static final int MSG_NOTIFY_REAL_NAME_CHECK_FAILED = 5;
    private static final int MSG_NOTIFY_REGISTER_REAL_NAME = 1;
    private static final int MSG_NOTIFY_TIME_LIMIT_INSTRUCTION = 3;
    private static final int MSG_NOTIFY_VISITOR_GUIDE = 6;
    private static final int MSG_NOTIFY_VISITOR_LOGIN = 4;
    private static final java.lang.String REAL_NAME_WINDOW_PUSH_ID = "YSDKRealNameRegister";
    private static final java.lang.String VISITOR_GUIDE_PUSH_ID = "YSDKVisitorGuideWindow";
    private static final java.lang.String VISITOR_TIPS_PUSH_ID = "YSDKVisitorWindow";
    private static boolean sIsVisitor = false;
    private static boolean sLogEnable = false;
    private static boolean sUserSetStartGame = false;
    private com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener mAntiAddictListener;
    private com.tencent.ysdk.module.antiaddiction.listener.AntiRegisterWindowCloseListener mAntiRegisterWindowCloseListener;
    private int mDuration;
    private com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction mInnerInstruction;
    private boolean mIsNeedCheckRealName = false;
    private android.os.Handler mUiHandler;

    class JudgeTimingResponseHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse> {
        JudgeTimingResponseHandler() {
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.JudgeTimingResponse judgeTimingResponse) {
            if (judgeTimingResponse.ret == 0) {
                com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mDuration = judgeTimingResponse.getDuration();
                if (judgeTimingResponse.getInstructionList() == null || judgeTimingResponse.getInstructionList().size() <= 0) {
                    return;
                }
                for (com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel singleInstructionModel : judgeTimingResponse.getInstructionList()) {
                    com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.printLogInDebug("user has time anti-addict limit");
                    com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet = new com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet(singleInstructionModel, judgeTimingResponse.getTraceId());
                    android.os.Message messageObtain = android.os.Message.obtain();
                    messageObtain.what = 3;
                    messageObtain.obj = antiAddictRet;
                    com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mUiHandler.sendMessage(messageObtain);
                }
            }
        }
    }

    public AntiAddictModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_ANTI_ADDICTION;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void loadUrl(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map, com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener onBrowserStateChangeListener) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.ysdk.shell.framework.web.router.IntentRouter.commonJump(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getPluginContext(), str, null, 2, map, onBrowserStateChangeListener);
        reportWebviewBuildCost(java.lang.System.currentTimeMillis() - jCurrentTimeMillis, str, map);
    }

    private void reportWebviewBuildCost(final long j, final java.lang.String str, final java.util.HashMap<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.2
            @Override // java.lang.Runnable
            public void run() {
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("url", str);
                map2.put("duration", java.lang.String.valueOf(j));
                java.util.HashMap map3 = map;
                if (map3 != null && map3.containsKey(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID)) {
                    map2.put("id", map.get(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID));
                }
                com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo("ysdkAntiWebviewBuildCost", 0, "webview build cost", map2, java.lang.System.currentTimeMillis(), true);
            }
        });
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public boolean checkAntiAddictionLoginRules(org.json.JSONObject jSONObject, org.json.JSONObject jSONObject2, com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginAntiAddictCallBack, boolean z) {
        if (!this.mIsNeedCheckRealName) {
            setVisitorState(false);
            return false;
        }
        com.tencent.ysdk.shell.module.antiaddiction.impl.model.LoginJudgeModel loginJudgeModel = new com.tencent.ysdk.shell.module.antiaddiction.impl.model.LoginJudgeModel(jSONObject);
        if (loginJudgeModel.ret == -1 || loginJudgeModel.instructionList == null || loginJudgeModel.instructionList.size() <= 0) {
            setVisitorState(false);
            return false;
        }
        com.tencent.ysdk.shell.module.antiaddiction.impl.model.VisitorLoginModel visitorLoginModel = new com.tencent.ysdk.shell.module.antiaddiction.impl.model.VisitorLoginModel(jSONObject2);
        java.util.Iterator<com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel> it = loginJudgeModel.instructionList.iterator();
        while (it.hasNext()) {
            executeLoginInstruction(new com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet(it.next(), loginJudgeModel.traceId), visitorLoginModel, loginAntiAddictCallBack, z);
        }
        return true;
    }

    boolean checkGameTaskIsRunning() {
        return getTaskManager().getTaskByName(com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask.TASK_NAME) instanceof com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask;
    }

    void executeLoginInstruction(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet, com.tencent.ysdk.shell.module.antiaddiction.impl.model.VisitorLoginModel visitorLoginModel, com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginAntiAddictCallBack, boolean z) {
        com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction innerInstruction = new com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction(antiAddictRet, visitorLoginModel, loginAntiAddictCallBack);
        this.mInnerInstruction = innerInstruction;
        if (z) {
            if (antiAddictRet.ruleFamily.equals(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet.RULE_REGISTER_REAL_NAME)) {
                if (visitorLoginModel.visitorSwitch != 1 || visitorLoginModel.visitorLoginState != 0) {
                    onRegisterWindowClose();
                    return;
                }
                setVisitorState(true);
                loginAntiAddictCallBack.onVisitorLogin();
                android.os.Message messageObtain = android.os.Message.obtain();
                messageObtain.what = 4;
                messageObtain.obj = innerInstruction;
                this.mUiHandler.sendMessage(messageObtain);
                return;
            }
            return;
        }
        java.lang.String str = antiAddictRet.ruleFamily;
        byte b = -1;
        if (str.hashCode() == -2128636558 && str.equals(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet.RULE_REGISTER_REAL_NAME)) {
            b = 0;
        }
        if (b != 0) {
            loginAntiAddictCallBack.onExecuteInstruction(antiAddictRet);
            printLogInDebug("user has login anti-addict limit");
            android.os.Message messageObtain2 = android.os.Message.obtain();
            messageObtain2.what = 2;
            messageObtain2.obj = antiAddictRet;
            this.mUiHandler.sendMessage(messageObtain2);
            return;
        }
        loginAntiAddictCallBack.onRegisterRealName();
        printLogInDebug("user need register real name");
        android.os.Message messageObtain3 = android.os.Message.obtain();
        messageObtain3.what = 1;
        messageObtain3.obj = innerInstruction;
        this.mUiHandler.sendMessage(messageObtain3);
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public int getGameDuration() {
        return this.mDuration;
    }

    com.tencent.ysdk.module.user.UserLoginRet getLoginRet() {
        return com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
    }

    com.tencent.ysdk.shell.framework.timertask.TaskManager getTaskManager() {
        return com.tencent.ysdk.shell.framework.timertask.TaskManager.getInstance();
    }

    com.tencent.ysdk.shell.framework.request.YSDKServer getYSDKServer() {
        return com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance();
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        this.mIsNeedCheckRealName = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_ANTIADDICTION_SWITCH, false);
        this.mUiHandler = new android.os.Handler(android.os.Looper.getMainLooper()) { // from class: com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.1
            @Override // android.os.Handler
            public void handleMessage(@androidx.annotation.NonNull android.os.Message message) {
                switch (message.what) {
                    case 1:
                        if (message.obj instanceof com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction) {
                            com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction innerInstruction = (com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction) message.obj;
                            com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet instruction = innerInstruction.getInstruction();
                            final com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginCallback = innerInstruction.getLoginCallback();
                            final int i = innerInstruction.getVisitorLoginModel().visitorSwitch;
                            java.util.HashMap map = new java.util.HashMap();
                            map.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_CLOSE_BY_CLICK_OUTER, "false");
                            map.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_PORTRAIT_HEIGHT, "95");
                            map.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_PORTRAIT_WIDTH, "95");
                            map.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_LANDSCAPE_HEIGHT, "95");
                            map.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_LANDSCAPE_WIDTH, "80");
                            map.put(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID, com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.REAL_NAME_WINDOW_PUSH_ID);
                            com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.loadUrl(instruction.url, map, new com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener() { // from class: com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.1.1
                                @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
                                public void onClose() {
                                    com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginAntiAddictCallBack = loginCallback;
                                    if (loginAntiAddictCallBack != null) {
                                        loginAntiAddictCallBack.onRequestLogin(i);
                                    }
                                }

                                @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
                                public void onPageFinish() {
                                }

                                @Override // com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser.OnBrowserStateChangeListener
                                public void onPageStart() {
                                }
                            });
                            com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.reportExecute(instruction, java.lang.System.currentTimeMillis());
                        }
                        break;
                    case 2:
                        try {
                            if ((message.obj instanceof com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet) && com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mAntiAddictListener != null) {
                                com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mAntiAddictListener.onLoginLimitNotify((com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet) message.obj);
                                break;
                            }
                        } catch (java.lang.Throwable th) {
                            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th);
                            return;
                        }
                        break;
                    case 3:
                        try {
                            if ((message.obj instanceof com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet) && com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mAntiAddictListener != null) {
                                com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mAntiAddictListener.onTimeLimitNotify((com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet) message.obj);
                                break;
                            }
                        } catch (java.lang.Throwable th2) {
                            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th2);
                            return;
                        }
                        break;
                    case 4:
                        try {
                            if (message.obj instanceof com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction) {
                                com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction innerInstruction2 = (com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction) message.obj;
                                java.lang.String str = innerInstruction2.getVisitorLoginModel().visitorLoginUrl;
                                com.tencent.ysdk.shell.module.antiaddiction.impl.model.LoginJudgeModel loginJudgeModel = innerInstruction2.getVisitorLoginModel().loginJudgeModel;
                                if (loginJudgeModel != null && loginJudgeModel.ret != -1 && loginJudgeModel.instructionList != null && loginJudgeModel.instructionList.size() > 0) {
                                    java.util.Iterator<com.tencent.ysdk.module.antiaddiction.impl.model.SingleInstructionModel> it = loginJudgeModel.instructionList.iterator();
                                    while (it.hasNext()) {
                                        com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mAntiAddictListener.onLoginLimitNotify(new com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet(it.next(), loginJudgeModel.traceId));
                                    }
                                }
                                if (!android.text.TextUtils.isEmpty(str)) {
                                    java.util.HashMap map2 = new java.util.HashMap();
                                    map2.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_CLOSE_BY_CLICK_OUTER, "false");
                                    map2.put(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID, com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.VISITOR_TIPS_PUSH_ID);
                                    map2.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_WEBVIEW_SHOWED_DELAY, com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
                                    com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.loadUrl(str, map2, null);
                                }
                            }
                        } catch (java.lang.Throwable th3) {
                            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th3);
                            return;
                        }
                        break;
                    case 5:
                        try {
                            if (com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mAntiRegisterWindowCloseListener != null) {
                                com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.mAntiRegisterWindowCloseListener.onWindowClose();
                            }
                        } catch (java.lang.Throwable th4) {
                            com.tencent.ysdk.shell.module.stat.StatHelper.reportStatError(null, th4);
                            return;
                        }
                        break;
                    case 6:
                        if (message.obj instanceof com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction) {
                            java.lang.String str2 = ((com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction) message.obj).getVisitorLoginModel().visitorGuideUrl;
                            if (!android.text.TextUtils.isEmpty(str2)) {
                                java.util.HashMap map3 = new java.util.HashMap();
                                map3.put(com.tencent.ysdk.shell.framework.web.browser.WebViewConstants.EXTRA_DATA_CLOSE_BY_CLICK_OUTER, "false");
                                map3.put(com.tencent.ysdk.shell.module.msgbox.impl.MsgBoxModuleStat.PARA_POP_PUSH_ID, com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.VISITOR_GUIDE_PUSH_ID);
                                com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.this.loadUrl(str2, map3, null);
                            }
                        }
                        break;
                }
            }
        };
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public boolean isVisitorState() {
        return sIsVisitor;
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void onRegisterWindowClose() {
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 5;
        this.mUiHandler.sendMessage(messageObtain);
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void printLogInDebug(java.lang.String str) {
        if (sLogEnable) {
            android.util.Log.d(com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface.LOG_TAG, str);
        }
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void queryCertification(final com.tencent.ysdk.module.antiaddiction.listener.QueryCertificationCallback queryCertificationCallback) {
        if (queryCertificationCallback == null) {
            return;
        }
        com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
        com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord(userLoginRet);
        getYSDKServer().doRequest(new com.tencent.ysdk.shell.module.antiaddiction.impl.http.request.QueryCertificationRequest(userLoginRet.getLoginType(), userLoginRet.platform, userLoginRet.open_id, userLoginRet.getAccessToken(), new com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse>() { // from class: com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.3
            @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
            public void onResponse(com.tencent.ysdk.shell.module.antiaddiction.impl.http.response.QueryCertificationResponse queryCertificationResponse) {
                queryCertificationCallback.onQueryCertification(queryCertificationResponse.getCertificationRect());
            }
        }));
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void registerRealName() {
        if (this.mInnerInstruction != null) {
            android.os.Message messageObtain = android.os.Message.obtain();
            messageObtain.what = 1;
            messageObtain.obj = this.mInnerInstruction;
            this.mUiHandler.sendMessage(messageObtain);
        }
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void reportExecute(com.tencent.ysdk.module.antiaddiction.model.AntiAddictRet antiAddictRet, long j) {
        if (antiAddictRet != null) {
            com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.ReportExecuteRequestParam reportExecuteRequestParam = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.ReportExecuteRequestParam();
            reportExecuteRequestParam.instrTraceId = antiAddictRet.getTraceId();
            reportExecuteRequestParam.execTime = (int) (j / 1000);
            reportExecuteRequestParam.ruleName = antiAddictRet.getTraceRuleName();
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
            reportExecuteRequestParam.openId = loginRecord.open_id;
            reportExecuteRequestParam.platform = com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform);
            getYSDKServer().doRequest(new com.tencent.ysdk.shell.module.antiaddiction.impl.http.request.ReportExecuteRequest(reportExecuteRequestParam));
            java.util.HashMap map = new java.util.HashMap();
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_ANTI_ADDICTION_RULEFAMILE, antiAddictRet.ruleFamily);
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_ANTI_ADDICTION_RULENAME, antiAddictRet.getTraceRuleName());
            map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_ANTI_ADDICTION_TRACEID, antiAddictRet.getTraceId());
            com.tencent.ysdk.shell.module.stat.StatHelper.reportApiEventWithDeviceInfo(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_ANTI_ADDICTION, 0, "execute antiaddic instruction", map, j, true);
        }
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void resetGameStartFromBackground() {
        if (sUserSetStartGame) {
            printLogInDebug("resetGameStartFromBackground");
            com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
            if (checkGameTaskIsRunning()) {
                return;
            }
            com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam judgeTimingRequestParam = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam();
            judgeTimingRequestParam.factType = 11;
            judgeTimingRequestParam.platform = com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform);
            judgeTimingRequestParam.openId = loginRecord.open_id;
            judgeTimingRequestParam.visitorSwitch = sIsVisitor ? 1 : 0;
            com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.JudgeTimingResponseHandler judgeTimingResponseHandler = new com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.JudgeTimingResponseHandler();
            getYSDKServer().doRequest(new com.tencent.ysdk.shell.module.antiaddiction.impl.http.request.JudgeTimingRequest(judgeTimingRequestParam, null));
            getTaskManager().addTask(new com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask(judgeTimingResponseHandler, sIsVisitor));
        }
    }

    @Override // com.tencent.ysdk.shell.module.Module
    protected void selfCheck() {
        super.selfCheck();
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void setAntiAddictionListener(com.tencent.ysdk.module.antiaddiction.listener.AntiAddictListener antiAddictListener) {
        this.mAntiAddictListener = antiAddictListener;
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void setGameBackground() {
        if (sUserSetStartGame) {
            printLogInDebug("setGameBackground");
            if (checkGameTaskIsRunning()) {
                int duration = ((com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask) getTaskManager().getTaskByName(com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask.TASK_NAME)).getDuration();
                getTaskManager().removeTask(com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask.TASK_NAME);
                com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
                com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam judgeTimingRequestParam = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam();
                judgeTimingRequestParam.factType = 13;
                judgeTimingRequestParam.platform = com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform);
                judgeTimingRequestParam.openId = loginRecord.open_id;
                judgeTimingRequestParam.duration = duration;
                judgeTimingRequestParam.visitorSwitch = sIsVisitor ? 1 : 0;
                getYSDKServer().doRequest(new com.tencent.ysdk.shell.module.antiaddiction.impl.http.request.JudgeTimingRequest(judgeTimingRequestParam, null));
            }
        }
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public boolean setGameEnd() {
        if (!sUserSetStartGame) {
            printLogInDebug("setGameEnd false: 未设置游戏开始，无法设置游戏结束");
            return false;
        }
        com.tencent.ysdk.module.user.UserLoginRet loginRet = getLoginRet();
        if (android.text.TextUtils.isEmpty(loginRet.open_id)) {
            printLogInDebug("setGameEnd false: 用户未登录，无法设置游戏结束");
            return false;
        }
        sUserSetStartGame = false;
        if (!checkGameTaskIsRunning()) {
            printLogInDebug("setGameEnd false: 任务未开始，无需设置游戏结束");
            printLogInDebug("setGameEnd false: 设置游戏结束失败");
            return false;
        }
        int duration = ((com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask) getTaskManager().getTaskByName(com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask.TASK_NAME)).getDuration();
        getTaskManager().removeTask(com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask.TASK_NAME);
        com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam judgeTimingRequestParam = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam();
        judgeTimingRequestParam.factType = 13;
        judgeTimingRequestParam.platform = com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRet.platform);
        judgeTimingRequestParam.openId = loginRet.open_id;
        judgeTimingRequestParam.duration = duration;
        judgeTimingRequestParam.visitorSwitch = sIsVisitor ? 1 : 0;
        getYSDKServer().doRequest(new com.tencent.ysdk.shell.module.antiaddiction.impl.http.request.JudgeTimingRequest(judgeTimingRequestParam, new com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.JudgeTimingResponseHandler()));
        printLogInDebug("setGameEnd: success");
        return true;
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public boolean setGameStart() {
        if (!this.mIsNeedCheckRealName) {
            printLogInDebug("setGameStart false: 未开启实名认证开关");
            return false;
        }
        com.tencent.ysdk.module.user.UserLoginRet loginRet = getLoginRet();
        if (android.text.TextUtils.isEmpty(loginRet.open_id)) {
            printLogInDebug("setGameStart false: 用户未登录，游戏时长统计需要用户登录后使用");
            return false;
        }
        if (!com.tencent.ysdk.shell.framework.YSDKLifeCycle.isForeground()) {
            printLogInDebug("setGameStart false: 当前应用不在前台，无法设置游戏开始");
            return false;
        }
        sUserSetStartGame = true;
        if (checkGameTaskIsRunning()) {
            printLogInDebug("setGameStart false: 游戏已调用开始，无需再次调用，如果想结束时长统计，请调用setGameEnd()");
            return false;
        }
        printLogInDebug("setGameStart: success");
        com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam judgeTimingRequestParam = new com.tencent.ysdk.shell.module.antiaddiction.impl.http.requestparam.JudgeTimingRequestParam();
        judgeTimingRequestParam.factType = 11;
        judgeTimingRequestParam.platform = com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRet.platform);
        judgeTimingRequestParam.openId = loginRet.open_id;
        judgeTimingRequestParam.visitorSwitch = sIsVisitor ? 1 : 0;
        com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.JudgeTimingResponseHandler judgeTimingResponseHandler = new com.tencent.ysdk.shell.module.antiaddiction.impl.AntiAddictModule.JudgeTimingResponseHandler();
        getYSDKServer().doRequest(new com.tencent.ysdk.shell.module.antiaddiction.impl.http.request.JudgeTimingRequest(judgeTimingRequestParam, judgeTimingResponseHandler));
        getTaskManager().addTask(new com.tencent.ysdk.shell.module.antiaddiction.impl.GameDurationTask(judgeTimingResponseHandler, sIsVisitor));
        return true;
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void setLogEnable(boolean z) {
        sLogEnable = z;
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void setRegisterWindowClose(com.tencent.ysdk.module.antiaddiction.listener.AntiRegisterWindowCloseListener antiRegisterWindowCloseListener) {
        this.mAntiRegisterWindowCloseListener = antiRegisterWindowCloseListener;
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void setVisitorState(boolean z) {
        sIsVisitor = z;
    }

    @Override // com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionInterface
    public void visitorLogin() {
        com.tencent.ysdk.shell.module.antiaddiction.impl.model.InnerInstruction innerInstruction = this.mInnerInstruction;
        if (innerInstruction != null) {
            com.tencent.ysdk.shell.module.antiaddiction.listener.LoginAntiAddictCallBack loginCallback = innerInstruction.getLoginCallback();
            int i = this.mInnerInstruction.getVisitorLoginModel().visitorSwitch;
            if (loginCallback != null) {
                loginCallback.onRequestLogin(i);
            }
        }
    }
}
