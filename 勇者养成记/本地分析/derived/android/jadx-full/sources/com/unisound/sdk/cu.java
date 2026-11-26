package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cu {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final double f1558a = 1.0d;
    public static final int b = 0;
    public static final java.lang.String c = "vprv3.hivoice.cn:80";
    private int d = 0;
    private boolean e = false;
    private java.lang.String f = com.unisound.client.SpeechConstants.OPTION_VPR_BINDMODE_BYDEVICE;
    private java.lang.String g = "";
    private int h = 2;
    private java.lang.String i = "0";

    public static double e() {
        return 1.0d;
    }

    public java.lang.String a() {
        return this.f;
    }

    public void a(int i) {
        this.h = i;
    }

    public void a(java.lang.String str) {
        this.f = str;
    }

    public void a(boolean z) {
        this.i = z ? "1" : "0";
    }

    public int b() {
        return this.h;
    }

    public void b(int i) {
        this.d = i;
    }

    public void b(java.lang.String str) {
        this.g = str;
    }

    public void b(boolean z) {
        this.e = z;
    }

    public java.lang.String c() {
        return this.i;
    }

    public java.lang.String d() {
        return this.g;
    }

    public boolean f() {
        return this.e;
    }

    public int g() {
        return this.d;
    }

    public java.lang.String h() {
        return c;
    }
}
