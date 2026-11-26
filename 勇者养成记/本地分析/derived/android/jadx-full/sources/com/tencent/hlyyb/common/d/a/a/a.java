package com.tencent.hlyyb.common.d.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a extends com.tencent.hlyyb.common.d.a.a implements com.tencent.hlyyb.common.a.c.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.d.b.b.b.a f564a = new com.tencent.hlyyb.common.d.b.b.b.a("HttpSchedulerClient");
    private com.tencent.hlyyb.common.a.c.a b;

    private static void a(com.tencent.hlyyb.common.a.c.a aVar, org.json.JSONArray jSONArray) {
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                org.json.JSONObject jSONObject = jSONArray.getJSONObject(i);
                org.json.JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("domains");
                org.json.JSONArray jSONArrayOptJSONArray2 = jSONObject.optJSONArray("resultlist");
                java.lang.String strOptString = jSONObject.optString("schedulecode");
                java.lang.String strOptString2 = jSONObject.optString("httpsport");
                if (jSONArrayOptJSONArray != null && jSONArrayOptJSONArray2 != null) {
                    for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                        com.tencent.hlyyb.common.a.c.b bVar = new com.tencent.hlyyb.common.a.c.b(jSONArrayOptJSONArray.getString(i2), strOptString);
                        try {
                            bVar.d = java.lang.Integer.parseInt(strOptString2);
                            for (int i3 = 0; i3 < jSONArrayOptJSONArray2.length(); i3++) {
                                java.lang.String string = jSONArrayOptJSONArray2.getString(i3);
                                com.tencent.hlyyb.common.a.a aVar2 = new com.tencent.hlyyb.common.a.a();
                                if (aVar2.a(string)) {
                                    bVar.c.add(aVar2);
                                }
                            }
                            aVar.a(bVar);
                        } catch (java.lang.Throwable unused) {
                        }
                    }
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                return;
            }
        }
    }

    static /* synthetic */ void a(com.tencent.hlyyb.common.d.a.a.a aVar, byte[] bArr, java.lang.String str) {
        try {
            if (android.text.TextUtils.isEmpty(str) || com.tencent.hlyyb.common.f.c.a(bArr)) {
                return;
            }
            org.json.JSONObject jSONObject = new org.json.JSONObject(new java.lang.String(bArr));
            com.tencent.hlyyb.common.a.c.a aVar2 = new com.tencent.hlyyb.common.a.c.a(str);
            jSONObject.getString("ipInfo");
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("resultMap");
            if (jSONObjectOptJSONObject != null) {
                java.util.Iterator<java.lang.String> itKeys = jSONObjectOptJSONObject.keys();
                while (itKeys.hasNext()) {
                    org.json.JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(itKeys.next());
                    if (jSONArrayOptJSONArray != null) {
                        a(aVar2, jSONArrayOptJSONArray);
                    }
                }
            }
            aVar.b = aVar2;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.tencent.hlyyb.common.a.c.c
    public final java.util.List a() {
        com.tencent.hlyyb.common.a.c.a aVar = this.b;
        if (aVar != null) {
            if (aVar.a().equals(com.tencent.hlyyb.common.a.f.b())) {
                java.util.ArrayList arrayList = new java.util.ArrayList();
                java.util.Iterator it = this.b.b().entrySet().iterator();
                while (it.hasNext()) {
                    arrayList.add(((java.util.Map.Entry) it.next()).getValue());
                }
                return arrayList;
            }
            com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.d.a.a.b(this));
        }
        return null;
    }

    @Override // com.tencent.hlyyb.common.d.a.a, com.tencent.hlyyb.common.d.b
    public final void a(java.lang.String str, byte[] bArr, java.lang.String str2) {
        this.f564a.a(str, bArr);
        com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.d.a.a.b(this));
    }

    @Override // com.tencent.hlyyb.common.d.a.a
    public final java.lang.String b() {
        return "accessscheduler";
    }

    @Override // com.tencent.hlyyb.common.d.a.a, com.tencent.hlyyb.common.d.b
    public final void c() {
        com.tencent.hlyyb.common.d.f.d().a();
    }
}
