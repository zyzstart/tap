package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ak {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1470a = -1;
    int b;
    java.lang.String c;
    private boolean d = false;

    public ak(int i, java.lang.String str) {
        this.b = -1;
        this.c = "";
        this.b = i;
        this.c = str;
    }

    public void a(com.unisound.common.ak akVar) {
        this.b = akVar.b;
        this.c = akVar.c;
        this.d = akVar.d;
    }

    void a(java.lang.String str) {
        this.c = str;
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean a() {
        return this.d;
    }

    public java.lang.String b() {
        return this.c;
    }

    public int c() {
        return this.b;
    }
}
