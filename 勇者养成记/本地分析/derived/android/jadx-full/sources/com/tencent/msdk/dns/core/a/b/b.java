package com.tencent.msdk.dns.core.a.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends com.tencent.msdk.dns.core.a.c.a {
    private static final com.tencent.msdk.dns.core.a.b.b d = new com.tencent.msdk.dns.core.a.b.b(null);
    private java.lang.String b;
    private java.lang.String c;

    public b(java.lang.String[] strArr) {
        super(strArr);
        this.b = null;
        this.c = null;
    }

    public static com.tencent.msdk.dns.core.a.b.b a() {
        return d;
    }

    public java.lang.String b() {
        if (this.b == null) {
            this.b = "0";
            for (java.lang.String str : this.f658a) {
                if (com.tencent.msdk.dns.base.c.c.b(str)) {
                    this.b = str;
                    break;
                }
            }
        }
        return this.b;
    }

    public java.lang.String c() {
        if (this.c == null) {
            this.c = "0";
            for (java.lang.String str : this.f658a) {
                if (com.tencent.msdk.dns.base.c.c.c(str)) {
                    this.c = str;
                    break;
                }
            }
        }
        return this.c;
    }

    public java.lang.String toString() {
        return "LocalDnsResponse{mIpArr='" + java.util.Arrays.toString(this.f658a) + "'}";
    }
}
