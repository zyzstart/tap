package com.tencent.tmassistantsdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements com.tencent.tmassistantbase.network.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.tmassistantsdk.internal.c.e f1073a;

    f(com.tencent.tmassistantsdk.internal.c.e eVar) {
        this.f1073a = eVar;
    }

    @Override // com.tencent.tmassistantbase.network.d
    public void a() {
        com.tencent.tmassistantbase.util.TMLog.i("LogReportManager", "onNetworkChanged,netState:" + com.tencent.tmassistantbase.util.k.p());
        for (java.lang.Class cls : com.tencent.tmassistantsdk.internal.c.e.b) {
            try {
                if (cls.equals(com.tencent.tmassistantsdk.internal.c.b.class)) {
                    com.tencent.tmassistantsdk.internal.c.b.h().d();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        new java.lang.Thread(new com.tencent.tmassistantsdk.internal.c.g(this)).start();
    }
}
