package com.tencent.ydkbeacon.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.ydkbeacon.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.ydkbeacon.d.a f1238a;
    public boolean b = false;
    private java.lang.String c = "oth.str.mdt.qq.com";
    private int d = 360;
    private int e = 100;
    private java.util.Map f = null;
    private boolean g = false;
    private com.tencent.ydkbeacon.d.d h = new com.tencent.ydkbeacon.d.d(1);

    private a() {
    }

    public static com.tencent.ydkbeacon.d.a a() {
        if (f1238a == null) {
            synchronized (com.tencent.ydkbeacon.d.a.class) {
                if (f1238a == null) {
                    f1238a = new com.tencent.ydkbeacon.d.a();
                }
            }
        }
        return f1238a;
    }

    @Override // com.tencent.ydkbeacon.d.c
    public synchronized java.lang.String a(java.lang.String str) {
        java.util.Map map = this.f;
        if (map == null) {
            return null;
        }
        return (java.lang.String) map.get(str);
    }

    public void a(int i) {
        this.d = i;
    }

    public synchronized void a(java.util.Map map) {
        this.f = map;
    }

    public int b() {
        return this.d;
    }

    public java.lang.String b(java.lang.String str) {
        java.util.Map mapA;
        com.tencent.ydkbeacon.d.d dVar = this.h;
        if (dVar == null || (mapA = dVar.a()) == null) {
            return null;
        }
        return (java.lang.String) mapA.get(str);
    }

    public synchronized int c() {
        java.lang.String str;
        java.util.Map map = this.f;
        if (map == null || (str = (java.lang.String) map.get("maxStrategyQueryOneDay")) == null || str.trim().equals("")) {
            return this.e;
        }
        int i = this.e;
        try {
            i = java.lang.Integer.parseInt(str);
        } catch (java.lang.Exception unused) {
        }
        return i;
    }

    public com.tencent.ydkbeacon.d.d d() {
        return this.h;
    }

    public synchronized boolean e() {
        java.util.Map map = this.f;
        if (map == null || !"y".equalsIgnoreCase((java.lang.String) map.get("zeroPeak"))) {
            return false;
        }
        return java.util.Calendar.getInstance().get(11) == 0;
    }
}
