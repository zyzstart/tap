package com.tencent.ydkbeacon.base.net.adapter;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class b extends com.tencent.ydkbeacon.base.net.adapter.c {
    private com.tencent.ydkbeacon.base.net.a a(java.lang.String str, java.lang.String str2, java.util.Map map, byte[] bArr) throws java.lang.Throwable {
        java.net.HttpURLConnection httpURLConnectionA = a(str, str2, map);
        httpURLConnectionA.connect();
        java.io.OutputStream outputStream = httpURLConnectionA.getOutputStream();
        if (outputStream != null && bArr != null) {
            outputStream.write(bArr);
            outputStream.close();
        }
        return new com.tencent.ydkbeacon.base.net.a(httpURLConnectionA.getHeaderFields(), httpURLConnectionA.getResponseCode(), httpURLConnectionA.getResponseMessage(), a(httpURLConnectionA.getInputStream()));
    }

    private java.net.HttpURLConnection a(java.lang.String str, java.lang.String str2, java.util.Map map) throws java.net.ProtocolException {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(str).openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(10000);
        httpURLConnection.setRequestMethod(str2);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setDoInput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        for (java.util.Map.Entry entry : map.entrySet()) {
            httpURLConnection.setRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
        }
        return httpURLConnection;
    }

    private byte[] a(com.tencent.ydkbeacon.base.net.a.f fVar) {
        java.lang.String strB;
        int i = com.tencent.ydkbeacon.base.net.adapter.a.f1217a[fVar.a().ordinal()];
        if (i == 1) {
            return fVar.c();
        }
        if (i == 2) {
            strB = com.tencent.ydkbeacon.base.net.c.d.b(fVar.d());
        } else {
            if (i != 3) {
                return null;
            }
            strB = fVar.f();
        }
        return strB.getBytes("UTF-8");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private byte[] a(java.io.InputStream inputStream) throws java.lang.Throwable {
        java.io.ByteArrayOutputStream byteArrayOutputStream;
        java.lang.Throwable th;
        java.io.IOException e;
        try {
            byteArrayOutputStream = new java.io.ByteArrayOutputStream();
            try {
                try {
                    byte[] bArr = new byte[2048];
                    while (true) {
                        int i = inputStream.read(bArr);
                        if (i == -1) {
                            byteArrayOutputStream.flush();
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            byteArrayOutputStream.close();
                            inputStream.close();
                            com.tencent.ydkbeacon.a.e.b.a(inputStream, byteArrayOutputStream);
                            return byteArray;
                        }
                        byteArrayOutputStream.write(bArr, 0, i);
                        th = th;
                        com.tencent.ydkbeacon.a.e.b.a(inputStream, byteArrayOutputStream);
                        throw th;
                    }
                } catch (java.io.IOException e2) {
                    e = e2;
                    com.tencent.ydkbeacon.a.e.c.a(e);
                    com.tencent.ydkbeacon.a.e.b.a(inputStream, byteArrayOutputStream);
                    throw e;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.io.IOException e3) {
            byteArrayOutputStream = null;
            e = e3;
        } catch (java.lang.Throwable th3) {
            byteArrayOutputStream = null;
            th = th3;
        }
    }

    @Override // com.tencent.ydkbeacon.base.net.adapter.c
    public void a(com.tencent.ydkbeacon.base.net.a.f fVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        com.tencent.ydkbeacon.base.net.e eVar;
        java.lang.String strH = fVar.h();
        try {
            com.tencent.ydkbeacon.base.net.a aVarA = a(fVar.i(), fVar.g().name(), fVar.e(), a(fVar));
            if (aVarA.b != 200) {
                int i = aVarA.b;
                java.lang.StringBuilder sb = new java.lang.StringBuilder();
                sb.append("response status code != 2XX. msg: ");
                sb.append(aVarA.c);
                bVar.a(new com.tencent.ydkbeacon.base.net.e(strH, "452", i, sb.toString()));
            } else {
                bVar.a(aVarA);
            }
        } catch (java.net.ConnectException e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            eVar = new com.tencent.ydkbeacon.base.net.e(strH, "451", -1, "https connect timeout: " + e.getMessage(), e);
            bVar.a(eVar);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            eVar = new com.tencent.ydkbeacon.base.net.e(strH, "499", -1, "https connect error: " + th.getMessage(), th);
            bVar.a(eVar);
        }
    }

    @Override // com.tencent.ydkbeacon.base.net.adapter.c
    public void a(com.tencent.ydkbeacon.base.net.a.k kVar, com.tencent.ydkbeacon.base.net.a.b bVar) {
        com.tencent.ydkbeacon.base.net.e eVar;
        java.lang.String strName = kVar.g().name();
        try {
            com.tencent.ydkbeacon.base.net.a aVarA = a(kVar.h(), com.tencent.connect.common.Constants.HTTP_POST, kVar.d(), kVar.b());
            if (aVarA.b == 200) {
                if (com.tencent.ydkbeacon.base.net.c.d.a(aVarA.f1205a)) {
                    bVar.a(aVarA.d);
                    return;
                } else {
                    bVar.a(new com.tencent.ydkbeacon.base.net.e(strName, "454", aVarA.b, "server encrypt-status error!"));
                    return;
                }
            }
            int i = aVarA.b;
            java.lang.StringBuilder sb = new java.lang.StringBuilder();
            sb.append("response status code != 2XX. msg: ");
            sb.append(aVarA.c);
            bVar.a(new com.tencent.ydkbeacon.base.net.e(strName, "452", i, sb.toString()));
        } catch (java.net.ConnectException e) {
            com.tencent.ydkbeacon.a.e.c.a(e);
            eVar = new com.tencent.ydkbeacon.base.net.e(strName, "451", -1, "https connect timeout: " + e.getMessage(), e);
            bVar.a(eVar);
            com.tencent.ydkbeacon.base.net.d.c().b(this);
        } catch (java.lang.Throwable th) {
            com.tencent.ydkbeacon.a.e.c.a(th);
            eVar = new com.tencent.ydkbeacon.base.net.e(strName, "499", -1, "https connect error: " + th.getMessage(), th);
            bVar.a(eVar);
            com.tencent.ydkbeacon.base.net.d.c().b(this);
        }
    }
}
