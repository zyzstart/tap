package com.tencent.beacon.core.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.d.i f154a;
    private static final java.util.Map b = new java.util.LinkedHashMap();
    private final android.content.Context c;
    private boolean d = false;
    private boolean e = false;
    private boolean f = com.tencent.beacon.upload.UploadStrategy.defaultUploadErrorEnable;

    private i(android.content.Context context) {
        this.c = context;
    }

    public static synchronized com.tencent.beacon.core.d.i a() {
        return f154a;
    }

    public static synchronized com.tencent.beacon.core.d.i a(android.content.Context context) {
        if (f154a == null) {
            f154a = new com.tencent.beacon.core.d.i(context);
        }
        return f154a;
    }

    private synchronized void b() {
        if (this.d) {
            return;
        }
        if (com.tencent.beacon.core.e.j.b((java.lang.String) b.get("uin"))) {
            com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(this.c);
            java.lang.String strA = fVarA.a("QIMEI_DENGTA", "");
            if (strA.isEmpty()) {
                strA = fVarA.a("qimei_v2", "");
            }
            b.put("uin", strA);
        } else {
            this.d = true;
        }
    }

    private synchronized void c() {
        if (this.e) {
            return;
        }
        b.put("attaid", "00400014144");
        b.put("[REDACTED]", "[REDACTED]");
        b.put("error_code", "");
        b.put("platform", "Android");
        b.put("uin", com.tencent.beacon.core.a.f.a(this.c).a("QIMEI_DENGTA", ""));
        b.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MODEL, com.tencent.beacon.core.info.e.d(this.c).d() + " " + com.tencent.beacon.core.info.e.d(this.c).h());
        b.put("os", com.tencent.beacon.core.info.e.d(this.c).n());
        b.put("error_msg", "");
        b.put("error_stack", "");
        b.put("app_version", com.tencent.beacon.core.info.a.a(this.c));
        java.util.Map map = b;
        com.tencent.beacon.core.info.b.b(this.c);
        map.put(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_SDK_VERSION, com.tencent.beacon.core.info.b.i());
        b.put("product_id", com.tencent.beacon.core.info.b.b(this.c).a());
        b.put("_dc", "");
        this.e = true;
    }

    public synchronized void a(int i) {
        if (com.tencent.beacon.core.e.d.a()) {
            this.f = false;
            return;
        }
        if (com.tencent.beacon.core.e.b.a(1, i)) {
            this.f = true;
        }
        if (this.f) {
            c();
        }
    }

    public synchronized void a(java.lang.String str, java.lang.String str2) {
        a(str, str2, null);
    }

    public synchronized void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th) {
        a(str, str2, th, new com.tencent.beacon.core.d.h(this));
    }

    public synchronized void a(java.lang.String str, java.lang.String str2, java.lang.Throwable th, com.tencent.beacon.core.b.b bVar) {
        if (this.f) {
            if (!this.e) {
                c();
            }
            if (com.tencent.beacon.core.e.j.b(str)) {
                com.tencent.beacon.core.e.d.b("[upload error] errorCode isn't valid value!", new java.lang.Object[0]);
                return;
            }
            b();
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(b);
            linkedHashMap.put("error_code", str);
            linkedHashMap.put("error_msg", str2);
            linkedHashMap.put("error_stack", com.tencent.beacon.core.e.b.a(th));
            linkedHashMap.put("_dc", java.lang.String.valueOf(java.lang.Math.random()));
            com.tencent.beacon.core.b.f.a().a("https://h.trace.qq.com/kv", linkedHashMap, bVar);
            com.tencent.beacon.core.e.d.d("[upload error] upload a new error, errorCode: %s, message: %s, stack: %s", str, str2, com.tencent.beacon.core.e.b.a(th));
        }
    }
}
