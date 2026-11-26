package com.tencent.ydkqmsp.sdk.g.j;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.ydkqmsp.sdk.base.b {
    private static java.lang.Class b;
    private static java.lang.Object c;
    private static java.lang.reflect.Method d;
    private static java.lang.reflect.Method e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f1386a;

    public a() {
        try {
            com.tencent.ydkqmsp.sdk.base.c.c("xm start");
            java.lang.Class<?> cls = java.lang.Class.forName("com.android.id.impl.IdProviderImpl");
            b = cls;
            c = cls.newInstance();
            d = b.getMethod("getOAID", android.content.Context.class);
            e = b.getMethod("getAAID", android.content.Context.class);
        } catch (java.lang.Exception e2) {
            com.tencent.ydkqmsp.sdk.base.c.a("xm reflect exception!" + e2);
        }
    }

    private java.lang.String a(android.content.Context context, java.lang.Object obj, java.lang.reflect.Method method) {
        if (obj == null || method == null) {
            return null;
        }
        try {
            java.lang.Object objInvoke = method.invoke(obj, context);
            if (objInvoke != null) {
                return (java.lang.String) objInvoke;
            }
            return null;
        } catch (java.lang.Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        java.lang.reflect.Method method;
        java.lang.Object obj = c;
        if (obj == null || (method = d) == null) {
            return null;
        }
        return a(this.f1386a, obj, method);
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.f1386a = context;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        java.lang.reflect.Method method;
        java.lang.Object obj = c;
        if (obj == null || (method = e) == null) {
            return null;
        }
        return a(this.f1386a, obj, method);
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void c() {
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean d() {
        return true;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public boolean e() {
        return (b == null || c == null) ? false : true;
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
    }
}
