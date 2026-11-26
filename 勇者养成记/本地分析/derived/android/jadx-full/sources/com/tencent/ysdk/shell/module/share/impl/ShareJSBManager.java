package com.tencent.ysdk.shell.module.share.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ShareJSBManager {
    private static final java.lang.String TAG = "ShareJSBManager";
    private static com.tencent.ysdk.shell.module.share.impl.ShareJSBManager instance;
    private java.lang.String description;
    private java.lang.String extInfo;
    public boolean isConfigEnable = com.tencent.ysdk.shell.framework.config.Config.isSwitchEnabled(com.tencent.ysdk.shell.framework.config.Config.YSDK_H5SHARE_SWITCH, true);
    private com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge;
    private java.lang.String pageURL;
    private com.tencent.ysdk.shell.module.share.ShareApiImpl shareApiImpl;
    private java.lang.String shareFunction;
    private com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.ShareJSBManagerShareCallBackImpl shareJSBManagerShareCallBack;
    private java.lang.String shareMethod;
    private int shareSeqid;
    private java.lang.String thumbURL;
    private java.lang.String title;

    private class ShareJSBManagerShareCallBackImpl implements com.tencent.ysdk.module.share.ShareCallBack {
        private ShareJSBManagerShareCallBackImpl() {
        }

        @Override // com.tencent.ysdk.module.share.ShareCallBack
        public void onCancel(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
            com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.this.shareCallBackToJSBridge(shareRet);
        }

        @Override // com.tencent.ysdk.module.share.ShareCallBack
        public void onError(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
            com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.this.shareCallBackToJSBridge(shareRet);
        }

        @Override // com.tencent.ysdk.module.share.ShareCallBack
        public void onSuccess(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
            com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.this.shareCallBackToJSBridge(shareRet);
        }
    }

    private ShareJSBManager() {
        if (!this.isConfigEnable) {
            com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "ShareJSBManager is closed");
            return;
        }
        com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "ShareJSBManager is enable");
        this.shareApiImpl = com.tencent.ysdk.shell.module.share.ShareApiImpl.getInstance();
        this.shareJSBManagerShareCallBack = new com.tencent.ysdk.shell.module.share.impl.ShareJSBManager.ShareJSBManagerShareCallBackImpl();
    }

    public static synchronized com.tencent.ysdk.shell.module.share.impl.ShareJSBManager getInstance() {
        if (instance == null) {
            instance = new com.tencent.ysdk.shell.module.share.impl.ShareJSBManager();
        }
        return instance;
    }

    private void initShareFunctionParames(java.lang.String str, java.lang.String str2, int i, android.net.Uri uri, com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge) {
        if (isConfigEnable()) {
            this.shareFunction = str;
            this.shareSeqid = i;
            this.shareMethod = str2;
            this.jsBridge = jsBridge;
            this.thumbURL = uri.getQueryParameter("thumbURL");
            this.pageURL = uri.getQueryParameter("pageURL");
            this.title = uri.getQueryParameter("title");
            this.description = uri.getQueryParameter(com.tencent.open.SocialConstants.PARAM_COMMENT);
            this.extInfo = uri.getQueryParameter(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO);
            this.shareApiImpl.regShareCallBack(this.shareJSBManagerShareCallBack);
        }
    }

    private boolean isConfigEnable() {
        if (!this.isConfigEnable) {
            com.tencent.ysdk.shell.libware.file.Logger.e("ShareJSBManager is closed ,set Config Enable first.");
        }
        return this.isConfigEnable;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void shareCallBackToJSBridge(com.tencent.ysdk.module.share.impl.ShareRet shareRet) {
        if (this.jsBridge != null && !android.text.TextUtils.isEmpty(this.shareFunction) && !android.text.TextUtils.isEmpty(this.shareMethod)) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("shareType", shareRet.shareType.name());
                jSONObject.put("isFromCap", shareRet.isFromCap);
                jSONObject.put("retCode", shareRet.retCode);
                jSONObject.put(com.tencent.ysdk.shell.module.icon.impl.IconModuleStat.PARA_SHARE_EXTINFO, shareRet.extInfo);
                jSONObject.put("retMsg", shareRet.retMsg);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
            this.jsBridge.response(this.shareFunction, this.shareSeqid, this.shareMethod, jSONObject.toString());
            this.shareFunction = null;
            this.shareSeqid = 0;
            this.shareMethod = null;
        }
    }

    public synchronized void shareURLToQQFriend(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        initShareFunctionParames(str2, str, i, uri, jsBridge);
        this.shareApiImpl.shareURLToQQFriend(this.thumbURL, this.pageURL, this.title, this.description, this.extInfo);
    }

    public synchronized void shareURLToQZone(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        initShareFunctionParames(str2, str, i, uri, jsBridge);
        this.shareApiImpl.shareURLToQZone(this.thumbURL, this.pageURL, this.title, this.description, this.extInfo);
    }

    public synchronized void shareURLToWXFriend(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        initShareFunctionParames(str2, str, i, uri, jsBridge);
        this.shareApiImpl.shareURLToWXFriend(this.thumbURL, this.pageURL, this.title, this.description, this.extInfo);
    }

    public synchronized void shareURLToWXTimeline(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge jsBridge, android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        initShareFunctionParames(str2, str, i, uri, jsBridge);
        this.shareApiImpl.shareURLToWXTimeline(this.thumbURL, this.pageURL, this.title, this.description, this.extInfo);
    }
}
