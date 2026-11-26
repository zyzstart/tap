package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g extends android.content.BroadcastReceiver implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.a.g f136a;
    private static final java.util.List b = new java.util.ArrayList();
    private android.content.Context c;
    private volatile boolean d = false;
    private volatile boolean e = false;
    private boolean f = true;

    public interface a {
        void a();
    }

    private g() {
    }

    public static com.tencent.beacon.core.a.g a() {
        if (f136a == null) {
            synchronized (com.tencent.beacon.core.a.g.class) {
                if (f136a == null) {
                    f136a = new com.tencent.beacon.core.a.g();
                }
            }
        }
        return f136a;
    }

    public void a(android.content.Context context, com.tencent.beacon.core.a.g.a aVar) {
        if (context == null) {
            com.tencent.beacon.core.e.d.b("[net] Context is null!", new java.lang.Object[0]);
            return;
        }
        synchronized (b) {
            b.add(aVar);
        }
        if (this.e) {
            return;
        }
        context.registerReceiver(this, new android.content.IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.e = true;
    }

    public void a(com.tencent.beacon.core.a.g.a aVar) {
        synchronized (b) {
            b.remove(aVar);
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(android.content.Context context, android.content.Intent intent) {
        this.c = context.getApplicationContext();
        if (this.f) {
            this.f = false;
        } else {
            if (this.d) {
                return;
            }
            com.tencent.beacon.core.a.d.a().a(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d = true;
        try {
            if (this.c == null) {
                com.tencent.beacon.core.e.d.b("[net] onReceive context is null!", new java.lang.Object[0]);
                return;
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) this.c.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.tencent.beacon.core.e.d.b("[net] onReceive ConnectivityManager is null!", new java.lang.Object[0]);
                return;
            }
            android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            android.net.NetworkInfo.State state = networkInfo != null ? networkInfo.getState() : null;
            if (android.net.NetworkInfo.State.CONNECTED == (networkInfo2 != null ? networkInfo2.getState() : null) || android.net.NetworkInfo.State.CONNECTED == state) {
                synchronized (b) {
                    java.util.Iterator it = b.iterator();
                    while (it.hasNext()) {
                        ((com.tencent.beacon.core.a.g.a) it.next()).a();
                    }
                }
            }
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.a(e);
        }
        this.d = false;
    }
}
