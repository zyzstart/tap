package com.qq.gdt.action.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f73a;

    public abstract com.qq.gdt.action.c.c a();

    public final void a(int i) {
        this.f73a = i;
    }

    public abstract void a(com.qq.gdt.action.c.c cVar);

    public final int b() {
        return this.f73a;
    }

    protected final com.qq.gdt.action.c.c c() {
        return new com.qq.gdt.action.c.c();
    }
}
