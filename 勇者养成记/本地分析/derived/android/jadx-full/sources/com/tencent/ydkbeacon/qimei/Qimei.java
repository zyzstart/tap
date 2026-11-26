package com.tencent.ydkbeacon.qimei;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class Qimei {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1279a;
    private java.lang.String b;
    private java.util.Map c;

    public Qimei() {
        this("", "", null);
    }

    public Qimei(java.lang.String str) {
        this(str, "", null);
    }

    public Qimei(java.lang.String str, java.lang.String str2, java.util.Map map) {
        this.f1279a = str == null ? "" : str;
        this.b = str2 == null ? "" : str2;
        this.c = map;
    }

    void a(java.lang.String str) {
        this.b = str;
    }

    void a(java.util.Map map) {
        this.c = map;
    }

    void b(java.lang.String str) {
        this.f1279a = str;
    }

    public java.util.Map getQimeiMap() {
        return this.c;
    }

    public java.lang.String getQimeiNew() {
        return this.b;
    }

    public java.lang.String getQimeiOld() {
        return this.f1279a;
    }

    public boolean isEmpty() {
        java.util.Map map = this.c;
        return map == null || map.isEmpty();
    }

    public java.lang.String toString() {
        java.lang.String str;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("Qimei:");
        sb.append(this.f1279a);
        if (android.text.TextUtils.isEmpty(this.b)) {
            str = "";
        } else {
            str = "\nQimei3:" + this.b;
        }
        sb.append(str);
        return sb.toString();
    }
}
