package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class av {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.unisound.common.ah f1523a = null;

    public void a(int i) {
        com.unisound.common.ah ahVar = this.f1523a;
        if (ahVar != null) {
            ahVar.a(i);
        }
    }

    public void a(com.unisound.common.ah ahVar) {
        this.f1523a = ahVar;
    }

    public boolean a() {
        return this.f1523a != null;
    }

    public void b() {
        com.unisound.common.ah ahVar = this.f1523a;
        if (ahVar != null) {
            ahVar.a();
        }
    }

    public void c() {
        com.unisound.common.ah ahVar = this.f1523a;
        if (ahVar != null) {
            ahVar.b();
        }
    }
}
