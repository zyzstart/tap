package com.tencent.ydkbeacon.event.open;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class BeaconReport {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.event.open.BeaconReport f1263a = null;
    private static java.lang.String b = "";
    private android.content.Context c;
    private boolean d;
    private java.lang.String e;
    private com.tencent.ydkbeacon.event.open.BeaconConfig f;
    private boolean g;
    private java.lang.String h;

    private BeaconReport() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        com.tencent.ydkbeacon.a.e.c.a(this.g);
        com.tencent.ydkbeacon.event.open.BeaconConfig beaconConfig = this.f;
        if (beaconConfig != null) {
            com.tencent.ydkbeacon.a.e.c.a("BeaconReport", beaconConfig.toString(), new java.lang.Object[0]);
            com.tencent.ydkbeacon.base.net.c.b.a(this.f.getConfigHost(), this.f.getUploadHost());
            d();
            com.tencent.ydkbeacon.a.c.c.d().a(this.f.isEnableQmsp());
        }
        com.tencent.ydkbeacon.base.net.d dVarC = com.tencent.ydkbeacon.base.net.d.c();
        android.content.Context context = this.c;
        com.tencent.ydkbeacon.event.open.BeaconConfig beaconConfig2 = this.f;
        dVarC.a(context, beaconConfig2 == null ? null : beaconConfig2.getHttpAdapter());
        com.tencent.ydkbeacon.a.d.a.a().a(this.c);
        com.tencent.ydkbeacon.a.c.b.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        cVarD.a(this.c);
        cVarD.c(this.e);
        com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().setAppKey(this.e);
        cVarD.a(this.h);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        com.tencent.ydkbeacon.module.ModuleName[] moduleNameArrValues = com.tencent.ydkbeacon.module.ModuleName.values();
        for (com.tencent.ydkbeacon.module.ModuleName moduleName : moduleNameArrValues) {
            try {
                com.tencent.ydkbeacon.module.BeaconModule.f1265a.put(moduleName, com.tencent.ydkbeacon.event.c.c.e(moduleName.getClassName()));
            } catch (java.lang.Exception e) {
                com.tencent.ydkbeacon.a.e.c.b("init Module error: " + e.getMessage(), new java.lang.Object[0]);
                com.tencent.ydkbeacon.a.e.c.a(e);
            }
        }
        for (com.tencent.ydkbeacon.module.ModuleName moduleName2 : moduleNameArrValues) {
            com.tencent.ydkbeacon.module.BeaconModule beaconModule = (com.tencent.ydkbeacon.module.BeaconModule) com.tencent.ydkbeacon.module.BeaconModule.f1265a.get(moduleName2);
            if (beaconModule != null) {
                beaconModule.a(this.c);
            }
        }
        com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().init(this.c);
    }

    private void d() {
        java.util.HashMap map = new java.util.HashMap();
        map.put("u_c_a_e", java.lang.Boolean.valueOf(this.f.isAuditEnable()));
        map.put("u_c_b_e", java.lang.Boolean.valueOf(this.f.isBidEnable()));
        map.put("u_c_m_e", java.lang.Boolean.valueOf(this.f.isCollectMACEnable()));
        map.put("u_c_i_e", java.lang.Boolean.valueOf(this.f.isCollectIMEIEnable()));
        map.put("u_c_a_i_e", java.lang.Boolean.valueOf(this.f.isCollectAndroidIdEnable()));
        map.put("u_c_p_i_e", java.lang.Boolean.valueOf(this.f.isCollectProcessInfoEnable()));
        map.put("u_c_d_s", java.lang.Integer.valueOf(this.f.getMaxDBCount()));
        map.put("u_c_p_s", java.lang.Boolean.valueOf(this.f.isPagePathEnable()));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(8, map));
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("s_e_e", java.lang.Boolean.valueOf(this.f.isEventReportEnable()));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(7, map2));
        java.util.HashMap map3 = new java.util.HashMap();
        map3.put("u_c_r_p", java.lang.Long.valueOf(this.f.getRealtimePollingTime()));
        map3.put("u_c_n_p", java.lang.Long.valueOf(this.f.getNormalPollingTIme()));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(11, map3));
    }

    public static com.tencent.ydkbeacon.event.open.BeaconReport getInstance() {
        if (f1263a == null) {
            synchronized (com.tencent.ydkbeacon.event.open.BeaconReport.class) {
                if (f1263a == null) {
                    f1263a = new com.tencent.ydkbeacon.event.open.BeaconReport();
                }
            }
        }
        return f1263a;
    }

    public static java.lang.String getSoPath() {
        return b;
    }

    public static void setSoPath(java.lang.String str) {
        b = str;
    }

    public com.tencent.ydkbeacon.core.info.BeaconPubParams getCommonParams(android.content.Context context) {
        if (context == null) {
            return null;
        }
        return com.tencent.ydkbeacon.core.info.BeaconPubParams.getPubParams(context);
    }

    public java.lang.String getOAID() {
        return com.tencent.ydkbeacon.a.c.f.p().y();
    }

    @android.support.annotation.Nullable
    public com.tencent.ydkbeacon.qimei.Qimei getQimei() {
        return com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getQimei();
    }

    public void getQimei(com.tencent.ydkbeacon.qimei.IAsyncQimeiListener iAsyncQimeiListener) {
        com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getQimei(iAsyncQimeiListener);
    }

    public java.lang.String getSDKVersion() {
        return "4.1.18";
    }

    public com.tencent.ydkbeacon.event.open.EventResult report(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
        if (android.text.TextUtils.isEmpty(beaconEvent.getCode())) {
            return com.tencent.ydkbeacon.event.open.EventResult.a.a(106);
        }
        com.tencent.ydkbeacon.event.open.BeaconEvent beaconEventBuild = com.tencent.ydkbeacon.event.open.BeaconEvent.newBuilder(beaconEvent).build();
        com.tencent.ydkbeacon.module.EventModule eventModule = (com.tencent.ydkbeacon.module.EventModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.EVENT);
        if (eventModule != null && eventModule.d()) {
            return eventModule.a(beaconEventBuild);
        }
        java.util.HashMap map = new java.util.HashMap();
        map.put("b_e", beaconEventBuild);
        com.tencent.ydkbeacon.a.a.b.a().a(new com.tencent.ydkbeacon.a.a.c(6, map));
        return new com.tencent.ydkbeacon.event.open.EventResult(0, -1L, "Beacon SDK not init beaconEvent add to cache!");
    }

    public void resumeReport() {
        com.tencent.ydkbeacon.a.e.c.a("BeaconReport", "resume report by user.", new java.lang.Object[0]);
        com.tencent.ydkbeacon.a.b.a.a().b();
        com.tencent.ydkbeacon.base.net.d.c().e();
    }

    public void setAdditionalParams(java.lang.String str, @android.support.annotation.NonNull java.util.Map map) {
        java.util.HashMap map2 = new java.util.HashMap();
        map2.put("i_c_ad", new java.util.HashMap(map));
        map2.put("i_c_ak", str);
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(3, map2));
    }

    public void setAdditionalParams(@android.support.annotation.NonNull java.util.Map map) {
        setAdditionalParams(this.e, map);
    }

    public void setAppVersion(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        com.tencent.ydkbeacon.a.c.b.f1186a = str;
    }

    public void setChannelID(java.lang.String str) {
        this.h = str;
        com.tencent.ydkbeacon.a.c.c.d().a(str);
    }

    public void setCollectAndroidID(boolean z) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("u_c_a_i_e", java.lang.Boolean.valueOf(z));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(8, map));
    }

    public void setCollectImei(boolean z) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("u_c_i_e", java.lang.Boolean.valueOf(z));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(8, map));
    }

    public void setCollectMac(boolean z) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("u_c_m_e", java.lang.Boolean.valueOf(z));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(8, map));
    }

    public void setCollectProcessInfo(boolean z) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("u_c_p_i_e", java.lang.Boolean.valueOf(z));
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(8, map));
    }

    public void setLogAble(boolean z) {
        this.g = z;
        com.tencent.ydkbeacon.a.e.c.a(z);
    }

    @java.lang.Deprecated
    public void setOAID(java.lang.String str) {
    }

    public void setOmgID(java.lang.String str) {
        com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().setOmgId(str);
    }

    public void setQQ(java.lang.String str) {
        com.tencent.ydkbeacon.a.c.b.a(str);
    }

    public void setStrictMode(boolean z) {
        com.tencent.ydkbeacon.a.e.e.f1201a.set(z);
    }

    public void setUserID(java.lang.String str) {
        setUserID(this.e, str);
    }

    public void setUserID(java.lang.String str, java.lang.String str2) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("i_c_ak", str);
        map.put("i_c_u_i", str2);
        com.tencent.ydkbeacon.a.a.b.a().b(new com.tencent.ydkbeacon.a.a.c(4, map));
    }

    public synchronized void start(@android.support.annotation.NonNull android.content.Context context, @android.support.annotation.NonNull java.lang.String str, @android.support.annotation.Nullable com.tencent.ydkbeacon.event.open.BeaconConfig beaconConfig) {
        if (this.d) {
            return;
        }
        com.tencent.ydkbeacon.a.e.e.a("Context", context);
        this.c = context.getApplicationContext();
        com.tencent.ydkbeacon.a.e.e.a(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_APP_KEY, str);
        this.e = str;
        this.f = beaconConfig;
        com.tencent.ydkbeacon.a.c.c.d().a(context);
        com.tencent.ydkbeacon.a.b.d.b().a(beaconConfig != null && beaconConfig.isForceEnableAtta());
        ((android.app.Application) this.c).registerActivityLifecycleCallbacks(new com.tencent.ydkbeacon.b.b());
        com.tencent.ydkbeacon.a.b.a.a().a(new com.tencent.ydkbeacon.event.open.c(this));
        this.d = true;
    }

    public void stopReport(boolean z) {
        com.tencent.ydkbeacon.a.e.c.a("BeaconReport", "stop report by user.", new java.lang.Object[0]);
        com.tencent.ydkbeacon.a.b.a.a().a(z);
        com.tencent.ydkbeacon.base.net.d.c().close();
    }
}
