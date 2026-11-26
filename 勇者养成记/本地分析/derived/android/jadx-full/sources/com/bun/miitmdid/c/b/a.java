package com.bun.miitmdid.c.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class a implements com.bun.supplier.InnerIdSupplier, com.asus.msa.sdid.IDIDBinderStatusListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private com.bun.supplier.SupplierListener f26a;

    @android.support.annotation.Keep
    private com.asus.msa.sdid.SupplementaryDIDManager f;

    @android.support.annotation.Keep
    private java.lang.String b = "";

    @android.support.annotation.Keep
    private java.lang.String c = "";

    @android.support.annotation.Keep
    private java.lang.String d = "";

    @android.support.annotation.Keep
    private java.lang.String e = "";

    @android.support.annotation.Keep
    private boolean g = false;

    @android.support.annotation.Keep
    private boolean h = false;

    @android.support.annotation.Keep
    public a(android.content.Context context, com.bun.supplier.SupplierListener supplierListener) {
        this.f26a = supplierListener;
        this.f = new com.asus.msa.sdid.SupplementaryDIDManager(context);
    }

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
    @android.support.annotation.Keep
    public native void a(com.asus.msa.SupplementaryDID.IDidAidlInterface iDidAidlInterface);

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native void a(com.bun.supplier.SupplierListener supplierListener);

    @Override // com.bun.supplier.InnerIdSupplier
    @android.support.annotation.Keep
    public native boolean a();

    @Override // android.os.IInterface
    @android.support.annotation.Keep
    public native android.os.IBinder asBinder();

    @Override // com.asus.msa.sdid.IDIDBinderStatusListener
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
