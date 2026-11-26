package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f94a;
    private java.lang.String b;
    private java.util.Map<java.lang.String, java.lang.String> c;
    private com.qq.gdt.action.d.b.h d;
    private int e;
    private int f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private java.lang.String f95a;
        private java.lang.String b = com.tencent.connect.common.Constants.HTTP_GET;
        private java.util.Map<java.lang.String, java.lang.String> c = new java.util.HashMap();
        private com.qq.gdt.action.d.b.h d;
        private int e;
        private int f;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void b(java.lang.String str, java.lang.String str2) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("name == null");
            }
            if (str.isEmpty()) {
                throw new java.lang.IllegalArgumentException("name is empty");
            }
            int length = str.length();
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                if (cCharAt <= 31 || cCharAt >= 127) {
                    throw new java.lang.IllegalArgumentException(com.qq.gdt.action.d.b.k.a("Unexpected char %#04x at %d in header name: %s", java.lang.Integer.valueOf(cCharAt), java.lang.Integer.valueOf(i), str));
                }
            }
            if (str2 == null) {
                throw new java.lang.IllegalArgumentException("value == null");
            }
            int length2 = str2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                char cCharAt2 = str2.charAt(i2);
                if (cCharAt2 <= 31 || cCharAt2 >= 127) {
                    throw new java.lang.IllegalArgumentException(com.qq.gdt.action.d.b.k.a("Unexpected char %#04x at %d in %s value: %s", java.lang.Integer.valueOf(cCharAt2), java.lang.Integer.valueOf(i2), str, str2));
                }
            }
        }

        public com.qq.gdt.action.d.b.g.a a(com.qq.gdt.action.d.b.h hVar) {
            return a(com.tencent.connect.common.Constants.HTTP_POST, hVar);
        }

        public com.qq.gdt.action.d.b.g.a a(java.lang.String str) {
            if (str == null) {
                throw new java.lang.IllegalArgumentException("url == null");
            }
            this.f95a = str;
            return this;
        }

        public com.qq.gdt.action.d.b.g.a a(java.lang.String str, com.qq.gdt.action.d.b.h hVar) {
            this.b = str;
            this.d = hVar;
            return this;
        }

        public com.qq.gdt.action.d.b.g.a a(java.lang.String str, java.lang.String str2) {
            b(str, str2);
            this.c.put(str, str2);
            return this;
        }

        public com.qq.gdt.action.d.b.g a() {
            if (this.f95a != null) {
                return new com.qq.gdt.action.d.b.g(this);
            }
            throw new java.lang.IllegalStateException("url == null");
        }
    }

    g(com.qq.gdt.action.d.b.g.a aVar) {
        this.f94a = aVar.f95a;
        this.b = aVar.b;
        this.c = aVar.c;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = aVar.f;
    }

    public java.lang.String a() {
        return this.f94a;
    }

    public int b() {
        return this.e;
    }

    public int c() {
        return this.f;
    }

    public java.util.Map<java.lang.String, java.lang.String> d() {
        return this.c;
    }

    public java.lang.String e() {
        return this.b;
    }

    public com.qq.gdt.action.d.b.h f() {
        return this.d;
    }
}
