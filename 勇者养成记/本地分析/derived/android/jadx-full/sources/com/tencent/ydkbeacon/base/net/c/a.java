package com.tencent.ydkbeacon.base.net.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    public static byte[] a(int i, byte[] bArr) {
        if (i == 1) {
            return d(bArr);
        }
        if (i == 2) {
            return a(bArr);
        }
        return null;
    }

    private static byte[] a(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.zip.GZIPOutputStream gZIPOutputStream = new java.util.zip.GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(bArr);
        gZIPOutputStream.finish();
        gZIPOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }

    public static byte[] b(int i, byte[] bArr) {
        if (i == 1) {
            return c(bArr);
        }
        if (i == 2) {
            return b(bArr);
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x008a  */
    /* JADX WARN: Code duplicated, block: B:39:0x008f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0094  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static byte[] b(byte[] bArr) throws java.lang.Throwable {
        java.io.ByteArrayInputStream byteArrayInputStream;
        java.util.zip.GZIPInputStream gZIPInputStream;
        java.lang.Exception e;
        ?? r5;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        byte[] byteArray = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        try {
            byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
            try {
                gZIPInputStream = new java.util.zip.GZIPInputStream(byteArrayInputStream);
                try {
                    try {
                        byte[] bArr2 = new byte[1024];
                        java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                        while (true) {
                            try {
                                int i = gZIPInputStream.read(bArr2, 0, 1024);
                                if (i == -1) {
                                    byteArray = byteArrayOutputStream2.toByteArray();
                                    byteArrayOutputStream2.flush();
                                    byteArrayOutputStream2.close();
                                    gZIPInputStream.close();
                                    byteArrayInputStream.close();
                                    return byteArray;
                                }
                                byteArrayOutputStream2.write(bArr2, 0, i);
                            } catch (java.lang.Exception e2) {
                                e = e2;
                                r5 = byteArray;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                com.tencent.ydkbeacon.a.b.d dVarB = com.tencent.ydkbeacon.a.b.d.b();
                                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                                sb.append("unzipData length: ");
                                sb.append(bArr.length);
                                dVarB.a("509", sb.toString(), e);
                                com.tencent.ydkbeacon.a.e.c.a(e);
                                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                                sb2.append("unGzip error ");
                                sb2.append(e.toString());
                                com.tencent.ydkbeacon.a.e.c.b(sb2.toString(), new java.lang.Object[0]);
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                if (byteArrayInputStream != null) {
                                    byteArrayInputStream.close();
                                }
                                return r5;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (gZIPInputStream != null) {
                                    gZIPInputStream.close();
                                }
                                if (byteArrayInputStream != null) {
                                    byteArrayInputStream.close();
                                }
                                throw th;
                            }
                        }
                    } catch (java.lang.Exception e3) {
                        e = e3;
                        r5 = 0;
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
            } catch (java.lang.Exception e4) {
                e = e4;
                gZIPInputStream = null;
                r5 = gZIPInputStream;
                com.tencent.ydkbeacon.a.b.d dVarB2 = com.tencent.ydkbeacon.a.b.d.b();
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append("unzipData length: ");
                sb3.append(bArr.length);
                dVarB2.a("509", sb3.toString(), e);
                com.tencent.ydkbeacon.a.e.c.a(e);
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append("unGzip error ");
                sb4.append(e.toString());
                com.tencent.ydkbeacon.a.e.c.b(sb4.toString(), new java.lang.Object[0]);
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (gZIPInputStream != null) {
                    gZIPInputStream.close();
                }
                if (byteArrayInputStream != null) {
                    byteArrayInputStream.close();
                }
                return r5;
            } catch (java.lang.Throwable th3) {
                th = th3;
                gZIPInputStream = null;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            byteArrayInputStream = null;
            gZIPInputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            byteArrayInputStream = null;
            gZIPInputStream = null;
        }
    }

    private static byte[] c(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayInputStream byteArrayInputStream = new java.io.ByteArrayInputStream(bArr);
        java.util.zip.ZipInputStream zipInputStream = new java.util.zip.ZipInputStream(byteArrayInputStream);
        byte[] byteArray = null;
        while (zipInputStream.getNextEntry() != null) {
            byte[] bArr2 = new byte[1024];
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                int i = zipInputStream.read(bArr2, 0, 1024);
                if (i != -1) {
                    byteArrayOutputStream.write(bArr2, 0, i);
                }
            }
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.flush();
            byteArrayOutputStream.close();
        }
        zipInputStream.close();
        byteArrayInputStream.close();
        return byteArray;
    }

    private static byte[] d(byte[] bArr) throws java.io.IOException {
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(byteArrayOutputStream);
        java.util.zip.ZipEntry zipEntry = new java.util.zip.ZipEntry("zip");
        zipEntry.setSize(bArr.length);
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(bArr);
        zipOutputStream.closeEntry();
        zipOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return byteArray;
    }
}
