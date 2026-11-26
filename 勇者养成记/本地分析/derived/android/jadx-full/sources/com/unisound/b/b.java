package com.unisound.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {
    private static final java.lang.String C = "systemResponese";
    private static java.lang.String z = "";
    private android.content.Context A;
    private com.unisound.b.a B;
    private java.lang.String c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1450a = "http://dc.hivoice.cn/rest/v2/device/activate";
    private java.lang.String b = "[REDACTED]";
    private java.lang.String d = "";
    private java.lang.String e = "";
    private java.lang.String f = "";
    private java.lang.String g = "";
    private java.lang.String h = "";
    private java.lang.String i = "";
    private java.lang.String j = "";
    private java.lang.String k = "";
    private java.lang.String l = "";
    private java.lang.String m = "";
    private java.lang.String n = "";
    private java.lang.String o = "";
    private java.lang.String p = "";
    private java.lang.String q = "";
    private java.lang.String r = "Android";
    private java.lang.String s = "";
    private java.lang.String t = "";
    private java.lang.String u = "";
    private java.lang.String v = "";
    private java.lang.String w = "";
    private java.lang.String x = "";
    private java.lang.String y = "";
    private com.unisound.b.c D = com.unisound.b.c.FINISH;

    public b(android.content.Context context) {
        this.A = null;
        this.A = context;
        this.B = new com.unisound.b.a(context.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.Map<java.lang.String, java.lang.String> A() {
        java.util.HashMap map = new java.util.HashMap();
        java.lang.String str = this.d;
        if (str == null) {
            str = "";
        }
        map.put("udid", str);
        java.lang.String str2 = this.e;
        if (str2 == null) {
            str2 = "";
        }
        map.put("deviceSn", str2);
        java.lang.String str3 = this.f;
        if (str3 == null) {
            str3 = "";
        }
        map.put(com.unisound.common.x.f1502a, str3);
        map.put("timestamp", E());
        java.lang.String str4 = this.h;
        if (str4 == null) {
            str4 = "";
        }
        map.put("appVersion", str4);
        java.lang.String str5 = this.i;
        if (str5 == null) {
            str5 = "";
        }
        map.put("pkgName", str5);
        java.lang.String str6 = this.j;
        if (str6 == null) {
            str6 = "";
        }
        map.put("imei", str6);
        java.lang.String str7 = this.k;
        if (str7 == null) {
            str7 = "";
        }
        map.put("macAddress", str7);
        java.lang.String str8 = this.l;
        if (str8 == null) {
            str8 = "";
        }
        map.put("wifiSsid", str8);
        java.lang.String str9 = this.m;
        if (str9 == null) {
            str9 = "";
        }
        map.put("telecomOperator", str9);
        java.lang.String str10 = this.n;
        if (str10 == null) {
            str10 = "";
        }
        map.put("bssId", str10);
        java.lang.String str11 = this.o;
        if (str11 == null) {
            str11 = "";
        }
        map.put("productName", str11);
        java.lang.String str12 = this.p;
        if (str12 == null) {
            str12 = "";
        }
        map.put("productModel", str12);
        java.lang.String str13 = this.q;
        if (str13 == null) {
            str13 = "";
        }
        map.put("productMfr", str13);
        java.lang.String str14 = this.r;
        if (str14 == null) {
            str14 = "";
        }
        map.put("productOs", str14);
        java.lang.String str15 = this.s;
        if (str15 == null) {
            str15 = "";
        }
        map.put("productOsVersion", str15);
        java.lang.String str16 = this.t;
        if (str16 == null) {
            str16 = "";
        }
        map.put("hardwareSn", str16);
        java.lang.String str17 = this.u;
        if (str17 == null) {
            str17 = "";
        }
        map.put("memo", str17);
        map.put(com.tencent.open.SocialOperation.GAME_SIGNATURE, C());
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public java.util.Map<java.lang.String, java.lang.String> B() {
        java.util.HashMap map = new java.util.HashMap();
        java.lang.String str = this.d;
        if (str == null) {
            str = "";
        }
        map.put("udid", str);
        java.lang.String str2 = this.f;
        if (str2 == null) {
            str2 = "";
        }
        map.put(com.unisound.common.x.f1502a, str2);
        java.lang.String str3 = this.x;
        if (str3 == null) {
            str3 = "";
        }
        map.put("[REDACTED]", str3);
        map.put("timestamp", E());
        map.put(com.tencent.open.SocialOperation.GAME_SIGNATURE, D());
        return map;
    }

    private java.lang.String C() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str = this.d;
        if (str == null) {
            str = "";
        }
        arrayList.add(str);
        java.lang.String str2 = this.e;
        if (str2 == null) {
            str2 = "";
        }
        arrayList.add(str2);
        java.lang.String str3 = this.f;
        if (str3 == null) {
            str3 = "";
        }
        arrayList.add(str3);
        java.lang.String str4 = this.g;
        if (str4 == null) {
            str4 = "";
        }
        arrayList.add(str4);
        java.lang.String str5 = this.h;
        if (str5 == null) {
            str5 = "";
        }
        arrayList.add(str5);
        java.lang.String str6 = this.i;
        if (str6 == null) {
            str6 = "";
        }
        arrayList.add(str6);
        java.lang.String str7 = this.j;
        if (str7 == null) {
            str7 = "";
        }
        arrayList.add(str7);
        java.lang.String str8 = this.k;
        if (str8 == null) {
            str8 = "";
        }
        arrayList.add(str8);
        java.lang.String str9 = this.l;
        if (str9 == null) {
            str9 = "";
        }
        arrayList.add(str9);
        java.lang.String str10 = this.m;
        if (str10 == null) {
            str10 = "";
        }
        arrayList.add(str10);
        java.lang.String str11 = this.n;
        if (str11 == null) {
            str11 = "";
        }
        arrayList.add(str11);
        java.lang.String str12 = this.o;
        if (str12 == null) {
            str12 = "";
        }
        arrayList.add(str12);
        java.lang.String str13 = this.p;
        if (str13 == null) {
            str13 = "";
        }
        arrayList.add(str13);
        java.lang.String str14 = this.q;
        if (str14 == null) {
            str14 = "";
        }
        arrayList.add(str14);
        java.lang.String str15 = this.r;
        if (str15 == null) {
            str15 = "";
        }
        arrayList.add(str15);
        java.lang.String str16 = this.s;
        if (str16 == null) {
            str16 = "";
        }
        arrayList.add(str16);
        java.lang.String str17 = this.t;
        if (str17 == null) {
            str17 = "";
        }
        arrayList.add(str17);
        java.lang.String str18 = this.u;
        if (str18 == null) {
            str18 = "";
        }
        arrayList.add(str18);
        java.lang.String str19 = this.y;
        if (str19 == null) {
            str19 = "";
        }
        arrayList.add(str19);
        return com.unisound.b.k.a(arrayList);
    }

    private java.lang.String D() {
        java.util.ArrayList arrayList = new java.util.ArrayList();
        java.lang.String str = this.d;
        if (str == null) {
            str = "";
        }
        arrayList.add(str);
        java.lang.String str2 = this.f;
        if (str2 == null) {
            str2 = "";
        }
        arrayList.add(str2);
        java.lang.String str3 = this.g;
        if (str3 == null) {
            str3 = "";
        }
        arrayList.add(str3);
        java.lang.String str4 = this.x;
        if (str4 == null) {
            str4 = "";
        }
        arrayList.add(str4);
        java.lang.String str5 = this.y;
        if (str5 == null) {
            str5 = "";
        }
        arrayList.add(str5);
        return com.unisound.b.k.a(arrayList);
    }

    private java.lang.String E() {
        long jF = F();
        this.g = java.lang.String.valueOf(jF != 0 ? com.unisound.b.k.a(java.lang.System.currentTimeMillis() + jF) : com.unisound.b.k.a(java.lang.System.currentTimeMillis()));
        return this.g;
    }

    private long F() {
        return this.A.getSharedPreferences(C, 0).getLong("timeDelay", 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j) {
        android.content.SharedPreferences.Editor editorEdit = this.A.getSharedPreferences(C, 0).edit();
        editorEdit.putLong("timeDelay", j);
        editorEdit.commit();
    }

    protected static void a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            com.unisound.b.i.a("ActivatroInterface setJsonString error!");
        } else {
            z = str;
        }
    }

    private void r(java.lang.String str) {
        java.lang.String str2;
        java.lang.String str3;
        java.lang.String str4;
        java.lang.String str5;
        java.lang.String str6;
        java.lang.String str7;
        java.lang.String str8;
        java.lang.String str9;
        java.lang.String str10;
        org.json.JSONObject jSONObjectA = com.unisound.b.h.a(str);
        java.lang.String strB = com.unisound.b.h.b(jSONObjectA, "deviceSn");
        if (strB.equals("")) {
            str2 = "ActivatorInterface _deviceSn= null";
        } else {
            l(strB);
            str2 = "ActivatorInterface _deviceSn= " + strB;
        }
        com.unisound.b.i.c(str2);
        java.lang.String strB2 = com.unisound.b.h.b(jSONObjectA, com.unisound.common.x.f1502a);
        if (strB2.equals("")) {
            com.unisound.b.i.a("[REDACTED]");
        } else {
            c(strB2);
            com.unisound.b.i.c("[REDACTED]" + strB2);
        }
        java.lang.String strB3 = com.unisound.b.h.b(jSONObjectA, "[REDACTED]");
        if (strB3.equals("")) {
            com.unisound.b.i.a("[REDACTED]");
        } else {
            d(strB3);
            com.unisound.b.i.c("[REDACTED]" + strB3);
        }
        java.lang.String strB4 = com.unisound.b.h.b(jSONObjectA, "appVersion");
        if (strB4.equals("")) {
            str3 = "ActivatorInterface _appVersion= null";
        } else {
            f(strB4);
            str3 = "ActivatorInterface _appVersion= " + strB4;
        }
        com.unisound.b.i.c(str3);
        java.lang.String strB5 = com.unisound.b.h.b(jSONObjectA, "packageName");
        if (strB5.equals("")) {
            str4 = "ActivatorInterface _packageName= null";
        } else {
            g(strB5);
            str4 = "ActivatorInterface _packageName= " + strB5;
        }
        com.unisound.b.i.c(str4);
        java.lang.String strB6 = com.unisound.b.h.b(jSONObjectA, "imei");
        if (strB6.equals("")) {
            str5 = "ActivatorInterface _imei= null";
        } else {
            e(strB6);
            str5 = "ActivatorInterface _imei= " + strB6;
        }
        com.unisound.b.i.c(str5);
        java.lang.String strB7 = com.unisound.b.h.b(jSONObjectA, "macAddress");
        if (strB7.equals("")) {
            str6 = "ActivatorInterface _macAddress= null";
        } else {
            h(strB7);
            str6 = "ActivatorInterface _macAddress= " + strB7;
        }
        com.unisound.b.i.c(str6);
        java.lang.String strB8 = com.unisound.b.h.b(jSONObjectA, "wifiSsid");
        if (strB8.equals("")) {
            str7 = "ActivatorInterface _wifiSsid= null";
        } else {
            i(strB8);
            str7 = "ActivatorInterface _wifiSsid= " + strB8;
        }
        com.unisound.b.i.c(str7);
        java.lang.String strB9 = com.unisound.b.h.b(jSONObjectA, "telecomOperator");
        if (strB9.equals("")) {
            str8 = "ActivatorInterface _telecomOperator= null";
        } else {
            j(strB9);
            str8 = "ActivatorInterface _telecomOperator= " + strB9;
        }
        com.unisound.b.i.c(str8);
        java.lang.String strB10 = com.unisound.b.h.b(jSONObjectA, "memo");
        if (strB10.equals("")) {
            str9 = "ActivatorInterface _memo= null";
        } else {
            k(strB10);
            str9 = "ActivatorInterface _memo= " + strB10;
        }
        com.unisound.b.i.c(str9);
        java.lang.String strB11 = com.unisound.b.h.b(jSONObjectA, "[REDACTED]");
        if (strB11.equals("")) {
            str10 = "[REDACTED]";
        } else {
            q(strB11);
            str10 = "[REDACTED]" + strB11;
        }
        com.unisound.b.i.c(str10);
        boolean zA = com.unisound.b.h.a(jSONObjectA, "debug", false);
        if (zA) {
            a(zA);
            com.unisound.b.i.c("ActivatorInterface _debug= " + zA);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        if (this.h == "") {
            g();
        }
        if (this.j == "") {
            e();
        }
        if (this.i == "") {
            i();
        }
        if (this.k == "") {
            k();
        }
        if (this.l == "") {
            m();
        }
        if (this.m == "") {
            o();
        }
        z();
    }

    private void z() {
        this.n = "";
        this.o = "";
        this.p = "";
        this.q = "";
        this.s = "";
        this.t = "";
        try {
            this.n = com.unisound.a.a.e(this.A);
            this.o = com.unisound.a.a.d();
            this.p = com.unisound.a.a.e();
            this.q = com.unisound.a.a.f();
            this.s = com.unisound.a.a.g();
            this.t = com.unisound.a.a.h();
        } catch (java.lang.Exception unused) {
            com.unisound.b.i.d("activate cant createDeviceInfo");
        }
    }

    protected android.content.Context a() {
        return this.A;
    }

    public void a(int i) {
        if (this.D == com.unisound.b.c.RUNNING) {
            this.B.sendEmptyMessage(108);
        }
        this.D = com.unisound.b.c.RUNNING;
        switch (i) {
            case 0:
            case 1:
                r(z);
                new com.unisound.b.d(this, i).start();
                break;
            default:
                this.B.sendEmptyMessage(110);
                this.D = com.unisound.b.c.FINISH;
                break;
        }
    }

    protected void a(android.content.Context context) {
        this.A = context;
    }

    public void a(com.unisound.b.a.c cVar) {
        this.B.a(cVar);
    }

    protected void a(boolean z2) {
        com.unisound.b.i.f1456a = z2;
        com.unisound.a.a.b(z2);
    }

    protected java.lang.String b() {
        return this.f;
    }

    protected void b(java.lang.String str) {
        this.c = str;
        this.f1450a = "http://" + str + "/rest/v1/device/activate";
        this.b = "[REDACTED]" + str + "[REDACTED]";
    }

    protected java.lang.String c() {
        return this.y;
    }

    protected void c(java.lang.String str) {
        this.f = str;
    }

    protected java.lang.String d() {
        return this.j;
    }

    protected void d(java.lang.String str) {
        this.y = str;
    }

    protected void e() {
        try {
            this.j = com.unisound.a.a.b(this.A);
        } catch (java.lang.Exception unused) {
            this.B.sendEmptyMessage(120);
            com.unisound.b.i.d("activate HttpResponse result is null");
        }
    }

    protected void e(java.lang.String str) {
        this.j = str;
    }

    protected java.lang.String f() {
        return this.h;
    }

    protected void f(java.lang.String str) {
        this.h = str;
    }

    protected void g() {
        this.h = com.unisound.a.a.f(this.A);
    }

    protected void g(java.lang.String str) {
        this.i = str;
    }

    protected java.lang.String h() {
        return this.i;
    }

    protected void h(java.lang.String str) {
        this.k = str;
    }

    protected void i() {
        this.i = com.unisound.a.a.g(this.A);
    }

    protected void i(java.lang.String str) {
        this.l = str;
    }

    protected java.lang.String j() {
        return this.k;
    }

    protected void j(java.lang.String str) {
        this.m = str;
    }

    protected void k() {
        try {
            this.k = com.unisound.a.a.h(this.A);
        } catch (java.lang.Exception unused) {
            com.unisound.b.i.d("activate setMacAddress error");
        }
    }

    protected void k(java.lang.String str) {
        this.u = str;
    }

    protected java.lang.String l() {
        return this.l;
    }

    public void l(java.lang.String str) {
        this.e = str;
        com.unisound.a.a.b(this.e);
    }

    protected void m() {
        try {
            this.l = com.unisound.a.a.i(this.A);
        } catch (java.lang.Exception unused) {
            com.unisound.b.i.d("activate setWifiSsid error");
        }
    }

    public void m(java.lang.String str) {
        this.g = str;
    }

    protected java.lang.String n() {
        return this.m;
    }

    protected void n(java.lang.String str) {
        this.d = str;
    }

    protected void o() {
        try {
            this.m = com.unisound.a.a.j(this.A);
        } catch (java.lang.Exception unused) {
            com.unisound.b.i.d("activate setTelecomOperator error");
        }
    }

    protected void o(java.lang.String str) {
        this.v = str;
    }

    protected java.lang.String p() {
        return this.u;
    }

    protected void p(java.lang.String str) {
        this.w = str;
    }

    protected java.lang.String q() {
        return com.unisound.b.e.a();
    }

    public void q(java.lang.String str) {
        this.x = str;
    }

    public java.lang.String r() {
        return this.e;
    }

    public java.lang.String s() {
        return this.g;
    }

    protected java.lang.String t() {
        return this.d;
    }

    public java.lang.String u() {
        return this.v;
    }

    public java.lang.String v() {
        return this.w;
    }

    public java.lang.String w() {
        return this.x;
    }
}
