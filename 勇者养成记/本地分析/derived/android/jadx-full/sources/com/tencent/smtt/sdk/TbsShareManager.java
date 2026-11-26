package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class TbsShareManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static android.content.Context f876a = null;
    private static boolean b = false;
    private static java.lang.String c = null;
    private static java.lang.String d = null;
    private static int e = 0;
    private static java.lang.String f = null;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static java.lang.String j = null;
    private static boolean k = false;
    private static boolean l = false;
    public static boolean mHasQueryed = false;

    static int a(android.content.Context context, boolean z) {
        b(context, z);
        return e;
    }

    static java.lang.String a() {
        return d;
    }

    static void a(android.content.Context context) {
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "shareTbsCore #1");
        try {
            com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni = new com.tencent.smtt.sdk.TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, com.tencent.smtt.sdk.m.a().q(context));
            java.io.File fileR = com.tencent.smtt.sdk.m.a().r(context);
            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + fileR.getAbsolutePath());
            tbsLinuxToolsJni.a(fileR.getAbsolutePath(), "755");
        } catch (java.lang.Throwable th) {
            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + th.getMessage() + " ## " + th.getCause());
            th.printStackTrace();
        }
    }

    private static void a(android.content.Context context, int i2) {
        java.io.File backupDecoupleCoreFile;
        java.lang.StringBuilder sb;
        java.lang.String str;
        if (com.tencent.smtt.sdk.TbsPVConfig.getInstance(f876a).isDisableHostBackupCore() || !com.tencent.smtt.sdk.m.a().t(context)) {
            return;
        }
        java.lang.String[] strArr = {com.tencent.smtt.sdk.TbsConfig.APP_DEMO, "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", context.getPackageName()};
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + android.util.Log.getStackTraceString(new java.lang.Throwable()));
        for (int i3 = 0; i3 < 5; i3++) {
            java.lang.String str2 = strArr[i3];
            if (i2 == getBackupCoreVersion(context, str2)) {
                if (com.tencent.smtt.sdk.m.a().f(getPackageContext(context, str2, false))) {
                    backupDecoupleCoreFile = getBackupCoreFile(context, str2);
                    if (com.tencent.smtt.utils.a.a(context, backupDecoupleCoreFile, 0L, i2)) {
                        sb = new java.lang.StringBuilder();
                        str = "find host backup core to unzip normal coreVersion is ";
                        sb.append(str);
                        sb.append(i2);
                        sb.append(" packageName is ");
                        sb.append(str2);
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", sb.toString());
                        com.tencent.smtt.sdk.m.a().b(context, backupDecoupleCoreFile, i2);
                        break;
                    }
                } else {
                    continue;
                }
            } else {
                if (i2 == getBackupDecoupleCoreVersion(context, str2) && com.tencent.smtt.sdk.m.a().f(getPackageContext(context, str2, false))) {
                    backupDecoupleCoreFile = getBackupDecoupleCoreFile(context, str2);
                    if (com.tencent.smtt.utils.a.a(context, backupDecoupleCoreFile, 0L, i2)) {
                        sb = new java.lang.StringBuilder();
                        str = "find host backup core to unzip decouple coreVersion is ";
                        sb.append(str);
                        sb.append(i2);
                        sb.append(" packageName is ");
                        sb.append(str2);
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", sb.toString());
                        com.tencent.smtt.sdk.m.a().b(context, backupDecoupleCoreFile, i2);
                        break;
                    }
                }
            }
        }
        com.tencent.smtt.sdk.m.a().b();
    }

    private static void a(android.content.Context context, com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni, java.io.File file) {
        java.lang.String absolutePath;
        java.lang.String str;
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file != null && file.exists() && file.isDirectory()) {
            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + file.getAbsolutePath());
            tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
            for (java.io.File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        absolutePath = file2.getAbsolutePath();
                        str = "755";
                    } else {
                        absolutePath = file2.getAbsolutePath();
                        str = "644";
                    }
                    tbsLinuxToolsJni.a(absolutePath, str);
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    com.tencent.smtt.utils.TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    static void b(android.content.Context context) {
        try {
            a(context, new com.tencent.smtt.sdk.TbsLinuxToolsJni(context), com.tencent.smtt.sdk.m.a().p(context));
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    static boolean b(android.content.Context context, boolean z) {
        if (i(context)) {
            return true;
        }
        if (!z) {
            return false;
        }
        com.tencent.smtt.sdk.QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        return false;
    }

    static java.lang.String c(android.content.Context context) {
        j(context);
        return d;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x0071 A[DONT_GENERATE, EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    private static void c(android.content.Context context, boolean z) {
        java.io.BufferedOutputStream bufferedOutputStream;
        java.io.BufferedInputStream bufferedInputStream;
        try {
            java.io.File tbsShareFile = getTbsShareFile(context, "core_info");
            try {
                try {
                    if (tbsShareFile == null) {
                        return;
                    }
                    bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(tbsShareFile));
                    try {
                        java.util.Properties properties = new java.util.Properties();
                        properties.load(bufferedInputStream);
                        properties.setProperty("core_disabled", java.lang.String.valueOf(false));
                        if (z) {
                            java.lang.String absolutePath = com.tencent.smtt.sdk.m.a().q(context).getAbsolutePath();
                            java.lang.String packageName = context.getApplicationContext().getPackageName();
                            int iB = com.tencent.smtt.utils.b.b(context);
                            properties.setProperty("core_packagename", packageName);
                            properties.setProperty("core_path", absolutePath);
                            properties.setProperty("app_version", java.lang.String.valueOf(iB));
                        }
                        bufferedOutputStream = new java.io.BufferedOutputStream(new java.io.FileOutputStream(tbsShareFile));
                        try {
                            properties.store(bufferedOutputStream, (java.lang.String) null);
                            try {
                                bufferedInputStream.close();
                            } catch (java.lang.Exception unused) {
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        bufferedOutputStream = null;
                    }
                    return;
                    return;
                } catch (java.lang.Exception unused2) {
                    return;
                }
                th.printStackTrace();
            } finally {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Exception unused3) {
                    }
                }
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                    } catch (java.lang.Exception unused4) {
                    }
                }
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
    }

    static int d(android.content.Context context) {
        return a(context, true);
    }

    private static java.lang.String[] d(android.content.Context context, boolean z) {
        if (com.tencent.smtt.sdk.QbSdk.getOnlyDownload()) {
            return new java.lang.String[]{context.getApplicationContext().getPackageName()};
        }
        return z ? new java.lang.String[]{context.getApplicationContext().getPackageName()} : getCoreProviderAppList();
    }

    static android.content.Context e(android.content.Context context) {
        j(context);
        java.lang.String str = f;
        android.content.Context context2 = null;
        if (str != null) {
            android.content.Context packageContext = getPackageContext(context, str, true);
            if (com.tencent.smtt.sdk.m.a().f(packageContext)) {
                context2 = packageContext;
            }
        }
        return c != null ? f876a : context2;
    }

    static synchronized java.lang.String f(android.content.Context context) {
        java.lang.Throwable th;
        java.io.BufferedInputStream bufferedInputStream;
        try {
            java.io.File tbsShareFile = getTbsShareFile(context, "core_info");
            if (tbsShareFile == null) {
                return null;
            }
            bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(tbsShareFile));
            try {
                java.util.Properties properties = new java.util.Properties();
                properties.load(bufferedInputStream);
                java.lang.String property = properties.getProperty("core_packagename", "");
                if ("".equals(property)) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Exception unused) {
                    }
                    return null;
                }
                try {
                    bufferedInputStream.close();
                } catch (java.lang.Exception unused2) {
                }
                return property;
            } catch (java.lang.Throwable th2) {
                th = th2;
            }
        } catch (java.lang.Throwable th3) {
            th = th3;
            bufferedInputStream = null;
        }
        try {
            th.printStackTrace();
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (java.lang.Exception unused3) {
                }
            }
            return null;
        } catch (java.lang.Throwable th4) {
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (java.lang.Exception unused4) {
                }
            }
            throw th4;
        }
    }

    public static int findCoreForThirdPartyApp(android.content.Context context) {
        n(context);
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
        if (f == null) {
            com.tencent.smtt.utils.TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        java.lang.String str = f;
        if (str == null || !str.equals("AppDefined")) {
            if (!k(context) && !l(context)) {
                e = 0;
                d = null;
                f = null;
                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
            }
        } else if (e != com.tencent.smtt.sdk.m.a().a(c)) {
            e = 0;
            d = null;
            f = null;
            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + e + " dest is " + com.tencent.smtt.sdk.m.a().a(c));
        }
        if (e > 0) {
            android.content.pm.ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((!("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || "com.jd.jrapp".equals(applicationInfo.packageName)) ? com.tencent.smtt.sdk.QbSdk.a(context, e) : false) || g) {
                e = 0;
                d = null;
                f = null;
                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        return e;
    }

    public static boolean forceLoadX5FromTBSDemo(android.content.Context context) {
        int sharedTbsCoreVersion;
        if (context == null || com.tencent.smtt.sdk.m.a().a(context, (java.io.File[]) null) || (sharedTbsCoreVersion = getSharedTbsCoreVersion(context, com.tencent.smtt.sdk.TbsConfig.APP_DEMO)) <= 0) {
            return false;
        }
        writeProperties(context, java.lang.Integer.toString(sharedTbsCoreVersion), com.tencent.smtt.sdk.TbsConfig.APP_DEMO, com.tencent.smtt.sdk.m.a().q(getPackageContext(context, com.tencent.smtt.sdk.TbsConfig.APP_DEMO, true)).getAbsolutePath(), "1");
        return true;
    }

    public static void forceToLoadX5ForThirdApp(android.content.Context context, boolean z) {
        java.io.File fileR;
        int iA;
        try {
            if (com.tencent.smtt.sdk.QbSdk.isNeedInitX5FirstTime() && isThirdPartyApp(context) && !com.tencent.smtt.sdk.QbSdk.getOnlyDownload() && (fileR = com.tencent.smtt.sdk.m.a().r(context)) != null) {
                if (z && new java.io.File(fileR, "core_info").exists()) {
                    return;
                }
                if (c != null && (iA = com.tencent.smtt.sdk.m.a().a(c)) > 0) {
                    d = c;
                    f = "AppDefined";
                    e = iA;
                    com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1 -- mAvailableCoreVersion: " + e + " " + android.util.Log.getStackTraceString(new java.lang.Throwable("#")));
                    writeProperties(context, java.lang.Integer.toString(e), f, d, java.lang.Integer.toString(1));
                    return;
                }
                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
                int iH = h(context);
                int i2 = com.tencent.smtt.sdk.m.a().i(context);
                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromConfig is " + iH);
                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromCoreShare is " + i2);
                java.lang.String[] coreProviderAppList = getCoreProviderAppList();
                for (java.lang.String str : coreProviderAppList) {
                    int coreShareDecoupleCoreVersion = getCoreShareDecoupleCoreVersion(context, str);
                    if (coreShareDecoupleCoreVersion >= iH && coreShareDecoupleCoreVersion >= i2 && coreShareDecoupleCoreVersion > 0) {
                        d = com.tencent.smtt.sdk.m.a().c(context, getPackageContext(context, str, true)).getAbsolutePath();
                        f = str;
                        e = coreShareDecoupleCoreVersion;
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2 -- mAvailableCoreVersion: " + e + " " + android.util.Log.getStackTraceString(new java.lang.Throwable("#")));
                        if (com.tencent.smtt.sdk.QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                            int iB = com.tencent.smtt.utils.b.b(context);
                            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
                            writeProperties(context, java.lang.Integer.toString(e), f, d, java.lang.Integer.toString(iB));
                            return;
                        } else {
                            e = 0;
                            d = null;
                            f = null;
                        }
                    }
                }
                for (java.lang.String str2 : coreProviderAppList) {
                    int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str2);
                    if (sharedTbsCoreVersion >= iH && sharedTbsCoreVersion >= i2 && sharedTbsCoreVersion > 0) {
                        d = com.tencent.smtt.sdk.m.a().b(context, getPackageContext(context, str2, true)).getAbsolutePath();
                        f = str2;
                        e = sharedTbsCoreVersion;
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #3 -- mAvailableCoreVersion: " + e + " " + android.util.Log.getStackTraceString(new java.lang.Throwable("#")));
                        if (com.tencent.smtt.sdk.QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                            writeProperties(context, java.lang.Integer.toString(e), f, d, java.lang.Integer.toString(com.tencent.smtt.utils.b.b(context)));
                            return;
                        } else {
                            e = 0;
                            d = null;
                            f = null;
                        }
                    }
                }
                if (com.tencent.smtt.sdk.TbsPVConfig.getInstance(f876a).isDisableHostBackupCore()) {
                    return;
                }
                if (java.lang.Thread.currentThread() == android.os.Looper.getMainLooper().getThread()) {
                    com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "in mainthread so do not find host backup core to install ");
                    return;
                }
                for (java.lang.String str3 : coreProviderAppList) {
                    int backupCoreVersion = getBackupCoreVersion(context, str3);
                    if (backupCoreVersion >= iH && backupCoreVersion >= i2 && backupCoreVersion > 0) {
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "find host backup core to unzip forceload coreVersion is " + backupCoreVersion + " packageName is " + str3);
                        com.tencent.smtt.sdk.m.a().a(context, getBackupCoreFile(context, str3), backupCoreVersion);
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
                        return;
                    }
                    int backupDecoupleCoreVersion = getBackupDecoupleCoreVersion(context, str3);
                    if (backupDecoupleCoreVersion >= iH && backupDecoupleCoreVersion >= i2 && backupDecoupleCoreVersion > 0) {
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "find host backup core to unzip forceload decouple coreVersion is " + backupDecoupleCoreVersion + " packageName is " + str3);
                        com.tencent.smtt.sdk.m.a().a(context, getBackupCoreFile(context, str3), backupDecoupleCoreVersion);
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
                        return;
                    }
                }
            }
        } catch (java.lang.Exception unused) {
        }
    }

    static java.lang.String g(android.content.Context context) {
        try {
            n(context);
            if (d != null && !android.text.TextUtils.isEmpty(d)) {
                return d + java.io.File.separator + "res.apk";
            }
            return null;
        } catch (java.lang.Throwable th) {
            android.util.Log.e("", "getTbsResourcesPath exception: " + android.util.Log.getStackTraceString(th));
            return null;
        }
    }

    public static java.io.File getBackupCoreFile(android.content.Context context, java.lang.String str) {
        try {
            java.io.File file = new java.io.File(new java.io.File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, false), 4)), com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static int getBackupCoreVersion(android.content.Context context, java.lang.String str) {
        try {
            java.io.File file = new java.io.File(new java.io.File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, false), 4)), com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                return com.tencent.smtt.utils.a.b(file);
            }
        } catch (java.lang.Throwable unused) {
        }
        return 0;
    }

    public static java.io.File getBackupDecoupleCoreFile(android.content.Context context, java.lang.String str) {
        try {
            java.io.File file = new java.io.File(new java.io.File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, true), 4)), com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (java.lang.Throwable unused) {
            return null;
        }
    }

    public static int getBackupDecoupleCoreVersion(android.content.Context context, java.lang.String str) {
        try {
            java.io.File file = new java.io.File(new java.io.File(com.tencent.smtt.utils.f.a(getPackageContext(context, str, false), 4)), com.tencent.smtt.sdk.TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                return com.tencent.smtt.utils.a.b(file);
            }
        } catch (java.lang.Throwable unused) {
        }
        return 0;
    }

    public static boolean getCoreDisabled() {
        return g;
    }

    public static boolean getCoreFormOwn() {
        return k;
    }

    public static java.lang.String[] getCoreProviderAppList() {
        return new java.lang.String[]{com.tencent.smtt.sdk.TbsConfig.APP_DEMO, "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", com.tencent.connect.common.Constants.PACKAGE_QQ_SPEED};
    }

    public static int getCoreShareDecoupleCoreVersion(android.content.Context context, java.lang.String str) {
        android.content.Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return com.tencent.smtt.sdk.m.a().h(packageContext);
        }
        return 0;
    }

    public static java.lang.String getHostCorePathAppDefined() {
        return c;
    }

    public static long getHostCoreVersions(android.content.Context context) {
        long sharedTbsCoreVersion;
        long sharedTbsCoreVersion2;
        long j2;
        long j3 = 0;
        for (java.lang.String str : getCoreProviderAppList()) {
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                sharedTbsCoreVersion2 = getSharedTbsCoreVersion(context, str);
                j2 = 10000000000L;
            } else {
                if (str.equalsIgnoreCase("com.tencent.mobileqq")) {
                    sharedTbsCoreVersion2 = getSharedTbsCoreVersion(context, str);
                    j2 = 100000;
                } else if (str.equalsIgnoreCase("com.qzone")) {
                    sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str);
                    j3 += sharedTbsCoreVersion;
                }
            }
            sharedTbsCoreVersion = sharedTbsCoreVersion2 * j2;
            j3 += sharedTbsCoreVersion;
        }
        return j3;
    }

    public static android.content.Context getPackageContext(android.content.Context context, java.lang.String str, boolean z) {
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && com.tencent.smtt.sdk.TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                    com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "gray no core app,skip get context");
                    return null;
                }
            } catch (android.content.pm.PackageManager.NameNotFoundException unused) {
                return null;
            } catch (java.lang.Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return context.createPackageContext(str, 2);
    }

    public static int getSharedTbsCoreVersion(android.content.Context context, java.lang.String str) {
        android.content.Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return com.tencent.smtt.sdk.m.a().i(packageContext);
        }
        return 0;
    }

    public static java.io.File getTbsShareFile(android.content.Context context, java.lang.String str) {
        java.io.File fileR = com.tencent.smtt.sdk.m.a().r(context);
        if (fileR == null) {
            return null;
        }
        java.io.File file = new java.io.File(fileR, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (java.io.IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static synchronized int h(android.content.Context context) {
        try {
            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #1");
            java.io.BufferedInputStream bufferedInputStream = null;
            try {
                java.io.File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #2");
                    return 0;
                }
                java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(tbsShareFile));
                try {
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(bufferedInputStream2);
                    java.lang.String property = properties.getProperty("core_version", "");
                    if ("".equals(property)) {
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #4");
                        try {
                            bufferedInputStream2.close();
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                        return 0;
                    }
                    com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #3");
                    int iMax = java.lang.Math.max(java.lang.Integer.parseInt(property), 0);
                    try {
                        bufferedInputStream2.close();
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                    return iMax;
                } catch (java.lang.Throwable th) {
                    bufferedInputStream = bufferedInputStream2;
                    th = th;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.lang.Exception e4) {
                                e4.printStackTrace();
                            }
                        }
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #5");
                        return -2;
                    } catch (java.lang.Throwable th2) {
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (java.lang.Exception e5) {
                                e5.printStackTrace();
                            }
                        }
                        throw th2;
                    }
                }
                throw th;
            } catch (java.lang.Throwable th3) {
                th = th3;
            }
        } catch (java.lang.Throwable th4) {
            throw th4;
        }
    }

    static boolean i(android.content.Context context) {
        try {
            if (e == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (e == 0) {
                com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new java.lang.Object[0]);
                return false;
            }
            if (c == null) {
                if (e != 0 && getSharedTbsCoreVersion(context, f) == e) {
                    return true;
                }
            } else if (e != 0 && com.tencent.smtt.sdk.m.a().a(c) == e) {
                return true;
            }
            if (l(context)) {
                return true;
            }
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.INFO_CORE_EXIST_NOT_LOAD, new java.lang.Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            d = null;
            e = 0;
            com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new java.lang.Object[0]);
            com.tencent.smtt.sdk.QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            return false;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            com.tencent.smtt.utils.TbsLog.addLog(com.tencent.smtt.utils.TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new java.lang.Object[0]);
            return false;
        }
    }

    public static boolean isThirdPartyApp(android.content.Context context) {
        try {
            if (f876a != null && f876a.equals(context.getApplicationContext())) {
                return b;
            }
            android.content.Context applicationContext = context.getApplicationContext();
            f876a = applicationContext;
            java.lang.String packageName = applicationContext.getPackageName();
            for (java.lang.String str : getCoreProviderAppList()) {
                if (packageName.equals(str)) {
                    b = false;
                    return false;
                }
            }
            b = true;
            return true;
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
        }
    }

    static boolean j(android.content.Context context) {
        return b(context, true);
    }

    private static boolean k(android.content.Context context) {
        java.lang.String str = f;
        if (str == null) {
            return false;
        }
        return e == getSharedTbsCoreVersion(context, str) || e == getCoreShareDecoupleCoreVersion(context, f);
    }

    private static boolean l(android.content.Context context) {
        java.io.File fileC;
        if (com.tencent.smtt.sdk.QbSdk.getOnlyDownload()) {
            return false;
        }
        java.lang.String[] coreProviderAppList = getCoreProviderAppList();
        for (java.lang.String str : coreProviderAppList) {
            int i2 = e;
            if (i2 > 0 && i2 == getSharedTbsCoreVersion(context, str)) {
                android.content.Context packageContext = getPackageContext(context, str, true);
                if (com.tencent.smtt.sdk.m.a().f(context)) {
                    fileC = com.tencent.smtt.sdk.m.a().b(context, packageContext);
                    d = fileC.getAbsolutePath();
                    f = str;
                    return true;
                }
            }
        }
        for (java.lang.String str2 : coreProviderAppList) {
            int i3 = e;
            if (i3 > 0 && i3 == getCoreShareDecoupleCoreVersion(context, str2)) {
                android.content.Context packageContext2 = getPackageContext(context, str2, true);
                if (com.tencent.smtt.sdk.m.a().f(context)) {
                    fileC = com.tencent.smtt.sdk.m.a().c(context, packageContext2);
                    d = fileC.getAbsolutePath();
                    f = str2;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean m(android.content.Context context) {
        if (context == null) {
            return false;
        }
        writeProperties(context, java.lang.Integer.toString(0), "", "", java.lang.Integer.toString(0));
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00e4 A[Catch: Exception -> 0x00d7, all -> 0x00f9, TRY_ENTER, TRY_LEAVE, TryCatch #0 {Exception -> 0x00d7, blocks: (B:40:0x00d3, B:49:0x00e4), top: B:65:0x000f, outer: #2 }] */
    private static void n(android.content.Context context) {
        if (l) {
            return;
        }
        synchronized (com.tencent.smtt.sdk.TbsShareManager.class) {
            if (l) {
                return;
            }
            java.io.BufferedInputStream bufferedInputStream = null;
            try {
                try {
                    try {
                        java.io.File tbsShareFile = getTbsShareFile(context, "core_info");
                        if (tbsShareFile == null) {
                            return;
                        }
                        java.io.BufferedInputStream bufferedInputStream2 = new java.io.BufferedInputStream(new java.io.FileInputStream(tbsShareFile));
                        try {
                            java.util.Properties properties = new java.util.Properties();
                            properties.load(bufferedInputStream2);
                            java.lang.String property = properties.getProperty("core_version", "");
                            if (!"".equals(property)) {
                                e = java.lang.Math.max(java.lang.Integer.parseInt(property), 0);
                                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "loadProperties -- mAvailableCoreVersion: " + e + " " + android.util.Log.getStackTraceString(new java.lang.Throwable("#")));
                            }
                            java.lang.String property2 = properties.getProperty("core_packagename", "");
                            if (!"".equals(property2)) {
                                f = property2;
                            }
                            if (f != null && f876a != null) {
                                if (f.equals(f876a.getPackageName())) {
                                    k = true;
                                } else {
                                    k = false;
                                }
                            }
                            java.lang.String property3 = properties.getProperty("core_path", "");
                            if (!"".equals(property3)) {
                                d = property3;
                            }
                            java.lang.String property4 = properties.getProperty("app_version", "");
                            if (!"".equals(property4)) {
                                j = property4;
                            }
                            g = java.lang.Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                            l = true;
                            bufferedInputStream2.close();
                        } catch (java.lang.Throwable th) {
                            bufferedInputStream = bufferedInputStream2;
                            th = th;
                            th.printStackTrace();
                            if (bufferedInputStream != null) {
                                bufferedInputStream.close();
                            }
                        }
                    } catch (java.lang.Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (java.lang.Throwable th2) {
                    th = th2;
                }
                th.printStackTrace();
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
            } catch (java.lang.Throwable th3) {
                if (bufferedInputStream != null) {
                    try {
                        bufferedInputStream.close();
                    } catch (java.lang.Exception e3) {
                        e3.printStackTrace();
                    }
                }
                throw th3;
            }
        }
    }

    public static void setHostCorePathAppDefined(java.lang.String str) {
        c = str;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x02b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:109:0x02e3 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:133:0x01cb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:134:0x0262 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:136:0x02dd A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x019f A[Catch: all -> 0x02ea, TRY_ENTER, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x001b, B:9:0x002b, B:11:0x0047, B:15:0x0056, B:18:0x005e, B:19:0x0061, B:24:0x0075, B:27:0x0083, B:29:0x00a3, B:32:0x00b1, B:34:0x00bb, B:36:0x00c7, B:43:0x0107, B:46:0x010c, B:48:0x0118, B:50:0x011c, B:52:0x0124, B:55:0x0142, B:64:0x0196, B:68:0x019f, B:70:0x01a3, B:72:0x01ab, B:75:0x01cb, B:77:0x01d9, B:78:0x01fa, B:85:0x0237, B:86:0x023c, B:88:0x0242, B:91:0x0262, B:93:0x0270, B:97:0x029a, B:98:0x029d, B:110:0x02e5, B:56:0x0153, B:58:0x015c, B:61:0x0171, B:37:0x00d6, B:40:0x00e2, B:94:0x028e), top: B:127:0x0003, inners: #0, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01a3 A[Catch: all -> 0x02ea, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x001b, B:9:0x002b, B:11:0x0047, B:15:0x0056, B:18:0x005e, B:19:0x0061, B:24:0x0075, B:27:0x0083, B:29:0x00a3, B:32:0x00b1, B:34:0x00bb, B:36:0x00c7, B:43:0x0107, B:46:0x010c, B:48:0x0118, B:50:0x011c, B:52:0x0124, B:55:0x0142, B:64:0x0196, B:68:0x019f, B:70:0x01a3, B:72:0x01ab, B:75:0x01cb, B:77:0x01d9, B:78:0x01fa, B:85:0x0237, B:86:0x023c, B:88:0x0242, B:91:0x0262, B:93:0x0270, B:97:0x029a, B:98:0x029d, B:110:0x02e5, B:56:0x0153, B:58:0x015c, B:61:0x0171, B:37:0x00d6, B:40:0x00e2, B:94:0x028e), top: B:127:0x0003, inners: #0, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01ab A[Catch: all -> 0x02ea, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x001b, B:9:0x002b, B:11:0x0047, B:15:0x0056, B:18:0x005e, B:19:0x0061, B:24:0x0075, B:27:0x0083, B:29:0x00a3, B:32:0x00b1, B:34:0x00bb, B:36:0x00c7, B:43:0x0107, B:46:0x010c, B:48:0x0118, B:50:0x011c, B:52:0x0124, B:55:0x0142, B:64:0x0196, B:68:0x019f, B:70:0x01a3, B:72:0x01ab, B:75:0x01cb, B:77:0x01d9, B:78:0x01fa, B:85:0x0237, B:86:0x023c, B:88:0x0242, B:91:0x0262, B:93:0x0270, B:97:0x029a, B:98:0x029d, B:110:0x02e5, B:56:0x0153, B:58:0x015c, B:61:0x0171, B:37:0x00d6, B:40:0x00e2, B:94:0x028e), top: B:127:0x0003, inners: #0, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d9 A[Catch: all -> 0x02ea, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x001b, B:9:0x002b, B:11:0x0047, B:15:0x0056, B:18:0x005e, B:19:0x0061, B:24:0x0075, B:27:0x0083, B:29:0x00a3, B:32:0x00b1, B:34:0x00bb, B:36:0x00c7, B:43:0x0107, B:46:0x010c, B:48:0x0118, B:50:0x011c, B:52:0x0124, B:55:0x0142, B:64:0x0196, B:68:0x019f, B:70:0x01a3, B:72:0x01ab, B:75:0x01cb, B:77:0x01d9, B:78:0x01fa, B:85:0x0237, B:86:0x023c, B:88:0x0242, B:91:0x0262, B:93:0x0270, B:97:0x029a, B:98:0x029d, B:110:0x02e5, B:56:0x0153, B:58:0x015c, B:61:0x0171, B:37:0x00d6, B:40:0x00e2, B:94:0x028e), top: B:127:0x0003, inners: #0, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x020f A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:86:0x023c A[Catch: all -> 0x02ea, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x001b, B:9:0x002b, B:11:0x0047, B:15:0x0056, B:18:0x005e, B:19:0x0061, B:24:0x0075, B:27:0x0083, B:29:0x00a3, B:32:0x00b1, B:34:0x00bb, B:36:0x00c7, B:43:0x0107, B:46:0x010c, B:48:0x0118, B:50:0x011c, B:52:0x0124, B:55:0x0142, B:64:0x0196, B:68:0x019f, B:70:0x01a3, B:72:0x01ab, B:75:0x01cb, B:77:0x01d9, B:78:0x01fa, B:85:0x0237, B:86:0x023c, B:88:0x0242, B:91:0x0262, B:93:0x0270, B:97:0x029a, B:98:0x029d, B:110:0x02e5, B:56:0x0153, B:58:0x015c, B:61:0x0171, B:37:0x00d6, B:40:0x00e2, B:94:0x028e), top: B:127:0x0003, inners: #0, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0242 A[Catch: all -> 0x02ea, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x001b, B:9:0x002b, B:11:0x0047, B:15:0x0056, B:18:0x005e, B:19:0x0061, B:24:0x0075, B:27:0x0083, B:29:0x00a3, B:32:0x00b1, B:34:0x00bb, B:36:0x00c7, B:43:0x0107, B:46:0x010c, B:48:0x0118, B:50:0x011c, B:52:0x0124, B:55:0x0142, B:64:0x0196, B:68:0x019f, B:70:0x01a3, B:72:0x01ab, B:75:0x01cb, B:77:0x01d9, B:78:0x01fa, B:85:0x0237, B:86:0x023c, B:88:0x0242, B:91:0x0262, B:93:0x0270, B:97:0x029a, B:98:0x029d, B:110:0x02e5, B:56:0x0153, B:58:0x015c, B:61:0x0171, B:37:0x00d6, B:40:0x00e2, B:94:0x028e), top: B:127:0x0003, inners: #0, #2, #4 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x0260  */
    /* JADX WARN: Code duplicated, block: B:93:0x0270 A[Catch: all -> 0x02ea, TRY_LEAVE, TryCatch #5 {, blocks: (B:4:0x0003, B:6:0x001b, B:9:0x002b, B:11:0x0047, B:15:0x0056, B:18:0x005e, B:19:0x0061, B:24:0x0075, B:27:0x0083, B:29:0x00a3, B:32:0x00b1, B:34:0x00bb, B:36:0x00c7, B:43:0x0107, B:46:0x010c, B:48:0x0118, B:50:0x011c, B:52:0x0124, B:55:0x0142, B:64:0x0196, B:68:0x019f, B:70:0x01a3, B:72:0x01ab, B:75:0x01cb, B:77:0x01d9, B:78:0x01fa, B:85:0x0237, B:86:0x023c, B:88:0x0242, B:91:0x0262, B:93:0x0270, B:97:0x029a, B:98:0x029d, B:110:0x02e5, B:56:0x0153, B:58:0x015c, B:61:0x0171, B:37:0x00d6, B:40:0x00e2, B:94:0x028e), top: B:127:0x0003, inners: #0, #2, #4 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:68:0x019f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:77:0x01d9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:93:0x0270, please report this as an issue */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized void writeCoreInfoForThirdPartyApp(android.content.Context context, int i2, boolean z) {
        int i3;
        android.content.Context packageContext;
        java.lang.String absolutePath;
        int iB;
        java.io.File tbsShareFile;
        android.content.Context packageContext2;
        java.lang.String absolutePath2;
        int iB2;
        java.io.File tbsShareFile2;
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is " + i2);
        if (i2 == 0) {
            m(context);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(f876a).setDownloadInterruptCode(-401);
            return;
        }
        int iH = h(context);
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is " + iH);
        if (iH < 0) {
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(f876a).setDownloadInterruptCode(-402);
            return;
        }
        if (i2 == iH) {
            if (d(context) == 0 && !z) {
                a(context, i2);
            }
            c(context, z);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(f876a).setDownloadInterruptCode(-403);
            return;
        }
        if (i2 < iH) {
            m(context);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(f876a).setDownloadInterruptCode(-404);
            return;
        }
        int i4 = com.tencent.smtt.sdk.m.a().i(context);
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is " + i4);
        if (i2 < i4) {
            m(context);
            com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(f876a).setDownloadInterruptCode(-404);
            return;
        }
        java.lang.String[] strArrD = d(context, z);
        boolean z2 = false;
        if (c == null) {
            for (java.lang.String str : strArrD) {
                if (i2 == getSharedTbsCoreVersion(context, str)) {
                    packageContext2 = getPackageContext(context, str, true);
                    absolutePath2 = com.tencent.smtt.sdk.m.a().q(packageContext2).getAbsolutePath();
                    iB2 = com.tencent.smtt.utils.b.b(context);
                    if (com.tencent.smtt.sdk.m.a().f(packageContext2)) {
                        if (!str.equals(context.getApplicationContext().getPackageName())) {
                            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                            com.tencent.smtt.sdk.k.a(f876a).a("remove_old_core", 1);
                        }
                        writeProperties(context, java.lang.Integer.toString(i2), str, absolutePath2, java.lang.Integer.toString(iB2));
                        try {
                            tbsShareFile2 = getTbsShareFile(context, "core_info");
                            if (!i && tbsShareFile2 != null) {
                                com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                                tbsLinuxToolsJni.a(tbsShareFile2.getAbsolutePath(), "644");
                                tbsLinuxToolsJni.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                                i = true;
                            }
                        } catch (java.lang.Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                        z2 = true;
                        break;
                    }
                } else {
                    if (i2 == getCoreShareDecoupleCoreVersion(context, str)) {
                        packageContext = getPackageContext(context, str, true);
                        absolutePath = com.tencent.smtt.sdk.m.a().p(packageContext).getAbsolutePath();
                        iB = com.tencent.smtt.utils.b.b(context);
                        if (com.tencent.smtt.sdk.m.a().f(packageContext)) {
                            if (!str.equals(context.getApplicationContext().getPackageName())) {
                                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                                try {
                                    com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().q(context));
                                    com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                } catch (java.lang.Throwable th2) {
                                    th2.printStackTrace();
                                }
                            }
                            writeProperties(context, java.lang.Integer.toString(i2), str, absolutePath, java.lang.Integer.toString(iB));
                            try {
                                tbsShareFile = getTbsShareFile(context, "core_info");
                                if (!i && tbsShareFile != null) {
                                    com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni2 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                                    tbsLinuxToolsJni2.a(tbsShareFile.getAbsolutePath(), "644");
                                    tbsLinuxToolsJni2.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                                    i = true;
                                }
                            } catch (java.lang.Throwable th3) {
                                th = th3;
                                th.printStackTrace();
                            }
                            z2 = true;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (!z2 && !z) {
                a(context, i2);
            }
            return;
        }
        if (i2 == com.tencent.smtt.sdk.m.a().a(c)) {
            writeProperties(context, java.lang.Integer.toString(i2), "AppDefined", c, java.lang.Integer.toString(1));
            try {
                java.io.File tbsShareFile3 = getTbsShareFile(context, "core_info");
                if (!i && tbsShareFile3 != null) {
                    com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni3 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                    tbsLinuxToolsJni3.a(tbsShareFile3.getAbsolutePath(), "644");
                    tbsLinuxToolsJni3.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                    i = true;
                }
            } catch (java.lang.Throwable th4) {
                th4.printStackTrace();
            }
            return;
        }
        if (i2 <= com.tencent.smtt.sdk.m.a().a(c)) {
            while (i3 < r2) {
                if (i2 == getSharedTbsCoreVersion(context, str)) {
                    packageContext2 = getPackageContext(context, str, true);
                    absolutePath2 = com.tencent.smtt.sdk.m.a().q(packageContext2).getAbsolutePath();
                    iB2 = com.tencent.smtt.utils.b.b(context);
                    if (com.tencent.smtt.sdk.m.a().f(packageContext2)) {
                        if (!str.equals(context.getApplicationContext().getPackageName())) {
                            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                            com.tencent.smtt.sdk.k.a(f876a).a("remove_old_core", 1);
                        }
                        writeProperties(context, java.lang.Integer.toString(i2), str, absolutePath2, java.lang.Integer.toString(iB2));
                        tbsShareFile2 = getTbsShareFile(context, "core_info");
                        if (!i) {
                            com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni4 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                            tbsLinuxToolsJni4.a(tbsShareFile2.getAbsolutePath(), "644");
                            tbsLinuxToolsJni4.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                            i = true;
                        }
                        z2 = true;
                        break;
                    }
                } else {
                    if (i2 == getCoreShareDecoupleCoreVersion(context, str)) {
                        packageContext = getPackageContext(context, str, true);
                        absolutePath = com.tencent.smtt.sdk.m.a().p(packageContext).getAbsolutePath();
                        iB = com.tencent.smtt.utils.b.b(context);
                        if (com.tencent.smtt.sdk.m.a().f(packageContext)) {
                            if (!str.equals(context.getApplicationContext().getPackageName())) {
                                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                                com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().q(context));
                                com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                            }
                            writeProperties(context, java.lang.Integer.toString(i2), str, absolutePath, java.lang.Integer.toString(iB));
                            tbsShareFile = getTbsShareFile(context, "core_info");
                            if (!i) {
                                com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni5 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                                tbsLinuxToolsJni5.a(tbsShareFile.getAbsolutePath(), "644");
                                tbsLinuxToolsJni5.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                                i = true;
                            }
                            z2 = true;
                            break;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (!z2) {
                a(context, i2);
            }
            return;
        }
        for (java.lang.String str2 : strArrD) {
            if (i2 == getSharedTbsCoreVersion(context, str2)) {
                android.content.Context packageContext3 = getPackageContext(context, str2, true);
                java.lang.String absolutePath3 = com.tencent.smtt.sdk.m.a().q(packageContext3).getAbsolutePath();
                com.tencent.smtt.utils.b.b(context);
                if (com.tencent.smtt.sdk.m.a().f(packageContext3)) {
                    try {
                        com.tencent.smtt.utils.f.a(new java.io.File(absolutePath3), new java.io.File(c), new java.io.FileFilter() { // from class: com.tencent.smtt.sdk.TbsShareManager.1
                            @Override // java.io.FileFilter
                            public boolean accept(java.io.File file) {
                                return !file.getName().endsWith(".dex");
                            }
                        });
                        writeProperties(context, java.lang.Integer.toString(i2), "AppDefined", c, java.lang.Integer.toString(1));
                        java.io.File tbsShareFile4 = getTbsShareFile(context, "core_info");
                        if (!i && tbsShareFile4 != null) {
                            com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni6 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                            tbsLinuxToolsJni6.a(tbsShareFile4.getAbsolutePath(), "644");
                            tbsLinuxToolsJni6.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                            i = true;
                        }
                    } catch (java.lang.Throwable th5) {
                        th5.printStackTrace();
                    }
                    return;
                }
            }
        }
        while (i3 < r2) {
            if (i2 == getSharedTbsCoreVersion(context, str)) {
                packageContext2 = getPackageContext(context, str, true);
                absolutePath2 = com.tencent.smtt.sdk.m.a().q(packageContext2).getAbsolutePath();
                iB2 = com.tencent.smtt.utils.b.b(context);
                if (com.tencent.smtt.sdk.m.a().f(packageContext2)) {
                    if (!str.equals(context.getApplicationContext().getPackageName())) {
                        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                        com.tencent.smtt.sdk.k.a(f876a).a("remove_old_core", 1);
                    }
                    writeProperties(context, java.lang.Integer.toString(i2), str, absolutePath2, java.lang.Integer.toString(iB2));
                    tbsShareFile2 = getTbsShareFile(context, "core_info");
                    if (!i) {
                        com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni7 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                        tbsLinuxToolsJni7.a(tbsShareFile2.getAbsolutePath(), "644");
                        tbsLinuxToolsJni7.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                        i = true;
                    }
                    z2 = true;
                    break;
                }
            } else {
                if (i2 == getCoreShareDecoupleCoreVersion(context, str)) {
                    packageContext = getPackageContext(context, str, true);
                    absolutePath = com.tencent.smtt.sdk.m.a().p(packageContext).getAbsolutePath();
                    iB = com.tencent.smtt.utils.b.b(context);
                    if (com.tencent.smtt.sdk.m.a().f(packageContext)) {
                        if (!str.equals(context.getApplicationContext().getPackageName())) {
                            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + i2);
                            com.tencent.smtt.utils.f.b(com.tencent.smtt.sdk.m.a().q(context));
                            com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                        }
                        writeProperties(context, java.lang.Integer.toString(i2), str, absolutePath, java.lang.Integer.toString(iB));
                        tbsShareFile = getTbsShareFile(context, "core_info");
                        if (!i) {
                            com.tencent.smtt.sdk.TbsLinuxToolsJni tbsLinuxToolsJni8 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(f876a);
                            tbsLinuxToolsJni8.a(tbsShareFile.getAbsolutePath(), "644");
                            tbsLinuxToolsJni8.a(com.tencent.smtt.sdk.m.a().r(context).getAbsolutePath(), "755");
                            i = true;
                        }
                        z2 = true;
                        break;
                    }
                } else {
                    continue;
                }
            }
        }
        if (!z2) {
            a(context, i2);
        }
        return;
        throw th;
    }

    public static void writeProperties(android.content.Context context, java.lang.String str, java.lang.String str2, java.lang.String str3, java.lang.String str4) {
        java.lang.Throwable th;
        java.io.BufferedInputStream bufferedInputStream;
        int i2;
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        java.lang.StringBuilder sb = new java.lang.StringBuilder();
        sb.append("writeProperties -- stack: ");
        sb.append(android.util.Log.getStackTraceString(new java.lang.Throwable("#")));
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", sb.toString());
        java.io.BufferedOutputStream bufferedOutputStream = null;
        try {
            try {
                java.io.File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(f876a).setDownloadInterruptCode(-405);
                    return;
                }
                bufferedInputStream = new java.io.BufferedInputStream(new java.io.FileInputStream(tbsShareFile));
                try {
                    java.util.Properties properties = new java.util.Properties();
                    properties.load(bufferedInputStream);
                    try {
                        i2 = java.lang.Integer.parseInt(str);
                    } catch (java.lang.Exception unused) {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        properties.setProperty("core_version", str);
                        properties.setProperty("core_disabled", java.lang.String.valueOf(false));
                        properties.setProperty("core_packagename", str2);
                        properties.setProperty("core_path", str3);
                        properties.setProperty("app_version", str4);
                    } else {
                        properties.setProperty("core_disabled", java.lang.String.valueOf(true));
                    }
                    java.io.BufferedOutputStream bufferedOutputStream2 = new java.io.BufferedOutputStream(new java.io.FileOutputStream(tbsShareFile));
                    try {
                        properties.store(bufferedOutputStream2, (java.lang.String) null);
                        l = false;
                        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(f876a).setDownloadInterruptCode(-406);
                        try {
                            bufferedInputStream.close();
                        } catch (java.lang.Exception e2) {
                            e2.printStackTrace();
                        }
                        bufferedOutputStream2.close();
                    } catch (java.lang.Throwable th2) {
                        th = th2;
                        bufferedOutputStream = bufferedOutputStream2;
                        try {
                            th.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.lang.Exception e3) {
                                    e3.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream == null) {
                            }
                        } finally {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (java.lang.Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (java.lang.Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                    }
                } catch (java.lang.Throwable th3) {
                    th = th3;
                }
            } catch (java.lang.Throwable th4) {
                th = th4;
                bufferedInputStream = null;
            }
        } catch (java.lang.Exception e6) {
        }
    }
}
