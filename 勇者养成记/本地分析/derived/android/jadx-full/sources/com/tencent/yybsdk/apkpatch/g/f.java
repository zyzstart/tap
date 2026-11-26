package com.tencent.yybsdk.apkpatch.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1427a;
    public int b;
    public long c;
    public long d;
    public int e;
    public int f;
    public boolean g = false;

    public void a(java.io.DataInputStream dataInputStream) {
        this.f1427a = dataInputStream.readInt();
        this.b = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readInt());
        if (this.g) {
            this.c = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readLong());
            this.d = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readLong());
        } else {
            this.e = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readInt());
            this.f = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readInt());
        }
    }
}
