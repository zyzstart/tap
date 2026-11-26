package com.qq.gdt.action.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements com.qq.gdt.action.d.b.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f87a;

    public e(int i) {
        this.f87a = i;
    }

    @Override // com.qq.gdt.action.d.b.a.b
    public com.qq.gdt.action.d.b.i a(com.qq.gdt.action.d.b.a.b.a aVar) throws java.io.IOException {
        com.qq.gdt.action.d.b.g gVarA = aVar.a();
        com.qq.gdt.action.d.b.i iVarA = aVar.a(gVarA);
        int i = 0;
        while (!iVarA.b() && i < this.f87a) {
            iVarA.e().close();
            i++;
            com.qq.gdt.action.h.l.a(com.qq.gdt.action.h.t.a("Retry for %s, retry number = %d", gVarA.a(), java.lang.Integer.valueOf(i)), new java.lang.Object[0]);
            iVarA = aVar.a(gVarA);
        }
        return iVarA;
    }
}
