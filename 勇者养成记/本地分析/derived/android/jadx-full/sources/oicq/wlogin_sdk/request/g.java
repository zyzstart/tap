package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g extends java.util.TimerTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ android.widget.Toast f1681a;
    final /* synthetic */ int b;
    final /* synthetic */ oicq.wlogin_sdk.request.f c;

    g(oicq.wlogin_sdk.request.f fVar, android.widget.Toast toast, int i) {
        this.c = fVar;
        this.f1681a = toast;
        this.b = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        this.c.a(this.f1681a, this.b + 1);
    }
}
