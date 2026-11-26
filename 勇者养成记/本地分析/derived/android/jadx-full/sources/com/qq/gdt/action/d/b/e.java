package com.qq.gdt.action.d.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.qq.gdt.action.d.b.d f92a;

    e(com.qq.gdt.action.d.b.d dVar) {
        this.f92a = dVar;
    }

    private static com.qq.gdt.action.d.b.j a(java.net.HttpURLConnection httpURLConnection) throws java.io.IOException {
        return new com.qq.gdt.action.d.b.j(httpURLConnection.getContentType(), httpURLConnection.getContentLength(), new java.io.BufferedInputStream(b(httpURLConnection)), httpURLConnection);
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, long j) {
        if (android.os.Build.VERSION.SDK_INT >= 19) {
            httpURLConnection.setFixedLengthStreamingMode(j);
        } else {
            httpURLConnection.setFixedLengthStreamingMode((int) j);
        }
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, com.qq.gdt.action.d.b.h hVar) throws java.lang.Throwable {
        httpURLConnection.setDoOutput(true);
        java.io.BufferedOutputStream bufferedOutputStream = null;
        if ((hVar.a() != null ? hVar.a().toString() : null) != null) {
            httpURLConnection.addRequestProperty("Content-Type", hVar.a().toString());
        }
        long jB = hVar.b();
        if (jB > 0) {
            a(httpURLConnection, jB);
            httpURLConnection.addRequestProperty("Content-Length", java.lang.Long.toString(jB));
        } else {
            httpURLConnection.setChunkedStreamingMode(0);
        }
        try {
            java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(httpURLConnection.getOutputStream());
            try {
                hVar.a(bufferedOutputStream2);
                com.qq.gdt.action.d.b.k.a(bufferedOutputStream2);
            } catch (java.lang.Throwable th) {
                th = th;
                bufferedOutputStream = bufferedOutputStream2;
                com.qq.gdt.action.d.b.k.a(bufferedOutputStream);
                throw th;
            }
        } catch (java.lang.Throwable th2) {
            th = th2;
        }
    }

    private static void a(java.net.HttpURLConnection httpURLConnection, java.util.Map<java.lang.String, java.lang.String> map) {
        for (java.util.Map.Entry<java.lang.String, java.lang.String> entry : map.entrySet()) {
            java.lang.String value = entry.getValue();
            if (value != null) {
                httpURLConnection.addRequestProperty(entry.getKey(), value);
            }
        }
    }

    private static java.io.InputStream b(java.net.HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getInputStream();
        } catch (java.io.IOException unused) {
            return httpURLConnection.getErrorStream();
        }
    }

    private static boolean b(com.qq.gdt.action.d.b.g gVar) {
        if (gVar.f() == null) {
            return false;
        }
        return com.tencent.connect.common.Constants.HTTP_POST.equals(gVar.e());
    }

    public com.qq.gdt.action.d.b.i a(com.qq.gdt.action.d.b.g gVar) throws java.lang.Throwable {
        java.net.HttpURLConnection httpURLConnection = (java.net.HttpURLConnection) new java.net.URL(gVar.a()).openConnection();
        httpURLConnection.setRequestMethod(gVar.e());
        httpURLConnection.setReadTimeout(this.f92a.b);
        httpURLConnection.setConnectTimeout(this.f92a.f90a);
        if (gVar.c() > 0) {
            httpURLConnection.setReadTimeout(gVar.c());
        }
        if (gVar.b() > 0) {
            httpURLConnection.setConnectTimeout(gVar.b());
        }
        httpURLConnection.setDoInput(true);
        java.util.Map<java.lang.String, java.lang.String> mapD = gVar.d();
        if (mapD != null && !mapD.isEmpty()) {
            a(httpURLConnection, mapD);
        }
        if (b(gVar)) {
            a(httpURLConnection, gVar.f());
        }
        httpURLConnection.connect();
        int responseCode = httpURLConnection.getResponseCode();
        java.lang.String responseMessage = httpURLConnection.getResponseMessage();
        java.util.Map<java.lang.String, java.util.List<java.lang.String>> headerFields = httpURLConnection.getHeaderFields();
        return new com.qq.gdt.action.d.b.i.a().a(gVar).a(responseCode).a(responseMessage).a(headerFields).a(a(httpURLConnection)).a();
    }

    public java.util.concurrent.Executor a() {
        return this.f92a.c;
    }
}
