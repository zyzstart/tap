package com.tencent.hlyyb.common.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f593a = true;
    private static boolean b = true;

    public static void a(java.lang.String str, int i, int i2, java.lang.String str2, java.util.Map map, java.util.Map map2, boolean z) {
        com.tencent.hlyyb.common.a.b.a.a(str, i, i2, str2, map, map2, z, 100);
    }

    public static boolean a(java.lang.String str, int i, java.util.Map map) {
        if (i == com.tencent.hlyyb.common.a.c()) {
            if (f593a && ("HLReqRspEvent".equals(str) || "HLHttpAgent".equals(str))) {
                f593a = false;
                return true;
            }
            if (b && "HLHttpDirect".equals(str)) {
                java.lang.String str2 = (java.lang.String) map.get("B15");
                if (!com.tencent.hlyyb.common.f.c.a(str2) && str2.equals("app")) {
                    b = false;
                    return true;
                }
            }
        }
        return false;
    }

    public static void b(java.lang.String str, int i, int i2, java.lang.String str2, java.util.Map map, java.util.Map map2, boolean z) {
        com.tencent.hlyyb.common.a.b.a.a(str, i, i2, str2, map, map2, z);
    }
}
