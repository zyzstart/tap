package com.tencent.ysdk.shell.module.realName.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class RealNameModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.realName.RealNameInterface {
    private static final int MSG_REAL_NAME_NOTIFY_RESULT_TO_LOGIN_MODULE = 4;
    private static final int MSG_REAL_NAME_NOTIFY_RESULT_TO_UI = 3;
    private static final int MSG_REAL_NAME_REGISTER_REAL_NAME = 2;
    private static final int MSG_REAL_NAME_SHOW_REGISTER = 1;
    private android.os.Handler mUiHandler = null;
    private android.os.Handler mBGHandler = null;
    private com.tencent.ysdk.shell.module.realName.RealNameInnerListener mMaoYangRealNameInnerListener = null;
    private com.tencent.ysdk.shell.module.realName.RealNameInnerListener mUiRealNameInnerListener = null;
    private com.tencent.ysdk.framework.common.ePlatform mLoginPlatForm = null;
    private java.lang.String mOpenId = "";
    private java.lang.String mATK = "";
    private java.lang.String mNickName = "";

    private class HandlerInBG extends android.os.Handler {
        public HandlerInBG(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 2) {
                if (!(message.obj instanceof com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara)) {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "RegisterRealNameRequestPara is bad , not instanceof RegisterRealNameRequestPara");
                    return;
                }
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "registerRealNameAsync");
                com.tencent.ysdk.shell.module.realName.impl.RealNameModule.this.registerRealNameAsync((com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara) message.obj);
                return;
            }
            if (i != 4) {
                return;
            }
            if (!(message.obj instanceof com.tencent.ysdk.framework.common.BaseRet)) {
                com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "notifyRegisterRealNameToLoginModuleAsync is bad");
                return;
            }
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "notifyRegisterRealNameToLoginModuleAsync");
            com.tencent.ysdk.shell.module.realName.impl.RealNameModule.this.notifyRegisterRealNameToLoginModuleAsync((com.tencent.ysdk.framework.common.BaseRet) message.obj);
        }
    }

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            int i = message.what;
            if (i == 1) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "showRegisterPageAsync");
                com.tencent.ysdk.shell.module.realName.impl.RealNameModule.this.showRegisterPageAsync();
            } else {
                if (i != 3) {
                    return;
                }
                if (!(message.obj instanceof com.tencent.ysdk.framework.common.BaseRet)) {
                    com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "notifyRegisterResultToUiAsync is bad");
                    return;
                }
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "notifyRegisterResultToUiAsync");
                com.tencent.ysdk.shell.module.realName.impl.RealNameModule.this.notifyRegisterResultToUiAsync((com.tencent.ysdk.framework.common.BaseRet) message.obj);
            }
        }
    }

    private class RegisterRealNameResponesHandler implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse> {
        protected com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara registerRealNameRequestPara;

        private RegisterRealNameResponesHandler() {
            this.registerRealNameRequestPara = null;
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameResponse registerRealNameResponse) {
            com.tencent.ysdk.shell.libware.file.Logger.d(registerRealNameResponse.toString());
            if (com.tencent.ysdk.shell.module.realName.impl.RealNameModule.this.mUiRealNameInnerListener == null) {
                com.tencent.ysdk.shell.libware.file.Logger.e("mUiRealNameInnerListener is null");
                return;
            }
            com.tencent.ysdk.framework.common.BaseRet baseRet = new com.tencent.ysdk.framework.common.BaseRet();
            if (registerRealNameResponse.flag == 0) {
                baseRet.ret = 0;
            } else {
                baseRet.ret = 1;
            }
            baseRet.flag = registerRealNameResponse.flag;
            baseRet.msg = registerRealNameResponse.msg;
            com.tencent.ysdk.shell.module.realName.impl.RealNameModule.this.notifyRegisterResultToUi(baseRet);
        }
    }

    public RealNameModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_REAL_NAME;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRegisterResultToUi(com.tencent.ysdk.framework.common.BaseRet baseRet) {
        android.os.Message message = new android.os.Message();
        message.what = 3;
        message.obj = baseRet;
        this.mUiHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyRegisterResultToUiAsync(com.tencent.ysdk.framework.common.BaseRet baseRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "notifyRegisterResultToUiAsync");
        if (baseRet != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, baseRet.toString());
            if (this.mUiRealNameInnerListener == null) {
                com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "mUiRealNameInnerListener is null");
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "mUiRealNameInnerListener OnRegisterRealNameNotify");
                this.mUiRealNameInnerListener.OnRegisterRealNameNotify(baseRet);
            }
        }
    }

    @Override // com.tencent.ysdk.shell.module.realName.RealNameInterface
    public com.tencent.ysdk.framework.common.ePlatform getUserLoginPltform() {
        com.tencent.ysdk.framework.common.ePlatform eplatform = this.mLoginPlatForm;
        if (eplatform != null) {
            return eplatform;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "mLoginPlatForm  is null");
        return com.tencent.ysdk.framework.common.ePlatform.None;
    }

    @Override // com.tencent.ysdk.shell.module.realName.RealNameInterface
    public java.lang.String getUserNickname() {
        if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(this.mNickName)) {
            return this.mNickName;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "mNickName  is null");
        return "";
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "RealNameModule init start");
        this.mUiHandler = new com.tencent.ysdk.shell.module.realName.impl.RealNameModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        this.mBGHandler = new com.tencent.ysdk.shell.module.realName.impl.RealNameModule.HandlerInBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(1));
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "RealNameModule init end");
    }

    @Override // com.tencent.ysdk.shell.module.realName.RealNameInterface
    public void notifyRegisterRealNameToLoginModule(com.tencent.ysdk.framework.common.BaseRet baseRet) {
        android.os.Message message = new android.os.Message();
        message.what = 4;
        message.obj = baseRet;
        this.mBGHandler.sendMessage(message);
    }

    public void notifyRegisterRealNameToLoginModuleAsync(com.tencent.ysdk.framework.common.BaseRet baseRet) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "notifyRegisterRealNameToLoginModule");
        if (baseRet != null) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, baseRet.toString());
            if (this.mMaoYangRealNameInnerListener == null) {
                com.tencent.ysdk.shell.libware.file.Logger.e(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "mMaoYangRealNameInnerListener is null");
            } else {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "mMaoYangRealNameInnerListener OnRegisterRealNameNotify");
                this.mMaoYangRealNameInnerListener.OnRegisterRealNameNotify(baseRet);
            }
        }
    }

    @Override // com.tencent.ysdk.shell.module.realName.RealNameInterface
    public void registerRealName(com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara registerRealNameRequestPara, com.tencent.ysdk.shell.module.realName.RealNameInnerListener realNameInnerListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "registerRealName");
        this.mUiRealNameInnerListener = realNameInnerListener;
        if (registerRealNameRequestPara != null) {
            android.os.Message message = new android.os.Message();
            message.what = 2;
            message.obj = registerRealNameRequestPara;
            this.mBGHandler.sendMessage(message);
        }
    }

    public void registerRealNameAsync(com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequestPara registerRealNameRequestPara) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "registerRealNameAsync");
        com.tencent.ysdk.shell.module.realName.impl.RealNameModule.RegisterRealNameResponesHandler registerRealNameResponesHandler = new com.tencent.ysdk.shell.module.realName.impl.RealNameModule.RegisterRealNameResponesHandler();
        registerRealNameResponesHandler.registerRealNameRequestPara = registerRealNameRequestPara;
        registerRealNameResponesHandler.registerRealNameRequestPara.open_id = this.mOpenId;
        registerRealNameResponesHandler.registerRealNameRequestPara.platform = this.mLoginPlatForm;
        registerRealNameResponesHandler.registerRealNameRequestPara.access_token = this.mATK;
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.realName.impl.request.RegisterRealNameRequest(registerRealNameRequestPara, registerRealNameResponesHandler));
    }

    @Override // com.tencent.ysdk.shell.module.Module
    protected void selfCheck() {
        com.tencent.ysdk.shell.module.realName.impl.RealNameModuleSelfCheck.checkSDKConfig();
    }

    @Override // com.tencent.ysdk.shell.module.realName.RealNameInterface
    public void showRegisterPage(com.tencent.ysdk.framework.common.ePlatform eplatform, java.lang.String str, java.lang.String str2, java.lang.String str3, com.tencent.ysdk.shell.module.realName.RealNameInnerListener realNameInnerListener) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "platform:" + eplatform);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "openid:" + str);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "nickName:" + str3);
        this.mLoginPlatForm = eplatform;
        this.mOpenId = str;
        this.mATK = str2;
        this.mNickName = str3;
        this.mMaoYangRealNameInnerListener = realNameInnerListener;
        android.os.Message message = new android.os.Message();
        message.what = 1;
        this.mUiHandler.sendMessage(message);
    }

    public void showRegisterPageAsync() {
        boolean zIsSwitchEnabled = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_REAL_NAME_SWITCH, false);
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, "isSkipRealName:" + zIsSwitchEnabled);
        if (zIsSwitchEnabled) {
            com.tencent.ysdk.framework.common.BaseRet baseRet = new com.tencent.ysdk.framework.common.BaseRet();
            baseRet.ret = 0;
            baseRet.flag = 0;
            baseRet.msg = "app skip real name auth ";
            notifyRegisterRealNameToLoginModule(baseRet);
            return;
        }
        android.content.Intent intent = new android.content.Intent();
        intent.setClass(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), com.tencent.ysdk.shell.module.realName.impl.RegisterRealNameActivity.class);
        try {
            com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity().startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.realName.RealNameInterface.LOG_TAG, e.toString());
            com.tencent.ysdk.framework.common.BaseRet baseRet2 = new com.tencent.ysdk.framework.common.BaseRet();
            baseRet2.ret = 1;
            baseRet2.flag = com.tencent.ysdk.framework.common.eFlag.Login_NotRegisterRealName;
            baseRet2.msg = "ActivityNotFoundException e " + e.toString();
            notifyRegisterRealNameToLoginModule(baseRet2);
        }
    }
}
