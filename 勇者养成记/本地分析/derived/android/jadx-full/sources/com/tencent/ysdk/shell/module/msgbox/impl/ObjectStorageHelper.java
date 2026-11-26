package com.tencent.ysdk.shell.module.msgbox.impl;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ObjectStorageHelper {
    private static java.lang.String FILENAME = "OBJECT_STORAGE_SP";

    private ObjectStorageHelper() {
    }

    private static synchronized android.content.SharedPreferences build() {
        return com.tencent.ysdk.shell.framework.YSDKSystem.getInstance().getApplicationContext().getSharedPreferences(FILENAME, 0);
    }

    private static java.lang.String bytesToHexString(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        if (bArr.length == 0) {
            return "";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer(bArr.length);
        for (byte b : bArr) {
            java.lang.String hexString = java.lang.Integer.toHexString(b & 255);
            if (hexString.length() < 2) {
                stringBuffer.append(0);
            }
            stringBuffer.append(hexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static synchronized void delete(java.lang.String str) {
        android.content.SharedPreferences.Editor editorEdit = build().edit();
        editorEdit.remove(str);
        editorEdit.commit();
    }

    private static java.lang.Integer generateHiNum(char c) {
        if (c >= '0' && c <= '9') {
            return java.lang.Integer.valueOf((c - '0') * 16);
        }
        if (c < 'A' || c > 'F') {
            return null;
        }
        return java.lang.Integer.valueOf((c - '7') * 16);
    }

    private static java.lang.Integer generateLowNum(char c) {
        if (c >= '0' && c <= '9') {
            return java.lang.Integer.valueOf(c - '0');
        }
        if (c < 'A' || c > 'F') {
            return null;
        }
        return java.lang.Integer.valueOf(c - '7');
    }

    public static synchronized java.lang.Object read(java.lang.String str) {
        try {
            android.content.SharedPreferences sharedPreferencesBuild = build();
            if (!sharedPreferencesBuild.contains(str)) {
                return null;
            }
            java.lang.String string = sharedPreferencesBuild.getString(str, "");
            if (android.text.TextUtils.isEmpty(string)) {
                return null;
            }
            return new java.io.ObjectInputStream(new java.io.ByteArrayInputStream(stringToBytes(string))).readObject();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public static synchronized void save(java.lang.String str, java.lang.Object obj) {
        try {
            android.content.SharedPreferences.Editor editorEdit = build().edit();
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            new java.io.ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            editorEdit.putString(str, bytesToHexString(byteArrayOutputStream.toByteArray()));
            editorEdit.commit();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    static byte[] stringToBytes(java.lang.String str) {
        java.lang.String strTrim = str.toUpperCase().trim();
        if (strTrim.length() % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[strTrim.length() / 2];
        int i = 0;
        while (i < strTrim.length()) {
            java.lang.Integer numGenerateHiNum = generateHiNum(strTrim.charAt(i));
            if (numGenerateHiNum == null) {
                return null;
            }
            int i2 = i + 1;
            java.lang.Integer numGenerateLowNum = generateLowNum(strTrim.charAt(i2));
            if (numGenerateLowNum == null) {
                return null;
            }
            bArr[i2 / 2] = (byte) (numGenerateHiNum.intValue() + numGenerateLowNum.intValue());
            i = i2 + 1;
        }
        return bArr;
    }
}
