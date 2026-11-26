package com.tencent.ydkqmsp.sdk.g.c;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements com.tencent.ydkqmsp.sdk.base.b, com.tencent.ydkqmsp.sdk.g.c.c.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkqmsp.sdk.g.c.c f1360a;
    private com.tencent.ydkqmsp.sdk.base.IVendorCallback b;

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        java.lang.String strA;
        return (e() && (strA = this.f1360a.a()) != null) ? strA : "";
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.b = iVendorCallback;
        this.f1360a = new com.tencent.ydkqmsp.sdk.g.c.c(context, this);
    }

    @Override // com.tencent.ydkqmsp.sdk.g.c.c.b
    public void a(com.tencent.ydkqmsp.sdk.g.c.c cVar) {
        try {
            if (this.b != null) {
                this.b.onResult(e(), b(), a());
            }
        } catch (java.lang.Exception unused) {
            com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = this.b;
            if (iVendorCallback != null) {
                iVendorCallback.onResult(false, null, null);
            }
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        java.lang.String strC;
        return (e() && (strC = this.f1360a.c()) != null) ? strC : "";
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean e() {
        com.tencent.ydkqmsp.sdk.g.c.c cVar = this.f1360a;
        if (cVar != null) {
            return cVar.b();
        }
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
        com.tencent.ydkqmsp.sdk.g.c.c cVar = this.f1360a;
        if (cVar != null) {
            cVar.d();
        }
    }
}
