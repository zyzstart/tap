package com.tencent.yybsdk.apkpatch.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {
    public static boolean a() {
        try {
            com.tencent.yybsdk.apkpatch.f.a.a aVarA = com.tencent.yybsdk.apkpatch.f.a.a.a();
            return (aVarA.a("ro.miui.ui.version.code", null) == null && aVarA.a("ro.miui.ui.version.name", null) == null && aVarA.a("ro.miui.internal.storage", null) == null) ? false : true;
        } catch (java.io.IOException unused) {
            return false;
        }
    }

    public static java.lang.String[] b() {
        java.lang.String[] strArr = {"MIUI", "0"};
        try {
            strArr[1] = com.tencent.yybsdk.apkpatch.f.a.a.a().a("ro.miui.ui.version.name", "0");
        } catch (java.lang.Exception unused) {
        }
        return strArr;
    }
}
