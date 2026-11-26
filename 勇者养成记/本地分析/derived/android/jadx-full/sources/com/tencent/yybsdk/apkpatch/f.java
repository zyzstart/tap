package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.yybsdk.apkpatch.g.h f1414a;
    com.tencent.yybsdk.apkpatch.g.f b;
    public byte c;
    public int d;
    public int e;

    public int a() {
        int i;
        int i2;
        com.tencent.yybsdk.apkpatch.g.h hVar = this.f1414a;
        if ((hVar.b & 8) == 8) {
            i = hVar.i + 30 + hVar.j + 16 + 0;
            if (this.c == 1) {
                i2 = this.b.e;
                i += i2;
            }
        } else {
            i = hVar.i + 30 + hVar.j + 0;
            if (this.c == 1) {
                i2 = hVar.g;
                i += i2;
            }
        }
        if (this.c == 2) {
            i += 8;
        }
        return this.c == 3 ? i + 1 : i;
    }
}
