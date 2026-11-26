package com.tencent.tmassistantbase.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1012a;
    final /* synthetic */ boolean b;
    final /* synthetic */ long c;
    final /* synthetic */ long d;
    final /* synthetic */ java.util.Map e;
    final /* synthetic */ boolean f;
    final /* synthetic */ com.tencent.tmassistantbase.c.a.a g;

    b(com.tencent.tmassistantbase.c.a.a aVar, java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        this.g = aVar;
        this.f1012a = str;
        this.b = z;
        this.c = j;
        this.d = j2;
        this.e = map;
        this.f = z2;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zOnUserAction;
        try {
            zOnUserAction = com.tencent.beaconselfupdate.event.UserAction.onUserAction(this.f1012a, this.b, this.c, this.d, this.e, this.f);
        } catch (java.lang.Exception e) {
            com.tencent.tmassistantbase.util.TMLog.e("BeaconReportManager", "onUserAction Exception", e);
            zOnUserAction = false;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder("[BeaconReportManager]onUserAction(6)|");
        sb.append("【eventName】:");
        sb.append(this.f1012a);
        sb.append("【isSucceed】：");
        sb.append(this.b);
        sb.append("【result】:");
        sb.append(zOnUserAction);
        java.util.LinkedList<java.util.Map.Entry> linkedList = new java.util.LinkedList(this.e.entrySet());
        java.util.Collections.sort(linkedList, new com.tencent.tmassistantbase.c.a.c(this));
        for (java.util.Map.Entry entry : linkedList) {
            sb.append("\n  【");
            sb.append((java.lang.String) entry.getKey());
            sb.append("】:");
            sb.append((java.lang.String) entry.getValue());
        }
        if (zOnUserAction) {
            sb.append(", report success!");
            com.tencent.tmassistantbase.util.TMLog.d("BeaconReportManager", sb.toString());
        } else {
            sb.append(", report failed!");
            com.tencent.tmassistantbase.util.TMLog.e("BeaconReportManager", sb.toString());
        }
    }
}
