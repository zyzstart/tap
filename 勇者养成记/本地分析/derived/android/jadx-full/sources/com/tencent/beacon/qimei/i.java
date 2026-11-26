package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {
    public static java.util.Map a(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return null;
        }
        java.util.HashMap map = new java.util.HashMap(10);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            while (itKeys.hasNext()) {
                java.lang.String next = itKeys.next();
                map.put(next, jSONObject.getString(next));
            }
            return map;
        } catch (org.json.JSONException e) {
            com.tencent.beacon.core.e.d.a("[qimei] jsonToMap error: " + e.getMessage(), new java.lang.Object[0]);
            map.put("A3", str);
            return map;
        }
    }

    public static void a(android.content.Context context) {
        int iE = e(context);
        if (!com.tencent.beacon.core.e.b.a().equals(d(context))) {
            f(context);
            iE = 0;
        }
        com.tencent.beacon.core.a.f.a(context).b().a("GEN_QIMEI_TIMES", java.lang.Integer.valueOf(iE + 1)).a();
    }

    public static void a(android.content.Context context, long j) {
        com.tencent.beacon.core.a.f.a(context).b().a("QIMEI_TINE", java.lang.Long.valueOf(j)).a();
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(str)) {
            return;
        }
        (com.tencent.beacon.core.info.f.a() != 1 ? com.tencent.beacon.core.a.f.a(context).b().a("BEACON_QIMEI_1", (java.lang.Object) str) : com.tencent.beacon.core.a.f.a(context).b().b("qimei_v2", str)).a();
        com.tencent.beacon.core.e.d.a("[qimei] update QIMEI:%s, and save to sp.", str);
    }

    public static void b(android.content.Context context, java.lang.String str) {
        if (com.tencent.beacon.core.e.d.b()) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.tencent.beacon.qimei.h(context, str));
        }
    }

    public static boolean b(android.content.Context context) {
        long jA = com.tencent.beacon.core.a.f.a(context).a("QIMEI_TINE", 0L);
        boolean z = jA == 0 || java.lang.System.currentTimeMillis() - jA >= 86400000;
        com.tencent.beacon.core.e.d.a("[qimei] lastUpdateQimei time: " + jA + ", isOver24h: " + z, new java.lang.Object[0]);
        return z;
    }

    public static java.lang.String c(android.content.Context context) {
        java.lang.String strA;
        if (context == null) {
            return "";
        }
        com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
        if (com.tencent.beacon.core.info.f.a() != 1) {
            strA = fVarA.a("BEACON_QIMEI_1", "");
            if (android.text.TextUtils.isEmpty(strA)) {
                strA = fVarA.a("QIMEI_DENGTA", "");
            }
        } else {
            strA = fVarA.a("QIMEI_DENGTA", "qimei_v2", "");
        }
        com.tencent.beacon.core.e.d.a("[qimei] loadQIMEIJson: %s.", strA);
        return strA;
    }

    private static java.lang.String d(android.content.Context context) {
        return com.tencent.beacon.core.a.f.a(context).a("GEN_QIMEI", "");
    }

    private static int e(android.content.Context context) {
        return com.tencent.beacon.core.a.f.a(context).a("GEN_QIMEI_TIMES", 0);
    }

    private static void f(android.content.Context context) {
        com.tencent.beacon.core.a.f.a(context).b().a("GEN_QIMEI", (java.lang.Object) com.tencent.beacon.core.e.b.a()).a();
    }
}
