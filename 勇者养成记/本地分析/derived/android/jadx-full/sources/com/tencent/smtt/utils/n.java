package com.tencent.smtt.utils;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class n {
    private static com.tencent.smtt.utils.n c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f981a;
    private java.io.File b = null;
    private java.lang.String d = "http://log.tbs.qq.com/ajax?[REDACTED]";
    private java.lang.String e = "http://log.tbs.qq.com/ajax?[REDACTED]";
    private java.lang.String f = "http://wup.imtt.qq.com:8080";
    private java.lang.String g = "http://log.tbs.qq.com/ajax?[REDACTED]";
    private java.lang.String h = "http://cfg.imtt.qq.com/tbs?[REDACTED]";
    private java.lang.String i = "http://log.tbs.qq.com/ajax?[REDACTED]";
    private java.lang.String j = "http://mqqad.html5.qq.com/adjs";
    private java.lang.String k = "http://log.tbs.qq.com/ajax?[REDACTED]";

    @android.annotation.TargetApi(11)
    private n(android.content.Context context) {
        this.f981a = null;
        com.tencent.smtt.utils.TbsLog.w("TbsCommonConfig", "TbsCommonConfig constructing...");
        this.f981a = context.getApplicationContext();
        g();
    }

    public static synchronized com.tencent.smtt.utils.n a() {
        return c;
    }

    public static synchronized com.tencent.smtt.utils.n a(android.content.Context context) {
        if (c == null) {
            c = new com.tencent.smtt.utils.n(context);
        }
        return c;
    }

    private synchronized void g() {
        java.io.BufferedInputStream bufferedInputStream = null;
        try {
            try {
                java.io.File fileH = h();
                if (fileH == null) {
                    com.tencent.smtt.utils.TbsLog.e("TbsCommonConfig", "Config file is null, default values will be applied");
                    return;
                }
                java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(fileH));
                try {
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(bufferedInputStream2);
                    java.lang.String property = properties.getProperty("pv_post_url", "");
                    if (!"".equals(property)) {
                        this.d = property;
                    }
                    java.lang.String property2 = properties.getProperty("wup_proxy_domain", "");
                    if (!"".equals(property2)) {
                        this.f = property2;
                    }
                    java.lang.String property3 = properties.getProperty("tbs_download_stat_post_url", "");
                    if (!"".equals(property3)) {
                        this.g = property3;
                    }
                    java.lang.String property4 = properties.getProperty("tbs_downloader_post_url", "");
                    if (!"".equals(property4)) {
                        this.h = property4;
                    }
                    java.lang.String property5 = properties.getProperty("tbs_log_post_url", "");
                    if (!"".equals(property5)) {
                        this.i = property5;
                    }
                    java.lang.String property6 = properties.getProperty("tips_url", "");
                    if (!"".equals(property6)) {
                        this.j = property6;
                    }
                    java.lang.String property7 = properties.getProperty("tbs_cmd_post_url", "");
                    if (!"".equals(property7)) {
                        this.k = property7;
                    }
                    java.lang.String property8 = properties.getProperty("pv_post_url_tk", "");
                    if (!"".equals(property8)) {
                        this.e = property8;
                    }
                    bufferedInputStream2.close();
                } catch (java.lang.Throwable th) {
                    th = th;
                    bufferedInputStream = bufferedInputStream2;
                    try {
                        java.io.StringWriter stringWriter = new java.io.StringWriter();
                        th.printStackTrace(new java.io.PrintWriter(stringWriter));
                        com.tencent.smtt.utils.TbsLog.e("TbsCommonConfig", "exceptions occurred1:" + stringWriter.toString());
                        if (bufferedInputStream != null) {
                            bufferedInputStream.close();
                        }
                    } catch (java.lang.Throwable th2) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.io.IOException e) {
                                e.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
            } catch (java.io.IOException e2) {
                e2.printStackTrace();
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
        }
    }

    private java.io.File h() {
        java.io.File file;
        java.lang.Throwable th;
        java.io.File file2;
        try {
            if (this.b == null) {
                java.lang.String str = this.f981a.getApplicationContext().getApplicationInfo().packageName;
                if (android.text.TextUtils.isEmpty(str)) {
                    file2 = new java.io.File(com.tencent.smtt.utils.f.a(this.f981a, 8));
                } else {
                    boolean z = true;
                    boolean z2 = this.f981a.getPackageManager().checkPermission(com.dodjoy.permissions.Permission.READ_EXTERNAL_STORAGE, str) == 0;
                    if (this.f981a.getPackageManager().checkPermission("android.permission.WRITE_EXTERNAL_STORAGE", str) != 0) {
                        z = false;
                    }
                    if (z2 || z) {
                        com.tencent.smtt.utils.TbsLog.i("TbsCommonConfig", "no permission,use sdcard default folder");
                        file2 = new java.io.File(com.tencent.smtt.utils.f.a(this.f981a, 5));
                    } else {
                        file2 = new java.io.File(com.tencent.smtt.utils.f.a(this.f981a, 8));
                    }
                }
                this.b = file2;
                if (this.b == null || !this.b.isDirectory()) {
                    return null;
                }
            }
            file = new java.io.File(this.b, "tbsnet.conf");
            if (!file.exists()) {
                com.tencent.smtt.utils.TbsLog.e("TbsCommonConfig", "Get file(" + file.getCanonicalPath() + ") failed!");
                return null;
            }
            try {
                com.tencent.smtt.utils.TbsLog.w("TbsCommonConfig", "pathc:" + file.getCanonicalPath());
            } catch (java.lang.Throwable th2) {
                th = th2;
                java.io.StringWriter stringWriter = new java.io.StringWriter();
                th.printStackTrace(new java.io.PrintWriter(stringWriter));
                com.tencent.smtt.utils.TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter.toString());
            }
            return file;
        } catch (java.lang.Throwable th3) {
            file = null;
            th = th3;
        }
        java.io.StringWriter stringWriter2 = new java.io.StringWriter();
        th.printStackTrace(new java.io.PrintWriter(stringWriter2));
        com.tencent.smtt.utils.TbsLog.e("TbsCommonConfig", "exceptions occurred2:" + stringWriter2.toString());
        return file;
    }

    public java.lang.String b() {
        return this.d;
    }

    public java.lang.String c() {
        return this.g;
    }

    public java.lang.String d() {
        return this.h;
    }

    public java.lang.String e() {
        return this.i;
    }

    public java.lang.String f() {
        return this.e;
    }
}
