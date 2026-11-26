package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class h implements com.tencent.beacon.core.a.g.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f193a;
    final /* synthetic */ com.tencent.beacon.core.strategy.StrategyQueryModule b;

    h(com.tencent.beacon.core.strategy.StrategyQueryModule strategyQueryModule, android.content.Context context) {
        this.b = strategyQueryModule;
        this.f193a = context;
    }

    @Override // com.tencent.beacon.core.a.g.a
    public void a() {
        if (this.b.isAtLeastAComQuerySuccess() || com.tencent.beacon.core.event.UserEventModule.getInstance() == null || com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.f193a).getCommonQueryTime() == 0 || this.b.getCurrentQueryStep() == 2) {
            return;
        }
        this.b.startQuery();
    }
}
