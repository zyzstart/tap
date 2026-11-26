package com.tencent.beacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserAction {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f201a = false;
    public static java.util.List beaconModules = new java.util.ArrayList();
    public static android.content.Context mContext;

    @java.lang.Deprecated
    public static void closeUseInfoEvent() {
    }

    public static void doUploadRecords() {
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.event.c());
    }

    public static void flushObjectsToDB(boolean z) {
        com.tencent.beacon.core.event.TunnelModule.flushObjectsToDB(z);
    }

    public static java.util.Map getAdditionalInfo() {
        return com.tencent.beacon.core.event.TunnelModule.getAdditionalInfo(null);
    }

    public static java.util.Map getAdditionalInfo(java.lang.String str) {
        return com.tencent.beacon.core.event.TunnelModule.getAdditionalInfo(str);
    }

    public static java.lang.String getAppKey() {
        return com.tencent.beacon.core.info.b.b;
    }

    public static java.lang.String getCloudParas(java.lang.String str) {
        java.util.Map mapE;
        if (mContext == null || (mapE = com.tencent.beacon.core.strategy.c.g().e()) == null) {
            return null;
        }
        return (java.lang.String) mapE.get(str);
    }

    public static com.tencent.beacon.core.info.BeaconPubParams getCommonParams() {
        return com.tencent.beacon.core.info.BeaconPubParams.getPubParams(getAppKey());
    }

    public static java.lang.String getEventDomain() {
        return com.tencent.beacon.core.c.a.b.c;
    }

    public static java.lang.String getQIMEI() {
        return com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimeiInternal(null);
    }

    public static void getQimei(com.tencent.beacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimei(iAsyncQimeiListener);
    }

    public static java.lang.String getQimeiByKey(java.lang.String str) {
        return com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimeiByKey(null, str);
    }

    public static java.lang.String getQimeiNew() {
        return com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimeiNew(null);
    }

    @java.lang.Deprecated
    public static java.lang.String getRtQIMEI(android.content.Context context) {
        try {
            java.lang.String strC = com.tencent.beacon.qimei.i.c(context);
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[userAction] load qimeiJson: ");
            sb.append(strC);
            com.tencent.beacon.core.e.d.a(sb.toString(), new java.lang.Object[0]);
            java.util.Map mapA = com.tencent.beacon.qimei.i.a(strC);
            if (mapA == null) {
                return "";
            }
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append("[userAction] get A3: ");
            sb2.append((java.lang.String) mapA.get("A3"));
            com.tencent.beacon.core.e.d.a(sb2.toString(), new java.lang.Object[0]);
            return (java.lang.String) mapA.get("A3");
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.b("load qimei error ", e.getMessage());
            return "";
        }
    }

    public static java.lang.String getSDKVersion() {
        return com.tencent.beacon.core.info.b.i();
    }

    public static java.lang.String getStrategyDomain() {
        return com.tencent.beacon.core.c.a.b.d;
    }

    public static java.lang.String getUserID(java.lang.String str) {
        return com.tencent.beacon.core.event.TunnelModule.getUserId(str);
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
    public static void initUserAction(android.content.Context context, boolean z, long j, com.tencent.beacon.upload.InitHandleListener initHandleListener, com.tencent.beacon.upload.UploadHandleListener uploadHandleListener) {
        if (mContext != null) {
            com.tencent.beacon.core.e.d.b("[core] SDK is already initialized.", new java.lang.Object[0]);
            return;
        }
        if (context == null) {
            com.tencent.beacon.core.e.d.i("[core] context is null! init failed!", new java.lang.Object[0]);
            return;
        }
        android.content.Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            mContext = applicationContext;
        } else {
            mContext = context;
        }
        synchronized (com.tencent.beacon.event.UserAction.class) {
            if (f201a) {
                return;
            }
            f201a = true;
            com.tencent.beacon.core.e.b.b(mContext);
            com.tencent.beacon.core.info.a.f(mContext);
            if (java.lang.Integer.valueOf(android.os.Build.VERSION.SDK).intValue() >= 14) {
                ((android.app.Application) mContext).registerActivityLifecycleCallbacks(new com.tencent.beacon.core.a.j());
                ((android.app.Application) mContext).registerActivityLifecycleCallbacks(new com.tencent.beacon.core.a.k());
            } else {
                com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.a.b(mContext));
            }
            com.tencent.beacon.core.d.k.a(mContext).b(z);
            if (uploadHandleListener != null) {
                com.tencent.beacon.core.d.k.a(mContext).a(uploadHandleListener);
            }
            com.tencent.beacon.core.b.f.a().a(context);
            com.tencent.beacon.core.d.i.a(context).a(com.tencent.beacon.upload.UploadStrategy.defaultErrorRandomBound);
            com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.event.b(context, initHandleListener, j));
        }
    }

    public static boolean loginEvent(boolean z, long j, java.util.Map map) {
        android.content.Context context = mContext;
        if (context != null) {
            map.put("A33", com.tencent.beacon.core.info.e.d(context).k(mContext));
        }
        return onUserAction("rqd_wgLogin", z, j, 0L, map, true);
    }

    public static boolean onDTUserAction(android.content.Context context, java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        if (context == null) {
            return false;
        }
        if (map == null) {
            return onUserAction(str, z, j, j2, null, z2, z3);
        }
        com.tencent.beacon.core.info.c cVarA = com.tencent.beacon.core.info.c.a(context);
        java.util.HashMap map2 = new java.util.HashMap(map);
        map2.put("dt_imei2", "" + cVarA.d());
        map2.put("dt_meid", "" + cVarA.h());
        map2.put("dt_mf", "" + cVarA.g());
        return onUserAction(str, z, j, j2, map2, z2, z3);
    }

    public static boolean onDTUserActionToTunnel(android.content.Context context, java.lang.String str, java.lang.String str2, java.util.Map map, boolean z, boolean z2) {
        if (context == null) {
            return false;
        }
        if (map == null) {
            return onUserActionToTunnel(str, str2, null, z, z2);
        }
        com.tencent.beacon.core.info.c cVarA = com.tencent.beacon.core.info.c.a(context);
        java.util.HashMap map2 = new java.util.HashMap(map);
        map2.put("dt_imei2", "" + cVarA.d());
        map2.put("dt_meid", "" + cVarA.h());
        map2.put("dt_mf", "" + cVarA.g());
        return onUserActionToTunnel(str, str2, map2, z, z2);
    }

    public static void onPageIn(java.lang.String str) {
        com.tencent.beacon.core.event.k.a(com.tencent.beacon.core.e.c.c(str));
    }

    public static void onPageOut(java.lang.String str) {
        com.tencent.beacon.core.event.k.b(com.tencent.beacon.core.e.c.c(str));
    }

    public static boolean onUserAction(java.lang.String str, java.util.Map map, boolean z, boolean z2) {
        return onUserAction(str, true, -1L, -1L, map, z, z2);
    }

    public static boolean onUserAction(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        return onUserAction(str, z, j, j2, map, z2, false);
    }

    public static boolean onUserAction(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        com.tencent.beacon.core.e.i.a(map);
        return com.tencent.beacon.core.event.TunnelModule.onUserAction(null, str, z, j, j2, map, z2, z3);
    }

    public static boolean onUserActionToTunnel(java.lang.String str, java.lang.String str2, java.util.Map map, boolean z, boolean z2) {
        return onUserActionToTunnel(str, str2, true, -1L, -1L, map, z, z2);
    }

    public static boolean onUserActionToTunnel(java.lang.String str, java.lang.String str2, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        return com.tencent.beacon.core.event.TunnelModule.onUserAction(str, str2, z, j, j2, map, z2, z3);
    }

    public static void registerTunnel(com.tencent.beacon.upload.TunnelInfo tunnelInfo) {
        com.tencent.beacon.core.event.TunnelModule.registerTunnel(tunnelInfo);
    }

    public static void setAdditionalInfo(java.lang.String str, java.util.Map map) {
        com.tencent.beacon.core.event.TunnelModule.setAdditionalInfo(str, map);
    }

    public static void setAdditionalInfo(java.util.Map map) {
        com.tencent.beacon.core.event.TunnelModule.setAdditionalInfo(null, map);
    }

    public static void setAppKey(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return;
        }
        com.tencent.beacon.core.info.b.b = str;
        com.tencent.beacon.core.event.TunnelModule tunnelModule = com.tencent.beacon.core.event.TunnelModule.getInstance();
        if (tunnelModule != null) {
            tunnelModule.setAppKey(str);
        }
    }

    public static void setAppVersion(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return;
        }
        com.tencent.beacon.core.info.b.c = str;
    }

    @java.lang.Deprecated
    public static void setAutoLaunchEventUsable(boolean z) {
    }

    public static void setChannelID(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return;
        }
        com.tencent.beacon.core.info.b.d = com.tencent.beacon.core.e.c.a(str);
    }

    public static void setCollecProcessInfo(boolean z) {
        com.tencent.beacon.upload.UploadStrategy.IS_PROCESS_INFO = z;
    }

    public static void setCollectAndroidID(boolean z) {
        com.tencent.beacon.upload.UploadStrategy.IS_ANDROID_ID = z;
    }

    public static void setCollectImei(boolean z) {
        com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_IMEI = z;
    }

    public static void setCollectMAC(boolean z) {
        com.tencent.beacon.upload.UploadStrategy.IS_COLLECT_MAC = z;
    }

    public static void setJsClientId(java.lang.String str) {
        com.tencent.beacon.core.info.g.b(mContext).d(str);
    }

    public static void setLogAble(boolean z, boolean z2) {
        com.tencent.beacon.core.e.d.b(z);
        com.tencent.beacon.core.e.d.a(z2);
        com.tencent.beacon.core.e.d.c(z & z2);
    }

    public static void setOAID(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return;
        }
        com.tencent.beacon.core.info.c.b = str;
    }

    public static void setOmgId(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return;
        }
        com.tencent.beacon.core.info.c.c = str;
    }

    public static void setQQ(java.lang.String str) {
        java.lang.Object[] objArr;
        java.lang.String str2;
        if (str != null) {
            try {
                if (java.lang.Long.parseLong(str) > 10000) {
                    com.tencent.beacon.core.info.c.d = str;
                    return;
                }
                return;
            } catch (java.lang.Exception unused) {
                objArr = new java.lang.Object[0];
                str2 = "[core] set qq is not available !";
            }
        } else {
            objArr = new java.lang.Object[0];
            str2 = "[core] set qq is null !";
        }
        com.tencent.beacon.core.e.d.i(str2, objArr);
    }

    public static void setReportDomain(java.lang.String str, java.lang.String str2) {
        com.tencent.beacon.core.strategy.c.g().a(str, str2);
    }

    public static void setReportIP(java.lang.String str, java.lang.String str2) {
        com.tencent.beacon.core.c.a.b.a(str, str2);
    }

    public static void setScheduledService(java.util.concurrent.ScheduledExecutorService scheduledExecutorService) {
        if (scheduledExecutorService != null) {
            com.tencent.beacon.core.a.d.a(com.tencent.beacon.core.a.d.a(scheduledExecutorService));
        } else {
            com.tencent.beacon.core.e.d.b("service param error!", new java.lang.Object[0]);
        }
    }

    public static void setStopBackgroundTask(boolean z) {
        com.tencent.beacon.upload.UploadStrategy.IS_STOP_BACKGROUND_TASK = z;
    }

    public static void setStrictMode(boolean z) {
        com.tencent.beacon.core.e.i.f160a.set(z);
        android.content.Context context = mContext;
        if (context != null) {
            com.tencent.beacon.core.e.i.a(context);
        }
    }

    public static void setUploadMode(boolean z) {
        com.tencent.beacon.core.event.UserEventModule userEventModule = com.tencent.beacon.core.event.UserEventModule.getInstance();
        if (userEventModule != null) {
            userEventModule.setUploadMode(z);
        } else {
            com.tencent.beacon.core.e.d.i("[core] UserEventModule is null, init sdk first!", new java.lang.Object[0]);
        }
        com.tencent.beacon.core.event.TunnelModule tunnelModule = com.tencent.beacon.core.event.TunnelModule.getInstance();
        if (tunnelModule != null) {
            tunnelModule.setUploadMode(z);
        }
    }

    public static void setUserID(java.lang.String str) {
        setUserID(null, str);
    }

    public static void setUserID(java.lang.String str, java.lang.String str2) {
        com.tencent.beacon.core.e.d.d("[core] setUserID:" + str2, new java.lang.Object[0]);
        com.tencent.beacon.core.event.TunnelModule.setUserId(str, str2);
    }
}
