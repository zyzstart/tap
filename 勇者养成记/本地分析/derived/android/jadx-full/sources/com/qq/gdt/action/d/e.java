package com.qq.gdt.action.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends com.qq.gdt.action.d.d<com.qq.gdt.action.d.e> {
    private byte[] d;

    public com.qq.gdt.action.d.e a(byte[] bArr) {
        this.d = bArr;
        return this;
    }

    public com.qq.gdt.action.d.c b() {
        a();
        return new com.qq.gdt.action.d.c(this.c.a(com.qq.gdt.action.d.b.h.a(com.qq.gdt.action.d.b.f.a("application/json; charset=utf-8"), this.d)).a(this.f102a).a());
    }
}
