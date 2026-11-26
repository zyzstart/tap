package com.tencent.ydkqmsp.sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.StringBuilder f1290a;
    private boolean b;

    public g() {
        a();
    }

    private void b() {
        b(",");
    }

    private void b(java.lang.String str) {
        if (this.b) {
            this.f1290a.append(str);
        }
        this.b = true;
    }

    public com.tencent.ydkqmsp.sdk.a.g a() {
        this.f1290a = new java.lang.StringBuilder();
        this.b = false;
        return this;
    }

    public com.tencent.ydkqmsp.sdk.a.g a(int i) {
        return a(java.lang.String.format("%d", java.lang.Integer.valueOf(i)));
    }

    public com.tencent.ydkqmsp.sdk.a.g a(java.lang.String str) {
        b();
        this.f1290a.append(str.replace(',', ';'));
        return this;
    }

    public java.lang.String toString() {
        return this.f1290a.toString();
    }
}
