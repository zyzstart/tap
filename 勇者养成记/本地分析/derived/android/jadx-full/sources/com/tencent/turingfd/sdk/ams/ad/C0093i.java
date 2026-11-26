package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class C0093i {
    public static java.lang.String ea = "10.0.0.172";
    public java.net.HttpURLConnection fa = null;
    public boolean ga = false;
    public com.tencent.turingfd.sdk.ams.ad.C0093i.a ha;

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: com.tencent.turingfd.sdk.ams.ad.i$a */
    public static final class a {
        public static final com.tencent.turingfd.sdk.ams.ad.C0093i.a ib = new com.tencent.turingfd.sdk.ams.ad.C0093i.a("CONN_WIFI", 0);
        public static final com.tencent.turingfd.sdk.ams.ad.C0093i.a jb = new com.tencent.turingfd.sdk.ams.ad.C0093i.a("CONN_CMWAP", 1);
        public static final com.tencent.turingfd.sdk.ams.ad.C0093i.a kb = new com.tencent.turingfd.sdk.ams.ad.C0093i.a("CONN_CMNET", 2);
        public static final com.tencent.turingfd.sdk.ams.ad.C0093i.a lb = new com.tencent.turingfd.sdk.ams.ad.C0093i.a("CONN_NONE", 3);

        static {
            com.tencent.turingfd.sdk.ams.ad.C0093i.a[] aVarArr = {ib, jb, kb, lb};
        }

        public a(java.lang.String str, int i) {
            super(str, i);
        }
    }

    public C0093i(android.content.Context context) {
        com.tencent.turingfd.sdk.ams.ad.C0093i.a aVar;
        android.net.NetworkInfo activeNetworkInfo = null;
        this.ha = com.tencent.turingfd.sdk.ams.ad.C0093i.a.lb;
        try {
            activeNetworkInfo = ((android.net.ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        } catch (java.lang.Throwable unused) {
        }
        if (activeNetworkInfo == null || !(activeNetworkInfo.getState() == android.net.NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == android.net.NetworkInfo.State.CONNECTED)) {
            aVar = com.tencent.turingfd.sdk.ams.ad.C0093i.a.lb;
        } else if (activeNetworkInfo.getType() == 1) {
            aVar = com.tencent.turingfd.sdk.ams.ad.C0093i.a.ib;
        } else if (activeNetworkInfo.getType() != 0) {
            aVar = com.tencent.turingfd.sdk.ams.ad.C0093i.a.lb;
        } else if (android.net.Proxy.getDefaultHost() == null && android.net.Proxy.getHost(context) == null) {
            aVar = com.tencent.turingfd.sdk.ams.ad.C0093i.a.kb;
        } else {
            ea = android.net.Proxy.getDefaultHost();
            aVar = com.tencent.turingfd.sdk.ams.ad.C0093i.a.jb;
        }
        this.ha = aVar;
    }
}
