package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.ydkbeacon.a.d.g f1285a;

    static java.lang.String a(android.content.Context context) {
        com.tencent.ydkbeacon.a.d.g gVarB = b(context);
        if (gVarB != null) {
            java.lang.String str = (java.lang.String) gVarB.a("Q_V3", "");
            if (!android.text.TextUtils.isEmpty(str)) {
                return str;
            }
        }
        com.tencent.ydkbeacon.b.a.b bVarA = com.tencent.ydkbeacon.b.a.b.a();
        java.lang.String strA = com.tencent.ydkbeacon.a.c.g.a() != 1 ? bVarA.a("BEACON_QIMEI_1", "") : bVarA.a("QIMEI_DENGTA", "qimei_v2", "");
        return android.text.TextUtils.isEmpty(strA) ? bVarA.a("QIMEI_DENGTA", "") : strA;
    }

    public static java.util.HashMap a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return null;
        }
        java.util.HashMap map = new java.util.HashMap(3);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            java.util.Iterator<java.lang.String> itKeys = jSONObject.keys();
            if (itKeys != null) {
                while (itKeys.hasNext()) {
                    java.lang.String next = itKeys.next();
                    map.put(next, jSONObject.getString(next));
                }
                return map;
            }
        } catch (org.json.JSONException e) {
            com.tencent.ydkbeacon.a.e.c.a("[qimei] jsonToMap error: " + e.getMessage(), new java.lang.Object[0]);
            map.put("A3", str);
        }
        return map;
    }

    public static void a(long j) {
        com.tencent.ydkbeacon.a.d.a.a().edit().putLong("q_i_t", j);
    }

    public static void a(android.content.Context context, java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        b(context).b("Q_V3", str);
    }

    public static boolean a() {
        long j = com.tencent.ydkbeacon.a.d.a.a().getLong("q_i_t", 0L);
        boolean z = j == 0 || java.lang.System.currentTimeMillis() - j >= 86400000;
        com.tencent.ydkbeacon.a.e.c.a("[qimei] lastUpdateQimei time: " + j + ", isOver24h: " + z, new java.lang.Object[0]);
        return z;
    }

    private static synchronized com.tencent.ydkbeacon.a.d.g b(android.content.Context context) {
        if (f1285a == null) {
            try {
                f1285a = com.tencent.ydkbeacon.a.d.g.a(context, "Q_V3");
            } catch (java.lang.Exception e) {
                com.tencent.ydkbeacon.a.e.c.a("[qimei] qimeiFile create error: " + e.getMessage(), new java.lang.Object[0]);
                com.tencent.ydkbeacon.a.b.d.b().a("511", "getQimeiStoreFile error", e);
            }
        }
        return f1285a;
    }

    public static void b(android.content.Context context, java.lang.String str) {
        if (com.tencent.ydkbeacon.a.e.c.a()) {
            new android.os.Handler(android.os.Looper.getMainLooper()).post(new com.tencent.ydkbeacon.qimei.e(context, str));
        }
    }

    public static boolean b() {
        java.lang.String strA = com.tencent.ydkbeacon.d.g.b().a("qimeiZeroPeak");
        return strA != null && "y".equalsIgnoreCase(strA) && java.util.Calendar.getInstance().get(11) == 0;
    }

    public static boolean c() {
        java.lang.String strA = com.tencent.ydkbeacon.d.g.b().a("updateQimei");
        return !"n".equalsIgnoreCase(strA) && "y".equalsIgnoreCase(strA);
    }

    public static void d() {
        com.tencent.ydkbeacon.a.d.g gVar = f1285a;
        if (gVar != null) {
            gVar.c();
        }
    }
}
