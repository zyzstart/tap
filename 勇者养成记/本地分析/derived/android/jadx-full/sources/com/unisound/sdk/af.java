package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class af extends android.os.Handler implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1514a;
    private com.unisound.sdk.ag b;
    private boolean c;
    private boolean d;

    public af(com.unisound.sdk.ag agVar, android.os.Looper looper) {
        super(looper);
        this.f1514a = 30000;
        this.c = false;
        this.d = false;
        this.b = agVar;
    }

    public int a() {
        return this.f1514a;
    }

    public void a(int i) {
        this.f1514a = i;
    }

    public boolean b() {
        return this.c;
    }

    public void c() {
        e();
        postDelayed(this, this.f1514a);
        this.c = false;
        this.d = true;
        com.unisound.common.y.a("OnTimer:start");
    }

    public void d() {
        e();
    }

    public void e() {
        if (this.d) {
            removeCallbacks(this);
            this.d = false;
        }
        this.c = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c = true;
        if (this.d) {
            this.b.a();
        }
    }
}
