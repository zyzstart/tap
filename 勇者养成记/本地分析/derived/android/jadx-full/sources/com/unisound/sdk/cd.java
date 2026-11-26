package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class cd implements com.unisound.sdk.cl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.unisound.sdk.cc f1549a;

    cd(com.unisound.sdk.cc ccVar) {
        this.f1549a = ccVar;
    }

    @Override // com.unisound.sdk.cl
    public void a(int i) {
        this.f1549a.sendMessage(101, java.lang.Integer.valueOf(i));
    }

    @Override // com.unisound.sdk.cl
    public void a(java.lang.String str) {
        this.f1549a.sendMessage(100, str);
    }

    @Override // com.unisound.sdk.cl
    public void b(int i) {
        this.f1549a.sendMessage(102, java.lang.Integer.valueOf(i));
    }
}
