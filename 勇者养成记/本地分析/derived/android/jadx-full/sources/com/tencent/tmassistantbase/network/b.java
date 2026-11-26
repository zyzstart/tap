package com.tencent.tmassistantbase.network;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class b implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ java.lang.String f1045a;
    final /* synthetic */ com.tencent.tmassistantbase.network.a b;

    b(com.tencent.tmassistantbase.network.a aVar, java.lang.String str) {
        this.b = aVar;
        this.f1045a = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() {
        java.net.HttpURLConnection httpURLConnection;
        com.tencent.tmassistantbase.network.a aVar;
        java.net.URLConnection uRLConnectionOpenConnection;
        try {
            try {
                java.net.URL url = new java.net.URL("http://appicsh.qq.com/cgi-bin/appstage/yyb_get_userapp_info" + this.f1045a);
                java.lang.String strP = com.tencent.tmassistantbase.util.k.p();
                if (!android.text.TextUtils.isEmpty(strP)) {
                    if (strP.equalsIgnoreCase("cmwap") || strP.equalsIgnoreCase("3gwap") || strP.equalsIgnoreCase("uniwap")) {
                        java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(com.tencent.tmassistantbase.network.c.f1046a, com.tencent.tmassistantbase.network.c.b));
                        aVar = this.b;
                        uRLConnectionOpenConnection = url.openConnection(proxy);
                    } else if (strP.equalsIgnoreCase("ctwap")) {
                        java.net.Proxy proxy2 = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(com.tencent.tmassistantbase.network.c.c, com.tencent.tmassistantbase.network.c.b));
                        aVar = this.b;
                        uRLConnectionOpenConnection = url.openConnection(proxy2);
                    }
                    aVar.f1044a = (java.net.HttpURLConnection) uRLConnectionOpenConnection;
                }
                if (this.b.f1044a == null) {
                    this.b.f1044a = (java.net.HttpURLConnection) url.openConnection();
                }
                this.b.f1044a.setDoInput(true);
                this.b.f1044a.setConnectTimeout(30000);
                this.b.f1044a.setReadTimeout(30000);
                if (this.b.f1044a != null && this.b.f1044a.getResponseCode() == 200) {
                    this.b.b = this.b.f1044a.getInputStream();
                    if (this.b.b != null) {
                        byte[] bArrA = com.tencent.tmassistantbase.util.f.a(this.b.b);
                        if (bArrA == null || bArrA.length <= 0) {
                            com.tencent.tmassistantbase.util.TMLog.i("NetworkTask", "data invalidate");
                            this.b.a(null, 704);
                            java.io.InputStream inputStream = this.b.b;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                }
                                this.b.b = null;
                            }
                            java.net.HttpURLConnection httpURLConnection2 = this.b.f1044a;
                            if (httpURLConnection2 != null) {
                                httpURLConnection2.disconnect();
                                this.b.f1044a = null;
                                return;
                            }
                            return;
                        }
                        java.lang.String str = new java.lang.String(bArrA, com.unisound.b.f.b);
                        if (android.text.TextUtils.isEmpty(str)) {
                            com.tencent.tmassistantbase.util.TMLog.i("NetworkTask", "failed to convert byte[] to string");
                            this.b.a(null, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_IO_EXCEPTION);
                            java.io.InputStream inputStream2 = this.b.b;
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                }
                                this.b.b = null;
                            }
                            java.net.HttpURLConnection httpURLConnection3 = this.b.f1044a;
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                                this.b.f1044a = null;
                                return;
                            }
                            return;
                        }
                        org.json.JSONObject jSONObject = new org.json.JSONObject(str);
                        com.tencent.tmassistantbase.util.TMLog.i("NetworkTask", "success to received data");
                        this.b.a(jSONObject, 0);
                        java.io.InputStream inputStream3 = this.b.b;
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                            } catch (java.lang.Exception e3) {
                                e3.printStackTrace();
                            }
                            this.b.b = null;
                        }
                        java.net.HttpURLConnection httpURLConnection4 = this.b.f1044a;
                        if (httpURLConnection4 != null) {
                            httpURLConnection4.disconnect();
                            this.b.f1044a = null;
                            return;
                        }
                        return;
                    }
                }
                this.b.a(null, 704);
                java.io.InputStream inputStream4 = this.b.b;
                if (inputStream4 != null) {
                    try {
                        inputStream4.close();
                    } catch (java.lang.Exception e4) {
                        e4.printStackTrace();
                    }
                    this.b.b = null;
                }
                httpURLConnection = this.b.f1044a;
                if (httpURLConnection == null) {
                    return;
                }
            } catch (java.lang.Throwable th) {
                java.io.InputStream inputStream5 = this.b.b;
                if (inputStream5 != null) {
                    try {
                        inputStream5.close();
                    } catch (java.lang.Exception e5) {
                        e5.printStackTrace();
                    }
                    this.b.b = null;
                }
                java.net.HttpURLConnection httpURLConnection5 = this.b.f1044a;
                if (httpURLConnection5 == null) {
                    throw th;
                }
                httpURLConnection5.disconnect();
                this.b.f1044a = null;
                throw th;
            }
        } catch (java.net.ConnectException e6) {
            e6.printStackTrace();
            this.b.a(null, 1);
            java.io.InputStream inputStream6 = this.b.b;
            if (inputStream6 != null) {
                try {
                    inputStream6.close();
                } catch (java.lang.Exception e7) {
                    e7.printStackTrace();
                }
                this.b.b = null;
            }
            httpURLConnection = this.b.f1044a;
            if (httpURLConnection == null) {
                return;
            }
        } catch (java.net.SocketTimeoutException e8) {
            e8.printStackTrace();
            this.b.a(null, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SOCKET_TIMEOUT);
            java.io.InputStream inputStream7 = this.b.b;
            if (inputStream7 != null) {
                try {
                    inputStream7.close();
                } catch (java.lang.Exception e9) {
                    e9.printStackTrace();
                }
                this.b.b = null;
            }
            httpURLConnection = this.b.f1044a;
            if (httpURLConnection == null) {
                return;
            }
        } catch (java.lang.Exception e10) {
            e10.printStackTrace();
            this.b.a(null, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_UNKNOWN_EXCEPTION);
            java.io.InputStream inputStream8 = this.b.b;
            if (inputStream8 != null) {
                try {
                    inputStream8.close();
                } catch (java.lang.Exception e11) {
                    e11.printStackTrace();
                }
                this.b.b = null;
            }
            httpURLConnection = this.b.f1044a;
            if (httpURLConnection == null) {
                return;
            }
        }
        httpURLConnection.disconnect();
        this.b.f1044a = null;
    }
}
