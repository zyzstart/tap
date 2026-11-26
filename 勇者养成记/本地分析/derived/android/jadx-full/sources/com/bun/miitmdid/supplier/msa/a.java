package com.bun.miitmdid.supplier.msa;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class a extends android.os.AsyncTask<java.lang.Void, java.lang.Void, java.lang.Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    public com.bun.lib.c f48a;

    @android.support.annotation.Keep
    public com.bun.miitmdid.c.e.a b;

    @android.support.annotation.Keep
    public a(com.bun.lib.c cVar, com.bun.miitmdid.c.e.a aVar) {
        this.f48a = cVar;
        this.b = aVar;
    }

    @android.support.annotation.Keep
    protected native java.lang.Boolean a(java.lang.Void... voidArr);

    @android.support.annotation.Keep
    protected native void a(java.lang.Boolean bool);

    @Override // android.os.AsyncTask
    @android.support.annotation.Keep
    protected native /* bridge */ /* synthetic */ java.lang.Boolean doInBackground(java.lang.Void[] voidArr);

    @Override // android.os.AsyncTask
    @android.support.annotation.Keep
    protected native /* bridge */ /* synthetic */ void onPostExecute(java.lang.Boolean bool);
}
