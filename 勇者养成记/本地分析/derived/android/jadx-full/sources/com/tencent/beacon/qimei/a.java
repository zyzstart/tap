package com.tencent.beacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beacon.qimei.a f207a;
    private java.lang.String b;
    private com.tencent.beacon.qimei.Qimei c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;
    private java.lang.String h;
    private java.lang.String i;
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String n;
    private java.lang.String o;
    private boolean m = false;
    private java.lang.String p = "";
    private java.lang.String q = "";
    private java.lang.String r = "";
    private java.lang.String s = "";
    private java.lang.String t = "";
    private java.lang.String u = "";
    private java.lang.String v = "";

    private a(android.content.Context context) {
        this.b = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = "";
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.n = "";
        this.o = "";
        this.d = com.tencent.beacon.core.info.c.a(context).c();
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(context);
        this.e = eVarD.i(context);
        this.f = eVarD.h(context);
        this.g = eVarD.b(context);
        if ("".equals(this.e)) {
            this.h = eVarD.e(context);
        }
        this.i = com.tencent.beacon.core.info.c.a(context).k();
        this.j = eVarD.h();
        this.k = eVarD.d();
        this.l = eVarD.n();
        this.n = eVarD.l();
        this.o = eVarD.k(context);
        try {
            this.c = new com.tencent.beacon.qimei.Qimei();
            java.lang.String strC = com.tencent.beacon.qimei.i.c(context);
            if (!com.tencent.beacon.core.e.j.b(strC)) {
                this.b = strC;
            }
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("[qimei] final request qimeiJson: ");
            sb.append(this.b);
            com.tencent.beacon.core.e.d.a(sb.toString(), new java.lang.Object[0]);
            java.util.Map mapA = com.tencent.beacon.qimei.i.a(this.b);
            if (mapA != null) {
                this.c.setQimeiOld((java.lang.String) mapA.get("A3"));
                this.c.setQimeiNew((java.lang.String) mapA.get("A153"));
                this.c.setQimeiMap(mapA);
                com.tencent.beacon.qimei.i.b(context, this.c.toString());
            }
        } catch (java.lang.Exception e) {
            com.tencent.beacon.core.e.d.b("load qimei error ", e.getMessage());
        }
    }

    public static synchronized com.tencent.beacon.qimei.a a(android.content.Context context) {
        if (f207a == null) {
            f207a = new com.tencent.beacon.qimei.a(context);
        }
        return f207a;
    }

    public java.lang.String a() {
        return this.b;
    }

    public void a(com.tencent.beacon.qimei.Qimei qimei) {
        this.c = qimei;
    }

    public com.tencent.beacon.qimei.Qimei b() {
        return this.c;
    }

    public java.lang.String c() {
        return this.b;
    }

    public com.tencent.beacon.qimei.QimeiPackage d() {
        com.tencent.beacon.qimei.QimeiPackage qimeiPackage = new com.tencent.beacon.qimei.QimeiPackage();
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
        java.lang.String str6 = this.j;
        if (str6 == null) {
            str6 = "";
        }
        qimeiPackage.model = str6;
        java.lang.String str7 = this.k;
        if (str7 == null) {
            str7 = "";
        }
        qimeiPackage.brand = str7;
        java.lang.String str8 = this.l;
        if (str8 == null) {
            str8 = "";
        }
        qimeiPackage.osVersion = str8;
        qimeiPackage.broot = this.m;
        java.lang.String str9 = this.i;
        if (str9 == null) {
            str9 = "";
        }
        qimeiPackage.qq = str9;
        java.lang.String str10 = this.n;
        if (str10 == null) {
            str10 = "";
        }
        qimeiPackage.cid = str10;
        return qimeiPackage;
    }
}
