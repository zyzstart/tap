package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.d.g f1243a;
    private com.tencent.ydkbeacon.d.c b;
    private final java.lang.String c = "sid";
    private java.lang.String d = "";
    private boolean e = true;
    private int f = 8081;
    private java.lang.String h = "";
    private java.lang.String i = "";
    private final android.content.Context g = com.tencent.ydkbeacon.a.c.c.d().c();

    private g() {
        com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.d.e(this));
    }

    public static com.tencent.ydkbeacon.d.g b() {
        if (f1243a == null) {
            synchronized (com.tencent.ydkbeacon.d.g.class) {
                if (f1243a == null) {
                    f1243a = new com.tencent.ydkbeacon.d.g();
                }
            }
        }
        return f1243a;
    }

    public synchronized java.lang.String a() {
        return this.i;
    }

    public java.lang.String a(java.lang.String str) {
        com.tencent.ydkbeacon.d.c cVar = this.b;
        if (cVar != null) {
            return cVar.a(str);
        }
        return null;
    }

    public synchronized void a(android.content.Context context) {
        com.tencent.ydkbeacon.a.d.a aVarA = com.tencent.ydkbeacon.a.d.a.a();
        java.lang.String string = aVarA.getString("sid_value", "");
        if (aVarA.getLong("sid_mt", 0L) > new java.util.Date().getTime() / 1000) {
            b(string);
        }
        a(context, com.tencent.ydkbeacon.a.e.b.a());
    }

    synchronized void a(android.content.Context context, java.lang.String str) {
        this.i = str;
        byte[] bArrA = com.tencent.ydkbeacon.base.net.c.c.a(context, str);
        if (bArrA != null) {
            this.h = android.util.Base64.encodeToString(bArrA, 2);
        }
    }

    public void a(com.tencent.ydkbeacon.d.c cVar) {
        this.b = cVar;
    }

    public synchronized void a(java.lang.String str, java.lang.String str2) {
        com.tencent.ydkbeacon.a.e.c.a("[net] -> update local sid|time[%s|%s].", str, str2);
        this.d = str;
        com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.d.f(this, str2, str));
    }

    public synchronized void b(java.lang.String str) {
        this.d = str;
    }

    public synchronized java.lang.String c() {
        return this.d;
    }

    public synchronized java.lang.String d() {
        return this.h;
    }
}
