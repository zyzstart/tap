package com.tencent.hlyyb.common.d.b.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.hlyyb.common.d.b.b.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.hlyyb.common.d.b.b.b.a f576a = new com.tencent.hlyyb.common.d.b.b.b.a("HttpSchedulerHandler");

    @Override // com.tencent.hlyyb.common.d.b.b.b, com.tencent.hlyyb.common.d.a
    public final void a() {
        com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.d.b.b.b.c(this, null, null));
    }

    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final void a(com.tencent.hlyyb.common.d.b.b.a aVar) {
        java.lang.String string;
        org.json.JSONObject jSONObject;
        try {
            try {
                org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                com.tencent.hlyyb.common.d.b.b.b.a aVar2 = this.f576a;
                com.tencent.hlyyb.common.a.f.e();
                byte[] bArrA = aVar2.a(com.tencent.hlyyb.common.a.f.b());
                org.json.JSONObject jSONObject3 = !com.tencent.hlyyb.common.f.c.a(bArrA) ? new org.json.JSONObject(new java.lang.String(bArrA)) : null;
                if (jSONObject3 != null) {
                    org.json.JSONObject jSONObjectOptJSONObject = jSONObject3.optJSONObject("resultMap");
                    if (jSONObjectOptJSONObject != null) {
                        java.util.Iterator<java.lang.String> itKeys = jSONObjectOptJSONObject.keys();
                        while (itKeys.hasNext()) {
                            java.lang.String next = itKeys.next();
                            org.json.JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(next);
                            if (jSONArrayOptJSONArray != null) {
                                org.json.JSONObject jSONObject4 = new org.json.JSONObject();
                                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                                    org.json.JSONObject jSONObject5 = jSONArrayOptJSONArray.getJSONObject(i);
                                    jSONObject4.put(jSONObject5.optString("unit"), jSONObject5.optString("schedulecode"));
                                }
                                jSONObject2.put(next, jSONObject4);
                            }
                        }
                    } else {
                        java.lang.StringBuilder sb = new java.lang.StringBuilder();
                        sb.append(com.tencent.hlyyb.common.a.c());
                        string = sb.toString();
                        jSONObject = new org.json.JSONObject();
                    }
                    aVar.f571a.put("directScheduleCodes", jSONObject2);
                }
                java.lang.StringBuilder sb2 = new java.lang.StringBuilder();
                sb2.append(com.tencent.hlyyb.common.a.c());
                string = sb2.toString();
                jSONObject = new org.json.JSONObject();
                jSONObject2.put(string, jSONObject);
                aVar.f571a.put("directScheduleCodes", jSONObject2);
            } catch (java.lang.Exception unused) {
                org.json.JSONObject jSONObject6 = new org.json.JSONObject();
                java.lang.StringBuilder sb3 = new java.lang.StringBuilder();
                sb3.append(com.tencent.hlyyb.common.a.c());
                jSONObject6.put(sb3.toString(), new org.json.JSONObject());
                aVar.f571a.put("directScheduleCodes", jSONObject6);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final void a(org.json.JSONObject jSONObject) {
        try {
            org.json.JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("AccessScheduleRsp");
            if (jSONObjectOptJSONObject != null) {
                java.lang.String string = jSONObjectOptJSONObject.toString();
                if (com.tencent.hlyyb.common.f.c.a(string)) {
                    return;
                }
                byte[] bytes = string.getBytes();
                if (com.tencent.hlyyb.common.f.c.a(bytes)) {
                    return;
                }
                java.lang.String strB = com.tencent.hlyyb.common.a.f.b();
                this.f576a.a(strB, bytes);
                com.tencent.hlyyb.common.a.b.d();
                com.tencent.hlyyb.common.a.b.c();
                com.tencent.hlyyb.common.a.k().post(new com.tencent.hlyyb.common.d.b.b.b.c(this, strB, bytes));
            }
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.tencent.hlyyb.common.d.b.b.b
    public final java.lang.String c() {
        return "accessscheduler";
    }
}
