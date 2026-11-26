package com.qq.gdt.action.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    public static com.qq.gdt.action.d.f a() {
        try {
            org.json.JSONObject jSONObjectB = b();
            javax.crypto.SecretKey secretKeyF = com.qq.gdt.action.e.a().f();
            com.qq.gdt.action.h.l.a("LaunchService#launch 加密前\n" + com.qq.gdt.action.h.k.a(jSONObjectB.toString()), new java.lang.Object[0]);
            java.lang.String strA = a(jSONObjectB, secretKeyF);
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.putOpt(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA, strA);
            jSONObject.putOpt("os", "Android");
            jSONObject.putOpt("sdkv", com.qq.gdt.action.f.a());
            jSONObject.putOpt("sdkvc", java.lang.Integer.valueOf(com.qq.gdt.action.f.b()));
            com.qq.gdt.action.h.l.a("LaunchService#launch 正式请求\n" + com.qq.gdt.action.h.k.a(jSONObject.toString()), new java.lang.Object[0]);
            com.qq.gdt.action.d.b.i iVarA = com.qq.gdt.action.d.b.d().a("http://a.gdt.qq.com/getSdkConf").a(jSONObject.toString().getBytes()).b().a();
            com.qq.gdt.action.d.f fVar = new com.qq.gdt.action.d.f(-1, "Unknown message");
            if (iVarA != null) {
                try {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject(iVarA.e().b());
                    fVar.a(jSONObject2.optInt("code", -1));
                    fVar.a(jSONObject2.optString("message", "Deserialize message error"));
                    if (jSONObject2.has(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA)) {
                        org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
                        if (jSONObject3.has("conf")) {
                            com.qq.gdt.action.b.a(com.qq.gdt.action.e.a().c()).a(jSONObject3.getJSONObject("conf"));
                        }
                    }
                } catch (java.io.IOException | org.json.JSONException unused) {
                    com.qq.gdt.action.h.l.a("Deserialize service response error", new java.lang.Object[0]);
                    fVar.a("Deserialize service response error");
                }
            }
            return fVar;
        } catch (java.lang.Throwable th) {
            com.qq.gdt.action.h.l.b(com.qq.gdt.action.h.t.a("LaunchService launch(%s) exception", "http://a.gdt.qq.com/getSdkConf"), th);
            return null;
        }
    }

    public static java.lang.String a(org.json.JSONObject jSONObject, javax.crypto.SecretKey secretKey) throws java.lang.Exception {
        byte[] bArrB = com.qq.gdt.action.h.a.b(secretKey, jSONObject.toString().getBytes());
        byte[] bArr = new byte[48];
        java.lang.System.arraycopy(com.qq.gdt.action.h.r.b(bArrB), 0, bArr, 0, 16);
        java.lang.System.arraycopy(secretKey.getEncoded(), 0, bArr, 16, 32);
        byte[] bArrA = com.qq.gdt.action.h.j.a(bArr);
        byte[] bArr2 = new byte[bArrB.length + 130];
        java.lang.System.arraycopy(new byte[]{0, 1}, 0, bArr2, 0, 2);
        java.lang.System.arraycopy(bArrA, 0, bArr2, 2, 128);
        java.lang.System.arraycopy(bArrB, 0, bArr2, 130, bArrB.length);
        return com.qq.gdt.action.h.h.a(bArr2);
    }

    private static org.json.JSONObject b() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            jSONObject.putOpt("did", com.qq.gdt.action.e.a().j());
            jSONObject.putOpt("sdkv", com.qq.gdt.action.f.a());
            jSONObject.putOpt("asid", com.qq.gdt.action.e.a().d());
            jSONObject.putOpt("hash_imei", com.qq.gdt.action.h.g.a());
            jSONObject.putOpt("hash_android_id", com.qq.gdt.action.h.g.e());
            jSONObject.putOpt("hash_mac", com.qq.gdt.action.h.g.g());
            com.qq.gdt.action.h.v.a(jSONObject, com.qq.gdt.action.e.a().c());
            jSONObject.putOpt("conf_version", com.qq.gdt.action.b.a(com.qq.gdt.action.e.a().c()).a());
        } catch (org.json.JSONException e) {
            com.qq.gdt.action.h.l.b("Json Exception while build init req", e);
        }
        return jSONObject;
    }
}
