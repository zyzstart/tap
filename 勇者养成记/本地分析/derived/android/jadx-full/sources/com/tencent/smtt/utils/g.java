package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    public interface a {
        void a(int i);
    }

    public static java.lang.String a(java.lang.String str, java.util.Map map, byte[] bArr, com.tencent.smtt.utils.g.a aVar, boolean z) throws java.lang.Throwable {
        java.net.HttpURLConnection httpURLConnectionA;
        if (bArr == null || (httpURLConnectionA = a(str, map)) == null) {
            return null;
        }
        if (z) {
            a(httpURLConnectionA, bArr);
        } else {
            b(httpURLConnectionA, bArr);
        }
        return a(httpURLConnectionA, aVar, false);
    }

    public static java.lang.String a(java.lang.String str, byte[] bArr, com.tencent.smtt.utils.g.a aVar, boolean z) {
        try {
            java.lang.String str2 = str + (z ? com.tencent.smtt.utils.i.a().c() : com.tencent.smtt.utils.h.a().b());
            try {
                bArr = z ? com.tencent.smtt.utils.i.a().a(bArr) : com.tencent.smtt.utils.h.a().a(bArr);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            if (bArr == null) {
                return null;
            }
            java.util.HashMap map = new java.util.HashMap();
            map.put("Content-Type", "application/x-www-form-urlencoded");
            map.put("Content-Length", java.lang.String.valueOf(bArr.length));
            java.net.HttpURLConnection httpURLConnectionA = a(str2, map);
            if (httpURLConnectionA == null) {
                return null;
            }
            b(httpURLConnectionA, bArr);
            return a(httpURLConnectionA, aVar, z);
        } catch (java.lang.Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static java.lang.String a(java.net.HttpURLConnection httpURLConnection, com.tencent.smtt.utils.g.a aVar, boolean z) {
        java.lang.Throwable th;
        java.io.InputStream inflaterInputStream;
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.String str = null;
        try {
            int responseCode = httpURLConnection.getResponseCode();
            if (aVar != null) {
                aVar.a(responseCode);
            }
            if (responseCode == 200) {
                java.io.InputStream inputStream = httpURLConnection.getInputStream();
                java.lang.String contentEncoding = httpURLConnection.getContentEncoding();
                if (contentEncoding == null || !contentEncoding.equalsIgnoreCase("gzip")) {
                    inflaterInputStream = (contentEncoding == null || !contentEncoding.equalsIgnoreCase("deflate")) ? inputStream : new java.util.zip.InflaterInputStream(inputStream, new java.util.zip.Inflater(true));
                } else {
                    inflaterInputStream = new java.util.zip.GZIPInputStream(inputStream);
                }
                try {
                    byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[128];
                        while (true) {
                            int i = inflaterInputStream.read(bArr);
                            if (i == -1) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, i);
                        }
                        str = z ? new java.lang.String(byteArrayOutputStream.toByteArray(), com.unisound.b.f.b) : new java.lang.String(com.tencent.smtt.utils.h.a().c(byteArrayOutputStream.toByteArray()));
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        try {
                            th.printStackTrace();
                        } finally {
                            a(inflaterInputStream);
                            a(byteArrayOutputStream);
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                    byteArrayOutputStream = null;
                }
            } else {
                inflaterInputStream = null;
                byteArrayOutputStream = null;
            }
        } catch (java.lang.Throwable th4) {
            th = th4;
            inflaterInputStream = null;
            byteArrayOutputStream = null;
        }
        return str;
    }

    private static java.net.HttpURLConnection a(java.lang.String str, java.util.Map map) {
        java.lang.String str2;
        java.lang.String str3;
        java.net.HttpURLConnection httpURLConnection = null;
        try {
            java.net.HttpURLConnection httpURLConnection2 = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
            try {
                httpURLConnection2.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                httpURLConnection2.setDoOutput(true);
                httpURLConnection2.setDoInput(true);
                httpURLConnection2.setUseCaches(false);
                httpURLConnection2.setConnectTimeout(cn.yunzhisheng.asr.a.b);
                if (android.os.Build.VERSION.SDK_INT > 13) {
                    str2 = "Connection";
                    str3 = cn.yunzhisheng.asr.JniUscClient.s;
                } else {
                    str2 = "http.keepAlive";
                    str3 = "false";
                }
                httpURLConnection2.setRequestProperty(str2, str3);
                for (java.util.Map.Entry entry : map.entrySet()) {
                    httpURLConnection2.setRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
                }
                return httpURLConnection2;
            } catch (java.lang.Exception e) {
                e = e;
                httpURLConnection = httpURLConnection2;
                e.printStackTrace();
                return httpURLConnection;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
        }
    }

    private static void a(java.io.Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (java.lang.Exception unused) {
            }
        }
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, byte[] bArr) throws java.lang.Throwable {
        java.util.zip.GZIPOutputStream gZIPOutputStream;
        try {
            gZIPOutputStream = new java.util.zip.GZIPOutputStream(new java.io.BufferedOutputStream(httpURLConnection.getOutputStream(), 204800));
            try {
                try {
                    gZIPOutputStream.write(bArr);
                    gZIPOutputStream.flush();
                } catch (java.lang.Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (java.lang.Throwable th) {
                th = th;
                a(null);
                a(gZIPOutputStream);
                throw th;
            }
        } catch (java.lang.Exception e2) {
            e = e2;
            gZIPOutputStream = null;
        } catch (java.lang.Throwable th2) {
            th = th2;
            gZIPOutputStream = null;
            a(null);
            a(gZIPOutputStream);
            throw th;
        }
        a(null);
        a(gZIPOutputStream);
    }

    private static void b(java.net.HttpURLConnection httpURLConnection, byte[] bArr) {
        java.io.OutputStream outputStream = null;
        try {
            try {
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(bArr);
                outputStream.flush();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        } finally {
            a(outputStream);
        }
    }
}
