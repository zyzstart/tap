package com.tencent.hlyyb.common.d.b.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.Map f571a = new java.util.HashMap();

    public final byte[] a() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        for (java.util.Map.Entry entry : this.f571a.entrySet()) {
            try {
                jSONObject.put((java.lang.String) entry.getKey(), entry.getValue());
            } catch (java.lang.Exception unused) {
            }
        }
        return jSONObject.toString().getBytes();
    }
}
