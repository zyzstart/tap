package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j implements com.tencent.beacon.core.d.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f195a;

    public j(android.content.Context context) {
        this.f195a = null;
        this.f195a = context;
    }

    private void a() {
        com.tencent.beacon.core.event.EventStrategyBean eventStrategyBean = com.tencent.beacon.core.event.EventStrategyBean.getInstance();
        if (eventStrategyBean == null || !eventStrategyBean.isStrategyQuerySuccessDaxMax()) {
            return;
        }
        com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(this.f195a);
        fVarA.b().a(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, java.lang.Integer.valueOf(fVarA.a(com.tencent.beacon.core.strategy.StrategyQueryModule.TODAY_SUCCESS_STRATEGY_QUERY_TIMES, 0) + 1)).a(com.tencent.beacon.core.strategy.StrategyQueryModule.LAST_SUCCESS_STRATEGY_QUERY_TIME, java.lang.Long.valueOf(java.lang.System.currentTimeMillis())).a();
    }

    private boolean a(java.util.Map map, com.tencent.beacon.core.strategy.c cVar) {
        if (cVar == null) {
            return false;
        }
        if (map == null || cVar.e() == null) {
            if (map == null || cVar.e() != null) {
                return false;
            }
        } else if (map.equals(cVar.e())) {
            return false;
        }
        cVar.a(map);
        return true;
    }

    @Override // com.tencent.beacon.core.d.g
    public void a(int i, byte[] bArr, boolean z) {
        if (i != 101) {
            com.tencent.beacon.core.e.d.i("[strategy] com strategy unmatch key: %d", java.lang.Integer.valueOf(i));
            return;
        }
        if (bArr == null || bArr.length <= 0) {
            return;
        }
        com.tencent.beacon.core.strategy.c strategy = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.f195a).getStrategy();
        if (strategy == null) {
            com.tencent.beacon.core.e.d.i("[strategy] impossible! common strategy null!", new java.lang.Object[0]);
            return;
        }
        try {
            com.tencent.beacon.core.protocol.strategy.CommonStrategy commonStrategy = new com.tencent.beacon.core.protocol.strategy.CommonStrategy();
            commonStrategy.readFrom(new com.tencent.beacon.core.wup.a(bArr));
            com.tencent.beacon.core.strategy.StrategyQueryModule strategyQueryModule = com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.f195a);
            com.tencent.beacon.core.e.d.a("[strategy] -> common strategy: %s", commonStrategy);
            if (a(commonStrategy, strategy)) {
                if (z) {
                    com.tencent.beacon.core.e.d.e("[strategy] update common strategy should save ", new java.lang.Object[0]);
                    com.tencent.beacon.core.strategy.d.a(this.f195a, i, bArr);
                }
                strategyQueryModule.notifyStrategyChanged(strategy);
            }
            if (z) {
                strategyQueryModule.setAtLeastAComQuerySuccess(true);
                a();
            }
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            com.tencent.beacon.core.e.d.b("[strategy] error to common strategy!", new java.lang.Object[0]);
        }
    }

    protected boolean a(com.tencent.beacon.core.protocol.strategy.CommonStrategy commonStrategy, com.tencent.beacon.core.strategy.c cVar) {
        boolean z;
        if (commonStrategy == null || cVar == null) {
            return false;
        }
        if (commonStrategy.url.equals(cVar.c())) {
            z = false;
        } else {
            com.tencent.beacon.core.e.d.a("[strategy] url changed to: %s", commonStrategy.url);
            cVar.c(commonStrategy.url);
            z = true;
        }
        if (commonStrategy.queryInterval != cVar.i()) {
            com.tencent.beacon.core.e.d.a("[strategy] QueryPeriod changed to: %d", java.lang.Integer.valueOf(commonStrategy.queryInterval));
            cVar.c(commonStrategy.queryInterval);
            z = true;
        }
        if (a(commonStrategy.moduleList, cVar)) {
            z = true;
        }
        if (a(commonStrategy.cloudParas, cVar)) {
            return true;
        }
        return z;
    }

    protected boolean a(java.util.ArrayList arrayList, com.tencent.beacon.core.strategy.c cVar) {
        java.lang.Object[] objArr;
        java.lang.Object[] objArr2;
        java.lang.Object[] objArr3;
        if (cVar == null) {
            return false;
        }
        if (arrayList != null) {
            android.util.SparseArray sparseArrayF = cVar.f();
            if (sparseArrayF != null) {
                boolean z = false;
                for (int i = 0; i < sparseArrayF.size(); i++) {
                    com.tencent.beacon.core.strategy.b bVar = (com.tencent.beacon.core.strategy.b) sparseArrayF.valueAt(i);
                    java.util.Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        com.tencent.beacon.core.protocol.strategy.ModuleStrategy moduleStrategy = (com.tencent.beacon.core.protocol.strategy.ModuleStrategy) it.next();
                        if (moduleStrategy.mId == bVar.e()) {
                            com.tencent.beacon.core.e.d.d("[strategy] server module strategy mid: %d", java.lang.Byte.valueOf(moduleStrategy.mId));
                            boolean z2 = moduleStrategy.onOff == 1;
                            if (bVar.f() != z2) {
                                com.tencent.beacon.core.e.d.a("[strategy] mid: %d , isUsable changed: %b ", java.lang.Byte.valueOf(moduleStrategy.mId), java.lang.Boolean.valueOf(z2));
                                bVar.a(z2);
                                z = true;
                            }
                            if (!bVar.d().equals(moduleStrategy.url)) {
                                com.tencent.beacon.core.e.d.a("[strategy] mid: %d , url changed: %s", java.lang.Byte.valueOf(moduleStrategy.mId), moduleStrategy.url);
                                bVar.a(moduleStrategy.url);
                                z = true;
                            }
                            byte b = moduleStrategy.mId;
                            if (b == 1 || b == 2) {
                                if (bVar.a() == null || moduleStrategy.detail == null) {
                                    if (moduleStrategy.detail != null && bVar.a() == null) {
                                        objArr = new java.lang.Object[]{java.lang.Byte.valueOf(moduleStrategy.mId)};
                                        com.tencent.beacon.core.e.d.a("[strategy] mid: %d , detail changed...", objArr);
                                        bVar.a(moduleStrategy.detail);
                                        com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.f195a).notifyModuleDetailChanged(moduleStrategy.mId, moduleStrategy.detail);
                                        z = true;
                                    }
                                } else if (!bVar.a().equals(moduleStrategy.detail)) {
                                    objArr = new java.lang.Object[]{java.lang.Byte.valueOf(moduleStrategy.mId)};
                                    com.tencent.beacon.core.e.d.a("[strategy] mid: %d , detail changed...", objArr);
                                    bVar.a(moduleStrategy.detail);
                                    com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.f195a).notifyModuleDetailChanged(moduleStrategy.mId, moduleStrategy.detail);
                                    z = true;
                                }
                            }
                            if (moduleStrategy.mId == 1) {
                                if (bVar.b() == null || moduleStrategy.preventEventCode == null) {
                                    if (bVar.b() != null || moduleStrategy.preventEventCode != null) {
                                        objArr2 = new java.lang.Object[]{java.lang.Byte.valueOf(moduleStrategy.mId)};
                                        com.tencent.beacon.core.e.d.a("[strategy] mid: %d , PreventEventCode changed...", objArr2);
                                        bVar.a((java.util.Set) com.tencent.beacon.core.e.b.a(moduleStrategy.preventEventCode));
                                        z = true;
                                    }
                                } else if (!com.tencent.beacon.core.e.b.a(bVar.b(), moduleStrategy.preventEventCode)) {
                                    objArr2 = new java.lang.Object[]{java.lang.Byte.valueOf(moduleStrategy.mId)};
                                    com.tencent.beacon.core.e.d.a("[strategy] mid: %d , PreventEventCode changed...", objArr2);
                                    bVar.a((java.util.Set) com.tencent.beacon.core.e.b.a(moduleStrategy.preventEventCode));
                                    z = true;
                                }
                                if (bVar.c() == null || moduleStrategy.sampleEvent == null) {
                                    if (bVar.c() != null || moduleStrategy.sampleEvent != null) {
                                        objArr3 = new java.lang.Object[]{java.lang.Byte.valueOf(moduleStrategy.mId)};
                                        com.tencent.beacon.core.e.d.a("[strategy] mid: %d , SampleEventSet changed...", objArr3);
                                        bVar.b(com.tencent.beacon.core.e.b.a(moduleStrategy.sampleEvent));
                                        z = true;
                                    }
                                } else if (!com.tencent.beacon.core.e.b.a(bVar.c(), moduleStrategy.sampleEvent)) {
                                    objArr3 = new java.lang.Object[]{java.lang.Byte.valueOf(moduleStrategy.mId)};
                                    com.tencent.beacon.core.e.d.a("[strategy] mid: %d , SampleEventSet changed...", objArr3);
                                    bVar.b(com.tencent.beacon.core.e.b.a(moduleStrategy.sampleEvent));
                                    z = true;
                                }
                            }
                            byte b2 = moduleStrategy.mId;
                            if (b2 == 2) {
                                com.tencent.beacon.core.e.d.a("[strategy] mid: %d , SpeedMonitorStrategy", java.lang.Byte.valueOf(b2));
                                bVar.a(moduleStrategy.sms);
                            }
                        }
                    }
                }
                return z;
            }
        } else {
            android.util.SparseArray sparseArrayF2 = cVar.f();
            if (sparseArrayF2 != null) {
                int size = sparseArrayF2.size();
                boolean z3 = false;
                for (int i2 = 0; i2 < size; i2++) {
                    com.tencent.beacon.core.strategy.b bVar2 = (com.tencent.beacon.core.strategy.b) sparseArrayF2.valueAt(i2);
                    if (bVar2.f()) {
                        com.tencent.beacon.core.e.d.a("[strategy] mid: %d , server not response strategy, sdk local close it!", java.lang.Integer.valueOf(bVar2.e()));
                        bVar2.a(false);
                        z3 = true;
                    }
                }
                return z3;
            }
        }
        return false;
    }
}
