package com.tencent.ydkbeacon.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.a.b.d f1181a;
    private static final java.util.Map b = new java.util.LinkedHashMap();
    private boolean c = false;
    private boolean d = false;

    private d() {
    }

    public static synchronized com.tencent.ydkbeacon.a.b.d b() {
        if (f1181a == null) {
            synchronized (com.tencent.ydkbeacon.a.b.d.class) {
                if (f1181a == null) {
                    f1181a = new com.tencent.ydkbeacon.a.b.d();
                }
            }
        }
        return f1181a;
    }

    private synchronized void d() {
        if (this.c) {
            return;
        }
        b.put("attaid", "00400014144");
        b.put("[REDACTED]", "[REDACTED]");
        b.put("error_code", "");
        b.put("platform", "Android");
        b.put("uin", com.tencent.ydkbeacon.a.c.f.p().e());
        b.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MODEL, android.os.Build.BOARD + " " + android.os.Build.MODEL);
        b.put("os", com.tencent.ydkbeacon.a.c.f.p().z());
        b.put("error_msg", "");
        b.put("error_stack_full", "");
        b.put("app_version", com.tencent.ydkbeacon.a.c.b.a());
        b.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_SDK_VERSION, com.tencent.ydkbeacon.a.c.c.d().i());
        b.put("product_id", com.tencent.ydkbeacon.a.c.c.d().f());
        b.put("_dc", "");
        this.c = true;
    }

    public synchronized void a(java.lang.String str, java.lang.String str2) {
        a(str, str2, null);
    }

    public synchronized void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a(str, str2, th, new com.tencent.ydkbeacon.a.b.b(this));
    }

    public synchronized void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th, com.tencent.ydkbeacon.base.net.a.b bVar) {
        if (c()) {
            if (!this.c) {
                d();
            }
            if (android.text.TextUtils.isEmpty(str)) {
                com.tencent.ydkbeacon.a.e.c.b("[atta] errorCode isn't valid value!", new java.lang.Object[0]);
            } else {
                com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.a.b.c(this, str, str2, th, bVar));
            }
        }
    }

    public void a(boolean z) {
        this.d = z;
    }

    public boolean c() {
        if (this.d) {
            return true;
        }
        if (com.tencent.ydkbeacon.a.e.c.a()) {
            return false;
        }
        java.lang.String strE = com.tencent.ydkbeacon.a.c.f.p().e();
        return !android.text.TextUtils.isEmpty(strE) && ((double) java.lang.Math.abs(strE.hashCode() % 10000)) < 100.0d;
    }
}
