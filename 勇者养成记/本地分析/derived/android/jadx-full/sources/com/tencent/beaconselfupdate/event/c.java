package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beaconselfupdate.event.c f257a;
    private java.lang.String b;
    private java.lang.String c;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f;
    private java.lang.String g;

    private c(android.content.Context context) {
        this.b = "";
        this.c = "";
        this.d = "";
        this.e = "";
        this.f = "";
        this.g = "";
        if (context == null) {
            com.tencent.beaconselfupdate.c.a.d(" DetailUserInfo context == null? pls check!", new java.lang.Object[0]);
        }
        com.tencent.beaconselfupdate.c.a.b(" start to create DetailUserInfo", new java.lang.Object[0]);
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        com.tencent.beaconselfupdate.a.e.a(context);
        this.b = com.tencent.beaconselfupdate.a.e.b(context);
        com.tencent.beaconselfupdate.c.a.b(" imei:" + this.b, new java.lang.Object[0]);
        if (!"".equals(this.b)) {
            try {
                if ("".equals(com.tencent.beaconselfupdate.a.a.b(context, "IMEI_DENGTA", ""))) {
                    com.tencent.beaconselfupdate.a.a.a(context, "IMEI_DENGTA", this.b);
                }
            } catch (java.lang.Exception unused) {
            }
        }
        this.e = com.tencent.beaconselfupdate.a.e.d(context);
        java.lang.String strB = com.tencent.beaconselfupdate.a.a.b(context, "QIMEI_DENGTA", "");
        this.f = strB;
        if ("".equals(strB)) {
            this.f = this.b.equals("") ? this.e : this.b;
        }
        if (com.tencent.beaconselfupdate.event.UserAction.f253a == null) {
            com.tencent.beaconselfupdate.event.UserAction.f253a = new java.util.HashMap();
        }
        com.tencent.beaconselfupdate.event.UserAction.f253a.put("A3", this.f);
        java.lang.String str = com.tencent.beaconselfupdate.a.e.e(context);
        this.c = str;
        if ("".equals(str)) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            java.lang.String strF = com.tencent.beaconselfupdate.a.e.f("/sys/class/net/eth0/address");
            sb.append((strF.trim().equals("") || strF.length() < 17) ? "" : strF.toLowerCase().substring(0, 17));
            this.c = sb.toString();
        }
        this.d = com.tencent.beaconselfupdate.a.e.c(context);
        java.lang.String str2 = com.tencent.beaconselfupdate.a.e.d();
        java.lang.String str3 = com.tencent.beaconselfupdate.a.e.e() + "m";
        this.g = com.tencent.beaconselfupdate.a.e.f();
        com.tencent.beaconselfupdate.c.a.b(" detail create cost: %d  values:\n %s", java.lang.Long.valueOf(java.lang.System.currentTimeMillis() - jCurrentTimeMillis), toString());
    }

    public static synchronized com.tencent.beaconselfupdate.event.c a(android.content.Context context) {
        if (f257a == null) {
            f257a = new com.tencent.beaconselfupdate.event.c(context);
        }
        return f257a;
    }

    public final synchronized java.lang.String a() {
        return this.b;
    }

    public final synchronized java.lang.String b() {
        return this.c;
    }

    public final synchronized java.lang.String c() {
        return this.d;
    }

    public final synchronized java.lang.String d() {
        return this.e;
    }

    public final synchronized java.lang.String e() {
        return this.f;
    }

    public final java.lang.String f() {
        return this.g;
    }
}
