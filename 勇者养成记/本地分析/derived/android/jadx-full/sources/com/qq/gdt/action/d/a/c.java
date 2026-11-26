package com.qq.gdt.action.d.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class c extends com.qq.gdt.action.d.a.a<com.qq.gdt.action.d.f> {
    public c() {
        this(false);
    }

    public c(boolean z) {
        super(z);
    }

    @Override // com.qq.gdt.action.d.a.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.qq.gdt.action.d.f b(com.qq.gdt.action.d.b.i iVar) throws java.lang.Exception {
        com.qq.gdt.action.d.f fVar = new com.qq.gdt.action.d.f(-1, "Unknown message");
        if (iVar != null) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(iVar.e().b());
                fVar.a(jSONObject.optInt("code", -1));
                fVar.a(jSONObject.optString("message", "Deserialize message error"));
                if (jSONObject.has(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA)) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
                    if (jSONObject2.has("conf")) {
                        com.qq.gdt.action.b.a(com.qq.gdt.action.e.a().c()).a(jSONObject2.getJSONObject("conf"));
                    }
                }
            } catch (java.io.IOException | org.json.JSONException unused) {
                com.qq.gdt.action.h.l.a("Deserialize service response error", new java.lang.Object[0]);
                fVar.a("Deserialize service response error");
            }
        }
        return fVar;
    }
}
