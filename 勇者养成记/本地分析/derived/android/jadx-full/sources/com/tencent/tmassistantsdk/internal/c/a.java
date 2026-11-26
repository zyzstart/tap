package com.tencent.tmassistantsdk.internal.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a implements com.tencent.tmassistantsdk.internal.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tencent.tmassistantsdk.internal.c.d f1071a = null;
    protected int b = 0;
    protected final java.util.List c = new java.util.ArrayList();

    public synchronized void a() {
        this.f1071a = null;
        this.c.clear();
    }

    public synchronized void a(com.qq.taf.jce.JceStruct jceStruct) {
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "enter:" + jceStruct);
        if (jceStruct != null) {
            e().a(com.tencent.tmassistantbase.common.d.c(jceStruct));
        }
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
    }

    @Override // com.tencent.tmassistantsdk.internal.c.c
    public synchronized void a(com.tencent.tmassistantsdk.internal.c.d dVar, boolean z) {
        java.util.List list;
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "result:" + z);
        if (!z && (list = this.c) != null && list.size() > 0) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "reback DB!");
            e().a(this.c);
        }
        this.f1071a = null;
        this.c.clear();
        if (z && g() && this.b < 5) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "reportlog go on,result:" + z + " count:" + this.b);
            c();
            this.b = this.b + 1;
        }
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
    }

    public synchronized void b() {
        com.tencent.tmassistantsdk.internal.c.d dVar = this.f1071a;
        if (dVar != null) {
            dVar.a();
            this.f1071a = null;
        }
    }

    public synchronized void c() {
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "enter");
        if (!com.tencent.tmassistantbase.util.k.a().m()) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "Not WiFi");
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
            return;
        }
        if (this.f1071a != null) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "reportRequst is sending out");
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
            return;
        }
        com.tencent.tmassistantsdk.internal.c.d dVar = new com.tencent.tmassistantsdk.internal.c.d();
        this.f1071a = dVar;
        dVar.a(this);
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", " request:" + this.f1071a + " reportManager:" + getClass().getName());
        com.tencent.tmassistantsdk.internal.e.a.b bVarA = e().a(1000);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("readLogDataAndSendToServer,wrappterCount:");
        sb.append(bVarA.b.size());
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", sb.toString());
        boolean zA = false;
        if (bVarA != null && bVarA.b.size() > 0) {
            this.c.addAll(bVarA.b);
            com.tencent.tmassistantsdk.internal.c.d dVar2 = this.f1071a;
            zA = dVar2 != null ? dVar2.a(f(), bVarA) : false;
            e().b(bVarA.f1075a);
        }
        if (!zA) {
            this.f1071a = null;
        }
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
    }

    public void d() {
        this.b = 0;
    }

    protected abstract com.tencent.tmassistantsdk.internal.e.a.a e();

    protected abstract byte f();

    protected abstract boolean g();
}
