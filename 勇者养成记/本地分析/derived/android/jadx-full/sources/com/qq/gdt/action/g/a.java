package com.qq.gdt.action.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {
    public static void a(org.json.JSONArray jSONArray, com.qq.gdt.action.a.a aVar, int i) {
        try {
            jSONArray.put(new org.json.JSONObject().putOpt("eventId", java.lang.Integer.valueOf(i)).putOpt("actionType", aVar.b()).putOpt("uniqActionId", aVar.a()));
        } catch (org.json.JSONException unused) {
        }
    }

    public static boolean a(org.json.JSONArray jSONArray, java.lang.String str, com.qq.gdt.action.d.b.b bVar) {
        return a(jSONArray, str, false, bVar);
    }

    public static boolean a(org.json.JSONArray jSONArray, java.lang.String str, boolean z, com.qq.gdt.action.d.b.b bVar) {
        if (jSONArray != null && (z || com.qq.gdt.action.b.a(com.qq.gdt.action.e.a().c()).e())) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject();
                jSONObject.putOpt("bid", 10021014);
                if (com.qq.gdt.action.e.a().b()) {
                    jSONObject.putOpt("hashImei", com.qq.gdt.action.h.g.a());
                    com.qq.gdt.action.h.v.a(jSONObject, com.qq.gdt.action.e.a().c());
                }
                jSONObject.putOpt("requestCgi", str);
                jSONObject.putOpt("appPackageName", com.qq.gdt.action.h.g.c());
                jSONObject.putOpt("sdkVersion", com.qq.gdt.action.f.a());
                jSONObject.putOpt("osVersion", java.lang.Integer.valueOf(android.os.Build.VERSION.SDK_INT));
                jSONObject.putOpt("netType", com.qq.gdt.action.h.m.a());
                jSONObject.putOpt("osType", 2);
                jSONObject.putOpt("actionSetId", com.qq.gdt.action.e.a().d());
                jSONObject.putOpt(com.tencent.ysdk.shell.framework.channel.ApkChannelTool.CHANNEL_ID, com.qq.gdt.action.e.a().l());
                jSONObject.putOpt("user_unique_id", com.qq.gdt.action.e.a().m());
                jSONObject.putOpt("sessionId", com.qq.gdt.action.e.a().i());
                jSONObject.putOpt("body", jSONArray);
                com.qq.gdt.action.h.l.a("Dp3Service#report：\n" + com.qq.gdt.action.h.k.a(jSONObject.toString()), new java.lang.Object[0]);
                com.qq.gdt.action.d.c cVarB = com.qq.gdt.action.d.b.d().a("http://dp3.qq.com/stdlog").a(jSONObject.toString().getBytes()).b();
                if (bVar == null) {
                    bVar = new com.qq.gdt.action.d.b.b() { // from class: com.qq.gdt.action.g.a.1
                        @Override // com.qq.gdt.action.d.b.b
                        public void a(com.qq.gdt.action.d.b.i iVar) {
                            iVar.e().close();
                        }

                        @Override // com.qq.gdt.action.d.b.b
                        public void a(java.lang.Throwable th) {
                            com.qq.gdt.action.h.l.a("上报Dp3时发生错误：" + th.getMessage(), new java.lang.Object[0]);
                        }
                    };
                }
                cVarB.b(bVar);
                return true;
            } catch (java.lang.Exception e) {
                com.qq.gdt.action.h.l.a("处理Dp3请求时发生错误：" + e.getMessage(), new java.lang.Object[0]);
            }
        }
        return false;
    }
}
