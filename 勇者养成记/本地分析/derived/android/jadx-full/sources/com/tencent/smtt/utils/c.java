package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements java.io.Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.io.RandomAccessFile f960a;
    private final java.io.File b;
    private final byte[] c;
    private boolean d;

    public c(java.io.File file) {
        this.c = new byte[8];
        this.b = file;
        this.f960a = new java.io.RandomAccessFile(this.b, "r");
    }

    public c(java.lang.String str) {
        this(new java.io.File(str));
    }

    public final int a(byte[] bArr) {
        return this.f960a.read(bArr);
    }

    public final int a(char[] cArr) throws java.io.IOException {
        byte[] bArr = new byte[cArr.length];
        int i = this.f960a.read(bArr);
        for (int i2 = 0; i2 < cArr.length; i2++) {
            cArr[i2] = (char) bArr[i2];
        }
        return i;
    }

    public final short a() throws java.io.IOException {
        short s = this.f960a.readShort();
        if (!this.d) {
            return s;
        }
        return (short) (((s & 65280) >>> 8) | ((s & 255) << 8));
    }

    public void a(long j) throws java.io.IOException {
        this.f960a.seek(j);
    }

    public void a(boolean z) {
        this.d = z;
    }

    public final int b() throws java.io.IOException {
        int i = this.f960a.readInt();
        if (!this.d) {
            return i;
        }
        return ((i & (-16777216)) >>> 24) | ((i & 255) << 24) | ((65280 & i) << 8) | ((16711680 & i) >>> 8);
    }

    public final long c() throws java.io.IOException {
        if (!this.d) {
            return this.f960a.readLong();
        }
        this.f960a.readFully(this.c, 0, 8);
        byte[] bArr = this.c;
        return (((long) (bArr[1] & 255)) << 8) | (((long) bArr[7]) << 56) | (((long) (bArr[6] & 255)) << 48) | (((long) (bArr[5] & 255)) << 40) | (((long) (bArr[4] & 255)) << 32) | (((long) (bArr[3] & 255)) << 24) | (((long) (bArr[2] & 255)) << 16) | ((long) (bArr[0] & 255));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.f960a.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
