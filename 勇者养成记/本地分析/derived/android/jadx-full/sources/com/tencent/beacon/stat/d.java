package com.tencent.beacon.stat;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.Map f217a = new java.util.concurrent.ConcurrentHashMap(5);
    private final android.content.Context e;
    private final java.lang.String f;
    private java.lang.String g;
    private android.content.SharedPreferences k;
    private final java.lang.String b = "normal_log_id";
    private final java.lang.String c = "realtime_log_id";
    private final java.lang.String d = "on_date";
    private java.util.concurrent.atomic.AtomicLong h = new java.util.concurrent.atomic.AtomicLong(0);
    private java.util.concurrent.atomic.AtomicLong i = new java.util.concurrent.atomic.AtomicLong(0);
    private final java.util.List j = new java.util.ArrayList();
    private boolean l = false;
    private final java.lang.Runnable m = new com.tencent.beacon.stat.c(this);

    private d(android.content.Context context, java.lang.String str) {
        this.e = context;
        this.f = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public android.content.SharedPreferences a(android.content.Context context) {
        if (this.k == null) {
            this.k = context.getSharedPreferences("b_log_ID_" + com.tencent.beacon.core.info.a.c(context) + "_" + this.f, 0);
        }
        return this.k;
    }

    public static synchronized com.tencent.beacon.stat.d a(android.content.Context context, java.lang.String str) {
        com.tencent.beacon.stat.d dVar;
        dVar = (com.tencent.beacon.stat.d) f217a.get(str);
        if (dVar == null) {
            dVar = new com.tencent.beacon.stat.d(context, str);
            f217a.put(str, dVar);
        }
        return dVar;
    }

    private synchronized void a(java.lang.String str, long j, long j2) {
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.stat.b(this, str, j, j2));
    }

    private synchronized void b() {
        java.lang.String strA = com.tencent.beacon.core.e.b.a(com.tencent.beacon.core.e.b.b(com.tencent.beacon.core.info.b.b(this.e).j()));
        if (!strA.equals(this.g)) {
            java.lang.String str = this.g;
            this.g = strA;
            a(str, this.i.get(), this.h.get());
        }
    }

    private void c() {
        this.j.add("rqd_model");
        this.j.add("rqd_appresumed");
        d();
        b();
        a();
    }

    private void d() {
        if (com.tencent.beacon.core.info.b.b(this.e).k()) {
            com.tencent.beacon.core.e.d.a("[LogID " + this.f + "]  All logID of the new SDK version will be reset!", new java.lang.Object[0]);
            e();
            return;
        }
        android.content.SharedPreferences sharedPreferencesA = a(this.e);
        this.g = sharedPreferencesA.getString("on_date", "");
        this.i.set(sharedPreferencesA.getLong("realtime_log_id", 0L));
        this.h.set(sharedPreferencesA.getLong("normal_log_id", 0L));
        com.tencent.beacon.core.e.d.a("[LogID " + this.f + "]", " load LogID from sp, date: %s , realtime: %d, normal: %d", this.g, java.lang.Long.valueOf(this.i.get()), java.lang.Long.valueOf(this.h.get()));
    }

    private void e() {
        this.i.set(0L);
        this.h.set(0L);
        this.g = com.tencent.beacon.core.e.b.a(com.tencent.beacon.core.e.b.b(com.tencent.beacon.core.info.b.b(this.e).j()));
        a();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized java.lang.String a(java.lang.String str, boolean z) {
        if (!this.l) {
            c();
            this.l = true;
        }
        if (this.j.contains(str)) {
            return "";
        }
        java.lang.String strValueOf = java.lang.String.valueOf(z ? this.i.incrementAndGet() : this.h.incrementAndGet());
        com.tencent.beacon.core.e.d.a("[stat " + this.f + "]type: %s, code: %s, logID: %s.", java.lang.Boolean.valueOf(z), str, strValueOf);
        return strValueOf;
    }

    public synchronized void a() {
        com.tencent.beacon.core.a.d.a(false);
        com.tencent.beacon.core.a.d.a().a(113, this.m, 0L, 500L);
        com.tencent.beacon.core.a.d.a(true);
    }
}
