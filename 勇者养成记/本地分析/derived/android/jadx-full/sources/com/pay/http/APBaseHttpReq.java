package com.pay.http;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class APBaseHttpReq extends java.lang.Thread {
    protected com.pay.http.IAPHttpAns httpAns;
    public com.pay.http.APBaseHttpParam httpParam;
    protected java.net.HttpURLConnection httpURLConnection;
    private boolean isStop = false;
    private byte[] resultContent;

    public APBaseHttpReq() {
        com.pay.http.APBaseHttpParam aPBaseHttpParam = new com.pay.http.APBaseHttpParam();
        this.httpParam = aPBaseHttpParam;
        aPBaseHttpParam.reqParam = new java.util.HashMap();
        this.httpParam.domain = com.pay.tool.APMidasTools.getSysServerDomain();
    }

    private void closeOutput() {
        try {
            if (this.httpURLConnection.getDoOutput()) {
                try {
                    this.httpURLConnection.getOutputStream().flush();
                    this.httpURLConnection.getOutputStream().close();
                } catch (java.lang.Throwable unused) {
                }
            }
        } catch (java.lang.Exception e) {
            com.tencent.midas.comm.APLog.i("closeOutput", e.toString());
        }
    }

    private void closeStream(java.io.InputStream inputStream, java.io.OutputStream outputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (java.lang.Exception unused) {
                return;
            }
        }
        if (outputStream != null) {
            outputStream.flush();
            outputStream.close();
        }
        this.httpURLConnection.disconnect();
    }

    private void createConnection() {
        java.net.URL url;
        java.lang.StringBuilder sb;
        java.lang.String str;
        try {
            url = new java.net.URL(this.httpParam.url);
        } catch (java.net.MalformedURLException e) {
            e.printStackTrace();
            url = null;
        }
        if (com.tencent.midas.api.APMidasPayAPI.env.equals(com.tencent.midas.api.APMidasPayAPI.ENV_TESTING)) {
            sb = new java.lang.StringBuilder();
            sb.append("URL = ");
            str = this.httpParam.url;
        } else {
            sb = new java.lang.StringBuilder();
            sb.append("URL = ");
            sb.append(this.httpParam.url);
            sb.append(" HOST = ");
            str = this.httpParam.defaultDomain;
        }
        sb.append(str);
        com.tencent.midas.comm.APLog.i("APHttp Request", sb.toString());
        this.httpAns.onStart(this);
        try {
            java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) url.openConnection();
            this.httpURLConnection = httpURLConnection;
            httpURLConnection.setConnectTimeout(this.httpParam.connectTimeout);
            this.httpURLConnection.setReadTimeout(this.httpParam.readTimeout);
            this.httpURLConnection.setRequestProperty("Host", this.httpParam.defaultDomain);
            this.httpURLConnection.setUseCaches(false);
        } catch (java.lang.Exception e2) {
            com.tencent.midas.comm.APLog.i("createConnection", e2.toString());
        }
    }

    private void initRequest() {
        constructParam();
        this.httpParam.constructUrl();
        preCreateConnection();
        createConnection();
        closeOutput();
        setHeader();
        setBody();
    }

    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:127:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:128:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:129:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x014d  */
    /* JADX WARN: Code duplicated, block: B:63:0x018d  */
    /* JADX WARN: Code duplicated, block: B:74:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:85:0x020b  */
    /* JADX WARN: Code duplicated, block: B:95:0x0254  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void requestProgress() throws java.lang.Throwable {
        java.lang.Exception e;
        java.io.InputStream inputStream;
        java.lang.StringBuilder sb;
        java.io.IOException e2;
        java.lang.Exception e3;
        java.lang.Exception e4;
        java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
        this.httpParam.begTime = java.lang.System.currentTimeMillis();
        initRequest();
        try {
            try {
                if (this.httpParam.sendType.equals(com.tencent.connect.common.Constants.HTTP_POST)) {
                    java.io.DataOutputStream dataOutputStream = new java.io.DataOutputStream(this.httpURLConnection.getOutputStream());
                    dataOutputStream.write(this.httpParam.urlParams.getBytes());
                    dataOutputStream.flush();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                closeStream(null, byteArrayOutputStream);
                if (this.httpParam.reqType.equals("https://")) {
                    com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                    try {
                        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("TLS");
                        sSLContext.init(null, null, new java.security.SecureRandom());
                        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext.getSocketFactory());
                    } catch (java.lang.Exception e5) {
                        com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally Exception" + e5.toString());
                    }
                }
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            try {
                th2.printStackTrace();
            } catch (java.net.SocketTimeoutException e6) {
                e4 = e6;
                inputStream = null;
                closeStream(inputStream, byteArrayOutputStream);
                tryAgain(-8, -1, e4, "网络响应超时,请检查网络");
                closeStream(inputStream, byteArrayOutputStream);
                if (this.httpParam.reqType.equals("https://")) {
                    com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                    try {
                        javax.net.ssl.SSLContext sSLContext2 = javax.net.ssl.SSLContext.getInstance("TLS");
                        sSLContext2.init(null, null, new java.security.SecureRandom());
                        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext2.getSocketFactory());
                    } catch (java.lang.Exception e7) {
                        e = e7;
                        sb = new java.lang.StringBuilder();
                        sb.append("finally Exception");
                        sb.append(e.toString());
                        com.tencent.midas.comm.APLog.e("APBaseHttpReq", sb.toString());
                    }
                }
            } catch (org.apache.http.conn.ConnectTimeoutException e8) {
                e3 = e8;
                inputStream = null;
                closeStream(inputStream, byteArrayOutputStream);
                tryAgain(-7, -1, e3, "网络连接超时,请检查网络");
                closeStream(inputStream, byteArrayOutputStream);
                if (this.httpParam.reqType.equals("https://")) {
                    com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                    try {
                        javax.net.ssl.SSLContext sSLContext3 = javax.net.ssl.SSLContext.getInstance("TLS");
                        sSLContext3.init(null, null, new java.security.SecureRandom());
                        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext3.getSocketFactory());
                    } catch (java.lang.Exception e9) {
                        e = e9;
                        sb = new java.lang.StringBuilder();
                        sb.append("finally Exception");
                        sb.append(e.toString());
                        com.tencent.midas.comm.APLog.e("APBaseHttpReq", sb.toString());
                    }
                }
            } catch (java.io.IOException e10) {
                e2 = e10;
                inputStream = null;
                tryAgain(com.pay.tool.APMidasTools.getErrorCodeFromException(e2), -1, e2, "网络连接异常,请检查网络");
                closeStream(inputStream, byteArrayOutputStream);
                if (this.httpParam.reqType.equals("https://")) {
                    com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                    try {
                        javax.net.ssl.SSLContext sSLContext4 = javax.net.ssl.SSLContext.getInstance("TLS");
                        sSLContext4.init(null, null, new java.security.SecureRandom());
                        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext4.getSocketFactory());
                    } catch (java.lang.Exception e11) {
                        e = e11;
                        sb = new java.lang.StringBuilder();
                        sb.append("finally Exception");
                        sb.append(e.toString());
                        com.tencent.midas.comm.APLog.e("APBaseHttpReq", sb.toString());
                    }
                }
            } catch (java.lang.Exception e12) {
                e = e12;
                inputStream = null;
                closeStream(inputStream, byteArrayOutputStream);
                tryAgain(-6, -1, e, "网络错误，请稍后再试");
                closeStream(inputStream, byteArrayOutputStream);
                if (this.httpParam.reqType.equals("https://")) {
                    com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                    try {
                        javax.net.ssl.SSLContext sSLContext5 = javax.net.ssl.SSLContext.getInstance("TLS");
                        sSLContext5.init(null, null, new java.security.SecureRandom());
                        javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext5.getSocketFactory());
                    } catch (java.lang.Exception e13) {
                        e = e13;
                        sb = new java.lang.StringBuilder();
                        sb.append("finally Exception");
                        sb.append(e.toString());
                        com.tencent.midas.comm.APLog.e("APBaseHttpReq", sb.toString());
                    }
                }
            } catch (java.lang.Throwable th3) {
                th = th3;
                closeStream(null, byteArrayOutputStream);
                if (this.httpParam.reqType.equals("https://")) {
                    com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                    javax.net.ssl.SSLContext sSLContext6 = javax.net.ssl.SSLContext.getInstance("TLS");
                    sSLContext6.init(null, null, new java.security.SecureRandom());
                    javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext6.getSocketFactory());
                }
                throw th;
            }
        }
        inputStream = this.httpURLConnection.getInputStream();
        try {
            if (this.httpURLConnection.getResponseCode() == 200) {
                byte[] bArr = new byte[1024];
                int i = 0;
                while (true) {
                    int i2 = inputStream.read(bArr);
                    if (i2 <= 0) {
                        this.resultContent = byteArrayOutputStream.toByteArray();
                        this.httpAns.onFinish(this);
                        sendReportData(0, 200);
                        break;
                    }
                    if (this.isStop) {
                        java.lang.Thread.currentThread().interrupt();
                        closeStream(inputStream, byteArrayOutputStream);
                        if (this.httpParam.reqType.equals("https://")) {
                            com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                            try {
                                javax.net.ssl.SSLContext sSLContext7 = javax.net.ssl.SSLContext.getInstance("TLS");
                                sSLContext7.init(null, null, new java.security.SecureRandom());
                                javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext7.getSocketFactory());
                                return;
                            } catch (java.lang.Exception e14) {
                                com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally Exception" + e14.toString());
                                return;
                            }
                        }
                        return;
                    }
                    byteArrayOutputStream.write(bArr, 0, i2);
                    int i3 = i + i2;
                    this.httpAns.onReceive(bArr, i2, i3, this);
                    i = i3;
                }
            } else {
                tryAgain(-10, this.httpURLConnection.getResponseCode(), null, "网络错误(错误码" + this.httpURLConnection.getResponseCode() + ")");
            }
            closeStream(inputStream, byteArrayOutputStream);
            if (this.httpParam.reqType.equals("https://")) {
                com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                try {
                    javax.net.ssl.SSLContext sSLContext8 = javax.net.ssl.SSLContext.getInstance("TLS");
                    sSLContext8.init(null, null, new java.security.SecureRandom());
                    javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext8.getSocketFactory());
                } catch (java.lang.Exception e15) {
                    e = e15;
                    sb = new java.lang.StringBuilder();
                    sb.append("finally Exception");
                    sb.append(e.toString());
                    com.tencent.midas.comm.APLog.e("APBaseHttpReq", sb.toString());
                }
            }
        } catch (java.net.SocketTimeoutException e16) {
            e4 = e16;
            closeStream(inputStream, byteArrayOutputStream);
            tryAgain(-8, -1, e4, "网络响应超时,请检查网络");
            closeStream(inputStream, byteArrayOutputStream);
            if (this.httpParam.reqType.equals("https://")) {
                com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                javax.net.ssl.SSLContext sSLContext9 = javax.net.ssl.SSLContext.getInstance("TLS");
                sSLContext9.init(null, null, new java.security.SecureRandom());
                javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext9.getSocketFactory());
            }
        } catch (org.apache.http.conn.ConnectTimeoutException e17) {
            e3 = e17;
            closeStream(inputStream, byteArrayOutputStream);
            tryAgain(-7, -1, e3, "网络连接超时,请检查网络");
            closeStream(inputStream, byteArrayOutputStream);
            if (this.httpParam.reqType.equals("https://")) {
                com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                javax.net.ssl.SSLContext sSLContext10 = javax.net.ssl.SSLContext.getInstance("TLS");
                sSLContext10.init(null, null, new java.security.SecureRandom());
                javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext10.getSocketFactory());
            }
        } catch (java.io.IOException e18) {
            e2 = e18;
            tryAgain(com.pay.tool.APMidasTools.getErrorCodeFromException(e2), -1, e2, "网络连接异常,请检查网络");
            closeStream(inputStream, byteArrayOutputStream);
            if (this.httpParam.reqType.equals("https://")) {
                com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                javax.net.ssl.SSLContext sSLContext11 = javax.net.ssl.SSLContext.getInstance("TLS");
                sSLContext11.init(null, null, new java.security.SecureRandom());
                javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext11.getSocketFactory());
            }
        } catch (java.lang.Exception e19) {
            e = e19;
            closeStream(inputStream, byteArrayOutputStream);
            tryAgain(-6, -1, e, "网络错误，请稍后再试");
            closeStream(inputStream, byteArrayOutputStream);
            if (this.httpParam.reqType.equals("https://")) {
                com.tencent.midas.comm.APLog.e("APBaseHttpReq", "finally https");
                javax.net.ssl.SSLContext sSLContext12 = javax.net.ssl.SSLContext.getInstance("TLS");
                sSLContext12.init(null, null, new java.security.SecureRandom());
                javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(sSLContext12.getSocketFactory());
            }
        }
    }

    private void sendReportData(int i, int i2) {
        if (this.httpParam.urlName.endsWith("log_data")) {
        }
    }

    private void tryAgain(int i, int i2, java.lang.Exception exc, java.lang.String str) throws java.lang.Throwable {
        sendReportData(i, i2);
        com.tencent.midas.comm.APLog.i("APBaseHttpReq", getClass().getName() + " tryAgain reqTimes = " + this.httpParam.requestTimes + " tryTimes = " + this.httpParam.reTryTimes);
        try {
            if (this.httpParam.requestTimes < this.httpParam.reTryTimes) {
                this.httpParam.constructReTryUrl();
                requestProgress();
                return;
            }
            try {
                if (this.httpParam.reqType.equals("https://")) {
                    for (java.lang.Throwable cause = exc; cause != null; cause = cause.getCause()) {
                        if (!(cause instanceof java.security.cert.CertificateExpiredException) && !(cause instanceof java.security.cert.CertificateNotYetValidException)) {
                        }
                        com.tencent.midas.comm.APLog.e("APBaseHttpReq", "您的设备系统时间不正确，请更改");
                        this.httpAns.onError(this, 1100, str);
                        return;
                    }
                }
                this.httpAns.onError(this, 1000, str);
                com.tencent.midas.comm.APLog.i("APBaseHttpReq", str);
                exc.printStackTrace();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } catch (java.lang.Exception unused) {
        }
    }

    public void constructParam() {
    }

    public byte[] getContent() {
        return this.resultContent;
    }

    public com.pay.http.IAPHttpAns getHttpAns() {
        return this.httpAns;
    }

    protected void preCreateConnection() {
    }

    public void requestAgain() throws java.lang.Throwable {
        requestProgress();
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() throws java.lang.Throwable {
        requestProgress();
        super.run();
    }

    protected void setBody() {
    }

    public void setContent(byte[] bArr) {
        this.resultContent = bArr;
    }

    protected void setHeader() {
    }

    public void setHttpAns(com.pay.http.IAPHttpAns iAPHttpAns) {
        this.httpAns = iAPHttpAns;
    }

    protected void setReportUrl(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        this.httpParam.setReportUrl(str, str2, str3);
    }

    protected void setUrl(java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        this.httpParam.setUrl(str, str2, str3, str4);
    }

    public void startRequest() {
        start();
    }

    public void stopRequest() {
        android.util.Log.i("APBaseHttpReq", "stopRequest");
        this.isStop = true;
        this.httpAns.onStop(this);
    }
}
