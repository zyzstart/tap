package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class au {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final int f1477a = 1;
    int b = 0;

    public int a() {
        return this.b;
    }

    public void a(boolean z) {
        this.b = z ? this.b | 1 : this.b & (-2);
    }

    public boolean b() {
        return (this.b & 1) != 0;
    }
}
