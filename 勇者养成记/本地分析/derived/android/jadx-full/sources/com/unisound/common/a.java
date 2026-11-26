package com.unisound.common;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f1462a;
    private int b;
    private java.lang.String d;
    private int e;
    private boolean g;
    private java.lang.String c = "";
    private boolean f = false;

    public a(com.unisound.common.a aVar) {
        this.f1462a = "117.121.55.35";
        this.b = 80;
        this.d = "117.121.55.35";
        this.e = 80;
        this.g = true;
        this.f1462a = aVar.f1462a;
        this.b = aVar.b;
        this.d = aVar.d;
        this.e = aVar.e;
        this.g = true;
    }

    public a(java.lang.String str, int i, java.lang.String str2, int i2) {
        this.f1462a = "117.121.55.35";
        this.b = 80;
        this.d = "117.121.55.35";
        this.e = 80;
        this.g = true;
        this.f1462a = str;
        this.b = i;
        this.e = i2;
        this.d = str2;
        this.g = true;
    }

    private void f() {
        if (this.f) {
            return;
        }
        try {
            this.c = java.net.InetAddress.getByName(this.f1462a).getHostAddress();
            this.f = true;
        } catch (java.net.UnknownHostException unused) {
            com.unisound.common.y.a("InetAddress.getByName fail");
        }
    }

    public java.lang.String a() {
        f();
        return this.f ? this.c : this.d;
    }

    public void a(int i) {
        this.e = i;
        this.g = true;
    }

    public void a(com.unisound.common.a aVar) {
        this.f1462a = aVar.f1462a;
        this.b = aVar.b;
        this.d = aVar.d;
        this.e = aVar.e;
        this.f = false;
        this.g = true;
    }

    public void a(java.lang.String str) {
        this.d = str;
        this.g = true;
    }

    public void a(boolean z) {
        this.g = z;
    }

    public java.lang.String b() {
        return this.f1462a;
    }

    public void b(int i) {
        this.b = i;
    }

    public void b(java.lang.String str) {
        this.f1462a = str;
        this.f = false;
        this.g = true;
    }

    public int c() {
        return this.b;
    }

    public boolean c(java.lang.String str) {
        if (str == null) {
            return false;
        }
        java.lang.String[] strArrSplit = str.split(":");
        if (strArrSplit.length != 2 || strArrSplit[0].length() == 0) {
            return false;
        }
        try {
            this.b = (short) java.lang.Integer.valueOf(strArrSplit[1]).intValue();
            this.f1462a = strArrSplit[0];
            this.d = strArrSplit[0];
            this.e = this.b;
            this.g = true;
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean d() {
        return this.g;
    }

    public void e() {
        this.f = false;
    }
}
