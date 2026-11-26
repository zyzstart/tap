package oicq.wlogin_sdk.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1677a;
    private int b;
    private java.net.InetSocketAddress c;

    public a(java.lang.String str, int i) {
        this.f1677a = str;
        this.b = i;
    }

    public static java.net.InetSocketAddress a(java.lang.String str, int i, long j) {
        try {
            oicq.wlogin_sdk.request.a aVar = new oicq.wlogin_sdk.request.a(str, i);
            java.lang.Thread thread = new java.lang.Thread(aVar);
            thread.start();
            thread.join(j);
            return aVar.a();
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    public synchronized java.net.InetSocketAddress a() {
        return this.c;
    }

    public synchronized void a(java.net.InetSocketAddress inetSocketAddress) {
        this.c = inetSocketAddress;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            a(new java.net.InetSocketAddress(this.f1677a, this.b));
        } catch (java.lang.Exception unused) {
        }
    }
}
