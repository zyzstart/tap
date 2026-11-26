package com.bun.supplier;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public interface InnerIdSupplier extends com.bun.supplier.IdSupplier {
    @android.support.annotation.Keep
    void a(com.bun.supplier.SupplierListener supplierListener);

    @android.support.annotation.Keep
    boolean a();

    @android.support.annotation.Keep
    java.lang.String getUDID();

    @android.support.annotation.Keep
    void shutDown();
}
