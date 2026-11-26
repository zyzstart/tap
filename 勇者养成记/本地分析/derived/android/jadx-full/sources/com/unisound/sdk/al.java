package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class al {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1516a;
    public long b;
    public long c;
    private java.lang.String d;
    private java.lang.String e;
    private boolean f = false;
    private boolean g = false;
    private com.unisound.sdk.am h;
    private float i;
    private int j;
    private int k;

    public java.lang.String a() {
        return this.d;
    }

    public void a(float f) {
        this.i = f;
    }

    public void a(int i) {
        this.j = i;
    }

    public void a(long j) {
        this.b = j;
    }

    public void a(com.unisound.sdk.am amVar) {
        this.h = amVar;
    }

    public void a(java.lang.String str) {
        this.d = str;
    }

    public void a(boolean z) {
        this.f = z;
    }

    public java.lang.String b() {
        return this.e;
    }

    public void b(int i) {
        this.k = i;
    }

    public void b(long j) {
        this.c = j;
    }

    public void b(java.lang.String str) {
        this.e = str;
    }

    public void b(boolean z) {
        this.g = z;
    }

    public void c(int i) {
        this.f1516a = i;
    }

    public boolean c() {
        return this.f;
    }

    public boolean d() {
        return this.g;
    }

    public com.unisound.sdk.am e() {
        return this.h;
    }

    public int f() {
        return this.j;
    }

    public int g() {
        return this.k;
    }

    public float h() {
        return this.i;
    }

    public int i() {
        return this.f1516a;
    }

    public long j() {
        return this.b;
    }

    public long k() {
        return this.c;
    }

    public java.lang.String toString() {
        return "resultType=" + this.h + "; recognitionResult=" + this.d + "; sessionId=" + this.e + "; isVarialbe=" + this.g + "; isLast=" + this.f + "; utterranceStartTime=" + this.j + "; utteranceEndTime=" + this.k + "; utteranceTime=" + this.f1516a + "; recordingTime=" + this.b + "; delayTime=" + this.c + "; score=" + this.i;
    }
}
