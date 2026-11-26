package com.tencent.ydkbeacon.a.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.tencent.ydkbeacon.a.d.g f1194a;

    e(com.tencent.ydkbeacon.a.d.g gVar) {
        this.f1194a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            synchronized (this.f1194a.f) {
                byte[] bArrA = com.tencent.ydkbeacon.a.d.g.a(this.f1194a.b.toString().getBytes("ISO8859-1"));
                if (bArrA == null) {
                    return;
                }
                if (bArrA.length + 10 > this.f1194a.d) {
                    this.f1194a.d = bArrA.length + 10;
                    this.f1194a.a(this.f1194a.d);
                }
                this.f1194a.c.putInt(0, bArrA.length);
                this.f1194a.c.position(10);
                this.f1194a.c.put(bArrA);
                this.f1194a.c.force();
            }
        } catch (java.lang.Exception e) {
            com.tencent.ydkbeacon.a.b.d.b().a("504", "[properties] write to file error!", e);
        }
    }
}
