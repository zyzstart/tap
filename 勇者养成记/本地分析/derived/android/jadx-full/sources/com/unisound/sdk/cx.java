package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class cx {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final java.lang.String f1560a = "wakeup";
    public static final java.lang.String b = "#JSGF V1.0 utf-8 cn;\ngrammar wakeup;\npublic <wakeup> =( \"<s>\" (\n(<NAME> )\n) \"</s>\");";
    private java.lang.String c = "wakeup.dat";
    private java.util.List<java.lang.String> d = new java.util.ArrayList();
    private boolean e = false;

    public cx() {
        this.d.add("您好魔方");
    }

    public java.lang.String a() {
        return this.c;
    }

    public void a(java.lang.String str) {
        this.c = str + "wakeup.dat";
    }

    public void a(boolean z) {
        this.e = z;
    }

    public boolean a(java.util.List<java.lang.String> list) {
        return list == null || !list.toString().equals(this.d.toString());
    }

    public java.lang.String b() {
        return b;
    }

    public void b(java.util.List<java.lang.String> list) {
        if (a(list)) {
            a(true);
            this.d.clear();
            this.d.addAll(list);
        }
    }

    public java.lang.String c(java.util.List<java.lang.String> list) {
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        stringBuffer.append("<NAME>");
        stringBuffer.append("\n");
        java.util.Iterator<java.lang.String> it = list.iterator();
        while (it.hasNext()) {
            stringBuffer.append(it.next());
            stringBuffer.append("\n");
        }
        stringBuffer.append("</NAME>");
        return stringBuffer.toString();
    }

    public boolean c() {
        return this.e;
    }

    public java.lang.String d() {
        return c(this.d);
    }

    public java.util.List<java.lang.String> e() {
        return this.d;
    }
}
