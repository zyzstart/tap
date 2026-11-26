package com.qq.gdt.action.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f68a;
    private final java.lang.String b;
    private final java.lang.String c;
    private int d;

    public c(int i, java.lang.String str, java.lang.String str2, int i2) {
        this.f68a = i;
        this.b = str;
        this.c = str2;
        this.d = i2;
    }

    public int a() {
        return this.f68a;
    }

    public java.lang.String b() {
        return this.b;
    }

    public java.lang.String c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public java.lang.String toString() {
        return "ActionHistoryInfo{status=" + this.f68a + ", sessionId='" + this.b + "', actionType='" + this.c + "', count=" + this.d + '}';
    }
}
