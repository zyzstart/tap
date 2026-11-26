package com.tencent.yybsdk.apkpatch.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1406a;
    private int b;

    public d() {
        this.f1406a = -1;
        this.b = -1;
    }

    public d(int i, int i2) {
        this.f1406a = -1;
        this.b = -1;
        this.f1406a = i;
        this.b = i2;
    }

    public int a() {
        return this.f1406a;
    }

    public boolean equals(java.lang.Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof com.tencent.yybsdk.apkpatch.d.d)) {
            return false;
        }
        com.tencent.yybsdk.apkpatch.d.d dVar = (com.tencent.yybsdk.apkpatch.d.d) obj;
        return this.f1406a == dVar.f1406a && this.b == dVar.b;
    }

    public int hashCode() {
        return (this.f1406a * 31) + (this.b * 17);
    }

    public java.lang.String toString() {
        return "EventKey [mainEvent=" + this.f1406a + ", subEvent=" + this.b + "]";
    }
}
