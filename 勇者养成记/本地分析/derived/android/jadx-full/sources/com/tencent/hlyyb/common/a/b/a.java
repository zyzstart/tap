package com.tencent.hlyyb.common.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.os.Handler f525a = com.tencent.hlyyb.common.a.k();

    public static void a(java.lang.String str, int i, int i2, java.lang.String str2, java.util.Map map, java.util.Map map2, boolean z) {
        f525a.post(new com.tencent.hlyyb.common.a.b.c(str, i, i2, str2, map, map2, z));
    }

    static /* synthetic */ void a(java.lang.String str, int i, int i2, java.lang.String str2, java.util.Map map, java.util.Map map2, boolean z, boolean z2) {
        int iA;
        boolean zA;
        if (z) {
            try {
                if (com.tencent.hlyyb.common.a.f.m()) {
                    i2 = -288;
                } else {
                    com.tencent.hlyyb.common.a.f.e();
                    if (!com.tencent.hlyyb.common.a.f.i()) {
                        i2 = -4;
                    } else if (!com.tencent.hlyyb.common.a.n.a()) {
                        i2 = -3;
                    }
                }
                if (i2 == -3) {
                    str2 = "ping failed, " + str2;
                }
            } catch (java.lang.Throwable unused) {
                return;
            }
        }
        if (z2) {
            iA = com.tencent.hlyyb.common.a.e.a(str, i, i2, map);
            zA = com.tencent.hlyyb.common.a.e.a(iA);
        } else {
            iA = 1;
            zA = true;
        }
        if (zA) {
            if (map2 != null) {
                if (map2.containsKey("B83")) {
                    map2.put("B83", com.tencent.hlyyb.common.f.c.a(java.lang.Long.parseLong((java.lang.String) map2.get("B83")), "yyyy-MM-dd HH:mm:ss.SSS"));
                }
                if (map2.containsKey("B84")) {
                    map2.put("B84", com.tencent.hlyyb.common.f.c.a(java.lang.Long.parseLong((java.lang.String) map2.get("B84")), "yyyy-MM-dd HH:mm:ss.SSS"));
                }
            }
            if (map == null) {
                map = new java.util.HashMap();
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(iA);
            map.put("B31", sb.toString());
            java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
            sb2.append(i2);
            map.put("B7", sb2.toString());
            map.put("B1", com.tencent.hlyyb.common.a.h());
            map.put("B2", com.tencent.hlyyb.common.a.b);
            map.put("B30", com.tencent.hlyyb.common.a.f());
            java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
            sb3.append(i);
            map.put("B3", sb3.toString());
            java.lang.String strJ = com.tencent.hlyyb.common.a.j();
            if (!android.text.TextUtils.isEmpty(strJ)) {
                map.put("B4", strJ);
            }
            map.put("B5", com.tencent.hlyyb.common.d.j.a());
            java.lang.String strC = com.tencent.hlyyb.common.a.f.c();
            if (!android.text.TextUtils.isEmpty(strC)) {
                map.put("B29", strC);
            }
            if (com.tencent.hlyyb.common.a.e.a("access_report_detail", 0, 1, 1) == 1) {
                if (map2 != null) {
                    map.putAll(map2);
                }
                map.put("B6", com.tencent.hlyyb.common.a.f.b());
                if (i2 != -4 && !android.text.TextUtils.isEmpty(str2)) {
                    map.put("B8", str2);
                }
                map.put("D1", com.tencent.hlyyb.common.a.d());
                java.lang.StringBuilder sb4 = new java.lang.StringBuilder();
                sb4.append(com.tencent.hlyyb.common.a.e());
                map.put("D2", sb4.toString());
                map.put("D3", com.tencent.hlyyb.common.a.d);
            }
            com.tencent.hlyyb.common.a.e.a(str, i2 == 0, map, false, true);
        }
    }

    public static boolean a(java.lang.String str, int i, int i2, java.lang.String str2, java.util.Map map, java.util.Map map2, boolean z, int i3) {
        boolean zA = com.tencent.hlyyb.common.a.e.a(100);
        if (zA) {
            f525a.post(new com.tencent.hlyyb.common.a.b.b(str, i, i2, str2, map, map2, z));
        }
        return zA;
    }
}
