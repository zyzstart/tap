package com.tencent.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SocialApiIml extends com.tencent.connect.common.BaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.app.Activity f674a;

    private class a extends com.tencent.tauth.DefaultUiListener {
        private com.tencent.tauth.IUiListener b;
        private java.lang.String c;
        private java.lang.String d;
        private android.os.Bundle e;
        private android.app.Activity f;

        a(android.app.Activity activity, com.tencent.tauth.IUiListener iUiListener, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
            this.b = iUiListener;
            this.c = str;
            this.d = str2;
            this.e = bundle;
            this.f = activity;
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onCancel() {
            this.b.onCancel();
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onComplete(java.lang.Object obj) {
            java.lang.String string;
            try {
                string = ((org.json.JSONObject) obj).getString(com.tencent.open.SocialConstants.PARAM_ENCRY_EOKEN);
            } catch (org.json.JSONException e) {
                e.printStackTrace();
                com.tencent.open.log.SLog.e("[REDACTED]", "[REDACTED]", e);
                string = null;
            }
            this.e.putString("[REDACTED]", string);
            com.tencent.open.SocialApiIml socialApiIml = com.tencent.open.SocialApiIml.this;
            socialApiIml.a((android.content.Context) socialApiIml.f674a, this.c, this.e, this.d, this.b);
            if (android.text.TextUtils.isEmpty(string)) {
                com.tencent.open.log.SLog.d("[REDACTED]", "[REDACTED]");
                com.tencent.open.SocialApiIml.this.writeEncryToken(this.f);
            }
        }

        @Override // com.tencent.tauth.DefaultUiListener, com.tencent.tauth.IUiListener
        public void onError(com.tencent.tauth.UiError uiError) {
            com.tencent.open.log.SLog.d("[REDACTED]", "[REDACTED]" + uiError.errorMessage);
            this.b.onError(uiError);
        }
    }

    public SocialApiIml(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    public SocialApiIml(com.tencent.connect.auth.c cVar, com.tencent.connect.auth.QQToken qQToken) {
        super(cVar, qQToken);
    }

    private void a(android.app.Activity activity, android.content.Intent intent, java.lang.String str, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithAgent action = " + str);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, str);
        intent.putExtra(com.tencent.connect.common.Constants.KEY_PARAMS, bundle);
        com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_SOCIAL_API, iUiListener);
        a(activity, intent, com.tencent.connect.common.Constants.REQUEST_SOCIAL_API);
    }

    private void a(android.app.Activity activity, android.content.Intent intent, java.lang.String str, android.os.Bundle bundle, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener, boolean z) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("-->handleIntent action = ");
        sb.append(str);
        sb.append(", activityIntent = null ? ");
        boolean z2 = true;
        sb.append(intent == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.SocialApiIml", sb.toString());
        if (intent != null) {
            a(activity, intent, str, bundle, iUiListener);
            return;
        }
        com.tencent.open.utils.g gVarA = com.tencent.open.utils.g.a(com.tencent.open.utils.f.a(), this.c.getAppId());
        if (!z && !gVarA.b("C_LoginH5")) {
            z2 = false;
        }
        if (z2) {
            a(activity, str, bundle, str2, iUiListener);
        } else {
            a(activity, bundle, iUiListener);
        }
    }

    private void a(android.app.Activity activity, java.lang.String str, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str2;
        java.lang.String str3;
        this.f674a = activity;
        android.content.Intent intentC = c(com.tencent.open.SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (intentC == null) {
            com.tencent.open.log.SLog.i("openSDK_LOG.SocialApiIml", "--askgift--friend chooser not found");
            intentC = c(com.tencent.open.SocialConstants.ACTIVITY_ASK_GIFT);
        }
        android.content.Intent intent = intentC;
        bundle.putAll(b());
        if (!com.tencent.open.SocialConstants.ACTION_ASK.equals(str)) {
            if (com.tencent.open.SocialConstants.ACTION_GIFT.equals(str)) {
                str2 = com.tencent.open.SocialConstants.PARAM_TYPE;
                str3 = com.tencent.open.SocialConstants.TYPE_FREEGIFT;
            }
            a(activity, intent, str, bundle, com.tencent.open.utils.h.a().a(com.tencent.open.utils.f.a(), "https://login.imgcache.qq.com/open/mobile/request/sdk_request.html"), iUiListener, false);
        }
        str2 = com.tencent.open.SocialConstants.PARAM_TYPE;
        str3 = com.tencent.open.SocialConstants.TYPE_REQUEST;
        bundle.putString(str2, str3);
        a(activity, intent, str, bundle, com.tencent.open.utils.h.a().a(com.tencent.open.utils.f.a(), "https://login.imgcache.qq.com/open/mobile/request/sdk_request.html"), iUiListener, false);
    }

    private void a(android.app.Activity activity, java.lang.String str, android.os.Bundle bundle, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.SocialApiIml", "-->handleIntentWithH5 action = " + str);
        android.content.Intent intentB = b("com.tencent.open.agent.AgentActivity");
        com.tencent.tauth.IUiListener aVar = new com.tencent.open.SocialApiIml.a(activity, iUiListener, str, str2, bundle);
        android.content.Intent intentB2 = b("[REDACTED]");
        if (intentB2 != null && intentB != null && intentB.getComponent() != null && intentB2.getComponent() != null && intentB.getComponent().getPackageName().equals(intentB2.getComponent().getPackageName())) {
            intentB2.putExtra("oauth_consumer_key", this.c.getAppId());
            intentB2.putExtra("openid", this.c.getOpenId());
            intentB2.putExtra(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, this.c.getAccessToken());
            intentB2.putExtra(com.tencent.connect.common.Constants.KEY_ACTION, com.tencent.open.SocialConstants.ACTION_CHECK_TOKEN);
            if (a(intentB2)) {
                com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
                com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_SOCIAL_H5, aVar);
                a(activity, intentB2, com.tencent.connect.common.Constants.REQUEST_SOCIAL_H5);
                return;
            }
            return;
        }
        com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
        java.lang.String strF = com.tencent.open.utils.l.f("[REDACTED]" + this.c.getAccessToken() + this.c.getAppId() + this.c.getOpenId() + "[REDACTED]");
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.put(com.tencent.open.SocialConstants.PARAM_ENCRY_EOKEN, strF);
        } catch (org.json.JSONException e) {
            e.printStackTrace();
        }
        aVar.onComplete(jSONObject);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(android.content.Context context, java.lang.String str, android.os.Bundle bundle, java.lang.String str2, com.tencent.tauth.IUiListener iUiListener) {
        android.app.Dialog cVar;
        com.tencent.open.log.SLog.v("openSDK_LOG.SocialApiIml", "OpenUi, showDialog --start");
        android.webkit.CookieSyncManager.createInstance(context);
        bundle.putString("oauth_consumer_key", this.c.getAppId());
        if (this.c.isSessionValid()) {
            bundle.putString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN, this.c.getAccessToken());
        }
        java.lang.String openId = this.c.getOpenId();
        if (openId != null) {
            bundle.putString("openid", openId);
        }
        try {
            bundle.putString("pf", com.tencent.open.utils.f.a().getSharedPreferences(com.tencent.connect.common.Constants.PREFERENCE_PF, 0).getString("pf", com.tencent.connect.common.Constants.DEFAULT_PF));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            bundle.putString("pf", com.tencent.connect.common.Constants.DEFAULT_PF);
        }
        java.lang.String str3 = str2 + com.tencent.open.utils.HttpUtils.encodeUrl(bundle);
        com.tencent.open.log.SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog TDialog");
        if (com.tencent.open.SocialConstants.ACTION_CHALLENGE.equals(str) || com.tencent.open.SocialConstants.ACTION_BRAG.equals(str)) {
            com.tencent.open.log.SLog.d("openSDK_LOG.SocialApiIml", "OpenUi, showDialog PKDialog");
            cVar = new com.tencent.open.c(this.f674a, str, str3, iUiListener, this.c);
        } else {
            cVar = new com.tencent.open.TDialog(this.f674a, str, str3, iUiListener, this.c);
        }
        cVar.show();
    }

    public void ask(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        a(activity, com.tencent.open.SocialConstants.ACTION_ASK, bundle, iUiListener);
    }

    @Override // com.tencent.connect.common.BaseApi
    protected android.content.Intent b(java.lang.String str) {
        android.content.Intent intent = new android.content.Intent();
        intent.setClassName("com.qzone", str);
        android.content.Intent intent2 = new android.content.Intent();
        intent2.setClassName("com.tencent.mobileqq", str);
        android.content.Intent intent3 = new android.content.Intent();
        intent3.setClassName(com.tencent.connect.common.Constants.PACKAGE_QQ_PAD, str);
        if (com.tencent.open.utils.l.c(com.tencent.open.utils.f.a()) && com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent3)) {
            return intent3;
        }
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent2) && com.tencent.open.utils.i.c(com.tencent.open.utils.f.a(), "4.7") >= 0) {
            return intent2;
        }
        if (com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent) && com.tencent.open.utils.i.a(com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), "com.qzone"), "4.2") >= 0 && com.tencent.open.utils.i.a(com.tencent.open.utils.f.a(), intent.getComponent().getPackageName(), com.tencent.connect.common.Constants.SIGNATRUE_QZONE)) {
            return intent;
        }
        return null;
    }

    public void gift(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        a(activity, com.tencent.open.SocialConstants.ACTION_GIFT, bundle, iUiListener);
    }

    public void invite(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.f674a = activity;
        android.content.Intent intentC = c(com.tencent.open.SocialConstants.ACTIVITY_FRIEND_CHOOSER);
        if (intentC == null) {
            com.tencent.open.log.SLog.i("openSDK_LOG.SocialApiIml", "--invite--friend chooser not found");
            intentC = c(com.tencent.open.SocialConstants.ACTIVITY_INVITE);
        }
        bundle.putAll(b());
        a(activity, intentC, com.tencent.open.SocialConstants.ACTION_INVITE, bundle, com.tencent.open.utils.h.a().a(com.tencent.open.utils.f.a(), "https://login.imgcache.qq.com/open/mobile/invite/sdk_invite.html"), iUiListener, false);
    }

    public void story(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        this.f674a = activity;
        android.content.Intent intentC = c(com.tencent.open.SocialConstants.ACTIVITY_STORY);
        bundle.putAll(b());
        a(activity, intentC, com.tencent.open.SocialConstants.ACTION_STORY, bundle, com.tencent.open.utils.h.a().a(com.tencent.open.utils.f.a(), "https://login.imgcache.qq.com/open/mobile/sendstory/sdk_sendstory_v1.3.html"), iUiListener, false);
    }

    @android.annotation.SuppressLint({"SetJavaScriptEnabled"})
    public void writeEncryToken(android.content.Context context) {
        java.lang.String strF;
        java.lang.String accessToken = this.c.getAccessToken();
        java.lang.String appId = this.c.getAppId();
        java.lang.String openId = this.c.getOpenId();
        if (accessToken == null || accessToken.length() <= 0 || appId == null || appId.length() <= 0 || openId == null || openId.length() <= 0) {
            strF = null;
        } else {
            strF = com.tencent.open.utils.l.f("[REDACTED]" + accessToken + appId + openId + "[REDACTED]");
        }
        com.tencent.open.b.b bVar = new com.tencent.open.b.b(context);
        android.webkit.WebSettings settings = bVar.getSettings();
        settings.setDomStorageEnabled(true);
        settings.setJavaScriptEnabled(true);
        settings.setDatabaseEnabled(true);
        settings.setSavePassword(false);
        java.lang.String str = "<!DOCTYPE HTML><html lang=\"en-US\"><head><meta charset=\"UTF-8\"><title>localStorage Test</title><script type=\"text/javascript\">document.domain = 'qq.com';localStorage[\"" + this.c.getOpenId() + "_" + this.c.getAppId() + "\"]=\"" + strF + "\";</script></head><body></body></html>";
        java.lang.String strA = com.tencent.open.utils.h.a().a(context, "https://login.imgcache.qq.com");
        bVar.loadDataWithBaseURL(strA, str, "text/html", com.unisound.b.f.b, strA);
    }
}
