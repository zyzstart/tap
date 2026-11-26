package com.tencent.beaconselfupdate.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d extends android.content.BroadcastReceiver {
    private android.content.Context b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f237a = false;
    private java.lang.Runnable c = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.a.d.1
        @Override // java.lang.Runnable
        public final void run() {
            com.tencent.beaconselfupdate.c.a.b(" db events to up on netConnectChange", new java.lang.Object[0]);
            try {
                com.tencent.beaconselfupdate.event.j.d(true);
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
            }
        }
    };

    public final void a(android.content.Context context) {
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.c(" Context is null!", new java.lang.Object[0]);
        } else {
            if (this.f237a) {
                return;
            }
            this.f237a = true;
            try {
                context.registerReceiver(this, new android.content.IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            } catch (java.lang.SecurityException unused) {
                com.tencent.beaconselfupdate.c.a.d("register receiver failure by SecurityException", new java.lang.Object[0]);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        try {
            if (context == null) {
                com.tencent.beaconselfupdate.c.a.c(" onReceive context is null!", new java.lang.Object[0]);
                return;
            }
            if (this.b == null) {
                this.b = context;
            }
            android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                com.tencent.beaconselfupdate.c.a.c(" onReceive ConnectivityManager is null!", new java.lang.Object[0]);
                return;
            }
            android.net.NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            android.net.NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
            android.net.NetworkInfo.State state = networkInfo != null ? networkInfo.getState() : null;
            android.net.NetworkInfo.State state2 = networkInfo2 != null ? networkInfo2.getState() : null;
            if (state != null || state2 != null) {
                com.tencent.beaconselfupdate.a.b.b bVarA = com.tencent.beaconselfupdate.a.b.b.a(context);
                if (!bVarA.a() && com.tencent.beaconselfupdate.event.j.d().h() != 0 && bVarA.j() != 2) {
                    com.tencent.beaconselfupdate.a.b.a().a(bVarA.d());
                }
            }
            if (state == null && state2 == null) {
                return;
            }
            if (android.net.NetworkInfo.State.CONNECTED == state2 || android.net.NetworkInfo.State.CONNECTED == state) {
                com.tencent.beaconselfupdate.a.b.a().a(this.c);
            }
        } catch (java.lang.Exception e) {
            com.tencent.beaconselfupdate.c.a.a(e);
        }
    }
}
