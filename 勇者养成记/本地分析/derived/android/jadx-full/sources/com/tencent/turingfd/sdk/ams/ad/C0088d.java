package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class C0088d {
    public static boolean q = false;
    public static boolean r = false;

    static {
        android.util.Log.d("TuringFdSDK", getVersionInfo());
    }

    public static java.lang.String getVersionInfo() {
        return java.lang.String.format(java.util.Locale.getDefault(), "TuringFD v%d (c%d, l%s, t%d, %s, compiled %s)", 28, 105548, "78DF73B70BE7D5F9", 1, "advertisersMini", "2019-08-23 11:04:53");
    }
}
