package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static java.util.Map f1055a = new java.util.concurrent.ConcurrentHashMap();
    private static android.os.Handler b;

    public static android.os.Handler a() {
        if (b == null) {
            b = a(com.tencent.tmassistantbase.util.m.ID_DEAFULT);
        }
        return b;
    }

    public static android.os.Handler a(com.tencent.tmassistantbase.util.m mVar) {
        if (f1055a.containsKey(mVar)) {
            return (android.os.Handler) f1055a.get(mVar);
        }
        android.os.HandlerThread handlerThread = new android.os.HandlerThread(mVar.name());
        handlerThread.start();
        android.os.Handler handler = new android.os.Handler(handlerThread.getLooper());
        f1055a.put(mVar, handler);
        return handler;
    }

    public static android.os.Looper b(com.tencent.tmassistantbase.util.m mVar) {
        return a(mVar).getLooper();
    }
}
