package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f535a = "info.3g.qq.com";

    public static boolean a() {
        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(1);
        boolean[] zArr = {false};
        com.tencent.hlyyb.common.a.l.f534a.b().execute(new com.tencent.hlyyb.common.a.o(zArr, countDownLatch));
        try {
            countDownLatch.await(5L, java.util.concurrent.TimeUnit.SECONDS);
        } catch (java.lang.InterruptedException e) {
            e.printStackTrace();
        }
        return zArr[0];
    }

    private static boolean a(java.lang.String str, int i, int i2) {
        java.net.Socket socket;
        boolean zIsConnected = false;
        try {
            socket = new java.net.Socket();
            try {
                socket.connect(new java.net.InetSocketAddress(str, 80), com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
                zIsConnected = socket.isConnected();
            } catch (java.lang.Throwable th) {
                th = th;
                try {
                    th.printStackTrace();
                    return zIsConnected;
                } finally {
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (java.lang.Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            socket = null;
        }
        return zIsConnected;
    }

    public static boolean b() {
        return a(f535a, 80, com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING);
    }
}
