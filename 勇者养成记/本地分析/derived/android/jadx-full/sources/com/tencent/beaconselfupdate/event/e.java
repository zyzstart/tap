package com.tencent.beaconselfupdate.event;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f259a = 12;
    private int b = 60;
    private int c = 12;
    private int d = 60;
    private int e = 20;
    private boolean f = false;
    private boolean g = true;
    private java.util.Set h = null;
    private java.util.Map i = null;
    private boolean j = false;
    private boolean k = false;
    private boolean l = false;

    public final synchronized int a() {
        return this.f259a;
    }

    public final synchronized void a(java.util.Map map) {
        int iIntValue;
        int iIntValue2;
        int iIntValue3;
        int iIntValue4;
        int iIntValue5;
        if (map != null) {
            try {
                java.lang.String str = (java.lang.String) map.get("realNumUp");
                if (str != null && (iIntValue5 = java.lang.Integer.valueOf(str).intValue()) > 0 && iIntValue5 <= 50) {
                    this.f259a = iIntValue5;
                }
                java.lang.String str2 = (java.lang.String) map.get("realDelayUp");
                if (str2 != null && (iIntValue4 = java.lang.Integer.valueOf(str2).intValue()) >= 10 && iIntValue4 <= 600) {
                    this.b = iIntValue4;
                }
                java.lang.String str3 = (java.lang.String) map.get("comNumDB");
                if (str3 != null && (iIntValue3 = java.lang.Integer.valueOf(str3).intValue()) > 0 && iIntValue3 <= 50) {
                    this.c = iIntValue3;
                }
                java.lang.String str4 = (java.lang.String) map.get("comDelayDB");
                if (str4 != null && (iIntValue2 = java.lang.Integer.valueOf(str4).intValue()) >= 30 && iIntValue2 <= 600) {
                    this.d = iIntValue2;
                }
                java.lang.String str5 = (java.lang.String) map.get("comNumUp");
                if (str5 != null && (iIntValue = java.lang.Integer.valueOf(str5).intValue()) > 0 && iIntValue <= 100) {
                    this.e = iIntValue;
                }
                java.lang.String str6 = (java.lang.String) map.get("heartOnOff");
                if (str6 != null) {
                    if (str6.toLowerCase().equals("y")) {
                        this.g = true;
                    } else if (str6.toLowerCase().equals("n")) {
                        this.g = false;
                    }
                }
                java.lang.String str7 = (java.lang.String) map.get("tidyEF");
                if (str7 != null) {
                    if (str7.toLowerCase().equals("y")) {
                        this.k = true;
                    } else if (str7.toLowerCase().equals("n")) {
                        this.k = false;
                    }
                }
                java.lang.String str8 = (java.lang.String) map.get("lauEveSim");
                if (str8 != null) {
                    if (str8.toLowerCase().equals("y")) {
                        this.l = true;
                    } else if (str8.toLowerCase().equals("n")) {
                        this.l = false;
                    }
                }
                java.lang.String str9 = (java.lang.String) map.get("comPollUp");
                if (str9 != null) {
                    if (str9.toLowerCase().equals("y")) {
                        this.f = true;
                    } else if (str9.toLowerCase().equals("n")) {
                        this.f = false;
                    }
                }
                java.lang.String str10 = (java.lang.String) map.get("accessTestOnOff");
                if (str10 != null) {
                    if (str10.toLowerCase().equals("y")) {
                        com.tencent.beaconselfupdate.c.a.b = true;
                    } else if (str10.toLowerCase().equals("n")) {
                        com.tencent.beaconselfupdate.c.a.b = false;
                    }
                }
                java.lang.String str11 = (java.lang.String) map.get("upAc");
                if (str11 != null) {
                    if (str11.toLowerCase().equals("y")) {
                        this.j = true;
                    } else if (str11.toLowerCase().equals("n")) {
                        this.j = false;
                    }
                }
                map.get("appendXMeths");
            } catch (java.lang.Exception e) {
                com.tencent.beaconselfupdate.c.a.a(e);
            }
        }
    }

    public final synchronized void a(java.util.Set set) {
        this.h = set;
    }

    public final synchronized boolean a(java.lang.String str) {
        boolean zContains;
        zContains = false;
        java.util.Set set = this.h;
        if (set != null && set.size() > 0) {
            zContains = this.h.contains(str);
        }
        return zContains;
    }

    public final synchronized int b() {
        return this.b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void b(java.util.Set set) {
        if (this.i == null) {
            this.i = new java.util.HashMap();
        }
        java.util.Iterator it = set.iterator();
        while (it.hasNext()) {
            java.lang.String[] strArrSplit = ((java.lang.String) it.next()).split(",");
            if (strArrSplit.length == 3) {
                try {
                    this.i.put(strArrSplit[0].toLowerCase(), java.lang.Float.valueOf(java.lang.Float.valueOf(strArrSplit[1]).floatValue() / java.lang.Float.valueOf(strArrSplit[2]).floatValue()));
                } catch (java.lang.Exception unused) {
                }
            }
        }
    }

    public final synchronized boolean b(java.lang.String str) {
        java.util.Map map = this.i;
        if (map != null && map.get(str) != null) {
            return new java.util.Random().nextInt(1000) + 1 <= ((int) (((java.lang.Float) this.i.get(str.toLowerCase())).floatValue() * 1000.0f));
        }
        return true;
    }

    public final synchronized int c() {
        return this.c;
    }

    public final synchronized int d() {
        return this.d;
    }

    public final synchronized int e() {
        return this.e;
    }

    public final boolean f() {
        return this.g;
    }

    public final boolean g() {
        return this.f;
    }

    public final boolean h() {
        return this.k;
    }

    public final boolean i() {
        return this.l;
    }

    public final boolean j() {
        return this.j;
    }
}
