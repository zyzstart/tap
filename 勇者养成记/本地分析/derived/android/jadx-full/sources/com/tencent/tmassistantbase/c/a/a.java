package com.tencent.tmassistantbase.c.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.tmassistantbase.c.a.a f1011a;

    private a() {
    }

    public static synchronized com.tencent.tmassistantbase.c.a.a a() {
        if (f1011a == null) {
            f1011a = new com.tencent.tmassistantbase.c.a.a();
        }
        return f1011a;
    }

    public void a(java.lang.String str) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("B1", com.tencent.tmassistantbase.util.k.a().f());
        map.put("B2", com.tencent.tmassistantbase.util.k.a().d);
        map.put("B3", com.tencent.tmassistantbase.util.k.a().g());
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB != null) {
            map.put("B4", contextB.getPackageName());
        } else {
            map.put("B4", "null");
        }
        map.put("B5", com.tencent.tmassistantbase.util.k.a().j());
        map.put("B6", android.os.Build.VERSION.RELEASE);
        com.tencent.tmassistantbase.util.TMLog.d("BeaconReportManager", "[BeaconReportAdpater]report|eventCode:" + str + "|paras:" + map.toString());
        a(str, true, -1L, -1L, map, true);
    }

    public void a(java.lang.String str, boolean z, java.lang.String... strArr) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("B1", com.tencent.tmassistantbase.util.k.a().f());
        map.put("B2", com.tencent.tmassistantbase.util.k.a().d);
        map.put("B3", com.tencent.tmassistantbase.util.k.a().g());
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB != null) {
            map.put("B4", contextB.getPackageName());
        } else {
            map.put("B4", "null");
        }
        map.put("B5", com.tencent.tmassistantbase.util.k.a().j());
        map.put("B6", android.os.Build.VERSION.RELEASE);
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                map.put("B" + (7 + i), strArr[i]);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.d("BeaconReportManager", "[BeaconReportAdpater]report|eventCode:" + str + "|paras:" + map.toString());
        a(str, z, -1L, -1L, map, true);
    }

    public void a(java.lang.String str, java.lang.String... strArr) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("B1", com.tencent.tmassistantbase.util.k.a().f());
        map.put("B2", com.tencent.tmassistantbase.util.k.a().d);
        map.put("B3", com.tencent.tmassistantbase.util.k.a().g());
        android.content.Context contextB = com.tencent.tmassistantbase.util.k.a().b();
        if (contextB != null) {
            map.put("B4", contextB.getPackageName());
        } else {
            map.put("B4", "null");
        }
        map.put("B5", com.tencent.tmassistantbase.util.k.a().j());
        map.put("B6", android.os.Build.VERSION.RELEASE);
        if (strArr != null && strArr.length > 0) {
            for (int i = 0; i < strArr.length; i++) {
                map.put("B" + (7 + i), strArr[i]);
            }
        }
        com.tencent.tmassistantbase.util.TMLog.d("BeaconReportManager", "[BeaconReportAdpater]report|eventCode:" + str + "|paras:" + map.toString());
        a(str, true, -1L, -1L, map, true);
    }

    public void a(boolean z, boolean z2) {
        com.tencent.beaconselfupdate.event.UserAction.setLogAble(z, z2);
    }

    public boolean a(java.lang.String str, boolean z, long j, long j2, java.util.Map map, boolean z2) {
        com.tencent.tmassistantbase.util.l.a(com.tencent.tmassistantbase.util.m.ID_BEACON_REPORT).post(new com.tencent.tmassistantbase.c.a.b(this, str, z, j, j2, map, z2));
        return true;
    }

    public void b() {
        com.tencent.beaconselfupdate.event.UserAction.setAppkey("[REDACTED]");
        com.tencent.beaconselfupdate.event.UserAction.initUserAction(com.tencent.tmassistantbase.util.k.a().b());
        a(false, false);
    }
}
