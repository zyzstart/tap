package com.tencent.hlyyb.common.d.b.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f575a;
    public int b;
    public long c;

    public final java.lang.Object a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        try {
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            org.json.JSONObject jSONObject2 = new org.json.JSONObject();
            jSONObject2.put("appid", com.tencent.hlyyb.common.a.c());
            jSONObject2.put("url", this.f575a);
            jSONObject2.put("needFeature", this.b);
            jSONObject2.put("size", this.c);
            jSONArray.put(jSONObject2);
            jSONObject.put("resources", jSONArray);
        } catch (java.lang.Exception unused) {
        }
        return jSONObject;
    }
}
