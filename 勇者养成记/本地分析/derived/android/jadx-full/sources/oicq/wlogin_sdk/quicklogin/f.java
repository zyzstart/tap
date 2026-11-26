package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class f implements android.content.DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.webkit.SslErrorHandler f1673a;
    final /* synthetic */ oicq.wlogin_sdk.quicklogin.c b;

    f(oicq.wlogin_sdk.quicklogin.c cVar, android.webkit.SslErrorHandler sslErrorHandler) {
        this.b = cVar;
        this.f1673a = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(android.content.DialogInterface dialogInterface) {
        this.f1673a.cancel();
    }
}
