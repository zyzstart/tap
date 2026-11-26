package oicq.wlogin_sdk.quicklogin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class a implements android.view.View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.app.Activity f1668a;

    a(android.app.Activity activity) {
        this.f1668a = activity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(android.view.View view) {
        oicq.wlogin_sdk.tools.util.LOGI("close button clicked", "");
        this.f1668a.finish();
        if (oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimEnter == 0 && oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimExit == 0) {
            return;
        }
        this.f1668a.overridePendingTransition(oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimEnter, oicq.wlogin_sdk.quicklogin.QuickLoginWebViewLoader.finishAnimExit);
    }
}
