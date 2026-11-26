package com.tencent.ydkbeacon.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class c implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1180a;
    final /* synthetic */ java.lang.String b;
    final /* synthetic */ java.lang.Throwable c;
    final /* synthetic */ com.tencent.ydkbeacon.base.net.a.b d;
    final /* synthetic */ com.tencent.ydkbeacon.a.b.d e;

    c(com.tencent.ydkbeacon.a.b.d dVar, java.lang.String str, java.lang.String str2, java.lang.Throwable th, com.tencent.ydkbeacon.base.net.a.b bVar) {
        this.e = dVar;
        this.f1180a = str;
        this.b = str2;
        this.c = th;
        this.d = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.e) {
            java.util.LinkedHashMap linkedHashMap = new java.util.LinkedHashMap(com.tencent.ydkbeacon.a.b.d.b);
            linkedHashMap.put("error_code", this.f1180a);
            linkedHashMap.put("error_msg", this.b);
            linkedHashMap.put("error_stack_full", com.tencent.ydkbeacon.a.e.b.a(this.c));
            linkedHashMap.put("_dc", java.lang.String.valueOf(java.lang.Math.random()));
            com.tencent.ydkbeacon.base.net.d.c().a(com.tencent.ydkbeacon.base.net.a.f.b().b("https://h.trace.qq.com/kv").a("atta").a(linkedHashMap).a(com.tencent.ydkbeacon.base.net.HttpMethod.POST).a()).a(this.d);
            com.tencent.ydkbeacon.a.e.c.d("[atta] upload a new error, errorCode: %s, message: %s, stack: %s", this.f1180a, this.b, com.tencent.ydkbeacon.a.e.b.a(this.c));
        }
    }
}
