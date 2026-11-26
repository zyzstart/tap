package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class StrategyQueryModule extends com.tencent.beacon.core.c {
    public static final int CheckApp = 1;
    public static final int EndQuery = 3;
    public static final java.lang.String LAST_SUCCESS_STRATEGY_QUERY_TIME = "last_success_strategy_query_time";
    public static final int Launch = 0;
    private static final java.lang.Object QUERY_STATE_LOCK = new java.lang.Object();
    public static final int StartQuery = 2;
    public static final java.lang.String TODAY_SUCCESS_STRATEGY_QUERY_TIMES = "today_success_strategy_query_times";
    public static final int WaitNextQuery = 4;
    private static volatile com.tencent.beacon.core.strategy.StrategyQueryModule mInstance;
    private boolean atLeastAComQueryEnd;
    private boolean atLeastAComQuerySuccess;
    private int commonQueryTime;
    protected int currentQueryStep;
    protected boolean isAppFirstRun;
    private com.tencent.beacon.upload.InitHandleListener mInitHandleListener;
    protected com.tencent.beacon.core.strategy.c strategy;
    private com.tencent.beacon.core.d.g strategyHandler;
    private com.tencent.beacon.core.strategy.i strategyQueryRunner;
    protected com.tencent.beacon.core.d.j uploadHandler;

    private StrategyQueryModule(android.content.Context context) {
        super(context);
        this.strategy = null;
        this.isAppFirstRun = false;
        this.strategyHandler = null;
        this.strategyQueryRunner = null;
        this.uploadHandler = null;
        this.currentQueryStep = 0;
        this.atLeastAComQuerySuccess = false;
        this.atLeastAComQueryEnd = false;
        this.commonQueryTime = 0;
        this.uploadHandler = com.tencent.beacon.core.d.k.a(context);
        this.strategy = com.tencent.beacon.core.strategy.c.g();
        com.tencent.beacon.core.strategy.g.b(context).a(this.strategy);
        this.strategyHandler = new com.tencent.beacon.core.strategy.j(context);
        this.uploadHandler.a(101, getStrategyHandler());
        this.strategyQueryRunner = new com.tencent.beacon.core.strategy.i(context);
    }

    public static synchronized com.tencent.beacon.core.strategy.StrategyQueryModule getInstance() {
        return mInstance;
    }

    public static synchronized com.tencent.beacon.core.strategy.StrategyQueryModule getInstance(android.content.Context context) {
        if (mInstance == null && context != null) {
            mInstance = new com.tencent.beacon.core.strategy.StrategyQueryModule(context);
        }
        return mInstance;
    }

    public static synchronized com.tencent.beacon.core.d.j getMyUpload() {
        if (mInstance == null) {
            return null;
        }
        return mInstance.getStrategyUploadHandler();
    }

    private synchronized com.tencent.beacon.core.d.j getStrategyUploadHandler() {
        return this.uploadHandler;
    }

    public int getCommonQueryTime() {
        int i;
        synchronized (QUERY_STATE_LOCK) {
            i = this.commonQueryTime;
        }
        return i;
    }

    public int getCurrentQueryStep() {
        int i;
        synchronized (QUERY_STATE_LOCK) {
            i = this.currentQueryStep;
        }
        return i;
    }

    public synchronized com.tencent.beacon.core.strategy.c getStrategy() {
        return this.strategy;
    }

    public synchronized com.tencent.beacon.core.d.g getStrategyHandler() {
        return this.strategyHandler;
    }

    public synchronized boolean isAppFirstRun() {
        return this.isAppFirstRun;
    }

    public boolean isAtLeastAComQueryEnd() {
        boolean z;
        synchronized (QUERY_STATE_LOCK) {
            z = this.atLeastAComQueryEnd;
        }
        return z;
    }

    public boolean isAtLeastAComQuerySuccess() {
        boolean z;
        synchronized (QUERY_STATE_LOCK) {
            z = this.atLeastAComQuerySuccess;
        }
        return z;
    }

    public void notifyModuleDetailChanged(int i, java.util.Map map) {
        java.util.Iterator it = com.tencent.beacon.event.UserAction.beaconModules.iterator();
        while (it.hasNext()) {
            ((com.tencent.beacon.core.c) it.next()).onModuleStrategyUpdated(i, map);
        }
    }

    public void notifyStrategyChanged(com.tencent.beacon.core.strategy.c cVar) {
        java.util.Iterator it = com.tencent.beacon.event.UserAction.beaconModules.iterator();
        while (it.hasNext()) {
            try {
                ((com.tencent.beacon.core.c) it.next()).onStrategyUpdated(cVar);
            } catch (java.lang.Throwable th) {
                com.tencent.beacon.core.e.d.a(th);
                com.tencent.beacon.core.e.d.b("[strategy] error %s", th.toString());
            }
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onFirstStrategyQueryFinished() {
        super.onFirstStrategyQueryFinished();
        com.tencent.beacon.upload.InitHandleListener initHandleListener = this.mInitHandleListener;
        if (initHandleListener != null) {
            initHandleListener.onInitEnd();
        }
    }

    @Override // com.tencent.beacon.core.c
    public void onSDKInit(android.content.Context context) {
        super.onSDKInit(context);
        com.tencent.beacon.core.e.d.a("[module] strategy module > TRUE", new java.lang.Object[0]);
        this.strategyQueryRunner.d();
        startQuery();
        com.tencent.beacon.core.a.g.a().a(context, new com.tencent.beacon.core.strategy.h(this, context));
    }

    @Override // com.tencent.beacon.core.c
    public void onStrategyQueryFinished() {
        super.onStrategyQueryFinished();
        com.tencent.beacon.upload.InitHandleListener initHandleListener = this.mInitHandleListener;
        if (initHandleListener != null) {
            initHandleListener.onStrategyQuerySuccess();
        }
    }

    @Override // com.tencent.beacon.core.c
    public synchronized void onStrategyUpdated(com.tencent.beacon.core.strategy.c cVar) {
        super.onStrategyUpdated(cVar);
        this.strategy.l();
    }

    public synchronized void setAppFirstRun(boolean z) {
        this.isAppFirstRun = z;
        com.tencent.beacon.core.e.d.f("[strategy] set isFirst: %b", java.lang.Boolean.valueOf(z));
    }

    public void setAtLeastAComQueryEnd(boolean z) {
        synchronized (QUERY_STATE_LOCK) {
            this.atLeastAComQueryEnd = z;
        }
    }

    public void setAtLeastAComQuerySuccess(boolean z) {
        synchronized (QUERY_STATE_LOCK) {
            this.atLeastAComQuerySuccess = z;
        }
    }

    public void setCommonQueryTime(int i) {
        synchronized (QUERY_STATE_LOCK) {
            this.commonQueryTime = i;
        }
    }

    public synchronized void setCommonStrategy(com.tencent.beacon.core.strategy.c cVar) {
        this.strategy = cVar;
    }

    public void setCurrentQueryStep(int i) {
        synchronized (QUERY_STATE_LOCK) {
            this.currentQueryStep = i;
            com.tencent.beacon.core.e.d.f("[strategy] current query step:%d", java.lang.Integer.valueOf(i));
            if (i == 3) {
                setAtLeastAComQueryEnd(true);
            }
        }
    }

    public void setInitHandleListener(com.tencent.beacon.upload.InitHandleListener initHandleListener) {
        this.mInitHandleListener = initHandleListener;
    }

    public synchronized void startQuery() {
        if (!this.strategyQueryRunner.c) {
            com.tencent.beacon.core.a.d.a().a(this.strategyQueryRunner);
        }
    }
}
