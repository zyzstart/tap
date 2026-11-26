package com.tencent.smtt.sdk.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f913a;
    private android.content.pm.ResolveInfo b;
    private android.graphics.drawable.Drawable c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;

    b(android.content.Context context, android.content.pm.ResolveInfo resolveInfo) {
        this.f = 0;
        this.f913a = context.getApplicationContext();
        this.b = resolveInfo;
        this.c = null;
        this.d = null;
        this.e = null;
    }

    b(android.content.Context context, android.graphics.drawable.Drawable drawable, java.lang.String str, java.lang.String str2) {
        this.f = 0;
        this.f913a = context.getApplicationContext();
        this.b = null;
        this.c = drawable;
        this.d = str;
        this.e = str2;
    }

    public static android.graphics.drawable.Drawable a(android.content.Context context, java.lang.String str) {
        if (com.tencent.smtt.sdk.TbsConfig.APP_QB.equals(str)) {
            try {
                return com.tencent.smtt.sdk.b.a.d.a("application_icon");
            } catch (java.lang.Throwable th) {
                android.util.Log.e("error", "getApkIcon Error:" + android.util.Log.getStackTraceString(th));
                return null;
            }
        }
        android.content.pm.PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            android.content.pm.ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, 128);
            if (applicationInfo == null) {
                return null;
            }
            android.content.res.Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo);
            android.util.TypedValue typedValue = new android.util.TypedValue();
            resourcesForApplication.getValue(applicationInfo.icon, typedValue, true);
            try {
                return android.graphics.drawable.Drawable.createFromResourceStream(resourcesForApplication, typedValue, new java.io.BufferedInputStream(resourcesForApplication.getAssets().openNonAssetFd(typedValue.assetCookie, typedValue.string.toString()).createInputStream()), null);
            } catch (java.lang.Exception unused) {
                return null;
            }
        } catch (java.lang.Exception e) {
            android.util.Log.e("sdk", "e = " + e);
            return null;
        }
    }

    public android.graphics.drawable.Drawable a(java.util.Map map) {
        android.graphics.drawable.Drawable drawableA = a(this.f913a, c());
        if (drawableA != null) {
            return drawableA;
        }
        android.content.pm.ResolveInfo resolveInfo = this.b;
        return resolveInfo != null ? resolveInfo.loadIcon(this.f913a.getPackageManager()) : this.c;
    }

    public java.lang.String a() {
        android.content.pm.ResolveInfo resolveInfo = this.b;
        return resolveInfo != null ? resolveInfo.loadLabel(this.f913a.getPackageManager()).toString() : this.d;
    }

    public void a(android.content.pm.ResolveInfo resolveInfo) {
        this.b = resolveInfo;
    }

    public android.content.pm.ResolveInfo b() {
        return this.b;
    }

    public java.lang.String c() {
        android.content.pm.ResolveInfo resolveInfo = this.b;
        if (resolveInfo != null) {
            return resolveInfo.activityInfo.packageName;
        }
        java.lang.String str = this.e;
        return str == null ? "" : str;
    }
}
