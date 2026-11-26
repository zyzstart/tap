package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class bt extends com.unisound.common.f {
    public static final java.lang.String b = "TTSBaseThread";
    private volatile boolean c;
    private boolean d;
    private volatile boolean e;

    public bt(boolean z, boolean z2) {
        super(z2);
        this.c = false;
        this.d = false;
        this.e = false;
        this.d = z;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean a() {
        return this.c;
    }

    public void b() {
        this.c = true;
    }

    public boolean c() {
        return this.d;
    }

    public void d() {
        this.e = true;
    }

    public boolean e() {
        return this.e;
    }

    public void f() {
    }
}
