package com.tencent.tmassistantbase.network;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class g implements java.util.concurrent.Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ byte[] f1049a;
    final /* synthetic */ com.tencent.tmassistantbase.network.f b;

    g(com.tencent.tmassistantbase.network.f fVar, byte[] bArr) {
        this.b = fVar;
        this.f1049a = bArr;
    }

    /* JADX WARN: Code duplicated, block: B:178:0x0278 A[PHI: r0
  0x0278: PHI (r0v25 java.net.HttpURLConnection) = 
  (r0v11 java.net.HttpURLConnection)
  (r0v17 java.net.HttpURLConnection)
  (r0v23 java.net.HttpURLConnection)
  (r0v32 java.net.HttpURLConnection)
 binds: [B:127:0x01f6, B:143:0x0221, B:177:0x0276, B:159:0x0249] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:194:0x029d  */
    /* JADX WARN: Code duplicated, block: B:224:0x0285 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:228:0x028f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:240:? A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public java.lang.Integer call() throws java.lang.Throwable {
        java.io.OutputStream outputStream;
        java.io.InputStream inputStream;
        java.io.OutputStream outputStream2;
        java.net.HttpURLConnection httpURLConnection;
        java.net.HttpURLConnection httpURLConnection2;
        com.tencent.tmassistantbase.network.f fVar;
        java.net.URLConnection uRLConnectionOpenConnection;
        try {
            try {
                java.net.URL url = new java.net.URL(com.tencent.tmassistantbase.common.a.a().c());
                com.tencent.tmassistantbase.util.x.a("PostHttpRequest", "jxlhPush serverUrl=" + url);
                java.lang.String strP = com.tencent.tmassistantbase.util.k.p();
                if (!android.text.TextUtils.isEmpty(strP)) {
                    if (strP.equalsIgnoreCase("cmwap") || strP.equalsIgnoreCase("3gwap") || strP.equalsIgnoreCase("uniwap")) {
                        java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(com.tencent.tmassistantbase.network.c.f1046a, com.tencent.tmassistantbase.network.c.b));
                        fVar = this.b;
                        uRLConnectionOpenConnection = url.openConnection(proxy);
                    } else if (strP.equalsIgnoreCase("ctwap")) {
                        java.net.Proxy proxy2 = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(com.tencent.tmassistantbase.network.c.c, com.tencent.tmassistantbase.network.c.b));
                        fVar = this.b;
                        uRLConnectionOpenConnection = url.openConnection(proxy2);
                    }
                    fVar.b = (java.net.HttpURLConnection) uRLConnectionOpenConnection;
                }
                if (this.b.b == null) {
                    this.b.b = (java.net.HttpURLConnection) url.openConnection();
                }
                this.b.b.setDoOutput(true);
                this.b.b.setDoInput(true);
                this.b.b.setUseCaches(false);
                this.b.b.addRequestProperty("User-Agent", "AssistantDownloader");
                this.b.b.addRequestProperty("Content-Type", "application/octet-stream");
                this.b.b.setConnectTimeout(30000);
                this.b.b.setReadTimeout(30000);
                outputStream = this.b.b.getOutputStream();
                try {
                    outputStream.write(this.f1049a);
                    outputStream.flush();
                    inputStream = this.b.b.getInputStream();
                    try {
                        if (this.b.b.getResponseCode() != 200) {
                            this.b.a(this.f1049a, null, 701);
                            java.lang.Integer num = com.tencent.tmassistantbase.network.f.f1048a;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e) {
                                    e.printStackTrace();
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (java.lang.Exception e2) {
                                    e2.printStackTrace();
                                }
                            }
                            java.net.HttpURLConnection httpURLConnection3 = this.b.b;
                            if (httpURLConnection3 != null) {
                                httpURLConnection3.disconnect();
                                this.b.b = null;
                            }
                            return num;
                        }
                        if (inputStream == null) {
                            this.b.a(this.f1049a, null, 701);
                            java.lang.Integer num2 = com.tencent.tmassistantbase.network.f.f1048a;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (java.lang.Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            java.net.HttpURLConnection httpURLConnection4 = this.b.b;
                            if (httpURLConnection4 != null) {
                                httpURLConnection4.disconnect();
                                this.b.b = null;
                            }
                            return num2;
                        }
                        byte[] bArrA = com.tencent.tmassistantbase.util.f.a(inputStream);
                        if (bArrA == null || bArrA.length <= 4) {
                            this.b.a(this.f1049a, null, 701);
                            java.lang.Integer num3 = com.tencent.tmassistantbase.network.f.f1048a;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (java.lang.Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            java.net.HttpURLConnection httpURLConnection5 = this.b.b;
                            if (httpURLConnection5 != null) {
                                httpURLConnection5.disconnect();
                                this.b.b = null;
                            }
                            return num3;
                        }
                        this.b.a(this.f1049a, bArrA, 0);
                        java.lang.Integer num4 = com.tencent.tmassistantbase.network.f.f1048a;
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e7) {
                                e7.printStackTrace();
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e8) {
                                e8.printStackTrace();
                            }
                        }
                        java.net.HttpURLConnection httpURLConnection6 = this.b.b;
                        if (httpURLConnection6 != null) {
                            httpURLConnection6.disconnect();
                            this.b.b = null;
                        }
                        return num4;
                    } catch (java.net.ConnectException e9) {
                        e = e9;
                        java.net.ConnectException connectException = e;
                        outputStream2 = outputStream;
                        e = connectException;
                        try {
                            e.printStackTrace();
                            this.b.a(this.f1049a, null, 1);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e10) {
                                    e10.printStackTrace();
                                }
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (java.lang.Exception e11) {
                                    e11.printStackTrace();
                                }
                            }
                            httpURLConnection = this.b.b;
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                this.b.b = null;
                            }
                            return com.tencent.tmassistantbase.network.f.f1048a;
                        } catch (java.lang.Throwable th) {
                            th = th;
                            outputStream = outputStream2;
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (java.lang.Exception e12) {
                                    e12.printStackTrace();
                                }
                            }
                            if (outputStream != null) {
                                try {
                                    outputStream.close();
                                } catch (java.lang.Exception e13) {
                                    e13.printStackTrace();
                                }
                            }
                            httpURLConnection2 = this.b.b;
                            if (httpURLConnection2 != null) {
                                throw th;
                            }
                            httpURLConnection2.disconnect();
                            this.b.b = null;
                            throw th;
                        }
                    } catch (java.net.MalformedURLException e14) {
                        e = e14;
                        e.printStackTrace();
                        this.b.a(this.f1049a, null, 700);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e15) {
                                e15.printStackTrace();
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e16) {
                                e16.printStackTrace();
                            }
                        }
                        httpURLConnection = this.b.b;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            this.b.b = null;
                        }
                        return com.tencent.tmassistantbase.network.f.f1048a;
                    } catch (java.net.SocketTimeoutException e17) {
                        e = e17;
                        e.printStackTrace();
                        this.b.a(this.f1049a, null, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_SOCKET_TIMEOUT);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e19) {
                                e19.printStackTrace();
                            }
                        }
                        httpURLConnection = this.b.b;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            this.b.b = null;
                        }
                        return com.tencent.tmassistantbase.network.f.f1048a;
                    } catch (java.lang.Exception e20) {
                        e = e20;
                        e.printStackTrace();
                        this.b.a(this.f1049a, null, com.tencent.tmassistantbase.common.download.TMAssistantDownloadErrorCode.DownloadSDKErrorCode_UNKNOWN_EXCEPTION);
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e21) {
                                e21.printStackTrace();
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e22) {
                                e22.printStackTrace();
                            }
                        }
                        httpURLConnection = this.b.b;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            this.b.b = null;
                        }
                        return com.tencent.tmassistantbase.network.f.f1048a;
                    }
                } catch (java.net.ConnectException e23) {
                    e = e23;
                    inputStream = null;
                } catch (java.net.MalformedURLException e24) {
                    e = e24;
                    inputStream = null;
                } catch (java.net.SocketTimeoutException e25) {
                    e = e25;
                    inputStream = null;
                } catch (java.lang.Exception e26) {
                    e = e26;
                    inputStream = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    inputStream = null;
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    httpURLConnection2 = this.b.b;
                    if (httpURLConnection2 != null) {
                        throw th;
                    }
                    httpURLConnection2.disconnect();
                    this.b.b = null;
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.net.ConnectException e27) {
            e = e27;
            outputStream2 = null;
            inputStream = null;
        } catch (java.net.MalformedURLException e28) {
            e = e28;
            outputStream = null;
            inputStream = null;
        } catch (java.net.SocketTimeoutException e29) {
            e = e29;
            outputStream = null;
            inputStream = null;
        } catch (java.lang.Exception e30) {
            e = e30;
            outputStream = null;
            inputStream = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            outputStream = null;
            inputStream = null;
        }
    }
}
