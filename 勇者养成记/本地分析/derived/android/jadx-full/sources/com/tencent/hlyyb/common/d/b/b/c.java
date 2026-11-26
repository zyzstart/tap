package com.tencent.hlyyb.common.d.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c implements com.tencent.hlyyb.common.d.c, java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.hlyyb.common.d.b.b.c f578a = new com.tencent.hlyyb.common.d.b.b.c();
    private com.tencent.hlyyb.common.d.b b;
    private android.os.Handler d;
    private boolean c = false;
    private java.util.Map e = new java.util.concurrent.ConcurrentHashMap();
    private java.lang.Runnable f = new com.tencent.hlyyb.common.d.b.b.e(this);
    private java.lang.Runnable g = new com.tencent.hlyyb.common.d.b.b.f(this);
    private java.lang.Runnable h = new com.tencent.hlyyb.common.d.b.b.g(this);
    private java.util.Map i = new java.util.HashMap();

    private c() {
    }

    static /* synthetic */ com.tencent.hlyyb.common.d.b.b.d a(com.tencent.hlyyb.common.d.b.b.c cVar, java.lang.String str) {
        com.tencent.hlyyb.common.d.b.b.d dVar = (com.tencent.hlyyb.common.d.b.b.d) cVar.i.get(str);
        if (dVar != null) {
            return dVar;
        }
        com.tencent.hlyyb.common.d.b.b.d dVar2 = new com.tencent.hlyyb.common.d.b.b.d(cVar, (byte) 0);
        cVar.i.put(str, dVar2);
        return dVar2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(int i) {
        java.lang.String str;
        int i2;
        if (i == 0) {
            str = "http_platform_update_interval_succ";
        } else {
            str = (i == -4 || i == -3) ? "http_platform_update_interval_nonet" : "http_platform_update_interval_fail";
        }
        if (i == 0) {
            i2 = 1800000;
        } else {
            i2 = (i == -4 || i == -3) ? com.youme.im.CommonConst.SPEECH_DURATION_MAX : 300000;
        }
        return com.tencent.hlyyb.common.a.e.a(str, com.youme.im.CommonConst.SPEECH_DURATION_MAX, 3600000, i2);
    }

    public static com.tencent.hlyyb.common.d.b.b.c c() {
        return f578a;
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a() {
        ((com.tencent.hlyyb.common.d.b.b.b) this.e.get("accessscheduler")).a();
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a(int i) {
        if (i == 1 || i == 2) {
            this.d.removeCallbacks(this.g);
            this.d.post(this.g);
        } else if (i == 3 || i == 4) {
            com.tencent.hlyyb.common.a.r.a().a(this.f, (i == 3 ? b(-4) : b(0)) + (new java.util.Random().nextInt(com.tencent.hlyyb.common.a.e.a("detect_platform_update_random_interval", 0, 1440, 10)) * 60 * 1000));
        }
    }

    @Override // com.tencent.hlyyb.common.d.c
    public final void a(com.tencent.hlyyb.common.d.b bVar) {
        this.b = bVar;
        com.tencent.hlyyb.common.d.b.b.d.a aVar = new com.tencent.hlyyb.common.d.b.b.d.a();
        this.e.put(aVar.c(), aVar);
        com.tencent.hlyyb.common.d.b.b.b.b bVar2 = new com.tencent.hlyyb.common.d.b.b.b.b();
        this.e.put(bVar2.c(), bVar2);
        com.tencent.hlyyb.common.d.b.b.c.a aVar2 = new com.tencent.hlyyb.common.d.b.b.c.a();
        this.e.put(aVar2.c(), aVar2);
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a(boolean z) {
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void b() {
        ((com.tencent.hlyyb.common.d.b.b.b) this.e.get("settings")).b();
    }

    public final com.tencent.hlyyb.common.d.b d() {
        return this.b;
    }

    @Override // com.tencent.hlyyb.common.d.c
    public final void e() {
        android.os.HandlerThread handlerThread = new android.os.HandlerThread("HttpPlatformConnection");
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        this.d = handler;
        handler.post(this);
        this.b.c();
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (com.tencent.hlyyb.common.a.e.a("http_platform_start_update_on", 0, 1, 1) == 1) {
            this.d.post(this.h);
        }
    }
}
