package com.bun.supplier;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class a implements com.bun.supplier.InnerIdSupplier {
    @android.support.annotation.Keep
    public a() {
    }

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native boolean a();

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
