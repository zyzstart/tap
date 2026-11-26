package com.tencent.ydkqmsp.sdk.g.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c implements com.tencent.ydkqmsp.sdk.base.b, com.tencent.ydkqmsp.sdk.g.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.ydkqmsp.sdk.base.IVendorCallback f1351a;
    private com.tencent.ydkqmsp.sdk.g.a.d d;
    private java.lang.String b = "";
    private java.lang.String c = "";
    private boolean e = false;
    private boolean f = false;

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        return this.b;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.f1351a = iVendorCallback;
        com.tencent.ydkqmsp.sdk.g.a.d dVar = new com.tencent.ydkqmsp.sdk.g.a.d(context);
        this.d = dVar;
        dVar.a(this);
    }

    @Override // com.tencent.ydkqmsp.sdk.g.a.b
    public void a(com.tencent.ydkqmsp.sdk.g.a.a aVar) {
        try {
            java.lang.String strC = aVar.c();
            this.b = strC;
            if (strC == null) {
                this.b = "";
            }
        } catch (java.lang.Exception unused) {
        }
        try {
            java.lang.String strH = aVar.h();
            this.c = strH;
            if (strH == null) {
                this.c = "";
            }
        } catch (java.lang.Exception unused2) {
        }
        try {
            this.f = aVar.g();
        } catch (java.lang.Exception unused3) {
        }
        this.e = true;
        com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = this.f1351a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(this.f, this.c, this.b);
        }
    }

    @Override // android.os.IInterface
    public android.os.IBinder asBinder() {
        return null;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        return this.c;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void c() {
        this.d.a(this);
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean d() {
        return false;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean e() {
        return this.f;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
        com.tencent.ydkqmsp.sdk.g.a.d dVar;
        if (!this.e || (dVar = this.d) == null) {
            return;
        }
        dVar.a();
    }

    @Override // com.tencent.ydkqmsp.sdk.g.a.b
    public void g() {
        com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback = this.f1351a;
        if (iVendorCallback != null) {
            iVendorCallback.onResult(false, null, null);
        }
    }
}
