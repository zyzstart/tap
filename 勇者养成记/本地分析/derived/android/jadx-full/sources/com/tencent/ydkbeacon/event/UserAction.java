package com.tencent.ydkbeacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@java.lang.Deprecated
public class UserAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1247a;
    private static java.lang.String c;
    public static android.content.Context mContext;
    private static com.tencent.ydkbeacon.event.open.BeaconConfig.Builder b = com.tencent.ydkbeacon.event.open.BeaconConfig.builder();
    private static boolean d = true;

    @java.lang.Deprecated
    public static void closeUseInfoEvent() {
    }

    public static void doUploadRecords() {
        com.tencent.ydkbeacon.module.EventModule eventModule = (com.tencent.ydkbeacon.module.EventModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.EVENT);
        if (eventModule != null) {
            eventModule.a(false);
        }
    }

    public static void flushObjectsToDB(boolean z) {
    }

    public static java.util.Map getAdditionalInfo() {
        return getAdditionalInfo(null);
    }

    public static java.util.Map getAdditionalInfo(java.lang.String str) {
        com.tencent.ydkbeacon.module.EventModule eventModule = (com.tencent.ydkbeacon.module.EventModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.EVENT);
        if (eventModule != null) {
            return eventModule.a(str);
        }
        return null;
    }

    public static java.lang.String getAppKey() {
        return f1247a;
    }

    public static java.lang.String getCloudParas(java.lang.String str) {
        return "";
    }

    public static com.tencent.ydkbeacon.core.info.BeaconPubParams getCommonParams() {
        return com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().getCommonParams(mContext);
    }

    public static java.lang.String getEventDomain() {
        return com.tencent.ydkbeacon.base.net.c.b.c;
    }

    public static java.lang.String getQIMEI() {
        return com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getQimeiInternal();
    }

    public static void getQimei(com.tencent.ydkbeacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getQimei(iAsyncQimeiListener);
    }

    public static java.lang.String getQimeiByKey(java.lang.String str) {
        com.tencent.ydkbeacon.qimei.Qimei qimei = com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().getQimei();
        return (qimei == null || qimei.isEmpty()) ? "" : (java.lang.String) qimei.getQimeiMap().get(str);
    }

    public static java.lang.String getQimeiNew() {
        com.tencent.ydkbeacon.qimei.Qimei qimei = com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().getQimei();
        return qimei != null ? qimei.getQimeiNew() : "";
    }

    @java.lang.Deprecated
    public static java.lang.String getRtQIMEI(android.content.Context context) {
        if (context == null) {
            return null;
        }
        com.tencent.ydkbeacon.a.c.c.d().a(context.getApplicationContext());
        return com.tencent.ydkbeacon.qimei.a.a().b().getQimeiOld();
    }

    public static java.lang.String getSDKVersion() {
        return com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().getSDKVersion();
    }

    public static java.lang.String getStrategyDomain() {
        return com.tencent.ydkbeacon.base.net.c.b.d;
    }

    public static java.lang.String getUserID(java.lang.String str) {
        com.tencent.ydkbeacon.module.EventModule eventModule = (com.tencent.ydkbeacon.module.EventModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.EVENT);
        return eventModule != null ? eventModule.b(str) : "";
    }

    public static void initUserAction(android.content.Context context) {
        initUserAction(context, true);
    }

    public static void initUserAction(android.content.Context context, boolean z) {
        initUserAction(context, z, 0L);
    }

    public static void initUserAction(android.content.Context context, boolean z, long j) {
        initUserAction(context, z, j, null, null);
    }

    @android.annotation.TargetApi(14)
    public static void initUserAction(android.content.Context context, boolean z, long j, com.tencent.ydkbeacon.upload.InitHandleListener initHandleListener, com.tencent.ydkbeacon.upload.UploadHandleListener uploadHandleListener) {
        if (!d) {
            android.util.Log.e("beacon", "UserAction.initUserAction is not available");
        } else {
            mContext = context;
            com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().start(context, f1247a, b.build());
        }
    }

    public static boolean loginEvent(boolean z, long j, java.util.Map map) {
        if (mContext != null) {
            map.put("A19", com.tencent.ydkbeacon.a.c.f.p().w());
        }
        return onUserAction("rqd_wgLogin", z, j, 0L, map, true);
    }

    public static boolean onDTUserAction(android.content.Context context, java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        java.util.HashMap map2;
        if (context == null) {
            return false;
        }
        if (map != null) {
            com.tencent.ydkbeacon.a.c.c.d().a(context);
            com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
            map2 = new java.util.HashMap(map);
            map2.put("dt_imei2", "" + fVarP.n());
            map2.put("dt_meid", "" + fVarP.u());
            map2.put("dt_mf", "" + fVarP.t());
        } else {
            map2 = null;
        }
        return onUserAction(str, z, j, j2, map2, z2, z3);
    }

    public static boolean onDTUserActionToTunnel(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map map, boolean z, boolean z2) {
        if (context == null) {
            return false;
        }
        if (map == null) {
            return onUserActionToTunnel(str, str2, null, z, z2);
        }
        com.tencent.ydkbeacon.a.c.c.d().a(context);
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        java.util.HashMap map2 = new java.util.HashMap(map);
        map2.put("dt_imei2", "" + fVarP.n());
        map2.put("dt_meid", "" + fVarP.u());
        map2.put("dt_mf", "" + fVarP.t());
        return onUserActionToTunnel(str, str2, map2, z, z2);
    }

    public static void onPageIn(java.lang.String str) {
        com.tencent.ydkbeacon.c.a.a(com.tencent.ydkbeacon.event.c.c.c(str));
    }

    public static void onPageOut(java.lang.String str) {
        com.tencent.ydkbeacon.c.a.b(com.tencent.ydkbeacon.event.c.c.c(str));
    }

    public static boolean onUserAction(java.lang.String str, java.util.Map map, boolean z, boolean z2) {
        return onUserAction(str, true, -1L, -1L, map, z, z2);
    }

    public static boolean onUserAction(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        return onUserAction(str, z, j, j2, map, z2, false);
    }

    public static boolean onUserAction(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        return com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withCode(str).withType(z2 ? com.tencent.ydkbeacon.event.open.EventType.REALTIME : com.tencent.ydkbeacon.event.open.EventType.NORMAL).withParams(map).withAppKey(f1247a).withIsSucceed(z).build()).isSuccess();
    }

    public static boolean onUserActionToTunnel(java.lang.String str, java.lang.String str2, java.util.Map map, boolean z, boolean z2) {
        return onUserActionToTunnel(str, str2, true, -1L, -1L, map, z, z2);
    }

    public static boolean onUserActionToTunnel(java.lang.String str, java.lang.String str2, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        return com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().report(com.tencent.ydkbeacon.event.open.BeaconEvent.builder().withCode(str2).withType(z2 ? com.tencent.ydkbeacon.event.open.EventType.REALTIME : com.tencent.ydkbeacon.event.open.EventType.NORMAL).withParams(map).withAppKey(str).withIsSucceed(z).build()).isSuccess();
    }

    public static void registerTunnel(com.tencent.ydkbeacon.upload.TunnelInfo tunnelInfo) {
    }

    public static void setAdditionalInfo(java.lang.String str, java.util.Map map) {
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setAdditionalParams(str, map);
    }

    public static void setAdditionalInfo(java.util.Map map) {
        setAdditionalInfo(null, map);
    }

    public static void setAppKey(java.lang.String str) {
        f1247a = str;
    }

    public static void setAppVersion(java.lang.String str) {
        c = str;
    }

    @java.lang.Deprecated
    public static void setAutoLaunchEventUsable(boolean z) {
    }

    public static void setChannelID(java.lang.String str) {
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setChannelID(str);
    }

    public static void setCollectImei(boolean z) {
        b.collectIMEIEnable(z);
    }

    public static void setCollectMAC(boolean z) {
        b.collectMACEnable(z);
    }

    public static void setJsClientId(java.lang.String str) {
    }

    public static void setLogAble(boolean z, boolean z2) {
        com.tencent.ydkbeacon.a.e.c.a(z);
        com.tencent.ydkbeacon.a.e.c.b(z);
    }

    public static void setOAID(java.lang.String str) {
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setOAID(str);
    }

    @java.lang.Deprecated
    public static void setOldInitMethodEnable(boolean z) {
        d = z;
    }

    public static void setOmgId(java.lang.String str) {
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setOmgID(str);
    }

    public static void setQQ(java.lang.String str) {
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setQQ(str);
    }

    public static void setReportDomain(java.lang.String str, java.lang.String str2) {
        com.tencent.ydkbeacon.base.net.c.b.a(str, str2);
    }

    public static void setReportIP(java.lang.String str, java.lang.String str2) {
        com.tencent.ydkbeacon.base.net.c.b.b(str, str2);
    }

    public static void setScheduledService(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        b.setExecutorService(scheduledExecutorService);
    }

    public static void setStrictMode(boolean z) {
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setStrictMode(z);
    }

    public static void setUploadMode(boolean z) {
        com.tencent.ydkbeacon.module.EventModule eventModule = (com.tencent.ydkbeacon.module.EventModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.EVENT);
        if (eventModule != null) {
            eventModule.b(z);
        } else {
            b.eventReportEnable(z);
        }
    }

    public static void setUserID(java.lang.String str) {
        setUserID(null, str);
    }

    public static void setUserID(java.lang.String str, java.lang.String str2) {
        com.tencent.ydkbeacon.event.open.BeaconReport.getInstance().setUserID(str, str2);
    }
}
