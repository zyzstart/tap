package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class af {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.lang.String f1467a = "v";
    private static final java.lang.String b = "ak";
    private static final java.lang.String c = "udid";
    private static final java.lang.String d = "curw";
    private static final java.lang.String e = "neww";
    private static final java.lang.String f = "reqID";
    private java.lang.String g = "1.0";
    private java.lang.String h;
    private java.lang.String i;
    private java.util.Set<java.lang.String> j;
    private java.util.Set<java.lang.String> k;
    private java.lang.String l;

    public java.lang.String a() {
        return this.g;
    }

    public void a(java.lang.String str) {
        this.g = str;
    }

    public void a(java.util.Set<java.lang.String> set) {
        this.j = set;
    }

    public java.lang.String b() {
        return this.h;
    }

    public void b(java.lang.String str) {
        this.h = str;
    }

    public void b(java.util.Set<java.lang.String> set) {
        this.k = set;
    }

    public java.lang.String c() {
        return this.i;
    }

    public void c(java.lang.String str) {
        this.i = str;
        this.l = com.unisound.common.aa.a(str + java.lang.String.valueOf(java.lang.System.currentTimeMillis()));
    }

    public java.util.Set<java.lang.String> d() {
        return this.j;
    }

    public java.util.Set<java.lang.String> e() {
        return this.k;
    }

    public java.lang.String f() {
        return "v:" + this.g + " ; " + b + ":" + this.h + " ; udid:" + this.i + " ; " + d + ":" + this.j.toString() + " ; " + e + ":" + this.k.toString() + " ; " + f + ":" + this.l;
    }

    public java.lang.String g() {
        org.json.JSONObject jSONObject = new org.json.JSONObject();
        org.json.JSONArray jSONArray = new org.json.JSONArray();
        java.util.Set<java.lang.String> set = this.k;
        if (set != null) {
            for (java.lang.Object obj : set.toArray()) {
                jSONArray.put(obj.toString());
            }
        }
        org.json.JSONArray jSONArray2 = new org.json.JSONArray();
        java.util.Set<java.lang.String> set2 = this.j;
        if (set2 != null) {
            for (java.lang.Object obj2 : set2.toArray()) {
                jSONArray2.put(obj2.toString());
            }
        }
        try {
            jSONObject.put(f1467a, this.g);
            jSONObject.put(b, this.h);
            jSONObject.put("udid", this.i);
            jSONObject.put(f, this.l);
            jSONObject.put(d, jSONArray2);
            jSONObject.put(e, jSONArray);
        } catch (org.json.JSONException e2) {
            com.unisound.common.y.a("OneshotVO JSONException");
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
