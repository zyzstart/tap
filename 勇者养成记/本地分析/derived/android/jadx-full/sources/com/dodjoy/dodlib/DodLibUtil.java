package com.dodjoy.dodlib;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class DodLibUtil {
    public static byte[] LoadStreamAssetFile(android.content.Context context, java.lang.String str) {
        java.io.InputStream inputStreamOpen;
        java.io.BufferedInputStream bufferedInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        try {
            inputStreamOpen = context.getResources().getAssets().open(str);
            while (true) {
                try {
                    int i = bufferedInputStream.read(bArr);
                    if (i == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, i);
                } catch (java.io.IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (java.io.IOException e2) {
            android.util.Log.v("unity", e2.getMessage());
            inputStreamOpen = null;
        }
        bufferedInputStream = new java.io.BufferedInputStream(inputStreamOpen);
        byteArrayOutputStream = new java.io.ByteArrayOutputStream(1024);
        bArr = new byte[1024];
        bufferedInputStream.close();
        inputStreamOpen.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static java.lang.String ReadText(java.io.InputStream inputStream) {
        try {
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            while (true) {
                int i = inputStream.read();
                if (i == -1) {
                    return byteArrayOutputStream.toString();
                }
                byteArrayOutputStream.write(i);
            }
        } catch (java.lang.Exception unused) {
            return "读写失败";
        }
    }
}
