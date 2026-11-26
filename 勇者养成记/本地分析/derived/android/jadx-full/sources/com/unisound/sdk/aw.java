package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class aw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f1524a = 0;
    private int b = -1;
    private boolean c = false;

    public void a() {
        this.f1524a = 0;
    }

    public void a(int i) {
        a();
        if (i == -1) {
            this.c = false;
        } else {
            this.c = true;
            this.b = i * 32;
        }
    }

    public boolean a(boolean z, int i) {
        if (!z || !this.c) {
            return false;
        }
        this.f1524a += i;
        return this.f1524a > this.b;
    }
}
