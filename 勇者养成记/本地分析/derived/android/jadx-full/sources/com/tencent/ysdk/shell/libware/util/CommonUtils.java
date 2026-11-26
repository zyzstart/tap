package com.tencent.ysdk.shell.libware.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CommonUtils {
    public static byte[] bitmap2Bytes(android.graphics.Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        bitmap.compress(android.graphics.Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static java.util.Vector<com.tencent.ysdk.framework.common.KVPair> bundleToVector(android.os.Bundle bundle) {
        java.util.Vector<com.tencent.ysdk.framework.common.KVPair> vector = new java.util.Vector<>();
        if (bundle != null) {
            for (java.lang.String str : bundle.keySet()) {
                com.tencent.ysdk.framework.common.KVPair kVPair = new com.tencent.ysdk.framework.common.KVPair();
                kVPair.key = str;
                java.lang.Object obj = bundle.get(str);
                if (obj != null) {
                    kVPair.value = obj.toString();
                    vector.add(kVPair);
                }
            }
        }
        return vector;
    }

    public static java.lang.String getCommonNotifyMsg(java.lang.String str) {
        return java.lang.String.format("调用%1$s方法之前需要先调用YSDKApi.init方法进行初始化", str);
    }

    public static boolean isToday(long j) {
        if (j <= 0) {
            return false;
        }
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.setTime(new java.util.Date(j));
        java.util.Calendar calendar2 = java.util.Calendar.getInstance();
        calendar2.setTime(new java.util.Date(java.lang.System.currentTimeMillis()));
        return calendar.get(1) == calendar2.get(1) && calendar.get(6) == calendar2.get(6);
    }

    public static int parseInt(java.lang.String str, int i) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return i;
        }
        try {
            return java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    public static long parseLong(java.lang.String str, long j) {
        if (com.tencent.ysdk.shell.libware.util.YSDKTextUtils.ckIsEmpty(str)) {
            return j;
        }
        try {
            return java.lang.Long.parseLong(str);
        } catch (java.lang.Exception unused) {
            return j;
        }
    }
}
