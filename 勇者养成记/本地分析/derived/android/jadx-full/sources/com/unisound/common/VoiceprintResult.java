package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class VoiceprintResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1461a;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private java.lang.String d = "";
    private java.lang.String e = "";
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String h = "";

    public VoiceprintResult(java.lang.String str) {
        this.f1461a = str;
        a(str);
    }

    private boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        com.unisound.common.y.c(str);
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(b(str));
            if (jSONObject.has("vprResult")) {
                try {
                    org.json.JSONObject jSONObject2 = jSONObject.getJSONObject("vprResult");
                    this.d = jSONObject2.toString();
                    this.h = jSONObject2.has("code") ? jSONObject2.getString("code") : "0000";
                    this.b = jSONObject2.has("message") ? jSONObject2.getString("message") : "";
                    if (jSONObject2.has("result")) {
                        try {
                            org.json.JSONObject jSONObject3 = jSONObject2.getJSONObject("result");
                            this.c = jSONObject3.toString();
                            this.g = jSONObject3.has("customizedName") ? jSONObject3.getString("customizedName") : "";
                            this.e = jSONObject3.has("udid") ? jSONObject3.getString("udid") : "";
                            this.f = jSONObject3.has("passportId") ? jSONObject3.getString("passportId") : "";
                        } catch (org.json.JSONException unused) {
                            this.c = jSONObject2.getString("result");
                        }
                    }
                } catch (org.json.JSONException unused2) {
                    this.d = jSONObject.getString("vprResult");
                }
            }
            return true;
        } catch (org.json.JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    private java.lang.String b(java.lang.String str) {
        if (!str.contains("}{")) {
            return str;
        }
        java.lang.String strSubstring = str.substring(str.indexOf("}") + 1);
        com.unisound.common.y.a("jsonStr: " + strSubstring);
        return strSubstring;
    }

    public java.lang.String getCode() {
        return this.h;
    }

    public java.lang.String getCustomizedName() {
        return this.g;
    }

    public java.lang.String getMessage() {
        return this.b;
    }

    public java.lang.String getPassportId() {
        return this.f;
    }

    public java.lang.String getResult() {
        return this.c;
    }

    public java.lang.String getString() {
        return this.f1461a;
    }

    public java.lang.String getUdid() {
        return this.e;
    }

    public java.lang.String getVprResult() {
        return this.d;
    }
}
