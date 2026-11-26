package com.bun.miitmdid.c.g;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class b implements com.bun.supplier.InnerIdSupplier, com.bun.miitmdid.c.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private com.bun.miitmdid.c.g.a f32a;

    @android.support.annotation.Keep
    private com.bun.supplier.SupplierListener b;

    @android.support.annotation.Keep
    public b(android.content.Context context, com.bun.supplier.SupplierListener supplierListener) {
        this.b = supplierListener;
        this.f32a = new com.bun.miitmdid.c.g.a(context, this);
    }

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    @Override // com.bun.miitmdid.c.e.a
    @android.support.annotation.Keep
    public native void a(boolean z);

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native boolean a();

    @Override // com.bun.miitmdid.c.e.a
    @android.support.annotation.Keep
    public native void b();

    @Override // com.bun.supplier.IdSupplier
    @android.support.annotation.Keep
    public native java.lang.String getAAID();

    @Override // com.bun.supplier.IdSupplier
    @android.support.annotation.Keep
    public native java.lang.String getOAID();

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native java.lang.String getUDID();

    @Override // com.bun.supplier.IdSupplier
    @android.support.annotation.Keep
    public native java.lang.String getVAID();

    @Override // com.bun.supplier.IdSupplier
    @android.support.annotation.Keep
    public native boolean isSupported();

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native void shutDown();
}
