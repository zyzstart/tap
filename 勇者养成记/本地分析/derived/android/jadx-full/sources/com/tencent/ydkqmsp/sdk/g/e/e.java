package com.tencent.ydkqmsp.sdk.g.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1370a;
    public long b = java.lang.System.currentTimeMillis() + 86400000;
    public java.lang.String c;

    public e(java.lang.String str, int i) {
        this.c = str;
        this.f1370a = i;
    }

    public java.lang.String toString() {
        return "ValueData{value='" + this.c + "', code=" + this.f1370a + ", expired=" + this.b + '}';
    }
}
