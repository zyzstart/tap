package com.tencent.ydkbeacon.base.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1230a;
    public java.lang.String b;
    public int c;
    public java.lang.String d;
    public java.lang.Throwable e;

    public e(java.lang.String str, java.lang.String str2, int i, java.lang.String str3) {
        this.f1230a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
    }

    public e(java.lang.String str, java.lang.String str2, int i, java.lang.String str3, java.lang.Throwable th) {
        this.f1230a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
        this.e = th;
    }

    public java.lang.String toString() {
        return "NetFailure{requestType='" + this.f1230a + "', attaCode='" + this.b + "', responseCode=" + this.c + ", msg='" + this.d + "', exception=" + this.e + '}';
    }
}
