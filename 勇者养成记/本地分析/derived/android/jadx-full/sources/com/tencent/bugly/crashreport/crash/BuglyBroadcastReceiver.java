package com.tencent.bugly.crashreport.crash;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BuglyBroadcastReceiver extends android.content.BroadcastReceiver {
    private static com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver d;
    private android.content.Context b;
    private java.lang.String c;
    private boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.IntentFilter f297a = new android.content.IntentFilter();

    private synchronized boolean a(android.content.Context context, android.content.Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.e) {
                    this.e = false;
                    return true;
                }
                java.lang.String strC = com.tencent.bugly.crashreport.common.info.b.c(this.b);
                com.tencent.bugly.proguard.x.c("is Connect BC " + strC, new java.lang.Object[0]);
                com.tencent.bugly.proguard.x.a("network %s changed to %s", this.c, strC);
                if (strC == null) {
                    this.c = null;
                    return true;
                }
                java.lang.String str = this.c;
                this.c = strC;
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a aVarA = com.tencent.bugly.crashreport.common.strategy.a.a();
                com.tencent.bugly.proguard.u uVarA = com.tencent.bugly.proguard.u.a();
                com.tencent.bugly.crashreport.common.info.a aVarA2 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (aVarA != null && uVarA != null && aVarA2 != null) {
                    if (!strC.equals(str)) {
                        if (jCurrentTimeMillis - uVarA.a(com.tencent.bugly.crashreport.crash.c.f310a) > 30000) {
                            com.tencent.bugly.proguard.x.a("try to upload crash on network changed.", new java.lang.Object[0]);
                            com.tencent.bugly.crashreport.crash.c cVarA = com.tencent.bugly.crashreport.crash.c.a();
                            if (cVarA != null) {
                                cVarA.a(0L);
                            }
                        }
                        if (jCurrentTimeMillis - uVarA.a(1001) > 30000) {
                            com.tencent.bugly.proguard.x.a("try to upload userinfo on network changed.", new java.lang.Object[0]);
                            com.tencent.bugly.crashreport.biz.b.f288a.b();
                        }
                    }
                    return true;
                }
                com.tencent.bugly.proguard.x.d("not inited BC not work", new java.lang.Object[0]);
                return true;
            }
        }
        return false;
    }

    public static synchronized com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver getInstance() {
        if (d == null) {
            d = new com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver();
        }
        return d;
    }

    public synchronized void addFilter(java.lang.String str) {
        if (!this.f297a.hasAction(str)) {
            this.f297a.addAction(str);
        }
        com.tencent.bugly.proguard.x.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        try {
            a(context, intent);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(android.content.Context context) {
        this.b = context;
        com.tencent.bugly.proguard.z.a(new java.lang.Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    com.tencent.bugly.proguard.x.a(com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.d.getClass(), "Register broadcast receiver of Bugly.", new java.lang.Object[0]);
                    synchronized (this) {
                        com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.this.b.registerReceiver(com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.d, com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.this.f297a);
                    }
                } catch (java.lang.Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(android.content.Context context) {
        try {
            com.tencent.bugly.proguard.x.a(getClass(), "Unregister broadcast receiver of Bugly.", new java.lang.Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
