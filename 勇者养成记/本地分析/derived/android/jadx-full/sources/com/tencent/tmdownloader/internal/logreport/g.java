package com.tencent.tmdownloader.internal.logreport;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g extends com.tencent.tmdownloader.internal.logreport.b {
    protected static com.tencent.tmdownloader.internal.logreport.g d;

    protected g() {
    }

    public static synchronized com.tencent.tmdownloader.internal.logreport.g h() {
        if (d == null) {
            d = new com.tencent.tmdownloader.internal.logreport.g();
        }
        return d;
    }

    public void a(java.lang.String str, byte b) {
        com.tencent.tmassistantbase.util.TMLog.i("InstallReportManager", " buildInstallLogInfo: " + str);
        com.tencent.tmdownloader.internal.downloadservice.d dVarC = com.tencent.tmdownloader.internal.b.a.a().c(str);
        if (dVarC != null) {
            com.tencent.tmdownloader.internal.protocol.jce.InstalledStatLogInfo installedStatLogInfo = new com.tencent.tmdownloader.internal.protocol.jce.InstalledStatLogInfo();
            installedStatLogInfo.appId = dVarC.r;
            installedStatLogInfo.channelId = dVarC.A;
            installedStatLogInfo.downloadDate = dVarC.w;
            installedStatLogInfo.extradata = dVarC.C;
            installedStatLogInfo.taskPackageName = dVarC.s;
            installedStatLogInfo.taskVersioncode = dVarC.t;
            installedStatLogInfo.time = java.lang.System.currentTimeMillis();
            installedStatLogInfo.uin = dVarC.x;
            installedStatLogInfo.uintype = dVarC.y;
            installedStatLogInfo.via = dVarC.z;
            installedStatLogInfo.type = b;
            installedStatLogInfo.sdkVersionInfo = "1004";
            a(installedStatLogInfo);
            c();
            d();
            com.tencent.tmassistantbase.util.TMLog.i("InstallReportManager", " install log msg: " + installedStatLogInfo.toString());
        }
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected com.tencent.tmdownloader.internal.b.c.a e() {
        return com.tencent.tmdownloader.internal.b.c.k.f();
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected byte f() {
        return (byte) 5;
    }

    @Override // com.tencent.tmdownloader.internal.logreport.b
    protected boolean g() {
        return true;
    }
}
