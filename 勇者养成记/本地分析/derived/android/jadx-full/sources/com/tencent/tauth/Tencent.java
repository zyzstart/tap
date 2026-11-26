package com.tencent.tauth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class Tencent {
    public static final int REQUEST_LOGIN = 10001;
    private static com.tencent.tauth.Tencent c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.connect.auth.c f988a;
    private java.lang.String b;

    private Tencent(java.lang.String str, android.content.Context context) {
        this.f988a = com.tencent.connect.auth.c.a(str, context);
    }

    private static boolean a(android.content.Context context, java.lang.String str) {
        java.lang.String str2;
        java.lang.StringBuilder sb;
        java.lang.String str3;
        try {
            context.getPackageManager().getActivityInfo(new android.content.ComponentName(context.getPackageName(), "com.tencent.tauth.AuthActivity"), 128);
            try {
                context.getPackageManager().getActivityInfo(new android.content.ComponentName(context.getPackageName(), "com.tencent.connect.common.AssistActivity"), 128);
                return true;
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                str2 = "没有在AndroidManifest.xml中检测到com.tencent.connect.common.AssistActivity,请加上com.tencent.connect.common.AssistActivity,详细信息请查看官网文档.\n配置示例如下: \n<activity\n     android:name=\"com.tencent.connect.common.AssistActivity\"\n     android:screenOrientation=\"behind\"\n     android:theme=\"@android:style/Theme.Translucent.NoTitleBar\"\n     android:configChanges=\"orientation|keyboardHidden\">\n</activity>";
                sb = new java.lang.StringBuilder();
                str3 = "AndroidManifest.xml 没有检测到com.tencent.connect.common.AssistActivity\n";
                sb.append(str3);
                sb.append(str2);
                com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", sb.toString());
                return false;
            }
        } catch (android.content.pm.PackageManager.NameNotFoundException unused2) {
            str2 = ("没有在AndroidManifest.xml中检测到com.tencent.tauth.AuthActivity,请加上com.tencent.tauth.AuthActivity,并配置<data android:scheme=\"tencent" + str + "\" />,详细信息请查看官网文档.") + "\n配置示例如下: \n<activity\n     android:name=\"com.tencent.tauth.AuthActivity\"\n     android:noHistory=\"true\"\n     android:launchMode=\"singleTask\">\n<intent-filter>\n    <action android:name=\"android.intent.action.VIEW\" />\n    <category android:name=\"android.intent.category.DEFAULT\" />\n    <category android:name=\"android.intent.category.BROWSABLE\" />\n    <data android:scheme=\"tencent" + str + "\" />\n</intent-filter>\n</activity>";
            sb = new java.lang.StringBuilder();
            str3 = "AndroidManifest.xml 没有检测到com.tencent.tauth.AuthActivity";
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0057 A[DONT_GENERATE] */
    /* JADX WARN: Code duplicated, block: B:20:0x0059 A[Catch: all -> 0x0067, TRY_ENTER, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0003, B:6:0x0027, B:9:0x0030, B:11:0x0034, B:12:0x0039, B:16:0x0051, B:20:0x0059, B:13:0x003c, B:15:0x0046), top: B:27:0x0003 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:18:0x0057, please report this as an issue */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized com.tencent.tauth.Tencent createInstance(java.lang.String str, android.content.Context context) {
        com.tencent.tauth.Tencent tencent;
        com.tencent.open.utils.f.a(context.getApplicationContext());
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str);
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "appId should not be empty!");
            return null;
        }
        com.tencent.tauth.Tencent tencent2 = c;
        if (tencent2 != null) {
            if (!str.equals(tencent2.getAppId())) {
                c.logout(context);
                tencent = new com.tencent.tauth.Tencent(str, context);
            }
            if (!a(context, str)) {
                return null;
            }
            com.tencent.open.utils.g.a(context, str);
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
            return c;
        }
        tencent = new com.tencent.tauth.Tencent(str, context);
        c = tencent;
        if (!a(context, str)) {
            return null;
        }
        com.tencent.open.utils.g.a(context, str);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "createInstance()  -- end");
        return c;
    }

    public static synchronized com.tencent.tauth.Tencent createInstance(java.lang.String str, android.content.Context context, java.lang.String str2) {
        com.tencent.tauth.Tencent tencentCreateInstance;
        tencentCreateInstance = createInstance(str, context);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "createInstance()  -- start, appId = " + str + ", authorities=" + str2);
        if (tencentCreateInstance != null) {
            tencentCreateInstance.b = str2;
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "null == tencent set mAuthorities fail");
        }
        return tencentCreateInstance;
    }

    public static synchronized java.lang.String getAuthorities(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "TextUtils.isEmpty(appId)");
            return null;
        }
        com.tencent.tauth.Tencent tencent = c;
        if (tencent != null) {
            return str.equals(tencent.getAppId()) ? c.b : "";
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "sInstance == null");
        return null;
    }

    public static void handleResultData(android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("handleResultData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        com.tencent.connect.common.UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public static boolean isSupportPushToQZone(android.content.Context context) {
        boolean z = com.tencent.open.utils.i.c(context, "5.9.5") >= 0 || com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) != null;
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportPushToQZone() support=" + z);
        return z;
    }

    public static boolean isSupportShareToQQ(android.content.Context context) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ()");
        boolean z = true;
        if (com.tencent.open.utils.l.c(context) && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (com.tencent.open.utils.i.c(context, com.tencent.ydkqmsp.sdk.u.U.BEACON_ID_VERSION) < 0 && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_TIM) == null && com.tencent.open.utils.i.a(context, com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED) == null) {
            z = false;
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportShareToQQ() support=" + z);
        return z;
    }

    public static boolean onActivityResultData(int i, int i2, android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("onActivityResultData() reqcode = ");
        sb.append(i);
        sb.append(", resultcode = ");
        sb.append(i2);
        sb.append(", data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        return com.tencent.connect.common.UIListenerManager.getInstance().onActivityResult(i, i2, intent, iUiListener);
    }

    public static java.util.Map parseMiniParameters(android.content.Intent intent) {
        java.util.HashMap map = new java.util.HashMap();
        if (intent == null) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "parseMiniParameters null == intent");
            return map;
        }
        try {
            java.lang.String stringExtra = intent.getStringExtra("appParameter");
            if (!android.text.TextUtils.isEmpty(stringExtra)) {
                com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters appParameter=" + stringExtra);
                org.json.JSONObject jSONObject = new org.json.JSONObject(stringExtra);
                java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
                return map;
            }
            android.net.Uri data = intent.getData();
            if (data == null) {
                com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uri==null");
                return map;
            }
            java.lang.String string = data.toString();
            if (android.text.TextUtils.isEmpty(string)) {
                com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriStr isEmpty");
                return map;
            }
            java.lang.String strSubstring = string.substring(string.lastIndexOf(63) + 1);
            if (android.text.TextUtils.isEmpty(strSubstring)) {
                com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam is empty");
                return map;
            }
            com.tencent.open.log.SLog.d("openSDK_LOG.Tencent", "parseMiniParameters uriParam=" + strSubstring);
            for (java.lang.String str : strSubstring.split("&")) {
                java.lang.String[] strArrSplit = str.split("=");
                if (strArrSplit.length == 2) {
                    map.put(strArrSplit[0], strArrSplit[1]);
                }
            }
            return map;
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.Tencent", "parseMiniParameters Exception", e);
        }
    }

    public static void setCustomLogger(com.tencent.open.log.Tracer tracer) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setCustomLogger");
        com.tencent.open.log.SLog.getInstance().setCustomLogger(tracer);
    }

    public void checkLogin(com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "checkLogin()");
        this.f988a.a(iUiListener);
    }

    public java.lang.String getAccessToken() {
        java.lang.String accessToken = this.f988a.b().getAccessToken();
        com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]" + accessToken);
        return accessToken;
    }

    public java.lang.String getAppId() {
        java.lang.String appId = this.f988a.b().getAppId();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getAppId() appid =" + appId);
        return appId;
    }

    public long getExpiresIn() {
        long expireTimeInSecond = this.f988a.b().getExpireTimeInSecond();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getExpiresIn() expiresin= " + expireTimeInSecond);
        return expireTimeInSecond;
    }

    public java.lang.String getOpenId() {
        java.lang.String openId = this.f988a.b().getOpenId();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "getOpenId() openid= " + openId);
        return openId;
    }

    public com.tencent.connect.auth.QQToken getQQToken() {
        com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]");
        return this.f988a.b();
    }

    @java.lang.Deprecated
    public void handleLoginData(android.content.Intent intent, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("handleLoginData() data = null ? ");
        sb.append(intent == null);
        sb.append(", listener = null ? ");
        sb.append(iUiListener == null);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        com.tencent.connect.common.UIListenerManager.getInstance().handleDataToListener(intent, iUiListener);
    }

    public void initSessionCache(org.json.JSONObject jSONObject) {
        try {
            java.lang.String string = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_ACCESS_TOKEN);
            java.lang.String string2 = jSONObject.getString(com.tencent.connect.common.Constants.PARAM_EXPIRES_IN);
            java.lang.String string3 = jSONObject.getString("openid");
            if (!android.text.TextUtils.isEmpty(string) && !android.text.TextUtils.isEmpty(string2) && !android.text.TextUtils.isEmpty(string3)) {
                setAccessToken(string, string2);
                setOpenId(string3);
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "initSessionCache()");
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]" + e.toString());
        }
    }

    public boolean isQQInstalled(android.content.Context context) {
        boolean zB = com.tencent.open.utils.i.b(context);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isQQInstalled() installed=" + zB);
        return zB;
    }

    public boolean isReady() {
        boolean z = isSessionValid() && getOpenId() != null;
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isReady() --ready=" + z);
        return z;
    }

    public boolean isSessionValid() {
        boolean zC = this.f988a.c();
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSessionValid() isvalid =" + zC);
        return zC;
    }

    public boolean isSupportSSOLogin(android.app.Activity activity) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin()");
        boolean z = true;
        if (com.tencent.open.utils.l.c(activity) && com.tencent.open.utils.i.a((android.content.Context) activity, com.tencent.connect.common.Constants.PACKAGE_QQ_PAD) != null) {
            return true;
        }
        if (com.tencent.open.utils.i.c(activity, com.tencent.ydkqmsp.sdk.u.U.BEACON_ID_VERSION) < 0 && com.tencent.open.utils.i.d(activity, "1.1") < 0 && com.tencent.open.utils.i.e(activity, "4.0.0") < 0) {
            z = false;
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "isSupportSSOLogin() support=" + z);
        return z;
    }

    public org.json.JSONObject loadSession(java.lang.String str) {
        org.json.JSONObject jSONObjectLoadSession = this.f988a.b().loadSession(str);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("loadSession() appid ");
        sb.append(str);
        sb.append(", length=");
        sb.append(jSONObjectLoadSession != null ? jSONObjectLoadSession.length() : 0);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        return jSONObjectLoadSession;
    }

    public int login(android.app.Activity activity, com.tencent.tauth.IUiListener iUiListener, java.util.Map map) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login activity with params");
        return this.f988a.a(activity, iUiListener, map);
    }

    public int login(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f988a.a(activity, str, iUiListener);
    }

    public int login(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with activity, scope is " + str);
        return this.f988a.a(activity, str, iUiListener, z);
    }

    public int login(android.support.v4.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f988a.a(fragment, str, iUiListener, "");
    }

    public int login(android.support.v4.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "login() with fragment, scope is " + str);
        return this.f988a.a(fragment, str, iUiListener, "", z);
    }

    public int loginServerSide(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "loginServerSide() with activity, scope = " + str + ",server_side");
        return this.f988a.a(activity, str + ",server_side", iUiListener);
    }

    public int loginServerSide(android.support.v4.app.Fragment fragment, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "loginServerSide() with fragment, scope = " + str + ",server_side");
        return this.f988a.a(fragment, str + ",server_side", iUiListener, "");
    }

    public int loginWithOEM(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener, boolean z, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "loginWithOEM() with activity, scope = " + str);
        return this.f988a.a(activity, str, iUiListener, z, str2, str3, str4);
    }

    public void logout(android.content.Context context) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "logout()");
        this.f988a.b().setAccessToken(null, "[REDACTED]");
        this.f988a.b().setOpenId(null);
        this.f988a.b().removeSession(this.f988a.b().getAppId());
    }

    public boolean onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "onActivityResult() deprecated, will do nothing");
        return false;
    }

    public void publishToQzone(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "publishToQzone()");
        new com.tencent.connect.share.QzonePublish(activity, this.f988a.b()).publishToQzone(activity, bundle, iUiListener);
    }

    public int reAuth(android.app.Activity activity, java.lang.String str, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "reAuth() with activity, scope = " + str);
        return this.f988a.b(activity, str, iUiListener);
    }

    public void releaseResource() {
    }

    public void reportDAU() {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "reportDAU() ");
        this.f988a.a();
    }

    public org.json.JSONObject request(java.lang.String str, android.os.Bundle bundle, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "request()");
        return com.tencent.open.utils.HttpUtils.request(this.f988a.b(), com.tencent.open.utils.f.a(), str, bundle, str2);
    }

    public void requestAsync(java.lang.String str, android.os.Bundle bundle, java.lang.String str2, com.tencent.tauth.IRequestListener iRequestListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "requestAsync()");
        com.tencent.open.utils.HttpUtils.requestAsync(this.f988a.b(), com.tencent.open.utils.f.a(), str, bundle, str2, iRequestListener);
    }

    public void saveSession(org.json.JSONObject jSONObject) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("saveSession() length=");
        sb.append(jSONObject != null ? jSONObject.length() : 0);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", sb.toString());
        this.f988a.b().saveSession(jSONObject);
    }

    public void setAccessToken(java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("[REDACTED]", "[REDACTED]" + str2 + "[REDACTED]");
        this.f988a.a(str, str2);
    }

    public void setAvatar(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        java.lang.String string = bundle.getString("picture");
        new com.tencent.connect.avatar.QQAvatar(this.f988a.b()).setAvatar(activity, android.net.Uri.parse(string), iUiListener, bundle.getInt("exitAnim"));
    }

    public void setAvatar(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener, int i, int i2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setAvatar()");
        bundle.putInt("exitAnim", i2);
        activity.overridePendingTransition(i, 0);
        setAvatar(activity, bundle, iUiListener);
    }

    public void setAvatarByQQ(android.app.Activity activity, android.net.Uri uri, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setAvatarByQQ()");
        new com.tencent.connect.avatar.QQAvatar(this.f988a.b()).setAvatarByQQ(activity, uri, iUiListener);
    }

    public void setDynamicAvatar(android.app.Activity activity, android.net.Uri uri, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setDynamicAvatar()");
        new com.tencent.connect.avatar.QQAvatar(this.f988a.b()).setDynamicAvatar(activity, uri, iUiListener);
    }

    public void setEmotions(android.app.Activity activity, java.util.ArrayList arrayList, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "saveQQEmotions()");
        new com.tencent.connect.emotion.QQEmotion(this.f988a.b()).setEmotions(activity, arrayList, iUiListener);
    }

    public void setOpenId(java.lang.String str) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setOpenId() --start");
        this.f988a.b(com.tencent.open.utils.f.a(), str);
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "setOpenId() --end");
    }

    public void shareToQQ(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "shareToQQ()");
        if (android.text.TextUtils.isEmpty(this.b)) {
            iUiListener.onWarning(-19);
        }
        new com.tencent.connect.share.QQShare(activity, this.f988a.b()).shareToQQ(activity, bundle, iUiListener);
    }

    public void shareToQzone(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "shareToQzone()");
        new com.tencent.connect.share.QzoneShare(activity, this.f988a.b()).shareToQzone(activity, bundle, iUiListener);
    }

    public int startIMAio(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startIMAio()");
        return startIMConversation(activity, com.tencent.open.im.IM.CHAT_TYPE_AIO, str, str2);
    }

    public int startIMAudio(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startIMAudio()");
        return startIMConversation(activity, com.tencent.open.im.IM.CHAT_TYPE_AUDIO_CHAT, str, str2);
    }

    public int startIMConversation(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        return new com.tencent.open.im.IM(getQQToken()).startIMConversation(activity, str, str2, str3);
    }

    public int startIMVideo(android.app.Activity activity, java.lang.String str, java.lang.String str2) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startIMVideo()");
        return startIMConversation(activity, com.tencent.open.im.IM.CHAT_TYPE_VIDEO_CHAT, str, str2);
    }

    public int startMiniApp(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3) {
        com.tencent.open.log.SLog.i("openSDK_LOG.Tencent", "startMiniApp()");
        return new com.tencent.open.miniapp.MiniApp(getQQToken()).startMiniApp(activity, com.tencent.open.miniapp.MiniApp.MINIAPP_TYPE_NORMAL, str, "[REDACTED]", str2, str3);
    }
}
