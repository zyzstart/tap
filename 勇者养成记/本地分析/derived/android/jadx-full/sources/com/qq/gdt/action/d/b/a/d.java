package com.qq.gdt.action.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d implements com.qq.gdt.action.d.b.a.b {
    @Override // com.qq.gdt.action.d.b.a.b
    public com.qq.gdt.action.d.b.i a(com.qq.gdt.action.d.b.a.b.a aVar) throws java.io.IOException {
        com.qq.gdt.action.d.b.g gVarA = aVar.a();
        long jNanoTime = java.lang.System.nanoTime();
        com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("Sending request %s %s", gVarA.e(), gVarA.a()), new java.lang.Object[0]);
        com.qq.gdt.action.d.b.i iVarA = aVar.a(gVarA);
        double dNanoTime = java.lang.System.nanoTime() - jNanoTime;
        java.lang.Double.isNaN(dNanoTime);
        com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("Received response for %s in %.1fms (http status code %d)%n%s", iVarA.a().a(), java.lang.Double.valueOf(dNanoTime / 1000000.0d), java.lang.Integer.valueOf(iVarA.c()), com.qq.gdt.action.h.k.a(iVarA.e().c())), new java.lang.Object[0]);
        return iVarA;
    }
}
