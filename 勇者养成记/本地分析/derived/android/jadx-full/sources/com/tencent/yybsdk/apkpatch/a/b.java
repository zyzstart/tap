package com.tencent.yybsdk.apkpatch.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends java.io.InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1392a = 0;
    private long b;
    private long c;
    private java.io.RandomAccessFile d;

    public b(java.lang.String str) {
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "r");
        this.d = randomAccessFile;
        this.b = randomAccessFile.length();
    }

    public void a(long j) throws java.io.IOException {
        this.c = j;
        this.f1392a = 0L;
        this.d.seek(j);
    }

    public void b(long j) {
        long length = this.d.length() - this.c;
        if (j > length) {
            j = length;
        }
        this.b = j;
        this.f1392a = 0L;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.d.close();
        super.close();
    }

    @Override // java.io.InputStream
    public int read() {
        return 0;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        long j = this.b - this.f1392a;
        if (j > 0) {
            if (j < i2) {
                i2 = (int) j;
            }
            int i3 = this.d.read(bArr, i, i2);
            if (i3 > 0) {
                this.f1392a += (long) i3;
                return i3;
            }
        }
        return -1;
    }
}
