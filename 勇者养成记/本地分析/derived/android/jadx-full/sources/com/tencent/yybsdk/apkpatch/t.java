package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1441a;
    private java.lang.String b;
    private java.lang.String c;
    private final java.lang.String d;
    private final java.lang.String e;
    private final java.lang.String f;

    public t(java.lang.String str, java.lang.String str2) {
        this.f1441a = str;
        this.b = str2;
        this.c = str2 + ".merging";
        this.d = str2 + ".oldEntry";
        this.e = str2 + ".newEntry";
        this.f = str2 + ".diffEntry";
    }

    public java.lang.String a() {
        return this.f1441a;
    }

    public java.lang.String b() {
        return this.c;
    }

    public java.lang.String c() {
        return this.d;
    }

    public java.lang.String d() {
        return this.e;
    }
}
