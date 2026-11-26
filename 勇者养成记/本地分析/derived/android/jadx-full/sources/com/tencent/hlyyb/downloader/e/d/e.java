package com.tencent.hlyyb.downloader.e.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class e implements com.tencent.hlyyb.downloader.d.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private /* synthetic */ java.util.concurrent.CountDownLatch f630a;
    private /* synthetic */ com.tencent.hlyyb.downloader.e.d.c b;

    e(com.tencent.hlyyb.downloader.e.d.c cVar, java.util.concurrent.CountDownLatch countDownLatch) {
        this.b = cVar;
        this.f630a = countDownLatch;
    }

    @Override // com.tencent.hlyyb.downloader.d.b
    public final void a() {
        this.f630a.countDown();
    }

    @Override // com.tencent.hlyyb.downloader.d.b
    public final void a(java.util.List list, long j, java.lang.String str, java.util.List list2, java.lang.String str2, java.util.Map map) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    com.tencent.hlyyb.common.a.f.e();
                    java.lang.String strB = com.tencent.hlyyb.common.a.f.b();
                    if (!android.text.TextUtils.isEmpty(strB)) {
                        this.b.b(true);
                        java.util.Iterator it = list.iterator();
                        while (it.hasNext()) {
                            java.lang.String str3 = (java.lang.String) it.next();
                            if (!android.text.TextUtils.isEmpty(str3)) {
                                int i = com.tencent.hlyyb.downloader.e.d.b.f;
                                if (str3.toLowerCase().startsWith("https://")) {
                                    i = com.tencent.hlyyb.downloader.e.d.b.j;
                                }
                                this.b.a(strB, str3, i);
                            }
                        }
                        if (!this.b.k) {
                            this.b.c = (int) (android.os.SystemClock.elapsedRealtime() - this.b.l);
                            com.tencent.hlyyb.downloader.e.d.c cVar = this.b;
                            if (this.b.g != -1 || j <= 0) {
                                j = -1;
                            }
                            cVar.g = j;
                            com.tencent.hlyyb.downloader.e.d.c cVar2 = this.b;
                            if (!android.text.TextUtils.isEmpty(this.b.h) || android.text.TextUtils.isEmpty(str)) {
                                str = "";
                            }
                            cVar2.h = str;
                            this.b.i = list2;
                            this.b.j = str2;
                            this.b.m = map;
                            com.tencent.hlyyb.downloader.e.d.c.a(this.b, true);
                        }
                    }
                }
            } catch (java.lang.Throwable unused) {
            }
        }
        this.f630a.countDown();
    }
}
