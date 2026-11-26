package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1502a = "[REDACTED]";
    public static final java.lang.String b = "imei";
    public static final java.lang.String c = "sessionID";
    public static final java.lang.String d = "sessionId";
    public static final java.lang.String e = "timeStamp";
    public static final java.lang.String f = "packageName";
    public static final java.lang.String g = "status";
    public static final java.lang.String h = "errString";
    public static final java.lang.String i = "javaSDKLog";
    public static final java.lang.String j = "cSDKLog";
    private static final java.lang.String k = "http://log.hivoice.cn/trace/basicService/";
    private java.lang.String l;
    private java.lang.String m;
    private java.lang.String n;
    private java.lang.String o;
    private java.lang.String p;
    private int q;
    private java.lang.String r;
    private java.lang.String s;
    private java.lang.String t;

    public x() {
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = "0";
        this.p = "";
        this.q = 0;
        this.r = "";
        this.s = "";
        this.t = "";
    }

    public x(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i2, java.lang.String str6, java.lang.String str7, java.lang.String str8) {
        this.l = "0";
        this.m = "0";
        this.n = "0";
        this.o = "0";
        this.p = "";
        this.q = 0;
        this.r = "";
        this.s = "";
        this.t = "";
        this.l = str;
        this.m = str2;
        this.n = str3;
        this.o = str4;
        this.p = str5;
        this.q = i2;
        this.r = str6;
        this.s = str7;
        this.t = str8;
    }

    public java.lang.String a() {
        return k;
    }

    public void a(int i2) {
        this.q = i2;
    }

    public void a(java.lang.String str) {
        this.l = str;
    }

    public java.lang.String b() {
        return this.l;
    }

    public void b(java.lang.String str) {
        this.m = str;
    }

    public java.lang.String c() {
        return this.m;
    }

    public void c(java.lang.String str) {
        this.n = str;
    }

    public java.lang.String d() {
        return this.n;
    }

    public void d(java.lang.String str) {
        this.o = str;
    }

    public java.lang.String e() {
        return this.o;
    }

    public void e(java.lang.String str) {
        this.p = str;
    }

    public java.lang.String f() {
        return this.p;
    }

    public void f(java.lang.String str) {
        this.r = str;
    }

    public int g() {
        return this.q;
    }

    public void g(java.lang.String str) {
        this.s = str;
    }

    public java.lang.String h() {
        return this.r;
    }

    public void h(java.lang.String str) {
        this.t = str;
    }

    public java.lang.String i() {
        return this.s;
    }

    public java.lang.String j() {
        return this.t;
    }

    public java.lang.String k() {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject();
            jSONObject.put("sessionId", this.n);
            jSONObject.put("packageName", this.p);
            jSONObject.put("status", this.q);
            jSONObject.put(h, this.r);
            byte[] bytes = this.s.getBytes();
            org.json.JSONArray jSONArray = new org.json.JSONArray();
            for (int i2 = 0; i2 < bytes.length; i2++) {
                jSONArray.put(i2, (int) bytes[i2]);
            }
            jSONObject.put(i, jSONArray);
            org.json.JSONArray jSONArray2 = new org.json.JSONArray();
            byte[] bytes2 = this.t.getBytes();
            for (int i3 = 0; i3 < bytes2.length; i3++) {
                jSONArray2.put(i3, (int) bytes2[i3]);
            }
            jSONObject.put(j, jSONArray2);
            return jSONObject.toString();
        } catch (org.json.JSONException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public java.lang.String l() {
        java.util.HashMap map = new java.util.HashMap();
        map.put(f1502a, this.l);
        map.put("imei", this.m);
        map.put(c, this.n);
        com.unisound.common.y.c("BASEURL = ", k);
        return com.unisound.common.aj.a(k, map);
    }
}
