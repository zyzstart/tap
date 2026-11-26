package com.tencent.hlyyb.common.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e implements com.tencent.hlyyb.common.d.b, com.tencent.hlyyb.common.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static com.tencent.hlyyb.common.d.e f586a = new com.tencent.hlyyb.common.d.e();
    private com.tencent.hlyyb.common.d.c b;
    private com.tencent.hlyyb.common.d.b c;
    private boolean d = false;

    private e() {
    }

    public static com.tencent.hlyyb.common.d.e d() {
        return f586a;
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a() {
        this.b.a();
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a(int i) {
        this.b.a(i);
    }

    @Override // com.tencent.hlyyb.common.d.c
    public final void a(com.tencent.hlyyb.common.d.b bVar) {
        this.c = bVar;
    }

    @Override // com.tencent.hlyyb.common.d.b
    public final void a(java.lang.String str, java.lang.String str2) {
        this.c.a(str, str2);
    }

    @Override // com.tencent.hlyyb.common.d.b
    public final void a(java.lang.String str, byte[] bArr, java.lang.String str2) {
        this.c.a(str, bArr, str2);
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void a(boolean z) {
        this.b.a(z);
    }

    @Override // com.tencent.hlyyb.common.d.a
    public final void b() {
        this.b.b();
    }

    @Override // com.tencent.hlyyb.common.d.b
    public final void c() {
        this.c.c();
    }

    @Override // com.tencent.hlyyb.common.d.c
    public final synchronized void e() {
        if (this.d) {
            return;
        }
        com.tencent.hlyyb.common.d.b.b.c cVarC = com.tencent.hlyyb.common.d.b.b.c.c();
        this.b = cVarC;
        if (cVarC != null) {
            cVarC.a(this);
            this.b.e();
        }
        this.d = true;
    }
}
