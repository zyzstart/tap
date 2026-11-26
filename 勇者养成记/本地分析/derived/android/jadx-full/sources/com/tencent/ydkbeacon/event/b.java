package com.tencent.ydkbeacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements com.tencent.ydkbeacon.event.f, com.tencent.ydkbeacon.a.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f1251a = com.tencent.ysdk.shell.module.icon.impl.floatingviews.iconview.IconViewConstants.HIDE_BUBBLE_TASK_DELAY;
    private long b = 3000;
    private final android.os.Handler c = com.tencent.ydkbeacon.a.b.a.a().a(3000);
    private final com.tencent.ydkbeacon.event.a.a d;
    private final com.tencent.ydkbeacon.event.e e;
    private final com.tencent.ydkbeacon.event.e f;

    public b() {
        com.tencent.ydkbeacon.event.a.a aVar = new com.tencent.ydkbeacon.event.a.a();
        this.d = aVar;
        this.e = new com.tencent.ydkbeacon.event.e(2000, aVar, true);
        this.f = new com.tencent.ydkbeacon.event.e(1000, this.d, false);
        com.tencent.ydkbeacon.a.a.b.a().a(2, this);
    }

    @Override // com.tencent.ydkbeacon.event.f
    public com.tencent.ydkbeacon.event.open.EventResult a(@android.support.annotation.Nullable java.lang.String str, @android.support.annotation.NonNull com.tencent.ydkbeacon.event.EventBean eventBean) {
        boolean zA = a(new com.tencent.ydkbeacon.event.a(this, eventBean));
        com.tencent.ydkbeacon.a.e.c.a("[REDACTED]", 1, "[REDACTED]", eventBean.getEventCode(), eventBean.getAppKey(), java.lang.Boolean.valueOf(zA));
        if (!zA) {
            return com.tencent.ydkbeacon.event.open.EventResult.a.a(103);
        }
        if (android.text.TextUtils.isEmpty(str)) {
            str = "-1";
        }
        return com.tencent.ydkbeacon.event.open.EventResult.a.a(java.lang.Long.parseLong(str));
    }

    @Override // com.tencent.ydkbeacon.event.f
    public void a() {
        com.tencent.ydkbeacon.a.b.a.a().a(2000, 0L, this.f1251a, this.e);
        com.tencent.ydkbeacon.a.b.a.a().a(1000, 0L, this.b, this.f);
    }

    @Override // com.tencent.ydkbeacon.event.f
    public void a(boolean z) {
        if (z) {
            this.f.run();
            this.e.run();
        } else {
            com.tencent.ydkbeacon.a.b.a.a().a(this.f);
            com.tencent.ydkbeacon.a.b.a.a().a(this.e);
        }
    }

    @Override // com.tencent.ydkbeacon.event.f
    public boolean a(java.lang.Runnable runnable) {
        return this.c.post(runnable);
    }

    @Override // com.tencent.ydkbeacon.event.f
    public void b() {
        com.tencent.ydkbeacon.a.b.a.a().b(2000);
        com.tencent.ydkbeacon.a.b.a.a().b(1000);
    }

    @Override // com.tencent.ydkbeacon.event.f
    public void c() {
        com.tencent.ydkbeacon.a.b.a.a().a(2000, false);
        com.tencent.ydkbeacon.a.b.a.a().a(1000, false);
    }

    @Override // com.tencent.ydkbeacon.a.a.d
    public void onEvent(com.tencent.ydkbeacon.a.a.c cVar) {
        long jA;
        int i = cVar.f1177a;
        if (i == 2) {
            java.util.Map map = (java.util.Map) cVar.b.get("d_m");
            if (map != null) {
                this.f1251a = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("realtimePollingTime"), this.f1251a, 500L, 5000L);
                jA = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("normalPollingTime"), this.b, 1000L, 8000L);
                this.b = jA;
            }
        } else if (i == 11) {
            java.lang.Object obj = cVar.b.get("u_c_r_p");
            if (obj != null) {
                long jLongValue = ((java.lang.Long) obj).longValue();
                if (jLongValue <= 500) {
                    jLongValue = 500;
                }
                this.f1251a = jLongValue;
            }
            java.lang.Object obj2 = cVar.b.get("u_c_n_p");
            if (obj2 != null) {
                jA = ((java.lang.Long) obj2).longValue();
                if (jA <= 1000) {
                    jA = 1000;
                }
                this.b = jA;
            }
        }
        com.tencent.ydkbeacon.a.e.c.a("[EventManager]", "pollingTime maybe change, realtime: %s normal: %s", java.lang.Long.valueOf(this.f1251a), java.lang.Long.valueOf(this.b));
    }
}
