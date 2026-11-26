package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1546a = "x-wav";
    public static final java.lang.String b = "pcm";
    public static final java.lang.String c = "opus";
    public static final int d = 16;
    public static final int e = 16000;
    private java.lang.String f = f1546a;
    private java.lang.String g = "pcm";
    private java.lang.String h = "opus";
    private int i = 16;
    private int j = 16000;
    private boolean k = true;

    public java.lang.String a() {
        return this.h;
    }

    public void a(boolean z) {
        this.k = z;
    }

    public java.lang.String b() {
        return "audio/" + this.f;
    }

    public boolean c() {
        return this.k;
    }
}
