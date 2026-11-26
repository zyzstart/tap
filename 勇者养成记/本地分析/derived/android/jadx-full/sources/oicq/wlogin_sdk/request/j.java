package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class j implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.net.HttpURLConnection f1684a;
    private boolean b = false;

    public j(java.net.HttpURLConnection httpURLConnection) {
        this.f1684a = httpURLConnection;
    }

    public static boolean a(java.net.HttpURLConnection httpURLConnection, long j) {
        try {
            oicq.wlogin_sdk.request.j jVar = new oicq.wlogin_sdk.request.j(httpURLConnection);
            java.lang.Thread thread = new java.lang.Thread(jVar);
            thread.start();
            thread.join(j);
            return jVar.a();
        } catch (java.lang.Throwable unused) {
            return false;
        }
    }

    public boolean a() {
        return this.b;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.f1684a.connect();
            this.b = true;
        } catch (java.lang.Throwable th) {
            oicq.wlogin_sdk.tools.util.printThrowable(th, "");
        }
    }
}
