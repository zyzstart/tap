package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final com.tencent.open.utils.m f718a = new com.tencent.open.utils.m(101010256);
    private static final com.tencent.open.utils.n b = new com.tencent.open.utils.n(38651);

    private static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        java.util.Properties f719a;
        byte[] b;

        private a() {
            this.f719a = new java.util.Properties();
        }

        void a(byte[] bArr) throws java.io.IOException {
            if (bArr == null) {
                return;
            }
            java.nio.ByteBuffer byteBufferWrap = java.nio.ByteBuffer.wrap(bArr);
            int length = com.tencent.open.utils.b.b.a().length;
            byte[] bArr2 = new byte[length];
            byteBufferWrap.get(bArr2);
            if (!com.tencent.open.utils.b.b.equals(new com.tencent.open.utils.n(bArr2))) {
                throw new java.net.ProtocolException("unknow protocl [" + java.util.Arrays.toString(bArr) + "]");
            }
            if (bArr.length - length <= 2) {
                return;
            }
            byte[] bArr3 = new byte[2];
            byteBufferWrap.get(bArr3);
            int iB = new com.tencent.open.utils.n(bArr3).b();
            if ((bArr.length - length) - 2 < iB) {
                return;
            }
            byte[] bArr4 = new byte[iB];
            byteBufferWrap.get(bArr4);
            this.f719a.load(new java.io.ByteArrayInputStream(bArr4));
            int length2 = ((bArr.length - length) - iB) - 2;
            if (length2 > 0) {
                byte[] bArr5 = new byte[length2];
                this.b = bArr5;
                byteBufferWrap.get(bArr5);
            }
        }

        public java.lang.String toString() {
            return "ApkExternalInfo [p=" + this.f719a + ", otherData=" + java.util.Arrays.toString(this.b) + "]";
        }
    }

    public static java.lang.String a(java.io.File file) {
        return a(file, "channelNo");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static java.lang.String a(java.io.File file, java.lang.String str) throws java.lang.Throwable {
        java.io.RandomAccessFile randomAccessFile = null;
        java.lang.Object[] objArr = 0;
        try {
            java.io.RandomAccessFile randomAccessFile2 = new java.io.RandomAccessFile(file, "r");
            try {
                byte[] bArrA = a(randomAccessFile2);
                if (bArrA == null) {
                    randomAccessFile2.close();
                    return null;
                }
                com.tencent.open.utils.b.a aVar = new com.tencent.open.utils.b.a();
                aVar.a(bArrA);
                java.lang.String property = aVar.f719a.getProperty(str);
                randomAccessFile2.close();
                return property;
            } catch (java.lang.Throwable th) {
                th = th;
                randomAccessFile = randomAccessFile2;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] a(java.io.RandomAccessFile randomAccessFile) throws java.io.IOException {
        boolean z;
        long length = randomAccessFile.length() - 22;
        randomAccessFile.seek(length);
        byte[] bArrA = f718a.a();
        while (true) {
            int i = randomAccessFile.read();
            z = true;
            if (i == -1) {
                z = false;
                break;
            }
            if (i == bArrA[0] && randomAccessFile.read() == bArrA[1] && randomAccessFile.read() == bArrA[2] && randomAccessFile.read() == bArrA[3]) {
                break;
            }
            length--;
            randomAccessFile.seek(length);
        }
        if (!z) {
            throw new java.util.zip.ZipException("archive is not a ZIP archive");
        }
        randomAccessFile.seek(length + 16 + 4);
        byte[] bArr = new byte[2];
        randomAccessFile.readFully(bArr);
        int iB = new com.tencent.open.utils.n(bArr).b();
        if (iB == 0) {
            return null;
        }
        byte[] bArr2 = new byte[iB];
        randomAccessFile.read(bArr2);
        return bArr2;
    }
}
