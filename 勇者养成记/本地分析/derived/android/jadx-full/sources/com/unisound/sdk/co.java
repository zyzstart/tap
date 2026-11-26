package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class co {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1554a;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private java.lang.String d = "";

    public co(java.lang.String str) {
        this.f1554a = "";
        this.f1554a = str;
        b(str);
    }

    private boolean a(java.lang.String str) {
        return str == null || str.trim().length() == 0;
    }

    private boolean b(java.lang.String str) {
        if (!a(str)) {
            try {
                org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                this.d = jSONObject.has("history") ? jSONObject.getString("history") : "";
                this.c = jSONObject.has(com.unisound.sdk.cb.h) ? jSONObject.getString(com.unisound.sdk.cb.h) : "";
                if (jSONObject.has(com.unisound.sdk.i.i)) {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject(com.unisound.sdk.i.i);
                    this.b = jSONObject2.has(com.unisound.sdk.cb.h) ? jSONObject2.getString(com.unisound.sdk.cb.h) : "";
                    return true;
                }
            } catch (org.json.JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public java.lang.String a() {
        return this.f1554a;
    }

    public java.lang.String b() {
        return this.b;
    }

    public java.lang.String c() {
        return this.d;
    }

    public java.lang.String d() {
        return this.c;
    }
}
