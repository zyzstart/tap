package com.tencent.hlyyb.common.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class d extends com.tencent.hlyyb.common.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.c.e f553a;
    private /* synthetic */ com.tencent.hlyyb.common.c.a b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(com.tencent.hlyyb.common.c.a aVar, com.tencent.hlyyb.common.c.e eVar) {
        super(aVar, (byte) 0);
        this.b = aVar;
        this.f553a = eVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.tencent.hlyyb.common.c.a.b(this.b, false);
        com.tencent.hlyyb.common.c.e eVar = this.f553a;
        if (!eVar.d) {
            if (eVar.c && eVar.b) {
                int size = eVar.e.size();
                for (int i = 0; i < size; i++) {
                    com.tencent.hlyyb.common.c.n.a(this.b.c()).b(((com.tencent.hlyyb.common.c.o) this.f553a.e.get(i)).b);
                }
                return;
            }
            return;
        }
        this.b.f549a.addAndGet(eVar.g);
        com.tencent.hlyyb.common.c.e eVar2 = this.f553a;
        if (!eVar2.b) {
            int size2 = eVar2.e.size();
            java.util.ArrayList arrayList = new java.util.ArrayList();
            for (int i2 = 0; i2 < size2; i2++) {
                arrayList.add(java.lang.Long.valueOf(((com.tencent.hlyyb.common.c.o) this.f553a.e.get(i2)).f562a));
            }
            com.tencent.hlyyb.common.c.n.a(this.b.c()).a(arrayList);
            if (this.b.i) {
                com.tencent.hlyyb.common.c.a.c(this.b, false);
                this.b.a(true, this.f553a.c);
                return;
            }
        }
        if (this.f553a.f554a) {
            this.b.m = true;
            return;
        }
        android.os.SystemClock.sleep(200L);
        com.tencent.hlyyb.common.c.a aVar = this.b;
        com.tencent.hlyyb.common.c.e eVar3 = this.f553a;
        aVar.a(eVar3.b, eVar3.c);
    }
}
