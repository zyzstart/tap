package com.tencent.midas.comm.log.util.compressor;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CachedByteArrayStream extends java.io.OutputStream {
    private final int BUFFER_SIZE;
    private final byte[] _bytes;
    protected byte[] buf;
    protected int count;

    public CachedByteArrayStream() {
        this.BUFFER_SIZE = 512;
        byte[] bArr = new byte[512];
        this._bytes = bArr;
        this.buf = bArr;
    }

    public CachedByteArrayStream(int i) {
        this.BUFFER_SIZE = 512;
        this._bytes = new byte[512];
        if (i < 0) {
            throw new java.lang.IllegalArgumentException("size < 0");
        }
        this.buf = new byte[i];
    }

    private static void checkOffsetAndCount(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new java.lang.ArrayIndexOutOfBoundsException("arrayLength: " + i + ", offset: " + i2 + ", count: " + i3);
        }
    }

    private void expand(int i) {
        int i2 = this.count;
        int i3 = i + i2;
        byte[] bArr = this.buf;
        if (i3 <= bArr.length) {
            return;
        }
        byte[] bArr2 = new byte[i3 * 2];
        java.lang.System.arraycopy(bArr, 0, bArr2, 0, i2);
        this.buf = bArr2;
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        super.close();
    }

    public synchronized void reset() {
        this.buf = this._bytes;
        this.count = 0;
    }

    public int size() {
        return this.count;
    }

    public synchronized byte[] toByteArray() {
        byte[] bArr;
        int i = this.count;
        bArr = new byte[i];
        java.lang.System.arraycopy(this.buf, 0, bArr, 0, i);
        return bArr;
    }

    public java.lang.String toString() {
        return new java.lang.String(this.buf, 0, this.count);
    }

    @java.lang.Deprecated
    public java.lang.String toString(int i) {
        int size = size();
        char[] cArr = new char[size];
        for (int i2 = 0; i2 < size; i2++) {
            cArr[i2] = (char) (((i & 255) << 8) | (this.buf[i2] & 255));
        }
        return new java.lang.String(cArr);
    }

    public java.lang.String toString(java.lang.String str) {
        return new java.lang.String(this.buf, 0, this.count, str);
    }

    @Override // java.io.OutputStream
    public synchronized void write(int i) {
        if (this.count == this.buf.length) {
            expand(1);
        }
        byte[] bArr = this.buf;
        int i2 = this.count;
        this.count = i2 + 1;
        bArr[i2] = (byte) i;
    }

    @Override // java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        checkOffsetAndCount(bArr.length, i, i2);
        if (i2 == 0) {
            return;
        }
        expand(i2);
        java.lang.System.arraycopy(bArr, i, this.buf, this.count, i2);
        this.count += i2;
    }

    public synchronized void writeTo(java.io.OutputStream outputStream) {
        outputStream.write(this.buf, 0, this.count);
    }
}
