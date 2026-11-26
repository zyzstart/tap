package com.qq.gdt.action;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static com.qq.gdt.action.a.a a(java.lang.String str, org.json.JSONObject jSONObject) {
        com.qq.gdt.action.a.a aVar = new com.qq.gdt.action.a.a(com.qq.gdt.action.e.a().i(), str, java.lang.System.currentTimeMillis(), jSONObject);
        com.qq.gdt.action.f.a.a().a(aVar);
        return aVar;
    }

    public static java.lang.String a(java.lang.String str) {
        java.lang.String strA = com.qq.gdt.action.h.r.a(str);
        java.lang.String strD = com.qq.gdt.action.e.a().d();
        java.lang.String strE = com.qq.gdt.action.e.a().e();
        java.lang.String strA2 = com.qq.gdt.action.h.h.a(com.qq.gdt.action.e.a().f().getEncoded());
        return com.qq.gdt.action.h.p.a(strA + "," + strA2 + "," + com.qq.gdt.action.h.r.a(strA + strD + strE + strA2));
    }

    public static java.lang.String a(org.json.JSONObject jSONObject) throws java.lang.Exception {
        return com.qq.gdt.action.h.a.a(com.qq.gdt.action.e.a().f(), com.qq.gdt.action.h.w.a(jSONObject.toString().getBytes()));
    }

    public static org.json.JSONArray a(java.util.List<com.qq.gdt.action.a.a> list) throws org.json.JSONException {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<com.qq.gdt.action.a.a> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(a(it.next()));
        }
        return jSONArray;
    }

    public static org.json.JSONObject a() throws org.json.JSONException {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        android.content.Context contextC = com.qq.gdt.action.e.a().c();
        d(jSONObject);
        b(jSONObject, contextC);
        c(jSONObject);
        a(jSONObject, contextC);
        b(jSONObject);
        if (com.qq.gdt.action.b.a(contextC).b()) {
            jSONObject.putOpt("his", b());
        }
        jSONObject.putOpt("conf_version", com.qq.gdt.action.b.a(contextC).a());
        c(jSONObject, contextC);
        return jSONObject;
    }

    private static org.json.JSONObject a(com.qq.gdt.action.a.a aVar) throws org.json.JSONException {
        if (aVar == null) {
            return null;
        }
        if (com.qq.gdt.action.h.t.a(aVar.b())) {
            com.qq.gdt.action.h.l.b("ActionType must not be empty.");
            return null;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        jSONObject.putOpt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID, aVar.f());
        jSONObject.putOpt("action_time", java.lang.Long.valueOf(aVar.c() / 1000));
        jSONObject.putOpt("action_time_mills", java.lang.Long.valueOf(aVar.c()));
        jSONObject.putOpt("action_type", aVar.b());
        jSONObject.putOpt("revised_action_time", java.lang.Long.valueOf(aVar.g()));
        jSONObject.putOpt("retry", java.lang.Boolean.valueOf(aVar.h() == 2));
        jSONObject.putOpt("action_id", aVar.a());
        org.json.JSONObject jSONObjectD = aVar.d();
        if (jSONObjectD != null && jSONObjectD.has(com.qq.gdt.action.ActionParam.Key.OUTER_ACTION_ID)) {
            jSONObject.putOpt(com.qq.gdt.action.ActionParam.Key.OUTER_ACTION_ID, jSONObjectD.optString(com.qq.gdt.action.ActionParam.Key.OUTER_ACTION_ID));
            jSONObjectD.remove(com.qq.gdt.action.ActionParam.Key.OUTER_ACTION_ID);
        }
        jSONObject.putOpt("action_param", jSONObjectD);
        return jSONObject;
    }

    private static void a(org.json.JSONObject jSONObject, android.content.Context context) throws org.json.JSONException {
        java.lang.String strC = com.qq.gdt.action.h.g.c();
        java.lang.String strC2 = com.qq.gdt.action.h.g.c(context);
        java.lang.String strA = com.qq.gdt.action.h.g.a(context);
        int iB = com.qq.gdt.action.h.g.b(context);
        jSONObject.putOpt("pkg_name", strC);
        jSONObject.putOpt("process_name", com.qq.gdt.action.e.a().k());
        jSONObject.putOpt("appn", strC2);
        jSONObject.putOpt("app_version_name", strA);
        jSONObject.putOpt("app_version_code", java.lang.String.valueOf(iB));
        jSONObject.putOpt("channel_id", com.qq.gdt.action.e.a().l());
        jSONObject.putOpt("user_unique_id", com.qq.gdt.action.e.a().m());
        try {
            android.content.pm.PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            jSONObject.put("install_time", packageInfo.firstInstallTime);
            jSONObject.put("update_time", packageInfo.lastUpdateTime);
        } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            com.qq.gdt.action.h.l.c("getPackageInfo err");
        }
    }

    private static org.json.JSONArray b() throws org.json.JSONException {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.add(5, -24);
        for (com.qq.gdt.action.a.c cVar : com.qq.gdt.action.a.b.a(com.qq.gdt.action.e.a().c()).a(java.lang.Integer.parseInt(new java.text.SimpleDateFormat("yyyyMMddHH").format(calendar.getTime())))) {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.putOpt("status", java.lang.Integer.valueOf(cVar.a()));
            jSONObject.putOpt(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_SESSION_ID, cVar.b());
            jSONObject.putOpt("action_type", cVar.c());
            jSONObject.putOpt("count", java.lang.Integer.valueOf(cVar.d()));
            jSONArray.put(jSONObject);
        }
        return jSONArray;
    }

    private static void b(org.json.JSONObject jSONObject) throws org.json.JSONException {
        int iB = com.qq.gdt.action.f.b();
        jSONObject.putOpt("sdkv", com.qq.gdt.action.f.a());
        jSONObject.putOpt("sdkvc", java.lang.Integer.valueOf(iB));
        jSONObject.putOpt("report_session_id", com.qq.gdt.action.e.a().i());
    }

    private static void b(org.json.JSONObject jSONObject, android.content.Context context) throws org.json.JSONException {
        jSONObject.putOpt("qadid", com.qq.gdt.action.e.a.a(context));
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObject3 = new org.json.JSONObject();
        org.json.JSONObject jSONObject4 = new org.json.JSONObject();
        for (java.util.Map.Entry<java.lang.String, android.content.pm.PackageInfo> entry : com.qq.gdt.action.h.o.d(context).entrySet()) {
            java.lang.String key = entry.getKey();
            android.content.pm.PackageInfo value = entry.getValue();
            jSONObject2.putOpt(key, java.lang.Long.valueOf(value.firstInstallTime));
            jSONObject3.putOpt(key, java.lang.Long.valueOf(value.lastUpdateTime));
            jSONObject4.putOpt(key, value.versionName);
        }
        jSONObject.putOpt("fit", jSONObject2);
        jSONObject.putOpt("lut", jSONObject3);
        jSONObject.putOpt("av", jSONObject4);
        jSONObject.putOpt("cv", com.qq.gdt.action.h.o.e());
        jSONObject.putOpt("cc", com.qq.gdt.action.h.o.a(context));
        android.util.Pair<java.lang.Integer, java.lang.Integer> pairB = com.qq.gdt.action.h.o.b(context);
        jSONObject.putOpt("sw", pairB.first);
        jSONObject.putOpt("sh", pairB.second);
        jSONObject.putOpt("tz", com.qq.gdt.action.h.o.c());
        jSONObject.putOpt("ov", com.qq.gdt.action.h.o.b());
        jSONObject.putOpt("alv", java.lang.Integer.valueOf(com.qq.gdt.action.h.o.a()));
        jSONObject.putOpt("is", java.lang.Long.valueOf(com.qq.gdt.action.h.o.d()));
        jSONObject.putOpt("rs", java.lang.Long.valueOf(com.qq.gdt.action.h.o.c(context)));
    }

    private static void c(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.lang.String str = android.os.Build.MODEL;
        java.lang.String language = java.util.Locale.getDefault().getLanguage();
        java.lang.String str2 = android.os.Build.VERSION.RELEASE;
        java.lang.Integer numH = com.qq.gdt.action.h.g.h();
        java.lang.String strA = com.qq.gdt.action.h.m.a();
        int i = android.os.Build.VERSION.SDK_INT;
        jSONObject.putOpt("md", str);
        jSONObject.putOpt("lg", language);
        jSONObject.putOpt("os", "Android");
        jSONObject.putOpt("osv", str2);
        jSONObject.putOpt("op", numH);
        jSONObject.putOpt("apil", java.lang.Integer.valueOf(i));
        jSONObject.putOpt("dn", strA);
        jSONObject.putOpt("tz", com.qq.gdt.action.h.g.k());
    }

    private static void c(org.json.JSONObject jSONObject, android.content.Context context) {
        try {
            com.tencent.turingfd.sdk.ams.ad.ITuringDID turingDID = com.tencent.turingfd.sdk.ams.ad.TuringDIDService.getTuringDID(context);
            if (turingDID.getErrorCode() == 0) {
                jSONObject.putOpt("taid", turingDID.getTAID());
                jSONObject.putOpt("m10", turingDID.getAIDTicket());
            } else {
                com.qq.gdt.action.h.l.c("getTuringDID err:" + turingDID.getErrorCode());
            }
        } catch (java.lang.Exception e) {
            com.qq.gdt.action.h.l.b("appendTuringDID err", e);
        }
    }

    private static void d(org.json.JSONObject jSONObject) throws org.json.JSONException {
        java.lang.Object lowerCase;
        java.lang.String strB = com.qq.gdt.action.h.g.b();
        java.lang.Object lowerCase2 = null;
        if (com.qq.gdt.action.h.t.a(strB)) {
            lowerCase = null;
        } else {
            lowerCase2 = com.qq.gdt.action.h.r.a(strB.toLowerCase()).toLowerCase();
            lowerCase = com.qq.gdt.action.h.r.a(strB).toLowerCase();
        }
        java.lang.String strD = com.qq.gdt.action.h.g.d();
        if (!com.qq.gdt.action.h.t.a(strD)) {
            strD = com.qq.gdt.action.h.r.a(strD).toLowerCase();
        }
        java.lang.String strF = com.qq.gdt.action.h.g.f();
        if (!com.qq.gdt.action.h.t.a(strF)) {
            strF = com.qq.gdt.action.h.r.a(strF.replace(":", "").toUpperCase()).toLowerCase();
        }
        jSONObject.putOpt("hash_imei", lowerCase2);
        jSONObject.putOpt("hash_capital_meid", lowerCase);
        jSONObject.putOpt("device_id", com.qq.gdt.action.e.a().j());
        jSONObject.putOpt("hash_android_id", strD);
        jSONObject.putOpt("hash_mac", strF);
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Iterator<java.lang.String> it = com.qq.gdt.action.h.g.i().iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        jSONObject.putOpt("all_hash_imei", jSONArray);
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        java.util.Iterator<java.lang.String> it2 = com.qq.gdt.action.h.g.j().iterator();
        while (it2.hasNext()) {
            jSONArray2.put(it2.next());
        }
        jSONObject.putOpt("all_hash_meid", jSONArray2);
    }
}
