package com.tencent.tmapkupdatesdk.internal.logic.protocol;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class a implements java.lang.Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.lang.String f998a = "TMSelfUpdate_BaseHttpRequest";
    private com.qq.taf.jce.JceStruct b = null;
    private boolean c = false;

    protected void a() {
    }

    public void a(com.qq.taf.jce.JceStruct jceStruct) {
        this.b = jceStruct;
    }

    protected abstract void a(com.qq.taf.jce.JceStruct jceStruct, com.qq.taf.jce.JceStruct jceStruct2);

    protected abstract void b();

    public boolean c() {
        return this.c;
    }

    /* JADX WARN: Code duplicated, block: B:129:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:132:0x01cb A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x01e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:142:0x01dc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:151:0x01c1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:162:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:163:? A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x008f  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public void run() throws java.lang.Throwable {
        java.net.HttpURLConnection httpURLConnection;
        java.io.OutputStream outputStream;
        java.io.OutputStream outputStream2;
        java.net.HttpURLConnection httpURLConnection2;
        com.qq.taf.jce.JceStruct jceStructA;
        java.net.Proxy proxy;
        if (c()) {
            return;
        }
        a();
        com.qq.taf.jce.JceStruct jceStruct = this.b;
        if (jceStruct == null) {
            return;
        }
        byte[] bArrA = com.tencent.tmassistantbase.common.d.a(com.tencent.tmassistantbase.common.d.b(jceStruct));
        java.io.InputStream inputStream = null;
        try {
            try {
                java.lang.String strC = com.tencent.tmassistantbase.common.a.a().c();
                java.net.URL url = new java.net.URL(strC);
                com.tencent.tmassistantbase.util.x.a(f998a, "apkUpdate serverUrl=" + url);
                java.lang.String strA = com.tencent.tmapkupdatesdk.internal.b.a.a();
                if (android.text.TextUtils.isEmpty(strA)) {
                    httpURLConnection2 = null;
                } else {
                    if (strA.equalsIgnoreCase("cmwap") || strA.equalsIgnoreCase("3gwap") || strA.equalsIgnoreCase("uniwap")) {
                        proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(com.tencent.tmapkupdatesdk.internal.b.a.f995a, com.tencent.tmapkupdatesdk.internal.b.a.b));
                    } else if (strA.equalsIgnoreCase("ctwap")) {
                        proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(com.tencent.tmapkupdatesdk.internal.b.a.c, com.tencent.tmapkupdatesdk.internal.b.a.b));
                    } else {
                        httpURLConnection2 = null;
                    }
                    httpURLConnection2 = (java.net.HttpURLConnection) url.openConnection(proxy);
                }
                if (httpURLConnection2 == null) {
                    try {
                        httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
                    } catch (java.lang.Exception e) {
                        e = e;
                        httpURLConnection = httpURLConnection2;
                        outputStream2 = null;
                        e.printStackTrace();
                        b();
                        com.tencent.tmassistantbase.util.TMLog.e(f998a, "exception:", e);
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        if (outputStream2 != null) {
                            try {
                                outputStream2.close();
                            } catch (java.lang.Exception e3) {
                                e3.printStackTrace();
                            }
                        }
                        if (httpURLConnection == null) {
                        }
                        httpURLConnection.disconnect();
                    } catch (java.lang.Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        outputStream = null;
                        if (0 != 0) {
                            try {
                                inputStream.close();
                            } catch (java.lang.Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        if (outputStream != null) {
                            try {
                                outputStream.close();
                            } catch (java.lang.Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        if (httpURLConnection != null) {
                            throw th;
                        }
                        httpURLConnection.disconnect();
                        throw th;
                    }
                } else {
                    httpURLConnection = httpURLConnection2;
                }
                try {
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.addRequestProperty("User-Agent", "AssistantDownloader");
                    httpURLConnection.addRequestProperty("Content-Type", "application/octet-stream");
                    httpURLConnection.setConnectTimeout(30000);
                    httpURLConnection.setReadTimeout(30000);
                    outputStream2 = httpURLConnection.getOutputStream();
                    try {
                        outputStream2.write(bArrA);
                        outputStream2.flush();
                        outputStream2.close();
                        java.io.InputStream inputStream2 = httpURLConnection.getInputStream();
                        if (c()) {
                            com.tencent.tmassistantbase.util.TMLog.i(f998a, "request is cancel");
                            if (inputStream2 != null) {
                                try {
                                    inputStream2.close();
                                } catch (java.lang.Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            if (outputStream2 != null) {
                                try {
                                    outputStream2.close();
                                } catch (java.lang.Exception e7) {
                                    e7.printStackTrace();
                                }
                            }
                            if (httpURLConnection != null) {
                                httpURLConnection.disconnect();
                                return;
                            }
                            return;
                        }
                        com.tencent.tmassistantbase.util.TMLog.i(f998a, "url:" + strC + "; httpCode=" + httpURLConnection.getResponseCode());
                        if (httpURLConnection.getResponseCode() == 200 && inputStream2 != null) {
                            byte[] bArrA2 = com.tencent.tmassistantbase.util.f.a(inputStream2);
                            if (bArrA2 == null || bArrA2.length <= 4) {
                                com.tencent.tmassistantbase.util.TMLog.i(f998a, "onDataReceiveFailed()(data == null || data.length <= 4)");
                                b();
                            } else {
                                com.tencent.tmassistantbase.util.TMLog.i(f998a, "onDataReceiveSuccess(data != null && data.length > 4)");
                                com.tencent.tmassistantbase.jce.Response responseA = com.tencent.tmassistantbase.common.d.a(bArrA2);
                                if (responseA != null && responseA.body != null && (jceStructA = com.tencent.tmassistantbase.common.d.a(this.b, responseA.body)) != null) {
                                    a(this.b, jceStructA);
                                    if (inputStream2 != null) {
                                        try {
                                            inputStream2.close();
                                        } catch (java.lang.Exception e8) {
                                            e8.printStackTrace();
                                        }
                                    }
                                    if (outputStream2 != null) {
                                        try {
                                            outputStream2.close();
                                        } catch (java.lang.Exception e9) {
                                            e9.printStackTrace();
                                        }
                                    }
                                    if (httpURLConnection != null) {
                                        httpURLConnection.disconnect();
                                        return;
                                    }
                                    return;
                                }
                                com.tencent.tmassistantbase.util.TMLog.i(f998a, "jceResp == null || jceResp.body == null");
                            }
                        }
                        com.tencent.tmassistantbase.util.TMLog.i(f998a, "onDataReceiveFailed()");
                        b();
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
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
                        if (httpURLConnection == null) {
                            return;
                        }
                        httpURLConnection.disconnect();
                    } catch (java.lang.Exception e12) {
                        e = e12;
                        e.printStackTrace();
                        b();
                        com.tencent.tmassistantbase.util.TMLog.e(f998a, "exception:", e);
                        if (0 != 0) {
                            inputStream.close();
                        }
                        if (outputStream2 != null) {
                            outputStream2.close();
                        }
                        if (httpURLConnection == null) {
                        }
                    }
                } catch (java.lang.Exception e13) {
                    e = e13;
                    outputStream2 = null;
                    e.printStackTrace();
                    b();
                    com.tencent.tmassistantbase.util.TMLog.e(f998a, "exception:", e);
                    if (0 != 0) {
                        inputStream.close();
                    }
                    if (outputStream2 != null) {
                        outputStream2.close();
                    }
                    if (httpURLConnection == null) {
                    }
                    httpURLConnection.disconnect();
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    outputStream = null;
                    if (0 != 0) {
                        inputStream.close();
                    }
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (httpURLConnection != null) {
                        throw th;
                    }
                    httpURLConnection.disconnect();
                    throw th;
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Exception e14) {
            e = e14;
            httpURLConnection = null;
            outputStream2 = null;
        } catch (java.lang.Throwable th4) {
            th = th4;
            httpURLConnection = null;
            outputStream = null;
        }
    }
}
