package com.tencent.hlyyb.common.d.b.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f572a;
    public int b;
    public java.lang.String c;
    public java.lang.String d;
    public int e;

    public a() {
        this.f572a = "";
        this.b = 0;
        this.c = "";
        this.d = "";
        try {
            this.f572a = com.tencent.hlyyb.common.a.a().getPackageName();
            android.content.pm.PackageInfo packageInfo = com.tencent.hlyyb.common.a.a().getPackageManager().getPackageInfo(this.f572a, 0);
            this.b = packageInfo.versionCode;
            this.c = packageInfo.versionName;
            this.e = com.tencent.hlyyb.common.a.c();
            this.d = "";
        } catch (java.lang.Throwable unused) {
        }
    }
}
