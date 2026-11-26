package com.tencent.ydkbeacon.base.net.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tencent.ydkbeacon.base.net.RequestType f1214a;
    private final java.lang.String b;
    private final java.lang.String c;
    private final int d;
    private final java.lang.String e;
    private final byte[] f;
    private final java.util.Map g;
    private final int h;
    private final int i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.lang.String f1215a;
        private int b;
        private java.lang.String c;
        private int d;
        private int e;
        private com.tencent.ydkbeacon.base.net.RequestType f;
        private java.lang.String g;
        private java.util.Map h = new java.util.concurrent.ConcurrentHashMap(5);
        private java.util.Map i = new java.util.LinkedHashMap(10);
        private byte[] j;
        private com.tencent.ydkbeacon.pack.JceStruct k;

        public com.tencent.ydkbeacon.base.net.a.k.a a(int i) {
            this.d = i;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a a(com.tencent.ydkbeacon.base.net.RequestType requestType) {
            this.f = requestType;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a a(com.tencent.ydkbeacon.pack.JceStruct jceStruct) {
            this.k = jceStruct;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a a(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a a(java.lang.String str, int i) {
            this.g = str;
            this.b = i;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a a(@android.support.annotation.NonNull java.lang.String str, java.lang.String str2) {
            this.h.put(str, str2);
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a a(java.util.Map map) {
            if (map != null) {
                this.i.putAll(map);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public com.tencent.ydkbeacon.base.net.a.k a() {
            java.lang.Object objA;
            com.tencent.ydkbeacon.base.net.b.c cVarC;
            if (android.text.TextUtils.isEmpty(this.f1215a) && android.text.TextUtils.isEmpty(this.g)) {
                throw new java.lang.IllegalArgumentException("url || domain == null");
            }
            if (android.text.TextUtils.isEmpty(this.c)) {
                throw new java.lang.IllegalArgumentException("[REDACTED]");
            }
            com.tencent.ydkbeacon.base.net.d dVarC = com.tencent.ydkbeacon.base.net.d.c();
            this.h.putAll(com.tencent.ydkbeacon.base.net.c.d.a());
            if (this.f == com.tencent.ydkbeacon.base.net.RequestType.EVENT) {
                cVarC = dVarC.e.c();
                objA = (com.tencent.ydkbeacon.pack.RequestPackageV2) this.k;
            } else {
                com.tencent.ydkbeacon.pack.JceStruct jceStruct = this.k;
                objA = com.tencent.ydkbeacon.base.net.c.d.a(this.d, jceStruct == null ? "".getBytes() : jceStruct.toByteArray(), this.i, this.c);
                cVarC = dVarC.d.c();
            }
            this.j = (byte[]) cVarC.a(objA);
            return new com.tencent.ydkbeacon.base.net.a.k(this.f, this.f1215a, this.g, this.b, this.c, this.j, this.h, this.d, this.e);
        }

        public com.tencent.ydkbeacon.base.net.a.k.a b(int i) {
            this.e = i;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a b(java.lang.String str) {
            this.f1215a = str;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.k.a b(java.lang.String str, java.lang.String str2) {
            if (str2 == null) {
                str2 = "";
            }
            this.i.put(str, str2);
            return this;
        }
    }

    private k(com.tencent.ydkbeacon.base.net.RequestType requestType, java.lang.String str, java.lang.String str2, int i, java.lang.String str3, byte[] bArr, java.util.Map map, int i2, int i3) {
        this.f1214a = requestType;
        this.b = str;
        this.c = str2;
        this.d = i;
        this.e = str3;
        this.f = bArr;
        this.g = map;
        this.h = i2;
        this.i = i3;
    }

    public static com.tencent.ydkbeacon.base.net.a.k.a a() {
        return new com.tencent.ydkbeacon.base.net.a.k.a();
    }

    public byte[] b() {
        return this.f;
    }

    public java.lang.String c() {
        return this.c;
    }

    public java.util.Map d() {
        return this.g;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.i;
    }

    public com.tencent.ydkbeacon.base.net.RequestType g() {
        return this.f1214a;
    }

    public java.lang.String h() {
        return this.b;
    }

    public java.lang.String toString() {
        return "[REDACTED]" + this.f1214a + "[REDACTED]" + this.b + "[REDACTED]" + this.c + "[REDACTED]" + this.d + "[REDACTED]" + this.e + "[REDACTED]" + this.f.length + "[REDACTED]" + this.g + "[REDACTED]" + this.h + "[REDACTED]" + this.i + '}';
    }
}
