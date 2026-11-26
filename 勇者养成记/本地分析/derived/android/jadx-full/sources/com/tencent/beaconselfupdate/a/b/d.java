package com.tencent.beaconselfupdate.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.beaconselfupdate.a.b.d f232a;
    private android.util.SparseArray e;
    private java.lang.String b = "http://oth.str.mdt.qq.com:8080/analytics/upload";
    private int c = 360;
    private int d = 100;
    private java.util.Map f = null;
    private byte g = 3;
    private byte h = 2;
    private java.lang.String i = "";
    private java.lang.String j = "";
    private java.lang.String k = "";

    public final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f234a;
        private boolean b = false;
        private java.lang.String c = "http://oth.eve.mdt.qq.com:8080/analytics/upload";
        private java.lang.String d = "http://jrlt.beacon.qq.com/analytics/upload";
        private java.util.Map e = null;
        private java.util.Set f = null;
        private java.util.Set g = null;

        public a(int i) {
            this.f234a = i;
        }

        public final void a(java.lang.String str) {
            this.c = str;
        }

        public final void a(java.util.Map map) {
            this.e = map;
        }

        public final void a(java.util.Set set) {
            this.f = set;
        }

        public final void a(boolean z) {
            this.b = z;
        }

        public final boolean a() {
            return this.b;
        }

        public final java.lang.String b() {
            return com.tencent.beaconselfupdate.c.a.b ? this.d : this.c;
        }

        public final void b(java.util.Set set) {
            this.g = set;
        }

        public final java.util.Map c() {
            return this.e;
        }

        public final java.util.Set d() {
            return this.f;
        }

        public final int e() {
            return this.f234a;
        }

        public final java.util.Set f() {
            return this.g;
        }
    }

    private d() {
        this.e = null;
        android.util.SparseArray sparseArray = new android.util.SparseArray(3);
        this.e = sparseArray;
        sparseArray.put(1, new com.tencent.beaconselfupdate.a.b.d.a(1));
        this.e.put(2, new com.tencent.beaconselfupdate.a.b.d.a(2));
        this.e.put(3, new com.tencent.beaconselfupdate.a.b.d.a(3));
    }

    public static com.tencent.beaconselfupdate.a.b.d a() {
        if (f232a == null) {
            synchronized (com.tencent.beaconselfupdate.a.b.d.class) {
                if (f232a == null) {
                    f232a = new com.tencent.beaconselfupdate.a.b.d();
                }
            }
        }
        return f232a;
    }

    private synchronized void b(java.lang.String str) {
        this.j = str;
        this.i = android.util.Base64.encodeToString(com.tencent.beaconselfupdate.a.e.a(str), 2);
    }

    private synchronized void c(java.lang.String str) {
        this.k = str;
    }

    public final void a(int i) {
        this.c = i;
    }

    final synchronized void a(android.content.Context context) {
        java.lang.Object[] objArrA = com.tencent.beaconselfupdate.a.e.a(context, "sid");
        if (objArrA != null && objArrA.length == 3) {
            long time = new java.util.Date().getTime() / 1000;
            long jLongValue = 0;
            try {
                jLongValue = ((java.lang.Long) objArrA[2]).longValue();
            } catch (java.lang.Exception unused) {
            }
            if (jLongValue > time) {
                c((java.lang.String) objArrA[1]);
            }
        }
        b(com.tencent.beaconselfupdate.a.e.k(context));
    }

    public final synchronized void a(final android.content.Context context, final java.lang.String str, final java.lang.String str2) {
        this.k = str;
        com.tencent.beaconselfupdate.a.b.a().a(new java.lang.Runnable() { // from class: com.tencent.beaconselfupdate.a.b.d.1
            @Override // java.lang.Runnable
            public final void run() {
                long time;
                java.lang.Object[] objArr = new java.lang.Object[2];
                objArr[0] = str;
                try {
                    time = com.tencent.beaconselfupdate.a.e.e(str2).getTime() / 1000;
                } catch (java.lang.Exception unused) {
                    time = 0;
                }
                if (time == 0) {
                    time = (new java.util.Date().getTime() / 1000) + com.tencent.smtt.sdk.TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC;
                }
                objArr[1] = java.lang.Long.valueOf(time);
                android.content.Context context2 = context;
                com.tencent.beaconselfupdate.a.b.d.this.getClass();
                com.tencent.beaconselfupdate.a.e.a(context2, "sid", objArr);
            }
        });
    }

    public final void a(java.lang.String str) {
        this.b = str;
    }

    public final void a(java.util.Map map) {
        this.f = map;
    }

    public final synchronized com.tencent.beaconselfupdate.a.b.d.a b(int i) {
        android.util.SparseArray sparseArray = this.e;
        if (sparseArray == null) {
            return null;
        }
        return (com.tencent.beaconselfupdate.a.b.d.a) sparseArray.get(i);
    }

    public final java.lang.String b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final java.util.Map d() {
        return this.f;
    }

    public final synchronized android.util.SparseArray e() {
        if (this.e == null) {
            return null;
        }
        new com.tencent.beaconselfupdate.c.b();
        return com.tencent.beaconselfupdate.c.b.a(this.e);
    }

    public final int f() {
        java.lang.String str;
        java.util.Map map = this.f;
        if (map == null || (str = (java.lang.String) map.get("maxStrategyQueryOneDay")) == null || str.trim().equals("")) {
            return this.d;
        }
        int i = this.d;
        try {
            return java.lang.Integer.valueOf(str).intValue();
        } catch (java.lang.Exception unused) {
            return i;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized boolean g() {
        java.util.Map map;
        java.lang.String str;
        map = this.f;
        return map != null && (str = (java.lang.String) map.get("zeroPeak")) != null && "y".equalsIgnoreCase(str) && java.util.Calendar.getInstance().get(11) == 0;
    }

    public final synchronized byte h() {
        return this.g;
    }

    public final synchronized byte i() {
        return this.h;
    }

    public final synchronized java.lang.String j() {
        return this.i;
    }

    public final synchronized java.lang.String k() {
        return this.j;
    }

    public final synchronized java.lang.String l() {
        return this.k;
    }
}
