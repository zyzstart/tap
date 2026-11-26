package com.tencent.ysdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private static final int LENGTH = 16;
    private static java.lang.String sYSDKDBKey = "";
    private static final byte[] DB_KEY = {109, 115, 100, 107, 100, 98, 107, 100, 121, 98, 117, 100, 97, 121, 100, 121};
    private static int VERSION = e();

    static {
        android.util.Log.e("YSDK", "YSDKSo module Version :" + VERSION);
    }

    public static native java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    public static byte[] b(java.lang.String str) {
        android.util.Log.d("YSDK_DOCTOR", "YSDKSo module Version :" + VERSION);
        if (ckIsEmpty(sYSDKDBKey)) {
            try {
                if (ckIsEmpty(str)) {
                    str = "";
                }
                java.lang.String randomStrByLength = getRandomStrByLength(16);
                java.lang.String strValueOf = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
                sYSDKDBKey = b(str, randomStrByLength, strValueOf, getSign(str, randomStrByLength, strValueOf));
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                sYSDKDBKey = new java.lang.String(DB_KEY);
            }
        }
        return sYSDKDBKey.getBytes();
    }

    public static native java.lang.String c(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    public static boolean ckIsEmpty(java.lang.String str) {
        return str == null || str.trim().equals("") || str.trim().equals("null");
    }

    public static native java.lang.String d(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4);

    public static native int e();

    public static java.lang.String e(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        android.util.Log.d("YSDK_DOCTOR", "YSDKSo module Version :" + VERSION);
        try {
            return c(str, str2, str3, str4);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private static java.lang.String getRandomStrByLength(int i) {
        char[] cArr = new char[i];
        java.util.Random random = new java.util.Random();
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) (random.nextInt(9) + 97);
        }
        return new java.lang.String(cArr);
    }

    private static java.lang.String getSign(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.String strA = "";
        try {
            java.lang.String[] strArr = {str, str2, str3};
            java.util.Arrays.sort(strArr);
            java.security.MessageDigest messageDigest = java.security.MessageDigest.getInstance("MD5");
            messageDigest.update((strArr[0] + strArr[1] + strArr[2]).getBytes());
            strA = com.tencent.ysdk.a.b.a(messageDigest.digest());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
        return ckIsEmpty(strA) ? "" : strA;
    }
}
