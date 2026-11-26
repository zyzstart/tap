package com.tencent.ydkbeacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.event.EventBean f1248a;
    final /* synthetic */ com.tencent.ydkbeacon.event.b b;

    a(com.tencent.ydkbeacon.event.b bVar, com.tencent.ydkbeacon.event.EventBean eventBean) {
        this.b = bVar;
        this.f1248a = eventBean;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!this.b.d.a(this.f1248a.getEventType())) {
            boolean zA = this.b.d.a(this.f1248a);
            com.tencent.ydkbeacon.a.e.c.a("[EventModule]", 2, "event: %s. insert to DB %s", this.f1248a.getEventCode(), java.lang.Boolean.valueOf(zA));
            if (zA) {
                this.b.b();
                return;
            }
            return;
        }
        com.tencent.ydkbeacon.a.b.d.b().a("602", "type: " + com.tencent.ydkbeacon.event.c.c.a(this.f1248a.getEventType()) + " max db count!");
        com.tencent.ydkbeacon.a.e.c.a("[EventModule]", 2, "event: %s. insert to DB false. reason: DB count max!", this.f1248a.getEventCode());
    }
}
