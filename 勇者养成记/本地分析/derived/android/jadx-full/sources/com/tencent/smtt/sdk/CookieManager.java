package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class CookieManager {
    public static java.lang.String LOGTAG = "CookieManager";
    private static com.tencent.smtt.sdk.CookieManager d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    java.util.concurrent.CopyOnWriteArrayList f802a;
    java.lang.String b;
    com.tencent.smtt.sdk.CookieManager.a c = com.tencent.smtt.sdk.CookieManager.a.MODE_NONE;
    private boolean e = false;
    private boolean f = false;

    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f804a;
        java.lang.String b;
        java.lang.String c;
        com.tencent.smtt.sdk.ValueCallback d;

        b() {
        }
    }

    private CookieManager() {
    }

    public static com.tencent.smtt.sdk.CookieManager getInstance() {
        if (d == null) {
            synchronized (com.tencent.smtt.sdk.CookieManager.class) {
                if (d == null) {
                    d = new com.tencent.smtt.sdk.CookieManager();
                }
            }
        }
        return d;
    }

    public static int getROMCookieDBVersion(android.content.Context context) {
        java.lang.String str;
        int i;
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            str = "cookiedb_info";
            i = 4;
        } else {
            str = "cookiedb_info";
            i = 0;
        }
        return context.getSharedPreferences(str, i).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(android.content.Context context, int i) {
        java.lang.String str;
        int i2;
        if (android.os.Build.VERSION.SDK_INT >= 11) {
            str = "cookiedb_info";
            i2 = 4;
        } else {
            str = "cookiedb_info";
            i2 = 0;
        }
        android.content.SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, i2).edit();
        editorEdit.putInt("db_version", i);
        editorEdit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void a() {
        this.f = true;
        java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = this.f802a;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
            if (uVarA == null || !uVarA.b()) {
                for (com.tencent.smtt.sdk.CookieManager.b bVar : this.f802a) {
                    int i = bVar.f804a;
                    if (i != 1) {
                        if (i == 2) {
                            android.webkit.CookieManager.getInstance().setCookie(bVar.b, bVar.c);
                        }
                    } else if (android.os.Build.VERSION.SDK_INT >= 21) {
                        com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setCookie", new java.lang.Class[]{java.lang.String.class, java.lang.String.class, android.webkit.ValueCallback.class}, bVar.b, bVar.c, bVar.d);
                    }
                }
            } else {
                for (com.tencent.smtt.sdk.CookieManager.b bVar2 : this.f802a) {
                    int i2 = bVar2.f804a;
                    if (i2 == 1) {
                        setCookie(bVar2.b, bVar2.c, bVar2.d);
                    } else if (i2 == 2) {
                        setCookie(bVar2.b, bVar2.c);
                    }
                }
            }
            this.f802a.clear();
        }
    }

    /* JADX WARN: Code duplicated, block: B:51:0x00ea A[PHI: r6
  0x00ea: PHI (r6v12 int) = (r6v11 int), (r6v11 int), (r6v11 int), (r6v14 int) binds: [B:46:0x00d3, B:48:0x00e3, B:69:0x00ea, B:41:0x00c5] A[DONT_GENERATE, DONT_INLINE]] */
    protected synchronized void a(android.content.Context context, boolean z, boolean z2) {
        int iD;
        int rOMCookieDBVersion;
        if (this.c != com.tencent.smtt.sdk.CookieManager.a.MODE_NONE && context != null && com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().canUseFunction(context, com.tencent.smtt.sdk.TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME) && !this.e) {
            long jCurrentTimeMillis = java.lang.System.currentTimeMillis();
            long jCurrentTimeMillis2 = 0;
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "compatiableCookieDatabaseIfNeed,isX5Inited:" + z + ",useX5:" + z2);
            if (!z && !com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter() && !com.tencent.smtt.sdk.QbSdk.f818a) {
                com.tencent.smtt.sdk.u.a().a(context);
                return;
            }
            boolean z3 = false;
            if (com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter() || com.tencent.smtt.sdk.QbSdk.f818a) {
                z2 = false;
            }
            boolean zCanUseFunction = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().canUseFunction(context, com.tencent.smtt.sdk.TbsExtensionFunctionManager.USEX5_FILE_NAME);
            com.tencent.smtt.utils.TbsLog.i(LOGTAG, "usex5 : mUseX5LastProcess->" + zCanUseFunction + ",useX5:" + z2);
            com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().setFunctionEnable(context, com.tencent.smtt.sdk.TbsExtensionFunctionManager.USEX5_FILE_NAME, z2);
            if (zCanUseFunction == z2) {
                return;
            }
            com.tencent.smtt.sdk.TbsLogReport.TbsLogInfo tbsLogInfo = com.tencent.smtt.sdk.TbsLogReport.getInstance(context).tbsLogInfo();
            if (android.text.TextUtils.isEmpty(this.b)) {
                tbsLogInfo.setErrorCode(701);
                iD = 0;
                rOMCookieDBVersion = 0;
            } else {
                if (com.tencent.smtt.sdk.m.a().i(context) > 0 && com.tencent.smtt.sdk.m.a().i(context) < 36001) {
                    return;
                }
                if (zCanUseFunction) {
                    iD = com.tencent.smtt.sdk.h.d(context);
                    if (iD > 0) {
                        rOMCookieDBVersion = getROMCookieDBVersion(context);
                        if (rOMCookieDBVersion <= 0) {
                            z3 = true;
                        }
                    } else {
                        rOMCookieDBVersion = 0;
                    }
                } else {
                    iD = com.tencent.smtt.sdk.h.d(context);
                    if (iD > 0) {
                        java.lang.String strD = com.tencent.smtt.sdk.m.a().d(context, "cookies_database_version");
                        if (android.text.TextUtils.isEmpty(strD)) {
                            rOMCookieDBVersion = 0;
                        } else {
                            try {
                                rOMCookieDBVersion = java.lang.Integer.parseInt(strD);
                            } catch (java.lang.Exception unused) {
                                rOMCookieDBVersion = 0;
                            }
                        }
                    } else {
                        rOMCookieDBVersion = 0;
                    }
                }
                if (!z3 && (iD <= 0 || rOMCookieDBVersion <= 0)) {
                    tbsLogInfo.setErrorCode(702);
                } else if (rOMCookieDBVersion >= iD) {
                    tbsLogInfo.setErrorCode(703);
                } else {
                    com.tencent.smtt.sdk.h.a(context, this.c, this.b, z3, z2);
                    tbsLogInfo.setErrorCode(704);
                    jCurrentTimeMillis2 = java.lang.System.currentTimeMillis() - jCurrentTimeMillis;
                }
            }
            tbsLogInfo.setFailDetail("x5->sys:" + zCanUseFunction + " from:" + iD + " to:" + rOMCookieDBVersion + ",timeused:" + jCurrentTimeMillis2);
            com.tencent.smtt.sdk.TbsLogReport.getInstance(context).eventReport(com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH, tbsLogInfo);
        }
    }

    public boolean acceptCookie() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.CookieManager.getInstance().acceptCookie() : uVarA.c().d();
    }

    public synchronized boolean acceptThirdPartyCookies(com.tencent.smtt.sdk.WebView webView) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            java.lang.Object objInvokeStaticMethod = uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new java.lang.Class[]{java.lang.Object.class}, webView.getView());
            if (objInvokeStaticMethod == null) {
                return true;
            }
            return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
        }
        if (android.os.Build.VERSION.SDK_INT < 21) {
            return true;
        }
        java.lang.Object objA = com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new java.lang.Class[]{android.webkit.WebView.class}, webView.getView());
        if (objA == null) {
            return false;
        }
        return ((java.lang.Boolean) objA).booleanValue();
    }

    public void flush() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new java.lang.Class[0], new java.lang.Object[0]);
        } else {
            if (android.os.Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "flush", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public java.lang.String getCookie(java.lang.String str) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            return uVarA.c().a(str);
        }
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (java.lang.Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean hasCookies() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        return (uVarA == null || !uVarA.b()) ? android.webkit.CookieManager.getInstance().hasCookies() : uVarA.c().h();
    }

    public void removeAllCookie() {
        java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = this.f802a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            uVarA.c().e();
        }
    }

    public void removeAllCookies(com.tencent.smtt.sdk.ValueCallback valueCallback) {
        java.util.concurrent.CopyOnWriteArrayList copyOnWriteArrayList = this.f802a;
        if (copyOnWriteArrayList != null) {
            copyOnWriteArrayList.clear();
        }
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new java.lang.Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (android.os.Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new java.lang.Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public void removeExpiredCookie() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void removeSessionCookie() {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new java.lang.Class[0], new java.lang.Object[0]);
        }
    }

    public void removeSessionCookies(com.tencent.smtt.sdk.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new java.lang.Class[]{android.webkit.ValueCallback.class}, valueCallback);
        } else {
            if (android.os.Build.VERSION.SDK_INT < 21) {
                return;
            }
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new java.lang.Class[]{android.webkit.ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
            }
        } else {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
        }
    }

    public synchronized void setAcceptThirdPartyCookies(com.tencent.smtt.sdk.WebView webView, boolean z) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA != null && uVarA.b()) {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new java.lang.Class[]{java.lang.Object.class, java.lang.Boolean.TYPE}, webView.getView(), java.lang.Boolean.valueOf(z));
        } else if (android.os.Build.VERSION.SDK_INT < 21) {
        } else {
            com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new java.lang.Class[]{android.webkit.WebView.class, java.lang.Boolean.TYPE}, webView.getView(), java.lang.Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(java.lang.String str, java.lang.String str2) {
        setCookie(str, str2, false);
    }

    public synchronized void setCookie(java.lang.String str, java.lang.String str2, com.tencent.smtt.sdk.ValueCallback valueCallback) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            if (!com.tencent.smtt.sdk.u.a().d()) {
                com.tencent.smtt.sdk.CookieManager.b bVar = new com.tencent.smtt.sdk.CookieManager.b();
                bVar.f804a = 1;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = valueCallback;
                if (this.f802a == null) {
                    this.f802a = new java.util.concurrent.CopyOnWriteArrayList();
                }
                this.f802a.add(bVar);
            }
            if (this.f) {
                if (android.os.Build.VERSION.SDK_INT < 21) {
                } else {
                    com.tencent.smtt.utils.k.a(android.webkit.CookieManager.getInstance(), "setCookie", new java.lang.Class[]{java.lang.String.class, java.lang.String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
                }
            }
        } else {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new java.lang.Class[]{java.lang.String.class, java.lang.String.class, android.webkit.ValueCallback.class}, str, str2, valueCallback);
        }
    }

    public synchronized void setCookie(java.lang.String str, java.lang.String str2, boolean z) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if (uVarA == null || !uVarA.b()) {
            if (this.f || z) {
                android.webkit.CookieManager.getInstance().setCookie(str, str2);
            }
            if (!com.tencent.smtt.sdk.u.a().d()) {
                com.tencent.smtt.sdk.CookieManager.b bVar = new com.tencent.smtt.sdk.CookieManager.b();
                bVar.f804a = 2;
                bVar.b = str;
                bVar.c = str2;
                bVar.d = null;
                if (this.f802a == null) {
                    this.f802a = new java.util.concurrent.CopyOnWriteArrayList();
                }
                this.f802a.add(bVar);
            }
        } else {
            uVarA.c().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookie", new java.lang.Class[]{java.lang.String.class, java.lang.String.class}, str, str2);
        }
    }

    public boolean setCookieCompatialbeMode(android.content.Context context, com.tencent.smtt.sdk.CookieManager.a aVar, java.lang.String str, boolean z) {
        java.lang.System.currentTimeMillis();
        if (context == null || !com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance().canUseFunction(context, com.tencent.smtt.sdk.TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
            return false;
        }
        this.c = aVar;
        if (str != null) {
            this.b = str;
        }
        if (this.c == com.tencent.smtt.sdk.CookieManager.a.MODE_NONE || !z || com.tencent.smtt.sdk.u.a().d()) {
            return true;
        }
        com.tencent.smtt.sdk.u.a().a(context);
        return true;
    }

    public void setCookies(java.util.Map map) {
        com.tencent.smtt.sdk.u uVarA = com.tencent.smtt.sdk.u.a();
        if ((uVarA == null || !uVarA.b()) ? false : uVarA.c().a(map)) {
            return;
        }
        for (java.lang.String str : map.keySet()) {
            for (java.lang.String str2 : (java.lang.String[]) map.get(str)) {
                setCookie(str, str2);
            }
        }
    }
}
