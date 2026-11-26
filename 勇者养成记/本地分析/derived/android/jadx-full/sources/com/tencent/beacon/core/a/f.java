package com.tencent.beacon.core.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beacon.core.a.f f135a;
    private static byte[] b = {33, 94, 120, 74, 111, 43, 35};
    private android.content.SharedPreferences c;
    private android.content.SharedPreferences.Editor d;
    private java.util.concurrent.locks.Lock e = new java.util.concurrent.locks.ReentrantLock();
    private java.lang.Runnable f = new com.tencent.beacon.core.a.e(this);

    public f(android.content.Context context) {
        if (context != null) {
            this.c = context.getSharedPreferences("DENGTA_META", 0);
        }
    }

    public static synchronized com.tencent.beacon.core.a.f a(android.content.Context context) {
        if (f135a == null) {
            f135a = new com.tencent.beacon.core.a.f(context);
        }
        return f135a;
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
    public synchronized void d() {
        if (this.e.tryLock()) {
            this.d.commit();
            this.e.unlock();
        }
    }

    public synchronized int a(java.lang.String str, int i) {
        return this.c.getInt(str, i);
    }

    public synchronized long a(java.lang.String str, long j) {
        return this.c.getLong(str, j);
    }

    public synchronized com.tencent.beacon.core.a.f a(java.lang.String str, java.lang.Object obj) {
        android.content.SharedPreferences.Editor editor;
        if (this.c != null && (editor = this.d) != null) {
            if (obj instanceof java.lang.String) {
                editor.putString(str, (java.lang.String) obj);
            } else if (obj instanceof java.lang.Boolean) {
                editor.putBoolean(str, ((java.lang.Boolean) obj).booleanValue());
            } else if (obj instanceof java.lang.Integer) {
                editor.putInt(str, ((java.lang.Integer) obj).intValue());
            } else if (obj instanceof java.lang.Long) {
                editor.putLong(str, ((java.lang.Long) obj).longValue());
            }
            return this;
        }
        com.tencent.beacon.core.e.d.b("[sp] create failed or edit() has not called.", new java.lang.Object[0]);
        return this;
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

    public synchronized void a() {
        if (this.c != null && this.d != null) {
            if (android.os.Looper.myLooper() == android.os.Looper.getMainLooper()) {
                com.tencent.beacon.core.a.d.a().a(this.f);
            } else {
                d();
            }
        }
    }

    public synchronized com.tencent.beacon.core.a.f b() {
        android.content.SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null && this.d == null) {
            this.d = sharedPreferences.edit();
        }
        return this;
    }

    public synchronized com.tencent.beacon.core.a.f b(java.lang.String str, java.lang.String str2) {
        if (this.c != null && this.d != null) {
            this.d.putString(str, b(str2));
            return this;
        }
        com.tencent.beacon.core.e.d.b("[sp] create failed or edit() has not called.", new java.lang.Object[0]);
        return this;
    }

    public synchronized android.content.SharedPreferences c() {
        return this.c;
    }
}
