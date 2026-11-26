package com.tencent.ydkqmsp.sdk.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    private static final byte[] d = {6, 98, -78, 83, 38, 11, 101, -14, 22, 96};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1308a;
    private long b;
    private boolean c;

    /* JADX INFO: renamed from: com.tencent.ydkqmsp.sdk.c.a$a, reason: collision with other inner class name */
    public interface InterfaceC0047a {
        void a();

        void run();
    }

    public a(java.lang.String str, long j) {
        this.f1308a = str;
        this.b = j;
    }

    private boolean a() {
        boolean z = false;
        android.content.SharedPreferences sharedPreferences = com.tencent.ydkqmsp.sdk.app.a.getContext().getSharedPreferences(a(d), 0);
        this.c = true;
        try {
            long j = sharedPreferences.getLong(this.f1308a, 0L);
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            long j2 = jCurrentTimeMillis - j;
            if (j == 0 || j2 >= this.b || j2 <= 0) {
                android.content.SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.putLong(this.f1308a, jCurrentTimeMillis);
                editorEdit.commit();
                return false;
            }
            try {
                this.c = false;
                return true;
            } catch (java.lang.Exception e) {
                e = e;
                z = true;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
        e.printStackTrace();
        return z;
    }

    private void b() {
        if (this.c) {
            try {
                android.content.SharedPreferences.Editor editorEdit = com.tencent.ydkqmsp.sdk.app.a.getContext().getSharedPreferences(a(d), 0).edit();
                editorEdit.remove(this.f1308a);
                editorEdit.commit();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    public java.lang.String a(byte[] bArr) {
        return com.tencent.ydkqmsp.sdk.f.k.a(bArr);
    }

    public void a(com.tencent.ydkqmsp.sdk.c.a.InterfaceC0047a interfaceC0047a) {
        if (interfaceC0047a != null) {
            if (a()) {
                interfaceC0047a.a();
            } else {
                interfaceC0047a.run();
            }
            b();
        }
    }
}
