package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected android.content.Context f1061a;
    protected final java.lang.String b;

    public r(android.content.Context context) {
        this.f1061a = context;
        this.b = this.f1061a.getPackageName() + ".R";
    }

    private int a(java.lang.String str, java.lang.String str2) {
        if (this.b == null || str == null || str2 == null) {
            return 0;
        }
        try {
            java.lang.Class<?> cls = java.lang.Class.forName(this.b + "$" + str);
            return java.lang.Integer.parseInt(cls.getField(str2).get(cls.newInstance()).toString());
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int a(java.lang.String str) {
        return a("string", str);
    }

    public int b(java.lang.String str) {
        return a("drawable", str);
    }

    public int c(java.lang.String str) {
        return a("layout", str);
    }

    public int d(java.lang.String str) {
        return a("id", str);
    }

    public int e(java.lang.String str) {
        return a("style", str);
    }
}
