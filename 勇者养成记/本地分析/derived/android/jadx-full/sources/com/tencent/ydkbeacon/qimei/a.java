package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.ydkbeacon.qimei.a f1280a;
    private java.lang.String b = "";
    private com.tencent.ydkbeacon.qimei.Qimei c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private boolean l;
    private java.lang.String m;

    private a() {
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = false;
        this.m = "";
        com.tencent.ydkbeacon.a.c.f fVarP = com.tencent.ydkbeacon.a.c.f.p();
        this.d = fVarP.m();
        this.e = fVarP.s();
        this.f = fVarP.o();
        this.g = fVarP.e();
        this.h = "";
        this.i = android.os.Build.MODEL;
        this.j = android.os.Build.BRAND;
        this.k = fVarP.z();
        this.m = fVarP.v();
        this.l = com.tencent.ydkbeacon.a.e.d.d();
        d();
    }

    public static synchronized com.tencent.ydkbeacon.qimei.a a() {
        if (f1280a == null) {
            f1280a = new com.tencent.ydkbeacon.qimei.a();
        }
        return f1280a;
    }

    private synchronized void d() {
        this.c = new com.tencent.ydkbeacon.qimei.Qimei();
        java.lang.String strA = com.tencent.ydkbeacon.qimei.f.a(com.tencent.ydkbeacon.a.c.c.d().c());
        if (!android.text.TextUtils.isEmpty(strA)) {
            this.b = strA;
        }
        com.tencent.ydkbeacon.a.e.c.a("[qimei] final jceRequest qimeiJson: " + this.b, new java.lang.Object[0]);
        java.util.HashMap mapA = com.tencent.ydkbeacon.qimei.f.a(this.b);
        if (mapA != null) {
            this.c.b((java.lang.String) mapA.get("A3"));
            this.c.a((java.lang.String) mapA.get("A153"));
            this.c.a(mapA);
            com.tencent.ydkbeacon.qimei.f.b(com.tencent.ydkbeacon.a.c.c.d().c(), this.c.toString());
        }
    }

    public synchronized void a(com.tencent.ydkbeacon.qimei.Qimei qimei) {
        this.c = qimei;
    }

    public com.tencent.ydkbeacon.qimei.Qimei b() {
        return this.c;
    }

    public com.tencent.ydkbeacon.pack.QimeiPackage c() {
        com.tencent.ydkbeacon.pack.QimeiPackage qimeiPackage = new com.tencent.ydkbeacon.pack.QimeiPackage();
        java.lang.String str = this.d;
        if (str == null) {
            str = "";
        }
        qimeiPackage.imei = str;
        java.lang.String str2 = this.f;
        if (str2 == null) {
            str2 = "";
        }
        qimeiPackage.imsi = str2;
        java.lang.String str3 = this.e;
        if (str3 == null) {
            str3 = "";
        }
        qimeiPackage.mac = str3;
        java.lang.String str4 = this.g;
        if (str4 == null) {
            str4 = "";
        }
        qimeiPackage.androidId = str4;
        java.lang.String str5 = this.b;
        if (str5 == null) {
            str5 = "";
        }
        qimeiPackage.qimei = str5;
        java.lang.String str6 = this.i;
        if (str6 == null) {
            str6 = "";
        }
        qimeiPackage.model = str6;
        java.lang.String str7 = this.j;
        if (str7 == null) {
            str7 = "";
        }
        qimeiPackage.brand = str7;
        java.lang.String str8 = this.k;
        if (str8 == null) {
            str8 = "";
        }
        qimeiPackage.osVersion = str8;
        qimeiPackage.broot = this.l;
        java.lang.String str9 = this.h;
        if (str9 == null) {
            str9 = "";
        }
        qimeiPackage.qq = str9;
        java.lang.String str10 = this.m;
        if (str10 == null) {
            str10 = "";
        }
        qimeiPackage.cid = str10;
        return qimeiPackage;
    }
}
