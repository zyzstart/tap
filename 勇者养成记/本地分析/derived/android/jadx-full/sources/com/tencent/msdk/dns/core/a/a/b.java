package com.tencent.msdk.dns.core.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.msdk.dns.core.a.c.a {
    private static final com.tencent.msdk.dns.core.a.a.b g = new com.tencent.msdk.dns.core.a.a.b(null, 0, null);
    private long b;
    private java.lang.String c;
    private java.lang.String d;
    private boolean e;
    private boolean f;

    public b(java.lang.String[] strArr, long j, java.lang.String str) {
        super(strArr);
        this.b = 0L;
        this.c = "0";
        this.d = null;
        this.e = false;
        this.f = false;
        h();
        if (0 < j) {
            this.b = j;
        }
        if (android.text.TextUtils.isEmpty(str)) {
            return;
        }
        this.c = str;
    }

    public static com.tencent.msdk.dns.core.a.a.b a() {
        return g;
    }

    public static boolean a(com.tencent.msdk.dns.core.a.a.b bVar) {
        return bVar != null && (bVar.e || bVar.f);
    }

    private void h() {
        java.lang.String[] strArr = this.f658a;
        int length = strArr.length;
        if (length == 0) {
            return;
        }
        boolean zB = com.tencent.msdk.dns.base.c.c.b(strArr[0]);
        this.e = zB;
        if (!zB) {
            this.f = com.tencent.msdk.dns.base.c.c.c(this.f658a[0]);
        }
        if (!this.e && !this.f) {
            this.f658a = com.tencent.msdk.dns.base.a.f644a;
            return;
        }
        int i = length;
        for (int i2 = 1; i2 < i; i2++) {
            java.lang.String str = this.f658a[i2];
            if (this.e) {
                if (!com.tencent.msdk.dns.base.c.c.b(str)) {
                    this.f658a[i2] = "0";
                    i--;
                }
            } else if (this.f && !com.tencent.msdk.dns.base.c.c.c(str)) {
                this.f658a[i2] = "0";
                i--;
            }
        }
        if (i != length) {
            java.lang.String[] strArr2 = this.f658a;
            this.f658a = new java.lang.String[i];
            int i3 = i - 1;
            for (int i4 = length - 1; i4 >= 0 && i3 >= 0; i4--) {
                java.lang.String str2 = strArr2[i4];
                if (!"0".equals(str2)) {
                    this.f658a[i3] = str2;
                    i3--;
                }
            }
        }
    }

    public long b() {
        return this.b;
    }

    public java.lang.String c() {
        return this.c;
    }

    public java.lang.String d() {
        if (this.d == null) {
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            for (java.lang.String str : this.f658a) {
                if (!com.tencent.msdk.dns.base.c.c.a(str)) {
                    sb.setLength(0);
                    break;
                }
                sb.append(str);
                sb.append(",");
            }
            if (sb.length() > 0) {
                sb.setLength(sb.length() - 1);
            }
            java.lang.String string = sb.toString();
            this.d = string;
            if (android.text.TextUtils.isEmpty(string)) {
                this.d = "";
            }
        }
        return this.d;
    }

    public java.lang.String e() {
        return a(this) ? this.f658a[0] : "0";
    }

    public boolean f() {
        return this.e;
    }

    public boolean g() {
        return this.f;
    }

    public java.lang.String toString() {
        return "HttpDnsResponse{mTtl=" + this.b + ", mClientIp='" + this.c + "', mIpArr='" + java.util.Arrays.toString(this.f658a) + "'}";
    }
}
