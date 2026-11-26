package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class s {
    public static com.tencent.beacon.core.event.RDBean a(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        return a(context, str, str2, z, j, j2, map, z2, false);
    }

    public static com.tencent.beacon.core.event.RDBean a(android.content.Context context, java.lang.String str, java.lang.String str2, boolean z, long j, long j2, java.util.Map map, boolean z2, boolean z3) {
        if (str2 == null) {
            return null;
        }
        com.tencent.beacon.core.info.g gVarB = com.tencent.beacon.core.info.g.b(com.tencent.beacon.event.UserAction.mContext);
        if (gVarB == null) {
            com.tencent.beacon.core.e.d.b("[event] BeaconInfo is null!", new java.lang.Object[0]);
            return null;
        }
        java.lang.String userID = com.tencent.beacon.event.UserAction.getUserID(str);
        long jB = com.tencent.beacon.core.e.b.b(gVarB.j());
        java.lang.String strD = gVarB.d();
        java.lang.String strB = com.tencent.beacon.core.e.e.b(context);
        if (strB == null) {
            strB = "null";
        }
        java.util.HashMap map2 = new java.util.HashMap();
        if (map != null) {
            map2.putAll(map);
        }
        boolean z4 = com.tencent.beacon.core.event.EventStrategyBean.getInstance().isTidyEventFields() && !com.tencent.beacon.core.e.b.a(str2);
        com.tencent.beacon.core.info.c cVarA = com.tencent.beacon.core.info.c.a(context);
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(context);
        if (!z4) {
            map2.put("A1", "" + userID);
            java.lang.String strK = cVarA.k();
            if (strK != null && !strK.equals("")) {
                map2.put(com.tencent.connect.common.Constants.SOURCE_QQ, "" + strK);
            }
            map2.put("A141", com.tencent.beacon.qimei.QimeiSDK.getInstance().getBeaconIdInfo(context));
            map2.put("A143", cVarA.j());
            map2.put("A2", "" + cVarA.c());
            map2.put("A4", cVarA.e());
            map2.put("A6", cVarA.f());
            map2.put("A7", cVarA.a());
            com.tencent.beacon.qimei.Qimei qimei = com.tencent.beacon.qimei.QimeiSDK.getInstance().getQimei(context);
            if (qimei != null && qimei.getQimeiMap() != null) {
                map2.putAll(qimei.getQimeiMap());
            }
            map2.put("A23", gVarB.b(str));
            map2.put("A31", "" + cVarA.b());
            map2.put("A67", com.tencent.beacon.core.info.a.c(context));
            map2.put("A76", com.tencent.beacon.core.info.a.a());
            map2.put("A89", eVarD.c(context));
            map2.put("A52", "" + eVarD.n(context));
            map2.put("A58", eVarD.i() ? "Y" : "N");
            map2.put("A12", eVarD.j());
            map2.put("A17", eVarD.m(context));
            map2.put("A20", eVarD.p(context));
            map2.put("A69", eVarD.q(context));
            map2.put("A60", eVarD.o(context));
            map2.put("A9", eVarD.d());
            map2.put("A10", eVarD.h());
            if (!map2.containsKey("A95")) {
                map2.put("A95", com.tencent.beacon.core.info.a.a(context));
            }
            map2.put("A99", z2 ? "Y" : "N");
            map2.put("A34", jB + "");
        }
        java.util.ArrayList arrayListD = com.tencent.beacon.core.d.k.a(context).d();
        if (arrayListD != null && arrayListD.size() > 0) {
            com.tencent.beacon.core.d.l lVar = (com.tencent.beacon.core.d.l) arrayListD.get(0);
            java.lang.String eventSerialNumber = lVar.getEventSerialNumber(str, str2, z2);
            if (eventSerialNumber != null) {
                map2.put("A100", eventSerialNumber);
            }
            if (!map2.containsKey("A88")) {
                map2.put("A88", lVar.getAppFirstInstallTime());
            }
        }
        if (!"".equals(gVarB.l())) {
            map2.put("A113", gVarB.l());
        }
        com.tencent.beacon.core.event.RDBean rDBean = new com.tencent.beacon.core.event.RDBean();
        rDBean.setEN("" + str2);
        rDBean.setTM(jB);
        rDBean.setTP(com.tencent.beacon.core.event.RDBean.TP_UA);
        rDBean.setEMap(map2);
        rDBean.setImmediatelyUpload(z3);
        rDBean.setApn(strB);
        rDBean.setSrcIp(strD);
        rDBean.setEventResult(z);
        rDBean.setElapse(j);
        rDBean.setSize(j2);
        return rDBean;
    }

    public static com.tencent.beacon.core.protocol.event.EventRecord a(com.tencent.beacon.core.event.RDBean rDBean) {
        java.util.Map eMap;
        if (rDBean == null || !com.tencent.beacon.core.event.RDBean.TP_UA.equals(rDBean.getTP()) || (eMap = rDBean.getEMap()) == null) {
            return null;
        }
        try {
            com.tencent.beacon.core.protocol.event.EventRecord eventRecord = new com.tencent.beacon.core.protocol.event.EventRecord();
            eventRecord.eventName = rDBean.getEN();
            eventRecord.eventTime = rDBean.getTM();
            eventRecord.apn = rDBean.getApn() != null ? rDBean.getApn() : eventRecord.apn;
            eventRecord.srcIp = rDBean.getSrcIp() != null ? rDBean.getSrcIp() : eventRecord.srcIp;
            eventRecord.cosumeTime = rDBean.getElapse();
            eventRecord.eventResult = rDBean.isEventResult();
            eventRecord.packageSize = rDBean.getSize();
            java.lang.String strA = com.tencent.beacon.core.e.c.a(rDBean.getEN(), eMap);
            eventRecord.eventValue = strA;
            if (strA == null) {
                return null;
            }
            return eventRecord;
        } catch (java.lang.Throwable th) {
            com.tencent.beacon.core.e.d.a(th);
            return null;
        }
    }
}
