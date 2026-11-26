package com.tencent.ydkqmsp.sdk.g.f;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.ydkqmsp.sdk.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1372a;

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        return com.tencent.ydkqmsp.sdk.g.f.b.b(this.f1372a);
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.f1372a = context;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        android.content.Context context = this.f1372a;
        return com.tencent.ydkqmsp.sdk.g.f.b.a(context, com.tencent.ydkqmsp.sdk.base.f.a(context));
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean d() {
        return true;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean e() {
        return com.tencent.ydkqmsp.sdk.g.f.b.a(this.f1372a);
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
    }
}
