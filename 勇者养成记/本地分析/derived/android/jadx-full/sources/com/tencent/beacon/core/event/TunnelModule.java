package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TunnelModule extends com.tencent.beacon.core.c {
    private static volatile com.tencent.beacon.core.event.TunnelModule INSTANCE;
    public static com.tencent.beacon.core.event.TunnelModule.b netConsumeUtil;
    private com.tencent.beacon.core.event.h appDefaultEventTunnel;
    private android.content.Context context;
    protected java.lang.Runnable doUploadTask;
    public boolean isEnable;
    private java.util.Map tunnelMap;
    private static final java.util.List CACHE_TUNNEL = java.util.Collections.synchronizedList(new java.util.ArrayList(5));
    private static java.util.List cacheEvents = java.util.Collections.synchronizedList(new java.util.ArrayList(5));
    private static java.util.List cacheAdditionInfo = java.util.Collections.synchronizedList(new java.util.ArrayList(5));
    private static java.util.List cacheUserId = java.util.Collections.synchronizedList(new java.util.ArrayList(5));

    /* JADX INFO: Access modifiers changed from: private */
    interface a {
        void a(com.tencent.beacon.core.event.h hVar);
    }

    public interface b {
        long a();
    }

    public TunnelModule(android.content.Context context) {
        super(context);
        this.doUploadTask = new com.tencent.beacon.core.event.z(this);
        this.context = context;
        this.appDefaultEventTunnel = new com.tencent.beacon.core.event.h(context, com.tencent.beacon.core.info.b.b(context).a());
        this.tunnelMap = new java.util.concurrent.ConcurrentHashMap();
        dealCacheTunnel();
        dealCacheAdditionalInfo();
        dealCacheUserId();
    }

    private synchronized void addTunnel(com.tencent.beacon.upload.TunnelInfo tunnelInfo) {
        if (tunnelInfo.appKey.equals(this.appDefaultEventTunnel.b())) {
            com.tencent.beacon.core.e.d.b("[REDACTED]", tunnelInfo.appKey);
        } else if (((com.tencent.beacon.core.event.h) this.tunnelMap.get(tunnelInfo.appKey)) != null) {
            com.tencent.beacon.core.e.d.b("[REDACTED]", tunnelInfo.appKey);
        } else {
            com.tencent.beacon.core.e.d.a("[REDACTED]", tunnelInfo.appKey);
            this.tunnelMap.put(tunnelInfo.appKey, createTunnel(this.context, tunnelInfo));
        }
    }

    private void allTunnel(com.tencent.beacon.core.event.TunnelModule.a aVar) {
        if (aVar == null) {
            return;
        }
        com.tencent.beacon.core.event.h hVar = this.appDefaultEventTunnel;
        if (hVar != null) {
            aVar.a(hVar);
        }
        java.util.Iterator it = this.tunnelMap.values().iterator();
        while (it.hasNext()) {
            aVar.a((com.tencent.beacon.core.event.h) it.next());
        }
    }

    private com.tencent.beacon.core.event.h createTunnel(android.content.Context context, com.tencent.beacon.upload.TunnelInfo tunnelInfo) {
        tunnelInfo.channel = com.tencent.beacon.core.e.c.a(tunnelInfo.channel);
        com.tencent.beacon.core.event.h hVar = new com.tencent.beacon.core.event.h(context, tunnelInfo.appKey);
        hVar.a(true);
        com.tencent.beacon.core.info.g.b(context).a(tunnelInfo.appKey, tunnelInfo);
        return hVar;
    }

    private void dealCacheAdditionalInfo() {
        for (com.tencent.beacon.event.a aVar : cacheAdditionInfo) {
            setAdditionalInfoInstance(aVar.f202a, (java.util.Map) aVar.b);
        }
        cacheAdditionInfo.clear();
    }

    private void dealCacheTunnel() {
        for (com.tencent.beacon.upload.TunnelInfo tunnelInfo : CACHE_TUNNEL) {
            this.tunnelMap.put(tunnelInfo.appKey, createTunnel(this.context, tunnelInfo));
        }
        CACHE_TUNNEL.clear();
    }

    private void dealCacheUserId() {
        for (com.tencent.beacon.event.a aVar : cacheUserId) {
            setUserIdInstance(aVar.f202a, (java.lang.String) aVar.b);
        }
        cacheUserId.clear();
    }

    public static void doUploadAllEventsData() {
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule == null || !isModuleAble()) {
            return;
        }
        tunnelModule.allTunnel(new com.tencent.beacon.core.event.B());
    }

    public static void doUploadRecentCommonData(boolean z) {
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule == null || !isModuleAble()) {
            return;
        }
        tunnelModule.allTunnel(new com.tencent.beacon.core.event.A(z));
    }

    public static void flushObjectsToDB(boolean z) {
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule != null) {
            tunnelModule.allTunnel(new com.tencent.beacon.core.event.C(z));
        }
    }

    public static java.util.Map getAdditionalInfo(java.lang.String str) {
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule == null) {
            com.tencent.beacon.core.e.d.b("getAdditionalInfo failed, sdk is not ready", new java.lang.Object[0]);
            return null;
        }
        com.tencent.beacon.core.event.h tunnelByAppKey = tunnelModule.getTunnelByAppKey(str);
        if (tunnelByAppKey != null) {
            return tunnelByAppKey.a();
        }
        com.tencent.beacon.core.e.d.b("getAdditionalInfo failed, tunnel of %s not found", str);
        return null;
    }

    public static com.tencent.beacon.core.event.TunnelModule getInstance() {
        return INSTANCE;
    }

    public static com.tencent.beacon.core.event.TunnelModule getInstance(android.content.Context context) {
        if (INSTANCE == null) {
            synchronized (com.tencent.beacon.core.event.TunnelModule.class) {
                if (INSTANCE == null) {
                    INSTANCE = new com.tencent.beacon.core.event.TunnelModule(context);
                }
            }
        }
        return INSTANCE;
    }

    private com.tencent.beacon.core.event.h getTunnelByAppKey(java.lang.String str) {
        return (com.tencent.beacon.core.e.j.b(str) || str.equals(this.appDefaultEventTunnel.b())) ? this.appDefaultEventTunnel : (com.tencent.beacon.core.event.h) this.tunnelMap.get(str);
    }

    public static java.lang.String getUserId(java.lang.String str) {
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule == null) {
            com.tencent.beacon.core.e.d.b("getUserId failed, sdk is not ready", new java.lang.Object[0]);
            return null;
        }
        com.tencent.beacon.core.event.h tunnelByAppKey = tunnelModule.getTunnelByAppKey(str);
        if (tunnelByAppKey != null) {
            return tunnelByAppKey.f();
        }
        com.tencent.beacon.core.e.d.b("getUserId failed, tunnel of %s not found", str);
        return null;
    }

    public static boolean isModuleAble() {
        com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean;
        com.tencent.beacon.core.event.TunnelModule.b bVar;
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule == null) {
            com.tencent.beacon.core.e.d.b("[module] this module not ready!", new java.lang.Object[0]);
            return false;
        }
        boolean z = tunnelModule.isEnable;
        boolean zIsAtLeastAComQueryEnd = z ? com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(tunnelModule.context).isAtLeastAComQueryEnd() : z;
        if (!zIsAtLeastAComQueryEnd || (eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance()) == null || (bVar = netConsumeUtil) == null || bVar.a() < eventStrategyBean.getDailyConsumeLimit()) {
            return zIsAtLeastAComQueryEnd;
        }
        com.tencent.beacon.core.e.d.i("[strategy] reach daily consume limited! %d ", java.lang.Integer.valueOf(eventStrategyBean.getDailyConsumeLimit()));
        return false;
    }

    public static boolean onUserAction(java.lang.String str, java.lang.String str2, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        return onUserAction(str, str2, z, j, j2, map, z2, false);
    }

    public static boolean onUserAction(java.lang.String str, java.lang.String str2, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        com.tencent.beacon.core.strategy.StrategyQueryModule strategyQueryModule = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance();
        if (strategyQueryModule == null || !strategyQueryModule.isAtLeastAComQueryEnd()) {
            com.tencent.beacon.core.e.d.d("[event] [%s] add to cache events list.", str2);
            java.util.List list = cacheEvents;
            if (list != null) {
                list.add(new com.tencent.beacon.core.event.f(str, str2, z, j, j2, map, z2));
            }
            return true;
        }
        if (!isModuleAble()) {
            com.tencent.beacon.core.e.d.b("[event] UserEventModule is disable (false).", new java.lang.Object[0]);
            return false;
        }
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule != null) {
            com.tencent.beacon.core.event.h tunnelByAppKey = tunnelModule.getTunnelByAppKey(str);
            if (tunnelByAppKey != null) {
                return tunnelByAppKey.a(str2, z, j, j2, map, z2, z3);
            }
            com.tencent.beacon.core.e.d.b("onUserAction failed, tunnel of %s not found", str);
        }
        return false;
    }

    public static void registerTunnel(com.tencent.beacon.upload.TunnelInfo tunnelInfo) {
        if (com.tencent.beacon.core.e.j.b(tunnelInfo.appKey)) {
            com.tencent.beacon.core.e.d.b("[REDACTED]", new java.lang.Object[0]);
            return;
        }
        synchronized (com.tencent.beacon.core.event.TunnelModule.class) {
            com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
            if (tunnelModule == null) {
                CACHE_TUNNEL.add(tunnelInfo);
            } else {
                tunnelModule.addTunnel(tunnelInfo);
            }
        }
    }

    public static void setAdditionalInfo(java.lang.String str, java.util.Map map) {
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule == null) {
            cacheAdditionInfo.add(new com.tencent.beacon.event.a(str, map));
        } else {
            tunnelModule.setAdditionalInfoInstance(str, map);
        }
    }

    private void setAdditionalInfoInstance(java.lang.String str, java.util.Map map) {
        com.tencent.beacon.core.event.h tunnelByAppKey = getTunnelByAppKey(str);
        if (tunnelByAppKey == null) {
            com.tencent.beacon.core.e.d.b("setAdditionalInfo failed, tunnel of %s not found", str);
        } else {
            tunnelByAppKey.a(map);
        }
    }

    public static void setNetConsumeProtocol(com.tencent.beacon.core.event.TunnelModule.b bVar) {
        netConsumeUtil = bVar;
    }

    public static void setUserId(java.lang.String str, java.lang.String str2) {
        com.tencent.beacon.core.event.TunnelModule tunnelModule = getInstance();
        if (tunnelModule == null) {
            cacheUserId.add(new com.tencent.beacon.event.a(str, str2));
            return;
        }
        if (com.tencent.beacon.core.e.j.b(str2)) {
            str2 = "10000";
        }
        tunnelModule.setUserIdInstance(str, com.tencent.beacon.core.e.c.d(str2));
    }

    private void setUserIdInstance(java.lang.String str, java.lang.String str2) {
        com.tencent.beacon.core.event.h tunnelByAppKey = getTunnelByAppKey(str);
        if (tunnelByAppKey == null) {
            com.tencent.beacon.core.e.d.b("setUserId failed, tunnel of %s not found", str);
        } else {
            tunnelByAppKey.b(str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void dealCacheEvent() {
        java.util.List list = cacheEvents;
        if (list != null && list.size() > 0) {
            for (com.tencent.beacon.core.event.f fVar : cacheEvents) {
                onUserAction(fVar.g, fVar.f167a, fVar.b, fVar.c, fVar.d, fVar.e, fVar.f);
            }
            cacheEvents.clear();
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onAppFirstRun() {
        com.tencent.beacon.core.e.d.e("[event] ua first clean :%d", java.lang.Integer.valueOf(com.tencent.beacon.core.event.t.a(this.mContext, this.appDefaultEventTunnel.b(), null, -1L, Long.MAX_VALUE)));
        com.tencent.beacon.core.e.d.e("[event] ua remove strategy :%d", java.lang.Integer.valueOf(com.tencent.beacon.core.strategy.d.a(this.mContext, 101)));
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStrategyUpdated(int i, java.util.Map map) {
        super.onModuleStrategyUpdated(i, map);
        if (i != 1 || map == null || map.size() <= 0 || com.tencent.beacon.core.event.EventStrategyBean.getInstance() == null) {
            return;
        }
        com.tencent.beacon.core.event.EventStrategyBean.getInstance().updateConfig(map);
    }

    @Override // com.tencent.beacon.core.c
    public void onSDKInit(android.content.Context context) {
        super.onSDKInit(context);
        setModuleUserEnable(true);
        com.tencent.beacon.core.a.g.a().a(context, new com.tencent.beacon.core.event.y(this));
    }

    @Override // com.tencent.beacon.core.c
    public void onStrategyQueryFinished() {
        super.onStrategyQueryFinished();
        allTunnel(new com.tencent.beacon.core.event.w(this));
        dealCacheEvent();
    }

    @Override // com.tencent.beacon.core.c
    public void onStrategyUpdated(com.tencent.beacon.core.strategy.c cVar) {
        com.tencent.beacon.core.strategy.b bVarB;
        super.onStrategyUpdated(cVar);
        if (cVar == null || (bVarB = cVar.b(1)) == null) {
            return;
        }
        boolean zF = bVarB.f();
        com.tencent.beacon.core.e.d.f("[strategy] setEnable: %b", java.lang.Boolean.valueOf(zF));
        setEnable(zF);
    }

    public void setAppKey(java.lang.String str) {
        com.tencent.beacon.core.event.h hVar = this.appDefaultEventTunnel;
        if (hVar != null) {
            hVar.a(str);
        }
    }

    public synchronized void setEnable(boolean z) {
        this.isEnable = z;
        allTunnel(new com.tencent.beacon.core.event.x(this, z));
    }

    public void setModuleUserEnable(boolean z) {
        com.tencent.beacon.core.strategy.b bVarB;
        com.tencent.beacon.core.strategy.StrategyQueryModule strategyQueryModule = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.mContext);
        if (strategyQueryModule == null || (bVarB = strategyQueryModule.getStrategy().b(1)) == null || bVarB.f() == z) {
            return;
        }
        bVarB.a(z);
        setEnable(z);
    }

    public void setUploadMode(boolean z) {
        com.tencent.beacon.core.d.k kVarA;
        boolean z2;
        if (com.tencent.beacon.core.d.k.a(this.mContext) == null || z == com.tencent.beacon.core.d.k.a(this.mContext).e()) {
            return;
        }
        if (z) {
            kVarA = com.tencent.beacon.core.d.k.a(this.mContext);
            z2 = true;
        } else {
            kVarA = com.tencent.beacon.core.d.k.a(this.mContext);
            z2 = false;
        }
        kVarA.a(z2);
    }

    public void updateSchedule() {
        allTunnel(new com.tencent.beacon.core.event.D(this));
    }
}
