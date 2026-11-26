package com.qq.gdt.action.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.qq.gdt.action.c.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f111a;
    private java.lang.String b;
    private java.lang.String c;

    public a() {
    }

    public a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.f111a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // com.qq.gdt.action.c.a
    public com.qq.gdt.action.c.c a() {
        return c().a(this.f111a).a(this.b).a(this.c);
    }

    @Override // com.qq.gdt.action.c.a
    public void a(com.qq.gdt.action.c.c cVar) {
        this.f111a = cVar.a();
        this.b = cVar.a();
        this.c = cVar.a();
    }

    public java.lang.String d() {
        return this.f111a;
    }

    public java.lang.String e() {
        return this.b;
    }

    public java.lang.String f() {
        return this.c;
    }

    public java.lang.String toString() {
        return "ActionRecord{sessionId='" + this.f111a + "', actionUniqueId='" + this.b + "', actionType='" + this.c + "'}";
    }
}
