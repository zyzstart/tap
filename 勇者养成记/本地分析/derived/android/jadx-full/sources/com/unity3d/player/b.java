package com.unity3d.player;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class b extends javax.net.ssl.SSLSocketFactory {
    private static volatile javax.net.ssl.SSLSocketFactory c;
    private static volatile javax.net.ssl.X509TrustManager d;
    private static final java.lang.Object e = new java.lang.Object[0];
    private static final java.lang.Object f = new java.lang.Object[0];
    private static final boolean g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final javax.net.ssl.SSLSocketFactory f1626a;
    private final com.unity3d.player.b.a b;

    class a implements javax.net.ssl.HandshakeCompletedListener {
        @Override // javax.net.ssl.HandshakeCompletedListener
        public final void handshakeCompleted(javax.net.ssl.HandshakeCompletedEvent handshakeCompletedEvent) {
            javax.net.ssl.SSLSession session = handshakeCompletedEvent.getSession();
            session.getCipherSuite();
            session.getProtocol();
            try {
                session.getPeerPrincipal().getName();
            } catch (javax.net.ssl.SSLPeerUnverifiedException unused) {
            }
        }
    }

    /* JADX INFO: renamed from: com.unity3d.player.b$b, reason: collision with other inner class name */
    public static abstract class AbstractC0073b implements javax.net.ssl.X509TrustManager {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected javax.net.ssl.X509TrustManager f1627a = com.unity3d.player.b.c();

        @Override // javax.net.ssl.X509TrustManager
        public final void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
            this.f1627a.checkClientTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
            this.f1627a.checkServerTrusted(x509CertificateArr, str);
        }

        @Override // javax.net.ssl.X509TrustManager
        public final java.security.cert.X509Certificate[] getAcceptedIssuers() {
            return this.f1627a.getAcceptedIssuers();
        }
    }

    static {
        boolean z = false;
        if (android.os.Build.VERSION.SDK_INT >= 16 && android.os.Build.VERSION.SDK_INT < 20) {
            z = true;
        }
        g = z;
    }

    private b(com.unity3d.player.b.AbstractC0073b[] abstractC0073bArr) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
        sSLContext.init(null, abstractC0073bArr, null);
        this.f1626a = sSLContext.getSocketFactory();
        this.b = null;
    }

    private java.net.Socket a(java.net.Socket socket) {
        if (socket != null && (socket instanceof javax.net.ssl.SSLSocket)) {
            if (g) {
                javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) socket;
                sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
            }
            com.unity3d.player.b.a aVar = this.b;
            if (aVar != null) {
                ((javax.net.ssl.SSLSocket) socket).addHandshakeCompletedListener(aVar);
            }
        }
        return socket;
    }

    public static javax.net.ssl.SSLSocketFactory a(com.unity3d.player.b.AbstractC0073b abstractC0073b) {
        try {
            return abstractC0073b == null ? b() : new com.unity3d.player.b(new com.unity3d.player.b.AbstractC0073b[]{abstractC0073b});
        } catch (java.lang.Exception e2) {
            com.unity3d.player.g.Log(5, "CustomSSLSocketFactory: Failed to create SSLSocketFactory (" + e2.getMessage() + ")");
            return null;
        }
    }

    private static javax.net.ssl.SSLSocketFactory b() {
        synchronized (e) {
            if (c != null) {
                return c;
            }
            com.unity3d.player.b bVar = new com.unity3d.player.b(null);
            c = bVar;
            return bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static javax.net.ssl.X509TrustManager c() {
        synchronized (f) {
            if (d != null) {
                return d;
            }
            try {
                javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init((java.security.KeyStore) null);
                for (javax.net.ssl.TrustManager trustManager : trustManagerFactory.getTrustManagers()) {
                    if (trustManager instanceof javax.net.ssl.X509TrustManager) {
                        javax.net.ssl.X509TrustManager x509TrustManager = (javax.net.ssl.X509TrustManager) trustManager;
                        d = x509TrustManager;
                        return x509TrustManager;
                    }
                }
            } catch (java.lang.Exception e2) {
                com.unity3d.player.g.Log(5, "CustomSSLSocketFactory: Failed to find X509TrustManager (" + e2.getMessage() + ")");
            }
            return null;
        }
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket() {
        return a(this.f1626a.createSocket());
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.lang.String str, int i) {
        return a(this.f1626a.createSocket(str, i));
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) {
        return a(this.f1626a.createSocket(str, i, inetAddress, i2));
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) {
        return a(this.f1626a.createSocket(inetAddress, i));
    }

    @Override // javax.net.SocketFactory
    public final java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) {
        return a(this.f1626a.createSocket(inetAddress, i, inetAddress2, i2));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) {
        return a(this.f1626a.createSocket(socket, str, i, z));
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.lang.String[] getDefaultCipherSuites() {
        return this.f1626a.getDefaultCipherSuites();
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public final java.lang.String[] getSupportedCipherSuites() {
        return this.f1626a.getSupportedCipherSuites();
    }
}
