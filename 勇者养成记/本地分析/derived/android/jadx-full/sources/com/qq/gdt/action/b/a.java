package com.qq.gdt.action.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends java.lang.Exception {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f71a;

    public a(java.lang.String str, java.lang.Throwable th) {
        super(str, th);
        this.f71a = str;
    }

    @Override // java.lang.Throwable
    public java.lang.String getMessage() {
        return this.f71a;
    }
}
