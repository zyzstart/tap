package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1442a;
    public final java.lang.String b;
    public final java.lang.String c;
    public final com.tencent.yybsdk.apkpatch.b.a d;
    public com.tencent.yybsdk.apkpatch.d.g e;
    public final short f;

    public u(java.lang.String str, java.lang.String str2, com.tencent.yybsdk.apkpatch.b.a aVar, java.lang.String str3, short s, com.tencent.yybsdk.apkpatch.d.g gVar) {
        this.f1442a = str;
        this.b = str2;
        this.d = aVar;
        this.c = str3;
        this.e = gVar;
        this.f = s;
    }

    public java.lang.String a() {
        return this.d.b();
    }

    public java.lang.String toString() {
        return "ApkPatchTask{, ticket=" + this.f1442a + ", oldApkPath=" + this.b + ", patchPath=" + this.d.b() + ", newApkPath=" + this.c + ", patchAlgorithm=" + ((int) this.f) + "}";
    }
}
