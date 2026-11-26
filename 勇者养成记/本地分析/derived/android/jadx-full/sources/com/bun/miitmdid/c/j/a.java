package com.bun.miitmdid.c.j;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class a implements com.bun.supplier.InnerIdSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private java.lang.String f38a = "";

    @android.support.annotation.Keep
    private android.content.Context b;

    /* JADX INFO: renamed from: com.bun.miitmdid.c.j.a$a, reason: collision with other inner class name */
    @android.support.annotation.Keep
    class RunnableC0008a implements java.lang.Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @android.support.annotation.Keep
        final /* synthetic */ com.bun.supplier.SupplierListener f39a;

        @android.support.annotation.Keep
        RunnableC0008a(com.bun.supplier.SupplierListener supplierListener) {
            this.f39a = supplierListener;
        }

        @Override // java.lang.Runnable
        @android.support.annotation.Keep
        public native void run();
    }

    @android.support.annotation.Keep
    public a(android.content.Context context) {
        this.b = context;
    }

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    @android.support.annotation.Keep
    public native void a(java.lang.String str);

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
