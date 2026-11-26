package com.tencent.tmapkupdatesdk.internal.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.lang.String f995a = "10.0.0.172";
    public static int b = 80;
    public static java.lang.String c = "10.0.0.200";

    public static java.lang.String a() {
        android.net.NetworkInfo activeNetworkInfo;
        android.content.Context contextB = com.tencent.tmapkupdatesdk.internal.c.a.a().b();
        if (contextB == null || contextB.checkCallingOrSelfPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE) == -1 || (activeNetworkInfo = ((android.net.ConnectivityManager) contextB.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return "";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        java.lang.String extraInfo = activeNetworkInfo.getExtraInfo();
        return extraInfo == null ? "" : extraInfo.toLowerCase();
    }
}
