package com.tencent.hlyyb.downloader.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b implements com.tencent.hlyyb.common.a.g, com.tencent.hlyyb.downloader.DownloaderTaskListener, com.tencent.hlyyb.downloader.e.a.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.hlyyb.downloader.c.b f609a;
    private java.util.Vector b = new java.util.Vector();
    private com.tencent.hlyyb.downloader.e.a.c c = new com.tencent.hlyyb.downloader.e.a.c(this);

    private b() {
        com.tencent.hlyyb.common.a.f.a("downloader", this);
    }

    public static synchronized com.tencent.hlyyb.downloader.c.b a() {
        if (f609a == null) {
            f609a = new com.tencent.hlyyb.downloader.c.b();
        }
        return f609a;
    }

    private static void a(com.tencent.hlyyb.downloader.e.h hVar, int i) {
        if (hVar == null) {
            return;
        }
        try {
            java.util.HashMap map = new java.util.HashMap();
            int failCode = hVar.getFailCode();
            if (i == 0) {
                failCode = 0;
            }
            java.lang.String str = hVar.isEaseTask() ? "HLDownTiny" : "B_DLSDK_Result";
            if (com.tencent.hlyyb.common.a.e.a(com.tencent.hlyyb.common.a.e.a(str, com.tencent.hlyyb.common.a.c(), failCode, (java.util.Map) null))) {
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append(com.tencent.hlyyb.common.a.c());
                map.put("D1", sb.toString());
                map.put("B1", hVar.n);
                map.put("B2", com.tencent.hlyyb.common.f.c.e());
                map.put("B3", com.tencent.hlyyb.common.a.f518a);
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(com.tencent.hlyyb.common.a.c);
                map.put("B4", sb2.toString());
                if (!android.text.TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.a.f600a)) {
                    map.put("B5", com.tencent.hlyyb.downloader.a.a.f600a);
                }
                map.put("B6", com.tencent.hlyyb.common.a.h());
                if (!android.text.TextUtils.isEmpty(hVar.c)) {
                    map.put("B7", hVar.c);
                }
                if (!android.text.TextUtils.isEmpty(hVar.d)) {
                    map.put("B8", hVar.d);
                }
                if (!android.text.TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.a.b)) {
                    map.put("B9", com.tencent.hlyyb.downloader.a.a.b);
                }
                if (!android.text.TextUtils.isEmpty(com.tencent.hlyyb.downloader.a.a.c)) {
                    map.put("B10", com.tencent.hlyyb.downloader.a.a.c);
                }
                map.put("C13", hVar.getSavePath());
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(hVar.g);
                map.put("B14", sb3.toString());
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(hVar.j);
                map.put("B15", sb4.toString());
                if (hVar.f634a != -1) {
                    java.lang.StringBuilder sb5 = new java.lang.StringBuilder();
                    sb5.append(hVar.f634a);
                    map.put("B18", sb5.toString());
                }
                if (!android.text.TextUtils.isEmpty(hVar.b)) {
                    map.put("B19", hVar.b);
                }
                java.lang.StringBuilder sb6 = new java.lang.StringBuilder();
                sb6.append(failCode);
                map.put("B21", sb6.toString());
                java.lang.StringBuilder sb7 = new java.lang.StringBuilder();
                sb7.append(i);
                map.put("B22", sb7.toString());
                map.put("B23", hVar.o());
                if (!android.text.TextUtils.isEmpty(hVar.y)) {
                    map.put("B24", hVar.y);
                }
                java.lang.StringBuilder sb8 = new java.lang.StringBuilder();
                sb8.append(com.tencent.hlyyb.common.a.f.h());
                map.put("B25", sb8.toString());
                java.lang.StringBuilder sb9 = new java.lang.StringBuilder();
                sb9.append(hVar.isSupportRange() ? 1 : 0);
                map.put("B28", sb9.toString());
                java.lang.StringBuilder sb10 = new java.lang.StringBuilder();
                sb10.append(hVar.getCategory().ordinal());
                map.put("B85", sb10.toString());
                java.lang.StringBuilder sb11 = new java.lang.StringBuilder();
                sb11.append(hVar.j());
                map.put("B33", sb11.toString());
                if (hVar.getKnownSize() > 0) {
                    java.lang.StringBuilder sb12 = new java.lang.StringBuilder();
                    sb12.append(hVar.getKnownSize());
                    map.put("B34", sb12.toString());
                }
                if (i != 0) {
                    hVar.v = android.os.SystemClock.elapsedRealtime();
                }
                long j = -1;
                if (hVar.u > 0 && hVar.v > hVar.u) {
                    j = hVar.v - hVar.u;
                }
                java.lang.StringBuilder sb13 = new java.lang.StringBuilder();
                sb13.append(j);
                map.put("B38", sb13.toString());
                java.lang.StringBuilder sb14 = new java.lang.StringBuilder();
                sb14.append(hVar.getReceivedLength());
                map.put("B41", sb14.toString());
                java.lang.StringBuilder sb15 = new java.lang.StringBuilder();
                sb15.append(hVar.o);
                map.put("B44", sb15.toString());
                java.lang.StringBuilder sb16 = new java.lang.StringBuilder();
                sb16.append(hVar.p.getAndSet(0L));
                map.put("B45", sb16.toString());
                if (hVar.w) {
                    map.put("B46", "1");
                }
                java.lang.StringBuilder sb17 = new java.lang.StringBuilder();
                sb17.append(hVar.f());
                map.put("B66", sb17.toString());
                if (i == 0 && hVar.A > 0) {
                    java.lang.StringBuilder sb18 = new java.lang.StringBuilder();
                    sb18.append(hVar.A);
                    map.put("B77", sb18.toString());
                }
                if (com.tencent.hlyyb.common.a.e.a("down_report_detail", 0, 1, 1) == 1) {
                    if (failCode == -40 || failCode == -12 || failCode == -45) {
                        java.lang.StringBuilder sb19 = new java.lang.StringBuilder();
                        sb19.append(com.tencent.hlyyb.common.a.e.c());
                        map.put("C11", sb19.toString());
                        java.lang.StringBuilder sb20 = new java.lang.StringBuilder();
                        sb20.append(com.tencent.hlyyb.common.a.e.b());
                        map.put("C12", sb20.toString());
                    }
                    long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
                    java.lang.StringBuilder sb21 = new java.lang.StringBuilder();
                    sb21.append(hVar.t);
                    map.put("C16", sb21.toString());
                    java.lang.StringBuilder sb22 = new java.lang.StringBuilder();
                    sb22.append(jCurrentTimeMillis);
                    map.put("C17", sb22.toString());
                    map.put("C20", com.tencent.hlyyb.common.f.c.b(hVar.getFailInfo()));
                    java.lang.String strL = hVar.l();
                    int length = strL.length();
                    if (length > 600) {
                        strL = strL.substring(0, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_INTERRUPTED) + "|" + length;
                    }
                    map.put("C26", strL);
                    java.lang.StringBuilder sb23 = new java.lang.StringBuilder();
                    sb23.append(hVar.z);
                    map.put("C27", sb23.toString());
                    java.lang.String strM = hVar.m();
                    int length2 = strM.length();
                    if (length2 > 2000) {
                        strM = strM.substring(0, 2000) + "|" + length2;
                    }
                    map.put("C37", strM);
                    if (i == 0 && hVar.d() > 1000) {
                        java.lang.StringBuilder sb24 = new java.lang.StringBuilder();
                        sb24.append(hVar.d());
                        map.put("C48", sb24.toString());
                    }
                    if (hVar.h() > 1000) {
                        java.lang.StringBuilder sb25 = new java.lang.StringBuilder();
                        sb25.append(hVar.h());
                        map.put("C72", sb25.toString());
                    }
                    if (hVar.g()) {
                        map.put("C74", "1");
                    }
                    map.put("C78", hVar.n());
                    map.put("C79", hVar.k());
                    if (!android.text.TextUtils.isEmpty(hVar.x)) {
                        map.put("C80", hVar.x);
                    }
                    map.put("B90", hVar.p());
                    map.put("B91", hVar.q());
                    java.lang.String strR = hVar.r();
                    if (!android.text.TextUtils.isEmpty(strR)) {
                        map.put("C92", strR);
                    }
                    java.lang.String strS = hVar.s();
                    if (!android.text.TextUtils.isEmpty(strS)) {
                        map.put("C93", strS);
                    }
                    java.lang.StringBuilder sb26 = new java.lang.StringBuilder();
                    sb26.append(hVar.u());
                    map.put("C94", sb26.toString());
                }
                if (i == 2 && hVar.isPausedOnMobile()) {
                    map.put("B87", "1");
                }
                map.put("D1", com.tencent.hlyyb.common.a.d());
                java.lang.StringBuilder sb27 = new java.lang.StringBuilder();
                sb27.append(com.tencent.hlyyb.common.a.e());
                map.put("D2", sb27.toString());
                com.tencent.hlyyb.common.a.e.a(str, failCode == 0, map, false, true);
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean g() {
        synchronized (this.b) {
            for (com.tencent.hlyyb.downloader.e.h hVar : this.b) {
                if (hVar.isRunning() || hVar.isWaiting()) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x002e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:44:0x002d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:0x002b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0037 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:47:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:48:0x0034 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:49:0x0040 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:50:0x003f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x003d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x0049 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:53:0x0048 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:64:0x000e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x000e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x000e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x000e A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.util.List a(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        synchronized (this.b) {
            for (com.tencent.hlyyb.downloader.e.h hVar : this.b) {
                if (hVar.isEaseTask()) {
                    if (z2) {
                        if (hVar.isRunning()) {
                            if (z3) {
                                linkedList.add(hVar);
                            }
                        } else if (hVar.isWaiting()) {
                            if (z4) {
                                linkedList.add(hVar);
                            }
                        } else if (hVar.isPaused()) {
                            if (z5) {
                                linkedList.add(hVar);
                            }
                        } else if (hVar.isFailed()) {
                            if (z6) {
                                linkedList.add(hVar);
                            }
                        } else if (!hVar.isCompleted() && z7) {
                            linkedList.add(hVar);
                        }
                    }
                } else if (z) {
                    if (hVar.isRunning()) {
                        if (z3) {
                            linkedList.add(hVar);
                        }
                    } else if (hVar.isWaiting()) {
                        if (z4) {
                            linkedList.add(hVar);
                        }
                    } else if (hVar.isPaused()) {
                        if (z5) {
                            linkedList.add(hVar);
                        }
                    } else if (hVar.isFailed()) {
                        if (z6) {
                            linkedList.add(hVar);
                        }
                    } else if (!hVar.isCompleted()) {
                    }
                }
            }
        }
        return linkedList;
    }

    @Override // com.tencent.hlyyb.common.a.g
    public final void a(int i, java.lang.String str) {
        java.util.List listD = d();
        if (listD.size() > 0) {
            java.util.Iterator it = listD.iterator();
            while (it.hasNext()) {
                ((com.tencent.hlyyb.downloader.e.h) ((com.tencent.hlyyb.downloader.DownloaderTask) it.next())).a(i, str);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0081 A[Catch: all -> 0x00a6, PHI: r0
  0x0081: PHI (r0v3 java.lang.String) = (r0v0 java.lang.String), (r0v7 java.lang.String) binds: [B:13:0x001f, B:27:0x007d] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {, blocks: (B:9:0x000d, B:11:0x0015, B:12:0x0019, B:14:0x0021, B:15:0x0029, B:17:0x002f, B:19:0x0041, B:21:0x004e, B:23:0x0057, B:25:0x005d, B:22:0x0053, B:26:0x0077, B:28:0x007f, B:30:0x0081, B:31:0x0083, B:47:0x00a2, B:50:0x00a5, B:32:0x0084, B:33:0x0089, B:34:0x008a, B:39:0x0091, B:40:0x0097, B:46:0x00a1), top: B:63:0x000d, inners: #0, #3 }] */
    /* JADX WARN: Code duplicated, block: B:61:0x0084 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) throws com.tencent.hlyyb.common.HalleyException {
        java.lang.String localizedMessage = "";
        if (downloaderTask == null || !(downloaderTask instanceof com.tencent.hlyyb.downloader.e.h)) {
            localizedMessage = "param task not illegal.";
        } else {
            com.tencent.hlyyb.downloader.e.h hVar = (com.tencent.hlyyb.downloader.e.h) downloaderTask;
            synchronized (this) {
                if (com.tencent.hlyyb.common.f.c.a(hVar.i)) {
                    hVar.i = "";
                }
                if (com.tencent.hlyyb.downloader.a.a.g(hVar.i)) {
                    for (com.tencent.hlyyb.downloader.DownloaderTask downloaderTask2 : c()) {
                        if (hVar.h.equalsIgnoreCase(downloaderTask2.getSaveDir())) {
                            if (hVar.i.equalsIgnoreCase(com.tencent.hlyyb.downloader.a.a.g(((com.tencent.hlyyb.downloader.e.h) downloaderTask2).i) ? downloaderTask2.getInitSaveName() : downloaderTask2.getRealSaveName())) {
                                localizedMessage = "Can not add new task, another task exists with the same path:" + hVar.h + "/" + hVar.i;
                                break;
                            }
                        }
                    }
                    if ("".equals(localizedMessage)) {
                        synchronized (this.b) {
                            this.b.add(hVar);
                        }
                        try {
                            hVar.c();
                        } catch (com.tencent.hlyyb.common.HalleyException e) {
                            localizedMessage = e.getLocalizedMessage();
                            synchronized (this.b) {
                                this.b.remove(hVar);
                            }
                        }
                    }
                } else {
                    synchronized (this.b) {
                        this.b.add(hVar);
                        hVar.c();
                    }
                }
            }
        }
        if (!"".equals(localizedMessage)) {
            throw new com.tencent.hlyyb.common.HalleyException(localizedMessage);
        }
    }

    public final void a(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask, boolean z) {
        if (downloaderTask == null) {
            return;
        }
        com.tencent.hlyyb.downloader.e.h hVar = (com.tencent.hlyyb.downloader.e.h) downloaderTask;
        hVar.a(z);
        synchronized (this.b) {
            this.b.remove(downloaderTask);
        }
        a(hVar, 3);
        if (g()) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void a(java.lang.String str, boolean z) {
        com.tencent.hlyyb.downloader.e.h hVar;
        synchronized (this.b) {
            java.util.Iterator it = this.b.iterator();
            do {
                if (!it.hasNext()) {
                    hVar = null;
                    break;
                }
                hVar = (com.tencent.hlyyb.downloader.e.h) it.next();
            } while (!hVar.getUniqueKey().equals(str));
        }
        if (hVar != null) {
            a(hVar, z);
        }
    }

    public final void b() {
        com.tencent.hlyyb.downloader.e.a.c cVar = this.c;
        if (cVar != null) {
            cVar.c();
        }
    }

    public final java.util.List c() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        synchronized (this.b) {
            linkedList.addAll(this.b);
        }
        return linkedList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final java.util.List d() {
        java.util.LinkedList linkedList = new java.util.LinkedList();
        synchronized (this.b) {
            for (com.tencent.hlyyb.downloader.e.h hVar : this.b) {
                if (hVar.isRunning()) {
                    linkedList.add(hVar);
                }
            }
        }
        return linkedList;
    }

    @Override // com.tencent.hlyyb.downloader.e.a.d
    public final boolean e() {
        java.util.List listD = d();
        int size = listD.size();
        java.util.Iterator it = listD.iterator();
        boolean z = false;
        while (it.hasNext()) {
            com.tencent.hlyyb.downloader.e.h hVar = (com.tencent.hlyyb.downloader.e.h) ((com.tencent.hlyyb.downloader.DownloaderTask) it.next());
            hVar.a(size);
            if (hVar.isRunning() ? hVar.b() : false) {
                z = true;
            }
        }
        return z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final long f() {
        long jI;
        synchronized (this.b) {
            jI = 0;
            for (com.tencent.hlyyb.downloader.e.h hVar : this.b) {
                if (hVar.isRunning()) {
                    jI += hVar.i();
                }
            }
        }
        return jI;
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskCompletedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        if (g()) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskCompletedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        a((com.tencent.hlyyb.downloader.e.h) downloaderTask, 0);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskDetectedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskDetectedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskFailedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        if (g()) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskFailedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        a((com.tencent.hlyyb.downloader.e.h) downloaderTask, 1);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskPausedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        if (g()) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskPausedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        a((com.tencent.hlyyb.downloader.e.h) downloaderTask, 2);
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskPendingMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskReceivedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskReceivedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskStartedMainloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
        if (g()) {
            this.c.a();
        } else {
            this.c.b();
        }
    }

    @Override // com.tencent.hlyyb.downloader.DownloaderTaskListener
    public final void onTaskStartedSubloop(com.tencent.hlyyb.downloader.DownloaderTask downloaderTask) {
    }
}
