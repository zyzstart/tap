package qfc;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public final class c {
    private static long j;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1696a;

        static {
            int[] iArr = new int[qfc.f.values().length];
            f1696a = iArr;
            try {
                iArr[qfc.f.DOWNLOAD_CONFIG_EXCEPTION.ordinal()] = 1;
            } catch (java.lang.NoSuchFieldError unused) {
            }
            try {
                f1696a[qfc.f.DOWNLOAD_CONFIG_EMPTY.ordinal()] = 2;
            } catch (java.lang.NoSuchFieldError unused2) {
            }
            try {
                f1696a[qfc.f.DOWNLOAD_CONFIG_CONTENT_ERROR.ordinal()] = 3;
            } catch (java.lang.NoSuchFieldError unused3) {
            }
            try {
                f1696a[qfc.f.DOWNLOAD_CONFIG_CONTENT_NOT_JSON.ordinal()] = 4;
            } catch (java.lang.NoSuchFieldError unused4) {
            }
            try {
                f1696a[qfc.f.DOWNLOAD_CODE_EXCEPTION.ordinal()] = 5;
            } catch (java.lang.NoSuchFieldError unused5) {
            }
            try {
                f1696a[qfc.f.DOWNLOAD_REPORT_EXCEPTION.ordinal()] = 6;
            } catch (java.lang.NoSuchFieldError unused6) {
            }
        }
    }

    static class b implements java.lang.Runnable {
        private qfc.f b;

        private b() {
            this.b = qfc.f.SUCCESS;
        }

        /* synthetic */ b(byte b) {
            this();
        }

        private void a() {
            java.lang.String str;
            switch (qfc.c.a.f1696a[this.b.ordinal()]) {
                case 1:
                    str = "download cloud config is null. ";
                    break;
                case 2:
                    str = "download cloud config is empty. ";
                    break;
                case 3:
                    str = "download cloud config is error.";
                    break;
                case 4:
                    str = "content is not json format.";
                    break;
                case 5:
                    str = "download cloud config exception.";
                    break;
                case 6:
                    str = "report download result exception. ";
                    break;
                default:
                    str = "download cloud config success.";
                    break;
            }
            qfc.ac.j(str);
        }

        @Override // java.lang.Runnable
        public final void run() {
            qfc.f fVar;
            qfc.f fVar2;
            qfc.ac.j("CloudChecker download config thread start.");
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            java.util.HashMap map = new java.util.HashMap();
            try {
                java.lang.String strH = qfc.v.h();
                java.lang.String str = android.os.Build.MANUFACTURER;
                java.lang.String str2 = android.os.Build.MODEL;
                java.lang.String str3 = android.os.Build.VERSION.RELEASE;
                java.lang.String str4 = (qfc.u.c() ? "https://testcloud.tgpa.qq.com/cloud_ctrl" : "https://cloud.tgpa.qq.com/cloud_ctrl") + "plat_type=Android&os_version=" + str3 + "&manufacturer=" + str + "&model=" + str2 + "&pkg_name=" + strH + "&ver_code=8&ver_name=1.0.8";
                qfc.ac.j("request url: ".concat(java.lang.String.valueOf(str4)));
                qfc.ab abVar = new qfc.ab();
                abVar.ax = com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING;
                abVar.ay = com.tencent.smtt.sdk.TbsReaderView.ReaderCallback.GET_BAR_ANIMATING;
                java.lang.String strB = abVar.b(str4);
                try {
                    if (strB == null) {
                        fVar = qfc.f.DOWNLOAD_CONFIG_EXCEPTION;
                    } else {
                        if (!strB.isEmpty()) {
                            qfc.ac.j("CloudChecker download config content: ".concat(java.lang.String.valueOf(strB)));
                            try {
                                org.json.JSONObject jSONObject = new org.json.JSONObject(strB);
                                if (jSONObject.optInt("ret") == 0) {
                                    java.lang.String strOptString = jSONObject.optString(com.tencent.ysdk.shell.module.user.impl.freelogin.request.CloudGameFreeloginResponse.HTTP_RESP_PARAM_DATA);
                                    if (qfc.d.b().a(strOptString)) {
                                        java.io.FileOutputStream fileOutputStream = new java.io.FileOutputStream(qfc.v.d() + java.io.File.separator + "vmpcloudconfig.json");
                                        try {
                                            try {
                                                fileOutputStream.write(strOptString.getBytes());
                                            } catch (java.lang.Exception unused) {
                                                qfc.ac.j("FileUtil:saveFile: exception.");
                                            }
                                            fileOutputStream.close();
                                            qfc.ac.j("CloudChecker save config success.");
                                        } catch (java.lang.Throwable th) {
                                            fileOutputStream.close();
                                            throw th;
                                        }
                                    } else {
                                        fVar2 = qfc.f.PARSE_JSON_CONFIG_EXCEPTION;
                                    }
                                    long jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                                    map.put("run_time", java.lang.String.valueOf(jCurrentTimeMillis2));
                                    qfc.ac.j("CloudChecker download config thread run time: ".concat(java.lang.String.valueOf(jCurrentTimeMillis2)));
                                    qfc.ad.b(map);
                                    a();
                                }
                                fVar2 = qfc.f.DOWNLOAD_CONFIG_CONTENT_ERROR;
                                this.b = fVar2;
                            } catch (java.lang.Exception unused2) {
                                fVar = qfc.f.DOWNLOAD_CONFIG_CONTENT_NOT_JSON;
                                this.b = fVar;
                            }
                            long jCurrentTimeMillis3 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                            map.put("run_time", java.lang.String.valueOf(jCurrentTimeMillis3));
                            qfc.ac.j("CloudChecker download config thread run time: ".concat(java.lang.String.valueOf(jCurrentTimeMillis3)));
                            qfc.ad.b(map);
                            a();
                        }
                        fVar = qfc.f.DOWNLOAD_CONFIG_EMPTY;
                    }
                    long jCurrentTimeMillis4 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                    map.put("run_time", java.lang.String.valueOf(jCurrentTimeMillis4));
                    qfc.ac.j("CloudChecker download config thread run time: ".concat(java.lang.String.valueOf(jCurrentTimeMillis4)));
                    qfc.ad.b(map);
                } catch (java.lang.Exception unused3) {
                    this.b = qfc.f.DOWNLOAD_REPORT_EXCEPTION;
                }
                this.b = fVar;
                a();
            } catch (java.lang.Throwable th2) {
                try {
                    th2.printStackTrace();
                    this.b = qfc.f.DOWNLOAD_CODE_EXCEPTION;
                } finally {
                    try {
                        long jCurrentTimeMillis5 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                        map.put("run_time", java.lang.String.valueOf(jCurrentTimeMillis5));
                        qfc.ac.j("CloudChecker download config thread run time: ".concat(java.lang.String.valueOf(jCurrentTimeMillis5)));
                        qfc.ad.b(map);
                    } catch (java.lang.Exception unused4) {
                        this.b = qfc.f.DOWNLOAD_REPORT_EXCEPTION;
                    }
                    a();
                }
            }
        }
    }

    public static void a() {
        java.lang.String str;
        long j2;
        java.lang.String str2 = qfc.v.d() + java.io.File.separator + "vmpcloudconfig.json";
        if (qfc.aa.g(str2)) {
            try {
                qfc.ac.j("start to load local config . ");
                qfc.ac.j(qfc.d.b().a(qfc.aa.b(str2)) ? "parse local cloud config parse success." : "parse local cloud config parse exception, ple check it's content.");
            } catch (java.lang.Exception e) {
                e.printStackTrace();
                str = "read local cloud config exception.";
                qfc.ac.j(str);
            }
            j2 = j;
            if (j2 != 0 || java.lang.System.currentTimeMillis() - j2 > 21600000) {
                j = java.lang.System.currentTimeMillis();
                new java.lang.Thread(new qfc.c.b((byte) 0)).start();
            }
            return;
        }
        str = "no local cloud config was found.";
        qfc.ac.j(str);
        j2 = j;
        if (j2 != 0) {
        }
        j = java.lang.System.currentTimeMillis();
        new java.lang.Thread(new qfc.c.b((byte) 0)).start();
    }
}
