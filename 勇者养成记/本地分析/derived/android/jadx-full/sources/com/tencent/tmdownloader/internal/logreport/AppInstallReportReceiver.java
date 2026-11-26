package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class AppInstallReportReceiver extends android.content.BroadcastReceiver {
    protected static com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final java.lang.String f1137a = com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver.class.getName();
    protected boolean b = false;
    private final android.os.Handler d = new com.tencent.tmdownloader.internal.logreport.a(this);

    public static synchronized com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver a() {
        if (c == null) {
            c = new com.tencent.tmdownloader.internal.logreport.AppInstallReportReceiver();
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i) {
        com.tencent.tmdownloader.internal.logreport.g.h().a(str, (byte) i);
    }

    public void b() {
        com.tencent.tmassistantbase.util.TMLog.i(this.f1137a, "enter");
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB == null) {
            com.tencent.tmassistantbase.util.TMLog.i(this.f1137a, "null == context return");
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        intentFilter.addDataScheme("package");
        try {
            com.tencent.tmassistantbase.util.TMLog.i(this.f1137a, "registerReceiver ok");
            contextB.registerReceiver(this, intentFilter);
            this.b = true;
        } catch (java.lang.Throwable th) {
            com.tencent.tmassistantbase.util.TMLog.i(this.f1137a, "registerReceiver fail");
            this.b = false;
            th.printStackTrace();
        }
    }

    public void c() {
        android.content.Context contextB;
        if (c == null || (contextB = com.tencent.tmassistantbase.util.k.a().b()) == null) {
            return;
        }
        try {
            if (this.b) {
                contextB.unregisterReceiver(this);
                this.b = false;
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.i(this.f1137a, "onReceive >> " + intent.getAction());
        java.lang.String dataString = intent.getDataString();
        if (android.text.TextUtils.isEmpty(dataString)) {
            com.tencent.tmassistantbase.util.TMLog.e(this.f1137a, "onReceive intentPkgNameString == null ");
            return;
        }
        java.lang.String[] strArrSplit = dataString.split(":");
        if (strArrSplit.length != 2) {
            com.tencent.tmassistantbase.util.TMLog.e(this.f1137a, "onReceive packageName == null " + intent.getDataString());
            return;
        }
        java.lang.String str = new java.lang.String(strArrSplit[1].toString());
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = str;
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
            com.tencent.tmassistantbase.util.TMLog.i(this.f1137a, "ACTION_PACKAGE_REPLACED >> " + dataString);
            messageObtain.what = 1;
        } else {
            if (!intent.getAction().equals("android.intent.action.PACKAGE_ADDED") || booleanExtra) {
                return;
            }
            com.tencent.tmassistantbase.util.TMLog.i(this.f1137a, "ACTION_PACKAGE_ADDED >> " + dataString);
            messageObtain.what = 0;
        }
        this.d.sendMessage(messageObtain);
    }
}
