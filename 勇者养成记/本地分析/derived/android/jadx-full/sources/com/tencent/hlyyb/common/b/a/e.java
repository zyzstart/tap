package com.tencent.hlyyb.common.b.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class e extends javax.net.ssl.SSLSocketFactory {
    private java.lang.String c;
    private final java.lang.String b = com.tencent.hlyyb.common.b.a.e.class.getSimpleName();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f546a = false;

    public e(java.lang.String str) {
        this.c = str;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket() {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        if (android.text.TextUtils.isEmpty(this.c)) {
            throw new java.io.IOException("Halley set empty bizHost");
        }
        android.util.Log.i(this.b, "customized createSocket. host: " + this.c);
        try {
            if (android.os.Build.VERSION.SDK_INT < 17) {
                javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) ((android.net.SSLCertificateSocketFactory) android.net.SSLCertificateSocketFactory.getInsecure(10000, new android.net.SSLSessionCache(com.tencent.hlyyb.common.a.a()))).createSocket(socket, this.c, i, z);
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
                sSLSocket.getClass().getMethod("setHostname", java.lang.String.class).invoke(sSLSocket, this.c);
                sSLSocket.startHandshake();
                return sSLSocket;
            }
            android.net.SSLCertificateSocketFactory sSLCertificateSocketFactory = (android.net.SSLCertificateSocketFactory) android.net.SSLCertificateSocketFactory.getInsecure(10000, new android.net.SSLSessionCache(com.tencent.hlyyb.common.a.a()));
            javax.net.ssl.SSLSocket sSLSocket2 = (javax.net.ssl.SSLSocket) sSLCertificateSocketFactory.createSocket(socket, this.c, i, z);
            sSLCertificateSocketFactory.setUseSessionTickets(sSLSocket2, true);
            sSLSocket2.setEnabledProtocols(sSLSocket2.getSupportedProtocols());
            sSLCertificateSocketFactory.setHostname(sSLSocket2, this.c);
            sSLSocket2.startHandshake();
            return sSLSocket2;
        } catch (java.lang.Throwable th) {
            this.f546a = true;
            throw new java.io.IOException("HalleySNI exception: " + th);
        }
    }

    public boolean equals(java.lang.Object obj) {
        if (android.text.TextUtils.isEmpty(this.c) || !(obj instanceof com.tencent.hlyyb.common.b.a.e)) {
            return false;
        }
        java.lang.String str = ((com.tencent.hlyyb.common.b.a.e) obj).c;
        if (android.text.TextUtils.isEmpty(str)) {
            return false;
        }
        return this.c.equals(str);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getDefaultCipherSuites() {
        return new java.lang.String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.lang.String[] getSupportedCipherSuites() {
        return new java.lang.String[0];
    }
}
