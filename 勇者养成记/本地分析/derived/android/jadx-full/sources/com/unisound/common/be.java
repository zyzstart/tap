package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f1486a = 1;
    public short b = 16000;
    private static char[] d = {'R', 'I', 'F', 'F'};
    private static char[] e = {'W', 'A', 'V', 'E'};
    private static char[] f = {'f', 'm', 't', ' '};
    private static int g = 16;
    private static short h = 1;
    public static short c = 16;
    private static char[] i = {'d', 'a', 't', 'a'};

    private static void a(java.io.ByteArrayOutputStream byteArrayOutputStream, int i2) {
        byteArrayOutputStream.write(new byte[]{(byte) ((i2 << 24) >> 24), (byte) ((i2 << 16) >> 24), (byte) ((i2 << 8) >> 24), (byte) (i2 >> 24)});
    }

    private static void a(java.io.ByteArrayOutputStream byteArrayOutputStream, short s) {
        byteArrayOutputStream.write(new byte[]{(byte) ((s << 8) >> 8), (byte) (s >> 8)});
    }

    private static void a(java.io.ByteArrayOutputStream byteArrayOutputStream, char[] cArr) {
        for (char c2 : cArr) {
            byteArrayOutputStream.write(c2);
        }
    }

    public static byte[] a(int i2, int i3, int i4) {
        byte[] byteArray = null;
        try {
            short s = (short) ((c * i3) / 8);
            java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            a(byteArrayOutputStream, d);
            a(byteArrayOutputStream, i2 + 36);
            a(byteArrayOutputStream, e);
            a(byteArrayOutputStream, f);
            a(byteArrayOutputStream, g);
            a(byteArrayOutputStream, h);
            a(byteArrayOutputStream, (short) i3);
            a(byteArrayOutputStream, i4);
            a(byteArrayOutputStream, i4 * s);
            a(byteArrayOutputStream, s);
            a(byteArrayOutputStream, c);
            a(byteArrayOutputStream, i);
            a(byteArrayOutputStream, i2);
            byteArrayOutputStream.flush();
            byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return byteArray;
        }
    }
}
