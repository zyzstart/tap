package com.tencent.yybsdk.apkpatch.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends java.io.BufferedInputStream {
    public b(java.io.InputStream inputStream) {
        super(inputStream);
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) {
        int i3;
        i3 = 0;
        while (i2 > 0) {
            int i4 = super.read(bArr, i, i2);
            if (i4 < 0) {
                break;
            }
            i2 -= i4;
            i += i4;
            i3 += i4;
        }
        return i3;
    }

    @Override // java.io.BufferedInputStream, java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) {
        long j2;
        j2 = 0;
        while (j > 0) {
            long jSkip = super.skip(j);
            j -= jSkip;
            j2 += jSkip;
        }
        return j2;
    }
}
