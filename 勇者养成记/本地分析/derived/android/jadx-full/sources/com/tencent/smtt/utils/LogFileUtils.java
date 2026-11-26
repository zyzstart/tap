package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class LogFileUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.io.OutputStream f955a;

    public static void closeOutputStream(java.io.OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (java.io.IOException e) {
                android.util.Log.e("LOG_FILE", "Couldn't close stream!", e);
            }
        }
    }

    public static byte[] createHeaderText(java.lang.String str, java.lang.String str2) {
        try {
            byte[] bArrEncryptKey = encryptKey(str, str2);
            java.lang.String str3 = java.lang.String.format("%03d", java.lang.Integer.valueOf(bArrEncryptKey.length));
            byte[] bArr = new byte[bArrEncryptKey.length + 3];
            bArr[0] = (byte) str3.charAt(0);
            bArr[1] = (byte) str3.charAt(1);
            bArr[2] = (byte) str3.charAt(2);
            java.lang.System.arraycopy(bArrEncryptKey, 0, bArr, 3, bArrEncryptKey.length);
            return bArr;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static java.lang.String createKey() {
        return java.lang.String.valueOf(java.lang.System.currentTimeMillis());
    }

    public static byte[] encrypt(java.lang.String str, java.lang.String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RC4");
            cipher.init(1, new javax.crypto.spec.SecretKeySpec(str.getBytes("[REDACTED]"), "[REDACTED]"));
            return cipher.update(bytes);
        } catch (java.lang.Throwable th) {
            android.util.Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    public static byte[] encryptKey(java.lang.String str, java.lang.String str2) {
        try {
            byte[] bytes = str2.getBytes("UTF-8");
            javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance("RC4");
            cipher.init(1, new javax.crypto.spec.SecretKeySpec(str.getBytes("[REDACTED]"), "[REDACTED]"));
            return cipher.update(bytes);
        } catch (java.lang.Throwable th) {
            android.util.Log.e("LOG_FILE", "encrypt exception:" + th.getMessage());
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void writeDataToStorage(java.io.File file, java.lang.String str, byte[] bArr, java.lang.String str2, boolean z) {
        java.io.OutputStream outputStream;
        java.io.OutputStream outputStream2;
        byte[] bytes;
        try {
            byte[] bArrEncrypt = encrypt(str, str2);
            if (bArrEncrypt != null) {
                str2 = null;
            } else {
                bArrEncrypt = null;
            }
            try {
                file.getParentFile().mkdirs();
                if (file.isFile() && file.exists() && file.length() > 2097152) {
                    file.delete();
                    file.createNewFile();
                }
                if (f955a == null) {
                    f955a = new java.io.BufferedOutputStream(new java.io.FileOutputStream(file, z));
                }
                if (str2 != null) {
                    outputStream2 = f955a;
                    bytes = str2.getBytes();
                } else {
                    f955a.write(bArr);
                    f955a.write(bArrEncrypt);
                    outputStream2 = f955a;
                    bytes = new byte[]{10, 10};
                }
                outputStream2.write(bytes);
                outputStream = f955a;
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                    } catch (java.lang.Throwable unused) {
                    }
                }
            } catch (java.lang.Throwable unused2) {
                outputStream = f955a;
                if (outputStream != null) {
                }
            }
        } catch (java.lang.Throwable th) {
            throw th;
        }
    }
}
