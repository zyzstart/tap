package com.tencent.beacon.core.info;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile com.tencent.beacon.core.info.b f184a;
    public static java.lang.String b;
    public static java.lang.String c;
    public static java.lang.String d;
    private android.content.Context e;
    private java.lang.String f;
    private java.lang.String g;
    private byte h;
    private java.lang.String i = "";
    private java.lang.String j;
    private java.lang.String k;
    private java.lang.String l;
    private java.lang.String m;
    private long n;
    private java.lang.String o;
    private java.lang.String p;

    public b(android.content.Context context) {
        this.f = "";
        this.g = "";
        this.h = (byte) -1;
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.o = "";
        this.p = "";
        this.e = context;
        com.tencent.beacon.core.info.e eVarD = com.tencent.beacon.core.info.e.d(context);
        this.f = eVarD.h();
        this.g = eVarD.n();
        this.h = (byte) 1;
        this.j = com.tencent.beacon.core.info.a.a(context);
        this.k = "beacon";
        this.l = "3.2.2.33";
        this.m = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
        this.o = a(context);
        this.p = com.tencent.beacon.core.e.c.a(e(context));
    }

    protected static java.lang.String a(android.content.Context context) {
        if (context == null) {
            return "";
        }
        try {
            java.lang.Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("[REDACTED]");
            return obj != null ? obj.toString().trim() : "";
        } catch (java.lang.Throwable unused) {
            com.tencent.beacon.core.e.d.b("[REDACTED]", new java.lang.Object[0]);
            return "";
        }
    }

    public static synchronized com.tencent.beacon.core.info.b b(android.content.Context context) {
        if (f184a == null) {
            f184a = new com.tencent.beacon.core.info.b(context);
        }
        return f184a;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x0093 A[DONT_GENERATE, EXC_TOP_SPLITTER, PHI: r0 r5
  0x0093: PHI (r0v3 java.lang.String) = (r0v2 java.lang.String), (r0v5 java.lang.String) binds: [B:35:0x0091, B:26:0x0076] A[DONT_GENERATE, DONT_INLINE]
  0x0093: PHI (r5v3 java.io.InputStream) = (r5v2 java.io.InputStream), (r5v4 java.io.InputStream) binds: [B:35:0x0091, B:26:0x0076] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    protected static java.lang.String c(android.content.Context context) {
        java.lang.String property = "";
        android.content.res.AssetManager assets = context.getAssets();
        com.tencent.beacon.core.a.f fVarA = com.tencent.beacon.core.a.f.a(context);
        java.io.InputStream inputStreamOpen = null;
        try {
            try {
                java.lang.String strA = fVarA.a("key_channelpath", "");
                if (com.tencent.beacon.core.e.j.b(strA)) {
                    strA = "channel.ini";
                    fVarA.b().a("key_channelpath", (java.lang.Object) "channel.ini").a();
                }
                com.tencent.beacon.core.e.d.a("[core] channel path: %s", strA);
                if (!strA.equals("")) {
                    inputStreamOpen = assets.open(strA);
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(inputStreamOpen);
                    property = properties.getProperty("CHANNEL", "");
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("[core] channel from assets ");
                    sb.append(property);
                    com.tencent.beacon.core.e.d.d(sb.toString(), new java.lang.Object[0]);
                    if (!com.tencent.beacon.core.e.j.b(property)) {
                        if (inputStreamOpen != null) {
                            try {
                                inputStreamOpen.close();
                            } catch (java.io.IOException e) {
                                com.tencent.beacon.core.e.d.a(e);
                            }
                        }
                        return property;
                    }
                }
            } catch (java.lang.Exception unused) {
                fVarA.b().a("key_channelpath", (java.lang.Object) "").a();
                com.tencent.beacon.core.e.d.i("[core] get app channel fail!", new java.lang.Object[0]);
            }
            return property;
        } finally {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (java.io.IOException e2) {
                    com.tencent.beacon.core.e.d.a(e2);
                }
            }
        }
    }

    protected static java.lang.String d(android.content.Context context) {
        try {
            java.lang.Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("CHANNEL_DENGTA");
            return obj != null ? obj.toString() : "";
        } catch (java.lang.Throwable unused) {
            com.tencent.beacon.core.e.d.b("[core] not set 'CHANNEL_DENGTA' in manifest", new java.lang.Object[0]);
            return "";
        }
    }

    private static java.lang.String e(android.content.Context context) {
        if (context == null) {
            return "";
        }
        java.lang.String strC = c(context);
        return !com.tencent.beacon.core.e.j.b(strC) ? strC : d(context);
    }

    public static java.lang.String i() {
        return "3.2.2.33";
    }

    public synchronized java.lang.String a() {
        if (!com.tencent.beacon.core.e.j.b(b)) {
            return b;
        }
        if (com.tencent.beacon.core.e.j.b(this.o)) {
            return b();
        }
        return this.o;
    }

    public synchronized java.lang.String a(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(c)) {
            return this.j;
        }
        return c;
    }

    public synchronized void a(long j) {
        this.n = j;
    }

    public synchronized java.lang.String b() {
        android.content.Context context = this.e;
        if (context == null) {
            return "";
        }
        java.lang.String packageName = context.getPackageName();
        this.i = packageName;
        return packageName;
    }

    public synchronized java.lang.String b(java.lang.String str) {
        if (com.tencent.beacon.core.e.j.b(d)) {
            return this.p;
        }
        return d;
    }

    public synchronized android.content.Context c() {
        return this.e;
    }

    public void c(java.lang.String str) {
        this.m = str;
    }

    public synchronized java.lang.String d() {
        return this.m;
    }

    public java.lang.String e() {
        return this.f;
    }

    public java.lang.String f() {
        return this.g;
    }

    public synchronized byte g() {
        return this.h;
    }

    public synchronized java.lang.String h() {
        return this.k;
    }

    public synchronized long j() {
        return this.n;
    }

    public synchronized boolean k() {
        boolean z;
        android.content.Context context = this.e;
        if (context == null) {
            return false;
        }
        try {
            android.content.SharedPreferences sharedPreferencesC = com.tencent.beacon.core.a.f.a(context).c();
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append(com.tencent.beacon.core.info.a.c(this.e));
            sb.append("_");
            sb.append("SDKVER_DENGTA");
            java.lang.String string = sb.toString();
            java.lang.String string2 = sharedPreferencesC.getString(string, null);
            if (string2 == null || !string2.equals(this.l)) {
                try {
                    sharedPreferencesC.edit().putString(string, this.l).apply();
                    z = true;
                } catch (java.lang.Exception e) {
                    e = e;
                    z = true;
                    com.tencent.beacon.core.e.d.b("[core] updateLocalSDKVER fail!", new java.lang.Object[0]);
                    com.tencent.beacon.core.e.d.a(e);
                }
            } else {
                z = false;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            z = false;
        }
        com.tencent.beacon.core.e.d.a("[core] isNewSDKVersion: %s", java.lang.Boolean.valueOf(z));
        return z;
    }
}
