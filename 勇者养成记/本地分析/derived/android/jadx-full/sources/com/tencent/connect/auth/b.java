package com.tencent.connect.auth;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static com.tencent.connect.auth.b f481a;
    static final /* synthetic */ boolean d = !com.tencent.connect.auth.b.class.desiredAssertionStatus();
    private static int e = 0;
    public java.util.HashMap b = new java.util.HashMap();
    public final java.lang.String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.tencent.tauth.IUiListener f482a;
        public com.tencent.connect.auth.a b;
        public java.lang.String c;
    }

    public static com.tencent.connect.auth.b a() {
        if (f481a == null) {
            f481a = new com.tencent.connect.auth.b();
        }
        return f481a;
    }

    public static int b() {
        int i = e + 1;
        e = i;
        return i;
    }

    public java.lang.String a(com.tencent.connect.auth.b.a aVar) {
        int iB = b();
        try {
            this.b.put("" + iB, aVar);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
        return "" + iB;
    }

    public java.lang.String c() {
        int iCeil = (int) java.lang.Math.ceil((java.lang.Math.random() * 20.0d) + 3.0d);
        char[] charArray = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        int length = charArray.length;
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        for (int i = 0; i < iCeil; i++) {
            double dRandom = java.lang.Math.random();
            double d2 = length;
            java.lang.Double.isNaN(d2);
            stringBuffer.append(charArray[(int) (dRandom * d2)]);
        }
        return stringBuffer.toString();
    }
}
