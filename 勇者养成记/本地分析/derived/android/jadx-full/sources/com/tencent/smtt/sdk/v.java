package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.smtt.export.external.DexLoader f952a;

    public v(com.tencent.smtt.export.external.DexLoader dexLoader) {
        this.f952a = dexLoader;
    }

    public int a(android.content.Context context, java.lang.String str, java.util.Map map, java.lang.String str2, android.webkit.ValueCallback valueCallback) {
        if (com.tencent.smtt.sdk.TbsDownloader.getOverSea(context)) {
            return -103;
        }
        if (str2 != null) {
            java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.lang.String.class}, context, str, str2);
            return objInvokeStaticMethod == null ? com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT_LOAD : ((java.lang.Integer) objInvokeStaticMethod).intValue();
        }
        java.lang.Object objInvokeStaticMethod2 = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.util.Map.class, android.webkit.ValueCallback.class}, context, str, map, valueCallback);
        if (objInvokeStaticMethod2 == null) {
            objInvokeStaticMethod2 = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.util.Map.class}, context, str, map);
        }
        if (objInvokeStaticMethod2 == null) {
            objInvokeStaticMethod2 = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new java.lang.Class[]{android.content.Context.class, java.lang.String.class}, context, str);
        }
        return objInvokeStaticMethod2 == null ? com.tencent.safecloud.device.openlib.DeviceConfig.ERR_INIT_LOAD : ((java.lang.Integer) objInvokeStaticMethod2).intValue();
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0072 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:30:0x0073 A[RETURN] */
    public com.tencent.smtt.export.external.interfaces.IX5WebViewBase a(android.content.Context context) {
        com.tencent.smtt.export.external.interfaces.IX5WebViewBase iX5WebViewBase;
        com.tencent.smtt.sdk.TbsCoreLoadStat tbsCoreLoadStat;
        java.lang.Throwable th;
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new java.lang.Class[]{android.content.Context.class}, context);
        try {
            if (objInvokeStaticMethod != null) {
                iX5WebViewBase = (com.tencent.smtt.export.external.interfaces.IX5WebViewBase) objInvokeStaticMethod;
                if (iX5WebViewBase != null) {
                    try {
                        if (iX5WebViewBase.getView() == null) {
                            tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                            th = new java.lang.Throwable("x5webview.getView is null!");
                        }
                    } catch (java.lang.Exception e) {
                        e = e;
                        e.printStackTrace();
                    }
                }
                if (objInvokeStaticMethod == null) {
                    return null;
                }
                return iX5WebViewBase;
            }
            java.lang.Object objInvokeStaticMethod2 = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new java.lang.Class[0], new java.lang.Object[0]);
            if (objInvokeStaticMethod2 != null && (objInvokeStaticMethod2 instanceof java.lang.Throwable)) {
                com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITX5CORE, (java.lang.Throwable) objInvokeStaticMethod2);
            }
            if (objInvokeStaticMethod2 == null || !(objInvokeStaticMethod2 instanceof java.lang.String)) {
                iX5WebViewBase = null;
            } else {
                tbsCoreLoadStat = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
                th = new java.lang.Throwable((java.lang.String) objInvokeStaticMethod2);
                iX5WebViewBase = null;
            }
            objInvokeStaticMethod = null;
            if (objInvokeStaticMethod == null) {
                return null;
            }
            return iX5WebViewBase;
            tbsCoreLoadStat.a(context, com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITX5CORE, th);
            objInvokeStaticMethod = null;
        } catch (java.lang.Exception e2) {
            e = e2;
            iX5WebViewBase = null;
        }
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return iX5WebViewBase;
    }

    public java.io.InputStream a(java.lang.String str, boolean z) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new java.lang.Class[]{java.lang.String.class, java.lang.Boolean.TYPE}, str, java.lang.Boolean.valueOf(z));
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.io.InputStream) objInvokeStaticMethod;
    }

    public java.lang.String a(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public java.lang.String a(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilComposeSearchUrl", new java.lang.Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class}, str, str2, str3);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public void a(android.content.Context context, boolean z) {
        com.tencent.smtt.utils.TbsLog.w(com.tencent.ysdk.framework.common.ePlatform.PLATFORM_STR_NONE, " tbsWizard clearAllX5Cache");
        if (z) {
            this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new java.lang.Class[]{android.content.Context.class}, context);
            return;
        }
        try {
            this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "clearAllCache", new java.lang.Class[]{android.content.Context.class, java.lang.Boolean.TYPE}, context, java.lang.Boolean.valueOf(z));
        } catch (java.lang.Exception unused) {
            this.f952a.invokeStaticMethod("[REDACTED]", "[REDACTED]", new java.lang.Class[]{android.content.Context.class}, context);
            this.f952a.invokeStaticMethod("[REDACTED]", "[REDACTED]", new java.lang.Class[]{android.content.Context.class}, context);
            this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new java.lang.Class[]{android.content.Context.class}, context);
            this.f952a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "removeAllCacheFiles", null, new java.lang.Object[0]);
            this.f952a.invokeStaticMethod("com.tencent.smtt.webkit.CacheManager", "clearLocalStorage", null, new java.lang.Object[0]);
            java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.smtt.net.http.DnsManager", "getInstance", null, new java.lang.Object[0]);
            if (objInvokeStaticMethod != null) {
                this.f952a.invokeMethod(objInvokeStaticMethod, "com.tencent.smtt.net.http.DnsManager", "removeAllDns", null, new java.lang.Object[0]);
            }
            java.lang.Object objInvokeStaticMethod2 = this.f952a.invokeStaticMethod("com.tencent.smtt.webkit.SmttPermanentPermissions", "getInstance", null, new java.lang.Object[0]);
            if (objInvokeStaticMethod2 != null) {
                this.f952a.invokeMethod(objInvokeStaticMethod2, "com.tencent.smtt.webkit.SmttPermanentPermissions", "clearAllPermanentPermission", null, new java.lang.Object[0]);
            }
            this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new java.lang.Object[0]);
        }
    }

    public void a(android.webkit.ValueCallback valueCallback) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new java.lang.Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    public void a(java.lang.String str, long j) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new java.lang.Class[]{java.lang.String.class, java.lang.Long.TYPE}, str, java.lang.Long.valueOf(j));
    }

    public void a(java.lang.String str, android.webkit.ValueCallback valueCallback) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new java.lang.Class[]{java.lang.String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void a(java.lang.String str, com.tencent.smtt.export.external.interfaces.IconListener iconListener) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new java.lang.Class[]{java.lang.String.class, com.tencent.smtt.export.external.interfaces.IconListener.class}, str, iconListener);
    }

    public void a(boolean z) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webview_setWebContentsDebuggingEnabled", new java.lang.Class[]{java.lang.Boolean.TYPE}, java.lang.Boolean.valueOf(z));
    }

    public boolean a() {
        java.lang.reflect.Method method = this.f952a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new java.lang.Class[0]);
        method.setAccessible(true);
        java.lang.Object objInvoke = method.invoke(null, new java.lang.Object[0]);
        return objInvoke instanceof java.lang.Boolean ? ((java.lang.Boolean) objInvoke).booleanValue() : ((java.lang.Boolean) objInvoke).booleanValue();
    }

    public boolean a(android.content.Context context, java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new java.lang.Class[]{android.content.Context.class, java.lang.String.class}, context, str);
        if (objInvokeStaticMethod instanceof java.lang.Boolean) {
            return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
        }
        return false;
    }

    public boolean a(java.util.Map map) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new java.lang.Class[]{java.util.Map.class}, map);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public byte[] a(byte[] bArr) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilDecode", new java.lang.Class[]{java.lang.String.class}, bArr);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (byte[]) objInvokeStaticMethod;
    }

    public android.net.Uri[] a(int i, android.content.Intent intent) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new java.lang.Class[]{java.lang.Integer.TYPE, android.content.Intent.class}, java.lang.Integer.valueOf(i), intent);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (android.net.Uri[]) objInvokeStaticMethod;
    }

    public com.tencent.smtt.export.external.DexLoader b() {
        return this.f952a;
    }

    public java.lang.String b(java.lang.String str, java.lang.String str2, java.lang.String str3) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessFileName", new java.lang.Class[]{java.lang.String.class, java.lang.String.class, java.lang.String.class}, str, str2, str3);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public void b(android.webkit.ValueCallback valueCallback) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetOrigins", new java.lang.Class[]{android.webkit.ValueCallback.class}, valueCallback);
    }

    public void b(java.lang.String str) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new java.lang.Class[]{java.lang.String.class}, str);
    }

    public void b(java.lang.String str, android.webkit.ValueCallback valueCallback) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new java.lang.Class[]{java.lang.String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public boolean b(android.content.Context context) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("[REDACTED]", "[REDACTED]", new java.lang.Class[]{android.content.Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public java.lang.Object c() {
        return this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public void c(android.content.Context context) {
        this.f952a.invokeStaticMethod("[REDACTED]", "[REDACTED]", new java.lang.Class[]{android.content.Context.class}, context);
    }

    public void c(java.lang.String str) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new java.lang.Class[]{java.lang.String.class}, str);
    }

    public void c(java.lang.String str, android.webkit.ValueCallback valueCallback) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsGetAllowed", new java.lang.Class[]{java.lang.String.class, android.webkit.ValueCallback.class}, str, valueCallback);
    }

    public void d(java.lang.String str) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new java.lang.Class[]{java.lang.String.class}, str);
    }

    public boolean d() {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new java.lang.Class[0], new java.lang.Object[0]);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean d(android.content.Context context) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("[REDACTED]", "[REDACTED]", new java.lang.Class[]{android.content.Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public void e() {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public void e(android.content.Context context) {
        this.f952a.invokeStaticMethod("[REDACTED]", "[REDACTED]", new java.lang.Class[]{android.content.Context.class}, context);
    }

    public void e(java.lang.String str) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new java.lang.Class[]{java.lang.String.class}, str);
    }

    public java.lang.String f() {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new java.lang.Class[0], new java.lang.Object[0]);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public void f(java.lang.String str) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClear", new java.lang.Class[]{java.lang.String.class}, str);
    }

    public boolean f(android.content.Context context) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new java.lang.Class[]{android.content.Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public java.lang.Object g() {
        return this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public void g(android.content.Context context) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new java.lang.Class[]{android.content.Context.class}, context);
    }

    public void g(java.lang.String str) {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsAllow", new java.lang.Class[]{java.lang.String.class}, str);
    }

    public com.tencent.smtt.export.external.interfaces.IX5DateSorter h(android.content.Context context) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDateSorter", new java.lang.Class[]{android.content.Context.class}, context);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (com.tencent.smtt.export.external.interfaces.IX5DateSorter) objInvokeStaticMethod;
    }

    public java.lang.String h(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetFileExtensionFromUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public boolean h() {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new java.lang.Class[0], new java.lang.Object[0]);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public com.tencent.smtt.export.external.interfaces.IX5WebChromeClient i() {
        java.lang.Object objInvokeStaticMethod;
        com.tencent.smtt.export.external.DexLoader dexLoader = this.f952a;
        if (dexLoader == null || (objInvokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new java.lang.Class[0], new java.lang.Object[0])) == null) {
            return null;
        }
        return (com.tencent.smtt.export.external.interfaces.IX5WebChromeClient) objInvokeStaticMethod;
    }

    public java.lang.String i(android.content.Context context) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getDefaultUserAgent", new java.lang.Class[]{android.content.Context.class}, context);
        if (objInvokeStaticMethod instanceof java.lang.String) {
            return (java.lang.String) objInvokeStaticMethod;
        }
        return null;
    }

    public boolean i(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasMimeType", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public com.tencent.smtt.export.external.interfaces.IX5WebViewClient j() {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new java.lang.Class[0], new java.lang.Object[0]);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (com.tencent.smtt.export.external.interfaces.IX5WebViewClient) objInvokeStaticMethod;
    }

    public java.lang.String j(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension k() {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new java.lang.Class[0], new java.lang.Object[0]);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension) objInvokeStaticMethod;
    }

    public boolean k(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapHasExtension", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public java.lang.String l(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "mimeTypeMapGetMimeTypeFromExtension", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public void l() {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new java.lang.Object[0]);
    }

    public java.lang.String m(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilGuessUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }

    public void m() {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new java.lang.Object[0]);
    }

    public void n() {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new java.lang.Object[0]);
    }

    public boolean n(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAssetUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public void o() {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "geolocationPermissionsClearAll", null, new java.lang.Object[0]);
    }

    public boolean o(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsCookielessProxyUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public void p() {
        this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new java.lang.Class[0], new java.lang.Object[0]);
    }

    public boolean p(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsFileUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController q() {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getServiceWorkerController", new java.lang.Class[0], new java.lang.Object[0]);
        if (objInvokeStaticMethod instanceof com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController) {
            return (com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController) objInvokeStaticMethod;
        }
        return null;
    }

    public boolean q(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsAboutUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean r(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsDataUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean s(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsJavaScriptUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean t(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean u(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsHttpsUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean v(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsNetworkUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean w(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsContentUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public boolean x(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilIsValidUrl", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public java.lang.String y(java.lang.String str) {
        java.lang.Object objInvokeStaticMethod = this.f952a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "urlUtilStripAnchor", new java.lang.Class[]{java.lang.String.class}, str);
        if (objInvokeStaticMethod == null) {
            return null;
        }
        return (java.lang.String) objInvokeStaticMethod;
    }
}
