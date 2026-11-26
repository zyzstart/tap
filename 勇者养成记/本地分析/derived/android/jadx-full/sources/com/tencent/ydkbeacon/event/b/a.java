package com.tencent.ydkbeacon.event.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a extends com.tencent.ydkbeacon.event.b.c {
    @Override // com.tencent.ydkbeacon.event.b.c
    protected com.tencent.ydkbeacon.event.open.BeaconEvent a(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
        com.tencent.ydkbeacon.event.open.EventType type = beaconEvent.getType();
        if (type == com.tencent.ydkbeacon.event.open.EventType.DT_REALTIME || type == com.tencent.ydkbeacon.event.open.EventType.DT_NORMAL) {
            java.util.Map params = beaconEvent.getParams();
            com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
            params.put("dt_imei2", "" + fVarP.n());
            params.put("dt_meid", "" + fVarP.u());
            params.put("dt_mf", "" + fVarP.t());
            beaconEvent.setParams(params);
        }
        return beaconEvent;
    }
}
