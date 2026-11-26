package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class q {
    protected static java.lang.String b = "NA";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected android.content.Context f1060a;

    public q(android.content.Context context) {
        this.f1060a = null;
        this.f1060a = context;
    }

    private java.lang.StringBuffer a(java.lang.String str) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (android.text.TextUtils.isEmpty(str)) {
            stringBuffer.append("NA");
            return stringBuffer;
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > ' ' && charArray[i] != '/' && charArray[i] != '_' && charArray[i] != '&' && charArray[i] != '|' && charArray[i] != '-') {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer;
    }

    public static java.lang.String b() {
        return "33";
    }

    private int c() {
        android.content.Context context = this.f1060a;
        if (context == null || context.getResources() == null || this.f1060a.getResources().getDisplayMetrics() == null) {
            return 0;
        }
        return this.f1060a.getResources().getDisplayMetrics().widthPixels;
    }

    private int d() {
        android.content.Context context = this.f1060a;
        if (context == null || context.getResources() == null || this.f1060a.getResources().getDisplayMetrics() == null) {
            return 0;
        }
        return this.f1060a.getResources().getDisplayMetrics().heightPixels;
    }

    private int e() {
        return 0;
    }

    private java.lang.String f() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(a(android.os.Build.BRAND));
        stringBuffer.append("_");
        stringBuffer.append(a(android.os.Build.MODEL));
        return stringBuffer.toString();
    }

    private java.lang.String g() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        java.lang.String str = android.os.Build.VERSION.RELEASE;
        if (android.text.TextUtils.isEmpty(str)) {
            str = "NA";
        }
        stringBuffer.append(str);
        stringBuffer.append("_");
        stringBuffer.append(android.os.Build.VERSION.SDK_INT);
        return stringBuffer.toString();
    }

    public java.lang.String a() {
        com.tencent.tmassistantbase.util.p pVar = new com.tencent.tmassistantbase.util.p();
        pVar.c = b();
        pVar.d = "";
        pVar.e = b;
        pVar.f = g();
        pVar.h = d();
        pVar.g = c();
        pVar.i = e();
        pVar.f1059a = f();
        pVar.b = java.lang.String.valueOf(3010);
        return pVar.a();
    }
}
