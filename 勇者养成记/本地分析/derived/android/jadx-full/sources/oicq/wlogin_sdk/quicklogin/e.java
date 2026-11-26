package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e implements android.content.DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.webkit.SslErrorHandler f1672a;
    final /* synthetic */ oicq.wlogin_sdk.quicklogin.c b;

    e(oicq.wlogin_sdk.quicklogin.c cVar, android.webkit.SslErrorHandler sslErrorHandler) {
        this.b = cVar;
        this.f1672a = sslErrorHandler;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(android.content.DialogInterface dialogInterface, int i) {
        this.f1672a.cancel();
    }
}
