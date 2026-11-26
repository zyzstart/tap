package com.tencent.connect.share;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QzoneShare extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String SHARE_TO_QQ_APP_NAME = "appName";
    public static final java.lang.String SHARE_TO_QQ_AUDIO_URL = "audio_url";
    public static final java.lang.String SHARE_TO_QQ_EXT_INT = "cflag";
    public static final java.lang.String SHARE_TO_QQ_EXT_STR = "share_qq_ext_str";
    public static final java.lang.String SHARE_TO_QQ_IMAGE_LOCAL_URL = "imageLocalUrl";
    public static final java.lang.String SHARE_TO_QQ_IMAGE_URL = "imageUrl";
    public static final java.lang.String SHARE_TO_QQ_SITE = "site";
    public static final java.lang.String SHARE_TO_QQ_SUMMARY = "summary";
    public static final java.lang.String SHARE_TO_QQ_TARGET_URL = "targetUrl";
    public static final java.lang.String SHARE_TO_QQ_TITLE = "title";
    public static final java.lang.String SHARE_TO_QZONE_EXTMAP = "extMap";
    public static final java.lang.String SHARE_TO_QZONE_KEY_TYPE = "req_type";
    public static final int SHARE_TO_QZONE_TYPE_IMAGE = 5;
    public static final int SHARE_TO_QZONE_TYPE_IMAGE_TEXT = 1;
    public static final int SHARE_TO_QZONE_TYPE_MINI_PROGRAM = 7;
    public static final int SHARE_TO_QZONE_TYPE_NO_TYPE = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f513a;
    private boolean d;
    private boolean e;
    private boolean f;
    public java.lang.String mViaShareQzoneType;

    public QzoneShare(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
        this.mViaShareQzoneType = "";
        this.f513a = true;
        this.d = false;
        this.e = false;
        this.f = false;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:35:0x0123  */
    /* JADX WARN: Code duplicated, block: B:37:0x012d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0153  */
    /* JADX WARN: Code duplicated, block: B:43:0x0175  */
    /* JADX WARN: Code duplicated, block: B:46:0x0197  */
    /* JADX WARN: Code duplicated, block: B:49:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:52:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:55:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:58:0x0217  */
    /* JADX WARN: Code duplicated, block: B:61:0x0259  */
    /* JADX WARN: Code duplicated, block: B:64:0x027f  */
    /* JADX WARN: Code duplicated, block: B:67:0x02a5  */
    /* JADX WARN: Code duplicated, block: B:70:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:73:0x02ed  */
    /* JADX WARN: Code duplicated, block: B:76:0x0379  */
    /* JADX WARN: Code duplicated, block: B:78:0x037f  */
    /* JADX WARN: Code duplicated, block: B:80:0x0393  */
    /* JADX WARN: Code duplicated, block: B:82:0x03a6  */
    /* JADX WARN: Code duplicated, block: B:85:0x03b3  */
    /* JADX WARN: Code duplicated, block: B:88:0x03c0  */
    /* JADX WARN: Code duplicated, block: B:89:0x0405  */
    /* JADX WARN: Instruction removed from duplicated block: B:37:0x012d, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:40:0x0153, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:43:0x0175, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x0197, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x01b1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x01d3, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x01f5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0217, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:61:0x0259, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:64:0x027f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:67:0x02a5, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:70:0x02cb, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:73:0x02ed, please report this as an issue */
    private void b(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String appId;
        java.lang.String openIdWithCache;
        android.content.Intent intent;
        com.tencent.open.a.d dVarA;
        java.lang.String appId2;
        java.lang.String strValueOf;
        java.lang.Long lValueOf;
        int i;
        java.lang.String str4;
        java.lang.String str5;
        int i2;
        int i3;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String strA;
        com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doshareToQzone() --start");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://share/to_qzone?src_type=app&version=1&file_type=news");
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
        java.lang.String string = bundle.getString("title");
        java.lang.String string2 = bundle.getString("summary");
        java.lang.String string3 = bundle.getString("targetUrl");
        java.lang.String string4 = bundle.getString("audio_url");
        int i4 = bundle.getInt("req_type", 1);
        java.lang.String string5 = bundle.getString("appName");
        java.lang.String string6 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        java.lang.String string7 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        java.lang.String string8 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_TYPE);
        int i5 = bundle.getInt("cflag", 0);
        java.lang.String string9 = bundle.getString("share_qq_ext_str");
        java.lang.String string10 = "";
        try {
            android.os.Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                java.util.Set<java.lang.String> setKeySet = bundle2.keySet();
                str3 = string9;
                try {
                    org.json.JSONObject jSONObject = new org.json.JSONObject();
                    for (java.lang.String str8 : setKeySet) {
                        str2 = string7;
                        try {
                            str = string6;
                            try {
                                jSONObject.put(str8, bundle2.get(str8));
                                string6 = str;
                                string7 = str2;
                            } catch (java.lang.Exception e) {
                                e = e;
                                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                                appId = this.c.getAppId();
                                openIdWithCache = this.c.getOpenIdWithCache();
                                com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                                if (stringArrayList != null) {
                                    str7 = stringArrayList.get(0);
                                    stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(str7)), 2));
                                    if (!com.tencent.open.utils.l.g(str7)) {
                                        strA = com.tencent.open.utils.l.a(appId, activity, str7, iUiListener);
                                        if (!android.text.TextUtils.isEmpty(strA)) {
                                            stringBuffer.append("&image_uri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(strA)), 2));
                                        }
                                    }
                                }
                                if (!android.text.TextUtils.isEmpty(string)) {
                                    stringBuffer.append("&title=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2));
                                }
                                if (!android.text.TextUtils.isEmpty(string2)) {
                                    stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
                                }
                                if (!android.text.TextUtils.isEmpty(appId)) {
                                    stringBuffer.append("&share_id=" + appId);
                                }
                                if (!android.text.TextUtils.isEmpty(string3)) {
                                    stringBuffer.append("&url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string3), 2));
                                }
                                if (!android.text.TextUtils.isEmpty(string5)) {
                                    stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string5), 2));
                                }
                                if (!com.tencent.open.utils.l.e(openIdWithCache)) {
                                    stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openIdWithCache), 2));
                                }
                                if (!com.tencent.open.utils.l.e(string4)) {
                                    stringBuffer.append("&audioUrl=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
                                }
                                stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i4)), 2));
                                if (!android.text.TextUtils.isEmpty(str)) {
                                    stringBuffer.append("&mini_program_appid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(str)), 2));
                                }
                                if (!android.text.TextUtils.isEmpty(str2)) {
                                    stringBuffer.append("&mini_program_path=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(str2)), 2));
                                }
                                if (!android.text.TextUtils.isEmpty(string8)) {
                                    stringBuffer.append("&mini_program_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string8)), 2));
                                }
                                if (!com.tencent.open.utils.l.e(str3)) {
                                    stringBuffer.append("&share_qq_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str3), 2));
                                }
                                if (!android.text.TextUtils.isEmpty(string10)) {
                                    stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string10), 2));
                                }
                                stringBuffer.append("&cflag=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i5)), 2));
                                com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                                com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                                intent = new android.content.Intent("android.intent.action.VIEW");
                                intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                                intent.putExtra("pkg_name", activity.getPackageName());
                                if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
                                    if (a(intent)) {
                                        com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE, iUiListener);
                                        a(activity, intent, com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE);
                                    }
                                    com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
                                } else {
                                    com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
                                    if (com.tencent.connect.common.UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                                        com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
                                    }
                                    if (a(intent)) {
                                        a(activity, 10104, intent, false);
                                    }
                                }
                                if (a(intent)) {
                                    com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "0", this.mViaShareQzoneType, "0", "1", "0");
                                    dVarA = com.tencent.open.a.d.a();
                                    appId2 = this.c.getAppId();
                                    strValueOf = java.lang.String.valueOf(4);
                                    lValueOf = java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime());
                                    i = 0;
                                    str4 = "SHARE_CHECK_SDK";
                                    str5 = "1000";
                                    i2 = 0;
                                    i3 = 1;
                                    str6 = "";
                                } else {
                                    com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", this.mViaShareQzoneType, "0", "1", "0");
                                    dVarA = com.tencent.open.a.d.a();
                                    appId2 = this.c.getAppId();
                                    strValueOf = java.lang.String.valueOf(4);
                                    lValueOf = java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime());
                                    i = 1;
                                    str4 = "SHARE_CHECK_SDK";
                                    str5 = "1000";
                                    i2 = 0;
                                    i3 = 1;
                                    str6 = "hasActivityForIntent fail";
                                }
                                dVarA.a(i, str4, str5, appId2, strValueOf, lValueOf, i2, i3, str6);
                                com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doShareToQzone() --end");
                            }
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            str = string6;
                            com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "ShareToQzone()  --error parse extmap", e);
                            appId = this.c.getAppId();
                            openIdWithCache = this.c.getOpenIdWithCache();
                            com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
                            if (stringArrayList != null) {
                                str7 = stringArrayList.get(0);
                                stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(str7)), 2));
                                if (!com.tencent.open.utils.l.g(str7)) {
                                    strA = com.tencent.open.utils.l.a(appId, activity, str7, iUiListener);
                                    if (!android.text.TextUtils.isEmpty(strA)) {
                                        stringBuffer.append("&image_uri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(strA)), 2));
                                    }
                                }
                            }
                            if (!android.text.TextUtils.isEmpty(string)) {
                                stringBuffer.append("&title=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2));
                            }
                            if (!android.text.TextUtils.isEmpty(string2)) {
                                stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
                            }
                            if (!android.text.TextUtils.isEmpty(appId)) {
                                stringBuffer.append("&share_id=" + appId);
                            }
                            if (!android.text.TextUtils.isEmpty(string3)) {
                                stringBuffer.append("&url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string3), 2));
                            }
                            if (!android.text.TextUtils.isEmpty(string5)) {
                                stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string5), 2));
                            }
                            if (!com.tencent.open.utils.l.e(openIdWithCache)) {
                                stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openIdWithCache), 2));
                            }
                            if (!com.tencent.open.utils.l.e(string4)) {
                                stringBuffer.append("&audioUrl=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
                            }
                            stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i4)), 2));
                            if (!android.text.TextUtils.isEmpty(str)) {
                                stringBuffer.append("&mini_program_appid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(str)), 2));
                            }
                            if (!android.text.TextUtils.isEmpty(str2)) {
                                stringBuffer.append("&mini_program_path=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(str2)), 2));
                            }
                            if (!android.text.TextUtils.isEmpty(string8)) {
                                stringBuffer.append("&mini_program_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string8)), 2));
                            }
                            if (!com.tencent.open.utils.l.e(str3)) {
                                stringBuffer.append("&share_qq_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str3), 2));
                            }
                            if (!android.text.TextUtils.isEmpty(string10)) {
                                stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string10), 2));
                            }
                            stringBuffer.append("&cflag=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i5)), 2));
                            com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
                            com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                            intent = new android.content.Intent("android.intent.action.VIEW");
                            intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                            intent.putExtra("pkg_name", activity.getPackageName());
                            if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
                                if (a(intent)) {
                                    com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE, iUiListener);
                                    a(activity, intent, com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE);
                                }
                                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
                            } else {
                                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
                                if (com.tencent.connect.common.UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                                    com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
                                }
                                if (a(intent)) {
                                    a(activity, 10104, intent, false);
                                }
                            }
                            if (a(intent)) {
                                com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "0", this.mViaShareQzoneType, "0", "1", "0");
                                dVarA = com.tencent.open.a.d.a();
                                appId2 = this.c.getAppId();
                                strValueOf = java.lang.String.valueOf(4);
                                lValueOf = java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime());
                                i = 0;
                                str4 = "SHARE_CHECK_SDK";
                                str5 = "1000";
                                i2 = 0;
                                i3 = 1;
                                str6 = "";
                            } else {
                                com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", this.mViaShareQzoneType, "0", "1", "0");
                                dVarA = com.tencent.open.a.d.a();
                                appId2 = this.c.getAppId();
                                strValueOf = java.lang.String.valueOf(4);
                                lValueOf = java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime());
                                i = 1;
                                str4 = "SHARE_CHECK_SDK";
                                str5 = "1000";
                                i2 = 0;
                                i3 = 1;
                                str6 = "hasActivityForIntent fail";
                            }
                            dVarA.a(i, str4, str5, appId2, strValueOf, lValueOf, i2, i3, str6);
                            com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doShareToQzone() --end");
                        }
                    }
                    str = string6;
                    str2 = string7;
                    if (setKeySet.size() > 0) {
                        string10 = jSONObject.toString();
                    }
                } catch (java.lang.Exception e3) {
                    e = e3;
                    str = string6;
                    str2 = string7;
                }
            } else {
                str = string6;
                str2 = string7;
                str3 = string9;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
            str = string6;
            str2 = string7;
            str3 = string9;
        }
        appId = this.c.getAppId();
        openIdWithCache = this.c.getOpenIdWithCache();
        com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "openId:" + openIdWithCache);
        if (stringArrayList != null && stringArrayList.size() > 0) {
            str7 = stringArrayList.get(0);
            stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(str7)), 2));
            if (!com.tencent.open.utils.l.g(str7)) {
                strA = com.tencent.open.utils.l.a(appId, activity, str7, iUiListener);
                if (!android.text.TextUtils.isEmpty(strA)) {
                    stringBuffer.append("&image_uri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.net.URLEncoder.encode(strA)), 2));
                }
            }
        }
        if (!android.text.TextUtils.isEmpty(string)) {
            stringBuffer.append("&title=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2));
        }
        if (!android.text.TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
        }
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(string3)) {
            stringBuffer.append("&url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string3), 2));
        }
        if (!android.text.TextUtils.isEmpty(string5)) {
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string5), 2));
        }
        if (!com.tencent.open.utils.l.e(openIdWithCache)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openIdWithCache), 2));
        }
        if (!com.tencent.open.utils.l.e(string4)) {
            stringBuffer.append("&audioUrl=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
        }
        stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i4)), 2));
        if (!android.text.TextUtils.isEmpty(str)) {
            stringBuffer.append("&mini_program_appid=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(str)), 2));
        }
        if (!android.text.TextUtils.isEmpty(str2)) {
            stringBuffer.append("&mini_program_path=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(str2)), 2));
        }
        if (!android.text.TextUtils.isEmpty(string8)) {
            stringBuffer.append("&mini_program_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(string8)), 2));
        }
        if (!com.tencent.open.utils.l.e(str3)) {
            stringBuffer.append("&share_qq_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str3), 2));
        }
        if (!android.text.TextUtils.isEmpty(string10)) {
            stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string10), 2));
        }
        stringBuffer.append("&cflag=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i5)), 2));
        com.tencent.open.log.SLog.v("openSDK_LOG.QzoneShare", "doshareToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (com.tencent.open.utils.l.g(activity, "4.6.0")) {
            if (a(intent)) {
                com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE, iUiListener);
                a(activity, intent, com.tencent.connect.common.Constants.REQUEST_OLD_QZSHARE);
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is < 4.6.0");
        } else {
            com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- QQ Version is > 4.6.0");
            if (com.tencent.connect.common.UIListenerManager.getInstance().setListnerWithAction("shareToQzone", iUiListener) != null) {
                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "doShareToQzone() -- do listener onCancel()");
            }
            if (a(intent)) {
                a(activity, 10104, intent, false);
            }
        }
        if (a(intent)) {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "0", this.mViaShareQzoneType, "0", "1", "0");
            dVarA = com.tencent.open.a.d.a();
            appId2 = this.c.getAppId();
            strValueOf = java.lang.String.valueOf(4);
            lValueOf = java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime());
            i = 0;
            str4 = "SHARE_CHECK_SDK";
            str5 = "1000";
            i2 = 0;
            i3 = 1;
            str6 = "";
        } else {
            com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", this.mViaShareQzoneType, "0", "1", "0");
            dVarA = com.tencent.open.a.d.a();
            appId2 = this.c.getAppId();
            strValueOf = java.lang.String.valueOf(4);
            lValueOf = java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime());
            i = 1;
            str4 = "SHARE_CHECK_SDK";
            str5 = "1000";
            i2 = 0;
            i3 = 1;
            str6 = "hasActivityForIntent fail";
        }
        dVarA.a(i, str4, str5, appId2, strValueOf, lValueOf, i2, i3, str6);
        com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doShareToQzone() --end");
    }

    @Override // com.tencent.connect.common.BaseApi
    public void releaseResource() {
    }

    /* JADX WARN: Code duplicated, block: B:103:0x0337  */
    /* JADX WARN: Code duplicated, block: B:105:0x033b  */
    /* JADX WARN: Code duplicated, block: B:109:0x037a  */
    /* JADX WARN: Code duplicated, block: B:110:0x0386  */
    /* JADX WARN: Code duplicated, block: B:112:0x038e  */
    /* JADX WARN: Code duplicated, block: B:129:0x0408  */
    /* JADX WARN: Code duplicated, block: B:52:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:54:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:56:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:58:0x0205  */
    /* JADX WARN: Code duplicated, block: B:62:0x023f  */
    /* JADX WARN: Code duplicated, block: B:64:0x024e  */
    /* JADX WARN: Code duplicated, block: B:75:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:83:0x02c4  */
    /* JADX WARN: Code duplicated, block: B:85:0x02cb A[ADDED_TO_REGION] */
    public void shareToQzone(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str;
        java.lang.String strA;
        java.lang.String str2;
        com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() params is null");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        java.lang.String string = bundle.getString("title");
        java.lang.String string2 = bundle.getString("summary");
        java.lang.String string3 = bundle.getString("targetUrl");
        java.lang.String string4 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_APPID);
        java.lang.String string5 = bundle.getString(com.tencent.connect.share.QQShare.SHARE_TO_QQ_MINI_PROGRAM_PATH);
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
        java.lang.String strA2 = com.tencent.open.utils.l.a(activity);
        if (strA2 == null) {
            strA2 = bundle.getString("appName");
        } else if (strA2.length() > 20) {
            strA2 = strA2.substring(0, 20) + "...";
        }
        int i = bundle.getInt("req_type");
        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() get SHARE_TO_QZONE_KEY_TYPE: " + i);
        this.mViaShareQzoneType = (i == 1 || i != 5) ? "1" : "2";
        if (i != 1) {
            if (i == 5) {
                iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_SHARE_TYPE_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() error--end请选择支持的分享类型");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 请选择支持的分享类型");
                return;
            }
            if (i != 7) {
                if (!com.tencent.open.utils.l.e(string) || !com.tencent.open.utils.l.e(string2)) {
                    this.f513a = true;
                } else if (stringArrayList == null || stringArrayList.size() == 0) {
                    this.f513a = true;
                    string = "来自" + strA2 + "的分享";
                } else {
                    this.f513a = false;
                }
                this.d = false;
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, default needTitle = true, shareType = " + i);
            } else {
                if (android.text.TextUtils.isEmpty(string4) || android.text.TextUtils.isEmpty(string5)) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_ERROR, "appid or path empty."));
                }
                this.e = false;
                this.f = false;
                this.f513a = false;
            }
            if (com.tencent.open.utils.l.a() && com.tencent.open.utils.l.g(activity, "4.5.0")) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_SHARE_NOSD_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() sdcard is null--end");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_SHARE_NOSD_ERROR);
                return;
            }
            if (this.f513a) {
                if (android.text.TextUtils.isEmpty(string3)) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                    return;
                } else if (!com.tencent.open.utils.l.g(string3)) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_ERROR);
                    return;
                }
            }
            if (this.d) {
                if (!this.e && com.tencent.open.utils.l.e(string)) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_TITLE_NULL_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() title is null--end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() title is null");
                    return;
                }
                if (!com.tencent.open.utils.l.e(string) || string.length() <= 200) {
                    str = null;
                } else {
                    str = null;
                    bundle.putString("title", com.tencent.open.utils.l.a(string, 200, (java.lang.String) null, (java.lang.String) null));
                }
                if (!com.tencent.open.utils.l.e(string2) && string2.length() > 600) {
                    strA = com.tencent.open.utils.l.a(string2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_INTERRUPTED, str, str);
                    str2 = "summary";
                }
                if (!android.text.TextUtils.isEmpty(strA2)) {
                    bundle.putString("appName", strA2);
                }
                if (stringArrayList == null && (stringArrayList == null || stringArrayList.size() != 0)) {
                    int i2 = 0;
                    while (i2 < stringArrayList.size()) {
                        java.lang.String str3 = stringArrayList.get(i2);
                        if (!com.tencent.open.utils.l.g(str3) && !com.tencent.open.utils.l.h(str3)) {
                            stringArrayList.remove(i2);
                            i2--;
                        }
                        i2++;
                    }
                    if (stringArrayList.size() == 0) {
                        iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_URL_FORMAT_ERROR, null));
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() MSG_PARAM_IMAGE_URL_FORMAT_ERROR--end");
                        com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() 非法的图片地址!");
                        return;
                    }
                    bundle.putStringArrayList("imageUrl", stringArrayList);
                } else if (this.f) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                    return;
                }
                if (!com.tencent.open.utils.l.g(activity, "4.6.0")) {
                    com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                    b(activity, bundle, iUiListener);
                } else if (com.tencent.open.utils.i.c(activity, "4.2.0") >= 0 || com.tencent.open.utils.i.c(activity, "4.6.0") >= 0) {
                    com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                    new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
                } else {
                    com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver between 4.2.0 and 4.6.0, will use qqshare");
                    com.tencent.connect.share.QQShare qQShare = new com.tencent.connect.share.QQShare(activity, this.c);
                    if (stringArrayList != null && stringArrayList.size() > 0) {
                        java.lang.String str4 = stringArrayList.get(0);
                        if (i == 5 && !com.tencent.open.utils.l.h(str4)) {
                            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_URL_MUST_BE_LOCAL, null));
                            com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone()手Q版本过低，纯图分享不支持网路图片");
                            return;
                        }
                        bundle.putString("imageLocalUrl", str4);
                    }
                    if (!com.tencent.open.utils.l.g(activity, "4.5.0")) {
                        bundle.putInt("cflag", 1);
                    }
                    qQShare.shareToQQ(activity, bundle, iUiListener);
                }
                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
            }
            bundle.putString("title", "");
            str2 = "summary";
            strA = "";
            bundle.putString(str2, strA);
            if (!android.text.TextUtils.isEmpty(strA2)) {
                bundle.putString("appName", strA2);
            }
            if (stringArrayList == null) {
                if (this.f) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                    return;
                }
            } else if (this.f) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
            if (!com.tencent.open.utils.l.g(activity, "4.6.0")) {
                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                b(activity, bundle, iUiListener);
            } else if (com.tencent.open.utils.i.c(activity, "4.2.0") >= 0) {
                com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
            } else {
                com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
        }
        com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "-->shareToQzone, SHARE_TO_QZONE_TYPE_IMAGE_TEXT needTitle = true");
        this.f513a = true;
        this.d = false;
        this.e = true;
        this.f = false;
        if (com.tencent.open.utils.l.a()) {
        }
        if (this.f513a) {
            if (android.text.TextUtils.isEmpty(string3)) {
                iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_NULL_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl null error--end");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_NULL_ERROR);
                return;
            } else if (!com.tencent.open.utils.l.g(string3)) {
                iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() targetUrl error--end");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_TARGETURL_ERROR);
                return;
            }
        }
        if (this.d) {
            if (!this.e) {
            }
            if (com.tencent.open.utils.l.e(string)) {
                str = null;
            } else {
                str = null;
            }
            if (!com.tencent.open.utils.l.e(string2)) {
                strA = com.tencent.open.utils.l.a(string2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_INTERRUPTED, str, str);
                str2 = "summary";
            }
            if (!android.text.TextUtils.isEmpty(strA2)) {
                bundle.putString("appName", strA2);
            }
            if (stringArrayList == null) {
                if (this.f) {
                    iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                    return;
                }
            } else if (this.f) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
            if (!com.tencent.open.utils.l.g(activity, "4.6.0")) {
                com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
                b(activity, bundle, iUiListener);
            } else if (com.tencent.open.utils.i.c(activity, "4.2.0") >= 0) {
                com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
            } else {
                com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
                new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
            }
            com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
        }
        bundle.putString("title", "");
        str2 = "summary";
        strA = "";
        bundle.putString(str2, strA);
        if (!android.text.TextUtils.isEmpty(strA2)) {
            bundle.putString("appName", strA2);
        }
        if (stringArrayList == null) {
            if (this.f) {
                iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
                com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
                com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
                return;
            }
        } else if (this.f) {
            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_IMAGE_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzoneShare", "shareToQzone() imageUrl is null -- end");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "shareToQzone() imageUrl is null");
            return;
        }
        if (!com.tencent.open.utils.l.g(activity, "4.6.0")) {
            com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() qqver greater than 4.6.0");
            b(activity, bundle, iUiListener);
        } else if (com.tencent.open.utils.i.c(activity, "4.2.0") >= 0) {
            com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
            new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
        } else {
            com.tencent.open.log.SLog.w("openSDK_LOG.QzoneShare", "shareToQzone() qqver below 4.2.0, will show download dialog");
            new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
        }
        com.tencent.open.log.SLog.i("openSDK_LOG.QzoneShare", "shareToQzone() --end");
    }
}
