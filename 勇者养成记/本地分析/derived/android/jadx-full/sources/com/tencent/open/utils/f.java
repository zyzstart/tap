package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.content.Context f724a;

    public static final android.content.Context a() {
        android.content.Context context = f724a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final java.io.File a(java.lang.String str) {
        return com.tencent.open.utils.l.h(a(), str);
    }

    public static final void a(android.content.Context context) {
        f724a = context;
    }

    public static final java.lang.String b() {
        return a() == null ? "" : a().getPackageName();
    }

    public static final java.io.File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final java.io.File d() {
        android.content.Context contextA = a();
        if (contextA != null) {
            return contextA.getCacheDir();
        }
        return null;
    }

    public static final java.io.File e() {
        return a((java.lang.String) null);
    }
}
