package com.dmlt.tracking.util;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class HttpUtil {
    public static int CONNECT_TIMEOUT = 1000;
    public static int READ_TIMEOUT = 1000;

    public interface OnRequestCallBack {
        void onError(java.lang.String str);

        void onSuccess(java.lang.String str);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.dmlt.tracking.util.HttpUtil$1] */
    public static void get(final java.lang.String str, final com.dmlt.tracking.util.HttpUtil.OnRequestCallBack onRequestCallBack) {
        com.dmlt.tracking.util.LogUtil.i("requestUrl: " + str);
        new java.lang.Thread() { // from class: com.dmlt.tracking.util.HttpUtil.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws java.lang.Throwable {
                com.dmlt.tracking.util.HttpUtil.getRequest(str, onRequestCallBack);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:66:0x0104 A[Catch: IOException -> 0x0100, TRY_LEAVE, TryCatch #6 {IOException -> 0x0100, blocks: (B:62:0x00fc, B:66:0x0104), top: B:73:0x00fc }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v5, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.io.InputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void getRequest(java.lang.String str, com.dmlt.tracking.util.HttpUtil.OnRequestCallBack onRequestCallBack) throws java.lang.Throwable {
        java.lang.String message;
        ?? inputStream;
        ?? r2;
        ?? r3;
        java.lang.String message2;
        ?? r7;
        java.io.ByteArrayOutputStream byteArrayOutputStream = null;
        boolean z = false;
        try {
            try {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_GET);
                    httpURLConnection.setConnectTimeout(CONNECT_TIMEOUT);
                    httpURLConnection.setReadTimeout(READ_TIMEOUT);
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setUseCaches(false);
                    httpURLConnection.connect();
                    httpURLConnection.getContentLength();
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            java.io.ByteArrayOutputStream byteArrayOutputStream2 = new java.io.ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream2.write(bArr, 0, i);
                                    }
                                }
                                java.lang.String string = byteArrayOutputStream2.toString();
                                com.dmlt.tracking.util.LogUtil.i("result:" + string);
                                message = string;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                z = true;
                                r7 = inputStream;
                            } catch (java.net.MalformedURLException e) {
                                r3 = inputStream;
                                e = e;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                message2 = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (r3 != 0) {
                                    r3.close();
                                }
                                message = message2;
                            } catch (java.io.IOException e2) {
                                r2 = inputStream;
                                e = e2;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                message2 = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream != null) {
                                    byteArrayOutputStream.close();
                                }
                                if (r2 != 0) {
                                    r2.close();
                                }
                                message = message2;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                byteArrayOutputStream = byteArrayOutputStream2;
                                if (byteArrayOutputStream != null) {
                                    try {
                                        byteArrayOutputStream.close();
                                        if (inputStream != 0) {
                                            inputStream.close();
                                        }
                                    } catch (java.io.IOException e3) {
                                        e3.getMessage();
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                } else if (inputStream != 0) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (java.net.MalformedURLException e4) {
                            r3 = inputStream;
                            e = e4;
                        } catch (java.io.IOException e5) {
                            r2 = inputStream;
                            e = e5;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    } else {
                        message = "请求失败 code:" + httpURLConnection.getResponseCode();
                        r7 = 0;
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (r7 != 0) {
                        r7.close();
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    inputStream = message;
                }
            } catch (java.net.MalformedURLException e6) {
                e = e6;
                r3 = 0;
            } catch (java.io.IOException e7) {
                e = e7;
                r2 = 0;
            } catch (java.lang.Throwable th4) {
                th = th4;
                inputStream = 0;
            }
        } catch (java.io.IOException e8) {
            message = e8.getMessage();
            e8.printStackTrace();
        }
        if (z) {
            onRequestCallBack.onSuccess(message);
        } else {
            onRequestCallBack.onError(message);
        }
    }

    @android.annotation.SuppressLint({"MissingPermission"})
    public static boolean isOpenNetwork(android.content.Context context) {
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager.getActiveNetworkInfo() != null) {
            return connectivityManager.getActiveNetworkInfo().isAvailable();
        }
        return false;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.dmlt.tracking.util.HttpUtil$2] */
    public static void post(final java.lang.String str, final java.lang.String str2, final com.dmlt.tracking.util.HttpUtil.OnRequestCallBack onRequestCallBack) {
        com.dmlt.tracking.util.LogUtil.i("requestUrl: " + str + ", params: " + str2);
        new java.lang.Thread() { // from class: com.dmlt.tracking.util.HttpUtil.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() throws java.lang.Throwable {
                com.dmlt.tracking.util.HttpUtil.postRequest(str, str2, onRequestCallBack);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:66:0x0120 A[Catch: IOException -> 0x011c, TRY_LEAVE, TryCatch #11 {IOException -> 0x011c, blocks: (B:62:0x0118, B:66:0x0120), top: B:74:0x0118 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.ByteArrayOutputStream] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v16, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r7v21 */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v14 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r8v5 */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r9v0, types: [com.dmlt.tracking.util.HttpUtil$OnRequestCallBack] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void postRequest(java.lang.String str, java.lang.String str2, com.dmlt.tracking.util.HttpUtil.OnRequestCallBack onRequestCallBack) throws java.lang.Throwable {
        ?? inputStream;
        java.lang.String message;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        ?? r7;
        ?? message2 = 0;
        byteArrayOutputStream = null;
        byteArrayOutputStream = null;
        message2 = 0;
        java.io.ByteArrayOutputStream byteArrayOutputStream2 = null;
        java.io.ByteArrayOutputStream byteArrayOutputStream3 = null;
        message2 = 0;
        boolean z = false;
        try {
            try {
                try {
                    java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
                    httpURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    httpURLConnection.setConnectTimeout(CONNECT_TIMEOUT);
                    httpURLConnection.setReadTimeout(READ_TIMEOUT);
                    httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (compatible; MSIE 9.0; Windows NT 6.1; Trident/5.0;");
                    httpURLConnection.setRequestProperty("Accept-Language", "zh-CN");
                    httpURLConnection.setRequestProperty("Connection", "Keep-Alive");
                    httpURLConnection.setRequestProperty("Charset", "UTF-8");
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.setUseCaches(false);
                    java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");
                    outputStreamWriter.write((java.lang.String) str2);
                    outputStreamWriter.flush();
                    httpURLConnection.connect();
                    httpURLConnection.getContentLength();
                    if (httpURLConnection.getResponseCode() == 200) {
                        inputStream = httpURLConnection.getInputStream();
                        try {
                            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                            try {
                                byte[] bArr = new byte[1024];
                                while (true) {
                                    int i = inputStream.read(bArr);
                                    if (i == -1) {
                                        break;
                                    } else {
                                        byteArrayOutputStream.write(bArr, 0, i);
                                    }
                                }
                                java.lang.String string = byteArrayOutputStream.toString();
                                com.dmlt.tracking.util.LogUtil.i("result:" + string);
                                z = true;
                                message2 = string;
                                r7 = inputStream;
                            } catch (java.net.MalformedURLException e) {
                                str2 = inputStream;
                                e = e;
                                byteArrayOutputStream2 = byteArrayOutputStream;
                                message = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream2 != null) {
                                    byteArrayOutputStream2.close();
                                }
                                if (str2 != 0) {
                                    str2.close();
                                }
                                message2 = message;
                            } catch (java.io.IOException e2) {
                                str2 = inputStream;
                                e = e2;
                                byteArrayOutputStream3 = byteArrayOutputStream;
                                message = e.getMessage();
                                e.printStackTrace();
                                if (byteArrayOutputStream3 != null) {
                                    byteArrayOutputStream3.close();
                                }
                                if (str2 != 0) {
                                    str2.close();
                                }
                                message2 = message;
                            } catch (java.lang.Throwable th) {
                                th = th;
                                message2 = byteArrayOutputStream;
                                if (message2 != 0) {
                                    try {
                                        message2.close();
                                        if (inputStream != 0) {
                                            inputStream.close();
                                        }
                                    } catch (java.io.IOException e3) {
                                        e3.getMessage();
                                        e3.printStackTrace();
                                        throw th;
                                    }
                                } else if (inputStream != 0) {
                                    inputStream.close();
                                }
                                throw th;
                            }
                        } catch (java.net.MalformedURLException e4) {
                            str2 = inputStream;
                            e = e4;
                        } catch (java.io.IOException e5) {
                            str2 = inputStream;
                            e = e5;
                        } catch (java.lang.Throwable th2) {
                            th = th2;
                        }
                    } else {
                        byteArrayOutputStream = null;
                        message2 = "请求失败 code:" + httpURLConnection.getResponseCode();
                        r7 = 0;
                    }
                    if (byteArrayOutputStream != null) {
                        byteArrayOutputStream.close();
                    }
                    if (r7 != 0) {
                        r7.close();
                    }
                } catch (java.io.IOException e6) {
                    message2 = e6.getMessage();
                    e6.printStackTrace();
                }
            } catch (java.net.MalformedURLException e7) {
                e = e7;
                str2 = 0;
            } catch (java.io.IOException e8) {
                e = e8;
                str2 = 0;
            } catch (java.lang.Throwable th3) {
                th = th3;
                inputStream = 0;
            }
            if (z) {
                onRequestCallBack.onSuccess(message2);
            } else {
                onRequestCallBack.onError(message2);
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            inputStream = str2;
        }
    }
}
