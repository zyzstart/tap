package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class C {
    public static java.util.Map<java.lang.String, com.tencent.turingfd.sdk.ams.ad.C.a> Za = new java.util.concurrent.ConcurrentHashMap();
    public static java.lang.String _a = "";
    public static java.lang.String ab;

    static class a {
        public com.tencent.turingfd.sdk.ams.ad.A Xa;
        public int Ya = 0;

        public a(com.tencent.turingfd.sdk.ams.ad.A a2) {
            this.Xa = a2;
        }
    }

    static {
        new com.tencent.turingfd.sdk.ams.ad.G();
        Za.put("67843BC", new com.tencent.turingfd.sdk.ams.ad.C.a(new com.tencent.turingfd.sdk.ams.ad.J()));
        ab = "";
        try {
            ab = com.tencent.turingfd.sdk.ams.ad.C0086b.b(android.os.Build.BRAND.toUpperCase().getBytes()).substring(0, 7);
        } catch (java.lang.Throwable unused) {
        }
    }
}
