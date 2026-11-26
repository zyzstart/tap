package com.tencent.ydkbeacon.event.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.Map f1256a = new java.util.concurrent.ConcurrentHashMap(5);
    private static volatile android.os.Handler b;
    private final android.content.Context f;
    private final java.lang.String g;
    private java.lang.String h;
    private android.content.SharedPreferences l;
    private final java.lang.String c = "normal_log_id";
    private final java.lang.String d = "realtime_log_id";
    private final java.lang.String e = "on_date";
    private java.util.concurrent.atomic.AtomicLong i = new java.util.concurrent.atomic.AtomicLong(0);
    private java.util.concurrent.atomic.AtomicLong j = new java.util.concurrent.atomic.AtomicLong(0);
    private final java.util.List k = new java.util.ArrayList();
    private boolean m = false;
    private final java.lang.Runnable n = new com.tencent.ydkbeacon.event.c.d(this);

    private e(android.content.Context context, java.lang.String str) {
        this.f = context;
        this.g = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.content.SharedPreferences a(android.content.Context context) {
        if (this.l == null) {
            this.l = context.getSharedPreferences("b_log_ID_ydkbeacon_" + com.tencent.ydkbeacon.a.c.b.c(context) + "_" + this.g, 0);
        }
        return this.l;
    }

    public static synchronized com.tencent.ydkbeacon.event.c.e a(android.content.Context context, @android.support.annotation.NonNull java.lang.String str) {
        com.tencent.ydkbeacon.event.c.e eVar;
        eVar = (com.tencent.ydkbeacon.event.c.e) f1256a.get(str);
        if (eVar == null) {
            eVar = new com.tencent.ydkbeacon.event.c.e(context, str);
            f1256a.put(str, eVar);
        }
        return eVar;
    }

    private void a() {
        synchronized (com.tencent.ydkbeacon.event.c.e.class) {
            if (b == null) {
                b = com.tencent.ydkbeacon.a.b.a.a().a(113);
            }
        }
    }

    private void b() {
        a();
        this.k.add("rqd_model");
        this.k.add("rqd_appresumed");
        c();
    }

    private void c() {
        android.content.SharedPreferences sharedPreferencesA = a(this.f);
        this.h = sharedPreferencesA.getString("on_date", "");
        this.j.set(sharedPreferencesA.getLong("realtime_log_id", 0L));
        this.i.set(sharedPreferencesA.getLong("normal_log_id", 0L));
        com.tencent.ydkbeacon.a.e.c.a("[LogID " + this.g + "]", " load LogID from sp, date: %s , realtime: %d, normal: %d", this.h, java.lang.Long.valueOf(this.j.get()), java.lang.Long.valueOf(this.i.get()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized java.lang.String a(java.lang.String str, boolean z) {
        if (!this.m) {
            b();
            this.m = true;
        }
        if (this.k.contains(str)) {
            return "";
        }
        java.lang.String strValueOf = java.lang.String.valueOf(z ? this.j.incrementAndGet() : this.i.incrementAndGet());
        com.tencent.ydkbeacon.a.e.c.a("[stat " + this.g + "]", "type: %s, code: %s, logID: %s.", java.lang.Boolean.valueOf(z), str, strValueOf);
        b.post(this.n);
        return strValueOf;
    }
}
