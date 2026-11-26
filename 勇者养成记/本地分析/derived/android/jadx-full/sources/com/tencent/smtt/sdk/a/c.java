package com.tencent.smtt.sdk.a;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class c {

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f906a = -1;
        public int b = -1;
        public java.lang.String c = "";
        public java.lang.String d = "0";
        public java.lang.String e = null;
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public java.lang.String f907a;
        public java.lang.String b;

        private b() {
            this.f907a = "";
            this.b = "";
        }
    }

    /* JADX WARN: Code duplicated, block: B:64:0x00ce A[PHI: r0 r2
  0x00ce: PHI (r0v11 com.tencent.smtt.sdk.a.c$b) = (r0v3 com.tencent.smtt.sdk.a.c$b), (r0v7 com.tencent.smtt.sdk.a.c$b), (r0v22 com.tencent.smtt.sdk.a.c$b) binds: [B:63:0x00cc, B:58:0x00b6, B:38:0x0078] A[DONT_GENERATE, DONT_INLINE]
  0x00ce: PHI (r2v4 android.content.Intent) = (r2v2 android.content.Intent), (r2v3 android.content.Intent), (r2v6 android.content.Intent) binds: [B:63:0x00cc, B:58:0x00b6, B:38:0x0078] A[DONT_GENERATE, DONT_INLINE]] */
    public static int a(android.content.Context context, java.lang.String str, java.util.HashMap map, com.tencent.smtt.sdk.WebView webView) {
        com.tencent.smtt.sdk.a.c.b bVarA;
        java.lang.String str2;
        java.lang.String str3;
        java.util.Set<java.lang.String> setKeySet;
        if (context == null) {
            return 3;
        }
        if (!a(str)) {
            str = "http://" + str;
        }
        try {
            android.net.Uri uri = android.net.Uri.parse(str);
            if (uri == null) {
                return 2;
            }
            com.tencent.smtt.sdk.a.c.a aVarA = a(context);
            int i = aVarA.f906a;
            if (i == -1) {
                return 4;
            }
            if (i == 2 && aVarA.b < 33) {
                return 5;
            }
            android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
            int i2 = aVarA.f906a;
            if (i2 == 2) {
                int i3 = aVarA.b;
                if (i3 < 33 || i3 > 39) {
                    int i4 = aVarA.b;
                    if (i4 >= 40 && i4 <= 45) {
                        str2 = com.tencent.smtt.sdk.TbsConfig.APP_QB;
                        str3 = "com.tencent.mtt.SplashActivity";
                    } else if (aVarA.b >= 46) {
                        intent = new android.content.Intent("com.tencent.QQBrowser.action.VIEW");
                        bVarA = a(context, uri);
                        if (bVarA != null && !android.text.TextUtils.isEmpty(bVarA.f907a)) {
                            intent.setClassName(bVarA.b, bVarA.f907a);
                        }
                    }
                } else {
                    str2 = com.tencent.smtt.sdk.TbsConfig.APP_QB;
                    str3 = "com.tencent.mtt.MainActivity";
                }
                intent.setClassName(str2, str3);
            } else if (i2 == 1) {
                int i5 = aVarA.b;
                if (i5 == 1) {
                    str2 = "com.tencent.qbx5";
                    str3 = "com.tencent.qbx5.MainActivity";
                } else if (i5 == 2) {
                    str2 = "com.tencent.qbx5";
                    str3 = "com.tencent.qbx5.SplashActivity";
                }
                intent.setClassName(str2, str3);
            } else if (i2 == 0) {
                int i6 = aVarA.b;
                if (i6 >= 4 && i6 <= 6) {
                    str2 = "com.tencent.qbx";
                    str3 = "com.tencent.qbx.SplashActivity";
                    intent.setClassName(str2, str3);
                } else if (aVarA.b > 6) {
                    intent = new android.content.Intent("com.tencent.QQBrowser.action.VIEW");
                    bVarA = a(context, uri);
                    if (bVarA != null && !android.text.TextUtils.isEmpty(bVarA.f907a)) {
                        intent.setClassName(bVarA.b, bVarA.f907a);
                    }
                }
            } else {
                intent = new android.content.Intent("com.tencent.QQBrowser.action.VIEW");
                bVarA = a(context, uri);
                if (bVarA != null && !android.text.TextUtils.isEmpty(bVarA.f907a)) {
                    intent.setClassName(bVarA.b, bVarA.f907a);
                }
            }
            intent.setData(uri);
            if (map != null && (setKeySet = map.keySet()) != null) {
                for (java.lang.String str4 : setKeySet) {
                    java.lang.String str5 = (java.lang.String) map.get(str4);
                    if (!android.text.TextUtils.isEmpty(str5)) {
                        intent.putExtra(str4, str5);
                    }
                }
            }
            try {
                intent.putExtra(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, d(context));
                intent.addFlags(268435456);
                if (webView != null) {
                    intent.putExtra("AnchorPoint", new android.graphics.Point(webView.getScrollX(), webView.getScrollY()));
                    intent.putExtra("ContentSize", new android.graphics.Point(webView.getContentWidth(), webView.getContentHeight()));
                }
                context.startActivity(intent);
                return 0;
            } catch (android.content.ActivityNotFoundException unused) {
                return 4;
            }
        } catch (java.lang.Exception unused2) {
            return 2;
        }
    }

    public static int a(android.content.Context context, java.lang.String str, java.util.HashMap map, java.lang.String str2, com.tencent.smtt.sdk.WebView webView) {
        boolean z;
        android.content.pm.PackageInfo packageInfo;
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            z = (packageManager == null || (packageInfo = packageManager.getPackageInfo(com.tencent.smtt.sdk.TbsConfig.APP_QB, 0)) == null || packageInfo.versionCode <= 601000) ? false : true;
        } catch (java.lang.Throwable unused) {
        }
        try {
            java.lang.String strEncode = java.net.URLEncoder.encode(str, "UTF-8");
            if (z) {
                str = strEncode;
            }
        } catch (java.lang.Exception unused2) {
            z = false;
        }
        java.lang.String str3 = z ? ",encoded=1" : "";
        sb.append("mttbrowser://url=");
        sb.append(str);
        sb.append(",product=");
        sb.append("TBS");
        sb.append(",packagename=");
        sb.append(context.getPackageName());
        sb.append(",from=");
        sb.append(str2);
        sb.append(",version=");
        sb.append(com.tencent.smtt.sdk.TbsConfig.TBS_SDK_VERSIONNAME);
        sb.append(str3);
        return a(context, sb.toString(), map, webView);
    }

    private static android.net.Uri a(android.content.Context context, java.lang.String str) {
        return com.tencent.smtt.utils.FileProvider.a(context, str);
    }

    public static com.tencent.smtt.sdk.a.c.a a(android.content.Context context) {
        boolean z = context.getApplicationContext().getSharedPreferences("x5_proxy_setting", 0).getBoolean("qb_install_status", false);
        com.tencent.smtt.sdk.a.c.a aVar = new com.tencent.smtt.sdk.a.c.a();
        if (z) {
            return aVar;
        }
        try {
            android.content.pm.PackageManager packageManager = context.getPackageManager();
            android.content.pm.PackageInfo packageInfo = null;
            try {
                packageInfo = packageManager.getPackageInfo(com.tencent.smtt.sdk.TbsConfig.APP_QB, 0);
                aVar.f906a = 2;
                aVar.e = com.tencent.smtt.sdk.TbsConfig.APP_QB;
                aVar.c = "ADRQB_";
                if (packageInfo != null && packageInfo.versionCode > 420000) {
                    aVar.b = packageInfo.versionCode;
                    aVar.c += packageInfo.versionName.replaceAll("\\.", "");
                    aVar.d = packageInfo.versionName.replaceAll("\\.", "");
                    return aVar;
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
            }
            try {
                try {
                    try {
                        try {
                            try {
                                packageInfo = packageManager.getPackageInfo("com.tencent.qbx", 0);
                                aVar.f906a = 0;
                                aVar.e = "com.tencent.qbx";
                                aVar.c = "ADRQBX_";
                            } catch (java.lang.Exception unused2) {
                            }
                        } catch (android.content.pm.PackageManager.NameNotFoundException unused3) {
                            packageInfo = packageManager.getPackageInfo("com.tencent.mtt.x86", 0);
                            aVar.e = "com.tencent.mtt.x86";
                            aVar.f906a = 2;
                            aVar.c = "ADRQB_";
                        }
                    } catch (android.content.pm.PackageManager.NameNotFoundException unused4) {
                        packageInfo = packageManager.getPackageInfo(com.tencent.smtt.sdk.TbsConfig.APP_QB, 0);
                        aVar.e = com.tencent.smtt.sdk.TbsConfig.APP_QB;
                        aVar.f906a = 2;
                        aVar.c = "ADRQB_";
                    }
                } catch (android.content.pm.PackageManager.NameNotFoundException unused5) {
                    packageInfo = packageManager.getPackageInfo("com.tencent.qbx5", 0);
                    aVar.f906a = 1;
                    aVar.e = "com.tencent.qbx5";
                    aVar.c = "ADRQBX5_";
                }
            } catch (java.lang.Exception unused6) {
                com.tencent.smtt.sdk.a.c.b bVarA = a(context, android.net.Uri.parse("http://mdc.html5.qq.com/mh?[REDACTED]"));
                if (bVarA != null && !android.text.TextUtils.isEmpty(bVarA.b)) {
                    packageInfo = packageManager.getPackageInfo(bVarA.b, 0);
                    aVar.e = bVarA.b;
                    aVar.f906a = 2;
                    aVar.c = "ADRQB_";
                }
            }
            if (packageInfo != null) {
                aVar.b = packageInfo.versionCode;
                aVar.c += packageInfo.versionName.replaceAll("\\.", "");
                aVar.d = packageInfo.versionName.replaceAll("\\.", "");
            }
        } catch (java.lang.Exception unused7) {
        }
        return aVar;
    }

    private static com.tencent.smtt.sdk.a.c.b a(android.content.Context context, android.net.Uri uri) {
        android.content.Intent intent = new android.content.Intent("com.tencent.QQBrowser.action.VIEW");
        intent.setData(uri);
        java.util.List<android.content.pm.ResolveInfo> listQueryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 0);
        if (listQueryIntentActivities.size() <= 0) {
            return null;
        }
        com.tencent.smtt.sdk.a.c.b bVar = new com.tencent.smtt.sdk.a.c.b();
        for (android.content.pm.ResolveInfo resolveInfo : listQueryIntentActivities) {
            java.lang.String str = resolveInfo.activityInfo.packageName;
            if (str.contains(com.tencent.smtt.sdk.TbsConfig.APP_QB)) {
                android.content.pm.ActivityInfo activityInfo = resolveInfo.activityInfo;
                bVar.f907a = activityInfo.name;
                bVar.b = activityInfo.packageName;
                return bVar;
            }
            if (str.contains("com.tencent.qbx")) {
                android.content.pm.ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                bVar.f907a = activityInfo2.name;
                bVar.b = activityInfo2.packageName;
            }
        }
        return bVar;
    }

    public static boolean a(android.content.Context context, long j, long j2) {
        boolean z;
        com.tencent.smtt.sdk.a.c.a aVarA = a(context);
        try {
            z = java.lang.Long.valueOf(aVarA.d).longValue() >= j;
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
        }
        if (aVarA.b >= j2) {
            return true;
        }
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x006c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:29:0x006d A[Catch: Exception -> 0x0099, TRY_LEAVE, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0010, B:8:0x0014, B:10:0x001a, B:12:0x002c, B:13:0x0030, B:16:0x0045, B:19:0x004e, B:21:0x0055, B:23:0x005f, B:25:0x0063, B:26:0x0066, B:29:0x006d, B:31:0x0083, B:33:0x0090, B:34:0x0095), top: B:39:0x0001 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x0090 A[Catch: Exception -> 0x0099, TryCatch #0 {Exception -> 0x0099, blocks: (B:3:0x0001, B:5:0x000a, B:7:0x0010, B:8:0x0014, B:10:0x001a, B:12:0x002c, B:13:0x0030, B:16:0x0045, B:19:0x004e, B:21:0x0055, B:23:0x005f, B:25:0x0063, B:26:0x0066, B:29:0x006d, B:31:0x0083, B:33:0x0090, B:34:0x0095), top: B:39:0x0001 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x006d, please report this as an issue */
    public static boolean a(android.content.Context context, java.lang.String str, int i, java.lang.String str2, java.util.HashMap map, android.os.Bundle bundle) {
        android.net.Uri uriA;
        java.lang.String str3;
        java.util.Set<java.lang.String> setKeySet;
        try {
            android.content.Intent intent = new android.content.Intent("com.tencent.QQBrowser.action.sdk.document");
            if (map != null && (setKeySet = map.keySet()) != null) {
                for (java.lang.String str4 : setKeySet) {
                    java.lang.String str5 = (java.lang.String) map.get(str4);
                    if (!android.text.TextUtils.isEmpty(str5)) {
                        intent.putExtra(str4, str5);
                    }
                }
            }
            new java.io.File(str);
            intent.putExtra("key_reader_sdk_id", 3);
            intent.putExtra("key_reader_sdk_type", i);
            if (i != 0) {
                str3 = i == 1 ? "key_reader_sdk_url" : "key_reader_sdk_path";
                intent.putExtra("key_reader_sdk_format", str2);
                if (context != null && context.getApplicationInfo().targetSdkVersion >= 24 && android.os.Build.VERSION.SDK_INT >= 24) {
                    intent.addFlags(1);
                }
                uriA = a(context, str);
                if (uriA == null) {
                    return false;
                }
                intent.setDataAndType(uriA, "mtt/" + str2);
                intent.putExtra(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, d(context.getApplicationContext()));
                if (bundle != null) {
                    intent.putExtra("key_reader_sdk_extrals", bundle);
                }
                context.startActivity(intent);
                return true;
            }
            intent.putExtra(str3, str);
            intent.putExtra("key_reader_sdk_format", str2);
            if (context != null) {
                intent.addFlags(1);
            }
            uriA = a(context, str);
            if (uriA == null) {
                return false;
            }
            intent.setDataAndType(uriA, "mtt/" + str2);
            intent.putExtra(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, d(context.getApplicationContext()));
            if (bundle != null) {
                intent.putExtra("key_reader_sdk_extrals", bundle);
            }
            context.startActivity(intent);
            return true;
        } catch (java.lang.Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean a(android.content.Context context, java.lang.String str, java.util.HashMap map) {
        boolean z;
        java.util.Set<java.lang.String> setKeySet;
        android.net.Uri uri = android.net.Uri.parse(str);
        android.content.Intent intent = new android.content.Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        intent.setDataAndType(uri, "video/*");
        if (map != null && (setKeySet = map.keySet()) != null) {
            for (java.lang.String str2 : setKeySet) {
                java.lang.String str3 = (java.lang.String) map.get(str2);
                if (!android.text.TextUtils.isEmpty(str3)) {
                    intent.putExtra(str2, str3);
                }
            }
        }
        try {
            intent.putExtra(com.tencent.ysdk.shell.module.stat.StatInterface.EVENT_PARAM_LOGIN_TYPE, d(context));
            intent.setComponent(new android.content.ComponentName(com.tencent.smtt.sdk.TbsConfig.APP_QB, "com.tencent.mtt.browser.video.H5VideoThrdcallActivity"));
            context.startActivity(intent);
            z = true;
        } catch (java.lang.Throwable unused) {
            z = false;
        }
        if (!z) {
            try {
                intent.setComponent(null);
                context.startActivity(intent);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private static boolean a(java.lang.String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        java.lang.String strTrim = str.trim();
        int iIndexOf = strTrim.toLowerCase().indexOf("://");
        int iIndexOf2 = strTrim.toLowerCase().indexOf(46);
        if (iIndexOf <= 0 || iIndexOf2 <= 0 || iIndexOf <= iIndexOf2) {
            return strTrim.toLowerCase().contains("://");
        }
        return false;
    }

    public static boolean b(android.content.Context context) {
        return a(context).f906a != -1;
    }

    public static boolean c(android.content.Context context) {
        boolean z;
        com.tencent.smtt.sdk.a.c.a aVarA = a(context);
        try {
            z = java.lang.Long.valueOf(aVarA.d).longValue() >= 6001500;
        } catch (java.lang.NumberFormatException e) {
            e.printStackTrace();
        }
        if (aVarA.b >= 601500) {
            return true;
        }
        return z;
    }

    private static int d(android.content.Context context) {
        java.lang.String str = context.getApplicationInfo().processName;
        if (str.equals("com.tencent.mobileqq")) {
            return 13;
        }
        if (str.equals("com.qzone")) {
            return 14;
        }
        if (str.equals("com.tencent.WBlog")) {
            return 15;
        }
        return str.equals("com.tencent.mm") ? 24 : 26;
    }
}
