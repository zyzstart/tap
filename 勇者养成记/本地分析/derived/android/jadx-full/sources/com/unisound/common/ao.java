package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ao extends android.os.Handler implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f1473a = "TimerThreadUtils";
    private int b;
    private com.unisound.common.ap c;
    private boolean d;
    private boolean e;

    public ao(com.unisound.common.ap apVar, android.os.Looper looper) {
        super(looper);
        this.b = 300000;
        this.d = false;
        this.e = false;
        this.c = apVar;
    }

    public int a() {
        return this.b;
    }

    public void a(int i) {
        this.b = i;
    }

    public boolean b() {
        return this.d;
    }

    public void c() {
        e();
        postDelayed(this, this.b);
        this.d = false;
        this.e = true;
    }

    public void d() {
        e();
    }

    public void e() {
        if (this.e) {
            removeCallbacks(this);
            this.e = false;
        }
        this.d = false;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.d = true;
        if (this.e) {
            this.c.a();
        }
    }
}
