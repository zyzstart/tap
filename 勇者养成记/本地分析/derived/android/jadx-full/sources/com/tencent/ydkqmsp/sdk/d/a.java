package com.tencent.ydkqmsp.sdk.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    /* JADX WARN: Code duplicated, block: B:58:0x0074 A[ExcSplitCross -> B:47:0x0074, PHI: r2
  0x0074: PHI (r2v8 java.io.FileInputStream) = 
  (r2v5 java.io.FileInputStream)
  (r2v6 java.io.FileInputStream)
  (r2v7 java.io.FileInputStream)
  (r2v9 java.io.FileInputStream)
  (r2v10 java.io.FileInputStream)
 binds: [B:30:0x0057, B:45:0x006f, B:35:0x005f, B:46:0x0071, B:40:0x0067] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static java.lang.String a(java.lang.String str) {
        java.io.FileInputStream fileInputStream;
        int i;
        try {
            try {
                java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
                fileInputStream = new java.io.FileInputStream(str);
                try {
                    long length = new java.io.File(str).length();
                    if (length > 10002432) {
                        length = 10002432;
                    }
                    byte[] bArr = new byte[4096];
                    while (length > 0 && (i = fileInputStream.read(bArr)) != -1) {
                        if (i > length) {
                            i = (int) length;
                        }
                        length -= (long) i;
                        messageDigest.update(bArr, 0, i);
                    }
                    fileInputStream.close();
                    java.lang.String strA = com.tencent.ydkqmsp.sdk.f.e.a(messageDigest.digest());
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Exception unused) {
                    }
                    return strA;
                } catch (java.io.FileNotFoundException e) {
                    e = e;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (java.lang.Exception unused2) {
                            return null;
                        }
                    }
                    return null;
                } catch (java.io.IOException e2) {
                    e = e2;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (java.security.NoSuchAlgorithmException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (java.lang.Throwable th) {
                    th = th;
                    th.printStackTrace();
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                }
            } catch (java.lang.Throwable th2) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (java.lang.Exception unused3) {
                    }
                }
                throw th2;
            }
        } catch (java.io.FileNotFoundException e4) {
            e = e4;
            fileInputStream = null;
        } catch (java.io.IOException e5) {
            e = e5;
            fileInputStream = null;
        } catch (java.security.NoSuchAlgorithmException e6) {
            e = e6;
            fileInputStream = null;
        } catch (java.lang.Throwable th3) {
            th = th3;
            fileInputStream = null;
        }
    }
}
