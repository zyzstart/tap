package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1513a = "filterName";
    public static final java.lang.String b = "returnType";
    public static final java.lang.String c = "city";
    public static final java.lang.String d = "gps";
    public static final java.lang.String e = "time";
    public static final java.lang.String f = "scenario";
    public static final java.lang.String g = "screen";
    public static final java.lang.String h = "dpi";
    public static final java.lang.String i = "history";
    public static final java.lang.String j = "udid";
    public static final java.lang.String k = "ver";
    public static final java.lang.String l = "appver";
    public static final java.lang.String m = "oneshotKeyProperty";
    public static java.lang.String n = "http://scv2.hivoice.cn/service/iss";
    private java.lang.String A;
    private java.lang.String B;
    private java.lang.String C;
    private java.lang.String D;
    private java.lang.String E;
    private java.lang.String F;
    private final java.lang.String o;
    private java.lang.String p;
    private java.lang.String q;
    private java.lang.String r;
    private java.lang.String s;
    private java.lang.String t;
    private java.lang.String u;
    private java.lang.String v;
    private java.lang.String w;
    private java.lang.String x;
    private java.lang.String y;
    private java.lang.String z;

    public ae() {
        this.o = "iss.getTalk";
        this.p = "2.0";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.w = a(java.lang.System.currentTimeMillis());
        this.x = "";
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = cn.yunzhisheng.asr.JniUscClient.aA;
    }

    public ae(java.lang.String str, java.lang.String str2) {
        this.o = "iss.getTalk";
        this.p = "2.0";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.w = a(java.lang.System.currentTimeMillis());
        this.x = "";
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = cn.yunzhisheng.asr.JniUscClient.aA;
        this.q = str;
        this.r = str2;
    }

    public ae(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, java.lang.String str6, java.lang.String str7, java.lang.String str8, java.lang.String str9, java.lang.String str10, java.lang.String str11, java.lang.String str12, java.lang.String str13) {
        this.o = "iss.getTalk";
        this.p = "2.0";
        this.q = "";
        this.r = "";
        this.s = "";
        this.t = "";
        this.u = "";
        this.v = "";
        this.w = a(java.lang.System.currentTimeMillis());
        this.x = "";
        this.y = "";
        this.z = "";
        this.A = "";
        this.B = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = cn.yunzhisheng.asr.JniUscClient.aA;
        this.q = str;
        this.r = str2;
        this.t = str3;
        this.s = str4;
        this.u = str5;
        this.x = str6;
        this.y = str7;
        this.v = str8;
        this.w = str9;
        this.z = str10;
        this.A = str11;
        this.B = str12;
        this.C = str13;
    }

    public static java.lang.String a(long j2) {
        return new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(java.lang.Long.valueOf(j2));
    }

    public java.lang.String a() {
        return n;
    }

    public void a(com.unisound.sdk.ae aeVar) {
        this.q = aeVar.b();
        this.s = aeVar.g();
        this.v = aeVar.j();
        this.C = aeVar.p();
        this.u = aeVar.f();
        this.y = aeVar.i();
        this.D = aeVar.q();
        this.A = aeVar.n();
        this.B = aeVar.o();
        this.r = aeVar.c();
        this.x = aeVar.h();
        this.w = aeVar.k();
        this.t = aeVar.e();
        this.p = aeVar.d();
        this.s = aeVar.g();
        this.E = aeVar.r();
        this.z = aeVar.m();
    }

    public void a(java.lang.String str) {
        n = str;
    }

    public java.lang.String b() {
        return this.q;
    }

    public void b(long j2) {
        this.w = a(j2);
    }

    public void b(java.lang.String str) {
        this.q = str;
    }

    public java.lang.String c() {
        return this.r;
    }

    public void c(java.lang.String str) {
        this.r = str;
    }

    public java.lang.String d() {
        return this.p;
    }

    public void d(java.lang.String str) {
        this.p = str;
    }

    public java.lang.String e() {
        return com.unisound.c.a.a(this.q);
    }

    public void e(java.lang.String str) {
        this.u = str;
    }

    public java.lang.String f() {
        return this.u;
    }

    public void f(java.lang.String str) {
        this.s = str;
    }

    public java.lang.String g() {
        return this.s;
    }

    public void g(java.lang.String str) {
        this.x = str;
    }

    public java.lang.String h() {
        return this.x;
    }

    public void h(java.lang.String str) {
        this.y = str;
    }

    public java.lang.String i() {
        return this.y;
    }

    public void i(java.lang.String str) {
        this.v = str;
    }

    public java.lang.String j() {
        return this.v;
    }

    public void j(java.lang.String str) {
        this.z = str;
    }

    public java.lang.String k() {
        return this.w;
    }

    public void k(java.lang.String str) {
        this.A = str;
    }

    public java.lang.String l() {
        return "iss.getTalk";
    }

    public void l(java.lang.String str) {
        this.B = str;
    }

    public java.lang.String m() {
        return this.z;
    }

    public void m(java.lang.String str) {
        this.C = str;
    }

    public java.lang.String n() {
        return this.A;
    }

    public void n(java.lang.String str) {
        this.D = str;
    }

    public java.lang.String o() {
        return this.B;
    }

    public void o(java.lang.String str) {
        this.E = str;
    }

    public java.lang.String p() {
        return this.C;
    }

    public void p(java.lang.String str) {
        this.F = str;
    }

    public java.lang.String q() {
        return this.D;
    }

    public java.lang.String r() {
        return this.E;
    }

    public java.lang.String s() {
        return this.F;
    }
}
