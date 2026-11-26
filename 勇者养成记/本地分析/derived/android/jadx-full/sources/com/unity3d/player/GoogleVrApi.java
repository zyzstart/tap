package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class GoogleVrApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.concurrent.atomic.AtomicReference f1578a = new java.util.concurrent.atomic.AtomicReference();

    private GoogleVrApi() {
    }

    static void a() {
        f1578a.set(null);
    }

    static void a(com.unity3d.player.f fVar) {
        f1578a.compareAndSet(null, new com.unity3d.player.GoogleVrProxy(fVar));
    }

    static com.unity3d.player.GoogleVrProxy b() {
        return (com.unity3d.player.GoogleVrProxy) f1578a.get();
    }

    public static com.unity3d.player.GoogleVrVideo getGoogleVrVideo() {
        return (com.unity3d.player.GoogleVrVideo) f1578a.get();
    }
}
