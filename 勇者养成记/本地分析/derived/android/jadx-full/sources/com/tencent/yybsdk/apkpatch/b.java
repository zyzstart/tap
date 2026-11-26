package com.tencent.yybsdk.apkpatch;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends java.io.RandomAccessFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.nio.ByteBuffer f1393a;
    private int b;
    private java.nio.channels.FileChannel c;

    public b(java.lang.String str) {
        super(str, "rw");
        this.f1393a = java.nio.ByteBuffer.allocate(8192);
        this.b = 0;
        this.c = getChannel();
    }

    private synchronized void b(java.nio.ByteBuffer byteBuffer) {
        this.b += this.c.write(byteBuffer);
    }

    public synchronized int a() {
        return this.b + this.f1393a.position();
    }

    public synchronized void a(int i) {
        this.c.position(i);
        this.b = i;
    }

    public synchronized void a(com.tencent.yybsdk.apkpatch.g.f fVar) {
        if (this.f1393a.remaining() < 16) {
            b();
        }
        this.f1393a.putInt(fVar.f1427a);
        this.f1393a.putInt(com.tencent.yybsdk.apkpatch.g.d.a(fVar.b));
        this.f1393a.putInt(com.tencent.yybsdk.apkpatch.g.d.a(fVar.e));
        this.f1393a.putInt(com.tencent.yybsdk.apkpatch.g.d.a(fVar.f));
    }

    public synchronized void a(com.tencent.yybsdk.apkpatch.g.h hVar) {
        if (this.f1393a.remaining() < 30) {
            b();
        }
        this.f1393a.putInt(1347093252);
        this.f1393a.putShort(com.tencent.yybsdk.apkpatch.g.d.a(hVar.f1429a));
        this.f1393a.putShort(com.tencent.yybsdk.apkpatch.g.d.a(hVar.b));
        this.f1393a.putShort(com.tencent.yybsdk.apkpatch.g.d.a(hVar.c));
        this.f1393a.putShort(com.tencent.yybsdk.apkpatch.g.d.a(hVar.d));
        this.f1393a.putShort(com.tencent.yybsdk.apkpatch.g.d.a(hVar.e));
        this.f1393a.putInt(com.tencent.yybsdk.apkpatch.g.d.a(hVar.f));
        this.f1393a.putInt(com.tencent.yybsdk.apkpatch.g.d.a(hVar.g));
        this.f1393a.putInt(com.tencent.yybsdk.apkpatch.g.d.a(hVar.h));
        this.f1393a.putShort(com.tencent.yybsdk.apkpatch.g.d.a(hVar.i));
        this.f1393a.putShort(com.tencent.yybsdk.apkpatch.g.d.a(hVar.j));
        if (hVar.i > 0) {
            if (this.f1393a.remaining() < hVar.i) {
                b();
            }
            if (this.f1393a.remaining() < hVar.i) {
                b(java.nio.ByteBuffer.wrap(hVar.k));
            } else {
                this.f1393a.put(hVar.k);
            }
        }
        if (hVar.j > 0) {
            if (this.f1393a.remaining() < hVar.j) {
                b();
            }
            if (this.f1393a.remaining() < hVar.j) {
                b(java.nio.ByteBuffer.wrap(hVar.l));
            } else {
                this.f1393a.put(hVar.l);
            }
        }
    }

    public synchronized void a(java.nio.ByteBuffer byteBuffer) {
        if (this.f1393a.remaining() < byteBuffer.remaining()) {
            b();
        }
        if (this.f1393a.remaining() < byteBuffer.remaining()) {
            b(byteBuffer);
        } else {
            this.f1393a.put(byteBuffer);
        }
    }

    public synchronized void b() {
        if (this.f1393a.position() > 0) {
            this.b += this.f1393a.position();
            this.f1393a.flip();
            this.c.write(this.f1393a);
            this.f1393a.clear();
        }
    }

    @Override // java.io.RandomAccessFile, java.io.DataInput
    public synchronized int skipBytes(int i) {
        b();
        java.nio.channels.FileChannel fileChannel = this.c;
        fileChannel.position(fileChannel.position() + ((long) i));
        return i;
    }
}
