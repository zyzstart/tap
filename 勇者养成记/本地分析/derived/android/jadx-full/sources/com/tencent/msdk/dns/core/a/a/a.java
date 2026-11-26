package com.tencent.msdk.dns.core.a.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a implements com.tencent.msdk.dns.core.a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f657a;

    public a() {
        this(false);
    }

    public a(boolean z) {
        this.f657a = z;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0083 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.tencent.msdk.dns.core.a.a
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public com.tencent.msdk.dns.core.a.a.b a(java.lang.String str) throws java.lang.Throwable {
        java.io.BufferedReader bufferedReader;
        com.tencent.msdk.dns.core.a.a.b bVarA;
        if (android.text.TextUtils.isEmpty(str)) {
            return com.tencent.msdk.dns.core.a.a.b.a();
        }
        com.tencent.msdk.dns.base.log.DnsLog.d("HttpDns(domain:%s) start.", str);
        java.io.BufferedReader bufferedReader2 = null;
        try {
            java.lang.String strD = com.tencent.msdk.dns.core.config.b.d();
            java.lang.String strF = this.f657a ? com.tencent.msdk.dns.core.config.b.f(com.tencent.msdk.dns.base.c.a.a(str, strD)) : com.tencent.msdk.dns.core.config.b.e(com.tencent.msdk.dns.base.c.a.a(str, strD));
            com.tencent.msdk.dns.base.log.DnsLog.d("httpDnsUrl:%s", strF);
            java.net.URLConnection uRLConnectionOpenConnection = new java.net.URL(strF).openConnection();
            uRLConnectionOpenConnection.setConnectTimeout(com.tencent.msdk.dns.core.config.b.e());
            uRLConnectionOpenConnection.setReadTimeout(com.tencent.msdk.dns.core.config.b.e());
            bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(uRLConnectionOpenConnection.getInputStream(), "UTF-8"));
            try {
                try {
                    bVarA = com.tencent.msdk.dns.core.a.c.b.a(com.tencent.msdk.dns.base.c.a.b(bufferedReader.readLine(), strD), com.tencent.msdk.dns.core.config.b.a());
                } catch (java.lang.Exception unused) {
                    bVarA = com.tencent.msdk.dns.core.a.a.b.a();
                    if (bufferedReader != null) {
                    }
                    return bVarA;
                }
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedReader2 = bufferedReader;
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (java.io.IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (java.lang.Exception unused3) {
            bufferedReader = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            if (bufferedReader2 != null) {
                bufferedReader2.close();
            }
            throw th;
        }
        try {
            bufferedReader.close();
        } catch (java.io.IOException unused4) {
        }
        return bVarA;
    }

    public java.lang.String toString() {
        return "HttpDnsImpl{mResolve4Inet6=" + this.f657a + '}';
    }
}
