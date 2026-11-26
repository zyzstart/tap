package com.tencent.hlyyb.common.d;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f592a;
    public boolean b;
    public boolean c;
    public java.lang.String d;
    public android.os.Bundle e;
    private int f;

    public k(int i, java.lang.String str, boolean z, boolean z2, java.lang.String str2, android.os.Bundle bundle) {
        this.b = false;
        this.c = false;
        this.d = "";
        this.f = i;
        this.f592a = str;
        this.b = z;
        this.c = z2;
        this.d = str2;
        this.e = bundle;
    }

    public final java.lang.String toString() {
        return "appid:" + this.f + "," + this.f592a + "," + this.b + "," + this.c + "," + this.d;
    }
}
