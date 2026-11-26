package com.tencent.yybsdk.apkpatch.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements java.io.Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f1426a;
    public short b;
    public int c;
    public int d;
    public int e;
    public int f;
    public byte[] g;

    public void a(java.nio.MappedByteBuffer mappedByteBuffer) {
        mappedByteBuffer.getInt();
        this.f1426a = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        this.b = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        mappedByteBuffer.getInt();
        this.c = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getInt());
        this.d = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getInt());
        this.e = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getInt());
        int iA = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        short sA = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        short sA2 = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getShort());
        mappedByteBuffer.getLong();
        this.f = com.tencent.yybsdk.apkpatch.g.d.a(mappedByteBuffer.getInt());
        byte[] bArr = new byte[iA];
        this.g = bArr;
        mappedByteBuffer.get(bArr, 0, iA);
        mappedByteBuffer.position(mappedByteBuffer.position() + sA + sA2);
    }
}
