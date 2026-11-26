package com.tencent.ydkbeacon.base.net;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.util.Map f1205a;
    public int b;
    public java.lang.String c;
    public byte[] d;

    public a(java.util.Map map, int i, java.lang.String str, byte[] bArr) {
        this.f1205a = map;
        this.b = i;
        this.c = str;
        this.d = bArr;
    }

    public java.lang.String toString() {
        return "BResponse{code=" + this.b + ", msg='" + this.c + "'}";
    }
}
