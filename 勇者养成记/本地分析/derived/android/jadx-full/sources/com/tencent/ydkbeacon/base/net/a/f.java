package com.tencent.ydkbeacon.base.net.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final java.lang.String f1209a;
    private final com.tencent.ydkbeacon.base.net.HttpMethod b;
    private final java.util.Map c;
    private final java.util.Map d;
    private com.tencent.ydkbeacon.base.net.BodyType e;
    private java.lang.String f;
    private byte[] g;
    private final java.lang.String h;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.tencent.ydkbeacon.base.net.HttpMethod f1210a;
        private java.lang.String b;
        private java.lang.String c;
        private java.util.Map d = new java.util.HashMap(3);
        private java.util.Map e = new java.util.HashMap(3);
        private java.lang.String f;
        private com.tencent.ydkbeacon.base.net.BodyType g;
        private byte[] h;

        private void a(com.tencent.ydkbeacon.base.net.BodyType bodyType) {
            if (this.g == null) {
                this.g = bodyType;
            }
            if (this.g != bodyType) {
                throw new java.lang.IllegalStateException("bodyType already set!");
            }
        }

        public com.tencent.ydkbeacon.base.net.a.f.a a(com.tencent.ydkbeacon.base.net.HttpMethod httpMethod) {
            this.f1210a = httpMethod;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.f.a a(java.lang.String str) {
            this.c = str;
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.f.a a(@android.support.annotation.NonNull java.util.Map map) {
            a(com.tencent.ydkbeacon.base.net.BodyType.FORM);
            this.d.putAll(map);
            return this;
        }

        public com.tencent.ydkbeacon.base.net.a.f a() {
            if (this.f1210a == null) {
                throw new java.lang.NullPointerException("request method == null");
            }
            if (android.text.TextUtils.isEmpty(this.b)) {
                throw new java.lang.NullPointerException("request url == null!");
            }
            com.tencent.ydkbeacon.base.net.BodyType bodyType = this.g;
            if (bodyType == null) {
                throw new java.lang.NullPointerException("bodyType == null");
            }
            int i = com.tencent.ydkbeacon.base.net.a.e.f1208a[bodyType.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i == 3 && this.h == null) {
                        throw new java.lang.NullPointerException("data request body == null");
                    }
                } else if (this.d.isEmpty()) {
                    throw new java.lang.NullPointerException("form request body == null");
                }
            } else if (android.text.TextUtils.isEmpty(this.f)) {
                throw new java.lang.NullPointerException("json request body == null");
            }
            return new com.tencent.ydkbeacon.base.net.a.f(this.f1210a, this.b, this.e, this.g, this.f, this.d, this.h, this.c, null);
        }

        public com.tencent.ydkbeacon.base.net.a.f.a b(@android.support.annotation.NonNull java.lang.String str) {
            this.b = str;
            return this;
        }
    }

    private f(com.tencent.ydkbeacon.base.net.HttpMethod httpMethod, java.lang.String str, java.util.Map map, com.tencent.ydkbeacon.base.net.BodyType bodyType, java.lang.String str2, java.util.Map map2, byte[] bArr, java.lang.String str3) {
        this.b = httpMethod;
        this.f1209a = str;
        this.c = map;
        this.e = bodyType;
        this.f = str2;
        this.d = map2;
        this.g = bArr;
        this.h = str3;
    }

    /* synthetic */ f(com.tencent.ydkbeacon.base.net.HttpMethod httpMethod, java.lang.String str, java.util.Map map, com.tencent.ydkbeacon.base.net.BodyType bodyType, java.lang.String str2, java.util.Map map2, byte[] bArr, java.lang.String str3, com.tencent.ydkbeacon.base.net.a.e eVar) {
        this(httpMethod, str, map, bodyType, str2, map2, bArr, str3);
    }

    public static com.tencent.ydkbeacon.base.net.a.f.a b() {
        return new com.tencent.ydkbeacon.base.net.a.f.a();
    }

    public com.tencent.ydkbeacon.base.net.BodyType a() {
        return this.e;
    }

    public byte[] c() {
        return this.g;
    }

    public java.util.Map d() {
        return this.d;
    }

    public java.util.Map e() {
        return this.c;
    }

    public java.lang.String f() {
        return this.f;
    }

    public com.tencent.ydkbeacon.base.net.HttpMethod g() {
        return this.b;
    }

    public java.lang.String h() {
        return this.h;
    }

    public java.lang.String i() {
        return this.f1209a;
    }

    public java.lang.String toString() {
        return "HttpRequestEntity{url='" + this.f1209a + "', method=" + this.b + ", headers=" + this.c + ", formParams=" + this.d + ", bodyType=" + this.e + ", json='" + this.f + "', tag='" + this.h + "'}";
    }
}
