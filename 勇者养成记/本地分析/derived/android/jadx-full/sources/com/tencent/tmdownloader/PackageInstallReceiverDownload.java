package com.tencent.tmdownloader;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PackageInstallReceiverDownload extends android.content.BroadcastReceiver {
    private static com.tencent.tmdownloader.PackageInstallReceiverDownload c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final java.lang.String f1113a = "PackageInstallReceiver";
    protected boolean b = false;

    public static synchronized com.tencent.tmdownloader.PackageInstallReceiverDownload a() {
        if (c == null) {
            c = new com.tencent.tmdownloader.PackageInstallReceiverDownload();
        }
        return c;
    }

    private java.lang.String b() {
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        int iMyPid = android.os.Process.myPid();
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB == null || (runningAppProcesses = ((android.app.ActivityManager) contextB.getSystemService("activity")).getRunningAppProcesses()) == null || runningAppProcesses.size() <= 0) {
            return null;
        }
        for (android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == iMyPid) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public void a(android.content.Context context) {
        android.content.Context applicationContext;
        if (context == null || (applicationContext = context.getApplicationContext()) == null) {
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        applicationContext.registerReceiver(this, intentFilter);
        this.b = true;
    }

    public void a(java.lang.String str) {
        java.lang.String str2 = (java.lang.System.currentTimeMillis() / 1000) + "||" + str + "|";
        com.tencent.tmassistantbase.util.TMLog.d("PackageInstallReceiver", "reportLog installTest type=9,yybInstallReport.data: " + str2);
        com.tencent.tmassistantbase.c.b.b().a(9, str2);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.d("PackageInstallReceiver", "halleytest intent Action" + intent.getAction());
        java.lang.String dataString = intent.getDataString();
        if (android.text.TextUtils.isEmpty(dataString)) {
            com.tencent.tmassistantbase.util.TMLog.e("PackageInstallReceiver", "intentPkgNameString == null ");
            return;
        }
        java.lang.String[] strArrSplit = dataString.split(":");
        if (strArrSplit.length != 2) {
            com.tencent.tmassistantbase.util.TMLog.e("PackageInstallReceiver", "packageName == null " + intent.getDataString());
            return;
        }
        java.lang.String str = strArrSplit[1];
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = str;
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            com.tencent.tmassistantbase.util.TMLog.d("PackageInstallReceiver", "ACTION_PACKAGE_REMOVED >> " + dataString);
            messageObtain.what = 2;
            return;
        }
        if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
            com.tencent.tmassistantbase.util.TMLog.d("PackageInstallReceiver", "ACTION_PACKAGE_REPLACED >> " + dataString);
            messageObtain.what = 3;
            return;
        }
        if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            com.tencent.tmassistantbase.util.TMLog.d("PackageInstallReceiver", "ACTION_PACKAGE_ADDED >> " + dataString);
            messageObtain.what = 1;
            java.lang.String strB = b();
            if (strB == null || !strB.contains("TMAssistantDownloadSDKService")) {
                try {
                    a(str);
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
