package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final boolean f1631a;
    static final boolean b;
    static final boolean c;
    static final com.unity3d.player.e d;

    static {
        f1631a = android.os.Build.VERSION.SDK_INT >= 19;
        b = android.os.Build.VERSION.SDK_INT >= 21;
        boolean z = android.os.Build.VERSION.SDK_INT >= 23;
        c = z;
        d = z ? new com.unity3d.player.h() : null;
    }
}
