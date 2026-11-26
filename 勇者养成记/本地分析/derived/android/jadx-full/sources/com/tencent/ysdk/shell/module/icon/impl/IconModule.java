package com.tencent.ysdk.shell.module.icon.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class IconModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.icon.IconInterface {
    private static final java.lang.String ICON_DEFAULT_VERSION = "YSDK_1";
    private static final int MSG_ICON_GET_SETTINGS = 1;
    private static final int MSG_ICON_REMOVE_ICON = 3;
    private static final int MSG_ICON_SHOW_ICON = 2;
    public static final java.lang.String TAG = "YSDK ICON";
    private android.os.Handler mUiHandler = null;
    private android.os.Handler mBgHandler = null;
    private boolean mIconHasStart = false;
    private java.lang.String mIconVersion = "";

    private class GetMenuResponseHandle implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse> {
        public GetMenuResponseHandle() {
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.icon.impl.request.GetMenuResponse getMenuResponse) {
            com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.icon.impl.IconModule.TAG, getMenuResponse.toString());
            if (getMenuResponse.ret != 0) {
                com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.icon.impl.IconModule.TAG, "load icon get bad response, don't show icon");
                return;
            }
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setIconIsNew(getMenuResponse.iconIsNew);
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setIconCanBeShowed(getMenuResponse.iconCanBeShowed);
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setMsgNum(getMenuResponse.msg_num);
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setMenuUrl(getMenuResponse.mMenuMsgUrl);
            com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setMenuItems(getMenuResponse.mItems);
            if (getMenuResponse.mItems.size() == 0) {
                com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().setIconCanBeShowed(false);
            }
            if (com.tencent.ysdk.shell.module.icon.impl.IconModule.this.mIconHasStart) {
                return;
            }
            com.tencent.ysdk.shell.module.icon.impl.IconModule.this.showGameAssistant(getMenuResponse.mIconUrl);
            com.tencent.ysdk.shell.module.icon.impl.IconModule.this.showForcePopWindow(1);
            com.tencent.ysdk.shell.module.icon.impl.IconModule.this.mIconHasStart = true;
        }
    }

    private class HandlerInBG extends android.os.Handler {
        public HandlerInBG(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 1) {
                return;
            }
            com.tencent.ysdk.shell.module.icon.impl.IconModule.this.createGameAssistantAsync();
        }
    }

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            switch (message.what) {
                case 2:
                    com.tencent.ysdk.shell.module.icon.impl.IconModule.this.showGameAssistantAsync(message.obj);
                    break;
                case 3:
                    com.tencent.ysdk.shell.module.icon.impl.IconModule.this.removeGameAssistantAsync();
                    break;
            }
        }
    }

    private class UserInnerLoginListenerImp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private java.lang.String openid;

        private UserInnerLoginListenerImp() {
            this.openid = null;
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet != null) {
                if (userLoginRet.ret != 0 || userLoginRet.flag != 0) {
                    if (com.tencent.ysdk.shell.module.icon.impl.IconModule.this.mIconHasStart) {
                        com.tencent.ysdk.shell.module.icon.impl.IconModule.this.removeGameAssistant();
                    }
                } else if (userLoginRet.getLoginType() == 0 || 1 == userLoginRet.getLoginType()) {
                    this.openid = userLoginRet.open_id;
                    com.tencent.ysdk.shell.module.icon.impl.IconModule.this.createGameAssistant();
                }
            }
        }
    }

    public IconModule() {
        this.name = "icon";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void createGameAssistantAsync() {
        com.tencent.ysdk.shell.module.icon.impl.IconModule.GetMenuResponseHandle getMenuResponseHandle = new com.tencent.ysdk.shell.module.icon.impl.IconModule.GetMenuResponseHandle();
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.icon.impl.request.GetMenuRequest(com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform), loginRecord.open_id, 7 == loginRecord.platform ? loginRecord.getPayToken() : loginRecord.getAccessToken(), com.tencent.ysdk.shell.module.icon.impl.floatingviews.FloatMenu.getMenuInstance().getMenuTag(), getMenuResponseHandle));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGameAssistantAsync() {
        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().closeAllView();
        this.mIconHasStart = false;
        com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.reportIconEvent(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.EVENT_ICON_REMOVE, 0, "removeGameAssistantAsync", (java.util.Map<java.lang.String, java.lang.String>) null, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "icon");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGameAssistant(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "showGameAssistant");
        android.os.Message message = new android.os.Message();
        message.what = 2;
        message.obj = str;
        this.mUiHandler.sendMessage(message);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGameAssistantAsync(java.lang.Object obj) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("showGameAssistantAsync ");
        int i = 1;
        sb.append(obj == null);
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, sb.toString());
        try {
            final java.lang.String str = obj instanceof java.lang.String ? (java.lang.String) obj : "";
            com.tencent.ysdk.shell.framework.floatingwindow.FloatingWindowManager.getInstance().addCommand(new com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand(i) { // from class: com.tencent.ysdk.shell.module.icon.impl.IconModule.1
                @Override // com.tencent.ysdk.shell.framework.floatingwindow.AbstractFloatingWindowCommand
                protected void executeWithTryCatch() {
                    com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().showIconWindow(str);
                }
            });
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e(TAG, e);
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void createGameAssistant() {
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w("createGameAssistant icon module is closed");
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "createGameAssistant");
            this.mBgHandler.sendEmptyMessage(1);
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public java.lang.String getIconVersion() {
        if (com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "getIconVersion");
            return this.mIconVersion;
        }
        com.tencent.ysdk.shell.libware.file.Logger.w("createGameAssistant icon module is closed");
        return "";
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "icon is closed_init");
            return;
        }
        this.mIconVersion = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_VERSION, ICON_DEFAULT_VERSION);
        this.mUiHandler = new com.tencent.ysdk.shell.module.icon.impl.IconModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        this.mBgHandler = new com.tencent.ysdk.shell.module.icon.impl.IconModule.HandlerInBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(1));
        com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.icon.impl.IconModule.UserInnerLoginListenerImp());
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void notifyStateChange(java.lang.String str, boolean z) {
        android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "Icon notifyStateChange need Show RedPoint:" + z);
        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().updateIconViewRedPoint();
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void onDestroy() {
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w("onDestroy icon module is closed");
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "onDestroy");
        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().closeAllView();
        this.mIconHasStart = false;
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void onPause() {
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w("onPause icon module is closed");
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "onPause");
            com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().onPause();
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void onResume() {
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w("onResume icon module is closed");
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "onResume");
            com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().onResume();
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void removeGameAssistant() {
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.KEY_ICON_SWITCH, true)) {
            com.tencent.ysdk.shell.libware.file.Logger.w("createGameAssistant icon module is closed");
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "removeGameAssistant");
            this.mUiHandler.sendEmptyMessage(3);
        }
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void showForcePopWindow(int i) {
    }

    @Override // com.tencent.ysdk.shell.module.icon.IconInterface
    public void showIconBubble(com.tencent.ysdk.module.msgbox.MsgItem msgItem) {
        com.tencent.ysdk.shell.libware.file.Logger.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "showIconBubble");
        com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().showIconBubble(msgItem);
    }
}
