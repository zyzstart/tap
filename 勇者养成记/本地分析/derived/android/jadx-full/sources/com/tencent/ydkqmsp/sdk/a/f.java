package com.tencent.ydkqmsp.sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f1288a = "Qp.RPT";

    static class a implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f1289a;
        final /* synthetic */ org.json.JSONObject b;

        a(int i, org.json.JSONObject jSONObject) {
            this.f1289a = i;
            this.b = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.ydkqmsp.sdk.a.f.b(this.f1289a, this.b);
        }
    }

    static class b implements com.tencent.ydkqmsp.sdk.b.e {
        b() {
        }

        @Override // com.tencent.ydkqmsp.sdk.b.e
        public void a(int i, org.json.JSONObject jSONObject) {
            if (i == 161) {
                com.tencent.ydkqmsp.sdk.f.g.a(com.tencent.ydkqmsp.sdk.a.f.f1288a, 1, java.lang.String.format("ret: %d", java.lang.Integer.valueOf(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_2)));
            }
        }
    }

    public static void a(java.lang.String str, int i) {
        if (str == null || !(str instanceof java.lang.String)) {
            return;
        }
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        org.json.JSONObject jSONObject2 = new org.json.JSONObject();
        org.json.JSONObject jSONObjectA = com.tencent.ydkqmsp.sdk.a.d.a(3);
        if (a(jSONObjectA)) {
            try {
                jSONObject2.put(com.tencent.ydkqmsp.sdk.a.e.a(15), jSONObjectA);
                jSONObject2.put(com.tencent.ydkqmsp.sdk.a.e.a(16), new org.json.JSONObject().put("log", str));
                jSONArray.put(jSONObject2);
                jSONObject.put("arr", jSONArray);
                com.tencent.ydkqmsp.sdk.f.g.a(f1288a, 1, jSONObject2.toString());
                com.tencent.ydkqmsp.sdk.app.b.e().a(new com.tencent.ydkqmsp.sdk.a.f.a(i, jSONObject));
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
    }

    protected static boolean a(org.json.JSONObject jSONObject) {
        try {
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(12), com.tencent.ydkqmsp.sdk.a.c.b());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(13), com.tencent.ydkqmsp.sdk.a.c.e());
            jSONObject.put(com.tencent.ydkqmsp.sdk.a.e.a(14), com.tencent.ydkqmsp.sdk.a.c.a());
            return true;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(int i, org.json.JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.tencent.ydkqmsp.sdk.f.g.a(f1288a, 0, "Rpt: " + jSONObject);
        com.tencent.ydkqmsp.sdk.b.g.b().a(3, com.tencent.ydkqmsp.sdk.app.a.getAppID(), i, jSONObject, new com.tencent.ydkqmsp.sdk.a.f.b());
    }
}
