package com.tencent.beacon.core.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.Map f171a;

    private static void a() {
        if (f171a == null) {
            f171a = new java.util.HashMap();
        }
    }

    public static void a(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        a();
        f171a.put(str, java.lang.Long.valueOf(jCurrentTimeMillis));
        com.tencent.beacon.core.e.d.a("[page] onPageIn cost time: %d", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    private static void a(java.lang.String str, long j, long j2) {
        com.tencent.beacon.core.a.d.a().a(new com.tencent.beacon.core.event.j(j2, str, j));
    }

    public static void b(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.Map map = f171a;
        if (map == null) {
            com.tencent.beacon.core.e.d.i("[page] please call 'onPageIn' first!", new java.lang.Object[0]);
            return;
        }
        java.lang.Long l = (java.lang.Long) map.get(str);
        if (l == null) {
            com.tencent.beacon.core.e.d.i("[page] please call 'onPageIn' first!", new java.lang.Object[0]);
            return;
        }
        a(str, jCurrentTimeMillis - l.longValue(), jCurrentTimeMillis);
        f171a.remove(str);
        com.tencent.beacon.core.e.d.a("[page] onPageOut cost time: %d", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
