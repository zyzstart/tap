package com.tencent.yybsdk.apkpatch.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {
    public static boolean a() {
        try {
            return android.os.Build.class.getMethod("hasSmartBar", new java.lang.Class[0]) != null;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    public static java.lang.String[] b() {
        return new java.lang.String[]{"Flyme", "0"};
    }
}
