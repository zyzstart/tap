package com.tencent.yybsdk.apkpatch.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f1428a;
    public short b;
    public short c;
    public short d;
    public int e;
    public int f;
    public short g;
    public byte[] h;
    public long i = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public void a(java.nio.MappedByteBuffer mappedByteBuffer) throws java.io.IOException {
        if (mappedByteBuffer.getInt() != 1347093766) {
            throw new java.io.IOException("signature != EndOfCentralDirRecord.SIGNATURE");
        }
        this.f1428a = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        this.b = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        this.c = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        this.d = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        this.e = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getInt());
        this.f = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getInt());
        int iA = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        this.g = iA;
        byte[] bArr = new byte[iA];
        this.h = bArr;
        if (iA > 0) {
            mappedByteBuffer.get(bArr, 0, iA);
        }
        this.i += (long) (this.g + 22);
    }
}
