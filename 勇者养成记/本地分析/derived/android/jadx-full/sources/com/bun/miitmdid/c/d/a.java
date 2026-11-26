package com.bun.miitmdid.c.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class a implements com.bun.supplier.InnerIdSupplier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private android.content.Context f27a;

    @android.support.annotation.Keep
    private com.bun.supplier.SupplierListener f;

    @android.support.annotation.Keep
    private boolean e = false;

    @android.support.annotation.Keep
    private java.lang.String b = "";

    @android.support.annotation.Keep
    private java.lang.String c = "";

    @android.support.annotation.Keep
    private java.lang.String d = "";

    /* JADX INFO: renamed from: com.bun.miitmdid.c.d.a$a, reason: collision with other inner class name */
    @android.support.annotation.Keep
    class RunnableC0005a implements java.lang.Runnable {
        @android.support.annotation.Keep
        RunnableC0005a() {
        }

        @Override // java.lang.Runnable
        @android.support.annotation.Keep
        public native void run();
    }

    @android.support.annotation.Keep
    public a(android.content.Context context) {
        this.f27a = context;
    }

    @android.support.annotation.Keep
    static native /* synthetic */ android.content.Context a(com.bun.miitmdid.c.d.a aVar);

    @android.support.annotation.Keep
    static native /* synthetic */ java.lang.String a(com.bun.miitmdid.c.d.a aVar, java.lang.String str);

    @android.support.annotation.Keep
    private native void b();

    @android.support.annotation.Keep
    static native /* synthetic */ void b(com.bun.miitmdid.c.d.a aVar);

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
