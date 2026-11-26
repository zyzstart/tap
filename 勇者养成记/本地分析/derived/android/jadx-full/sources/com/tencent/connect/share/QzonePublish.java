package com.tencent.connect.share;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QzonePublish extends com.tencent.connect.common.BaseApi {
    public static final java.lang.String HULIAN_CALL_BACK = "hulian_call_back";
    public static final java.lang.String HULIAN_EXTRA_SCENE = "hulian_extra_scene";
    public static final java.lang.String PUBLISH_TO_QZONE_APP_NAME = "appName";
    public static final java.lang.String PUBLISH_TO_QZONE_EXTMAP = "extMap";
    public static final java.lang.String PUBLISH_TO_QZONE_IMAGE_URL = "imageUrl";
    public static final java.lang.String PUBLISH_TO_QZONE_KEY_TYPE = "req_type";
    public static final java.lang.String PUBLISH_TO_QZONE_SUMMARY = "summary";
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHMOOD = 3;
    public static final int PUBLISH_TO_QZONE_TYPE_PUBLISHVIDEO = 4;
    public static final java.lang.String PUBLISH_TO_QZONE_VIDEO_DURATION = "videoDuration";
    public static final java.lang.String PUBLISH_TO_QZONE_VIDEO_PATH = "videoPath";
    public static final java.lang.String PUBLISH_TO_QZONE_VIDEO_SIZE = "videoSize";

    public QzonePublish(android.content.Context context, com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:27:0x00c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:40:0x0168  */
    /* JADX WARN: Code duplicated, block: B:43:0x0173  */
    /* JADX WARN: Code duplicated, block: B:45:0x019c  */
    /* JADX WARN: Code duplicated, block: B:49:0x0202  */
    /* JADX WARN: Code duplicated, block: B:52:0x0225  */
    /* JADX WARN: Code duplicated, block: B:55:0x023f  */
    /* JADX WARN: Code duplicated, block: B:58:0x0262  */
    /* JADX WARN: Code duplicated, block: B:61:0x0285  */
    /* JADX WARN: Code duplicated, block: B:64:0x0313  */
    /* JADX WARN: Code duplicated, block: B:65:0x033c  */
    /* JADX WARN: Instruction removed from duplicated block: B:43:0x0173, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:45:0x019c, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:49:0x0202, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:52:0x0225, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:55:0x023f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:58:0x0262, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:61:0x0285, please report this as an issue */
    public void b(android.app.Activity activity, android.os.Bundle bundle, com.tencent.tauth.IUiListener iUiListener) {
        java.lang.String str;
        java.lang.String string;
        java.lang.String appId;
        java.lang.String openId;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        android.content.Intent intent;
        java.lang.String strA;
        com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "doPublishToQzone() --start");
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://qzone/publish?src_type=app&version=1&file_type=news");
        java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
        java.lang.String string2 = bundle.getString("summary");
        int i = bundle.getInt("req_type", 3);
        java.lang.String string3 = bundle.getString("appName");
        java.lang.String string4 = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        int i2 = bundle.getInt(PUBLISH_TO_QZONE_VIDEO_DURATION);
        long j = bundle.getLong(PUBLISH_TO_QZONE_VIDEO_SIZE);
        java.lang.String str6 = "";
        try {
            android.os.Bundle bundle2 = bundle.getBundle("extMap");
            if (bundle2 != null) {
                java.util.Set<java.lang.String> setKeySet = bundle2.keySet();
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                java.util.Iterator<java.lang.String> it = setKeySet.iterator();
                while (it.hasNext()) {
                    str = str6;
                    try {
                        java.lang.String next = it.next();
                        if (!android.text.TextUtils.isEmpty(bundle2.getString(next))) {
                            jSONObject.put(next, bundle2.getString(next));
                            it = it;
                        }
                        str6 = str;
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone()  --error parse extmap", e);
                        string = str;
                        appId = this.c.getAppId();
                        openId = this.c.getOpenId();
                        com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                        if (3 == i) {
                            str2 = openId;
                            str3 = string3;
                            str4 = string;
                            str5 = "";
                        } else {
                            str2 = openId;
                            str3 = string3;
                            str4 = string;
                            str5 = "";
                        }
                        if (4 == i) {
                            str5 = com.tencent.connect.common.Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                            stringBuffer.append("&videoPath=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
                            strA = com.tencent.open.utils.l.a(appId, activity, string4, iUiListener);
                            if (!android.text.TextUtils.isEmpty(strA)) {
                                stringBuffer.append("&videoUri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(strA), 2));
                            }
                            stringBuffer.append("&videoDuration=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i2)), 2));
                            stringBuffer.append("&videoSize=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(j)), 2));
                        }
                        java.lang.String str7 = str5;
                        if (!android.text.TextUtils.isEmpty(string2)) {
                            stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
                        }
                        if (!android.text.TextUtils.isEmpty(appId)) {
                            stringBuffer.append("&share_id=" + appId);
                        }
                        if (!android.text.TextUtils.isEmpty(str3)) {
                            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str3), 2));
                        }
                        if (!com.tencent.open.utils.l.e(str2)) {
                            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str2), 2));
                        }
                        if (!android.text.TextUtils.isEmpty(str4)) {
                            stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str4), 2));
                        }
                        stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
                        com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                        com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                        intent = new android.content.Intent("android.intent.action.VIEW");
                        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                        intent.putExtra("pkg_name", activity.getPackageName());
                        if (a(intent)) {
                            a(activity, 10104, intent, false);
                            com.tencent.open.a.d.a().a(0, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                        } else {
                            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
                            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                        }
                        com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str7, "0", "1", "0");
                        com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doPublishToQzone() --end");
                    }
                }
                str = str6;
                if (jSONObject.length() > 0) {
                    string = jSONObject.toString();
                }
                appId = this.c.getAppId();
                openId = this.c.getOpenId();
                com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
                if (3 == i || stringArrayList == null) {
                    str2 = openId;
                    str3 = string3;
                    str4 = string;
                    str5 = "";
                } else {
                    java.lang.StringBuffer stringBuffer2 = new java.lang.StringBuffer();
                    str5 = "7";
                    java.lang.StringBuffer stringBuffer3 = new java.lang.StringBuffer();
                    str4 = string;
                    int size = stringArrayList.size();
                    str2 = openId;
                    int i3 = 0;
                    while (i3 < size) {
                        java.lang.String str8 = string3;
                        stringBuffer2.append(java.net.URLEncoder.encode(stringArrayList.get(i3)));
                        java.lang.String strA2 = com.tencent.open.utils.l.a(appId, activity, stringArrayList.get(i3), iUiListener);
                        if (!android.text.TextUtils.isEmpty(strA2)) {
                            stringBuffer3.append(java.net.URLEncoder.encode(strA2));
                        }
                        if (i3 != size - 1) {
                            stringBuffer2.append(";");
                            stringBuffer3.append(";");
                        }
                        i3++;
                        string3 = str8;
                    }
                    str3 = string3;
                    stringBuffer.append("&image_url=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(stringBuffer2.toString()), 2));
                    if (!android.text.TextUtils.isEmpty(stringBuffer3.toString())) {
                        stringBuffer.append("&image_uri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(stringBuffer3.toString()), 2));
                    }
                }
                if (4 == i) {
                    str5 = com.tencent.connect.common.Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
                    stringBuffer.append("&videoPath=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
                    strA = com.tencent.open.utils.l.a(appId, activity, string4, iUiListener);
                    if (!android.text.TextUtils.isEmpty(strA)) {
                        stringBuffer.append("&videoUri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(strA), 2));
                    }
                    stringBuffer.append("&videoDuration=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i2)), 2));
                    stringBuffer.append("&videoSize=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(j)), 2));
                }
                java.lang.String str9 = str5;
                if (!android.text.TextUtils.isEmpty(string2)) {
                    stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
                }
                if (!android.text.TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!android.text.TextUtils.isEmpty(str3)) {
                    stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str3), 2));
                }
                if (!com.tencent.open.utils.l.e(str2)) {
                    stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str2), 2));
                }
                if (!android.text.TextUtils.isEmpty(str4)) {
                    stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str4), 2));
                }
                stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
                com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
                com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
                intent = new android.content.Intent("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                intent.putExtra("pkg_name", activity.getPackageName());
                if (a(intent)) {
                    a(activity, 10104, intent, false);
                    com.tencent.open.a.d.a().a(0, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
                } else {
                    com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
                    com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
                }
                com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str9, "0", "1", "0");
                com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doPublishToQzone() --end");
            }
            str = "";
        } catch (java.lang.Exception e2) {
            e = e2;
            str = str6;
        }
        string = str;
        appId = this.c.getAppId();
        openId = this.c.getOpenId();
        com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "openId:" + openId);
        if (3 == i) {
            str2 = openId;
            str3 = string3;
            str4 = string;
            str5 = "";
        } else {
            str2 = openId;
            str3 = string3;
            str4 = string;
            str5 = "";
        }
        if (4 == i) {
            str5 = com.tencent.connect.common.Constants.VIA_SHARE_TYPE_PUBLISHVIDEO;
            stringBuffer.append("&videoPath=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string4), 2));
            strA = com.tencent.open.utils.l.a(appId, activity, string4, iUiListener);
            if (!android.text.TextUtils.isEmpty(strA)) {
                stringBuffer.append("&videoUri=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(strA), 2));
            }
            stringBuffer.append("&videoDuration=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i2)), 2));
            stringBuffer.append("&videoSize=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(j)), 2));
        }
        java.lang.String str10 = str5;
        if (!android.text.TextUtils.isEmpty(string2)) {
            stringBuffer.append("&description=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string2), 2));
        }
        if (!android.text.TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
        }
        if (!android.text.TextUtils.isEmpty(str3)) {
            stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str3), 2));
        }
        if (!com.tencent.open.utils.l.e(str2)) {
            stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str2), 2));
        }
        if (!android.text.TextUtils.isEmpty(str4)) {
            stringBuffer.append("&share_qzone_ext_str=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(str4), 2));
        }
        stringBuffer.append("&req_type=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(java.lang.String.valueOf(i)), 2));
        com.tencent.open.log.SLog.v("openSDK_LOG.QzonePublish", "doPublishToQzone, url: " + stringBuffer.toString());
        com.tencent.connect.a.a.a(com.tencent.open.utils.f.a(), this.c, "requireApi", "shareToNativeQQ");
        intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setData(android.net.Uri.parse(stringBuffer.toString()));
        intent.putExtra("pkg_name", activity.getPackageName());
        if (a(intent)) {
            a(activity, 10104, intent, false);
            com.tencent.open.a.d.a().a(0, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent success");
        } else {
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "doPublishToQzone() target activity not found");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "hasActivityForIntent fail");
        }
        com.tencent.open.a.d.a().a(this.c.getOpenId(), this.c.getAppId(), com.tencent.connect.common.Constants.VIA_SHARE_TO_QZONE, com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, "3", "1", str10, "0", "1", "0");
        com.tencent.open.log.SLog.i(com.tencent.open.log.SLog.TAG, "doPublishToQzone() --end");
    }

    public void publishToQzone(final android.app.Activity activity, final android.os.Bundle bundle, final com.tencent.tauth.IUiListener iUiListener) {
        com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() -- start");
        if (bundle == null) {
            iUiListener.onError(new com.tencent.tauth.UiError(-6, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, params is null");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, com.tencent.connect.common.Constants.MSG_PARAM_NULL_ERROR);
            return;
        }
        if (!com.tencent.open.utils.l.f(activity)) {
            iUiListener.onError(new com.tencent.tauth.UiError(-15, com.tencent.connect.common.Constants.MSG_PARAM_VERSION_TOO_LOW, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "-->publishToQzone, this is not support below qq 5.9.5");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "publicToQzone, this is not support below qq 5.9.5");
            new com.tencent.open.TDialog(activity, "", a(""), null, this.c).show();
            return;
        }
        java.lang.String strA = com.tencent.open.utils.l.a(activity);
        int i = 0;
        if (strA == null) {
            strA = bundle.getString("appName");
        } else if (strA.length() > 20) {
            strA = strA.substring(0, 20) + "...";
        }
        if (!android.text.TextUtils.isEmpty(strA)) {
            bundle.putString("appName", strA);
        }
        int i2 = bundle.getInt("req_type");
        if (i2 == 3) {
            java.util.ArrayList<java.lang.String> stringArrayList = bundle.getStringArrayList("imageUrl");
            if (stringArrayList != null && stringArrayList.size() > 0) {
                while (i < stringArrayList.size()) {
                    if (!com.tencent.open.utils.l.h(stringArrayList.get(i))) {
                        stringArrayList.remove(i);
                        i--;
                    }
                    i++;
                }
                bundle.putStringArrayList("imageUrl", stringArrayList);
            }
            b(activity, bundle, iUiListener);
            com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            return;
        }
        if (i2 != 4) {
            iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_SHARE_TYPE_ERROR, null));
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() error--end请选择支持的分享类型");
            com.tencent.open.a.d.a().a(1, "SHARE_CHECK_SDK", "1000", this.c.getAppId(), java.lang.String.valueOf(4), java.lang.Long.valueOf(android.os.SystemClock.elapsedRealtime()), 0, 1, "publishToQzone() 请选择支持的分享类型");
            return;
        }
        final java.lang.String string = bundle.getString(PUBLISH_TO_QZONE_VIDEO_PATH);
        if (!com.tencent.open.utils.l.h(string)) {
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() video url invalid");
            iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PUBLISH_VIDEO_ERROR, null));
            return;
        }
        android.media.MediaPlayer mediaPlayer = new android.media.MediaPlayer();
        mediaPlayer.setOnPreparedListener(new android.media.MediaPlayer.OnPreparedListener() { // from class: com.tencent.connect.share.QzonePublish.1
            @Override // android.media.MediaPlayer.OnPreparedListener
            public void onPrepared(android.media.MediaPlayer mediaPlayer2) {
                long length = new java.io.File(string).length();
                int duration = mediaPlayer2.getDuration();
                bundle.putString(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_PATH, string);
                bundle.putInt(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_DURATION, duration);
                bundle.putLong(com.tencent.connect.share.QzonePublish.PUBLISH_TO_QZONE_VIDEO_SIZE, length);
                com.tencent.connect.share.QzonePublish.this.b(activity, bundle, iUiListener);
                com.tencent.open.log.SLog.i("openSDK_LOG.QzonePublish", "publishToQzone() --end");
            }
        });
        mediaPlayer.setOnErrorListener(new android.media.MediaPlayer.OnErrorListener() { // from class: com.tencent.connect.share.QzonePublish.2
            @Override // android.media.MediaPlayer.OnErrorListener
            public boolean onError(android.media.MediaPlayer mediaPlayer2, int i3, int i4) {
                com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() mediaplayer onError()");
                iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PUBLISH_VIDEO_ERROR, null));
                return false;
            }
        });
        try {
            mediaPlayer.setDataSource(string);
            mediaPlayer.prepareAsync();
        } catch (java.lang.Exception unused) {
            com.tencent.open.log.SLog.e("openSDK_LOG.QzonePublish", "publishToQzone() exception(s) occurred when preparing mediaplayer");
            iUiListener.onError(new com.tencent.tauth.UiError(-5, com.tencent.connect.common.Constants.MSG_PUBLISH_VIDEO_ERROR, null));
        }
    }
}
