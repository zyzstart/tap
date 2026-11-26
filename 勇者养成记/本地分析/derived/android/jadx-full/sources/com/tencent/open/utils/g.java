package com.tencent.open.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static java.util.Map f725a = java.util.Collections.synchronizedMap(new java.util.HashMap());
    private static java.lang.String b = null;
    private android.content.Context c;
    private java.lang.String d;
    private org.json.JSONObject e = null;
    private long f = 0;
    private int g = 0;
    private boolean h = true;

    private g(android.content.Context context, java.lang.String str) {
        this.c = null;
        this.d = null;
        this.c = context.getApplicationContext();
        this.d = str;
        a();
        b();
    }

    public static com.tencent.open.utils.g a(android.content.Context context, java.lang.String str) {
        com.tencent.open.utils.g gVar;
        synchronized (f725a) {
            com.tencent.open.log.SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
            if (str != null) {
                b = str;
            }
            if (str == null) {
                str = b != null ? b : "0";
            }
            gVar = (com.tencent.open.utils.g) f725a.get(str);
            if (gVar == null) {
                gVar = new com.tencent.open.utils.g(context, str);
                f725a.put(str, gVar);
            }
            com.tencent.open.log.SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
        }
        return gVar;
    }

    private void a() {
        try {
            this.e = new org.json.JSONObject(c("com.tencent.open.config.json"));
        } catch (org.json.JSONException unused) {
            this.e = new org.json.JSONObject();
        }
    }

    private void a(java.lang.String str, java.lang.String str2) {
        try {
            if (this.d != null) {
                str = str + "." + this.d;
            }
            java.io.OutputStreamWriter outputStreamWriter = new java.io.OutputStreamWriter(this.c.openFileOutput(str, 0), java.nio.charset.Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(org.json.JSONObject jSONObject) {
        d("cgi back, do update");
        this.e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f = android.os.SystemClock.elapsedRealtime();
    }

    private void b() {
        if (this.g != 0) {
            d("update thread is running, return");
            return;
        }
        this.g = 1;
        final android.os.Bundle bundle = new android.os.Bundle();
        bundle.putString("appid", this.d);
        bundle.putString("appid_for_getting_config", this.d);
        bundle.putString("status_os", android.os.Build.VERSION.RELEASE);
        bundle.putString("status_machine", android.os.Build.MODEL);
        bundle.putString("status_version", android.os.Build.VERSION.SDK);
        bundle.putString("sdkv", com.tencent.connect.common.Constants.SDK_VERSION);
        bundle.putString("sdkp", "a");
        new java.lang.Thread() { // from class: com.tencent.open.utils.g.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.utils.g.this.a(com.tencent.open.utils.l.d(com.tencent.open.utils.HttpUtils.openUrl2(com.tencent.open.utils.g.this.c, "https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", com.tencent.connect.common.Constants.HTTP_GET, bundle).f734a));
                } catch (java.lang.Exception e) {
                    e.printStackTrace();
                }
                com.tencent.open.utils.g.this.g = 0;
            }
        }.start();
    }

    private java.lang.String c(java.lang.String str) {
        java.io.InputStream inputStreamOpen;
        java.io.BufferedReader bufferedReader;
        java.lang.StringBuffer stringBuffer;
        java.lang.String str2;
        java.lang.String string = "";
        try {
            try {
                if (this.d != null) {
                    str2 = str + "." + this.d;
                } else {
                    str2 = str;
                }
                inputStreamOpen = this.c.openFileInput(str2);
                while (true) {
                    try {
                        try {
                            try {
                                java.lang.String line = bufferedReader.readLine();
                                if (line == null) {
                                    break;
                                }
                                stringBuffer.append(line);
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        } catch (java.io.IOException e2) {
                            e2.printStackTrace();
                            inputStreamOpen.close();
                            bufferedReader.close();
                        }
                    } catch (java.lang.Throwable th) {
                        try {
                            inputStreamOpen.close();
                            bufferedReader.close();
                        } catch (java.io.IOException e3) {
                            e3.printStackTrace();
                        }
                        throw th;
                    }
                }
            } catch (java.io.IOException e4) {
                e4.printStackTrace();
                return "";
            }
        } catch (java.io.FileNotFoundException unused) {
            inputStreamOpen = this.c.getAssets().open(str);
        }
        bufferedReader = new java.io.BufferedReader(new java.io.InputStreamReader(inputStreamOpen, java.nio.charset.Charset.forName("UTF-8")));
        stringBuffer = new java.lang.StringBuffer();
        string = stringBuffer.toString();
        inputStreamOpen.close();
        bufferedReader.close();
        return string;
    }

    private void c() {
        int iOptInt = this.e.optInt("Common_frequency");
        if (iOptInt == 0) {
            iOptInt = 1;
        }
        if (android.os.SystemClock.elapsedRealtime() - this.f >= iOptInt * 3600000) {
            b();
        }
    }

    private void d(java.lang.String str) {
        if (this.h) {
            com.tencent.open.log.SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.d);
        }
    }

    public int a(java.lang.String str) {
        d("get " + str);
        c();
        return this.e.optInt(str);
    }

    public boolean b(java.lang.String str) {
        d("get " + str);
        c();
        java.lang.Object objOpt = this.e.opt(str);
        if (objOpt == null) {
            return false;
        }
        if (objOpt instanceof java.lang.Integer) {
            return !objOpt.equals(0);
        }
        if (objOpt instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) objOpt).booleanValue();
        }
        return false;
    }
}
