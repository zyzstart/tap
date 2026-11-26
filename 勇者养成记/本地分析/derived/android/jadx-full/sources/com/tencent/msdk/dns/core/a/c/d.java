package com.tencent.msdk.dns.core.a.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d {
    private static final com.tencent.msdk.dns.core.a.c.d d = new com.tencent.msdk.dns.core.a.c.d();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f660a;
    public com.tencent.msdk.dns.core.a.c.d.a b;
    public com.tencent.msdk.dns.core.a.c.d.a c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final com.tencent.msdk.dns.core.a.c.d.a f661a = new com.tencent.msdk.dns.core.a.c.d.a();
        public java.lang.String b;
        public int c;

        private a() {
            this.b = "0";
            this.c = -1;
        }

        public a(java.lang.String str, int i) {
            this.b = "0";
            this.c = -1;
            this.b = str;
            this.c = i;
        }
    }

    private d() {
        this.f660a = 0;
        com.tencent.msdk.dns.core.a.c.d.a aVar = com.tencent.msdk.dns.core.a.c.d.a.f661a;
        this.b = aVar;
        this.c = aVar;
    }

    public d(int i, com.tencent.msdk.dns.core.a.c.d.a aVar, com.tencent.msdk.dns.core.a.c.d.a aVar2) {
        this.f660a = 0;
        com.tencent.msdk.dns.core.a.c.d.a aVar3 = com.tencent.msdk.dns.core.a.c.d.a.f661a;
        this.b = aVar3;
        this.c = aVar3;
        if (com.tencent.msdk.dns.base.c.a(i)) {
            this.f660a = i;
        }
        if (aVar != null) {
            this.b = aVar;
        }
        if (aVar2 != null) {
            this.c = aVar2;
        }
    }

    public static com.tencent.msdk.dns.core.a.c.d a() {
        return d;
    }

    public java.lang.String[] b() {
        return new java.lang.String[]{this.b.b, this.c.b};
    }

    public java.lang.String toString() {
        return this.b.b + "," + this.c.b;
    }
}
