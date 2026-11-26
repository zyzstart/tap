package com.tencent.tmassistantbase.network;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class NetworkMonitorReceiver extends android.content.BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmassistantbase.network.NetworkMonitorReceiver f1043a;
    protected static android.os.Handler c;
    protected boolean b = false;
    java.util.ArrayList d = new java.util.ArrayList();

    public static synchronized com.tencent.tmassistantbase.network.NetworkMonitorReceiver a() {
        if (f1043a == null) {
            f1043a = new com.tencent.tmassistantbase.network.NetworkMonitorReceiver();
        }
        return f1043a;
    }

    public void a(com.tencent.tmassistantbase.network.d dVar) {
        if (this.d.contains(dVar) || dVar == null) {
            return;
        }
        this.d.add(dVar);
    }

    public void b() {
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB == null) {
            return;
        }
        android.content.IntentFilter intentFilter = new android.content.IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        try {
            contextB.registerReceiver(this, intentFilter);
            this.b = true;
        } catch (java.lang.Throwable th) {
            this.b = false;
            th.printStackTrace();
        }
    }

    public void b(com.tencent.tmassistantbase.network.d dVar) {
        if (dVar != null) {
            this.d.remove(dVar);
        }
    }

    public void c() {
        android.content.Context contextB;
        if (f1043a == null || (contextB = com.tencent.tmassistantbase.util.k.a().b()) == null) {
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

    public void d() {
        java.util.Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((com.tencent.tmassistantbase.network.d) it.next()).a();
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        com.tencent.tmassistantbase.util.TMLog.i("NetworkMonitorReceiver", "network changed!");
        if (c == null) {
            c = new com.tencent.tmassistantbase.network.e(this);
        }
        c.removeMessages(67);
        android.os.Message messageObtain = android.os.Message.obtain();
        messageObtain.what = 67;
        c.sendMessageDelayed(messageObtain, 3500L);
    }
}
