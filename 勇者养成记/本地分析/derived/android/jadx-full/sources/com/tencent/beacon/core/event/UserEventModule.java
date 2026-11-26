package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class UserEventModule extends com.tencent.beacon.core.c {
    private static com.tencent.beacon.core.event.UserEventModule mInstance;
    private com.tencent.beacon.core.event.v sensorManager;
    private boolean uploadMode;

    protected UserEventModule(android.content.Context context) {
        super(context);
        this.uploadMode = true;
        com.tencent.beacon.core.info.b.b(this.mContext);
        com.tencent.beacon.core.event.EventStrategyBean.getInstance();
        this.sensorManager = new com.tencent.beacon.core.event.v();
    }

    public static synchronized com.tencent.beacon.core.event.UserEventModule getInstance() {
        return mInstance;
    }

    public static synchronized com.tencent.beacon.core.event.UserEventModule getInstance(android.content.Context context) {
        if (mInstance == null) {
            mInstance = new com.tencent.beacon.core.event.UserEventModule(context);
        }
        return mInstance;
    }

    public void onAppHotLaunch() {
        sensorEvent();
    }

    public void onAppStop() {
        this.sensorManager.c(this.mContext);
    }

    @Override // com.tencent.beacon.core.c
    public void onModuleStarted() {
        super.onModuleStarted();
        com.tencent.beacon.core.e.d.a("[event] start userEvent module > heartbeat & launched", new java.lang.Object[0]);
        new com.tencent.beacon.core.event.m(this.mContext).a(false);
        startAppLaunched();
    }

    public void sensorEvent() {
        this.sensorManager.b(this.mContext);
    }

    public void setUploadMode(boolean z) {
        if (z != this.uploadMode) {
            this.uploadMode = z;
            if (!z) {
                com.tencent.beacon.core.event.m.a(this.mContext);
            } else {
                new com.tencent.beacon.core.event.m(this.mContext).a(false);
                startAppLaunched();
            }
        }
    }

    public void startAppLaunched() {
        java.lang.String str;
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        if (com.tencent.beacon.core.event.EventStrategyBean.getInstance().isLaunchEventSimple()) {
            if (com.tencent.beacon.core.e.b.a().equals(com.tencent.beacon.core.a.f.a(this.mContext).a("LAUEVE_DENGTA", ""))) {
                com.tencent.beacon.core.e.d.d("[event] AppLaunchedEvent has been uploaded!", new java.lang.Object[0]);
                return;
            }
        }
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(this.mContext);
        if (eVarD == null) {
            com.tencent.beacon.core.e.d.b("[event] DeviceInfo is null then return", new java.lang.Object[0]);
            return;
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("A33", eVarD.k(this.mContext));
        map.put("A133", eVarD.a(this.mContext));
        map.put("A63", "Y");
        if (com.tencent.beacon.core.info.a.j(this.mContext)) {
            str = "A21";
            str2 = "Y";
        } else {
            str = "A21";
            str2 = "N";
        }
        map.put(str, str2);
        if (com.tencent.beacon.core.strategy.StrategyQueryModule.getInstance(this.mContext).isAppFirstRun()) {
            str3 = "A45";
            str4 = "Y";
        } else {
            str3 = "A45";
            str4 = "N";
        }
        map.put(str3, str4);
        if (com.tencent.beacon.core.info.a.h(this.mContext)) {
            str5 = "A66";
            str6 = "F";
        } else {
            str5 = "A66";
            str6 = "B";
        }
        map.put(str5, str6);
        map.put("A68", "" + com.tencent.beacon.core.info.a.b(this.mContext));
        map.put("A85", com.tencent.beacon.core.info.a.e ? "Y" : "N");
        map.put("A9", eVarD.d());
        map.put("A14", eVarD.q());
        map.put("A20", eVarD.p(this.mContext));
        map.put("A69", eVarD.q(this.mContext));
        if (com.tencent.beacon.event.UserAction.onUserAction("rqd_applaunched", true, 0L, 0L, map, true)) {
            com.tencent.beacon.core.a.f.a(this.mContext).b().a("LAUEVE_DENGTA", (java.lang.Object) com.tencent.beacon.core.e.b.a()).a();
        }
        sensorEvent();
    }
}
