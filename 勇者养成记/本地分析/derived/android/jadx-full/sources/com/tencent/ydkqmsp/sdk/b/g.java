package com.tencent.ydkqmsp.sdk.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {
    private static com.tencent.ydkqmsp.sdk.b.g c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1300a = "Qp.netImp";
    private com.tencent.ydkqmsp.sdk.b.f b = null;

    class a implements com.tencent.ydkqmsp.sdk.b.f {
        a() {
        }

        @Override // com.tencent.ydkqmsp.sdk.b.f
        public void a(int i, java.lang.String str, int i2, org.json.JSONObject jSONObject, com.tencent.ydkqmsp.sdk.b.e eVar) {
            try {
                org.json.JSONObject jSONObjectB = com.tencent.ydkqmsp.sdk.b.g.this.b(8, jSONObject);
                if (jSONObjectB == null) {
                    eVar.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_4, null);
                    return;
                }
                com.tencent.ydkqmsp.sdk.b.a.d dVarA = com.tencent.ydkqmsp.sdk.b.a.a(i, str, i2, jSONObjectB);
                if (dVarA.b == 0) {
                    eVar.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_2, (dVarA.f1296a == null || !(dVarA.f1296a instanceof org.json.JSONObject)) ? null : com.tencent.ydkqmsp.sdk.b.g.this.b(9, dVarA.f1296a));
                } else {
                    eVar.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_3, dVarA.f1296a);
                }
            } catch (java.lang.Exception e) {
                com.tencent.ydkqmsp.sdk.f.g.b(com.tencent.ydkqmsp.sdk.b.g.this.f1300a, 0, "send fail！");
                eVar.a(com.tencent.smtt.sdk.TbsListener.ErrorCode.STARTDOWNLOAD_3, null);
                e.printStackTrace();
            }
        }
    }

    private g() {
    }

    private org.json.JSONObject a(int i, org.json.JSONObject jSONObject) {
        java.lang.String strA;
        if ((jSONObject instanceof org.json.JSONObject) && jSONObject != null) {
            try {
                if (i != 8) {
                    if (i == 9 && (strA = com.tencent.ydkqmsp.sdk.c.f.a(i, 0, 0, 0, a(jSONObject), "")) != null && !android.text.TextUtils.isEmpty(strA)) {
                        return new org.json.JSONObject(strA);
                    }
                    return null;
                }
                java.lang.String strA2 = com.tencent.ydkqmsp.sdk.c.f.a(i, 0, 0, 0, jSONObject.toString(), "");
                if (strA2 != null && !android.text.TextUtils.isEmpty(strA2)) {
                    org.json.JSONObject jSONObject2 = new org.json.JSONObject();
                    jSONObject2.put(com.tencent.ydkqmsp.sdk.a.e.a(17), strA2);
                    return jSONObject2;
                }
                return null;
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static com.tencent.ydkqmsp.sdk.b.g b() {
        if (c == null) {
            synchronized (com.tencent.ydkqmsp.sdk.b.g.class) {
                if (c == null) {
                    c = new com.tencent.ydkqmsp.sdk.b.g();
                }
            }
        }
        return c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public org.json.JSONObject b(int i, org.json.JSONObject jSONObject) {
        if (!(jSONObject instanceof org.json.JSONObject) || jSONObject == null) {
            return null;
        }
        return a(i, jSONObject);
    }

    public java.lang.String a(org.json.JSONObject jSONObject) {
        try {
            return jSONObject.optString(com.tencent.ydkqmsp.sdk.a.e.a(17));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void a() {
        this.b = new com.tencent.ydkqmsp.sdk.b.g.a();
    }

    public void a(int i, java.lang.String str, int i2, org.json.JSONObject jSONObject, com.tencent.ydkqmsp.sdk.b.e eVar) {
        com.tencent.ydkqmsp.sdk.b.f fVar;
        if (!(jSONObject instanceof org.json.JSONObject) || jSONObject == null || eVar == null || (fVar = this.b) == null) {
            com.tencent.ydkqmsp.sdk.f.g.d(this.f1300a, 0, com.tencent.ydkqmsp.sdk.f.k.a(com.tencent.ydkqmsp.sdk.f.k.f1349a));
        } else {
            fVar.a(i, str, i2, jSONObject, eVar);
        }
    }

    public void a(com.tencent.ydkqmsp.sdk.b.f fVar) {
        if (fVar == null || !(fVar instanceof com.tencent.ydkqmsp.sdk.b.f)) {
            com.tencent.ydkqmsp.sdk.f.g.d(this.f1300a, 0, com.tencent.ydkqmsp.sdk.f.k.a(com.tencent.ydkqmsp.sdk.f.k.f1349a));
        } else {
            this.b = fVar;
        }
    }
}
