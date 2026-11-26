package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beacon.qimei.e f211a;
    private android.content.Context c;
    private com.tencent.beacon.qimei.IAsyncQimeiListener d;
    private int b = 1;
    private java.lang.Runnable e = new com.tencent.beacon.qimei.b(this);
    private final com.tencent.beacon.core.a.g.a f = new com.tencent.beacon.qimei.c(this);

    public e(android.content.Context context) {
        this.c = context;
        com.tencent.beacon.core.d.k.a(context).a(103, new com.tencent.beacon.qimei.d(this));
    }

    public static synchronized com.tencent.beacon.qimei.e a(android.content.Context context) {
        if (f211a == null) {
            f211a = new com.tencent.beacon.qimei.e(context);
        }
        return f211a;
    }

    private void a(java.lang.String str) {
        com.tencent.beacon.core.e.d.a("[qimei] update qimei: " + str, new java.lang.Object[0]);
        com.tencent.beacon.qimei.Qimei qimeiB = com.tencent.beacon.qimei.a.a(this.c).b();
        java.util.Map mapA = com.tencent.beacon.qimei.i.a(str);
        if (mapA != null) {
            com.tencent.beacon.qimei.Qimei qimei = new com.tencent.beacon.qimei.Qimei((java.lang.String) mapA.get("A3"), (java.lang.String) mapA.get("A153"), mapA);
            com.tencent.beacon.qimei.i.b(this.c, qimei.toString());
            qimeiB = qimei;
        }
        com.tencent.beacon.qimei.a.a(this.c).a(qimeiB);
        com.tencent.beacon.qimei.i.a(this.c, str);
        com.tencent.beacon.qimei.IAsyncQimeiListener iAsyncQimeiListener = this.d;
        if (iAsyncQimeiListener != null) {
            try {
                iAsyncQimeiListener.onQimeiDispatch(qimeiB);
                this.d = null;
            } catch (java.lang.Exception e) {
                com.tencent.beacon.core.e.d.a(e);
            }
        }
    }

    protected void a(com.tencent.beacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        this.d = iAsyncQimeiListener;
    }

    public void a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        try {
            com.tencent.beacon.core.wup.a aVar = new com.tencent.beacon.core.wup.a(bArr);
            com.tencent.beacon.qimei.QimeiPackage qimeiPackage = new com.tencent.beacon.qimei.QimeiPackage();
            qimeiPackage.readFrom(aVar);
            if (!com.tencent.beacon.core.e.j.b(qimeiPackage.qimei)) {
                com.tencent.beacon.core.e.d.d("[qimei] Async return qimei: %s", qimeiPackage.qimei);
                a(qimeiPackage.qimei);
                com.tencent.beacon.core.a.g.a().a(this.f);
                com.tencent.beacon.qimei.i.a(this.c);
            }
            com.tencent.beacon.core.e.d.h("[qimei] update Qimei:%s  imei:%s  imsi:%s  aid:%s  mac:%s by server.", qimeiPackage.qimei, qimeiPackage.imei, qimeiPackage.imsi, qimeiPackage.androidId, qimeiPackage.mac);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }

    public boolean a() {
        java.lang.String strA = com.tencent.beacon.core.strategy.g.b(this.c).a("qimeiZeroPeak");
        return strA != null && "y".equalsIgnoreCase(strA) && java.util.Calendar.getInstance().get(11) == 0;
    }

    public boolean b() {
        java.lang.String strA = com.tencent.beacon.core.strategy.g.b(this.c).a("updateQimei");
        if ("n".equalsIgnoreCase(strA)) {
            return false;
        }
        if ("y".equalsIgnoreCase(strA)) {
        }
        return true;
    }

    public void c() {
        d();
        if (com.tencent.beacon.core.e.j.b(com.tencent.beacon.qimei.a.a(this.c).c())) {
            com.tencent.beacon.core.a.g.a().a(this.c, this.f);
        }
    }

    public void d() {
        try {
            boolean zB = b();
            if (zB && !com.tencent.beacon.qimei.i.b(this.c)) {
                zB = false;
            }
            if ("".equals(com.tencent.beacon.qimei.a.a(this.c).a()) || com.tencent.beacon.core.info.a.k(this.c)) {
                zB = true;
            }
            com.tencent.beacon.core.e.d.a("[module] QIMEI query module > %S", java.lang.Boolean.valueOf(zB));
            if (zB && !a() && com.tencent.beacon.core.d.k.a(this.c).f()) {
                com.tencent.beacon.core.a.d.a().a(112, this.e, 0L, 60000L);
            }
        } catch (java.lang.Exception unused) {
            com.tencent.beacon.core.e.d.b("[qimei] save GEN_QIMEI flag failed! ", new java.lang.Object[0]);
        }
    }
}
