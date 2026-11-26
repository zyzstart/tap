package com.bun.miitmdid.supplier.msa;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class b implements com.bun.supplier.InnerIdSupplier, com.bun.miitmdid.c.e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    public com.bun.supplier.SupplierListener f49a;

    @android.support.annotation.Keep
    private com.bun.miitmdid.supplier.msa.MsaClient b;

    @android.support.annotation.Keep
    public b(android.content.Context context) {
        if (com.bun.miitmdid.supplier.msa.MsaClient.CheckService(context)) {
            java.lang.String strG = com.bun.lib.sysParamters.g();
            if (!android.text.TextUtils.isEmpty(strG)) {
                com.bun.miitmdid.supplier.msa.MsaClient.StartMsaKlService(context, strG);
            }
            this.b = new com.bun.miitmdid.supplier.msa.MsaClient(context, this);
        }
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
