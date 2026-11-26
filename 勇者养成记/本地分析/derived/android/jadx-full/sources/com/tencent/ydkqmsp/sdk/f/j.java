package com.tencent.ydkqmsp.sdk.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j extends java.io.FilterOutputStream {
    private static com.tencent.ydkqmsp.sdk.f.j e;
    private static int f;
    private static final java.lang.Object g = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f1348a;
    private com.tencent.ydkqmsp.sdk.f.j b;
    protected byte[] c;
    protected int d;

    private j(java.io.OutputStream outputStream) {
        this(outputStream, 8192);
    }

    private j(java.io.OutputStream outputStream, int i) {
        super(outputStream);
        this.c = com.tencent.ydkqmsp.sdk.f.a.a().a(i);
        this.f1348a = true;
    }

    public static com.tencent.ydkqmsp.sdk.f.j a(java.io.OutputStream outputStream) {
        com.tencent.ydkqmsp.sdk.f.j jVar;
        synchronized (g) {
            if (e != null) {
                jVar = e;
                e = jVar.b;
                jVar.b = null;
                f--;
            } else {
                jVar = null;
            }
        }
        if (jVar == null) {
            return new com.tencent.ydkqmsp.sdk.f.j(outputStream);
        }
        ((java.io.FilterOutputStream) jVar).out = outputStream;
        jVar.f1348a = true;
        return jVar;
    }

    private void a() throws java.io.IOException {
        if (!this.f1348a) {
            throw new java.io.IOException("BufferedOutputStream is closed");
        }
    }

    public static void a(int i, int i2, int i3) {
        if ((i2 | i3) < 0 || i2 > i || i - i2 < i3) {
            throw new java.lang.IndexOutOfBoundsException("length=" + i + "; regionStart=" + i2 + "; regionLength=" + i3);
        }
    }

    private void b() {
        this.d = 0;
        ((java.io.FilterOutputStream) this).out = null;
        this.f1348a = false;
    }

    private void c() throws java.io.IOException {
        int i = this.d;
        if (i > 0) {
            ((java.io.FilterOutputStream) this).out.write(this.c, 0, i);
            this.d = 0;
        }
    }

    private void d() {
        b();
        synchronized (g) {
            if (f < 4) {
                this.b = e;
                e = this;
                f++;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.f1348a) {
            try {
                super.close();
                d();
            } catch (java.lang.Throwable th) {
                d();
                throw th;
            }
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    public synchronized void flush() {
        a();
        c();
        ((java.io.FilterOutputStream) this).out.flush();
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(int i) {
        a();
        int i2 = this.d;
        byte[] bArr = this.c;
        if (i2 == bArr.length) {
            ((java.io.FilterOutputStream) this).out.write(bArr, 0, i2);
            this.d = 0;
        }
        byte[] bArr2 = this.c;
        int i3 = this.d;
        this.d = i3 + 1;
        bArr2[i3] = (byte) i;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) {
        a();
        if (bArr == null) {
            throw new java.lang.NullPointerException("buffer == null");
        }
        byte[] bArr2 = this.c;
        if (i2 >= bArr2.length) {
            c();
            ((java.io.FilterOutputStream) this).out.write(bArr, i, i2);
            return;
        }
        a(bArr.length, i, i2);
        if (i2 > bArr2.length - this.d) {
            c();
        }
        java.lang.System.arraycopy(bArr, i, bArr2, this.d, i2);
        this.d += i2;
    }
}
