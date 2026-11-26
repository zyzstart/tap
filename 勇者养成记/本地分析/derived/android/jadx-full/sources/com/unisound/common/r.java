package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class r {
    public static void a(java.lang.String str) {
        int iLastIndexOf;
        if (str != null && (iLastIndexOf = str.lastIndexOf(47)) >= 0) {
            new java.io.File(str.substring(0, iLastIndexOf)).mkdirs();
        }
    }

    public static boolean a() {
        return "mounted".equals(android.os.Environment.getExternalStorageState());
    }

    public static boolean a(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        boolean z = false;
        if (inputStream != null && outputStream != null) {
            byte[] bArr = new byte[1024];
            while (true) {
                try {
                    try {
                        try {
                            int i = inputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            outputStream.write(bArr, 0, i);
                        } catch (java.lang.Throwable th) {
                            try {
                                outputStream.close();
                                inputStream.close();
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                        outputStream.close();
                        inputStream.close();
                    }
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                }
            }
            outputStream.close();
            inputStream.close();
            z = true;
        }
        return z;
    }

    public static boolean a(java.lang.String str, java.lang.String str2, boolean z) {
        java.io.File file = new java.io.File(str);
        java.io.File file2 = new java.io.File(str2);
        if (!file.isFile() || !file2.isFile()) {
            return false;
        }
        try {
            file2.getParentFile().mkdirs();
            return a(new java.io.FileInputStream(file), new java.io.FileOutputStream(file2, false));
        } catch (java.io.FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static java.lang.String b() {
        java.lang.String path = android.os.Environment.getExternalStorageDirectory().getPath();
        if (path == null || path.endsWith(java.io.File.separator)) {
            return path;
        }
        return path + java.io.File.separator;
    }
}
