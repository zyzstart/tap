package com.tencent.hlyyb.common.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class d implements javax.net.ssl.HostnameVerifier {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private java.lang.String f545a;

    public d(java.lang.String str) {
        this.f545a = str;
    }

    public final boolean equals(java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(this.f545a) || !(obj instanceof com.tencent.hlyyb.common.b.a.d)) {
            return false;
        }
        java.lang.String str = ((com.tencent.hlyyb.common.b.a.d) obj).f545a;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f545a.equals(str);
    }

    @Override // javax.net.ssl.HostnameVerifier
    public final boolean verify(java.lang.String str, javax.net.ssl.SSLSession sSLSession) {
        return javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(this.f545a, sSLSession);
    }
}
