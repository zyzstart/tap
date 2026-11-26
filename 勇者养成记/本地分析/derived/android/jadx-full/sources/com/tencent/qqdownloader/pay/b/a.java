package com.tencent.qqdownloader.pay.b;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final org.apache.http.conn.ssl.StrictHostnameVerifier f757a;
    private final org.apache.http.conn.ssl.StrictHostnameVerifier b;
    private com.tencent.qqdownloader.pay.b.a.C0033a c;
    private java.lang.String d;
    private java.lang.String e;
    private int f;

    /* JADX INFO: renamed from: com.tencent.qqdownloader.pay.b.a$a, reason: collision with other inner class name */
    public static class C0033a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        java.lang.String f759a;
        java.lang.String c;
        java.lang.String e;
        android.content.Context g;
        java.lang.String h;
        int d = 0;
        com.tencent.qqdownloader.pay.b.a.b f = null;
        java.util.Map b = new java.util.HashMap();
        java.util.Map i = new java.util.HashMap();

        private C0033a(java.lang.String str, android.content.Context context) {
            this.f759a = "";
            this.h = "";
            this.f759a = str;
            this.g = context;
            this.h = com.tencent.qqdownloader.pay.a.a.b(context);
        }

        public static com.tencent.qqdownloader.pay.b.a.C0033a a(android.content.Context context) {
            return new com.tencent.qqdownloader.pay.b.a.C0033a(com.tencent.qqdownloader.pay.a.a.b(), context);
        }

        private void b() {
            com.tencent.qqdownloader.pay.c.b bVarG = com.tencent.qqdownloader.pay.a.a.g(this.g);
            if (android.text.TextUtils.isEmpty(this.e)) {
                this.e = java.lang.String.valueOf(java.lang.System.currentTimeMillis());
            }
            a("random", this.e);
            a("pkgName", this.h);
            a("imei", bVarG.b());
            a("imsi", bVarG.e());
            a(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_MAC, bVarG.c());
            a("androidId", bVarG.d());
            a("sdkVersion", java.lang.String.valueOf(bVarG.f()));
            a("deviceHeight", java.lang.String.valueOf(bVarG.g()));
            a("deviceWidth", java.lang.String.valueOf(bVarG.h()));
            a("module", bVarG.i());
            a("keyVer", java.lang.String.valueOf(this.d));
            a(com.tencent.ysdk.shell.module.stat.StatInterface.LOG_USER_PARAM_GUID, com.tencent.qqdownloader.pay.a.a.e(this.g));
            a("phoneBrand", c(android.os.Build.BRAND));
            a("phoneMode", c(android.os.Build.MODEL));
            a("pseudoId", com.tencent.qqdownloader.pay.c.b.a());
        }

        private java.lang.String c(java.lang.String str) {
            java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
            if (android.text.TextUtils.isEmpty(str)) {
                stringBuffer.append("NA");
            } else {
                char[] charArray = str.toCharArray();
                for (int i = 0; i < charArray.length; i++) {
                    if (charArray[i] > ' ' && charArray[i] != '/' && charArray[i] != '_' && charArray[i] != '&' && charArray[i] != '|' && charArray[i] != '-') {
                        stringBuffer.append(charArray[i]);
                    }
                }
            }
            return stringBuffer.toString();
        }

        public com.tencent.qqdownloader.pay.b.a.C0033a a(int i) {
            this.d = i;
            return this;
        }

        public com.tencent.qqdownloader.pay.b.a.C0033a a(com.tencent.qqdownloader.pay.b.a.b bVar) {
            this.f = bVar;
            return this;
        }

        public com.tencent.qqdownloader.pay.b.a.C0033a a(java.lang.String str) {
            this.e = str;
            return this;
        }

        public com.tencent.qqdownloader.pay.b.a.C0033a a(java.lang.String str, java.lang.String str2) {
            try {
                this.b.put(str, str2);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
            return this;
        }

        public com.tencent.qqdownloader.pay.b.a a() {
            com.tencent.qqdownloader.pay.b.a aVar = new com.tencent.qqdownloader.pay.b.a();
            b();
            aVar.c = this;
            return aVar;
        }

        public com.tencent.qqdownloader.pay.b.a.C0033a b(java.lang.String str) {
            this.c = str;
            return this;
        }
    }

    public interface b {
        void a(int i);

        void a(org.json.JSONObject jSONObject);
    }

    private a() {
        this.f757a = new org.apache.http.conn.ssl.StrictHostnameVerifier();
        this.b = new org.apache.http.conn.ssl.StrictHostnameVerifier();
        this.c = null;
        this.d = com.unisound.b.f.b;
        this.e = "";
        this.f = 200;
    }

    private javax.net.ssl.HttpsURLConnection a(java.net.URL url) throws java.security.NoSuchAlgorithmException, java.security.KeyManagementException {
        javax.net.ssl.HttpsURLConnection httpsURLConnection = (javax.net.ssl.HttpsURLConnection) url.openConnection();
        javax.net.ssl.SSLContext sSLContext = javax.net.ssl.SSLContext.getInstance("SSL");
        sSLContext.init(null, null, new java.security.SecureRandom());
        httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
        httpsURLConnection.setConnectTimeout(com.youme.im.CommonConst.SPEECH_DURATION_MAX);
        httpsURLConnection.setReadTimeout(com.youme.im.CommonConst.SPEECH_DURATION_MAX);
        httpsURLConnection.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
        httpsURLConnection.setDoOutput(true);
        httpsURLConnection.setDoInput(true);
        return httpsURLConnection;
    }

    private void a(int i) {
        com.tencent.qqdownloader.pay.b.a.b bVar = this.c.f;
        if (bVar != null) {
            bVar.a(i);
        }
    }

    private void a(java.lang.String str) {
        try {
            org.json.JSONObject jSONObject = new org.json.JSONObject(str);
            if (this.c.f != null) {
                this.c.f.a(jSONObject);
            }
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            a(-50);
        }
    }

    private void a(javax.net.ssl.HttpsURLConnection httpsURLConnection) throws java.io.IOException {
        java.lang.String strC = c();
        com.tencent.qqdownloader.pay.utils.i.a("http.post", "requestbody:" + strC);
        byte[] bytes = strC.toString().getBytes();
        httpsURLConnection.setRequestProperty("Content-Length", java.lang.String.valueOf(bytes.length));
        java.io.OutputStream outputStream = httpsURLConnection.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        outputStream.close();
    }

    private java.lang.String b() {
        try {
            return com.tencent.qqdownloader.pay.utils.a.a(com.tencent.qqdownloader.pay.utils.f.a(this.c.e, this.c.c));
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    private void b(javax.net.ssl.HttpsURLConnection httpsURLConnection) {
        java.util.Map map = this.c.i;
        if (map != null) {
            for (java.util.Map.Entry entry : map.entrySet()) {
                httpsURLConnection.setRequestProperty((java.lang.String) entry.getKey(), (java.lang.String) entry.getValue());
            }
        }
    }

    private java.lang.String c() {
        java.util.HashMap map = new java.util.HashMap();
        map.putAll(this.c.b);
        map.put("crypto", b());
        java.lang.StringBuffer stringBuffer = new java.lang.StringBuffer();
        if (!map.isEmpty()) {
            for (java.util.Map.Entry entry : map.entrySet()) {
                stringBuffer.append((java.lang.String) entry.getKey());
                stringBuffer.append('=');
                stringBuffer.append(java.net.URLEncoder.encode((java.lang.String) entry.getValue(), this.d));
                stringBuffer.append('&');
            }
            stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Code duplicated, block: B:32:0x006a  */
    /* JADX WARN: Code duplicated, block: B:34:0x006f  */
    /* JADX WARN: Code duplicated, block: B:52:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0077: MOVE (r0 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x0076 */
    /* JADX WARN: Type inference failed for: r6v0, types: [javax.net.ssl.HttpsURLConnection] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.io.InputStream] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private java.lang.String c(javax.net.ssl.HttpsURLConnection httpsURLConnection) throws java.lang.Throwable {
        java.lang.Exception e;
        java.io.InputStreamReader inputStreamReader;
        java.io.InputStreamReader inputStreamReader2;
        java.lang.Exception e2;
        this.f = httpsURLConnection.getResponseCode();
        com.tencent.qqdownloader.pay.utils.i.a("http.post", "recCode:" + this.f);
        if (this.f != 200) {
            return "";
        }
        java.io.InputStreamReader inputStreamReader3 = null;
        try {
            try {
                httpsURLConnection = httpsURLConnection.getInputStream();
                try {
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    inputStreamReader2 = new java.io.InputStreamReader((java.io.InputStream) httpsURLConnection, "UTF-8");
                    try {
                        char[] cArr = new char[1024];
                        while (true) {
                            int i = inputStreamReader2.read(cArr);
                            if (i == -1) {
                                break;
                            }
                            sb.append(cArr, 0, i);
                        }
                        java.lang.String string = sb.toString();
                        this.e = string;
                        if (httpsURLConnection != 0) {
                            httpsURLConnection.close();
                        }
                        inputStreamReader2.close();
                        return string;
                    } catch (java.lang.Exception e3) {
                        e2 = e3;
                        e2.printStackTrace();
                        if (httpsURLConnection != 0) {
                            httpsURLConnection.close();
                        }
                        if (inputStreamReader2 != null) {
                            return "";
                        }
                        inputStreamReader2.close();
                        return "";
                    }
                } catch (java.lang.Exception e4) {
                    e = e4;
                    inputStreamReader2 = null;
                    e2 = e;
                    e2.printStackTrace();
                    if (httpsURLConnection != 0) {
                        httpsURLConnection.close();
                    }
                    if (inputStreamReader2 != null) {
                        return "";
                    }
                    inputStreamReader2.close();
                    return "";
                } catch (java.lang.Throwable th) {
                    th = th;
                    if (httpsURLConnection != 0) {
                        httpsURLConnection.close();
                    }
                    if (inputStreamReader3 != null) {
                        inputStreamReader3.close();
                    }
                    throw th;
                }
            } catch (java.lang.Throwable th2) {
                th = th2;
                inputStreamReader3 = inputStreamReader;
            }
        } catch (java.lang.Exception e5) {
            e = e5;
            httpsURLConnection = 0;
        } catch (java.lang.Throwable th3) {
            th = th3;
            httpsURLConnection = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:16:0x0050 A[PHI: r0
  0x0050: PHI (r0v2 javax.net.ssl.HttpsURLConnection) = (r0v1 javax.net.ssl.HttpsURLConnection), (r0v4 javax.net.ssl.HttpsURLConnection) binds: [B:15:0x004e, B:9:0x003c] A[DONT_GENERATE, DONT_INLINE]] */
    public java.lang.String d() {
        this.e = "";
        javax.net.ssl.HttpsURLConnection httpsURLConnectionA = null;
        try {
            try {
                httpsURLConnectionA = a(new java.net.URL(this.c.f759a));
                b(httpsURLConnectionA);
                a(httpsURLConnectionA);
                java.lang.String strC = c(httpsURLConnectionA);
                this.e = strC;
                com.tencent.qqdownloader.pay.utils.i.a("http.post", strC.toString());
                if (android.text.TextUtils.isEmpty(this.e)) {
                    a(httpsURLConnectionA.getResponseCode());
                } else {
                    a(this.e);
                }
                if (httpsURLConnectionA != null) {
                    httpsURLConnectionA.disconnect();
                }
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                this.e = "";
                a(-52);
                if (0 != 0) {
                    httpsURLConnectionA.disconnect();
                }
            }
            return this.e;
        } catch (java.lang.Throwable th) {
            if (0 != 0) {
                httpsURLConnectionA.disconnect();
            }
            throw th;
        }
    }

    public void a() {
        com.tencent.qqdownloader.pay.b.b.a().a(new java.lang.Runnable() { // from class: com.tencent.qqdownloader.pay.b.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.qqdownloader.pay.b.a.this.d();
                } catch (org.apache.http.conn.ConnectTimeoutException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
