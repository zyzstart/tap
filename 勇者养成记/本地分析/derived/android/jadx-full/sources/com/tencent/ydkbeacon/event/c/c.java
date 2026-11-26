package com.tencent.ydkbeacon.event.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {
    public static int a(com.tencent.ydkbeacon.event.open.EventType eventType) {
        if (eventType == com.tencent.ydkbeacon.event.open.EventType.NORMAL || eventType == com.tencent.ydkbeacon.event.open.EventType.DT_NORMAL) {
            return 0;
        }
        if (eventType == com.tencent.ydkbeacon.event.open.EventType.REALTIME || eventType == com.tencent.ydkbeacon.event.open.EventType.DT_REALTIME) {
        }
        return 1;
    }

    private static com.tencent.ydkbeacon.pack.EventRecordV2 a(com.tencent.ydkbeacon.event.EventBean eventBean) {
        if (eventBean == null) {
            return null;
        }
        com.tencent.ydkbeacon.pack.EventRecordV2 eventRecordV2 = new com.tencent.ydkbeacon.pack.EventRecordV2();
        eventRecordV2.appKey = eventBean.getAppKey();
        eventRecordV2.apn = eventBean.getApn() != null ? eventBean.getApn() : "";
        eventRecordV2.srcIp = eventBean.getSrcIp() != null ? eventBean.getSrcIp() : "";
        eventRecordV2.eventCode = eventBean.getEventCode();
        eventRecordV2.valueType = eventBean.getValueType();
        eventRecordV2.mapValue = eventBean.getEventValue();
        eventRecordV2.byteValue = eventBean.getByteValue();
        eventRecordV2.eventTime = eventBean.getEventTime();
        eventRecordV2.eventResult = eventBean.getEventResult();
        eventRecordV2.eventType = eventBean.getEventType();
        eventRecordV2.reserved = eventBean.getReserved();
        return eventRecordV2;
    }

    public static com.tencent.ydkbeacon.pack.RequestPackageV2 a(java.util.List list) {
        com.tencent.ydkbeacon.pack.RequestPackageV2 requestPackageV2 = new com.tencent.ydkbeacon.pack.RequestPackageV2();
        requestPackageV2.appVersion = com.tencent.ydkbeacon.a.c.b.a();
        requestPackageV2.common = a();
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.ydkbeacon.pack.EventRecordV2 eventRecordV2A = a((com.tencent.ydkbeacon.event.EventBean) it.next());
            if (eventRecordV2A != null) {
                arrayList.add(eventRecordV2A);
            }
        }
        requestPackageV2.events = arrayList;
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        requestPackageV2.mainAppKey = cVarD.f();
        requestPackageV2.model = android.os.Build.MODEL;
        requestPackageV2.osVersion = com.tencent.ydkbeacon.a.c.f.p().z();
        requestPackageV2.packageName = com.tencent.ydkbeacon.a.c.b.b();
        requestPackageV2.platformId = cVarD.g();
        requestPackageV2.sdkId = cVarD.h();
        requestPackageV2.sdkVersion = cVarD.i();
        requestPackageV2.reserved = "";
        return requestPackageV2;
    }

    public static java.lang.String a(java.lang.String str) {
        if (str != null && str.trim().length() != 0) {
            if (f(str.trim())) {
                java.lang.String strTrim = str.trim();
                return strTrim.length() > 16 ? strTrim.substring(0, 16) : strTrim;
            }
            com.tencent.ydkbeacon.a.e.c.e("[core] channelID should be Numeric! channelID:" + str, new java.lang.Object[0]);
        }
        return android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    }

    private static java.util.Map a() {
        java.util.HashMap map = new java.util.HashMap();
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        com.tencent.ydkbeacon.a.c.c cVarD = com.tencent.ydkbeacon.a.c.c.d();
        map.put("A31", "" + fVarP.v());
        map.put("A67", com.tencent.ydkbeacon.a.c.b.c(cVarD.c()));
        map.put("A76", com.tencent.ydkbeacon.a.c.b.d());
        map.put("A89", fVarP.a(cVarD.c()));
        map.put("A52", java.lang.String.valueOf(fVarP.F()));
        map.put("A58", fVarP.q() ? "Y" : "N");
        map.put("A12", fVarP.r());
        map.put("A17", fVarP.B());
        map.put("A10", android.os.Build.MODEL);
        map.put("A2", "" + fVarP.m());
        map.put("A4", fVarP.o());
        map.put("A6", fVarP.s());
        map.put("A7", fVarP.e());
        map.put("A20", fVarP.J());
        map.put("A69", fVarP.K());
        map.put("A60", fVarP.I());
        map.put("A9", android.os.Build.BRAND);
        return map;
    }

    public static boolean a(int i) {
        if (i == 0) {
            return false;
        }
        if (i != 1) {
        }
        return true;
    }

    public static java.lang.String b(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            if (!com.tencent.ydkbeacon.a.e.e.f1201a.get()) {
                return "";
            }
            com.tencent.ydkbeacon.a.b.d.b().a("101", "eventCode == null");
            com.tencent.ydkbeacon.a.e.e.a("eventCode == null");
            return "";
        }
        java.lang.String strTrim = str.replace('|', '_').trim();
        if (!f(strTrim)) {
            java.lang.String str2 = str + " is not ASCII";
            com.tencent.ydkbeacon.a.b.d.b().a("101", str2);
            com.tencent.ydkbeacon.a.e.e.a(str2);
            return "";
        }
        if (strTrim.length() <= 128) {
            return strTrim;
        }
        java.lang.String str3 = str + " length > 128.";
        com.tencent.ydkbeacon.a.b.d.b().a("101", str3);
        com.tencent.ydkbeacon.a.e.e.a(str3);
        return strTrim.substring(0, 128);
    }

    public static java.lang.String c(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return "DefaultPageID";
        }
        return str.length() > 50 ? str.substring(0, 50) : str;
    }

    public static java.lang.String d(java.lang.String str) {
        java.lang.String strTrim = str.replace('|', '_').trim();
        if (f(strTrim)) {
            if (strTrim.length() < 5) {
                com.tencent.ydkbeacon.a.e.c.e("[core] userID length should < 5!", new java.lang.Object[0]);
            }
            return strTrim.length() > 128 ? strTrim.substring(0, 128) : strTrim;
        }
        com.tencent.ydkbeacon.a.e.c.e("[core] userID should be ASCII code in 32-126! userID:" + str, new java.lang.Object[0]);
        return "10000";
    }

    public static com.tencent.ydkbeacon.module.BeaconModule e(java.lang.String str) {
        return (com.tencent.ydkbeacon.module.BeaconModule) java.lang.Class.forName(str).newInstance();
    }

    private static boolean f(java.lang.String str) {
        int length = str.length();
        boolean z = true;
        while (true) {
            length--;
            if (length < 0) {
                return z;
            }
            char cCharAt = str.charAt(length);
            if (cCharAt < ' ' || cCharAt >= 127) {
                z = false;
            }
        }
    }
}
