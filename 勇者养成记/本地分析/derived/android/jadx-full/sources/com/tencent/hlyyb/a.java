package com.tencent.hlyyb;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f517a;
    private int b;
    private java.lang.String d;
    private java.lang.String e;
    private java.lang.String f = "0M100WJ33N1CQ08O";
    private boolean g = false;
    private int h = -1;
    private boolean c = true;

    public a(android.content.Context context, int i, java.lang.String str, java.lang.String str2) {
        this.d = "";
        this.e = "";
        this.f517a = context.getApplicationContext();
        this.b = i;
        this.d = str;
        this.e = str2;
    }

    public final android.content.Context a() {
        return this.f517a;
    }

    public final java.lang.String b() {
        return this.e;
    }

    public final java.lang.String c() {
        return this.d;
    }

    public final boolean d() {
        return this.c;
    }

    public final int e() {
        return this.b;
    }

    public final boolean f() {
        return this.g;
    }

    public final int g() {
        return this.h;
    }

    public final java.lang.String h() {
        return this.f;
    }

    public final java.lang.String toString() {
        java.lang.StringBuilder sb = new java.lang.StringBuilder("[");
        sb.append("appid:" + this.b);
        sb.append(",uuid:" + this.d);
        sb.append(",channelid:" + this.e);
        sb.append(",isSDKMode:" + this.c);
        sb.append(",isTest:" + this.g);
        sb.append(",testAppid:" + this.h);
        sb.append("]");
        return sb.toString();
    }
}
