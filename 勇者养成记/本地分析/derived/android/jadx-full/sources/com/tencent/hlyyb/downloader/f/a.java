package com.tencent.hlyyb.downloader.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    private static com.tencent.hlyyb.downloader.f.a f = new com.tencent.hlyyb.downloader.f.a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.util.Map f636a = new java.util.HashMap();
    private java.util.Map b = new java.util.HashMap();
    private com.tencent.hlyyb.common.a.a.d c;
    private com.tencent.hlyyb.common.a.a.d d;
    private com.tencent.hlyyb.common.a.a.d e;

    private a() {
    }

    private synchronized com.tencent.hlyyb.downloader.f.a.b a(com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory) {
        int iIntValue;
        com.tencent.hlyyb.downloader.f.a.b bVar;
        java.lang.Integer num = (java.lang.Integer) this.b.get(downloaderTaskCategory);
        if (num == null) {
            iIntValue = downloaderTaskCategory == com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultEase ? 3 : 2;
        } else {
            iIntValue = num.intValue();
        }
        int iA = com.tencent.hlyyb.common.f.c.a(iIntValue, 1, 5);
        bVar = (com.tencent.hlyyb.downloader.f.a.b) this.f636a.get(downloaderTaskCategory);
        if (bVar == null) {
            com.tencent.hlyyb.downloader.f.a.a aVar = new com.tencent.hlyyb.downloader.f.a.a(64);
            com.tencent.hlyyb.downloader.f.a.b bVar2 = new com.tencent.hlyyb.downloader.f.a.b(0, iA, 5L, java.util.concurrent.TimeUnit.SECONDS, aVar, new com.tencent.hlyyb.common.a.a.a(downloaderTaskCategory.name()));
            aVar.a(bVar2);
            this.f636a.put(downloaderTaskCategory, bVar2);
            bVar = bVar2;
        } else {
            int maximumPoolSize = iA - bVar.getMaximumPoolSize();
            bVar.setMaximumPoolSize(iA);
            iA = maximumPoolSize;
        }
        com.tencent.hlyyb.common.a.a.d dVar = this.c;
        if (dVar == null) {
            com.tencent.hlyyb.common.a.a.b bVar3 = new com.tencent.hlyyb.common.a.a.b(16);
            com.tencent.hlyyb.common.a.a.d dVar2 = new com.tencent.hlyyb.common.a.a.d(0, (iA <= 0 ? 1 : iA) + 1, 5L, java.util.concurrent.TimeUnit.SECONDS, bVar3, new com.tencent.hlyyb.common.a.a.a("HallyDownload-DirectPool"));
            this.c = dVar2;
            bVar3.a(dVar2);
        } else {
            this.c.setMaximumPoolSize(dVar.getMaximumPoolSize() + iA);
        }
        if (downloaderTaskCategory != com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultEase) {
            com.tencent.hlyyb.common.a.a.d dVar3 = this.d;
            if (dVar3 == null) {
                com.tencent.hlyyb.common.a.a.b bVar4 = new com.tencent.hlyyb.common.a.a.b(16);
                if (iA <= 0) {
                    iA = 1;
                }
                com.tencent.hlyyb.common.a.a.d dVar4 = new com.tencent.hlyyb.common.a.a.d(0, iA + 1, 5L, java.util.concurrent.TimeUnit.SECONDS, bVar4, new com.tencent.hlyyb.common.a.a.a("HallyDownload-SchedulePool"));
                this.d = dVar4;
                bVar4.a(dVar4);
            } else {
                this.d.setMaximumPoolSize(dVar3.getMaximumPoolSize() + iA);
            }
        }
        if (this.e != null) {
            b();
        }
        return bVar;
    }

    public static com.tencent.hlyyb.downloader.f.a a() {
        return f;
    }

    private void b() {
        int maximumPoolSize = 0;
        for (com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory : this.f636a.keySet()) {
            if (downloaderTaskCategory != com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultEase) {
                maximumPoolSize += ((com.tencent.hlyyb.downloader.f.a.b) this.f636a.get(downloaderTaskCategory)).getMaximumPoolSize();
            }
        }
        if (maximumPoolSize == 0) {
            maximumPoolSize = 2;
        }
        com.tencent.hlyyb.common.a.a.d dVar = this.e;
        if (dVar != null) {
            dVar.setMaximumPoolSize((maximumPoolSize << 1) + 1);
            return;
        }
        com.tencent.hlyyb.common.a.a.b bVar = new com.tencent.hlyyb.common.a.a.b(16);
        com.tencent.hlyyb.common.a.a.d dVar2 = new com.tencent.hlyyb.common.a.a.d(0, (maximumPoolSize << 1) + 1, 5L, java.util.concurrent.TimeUnit.SECONDS, bVar, new com.tencent.hlyyb.common.a.a.a("HallyDownload-HijackPool"));
        this.e = dVar2;
        bVar.a(dVar2);
    }

    public final com.tencent.hlyyb.common.a.m a(java.lang.Runnable runnable) {
        return new com.tencent.hlyyb.downloader.f.b(this.c.submit(runnable));
    }

    public final synchronized com.tencent.hlyyb.common.a.m a(java.lang.Runnable runnable, com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory) {
        com.tencent.hlyyb.downloader.f.a.b bVarA;
        bVarA = (com.tencent.hlyyb.downloader.f.a.b) this.f636a.get(downloaderTaskCategory);
        if (bVarA == null) {
            bVarA = a(downloaderTaskCategory);
        }
        return new com.tencent.hlyyb.downloader.f.b(bVarA.submit(runnable));
    }

    public final synchronized void a(com.tencent.hlyyb.downloader.DownloaderTaskCategory downloaderTaskCategory, int i) {
        if (downloaderTaskCategory == null || i <= 0) {
            return;
        }
        this.b.put(downloaderTaskCategory, java.lang.Integer.valueOf(com.tencent.hlyyb.common.f.c.a(i, 1, 5)));
        if (((com.tencent.hlyyb.downloader.f.a.b) this.f636a.get(downloaderTaskCategory)) != null) {
            a(downloaderTaskCategory);
        }
    }

    public final com.tencent.hlyyb.common.a.m b(java.lang.Runnable runnable) {
        return new com.tencent.hlyyb.downloader.f.b(this.d.submit(runnable));
    }

    public final com.tencent.hlyyb.common.a.m c(java.lang.Runnable runnable) {
        if (this.e == null) {
            b();
        }
        return new com.tencent.hlyyb.downloader.f.b(this.e.submit(runnable));
    }
}
