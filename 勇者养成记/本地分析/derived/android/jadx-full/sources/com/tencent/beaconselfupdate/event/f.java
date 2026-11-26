package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.beaconselfupdate.event.h f260a;
    private android.content.Context b;
    private int c = cn.yunzhisheng.asr.a.b;
    private int d = 0;
    private java.lang.Runnable e = new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.event.f.1
        @Override // java.lang.Runnable
        public final void run() {
            try {
                com.tencent.beaconselfupdate.event.f.this.a();
            } catch (java.lang.Throwable th) {
                com.tencent.beaconselfupdate.c.a.a(th);
            }
        }
    };

    public f(android.content.Context context) {
        java.lang.String str;
        java.lang.String str2;
        this.b = context;
        java.util.HashMap map = new java.util.HashMap(2);
        boolean zG = com.tencent.beaconselfupdate.a.a.g(this.b);
        com.tencent.beaconselfupdate.a.e.a(context);
        map.put("A33", com.tencent.beaconselfupdate.a.e.g(context));
        if (zG) {
            str = "A66";
            str2 = "F";
        } else {
            str = "A66";
            str2 = "B";
        }
        map.put(str, str2);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(com.tencent.beaconselfupdate.a.a.h(this.b));
        map.put("A68", sb.toString());
        map.put("A85", com.tencent.beaconselfupdate.a.a.b ? "Y" : "N");
        this.f260a = com.tencent.beaconselfupdate.a.e.a(this.b, "rqd_heartbeat", true, 0L, 0L, map, false);
    }

    private synchronized void a(int i) {
        this.d = i;
    }

    private synchronized int c() {
        return this.d;
    }

    protected final void a() {
        if (com.tencent.beaconselfupdate.a.e.m(this.b)) {
            com.tencent.beaconselfupdate.upload.f fVarF = com.tencent.beaconselfupdate.event.j.d().f();
            if (fVarF != null) {
                java.util.ArrayList arrayList = new java.util.ArrayList(2);
                arrayList.add(this.f260a);
                fVarF.a(new com.tencent.beaconselfupdate.event.i.a(this.b, arrayList));
            }
            a(c() + 1);
            if (c() % 10 == 0) {
                com.tencent.beaconselfupdate.a.b.a().a(108, this.e, 600000L, this.c);
                a(0);
            }
        }
    }

    public final void b() {
        if (com.tencent.beaconselfupdate.a.e.g().equals(com.tencent.beaconselfupdate.a.a.b(this.b, "HEART_DENGTA", ""))) {
            com.tencent.beaconselfupdate.c.a.a("heartbeat has been uploaded today!", new java.lang.Object[0]);
        } else {
            com.tencent.beaconselfupdate.a.b.a().a(108, this.e, 0L, this.c);
        }
    }
}
