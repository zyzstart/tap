package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.unisound.sdk.ch f1550a;
    private java.lang.Object[] c;
    private boolean d = false;
    com.unisound.sdk.ci b = null;

    public cg(com.unisound.sdk.ch chVar) {
        this.f1550a = chVar;
    }

    public void a() {
        b();
        this.b = new com.unisound.sdk.ci(this, this.f1550a);
        java.lang.Object[] objArr = this.c;
        if (objArr != null) {
            this.b.execute(objArr);
        }
    }

    public void a(java.lang.Object... objArr) {
        this.c = objArr;
    }

    public void b() {
        com.unisound.sdk.ci ciVar = this.b;
        if (ciVar != null) {
            ciVar.a();
            this.b = null;
        }
    }

    public boolean c() {
        return this.d;
    }
}
