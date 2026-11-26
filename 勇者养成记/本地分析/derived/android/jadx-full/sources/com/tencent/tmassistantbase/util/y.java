package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class y {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] a(byte[] bArr) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.Deflater deflater = new java.util.zip.Deflater();
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream(bArr.length);
            try {
                deflater.setLevel(9);
                deflater.setInput(bArr);
                deflater.finish();
                byte[] bArr2 = new byte[1024];
                while (!deflater.finished()) {
                    byteArrayOutputStream.write(bArr2, 0, deflater.deflate(bArr2));
                }
                deflater.end();
                try {
                    byteArrayOutputStream.close();
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
                return byteArrayOutputStream.toByteArray();
            } catch (java.lang.Throwable th) {
                th = th;
                deflater.end();
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
            byteArrayOutputStream = null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x0044 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static byte[] b(byte[] bArr) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.util.zip.Inflater inflater = new java.util.zip.Inflater();
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream(bArr.length);
            try {
                try {
                    byte[] bArr2 = new byte[1024];
                    inflater.setInput(bArr);
                    while (!inflater.finished()) {
                        byteArrayOutputStream.write(bArr2, 0, inflater.inflate(bArr2));
                    }
                    inflater.end();
                } catch (java.util.zip.DataFormatException e) {
                    e = e;
                    e.printStackTrace();
                    inflater.end();
                    if (byteArrayOutputStream != null) {
                    }
                    return byteArrayOutputStream.toByteArray();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                inflater.end();
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (java.io.IOException unused) {
                    }
                }
                throw th;
            }
        } catch (java.util.zip.DataFormatException e2) {
            e = e2;
            byteArrayOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            inflater.end();
            if (byteArrayOutputStream2 != null) {
                byteArrayOutputStream2.close();
            }
            throw th;
        }
        try {
            byteArrayOutputStream.close();
        } catch (java.io.IOException unused2) {
        }
        return byteArrayOutputStream.toByteArray();
    }
}
