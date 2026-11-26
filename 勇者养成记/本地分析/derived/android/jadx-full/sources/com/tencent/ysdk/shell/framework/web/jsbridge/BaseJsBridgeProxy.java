package com.tencent.ysdk.shell.framework.web.jsbridge;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseJsBridgeProxy {
    private static final java.lang.String ACTIVITY_STATE_CHANGE_CALLBACK = "activityStateCallback";
    private static final java.lang.String ON_SHAKE_CALLBACK = "onShakeCallback";
    public static final int PAGE_CONTROL_GO_BACK = 1;
    public static final int PAGE_CONTROL_GO_FORWARD = 2;
    public static final int PAGE_CONTROL_RELOAD = 0;
    public static final java.lang.String STATUS_NO = "0";
    public static final java.lang.String STATUS_OK = "1";
    protected android.content.Context mContext;
    public com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge mJsBridge;
    protected int mType;
    protected com.tencent.smtt.sdk.WebView mWebView;
    private com.tencent.ysdk.shell.framework.web.SensorManagerHelper sensorManagerHelper;

    public BaseJsBridgeProxy(com.tencent.smtt.sdk.WebView webView, android.content.Context context) {
        this.mWebView = webView;
        this.mContext = context;
        this.mJsBridge = new com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge(this.mWebView, this.mContext);
        this.mType = 2;
    }

    public BaseJsBridgeProxy(com.tencent.smtt.sdk.WebView webView, android.content.Context context, int i) {
        this.mWebView = webView;
        this.mContext = context;
        this.mJsBridge = new com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge(this.mWebView, this.mContext);
        this.mType = i;
    }

    private void callBatchMethod(android.net.Uri uri, java.lang.String str, int i, java.lang.String str2) {
        try {
            if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
                getClass().getMethod(str, android.net.Uri.class, java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class).invoke(this, uri, java.lang.Integer.valueOf(i), str, str2);
            } else if (!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str2)) {
                this.mJsBridge.responseFail(str2, i, str, -2);
            }
        } catch (java.lang.Exception e) {
            com.tencent.ysdk.shell.libware.file.Logger.e("JSBridge method has error");
            com.tencent.ysdk.shell.libware.file.Logger.d(e.toString());
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str2)) {
                return;
            }
            this.mJsBridge.responseFail(str2, i, str, -3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getClipboardUiThread(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        java.lang.String string = "";
        if (android.os.Build.VERSION.SDK_INT > 10) {
            android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) this.mContext.getSystemService("clipboard");
            if (clipboardManager == null) {
                this.mJsBridge.responseFail(str2, i, str, -2);
                return;
            }
            string = clipboardManager.hasPrimaryClip() ? clipboardManager.getPrimaryClip().getItemAt(0).getText().toString() : "";
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            try {
                jSONObject.put("content", string);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                this.mJsBridge.responseFail(str2, i, str, -3);
            }
            this.mJsBridge.response(str2, i, str, jSONObject.toString());
            return;
        }
        android.text.ClipboardManager clipboardManager2 = (android.text.ClipboardManager) this.mContext.getSystemService("clipboard");
        try {
            if (clipboardManager2 == null) {
                this.mJsBridge.responseFail(str2, i, str, -2);
                return;
            }
            if (clipboardManager2.hasText() && clipboardManager2.getText() != null) {
                string = clipboardManager2.getText().toString();
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            try {
                jSONObject2.put("content", string);
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                this.mJsBridge.responseFail(str2, i, str, -3);
            }
            this.mJsBridge.response(str2, i, str, jSONObject2.toString());
        } catch (java.lang.Exception e3) {
            e3.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void invokeAsync(java.lang.String str) {
        android.net.Uri uri = android.net.Uri.parse(str);
        java.lang.String host = uri.getHost();
        if (android.text.TextUtils.isEmpty(host)) {
            return;
        }
        java.util.List<java.lang.String> pathSegments = uri.getPathSegments();
        java.lang.String str2 = null;
        int i = 0;
        if (pathSegments != null && pathSegments.size() > 0) {
            try {
                i = java.lang.Integer.parseInt(pathSegments.get(0));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (pathSegments.size() > 1) {
                str2 = pathSegments.get(1);
            }
        }
        if (!host.equals(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.CALL_BATCH_NAME)) {
            callBatchMethod(uri, host, i, str2);
            return;
        }
        try {
            invokeAsyncInner(uri);
        } catch (java.lang.Exception e2) {
            com.tencent.ysdk.shell.libware.file.Logger.d(e2.toString());
            e2.printStackTrace();
        }
    }

    private void invokeAsyncInner(android.net.Uri uri) throws org.json.JSONException {
        org.json.JSONObject jSONObject;
        org.json.JSONArray jSONArray = new org.json.JSONArray(uri.getQueryParameter("param"));
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            org.json.JSONObject jSONObject2 = jSONArray.getJSONObject(i);
            java.lang.String string = jSONObject2.getString("method");
            int i2 = jSONObject2.getInt("seqid");
            java.lang.String strOptString = jSONObject2.has("callback") ? jSONObject2.optString("callback") : null;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.tencent.ysdk.shell.framework.web.jsbridge.JsBridge.JS_BRIDGE_SCHEME);
            sb.append(string);
            sb.append("/");
            sb.append(i2);
            sb.append("/");
            sb.append(!com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(strOptString) ? strOptString : "");
            sb.append(com.tencent.ysdk.shell.libware.util.YSDKURLUtils.HTTP_REQ_ENTITY_START);
            if (jSONObject2.has("args") && (jSONObject = jSONObject2.getJSONObject("args")) != null) {
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    java.lang.String strDecode = android.net.Uri.decode(jSONObject.getString(next));
                    sb.append(next);
                    sb.append("=");
                    sb.append(android.net.Uri.encode(strDecode));
                    sb.append("&");
                }
            }
            callBatchMethod(android.net.Uri.parse(sb.toString()), string, i2, strOptString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setClipboardUiThread(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        java.lang.String queryParameter = uri.getQueryParameter("content");
        if (android.os.Build.VERSION.SDK_INT > 10) {
            android.content.ClipboardManager clipboardManager = (android.content.ClipboardManager) this.mContext.getSystemService("clipboard");
            if (clipboardManager == null) {
                this.mJsBridge.responseFail(str2, i, str, -2);
                return;
            }
            if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(queryParameter)) {
                clipboardManager.setPrimaryClip(android.content.ClipData.newPlainText(null, ""));
            } else {
                clipboardManager.setPrimaryClip(android.content.ClipData.newPlainText(null, queryParameter));
            }
            this.mJsBridge.response(str2, i, str, "");
            return;
        }
        android.text.ClipboardManager clipboardManager2 = (android.text.ClipboardManager) this.mContext.getSystemService("clipboard");
        if (clipboardManager2 == null) {
            this.mJsBridge.responseFail(str2, i, str, -2);
            return;
        }
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(queryParameter)) {
            clipboardManager2.setText("");
        } else {
            clipboardManager2.setText(queryParameter);
        }
        this.mJsBridge.response(str2, i, str, "");
    }

    private void setShakeState(boolean z) {
        if (z) {
            if (this.sensorManagerHelper == null) {
                this.sensorManagerHelper = new com.tencent.ysdk.shell.framework.web.SensorManagerHelper(this.mContext);
                this.sensorManagerHelper.start();
                this.sensorManagerHelper.setOnShakeListener(new com.tencent.ysdk.shell.framework.web.SensorManagerHelper.OnShakeListener() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.7
                    @Override // com.tencent.ysdk.shell.framework.web.SensorManagerHelper.OnShakeListener
                    public void onShake() {
                        com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.this.mJsBridge.response(com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.ON_SHAKE_CALLBACK, 0, null, "onShake");
                    }
                });
                return;
            }
            return;
        }
        com.tencent.ysdk.shell.framework.web.SensorManagerHelper sensorManagerHelper = this.sensorManagerHelper;
        if (sensorManagerHelper != null) {
            sensorManagerHelper.stop();
            this.sensorManagerHelper = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showErrorPageUiThread(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        int i2;
        try {
            java.lang.String queryParameter = uri.getQueryParameter("flag");
            i2 = !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(queryParameter) ? java.lang.Integer.parseInt(queryParameter) : 0;
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
            i2 = 0;
        }
        if (i2 == 0) {
            com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().showErrorPage(false);
        } else if (i2 == 1) {
            com.tencent.ysdk.shell.module.icon.impl.IconManager.getInstance().showErrorPage(true);
        }
    }

    public void closeWebView(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.closeForOut(this.mType);
    }

    public void getChannel(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        this.mJsBridge.response(str2, i, str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getChannelId());
    }

    public void getClipboard(final android.net.Uri uri, final int i, final java.lang.String str, final java.lang.String str2) {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.6
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.this.getClipboardUiThread(uri, i, str, str2);
                }
            });
        } else {
            getClipboardUiThread(uri, i, str, str2);
        }
    }

    public void getGameScreenDir(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        this.mJsBridge.response(str2, i, str, java.lang.String.valueOf(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getGameScreenDir().val()));
    }

    public void getYSDKVersion(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        this.mJsBridge.response(str2, i, str, com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getVersion());
    }

    public void getYYBLiteVersion(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        this.mJsBridge.response(str2, i, str, com.tencent.ysdk.shell.framework.web.YYBVersionHelper.getYYBListVersion());
    }

    public void hideH5CloseBtn(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowser ySDKWebBrowserManager = com.tencent.ysdk.shell.framework.web.browser.YSDKWebBrowserManager.getInstance(this.mType);
        if (ySDKWebBrowserManager != null) {
            ySDKWebBrowserManager.hideCloseButton();
        }
    }

    public void invoke(final java.lang.String str) {
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().start(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.1
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.this.invokeAsync(str);
            }
        });
    }

    public void isMyAPPInstalled(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        this.mJsBridge.response(str2, i, str, java.lang.String.valueOf(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().isPlatformInstalled(com.tencent.ysdk.framework.common.ePlatform.MyApp) ? 1 : 0));
    }

    public void onPause() {
        this.mJsBridge.response(ACTIVITY_STATE_CHANGE_CALLBACK, 0, null, "onPause");
    }

    public void onResume() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("state", "1");
        this.mJsBridge.response(ACTIVITY_STATE_CHANGE_CALLBACK, 0, null, "onResume", map);
    }

    public void onWebViewClose() {
        setShakeState(false);
    }

    public void pageControl(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        int i2;
        try {
            i2 = java.lang.Integer.parseInt(uri.getQueryParameter(com.tencent.open.SocialConstants.PARAM_TYPE));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            i2 = 0;
        }
        com.tencent.smtt.sdk.WebView webView = this.mWebView;
        if (webView != null) {
            if (i2 == 1) {
                webView.goBack();
            } else if (i2 == 2) {
                webView.goForward();
            } else {
                webView.reload();
            }
        }
        this.mJsBridge.response(str2, i, str, "");
    }

    public void registerRealName(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().registerRealName();
    }

    public void setClipboard(final android.net.Uri uri, final int i, final java.lang.String str, final java.lang.String str2) {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.5
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.this.setClipboardUiThread(uri, i, str, str2);
                }
            });
        } else {
            setClipboardUiThread(uri, i, str, str2);
        }
    }

    public void setShake(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        try {
            java.lang.String queryParameter = uri.getQueryParameter("enable");
            boolean zEquals = android.text.TextUtils.isEmpty(queryParameter) ? false : com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON.equals(queryParameter);
            setShakeState(zEquals);
            this.mJsBridge.response(str2, i, str, java.lang.String.valueOf(zEquals));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            this.mJsBridge.responseFail(str2, i, str, -3);
        }
    }

    public void showErrorPage(final android.net.Uri uri, final int i, final java.lang.String str, final java.lang.String str2) {
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.3
                @Override // java.lang.Runnable
                public void run() {
                    com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.this.showErrorPageUiThread(uri, i, str, str2);
                }
            });
        } else {
            showErrorPageUiThread(uri, i, str, str2);
        }
    }

    public void toast(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        final int i2;
        try {
            java.lang.String queryParameter = uri.getQueryParameter("duration");
            i2 = !com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(queryParameter) ? java.lang.Integer.parseInt(queryParameter) : 0;
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
            i2 = 0;
        }
        final java.lang.String queryParameter2 = uri.getQueryParameter(com.unisound.sdk.cb.h);
        if (java.lang.Thread.currentThread() != android.os.Looper.getMainLooper().getThread()) {
            com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.4
                @Override // java.lang.Runnable
                public void run() {
                    android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), queryParameter2, i2 != 1 ? 0 : 1).show();
                }
            });
        } else {
            android.widget.Toast.makeText(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getActivity(), queryParameter2, i2 == 1 ? 1 : 0).show();
        }
    }

    public void userLogout(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.libware.file.Logger.d("YSDK_LOGIN_ANTI_ADDICTION", "logout");
        com.tencent.ysdk.shell.libware.thread.YSDKThreadManager.getInstance().runOnUIThread(new java.lang.Runnable() { // from class: com.tencent.ysdk.shell.framework.web.jsbridge.BaseJsBridgeProxy.2
            @Override // java.lang.Runnable
            public void run() {
                com.tencent.ysdk.shell.module.stat.StatHelper.reportEventData(com.tencent.ysdk.shell.module.stat.StatEvent.EVENT_USER_LOGOUT, 0, "user logout", null, java.lang.System.currentTimeMillis(), true, com.tencent.ysdk.shell.module.stat.StatConstants.EventType.Click, "");
                com.tencent.ysdk.api.YSDKApi.logout();
                com.tencent.ysdk.module.user.UserLoginRet userLoginRet = new com.tencent.ysdk.module.user.UserLoginRet();
                userLoginRet.setLoginType(3);
                userLoginRet.ret = 1;
                userLoginRet.setLoginType(3);
                userLoginRet.flag = 3105;
                userLoginRet.msg = "user logout";
                com.tencent.ysdk.shell.module.user.UserApi.getInstance().notifyLoginAsync(userLoginRet);
            }
        });
    }

    public void visitorLogin(android.net.Uri uri, int i, java.lang.String str, java.lang.String str2) {
        com.tencent.ysdk.shell.module.antiaddiction.AntiAddictionApi.getInstance().visitorLogin();
    }
}
