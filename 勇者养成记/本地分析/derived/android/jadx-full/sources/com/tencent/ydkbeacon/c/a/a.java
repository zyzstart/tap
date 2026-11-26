package com.tencent.ydkbeacon.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.c.a.c f1232a;

    a(com.tencent.ydkbeacon.c.a.c cVar) {
        this.f1232a = cVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        this.f1232a.g.put("A19", fVarP.w());
        this.f1232a.g.put("A85", com.tencent.ydkbeacon.a.c.b.f ? "Y" : "N");
        this.f1232a.g.put("A20", fVarP.J());
        this.f1232a.g.put("A69", fVarP.K());
        this.f1232a.h.a(this.f1232a.g);
    }
}
