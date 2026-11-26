package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.unisound.common.b f1510a = null;
    private com.unisound.common.d b = null;

    public void a(int i) {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.b(i);
        }
    }

    public void a(com.unisound.common.b bVar) {
        this.f1510a = bVar;
        com.unisound.common.b bVar2 = this.f1510a;
        if (bVar2 != null) {
            bVar2.a(this.b);
        }
    }

    public void a(com.unisound.common.d dVar) {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.a(dVar);
        }
        this.b = dVar;
    }

    public void a(java.lang.String str, boolean z) {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.a(str, z);
        }
    }

    public boolean a() {
        return this.f1510a != null;
    }

    public void b() {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.f();
        }
    }

    public void b(int i) {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    public void c() {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void d() {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.h();
        }
    }

    public void e() {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.d();
        }
    }

    public void f() {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.i();
        }
    }

    public void g() {
        com.unisound.common.b bVar = this.f1510a;
        if (bVar != null) {
            bVar.e();
        }
    }
}
