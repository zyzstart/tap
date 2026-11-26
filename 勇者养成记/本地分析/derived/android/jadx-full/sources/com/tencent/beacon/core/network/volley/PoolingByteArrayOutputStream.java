package com.tencent.beacon.core.network.volley;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class PoolingByteArrayOutputStream extends java.io.ByteArrayOutputStream {
    private static final int DEFAULT_SIZE = 256;
    private final com.tencent.beacon.core.network.volley.ByteArrayPool mPool;

    public PoolingByteArrayOutputStream(com.tencent.beacon.core.network.volley.ByteArrayPool byteArrayPool) {
        this(byteArrayPool, 256);
    }

    public PoolingByteArrayOutputStream(com.tencent.beacon.core.network.volley.ByteArrayPool byteArrayPool, int i) {
        this.mPool = byteArrayPool;
        ((java.io.ByteArrayOutputStream) this).buf = byteArrayPool.getBuf(java.lang.Math.max(i, 256));
    }

    private void expand(int i) {
        int i2 = ((java.io.ByteArrayOutputStream) this).count + i;
        if (i2 <= ((java.io.ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] buf = this.mPool.getBuf(i2 * 2);
        java.lang.System.arraycopy(((java.io.ByteArrayOutputStream) this).buf, 0, buf, 0, ((java.io.ByteArrayOutputStream) this).count);
        this.mPool.returnBuf(((java.io.ByteArrayOutputStream) this).buf);
        ((java.io.ByteArrayOutputStream) this).buf = buf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        this.mPool.returnBuf(((java.io.ByteArrayOutputStream) this).buf);
        ((java.io.ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    protected void finalize() {
        this.mPool.returnBuf(((java.io.ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        expand(1);
        super.write(i);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        expand(i2);
        super.write(bArr, i, i2);
    }
}
