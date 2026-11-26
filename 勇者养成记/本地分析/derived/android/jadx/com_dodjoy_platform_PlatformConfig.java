package com.dodjoy.platform;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PlatformConfig {
    private static android.os.Bundle mMetaData;

    public static android.os.Bundle GetMetaData() {
        return mMetaData;
    }

    public static void Init(android.app.Activity activity) {
        try {
            mMetaData = activity.getPackageManager().getApplicationInfo(activity.getPackageName(), 128).metaData;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }
}
