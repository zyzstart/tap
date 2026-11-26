package com.tencent.safecloud.device.openlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NativeHelper {
    public dalvik.system.DexClassLoader mDexClassLoader;

    static {
        try {
            java.lang.System.loadLibrary("scfp");
        } catch (java.lang.Exception e) {
            com.tencent.safecloud.device.openlib.LogUtil.d("loadLibrary fail" + com.tencent.safecloud.device.openlib.ErrorManager.catchMsg(e));
        }
    }

    public native java.lang.String q1(java.lang.String str);

    public native java.lang.String q10(java.lang.String str);

    public native java.lang.String q11(java.lang.String str);

    public native java.lang.String q12(java.lang.String str);

    public native java.lang.String q13(java.lang.String str, java.lang.String str2);

    public native java.lang.String q14(java.lang.String str, java.lang.String str2);

    public native java.lang.String[] q15(java.lang.String str, java.lang.String str2, boolean z);

    public native java.lang.String q16(java.lang.String str, java.lang.String str2, boolean z);

    public native java.lang.String q2(java.lang.String str);

    public native java.lang.String q3(java.lang.String str);

    public native java.lang.String q4(java.lang.String str);

    public native java.lang.String q5(java.lang.String str);

    public native java.lang.String q6(java.lang.String str);

    public native java.lang.String q7(java.lang.String str);

    public native java.lang.String q8(java.lang.String str);

    public native java.lang.String q9();

    public native int t1(java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.res.AssetManager assetManager, java.lang.ClassLoader classLoader);
}
