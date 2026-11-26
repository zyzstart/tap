package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class ci extends android.os.AsyncTask<java.lang.Object, java.lang.Object, java.lang.Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.unisound.sdk.ch f1551a;
    final /* synthetic */ com.unisound.sdk.cg b;

    public ci(com.unisound.sdk.cg cgVar, com.unisound.sdk.ch chVar) {
        this.b = cgVar;
        this.f1551a = chVar;
    }

    public void a() {
        this.f1551a = null;
    }

    @Override // android.os.AsyncTask
    protected java.lang.Object doInBackground(java.lang.Object... objArr) {
        com.unisound.common.y.b("USCAsyncTask doInBackground: ", objArr[0]);
        return this.f1551a.a(objArr);
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(java.lang.Object obj) {
        super.onPostExecute(obj);
        this.b.d = false;
        this.f1551a.a(obj);
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        this.b.d = true;
        super.onPreExecute();
    }
}
