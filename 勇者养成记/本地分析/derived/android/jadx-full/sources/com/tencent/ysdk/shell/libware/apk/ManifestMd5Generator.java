package com.tencent.ysdk.shell.libware.apk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ManifestMd5Generator {
    public static java.lang.String getMd5(java.lang.String str) throws java.lang.Throwable {
        java.util.zip.ZipFile zipFile;
        java.lang.String inputStreamMd5 = "";
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            zipFile = new java.util.zip.ZipFile(str);
            try {
                if (new java.io.File(str).exists()) {
                    java.util.zip.ZipEntry entry = zipFile.getEntry("META-INF/MANIFEST.MF");
                    if (entry == null) {
                        entry = zipFile.getEntry("META-INF\\MANIFEST.MF");
                    }
                    if (entry != null) {
                        java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(zipFile.getInputStream(entry));
                        try {
                            inputStreamMd5 = com.tencent.ysdk.shell.libware.encrypt.MD5.getInputStreamMd5(bufferedInputStream2);
                            bufferedInputStream = bufferedInputStream2;
                        } catch (java.io.IOException unused) {
                            bufferedInputStream = bufferedInputStream2;
                            com.tencent.ysdk.libware.file.Closer.closeStream(bufferedInputStream);
                            if (zipFile != null) {
                            }
                            return inputStreamMd5;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            bufferedInputStream = bufferedInputStream2;
                            com.tencent.ysdk.libware.file.Closer.closeStream(bufferedInputStream);
                            if (zipFile != null) {
                                try {
                                    zipFile.close();
                                } catch (java.io.IOException unused2) {
                                }
                            }
                            throw th;
                        }
                    }
                }
                com.tencent.ysdk.libware.file.Closer.closeStream(bufferedInputStream);
            } catch (java.io.IOException unused3) {
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException unused4) {
            zipFile = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            zipFile = null;
        }
        try {
            zipFile.close();
        } catch (java.io.IOException unused5) {
        }
        return inputStreamMd5;
    }
}
