package com.meizu.flyme.openidsdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class ValueData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    public java.lang.String f60a;

    @android.support.annotation.Keep
    public int b;

    @android.support.annotation.Keep
    public long c = java.lang.System.currentTimeMillis() + 86400000;

    @android.support.annotation.Keep
    public ValueData(java.lang.String str, int i) {
        this.f60a = str;
        this.b = i;
    }

    @android.support.annotation.Keep
    public native java.lang.String toString();
}
