package com.tencent.tmselfupdatesdk.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    public static void a(java.lang.String str, boolean z, long j, boolean z2, java.lang.String... strArr) {
        java.util.HashMap map = new java.util.HashMap();
        map.put("B1", "3.0.1_3010_33");
        map.put("B2", com.tencent.tmassistantbase.util.k.a().d());
        map.put("B3", com.tencent.tmassistantbase.util.k.a().g());
        map.put("B4", java.lang.String.valueOf(z));
        map.put("B5", com.tencent.beaconselfupdate.event.UserAction.getQIMEI());
        map.put("B6", com.tencent.tmassistantbase.util.k.a().f());
        if (strArr != null) {
            int i = 8;
            for (java.lang.String str2 : strArr) {
                map.put("B" + i, str2);
                i++;
            }
        }
        if (com.tencent.tmassistantbase.common.a.b()) {
            com.tencent.tmassistantbase.util.x.a("BeaconReport", "【eventCode】:" + str + "【result】:" + z + "【time】:" + j + "【isImmediately】:" + z2);
            for (int i2 = 1; i2 < 20; i2++) {
                java.lang.String str3 = "B" + i2;
                if (map.containsKey(str3)) {
                    com.tencent.tmassistantbase.util.x.a("BeaconReport", "【" + str3 + "】:" + ((java.lang.String) map.get(str3)));
                }
            }
        }
        com.tencent.beaconselfupdate.event.UserAction.onUserAction(str, z, j, -1L, map, z2);
    }

    public static void a(java.lang.String str, boolean z, java.lang.String... strArr) {
        a(str, z, -1L, true, strArr);
    }
}
