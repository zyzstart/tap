package com.tencent.yybsdk.apkpatch.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends java.io.RandomAccessFile {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1391a;
    private boolean b;
    private boolean c;
    private long d;
    private long e;
    private long f;
    private byte[] g;
    private long h;
    private boolean i;
    private long j;

    public a(java.lang.String str, java.lang.String str2) {
        this(str, str2, 0);
    }

    public a(java.lang.String str, java.lang.String str2, int i) {
        super(str, str2);
        this.f1391a = str;
        a(i);
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0020  */
    /* JADX WARN: Code duplicated, block: B:9:0x0013  */
    private int a(byte[] bArr, int i, int i2) throws java.io.IOException {
        long j;
        long j2 = this.d;
        long j3 = this.f;
        if (j2 >= j3) {
            if (this.i) {
                j = this.h;
                if (j3 < j) {
                    this.f = j;
                } else {
                    seek(this.d);
                    if (this.d == this.f) {
                        j = this.h;
                        this.f = j;
                    }
                }
            } else {
                seek(this.d);
                if (this.d == this.f) {
                    j = this.h;
                    this.f = j;
                }
            }
        }
        int iMin = java.lang.Math.min(i2, (int) (this.f - this.d));
        java.lang.System.arraycopy(bArr, i, this.g, (int) (this.d - this.e), iMin);
        this.d += (long) iMin;
        return iMin;
    }

    private void a(int i) {
        this.b = false;
        this.f = 0L;
        this.d = 0L;
        this.e = 0L;
        this.g = i > 65536 ? new byte[i] : new byte[65536];
        this.h = android.support.v4.media.session.PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
        this.i = false;
        this.j = 0L;
    }

    private void b() throws java.io.IOException {
        if (this.b) {
            long j = this.j;
            long j2 = this.e;
            if (j != j2) {
                super.seek(j2);
            }
            super.write(this.g, 0, (int) (this.d - this.e));
            this.j = this.d;
            this.b = false;
        }
    }

    private int c() throws java.io.IOException {
        int length = this.g.length;
        int i = 0;
        while (length > 0) {
            int i2 = super.read(this.g, i, length);
            if (i2 < 0) {
                break;
            }
            i += i2;
            length -= i2;
        }
        if (i < 0) {
            boolean z = i < this.g.length;
            this.i = z;
            if (z) {
                byte[] bArr = this.g;
                java.util.Arrays.fill(bArr, i, bArr.length, (byte) -1);
            }
        }
        this.j += (long) i;
        return i;
    }

    public void a() throws java.io.IOException {
        b();
    }

    @Override // java.io.RandomAccessFile, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        a();
        this.g = null;
        super.close();
    }

    @Override // java.io.RandomAccessFile
    public long getFilePointer() {
        return this.d;
    }

    @Override // java.io.RandomAccessFile
    public long length() {
        return java.lang.Math.max(this.d, super.length());
    }

    @Override // java.io.RandomAccessFile
    public int read() throws java.io.IOException {
        long j = this.d;
        if (j >= this.f) {
            if (this.i) {
                return -1;
            }
            seek(j);
            if (this.d == this.f) {
                return -1;
            }
        }
        byte[] bArr = this.g;
        long j2 = this.d;
        byte b = bArr[(int) (j2 - this.e)];
        this.d = j2 + 1;
        return b & 255;
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile
    public int read(byte[] bArr, int i, int i2) throws java.io.IOException {
        long j = this.d;
        if (j >= this.f) {
            if (this.i) {
                return -1;
            }
            seek(j);
            if (this.d == this.f) {
                return -1;
            }
        }
        int iMin = java.lang.Math.min(i2, (int) (this.f - this.d));
        java.lang.System.arraycopy(this.g, (int) (this.d - this.e), bArr, i, iMin);
        this.d += (long) iMin;
        return (iMin >= i2 || this.i) ? iMin : iMin + read(bArr, i + iMin, i2 - iMin);
    }

    @Override // java.io.RandomAccessFile
    public void seek(long j) throws java.io.IOException {
        if (j >= this.f || j < this.e) {
            b();
            long j2 = (-65536) & j;
            this.e = j2;
            this.h = ((long) this.g.length) + j2;
            if (this.j != j2) {
                super.seek(j2);
                this.j = this.e;
            }
            this.f = this.e + ((long) c());
        } else if (j < this.d) {
            b();
        }
        this.d = j;
    }

    /* JADX WARN: Code duplicated, block: B:11:0x0022 A[PHI: r2
  0x0022: PHI (r2v2 long) = (r2v1 long), (r2v0 long) binds: [B:10:0x0020, B:7:0x0012] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(int i) throws java.io.IOException {
        long j = this.d;
        long j2 = this.f;
        if (j >= j2) {
            if (!this.i || j2 >= this.h) {
                seek(this.d);
                long j3 = this.d;
                j2 = this.f;
                if (j3 == j2) {
                    this.f = j2 + 1;
                }
            } else {
                this.f = j2 + 1;
            }
        }
        byte[] bArr = this.g;
        long j4 = this.d;
        bArr[(int) (j4 - this.e)] = (byte) i;
        this.d = j4 + 1;
        this.b = true;
        this.c = true;
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr) throws java.io.IOException {
        write(bArr, 0, bArr.length);
    }

    @Override // java.io.RandomAccessFile, java.io.DataOutput
    public void write(byte[] bArr, int i, int i2) throws java.io.IOException {
        while (i2 > 0) {
            int iA = a(bArr, i, i2);
            i += iA;
            i2 -= iA;
            this.b = true;
            this.c = true;
        }
    }
}
