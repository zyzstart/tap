package com.tencent.ysdk.framework.dynamic.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MD5 {
    public static final java.lang.String TAG = "YSDKMD5";
    public static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static java.lang.String bytesToHexString(byte[] bArr) {
        if (bArr == null || bArr.length != 16) {
            return "";
        }
        char[] cArr = new char[32];
        int i = 0;
        for (int i2 = 0; i2 < 16; i2++) {
            byte b = bArr[i2];
            int i3 = i + 1;
            char[] cArr2 = hexDigits;
            cArr[i] = cArr2[(b >>> 4) & 15];
            i = i3 + 1;
            cArr[i3] = cArr2[b & 15];
        }
        return new java.lang.String(cArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0031, code lost:
    
        if (r1 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0033, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r1 != null) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String getFileMD5(java.io.File r6) throws java.lang.Throwable {
        /*
            java.lang.String r0 = ""
            if (r6 == 0) goto L4f
            boolean r1 = r6.exists()
            if (r1 == 0) goto L4f
            long r1 = r6.length()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 <= 0) goto L4f
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L2f java.lang.OutOfMemoryError -> L31 java.io.FileNotFoundException -> L39
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2f java.lang.OutOfMemoryError -> L31 java.io.FileNotFoundException -> L39
            r3.<init>(r6)     // Catch: java.lang.Throwable -> L2f java.lang.OutOfMemoryError -> L31 java.io.FileNotFoundException -> L39
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L2f java.lang.OutOfMemoryError -> L31 java.io.FileNotFoundException -> L39
            java.lang.String r0 = getInputStreamMd5(r2)     // Catch: java.lang.Throwable -> L27 java.lang.OutOfMemoryError -> L2a java.io.FileNotFoundException -> L2c
            r2.close()     // Catch: java.io.IOException -> L37
            goto L4f
        L27:
            r6 = move-exception
            r1 = r2
            goto L44
        L2a:
            r1 = r2
            goto L31
        L2c:
            r6 = move-exception
            r1 = r2
            goto L3a
        L2f:
            r6 = move-exception
            goto L44
        L31:
            if (r1 == 0) goto L4f
        L33:
            r1.close()     // Catch: java.io.IOException -> L37
            goto L4f
        L37:
            r6 = move-exception
            goto L40
        L39:
            r6 = move-exception
        L3a:
            r6.printStackTrace()     // Catch: java.lang.Throwable -> L2f
            if (r1 == 0) goto L4f
            goto L33
        L40:
            r6.printStackTrace()
            goto L4f
        L44:
            if (r1 == 0) goto L4e
            r1.close()     // Catch: java.io.IOException -> L4a
            goto L4e
        L4a:
            r0 = move-exception
            r0.printStackTrace()
        L4e:
            throw r6
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.ysdk.framework.dynamic.utils.MD5.getFileMD5(java.io.File):java.lang.String");
    }

    public static java.lang.String getInputStreamMd5(java.io.InputStream inputStream) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[4196];
            int i = 0;
            while (true) {
                int i2 = inputStream.read(bArr, 0, 4196);
                if (i2 == -1) {
                    break;
                }
                if (i2 > 0) {
                    messageDigest.update(bArr, 0, i2);
                    i += i2;
                }
            }
            return i == 0 ? "" : bytesToHexString(messageDigest.digest());
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        } catch (java.security.NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        }
    }
}
