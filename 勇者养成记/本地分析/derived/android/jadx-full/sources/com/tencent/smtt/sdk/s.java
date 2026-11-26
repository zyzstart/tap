package com.tencent.smtt.sdk;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.content.Context f949a;
    private android.content.Context b;
    private java.lang.String c;
    private java.lang.String[] d;
    private com.tencent.smtt.export.external.DexLoader e;
    private java.lang.String f;
    private java.lang.String g = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public s(android.content.Context context, android.content.Context context2, java.lang.String str, java.lang.String str2, java.lang.String[] strArr, java.lang.String str3) throws java.lang.Exception {
        boolean tbsCoreSandboxModeEnable;
        boolean zEquals;
        this.f949a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = "TbsDexOpt";
        com.tencent.smtt.utils.TbsLog.i("TbsWizard", "construction start...");
        if (context == null || ((context2 == null && com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() == null) || android.text.TextUtils.isEmpty(str) || strArr == null || strArr.length == 0)) {
            throw new java.lang.Exception("TbsWizard paramter error:-1callerContext:" + context + "hostcontext" + context2 + "isEmpty" + android.text.TextUtils.isEmpty(str) + "dexfileList" + strArr);
        }
        this.f949a = context.getApplicationContext();
        if (context2.getApplicationContext() != null) {
            this.b = context2.getApplicationContext();
        } else {
            this.b = context2;
        }
        this.c = str;
        this.d = strArr;
        this.f = str2;
        for (int i = 0; i < this.d.length; i++) {
            com.tencent.smtt.utils.TbsLog.i("TbsWizard", "#2 mDexFileList[" + i + "]: " + this.d[i]);
        }
        com.tencent.smtt.utils.TbsLog.i("TbsWizard", "new DexLoader #2 libraryPath is " + str3 + " mCallerAppContext is " + this.f949a + " dexOutPutDir is " + str2);
        this.e = new com.tencent.smtt.export.external.DexLoader(str3, this.f949a, this.d, str2, com.tencent.smtt.sdk.QbSdk.n);
        java.lang.System.currentTimeMillis();
        a(context);
        com.tencent.smtt.export.external.libwebp.loadWepLibraryIfNeed(context2, this.c);
        if ("com.nd.android.pandahome2".equals(this.f949a.getApplicationInfo().packageName)) {
            this.e.invokeStaticMethod("com.tencent.tbs.common.beacon.X5CoreBeaconUploader", "getInstance", new java.lang.Class[]{android.content.Context.class}, this.f949a);
        }
        if (com.tencent.smtt.sdk.QbSdk.n != null) {
            try {
                tbsCoreSandboxModeEnable = com.tencent.smtt.sdk.TbsPVConfig.getInstance(this.f949a).getTbsCoreSandboxModeEnable();
            } catch (java.lang.Throwable unused) {
                tbsCoreSandboxModeEnable = false;
            }
            try {
                zEquals = com.tencent.ysdk.shell.framework.config.Config.VALUE_SWITCH_ON.equals(java.lang.String.valueOf(com.tencent.smtt.sdk.QbSdk.n.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX)));
            } catch (java.lang.Throwable th) {
                th.printStackTrace();
                zEquals = false;
            }
            com.tencent.smtt.sdk.QbSdk.n.put(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_USE_SANDBOX, java.lang.Boolean.valueOf(tbsCoreSandboxModeEnable && zEquals));
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new java.lang.Class[]{java.util.Map.class}, com.tencent.smtt.sdk.QbSdk.n);
        }
        int iB = b(context);
        if (iB >= 0) {
            com.tencent.smtt.utils.TbsLog.i("TbsWizard", "construction end...");
            return;
        }
        throw new java.lang.Exception("TbsWizard init error: " + iB + "; msg: " + this.g);
    }

    private int b(android.content.Context context) {
        java.lang.Object objInvokeStaticMethod;
        int iIntValue;
        java.lang.String str;
        if (this.b != null || com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined() == null) {
            com.tencent.smtt.utils.TbsLog.i("TbsWizard", "initTesRuntimeEnvironment callerContext is " + context + " mHostContext is " + this.b + " mDexLoader is " + this.e + " mtbsInstallLocation is " + this.c + " mDexOptPath is " + this.f);
            com.tencent.smtt.export.external.DexLoader dexLoader = this.e;
            objInvokeStaticMethod = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new java.lang.Class[]{android.content.Context.class, android.content.Context.class, com.tencent.smtt.export.external.DexLoader.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.TYPE, java.lang.String.class}, context, this.b, dexLoader, this.c, this.f, com.tencent.smtt.sdk.TbsConfig.TBS_SDK_VERSIONNAME, 43903, com.tencent.smtt.sdk.QbSdk.a());
        } else {
            com.tencent.smtt.export.external.DexLoader dexLoader2 = this.e;
            objInvokeStaticMethod = dexLoader2.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new java.lang.Class[]{android.content.Context.class, android.content.Context.class, com.tencent.smtt.export.external.DexLoader.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.TYPE, java.lang.String.class, java.lang.String.class}, context, this.b, dexLoader2, this.c, this.f, com.tencent.smtt.sdk.TbsConfig.TBS_SDK_VERSIONNAME, 43903, com.tencent.smtt.sdk.QbSdk.a(), com.tencent.smtt.sdk.TbsShareManager.getHostCorePathAppDefined());
        }
        if (objInvokeStaticMethod == null) {
            c();
            d();
            com.tencent.smtt.export.external.DexLoader dexLoader3 = this.e;
            objInvokeStaticMethod = dexLoader3.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTesRuntimeEnvironment", new java.lang.Class[]{android.content.Context.class, android.content.Context.class, com.tencent.smtt.export.external.DexLoader.class, java.lang.String.class, java.lang.String.class}, context, this.b, dexLoader3, this.c, this.f);
        }
        if (objInvokeStaticMethod == null) {
            iIntValue = -3;
        } else if (objInvokeStaticMethod instanceof java.lang.Integer) {
            iIntValue = ((java.lang.Integer) objInvokeStaticMethod).intValue();
        } else if (objInvokeStaticMethod instanceof java.lang.Throwable) {
            com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance().a(this.f949a, com.tencent.smtt.sdk.TbsListener.ErrorCode.THROWABLE_INITTESRUNTIMEENVIRONMENT, (java.lang.Throwable) objInvokeStaticMethod);
            iIntValue = -5;
        } else {
            iIntValue = -4;
        }
        if (iIntValue < 0) {
            java.lang.Object objInvokeStaticMethod2 = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new java.lang.Class[0], new java.lang.Object[0]);
            if (objInvokeStaticMethod2 instanceof java.lang.Throwable) {
                java.lang.Throwable th = (java.lang.Throwable) objInvokeStaticMethod2;
                this.g = "#" + th.getMessage() + "; cause: " + th.getCause() + "; th: " + th;
            }
            str = objInvokeStaticMethod2 instanceof java.lang.String ? (java.lang.String) objInvokeStaticMethod2 : null;
            return iIntValue;
        }
        this.g = str;
        return iIntValue;
    }

    private void c() {
        this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "setTesSdkVersionName", new java.lang.Class[]{java.lang.String.class}, com.tencent.smtt.sdk.TbsConfig.TBS_SDK_VERSIONNAME);
    }

    private void d() {
        this.e.setStaticField("com.tencent.tbs.tbsshell.TBSShell", "VERSION", 43903);
    }

    public java.lang.String a() {
        java.lang.String str = null;
        java.lang.Object objInvokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "invokeStaticMethod", new java.lang.Class[]{java.lang.Boolean.TYPE, java.lang.String.class, java.lang.String.class, java.lang.Class[].class, java.lang.Object[].class}, java.lang.Boolean.TRUE, "com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new java.lang.Object[0]);
        if (objInvokeStaticMethod == null) {
            objInvokeStaticMethod = this.e.invokeStaticMethod("com.tencent.smtt.util.CrashTracker", "getCrashExtraInfo", null, new java.lang.Object[0]);
        }
        if (objInvokeStaticMethod != null) {
            str = java.lang.String.valueOf(objInvokeStaticMethod) + " ReaderPackName=" + com.tencent.smtt.sdk.TbsReaderView.gReaderPackName + " ReaderPackVersion=" + com.tencent.smtt.sdk.TbsReaderView.gReaderPackVersion;
        }
        return str == null ? "X5 core get nothing..." : str;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0015  */
    void a(android.content.Context context) {
        boolean zBooleanValue;
        java.util.Map map = com.tencent.smtt.sdk.QbSdk.n;
        if (map != null) {
            java.lang.Object obj = map.get(com.tencent.smtt.export.external.TbsCoreSettings.TBS_SETTINGS_CHECK_TBS_VALIDITY);
            if (obj instanceof java.lang.Boolean) {
                zBooleanValue = ((java.lang.Boolean) obj).booleanValue();
            } else {
                zBooleanValue = true;
            }
        } else {
            zBooleanValue = true;
        }
        if (zBooleanValue) {
            com.tencent.smtt.utils.m.b(context);
        }
    }

    public void a(android.content.Context context, android.content.Context context2, java.lang.String str, java.lang.String str2, java.lang.String[] strArr, java.lang.String str3) throws java.lang.Exception {
        this.f949a = context.getApplicationContext();
        if (this.b.getApplicationContext() != null) {
            this.b = this.b.getApplicationContext();
        }
        this.c = str;
        this.d = strArr;
        this.f = str2;
        com.tencent.smtt.export.external.libwebp.loadWepLibraryIfNeed(context2, str);
        java.util.Map map = com.tencent.smtt.sdk.QbSdk.n;
        if (map != null) {
            this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "initTbsSettings", new java.lang.Class[]{java.util.Map.class}, map);
        }
        int iB = b(context);
        if (iB >= 0) {
            return;
        }
        throw new java.lang.Exception("continueInit init error: " + iB + "; msg: " + this.g);
    }

    public boolean a(android.content.Context context, java.lang.String str, java.lang.String str2, android.os.Bundle bundle) {
        java.lang.Object objInvokeStaticMethod = this.e.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "installLocalQbApk", new java.lang.Class[]{android.content.Context.class, java.lang.String.class, java.lang.String.class, android.os.Bundle.class}, context, str, str2, bundle);
        if (objInvokeStaticMethod == null) {
            return false;
        }
        return ((java.lang.Boolean) objInvokeStaticMethod).booleanValue();
    }

    public com.tencent.smtt.export.external.DexLoader b() {
        return this.e;
    }
}
