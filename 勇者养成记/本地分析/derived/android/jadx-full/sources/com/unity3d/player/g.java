package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected static boolean f1630a = false;

    protected static void Log(int i, java.lang.String str) {
        if (f1630a) {
            return;
        }
        if (i == 6) {
            android.util.Log.e("Unity", str);
        }
        if (i == 5) {
            android.util.Log.w("Unity", str);
        }
    }
}
