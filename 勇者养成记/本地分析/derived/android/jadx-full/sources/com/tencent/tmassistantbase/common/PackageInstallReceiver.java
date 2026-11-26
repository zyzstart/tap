package com.tencent.tmassistantbase.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PackageInstallReceiver extends android.content.BroadcastReceiver {
    private static com.tencent.tmassistantbase.common.PackageInstallReceiver d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final java.lang.String f1017a = com.tencent.tmassistantbase.common.PackageInstallReceiver.class.getName();
    protected boolean b = false;
    private final android.os.Handler e = new com.tencent.tmassistantbase.common.b(this);
    java.util.ArrayList c = new java.util.ArrayList();

    public static synchronized com.tencent.tmassistantbase.common.PackageInstallReceiver a() {
        if (d == null) {
            d = new com.tencent.tmassistantbase.common.PackageInstallReceiver();
        }
        return d;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(java.lang.String str, int i) {
        java.util.Iterator it = this.c.iterator();
        while (it.hasNext()) {
            ((com.tencent.tmassistantbase.common.c) it.next()).a(str, i);
        }
    }

    public void a(android.content.Context context) {
        if (context != null) {
            android.content.IntentFilter intentFilter = new android.content.IntentFilter();
            intentFilter.addDataScheme("package");
            intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
            context.registerReceiver(this, intentFilter);
            this.b = true;
        }
    }

    public void a(com.tencent.tmassistantbase.common.c cVar) {
        if (this.c.contains(cVar) || cVar == null) {
            return;
        }
        this.c.add(cVar);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.d(this.f1017a, "intent Action >> " + intent.getAction());
        android.util.Log.i(this.f1017a, "installTest onReceive intent Action >>" + intent.getAction());
        java.lang.String dataString = intent.getDataString();
        if (android.text.TextUtils.isEmpty(dataString)) {
            com.tencent.tmassistantbase.util.TMLog.e(this.f1017a, "intentPkgNameString == null ");
            return;
        }
        java.lang.String[] strArrSplit = dataString.split(":");
        if (strArrSplit.length != 2) {
            com.tencent.tmassistantbase.util.TMLog.e(this.f1017a, "packageName == null " + intent.getDataString());
            return;
        }
        java.lang.String str = strArrSplit[1];
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.obj = str;
        if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
            com.tencent.tmassistantbase.util.TMLog.d(this.f1017a, "ACTION_PACKAGE_REMOVED >> " + dataString);
            messageObtain.what = 2;
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
            com.tencent.tmassistantbase.util.TMLog.d(this.f1017a, "ACTION_PACKAGE_REPLACED >> " + dataString);
            messageObtain.what = 3;
        } else if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
            com.tencent.tmassistantbase.util.TMLog.d(this.f1017a, "ACTION_PACKAGE_ADDED >> " + dataString);
            messageObtain.what = 1;
        }
        this.e.sendMessage(messageObtain);
    }
}
