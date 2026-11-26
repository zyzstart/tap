package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class h extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1682a;

    public h(android.content.Context context) {
        this.f1682a = context;
        setName("WtCleanThread");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        oicq.wlogin_sdk.tools.util.deleteExpireLog(this.f1682a);
    }
}
