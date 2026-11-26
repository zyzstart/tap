package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class w {
    /* JADX WARN: Code duplicated, block: B:39:0x0045 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static byte[] a(byte[] bArr) throws java.lang.Throwable {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        byte[] byteArray = null;
        try {
            try {
                try {
                    gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
                    try {
                        gZIPOutputStream.write(bArr);
                        gZIPOutputStream.finish();
                        byteArray = byteArrayOutputStream.toByteArray();
                        gZIPOutputStream.close();
                        byteArrayOutputStream.close();
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.qq.gdt.action.h.l.c(e.getMessage());
                        if (gZIPOutputStream != null) {
                            gZIPOutputStream.close();
                        }
                        byteArrayOutputStream.close();
                    }
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (gZIPOutputStream != null) {
                        try {
                            gZIPOutputStream.close();
                        } catch (java.lang.Exception e2) {
                            com.qq.gdt.action.h.l.c(e2.getMessage());
                            throw th;
                        }
                    }
                    byteArrayOutputStream.close();
                    throw th;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                gZIPOutputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                gZIPOutputStream = null;
                if (gZIPOutputStream != null) {
                    gZIPOutputStream.close();
                }
                byteArrayOutputStream.close();
                throw th;
            }
        } catch (java.lang.Exception e4) {
            com.qq.gdt.action.h.l.c(e4.getMessage());
        }
        return byteArray;
    }
}
