package com.tencent.yybsdk.apkpatch.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends java.io.InputStream {
    private java.lang.String h;
    private final java.lang.Object e = new java.lang.Object();
    private java.nio.channels.FileChannel f = null;
    private java.io.FileInputStream g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f1394a = 0;
    public long b = 0;
    public com.tencent.yybsdk.apkpatch.d.h c = null;
    public long d = 0;

    public a(java.lang.String str) {
        this.h = null;
        if (android.text.TextUtils.isEmpty(str)) {
            throw new java.security.InvalidParameterException("patchPath is null.");
        }
        this.h = str;
    }

    private boolean c() {
        try {
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(new java.io.File(this.h));
            this.g = fileInputStream;
            this.f = fileInputStream.getChannel();
            this.b = 0L;
            return true;
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    private void d() {
        synchronized (this.e) {
            try {
                this.e.wait();
            } catch (java.lang.InterruptedException e) {
                e.printStackTrace();
                java.lang.Thread.currentThread().interrupt();
            }
            if (this.b == Long.MAX_VALUE) {
                throw new java.nio.channels.ClosedChannelException();
            }
            if (this.f == null) {
                if (this.b <= 0 || this.b >= Long.MAX_VALUE) {
                    throw new java.nio.channels.ClosedChannelException();
                }
                throw new java.io.FileNotFoundException("filename:" + this.h);
            }
        }
    }

    public void a() {
        synchronized (this.e) {
            this.e.notifyAll();
        }
    }

    public void a(long j, long j2) {
        com.tencent.yybsdk.apkpatch.d.h hVar;
        if (j <= 0 || j2 <= 0) {
            return;
        }
        if (this.f1394a == 0 && c()) {
            this.f1394a = j2;
            com.tencent.yybsdk.apkpatch.d.h hVar2 = this.c;
            if (hVar2 != null) {
                hVar2.u = java.lang.System.currentTimeMillis();
            }
            this.d = j;
        }
        this.b = j;
        synchronized (this.e) {
            this.e.notifyAll();
        }
        if (j != j2 || (hVar = this.c) == null) {
            return;
        }
        hVar.v = java.lang.System.currentTimeMillis();
        com.tencent.yybsdk.apkpatch.d.h hVar3 = this.c;
        hVar3.x = 0;
        hVar3.w = j - this.d;
    }

    @Override // java.io.InputStream
    public int available() {
        java.nio.channels.FileChannel fileChannel = this.f;
        if (fileChannel == null) {
            return 0;
        }
        return (int) java.lang.Math.min(this.f1394a - fileChannel.position(), 2147483647L);
    }

    public java.lang.String b() {
        return this.h;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        synchronized (this.e) {
            if (this.f != null) {
                this.f.close();
            }
            if (this.g != null) {
                this.g.close();
            }
            this.b = Long.MAX_VALUE;
            this.e.notifyAll();
        }
        super.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public synchronized int read() {
        int i;
        long j = this.b;
        if (j == 0) {
            d();
        } else if (j == Long.MAX_VALUE) {
            throw new java.nio.channels.ClosedChannelException();
        }
        if (this.f.position() >= this.f1394a) {
            i = -1;
        } else {
            while (this.b <= this.f.position()) {
                d();
            }
            byte[] bArr = new byte[1];
            this.f.read(java.nio.ByteBuffer.wrap(bArr));
            i = bArr[0] & 255;
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        if ((i | i2) >= 0) {
            if (i <= bArr.length && bArr.length - i >= i2) {
                long j = this.b;
                if (j == 0) {
                    d();
                } else if (j == Long.MAX_VALUE) {
                    throw new java.nio.channels.ClosedChannelException();
                }
                if (this.f.position() >= this.f1394a) {
                    return -1;
                }
                java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr, i, i2);
                int iMin = (int) java.lang.Math.min(i2, this.f1394a - this.f.position());
                while (iMin > this.b - this.f.position()) {
                    d();
                }
                return this.f.read(byteBufferWrap);
            }
        }
        throw new java.lang.IndexOutOfBoundsException("length=" + bArr.length + "; regionStart=" + i + "; regionLength=" + i2);
    }

    @Override // java.io.InputStream
    public void reset() throws java.io.IOException {
        throw new java.io.IOException("mark/reset not supported");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.io.InputStream
    public synchronized long skip(long j) {
        if (j <= 0) {
            return 0L;
        }
        long j2 = this.b;
        if (j2 == 0) {
            d();
        } else if (j2 == Long.MAX_VALUE) {
            throw new java.nio.channels.ClosedChannelException();
        }
        long jMin = java.lang.Math.min(this.f1394a - this.f.position(), j);
        while (jMin > this.b - this.f.position()) {
            d();
        }
        this.f.position(this.f.position() + jMin);
        return jMin;
    }
}
