package com.tencent.ydkbeacon.event.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    @android.support.annotation.Nullable
    public static com.tencent.ydkbeacon.event.EventBean a(com.tencent.ydkbeacon.event.open.BeaconEvent beaconEvent) {
        java.util.Map mapA = com.tencent.ydkbeacon.base.net.c.d.a(beaconEvent.getCode(), beaconEvent.getParams());
        if (mapA == null) {
            return null;
        }
        com.tencent.ydkbeacon.event.EventBean eventBean = new com.tencent.ydkbeacon.event.EventBean();
        java.lang.String code = beaconEvent.getCode();
        eventBean.setEventCode(code);
        eventBean.setAppKey(beaconEvent.getAppKey());
        eventBean.setApn(com.tencent.ydkbeacon.base.net.c.d.c());
        eventBean.setSrcIp(com.tencent.ydkbeacon.a.c.c.d().b());
        eventBean.setEventCode(code);
        eventBean.setValueType(0);
        eventBean.setEventValue(mapA);
        java.lang.String str = (java.lang.String) beaconEvent.getParams().get("A34");
        if (!android.text.TextUtils.isEmpty(str)) {
            eventBean.setEventTime(java.lang.Long.parseLong(str));
        }
        eventBean.setEventResult(beaconEvent.isSucceed());
        eventBean.setEventType(com.tencent.ydkbeacon.event.c.c.a(beaconEvent.getType()));
        eventBean.setReserved("");
        return eventBean;
    }
}
