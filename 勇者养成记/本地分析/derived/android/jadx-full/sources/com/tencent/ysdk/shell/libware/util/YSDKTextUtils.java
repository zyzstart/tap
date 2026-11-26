package com.tencent.ysdk.shell.libware.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class YSDKTextUtils {
    public static boolean ckIsEmpty(java.lang.String str) {
        return str == null || str.trim().equals("") || str.trim().equals("null");
    }

    public static boolean ckNonEmpty(java.lang.String... strArr) {
        for (java.lang.String str : strArr) {
            if (ckIsEmpty(str)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] getBytesUTF8(java.lang.String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (java.io.UnsupportedEncodingException unused) {
            return null;
        }
    }

    public static java.lang.String getRandomString(int i) {
        char[] cArr = new char[i];
        java.util.Random random = new java.util.Random();
        for (int i2 = 0; i2 < i; i2++) {
            cArr[i2] = (char) (random.nextInt(9) + 97);
        }
        return new java.lang.String(cArr);
    }

    public static java.lang.String replaceBlank(java.lang.String str) {
        if (str == null) {
            return null;
        }
        return java.util.regex.Pattern.compile("\\s*|\t|\r|\n").matcher(str).replaceAll("");
    }

    public static java.lang.String[] split(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null || str2.length() == 0) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        int length = 0;
        while (true) {
            int iIndexOf = str.indexOf(str2, length);
            if (iIndexOf < 0) {
                break;
            }
            arrayList.add(str.substring(length, iIndexOf));
            length = str2.length() + iIndexOf;
        }
        arrayList.add(str.substring(length));
        for (int size = arrayList.size() - 1; size >= 0 && ((java.lang.String) arrayList.get(size)).length() == 0; size--) {
            arrayList.remove(size);
        }
        return (java.lang.String[]) arrayList.toArray(new java.lang.String[0]);
    }
}
