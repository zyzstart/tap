package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class d implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.webkit.SslErrorHandler f1671a;
    final /* synthetic */ oicq.wlogin_sdk.quicklogin.c b;

    d(oicq.wlogin_sdk.quicklogin.c cVar, android.webkit.SslErrorHandler sslErrorHandler) {
        this.b = cVar;
        this.f1671a = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.sslErrorProcessed = true;
        this.f1671a.proceed();
    }
}
