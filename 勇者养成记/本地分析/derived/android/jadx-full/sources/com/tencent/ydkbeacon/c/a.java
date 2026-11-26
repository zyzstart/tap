package com.tencent.ydkbeacon.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.Map f1231a = new java.util.HashMap();

    public static void a(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        f1231a.put(str, java.lang.Long.valueOf(jCurrentTimeMillis));
        com.tencent.ydkbeacon.a.e.c.a("[page] onPageIn cost time: %d", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }

    public static void b(java.lang.String str) {
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        java.util.Map map = f1231a;
        if (map == null) {
            com.tencent.ydkbeacon.a.e.c.e("[page] please call 'onPageIn' first!", new java.lang.Object[0]);
            return;
        }
        java.lang.Long l = (java.lang.Long) map.get(str);
        if (l == null) {
            com.tencent.ydkbeacon.a.e.c.e("[page] please call 'onPageIn' first!", new java.lang.Object[0]);
            return;
        }
        ((com.tencent.ydkbeacon.module.StatModule) com.tencent.ydkbeacon.a.c.c.d().a(com.tencent.ydkbeacon.module.ModuleName.STAT)).a(str, jCurrentTimeMillis - l.longValue(), jCurrentTimeMillis);
        f1231a.remove(str);
        com.tencent.ydkbeacon.a.e.c.a("[page] onPageOut cost time: %d", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis));
    }
}
