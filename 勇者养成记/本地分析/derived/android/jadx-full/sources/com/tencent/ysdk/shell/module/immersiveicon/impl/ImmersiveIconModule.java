package com.tencent.ysdk.shell.module.immersiveicon.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ImmersiveIconModule extends com.tencent.ysdk.shell.module.Module implements com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface {
    private static final java.lang.String ICON_DEFAULT_VERSION = "YSDK_1";
    private static final java.lang.String KEY_ICON_SHOW_PERFORM_FEATURE_EXTRADATA = "KEY_ICON_SHOW_PERFORM_FEATURE_EXTRADATA";
    private static final java.lang.String KEY_ICON_SHOW_PERFORM_FEATURE_TAG = "KEY_ICON_SHOW_PERFORM_FEATURE_TAG";
    private static final int MSG_ICON_GET_SETTINGS = 1;
    private static final int MSG_ICON_SHOW_PERFORM_FEATURE = 2;
    public static final java.lang.String TAG = "YSDK IMMERSIVE ICON";
    private java.util.HashMap<java.lang.String, java.lang.String> extraDataToLoad;
    private java.util.List<com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem> featureItems;
    private com.tencent.ysdk.module.immersiveicon.OnStateChangeListener mListener;
    private android.os.Handler mUiHandler = null;
    private android.os.Handler mBgHandler = null;
    private java.lang.String mIconVersion = "";
    private java.lang.String featureTagToLoad = null;

    private class GetFeatureResponseHandle implements com.tencent.ysdk.shell.framework.request.HttpResponseHandler<com.tencent.ysdk.shell.module.immersiveicon.impl.request.GetFeatureResponse> {
        public GetFeatureResponseHandle() {
        }

        @Override // com.tencent.ysdk.shell.framework.request.HttpResponseHandler
        public void onResponse(com.tencent.ysdk.shell.module.immersiveicon.impl.request.GetFeatureResponse getFeatureResponse) {
            com.tencent.ysdk.shell.libware.file.Logger.d(getFeatureResponse.toString());
            if (getFeatureResponse.ret != 0) {
                com.tencent.ysdk.shell.libware.file.Logger.w("load icon get bad response, don't show icon");
                return;
            }
            com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.featureItems = getFeatureResponse.featureItems;
            if (com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.featureTagToLoad != null) {
                com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule immersiveIconModule = com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this;
                immersiveIconModule.performImmersiveIconAction(immersiveIconModule.featureTagToLoad, com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.extraDataToLoad);
                com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.featureTagToLoad = null;
                com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.extraDataToLoad = null;
            }
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
            com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.getFeatureListFromServerAsync();
        }
    }

    private class HandlerInUI extends android.os.Handler {
        public HandlerInUI(android.os.Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            if (message.what != 2) {
                return;
            }
            com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.performImmersiveIconActionInUIThread((java.lang.String) message.getData().get(com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.KEY_ICON_SHOW_PERFORM_FEATURE_TAG), (java.util.HashMap) message.getData().get(com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.KEY_ICON_SHOW_PERFORM_FEATURE_EXTRADATA));
        }
    }

    private class UserInnerLoginListenerImp implements com.tencent.ysdk.shell.module.user.UserInnerLoginListener {
        private UserInnerLoginListenerImp() {
        }

        @Override // com.tencent.ysdk.shell.module.user.UserInnerLoginListener
        public void OnLoginNotify(com.tencent.ysdk.module.user.UserLoginRet userLoginRet) {
            if (userLoginRet != null) {
                if (userLoginRet.ret != 0 || userLoginRet.flag != 0) {
                    com.tencent.ysdk.shell.libware.file.Logger.e("Immersive IconModule login Fail");
                } else if (userLoginRet.getLoginType() == 0 || 1 == userLoginRet.getLoginType()) {
                    com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.this.getFeatureListFromServer();
                }
            }
        }
    }

    public ImmersiveIconModule() {
        this.name = com.tencent.ysdk.shell.module.ModuleManager.YSDK_MODULE_NAME_IMMERSIVE_ICON;
    }

    private com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem findItem(java.lang.String str) {
        java.util.List<com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem> list = this.featureItems;
        if (list == null || str == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e("performImmersiveIconModule not init or param error");
            return null;
        }
        for (com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem featureItem : list) {
            if (str.equals(featureItem.getDesc())) {
                com.tencent.ysdk.shell.libware.file.Logger.d("performImmersiveIconAction tag " + str + " find ,URL is " + featureItem.getJmpUrl());
                return featureItem;
            }
        }
        com.tencent.ysdk.shell.libware.file.Logger.e("performImmersiveIconAction tag " + str + " not find");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getFeatureListFromServerAsync() {
        com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.GetFeatureResponseHandle getFeatureResponseHandle = new com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.GetFeatureResponseHandle();
        com.tencent.ysdk.module.user.UserLoginRet loginRecord = com.tencent.ysdk.shell.module.user.UserApi.getInstance().getLoginRecord();
        com.tencent.ysdk.shell.framework.request.YSDKServer.getInstance().doRequest(new com.tencent.ysdk.shell.module.immersiveicon.impl.request.GetFeatureRequest(com.tencent.ysdk.framework.common.ePlatform.getEnum(loginRecord.platform), loginRecord.open_id, 7 == loginRecord.platform ? loginRecord.getPayToken() : loginRecord.getAccessToken(), getFeatureResponseHandle));
    }

    public void getFeatureListFromServer() {
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_IMMERSIVE_ICON_SWITCH, false)) {
            com.tencent.ysdk.shell.libware.file.Logger.w("getFeatureListFromServer icon module is closed");
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "get Feature List From Server");
            this.mBgHandler.sendEmptyMessage(1);
        }
    }

    public java.lang.String getIconVersion() {
        if (com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_IMMERSIVE_ICON_SWITCH, false)) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "getIconVersion");
            return this.mIconVersion;
        }
        com.tencent.ysdk.shell.libware.file.Logger.w("getFeatureListFromServer icon module is closed");
        return "";
    }

    @Override // com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface
    public java.lang.String getImmersiveIconVersion() {
        return getIconVersion();
    }

    @Override // com.tencent.ysdk.shell.module.Module
    public void init() {
        super.init();
        if (!com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_IMMERSIVE_ICON_SWITCH, false)) {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "ImmersiveIcon is closed");
            return;
        }
        this.mIconVersion = com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.YSDK_IMMERSIVE_ICON_VERSION, ICON_DEFAULT_VERSION);
        this.mUiHandler = new com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.HandlerInUI(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(0));
        this.mBgHandler = new com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.HandlerInBG(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getLooper(1));
        com.tencent.ysdk.shell.module.user.UserApi.setUserInnerLoginListener(new com.tencent.ysdk.shell.module.immersiveicon.impl.ImmersiveIconModule.UserInnerLoginListenerImp());
    }

    @Override // com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface
    public void notifyStateChange(java.lang.String str, boolean z) {
        android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "ImmersiveIcon NotifyStateChange innerTag:" + str + " hasNew" + z);
        if (this.mListener == null) {
            android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "ImmersiveIcon NotifyStateChange listener is Null");
            return;
        }
        java.lang.String desc = null;
        try {
            for (com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem featureItem : this.featureItems) {
                if (!android.text.TextUtils.isEmpty(featureItem.getIconID()) && featureItem.getIconID().equals(str)) {
                    desc = featureItem.getDesc();
                    android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "Find innerTag:" + str + " outterTag " + desc);
                    break;
                }
            }
            if (android.text.TextUtils.isEmpty(desc)) {
                android.util.Log.e(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "innerID Not match out Tag");
            } else {
                this.mListener.onStateChange(desc, z);
            }
        } catch (java.lang.Exception e) {
            android.util.Log.e(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "游戏请检查红点状态改变逻辑异常");
            e.printStackTrace();
        }
    }

    @Override // com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface
    public void performImmersiveIconAction(java.lang.String str) {
        com.tencent.ysdk.shell.libware.file.Logger.d("performImmersiveIconAction tag " + str);
        performImmersiveIconAction(str, null);
    }

    @Override // com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface
    public void performImmersiveIconAction(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.libware.file.Logger.d("performImmersiveIconAction tag " + str);
        android.os.Message messageObtainMessage = this.mUiHandler.obtainMessage();
        messageObtainMessage.what = 2;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putSerializable(KEY_ICON_SHOW_PERFORM_FEATURE_EXTRADATA, map);
        bundle.putSerializable(KEY_ICON_SHOW_PERFORM_FEATURE_TAG, str);
        messageObtainMessage.setData(bundle);
        this.mUiHandler.sendMessage(messageObtainMessage);
    }

    public void performImmersiveIconActionInUIThread(java.lang.String str, java.util.HashMap<java.lang.String, java.lang.String> map) {
        com.tencent.ysdk.shell.libware.file.Logger.d("performImmersiveIconActionInUIThread tag " + str);
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.ysdk.shell.libware.file.Logger.d("performImmersiveIconActionInUIThread tag is Null");
        }
        com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem featureItemFindItem = findItem(str);
        if (featureItemFindItem == null) {
            if (this.featureItems == null) {
                android.util.Log.i(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "performImmersiveIconActionInUIThread tag " + str + " is Not ready. will load soon");
                this.featureTagToLoad = str;
                this.extraDataToLoad = map;
                return;
            }
            return;
        }
        com.tencent.ysdk.shell.framework.web.router.IntentRouter.commonJump(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext(), featureItemFindItem.getJmpUrl(), map, 1);
        if (!featureItemFindItem.isRed()) {
            android.util.Log.i(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "performImmersiveIconActionInUIThread tag " + str + " is Not Red.");
            return;
        }
        android.util.Log.i(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "performImmersiveIconActionInUIThread tag " + str + " isRed.");
        com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.stateUpdate(featureItemFindItem.getIconID(), featureItemFindItem.getTs());
    }

    @Override // com.tencent.ysdk.shell.module.immersiveicon.ImmersiveIconInterface
    public void regOnStateChangeListener(com.tencent.ysdk.module.immersiveicon.OnStateChangeListener onStateChangeListener) {
        android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "ImmersiveIcon regOnStateChangeListener");
        this.mListener = onStateChangeListener;
        java.util.List<com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem> list = this.featureItems;
        if (list == null) {
            return;
        }
        for (com.tencent.ysdk.shell.module.immersiveicon.impl.FeatureItem featureItem : list) {
            if (featureItem.isRed()) {
                android.util.Log.d(com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.TAG, "ImmersiveIcon iconID: " + featureItem.getIconID() + "isRed");
                notifyStateChange(featureItem.getIconID(), com.tencent.ysdk.shell.module.icon.impl.IconRedPointManager.needShowRedPoint(featureItem.getIconID(), featureItem.getTs()));
            }
        }
    }
}
