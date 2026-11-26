package com.tencent.tmdownloader.internal.downloadclient;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MobileQQCloseServiceReceiver extends android.content.BroadcastReceiver {
    protected static com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f1126a = false;
    public android.os.HandlerThread c = new android.os.HandlerThread("checkIsAllFinishThread");
    public android.os.Handler d = null;

    private MobileQQCloseServiceReceiver() {
    }

    public static synchronized com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver a() {
        if (b == null) {
            b = new com.tencent.tmdownloader.internal.downloadclient.MobileQQCloseServiceReceiver();
        }
        return b;
    }

    private java.lang.String a(java.util.ArrayList arrayList, boolean z) {
        android.text.format.Time time = new android.text.format.Time();
        time.setToNow();
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("com.tencent.process.exit");
        sb.append(time.year);
        sb.append(time.month + 1);
        sb.append(time.monthDay);
        sb.append(time.hour);
        sb.append(z ? time.minute - 1 : time.minute);
        sb.append(arrayList == null ? "null" : arrayList.toString());
        return com.tencent.tmassistantbase.util.n.a(com.tencent.tmassistantbase.util.n.a(sb.toString()) + sb.toString());
    }

    public java.lang.String a(android.content.Context context) {
        android.content.pm.ServiceInfo serviceInfo;
        try {
            serviceInfo = context.getPackageManager().getServiceInfo(new android.content.ComponentName(context, "com.tencent.tmdownloader.TMAssistantDownloadService"), 0);
        } catch (android.content.pm.PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            serviceInfo = null;
        }
        return serviceInfo != null ? serviceInfo.processName : "com.tencent.tmassistantsdk.Service";
    }

    public int b(android.content.Context context) {
        java.lang.String strA = a(context);
        java.util.List<android.app.ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((android.app.ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < runningAppProcesses.size(); i2++) {
            android.app.ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(i2);
            int i3 = runningAppProcessInfo.pid;
            java.lang.String str = runningAppProcessInfo.processName;
            if (strA.equals(str)) {
                com.tencent.tmassistantbase.util.TMLog.i("MobileQQCloseServiceReceiver", "MobileQQCloseServiceReceiver killProcessByName;process name: " + str + " pid: " + i3);
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("MobileQQCloseServiceReceiver killProcessByName;killProcess pid-->");
                sb.append(i3);
                com.tencent.tmassistantbase.util.TMLog.i("MobileQQCloseServiceReceiver", sb.toString());
                android.os.Process.killProcess(i3);
                i++;
            }
        }
        return i;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        java.lang.String action;
        com.tencent.tmassistantbase.util.TMLog.i("MobileQQCloseServiceReceiver", "receive broadcast close all service");
        if (context == null || intent == null || (action = intent.getAction()) == null || !action.equals("com.tencent.process.exit") || intent.getExtras() == null) {
            return;
        }
        java.util.ArrayList<java.lang.String> stringArrayList = intent.getExtras().getStringArrayList("procNameList");
        java.lang.String string = intent.getExtras().getString("verify");
        boolean z = true;
        boolean z2 = (string == null || string.length() == 0 || (!string.equals(a(stringArrayList, false)) && !string.equals(a(stringArrayList, true)))) ? false : true;
        if (stringArrayList != null && stringArrayList.size() != 0) {
            java.lang.String strA = a(context);
            boolean z3 = false;
            for (int i = 0; i < stringArrayList.size(); i++) {
                if (strA.equals(stringArrayList.get(i))) {
                    z3 = true;
                }
            }
            z = z3;
        }
        if (z2 && z) {
            if (!this.c.isAlive()) {
                this.c.start();
                this.d = new android.os.Handler(this.c.getLooper());
            }
            android.os.Handler handler = this.d;
            if (handler != null) {
                handler.post(new com.tencent.tmdownloader.internal.downloadclient.a(this, context));
            }
        }
    }
}
