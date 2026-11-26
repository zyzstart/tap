package com.tencent.yybsdk.apkpatch.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h {
    public static java.nio.ByteBuffer m = java.nio.ByteBuffer.allocate(512);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f1429a;
    public short b;
    public short c;
    public short d;
    public short e;
    public int f;
    public int g;
    public int h;
    public short i;
    public short j;
    public byte[] k;
    public byte[] l;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(java.io.DataInputStream dataInputStream) throws java.io.IOException {
        dataInputStream.readInt();
        this.f1429a = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readShort());
        this.b = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readShort());
        this.c = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readShort());
        this.d = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readShort());
        this.e = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readShort());
        this.f = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readInt());
        this.g = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readInt());
        this.h = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readInt());
        this.i = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readShort());
        int iA = com.tencent.yybsdk.apkpatch.g.d.a(dataInputStream.readShort());
        this.j = iA;
        int i = this.i;
        byte[] bArr = new byte[i];
        this.k = bArr;
        this.l = new byte[iA];
        dataInputStream.read(bArr, 0, i);
        dataInputStream.read(this.l, 0, this.j);
    }
}
