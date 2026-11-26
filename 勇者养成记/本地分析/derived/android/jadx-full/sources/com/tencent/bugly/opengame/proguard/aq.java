package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class aq extends com.tencent.bugly.opengame.proguard.k {
    private static byte[] i = {0};
    private static java.util.Map j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte f386a = 0;
    public int b = 0;
    public byte[] c = null;
    public java.lang.String d = "";
    public long e = 0;
    private java.lang.String h = "";
    public java.lang.String f = "";
    public java.util.Map g = null;

    static {
        java.util.HashMap map = new java.util.HashMap();
        j = map;
        map.put("", "");
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f386a = iVar.a(this.f386a, 0, true);
        this.b = iVar.a(this.b, 1, true);
        this.c = iVar.c(2, false);
        this.d = iVar.b(3, false);
        this.e = iVar.a(this.e, 4, false);
        this.h = iVar.b(5, false);
        this.f = iVar.b(6, false);
        this.g = (java.util.Map) iVar.a((java.lang.Object) j, 7, false);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f386a, 0);
        jVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
        java.lang.String str = this.d;
        if (str != null) {
            jVar.a(str, 3);
        }
        jVar.a(this.e, 4);
        java.lang.String str2 = this.h;
        if (str2 != null) {
            jVar.a(str2, 5);
        }
        java.lang.String str3 = this.f;
        if (str3 != null) {
            jVar.a(str3, 6);
        }
        java.util.Map map = this.g;
        if (map != null) {
            jVar.a(map, 7);
        }
    }
}
