package com.tencent.midas.plugin;

/* JADX INFO: loaded from: D:\VibeCoding\勇者养成记\本地分析\unpacked\classes.dex */
public class APPluginProxyActivity extends android.app.Activity {
    private static final java.lang.String TAG = "APPluginProxyActivity";
    private static java.lang.String gPluginApkFilePath = null;
    protected static java.lang.String gPluginName = "MidasPay";
    public static boolean mAppForground = true;
    private static java.lang.reflect.Field sMMapField;
    private static java.lang.reflect.Method sUnparcelMethod;
    private java.lang.String mLaunchActivity = null;
    private com.tencent.midas.plugin.IAPPluginActivity mPluginActivity = null;
    private java.lang.String mPluginApkFilePath = null;
    private java.lang.String mPluginName = null;
    protected int mStopFlag = 0;
    protected java.lang.String mCreateErrorInfo = null;

    private java.lang.String initPlugin() {
        android.content.pm.PackageInfo packageInfo = (android.content.pm.PackageInfo) com.tencent.midas.plugin.APPluginStatic.sPackageInfoMap.get(this.mPluginApkFilePath);
        if (packageInfo == null) {
            packageInfo = com.tencent.midas.plugin.APApkFileParser.getPackageInfo(this, this.mPluginApkFilePath, 1);
            if (packageInfo == null) {
                return "Get Package Info Failed!";
            }
            com.tencent.midas.plugin.APPluginStatic.sPackageInfoMap.put(this.mPluginApkFilePath, packageInfo);
        }
        android.content.pm.PackageInfo packageInfo2 = packageInfo;
        java.lang.String str = this.mLaunchActivity;
        if (str == null || str.length() == 0) {
            android.content.pm.ActivityInfo[] activityInfoArr = packageInfo2.activities;
            if (activityInfoArr == null || activityInfoArr.length == 0) {
                return "Activity Not Found!";
            }
            this.mLaunchActivity = activityInfoArr[0].name;
        }
        dalvik.system.DexClassLoader orCreateClassLoaderByPath = com.tencent.midas.plugin.APPluginLoader.getOrCreateClassLoaderByPath(this, this.mPluginName, this.mPluginApkFilePath);
        getIntent().setExtrasClassLoader(orCreateClassLoaderByPath);
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = (com.tencent.midas.plugin.IAPPluginActivity) orCreateClassLoaderByPath.loadClass(this.mLaunchActivity).newInstance();
        this.mPluginActivity = iAPPluginActivity;
        iAPPluginActivity.IInit(this.mPluginName, this.mPluginApkFilePath, this, orCreateClassLoaderByPath, packageInfo2);
        this.mPluginActivity.ISetIntent(getIntent());
        return null;
    }

    public static boolean isMoveTaskToBack(android.content.Context context, android.content.Intent intent) {
        return intent.getComponent() == null || !intent.getComponent().getPackageName().equals(context.getPackageName());
    }

    private boolean isStart3rdApp(android.content.Intent intent) {
        java.lang.String action = intent.getAction();
        if (!android.text.TextUtils.isEmpty(action) && action.equals("android.media.action.IMAGE_CAPTURE")) {
            return true;
        }
        if (!android.text.TextUtils.isEmpty(action) && action.equals("android.intent.action.GET_CONTENT")) {
            return true;
        }
        android.content.ComponentName component = intent.getComponent();
        if (component == null) {
            return false;
        }
        java.lang.String packageName = component.getPackageName();
        if (!android.text.TextUtils.isEmpty(packageName) && packageName.equals("com.tencent.midas.pay")) {
            return true;
        }
        java.lang.String className = component.getClassName();
        return !android.text.TextUtils.isEmpty(className) && className.equals("com.qzone");
    }

    private void logStartPluginErrInfo(java.lang.String str) {
        if (!str.contains("permission") && !str.contains("filenotfoundexception")) {
            if (str.contains("resources$notfoundexception") || str.contains("resourcesnotfoundexception")) {
                return;
            }
            str.contains("classnotfoundexception");
            return;
        }
        com.tencent.midas.comm.APLog.i("logStartPluginErrInfo", "mPluginApkFilePath" + this.mPluginApkFilePath);
        android.content.pm.ApplicationInfo applicationInfo = getApplicationInfo();
        if (applicationInfo != null) {
            com.tencent.midas.comm.APLog.d("", "UID: " + applicationInfo.uid + ", IsSystemApp: " + ((applicationInfo.flags & 1) > 0) + ", IsUpdateSystemApp: " + ((applicationInfo.flags & 128) > 0));
        }
    }

    public static void openActivityForResult(android.app.Activity activity, java.lang.String str, java.lang.String str2, java.lang.String str3, android.content.Intent intent, int i) {
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult pluginName：" + str);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult contextActivity：" + activity);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult apkFilePath：" + str2);
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + intent.getClass().getSimpleName());
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + intent.getClass().getCanonicalName());
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult startIntent：" + intent.getClass().getClassLoader());
        gPluginName = str;
        try {
            gPluginApkFilePath = com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(activity, str).getCanonicalPath();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        intent.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_NAME, str);
        intent.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_LAUNCH_ACTIVITY, str3);
        intent.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_PATH, str2);
        com.tencent.midas.comm.APLog.e("APPLuginProxyActivity", "put is new process: " + com.tencent.midas.control.APMidasPayHelper.isNewProcess);
        com.tencent.midas.comm.APLog.e("APPLuginProxyActivity", "put is log enable: " + com.tencent.midas.control.APMidasPayHelper.isLogEnable());
        intent.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_IS_NEW_PROCESS, com.tencent.midas.control.APMidasPayHelper.isNewProcess);
        intent.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_LOG_ENABLE, com.tencent.midas.control.APMidasPayHelper.isLogEnable());
        try {
            activity.startActivityForResult(intent, i);
        } catch (java.lang.Throwable th) {
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity openActivityForResult Throwable:" + th.toString());
        }
    }

    private static void setClassLoaderToEveryBundle(android.os.Bundle bundle, java.lang.ClassLoader classLoader) throws java.lang.IllegalAccessException, java.lang.NoSuchFieldException, java.lang.NoSuchMethodException, java.lang.reflect.InvocationTargetException {
        if (bundle == null) {
            return;
        }
        bundle.setClassLoader(classLoader);
        if (sUnparcelMethod == null || sMMapField == null) {
            java.lang.Class<?> cls = bundle.getClass();
            java.lang.reflect.Method declaredMethod = cls.getDeclaredMethod("unparcel", new java.lang.Class[0]);
            sUnparcelMethod = declaredMethod;
            declaredMethod.setAccessible(true);
            java.lang.reflect.Field declaredField = cls.getDeclaredField("mMap");
            sMMapField = declaredField;
            declaredField.setAccessible(true);
        }
        sUnparcelMethod.invoke(bundle, new java.lang.Object[0]);
        java.util.Map map = (java.util.Map) sMMapField.get(bundle);
        if (map != null) {
            for (java.lang.Object obj : map.values()) {
                if (obj instanceof android.os.Bundle) {
                    setClassLoaderToEveryBundle((android.os.Bundle) obj, classLoader);
                }
            }
        }
    }

    private void startPluginActivityForResult(android.app.Activity activity, java.lang.String str, android.content.Intent intent, int i) {
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity startPluginActivityForResult.private");
        android.content.Intent intent2 = new android.content.Intent(activity, (java.lang.Class<?>) getProxyActivity(str));
        intent2.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_NAME, this.mPluginName);
        intent2.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_PATH, this.mPluginApkFilePath);
        intent2.putExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_LAUNCH_ACTIVITY, str);
        if (intent != null) {
            intent2.addFlags(intent.getFlags());
            intent2.putExtras(intent);
        }
        activity.startActivityForResult(intent2, i);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(android.view.MotionEvent motionEvent) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        return iAPPluginActivity != null ? iAPPluginActivity.IDispatchTouchEvent(motionEvent) : super.dispatchTouchEvent(motionEvent);
    }

    protected java.lang.Class getProxyActivity(java.lang.String str) {
        return getClass();
    }

    protected boolean isWrapContent() {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            return iAPPluginActivity.IIsWrapContent();
        }
        return true;
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, android.content.Intent intent) {
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "onActivityResult requestCode:" + i + " resultCode:" + i2 + " mPluginActivity:" + this.mPluginActivity);
        super.onActivityResult(i, i2, intent);
        if (this.mPluginActivity != null) {
            try {
                java.lang.ClassLoader classLoader = com.tencent.midas.plugin.APPluginLoader.getClassLoader(this.mPluginName, com.tencent.midas.plugin.APPluginUtils.getMD5FromPath(com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath()));
                if (classLoader != null && intent != null) {
                    intent.setExtrasClassLoader(classLoader);
                }
                this.mPluginActivity.IOnActivityResult(i, i2, intent);
            } catch (java.lang.Exception e) {
                com.tencent.midas.comm.APLog.w("APPLuginProxyActivity onActivityResult", e.toString());
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        try {
            super.onBackPressed();
        } catch (java.lang.IllegalStateException unused) {
            finish();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(android.content.res.Configuration configuration) {
        super.onConfigurationChanged(configuration);
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            try {
                iAPPluginActivity.IOnConfigurationChanged(configuration);
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onCreate(android.os.Bundle bundle) {
        android.os.Bundle extras;
        boolean z;
        boolean z2;
        java.lang.String exceptionInfo;
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate gPluginName:" + gPluginName + " gPluginApkFilePath1:" + gPluginApkFilePath);
        if (android.text.TextUtils.isEmpty(gPluginName)) {
            super.onCreate(bundle);
            com.tencent.midas.comm.APLog.w("APPLuginProxyActivity", "gPluginName is null");
        } else {
            java.lang.ClassLoader classLoader = com.tencent.midas.plugin.APPluginLoader.getClassLoader(gPluginName, com.tencent.midas.plugin.APPluginUtils.getMD5FromPath(com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPathString(this, gPluginName)));
            if (bundle != null && classLoader != null) {
                com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate savedInstanceState=" + bundle + ", classLoader=" + classLoader);
                bundle.setClassLoader(classLoader);
            }
            android.content.Intent intent = getIntent();
            if (bundle != null) {
                extras = bundle;
            } else {
                if (classLoader != null) {
                    intent.setExtrasClassLoader(classLoader);
                }
                extras = getIntent().getExtras();
            }
            boolean z3 = false;
            try {
                this.mPluginName = extras.getString(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_NAME);
                this.mLaunchActivity = extras.getString(com.tencent.midas.plugin.APPluginStatic.PARAM_LAUNCH_ACTIVITY);
                this.mPluginApkFilePath = extras.getString(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_PATH);
                z2 = extras.getBoolean(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_IS_NEW_PROCESS);
                try {
                    com.tencent.midas.comm.APLog.e("APPLuginProxyActivity", "is new process: " + z2);
                    z = extras.getBoolean(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_LOG_ENABLE);
                    try {
                        com.tencent.midas.comm.APLog.e("APPLuginProxyActivity", "is log enable: " + z);
                    } catch (java.lang.Exception e) {
                        e = e;
                        com.tencent.midas.comm.APLog.w("APPLuginProxyActivity", "bundle exception:" + e.toString());
                        e.printStackTrace();
                        finish();
                        com.tencent.midas.plugin.APPluginStatic.removeAll();
                    }
                } catch (java.lang.Exception e2) {
                    e = e2;
                    z = true;
                }
            } catch (java.lang.Exception e3) {
                e = e3;
                z = true;
                z2 = false;
            }
            com.tencent.midas.comm.APLogUtil.initAPLogIfNewProcess(this, z2, z);
            com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onCreate mPluginName：" + this.mPluginName + ", mLaunchActivity：" + this.mLaunchActivity + ", mPluginApkFilePath：" + this.mPluginApkFilePath);
            if (android.text.TextUtils.isEmpty(this.mPluginApkFilePath)) {
                try {
                    this.mPluginApkFilePath = com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath();
                } catch (java.lang.Exception unused) {
                }
            }
            if (!android.text.TextUtils.isEmpty(this.mLaunchActivity)) {
                java.lang.String str = this.mPluginName;
                if (str == null || str.length() == 0) {
                    exceptionInfo = "Param mPluingLocation missing!";
                } else {
                    try {
                        exceptionInfo = initPlugin();
                        if (exceptionInfo == null) {
                            if (android.os.Build.VERSION.SDK_INT >= 11) {
                                getLayoutInflater().setFactory2(new com.tencent.midas.plugin.APLayoutInflaterFactory());
                            }
                            super.onCreate(bundle);
                            try {
                                this.mPluginActivity.IOnCreate(bundle);
                                z3 = true;
                            } catch (java.lang.Exception e4) {
                                e = e4;
                                z3 = true;
                                com.tencent.midas.comm.APLog.e("Midas", "APPluginProxyActivity onCreate:" + e.toString());
                                e.printStackTrace();
                                exceptionInfo = com.tencent.midas.plugin.APPluginUtils.getExceptionInfo(e);
                            }
                        }
                    } catch (java.lang.Exception e5) {
                        e = e5;
                    }
                }
                if (!z3) {
                    super.onCreate(bundle);
                }
                if (exceptionInfo != null) {
                    this.mCreateErrorInfo = exceptionInfo;
                    com.tencent.midas.comm.APLog.e("Midas", "APPluginProxyActivity onCreate activity failed:" + exceptionInfo);
                    logStartPluginErrInfo(this.mCreateErrorInfo);
                    if (shouldHandleStartPluginFailed(this.mCreateErrorInfo)) {
                        return;
                    }
                    com.tencent.midas.data.APPluginReportManager.getInstance().insertData(com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_TIMENAME_LAUNCHPAY, com.tencent.midas.data.APPluginReportManager.MIDASPLUGIN_FORMAT_APKLOAD_FAIL, this.mPluginName, exceptionInfo);
                    com.tencent.midas.plugin.APPluginUtils.showLaunchPluginFail(this, exceptionInfo, true);
                    finish();
                    com.tencent.midas.plugin.APPluginStatic.removeAll();
                    return;
                }
                return;
            }
            com.tencent.midas.comm.APLog.e("Midas", "APPluginProxyActivity onCreate mLaunchActivity is null");
            super.onCreate(bundle);
        }
        finish();
        com.tencent.midas.plugin.APPluginStatic.removeAll();
    }

    @Override // android.app.Activity
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        return iAPPluginActivity != null ? iAPPluginActivity.IOnCreateOptionsMenu(menu) : super.onCreateOptionsMenu(menu);
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        com.tencent.midas.comm.APLog.i(TAG, "onDestroy mPluginActivity:" + this.mPluginActivity);
        com.tencent.midas.comm.APLogUtil.flushIfNewProcess();
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            try {
                iAPPluginActivity.IOnDestroy();
            } catch (java.lang.Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, android.view.KeyEvent keyEvent) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        boolean zIOnKeyDown = iAPPluginActivity != null ? iAPPluginActivity.IOnKeyDown(i, keyEvent) : false;
        return !zIOnKeyDown ? super.onKeyDown(i, keyEvent) : zIOnKeyDown;
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean onMenuItemSelected(int i, android.view.MenuItem menuItem) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        return iAPPluginActivity != null ? iAPPluginActivity.IOnMenuItemSelected(i, menuItem) : super.onMenuItemSelected(i, menuItem);
    }

    @Override // android.app.Activity
    public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
        java.lang.ClassLoader classLoader = com.tencent.midas.plugin.APPluginLoader.getClassLoader(this.mPluginName, com.tencent.midas.plugin.APPluginUtils.getMD5FromPath(com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName)));
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "APPluginProxyActivity onNewIntent mPluginName:" + this.mPluginName + " classLoader: " + classLoader);
        if (classLoader != null) {
            intent.setExtrasClassLoader(classLoader);
        }
        if (this.mPluginActivity == null || !intent.getBooleanExtra(com.tencent.midas.plugin.APPluginStatic.PARAM_CLEAR_TOP, false)) {
            return;
        }
        this.mPluginActivity.IOnNewIntent(intent);
    }

    @Override // android.app.Activity
    public boolean onOptionsItemSelected(android.view.MenuItem menuItem) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        return iAPPluginActivity != null ? iAPPluginActivity.IOnOptionsItemSelected(menuItem) : super.onOptionsItemSelected(menuItem);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnPause();
        }
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(android.view.Menu menu) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        return iAPPluginActivity != null ? iAPPluginActivity.IOnPrepareOptionsMenu(menu) : super.onPrepareOptionsMenu(menu);
    }

    @Override // android.app.Activity
    public void onRequestPermissionsResult(int i, java.lang.String[] strArr, int[] iArr) {
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "onRequestPermissionsResult requestCode:" + i + " permissions:" + strArr + " grantResults:" + iArr);
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (this.mPluginActivity != null) {
            try {
                com.tencent.midas.plugin.APPluginLoader.getClassLoader(this.mPluginName, com.tencent.midas.plugin.APPluginUtils.getMD5FromPath(com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPath(this, this.mPluginName).getCanonicalPath()));
                this.mPluginActivity.IOnRequestPermissionsResult(i, strArr, iArr);
            } catch (java.lang.Exception e) {
                com.tencent.midas.comm.APLog.w("APPLuginProxyActivity onRequestPermissionsResult", e.toString());
                e.printStackTrace();
            }
        }
    }

    @Override // android.app.Activity
    protected void onRestoreInstanceState(android.os.Bundle bundle) {
        java.lang.ClassLoader classLoader = com.tencent.midas.plugin.APPluginLoader.getClassLoader(this.mPluginName, com.tencent.midas.plugin.APPluginUtils.getMD5FromPath(com.tencent.midas.plugin.APPluginInstallerAndUpdater.getInstallPathString(this, this.mPluginName)));
        if (classLoader != null) {
            try {
                setClassLoaderToEveryBundle(bundle, classLoader);
            } catch (java.lang.Exception unused) {
            }
        }
        super.onRestoreInstanceState(bundle);
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnRestoreInstanceState(bundle);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnResume();
        }
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(android.os.Bundle bundle) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnSaveInstanceState(bundle);
        }
        bundle.putString(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_NAME, this.mPluginName);
        bundle.putString(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_LOCATION, this.mPluginName);
        bundle.putString(com.tencent.midas.plugin.APPluginStatic.PARAM_PLUGIN_PATH, this.mPluginApkFilePath);
        bundle.putString(com.tencent.midas.plugin.APPluginStatic.PARAM_LAUNCH_ACTIVITY, this.mLaunchActivity);
        super.onSaveInstanceState(bundle);
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnStart();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        super.onStop();
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnStop();
        }
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(android.view.MotionEvent motionEvent) {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        return iAPPluginActivity != null ? iAPPluginActivity.IOnTouchEvent(motionEvent) : super.onTouchEvent(motionEvent);
    }

    @Override // android.app.Activity
    public void onUserInteraction() {
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnUserInteraction();
        } else {
            super.onUserInteraction();
        }
    }

    @Override // android.app.Activity
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        com.tencent.midas.plugin.IAPPluginActivity iAPPluginActivity = this.mPluginActivity;
        if (iAPPluginActivity != null) {
            iAPPluginActivity.IOnWindowFocusChanged(z);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int i) {
        com.tencent.midas.comm.APLog.i(TAG, "setRequestedOrientation requestedOrientation:" + i);
        super.setRequestedOrientation(i);
    }

    protected boolean shouldHandleStartPluginFailed(java.lang.String str) {
        if (!str.contains("permission") && !str.contains("filenotfoundexception") && !str.contains("resources$notfoundexception") && !str.contains("resourcesnotfoundexception")) {
            return false;
        }
        showNeedUninstanllAndInstallDialog();
        return true;
    }

    protected void showNeedUninstanllAndInstallDialog() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setTitle("温馨提示");
        builder.setMessage("系统繁忙" + this.mPluginName + "失败，请卸载重装~");
        builder.setPositiveButton("我知道了", new android.content.DialogInterface.OnClickListener() { // from class: com.tencent.midas.plugin.APPluginProxyActivity.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(android.content.DialogInterface dialogInterface, int i) {
                com.tencent.midas.plugin.APPluginProxyActivity.this.finish();
            }
        });
        try {
            builder.create().show();
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.app.Activity
    public void startActivityForResult(android.content.Intent intent, int i) {
        if (intent.getBooleanExtra("pluginsdk_IsPluginActivity", false)) {
            android.content.ComponentName component = intent.getComponent();
            java.lang.String className = component != null ? component.getClassName() : null;
            intent.putExtra("pluginsdk_IsPluginActivity", false);
            if (className != null && className.length() > 0) {
                startPluginActivityForResult(this, className, intent, i);
            }
        } else {
            super.startActivityForResult(intent, i);
        }
        this.mStopFlag = 2;
    }

    public void startActivityForResult(android.content.Intent intent, int i, int i2) {
        com.tencent.midas.comm.APLog.i("APPLuginProxyActivity", "startActivityForResult.public");
        this.mStopFlag = 2;
        isStart3rdApp(intent);
        if (!isMoveTaskToBack(this, intent)) {
            intent.addFlags(262144);
        }
        super.startActivityForResult(intent, i);
    }
}
