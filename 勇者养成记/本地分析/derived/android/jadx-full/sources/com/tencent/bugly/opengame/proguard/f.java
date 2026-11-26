package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f extends com.tencent.bugly.opengame.proguard.k {
    public byte[] e;
    private java.util.Map i;
    private java.util.Map j;
    private static /* synthetic */ boolean m = !com.tencent.bugly.opengame.proguard.f.class.desiredAssertionStatus();
    private static byte[] k = null;
    private static java.util.Map l = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public short f392a = 0;
    private byte f = 0;
    private int g = 0;
    public int b = 0;
    public java.lang.String c = null;
    public java.lang.String d = null;
    private int h = 0;

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        try {
            this.f392a = iVar.a(this.f392a, 1, true);
            this.f = iVar.a(this.f, 2, true);
            this.g = iVar.a(this.g, 3, true);
            this.b = iVar.a(this.b, 4, true);
            this.c = iVar.b(5, true);
            this.d = iVar.b(6, true);
            if (k == null) {
                k = new byte[]{0};
            }
            this.e = iVar.c(7, true);
            this.h = iVar.a(this.h, 8, true);
            if (l == null) {
                java.util.HashMap map = new java.util.HashMap();
                l = map;
                map.put("", "");
            }
            this.i = (java.util.Map) iVar.a((java.lang.Object) l, 9, true);
            if (l == null) {
                java.util.HashMap map2 = new java.util.HashMap();
                l = map2;
                map2.put("", "");
            }
            this.j = (java.util.Map) iVar.a((java.lang.Object) l, 10, true);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            java.lang.System.out.println("RequestPacket decode error " + com.tencent.bugly.opengame.proguard.e.a(this.e));
            throw new java.lang.RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f392a, 1);
        jVar.a(this.f, 2);
        jVar.a(this.g, 3);
        jVar.a(this.b, 4);
        jVar.a(this.c, 5);
        jVar.a(this.d, 6);
        jVar.a(this.e, 7);
        jVar.a(this.h, 8);
        jVar.a(this.i, 9);
        jVar.a(this.j, 10);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
        com.tencent.bugly.opengame.proguard.h hVar = new com.tencent.bugly.opengame.proguard.h(sb, i);
        hVar.a(this.f392a, "iVersion");
        hVar.a(this.f, "cPacketType");
        hVar.a(this.g, "iMessageType");
        hVar.a(this.b, "iRequestId");
        hVar.a(this.c, "sServantName");
        hVar.a(this.d, "sFuncName");
        hVar.a(this.e, "sBuffer");
        hVar.a(this.h, "iTimeout");
        hVar.a(this.i, "context");
        hVar.a(this.j, "status");
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
        com.tencent.bugly.opengame.proguard.f fVar = (com.tencent.bugly.opengame.proguard.f) obj;
        return com.tencent.bugly.opengame.proguard.l.a(1, (int) fVar.f392a) && com.tencent.bugly.opengame.proguard.l.a(1, (int) fVar.f) && com.tencent.bugly.opengame.proguard.l.a(1, fVar.g) && com.tencent.bugly.opengame.proguard.l.a(1, fVar.b) && com.tencent.bugly.opengame.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.c) && com.tencent.bugly.opengame.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.d) && com.tencent.bugly.opengame.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.e) && com.tencent.bugly.opengame.proguard.l.a(1, fVar.h) && com.tencent.bugly.opengame.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.i) && com.tencent.bugly.opengame.proguard.l.a((java.lang.Object) 1, (java.lang.Object) fVar.j);
    }
}
