package com.bun.miitmdid.c.k;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.support.annotation.Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @android.support.annotation.Keep
    private static java.lang.Object f43a;

    @android.support.annotation.Keep
    private static java.lang.Class<?> b;

    @android.support.annotation.Keep
    private static java.lang.reflect.Method c;

    @android.support.annotation.Keep
    private static java.lang.reflect.Method d;

    @android.support.annotation.Keep
    private static java.lang.reflect.Method e;

    static {
        try {
            b = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            f43a = b.newInstance();
        } catch (java.lang.Exception e2) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e2);
        }
        try {
            if (b != null) {
                c = b.getMethod("getOAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e3) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e3);
        }
        try {
            if (b != null) {
                d = b.getMethod("getVAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e4) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e4);
        }
        try {
            if (b != null) {
                e = b.getMethod("getAAID", android.content.Context.class);
            }
        } catch (java.lang.Exception e5) {
            com.bun.lib.a.a("IdentifierManager", "reflect exception!", e5);
        }
    }

    @android.support.annotation.Keep
    public static native java.lang.String a(android.content.Context context);

    @android.support.annotation.Keep
    private static native java.lang.String a(android.content.Context context, java.lang.reflect.Method method);

    @android.support.annotation.Keep
    public static native boolean a();

    @android.support.annotation.Keep
    public static native java.lang.String b(android.content.Context context);

    @android.support.annotation.Keep
    public static native java.lang.String c(android.content.Context context);
}
