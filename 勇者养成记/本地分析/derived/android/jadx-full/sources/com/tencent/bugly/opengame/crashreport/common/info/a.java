package com.tencent.bugly.opengame.crashreport.common.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {
    private static com.tencent.bugly.opengame.crashreport.common.info.a af;
    public android.content.SharedPreferences E;
    private final android.content.Context F;
    private java.lang.String G;
    private java.lang.String H;
    private java.lang.String I;
    private java.lang.String Y;
    public java.lang.String c;
    public final java.lang.String d;
    public final java.lang.String f;
    public final java.lang.String g;
    public final java.lang.String h;
    public long i;
    public java.lang.String j;
    public java.lang.String k;
    public java.lang.String l;
    public java.util.List o;
    public boolean u;
    public java.lang.String v;
    public java.lang.String w;
    public java.lang.String x;
    public boolean z;
    public boolean e = true;
    private java.lang.String J = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    private java.lang.String K = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    private java.lang.String L = "";
    private java.lang.String M = null;
    private java.lang.String N = null;
    private java.lang.String O = null;
    private java.lang.String P = null;
    private long Q = -1;
    private long R = -1;
    private long S = -1;
    private java.lang.String T = null;
    private java.lang.String U = null;
    private java.util.Map V = null;
    private boolean W = true;
    private java.lang.String X = null;
    private java.lang.Boolean Z = null;
    private java.lang.String aa = null;
    private java.lang.String ab = null;
    private java.lang.String ac = null;
    public java.lang.String m = null;
    public java.lang.String n = null;
    private java.util.Map ad = null;
    private java.util.Map ae = null;
    private int ag = -1;
    private int ah = -1;
    private java.util.Map ai = new java.util.HashMap();
    private java.util.Map aj = new java.util.HashMap();
    private java.util.Map ak = new java.util.HashMap();
    private boolean al = true;
    public java.lang.String p = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public boolean y = false;
    private java.lang.Boolean am = null;
    private java.lang.Boolean an = null;
    public java.util.HashMap A = new java.util.HashMap();
    private java.lang.String ao = null;
    private java.lang.String ap = null;
    private java.lang.String aq = null;
    private java.lang.String ar = null;
    private java.lang.String as = null;
    public boolean B = true;
    public java.util.List C = new java.util.ArrayList();
    public com.tencent.bugly.opengame.crashreport.a D = null;
    private final java.lang.Object at = new java.lang.Object();
    private final java.lang.Object au = new java.lang.Object();
    private final java.lang.Object av = new java.lang.Object();
    private final java.lang.Object aw = new java.lang.Object();
    private final java.lang.Object ax = new java.lang.Object();
    private final java.lang.Object ay = new java.lang.Object();
    private final java.lang.Object az = new java.lang.Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f342a = java.lang.System.currentTimeMillis();
    public final byte b = 1;

    private a(android.content.Context context) {
        this.j = null;
        this.k = null;
        this.Y = null;
        this.l = null;
        this.o = null;
        this.u = false;
        this.v = null;
        this.w = null;
        this.x = null;
        this.z = false;
        this.F = com.tencent.bugly.opengame.proguard.z.a(context);
        android.content.pm.PackageInfo packageInfoB = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.b(context);
        if (packageInfoB != null) {
            try {
                java.lang.String str = packageInfoB.versionName;
                this.j = str;
                this.v = str;
                this.w = java.lang.Integer.toString(packageInfoB.versionCode);
            } catch (java.lang.Throwable th) {
                if (!com.tencent.bugly.opengame.proguard.x.a(th)) {
                    th.printStackTrace();
                }
            }
        }
        this.c = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.a(context);
        this.d = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.a(android.os.Process.myPid());
        this.f = com.tencent.bugly.opengame.crashreport.common.info.b.o();
        this.g = com.tencent.bugly.opengame.crashreport.common.info.b.a();
        this.k = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.c(context);
        this.h = "Android " + com.tencent.bugly.opengame.crashreport.common.info.b.b() + ",level " + com.tencent.bugly.opengame.crashreport.common.info.b.c();
        java.lang.String str2 = this.g + ";" + this.h;
        java.util.Map mapD = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.d(context);
        if (mapD != null) {
            try {
                this.o = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.a(mapD);
                java.lang.String str3 = (java.lang.String) mapD.get("BUGLY_APPID");
                if (str3 != null) {
                    this.Y = str3;
                    c("APP_ID", str3);
                }
                java.lang.String str4 = (java.lang.String) mapD.get("BUGLY_APP_VERSION");
                if (str4 != null) {
                    this.j = str4;
                }
                java.lang.String str5 = (java.lang.String) mapD.get("BUGLY_APP_CHANNEL");
                if (str5 != null) {
                    this.l = str5;
                }
                java.lang.String str6 = (java.lang.String) mapD.get("BUGLY_ENABLE_DEBUG");
                if (str6 != null) {
                    this.u = str6.equalsIgnoreCase(com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON);
                }
                java.lang.String str7 = (java.lang.String) mapD.get("com.tencent.rdm.uuid");
                if (str7 != null) {
                    this.x = str7;
                }
            } catch (java.lang.Throwable th2) {
                if (!com.tencent.bugly.opengame.proguard.x.a(th2)) {
                    th2.printStackTrace();
                }
            }
        }
        try {
            if (!context.getDatabasePath("bugly_db_opengame").exists()) {
                this.z = true;
                com.tencent.bugly.opengame.proguard.x.c("App is first time to be installed on the device.", new java.lang.Object[0]);
            }
        } catch (java.lang.Throwable th3) {
            if (com.tencent.bugly.opengame.b.c) {
                th3.printStackTrace();
            }
        }
        this.E = com.tencent.bugly.opengame.proguard.z.a("BUGLY_COMMON_VALUES", context);
        com.tencent.bugly.opengame.proguard.x.c("com info create end", new java.lang.Object[0]);
    }

    public static int K() {
        return com.tencent.bugly.opengame.crashreport.common.info.b.c();
    }

    public static synchronized com.tencent.bugly.opengame.crashreport.common.info.a a(android.content.Context context) {
        if (af == null) {
            af = new com.tencent.bugly.opengame.crashreport.common.info.a(context);
        }
        return af;
    }

    public static synchronized com.tencent.bugly.opengame.crashreport.common.info.a b() {
        return af;
    }

    public static java.lang.String c() {
        return "3.0.0";
    }

    public final java.lang.String A() {
        if (this.ac == null) {
            java.lang.String str = com.tencent.bugly.opengame.crashreport.common.info.b.g();
            this.ac = str;
            com.tencent.bugly.opengame.proguard.x.a("Hardware serial number: %s", str);
        }
        return this.ac;
    }

    public final java.util.Map B() {
        synchronized (this.av) {
            if (this.ai.size() <= 0) {
                return null;
            }
            return new java.util.HashMap(this.ai);
        }
    }

    public final void C() {
        synchronized (this.av) {
            this.ai.clear();
        }
    }

    public final int D() {
        int size;
        synchronized (this.av) {
            size = this.ai.size();
        }
        return size;
    }

    public final java.util.Set E() {
        java.util.Set setKeySet;
        synchronized (this.av) {
            setKeySet = this.ai.keySet();
        }
        return setKeySet;
    }

    public final java.util.Map F() {
        synchronized (this.az) {
            if (this.aj.size() <= 0) {
                return null;
            }
            return new java.util.HashMap(this.aj);
        }
    }

    public final java.util.Map G() {
        synchronized (this.aw) {
            if (this.ak.size() <= 0) {
                return null;
            }
            return new java.util.HashMap(this.ak);
        }
    }

    public final int H() {
        int i;
        synchronized (this.ax) {
            i = this.ag;
        }
        return i;
    }

    public final int I() {
        return this.ah;
    }

    public final synchronized java.util.Map J() {
        return null;
    }

    public final java.lang.String L() {
        if (this.ao == null) {
            this.ao = com.tencent.bugly.opengame.crashreport.common.info.b.q();
        }
        return this.ao;
    }

    public final java.lang.String M() {
        if (this.ap == null) {
            this.ap = com.tencent.bugly.opengame.crashreport.common.info.b.f(this.F);
        }
        return this.ap;
    }

    public final java.lang.String N() {
        if (this.aq == null) {
            this.aq = com.tencent.bugly.opengame.crashreport.common.info.b.g(this.F);
        }
        return this.aq;
    }

    public final java.lang.String O() {
        return com.tencent.bugly.opengame.crashreport.common.info.b.r();
    }

    public final java.lang.String P() {
        if (this.ar == null) {
            this.ar = com.tencent.bugly.opengame.crashreport.common.info.b.h(this.F);
        }
        return this.ar;
    }

    public final long Q() {
        return com.tencent.bugly.opengame.crashreport.common.info.b.s();
    }

    public final boolean R() {
        if (this.am == null) {
            this.am = java.lang.Boolean.valueOf(com.tencent.bugly.opengame.crashreport.common.info.b.i(this.F));
            com.tencent.bugly.opengame.proguard.x.a("Is it a virtual machine? " + this.am, new java.lang.Object[0]);
        }
        return this.am.booleanValue();
    }

    public final boolean S() {
        if (this.an == null) {
            this.an = java.lang.Boolean.valueOf(com.tencent.bugly.opengame.crashreport.common.info.b.j(this.F));
            com.tencent.bugly.opengame.proguard.x.a("Does it has hook frame? " + this.an, new java.lang.Object[0]);
        }
        return this.an.booleanValue();
    }

    public final java.lang.String T() {
        if (this.H == null) {
            this.H = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.g(this.F);
            com.tencent.bugly.opengame.proguard.x.a("Beacon channel " + this.H, new java.lang.Object[0]);
        }
        return this.H;
    }

    public final void a(int i) {
        synchronized (this.ax) {
            int i2 = this.ag;
            if (i2 != i) {
                this.ag = i;
                com.tencent.bugly.opengame.proguard.x.a("user scene tag %d changed to tag %d", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(this.ag));
            }
        }
    }

    public final void a(java.lang.String str) {
        this.Y = str;
        c("APP_ID", str);
    }

    public final void a(java.lang.String str, java.lang.String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.au) {
            this.A.put(str, str2);
        }
    }

    public final void a(boolean z) {
        this.al = z;
        com.tencent.bugly.opengame.crashreport.a aVar = this.D;
        if (aVar != null) {
            aVar.setNativeIsAppForeground(z);
        }
    }

    public final boolean a() {
        return this.al;
    }

    public final void b(int i) {
        int i2 = this.ah;
        if (i2 != 24096) {
            this.ah = 24096;
            com.tencent.bugly.opengame.proguard.x.a("server scene tag %d changed to tag %d", java.lang.Integer.valueOf(i2), java.lang.Integer.valueOf(this.ah));
        }
    }

    public final void b(java.lang.String str) {
        synchronized (this.ay) {
            if (str == null) {
                str = "10000";
            }
            this.J = str;
        }
    }

    public final void b(java.lang.String str, java.lang.String str2) {
        if (!com.tencent.bugly.opengame.proguard.z.a(str) && !com.tencent.bugly.opengame.proguard.z.a(str2)) {
            synchronized (this.av) {
                this.ai.put(str, str2);
            }
        } else {
            com.tencent.bugly.opengame.proguard.x.d("key&value should not be empty %s %s", str, str2);
        }
    }

    public final void b(boolean z) {
        this.W = z;
    }

    public final void c(java.lang.String str) {
        this.I = str;
        synchronized (this.az) {
            this.aj.put("E8", str);
        }
    }

    public final void c(java.lang.String str, java.lang.String str2) {
        if (!com.tencent.bugly.opengame.proguard.z.a(str) && !com.tencent.bugly.opengame.proguard.z.a(str2)) {
            synchronized (this.aw) {
                this.ak.put(str, str2);
            }
        } else {
            com.tencent.bugly.opengame.proguard.x.d("server key&value should not be empty %s %s", str, str2);
        }
    }

    public final void d() {
        synchronized (this.at) {
            this.G = java.util.UUID.randomUUID().toString();
        }
    }

    public final synchronized void d(java.lang.String str) {
        this.K = str;
    }

    public final java.lang.String e() {
        java.lang.String str;
        synchronized (this.at) {
            if (this.G == null) {
                synchronized (this.at) {
                    this.G = java.util.UUID.randomUUID().toString();
                }
            }
            str = this.G;
        }
        return str;
    }

    public final synchronized void e(java.lang.String str) {
        this.L = str;
    }

    public final java.lang.String f() {
        if (com.tencent.bugly.opengame.proguard.z.a((java.lang.String) null)) {
            return this.Y;
        }
        return null;
    }

    public final java.lang.String f(java.lang.String str) {
        java.lang.String str2;
        if (com.tencent.bugly.opengame.proguard.z.a(str)) {
            com.tencent.bugly.opengame.proguard.x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.av) {
            str2 = (java.lang.String) this.ai.remove(str);
        }
        return str2;
    }

    public final java.lang.String g() {
        java.lang.String str;
        synchronized (this.ay) {
            str = this.J;
        }
        return str;
    }

    public final java.lang.String g(java.lang.String str) {
        java.lang.String str2;
        if (com.tencent.bugly.opengame.proguard.z.a(str)) {
            com.tencent.bugly.opengame.proguard.x.d("key should not be empty %s", str);
            return null;
        }
        synchronized (this.av) {
            str2 = (java.lang.String) this.ai.get(str);
        }
        return str2;
    }

    public final java.lang.String h() {
        java.lang.String str = this.I;
        if (str != null) {
            return str;
        }
        java.lang.String str2 = k() + "|" + m() + "|" + n();
        this.I = str2;
        return str2;
    }

    public final synchronized java.lang.String i() {
        return this.K;
    }

    public final synchronized java.lang.String j() {
        return this.L;
    }

    public final java.lang.String k() {
        if (!this.W) {
            return "";
        }
        if (this.M == null) {
            this.M = com.tencent.bugly.opengame.crashreport.common.info.b.d();
        }
        return this.M;
    }

    public final java.lang.String l() {
        if (!this.W) {
            return "";
        }
        java.lang.String str = this.N;
        if (str == null || !str.contains(":")) {
            this.N = com.tencent.bugly.opengame.crashreport.common.info.b.f();
        }
        return this.N;
    }

    public final java.lang.String m() {
        if (!this.W) {
            return "";
        }
        if (this.O == null) {
            this.O = com.tencent.bugly.opengame.crashreport.common.info.b.e();
        }
        return this.O;
    }

    public final java.lang.String n() {
        if (!this.W) {
            return "";
        }
        if (this.P == null) {
            this.P = com.tencent.bugly.opengame.crashreport.common.info.b.a(this.F);
        }
        return this.P;
    }

    public final long o() {
        if (this.Q <= 0) {
            this.Q = com.tencent.bugly.opengame.crashreport.common.info.b.h();
        }
        return this.Q;
    }

    public final long p() {
        if (this.R <= 0) {
            this.R = com.tencent.bugly.opengame.crashreport.common.info.b.j();
        }
        return this.R;
    }

    public final long q() {
        if (this.S <= 0) {
            this.S = com.tencent.bugly.opengame.crashreport.common.info.b.l();
        }
        return this.S;
    }

    public final java.lang.String r() {
        if (this.T == null) {
            this.T = com.tencent.bugly.opengame.crashreport.common.info.b.a(this.F, true);
        }
        return this.T;
    }

    public final java.lang.String s() {
        if (this.U == null) {
            this.U = com.tencent.bugly.opengame.crashreport.common.info.b.e(this.F);
        }
        return this.U;
    }

    public final java.lang.String t() {
        try {
            java.util.Map<java.lang.String, ?> all = this.F.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.au) {
                    for (java.util.Map.Entry<java.lang.String, ?> entry : all.entrySet()) {
                        try {
                            this.A.put(entry.getKey(), entry.getValue().toString());
                        } catch (java.lang.Throwable th) {
                            com.tencent.bugly.opengame.proguard.x.a(th);
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th2) {
            com.tencent.bugly.opengame.proguard.x.a(th2);
        }
        if (this.A.isEmpty()) {
            return null;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        for (java.util.Map.Entry entry2 : this.A.entrySet()) {
            sb.append("[");
            sb.append((java.lang.String) entry2.getKey());
            sb.append(",");
            sb.append((java.lang.String) entry2.getValue());
            sb.append("] ");
        }
        c("SDK_INFO", sb.toString());
        return sb.toString();
    }

    public final java.lang.String u() {
        if (this.as == null) {
            this.as = com.tencent.bugly.opengame.crashreport.common.info.AppInfo.e(this.F);
        }
        return this.as;
    }

    public final synchronized java.util.Map v() {
        return null;
    }

    public final java.lang.String w() {
        if (this.X == null) {
            this.X = com.tencent.bugly.opengame.crashreport.common.info.b.n();
        }
        return this.X;
    }

    public final java.lang.Boolean x() {
        if (this.Z == null) {
            this.Z = java.lang.Boolean.valueOf(com.tencent.bugly.opengame.crashreport.common.info.b.p());
        }
        return this.Z;
    }

    public final java.lang.String y() {
        if (this.aa == null) {
            java.lang.String str = com.tencent.bugly.opengame.crashreport.common.info.b.d(this.F);
            this.aa = str;
            com.tencent.bugly.opengame.proguard.x.a("ROM ID: %s", str);
        }
        return this.aa;
    }

    public final java.lang.String z() {
        if (this.ab == null) {
            java.lang.String str = com.tencent.bugly.opengame.crashreport.common.info.b.b(this.F);
            this.ab = str;
            com.tencent.bugly.opengame.proguard.x.a("SIM serial number: %s", str);
        }
        return this.ab;
    }
}
