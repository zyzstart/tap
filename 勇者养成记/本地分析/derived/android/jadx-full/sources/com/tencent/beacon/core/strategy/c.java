package com.tencent.beacon.core.strategy;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.beacon.core.strategy.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.strategy.c f189a;
    private android.util.SparseArray f;
    public boolean b = false;
    private java.lang.String c = "";
    private int d = 360;
    private int e = 100;
    private java.util.Map g = null;
    private boolean h = true;

    private c() {
        this.f = null;
        android.util.SparseArray sparseArray = new android.util.SparseArray(3);
        this.f = sparseArray;
        sparseArray.put(1, new com.tencent.beacon.core.strategy.b(1));
        this.f.put(2, new com.tencent.beacon.core.strategy.b(2));
        this.f.put(3, new com.tencent.beacon.core.strategy.b(3));
    }

    public static com.tencent.beacon.core.strategy.c g() {
        if (f189a == null) {
            synchronized (com.tencent.beacon.core.strategy.c.class) {
                if (f189a == null) {
                    f189a = new com.tencent.beacon.core.strategy.c();
                }
            }
        }
        return f189a;
    }

    @Override // com.tencent.beacon.core.strategy.a
    public java.lang.String a(int i) {
        com.tencent.beacon.core.strategy.b bVarB = b(i);
        return bVarB == null ? "" : bVarB.d();
    }

    @Override // com.tencent.beacon.core.strategy.a
    public synchronized java.lang.String a(java.lang.String str) {
        java.util.Map map = this.g;
        if (map == null) {
            return null;
        }
        return (java.lang.String) map.get(str);
    }

    public synchronized void a(java.lang.String str, java.lang.String str2) {
        this.b = true;
        a(false);
        java.lang.String strA = com.tencent.beacon.core.c.a.b.a(str);
        this.c = strA;
        com.tencent.beacon.core.e.d.a("[strategy] set strategy url to %s by api.", strA);
        com.tencent.beacon.core.strategy.b bVar = (com.tencent.beacon.core.strategy.b) h().get(1);
        if (bVar != null) {
            java.lang.String strA2 = com.tencent.beacon.core.c.a.b.a(str2);
            bVar.c = strA2;
            com.tencent.beacon.core.e.d.a("[strategy] set user event url to %s by api.", strA2);
        }
    }

    public synchronized void a(java.util.Map map) {
        this.g = map;
    }

    @Override // com.tencent.beacon.core.strategy.a
    public void a(boolean z) {
        com.tencent.beacon.core.e.d.a("[net] -> change to http mode.", new java.lang.Object[0]);
        this.h = z;
    }

    @Override // com.tencent.beacon.core.strategy.a
    public boolean a() {
        return this.h;
    }

    @Override // com.tencent.beacon.core.strategy.a
    public int b() {
        java.util.Map mapA;
        java.lang.String str;
        com.tencent.beacon.core.strategy.b bVar = (com.tencent.beacon.core.strategy.b) h().get(1);
        if (bVar == null || (mapA = bVar.a()) == null || (str = (java.lang.String) mapA.get("socketPort")) == null) {
            return 8081;
        }
        return java.lang.Integer.valueOf(str).intValue();
    }

    public synchronized com.tencent.beacon.core.strategy.b b(int i) {
        android.util.SparseArray sparseArray = this.f;
        if (sparseArray == null) {
            return null;
        }
        return (com.tencent.beacon.core.strategy.b) sparseArray.get(i);
    }

    public java.lang.String b(java.lang.String str) {
        java.util.Map mapA;
        com.tencent.beacon.core.strategy.b bVar = (com.tencent.beacon.core.strategy.b) h().get(1);
        if (bVar == null || (mapA = bVar.a()) == null) {
            return null;
        }
        return (java.lang.String) mapA.get(str);
    }

    @Override // com.tencent.beacon.core.strategy.a
    public java.lang.String c() {
        java.lang.String strA = com.tencent.beacon.core.c.a.b.a(!g().a(), this.c);
        com.tencent.beacon.core.e.d.a("[net] module strategy url: %s", strA);
        return strA;
    }

    public void c(int i) {
        this.d = i;
    }

    public void c(java.lang.String str) {
        if (this.b) {
            com.tencent.beacon.core.e.d.i("[strategy] url has defined by api, don't change.", new java.lang.Object[0]);
        } else {
            this.c = str;
        }
    }

    @Override // com.tencent.beacon.core.strategy.a
    public boolean d() {
        java.lang.String strB = b("stopTest");
        if (strB != null) {
            return "y".equals(strB);
        }
        return false;
    }

    public synchronized java.util.Map e() {
        return this.g;
    }

    public synchronized android.util.SparseArray f() {
        if (this.f == null) {
            return null;
        }
        return new com.tencent.beacon.core.e.h().a(this.f);
    }

    public android.util.SparseArray h() {
        return this.f;
    }

    public int i() {
        return this.d;
    }

    public int j() {
        java.lang.String str;
        java.util.Map map = this.g;
        if (map == null || (str = (java.lang.String) map.get("maxStrategyQueryOneDay")) == null || str.trim().equals("")) {
            return this.e;
        }
        int i = this.e;
        try {
            return java.lang.Integer.valueOf(str).intValue();
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean k() {
        java.util.Map map;
        java.lang.String str;
        map = this.g;
        return map != null && (str = (java.lang.String) map.get("zeroPeak")) != null && "y".equalsIgnoreCase(str) && java.util.Calendar.getInstance().get(11) == 0;
    }

    public void l() {
        java.lang.String strB = b("isSocketOnOff");
        if (strB == null || !"n".equals(strB)) {
            return;
        }
        a(false);
    }
}
