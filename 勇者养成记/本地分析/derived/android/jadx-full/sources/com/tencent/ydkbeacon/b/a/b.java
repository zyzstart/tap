package com.tencent.ydkbeacon.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.ydkbeacon.b.a.b f1204a;
    private static byte[] b = {33, 94, 120, 74, 111, 43, 35};
    private android.content.SharedPreferences c;
    private android.content.SharedPreferences.Editor d;
    private java.util.concurrent.locks.Lock e = new java.util.concurrent.locks.ReentrantLock();
    private java.lang.Runnable f = new com.tencent.ydkbeacon.b.a.a(this);

    public b() {
        android.content.Context contextC = com.tencent.ydkbeacon.a.c.c.d().c();
        if (contextC != null) {
            this.c = contextC.getSharedPreferences("DENGTA_META", 0);
        }
    }

    public static synchronized com.tencent.ydkbeacon.b.a.b a() {
        if (f1204a == null) {
            f1204a = new com.tencent.ydkbeacon.b.a.b();
        }
        return f1204a;
    }

    private static java.lang.String a(java.lang.String str) {
        byte[] bArrDecode = android.util.Base64.decode(str, 2);
        int length = 0;
        for (int i = 0; i < bArrDecode.length; i++) {
            byte b2 = bArrDecode[i];
            byte[] bArr = b;
            bArrDecode[i] = (byte) (b2 ^ bArr[length]);
            length = (length + 1) % bArr.length;
        }
        return new java.lang.String(bArrDecode, java.nio.charset.Charset.defaultCharset());
    }

    private static java.lang.String b(java.lang.String str) {
        byte[] bytes = str.getBytes(java.nio.charset.Charset.defaultCharset());
        int length = 0;
        for (int i = 0; i < bytes.length; i++) {
            byte b2 = bytes[i];
            byte[] bArr = b;
            bytes[i] = (byte) (b2 ^ bArr[length]);
            length = (length + 1) % bArr.length;
        }
        return android.util.Base64.encodeToString(bytes, 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void b() {
        if (this.e.tryLock()) {
            this.d.commit();
            this.e.unlock();
        }
    }

    public synchronized java.lang.String a(java.lang.String str, java.lang.String str2) {
        return this.c.getString(str, str2);
    }

    public synchronized java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        android.content.SharedPreferences sharedPreferences = this.c;
        java.lang.String string = sharedPreferences.getString(str, "");
        if (string != null && !string.trim().equals("")) {
            sharedPreferences.edit().remove(str).putString(str2, b(string)).commit();
            return string;
        }
        java.lang.String string2 = sharedPreferences.getString(str2, "");
        if (string2 == null || string2.trim().equals("")) {
            return str3;
        }
        return a(string2);
    }
}
