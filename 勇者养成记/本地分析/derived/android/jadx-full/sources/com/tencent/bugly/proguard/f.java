package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f extends com.tencent.bugly.proguard.k {
    public byte[] e;
    private java.util.Map<java.lang.String, java.lang.String> i;
    private java.util.Map<java.lang.String, java.lang.String> j;
    private static /* synthetic */ boolean m = !com.tencent.bugly.proguard.f.class.desiredAssertionStatus();
    private static byte[] k = null;
    private static java.util.Map<java.lang.String, java.lang.String> l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f434a = 0;
    private byte f = 0;
    private int g = 0;
    public int b = 0;
    public java.lang.String c = null;
    public java.lang.String d = null;
    private int h = 0;

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.i iVar) {
        try {
            this.f434a = iVar.a(this.f434a, 1, true);
            this.f = iVar.a(this.f, 2, true);
            this.g = iVar.a(this.g, 3, true);
            this.b = iVar.a(this.b, 4, true);
            this.c = iVar.b(5, true);
            this.d = iVar.b(6, true);
            if (k == null) {
                k = new byte[]{0};
            }
            byte[] bArr = k;
            this.e = iVar.c(7, true);
            this.h = iVar.a(this.h, 8, true);
            if (l == null) {
                java.util.HashMap map = new java.util.HashMap();
                l = map;
                map.put("", "");
            }
            this.i = (java.util.Map) iVar.a(l, 9, true);
            if (l == null) {
                java.util.HashMap map2 = new java.util.HashMap();
                l = map2;
                map2.put("", "");
            }
            this.j = (java.util.Map) iVar.a(l, 10, true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("RequestPacket decode error " + com.tencent.bugly.proguard.e.a(this.e));
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(com.tencent.bugly.proguard.j jVar) {
        jVar.a(this.f434a, 1);
        jVar.a(this.f, 2);
        jVar.a(this.g, 3);
        jVar.a(this.b, 4);
        jVar.a(this.c, 5);
        jVar.a(this.d, 6);
        jVar.a(this.e, 7);
        jVar.a(this.h, 8);
        jVar.a((java.util.Map) this.i, 9);
        jVar.a((java.util.Map) this.j, 10);
    }

    @Override // com.tencent.bugly.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
        com.tencent.bugly.proguard.h hVar = new com.tencent.bugly.proguard.h(sb, i);
        hVar.a(this.f434a, "iVersion");
        hVar.a(this.f, "cPacketType");
        hVar.a(this.g, "iMessageType");
        hVar.a(this.b, "iRequestId");
        hVar.a(this.c, "sServantName");
        hVar.a(this.d, "sFuncName");
        hVar.a(this.e, "sBuffer");
        hVar.a(this.h, "iTimeout");
        hVar.a((java.util.Map) this.i, "context");
        hVar.a((java.util.Map) this.j, "status");
    }

    public final java.lang.Object clone() {
        try {
            return super.clone();
        } catch (java.lang.CloneNotSupportedException unused) {
            if (m) {
                return null;
            }
            throw new java.lang.AssertionError();
        }
    }

    public final boolean equals(java.lang.Object obj) {
        com.tencent.bugly.proguard.f fVar = (com.tencent.bugly.proguard.f) obj;
        return com.tencent.bugly.proguard.l.a(1, (int) fVar.f434a) && com.tencent.bugly.proguard.l.a(1, (int) fVar.f) && com.tencent.bugly.proguard.l.a(1, fVar.g) && com.tencent.bugly.proguard.l.a(1, fVar.b) && com.tencent.bugly.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.c) && com.tencent.bugly.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.d) && com.tencent.bugly.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.e) && com.tencent.bugly.proguard.l.a(1, fVar.h) && com.tencent.bugly.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.i) && com.tencent.bugly.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.j);
    }
}
