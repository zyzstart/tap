package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class q implements com.tencent.beacon.core.event.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.concurrent.atomic.AtomicInteger f176a = new java.util.concurrent.atomic.AtomicInteger(2000);
    protected final android.content.Context d;
    private com.tencent.beacon.core.event.h e;
    boolean b = false;
    protected java.lang.Runnable g = new com.tencent.beacon.core.event.o(this);
    protected java.lang.Runnable h = new com.tencent.beacon.core.event.p(this);
    protected final java.util.List c = java.util.Collections.synchronizedList(new java.util.ArrayList(25));
    private int f = f176a.addAndGet(1);

    public q(android.content.Context context, com.tencent.beacon.core.event.h hVar) {
        this.d = context;
        this.e = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str) {
        return str + " Tunnel key: " + this.e.b();
    }

    private boolean b(com.tencent.beacon.core.event.RDBean rDBean) {
        return "rqd_applaunched".equals(rDBean.getEN());
    }

    @Override // com.tencent.beacon.core.event.n
    public synchronized void a() {
        com.tencent.beacon.core.a.d.a().a(this.f, this.g, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING, ((long) com.tencent.beacon.core.event.EventStrategyBean.getInstance().getRealDelayUpload()) * 1000);
    }

    @Override // com.tencent.beacon.core.event.n
    public synchronized void a(boolean z) {
        if (this.b != z) {
            if (z) {
                this.b = z;
                com.tencent.beacon.core.a.d.a().a(this.f, this.g, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING, ((long) com.tencent.beacon.core.event.EventStrategyBean.getInstance().getRealDelayUpload()) * 1000);
            } else {
                com.tencent.beacon.core.a.d.a().a(this.f, true);
                b(true);
                this.b = z;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.event.n
    public synchronized boolean a(com.tencent.beacon.core.event.RDBean rDBean) {
        java.lang.Object[] objArr = new java.lang.Object[1];
        objArr[0] = rDBean == null ? "null" : rDBean.getEN();
        com.tencent.beacon.core.e.d.f("[event] eN:%s", objArr);
        if (this.d != null && rDBean != null) {
            if (!e()) {
                com.tencent.beacon.core.e.d.b(a("[realtime event] disable process."), new java.lang.Object[0]);
                return false;
            }
            this.c.add(rDBean);
            com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
            int realNumUpload = eventStrategyBean.getRealNumUpload();
            long realDelayUpload = ((long) eventStrategyBean.getRealDelayUpload()) * 1000;
            int size = this.c.size();
            com.tencent.beacon.core.e.d.a(a("[realtime event] realtime event buff num: " + this.c.size()), new java.lang.Object[0]);
            if (b(rDBean) || size >= realNumUpload || rDBean.isImmediatelyUpload()) {
                com.tencent.beacon.core.e.d.f(a("[realtime event] upload by max num or immediate."), new java.lang.Object[0]);
                com.tencent.beacon.core.a.d.a().a(this.g);
                com.tencent.beacon.core.a.d.a().a(this.f, this.g, realDelayUpload, realDelayUpload);
            }
            java.util.Iterator it = com.tencent.beacon.core.d.k.a(this.d).d().iterator();
            while (it.hasNext()) {
                ((com.tencent.beacon.core.d.l) it.next()).incRealTimeEventCalls();
            }
            com.tencent.beacon.core.e.d.a(a("[realtime event] eventName:" + rDBean.getEN() + ", processUA:true!"), new java.lang.Object[0]);
            return true;
        }
        com.tencent.beacon.core.e.d.b(a("[realtime event] context is null or bean is null !"), new java.lang.Object[0]);
        return false;
    }

    protected void b() {
        java.util.List listD = d();
        if (listD == null || listD.size() <= 0) {
            return;
        }
        com.tencent.beacon.core.e.d.f(a("[realtime event] sync real events 2 db"), new java.lang.Object[0]);
        java.lang.Long[] lArrA = com.tencent.beacon.core.event.t.a(this.d, this.e.b(), listD);
        if (lArrA != null) {
            java.util.Iterator it = com.tencent.beacon.core.d.k.a(this.d).d().iterator();
            while (it.hasNext()) {
                ((com.tencent.beacon.core.d.l) it.next()).incRealTimeEventWriteSucc(lArrA.length);
            }
        }
    }

    @Override // com.tencent.beacon.core.event.n
    public void b(boolean z) {
        com.tencent.beacon.core.e.d.e(a("[realtime event] flush memory objects to db."), new java.lang.Object[0]);
        if (z) {
            b();
        } else {
            com.tencent.beacon.core.a.d.a().a(this.h);
        }
    }

    protected void c() {
        if (!e()) {
            com.tencent.beacon.core.e.d.b(a("[realtime event] disable upload."), new java.lang.Object[0]);
            return;
        }
        java.util.List listD = d();
        if (listD == null || listD.size() <= 0) {
            return;
        }
        com.tencent.beacon.core.d.k kVarA = com.tencent.beacon.core.d.k.a(this.d);
        com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
        if (com.tencent.beacon.core.e.e.c(this.d) && kVarA != null && eventStrategyBean.isZeroPeakUploadByRate()) {
            com.tencent.beacon.core.e.d.f(a("[realtime event] sync real events 2 upload"), new java.lang.Object[0]);
            kVarA.a(new com.tencent.beacon.core.event.r(this.d, this.e.b(), listD));
            return;
        }
        com.tencent.beacon.core.e.d.f(a("[realtime event] sync real events 2 db"), new java.lang.Object[0]);
        java.lang.Long[] lArrA = com.tencent.beacon.core.event.t.a(this.d, this.e.b(), listD);
        if (lArrA != null) {
            java.util.Iterator it = com.tencent.beacon.core.d.k.a(this.d).d().iterator();
            while (it.hasNext()) {
                ((com.tencent.beacon.core.d.l) it.next()).incRealTimeEventWriteSucc(lArrA.length);
            }
        }
    }

    public synchronized java.util.List d() {
        java.util.List list = this.c;
        if (list != null && list.size() > 0 && e()) {
            java.util.ArrayList arrayList = new java.util.ArrayList();
            arrayList.addAll(this.c);
            this.c.clear();
            com.tencent.beacon.core.e.d.a(a("[realtime event] buff event size: " + arrayList.size()), new java.lang.Object[0]);
            return arrayList;
        }
        return null;
    }

    public synchronized boolean e() {
        return this.b;
    }
}
