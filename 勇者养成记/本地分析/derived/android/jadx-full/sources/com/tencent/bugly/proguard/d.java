package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d extends com.tencent.bugly.proguard.c {
    private static java.util.HashMap<java.lang.String, byte[]> f;
    private static java.util.HashMap<java.lang.String, java.util.HashMap<java.lang.String, byte[]>> g;
    private com.tencent.bugly.proguard.f e = new com.tencent.bugly.proguard.f();

    public d() {
        this.e.f434a = (short) 2;
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final <T> void a(java.lang.String str, T t) {
        if (!str.startsWith(".")) {
            super.a(str, t);
        } else {
            throw new java.lang.IllegalArgumentException("put name can not startwith . , now is " + str);
        }
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new java.lang.IllegalArgumentException("decode package must include size head");
        }
        try {
            com.tencent.bugly.proguard.i iVar = new com.tencent.bugly.proguard.i(bArr, 4);
            iVar.a(this.b);
            this.e.a(iVar);
            if (this.e.f434a == 3) {
                com.tencent.bugly.proguard.i iVar2 = new com.tencent.bugly.proguard.i(this.e.e);
                iVar2.a(this.b);
                if (f == null) {
                    java.util.HashMap<java.lang.String, byte[]> map = new java.util.HashMap<>();
                    f = map;
                    map.put("", new byte[0]);
                }
                this.d = iVar2.a((java.util.Map) f, 0, false);
                return;
            }
            com.tencent.bugly.proguard.i iVar3 = new com.tencent.bugly.proguard.i(this.e.e);
            iVar3.a(this.b);
            if (g == null) {
                g = new java.util.HashMap<>();
                java.util.HashMap<java.lang.String, byte[]> map2 = new java.util.HashMap<>();
                map2.put("", new byte[0]);
                g.put("", map2);
            }
            this.f416a = iVar3.a((java.util.Map) g, 0, false);
            new java.util.HashMap();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.proguard.c, com.tencent.bugly.proguard.a
    public final byte[] a() {
        if (this.e.f434a != 2) {
            if (this.e.c == null) {
                this.e.c = "";
            }
            if (this.e.d == null) {
                this.e.d = "";
            }
        } else {
            if (this.e.c.equals("")) {
                throw new java.lang.IllegalArgumentException("servantName can not is null");
            }
            if (this.e.d.equals("")) {
                throw new java.lang.IllegalArgumentException("funcName can not is null");
            }
        }
        com.tencent.bugly.proguard.j jVar = new com.tencent.bugly.proguard.j(0);
        jVar.a(this.b);
        if (this.e.f434a == 2) {
            jVar.a((java.util.Map) this.f416a, 0);
        } else {
            jVar.a((java.util.Map) this.d, 0);
        }
        this.e.e = com.tencent.bugly.proguard.l.a(jVar.a());
        com.tencent.bugly.proguard.j jVar2 = new com.tencent.bugly.proguard.j(0);
        jVar2.a(this.b);
        this.e.a(jVar2);
        byte[] bArrA = com.tencent.bugly.proguard.l.a(jVar2.a());
        int length = bArrA.length + 4;
        java.nio.ByteBuffer byteBufferAllocate = java.nio.ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length).put(bArrA).flip();
        return byteBufferAllocate.array();
    }

    public final void b(int i) {
        this.e.b = 1;
    }

    public final void b(java.lang.String str) {
        this.e.c = str;
    }

    @Override // com.tencent.bugly.proguard.c
    public final void c() {
        super.c();
        this.e.f434a = (short) 3;
    }

    public final void c(java.lang.String str) {
        this.e.d = str;
    }
}
