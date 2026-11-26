package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f1640a = false;
    private boolean b = false;
    private boolean c = false;
    private boolean d = true;
    private boolean e = false;

    n() {
    }

    static void a() {
        f1640a = true;
    }

    static void b() {
        f1640a = false;
    }

    static boolean c() {
        return f1640a;
    }

    final void a(boolean z) {
        this.b = z;
    }

    final void b(boolean z) {
        this.d = z;
    }

    final void c(boolean z) {
        this.e = z;
    }

    final void d(boolean z) {
        this.c = z;
    }

    final boolean d() {
        return this.d;
    }

    final boolean e() {
        return this.e;
    }

    final boolean f() {
        return f1640a && this.b && !this.d && !this.c;
    }

    final boolean g() {
        return this.c;
    }

    public final java.lang.String toString() {
        return super.toString();
    }
}
