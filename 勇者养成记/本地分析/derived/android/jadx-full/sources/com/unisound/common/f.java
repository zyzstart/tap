package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class f extends java.lang.Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected int f1489a = 0;

    public f(boolean z) {
        int i;
        if (z) {
            setPriority(10);
            i = -19;
        } else {
            setPriority(5);
            i = -16;
        }
        android.os.Process.setThreadPriority(i);
    }

    public void a(int i) {
        this.f1489a = i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
    }
}
