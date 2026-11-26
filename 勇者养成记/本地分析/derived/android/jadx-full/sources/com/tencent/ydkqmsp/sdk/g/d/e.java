package com.tencent.ydkqmsp.sdk.g.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e implements com.tencent.ydkqmsp.sdk.base.b, com.tencent.ydkqmsp.sdk.g.d.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkqmsp.sdk.g.d.b f1367a;
    private android.content.Context b;
    private com.tencent.ydkqmsp.sdk.base.IVendorCallback c;

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        java.lang.String strB;
        return (!e() || (strB = this.f1367a.b()) == null) ? "" : strB;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        if (com.tencent.ydkqmsp.sdk.g.d.b.a(context)) {
            java.lang.String strA = com.tencent.ydkqmsp.sdk.base.f.a(context);
            if (!android.text.TextUtils.isEmpty(strA)) {
                com.tencent.ydkqmsp.sdk.g.d.b.a(context, strA);
            }
            this.f1367a = new com.tencent.ydkqmsp.sdk.g.d.b(context, this);
            this.c = iVendorCallback;
            this.b = context;
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.g.d.c
    public void a(boolean z) {
        com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = this.c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(e(), b(), a());
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        java.lang.String strA;
        return (!e() || (strA = this.f1367a.a()) == null) ? "" : strA;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void c() {
        com.tencent.ydkqmsp.sdk.g.d.b bVar = this.f1367a;
        if (bVar != null) {
            bVar.a(com.tencent.ydkqmsp.sdk.base.f.a(this.b));
        } else {
            g();
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean e() {
        com.tencent.ydkqmsp.sdk.g.d.b bVar = this.f1367a;
        if (bVar != null) {
            return bVar.c();
        }
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
        com.tencent.ydkqmsp.sdk.g.d.b bVar = this.f1367a;
        if (bVar != null) {
            bVar.d();
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.g.d.c
    public void g() {
        com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = this.c;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, "", "");
        }
    }
}
