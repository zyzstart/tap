package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class c extends com.tencent.hlyyb.common.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f552a;
    private boolean b;
    private boolean c;
    private /* synthetic */ com.tencent.hlyyb.common.c.a d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(com.tencent.hlyyb.common.c.a aVar, java.lang.String str, boolean z, boolean z2) {
        super(aVar, (byte) 0);
        this.d = aVar;
        this.f552a = str;
        this.b = z;
        this.c = z2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.d.j.decrementAndGet();
        if (android.text.TextUtils.isEmpty(this.f552a)) {
            return;
        }
        int iA = com.tencent.hlyyb.common.a.e.a("report_new_record_num", 1, 50, 10);
        if (!this.b) {
            if (com.tencent.hlyyb.common.c.n.a(this.d.c()).b(this.f552a) == -1) {
                com.tencent.hlyyb.common.c.a aVar = this.d;
                com.tencent.hlyyb.common.d.j.a("report_missing_event", com.tencent.hlyyb.common.d.j.b("report_missing_event", 0, false) + 1, false);
                return;
            }
            if (this.d.m) {
                this.d.m = false;
                this.d.b(false, false);
            }
            if (this.d.f.incrementAndGet() >= iA) {
                this.d.a(this.b, this.c);
                return;
            }
            return;
        }
        this.d.g.add(this.f552a);
        boolean z = this.c;
        if (!z) {
            this.d.a(this.b, z);
            return;
        }
        if (this.d.g.size() >= iA) {
            this.d.l.set(1);
            this.d.a(this.b, this.c);
        } else if (this.d.l.get() == 0) {
            this.d.l.set(1);
            this.d.b(false, true);
        }
    }
}
