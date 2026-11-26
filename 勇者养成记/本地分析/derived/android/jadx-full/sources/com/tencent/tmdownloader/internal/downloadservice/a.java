package com.tencent.tmdownloader.internal.downloadservice;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.tmassistantbase.network.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static com.tencent.tmdownloader.internal.downloadservice.a f1128a;
    public static com.tencent.hlyyb.a e;
    protected long b = 0;
    protected long c = 0;
    protected java.lang.String d = "";
    final java.util.concurrent.ConcurrentHashMap f = new java.util.concurrent.ConcurrentHashMap();

    private a() {
    }

    public static com.tencent.tmdownloader.internal.downloadservice.a b() {
        if (f1128a == null) {
            f1128a = new com.tencent.tmdownloader.internal.downloadservice.a();
        }
        return f1128a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x014f, code lost:
    
        if ((r0.f1133a.equals(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF) ? com.tencent.tmdownloader.internal.downloadservice.c.b(r7, r0.f1133a) : com.tencent.tmdownloader.internal.downloadservice.c.f(r0.j)) != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int a(java.lang.String r7, int r8, java.lang.String r9, java.lang.String r10, java.util.Map r11, android.os.Bundle r12) {
        /*
            Method dump skipped, instruction units count: 557
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmdownloader.internal.downloadservice.a.a(java.lang.String, int, java.lang.String, java.lang.String, java.util.Map, android.os.Bundle):int");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.tmassistantbase.network.d
    public synchronized void a() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "halleytest onNetworkChanged and isNetworkConncted=" + com.tencent.tmdownloader.internal.downloadservice.c.b() + ",isAutoDownloadOrPause=" + com.tencent.tmdownloader.internal.downloadservice.g.a().c());
        com.tencent.tmassistantbase.b.d.f();
        if (com.tencent.tmdownloader.internal.downloadservice.c.b() && com.tencent.tmdownloader.internal.downloadservice.g.a().c()) {
            java.lang.String strA = com.tencent.tmdownloader.internal.downloadservice.c.a();
            java.util.Iterator it = this.f.keySet().iterator();
            while (it.hasNext()) {
                com.tencent.tmdownloader.internal.downloadservice.d dVar = (com.tencent.tmdownloader.internal.downloadservice.d) this.f.get(it.next());
                if (dVar != null && !android.text.TextUtils.isEmpty(strA)) {
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "halleytest onNetworkChanged and di.mAppName = " + dVar.G + ",di.mStatus=" + dVar.g + ",di.mIsPausedByMobl=" + dVar.I);
                    if (((dVar.g == 3 && dVar.I) || dVar.g == 5) && com.tencent.tmdownloader.internal.downloadservice.g.a().a(this.d, strA)) {
                        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "halleytest onNetworkChanged di.mAppName = " + dVar.G + "and startDownloadIfReady");
                        dVar.c();
                    }
                    int i = dVar.g;
                    if (i == 2 || i == 1) {
                        if (com.tencent.tmdownloader.internal.downloadservice.g.a().b(this.d, strA)) {
                            dVar.d();
                            dVar.I = true;
                            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "halleytest onNetworkChanged di.mAppName = " + dVar.G + "and pauseDownload, di.mIsPausedByMoble=" + dVar.I);
                        }
                    }
                }
            }
            this.d = strA;
        }
    }

    public void a(com.tencent.tmdownloader.internal.downloadservice.h hVar) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "call AddDownloadListener, dl: " + hVar);
        com.tencent.tmdownloader.internal.downloadservice.f.a().a(hVar);
    }

    public void a(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "call pauseDownload, url: " + str);
        com.tencent.tmdownloader.internal.downloadservice.d dVar = (com.tencent.tmdownloader.internal.downloadservice.d) this.f.get(str);
        if (dVar != null) {
            dVar.d();
        }
    }

    public void b(com.tencent.tmdownloader.internal.downloadservice.h hVar) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "call RemoveDownloadListener, dl: " + hVar);
        com.tencent.tmdownloader.internal.downloadservice.f.a().b(hVar);
    }

    public void b(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "call cancelDownload, url: " + str);
        com.tencent.tmdownloader.internal.downloadservice.d dVar = (com.tencent.tmdownloader.internal.downloadservice.d) this.f.remove(str);
        if (dVar != null) {
            dVar.e();
        }
    }

    public com.tencent.tmdownloader.internal.downloadservice.d c(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "call queryDownloadInfo, url: " + str);
        com.tencent.tmdownloader.internal.downloadservice.d dVarB = (com.tencent.tmdownloader.internal.downloadservice.d) this.f.get(str);
        if (dVarB == null) {
            dVarB = com.tencent.tmdownloader.internal.b.a.a().b(str);
        } else {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "getDownloadTaskInfo url=" + str + ",state=" + dVarB.g);
        }
        boolean zB = false;
        if (dVarB != null) {
            zB = dVarB.f1133a.equals(com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF) ? com.tencent.tmdownloader.internal.downloadservice.c.b(str, dVarB.f1133a) : com.tencent.tmdownloader.internal.downloadservice.c.f(dVarB.j);
        }
        if (dVarB == null || !dVarB.a() || zB) {
            return dVarB;
        }
        this.f.remove(str);
        com.tencent.tmdownloader.internal.b.a.a().a(str);
        return null;
    }

    public void c() {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "Start to load DownloadInfo list.");
        this.f.clear();
        java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.d> arrayListB = com.tencent.tmdownloader.internal.b.a.a().b();
        if (arrayListB != null) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "The size of downloadinfo_list: " + arrayListB.size());
            for (com.tencent.tmdownloader.internal.downloadservice.d dVar : arrayListB) {
                if (dVar != null) {
                    com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "---------------load download info---------------");
                    dVar.a("TMSelfUpdate_ApkDownloadManager");
                    if (!android.text.TextUtils.isEmpty(dVar.b)) {
                        this.f.put(dVar.b, dVar);
                    }
                    if (!dVar.b()) {
                        dVar.a(3);
                    }
                }
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "Add NetworkChangedObserver to NetworkMonitorReceiver");
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().a(this);
        com.tencent.hlyyb.a aVar = new com.tencent.hlyyb.a(com.tencent.tmassistantbase.util.k.a().b(), 2900, "", "");
        e = aVar;
        com.tencent.hlyyb.HalleyAgent.init(aVar);
        com.tencent.hlyyb.HalleyAgent.getDownloader(e).setPhoneGuid(com.tencent.tmassistantbase.util.k.a().f());
        com.tencent.hlyyb.HalleyAgent.getDownloader(e).setTaskNumForCategory(com.tencent.hlyyb.downloader.DownloaderTaskCategory.Cate_DefaultMass, 3);
        com.tencent.hlyyb.HalleyAgent.getDownloader(e).setNotNetworkWaitMillis(com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
        this.d = com.tencent.tmdownloader.internal.downloadservice.c.a();
    }

    public void d() {
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().b(this);
        java.util.ArrayList arrayList = new java.util.ArrayList();
        if (!this.f.isEmpty()) {
            java.util.Iterator it = this.f.keySet().iterator();
            while (it.hasNext()) {
                com.tencent.tmdownloader.internal.downloadservice.d dVar = (com.tencent.tmdownloader.internal.downloadservice.d) this.f.get(it.next());
                if (dVar.g == 2) {
                    a(dVar.b);
                }
                arrayList.add(dVar);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ApkDownloadManager", "Start to save DownloadInfo list.");
        com.tencent.tmdownloader.internal.b.a.a().a(arrayList);
    }

    public java.lang.Boolean e() {
        java.util.Iterator it = this.f.keySet().iterator();
        while (it.hasNext()) {
            if (!((com.tencent.tmdownloader.internal.downloadservice.d) this.f.get(it.next())).b()) {
                return java.lang.Boolean.FALSE;
            }
        }
        return java.lang.Boolean.TRUE;
    }
}
