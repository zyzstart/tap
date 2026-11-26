package com.tencent.ydkqmsp.sdk.g.h;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.ydkqmsp.sdk.base.b, com.tencent.ydkqmsp.sdk.g.h.b.InterfaceC0063b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tencent.ydkqmsp.sdk.base.IVendorCallback f1383a;
    private com.tencent.ydkqmsp.sdk.g.h.b b;

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        java.lang.String strB;
        return (e() && (strB = this.b.b()) != null) ? strB : "";
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.f1383a = iVendorCallback;
        com.tencent.ydkqmsp.sdk.g.h.b bVar = new com.tencent.ydkqmsp.sdk.g.h.b(context, this);
        this.b = bVar;
        bVar.c();
    }

    @Override // com.tencent.ydkqmsp.sdk.g.h.b.InterfaceC0063b
    public void a(com.tencent.ydkqmsp.sdk.g.h.b bVar) {
        com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = this.f1383a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), b(), a());
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        java.lang.String strA;
        return (e() && (strA = this.b.a()) != null) ? strA : "";
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
        com.tencent.ydkqmsp.sdk.g.h.b bVar = this.b;
        if (bVar != null) {
            return bVar.d();
        }
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
        com.tencent.ydkqmsp.sdk.g.h.b bVar = this.b;
        if (bVar != null) {
            bVar.e();
        }
    }
}
