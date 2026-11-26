package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d extends com.tencent.bugly.opengame.proguard.c {
    private static java.util.HashMap f;
    private static java.util.HashMap g;
    private com.tencent.bugly.opengame.proguard.f e;

    public d() {
        com.tencent.bugly.opengame.proguard.f fVar = new com.tencent.bugly.opengame.proguard.f();
        this.e = fVar;
        fVar.f392a = (short) 2;
    }

    @Override // com.tencent.bugly.opengame.proguard.c, com.tencent.bugly.opengame.proguard.a
    public final void a(java.lang.String str, java.lang.Object obj) {
        if (!str.startsWith(".")) {
            super.a(str, obj);
        } else {
            throw new java.lang.IllegalArgumentException("put name can not startwith . , now is " + str);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.c, com.tencent.bugly.opengame.proguard.a
    public final void a(byte[] bArr) {
        if (bArr.length < 4) {
            throw new java.lang.IllegalArgumentException("decode package must include size head");
        }
        try {
            com.tencent.bugly.opengame.proguard.i iVar = new com.tencent.bugly.opengame.proguard.i(bArr, 4);
            iVar.a(this.b);
            this.e.a(iVar);
            if (this.e.f392a == 3) {
                com.tencent.bugly.opengame.proguard.i iVar2 = new com.tencent.bugly.opengame.proguard.i(this.e.e);
                iVar2.a(this.b);
                if (f == null) {
                    java.util.HashMap map = new java.util.HashMap();
                    f = map;
                    map.put("", new byte[0]);
                }
                ((com.tencent.bugly.opengame.proguard.c) this).d = iVar2.a((java.util.Map) f, 0, false);
                return;
            }
            com.tencent.bugly.opengame.proguard.i iVar3 = new com.tencent.bugly.opengame.proguard.i(this.e.e);
            iVar3.a(this.b);
            if (g == null) {
                g = new java.util.HashMap();
                java.util.HashMap map2 = new java.util.HashMap();
                map2.put("", new byte[0]);
                g.put("", map2);
            }
            this.f374a = iVar3.a((java.util.Map) g, 0, false);
            new java.util.HashMap();
        } catch (java.lang.Exception e) {
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.c, com.tencent.bugly.opengame.proguard.a
    public final byte[] a() {
        com.tencent.bugly.opengame.proguard.f fVar = this.e;
        if (fVar.f392a != 2) {
            if (fVar.c == null) {
                fVar.c = "";
            }
            com.tencent.bugly.opengame.proguard.f fVar2 = this.e;
            if (fVar2.d == null) {
                fVar2.d = "";
            }
        } else {
            if (fVar.c.equals("")) {
                throw new java.lang.IllegalArgumentException("servantName can not is null");
            }
            if (this.e.d.equals("")) {
                throw new java.lang.IllegalArgumentException("funcName can not is null");
            }
        }
        com.tencent.bugly.opengame.proguard.j jVar = new com.tencent.bugly.opengame.proguard.j(0);
        jVar.a(this.b);
        jVar.a((java.util.Map) (this.e.f392a == 2 ? this.f374a : ((com.tencent.bugly.opengame.proguard.c) this).d), 0);
        this.e.e = com.tencent.bugly.opengame.proguard.l.a(jVar.a());
        com.tencent.bugly.opengame.proguard.j jVar2 = new com.tencent.bugly.opengame.proguard.j(0);
        jVar2.a(this.b);
        this.e.a(jVar2);
        byte[] bArrA = com.tencent.bugly.opengame.proguard.l.a(jVar2.a());
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

    @Override // com.tencent.bugly.opengame.proguard.c
    public final void c() {
        super.c();
        this.e.f392a = (short) 3;
    }

    public final void c(java.lang.String str) {
        this.e.d = str;
    }
}
