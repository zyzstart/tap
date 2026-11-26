package com.tencent.ydkbeacon.event.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.ydkbeacon.event.b.c implements com.tencent.ydkbeacon.a.a.d {
    private boolean b = false;
    private java.lang.String c;

    public b() {
        com.tencent.ydkbeacon.a.a.b.a().a(2, this);
    }

    @Override // com.tencent.ydkbeacon.event.b.c
    com.tencent.ydkbeacon.event.open.BeaconEvent a(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
        if (this.b && !com.tencent.ydkbeacon.a.e.b.a(beaconEvent.getCode())) {
            return beaconEvent;
        }
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        android.content.Context contextC = cVarD.c();
        java.util.Map params = beaconEvent.getParams();
        com.tencent.ydkbeacon.qimei.Qimei qimeiB = com.tencent.ydkbeacon.qimei.a.a().b();
        if (qimeiB != null && !qimeiB.isEmpty()) {
            params.putAll(qimeiB.getQimeiMap());
        }
        params.put("A143", com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getOmgID());
        params.put("A144", com.tencent.ydkbeacon.a.c.f.p().y());
        params.put("A19", com.tencent.ydkbeacon.a.c.f.p().w());
        params.put(com.tencent.connect.common.Constants.SOURCE_QQ, com.tencent.ydkbeacon.a.c.b.c());
        params.put("A95", "" + com.tencent.ydkbeacon.a.c.b.a());
        params.put("A141", com.tencent.ydkbeacon.qimei.QimeiSDK.getInstance().getBeaconIdInfo());
        params.put("A23", cVarD.a());
        params.put("A48", com.tencent.ydkbeacon.a.c.c.d().e());
        java.lang.String appKey = beaconEvent.getAppKey();
        com.tencent.ydkbeacon.module.EventModule eventModule = (com.tencent.ydkbeacon.module.EventModule) cVarD.a(com.tencent.ydkbeacon.module.ModuleName.EVENT);
        params.put("[REDACTED]", eventModule.b(appKey));
        params.put("A99", beaconEvent.isRealtime() ? "Y" : "N");
        params.put("A72", cVarD.i());
        params.put("A34", java.lang.String.valueOf(com.tencent.ydkbeacon.a.e.b.b()));
        if (!params.containsKey("A88")) {
            if (android.text.TextUtils.isEmpty(this.c)) {
                this.c = com.tencent.ydkbeacon.a.c.b.a(contextC);
            }
            params.put("A88", this.c);
        }
        params.put("[REDACTED]", com.tencent.ydkbeacon.event.c.e.a(contextC, appKey).a(beaconEvent.getCode(), beaconEvent.isRealtime()));
        java.util.Map mapA = eventModule.a(appKey);
        if (mapA != null) {
            params.putAll(mapA);
        }
        beaconEvent.setParams(params);
        return beaconEvent;
    }

    @Override // com.tencent.ydkbeacon.a.a.d
    public void onEvent(com.tencent.ydkbeacon.a.a.c cVar) {
        java.util.HashMap map;
        if (cVar.f1177a == 2 && (map = (java.util.HashMap) cVar.b.get("d_m")) != null) {
            this.b = com.tencent.ydkbeacon.a.e.b.a((java.lang.String) map.get("tidyEF"), this.b);
        }
    }
}
