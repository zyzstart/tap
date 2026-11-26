package com.tencent.connect.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseApi {
    public static java.lang.String businessId = null;
    public static java.lang.String installChannel = null;
    public static boolean isOEM = false;
    public static java.lang.String registerChannel;
    protected com.tencent.connect.auth.c b;
    protected com.tencent.connect.auth.QQToken c;

    public class TempRequestListener implements com.tencent.tauth.IRequestListener {
        private final com.tencent.tauth.IUiListener b;
        private final android.os.Handler c;

        public TempRequestListener(com.tencent.tauth.IUiListener iUiListener) {
            this.b = iUiListener;
            this.c = new android.os.Handler(com.tencent.open.utils.f.a().getMainLooper()) { // from class: com.tencent.connect.common.BaseApi.TempRequestListener.1
                @Override // android.os.Handler
                public void handleMessage(android.os.Message message) {
                    if (message.what == 0) {
                        com.tencent.connect.common.BaseApi.TempRequestListener.this.b.onComplete(message.obj);
                    } else {
                        com.tencent.connect.common.BaseApi.TempRequestListener.this.b.onError(new com.tencent.tauth.UiError(message.what, (java.lang.String) message.obj, null));
                    }
                }
            };
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onComplete(org.json.JSONObject jSONObject) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = jSONObject;
            messageObtainMessage.what = 0;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onConnectTimeoutException(org.apache.http.conn.ConnectTimeoutException connectTimeoutException) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = connectTimeoutException.getMessage();
            messageObtainMessage.what = -7;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onHttpStatusException(com.tencent.open.utils.HttpUtils.HttpStatusException httpStatusException) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = httpStatusException.getMessage();
            messageObtainMessage.what = -9;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onIOException(java.io.IOException iOException) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = iOException.getMessage();
            messageObtainMessage.what = -2;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onJSONException(org.json.JSONException jSONException) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = jSONException.getMessage();
            messageObtainMessage.what = -4;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onMalformedURLException(java.net.MalformedURLException malformedURLException) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = malformedURLException.getMessage();
            messageObtainMessage.what = -3;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onNetworkUnavailableException(com.tencent.open.utils.HttpUtils.NetworkUnavailableException networkUnavailableException) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = networkUnavailableException.getMessage();
            messageObtainMessage.what = -10;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onSocketTimeoutException(java.net.SocketTimeoutException socketTimeoutException) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = socketTimeoutException.getMessage();
            messageObtainMessage.what = -8;
            this.c.sendMessage(messageObtainMessage);
        }

        @Override // com.tencent.tauth.IRequestListener
        public void onUnknowException(java.lang.Exception exc) {
            android.os.Message messageObtainMessage = this.c.obtainMessage();
            messageObtainMessage.obj = exc.getMessage();
            messageObtainMessage.what = -6;
            this.c.sendMessage(messageObtainMessage);
        }
    }

    public BaseApi(com.tencent.connect.auth.QQToken qQToken) {
        this(null, qQToken);
    }

    public BaseApi(com.tencent.connect.auth.c cVar, com.tencent.connect.auth.QQToken qQToken) {
        this.b = cVar;
        this.c = qQToken;
    }

    private android.content.Intent a(android.app.Activity activity, android.content.Intent intent, java.util.Map map) {
        android.content.Intent intent2 = new android.content.Intent(activity.getApplicationContext(), (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
        intent2.putExtra("is_login", true);
        intent2.putExtra(com.tencent.connect.common.AssistActivity.EXTRA_INTENT, intent);
        if (map == null) {
            return intent2;
        }
        try {
            if (map.containsKey(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE)) {
                intent2.putExtra(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE, ((java.lang.Boolean) map.get(com.tencent.connect.common.Constants.KEY_RESTORE_LANDSCAPE)).booleanValue());
            }
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.BaseApi", "Exception", e);
        }
        return intent2;
    }

    protected android.os.Bundle a() {
        java.lang.String string;
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("format", "json");
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", android.os.Build.MODEL);
        bundle.putString("status_version", android.os.Build.VERSION.SDK);
        bundle.putString("sdkv", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        com.tencent.connect.auth.QQToken qQToken = this.c;
        if (qQToken != null && qQToken.isSessionValid()) {
            bundle.putString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, this.c.getAccessToken());
            bundle.putString("oauth_consumer_key", this.c.getAppId());
            bundle.putString("openid", this.c.getOpenId());
            bundle.putString("appid_for_getting_config", this.c.getAppId());
        }
        android.content.SharedPreferences sharedPreferences = com.tencent.open.utils.f.a().getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            string = "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId;
        } else {
            string = sharedPreferences.getString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
        }
        bundle.putString("pf", string);
        return bundle;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public java.lang.String a(java.lang.String str) {
        android.os.Bundle bundleA = a();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        if (!android.text.TextUtils.isEmpty(str)) {
            bundleA.putString("need_version", str);
        }
        sb.append("https://openmobile.qq.com/oauth2.0/m_jump_by_version");
        sb.append(com.tencent.open.utils.HttpUtils.encodeUrl(bundleA));
        return sb.toString();
    }

    protected void a(android.app.Activity activity, int i, android.content.Intent intent, boolean z) {
        android.content.Intent intent2 = new android.content.Intent(activity.getApplicationContext(), (java.lang.Class<?>) com.tencent.connect.common.AssistActivity.class);
        if (z) {
            intent2.putExtra("is_qq_mobile_share", true);
        }
        intent2.putExtra(com.tencent.connect.common.AssistActivity.EXTRA_INTENT, intent);
        activity.startActivityForResult(intent2, i);
    }

    protected void a(android.app.Activity activity, android.content.Intent intent, int i) {
        a(activity, intent, i, (java.util.Map) null);
    }

    protected void a(android.app.Activity activity, android.content.Intent intent, int i, java.util.Map map) {
        intent.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, i);
        activity.startActivityForResult(a(activity, intent, map), i);
    }

    protected void a(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.BaseApi", "--handleDownloadLastestQQ");
        new com.tencent.open.TDialog(activity, "", "https://login.imgcache.qq.com/ptlogin/static/qzsjump.html" + com.tencent.open.utils.HttpUtils.encodeUrl(bundle), null, this.c).show();
    }

    protected void a(android.support.v4.app.Fragment fragment, android.content.Intent intent, int i, java.util.Map map) {
        intent.putExtra(com.tencent.connect.common.Constants.KEY_REQUEST_CODE, i);
        fragment.startActivityForResult(a(fragment.getActivity(), intent, map), i);
    }

    protected boolean a(android.content.Intent intent) {
        if (intent != null) {
            return com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent);
        }
        return false;
    }

    protected android.content.Intent b(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        if (com.tencent.open.utils.l.c(com.tencent.open.utils.f.a())) {
            intent.setClassName(com.tencent.connect.common.Constants.PACKAGE_QQ_PAD, str);
            if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
                return intent;
            }
        }
        intent.setClassName("com.tencent.mobileqq", str);
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
            return intent;
        }
        intent.setClassName(com.tencent.connect.common.Constants.PACKAGE_TIM, str);
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
            return intent;
        }
        intent.setClassName(com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED, str);
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent)) {
            return intent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public android.os.Bundle b() {
        android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("appid", this.c.getAppId());
        if (this.c.isSessionValid()) {
            bundle.putString(com.tencent.connect.common.Constants.PARAM_KEY_STR, this.c.getAccessToken());
            bundle.putString(com.tencent.connect.common.Constants.PARAM_KEY_TYPE, "0x80");
        }
        java.lang.String openId = this.c.getOpenId();
        if (openId != null) {
            bundle.putString("hopenid", openId);
        }
        bundle.putString("platform", "androidqz");
        android.content.SharedPreferences sharedPreferences = com.tencent.open.utils.f.a().getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0);
        if (isOEM) {
            bundle.putString("pf", "desktop_m_qq-" + installChannel + "-android-" + registerChannel + "-" + businessId);
        } else {
            bundle.putString("pf", sharedPreferences.getString("pf", com.tencent.connect.common.Constants.DEFAULT_PF));
            bundle.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
        }
        bundle.putString("sdkv", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        return bundle;
    }

    protected android.content.Intent c(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        android.content.Intent intentB = b(str);
        if (intentB == null || intentB.getComponent() == null) {
            return null;
        }
        intent.setClassName(intentB.getComponent().getPackageName(), "com.tencent.open.agent.AgentActivity");
        return intent;
    }

    public void releaseResource() {
    }
}
