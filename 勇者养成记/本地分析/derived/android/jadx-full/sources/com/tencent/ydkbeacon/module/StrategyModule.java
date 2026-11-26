package com.tencent.ydkbeacon.module;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StrategyModule implements com.tencent.ydkbeacon.module.BeaconModule {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.Object f1273a = new java.lang.Object();
    private com.tencent.ydkbeacon.d.h c;
    private boolean e = false;
    private com.tencent.ydkbeacon.d.b d = com.tencent.ydkbeacon.d.b.a();
    private com.tencent.ydkbeacon.d.a b = com.tencent.ydkbeacon.d.a.a();

    public StrategyModule() {
        com.tencent.ydkbeacon.d.g.b().a(this.b);
        this.c = new com.tencent.ydkbeacon.d.h(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void d() {
        if (!this.c.a()) {
            com.tencent.ydkbeacon.a.b.a.a().a(this.c);
        }
    }

    public com.tencent.ydkbeacon.d.a a() {
        return this.b;
    }

    @Override // com.tencent.ydkbeacon.module.BeaconModule
    public void a(android.content.Context context) {
        com.tencent.ydkbeacon.a.e.c.a("[module] strategy module > TRUE", new java.lang.Object[0]);
        this.c.b();
        d();
        com.tencent.ydkbeacon.base.net.c.e.a(context, new com.tencent.ydkbeacon.base.net.c.e.a() { // from class: com.tencent.ydkbeacon.module.StrategyModule.1
            @Override // com.tencent.ydkbeacon.base.net.c.e.a
            public void a() {
                synchronized (com.tencent.ydkbeacon.module.StrategyModule.this) {
                    if (!com.tencent.ydkbeacon.module.StrategyModule.this.c() && !com.tencent.ydkbeacon.module.StrategyModule.this.c.a()) {
                        com.tencent.ydkbeacon.module.StrategyModule.this.d();
                    }
                }
            }

            @Override // com.tencent.ydkbeacon.base.net.c.e.a
            public void b() {
            }
        });
    }

    public void a(boolean z) {
        synchronized (f1273a) {
            this.e = z;
        }
    }

    public com.tencent.ydkbeacon.d.b b() {
        return this.d;
    }

    public boolean c() {
        boolean z;
        synchronized (f1273a) {
            z = this.e;
        }
        return z;
    }
}
