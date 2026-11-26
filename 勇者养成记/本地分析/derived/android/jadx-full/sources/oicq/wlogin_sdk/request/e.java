package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.lang.Runnable f1679a = new oicq.wlogin_sdk.request.f(this);
    private android.content.Context b;
    private oicq.wlogin_sdk.tools.ErrMsg c;

    public e(android.content.Context context, oicq.wlogin_sdk.tools.ErrMsg errMsg) {
        this.b = context;
        a(errMsg);
    }

    public void a(oicq.wlogin_sdk.tools.ErrMsg errMsg) {
        if (errMsg != null) {
            try {
                this.c = (oicq.wlogin_sdk.tools.ErrMsg) errMsg.clone();
                return;
            } catch (java.lang.CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        this.c = null;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        new android.os.Handler(android.os.Looper.getMainLooper()).post(this.f1679a);
    }
}
