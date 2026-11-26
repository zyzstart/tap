package com.tencent.hlyyb.common.d.b.b.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.hlyyb.common.d.b.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f582a = false;

    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final void a(com.tencent.hlyyb.common.d.b.b.a aVar) {
        com.tencent.hlyyb.common.d.b.b.a.c cVar = new com.tencent.hlyyb.common.d.b.b.a.c();
        com.tencent.hlyyb.common.d.b.b.a.b bVar = new com.tencent.hlyyb.common.d.b.b.a.b();
        com.tencent.hlyyb.common.d.b.b.a.a aVar2 = new com.tencent.hlyyb.common.d.b.b.a.a();
        try {
            if (com.tencent.hlyyb.common.f.c.a(bVar.b) || !f582a) {
                aVar.f571a.put("needUpdateState", 1);
                f582a = true;
            } else {
                aVar.f571a.put("needUpdateState", 0);
            }
            if (com.tencent.hlyyb.common.f.c.a(bVar.b)) {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_DEVICE_PARAM_MODEL, cVar.f574a);
                jSONObject.put("osVersion", cVar.b);
                jSONObject.put("imei", cVar.c);
                jSONObject.put("imsi", cVar.d);
                jSONObject.put("pseudoId", cVar.e);
                aVar.f571a.put("RegistDeviceInfo", jSONObject);
            }
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("platform", (int) bVar.f573a);
            jSONObject2.put("deviceId", bVar.b);
            jSONObject2.put("sdkVersion", bVar.c);
            aVar.f571a.put("BindDeviceInfo", jSONObject2);
            org.json.JSONObject jSONObject3 = new org.json.JSONObject();
            jSONObject3.put("bundle", aVar2.f572a);
            jSONObject3.put("verCode", aVar2.b);
            jSONObject3.put("verName", aVar2.c);
            jSONObject3.put("appId", aVar2.e);
            jSONObject3.put(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_UUID, aVar2.d);
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            jSONArray.put(jSONObject3);
            aVar.f571a.put("AppState", jSONArray);
            aVar.f571a.put("netType", com.tencent.hlyyb.common.d.j.a(com.tencent.hlyyb.common.a.f.h()));
            aVar.f571a.put("oper", com.tencent.hlyyb.common.d.b.a.c.a(com.tencent.hlyyb.common.a.f.k().intValue()));
        } catch (java.lang.Exception unused) {
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0049 A[Catch: all -> 0x0054, TRY_LEAVE, TryCatch #0 {all -> 0x0054, blocks: (B:2:0x0000, B:8:0x001a, B:10:0x0026, B:12:0x0030, B:14:0x0036, B:16:0x003d, B:18:0x0049), top: B:22:0x0000 }] */
    /* JADX WARN: Code duplicated, block: B:26:? A[RETURN, SYNTHETIC] */
    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final void a(org.json.JSONObject jSONObject) {
        java.lang.String strOptString;
        try {
            java.lang.String strOptString2 = jSONObject.optString("result");
            if (!android.text.TextUtils.isEmpty(strOptString2)) {
                try {
                    if (java.lang.Integer.parseInt(strOptString2) == 1002) {
                        com.tencent.hlyyb.common.d.j.a("");
                        return;
                    }
                } catch (java.lang.Throwable unused) {
                }
            }
            java.lang.String strOptString3 = jSONObject.optString("deviceId");
            if (!android.text.TextUtils.isEmpty(strOptString3)) {
                java.lang.String strA = com.tencent.hlyyb.common.d.j.a();
                if (!android.text.TextUtils.isEmpty(strOptString3) && !strOptString3.equals(strA)) {
                }
                strOptString = jSONObject.optString("oper");
                if (android.text.TextUtils.isEmpty(strOptString)) {
                }
                com.tencent.hlyyb.common.d.b.a.c.a().a(com.tencent.hlyyb.common.a.f.b(), strOptString);
            }
            strOptString3 = "";
            com.tencent.hlyyb.common.d.j.a(strOptString3);
            strOptString = jSONObject.optString("oper");
            if (android.text.TextUtils.isEmpty(strOptString)) {
                com.tencent.hlyyb.common.d.b.a.c.a().a(com.tencent.hlyyb.common.a.f.b(), strOptString);
            }
        } catch (java.lang.Throwable unused2) {
        }
    }

    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final java.lang.String c() {
        return "state";
    }
}
