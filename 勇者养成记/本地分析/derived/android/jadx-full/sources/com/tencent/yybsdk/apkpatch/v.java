package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1443a;
    public java.lang.String b;
    public java.lang.String c;
    public short d;
    public volatile int e;
    public long f;
    public int g = 0;
    public long h = 0;
    public long i = 0;
    public int j = 0;
    public int k = 0;
    public int l = 0;
    public int m = 0;
    public int n = 0;

    public v() {
    }

    public v(java.lang.String str, java.lang.String str2, java.lang.String str3, short s) {
        this.f1443a = str;
        this.b = str2;
        this.c = str3;
        this.d = s;
    }

    public java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("ApkPatchTaskInfo {");
        sb.append("\n oldApkPath: ");
        sb.append(this.f1443a);
        sb.append("\n patchPath: ");
        sb.append(this.b);
        sb.append("\n newApkPath: ");
        sb.append(this.c);
        sb.append("\n alorithm: ");
        sb.append((int) this.d);
        sb.append("\n status: ");
        sb.append(this.e);
        sb.append("\n createTime: ");
        sb.append(this.f);
        sb.append("\n successEntryCount: ");
        sb.append(this.h);
        sb.append("\n successFilePosition: ");
        sb.append(this.i);
        if (this.d == 64) {
            sb.append("\n process: ");
            sb.append(this.g);
            sb.append("\n bspatchNewPointer: ");
            sb.append(this.j);
            sb.append("\n bspatchOldPointer: ");
            sb.append(this.k);
            sb.append("\n bspatchReadedBytes: ");
            sb.append(this.l);
            sb.append("\n successInflateCount: ");
            sb.append(this.m);
            sb.append("\n successDeflateCount: ");
            sb.append(this.n);
        }
        sb.append("\n}");
        return sb.toString();
    }
}
