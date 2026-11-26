package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f1240a;
    private boolean b = false;
    public java.lang.String c = "";
    private java.util.Map d = null;
    private java.util.Set e = null;
    private java.util.Set f = null;

    public d(int i) {
        this.f1240a = i;
    }

    public java.util.Map a() {
        return this.d;
    }

    public void a(java.util.Map map) {
        this.d = map;
    }

    public void a(java.util.Set set) {
        this.e = set;
    }

    public void a(boolean z) {
        this.b = z;
    }

    public int b() {
        return this.f1240a;
    }

    public void b(java.util.Set set) {
        this.f = set;
    }

    public boolean c() {
        return this.b;
    }
}
