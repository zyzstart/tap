package com.tencent.ydkbeacon.base.net.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e extends android.content.BroadcastReceiver implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.List f1228a = new java.util.ArrayList();
    private static volatile boolean b = false;
    private boolean c = true;
    private volatile boolean d = false;

    public interface a {
        void a();

        void b();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void a() {
        synchronized (f1228a) {
            java.util.Iterator it = f1228a.iterator();
            while (it.hasNext()) {
                ((com.tencent.ydkbeacon.base.net.c.e.a) it.next()).a();
            }
        }
    }

    public static void a(android.content.Context context, com.tencent.ydkbeacon.base.net.c.e.a aVar) {
        if (context == null) {
            com.tencent.ydkbeacon.a.e.c.b("[net] context == null!", new java.lang.Object[0]);
            return;
        }
        synchronized (f1228a) {
            f1228a.add(aVar);
        }
        if (b) {
            return;
        }
        context.registerReceiver(new com.tencent.ydkbeacon.base.net.c.e(), new android.content.IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        b = true;
    }

    public static void a(com.tencent.ydkbeacon.base.net.c.e.a aVar) {
        synchronized (f1228a) {
            f1228a.remove(aVar);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void b() {
        synchronized (f1228a) {
            java.util.Iterator it = f1228a.iterator();
            while (it.hasNext()) {
                ((com.tencent.ydkbeacon.base.net.c.e.a) it.next()).b();
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        if (this.c) {
            this.c = false;
        } else {
            if (this.d) {
                return;
            }
            com.tencent.ydkbeacon.a.b.a.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    @android.support.annotation.RequiresPermission(com.unisound.client.SpeechConstants.PERMISSION_ACCESS_NETWORK_STATE)
    public void run() {
        this.d = true;
        if (com.tencent.ydkbeacon.base.net.c.d.d()) {
            com.tencent.ydkbeacon.a.e.c.d("[net] current network available!", new java.lang.Object[0]);
            a();
        } else {
            com.tencent.ydkbeacon.a.e.c.d("[net] current network unavailable!", new java.lang.Object[0]);
            b();
        }
        this.d = false;
    }
}
