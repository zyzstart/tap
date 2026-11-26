package com.tencent.ydkqmsp.sdk.g.i;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b implements com.tencent.ydkqmsp.sdk.base.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.tencent.ydkqmsp.sdk.g.i.a f1385a;

    private static java.lang.String a(java.lang.String str, java.lang.String str2) {
        try {
            java.lang.Class<?> cls = java.lang.Class.forName("android.os.SystemProperties");
            java.lang.reflect.Method method = cls.getMethod("get", java.lang.String.class, java.lang.String.class);
            java.lang.Object[] objArr = new java.lang.Object[2];
            objArr[0] = str;
            objArr[1] = android.support.v4.os.EnvironmentCompat.MEDIA_UNKNOWN;
            return (java.lang.String) method.invoke(cls, objArr);
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String a() {
        return this.f1385a.a(0, "");
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void a(android.content.Context context, com.tencent.ydkqmsp.sdk.base.IVendorCallback iVendorCallback) {
        this.f1385a = new com.tencent.ydkqmsp.sdk.g.i.a(context);
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public java.lang.String b() {
        return null;
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
        return "1".equals(a("persist.sys.identifierid.supported", "0"));
    }

    @Override // com.tencent.ydkqmsp.sdk.base.b
    public void f() {
    }
}
