package com.tencent.turingfd.sdk.ams.ad;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class u {
    public static com.tencent.turingfd.sdk.ams.ad.u Ea = new com.tencent.turingfd.sdk.ams.ad.u();
    public com.tencent.turingfd.sdk.ams.ad.C0087c Fa;
    public android.os.Handler Ga;
    public com.tencent.turingfd.sdk.ams.ad.w Ia;
    public com.tencent.turingfd.sdk.ams.ad.r Ja;
    public boolean Ha = false;
    public java.util.concurrent.atomic.AtomicReference<java.lang.Boolean> Ka = new java.util.concurrent.atomic.AtomicReference<>(false);

    /* JADX INFO: Access modifiers changed from: private */
    class a extends android.os.Handler {
        public android.content.Context mContext;

        public a(android.os.Looper looper, android.content.Context context) {
            super(looper);
            this.mContext = context;
        }

        @Override // android.os.Handler
        public void handleMessage(android.os.Message message) {
            java.lang.System.currentTimeMillis();
            int i = message.what;
            if (i == 1) {
                com.tencent.turingfd.sdk.ams.ad.u.this.e(this.mContext);
            } else {
                if (i != 2) {
                    return;
                }
                com.tencent.turingfd.sdk.ams.ad.u uVar = com.tencent.turingfd.sdk.ams.ad.u.this;
                uVar.Ja = com.tencent.turingfd.sdk.ams.ad.u.a(uVar, this.mContext, true);
                com.tencent.turingfd.sdk.ams.ad.u.this.Ka.set(false);
            }
        }
    }

    public static /* synthetic */ com.tencent.turingfd.sdk.ams.ad.r a(com.tencent.turingfd.sdk.ams.ad.u uVar, android.content.Context context, boolean z) {
        int i;
        int i2;
        com.tencent.turingfd.sdk.ams.ad.x xVarA;
        byte[] byteArray;
        com.tencent.turingfd.sdk.ams.ad.r rVarA = uVar.a(context, 1, z);
        if (rVarA.sa != 0) {
            return rVarA;
        }
        byte[] bArr = rVarA.ta;
        if (bArr == null || bArr.length == 0) {
            return com.tencent.turingfd.sdk.ams.ad.r.a(-10003);
        }
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        byte[] bArr2 = rVarA.ta;
        java.lang.System.currentTimeMillis();
        com.tencent.turingfd.sdk.ams.ad.C0093i c0093i = new com.tencent.turingfd.sdk.ams.ad.C0093i(context);
        if (c0093i.ha == com.tencent.turingfd.sdk.ams.ad.C0093i.a.lb) {
            i = -1052;
        } else {
            try {
                java.net.URL url = new java.net.URL("https://tdid.m.qq.com?[REDACTED]");
                if (c0093i.ha == com.tencent.turingfd.sdk.ams.ad.C0093i.a.jb) {
                    c0093i.fa = (java.net.HttpURLConnection) url.openConnection(new java.net.Proxy(java.net.Proxy.Type.HTTP, new java.net.InetSocketAddress(com.tencent.turingfd.sdk.ams.ad.C0093i.ea, 80)));
                } else {
                    c0093i.fa = (java.net.HttpURLConnection) url.openConnection();
                }
                c0093i.fa.setReadTimeout(15000);
                c0093i.fa.setConnectTimeout(15000);
                i = 0;
            } catch (java.lang.IllegalArgumentException e) {
                i = -1057;
                e.printStackTrace();
            } catch (java.net.MalformedURLException e2) {
                i = -1053;
                e2.printStackTrace();
            } catch (java.io.IOException e3) {
                i = -1056;
                e3.printStackTrace();
            } catch (java.lang.SecurityException e4) {
                i = -1058;
                e4.printStackTrace();
            } catch (java.lang.UnsupportedOperationException e5) {
                i = -1059;
                e5.printStackTrace();
            } catch (java.lang.Exception e6) {
                i = -1000;
                e6.printStackTrace();
            }
        }
        if (i != 0) {
            i2 = i;
        } else {
            c0093i.ga = false;
            try {
                try {
                    int length = bArr2.length;
                    c0093i.fa.setDoOutput(true);
                    c0093i.fa.setDoInput(true);
                    c0093i.fa.setUseCaches(false);
                    c0093i.fa.setRequestMethod(com.tencent.connect.common.Constants.HTTP_POST);
                    c0093i.fa.setRequestProperty("User-Agent", "QQPimSecure");
                    c0093i.fa.setRequestProperty("Accept", "*/*");
                    c0093i.fa.setRequestProperty("Accept-Charset", com.unisound.b.f.b);
                    c0093i.fa.setRequestProperty("Content-Type", "application/octet-stream");
                    java.net.HttpURLConnection httpURLConnection = c0093i.fa;
                    java.lang.StringBuilder sb = new java.lang.StringBuilder();
                    sb.append("");
                    sb.append(length);
                    httpURLConnection.setRequestProperty("Content-length", sb.toString());
                    try {
                        if (android.os.Build.VERSION.SDK != null && android.os.Build.VERSION.SDK_INT > 13) {
                            c0093i.fa.setRequestProperty("Connection", cn.yunzhisheng.asr.JniUscClient.s);
                        }
                    } catch (java.lang.Exception unused) {
                    }
                    java.io.OutputStream outputStream = c0093i.fa.getOutputStream();
                    outputStream.write(bArr2);
                    outputStream.flush();
                    outputStream.close();
                    int responseCode = c0093i.fa.getResponseCode();
                    if (responseCode == 200) {
                        c0093i.ga = true;
                        i2 = 0;
                    } else {
                        i2 = responseCode == -1 ? oicq.wlogin_sdk.tools.util.E_LOGIN_THROUGH_WEB : (-2000) - responseCode;
                    }
                } catch (java.lang.IllegalAccessError e7) {
                    i2 = -2060;
                    e7.printStackTrace();
                }
            } catch (java.io.IOException e8) {
                i2 = -2056;
                e8.printStackTrace();
            } catch (java.lang.IllegalStateException e9) {
                i2 = -2061;
                e9.printStackTrace();
            } catch (java.net.ProtocolException e10) {
                i2 = -2051;
                e10.printStackTrace();
            } catch (java.lang.Exception e11) {
                e11.printStackTrace();
                i2 = oicq.wlogin_sdk.tools.util.E_LOGIN_THROUGH_WEB;
            }
        }
        if (i2 != 0) {
            xVarA = com.tencent.turingfd.sdk.ams.ad.x.a(i2 - 20000);
        } else {
            java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
            java.net.HttpURLConnection httpURLConnection2 = c0093i.fa;
            int i3 = -4000;
            if (httpURLConnection2 != null && c0093i.ga) {
                try {
                    java.io.InputStream inputStream = httpURLConnection2.getInputStream();
                    java.io.ByteArrayOutputStream byteArrayOutputStream = new java.io.ByteArrayOutputStream();
                    while (true) {
                        int i4 = inputStream.read();
                        if (i4 == -1) {
                            break;
                        }
                        byteArrayOutputStream.write(i4);
                    }
                    byteArray = byteArrayOutputStream.toByteArray();
                    i3 = 0;
                } catch (java.io.IOException e12) {
                    e12.printStackTrace();
                    byteArray = null;
                    i3 = -4056;
                } catch (java.lang.Exception e13) {
                    e13.printStackTrace();
                    byteArray = null;
                }
                atomicReference.set(byteArray);
                java.net.HttpURLConnection httpURLConnection3 = c0093i.fa;
                if (httpURLConnection3 != null) {
                    httpURLConnection3.disconnect();
                    c0093i.fa = null;
                }
            }
            xVarA = i3 != 0 ? com.tencent.turingfd.sdk.ams.ad.x.a(i3 - 20000) : new com.tencent.turingfd.sdk.ams.ad.x(0, (byte[]) atomicReference.get());
        }
        if (xVarA.getErrorCode() != 0) {
            return com.tencent.turingfd.sdk.ams.ad.r.a(xVarA.getErrorCode());
        }
        uVar.Ia.a(context, com.tencent.turingfd.sdk.ams.ad.C0086b.d(context), java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
        try {
            android.util.SparseArray<java.lang.Object> sparseArrayB = com.tencent.turingfd.sdk.ams.ad.TuringDIDService.aa.b(com.tencent.turingfd.sdk.ams.ad.C0086b.a(), xVarA.Na);
            int iA = com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayB);
            if (iA != 0) {
                return com.tencent.turingfd.sdk.ams.ad.r.a(iA);
            }
            java.lang.Integer num = (java.lang.Integer) com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayB, 102, java.lang.Integer.class);
            if (num == null) {
                return com.tencent.turingfd.sdk.ams.ad.r.a(-30000);
            }
            if (num.intValue() < 0) {
                return com.tencent.turingfd.sdk.ams.ad.r.a(num.intValue() - 30000);
            }
            java.lang.String str = (java.lang.String) com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayB, 101, java.lang.String.class);
            if (str == null) {
                str = "";
            }
            java.lang.String str2 = (java.lang.String) com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayB, 103, java.lang.String.class);
            if (str2 == null) {
                str2 = "";
            }
            java.lang.String str3 = (java.lang.String) com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayB, 104, java.lang.String.class);
            if (str3 == null) {
                str3 = "";
            }
            java.lang.String str4 = (java.lang.String) com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayB, 105, java.lang.String.class);
            if (str4 == null) {
                str4 = "";
            }
            java.lang.String str5 = (java.lang.String) com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayB, 106, java.lang.String.class);
            if (str5 == null) {
                str5 = "";
            }
            com.tencent.turingfd.sdk.ams.ad.r rVarBuild = com.tencent.turingfd.sdk.ams.ad.r.create(0).d(str2).a((java.lang.System.currentTimeMillis() / 1000) + 3600).f(str).g(str3).h(str4).e(str5).build();
            uVar.Ia.a(context, rVarBuild);
            return rVarBuild;
        } catch (java.lang.Throwable unused2) {
            return com.tencent.turingfd.sdk.ams.ad.r.a(-10007);
        }
    }

    public static com.tencent.turingfd.sdk.ams.ad.u getInstance() {
        return Ea;
    }

    public final com.tencent.turingfd.sdk.ams.ad.r a(android.content.Context context, int i, boolean z) {
        com.tencent.turingfd.sdk.ams.ad.C.a aVar;
        int i2;
        long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
        if (context.getSharedPreferences("turingfd_protect_105548_28_advertisersMini", 0).getInt("301", 0) >= 10) {
            return com.tencent.turingfd.sdk.ams.ad.r.a(-10005);
        }
        java.util.HashMap map = new java.util.HashMap();
        if (android.text.TextUtils.isEmpty(com.tencent.turingfd.sdk.ams.ad.C._a) && com.tencent.turingfd.sdk.ams.ad.C.Za.containsKey(com.tencent.turingfd.sdk.ams.ad.C.ab) && (aVar = com.tencent.turingfd.sdk.ams.ad.C.Za.get(com.tencent.turingfd.sdk.ams.ad.C.ab)) != null && (i2 = aVar.Ya) <= 3) {
            aVar.Ya = i2 + 1;
            com.tencent.turingfd.sdk.ams.ad.C._a = aVar.Xa.c(context);
        }
        java.lang.String str = com.tencent.turingfd.sdk.ams.ad.C._a;
        map.put("100", str);
        map.put("101", this.Fa.c());
        map.put("205", com.tencent.turingfd.sdk.ams.ad.z.k(context));
        map.put("207", this.Ia.j(context).qa);
        map.put("209", this.Fa.getUserId());
        map.put("210", com.tencent.turingfd.sdk.ams.ad.y.b(context, z));
        map.put("302", this.Ia.f(context));
        map.put("303", this.Ia.h(context));
        map.put("305", this.Ia.g(context));
        map.put("306", com.tencent.turingfd.sdk.ams.ad.z.h());
        if (z) {
            map.put("1001", "1");
        }
        com.tencent.turingfd.sdk.ams.ad.C0086b.a(context, "301", context.getSharedPreferences("turingfd_protect_105548_28_advertisersMini", 0).getInt("301", 0));
        try {
            android.util.SparseArray<java.lang.Object> sparseArrayA = com.tencent.turingfd.sdk.ams.ad.TuringDIDService.aa.a(new android.util.SparseArray(), context, map, i);
            com.tencent.turingfd.sdk.ams.ad.C0086b.a(context, "301", 0);
            this.Ia.b(context, java.lang.System.currentTimeMillis() - jCurrentTimeMillis);
            int iA = com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayA);
            byte[] bArr = (byte[]) com.tencent.turingfd.sdk.ams.ad.C0086b.a(sparseArrayA, 1, byte[].class);
            if (bArr == null) {
                bArr = new byte[0];
            }
            this.Ia.c(context, bArr.length);
            this.Fa.e();
            return iA == 0 ? new com.tencent.turingfd.sdk.ams.ad.r(0, bArr) : com.tencent.turingfd.sdk.ams.ad.r.a(iA);
        } catch (java.lang.Throwable unused) {
            return com.tencent.turingfd.sdk.ams.ad.r.a(-10006);
        }
    }

    public final com.tencent.turingfd.sdk.ams.ad.r a(android.content.Context context, boolean z) {
        java.lang.Object obj = new java.lang.Object();
        java.util.concurrent.atomic.AtomicReference atomicReference = new java.util.concurrent.atomic.AtomicReference();
        java.util.concurrent.atomic.AtomicReference atomicReference2 = new java.util.concurrent.atomic.AtomicReference();
        atomicReference2.set(false);
        atomicReference.set(com.tencent.turingfd.sdk.ams.ad.r.a(-10004));
        this.Ga.post(new com.tencent.turingfd.sdk.ams.ad.t(this, context, z, atomicReference, atomicReference2, obj));
        synchronized (obj) {
            try {
                int i = 2;
                if (com.tencent.turingfd.sdk.ams.ad.C0086b.d(context) != 2) {
                    i = 1;
                }
                obj.wait(this.Fa.getTimeout() * i);
            } catch (java.lang.InterruptedException unused) {
            }
        }
        atomicReference2.set(true);
        return (com.tencent.turingfd.sdk.ams.ad.r) atomicReference.get();
    }

    public final synchronized com.tencent.turingfd.sdk.ams.ad.r e(android.content.Context context) {
        char c;
        if (this.Ja == null) {
            this.Ja = this.Ia.j(context);
        }
        com.tencent.turingfd.sdk.ams.ad.r rVar = this.Ja;
        if (rVar.sa != 0) {
            c = 2;
        } else {
            c = java.lang.System.currentTimeMillis() / 1000 >= rVar.g() ? (char) 3 : (char) 1;
        }
        if (c == 1) {
            return this.Ja;
        }
        if (c == 2) {
            this.Ja = a(context, false);
        } else if (c == 3 && !this.Ka.get().booleanValue()) {
            this.Ka.set(true);
            this.Ga.sendEmptyMessage(2);
        }
        return this.Ja;
    }
}
