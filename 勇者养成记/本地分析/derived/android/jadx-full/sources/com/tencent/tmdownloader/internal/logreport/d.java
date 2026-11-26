package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d extends com.tencent.tmdownloader.internal.logreport.b {
    protected static com.tencent.tmdownloader.internal.logreport.d d;

    protected d() {
    }

    public static com.tencent.tmdownloader.internal.protocol.jce.DownloadQualityLogInfo a(com.tencent.tmdownloader.internal.downloadservice.d dVar) {
        com.tencent.tmdownloader.internal.protocol.jce.DownloadQualityLogInfo downloadQualityLogInfo = new com.tencent.tmdownloader.internal.protocol.jce.DownloadQualityLogInfo();
        if (dVar != null) {
            downloadQualityLogInfo.taskId = dVar.d;
            downloadQualityLogInfo.sdkVersion = "1004";
            downloadQualityLogInfo.usedcard = com.tencent.tmdownloader.internal.b.b.a(dVar.j);
            downloadQualityLogInfo.memorySize = com.tencent.tmdownloader.internal.downloadservice.c.c();
            downloadQualityLogInfo.remainsdCardSize = com.tencent.tmdownloader.internal.downloadservice.c.d();
            downloadQualityLogInfo.pkg_size = dVar.i;
            downloadQualityLogInfo.startTime = dVar.v;
            downloadQualityLogInfo.downType = (byte) dVar.D;
            downloadQualityLogInfo.extMsg = dVar.E;
            downloadQualityLogInfo.taskResult = dVar.m;
            downloadQualityLogInfo.result = (byte) dVar.g;
            downloadQualityLogInfo.downloadChunkLogList = b(downloadQualityLogInfo.taskId);
            com.tencent.tmassistantbase.util.TMLog.i("DownloadQualityReportManager", "qulitylogInfo : info.taskId = " + downloadQualityLogInfo.taskId + " info.sdkVersion = " + downloadQualityLogInfo.sdkVersion + "info.usedcard = " + downloadQualityLogInfo.usedcard + " info.memorySize = " + downloadQualityLogInfo.memorySize + " info.remainsdCardSize = " + downloadQualityLogInfo.remainsdCardSize + " info.pkg_size = " + downloadQualityLogInfo.pkg_size + " info.startTime = " + downloadQualityLogInfo.startTime + " info.endTime= " + downloadQualityLogInfo.endTime + " info.extMsg =" + downloadQualityLogInfo.extMsg + "info.downType = " + ((int) downloadQualityLogInfo.downType) + "info.taskResult =" + downloadQualityLogInfo.taskResult + "info.Result =" + ((int) downloadQualityLogInfo.result));
            java.util.ArrayList arrayList = downloadQualityLogInfo.downloadChunkLogList;
            if (arrayList != null && !arrayList.isEmpty()) {
                for (com.tencent.tmdownloader.internal.protocol.jce.DownloadNewChunkLogInfo downloadNewChunkLogInfo : downloadQualityLogInfo.downloadChunkLogList) {
                    com.tencent.tmassistantbase.util.TMLog.i("DownloadQualityReportManager", "downloadChunkLogList: chunkinfo.segId =" + downloadNewChunkLogInfo.segId + " chunkinfo.taskId = " + downloadNewChunkLogInfo.taskId + "chunkinfo.downUrl = " + downloadNewChunkLogInfo.downUrl + " chunkinfo.jumpUrl=" + downloadNewChunkLogInfo.jumpUrl + "chunkinfo.finalDownloadUrl = " + downloadNewChunkLogInfo.finalDownloadUrl + " chunkinfo.networkType = " + downloadNewChunkLogInfo.networkType + " chunkinfo.contentType= " + downloadNewChunkLogInfo.contentType + " chunkinfo.down_Size=" + downloadNewChunkLogInfo.down_Size + " chunkinfo.costTime =" + downloadNewChunkLogInfo.costTime + " chunkinfo.startTime= " + downloadNewChunkLogInfo.startTime + " chunkinfo.endTime= " + downloadNewChunkLogInfo.endTime + " chunkinfo.taskResult = " + downloadNewChunkLogInfo.taskResult + " chunkinfo.result = " + ((int) downloadNewChunkLogInfo.result));
                }
            }
        }
        return downloadQualityLogInfo;
    }

    public static synchronized void a(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("DownloadQualityReportManager", "delDownloadNewChunkLogData enter:" + str);
        if (!android.text.TextUtils.isEmpty(str)) {
            com.tencent.tmdownloader.internal.b.c.f.a(str);
        }
        com.tencent.tmassistantbase.util.TMLog.i("DownloadQualityReportManager", "exit");
    }

    public static java.util.ArrayList b(java.lang.String str) {
        com.tencent.tmassistantbase.util.TMLog.i("DownloadQualityReportManager", "getDownloadNewChunkLogInfoList enter:" + str);
        if (!android.text.TextUtils.isEmpty(str)) {
            return com.tencent.tmdownloader.internal.b.c.f.b(str);
        }
        com.tencent.tmassistantbase.util.TMLog.i("DownloadQualityReportManager", "exit");
        return null;
    }

    public static synchronized com.tencent.tmdownloader.internal.logreport.d h() {
        if (d == null) {
            d = new com.tencent.tmdownloader.internal.logreport.d();
        }
        return d;
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected com.tencent.tmdownloader.internal.b.c.a e() {
        return com.tencent.tmdownloader.internal.b.c.i.f();
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected byte f() {
        return (byte) 6;
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected boolean g() {
        return false;
    }
}
