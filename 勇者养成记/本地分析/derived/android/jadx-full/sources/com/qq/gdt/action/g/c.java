package com.qq.gdt.action.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    public interface a {
        void a(java.util.List<com.qq.gdt.action.a.a> list, int i, java.lang.String str, int i2);

        void a(java.util.List<com.qq.gdt.action.a.a> list, boolean z);
    }

    public static void a(java.util.List<com.qq.gdt.action.a.a> list, long j, java.lang.String str, int i, java.lang.String str2, int i2) {
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        try {
            for (com.qq.gdt.action.a.a aVar : list) {
                com.qq.gdt.action.g.a.a(jSONArray, aVar, 1000);
                com.qq.gdt.action.g.a.a(jSONArray, aVar, 1004);
                com.qq.gdt.action.g.a.a(jSONArray, aVar, android.support.v4.view.PointerIconCompat.TYPE_CELL);
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.putOpt("duration", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - j));
                jSONObject.putOpt("httpStatus", java.lang.Integer.valueOf(i2));
                jSONObject.putOpt("actionType", aVar.b());
                jSONObject.putOpt("actionTime", java.lang.Long.valueOf(aVar.c()));
                jSONObject.putOpt("uniqActionId", aVar.a());
                jSONObject.putOpt(com.tencent.ysdk.framework.dynamic.constant.PluginConst.EVENT_PARAM_ERROR_CODE, java.lang.Integer.valueOf(i));
                jSONObject.putOpt("errorMsg", str2);
                jSONObject.putOpt("eventId", java.lang.Integer.valueOf(i == 0 ? 1008 : 1009));
                jSONArray.put(jSONObject);
            }
        } catch (org.json.JSONException unused) {
        }
        com.qq.gdt.action.g.a.a(jSONArray, str, (com.qq.gdt.action.d.b.b) null);
    }

    public static void a(final java.util.List<com.qq.gdt.action.a.a> list, final com.qq.gdt.action.g.c.a aVar) {
        if (com.qq.gdt.action.h.f.a(list)) {
            com.qq.gdt.action.h.l.b("No actions need to track.");
            return;
        }
        final long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        try {
            org.json.JSONObject jSONObjectA = com.qq.gdt.action.d.a();
            org.json.JSONArray jSONArrayA = com.qq.gdt.action.d.a(list);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.putOpt("info", jSONObjectA);
            jSONObject.putOpt("actions", jSONArrayA);
            com.qq.gdt.action.h.l.a("TrackService#track\n加密前：\n" + com.qq.gdt.action.h.k.a(jSONObject.toString()), new java.lang.Object[0]);
            java.lang.String strA = com.qq.gdt.action.d.a(jSONObject);
            com.qq.gdt.action.h.l.a("加密后：\n" + strA, new java.lang.Object[0]);
            java.lang.String strA2 = com.qq.gdt.action.d.a(strA);
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.putOpt("v", "0.1");
            jSONObject2.putOpt("id", com.qq.gdt.action.e.a().d());
            jSONObject2.putOpt(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, strA);
            jSONObject2.putOpt("sign", strA2);
            com.qq.gdt.action.h.l.a("正式请求：\n" + com.qq.gdt.action.h.k.a(jSONObject2.toString()), new java.lang.Object[0]);
            final java.lang.String strOptString = jSONObjectA.optString("hash_imei", "");
            final java.lang.String str = a(strOptString) ? "https://a.gdt.qq.com/sdk" : "http://a.gdt.qq.com/sdk";
            com.qq.gdt.action.d.b.d().a(str).a(jSONObject2.toString().getBytes()).b().a(new com.qq.gdt.action.d.a.c() { // from class: com.qq.gdt.action.g.c.1
                @Override // com.qq.gdt.action.d.a.a
                public void a(int i, com.qq.gdt.action.d.f fVar) {
                    com.qq.gdt.action.g.c.a(list, jCurrentTimeMillis, str, fVar.a(), fVar.b(), i);
                    if (i == 200 && fVar.a() == 0) {
                        com.qq.gdt.action.g.c.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(list, !com.qq.gdt.action.h.t.a(strOptString));
                            return;
                        }
                        return;
                    }
                    com.qq.gdt.action.g.c.a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(list, fVar.a(), fVar.b(), i);
                    }
                }

                @Override // com.qq.gdt.action.d.a.a
                public void b(java.lang.Throwable th) {
                    com.qq.gdt.action.g.c.a(list, jCurrentTimeMillis, str, -2, th.getMessage(), -1);
                    com.qq.gdt.action.g.c.a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(list, -2, th.getMessage(), -1);
                    }
                }
            });
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.c("处理行为数据请求时发生错误：" + th.getMessage());
            if (aVar != null) {
                aVar.a(list, -2, th.getMessage(), -1);
            }
        }
    }

    private static boolean a(java.lang.String str) {
        if (com.qq.gdt.action.h.t.a(str)) {
            return false;
        }
        return new java.util.ArrayList(java.util.Arrays.asList("a")).contains(java.lang.Character.valueOf(str.charAt(str.length() - 1)));
    }
}
