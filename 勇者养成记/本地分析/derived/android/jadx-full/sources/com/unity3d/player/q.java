package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.unity3d.player.UnityPlayer f1645a;
    private com.unity3d.player.q.a c;
    private android.content.Context b = null;
    private final java.util.concurrent.Semaphore d = new java.util.concurrent.Semaphore(0);
    private final java.util.concurrent.locks.Lock e = new java.util.concurrent.locks.ReentrantLock();
    private com.unity3d.player.p f = null;
    private int g = 2;
    private boolean h = false;
    private boolean i = false;

    /* JADX INFO: renamed from: com.unity3d.player.q$1, reason: invalid class name */
    final class AnonymousClass1 implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ java.lang.String f1646a;
        final /* synthetic */ int b;
        final /* synthetic */ int c;
        final /* synthetic */ int d;
        final /* synthetic */ boolean e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        AnonymousClass1(java.lang.String str, int i, int i2, int i3, boolean z, long j, long j2) {
            this.f1646a = str;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = z;
            this.f = j;
            this.g = j2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (com.unity3d.player.q.this.f != null) {
                com.unity3d.player.g.Log(5, "Video already playing");
                com.unity3d.player.q.this.g = 2;
                com.unity3d.player.q.this.d.release();
            } else {
                com.unity3d.player.q qVar = com.unity3d.player.q.this;
                qVar.f = new com.unity3d.player.p(qVar.b, this.f1646a, this.b, this.c, this.d, this.e, this.f, this.g, new com.unity3d.player.p.a() { // from class: com.unity3d.player.q.1.1
                    @Override // com.unity3d.player.p.a
                    public final void a(int i) {
                        com.unity3d.player.q.this.e.lock();
                        com.unity3d.player.q.this.g = i;
                        if (i == 3 && com.unity3d.player.q.this.i) {
                            com.unity3d.player.q.this.runOnUiThread(new java.lang.Runnable() { // from class: com.unity3d.player.q.1.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    com.unity3d.player.q.this.d();
                                    com.unity3d.player.q.this.f1645a.resume();
                                }
                            });
                        }
                        if (i != 0) {
                            com.unity3d.player.q.this.d.release();
                        }
                        com.unity3d.player.q.this.e.unlock();
                    }
                });
                if (com.unity3d.player.q.this.f != null) {
                    com.unity3d.player.q.this.f1645a.addView(com.unity3d.player.q.this.f);
                }
            }
        }
    }

    public interface a {
        void a();
    }

    q(com.unity3d.player.UnityPlayer unityPlayer) {
        this.f1645a = null;
        this.f1645a = unityPlayer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.unity3d.player.p pVar = this.f;
        if (pVar != null) {
            this.f1645a.removeViewFromPlayer(pVar);
            this.i = false;
            this.f.destroyPlayer();
            this.f = null;
            com.unity3d.player.q.a aVar = this.c;
            if (aVar != null) {
                aVar.a();
            }
        }
    }

    static /* synthetic */ boolean h(com.unity3d.player.q qVar) {
        qVar.i = true;
        return true;
    }

    public final void a() {
        this.e.lock();
        com.unity3d.player.p pVar = this.f;
        if (pVar != null) {
            if (this.g == 0) {
                pVar.CancelOnPrepare();
            } else if (this.i) {
                this.h = pVar.a();
                if (!this.h) {
                    this.f.pause();
                }
            }
        }
        this.e.unlock();
    }

    public final boolean a(android.content.Context context, java.lang.String str, int i, int i2, int i3, boolean z, long j, long j2, com.unity3d.player.q.a aVar) {
        this.e.lock();
        this.c = aVar;
        this.b = context;
        this.d.drainPermits();
        this.g = 2;
        runOnUiThread(new com.unity3d.player.q.AnonymousClass1(str, i, i2, i3, z, j, j2));
        boolean z2 = false;
        try {
            this.e.unlock();
            this.d.acquire();
            this.e.lock();
            if (this.g != 2) {
                z2 = true;
            }
        } catch (java.lang.InterruptedException unused) {
        }
        runOnUiThread(new java.lang.Runnable() { // from class: com.unity3d.player.q.2
            @Override // java.lang.Runnable
            public final void run() {
                com.unity3d.player.q.this.f1645a.pause();
            }
        });
        runOnUiThread((!z2 || this.g == 3) ? new java.lang.Runnable() { // from class: com.unity3d.player.q.4
            @Override // java.lang.Runnable
            public final void run() {
                com.unity3d.player.q.this.d();
                com.unity3d.player.q.this.f1645a.resume();
            }
        } : new java.lang.Runnable() { // from class: com.unity3d.player.q.3
            @Override // java.lang.Runnable
            public final void run() {
                if (com.unity3d.player.q.this.f != null) {
                    com.unity3d.player.q.this.f1645a.addViewToPlayer(com.unity3d.player.q.this.f, true);
                    com.unity3d.player.q.h(com.unity3d.player.q.this);
                    com.unity3d.player.q.this.f.requestFocus();
                }
            }
        });
        this.e.unlock();
        return z2;
    }

    public final void b() {
        this.e.lock();
        com.unity3d.player.p pVar = this.f;
        if (pVar != null && this.i && !this.h) {
            pVar.start();
        }
        this.e.unlock();
    }

    public final void c() {
        this.e.lock();
        com.unity3d.player.p pVar = this.f;
        if (pVar != null) {
            pVar.updateVideoLayout();
        }
        this.e.unlock();
    }

    protected final void runOnUiThread(java.lang.Runnable runnable) {
        android.content.Context context = this.b;
        if (context instanceof android.app.Activity) {
            ((android.app.Activity) context).runOnUiThread(runnable);
        } else {
            com.unity3d.player.g.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
