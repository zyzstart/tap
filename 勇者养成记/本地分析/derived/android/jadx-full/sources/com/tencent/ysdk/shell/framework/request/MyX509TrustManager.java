package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class MyX509TrustManager implements javax.net.ssl.X509TrustManager {
    private static volatile com.tencent.ysdk.shell.framework.request.MyX509TrustManager instance;
    javax.net.ssl.X509TrustManager sunJSSEX509TrustManager;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MyX509TrustManager() throws java.lang.Exception {
        java.security.KeyStore keyStore;
        java.io.FileInputStream fileInputStream;
        java.lang.Throwable th;
        javax.net.ssl.TrustManager[] trustManagers;
        try {
            keyStore = java.security.KeyStore.getInstance("JKS");
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            keyStore = null;
        }
        if (keyStore != null) {
            try {
                fileInputStream = new java.io.FileInputStream("trustedCerts");
                try {
                    keyStore.load(fileInputStream, "passphrase".toCharArray());
                    javax.net.ssl.TrustManagerFactory trustManagerFactory = javax.net.ssl.TrustManagerFactory.getInstance("SunX509", "SunJSSE");
                    trustManagerFactory.init(keyStore);
                    trustManagers = trustManagerFactory.getTrustManagers();
                    fileInputStream.close();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                fileInputStream = null;
                th = th3;
            }
        } else {
            javax.net.ssl.TrustManagerFactory trustManagerFactory2 = javax.net.ssl.TrustManagerFactory.getInstance(javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory2.init((java.security.KeyStore) null);
            trustManagers = trustManagerFactory2.getTrustManagers();
        }
        for (int i = 0; i < trustManagers.length; i++) {
            if (trustManagers[i] instanceof javax.net.ssl.X509TrustManager) {
                this.sunJSSEX509TrustManager = (javax.net.ssl.X509TrustManager) trustManagers[i];
                return;
            }
        }
        throw new java.lang.Exception("Couldn't initialize");
    }

    public static com.tencent.ysdk.shell.framework.request.MyX509TrustManager getInstance() {
        if (instance == null) {
            synchronized (com.tencent.ysdk.shell.framework.request.MyX509TrustManager.class) {
                if (instance == null) {
                    try {
                        instance = new com.tencent.ysdk.shell.framework.request.MyX509TrustManager();
                    } catch (java.lang.Exception e) {
                        e.printStackTrace();
                        instance = null;
                    }
                }
            }
        }
        return instance;
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        this.sunJSSEX509TrustManager.checkClientTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(java.security.cert.X509Certificate[] x509CertificateArr, java.lang.String str) throws java.security.cert.CertificateException {
        this.sunJSSEX509TrustManager.checkServerTrusted(x509CertificateArr, str);
    }

    @Override // javax.net.ssl.X509TrustManager
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return this.sunJSSEX509TrustManager.getAcceptedIssuers();
    }
}
