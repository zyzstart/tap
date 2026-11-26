package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class av {
    private static final int c = 1;
    private static final int d = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f1478a;
    int b;

    public av() {
        this.f1478a = 0;
        this.b = 0;
    }

    public av(int i, int i2) {
        this.f1478a = 0;
        this.b = 0;
        this.f1478a = i2;
        this.b = i;
    }

    public void a(int i) {
        this.b = i;
    }

    public boolean a() {
        return (this.f1478a & 1) != 0;
    }

    public com.unisound.common.aw b() {
        int i = this.b;
        if ((i & 1) != 0) {
            return com.unisound.common.aw.MAN;
        }
        return (i & 2) != 0 ? com.unisound.common.aw.FEMALE : com.unisound.common.aw.UNKOWN;
    }
}
