package com.tencent.ysdk.shell.framework.request;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public abstract class BaseConnection {
    protected static final int CONNECT_TIMEOUT = 5000;
    protected static final int DEFAULT_READ_TIMEOUT = 10000;
    protected static final java.lang.String HTTP_REQ_COOKIE = "Cookie";
    protected static final java.lang.String HTTP_REQ_METHOD_GET = "GET";
    protected static final java.lang.String HTTP_REQ_METHOD_POST = "POST";
    protected static final java.lang.String HTTP_REQ_PROPERTY_CHARSET = "Accept-Charset";
    protected static final java.lang.String HTTP_REQ_PROPERTY_CONTENT_LENGTH = "Content-Length";
    protected static final java.lang.String HTTP_REQ_PROPERTY_CONTENT_TYPE = "Content-Type";
    protected static final java.lang.String HTTP_REQ_PROPERTY_ENCODING = "Accept-Encoding";
    protected static final java.lang.String HTTP_REQ_VALUE_CHARSET = "UTF-8";
    protected static final java.lang.String HTTP_REQ_VALUE_CONTENT_TYPE = "application/x-www-form-urlencoded";
    protected static final java.lang.String HTTP_REQ_VALUE_ENCODING = "gzip";
    public static final java.lang.String LOG_TAG = "YSDK_REQUEST";
    protected static int sRealReadTimeout;

    public BaseConnection() {
        if (sRealReadTimeout == 0) {
            int i = com.tencent.ysdk.shell.libware.util.CommonUtils.parseInt(com.tencent.ysdk.shell.framework.config.Config.readConfig(com.tencent.ysdk.shell.framework.config.Config.KEY_FRAMEWORK_REQUEST_TIME_OUT, ""), 10000);
            if (i > 0) {
                sRealReadTimeout = i;
            } else {
                sRealReadTimeout = 10000;
            }
        }
    }

    private void setURLConnectionCommonPara() {
        java.net.HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return;
        }
        uRLConnection.setConnectTimeout(5000);
        uRLConnection.setReadTimeout(sRealReadTimeout);
        uRLConnection.setUseCaches(false);
        uRLConnection.setRequestProperty(HTTP_REQ_PROPERTY_CHARSET, HTTP_REQ_VALUE_CHARSET);
        uRLConnection.setRequestProperty(HTTP_REQ_PROPERTY_CONTENT_TYPE, HTTP_REQ_VALUE_CONTENT_TYPE);
    }

    private void setURLConnectionCookie(java.util.HashMap<java.lang.String, java.lang.String> map) {
        java.net.HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            return;
        }
        java.lang.StringBuilder sb = new java.lang.StringBuilder(uRLConnection.getRequestProperty(HTTP_REQ_COOKIE));
        if (android.text.TextUtils.isEmpty(sb.toString())) {
            sb = new java.lang.StringBuilder();
        } else {
            sb.append(";");
        }
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            if (com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(entry.getKey()) || com.tencent.ysdk.libware.util.YSDKTextUtils.ckIsEmpty(entry.getValue())) {
                com.tencent.ysdk.shell.libware.file.Logger.d("cookie inf is bad");
            } else {
                sb.append(entry.getKey());
                sb.append("=");
                sb.append(entry.getValue());
                sb.append(";");
            }
        }
        uRLConnection.setRequestProperty(HTTP_REQ_COOKIE, sb.toString());
    }

    /* JADX WARN: Not initialized variable reg: 3, insn: 0x0056: MOVE (r1 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:29:0x0056 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected java.lang.String doGetRequest() throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.BufferedReader bufferedReader;
        java.lang.Exception e;
        java.io.BufferedReader bufferedReader2;
        java.lang.String string = "";
        java.io.BufferedReader bufferedReader3 = null;
        try {
            try {
                try {
                    java.net.HttpURLConnection uRLConnection = getURLConnection();
                    if (uRLConnection == null) {
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(null);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(null);
                        return "";
                    }
                    uRLConnection.setRequestMethod("GET");
                    inputStream = uRLConnection.getInputStream();
                    try {
                        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, HTTP_REQ_VALUE_CHARSET));
                        try {
                            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                            while (true) {
                                java.lang.String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                stringBuffer.append(line);
                            }
                            string = stringBuffer.toString();
                        } catch (javax.net.ssl.SSLHandshakeException unused) {
                            bufferedReader3 = bufferedReader;
                        } catch (java.lang.Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    } catch (javax.net.ssl.SSLHandshakeException unused2) {
                    } catch (java.lang.Exception e3) {
                        bufferedReader = null;
                        e = e3;
                    }
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                    return string;
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedReader3 = bufferedReader2;
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader3);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                    throw th;
                }
            } catch (javax.net.ssl.SSLHandshakeException unused3) {
                inputStream = null;
            } catch (java.lang.Exception e4) {
                bufferedReader = null;
                e = e4;
                inputStream = null;
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStream = null;
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader3);
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                throw th;
            }
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, "javax.net.ssl.SSLPeerUnverifiedException");
            com.tencent.ysdk.shell.framework.verification.UserTips.showHttpsErrorTips();
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader3);
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
            return string;
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected java.lang.String doPostRequest(byte[] bArr) throws java.lang.Throwable {
        java.io.InputStream inputStream;
        java.io.OutputStream outputStream = null;
        bufferedReader = null;
        java.io.BufferedReader bufferedReader = null;
        outputStream = null;
        try {
            java.net.HttpURLConnection uRLConnection = getURLConnection();
            if (uRLConnection == null) {
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(null);
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(null);
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(null);
                return "";
            }
            uRLConnection.setRequestMethod("POST");
            uRLConnection.setRequestProperty(HTTP_REQ_PROPERTY_ENCODING, HTTP_REQ_VALUE_ENCODING);
            uRLConnection.setRequestProperty(HTTP_REQ_PROPERTY_CONTENT_LENGTH, java.lang.String.valueOf(bArr.length));
            java.io.OutputStream outputStream2 = uRLConnection.getOutputStream();
            try {
                outputStream2.write(bArr);
                if (uRLConnection.getResponseCode() != 200) {
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(outputStream2);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(null);
                    com.tencent.ysdk.shell.libware.file.Closer.closeStream(null);
                    return "";
                }
                inputStream = uRLConnection.getInputStream();
                try {
                    bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStream, HTTP_REQ_VALUE_CHARSET));
                    try {
                        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
                        while (true) {
                            java.lang.String line = bufferedReader.readLine();
                            if (line == null) {
                                java.lang.String string = stringBuffer.toString();
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(outputStream2);
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader);
                                com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                                return string;
                            }
                            stringBuffer.append(line);
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        outputStream = outputStream2;
                        e.printStackTrace();
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(outputStream);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                        return "";
                    } catch (java.lang.Throwable th) {
                        th = th;
                        outputStream = outputStream2;
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(outputStream);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader);
                        com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                        throw th;
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    bufferedReader = null;
                } catch (java.lang.Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                outputStream = outputStream2;
                inputStream = outputStream;
            } catch (java.lang.Throwable th3) {
                th = th3;
                outputStream = outputStream2;
                inputStream = outputStream;
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(outputStream);
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader);
                com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
                throw th;
            }
        } catch (java.lang.Exception e4) {
            e = e4;
        } catch (java.lang.Throwable th4) {
            th = th4;
        }
        inputStream = outputStream;
        try {
            e.printStackTrace();
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(outputStream);
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader);
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
            return "";
        } catch (java.lang.Throwable th5) {
            th = th5;
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(outputStream);
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(bufferedReader);
            com.tencent.ysdk.shell.libware.file.Closer.closeStream(inputStream);
            throw th;
        }
    }

    public java.lang.String doRequest(com.tencent.ysdk.shell.framework.request.HttpRequest httpRequest) {
        java.net.HttpURLConnection uRLConnection = getURLConnection();
        if (uRLConnection == null) {
            com.tencent.ysdk.shell.libware.file.Logger.e(LOG_TAG, "URLConnection is null");
            return "";
        }
        setURLConnectionCommonPara();
        httpRequest.setURLConnectionCustomParam(uRLConnection);
        if (httpRequest.cookieInfo != null && httpRequest.cookieInfo.size() > 0) {
            setURLConnectionCookie(httpRequest.cookieInfo);
        }
        return httpRequest.data == null ? doGetRequest() : doPostRequest(httpRequest.data);
    }

    public int getResponseCode() {
        if (getURLConnection() == null) {
            return -1;
        }
        try {
            return getURLConnection().getResponseCode();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public java.lang.String getResponseMessage() {
        if (getURLConnection() == null) {
            return "";
        }
        try {
            return getURLConnection().getResponseMessage();
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return "";
        }
    }

    protected abstract java.net.HttpURLConnection getURLConnection();
}
