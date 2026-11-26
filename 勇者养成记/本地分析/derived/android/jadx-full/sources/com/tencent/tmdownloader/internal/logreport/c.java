package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c extends com.tencent.tmdownloader.internal.logreport.b {
    protected static final java.lang.String d = "com.tencent.tmdownloader.internal.logreport.c";
    protected static com.tencent.tmdownloader.internal.logreport.c e;

    protected c() {
    }

    public static synchronized com.tencent.tmdownloader.internal.protocol.jce.DownloadStatLogInfo a(com.tencent.tmdownloader.internal.downloadservice.d dVar) {
        com.tencent.tmdownloader.internal.protocol.jce.DownloadStatLogInfo downloadStatLogInfo;
        downloadStatLogInfo = new com.tencent.tmdownloader.internal.protocol.jce.DownloadStatLogInfo();
        if (dVar != null) {
            downloadStatLogInfo.appId = dVar.r;
            downloadStatLogInfo.taskPackageName = dVar.s;
            downloadStatLogInfo.taskVersioncode = dVar.t;
            downloadStatLogInfo.starTime = java.lang.System.currentTimeMillis();
            downloadStatLogInfo.clientIp = "";
            downloadStatLogInfo.errorCode = dVar.m;
            downloadStatLogInfo.totalFileSize = dVar.i;
            downloadStatLogInfo.result = (byte) dVar.g;
            downloadStatLogInfo.reportTime = java.lang.System.currentTimeMillis();
            downloadStatLogInfo.uin = dVar.x;
            downloadStatLogInfo.uintype = dVar.y;
            downloadStatLogInfo.sdkVersionInfo = "1004";
            downloadStatLogInfo.via = dVar.z;
            downloadStatLogInfo.channelId = dVar.A;
            downloadStatLogInfo.downType = (byte) dVar.D;
            downloadStatLogInfo.traceId = dVar.B;
            downloadStatLogInfo.extradata = dVar.C;
            com.tencent.tmassistantbase.util.TMLog.i("BusinessDownloadReportManager", "statlogInfo : | taskPackageName:" + downloadStatLogInfo.taskPackageName + " result:" + ((int) downloadStatLogInfo.result) + " downloadType:" + ((int) downloadStatLogInfo.downType) + " via:" + downloadStatLogInfo.via + " traceId:" + downloadStatLogInfo.traceId);
        }
        return downloadStatLogInfo;
    }

    public static synchronized com.tencent.tmdownloader.internal.logreport.c h() {
        if (e == null) {
            e = new com.tencent.tmdownloader.internal.logreport.c();
        }
        return e;
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected com.tencent.tmdownloader.internal.b.c.a e() {
        return com.tencent.tmdownloader.internal.b.c.c.f();
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected byte f() {
        return (byte) 4;
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected boolean g() {
        return false;
    }
}
