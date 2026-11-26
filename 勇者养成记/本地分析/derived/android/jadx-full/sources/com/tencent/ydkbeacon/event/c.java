package com.tencent.ydkbeacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.event.d f1253a;

    c(com.tencent.ydkbeacon.event.d dVar) {
        this.f1253a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        java.util.Iterator it = this.f1253a.d.iterator();
        while (it.hasNext()) {
            sb.append((java.lang.Long) it.next());
            sb.append(",");
        }
        com.tencent.ydkbeacon.a.e.c.a(this.f1253a.e, 4, "delete: %s", java.lang.Boolean.valueOf(this.f1253a.c.a(this.f1253a.b, sb.substring(0, sb.lastIndexOf(",")))));
        this.f1253a.f1257a.a(this.f1253a.d);
    }
}
