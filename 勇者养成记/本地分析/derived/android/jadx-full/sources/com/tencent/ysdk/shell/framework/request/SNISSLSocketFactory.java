package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class SNISSLSocketFactory extends javax.net.ssl.SSLSocketFactory {
    private static final java.lang.String TAG = "SNISSLSocketFactory";
    private javax.net.ssl.HttpsURLConnection mConn;

    public SNISSLSocketFactory(javax.net.ssl.HttpsURLConnection httpsURLConnection) {
        this.mConn = httpsURLConnection;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket() throws java.io.IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.lang.String str, int i, java.net.InetAddress inetAddress, int i2) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.SocketFactory
    public java.net.Socket createSocket(java.net.InetAddress inetAddress, int i, java.net.InetAddress inetAddress2, int i2) throws java.io.IOException {
        return null;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        java.lang.String requestProperty = this.mConn.getRequestProperty("Host");
        if (requestProperty != null) {
            str = requestProperty;
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "customized createSocket host is: " + str);
        java.net.InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        android.net.SSLCertificateSocketFactory sSLCertificateSocketFactory = (android.net.SSLCertificateSocketFactory) android.net.SSLCertificateSocketFactory.getDefault(0);
        javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) sSLCertificateSocketFactory.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "Setting SNI hostname");
            sSLCertificateSocketFactory.setHostname(sSLSocket, str);
        } else {
            com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "No documented SNI support on Android < 4.2, trying with reflection");
            try {
                sSLSocket.getClass().getMethod("setHostname", java.lang.String.class).invoke(sSLSocket, str);
            } catch (java.lang.Exception e) {
                com.tencent.ysdk.shell.libware.file.Logger.w(TAG, "SNI not useable" + e.getMessage());
            }
        }
        javax.net.ssl.SSLSession session = sSLSocket.getSession();
        if (!javax.net.ssl.HttpsURLConnection.getDefaultHostnameVerifier().verify(str, session)) {
            throw new javax.net.ssl.SSLPeerUnverifiedException("Cannot verify hostname: " + str);
        }
        com.tencent.ysdk.shell.libware.file.Logger.d(TAG, "Established " + session.getProtocol() + " connection with " + session.getPeerHost() + " using " + session.getCipherSuite());
        return sSLSocket;
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
