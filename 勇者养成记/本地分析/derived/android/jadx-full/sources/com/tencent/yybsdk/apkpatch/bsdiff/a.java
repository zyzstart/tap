package com.tencent.yybsdk.apkpatch.bsdiff;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f1395a = false;

    public void a() {
        this.f1395a = true;
    }

    public void a(java.lang.String str, java.lang.String str2, java.io.InputStream inputStream, int[] iArr, com.tencent.yybsdk.apkpatch.bsdiff.b bVar, com.tencent.yybsdk.apkpatch.v vVar) throws java.io.IOException {
        int i;
        java.io.InputStream inputStream2 = inputStream;
        int i2 = vVar.j;
        int i3 = vVar.k;
        int i4 = vVar.l;
        int iA = new com.tencent.yybsdk.apkpatch.bsdiff.d(inputStream2).a();
        java.io.RandomAccessFile randomAccessFile = new java.io.RandomAccessFile(str, "r");
        randomAccessFile.seek(i3);
        com.tencent.yybsdk.apkpatch.a.a aVar = new com.tencent.yybsdk.apkpatch.a.a(str2, "rw");
        aVar.seek(i2);
        inputStream2.skip(i4);
        byte[] bArr = new byte[65536];
        byte[] bArr2 = new byte[65536];
        int i5 = 0;
        int i6 = 0;
        boolean z = false;
        while (i2 < iA) {
            try {
                if (this.f1395a) {
                    break;
                }
                com.tencent.yybsdk.apkpatch.bsdiff.c cVar = new com.tencent.yybsdk.apkpatch.bsdiff.c(inputStream2);
                int iA2 = cVar.a();
                int i7 = i5;
                int iB = cVar.b();
                int iC = cVar.c();
                int i8 = i6;
                int i9 = 0;
                while (i9 < iA2) {
                    boolean z2 = z;
                    int i10 = iA2 - i9;
                    if (i10 > 65536) {
                        i10 = 65536;
                    }
                    inputStream2.read(bArr, 0, i10);
                    randomAccessFile.read(bArr2, 0, i10);
                    int i11 = 0;
                    while (i11 < i10) {
                        bArr[i11] = (byte) (bArr[i11] + bArr2[i11]);
                        i11++;
                        bArr2 = bArr2;
                    }
                    aVar.write(bArr, 0, i10);
                    i9 += i10;
                    z = z2;
                    bArr2 = bArr2;
                }
                byte[] bArr3 = bArr2;
                boolean z3 = z;
                int i12 = 0;
                while (i12 < iB) {
                    int i13 = iB - i12;
                    if (i13 > 65536) {
                        i13 = 65536;
                    }
                    inputStream2.read(bArr, 0, i13);
                    aVar.write(bArr, 0, i13);
                    i12 += i13;
                }
                i2 += iA2 + iB;
                int filePointer = ((int) randomAccessFile.getFilePointer()) + iC;
                randomAccessFile.seek(randomAccessFile.getFilePointer() + ((long) iC));
                i4 += iA2 + 24 + iB;
                if (bVar != null && !bVar.a(i2, iA, filePointer, i4)) {
                    try {
                        randomAccessFile.close();
                        aVar.close();
                        return;
                    } catch (java.lang.Exception unused) {
                        return;
                    }
                }
                if (iArr == null || bVar == null) {
                    i5 = i7;
                    i6 = i8;
                    z = z3;
                } else {
                    z = true;
                    int i14 = i7;
                    i5 = i8;
                    while (true) {
                        if (i2 < iArr[i5]) {
                            z = z3;
                            int i15 = i5;
                            i5 = i14;
                            i = i15;
                            break;
                        }
                        i = i5 + 1;
                        if (i == iArr.length) {
                            break;
                        }
                        z3 = true;
                        int i16 = i5;
                        i5 = i;
                        i14 = i16;
                    }
                    if (z) {
                        aVar.a();
                        try {
                            try {
                                bVar.a(i5);
                                i6 = i;
                                z = false;
                            } catch (java.util.concurrent.RejectedExecutionException unused2) {
                                randomAccessFile.close();
                                aVar.close();
                                return;
                            }
                        } catch (java.lang.Exception unused3) {
                            return;
                        }
                    } else {
                        i6 = i;
                    }
                }
                bArr2 = bArr3;
                inputStream2 = inputStream;
            } catch (java.lang.Throwable th) {
                try {
                    randomAccessFile.close();
                    aVar.close();
                } catch (java.lang.Exception unused4) {
                }
                throw th;
            }
        }
        try {
            randomAccessFile.close();
            aVar.close();
        } catch (java.lang.Exception unused5) {
        }
    }
}
