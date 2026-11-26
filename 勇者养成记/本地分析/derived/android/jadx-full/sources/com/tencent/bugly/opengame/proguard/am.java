package com.tencent.bugly.opengame.proguard;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class am extends com.tencent.bugly.opengame.proguard.k implements java.lang.Cloneable {
    private static byte[] d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private byte f382a;
    private java.lang.String b;
    private byte[] c;

    public am() {
        this.f382a = (byte) 0;
        this.b = "";
        this.c = null;
    }

    public am(byte b, java.lang.String str, byte[] bArr) {
        this.f382a = (byte) 0;
        this.b = "";
        this.c = null;
        this.f382a = b;
        this.b = str;
        this.c = bArr;
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.i iVar) {
        this.f382a = iVar.a(this.f382a, 0, true);
        this.b = iVar.b(1, true);
        if (d == null) {
            d = new byte[]{0};
        }
        this.c = iVar.c(2, false);
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(com.tencent.bugly.opengame.proguard.j jVar) {
        jVar.a(this.f382a, 0);
        jVar.a(this.b, 1);
        byte[] bArr = this.c;
        if (bArr != null) {
            jVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.opengame.proguard.k
    public final void a(java.lang.StringBuilder sb, int i) {
    }
}
