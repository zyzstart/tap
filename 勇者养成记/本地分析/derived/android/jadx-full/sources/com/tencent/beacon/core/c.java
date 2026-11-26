package com.tencent.beacon.core;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {
    private boolean firstStrategyQueryFinishedCalled = true;
    protected android.content.Context mContext;

    public c(android.content.Context context) {
        this.mContext = context;
    }

    public void onAppFirstRun() {
    }

    public void onFirstStrategyQueryFinished() {
    }

    public void onModuleStarted() {
    }

    public void onModuleStrategyUpdated(int i, java.util.Map map) {
    }

    public void onSDKInit(android.content.Context context) {
    }

    public void onStrategyQueryFinished() {
        if (this.firstStrategyQueryFinishedCalled) {
            onFirstStrategyQueryFinished();
            if (com.tencent.beacon.core.d.k.a(this.mContext).f() && com.tencent.beacon.core.a.l.a(this.mContext).b("sig_1") && com.tencent.beacon.core.d.k.a(this.mContext).e()) {
                onModuleStarted();
            } else {
                com.tencent.beacon.core.e.d.i("[strategy] get lock failed, on call module started", new java.lang.Object[0]);
            }
            this.firstStrategyQueryFinishedCalled = false;
        }
    }

    public void onStrategyQueryStarted() {
    }

    public void onStrategyUpdated(com.tencent.beacon.core.strategy.c cVar) {
    }
}
