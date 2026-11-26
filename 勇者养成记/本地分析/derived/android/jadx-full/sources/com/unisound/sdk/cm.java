package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class cm extends com.unisound.sdk.ae {
    private java.lang.String o;
    private boolean p;
    private java.lang.String q;
    private java.lang.String r;
    private boolean s;
    private int t;

    public cm() {
        this.o = "search";
        this.p = true;
        this.q = "json";
        this.r = n;
        this.s = false;
        this.t = -1;
    }

    public cm(java.lang.String str, java.lang.String str2) {
        super(str, str2);
        this.o = "search";
        this.p = true;
        this.q = "json";
        this.r = n;
        this.s = false;
        this.t = -1;
    }

    public java.lang.String A() {
        return "returnType=" + v() + ";city=" + j() + ";gps=" + f() + ";time=" + k() + ";scenario=" + n() + ";screen=" + o() + ";dpi=" + p() + ";history=" + i() + ";udid=" + e() + ";ver=" + d() + ";appver=" + g() + ";" + com.unisound.sdk.ae.m + "=" + s() + ";";
    }

    public void a(int i) {
        this.t = i;
    }

    public void a(com.unisound.sdk.cm cmVar) {
        super.a((com.unisound.sdk.ae) cmVar);
        this.o = cmVar.u();
        this.p = cmVar.w();
        this.r = cmVar.t();
        this.q = cmVar.v();
    }

    public void a(boolean z) {
        this.p = z;
    }

    public boolean a(java.lang.String str, int i) {
        if (str == null) {
            return false;
        }
        this.r = "http://" + str + ":" + i + "/service/iss";
        return true;
    }

    public void b(boolean z) {
        this.s = z;
    }

    public void q(java.lang.String str) {
        this.r = str;
    }

    public boolean r(java.lang.String str) {
        return false;
    }

    public void s(java.lang.String str) {
        this.o = str;
    }

    public java.lang.String t() {
        return this.r;
    }

    public void t(java.lang.String str) {
        this.q = str;
    }

    public java.lang.String u() {
        return this.o;
    }

    public java.lang.String v() {
        return this.q;
    }

    public boolean w() {
        return this.p;
    }

    public com.unisound.sdk.cm x() {
        return this;
    }

    public boolean y() {
        return this.s;
    }

    public int z() {
        return this.t;
    }
}
