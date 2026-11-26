package com.tencent.bugly.opengame.crashreport.crash;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class BuglyBroadcastReceiver extends android.content.BroadcastReceiver {
    private static com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver d;
    private android.content.Context b;
    private java.lang.String c;
    private boolean e = true;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.IntentFilter f347a = new android.content.IntentFilter();

    private synchronized boolean a(android.content.Context context, android.content.Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.e) {
                    this.e = false;
                    return true;
                }
                java.lang.String strC = com.tencent.bugly.opengame.crashreport.common.info.b.c(this.b);
                com.tencent.bugly.opengame.proguard.x.c("is Connect BC " + strC, new java.lang.Object[0]);
                com.tencent.bugly.opengame.proguard.x.a("network %s changed to %s", this.c, strC);
                if (strC == null) {
                    this.c = null;
                    return true;
                }
                java.lang.String str = this.c;
                this.c = strC;
                long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                com.tencent.bugly.opengame.crashreport.common.strategy.a aVarA = com.tencent.bugly.opengame.crashreport.common.strategy.a.a();
                com.tencent.bugly.opengame.proguard.u uVarA = com.tencent.bugly.opengame.proguard.u.a();
                com.tencent.bugly.opengame.crashreport.common.info.a aVarA2 = com.tencent.bugly.opengame.crashreport.common.info.a.a(context);
                if (aVarA != null && uVarA != null && aVarA2 != null) {
                    if (!strC.equals(str)) {
                        if (jCurrentTimeMillis - uVarA.a(com.tencent.bugly.opengame.crashreport.crash.c.f360a) > 30000) {
                            com.tencent.bugly.opengame.proguard.x.a("try to upload crash on network changed.", new java.lang.Object[0]);
                            com.tencent.bugly.opengame.crashreport.crash.c cVarA = com.tencent.bugly.opengame.crashreport.crash.c.a();
                            if (cVarA != null) {
                                cVarA.a(0L);
                            }
                        }
                        if (jCurrentTimeMillis - uVarA.a(1001) > 30000) {
                            com.tencent.bugly.opengame.proguard.x.a("try to upload userinfo on network changed.", new java.lang.Object[0]);
                            com.tencent.bugly.opengame.crashreport.biz.b.f338a.b();
                        }
                    }
                    return true;
                }
                com.tencent.bugly.opengame.proguard.x.d("not inited BC not work", new java.lang.Object[0]);
                return true;
            }
        }
        return false;
    }

    public static synchronized com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver getInstance() {
        if (d == null) {
            d = new com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver();
        }
        return d;
    }

    public synchronized void addFilter(java.lang.String str) {
        if (!this.f347a.hasAction(str)) {
            this.f347a.addAction(str);
        }
        com.tencent.bugly.opengame.proguard.x.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(android.content.Context context, android.content.Intent intent) {
        try {
            a(context, intent);
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(android.content.Context context) {
        this.b = context;
        com.tencent.bugly.opengame.proguard.z.a(new java.lang.Runnable() { // from class: com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.1
            /* JADX WARN: Bottom block not found for handler: all -> 0x002b */
            /* JADX WARN: Code restructure failed: missing block: B:14:0x002f, code lost:
            
                return;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final void run() {
                /*
                    r4 = this;
                    com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver r0 = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.a()     // Catch: java.lang.Throwable -> L2b
                    java.lang.Class r0 = r0.getClass()     // Catch: java.lang.Throwable -> L2b
                    java.lang.String r1 = "Register broadcast receiver of Bugly."
                    r2 = 0
                    java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L2b
                    com.tencent.bugly.opengame.proguard.x.a(r0, r1, r2)     // Catch: java.lang.Throwable -> L2b
                    com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver r0 = r2     // Catch: java.lang.Throwable -> L2b
                    monitor-enter(r0)     // Catch: java.lang.Throwable -> L2b
                    com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver r1 = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.this     // Catch: java.lang.Throwable -> L28
                    android.content.Context r1 = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.b(r1)     // Catch: java.lang.Throwable -> L28
                    com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver r2 = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.a()     // Catch: java.lang.Throwable -> L28
                    com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver r3 = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.this     // Catch: java.lang.Throwable -> L28
                    android.content.IntentFilter r3 = com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.a(r3)     // Catch: java.lang.Throwable -> L28
                    r1.registerReceiver(r2, r3)     // Catch: java.lang.Throwable -> L28
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L28
                    goto L2f
                L28:
                    r1 = move-exception
                    monitor-exit(r0)     // Catch: java.lang.Throwable -> L2b
                    throw r1     // Catch: java.lang.Throwable -> L2b
                L2b:
                    r0 = move-exception
                    r0.printStackTrace()
                L2f:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.opengame.crashreport.crash.BuglyBroadcastReceiver.AnonymousClass1.run():void");
            }
        });
    }

    public synchronized void unregister(android.content.Context context) {
        try {
            com.tencent.bugly.opengame.proguard.x.a(getClass(), "Unregister broadcast receiver of Bugly.", new java.lang.Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (java.lang.Throwable th) {
            if (com.tencent.bugly.opengame.proguard.x.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }
}
