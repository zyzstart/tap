package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
@android.annotation.TargetApi(17)
public class k implements org.apache.http.conn.scheme.LayeredSocketFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final javax.net.ssl.HostnameVerifier f731a = new org.apache.http.conn.ssl.StrictHostnameVerifier();
    private static final android.net.SSLCertificateSocketFactory b = (android.net.SSLCertificateSocketFactory) android.net.SSLCertificateSocketFactory.getDefault(0, null);

    @Override // org.apache.http.conn.scheme.SocketFactory
    public java.net.Socket connectSocket(java.net.Socket socket, java.lang.String str, int i, java.net.InetAddress inetAddress, int i2, org.apache.http.params.HttpParams httpParams) throws java.io.IOException {
        socket.connect(new java.net.InetSocketAddress(str, i));
        return socket;
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public java.net.Socket createSocket() {
        return new java.net.Socket();
    }

    @Override // org.apache.http.conn.scheme.LayeredSocketFactory
    public java.net.Socket createSocket(java.net.Socket socket, java.lang.String str, int i, boolean z) throws java.io.IOException {
        com.tencent.open.log.SLog.v("openSDK_LOG.SNISocketFactory", "createSocket " + socket.toString() + " host:" + str + " port:" + i + " autoClose:" + z);
        java.net.InetAddress inetAddress = socket.getInetAddress();
        if (z) {
            socket.close();
        }
        javax.net.ssl.SSLSocket sSLSocket = (javax.net.ssl.SSLSocket) b.createSocket(inetAddress, i);
        sSLSocket.setEnabledProtocols(sSLSocket.getSupportedProtocols());
        if (android.os.Build.VERSION.SDK_INT >= 17) {
            com.tencent.open.log.SLog.v("openSDK_LOG.SNISocketFactory", "Setting SNI hostname");
            b.setHostname(sSLSocket, str);
        } else {
            com.tencent.open.log.SLog.v("openSDK_LOG.SNISocketFactory", "No documented SNI support on Android <4.2, trying with reflection");
            try {
                sSLSocket.getClass().getMethod("setHostname", java.lang.String.class).invoke(sSLSocket, str);
            } catch (java.lang.Exception unused) {
                com.tencent.open.log.SLog.v("openSDK_LOG.SNISocketFactory", "SNI not useable");
            }
        }
        if (f731a.verify(str, sSLSocket.getSession())) {
            return sSLSocket;
        }
        throw new javax.net.ssl.SSLPeerUnverifiedException("Cannot verify hostname: " + str);
    }

    @Override // org.apache.http.conn.scheme.SocketFactory
    public boolean isSecure(java.net.Socket socket) {
        if (socket instanceof javax.net.ssl.SSLSocket) {
            return ((javax.net.ssl.SSLSocket) socket).isConnected();
        }
        return false;
    }
}
