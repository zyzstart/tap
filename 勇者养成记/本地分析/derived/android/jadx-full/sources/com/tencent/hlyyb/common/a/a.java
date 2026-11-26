package com.tencent.hlyyb.common.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f519a;
    public int b;
    private java.lang.String c;
    private int d;
    private byte e;
    private byte f;
    private java.lang.String[] g;

    public a() {
        this.c = "";
        this.d = -1;
        this.f519a = -1;
        this.b = -1;
        this.f = (byte) 1;
    }

    public a(java.lang.String str, int i) {
        this.c = "";
        this.d = -1;
        this.f519a = -1;
        this.b = -1;
        this.f = (byte) 1;
        this.c = str;
        this.d = i;
    }

    public final java.lang.String a() {
        return this.c;
    }

    public final void a(byte b) {
        this.e = b;
    }

    public final void a(int i) {
        this.d = i;
    }

    public final boolean a(com.tencent.hlyyb.common.a.a aVar) {
        return aVar != null && this.c.equals(aVar.c) && this.d == aVar.d;
    }

    public final boolean a(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        java.lang.String[] strArrSplit = str.split(":");
        this.g = strArrSplit;
        if (strArrSplit.length != 2) {
            return false;
        }
        java.lang.String str2 = strArrSplit[0];
        this.c = str2;
        if (!com.tencent.hlyyb.common.f.c.d(str2)) {
            return false;
        }
        try {
            int i = java.lang.Integer.parseInt(this.g[1]);
            this.d = i;
            return i >= 0 && i <= 65535;
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
    }

    public final byte b() {
        return this.e;
    }

    public final void b(java.lang.String str) {
        this.c = str;
    }

    public final int c() {
        return this.d;
    }

    public final java.lang.String d() {
        return this.c + ":" + this.d;
    }

    public final boolean e() {
        return this.e == 3;
    }

    public final java.lang.String toString() {
        return this.c + ":" + this.d + ",protocalType:" + ((int) this.f) + ",ipType:" + ((int) this.e);
    }
}
