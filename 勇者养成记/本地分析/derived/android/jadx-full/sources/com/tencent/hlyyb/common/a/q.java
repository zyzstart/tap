package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f538a;
    public boolean b = true;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public boolean g;
    private java.lang.String[] h;

    public q(com.tencent.hlyyb.common.a.p pVar, java.lang.String str, int i, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5) {
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.f538a = str;
        java.lang.String[] strArrSplit = str.split("-");
        if (strArrSplit.length < 5) {
            this.h = new java.lang.String[]{"all", "all", "all", "all", "all"};
            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                this.h[i2] = strArrSplit[i2];
            }
        } else {
            this.h = strArrSplit;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append(i);
        this.c = a(0, sb.toString());
        this.d = a(1, str2);
        this.e = a(2, str3);
        this.f = a(3, str4);
        this.g = a(4, str5);
        this.h = null;
    }

    private boolean a(int i, java.lang.String str) {
        java.lang.String[] strArr = this.h;
        if (strArr.length < i + 1) {
            return false;
        }
        boolean zEquals = strArr[i].equals(str);
        if (zEquals || this.h[i].equals("all")) {
            return zEquals;
        }
        this.b = false;
        return zEquals;
    }
}
