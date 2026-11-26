package com.tencent.msdk.dns.base.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {
    public static void a(int i, int i2, java.lang.String str, java.util.Map map) {
        a(com.tencent.msdk.dns.base.b.g.a(i), i2, str, map);
    }

    private static void a(java.util.List list, int i, java.lang.String str, java.util.Map map) {
        java.util.Iterator it = list.iterator();
        while (it.hasNext()) {
            com.tencent.msdk.dns.base.b.e eVar = (com.tencent.msdk.dns.base.b.e) it.next();
            if (!eVar.a(i, str, map)) {
                com.tencent.msdk.dns.base.log.DnsLog.d("%s report failed", eVar.a());
            }
        }
    }
}
