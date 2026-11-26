package com.tencent.ysdk.shell.framework.storage;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LightStorageFactory {
    private LightStorageFactory() {
    }

    public static com.tencent.ysdk.shell.framework.storage.ILightStorage getLightStorage(java.lang.String str) {
        return new com.tencent.ysdk.shell.framework.storage.SharedPreferencesLightStorage(com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(str, 0));
    }
}
