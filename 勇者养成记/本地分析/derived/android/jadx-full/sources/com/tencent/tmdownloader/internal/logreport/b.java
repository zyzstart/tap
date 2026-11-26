package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class b implements com.tencent.tmdownloader.internal.logreport.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected com.tencent.tmdownloader.internal.logreport.h f1139a = null;
    protected int b = 0;
    protected final java.util.List c = new java.util.ArrayList();

    public synchronized void a() {
        this.f1139a = null;
        this.c.clear();
    }

    public synchronized void a(com.qq.taf.jce.JceStruct jceStruct) {
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "enter:" + jceStruct);
        if (jceStruct != null) {
            e().a(com.tencent.tmassistantbase.common.d.c(jceStruct));
        }
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
    }

    @Override // com.tencent.tmdownloader.internal.logreport.f
    public synchronized void a(com.tencent.tmdownloader.internal.logreport.h hVar, boolean z) {
        java.util.List list;
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "enter");
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "result:" + z);
        if (!z && (list = this.c) != null && list.size() > 0) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "reback DB!");
            e().a(this.c);
        }
        this.f1139a = null;
        this.c.clear();
        if (z && g() && this.b < 5) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "reportlog go on,result:" + z + " count:" + this.b);
            c();
            this.b = this.b + 1;
        }
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
    }

    public synchronized void b() {
        com.tencent.tmdownloader.internal.logreport.h hVar = this.f1139a;
        if (hVar != null) {
            hVar.a();
            this.f1139a = null;
        }
    }

    public synchronized void c() {
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "enter");
        if (!com.tencent.tmassistantbase.util.k.a().m()) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "Not WiFi");
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
            return;
        }
        if (this.f1139a != null) {
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "reportRequst is sending out");
            com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
            return;
        }
        com.tencent.tmdownloader.internal.logreport.h hVar = new com.tencent.tmdownloader.internal.logreport.h();
        this.f1139a = hVar;
        hVar.a(this);
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", " request:" + this.f1139a + " reportManager:" + getClass().getName());
        com.tencent.tmdownloader.internal.b.c.b bVarA = e().a(1000);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("readLogDataAndSendToServer,wrappterCount:");
        sb.append(bVarA.b.size());
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", sb.toString());
        boolean zA = false;
        if (bVarA != null && bVarA.b.size() > 0) {
            this.c.addAll(bVarA.b);
            com.tencent.tmdownloader.internal.logreport.h hVar2 = this.f1139a;
            zA = hVar2 != null ? hVar2.a(f(), bVarA) : false;
            e().b(bVarA.f1120a);
        }
        if (!zA) {
            this.f1139a = null;
        }
        com.tencent.tmassistantbase.util.TMLog.i("BaseReportManager", "exit");
    }

    public void d() {
        this.b = 0;
    }

    protected abstract com.tencent.tmdownloader.internal.b.c.a e();

    protected abstract byte f();

    protected abstract boolean g();
}
