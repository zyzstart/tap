package com.tencent.tmassistantbase.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public java.lang.String f1059a;
    public java.lang.String b;
    public java.lang.String c;
    public java.lang.String d;
    public java.lang.String e;
    public java.lang.String f;
    public int g;
    public int h;
    public int i;

    private java.lang.String b() {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("0");
        stringBuffer.append(this.b.subSequence(0, 1));
        stringBuffer.append(this.c);
        return stringBuffer.toString();
    }

    public java.lang.String a() {
        java.lang.String strB = b();
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("selfUpdate");
        stringBuffer.append("_");
        stringBuffer.append(this.b);
        if (!android.text.TextUtils.isEmpty(this.d)) {
            stringBuffer.append("_");
            stringBuffer.append(this.d);
        }
        stringBuffer.append("/");
        stringBuffer.append(strB);
        stringBuffer.append("&NA/");
        stringBuffer.append(strB);
        stringBuffer.append("&");
        stringBuffer.append(this.f);
        stringBuffer.append("_");
        stringBuffer.append(this.i);
        stringBuffer.append("&");
        stringBuffer.append(this.g / 16);
        stringBuffer.append("_");
        stringBuffer.append(this.h / 16);
        stringBuffer.append("_");
        stringBuffer.append("14&");
        stringBuffer.append(this.f1059a);
        stringBuffer.append("&");
        stringBuffer.append(this.e);
        stringBuffer.append("&");
        stringBuffer.append("NA");
        stringBuffer.append("&");
        stringBuffer.append("V3");
        return stringBuffer.toString();
    }
}
