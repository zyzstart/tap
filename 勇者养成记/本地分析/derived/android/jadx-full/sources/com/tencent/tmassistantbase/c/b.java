package com.tencent.tmassistantbase.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements com.tencent.tmassistantbase.c.a, com.tencent.tmassistantbase.network.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.tmassistantbase.c.b f1014a;
    private com.tencent.tmassistantbase.c.e b;
    private android.os.Handler c;
    private android.util.SparseArray d = new android.util.SparseArray();
    private java.util.Map e = new java.util.concurrent.ConcurrentHashMap();
    private long f = 1800000;
    private int g = 50;
    private int h = 2;

    private b() {
        com.tencent.tmassistantbase.c.e eVar = new com.tencent.tmassistantbase.c.e();
        this.b = eVar;
        eVar.a(this);
        c();
        d();
        e();
    }

    private void a(java.util.ArrayList arrayList) {
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>cacheDataOnFailed enter");
        if (arrayList != null && arrayList.size() > 0) {
            android.util.SparseArray sparseArray = new android.util.SparseArray();
            java.util.Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                com.tencent.tmassistantbase.jce.StatItem statItem = (com.tencent.tmassistantbase.jce.StatItem) it.next();
                java.util.List arrayList2 = (java.util.List) sparseArray.get(statItem.type);
                if (arrayList2 == null) {
                    arrayList2 = new java.util.ArrayList();
                    sparseArray.put(statItem.type, arrayList2);
                }
                arrayList2.addAll(statItem.records);
            }
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                int iKeyAt = sparseArray.keyAt(i);
                java.util.List list = (java.util.List) sparseArray.get(iKeyAt);
                java.util.ArrayList arrayList3 = new java.util.ArrayList();
                java.util.Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    arrayList3.add((java.lang.String) it2.next());
                }
                com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>cacheDataOnFailed saveReportItemToDB type = " + iKeyAt + " saveData = " + com.tencent.tmassistantbase.util.s.a(arrayList3));
                com.tencent.tmdownloader.internal.b.c.d.a(java.lang.String.valueOf(iKeyAt), arrayList3);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>cacheDataOnFailed exit");
    }

    public static synchronized com.tencent.tmassistantbase.c.b b() {
        if (f1014a == null) {
            f1014a = new com.tencent.tmassistantbase.c.b();
        }
        return f1014a;
    }

    private void c() {
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().b();
        com.tencent.tmassistantbase.network.NetworkMonitorReceiver.a().a(this);
    }

    private void d() {
        com.tencent.tmdownloader.internal.a.a.b().c();
        com.tencent.tmapkupdatesdk.internal.logic.protocol.jce.BatchReportConfig batchReportConfigD = com.tencent.tmassistantbase.common.e.a().d();
        if (batchReportConfigD == null || batchReportConfigD.batchReportInterval <= 0) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>BatchReportConfig != null BatchReportConfig.batchReportInterval = " + batchReportConfigD.batchReportInterval + " BatchReportConfig.batchReportMaxCount = " + batchReportConfigD.batchReportMaxCount);
        this.f = batchReportConfigD.batchReportInterval;
        this.g = batchReportConfigD.batchReportMaxCount;
        this.h = batchReportConfigD.reportRetryCount;
    }

    private void e() {
        com.tencent.tmassistantbase.c.c cVar = new com.tencent.tmassistantbase.c.c(this, com.tencent.tmassistantbase.util.l.b(com.tencent.tmassistantbase.util.m.ID_SDK_REPORT));
        this.c = cVar;
        cVar.sendEmptyMessage(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        java.util.Map mapD = com.tencent.tmdownloader.internal.b.c.d.d();
        java.util.ArrayList<com.tencent.tmassistantbase.jce.StatItem> arrayList = new java.util.ArrayList();
        if (mapD != null && mapD.size() > 0) {
            java.util.Iterator it = mapD.keySet().iterator();
            while (it.hasNext()) {
                int iIntValue = ((java.lang.Integer) it.next()).intValue();
                java.util.ArrayList arrayList2 = (java.util.ArrayList) mapD.get(java.lang.Integer.valueOf(iIntValue));
                if (arrayList2.size() > 0) {
                    arrayList.add(new com.tencent.tmassistantbase.jce.StatItem(iIntValue, arrayList2));
                }
            }
        }
        if (arrayList.size() > 0) {
            this.b.a(arrayList);
            for (com.tencent.tmassistantbase.jce.StatItem statItem : arrayList) {
                com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", "batchReport type = " + statItem.type + " records = " + com.tencent.tmassistantbase.util.s.a(statItem.records));
            }
        }
        this.c.sendEmptyMessageDelayed(2, this.f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        java.util.Set setKeySet = this.e.keySet();
        if (setKeySet == null || setKeySet.size() <= 0) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = setKeySet.iterator();
        while (it.hasNext()) {
            int iIntValue = ((java.lang.Integer) it.next()).intValue();
            if (iIntValue > 0 && this.e.get(java.lang.Integer.valueOf(iIntValue)) != null) {
                com.tencent.tmassistantbase.jce.StatItem statItem = new com.tencent.tmassistantbase.jce.StatItem();
                statItem.type = iIntValue;
                statItem.records = (java.util.ArrayList) this.e.get(java.lang.Integer.valueOf(iIntValue));
                arrayList.add(statItem);
            }
        }
        this.e.clear();
        if (arrayList.size() > 0) {
            int iA = this.b.a(arrayList);
            com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", "timelyReport");
            this.d.put(iA, arrayList);
        }
    }

    @Override // com.tencent.tmassistantbase.network.d
    public void a() {
        com.tencent.tmassistantbase.util.l.a().post(new com.tencent.tmassistantbase.c.d(this));
    }

    @Override // com.tencent.tmassistantbase.c.a
    public void a(int i, com.tencent.tmassistantbase.jce.StatReportRequest statReportRequest, com.tencent.tmassistantbase.jce.StatReportResponse statReportResponse, int i2) {
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>onStatReportFinish reportLog onReportFinish errorCode = " + i2);
        java.util.ArrayList arrayList = (java.util.ArrayList) this.d.get(i);
        if (i2 != 0) {
            a(arrayList);
        }
        this.d.delete(i);
    }

    public void a(int i, java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>yybInstallReport enter");
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>yybInstallReport type = " + i + " data = " + str);
        if (i >= 0 && !android.text.TextUtils.isEmpty(str)) {
            java.util.ArrayList arrayList = (java.util.ArrayList) this.e.get(java.lang.Integer.valueOf(i));
            if (arrayList == null) {
                arrayList = new java.util.ArrayList();
                this.e.put(java.lang.Integer.valueOf(i), arrayList);
            }
            arrayList.add(str);
            this.c.removeMessages(1);
            this.c.sendEmptyMessageDelayed(1, 500L);
        }
        com.tencent.tmassistantbase.util.TMLog.i("SDKReportManager2", ">>yybInstallReport exit");
    }
}
