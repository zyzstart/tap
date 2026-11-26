package com.tencent.yybsdk.apkpatch.f.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class h {
    private java.lang.String b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final java.lang.String f1420a = "NA";
    private java.lang.String c = "NA";
    private java.lang.String d = "000";
    private java.lang.String e = "0000";
    private java.lang.String f = "NA";
    private final java.lang.String g = "NA";
    private final java.lang.String h = "000000";
    private java.lang.String i = "NA";
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private final int n = 14;
    private java.lang.String o = "NA";
    private java.lang.String p = "NA";
    private java.lang.String q = "NA";
    private java.lang.String r = "NA";
    private java.lang.String s = "NA";
    private final java.lang.String t = "NA";
    private final java.lang.String u = "V3";
    private boolean v = false;

    private void a(int i) {
        if (i != this.k) {
            this.k = i;
            this.b = null;
        }
    }

    private void a(java.lang.String str) {
        this.c = f(str);
    }

    private boolean a(android.content.Context context) {
        if (context == null) {
            return false;
        }
        try {
            int i = context.getResources().getDisplayMetrics().widthPixels;
            int i2 = context.getResources().getDisplayMetrics().heightPixels;
            int i3 = context.getResources().getConfiguration().orientation;
            if (i3 != 1) {
                if (i3 == 2) {
                    b(i2);
                } else {
                    b(java.lang.Math.min(i, i2));
                    c(java.lang.Math.min(i, i2));
                }
                return true;
            }
            b(i);
            i = i2;
            c(i);
            return true;
        } catch (java.lang.Exception unused) {
            return false;
        }
    }

    private java.lang.String b() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("0");
        stringBuffer.append(this.d.subSequence(0, 1));
        stringBuffer.append(this.e);
        java.lang.String string = stringBuffer.toString();
        return android.text.TextUtils.isEmpty(string) ? "000000" : string;
    }

    private void b(int i) {
        if (i > 0) {
            this.l = i;
        }
    }

    private void b(java.lang.String str) {
        this.d = f(str);
    }

    private void c(int i) {
        if (i > 0) {
            this.m = i;
        }
    }

    private void c(java.lang.String str) {
        this.e = f(str);
    }

    private void d(java.lang.String str) {
        this.f = f(str);
    }

    private void e(java.lang.String str) {
        this.s = f(str);
    }

    private java.lang.String f(java.lang.String str) {
        if (android.text.TextUtils.isEmpty(str) || str.equals("NA")) {
            return "NA";
        }
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] > ' ' && charArray[i] != '/' && charArray[i] != '_' && charArray[i] != '&' && charArray[i] != '|' && charArray[i] != '-') {
                stringBuffer.append(charArray[i]);
            }
        }
        return stringBuffer.toString();
    }

    public java.lang.String a() {
        java.lang.String str;
        java.lang.String str2 = this.b;
        if (str2 != null) {
            return str2;
        }
        java.lang.String strB = b();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append(this.c + "_" + this.d);
        if (!android.text.TextUtils.isEmpty(this.f)) {
            stringBuffer.append("_");
            if (this.f.equals("P")) {
                str = this.f + "_" + this.e;
            } else {
                str = this.f;
            }
            stringBuffer.append(str);
        }
        stringBuffer.append("/" + strB);
        stringBuffer.append("&NA/000000");
        stringBuffer.append("&" + this.i + "_" + this.j + "_" + this.k);
        stringBuffer.append("&" + (this.l / 16) + "_" + (this.m / 16) + "_14");
        stringBuffer.append("&" + this.o + "_" + this.p + "_" + this.q + "_" + this.r);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("&");
        sb.append(this.s);
        stringBuffer.append(sb.toString());
        stringBuffer.append("&NA");
        stringBuffer.append("&V3");
        return stringBuffer.toString();
    }

    public java.lang.String a(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i) {
        b(context, str, str2, str3, str4, str5, i);
        return a();
    }

    public boolean b(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4, java.lang.String str5, int i) {
        if (this.v) {
            return true;
        }
        this.i = f(android.os.Build.VERSION.RELEASE);
        this.j = android.os.Build.VERSION.SDK_INT;
        this.o = f(android.os.Build.BRAND);
        this.p = f(android.os.Build.MODEL);
        this.q = f(android.os.Build.MANUFACTURER);
        this.r = f(android.os.Build.PRODUCT);
        a(context);
        c(str);
        a(str2);
        b(str3);
        d(str4);
        e(str5);
        a(i);
        this.v = true;
        return true;
    }
}
