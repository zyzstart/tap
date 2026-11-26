package com.tencent.connect.emotion;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class QQEmotion extends com.tencent.connect.common.BaseApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.tauth.IUiListener f508a;

    public QQEmotion(com.tencent.connect.auth.QQToken qQToken) {
        super(qQToken);
    }

    private java.lang.String a(java.util.ArrayList arrayList) {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append(arrayList.get(i));
            sb.append(";");
        }
        java.lang.String string = sb.toString();
        com.tencent.open.log.SLog.i("QQEMOTION", "-->getFilePathListJson listStr : " + string);
        return android.util.Base64.encodeToString(com.tencent.open.utils.l.i(string), 2);
    }

    private boolean a(android.content.Context context, java.util.ArrayList arrayList) throws java.lang.Throwable {
        java.lang.StringBuilder sb;
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            sb = new java.lang.StringBuilder();
            sb.append("isLegality -->illegal, file count > 9, count = ");
            sb.append(arrayList.size());
        } else {
            long j = 0;
            for (int i = 0; i < arrayList.size(); i++) {
                java.lang.String strA = com.tencent.open.utils.l.a(context, (android.net.Uri) arrayList.get(i));
                long j2 = com.tencent.open.utils.l.j(strA);
                if (j2 > android.support.v4.media.session.PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                    sb = new java.lang.StringBuilder();
                    sb.append("isLegality -->illegal, fileSize: ");
                    sb.append(j2);
                    sb.append("， path =");
                    sb.append(strA);
                } else {
                    j += j2;
                }
            }
            if (j <= 3145728) {
                com.tencent.open.log.SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j);
                return true;
            }
            sb = new java.lang.StringBuilder();
            sb.append("isLegality -->illegal, totalSize: ");
            sb.append(j);
        }
        com.tencent.open.log.SLog.i("QQEMOTION", sb.toString());
        return false;
    }

    public void setEmotions(android.app.Activity activity, java.util.ArrayList arrayList, com.tencent.tauth.IUiListener iUiListener) {
        android.content.Context applicationContext;
        java.lang.String str;
        com.tencent.tauth.IUiListener iUiListener2 = this.f508a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f508a = iUiListener;
        if (!com.tencent.open.utils.i.b(activity)) {
            applicationContext = activity.getApplicationContext();
            str = "当前手机未安装QQ，请安装最新版QQ后再试。";
        } else if (com.tencent.open.utils.i.c(activity, "8.0.0") < 0) {
            applicationContext = activity.getApplicationContext();
            str = "当前手机QQ版本过低，不支持设置表情功能。";
        } else {
            if (a(activity.getApplicationContext(), arrayList)) {
                java.lang.String strA = com.tencent.open.utils.l.a(activity);
                java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer("mqqapi://profile/sdk_face_collection?");
                if (!android.text.TextUtils.isEmpty(strA)) {
                    if (strA.length() > 20) {
                        strA = strA.substring(0, 20) + "...";
                    }
                    stringBuffer.append("&app_name=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(strA), 2));
                }
                java.lang.String appId = this.c.getAppId();
                java.lang.String openId = this.c.getOpenId();
                if (!android.text.TextUtils.isEmpty(appId)) {
                    stringBuffer.append("&share_id=" + appId);
                }
                if (!android.text.TextUtils.isEmpty(openId)) {
                    stringBuffer.append("&open_id=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(openId), 2));
                }
                stringBuffer.append("&sdk_version=" + android.util.Base64.encodeToString(com.tencent.open.utils.l.i(com.tencent.connect.common.Constants.SDK_VERSION), 2));
                java.lang.String strA2 = a(arrayList);
                if (!android.text.TextUtils.isEmpty(strA2)) {
                    stringBuffer.append("&set_uri_list=" + strA2);
                }
                com.tencent.open.log.SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
                android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
                intent.setData(android.net.Uri.parse(stringBuffer.toString()));
                intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
                if (a(intent)) {
                    com.tencent.connect.common.UIListenerManager.getInstance().setListenerWithRequestcode(com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION, iUiListener);
                    a(activity, com.tencent.connect.common.Constants.REQUEST_EDIT_EMOTION, intent, false);
                    return;
                }
                return;
            }
            applicationContext = activity.getApplicationContext();
            str = "图片不符合要求，不支持设置表情功能。";
        }
        android.widget.Toast.makeText(applicationContext, str, 1).show();
    }
}
