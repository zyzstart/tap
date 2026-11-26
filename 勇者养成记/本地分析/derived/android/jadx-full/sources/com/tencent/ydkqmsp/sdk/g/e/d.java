package com.tencent.ydkqmsp.sdk.g.e;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class d {
    public static java.lang.String a(android.content.Context context) {
        com.tencent.ydkqmsp.sdk.g.e.c cVarA = com.tencent.ydkqmsp.sdk.g.e.c.a();
        return cVarA.a(context.getApplicationContext(), cVarA.c);
    }

    public static final boolean a() {
        android.content.Context context;
        try {
            java.lang.reflect.Method method = java.lang.Class.forName("android.app.ActivityThread").getMethod("currentApplication", new java.lang.Class[0]);
            method.setAccessible(true);
            context = (android.content.Context) method.invoke(null, new java.lang.Object[0]);
        } catch (java.lang.Exception e) {
            android.util.Log.e("OpenIdHelper", "ActivityThread:currentApplication --> " + e.toString());
            context = null;
        }
        if (context == null) {
            return false;
        }
        return com.tencent.ydkqmsp.sdk.g.e.c.a().a(context, false);
    }

    public static java.lang.String b(android.content.Context context) {
        com.tencent.ydkqmsp.sdk.g.e.c cVarA = com.tencent.ydkqmsp.sdk.g.e.c.a();
        return cVarA.a(context.getApplicationContext(), cVarA.b);
    }
}
