package com.tencent.beacon.core.event;

/* JADX INFO: renamed from: com.tencent.beacon.core.event.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class C0083c implements com.tencent.beacon.core.event.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.concurrent.atomic.AtomicInteger f166a = new java.util.concurrent.atomic.AtomicInteger(1000);
    final android.content.Context b;
    private com.tencent.beacon.core.event.h h;
    boolean c = false;
    private final java.lang.Object d = new java.lang.Object();
    private final java.lang.Object e = new java.lang.Object();
    protected final java.util.List f = new java.util.ArrayList(25);
    private int g = com.youme.im.CommonConst.SPEECH_DURATION_MAX;
    protected java.lang.Runnable j = new com.tencent.beacon.core.event.RunnableC0081a(this);
    private final int i = f166a.addAndGet(1);

    public C0083c(android.content.Context context, com.tencent.beacon.core.event.h hVar) {
        this.b = context;
        this.h = hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.lang.String a(java.lang.String str) {
        return str + " Tunnel key: " + this.h.b();
    }

    private java.util.List f() {
        synchronized (this.f) {
            if (this.f.size() > 0 && c()) {
                java.util.ArrayList arrayList = new java.util.ArrayList(this.f);
                this.f.clear();
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("[event] getListInMemory: buffer event size:");
                sb.append(arrayList.size());
                com.tencent.beacon.core.e.d.a(a(sb.toString()), new java.lang.Object[0]);
                return arrayList;
            }
            return null;
        }
    }

    @Override // com.tencent.beacon.core.event.n
    public synchronized void a() {
        this.g = com.tencent.beacon.core.event.EventStrategyBean.getInstance().getComDelayDB() * 1000;
        com.tencent.beacon.core.a.d dVarA = com.tencent.beacon.core.a.d.a();
        int i = this.i;
        java.lang.Runnable runnableB = b(true, null);
        long j = this.g;
        dVarA.a(i, runnableB, j, j);
    }

    @Override // com.tencent.beacon.core.event.n
    public synchronized void a(boolean z) {
        if (this.c != z) {
            if (z) {
                this.c = true;
                this.g = com.tencent.beacon.core.event.EventStrategyBean.getInstance().getComDelayDB() * 1000;
                com.tencent.beacon.core.a.d dVarA = com.tencent.beacon.core.a.d.a();
                int i = this.i;
                java.lang.Runnable runnableB = b(true, null);
                long j = this.g;
                dVarA.a(i, runnableB, j, j);
            } else {
                com.tencent.beacon.core.a.d.a().a(this.i, true);
                com.tencent.beacon.core.a.d.a().a(102, true);
                b(true);
                this.c = false;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void a(boolean z, java.util.List list) {
        java.lang.String strA;
        java.lang.Object[] objArr;
        synchronized (this.e) {
            if (!c()) {
                com.tencent.beacon.core.e.d.b(a("[event] err disable."), new java.lang.Object[0]);
                return;
            }
            if (list == null) {
                list = f();
            }
            if (list != null && list.size() > 0) {
                java.lang.Long[] lArrA = com.tencent.beacon.core.event.t.a(this.b, this.h.b(), list);
                if (lArrA != null) {
                    java.util.Iterator it = com.tencent.beacon.core.d.k.a(this.b).d().iterator();
                    while (it.hasNext()) {
                        ((com.tencent.beacon.core.d.l) it.next()).incCommonEventWriteSucc(lArrA.length);
                    }
                }
                com.tencent.beacon.core.d.k kVarA = com.tencent.beacon.core.d.k.a(this.b);
                if (lArrA != null && d() && kVarA.f() && kVarA.e()) {
                    if (!com.tencent.beacon.core.event.EventStrategyBean.getInstance().isZeroPeakUploadByRate()) {
                        com.tencent.beacon.core.e.d.e(a("[event] max but not up(zeroPeak)!"), new java.lang.Object[0]);
                        return;
                    }
                    c(z);
                    strA = a("[event] max then up");
                    objArr = new java.lang.Object[0];
                    com.tencent.beacon.core.e.d.e(strA, objArr);
                }
            } else if (e()) {
                c(z);
                strA = a("[event] polling then up");
                objArr = new java.lang.Object[0];
                com.tencent.beacon.core.e.d.e(strA, objArr);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.beacon.core.event.n
    public boolean a(com.tencent.beacon.core.event.RDBean rDBean) {
        synchronized (this.d) {
            java.lang.String strA = a("[event] eN:%s");
            java.lang.Object[] objArr = new java.lang.Object[1];
            objArr[0] = rDBean == null ? "null" : rDBean.getEN();
            com.tencent.beacon.core.e.d.f(strA, objArr);
            if (this.b != null && rDBean != null) {
                if (!c()) {
                    com.tencent.beacon.core.e.d.b(a("[event] return false, isEnable is false !"), new java.lang.Object[0]);
                    return false;
                }
                com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
                int comNumDB = eventStrategyBean.getComNumDB();
                this.g = eventStrategyBean.getComDelayDB() * 1000;
                synchronized (this.f) {
                    this.f.add(rDBean);
                    int size = this.f.size();
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("[event] event buff num：");
                    sb.append(size);
                    com.tencent.beacon.core.e.d.f(a(sb.toString()), new java.lang.Object[0]);
                    if (size >= comNumDB) {
                        java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                        sb2.append("[event] max num .  size : ");
                        sb2.append(size);
                        com.tencent.beacon.core.e.d.f(a(sb2.toString()), new java.lang.Object[0]);
                        com.tencent.beacon.core.a.d.a().a(b(false, f()));
                        com.tencent.beacon.core.a.d.a().a(this.i, b(true, null), this.g, this.g);
                    }
                }
                java.util.Iterator it = com.tencent.beacon.core.d.k.a(this.b).d().iterator();
                while (it.hasNext()) {
                    ((com.tencent.beacon.core.d.l) it.next()).incCommonEventCalls();
                }
                com.tencent.beacon.core.e.d.d(a("[event] process UA:true!"), new java.lang.Object[0]);
                return true;
            }
            com.tencent.beacon.core.e.d.b(a("[event] err return."), new java.lang.Object[0]);
            return false;
        }
    }

    protected java.lang.Runnable b(boolean z, java.util.List list) {
        return new com.tencent.beacon.core.event.RunnableC0082b(this, z, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized void b() {
        java.lang.Long[] lArrA;
        com.tencent.beacon.core.e.d.a(a("[event] sync db only"), new java.lang.Object[0]);
        if (!c()) {
            com.tencent.beacon.core.e.d.b(a("[event] err disable."), new java.lang.Object[0]);
            return;
        }
        java.util.List listF = f();
        if (listF != null && listF.size() > 0 && (lArrA = com.tencent.beacon.core.event.t.a(this.b, this.h.b(), listF)) != null) {
            java.util.Iterator it = com.tencent.beacon.core.d.k.a(this.b).d().iterator();
            while (it.hasNext()) {
                ((com.tencent.beacon.core.d.l) it.next()).incCommonEventWriteSucc(lArrA.length);
            }
        }
    }

    @Override // com.tencent.beacon.core.event.n
    public void b(boolean z) {
        com.tencent.beacon.core.e.d.e(a("[event] process flush memory objects to db."), new java.lang.Object[0]);
        if (z) {
            b();
        } else {
            com.tencent.beacon.core.a.d.a().a(this.j);
        }
    }

    protected void c(boolean z) {
        com.tencent.beacon.core.e.d.f(a("[event] -> do max size upload task."), new java.lang.Object[0]);
        try {
            this.h.a(z, true);
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
        }
    }

    public boolean c() {
        return this.c;
    }

    protected boolean d() {
        long comNumUpload = com.tencent.beacon.core.event.EventStrategyBean.getInstance().getComNumUpload();
        if (com.tencent.beacon.core.e.e.d(this.b)) {
            com.tencent.beacon.core.e.d.e(a("[event] on wifi, so half mSZ " + comNumUpload), new java.lang.Object[0]);
            comNumUpload /= 2;
        }
        int iA = com.tencent.beacon.core.event.t.a(this.b, this.h.b());
        com.tencent.beacon.core.e.d.a(a("[event] recordNum: " + iA + ", maxNum: " + comNumUpload), new java.lang.Object[0]);
        return ((long) iA) >= comNumUpload;
    }

    protected boolean e() {
        com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
        if (eventStrategyBean != null) {
            return eventStrategyBean.isComPollUp();
        }
        return false;
    }
}
