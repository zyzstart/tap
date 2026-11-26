package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {
    public static final java.lang.String CLASS = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.H);
    public static final java.lang.String PACKAGE;
    public static final java.lang.String S;
    public static final java.lang.String ka;

    static {
        com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.G);
        com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.I);
        com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.J);
        ka = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.K);
        PACKAGE = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.PACKAGE);
        S = com.tencent.turingfd.sdk.ams.ad.C0091g.get(com.tencent.turingfd.sdk.ams.ad.C0091g.S);
    }

    public static java.lang.Object getPackageManager() {
        try {
            android.os.IBinder iBinderC = com.tencent.turingfd.sdk.ams.ad.m.c(PACKAGE);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(CLASS);
            sb.append("$Stub");
            return com.tencent.turingfd.sdk.ams.ad.C0095k.a(sb.toString(), S, new java.lang.Class[]{android.os.IBinder.class}, null, new java.lang.Object[]{iBinderC});
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static java.lang.String[] getPackagesForUid(int i) {
        java.lang.String[] strArr;
        try {
            java.lang.Object packageManager = getPackageManager();
            java.lang.reflect.Method method = java.lang.Class.forName(CLASS).getMethod(ka, java.lang.Integer.TYPE);
            method.setAccessible(true);
            strArr = (java.lang.String[]) method.invoke(packageManager, java.lang.Integer.valueOf(i));
        } catch (java.lang.Throwable unused) {
            strArr = null;
        }
        return strArr == null ? new java.lang.String[0] : strArr;
    }
}
