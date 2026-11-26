package com.tencent.beacon.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.content.Context f203a;
    final /* synthetic */ com.tencent.beacon.upload.InitHandleListener b;
    final /* synthetic */ long c;

    b(android.content.Context context, com.tencent.beacon.upload.InitHandleListener initHandleListener, long j) {
        this.f203a = context;
        this.b = initHandleListener;
        this.c = j;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.tencent.beacon.event.UserAction.beaconModules.add(com.tencent.beacon.core.event.UserEventModule.getInstance(com.tencent.beacon.event.UserAction.mContext));
        com.tencent.beacon.event.UserAction.beaconModules.add(com.tencent.beacon.core.event.TunnelModule.getInstance(com.tencent.beacon.event.UserAction.mContext));
        for (java.lang.String str : com.tencent.beacon.core.b.f142a) {
            try {
                com.tencent.beacon.core.c cVar = (com.tencent.beacon.core.c) com.tencent.beacon.core.e.f.a(str, "getInstance", new java.lang.Class[]{android.content.Context.class}, new java.lang.Object[]{com.tencent.beacon.event.UserAction.mContext});
                if (cVar != null) {
                    com.tencent.beacon.core.e.d.d("[core] %s module load successfully.", str);
                    com.tencent.beacon.event.UserAction.beaconModules.add(cVar);
                } else if (!str.contains("nativeaudit")) {
                    com.tencent.beacon.core.d.i iVarA = com.tencent.beacon.core.d.i.a(this.f203a);
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("[core] SDK init ");
                    sb.append(str);
                    sb.append(" fail!");
                    iVarA.a("201", sb.toString());
                }
            } catch (java.lang.Exception unused) {
            }
        }
        com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(com.tencent.beacon.event.UserAction.mContext).setInitHandleListener(this.b);
        com.tencent.beacon.event.UserAction.beaconModules.add(com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(com.tencent.beacon.event.UserAction.mContext));
        java.util.Iterator it = com.tencent.beacon.event.UserAction.beaconModules.iterator();
        while (it.hasNext()) {
            ((com.tencent.beacon.core.c) it.next()).onSDKInit(com.tencent.beacon.event.UserAction.mContext);
        }
        com.tencent.beacon.qimei.QimeiSDK.getInstance().init(com.tencent.beacon.event.UserAction.mContext);
        long j = this.c;
        if (j > 0) {
            if (j > 10000) {
                j = 10000;
            }
            com.tencent.beacon.core.strategy.i.a(j);
        }
    }
}
