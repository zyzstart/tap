package com.unisound.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class i {
    private static final java.lang.String A = "sampleRate";
    private static final java.lang.String B = "oneshot";
    private static final java.lang.String C = "oneshot_key";
    private static final java.lang.String D = "alread_awpe";
    private static final java.lang.String E = "productLine";
    private static final java.lang.String F = "punctuated";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f1565a = 8000;
    public static final int b = 16000;
    public static final int c = 80000;
    public static final java.lang.String d = "far";
    public static final java.lang.String e = "near";
    public static final java.lang.String f = "8k";
    public static final java.lang.String g = "16k";
    public static final java.lang.String h = "16kto8k";
    public static final java.lang.String i = "general";
    public static final java.lang.String j = "poi";
    public static final java.lang.String k = "food";
    public static final java.lang.String l = "medical";
    public static final java.lang.String m = "movietv";
    public static final java.lang.String n = "textFormat";
    public static final java.lang.String o = "serverVad";
    public static final java.lang.String p = "best_result_return";
    public static final java.lang.String q = "false_alarm";
    public static final java.lang.String r = "domains_penalty";
    public static final java.lang.String s = "SGN_Setting";
    public static final java.lang.String t = "en";
    public static final java.lang.String u = "co";
    public static final java.lang.String v = "cn";
    private static final java.lang.String w = "modelType";
    private static final java.lang.String x = "subModel";
    private static final java.lang.String y = "voiceField";
    private static final java.lang.String z = "lang";
    private java.util.Map<java.lang.String, java.lang.String> G = new java.util.HashMap();
    private java.lang.StringBuffer H = new java.lang.StringBuffer();
    private boolean I = true;
    private int J = 16000;
    private boolean K = true;
    private boolean L = true;

    public i() {
        d(e);
        a(16000);
        d(false);
        f("");
        g("json");
    }

    private void g() {
        this.I = true;
    }

    private void h() {
        if (this.I) {
            this.I = false;
            java.lang.StringBuffer stringBuffer = this.H;
            stringBuffer.delete(0, stringBuffer.length());
            for (java.lang.String str : this.G.keySet()) {
                java.lang.StringBuffer stringBuffer2 = this.H;
                stringBuffer2.append(str);
                stringBuffer2.append(":");
                java.lang.StringBuffer stringBuffer3 = this.H;
                stringBuffer3.append(this.G.get(str));
                stringBuffer3.append("\n");
            }
        }
    }

    public void a(java.lang.String str) {
        this.G.put("lang", str);
        g();
    }

    public void a(java.lang.String str, java.lang.String str2) {
        this.G.put(str, java.lang.String.valueOf(str2));
        g();
    }

    public void a(boolean z2) {
        this.K = z2;
    }

    public boolean a() {
        return this.K;
    }

    public boolean a(int i2) {
        if (i2 == 8000) {
            b();
            return true;
        }
        if (i2 == 16000) {
            d();
            return true;
        }
        if (i2 == 80000) {
            c();
            return true;
        }
        com.unisound.common.y.a(toString() + ".setSampleRate param error " + i2);
        return false;
    }

    public void b() {
        e(h);
        this.J = 8000;
    }

    public void b(int i2) {
        this.G.put(q, java.lang.String.valueOf(i2));
        g();
    }

    public void b(boolean z2) {
        this.L = z2;
    }

    public boolean b(java.lang.String str) {
        this.G.put(w, str);
        g();
        return true;
    }

    public void c() {
        e(f);
        this.J = c;
    }

    public void c(int i2) {
        this.G.put(r, java.lang.String.valueOf(i2));
        g();
    }

    public boolean c(java.lang.String str) {
        this.G.put(x, str);
        g();
        return true;
    }

    public boolean c(boolean z2) {
        return this.L;
    }

    public void d() {
        e(g);
        this.J = 16000;
    }

    public void d(java.lang.String str) {
        this.G.put(y, str);
        g();
    }

    public void d(boolean z2) {
        this.G.put(B, java.lang.String.valueOf(z2));
        g();
    }

    public void e() {
        java.lang.StringBuffer stringBuffer = this.H;
        stringBuffer.delete(0, stringBuffer.length());
        this.G.clear();
    }

    public void e(java.lang.String str) {
        this.G.put(A, str);
        g();
    }

    public void e(boolean z2) {
        this.G.put(D, java.lang.String.valueOf(z2));
        g();
    }

    public int f() {
        return this.J;
    }

    public void f(java.lang.String str) {
        this.G.put(C, str);
        g();
    }

    public void f(boolean z2) {
        this.G.put(o, java.lang.String.valueOf(z2));
        g();
    }

    public void g(java.lang.String str) {
        this.G.put(n, str);
        g();
    }

    public void g(boolean z2) {
        this.G.put(F, java.lang.String.valueOf(z2));
        g();
    }

    public void h(java.lang.String str) {
        this.G.put(s, java.lang.String.valueOf(str));
        g();
    }

    public void h(boolean z2) {
        this.G.put(p, java.lang.String.valueOf(z2));
        g();
    }

    public void i(java.lang.String str) {
        this.G.put(E, str);
        g();
    }

    public java.lang.String toString() {
        h();
        return this.H.toString();
    }
}
