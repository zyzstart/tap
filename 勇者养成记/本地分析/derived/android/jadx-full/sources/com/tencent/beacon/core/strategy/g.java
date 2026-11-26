package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.strategy.g f192a;
    private com.tencent.beacon.core.strategy.a b;
    private final java.lang.String c = "sid";
    private java.lang.String d = "";
    private boolean e = true;
    private int f = 8081;
    private java.lang.String g = "";
    private java.lang.String h = "";

    private g(android.content.Context context) {
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.strategy.e(this, context));
    }

    public static com.tencent.beacon.core.strategy.g b(android.content.Context context) {
        if (f192a == null) {
            synchronized (com.tencent.beacon.core.strategy.g.class) {
                if (f192a == null) {
                    f192a = new com.tencent.beacon.core.strategy.g(context);
                }
            }
        }
        return f192a;
    }

    public synchronized java.lang.String a() {
        return this.h;
    }

    public java.lang.String a(int i) {
        com.tencent.beacon.core.strategy.a aVar = this.b;
        boolean zA = (!(aVar != null && aVar.d())) & com.tencent.beacon.core.e.d.a();
        try {
            if (i == 0) {
                return this.b != null ? this.b.c() : com.tencent.beacon.core.c.a.b.a(!this.e, (java.lang.String) null);
            }
            return this.b != null ? this.b.a(i) : com.tencent.beacon.core.c.a.b.a(!e(), zA, null);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.i("[strategy] get strategy error:%s", th.toString());
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }

    public java.lang.String a(java.lang.String str) {
        com.tencent.beacon.core.strategy.a aVar = this.b;
        if (aVar != null) {
            return aVar.a(str);
        }
        return null;
    }

    public synchronized void a(android.content.Context context) {
        java.lang.Object[] objArrA = com.tencent.beacon.core.a.a.c.a(context, "sid");
        if (objArrA != null && objArrA.length == 3) {
            long time = new java.util.Date().getTime() / 1000;
            long jLongValue = 0;
            try {
                jLongValue = ((java.lang.Long) objArrA[2]).longValue();
            } catch (java.lang.Exception unused) {
            }
            if (jLongValue > time) {
                b((java.lang.String) objArrA[1]);
            }
        }
        a(context, com.tencent.beacon.core.e.b.a(context));
    }

    synchronized void a(android.content.Context context, java.lang.String str) {
        this.h = str;
        byte[] bArrA = com.tencent.beacon.core.c.a.c.a(context, str);
        if (bArrA != null) {
            this.g = android.util.Base64.encodeToString(bArrA, 2);
        }
    }

    public synchronized void a(android.content.Context context, java.lang.String str, java.lang.String str2) {
        com.tencent.beacon.core.e.d.a("[net] -> update local sid|time[%s|%s].", str, str2);
        this.d = str;
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.strategy.f(this, str, str2, context));
    }

    public void a(com.tencent.beacon.core.strategy.a aVar) {
        this.b = aVar;
    }

    public void a(boolean z) {
        com.tencent.beacon.core.strategy.a aVar = this.b;
        if (aVar != null) {
            aVar.a(z);
        }
        this.e = z;
    }

    public synchronized java.lang.String b() {
        return this.d;
    }

    public synchronized void b(java.lang.String str) {
        this.d = str;
    }

    public synchronized java.lang.String c() {
        return this.g;
    }

    public int d() {
        com.tencent.beacon.core.strategy.a aVar = this.b;
        return aVar == null ? this.f : aVar.b();
    }

    public boolean e() {
        com.tencent.beacon.core.strategy.a aVar = this.b;
        return aVar == null ? this.e : aVar.a();
    }
}
