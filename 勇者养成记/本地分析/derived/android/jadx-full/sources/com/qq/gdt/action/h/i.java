package com.qq.gdt.action.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {
    public static void a(java.io.InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static void a(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    public static boolean a(java.io.File file, java.io.File file2) {
        if (file == null || file2 == null || !file.exists()) {
            return false;
        }
        if (file.renameTo(file2)) {
            return true;
        }
        return a((java.io.InputStream) null, file2);
    }

    public static boolean a(java.io.InputStream inputStream, java.io.File file) throws java.lang.Throwable {
        if (inputStream == null || file == null) {
            return false;
        }
        java.io.FileOutputStream fileOutputStream = null;
        try {
            try {
                if (file.getParentFile().exists() || file.getParentFile().mkdirs()) {
                    java.io.FileOutputStream fileOutputStream2 = new java.io.FileOutputStream(file);
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i = inputStream.read(bArr);
                            if (i <= 0) {
                                a(inputStream);
                                a(fileOutputStream2);
                                return true;
                            }
                            fileOutputStream2.write(bArr, 0, i);
                        }
                    } catch (java.lang.Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        a(inputStream);
                        a(fileOutputStream);
                        throw th;
                    }
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
        a(inputStream);
        a(fileOutputStream);
        return false;
    }
}
