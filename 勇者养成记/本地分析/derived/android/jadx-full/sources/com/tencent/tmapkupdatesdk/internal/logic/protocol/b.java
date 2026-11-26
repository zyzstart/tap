package com.tencent.tmapkupdatesdk.internal.logic.protocol;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    private static com.tencent.tmapkupdatesdk.internal.logic.protocol.b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1001a;
    private java.util.concurrent.ExecutorService c;

    private b() {
    }

    public static synchronized com.tencent.tmapkupdatesdk.internal.logic.protocol.b a() {
        if (b == null) {
            b = new com.tencent.tmapkupdatesdk.internal.logic.protocol.b();
        }
        return b;
    }

    private static java.lang.String a(android.content.Context context, java.lang.String str, boolean z) {
        if (!z || !"mounted".equals(android.os.Environment.getExternalStorageState()) || !android.os.Environment.getExternalStorageDirectory().canWrite()) {
            java.lang.String absolutePath = context.getFilesDir().getAbsolutePath();
            if (absolutePath.endsWith("/")) {
                return absolutePath;
            }
            return absolutePath + "/";
        }
        java.io.File file = new java.io.File(android.os.Environment.getExternalStorageDirectory().getPath() + str);
        if (!file.exists()) {
            file.mkdirs();
        }
        java.lang.String absolutePath2 = file.getAbsolutePath();
        if (absolutePath2.endsWith("/")) {
            return absolutePath2;
        }
        return absolutePath2 + "/";
    }

    public static java.lang.String a(java.lang.String str) throws java.lang.Throwable {
        try {
            android.content.pm.PackageInfo packageInfo = a().b().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo == null) {
                return "";
            }
            java.lang.String str2 = packageInfo.applicationInfo.sourceDir;
            com.tencent.tmassistantbase.util.TMLog.i("ProtocolHelper", "packageName: " + str);
            com.tencent.tmassistantbase.util.TMLog.i("ProtocolHelper", "localPath: " + str2);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.lang.String str3 = a(a().b(), "/mfcache", true) + str + ".cache";
            new com.tencent.tmapkupdatesdk.internal.a.f(str2, str3).a();
            java.lang.String strB = com.tencent.tmassistantbase.util.n.b(str3);
            com.tencent.tmassistantbase.util.TMLog.i("ProtocolHelper", "old_md5: cost=" + (java.lang.System.currentTimeMillis() - jCurrentTimeMillis) + "; md5=" + strB);
            return strB != null ? strB : "";
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.tencent.tmassistantbase.util.TMLog.e("ProtocolHelper", "exception: ", e);
            e.printStackTrace();
            return "";
        }
    }

    public void a(android.content.Context context) {
        this.c = java.util.concurrent.Executors.newFixedThreadPool(5);
        this.f1001a = context;
    }

    public void a(java.lang.Runnable runnable) {
        com.tencent.tmassistantbase.util.TMLog.i("ProtocolHelper", "startNewTask");
        java.util.concurrent.ExecutorService executorService = this.c;
        if (executorService == null || executorService.isShutdown()) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("ProtocolHelper", "threadPool.execute");
        this.c.execute(runnable);
    }

    public android.content.Context b() {
        return this.f1001a;
    }

    public java.lang.String b(java.lang.String str) {
        android.content.pm.Signature[] signatureArr;
        try {
            android.content.pm.PackageInfo packageInfo = this.f1001a.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo == null || (signatureArr = packageInfo.signatures) == null || signatureArr.length <= 0) {
                return "";
            }
            java.lang.String charsString = signatureArr[signatureArr.length - 1].toCharsString();
            com.tencent.tmassistantbase.util.TMLog.i("ProtocolHelper", " signatures MD5: " + com.tencent.tmassistantbase.util.n.a(charsString));
            return com.tencent.tmassistantbase.util.n.a(charsString);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            com.tencent.tmassistantbase.util.TMLog.e("ProtocolHelper", "exception: ", e);
            e.printStackTrace();
            return "";
        }
    }

    public void c() {
        com.tencent.tmassistantbase.util.TMLog.i("ProtocolHelper", "threadPool.shutdown()");
        java.util.concurrent.ExecutorService executorService = this.c;
        if (executorService != null) {
            executorService.shutdown();
            this.c = null;
        }
    }
}
