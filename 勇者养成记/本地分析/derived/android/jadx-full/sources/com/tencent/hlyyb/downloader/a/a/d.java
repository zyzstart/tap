package com.tencent.hlyyb.downloader.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final java.util.concurrent.LinkedBlockingQueue f604a = new java.util.concurrent.LinkedBlockingQueue();
    private static com.tencent.hlyyb.downloader.a.a.d b;
    private static java.lang.Thread c;

    public static synchronized com.tencent.hlyyb.downloader.a.a.d a() {
        if (b == null) {
            b = new com.tencent.hlyyb.downloader.a.a.d();
            java.lang.Thread thread = new java.lang.Thread(b);
            c = thread;
            thread.start();
        }
        return b;
    }

    public static void a(java.net.HttpURLConnection httpURLConnection) {
        try {
            f604a.put(httpURLConnection);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (true) {
            try {
                java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) f604a.take();
                try {
                    httpURLConnection.disconnect();
                    httpURLConnection.getInputStream().close();
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
            } catch (java.lang.InterruptedException e2) {
                e2.printStackTrace();
                return;
            }
        }
    }
}
