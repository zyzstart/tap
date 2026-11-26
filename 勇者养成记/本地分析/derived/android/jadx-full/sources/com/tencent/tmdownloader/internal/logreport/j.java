package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class j implements com.tencent.tmassistantbase.network.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmdownloader.internal.logreport.i f1141a;

    j(com.tencent.tmdownloader.internal.logreport.i iVar) {
        this.f1141a = iVar;
    }

    @Override // com.tencent.tmassistantbase.network.d
    public void a() {
        com.tencent.tmassistantbase.util.TMLog.i("LogReportManager", "netState:" + com.tencent.tmdownloader.internal.downloadservice.c.a());
        for (java.lang.Class cls : com.tencent.tmdownloader.internal.logreport.i.b) {
            try {
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.c.class)) {
                    com.tencent.tmdownloader.internal.logreport.c.h().d();
                }
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.g.class)) {
                    com.tencent.tmdownloader.internal.logreport.g.h().d();
                }
                if (cls.equals(com.tencent.tmdownloader.internal.logreport.d.class)) {
                    com.tencent.tmdownloader.internal.logreport.d.h().d();
                }
            } catch (java.lang.Exception e) {
                com.tencent.tmassistantbase.util.TMLog.w("LogReportManager", "exception:", e);
                e.printStackTrace();
            }
        }
        if (com.tencent.tmdownloader.internal.downloadservice.c.b() && com.tencent.tmdownloader.internal.downloadservice.c.a().equalsIgnoreCase("wifi")) {
            this.f1141a.c();
        }
    }
}
