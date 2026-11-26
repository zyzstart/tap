package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class aa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f1463a = "[REDACTED]";

    public static java.lang.String a() {
        return f1463a;
    }

    public static java.lang.String a(java.io.File file) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            try {
                java.io.FileInputStream fileInputStream = new java.io.FileInputStream(file);
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        try {
                            int i = fileInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            }
                            messageDigest.update(bArr, 0, i);
                        } catch (java.lang.Throwable th) {
                            try {
                                fileInputStream.close();
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                                com.unisound.common.y.a("MD5 checkMD5: Exception on closing MD5 input stream: " + e);
                            }
                            throw th;
                        }
                    } catch (java.io.IOException e2) {
                        throw new java.lang.RuntimeException("Unable to process file for MD5", e2);
                    }
                }
                java.lang.String strReplace = java.lang.String.format("%32s", new java.math.BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
                try {
                    fileInputStream.close();
                } catch (java.io.IOException e3) {
                    e3.printStackTrace();
                    com.unisound.common.y.a("MD5 checkMD5: Exception on closing MD5 input stream: " + e3);
                }
                return strReplace;
            } catch (java.io.FileNotFoundException e4) {
                com.unisound.common.y.a("MD5 checkMD5: Exception while getting FileInputStream: " + e4);
                e4.printStackTrace();
                return null;
            }
        } catch (java.security.NoSuchAlgorithmException e5) {
            com.unisound.common.y.a("MD5 checkMD5: Exception while getting Digest: " + e5);
            e5.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(java.io.InputStream inputStream) {
        try {
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            byte[] bArr = new byte[8192];
            while (true) {
                try {
                    try {
                        int i = inputStream.read(bArr);
                        if (i <= 0) {
                            break;
                        }
                        messageDigest.update(bArr, 0, i);
                    } catch (java.io.IOException e) {
                        throw new java.lang.RuntimeException("Unable to process file for MD5", e);
                    }
                } catch (java.lang.Throwable th) {
                    try {
                        inputStream.close();
                    } catch (java.io.IOException e2) {
                        e2.printStackTrace();
                        com.unisound.common.y.a("MD5 checkMD5: Exception on closing MD5 input stream: " + e2);
                    }
                    throw th;
                }
            }
            java.lang.String strReplace = java.lang.String.format("%32s", new java.math.BigInteger(1, messageDigest.digest()).toString(16)).replace(' ', '0');
            try {
                inputStream.close();
            } catch (java.io.IOException e3) {
                e3.printStackTrace();
                com.unisound.common.y.a("MD5 checkMD5: Exception on closing MD5 input stream: " + e3);
            }
            return strReplace;
        } catch (java.security.NoSuchAlgorithmException e4) {
            com.unisound.common.y.a("MD5 checkMD5: Exception while getting Digest: " + e4);
            e4.printStackTrace();
            return null;
        }
    }

    public static java.lang.String a(java.lang.String str) {
        java.security.MessageDigest messageDigest;
        try {
            messageDigest = java.security.MessageDigest.getInstance("MD5");
        } catch (java.lang.Exception e) {
            java.lang.System.out.println(e.getMessage());
            messageDigest = null;
        }
        byte[] bArrDigest = messageDigest.digest(str.getBytes());
        java.lang.StringBuilder sb = new java.lang.StringBuilder(40);
        for (byte b : bArrDigest) {
            int i = b & 255;
            if ((i >> 4) == 0) {
                sb.append("0");
            }
            sb.append(java.lang.Integer.toHexString(i));
        }
        return sb.toString();
    }

    public static boolean a(java.lang.String str, java.io.File file) {
        java.lang.String str2;
        if (android.text.TextUtils.isEmpty(str) || file == null) {
            str2 = "MD5 checkMD5: md5 String NULL or File NULL";
        } else {
            java.lang.String strA = a(file);
            if (strA != null) {
                com.unisound.common.y.b("MD5 checkMD5: Calculated digest: ", strA);
                com.unisound.common.y.b("MD5 checkMD5: Provided digest: ", str);
                return strA.equalsIgnoreCase(str);
            }
            str2 = "MD5 checkMD5: calculatedDigest NULL";
        }
        com.unisound.common.y.a(str2);
        return false;
    }
}
