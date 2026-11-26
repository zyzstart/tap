package com.tencent.tmdownloader.internal.downloadservice.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.tmdownloader.internal.downloadservice.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected java.util.ArrayList f1130a = new java.util.ArrayList();
    protected com.tencent.tmdownloader.internal.downloadservice.a.a b = null;

    public c(java.util.ArrayList arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        this.f1130a.addAll(arrayList);
    }

    public int a(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.String str4, java.util.Map map, android.os.Bundle bundle) {
        java.lang.StringBuilder sb;
        java.lang.String str5;
        if (str == null || str2 == null) {
            return 3;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str);
        if (d(str, str2) != null) {
            sb = new java.lang.StringBuilder();
            sb.append("clientKey:");
            sb.append(str);
            str5 = ",taskItem is not null";
        } else {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is null");
            java.util.ArrayList arrayListA = a(str2);
            com.tencent.tmdownloader.internal.downloadservice.a.b bVar = new com.tencent.tmdownloader.internal.downloadservice.a.b(str, str2);
            bVar.c = 1;
            this.f1130a.add(bVar);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",add newTask");
            java.util.Iterator it = arrayListA.iterator();
            boolean z = false;
            boolean z2 = false;
            while (it.hasNext()) {
                int i2 = ((com.tencent.tmdownloader.internal.downloadservice.a.b) it.next()).c;
                if (i2 == 2) {
                    z = true;
                } else if (i2 == 1) {
                    z2 = true;
                }
            }
            if (z || z2) {
                if (z) {
                    bVar.c = 2;
                } else if (z2) {
                    bVar.c = 1;
                }
                com.tencent.tmdownloader.internal.downloadservice.a.a aVar = this.b;
                if (aVar != null) {
                    aVar.OnDownloadStateChanged(str, str2, bVar.c, 0, null);
                }
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",newTask is downloading");
                return 0;
            }
            sb = new java.lang.StringBuilder();
            sb.append("clientKey:");
            sb.append(str);
            str5 = ",start newTask download";
        }
        sb.append(str5);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", sb.toString());
        return com.tencent.tmdownloader.internal.downloadservice.a.b().a(str2, i, str3, str4, map, bundle);
    }

    public com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo a(java.lang.String str, java.lang.String str2) {
        com.tencent.tmdownloader.internal.downloadservice.d dVarC = com.tencent.tmdownloader.internal.downloadservice.a.b().c(str2);
        if (dVarC != null) {
            java.lang.String str3 = dVarC.b;
            java.lang.String strA = com.tencent.tmdownloader.internal.b.b.a(dVarC.j);
            int i = dVarC.g;
            long j = dVarC.h;
            long j2 = dVarC.i;
            com.tencent.tmassistantbase.util.TMLog.d("TMSelfUpdate_ServiceDownloadTaskManager", "getDownloadTaskInfo url=" + str2 + ",state=" + i);
            return new com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo(str3, strA, i, j, j2, dVarC.f1133a);
        }
        if (!com.tencent.tmdownloader.internal.downloadservice.c.b(str2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK)) {
            if (!com.tencent.tmdownloader.internal.downloadservice.c.b(str2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF)) {
                b(str2);
                return null;
            }
            java.lang.String strA2 = com.tencent.tmdownloader.internal.downloadservice.c.a(str2, com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF);
            java.lang.String strA3 = com.tencent.tmdownloader.internal.b.b.a(strA2);
            com.tencent.tmdownloader.internal.b.b bVar = new com.tencent.tmdownloader.internal.b.b(strA2, strA2);
            return new com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo(str2, strA3, 4, bVar.c(), bVar.c(), com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APKDIFF);
        }
        java.lang.String strB = com.tencent.tmdownloader.internal.downloadservice.c.b(str2);
        java.lang.String strA4 = com.tencent.tmdownloader.internal.b.b.a(strB);
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "getDownloadTaskInfo url=" + str2 + ",fileName=" + strB + ",savePath=" + strA4);
        com.tencent.tmdownloader.internal.b.b bVar2 = new com.tencent.tmdownloader.internal.b.b(strB, strB);
        return new com.tencent.tmassistantbase.aidl.TMAssistantDownloadTaskInfo(str2, strA4, 4, bVar2.c(), bVar2.c(), com.tencent.tmassistantbase.common.download.TMAssistantDownloadContentType.CONTENT_TYPE_APK);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized java.util.ArrayList a(java.lang.String str) {
        if (str == null) {
            return null;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.tencent.tmdownloader.internal.downloadservice.a.b bVar : this.f1130a) {
            if (bVar.b.equals(str)) {
                arrayList.add(bVar);
            }
        }
        return arrayList;
    }

    public void a() {
        com.tencent.tmdownloader.internal.downloadservice.a.b().a(this);
    }

    public void a(com.tencent.tmdownloader.internal.downloadservice.a.a aVar) {
        this.b = aVar;
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.h
    public void a(java.lang.String str, int i, int i2, java.lang.String str2) {
        java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.a.b> arrayListA;
        if (this.b == null || (arrayListA = a(str)) == null || arrayListA.size() <= 0) {
            return;
        }
        for (com.tencent.tmdownloader.internal.downloadservice.a.b bVar : arrayListA) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + bVar.f1129a + ",state:" + i + ",errorcode:" + i2 + ",url:" + str.hashCode());
            bVar.c = i;
            this.b.OnDownloadStateChanged(bVar.f1129a, str, i, i2, str2);
        }
    }

    @Override // com.tencent.tmdownloader.internal.downloadservice.h
    public void a(java.lang.String str, long j, long j2) {
        java.util.ArrayList<com.tencent.tmdownloader.internal.downloadservice.a.b> arrayListA;
        if (this.b == null || (arrayListA = a(str)) == null || arrayListA.size() <= 0) {
            return;
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        for (com.tencent.tmdownloader.internal.downloadservice.a.b bVar : arrayListA) {
            if (bVar.a(j, j2, jCurrentTimeMillis)) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + bVar.f1129a + ",receivedLen:" + j + ",url:" + str.hashCode());
                this.b.OnDownloadProgressChanged(bVar.f1129a, str, j, j2);
            }
        }
    }

    public void b() {
        com.tencent.tmdownloader.internal.downloadservice.a.b().b(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected synchronized void b(java.lang.String str) {
        if (str == null) {
            return;
        }
        java.util.ArrayList arrayList = new java.util.ArrayList();
        for (com.tencent.tmdownloader.internal.downloadservice.a.b bVar : this.f1130a) {
            if (bVar.b.equals(str)) {
                arrayList.add(bVar);
            }
        }
        if (arrayList.size() > 0) {
            this.f1130a.removeAll(arrayList);
        }
    }

    public void b(java.lang.String str, java.lang.String str2) {
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "enter");
        if (str == null || str2 == null) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + "; url: " + str2);
        com.tencent.tmdownloader.internal.downloadservice.a.b bVarD = d(str, str2);
        if (bVarD != null) {
            bVarD.c = 3;
            this.f1130a.remove(bVarD);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",remove taskItem");
            java.util.ArrayList arrayListA = a(str2);
            if (arrayListA == null || arrayListA.size() == 0) {
                com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is the only on pauseAll");
                com.tencent.tmdownloader.internal.downloadservice.a.b().a(str2);
            }
            com.tencent.tmdownloader.internal.downloadservice.a.a aVar = this.b;
            if (aVar != null) {
                aVar.OnDownloadStateChanged(str, str2, bVarD.c, 0, null);
            }
        } else {
            com.tencent.tmassistantbase.util.TMLog.w("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is null");
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "exit");
    }

    public void c(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str);
        com.tencent.tmdownloader.internal.downloadservice.a.b bVarD = d(str, str2);
        if (bVarD != null) {
            this.f1130a.remove(bVarD);
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",remove taskItem");
        } else {
            com.tencent.tmassistantbase.util.TMLog.w("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is null");
        }
        java.util.ArrayList arrayListA = a(str2);
        if (arrayListA == null || arrayListA.size() == 0) {
            com.tencent.tmassistantbase.util.TMLog.i("TMSelfUpdate_ServiceDownloadTaskManager", "clientKey:" + str + ",taskItem is the only on cancelAll");
            com.tencent.tmdownloader.internal.downloadservice.a.b().b(str2);
        }
    }

    protected synchronized com.tencent.tmdownloader.internal.downloadservice.a.b d(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return null;
        }
        for (com.tencent.tmdownloader.internal.downloadservice.a.b bVar : this.f1130a) {
            java.lang.String str3 = bVar.f1129a;
            if (str3 != null && str3.equals(str) && bVar.b.equals(str2)) {
                return bVar;
            }
        }
        return null;
    }
}
