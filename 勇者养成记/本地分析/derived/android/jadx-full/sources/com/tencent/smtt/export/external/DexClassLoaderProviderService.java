package com.tencent.smtt.export.external;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DexClassLoaderProviderService extends android.app.Service {
    private static final java.lang.String LOGTAG = "dexloader";

    @Override // android.app.Service
    public android.os.IBinder onBind(android.content.Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        android.util.Log.d(LOGTAG, "DexClassLoaderProviderService -- onCreate()");
        com.tencent.smtt.export.external.DexClassLoaderProvider.setForceLoadDexFlag(true, this);
    }

    @Override // android.app.Service
    public void onDestroy() {
        android.util.Log.d(LOGTAG, "DexClassLoaderProviderService -- onDestroy()");
        java.lang.System.exit(0);
    }

    @Override // android.app.Service
    public int onStartCommand(android.content.Intent intent, int i, int i2) {
        android.util.Log.d(LOGTAG, "DexClassLoaderProviderService -- onStartCommand(" + intent + ")");
        if (intent == null) {
            return 1;
        }
        try {
            java.util.ArrayList<java.lang.String> stringArrayListExtra = intent.getStringArrayListExtra("dex2oat");
            if (stringArrayListExtra == null) {
                return 1;
            }
            java.lang.String str = stringArrayListExtra.get(0);
            java.lang.String str2 = stringArrayListExtra.get(1);
            java.lang.String str3 = stringArrayListExtra.get(2);
            java.lang.String str4 = stringArrayListExtra.get(3);
            android.util.Log.d(LOGTAG, "DexClassLoaderProviderService -- onStartCommand(" + str + ")");
            java.lang.ClassLoader classLoader = getClassLoader();
            java.io.File file = new java.io.File(str3);
            if (!file.exists()) {
                file.mkdirs();
            }
            com.tencent.smtt.export.external.DexClassLoaderProvider.createDexClassLoader(str2, str3, str4, classLoader, getApplicationContext());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return 1;
    }
}
