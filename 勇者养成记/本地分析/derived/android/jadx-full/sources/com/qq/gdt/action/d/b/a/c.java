package com.qq.gdt.action.d.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.qq.gdt.action.d.b.a.b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.util.List<com.qq.gdt.action.d.b.a.b> f86a;
    private final int b;
    private int c;
    private final com.qq.gdt.action.d.b.g d;
    private final com.qq.gdt.action.d.b.e e;
    private final com.qq.gdt.action.d.b.a f;

    public c(com.qq.gdt.action.d.b.e eVar, java.util.List<com.qq.gdt.action.d.b.a.b> list, int i, com.qq.gdt.action.d.b.g gVar, com.qq.gdt.action.d.b.a aVar) {
        this.e = eVar;
        this.f86a = list;
        this.b = i;
        this.d = gVar;
        this.f = aVar;
    }

    @Override // com.qq.gdt.action.d.b.a.b.a
    public com.qq.gdt.action.d.b.g a() {
        return this.d;
    }

    @Override // com.qq.gdt.action.d.b.a.b.a
    public com.qq.gdt.action.d.b.i a(com.qq.gdt.action.d.b.g gVar) throws java.io.IOException {
        if (this.b >= this.f86a.size()) {
            throw new java.lang.AssertionError();
        }
        this.c++;
        com.qq.gdt.action.d.b.a.c cVar = new com.qq.gdt.action.d.b.a.c(this.e, this.f86a, this.b + 1, gVar, this.f);
        com.qq.gdt.action.d.b.a.b bVar = this.f86a.get(this.b);
        com.qq.gdt.action.d.b.i iVarA = bVar.a(cVar);
        if (iVarA == null) {
            throw new java.lang.NullPointerException("interceptor " + bVar + " returned null");
        }
        if (iVarA.e() != null) {
            return iVarA;
        }
        throw new java.lang.IllegalStateException("interceptor " + bVar + " returned a response with no body");
    }

    public com.qq.gdt.action.d.b.e b() {
        return this.e;
    }
}
