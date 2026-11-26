package com.tencent.hlyyb.common.d.b.b.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.hlyyb.common.d.b.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.a.p f579a = new com.tencent.hlyyb.common.a.p();

    public a() {
        java.lang.String string = com.tencent.hlyyb.common.a.a().getSharedPreferences(d(), 0).getString("halley_cloud_param_content", "");
        if (android.text.TextUtils.isEmpty(string)) {
            return;
        }
        try {
            this.f579a.a(string);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.tencent.hlyyb.common.a.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", "").commit();
        }
    }

    private static java.lang.String d() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("Halley_Cloud_Param_Content_");
        sb.append(com.tencent.hlyyb.common.a.c());
        sb.append("_for_SettingsHandler");
        sb.append(com.tencent.hlyyb.common.a.b() ? "_test" : "");
        return sb.toString();
    }

    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final void a(com.tencent.hlyyb.common.d.b.b.a aVar) {
        aVar.f571a.put("confVersion", this.f579a.c());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final void a(org.json.JSONObject jSONObject) {
        android.os.Handler handlerK;
        com.tencent.hlyyb.common.d.b.b.c.b bVar;
        try {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("Setting");
            if (jSONObjectOptJSONObject != null) {
                java.lang.String strOptString = jSONObjectOptJSONObject.optString(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
                if (!android.text.TextUtils.isEmpty(strOptString)) {
                    this.f579a.a(strOptString);
                    com.tencent.hlyyb.common.a.a().getSharedPreferences(d(), 0).edit().putString("halley_cloud_param_content", this.f579a.f537a.toString()).commit();
                }
            }
            handlerK = com.tencent.hlyyb.common.a.k();
            bVar = new com.tencent.hlyyb.common.d.b.b.c.b(this);
        } catch (java.lang.Throwable th) {
            try {
                th.printStackTrace();
                handlerK = com.tencent.hlyyb.common.a.k();
                bVar = new com.tencent.hlyyb.common.d.b.b.c.b(this);
            } catch (java.lang.Throwable th2) {
                com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.d.b.b.c.b(this));
                throw th2;
            }
        }
        handlerK.post(bVar);
    }

    @Override // com.tencent.hlyyb.common.d.b.b.b, com.tencent.hlyyb.common.d.a
    public final void b() {
        com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.d.b.b.c.b(this));
    }

    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final java.lang.String c() {
        return "settings";
    }
}
