package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.open.utils.h f727a;
    private volatile java.lang.ref.WeakReference b = null;

    public static synchronized com.tencent.open.utils.h a() {
        if (f727a == null) {
            f727a = new com.tencent.open.utils.h();
        }
        return f727a;
    }

    public java.lang.String a(android.content.Context context, java.lang.String str) {
        if (this.b == null || this.b.get() == null) {
            this.b = new java.lang.ref.WeakReference(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            java.lang.String host = new java.net.URL(str).getHost();
            if (host == null) {
                com.tencent.open.log.SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            java.lang.String string = ((android.content.SharedPreferences) this.b.get()).getString(host, null);
            if (string != null && !host.equals(string)) {
                java.lang.String strReplace = str.replace(host, string);
                com.tencent.open.log.SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + strReplace);
                return strReplace;
            }
            com.tencent.open.log.SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (java.lang.Exception e) {
            com.tencent.open.log.SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e.getMessage());
            return str;
        }
    }
}
